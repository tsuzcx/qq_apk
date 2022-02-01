package com.tencent.mm.audio;

import android.content.Context;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.compatible.util.b.a;
import com.tencent.mm.plugin.audio.b.c;
import com.tencent.mm.sdk.platformtools.Log;
import kotlin.g.b.p;
import kotlin.l;
import kotlin.x;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/audio/SceneVoicePlayerAudioManager;", "Lcom/tencent/mm/plugin/audio/mgr/BaseMusicAudioManager;", "context", "Landroid/content/Context;", "onAudioFocusChanged", "Lkotlin/Function1;", "", "Lkotlin/ParameterName;", "name", "status", "", "(Landroid/content/Context;Lkotlin/jvm/functions/Function1;)V", "abandonFocusOnStop", "", "audioFocusListener", "Lcom/tencent/mm/compatible/util/AudioFocusHelper$AudioFocusListener;", "bluetoothResumeSpeaker", "getContext", "()Landroid/content/Context;", "setContext", "(Landroid/content/Context;)V", "hasAudioFocus", "mAudioFocusHelper", "Lcom/tencent/mm/compatible/util/AudioFocusHelper;", "needFocusOnPlay", "player", "Lcom/tencent/mm/modelvoice/IVoicePlayer;", "getPlayer", "()Lcom/tencent/mm/modelvoice/IVoicePlayer;", "setPlayer", "(Lcom/tencent/mm/modelvoice/IVoicePlayer;)V", "value", "speakerOn", "getSpeakerOn", "()Z", "setSpeakerOn", "(Z)V", "onAudioDeviceStateChanged", "onErrorPlaying", "pausePlaying", "abandonFocus", "releaseAudioPlayingDevice", "isContinuousPlay", "requestAudioPlayingDevice", "requestSpeakerOn", "resumePlaying", "startPlay", "filepath", "", "position", "stopPlaying", "unInit", "Companion", "plugin-audiologic_release"})
public final class a
  extends c
{
  public static final a.a dtI;
  public Context context;
  private boolean dtA;
  private boolean dtB;
  public boolean dtC;
  private boolean dtD;
  public boolean dtE;
  public com.tencent.mm.modelvoice.d dtF;
  private final b.a dtG;
  private kotlin.g.a.b<? super Integer, x> dtH;
  public com.tencent.mm.compatible.util.b dtz;
  
  static
  {
    AppMethodBeat.i(187341);
    dtI = new a.a((byte)0);
    AppMethodBeat.o(187341);
  }
  
  public a(Context paramContext, kotlin.g.a.b<? super Integer, x> paramb)
  {
    AppMethodBeat.i(187340);
    this.dtH = paramb;
    this.dtA = true;
    this.dtB = true;
    this.context = paramContext;
    this.dtz = new com.tencent.mm.compatible.util.b(paramContext);
    com.tencent.mm.plugin.audio.d.b.cet();
    com.tencent.mm.plugin.audio.d.d.cet();
    paramContext = com.tencent.mm.plugin.audio.c.a.oIh;
    com.tencent.mm.plugin.audio.c.a.a.a((com.tencent.mm.plugin.audio.b.a)this, "music");
    this.dtG = ((b.a)new b(this));
    AppMethodBeat.o(187340);
  }
  
  public final void Yl()
  {
    AppMethodBeat.i(187333);
    Object localObject = this.dtF;
    if (localObject != null) {
      ((com.tencent.mm.modelvoice.d)localObject).c(this.dtG);
    }
    localObject = this.dtF;
    if (localObject != null) {
      ((com.tencent.mm.modelvoice.d)localObject).bhQ();
    }
    if (this.dtA)
    {
      localObject = this.dtz;
      if (localObject != null) {
        ((com.tencent.mm.compatible.util.b)localObject).a(this.dtG);
      }
      localObject = this.dtz;
      if (localObject != null) {
        ((com.tencent.mm.compatible.util.b)localObject).requestFocus();
      }
      this.dtC = true;
    }
    this.dtB = true;
    localObject = com.tencent.mm.plugin.audio.c.a.oIh;
    if (!com.tencent.mm.plugin.audio.c.a.a.cea().cdW())
    {
      b("music", Integer.valueOf(2));
      AppMethodBeat.o(187333);
      return;
    }
    b("music", Integer.valueOf(1));
    AppMethodBeat.o(187333);
  }
  
  public final boolean Ym()
  {
    AppMethodBeat.i(187337);
    Object localObject = this.dtF;
    if (localObject != null) {}
    for (boolean bool = ((com.tencent.mm.modelvoice.d)localObject).resume();; bool = false)
    {
      if (bool)
      {
        b("music", Integer.valueOf(2));
        localObject = com.tencent.mm.plugin.audio.c.a.oIh;
        localObject = com.tencent.mm.plugin.audio.d.b.oIo;
        if (com.tencent.mm.plugin.audio.d.b.ceb()) {
          cU(false);
        }
        jp(this.dtE);
      }
      if (this.dtC)
      {
        localObject = this.dtz;
        if (localObject != null) {
          ((com.tencent.mm.compatible.util.b)localObject).requestFocus();
        }
        this.dtC = false;
      }
      AppMethodBeat.o(187337);
      return bool;
    }
  }
  
  public final void Yn()
  {
    AppMethodBeat.i(187338);
    cdV();
    if ((this.dtC) && (this.dtB))
    {
      com.tencent.mm.compatible.util.b localb = this.dtz;
      if (localb != null) {
        localb.apm();
      }
      this.dtC = false;
    }
    AppMethodBeat.o(187338);
  }
  
  public final void cU(boolean paramBoolean)
  {
    this.dtE = paramBoolean;
    this.dtD = paramBoolean;
  }
  
  public final void cV(boolean paramBoolean)
  {
    AppMethodBeat.i(187332);
    if (this.dtE == paramBoolean)
    {
      AppMethodBeat.o(187332);
      return;
    }
    if (this.dtF != null)
    {
      com.tencent.mm.modelvoice.d locald = this.dtF;
      if (locald == null) {
        break label78;
      }
      if (locald.isPlaying() == true)
      {
        locald = this.dtF;
        if (locald != null) {
          locald.cU(paramBoolean);
        }
        jp(paramBoolean);
        cU(paramBoolean);
      }
    }
    AppMethodBeat.o(187332);
    return;
    label78:
    AppMethodBeat.o(187332);
  }
  
  public final void cW(boolean paramBoolean)
  {
    AppMethodBeat.i(187334);
    cdV();
    if (!paramBoolean) {
      agq("music");
    }
    if (this.dtC)
    {
      com.tencent.mm.compatible.util.b localb = this.dtz;
      if (localb != null) {
        localb.apm();
      }
      localb = this.dtz;
      if (localb != null) {
        localb.b(this.dtG);
      }
      this.dtz = null;
      this.dtC = false;
    }
    AppMethodBeat.o(187334);
  }
  
  public final boolean cX(boolean paramBoolean)
  {
    AppMethodBeat.i(187336);
    Object localObject = this.dtF;
    if (localObject != null)
    {
      if (((com.tencent.mm.modelvoice.d)localObject).isPlaying() != true) {
        break label94;
      }
      localObject = this.dtF;
      if (localObject == null) {
        break label89;
      }
      paramBoolean = ((com.tencent.mm.modelvoice.d)localObject).da(paramBoolean);
    }
    for (;;)
    {
      localObject = com.tencent.mm.plugin.audio.c.a.oIh;
      com.tencent.mm.plugin.audio.c.a.a.cea().cdV();
      if (this.dtC)
      {
        localObject = this.dtz;
        if (localObject != null) {
          ((com.tencent.mm.compatible.util.b)localObject).apm();
        }
        this.dtC = false;
      }
      AppMethodBeat.o(187336);
      return paramBoolean;
      paramBoolean = false;
      continue;
      label89:
      paramBoolean = false;
      continue;
      label94:
      paramBoolean = false;
    }
  }
  
  public final void iY(int paramInt)
  {
    AppMethodBeat.i(187339);
    super.iY(paramInt);
    switch (paramInt)
    {
    }
    for (;;)
    {
      AppMethodBeat.o(187339);
      return;
      cV(false);
      AppMethodBeat.o(187339);
      return;
      cU(this.dtD);
    }
  }
  
  public final void x(String paramString, int paramInt)
  {
    AppMethodBeat.i(187335);
    p.h(paramString, "filepath");
    com.tencent.mm.modelvoice.d locald = this.dtF;
    if (locald == null) {
      p.hyc();
    }
    if (!locald.c(paramString, this.dtE, paramInt))
    {
      Log.i("MicroMsg.SceneVoiceAudioManager", "start play error fileName[" + paramString + "], [" + this.dtE + ']');
      agq("music");
    }
    AppMethodBeat.o(187335);
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "focusChange", "", "onChange"})
  static final class b
    implements b.a
  {
    b(a parama) {}
    
    public final void iZ(int paramInt)
    {
      AppMethodBeat.i(187331);
      Log.i("MicroMsg.SceneVoiceAudioManager", "on audio focus change: %s", new Object[] { Integer.valueOf(paramInt) });
      a.a(this.dtJ).invoke(Integer.valueOf(paramInt));
      AppMethodBeat.o(187331);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.audio.a
 * JD-Core Version:    0.7.0.1
 */