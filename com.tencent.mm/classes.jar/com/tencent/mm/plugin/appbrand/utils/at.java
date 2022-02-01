package com.tencent.mm.plugin.appbrand.utils;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.jsapi.f;
import com.tencent.mm.vfs.ah;
import com.tencent.mm.vfs.u;
import kotlin.Metadata;
import kotlin.g.b.s;
import kotlin.n.n;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/appbrand/utils/WxaPathResolver;", "", "()V", "PATH_TYPE_NETWORK", "", "PATH_TYPE_WX_FILE", "PATH_TYPE_WX_PKG", "resolveImage", "", "component", "Lcom/tencent/mm/plugin/appbrand/jsapi/AppBrandComponent;", "path", "", "md5", "supportPathType", "pathResolveListener", "Lcom/tencent/mm/plugin/appbrand/utils/IPathResolveListener;", "resolveImageWithGifSupport", "isSupport", "", "supportNetworkPath", "supportWxFilePath", "supportWxPkgPath", "luggage-wxa-app_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class at
{
  public static final at urQ;
  
  static
  {
    AppMethodBeat.i(317435);
    urQ = new at();
    AppMethodBeat.o(317435);
  }
  
  private static boolean DJ(int paramInt)
  {
    return 1 == (paramInt & 0x1);
  }
  
  private static boolean DK(int paramInt)
  {
    return 2 == (paramInt & 0x2);
  }
  
  private static boolean DL(int paramInt)
  {
    return 4 == (paramInt & 0x4);
  }
  
  public static final void a(f paramf, String paramString, int paramInt, w paramw)
  {
    Object localObject = null;
    AppMethodBeat.i(317388);
    s.u(paramf, "component");
    s.u(paramString, "path");
    s.u(paramw, "pathResolveListener");
    if (!aL(paramInt, paramString))
    {
      paramw.aA(null, false);
      AppMethodBeat.o(317388);
      return;
    }
    if ((n.U(paramString, "http://", false)) || (n.U(paramString, "https://", false)))
    {
      g.a(paramf, paramString, null, new at..ExternalSyntheticLambda0(paramw));
      AppMethodBeat.o(317388);
      return;
    }
    paramf = paramf.getFileSystem();
    if (paramf == null)
    {
      paramf = null;
      paramString = (CharSequence)paramf;
      if ((paramString != null) && (paramString.length() != 0)) {
        break label210;
      }
      paramInt = 1;
      label121:
      if (paramInt == 0) {
        break label215;
      }
      paramf = localObject;
      label128:
      if (paramf == null) {
        break label223;
      }
      paramString = new u(paramf).jKO();
      if ((paramString == null) || (true != n.rs(paramString, "_xdir"))) {
        break label218;
      }
      paramInt = 1;
      label160:
      if (paramInt == 0) {
        break label223;
      }
    }
    label210:
    label215:
    label218:
    label223:
    for (boolean bool = true;; bool = false)
    {
      paramw.aA(paramf, bool);
      AppMethodBeat.o(317388);
      return;
      paramf = paramf.Wm(paramString);
      if (paramf == null)
      {
        paramf = null;
        break;
      }
      paramf = ah.v(paramf.jKT());
      break;
      paramInt = 0;
      break label121;
      break label128;
      paramInt = 0;
      break label160;
    }
  }
  
  public static final void a(f paramf, String paramString, w paramw)
  {
    AppMethodBeat.i(317376);
    s.u(paramf, "component");
    s.u(paramString, "path");
    s.u(paramw, "pathResolveListener");
    a(paramf, paramString, 7, paramw);
    AppMethodBeat.o(317376);
  }
  
  private static final void a(w paramw, String paramString)
  {
    AppMethodBeat.i(317429);
    s.u(paramw, "$pathResolveListener");
    CharSequence localCharSequence = (CharSequence)paramString;
    if ((localCharSequence == null) || (localCharSequence.length() == 0)) {}
    for (int i = 1;; i = 0)
    {
      if (i != 0) {
        paramString = null;
      }
      paramw.aA(paramString, true);
      AppMethodBeat.o(317429);
      return;
    }
  }
  
  private static boolean aL(int paramInt, String paramString)
  {
    AppMethodBeat.i(317397);
    if (((DJ(paramInt)) && ((n.U(paramString, "http://", false)) || (n.U(paramString, "https://", false)))) || ((DK(paramInt)) && (n.U(paramString, "wxfile://", false))) || (DL(paramInt)))
    {
      AppMethodBeat.o(317397);
      return true;
    }
    AppMethodBeat.o(317397);
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.utils.at
 * JD-Core Version:    0.7.0.1
 */