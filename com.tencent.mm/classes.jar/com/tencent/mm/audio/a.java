package com.tencent.mm.audio;

import android.content.Context;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.compatible.util.b.a;
import com.tencent.mm.modelvoice.d;
import com.tencent.mm.sdk.platformtools.ae;
import d.g.b.p;
import d.l;
import d.z;

@l(gjZ={1, 1, 16}, gka={""}, gkb={"Lcom/tencent/mm/audio/SceneVoicePlayerAudioManager;", "Lcom/tencent/mm/plugin/audio/mgr/BaseMusicAudioManager;", "context", "Landroid/content/Context;", "onAudioFocusChanged", "Lkotlin/Function1;", "", "Lkotlin/ParameterName;", "name", "status", "", "(Landroid/content/Context;Lkotlin/jvm/functions/Function1;)V", "abandonFocusOnStop", "", "audioFocusListener", "Lcom/tencent/mm/compatible/util/AudioFocusHelper$AudioFocusListener;", "bluetoothResumeSpeaker", "getContext", "()Landroid/content/Context;", "setContext", "(Landroid/content/Context;)V", "hasAudioFocus", "mAudioFocusHelper", "Lcom/tencent/mm/compatible/util/AudioFocusHelper;", "needFocusOnPlay", "player", "Lcom/tencent/mm/modelvoice/IVoicePlayer;", "getPlayer", "()Lcom/tencent/mm/modelvoice/IVoicePlayer;", "setPlayer", "(Lcom/tencent/mm/modelvoice/IVoicePlayer;)V", "value", "speakerOn", "getSpeakerOn", "()Z", "setSpeakerOn", "(Z)V", "onAudioDeviceStateChanged", "onErrorPlaying", "pausePlaying", "abandonFocus", "releaseAudioPlayingDevice", "isContinuousPlay", "requestAudioPlayingDevice", "requestSpeakerOn", "resumePlaying", "startPlay", "filepath", "", "position", "stopPlaying", "unInit", "Companion", "plugin-audiologic_release"})
public final class a
  extends com.tencent.mm.plugin.audio.b.c
{
  public static final a.a dcR;
  public Context context;
  public com.tencent.mm.compatible.util.b dcI;
  private boolean dcJ;
  private boolean dcK;
  public boolean dcL;
  private boolean dcM;
  public boolean dcN;
  public d dcO;
  private final b.a dcP;
  private d.g.a.b<? super Integer, z> dcQ;
  
  static
  {
    AppMethodBeat.i(200169);
    dcR = new a.a((byte)0);
    AppMethodBeat.o(200169);
  }
  
  public a(Context paramContext, d.g.a.b<? super Integer, z> paramb)
  {
    AppMethodBeat.i(200168);
    this.dcQ = paramb;
    this.dcJ = true;
    this.dcK = true;
    this.context = paramContext;
    this.dcI = new com.tencent.mm.compatible.util.b(paramContext);
    com.tencent.mm.plugin.audio.d.a.bHI();
    com.tencent.mm.plugin.audio.d.c.bHI();
    paramContext = com.tencent.mm.plugin.audio.c.a.nxo;
    com.tencent.mm.plugin.audio.c.a.a.a((com.tencent.mm.plugin.audio.b.a)this, "music");
    this.dcP = ((b.a)new b(this));
    AppMethodBeat.o(200168);
  }
  
  public final void NZ()
  {
    AppMethodBeat.i(200161);
    Object localObject = this.dcO;
    if (localObject != null) {
      ((d)localObject).b(this.dcP);
    }
    localObject = this.dcO;
    if (localObject != null) {
      ((d)localObject).aNL();
    }
    if (this.dcJ)
    {
      localObject = this.dcI;
      if (localObject != null) {
        ((com.tencent.mm.compatible.util.b)localObject).a(this.dcP);
      }
      localObject = this.dcI;
      if (localObject != null) {
        ((com.tencent.mm.compatible.util.b)localObject).requestFocus();
      }
      this.dcL = true;
    }
    this.dcK = true;
    localObject = com.tencent.mm.plugin.audio.c.a.nxo;
    if (!com.tencent.mm.plugin.audio.c.a.a.bHy().bHt())
    {
      b("music", Integer.valueOf(2));
      AppMethodBeat.o(200161);
      return;
    }
    b("music", Integer.valueOf(1));
    AppMethodBeat.o(200161);
  }
  
  public final boolean Oa()
  {
    AppMethodBeat.i(200165);
    Object localObject = this.dcO;
    if (localObject != null) {}
    for (boolean bool = ((d)localObject).resume();; bool = false)
    {
      if (bool)
      {
        b("music", Integer.valueOf(2));
        localObject = com.tencent.mm.plugin.audio.c.a.nxo;
        localObject = com.tencent.mm.plugin.audio.d.a.nxr;
        if (com.tencent.mm.plugin.audio.d.a.bHz()) {
          cm(false);
        }
        io(this.dcN);
      }
      if (this.dcL)
      {
        localObject = this.dcI;
        if (localObject != null) {
          ((com.tencent.mm.compatible.util.b)localObject).requestFocus();
        }
        this.dcL = false;
      }
      AppMethodBeat.o(200165);
      return bool;
    }
  }
  
  public final void Ob()
  {
    AppMethodBeat.i(200166);
    bHs();
    if ((this.dcL) && (this.dcK))
    {
      com.tencent.mm.compatible.util.b localb = this.dcI;
      if (localb != null) {
        localb.abn();
      }
      this.dcL = false;
    }
    AppMethodBeat.o(200166);
  }
  
  public final void cm(boolean paramBoolean)
  {
    this.dcN = paramBoolean;
    this.dcM = paramBoolean;
  }
  
  public final void cn(boolean paramBoolean)
  {
    AppMethodBeat.i(200160);
    if (this.dcN == paramBoolean)
    {
      AppMethodBeat.o(200160);
      return;
    }
    if (this.dcO != null)
    {
      d locald = this.dcO;
      if (locald == null) {
        break label78;
      }
      if (locald.isPlaying() == true)
      {
        locald = this.dcO;
        if (locald != null) {
          locald.cm(paramBoolean);
        }
        io(paramBoolean);
        cm(paramBoolean);
      }
    }
    AppMethodBeat.o(200160);
    return;
    label78:
    AppMethodBeat.o(200160);
  }
  
  public final void co(boolean paramBoolean)
  {
    AppMethodBeat.i(200162);
    bHs();
    if (!paramBoolean) {
      Wv("music");
    }
    if (this.dcL)
    {
      com.tencent.mm.compatible.util.b localb = this.dcI;
      if (localb != null) {
        localb.abn();
      }
      this.dcL = false;
    }
    AppMethodBeat.o(200162);
  }
  
  public final boolean cp(boolean paramBoolean)
  {
    AppMethodBeat.i(200164);
    Object localObject = this.dcO;
    if (localObject != null)
    {
      if (((d)localObject).isPlaying() != true) {
        break label94;
      }
      localObject = this.dcO;
      if (localObject == null) {
        break label89;
      }
      paramBoolean = ((d)localObject).cs(paramBoolean);
    }
    for (;;)
    {
      localObject = com.tencent.mm.plugin.audio.c.a.nxo;
      com.tencent.mm.plugin.audio.c.a.a.bHy().bHs();
      if (this.dcL)
      {
        localObject = this.dcI;
        if (localObject != null) {
          ((com.tencent.mm.compatible.util.b)localObject).abn();
        }
        this.dcL = false;
      }
      AppMethodBeat.o(200164);
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
  
  public final void hE(int paramInt)
  {
    AppMethodBeat.i(200167);
    super.hE(paramInt);
    switch (paramInt)
    {
    }
    for (;;)
    {
      AppMethodBeat.o(200167);
      return;
      cn(false);
      AppMethodBeat.o(200167);
      return;
      cm(this.dcM);
    }
  }
  
  public final void w(String paramString, int paramInt)
  {
    AppMethodBeat.i(200163);
    p.h(paramString, "filepath");
    d locald = this.dcO;
    if (locald == null) {
      p.gkB();
    }
    if (!locald.c(paramString, this.dcN, paramInt))
    {
      ae.i("MicroMsg.SceneVoiceAudioManager", "start play error fileName[" + paramString + "], [" + this.dcN + ']');
      Wv("music");
    }
    AppMethodBeat.o(200163);
  }
  
  @l(gjZ={1, 1, 16}, gka={""}, gkb={"<anonymous>", "", "focusChange", "", "onChange"})
  static final class b
    implements b.a
  {
    b(a parama) {}
    
    public final void hF(int paramInt)
    {
      AppMethodBeat.i(200159);
      ae.i("MicroMsg.SceneVoiceAudioManager", "on audio focus change: %s", new Object[] { Integer.valueOf(paramInt) });
      a.a(this.dcS).invoke(Integer.valueOf(paramInt));
      AppMethodBeat.o(200159);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.audio.a
 * JD-Core Version:    0.7.0.1
 */