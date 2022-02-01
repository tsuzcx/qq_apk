package com.tencent.mm.plugin.emoji.sync;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.net.TrafficStats;
import android.os.Looper;
import android.os.Process;
import android.os.SystemClock;
import com.tencent.e.h;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.compatible.util.e;
import com.tencent.mm.emoji.sync.EmojiSyncManager;
import com.tencent.mm.plugin.emoji.sync.a.a;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.ak;
import com.tencent.mm.sdk.platformtools.aw;
import com.tencent.mm.sdk.platformtools.aw.a;
import com.tencent.mm.sdk.platformtools.az;
import com.tencent.mm.sdk.platformtools.bu;
import com.tencent.mm.storage.emotion.EmojiInfo;
import com.tencent.mm.vfs.o;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.Vector;
import java.util.concurrent.Executor;

public final class BKGLoaderManager
  implements d
{
  int Mh;
  public boolean cFc;
  int mNetWorkType;
  private int pNd;
  private int pNe;
  private boolean pNf;
  boolean pNg;
  boolean pNh;
  public boolean pNi;
  public boolean pNj;
  private boolean pNk;
  private boolean pNl;
  private c pNm;
  private b pNn;
  private Vector<c> pNo;
  private Vector<c> pNp;
  private Vector<c> pNq;
  private Set<Object> pNr;
  public ConnectivityReceiver pNs;
  long pNt;
  long pNu;
  aw pNv;
  public com.tencent.mm.sdk.b.c pNw;
  public com.tencent.mm.sdk.b.c pNx;
  
  public BKGLoaderManager(b paramb)
  {
    AppMethodBeat.i(108757);
    this.pNd = 0;
    this.pNe = 0;
    this.pNf = false;
    this.pNg = false;
    this.pNh = false;
    this.pNi = false;
    this.pNj = false;
    this.pNk = false;
    this.pNl = false;
    this.cFc = false;
    this.pNm = null;
    this.pNo = new Vector();
    this.pNp = new Vector();
    this.pNq = new Vector();
    this.pNr = new HashSet();
    this.mNetWorkType = -1;
    this.pNt = 0L;
    this.pNu = 0L;
    this.pNv = new aw(Looper.getMainLooper(), new aw.a()
    {
      public final boolean onTimerExpired()
      {
        AppMethodBeat.i(108753);
        long l1;
        long l2;
        if ((BKGLoaderManager.this.pNg) || (BKGLoaderManager.this.pNh) || (BKGLoaderManager.this.pNi))
        {
          l1 = TrafficStats.getUidTxBytes(BKGLoaderManager.this.Mh);
          l2 = TrafficStats.getUidRxBytes(BKGLoaderManager.this.Mh);
          long l3 = l1 - BKGLoaderManager.this.pNt + (l2 - BKGLoaderManager.this.pNu);
          ae.d("MicroMsg.BKGLoader.BKGLoaderManager", "delta of data: " + l3 / 1024L);
          if (l3 > 20480L) {
            break label127;
          }
          BKGLoaderManager.this.ciE();
        }
        for (;;)
        {
          AppMethodBeat.o(108753);
          return false;
          label127:
          BKGLoaderManager.this.pNt = l1;
          BKGLoaderManager.this.pNu = l2;
          BKGLoaderManager.this.pNv.ay(1000L, 1000L);
        }
      }
    }, false);
    this.pNw = new BKGLoaderManager.2(this);
    this.pNx = new BKGLoaderManager.3(this);
    this.pNn = paramb;
    this.Mh = Process.myUid();
    this.mNetWorkType = az.getNetType(ak.getContext());
    AppMethodBeat.o(108757);
  }
  
  static boolean chH()
  {
    AppMethodBeat.i(108768);
    if ((az.is3G(ak.getContext())) || (az.is4G(ak.getContext())) || (az.is2G(ak.getContext())))
    {
      AppMethodBeat.o(108768);
      return true;
    }
    AppMethodBeat.o(108768);
    return false;
  }
  
  public static boolean ciH()
  {
    AppMethodBeat.i(108767);
    long l = SystemClock.uptimeMillis();
    try
    {
      NetworkInfo localNetworkInfo = ((ConnectivityManager)ak.getContext().getSystemService("connectivity")).getNetworkInfo(1);
      if (localNetworkInfo != null)
      {
        boolean bool = localNetworkInfo.isConnected();
        return bool;
      }
      return false;
    }
    finally
    {
      l = SystemClock.uptimeMillis() - l;
      if (l >= 1000L) {
        ae.i("MicroMsg.BKGLoader.BKGLoaderManager", "[isWifi] cost:%s", new Object[] { Long.valueOf(l) });
      }
      AppMethodBeat.o(108767);
    }
  }
  
  public final void acN(String paramString)
  {
    AppMethodBeat.i(108765);
    ae.i("MicroMsg.BKGLoader.BKGLoaderManager", "[cpan] task is ruing. key:%s", new Object[] { paramString });
    AppMethodBeat.o(108765);
  }
  
  public final void cS(List<c> paramList)
  {
    AppMethodBeat.i(108759);
    if (this.pNp == null) {
      this.pNp = new Vector();
    }
    if (paramList.size() > 0)
    {
      int j = paramList.size();
      int i = 0;
      if (i < j)
      {
        c localc = (c)paramList.get(i);
        if ((localc != null) && (!this.pNp.contains(localc))) {
          this.pNp.add(localc);
        }
        for (;;)
        {
          i += 1;
          break;
          ae.i("MicroMsg.BKGLoader.BKGLoaderManager", "[cpan] task is has exist:%s", new Object[] { localc.getKey() });
        }
      }
    }
    AppMethodBeat.o(108759);
  }
  
  public final void cT(List<c> paramList)
  {
    for (;;)
    {
      int i;
      try
      {
        AppMethodBeat.i(108760);
        if (this.pNq == null) {
          this.pNq = new Vector();
        }
        if ((paramList == null) || (paramList.size() <= 0)) {
          break label194;
        }
        int j = paramList.size();
        i = 0;
        if (i >= j) {
          break label194;
        }
        localObject = (c)paramList.get(i);
        if ((this.pNm != null) && (this.pNm.equals(localObject)))
        {
          if (localObject == null)
          {
            localObject = "task is null";
            ae.i("MicroMsg.BKGLoader.BKGLoaderManager", "[cpan] currentTask equals task is has exist:%s", new Object[] { localObject });
          }
          else
          {
            localObject = ((c)localObject).getKey();
            continue;
          }
        }
        else if ((localObject != null) && (!this.pNq.contains(localObject))) {
          this.pNq.add(localObject);
        }
      }
      finally {}
      if (localObject == null) {}
      for (Object localObject = "task is null";; localObject = ((c)localObject).getKey())
      {
        ae.i("MicroMsg.BKGLoader.BKGLoaderManager", "[cpan] task is has exist:%s", new Object[] { localObject });
        break;
      }
      label194:
      AppMethodBeat.o(108760);
      return;
      i += 1;
    }
  }
  
  public final void ciD()
  {
    try
    {
      AppMethodBeat.i(108761);
      if (this.pNo != null) {
        this.pNo.clear();
      }
      if (this.pNp != null) {
        this.pNp.clear();
      }
      if (this.pNq != null) {
        this.pNq.clear();
      }
      this.pNf = false;
      AppMethodBeat.o(108761);
      return;
    }
    finally {}
  }
  
  public final void ciE()
  {
    int i = 0;
    for (;;)
    {
      try
      {
        AppMethodBeat.i(108762);
        if ((az.isWifi(ak.getContext())) || (EmojiSyncManager.agw())) {
          break label666;
        }
        if ((i == 0) && (!this.pNf)) {
          break label602;
        }
        if ((this.pNo != null) && (this.pNo.size() > 0))
        {
          this.pNl = e.abp();
          this.pNg = true;
          this.pNh = false;
          this.pNj = false;
          this.pNi = false;
          if (!this.pNl)
          {
            this.pNm = ((c)this.pNo.remove(0));
            this.pNm.a(this);
            this.pNn.pNb.execute(this.pNm);
            ae.i("MicroMsg.BKGLoader.BKGLoaderManager", "[cpan] tryToStart task is ruing. key:%s donwload list size:%d", new Object[] { this.pNm.getKey(), Integer.valueOf(this.pNo.size()) });
            ciG();
            if ((this.pNh) || (this.pNg)) {
              break label657;
            }
            if ((this.pNq == null) || (this.pNq.size() <= 0)) {
              break label588;
            }
            this.pNi = true;
            this.pNm = ((c)this.pNq.remove(0));
            this.pNm.a(this);
            this.pNn.pNb.execute(this.pNm);
            ae.i("MicroMsg.BKGLoader.BKGLoaderManager", "[cpan] tryToStart download store emoji task is runing. productID:%s size:%d", new Object[] { this.pNm.getKey(), Integer.valueOf(this.pNq.size()) });
            AppMethodBeat.o(108762);
            return;
          }
          ae.i("MicroMsg.BKGLoader.BKGLoaderManager", "[cpan] sdcard is full.");
          continue;
        }
        if (this.pNp == null) {
          break label421;
        }
      }
      finally {}
      label657:
      label666:
      if (this.pNp.size() > 0)
      {
        this.pNh = true;
        this.pNg = false;
        this.pNk = false;
        this.pNi = false;
        this.pNm = ((c)this.pNp.remove(0));
        this.pNm.a(this);
        this.pNn.pNb.execute(this.pNm);
        ae.i("MicroMsg.BKGLoader.BKGLoaderManager", "[cpan] tryToStart task is ruing. key:%s upload list size:%d", new Object[] { this.pNm.getKey(), Integer.valueOf(this.pNp.size()) });
        ciG();
      }
      else
      {
        label421:
        ae.i("MicroMsg.BKGLoader.BKGLoaderManager", "[cpan] tryToStart no task list .");
        if ((this.pNo == null) || (this.pNo.size() <= 0))
        {
          if ((this.pNg) && (this.cFc)) {
            this.pNj = true;
          }
          this.pNg = false;
        }
        if ((this.pNp == null) || (this.pNp.size() <= 0))
        {
          if ((this.pNh) && (this.cFc)) {
            this.pNk = true;
          }
          this.pNh = false;
        }
        if (((this.pNo == null) || (this.pNo.size() <= 0)) && ((this.pNp == null) || (this.pNp.size() <= 0)) && ((this.pNg) || (this.pNh)) && (this.cFc))
        {
          this.pNh = false;
          this.pNg = false;
        }
        this.pNf = false;
        ciG();
        continue;
        label588:
        this.pNi = false;
        AppMethodBeat.o(108762);
        continue;
        label602:
        if (chH())
        {
          ae.i("MicroMsg.BKGLoader.BKGLoaderManager", "[dz tryToStart is 3g or 4g]");
          this.pNg = false;
          this.pNh = false;
          this.pNj = false;
          this.pNi = false;
          ciG();
          AppMethodBeat.o(108762);
        }
        else
        {
          ae.i("MicroMsg.BKGLoader.BKGLoaderManager", "[dz tryToStart is not wifi, 3g nor 4g]");
          AppMethodBeat.o(108762);
          continue;
          i = 1;
        }
      }
    }
  }
  
  public final void ciF()
  {
    try
    {
      AppMethodBeat.i(108763);
      this.pNg = false;
      this.pNh = false;
      this.pNf = false;
      ciG();
      if (this.pNm != null) {
        this.pNm.cancel();
      }
      AppMethodBeat.o(108763);
      return;
    }
    finally {}
  }
  
  public final void ciG()
  {
    AppMethodBeat.i(108764);
    if ((this.pNr != null) && (this.pNr.size() > 0))
    {
      Iterator localIterator = this.pNr.iterator();
      while (localIterator.hasNext()) {
        localIterator.next();
      }
    }
    AppMethodBeat.o(108764);
  }
  
  public final void l(String paramString, int paramInt, boolean paramBoolean)
  {
    for (;;)
    {
      try
      {
        AppMethodBeat.i(108766);
        ae.i("MicroMsg.BKGLoader.BKGLoaderManager", "[cpan] task is finish. key:%s success:%b", new Object[] { paramString, Boolean.valueOf(paramBoolean) });
        if ((this.pNm == null) || (bu.isNullOrNil(paramString)))
        {
          ae.e("MicroMsg.BKGLoader.BKGLoaderManager", "CurrentTask or key is null. or key is no equal crrentkey ");
          AppMethodBeat.o(108766);
          return;
        }
        if (this.pNo.contains(this.pNm))
        {
          this.pNo.remove(this.pNm);
          if (!paramBoolean) {
            break label335;
          }
          if ((paramInt == 2) || (this.pNr == null) || (this.pNr.size() <= 0)) {
            break label208;
          }
          paramString = this.pNr.iterator();
          if (!paramString.hasNext()) {
            break label208;
          }
          paramString.next();
          continue;
        }
        if (!this.pNp.contains(this.pNm)) {
          break label179;
        }
      }
      finally {}
      this.pNp.remove(this.pNm);
      continue;
      label179:
      if (this.pNq.contains(this.pNm))
      {
        this.pNq.remove(this.pNm);
        continue;
        label208:
        if ((this.pNm instanceof a))
        {
          paramString = ((a)this.pNm).pMk;
          paramString = com.tencent.mm.emoji.a.i.aeX().wB(paramString);
          if (paramString != null)
          {
            paramString = paramString.iterator();
            for (long l = 0L; paramString.hasNext(); l = o.aZR(((EmojiInfo)paramString.next()).fSQ()) + l) {}
            ae.i("MicroMsg.BKGLoader.BKGLoaderManager", "download size is %s", new Object[] { Long.valueOf(l) });
            EmojiSyncManager.ri(l);
          }
        }
        for (;;)
        {
          if (paramInt != 2) {
            break label346;
          }
          this.pNv.ay(5000L, 5000L);
          AppMethodBeat.o(108766);
          break;
          label335:
          ae.i("MicroMsg.BKGLoader.BKGLoaderManager", "retry later.");
        }
        label346:
        this.pNv.ay(1000L, 1000L);
        AppMethodBeat.o(108766);
      }
    }
  }
  
  public final class ConnectivityReceiver
    extends BroadcastReceiver
  {
    public ConnectivityReceiver() {}
    
    public final void onReceive(final Context paramContext, Intent paramIntent)
    {
      AppMethodBeat.i(108756);
      h.MqF.aO(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(194865);
          int i = az.getNetType(paramContext);
          if (BKGLoaderManager.this.mNetWorkType == i)
          {
            AppMethodBeat.o(194865);
            return;
          }
          ae.i("MicroMsg.BKGLoader.BKGLoaderManager", "[cpan] network change type:%d", new Object[] { Integer.valueOf(i) });
          if (BKGLoaderManager.chH()) {
            BKGLoaderManager.this.ciF();
          }
          for (;;)
          {
            BKGLoaderManager.this.mNetWorkType = i;
            AppMethodBeat.o(194865);
            return;
            if (BKGLoaderManager.ciH()) {
              BKGLoaderManager.this.ciE();
            } else if (!az.isConnected(ak.getContext())) {
              BKGLoaderManager.this.ciF();
            } else {
              BKGLoaderManager.this.ciG();
            }
          }
        }
      });
      AppMethodBeat.o(108756);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.emoji.sync.BKGLoaderManager
 * JD-Core Version:    0.7.0.1
 */