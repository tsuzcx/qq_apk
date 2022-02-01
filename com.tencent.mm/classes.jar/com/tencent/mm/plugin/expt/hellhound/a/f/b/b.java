package com.tencent.mm.plugin.expt.hellhound.a.f.b;

import android.app.Activity;
import android.text.TextUtils;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.expt.hellhound.a.f.c.i;
import com.tencent.mm.protocal.protobuf.bjw;
import com.tencent.mm.protocal.protobuf.ccs;
import com.tencent.mm.protocal.protobuf.cvo;
import com.tencent.mm.protocal.protobuf.cvp;
import com.tencent.mm.protocal.protobuf.cvq;
import com.tencent.mm.protocal.protobuf.cvr;
import com.tencent.mm.protocal.protobuf.cvt;
import com.tencent.mm.protocal.protobuf.cvx;
import com.tencent.mm.protocal.protobuf.cwa;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.bs;
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

@l(fNY={1, 1, 16}, fNZ={""}, fOa={"Lcom/tencent/mm/plugin/expt/hellhound/ext/session/config/HellKSessionConfig;", "", "()V", "Companion", "plugin-expt_release"})
public final class b
{
  private static final List<i> qpW;
  public static final a qpX;
  
  static
  {
    AppMethodBeat.i(122602);
    qpX = new a((byte)0);
    qpW = j.listOf(new i[] { new i("999", com.tencent.mm.plugin.expt.hellhound.core.b.qiM, (List)j.ab(new String[] { "ChattingUIFragment", "ChattingUI" })), new i("998", com.tencent.mm.plugin.expt.hellhound.core.b.qiM, (List)j.ab(new String[] { "BizConversationUI" })), new i("104", com.tencent.mm.plugin.expt.hellhound.core.b.qiM, (List)j.ab(new String[] { "BizTimeLineUI" })), new i("105", com.tencent.mm.plugin.expt.hellhound.core.b.qiM, (List)j.ab(new String[] { "AppBrandLaunchProxyUI", "AppBrandUI", "AppBrandUI1", "AppBrandUI2", "AppBrandUI3", "AppBrandUI4" })), new i("105", com.tencent.mm.plugin.expt.hellhound.core.b.qiM, (List)j.ab(new String[] { "AppBrandUI", "AppBrandUI1", "AppBrandUI2", "AppBrandUI3", "AppBrandUI4" })), new i("105", "LauncherUI", (List)j.ab(new String[] { "AppBrandLaunchProxyUI", "AppBrandUI", "AppBrandUI1", "AppBrandUI2", "AppBrandUI3", "AppBrandUI4" })), new i("105", "LauncherUI", (List)j.ab(new String[] { "AppBrandUI", "AppBrandUI1", "AppBrandUI2", "AppBrandUI3", "AppBrandUI4" })), new i("105", com.tencent.mm.plugin.expt.hellhound.core.b.qiM, (List)j.ab(new String[] { "AppBrandLauncherUI" })), new i("105", "LauncherUI", (List)j.ab(new String[] { "AppBrandLauncherUI" })), new i("105", "WXShortcutEntryActivity", (List)j.ab(new String[] { "AppBrandLaunchProxyUI", "AppBrandUI", "AppBrandUI1", "AppBrandUI2", "AppBrandUI3", "AppBrandUI4" })), new i("105", com.tencent.mm.plugin.expt.hellhound.core.b.qiN, (List)j.ab(new String[] { "AppBrandLaunchProxyUI", "AppBrandUI", "AppBrandUI1", "AppBrandUI2", "AppBrandUI3", "AppBrandUI4" })), new i("105", com.tencent.mm.plugin.expt.hellhound.core.b.qiO, (List)j.ab(new String[] { "AppBrandLaunchProxyUI", "AppBrandUI", "AppBrandUI1", "AppBrandUI2", "AppBrandUI3", "AppBrandUI4" })), new i("105", com.tencent.mm.plugin.expt.hellhound.core.b.qiP, (List)j.ab(new String[] { "AppBrandLaunchProxyUI", "AppBrandUI", "AppBrandUI1", "AppBrandUI2", "AppBrandUI3", "AppBrandUI4" })), new i("113", com.tencent.mm.plugin.expt.hellhound.core.b.qiM, (List)j.ab(new String[] { "ReaderAppUI" })), new i("114", com.tencent.mm.plugin.expt.hellhound.core.b.qiN, (List)j.ab(new String[] { "FTSMainUI" })), new i("147", com.tencent.mm.plugin.expt.hellhound.core.b.qiO, (List)j.ab(new String[] { "FTSMainUI" })), new i("115", com.tencent.mm.plugin.expt.hellhound.core.b.qiN, (List)j.ab(new String[] { "AddMoreFriendsUI" })), new i("116", com.tencent.mm.plugin.expt.hellhound.core.b.qiN, (List)j.ab(new String[] { "FMessageConversationUI" })), new i("117", com.tencent.mm.plugin.expt.hellhound.core.b.qiN, (List)j.ab(new String[] { "ChatroomContactUI" })), new i("118", com.tencent.mm.plugin.expt.hellhound.core.b.qiN, (List)j.ab(new String[] { "ContactLabelManagerUI" })), new i("106", com.tencent.mm.plugin.expt.hellhound.core.b.qiM, (List)j.ab(new String[] { "FTSMainUI" })), new i("107", com.tencent.mm.plugin.expt.hellhound.core.b.qiM, (List)j.ab(new String[] { "SelectContactUI" })), new i("107", com.tencent.mm.plugin.expt.hellhound.core.b.qiN, (List)j.ab(new String[] { "SelectContactUI" })), new i("107", com.tencent.mm.plugin.expt.hellhound.core.b.qiO, (List)j.ab(new String[] { "SelectContactUI" })), new i("108", com.tencent.mm.plugin.expt.hellhound.core.b.qiM, (List)j.ab(new String[] { "AddMoreFriendsUI" })), new i("108", com.tencent.mm.plugin.expt.hellhound.core.b.qiN, (List)j.ab(new String[] { "AddMoreFriendsUI" })), new i("108", com.tencent.mm.plugin.expt.hellhound.core.b.qiO, (List)j.ab(new String[] { "AddMoreFriendsUI" })), new i("109", com.tencent.mm.plugin.expt.hellhound.core.b.qiM, (List)j.ab(new String[] { "BaseScanUI" })), new i("109", com.tencent.mm.plugin.expt.hellhound.core.b.qiN, (List)j.ab(new String[] { "BaseScanUI" })), new i("109", com.tencent.mm.plugin.expt.hellhound.core.b.qiO, (List)j.ab(new String[] { "BaseScanUI" })), new i("110", com.tencent.mm.plugin.expt.hellhound.core.b.qiM, (List)j.ab(new String[] { "WalletOfflineEntranceUI" })), new i("110", com.tencent.mm.plugin.expt.hellhound.core.b.qiN, (List)j.ab(new String[] { "WalletOfflineEntranceUI" })), new i("110", com.tencent.mm.plugin.expt.hellhound.core.b.qiO, (List)j.ab(new String[] { "WalletOfflineEntranceUI" })), new i("119", com.tencent.mm.plugin.expt.hellhound.core.b.qiN, (List)j.ab(new String[] { "BrandServiceIndexUI" })), new i("120", com.tencent.mm.plugin.expt.hellhound.core.b.qiN, (List)j.ab(new String[] { "EnterpriseBizContactListUI" })), new i("121", "AddressUIFragment", (List)j.ab(new String[] { "OpenIMAddressUI" })), new i("122", "AddressUIFragment", (List)j.ab(new String[] { "ContactInfoUI" })), new i("123", com.tencent.mm.plugin.expt.hellhound.core.b.qiO, (List)j.ab(new String[] { "SnsTimeLineUI" })), new i("124", com.tencent.mm.plugin.expt.hellhound.core.b.qiO, (List)j.ab(new String[] { "BaseScanUI" })), new i("125", com.tencent.mm.plugin.expt.hellhound.core.b.qiO, (List)j.ab(new String[] { "ShakeReportUI" })), new i("126", com.tencent.mm.plugin.expt.hellhound.core.b.qiO, (List)j.ab(new String[] { "TopStoryHomeUI" })), new i("127", com.tencent.mm.plugin.expt.hellhound.core.b.qiO, (List)j.ab(new String[] { "FTSSOSHomeWebViewUI" })), new i("128", com.tencent.mm.plugin.expt.hellhound.core.b.qiO, (List)j.ab(new String[] { "NearbyFriendsIntroUI", "NearbyFriendsUI", "NearbyPersonalInfoUI", "NearbyFriendShowSayHiUI" })), new i("129", com.tencent.mm.plugin.expt.hellhound.core.b.qiO, (List)j.ab(new String[] { "BottleBeachUI" })), new i("130", com.tencent.mm.plugin.expt.hellhound.core.b.qiO, (List)j.ab(new String[] { "AppBrandPluginUI" })), new i("131", com.tencent.mm.plugin.expt.hellhound.core.b.qiO, (List)j.ab(new String[] { "WebViewUI", "1", "jd_store" })), new i("131", com.tencent.mm.plugin.expt.hellhound.core.b.qiO, (List)j.ab(new String[] { "AppBrandLaunchProxyUI", "AppBrandUI", "AppBrandUI1", "AppBrandUI2", "AppBrandUI3", "AppBrandUI4" })), new i("132", com.tencent.mm.plugin.expt.hellhound.core.b.qiO, (List)j.ab(new String[] { "GameWebViewUI" })), new i("132", com.tencent.mm.plugin.expt.hellhound.core.b.qiO, (List)j.ab(new String[] { "GameCenterUI" })), new i("132", com.tencent.mm.plugin.expt.hellhound.core.b.qiO, (List)j.ab(new String[] { "LuggageGameWebViewUI" })), new i("132", com.tencent.mm.plugin.expt.hellhound.core.b.qiO, (List)j.ab(new String[] { "GameWebViewMpUI" })), new i("132", com.tencent.mm.plugin.expt.hellhound.core.b.qiO, (List)j.ab(new String[] { "LuggageGameWebViewMpUI" })), new i("133", com.tencent.mm.plugin.expt.hellhound.core.b.qiO, (List)j.ab(new String[] { "AppBrandLauncherUI" })), new i("134", com.tencent.mm.plugin.expt.hellhound.core.b.qiP, (List)j.ab(new String[] { "SettingsPersonalInfoUI" })), new i("135", com.tencent.mm.plugin.expt.hellhound.core.b.qiP, (List)j.ab(new String[] { "MallIndexUI" })), new i("136", com.tencent.mm.plugin.expt.hellhound.core.b.qiP, (List)j.ab(new String[] { "FavoriteIndexUI" })), new i("137", com.tencent.mm.plugin.expt.hellhound.core.b.qiP, (List)j.ab(new String[] { "SnsUserUI", "AlbumUI" })), new i("138", com.tencent.mm.plugin.expt.hellhound.core.b.qiP, (List)j.ab(new String[] { "CardHomePageNewUI", "CardHomePageUI", "CardIndexUI", "CardInvalidCardUI", "CardViewUI", "ShareCardListUI" })), new i("139", "MoreTabUI", (List)j.ab(new String[] { "EmojiStoreV2UI", "MMFlutterActivity" })), new i("140", "MoreTabUI", (List)j.ab(new String[] { "SettingsUI" })), new i("141", "MoreTabUI", (List)j.ab(new String[] { "StoryCaptureUI", "MMRecordUI" })), new i("142", "MoreTabUI", (List)j.ab(new String[] { "StoryGalleryView", "StoryVideoView" })), new i("143", "FindMoreFriendsUI", (List)j.ab(new String[] { "FinderTimelineUI" })), new i("143", "FindMoreFriendsUI", (List)j.ab(new String[] { "FinderHomeUI" })), new i("143", "FindMoreFriendsUI", (List)j.ab(new String[] { "FinderConversationUI" })), new i("143", "AddressUIFragment", (List)j.ab(new String[] { "FinderTimelineUI" })), new i("145", "LauncherUI", (List)j.ab(new String[] { "FloatingBall" })), new i("146", "LauncherUI", (List)j.ab(new String[] { "VideoActivity" })) });
    AppMethodBeat.o(122602);
  }
  
  public static final String a(Activity paramActivity, String paramString1, String paramString2, List<String> paramList)
  {
    AppMethodBeat.i(122603);
    paramString1 = com.tencent.mm.plugin.expt.hellhound.core.b.ZK(paramString1);
    ac.i("HABBYGE-MALI.HellKSessionConfig", "getSidId: " + paramString1 + ", " + paramString2);
    k.g(c.ckB(), "HellSessionCloudConfig.getInstance()");
    Object localObject1 = c.ckC();
    if (localObject1 == null)
    {
      paramActivity = a.a(paramString1, paramString2, paramList);
      AppMethodBeat.o(122603);
      return paramActivity;
    }
    if (((cvp)localObject1).fxO)
    {
      ac.e("HABBYGE-MALI.HellKSessionConfig", "getSidId, sessionCloud.isDel ture");
      AppMethodBeat.o(122603);
      return null;
    }
    if (((k.g("ChattingUI", paramString2)) || (k.g("ChattingUIFragment", paramString2))) && ((k.g(com.tencent.mm.plugin.expt.hellhound.core.b.qiM, paramString1)) || (TextUtils.isEmpty((CharSequence)paramString1))))
    {
      ac.i("HABBYGE-MALI.HellKSessionConfig", "HellKSessionConfig, getSidId: 999");
      AppMethodBeat.o(122603);
      return "999";
    }
    if (k.g("WebViewUI", paramString2)) {
      if (k.g("FindMoreFriendsUI", paramString1))
      {
        if (((cvp)localObject1).FGs != null)
        {
          if ((paramList != null) && (paramList.size() >= 2) && (k.g(((cvp)localObject1).FGs.FGu, (String)paramList.get(0))) && (k.g(((cvp)localObject1).FGs.FGv, (String)paramList.get(1))))
          {
            ac.i("HABBYGE-MALI.HellKSessionConfig", "getSidId, SESSION_ID_WebViewUI_jd_store");
            AppMethodBeat.o(122603);
            return "131";
          }
        }
        else
        {
          localObject2 = com.tencent.mm.plugin.expt.hellhound.a.h.a.qqO;
          if (com.tencent.mm.plugin.expt.hellhound.a.h.a.cly())
          {
            paramActivity = com.tencent.mm.plugin.expt.hellhound.a.h.a.qqO;
            com.tencent.mm.plugin.expt.hellhound.a.h.a.kP(false);
            AppMethodBeat.o(122603);
            return "148";
          }
        }
      }
      else if ((k.g("MainUI", paramString1)) || (k.g("AddressUIFragment", paramString1)))
      {
        localObject2 = com.tencent.mm.plugin.expt.hellhound.a.h.a.qqO;
        if (com.tencent.mm.plugin.expt.hellhound.a.h.a.cly())
        {
          paramActivity = com.tencent.mm.plugin.expt.hellhound.a.h.a.qqO;
          com.tencent.mm.plugin.expt.hellhound.a.h.a.kP(false);
          AppMethodBeat.o(122603);
          return "148";
        }
      }
    }
    if (k.g("BaseScanUI", paramString2))
    {
      localObject2 = com.tencent.mm.plugin.expt.hellhound.a.f.g.b.a.qqx;
      if (com.tencent.mm.plugin.expt.hellhound.a.f.g.b.a.clr())
      {
        paramActivity = com.tencent.mm.plugin.expt.hellhound.a.f.g.b.a.qqx;
        com.tencent.mm.plugin.expt.hellhound.a.f.g.b.a.kM(false);
        AppMethodBeat.o(122603);
        return "124";
      }
      localObject2 = com.tencent.mm.plugin.expt.hellhound.a.h.a.qqO;
      if (com.tencent.mm.plugin.expt.hellhound.a.h.a.clx())
      {
        paramActivity = com.tencent.mm.plugin.expt.hellhound.a.h.a.qqO;
        com.tencent.mm.plugin.expt.hellhound.a.h.a.kO(false);
        AppMethodBeat.o(122603);
        return "109";
      }
    }
    Object localObject2 = com.tencent.mm.plugin.expt.hellhound.a.f.g.b.a.qqx;
    com.tencent.mm.plugin.expt.hellhound.a.f.g.b.a.clr();
    if ((paramList == null) || (paramList.isEmpty()))
    {
      localObject1 = ((cvp)localObject1).FGq.iterator();
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
            localObject2 = (cvr)((Iterator)localObject1).next();
          } while ((localObject2 == null) || (!k.g(((cvr)localObject2).FGo, paramString1)));
          localObject3 = ((cvr)localObject2).qoi;
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
      if (k.g(((cvr)localObject2).qon, "109"))
      {
        paramActivity = com.tencent.mm.plugin.expt.hellhound.a.h.a.qqO;
        if (com.tencent.mm.plugin.expt.hellhound.a.h.a.clx())
        {
          paramActivity = com.tencent.mm.plugin.expt.hellhound.a.h.a.qqO;
          com.tencent.mm.plugin.expt.hellhound.a.h.a.kO(false);
          AppMethodBeat.o(122603);
          return "109";
        }
        AppMethodBeat.o(122603);
        return "124";
      }
      if ((k.g(((cvr)localObject2).qon, "105")) || (k.g(((cvr)localObject2).qon, "131")))
      {
        paramActivity = com.tencent.mm.plugin.expt.hellhound.a.f.g.b.a.qqx;
        if (com.tencent.mm.plugin.expt.hellhound.a.f.g.b.a.clq())
        {
          paramActivity = com.tencent.mm.plugin.expt.hellhound.a.f.g.b.a.qqx;
          com.tencent.mm.plugin.expt.hellhound.a.f.g.b.a.kL(false);
          AppMethodBeat.o(122603);
          return "131";
        }
        AppMethodBeat.o(122603);
        return "105";
      }
      paramActivity = ((cvr)localObject2).qon;
      AppMethodBeat.o(122603);
      return paramActivity;
      paramActivity = a.a(paramActivity, paramString1, paramString2);
      if (paramActivity != null)
      {
        AppMethodBeat.o(122603);
        return paramActivity;
      }
    }
    ac.i("HABBYGE-MALI.HellKSessionConfig", "get sid by cloud config, but NULL, dignose sid By local config !!!");
    paramActivity = a.a(paramString1, paramString2, paramList);
    AppMethodBeat.o(122603);
    return paramActivity;
  }
  
  public static final void a(bjw parambjw)
  {
    AppMethodBeat.i(122606);
    if (parambjw != null)
    {
      parambjw = parambjw.EZo;
      k.g(parambjw, "hellSession.sessions");
      Object localObject1 = (Iterable)parambjw;
      parambjw = (Collection)new ArrayList();
      localObject1 = ((Iterable)localObject1).iterator();
      Object localObject2;
      Object localObject3;
      label159:
      while (((Iterator)localObject1).hasNext())
      {
        localObject2 = ((Iterator)localObject1).next();
        localObject3 = (ccs)localObject2;
        String str = ((ccs)localObject3).sessionId;
        k.g(str, "it.sessionId");
        if ((k.g(a.aaS(str), "999")) && ((((ccs)localObject3).Fre == 0) || (((ccs)localObject3).Fre == 1) || (((ccs)localObject3).Fre == 2) || (((ccs)localObject3).Fre == 4) || (((ccs)localObject3).Fre == 5))) {}
        for (int i = 1;; i = 0)
        {
          if (i == 0) {
            break label159;
          }
          parambjw.add(localObject2);
          break;
        }
      }
      localObject1 = j.l((Iterable)parambjw);
      if (localObject1 == null)
      {
        AppMethodBeat.o(122606);
        return;
      }
      ac.i("HABBYGE-MALI.HellKSessionConfig", "after, sessionList.size: " + ((List)localObject1).size());
      parambjw = null;
      localObject1 = ((List)localObject1).iterator();
      while (((Iterator)localObject1).hasNext())
      {
        localObject2 = (ccs)((Iterator)localObject1).next();
        localObject3 = a.aaU(((ccs)localObject2).sessionId);
        if (localObject3 != null) {
          parambjw = "_" + ((com.tencent.mm.vending.j.c)localObject3).get(1);
        }
        ac.i("HABBYGE-MALI.HellKSessionConfig", "handleChatting, session, Start: " + ((ccs)localObject2).sessionId + ", " + parambjw);
        ((ccs)localObject2).sessionId = a.Cy(((ccs)localObject2).Fre);
        if ((k.g(((ccs)localObject2).sessionId, "-1") ^ true))
        {
          localObject3 = ((ccs)localObject2).sessionId;
          ((ccs)localObject2).sessionId = ((String)localObject3 + parambjw);
        }
        ac.i("HABBYGE-MALI.HellKSessionConfig", "handleChatting, session, End: " + ((ccs)localObject2).sessionId);
      }
    }
    AppMethodBeat.o(122606);
  }
  
  public static final String aaS(String paramString)
  {
    AppMethodBeat.i(122604);
    paramString = a.aaS(paramString);
    AppMethodBeat.o(122604);
    return paramString;
  }
  
  public static final String aaT(String paramString)
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
  
  public static final com.tencent.mm.vending.j.c<String, String> aaU(String paramString)
  {
    AppMethodBeat.i(177417);
    paramString = a.aaU(paramString);
    AppMethodBeat.o(177417);
    return paramString;
  }
  
  public static final void aaV(String paramString)
  {
    AppMethodBeat.i(177418);
    if (paramString == null)
    {
      AppMethodBeat.o(177418);
      return;
    }
    ccs localccs = com.tencent.mm.plugin.expt.hellhound.a.f.c.c.ckP();
    if (localccs == null)
    {
      AppMethodBeat.o(177418);
      return;
    }
    com.tencent.mm.vending.j.c localc = a.aaU(localccs.sessionId);
    if (localc == null)
    {
      AppMethodBeat.o(177418);
      return;
    }
    ac.i("HABBYGE-MALI.HellKSessionConfig", "HellK, updateCurSid, old: " + localccs.sessionId);
    paramString = paramString + "_" + localc.get(1);
    localccs.sessionId = paramString;
    com.tencent.mm.plugin.expt.hellhound.a.f.c.c.j(localccs);
    ac.i("HABBYGE-MALI.HellKSessionConfig", "HellK, updateCurSid, new: ".concat(String.valueOf(paramString)));
    AppMethodBeat.o(177418);
  }
  
  public static final boolean aaW(String paramString)
  {
    AppMethodBeat.i(122610);
    boolean bool = a.aaW(paramString);
    AppMethodBeat.o(122610);
    return bool;
  }
  
  public static final boolean aaX(String paramString)
  {
    AppMethodBeat.i(122611);
    if (paramString == null)
    {
      AppMethodBeat.o(122611);
      return false;
    }
    boolean bool = k.g("105", a.aaS(paramString));
    AppMethodBeat.o(122611);
    return bool;
  }
  
  public static final boolean aaY(String paramString)
  {
    AppMethodBeat.i(122612);
    if (paramString == null)
    {
      AppMethodBeat.o(122612);
      return false;
    }
    boolean bool = k.g("145", a.aaS(paramString));
    AppMethodBeat.o(122612);
    return bool;
  }
  
  public static final boolean aaZ(String paramString)
  {
    AppMethodBeat.i(122613);
    if (paramString == null)
    {
      AppMethodBeat.o(122613);
      return false;
    }
    boolean bool = k.g("146", a.aaS(paramString));
    AppMethodBeat.o(122613);
    return bool;
  }
  
  public static final boolean aba(String paramString)
  {
    AppMethodBeat.i(122614);
    if (paramString == null)
    {
      AppMethodBeat.o(122614);
      return false;
    }
    paramString = a.aaS(paramString);
    if ((k.g("999", paramString)) || (a.aaW(paramString)))
    {
      AppMethodBeat.o(122614);
      return true;
    }
    AppMethodBeat.o(122614);
    return false;
  }
  
  public static final boolean abb(String paramString)
  {
    AppMethodBeat.i(122615);
    k.h(paramString, "sid");
    boolean bool = k.g("131", paramString);
    AppMethodBeat.o(122615);
    return bool;
  }
  
  public static final List<cwa> abc(String paramString)
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
    k.g(d.ckF(), "HellSessionPageCloudConfig.getInstance()");
    Object localObject = d.ckG();
    if (localObject == null)
    {
      AppMethodBeat.o(122616);
      return null;
    }
    ArrayList localArrayList = new ArrayList();
    Iterator localIterator = ((cvx)localObject).FGz.iterator();
    while (localIterator.hasNext())
    {
      cwa localcwa = (cwa)localIterator.next();
      if ((localcwa != null) && (localcwa.type == 0) && ((!(k.g(localcwa.qon, paramString) ^ true)) || (!(k.g(localcwa.qon, "-1") ^ true))))
      {
        localObject = localcwa;
        if (!localcwa.rAJ) {
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
  
  public static final Long abd(String paramString)
  {
    AppMethodBeat.i(122618);
    paramString = a.abd(paramString);
    AppMethodBeat.o(122618);
    return paramString;
  }
  
  public static final String abe(String paramString)
  {
    AppMethodBeat.i(185599);
    paramString = a.abe(paramString);
    AppMethodBeat.o(185599);
    return paramString;
  }
  
  public static final String abf(String paramString)
  {
    AppMethodBeat.i(195594);
    if (paramString == null)
    {
      AppMethodBeat.o(195594);
      return null;
    }
    if (n.a((CharSequence)paramString, (CharSequence)"_", false))
    {
      paramString = n.a((CharSequence)paramString, new String[] { "_" });
      paramString = a.abe((String)paramString.get(0)) + "_" + (String)paramString.get(1);
      AppMethodBeat.o(195594);
      return paramString;
    }
    AppMethodBeat.o(195594);
    return paramString;
  }
  
  public static final boolean abg(String paramString)
  {
    AppMethodBeat.i(185600);
    if (paramString == null)
    {
      AppMethodBeat.o(185600);
      return false;
    }
    if (n.a((CharSequence)paramString, (CharSequence)"_", false))
    {
      bool = a.abh((String)n.a((CharSequence)paramString, new String[] { "_" }).get(0));
      AppMethodBeat.o(185600);
      return bool;
    }
    boolean bool = a.abh(paramString);
    AppMethodBeat.o(185600);
    return bool;
  }
  
  public static final boolean ckx()
  {
    AppMethodBeat.i(122619);
    boolean bool = a.ckx();
    AppMethodBeat.o(122619);
    return bool;
  }
  
  public static final boolean cky()
  {
    AppMethodBeat.i(122620);
    String str = a.ckz();
    if (!TextUtils.isEmpty((CharSequence)str))
    {
      if (str != null)
      {
        str = a.aaS(str);
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
  
  public static final String ckz()
  {
    AppMethodBeat.i(122621);
    String str = a.ckz();
    AppMethodBeat.o(122621);
    return str;
  }
  
  public static final void f(ccs paramccs)
  {
    AppMethodBeat.i(122607);
    if (paramccs != null)
    {
      com.tencent.mm.vending.j.c localc = a.aaU(paramccs.sessionId);
      if (localc == null)
      {
        AppMethodBeat.o(122607);
        return;
      }
      if (!(k.g("999", localc.get(0)) ^ true))
      {
        String str = a.Cy(paramccs.Fre);
        paramccs.sessionId = (str + "_" + localc.get(1));
      }
    }
    AppMethodBeat.o(122607);
  }
  
  public static final String fN(String paramString1, String paramString2)
  {
    AppMethodBeat.i(177416);
    paramString1 = a.a(paramString1, paramString2, null);
    AppMethodBeat.o(177416);
    return paramString1;
  }
  
  public static final int fr(int paramInt1, int paramInt2)
  {
    if (paramInt1 >= paramInt2) {
      return paramInt1 + 1;
    }
    return paramInt2 + 1;
  }
  
  public static final String g(ccs paramccs)
  {
    AppMethodBeat.i(122608);
    if (paramccs == null)
    {
      AppMethodBeat.o(122608);
      return null;
    }
    Object localObject1 = a.aaU(paramccs.sessionId);
    if (localObject1 == null)
    {
      paramccs = paramccs.sessionId;
      AppMethodBeat.o(122608);
      return paramccs;
    }
    if ((k.g("999", ((com.tencent.mm.vending.j.c)localObject1).get(0)) ^ true))
    {
      localObject2 = ((com.tencent.mm.vending.j.c)localObject1).get(0);
      if (!(localObject2 instanceof Integer)) {}
      while (-1 != ((Integer)localObject2).intValue())
      {
        paramccs = paramccs.sessionId;
        AppMethodBeat.o(122608);
        return paramccs;
      }
    }
    Object localObject2 = a.Cy(paramccs.Fre);
    localObject1 = (String)localObject2 + "_" + ((com.tencent.mm.vending.j.c)localObject1).get(1);
    paramccs.sessionId = ((String)localObject1);
    AppMethodBeat.o(122608);
    return localObject1;
  }
  
  public static final String h(ccs paramccs)
  {
    AppMethodBeat.i(122609);
    if (paramccs == null)
    {
      AppMethodBeat.o(122609);
      return null;
    }
    com.tencent.mm.vending.j.c localc = a.aaU(paramccs.sessionId);
    if (localc == null)
    {
      paramccs = paramccs.sessionId;
      AppMethodBeat.o(122609);
      return paramccs;
    }
    if ((k.g("999", localc.get(0)) ^ true))
    {
      paramccs = paramccs.sessionId;
      k.g(paramccs, "pageSession.sessionId");
      paramccs = a.aaS(paramccs);
      AppMethodBeat.o(122609);
      return paramccs;
    }
    ac.i("HABBYGE-MALI.HellKSessionConfig", "HellKSessionConfig, getRealChatSessionId: " + paramccs.Fre);
    paramccs = a.Cy(paramccs.Fre);
    AppMethodBeat.o(122609);
    return paramccs;
  }
  
  public static final String v(long paramLong, int paramInt)
  {
    AppMethodBeat.i(122617);
    String str = String.valueOf(paramLong) + "_" + paramInt;
    AppMethodBeat.o(122617);
    return str;
  }
  
  @l(fNY={1, 1, 16}, fNZ={""}, fOa={"Lcom/tencent/mm/plugin/expt/hellhound/ext/session/config/HellKSessionConfig$Companion;", "", "()V", "CHATTING_UI", "", "CHATTING_UI_FRAGMENT", "SESSION_ID_ADDRESS_ADD_FRIEND", "SESSION_ID_ADDRESS_SEARCH", "SESSION_ID_ADD_FRIEND", "SESSION_ID_APPBRAND", "SESSION_ID_AppBrandLauncherUI", "SESSION_ID_BIZ_LIST", "SESSION_ID_BIZ_MESSAGE", "SESSION_ID_BaseScanUI", "SESSION_ID_BottleBeachUI", "SESSION_ID_CHAT", "SESSION_ID_CHAT_PLUGIN_WECHAT_MOVEMENT", "SESSION_ID_CHAT_ROOM", "SESSION_ID_CHAT_SERVICE", "SESSION_ID_CHAT_SERVICE_NOTIFY", "SESSION_ID_CHAT_VIRTUAL", "SESSION_ID_CONTACT_BIZ", "SESSION_ID_CardHomePageUI", "SESSION_ID_ChatroomContactUI", "SESSION_ID_ContactInfoUI", "SESSION_ID_ContactLabelManagerUI", "SESSION_ID_ENTERPRISE", "SESSION_ID_EmojiStoreV2UI", "SESSION_ID_FINDER", "SESSION_ID_FIND_SEARCH", "SESSION_ID_FMessageConversationUI", "SESSION_ID_FTSSOSHomeWebViewUI", "SESSION_ID_FavoriteIndexUI", "SESSION_ID_FloatingWindow", "SESSION_ID_GAME", "SESSION_ID_GLOBAL_SEARCH", "SESSION_ID_HELP", "SESSION_ID_MINI_GAME", "SESSION_ID_MallIndexUI", "SESSION_ID_NearbyFriendsUI", "SESSION_ID_Nearby_Rest", "SESSION_ID_OpenIMAddressUI", "SESSION_ID_SEARCH_BaseScanUI", "SESSION_ID_SELECT_CONTACTUI", "SESSION_ID_SettingsPersonalInfoUI", "SESSION_ID_SettingsUI", "SESSION_ID_ShakeReportUI", "SESSION_ID_SnsTimeLineUI", "SESSION_ID_SnsUserUI", "SESSION_ID_StoryCaptureUI", "SESSION_ID_StoryGalleryView", "SESSION_ID_TENCENT_NEWS", "SESSION_ID_TopStoryHomeUI", "SESSION_ID_VOIP_FloatingWindow", "SESSION_ID_WalletOfflineEntranceUI", "SESSION_ID_WebViewUI_jd_store", "TAB_AddressUIFragment", "TAB_FindMoreFriendsUI", "TAB_MainUI", "TAB_MoreTabUI", "TAG", "mSessionIdEntryListLocal", "", "Lcom/tencent/mm/plugin/expt/hellhound/ext/session/dao/SessionKEntry;", "convertChatSid", "", "hellSession", "Lcom/tencent/mm/protocal/protobuf/HellSession;", "pageSession", "Lcom/tencent/mm/protocal/protobuf/PageSession;", "cutInvalidatePageKeyToName", "pageId", "cutSessonToSid", "session", "doNotNeedSessionMonitor", "", "generateSeq", "", "seqOfPage", "seqOfUBA", "getBizIdOfSessionParam", "timestamp", "", "seq", "getCurSession", "getCurSid", "getIdentifySidExpect", "curActivity", "Landroid/app/Activity;", "srcPage", "dstPage", "getLastSession", "getPageStartTimeOfBizId", "bizId", "(Ljava/lang/String;)Ljava/lang/Long;", "getRealChatSid", "chattingType", "getRealChatSidLocal", "getSessionPageOfConfig", "Lcom/tencent/mm/protocal/protobuf/SessionPagePath;", "sid", "isDetailReport", "getSidId", "args", "getSidLocal", "getTabIdOfLauncher", "tabPageName", "getTabSessionIdOfLauncher", "sessionId", "isAppBrandSession", "isBizSid", "isChatSessionId", "isChatSid", "isCurBizSid", "isEffectiveSession", "sessoinId", "isEffectiveSessionBySid", "isFloatSession", "isJdSid", "isVoipSession", "spliteSession", "Lcom/tencent/mm/vending/tuple/Tuple2;", "updateCurSid", "updateRealChatSessionId", "plugin-expt_release"})
  public static final class a
  {
    static String Cy(int paramInt)
    {
      AppMethodBeat.i(122595);
      k.g(c.ckB(), "HellSessionCloudConfig.getInstance()");
      Object localObject = c.ckC();
      if (localObject == null)
      {
        localObject = Cz(paramInt);
        AppMethodBeat.o(122595);
        return localObject;
      }
      if (((cvp)localObject).fxO)
      {
        ac.e("HABBYGE-MALI.HellKSessionConfig", "getRealChatSid, configCloud.isDel");
        AppMethodBeat.o(122595);
        return "-1";
      }
      localObject = ((cvp)localObject).FGr.iterator();
      while (((Iterator)localObject).hasNext())
      {
        cvo localcvo = (cvo)((Iterator)localObject).next();
        if (localcvo != null)
        {
          ac.i("HABBYGE-MALI.HellKSessionConfig", "getRealChatSid, chatConfig.expect=" + localcvo.FGp);
          if (bs.getInt(localcvo.FGp, -1) == paramInt)
          {
            localObject = localcvo.qon;
            k.g(localObject, "chatConfig.sid");
            AppMethodBeat.o(122595);
            return localObject;
          }
        }
      }
      localObject = Cz(paramInt);
      AppMethodBeat.o(122595);
      return localObject;
    }
    
    private static String Cz(int paramInt)
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
        ac.i("HABBYGE-MALI.HellKSessionConfig", "HellKSessionConfig, getRealChatSidLocal: ".concat(String.valueOf(str)));
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
      k.g(c.ckB(), "HellSessionCloudConfig.getInstance()");
      Object localObject1 = c.ckC();
      if (localObject1 == null)
      {
        AppMethodBeat.o(122591);
        return null;
      }
      cvt localcvt;
      do
      {
        String str;
        do
        {
          localObject1 = ((cvp)localObject1).FGt.iterator();
          Object localObject2;
          while (!((Iterator)localObject2).hasNext())
          {
            do
            {
              if (!((Iterator)localObject1).hasNext()) {
                break;
              }
              localcvt = (cvt)((Iterator)localObject1).next();
            } while ((localcvt == null) || (localcvt.FGw.isEmpty()) || ((k.g(localcvt.FGo, paramString1) ^ true)));
            localObject2 = localcvt.qoi;
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
        ac.i("HABBYGE-MALI.HellKSessionConfig", "getIdentifySidExpect, sid: " + localcvt.qon);
      } while (!a.a(paramActivity, localcvt));
      paramActivity = localcvt.qon;
      AppMethodBeat.o(122591);
      return paramActivity;
      AppMethodBeat.o(122591);
      return null;
    }
    
    public static String a(String paramString1, String paramString2, List<String> paramList)
    {
      AppMethodBeat.i(122592);
      paramString1 = com.tencent.mm.plugin.expt.hellhound.core.b.ZK(paramString1);
      String str1 = com.tencent.mm.plugin.expt.hellhound.core.b.ZK(paramString2);
      ac.i("HABBYGE-MALI.HellKSessionConfig", "getSessionIdLocal: " + paramString1 + ", " + str1);
      if (((k.g("ChattingUI", paramString2)) || (k.g("ChattingUIFragment", paramString2))) && ((k.g(com.tencent.mm.plugin.expt.hellhound.core.b.qiM, paramString1)) || (TextUtils.isEmpty((CharSequence)paramString1))))
      {
        ac.i("HABBYGE-MALI.HellKSessionConfig", "HellKSessionConfig, getSidId: 999");
        AppMethodBeat.o(122592);
        return "999";
      }
      if ((k.g("WebViewUI", str1)) && ((k.g("FindMoreFriendsUI", paramString1)) || (k.g("MainUI", paramString1)) || (k.g("AddressUIFragment", paramString1))))
      {
        paramString2 = com.tencent.mm.plugin.expt.hellhound.a.h.a.qqO;
        if (com.tencent.mm.plugin.expt.hellhound.a.h.a.cly())
        {
          AppMethodBeat.o(122592);
          return "148";
        }
      }
      if (k.g("BaseScanUI", str1))
      {
        paramString2 = com.tencent.mm.plugin.expt.hellhound.a.f.g.b.a.qqx;
        if (com.tencent.mm.plugin.expt.hellhound.a.f.g.b.a.clr())
        {
          AppMethodBeat.o(122592);
          return "124";
        }
        paramString2 = com.tencent.mm.plugin.expt.hellhound.a.h.a.qqO;
        if (com.tencent.mm.plugin.expt.hellhound.a.h.a.clx())
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
          paramString2 = b.ckw().iterator();
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
            } while (!k.g(paramString1, paramList.qqh));
            localObject = paramList.qqi.iterator();
          }
        } while (!k.g(str1, (String)((Iterator)localObject).next()));
        if (k.g(paramList.sessionId, "109"))
        {
          paramString1 = com.tencent.mm.plugin.expt.hellhound.a.h.a.qqO;
          if (com.tencent.mm.plugin.expt.hellhound.a.h.a.clx())
          {
            AppMethodBeat.o(122592);
            return "109";
          }
          AppMethodBeat.o(122592);
          return "124";
        }
        if ((k.g(paramList.sessionId, "105")) || (k.g(paramList.sessionId, "131")))
        {
          paramString1 = com.tencent.mm.plugin.expt.hellhound.a.f.g.b.a.qqx;
          if (com.tencent.mm.plugin.expt.hellhound.a.f.g.b.a.clq())
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
      paramString2 = b.ckw().iterator();
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
        if ((k.g(paramString1, ((i)localObject).qqh) ^ true)) {
          break label653;
        }
        Iterator localIterator = ((i)localObject).qqi.iterator();
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
    
    public static String aaS(String paramString)
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
    
    public static com.tencent.mm.vending.j.c<String, String> aaU(String paramString)
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
    
    public static boolean aaW(String paramString)
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
    
    public static Long abd(String paramString)
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
        ac.printErrStackTrace("HABBYGE-MALI.HellKSessionConfig", (Throwable)paramString, "getPageStartTimeOfBusinessId, crash: " + paramString.getMessage(), new Object[0]);
        AppMethodBeat.o(122598);
      }
      return null;
    }
    
    public static String abe(String paramString)
    {
      AppMethodBeat.i(195593);
      if (paramString == null)
      {
        AppMethodBeat.o(195593);
        return null;
      }
      if (n.a((CharSequence)paramString, (CharSequence)".", false))
      {
        if (k.g(paramString, com.tencent.mm.plugin.expt.hellhound.core.b.qiH))
        {
          AppMethodBeat.o(195593);
          return "0";
        }
        if (k.g(paramString, com.tencent.mm.plugin.expt.hellhound.core.b.qiI))
        {
          AppMethodBeat.o(195593);
          return "1";
        }
        if (k.g(paramString, com.tencent.mm.plugin.expt.hellhound.core.b.qiJ))
        {
          AppMethodBeat.o(195593);
          return "2";
        }
        if (k.g(paramString, com.tencent.mm.plugin.expt.hellhound.core.b.qiK))
        {
          AppMethodBeat.o(195593);
          return "3";
        }
        AppMethodBeat.o(195593);
        return paramString;
      }
      if (k.g(paramString, com.tencent.mm.plugin.expt.hellhound.core.b.qiM))
      {
        AppMethodBeat.o(195593);
        return "0";
      }
      if (k.g(paramString, com.tencent.mm.plugin.expt.hellhound.core.b.qiN))
      {
        AppMethodBeat.o(195593);
        return "1";
      }
      if (k.g(paramString, com.tencent.mm.plugin.expt.hellhound.core.b.qiO))
      {
        AppMethodBeat.o(195593);
        return "2";
      }
      if (k.g(paramString, com.tencent.mm.plugin.expt.hellhound.core.b.qiP))
      {
        AppMethodBeat.o(195593);
        return "3";
      }
      AppMethodBeat.o(195593);
      return paramString;
    }
    
    static boolean abh(String paramString)
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
    
    public static String ckA()
    {
      AppMethodBeat.i(122600);
      Object localObject = com.tencent.mm.plugin.expt.hellhound.a.f.c.c.ckP();
      if (localObject == null)
      {
        AppMethodBeat.o(122600);
        return null;
      }
      localObject = ((ccs)localObject).sessionId;
      AppMethodBeat.o(122600);
      return localObject;
    }
    
    public static boolean ckx()
    {
      AppMethodBeat.i(122599);
      if (!com.tencent.mm.plugin.expt.hellhound.a.ciw())
      {
        ac.i("HABBYGE-MALI.HellKSessionConfig", "HellSessionMonitor monitor, fetchHellhoundConfig: FALSE");
        AppMethodBeat.o(122599);
        return true;
      }
      k.g(c.ckB(), "HellSessionCloudConfig.getInstance()");
      if ((c.ckD()) || (com.tencent.mm.plugin.expt.hellhound.core.b.getUin() == 0))
      {
        ac.i("HABBYGE-MALI.HellKSessionConfig", "HellSessionMonitor monitor FALSE");
        AppMethodBeat.o(122599);
        return true;
      }
      if (!com.tencent.mm.plugin.expt.hellhound.a.ciy())
      {
        ac.i("HABBYGE-MALI.HellKSessionConfig", "HellSessionMonitor monitor, close !!!");
        AppMethodBeat.o(122599);
        return true;
      }
      AppMethodBeat.o(122599);
      return false;
    }
    
    public static String ckz()
    {
      AppMethodBeat.i(122601);
      String str = ckA();
      if (str == null)
      {
        AppMethodBeat.o(122601);
        return null;
      }
      str = aaS(str);
      AppMethodBeat.o(122601);
      return str;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.expt.hellhound.a.f.b.b
 * JD-Core Version:    0.7.0.1
 */