package com.tencent.mm.mj_template.maas.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.audio.b.c;
import com.tencent.mm.audio.b.c.a;
import com.tencent.mm.sdk.platformtools.Log;
import kotlin.Metadata;
import kotlin.ah;
import kotlin.g.a.m;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/mj_template/maas/record/FinderTemplateAudioRecorder;", "", "audioConfig", "Lcom/tencent/mm/mj_template/maas/record/AudioConfig;", "(Lcom/tencent/mm/mj_template/maas/record/AudioConfig;)V", "TAG", "", "callback", "Lkotlin/Function2;", "", "", "", "pcmRecorder", "Lcom/tencent/mm/audio/recorder/MMPcmRecorder;", "onReceivePcmFrame", "pcm", "len", "start", "stop", "plugin-mj-template_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class b
{
  public static final int Ue = 8;
  final String TAG;
  m<? super byte[], ? super Integer, ah> mgM;
  final a oaN;
  final c oaO;
  
  public b(a parama)
  {
    AppMethodBeat.i(240001);
    this.oaN = parama;
    this.TAG = "MicroMsg.FinderTemplateAudioRecorder";
    this.oaO = new c(this.oaN.sampleRate, this.oaN.channelCount, 5);
    parama = this.oaO;
    parama.ol(1);
    parama.hwn = -19;
    parama.hwy = ((c.a)new a(this));
    this.oaN.oaM = this.oaO.hwi;
    AppMethodBeat.o(240001);
  }
  
  @Metadata(d1={""}, d2={"com/tencent/mm/mj_template/maas/record/FinderTemplateAudioRecorder$1$1", "Lcom/tencent/mm/audio/recorder/MMPcmRecorder$OnPcmRecListener;", "onRecError", "", "state", "", "detailState", "onRecPcmDataReady", "pcm", "", "len", "plugin-mj-template_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class a
    implements c.a
  {
    a(b paramb) {}
    
    public final void ds(int paramInt1, int paramInt2)
    {
      AppMethodBeat.i(240007);
      Log.e(b.a(this.oaP), s.X("onRecError state is in ", Integer.valueOf(paramInt1)));
      AppMethodBeat.o(240007);
    }
    
    public final void u(byte[] paramArrayOfByte, int paramInt)
    {
      AppMethodBeat.i(239990);
      if ((paramArrayOfByte == null) || (paramInt <= 0))
      {
        AppMethodBeat.o(239990);
        return;
      }
      b.a(this.oaP, paramArrayOfByte, paramInt);
      AppMethodBeat.o(239990);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.mj_template.maas.a.b
 * JD-Core Version:    0.7.0.1
 */