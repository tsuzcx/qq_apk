package com.tencent.mm.plugin.appbrand.jsapi;

import android.os.Bundle;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.i.c;
import com.tencent.mm.i.g.a;
import com.tencent.mm.ipcinvoker.b;
import com.tencent.mm.plugin.appbrand.AppBrandRuntime;
import com.tencent.mm.plugin.appbrand.appstorage.p;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.vfs.e;
import java.io.ByteArrayOutputStream;
import java.nio.ByteBuffer;

public final class ch
  extends a<com.tencent.mm.plugin.appbrand.q>
{
  public static final int CTRL_INDEX = -2;
  public static final String NAME = "uploadToCommonCDN";
  
  private static String c(com.tencent.mm.plugin.appbrand.q paramq, String paramString)
  {
    AppMethodBeat.i(45705);
    paramq = paramq.getRuntime().Fg().Mj(paramString);
    if (paramq == null)
    {
      AppMethodBeat.o(45705);
      return "";
    }
    paramq = com.tencent.mm.vfs.q.B(paramq.fOK());
    AppMethodBeat.o(45705);
    return paramq;
  }
  
  private static ByteBuffer ct(Object paramObject)
  {
    AppMethodBeat.i(188275);
    if ((paramObject instanceof String)) {
      paramObject = ByteBuffer.wrap(((String)paramObject).getBytes());
    }
    for (;;)
    {
      AppMethodBeat.o(188275);
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.ch
 * JD-Core Version:    0.7.0.1
 */