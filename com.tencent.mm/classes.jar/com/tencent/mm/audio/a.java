package com.tencent.mm.audio;

import android.content.Context;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.compatible.util.b.a;
import com.tencent.mm.plugin.audio.b.c;
import com.tencent.mm.sdk.platformtools.Log;
import kotlin.g.b.p;
import kotlin.l;
import kotlin.x;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/audio/SceneVoicePlayerAudioManager;", "Lcom/tencent/mm/plugin/audio/mgr/BaseMusicAudioManager;", "context", "Landroid/content/Context;", "onAudioFocusChanged", "Lkotlin/Function1;", "", "Lkotlin/ParameterName;", "name", "status", "", "(Landroid/content/Context;Lkotlin/jvm/functions/Function1;)V", "abandonFocusOnStop", "", "audioFocusListener", "Lcom/tencent/mm/compatible/util/AudioFocusHelper$AudioFocusListener;", "bluetoothResumeSpeaker", "getContext", "()Landroid/content/Context;", "setContext", "(Landroid/content/Context;)V", "hasAudioFocus", "mAudioFocusHelper", "Lcom/tencent/mm/compatible/util/AudioFocusHelper;", "needFocusOnPlay", "player", "Lcom/tencent/mm/modelvoice/IVoicePlayer;", "getPlayer", "()Lcom/tencent/mm/modelvoice/IVoicePlayer;", "setPlayer", "(Lcom/tencent/mm/modelvoice/IVoicePlayer;)V", "value", "speakerOn", "getSpeakerOn", "()Z", "setSpeakerOn", "(Z)V", "onAudioDeviceStateChanged", "onErrorPlaying", "pausePlaying", "abandonFocus", "releaseAudioPlayingDevice", "isContinuousPlay", "requestAudioPlayingDevice", "requestSpeakerOn", "resumePlaying", "startPlay", "filepath", "", "position", "stopPlaying", "unInit", "Companion", "plugin-audiologic_release"})
public final class a
  extends c
{
  public static final a.a fmq;
  public Context context;
  public com.tencent.mm.compatible.util.b fmh;
  private boolean fmi;
  private boolean fmj;
  public boolean fmk;
  private boolean fml;
  public boolean fmm;
  public com.tencent.mm.modelvoice.d fmn;
  private final b.a fmo;
  private kotlin.g.a.b<? super Integer, x> fmp;
  
  static
  {
    AppMethodBeat.i(227505);
    fmq = new a.a((byte)0);
    AppMethodBeat.o(227505);
  }
  
  public a(Context paramContext, kotlin.g.a.b<? super Integer, x> paramb)
  {
    AppMethodBeat.i(227503);
    this.fmp = paramb;
    this.fmi = true;
    this.fmj = true;
    this.context = paramContext;
    this.fmh = new com.tencent.mm.compatible.util.b(paramContext);
    com.tencent.mm.plugin.audio.d.b.crG();
    com.tencent.mm.plugin.audio.d.d.crG();
    paramContext = com.tencent.mm.plugin.audio.c.a.rJX;
    com.tencent.mm.plugin.audio.c.a.a.a((com.tencent.mm.plugin.audio.b.a)this, "music");
    this.fmo = ((b.a)new b(this));
    AppMethodBeat.o(227503);
  }
  
  public final void P(String paramString, int paramInt)
  {
    AppMethodBeat.i(227489);
    p.k(paramString, "filepath");
    com.tencent.mm.modelvoice.d locald = this.fmn;
    if (locald == null) {
      p.iCn();
    }
    if (!locald.d(paramString, this.fmm, paramInt))
    {
      Log.i("MicroMsg.SceneVoiceAudioManager", "start play error fileName[" + paramString + "], [" + this.fmm + ']');
      anT("music");
    }
    AppMethodBeat.o(227489);
  }
  
  public final void acR()
  {
    AppMethodBeat.i(227481);
    Object localObject = this.fmn;
    if (localObject != null) {
      ((com.tencent.mm.modelvoice.d)localObject).c(this.fmo);
    }
    localObject = this.fmn;
    if (localObject != null) {
      ((com.tencent.mm.modelvoice.d)localObject).bro();
    }
    if (this.fmi)
    {
      this.fmh = new com.tencent.mm.compatible.util.b(this.context);
      localObject = this.fmh;
      if (localObject != null) {
        ((com.tencent.mm.compatible.util.b)localObject).a(this.fmo);
      }
      localObject = this.fmh;
      if (localObject != null) {
        ((com.tencent.mm.compatible.util.b)localObject).avy();
      }
      this.fmk = true;
    }
    this.fmj = true;
    localObject = com.tencent.mm.plugin.audio.c.a.rJX;
    if (!com.tencent.mm.plugin.audio.c.a.a.crn().crh())
    {
      b("music", Integer.valueOf(2));
      AppMethodBeat.o(227481);
      return;
    }
    b("music", Integer.valueOf(1));
    AppMethodBeat.o(227481);
  }
  
  public final boolean acS()
  {
    AppMethodBeat.i(227495);
    Object localObject = this.fmn;
    if (localObject != null) {}
    for (boolean bool = ((com.tencent.mm.modelvoice.d)localObject).resume();; bool = false)
    {
      if (bool)
      {
        b("music", Integer.valueOf(2));
        localObject = com.tencent.mm.plugin.audio.c.a.rJX;
        localObject = com.tencent.mm.plugin.audio.d.b.rKe;
        if (com.tencent.mm.plugin.audio.d.b.cro()) {
          dr(false);
        }
        kA(this.fmm);
      }
      if (this.fmk)
      {
        localObject = this.fmh;
        if (localObject != null) {
          ((com.tencent.mm.compatible.util.b)localObject).avy();
        }
        this.fmk = true;
      }
      AppMethodBeat.o(227495);
      return bool;
    }
  }
  
  public final void acT()
  {
    AppMethodBeat.i(227497);
    crg();
    if ((this.fmk) && (this.fmj))
    {
      com.tencent.mm.compatible.util.b localb = this.fmh;
      if (localb != null) {
        localb.avz();
      }
      this.fmk = false;
    }
    AppMethodBeat.o(227497);
  }
  
  public final void dr(boolean paramBoolean)
  {
    this.fmm = paramBoolean;
    this.fml = paramBoolean;
  }
  
  public final void ds(boolean paramBoolean)
  {
    AppMethodBeat.i(227476);
    if (this.fmm == paramBoolean)
    {
      AppMethodBeat.o(227476);
      return;
    }
    if (this.fmn != null)
    {
      com.tencent.mm.modelvoice.d locald = this.fmn;
      if (locald == null) {
        break label81;
      }
      if (locald.isPlaying() == true)
      {
        locald = this.fmn;
        if (locald != null) {
          locald.dr(paramBoolean);
        }
        kA(paramBoolean);
        dr(paramBoolean);
      }
    }
    AppMethodBeat.o(227476);
    return;
    label81:
    AppMethodBeat.o(227476);
  }
  
  public final void dt(boolean paramBoolean)
  {
    AppMethodBeat.i(227483);
    crg();
    if (!paramBoolean) {
      anT("music");
    }
    if (this.fmk)
    {
      com.tencent.mm.compatible.util.b localb = this.fmh;
      if (localb != null) {
        localb.avz();
      }
      localb = this.fmh;
      if (localb != null) {
        localb.b(this.fmo);
      }
      this.fmh = null;
      this.fmk = false;
    }
    AppMethodBeat.o(227483);
  }
  
  public final boolean du(boolean paramBoolean)
  {
    AppMethodBeat.i(227493);
    Object localObject = this.fmn;
    if (localObject != null)
    {
      if (((com.tencent.mm.modelvoice.d)localObject).isPlaying() != true) {
        break label96;
      }
      localObject = this.fmn;
      if (localObject == null) {
        break label91;
      }
      paramBoolean = ((com.tencent.mm.modelvoice.d)localObject).dA(paramBoolean);
    }
    for (;;)
    {
      localObject = com.tencent.mm.plugin.audio.c.a.rJX;
      com.tencent.mm.plugin.audio.c.a.a.crn().crg();
      if (this.fmk)
      {
        localObject = this.fmh;
        if (localObject != null) {
          ((com.tencent.mm.compatible.util.b)localObject).avz();
        }
        this.fmk = false;
      }
      AppMethodBeat.o(227493);
      return paramBoolean;
      paramBoolean = false;
      continue;
      label91:
      paramBoolean = false;
      continue;
      label96:
      paramBoolean = false;
    }
  }
  
  public final void ko(int paramInt)
  {
    AppMethodBeat.i(227500);
    super.ko(paramInt);
    switch (paramInt)
    {
    }
    for (;;)
    {
      AppMethodBeat.o(227500);
      return;
      ds(false);
      AppMethodBeat.o(227500);
      return;
      dr(this.fml);
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "focusChange", "", "onChange"})
  static final class b
    implements b.a
  {
    b(a parama) {}
    
    public final void kp(int paramInt)
    {
      AppMethodBeat.i(226396);
      Log.i("MicroMsg.SceneVoiceAudioManager", "on audio focus change: %s", new Object[] { Integer.valueOf(paramInt) });
      a.a(this.fmr).invoke(Integer.valueOf(paramInt));
      AppMethodBeat.o(226396);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.audio.a
 * JD-Core Version:    0.7.0.1
 */