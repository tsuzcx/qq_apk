package com.tencent.mm.plugin.expt.hellhound.a.f.b;

import android.app.Activity;
import android.text.TextUtils;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.expt.hellhound.a.f.c.i;
import com.tencent.mm.protocal.protobuf.bow;
import com.tencent.mm.protocal.protobuf.cie;
import com.tencent.mm.protocal.protobuf.dbu;
import com.tencent.mm.protocal.protobuf.dbv;
import com.tencent.mm.protocal.protobuf.dbw;
import com.tencent.mm.protocal.protobuf.dbx;
import com.tencent.mm.protocal.protobuf.dbz;
import com.tencent.mm.protocal.protobuf.dcd;
import com.tencent.mm.protocal.protobuf.dcg;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.bu;
import d.a.j;
import d.g.b.p;
import d.l;
import d.n.n;
import d.v;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

@l(gjZ={1, 1, 16}, gka={""}, gkb={"Lcom/tencent/mm/plugin/expt/hellhound/ext/session/config/HellKSessionConfig;", "", "()V", "Companion", "plugin-expt_release"})
public final class b
{
  private static final List<i> rhb;
  public static final a rhc;
  
  static
  {
    AppMethodBeat.i(122602);
    rhc = new a((byte)0);
    rhb = j.listOf(new i[] { new i("999", com.tencent.mm.plugin.expt.hellhound.core.b.qYK, (List)j.ab(new String[] { "ChattingUIFragment", "ChattingUI" })), new i("998", com.tencent.mm.plugin.expt.hellhound.core.b.qYK, (List)j.ab(new String[] { "BizConversationUI" })), new i("104", com.tencent.mm.plugin.expt.hellhound.core.b.qYK, (List)j.ab(new String[] { "BizTimeLineUI" })), new i("105", com.tencent.mm.plugin.expt.hellhound.core.b.qYK, (List)j.ab(new String[] { "AppBrandLaunchProxyUI", "AppBrandUI", "AppBrandUI1", "AppBrandUI2", "AppBrandUI3", "AppBrandUI4" })), new i("105", com.tencent.mm.plugin.expt.hellhound.core.b.qYK, (List)j.ab(new String[] { "AppBrandUI", "AppBrandUI1", "AppBrandUI2", "AppBrandUI3", "AppBrandUI4" })), new i("105", "LauncherUI", (List)j.ab(new String[] { "AppBrandLaunchProxyUI", "AppBrandUI", "AppBrandUI1", "AppBrandUI2", "AppBrandUI3", "AppBrandUI4" })), new i("105", "LauncherUI", (List)j.ab(new String[] { "AppBrandUI", "AppBrandUI1", "AppBrandUI2", "AppBrandUI3", "AppBrandUI4" })), new i("105", com.tencent.mm.plugin.expt.hellhound.core.b.qYK, (List)j.ab(new String[] { "AppBrandLauncherUI" })), new i("105", "LauncherUI", (List)j.ab(new String[] { "AppBrandLauncherUI" })), new i("105", "WXShortcutEntryActivity", (List)j.ab(new String[] { "AppBrandLaunchProxyUI", "AppBrandUI", "AppBrandUI1", "AppBrandUI2", "AppBrandUI3", "AppBrandUI4" })), new i("105", com.tencent.mm.plugin.expt.hellhound.core.b.qYL, (List)j.ab(new String[] { "AppBrandLaunchProxyUI", "AppBrandUI", "AppBrandUI1", "AppBrandUI2", "AppBrandUI3", "AppBrandUI4" })), new i("105", com.tencent.mm.plugin.expt.hellhound.core.b.qYM, (List)j.ab(new String[] { "AppBrandLaunchProxyUI", "AppBrandUI", "AppBrandUI1", "AppBrandUI2", "AppBrandUI3", "AppBrandUI4" })), new i("105", com.tencent.mm.plugin.expt.hellhound.core.b.qYN, (List)j.ab(new String[] { "AppBrandLaunchProxyUI", "AppBrandUI", "AppBrandUI1", "AppBrandUI2", "AppBrandUI3", "AppBrandUI4" })), new i("113", com.tencent.mm.plugin.expt.hellhound.core.b.qYK, (List)j.ab(new String[] { "ReaderAppUI" })), new i("114", com.tencent.mm.plugin.expt.hellhound.core.b.qYL, (List)j.ab(new String[] { "FTSMainUI" })), new i("147", com.tencent.mm.plugin.expt.hellhound.core.b.qYM, (List)j.ab(new String[] { "FTSMainUI" })), new i("115", com.tencent.mm.plugin.expt.hellhound.core.b.qYL, (List)j.ab(new String[] { "AddMoreFriendsUI" })), new i("116", com.tencent.mm.plugin.expt.hellhound.core.b.qYL, (List)j.ab(new String[] { "FMessageConversationUI" })), new i("117", com.tencent.mm.plugin.expt.hellhound.core.b.qYL, (List)j.ab(new String[] { "ChatroomContactUI" })), new i("118", com.tencent.mm.plugin.expt.hellhound.core.b.qYL, (List)j.ab(new String[] { "ContactLabelManagerUI" })), new i("106", com.tencent.mm.plugin.expt.hellhound.core.b.qYK, (List)j.ab(new String[] { "FTSMainUI" })), new i("107", com.tencent.mm.plugin.expt.hellhound.core.b.qYK, (List)j.ab(new String[] { "SelectContactUI" })), new i("107", com.tencent.mm.plugin.expt.hellhound.core.b.qYL, (List)j.ab(new String[] { "SelectContactUI" })), new i("107", com.tencent.mm.plugin.expt.hellhound.core.b.qYM, (List)j.ab(new String[] { "SelectContactUI" })), new i("108", com.tencent.mm.plugin.expt.hellhound.core.b.qYK, (List)j.ab(new String[] { "AddMoreFriendsUI" })), new i("108", com.tencent.mm.plugin.expt.hellhound.core.b.qYL, (List)j.ab(new String[] { "AddMoreFriendsUI" })), new i("108", com.tencent.mm.plugin.expt.hellhound.core.b.qYM, (List)j.ab(new String[] { "AddMoreFriendsUI" })), new i("109", com.tencent.mm.plugin.expt.hellhound.core.b.qYK, (List)j.ab(new String[] { "BaseScanUI" })), new i("109", com.tencent.mm.plugin.expt.hellhound.core.b.qYL, (List)j.ab(new String[] { "BaseScanUI" })), new i("109", com.tencent.mm.plugin.expt.hellhound.core.b.qYM, (List)j.ab(new String[] { "BaseScanUI" })), new i("110", com.tencent.mm.plugin.expt.hellhound.core.b.qYK, (List)j.ab(new String[] { "WalletOfflineEntranceUI" })), new i("110", com.tencent.mm.plugin.expt.hellhound.core.b.qYL, (List)j.ab(new String[] { "WalletOfflineEntranceUI" })), new i("110", com.tencent.mm.plugin.expt.hellhound.core.b.qYM, (List)j.ab(new String[] { "WalletOfflineEntranceUI" })), new i("119", com.tencent.mm.plugin.expt.hellhound.core.b.qYL, (List)j.ab(new String[] { "BrandServiceIndexUI" })), new i("120", com.tencent.mm.plugin.expt.hellhound.core.b.qYL, (List)j.ab(new String[] { "EnterpriseBizContactListUI" })), new i("121", "AddressUIFragment", (List)j.ab(new String[] { "OpenIMAddressUI" })), new i("122", "AddressUIFragment", (List)j.ab(new String[] { "ContactInfoUI" })), new i("123", com.tencent.mm.plugin.expt.hellhound.core.b.qYM, (List)j.ab(new String[] { "SnsTimeLineUI" })), new i("124", com.tencent.mm.plugin.expt.hellhound.core.b.qYM, (List)j.ab(new String[] { "BaseScanUI" })), new i("125", com.tencent.mm.plugin.expt.hellhound.core.b.qYM, (List)j.ab(new String[] { "ShakeReportUI" })), new i("126", com.tencent.mm.plugin.expt.hellhound.core.b.qYM, (List)j.ab(new String[] { "TopStoryHomeUI" })), new i("127", com.tencent.mm.plugin.expt.hellhound.core.b.qYM, (List)j.ab(new String[] { "FTSSOSHomeWebViewUI" })), new i("128", com.tencent.mm.plugin.expt.hellhound.core.b.qYM, (List)j.ab(new String[] { "NearbyFriendsIntroUI", "NearbyFriendsUI", "NearbyPersonalInfoUI", "NearbyFriendShowSayHiUI" })), new i("129", com.tencent.mm.plugin.expt.hellhound.core.b.qYM, (List)j.ab(new String[] { "BottleBeachUI" })), new i("130", com.tencent.mm.plugin.expt.hellhound.core.b.qYM, (List)j.ab(new String[] { "AppBrandPluginUI" })), new i("131", com.tencent.mm.plugin.expt.hellhound.core.b.qYM, (List)j.ab(new String[] { "WebViewUI", "1", "jd_store" })), new i("131", com.tencent.mm.plugin.expt.hellhound.core.b.qYM, (List)j.ab(new String[] { "AppBrandLaunchProxyUI", "AppBrandUI", "AppBrandUI1", "AppBrandUI2", "AppBrandUI3", "AppBrandUI4" })), new i("132", com.tencent.mm.plugin.expt.hellhound.core.b.qYM, (List)j.ab(new String[] { "GameWebViewUI" })), new i("132", com.tencent.mm.plugin.expt.hellhound.core.b.qYM, (List)j.ab(new String[] { "GameCenterUI" })), new i("132", com.tencent.mm.plugin.expt.hellhound.core.b.qYM, (List)j.ab(new String[] { "LuggageGameWebViewUI" })), new i("132", com.tencent.mm.plugin.expt.hellhound.core.b.qYM, (List)j.ab(new String[] { "GameWebViewMpUI" })), new i("132", com.tencent.mm.plugin.expt.hellhound.core.b.qYM, (List)j.ab(new String[] { "LuggageGameWebViewMpUI" })), new i("133", com.tencent.mm.plugin.expt.hellhound.core.b.qYM, (List)j.ab(new String[] { "AppBrandLauncherUI" })), new i("134", com.tencent.mm.plugin.expt.hellhound.core.b.qYN, (List)j.ab(new String[] { "SettingsPersonalInfoUI" })), new i("135", com.tencent.mm.plugin.expt.hellhound.core.b.qYN, (List)j.ab(new String[] { "MallIndexUI", "MallIndexUIv2" })), new i("136", com.tencent.mm.plugin.expt.hellhound.core.b.qYN, (List)j.ab(new String[] { "FavoriteIndexUI" })), new i("137", com.tencent.mm.plugin.expt.hellhound.core.b.qYN, (List)j.ab(new String[] { "SnsUserUI", "AlbumUI" })), new i("138", com.tencent.mm.plugin.expt.hellhound.core.b.qYN, (List)j.ab(new String[] { "CardHomePageNewUI", "CardHomePageUI", "CardIndexUI", "CardInvalidCardUI", "CardViewUI", "ShareCardListUI", "CardHomePageV3UI" })), new i("139", "MoreTabUI", (List)j.ab(new String[] { "EmojiStoreV2UI", "MMFlutterActivity" })), new i("140", "MoreTabUI", (List)j.ab(new String[] { "SettingsUI" })), new i("141", "MoreTabUI", (List)j.ab(new String[] { "StoryCaptureUI", "MMRecordUI" })), new i("142", "MoreTabUI", (List)j.ab(new String[] { "StoryGalleryView", "StoryVideoView" })), new i("143", "FindMoreFriendsUI", (List)j.ab(new String[] { "FinderTimelineUI" })), new i("143", "FindMoreFriendsUI", (List)j.ab(new String[] { "FinderHomeUI" })), new i("143", "FindMoreFriendsUI", (List)j.ab(new String[] { "FinderConversationUI" })), new i("143", "AddressUIFragment", (List)j.ab(new String[] { "FinderTimelineUI" })), new i("143", "FinderHomeUI", (List)j.ab(new String[] { "FinderSelfUI" })), new i("145", "LauncherUI", (List)j.ab(new String[] { "FloatingBall" })), new i("146", "LauncherUI", (List)j.ab(new String[] { "VideoActivity" })), new i("149", "AddressUIFragment", (List)j.ab(new String[] { "OnlyChatContactMgrUI" })) });
    AppMethodBeat.o(122602);
  }
  
  public static final String a(Activity paramActivity, String paramString1, String paramString2, List<String> paramList)
  {
    AppMethodBeat.i(122603);
    paramString1 = com.tencent.mm.plugin.expt.hellhound.core.b.aer(paramString1);
    ae.i("HABBYGE-MALI.HellKSessionConfig", "getSidId: " + paramString1 + ", " + paramString2);
    p.g(c.crs(), "HellSessionCloudConfig.getInstance()");
    Object localObject1 = c.crt();
    if (localObject1 == null)
    {
      paramActivity = a.a(paramString1, paramString2, paramList);
      AppMethodBeat.o(122603);
      return paramActivity;
    }
    if (((dbv)localObject1).fTh)
    {
      ae.e("HABBYGE-MALI.HellKSessionConfig", "getSidId, sessionCloud.isDel ture");
      AppMethodBeat.o(122603);
      return null;
    }
    if (((p.i("ChattingUI", paramString2)) || (p.i("ChattingUIFragment", paramString2))) && ((p.i(com.tencent.mm.plugin.expt.hellhound.core.b.qYK, paramString1)) || (TextUtils.isEmpty((CharSequence)paramString1))))
    {
      ae.i("HABBYGE-MALI.HellKSessionConfig", "getSidId: 999");
      AppMethodBeat.o(122603);
      return "999";
    }
    if (p.i("WebViewUI", paramString2)) {
      if (p.i("FindMoreFriendsUI", paramString1))
      {
        if (((dbv)localObject1).HKw != null)
        {
          if ((paramList != null) && (paramList.size() >= 2) && (p.i(((dbv)localObject1).HKw.HKy, (String)paramList.get(0))) && (p.i(((dbv)localObject1).HKw.HKz, (String)paramList.get(1))))
          {
            ae.i("HABBYGE-MALI.HellKSessionConfig", "getSidId, SESSION_ID_WebViewUI_jd_store");
            AppMethodBeat.o(122603);
            return "131";
          }
        }
        else
        {
          localObject2 = com.tencent.mm.plugin.expt.hellhound.a.h.a.rhY;
          if (com.tencent.mm.plugin.expt.hellhound.a.h.a.csp())
          {
            paramActivity = com.tencent.mm.plugin.expt.hellhound.a.h.a.rhY;
            com.tencent.mm.plugin.expt.hellhound.a.h.a.lh(false);
            AppMethodBeat.o(122603);
            return "148";
          }
        }
      }
      else if ((p.i("MainUI", paramString1)) || (p.i("AddressUIFragment", paramString1)))
      {
        localObject2 = com.tencent.mm.plugin.expt.hellhound.a.h.a.rhY;
        if (com.tencent.mm.plugin.expt.hellhound.a.h.a.csp())
        {
          paramActivity = com.tencent.mm.plugin.expt.hellhound.a.h.a.rhY;
          com.tencent.mm.plugin.expt.hellhound.a.h.a.lh(false);
          AppMethodBeat.o(122603);
          return "148";
        }
      }
    }
    if (p.i("BaseScanUI", paramString2))
    {
      localObject2 = com.tencent.mm.plugin.expt.hellhound.a.f.g.b.a.rhI;
      if (com.tencent.mm.plugin.expt.hellhound.a.f.g.b.a.csi())
      {
        paramActivity = com.tencent.mm.plugin.expt.hellhound.a.f.g.b.a.rhI;
        com.tencent.mm.plugin.expt.hellhound.a.f.g.b.a.le(false);
        AppMethodBeat.o(122603);
        return "124";
      }
      localObject2 = com.tencent.mm.plugin.expt.hellhound.a.h.a.rhY;
      if (com.tencent.mm.plugin.expt.hellhound.a.h.a.cso())
      {
        paramActivity = com.tencent.mm.plugin.expt.hellhound.a.h.a.rhY;
        com.tencent.mm.plugin.expt.hellhound.a.h.a.lg(false);
        AppMethodBeat.o(122603);
        return "109";
      }
    }
    Object localObject2 = com.tencent.mm.plugin.expt.hellhound.a.f.g.b.a.rhI;
    com.tencent.mm.plugin.expt.hellhound.a.f.g.b.a.csi();
    if ((paramList == null) || (paramList.isEmpty()))
    {
      localObject1 = ((dbv)localObject1).HKu.iterator();
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
            localObject2 = (dbx)((Iterator)localObject1).next();
          } while ((localObject2 == null) || (!p.i(((dbx)localObject2).HKs, paramString1)));
          localObject3 = ((dbx)localObject2).duQ;
          p.g(localObject3, "config.pageName");
          localObject3 = n.b((CharSequence)localObject3, new String[] { "," }).iterator();
        }
        str = (String)((Iterator)localObject3).next();
        if (str == null)
        {
          paramActivity = new v("null cannot be cast to non-null type kotlin.CharSequence");
          AppMethodBeat.o(122603);
          throw paramActivity;
        }
      } while (!p.i(n.trim((CharSequence)str).toString(), paramString2));
      if (p.i(((dbx)localObject2).rfp, "109"))
      {
        paramActivity = com.tencent.mm.plugin.expt.hellhound.a.h.a.rhY;
        if (com.tencent.mm.plugin.expt.hellhound.a.h.a.cso())
        {
          paramActivity = com.tencent.mm.plugin.expt.hellhound.a.h.a.rhY;
          com.tencent.mm.plugin.expt.hellhound.a.h.a.lg(false);
          AppMethodBeat.o(122603);
          return "109";
        }
        AppMethodBeat.o(122603);
        return "124";
      }
      if ((p.i(((dbx)localObject2).rfp, "105")) || (p.i(((dbx)localObject2).rfp, "131")))
      {
        paramActivity = com.tencent.mm.plugin.expt.hellhound.a.f.g.b.a.rhI;
        if (com.tencent.mm.plugin.expt.hellhound.a.f.g.b.a.csh())
        {
          paramActivity = com.tencent.mm.plugin.expt.hellhound.a.f.g.b.a.rhI;
          com.tencent.mm.plugin.expt.hellhound.a.f.g.b.a.ld(false);
          AppMethodBeat.o(122603);
          return "131";
        }
        AppMethodBeat.o(122603);
        return "105";
      }
      paramActivity = ((dbx)localObject2).rfp;
      AppMethodBeat.o(122603);
      return paramActivity;
      paramActivity = a.a(paramActivity, paramString1, paramString2);
      if (paramActivity != null)
      {
        AppMethodBeat.o(122603);
        return paramActivity;
      }
    }
    ae.i("HABBYGE-MALI.HellKSessionConfig", "get sid by cloud config, but NULL, dignose sid By local config !!!");
    paramActivity = a.a(paramString1, paramString2, paramList);
    AppMethodBeat.o(122603);
    return paramActivity;
  }
  
  public static final void a(bow parambow)
  {
    AppMethodBeat.i(122606);
    if (parambow != null)
    {
      parambow = parambow.Hco;
      p.g(parambow, "hellSession.sessions");
      Object localObject1 = (Iterable)parambow;
      parambow = (Collection)new ArrayList();
      localObject1 = ((Iterable)localObject1).iterator();
      Object localObject2;
      Object localObject3;
      label159:
      while (((Iterator)localObject1).hasNext())
      {
        localObject2 = ((Iterator)localObject1).next();
        localObject3 = (cie)localObject2;
        String str = ((cie)localObject3).sessionId;
        p.g(str, "it.sessionId");
        if ((p.i(a.afC(str), "999")) && ((((cie)localObject3).Huq == 0) || (((cie)localObject3).Huq == 1) || (((cie)localObject3).Huq == 2) || (((cie)localObject3).Huq == 4) || (((cie)localObject3).Huq == 5))) {}
        for (int i = 1;; i = 0)
        {
          if (i == 0) {
            break label159;
          }
          parambow.add(localObject2);
          break;
        }
      }
      localObject1 = j.l((Iterable)parambow);
      if (localObject1 == null)
      {
        AppMethodBeat.o(122606);
        return;
      }
      ae.i("HABBYGE-MALI.HellKSessionConfig", "after, sessionList.size: " + ((List)localObject1).size());
      parambow = null;
      localObject1 = ((List)localObject1).iterator();
      while (((Iterator)localObject1).hasNext())
      {
        localObject2 = (cie)((Iterator)localObject1).next();
        localObject3 = a.afE(((cie)localObject2).sessionId);
        if (localObject3 != null) {
          parambow = "_" + ((com.tencent.mm.vending.j.c)localObject3).get(1);
        }
        ae.i("HABBYGE-MALI.HellKSessionConfig", "handleChatting, session, Start: " + ((cie)localObject2).sessionId + ", " + parambow);
        ((cie)localObject2).sessionId = a.Dy(((cie)localObject2).Huq);
        if ((p.i(((cie)localObject2).sessionId, "-1") ^ true))
        {
          localObject3 = ((cie)localObject2).sessionId;
          ((cie)localObject2).sessionId = ((String)localObject3 + parambow);
        }
        ae.i("HABBYGE-MALI.HellKSessionConfig", "handleChatting, session, End: " + ((cie)localObject2).sessionId);
      }
    }
    AppMethodBeat.o(122606);
  }
  
  public static final String afC(String paramString)
  {
    AppMethodBeat.i(122604);
    paramString = a.afC(paramString);
    AppMethodBeat.o(122604);
    return paramString;
  }
  
  public static final String afD(String paramString)
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
  
  public static final com.tencent.mm.vending.j.c<String, String> afE(String paramString)
  {
    AppMethodBeat.i(177417);
    paramString = a.afE(paramString);
    AppMethodBeat.o(177417);
    return paramString;
  }
  
  public static final void afF(String paramString)
  {
    AppMethodBeat.i(177418);
    if (paramString == null)
    {
      AppMethodBeat.o(177418);
      return;
    }
    cie localcie = com.tencent.mm.plugin.expt.hellhound.a.f.c.c.crG();
    if (localcie == null)
    {
      AppMethodBeat.o(177418);
      return;
    }
    com.tencent.mm.vending.j.c localc = a.afE(localcie.sessionId);
    if (localc == null)
    {
      AppMethodBeat.o(177418);
      return;
    }
    if (!a.afI(localcie.sessionId))
    {
      ae.i("HABBYGE-MALI.HellKSessionConfig", "HellK, updateCurSid, old: " + localcie.sessionId);
      paramString = paramString + "_" + localc.get(1);
      localcie.sessionId = paramString;
      com.tencent.mm.plugin.expt.hellhound.a.f.c.c.m(localcie);
      ae.i("HABBYGE-MALI.HellKSessionConfig", "HellK, updateCurSid, new: ".concat(String.valueOf(paramString)));
    }
    AppMethodBeat.o(177418);
  }
  
  public static final boolean afG(String paramString)
  {
    AppMethodBeat.i(122610);
    boolean bool = a.afG(paramString);
    AppMethodBeat.o(122610);
    return bool;
  }
  
  public static final boolean afH(String paramString)
  {
    AppMethodBeat.i(122611);
    if (paramString == null)
    {
      AppMethodBeat.o(122611);
      return false;
    }
    boolean bool = p.i("105", a.afC(paramString));
    AppMethodBeat.o(122611);
    return bool;
  }
  
  public static final boolean afI(String paramString)
  {
    AppMethodBeat.i(122612);
    boolean bool = a.afI(paramString);
    AppMethodBeat.o(122612);
    return bool;
  }
  
  public static final boolean afJ(String paramString)
  {
    AppMethodBeat.i(122614);
    if (paramString == null)
    {
      AppMethodBeat.o(122614);
      return false;
    }
    paramString = a.afC(paramString);
    if ((p.i("999", paramString)) || (a.afG(paramString)))
    {
      AppMethodBeat.o(122614);
      return true;
    }
    AppMethodBeat.o(122614);
    return false;
  }
  
  public static final boolean afK(String paramString)
  {
    AppMethodBeat.i(122615);
    p.h(paramString, "sid");
    boolean bool = p.i("131", paramString);
    AppMethodBeat.o(122615);
    return bool;
  }
  
  public static final List<dcg> afL(String paramString)
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
    p.g(d.crw(), "HellSessionPageCloudConfig.getInstance()");
    Object localObject = d.crx();
    if (localObject == null)
    {
      AppMethodBeat.o(122616);
      return null;
    }
    ArrayList localArrayList = new ArrayList();
    Iterator localIterator = ((dcd)localObject).HKE.iterator();
    while (localIterator.hasNext())
    {
      dcg localdcg = (dcg)localIterator.next();
      if ((localdcg != null) && (localdcg.type == 0) && ((!(p.i(localdcg.rfp, paramString) ^ true)) || (!(p.i(localdcg.rfp, "-1") ^ true))))
      {
        localObject = localdcg;
        if (!localdcg.sDg) {
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
  
  public static final Long afM(String paramString)
  {
    AppMethodBeat.i(122618);
    paramString = a.afM(paramString);
    AppMethodBeat.o(122618);
    return paramString;
  }
  
  public static final String afN(String paramString)
  {
    AppMethodBeat.i(185599);
    paramString = a.afN(paramString);
    AppMethodBeat.o(185599);
    return paramString;
  }
  
  public static final String afO(String paramString)
  {
    AppMethodBeat.i(196631);
    if (paramString == null)
    {
      AppMethodBeat.o(196631);
      return null;
    }
    if (n.a((CharSequence)paramString, (CharSequence)"_", false))
    {
      paramString = n.a((CharSequence)paramString, new String[] { "_" });
      paramString = a.afN((String)paramString.get(0)) + "_" + (String)paramString.get(1);
      AppMethodBeat.o(196631);
      return paramString;
    }
    AppMethodBeat.o(196631);
    return paramString;
  }
  
  public static final boolean afP(String paramString)
  {
    AppMethodBeat.i(185600);
    if (paramString == null)
    {
      AppMethodBeat.o(185600);
      return false;
    }
    if (n.a((CharSequence)paramString, (CharSequence)"_", false))
    {
      bool = a.afQ((String)n.a((CharSequence)paramString, new String[] { "_" }).get(0));
      AppMethodBeat.o(185600);
      return bool;
    }
    boolean bool = a.afQ(paramString);
    AppMethodBeat.o(185600);
    return bool;
  }
  
  public static final String cri()
  {
    AppMethodBeat.i(122621);
    String str = a.cri();
    AppMethodBeat.o(122621);
    return str;
  }
  
  public static final boolean crp()
  {
    AppMethodBeat.i(122619);
    boolean bool = a.crp();
    AppMethodBeat.o(122619);
    return bool;
  }
  
  public static final boolean crq()
  {
    AppMethodBeat.i(122620);
    String str = a.cri();
    if (!TextUtils.isEmpty((CharSequence)str))
    {
      if (str != null)
      {
        str = a.afC(str);
        if ((!p.i("104", str)) && (!p.i("998", str))) {}
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
  
  public static final int fw(int paramInt1, int paramInt2)
  {
    if (paramInt1 >= paramInt2) {
      return paramInt1 + 1;
    }
    return paramInt2 + 1;
  }
  
  public static final String gb(String paramString1, String paramString2)
  {
    AppMethodBeat.i(177416);
    paramString1 = a.a(paramString1, paramString2, null);
    AppMethodBeat.o(177416);
    return paramString1;
  }
  
  public static final void i(cie paramcie)
  {
    AppMethodBeat.i(122607);
    if (paramcie != null)
    {
      com.tencent.mm.vending.j.c localc = a.afE(paramcie.sessionId);
      if (localc == null)
      {
        AppMethodBeat.o(122607);
        return;
      }
      if (!(p.i("999", localc.get(0)) ^ true))
      {
        String str = a.Dy(paramcie.Huq);
        paramcie.sessionId = (str + "_" + localc.get(1));
      }
    }
    AppMethodBeat.o(122607);
  }
  
  public static final String j(cie paramcie)
  {
    AppMethodBeat.i(122608);
    if (paramcie == null)
    {
      AppMethodBeat.o(122608);
      return null;
    }
    Object localObject1 = a.afE(paramcie.sessionId);
    if (localObject1 == null)
    {
      paramcie = paramcie.sessionId;
      AppMethodBeat.o(122608);
      return paramcie;
    }
    if ((p.i("999", ((com.tencent.mm.vending.j.c)localObject1).get(0)) ^ true))
    {
      localObject2 = ((com.tencent.mm.vending.j.c)localObject1).get(0);
      if (!(localObject2 instanceof Integer)) {}
      while (-1 != ((Integer)localObject2).intValue())
      {
        paramcie = paramcie.sessionId;
        AppMethodBeat.o(122608);
        return paramcie;
      }
    }
    Object localObject2 = a.Dy(paramcie.Huq);
    localObject1 = (String)localObject2 + "_" + ((com.tencent.mm.vending.j.c)localObject1).get(1);
    paramcie.sessionId = ((String)localObject1);
    AppMethodBeat.o(122608);
    return localObject1;
  }
  
  public static final String k(cie paramcie)
  {
    AppMethodBeat.i(122609);
    if (paramcie == null)
    {
      AppMethodBeat.o(122609);
      return null;
    }
    com.tencent.mm.vending.j.c localc = a.afE(paramcie.sessionId);
    if (localc == null)
    {
      paramcie = paramcie.sessionId;
      AppMethodBeat.o(122609);
      return paramcie;
    }
    if ((p.i("999", localc.get(0)) ^ true))
    {
      paramcie = paramcie.sessionId;
      p.g(paramcie, "pageSession.sessionId");
      paramcie = a.afC(paramcie);
      AppMethodBeat.o(122609);
      return paramcie;
    }
    ae.i("HABBYGE-MALI.HellKSessionConfig", "getRealChatSessionId: " + paramcie.Huq);
    paramcie = a.Dy(paramcie.Huq);
    AppMethodBeat.o(122609);
    return paramcie;
  }
  
  public static final String v(long paramLong, int paramInt)
  {
    AppMethodBeat.i(122617);
    String str = String.valueOf(paramLong) + "_" + paramInt;
    AppMethodBeat.o(122617);
    return str;
  }
  
  @l(gjZ={1, 1, 16}, gka={""}, gkb={"Lcom/tencent/mm/plugin/expt/hellhound/ext/session/config/HellKSessionConfig$Companion;", "", "()V", "CHATTING_UI", "", "CHATTING_UI_FRAGMENT", "ILLEGAL_CONFIG_ID", "SESSION_ID_ADDRESS_ADD_FRIEND", "SESSION_ID_ADDRESS_SEARCH", "SESSION_ID_ADD_FRIEND", "SESSION_ID_APPBRAND", "SESSION_ID_AppBrandLauncherUI", "SESSION_ID_BIZ_LIST", "SESSION_ID_BIZ_MESSAGE", "SESSION_ID_BaseScanUI", "SESSION_ID_BottleBeachUI", "SESSION_ID_CHAT", "SESSION_ID_CHAT_PLUGIN_WECHAT_MOVEMENT", "SESSION_ID_CHAT_ROOM", "SESSION_ID_CHAT_SERVICE", "SESSION_ID_CHAT_SERVICE_NOTIFY", "SESSION_ID_CHAT_VIRTUAL", "SESSION_ID_CONTACT_BIZ", "SESSION_ID_CardHomePageUI", "SESSION_ID_ChatroomContactUI", "SESSION_ID_ContactInfoUI", "SESSION_ID_ContactLabelManagerUI", "SESSION_ID_ENTERPRISE", "SESSION_ID_EmojiStoreV2UI", "SESSION_ID_FINDER", "SESSION_ID_FIND_SEARCH", "SESSION_ID_FMessageConversationUI", "SESSION_ID_FTSSOSHomeWebViewUI", "SESSION_ID_FavoriteIndexUI", "SESSION_ID_FloatingWindow", "SESSION_ID_GAME", "SESSION_ID_GLOBAL_SEARCH", "SESSION_ID_HELP", "SESSION_ID_MINI_GAME", "SESSION_ID_MallIndexUI", "SESSION_ID_NearbyFriendsUI", "SESSION_ID_Nearby_Rest", "SESSION_ID_ONLY_CAHT_FRIENDS", "SESSION_ID_OpenIMAddressUI", "SESSION_ID_SEARCH_BaseScanUI", "SESSION_ID_SELECT_CONTACTUI", "SESSION_ID_SettingsPersonalInfoUI", "SESSION_ID_SettingsUI", "SESSION_ID_ShakeReportUI", "SESSION_ID_SnsTimeLineUI", "SESSION_ID_SnsUserUI", "SESSION_ID_StoryCaptureUI", "SESSION_ID_StoryGalleryView", "SESSION_ID_TENCENT_NEWS", "SESSION_ID_TopStoryHomeUI", "SESSION_ID_VOIP_FloatingWindow", "SESSION_ID_WalletOfflineEntranceUI", "SESSION_ID_WebViewUI_jd_store", "TAB_AddressUIFragment", "TAB_FindMoreFriendsUI", "TAB_MainUI", "TAB_MoreTabUI", "TAG", "mSessionIdEntryListLocal", "", "Lcom/tencent/mm/plugin/expt/hellhound/ext/session/dao/SessionKEntry;", "convertChatSid", "", "hellSession", "Lcom/tencent/mm/protocal/protobuf/HellSession;", "pageSession", "Lcom/tencent/mm/protocal/protobuf/PageSession;", "cutInvalidatePageKeyToName", "pageId", "cutSessonToSid", "session", "doNotNeedSessionMonitor", "", "generateSeq", "", "seqOfPage", "seqOfUBA", "getBizIdOfSessionParam", "timestamp", "", "seq", "getCurSession", "getCurSid", "getIdentifySidExpect", "curActivity", "Landroid/app/Activity;", "srcPage", "dstPage", "getLastSession", "getPageStartTimeOfBizId", "bizId", "(Ljava/lang/String;)Ljava/lang/Long;", "getRealChatSid", "chattingType", "getRealChatSidLocal", "getSessionPageOfConfig", "Lcom/tencent/mm/protocal/protobuf/SessionPagePath;", "sid", "isDetailReport", "getSidId", "args", "getSidLocal", "getTabIdOfLauncher", "tabPageName", "getTabSessionIdOfLauncher", "sessionId", "isAppBrandSession", "isBizSid", "isChatSessionId", "isChatSid", "isCurBizSid", "isEffectiveSession", "sessoinId", "isEffectiveSessionBySid", "isFloatSession", "isJdSid", "isVoipSession", "spliteSession", "Lcom/tencent/mm/vending/tuple/Tuple2;", "updateCurSid", "updateRealChatSessionId", "plugin-expt_release"})
  public static final class a
  {
    static String Dy(int paramInt)
    {
      AppMethodBeat.i(122595);
      p.g(c.crs(), "HellSessionCloudConfig.getInstance()");
      Object localObject = c.crt();
      if (localObject == null)
      {
        localObject = Dz(paramInt);
        AppMethodBeat.o(122595);
        return localObject;
      }
      if (((dbv)localObject).fTh)
      {
        ae.e("HABBYGE-MALI.HellKSessionConfig", "getRealChatSid, configCloud.isDel");
        AppMethodBeat.o(122595);
        return "-1";
      }
      localObject = ((dbv)localObject).HKv.iterator();
      while (((Iterator)localObject).hasNext())
      {
        dbu localdbu = (dbu)((Iterator)localObject).next();
        if (localdbu != null)
        {
          ae.i("HABBYGE-MALI.HellKSessionConfig", "getRealChatSid, chatConfig.expect=" + localdbu.HKt);
          if (bu.getInt(localdbu.HKt, -1) == paramInt)
          {
            localObject = localdbu.rfp;
            p.g(localObject, "chatConfig.sid");
            AppMethodBeat.o(122595);
            return localObject;
          }
        }
      }
      localObject = Dz(paramInt);
      AppMethodBeat.o(122595);
      return localObject;
    }
    
    private static String Dz(int paramInt)
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
        ae.i("HABBYGE-MALI.HellKSessionConfig", "getRealChatSidLocal: ".concat(String.valueOf(str)));
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
      p.g(c.crs(), "HellSessionCloudConfig.getInstance()");
      Object localObject1 = c.crt();
      if (localObject1 == null)
      {
        AppMethodBeat.o(122591);
        return null;
      }
      dbz localdbz;
      do
      {
        String str;
        do
        {
          localObject1 = ((dbv)localObject1).HKx.iterator();
          Object localObject2;
          while (!((Iterator)localObject2).hasNext())
          {
            do
            {
              if (!((Iterator)localObject1).hasNext()) {
                break;
              }
              localdbz = (dbz)((Iterator)localObject1).next();
            } while ((localdbz == null) || (localdbz.HKA.isEmpty()) || ((p.i(localdbz.HKs, paramString1) ^ true)));
            localObject2 = localdbz.duQ;
            p.g(localObject2, "config.pageName");
            localObject2 = n.a((CharSequence)localObject2, new String[] { "," }).iterator();
          }
          str = (String)((Iterator)localObject2).next();
          if (str == null)
          {
            paramActivity = new v("null cannot be cast to non-null type kotlin.CharSequence");
            AppMethodBeat.o(122591);
            throw paramActivity;
          }
        } while (!p.i(n.trim((CharSequence)str).toString(), paramString2));
        ae.i("HABBYGE-MALI.HellKSessionConfig", "getIdentifySidExpect, sid: " + localdbz.rfp);
      } while (!a.a(paramActivity, localdbz));
      paramActivity = localdbz.rfp;
      AppMethodBeat.o(122591);
      return paramActivity;
      AppMethodBeat.o(122591);
      return null;
    }
    
    public static String a(String paramString1, String paramString2, List<String> paramList)
    {
      AppMethodBeat.i(122592);
      paramString1 = com.tencent.mm.plugin.expt.hellhound.core.b.aer(paramString1);
      String str1 = com.tencent.mm.plugin.expt.hellhound.core.b.aer(paramString2);
      ae.i("HABBYGE-MALI.HellKSessionConfig", "getSessionIdLocal: " + paramString1 + ", " + str1);
      if (((p.i("ChattingUI", paramString2)) || (p.i("ChattingUIFragment", paramString2))) && ((p.i(com.tencent.mm.plugin.expt.hellhound.core.b.qYK, paramString1)) || (TextUtils.isEmpty((CharSequence)paramString1))))
      {
        ae.i("HABBYGE-MALI.HellKSessionConfig", "getSidId: 999");
        AppMethodBeat.o(122592);
        return "999";
      }
      if ((p.i("WebViewUI", str1)) && ((p.i("FindMoreFriendsUI", paramString1)) || (p.i("MainUI", paramString1)) || (p.i("AddressUIFragment", paramString1))))
      {
        paramString2 = com.tencent.mm.plugin.expt.hellhound.a.h.a.rhY;
        if (com.tencent.mm.plugin.expt.hellhound.a.h.a.csp())
        {
          AppMethodBeat.o(122592);
          return "148";
        }
      }
      if (p.i("BaseScanUI", str1))
      {
        paramString2 = com.tencent.mm.plugin.expt.hellhound.a.f.g.b.a.rhI;
        if (com.tencent.mm.plugin.expt.hellhound.a.f.g.b.a.csi())
        {
          AppMethodBeat.o(122592);
          return "124";
        }
        paramString2 = com.tencent.mm.plugin.expt.hellhound.a.h.a.rhY;
        if (com.tencent.mm.plugin.expt.hellhound.a.h.a.cso())
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
          paramString2 = b.cro().iterator();
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
            } while (!p.i(paramString1, paramList.rhm));
            localObject = paramList.rhn.iterator();
          }
        } while (!p.i(str1, (String)((Iterator)localObject).next()));
        if (p.i(paramList.sessionId, "109"))
        {
          paramString1 = com.tencent.mm.plugin.expt.hellhound.a.h.a.rhY;
          if (com.tencent.mm.plugin.expt.hellhound.a.h.a.cso())
          {
            AppMethodBeat.o(122592);
            return "109";
          }
          AppMethodBeat.o(122592);
          return "124";
        }
        if ((p.i(paramList.sessionId, "105")) || (p.i(paramList.sessionId, "131")))
        {
          paramString1 = com.tencent.mm.plugin.expt.hellhound.a.f.g.b.a.rhI;
          if (com.tencent.mm.plugin.expt.hellhound.a.f.g.b.a.csh())
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
      paramString2 = b.cro().iterator();
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
        if ((p.i(paramString1, ((i)localObject).rhm) ^ true)) {
          break label653;
        }
        Iterator localIterator = ((i)localObject).rhn.iterator();
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
              if (p.i(str2, (String)paramList.get(i))) {
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
          if ((p.i(str1, str2) ^ true)) {
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
    
    public static String afC(String paramString)
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
    
    public static com.tencent.mm.vending.j.c<String, String> afE(String paramString)
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
      paramString = com.tencent.mm.vending.j.a.N(paramString.get(0), paramString.get(1));
      AppMethodBeat.o(122594);
      return paramString;
    }
    
    public static boolean afG(String paramString)
    {
      AppMethodBeat.i(122597);
      if ((p.i("101", paramString)) || (p.i("102", paramString)) || (p.i("103", paramString)) || (p.i("111", paramString)) || (p.i("112", paramString)))
      {
        AppMethodBeat.o(122597);
        return true;
      }
      AppMethodBeat.o(122597);
      return false;
    }
    
    public static boolean afI(String paramString)
    {
      AppMethodBeat.i(196629);
      if (paramString == null)
      {
        AppMethodBeat.o(196629);
        return false;
      }
      boolean bool = p.i("145", afC(paramString));
      AppMethodBeat.o(196629);
      return bool;
    }
    
    public static Long afM(String paramString)
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
        ae.printErrStackTrace("HABBYGE-MALI.HellKSessionConfig", (Throwable)paramString, "getPageStartTimeOfBusinessId, crash: " + paramString.getMessage(), new Object[0]);
        AppMethodBeat.o(122598);
      }
      return null;
    }
    
    public static String afN(String paramString)
    {
      AppMethodBeat.i(196630);
      if (paramString == null)
      {
        AppMethodBeat.o(196630);
        return null;
      }
      if (n.a((CharSequence)paramString, (CharSequence)".", false))
      {
        if (p.i(paramString, com.tencent.mm.plugin.expt.hellhound.core.b.qYF))
        {
          AppMethodBeat.o(196630);
          return "0";
        }
        if (p.i(paramString, com.tencent.mm.plugin.expt.hellhound.core.b.qYG))
        {
          AppMethodBeat.o(196630);
          return "1";
        }
        if (p.i(paramString, com.tencent.mm.plugin.expt.hellhound.core.b.qYH))
        {
          AppMethodBeat.o(196630);
          return "2";
        }
        if (p.i(paramString, com.tencent.mm.plugin.expt.hellhound.core.b.qYI))
        {
          AppMethodBeat.o(196630);
          return "3";
        }
        AppMethodBeat.o(196630);
        return paramString;
      }
      if (p.i(paramString, com.tencent.mm.plugin.expt.hellhound.core.b.qYK))
      {
        AppMethodBeat.o(196630);
        return "0";
      }
      if (p.i(paramString, com.tencent.mm.plugin.expt.hellhound.core.b.qYL))
      {
        AppMethodBeat.o(196630);
        return "1";
      }
      if (p.i(paramString, com.tencent.mm.plugin.expt.hellhound.core.b.qYM))
      {
        AppMethodBeat.o(196630);
        return "2";
      }
      if (p.i(paramString, com.tencent.mm.plugin.expt.hellhound.core.b.qYN))
      {
        AppMethodBeat.o(196630);
        return "3";
      }
      AppMethodBeat.o(196630);
      return paramString;
    }
    
    static boolean afQ(String paramString)
    {
      AppMethodBeat.i(185598);
      if ((p.i(paramString, "0")) || (p.i(paramString, "1")) || (p.i(paramString, "2")) || (p.i(paramString, "3")))
      {
        AppMethodBeat.o(185598);
        return false;
      }
      boolean bool = com.tencent.mm.plugin.expt.hellhound.core.b.isNumeric(paramString);
      AppMethodBeat.o(185598);
      return bool;
    }
    
    public static String cri()
    {
      AppMethodBeat.i(122601);
      String str = crr();
      if (str == null)
      {
        AppMethodBeat.o(122601);
        return null;
      }
      str = afC(str);
      AppMethodBeat.o(122601);
      return str;
    }
    
    public static boolean crp()
    {
      AppMethodBeat.i(122599);
      if (!com.tencent.mm.plugin.expt.hellhound.a.coV())
      {
        ae.i("HABBYGE-MALI.HellKSessionConfig", "HellSessionMonitor monitor, fetchHellhoundConfig: FALSE");
        AppMethodBeat.o(122599);
        return true;
      }
      p.g(c.crs(), "HellSessionCloudConfig.getInstance()");
      if ((c.cru()) || (com.tencent.mm.plugin.expt.hellhound.core.b.getUin() == 0))
      {
        ae.i("HABBYGE-MALI.HellKSessionConfig", "HellSessionMonitor monitor FALSE");
        AppMethodBeat.o(122599);
        return true;
      }
      if (!com.tencent.mm.plugin.expt.hellhound.a.coX())
      {
        ae.i("HABBYGE-MALI.HellKSessionConfig", "HellSessionMonitor monitor, close !!!");
        AppMethodBeat.o(122599);
        return true;
      }
      AppMethodBeat.o(122599);
      return false;
    }
    
    public static String crr()
    {
      AppMethodBeat.i(122600);
      Object localObject = com.tencent.mm.plugin.expt.hellhound.a.f.c.c.crG();
      if (localObject == null)
      {
        AppMethodBeat.o(122600);
        return null;
      }
      localObject = ((cie)localObject).sessionId;
      AppMethodBeat.o(122600);
      return localObject;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.expt.hellhound.a.f.b.b
 * JD-Core Version:    0.7.0.1
 */