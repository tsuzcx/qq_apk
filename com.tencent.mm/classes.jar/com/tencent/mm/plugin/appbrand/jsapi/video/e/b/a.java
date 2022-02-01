package com.tencent.mm.plugin.appbrand.jsapi.video.e.b;

import android.net.Uri;
import com.google.android.exoplayer2.h.g;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.io.FilterInputStream;
import java.io.InputStream;
import kotlin.Metadata;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/appbrand/jsapi/video/player/depend_exo/InferContentTypeInputStream;", "Ljava/io/FilterInputStream;", "dataSource", "Lcom/google/android/exoplayer2/upstream/DataSource;", "uri", "Landroid/net/Uri;", "realInputStream", "Ljava/io/InputStream;", "(Lcom/google/android/exoplayer2/upstream/DataSource;Landroid/net/Uri;Ljava/io/InputStream;)V", "Companion", "luggage-commons-jsapi-video-ext_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class a
  extends FilterInputStream
{
  public static final a.a sFB;
  
  static
  {
    AppMethodBeat.i(328844);
    sFB = new a.a((byte)0);
    AppMethodBeat.o(328844);
  }
  
  private a(g paramg, Uri paramUri, InputStream paramInputStream)
  {
    super(paramInputStream);
    AppMethodBeat.i(328828);
    AppMethodBeat.o(328828);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.video.e.b.a
 * JD-Core Version:    0.7.0.1
 */