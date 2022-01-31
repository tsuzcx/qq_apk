package com.tencent.mm.plugin.appbrand.jsapi.storage;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.i;
import com.tencent.mm.plugin.appbrand.ipc.AppBrandMainProcessService;
import com.tencent.mm.plugin.appbrand.jsapi.a;
import com.tencent.mm.plugin.appbrand.jsapi.h;
import com.tencent.mm.sdk.g.d;

public class n
  extends a<h>
{
  public static final int CTRL_INDEX = 16;
  public static final String NAME = "setStorage";
  private n.a iaD;
  
  public n()
  {
    AppMethodBeat.i(102075);
    this.iaD = new n.1(this);
    AppMethodBeat.o(102075);
  }
  
  private void a(h paramh, int paramInt1, int paramInt2, String paramString1, String paramString2, String paramString3, String paramString4, n.a parama)
  {
    AppMethodBeat.i(102076);
    d.post(new n.2(this, paramh, paramInt2, paramString4, paramString1, paramString2, paramString3, parama, paramInt1, System.currentTimeMillis()), "JsApiSetStorage");
    AppMethodBeat.o(102076);
  }
  
  private void b(h paramh, int paramInt1, int paramInt2, String paramString1, String paramString2, String paramString3, String paramString4, n.a parama)
  {
    AppMethodBeat.i(102077);
    long l = System.currentTimeMillis();
    JsApiSetStorageTask localJsApiSetStorageTask = new JsApiSetStorageTask();
    localJsApiSetStorageTask.appId = paramString4;
    localJsApiSetStorageTask.ias = paramInt2;
    localJsApiSetStorageTask.E(paramString1, paramString2, paramString3);
    localJsApiSetStorageTask.hxp = new n.3(this, parama, localJsApiSetStorageTask, paramh, paramInt1, paramString1, paramString2, l);
    localJsApiSetStorageTask.aBj();
    AppBrandMainProcessService.a(localJsApiSetStorageTask);
    AppMethodBeat.o(102077);
  }
  
  protected String c(h paramh)
  {
    AppMethodBeat.i(102078);
    paramh = paramh.getRuntime().mAppId;
    AppMethodBeat.o(102078);
    return paramh;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.storage.n
 * JD-Core Version:    0.7.0.1
 */