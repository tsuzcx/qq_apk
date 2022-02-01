package com.tencent.mm.audio.b;

import android.os.HandlerThread;
import android.os.SystemClock;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.al.n;
import com.tencent.mm.al.q;
import com.tencent.mm.compatible.util.f.a;
import com.tencent.mm.modelvoice.e;
import com.tencent.mm.modelvoice.f;
import com.tencent.mm.modelvoice.r;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.aq;
import com.tencent.mm.sdk.platformtools.av;
import com.tencent.mm.sdk.platformtools.av.a;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;

public final class i
  implements com.tencent.mm.al.g
{
  private static int cZH = 0;
  public static boolean cZI = true;
  Queue<String> cZA;
  Queue<r> cZB;
  Map<String, f.a> cZC;
  private boolean cZD;
  private boolean cZE;
  public int cZF;
  private long cZG;
  f.a cZJ;
  private av cZK;
  private boolean running;
  
  public i()
  {
    AppMethodBeat.i(148358);
    this.cZA = new LinkedList();
    this.cZB = new LinkedList();
    this.cZC = new HashMap();
    this.cZD = false;
    this.cZE = false;
    this.running = false;
    this.cZF = 0;
    this.cZG = 0L;
    this.cZJ = new f.a();
    this.cZK = new av(com.tencent.mm.kernel.g.afE().EUN.getLooper(), new av.a()
    {
      public final boolean onTimerExpired()
      {
        AppMethodBeat.i(148356);
        ad.d("MicroMsg.SceneVoiceService", "onTimerExpired");
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
    com.tencent.mm.kernel.g.aeS().a(127, this);
    com.tencent.mm.kernel.g.aeS().a(128, this);
    AppMethodBeat.o(148358);
  }
  
  private void Oy()
  {
    AppMethodBeat.i(148360);
    this.cZC.clear();
    this.cZA.clear();
    this.cZB.clear();
    this.cZE = false;
    this.cZD = false;
    this.running = false;
    ad.i("MicroMsg.SceneVoiceService", "Finish service use time(ms):" + this.cZJ.XK());
    AppMethodBeat.o(148360);
  }
  
  public final void onSceneEnd(final int paramInt1, final int paramInt2, String paramString, final n paramn)
  {
    AppMethodBeat.i(148359);
    com.tencent.mm.kernel.g.afE().ax(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(148352);
        i.access$008();
        String str;
        int i;
        if (paramn.getType() == 128)
        {
          i.a(i.this);
          str = ((e)paramn).fileName;
          i = ((e)paramn).retCode;
          long l2 = 0L;
          long l1 = l2;
          if (str != null)
          {
            l1 = l2;
            if (i.this.cZC.get(str) != null)
            {
              l1 = ((f.a)i.this.cZC.get(str)).XK();
              i.this.cZC.remove(str);
            }
          }
          ad.i("MicroMsg.SceneVoiceService", "onSceneEnd SceneType:" + paramn.getType() + " errtype:" + paramInt1 + " errCode:" + paramInt2 + " retCode:" + i + " file:" + str + " time:" + l1);
          if ((paramInt1 != 3) || (i == 0)) {
            break label412;
          }
          i.c(i.this);
          label219:
          ad.i("MicroMsg.SceneVoiceService", "onSceneEnd  inCnt:" + i.cZH + " stop:" + i.d(i.this) + " running:" + i.e(i.this) + " recving:" + i.f(i.this) + " sending:" + i.g(i.this));
          if (i.d(i.this) <= 0) {
            break label431;
          }
          i.h(i.this);
        }
        for (;;)
        {
          i.Oz();
          AppMethodBeat.o(148352);
          return;
          if (paramn.getType() == 127)
          {
            i.b(i.this);
            str = ((f)paramn).fileName;
            i = ((f)paramn).retCode;
            break;
          }
          ad.e("MicroMsg.SceneVoiceService", "onSceneEnd Error SceneType:" + paramn.getType());
          i.Oz();
          AppMethodBeat.o(148352);
          return;
          label412:
          if (paramInt1 == 0) {
            break label219;
          }
          i.a(i.this, 0);
          break label219;
          label431:
          if ((!i.g(i.this)) && (!i.f(i.this)))
          {
            i.i(i.this);
            ad.i("MicroMsg.SceneVoiceService", "onSceneEnd fin and try next delay 3s [%d, %d] [%b]", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(i), Boolean.valueOf(i.cZI) });
            if ((i.cZI) && (paramInt1 == 4)) {
              com.tencent.mm.kernel.g.afE().m(new Runnable()
              {
                public final void run()
                {
                  AppMethodBeat.i(148351);
                  ad.i("MicroMsg.SceneVoiceService", "onSceneEnd fin and try run");
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
  }
  
  public final void run()
  {
    AppMethodBeat.i(148361);
    com.tencent.mm.kernel.g.afE().ax(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(148354);
        long l = System.currentTimeMillis() - i.j(i.this);
        ad.i("MicroMsg.SceneVoiceService", "Try Run service runningFlag:" + i.e(i.this) + " timeWait:" + l + " sending:" + i.g(i.this) + " recving:" + i.f(i.this));
        if (i.e(i.this))
        {
          if (l < 60000L)
          {
            AppMethodBeat.o(148354);
            return;
          }
          ad.e("MicroMsg.SceneVoiceService", "ERR: Try Run service runningFlag:" + i.e(i.this) + " timeWait:" + l + ">=MAX_TIME_WAIT sending:" + i.g(i.this) + " recving:" + i.f(i.this));
        }
        i.k(i.this);
        i.b(i.this);
        i.a(i.this, 3);
        i.a(i.this);
        i.this.cZJ.fGp = SystemClock.elapsedRealtime();
        i.l(i.this).av(10L, 10L);
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.audio.b.i
 * JD-Core Version:    0.7.0.1
 */