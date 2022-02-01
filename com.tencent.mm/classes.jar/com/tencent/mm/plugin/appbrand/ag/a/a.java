package com.tencent.mm.plugin.appbrand.ag.a;

import android.content.Context;
import android.net.Uri;
import com.google.android.exoplayer2.h.g;
import com.google.android.exoplayer2.h.g.a;
import com.google.android.exoplayer2.h.j;
import com.google.android.exoplayer2.h.m;
import com.google.android.exoplayer2.h.w;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.jsapi.video.e.c.k;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import kotlin.Metadata;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/appbrand/video/depend_exo/FinalUrlAccessibleDataSource;", "Lcom/google/android/exoplayer2/upstream/DataSource;", "context", "Landroid/content/Context;", "listener", "Lcom/google/android/exoplayer2/upstream/TransferListener;", "baseDataSource", "Lcom/tencent/mm/plugin/appbrand/video/depend_exo/FinalUrlAccessibleHttpDataSource;", "realDataSource", "Lcom/google/android/exoplayer2/upstream/DefaultDataSource;", "(Landroid/content/Context;Lcom/google/android/exoplayer2/upstream/TransferListener;Lcom/tencent/mm/plugin/appbrand/video/depend_exo/FinalUrlAccessibleHttpDataSource;Lcom/google/android/exoplayer2/upstream/DefaultDataSource;)V", "close", "", "getFinalUrl", "", "getUri", "Landroid/net/Uri;", "kotlin.jvm.PlatformType", "open", "", "p0", "Lcom/google/android/exoplayer2/upstream/DataSpec;", "read", "", "", "p1", "p2", "Companion", "plugin-appbrand-integration_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class a
  implements g
{
  public static final a usm;
  public final b usn;
  
  static
  {
    AppMethodBeat.i(318064);
    usm = new a((byte)0);
    AppMethodBeat.o(318064);
  }
  
  private a(b paramb, m paramm)
  {
    AppMethodBeat.i(318044);
    this.usn = paramb;
    this.uso = paramm;
    AppMethodBeat.o(318044);
  }
  
  public final long a(j paramj)
  {
    AppMethodBeat.i(318085);
    long l = this.uso.a(paramj);
    AppMethodBeat.o(318085);
    return l;
  }
  
  public final void close()
  {
    AppMethodBeat.i(318072);
    this.uso.close();
    AppMethodBeat.o(318072);
  }
  
  public final Uri getUri()
  {
    AppMethodBeat.i(318078);
    Uri localUri = this.uso.getUri();
    AppMethodBeat.o(318078);
    return localUri;
  }
  
  public final int read(byte[] paramArrayOfByte, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(318092);
    paramInt1 = this.uso.read(paramArrayOfByte, paramInt1, paramInt2);
    AppMethodBeat.o(318092);
    return paramInt1;
  }
  
  @Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/appbrand/video/depend_exo/FinalUrlAccessibleDataSource$Companion;", "Lcom/google/android/exoplayer2/upstream/DataSource$Factory;", "()V", "createDataSource", "Lcom/tencent/mm/plugin/appbrand/video/depend_exo/FinalUrlAccessibleDataSource;", "plugin-appbrand-integration_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class a
    implements g.a
  {
    public static a cNJ()
    {
      AppMethodBeat.i(318040);
      Object localObject = MMApplicationContext.getContext();
      w localw = (w)k.sGC;
      b.a locala = b.usp;
      localObject = new a((Context)localObject, localw, b.a.cNL());
      AppMethodBeat.o(318040);
      return localObject;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.ag.a.a
 * JD-Core Version:    0.7.0.1
 */