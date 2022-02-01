package com.tencent.mm.plugin.appbrand.d;

import android.content.Context;
import android.os.Parcelable;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ipcinvoker.d;
import com.tencent.mm.ipcinvoker.j;
import com.tencent.mm.ipcinvoker.type.IPCString;
import com.tencent.mm.ipcinvoker.type.IPCVoid;
import com.tencent.mm.ipcinvoker.wx_extension.service.MainProcessIPCService;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.vfs.q;
import com.tencent.mm.vfs.u;
import java.util.LinkedHashSet;
import java.util.Set;
import kotlin.g.b.p;
import kotlin.l;
import kotlin.n.n;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/appbrand/complaint/AppBrandComplaintService;", "Lcom/tencent/mm/plugin/appbrand/complaint/IAppBrandComplaintService;", "()V", "TAG", "", "imageCacheDir", "imageSet", "", "cleanCacheDir", "", "cleanCacheDirInMM", "getCacheDir", "registerFileItem", "path", "registerFileItemInMM", "plugin-appbrand-integration_release"})
public final class b
  implements c
{
  private static final Set<String> nVG = (Set)new LinkedHashSet();
  private static String nVH;
  public static final b nVI;
  
  static
  {
    AppMethodBeat.i(281271);
    nVI = new b();
    try
    {
      Object localObject1 = MMApplicationContext.getContext();
      p.j(localObject1, "MMApplicationContext.getContext()");
      localObject1 = q.Q(((Context)localObject1).getExternalCacheDir());
      Object localObject3 = localObject1;
      if (localObject1 == null)
      {
        localObject1 = MMApplicationContext.getContext();
        p.j(localObject1, "MMApplicationContext.getContext()");
        localObject3 = new q(((Context)localObject1).getCacheDir());
      }
      localObject3 = ((q)localObject3).bOF();
      p.j(localObject3, "cacheDir.absolutePath");
      localObject1 = localObject3;
      if (!n.pu((String)localObject3, "/")) {
        localObject1 = (String)localObject3 + "/";
      }
      localObject1 = (String)localObject1 + "wxacomplaint";
      if (u.bBD((String)localObject1)) {
        nVH = (String)localObject1;
      }
      AppMethodBeat.o(281271);
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
  
  public final void aeG(String paramString)
  {
    AppMethodBeat.i(281269);
    p.k(paramString, "path");
    j.a(MainProcessIPCService.PROCESS_NAME, (Parcelable)new IPCString(paramString), b.nVK.getClass(), null);
    AppMethodBeat.o(281269);
  }
  
  public final void bKQ()
  {
    AppMethodBeat.i(281270);
    j.a(MainProcessIPCService.PROCESS_NAME, (Parcelable)new IPCVoid(), a.nVJ.getClass(), null);
    AppMethodBeat.o(281270);
  }
  
  public final String getCacheDir()
  {
    return nVH;
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "<anonymous parameter 0>", "Lcom/tencent/mm/ipcinvoker/type/IPCVoid;", "kotlin.jvm.PlatformType", "<anonymous parameter 1>", "Lcom/tencent/mm/ipcinvoker/IPCInvokeCallback;", "invoke"})
  static final class a<InputType, ResultType>
    implements d<IPCVoid, IPCVoid>
  {
    public static final a nVJ;
    
    static
    {
      AppMethodBeat.i(277669);
      nVJ = new a();
      AppMethodBeat.o(277669);
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "data", "Lcom/tencent/mm/ipcinvoker/type/IPCString;", "kotlin.jvm.PlatformType", "<anonymous parameter 1>", "Lcom/tencent/mm/ipcinvoker/IPCInvokeCallback;", "Lcom/tencent/mm/ipcinvoker/type/IPCVoid;", "invoke"})
  static final class b<InputType, ResultType>
    implements d<IPCString, IPCVoid>
  {
    public static final b nVK;
    
    static
    {
      AppMethodBeat.i(245435);
      nVK = new b();
      AppMethodBeat.o(245435);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.d.b
 * JD-Core Version:    0.7.0.1
 */