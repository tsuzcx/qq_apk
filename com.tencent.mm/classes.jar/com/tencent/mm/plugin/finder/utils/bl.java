package com.tencent.mm.plugin.finder.utils;

import com.tencent.d.a.a.a.b.b.j;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.autogen.a.cd;
import com.tencent.mm.autogen.a.nu;
import com.tencent.mm.autogen.mmdata.rpt.cu;
import com.tencent.mm.kernel.h;
import com.tencent.mm.sdk.event.IListener;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.vfs.u;
import com.tencent.mm.vfs.v;
import com.tencent.mm.vfs.y;
import kotlin.Metadata;
import kotlin.g.b.s;
import kotlin.p;
import kotlin.r;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/utils/OlympicsResHelper;", "", "()V", "ResFolderName", "", "getResFolderName", "()Ljava/lang/String;", "ResPath", "getResPath", "TAG", "checkResUpdateListener", "Lcom/tencent/mm/sdk/event/IListener;", "Lcom/tencent/mm/autogen/events/CheckResUpdateCacheFileEvent;", "getCheckResUpdateListener", "()Lcom/tencent/mm/sdk/event/IListener;", "localDebugUpdateListener", "Lcom/tencent/mm/autogen/events/LocalCheckOlympicsFileEvent;", "getLocalDebugUpdateListener", "_innerGetJson", "fileName", "_innerGetPath", "checkResUpdate", "", "filePath", "fileVersion", "", "getPath", "Lkotlin/Pair;", "key", "Lcom/tencent/plugin/finder/live/api/constants/ConstantsOlympics$ResType;", "index", "report", "succ", "", "errCode", "plugin-finder-base_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class bl
{
  public static final bl GlV;
  private static final String GlW;
  private static final String GlX;
  private static final IListener<nu> GlY;
  private static final String TAG;
  private static final IListener<cd> pWI;
  
  static
  {
    AppMethodBeat.i(333235);
    GlV = new bl();
    TAG = "Finder.OlympicsResHelper";
    GlW = s.X(h.baE().cachePath, "oly/");
    GlX = "liveOlympicsAssets";
    pWI = (IListener)new OlympicsResHelper.checkResUpdateListener.1(com.tencent.mm.app.f.hfK);
    GlY = (IListener)new OlympicsResHelper.localDebugUpdateListener.1(com.tencent.mm.app.f.hfK);
    AppMethodBeat.o(333235);
  }
  
  private static String aCe(String paramString)
  {
    AppMethodBeat.i(333199);
    try
    {
      paramString = new u(GlW + GlX + '/' + paramString);
      if ((paramString.jKS()) && (paramString.jKV()))
      {
        paramString = v.an(paramString);
        AppMethodBeat.o(333199);
        return paramString;
      }
      AppMethodBeat.o(333199);
      return "";
    }
    finally
    {
      Log.printErrStackTrace(TAG, paramString, "_innerGetJson failed.", new Object[0]);
      AppMethodBeat.o(333199);
    }
    return "";
  }
  
  public static r<String, String> c(b.j paramj, int paramInt)
  {
    AppMethodBeat.i(333179);
    s.u(paramj, "key");
    if (!y.ZC(GlW))
    {
      Log.i(TAG, "getPath:" + paramj.name() + ", but not yet download.");
      paramj = new r("", "");
      AppMethodBeat.o(333179);
      return paramj;
    }
    Object localObject;
    String str1;
    switch (bl.a.$EnumSwitchMapping$0[paramj.ordinal()])
    {
    default: 
      paramj = new p();
      AppMethodBeat.o(333179);
      throw paramj;
    case 1: 
      localObject = new r("star-escort-animation.pag", "star-escort-config.json");
      String str2 = (String)((r)localObject).bsC;
      str1 = (String)((r)localObject).bsD;
      Log.i(TAG, "resFileName:" + str2 + ", jsonFileName:" + str1);
      localObject = GlW + GlX + '/' + str2;
      if (!new u((String)localObject).jKS()) {
        break;
      }
    }
    for (;;)
    {
      str1 = aCe(str1);
      Log.i(TAG, "getPath:" + paramj.name() + ", path:" + y.n((String)localObject, false) + ", json:" + str1);
      paramj = new r(localObject, str1);
      AppMethodBeat.o(333179);
      return paramj;
      localObject = new r("star-ignition-animation.pag", "star-ignition-config.json");
      break;
      localObject = new r("star-countdown-" + paramInt + "-animation.pag", "star-countdown-" + paramInt + "-config.json");
      break;
      localObject = new r("star-countdown-0-animation.pag", "star-countdown-0-config.json");
      break;
      localObject = new r("background-image.png", "background-config.json");
      break;
      localObject = new r("background-mini-window.png", "");
      break;
      localObject = new r("star-background-normal.pag", "");
      break;
      localObject = new r("star-background-ignited.pag", "");
      break;
      localObject = new r("cert-background.png", "");
      break;
      localObject = new r("cert-textstate-background.png", "");
      break;
      localObject = new r("cert-typeface.ttf", "");
      break;
      localObject = new r("cert-back-cover.png", "");
      break;
      localObject = new r("cert-button.png", "");
      break;
      localObject = new r("cert-cover.png", "");
      break;
      localObject = new r("cert-logo.png", "");
      break;
      localObject = new r("cert-seal.png", "");
      break;
      localObject = new r("cert-shadow.png", "");
      break;
      localObject = new r("cert-torch.png", "");
      break;
      localObject = new r("cert-torch-light.png", "");
      break;
      localObject = new r("cert-lighting.png", "");
      break;
      localObject = new r("cert-share-cover.png", "");
      break;
      localObject = "";
    }
  }
  
  public static String fie()
  {
    return GlW;
  }
  
  public static IListener<cd> fif()
  {
    return pWI;
  }
  
  public static IListener<nu> fig()
  {
    return GlY;
  }
  
  private static void n(boolean paramBoolean, int paramInt)
  {
    long l = 1L;
    AppMethodBeat.i(333206);
    cu localcu = new cu();
    localcu.ixD = 1L;
    if (paramBoolean) {}
    for (;;)
    {
      localcu.ixE = l;
      localcu.ixF = paramInt;
      localcu.ixG = 105L;
      localcu.bMH();
      AppMethodBeat.o(333206);
      return;
      l = 2L;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes10.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.utils.bl
 * JD-Core Version:    0.7.0.1
 */