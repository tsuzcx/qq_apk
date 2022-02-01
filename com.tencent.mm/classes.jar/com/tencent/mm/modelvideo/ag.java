package com.tencent.mm.modelvideo;

import android.os.Looper;
import android.os.SystemClock;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.am.p;
import com.tencent.mm.am.s;
import com.tencent.mm.compatible.util.f.a;
import com.tencent.mm.modelcontrol.VideoTransPara;
import com.tencent.mm.plugin.expt.b.c;
import com.tencent.mm.plugin.expt.b.c.a;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMHandler;
import com.tencent.mm.sdk.platformtools.MMHandlerThread;
import com.tencent.mm.sdk.platformtools.MTimerHandler;
import com.tencent.mm.sdk.platformtools.MTimerHandler.CallBack;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.threadpool.j.a;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.concurrent.ConcurrentHashMap;

public final class ag
{
  public static String pbV = null;
  
  public static final class a
    implements com.tencent.mm.am.h, aa.a
  {
    private static int pae = 0;
    Queue<String> hxE;
    Queue<String> hxF;
    Map<String, f.a> hxG;
    boolean hxH;
    private boolean hxI;
    int hxJ;
    private long hxK;
    f.a hxM;
    private MTimerHandler hxN;
    private VideoTransPara paR;
    private VideoTransPara paS;
    MMHandler pbW;
    boolean pbX;
    private List<ad> pbY;
    Queue<String> pbZ;
    Queue<String> pca;
    h pcb;
    k pcc;
    ConcurrentHashMap<String, WeakReference<aa.a>> pcd;
    private boolean running;
    
    public a()
    {
      AppMethodBeat.i(127042);
      this.pbX = false;
      this.hxN = null;
      this.paR = null;
      this.paS = null;
      this.pbY = new ArrayList();
      this.hxE = new LinkedList();
      this.hxF = new LinkedList();
      this.pbZ = new LinkedList();
      this.pca = new LinkedList();
      this.hxG = new HashMap();
      this.hxH = false;
      this.hxI = false;
      this.running = false;
      this.hxJ = 0;
      this.hxK = 0L;
      this.pcb = null;
      this.pcc = null;
      this.hxM = new f.a();
      this.pcd = new ConcurrentHashMap();
      com.tencent.mm.kernel.h.aZW().a(149, this);
      com.tencent.mm.kernel.h.aZW().a(150, this);
      v.bOh().a(this, Looper.getMainLooper());
      this.pbX = true;
      a locala = a.bFV("VideoService_runThread");
      this.pbW = new MMHandler(locala);
      this.hxN = new MTimerHandler(locala, new MTimerHandler.CallBack()
      {
        public final boolean onTimerExpired()
        {
          AppMethodBeat.i(127035);
          ag.a.a(ag.a.this);
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
      Log.i("MicroMsg.VideoService", "create VideoService, start video send thread");
      AppMethodBeat.o(127042);
    }
    
    private void aHh()
    {
      AppMethodBeat.i(127047);
      this.hxG.clear();
      this.hxE.clear();
      this.hxF.clear();
      this.pbZ.clear();
      this.pca.clear();
      this.hxI = false;
      this.hxH = false;
      this.running = false;
      Log.i("MicroMsg.VideoService", "Finish service use time(ms):" + this.hxM.aPY());
      AppMethodBeat.o(127047);
    }
    
    private boolean bOI()
    {
      AppMethodBeat.i(127045);
      long l = Util.currentTicks();
      if (v.bOh() == null)
      {
        Log.e("MicroMsg.VideoService", "error, video info storage is null!!");
        AppMethodBeat.o(127045);
        return false;
      }
      Object localObject3;
      try
      {
        aa localaa = v.bOh();
        localObject2 = new LinkedList();
        localObject3 = aa.d.oHy.iterator();
        while (((Iterator)localObject3).hasNext()) {
          ((List)localObject2).addAll(localaa.PU(((aa.c)((Iterator)localObject3).next()).table));
        }
        localObject3 = v.bOh().bOD();
      }
      catch (Exception localException)
      {
        Log.printErrStackTrace("MicroMsg.VideoService", localException, "getNeedRunInfo error: %s", new Object[] { localException.getMessage() });
        AppMethodBeat.o(127045);
        return false;
      }
      Object localObject1 = v.bOh().bOE();
      Log.d("MicroMsg.VideoService", "getNeedRunInfo needSendList size: " + ((List)localObject2).size());
      Object localObject2 = ((List)localObject2).iterator();
      while (((Iterator)localObject2).hasNext())
      {
        String str = (String)((Iterator)localObject2).next();
        if (this.hxG.containsKey(str))
        {
          Log.d("MicroMsg.VideoService", "need sendList File is Already running:".concat(String.valueOf(str)));
        }
        else
        {
          this.hxE.offer(str);
          this.hxG.put(str, null);
        }
      }
      if (localObject3 != null)
      {
        Log.d("MicroMsg.VideoService", "getNeedRunInfo needRecvList size: " + ((List)localObject3).size());
        localObject2 = ((List)localObject3).iterator();
        while (((Iterator)localObject2).hasNext())
        {
          localObject3 = (String)((Iterator)localObject2).next();
          if (this.hxG.containsKey(localObject3))
          {
            Log.d("MicroMsg.VideoService", "need recvList File is Already running:".concat(String.valueOf(localObject3)));
          }
          else
          {
            this.hxF.offer(localObject3);
            this.hxG.put(localObject3, null);
          }
        }
      }
      if (localObject1 != null)
      {
        Log.d("MicroMsg.VideoService", "getNeedRunInfo online video list size: " + ((List)localObject1).size());
        localObject1 = ((List)localObject1).iterator();
        while (((Iterator)localObject1).hasNext())
        {
          localObject2 = (String)((Iterator)localObject1).next();
          if (this.hxG.containsKey(localObject2))
          {
            Log.d("MicroMsg.VideoService", "online videoList File is Already running:".concat(String.valueOf(localObject2)));
          }
          else
          {
            this.pbZ.offer(localObject2);
            this.hxG.put(localObject2, null);
          }
        }
      }
      Log.i("MicroMsg.VideoService", "GetNeedRun cost time[%d] procing[%d] [recv:%d, online:%d, send:%d ]", new Object[] { Long.valueOf(Util.ticksToNow(l)), Integer.valueOf(this.hxG.size()), Integer.valueOf(this.hxF.size()), Integer.valueOf(this.pbZ.size()), Integer.valueOf(this.hxE.size()) });
      if (this.hxF.size() + this.hxE.size() + this.pbZ.size() != 0)
      {
        AppMethodBeat.o(127045);
        return true;
      }
      AppMethodBeat.o(127045);
      return false;
    }
    
    public final void Qx(String paramString)
    {
      AppMethodBeat.i(127051);
      this.hxG.remove(paramString);
      AppMethodBeat.o(127051);
    }
    
    public final void a(aa.a.a parama)
    {
      AppMethodBeat.i(127053);
      Object localObject = (WeakReference)this.pcd.get(parama.fileName);
      if (localObject != null)
      {
        localObject = (aa.a)((WeakReference)localObject).get();
        if (localObject != null) {
          ((aa.a)localObject).a(parama);
        }
      }
      localObject = ab.Qo(parama.fileName);
      if ((localObject != null) && (((z)localObject).status == 199)) {
        this.pcd.remove(parama.fileName);
      }
      AppMethodBeat.o(127053);
    }
    
    public final void a(ad paramad)
    {
      AppMethodBeat.i(127043);
      Log.printInfoStack("MicroMsg.VideoService", "addVideoMsgSendCallback %s", new Object[] { paramad });
      if ((paramad != null) && (this.pbY != null) && (!this.pbY.contains(paramad))) {
        this.pbY.add(paramad);
      }
      AppMethodBeat.o(127043);
    }
    
    public final void a(final String paramString, aa.a parama)
    {
      AppMethodBeat.i(127052);
      this.pcd.put(paramString, new WeakReference(parama));
      com.tencent.mm.kernel.h.baH().postToWorker(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(127041);
          ab.bh(paramString, this.pcf);
          z localz = ab.Qo(paramString);
          if ((localz != null) && (localz.status != 199))
          {
            if (localz.bOw())
            {
              Log.i("MicroMsg.VideoService", "start complete online video");
              ab.Qu(paramString);
              AppMethodBeat.o(127041);
              return;
            }
            Log.i("MicroMsg.VideoService", "start complete offline video");
            ab.Qj(paramString);
          }
          AppMethodBeat.o(127041);
        }
      });
      AppMethodBeat.o(127052);
    }
    
    public final void b(ad paramad)
    {
      AppMethodBeat.i(127044);
      if ((paramad != null) && (this.pbY != null)) {
        this.pbY.remove(paramad);
      }
      AppMethodBeat.o(127044);
    }
    
    public final boolean bOJ()
    {
      AppMethodBeat.i(127049);
      boolean bool;
      if (this.pcb != null)
      {
        com.tencent.mm.kernel.h.aZW().a(this.pcb);
        bool = true;
        this.running = false;
      }
      for (;;)
      {
        this.hxG.clear();
        this.hxE.clear();
        this.hxF.clear();
        this.pbZ.clear();
        this.pca.clear();
        AppMethodBeat.o(127049);
        return bool;
        bool = false;
      }
    }
    
    public final void bOK()
    {
      AppMethodBeat.i(127050);
      com.tencent.mm.kernel.h.aZW().a(this.pcb);
      aHh();
      AppMethodBeat.o(127050);
    }
    
    public final void onSceneEnd(final int paramInt1, final int paramInt2, String paramString, final p paramp)
    {
      AppMethodBeat.i(127046);
      if ((!this.pbX) || (this.pbW == null))
      {
        Log.e("MicroMsg.VideoService", "onSceneEnd error!, handler or thread is null!");
        AppMethodBeat.o(127046);
        return;
      }
      this.pbW.post(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(127037);
          ag.a.bFC();
          String str;
          int i;
          if (paramp.getType() == 150)
          {
            ag.a.b(ag.a.this);
            str = ((h)paramp).fileName;
            ag.pbV = str;
            i = ((h)paramp).retCode;
            ag.a.c(ag.a.this);
          }
          for (;;)
          {
            long l2 = 0L;
            long l1 = l2;
            if (str != null)
            {
              l1 = l2;
              if (ag.a.this.hxG.get(str) != null)
              {
                l1 = ((f.a)ag.a.this.hxG.get(str)).aPY();
                ag.a.this.hxG.remove(str);
              }
            }
            Log.d("MicroMsg.VideoService", "onSceneEnd SceneType:" + paramp.getType() + " errtype:" + paramInt1 + " errCode:" + paramInt2 + " retCode:" + i + " file:" + str + " time:" + l1 + " scene = " + paramp);
            if ((paramInt1 == 3) && (i != 0))
            {
              ag.a.f(ag.a.this);
              label244:
              Log.d("MicroMsg.VideoService", "onSceneEnd  inCnt:" + ag.a.pae + " stop:" + ag.a.g(ag.a.this) + " running:" + ag.a.h(ag.a.this) + " recving:" + ag.a.i(ag.a.this) + " sending:" + ag.a.j(ag.a.this));
              if (ag.a.g(ag.a.this) <= 0) {
                break label556;
              }
              ag.a.a(ag.a.this);
            }
            for (;;)
            {
              ag.a.bOL();
              AppMethodBeat.o(127037);
              return;
              if (paramp.getType() == 149)
              {
                if ((paramInt1 == 4) && (paramInt2 == 102) && (((c)com.tencent.mm.kernel.h.ax(c.class)).a(c.a.zvy, true)))
                {
                  Log.i("MicroMsg.VideoService", "upload video returns 102 code, waiting for the retried response");
                  ag.a.bOL();
                  AppMethodBeat.o(127037);
                  return;
                }
                ag.a.d(ag.a.this);
                ag.a.e(ag.a.this);
                if ((paramp instanceof k))
                {
                  str = ((k)paramp).fileName;
                  i = ((k)paramp).retCode;
                  break;
                }
                if (!(paramp instanceof l)) {
                  break label586;
                }
                str = ((l)paramp).fileName;
                i = 0;
                break;
              }
              Log.e("MicroMsg.VideoService", "onSceneEnd Error SceneType:" + paramp.getType());
              ag.a.bOL();
              AppMethodBeat.o(127037);
              return;
              if (paramInt1 == 0) {
                break label244;
              }
              ag.a.a(ag.a.this, 0);
              break label244;
              label556:
              if ((!ag.a.j(ag.a.this)) && (!ag.a.i(ag.a.this))) {
                ag.a.k(ag.a.this);
              }
            }
            label586:
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
      if ((!this.pbX) || (this.pbW == null))
      {
        Log.e("MicroMsg.VideoService", "run error!, handler or thread is null!");
        AppMethodBeat.o(127048);
        return;
      }
      this.pbW.post(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(127039);
          long l = System.currentTimeMillis() - ag.a.l(ag.a.this);
          Log.d("MicroMsg.VideoService", "Try Run service runningFlag:" + ag.a.h(ag.a.this) + " timeWait:" + l + " sending:" + ag.a.j(ag.a.this) + " recving:" + ag.a.i(ag.a.this));
          if (ag.a.h(ag.a.this))
          {
            if (l < 60000L)
            {
              AppMethodBeat.o(127039);
              return;
            }
            Log.e("MicroMsg.VideoService", "ERR: Try Run service runningFlag:" + ag.a.h(ag.a.this) + " timeWait:" + l + ">=MAX_TIME_WAIT sending:" + ag.a.j(ag.a.this) + " recving:" + ag.a.i(ag.a.this));
          }
          ag.a.a(ag.a.this, 3);
          ag.a.m(ag.a.this);
          ag.a.d(ag.a.this);
          ag.a.b(ag.a.this);
          ag.a.e(ag.a.this);
          ag.a.c(ag.a.this);
          ag.a.this.hxM.lYS = SystemClock.elapsedRealtime();
          ag.a.n(ag.a.this).startTimer(10L);
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
 * Qualified Name:     com.tencent.mm.modelvideo.ag
 * JD-Core Version:    0.7.0.1
 */