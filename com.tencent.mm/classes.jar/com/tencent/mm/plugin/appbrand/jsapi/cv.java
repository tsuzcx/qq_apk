package com.tencent.mm.plugin.appbrand.jsapi;

import android.os.Bundle;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.i.c;
import com.tencent.mm.i.g.a;
import com.tencent.mm.ipcinvoker.b;
import com.tencent.mm.plugin.appbrand.AppBrandRuntime;
import com.tencent.mm.plugin.appbrand.appstorage.q;
import com.tencent.mm.plugin.appbrand.s;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.vfs.aa;
import com.tencent.mm.vfs.o;
import java.io.ByteArrayOutputStream;
import java.nio.ByteBuffer;

public final class cv
  extends d<s>
{
  public static final int CTRL_INDEX = -2;
  public static final String NAME = "uploadToCommonCDN";
  
  private static String c(s params, String paramString)
  {
    AppMethodBeat.i(45705);
    params = params.getRuntime().getFileSystem().VY(paramString);
    if (params == null)
    {
      AppMethodBeat.o(45705);
      return "";
    }
    params = aa.z(params.her());
    AppMethodBeat.o(45705);
    return params;
  }
  
  private static ByteBuffer cD(Object paramObject)
  {
    AppMethodBeat.i(226684);
    if ((paramObject instanceof String)) {
      paramObject = ByteBuffer.wrap(((String)paramObject).getBytes());
    }
    for (;;)
    {
      AppMethodBeat.o(226684);
      return paramObject;
      if ((paramObject instanceof ByteBuffer)) {
        paramObject = (ByteBuffer)paramObject;
      } else {
        paramObject = null;
      }
    }
  }
  
  static final class a
    implements b<Bundle, Bundle>
  {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.cv
 * JD-Core Version:    0.7.0.1
 */