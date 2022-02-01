package com.tencent.mm.plugin.expt.hellhound.a.f.b;

import android.app.Activity;
import android.text.TextUtils;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.expt.hellhound.a.f.c.i;
import com.tencent.mm.protocal.protobuf.bge;
import com.tencent.mm.protocal.protobuf.bxx;
import com.tencent.mm.protocal.protobuf.cqh;
import com.tencent.mm.protocal.protobuf.cqi;
import com.tencent.mm.protocal.protobuf.cqj;
import com.tencent.mm.protocal.protobuf.cqk;
import com.tencent.mm.protocal.protobuf.cqm;
import com.tencent.mm.protocal.protobuf.cqq;
import com.tencent.mm.protocal.protobuf.cqt;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.bt;
import d.a.j;
import d.g.b.k;
import d.l;
import d.n.n;
import d.v;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

@l(fvt={1, 1, 16}, fvu={""}, fvv={"Lcom/tencent/mm/plugin/expt/hellhound/ext/session/config/HellKSessionConfig;", "", "()V", "Companion", "plugin-expt_release"})
public final class b
{
  private static final List<i> pHp;
  public static final a pHq;
  
  static
  {
    AppMethodBeat.i(122602);
    pHq = new a((byte)0);
    pHp = j.listOf(new i[] { new i("999", com.tencent.mm.plugin.expt.hellhound.core.b.pDZ, (List)j.Z(new String[] { "ChattingUIFragment", "ChattingUI" })), new i("998", com.tencent.mm.plugin.expt.hellhound.core.b.pDZ, (List)j.Z(new String[] { "BizConversationUI" })), new i("104", com.tencent.mm.plugin.expt.hellhound.core.b.pDZ, (List)j.Z(new String[] { "BizTimeLineUI" })), new i("105", com.tencent.mm.plugin.expt.hellhound.core.b.pDZ, (List)j.Z(new String[] { "AppBrandLaunchProxyUI", "AppBrandUI", "AppBrandUI1", "AppBrandUI2", "AppBrandUI3", "AppBrandUI4" })), new i("105", com.tencent.mm.plugin.expt.hellhound.core.b.pDZ, (List)j.Z(new String[] { "AppBrandUI", "AppBrandUI1", "AppBrandUI2", "AppBrandUI3", "AppBrandUI4" })), new i("105", "LauncherUI", (List)j.Z(new String[] { "AppBrandLaunchProxyUI", "AppBrandUI", "AppBrandUI1", "AppBrandUI2", "AppBrandUI3", "AppBrandUI4" })), new i("105", "LauncherUI", (List)j.Z(new String[] { "AppBrandUI", "AppBrandUI1", "AppBrandUI2", "AppBrandUI3", "AppBrandUI4" })), new i("105", com.tencent.mm.plugin.expt.hellhound.core.b.pDZ, (List)j.Z(new String[] { "AppBrandLauncherUI" })), new i("105", "LauncherUI", (List)j.Z(new String[] { "AppBrandLauncherUI" })), new i("105", "WXShortcutEntryActivity", (List)j.Z(new String[] { "AppBrandLaunchProxyUI", "AppBrandUI", "AppBrandUI1", "AppBrandUI2", "AppBrandUI3", "AppBrandUI4" })), new i("105", com.tencent.mm.plugin.expt.hellhound.core.b.pEa, (List)j.Z(new String[] { "AppBrandLaunchProxyUI", "AppBrandUI", "AppBrandUI1", "AppBrandUI2", "AppBrandUI3", "AppBrandUI4" })), new i("105", com.tencent.mm.plugin.expt.hellhound.core.b.pEb, (List)j.Z(new String[] { "AppBrandLaunchProxyUI", "AppBrandUI", "AppBrandUI1", "AppBrandUI2", "AppBrandUI3", "AppBrandUI4" })), new i("105", com.tencent.mm.plugin.expt.hellhound.core.b.pEc, (List)j.Z(new String[] { "AppBrandLaunchProxyUI", "AppBrandUI", "AppBrandUI1", "AppBrandUI2", "AppBrandUI3", "AppBrandUI4" })), new i("113", com.tencent.mm.plugin.expt.hellhound.core.b.pDZ, (List)j.Z(new String[] { "ReaderAppUI" })), new i("114", com.tencent.mm.plugin.expt.hellhound.core.b.pEa, (List)j.Z(new String[] { "FTSMainUI" })), new i("147", com.tencent.mm.plugin.expt.hellhound.core.b.pEb, (List)j.Z(new String[] { "FTSMainUI" })), new i("115", com.tencent.mm.plugin.expt.hellhound.core.b.pEa, (List)j.Z(new String[] { "AddMoreFriendsUI" })), new i("116", com.tencent.mm.plugin.expt.hellhound.core.b.pEa, (List)j.Z(new String[] { "FMessageConversationUI" })), new i("117", com.tencent.mm.plugin.expt.hellhound.core.b.pEa, (List)j.Z(new String[] { "ChatroomContactUI" })), new i("118", com.tencent.mm.plugin.expt.hellhound.core.b.pEa, (List)j.Z(new String[] { "ContactLabelManagerUI" })), new i("106", com.tencent.mm.plugin.expt.hellhound.core.b.pDZ, (List)j.Z(new String[] { "FTSMainUI" })), new i("107", com.tencent.mm.plugin.expt.hellhound.core.b.pDZ, (List)j.Z(new String[] { "SelectContactUI" })), new i("107", com.tencent.mm.plugin.expt.hellhound.core.b.pEa, (List)j.Z(new String[] { "SelectContactUI" })), new i("107", com.tencent.mm.plugin.expt.hellhound.core.b.pEb, (List)j.Z(new String[] { "SelectContactUI" })), new i("108", com.tencent.mm.plugin.expt.hellhound.core.b.pDZ, (List)j.Z(new String[] { "AddMoreFriendsUI" })), new i("108", com.tencent.mm.plugin.expt.hellhound.core.b.pEa, (List)j.Z(new String[] { "AddMoreFriendsUI" })), new i("108", com.tencent.mm.plugin.expt.hellhound.core.b.pEb, (List)j.Z(new String[] { "AddMoreFriendsUI" })), new i("109", com.tencent.mm.plugin.expt.hellhound.core.b.pDZ, (List)j.Z(new String[] { "BaseScanUI" })), new i("109", com.tencent.mm.plugin.expt.hellhound.core.b.pEa, (List)j.Z(new String[] { "BaseScanUI" })), new i("109", com.tencent.mm.plugin.expt.hellhound.core.b.pEb, (List)j.Z(new String[] { "BaseScanUI" })), new i("110", com.tencent.mm.plugin.expt.hellhound.core.b.pDZ, (List)j.Z(new String[] { "WalletOfflineEntranceUI" })), new i("110", com.tencent.mm.plugin.expt.hellhound.core.b.pEa, (List)j.Z(new String[] { "WalletOfflineEntranceUI" })), new i("110", com.tencent.mm.plugin.expt.hellhound.core.b.pEb, (List)j.Z(new String[] { "WalletOfflineEntranceUI" })), new i("119", com.tencent.mm.plugin.expt.hellhound.core.b.pEa, (List)j.Z(new String[] { "BrandServiceIndexUI" })), new i("120", com.tencent.mm.plugin.expt.hellhound.core.b.pEa, (List)j.Z(new String[] { "EnterpriseBizContactListUI" })), new i("121", "AddressUIFragment", (List)j.Z(new String[] { "OpenIMAddressUI" })), new i("122", "AddressUIFragment", (List)j.Z(new String[] { "ContactInfoUI" })), new i("123", com.tencent.mm.plugin.expt.hellhound.core.b.pEb, (List)j.Z(new String[] { "SnsTimeLineUI" })), new i("124", com.tencent.mm.plugin.expt.hellhound.core.b.pEb, (List)j.Z(new String[] { "BaseScanUI" })), new i("125", com.tencent.mm.plugin.expt.hellhound.core.b.pEb, (List)j.Z(new String[] { "ShakeReportUI" })), new i("126", com.tencent.mm.plugin.expt.hellhound.core.b.pEb, (List)j.Z(new String[] { "TopStoryHomeUI" })), new i("127", com.tencent.mm.plugin.expt.hellhound.core.b.pEb, (List)j.Z(new String[] { "FTSSOSHomeWebViewUI" })), new i("128", com.tencent.mm.plugin.expt.hellhound.core.b.pEb, (List)j.Z(new String[] { "NearbyFriendsIntroUI", "NearbyFriendsUI", "NearbyPersonalInfoUI", "NearbyFriendShowSayHiUI" })), new i("129", com.tencent.mm.plugin.expt.hellhound.core.b.pEb, (List)j.Z(new String[] { "BottleBeachUI" })), new i("130", com.tencent.mm.plugin.expt.hellhound.core.b.pEb, (List)j.Z(new String[] { "AppBrandPluginUI" })), new i("131", com.tencent.mm.plugin.expt.hellhound.core.b.pEb, (List)j.Z(new String[] { "WebViewUI", "1", "jd_store" })), new i("131", com.tencent.mm.plugin.expt.hellhound.core.b.pEb, (List)j.Z(new String[] { "AppBrandLaunchProxyUI", "AppBrandUI", "AppBrandUI1", "AppBrandUI2", "AppBrandUI3", "AppBrandUI4" })), new i("132", com.tencent.mm.plugin.expt.hellhound.core.b.pEb, (List)j.Z(new String[] { "GameWebViewUI" })), new i("132", com.tencent.mm.plugin.expt.hellhound.core.b.pEb, (List)j.Z(new String[] { "GameCenterUI" })), new i("132", com.tencent.mm.plugin.expt.hellhound.core.b.pEb, (List)j.Z(new String[] { "LuggageGameWebViewUI" })), new i("132", com.tencent.mm.plugin.expt.hellhound.core.b.pEb, (List)j.Z(new String[] { "GameWebViewMpUI" })), new i("132", com.tencent.mm.plugin.expt.hellhound.core.b.pEb, (List)j.Z(new String[] { "LuggageGameWebViewMpUI" })), new i("133", com.tencent.mm.plugin.expt.hellhound.core.b.pEb, (List)j.Z(new String[] { "AppBrandLauncherUI" })), new i("134", com.tencent.mm.plugin.expt.hellhound.core.b.pEc, (List)j.Z(new String[] { "SettingsPersonalInfoUI" })), new i("135", com.tencent.mm.plugin.expt.hellhound.core.b.pEc, (List)j.Z(new String[] { "MallIndexUI" })), new i("136", com.tencent.mm.plugin.expt.hellhound.core.b.pEc, (List)j.Z(new String[] { "FavoriteIndexUI" })), new i("137", com.tencent.mm.plugin.expt.hellhound.core.b.pEc, (List)j.Z(new String[] { "SnsUserUI", "AlbumUI" })), new i("138", com.tencent.mm.plugin.expt.hellhound.core.b.pEc, (List)j.Z(new String[] { "CardHomePageNewUI", "CardHomePageUI", "CardIndexUI", "CardInvalidCardUI", "CardViewUI", "ShareCardListUI" })), new i("139", "MoreTabUI", (List)j.Z(new String[] { "EmojiStoreV2UI", "MMFlutterActivity" })), new i("140", "MoreTabUI", (List)j.Z(new String[] { "SettingsUI" })), new i("141", "MoreTabUI", (List)j.Z(new String[] { "StoryCaptureUI", "MMRecordUI" })), new i("142", "MoreTabUI", (List)j.Z(new String[] { "StoryGalleryView", "StoryVideoView" })), new i("143", "FindMoreFriendsUI", (List)j.Z(new String[] { "FinderTimelineUI" })), new i("143", "FindMoreFriendsUI", (List)j.Z(new String[] { "FinderHomeUI" })), new i("143", "FindMoreFriendsUI", (List)j.Z(new String[] { "FinderConversationUI" })), new i("143", "AddressUIFragment", (List)j.Z(new String[] { "FinderTimelineUI" })), new i("145", "LauncherUI", (List)j.Z(new String[] { "FloatingBall" })), new i("146", "LauncherUI", (List)j.Z(new String[] { "VideoActivity" })) });
    AppMethodBeat.o(122602);
  }
  
  public static final boolean WA(String paramString)
  {
    AppMethodBeat.i(122611);
    if (paramString == null)
    {
      AppMethodBeat.o(122611);
      return false;
    }
    boolean bool = k.g("105", a.Wv(paramString));
    AppMethodBeat.o(122611);
    return bool;
  }
  
  public static final boolean WB(String paramString)
  {
    AppMethodBeat.i(122612);
    if (paramString == null)
    {
      AppMethodBeat.o(122612);
      return false;
    }
    boolean bool = k.g("145", a.Wv(paramString));
    AppMethodBeat.o(122612);
    return bool;
  }
  
  public static final boolean WC(String paramString)
  {
    AppMethodBeat.i(122613);
    if (paramString == null)
    {
      AppMethodBeat.o(122613);
      return false;
    }
    boolean bool = k.g("146", a.Wv(paramString));
    AppMethodBeat.o(122613);
    return bool;
  }
  
  public static final boolean WD(String paramString)
  {
    AppMethodBeat.i(122614);
    if (paramString == null)
    {
      AppMethodBeat.o(122614);
      return false;
    }
    paramString = a.Wv(paramString);
    if ((k.g("999", paramString)) || (a.Wz(paramString)))
    {
      AppMethodBeat.o(122614);
      return true;
    }
    AppMethodBeat.o(122614);
    return false;
  }
  
  public static final boolean WE(String paramString)
  {
    AppMethodBeat.i(122615);
    k.h(paramString, "sid");
    boolean bool = k.g("131", paramString);
    AppMethodBeat.o(122615);
    return bool;
  }
  
  public static final List<cqt> WF(String paramString)
  {
    AppMethodBeat.i(122616);
    if (paramString != null) {
      if (((CharSequence)paramString).length() != 0) {
        break label36;
      }
    }
    label36:
    for (int i = 1; i != 0; i = 0)
    {
      AppMethodBeat.o(122616);
      return null;
    }
    k.g(d.ccX(), "HellSessionPageCloudConfig.getInstance()");
    Object localObject = d.ccY();
    if (localObject == null)
    {
      AppMethodBeat.o(122616);
      return null;
    }
    ArrayList localArrayList = new ArrayList();
    Iterator localIterator = ((cqq)localObject).EjB.iterator();
    while (localIterator.hasNext())
    {
      cqt localcqt = (cqt)localIterator.next();
      if ((localcqt != null) && (localcqt.type == 0) && ((!(k.g(localcqt.pZX, paramString) ^ true)) || (!(k.g(localcqt.pZX, "-1") ^ true))))
      {
        localObject = localcqt;
        if (!localcqt.qHI) {
          localObject = null;
        }
        if (localObject != null) {
          localArrayList.add(localObject);
        }
      }
    }
    paramString = (List)localArrayList;
    AppMethodBeat.o(122616);
    return paramString;
  }
  
  public static final Long WG(String paramString)
  {
    AppMethodBeat.i(122618);
    paramString = a.WG(paramString);
    AppMethodBeat.o(122618);
    return paramString;
  }
  
  public static final String WH(String paramString)
  {
    AppMethodBeat.i(185599);
    paramString = a.WH(paramString);
    AppMethodBeat.o(185599);
    return paramString;
  }
  
  public static final String WI(String paramString)
  {
    AppMethodBeat.i(190933);
    if (paramString == null)
    {
      AppMethodBeat.o(190933);
      return null;
    }
    if (n.a((CharSequence)paramString, (CharSequence)"_", false))
    {
      paramString = n.a((CharSequence)paramString, new String[] { "_" });
      paramString = a.WH((String)paramString.get(0)) + "_" + (String)paramString.get(1);
      AppMethodBeat.o(190933);
      return paramString;
    }
    AppMethodBeat.o(190933);
    return paramString;
  }
  
  public static final boolean WJ(String paramString)
  {
    AppMethodBeat.i(185600);
    if (paramString == null)
    {
      AppMethodBeat.o(185600);
      return false;
    }
    if (n.a((CharSequence)paramString, (CharSequence)"_", false))
    {
      bool = a.WK((String)n.a((CharSequence)paramString, new String[] { "_" }).get(0));
      AppMethodBeat.o(185600);
      return bool;
    }
    boolean bool = a.WK(paramString);
    AppMethodBeat.o(185600);
    return bool;
  }
  
  public static final String Wv(String paramString)
  {
    AppMethodBeat.i(122604);
    paramString = a.Wv(paramString);
    AppMethodBeat.o(122604);
    return paramString;
  }
  
  public static final String Ww(String paramString)
  {
    AppMethodBeat.i(122605);
    k.h(paramString, "pageId");
    List localList = n.a((CharSequence)paramString, new String[] { "_" });
    if (localList.size() < 2)
    {
      AppMethodBeat.o(122605);
      return paramString;
    }
    paramString = (String)localList.get(0);
    AppMethodBeat.o(122605);
    return paramString;
  }
  
  public static final com.tencent.mm.vending.j.c<String, String> Wx(String paramString)
  {
    AppMethodBeat.i(177417);
    paramString = a.Wx(paramString);
    AppMethodBeat.o(177417);
    return paramString;
  }
  
  public static final void Wy(String paramString)
  {
    AppMethodBeat.i(177418);
    if (paramString == null)
    {
      AppMethodBeat.o(177418);
      return;
    }
    bxx localbxx = com.tencent.mm.plugin.expt.hellhound.a.f.c.c.cdh();
    if (localbxx == null)
    {
      AppMethodBeat.o(177418);
      return;
    }
    com.tencent.mm.vending.j.c localc = a.Wx(localbxx.sessionId);
    if (localc == null)
    {
      AppMethodBeat.o(177418);
      return;
    }
    ad.i("HABBYGE-MALI.HellKSessionConfig", "HellK, updateCurSid, old: " + localbxx.sessionId);
    paramString = paramString + "_" + localc.get(1);
    localbxx.sessionId = paramString;
    com.tencent.mm.plugin.expt.hellhound.a.f.c.c.i(localbxx);
    ad.i("HABBYGE-MALI.HellKSessionConfig", "HellK, updateCurSid, new: ".concat(String.valueOf(paramString)));
    AppMethodBeat.o(177418);
  }
  
  public static final boolean Wz(String paramString)
  {
    AppMethodBeat.i(122610);
    boolean bool = a.Wz(paramString);
    AppMethodBeat.o(122610);
    return bool;
  }
  
  public static final String a(Activity paramActivity, String paramString1, String paramString2, List<String> paramList)
  {
    AppMethodBeat.i(122603);
    paramString1 = com.tencent.mm.plugin.expt.hellhound.core.b.Vy(paramString1);
    ad.i("HABBYGE-MALI.HellKSessionConfig", "getSidId: " + paramString1 + ", " + paramString2);
    k.g(c.ccT(), "HellSessionCloudConfig.getInstance()");
    Object localObject1 = c.ccU();
    if (localObject1 == null)
    {
      paramActivity = a.a(paramString1, paramString2, paramList);
      AppMethodBeat.o(122603);
      return paramActivity;
    }
    if (((cqi)localObject1).fuh)
    {
      ad.e("HABBYGE-MALI.HellKSessionConfig", "getSidId, sessionCloud.isDel ture");
      AppMethodBeat.o(122603);
      return null;
    }
    if (((k.g("ChattingUI", paramString2)) || (k.g("ChattingUIFragment", paramString2))) && ((k.g(com.tencent.mm.plugin.expt.hellhound.core.b.pDZ, paramString1)) || (TextUtils.isEmpty((CharSequence)paramString1))))
    {
      ad.i("HABBYGE-MALI.HellKSessionConfig", "HellKSessionConfig, getSidId: 999");
      AppMethodBeat.o(122603);
      return "999";
    }
    if (k.g("WebViewUI", paramString2)) {
      if (k.g("FindMoreFriendsUI", paramString1))
      {
        if (((cqi)localObject1).Eju != null)
        {
          if ((paramList != null) && (paramList.size() >= 2) && (k.g(((cqi)localObject1).Eju.Ejw, (String)paramList.get(0))) && (k.g(((cqi)localObject1).Eju.Ejx, (String)paramList.get(1))))
          {
            ad.i("HABBYGE-MALI.HellKSessionConfig", "getSidId, SESSION_ID_WebViewUI_jd_store");
            AppMethodBeat.o(122603);
            return "131";
          }
        }
        else
        {
          localObject2 = com.tencent.mm.plugin.expt.hellhound.a.h.a.pIh;
          if (com.tencent.mm.plugin.expt.hellhound.a.h.a.cdR())
          {
            paramActivity = com.tencent.mm.plugin.expt.hellhound.a.h.a.pIh;
            com.tencent.mm.plugin.expt.hellhound.a.h.a.kl(false);
            AppMethodBeat.o(122603);
            return "148";
          }
        }
      }
      else if ((k.g("MainUI", paramString1)) || (k.g("AddressUIFragment", paramString1)))
      {
        localObject2 = com.tencent.mm.plugin.expt.hellhound.a.h.a.pIh;
        if (com.tencent.mm.plugin.expt.hellhound.a.h.a.cdR())
        {
          paramActivity = com.tencent.mm.plugin.expt.hellhound.a.h.a.pIh;
          com.tencent.mm.plugin.expt.hellhound.a.h.a.kl(false);
          AppMethodBeat.o(122603);
          return "148";
        }
      }
    }
    if (k.g("BaseScanUI", paramString2))
    {
      localObject2 = com.tencent.mm.plugin.expt.hellhound.a.f.g.b.a.pHQ;
      if (com.tencent.mm.plugin.expt.hellhound.a.f.g.b.a.cdJ())
      {
        paramActivity = com.tencent.mm.plugin.expt.hellhound.a.f.g.b.a.pHQ;
        com.tencent.mm.plugin.expt.hellhound.a.f.g.b.a.ki(false);
        AppMethodBeat.o(122603);
        return "124";
      }
      localObject2 = com.tencent.mm.plugin.expt.hellhound.a.h.a.pIh;
      if (com.tencent.mm.plugin.expt.hellhound.a.h.a.cdQ())
      {
        paramActivity = com.tencent.mm.plugin.expt.hellhound.a.h.a.pIh;
        com.tencent.mm.plugin.expt.hellhound.a.h.a.kk(false);
        AppMethodBeat.o(122603);
        return "109";
      }
    }
    Object localObject2 = com.tencent.mm.plugin.expt.hellhound.a.f.g.b.a.pHQ;
    com.tencent.mm.plugin.expt.hellhound.a.f.g.b.a.cdJ();
    if ((paramList == null) || (paramList.isEmpty()))
    {
      localObject1 = ((cqi)localObject1).Ejs.iterator();
      String str;
      do
      {
        Object localObject3;
        while (!((Iterator)localObject3).hasNext())
        {
          do
          {
            if (!((Iterator)localObject1).hasNext()) {
              break;
            }
            localObject2 = (cqk)((Iterator)localObject1).next();
          } while ((localObject2 == null) || (!k.g(((cqk)localObject2).Ejq, paramString1)));
          localObject3 = ((cqk)localObject2).DDP;
          k.g(localObject3, "config.pageName");
          localObject3 = n.b((CharSequence)localObject3, new String[] { "," }).iterator();
        }
        str = (String)((Iterator)localObject3).next();
        if (str == null)
        {
          paramActivity = new v("null cannot be cast to non-null type kotlin.CharSequence");
          AppMethodBeat.o(122603);
          throw paramActivity;
        }
      } while (!k.g(n.trim((CharSequence)str).toString(), paramString2));
      if (k.g(((cqk)localObject2).pZX, "109"))
      {
        paramActivity = com.tencent.mm.plugin.expt.hellhound.a.h.a.pIh;
        if (com.tencent.mm.plugin.expt.hellhound.a.h.a.cdQ())
        {
          paramActivity = com.tencent.mm.plugin.expt.hellhound.a.h.a.pIh;
          com.tencent.mm.plugin.expt.hellhound.a.h.a.kk(false);
          AppMethodBeat.o(122603);
          return "109";
        }
        AppMethodBeat.o(122603);
        return "124";
      }
      if ((k.g(((cqk)localObject2).pZX, "105")) || (k.g(((cqk)localObject2).pZX, "131")))
      {
        paramActivity = com.tencent.mm.plugin.expt.hellhound.a.f.g.b.a.pHQ;
        if (com.tencent.mm.plugin.expt.hellhound.a.f.g.b.a.cdI())
        {
          paramActivity = com.tencent.mm.plugin.expt.hellhound.a.f.g.b.a.pHQ;
          com.tencent.mm.plugin.expt.hellhound.a.f.g.b.a.kh(false);
          AppMethodBeat.o(122603);
          return "131";
        }
        AppMethodBeat.o(122603);
        return "105";
      }
      paramActivity = ((cqk)localObject2).pZX;
      AppMethodBeat.o(122603);
      return paramActivity;
      paramActivity = a.a(paramActivity, paramString1, paramString2);
      if (paramActivity != null)
      {
        AppMethodBeat.o(122603);
        return paramActivity;
      }
    }
    ad.i("HABBYGE-MALI.HellKSessionConfig", "get sid by cloud config, but NULL, dignose sid By local config !!!");
    paramActivity = a.a(paramString1, paramString2, paramList);
    AppMethodBeat.o(122603);
    return paramActivity;
  }
  
  public static final void a(bge parambge)
  {
    AppMethodBeat.i(122606);
    if (parambge != null)
    {
      parambge = parambge.DDT;
      k.g(parambge, "hellSession.sessions");
      Object localObject1 = (Iterable)parambge;
      parambge = (Collection)new ArrayList();
      localObject1 = ((Iterable)localObject1).iterator();
      Object localObject2;
      Object localObject3;
      label159:
      while (((Iterator)localObject1).hasNext())
      {
        localObject2 = ((Iterator)localObject1).next();
        localObject3 = (bxx)localObject2;
        String str = ((bxx)localObject3).sessionId;
        k.g(str, "it.sessionId");
        if ((k.g(a.Wv(str), "999")) && ((((bxx)localObject3).DUr == 0) || (((bxx)localObject3).DUr == 1) || (((bxx)localObject3).DUr == 2) || (((bxx)localObject3).DUr == 4) || (((bxx)localObject3).DUr == 5))) {}
        for (int i = 1;; i = 0)
        {
          if (i == 0) {
            break label159;
          }
          parambge.add(localObject2);
          break;
        }
      }
      localObject1 = j.m((Iterable)parambge);
      if (localObject1 == null)
      {
        AppMethodBeat.o(122606);
        return;
      }
      ad.i("HABBYGE-MALI.HellKSessionConfig", "after, sessionList.size: " + ((List)localObject1).size());
      parambge = null;
      localObject1 = ((List)localObject1).iterator();
      while (((Iterator)localObject1).hasNext())
      {
        localObject2 = (bxx)((Iterator)localObject1).next();
        localObject3 = a.Wx(((bxx)localObject2).sessionId);
        if (localObject3 != null) {
          parambge = "_" + ((com.tencent.mm.vending.j.c)localObject3).get(1);
        }
        ad.i("HABBYGE-MALI.HellKSessionConfig", "handleChatting, session, Start: " + ((bxx)localObject2).sessionId + ", " + parambge);
        ((bxx)localObject2).sessionId = a.BF(((bxx)localObject2).DUr);
        if ((k.g(((bxx)localObject2).sessionId, "-1") ^ true))
        {
          localObject3 = ((bxx)localObject2).sessionId;
          ((bxx)localObject2).sessionId = ((String)localObject3 + parambge);
        }
        ad.i("HABBYGE-MALI.HellKSessionConfig", "handleChatting, session, End: " + ((bxx)localObject2).sessionId);
      }
    }
    AppMethodBeat.o(122606);
  }
  
  public static final boolean ccP()
  {
    AppMethodBeat.i(122619);
    boolean bool = a.ccP();
    AppMethodBeat.o(122619);
    return bool;
  }
  
  public static final boolean ccQ()
  {
    AppMethodBeat.i(122620);
    String str = a.ccR();
    if (!TextUtils.isEmpty((CharSequence)str))
    {
      if (str != null)
      {
        str = a.Wv(str);
        if ((!k.g("104", str)) && (!k.g("998", str))) {}
      }
      for (int i = 1; i != 0; i = 0)
      {
        AppMethodBeat.o(122620);
        return true;
      }
    }
    AppMethodBeat.o(122620);
    return false;
  }
  
  public static final String ccR()
  {
    AppMethodBeat.i(122621);
    String str = a.ccR();
    AppMethodBeat.o(122621);
    return str;
  }
  
  public static final void e(bxx parambxx)
  {
    AppMethodBeat.i(122607);
    if (parambxx != null)
    {
      com.tencent.mm.vending.j.c localc = a.Wx(parambxx.sessionId);
      if (localc == null)
      {
        AppMethodBeat.o(122607);
        return;
      }
      if (!(k.g("999", localc.get(0)) ^ true))
      {
        String str = a.BF(parambxx.DUr);
        parambxx.sessionId = (str + "_" + localc.get(1));
      }
    }
    AppMethodBeat.o(122607);
  }
  
  public static final String f(bxx parambxx)
  {
    AppMethodBeat.i(122608);
    if (parambxx == null)
    {
      AppMethodBeat.o(122608);
      return null;
    }
    Object localObject1 = a.Wx(parambxx.sessionId);
    if (localObject1 == null)
    {
      parambxx = parambxx.sessionId;
      AppMethodBeat.o(122608);
      return parambxx;
    }
    if ((k.g("999", ((com.tencent.mm.vending.j.c)localObject1).get(0)) ^ true))
    {
      localObject2 = ((com.tencent.mm.vending.j.c)localObject1).get(0);
      if (!(localObject2 instanceof Integer)) {}
      while (-1 != ((Integer)localObject2).intValue())
      {
        parambxx = parambxx.sessionId;
        AppMethodBeat.o(122608);
        return parambxx;
      }
    }
    Object localObject2 = a.BF(parambxx.DUr);
    localObject1 = (String)localObject2 + "_" + ((com.tencent.mm.vending.j.c)localObject1).get(1);
    parambxx.sessionId = ((String)localObject1);
    AppMethodBeat.o(122608);
    return localObject1;
  }
  
  public static final String fA(String paramString1, String paramString2)
  {
    AppMethodBeat.i(177416);
    paramString1 = a.a(paramString1, paramString2, null);
    AppMethodBeat.o(177416);
    return paramString1;
  }
  
  public static final int fo(int paramInt1, int paramInt2)
  {
    if (paramInt1 >= paramInt2) {
      return paramInt1 + 1;
    }
    return paramInt2 + 1;
  }
  
  public static final String g(bxx parambxx)
  {
    AppMethodBeat.i(122609);
    if (parambxx == null)
    {
      AppMethodBeat.o(122609);
      return null;
    }
    com.tencent.mm.vending.j.c localc = a.Wx(parambxx.sessionId);
    if (localc == null)
    {
      parambxx = parambxx.sessionId;
      AppMethodBeat.o(122609);
      return parambxx;
    }
    if ((k.g("999", localc.get(0)) ^ true))
    {
      parambxx = parambxx.sessionId;
      k.g(parambxx, "pageSession.sessionId");
      parambxx = a.Wv(parambxx);
      AppMethodBeat.o(122609);
      return parambxx;
    }
    ad.i("HABBYGE-MALI.HellKSessionConfig", "HellKSessionConfig, getRealChatSessionId: " + parambxx.DUr);
    parambxx = a.BF(parambxx.DUr);
    AppMethodBeat.o(122609);
    return parambxx;
  }
  
  public static final String u(long paramLong, int paramInt)
  {
    AppMethodBeat.i(122617);
    String str = String.valueOf(paramLong) + "_" + paramInt;
    AppMethodBeat.o(122617);
    return str;
  }
  
  @l(fvt={1, 1, 16}, fvu={""}, fvv={"Lcom/tencent/mm/plugin/expt/hellhound/ext/session/config/HellKSessionConfig$Companion;", "", "()V", "CHATTING_UI", "", "CHATTING_UI_FRAGMENT", "SESSION_ID_ADDRESS_ADD_FRIEND", "SESSION_ID_ADDRESS_SEARCH", "SESSION_ID_ADD_FRIEND", "SESSION_ID_APPBRAND", "SESSION_ID_AppBrandLauncherUI", "SESSION_ID_BIZ_LIST", "SESSION_ID_BIZ_MESSAGE", "SESSION_ID_BaseScanUI", "SESSION_ID_BottleBeachUI", "SESSION_ID_CHAT", "SESSION_ID_CHAT_PLUGIN_WECHAT_MOVEMENT", "SESSION_ID_CHAT_ROOM", "SESSION_ID_CHAT_SERVICE", "SESSION_ID_CHAT_SERVICE_NOTIFY", "SESSION_ID_CHAT_VIRTUAL", "SESSION_ID_CONTACT_BIZ", "SESSION_ID_CardHomePageUI", "SESSION_ID_ChatroomContactUI", "SESSION_ID_ContactInfoUI", "SESSION_ID_ContactLabelManagerUI", "SESSION_ID_ENTERPRISE", "SESSION_ID_EmojiStoreV2UI", "SESSION_ID_FINDER", "SESSION_ID_FIND_SEARCH", "SESSION_ID_FMessageConversationUI", "SESSION_ID_FTSSOSHomeWebViewUI", "SESSION_ID_FavoriteIndexUI", "SESSION_ID_FloatingWindow", "SESSION_ID_GAME", "SESSION_ID_GLOBAL_SEARCH", "SESSION_ID_HELP", "SESSION_ID_MINI_GAME", "SESSION_ID_MallIndexUI", "SESSION_ID_NearbyFriendsUI", "SESSION_ID_Nearby_Rest", "SESSION_ID_OpenIMAddressUI", "SESSION_ID_SEARCH_BaseScanUI", "SESSION_ID_SELECT_CONTACTUI", "SESSION_ID_SettingsPersonalInfoUI", "SESSION_ID_SettingsUI", "SESSION_ID_ShakeReportUI", "SESSION_ID_SnsTimeLineUI", "SESSION_ID_SnsUserUI", "SESSION_ID_StoryCaptureUI", "SESSION_ID_StoryGalleryView", "SESSION_ID_TENCENT_NEWS", "SESSION_ID_TopStoryHomeUI", "SESSION_ID_VOIP_FloatingWindow", "SESSION_ID_WalletOfflineEntranceUI", "SESSION_ID_WebViewUI_jd_store", "TAB_AddressUIFragment", "TAB_FindMoreFriendsUI", "TAB_MainUI", "TAB_MoreTabUI", "TAG", "mSessionIdEntryListLocal", "", "Lcom/tencent/mm/plugin/expt/hellhound/ext/session/dao/SessionKEntry;", "convertChatSid", "", "hellSession", "Lcom/tencent/mm/protocal/protobuf/HellSession;", "pageSession", "Lcom/tencent/mm/protocal/protobuf/PageSession;", "cutInvalidatePageKeyToName", "pageId", "cutSessonToSid", "session", "doNotNeedSessionMonitor", "", "generateSeq", "", "seqOfPage", "seqOfUBA", "getBizIdOfSessionParam", "timestamp", "", "seq", "getCurSession", "getCurSid", "getIdentifySidExpect", "curActivity", "Landroid/app/Activity;", "srcPage", "dstPage", "getLastSession", "getPageStartTimeOfBizId", "bizId", "(Ljava/lang/String;)Ljava/lang/Long;", "getRealChatSid", "chattingType", "getRealChatSidLocal", "getSessionPageOfConfig", "Lcom/tencent/mm/protocal/protobuf/SessionPagePath;", "sid", "isDetailReport", "getSidId", "args", "getSidLocal", "getTabIdOfLauncher", "tabPageName", "getTabSessionIdOfLauncher", "sessionId", "isAppBrandSession", "isBizSid", "isChatSessionId", "isChatSid", "isCurBizSid", "isEffectiveSession", "sessoinId", "isEffectiveSessionBySid", "isFloatSession", "isJdSid", "isVoipSession", "spliteSession", "Lcom/tencent/mm/vending/tuple/Tuple2;", "updateCurSid", "updateRealChatSessionId", "plugin-expt_release"})
  public static final class a
  {
    static String BF(int paramInt)
    {
      AppMethodBeat.i(122595);
      k.g(c.ccT(), "HellSessionCloudConfig.getInstance()");
      Object localObject = c.ccU();
      if (localObject == null)
      {
        localObject = BG(paramInt);
        AppMethodBeat.o(122595);
        return localObject;
      }
      if (((cqi)localObject).fuh)
      {
        ad.e("HABBYGE-MALI.HellKSessionConfig", "getRealChatSid, configCloud.isDel");
        AppMethodBeat.o(122595);
        return "-1";
      }
      localObject = ((cqi)localObject).Ejt.iterator();
      while (((Iterator)localObject).hasNext())
      {
        cqh localcqh = (cqh)((Iterator)localObject).next();
        if (localcqh != null)
        {
          ad.i("HABBYGE-MALI.HellKSessionConfig", "getRealChatSid, chatConfig.expect=" + localcqh.Ejr);
          if (bt.getInt(localcqh.Ejr, -1) == paramInt)
          {
            localObject = localcqh.pZX;
            k.g(localObject, "chatConfig.sid");
            AppMethodBeat.o(122595);
            return localObject;
          }
        }
      }
      localObject = BG(paramInt);
      AppMethodBeat.o(122595);
      return localObject;
    }
    
    private static String BG(int paramInt)
    {
      AppMethodBeat.i(122596);
      String str;
      switch (paramInt)
      {
      case 3: 
      default: 
        str = "-1";
      }
      for (;;)
      {
        ad.i("HABBYGE-MALI.HellKSessionConfig", "HellKSessionConfig, getRealChatSidLocal: ".concat(String.valueOf(str)));
        AppMethodBeat.o(122596);
        return str;
        str = "101";
        continue;
        str = "102";
        continue;
        str = "103";
        continue;
        str = "111";
        continue;
        str = "112";
      }
    }
    
    public static Long WG(String paramString)
    {
      AppMethodBeat.i(122598);
      if (paramString != null) {
        if (((CharSequence)paramString).length() != 0) {
          break label36;
        }
      }
      label36:
      for (int i = 1; i != 0; i = 0)
      {
        AppMethodBeat.o(122598);
        return null;
      }
      try
      {
        long l = Long.parseLong((String)n.a((CharSequence)paramString, new String[] { "_" }).get(0));
        AppMethodBeat.o(122598);
        return Long.valueOf(l);
      }
      catch (Exception paramString)
      {
        ad.printErrStackTrace("HABBYGE-MALI.HellKSessionConfig", (Throwable)paramString, "getPageStartTimeOfBusinessId, crash: " + paramString.getMessage(), new Object[0]);
        AppMethodBeat.o(122598);
      }
      return null;
    }
    
    public static String WH(String paramString)
    {
      AppMethodBeat.i(190932);
      if (paramString == null)
      {
        AppMethodBeat.o(190932);
        return null;
      }
      if (n.a((CharSequence)paramString, (CharSequence)".", false))
      {
        if (k.g(paramString, com.tencent.mm.plugin.expt.hellhound.core.b.pDU))
        {
          AppMethodBeat.o(190932);
          return "0";
        }
        if (k.g(paramString, com.tencent.mm.plugin.expt.hellhound.core.b.pDV))
        {
          AppMethodBeat.o(190932);
          return "1";
        }
        if (k.g(paramString, com.tencent.mm.plugin.expt.hellhound.core.b.pDW))
        {
          AppMethodBeat.o(190932);
          return "2";
        }
        if (k.g(paramString, com.tencent.mm.plugin.expt.hellhound.core.b.pDX))
        {
          AppMethodBeat.o(190932);
          return "3";
        }
        AppMethodBeat.o(190932);
        return paramString;
      }
      if (k.g(paramString, com.tencent.mm.plugin.expt.hellhound.core.b.pDZ))
      {
        AppMethodBeat.o(190932);
        return "0";
      }
      if (k.g(paramString, com.tencent.mm.plugin.expt.hellhound.core.b.pEa))
      {
        AppMethodBeat.o(190932);
        return "1";
      }
      if (k.g(paramString, com.tencent.mm.plugin.expt.hellhound.core.b.pEb))
      {
        AppMethodBeat.o(190932);
        return "2";
      }
      if (k.g(paramString, com.tencent.mm.plugin.expt.hellhound.core.b.pEc))
      {
        AppMethodBeat.o(190932);
        return "3";
      }
      AppMethodBeat.o(190932);
      return paramString;
    }
    
    static boolean WK(String paramString)
    {
      AppMethodBeat.i(185598);
      if ((k.g(paramString, "0")) || (k.g(paramString, "1")) || (k.g(paramString, "2")) || (k.g(paramString, "3")))
      {
        AppMethodBeat.o(185598);
        return false;
      }
      boolean bool = com.tencent.mm.plugin.expt.hellhound.core.b.isNumeric(paramString);
      AppMethodBeat.o(185598);
      return bool;
    }
    
    public static String Wv(String paramString)
    {
      AppMethodBeat.i(122593);
      k.h(paramString, "session");
      if (paramString.length() <= 3)
      {
        AppMethodBeat.o(122593);
        return paramString;
      }
      if (n.a((CharSequence)paramString, (CharSequence)"_", false))
      {
        paramString = (String)n.a((CharSequence)paramString, new String[] { "_" }).get(0);
        AppMethodBeat.o(122593);
        return paramString;
      }
      paramString = paramString.substring(0, 3);
      k.g(paramString, "(this as java.lang.Strin…ing(startIndex, endIndex)");
      AppMethodBeat.o(122593);
      return paramString;
    }
    
    public static com.tencent.mm.vending.j.c<String, String> Wx(String paramString)
    {
      AppMethodBeat.i(122594);
      if (paramString != null)
      {
        if (k.compare(paramString.length(), 4) <= 0)
        {
          AppMethodBeat.o(122594);
          return null;
        }
      }
      else
      {
        AppMethodBeat.o(122594);
        return null;
      }
      paramString = n.a((CharSequence)paramString, new String[] { "_" });
      if (paramString != null)
      {
        if (k.compare(paramString.size(), 2) != 0)
        {
          AppMethodBeat.o(122594);
          return null;
        }
      }
      else
      {
        AppMethodBeat.o(122594);
        return null;
      }
      paramString = com.tencent.mm.vending.j.a.L(paramString.get(0), paramString.get(1));
      AppMethodBeat.o(122594);
      return paramString;
    }
    
    public static boolean Wz(String paramString)
    {
      AppMethodBeat.i(122597);
      if ((k.g("101", paramString)) || (k.g("102", paramString)) || (k.g("103", paramString)) || (k.g("111", paramString)) || (k.g("112", paramString)))
      {
        AppMethodBeat.o(122597);
        return true;
      }
      AppMethodBeat.o(122597);
      return false;
    }
    
    static String a(Activity paramActivity, String paramString1, String paramString2)
    {
      AppMethodBeat.i(122591);
      k.g(c.ccT(), "HellSessionCloudConfig.getInstance()");
      Object localObject1 = c.ccU();
      if (localObject1 == null)
      {
        AppMethodBeat.o(122591);
        return null;
      }
      cqm localcqm;
      do
      {
        String str;
        do
        {
          localObject1 = ((cqi)localObject1).Ejv.iterator();
          Object localObject2;
          while (!((Iterator)localObject2).hasNext())
          {
            do
            {
              if (!((Iterator)localObject1).hasNext()) {
                break;
              }
              localcqm = (cqm)((Iterator)localObject1).next();
            } while ((localcqm == null) || (localcqm.Ejy.isEmpty()) || ((k.g(localcqm.Ejq, paramString1) ^ true)));
            localObject2 = localcqm.DDP;
            k.g(localObject2, "config.pageName");
            localObject2 = n.a((CharSequence)localObject2, new String[] { "," }).iterator();
          }
          str = (String)((Iterator)localObject2).next();
          if (str == null)
          {
            paramActivity = new v("null cannot be cast to non-null type kotlin.CharSequence");
            AppMethodBeat.o(122591);
            throw paramActivity;
          }
        } while (!k.g(n.trim((CharSequence)str).toString(), paramString2));
        ad.i("HABBYGE-MALI.HellKSessionConfig", "getIdentifySidExpect, sid: " + localcqm.pZX);
      } while (!a.a(paramActivity, localcqm));
      paramActivity = localcqm.pZX;
      AppMethodBeat.o(122591);
      return paramActivity;
      AppMethodBeat.o(122591);
      return null;
    }
    
    public static String a(String paramString1, String paramString2, List<String> paramList)
    {
      AppMethodBeat.i(122592);
      paramString1 = com.tencent.mm.plugin.expt.hellhound.core.b.Vy(paramString1);
      String str1 = com.tencent.mm.plugin.expt.hellhound.core.b.Vy(paramString2);
      ad.i("HABBYGE-MALI.HellKSessionConfig", "getSessionIdLocal: " + paramString1 + ", " + str1);
      if (((k.g("ChattingUI", paramString2)) || (k.g("ChattingUIFragment", paramString2))) && ((k.g(com.tencent.mm.plugin.expt.hellhound.core.b.pDZ, paramString1)) || (TextUtils.isEmpty((CharSequence)paramString1))))
      {
        ad.i("HABBYGE-MALI.HellKSessionConfig", "HellKSessionConfig, getSidId: 999");
        AppMethodBeat.o(122592);
        return "999";
      }
      if ((k.g("WebViewUI", str1)) && ((k.g("FindMoreFriendsUI", paramString1)) || (k.g("MainUI", paramString1)) || (k.g("AddressUIFragment", paramString1))))
      {
        paramString2 = com.tencent.mm.plugin.expt.hellhound.a.h.a.pIh;
        if (com.tencent.mm.plugin.expt.hellhound.a.h.a.cdR())
        {
          AppMethodBeat.o(122592);
          return "148";
        }
      }
      if (k.g("BaseScanUI", str1))
      {
        paramString2 = com.tencent.mm.plugin.expt.hellhound.a.f.g.b.a.pHQ;
        if (com.tencent.mm.plugin.expt.hellhound.a.f.g.b.a.cdJ())
        {
          AppMethodBeat.o(122592);
          return "124";
        }
        paramString2 = com.tencent.mm.plugin.expt.hellhound.a.h.a.pIh;
        if (com.tencent.mm.plugin.expt.hellhound.a.h.a.cdQ())
        {
          AppMethodBeat.o(122592);
          return "109";
        }
      }
      Object localObject;
      if ((paramList == null) || (paramList.isEmpty()))
      {
        do
        {
          paramString2 = b.ccO().iterator();
          while (!((Iterator)localObject).hasNext())
          {
            do
            {
              if (!paramString2.hasNext()) {
                break;
              }
              paramList = (i)paramString2.next();
              if (TextUtils.isEmpty((CharSequence)paramString1))
              {
                AppMethodBeat.o(122592);
                return null;
              }
            } while (!k.g(paramString1, paramList.pHA));
            localObject = paramList.pHB.iterator();
          }
        } while (!k.g(str1, (String)((Iterator)localObject).next()));
        if (k.g(paramList.sessionId, "109"))
        {
          paramString1 = com.tencent.mm.plugin.expt.hellhound.a.h.a.pIh;
          if (com.tencent.mm.plugin.expt.hellhound.a.h.a.cdQ())
          {
            AppMethodBeat.o(122592);
            return "109";
          }
          AppMethodBeat.o(122592);
          return "124";
        }
        if ((k.g(paramList.sessionId, "105")) || (k.g(paramList.sessionId, "131")))
        {
          paramString1 = com.tencent.mm.plugin.expt.hellhound.a.f.g.b.a.pHQ;
          if (com.tencent.mm.plugin.expt.hellhound.a.f.g.b.a.cdI())
          {
            AppMethodBeat.o(122592);
            return "131";
          }
          AppMethodBeat.o(122592);
          return "105";
        }
        paramString1 = paramList.sessionId;
        AppMethodBeat.o(122592);
        return paramString1;
      }
      paramString2 = b.ccO().iterator();
      int i = 0;
      int j = 0;
      if (paramString2.hasNext())
      {
        localObject = (i)paramString2.next();
        if (TextUtils.isEmpty((CharSequence)paramString1))
        {
          AppMethodBeat.o(122592);
          return null;
        }
        if ((k.g(paramString1, ((i)localObject).pHA) ^ true)) {
          break label653;
        }
        Iterator localIterator = ((i)localObject).pHB.iterator();
        for (;;)
        {
          label519:
          if (!localIterator.hasNext()) {
            break label643;
          }
          String str2 = (String)localIterator.next();
          if (j != 0)
          {
            if (i < paramList.size())
            {
              if (k.g(str2, (String)paramList.get(i))) {
                break label646;
              }
              i = 0;
              j = 0;
              label579:
              if (j == 0) {
                break;
              }
              paramString1 = ((i)localObject).sessionId;
              AppMethodBeat.o(122592);
              return paramString1;
            }
            paramString1 = ((i)localObject).sessionId;
            AppMethodBeat.o(122592);
            return paramString1;
          }
          if ((k.g(str1, str2) ^ true)) {
            break label643;
          }
          j = 1;
          i = 0;
        }
      }
      label643:
      label646:
      label653:
      for (;;)
      {
        break;
        AppMethodBeat.o(122592);
        return null;
        break label579;
        i += 1;
        break label519;
      }
    }
    
    public static boolean ccP()
    {
      AppMethodBeat.i(122599);
      if (!com.tencent.mm.plugin.expt.hellhound.a.cbn())
      {
        ad.i("HABBYGE-MALI.HellKSessionConfig", "HellSessionMonitor monitor, fetchHellhoundConfig: FALSE");
        AppMethodBeat.o(122599);
        return true;
      }
      k.g(c.ccT(), "HellSessionCloudConfig.getInstance()");
      if ((c.ccV()) || (com.tencent.mm.plugin.expt.hellhound.core.b.getUin() == 0))
      {
        ad.i("HABBYGE-MALI.HellKSessionConfig", "HellSessionMonitor monitor FALSE");
        AppMethodBeat.o(122599);
        return true;
      }
      if (!com.tencent.mm.plugin.expt.hellhound.a.cbp())
      {
        ad.i("HABBYGE-MALI.HellKSessionConfig", "HellSessionMonitor monitor, close !!!");
        AppMethodBeat.o(122599);
        return true;
      }
      AppMethodBeat.o(122599);
      return false;
    }
    
    public static String ccR()
    {
      AppMethodBeat.i(122601);
      String str = ccS();
      if (str == null)
      {
        AppMethodBeat.o(122601);
        return null;
      }
      str = Wv(str);
      AppMethodBeat.o(122601);
      return str;
    }
    
    public static String ccS()
    {
      AppMethodBeat.i(122600);
      Object localObject = com.tencent.mm.plugin.expt.hellhound.a.f.c.c.cdh();
      if (localObject == null)
      {
        AppMethodBeat.o(122600);
        return null;
      }
      localObject = ((bxx)localObject).sessionId;
      AppMethodBeat.o(122600);
      return localObject;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.expt.hellhound.a.f.b.b
 * JD-Core Version:    0.7.0.1
 */