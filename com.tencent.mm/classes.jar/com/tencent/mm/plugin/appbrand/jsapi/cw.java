package com.tencent.mm.plugin.appbrand.jsapi;

import android.os.Bundle;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.i.g.a;
import com.tencent.mm.ipcinvoker.f;
import com.tencent.mm.plugin.appbrand.AppBrandRuntime;
import com.tencent.mm.plugin.appbrand.appstorage.r;
import com.tencent.mm.plugin.appbrand.v;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.vfs.q;
import java.io.ByteArrayOutputStream;
import java.nio.ByteBuffer;

public final class cw
  extends c<v>
{
  public static final int CTRL_INDEX = -2;
  public static final String NAME = "uploadToCommonCDN";
  
  private static String c(v paramv, String paramString)
  {
    AppMethodBeat.i(45705);
    paramv = paramv.getRuntime().getFileSystem().adL(paramString);
    if (paramv == null)
    {
      AppMethodBeat.o(45705);
      return "";
    }
    paramv = paramv.bOF();
    AppMethodBeat.o(45705);
    return paramv;
  }
  
  private static ByteBuffer cD(Object paramObject)
  {
    AppMethodBeat.i(273491);
    if ((paramObject instanceof String)) {
      paramObject = ByteBuffer.wrap(((String)paramObject).getBytes());
    }
    for (;;)
    {
      AppMethodBeat.o(273491);
      return paramObject;
      if ((paramObject instanceof ByteBuffer)) {
        paramObject = (ByteBuffer)paramObject;
      } else {
        paramObject = null;
      }
    }
  }
  
  static final class a
    implements com.tencent.mm.ipcinvoker.d<Bundle, Bundle>
  {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.cw
 * JD-Core Version:    0.7.0.1
 */