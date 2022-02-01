package com.tencent.mm.plugin.appbrand.jsapi;

import android.os.Bundle;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.g.a;
import com.tencent.mm.ipcinvoker.f;
import com.tencent.mm.plugin.appbrand.AppBrandRuntime;
import com.tencent.mm.plugin.appbrand.appstorage.w;
import com.tencent.mm.plugin.appbrand.y;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.vfs.ah;
import com.tencent.mm.vfs.u;
import java.io.ByteArrayOutputStream;
import java.nio.ByteBuffer;

public final class de
  extends c<y>
{
  public static final int CTRL_INDEX = -2;
  public static final String NAME = "uploadToCommonCDN";
  
  private static String c(y paramy, String paramString)
  {
    AppMethodBeat.i(45705);
    paramy = paramy.getRuntime().getFileSystem().Wm(paramString);
    if (paramy == null)
    {
      AppMethodBeat.o(45705);
      return "";
    }
    paramy = ah.v(paramy.jKT());
    AppMethodBeat.o(45705);
    return paramy;
  }
  
  private static ByteBuffer dX(Object paramObject)
  {
    AppMethodBeat.i(325497);
    if ((paramObject instanceof String)) {
      paramObject = ByteBuffer.wrap(((String)paramObject).getBytes());
    }
    for (;;)
    {
      AppMethodBeat.o(325497);
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
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.de
 * JD-Core Version:    0.7.0.1
 */