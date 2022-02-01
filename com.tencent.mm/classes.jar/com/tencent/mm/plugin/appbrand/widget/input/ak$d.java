package com.tencent.mm.plugin.appbrand.widget.input;

import android.content.res.AssetManager;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.util.DisplayMetrics;
import com.tencent.matrix.trace.core.AppMethodBeat;

final class ak$d
  extends Resources
{
  ak$d(AssetManager paramAssetManager, DisplayMetrics paramDisplayMetrics, Configuration paramConfiguration)
  {
    super(paramAssetManager, paramDisplayMetrics, paramConfiguration);
  }
  
  public final String[] getStringArray(int paramInt)
  {
    AppMethodBeat.i(49918);
    if (2130903068 == paramInt)
    {
      AppMethodBeat.o(49918);
      return new String[0];
    }
    if (2130903069 == paramInt)
    {
      AppMethodBeat.o(49918);
      return new String[0];
    }
    String[] arrayOfString = super.getStringArray(paramInt);
    AppMethodBeat.o(49918);
    return arrayOfString;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.widget.input.ak.d
 * JD-Core Version:    0.7.0.1
 */