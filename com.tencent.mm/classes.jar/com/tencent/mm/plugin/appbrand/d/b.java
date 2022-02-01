package com.tencent.mm.plugin.appbrand.d;

import android.content.Context;
import android.os.Parcelable;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ipcinvoker.h;
import com.tencent.mm.ipcinvoker.type.IPCString;
import com.tencent.mm.ipcinvoker.type.IPCVoid;
import com.tencent.mm.sdk.platformtools.ak;
import com.tencent.mm.vfs.k;
import com.tencent.mm.vfs.o;
import d.g.b.p;
import d.l;
import d.n.n;
import java.util.LinkedHashSet;
import java.util.Set;

@l(gjZ={1, 1, 16}, gka={""}, gkb={"Lcom/tencent/mm/plugin/appbrand/complaint/AppBrandComplaintService;", "Lcom/tencent/mm/plugin/appbrand/complaint/IAppBrandComplaintService;", "()V", "TAG", "", "imageCacheDir", "imageSet", "", "cleanCacheDir", "", "cleanCacheDirInMM", "getCacheDir", "registerFileItem", "path", "registerFileItemInMM", "plugin-appbrand-integration_release"})
public final class b
  implements c
{
  private static final Set<String> jYA = (Set)new LinkedHashSet();
  private static String jYB;
  public static final b jYC;
  
  static
  {
    AppMethodBeat.i(223261);
    jYC = new b();
    try
    {
      Object localObject1 = ak.getContext();
      p.g(localObject1, "MMApplicationContext.getContext()");
      localObject1 = k.W(((Context)localObject1).getExternalCacheDir());
      Object localObject3 = localObject1;
      if (localObject1 == null)
      {
        localObject1 = ak.getContext();
        p.g(localObject1, "MMApplicationContext.getContext()");
        localObject3 = new k(((Context)localObject1).getCacheDir());
      }
      localObject3 = ((k)localObject3).getAbsolutePath();
      p.g(localObject3, "cacheDirPath");
      localObject1 = localObject3;
      if (!n.nG((String)localObject3, "/")) {
        localObject1 = (String)localObject3 + "/";
      }
      localObject1 = (String)localObject1 + "wxacomplaint";
      if (o.aZI((String)localObject1)) {
        jYB = (String)localObject1;
      }
      AppMethodBeat.o(223261);
      return;
    }
    catch (Exception localException)
    {
      for (;;)
      {
        Object localObject2 = null;
      }
    }
  }
  
  public final void NL(String paramString)
  {
    AppMethodBeat.i(223259);
    p.h(paramString, "path");
    h.a("com.tencent.mm", (Parcelable)new IPCString(paramString), b.jYE.getClass(), null);
    AppMethodBeat.o(223259);
  }
  
  public final void bek()
  {
    AppMethodBeat.i(223260);
    h.a("com.tencent.mm", (Parcelable)new IPCVoid(), a.jYD.getClass(), null);
    AppMethodBeat.o(223260);
  }
  
  public final String getCacheDir()
  {
    return jYB;
  }
  
  @l(gjZ={1, 1, 16}, gka={""}, gkb={"<anonymous>", "", "<anonymous parameter 0>", "Lcom/tencent/mm/ipcinvoker/type/IPCVoid;", "kotlin.jvm.PlatformType", "<anonymous parameter 1>", "Lcom/tencent/mm/ipcinvoker/IPCInvokeCallback;", "invoke"})
  static final class a<InputType, ResultType>
    implements com.tencent.mm.ipcinvoker.b<IPCVoid, IPCVoid>
  {
    public static final a jYD;
    
    static
    {
      AppMethodBeat.i(223256);
      jYD = new a();
      AppMethodBeat.o(223256);
    }
  }
  
  @l(gjZ={1, 1, 16}, gka={""}, gkb={"<anonymous>", "", "data", "Lcom/tencent/mm/ipcinvoker/type/IPCString;", "kotlin.jvm.PlatformType", "<anonymous parameter 1>", "Lcom/tencent/mm/ipcinvoker/IPCInvokeCallback;", "Lcom/tencent/mm/ipcinvoker/type/IPCVoid;", "invoke"})
  static final class b<InputType, ResultType>
    implements com.tencent.mm.ipcinvoker.b<IPCString, IPCVoid>
  {
    public static final b jYE;
    
    static
    {
      AppMethodBeat.i(223258);
      jYE = new b();
      AppMethodBeat.o(223258);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.d.b
 * JD-Core Version:    0.7.0.1
 */