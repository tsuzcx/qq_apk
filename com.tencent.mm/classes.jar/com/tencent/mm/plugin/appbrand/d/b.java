package com.tencent.mm.plugin.appbrand.d;

import android.content.Context;
import android.os.Parcelable;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ipcinvoker.h;
import com.tencent.mm.ipcinvoker.type.IPCString;
import com.tencent.mm.ipcinvoker.type.IPCVoid;
import com.tencent.mm.sdk.platformtools.aj;
import com.tencent.mm.vfs.e;
import com.tencent.mm.vfs.i;
import d.g.b.p;
import d.l;
import d.n.n;
import java.util.LinkedHashSet;
import java.util.Set;

@l(gfx={1, 1, 16}, gfy={""}, gfz={"Lcom/tencent/mm/plugin/appbrand/complaint/AppBrandComplaintService;", "Lcom/tencent/mm/plugin/appbrand/complaint/IAppBrandComplaintService;", "()V", "TAG", "", "imageCacheDir", "imageSet", "", "cleanCacheDir", "", "cleanCacheDirInMM", "getCacheDir", "registerFileItem", "path", "registerFileItemInMM", "plugin-appbrand-integration_release"})
public final class b
  implements c
{
  private static final Set<String> jVj = (Set)new LinkedHashSet();
  private static String jVk;
  public static final b jVl;
  
  static
  {
    AppMethodBeat.i(189002);
    jVl = new b();
    try
    {
      Object localObject1 = aj.getContext();
      p.g(localObject1, "MMApplicationContext.getContext()");
      localObject1 = e.X(((Context)localObject1).getExternalCacheDir());
      Object localObject3 = localObject1;
      if (localObject1 == null)
      {
        localObject1 = aj.getContext();
        p.g(localObject1, "MMApplicationContext.getContext()");
        localObject3 = new e(((Context)localObject1).getCacheDir());
      }
      localObject3 = ((e)localObject3).getAbsolutePath();
      p.g(localObject3, "cacheDirPath");
      localObject1 = localObject3;
      if (!n.nA((String)localObject3, "/")) {
        localObject1 = (String)localObject3 + "/";
      }
      localObject1 = (String)localObject1 + "wxacomplaint";
      if (i.aYg((String)localObject1)) {
        jVk = (String)localObject1;
      }
      AppMethodBeat.o(189002);
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
  
  public final void Ne(String paramString)
  {
    AppMethodBeat.i(189000);
    p.h(paramString, "path");
    h.a("com.tencent.mm", (Parcelable)new IPCString(paramString), b.jVn.getClass(), null);
    AppMethodBeat.o(189000);
  }
  
  public final void bdF()
  {
    AppMethodBeat.i(189001);
    h.a("com.tencent.mm", (Parcelable)new IPCVoid(), a.jVm.getClass(), null);
    AppMethodBeat.o(189001);
  }
  
  public final String getCacheDir()
  {
    return jVk;
  }
  
  @l(gfx={1, 1, 16}, gfy={""}, gfz={"<anonymous>", "", "<anonymous parameter 0>", "Lcom/tencent/mm/ipcinvoker/type/IPCVoid;", "kotlin.jvm.PlatformType", "<anonymous parameter 1>", "Lcom/tencent/mm/ipcinvoker/IPCInvokeCallback;", "invoke"})
  static final class a<InputType, ResultType>
    implements com.tencent.mm.ipcinvoker.b<IPCVoid, IPCVoid>
  {
    public static final a jVm;
    
    static
    {
      AppMethodBeat.i(188997);
      jVm = new a();
      AppMethodBeat.o(188997);
    }
  }
  
  @l(gfx={1, 1, 16}, gfy={""}, gfz={"<anonymous>", "", "data", "Lcom/tencent/mm/ipcinvoker/type/IPCString;", "kotlin.jvm.PlatformType", "<anonymous parameter 1>", "Lcom/tencent/mm/ipcinvoker/IPCInvokeCallback;", "Lcom/tencent/mm/ipcinvoker/type/IPCVoid;", "invoke"})
  static final class b<InputType, ResultType>
    implements com.tencent.mm.ipcinvoker.b<IPCString, IPCVoid>
  {
    public static final b jVn;
    
    static
    {
      AppMethodBeat.i(188999);
      jVn = new b();
      AppMethodBeat.o(188999);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.d.b
 * JD-Core Version:    0.7.0.1
 */