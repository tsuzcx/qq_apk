package com.tencent.mm.plugin.emoji.sync;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.Process;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.app.f;
import com.tencent.mm.emoji.sync.a;
import com.tencent.mm.sdk.event.IListener;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.NetStatusUtil;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.threadpool.h;
import com.tencent.threadpool.i;
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
  private int bKg;
  private final Object mLock;
  int mNetWorkType;
  private Runnable xPA;
  public IListener xPB;
  public IListener xPC;
  private int xPk;
  private int xPl;
  public boolean xPm;
  boolean xPn;
  boolean xPo;
  public boolean xPp;
  private boolean xPq;
  private d xPr;
  private b xPs;
  private Vector<d> xPt;
  private final List<d<?>> xPu;
  final Vector<d<?>> xPv;
  Set<a> xPw;
  public a xPx;
  private long xPy;
  private long xPz;
  
  public c(b paramb)
  {
    AppMethodBeat.i(108757);
    this.xPk = 0;
    this.xPl = 0;
    this.xPm = false;
    this.xPn = false;
    this.xPo = false;
    this.xPp = false;
    this.xPq = false;
    this.xPr = null;
    this.mLock = new Object();
    this.xPt = new Vector();
    this.xPu = new LinkedList();
    this.xPv = new Vector();
    this.xPw = new HashSet();
    this.mNetWorkType = -1;
    this.xPy = 0L;
    this.xPz = 0L;
    this.xPA = new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(269796);
        if ((c.this.xPn) || (c.this.xPo) || (c.this.xPp)) {
          c.this.dAN();
        }
        AppMethodBeat.o(269796);
      }
    };
    this.xPB = new BKGLoaderManager.2(this, f.hfK);
    this.xPC = new BKGLoaderManager.3(this, f.hfK);
    this.xPs = paramb;
    this.bKg = Process.myUid();
    this.mNetWorkType = NetStatusUtil.getNetType(MMApplicationContext.getContext());
    AppMethodBeat.o(108757);
  }
  
  private void dAP()
  {
    AppMethodBeat.i(108764);
    h.ahAA.bk(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(269802);
        if ((c.this.xPw != null) && (c.this.xPw.size() > 0))
        {
          Iterator localIterator = c.this.xPw.iterator();
          while (localIterator.hasNext()) {
            ((a)localIterator.next()).aVR();
          }
        }
        AppMethodBeat.o(269802);
      }
    });
    AppMethodBeat.o(108764);
  }
  
  public final void aoN(String paramString)
  {
    AppMethodBeat.i(108765);
    Log.i("MicroMsg.BKGLoader.BKGLoaderManager", "[cpan] task is ruing. key:%s", new Object[] { paramString });
    AppMethodBeat.o(108765);
  }
  
  public final void dAM()
  {
    try
    {
      AppMethodBeat.i(108761);
      if (this.xPt != null) {
        this.xPt.clear();
      }
      if (this.xPv != null) {
        this.xPv.clear();
      }
      this.xPu.clear();
      this.xPn = false;
      this.xPo = false;
      this.xPp = false;
      AppMethodBeat.o(108761);
      return;
    }
    finally {}
  }
  
  public final void dAN()
  {
    for (;;)
    {
      try
      {
        AppMethodBeat.i(108762);
        Log.i("MicroMsg.BKGLoader.BKGLoaderManager", "tryToStart: %s", new Object[] { Boolean.valueOf(this.xPm) });
        if ((!NetStatusUtil.isWifi(MMApplicationContext.getContext())) && (!this.xPm) && (this.xPu.isEmpty())) {
          break label455;
        }
        if ((this.xPt != null) && (this.xPt.size() > 0))
        {
          this.xPo = true;
          this.xPn = false;
          this.xPq = false;
          this.xPp = false;
          this.xPr = ((d)this.xPt.remove(0));
          this.xPr.a(this);
          this.xPs.xPi.execute(this.xPr);
          Log.i("MicroMsg.BKGLoader.BKGLoaderManager", "[cpan] tryToStart task is ruing. key:%s upload list size:%d", new Object[] { this.xPr.getKey(), Integer.valueOf(this.xPt.size()) });
          dAP();
          if ((this.xPo) || (this.xPn)) {
            break label507;
          }
          if (!this.xPu.isEmpty())
          {
            this.xPp = true;
            this.xPr = ((d)this.xPu.remove(0));
            this.xPr.a(this);
            this.xPs.xPi.execute(this.xPr);
            dAP();
            AppMethodBeat.o(108762);
          }
        }
        else
        {
          Log.i("MicroMsg.BKGLoader.BKGLoaderManager", "[cpan] tryToStart no task list .");
          if ((this.xPt == null) || (this.xPt.size() <= 0))
          {
            if (this.xPo) {
              this.xPq = true;
            }
            this.xPo = false;
          }
          if (((this.xPt != null) && (this.xPt.size() > 0)) || ((!this.xPn) && (!this.xPo))) {
            continue;
          }
          this.xPo = false;
          this.xPn = false;
          continue;
        }
        if (this.xPv == null) {
          break label442;
        }
      }
      finally {}
      if (this.xPv.size() > 0)
      {
        this.xPp = true;
        this.xPr = ((d)this.xPv.remove(0));
        this.xPr.a(this);
        this.xPs.xPi.execute(this.xPr);
        Log.i("MicroMsg.BKGLoader.BKGLoaderManager", "[cpan] tryToStart download store emoji task is runing. productID:%s size:%d", new Object[] { this.xPr.getKey(), Integer.valueOf(this.xPv.size()) });
      }
      else
      {
        label442:
        this.xPp = false;
        this.xPm = false;
        continue;
        label455:
        if (NetStatusUtil.isConnected(MMApplicationContext.getContext()))
        {
          Log.i("MicroMsg.BKGLoader.BKGLoaderManager", "[dz tryToStart is 3g or 4g]");
          this.xPn = false;
          this.xPo = false;
          this.xPp = false;
          dAP();
          AppMethodBeat.o(108762);
        }
        else
        {
          Log.i("MicroMsg.BKGLoader.BKGLoaderManager", "[dz tryToStart is not wifi, 3g nor 4g]");
          label507:
          AppMethodBeat.o(108762);
        }
      }
    }
  }
  
  public final void dAO()
  {
    try
    {
      AppMethodBeat.i(108763);
      this.xPn = false;
      this.xPo = false;
      this.xPp = false;
      this.xPm = false;
      dAP();
      if (this.xPr != null) {
        this.xPr.cancel();
      }
      AppMethodBeat.o(108763);
      return;
    }
    finally {}
  }
  
  public final void e(a parama)
  {
    AppMethodBeat.i(269812);
    if (this.xPw == null) {
      this.xPw = new HashSet();
    }
    if (!this.xPw.contains(parama)) {
      this.xPw.add(parama);
    }
    AppMethodBeat.o(269812);
  }
  
  public final void f(a parama)
  {
    AppMethodBeat.i(269813);
    if (this.xPw == null) {
      this.xPw = new HashSet();
    }
    if (this.xPw.contains(parama)) {
      this.xPw.remove(parama);
    }
    AppMethodBeat.o(269813);
  }
  
  public final void fc(List<d> paramList)
  {
    AppMethodBeat.i(108759);
    if (this.xPt == null) {
      this.xPt = new Vector();
    }
    if (paramList.size() > 0)
    {
      int j = paramList.size();
      int i = 0;
      if (i < j)
      {
        d locald = (d)paramList.get(i);
        if ((locald != null) && (!this.xPt.contains(locald))) {
          this.xPt.add(locald);
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
  
  public final void fd(List<d<?>> paramList)
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
        if ((this.xPr != null) && (this.xPr.equals(localObject)))
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
        else if ((localObject != null) && (!this.xPv.contains(localObject))) {
          this.xPv.add(localObject);
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
  
  public final void fe(List<d<?>> paramList)
  {
    label143:
    for (;;)
    {
      try
      {
        AppMethodBeat.i(269800);
        Iterator localIterator1 = paramList.iterator();
        if (localIterator1.hasNext())
        {
          d locald1 = (d)localIterator1.next();
          Iterator localIterator2 = this.xPu.iterator();
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
          this.xPu.addAll(paramList);
          Log.i("MicroMsg.BKGLoader.BKGLoaderManager", "addNoWifiTask: %s", new Object[] { locald1.getKey() });
          continue;
        }
        AppMethodBeat.o(269800);
      }
      finally {}
      return;
    }
  }
  
  public final void r(String paramString, final int paramInt, boolean paramBoolean)
  {
    for (;;)
    {
      try
      {
        AppMethodBeat.i(108766);
        Log.i("MicroMsg.BKGLoader.BKGLoaderManager", "[cpan] task is finish. key:%s success:%b", new Object[] { paramString, Boolean.valueOf(paramBoolean) });
        if ((this.xPr == null) || (Util.isNullOrNil(paramString)))
        {
          Log.e("MicroMsg.BKGLoader.BKGLoaderManager", "CurrentTask or key is null. or key is no equal crrentkey ");
          AppMethodBeat.o(108766);
          return;
        }
        if (this.xPt.contains(this.xPr))
        {
          this.xPt.remove(this.xPr);
          if (!paramBoolean) {
            break label212;
          }
          if (paramInt != 2) {
            h.ahAA.bk(new Runnable()
            {
              public final void run()
              {
                AppMethodBeat.i(269804);
                if ((c.this.xPw != null) && (c.this.xPw.size() > 0))
                {
                  Iterator localIterator = c.this.xPw.iterator();
                  while (localIterator.hasNext()) {
                    localIterator.next();
                  }
                }
                AppMethodBeat.o(269804);
              }
            });
          }
          if (paramInt != 2) {
            break label223;
          }
          h.ahAA.p(this.xPA, 3000L);
          AppMethodBeat.o(108766);
          continue;
        }
        if (!this.xPu.contains(this.xPr)) {
          break label183;
        }
      }
      finally {}
      this.xPu.remove(this.xPr);
      continue;
      label183:
      if (this.xPv.contains(this.xPr))
      {
        this.xPv.remove(this.xPr);
        continue;
        label212:
        Log.i("MicroMsg.BKGLoader.BKGLoaderManager", "retry later.");
        continue;
        label223:
        h.ahAA.p(this.xPA, 1000L);
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
      h.ahAA.bm(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(269789);
          int i = NetStatusUtil.getNetType(paramContext);
          Log.i("MicroMsg.BKGLoader.BKGLoaderManager", "[cpan] network change type:%d", new Object[] { Integer.valueOf(i) });
          if (c.this.mNetWorkType == i)
          {
            AppMethodBeat.o(269789);
            return;
          }
          if ((c.this.xPm) || (NetStatusUtil.isWifi(MMApplicationContext.getContext()))) {
            if (!c.this.xPp) {
              c.this.dAN();
            }
          }
          for (;;)
          {
            c.this.mNetWorkType = i;
            AppMethodBeat.o(269789);
            return;
            c.this.dAO();
          }
        }
      });
      AppMethodBeat.o(108756);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.emoji.sync.c
 * JD-Core Version:    0.7.0.1
 */