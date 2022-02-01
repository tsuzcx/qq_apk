package com.tencent.mm.audio.a;

import android.app.Activity;
import android.content.Context;
import android.os.HandlerThread;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.am.j;
import com.tencent.mm.am.j.a;
import com.tencent.mm.am.j.b;
import com.tencent.mm.am.j.c;
import com.tencent.mm.am.j.d;
import com.tencent.mm.am.j.e;
import com.tencent.mm.audio.b.g.b;
import com.tencent.mm.compatible.deviceinfo.af;
import com.tencent.mm.modelvoice.d;
import com.tencent.mm.modelvoice.d.a;
import com.tencent.mm.modelvoice.d.b;
import com.tencent.mm.modelvoice.d.c;
import com.tencent.mm.modelvoice.k;
import com.tencent.mm.modelvoice.l;
import com.tencent.mm.modelvoice.q;
import com.tencent.mm.modelvoice.s;
import com.tencent.mm.modelvoice.u;
import com.tencent.mm.plugin.audio.c.a.a;
import com.tencent.mm.plugin.e.a.f;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.MMHandler;
import com.tencent.mm.sdk.platformtools.MMHandlerThread;
import com.tencent.mm.sdk.platformtools.PlaySound;
import com.tencent.mm.sdk.platformtools.PlaySound.OnPlayCompletionListener;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.sdk.thread.ThreadPool;
import com.tencent.mm.vfs.y;
import java.util.ArrayList;
import java.util.List;
import junit.framework.Assert;

public final class a
  implements j
{
  private static String hvf = null;
  private Context context;
  private d hqC;
  private boolean hqx;
  private boolean hqy;
  private boolean hqz;
  private boolean huY;
  private boolean huZ;
  private int hva;
  private boolean hvb;
  private j.c hvc;
  private j.e hvd;
  private String hve;
  private List<j.d> hvg;
  private com.tencent.mm.audio.a hvh;
  private HandlerThread hvi;
  private MMHandler hvj;
  public j.b hvk;
  public j.a hvl;
  
  public a(Context paramContext)
  {
    this(paramContext, 0);
  }
  
  public a(Context paramContext, int paramInt)
  {
    AppMethodBeat.i(148290);
    this.hqC = null;
    this.context = null;
    this.huY = false;
    this.huZ = false;
    this.hva = 0;
    this.hvb = true;
    this.hve = null;
    this.hqx = true;
    this.hqy = true;
    this.hqz = false;
    this.hvg = new ArrayList();
    this.hvi = null;
    this.hvj = null;
    this.hvk = null;
    if ((paramContext instanceof Activity)) {}
    for (Context localContext = MMApplicationContext.getContext();; localContext = paramContext)
    {
      this.context = localContext;
      this.hva = paramInt;
      this.hvh = new com.tencent.mm.audio.a(paramContext, new a.1(this));
      new g.b();
      AppMethodBeat.o(148290);
      return;
    }
  }
  
  private void aGE()
  {
    AppMethodBeat.i(148301);
    d.b local3 = new d.b()
    {
      public final void atR()
      {
        AppMethodBeat.i(148285);
        com.tencent.mm.audio.a locala = a.c(a.this);
        locala.cTP();
        if (locala.hqz)
        {
          com.tencent.mm.compatible.util.b localb = locala.hqw;
          if (localb != null) {
            localb.aPS();
          }
          locala.hqz = false;
        }
        Log.i("MicroMsg.SceneVoicePlayer", "setError abandon focus, needFocusOnPlay: %s, hasAudioFocus: %s", new Object[] { Boolean.valueOf(a.d(a.this)), Boolean.valueOf(a.e(a.this)) });
        if (a.f(a.this) != null) {
          MMHandlerThread.postToMainThread(new Runnable()
          {
            public final void run()
            {
              AppMethodBeat.i(148284);
              a.f(a.this).atR();
              AppMethodBeat.o(148284);
            }
          });
        }
        AppMethodBeat.o(148285);
      }
    };
    if (this.hqC != null) {
      this.hqC.a(local3);
    }
    AppMethodBeat.o(148301);
  }
  
  private void aGF()
  {
    AppMethodBeat.i(148302);
    d.a local4 = new d.a()
    {
      public final void onCompletion()
      {
        AppMethodBeat.i(148289);
        ThreadPool.post(new Runnable()
        {
          public final void run()
          {
            AppMethodBeat.i(148288);
            try
            {
              if (af.lXZ.lRb == 1) {
                Thread.sleep(300L);
              }
              Log.i("MicroMsg.SceneVoicePlayer", "onCompletion, intOnCompletion: %s, shouldPlayComplete: %s", new Object[] { a.g(a.this), Boolean.valueOf(a.h(a.this)) });
              MMHandlerThread.postToMainThread(new Runnable()
              {
                public final void run()
                {
                  AppMethodBeat.i(148287);
                  a.c(a.this).ee(a.c(a.this).hqB);
                  if (a.h(a.this)) {
                    PlaySound.play(a.i(a.this), a.f.play_completed, a.c(a.this).hqB, false, new PlaySound.OnPlayCompletionListener()
                    {
                      public final void onCompletion()
                      {
                        AppMethodBeat.i(148286);
                        Log.i("MicroMsg.SceneVoicePlayer", "play sound end onCompletion");
                        if (!a.this.isPlaying())
                        {
                          Log.i("MicroMsg.SceneVoicePlayer", "onCompletion() continuousPlay:%s", new Object[] { Boolean.valueOf(a.j(a.this)) });
                          a.c(a.this).ef(a.j(a.this));
                          a.k(a.this);
                          Log.i("MicroMsg.SceneVoicePlayer", "onCompletion() abandon focus, needFocusOnPlay: %s, hasAudioFocus: %s", new Object[] { Boolean.valueOf(a.d(a.this)), Boolean.valueOf(a.e(a.this)) });
                          Log.i("MicroMsg.SceneVoicePlayer", "onCompletion() resetSpeaker");
                        }
                        AppMethodBeat.o(148286);
                      }
                    });
                  }
                  for (;;)
                  {
                    MMHandlerThread.postToMainThread(new Runnable()
                    {
                      public final void run()
                      {
                        AppMethodBeat.i(236236);
                        if (a.g(a.this) != null)
                        {
                          Log.i("MicroMsg.SceneVoicePlayer", "intOnCompletion onCompletion()");
                          a.g(a.this).onCompletion();
                          AppMethodBeat.o(236236);
                          return;
                        }
                        Log.e("MicroMsg.SceneVoicePlayer", "intOnCompletion is null!!!");
                        AppMethodBeat.o(236236);
                      }
                    });
                    AppMethodBeat.o(148287);
                    return;
                    Log.i("MicroMsg.SceneVoicePlayer", "play sound end onCompletion");
                    if (!a.this.isPlaying())
                    {
                      Log.i("MicroMsg.SceneVoicePlayer", "onCompletion() abandon focus, needFocusOnPlay: %s, hasAudioFocus: %s", new Object[] { Boolean.valueOf(a.d(a.this)), Boolean.valueOf(a.e(a.this)) });
                      Log.i("MicroMsg.SceneVoicePlayer", "onCompletion() continuousPlay:%s", new Object[] { Boolean.valueOf(a.j(a.this)) });
                      a.c(a.this).ef(a.j(a.this));
                      a.k(a.this);
                      Log.i("MicroMsg.SceneVoicePlayer", "onCompletion() resetSpeaker");
                    }
                  }
                }
              });
              AppMethodBeat.o(148288);
              return;
            }
            catch (Exception localException)
            {
              Log.e("MicroMsg.SceneVoicePlayer", "exception:%s", new Object[] { Util.stackTraceToString(localException) });
              AppMethodBeat.o(148288);
            }
          }
        }, "SceneVoice_onCompletion");
        AppMethodBeat.o(148289);
      }
    };
    if (this.hqC != null) {
      this.hqC.a(local4);
    }
    AppMethodBeat.o(148302);
  }
  
  public final void a(j.a parama)
  {
    this.hvl = parama;
  }
  
  public final void a(j.b paramb)
  {
    this.hvk = paramb;
  }
  
  public final void a(j.c paramc)
  {
    this.hvc = paramc;
  }
  
  public final void a(j.d paramd)
  {
    AppMethodBeat.i(236260);
    this.hvg.add(paramd);
    AppMethodBeat.o(236260);
  }
  
  public final void a(j.e parame)
  {
    this.hvd = parame;
  }
  
  public final boolean a(String paramString, boolean paramBoolean, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(148293);
    Log.i("MicroMsg.SceneVoicePlayer", "start file name:[%s] speakerOn:[%b], isFullPath: %s, type: %s, userType: %s", new Object[] { paramString, Boolean.valueOf(paramBoolean), Boolean.TRUE, Integer.valueOf(paramInt1), Integer.valueOf(this.hva) });
    if (paramString.length() > 0) {}
    for (boolean bool = true;; bool = false)
    {
      Assert.assertTrue(bool);
      if (y.ZC(paramString)) {
        break;
      }
      Log.e("MicroMsg.SceneVoicePlayer", "start, file %s not exist!, fullPath: %s", new Object[] { paramString, paramString });
      AppMethodBeat.o(148293);
      return false;
    }
    int i = paramInt1;
    if (paramInt1 == -1) {
      i = q.l(paramString, this.hva, true);
    }
    if (i == 0) {
      if (this.context != null)
      {
        this.hqC = new u(this.context);
        if (this.hqC == null) {
          break label370;
        }
        Log.i("MicroMsg.SceneVoicePlayer", "init player success %s", new Object[] { Integer.valueOf(hashCode()) });
        this.hvh.hqC = this.hqC;
      }
    }
    for (;;)
    {
      this.hvh.aER();
      this.hvh.ed(paramBoolean);
      this.hvh.lN(this.hvh.hqB);
      aGF();
      aGE();
      this.hvh.Y(paramString, paramInt2);
      Log.i("MicroMsg.SceneVoicePlayer", "jacks Player requestFocus focus helper, needFocusOnPlay: %s", new Object[] { Boolean.valueOf(this.hqx) });
      AppMethodBeat.o(148293);
      return true;
      this.hqC = new u();
      break;
      if (i == 1)
      {
        if (this.context != null)
        {
          this.hqC = new l(this.context);
          break;
        }
        this.hqC = new l();
        break;
      }
      if (i != 2) {
        break;
      }
      if (this.context != null)
      {
        this.hqC = new k(this.context);
        break;
      }
      this.hqC = new k();
      break;
      label370:
      Log.e("MicroMsg.SceneVoicePlayer", "init player failed %s", new Object[] { Integer.valueOf(hashCode()) });
    }
  }
  
  public final boolean a(String paramString, boolean paramBoolean1, boolean paramBoolean2, int paramInt)
  {
    AppMethodBeat.i(148292);
    Log.i("MicroMsg.SceneVoicePlayer", "start file name:[%s] speakerOn:[%b], isFullPath: %s, type: %s, userType: %s", new Object[] { paramString, Boolean.valueOf(paramBoolean1), Boolean.valueOf(paramBoolean2), Integer.valueOf(paramInt), Integer.valueOf(this.hva) });
    boolean bool;
    if (paramString.length() > 0)
    {
      bool = true;
      Assert.assertTrue(bool);
      hvf = this.hve;
      this.hve = paramString;
      if (!paramBoolean2) {
        break label136;
      }
      str = paramString;
      label87:
      if (y.ZC(str)) {
        break label154;
      }
      if (!paramBoolean2) {
        break label145;
      }
    }
    label136:
    label145:
    for (String str = paramString;; str = s.getFullPath(paramString))
    {
      Log.e("MicroMsg.SceneVoicePlayer", "start, file %s not exist!, fullPath: %s", new Object[] { paramString, str });
      AppMethodBeat.o(148292);
      return false;
      bool = false;
      break;
      str = s.getFullPath(paramString);
      break label87;
    }
    label154:
    int i = paramInt;
    if (paramInt == -1) {
      i = q.l(paramString, this.hva, paramBoolean2);
    }
    if (i == 0) {
      if (this.context != null)
      {
        this.hqC = new u(this.context);
        if (this.hqC == null) {
          break label493;
        }
        Log.i("MicroMsg.SceneVoicePlayer", "init player success %s", new Object[] { Integer.valueOf(hashCode()) });
        this.hvh.hqC = this.hqC;
        label241:
        this.hvh.aER();
        this.hvh.ed(paramBoolean1);
        if ((com.tencent.mm.plugin.audio.c.a.cTQ()) || (com.tencent.mm.plugin.audio.c.a.cTX()))
        {
          Log.i("MicroMsg.SceneVoicePlayer", "headset plugged: %b, bluetoothon: %b", new Object[] { Boolean.valueOf(com.tencent.mm.plugin.audio.c.a.cTQ()), Boolean.valueOf(com.tencent.mm.plugin.audio.c.a.cTX()) });
          this.hvh.ed(false);
        }
        this.hvh.lN(this.hvh.hqB);
        aGF();
        aGE();
        if (!paramBoolean2) {
          break label518;
        }
      }
    }
    for (;;)
    {
      this.hvh.Y(paramString, 0);
      Log.i("MicroMsg.SceneVoicePlayer", "jacks Player requestFocus focus helper, needFocusOnPlay: %s", new Object[] { Boolean.valueOf(this.hqx) });
      AppMethodBeat.o(148292);
      return true;
      this.hqC = new u();
      break;
      if (i == 1)
      {
        if (this.context != null)
        {
          this.hqC = new l(this.context);
          break;
        }
        this.hqC = new l();
        break;
      }
      if (i != 2) {
        break;
      }
      if (this.context != null) {}
      for (this.hqC = new k(this.context);; this.hqC = new k())
      {
        this.hqC.a(new d.c()
        {
          public final void eb(long paramAnonymousLong)
          {
            AppMethodBeat.i(236239);
            int i = 0;
            while (i < a.b(a.this).size())
            {
              ((j.d)a.b(a.this).get(i)).eb(paramAnonymousLong);
              i += 1;
            }
            AppMethodBeat.o(236239);
          }
        });
        break;
      }
      label493:
      Log.e("MicroMsg.SceneVoicePlayer", "init player failed %s", new Object[] { Integer.valueOf(hashCode()) });
      break label241;
      label518:
      if (this.hva == 0) {
        paramString = s.getFullPath(paramString);
      } else {
        paramString = null;
      }
    }
  }
  
  public final boolean aFF()
  {
    AppMethodBeat.i(148305);
    if (this.hqC == null)
    {
      AppMethodBeat.o(148305);
      return false;
    }
    if (this.hqC.getStatus() == 2)
    {
      AppMethodBeat.o(148305);
      return true;
    }
    AppMethodBeat.o(148305);
    return false;
  }
  
  public final double aGG()
  {
    AppMethodBeat.i(148303);
    if (this.hqC == null)
    {
      AppMethodBeat.o(148303);
      return 0.0D;
    }
    double d = this.hqC.aGG();
    AppMethodBeat.o(148303);
    return d;
  }
  
  public final void b(j.d paramd)
  {
    AppMethodBeat.i(236263);
    this.hvg.remove(paramd);
    AppMethodBeat.o(236263);
  }
  
  public final boolean ea(long paramLong)
  {
    AppMethodBeat.i(236255);
    if (this.hqC != null)
    {
      boolean bool = this.hqC.ea(paramLong);
      AppMethodBeat.o(236255);
      return bool;
    }
    AppMethodBeat.o(236255);
    return false;
  }
  
  public final void ed(boolean paramBoolean)
  {
    AppMethodBeat.i(148300);
    this.hvh.ee(paramBoolean);
    AppMethodBeat.o(148300);
  }
  
  public final void ek(boolean paramBoolean)
  {
    this.hqx = paramBoolean;
  }
  
  public final void el(boolean paramBoolean)
  {
    this.hqy = paramBoolean;
  }
  
  public final boolean em(boolean paramBoolean)
  {
    AppMethodBeat.i(148295);
    if (this.hqC == null)
    {
      AppMethodBeat.o(148295);
      return false;
    }
    Log.i("MicroMsg.SceneVoicePlayer", "pause");
    boolean bool = this.hvh.eg(paramBoolean);
    if ((bool) && (this.hvc != null)) {
      this.hvc.gY(paramBoolean);
    }
    Log.i("MicroMsg.SceneVoicePlayer", "jacks Player abandonFocus focus helper, needFocusOnPlay: %s, hasAudioFocus: %s", new Object[] { Boolean.valueOf(this.hqx), Boolean.valueOf(this.hqz) });
    AppMethodBeat.o(148295);
    return bool;
  }
  
  public final void en(boolean paramBoolean)
  {
    AppMethodBeat.i(148304);
    Log.i("MicroMsg.SceneVoicePlayer", "setContinuousPlay() continuousPlay:%s", new Object[] { Boolean.valueOf(paramBoolean) });
    this.huZ = paramBoolean;
    AppMethodBeat.o(148304);
  }
  
  public final boolean isCalling()
  {
    return this.huY;
  }
  
  public final boolean isPlaying()
  {
    AppMethodBeat.i(148291);
    if (this.hqC == null)
    {
      AppMethodBeat.o(148291);
      return false;
    }
    boolean bool = this.hqC.isPlaying();
    AppMethodBeat.o(148291);
    return bool;
  }
  
  public final boolean pause()
  {
    AppMethodBeat.i(369562);
    boolean bool = em(true);
    AppMethodBeat.o(369562);
    return bool;
  }
  
  public final boolean q(String paramString, boolean paramBoolean)
  {
    AppMethodBeat.i(148297);
    paramBoolean = a(paramString, paramBoolean, false, -1);
    AppMethodBeat.o(148297);
    return paramBoolean;
  }
  
  public final boolean resume()
  {
    AppMethodBeat.i(148296);
    if (this.hqC == null)
    {
      AppMethodBeat.o(148296);
      return false;
    }
    Log.i("MicroMsg.SceneVoicePlayer", "resume");
    boolean bool = this.hvh.aES();
    Log.i("MicroMsg.SceneVoicePlayer", "jacks Player requestFocus focus helper, needFocusOnPlay: %s, hasAudioFocus: %s", new Object[] { Boolean.valueOf(this.hqx), Boolean.valueOf(this.hqz) });
    AppMethodBeat.o(148296);
    return bool;
  }
  
  public final void stop()
  {
    AppMethodBeat.i(369563);
    stop(false);
    AppMethodBeat.o(369563);
  }
  
  public final void stop(boolean paramBoolean)
  {
    AppMethodBeat.i(148299);
    if (this.hqC == null)
    {
      Log.e("MicroMsg.SceneVoicePlayer", "stop player failed cause player is null %s", new Object[] { Integer.valueOf(hashCode()) });
      AppMethodBeat.o(148299);
      return;
    }
    this.hqC.stop();
    this.hqC.a(null);
    this.hqC.a(null);
    Log.i("MicroMsg.SceneVoicePlayer", "stop player abandon focus, needFocusOnPlay: %s, hasAudioFocus: %s, abandonFocusOnStop: %s", new Object[] { Boolean.valueOf(this.hqx), Boolean.valueOf(this.hqz), Boolean.valueOf(this.hqy) });
    this.hvh.aET();
    if ((!paramBoolean) && (this.hvd != null)) {
      this.hvd.onStop();
    }
    AppMethodBeat.o(148299);
  }
  
  public final void unInit()
  {
    AppMethodBeat.i(236244);
    this.hvh.context = null;
    a.a locala = com.tencent.mm.plugin.audio.c.a.uVi;
    a.a.ahu("music");
    AppMethodBeat.o(236244);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes11.jar
 * Qualified Name:     com.tencent.mm.audio.a.a
 * JD-Core Version:    0.7.0.1
 */