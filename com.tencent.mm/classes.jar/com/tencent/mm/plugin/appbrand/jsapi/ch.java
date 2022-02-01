package com.tencent.mm.plugin.appbrand.jsapi;

import android.os.Bundle;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.i.c;
import com.tencent.mm.i.g.a;
import com.tencent.mm.plugin.appbrand.AppBrandRuntime;
import com.tencent.mm.plugin.appbrand.appstorage.q;
import com.tencent.mm.plugin.appbrand.r;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.vfs.k;
import com.tencent.mm.vfs.w;
import java.io.ByteArrayOutputStream;
import java.nio.ByteBuffer;

public final class ch
  extends a<r>
{
  public static final int CTRL_INDEX = -2;
  public static final String NAME = "uploadToCommonCDN";
  
  private static String c(r paramr, String paramString)
  {
    AppMethodBeat.i(45705);
    paramr = paramr.getRuntime().Fl().MP(paramString);
    if (paramr == null)
    {
      AppMethodBeat.o(45705);
      return "";
    }
    paramr = w.B(paramr.fTh());
    AppMethodBeat.o(45705);
    return paramr;
  }
  
  private static ByteBuffer cu(Object paramObject)
  {
    AppMethodBeat.i(222401);
    if ((paramObject instanceof String)) {
      paramObject = ByteBuffer.wrap(((String)paramObject).getBytes());
    }
    for (;;)
    {
      AppMethodBeat.o(222401);
      return paramObject;
      if ((paramObject instanceof ByteBuffer)) {
        paramObject = (ByteBuffer)paramObject;
      } else {
        paramObject = null;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.ch
 * JD-Core Version:    0.7.0.1
 */