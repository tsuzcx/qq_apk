package com.tencent.mm.modelvideo;

import android.os.Looper;
import android.os.SystemClock;
import com.tencent.e.j.a;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.al.f;
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
  public static String iuL = null;
  
  public static final class a
    implements f, t.a
  {
    private static int diu = 0;
    Queue<String> dim;
    Queue<String> din;
    Map<String, f.a> dio;
    boolean dip;
    private boolean diq;
    int dis;
    private long dit;
    f.a diw;
    private av dix;
    private VideoTransPara itU;
    private VideoTransPara itV;
    ap iuM;
    boolean iuN;
    private List<w> iuO;
    Queue<String> iuP;
    Queue<String> iuQ;
    d iuR;
    g iuS;
    ConcurrentHashMap<String, WeakReference<t.a>> iuT;
    private boolean running;
    
    public a()
    {
      AppMethodBeat.i(127042);
      this.iuN = false;
      this.dix = null;
      this.itU = null;
      this.itV = null;
      this.iuO = new ArrayList();
      this.dim = new LinkedList();
      this.din = new LinkedList();
      this.iuP = new LinkedList();
      this.iuQ = new LinkedList();
      this.dio = new HashMap();
      this.dip = false;
      this.diq = false;
      this.running = false;
      this.dis = 0;
      this.dit = 0L;
      this.iuR = null;
      this.iuS = null;
      this.diw = new f.a();
      this.iuT = new ConcurrentHashMap();
      com.tencent.mm.kernel.g.aiU().a(149, this);
      com.tencent.mm.kernel.g.aiU().a(150, this);
      o.aMJ().a(this, Looper.getMainLooper());
      this.iuN = true;
      a locala = a.aZF("VideoService_runThread");
      this.iuM = new ap(locala);
      this.dix = new av(locala, new av.a()
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
    
    private void Qe()
    {
      AppMethodBeat.i(127047);
      this.dio.clear();
      this.dim.clear();
      this.din.clear();
      this.iuP.clear();
      this.iuQ.clear();
      this.diq = false;
      this.dip = false;
      this.running = false;
      ad.i("MicroMsg.VideoService", "Finish service use time(ms):" + this.diw.abj());
      AppMethodBeat.o(127047);
    }
    
    private boolean aNe()
    {
      AppMethodBeat.i(127045);
      long l = bt.HI();
      if (o.aMJ() == null)
      {
        ad.e("MicroMsg.VideoService", "error, video info storage is null!!");
        AppMethodBeat.o(127045);
        return false;
      }
      Object localObject3;
      try
      {
        t localt = o.aMJ();
        localObject2 = new LinkedList();
        localObject3 = t.d.iaE.iterator();
        while (((Iterator)localObject3).hasNext()) {
          ((List)localObject2).addAll(localt.He(((t.c)((Iterator)localObject3).next()).table));
        }
        localObject3 = o.aMJ().aNc();
      }
      catch (Exception localException)
      {
        ad.printErrStackTrace("MicroMsg.VideoService", localException, "getNeedRunInfo error: %s", new Object[] { localException.getMessage() });
        AppMethodBeat.o(127045);
        return false;
      }
      Object localObject1 = o.aMJ().aNd();
      ad.d("MicroMsg.VideoService", "getNeedRunInfo needSendList size: " + ((List)localObject2).size());
      Object localObject2 = ((List)localObject2).iterator();
      while (((Iterator)localObject2).hasNext())
      {
        String str = (String)((Iterator)localObject2).next();
        if (this.dio.containsKey(str))
        {
          ad.d("MicroMsg.VideoService", "need sendList File is Already running:".concat(String.valueOf(str)));
        }
        else
        {
          this.dim.offer(str);
          this.dio.put(str, null);
        }
      }
      ad.d("MicroMsg.VideoService", "getNeedRunInfo needRecvList size: " + ((List)localObject3).size());
      localObject2 = ((List)localObject3).iterator();
      while (((Iterator)localObject2).hasNext())
      {
        localObject3 = (String)((Iterator)localObject2).next();
        if (this.dio.containsKey(localObject3))
        {
          ad.d("MicroMsg.VideoService", "need recvList File is Already running:".concat(String.valueOf(localObject3)));
        }
        else
        {
          this.din.offer(localObject3);
          this.dio.put(localObject3, null);
        }
      }
      ad.d("MicroMsg.VideoService", "getNeedRunInfo online video list size: " + ((List)localObject1).size());
      localObject1 = ((List)localObject1).iterator();
      while (((Iterator)localObject1).hasNext())
      {
        localObject2 = (String)((Iterator)localObject1).next();
        if (this.dio.containsKey(localObject2))
        {
          ad.d("MicroMsg.VideoService", "online videoList File is Already running:".concat(String.valueOf(localObject2)));
        }
        else
        {
          this.iuP.offer(localObject2);
          this.dio.put(localObject2, null);
        }
      }
      ad.i("MicroMsg.VideoService", "GetNeedRun cost time[%d] procing[%d] [recv:%d, online:%d, send:%d ]", new Object[] { Long.valueOf(bt.aO(l)), Integer.valueOf(this.dio.size()), Integer.valueOf(this.din.size()), Integer.valueOf(this.iuP.size()), Integer.valueOf(this.dim.size()) });
      if (this.din.size() + this.dim.size() + this.iuP.size() != 0)
      {
        AppMethodBeat.o(127045);
        return true;
      }
      AppMethodBeat.o(127045);
      return false;
    }
    
    public final void HH(String paramString)
    {
      AppMethodBeat.i(127051);
      this.dio.remove(paramString);
      AppMethodBeat.o(127051);
    }
    
    public final void a(t.a.a parama)
    {
      AppMethodBeat.i(127053);
      Object localObject = (WeakReference)this.iuT.get(parama.fileName);
      if (localObject != null)
      {
        localObject = (t.a)((WeakReference)localObject).get();
        if (localObject != null) {
          ((t.a)localObject).a(parama);
        }
      }
      localObject = u.Hy(parama.fileName);
      if ((localObject != null) && (((s)localObject).status == 199)) {
        this.iuT.remove(parama.fileName);
      }
      AppMethodBeat.o(127053);
    }
    
    public final void a(w paramw)
    {
      AppMethodBeat.i(127043);
      ad.m("MicroMsg.VideoService", "addVideoMsgSendCallback %s", new Object[] { paramw });
      if ((paramw != null) && (this.iuO != null) && (!this.iuO.contains(paramw))) {
        this.iuO.add(paramw);
      }
      AppMethodBeat.o(127043);
    }
    
    public final void a(final String paramString, t.a parama)
    {
      AppMethodBeat.i(127052);
      this.iuT.put(paramString, new WeakReference(parama));
      com.tencent.mm.kernel.g.ajF().ay(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(127041);
          u.av(paramString, this.iuV);
          s locals = u.Hy(paramString);
          if ((locals != null) && (locals.status != 199))
          {
            if (locals.aMX())
            {
              ad.i("MicroMsg.VideoService", "start complete online video");
              u.HF(paramString);
              AppMethodBeat.o(127041);
              return;
            }
            ad.i("MicroMsg.VideoService", "start complete offline video");
            u.Ht(paramString);
          }
          AppMethodBeat.o(127041);
        }
      });
      AppMethodBeat.o(127052);
    }
    
    public final boolean aNf()
    {
      AppMethodBeat.i(127049);
      boolean bool;
      if (this.iuR != null)
      {
        com.tencent.mm.kernel.g.aiU().a(this.iuR);
        bool = true;
        this.running = false;
      }
      for (;;)
      {
        this.dio.clear();
        this.dim.clear();
        this.din.clear();
        this.iuP.clear();
        this.iuQ.clear();
        AppMethodBeat.o(127049);
        return bool;
        bool = false;
      }
    }
    
    public final void aNg()
    {
      AppMethodBeat.i(127050);
      com.tencent.mm.kernel.g.aiU().a(this.iuR);
      Qe();
      AppMethodBeat.o(127050);
    }
    
    public final void b(w paramw)
    {
      AppMethodBeat.i(127044);
      if ((paramw != null) && (this.iuO != null)) {
        this.iuO.remove(paramw);
      }
      AppMethodBeat.o(127044);
    }
    
    public final void onSceneEnd(final int paramInt1, final int paramInt2, String paramString, final n paramn)
    {
      AppMethodBeat.i(127046);
      if ((!this.iuN) || (this.iuM == null))
      {
        ad.e("MicroMsg.VideoService", "onSceneEnd error!, handler or thread is null!");
        AppMethodBeat.o(127046);
        return;
      }
      this.iuM.post(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(127037);
          y.a.Qf();
          String str;
          int i;
          if (paramn.getType() == 150)
          {
            y.a.b(y.a.this);
            str = ((d)paramn).fileName;
            y.iuL = str;
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
              if (y.a.this.dio.get(str) != null)
              {
                l1 = ((f.a)y.a.this.dio.get(str)).abj();
                y.a.this.dio.remove(str);
              }
            }
            ad.d("MicroMsg.VideoService", "onSceneEnd SceneType:" + paramn.getType() + " errtype:" + paramInt1 + " errCode:" + paramInt2 + " retCode:" + i + " file:" + str + " time:" + l1);
            if ((paramInt1 == 3) && (i != 0))
            {
              y.a.f(y.a.this);
              label232:
              ad.d("MicroMsg.VideoService", "onSceneEnd  inCnt:" + y.a.diu + " stop:" + y.a.g(y.a.this) + " running:" + y.a.h(y.a.this) + " recving:" + y.a.i(y.a.this) + " sending:" + y.a.j(y.a.this));
              if (y.a.g(y.a.this) <= 0) {
                break label490;
              }
              y.a.a(y.a.this);
            }
            for (;;)
            {
              y.a.Qg();
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
              y.a.Qg();
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
      if ((!this.iuN) || (this.iuM == null))
      {
        ad.e("MicroMsg.VideoService", "run error!, handler or thread is null!");
        AppMethodBeat.o(127048);
        return;
      }
      this.iuM.post(new Runnable()
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
          y.a.this.diw.gdx = SystemClock.elapsedRealtime();
          y.a.n(y.a.this).az(10L, 10L);
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