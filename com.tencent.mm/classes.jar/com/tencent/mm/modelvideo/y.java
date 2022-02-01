package com.tencent.mm.modelvideo;

import android.os.Looper;
import android.os.SystemClock;
import com.tencent.e.j.a;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.al.n;
import com.tencent.mm.al.q;
import com.tencent.mm.compatible.util.f.a;
import com.tencent.mm.modelcontrol.VideoTransPara;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.ap;
import com.tencent.mm.sdk.platformtools.aq;
import com.tencent.mm.sdk.platformtools.av;
import com.tencent.mm.sdk.platformtools.av.a;
import com.tencent.mm.sdk.platformtools.bt;
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
  public static String hAO = null;
  
  public static final class a
    implements com.tencent.mm.al.g, t.a
  {
    private static int cZH = 0;
    Queue<String> cZA;
    Queue<String> cZB;
    Map<String, f.a> cZC;
    boolean cZD;
    private boolean cZE;
    int cZF;
    private long cZG;
    f.a cZJ;
    private av cZK;
    ap hAP;
    boolean hAQ;
    private List<w> hAR;
    Queue<String> hAS;
    Queue<String> hAT;
    d hAU;
    g hAV;
    ConcurrentHashMap<String, WeakReference<t.a>> hAW;
    private VideoTransPara hzX;
    private VideoTransPara hzY;
    private boolean running;
    
    public a()
    {
      AppMethodBeat.i(127042);
      this.hAQ = false;
      this.cZK = null;
      this.hzX = null;
      this.hzY = null;
      this.hAR = new ArrayList();
      this.cZA = new LinkedList();
      this.cZB = new LinkedList();
      this.hAS = new LinkedList();
      this.hAT = new LinkedList();
      this.cZC = new HashMap();
      this.cZD = false;
      this.cZE = false;
      this.running = false;
      this.cZF = 0;
      this.cZG = 0L;
      this.hAU = null;
      this.hAV = null;
      this.cZJ = new f.a();
      this.hAW = new ConcurrentHashMap();
      com.tencent.mm.kernel.g.aeS().a(149, this);
      com.tencent.mm.kernel.g.aeS().a(150, this);
      o.aCI().a(this, Looper.getMainLooper());
      this.hAQ = true;
      a locala = a.aOc("VideoService_runThread");
      this.hAP = new ap(locala);
      this.cZK = new av(locala, new av.a()
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
      ad.i("MicroMsg.VideoService", "create VideoService, start video send thread");
      AppMethodBeat.o(127042);
    }
    
    private void Oy()
    {
      AppMethodBeat.i(127047);
      this.cZC.clear();
      this.cZA.clear();
      this.cZB.clear();
      this.hAS.clear();
      this.hAT.clear();
      this.cZE = false;
      this.cZD = false;
      this.running = false;
      ad.i("MicroMsg.VideoService", "Finish service use time(ms):" + this.cZJ.XK());
      AppMethodBeat.o(127047);
    }
    
    private boolean aDd()
    {
      AppMethodBeat.i(127045);
      long l = bt.GC();
      if (o.aCI() == null)
      {
        ad.e("MicroMsg.VideoService", "error, video info storage is null!!");
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
          localObject2 = o.aCI().aDc();
          localObject1 = o.aCI().aDa();
          List localList = o.aCI().aDb();
          if (localObject2 == null) {
            break;
          }
          ad.d("MicroMsg.VideoService", "getNeedRunInfo needSendList size: " + ((List)localObject2).size());
          localObject2 = ((List)localObject2).iterator();
          if (!((Iterator)localObject2).hasNext()) {
            break;
          }
          str = (String)((Iterator)localObject2).next();
          if (this.cZC.containsKey(str))
          {
            ad.d("MicroMsg.VideoService", "need sendList File is Already running:".concat(String.valueOf(str)));
            continue;
          }
          this.cZA.offer(str);
        }
        catch (Exception localException)
        {
          ad.printErrStackTrace("MicroMsg.VideoService", localException, "getNeedRunInfo error: %s", new Object[] { localException.getMessage() });
          AppMethodBeat.o(127045);
          return false;
        }
        this.cZC.put(str, null);
      }
      if (localObject1 != null)
      {
        ad.d("MicroMsg.VideoService", "getNeedRunInfo needRecvList size: " + ((List)localObject1).size());
        localObject1 = ((List)localObject1).iterator();
        while (((Iterator)localObject1).hasNext())
        {
          localObject2 = (String)((Iterator)localObject1).next();
          if (this.cZC.containsKey(localObject2))
          {
            ad.d("MicroMsg.VideoService", "need recvList File is Already running:".concat(String.valueOf(localObject2)));
          }
          else
          {
            this.cZB.offer(localObject2);
            this.cZC.put(localObject2, null);
          }
        }
      }
      if (localException != null)
      {
        ad.d("MicroMsg.VideoService", "getNeedRunInfo online video list size: " + localException.size());
        Iterator localIterator = localException.iterator();
        while (localIterator.hasNext())
        {
          localObject1 = (String)localIterator.next();
          if (this.cZC.containsKey(localObject1))
          {
            ad.d("MicroMsg.VideoService", "online videoList File is Already running:".concat(String.valueOf(localObject1)));
          }
          else
          {
            this.hAS.offer(localObject1);
            this.cZC.put(localObject1, null);
          }
        }
      }
      ad.i("MicroMsg.VideoService", "GetNeedRun cost time[%d] procing[%d] [recv:%d, online:%d, send:%d ]", new Object[] { Long.valueOf(bt.aS(l)), Integer.valueOf(this.cZC.size()), Integer.valueOf(this.cZB.size()), Integer.valueOf(this.hAS.size()), Integer.valueOf(this.cZA.size()) });
      if (this.cZB.size() + this.cZA.size() + this.hAS.size() != 0)
      {
        AppMethodBeat.o(127045);
        return true;
      }
      AppMethodBeat.o(127045);
      return false;
    }
    
    public final void An(String paramString)
    {
      AppMethodBeat.i(127051);
      this.cZC.remove(paramString);
      AppMethodBeat.o(127051);
    }
    
    public final void a(t.a.a parama)
    {
      AppMethodBeat.i(127053);
      Object localObject = (WeakReference)this.hAW.get(parama.fileName);
      if (localObject != null)
      {
        localObject = (t.a)((WeakReference)localObject).get();
        if (localObject != null) {
          ((t.a)localObject).a(parama);
        }
      }
      localObject = u.Ae(parama.fileName);
      if ((localObject != null) && (((s)localObject).status == 199)) {
        this.hAW.remove(parama.fileName);
      }
      AppMethodBeat.o(127053);
    }
    
    public final void a(w paramw)
    {
      AppMethodBeat.i(127043);
      ad.m("MicroMsg.VideoService", "addVideoMsgSendCallback %s", new Object[] { paramw });
      if ((paramw != null) && (this.hAR != null) && (!this.hAR.contains(paramw))) {
        this.hAR.add(paramw);
      }
      AppMethodBeat.o(127043);
    }
    
    public final void a(final String paramString, t.a parama)
    {
      AppMethodBeat.i(127052);
      this.hAW.put(paramString, new WeakReference(parama));
      com.tencent.mm.kernel.g.afE().ax(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(127041);
          u.ap(paramString, this.hAY);
          s locals = u.Ae(paramString);
          if ((locals != null) && (locals.status != 199))
          {
            if (locals.aCV())
            {
              ad.i("MicroMsg.VideoService", "start complete online video");
              u.Al(paramString);
              AppMethodBeat.o(127041);
              return;
            }
            ad.i("MicroMsg.VideoService", "start complete offline video");
            u.zZ(paramString);
          }
          AppMethodBeat.o(127041);
        }
      });
      AppMethodBeat.o(127052);
    }
    
    public final boolean aDe()
    {
      AppMethodBeat.i(127049);
      boolean bool;
      if (this.hAU != null)
      {
        com.tencent.mm.kernel.g.aeS().a(this.hAU);
        bool = true;
        this.running = false;
      }
      for (;;)
      {
        this.cZC.clear();
        this.cZA.clear();
        this.cZB.clear();
        this.hAS.clear();
        this.hAT.clear();
        AppMethodBeat.o(127049);
        return bool;
        bool = false;
      }
    }
    
    public final void aDf()
    {
      AppMethodBeat.i(127050);
      com.tencent.mm.kernel.g.aeS().a(this.hAU);
      Oy();
      AppMethodBeat.o(127050);
    }
    
    public final void b(w paramw)
    {
      AppMethodBeat.i(127044);
      if ((paramw != null) && (this.hAR != null)) {
        this.hAR.remove(paramw);
      }
      AppMethodBeat.o(127044);
    }
    
    public final void onSceneEnd(final int paramInt1, final int paramInt2, String paramString, final n paramn)
    {
      AppMethodBeat.i(127046);
      if ((!this.hAQ) || (this.hAP == null))
      {
        ad.e("MicroMsg.VideoService", "onSceneEnd error!, handler or thread is null!");
        AppMethodBeat.o(127046);
        return;
      }
      this.hAP.post(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(127037);
          y.a.auD();
          String str;
          int i;
          if (paramn.getType() == 150)
          {
            y.a.b(y.a.this);
            str = ((d)paramn).fileName;
            y.hAO = str;
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
              if (y.a.this.cZC.get(str) != null)
              {
                l1 = ((f.a)y.a.this.cZC.get(str)).XK();
                y.a.this.cZC.remove(str);
              }
            }
            ad.d("MicroMsg.VideoService", "onSceneEnd SceneType:" + paramn.getType() + " errtype:" + paramInt1 + " errCode:" + paramInt2 + " retCode:" + i + " file:" + str + " time:" + l1);
            if ((paramInt1 == 3) && (i != 0))
            {
              y.a.f(y.a.this);
              label232:
              ad.d("MicroMsg.VideoService", "onSceneEnd  inCnt:" + y.a.cZH + " stop:" + y.a.g(y.a.this) + " running:" + y.a.h(y.a.this) + " recving:" + y.a.i(y.a.this) + " sending:" + y.a.j(y.a.this));
              if (y.a.g(y.a.this) <= 0) {
                break label490;
              }
              y.a.a(y.a.this);
            }
            for (;;)
            {
              y.a.aDg();
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
              ad.e("MicroMsg.VideoService", "onSceneEnd Error SceneType:" + paramn.getType());
              y.a.aDg();
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
      if ((!this.hAQ) || (this.hAP == null))
      {
        ad.e("MicroMsg.VideoService", "run error!, handler or thread is null!");
        AppMethodBeat.o(127048);
        return;
      }
      this.hAP.post(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(127039);
          long l = System.currentTimeMillis() - y.a.l(y.a.this);
          ad.d("MicroMsg.VideoService", "Try Run service runningFlag:" + y.a.h(y.a.this) + " timeWait:" + l + " sending:" + y.a.j(y.a.this) + " recving:" + y.a.i(y.a.this));
          if (y.a.h(y.a.this))
          {
            if (l < 60000L)
            {
              AppMethodBeat.o(127039);
              return;
            }
            ad.e("MicroMsg.VideoService", "ERR: Try Run service runningFlag:" + y.a.h(y.a.this) + " timeWait:" + l + ">=MAX_TIME_WAIT sending:" + y.a.j(y.a.this) + " recving:" + y.a.i(y.a.this));
          }
          y.a.a(y.a.this, 3);
          y.a.m(y.a.this);
          y.a.d(y.a.this);
          y.a.b(y.a.this);
          y.a.e(y.a.this);
          y.a.c(y.a.this);
          y.a.this.cZJ.fGp = SystemClock.elapsedRealtime();
          y.a.n(y.a.this).av(10L, 10L);
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.modelvideo.y
 * JD-Core Version:    0.7.0.1
 */