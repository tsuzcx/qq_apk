package com.tencent.mm.plugin.finder.utils;

import android.content.Context;
import android.content.Intent;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.am.b.a;
import com.tencent.mm.cp.f;
import com.tencent.mm.model.z;
import com.tencent.mm.plugin.expt.hellhound.core.b;
import com.tencent.mm.plugin.finder.cgi.as;
import com.tencent.mm.plugin.findersdk.a.bg;
import com.tencent.mm.plugin.findersdk.a.bg.a;
import com.tencent.mm.plugin.findersdk.a.ca.a;
import com.tencent.mm.plugin.findersdk.a.cf;
import com.tencent.mm.plugin.findersdk.a.cn;
import com.tencent.mm.plugin.secinforeport.a.d;
import com.tencent.mm.protocal.protobuf.FinderContact;
import com.tencent.mm.protocal.protobuf.FinderJumpInfo;
import com.tencent.mm.protocal.protobuf.FinderUserPageResponse;
import com.tencent.mm.protocal.protobuf.Html5Info;
import com.tencent.mm.protocal.protobuf.MiniAppInfo;
import com.tencent.mm.protocal.protobuf.etj;
import com.tencent.mm.protocal.protobuf.fby;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.Util;
import kotlin.Metadata;
import kotlin.ah;
import kotlin.g.b.s;
import kotlin.r;
import org.json.JSONObject;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/utils/FinderOpenSdkApi;", "Lcom/tencent/mm/plugin/findersdk/api/IFinderOpenSdkApi;", "()V", "TAG", "", "getFinderEventInfo", "Lkotlin/Pair;", "extraData", "openFeed", "", "context", "Landroid/content/Context;", "appid", "feedId", "nonceId", "notGetRelatedList", "openLive", "openProfile", "username", "requestFinderContact", "finderUserName", "callback", "Lcom/tencent/mm/plugin/findersdk/api/IFinderOpenSdkApi$CgiCallback;", "shareVideo", "path", "desc", "extendingUrl", "jumpJson", "plugin-finder_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class ab
  implements bg
{
  public static final ab Ghc;
  private static final String TAG;
  
  static
  {
    AppMethodBeat.i(333521);
    Ghc = new ab();
    TAG = "Finder.FinderOpenSdkApi";
    AppMethodBeat.o(333521);
  }
  
  private static final ah a(bg.a parama, b.a parama1)
  {
    AppMethodBeat.i(333515);
    if ((parama1.errType == 0) && (parama1.errCode == 0))
    {
      if (parama == null)
      {
        AppMethodBeat.o(333515);
        return null;
      }
      parama.h(parama1.errType, parama1.errCode, ((FinderUserPageResponse)parama1.ott).contact);
      parama = ah.aiuX;
      AppMethodBeat.o(333515);
      return parama;
    }
    if (parama == null)
    {
      AppMethodBeat.o(333515);
      return null;
    }
    parama.h(parama1.errType, parama1.errCode, null);
    parama = ah.aiuX;
    AppMethodBeat.o(333515);
    return parama;
  }
  
  private static final ah a(String paramString, Context paramContext, b.a parama)
  {
    AppMethodBeat.i(333493);
    s.u(paramString, "$appid");
    Object localObject;
    int i;
    label65:
    String str;
    if ((parama.errType == 0) && (parama.errCode == 0))
    {
      parama = ((FinderUserPageResponse)parama.ott).contact;
      if (parama != null) {
        break label209;
      }
      parama = null;
      localObject = (CharSequence)parama;
      if ((localObject != null) && (((CharSequence)localObject).length() != 0)) {
        break label217;
      }
      i = 1;
      if (i != 0) {
        break label229;
      }
      Log.i(TAG, s.X("realUsername:", parama));
      Intent localIntent = new Intent();
      localIntent.putExtra("finder_username", parama);
      localIntent.putExtra("key_extra_info", paramString);
      str = ((cn)com.tencent.mm.kernel.h.az(cn.class)).fillContextIdToIntent(11, 8, 32, localIntent);
      if (!Util.isNullOrNil(paramString))
      {
        com.tencent.mm.plugin.report.service.h localh = com.tencent.mm.plugin.report.service.h.OAn;
        if (str != null) {
          break label222;
        }
        localObject = "";
        label152:
        localh.b(21140, new Object[] { localObject, paramString, Integer.valueOf(0), parama });
      }
      b.aqZ(str);
      a.GfO.enterFinderProfileUI(paramContext, localIntent);
    }
    for (;;)
    {
      paramString = ah.aiuX;
      AppMethodBeat.o(333493);
      return paramString;
      label209:
      parama = parama.username;
      break;
      label217:
      i = 0;
      break label65;
      label222:
      localObject = str;
      break label152;
      label229:
      Log.i(TAG, "realUsername empty");
    }
  }
  
  private static r<String, String> aBA(String paramString)
  {
    localObject2 = null;
    AppMethodBeat.i(333484);
    if (paramString != null) {}
    try
    {
      localObject1 = new JSONObject(paramString).optJSONObject("finderEventInfo");
      if (localObject1 != null) {
        break label38;
      }
      paramString = localObject2;
    }
    catch (Exception paramString)
    {
      for (;;)
      {
        Object localObject1;
        paramString = localObject2;
      }
    }
    AppMethodBeat.o(333484);
    return paramString;
    label38:
    paramString = ((JSONObject)localObject1).optString("finderNickname");
    if (paramString == null) {
      paramString = "";
    }
    for (;;)
    {
      String str = ((JSONObject)localObject1).optString("eventName");
      localObject1 = str;
      if (str == null) {
        localObject1 = "";
      }
      paramString = new r(paramString, localObject1);
      break;
    }
    AppMethodBeat.o(333484);
    return null;
  }
  
  private static final void d(Void paramVoid)
  {
    AppMethodBeat.i(333509);
    Log.i(TAG, "openLive succ");
    AppMethodBeat.o(333509);
  }
  
  private static final void s(Integer paramInteger)
  {
    AppMethodBeat.i(333503);
    Log.i(TAG, s.X("openLive failed, errCode: ", paramInteger));
    AppMethodBeat.o(333503);
  }
  
  public final void F(Context paramContext, String paramString1, String paramString2)
  {
    AppMethodBeat.i(333581);
    s.u(paramString1, "appid");
    s.u(paramString2, "username");
    if (paramContext == null)
    {
      Log.i(TAG, "openProfile context null");
      AppMethodBeat.o(333581);
      return;
    }
    Log.i(TAG, "openProfile appid:" + paramString1 + ", username:" + paramString2);
    new as(paramString2).bFJ().g(new ab..ExternalSyntheticLambda3(paramString1, paramContext));
    AppMethodBeat.o(333581);
  }
  
  public final void a(String paramString, bg.a parama)
  {
    AppMethodBeat.i(333608);
    CharSequence localCharSequence = (CharSequence)paramString;
    if ((localCharSequence == null) || (localCharSequence.length() == 0)) {}
    for (int i = 1; i != 0; i = 0)
    {
      AppMethodBeat.o(333608);
      return;
    }
    Log.i(TAG, s.X("getFinderContact username:", paramString));
    new as(paramString).bFJ().g(new ab..ExternalSyntheticLambda2(parama));
    AppMethodBeat.o(333608);
  }
  
  public final void b(Context paramContext, String paramString1, String paramString2, String paramString3, String paramString4)
  {
    AppMethodBeat.i(333602);
    s.u(paramString1, "appid");
    s.u(paramString2, "feedId");
    s.u(paramString3, "nonceId");
    if (paramContext == null)
    {
      Log.i(TAG, "openFeed context null");
      AppMethodBeat.o(333602);
      return;
    }
    Log.i(TAG, "openFeed appid:" + paramString1 + ", feedId:" + paramString2 + ", nonceId:" + paramString3 + ", notGetRelatedList:" + paramString4);
    boolean bool = s.p(paramString4, "0");
    Intent localIntent = new Intent();
    localIntent.putExtra("from_user", z.bAM());
    localIntent.putExtra("feed_encrypted_object_id", paramString2);
    localIntent.putExtra("feed_object_nonceId", paramString3);
    localIntent.putExtra("key_need_related_list", bool);
    localIntent.putExtra("key_comment_scene", 39);
    localIntent.putExtra("key_reuqest_scene", 0);
    localIntent.putExtra("key_session_id", "");
    localIntent.putExtra("key_extra_info", "");
    paramString4 = ((cn)com.tencent.mm.kernel.h.az(cn.class)).fillContextIdToIntent(11, 8, 39, localIntent);
    if (!Util.isNullOrNil(paramString1))
    {
      com.tencent.mm.plugin.report.service.h localh = com.tencent.mm.plugin.report.service.h.OAn;
      paramString3 = paramString4;
      if (paramString4 == null) {
        paramString3 = "";
      }
      localh.b(21140, new Object[] { paramString3, paramString1, paramString2, "" });
    }
    localIntent.putExtra("report_scene", 0);
    localIntent.putExtra("tab_type", 9);
    paramString1 = com.tencent.mm.plugin.findersdk.d.a.Hdr;
    if (com.tencent.mm.plugin.findersdk.d.a.aDh("entrance") != 0)
    {
      paramString1 = a.GfO;
      a.hc(paramContext);
      AppMethodBeat.o(333602);
      return;
    }
    paramString1 = a.GfO;
    a.Y(paramContext, localIntent);
    paramContext = d.Pmb;
    d.asyncReportFinderSecurityInfoThroughCgi(540999685);
    AppMethodBeat.o(333602);
  }
  
  public final void c(String paramString1, String paramString2, String paramString3, String paramString4, String paramString5, String paramString6)
  {
    AppMethodBeat.i(333571);
    s.u(paramString1, "appid");
    s.u(paramString2, "path");
    s.u(paramString3, "desc");
    s.u(paramString4, "extendingUrl");
    JSONObject localJSONObject = new JSONObject();
    am localam = am.GhD;
    localJSONObject.put(am.ffm(), paramString2);
    paramString2 = am.GhD;
    localJSONObject.put(am.ffn(), "");
    paramString2 = am.GhD;
    localJSONObject.put(am.ffo(), 1);
    paramString2 = am.GhD;
    localJSONObject.put(am.ffp(), "");
    paramString2 = am.GhD;
    localJSONObject.put(am.ffs(), paramString3);
    paramString2 = am.GhD;
    localJSONObject.put(am.fft(), paramString4);
    if (paramString5 != null) {}
    for (;;)
    {
      try
      {
        Log.i(TAG, s.X("jump json:", paramString5));
        paramString2 = new FinderJumpInfo();
        paramString3 = new JSONObject(paramString5);
        paramString2.jumpinfo_type = paramString3.getInt("jumpType");
        paramString2.wording = paramString3.optString("wording");
        paramString2.icon_url = paramString3.getString("iconurl");
        paramString2.report_info = paramString3.optString("reportInfo");
        if (paramString3.has("miniAppInfo"))
        {
          paramString5 = paramString3.getJSONObject("miniAppInfo");
          paramString4 = new MiniAppInfo();
          paramString4.path = paramString5.optString("path");
          paramString4.appusername = paramString5.getString("appusername");
          paramString5 = ah.aiuX;
          paramString2.mini_app_info = paramString4;
        }
        if (paramString3.has("html5Info"))
        {
          paramString4 = paramString3.getJSONObject("html5Info");
          paramString3 = new Html5Info();
          paramString3.url = paramString4.optString("url");
          paramString3.style = 1;
          paramString4 = ah.aiuX;
          paramString2.html5_info = paramString3;
        }
        paramString2.source = 2;
        paramString6 = aBA(paramString6);
        paramString3 = new Intent();
        paramString4 = new fby();
        paramString4.DnR = 2;
        paramString5 = new etj();
        paramString5.businessType = "";
        paramString5.appid = paramString1;
        paramString5.extInfo = localJSONObject.toString();
        paramString5.BrJ = true;
        paramString5.hVf = paramString2;
        if (paramString6 != null)
        {
          paramString5.abwI = ((String)paramString6.bsC);
          paramString5.eventName = ((String)paramString6.bsD);
        }
        paramString1 = ah.aiuX;
        paramString4.abBz = paramString5;
        paramString3.putExtra("KEY_POST_FROM_SHARE", paramString4.toByteArray());
        paramString1 = a.GfO;
        paramString1 = MMApplicationContext.getContext();
        s.s(paramString1, "getContext()");
        a.R(paramString1, paramString3);
        AppMethodBeat.o(333571);
        return;
      }
      finally
      {
        Log.printErrStackTrace(TAG, paramString2, "shareVideo", new Object[0]);
      }
      paramString2 = null;
    }
  }
  
  public final void g(Context paramContext, String paramString1, String paramString2, String paramString3)
  {
    AppMethodBeat.i(333588);
    s.u(paramString1, "appid");
    s.u(paramString2, "feedId");
    s.u(paramString3, "nonceId");
    if (paramContext == null)
    {
      Log.i(TAG, "openLive context null");
      AppMethodBeat.o(333588);
      return;
    }
    Log.i(TAG, "openLive appid:" + paramString1 + ", feedId:" + paramString2 + ", nonceId:" + paramString3);
    String str = ((cn)com.tencent.mm.kernel.h.az(cn.class)).genContextId(11, 8, 65);
    Object localObject;
    if (!Util.isNullOrNil(new String[0]))
    {
      localObject = com.tencent.mm.plugin.report.service.h.OAn;
      if (str != null) {
        break label243;
      }
    }
    label243:
    for (paramContext = "";; paramContext = str)
    {
      ((com.tencent.mm.plugin.report.service.h)localObject).b(21140, new Object[] { paramContext, paramString1, "", "" });
      ((cf)com.tencent.mm.kernel.h.ax(cf.class)).axt(paramString1);
      b.aqZ(str);
      paramContext = new ax();
      localObject = ab..ExternalSyntheticLambda0.INSTANCE;
      ab..ExternalSyntheticLambda1 localExternalSyntheticLambda1 = ab..ExternalSyntheticLambda1.INSTANCE;
      s.s(str, "contextId");
      ax.a(paramContext, "", paramString2, (ca.a)localObject, paramString3, 0L, localExternalSyntheticLambda1, str, paramString1, null, 0L, null, null, 3840);
      AppMethodBeat.o(333588);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.utils.ab
 * JD-Core Version:    0.7.0.1
 */