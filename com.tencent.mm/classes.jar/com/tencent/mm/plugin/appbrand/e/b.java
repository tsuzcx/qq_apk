package com.tencent.mm.plugin.appbrand.e;

import android.content.Context;
import android.os.Parcelable;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ipcinvoker.h;
import com.tencent.mm.ipcinvoker.type.IPCString;
import com.tencent.mm.ipcinvoker.type.IPCVoid;
import com.tencent.mm.sdk.platformtools.aj;
import com.tencent.mm.vfs.e;
import com.tencent.mm.vfs.i;
import d.g.b.k;
import d.l;
import d.n.n;
import java.util.LinkedHashSet;
import java.util.Set;

@l(fvt={1, 1, 16}, fvu={""}, fvv={"Lcom/tencent/mm/plugin/appbrand/complaint/AppBrandComplaintService;", "Lcom/tencent/mm/plugin/appbrand/complaint/IAppBrandComplaintService;", "()V", "TAG", "", "imageCacheDir", "imageSet", "", "cleanCacheDir", "", "cleanCacheDirInMM", "getCacheDir", "registerFileItem", "path", "registerFileItemInMM", "plugin-appbrand-integration_release"})
public final class b
  implements c
{
  private static final Set<String> jbb;
  private static String jbc;
  public static final b jbd;
  
  static
  {
    AppMethodBeat.i(196248);
    jbd = new b();
    jbb = (Set)new LinkedHashSet();
    Object localObject1 = aj.getContext();
    k.g(localObject1, "MMApplicationContext.getContext()");
    Object localObject2 = e.R(((Context)localObject1).getExternalCacheDir());
    localObject1 = localObject2;
    if (localObject2 == null)
    {
      localObject1 = aj.getContext();
      k.g(localObject1, "MMApplicationContext.getContext()");
      localObject1 = new e(((Context)localObject1).getCacheDir());
    }
    localObject2 = ((e)localObject1).getAbsolutePath();
    k.g(localObject2, "cacheDirPath");
    localObject1 = localObject2;
    if (!n.mB((String)localObject2, "/")) {
      localObject1 = (String)localObject2 + "/";
    }
    localObject1 = (String)localObject1 + "wxacomplaint";
    if (i.aMF((String)localObject1)) {
      jbc = (String)localObject1;
    }
    AppMethodBeat.o(196248);
  }
  
  public final void FH(String paramString)
  {
    AppMethodBeat.i(196246);
    k.h(paramString, "path");
    h.a("com.tencent.mm", (Parcelable)new IPCString(paramString), b.jbf.getClass(), null);
    AppMethodBeat.o(196246);
  }
  
  public final String aTh()
  {
    return jbc;
  }
  
  public final void aTi()
  {
    AppMethodBeat.i(196247);
    h.a("com.tencent.mm", (Parcelable)new IPCVoid(), a.jbe.getClass(), null);
    AppMethodBeat.o(196247);
  }
  
  @l(fvt={1, 1, 16}, fvu={""}, fvv={"<anonymous>", "", "<anonymous parameter 0>", "Lcom/tencent/mm/ipcinvoker/type/IPCVoid;", "kotlin.jvm.PlatformType", "<anonymous parameter 1>", "Lcom/tencent/mm/ipcinvoker/IPCInvokeCallback;", "invoke"})
  static final class a<InputType, ResultType>
    implements com.tencent.mm.ipcinvoker.b<IPCVoid, IPCVoid>
  {
    public static final a jbe;
    
    static
    {
      AppMethodBeat.i(196243);
      jbe = new a();
      AppMethodBeat.o(196243);
    }
  }
  
  @l(fvt={1, 1, 16}, fvu={""}, fvv={"<anonymous>", "", "data", "Lcom/tencent/mm/ipcinvoker/type/IPCString;", "kotlin.jvm.PlatformType", "<anonymous parameter 1>", "Lcom/tencent/mm/ipcinvoker/IPCInvokeCallback;", "Lcom/tencent/mm/ipcinvoker/type/IPCVoid;", "invoke"})
  static final class b<InputType, ResultType>
    implements com.tencent.mm.ipcinvoker.b<IPCString, IPCVoid>
  {
    public static final b jbf;
    
    static
    {
      AppMethodBeat.i(196245);
      jbf = new b();
      AppMethodBeat.o(196245);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.e.b
 * JD-Core Version:    0.7.0.1
 */