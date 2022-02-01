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
import com.tencent.f.h;
import com.tencent.f.i;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.compatible.util.e;
import com.tencent.mm.emoji.b.j;
import com.tencent.mm.emoji.sync.EmojiSyncManager;
import com.tencent.mm.g.a.dm;
import com.tencent.mm.plugin.emoji.sync.a.a;
import com.tencent.mm.sdk.event.IListener;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.MTimerHandler;
import com.tencent.mm.sdk.platformtools.MTimerHandler.CallBack;
import com.tencent.mm.sdk.platformtools.NetStatusUtil;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.emotion.EmojiInfo;
import com.tencent.mm.vfs.s;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.Vector;
import java.util.concurrent.Executor;

public final class BKGLoaderManager
  implements d
{
  int Mr;
  public boolean mIsForeground;
  int mNetWorkType;
  boolean rdA;
  boolean rdB;
  public boolean rdC;
  public boolean rdD;
  private boolean rdE;
  private boolean rdF;
  private c rdG;
  private b rdH;
  private Vector<c> rdI;
  private Vector<c> rdJ;
  private Vector<c> rdK;
  private Set<Object> rdL;
  public ConnectivityReceiver rdM;
  long rdN;
  long rdO;
  MTimerHandler rdP;
  public IListener rdQ;
  public IListener rdR;
  private int rdx;
  private int rdy;
  private boolean rdz;
  
  public BKGLoaderManager(b paramb)
  {
    AppMethodBeat.i(108757);
    this.rdx = 0;
    this.rdy = 0;
    this.rdz = false;
    this.rdA = false;
    this.rdB = false;
    this.rdC = false;
    this.rdD = false;
    this.rdE = false;
    this.rdF = false;
    this.mIsForeground = false;
    this.rdG = null;
    this.rdI = new Vector();
    this.rdJ = new Vector();
    this.rdK = new Vector();
    this.rdL = new HashSet();
    this.mNetWorkType = -1;
    this.rdN = 0L;
    this.rdO = 0L;
    this.rdP = new MTimerHandler(Looper.getMainLooper(), new MTimerHandler.CallBack()
    {
      public final boolean onTimerExpired()
      {
        AppMethodBeat.i(108753);
        long l1;
        long l2;
        if ((BKGLoaderManager.this.rdA) || (BKGLoaderManager.this.rdB) || (BKGLoaderManager.this.rdC))
        {
          l1 = TrafficStats.getUidTxBytes(BKGLoaderManager.this.Mr);
          l2 = TrafficStats.getUidRxBytes(BKGLoaderManager.this.Mr);
          long l3 = l1 - BKGLoaderManager.this.rdN + (l2 - BKGLoaderManager.this.rdO);
          Log.d("MicroMsg.BKGLoader.BKGLoaderManager", "delta of data: " + l3 / 1024L);
          if (l3 > 20480L) {
            break label127;
          }
          BKGLoaderManager.this.cGC();
        }
        for (;;)
        {
          AppMethodBeat.o(108753);
          return false;
          label127:
          BKGLoaderManager.this.rdN = l1;
          BKGLoaderManager.this.rdO = l2;
          BKGLoaderManager.this.rdP.startTimer(1000L);
        }
      }
    }, false);
    this.rdQ = new IListener() {};
    this.rdR = new IListener() {};
    this.rdH = paramb;
    this.Mr = Process.myUid();
    this.mNetWorkType = NetStatusUtil.getNetType(MMApplicationContext.getContext());
    AppMethodBeat.o(108757);
  }
  
  static boolean cFE()
  {
    AppMethodBeat.i(108768);
    if ((NetStatusUtil.is3G(MMApplicationContext.getContext())) || (NetStatusUtil.is4G(MMApplicationContext.getContext())) || (NetStatusUtil.is2G(MMApplicationContext.getContext())))
    {
      AppMethodBeat.o(108768);
      return true;
    }
    AppMethodBeat.o(108768);
    return false;
  }
  
  public static boolean cGF()
  {
    AppMethodBeat.i(108767);
    long l = SystemClock.uptimeMillis();
    try
    {
      NetworkInfo localNetworkInfo = ((ConnectivityManager)MMApplicationContext.getContext().getSystemService("connectivity")).getNetworkInfo(1);
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
        Log.i("MicroMsg.BKGLoader.BKGLoaderManager", "[isWifi] cost:%s", new Object[] { Long.valueOf(l) });
      }
      AppMethodBeat.o(108767);
    }
  }
  
  public final void amU(String paramString)
  {
    AppMethodBeat.i(108765);
    Log.i("MicroMsg.BKGLoader.BKGLoaderManager", "[cpan] task is ruing. key:%s", new Object[] { paramString });
    AppMethodBeat.o(108765);
  }
  
  public final void cGB()
  {
    try
    {
      AppMethodBeat.i(108761);
      if (this.rdI != null) {
        this.rdI.clear();
      }
      if (this.rdJ != null) {
        this.rdJ.clear();
      }
      if (this.rdK != null) {
        this.rdK.clear();
      }
      this.rdz = false;
      AppMethodBeat.o(108761);
      return;
    }
    finally {}
  }
  
  public final void cGC()
  {
    int i = 0;
    for (;;)
    {
      try
      {
        AppMethodBeat.i(108762);
        if ((NetStatusUtil.isWifi(MMApplicationContext.getContext())) || (EmojiSyncManager.awm())) {
          break label661;
        }
        if ((i == 0) && (!this.rdz)) {
          break label599;
        }
        if ((this.rdI != null) && (this.rdI.size() > 0))
        {
          this.rdF = e.apo();
          this.rdA = true;
          this.rdB = false;
          this.rdD = false;
          this.rdC = false;
          if (!this.rdF)
          {
            this.rdG = ((c)this.rdI.remove(0));
            this.rdG.a(this);
            this.rdH.rdv.execute(this.rdG);
            Log.i("MicroMsg.BKGLoader.BKGLoaderManager", "[cpan] tryToStart task is ruing. key:%s donwload list size:%d", new Object[] { this.rdG.getKey(), Integer.valueOf(this.rdI.size()) });
            cGE();
            if ((this.rdB) || (this.rdA)) {
              break label653;
            }
            if ((this.rdK == null) || (this.rdK.size() <= 0)) {
              break label586;
            }
            this.rdC = true;
            this.rdG = ((c)this.rdK.remove(0));
            this.rdG.a(this);
            this.rdH.rdv.execute(this.rdG);
            Log.i("MicroMsg.BKGLoader.BKGLoaderManager", "[cpan] tryToStart download store emoji task is runing. productID:%s size:%d", new Object[] { this.rdG.getKey(), Integer.valueOf(this.rdK.size()) });
            AppMethodBeat.o(108762);
            return;
          }
          Log.i("MicroMsg.BKGLoader.BKGLoaderManager", "[cpan] sdcard is full.");
          continue;
        }
        if (this.rdJ == null) {
          break label419;
        }
      }
      finally {}
      label653:
      label661:
      if (this.rdJ.size() > 0)
      {
        this.rdB = true;
        this.rdA = false;
        this.rdE = false;
        this.rdC = false;
        this.rdG = ((c)this.rdJ.remove(0));
        this.rdG.a(this);
        this.rdH.rdv.execute(this.rdG);
        Log.i("MicroMsg.BKGLoader.BKGLoaderManager", "[cpan] tryToStart task is ruing. key:%s upload list size:%d", new Object[] { this.rdG.getKey(), Integer.valueOf(this.rdJ.size()) });
        cGE();
      }
      else
      {
        label419:
        Log.i("MicroMsg.BKGLoader.BKGLoaderManager", "[cpan] tryToStart no task list .");
        if ((this.rdI == null) || (this.rdI.size() <= 0))
        {
          if ((this.rdA) && (this.mIsForeground)) {
            this.rdD = true;
          }
          this.rdA = false;
        }
        if ((this.rdJ == null) || (this.rdJ.size() <= 0))
        {
          if ((this.rdB) && (this.mIsForeground)) {
            this.rdE = true;
          }
          this.rdB = false;
        }
        if (((this.rdI == null) || (this.rdI.size() <= 0)) && ((this.rdJ == null) || (this.rdJ.size() <= 0)) && ((this.rdA) || (this.rdB)) && (this.mIsForeground))
        {
          this.rdB = false;
          this.rdA = false;
        }
        this.rdz = false;
        cGE();
        continue;
        label586:
        this.rdC = false;
        AppMethodBeat.o(108762);
        continue;
        label599:
        if (cFE())
        {
          Log.i("MicroMsg.BKGLoader.BKGLoaderManager", "[dz tryToStart is 3g or 4g]");
          this.rdA = false;
          this.rdB = false;
          this.rdD = false;
          this.rdC = false;
          cGE();
          AppMethodBeat.o(108762);
        }
        else
        {
          Log.i("MicroMsg.BKGLoader.BKGLoaderManager", "[dz tryToStart is not wifi, 3g nor 4g]");
          AppMethodBeat.o(108762);
          continue;
          i = 1;
        }
      }
    }
  }
  
  public final void cGD()
  {
    try
    {
      AppMethodBeat.i(108763);
      this.rdA = false;
      this.rdB = false;
      this.rdz = false;
      cGE();
      if (this.rdG != null) {
        this.rdG.cancel();
      }
      AppMethodBeat.o(108763);
      return;
    }
    finally {}
  }
  
  public final void cGE()
  {
    AppMethodBeat.i(108764);
    if ((this.rdL != null) && (this.rdL.size() > 0))
    {
      Iterator localIterator = this.rdL.iterator();
      while (localIterator.hasNext()) {
        localIterator.next();
      }
    }
    AppMethodBeat.o(108764);
  }
  
  public final void dh(List<c> paramList)
  {
    AppMethodBeat.i(108759);
    if (this.rdJ == null) {
      this.rdJ = new Vector();
    }
    if (paramList.size() > 0)
    {
      int j = paramList.size();
      int i = 0;
      if (i < j)
      {
        c localc = (c)paramList.get(i);
        if ((localc != null) && (!this.rdJ.contains(localc))) {
          this.rdJ.add(localc);
        }
        for (;;)
        {
          i += 1;
          break;
          Log.i("MicroMsg.BKGLoader.BKGLoaderManager", "[cpan] task is has exist:%s", new Object[] { localc.getKey() });
        }
      }
    }
    AppMethodBeat.o(108759);
  }
  
  public final void di(List<c> paramList)
  {
    for (;;)
    {
      int i;
      try
      {
        AppMethodBeat.i(108760);
        if (this.rdK == null) {
          this.rdK = new Vector();
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
        if ((this.rdG != null) && (this.rdG.equals(localObject)))
        {
          if (localObject == null)
          {
            localObject = "task is null";
            Log.i("MicroMsg.BKGLoader.BKGLoaderManager", "[cpan] currentTask equals task is has exist:%s", new Object[] { localObject });
          }
          else
          {
            localObject = ((c)localObject).getKey();
            continue;
          }
        }
        else if ((localObject != null) && (!this.rdK.contains(localObject))) {
          this.rdK.add(localObject);
        }
      }
      finally {}
      if (localObject == null) {}
      for (Object localObject = "task is null";; localObject = ((c)localObject).getKey())
      {
        Log.i("MicroMsg.BKGLoader.BKGLoaderManager", "[cpan] task is has exist:%s", new Object[] { localObject });
        break;
      }
      label199:
      AppMethodBeat.o(108760);
      return;
      i += 1;
    }
  }
  
  public final void m(String paramString, int paramInt, boolean paramBoolean)
  {
    for (;;)
    {
      try
      {
        AppMethodBeat.i(108766);
        Log.i("MicroMsg.BKGLoader.BKGLoaderManager", "[cpan] task is finish. key:%s success:%b", new Object[] { paramString, Boolean.valueOf(paramBoolean) });
        if ((this.rdG == null) || (Util.isNullOrNil(paramString)))
        {
          Log.e("MicroMsg.BKGLoader.BKGLoaderManager", "CurrentTask or key is null. or key is no equal crrentkey ");
          AppMethodBeat.o(108766);
          return;
        }
        if (this.rdI.contains(this.rdG))
        {
          this.rdI.remove(this.rdG);
          if (!paramBoolean) {
            break label332;
          }
          if ((paramInt == 2) || (this.rdL == null) || (this.rdL.size() <= 0)) {
            break label208;
          }
          paramString = this.rdL.iterator();
          if (!paramString.hasNext()) {
            break label208;
          }
          paramString.next();
          continue;
        }
        if (!this.rdJ.contains(this.rdG)) {
          break label179;
        }
      }
      finally {}
      this.rdJ.remove(this.rdG);
      continue;
      label179:
      if (this.rdK.contains(this.rdG))
      {
        this.rdK.remove(this.rdG);
        continue;
        label208:
        if ((this.rdG instanceof a))
        {
          paramString = ((a)this.rdG).rcD;
          paramString = j.auL().EQ(paramString);
          if (paramString != null)
          {
            paramString = paramString.iterator();
            for (long l = 0L; paramString.hasNext(); l = s.boW(((EmojiInfo)paramString.next()).hRM()) + l) {}
            Log.i("MicroMsg.BKGLoader.BKGLoaderManager", "download size is %s", new Object[] { Long.valueOf(l) });
            EmojiSyncManager.zl(l);
          }
        }
        for (;;)
        {
          if (paramInt != 2) {
            break label343;
          }
          this.rdP.startTimer(5000L);
          AppMethodBeat.o(108766);
          break;
          label332:
          Log.i("MicroMsg.BKGLoader.BKGLoaderManager", "retry later.");
        }
        label343:
        this.rdP.startTimer(1000L);
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
      h.RTc.aX(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(240155);
          int i = NetStatusUtil.getNetType(paramContext);
          if (BKGLoaderManager.this.mNetWorkType == i)
          {
            AppMethodBeat.o(240155);
            return;
          }
          Log.i("MicroMsg.BKGLoader.BKGLoaderManager", "[cpan] network change type:%d", new Object[] { Integer.valueOf(i) });
          if (BKGLoaderManager.cFE()) {
            BKGLoaderManager.this.cGD();
          }
          for (;;)
          {
            BKGLoaderManager.this.mNetWorkType = i;
            AppMethodBeat.o(240155);
            return;
            if (BKGLoaderManager.cGF()) {
              BKGLoaderManager.this.cGC();
            } else if (!NetStatusUtil.isConnected(MMApplicationContext.getContext())) {
              BKGLoaderManager.this.cGD();
            } else {
              BKGLoaderManager.this.cGE();
            }
          }
        }
      });
      AppMethodBeat.o(108756);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.emoji.sync.BKGLoaderManager
 * JD-Core Version:    0.7.0.1
 */