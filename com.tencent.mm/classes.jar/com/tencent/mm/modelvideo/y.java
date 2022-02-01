package com.tencent.mm.modelvideo;

import android.os.Looper;
import android.os.SystemClock;
import com.tencent.e.j.a;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.f;
import com.tencent.mm.ak.n;
import com.tencent.mm.ak.q;
import com.tencent.mm.compatible.util.f.a;
import com.tencent.mm.modelcontrol.VideoTransPara;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.aq;
import com.tencent.mm.sdk.platformtools.ar;
import com.tencent.mm.sdk.platformtools.aw;
import com.tencent.mm.sdk.platformtools.aw.a;
import com.tencent.mm.sdk.platformtools.bu;
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
  public static String ixF = null;
  
  public static final class a
    implements f, t.a
  {
    private static int djw = 0;
    Queue<String> djp;
    Queue<String> djq;
    Map<String, f.a> djr;
    boolean djs;
    private boolean djt;
    int dju;
    private long djv;
    f.a djy;
    private aw djz;
    private VideoTransPara iwO;
    private VideoTransPara iwP;
    aq ixG;
    boolean ixH;
    private List<w> ixI;
    Queue<String> ixJ;
    Queue<String> ixK;
    d ixL;
    g ixM;
    ConcurrentHashMap<String, WeakReference<t.a>> ixN;
    private boolean running;
    
    public a()
    {
      AppMethodBeat.i(127042);
      this.ixH = false;
      this.djz = null;
      this.iwO = null;
      this.iwP = null;
      this.ixI = new ArrayList();
      this.djp = new LinkedList();
      this.djq = new LinkedList();
      this.ixJ = new LinkedList();
      this.ixK = new LinkedList();
      this.djr = new HashMap();
      this.djs = false;
      this.djt = false;
      this.running = false;
      this.dju = 0;
      this.djv = 0L;
      this.ixL = null;
      this.ixM = null;
      this.djy = new f.a();
      this.ixN = new ConcurrentHashMap();
      com.tencent.mm.kernel.g.ajj().a(149, this);
      com.tencent.mm.kernel.g.ajj().a(150, this);
      o.aNh().a(this, Looper.getMainLooper());
      this.ixH = true;
      a locala = a.bbi("VideoService_runThread");
      this.ixG = new aq(locala);
      this.djz = new aw(locala, new aw.a()
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
      ae.i("MicroMsg.VideoService", "create VideoService, start video send thread");
      AppMethodBeat.o(127042);
    }
    
    private void Qd()
    {
      AppMethodBeat.i(127047);
      this.djr.clear();
      this.djp.clear();
      this.djq.clear();
      this.ixJ.clear();
      this.ixK.clear();
      this.djt = false;
      this.djs = false;
      this.running = false;
      ae.i("MicroMsg.VideoService", "Finish service use time(ms):" + this.djy.abs());
      AppMethodBeat.o(127047);
    }
    
    private boolean aNC()
    {
      AppMethodBeat.i(127045);
      long l = bu.HQ();
      if (o.aNh() == null)
      {
        ae.e("MicroMsg.VideoService", "error, video info storage is null!!");
        AppMethodBeat.o(127045);
        return false;
      }
      Object localObject3;
      try
      {
        t localt = o.aNh();
        localObject2 = new LinkedList();
        localObject3 = t.d.idw.iterator();
        while (((Iterator)localObject3).hasNext()) {
          ((List)localObject2).addAll(localt.HG(((t.c)((Iterator)localObject3).next()).table));
        }
        localObject3 = o.aNh().aNA();
      }
      catch (Exception localException)
      {
        ae.printErrStackTrace("MicroMsg.VideoService", localException, "getNeedRunInfo error: %s", new Object[] { localException.getMessage() });
        AppMethodBeat.o(127045);
        return false;
      }
      Object localObject1 = o.aNh().aNB();
      ae.d("MicroMsg.VideoService", "getNeedRunInfo needSendList size: " + ((List)localObject2).size());
      Object localObject2 = ((List)localObject2).iterator();
      while (((Iterator)localObject2).hasNext())
      {
        String str = (String)((Iterator)localObject2).next();
        if (this.djr.containsKey(str))
        {
          ae.d("MicroMsg.VideoService", "need sendList File is Already running:".concat(String.valueOf(str)));
        }
        else
        {
          this.djp.offer(str);
          this.djr.put(str, null);
        }
      }
      ae.d("MicroMsg.VideoService", "getNeedRunInfo needRecvList size: " + ((List)localObject3).size());
      localObject2 = ((List)localObject3).iterator();
      while (((Iterator)localObject2).hasNext())
      {
        localObject3 = (String)((Iterator)localObject2).next();
        if (this.djr.containsKey(localObject3))
        {
          ae.d("MicroMsg.VideoService", "need recvList File is Already running:".concat(String.valueOf(localObject3)));
        }
        else
        {
          this.djq.offer(localObject3);
          this.djr.put(localObject3, null);
        }
      }
      ae.d("MicroMsg.VideoService", "getNeedRunInfo online video list size: " + ((List)localObject1).size());
      localObject1 = ((List)localObject1).iterator();
      while (((Iterator)localObject1).hasNext())
      {
        localObject2 = (String)((Iterator)localObject1).next();
        if (this.djr.containsKey(localObject2))
        {
          ae.d("MicroMsg.VideoService", "online videoList File is Already running:".concat(String.valueOf(localObject2)));
        }
        else
        {
          this.ixJ.offer(localObject2);
          this.djr.put(localObject2, null);
        }
      }
      ae.i("MicroMsg.VideoService", "GetNeedRun cost time[%d] procing[%d] [recv:%d, online:%d, send:%d ]", new Object[] { Long.valueOf(bu.aO(l)), Integer.valueOf(this.djr.size()), Integer.valueOf(this.djq.size()), Integer.valueOf(this.ixJ.size()), Integer.valueOf(this.djp.size()) });
      if (this.djq.size() + this.djp.size() + this.ixJ.size() != 0)
      {
        AppMethodBeat.o(127045);
        return true;
      }
      AppMethodBeat.o(127045);
      return false;
    }
    
    public final void Ij(String paramString)
    {
      AppMethodBeat.i(127051);
      this.djr.remove(paramString);
      AppMethodBeat.o(127051);
    }
    
    public final void a(t.a.a parama)
    {
      AppMethodBeat.i(127053);
      Object localObject = (WeakReference)this.ixN.get(parama.fileName);
      if (localObject != null)
      {
        localObject = (t.a)((WeakReference)localObject).get();
        if (localObject != null) {
          ((t.a)localObject).a(parama);
        }
      }
      localObject = u.Ia(parama.fileName);
      if ((localObject != null) && (((s)localObject).status == 199)) {
        this.ixN.remove(parama.fileName);
      }
      AppMethodBeat.o(127053);
    }
    
    public final void a(w paramw)
    {
      AppMethodBeat.i(127043);
      ae.m("MicroMsg.VideoService", "addVideoMsgSendCallback %s", new Object[] { paramw });
      if ((paramw != null) && (this.ixI != null) && (!this.ixI.contains(paramw))) {
        this.ixI.add(paramw);
      }
      AppMethodBeat.o(127043);
    }
    
    public final void a(final String paramString, t.a parama)
    {
      AppMethodBeat.i(127052);
      this.ixN.put(paramString, new WeakReference(parama));
      com.tencent.mm.kernel.g.ajU().aw(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(127041);
          u.aw(paramString, this.ixP);
          s locals = u.Ia(paramString);
          if ((locals != null) && (locals.status != 199))
          {
            if (locals.aNv())
            {
              ae.i("MicroMsg.VideoService", "start complete online video");
              u.Ih(paramString);
              AppMethodBeat.o(127041);
              return;
            }
            ae.i("MicroMsg.VideoService", "start complete offline video");
            u.HV(paramString);
          }
          AppMethodBeat.o(127041);
        }
      });
      AppMethodBeat.o(127052);
    }
    
    public final boolean aND()
    {
      AppMethodBeat.i(127049);
      boolean bool;
      if (this.ixL != null)
      {
        com.tencent.mm.kernel.g.ajj().a(this.ixL);
        bool = true;
        this.running = false;
      }
      for (;;)
      {
        this.djr.clear();
        this.djp.clear();
        this.djq.clear();
        this.ixJ.clear();
        this.ixK.clear();
        AppMethodBeat.o(127049);
        return bool;
        bool = false;
      }
    }
    
    public final void aNE()
    {
      AppMethodBeat.i(127050);
      com.tencent.mm.kernel.g.ajj().a(this.ixL);
      Qd();
      AppMethodBeat.o(127050);
    }
    
    public final void b(w paramw)
    {
      AppMethodBeat.i(127044);
      if ((paramw != null) && (this.ixI != null)) {
        this.ixI.remove(paramw);
      }
      AppMethodBeat.o(127044);
    }
    
    public final void onSceneEnd(final int paramInt1, final int paramInt2, String paramString, final n paramn)
    {
      AppMethodBeat.i(127046);
      if ((!this.ixH) || (this.ixG == null))
      {
        ae.e("MicroMsg.VideoService", "onSceneEnd error!, handler or thread is null!");
        AppMethodBeat.o(127046);
        return;
      }
      this.ixG.post(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(127037);
          y.a.Qe();
          String str;
          int i;
          if (paramn.getType() == 150)
          {
            y.a.b(y.a.this);
            str = ((d)paramn).fileName;
            y.ixF = str;
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
              if (y.a.this.djr.get(str) != null)
              {
                l1 = ((f.a)y.a.this.djr.get(str)).abs();
                y.a.this.djr.remove(str);
              }
            }
            ae.d("MicroMsg.VideoService", "onSceneEnd SceneType:" + paramn.getType() + " errtype:" + paramInt1 + " errCode:" + paramInt2 + " retCode:" + i + " file:" + str + " time:" + l1);
            if ((paramInt1 == 3) && (i != 0))
            {
              y.a.f(y.a.this);
              label232:
              ae.d("MicroMsg.VideoService", "onSceneEnd  inCnt:" + y.a.djw + " stop:" + y.a.g(y.a.this) + " running:" + y.a.h(y.a.this) + " recving:" + y.a.i(y.a.this) + " sending:" + y.a.j(y.a.this));
              if (y.a.g(y.a.this) <= 0) {
                break label490;
              }
              y.a.a(y.a.this);
            }
            for (;;)
            {
              y.a.Qf();
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
              ae.e("MicroMsg.VideoService", "onSceneEnd Error SceneType:" + paramn.getType());
              y.a.Qf();
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
      if ((!this.ixH) || (this.ixG == null))
      {
        ae.e("MicroMsg.VideoService", "run error!, handler or thread is null!");
        AppMethodBeat.o(127048);
        return;
      }
      this.ixG.post(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(127039);
          long l = System.currentTimeMillis() - y.a.l(y.a.this);
          ae.d("MicroMsg.VideoService", "Try Run service runningFlag:" + y.a.h(y.a.this) + " timeWait:" + l + " sending:" + y.a.j(y.a.this) + " recving:" + y.a.i(y.a.this));
          if (y.a.h(y.a.this))
          {
            if (l < 60000L)
            {
              AppMethodBeat.o(127039);
              return;
            }
            ae.e("MicroMsg.VideoService", "ERR: Try Run service runningFlag:" + y.a.h(y.a.this) + " timeWait:" + l + ">=MAX_TIME_WAIT sending:" + y.a.j(y.a.this) + " recving:" + y.a.i(y.a.this));
          }
          y.a.a(y.a.this, 3);
          y.a.m(y.a.this);
          y.a.d(y.a.this);
          y.a.b(y.a.this);
          y.a.e(y.a.this);
          y.a.c(y.a.this);
          y.a.this.djy.gfF = SystemClock.elapsedRealtime();
          y.a.n(y.a.this).ay(10L, 10L);
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.modelvideo.y
 * JD-Core Version:    0.7.0.1
 */