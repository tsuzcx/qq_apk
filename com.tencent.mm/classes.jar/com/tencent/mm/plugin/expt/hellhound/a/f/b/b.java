package com.tencent.mm.plugin.expt.hellhound.a.f.b;

import android.app.Activity;
import android.text.TextUtils;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.expt.hellhound.a.f.c.i;
import com.tencent.mm.protocal.protobuf.cbo;
import com.tencent.mm.protocal.protobuf.cyl;
import com.tencent.mm.protocal.protobuf.duy;
import com.tencent.mm.protocal.protobuf.duz;
import com.tencent.mm.protocal.protobuf.dva;
import com.tencent.mm.protocal.protobuf.dvb;
import com.tencent.mm.protocal.protobuf.dvd;
import com.tencent.mm.protocal.protobuf.dvh;
import com.tencent.mm.protocal.protobuf.dvk;
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

@l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/expt/hellhound/ext/session/config/HellKSessionConfig;", "", "()V", "Companion", "plugin-expt_release"})
public final class b
{
  private static final List<i> sIx;
  public static final a sIy;
  
  static
  {
    AppMethodBeat.i(122602);
    sIy = new a((byte)0);
    sIx = j.listOf(new i[] { new i("999", com.tencent.mm.plugin.expt.hellhound.core.b.szb, (List)j.ac(new String[] { "ChattingUIFragment", "ChattingUI" })), new i("998", com.tencent.mm.plugin.expt.hellhound.core.b.szb, (List)j.ac(new String[] { "BizConversationUI" })), new i("104", com.tencent.mm.plugin.expt.hellhound.core.b.szb, (List)j.ac(new String[] { "BizTimeLineUI" })), new i("105", com.tencent.mm.plugin.expt.hellhound.core.b.szb, (List)j.ac(new String[] { "AppBrandLaunchProxyUI", "AppBrandUI", "AppBrandUI1", "AppBrandUI2", "AppBrandUI3", "AppBrandUI4" })), new i("105", com.tencent.mm.plugin.expt.hellhound.core.b.szb, (List)j.ac(new String[] { "AppBrandUI", "AppBrandUI1", "AppBrandUI2", "AppBrandUI3", "AppBrandUI4" })), new i("105", "LauncherUI", (List)j.ac(new String[] { "AppBrandLaunchProxyUI", "AppBrandUI", "AppBrandUI1", "AppBrandUI2", "AppBrandUI3", "AppBrandUI4" })), new i("105", "LauncherUI", (List)j.ac(new String[] { "AppBrandUI", "AppBrandUI1", "AppBrandUI2", "AppBrandUI3", "AppBrandUI4" })), new i("105", com.tencent.mm.plugin.expt.hellhound.core.b.szb, (List)j.ac(new String[] { "AppBrandLauncherUI" })), new i("105", "LauncherUI", (List)j.ac(new String[] { "AppBrandLauncherUI" })), new i("105", "WXShortcutEntryActivity", (List)j.ac(new String[] { "AppBrandLaunchProxyUI", "AppBrandUI", "AppBrandUI1", "AppBrandUI2", "AppBrandUI3", "AppBrandUI4" })), new i("105", com.tencent.mm.plugin.expt.hellhound.core.b.szc, (List)j.ac(new String[] { "AppBrandLaunchProxyUI", "AppBrandUI", "AppBrandUI1", "AppBrandUI2", "AppBrandUI3", "AppBrandUI4" })), new i("105", com.tencent.mm.plugin.expt.hellhound.core.b.szd, (List)j.ac(new String[] { "AppBrandLaunchProxyUI", "AppBrandUI", "AppBrandUI1", "AppBrandUI2", "AppBrandUI3", "AppBrandUI4" })), new i("105", com.tencent.mm.plugin.expt.hellhound.core.b.sze, (List)j.ac(new String[] { "AppBrandLaunchProxyUI", "AppBrandUI", "AppBrandUI1", "AppBrandUI2", "AppBrandUI3", "AppBrandUI4" })), new i("113", com.tencent.mm.plugin.expt.hellhound.core.b.szb, (List)j.ac(new String[] { "ReaderAppUI" })), new i("114", com.tencent.mm.plugin.expt.hellhound.core.b.szc, (List)j.ac(new String[] { "FTSMainUI" })), new i("147", com.tencent.mm.plugin.expt.hellhound.core.b.szd, (List)j.ac(new String[] { "FTSMainUI" })), new i("115", com.tencent.mm.plugin.expt.hellhound.core.b.szc, (List)j.ac(new String[] { "AddMoreFriendsUI" })), new i("116", com.tencent.mm.plugin.expt.hellhound.core.b.szc, (List)j.ac(new String[] { "FMessageConversationUI" })), new i("117", com.tencent.mm.plugin.expt.hellhound.core.b.szc, (List)j.ac(new String[] { "ChatroomContactUI" })), new i("118", com.tencent.mm.plugin.expt.hellhound.core.b.szc, (List)j.ac(new String[] { "ContactLabelManagerUI" })), new i("106", com.tencent.mm.plugin.expt.hellhound.core.b.szb, (List)j.ac(new String[] { "FTSMainUI" })), new i("107", com.tencent.mm.plugin.expt.hellhound.core.b.szb, (List)j.ac(new String[] { "SelectContactUI" })), new i("107", com.tencent.mm.plugin.expt.hellhound.core.b.szc, (List)j.ac(new String[] { "SelectContactUI" })), new i("107", com.tencent.mm.plugin.expt.hellhound.core.b.szd, (List)j.ac(new String[] { "SelectContactUI" })), new i("108", com.tencent.mm.plugin.expt.hellhound.core.b.szb, (List)j.ac(new String[] { "AddMoreFriendsUI" })), new i("108", com.tencent.mm.plugin.expt.hellhound.core.b.szc, (List)j.ac(new String[] { "AddMoreFriendsUI" })), new i("108", com.tencent.mm.plugin.expt.hellhound.core.b.szd, (List)j.ac(new String[] { "AddMoreFriendsUI" })), new i("109", com.tencent.mm.plugin.expt.hellhound.core.b.szb, (List)j.ac(new String[] { "BaseScanUI" })), new i("109", com.tencent.mm.plugin.expt.hellhound.core.b.szc, (List)j.ac(new String[] { "BaseScanUI" })), new i("109", com.tencent.mm.plugin.expt.hellhound.core.b.szd, (List)j.ac(new String[] { "BaseScanUI" })), new i("110", com.tencent.mm.plugin.expt.hellhound.core.b.szb, (List)j.ac(new String[] { "WalletOfflineEntranceUI" })), new i("110", com.tencent.mm.plugin.expt.hellhound.core.b.szc, (List)j.ac(new String[] { "WalletOfflineEntranceUI" })), new i("110", com.tencent.mm.plugin.expt.hellhound.core.b.szd, (List)j.ac(new String[] { "WalletOfflineEntranceUI" })), new i("119", com.tencent.mm.plugin.expt.hellhound.core.b.szc, (List)j.ac(new String[] { "BrandServiceIndexUI" })), new i("120", com.tencent.mm.plugin.expt.hellhound.core.b.szc, (List)j.ac(new String[] { "EnterpriseBizContactListUI" })), new i("121", "AddressUIFragment", (List)j.ac(new String[] { "OpenIMAddressUI" })), new i("122", "AddressUIFragment", (List)j.ac(new String[] { "ContactInfoUI" })), new i("123", com.tencent.mm.plugin.expt.hellhound.core.b.szd, (List)j.ac(new String[] { "SnsTimeLineUI" })), new i("124", com.tencent.mm.plugin.expt.hellhound.core.b.szd, (List)j.ac(new String[] { "BaseScanUI" })), new i("125", com.tencent.mm.plugin.expt.hellhound.core.b.szd, (List)j.ac(new String[] { "ShakeReportUI" })), new i("126", com.tencent.mm.plugin.expt.hellhound.core.b.szd, (List)j.ac(new String[] { "TopStoryHomeUI" })), new i("127", com.tencent.mm.plugin.expt.hellhound.core.b.szd, (List)j.ac(new String[] { "FTSSOSHomeWebViewUI" })), new i("128", com.tencent.mm.plugin.expt.hellhound.core.b.szd, (List)j.ac(new String[] { "NearbyFriendsIntroUI", "NearbyFriendsUI", "NearbyPersonalInfoUI", "NearbyFriendShowSayHiUI" })), new i("129", com.tencent.mm.plugin.expt.hellhound.core.b.szd, (List)j.ac(new String[] { "BottleBeachUI" })), new i("130", com.tencent.mm.plugin.expt.hellhound.core.b.szd, (List)j.ac(new String[] { "AppBrandPluginUI" })), new i("131", com.tencent.mm.plugin.expt.hellhound.core.b.szd, (List)j.ac(new String[] { "WebViewUI", "1", "jd_store" })), new i("131", com.tencent.mm.plugin.expt.hellhound.core.b.szd, (List)j.ac(new String[] { "AppBrandLaunchProxyUI", "AppBrandUI", "AppBrandUI1", "AppBrandUI2", "AppBrandUI3", "AppBrandUI4" })), new i("132", com.tencent.mm.plugin.expt.hellhound.core.b.szd, (List)j.ac(new String[] { "GameWebViewUI" })), new i("132", com.tencent.mm.plugin.expt.hellhound.core.b.szd, (List)j.ac(new String[] { "GameCenterUI" })), new i("132", com.tencent.mm.plugin.expt.hellhound.core.b.szd, (List)j.ac(new String[] { "LuggageGameWebViewUI" })), new i("132", com.tencent.mm.plugin.expt.hellhound.core.b.szd, (List)j.ac(new String[] { "GameWebViewMpUI" })), new i("132", com.tencent.mm.plugin.expt.hellhound.core.b.szd, (List)j.ac(new String[] { "LuggageGameWebViewMpUI" })), new i("133", com.tencent.mm.plugin.expt.hellhound.core.b.szd, (List)j.ac(new String[] { "AppBrandLauncherUI" })), new i("134", com.tencent.mm.plugin.expt.hellhound.core.b.sze, (List)j.ac(new String[] { "SettingsPersonalInfoUI" })), new i("135", com.tencent.mm.plugin.expt.hellhound.core.b.sze, (List)j.ac(new String[] { "MallIndexUI", "MallIndexUIv2" })), new i("136", com.tencent.mm.plugin.expt.hellhound.core.b.sze, (List)j.ac(new String[] { "FavoriteIndexUI" })), new i("137", com.tencent.mm.plugin.expt.hellhound.core.b.sze, (List)j.ac(new String[] { "SnsUserUI", "AlbumUI" })), new i("138", com.tencent.mm.plugin.expt.hellhound.core.b.sze, (List)j.ac(new String[] { "CardHomePageNewUI", "CardHomePageUI", "CardIndexUI", "CardInvalidCardUI", "CardViewUI", "ShareCardListUI", "CardHomePageV3UI" })), new i("139", "MoreTabUI", (List)j.ac(new String[] { "EmojiStoreV2UI", "MMFlutterActivity" })), new i("140", "MoreTabUI", (List)j.ac(new String[] { "SettingsUI" })), new i("141", "MoreTabUI", (List)j.ac(new String[] { "StoryCaptureUI", "MMRecordUI" })), new i("142", "MoreTabUI", (List)j.ac(new String[] { "StoryGalleryView", "StoryVideoView" })), new i("143", "FindMoreFriendsUI", (List)j.ac(new String[] { "FinderTimelineUI" })), new i("143", "FindMoreFriendsUI", (List)j.ac(new String[] { "FinderHomeUI" })), new i("143", "FindMoreFriendsUI", (List)j.ac(new String[] { "FinderConversationUI" })), new i("143", "AddressUIFragment", (List)j.ac(new String[] { "FinderTimelineUI" })), new i("143", "FinderHomeUI", (List)j.ac(new String[] { "FinderSelfUI" })), new i("145", "LauncherUI", (List)j.ac(new String[] { "FloatingBall" })), new i("146", "LauncherUI", (List)j.ac(new String[] { "VideoActivity" })), new i("149", "AddressUIFragment", (List)j.ac(new String[] { "OnlyChatContactMgrUI" })), new i("150", com.tencent.mm.plugin.expt.hellhound.core.b.szd, (List)j.ac(new String[] { "NearbyHomeUI" })) });
    AppMethodBeat.o(122602);
  }
  
  public static final String a(Activity paramActivity, String paramString1, String paramString2, List<String> paramList)
  {
    AppMethodBeat.i(122603);
    paramString1 = com.tencent.mm.plugin.expt.hellhound.core.b.aoE(paramString1);
    Log.i("HABBYGE-MALI.HellKSessionConfig", "getSidId: " + paramString1 + ", " + paramString2);
    p.g(c.cQa(), "HellSessionCloudConfig.getInstance()");
    Object localObject1 = c.cQb();
    if (localObject1 == null)
    {
      paramActivity = a.a(paramString1, paramString2, paramList);
      AppMethodBeat.o(122603);
      return paramActivity;
    }
    if (((duz)localObject1).gyp)
    {
      Log.e("HABBYGE-MALI.HellKSessionConfig", "getSidId, sessionCloud.isDel ture");
      AppMethodBeat.o(122603);
      return null;
    }
    if (((p.j("ChattingUI", paramString2)) || (p.j("ChattingUIFragment", paramString2))) && ((p.j(com.tencent.mm.plugin.expt.hellhound.core.b.szb, paramString1)) || (TextUtils.isEmpty((CharSequence)paramString1))))
    {
      Log.i("HABBYGE-MALI.HellKSessionConfig", "getSidId: 999");
      AppMethodBeat.o(122603);
      return "999";
    }
    if (p.j("WebViewUI", paramString2)) {
      if (p.j("FindMoreFriendsUI", paramString1))
      {
        if (((duz)localObject1).MWf != null)
        {
          if ((paramList != null) && (paramList.size() >= 2) && (p.j(((duz)localObject1).MWf.MWh, (String)paramList.get(0))) && (p.j(((duz)localObject1).MWf.MWi, (String)paramList.get(1))))
          {
            Log.i("HABBYGE-MALI.HellKSessionConfig", "getSidId, SESSION_ID_WebViewUI_jd_store");
            AppMethodBeat.o(122603);
            return "131";
          }
        }
        else
        {
          localObject2 = com.tencent.mm.plugin.expt.hellhound.a.h.a.sJC;
          if (com.tencent.mm.plugin.expt.hellhound.a.h.a.cQY())
          {
            paramActivity = com.tencent.mm.plugin.expt.hellhound.a.h.a.sJC;
            com.tencent.mm.plugin.expt.hellhound.a.h.a.mp(false);
            AppMethodBeat.o(122603);
            return "148";
          }
        }
      }
      else if ((p.j("MainUI", paramString1)) || (p.j("AddressUIFragment", paramString1)))
      {
        localObject2 = com.tencent.mm.plugin.expt.hellhound.a.h.a.sJC;
        if (com.tencent.mm.plugin.expt.hellhound.a.h.a.cQY())
        {
          paramActivity = com.tencent.mm.plugin.expt.hellhound.a.h.a.sJC;
          com.tencent.mm.plugin.expt.hellhound.a.h.a.mp(false);
          AppMethodBeat.o(122603);
          return "148";
        }
      }
    }
    if (p.j("BaseScanUI", paramString2))
    {
      localObject2 = com.tencent.mm.plugin.expt.hellhound.a.f.g.b.a.sJe;
      if (com.tencent.mm.plugin.expt.hellhound.a.f.g.b.a.cQQ())
      {
        paramActivity = com.tencent.mm.plugin.expt.hellhound.a.f.g.b.a.sJe;
        com.tencent.mm.plugin.expt.hellhound.a.f.g.b.a.mm(false);
        AppMethodBeat.o(122603);
        return "124";
      }
      localObject2 = com.tencent.mm.plugin.expt.hellhound.a.h.a.sJC;
      if (com.tencent.mm.plugin.expt.hellhound.a.h.a.cQX())
      {
        paramActivity = com.tencent.mm.plugin.expt.hellhound.a.h.a.sJC;
        com.tencent.mm.plugin.expt.hellhound.a.h.a.mo(false);
        AppMethodBeat.o(122603);
        return "109";
      }
    }
    Object localObject2 = com.tencent.mm.plugin.expt.hellhound.a.f.g.b.a.sJe;
    com.tencent.mm.plugin.expt.hellhound.a.f.g.b.a.cQQ();
    if ((paramList == null) || (paramList.isEmpty()))
    {
      localObject1 = ((duz)localObject1).MWd.iterator();
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
            localObject2 = (dvb)((Iterator)localObject1).next();
          } while ((localObject2 == null) || (!p.j(((dvb)localObject2).MWb, paramString1)));
          localObject3 = ((dvb)localObject2).dMl;
          p.g(localObject3, "config.pageName");
          localObject3 = n.b((CharSequence)localObject3, new String[] { "," }).iterator();
        }
        str = (String)((Iterator)localObject3).next();
        if (str == null)
        {
          paramActivity = new t("null cannot be cast to non-null type kotlin.CharSequence");
          AppMethodBeat.o(122603);
          throw paramActivity;
        }
      } while (!p.j(n.trim((CharSequence)str).toString(), paramString2));
      if (p.j(((dvb)localObject2).sGF, "109"))
      {
        paramActivity = com.tencent.mm.plugin.expt.hellhound.a.h.a.sJC;
        if (com.tencent.mm.plugin.expt.hellhound.a.h.a.cQX())
        {
          paramActivity = com.tencent.mm.plugin.expt.hellhound.a.h.a.sJC;
          com.tencent.mm.plugin.expt.hellhound.a.h.a.mo(false);
          AppMethodBeat.o(122603);
          return "109";
        }
        AppMethodBeat.o(122603);
        return "124";
      }
      if ((p.j(((dvb)localObject2).sGF, "105")) || (p.j(((dvb)localObject2).sGF, "131")))
      {
        paramActivity = com.tencent.mm.plugin.expt.hellhound.a.f.g.b.a.sJe;
        if (com.tencent.mm.plugin.expt.hellhound.a.f.g.b.a.cQP())
        {
          paramActivity = com.tencent.mm.plugin.expt.hellhound.a.f.g.b.a.sJe;
          com.tencent.mm.plugin.expt.hellhound.a.f.g.b.a.ml(false);
          AppMethodBeat.o(122603);
          return "131";
        }
        AppMethodBeat.o(122603);
        return "105";
      }
      paramActivity = ((dvb)localObject2).sGF;
      AppMethodBeat.o(122603);
      return paramActivity;
      paramActivity = a.a(paramActivity, paramString1, paramString2);
      if (paramActivity != null)
      {
        AppMethodBeat.o(122603);
        return paramActivity;
      }
    }
    Log.i("HABBYGE-MALI.HellKSessionConfig", "get sid by cloud config, but NULL, dignose sid By local config !!!");
    paramActivity = a.a(paramString1, paramString2, paramList);
    AppMethodBeat.o(122603);
    return paramActivity;
  }
  
  public static final void a(cbo paramcbo)
  {
    AppMethodBeat.i(122606);
    if (paramcbo != null)
    {
      paramcbo = paramcbo.Mhr;
      p.g(paramcbo, "hellSession.sessions");
      Object localObject1 = (Iterable)paramcbo;
      paramcbo = (Collection)new ArrayList();
      localObject1 = ((Iterable)localObject1).iterator();
      Object localObject2;
      Object localObject3;
      label159:
      while (((Iterator)localObject1).hasNext())
      {
        localObject2 = ((Iterator)localObject1).next();
        localObject3 = (cyl)localObject2;
        String str = ((cyl)localObject3).sessionId;
        p.g(str, "it.sessionId");
        if ((p.j(a.aqn(str), "999")) && ((((cyl)localObject3).MDo == 0) || (((cyl)localObject3).MDo == 1) || (((cyl)localObject3).MDo == 2) || (((cyl)localObject3).MDo == 4) || (((cyl)localObject3).MDo == 5))) {}
        for (int i = 1;; i = 0)
        {
          if (i == 0) {
            break label159;
          }
          paramcbo.add(localObject2);
          break;
        }
      }
      localObject1 = j.p((Iterable)paramcbo);
      if (localObject1 == null)
      {
        AppMethodBeat.o(122606);
        return;
      }
      Log.i("HABBYGE-MALI.HellKSessionConfig", "after, sessionList.size: " + ((List)localObject1).size());
      paramcbo = null;
      localObject1 = ((List)localObject1).iterator();
      while (((Iterator)localObject1).hasNext())
      {
        localObject2 = (cyl)((Iterator)localObject1).next();
        localObject3 = a.aqp(((cyl)localObject2).sessionId);
        if (localObject3 != null) {
          paramcbo = "_" + ((com.tencent.mm.vending.j.c)localObject3).get(1);
        }
        Log.i("HABBYGE-MALI.HellKSessionConfig", "handleChatting, session, Start: " + ((cyl)localObject2).sessionId + ", " + paramcbo);
        ((cyl)localObject2).sessionId = a.Hl(((cyl)localObject2).MDo);
        if ((p.j(((cyl)localObject2).sessionId, "-1") ^ true))
        {
          localObject3 = ((cyl)localObject2).sessionId;
          ((cyl)localObject2).sessionId = ((String)localObject3 + paramcbo);
        }
        Log.i("HABBYGE-MALI.HellKSessionConfig", "handleChatting, session, End: " + ((cyl)localObject2).sessionId);
      }
    }
    AppMethodBeat.o(122606);
  }
  
  public static final boolean aqA(String paramString)
  {
    AppMethodBeat.i(185600);
    if (paramString == null)
    {
      AppMethodBeat.o(185600);
      return false;
    }
    if (n.a((CharSequence)paramString, (CharSequence)"_", false))
    {
      bool = a.aqB((String)n.a((CharSequence)paramString, new String[] { "_" }).get(0));
      AppMethodBeat.o(185600);
      return bool;
    }
    boolean bool = a.aqB(paramString);
    AppMethodBeat.o(185600);
    return bool;
  }
  
  public static final String aqn(String paramString)
  {
    AppMethodBeat.i(122604);
    paramString = a.aqn(paramString);
    AppMethodBeat.o(122604);
    return paramString;
  }
  
  public static final String aqo(String paramString)
  {
    AppMethodBeat.i(122605);
    p.h(paramString, "pageId");
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
  
  public static final com.tencent.mm.vending.j.c<String, String> aqp(String paramString)
  {
    AppMethodBeat.i(177417);
    paramString = a.aqp(paramString);
    AppMethodBeat.o(177417);
    return paramString;
  }
  
  public static final void aqq(String paramString)
  {
    AppMethodBeat.i(177418);
    if (paramString == null)
    {
      AppMethodBeat.o(177418);
      return;
    }
    cyl localcyl = com.tencent.mm.plugin.expt.hellhound.a.f.c.c.cQo();
    if (localcyl == null)
    {
      AppMethodBeat.o(177418);
      return;
    }
    com.tencent.mm.vending.j.c localc = a.aqp(localcyl.sessionId);
    if (localc == null)
    {
      AppMethodBeat.o(177418);
      return;
    }
    if (!a.aqt(localcyl.sessionId))
    {
      Log.i("HABBYGE-MALI.HellKSessionConfig", "HellK, updateCurSid, old: " + localcyl.sessionId);
      paramString = paramString + "_" + localc.get(1);
      localcyl.sessionId = paramString;
      com.tencent.mm.plugin.expt.hellhound.a.f.c.c.m(localcyl);
      Log.i("HABBYGE-MALI.HellKSessionConfig", "HellK, updateCurSid, new: ".concat(String.valueOf(paramString)));
    }
    AppMethodBeat.o(177418);
  }
  
  public static final boolean aqr(String paramString)
  {
    AppMethodBeat.i(122610);
    boolean bool = a.aqr(paramString);
    AppMethodBeat.o(122610);
    return bool;
  }
  
  public static final boolean aqs(String paramString)
  {
    AppMethodBeat.i(122611);
    if (paramString == null)
    {
      AppMethodBeat.o(122611);
      return false;
    }
    boolean bool = p.j("105", a.aqn(paramString));
    AppMethodBeat.o(122611);
    return bool;
  }
  
  public static final boolean aqt(String paramString)
  {
    AppMethodBeat.i(122612);
    boolean bool = a.aqt(paramString);
    AppMethodBeat.o(122612);
    return bool;
  }
  
  public static final boolean aqu(String paramString)
  {
    AppMethodBeat.i(122614);
    if (paramString == null)
    {
      AppMethodBeat.o(122614);
      return false;
    }
    paramString = a.aqn(paramString);
    if ((p.j("999", paramString)) || (a.aqr(paramString)))
    {
      AppMethodBeat.o(122614);
      return true;
    }
    AppMethodBeat.o(122614);
    return false;
  }
  
  public static final boolean aqv(String paramString)
  {
    AppMethodBeat.i(122615);
    p.h(paramString, "sid");
    boolean bool = p.j("131", paramString);
    AppMethodBeat.o(122615);
    return bool;
  }
  
  public static final List<dvk> aqw(String paramString)
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
    p.g(d.cQe(), "HellSessionPageCloudConfig.getInstance()");
    Object localObject = d.cQf();
    if (localObject == null)
    {
      AppMethodBeat.o(122616);
      return null;
    }
    ArrayList localArrayList = new ArrayList();
    Iterator localIterator = ((dvh)localObject).MWn.iterator();
    while (localIterator.hasNext())
    {
      dvk localdvk = (dvk)localIterator.next();
      if ((localdvk != null) && (localdvk.type == 0) && ((!(p.j(localdvk.sGF, paramString) ^ true)) || (!(p.j(localdvk.sGF, "-1") ^ true))))
      {
        localObject = localdvk;
        if (!localdvk.vtY) {
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
  
  public static final Long aqx(String paramString)
  {
    AppMethodBeat.i(122618);
    paramString = a.aqx(paramString);
    AppMethodBeat.o(122618);
    return paramString;
  }
  
  public static final String aqy(String paramString)
  {
    AppMethodBeat.i(185599);
    paramString = a.aqy(paramString);
    AppMethodBeat.o(185599);
    return paramString;
  }
  
  public static final String aqz(String paramString)
  {
    AppMethodBeat.i(221123);
    if (paramString == null)
    {
      AppMethodBeat.o(221123);
      return null;
    }
    if (n.a((CharSequence)paramString, (CharSequence)"_", false))
    {
      paramString = n.a((CharSequence)paramString, new String[] { "_" });
      paramString = a.aqy((String)paramString.get(0)) + "_" + (String)paramString.get(1);
      AppMethodBeat.o(221123);
      return paramString;
    }
    AppMethodBeat.o(221123);
    return paramString;
  }
  
  public static final String cPQ()
  {
    AppMethodBeat.i(122621);
    String str = a.cPQ();
    AppMethodBeat.o(122621);
    return str;
  }
  
  public static final boolean cPX()
  {
    AppMethodBeat.i(122619);
    boolean bool = a.cPX();
    AppMethodBeat.o(122619);
    return bool;
  }
  
  public static final boolean cPY()
  {
    AppMethodBeat.i(122620);
    String str = a.cPQ();
    if (!TextUtils.isEmpty((CharSequence)str))
    {
      if (str != null)
      {
        str = a.aqn(str);
        if ((!p.j("104", str)) && (!p.j("998", str))) {}
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
  
  public static final int fM(int paramInt1, int paramInt2)
  {
    if (paramInt1 >= paramInt2) {
      return paramInt1 + 1;
    }
    return paramInt2 + 1;
  }
  
  public static final String gv(String paramString1, String paramString2)
  {
    AppMethodBeat.i(177416);
    paramString1 = a.a(paramString1, paramString2, null);
    AppMethodBeat.o(177416);
    return paramString1;
  }
  
  public static final void i(cyl paramcyl)
  {
    AppMethodBeat.i(122607);
    if (paramcyl != null)
    {
      com.tencent.mm.vending.j.c localc = a.aqp(paramcyl.sessionId);
      if (localc == null)
      {
        AppMethodBeat.o(122607);
        return;
      }
      if (!(p.j("999", localc.get(0)) ^ true))
      {
        String str = a.Hl(paramcyl.MDo);
        paramcyl.sessionId = (str + "_" + localc.get(1));
      }
    }
    AppMethodBeat.o(122607);
  }
  
  public static final String j(cyl paramcyl)
  {
    AppMethodBeat.i(122608);
    if (paramcyl == null)
    {
      AppMethodBeat.o(122608);
      return null;
    }
    Object localObject1 = a.aqp(paramcyl.sessionId);
    if (localObject1 == null)
    {
      paramcyl = paramcyl.sessionId;
      AppMethodBeat.o(122608);
      return paramcyl;
    }
    if ((p.j("999", ((com.tencent.mm.vending.j.c)localObject1).get(0)) ^ true))
    {
      localObject2 = ((com.tencent.mm.vending.j.c)localObject1).get(0);
      if (!(localObject2 instanceof Integer)) {}
      while (-1 != ((Integer)localObject2).intValue())
      {
        paramcyl = paramcyl.sessionId;
        AppMethodBeat.o(122608);
        return paramcyl;
      }
    }
    Object localObject2 = a.Hl(paramcyl.MDo);
    localObject1 = (String)localObject2 + "_" + ((com.tencent.mm.vending.j.c)localObject1).get(1);
    paramcyl.sessionId = ((String)localObject1);
    AppMethodBeat.o(122608);
    return localObject1;
  }
  
  public static final String k(cyl paramcyl)
  {
    AppMethodBeat.i(122609);
    if (paramcyl == null)
    {
      AppMethodBeat.o(122609);
      return null;
    }
    com.tencent.mm.vending.j.c localc = a.aqp(paramcyl.sessionId);
    if (localc == null)
    {
      paramcyl = paramcyl.sessionId;
      AppMethodBeat.o(122609);
      return paramcyl;
    }
    if ((p.j("999", localc.get(0)) ^ true))
    {
      paramcyl = paramcyl.sessionId;
      p.g(paramcyl, "pageSession.sessionId");
      paramcyl = a.aqn(paramcyl);
      AppMethodBeat.o(122609);
      return paramcyl;
    }
    Log.i("HABBYGE-MALI.HellKSessionConfig", "getRealChatSessionId: " + paramcyl.MDo);
    paramcyl = a.Hl(paramcyl.MDo);
    AppMethodBeat.o(122609);
    return paramcyl;
  }
  
  public static final String s(long paramLong, int paramInt)
  {
    AppMethodBeat.i(122617);
    String str = String.valueOf(paramLong) + "_" + paramInt;
    AppMethodBeat.o(122617);
    return str;
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/expt/hellhound/ext/session/config/HellKSessionConfig$Companion;", "", "()V", "CHATTING_UI", "", "CHATTING_UI_FRAGMENT", "ILLEGAL_CONFIG_ID", "SESSION_ID_ADDRESS_ADD_FRIEND", "SESSION_ID_ADDRESS_SEARCH", "SESSION_ID_ADD_FRIEND", "SESSION_ID_APPBRAND", "SESSION_ID_AppBrandLauncherUI", "SESSION_ID_BIZ_LIST", "SESSION_ID_BIZ_MESSAGE", "SESSION_ID_BaseScanUI", "SESSION_ID_BottleBeachUI", "SESSION_ID_CHAT", "SESSION_ID_CHAT_PLUGIN_WECHAT_MOVEMENT", "SESSION_ID_CHAT_ROOM", "SESSION_ID_CHAT_SERVICE", "SESSION_ID_CHAT_SERVICE_NOTIFY", "SESSION_ID_CHAT_VIRTUAL", "SESSION_ID_CONTACT_BIZ", "SESSION_ID_CardHomePageUI", "SESSION_ID_ChatroomContactUI", "SESSION_ID_ContactInfoUI", "SESSION_ID_ContactLabelManagerUI", "SESSION_ID_ENTERPRISE", "SESSION_ID_EmojiStoreV2UI", "SESSION_ID_FINDER", "SESSION_ID_FIND_SEARCH", "SESSION_ID_FMessageConversationUI", "SESSION_ID_FTSSOSHomeWebViewUI", "SESSION_ID_FavoriteIndexUI", "SESSION_ID_FloatingWindow", "SESSION_ID_GAME", "SESSION_ID_GLOBAL_SEARCH", "SESSION_ID_HELP", "SESSION_ID_MINI_GAME", "SESSION_ID_MallIndexUI", "SESSION_ID_NEW_NEARBY", "SESSION_ID_NearbyFriendsUI", "SESSION_ID_Nearby_Rest", "SESSION_ID_ONLY_CAHT_FRIENDS", "SESSION_ID_OpenIMAddressUI", "SESSION_ID_SEARCH_BaseScanUI", "SESSION_ID_SELECT_CONTACTUI", "SESSION_ID_SettingsPersonalInfoUI", "SESSION_ID_SettingsUI", "SESSION_ID_ShakeReportUI", "SESSION_ID_SnsTimeLineUI", "SESSION_ID_SnsUserUI", "SESSION_ID_StoryCaptureUI", "SESSION_ID_StoryGalleryView", "SESSION_ID_TENCENT_NEWS", "SESSION_ID_TopStoryHomeUI", "SESSION_ID_VOIP_FloatingWindow", "SESSION_ID_WalletOfflineEntranceUI", "SESSION_ID_WebViewUI_jd_store", "TAB_AddressUIFragment", "TAB_FindMoreFriendsUI", "TAB_MainUI", "TAB_MoreTabUI", "TAG", "mSessionIdEntryListLocal", "", "Lcom/tencent/mm/plugin/expt/hellhound/ext/session/dao/SessionKEntry;", "convertChatSid", "", "hellSession", "Lcom/tencent/mm/protocal/protobuf/HellSession;", "pageSession", "Lcom/tencent/mm/protocal/protobuf/PageSession;", "cutInvalidatePageKeyToName", "pageId", "cutSessonToSid", "session", "doNotNeedSessionMonitor", "", "generateSeq", "", "seqOfPage", "seqOfUBA", "getBizIdOfSessionParam", "timestamp", "", "seq", "getCurSession", "getCurSid", "getIdentifySidExpect", "curActivity", "Landroid/app/Activity;", "srcPage", "dstPage", "getLastSession", "getPageStartTimeOfBizId", "bizId", "(Ljava/lang/String;)Ljava/lang/Long;", "getRealChatSid", "chattingType", "getRealChatSidLocal", "getSessionPageOfConfig", "Lcom/tencent/mm/protocal/protobuf/SessionPagePath;", "sid", "isDetailReport", "getSidId", "args", "getSidLocal", "getTabIdOfLauncher", "tabPageName", "getTabSessionIdOfLauncher", "sessionId", "isAppBrandSession", "isBizSid", "isChatSessionId", "isChatSid", "isCurBizSid", "isEffectiveSession", "sessoinId", "isEffectiveSessionBySid", "isFloatSession", "isJdSid", "isVoipSession", "spliteSession", "Lcom/tencent/mm/vending/tuple/Tuple2;", "updateCurSid", "updateRealChatSessionId", "plugin-expt_release"})
  public static final class a
  {
    static String Hl(int paramInt)
    {
      AppMethodBeat.i(122595);
      p.g(c.cQa(), "HellSessionCloudConfig.getInstance()");
      Object localObject = c.cQb();
      if (localObject == null)
      {
        localObject = Hm(paramInt);
        AppMethodBeat.o(122595);
        return localObject;
      }
      if (((duz)localObject).gyp)
      {
        Log.e("HABBYGE-MALI.HellKSessionConfig", "getRealChatSid, configCloud.isDel");
        AppMethodBeat.o(122595);
        return "-1";
      }
      localObject = ((duz)localObject).MWe.iterator();
      while (((Iterator)localObject).hasNext())
      {
        duy localduy = (duy)((Iterator)localObject).next();
        if (localduy != null)
        {
          Log.i("HABBYGE-MALI.HellKSessionConfig", "getRealChatSid, chatConfig.expect=" + localduy.MWc);
          if (Util.getInt(localduy.MWc, -1) == paramInt)
          {
            localObject = localduy.sGF;
            p.g(localObject, "chatConfig.sid");
            AppMethodBeat.o(122595);
            return localObject;
          }
        }
      }
      localObject = Hm(paramInt);
      AppMethodBeat.o(122595);
      return localObject;
    }
    
    private static String Hm(int paramInt)
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
    
    static String a(Activity paramActivity, String paramString1, String paramString2)
    {
      AppMethodBeat.i(122591);
      p.g(c.cQa(), "HellSessionCloudConfig.getInstance()");
      Object localObject1 = c.cQb();
      if (localObject1 == null)
      {
        AppMethodBeat.o(122591);
        return null;
      }
      dvd localdvd;
      do
      {
        String str;
        do
        {
          localObject1 = ((duz)localObject1).MWg.iterator();
          Object localObject2;
          while (!((Iterator)localObject2).hasNext())
          {
            do
            {
              if (!((Iterator)localObject1).hasNext()) {
                break;
              }
              localdvd = (dvd)((Iterator)localObject1).next();
            } while ((localdvd == null) || (localdvd.MWj.isEmpty()) || ((p.j(localdvd.MWb, paramString1) ^ true)));
            localObject2 = localdvd.dMl;
            p.g(localObject2, "config.pageName");
            localObject2 = n.a((CharSequence)localObject2, new String[] { "," }).iterator();
          }
          str = (String)((Iterator)localObject2).next();
          if (str == null)
          {
            paramActivity = new t("null cannot be cast to non-null type kotlin.CharSequence");
            AppMethodBeat.o(122591);
            throw paramActivity;
          }
        } while (!p.j(n.trim((CharSequence)str).toString(), paramString2));
        Log.i("HABBYGE-MALI.HellKSessionConfig", "getIdentifySidExpect, sid: " + localdvd.sGF);
      } while (!a.a(paramActivity, localdvd));
      paramActivity = localdvd.sGF;
      AppMethodBeat.o(122591);
      return paramActivity;
      AppMethodBeat.o(122591);
      return null;
    }
    
    public static String a(String paramString1, String paramString2, List<String> paramList)
    {
      AppMethodBeat.i(122592);
      paramString1 = com.tencent.mm.plugin.expt.hellhound.core.b.aoE(paramString1);
      String str1 = com.tencent.mm.plugin.expt.hellhound.core.b.aoE(paramString2);
      Log.i("HABBYGE-MALI.HellKSessionConfig", "getSessionIdLocal: " + paramString1 + ", " + str1);
      if (((p.j("ChattingUI", paramString2)) || (p.j("ChattingUIFragment", paramString2))) && ((p.j(com.tencent.mm.plugin.expt.hellhound.core.b.szb, paramString1)) || (TextUtils.isEmpty((CharSequence)paramString1))))
      {
        Log.i("HABBYGE-MALI.HellKSessionConfig", "getSidId: 999");
        AppMethodBeat.o(122592);
        return "999";
      }
      if ((p.j("WebViewUI", str1)) && ((p.j("FindMoreFriendsUI", paramString1)) || (p.j("MainUI", paramString1)) || (p.j("AddressUIFragment", paramString1))))
      {
        paramString2 = com.tencent.mm.plugin.expt.hellhound.a.h.a.sJC;
        if (com.tencent.mm.plugin.expt.hellhound.a.h.a.cQY())
        {
          AppMethodBeat.o(122592);
          return "148";
        }
      }
      if (p.j("BaseScanUI", str1))
      {
        paramString2 = com.tencent.mm.plugin.expt.hellhound.a.f.g.b.a.sJe;
        if (com.tencent.mm.plugin.expt.hellhound.a.f.g.b.a.cQQ())
        {
          AppMethodBeat.o(122592);
          return "124";
        }
        paramString2 = com.tencent.mm.plugin.expt.hellhound.a.h.a.sJC;
        if (com.tencent.mm.plugin.expt.hellhound.a.h.a.cQX())
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
          paramString2 = b.cPW().iterator();
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
            } while (!p.j(paramString1, paramList.sII));
            localObject = paramList.sIJ.iterator();
          }
        } while (!p.j(str1, (String)((Iterator)localObject).next()));
        if (p.j(paramList.sessionId, "109"))
        {
          paramString1 = com.tencent.mm.plugin.expt.hellhound.a.h.a.sJC;
          if (com.tencent.mm.plugin.expt.hellhound.a.h.a.cQX())
          {
            AppMethodBeat.o(122592);
            return "109";
          }
          AppMethodBeat.o(122592);
          return "124";
        }
        if ((p.j(paramList.sessionId, "105")) || (p.j(paramList.sessionId, "131")))
        {
          paramString1 = com.tencent.mm.plugin.expt.hellhound.a.f.g.b.a.sJe;
          if (com.tencent.mm.plugin.expt.hellhound.a.f.g.b.a.cQP())
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
      paramString2 = b.cPW().iterator();
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
        if ((p.j(paramString1, ((i)localObject).sII) ^ true)) {
          break label653;
        }
        Iterator localIterator = ((i)localObject).sIJ.iterator();
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
              if (p.j(str2, (String)paramList.get(i))) {
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
          if ((p.j(str1, str2) ^ true)) {
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
    
    static boolean aqB(String paramString)
    {
      AppMethodBeat.i(185598);
      if ((p.j(paramString, "0")) || (p.j(paramString, "1")) || (p.j(paramString, "2")) || (p.j(paramString, "3")))
      {
        AppMethodBeat.o(185598);
        return false;
      }
      boolean bool = com.tencent.mm.plugin.expt.hellhound.core.b.isNumeric(paramString);
      AppMethodBeat.o(185598);
      return bool;
    }
    
    public static String aqn(String paramString)
    {
      AppMethodBeat.i(122593);
      p.h(paramString, "session");
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
      p.g(paramString, "(this as java.lang.Strin…ing(startIndex, endIndex)");
      AppMethodBeat.o(122593);
      return paramString;
    }
    
    public static com.tencent.mm.vending.j.c<String, String> aqp(String paramString)
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
      paramString = com.tencent.mm.vending.j.a.Q(paramString.get(0), paramString.get(1));
      AppMethodBeat.o(122594);
      return paramString;
    }
    
    public static boolean aqr(String paramString)
    {
      AppMethodBeat.i(122597);
      if ((p.j("101", paramString)) || (p.j("102", paramString)) || (p.j("103", paramString)) || (p.j("111", paramString)) || (p.j("112", paramString)))
      {
        AppMethodBeat.o(122597);
        return true;
      }
      AppMethodBeat.o(122597);
      return false;
    }
    
    public static boolean aqt(String paramString)
    {
      AppMethodBeat.i(221121);
      if (paramString == null)
      {
        AppMethodBeat.o(221121);
        return false;
      }
      boolean bool = p.j("145", aqn(paramString));
      AppMethodBeat.o(221121);
      return bool;
    }
    
    public static Long aqx(String paramString)
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
    
    public static String aqy(String paramString)
    {
      AppMethodBeat.i(221122);
      if (paramString == null)
      {
        AppMethodBeat.o(221122);
        return null;
      }
      if (n.a((CharSequence)paramString, (CharSequence)".", false))
      {
        if (p.j(paramString, com.tencent.mm.plugin.expt.hellhound.core.b.syW))
        {
          AppMethodBeat.o(221122);
          return "0";
        }
        if (p.j(paramString, com.tencent.mm.plugin.expt.hellhound.core.b.syX))
        {
          AppMethodBeat.o(221122);
          return "1";
        }
        if (p.j(paramString, com.tencent.mm.plugin.expt.hellhound.core.b.syY))
        {
          AppMethodBeat.o(221122);
          return "2";
        }
        if (p.j(paramString, com.tencent.mm.plugin.expt.hellhound.core.b.syZ))
        {
          AppMethodBeat.o(221122);
          return "3";
        }
        AppMethodBeat.o(221122);
        return paramString;
      }
      if (p.j(paramString, com.tencent.mm.plugin.expt.hellhound.core.b.szb))
      {
        AppMethodBeat.o(221122);
        return "0";
      }
      if (p.j(paramString, com.tencent.mm.plugin.expt.hellhound.core.b.szc))
      {
        AppMethodBeat.o(221122);
        return "1";
      }
      if (p.j(paramString, com.tencent.mm.plugin.expt.hellhound.core.b.szd))
      {
        AppMethodBeat.o(221122);
        return "2";
      }
      if (p.j(paramString, com.tencent.mm.plugin.expt.hellhound.core.b.sze))
      {
        AppMethodBeat.o(221122);
        return "3";
      }
      AppMethodBeat.o(221122);
      return paramString;
    }
    
    public static String cPQ()
    {
      AppMethodBeat.i(122601);
      String str = cPZ();
      if (str == null)
      {
        AppMethodBeat.o(122601);
        return null;
      }
      str = aqn(str);
      AppMethodBeat.o(122601);
      return str;
    }
    
    public static boolean cPX()
    {
      AppMethodBeat.i(122599);
      if (!com.tencent.mm.plugin.expt.hellhound.a.cNo())
      {
        Log.i("HABBYGE-MALI.HellKSessionConfig", "HellSessionMonitor monitor, fetchHellhoundConfig: FALSE");
        AppMethodBeat.o(122599);
        return true;
      }
      p.g(c.cQa(), "HellSessionCloudConfig.getInstance()");
      if ((c.cQc()) || (com.tencent.mm.plugin.expt.hellhound.core.b.getUin() == 0))
      {
        Log.i("HABBYGE-MALI.HellKSessionConfig", "HellSessionMonitor monitor FALSE");
        AppMethodBeat.o(122599);
        return true;
      }
      if (!com.tencent.mm.plugin.expt.hellhound.a.cNq())
      {
        Log.i("HABBYGE-MALI.HellKSessionConfig", "HellSessionMonitor monitor, close !!!");
        AppMethodBeat.o(122599);
        return true;
      }
      AppMethodBeat.o(122599);
      return false;
    }
    
    public static String cPZ()
    {
      AppMethodBeat.i(122600);
      Object localObject = com.tencent.mm.plugin.expt.hellhound.a.f.c.c.cQo();
      if (localObject == null)
      {
        AppMethodBeat.o(122600);
        return null;
      }
      localObject = ((cyl)localObject).sessionId;
      AppMethodBeat.o(122600);
      return localObject;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.expt.hellhound.a.f.b.b
 * JD-Core Version:    0.7.0.1
 */