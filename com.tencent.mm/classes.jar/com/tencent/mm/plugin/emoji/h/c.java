package com.tencent.mm.plugin.emoji.h;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.Process;
import com.tencent.e.h;
import com.tencent.e.i;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.emoji.sync.a;
import com.tencent.mm.sdk.event.IListener;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.NetStatusUtil;
import com.tencent.mm.sdk.platformtools.Util;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;
import java.util.Vector;
import java.util.concurrent.Executor;

public final class c
  implements e
{
  private int acx;
  private final Object mLock;
  int mNetWorkType;
  private int uGE;
  private int uGF;
  public boolean uGG;
  boolean uGH;
  boolean uGI;
  public boolean uGJ;
  private boolean uGK;
  private d uGL;
  private b uGM;
  private Vector<d> uGN;
  private final List<d<?>> uGO;
  final Vector<d<?>> uGP;
  Set<a> uGQ;
  public a uGR;
  private long uGS;
  private long uGT;
  private Runnable uGU;
  public IListener uGV;
  public IListener uGW;
  
  public c(b paramb)
  {
    AppMethodBeat.i(108757);
    this.uGE = 0;
    this.uGF = 0;
    this.uGG = false;
    this.uGH = false;
    this.uGI = false;
    this.uGJ = false;
    this.uGK = false;
    this.uGL = null;
    this.mLock = new Object();
    this.uGN = new Vector();
    this.uGO = new LinkedList();
    this.uGP = new Vector();
    this.uGQ = new HashSet();
    this.mNetWorkType = -1;
    this.uGS = 0L;
    this.uGT = 0L;
    this.uGU = new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(255819);
        if ((c.this.uGH) || (c.this.uGI) || (c.this.uGJ)) {
          c.this.cVn();
        }
        AppMethodBeat.o(255819);
      }
    };
    this.uGV = new IListener() {};
    this.uGW = new c.3(this);
    this.uGM = paramb;
    this.acx = Process.myUid();
    this.mNetWorkType = NetStatusUtil.getNetType(MMApplicationContext.getContext());
    AppMethodBeat.o(108757);
  }
  
  private void cVp()
  {
    AppMethodBeat.i(108764);
    h.ZvG.bc(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(257058);
        if ((c.this.uGQ != null) && (c.this.uGQ.size() > 0))
        {
          Iterator localIterator = c.this.uGQ.iterator();
          while (localIterator.hasNext()) {
            ((a)localIterator.next()).aCT();
          }
        }
        AppMethodBeat.o(257058);
      }
    });
    AppMethodBeat.o(108764);
  }
  
  public final void auO(String paramString)
  {
    AppMethodBeat.i(108765);
    Log.i("MicroMsg.BKGLoader.BKGLoaderManager", "[cpan] task is ruing. key:%s", new Object[] { paramString });
    AppMethodBeat.o(108765);
  }
  
  public final void cVm()
  {
    try
    {
      AppMethodBeat.i(108761);
      if (this.uGN != null) {
        this.uGN.clear();
      }
      if (this.uGP != null) {
        this.uGP.clear();
      }
      this.uGO.clear();
      this.uGH = false;
      this.uGI = false;
      this.uGJ = false;
      AppMethodBeat.o(108761);
      return;
    }
    finally {}
  }
  
  public final void cVn()
  {
    for (;;)
    {
      try
      {
        AppMethodBeat.i(108762);
        Log.i("MicroMsg.BKGLoader.BKGLoaderManager", "tryToStart: %s", new Object[] { Boolean.valueOf(this.uGG) });
        if ((!NetStatusUtil.isWifi(MMApplicationContext.getContext())) && (!this.uGG) && (this.uGO.isEmpty())) {
          break label455;
        }
        if ((this.uGN != null) && (this.uGN.size() > 0))
        {
          this.uGI = true;
          this.uGH = false;
          this.uGK = false;
          this.uGJ = false;
          this.uGL = ((d)this.uGN.remove(0));
          this.uGL.a(this);
          this.uGM.uGC.execute(this.uGL);
          Log.i("MicroMsg.BKGLoader.BKGLoaderManager", "[cpan] tryToStart task is ruing. key:%s upload list size:%d", new Object[] { this.uGL.getKey(), Integer.valueOf(this.uGN.size()) });
          cVp();
          if ((this.uGI) || (this.uGH)) {
            break label505;
          }
          if (!this.uGO.isEmpty())
          {
            this.uGJ = true;
            this.uGL = ((d)this.uGO.remove(0));
            this.uGL.a(this);
            this.uGM.uGC.execute(this.uGL);
            cVp();
            AppMethodBeat.o(108762);
          }
        }
        else
        {
          Log.i("MicroMsg.BKGLoader.BKGLoaderManager", "[cpan] tryToStart no task list .");
          if ((this.uGN == null) || (this.uGN.size() <= 0))
          {
            if (this.uGI) {
              this.uGK = true;
            }
            this.uGI = false;
          }
          if (((this.uGN != null) && (this.uGN.size() > 0)) || ((!this.uGH) && (!this.uGI))) {
            continue;
          }
          this.uGI = false;
          this.uGH = false;
          continue;
        }
        if (this.uGP == null) {
          break label442;
        }
      }
      finally {}
      if (this.uGP.size() > 0)
      {
        this.uGJ = true;
        this.uGL = ((d)this.uGP.remove(0));
        this.uGL.a(this);
        this.uGM.uGC.execute(this.uGL);
        Log.i("MicroMsg.BKGLoader.BKGLoaderManager", "[cpan] tryToStart download store emoji task is runing. productID:%s size:%d", new Object[] { this.uGL.getKey(), Integer.valueOf(this.uGP.size()) });
      }
      else
      {
        label442:
        this.uGJ = false;
        this.uGG = false;
        continue;
        label455:
        if (NetStatusUtil.isConnected(MMApplicationContext.getContext()))
        {
          Log.i("MicroMsg.BKGLoader.BKGLoaderManager", "[dz tryToStart is 3g or 4g]");
          this.uGH = false;
          this.uGI = false;
          this.uGJ = false;
          cVp();
          AppMethodBeat.o(108762);
        }
        else
        {
          Log.i("MicroMsg.BKGLoader.BKGLoaderManager", "[dz tryToStart is not wifi, 3g nor 4g]");
          label505:
          AppMethodBeat.o(108762);
        }
      }
    }
  }
  
  public final void cVo()
  {
    try
    {
      AppMethodBeat.i(108763);
      this.uGH = false;
      this.uGI = false;
      this.uGJ = false;
      this.uGG = false;
      cVp();
      if (this.uGL != null) {
        this.uGL.cancel();
      }
      AppMethodBeat.o(108763);
      return;
    }
    finally {}
  }
  
  public final void dg(List<d> paramList)
  {
    AppMethodBeat.i(108759);
    if (this.uGN == null) {
      this.uGN = new Vector();
    }
    if (paramList.size() > 0)
    {
      int j = paramList.size();
      int i = 0;
      if (i < j)
      {
        d locald = (d)paramList.get(i);
        if ((locald != null) && (!this.uGN.contains(locald))) {
          this.uGN.add(locald);
        }
        for (;;)
        {
          i += 1;
          break;
          Log.i("MicroMsg.BKGLoader.BKGLoaderManager", "[cpan] task is has exist:%s", new Object[] { locald.getKey() });
        }
      }
    }
    AppMethodBeat.o(108759);
  }
  
  public final void dh(List<d<?>> paramList)
  {
    for (;;)
    {
      int i;
      try
      {
        AppMethodBeat.i(108760);
        if ((paramList == null) || (paramList.size() <= 0)) {
          break label181;
        }
        int j = paramList.size();
        i = 0;
        if (i >= j) {
          break label181;
        }
        localObject = (d)paramList.get(i);
        if ((this.uGL != null) && (this.uGL.equals(localObject)))
        {
          if (localObject == null)
          {
            localObject = "task is null";
            Log.i("MicroMsg.BKGLoader.BKGLoaderManager", "[cpan] currentTask equals task is has exist:%s", new Object[] { localObject });
          }
          else
          {
            localObject = ((d)localObject).getKey();
            continue;
          }
        }
        else if ((localObject != null) && (!this.uGP.contains(localObject))) {
          this.uGP.add(localObject);
        }
      }
      finally {}
      if (localObject == null) {}
      for (Object localObject = "task is null";; localObject = ((d)localObject).getKey())
      {
        Log.i("MicroMsg.BKGLoader.BKGLoaderManager", "[cpan] task is has exist:%s", new Object[] { localObject });
        break;
      }
      label181:
      AppMethodBeat.o(108760);
      return;
      i += 1;
    }
  }
  
  public final void di(List<d<?>> paramList)
  {
    label143:
    for (;;)
    {
      try
      {
        AppMethodBeat.i(257285);
        Iterator localIterator1 = paramList.iterator();
        if (localIterator1.hasNext())
        {
          d locald1 = (d)localIterator1.next();
          Iterator localIterator2 = this.uGO.iterator();
          int i = 0;
          if (localIterator2.hasNext())
          {
            d locald2 = (d)localIterator2.next();
            if (!Util.isEqual(locald1.getKey(), locald2.getKey())) {
              break label143;
            }
            i = 1;
            break label143;
          }
          if (i != 0) {
            continue;
          }
          this.uGO.addAll(paramList);
          Log.i("MicroMsg.BKGLoader.BKGLoaderManager", "addNoWifiTask: %s", new Object[] { locald1.getKey() });
          continue;
        }
        AppMethodBeat.o(257285);
      }
      finally {}
      return;
    }
  }
  
  public final void e(a parama)
  {
    AppMethodBeat.i(257290);
    if (this.uGQ == null) {
      this.uGQ = new HashSet();
    }
    if (!this.uGQ.contains(parama)) {
      this.uGQ.add(parama);
    }
    AppMethodBeat.o(257290);
  }
  
  public final void f(a parama)
  {
    AppMethodBeat.i(257292);
    if (this.uGQ == null) {
      this.uGQ = new HashSet();
    }
    if (this.uGQ.contains(parama)) {
      this.uGQ.remove(parama);
    }
    AppMethodBeat.o(257292);
  }
  
  public final void q(String paramString, final int paramInt, boolean paramBoolean)
  {
    for (;;)
    {
      try
      {
        AppMethodBeat.i(108766);
        Log.i("MicroMsg.BKGLoader.BKGLoaderManager", "[cpan] task is finish. key:%s success:%b", new Object[] { paramString, Boolean.valueOf(paramBoolean) });
        if ((this.uGL == null) || (Util.isNullOrNil(paramString)))
        {
          Log.e("MicroMsg.BKGLoader.BKGLoaderManager", "CurrentTask or key is null. or key is no equal crrentkey ");
          AppMethodBeat.o(108766);
          return;
        }
        if (this.uGN.contains(this.uGL))
        {
          this.uGN.remove(this.uGL);
          if (!paramBoolean) {
            break label212;
          }
          if (paramInt != 2) {
            h.ZvG.bc(new Runnable()
            {
              public final void run()
              {
                AppMethodBeat.i(256927);
                if ((c.this.uGQ != null) && (c.this.uGQ.size() > 0))
                {
                  Iterator localIterator = c.this.uGQ.iterator();
                  while (localIterator.hasNext()) {
                    localIterator.next();
                  }
                }
                AppMethodBeat.o(256927);
              }
            });
          }
          if (paramInt != 2) {
            break label223;
          }
          h.ZvG.o(this.uGU, 3000L);
          AppMethodBeat.o(108766);
          continue;
        }
        if (!this.uGO.contains(this.uGL)) {
          break label183;
        }
      }
      finally {}
      this.uGO.remove(this.uGL);
      continue;
      label183:
      if (this.uGP.contains(this.uGL))
      {
        this.uGP.remove(this.uGL);
        continue;
        label212:
        Log.i("MicroMsg.BKGLoader.BKGLoaderManager", "retry later.");
        continue;
        label223:
        h.ZvG.o(this.uGU, 1000L);
        AppMethodBeat.o(108766);
      }
    }
  }
  
  public final class a
    extends BroadcastReceiver
  {
    public a() {}
    
    public final void onReceive(final Context paramContext, Intent paramIntent)
    {
      AppMethodBeat.i(108756);
      h.ZvG.be(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(257391);
          int i = NetStatusUtil.getNetType(paramContext);
          Log.i("MicroMsg.BKGLoader.BKGLoaderManager", "[cpan] network change type:%d", new Object[] { Integer.valueOf(i) });
          if (c.this.mNetWorkType == i)
          {
            AppMethodBeat.o(257391);
            return;
          }
          if ((c.this.uGG) || (NetStatusUtil.isWifi(MMApplicationContext.getContext()))) {
            if (!c.this.uGJ) {
              c.this.cVn();
            }
          }
          for (;;)
          {
            c.this.mNetWorkType = i;
            AppMethodBeat.o(257391);
            return;
            c.this.cVo();
          }
        }
      });
      AppMethodBeat.o(108756);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.emoji.h.c
 * JD-Core Version:    0.7.0.1
 */