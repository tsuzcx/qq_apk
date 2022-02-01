package com.tencent.mm.plugin.appbrand.ag.a;

import android.net.Uri;
import com.google.android.exoplayer2.h.g.a;
import com.google.android.exoplayer2.h.o;
import com.google.android.exoplayer2.h.s.f;
import com.google.android.exoplayer2.h.w;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import java.net.HttpURLConnection;
import java.net.URL;
import kotlin.Metadata;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/appbrand/video/depend_exo/FinalUrlAccessibleHttpDataSource;", "Lcom/google/android/exoplayer2/upstream/DefaultHttpDataSource;", "userAgent", "", "contentTypePredicate", "Lcom/google/android/exoplayer2/util/Predicate;", "listener", "Lcom/google/android/exoplayer2/upstream/TransferListener;", "connectTimeoutMillis", "", "readTimeoutMillis", "allowCrossProtocolRedirects", "", "defaultRequestProperties", "Lcom/google/android/exoplayer2/upstream/HttpDataSource$RequestProperties;", "(Ljava/lang/String;Lcom/google/android/exoplayer2/util/Predicate;Lcom/google/android/exoplayer2/upstream/TransferListener;IIZLcom/google/android/exoplayer2/upstream/HttpDataSource$RequestProperties;)V", "getFinalUrl", "Companion", "plugin-appbrand-integration_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class b
  extends o
{
  public static final a usp;
  
  static
  {
    AppMethodBeat.i(318041);
    usp = new a((byte)0);
    AppMethodBeat.o(318041);
  }
  
  public b(String paramString, w<? super o> paramw, s.f paramf)
  {
    super(paramString, paramw, 8000, 8000, true, paramf);
  }
  
  public final String cNK()
  {
    String str1 = null;
    AppMethodBeat.i(318053);
    Object localObject = getConnection();
    if (localObject == null)
    {
      localObject = null;
      if (localObject != null) {
        break label87;
      }
    }
    for (;;)
    {
      String str2 = str1;
      if (str1 == null) {
        str2 = super.getUri().toString();
      }
      s.s(str2, "finalURL?.toString() ?: super.getUri().toString()");
      Log.i("MicroMsg.AppBrand.FinalUrlAccessibleHttpDataSource", "getFinalUrl, finalURL: " + localObject + ", finalUrl: " + str2);
      AppMethodBeat.o(318053);
      return str2;
      localObject = ((HttpURLConnection)localObject).getURL();
      break;
      label87:
      str1 = ((URL)localObject).toString();
    }
  }
  
  @Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/appbrand/video/depend_exo/FinalUrlAccessibleHttpDataSource$Companion;", "Lcom/google/android/exoplayer2/upstream/DataSource$Factory;", "()V", "TAG", "", "createDataSource", "Lcom/tencent/mm/plugin/appbrand/video/depend_exo/FinalUrlAccessibleHttpDataSource;", "plugin-appbrand-integration_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class a
    implements g.a
  {
    public static b cNL()
    {
      AppMethodBeat.i(318049);
      b localb = new b(com.tencent.mm.plugin.appbrand.jsapi.video.e.k.eP(MMApplicationContext.getContext()), (w)com.tencent.mm.plugin.appbrand.jsapi.video.e.c.k.sGC, new s.f());
      AppMethodBeat.o(318049);
      return localb;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.ag.a.b
 * JD-Core Version:    0.7.0.1
 */