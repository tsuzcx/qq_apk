package com.tencent.mm.plugin.cast.b;

import android.os.HandlerThread;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.audio.b.c;
import com.tencent.mm.audio.b.c.a;
import com.tencent.mm.plugin.cast.h.e;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMHandler;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.vfs.aa;
import kotlin.Metadata;
import kotlin.ah;
import kotlin.g.a.b;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/cast/encoder/ScreenCastAudioEncoder;", "", "audioConfig", "Lcom/tencent/mm/plugin/cast/config/AudioRecordConfig;", "callback", "Lkotlin/Function1;", "", "", "(Lcom/tencent/mm/plugin/cast/config/AudioRecordConfig;Lkotlin/jvm/functions/Function1;)V", "getAudioConfig", "()Lcom/tencent/mm/plugin/cast/config/AudioRecordConfig;", "setAudioConfig", "(Lcom/tencent/mm/plugin/cast/config/AudioRecordConfig;)V", "audioHandlerThread", "Landroid/os/HandlerThread;", "audioRecordHandler", "Lcom/tencent/mm/sdk/platformtools/MMHandler;", "getAudioRecordHandler", "()Lcom/tencent/mm/sdk/platformtools/MMHandler;", "setAudioRecordHandler", "(Lcom/tencent/mm/sdk/platformtools/MMHandler;)V", "getCallback", "()Lkotlin/jvm/functions/Function1;", "setCallback", "(Lkotlin/jvm/functions/Function1;)V", "outputStream", "Lcom/tencent/mm/vfs/VFSFileOutputStream;", "pcmRecorder", "Lcom/tencent/mm/audio/recorder/MMPcmRecorder;", "onAudioFrameArrived", "data", "ret", "", "queue", "Lkotlin/Function0;", "startRecord", "stopRecord", "Companion", "plugin-cast_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class a
{
  public static final a.a wMB;
  private b<? super byte[], ah> callback;
  private c oaO;
  private MMHandler wMC;
  private HandlerThread wMD;
  private aa wME;
  private com.tencent.mm.plugin.cast.a.a wMx;
  
  static
  {
    AppMethodBeat.i(274300);
    wMB = new a.a((byte)0);
    AppMethodBeat.o(274300);
  }
  
  public a(com.tencent.mm.plugin.cast.a.a parama, b<? super byte[], ah> paramb)
  {
    AppMethodBeat.i(274252);
    this.wMx = parama;
    this.callback = paramb;
    this.wMD = new HandlerThread(s.X("MicroMsg.ScreenCastAudioEncoder", Integer.valueOf(hashCode())));
    this.wMD.start();
    this.wMC = new MMHandler(this.wMD.getLooper());
    parama = e.wOn;
    if (e.dpH())
    {
      parama = new com.tencent.mm.vfs.u("/sdcard/ScreenCastDebug");
      if (!parama.jKS()) {
        parama.jKY();
      }
      this.wME = new aa("/sdcard/ScreenCastDebug/audio_" + Util.currentTicks() + ".pcm");
    }
    this.oaO = new c(this.wMx.audioSampleRate, this.wMx.wMu, 9);
    parama = this.oaO;
    if (parama != null) {
      parama.ol(1);
    }
    parama = this.oaO;
    if (parama != null) {
      parama.hwn = -19;
    }
    parama = this.oaO;
    if (parama != null) {
      parama.hwy = ((c.a)new c.a()
      {
        public final void ds(int paramAnonymousInt1, int paramAnonymousInt2)
        {
          AppMethodBeat.i(274251);
          Log.e("MicroMsg.ScreenCastAudioEncoder", s.X("onRecError state is in ", Integer.valueOf(paramAnonymousInt1)));
          AppMethodBeat.o(274251);
        }
        
        public final void u(byte[] paramAnonymousArrayOfByte, int paramAnonymousInt)
        {
          AppMethodBeat.i(274245);
          if (paramAnonymousArrayOfByte != null) {
            a.a(this.wMF, paramAnonymousArrayOfByte);
          }
          AppMethodBeat.o(274245);
        }
      });
    }
    AppMethodBeat.o(274252);
  }
  
  private final void K(kotlin.g.a.a<ah> parama)
  {
    AppMethodBeat.i(274260);
    if (this.wMD.isAlive()) {
      this.wMC.post(new a..ExternalSyntheticLambda0(parama));
    }
    AppMethodBeat.o(274260);
  }
  
  private static final void aH(kotlin.g.a.a parama)
  {
    AppMethodBeat.i(274267);
    s.u(parama, "$tmp0");
    parama.invoke();
    AppMethodBeat.o(274267);
  }
  
  public final void dpe()
  {
    AppMethodBeat.i(274313);
    K((kotlin.g.a.a)new b(this));
    AppMethodBeat.o(274313);
  }
  
  public final void stopRecord()
  {
    AppMethodBeat.i(274316);
    K((kotlin.g.a.a)new c(this));
    AppMethodBeat.o(274316);
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", ""}, k=3, mv={1, 5, 1}, xi=48)
  static final class b
    extends kotlin.g.b.u
    implements kotlin.g.a.a<ah>
  {
    b(a parama)
    {
      super();
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", ""}, k=3, mv={1, 5, 1}, xi=48)
  static final class c
    extends kotlin.g.b.u
    implements kotlin.g.a.a<ah>
  {
    c(a parama)
    {
      super();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.cast.b.a
 * JD-Core Version:    0.7.0.1
 */