package com.google.android.exoplayer2.e;

import android.annotation.TargetApi;
import android.media.MediaCodecInfo.CodecCapabilities;
import android.media.MediaCodecInfo.CodecProfileLevel;
import android.media.MediaCodecInfo.VideoCapabilities;
import com.google.android.exoplayer2.i.x;
import com.tencent.matrix.trace.core.AppMethodBeat;

@TargetApi(16)
public final class a
{
  public final boolean aME;
  public final boolean aMF;
  public final MediaCodecInfo.CodecCapabilities aMG;
  public final boolean azz;
  public final String mimeType;
  public final String name;
  
  a(String paramString1, String paramString2, MediaCodecInfo.CodecCapabilities paramCodecCapabilities, boolean paramBoolean1, boolean paramBoolean2)
  {
    AppMethodBeat.i(95231);
    this.name = ((String)com.google.android.exoplayer2.i.a.checkNotNull(paramString1));
    this.mimeType = paramString2;
    this.aMG = paramCodecCapabilities;
    if ((!paramBoolean1) && (paramCodecCapabilities != null)) {
      if ((x.SDK_INT >= 19) && (paramCodecCapabilities.isFeatureSupported("adaptive-playback")))
      {
        i = 1;
        if (i == 0) {
          break label177;
        }
        paramBoolean1 = true;
        label70:
        this.aME = paramBoolean1;
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
        this.azz = paramBoolean1;
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
      this.aMF = paramBoolean1;
      AppMethodBeat.o(95231);
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
    AppMethodBeat.i(95230);
    paramString1 = new a(paramString1, paramString2, paramCodecCapabilities, paramBoolean1, paramBoolean2);
    AppMethodBeat.o(95230);
    return paramString1;
  }
  
  @TargetApi(21)
  private static boolean a(MediaCodecInfo.VideoCapabilities paramVideoCapabilities, int paramInt1, int paramInt2, double paramDouble)
  {
    AppMethodBeat.i(95234);
    if ((paramDouble == -1.0D) || (paramDouble <= 0.0D))
    {
      bool = paramVideoCapabilities.isSizeSupported(paramInt1, paramInt2);
      AppMethodBeat.o(95234);
      return bool;
    }
    boolean bool = paramVideoCapabilities.areSizeAndRateSupported(paramInt1, paramInt2, paramDouble);
    AppMethodBeat.o(95234);
    return bool;
  }
  
  @TargetApi(21)
  public final boolean a(int paramInt1, int paramInt2, double paramDouble)
  {
    AppMethodBeat.i(95232);
    if (this.aMG == null)
    {
      aq("sizeAndRate.caps");
      AppMethodBeat.o(95232);
      return false;
    }
    Object localObject = this.aMG.getVideoCapabilities();
    if (localObject == null)
    {
      aq("sizeAndRate.vCaps");
      AppMethodBeat.o(95232);
      return false;
    }
    if (!a((MediaCodecInfo.VideoCapabilities)localObject, paramInt1, paramInt2, paramDouble))
    {
      if ((paramInt1 >= paramInt2) || (!a((MediaCodecInfo.VideoCapabilities)localObject, paramInt2, paramInt1, paramDouble)))
      {
        aq("sizeAndRate.support, " + paramInt1 + "x" + paramInt2 + "x" + paramDouble);
        AppMethodBeat.o(95232);
        return false;
      }
      localObject = "sizeAndRate.rotated, " + paramInt1 + "x" + paramInt2 + "x" + paramDouble;
      new StringBuilder("AssumedSupport [").append((String)localObject).append("] [").append(this.name).append(", ").append(this.mimeType).append("] [").append(x.bbt).append("]");
    }
    AppMethodBeat.o(95232);
    return true;
  }
  
  public final void aq(String paramString)
  {
    AppMethodBeat.i(95233);
    new StringBuilder("NoSupport [").append(paramString).append("] [").append(this.name).append(", ").append(this.mimeType).append("] [").append(x.bbt).append("]");
    AppMethodBeat.o(95233);
  }
  
  public final MediaCodecInfo.CodecProfileLevel[] oB()
  {
    if ((this.aMG == null) || (this.aMG.profileLevels == null)) {
      return new MediaCodecInfo.CodecProfileLevel[0];
    }
    return this.aMG.profileLevels;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.google.android.exoplayer2.e.a
 * JD-Core Version:    0.7.0.1
 */