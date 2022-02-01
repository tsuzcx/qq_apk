package com.tencent.mm.audio;

import android.content.Context;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.compatible.util.b.a;
import com.tencent.mm.compatible.util.b.b;
import com.tencent.mm.plugin.audio.b.c;
import com.tencent.mm.sdk.platformtools.Log;
import kotlin.Metadata;
import kotlin.ah;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/audio/SceneVoicePlayerAudioManager;", "Lcom/tencent/mm/plugin/audio/mgr/BaseMusicAudioManager;", "context", "Landroid/content/Context;", "onAudioFocusChanged", "Lkotlin/Function1;", "", "Lkotlin/ParameterName;", "name", "status", "", "(Landroid/content/Context;Lkotlin/jvm/functions/Function1;)V", "abandonFocusOnStop", "", "audioFocusListener", "Lcom/tencent/mm/compatible/util/AudioFocusHelper$AudioFocusListener;", "bluetoothResumeSpeaker", "getContext", "()Landroid/content/Context;", "setContext", "(Landroid/content/Context;)V", "hasAudioFocus", "mAudioFocusHelper", "Lcom/tencent/mm/compatible/util/AudioFocusHelper;", "needFocusOnPlay", "player", "Lcom/tencent/mm/modelvoice/IVoicePlayer;", "getPlayer", "()Lcom/tencent/mm/modelvoice/IVoicePlayer;", "setPlayer", "(Lcom/tencent/mm/modelvoice/IVoicePlayer;)V", "value", "speakerOn", "getSpeakerOn", "()Z", "setSpeakerOn", "(Z)V", "onAudioDeviceStateChanged", "onErrorPlaying", "pausePlaying", "abandonFocus", "releaseAudioPlayingDevice", "isContinuousPlay", "requestAudioPlayingDevice", "requestSpeakerOn", "resumePlaying", "startPlay", "filepath", "", "position", "stopPlaying", "unInit", "Companion", "plugin-audiologic_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class a
  extends c
{
  public static final a.a hqu;
  public Context context;
  private boolean hqA;
  public boolean hqB;
  public com.tencent.mm.modelvoice.d hqC;
  private final b.a hqD;
  private kotlin.g.a.b<? super Integer, ah> hqv;
  public com.tencent.mm.compatible.util.b hqw;
  private boolean hqx;
  private boolean hqy;
  public boolean hqz;
  
  static
  {
    AppMethodBeat.i(236150);
    hqu = new a.a((byte)0);
    AppMethodBeat.o(236150);
  }
  
  public a(Context paramContext, kotlin.g.a.b<? super Integer, ah> paramb)
  {
    AppMethodBeat.i(236146);
    this.hqv = paramb;
    this.hqx = true;
    this.hqy = true;
    this.context = paramContext;
    this.hqw = new com.tencent.mm.compatible.util.b(paramContext);
    com.tencent.mm.plugin.audio.d.b.cUq();
    com.tencent.mm.plugin.audio.d.d.cUq();
    paramContext = com.tencent.mm.plugin.audio.c.a.uVi;
    com.tencent.mm.plugin.audio.c.a.a.a((com.tencent.mm.plugin.audio.b.a)this, "music");
    this.hqD = new a..ExternalSyntheticLambda0(this);
    AppMethodBeat.o(236146);
  }
  
  private static final void a(a parama, int paramInt)
  {
    AppMethodBeat.i(236149);
    s.u(parama, "this$0");
    Log.i("MicroMsg.SceneVoiceAudioManager", "on audio focus change: %s", new Object[] { Integer.valueOf(paramInt) });
    parama.hqv.invoke(Integer.valueOf(paramInt));
    AppMethodBeat.o(236149);
  }
  
  public final void Y(String paramString, int paramInt)
  {
    AppMethodBeat.i(236160);
    s.u(paramString, "filepath");
    com.tencent.mm.modelvoice.d locald = this.hqC;
    s.checkNotNull(locald);
    if (!locald.c(paramString, this.hqB, paramInt))
    {
      Log.i("MicroMsg.SceneVoiceAudioManager", "start play error fileName[" + paramString + "], [" + this.hqB + ']');
      ahq("music");
    }
    AppMethodBeat.o(236160);
  }
  
  public final void aER()
  {
    AppMethodBeat.i(236157);
    Object localObject = this.hqC;
    if (localObject != null) {
      ((com.tencent.mm.modelvoice.d)localObject).c(this.hqD);
    }
    localObject = this.hqC;
    if (localObject != null) {
      ((com.tencent.mm.modelvoice.d)localObject).bOU();
    }
    if (this.hqx)
    {
      this.hqw = new com.tencent.mm.compatible.util.b(this.context);
      localObject = this.hqw;
      if (localObject != null) {
        ((com.tencent.mm.compatible.util.b)localObject).a(this.hqD);
      }
      localObject = this.hqw;
      if (localObject != null) {
        ((com.tencent.mm.compatible.util.b)localObject).requestFocus();
      }
      this.hqz = true;
    }
    this.hqy = true;
    localObject = com.tencent.mm.plugin.audio.c.a.uVi;
    if (!com.tencent.mm.plugin.audio.c.a.a.cTW().cTQ())
    {
      b("music", Integer.valueOf(2));
      AppMethodBeat.o(236157);
      return;
    }
    b("music", Integer.valueOf(1));
    AppMethodBeat.o(236157);
  }
  
  public final boolean aES()
  {
    AppMethodBeat.i(236163);
    Object localObject = this.hqC;
    if (localObject == null) {}
    for (boolean bool = false;; bool = ((com.tencent.mm.modelvoice.d)localObject).resume())
    {
      if (bool)
      {
        b("music", Integer.valueOf(2));
        localObject = com.tencent.mm.plugin.audio.c.a.uVi;
        localObject = com.tencent.mm.plugin.audio.d.b.uVo;
        if (com.tencent.mm.plugin.audio.d.b.cTX()) {
          ed(false);
        }
        lN(this.hqB);
      }
      if (this.hqz)
      {
        localObject = this.hqw;
        if (localObject != null) {
          ((com.tencent.mm.compatible.util.b)localObject).requestFocus();
        }
        this.hqz = true;
      }
      AppMethodBeat.o(236163);
      return bool;
    }
  }
  
  public final void aET()
  {
    AppMethodBeat.i(236164);
    cTP();
    if ((this.hqz) && (this.hqy))
    {
      com.tencent.mm.compatible.util.b localb = this.hqw;
      if (localb != null) {
        localb.aPS();
      }
      this.hqz = false;
    }
    AppMethodBeat.o(236164);
  }
  
  public final void ed(boolean paramBoolean)
  {
    this.hqB = paramBoolean;
    this.hqA = paramBoolean;
  }
  
  public final void ee(boolean paramBoolean)
  {
    int i = 1;
    AppMethodBeat.i(236155);
    if (this.hqB == paramBoolean)
    {
      AppMethodBeat.o(236155);
      return;
    }
    com.tencent.mm.modelvoice.d locald;
    if (this.hqC != null)
    {
      locald = this.hqC;
      if ((locald == null) || (locald.isPlaying() != true)) {
        break label87;
      }
    }
    for (;;)
    {
      if (i != 0)
      {
        locald = this.hqC;
        if (locald != null) {
          locald.ed(paramBoolean);
        }
        lN(paramBoolean);
        ed(paramBoolean);
      }
      AppMethodBeat.o(236155);
      return;
      label87:
      i = 0;
    }
  }
  
  public final void ef(boolean paramBoolean)
  {
    AppMethodBeat.i(236158);
    cTP();
    if (!paramBoolean) {
      ahq("music");
    }
    if (this.hqz)
    {
      com.tencent.mm.compatible.util.b localb = this.hqw;
      if (localb != null) {
        localb.aPS();
      }
      localb = this.hqw;
      if (localb != null)
      {
        b.a locala = this.hqD;
        if (localb.lYM != null) {
          localb.lYM.b(locala);
        }
      }
      this.hqw = null;
      this.hqz = false;
    }
    AppMethodBeat.o(236158);
  }
  
  public final boolean eg(boolean paramBoolean)
  {
    int i = 1;
    AppMethodBeat.i(236161);
    Object localObject = this.hqC;
    if ((localObject != null) && (((com.tencent.mm.modelvoice.d)localObject).isPlaying() == true))
    {
      if (i == 0) {
        break label102;
      }
      localObject = this.hqC;
      if (localObject != null) {
        break label91;
      }
      paramBoolean = false;
    }
    for (;;)
    {
      localObject = com.tencent.mm.plugin.audio.c.a.uVi;
      com.tencent.mm.plugin.audio.c.a.a.cTW().cTP();
      if (this.hqz)
      {
        localObject = this.hqw;
        if (localObject != null) {
          ((com.tencent.mm.compatible.util.b)localObject).aPS();
        }
        this.hqz = false;
      }
      AppMethodBeat.o(236161);
      return paramBoolean;
      i = 0;
      break;
      label91:
      paramBoolean = ((com.tencent.mm.modelvoice.d)localObject).em(paramBoolean);
      continue;
      label102:
      paramBoolean = false;
    }
  }
  
  public final void nW(int paramInt)
  {
    AppMethodBeat.i(236166);
    super.nW(paramInt);
    switch (paramInt)
    {
    }
    for (;;)
    {
      AppMethodBeat.o(236166);
      return;
      ee(false);
      AppMethodBeat.o(236166);
      return;
      ed(this.hqA);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes11.jar
 * Qualified Name:     com.tencent.mm.audio.a
 * JD-Core Version:    0.7.0.1
 */