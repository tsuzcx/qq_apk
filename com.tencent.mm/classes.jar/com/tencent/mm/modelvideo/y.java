package com.tencent.mm.modelvideo;

import android.os.Looper;
import android.os.SystemClock;
import com.tencent.e.j.a;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.n;
import com.tencent.mm.ak.q;
import com.tencent.mm.compatible.util.f.a;
import com.tencent.mm.modelcontrol.VideoTransPara;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.ao;
import com.tencent.mm.sdk.platformtools.ap;
import com.tencent.mm.sdk.platformtools.au;
import com.tencent.mm.sdk.platformtools.au.a;
import com.tencent.mm.sdk.platformtools.bs;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.concurrent.ConcurrentHashMap;

public final class y
{
  public static String ibp = null;
  
  public static final class a
    implements com.tencent.mm.ak.g, t.a
  {
    private static int cXd = 0;
    Queue<String> cWW;
    Queue<String> cWX;
    Map<String, f.a> cWY;
    boolean cWZ;
    private boolean cXa;
    int cXb;
    private long cXc;
    f.a cXf;
    private au cXg;
    private VideoTransPara iay;
    private VideoTransPara iaz;
    ao ibq;
    boolean ibr;
    private List<w> ibs;
    Queue<String> ibt;
    Queue<String> ibu;
    d ibv;
    g ibw;
    ConcurrentHashMap<String, WeakReference<t.a>> ibx;
    private boolean running;
    
    public a()
    {
      AppMethodBeat.i(127042);
      this.ibr = false;
      this.cXg = null;
      this.iay = null;
      this.iaz = null;
      this.ibs = new ArrayList();
      this.cWW = new LinkedList();
      this.cWX = new LinkedList();
      this.ibt = new LinkedList();
      this.ibu = new LinkedList();
      this.cWY = new HashMap();
      this.cWZ = false;
      this.cXa = false;
      this.running = false;
      this.cXb = 0;
      this.cXc = 0L;
      this.ibv = null;
      this.ibw = null;
      this.cXf = new f.a();
      this.ibx = new ConcurrentHashMap();
      com.tencent.mm.kernel.g.agi().a(149, this);
      com.tencent.mm.kernel.g.agi().a(150, this);
      o.aJy().a(this, Looper.getMainLooper());
      this.ibr = true;
      a locala = a.aTF("VideoService_runThread");
      this.ibq = new ao(locala);
      this.cXg = new au(locala, new au.a()
      {
        public final boolean onTimerExpired()
        {
          AppMethodBeat.i(127035);
          y.a.a(y.a.this);
          AppMethodBeat.o(127035);
          return false;
        }
        
        public final String toString()
        {
          AppMethodBeat.i(127036);
          String str = super.toString() + "|scenePusher";
          AppMethodBeat.o(127036);
          return str;
        }
      }, false);
      ac.i("MicroMsg.VideoService", "create VideoService, start video send thread");
      AppMethodBeat.o(127042);
    }
    
    private void Ou()
    {
      AppMethodBeat.i(127047);
      this.cWY.clear();
      this.cWW.clear();
      this.cWX.clear();
      this.ibt.clear();
      this.ibu.clear();
      this.cXa = false;
      this.cWZ = false;
      this.running = false;
      ac.i("MicroMsg.VideoService", "Finish service use time(ms):" + this.cXf.YH());
      AppMethodBeat.o(127047);
    }
    
    private boolean aJU()
    {
      AppMethodBeat.i(127045);
      long l = bs.Gn();
      if (o.aJy() == null)
      {
        ac.e("MicroMsg.VideoService", "error, video info storage is null!!");
        AppMethodBeat.o(127045);
        return false;
      }
      Object localObject2;
      Object localObject1;
      for (;;)
      {
        String str;
        try
        {
          localObject2 = o.aJy().aJT();
          localObject1 = o.aJy().aJR();
          List localList = o.aJy().aJS();
          if (localObject2 == null) {
            break;
          }
          ac.d("MicroMsg.VideoService", "getNeedRunInfo needSendList size: " + ((List)localObject2).size());
          localObject2 = ((List)localObject2).iterator();
          if (!((Iterator)localObject2).hasNext()) {
            break;
          }
          str = (String)((Iterator)localObject2).next();
          if (this.cWY.containsKey(str))
          {
            ac.d("MicroMsg.VideoService", "need sendList File is Already running:".concat(String.valueOf(str)));
            continue;
          }
          this.cWW.offer(str);
        }
        catch (Exception localException)
        {
          ac.printErrStackTrace("MicroMsg.VideoService", localException, "getNeedRunInfo error: %s", new Object[] { localException.getMessage() });
          AppMethodBeat.o(127045);
          return false;
        }
        this.cWY.put(str, null);
      }
      if (localObject1 != null)
      {
        ac.d("MicroMsg.VideoService", "getNeedRunInfo needRecvList size: " + ((List)localObject1).size());
        localObject1 = ((List)localObject1).iterator();
        while (((Iterator)localObject1).hasNext())
        {
          localObject2 = (String)((Iterator)localObject1).next();
          if (this.cWY.containsKey(localObject2))
          {
            ac.d("MicroMsg.VideoService", "need recvList File is Already running:".concat(String.valueOf(localObject2)));
          }
          else
          {
            this.cWX.offer(localObject2);
            this.cWY.put(localObject2, null);
          }
        }
      }
      if (localException != null)
      {
        ac.d("MicroMsg.VideoService", "getNeedRunInfo online video list size: " + localException.size());
        Iterator localIterator = localException.iterator();
        while (localIterator.hasNext())
        {
          localObject1 = (String)localIterator.next();
          if (this.cWY.containsKey(localObject1))
          {
            ac.d("MicroMsg.VideoService", "online videoList File is Already running:".concat(String.valueOf(localObject1)));
          }
          else
          {
            this.ibt.offer(localObject1);
            this.cWY.put(localObject1, null);
          }
        }
      }
      ac.i("MicroMsg.VideoService", "GetNeedRun cost time[%d] procing[%d] [recv:%d, online:%d, send:%d ]", new Object[] { Long.valueOf(bs.aO(l)), Integer.valueOf(this.cWY.size()), Integer.valueOf(this.cWX.size()), Integer.valueOf(this.ibt.size()), Integer.valueOf(this.cWW.size()) });
      if (this.cWX.size() + this.cWW.size() + this.ibt.size() != 0)
      {
        AppMethodBeat.o(127045);
        return true;
      }
      AppMethodBeat.o(127045);
      return false;
    }
    
    public final void Es(String paramString)
    {
      AppMethodBeat.i(127051);
      this.cWY.remove(paramString);
      AppMethodBeat.o(127051);
    }
    
    public final void a(t.a.a parama)
    {
      AppMethodBeat.i(127053);
      Object localObject = (WeakReference)this.ibx.get(parama.fileName);
      if (localObject != null)
      {
        localObject = (t.a)((WeakReference)localObject).get();
        if (localObject != null) {
          ((t.a)localObject).a(parama);
        }
      }
      localObject = u.Ej(parama.fileName);
      if ((localObject != null) && (((s)localObject).status == 199)) {
        this.ibx.remove(parama.fileName);
      }
      AppMethodBeat.o(127053);
    }
    
    public final void a(w paramw)
    {
      AppMethodBeat.i(127043);
      ac.m("MicroMsg.VideoService", "addVideoMsgSendCallback %s", new Object[] { paramw });
      if ((paramw != null) && (this.ibs != null) && (!this.ibs.contains(paramw))) {
        this.ibs.add(paramw);
      }
      AppMethodBeat.o(127043);
    }
    
    public final void a(String paramString, t.a parama)
    {
      AppMethodBeat.i(127052);
      this.ibx.put(paramString, new WeakReference(parama));
      com.tencent.mm.kernel.g.agU().az(new y.a.4(this, paramString));
      AppMethodBeat.o(127052);
    }
    
    public final boolean aJV()
    {
      AppMethodBeat.i(127049);
      boolean bool;
      if (this.ibv != null)
      {
        com.tencent.mm.kernel.g.agi().a(this.ibv);
        bool = true;
        this.running = false;
      }
      for (;;)
      {
        this.cWY.clear();
        this.cWW.clear();
        this.cWX.clear();
        this.ibt.clear();
        this.ibu.clear();
        AppMethodBeat.o(127049);
        return bool;
        bool = false;
      }
    }
    
    public final void aJW()
    {
      AppMethodBeat.i(127050);
      com.tencent.mm.kernel.g.agi().a(this.ibv);
      Ou();
      AppMethodBeat.o(127050);
    }
    
    public final void b(w paramw)
    {
      AppMethodBeat.i(127044);
      if ((paramw != null) && (this.ibs != null)) {
        this.ibs.remove(paramw);
      }
      AppMethodBeat.o(127044);
    }
    
    public final void onSceneEnd(final int paramInt1, final int paramInt2, String paramString, final n paramn)
    {
      AppMethodBeat.i(127046);
      if ((!this.ibr) || (this.ibq == null))
      {
        ac.e("MicroMsg.VideoService", "onSceneEnd error!, handler or thread is null!");
        AppMethodBeat.o(127046);
        return;
      }
      this.ibq.post(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(127037);
          y.a.aBu();
          String str;
          int i;
          if (paramn.getType() == 150)
          {
            y.a.b(y.a.this);
            str = ((d)paramn).fileName;
            y.ibp = str;
            i = ((d)paramn).retCode;
            y.a.c(y.a.this);
          }
          for (;;)
          {
            long l2 = 0L;
            long l1 = l2;
            if (str != null)
            {
              l1 = l2;
              if (y.a.this.cWY.get(str) != null)
              {
                l1 = ((f.a)y.a.this.cWY.get(str)).YH();
                y.a.this.cWY.remove(str);
              }
            }
            ac.d("MicroMsg.VideoService", "onSceneEnd SceneType:" + paramn.getType() + " errtype:" + paramInt1 + " errCode:" + paramInt2 + " retCode:" + i + " file:" + str + " time:" + l1);
            if ((paramInt1 == 3) && (i != 0))
            {
              y.a.f(y.a.this);
              label232:
              ac.d("MicroMsg.VideoService", "onSceneEnd  inCnt:" + y.a.cXd + " stop:" + y.a.g(y.a.this) + " running:" + y.a.h(y.a.this) + " recving:" + y.a.i(y.a.this) + " sending:" + y.a.j(y.a.this));
              if (y.a.g(y.a.this) <= 0) {
                break label490;
              }
              y.a.a(y.a.this);
            }
            for (;;)
            {
              y.a.aJX();
              AppMethodBeat.o(127037);
              return;
              if (paramn.getType() == 149)
              {
                y.a.d(y.a.this);
                y.a.e(y.a.this);
                if ((paramn instanceof g))
                {
                  str = ((g)paramn).fileName;
                  i = ((g)paramn).retCode;
                  break;
                }
                if (!(paramn instanceof h)) {
                  break label520;
                }
                str = ((h)paramn).fileName;
                i = 0;
                break;
              }
              ac.e("MicroMsg.VideoService", "onSceneEnd Error SceneType:" + paramn.getType());
              y.a.aJX();
              AppMethodBeat.o(127037);
              return;
              if (paramInt1 == 0) {
                break label232;
              }
              y.a.a(y.a.this, 0);
              break label232;
              label490:
              if ((!y.a.j(y.a.this)) && (!y.a.i(y.a.this))) {
                y.a.k(y.a.this);
              }
            }
            label520:
            i = 0;
            str = null;
          }
        }
        
        public final String toString()
        {
          AppMethodBeat.i(127038);
          String str = super.toString() + "|onSceneEnd";
          AppMethodBeat.o(127038);
          return str;
        }
      });
      AppMethodBeat.o(127046);
    }
    
    public final void run()
    {
      AppMethodBeat.i(127048);
      if ((!this.ibr) || (this.ibq == null))
      {
        ac.e("MicroMsg.VideoService", "run error!, handler or thread is null!");
        AppMethodBeat.o(127048);
        return;
      }
      this.ibq.post(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(127039);
          long l = System.currentTimeMillis() - y.a.l(y.a.this);
          ac.d("MicroMsg.VideoService", "Try Run service runningFlag:" + y.a.h(y.a.this) + " timeWait:" + l + " sending:" + y.a.j(y.a.this) + " recving:" + y.a.i(y.a.this));
          if (y.a.h(y.a.this))
          {
            if (l < 60000L)
            {
              AppMethodBeat.o(127039);
              return;
            }
            ac.e("MicroMsg.VideoService", "ERR: Try Run service runningFlag:" + y.a.h(y.a.this) + " timeWait:" + l + ">=MAX_TIME_WAIT sending:" + y.a.j(y.a.this) + " recving:" + y.a.i(y.a.this));
          }
          y.a.a(y.a.this, 3);
          y.a.m(y.a.this);
          y.a.d(y.a.this);
          y.a.b(y.a.this);
          y.a.e(y.a.this);
          y.a.c(y.a.this);
          y.a.this.cXf.fJW = SystemClock.elapsedRealtime();
          y.a.n(y.a.this).au(10L, 10L);
          AppMethodBeat.o(127039);
        }
        
        public final String toString()
        {
          AppMethodBeat.i(127040);
          String str = super.toString() + "|run";
          AppMethodBeat.o(127040);
          return str;
        }
      });
      AppMethodBeat.o(127048);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.modelvideo.y
 * JD-Core Version:    0.7.0.1
 */