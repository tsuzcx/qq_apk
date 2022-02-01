package com.tencent.mm.plugin.appbrand.e;

import android.content.Context;
import android.os.Parcelable;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ipcinvoker.h;
import com.tencent.mm.ipcinvoker.type.IPCString;
import com.tencent.mm.ipcinvoker.type.IPCVoid;
import com.tencent.mm.sdk.platformtools.ai;
import com.tencent.mm.vfs.e;
import com.tencent.mm.vfs.i;
import d.g.b.k;
import d.l;
import d.n.n;
import java.util.LinkedHashSet;
import java.util.Set;

@l(fNY={1, 1, 16}, fNZ={""}, fOa={"Lcom/tencent/mm/plugin/appbrand/complaint/AppBrandComplaintService;", "Lcom/tencent/mm/plugin/appbrand/complaint/IAppBrandComplaintService;", "()V", "TAG", "", "imageCacheDir", "imageSet", "", "cleanCacheDir", "", "cleanCacheDirInMM", "getCacheDir", "registerFileItem", "path", "registerFileItemInMM", "plugin-appbrand-integration_release"})
public final class b
  implements c
{
  private static final Set<String> jBo = (Set)new LinkedHashSet();
  private static String jBp;
  public static final b jBq;
  
  static
  {
    AppMethodBeat.i(187113);
    jBq = new b();
    try
    {
      Object localObject1 = ai.getContext();
      k.g(localObject1, "MMApplicationContext.getContext()");
      localObject1 = e.U(((Context)localObject1).getExternalCacheDir());
      Object localObject3 = localObject1;
      if (localObject1 == null)
      {
        localObject1 = ai.getContext();
        k.g(localObject1, "MMApplicationContext.getContext()");
        localObject3 = new e(((Context)localObject1).getCacheDir());
      }
      localObject3 = ((e)localObject3).getAbsolutePath();
      k.g(localObject3, "cacheDirPath");
      localObject1 = localObject3;
      if (!n.nc((String)localObject3, "/")) {
        localObject1 = (String)localObject3 + "/";
      }
      localObject1 = (String)localObject1 + "wxacomplaint";
      if (i.aSh((String)localObject1)) {
        jBp = (String)localObject1;
      }
      AppMethodBeat.o(187113);
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
  
  public final void JL(String paramString)
  {
    AppMethodBeat.i(187111);
    k.h(paramString, "path");
    h.a("com.tencent.mm", (Parcelable)new IPCString(paramString), b.jBs.getClass(), null);
    AppMethodBeat.o(187111);
  }
  
  public final void bag()
  {
    AppMethodBeat.i(187112);
    h.a("com.tencent.mm", (Parcelable)new IPCVoid(), a.jBr.getClass(), null);
    AppMethodBeat.o(187112);
  }
  
  public final String getCacheDir()
  {
    return jBp;
  }
  
  @l(fNY={1, 1, 16}, fNZ={""}, fOa={"<anonymous>", "", "<anonymous parameter 0>", "Lcom/tencent/mm/ipcinvoker/type/IPCVoid;", "kotlin.jvm.PlatformType", "<anonymous parameter 1>", "Lcom/tencent/mm/ipcinvoker/IPCInvokeCallback;", "invoke"})
  static final class a<InputType, ResultType>
    implements com.tencent.mm.ipcinvoker.b<IPCVoid, IPCVoid>
  {
    public static final a jBr;
    
    static
    {
      AppMethodBeat.i(187108);
      jBr = new a();
      AppMethodBeat.o(187108);
    }
  }
  
  @l(fNY={1, 1, 16}, fNZ={""}, fOa={"<anonymous>", "", "data", "Lcom/tencent/mm/ipcinvoker/type/IPCString;", "kotlin.jvm.PlatformType", "<anonymous parameter 1>", "Lcom/tencent/mm/ipcinvoker/IPCInvokeCallback;", "Lcom/tencent/mm/ipcinvoker/type/IPCVoid;", "invoke"})
  static final class b<InputType, ResultType>
    implements com.tencent.mm.ipcinvoker.b<IPCString, IPCVoid>
  {
    public static final b jBs;
    
    static
    {
      AppMethodBeat.i(187110);
      jBs = new b();
      AppMethodBeat.o(187110);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.e.b
 * JD-Core Version:    0.7.0.1
 */