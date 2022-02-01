package com.github.henryye.nativeiv;

import android.graphics.Bitmap.Config;
import android.support.annotation.Keep;
import com.tencent.matrix.trace.core.AppMethodBeat;

@Keep
public class ImageDecodeConfig
{
  @Keep
  public Bitmap.Config mConfig = Bitmap.Config.ARGB_8888;
  @Keep
  public boolean mPremultiplyAlpha = true;
  @Keep
  public ReferrerPolicy mReferrerPolicy = ReferrerPolicy.NOT_SET;
  
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
  public static Object createConfig(int paramInt1, boolean paramBoolean, int paramInt2)
  {
    AppMethodBeat.i(191262);
    ImageDecodeConfig localImageDecodeConfig = new ImageDecodeConfig();
    localImageDecodeConfig.mPremultiplyAlpha = paramBoolean;
    if (paramInt1 == 8)
    {
      localImageDecodeConfig.mConfig = Bitmap.Config.ALPHA_8;
      if (paramInt2 != 0) {
        break label90;
      }
      localImageDecodeConfig.mReferrerPolicy = ReferrerPolicy.NOT_SET;
    }
    for (;;)
    {
      AppMethodBeat.o(191262);
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
      label90:
      if (paramInt2 == 1) {
        localImageDecodeConfig.mReferrerPolicy = ReferrerPolicy.NO_REFERRER;
      } else if (paramInt2 == 2) {
        localImageDecodeConfig.mReferrerPolicy = ReferrerPolicy.ORIGIN;
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
    AppMethodBeat.i(191261);
    switch (1.aQl[this.mReferrerPolicy.ordinal()])
    {
    default: 
      AppMethodBeat.o(191261);
      return 0;
    case 1: 
      AppMethodBeat.o(191261);
      return 1;
    }
    AppMethodBeat.o(191261);
    return 2;
  }
  
  @Keep
  public static enum ReferrerPolicy
  {
    static
    {
      AppMethodBeat.i(191260);
      NOT_SET = new ReferrerPolicy("NOT_SET", 0);
      NO_REFERRER = new ReferrerPolicy("NO_REFERRER", 1);
      ORIGIN = new ReferrerPolicy("ORIGIN", 2);
      $VALUES = new ReferrerPolicy[] { NOT_SET, NO_REFERRER, ORIGIN };
      AppMethodBeat.o(191260);
    }
    
    private ReferrerPolicy() {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.github.henryye.nativeiv.ImageDecodeConfig
 * JD-Core Version:    0.7.0.1
 */