package com.tencent.mm.plugin.appbrand.jsapi.video.e;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.jsapi.video.b.e.h;
import com.tencent.mm.sdk.platformtools.Log;
import java.io.InputStream;
import kotlin.Metadata;
import kotlin.g.b.s;
import kotlin.k.k;
import kotlin.n.d;
import kotlin.n.n;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/appbrand/jsapi/video/player/ContainerFormatInferCommons;", "", "()V", "DATA_SPEC_LENGTH", "", "MAX_READ_LENGTH", "TAG", "", "isHls", "", "inputStream", "Ljava/io/InputStream;", "isHlsFallback", "url", "luggage-commons-jsapi-video-ext_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class b
{
  public static final b sEI;
  
  static
  {
    AppMethodBeat.i(328829);
    sEI = new b();
    AppMethodBeat.o(328829);
  }
  
  public static boolean R(InputStream paramInputStream)
  {
    AppMethodBeat.i(328816);
    s.u(paramInputStream, "inputStream");
    byte[] arrayOfByte = new byte[32768];
    int k = paramInputStream.read(arrayOfByte, 0, 1024);
    int i = 0;
    int j = 0;
    for (;;)
    {
      if (-1 == k) {
        break label227;
      }
      j += k;
      String str = new String(arrayOfByte, 0, j, d.UTF_8);
      if (i != 0) {
        break label224;
      }
      if (!n.U(str, "#EXTM3U", false))
      {
        Log.i("MicroMsg.AppBrand.ContainerFormatInferCommons", "isHls, magicChecked fail");
        AppMethodBeat.o(328816);
        return false;
      }
      i = 1;
      if ((n.i((CharSequence)str, (CharSequence)"#EXT-X-STREAM-INF:")) || (n.i((CharSequence)str, (CharSequence)"#EXT-X-TARGETDURATION:")) || (n.i((CharSequence)str, (CharSequence)"#EXT-X-MEDIA-SEQUENCE:")))
      {
        Log.i("MicroMsg.AppBrand.ContainerFormatInferCommons", s.X("isHls, infer done, hadReadLen: ", Integer.valueOf(j)));
        AppMethodBeat.o(328816);
        return true;
      }
      int m = k.qv(32768 - j, 1024);
      if (m <= 0) {
        break;
      }
      k = paramInputStream.read(arrayOfByte, j, m);
    }
    label224:
    label227:
    for (;;)
    {
      Log.i("MicroMsg.AppBrand.ContainerFormatInferCommons", "isHls, infer done, hadReadLen: " + j + ", curReadLen: " + k);
      AppMethodBeat.o(328816);
      return false;
      break;
    }
  }
  
  public static boolean aco(String paramString)
  {
    AppMethodBeat.i(328823);
    s.u(paramString, "url");
    boolean bool = h.acg(paramString);
    AppMethodBeat.o(328823);
    return bool;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.video.e.b
 * JD-Core Version:    0.7.0.1
 */