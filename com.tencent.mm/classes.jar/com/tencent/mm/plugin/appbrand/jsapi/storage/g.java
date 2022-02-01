package com.tencent.mm.plugin.appbrand.jsapi.storage;

import com.tencent.luggage.sdk.customize.a;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.jsapi.c;
import com.tencent.mm.plugin.appbrand.jsapi.j;
import java.lang.ref.WeakReference;
import java.util.List;

public class g
  extends c<j>
{
  public static final int CTRL_INDEX = 113;
  public static final String NAME = "getStorageInfo";
  
  protected String F(com.tencent.mm.plugin.appbrand.jsapi.e parame)
  {
    AppMethodBeat.i(147248);
    parame = parame.getAppId();
    AppMethodBeat.o(147248);
    return parame;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.storage.g
 * JD-Core Version:    0.7.0.1
 */