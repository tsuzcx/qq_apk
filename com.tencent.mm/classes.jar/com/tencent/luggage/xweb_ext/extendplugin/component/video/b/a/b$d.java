package com.tencent.luggage.xweb_ext.extendplugin.component.video.b.a;

import android.view.Surface;
import com.google.android.exoplayer2.Format;
import com.google.android.exoplayer2.b.d;
import com.google.android.exoplayer2.f.a;
import com.google.android.exoplayer2.f.j.a;
import com.google.android.exoplayer2.metadata.Metadata;
import com.google.android.exoplayer2.metadata.e.a;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ab;
import java.util.List;

final class b$d
  implements com.google.android.exoplayer2.a.e, j.a, e.a, com.google.android.exoplayer2.video.e
{
  private b$d(b paramb) {}
  
  public final void a(d paramd)
  {
    AppMethodBeat.i(139961);
    ab.i("MicroMsg.SameLayer.ExoMediaPlayer", "onVideoEnabled");
    AppMethodBeat.o(139961);
  }
  
  public final void b(int paramInt1, int paramInt2, int paramInt3, float paramFloat)
  {
    AppMethodBeat.i(139967);
    ab.i("MicroMsg.SameLayer.ExoMediaPlayer", "onVideoSizeChanged, width:%d, height:%d, rotationDegrees:%d, ratio:%s", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), Integer.valueOf(paramInt3), Float.valueOf(paramFloat) });
    this.bIP.mVideoWidth = paramInt1;
    this.bIP.mVideoHeight = paramInt2;
    this.bIP.bM(paramInt1, paramInt2);
    AppMethodBeat.o(139967);
  }
  
  public final void b(d paramd)
  {
    AppMethodBeat.i(139962);
    ab.i("MicroMsg.SameLayer.ExoMediaPlayer", "onVideoDisabled");
    AppMethodBeat.o(139962);
  }
  
  public final void b(Metadata paramMetadata)
  {
    AppMethodBeat.i(139959);
    ab.i("MicroMsg.SameLayer.ExoMediaPlayer", "onMetadata");
    AppMethodBeat.o(139959);
  }
  
  public final void b(String paramString, long paramLong1, long paramLong2)
  {
    AppMethodBeat.i(139963);
    ab.i("MicroMsg.SameLayer.ExoMediaPlayer", "onVideoDecoderInitialized");
    AppMethodBeat.o(139963);
  }
  
  public final void c(int paramInt, long paramLong1, long paramLong2)
  {
    AppMethodBeat.i(139957);
    ab.i("MicroMsg.SameLayer.ExoMediaPlayer", "onAudioTrackUnderrun");
    AppMethodBeat.o(139957);
  }
  
  public final void c(Surface paramSurface)
  {
    AppMethodBeat.i(139966);
    ab.i("MicroMsg.SameLayer.ExoMediaPlayer", "onRenderedFirstFrame");
    AppMethodBeat.o(139966);
  }
  
  public final void c(Format paramFormat)
  {
    AppMethodBeat.i(139964);
    ab.i("MicroMsg.SameLayer.ExoMediaPlayer", "onVideoInputFormatChanged");
    AppMethodBeat.o(139964);
  }
  
  public final void c(d paramd)
  {
    AppMethodBeat.i(139953);
    ab.i("MicroMsg.SameLayer.ExoMediaPlayer", "onAudioEnabled");
    AppMethodBeat.o(139953);
  }
  
  public final void c(String paramString, long paramLong1, long paramLong2)
  {
    AppMethodBeat.i(139955);
    ab.i("MicroMsg.SameLayer.ExoMediaPlayer", "onAudioDecoderInitialized");
    AppMethodBeat.o(139955);
  }
  
  public final void cX(int paramInt)
  {
    AppMethodBeat.i(139954);
    ab.i("MicroMsg.SameLayer.ExoMediaPlayer", "onAudioSessionId");
    AppMethodBeat.o(139954);
  }
  
  public final void d(Format paramFormat)
  {
    AppMethodBeat.i(139956);
    ab.i("MicroMsg.SameLayer.ExoMediaPlayer", "onAudioInputFormatChanged");
    AppMethodBeat.o(139956);
  }
  
  public final void d(d paramd)
  {
    AppMethodBeat.i(139958);
    ab.i("MicroMsg.SameLayer.ExoMediaPlayer", "onAudioDisabled");
    AppMethodBeat.o(139958);
  }
  
  public final void h(int paramInt, long paramLong)
  {
    AppMethodBeat.i(139965);
    ab.i("MicroMsg.SameLayer.ExoMediaPlayer", "onDroppedFrames");
    AppMethodBeat.o(139965);
  }
  
  public final void r(List<a> paramList)
  {
    AppMethodBeat.i(139960);
    ab.i("MicroMsg.SameLayer.ExoMediaPlayer", "onCues");
    AppMethodBeat.o(139960);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.luggage.xweb_ext.extendplugin.component.video.b.a.b.d
 * JD-Core Version:    0.7.0.1
 */