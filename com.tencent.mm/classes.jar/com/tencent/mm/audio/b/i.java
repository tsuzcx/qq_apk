package com.tencent.mm.audio.b;

import android.os.HandlerThread;
import android.os.SystemClock;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.al.n;
import com.tencent.mm.al.q;
import com.tencent.mm.compatible.util.f.a;
import com.tencent.mm.kernel.g;
import com.tencent.mm.modelvoice.e;
import com.tencent.mm.modelvoice.r;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.aq;
import com.tencent.mm.sdk.platformtools.at;
import com.tencent.mm.sdk.platformtools.av;
import com.tencent.mm.sdk.platformtools.av.a;
import com.tencent.mm.sdk.platformtools.bt;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;

public final class i
  implements com.tencent.mm.al.f
{
  private static int diu = 0;
  public static boolean div = true;
  Queue<String> dim;
  Queue<r> din;
  Map<String, f.a> dio;
  private boolean dip;
  private boolean diq;
  public int dis;
  private long dit;
  f.a diw;
  private av dix;
  private boolean running;
  
  public i()
  {
    AppMethodBeat.i(148358);
    this.dim = new LinkedList();
    this.din = new LinkedList();
    this.dio = new HashMap();
    this.dip = false;
    this.diq = false;
    this.running = false;
    this.dis = 0;
    this.dit = 0L;
    this.diw = new f.a();
    this.dix = new av(g.ajF().IdO.getLooper(), new av.a()
    {
      public final boolean onTimerExpired()
      {
        AppMethodBeat.i(148356);
        ad.i("MicroMsg.SceneVoiceService", "onTimerExpired[%s]", new Object[] { i.this.toString() });
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
    ad.i("MicroMsg.SceneVoiceService", "SceneVoiceService %s", new Object[] { bt.flS().toString() });
    g.aiU().a(127, this);
    g.aiU().a(128, this);
    AppMethodBeat.o(148358);
  }
  
  public static final i Qd()
  {
    AppMethodBeat.i(205869);
    i locali = a.Qh();
    AppMethodBeat.o(205869);
    return locali;
  }
  
  private void Qe()
  {
    AppMethodBeat.i(148360);
    this.dio.clear();
    this.dim.clear();
    this.din.clear();
    this.diq = false;
    this.dip = false;
    this.running = false;
    ad.i("MicroMsg.SceneVoiceService", "Finish service use time(ms):" + this.diw.abj() + "[" + toString() + "]");
    AppMethodBeat.o(148360);
  }
  
  public final void onSceneEnd(final int paramInt1, final int paramInt2, String paramString, final n paramn)
  {
    AppMethodBeat.i(148359);
    String str1 = toString();
    String str2 = bt.bI(paramString, "");
    if (paramn != null) {}
    for (paramString = paramn.toString();; paramString = Integer.valueOf(0))
    {
      ad.i("MicroMsg.SceneVoiceService", "[%s]errType:%s errCode:%s errMsg:%s scene:%s", new Object[] { str1, Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), str2, paramString });
      g.ajF().ay(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(148352);
          i.Qf();
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
              if (i.this.dio.get(str) != null)
              {
                l1 = ((f.a)i.this.dio.get(str)).abj();
                i.this.dio.remove(str);
              }
            }
            ad.i("MicroMsg.SceneVoiceService", "onSceneEnd SceneType:" + paramn.getType() + " errtype:" + paramInt1 + " errCode:" + paramInt2 + " retCode:" + i + " file:" + str + " time:" + l1);
            if ((paramInt1 != 3) || (i == 0)) {
              break label412;
            }
            i.c(i.this);
            label219:
            ad.i("MicroMsg.SceneVoiceService", "onSceneEnd  inCnt:" + i.diu + " stop:" + i.d(i.this) + " running:" + i.e(i.this) + " recving:" + i.f(i.this) + " sending:" + i.g(i.this));
            if (i.d(i.this) <= 0) {
              break label431;
            }
            i.h(i.this);
          }
          for (;;)
          {
            i.Qg();
            AppMethodBeat.o(148352);
            return;
            if (paramn.getType() == 127)
            {
              i.b(i.this);
              str = ((com.tencent.mm.modelvoice.f)paramn).fileName;
              i = ((com.tencent.mm.modelvoice.f)paramn).retCode;
              break;
            }
            ad.e("MicroMsg.SceneVoiceService", "onSceneEnd Error SceneType:" + paramn.getType());
            i.Qg();
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
              ad.i("MicroMsg.SceneVoiceService", "onSceneEnd fin and try next delay 3s [%d, %d] [%b]", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(i), Boolean.valueOf(i.div) });
              if ((i.div) && (paramInt1 == 4)) {
                g.ajF().n(new Runnable()
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
      return;
    }
  }
  
  public final void run()
  {
    AppMethodBeat.i(148361);
    ad.i("MicroMsg.SceneVoiceService", "run() %s", new Object[] { toString() });
    g.ajF().ay(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(148354);
        long l = System.currentTimeMillis() - i.j(i.this);
        ad.i("MicroMsg.SceneVoiceService", "Try Run service runningFlag:" + i.e(i.this) + " timeWait:" + l + " sending:" + i.g(i.this) + " recving:" + i.f(i.this) + "[" + i.this.toString() + "]");
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
        i.this.diw.gdx = SystemClock.elapsedRealtime();
        i.l(i.this).az(10L, 10L);
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
    private static final i diB;
    
    static
    {
      AppMethodBeat.i(205868);
      diB = new i();
      AppMethodBeat.o(205868);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.audio.b.i
 * JD-Core Version:    0.7.0.1
 */