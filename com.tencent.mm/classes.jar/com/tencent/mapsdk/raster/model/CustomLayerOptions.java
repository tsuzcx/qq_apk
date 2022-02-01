package com.tencent.mapsdk.raster.model;

import android.text.TextUtils;
import com.tencent.matrix.trace.core.AppMethodBeat;

public class CustomLayerOptions
{
  private String mLayerId;
  private String mLayerVersion;
  
  public String getLayerId()
  {
    return this.mLayerId;
  }
  
  public CustomLayerOptions layerId(String paramString)
  {
    AppMethodBeat.i(181497);
    if (!TextUtils.isEmpty(paramString)) {
      this.mLayerId = paramString;
    }
    AppMethodBeat.o(181497);
    return this;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mapsdk.raster.model.CustomLayerOptions
 * JD-Core Version:    0.7.0.1
 */