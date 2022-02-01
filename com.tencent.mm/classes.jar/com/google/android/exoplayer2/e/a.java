package com.google.android.exoplayer2.e;

import android.media.MediaCodecInfo.CodecCapabilities;
import android.media.MediaCodecInfo.CodecProfileLevel;
import android.media.MediaCodecInfo.VideoCapabilities;
import com.google.android.exoplayer2.i.x;
import com.tencent.matrix.trace.core.AppMethodBeat;

public final class a
{
  public final boolean cJt;
  public final boolean cWv;
  public final boolean cWw;
  public final MediaCodecInfo.CodecCapabilities cWx;
  public final String mimeType;
  public final String name;
  
  a(String paramString1, String paramString2, MediaCodecInfo.CodecCapabilities paramCodecCapabilities, boolean paramBoolean1, boolean paramBoolean2)
  {
    AppMethodBeat.i(92353);
    this.name = ((String)com.google.android.exoplayer2.i.a.checkNotNull(paramString1));
    this.mimeType = paramString2;
    this.cWx = paramCodecCapabilities;
    if ((!paramBoolean1) && (paramCodecCapabilities != null)) {
      if ((x.SDK_INT >= 19) && (paramCodecCapabilities.isFeatureSupported("adaptive-playback")))
      {
        i = 1;
        if (i == 0) {
          break label177;
        }
        paramBoolean1 = true;
        label70:
        this.cWv = paramBoolean1;
        if (paramCodecCapabilities == null) {
          break label189;
        }
        if ((x.SDK_INT < 21) || (!paramCodecCapabilities.isFeatureSupported("tunneled-playback"))) {
          break label183;
        }
        i = 1;
        label100:
        if (i == 0) {
          break label189;
        }
        paramBoolean1 = true;
        label108:
        this.cJt = paramBoolean1;
        if (!paramBoolean2)
        {
          paramBoolean1 = bool;
          if (paramCodecCapabilities == null) {
            break label159;
          }
          if ((x.SDK_INT < 21) || (!paramCodecCapabilities.isFeatureSupported("secure-playback"))) {
            break label195;
          }
        }
      }
    }
    label159:
    label177:
    label183:
    label189:
    label195:
    for (int i = 1;; i = 0)
    {
      paramBoolean1 = bool;
      if (i != 0) {
        paramBoolean1 = true;
      }
      this.cWw = paramBoolean1;
      AppMethodBeat.o(92353);
      return;
      i = 0;
      break;
      paramBoolean1 = false;
      break label70;
      i = 0;
      break label100;
      paramBoolean1 = false;
      break label108;
    }
  }
  
  public static a a(String paramString1, String paramString2, MediaCodecInfo.CodecCapabilities paramCodecCapabilities, boolean paramBoolean1, boolean paramBoolean2)
  {
    AppMethodBeat.i(92352);
    paramString1 = new a(paramString1, paramString2, paramCodecCapabilities, paramBoolean1, paramBoolean2);
    AppMethodBeat.o(92352);
    return paramString1;
  }
  
  private static boolean a(MediaCodecInfo.VideoCapabilities paramVideoCapabilities, int paramInt1, int paramInt2, double paramDouble)
  {
    AppMethodBeat.i(92356);
    if ((paramDouble == -1.0D) || (paramDouble <= 0.0D))
    {
      bool = paramVideoCapabilities.isSizeSupported(paramInt1, paramInt2);
      AppMethodBeat.o(92356);
      return bool;
    }
    boolean bool = paramVideoCapabilities.areSizeAndRateSupported(paramInt1, paramInt2, paramDouble);
    AppMethodBeat.o(92356);
    return bool;
  }
  
  public final MediaCodecInfo.CodecProfileLevel[] Sy()
  {
    if ((this.cWx == null) || (this.cWx.profileLevels == null)) {
      return new MediaCodecInfo.CodecProfileLevel[0];
    }
    return this.cWx.profileLevels;
  }
  
  public final boolean a(int paramInt1, int paramInt2, double paramDouble)
  {
    AppMethodBeat.i(92354);
    if (this.cWx == null)
    {
      cK("sizeAndRate.caps");
      AppMethodBeat.o(92354);
      return false;
    }
    Object localObject = this.cWx.getVideoCapabilities();
    if (localObject == null)
    {
      cK("sizeAndRate.vCaps");
      AppMethodBeat.o(92354);
      return false;
    }
    if (!a((MediaCodecInfo.VideoCapabilities)localObject, paramInt1, paramInt2, paramDouble))
    {
      if ((paramInt1 >= paramInt2) || (!a((MediaCodecInfo.VideoCapabilities)localObject, paramInt2, paramInt1, paramDouble)))
      {
        cK("sizeAndRate.support, " + paramInt1 + "x" + paramInt2 + "x" + paramDouble);
        AppMethodBeat.o(92354);
        return false;
      }
      localObject = "sizeAndRate.rotated, " + paramInt1 + "x" + paramInt2 + "x" + paramDouble;
      new StringBuilder("AssumedSupport [").append((String)localObject).append("] [").append(this.name).append(", ").append(this.mimeType).append("] [").append(x.dkT).append("]");
    }
    AppMethodBeat.o(92354);
    return true;
  }
  
  public final void cK(String paramString)
  {
    AppMethodBeat.i(92355);
    new StringBuilder("NoSupport [").append(paramString).append("] [").append(this.name).append(", ").append(this.mimeType).append("] [").append(x.dkT).append("]");
    AppMethodBeat.o(92355);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.google.android.exoplayer2.e.a
 * JD-Core Version:    0.7.0.1
 */