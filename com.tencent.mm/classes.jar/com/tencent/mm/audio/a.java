package com.tencent.mm.audio;

import android.content.Context;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.compatible.util.b.a;
import com.tencent.mm.modelvoice.d;
import com.tencent.mm.sdk.platformtools.ad;
import d.g.b.p;
import d.l;
import d.z;

@l(gfx={1, 1, 16}, gfy={""}, gfz={"Lcom/tencent/mm/audio/SceneVoicePlayerAudioManager;", "Lcom/tencent/mm/plugin/audio/mgr/BaseMusicAudioManager;", "context", "Landroid/content/Context;", "onAudioFocusChanged", "Lkotlin/Function1;", "", "Lkotlin/ParameterName;", "name", "status", "", "(Landroid/content/Context;Lkotlin/jvm/functions/Function1;)V", "abandonFocusOnStop", "", "audioFocusListener", "Lcom/tencent/mm/compatible/util/AudioFocusHelper$AudioFocusListener;", "bluetoothResumeSpeaker", "getContext", "()Landroid/content/Context;", "setContext", "(Landroid/content/Context;)V", "hasAudioFocus", "mAudioFocusHelper", "Lcom/tencent/mm/compatible/util/AudioFocusHelper;", "needFocusOnPlay", "player", "Lcom/tencent/mm/modelvoice/IVoicePlayer;", "getPlayer", "()Lcom/tencent/mm/modelvoice/IVoicePlayer;", "setPlayer", "(Lcom/tencent/mm/modelvoice/IVoicePlayer;)V", "value", "speakerOn", "getSpeakerOn", "()Z", "setSpeakerOn", "(Z)V", "onAudioDeviceStateChanged", "onErrorPlaying", "pausePlaying", "abandonFocus", "releaseAudioPlayingDevice", "isContinuousPlay", "requestAudioPlayingDevice", "requestSpeakerOn", "resumePlaying", "startPlay", "filepath", "", "position", "stopPlaying", "unInit", "Companion", "plugin-audiologic_release"})
public final class a
  extends com.tencent.mm.plugin.audio.b.c
{
  public static final a.a dbP;
  public Context context;
  public com.tencent.mm.compatible.util.b dbG;
  private boolean dbH;
  private boolean dbI;
  public boolean dbJ;
  private boolean dbK;
  public boolean dbL;
  public d dbM;
  private final b.a dbN;
  private d.g.a.b<? super Integer, z> dbO;
  
  static
  {
    AppMethodBeat.i(205849);
    dbP = new a.a((byte)0);
    AppMethodBeat.o(205849);
  }
  
  public a(Context paramContext, d.g.a.b<? super Integer, z> paramb)
  {
    AppMethodBeat.i(205848);
    this.dbO = paramb;
    this.dbH = true;
    this.dbI = true;
    this.context = paramContext;
    this.dbG = new com.tencent.mm.compatible.util.b(paramContext);
    com.tencent.mm.plugin.audio.d.a.bGM();
    com.tencent.mm.plugin.audio.d.c.bGM();
    paramContext = com.tencent.mm.plugin.audio.c.a.nrV;
    com.tencent.mm.plugin.audio.c.a.a.a((com.tencent.mm.plugin.audio.b.a)this, "music");
    this.dbN = ((b.a)new b(this));
    AppMethodBeat.o(205848);
  }
  
  public final void Ob()
  {
    AppMethodBeat.i(205841);
    Object localObject = this.dbM;
    if (localObject != null) {
      ((d)localObject).b(this.dbN);
    }
    localObject = this.dbM;
    if (localObject != null) {
      ((d)localObject).aNn();
    }
    if (this.dbH)
    {
      localObject = this.dbG;
      if (localObject != null) {
        ((com.tencent.mm.compatible.util.b)localObject).requestFocus();
      }
      this.dbJ = true;
    }
    this.dbI = true;
    localObject = com.tencent.mm.plugin.audio.c.a.nrV;
    if (!com.tencent.mm.plugin.audio.c.a.a.bGC().bGx())
    {
      b("music", Integer.valueOf(2));
      AppMethodBeat.o(205841);
      return;
    }
    b("music", Integer.valueOf(1));
    AppMethodBeat.o(205841);
  }
  
  public final boolean Oc()
  {
    AppMethodBeat.i(205845);
    Object localObject = this.dbM;
    if (localObject != null) {}
    for (boolean bool = ((d)localObject).resume();; bool = false)
    {
      if (bool)
      {
        b("music", Integer.valueOf(2));
        localObject = com.tencent.mm.plugin.audio.c.a.nrV;
        localObject = com.tencent.mm.plugin.audio.d.a.nrY;
        if (com.tencent.mm.plugin.audio.d.a.bGD()) {
          cm(false);
        }
        iq(this.dbL);
      }
      if (this.dbJ)
      {
        localObject = this.dbG;
        if (localObject != null) {
          ((com.tencent.mm.compatible.util.b)localObject).requestFocus();
        }
        this.dbJ = false;
      }
      AppMethodBeat.o(205845);
      return bool;
    }
  }
  
  public final void Od()
  {
    AppMethodBeat.i(205846);
    bGw();
    if ((this.dbJ) && (this.dbI))
    {
      com.tencent.mm.compatible.util.b localb = this.dbG;
      if (localb != null) {
        localb.abe();
      }
      this.dbJ = false;
    }
    AppMethodBeat.o(205846);
  }
  
  public final void cm(boolean paramBoolean)
  {
    this.dbL = paramBoolean;
    this.dbK = paramBoolean;
  }
  
  public final void cn(boolean paramBoolean)
  {
    AppMethodBeat.i(205840);
    if (this.dbL == paramBoolean)
    {
      AppMethodBeat.o(205840);
      return;
    }
    if (this.dbM != null)
    {
      d locald = this.dbM;
      if (locald == null) {
        break label78;
      }
      if (locald.isPlaying() == true)
      {
        locald = this.dbM;
        if (locald != null) {
          locald.cm(paramBoolean);
        }
        iq(paramBoolean);
        cm(paramBoolean);
      }
    }
    AppMethodBeat.o(205840);
    return;
    label78:
    AppMethodBeat.o(205840);
  }
  
  public final void co(boolean paramBoolean)
  {
    AppMethodBeat.i(205842);
    bGw();
    if (!paramBoolean) {
      VJ("music");
    }
    if (this.dbJ)
    {
      com.tencent.mm.compatible.util.b localb = this.dbG;
      if (localb != null) {
        localb.abe();
      }
      this.dbJ = false;
    }
    AppMethodBeat.o(205842);
  }
  
  public final boolean cp(boolean paramBoolean)
  {
    AppMethodBeat.i(205844);
    Object localObject = this.dbM;
    if (localObject != null)
    {
      if (((d)localObject).isPlaying() != true) {
        break label94;
      }
      localObject = this.dbM;
      if (localObject == null) {
        break label89;
      }
      paramBoolean = ((d)localObject).cs(paramBoolean);
    }
    for (;;)
    {
      localObject = com.tencent.mm.plugin.audio.c.a.nrV;
      com.tencent.mm.plugin.audio.c.a.a.bGC().bGw();
      if (this.dbJ)
      {
        localObject = this.dbG;
        if (localObject != null) {
          ((com.tencent.mm.compatible.util.b)localObject).abe();
        }
        this.dbJ = false;
      }
      AppMethodBeat.o(205844);
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
  
  public final void hC(int paramInt)
  {
    AppMethodBeat.i(205847);
    super.hC(paramInt);
    switch (paramInt)
    {
    }
    for (;;)
    {
      AppMethodBeat.o(205847);
      return;
      cn(false);
      AppMethodBeat.o(205847);
      return;
      cm(this.dbK);
    }
  }
  
  public final void v(String paramString, int paramInt)
  {
    AppMethodBeat.i(205843);
    p.h(paramString, "filepath");
    d locald = this.dbM;
    if (locald == null) {
      p.gfZ();
    }
    if (!locald.c(paramString, this.dbL, paramInt))
    {
      ad.i("MicroMsg.SceneVoiceAudioManager", "start play error fileName[" + paramString + "], [" + this.dbL + ']');
      VJ("music");
    }
    AppMethodBeat.o(205843);
  }
  
  @l(gfx={1, 1, 16}, gfy={""}, gfz={"<anonymous>", "", "focusChange", "", "onChange"})
  static final class b
    implements b.a
  {
    b(a parama) {}
    
    public final void hD(int paramInt)
    {
      AppMethodBeat.i(205839);
      ad.i("MicroMsg.SceneVoiceAudioManager", "on audio focus change: %s", new Object[] { Integer.valueOf(paramInt) });
      a.a(this.dbQ).invoke(Integer.valueOf(paramInt));
      AppMethodBeat.o(205839);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.audio.a
 * JD-Core Version:    0.7.0.1
 */