package com.tencent.mm.audio.b;

import android.os.SystemClock;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.q;
import com.tencent.mm.ak.t;
import com.tencent.mm.compatible.util.f.a;
import com.tencent.mm.kernel.g;
import com.tencent.mm.modelvoice.e;
import com.tencent.mm.modelvoice.f;
import com.tencent.mm.modelvoice.r;
import com.tencent.mm.modelvoice.s;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMHandlerThread;
import com.tencent.mm.sdk.platformtools.MMStack;
import com.tencent.mm.sdk.platformtools.MTimerHandler;
import com.tencent.mm.sdk.platformtools.Util;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;

public final class i
  implements com.tencent.mm.ak.i
{
  public static boolean dAH = true;
  Queue<String> dAA;
  Queue<r> dAB;
  Map<String, f.a> dAC;
  private boolean dAD;
  private boolean dAE;
  public int dAF;
  private long dAG;
  f.a dAI;
  private MTimerHandler dAJ;
  private boolean running;
  
  public i()
  {
    AppMethodBeat.i(148358);
    this.dAA = new LinkedList();
    this.dAB = new LinkedList();
    this.dAC = new HashMap();
    this.dAD = false;
    this.dAE = false;
    this.running = false;
    this.dAF = 0;
    this.dAG = 0L;
    this.dAI = new f.a();
    this.dAJ = new MTimerHandler(g.aAk().getLooper(), new i.3(this), false);
    Log.i("MicroMsg.SceneVoiceService", "SceneVoiceService %s", new Object[] { Util.getStack().toString() });
    g.azz().a(127, this);
    g.azz().a(128, this);
    AppMethodBeat.o(148358);
  }
  
  public static final i aaw()
  {
    AppMethodBeat.i(187328);
    i locali = a.aay();
    AppMethodBeat.o(187328);
    return locali;
  }
  
  private void aax()
  {
    AppMethodBeat.i(148360);
    this.dAC.clear();
    this.dAA.clear();
    this.dAB.clear();
    this.dAE = false;
    this.dAD = false;
    this.running = false;
    Log.i("MicroMsg.SceneVoiceService", "Finish service use time(ms):" + this.dAI.apr() + "[" + toString() + "]");
    AppMethodBeat.o(148360);
  }
  
  public final void onSceneEnd(final int paramInt1, final int paramInt2, String paramString, final q paramq)
  {
    AppMethodBeat.i(148359);
    String str1 = toString();
    String str2 = Util.nullAs(paramString, "");
    if (paramq != null) {}
    for (paramString = paramq.toString();; paramString = Integer.valueOf(0))
    {
      Log.i("MicroMsg.SceneVoiceService", "[%s]errType:%s errCode:%s errMsg:%s scene:%s", new Object[] { str1, Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), str2, paramString });
      g.aAk().postToWorker(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(148352);
          String str;
          int i;
          if (paramq.getType() == 128)
          {
            i.a(i.this);
            str = ((e)paramq).fileName;
            i = ((e)paramq).retCode;
            r localr = s.Ro(str);
            if ((paramq.getType() == 128) && (localr != null) && (localr.bih()) && (localr.status != 98))
            {
              s.QE(str);
              Log.w("MicroMsg.SceneVoiceService", "re-download set error");
            }
            long l2 = 0L;
            long l1 = l2;
            if (str != null)
            {
              l1 = l2;
              if (i.this.dAC.get(str) != null)
              {
                l1 = ((f.a)i.this.dAC.get(str)).apr();
                i.this.dAC.remove(str);
              }
            }
            Log.i("MicroMsg.SceneVoiceService", "onSceneEnd SceneType:" + paramq.getType() + " errtype:" + paramInt1 + " errCode:" + paramInt2 + " retCode:" + i + " file:" + str + " time:" + l1);
            if ((paramInt1 != 3) || (i == 0)) {
              break label445;
            }
            i.c(i.this);
          }
          for (;;)
          {
            Log.i("MicroMsg.SceneVoiceService", "onSceneEnd stop:" + i.d(i.this) + " running:" + i.e(i.this) + " recving:" + i.f(i.this) + " sending:" + i.g(i.this));
            if (i.d(i.this) <= 0) {
              break label464;
            }
            i.h(i.this);
            AppMethodBeat.o(148352);
            return;
            if (paramq.getType() == 127)
            {
              i.b(i.this);
              str = ((f)paramq).fileName;
              i = ((f)paramq).retCode;
              break;
            }
            Log.e("MicroMsg.SceneVoiceService", "onSceneEnd Error SceneType:" + paramq.getType());
            AppMethodBeat.o(148352);
            return;
            label445:
            if (paramInt1 != 0) {
              i.a(i.this, 0);
            }
          }
          label464:
          if ((!i.g(i.this)) && (!i.f(i.this)))
          {
            i.i(i.this);
            Log.i("MicroMsg.SceneVoiceService", "onSceneEnd fin and try next delay 3s [%d, %d] [%b]", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(i), Boolean.valueOf(i.dAH) });
            if ((i.dAH) && (paramInt1 == 4)) {
              g.aAk().postToWorkerDelayed(new Runnable()
              {
                public final void run()
                {
                  AppMethodBeat.i(148351);
                  Log.i("MicroMsg.SceneVoiceService", "onSceneEnd fin and try run");
                  i.this.run();
                  AppMethodBeat.o(148351);
                }
              }, 10000L);
            }
          }
          AppMethodBeat.o(148352);
        }
        
        public final String toString()
        {
          AppMethodBeat.i(148353);
          String str = super.toString() + "|onSceneEnd";
          AppMethodBeat.o(148353);
          return str;
        }
      });
      AppMethodBeat.o(148359);
      return;
    }
  }
  
  public final void run()
  {
    AppMethodBeat.i(148361);
    Log.i("MicroMsg.SceneVoiceService", "run() %s", new Object[] { toString() });
    g.aAk().postToWorker(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(148354);
        long l = System.currentTimeMillis() - i.j(i.this);
        Log.i("MicroMsg.SceneVoiceService", "Try Run service runningFlag:" + i.e(i.this) + " timeWait:" + l + " sending:" + i.g(i.this) + " recving:" + i.f(i.this) + "[" + i.this.toString() + "]");
        if (i.e(i.this))
        {
          if (l < 60000L)
          {
            AppMethodBeat.o(148354);
            return;
          }
          Log.e("MicroMsg.SceneVoiceService", "ERR: Try Run service runningFlag:" + i.e(i.this) + " timeWait:" + l + ">=MAX_TIME_WAIT sending:" + i.g(i.this) + " recving:" + i.f(i.this));
        }
        i.k(i.this);
        i.b(i.this);
        i.a(i.this, 3);
        i.a(i.this);
        i.this.dAI.gLm = SystemClock.elapsedRealtime();
        i.l(i.this).startTimer(10L);
        AppMethodBeat.o(148354);
      }
      
      public final String toString()
      {
        AppMethodBeat.i(148355);
        String str = super.toString() + "|run";
        AppMethodBeat.o(148355);
        return str;
      }
    });
    AppMethodBeat.o(148361);
  }
  
  static final class a
  {
    private static final i dAN;
    
    static
    {
      AppMethodBeat.i(187327);
      dAN = new i();
      AppMethodBeat.o(187327);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.audio.b.i
 * JD-Core Version:    0.7.0.1
 */