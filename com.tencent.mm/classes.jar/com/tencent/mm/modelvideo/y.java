package com.tencent.mm.modelvideo;

import android.os.Looper;
import android.os.SystemClock;
import com.tencent.f.j.a;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.i;
import com.tencent.mm.ak.q;
import com.tencent.mm.compatible.util.f.a;
import com.tencent.mm.modelcontrol.VideoTransPara;
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

public final class y
{
  public static String jsU = null;
  
  public static final class a
    implements i, t.a
  {
    private static int jrr = 0;
    Queue<String> dAA;
    Queue<String> dAB;
    Map<String, f.a> dAC;
    boolean dAD;
    private boolean dAE;
    int dAF;
    private long dAG;
    f.a dAI;
    private MTimerHandler dAJ;
    MMHandler jsV;
    boolean jsW;
    private List<w> jsX;
    Queue<String> jsY;
    Queue<String> jsZ;
    private VideoTransPara jsd;
    private VideoTransPara jse;
    d jta;
    g jtb;
    ConcurrentHashMap<String, WeakReference<t.a>> jtc;
    private boolean running;
    
    public a()
    {
      AppMethodBeat.i(127042);
      this.jsW = false;
      this.dAJ = null;
      this.jsd = null;
      this.jse = null;
      this.jsX = new ArrayList();
      this.dAA = new LinkedList();
      this.dAB = new LinkedList();
      this.jsY = new LinkedList();
      this.jsZ = new LinkedList();
      this.dAC = new HashMap();
      this.dAD = false;
      this.dAE = false;
      this.running = false;
      this.dAF = 0;
      this.dAG = 0L;
      this.jta = null;
      this.jtb = null;
      this.dAI = new f.a();
      this.jtc = new ConcurrentHashMap();
      com.tencent.mm.kernel.g.azz().a(149, this);
      com.tencent.mm.kernel.g.azz().a(150, this);
      o.bhj().a(this, Looper.getMainLooper());
      this.jsW = true;
      a locala = a.bqt("VideoService_runThread");
      this.jsV = new MMHandler(locala);
      this.dAJ = new MTimerHandler(locala, new MTimerHandler.CallBack()
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
      Log.i("MicroMsg.VideoService", "create VideoService, start video send thread");
      AppMethodBeat.o(127042);
    }
    
    private void aax()
    {
      AppMethodBeat.i(127047);
      this.dAC.clear();
      this.dAA.clear();
      this.dAB.clear();
      this.jsY.clear();
      this.jsZ.clear();
      this.dAE = false;
      this.dAD = false;
      this.running = false;
      Log.i("MicroMsg.VideoService", "Finish service use time(ms):" + this.dAI.apr());
      AppMethodBeat.o(127047);
    }
    
    private boolean bhF()
    {
      AppMethodBeat.i(127045);
      long l = Util.currentTicks();
      if (o.bhj() == null)
      {
        Log.e("MicroMsg.VideoService", "error, video info storage is null!!");
        AppMethodBeat.o(127045);
        return false;
      }
      Object localObject3;
      try
      {
        t localt = o.bhj();
        localObject2 = new LinkedList();
        localObject3 = t.d.iYu.iterator();
        while (((Iterator)localObject3).hasNext()) {
          ((List)localObject2).addAll(localt.Qt(((t.c)((Iterator)localObject3).next()).table));
        }
        localObject3 = o.bhj().bhC();
      }
      catch (Exception localException)
      {
        Log.printErrStackTrace("MicroMsg.VideoService", localException, "getNeedRunInfo error: %s", new Object[] { localException.getMessage() });
        AppMethodBeat.o(127045);
        return false;
      }
      Object localObject1 = o.bhj().bhD();
      Log.d("MicroMsg.VideoService", "getNeedRunInfo needSendList size: " + ((List)localObject2).size());
      Object localObject2 = ((List)localObject2).iterator();
      while (((Iterator)localObject2).hasNext())
      {
        String str = (String)((Iterator)localObject2).next();
        if (this.dAC.containsKey(str))
        {
          Log.d("MicroMsg.VideoService", "need sendList File is Already running:".concat(String.valueOf(str)));
        }
        else
        {
          this.dAA.offer(str);
          this.dAC.put(str, null);
        }
      }
      Log.d("MicroMsg.VideoService", "getNeedRunInfo needRecvList size: " + ((List)localObject3).size());
      localObject2 = ((List)localObject3).iterator();
      while (((Iterator)localObject2).hasNext())
      {
        localObject3 = (String)((Iterator)localObject2).next();
        if (this.dAC.containsKey(localObject3))
        {
          Log.d("MicroMsg.VideoService", "need recvList File is Already running:".concat(String.valueOf(localObject3)));
        }
        else
        {
          this.dAB.offer(localObject3);
          this.dAC.put(localObject3, null);
        }
      }
      Log.d("MicroMsg.VideoService", "getNeedRunInfo online video list size: " + ((List)localObject1).size());
      localObject1 = ((List)localObject1).iterator();
      while (((Iterator)localObject1).hasNext())
      {
        localObject2 = (String)((Iterator)localObject1).next();
        if (this.dAC.containsKey(localObject2))
        {
          Log.d("MicroMsg.VideoService", "online videoList File is Already running:".concat(String.valueOf(localObject2)));
        }
        else
        {
          this.jsY.offer(localObject2);
          this.dAC.put(localObject2, null);
        }
      }
      Log.i("MicroMsg.VideoService", "GetNeedRun cost time[%d] procing[%d] [recv:%d, online:%d, send:%d ]", new Object[] { Long.valueOf(Util.ticksToNow(l)), Integer.valueOf(this.dAC.size()), Integer.valueOf(this.dAB.size()), Integer.valueOf(this.jsY.size()), Integer.valueOf(this.dAA.size()) });
      if (this.dAB.size() + this.dAA.size() + this.jsY.size() != 0)
      {
        AppMethodBeat.o(127045);
        return true;
      }
      AppMethodBeat.o(127045);
      return false;
    }
    
    public final void QV(String paramString)
    {
      AppMethodBeat.i(127051);
      this.dAC.remove(paramString);
      AppMethodBeat.o(127051);
    }
    
    public final void a(t.a.a parama)
    {
      AppMethodBeat.i(127053);
      Object localObject = (WeakReference)this.jtc.get(parama.fileName);
      if (localObject != null)
      {
        localObject = (t.a)((WeakReference)localObject).get();
        if (localObject != null) {
          ((t.a)localObject).a(parama);
        }
      }
      localObject = u.QN(parama.fileName);
      if ((localObject != null) && (((s)localObject).status == 199)) {
        this.jtc.remove(parama.fileName);
      }
      AppMethodBeat.o(127053);
    }
    
    public final void a(w paramw)
    {
      AppMethodBeat.i(127043);
      Log.printInfoStack("MicroMsg.VideoService", "addVideoMsgSendCallback %s", new Object[] { paramw });
      if ((paramw != null) && (this.jsX != null) && (!this.jsX.contains(paramw))) {
        this.jsX.add(paramw);
      }
      AppMethodBeat.o(127043);
    }
    
    public final void a(final String paramString, t.a parama)
    {
      AppMethodBeat.i(127052);
      this.jtc.put(paramString, new WeakReference(parama));
      com.tencent.mm.kernel.g.aAk().postToWorker(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(127041);
          u.aA(paramString, this.jte);
          s locals = u.QN(paramString);
          if ((locals != null) && (locals.status != 199))
          {
            if (locals.bhx())
            {
              Log.i("MicroMsg.VideoService", "start complete online video");
              u.QT(paramString);
              AppMethodBeat.o(127041);
              return;
            }
            Log.i("MicroMsg.VideoService", "start complete offline video");
            u.QI(paramString);
          }
          AppMethodBeat.o(127041);
        }
      });
      AppMethodBeat.o(127052);
    }
    
    public final void b(w paramw)
    {
      AppMethodBeat.i(127044);
      if ((paramw != null) && (this.jsX != null)) {
        this.jsX.remove(paramw);
      }
      AppMethodBeat.o(127044);
    }
    
    public final boolean bhG()
    {
      AppMethodBeat.i(127049);
      boolean bool;
      if (this.jta != null)
      {
        com.tencent.mm.kernel.g.azz().a(this.jta);
        bool = true;
        this.running = false;
      }
      for (;;)
      {
        this.dAC.clear();
        this.dAA.clear();
        this.dAB.clear();
        this.jsY.clear();
        this.jsZ.clear();
        AppMethodBeat.o(127049);
        return bool;
        bool = false;
      }
    }
    
    public final void bhH()
    {
      AppMethodBeat.i(127050);
      com.tencent.mm.kernel.g.azz().a(this.jta);
      aax();
      AppMethodBeat.o(127050);
    }
    
    public final void onSceneEnd(final int paramInt1, final int paramInt2, String paramString, final q paramq)
    {
      AppMethodBeat.i(127046);
      if ((!this.jsW) || (this.jsV == null))
      {
        Log.e("MicroMsg.VideoService", "onSceneEnd error!, handler or thread is null!");
        AppMethodBeat.o(127046);
        return;
      }
      this.jsV.post(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(127037);
          y.a.aYz();
          String str;
          int i;
          if (paramq.getType() == 150)
          {
            y.a.b(y.a.this);
            str = ((d)paramq).fileName;
            y.jsU = str;
            i = ((d)paramq).retCode;
            y.a.c(y.a.this);
          }
          for (;;)
          {
            long l2 = 0L;
            long l1 = l2;
            if (str != null)
            {
              l1 = l2;
              if (y.a.this.dAC.get(str) != null)
              {
                l1 = ((f.a)y.a.this.dAC.get(str)).apr();
                y.a.this.dAC.remove(str);
              }
            }
            Log.d("MicroMsg.VideoService", "onSceneEnd SceneType:" + paramq.getType() + " errtype:" + paramInt1 + " errCode:" + paramInt2 + " retCode:" + i + " file:" + str + " time:" + l1);
            if ((paramInt1 == 3) && (i != 0))
            {
              y.a.f(y.a.this);
              label232:
              Log.d("MicroMsg.VideoService", "onSceneEnd  inCnt:" + y.a.jrr + " stop:" + y.a.g(y.a.this) + " running:" + y.a.h(y.a.this) + " recving:" + y.a.i(y.a.this) + " sending:" + y.a.j(y.a.this));
              if (y.a.g(y.a.this) <= 0) {
                break label490;
              }
              y.a.a(y.a.this);
            }
            for (;;)
            {
              y.a.bhI();
              AppMethodBeat.o(127037);
              return;
              if (paramq.getType() == 149)
              {
                y.a.d(y.a.this);
                y.a.e(y.a.this);
                if ((paramq instanceof g))
                {
                  str = ((g)paramq).fileName;
                  i = ((g)paramq).retCode;
                  break;
                }
                if (!(paramq instanceof h)) {
                  break label520;
                }
                str = ((h)paramq).fileName;
                i = 0;
                break;
              }
              Log.e("MicroMsg.VideoService", "onSceneEnd Error SceneType:" + paramq.getType());
              y.a.bhI();
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
      if ((!this.jsW) || (this.jsV == null))
      {
        Log.e("MicroMsg.VideoService", "run error!, handler or thread is null!");
        AppMethodBeat.o(127048);
        return;
      }
      this.jsV.post(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(127039);
          long l = System.currentTimeMillis() - y.a.l(y.a.this);
          Log.d("MicroMsg.VideoService", "Try Run service runningFlag:" + y.a.h(y.a.this) + " timeWait:" + l + " sending:" + y.a.j(y.a.this) + " recving:" + y.a.i(y.a.this));
          if (y.a.h(y.a.this))
          {
            if (l < 60000L)
            {
              AppMethodBeat.o(127039);
              return;
            }
            Log.e("MicroMsg.VideoService", "ERR: Try Run service runningFlag:" + y.a.h(y.a.this) + " timeWait:" + l + ">=MAX_TIME_WAIT sending:" + y.a.j(y.a.this) + " recving:" + y.a.i(y.a.this));
          }
          y.a.a(y.a.this, 3);
          y.a.m(y.a.this);
          y.a.d(y.a.this);
          y.a.b(y.a.this);
          y.a.e(y.a.this);
          y.a.c(y.a.this);
          y.a.this.dAI.gLm = SystemClock.elapsedRealtime();
          y.a.n(y.a.this).startTimer(10L);
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.modelvideo.y
 * JD-Core Version:    0.7.0.1
 */