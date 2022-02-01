package com.tencent.mm.plugin.finder.utils;

import android.content.Context;
import android.content.Intent;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.cw.f;
import com.tencent.mm.model.z;
import com.tencent.mm.plugin.expt.hellhound.core.b;
import com.tencent.mm.plugin.finder.cgi.ac;
import com.tencent.mm.plugin.finder.live.report.m;
import com.tencent.mm.plugin.findersdk.a.ag.a;
import com.tencent.mm.plugin.findersdk.a.ak;
import com.tencent.mm.plugin.findersdk.a.x;
import com.tencent.mm.plugin.secinforeport.a.d;
import com.tencent.mm.protocal.protobuf.ead;
import com.tencent.mm.protocal.protobuf.ehy;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.Util;
import kotlin.g.b.p;
import kotlin.l;
import org.json.JSONObject;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/finder/utils/FinderOpenSdkApi;", "Lcom/tencent/mm/plugin/findersdk/api/IFinderOpenSdkApi;", "()V", "TAG", "", "openFeed", "", "context", "Landroid/content/Context;", "appid", "feedId", "nonceId", "notGetRelatedList", "openLive", "openProfile", "username", "shareVideo", "path", "desc", "extendingUrl", "plugin-finder_release"})
public final class u
  implements x
{
  public static final u ADR;
  private static final String TAG = "Finder.FinderOpenSdkApi";
  
  static
  {
    AppMethodBeat.i(270931);
    ADR = new u();
    TAG = "Finder.FinderOpenSdkApi";
    AppMethodBeat.o(270931);
  }
  
  public final void D(final Context paramContext, String paramString1, String paramString2)
  {
    AppMethodBeat.i(270928);
    p.k(paramString1, "appid");
    p.k(paramString2, "username");
    if (paramContext == null)
    {
      Log.i(TAG, "openProfile context null");
      AppMethodBeat.o(270928);
      return;
    }
    Log.i(TAG, "openProfile appid:" + paramString1 + ", username:" + paramString2);
    new ac(paramString2).bhW().g((com.tencent.mm.vending.c.a)new c(paramString1, paramContext));
    AppMethodBeat.o(270928);
  }
  
  public final void b(Context paramContext, String paramString1, String paramString2, String paramString3, String paramString4)
  {
    AppMethodBeat.i(270930);
    p.k(paramString1, "appid");
    p.k(paramString2, "feedId");
    p.k(paramString3, "nonceId");
    if (paramContext == null)
    {
      Log.i(TAG, "openFeed context null");
      AppMethodBeat.o(270930);
      return;
    }
    Log.i(TAG, "openFeed appid:" + paramString1 + ", feedId:" + paramString2 + ", nonceId:" + paramString3 + ", notGetRelatedList:" + paramString4);
    boolean bool = p.h(paramString4, "0");
    Intent localIntent = new Intent();
    localIntent.putExtra("from_user", z.bcZ());
    localIntent.putExtra("feed_encrypted_object_id", paramString2);
    localIntent.putExtra("feed_object_nonceId", paramString3);
    localIntent.putExtra("key_need_related_list", bool);
    localIntent.putExtra("key_comment_scene", 39);
    localIntent.putExtra("key_reuqest_scene", 0);
    localIntent.putExtra("key_session_id", "");
    localIntent.putExtra("key_extra_info", "");
    paramString4 = ((ak)com.tencent.mm.kernel.h.ag(ak.class)).fillContextIdToIntent(11, 8, 39, localIntent);
    if (!Util.isNullOrNil(paramString1))
    {
      com.tencent.mm.plugin.report.service.h localh = com.tencent.mm.plugin.report.service.h.IzE;
      paramString3 = paramString4;
      if (paramString4 == null) {
        paramString3 = "";
      }
      localh.a(21140, new Object[] { paramString3, paramString1, paramString2, "" });
    }
    localIntent.putExtra("report_scene", 0);
    localIntent.putExtra("tab_type", 9);
    paramString1 = com.tencent.mm.plugin.findersdk.c.a.Bwg;
    if (com.tencent.mm.plugin.findersdk.c.a.aGQ("entrance") != 0)
    {
      paramString1 = a.ACH;
      a.fI(paramContext);
      AppMethodBeat.o(270930);
      return;
    }
    paramString1 = a.ACH;
    a.E(paramContext, localIntent);
    paramContext = d.Jcm;
    d.asyncReportFinderSecurityInfoThroughCgi(540999685);
    AppMethodBeat.o(270930);
  }
  
  public final void f(Context paramContext, String paramString1, String paramString2, String paramString3)
  {
    AppMethodBeat.i(270929);
    p.k(paramString1, "appid");
    p.k(paramString2, "feedId");
    p.k(paramString3, "nonceId");
    if (paramContext == null)
    {
      Log.i(TAG, "openLive context null");
      AppMethodBeat.o(270929);
      return;
    }
    Log.i(TAG, "openLive appid:" + paramString1 + ", feedId:" + paramString2 + ", nonceId:" + paramString3);
    String str = ((ak)com.tencent.mm.kernel.h.ag(ak.class)).genContextId(11, 8, 65);
    Object localObject;
    if (!Util.isNullOrNil(new String[0]))
    {
      localObject = com.tencent.mm.plugin.report.service.h.IzE;
      if (str != null) {
        break label228;
      }
    }
    label228:
    for (paramContext = "";; paramContext = str)
    {
      ((com.tencent.mm.plugin.report.service.h)localObject).a(21140, new Object[] { paramContext, paramString1, "", "" });
      paramContext = m.yCt;
      m.aCA(paramString1);
      b.awV(str);
      paramContext = new al();
      localObject = (ag.a)a.ADS;
      ag.a locala = (ag.a)b.ADT;
      p.j(str, "contextId");
      al.a(paramContext, "", paramString2, (ag.a)localObject, paramString3, 0L, locala, str, paramString1, 256);
      AppMethodBeat.o(270929);
      return;
    }
  }
  
  public final void v(String paramString1, String paramString2, String paramString3, String paramString4)
  {
    AppMethodBeat.i(270927);
    p.k(paramString1, "appid");
    p.k(paramString2, "path");
    p.k(paramString3, "desc");
    p.k(paramString4, "extendingUrl");
    JSONObject localJSONObject = new JSONObject();
    ab localab = ab.AEA;
    localJSONObject.put(ab.edu(), paramString2);
    paramString2 = ab.AEA;
    localJSONObject.put(ab.edv(), "");
    paramString2 = ab.AEA;
    localJSONObject.put(ab.edw(), 1);
    paramString2 = ab.AEA;
    localJSONObject.put(ab.edx(), "");
    paramString2 = ab.AEA;
    localJSONObject.put(ab.edA(), paramString3);
    paramString2 = ab.AEA;
    localJSONObject.put(ab.edB(), paramString4);
    paramString2 = new Intent();
    paramString3 = new ehy();
    paramString3.yAT = 2;
    paramString4 = new ead();
    paramString4.businessType = "";
    paramString4.appid = paramString1;
    paramString4.extInfo = localJSONObject.toString();
    paramString4.xSm = true;
    paramString3.UjV = paramString4;
    paramString2.putExtra("KEY_POST_FROM_SHARE", paramString3.toByteArray());
    paramString1 = a.ACH;
    paramString1 = MMApplicationContext.getContext();
    p.j(paramString1, "MMApplicationContext.getContext()");
    a.x(paramString1, paramString2);
    AppMethodBeat.o(270927);
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "ret", "", "kotlin.jvm.PlatformType", "onCallback", "(Ljava/lang/Integer;)V"})
  static final class a<T>
    implements ag.a<Integer>
  {
    public static final a ADS;
    
    static
    {
      AppMethodBeat.i(286217);
      ADS = new a();
      AppMethodBeat.o(286217);
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "it", "Ljava/lang/Void;", "kotlin.jvm.PlatformType", "onCallback"})
  static final class b<T>
    implements ag.a<Void>
  {
    public static final b ADT;
    
    static
    {
      AppMethodBeat.i(292100);
      ADT = new b();
      AppMethodBeat.o(292100);
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "it", "Lcom/tencent/mm/modelbase/Cgi$CgiBack;", "Lcom/tencent/mm/protocal/protobuf/FinderUserPageResponse;", "kotlin.jvm.PlatformType", "call"})
  static final class c<_Ret, _Var>
    implements com.tencent.mm.vending.c.a<_Ret, _Var>
  {
    c(String paramString, Context paramContext) {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.utils.u
 * JD-Core Version:    0.7.0.1
 */