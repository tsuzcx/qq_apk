package com.tencent.mm.plugin.appbrand.jsapi.camera;

import com.tencent.mm.sdk.platformtools.y;
import java.util.HashMap;

public final class a
{
  boolean gon = true;
  boolean goo = true;
  HashMap<Integer, d> goq = new HashMap();
  
  public final boolean aiC()
  {
    if (!this.gon) {
      y.i("MicroMsg.AppBrandCameraMrg", "no camera permission");
    }
    return this.gon;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.camera.a
 * JD-Core Version:    0.7.0.1
 */