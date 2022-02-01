package com.tencent.mm.plugin.expt.hellhound.a.f.b;

import android.app.Activity;
import android.text.TextUtils;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.expt.hellhound.a.f.c.i;
import com.tencent.mm.protocal.protobuf.cjr;
import com.tencent.mm.protocal.protobuf.dhx;
import com.tencent.mm.protocal.protobuf.efa;
import com.tencent.mm.protocal.protobuf.efb;
import com.tencent.mm.protocal.protobuf.efc;
import com.tencent.mm.protocal.protobuf.efd;
import com.tencent.mm.protocal.protobuf.eff;
import com.tencent.mm.protocal.protobuf.efj;
import com.tencent.mm.protocal.protobuf.efm;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import kotlin.a.j;
import kotlin.g.b.p;
import kotlin.l;
import kotlin.n.n;
import kotlin.t;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/expt/hellhound/ext/session/config/HellKSessionConfig;", "", "()V", "Companion", "plugin-expt_release"})
public final class b
{
  private static final List<i> wou;
  public static final a wov;
  
  static
  {
    AppMethodBeat.i(122602);
    wov = new a((byte)0);
    wou = j.listOf(new i[] { new i("999", com.tencent.mm.plugin.expt.hellhound.core.b.weX, (List)j.ag(new String[] { "ChattingUIFragment", "ChattingUI" })), new i("998", com.tencent.mm.plugin.expt.hellhound.core.b.weX, (List)j.ag(new String[] { "BizConversationUI" })), new i("104", com.tencent.mm.plugin.expt.hellhound.core.b.weX, (List)j.ag(new String[] { "BizTimeLineUI" })), new i("105", com.tencent.mm.plugin.expt.hellhound.core.b.weX, (List)j.ag(new String[] { "AppBrandLaunchProxyUI", "AppBrandUI", "AppBrandUI1", "AppBrandUI2", "AppBrandUI3", "AppBrandUI4" })), new i("105", com.tencent.mm.plugin.expt.hellhound.core.b.weX, (List)j.ag(new String[] { "AppBrandUI", "AppBrandUI1", "AppBrandUI2", "AppBrandUI3", "AppBrandUI4" })), new i("105", "LauncherUI", (List)j.ag(new String[] { "AppBrandLaunchProxyUI", "AppBrandUI", "AppBrandUI1", "AppBrandUI2", "AppBrandUI3", "AppBrandUI4" })), new i("105", "LauncherUI", (List)j.ag(new String[] { "AppBrandUI", "AppBrandUI1", "AppBrandUI2", "AppBrandUI3", "AppBrandUI4" })), new i("105", com.tencent.mm.plugin.expt.hellhound.core.b.weX, (List)j.ag(new String[] { "AppBrandLauncherUI" })), new i("105", "LauncherUI", (List)j.ag(new String[] { "AppBrandLauncherUI" })), new i("105", "WXShortcutEntryActivity", (List)j.ag(new String[] { "AppBrandLaunchProxyUI", "AppBrandUI", "AppBrandUI1", "AppBrandUI2", "AppBrandUI3", "AppBrandUI4" })), new i("105", com.tencent.mm.plugin.expt.hellhound.core.b.weY, (List)j.ag(new String[] { "AppBrandLaunchProxyUI", "AppBrandUI", "AppBrandUI1", "AppBrandUI2", "AppBrandUI3", "AppBrandUI4" })), new i("105", com.tencent.mm.plugin.expt.hellhound.core.b.weZ, (List)j.ag(new String[] { "AppBrandLaunchProxyUI", "AppBrandUI", "AppBrandUI1", "AppBrandUI2", "AppBrandUI3", "AppBrandUI4" })), new i("105", com.tencent.mm.plugin.expt.hellhound.core.b.wfa, (List)j.ag(new String[] { "AppBrandLaunchProxyUI", "AppBrandUI", "AppBrandUI1", "AppBrandUI2", "AppBrandUI3", "AppBrandUI4" })), new i("113", com.tencent.mm.plugin.expt.hellhound.core.b.weX, (List)j.ag(new String[] { "ReaderAppUI" })), new i("114", com.tencent.mm.plugin.expt.hellhound.core.b.weY, (List)j.ag(new String[] { "FTSMainUI" })), new i("147", com.tencent.mm.plugin.expt.hellhound.core.b.weZ, (List)j.ag(new String[] { "FTSMainUI" })), new i("115", com.tencent.mm.plugin.expt.hellhound.core.b.weY, (List)j.ag(new String[] { "AddMoreFriendsUI" })), new i("116", com.tencent.mm.plugin.expt.hellhound.core.b.weY, (List)j.ag(new String[] { "FMessageConversationUI" })), new i("117", com.tencent.mm.plugin.expt.hellhound.core.b.weY, (List)j.ag(new String[] { "ChatroomContactUI" })), new i("118", com.tencent.mm.plugin.expt.hellhound.core.b.weY, (List)j.ag(new String[] { "ContactLabelManagerUI" })), new i("106", com.tencent.mm.plugin.expt.hellhound.core.b.weX, (List)j.ag(new String[] { "FTSMainUI" })), new i("107", com.tencent.mm.plugin.expt.hellhound.core.b.weX, (List)j.ag(new String[] { "SelectContactUI" })), new i("107", com.tencent.mm.plugin.expt.hellhound.core.b.weY, (List)j.ag(new String[] { "SelectContactUI" })), new i("107", com.tencent.mm.plugin.expt.hellhound.core.b.weZ, (List)j.ag(new String[] { "SelectContactUI" })), new i("108", com.tencent.mm.plugin.expt.hellhound.core.b.weX, (List)j.ag(new String[] { "AddMoreFriendsUI" })), new i("108", com.tencent.mm.plugin.expt.hellhound.core.b.weY, (List)j.ag(new String[] { "AddMoreFriendsUI" })), new i("108", com.tencent.mm.plugin.expt.hellhound.core.b.weZ, (List)j.ag(new String[] { "AddMoreFriendsUI" })), new i("109", com.tencent.mm.plugin.expt.hellhound.core.b.weX, (List)j.ag(new String[] { "BaseScanUI" })), new i("109", com.tencent.mm.plugin.expt.hellhound.core.b.weY, (List)j.ag(new String[] { "BaseScanUI" })), new i("109", com.tencent.mm.plugin.expt.hellhound.core.b.weZ, (List)j.ag(new String[] { "BaseScanUI" })), new i("110", com.tencent.mm.plugin.expt.hellhound.core.b.weX, (List)j.ag(new String[] { "WalletOfflineEntranceUI" })), new i("110", com.tencent.mm.plugin.expt.hellhound.core.b.weY, (List)j.ag(new String[] { "WalletOfflineEntranceUI" })), new i("110", com.tencent.mm.plugin.expt.hellhound.core.b.weZ, (List)j.ag(new String[] { "WalletOfflineEntranceUI" })), new i("119", com.tencent.mm.plugin.expt.hellhound.core.b.weY, (List)j.ag(new String[] { "BrandServiceIndexUI" })), new i("120", com.tencent.mm.plugin.expt.hellhound.core.b.weY, (List)j.ag(new String[] { "EnterpriseBizContactListUI" })), new i("121", "AddressUIFragment", (List)j.ag(new String[] { "OpenIMAddressUI" })), new i("122", "AddressUIFragment", (List)j.ag(new String[] { "ContactInfoUI" })), new i("123", com.tencent.mm.plugin.expt.hellhound.core.b.weZ, (List)j.ag(new String[] { "SnsTimeLineUI" })), new i("124", com.tencent.mm.plugin.expt.hellhound.core.b.weZ, (List)j.ag(new String[] { "BaseScanUI" })), new i("125", com.tencent.mm.plugin.expt.hellhound.core.b.weZ, (List)j.ag(new String[] { "ShakeReportUI" })), new i("126", com.tencent.mm.plugin.expt.hellhound.core.b.weZ, (List)j.ag(new String[] { "TopStoryHomeUI" })), new i("127", com.tencent.mm.plugin.expt.hellhound.core.b.weZ, (List)j.ag(new String[] { "FTSSOSHomeWebViewUI" })), new i("128", com.tencent.mm.plugin.expt.hellhound.core.b.weZ, (List)j.ag(new String[] { "NearbyFriendsIntroUI", "NearbyFriendsUI", "NearbyPersonalInfoUI", "NearbyFriendShowSayHiUI" })), new i("129", com.tencent.mm.plugin.expt.hellhound.core.b.weZ, (List)j.ag(new String[] { "BottleBeachUI" })), new i("130", com.tencent.mm.plugin.expt.hellhound.core.b.weZ, (List)j.ag(new String[] { "AppBrandPluginUI" })), new i("131", com.tencent.mm.plugin.expt.hellhound.core.b.weZ, (List)j.ag(new String[] { "WebViewUI", "1", "jd_store" })), new i("131", com.tencent.mm.plugin.expt.hellhound.core.b.weZ, (List)j.ag(new String[] { "AppBrandLaunchProxyUI", "AppBrandUI", "AppBrandUI1", "AppBrandUI2", "AppBrandUI3", "AppBrandUI4" })), new i("132", com.tencent.mm.plugin.expt.hellhound.core.b.weZ, (List)j.ag(new String[] { "GameWebViewUI" })), new i("132", com.tencent.mm.plugin.expt.hellhound.core.b.weZ, (List)j.ag(new String[] { "GameCenterUI" })), new i("132", com.tencent.mm.plugin.expt.hellhound.core.b.weZ, (List)j.ag(new String[] { "LuggageGameWebViewUI" })), new i("132", com.tencent.mm.plugin.expt.hellhound.core.b.weZ, (List)j.ag(new String[] { "GameWebViewMpUI" })), new i("132", com.tencent.mm.plugin.expt.hellhound.core.b.weZ, (List)j.ag(new String[] { "LuggageGameWebViewMpUI" })), new i("133", com.tencent.mm.plugin.expt.hellhound.core.b.weZ, (List)j.ag(new String[] { "AppBrandLauncherUI" })), new i("134", com.tencent.mm.plugin.expt.hellhound.core.b.wfa, (List)j.ag(new String[] { "SettingsPersonalInfoUI" })), new i("135", com.tencent.mm.plugin.expt.hellhound.core.b.wfa, (List)j.ag(new String[] { "MallIndexUI", "MallIndexUIv2" })), new i("136", com.tencent.mm.plugin.expt.hellhound.core.b.wfa, (List)j.ag(new String[] { "FavoriteIndexUI" })), new i("137", com.tencent.mm.plugin.expt.hellhound.core.b.wfa, (List)j.ag(new String[] { "SnsUserUI", "AlbumUI" })), new i("138", com.tencent.mm.plugin.expt.hellhound.core.b.wfa, (List)j.ag(new String[] { "CardHomePageNewUI", "CardHomePageUI", "CardIndexUI", "CardInvalidCardUI", "CardViewUI", "ShareCardListUI", "CardHomePageV3UI" })), new i("139", "MoreTabUI", (List)j.ag(new String[] { "EmojiStoreV2UI", "MMFlutterActivity" })), new i("140", "MoreTabUI", (List)j.ag(new String[] { "SettingsUI" })), new i("141", "MoreTabUI", (List)j.ag(new String[] { "StoryCaptureUI", "MMRecordUI" })), new i("142", "MoreTabUI", (List)j.ag(new String[] { "StoryGalleryView", "StoryVideoView" })), new i("143", "FindMoreFriendsUI", (List)j.ag(new String[] { "FinderTimelineUI" })), new i("143", "FindMoreFriendsUI", (List)j.ag(new String[] { "FinderHomeUI" })), new i("143", "FindMoreFriendsUI", (List)j.ag(new String[] { "FinderConversationUI" })), new i("143", "AddressUIFragment", (List)j.ag(new String[] { "FinderTimelineUI" })), new i("143", "FinderHomeUI", (List)j.ag(new String[] { "FinderSelfUI" })), new i("145", "LauncherUI", (List)j.ag(new String[] { "FloatingBall" })), new i("146", "LauncherUI", (List)j.ag(new String[] { "VideoActivity" })), new i("149", "AddressUIFragment", (List)j.ag(new String[] { "OnlyChatContactMgrUI" })), new i("150", com.tencent.mm.plugin.expt.hellhound.core.b.weZ, (List)j.ag(new String[] { "NearbyHomeUI", "OccupyFinderUI11", "NearbyUI" })), new i("151", com.tencent.mm.plugin.expt.hellhound.core.b.wfa, (List)j.ag(new String[] { "FinderProfileUI" })), new i("152", com.tencent.mm.plugin.expt.hellhound.core.b.weZ, (List)j.ag(new String[] { "FinderLiveFindPageUI" })) });
    AppMethodBeat.o(122602);
  }
  
  public static final String a(Activity paramActivity, String paramString1, String paramString2, List<String> paramList)
  {
    AppMethodBeat.i(122603);
    paramString1 = com.tencent.mm.plugin.expt.hellhound.core.b.awD(paramString1);
    Log.i("HABBYGE-MALI.HellKSessionConfig", "getSidId: " + paramString1 + ", " + paramString2);
    p.j(c.deU(), "HellSessionCloudConfig.getInstance()");
    Object localObject1 = c.deV();
    if (localObject1 == null)
    {
      paramActivity = a.b(paramString1, paramString2, paramList);
      AppMethodBeat.o(122603);
      return paramActivity;
    }
    if (((efb)localObject1).jis)
    {
      Log.e("HABBYGE-MALI.HellKSessionConfig", "getSidId, sessionCloud.isDel ture");
      AppMethodBeat.o(122603);
      return null;
    }
    if (((p.h("ChattingUI", paramString2)) || (p.h("ChattingUIFragment", paramString2))) && ((p.h(com.tencent.mm.plugin.expt.hellhound.core.b.weX, paramString1)) || (TextUtils.isEmpty((CharSequence)paramString1))))
    {
      Log.i("HABBYGE-MALI.HellKSessionConfig", "getSidId: 999");
      AppMethodBeat.o(122603);
      return "999";
    }
    if (p.h("WebViewUI", paramString2)) {
      if (p.h("FindMoreFriendsUI", paramString1))
      {
        if (((efb)localObject1).UiA != null)
        {
          if ((paramList != null) && (paramList.size() >= 2) && (p.h(((efb)localObject1).UiA.UiC, (String)paramList.get(0))) && (p.h(((efb)localObject1).UiA.UiD, (String)paramList.get(1))))
          {
            Log.i("HABBYGE-MALI.HellKSessionConfig", "getSidId, SESSION_ID_WebViewUI_jd_store");
            AppMethodBeat.o(122603);
            return "131";
          }
        }
        else
        {
          localObject2 = com.tencent.mm.plugin.expt.hellhound.a.h.a.wpA;
          if (com.tencent.mm.plugin.expt.hellhound.a.h.a.dfT())
          {
            paramActivity = com.tencent.mm.plugin.expt.hellhound.a.h.a.wpA;
            com.tencent.mm.plugin.expt.hellhound.a.h.a.nC(false);
            AppMethodBeat.o(122603);
            return "148";
          }
        }
      }
      else if ((p.h("MainUI", paramString1)) || (p.h("AddressUIFragment", paramString1)))
      {
        localObject2 = com.tencent.mm.plugin.expt.hellhound.a.h.a.wpA;
        if (com.tencent.mm.plugin.expt.hellhound.a.h.a.dfT())
        {
          paramActivity = com.tencent.mm.plugin.expt.hellhound.a.h.a.wpA;
          com.tencent.mm.plugin.expt.hellhound.a.h.a.nC(false);
          AppMethodBeat.o(122603);
          return "148";
        }
      }
    }
    if (p.h("BaseScanUI", paramString2))
    {
      localObject2 = com.tencent.mm.plugin.expt.hellhound.a.f.g.b.a.wpb;
      if (com.tencent.mm.plugin.expt.hellhound.a.f.g.b.a.dfL())
      {
        paramActivity = com.tencent.mm.plugin.expt.hellhound.a.f.g.b.a.wpb;
        com.tencent.mm.plugin.expt.hellhound.a.f.g.b.a.nz(false);
        AppMethodBeat.o(122603);
        return "124";
      }
      localObject2 = com.tencent.mm.plugin.expt.hellhound.a.h.a.wpA;
      if (com.tencent.mm.plugin.expt.hellhound.a.h.a.dfS())
      {
        paramActivity = com.tencent.mm.plugin.expt.hellhound.a.h.a.wpA;
        com.tencent.mm.plugin.expt.hellhound.a.h.a.nB(false);
        AppMethodBeat.o(122603);
        return "109";
      }
    }
    Object localObject2 = com.tencent.mm.plugin.expt.hellhound.a.f.g.b.a.wpb;
    com.tencent.mm.plugin.expt.hellhound.a.f.g.b.a.dfL();
    if ((paramList == null) || (paramList.isEmpty()))
    {
      localObject1 = ((efb)localObject1).Uiy.iterator();
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
            localObject2 = (efd)((Iterator)localObject1).next();
          } while ((localObject2 == null) || (!p.h(((efd)localObject2).Uiw, paramString1)));
          localObject3 = ((efd)localObject2).fFe;
          p.j(localObject3, "config.pageName");
          localObject3 = n.b((CharSequence)localObject3, new String[] { "," }).iterator();
        }
        str = (String)((Iterator)localObject3).next();
        if (str == null)
        {
          paramActivity = new t("null cannot be cast to non-null type kotlin.CharSequence");
          AppMethodBeat.o(122603);
          throw paramActivity;
        }
      } while (!p.h(n.bb((CharSequence)str).toString(), paramString2));
      if (p.h(((efd)localObject2).wmA, "109"))
      {
        paramActivity = com.tencent.mm.plugin.expt.hellhound.a.h.a.wpA;
        if (com.tencent.mm.plugin.expt.hellhound.a.h.a.dfS())
        {
          paramActivity = com.tencent.mm.plugin.expt.hellhound.a.h.a.wpA;
          com.tencent.mm.plugin.expt.hellhound.a.h.a.nB(false);
          AppMethodBeat.o(122603);
          return "109";
        }
        AppMethodBeat.o(122603);
        return "124";
      }
      if ((p.h(((efd)localObject2).wmA, "105")) || (p.h(((efd)localObject2).wmA, "131")))
      {
        paramActivity = com.tencent.mm.plugin.expt.hellhound.a.f.g.b.a.wpb;
        if (com.tencent.mm.plugin.expt.hellhound.a.f.g.b.a.dfK())
        {
          paramActivity = com.tencent.mm.plugin.expt.hellhound.a.f.g.b.a.wpb;
          com.tencent.mm.plugin.expt.hellhound.a.f.g.b.a.ny(false);
          AppMethodBeat.o(122603);
          return "131";
        }
        AppMethodBeat.o(122603);
        return "105";
      }
      paramActivity = ((efd)localObject2).wmA;
      AppMethodBeat.o(122603);
      return paramActivity;
      paramActivity = a.b(paramActivity, paramString1, paramString2);
      if (paramActivity != null)
      {
        AppMethodBeat.o(122603);
        return paramActivity;
      }
    }
    Log.i("HABBYGE-MALI.HellKSessionConfig", "get sid by cloud config, but NULL, dignose sid By local config !!!");
    paramActivity = a.b(paramString1, paramString2, paramList);
    AppMethodBeat.o(122603);
    return paramActivity;
  }
  
  public static final void a(cjr paramcjr)
  {
    AppMethodBeat.i(122606);
    if (paramcjr != null)
    {
      paramcjr = paramcjr.Trf;
      p.j(paramcjr, "hellSession.sessions");
      Object localObject1 = (Iterable)paramcjr;
      paramcjr = (Collection)new ArrayList();
      localObject1 = ((Iterable)localObject1).iterator();
      Object localObject2;
      Object localObject3;
      label159:
      while (((Iterator)localObject1).hasNext())
      {
        localObject2 = ((Iterator)localObject1).next();
        localObject3 = (dhx)localObject2;
        String str = ((dhx)localObject3).sessionId;
        p.j(str, "it.sessionId");
        if ((p.h(a.ayn(str), "999")) && ((((dhx)localObject3).TOX == 0) || (((dhx)localObject3).TOX == 1) || (((dhx)localObject3).TOX == 2) || (((dhx)localObject3).TOX == 4) || (((dhx)localObject3).TOX == 5))) {}
        for (int i = 1;; i = 0)
        {
          if (i == 0) {
            break label159;
          }
          paramcjr.add(localObject2);
          break;
        }
      }
      localObject1 = j.p((Iterable)paramcjr);
      if (localObject1 == null)
      {
        AppMethodBeat.o(122606);
        return;
      }
      Log.i("HABBYGE-MALI.HellKSessionConfig", "after, sessionList.size: " + ((List)localObject1).size());
      paramcjr = null;
      localObject1 = ((List)localObject1).iterator();
      while (((Iterator)localObject1).hasNext())
      {
        localObject2 = (dhx)((Iterator)localObject1).next();
        localObject3 = a.ayp(((dhx)localObject2).sessionId);
        if (localObject3 != null) {
          paramcjr = "_" + ((com.tencent.mm.vending.j.c)localObject3).get(1);
        }
        Log.i("HABBYGE-MALI.HellKSessionConfig", "handleChatting, session, Start: " + ((dhx)localObject2).sessionId + ", " + paramcjr);
        ((dhx)localObject2).sessionId = a.KV(((dhx)localObject2).TOX);
        if ((p.h(((dhx)localObject2).sessionId, "-1") ^ true))
        {
          localObject3 = ((dhx)localObject2).sessionId;
          ((dhx)localObject2).sessionId = ((String)localObject3 + paramcjr);
        }
        Log.i("HABBYGE-MALI.HellKSessionConfig", "handleChatting, session, End: " + ((dhx)localObject2).sessionId);
      }
    }
    AppMethodBeat.o(122606);
  }
  
  public static final boolean ayA(String paramString)
  {
    AppMethodBeat.i(185600);
    if (paramString == null)
    {
      AppMethodBeat.o(185600);
      return false;
    }
    if (n.a((CharSequence)paramString, (CharSequence)"_", false))
    {
      bool = a.ayB((String)n.a((CharSequence)paramString, new String[] { "_" }).get(0));
      AppMethodBeat.o(185600);
      return bool;
    }
    boolean bool = a.ayB(paramString);
    AppMethodBeat.o(185600);
    return bool;
  }
  
  public static final String ayn(String paramString)
  {
    AppMethodBeat.i(122604);
    paramString = a.ayn(paramString);
    AppMethodBeat.o(122604);
    return paramString;
  }
  
  public static final String ayo(String paramString)
  {
    AppMethodBeat.i(122605);
    p.k(paramString, "pageId");
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
  
  public static final com.tencent.mm.vending.j.c<String, String> ayp(String paramString)
  {
    AppMethodBeat.i(177417);
    paramString = a.ayp(paramString);
    AppMethodBeat.o(177417);
    return paramString;
  }
  
  public static final void ayq(String paramString)
  {
    AppMethodBeat.i(177418);
    if (paramString == null)
    {
      AppMethodBeat.o(177418);
      return;
    }
    dhx localdhx = com.tencent.mm.plugin.expt.hellhound.a.f.c.c.dfi();
    if (localdhx == null)
    {
      AppMethodBeat.o(177418);
      return;
    }
    com.tencent.mm.vending.j.c localc = a.ayp(localdhx.sessionId);
    if (localc == null)
    {
      AppMethodBeat.o(177418);
      return;
    }
    if (!a.ayt(localdhx.sessionId))
    {
      Log.i("HABBYGE-MALI.HellKSessionConfig", "HellK, updateCurSid, old: " + localdhx.sessionId);
      paramString = paramString + "_" + localc.get(1);
      localdhx.sessionId = paramString;
      com.tencent.mm.plugin.expt.hellhound.a.f.c.c.m(localdhx);
      Log.i("HABBYGE-MALI.HellKSessionConfig", "HellK, updateCurSid, new: ".concat(String.valueOf(paramString)));
    }
    AppMethodBeat.o(177418);
  }
  
  public static final boolean ayr(String paramString)
  {
    AppMethodBeat.i(122610);
    boolean bool = a.ayr(paramString);
    AppMethodBeat.o(122610);
    return bool;
  }
  
  public static final boolean ays(String paramString)
  {
    AppMethodBeat.i(122611);
    if (paramString == null)
    {
      AppMethodBeat.o(122611);
      return false;
    }
    boolean bool = p.h("105", a.ayn(paramString));
    AppMethodBeat.o(122611);
    return bool;
  }
  
  public static final boolean ayt(String paramString)
  {
    AppMethodBeat.i(122612);
    boolean bool = a.ayt(paramString);
    AppMethodBeat.o(122612);
    return bool;
  }
  
  public static final boolean ayu(String paramString)
  {
    AppMethodBeat.i(122614);
    if (paramString == null)
    {
      AppMethodBeat.o(122614);
      return false;
    }
    paramString = a.ayn(paramString);
    if ((p.h("999", paramString)) || (a.ayr(paramString)))
    {
      AppMethodBeat.o(122614);
      return true;
    }
    AppMethodBeat.o(122614);
    return false;
  }
  
  public static final boolean ayv(String paramString)
  {
    AppMethodBeat.i(122615);
    p.k(paramString, "sid");
    boolean bool = p.h("131", paramString);
    AppMethodBeat.o(122615);
    return bool;
  }
  
  public static final List<efm> ayw(String paramString)
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
    p.j(d.deY(), "HellSessionPageCloudConfig.getInstance()");
    Object localObject = d.deZ();
    if (localObject == null)
    {
      AppMethodBeat.o(122616);
      return null;
    }
    ArrayList localArrayList = new ArrayList();
    Iterator localIterator = ((efj)localObject).UiI.iterator();
    while (localIterator.hasNext())
    {
      efm localefm = (efm)localIterator.next();
      if ((localefm != null) && (localefm.type == 0) && ((!(p.h(localefm.wmA, paramString) ^ true)) || (!(p.h(localefm.wmA, "-1") ^ true))))
      {
        localObject = localefm;
        if (!localefm.Aaj) {
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
  
  public static final Long ayx(String paramString)
  {
    AppMethodBeat.i(122618);
    paramString = a.ayx(paramString);
    AppMethodBeat.o(122618);
    return paramString;
  }
  
  public static final String ayy(String paramString)
  {
    AppMethodBeat.i(185599);
    paramString = a.ayy(paramString);
    AppMethodBeat.o(185599);
    return paramString;
  }
  
  public static final String ayz(String paramString)
  {
    AppMethodBeat.i(254329);
    if (paramString == null)
    {
      AppMethodBeat.o(254329);
      return null;
    }
    if (n.a((CharSequence)paramString, (CharSequence)"_", false))
    {
      paramString = n.a((CharSequence)paramString, new String[] { "_" });
      paramString = a.ayy((String)paramString.get(0)) + "_" + (String)paramString.get(1);
      AppMethodBeat.o(254329);
      return paramString;
    }
    AppMethodBeat.o(254329);
    return paramString;
  }
  
  public static final String deK()
  {
    AppMethodBeat.i(122621);
    String str = a.deK();
    AppMethodBeat.o(122621);
    return str;
  }
  
  public static final boolean deR()
  {
    AppMethodBeat.i(122619);
    boolean bool = a.deR();
    AppMethodBeat.o(122619);
    return bool;
  }
  
  public static final boolean deS()
  {
    AppMethodBeat.i(122620);
    String str = a.deK();
    if (!TextUtils.isEmpty((CharSequence)str))
    {
      if (str != null)
      {
        str = a.ayn(str);
        if ((!p.h("104", str)) && (!p.h("998", str))) {}
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
  
  public static final String gJ(String paramString1, String paramString2)
  {
    AppMethodBeat.i(177416);
    paramString1 = a.b(paramString1, paramString2, null);
    AppMethodBeat.o(177416);
    return paramString1;
  }
  
  public static final int gj(int paramInt1, int paramInt2)
  {
    if (paramInt1 >= paramInt2) {
      return paramInt1 + 1;
    }
    return paramInt2 + 1;
  }
  
  public static final void i(dhx paramdhx)
  {
    AppMethodBeat.i(122607);
    if (paramdhx != null)
    {
      com.tencent.mm.vending.j.c localc = a.ayp(paramdhx.sessionId);
      if (localc == null)
      {
        AppMethodBeat.o(122607);
        return;
      }
      if (!(p.h("999", localc.get(0)) ^ true))
      {
        String str = a.KV(paramdhx.TOX);
        paramdhx.sessionId = (str + "_" + localc.get(1));
      }
    }
    AppMethodBeat.o(122607);
  }
  
  public static final String j(dhx paramdhx)
  {
    AppMethodBeat.i(122608);
    if (paramdhx == null)
    {
      AppMethodBeat.o(122608);
      return null;
    }
    Object localObject1 = a.ayp(paramdhx.sessionId);
    if (localObject1 == null)
    {
      paramdhx = paramdhx.sessionId;
      AppMethodBeat.o(122608);
      return paramdhx;
    }
    if ((p.h("999", ((com.tencent.mm.vending.j.c)localObject1).get(0)) ^ true))
    {
      localObject2 = ((com.tencent.mm.vending.j.c)localObject1).get(0);
      if (!(localObject2 instanceof Integer)) {}
      while (-1 != ((Integer)localObject2).intValue())
      {
        paramdhx = paramdhx.sessionId;
        AppMethodBeat.o(122608);
        return paramdhx;
      }
    }
    Object localObject2 = a.KV(paramdhx.TOX);
    localObject1 = (String)localObject2 + "_" + ((com.tencent.mm.vending.j.c)localObject1).get(1);
    paramdhx.sessionId = ((String)localObject1);
    AppMethodBeat.o(122608);
    return localObject1;
  }
  
  public static final String k(dhx paramdhx)
  {
    AppMethodBeat.i(122609);
    if (paramdhx == null)
    {
      AppMethodBeat.o(122609);
      return null;
    }
    com.tencent.mm.vending.j.c localc = a.ayp(paramdhx.sessionId);
    if (localc == null)
    {
      paramdhx = paramdhx.sessionId;
      AppMethodBeat.o(122609);
      return paramdhx;
    }
    if ((p.h("999", localc.get(0)) ^ true))
    {
      paramdhx = paramdhx.sessionId;
      p.j(paramdhx, "pageSession.sessionId");
      paramdhx = a.ayn(paramdhx);
      AppMethodBeat.o(122609);
      return paramdhx;
    }
    Log.i("HABBYGE-MALI.HellKSessionConfig", "getRealChatSessionId: " + paramdhx.TOX);
    paramdhx = a.KV(paramdhx.TOX);
    AppMethodBeat.o(122609);
    return paramdhx;
  }
  
  public static final String u(long paramLong, int paramInt)
  {
    AppMethodBeat.i(122617);
    String str = String.valueOf(paramLong) + "_" + paramInt;
    AppMethodBeat.o(122617);
    return str;
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/expt/hellhound/ext/session/config/HellKSessionConfig$Companion;", "", "()V", "CHATTING_UI", "", "CHATTING_UI_FRAGMENT", "ILLEGAL_CONFIG_ID", "SESSION_ID_ADDRESS_ADD_FRIEND", "SESSION_ID_ADDRESS_SEARCH", "SESSION_ID_ADD_FRIEND", "SESSION_ID_APPBRAND", "SESSION_ID_AppBrandLauncherUI", "SESSION_ID_BIZ_LIST", "SESSION_ID_BIZ_MESSAGE", "SESSION_ID_BaseScanUI", "SESSION_ID_BottleBeachUI", "SESSION_ID_CHAT", "SESSION_ID_CHAT_PLUGIN_WECHAT_MOVEMENT", "SESSION_ID_CHAT_ROOM", "SESSION_ID_CHAT_SERVICE", "SESSION_ID_CHAT_SERVICE_NOTIFY", "SESSION_ID_CHAT_VIRTUAL", "SESSION_ID_CONTACT_BIZ", "SESSION_ID_CardHomePageUI", "SESSION_ID_ChatroomContactUI", "SESSION_ID_ContactInfoUI", "SESSION_ID_ContactLabelManagerUI", "SESSION_ID_ENTERPRISE", "SESSION_ID_EmojiStoreV2UI", "SESSION_ID_FINDER", "SESSION_ID_FIND_SEARCH", "SESSION_ID_FMessageConversationUI", "SESSION_ID_FTSSOSHomeWebViewUI", "SESSION_ID_FavoriteIndexUI", "SESSION_ID_Finder_Profile", "SESSION_ID_FloatingWindow", "SESSION_ID_GAME", "SESSION_ID_GLOBAL_SEARCH", "SESSION_ID_HELP", "SESSION_ID_LIVING", "SESSION_ID_MINI_GAME", "SESSION_ID_MallIndexUI", "SESSION_ID_NEW_NEARBY", "SESSION_ID_NearbyFriendsUI", "SESSION_ID_Nearby_Rest", "SESSION_ID_ONLY_CAHT_FRIENDS", "SESSION_ID_OpenIMAddressUI", "SESSION_ID_SEARCH_BaseScanUI", "SESSION_ID_SELECT_CONTACTUI", "SESSION_ID_SettingsPersonalInfoUI", "SESSION_ID_SettingsUI", "SESSION_ID_ShakeReportUI", "SESSION_ID_SnsTimeLineUI", "SESSION_ID_SnsUserUI", "SESSION_ID_StoryCaptureUI", "SESSION_ID_StoryGalleryView", "SESSION_ID_TENCENT_NEWS", "SESSION_ID_TopStoryHomeUI", "SESSION_ID_VOIP_FloatingWindow", "SESSION_ID_WalletOfflineEntranceUI", "SESSION_ID_WebViewUI_jd_store", "TAB_AddressUIFragment", "TAB_FindMoreFriendsUI", "TAB_MainUI", "TAB_MoreTabUI", "TAG", "mSessionIdEntryListLocal", "", "Lcom/tencent/mm/plugin/expt/hellhound/ext/session/dao/SessionKEntry;", "convertChatSid", "", "hellSession", "Lcom/tencent/mm/protocal/protobuf/HellSession;", "pageSession", "Lcom/tencent/mm/protocal/protobuf/PageSession;", "cutInvalidatePageKeyToName", "pageId", "cutSessonToSid", "session", "doNotNeedSessionMonitor", "", "generateSeq", "", "seqOfPage", "seqOfUBA", "getBizIdOfSessionParam", "timestamp", "", "seq", "getCurSession", "getCurSid", "getIdentifySidExpect", "curActivity", "Landroid/app/Activity;", "srcPage", "dstPage", "getLastSession", "getPageStartTimeOfBizId", "bizId", "(Ljava/lang/String;)Ljava/lang/Long;", "getRealChatSid", "chattingType", "getRealChatSidLocal", "getSessionPageOfConfig", "Lcom/tencent/mm/protocal/protobuf/SessionPagePath;", "sid", "isDetailReport", "getSidId", "args", "getSidLocal", "getTabIdOfLauncher", "tabPageName", "getTabSessionIdOfLauncher", "sessionId", "isAppBrandSession", "isBizSid", "isChatSessionId", "isChatSid", "isCurBizSid", "isEffectiveSession", "sessoinId", "isEffectiveSessionBySid", "isFloatSession", "isJdSid", "isVoipSession", "spliteSession", "Lcom/tencent/mm/vending/tuple/Tuple2;", "updateCurSid", "updateRealChatSessionId", "plugin-expt_release"})
  public static final class a
  {
    static String KV(int paramInt)
    {
      AppMethodBeat.i(122595);
      p.j(c.deU(), "HellSessionCloudConfig.getInstance()");
      Object localObject = c.deV();
      if (localObject == null)
      {
        localObject = KW(paramInt);
        AppMethodBeat.o(122595);
        return localObject;
      }
      if (((efb)localObject).jis)
      {
        Log.e("HABBYGE-MALI.HellKSessionConfig", "getRealChatSid, configCloud.isDel");
        AppMethodBeat.o(122595);
        return "-1";
      }
      localObject = ((efb)localObject).Uiz.iterator();
      while (((Iterator)localObject).hasNext())
      {
        efa localefa = (efa)((Iterator)localObject).next();
        if (localefa != null)
        {
          Log.i("HABBYGE-MALI.HellKSessionConfig", "getRealChatSid, chatConfig.expect=" + localefa.Uix);
          if (Util.getInt(localefa.Uix, -1) == paramInt)
          {
            localObject = localefa.wmA;
            p.j(localObject, "chatConfig.sid");
            AppMethodBeat.o(122595);
            return localObject;
          }
        }
      }
      localObject = KW(paramInt);
      AppMethodBeat.o(122595);
      return localObject;
    }
    
    private static String KW(int paramInt)
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
        Log.i("HABBYGE-MALI.HellKSessionConfig", "getRealChatSidLocal: ".concat(String.valueOf(str)));
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
    
    static boolean ayB(String paramString)
    {
      AppMethodBeat.i(185598);
      if ((p.h(paramString, "0")) || (p.h(paramString, "1")) || (p.h(paramString, "2")) || (p.h(paramString, "3")))
      {
        AppMethodBeat.o(185598);
        return false;
      }
      boolean bool = com.tencent.mm.plugin.expt.hellhound.core.b.isNumeric(paramString);
      AppMethodBeat.o(185598);
      return bool;
    }
    
    public static String ayn(String paramString)
    {
      AppMethodBeat.i(122593);
      p.k(paramString, "session");
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
      p.j(paramString, "(this as java.lang.Strin…ing(startIndex, endIndex)");
      AppMethodBeat.o(122593);
      return paramString;
    }
    
    public static com.tencent.mm.vending.j.c<String, String> ayp(String paramString)
    {
      AppMethodBeat.i(122594);
      if (paramString != null)
      {
        if (p.compare(paramString.length(), 4) <= 0)
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
        if (p.compare(paramString.size(), 2) != 0)
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
      paramString = com.tencent.mm.vending.j.a.J(paramString.get(0), paramString.get(1));
      AppMethodBeat.o(122594);
      return paramString;
    }
    
    public static boolean ayr(String paramString)
    {
      AppMethodBeat.i(122597);
      if ((p.h("101", paramString)) || (p.h("102", paramString)) || (p.h("103", paramString)) || (p.h("111", paramString)) || (p.h("112", paramString)))
      {
        AppMethodBeat.o(122597);
        return true;
      }
      AppMethodBeat.o(122597);
      return false;
    }
    
    public static boolean ayt(String paramString)
    {
      AppMethodBeat.i(253014);
      if (paramString == null)
      {
        AppMethodBeat.o(253014);
        return false;
      }
      boolean bool = p.h("145", ayn(paramString));
      AppMethodBeat.o(253014);
      return bool;
    }
    
    public static Long ayx(String paramString)
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
        paramString = Long.valueOf(l);
      }
      catch (Exception paramString)
      {
        for (;;)
        {
          Log.printErrStackTrace("HABBYGE-MALI.HellKSessionConfig", (Throwable)paramString, "getPageStartTimeOfBusinessId, crash: " + paramString.getMessage(), new Object[0]);
          paramString = null;
        }
      }
      AppMethodBeat.o(122598);
      return paramString;
    }
    
    public static String ayy(String paramString)
    {
      AppMethodBeat.i(253021);
      if (paramString == null)
      {
        AppMethodBeat.o(253021);
        return null;
      }
      if (n.a((CharSequence)paramString, (CharSequence)".", false))
      {
        if (p.h(paramString, com.tencent.mm.plugin.expt.hellhound.core.b.weS))
        {
          AppMethodBeat.o(253021);
          return "0";
        }
        if (p.h(paramString, com.tencent.mm.plugin.expt.hellhound.core.b.weT))
        {
          AppMethodBeat.o(253021);
          return "1";
        }
        if (p.h(paramString, com.tencent.mm.plugin.expt.hellhound.core.b.weU))
        {
          AppMethodBeat.o(253021);
          return "2";
        }
        if (p.h(paramString, com.tencent.mm.plugin.expt.hellhound.core.b.weV))
        {
          AppMethodBeat.o(253021);
          return "3";
        }
        AppMethodBeat.o(253021);
        return paramString;
      }
      if (p.h(paramString, com.tencent.mm.plugin.expt.hellhound.core.b.weX))
      {
        AppMethodBeat.o(253021);
        return "0";
      }
      if (p.h(paramString, com.tencent.mm.plugin.expt.hellhound.core.b.weY))
      {
        AppMethodBeat.o(253021);
        return "1";
      }
      if (p.h(paramString, com.tencent.mm.plugin.expt.hellhound.core.b.weZ))
      {
        AppMethodBeat.o(253021);
        return "2";
      }
      if (p.h(paramString, com.tencent.mm.plugin.expt.hellhound.core.b.wfa))
      {
        AppMethodBeat.o(253021);
        return "3";
      }
      AppMethodBeat.o(253021);
      return paramString;
    }
    
    static String b(Activity paramActivity, String paramString1, String paramString2)
    {
      AppMethodBeat.i(122591);
      p.j(c.deU(), "HellSessionCloudConfig.getInstance()");
      Object localObject1 = c.deV();
      if (localObject1 == null)
      {
        AppMethodBeat.o(122591);
        return null;
      }
      eff localeff;
      do
      {
        String str;
        do
        {
          localObject1 = ((efb)localObject1).UiB.iterator();
          Object localObject2;
          while (!((Iterator)localObject2).hasNext())
          {
            do
            {
              if (!((Iterator)localObject1).hasNext()) {
                break;
              }
              localeff = (eff)((Iterator)localObject1).next();
            } while ((localeff == null) || (localeff.UiE.isEmpty()) || ((p.h(localeff.Uiw, paramString1) ^ true)));
            localObject2 = localeff.fFe;
            p.j(localObject2, "config.pageName");
            localObject2 = n.a((CharSequence)localObject2, new String[] { "," }).iterator();
          }
          str = (String)((Iterator)localObject2).next();
          if (str == null)
          {
            paramActivity = new t("null cannot be cast to non-null type kotlin.CharSequence");
            AppMethodBeat.o(122591);
            throw paramActivity;
          }
        } while (!p.h(n.bb((CharSequence)str).toString(), paramString2));
        Log.i("HABBYGE-MALI.HellKSessionConfig", "getIdentifySidExpect, sid: " + localeff.wmA);
      } while (!a.a(paramActivity, localeff));
      paramActivity = localeff.wmA;
      AppMethodBeat.o(122591);
      return paramActivity;
      AppMethodBeat.o(122591);
      return null;
    }
    
    public static String b(String paramString1, String paramString2, List<String> paramList)
    {
      AppMethodBeat.i(122592);
      paramString1 = com.tencent.mm.plugin.expt.hellhound.core.b.awD(paramString1);
      String str1 = com.tencent.mm.plugin.expt.hellhound.core.b.awD(paramString2);
      Log.i("HABBYGE-MALI.HellKSessionConfig", "getSessionIdLocal: " + paramString1 + ", " + str1);
      if (((p.h("ChattingUI", paramString2)) || (p.h("ChattingUIFragment", paramString2))) && ((p.h(com.tencent.mm.plugin.expt.hellhound.core.b.weX, paramString1)) || (TextUtils.isEmpty((CharSequence)paramString1))))
      {
        Log.i("HABBYGE-MALI.HellKSessionConfig", "getSidId: 999");
        AppMethodBeat.o(122592);
        return "999";
      }
      if ((p.h("WebViewUI", str1)) && ((p.h("FindMoreFriendsUI", paramString1)) || (p.h("MainUI", paramString1)) || (p.h("AddressUIFragment", paramString1))))
      {
        paramString2 = com.tencent.mm.plugin.expt.hellhound.a.h.a.wpA;
        if (com.tencent.mm.plugin.expt.hellhound.a.h.a.dfT())
        {
          AppMethodBeat.o(122592);
          return "148";
        }
      }
      if (p.h("BaseScanUI", str1))
      {
        paramString2 = com.tencent.mm.plugin.expt.hellhound.a.f.g.b.a.wpb;
        if (com.tencent.mm.plugin.expt.hellhound.a.f.g.b.a.dfL())
        {
          AppMethodBeat.o(122592);
          return "124";
        }
        paramString2 = com.tencent.mm.plugin.expt.hellhound.a.h.a.wpA;
        if (com.tencent.mm.plugin.expt.hellhound.a.h.a.dfS())
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
          paramString2 = b.deQ().iterator();
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
            } while (!p.h(paramString1, paramList.woF));
            localObject = paramList.woG.iterator();
          }
        } while (!p.h(str1, (String)((Iterator)localObject).next()));
        if (p.h(paramList.sessionId, "109"))
        {
          paramString1 = com.tencent.mm.plugin.expt.hellhound.a.h.a.wpA;
          if (com.tencent.mm.plugin.expt.hellhound.a.h.a.dfS())
          {
            AppMethodBeat.o(122592);
            return "109";
          }
          AppMethodBeat.o(122592);
          return "124";
        }
        if ((p.h(paramList.sessionId, "105")) || (p.h(paramList.sessionId, "131")))
        {
          paramString1 = com.tencent.mm.plugin.expt.hellhound.a.f.g.b.a.wpb;
          if (com.tencent.mm.plugin.expt.hellhound.a.f.g.b.a.dfK())
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
      paramString2 = b.deQ().iterator();
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
        if ((p.h(paramString1, ((i)localObject).woF) ^ true)) {
          break label653;
        }
        Iterator localIterator = ((i)localObject).woG.iterator();
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
              if (p.h(str2, (String)paramList.get(i))) {
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
          if ((p.h(str1, str2) ^ true)) {
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
    
    public static String deK()
    {
      AppMethodBeat.i(122601);
      String str = deT();
      if (str == null)
      {
        AppMethodBeat.o(122601);
        return null;
      }
      str = ayn(str);
      AppMethodBeat.o(122601);
      return str;
    }
    
    public static boolean deR()
    {
      AppMethodBeat.i(122599);
      if (!com.tencent.mm.plugin.expt.hellhound.a.dcg())
      {
        Log.i("HABBYGE-MALI.HellKSessionConfig", "HellSessionMonitor monitor, fetchHellhoundConfig: FALSE");
        AppMethodBeat.o(122599);
        return true;
      }
      p.j(c.deU(), "HellSessionCloudConfig.getInstance()");
      if ((c.deW()) || (com.tencent.mm.plugin.expt.hellhound.core.b.getUin() == 0))
      {
        Log.i("HABBYGE-MALI.HellKSessionConfig", "HellSessionMonitor monitor FALSE");
        AppMethodBeat.o(122599);
        return true;
      }
      if (!com.tencent.mm.plugin.expt.hellhound.a.dci())
      {
        Log.i("HABBYGE-MALI.HellKSessionConfig", "HellSessionMonitor monitor, close !!!");
        AppMethodBeat.o(122599);
        return true;
      }
      AppMethodBeat.o(122599);
      return false;
    }
    
    public static String deT()
    {
      AppMethodBeat.i(122600);
      Object localObject = com.tencent.mm.plugin.expt.hellhound.a.f.c.c.dfi();
      if (localObject == null)
      {
        AppMethodBeat.o(122600);
        return null;
      }
      localObject = ((dhx)localObject).sessionId;
      AppMethodBeat.o(122600);
      return localObject;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.expt.hellhound.a.f.b.b
 * JD-Core Version:    0.7.0.1
 */