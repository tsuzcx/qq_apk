package com.tencent.mm.plugin.emoji.sync;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Looper;
import android.os.Process;
import com.tencent.mm.compatible.util.f;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.am;
import com.tencent.mm.sdk.platformtools.aq;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.sdk.platformtools.y;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.Vector;
import java.util.concurrent.Executor;

public final class BKGLoaderManager
  implements e
{
  boolean bqV = false;
  int emU;
  public boolean jaA = false;
  boolean jaB = false;
  boolean jaC = false;
  public boolean jaD = false;
  public boolean jaE = false;
  private boolean jaF = false;
  boolean jaG = false;
  d jaH = null;
  private b jaI;
  Vector<d> jaJ = new Vector();
  Vector<d> jaK = new Vector();
  Vector<d> jaL = new Vector();
  public Set<c> jaM = new HashSet();
  public BKGLoaderManager.ConnectivityReceiver jaN;
  long jaO = 0L;
  long jaP = 0L;
  am jaQ = new am(Looper.getMainLooper(), new BKGLoaderManager.1(this), false);
  public com.tencent.mm.sdk.b.c jaR = new BKGLoaderManager.2(this);
  public com.tencent.mm.sdk.b.c jaS = new BKGLoaderManager.3(this);
  public int jay = 0;
  private int jaz = 0;
  int mNetWorkType = -1;
  
  public BKGLoaderManager(b paramb)
  {
    this.jaI = paramb;
    this.emU = Process.myUid();
    this.mNetWorkType = aq.getNetType(ae.getContext());
  }
  
  public static boolean aHa()
  {
    return (aq.is3G(ae.getContext())) || (aq.is4G(ae.getContext())) || (aq.is2G(ae.getContext()));
  }
  
  public static boolean aIq()
  {
    NetworkInfo localNetworkInfo = ((ConnectivityManager)ae.getContext().getSystemService("connectivity")).getNetworkInfo(1);
    if (localNetworkInfo != null) {
      return localNetworkInfo.isConnected();
    }
    return false;
  }
  
  public final void AV(String paramString)
  {
    y.i("MicroMsg.BKGLoader.BKGLoaderManager", "[cpan] task is ruing. key:%s", new Object[] { paramString });
  }
  
  public final void aIn()
  {
    for (;;)
    {
      try
      {
        if ((!aq.isWifi(ae.getContext())) && (!this.jaA)) {
          break label564;
        }
        if ((this.jaJ != null) && (this.jaJ.size() > 0))
        {
          this.jaG = f.zG();
          this.jaB = true;
          this.jaC = false;
          this.jaE = false;
          this.jaD = false;
          if (!this.jaG)
          {
            this.jaH = ((d)this.jaJ.remove(0));
            this.jaH.a(this);
            this.jaI.jaw.execute(this.jaH);
            y.i("MicroMsg.BKGLoader.BKGLoaderManager", "[cpan] tryToStart task is ruing. key:%s donwload list size:%d", new Object[] { this.jaH.getKey(), Integer.valueOf(this.jaJ.size()) });
            aIp();
            if ((!this.jaC) && (!this.jaB))
            {
              if ((this.jaL == null) || (this.jaL.size() <= 0)) {
                break label556;
              }
              this.jaD = true;
              this.jaH = ((d)this.jaL.remove(0));
              this.jaH.a(this);
              this.jaI.jaw.execute(this.jaH);
              y.i("MicroMsg.BKGLoader.BKGLoaderManager", "[cpan] tryToStart download store emoji task is runing. productID:%s size:%d", new Object[] { this.jaH.getKey(), Integer.valueOf(this.jaL.size()) });
            }
            return;
          }
          y.i("MicroMsg.BKGLoader.BKGLoaderManager", "[cpan] sdcard is full.");
          continue;
        }
        if (this.jaK == null) {
          break label390;
        }
      }
      finally {}
      if (this.jaK.size() > 0)
      {
        this.jaC = true;
        this.jaB = false;
        this.jaF = false;
        this.jaD = false;
        this.jaH = ((d)this.jaK.remove(0));
        this.jaH.a(this);
        this.jaI.jaw.execute(this.jaH);
        y.i("MicroMsg.BKGLoader.BKGLoaderManager", "[cpan] tryToStart task is ruing. key:%s upload list size:%d", new Object[] { this.jaH.getKey(), Integer.valueOf(this.jaK.size()) });
        aIp();
      }
      else
      {
        label390:
        y.i("MicroMsg.BKGLoader.BKGLoaderManager", "[cpan] tryToStart no task list .");
        if ((this.jaJ == null) || (this.jaJ.size() <= 0))
        {
          if ((this.jaB) && (this.bqV)) {
            this.jaE = true;
          }
          this.jaB = false;
        }
        if ((this.jaK == null) || (this.jaK.size() <= 0))
        {
          if ((this.jaC) && (this.bqV)) {
            this.jaF = true;
          }
          this.jaC = false;
        }
        if (((this.jaJ == null) || (this.jaJ.size() <= 0)) && ((this.jaK == null) || (this.jaK.size() <= 0)) && ((this.jaB) || (this.jaC)) && (this.bqV))
        {
          this.jaC = false;
          this.jaB = false;
        }
        this.jaA = false;
        aIp();
        continue;
        label556:
        this.jaD = false;
        continue;
        label564:
        if (aHa())
        {
          y.i("MicroMsg.BKGLoader.BKGLoaderManager", "[dz tryToStart is 3g or 4g]");
          this.jaB = false;
          this.jaC = false;
          this.jaE = false;
          this.jaD = false;
          aIp();
        }
        else
        {
          y.i("MicroMsg.BKGLoader.BKGLoaderManager", "[dz tryToStart is not wifi, 3g nor 4g]");
        }
      }
    }
  }
  
  public final void aIo()
  {
    this.jaB = false;
    this.jaC = false;
    this.jaA = false;
    aIp();
    if (this.jaH != null) {
      this.jaH.cancel();
    }
  }
  
  public final void aIp()
  {
    if ((this.jaM != null) && (this.jaM.size() > 0))
    {
      Iterator localIterator = this.jaM.iterator();
      while (localIterator.hasNext()) {
        ((c)localIterator.next()).aIr();
      }
    }
  }
  
  public final void bOE()
  {
    try
    {
      if (this.jaJ != null) {
        this.jaJ.clear();
      }
      if (this.jaK != null) {
        this.jaK.clear();
      }
      if (this.jaL != null) {
        this.jaL.clear();
      }
      this.jaA = false;
      return;
    }
    finally {}
  }
  
  public final void ba(List<d> paramList)
  {
    if (this.jaK == null) {
      this.jaK = new Vector();
    }
    if (paramList.size() > 0)
    {
      int j = paramList.size();
      int i = 0;
      if (i < j)
      {
        d locald = (d)paramList.get(i);
        if ((locald != null) && (!this.jaK.contains(locald))) {
          this.jaK.add(locald);
        }
        for (;;)
        {
          i += 1;
          break;
          y.i("MicroMsg.BKGLoader.BKGLoaderManager", "[cpan] task is has exist:%s", new Object[] { locald.getKey() });
        }
      }
    }
  }
  
  public final void m(String paramString, int paramInt, boolean paramBoolean)
  {
    for (;;)
    {
      try
      {
        y.i("MicroMsg.BKGLoader.BKGLoaderManager", "[cpan] task is finish. key:%s success:%b", new Object[] { paramString, Boolean.valueOf(paramBoolean) });
        if ((this.jaH == null) || (bk.bl(paramString)))
        {
          y.e("MicroMsg.BKGLoader.BKGLoaderManager", "CurrentTask or key is null. or key is no equal crrentkey ");
          return;
        }
        if (this.jaJ.contains(this.jaH))
        {
          this.jaJ.remove(this.jaH);
          if (!paramBoolean) {
            break label203;
          }
          if ((paramInt == 2) || (this.jaM == null) || (this.jaM.size() <= 0)) {
            break label211;
          }
          paramString = this.jaM.iterator();
          if (!paramString.hasNext()) {
            break label211;
          }
          ((c)paramString.next()).aIs();
          continue;
        }
        if (!this.jaK.contains(this.jaH)) {
          break label174;
        }
      }
      finally {}
      this.jaK.remove(this.jaH);
      continue;
      label174:
      if (this.jaL.contains(this.jaH))
      {
        this.jaL.remove(this.jaH);
        continue;
        label203:
        y.i("MicroMsg.BKGLoader.BKGLoaderManager", "retry later.");
        label211:
        if (paramInt == 2) {
          this.jaQ.S(5000L, 5000L);
        } else {
          this.jaQ.S(1000L, 1000L);
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.emoji.sync.BKGLoaderManager
 * JD-Core Version:    0.7.0.1
 */