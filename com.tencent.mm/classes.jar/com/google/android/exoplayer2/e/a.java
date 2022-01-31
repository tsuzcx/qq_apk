package com.google.android.exoplayer2.e;

import android.annotation.TargetApi;
import android.media.MediaCodecInfo.CodecCapabilities;
import android.media.MediaCodecInfo.CodecProfileLevel;
import android.media.MediaCodecInfo.VideoCapabilities;
import com.google.android.exoplayer2.i.t;

@TargetApi(16)
public final class a
{
  public final boolean aFJ;
  public final boolean aFK;
  public final MediaCodecInfo.CodecCapabilities aFL;
  public final boolean axj;
  public final String mimeType;
  public final String name;
  
  a(String paramString1, String paramString2, MediaCodecInfo.CodecCapabilities paramCodecCapabilities, boolean paramBoolean1, boolean paramBoolean2)
  {
    this.name = ((String)com.google.android.exoplayer2.i.a.E(paramString1));
    this.mimeType = paramString2;
    this.aFL = paramCodecCapabilities;
    if ((!paramBoolean1) && (paramCodecCapabilities != null)) {
      if ((t.SDK_INT >= 19) && (paramCodecCapabilities.isFeatureSupported("adaptive-playback")))
      {
        i = 1;
        if (i == 0) {
          break label167;
        }
        paramBoolean1 = true;
        label65:
        this.aFJ = paramBoolean1;
        if (paramCodecCapabilities == null) {
          break label179;
        }
        if ((t.SDK_INT < 21) || (!paramCodecCapabilities.isFeatureSupported("tunneled-playback"))) {
          break label173;
        }
        i = 1;
        label95:
        if (i == 0) {
          break label179;
        }
        paramBoolean1 = true;
        label103:
        this.axj = paramBoolean1;
        if (!paramBoolean2)
        {
          paramBoolean1 = bool;
          if (paramCodecCapabilities == null) {
            break label154;
          }
          if ((t.SDK_INT < 21) || (!paramCodecCapabilities.isFeatureSupported("secure-playback"))) {
            break label185;
          }
        }
      }
    }
    label154:
    label167:
    label173:
    label179:
    label185:
    for (int i = 1;; i = 0)
    {
      paramBoolean1 = bool;
      if (i != 0) {
        paramBoolean1 = true;
      }
      this.aFK = paramBoolean1;
      return;
      i = 0;
      break;
      paramBoolean1 = false;
      break label65;
      i = 0;
      break label95;
      paramBoolean1 = false;
      break label103;
    }
  }
  
  public static a a(String paramString1, String paramString2, MediaCodecInfo.CodecCapabilities paramCodecCapabilities, boolean paramBoolean1, boolean paramBoolean2)
  {
    return new a(paramString1, paramString2, paramCodecCapabilities, paramBoolean1, paramBoolean2);
  }
  
  @TargetApi(21)
  private static boolean a(MediaCodecInfo.VideoCapabilities paramVideoCapabilities, int paramInt1, int paramInt2, double paramDouble)
  {
    if ((paramDouble == -1.0D) || (paramDouble <= 0.0D)) {
      return paramVideoCapabilities.isSizeSupported(paramInt1, paramInt2);
    }
    return paramVideoCapabilities.areSizeAndRateSupported(paramInt1, paramInt2, paramDouble);
  }
  
  @TargetApi(21)
  public final boolean a(int paramInt1, int paramInt2, double paramDouble)
  {
    if (this.aFL == null)
    {
      al("sizeAndRate.caps");
      return false;
    }
    Object localObject = this.aFL.getVideoCapabilities();
    if (localObject == null)
    {
      al("sizeAndRate.vCaps");
      return false;
    }
    if (!a((MediaCodecInfo.VideoCapabilities)localObject, paramInt1, paramInt2, paramDouble))
    {
      if ((paramInt1 >= paramInt2) || (!a((MediaCodecInfo.VideoCapabilities)localObject, paramInt2, paramInt1, paramDouble)))
      {
        al("sizeAndRate.support, " + paramInt1 + "x" + paramInt2 + "x" + paramDouble);
        return false;
      }
      localObject = "sizeAndRate.rotated, " + paramInt1 + "x" + paramInt2 + "x" + paramDouble;
      new StringBuilder("AssumedSupport [").append((String)localObject).append("] [").append(this.name).append(", ").append(this.mimeType).append("] [").append(t.aSS).append("]");
    }
    return true;
  }
  
  public final void al(String paramString)
  {
    new StringBuilder("NoSupport [").append(paramString).append("] [").append(this.name).append(", ").append(this.mimeType).append("] [").append(t.aSS).append("]");
  }
  
  public final MediaCodecInfo.CodecProfileLevel[] mk()
  {
    if ((this.aFL == null) || (this.aFL.profileLevels == null)) {
      return new MediaCodecInfo.CodecProfileLevel[0];
    }
    return this.aFL.profileLevels;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.google.android.exoplayer2.e.a
 * JD-Core Version:    0.7.0.1
 */