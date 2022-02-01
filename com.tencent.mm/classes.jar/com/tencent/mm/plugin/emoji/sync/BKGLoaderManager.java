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
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.compatible.util.e;
import com.tencent.mm.emoji.sync.EmojiSyncManager;
import com.tencent.mm.g.a.df;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.ai;
import com.tencent.mm.sdk.platformtools.au;
import com.tencent.mm.sdk.platformtools.au.a;
import com.tencent.mm.sdk.platformtools.ax;
import com.tencent.mm.sdk.platformtools.bs;
import com.tencent.mm.storage.emotion.EmojiInfo;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.Vector;
import java.util.concurrent.Executor;

public final class BKGLoaderManager
  implements d
{
  int Kr;
  public boolean ctA;
  int mNetWorkType;
  private int pcP;
  private int pcQ;
  private boolean pcR;
  boolean pcS;
  boolean pcT;
  public boolean pcU;
  public boolean pcV;
  private boolean pcW;
  private boolean pcX;
  private c pcY;
  private b pcZ;
  private Vector<c> pda;
  private Vector<c> pdb;
  private Vector<c> pdc;
  private Set<Object> pdd;
  public ConnectivityReceiver pde;
  long pdf;
  long pdg;
  au pdh;
  public com.tencent.mm.sdk.b.c pdi;
  public com.tencent.mm.sdk.b.c pdj;
  
  public BKGLoaderManager(b paramb)
  {
    AppMethodBeat.i(108757);
    this.pcP = 0;
    this.pcQ = 0;
    this.pcR = false;
    this.pcS = false;
    this.pcT = false;
    this.pcU = false;
    this.pcV = false;
    this.pcW = false;
    this.pcX = false;
    this.ctA = false;
    this.pcY = null;
    this.pda = new Vector();
    this.pdb = new Vector();
    this.pdc = new Vector();
    this.pdd = new HashSet();
    this.mNetWorkType = -1;
    this.pdf = 0L;
    this.pdg = 0L;
    this.pdh = new au(Looper.getMainLooper(), new au.a()
    {
      public final boolean onTimerExpired()
      {
        AppMethodBeat.i(108753);
        long l1;
        long l2;
        if ((BKGLoaderManager.this.pcS) || (BKGLoaderManager.this.pcT) || (BKGLoaderManager.this.pcU))
        {
          l1 = TrafficStats.getUidTxBytes(BKGLoaderManager.this.Kr);
          l2 = TrafficStats.getUidRxBytes(BKGLoaderManager.this.Kr);
          long l3 = l1 - BKGLoaderManager.this.pdf + (l2 - BKGLoaderManager.this.pdg);
          ac.d("MicroMsg.BKGLoader.BKGLoaderManager", "delta of data: " + l3 / 1024L);
          if (l3 > 20480L) {
            break label127;
          }
          BKGLoaderManager.this.ccK();
        }
        for (;;)
        {
          AppMethodBeat.o(108753);
          return false;
          label127:
          BKGLoaderManager.this.pdf = l1;
          BKGLoaderManager.this.pdg = l2;
          BKGLoaderManager.this.pdh.au(1000L, 1000L);
        }
      }
    }, false);
    this.pdi = new BKGLoaderManager.2(this);
    this.pdj = new com.tencent.mm.sdk.b.c() {};
    this.pcZ = paramb;
    this.Kr = Process.myUid();
    this.mNetWorkType = ax.getNetType(ai.getContext());
    AppMethodBeat.o(108757);
  }
  
  static boolean cbN()
  {
    AppMethodBeat.i(108768);
    if ((ax.is3G(ai.getContext())) || (ax.is4G(ai.getContext())) || (ax.is2G(ai.getContext())))
    {
      AppMethodBeat.o(108768);
      return true;
    }
    AppMethodBeat.o(108768);
    return false;
  }
  
  public static boolean ccN()
  {
    AppMethodBeat.i(108767);
    long l = SystemClock.uptimeMillis();
    try
    {
      NetworkInfo localNetworkInfo = ((ConnectivityManager)ai.getContext().getSystemService("connectivity")).getNetworkInfo(1);
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
        ac.i("MicroMsg.BKGLoader.BKGLoaderManager", "[isWifi] cost:%s", new Object[] { Long.valueOf(l) });
      }
      AppMethodBeat.o(108767);
    }
  }
  
  public final void Yq(String paramString)
  {
    AppMethodBeat.i(108765);
    ac.i("MicroMsg.BKGLoader.BKGLoaderManager", "[cpan] task is ruing. key:%s", new Object[] { paramString });
    AppMethodBeat.o(108765);
  }
  
  public final void cO(List<c> paramList)
  {
    AppMethodBeat.i(108758);
    this.pcR = false;
    if (this.pda == null) {
      this.pda = new Vector();
    }
    if (paramList.size() > 0)
    {
      int j = paramList.size();
      int i = 0;
      if (i < j)
      {
        c localc = (c)paramList.get(i);
        if ((localc != null) && (!this.pda.contains(localc))) {
          this.pda.add(localc);
        }
        for (;;)
        {
          i += 1;
          break;
          ac.i("MicroMsg.BKGLoader.BKGLoaderManager", "[cpan] task is has exist.:%s", new Object[] { localc.getKey() });
        }
      }
    }
    AppMethodBeat.o(108758);
  }
  
  public final void cP(List<c> paramList)
  {
    AppMethodBeat.i(108759);
    if (this.pdb == null) {
      this.pdb = new Vector();
    }
    if (paramList.size() > 0)
    {
      int j = paramList.size();
      int i = 0;
      if (i < j)
      {
        c localc = (c)paramList.get(i);
        if ((localc != null) && (!this.pdb.contains(localc))) {
          this.pdb.add(localc);
        }
        for (;;)
        {
          i += 1;
          break;
          ac.i("MicroMsg.BKGLoader.BKGLoaderManager", "[cpan] task is has exist:%s", new Object[] { localc.getKey() });
        }
      }
    }
    AppMethodBeat.o(108759);
  }
  
  public final void cQ(List<c> paramList)
  {
    for (;;)
    {
      int i;
      try
      {
        AppMethodBeat.i(108760);
        if (this.pdc == null) {
          this.pdc = new Vector();
        }
        if ((paramList == null) || (paramList.size() <= 0)) {
          break label195;
        }
        int j = paramList.size();
        i = 0;
        if (i >= j) {
          break label195;
        }
        localObject = (c)paramList.get(i);
        if ((this.pcY != null) && (this.pcY.equals(localObject)))
        {
          if (localObject == null)
          {
            localObject = "task is null";
            ac.i("MicroMsg.BKGLoader.BKGLoaderManager", "[cpan] currentTask equals task is has exist:%s", new Object[] { localObject });
          }
          else
          {
            localObject = ((c)localObject).getKey();
            continue;
          }
        }
        else if ((localObject != null) && (!this.pdc.contains(localObject))) {
          this.pdc.add(localObject);
        }
      }
      finally {}
      if (localObject == null) {}
      for (Object localObject = "task is null";; localObject = ((c)localObject).getKey())
      {
        ac.i("MicroMsg.BKGLoader.BKGLoaderManager", "[cpan] task is has exist:%s", new Object[] { localObject });
        break;
      }
      label195:
      AppMethodBeat.o(108760);
      return;
      i += 1;
    }
  }
  
  public final void ccJ()
  {
    try
    {
      AppMethodBeat.i(108761);
      if (this.pda != null) {
        this.pda.clear();
      }
      if (this.pdb != null) {
        this.pdb.clear();
      }
      if (this.pdc != null) {
        this.pdc.clear();
      }
      this.pcR = false;
      AppMethodBeat.o(108761);
      return;
    }
    finally {}
  }
  
  public final void ccK()
  {
    int i = 0;
    for (;;)
    {
      try
      {
        AppMethodBeat.i(108762);
        if ((ax.isWifi(ai.getContext())) || (EmojiSyncManager.adC())) {
          break label666;
        }
        if ((i == 0) && (!this.pcR)) {
          break label602;
        }
        if ((this.pda != null) && (this.pda.size() > 0))
        {
          this.pcX = e.YE();
          this.pcS = true;
          this.pcT = false;
          this.pcV = false;
          this.pcU = false;
          if (!this.pcX)
          {
            this.pcY = ((c)this.pda.remove(0));
            this.pcY.a(this);
            this.pcZ.pcN.execute(this.pcY);
            ac.i("MicroMsg.BKGLoader.BKGLoaderManager", "[cpan] tryToStart task is ruing. key:%s donwload list size:%d", new Object[] { this.pcY.getKey(), Integer.valueOf(this.pda.size()) });
            ccM();
            if ((this.pcT) || (this.pcS)) {
              break label657;
            }
            if ((this.pdc == null) || (this.pdc.size() <= 0)) {
              break label588;
            }
            this.pcU = true;
            this.pcY = ((c)this.pdc.remove(0));
            this.pcY.a(this);
            this.pcZ.pcN.execute(this.pcY);
            ac.i("MicroMsg.BKGLoader.BKGLoaderManager", "[cpan] tryToStart download store emoji task is runing. productID:%s size:%d", new Object[] { this.pcY.getKey(), Integer.valueOf(this.pdc.size()) });
            AppMethodBeat.o(108762);
            return;
          }
          ac.i("MicroMsg.BKGLoader.BKGLoaderManager", "[cpan] sdcard is full.");
          continue;
        }
        if (this.pdb == null) {
          break label421;
        }
      }
      finally {}
      label657:
      label666:
      if (this.pdb.size() > 0)
      {
        this.pcT = true;
        this.pcS = false;
        this.pcW = false;
        this.pcU = false;
        this.pcY = ((c)this.pdb.remove(0));
        this.pcY.a(this);
        this.pcZ.pcN.execute(this.pcY);
        ac.i("MicroMsg.BKGLoader.BKGLoaderManager", "[cpan] tryToStart task is ruing. key:%s upload list size:%d", new Object[] { this.pcY.getKey(), Integer.valueOf(this.pdb.size()) });
        ccM();
      }
      else
      {
        label421:
        ac.i("MicroMsg.BKGLoader.BKGLoaderManager", "[cpan] tryToStart no task list .");
        if ((this.pda == null) || (this.pda.size() <= 0))
        {
          if ((this.pcS) && (this.ctA)) {
            this.pcV = true;
          }
          this.pcS = false;
        }
        if ((this.pdb == null) || (this.pdb.size() <= 0))
        {
          if ((this.pcT) && (this.ctA)) {
            this.pcW = true;
          }
          this.pcT = false;
        }
        if (((this.pda == null) || (this.pda.size() <= 0)) && ((this.pdb == null) || (this.pdb.size() <= 0)) && ((this.pcS) || (this.pcT)) && (this.ctA))
        {
          this.pcT = false;
          this.pcS = false;
        }
        this.pcR = false;
        ccM();
        continue;
        label588:
        this.pcU = false;
        AppMethodBeat.o(108762);
        continue;
        label602:
        if (cbN())
        {
          ac.i("MicroMsg.BKGLoader.BKGLoaderManager", "[dz tryToStart is 3g or 4g]");
          this.pcS = false;
          this.pcT = false;
          this.pcV = false;
          this.pcU = false;
          ccM();
          AppMethodBeat.o(108762);
        }
        else
        {
          ac.i("MicroMsg.BKGLoader.BKGLoaderManager", "[dz tryToStart is not wifi, 3g nor 4g]");
          AppMethodBeat.o(108762);
          continue;
          i = 1;
        }
      }
    }
  }
  
  public final void ccL()
  {
    try
    {
      AppMethodBeat.i(108763);
      this.pcS = false;
      this.pcT = false;
      this.pcR = false;
      ccM();
      if (this.pcY != null) {
        this.pcY.cancel();
      }
      AppMethodBeat.o(108763);
      return;
    }
    finally {}
  }
  
  public final void ccM()
  {
    AppMethodBeat.i(108764);
    if ((this.pdd != null) && (this.pdd.size() > 0))
    {
      Iterator localIterator = this.pdd.iterator();
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
        ac.i("MicroMsg.BKGLoader.BKGLoaderManager", "[cpan] task is finish. key:%s success:%b", new Object[] { paramString, Boolean.valueOf(paramBoolean) });
        if ((this.pcY == null) || (bs.isNullOrNil(paramString)))
        {
          ac.e("MicroMsg.BKGLoader.BKGLoaderManager", "CurrentTask or key is null. or key is no equal crrentkey ");
          AppMethodBeat.o(108766);
          return;
        }
        if (this.pda.contains(this.pcY))
        {
          this.pda.remove(this.pcY);
          if (!paramBoolean) {
            break label335;
          }
          if ((paramInt == 2) || (this.pdd == null) || (this.pdd.size() <= 0)) {
            break label208;
          }
          paramString = this.pdd.iterator();
          if (!paramString.hasNext()) {
            break label208;
          }
          paramString.next();
          continue;
        }
        if (!this.pdb.contains(this.pcY)) {
          break label179;
        }
      }
      finally {}
      this.pdb.remove(this.pcY);
      continue;
      label179:
      if (this.pdc.contains(this.pcY))
      {
        this.pdc.remove(this.pcY);
        continue;
        label208:
        if ((this.pcY instanceof com.tencent.mm.plugin.emoji.sync.a.b))
        {
          paramString = ((com.tencent.mm.plugin.emoji.sync.a.b)this.pcY).pbW;
          paramString = com.tencent.mm.emoji.a.i.ach().tf(paramString);
          if (paramString != null)
          {
            paramString = paramString.iterator();
            for (long l = 0L; paramString.hasNext(); l = com.tencent.mm.vfs.i.aSp(((EmojiInfo)paramString.next()).ghd()) + l) {}
            ac.i("MicroMsg.BKGLoader.BKGLoaderManager", "download size is %s", new Object[] { Long.valueOf(l) });
            EmojiSyncManager.oV(l);
          }
        }
        for (;;)
        {
          if (paramInt != 2) {
            break label346;
          }
          this.pdh.au(5000L, 5000L);
          AppMethodBeat.o(108766);
          break;
          label335:
          ac.i("MicroMsg.BKGLoader.BKGLoaderManager", "retry later.");
        }
        label346:
        this.pdh.au(1000L, 1000L);
        AppMethodBeat.o(108766);
      }
    }
  }
  
  public final class ConnectivityReceiver
    extends BroadcastReceiver
  {
    public ConnectivityReceiver() {}
    
    public final void onReceive(Context paramContext, Intent paramIntent)
    {
      AppMethodBeat.i(108756);
      int i = ax.getNetType(paramContext);
      if (BKGLoaderManager.this.mNetWorkType == i)
      {
        AppMethodBeat.o(108756);
        return;
      }
      ac.i("MicroMsg.BKGLoader.BKGLoaderManager", "[cpan] network change type:%d", new Object[] { Integer.valueOf(i) });
      if (BKGLoaderManager.cbN()) {
        BKGLoaderManager.this.ccL();
      }
      for (;;)
      {
        BKGLoaderManager.this.mNetWorkType = i;
        AppMethodBeat.o(108756);
        return;
        if (BKGLoaderManager.ccN()) {
          BKGLoaderManager.this.ccK();
        } else if (!ax.isConnected(ai.getContext())) {
          BKGLoaderManager.this.ccL();
        } else {
          BKGLoaderManager.this.ccM();
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.emoji.sync.BKGLoaderManager
 * JD-Core Version:    0.7.0.1
 */