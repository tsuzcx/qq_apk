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
import com.tencent.mm.emoji.a.h;
import com.tencent.mm.emoji.sync.EmojiSyncManager;
import com.tencent.mm.g.a.de;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.aj;
import com.tencent.mm.sdk.platformtools.av;
import com.tencent.mm.sdk.platformtools.av.a;
import com.tencent.mm.sdk.platformtools.ay;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.storage.emotion.EmojiInfo;
import com.tencent.mm.vfs.i;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.Vector;
import java.util.concurrent.Executor;

public final class BKGLoaderManager
  implements d
{
  int Jw;
  public boolean cwr;
  int mNetWorkType;
  private Vector<c> ozA;
  private Vector<c> ozB;
  private Vector<c> ozC;
  private Set<Object> ozD;
  public ConnectivityReceiver ozE;
  long ozF;
  long ozG;
  av ozH;
  public com.tencent.mm.sdk.b.c ozI;
  public com.tencent.mm.sdk.b.c ozJ;
  private int ozp;
  private int ozq;
  private boolean ozr;
  boolean ozs;
  boolean ozt;
  public boolean ozu;
  public boolean ozv;
  private boolean ozw;
  private boolean ozx;
  private c ozy;
  private b ozz;
  
  public BKGLoaderManager(b paramb)
  {
    AppMethodBeat.i(108757);
    this.ozp = 0;
    this.ozq = 0;
    this.ozr = false;
    this.ozs = false;
    this.ozt = false;
    this.ozu = false;
    this.ozv = false;
    this.ozw = false;
    this.ozx = false;
    this.cwr = false;
    this.ozy = null;
    this.ozA = new Vector();
    this.ozB = new Vector();
    this.ozC = new Vector();
    this.ozD = new HashSet();
    this.mNetWorkType = -1;
    this.ozF = 0L;
    this.ozG = 0L;
    this.ozH = new av(Looper.getMainLooper(), new av.a()
    {
      public final boolean onTimerExpired()
      {
        AppMethodBeat.i(108753);
        long l1;
        long l2;
        if ((BKGLoaderManager.this.ozs) || (BKGLoaderManager.this.ozt) || (BKGLoaderManager.this.ozu))
        {
          l1 = TrafficStats.getUidTxBytes(BKGLoaderManager.this.Jw);
          l2 = TrafficStats.getUidRxBytes(BKGLoaderManager.this.Jw);
          long l3 = l1 - BKGLoaderManager.this.ozF + (l2 - BKGLoaderManager.this.ozG);
          ad.d("MicroMsg.BKGLoader.BKGLoaderManager", "delta of data: " + l3 / 1024L);
          if (l3 > 20480L) {
            break label127;
          }
          BKGLoaderManager.this.bVx();
        }
        for (;;)
        {
          AppMethodBeat.o(108753);
          return false;
          label127:
          BKGLoaderManager.this.ozF = l1;
          BKGLoaderManager.this.ozG = l2;
          BKGLoaderManager.this.ozH.av(1000L, 1000L);
        }
      }
    }, false);
    this.ozI = new com.tencent.mm.sdk.b.c() {};
    this.ozJ = new com.tencent.mm.sdk.b.c() {};
    this.ozz = paramb;
    this.Jw = Process.myUid();
    this.mNetWorkType = ay.getNetType(aj.getContext());
    AppMethodBeat.o(108757);
  }
  
  static boolean bUA()
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
  
  public static boolean bVA()
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
  
  public final void Ue(String paramString)
  {
    AppMethodBeat.i(108765);
    ad.i("MicroMsg.BKGLoader.BKGLoaderManager", "[cpan] task is ruing. key:%s", new Object[] { paramString });
    AppMethodBeat.o(108765);
  }
  
  public final void bVw()
  {
    try
    {
      AppMethodBeat.i(108761);
      if (this.ozA != null) {
        this.ozA.clear();
      }
      if (this.ozB != null) {
        this.ozB.clear();
      }
      if (this.ozC != null) {
        this.ozC.clear();
      }
      this.ozr = false;
      AppMethodBeat.o(108761);
      return;
    }
    finally {}
  }
  
  public final void bVx()
  {
    int i = 0;
    for (;;)
    {
      try
      {
        AppMethodBeat.i(108762);
        if ((ay.isWifi(aj.getContext())) || (EmojiSyncManager.acw())) {
          break label661;
        }
        if ((i == 0) && (!this.ozr)) {
          break label599;
        }
        if ((this.ozA != null) && (this.ozA.size() > 0))
        {
          this.ozx = e.XH();
          this.ozs = true;
          this.ozt = false;
          this.ozv = false;
          this.ozu = false;
          if (!this.ozx)
          {
            this.ozy = ((c)this.ozA.remove(0));
            this.ozy.a(this);
            this.ozz.ozn.execute(this.ozy);
            ad.i("MicroMsg.BKGLoader.BKGLoaderManager", "[cpan] tryToStart task is ruing. key:%s donwload list size:%d", new Object[] { this.ozy.getKey(), Integer.valueOf(this.ozA.size()) });
            bVz();
            if ((this.ozt) || (this.ozs)) {
              break label653;
            }
            if ((this.ozC == null) || (this.ozC.size() <= 0)) {
              break label586;
            }
            this.ozu = true;
            this.ozy = ((c)this.ozC.remove(0));
            this.ozy.a(this);
            this.ozz.ozn.execute(this.ozy);
            ad.i("MicroMsg.BKGLoader.BKGLoaderManager", "[cpan] tryToStart download store emoji task is runing. productID:%s size:%d", new Object[] { this.ozy.getKey(), Integer.valueOf(this.ozC.size()) });
            AppMethodBeat.o(108762);
            return;
          }
          ad.i("MicroMsg.BKGLoader.BKGLoaderManager", "[cpan] sdcard is full.");
          continue;
        }
        if (this.ozB == null) {
          break label419;
        }
      }
      finally {}
      label653:
      label661:
      if (this.ozB.size() > 0)
      {
        this.ozt = true;
        this.ozs = false;
        this.ozw = false;
        this.ozu = false;
        this.ozy = ((c)this.ozB.remove(0));
        this.ozy.a(this);
        this.ozz.ozn.execute(this.ozy);
        ad.i("MicroMsg.BKGLoader.BKGLoaderManager", "[cpan] tryToStart task is ruing. key:%s upload list size:%d", new Object[] { this.ozy.getKey(), Integer.valueOf(this.ozB.size()) });
        bVz();
      }
      else
      {
        label419:
        ad.i("MicroMsg.BKGLoader.BKGLoaderManager", "[cpan] tryToStart no task list .");
        if ((this.ozA == null) || (this.ozA.size() <= 0))
        {
          if ((this.ozs) && (this.cwr)) {
            this.ozv = true;
          }
          this.ozs = false;
        }
        if ((this.ozB == null) || (this.ozB.size() <= 0))
        {
          if ((this.ozt) && (this.cwr)) {
            this.ozw = true;
          }
          this.ozt = false;
        }
        if (((this.ozA == null) || (this.ozA.size() <= 0)) && ((this.ozB == null) || (this.ozB.size() <= 0)) && ((this.ozs) || (this.ozt)) && (this.cwr))
        {
          this.ozt = false;
          this.ozs = false;
        }
        this.ozr = false;
        bVz();
        continue;
        label586:
        this.ozu = false;
        AppMethodBeat.o(108762);
        continue;
        label599:
        if (bUA())
        {
          ad.i("MicroMsg.BKGLoader.BKGLoaderManager", "[dz tryToStart is 3g or 4g]");
          this.ozs = false;
          this.ozt = false;
          this.ozv = false;
          this.ozu = false;
          bVz();
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
  
  public final void bVy()
  {
    try
    {
      AppMethodBeat.i(108763);
      this.ozs = false;
      this.ozt = false;
      this.ozr = false;
      bVz();
      if (this.ozy != null) {
        this.ozy.cancel();
      }
      AppMethodBeat.o(108763);
      return;
    }
    finally {}
  }
  
  public final void bVz()
  {
    AppMethodBeat.i(108764);
    if ((this.ozD != null) && (this.ozD.size() > 0))
    {
      Iterator localIterator = this.ozD.iterator();
      while (localIterator.hasNext()) {
        localIterator.next();
      }
    }
    AppMethodBeat.o(108764);
  }
  
  public final void cM(List<c> paramList)
  {
    AppMethodBeat.i(108758);
    this.ozr = false;
    if (this.ozA == null) {
      this.ozA = new Vector();
    }
    if (paramList.size() > 0)
    {
      int j = paramList.size();
      int i = 0;
      if (i < j)
      {
        c localc = (c)paramList.get(i);
        if ((localc != null) && (!this.ozA.contains(localc))) {
          this.ozA.add(localc);
        }
        for (;;)
        {
          i += 1;
          break;
          ad.i("MicroMsg.BKGLoader.BKGLoaderManager", "[cpan] task is has exist.:%s", new Object[] { localc.getKey() });
        }
      }
    }
    AppMethodBeat.o(108758);
  }
  
  public final void cN(List<c> paramList)
  {
    AppMethodBeat.i(108759);
    if (this.ozB == null) {
      this.ozB = new Vector();
    }
    if (paramList.size() > 0)
    {
      int j = paramList.size();
      int i = 0;
      if (i < j)
      {
        c localc = (c)paramList.get(i);
        if ((localc != null) && (!this.ozB.contains(localc))) {
          this.ozB.add(localc);
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
  
  public final void cO(List<c> paramList)
  {
    for (;;)
    {
      int i;
      try
      {
        AppMethodBeat.i(108760);
        if (this.ozC == null) {
          this.ozC = new Vector();
        }
        if ((paramList == null) || (paramList.size() <= 0)) {
          break label199;
        }
        int j = paramList.size();
        i = 0;
        if (i >= j) {
          break label199;
        }
        localObject = (c)paramList.get(i);
        if ((this.ozy != null) && (this.ozy.equals(localObject)))
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
        else if ((localObject != null) && (!this.ozC.contains(localObject))) {
          this.ozC.add(localObject);
        }
      }
      finally {}
      if (localObject == null) {}
      for (Object localObject = "task is null";; localObject = ((c)localObject).getKey())
      {
        ad.i("MicroMsg.BKGLoader.BKGLoaderManager", "[cpan] task is has exist:%s", new Object[] { localObject });
        break;
      }
      label199:
      AppMethodBeat.o(108760);
      return;
      i += 1;
    }
  }
  
  public final void l(String paramString, int paramInt, boolean paramBoolean)
  {
    for (;;)
    {
      try
      {
        AppMethodBeat.i(108766);
        ad.i("MicroMsg.BKGLoader.BKGLoaderManager", "[cpan] task is finish. key:%s success:%b", new Object[] { paramString, Boolean.valueOf(paramBoolean) });
        if ((this.ozy == null) || (bt.isNullOrNil(paramString)))
        {
          ad.e("MicroMsg.BKGLoader.BKGLoaderManager", "CurrentTask or key is null. or key is no equal crrentkey ");
          AppMethodBeat.o(108766);
          return;
        }
        if (this.ozA.contains(this.ozy))
        {
          this.ozA.remove(this.ozy);
          if (!paramBoolean) {
            break label335;
          }
          if ((paramInt == 2) || (this.ozD == null) || (this.ozD.size() <= 0)) {
            break label208;
          }
          paramString = this.ozD.iterator();
          if (!paramString.hasNext()) {
            break label208;
          }
          paramString.next();
          continue;
        }
        if (!this.ozB.contains(this.ozy)) {
          break label179;
        }
      }
      finally {}
      this.ozB.remove(this.ozy);
      continue;
      label179:
      if (this.ozC.contains(this.ozy))
      {
        this.ozC.remove(this.ozy);
        continue;
        label208:
        if ((this.ozy instanceof com.tencent.mm.plugin.emoji.sync.a.b))
        {
          paramString = ((com.tencent.mm.plugin.emoji.sync.a.b)this.ozy).oyw;
          paramString = h.abj().pU(paramString);
          if (paramString != null)
          {
            paramString = paramString.iterator();
            for (long l = 0L; paramString.hasNext(); l = i.aMN(((EmojiInfo)paramString.next()).gaa()) + l) {}
            ad.i("MicroMsg.BKGLoader.BKGLoaderManager", "download size is %s", new Object[] { Long.valueOf(l) });
            EmojiSyncManager.ls(l);
          }
        }
        for (;;)
        {
          if (paramInt != 2) {
            break label346;
          }
          this.ozH.av(5000L, 5000L);
          AppMethodBeat.o(108766);
          break;
          label335:
          ad.i("MicroMsg.BKGLoader.BKGLoaderManager", "retry later.");
        }
        label346:
        this.ozH.av(1000L, 1000L);
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
      int i = ay.getNetType(paramContext);
      if (BKGLoaderManager.this.mNetWorkType == i)
      {
        AppMethodBeat.o(108756);
        return;
      }
      ad.i("MicroMsg.BKGLoader.BKGLoaderManager", "[cpan] network change type:%d", new Object[] { Integer.valueOf(i) });
      if (BKGLoaderManager.bUA()) {
        BKGLoaderManager.this.bVy();
      }
      for (;;)
      {
        BKGLoaderManager.this.mNetWorkType = i;
        AppMethodBeat.o(108756);
        return;
        if (BKGLoaderManager.bVA()) {
          BKGLoaderManager.this.bVx();
        } else if (!ay.isConnected(aj.getContext())) {
          BKGLoaderManager.this.bVy();
        } else {
          BKGLoaderManager.this.bVz();
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.emoji.sync.BKGLoaderManager
 * JD-Core Version:    0.7.0.1
 */