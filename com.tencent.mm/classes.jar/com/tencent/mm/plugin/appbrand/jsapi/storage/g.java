package com.tencent.mm.plugin.appbrand.jsapi.storage;

import com.tencent.luggage.a.e;
import com.tencent.luggage.sdk.customize.a;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.appstorage.v;
import com.tencent.mm.plugin.appbrand.jsapi.c;
import com.tencent.mm.plugin.appbrand.jsapi.f;
import com.tencent.mm.plugin.appbrand.jsapi.k;
import java.lang.ref.WeakReference;
import java.util.List;

public class g
  extends c<k>
{
  public static final int CTRL_INDEX = 113;
  public static final String NAME = "getStorageInfo";
  
  protected String H(f paramf)
  {
    AppMethodBeat.i(147248);
    paramf = paramf.getAppId();
    AppMethodBeat.o(147248);
    return paramf;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes11.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.storage.g
 * JD-Core Version:    0.7.0.1
 */