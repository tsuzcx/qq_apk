package com.google.android.exoplayer2.e;

import android.annotation.TargetApi;
import android.media.MediaCodecInfo;
import android.media.MediaCodecInfo.CodecCapabilities;
import android.media.MediaCodecList;
import com.tencent.matrix.trace.core.AppMethodBeat;

@TargetApi(21)
final class d$e
  implements d.c
{
  private final int aNB;
  private MediaCodecInfo[] aNC;
  
  public d$e(boolean paramBoolean)
  {
    AppMethodBeat.i(95244);
    if (paramBoolean) {}
    for (int i = 1;; i = 0)
    {
      this.aNB = i;
      AppMethodBeat.o(95244);
      return;
    }
  }
  
  private void oK()
  {
    AppMethodBeat.i(95248);
    if (this.aNC == null) {
      this.aNC = new MediaCodecList(this.aNB).getCodecInfos();
    }
    AppMethodBeat.o(95248);
  }
  
  public final boolean a(String paramString, MediaCodecInfo.CodecCapabilities paramCodecCapabilities)
  {
    AppMethodBeat.i(95247);
    boolean bool = paramCodecCapabilities.isFeatureSupported("secure-playback");
    AppMethodBeat.o(95247);
    return bool;
  }
  
  public final int getCodecCount()
  {
    AppMethodBeat.i(95245);
    oK();
    int i = this.aNC.length;
    AppMethodBeat.o(95245);
    return i;
  }
  
  public final MediaCodecInfo getCodecInfoAt(int paramInt)
  {
    AppMethodBeat.i(95246);
    oK();
    MediaCodecInfo localMediaCodecInfo = this.aNC[paramInt];
    AppMethodBeat.o(95246);
    return localMediaCodecInfo;
  }
  
  public final boolean oJ()
  {
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.google.android.exoplayer2.e.d.e
 * JD-Core Version:    0.7.0.1
 */