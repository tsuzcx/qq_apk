package com.tencent.mm.plugin.appbrand.jsapi.media;

import com.tencent.mm.platformtools.q;
import com.tencent.mm.sdk.platformtools.ai;
import com.tencent.mm.sdk.platformtools.bk;

public final class e
  extends a
{
  public static final int CTRL_INDEX = 217;
  public static final String NAME = "saveImageToPhotosAlbum";
  
  final boolean ui(String paramString)
  {
    return bk.pm(paramString).toLowerCase().contains("image");
  }
  
  final String uj(String paramString)
  {
    return q.pd(paramString);
  }
  
  final void uk(String paramString)
  {
    ai.d(new e.1(this));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.media.e
 * JD-Core Version:    0.7.0.1
 */