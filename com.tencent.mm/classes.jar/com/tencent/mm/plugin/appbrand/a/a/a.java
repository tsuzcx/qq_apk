package com.tencent.mm.plugin.appbrand.a.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.vfs.ah;
import com.tencent.mm.vfs.u;
import com.tencent.mm.vfs.y;
import java.io.File;
import kotlin.Metadata;
import kotlin.g.b.s;
import kotlin.n.n;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/appbrand/ai/cache/AppBrandXNetModelCache;", "Lcom/tencent/mm/plugin/appbrand/ai/cache/IAppBrandXNetModelCache;", "uin", "", "appId", "(Ljava/lang/String;Ljava/lang/String;)V", "cacheDirPath", "clear", "", "getCachePath", "Companion", "plugin-appbrand-integration_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class a
  implements b
{
  public static final a qAy;
  private final String appId;
  private String qAz;
  private final String uin;
  
  static
  {
    AppMethodBeat.i(317260);
    qAy = new a((byte)0);
    AppMethodBeat.o(317260);
  }
  
  public a(String paramString1, String paramString2)
  {
    AppMethodBeat.i(317253);
    this.uin = paramString1;
    this.appId = paramString2;
    this.qAz = "";
    paramString1 = u.V(new File(com.tencent.mm.loader.i.b.bnA()));
    if (paramString1 != null)
    {
      paramString2 = ah.v(paramString1.jKT());
      s.s(paramString2, "cacheRootDir.absolutePath");
      paramString1 = paramString2;
      if (!n.rs(paramString2, "/")) {
        paramString1 = s.X(paramString2, "/");
      }
      this.qAz = (paramString1 + this.uin + '#' + this.appId);
      if (new u(this.qAz).jKV()) {
        y.deleteFile(this.qAz);
      }
      if (!new u(this.qAz).jKS()) {
        y.bDX(this.qAz);
      }
    }
    AppMethodBeat.o(317253);
  }
  
  public static final void cK(String paramString1, String paramString2)
  {
    AppMethodBeat.i(317257);
    a.cK(paramString1, paramString2);
    AppMethodBeat.o(317257);
  }
  
  public final String baj()
  {
    return this.qAz;
  }
  
  public final void clear()
  {
    AppMethodBeat.i(317266);
    Log.i("MicroMsg.AppBrandXNetModelCache", s.X("[clear] result", Boolean.valueOf(y.ew(this.qAz, true))));
    AppMethodBeat.o(317266);
  }
  
  @Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/appbrand/ai/cache/AppBrandXNetModelCache$Companion;", "", "()V", "TAG", "", "clear", "", "uin", "appId", "plugin-appbrand-integration_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class a
  {
    public static void cK(String paramString1, String paramString2)
    {
      AppMethodBeat.i(317255);
      s.u(paramString1, "uin");
      s.u(paramString2, "appId");
      new a(paramString1, paramString2).clear();
      AppMethodBeat.o(317255);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.a.a.a
 * JD-Core Version:    0.7.0.1
 */