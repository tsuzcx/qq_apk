package com.tencent.mm.plugin.appbrand.widget.input;

import android.content.res.AssetManager;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.util.DisplayMetrics;
import com.tencent.mm.plugin.appbrand.y.b;

final class aj$d
  extends Resources
{
  aj$d(AssetManager paramAssetManager, DisplayMetrics paramDisplayMetrics, Configuration paramConfiguration)
  {
    super(paramAssetManager, paramDisplayMetrics, paramConfiguration);
  }
  
  public final String[] getStringArray(int paramInt)
  {
    if (y.b.merge_smiley_code_smiley == paramInt) {
      return new String[0];
    }
    if (y.b.merge_smiley_softbank_emoji == paramInt) {
      return new String[0];
    }
    return super.getStringArray(paramInt);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.widget.input.aj.d
 * JD-Core Version:    0.7.0.1
 */