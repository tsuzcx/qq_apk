package com.tencent.mm.audio.b;

import android.os.HandlerThread;
import android.os.SystemClock;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.n;
import com.tencent.mm.ak.q;
import com.tencent.mm.compatible.util.f.a;
import com.tencent.mm.modelvoice.e;
import com.tencent.mm.modelvoice.f;
import com.tencent.mm.modelvoice.r;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.ap;
import com.tencent.mm.sdk.platformtools.as;
import com.tencent.mm.sdk.platformtools.au;
import com.tencent.mm.sdk.platformtools.au.a;
import com.tencent.mm.sdk.platformtools.bs;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;

public final class i
  implements com.tencent.mm.ak.g
{
  private static int cXd = 0;
  public static boolean cXe = true;
  Queue<String> cWW;
  Queue<r> cWX;
  Map<String, f.a> cWY;
  private boolean cWZ;
  private boolean cXa;
  public int cXb;
  private long cXc;
  f.a cXf;
  private au cXg;
  private boolean running;
  
  public i()
  {
    AppMethodBeat.i(148358);
    this.cWW = new LinkedList();
    this.cWX = new LinkedList();
    this.cWY = new HashMap();
    this.cWZ = false;
    this.cXa = false;
    this.running = false;
    this.cXb = 0;
    this.cXc = 0L;
    this.cXf = new f.a();
    this.cXg = new au(com.tencent.mm.kernel.g.agU().GrZ.getLooper(), new au.a()
    {
      public final boolean onTimerExpired()
      {
        AppMethodBeat.i(148356);
        ac.i("MicroMsg.SceneVoiceService", "onTimerExpired[%s]", new Object[] { i.this.toString() });
        i.i(i.this);
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
    ac.i("MicroMsg.SceneVoiceService", "SceneVoiceService %s", new Object[] { bs.eWi().toString() });
    com.tencent.mm.kernel.g.agi().a(127, this);
    com.tencent.mm.kernel.g.agi().a(128, this);
    AppMethodBeat.o(148358);
  }
  
  public static final i EF()
  {
    AppMethodBeat.i(210502);
    i locali = i.a.EJ();
    AppMethodBeat.o(210502);
    return locali;
  }
  
  private void Ou()
  {
    AppMethodBeat.i(148360);
    this.cWY.clear();
    this.cWW.clear();
    this.cWX.clear();
    this.cXa = false;
    this.cWZ = false;
    this.running = false;
    ac.i("MicroMsg.SceneVoiceService", "Finish service use time(ms):" + this.cXf.YH() + "[" + toString() + "]");
    AppMethodBeat.o(148360);
  }
  
  public final void onSceneEnd(final int paramInt1, final int paramInt2, String paramString, final n paramn)
  {
    AppMethodBeat.i(148359);
    String str1 = toString();
    String str2 = bs.bG(paramString, "");
    if (paramn != null) {}
    for (paramString = paramn.toString();; paramString = Integer.valueOf(0))
    {
      ac.i("MicroMsg.SceneVoiceService", "[%s]errType:%s errCode:%s errMsg:%s scene:%s", new Object[] { str1, Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), str2, paramString });
      com.tencent.mm.kernel.g.agU().az(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(148352);
          i.aBu();
          String str;
          int i;
          if (paramn.getType() == 128)
          {
            i.b(i.this);
            str = ((e)paramn).fileName;
            i = ((e)paramn).retCode;
            long l2 = 0L;
            long l1 = l2;
            if (str != null)
            {
              l1 = l2;
              if (i.this.cWY.get(str) != null)
              {
                l1 = ((f.a)i.this.cWY.get(str)).YH();
                i.this.cWY.remove(str);
              }
            }
            ac.i("MicroMsg.SceneVoiceService", "onSceneEnd SceneType:" + paramn.getType() + " errtype:" + paramInt1 + " errCode:" + paramInt2 + " retCode:" + i + " file:" + str + " time:" + l1);
            if ((paramInt1 != 3) || (i == 0)) {
              break label412;
            }
            i.c(i.this);
            label219:
            ac.i("MicroMsg.SceneVoiceService", "onSceneEnd  inCnt:" + i.cXd + " stop:" + i.d(i.this) + " running:" + i.e(i.this) + " recving:" + i.g(i.this) + " sending:" + i.f(i.this));
            if (i.d(i.this) <= 0) {
              break label431;
            }
            i.i(i.this);
          }
          for (;;)
          {
            i.aJX();
            AppMethodBeat.o(148352);
            return;
            if (paramn.getType() == 127)
            {
              i.a(i.this);
              str = ((f)paramn).fileName;
              i = ((f)paramn).retCode;
              break;
            }
            ac.e("MicroMsg.SceneVoiceService", "onSceneEnd Error SceneType:" + paramn.getType());
            i.aJX();
            AppMethodBeat.o(148352);
            return;
            label412:
            if (paramInt1 == 0) {
              break label219;
            }
            i.a(i.this, 0);
            break label219;
            label431:
            if ((!i.f(i.this)) && (!i.g(i.this)))
            {
              i.h(i.this);
              ac.i("MicroMsg.SceneVoiceService", "onSceneEnd fin and try next delay 3s [%d, %d] [%b]", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(i), Boolean.valueOf(i.cXe) });
              if ((i.cXe) && (paramInt1 == 4)) {
                com.tencent.mm.kernel.g.agU().m(new Runnable()
                {
                  public final void run()
                  {
                    AppMethodBeat.i(148351);
                    ac.i("MicroMsg.SceneVoiceService", "onSceneEnd fin and try run");
                    i.this.run();
                    AppMethodBeat.o(148351);
                  }
                }, 10000L);
              }
            }
          }
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
    ac.i("MicroMsg.SceneVoiceService", "run() %s", new Object[] { toString() });
    com.tencent.mm.kernel.g.agU().az(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(148354);
        long l = System.currentTimeMillis() - i.j(i.this);
        ac.i("MicroMsg.SceneVoiceService", "Try Run service runningFlag:" + i.e(i.this) + " timeWait:" + l + " sending:" + i.f(i.this) + " recving:" + i.g(i.this) + "[" + i.this.toString() + "]");
        if (i.e(i.this))
        {
          if (l < 60000L)
          {
            AppMethodBeat.o(148354);
            return;
          }
          ac.e("MicroMsg.SceneVoiceService", "ERR: Try Run service runningFlag:" + i.e(i.this) + " timeWait:" + l + ">=MAX_TIME_WAIT sending:" + i.f(i.this) + " recving:" + i.g(i.this));
        }
        i.k(i.this);
        i.a(i.this);
        i.a(i.this, 3);
        i.b(i.this);
        i.this.cXf.fJW = SystemClock.elapsedRealtime();
        i.l(i.this).au(10L, 10L);
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
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.audio.b.i
 * JD-Core Version:    0.7.0.1
 */