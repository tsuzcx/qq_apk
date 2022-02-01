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
import com.tencent.mm.g.a.di;
import com.tencent.mm.plugin.emoji.sync.a.a;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.aj;
import com.tencent.mm.sdk.platformtools.av;
import com.tencent.mm.sdk.platformtools.av.a;
import com.tencent.mm.sdk.platformtools.ay;
import com.tencent.mm.sdk.platformtools.bt;
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
  int Mh;
  public boolean cEv;
  int mNetWorkType;
  private int pGA;
  private boolean pGB;
  boolean pGC;
  boolean pGD;
  public boolean pGE;
  public boolean pGF;
  private boolean pGG;
  private boolean pGH;
  private c pGI;
  private b pGJ;
  private Vector<c> pGK;
  private Vector<c> pGL;
  private Vector<c> pGM;
  private Set<Object> pGN;
  public ConnectivityReceiver pGO;
  long pGP;
  long pGQ;
  av pGR;
  public com.tencent.mm.sdk.b.c pGS;
  public com.tencent.mm.sdk.b.c pGT;
  private int pGz;
  
  public BKGLoaderManager(b paramb)
  {
    AppMethodBeat.i(108757);
    this.pGz = 0;
    this.pGA = 0;
    this.pGB = false;
    this.pGC = false;
    this.pGD = false;
    this.pGE = false;
    this.pGF = false;
    this.pGG = false;
    this.pGH = false;
    this.cEv = false;
    this.pGI = null;
    this.pGK = new Vector();
    this.pGL = new Vector();
    this.pGM = new Vector();
    this.pGN = new HashSet();
    this.mNetWorkType = -1;
    this.pGP = 0L;
    this.pGQ = 0L;
    this.pGR = new av(Looper.getMainLooper(), new av.a()
    {
      public final boolean onTimerExpired()
      {
        AppMethodBeat.i(108753);
        long l1;
        long l2;
        if ((BKGLoaderManager.this.pGC) || (BKGLoaderManager.this.pGD) || (BKGLoaderManager.this.pGE))
        {
          l1 = TrafficStats.getUidTxBytes(BKGLoaderManager.this.Mh);
          l2 = TrafficStats.getUidRxBytes(BKGLoaderManager.this.Mh);
          long l3 = l1 - BKGLoaderManager.this.pGP + (l2 - BKGLoaderManager.this.pGQ);
          ad.d("MicroMsg.BKGLoader.BKGLoaderManager", "delta of data: " + l3 / 1024L);
          if (l3 > 20480L) {
            break label127;
          }
          BKGLoaderManager.this.cho();
        }
        for (;;)
        {
          AppMethodBeat.o(108753);
          return false;
          label127:
          BKGLoaderManager.this.pGP = l1;
          BKGLoaderManager.this.pGQ = l2;
          BKGLoaderManager.this.pGR.az(1000L, 1000L);
        }
      }
    }, false);
    this.pGS = new com.tencent.mm.sdk.b.c() {};
    this.pGT = new com.tencent.mm.sdk.b.c() {};
    this.pGJ = paramb;
    this.Mh = Process.myUid();
    this.mNetWorkType = ay.getNetType(aj.getContext());
    AppMethodBeat.o(108757);
  }
  
  static boolean cgr()
  {
    AppMethodBeat.i(108768);
    if ((ay.is3G(aj.getContext())) || (ay.is4G(aj.getContext())) || (ay.is2G(aj.getContext())))
    {
      AppMethodBeat.o(108768);
      return true;
    }
    AppMethodBeat.o(108768);
    return false;
  }
  
  public static boolean chr()
  {
    AppMethodBeat.i(108767);
    long l = SystemClock.uptimeMillis();
    try
    {
      NetworkInfo localNetworkInfo = ((ConnectivityManager)aj.getContext().getSystemService("connectivity")).getNetworkInfo(1);
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
        ad.i("MicroMsg.BKGLoader.BKGLoaderManager", "[isWifi] cost:%s", new Object[] { Long.valueOf(l) });
      }
      AppMethodBeat.o(108767);
    }
  }
  
  public final void abW(String paramString)
  {
    AppMethodBeat.i(108765);
    ad.i("MicroMsg.BKGLoader.BKGLoaderManager", "[cpan] task is ruing. key:%s", new Object[] { paramString });
    AppMethodBeat.o(108765);
  }
  
  public final void cP(List<c> paramList)
  {
    AppMethodBeat.i(108759);
    if (this.pGL == null) {
      this.pGL = new Vector();
    }
    if (paramList.size() > 0)
    {
      int j = paramList.size();
      int i = 0;
      if (i < j)
      {
        c localc = (c)paramList.get(i);
        if ((localc != null) && (!this.pGL.contains(localc))) {
          this.pGL.add(localc);
        }
        for (;;)
        {
          i += 1;
          break;
          ad.i("MicroMsg.BKGLoader.BKGLoaderManager", "[cpan] task is has exist:%s", new Object[] { localc.getKey() });
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
        if (this.pGM == null) {
          this.pGM = new Vector();
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
        if ((this.pGI != null) && (this.pGI.equals(localObject)))
        {
          if (localObject == null)
          {
            localObject = "task is null";
            ad.i("MicroMsg.BKGLoader.BKGLoaderManager", "[cpan] currentTask equals task is has exist:%s", new Object[] { localObject });
          }
          else
          {
            localObject = ((c)localObject).getKey();
            continue;
          }
        }
        else if ((localObject != null) && (!this.pGM.contains(localObject))) {
          this.pGM.add(localObject);
        }
      }
      finally {}
      if (localObject == null) {}
      for (Object localObject = "task is null";; localObject = ((c)localObject).getKey())
      {
        ad.i("MicroMsg.BKGLoader.BKGLoaderManager", "[cpan] task is has exist:%s", new Object[] { localObject });
        break;
      }
      label194:
      AppMethodBeat.o(108760);
      return;
      i += 1;
    }
  }
  
  public final void chn()
  {
    try
    {
      AppMethodBeat.i(108761);
      if (this.pGK != null) {
        this.pGK.clear();
      }
      if (this.pGL != null) {
        this.pGL.clear();
      }
      if (this.pGM != null) {
        this.pGM.clear();
      }
      this.pGB = false;
      AppMethodBeat.o(108761);
      return;
    }
    finally {}
  }
  
  public final void cho()
  {
    int i = 0;
    for (;;)
    {
      try
      {
        AppMethodBeat.i(108762);
        if ((ay.isWifi(aj.getContext())) || (EmojiSyncManager.agi())) {
          break label666;
        }
        if ((i == 0) && (!this.pGB)) {
          break label602;
        }
        if ((this.pGK != null) && (this.pGK.size() > 0))
        {
          this.pGH = e.abg();
          this.pGC = true;
          this.pGD = false;
          this.pGF = false;
          this.pGE = false;
          if (!this.pGH)
          {
            this.pGI = ((c)this.pGK.remove(0));
            this.pGI.a(this);
            this.pGJ.pGx.execute(this.pGI);
            ad.i("MicroMsg.BKGLoader.BKGLoaderManager", "[cpan] tryToStart task is ruing. key:%s donwload list size:%d", new Object[] { this.pGI.getKey(), Integer.valueOf(this.pGK.size()) });
            chq();
            if ((this.pGD) || (this.pGC)) {
              break label657;
            }
            if ((this.pGM == null) || (this.pGM.size() <= 0)) {
              break label588;
            }
            this.pGE = true;
            this.pGI = ((c)this.pGM.remove(0));
            this.pGI.a(this);
            this.pGJ.pGx.execute(this.pGI);
            ad.i("MicroMsg.BKGLoader.BKGLoaderManager", "[cpan] tryToStart download store emoji task is runing. productID:%s size:%d", new Object[] { this.pGI.getKey(), Integer.valueOf(this.pGM.size()) });
            AppMethodBeat.o(108762);
            return;
          }
          ad.i("MicroMsg.BKGLoader.BKGLoaderManager", "[cpan] sdcard is full.");
          continue;
        }
        if (this.pGL == null) {
          break label421;
        }
      }
      finally {}
      label657:
      label666:
      if (this.pGL.size() > 0)
      {
        this.pGD = true;
        this.pGC = false;
        this.pGG = false;
        this.pGE = false;
        this.pGI = ((c)this.pGL.remove(0));
        this.pGI.a(this);
        this.pGJ.pGx.execute(this.pGI);
        ad.i("MicroMsg.BKGLoader.BKGLoaderManager", "[cpan] tryToStart task is ruing. key:%s upload list size:%d", new Object[] { this.pGI.getKey(), Integer.valueOf(this.pGL.size()) });
        chq();
      }
      else
      {
        label421:
        ad.i("MicroMsg.BKGLoader.BKGLoaderManager", "[cpan] tryToStart no task list .");
        if ((this.pGK == null) || (this.pGK.size() <= 0))
        {
          if ((this.pGC) && (this.cEv)) {
            this.pGF = true;
          }
          this.pGC = false;
        }
        if ((this.pGL == null) || (this.pGL.size() <= 0))
        {
          if ((this.pGD) && (this.cEv)) {
            this.pGG = true;
          }
          this.pGD = false;
        }
        if (((this.pGK == null) || (this.pGK.size() <= 0)) && ((this.pGL == null) || (this.pGL.size() <= 0)) && ((this.pGC) || (this.pGD)) && (this.cEv))
        {
          this.pGD = false;
          this.pGC = false;
        }
        this.pGB = false;
        chq();
        continue;
        label588:
        this.pGE = false;
        AppMethodBeat.o(108762);
        continue;
        label602:
        if (cgr())
        {
          ad.i("MicroMsg.BKGLoader.BKGLoaderManager", "[dz tryToStart is 3g or 4g]");
          this.pGC = false;
          this.pGD = false;
          this.pGF = false;
          this.pGE = false;
          chq();
          AppMethodBeat.o(108762);
        }
        else
        {
          ad.i("MicroMsg.BKGLoader.BKGLoaderManager", "[dz tryToStart is not wifi, 3g nor 4g]");
          AppMethodBeat.o(108762);
          continue;
          i = 1;
        }
      }
    }
  }
  
  public final void chp()
  {
    try
    {
      AppMethodBeat.i(108763);
      this.pGC = false;
      this.pGD = false;
      this.pGB = false;
      chq();
      if (this.pGI != null) {
        this.pGI.cancel();
      }
      AppMethodBeat.o(108763);
      return;
    }
    finally {}
  }
  
  public final void chq()
  {
    AppMethodBeat.i(108764);
    if ((this.pGN != null) && (this.pGN.size() > 0))
    {
      Iterator localIterator = this.pGN.iterator();
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
        ad.i("MicroMsg.BKGLoader.BKGLoaderManager", "[cpan] task is finish. key:%s success:%b", new Object[] { paramString, Boolean.valueOf(paramBoolean) });
        if ((this.pGI == null) || (bt.isNullOrNil(paramString)))
        {
          ad.e("MicroMsg.BKGLoader.BKGLoaderManager", "CurrentTask or key is null. or key is no equal crrentkey ");
          AppMethodBeat.o(108766);
          return;
        }
        if (this.pGK.contains(this.pGI))
        {
          this.pGK.remove(this.pGI);
          if (!paramBoolean) {
            break label335;
          }
          if ((paramInt == 2) || (this.pGN == null) || (this.pGN.size() <= 0)) {
            break label208;
          }
          paramString = this.pGN.iterator();
          if (!paramString.hasNext()) {
            break label208;
          }
          paramString.next();
          continue;
        }
        if (!this.pGL.contains(this.pGI)) {
          break label179;
        }
      }
      finally {}
      this.pGL.remove(this.pGI);
      continue;
      label179:
      if (this.pGM.contains(this.pGI))
      {
        this.pGM.remove(this.pGI);
        continue;
        label208:
        if ((this.pGI instanceof a))
        {
          paramString = ((a)this.pGI).pFG;
          paramString = com.tencent.mm.emoji.a.i.aeL().vU(paramString);
          if (paramString != null)
          {
            paramString = paramString.iterator();
            for (long l = 0L; paramString.hasNext(); l = com.tencent.mm.vfs.i.aYo(((EmojiInfo)paramString.next()).gzQ()) + l) {}
            ad.i("MicroMsg.BKGLoader.BKGLoaderManager", "download size is %s", new Object[] { Long.valueOf(l) });
            EmojiSyncManager.qV(l);
          }
        }
        for (;;)
        {
          if (paramInt != 2) {
            break label346;
          }
          this.pGR.az(5000L, 5000L);
          AppMethodBeat.o(108766);
          break;
          label335:
          ad.i("MicroMsg.BKGLoader.BKGLoaderManager", "retry later.");
        }
        label346:
        this.pGR.az(1000L, 1000L);
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
      h.LTJ.aR(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(198747);
          int i = ay.getNetType(paramContext);
          if (BKGLoaderManager.this.mNetWorkType == i)
          {
            AppMethodBeat.o(198747);
            return;
          }
          ad.i("MicroMsg.BKGLoader.BKGLoaderManager", "[cpan] network change type:%d", new Object[] { Integer.valueOf(i) });
          if (BKGLoaderManager.cgr()) {
            BKGLoaderManager.this.chp();
          }
          for (;;)
          {
            BKGLoaderManager.this.mNetWorkType = i;
            AppMethodBeat.o(198747);
            return;
            if (BKGLoaderManager.chr()) {
              BKGLoaderManager.this.cho();
            } else if (!ay.isConnected(aj.getContext())) {
              BKGLoaderManager.this.chp();
            } else {
              BKGLoaderManager.this.chq();
            }
          }
        }
      });
      AppMethodBeat.o(108756);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.emoji.sync.BKGLoaderManager
 * JD-Core Version:    0.7.0.1
 */