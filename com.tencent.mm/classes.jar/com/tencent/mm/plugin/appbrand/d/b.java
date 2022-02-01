package com.tencent.mm.plugin.appbrand.d;

import android.content.Context;
import android.os.Parcelable;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ipcinvoker.h;
import com.tencent.mm.ipcinvoker.type.IPCString;
import com.tencent.mm.ipcinvoker.type.IPCVoid;
import com.tencent.mm.ipcinvoker.wx_extension.service.MainProcessIPCService;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.vfs.o;
import com.tencent.mm.vfs.s;
import java.util.LinkedHashSet;
import java.util.Set;
import kotlin.g.b.p;
import kotlin.l;
import kotlin.n.n;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/appbrand/complaint/AppBrandComplaintService;", "Lcom/tencent/mm/plugin/appbrand/complaint/IAppBrandComplaintService;", "()V", "TAG", "", "imageCacheDir", "imageSet", "", "cleanCacheDir", "", "cleanCacheDirInMM", "getCacheDir", "registerFileItem", "path", "registerFileItemInMM", "plugin-appbrand-integration_release"})
public final class b
  implements c
{
  public static final b lbA = new b();
  private static final Set<String> lby = (Set)new LinkedHashSet();
  private static String lbz;
  
  static
  {
    AppMethodBeat.i(228159);
    try
    {
      Object localObject1 = MMApplicationContext.getContext();
      p.g(localObject1, "MMApplicationContext.getContext()");
      localObject1 = o.X(((Context)localObject1).getExternalCacheDir());
      Object localObject3 = localObject1;
      if (localObject1 == null)
      {
        localObject1 = MMApplicationContext.getContext();
        p.g(localObject1, "MMApplicationContext.getContext()");
        localObject3 = new o(((Context)localObject1).getCacheDir());
      }
      localObject3 = ((o)localObject3).getAbsolutePath();
      p.g(localObject3, "cacheDir.absolutePath");
      localObject1 = localObject3;
      if (!n.K((String)localObject3, "/", false)) {
        localObject1 = (String)localObject3 + "/";
      }
      localObject1 = (String)localObject1 + "wxacomplaint";
      if (s.boN((String)localObject1)) {
        lbz = (String)localObject1;
      }
      AppMethodBeat.o(228159);
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
  
  public final void WT(String paramString)
  {
    AppMethodBeat.i(228157);
    p.h(paramString, "path");
    h.a(MainProcessIPCService.dkO, (Parcelable)new IPCString(paramString), b.lbC.getClass(), null);
    AppMethodBeat.o(228157);
  }
  
  public final void bzB()
  {
    AppMethodBeat.i(228158);
    h.a(MainProcessIPCService.dkO, (Parcelable)new IPCVoid(), a.lbB.getClass(), null);
    AppMethodBeat.o(228158);
  }
  
  public final String getCacheDir()
  {
    return lbz;
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "<anonymous parameter 0>", "Lcom/tencent/mm/ipcinvoker/type/IPCVoid;", "kotlin.jvm.PlatformType", "<anonymous parameter 1>", "Lcom/tencent/mm/ipcinvoker/IPCInvokeCallback;", "invoke"})
  static final class a<InputType, ResultType>
    implements com.tencent.mm.ipcinvoker.b<IPCVoid, IPCVoid>
  {
    public static final a lbB;
    
    static
    {
      AppMethodBeat.i(228154);
      lbB = new a();
      AppMethodBeat.o(228154);
    }
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "data", "Lcom/tencent/mm/ipcinvoker/type/IPCString;", "kotlin.jvm.PlatformType", "<anonymous parameter 1>", "Lcom/tencent/mm/ipcinvoker/IPCInvokeCallback;", "Lcom/tencent/mm/ipcinvoker/type/IPCVoid;", "invoke"})
  static final class b<InputType, ResultType>
    implements com.tencent.mm.ipcinvoker.b<IPCString, IPCVoid>
  {
    public static final b lbC;
    
    static
    {
      AppMethodBeat.i(228156);
      lbC = new b();
      AppMethodBeat.o(228156);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.d.b
 * JD-Core Version:    0.7.0.1
 */