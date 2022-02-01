package com.tencent.mm.modelvideo;

import android.os.Looper;
import android.os.SystemClock;
import com.tencent.e.j.a;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.an.i;
import com.tencent.mm.an.q;
import com.tencent.mm.an.t;
import com.tencent.mm.compatible.util.f.a;
import com.tencent.mm.modelcontrol.VideoTransPara;
import com.tencent.mm.plugin.expt.b.b;
import com.tencent.mm.plugin.expt.b.b.a;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMHandler;
import com.tencent.mm.sdk.platformtools.MMHandlerThread;
import com.tencent.mm.sdk.platformtools.MTimerHandler;
import com.tencent.mm.sdk.platformtools.MTimerHandler.CallBack;
import com.tencent.mm.sdk.platformtools.Util;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.concurrent.ConcurrentHashMap;

public final class ac
{
  public static String miy = null;
  
  public static final class a
    implements i, x.a
  {
    private static int mgU = 0;
    Queue<String> ftp;
    Queue<String> ftq;
    Map<String, f.a> ftr;
    boolean fts;
    private boolean ftt;
    int ftu;
    private long ftv;
    f.a ftx;
    private MTimerHandler fty;
    private VideoTransPara mhG;
    private VideoTransPara mhH;
    boolean miA;
    private List<aa> miB;
    Queue<String> miC;
    Queue<String> miD;
    h miE;
    k miF;
    ConcurrentHashMap<String, WeakReference<x.a>> miG;
    MMHandler miz;
    private boolean running;
    
    public a()
    {
      AppMethodBeat.i(127042);
      this.miA = false;
      this.fty = null;
      this.mhG = null;
      this.mhH = null;
      this.miB = new ArrayList();
      this.ftp = new LinkedList();
      this.ftq = new LinkedList();
      this.miC = new LinkedList();
      this.miD = new LinkedList();
      this.ftr = new HashMap();
      this.fts = false;
      this.ftt = false;
      this.running = false;
      this.ftu = 0;
      this.ftv = 0L;
      this.miE = null;
      this.miF = null;
      this.ftx = new f.a();
      this.miG = new ConcurrentHashMap();
      com.tencent.mm.kernel.h.aGY().a(149, this);
      com.tencent.mm.kernel.h.aGY().a(150, this);
      s.bqB().a(this, Looper.getMainLooper());
      this.miA = true;
      a locala = a.bDn("VideoService_runThread");
      this.miz = new MMHandler(locala);
      this.fty = new MTimerHandler(locala, new MTimerHandler.CallBack()
      {
        public final boolean onTimerExpired()
        {
          AppMethodBeat.i(127035);
          ac.a.a(ac.a.this);
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
    
    private void afk()
    {
      AppMethodBeat.i(127047);
      this.ftr.clear();
      this.ftp.clear();
      this.ftq.clear();
      this.miC.clear();
      this.miD.clear();
      this.ftt = false;
      this.fts = false;
      this.running = false;
      Log.i("MicroMsg.VideoService", "Finish service use time(ms):" + this.ftx.avE());
      AppMethodBeat.o(127047);
    }
    
    private boolean brc()
    {
      AppMethodBeat.i(127045);
      long l = Util.currentTicks();
      if (s.bqB() == null)
      {
        Log.e("MicroMsg.VideoService", "error, video info storage is null!!");
        AppMethodBeat.o(127045);
        return false;
      }
      Object localObject3;
      try
      {
        x localx = s.bqB();
        localObject2 = new LinkedList();
        localObject3 = x.d.lOO.iterator();
        while (((Iterator)localObject3).hasNext()) {
          ((List)localObject2).addAll(localx.XQ(((x.c)((Iterator)localObject3).next()).table));
        }
        localObject3 = s.bqB().bqY();
      }
      catch (Exception localException)
      {
        Log.printErrStackTrace("MicroMsg.VideoService", localException, "getNeedRunInfo error: %s", new Object[] { localException.getMessage() });
        AppMethodBeat.o(127045);
        return false;
      }
      Object localObject1 = s.bqB().bqZ();
      Log.d("MicroMsg.VideoService", "getNeedRunInfo needSendList size: " + ((List)localObject2).size());
      Object localObject2 = ((List)localObject2).iterator();
      while (((Iterator)localObject2).hasNext())
      {
        String str = (String)((Iterator)localObject2).next();
        if (this.ftr.containsKey(str))
        {
          Log.d("MicroMsg.VideoService", "need sendList File is Already running:".concat(String.valueOf(str)));
        }
        else
        {
          this.ftp.offer(str);
          this.ftr.put(str, null);
        }
      }
      Log.d("MicroMsg.VideoService", "getNeedRunInfo needRecvList size: " + ((List)localObject3).size());
      localObject2 = ((List)localObject3).iterator();
      while (((Iterator)localObject2).hasNext())
      {
        localObject3 = (String)((Iterator)localObject2).next();
        if (this.ftr.containsKey(localObject3))
        {
          Log.d("MicroMsg.VideoService", "need recvList File is Already running:".concat(String.valueOf(localObject3)));
        }
        else
        {
          this.ftq.offer(localObject3);
          this.ftr.put(localObject3, null);
        }
      }
      Log.d("MicroMsg.VideoService", "getNeedRunInfo online video list size: " + ((List)localObject1).size());
      localObject1 = ((List)localObject1).iterator();
      while (((Iterator)localObject1).hasNext())
      {
        localObject2 = (String)((Iterator)localObject1).next();
        if (this.ftr.containsKey(localObject2))
        {
          Log.d("MicroMsg.VideoService", "online videoList File is Already running:".concat(String.valueOf(localObject2)));
        }
        else
        {
          this.miC.offer(localObject2);
          this.ftr.put(localObject2, null);
        }
      }
      Log.i("MicroMsg.VideoService", "GetNeedRun cost time[%d] procing[%d] [recv:%d, online:%d, send:%d ]", new Object[] { Long.valueOf(Util.ticksToNow(l)), Integer.valueOf(this.ftr.size()), Integer.valueOf(this.ftq.size()), Integer.valueOf(this.miC.size()), Integer.valueOf(this.ftp.size()) });
      if (this.ftq.size() + this.ftp.size() + this.miC.size() != 0)
      {
        AppMethodBeat.o(127045);
        return true;
      }
      AppMethodBeat.o(127045);
      return false;
    }
    
    public final void Ys(String paramString)
    {
      AppMethodBeat.i(127051);
      this.ftr.remove(paramString);
      AppMethodBeat.o(127051);
    }
    
    public final void a(aa paramaa)
    {
      AppMethodBeat.i(127043);
      Log.printInfoStack("MicroMsg.VideoService", "addVideoMsgSendCallback %s", new Object[] { paramaa });
      if ((paramaa != null) && (this.miB != null) && (!this.miB.contains(paramaa))) {
        this.miB.add(paramaa);
      }
      AppMethodBeat.o(127043);
    }
    
    public final void a(x.a.a parama)
    {
      AppMethodBeat.i(127053);
      Object localObject = (WeakReference)this.miG.get(parama.fileName);
      if (localObject != null)
      {
        localObject = (x.a)((WeakReference)localObject).get();
        if (localObject != null) {
          ((x.a)localObject).a(parama);
        }
      }
      localObject = y.Yk(parama.fileName);
      if ((localObject != null) && (((w)localObject).status == 199)) {
        this.miG.remove(parama.fileName);
      }
      AppMethodBeat.o(127053);
    }
    
    public final void a(final String paramString, x.a parama)
    {
      AppMethodBeat.i(127052);
      this.miG.put(paramString, new WeakReference(parama));
      com.tencent.mm.kernel.h.aHJ().postToWorker(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(127041);
          y.aT(paramString, this.miI);
          w localw = y.Yk(paramString);
          if ((localw != null) && (localw.status != 199))
          {
            if (localw.bqR())
            {
              Log.i("MicroMsg.VideoService", "start complete online video");
              y.Yq(paramString);
              AppMethodBeat.o(127041);
              return;
            }
            Log.i("MicroMsg.VideoService", "start complete offline video");
            y.Yf(paramString);
          }
          AppMethodBeat.o(127041);
        }
      });
      AppMethodBeat.o(127052);
    }
    
    public final void b(aa paramaa)
    {
      AppMethodBeat.i(127044);
      if ((paramaa != null) && (this.miB != null)) {
        this.miB.remove(paramaa);
      }
      AppMethodBeat.o(127044);
    }
    
    public final boolean brd()
    {
      AppMethodBeat.i(127049);
      boolean bool;
      if (this.miE != null)
      {
        com.tencent.mm.kernel.h.aGY().a(this.miE);
        bool = true;
        this.running = false;
      }
      for (;;)
      {
        this.ftr.clear();
        this.ftp.clear();
        this.ftq.clear();
        this.miC.clear();
        this.miD.clear();
        AppMethodBeat.o(127049);
        return bool;
        bool = false;
      }
    }
    
    public final void bre()
    {
      AppMethodBeat.i(127050);
      com.tencent.mm.kernel.h.aGY().a(this.miE);
      afk();
      AppMethodBeat.o(127050);
    }
    
    public final void onSceneEnd(final int paramInt1, final int paramInt2, String paramString, final q paramq)
    {
      AppMethodBeat.i(127046);
      if ((!this.miA) || (this.miz == null))
      {
        Log.e("MicroMsg.VideoService", "onSceneEnd error!, handler or thread is null!");
        AppMethodBeat.o(127046);
        return;
      }
      this.miz.post(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(127037);
          ac.a.bhN();
          String str;
          int i;
          if (paramq.getType() == 150)
          {
            ac.a.b(ac.a.this);
            str = ((h)paramq).fileName;
            ac.miy = str;
            i = ((h)paramq).retCode;
            ac.a.c(ac.a.this);
          }
          for (;;)
          {
            long l2 = 0L;
            long l1 = l2;
            if (str != null)
            {
              l1 = l2;
              if (ac.a.this.ftr.get(str) != null)
              {
                l1 = ((f.a)ac.a.this.ftr.get(str)).avE();
                ac.a.this.ftr.remove(str);
              }
            }
            Log.d("MicroMsg.VideoService", "onSceneEnd SceneType:" + paramq.getType() + " errtype:" + paramInt1 + " errCode:" + paramInt2 + " retCode:" + i + " file:" + str + " time:" + l1);
            if ((paramInt1 == 3) && (i != 0))
            {
              ac.a.f(ac.a.this);
              label232:
              Log.d("MicroMsg.VideoService", "onSceneEnd  inCnt:" + ac.a.mgU + " stop:" + ac.a.g(ac.a.this) + " running:" + ac.a.h(ac.a.this) + " recving:" + ac.a.i(ac.a.this) + " sending:" + ac.a.j(ac.a.this));
              if (ac.a.g(ac.a.this) <= 0) {
                break label544;
              }
              ac.a.a(ac.a.this);
            }
            for (;;)
            {
              ac.a.brf();
              AppMethodBeat.o(127037);
              return;
              if (paramq.getType() == 149)
              {
                if ((paramInt1 == 4) && (paramInt2 == 102) && (((b)com.tencent.mm.kernel.h.ae(b.class)).a(b.a.wca, true)))
                {
                  Log.i("MicroMsg.VideoService", "upload video returns 102 code, waiting for the retried response");
                  ac.a.brf();
                  AppMethodBeat.o(127037);
                  return;
                }
                ac.a.d(ac.a.this);
                ac.a.e(ac.a.this);
                if ((paramq instanceof k))
                {
                  str = ((k)paramq).fileName;
                  i = ((k)paramq).retCode;
                  break;
                }
                if (!(paramq instanceof l)) {
                  break label574;
                }
                str = ((l)paramq).fileName;
                i = 0;
                break;
              }
              Log.e("MicroMsg.VideoService", "onSceneEnd Error SceneType:" + paramq.getType());
              ac.a.brf();
              AppMethodBeat.o(127037);
              return;
              if (paramInt1 == 0) {
                break label232;
              }
              ac.a.a(ac.a.this, 0);
              break label232;
              label544:
              if ((!ac.a.j(ac.a.this)) && (!ac.a.i(ac.a.this))) {
                ac.a.k(ac.a.this);
              }
            }
            label574:
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
      if ((!this.miA) || (this.miz == null))
      {
        Log.e("MicroMsg.VideoService", "run error!, handler or thread is null!");
        AppMethodBeat.o(127048);
        return;
      }
      this.miz.post(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(127039);
          long l = System.currentTimeMillis() - ac.a.l(ac.a.this);
          Log.d("MicroMsg.VideoService", "Try Run service runningFlag:" + ac.a.h(ac.a.this) + " timeWait:" + l + " sending:" + ac.a.j(ac.a.this) + " recving:" + ac.a.i(ac.a.this));
          if (ac.a.h(ac.a.this))
          {
            if (l < 60000L)
            {
              AppMethodBeat.o(127039);
              return;
            }
            Log.e("MicroMsg.VideoService", "ERR: Try Run service runningFlag:" + ac.a.h(ac.a.this) + " timeWait:" + l + ">=MAX_TIME_WAIT sending:" + ac.a.j(ac.a.this) + " recving:" + ac.a.i(ac.a.this));
          }
          ac.a.a(ac.a.this, 3);
          ac.a.m(ac.a.this);
          ac.a.d(ac.a.this);
          ac.a.b(ac.a.this);
          ac.a.e(ac.a.this);
          ac.a.c(ac.a.this);
          ac.a.this.ftx.jvB = SystemClock.elapsedRealtime();
          ac.a.n(ac.a.this).startTimer(10L);
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
 * Qualified Name:     com.tencent.mm.modelvideo.ac
 * JD-Core Version:    0.7.0.1
 */