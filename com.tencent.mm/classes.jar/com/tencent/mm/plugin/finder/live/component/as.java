package com.tencent.mm.plugin.finder.live.component;

import android.content.Context;
import android.graphics.Bitmap.CompressFormat;
import android.graphics.Bitmap.Config;
import android.view.View;
import android.view.Window;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.h;
import com.tencent.mm.plugin.appbrand.api.f;
import com.tencent.mm.plugin.appbrand.config.z;
import com.tencent.mm.plugin.appbrand.service.t;
import com.tencent.mm.sdk.platformtools.BitmapUtil;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.ui.MMActivity;
import kotlin.Metadata;
import kotlin.ah;
import kotlin.g.b.s;
import kotlin.n.d;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/live/component/GameWelfareTaskMiniAppHelper;", "", "()V", "SNAPSHOT_FILE", "", "SNAPSHOT_FOLDER", "TAG", "getMiniAppBundle", "Lcom/tencent/mm/plugin/appbrand/api/WeAppOpenBundle;", "appId", "path", "version", "", "extraData", "Lcom/tencent/mm/protobuf/ByteString;", "snapShot", "orientationCallback", "Lkotlin/Function1;", "", "Lkotlin/ParameterName;", "name", "isLandscape", "", "getSnapShotPath", "goMiniApp", "context", "Landroid/content/Context;", "isNeedSnapShot", "makeSnapShot", "activity", "Lcom/tencent/mm/ui/MMActivity;", "preRenderMiniApp", "plugin-finder-live_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class as
{
  public static final as CAX;
  
  static
  {
    AppMethodBeat.i(352779);
    CAX = new as();
    AppMethodBeat.o(352779);
  }
  
  private static com.tencent.mm.plugin.appbrand.api.g a(String paramString1, String paramString2, int paramInt, com.tencent.mm.bx.b paramb, String paramString3, kotlin.g.a.b<? super Boolean, ah> paramb1)
  {
    AppMethodBeat.i(352758);
    com.tencent.mm.plugin.appbrand.api.g localg = new com.tencent.mm.plugin.appbrand.api.g();
    localg.appId = paramString1;
    localg.qAF = paramString2;
    localg.euz = paramInt;
    localg.qAG = new as..ExternalSyntheticLambda1(paramb);
    localg.epq = z.raW;
    localg.ept = com.tencent.mm.plugin.appbrand.config.y.raT;
    localg.epu = com.tencent.mm.plugin.appbrand.config.y.raT;
    localg.qAY = true;
    localg.epf = true;
    localg.scene = 1205;
    localg.epr = paramString3;
    localg.eps = true;
    localg.qAK = new as..ExternalSyntheticLambda0(paramb1);
    AppMethodBeat.o(352758);
    return localg;
  }
  
  public static void a(Context paramContext, String paramString1, String paramString2, int paramInt, com.tencent.mm.bx.b paramb)
  {
    AppMethodBeat.i(352718);
    s.u(paramContext, "context");
    s.u(paramString1, "appId");
    s.u(paramString2, "path");
    Log.i("GameWelfareTaskMiniAppHelper", "#preRenderMiniApp appId=" + paramString1 + " path=" + paramString2 + " version=" + paramInt + " extraData=" + paramb);
    paramContext = a(paramString1, paramString2, paramInt, paramb, "", null);
    ((t)h.ax(t.class)).b(paramContext, (f)new as.a());
    AppMethodBeat.o(352718);
  }
  
  public static void a(Context paramContext, String paramString1, String paramString2, int paramInt, com.tencent.mm.bx.b paramb, kotlin.g.a.b<? super Boolean, ah> paramb1)
  {
    AppMethodBeat.i(352738);
    s.u(paramContext, "context");
    s.u(paramString1, "appId");
    s.u(paramString2, "path");
    Log.i("GameWelfareTaskMiniAppHelper", "#goMiniApp appId=" + paramString1 + " path=" + paramString2 + " version=" + paramInt + " extraData=" + paramb);
    if (eiU()) {
      if ((paramContext instanceof MMActivity)) {
        localObject = (MMActivity)paramContext;
      }
    }
    for (Object localObject = i((MMActivity)localObject);; localObject = "")
    {
      paramString1 = a(paramString1, paramString2, paramInt, paramb, (String)localObject, paramb1);
      ((t)h.ax(t.class)).a(paramContext, paramString1);
      AppMethodBeat.o(352738);
      return;
      localObject = null;
      break;
    }
  }
  
  private static final void a(kotlin.g.a.b paramb, Integer paramInteger)
  {
    AppMethodBeat.i(352776);
    if (paramb != null) {
      if (paramInteger != null) {
        break label32;
      }
    }
    for (boolean bool = false;; bool = true)
    {
      paramb.invoke(Boolean.valueOf(bool));
      AppMethodBeat.o(352776);
      return;
      label32:
      if (paramInteger.intValue() != 0) {
        break;
      }
    }
  }
  
  private static final String d(com.tencent.mm.bx.b paramb)
  {
    AppMethodBeat.i(352767);
    if (paramb == null)
    {
      AppMethodBeat.o(352767);
      return "";
    }
    paramb = paramb.ZV();
    AppMethodBeat.o(352767);
    return paramb;
  }
  
  public static boolean eiU()
  {
    AppMethodBeat.i(352726);
    boolean bool = ((t)h.ax(t.class)).cAy();
    AppMethodBeat.o(352726);
    return bool;
  }
  
  private static String i(MMActivity paramMMActivity)
  {
    AppMethodBeat.i(352748);
    if (paramMMActivity == null)
    {
      AppMethodBeat.o(352748);
      return "";
    }
    try
    {
      paramMMActivity = paramMMActivity.getWindow().getDecorView();
      s.s(paramMMActivity, "activity.window.decorView");
      paramMMActivity = com.tencent.mm.ui.p.a.a(paramMMActivity, paramMMActivity.getWidth(), paramMMActivity.getHeight(), false, Bitmap.Config.RGB_565);
      if (paramMMActivity != null)
      {
        Object localObject1 = new StringBuilder().append(com.tencent.mm.loader.i.b.bmr()).append("gamewelfaretaskminiapphelper/");
        Object localObject2 = com.tencent.mm.plugin.auth.a.a.cUx();
        s.s(localObject2, "username()");
        localObject2 = ((String)localObject2).getBytes(d.UTF_8);
        s.s(localObject2, "(this as java.lang.String).getBytes(charset)");
        localObject1 = com.tencent.mm.b.g.getMessageDigest((byte[])localObject2);
        if (!com.tencent.mm.vfs.y.ZC((String)localObject1)) {
          com.tencent.mm.vfs.y.bDX((String)localObject1);
        }
        localObject1 = s.X((String)localObject1, "/snapshot");
        if (com.tencent.mm.vfs.y.ZC((String)localObject1)) {
          com.tencent.mm.vfs.y.deleteFile((String)localObject1);
        }
        BitmapUtil.saveBitmapToImage(paramMMActivity, 100, Bitmap.CompressFormat.JPEG, (String)localObject1, true);
        AppMethodBeat.o(352748);
        return localObject1;
      }
    }
    finally
    {
      Log.printErrStackTrace("GameWelfareTaskMiniAppHelper", paramMMActivity, "getSnapShot err", new Object[0]);
      AppMethodBeat.o(352748);
    }
    return "";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.live.component.as
 * JD-Core Version:    0.7.0.1
 */