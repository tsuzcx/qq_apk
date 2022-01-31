package com.tencent.mm.plugin.emoji.sync;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Looper;
import android.os.Process;
import android.os.SystemClock;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.compatible.util.f;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.ap;
import com.tencent.mm.sdk.platformtools.at;
import com.tencent.mm.sdk.platformtools.bo;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.Vector;
import java.util.concurrent.Executor;

public final class BKGLoaderManager
  implements d
{
  public boolean bNX;
  int fDr;
  public com.tencent.mm.sdk.b.c ljA;
  public com.tencent.mm.sdk.b.c ljB;
  private int ljh;
  private int lji;
  private boolean ljj;
  boolean ljk;
  boolean ljl;
  public boolean ljm;
  public boolean ljn;
  private boolean ljo;
  private boolean ljp;
  private c ljq;
  private b ljr;
  private Vector<c> ljs;
  private Vector<c> ljt;
  private Vector<c> lju;
  private Set<Object> ljv;
  public BKGLoaderManager.ConnectivityReceiver ljw;
  long ljx;
  long ljy;
  ap ljz;
  int mNetWorkType;
  
  public BKGLoaderManager(b paramb)
  {
    AppMethodBeat.i(53186);
    this.ljh = 0;
    this.lji = 0;
    this.ljj = false;
    this.ljk = false;
    this.ljl = false;
    this.ljm = false;
    this.ljn = false;
    this.ljo = false;
    this.ljp = false;
    this.bNX = false;
    this.ljq = null;
    this.ljs = new Vector();
    this.ljt = new Vector();
    this.lju = new Vector();
    this.ljv = new HashSet();
    this.mNetWorkType = -1;
    this.ljx = 0L;
    this.ljy = 0L;
    this.ljz = new ap(Looper.getMainLooper(), new BKGLoaderManager.1(this), false);
    this.ljA = new BKGLoaderManager.2(this);
    this.ljB = new BKGLoaderManager.3(this);
    this.ljr = paramb;
    this.fDr = Process.myUid();
    this.mNetWorkType = at.getNetType(ah.getContext());
    AppMethodBeat.o(53186);
  }
  
  static boolean bkO()
  {
    AppMethodBeat.i(53197);
    if ((at.is3G(ah.getContext())) || (at.is4G(ah.getContext())) || (at.is2G(ah.getContext())))
    {
      AppMethodBeat.o(53197);
      return true;
    }
    AppMethodBeat.o(53197);
    return false;
  }
  
  public static boolean blP()
  {
    AppMethodBeat.i(53196);
    long l = SystemClock.uptimeMillis();
    try
    {
      NetworkInfo localNetworkInfo = ((ConnectivityManager)ah.getContext().getSystemService("connectivity")).getNetworkInfo(1);
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
        ab.i("MicroMsg.BKGLoader.BKGLoaderManager", "[isWifi] cost:%s", new Object[] { Long.valueOf(l) });
      }
      AppMethodBeat.o(53196);
    }
  }
  
  public final void KX(String paramString)
  {
    AppMethodBeat.i(53194);
    ab.i("MicroMsg.BKGLoader.BKGLoaderManager", "[cpan] task is ruing. key:%s", new Object[] { paramString });
    AppMethodBeat.o(53194);
  }
  
  public final void blL()
  {
    try
    {
      AppMethodBeat.i(53190);
      if (this.ljs != null) {
        this.ljs.clear();
      }
      if (this.ljt != null) {
        this.ljt.clear();
      }
      if (this.lju != null) {
        this.lju.clear();
      }
      this.ljj = false;
      AppMethodBeat.o(53190);
      return;
    }
    finally {}
  }
  
  public final void blM()
  {
    for (;;)
    {
      try
      {
        AppMethodBeat.i(53191);
        if ((!at.isWifi(ah.getContext())) && (!this.ljj)) {
          break label584;
        }
        if ((this.ljs != null) && (this.ljs.size() > 0))
        {
          this.ljp = f.Mj();
          this.ljk = true;
          this.ljl = false;
          this.ljn = false;
          this.ljm = false;
          if (!this.ljp)
          {
            this.ljq = ((c)this.ljs.remove(0));
            this.ljq.a(this);
            this.ljr.ljg.execute(this.ljq);
            ab.i("MicroMsg.BKGLoader.BKGLoaderManager", "[cpan] tryToStart task is ruing. key:%s donwload list size:%d", new Object[] { this.ljq.getKey(), Integer.valueOf(this.ljs.size()) });
            blO();
            if ((this.ljl) || (this.ljk)) {
              break label638;
            }
            if ((this.lju == null) || (this.lju.size() <= 0)) {
              break label571;
            }
            this.ljm = true;
            this.ljq = ((c)this.lju.remove(0));
            this.ljq.a(this);
            this.ljr.ljg.execute(this.ljq);
            ab.i("MicroMsg.BKGLoader.BKGLoaderManager", "[cpan] tryToStart download store emoji task is runing. productID:%s size:%d", new Object[] { this.ljq.getKey(), Integer.valueOf(this.lju.size()) });
            AppMethodBeat.o(53191);
            return;
          }
          ab.i("MicroMsg.BKGLoader.BKGLoaderManager", "[cpan] sdcard is full.");
          continue;
        }
        if (this.ljt == null) {
          break label404;
        }
      }
      finally {}
      if (this.ljt.size() > 0)
      {
        this.ljl = true;
        this.ljk = false;
        this.ljo = false;
        this.ljm = false;
        this.ljq = ((c)this.ljt.remove(0));
        this.ljq.a(this);
        this.ljr.ljg.execute(this.ljq);
        ab.i("MicroMsg.BKGLoader.BKGLoaderManager", "[cpan] tryToStart task is ruing. key:%s upload list size:%d", new Object[] { this.ljq.getKey(), Integer.valueOf(this.ljt.size()) });
        blO();
      }
      else
      {
        label404:
        ab.i("MicroMsg.BKGLoader.BKGLoaderManager", "[cpan] tryToStart no task list .");
        if ((this.ljs == null) || (this.ljs.size() <= 0))
        {
          if ((this.ljk) && (this.bNX)) {
            this.ljn = true;
          }
          this.ljk = false;
        }
        if ((this.ljt == null) || (this.ljt.size() <= 0))
        {
          if ((this.ljl) && (this.bNX)) {
            this.ljo = true;
          }
          this.ljl = false;
        }
        if (((this.ljs == null) || (this.ljs.size() <= 0)) && ((this.ljt == null) || (this.ljt.size() <= 0)) && ((this.ljk) || (this.ljl)) && (this.bNX))
        {
          this.ljl = false;
          this.ljk = false;
        }
        this.ljj = false;
        blO();
        continue;
        label571:
        this.ljm = false;
        AppMethodBeat.o(53191);
        continue;
        label584:
        if (bkO())
        {
          ab.i("MicroMsg.BKGLoader.BKGLoaderManager", "[dz tryToStart is 3g or 4g]");
          this.ljk = false;
          this.ljl = false;
          this.ljn = false;
          this.ljm = false;
          blO();
          AppMethodBeat.o(53191);
        }
        else
        {
          ab.i("MicroMsg.BKGLoader.BKGLoaderManager", "[dz tryToStart is not wifi, 3g nor 4g]");
          label638:
          AppMethodBeat.o(53191);
        }
      }
    }
  }
  
  public final void blN()
  {
    try
    {
      AppMethodBeat.i(53192);
      this.ljk = false;
      this.ljl = false;
      this.ljj = false;
      blO();
      if (this.ljq != null) {
        this.ljq.cancel();
      }
      AppMethodBeat.o(53192);
      return;
    }
    finally {}
  }
  
  public final void blO()
  {
    AppMethodBeat.i(53193);
    if ((this.ljv != null) && (this.ljv.size() > 0))
    {
      Iterator localIterator = this.ljv.iterator();
      while (localIterator.hasNext()) {
        localIterator.next();
      }
    }
    AppMethodBeat.o(53193);
  }
  
  public final void bp(List<c> paramList)
  {
    AppMethodBeat.i(53187);
    this.ljj = false;
    if (this.ljs == null) {
      this.ljs = new Vector();
    }
    if (paramList.size() > 0)
    {
      int j = paramList.size();
      int i = 0;
      if (i < j)
      {
        c localc = (c)paramList.get(i);
        if ((localc != null) && (!this.ljs.contains(localc))) {
          this.ljs.add(localc);
        }
        for (;;)
        {
          i += 1;
          break;
          ab.i("MicroMsg.BKGLoader.BKGLoaderManager", "[cpan] task is has exist.:%s", new Object[] { localc.getKey() });
        }
      }
    }
    AppMethodBeat.o(53187);
  }
  
  public final void bq(List<c> paramList)
  {
    AppMethodBeat.i(53188);
    if (this.ljt == null) {
      this.ljt = new Vector();
    }
    if (paramList.size() > 0)
    {
      int j = paramList.size();
      int i = 0;
      if (i < j)
      {
        c localc = (c)paramList.get(i);
        if ((localc != null) && (!this.ljt.contains(localc))) {
          this.ljt.add(localc);
        }
        for (;;)
        {
          i += 1;
          break;
          ab.i("MicroMsg.BKGLoader.BKGLoaderManager", "[cpan] task is has exist:%s", new Object[] { localc.getKey() });
        }
      }
    }
    AppMethodBeat.o(53188);
  }
  
  public final void br(List<c> paramList)
  {
    for (;;)
    {
      int i;
      try
      {
        AppMethodBeat.i(53189);
        if (this.lju == null) {
          this.lju = new Vector();
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
        if ((this.ljq != null) && (this.ljq.equals(localObject)))
        {
          if (localObject == null)
          {
            localObject = "task is null";
            ab.i("MicroMsg.BKGLoader.BKGLoaderManager", "[cpan] currentTask equals task is has exist:%s", new Object[] { localObject });
          }
          else
          {
            localObject = ((c)localObject).getKey();
            continue;
          }
        }
        else if ((localObject != null) && (!this.lju.contains(localObject))) {
          this.lju.add(localObject);
        }
      }
      finally {}
      if (localObject == null) {}
      for (Object localObject = "task is null";; localObject = ((c)localObject).getKey())
      {
        ab.i("MicroMsg.BKGLoader.BKGLoaderManager", "[cpan] task is has exist:%s", new Object[] { localObject });
        break;
      }
      label199:
      AppMethodBeat.o(53189);
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
        AppMethodBeat.i(53195);
        ab.i("MicroMsg.BKGLoader.BKGLoaderManager", "[cpan] task is finish. key:%s success:%b", new Object[] { paramString, Boolean.valueOf(paramBoolean) });
        if ((this.ljq == null) || (bo.isNullOrNil(paramString)))
        {
          ab.e("MicroMsg.BKGLoader.BKGLoaderManager", "CurrentTask or key is null. or key is no equal crrentkey ");
          AppMethodBeat.o(53195);
          return;
        }
        if (this.ljs.contains(this.ljq))
        {
          this.ljs.remove(this.ljq);
          if (!paramBoolean) {
            break label208;
          }
          if ((paramInt == 2) || (this.ljv == null) || (this.ljv.size() <= 0)) {
            break label216;
          }
          paramString = this.ljv.iterator();
          if (!paramString.hasNext()) {
            break label216;
          }
          paramString.next();
          continue;
        }
        if (!this.ljt.contains(this.ljq)) {
          break label179;
        }
      }
      finally {}
      this.ljt.remove(this.ljq);
      continue;
      label179:
      if (this.lju.contains(this.ljq))
      {
        this.lju.remove(this.ljq);
        continue;
        label208:
        ab.i("MicroMsg.BKGLoader.BKGLoaderManager", "retry later.");
        label216:
        if (paramInt == 2)
        {
          this.ljz.ag(5000L, 5000L);
          AppMethodBeat.o(53195);
        }
        else
        {
          this.ljz.ag(1000L, 1000L);
          AppMethodBeat.o(53195);
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.emoji.sync.BKGLoaderManager
 * JD-Core Version:    0.7.0.1
 */