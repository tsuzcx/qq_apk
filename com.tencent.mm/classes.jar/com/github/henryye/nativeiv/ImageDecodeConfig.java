package com.github.henryye.nativeiv;

import android.graphics.Bitmap.Config;
import com.tencent.matrix.trace.core.AppMethodBeat;

public class ImageDecodeConfig
{
  public Bitmap.Config mConfig = Bitmap.Config.ARGB_8888;
  public int mPreferredHeight = 0;
  public double mPreferredScale = 0.0D;
  public int mPreferredWidth = 0;
  public boolean mPremultiplyAlpha = true;
  public ReferrerPolicy mReferrerPolicy = ReferrerPolicy.NOT_SET;
  
  public static ImageDecodeConfig createConfig(Bitmap.Config paramConfig, boolean paramBoolean)
  {
    AppMethodBeat.i(127341);
    ImageDecodeConfig localImageDecodeConfig = new ImageDecodeConfig();
    localImageDecodeConfig.mPremultiplyAlpha = paramBoolean;
    localImageDecodeConfig.mConfig = paramConfig;
    AppMethodBeat.o(127341);
    return localImageDecodeConfig;
  }
  
  public static Object createConfig(int paramInt1, boolean paramBoolean, int paramInt2, int paramInt3, int paramInt4, double paramDouble)
  {
    AppMethodBeat.i(208236);
    ImageDecodeConfig localImageDecodeConfig = new ImageDecodeConfig();
    localImageDecodeConfig.mPremultiplyAlpha = paramBoolean;
    if (paramInt1 == 8)
    {
      localImageDecodeConfig.mConfig = Bitmap.Config.ALPHA_8;
      if (paramInt2 != 0) {
        break label118;
      }
      localImageDecodeConfig.mReferrerPolicy = ReferrerPolicy.NOT_SET;
    }
    for (;;)
    {
      localImageDecodeConfig.mPreferredWidth = paramInt3;
      localImageDecodeConfig.mPreferredHeight = paramInt4;
      localImageDecodeConfig.mPreferredScale = paramDouble;
      AppMethodBeat.o(208236);
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
        localImageDecodeConfig.mReferrerPolicy = ReferrerPolicy.NO_REFERRER;
      } else if (paramInt2 == 2) {
        localImageDecodeConfig.mReferrerPolicy = ReferrerPolicy.ORIGIN;
      }
    }
  }
  
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
  
  public int getNativeReferrerPolicy()
  {
    AppMethodBeat.i(208238);
    switch (1.cDV[this.mReferrerPolicy.ordinal()])
    {
    default: 
      AppMethodBeat.o(208238);
      return 0;
    case 1: 
      AppMethodBeat.o(208238);
      return 1;
    }
    AppMethodBeat.o(208238);
    return 2;
  }
  
  public String toString()
  {
    AppMethodBeat.i(208241);
    String str = "ImageDecodeConfig{mConfig=" + this.mConfig + ", mPremultiplyAlpha=" + this.mPremultiplyAlpha + ", mReferrerPolicy=" + this.mReferrerPolicy + ", mPreferredWidth=" + this.mPreferredWidth + ", mPreferredHeight=" + this.mPreferredHeight + ", mPreferredScale=" + this.mPreferredScale + '}';
    AppMethodBeat.o(208241);
    return str;
  }
  
  public static enum ReferrerPolicy
  {
    static
    {
      AppMethodBeat.i(208234);
      NOT_SET = new ReferrerPolicy("NOT_SET", 0);
      NO_REFERRER = new ReferrerPolicy("NO_REFERRER", 1);
      ORIGIN = new ReferrerPolicy("ORIGIN", 2);
      $VALUES = new ReferrerPolicy[] { NOT_SET, NO_REFERRER, ORIGIN };
      AppMethodBeat.o(208234);
    }
    
    private ReferrerPolicy() {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.github.henryye.nativeiv.ImageDecodeConfig
 * JD-Core Version:    0.7.0.1
 */