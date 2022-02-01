package com.tencent.mm.audio;

import android.content.Context;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.compatible.util.b.a;
import com.tencent.mm.modelvoice.d;
import com.tencent.mm.sdk.platformtools.ad;
import d.g.b.k;
import d.l;
import d.y;

@l(fvt={1, 1, 16}, fvu={""}, fvv={"Lcom/tencent/mm/audio/SceneVoicePlayerAudioManager;", "Lcom/tencent/mm/plugin/audio/mgr/BaseMusicAudioManager;", "context", "Landroid/content/Context;", "onAudioFocusChanged", "Lkotlin/Function1;", "", "Lkotlin/ParameterName;", "name", "status", "", "(Landroid/content/Context;Lkotlin/jvm/functions/Function1;)V", "abandonFocusOnStop", "", "audioFocusListener", "Lcom/tencent/mm/compatible/util/AudioFocusHelper$AudioFocusListener;", "bluetoothResumeSpeaker", "getContext", "()Landroid/content/Context;", "setContext", "(Landroid/content/Context;)V", "hasAudioFocus", "mAudioFocusHelper", "Lcom/tencent/mm/compatible/util/AudioFocusHelper;", "needFocusOnPlay", "player", "Lcom/tencent/mm/modelvoice/IVoicePlayer;", "getPlayer", "()Lcom/tencent/mm/modelvoice/IVoicePlayer;", "setPlayer", "(Lcom/tencent/mm/modelvoice/IVoicePlayer;)V", "value", "speakerOn", "getSpeakerOn", "()Z", "setSpeakerOn", "(Z)V", "onAudioDeviceStateChanged", "onErrorPlaying", "pausePlaying", "abandonFocus", "releaseAudioPlayingDevice", "isContinuousPlay", "requestAudioPlayingDevice", "requestSpeakerOn", "resumePlaying", "startPlay", "filepath", "", "position", "stopPlaying", "unInit", "Companion", "plugin-audiologic_release"})
public final class a
  extends com.tencent.mm.plugin.audio.b.c
{
  public static final a.a cTc;
  public com.tencent.mm.compatible.util.b cST;
  private boolean cSU;
  private boolean cSV;
  public boolean cSW;
  private boolean cSX;
  public boolean cSY;
  public d cSZ;
  private final b.a cTa;
  private d.g.a.b<? super Integer, y> cTb;
  public Context context;
  
  static
  {
    AppMethodBeat.i(189928);
    cTc = new a.a((byte)0);
    AppMethodBeat.o(189928);
  }
  
  public a(Context paramContext, d.g.a.b<? super Integer, y> paramb)
  {
    AppMethodBeat.i(189927);
    this.cTb = paramb;
    this.cSU = true;
    this.cSV = true;
    this.context = paramContext;
    this.cST = new com.tencent.mm.compatible.util.b(paramContext);
    com.tencent.mm.plugin.audio.d.a.bvI();
    com.tencent.mm.plugin.audio.d.c.bvI();
    paramContext = com.tencent.mm.plugin.audio.c.a.mpv;
    com.tencent.mm.plugin.audio.c.a.a.a((com.tencent.mm.plugin.audio.b.a)this, "music");
    this.cTa = ((b.a)new b(this));
    AppMethodBeat.o(189927);
  }
  
  public final void Mu()
  {
    AppMethodBeat.i(189920);
    Object localObject = this.cSZ;
    if (localObject != null) {
      ((d)localObject).b(this.cTa);
    }
    localObject = this.cSZ;
    if (localObject != null) {
      ((d)localObject).aDn();
    }
    if (this.cSU)
    {
      localObject = this.cST;
      if (localObject != null) {
        ((com.tencent.mm.compatible.util.b)localObject).requestFocus();
      }
      this.cSW = true;
    }
    this.cSV = true;
    localObject = com.tencent.mm.plugin.audio.c.a.mpv;
    if (!com.tencent.mm.plugin.audio.c.a.a.bvB().bvw())
    {
      b("music", Integer.valueOf(2));
      AppMethodBeat.o(189920);
      return;
    }
    b("music", Integer.valueOf(1));
    AppMethodBeat.o(189920);
  }
  
  public final boolean Mv()
  {
    AppMethodBeat.i(189924);
    Object localObject = this.cSZ;
    if (localObject != null) {}
    for (boolean bool = ((d)localObject).resume();; bool = false)
    {
      if (bool)
      {
        b("music", Integer.valueOf(2));
        localObject = com.tencent.mm.plugin.audio.c.a.mpv;
        localObject = com.tencent.mm.plugin.audio.d.a.mpy;
        if (com.tencent.mm.plugin.audio.d.a.bvC()) {
          cj(false);
        }
        hJ(this.cSY);
      }
      if (this.cSW)
      {
        localObject = this.cST;
        if (localObject != null) {
          ((com.tencent.mm.compatible.util.b)localObject).requestFocus();
        }
        this.cSW = false;
      }
      AppMethodBeat.o(189924);
      return bool;
    }
  }
  
  public final void Mw()
  {
    AppMethodBeat.i(189925);
    bvv();
    if ((this.cSW) && (this.cSV))
    {
      com.tencent.mm.compatible.util.b localb = this.cST;
      if (localb != null) {
        localb.XF();
      }
      this.cSW = false;
    }
    AppMethodBeat.o(189925);
  }
  
  public final void cj(boolean paramBoolean)
  {
    this.cSY = paramBoolean;
    this.cSX = paramBoolean;
  }
  
  public final void ck(boolean paramBoolean)
  {
    AppMethodBeat.i(189919);
    if (this.cSY == paramBoolean)
    {
      AppMethodBeat.o(189919);
      return;
    }
    if (this.cSZ != null)
    {
      d locald = this.cSZ;
      if (locald == null) {
        break label78;
      }
      if (locald.isPlaying() == true)
      {
        locald = this.cSZ;
        if (locald != null) {
          locald.cj(paramBoolean);
        }
        hJ(paramBoolean);
        cj(paramBoolean);
      }
    }
    AppMethodBeat.o(189919);
    return;
    label78:
    AppMethodBeat.o(189919);
  }
  
  public final void cl(boolean paramBoolean)
  {
    AppMethodBeat.i(189921);
    bvv();
    if (!paramBoolean) {
      Oc("music");
    }
    if (this.cSW)
    {
      com.tencent.mm.compatible.util.b localb = this.cST;
      if (localb != null) {
        localb.XF();
      }
      this.cSW = false;
    }
    AppMethodBeat.o(189921);
  }
  
  public final boolean cm(boolean paramBoolean)
  {
    AppMethodBeat.i(189923);
    Object localObject = this.cSZ;
    if (localObject != null)
    {
      if (((d)localObject).isPlaying() != true) {
        break label94;
      }
      localObject = this.cSZ;
      if (localObject == null) {
        break label89;
      }
      paramBoolean = ((d)localObject).cp(paramBoolean);
    }
    for (;;)
    {
      localObject = com.tencent.mm.plugin.audio.c.a.mpv;
      com.tencent.mm.plugin.audio.c.a.a.bvB().bvv();
      if (this.cSW)
      {
        localObject = this.cST;
        if (localObject != null) {
          ((com.tencent.mm.compatible.util.b)localObject).XF();
        }
        this.cSW = false;
      }
      AppMethodBeat.o(189923);
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
  
  public final void hL(int paramInt)
  {
    AppMethodBeat.i(189926);
    super.hL(paramInt);
    switch (paramInt)
    {
    }
    for (;;)
    {
      AppMethodBeat.o(189926);
      return;
      ck(false);
      AppMethodBeat.o(189926);
      return;
      cj(this.cSX);
    }
  }
  
  public final void t(String paramString, int paramInt)
  {
    AppMethodBeat.i(189922);
    k.h(paramString, "filepath");
    d locald = this.cSZ;
    if (locald == null) {
      k.fvU();
    }
    if (!locald.c(paramString, this.cSY, paramInt))
    {
      ad.i("MicroMsg.SceneVoiceAudioManager", "start play error fileName[" + paramString + "], [" + this.cSY + ']');
      Oc("music");
    }
    AppMethodBeat.o(189922);
  }
  
  @l(fvt={1, 1, 16}, fvu={""}, fvv={"<anonymous>", "", "focusChange", "", "onChange"})
  static final class b
    implements b.a
  {
    b(a parama) {}
    
    public final void hM(int paramInt)
    {
      AppMethodBeat.i(189918);
      ad.i("MicroMsg.SceneVoiceAudioManager", "on audio focus change: %s", new Object[] { Integer.valueOf(paramInt) });
      a.a(this.cTd).aA(Integer.valueOf(paramInt));
      AppMethodBeat.o(189918);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.audio.a
 * JD-Core Version:    0.7.0.1
 */