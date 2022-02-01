package com.tencent.mm.audio.b;

import android.os.SystemClock;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.am.p;
import com.tencent.mm.compatible.util.f.a;
import com.tencent.mm.modelvoice.e;
import com.tencent.mm.modelvoice.f;
import com.tencent.mm.modelvoice.r;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMHandlerThread;
import com.tencent.mm.sdk.platformtools.MMStack;
import com.tencent.mm.sdk.platformtools.MTimerHandler;
import com.tencent.mm.sdk.platformtools.MTimerHandler.CallBack;
import com.tencent.mm.sdk.platformtools.Util;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;

public final class i
  implements com.tencent.mm.am.h
{
  public static boolean hxL = true;
  Queue<String> hxE;
  Queue<r> hxF;
  Map<String, f.a> hxG;
  private boolean hxH;
  private boolean hxI;
  public int hxJ;
  private long hxK;
  f.a hxM;
  private MTimerHandler hxN;
  private boolean running;
  
  public i()
  {
    AppMethodBeat.i(148358);
    this.hxE = new LinkedList();
    this.hxF = new LinkedList();
    this.hxG = new HashMap();
    this.hxH = false;
    this.hxI = false;
    this.running = false;
    this.hxJ = 0;
    this.hxK = 0L;
    this.hxM = new f.a();
    this.hxN = new MTimerHandler(com.tencent.mm.kernel.h.baH().getLooper(), new MTimerHandler.CallBack()
    {
      public final boolean onTimerExpired()
      {
        AppMethodBeat.i(148356);
        Log.i("MicroMsg.SceneVoiceService", "onTimerExpired[%s]", new Object[] { i.this.toString() });
        i.h(i.this);
        AppMethodBeat.o(148356);
        return false;
      }
      
      public final String toString()
      {
        AppMethodBeat.i(148357);
        String str = super.toString() + "|scenePusher";
        AppMethodBeat.o(148357);
        return str;
      }
    }, false);
    Log.i("MicroMsg.SceneVoiceService", "SceneVoiceService %s", new Object[] { Util.getStack().toString() });
    com.tencent.mm.kernel.h.aZW().a(127, this);
    com.tencent.mm.kernel.h.aZW().a(128, this);
    AppMethodBeat.o(148358);
  }
  
  public static final i aHg()
  {
    AppMethodBeat.i(236235);
    i locali = a.aHi();
    AppMethodBeat.o(236235);
    return locali;
  }
  
  private void aHh()
  {
    AppMethodBeat.i(148360);
    this.hxG.clear();
    this.hxE.clear();
    this.hxF.clear();
    this.hxI = false;
    this.hxH = false;
    this.running = false;
    Log.i("MicroMsg.SceneVoiceService", "Finish service use time(ms):" + this.hxM.aPY() + "[" + toString() + "]");
    AppMethodBeat.o(148360);
  }
  
  public final void onSceneEnd(final int paramInt1, final int paramInt2, String paramString, final p paramp)
  {
    AppMethodBeat.i(148359);
    String str1 = toString();
    String str2 = Util.nullAs(paramString, "");
    if (paramp != null) {}
    for (paramString = paramp.toString();; paramString = Integer.valueOf(0))
    {
      Log.i("MicroMsg.SceneVoiceService", "[%s]errType:%s errCode:%s errMsg:%s scene:%s", new Object[] { str1, Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), str2, paramString });
      com.tencent.mm.kernel.h.baH().postToWorker(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(148352);
          String str;
          int i;
          if (paramp.getType() == 128)
          {
            i.a(i.this);
            str = ((e)paramp).fileName;
            i = ((e)paramp).retCode;
            r localr = com.tencent.mm.modelvoice.s.QQ(str);
            if ((paramp.getType() == 128) && (localr != null) && (localr.bPl()) && (localr.status != 98))
            {
              com.tencent.mm.modelvoice.s.Qf(str);
              Log.w("MicroMsg.SceneVoiceService", "re-download set error");
            }
            long l2 = 0L;
            long l1 = l2;
            if (str != null)
            {
              l1 = l2;
              if (i.this.hxG.get(str) != null)
              {
                l1 = ((f.a)i.this.hxG.get(str)).aPY();
                i.this.hxG.remove(str);
              }
            }
            Log.i("MicroMsg.SceneVoiceService", "onSceneEnd SceneType:" + paramp.getType() + " errtype:" + paramInt1 + " errCode:" + paramInt2 + " retCode:" + i + " file:" + str + " time:" + l1);
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
            if (paramp.getType() == 127)
            {
              i.b(i.this);
              str = ((f)paramp).fileName;
              i = ((f)paramp).retCode;
              break;
            }
            Log.e("MicroMsg.SceneVoiceService", "onSceneEnd Error SceneType:" + paramp.getType());
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
            Log.i("MicroMsg.SceneVoiceService", "onSceneEnd fin and try next delay 3s [%d, %d] [%b]", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(i), Boolean.valueOf(i.hxL) });
            if ((i.hxL) && (paramInt1 == 4)) {
              com.tencent.mm.kernel.h.baH().postToWorkerDelayed(new Runnable()
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
    com.tencent.mm.kernel.h.baH().postToWorker(new Runnable()
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
        i.this.hxM.lYS = SystemClock.elapsedRealtime();
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
    private static final i hxR;
    
    static
    {
      AppMethodBeat.i(236233);
      hxR = new i();
      AppMethodBeat.o(236233);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.audio.b.i
 * JD-Core Version:    0.7.0.1
 */