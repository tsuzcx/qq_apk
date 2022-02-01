package com.tencent.mm.audio;

import android.content.Context;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.compatible.util.b.a;
import com.tencent.mm.modelvoice.d;
import com.tencent.mm.sdk.platformtools.ac;
import d.g.b.k;
import d.l;
import d.y;

@l(fNY={1, 1, 16}, fNZ={""}, fOa={"Lcom/tencent/mm/audio/SceneVoicePlayerAudioManager;", "Lcom/tencent/mm/plugin/audio/mgr/BaseMusicAudioManager;", "context", "Landroid/content/Context;", "onAudioFocusChanged", "Lkotlin/Function1;", "", "Lkotlin/ParameterName;", "name", "status", "", "(Landroid/content/Context;Lkotlin/jvm/functions/Function1;)V", "abandonFocusOnStop", "", "audioFocusListener", "Lcom/tencent/mm/compatible/util/AudioFocusHelper$AudioFocusListener;", "bluetoothResumeSpeaker", "getContext", "()Landroid/content/Context;", "setContext", "(Landroid/content/Context;)V", "hasAudioFocus", "mAudioFocusHelper", "Lcom/tencent/mm/compatible/util/AudioFocusHelper;", "needFocusOnPlay", "player", "Lcom/tencent/mm/modelvoice/IVoicePlayer;", "getPlayer", "()Lcom/tencent/mm/modelvoice/IVoicePlayer;", "setPlayer", "(Lcom/tencent/mm/modelvoice/IVoicePlayer;)V", "value", "speakerOn", "getSpeakerOn", "()Z", "setSpeakerOn", "(Z)V", "onAudioDeviceStateChanged", "onErrorPlaying", "pausePlaying", "abandonFocus", "releaseAudioPlayingDevice", "isContinuousPlay", "requestAudioPlayingDevice", "requestSpeakerOn", "resumePlaying", "startPlay", "filepath", "", "position", "stopPlaying", "unInit", "Companion", "plugin-audiologic_release"})
public final class a
  extends com.tencent.mm.plugin.audio.b.c
{
  public static final a.a cQz;
  public com.tencent.mm.compatible.util.b cQq;
  private boolean cQr;
  private boolean cQs;
  public boolean cQt;
  private boolean cQu;
  public boolean cQv;
  public d cQw;
  private final b.a cQx;
  private d.g.a.b<? super Integer, y> cQy;
  public Context context;
  
  static
  {
    AppMethodBeat.i(209470);
    cQz = new a.a((byte)0);
    AppMethodBeat.o(209470);
  }
  
  public a(Context paramContext, d.g.a.b<? super Integer, y> paramb)
  {
    AppMethodBeat.i(209469);
    this.cQy = paramb;
    this.cQr = true;
    this.cQs = true;
    this.context = paramContext;
    this.cQq = new com.tencent.mm.compatible.util.b(paramContext);
    com.tencent.mm.plugin.audio.d.a.bCE();
    com.tencent.mm.plugin.audio.d.c.bCE();
    paramContext = com.tencent.mm.plugin.audio.c.a.mRw;
    com.tencent.mm.plugin.audio.c.a.a.a((com.tencent.mm.plugin.audio.b.a)this, "music");
    this.cQx = ((b.a)new b(this));
    AppMethodBeat.o(209469);
  }
  
  public final void Ms()
  {
    AppMethodBeat.i(209462);
    Object localObject = this.cQw;
    if (localObject != null) {
      ((d)localObject).b(this.cQx);
    }
    localObject = this.cQw;
    if (localObject != null) {
      ((d)localObject).aKe();
    }
    if (this.cQr)
    {
      localObject = this.cQq;
      if (localObject != null) {
        ((com.tencent.mm.compatible.util.b)localObject).requestFocus();
      }
      this.cQt = true;
    }
    this.cQs = true;
    localObject = com.tencent.mm.plugin.audio.c.a.mRw;
    if (!com.tencent.mm.plugin.audio.c.a.a.bCx().bCs())
    {
      b("music", Integer.valueOf(2));
      AppMethodBeat.o(209462);
      return;
    }
    b("music", Integer.valueOf(1));
    AppMethodBeat.o(209462);
  }
  
  public final boolean Mt()
  {
    AppMethodBeat.i(209466);
    Object localObject = this.cQw;
    if (localObject != null) {}
    for (boolean bool = ((d)localObject).resume();; bool = false)
    {
      if (bool)
      {
        b("music", Integer.valueOf(2));
        localObject = com.tencent.mm.plugin.audio.c.a.mRw;
        localObject = com.tencent.mm.plugin.audio.d.a.mRz;
        if (com.tencent.mm.plugin.audio.d.a.bCy()) {
          cl(false);
        }
        ih(this.cQv);
      }
      if (this.cQt)
      {
        localObject = this.cQq;
        if (localObject != null) {
          ((com.tencent.mm.compatible.util.b)localObject).requestFocus();
        }
        this.cQt = false;
      }
      AppMethodBeat.o(209466);
      return bool;
    }
  }
  
  public final void Mu()
  {
    AppMethodBeat.i(209467);
    bCr();
    if ((this.cQt) && (this.cQs))
    {
      com.tencent.mm.compatible.util.b localb = this.cQq;
      if (localb != null) {
        localb.YC();
      }
      this.cQt = false;
    }
    AppMethodBeat.o(209467);
  }
  
  public final void cl(boolean paramBoolean)
  {
    this.cQv = paramBoolean;
    this.cQu = paramBoolean;
  }
  
  public final void cm(boolean paramBoolean)
  {
    AppMethodBeat.i(209461);
    if (this.cQv == paramBoolean)
    {
      AppMethodBeat.o(209461);
      return;
    }
    if (this.cQw != null)
    {
      d locald = this.cQw;
      if (locald == null) {
        break label78;
      }
      if (locald.isPlaying() == true)
      {
        locald = this.cQw;
        if (locald != null) {
          locald.cl(paramBoolean);
        }
        ih(paramBoolean);
        cl(paramBoolean);
      }
    }
    AppMethodBeat.o(209461);
    return;
    label78:
    AppMethodBeat.o(209461);
  }
  
  public final void cn(boolean paramBoolean)
  {
    AppMethodBeat.i(209463);
    bCr();
    if (!paramBoolean) {
      Sl("music");
    }
    if (this.cQt)
    {
      com.tencent.mm.compatible.util.b localb = this.cQq;
      if (localb != null) {
        localb.YC();
      }
      this.cQt = false;
    }
    AppMethodBeat.o(209463);
  }
  
  public final boolean co(boolean paramBoolean)
  {
    AppMethodBeat.i(209465);
    Object localObject = this.cQw;
    if (localObject != null)
    {
      if (((d)localObject).isPlaying() != true) {
        break label94;
      }
      localObject = this.cQw;
      if (localObject == null) {
        break label89;
      }
      paramBoolean = ((d)localObject).bF(paramBoolean);
    }
    for (;;)
    {
      localObject = com.tencent.mm.plugin.audio.c.a.mRw;
      com.tencent.mm.plugin.audio.c.a.a.bCx().bCr();
      if (this.cQt)
      {
        localObject = this.cQq;
        if (localObject != null) {
          ((com.tencent.mm.compatible.util.b)localObject).YC();
        }
        this.cQt = false;
      }
      AppMethodBeat.o(209465);
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
  
  public final void hv(int paramInt)
  {
    AppMethodBeat.i(209468);
    super.hv(paramInt);
    switch (paramInt)
    {
    }
    for (;;)
    {
      AppMethodBeat.o(209468);
      return;
      cm(false);
      AppMethodBeat.o(209468);
      return;
      cl(this.cQu);
    }
  }
  
  public final void t(String paramString, int paramInt)
  {
    AppMethodBeat.i(209464);
    k.h(paramString, "filepath");
    d locald = this.cQw;
    if (locald == null) {
      k.fOy();
    }
    if (!locald.c(paramString, this.cQv, paramInt))
    {
      ac.i("MicroMsg.SceneVoiceAudioManager", "start play error fileName[" + paramString + "], [" + this.cQv + ']');
      Sl("music");
    }
    AppMethodBeat.o(209464);
  }
  
  @l(fNY={1, 1, 16}, fNZ={""}, fOa={"<anonymous>", "", "focusChange", "", "onChange"})
  static final class b
    implements b.a
  {
    b(a parama) {}
    
    public final void hw(int paramInt)
    {
      AppMethodBeat.i(209460);
      ac.i("MicroMsg.SceneVoiceAudioManager", "on audio focus change: %s", new Object[] { Integer.valueOf(paramInt) });
      a.a(this.cQA).ay(Integer.valueOf(paramInt));
      AppMethodBeat.o(209460);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.audio.a
 * JD-Core Version:    0.7.0.1
 */