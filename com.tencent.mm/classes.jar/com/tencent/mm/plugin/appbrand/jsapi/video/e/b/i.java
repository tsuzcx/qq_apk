package com.tencent.mm.plugin.appbrand.jsapi.video.e.b;

import android.net.Uri;
import com.google.android.exoplayer2.h.g;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.io.InputStream;
import kotlin.g.b.p;
import kotlin.l;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/appbrand/jsapi/video/player/exo/InferContentTypeInputStream;", "Ljava/io/InputStream;", "dataSource", "Lcom/google/android/exoplayer2/upstream/DataSource;", "uri", "Landroid/net/Uri;", "(Lcom/google/android/exoplayer2/upstream/DataSource;Landroid/net/Uri;)V", "realInputStream", "close", "", "read", "", "b", "", "off", "len", "Companion", "luggage-commons-jsapi-video-ext_release"})
public final class i
  extends InputStream
{
  public static final i.a pBD;
  private final InputStream pBC;
  
  static
  {
    AppMethodBeat.i(227703);
    pBD = new i.a((byte)0);
    AppMethodBeat.o(227703);
  }
  
  public i(g paramg, Uri paramUri)
  {
    AppMethodBeat.i(227702);
    String str = paramUri.getScheme();
    int i;
    if ((p.h("http", str)) || (p.h("https", str)))
    {
      i = 1;
      if (i == 0) {
        break label82;
      }
    }
    label82:
    for (paramg = (InputStream)new j(paramg, paramUri);; paramg = (InputStream)new com.google.android.exoplayer2.h.i(paramg, new com.google.android.exoplayer2.h.j(paramUri)))
    {
      this.pBC = paramg;
      AppMethodBeat.o(227702);
      return;
      i = 0;
      break;
    }
  }
  
  public final void close()
  {
    AppMethodBeat.i(227701);
    this.pBC.close();
    AppMethodBeat.o(227701);
  }
  
  public final int read()
  {
    AppMethodBeat.i(227696);
    int i = this.pBC.read();
    AppMethodBeat.o(227696);
    return i;
  }
  
  public final int read(byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(227698);
    int i = this.pBC.read(paramArrayOfByte);
    AppMethodBeat.o(227698);
    return i;
  }
  
  public final int read(byte[] paramArrayOfByte, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(227700);
    paramInt1 = this.pBC.read(paramArrayOfByte, paramInt1, paramInt2);
    AppMethodBeat.o(227700);
    return paramInt1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.video.e.b.i
 * JD-Core Version:    0.7.0.1
 */