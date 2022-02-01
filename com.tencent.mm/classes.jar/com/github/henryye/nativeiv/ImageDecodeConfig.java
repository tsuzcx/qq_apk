package com.github.henryye.nativeiv;

import android.graphics.Bitmap.Config;
import androidx.annotation.Keep;
import com.tencent.matrix.trace.core.AppMethodBeat;

@Keep
public class ImageDecodeConfig
{
  @Keep
  public Bitmap.Config mConfig = Bitmap.Config.ARGB_8888;
  @Keep
  public int mPreferredHeight = 0;
  @Keep
  public double mPreferredScale = 0.0D;
  @Keep
  public int mPreferredWidth = 0;
  @Keep
  public boolean mPremultiplyAlpha = true;
  @Keep
  public ImageDecodeConfig.ReferrerPolicy mReferrerPolicy = ImageDecodeConfig.ReferrerPolicy.NOT_SET;
  
  @Keep
  public static ImageDecodeConfig createConfig(Bitmap.Config paramConfig, boolean paramBoolean)
  {
    AppMethodBeat.i(127341);
    ImageDecodeConfig localImageDecodeConfig = new ImageDecodeConfig();
    localImageDecodeConfig.mPremultiplyAlpha = paramBoolean;
    localImageDecodeConfig.mConfig = paramConfig;
    AppMethodBeat.o(127341);
    return localImageDecodeConfig;
  }
  
  @Keep
  public static Object createConfig(int paramInt1, boolean paramBoolean, int paramInt2, int paramInt3, int paramInt4, double paramDouble)
  {
    AppMethodBeat.i(219719);
    ImageDecodeConfig localImageDecodeConfig = new ImageDecodeConfig();
    localImageDecodeConfig.mPremultiplyAlpha = paramBoolean;
    if (paramInt1 == 8)
    {
      localImageDecodeConfig.mConfig = Bitmap.Config.ALPHA_8;
      if (paramInt2 != 0) {
        break label118;
      }
      localImageDecodeConfig.mReferrerPolicy = ImageDecodeConfig.ReferrerPolicy.NOT_SET;
    }
    for (;;)
    {
      localImageDecodeConfig.mPreferredWidth = paramInt3;
      localImageDecodeConfig.mPreferredHeight = paramInt4;
      localImageDecodeConfig.mPreferredScale = paramDouble;
      AppMethodBeat.o(219719);
      return localImageDecodeConfig;
      if (paramInt1 == 4)
      {
        localImageDecodeConfig.mConfig = Bitmap.Config.RGB_565;
        break;
      }
      if (paramInt1 == 7)
      {
        localImageDecodeConfig.mConfig = Bitmap.Config.ARGB_4444;
        break;
      }
      localImageDecodeConfig.mConfig = Bitmap.Config.ARGB_8888;
      break;
      label118:
      if (paramInt2 == 1) {
        localImageDecodeConfig.mReferrerPolicy = ImageDecodeConfig.ReferrerPolicy.NO_REFERRER;
      } else if (paramInt2 == 2) {
        localImageDecodeConfig.mReferrerPolicy = ImageDecodeConfig.ReferrerPolicy.ORIGIN;
      }
    }
  }
  
  @Keep
  public int getNativeConfig()
  {
    AppMethodBeat.i(127340);
    switch (1.$SwitchMap$android$graphics$Bitmap$Config[this.mConfig.ordinal()])
    {
    default: 
      AppMethodBeat.o(127340);
      return 1;
    case 1: 
      AppMethodBeat.o(127340);
      return 1;
    case 2: 
      AppMethodBeat.o(127340);
      return 4;
    case 3: 
      AppMethodBeat.o(127340);
      return 7;
    }
    AppMethodBeat.o(127340);
    return 8;
  }
  
  @Keep
  public int getNativeReferrerPolicy()
  {
    AppMethodBeat.i(219712);
    switch (1.aJZ[this.mReferrerPolicy.ordinal()])
    {
    default: 
      AppMethodBeat.o(219712);
      return 0;
    case 1: 
      AppMethodBeat.o(219712);
      return 1;
    }
    AppMethodBeat.o(219712);
    return 2;
  }
  
  public String toString()
  {
    AppMethodBeat.i(219723);
    String str = "ImageDecodeConfig{mConfig=" + this.mConfig + ", mPremultiplyAlpha=" + this.mPremultiplyAlpha + ", mReferrerPolicy=" + this.mReferrerPolicy + ", mPreferredWidth=" + this.mPreferredWidth + ", mPreferredHeight=" + this.mPreferredHeight + ", mPreferredScale=" + this.mPreferredScale + '}';
    AppMethodBeat.o(219723);
    return str;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.github.henryye.nativeiv.ImageDecodeConfig
 * JD-Core Version:    0.7.0.1
 */