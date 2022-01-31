package com.tencent.mm.plugin.appbrand.jsapi.media;

import com.tencent.mm.platformtools.q;
import com.tencent.mm.sdk.platformtools.ai;
import com.tencent.mm.sdk.platformtools.bk;

public final class f
  extends a
{
  public static final int CTRL_INDEX = 216;
  public static final String NAME = "saveVideoToPhotosAlbum";
  
  final boolean ui(String paramString)
  {
    return bk.pm(paramString).toLowerCase().contains("video");
  }
  
  final String uj(String paramString)
  {
    return q.pd("mp4");
  }
  
  final void uk(String paramString)
  {
    ai.d(new f.1(this, paramString));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.media.f
 * JD-Core Version:    0.7.0.1
 */