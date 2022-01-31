package com.tencent.mm.plugin.appbrand.jsapi;

import com.tencent.mm.sdk.platformtools.y;

public final class q
  extends l
{
  private static final int CTRL_INDEX = 248;
  private static final String NAME = "onUserCaptureScreen";
  private static q gfp = new q();
  
  public static void f(c paramc)
  {
    y.i("MicroMsg.AppBrandOnUserCaptureScreenEvent", "user capture screen event dispatch, appId:%s", new Object[] { paramc.getAppId() });
    gfp.d(paramc).dispatch();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.q
 * JD-Core Version:    0.7.0.1
 */