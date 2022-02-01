package com.tencent.mm.plugin.appbrand.e;

import android.content.Context;
import android.os.Parcelable;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ipcinvoker.f;
import com.tencent.mm.ipcinvoker.j;
import com.tencent.mm.ipcinvoker.type.IPCString;
import com.tencent.mm.ipcinvoker.type.IPCVoid;
import com.tencent.mm.ipcinvoker.wx_extension.service.MainProcessIPCService;
import com.tencent.mm.plugin.webview.model.WebViewJSSDKFileItem;
import com.tencent.mm.plugin.webview.model.WebViewJSSDKImageItem;
import com.tencent.mm.plugin.webview.model.ao;
import com.tencent.mm.plugin.webview.model.az;
import com.tencent.mm.plugin.webview.modeltools.g;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.vfs.ah;
import com.tencent.mm.vfs.u;
import com.tencent.mm.vfs.y;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.Set;
import kotlin.Metadata;
import kotlin.g.b.s;
import kotlin.n.n;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/appbrand/complaint/AppBrandComplaintService;", "Lcom/tencent/mm/plugin/appbrand/complaint/IAppBrandComplaintService;", "()V", "TAG", "", "imageCacheDir", "imageSet", "", "cleanCacheDir", "", "cleanCacheDirInMM", "getCacheDir", "registerFileItem", "path", "registerFileItemInMM", "plugin-appbrand-integration_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class b
  implements c
{
  public static final b qVq = new b();
  private static final Set<String> qVr = (Set)new LinkedHashSet();
  private static String qVs;
  
  static
  {
    AppMethodBeat.i(316989);
    try
    {
      Object localObject1 = u.V(MMApplicationContext.getContext().getExternalCacheDir());
      Object localObject3 = localObject1;
      if (localObject1 == null) {
        localObject3 = new u(MMApplicationContext.getContext().getCacheDir());
      }
      localObject3 = ah.v(((u)localObject3).jKT());
      s.s(localObject3, "cacheDir.absolutePath");
      localObject1 = localObject3;
      if (!n.rs((String)localObject3, "/")) {
        localObject1 = s.X((String)localObject3, "/");
      }
      localObject1 = s.X((String)localObject1, "wxacomplaint");
      if (y.bDX((String)localObject1)) {
        qVs = (String)localObject1;
      }
      AppMethodBeat.o(316989);
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
  
  private static final void b(IPCVoid paramIPCVoid, f paramf)
  {
    AppMethodBeat.i(316987);
    Log.i("MicroMsg.AppBrandComplaintService", s.X("cleanCacheDir, cacheDir:", qVs));
    y.ew(qVs, true);
    paramIPCVoid = ((Iterable)qVr).iterator();
    while (paramIPCVoid.hasNext())
    {
      paramf = (String)paramIPCVoid.next();
      ao localao = g.ivZ();
      if (Util.isNullOrNil(paramf))
      {
        Log.e("MicroMsg.WebViewJSSDKFileItemManager", "removeJSSDKFileItem, local id is null");
      }
      else
      {
        Log.i("MicroMsg.WebViewJSSDKFileItemManager", "removeJSSDKFileItem, localId:%s", new Object[] { paramf });
        localao.WMk.remove(paramf);
      }
    }
    AppMethodBeat.o(316987);
  }
  
  private static final void d(IPCString paramIPCString, f paramf)
  {
    AppMethodBeat.i(316982);
    paramf = paramIPCString.value;
    s.s(paramf, "data.value");
    paramIPCString = new WebViewJSSDKImageItem();
    paramIPCString.HKz = false;
    paramIPCString.qUK = paramf;
    paramIPCString.rPM = paramf;
    paramIPCString.hHB = az.bkB(paramf);
    g.ivZ().a((WebViewJSSDKFileItem)paramIPCString);
    Log.i("MicroMsg.AppBrandComplaintService", "registerFileItem, filePath:" + paramf + ", localId:" + paramIPCString.hHB);
    paramf = qVr;
    paramIPCString = paramIPCString.hHB;
    s.s(paramIPCString, "fileItem.localId");
    paramf.add(paramIPCString);
    AppMethodBeat.o(316982);
  }
  
  public final void Xj(String paramString)
  {
    AppMethodBeat.i(317004);
    s.u(paramString, "path");
    j.a(MainProcessIPCService.PROCESS_NAME, (Parcelable)new IPCString(paramString), b..ExternalSyntheticLambda0.INSTANCE.getClass(), null);
    AppMethodBeat.o(317004);
  }
  
  public final void ckq()
  {
    AppMethodBeat.i(317010);
    j.a(MainProcessIPCService.PROCESS_NAME, (Parcelable)new IPCVoid(), b..ExternalSyntheticLambda1.INSTANCE.getClass(), null);
    AppMethodBeat.o(317010);
  }
  
  public final String getCacheDir()
  {
    return qVs;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.e.b
 * JD-Core Version:    0.7.0.1
 */