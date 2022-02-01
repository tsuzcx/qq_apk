package com.tencent.mm.plugin.cast.c;

import android.os.HandlerThread;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.audio.b.c;
import com.tencent.mm.audio.b.c.a;
import com.tencent.mm.plugin.cast.i.e;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMHandler;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.vfs.w;
import kotlin.l;
import kotlin.x;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/cast/encoder/ScreenCastAudioEncoder;", "", "audioConfig", "Lcom/tencent/mm/plugin/cast/config/AudioRecordConfig;", "callback", "Lkotlin/Function1;", "", "", "(Lcom/tencent/mm/plugin/cast/config/AudioRecordConfig;Lkotlin/jvm/functions/Function1;)V", "getAudioConfig", "()Lcom/tencent/mm/plugin/cast/config/AudioRecordConfig;", "setAudioConfig", "(Lcom/tencent/mm/plugin/cast/config/AudioRecordConfig;)V", "audioHandlerThread", "Landroid/os/HandlerThread;", "audioRecordHandler", "Lcom/tencent/mm/sdk/platformtools/MMHandler;", "getAudioRecordHandler", "()Lcom/tencent/mm/sdk/platformtools/MMHandler;", "setAudioRecordHandler", "(Lcom/tencent/mm/sdk/platformtools/MMHandler;)V", "getCallback", "()Lkotlin/jvm/functions/Function1;", "setCallback", "(Lkotlin/jvm/functions/Function1;)V", "outputStream", "Lcom/tencent/mm/vfs/VFSFileOutputStream;", "pcmRecorder", "Lcom/tencent/mm/audio/recorder/MMPcmRecorder;", "onAudioFrameArrived", "data", "ret", "", "queue", "Lkotlin/Function0;", "startRecord", "stopRecord", "Companion", "plugin-cast_release"})
public final class a
{
  public static final a.a tIY;
  private kotlin.g.a.b<? super byte[], x> callback;
  private com.tencent.mm.plugin.cast.b.a tIQ;
  private MMHandler tIU;
  private HandlerThread tIV;
  private w tIW;
  private c tIX;
  
  static
  {
    AppMethodBeat.i(190057);
    tIY = new a.a((byte)0);
    AppMethodBeat.o(190057);
  }
  
  public a(com.tencent.mm.plugin.cast.b.a parama, kotlin.g.a.b<? super byte[], x> paramb)
  {
    AppMethodBeat.i(190054);
    this.tIQ = parama;
    this.callback = paramb;
    this.tIV = new HandlerThread("MicroMsg.ScreenCastAudioEncoder" + hashCode());
    this.tIV.start();
    this.tIU = new MMHandler(this.tIV.getLooper());
    parama = e.tKY;
    if (e.cMd())
    {
      parama = new com.tencent.mm.vfs.q("/sdcard/ScreenCastDebug");
      if (!parama.ifE()) {
        parama.ifL();
      }
      this.tIW = new w("/sdcard/ScreenCastDebug/audio_" + Util.currentTicks() + ".pcm");
    }
    this.tIX = new c(this.tIQ.audioSampleRate, this.tIQ.tIN, 9);
    parama = this.tIX;
    if (parama != null) {
      parama.kE(1);
    }
    parama = this.tIX;
    if (parama != null) {
      parama.aeT();
    }
    parama = this.tIX;
    if (parama != null)
    {
      parama.a((c.a)new c.a()
      {
        public final void cC(int paramAnonymousInt1, int paramAnonymousInt2)
        {
          AppMethodBeat.i(189374);
          Log.e("MicroMsg.ScreenCastAudioEncoder", "onRecError state is in ".concat(String.valueOf(paramAnonymousInt1)));
          AppMethodBeat.o(189374);
        }
        
        public final void w(byte[] paramAnonymousArrayOfByte, int paramAnonymousInt)
        {
          AppMethodBeat.i(189371);
          if (paramAnonymousArrayOfByte != null) {
            a.a(this.tIZ, paramAnonymousArrayOfByte);
          }
          AppMethodBeat.o(189371);
        }
      });
      AppMethodBeat.o(190054);
      return;
    }
    AppMethodBeat.o(190054);
  }
  
  public final void j(kotlin.g.a.a<x> parama)
  {
    AppMethodBeat.i(190048);
    if (this.tIV.isAlive()) {
      this.tIU.post((Runnable)new b(parama));
    }
    AppMethodBeat.o(190048);
  }
  
  public final void stopRecord()
  {
    AppMethodBeat.i(190050);
    j((kotlin.g.a.a)new c(this));
    AppMethodBeat.o(190050);
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "invoke"})
  public static final class b
    extends kotlin.g.b.q
    implements kotlin.g.a.a<x>
  {
    public b(a parama)
    {
      super();
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "invoke"})
  static final class c
    extends kotlin.g.b.q
    implements kotlin.g.a.a<x>
  {
    c(a parama)
    {
      super();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.cast.c.a
 * JD-Core Version:    0.7.0.1
 */