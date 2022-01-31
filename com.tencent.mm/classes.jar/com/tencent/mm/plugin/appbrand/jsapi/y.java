package com.tencent.mm.plugin.appbrand.jsapi;

import android.graphics.Bitmap;
import com.tencent.mm.plugin.appbrand.i;
import com.tencent.mm.plugin.appbrand.o;
import com.tencent.mm.plugin.appbrand.page.n;
import com.tencent.mm.plugin.appbrand.page.q;
import com.tencent.mm.sdk.platformtools.c;

public class y
  extends a<o>
{
  public static final int CTRL_INDEX = 250;
  public static final String NAME = "captureScreen";
  
  public Bitmap a(o paramo)
  {
    com.tencent.mm.sdk.platformtools.y.i("MicroMsg.JsApiCaptureScreen", "isGame:%b", new Object[] { Boolean.valueOf(paramo.getRuntime().ZH()) });
    return c.dz(paramo.getRuntime().Zz().getPageView().aha());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.y
 * JD-Core Version:    0.7.0.1
 */