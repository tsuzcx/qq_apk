package com.tencent.mm.plugin.expt.hellhound.ext.session.config;

import android.app.Activity;
import android.text.TextUtils;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.expt.hellhound.ext.session.b.i;
import com.tencent.mm.protocal.protobuf.czw;
import com.tencent.mm.protocal.protobuf.eah;
import com.tencent.mm.protocal.protobuf.eyt;
import com.tencent.mm.protocal.protobuf.eyu;
import com.tencent.mm.protocal.protobuf.eyv;
import com.tencent.mm.protocal.protobuf.eyw;
import com.tencent.mm.protocal.protobuf.eyy;
import com.tencent.mm.protocal.protobuf.ezc;
import com.tencent.mm.protocal.protobuf.ezf;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import kotlin.Metadata;
import kotlin.a.p;
import kotlin.g.b.s;
import kotlin.n.n;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/expt/hellhound/ext/session/config/HellKSessionConfig;", "", "()V", "Companion", "plugin-expt_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class b
{
  private static final List<i> zKA;
  public static final a zKz;
  
  static
  {
    AppMethodBeat.i(122602);
    zKz = new a((byte)0);
    zKA = p.listOf(new i[] { new i("999", com.tencent.mm.plugin.expt.hellhound.core.b.zAW, (List)p.al(new String[] { "ChattingUIFragment", "ChattingUI" })), new i("998", com.tencent.mm.plugin.expt.hellhound.core.b.zAW, (List)p.al(new String[] { "BizConversationUI" })), new i("104", com.tencent.mm.plugin.expt.hellhound.core.b.zAW, (List)p.al(new String[] { "BizTimeLineUI" })), new i("105", com.tencent.mm.plugin.expt.hellhound.core.b.zAW, (List)p.al(new String[] { "AppBrandLaunchProxyUI", "AppBrandUI", "AppBrandUI1", "AppBrandUI2", "AppBrandUI3", "AppBrandUI4" })), new i("105", com.tencent.mm.plugin.expt.hellhound.core.b.zAW, (List)p.al(new String[] { "AppBrandUI", "AppBrandUI1", "AppBrandUI2", "AppBrandUI3", "AppBrandUI4" })), new i("105", "LauncherUI", (List)p.al(new String[] { "AppBrandLaunchProxyUI", "AppBrandUI", "AppBrandUI1", "AppBrandUI2", "AppBrandUI3", "AppBrandUI4" })), new i("105", "LauncherUI", (List)p.al(new String[] { "AppBrandUI", "AppBrandUI1", "AppBrandUI2", "AppBrandUI3", "AppBrandUI4" })), new i("105", com.tencent.mm.plugin.expt.hellhound.core.b.zAW, (List)p.al(new String[] { "AppBrandLauncherUI" })), new i("105", "LauncherUI", (List)p.al(new String[] { "AppBrandLauncherUI" })), new i("105", "WXShortcutEntryActivity", (List)p.al(new String[] { "AppBrandLaunchProxyUI", "AppBrandUI", "AppBrandUI1", "AppBrandUI2", "AppBrandUI3", "AppBrandUI4" })), new i("105", com.tencent.mm.plugin.expt.hellhound.core.b.zAX, (List)p.al(new String[] { "AppBrandLaunchProxyUI", "AppBrandUI", "AppBrandUI1", "AppBrandUI2", "AppBrandUI3", "AppBrandUI4" })), new i("105", com.tencent.mm.plugin.expt.hellhound.core.b.zAY, (List)p.al(new String[] { "AppBrandLaunchProxyUI", "AppBrandUI", "AppBrandUI1", "AppBrandUI2", "AppBrandUI3", "AppBrandUI4" })), new i("105", com.tencent.mm.plugin.expt.hellhound.core.b.zAZ, (List)p.al(new String[] { "AppBrandLaunchProxyUI", "AppBrandUI", "AppBrandUI1", "AppBrandUI2", "AppBrandUI3", "AppBrandUI4" })), new i("105", com.tencent.mm.plugin.expt.hellhound.core.b.zBa, (List)p.al(new String[] { "AppBrandLaunchProxyUI", "AppBrandUI", "AppBrandUI1", "AppBrandUI2", "AppBrandUI3", "AppBrandUI4" })), new i("113", com.tencent.mm.plugin.expt.hellhound.core.b.zAW, (List)p.al(new String[] { "ReaderAppUI" })), new i("114", com.tencent.mm.plugin.expt.hellhound.core.b.zAX, (List)p.al(new String[] { "FTSMainUI" })), new i("114", com.tencent.mm.plugin.expt.hellhound.core.b.zAY, (List)p.al(new String[] { "FTSMainUI" })), new i("147", com.tencent.mm.plugin.expt.hellhound.core.b.zAZ, (List)p.al(new String[] { "FTSMainUI" })), new i("115", com.tencent.mm.plugin.expt.hellhound.core.b.zAX, (List)p.al(new String[] { "AddMoreFriendsUI" })), new i("115", com.tencent.mm.plugin.expt.hellhound.core.b.zAY, (List)p.al(new String[] { "AddMoreFriendsUI" })), new i("116", com.tencent.mm.plugin.expt.hellhound.core.b.zAX, (List)p.al(new String[] { "FMessageConversationUI" })), new i("116", com.tencent.mm.plugin.expt.hellhound.core.b.zAY, (List)p.al(new String[] { "FMessageConversationUI" })), new i("117", com.tencent.mm.plugin.expt.hellhound.core.b.zAX, (List)p.al(new String[] { "ChatroomContactUI" })), new i("117", com.tencent.mm.plugin.expt.hellhound.core.b.zAY, (List)p.al(new String[] { "ChatroomContactUI" })), new i("118", com.tencent.mm.plugin.expt.hellhound.core.b.zAX, (List)p.al(new String[] { "ContactLabelManagerUI" })), new i("118", com.tencent.mm.plugin.expt.hellhound.core.b.zAY, (List)p.al(new String[] { "ContactLabelManagerUI" })), new i("106", com.tencent.mm.plugin.expt.hellhound.core.b.zAW, (List)p.al(new String[] { "FTSMainUI" })), new i("107", com.tencent.mm.plugin.expt.hellhound.core.b.zAW, (List)p.al(new String[] { "SelectContactUI" })), new i("107", com.tencent.mm.plugin.expt.hellhound.core.b.zAX, (List)p.al(new String[] { "SelectContactUI" })), new i("107", com.tencent.mm.plugin.expt.hellhound.core.b.zAY, (List)p.al(new String[] { "SelectContactUI" })), new i("107", com.tencent.mm.plugin.expt.hellhound.core.b.zAZ, (List)p.al(new String[] { "SelectContactUI" })), new i("108", com.tencent.mm.plugin.expt.hellhound.core.b.zAW, (List)p.al(new String[] { "AddMoreFriendsUI" })), new i("108", com.tencent.mm.plugin.expt.hellhound.core.b.zAX, (List)p.al(new String[] { "AddMoreFriendsUI" })), new i("108", com.tencent.mm.plugin.expt.hellhound.core.b.zAY, (List)p.al(new String[] { "AddMoreFriendsUI" })), new i("108", com.tencent.mm.plugin.expt.hellhound.core.b.zAZ, (List)p.al(new String[] { "AddMoreFriendsUI" })), new i("109", com.tencent.mm.plugin.expt.hellhound.core.b.zAW, (List)p.al(new String[] { "BaseScanUI" })), new i("109", com.tencent.mm.plugin.expt.hellhound.core.b.zAX, (List)p.al(new String[] { "BaseScanUI" })), new i("109", com.tencent.mm.plugin.expt.hellhound.core.b.zAY, (List)p.al(new String[] { "BaseScanUI" })), new i("109", com.tencent.mm.plugin.expt.hellhound.core.b.zAZ, (List)p.al(new String[] { "BaseScanUI" })), new i("110", com.tencent.mm.plugin.expt.hellhound.core.b.zAW, (List)p.al(new String[] { "WalletOfflineEntranceUI" })), new i("110", com.tencent.mm.plugin.expt.hellhound.core.b.zAX, (List)p.al(new String[] { "WalletOfflineEntranceUI" })), new i("110", com.tencent.mm.plugin.expt.hellhound.core.b.zAY, (List)p.al(new String[] { "WalletOfflineEntranceUI" })), new i("110", com.tencent.mm.plugin.expt.hellhound.core.b.zAZ, (List)p.al(new String[] { "WalletOfflineEntranceUI" })), new i("119", com.tencent.mm.plugin.expt.hellhound.core.b.zAX, (List)p.al(new String[] { "BrandServiceIndexUI" })), new i("119", com.tencent.mm.plugin.expt.hellhound.core.b.zAY, (List)p.al(new String[] { "BrandServiceIndexUI" })), new i("120", com.tencent.mm.plugin.expt.hellhound.core.b.zAX, (List)p.al(new String[] { "EnterpriseBizContactListUI" })), new i("120", com.tencent.mm.plugin.expt.hellhound.core.b.zAY, (List)p.al(new String[] { "EnterpriseBizContactListUI" })), new i("121", com.tencent.mm.plugin.expt.hellhound.core.b.zAX, (List)p.al(new String[] { "OpenIMAddressUI" })), new i("121", com.tencent.mm.plugin.expt.hellhound.core.b.zAY, (List)p.al(new String[] { "OpenIMAddressUI" })), new i("122", com.tencent.mm.plugin.expt.hellhound.core.b.zAX, (List)p.al(new String[] { "ContactInfoUI" })), new i("122", com.tencent.mm.plugin.expt.hellhound.core.b.zAY, (List)p.al(new String[] { "ContactInfoUI" })), new i("123", com.tencent.mm.plugin.expt.hellhound.core.b.zAZ, (List)p.al(new String[] { "SnsTimeLineUI" })), new i("124", com.tencent.mm.plugin.expt.hellhound.core.b.zAZ, (List)p.al(new String[] { "BaseScanUI" })), new i("125", com.tencent.mm.plugin.expt.hellhound.core.b.zAZ, (List)p.al(new String[] { "ShakeReportUI" })), new i("126", com.tencent.mm.plugin.expt.hellhound.core.b.zAZ, (List)p.al(new String[] { "TopStoryHomeUI" })), new i("127", com.tencent.mm.plugin.expt.hellhound.core.b.zAZ, (List)p.al(new String[] { "FTSSOSHomeWebViewUI" })), new i("128", com.tencent.mm.plugin.expt.hellhound.core.b.zAZ, (List)p.al(new String[] { "NearbyFriendsIntroUI", "NearbyFriendsUI", "NearbyPersonalInfoUI", "NearbyFriendShowSayHiUI" })), new i("129", com.tencent.mm.plugin.expt.hellhound.core.b.zAZ, (List)p.al(new String[] { "BottleBeachUI" })), new i("130", com.tencent.mm.plugin.expt.hellhound.core.b.zAZ, (List)p.al(new String[] { "AppBrandPluginUI" })), new i("131", com.tencent.mm.plugin.expt.hellhound.core.b.zAZ, (List)p.al(new String[] { "WebViewUI", "1", "jd_store" })), new i("131", com.tencent.mm.plugin.expt.hellhound.core.b.zAZ, (List)p.al(new String[] { "AppBrandLaunchProxyUI", "AppBrandUI", "AppBrandUI1", "AppBrandUI2", "AppBrandUI3", "AppBrandUI4" })), new i("132", com.tencent.mm.plugin.expt.hellhound.core.b.zAZ, (List)p.al(new String[] { "GameWebViewUI" })), new i("132", com.tencent.mm.plugin.expt.hellhound.core.b.zAZ, (List)p.al(new String[] { "GameCenterUI" })), new i("132", com.tencent.mm.plugin.expt.hellhound.core.b.zAZ, (List)p.al(new String[] { "LuggageGameWebViewUI" })), new i("132", com.tencent.mm.plugin.expt.hellhound.core.b.zAZ, (List)p.al(new String[] { "GameWebViewMpUI" })), new i("132", com.tencent.mm.plugin.expt.hellhound.core.b.zAZ, (List)p.al(new String[] { "LuggageGameWebViewMpUI" })), new i("133", com.tencent.mm.plugin.expt.hellhound.core.b.zAZ, (List)p.al(new String[] { "AppBrandLauncherUI" })), new i("134", com.tencent.mm.plugin.expt.hellhound.core.b.zBa, (List)p.al(new String[] { "SettingsPersonalInfoUI" })), new i("135", com.tencent.mm.plugin.expt.hellhound.core.b.zBa, (List)p.al(new String[] { "MallIndexUI", "MallIndexUIv2" })), new i("136", com.tencent.mm.plugin.expt.hellhound.core.b.zBa, (List)p.al(new String[] { "FavoriteIndexUI" })), new i("137", com.tencent.mm.plugin.expt.hellhound.core.b.zBa, (List)p.al(new String[] { "SnsUserUI", "AlbumUI" })), new i("138", com.tencent.mm.plugin.expt.hellhound.core.b.zBa, (List)p.al(new String[] { "CardHomePageNewUI", "CardHomePageUI", "CardIndexUI", "CardInvalidCardUI", "CardViewUI", "ShareCardListUI", "CardHomePageV3UI" })), new i("139", "MoreTabUI", (List)p.al(new String[] { "EmojiStoreV2UI", "MMFlutterActivity" })), new i("140", "MoreTabUI", (List)p.al(new String[] { "SettingsUI" })), new i("141", "MoreTabUI", (List)p.al(new String[] { "StoryCaptureUI", "MMRecordUI" })), new i("142", "MoreTabUI", (List)p.al(new String[] { "StoryGalleryView", "StoryVideoView" })), new i("143", "FindMoreFriendsUI", (List)p.al(new String[] { "FinderTimelineUI" })), new i("143", "FindMoreFriendsUI", (List)p.al(new String[] { "FinderHomeUI" })), new i("143", "FindMoreFriendsUI", (List)p.al(new String[] { "FinderHomeAffinityUI" })), new i("143", "FindMoreFriendsUI", (List)p.al(new String[] { "FinderConversationUI" })), new i("143", com.tencent.mm.plugin.expt.hellhound.core.b.zAX, (List)p.al(new String[] { "FinderTimelineUI" })), new i("143", com.tencent.mm.plugin.expt.hellhound.core.b.zAY, (List)p.al(new String[] { "FinderTimelineUI" })), new i("143", "FinderHomeUI", (List)p.al(new String[] { "FinderSelfUI" })), new i("996", "FindMoreFriendsUI", (List)p.al(new String[] { "FinderMultiTaskRouterUI" })), new i("996", "ChattingUIFragment", (List)p.al(new String[] { "FinderMultiTaskRouterUI" })), new i("996", "SnsTimeLineUI", (List)p.al(new String[] { "FinderMultiTaskRouterUI" })), new i("145", "LauncherUI", (List)p.al(new String[] { "FloatingBall" })), new i("146", "LauncherUI", (List)p.al(new String[] { "VideoActivity" })), new i("149", com.tencent.mm.plugin.expt.hellhound.core.b.zAX, (List)p.al(new String[] { "OnlyChatContactMgrUI" })), new i("149", com.tencent.mm.plugin.expt.hellhound.core.b.zAY, (List)p.al(new String[] { "OnlyChatContactMgrUI" })), new i("150", com.tencent.mm.plugin.expt.hellhound.core.b.zAZ, (List)p.al(new String[] { "NearbyHomeUI", "OccupyFinderUI11", "NearbyUI" })), new i("151", com.tencent.mm.plugin.expt.hellhound.core.b.zBa, (List)p.al(new String[] { "FinderProfileUI" })), new i("152", com.tencent.mm.plugin.expt.hellhound.core.b.zAZ, (List)p.al(new String[] { "FinderLiveFindPageUI" })) });
    AppMethodBeat.o(122602);
  }
  
  public static final String E(long paramLong, int paramInt)
  {
    AppMethodBeat.i(122617);
    String str = paramLong + '_' + paramInt;
    AppMethodBeat.o(122617);
    return str;
  }
  
  public static final String a(Activity paramActivity, String paramString1, String paramString2, List<String> paramList)
  {
    AppMethodBeat.i(122603);
    paramString1 = com.tencent.mm.plugin.expt.hellhound.core.b.aqH(paramString1);
    Log.i("HABBYGE-MALI.HellKSessionConfig", "getSidId: " + paramString1 + ", " + paramString2);
    c.dLJ();
    Object localObject1 = c.dLK();
    if (localObject1 == null)
    {
      paramActivity = a.d(paramString1, paramString2, paramList);
      if ((paramActivity == null) && (s.p("FinderHomeAffinityUI", paramString2)))
      {
        AppMethodBeat.o(122603);
        return "155";
      }
      AppMethodBeat.o(122603);
      return paramActivity;
    }
    if (((eyu)localObject1).lKI)
    {
      Log.e("HABBYGE-MALI.HellKSessionConfig", "getSidId, sessionCloud.isDel ture");
      AppMethodBeat.o(122603);
      return null;
    }
    if (((s.p("ChattingUI", paramString2)) || (s.p("ChattingUIFragment", paramString2))) && ((s.p(com.tencent.mm.plugin.expt.hellhound.core.b.zAW, paramString1)) || (TextUtils.isEmpty((CharSequence)paramString1))))
    {
      Log.i("HABBYGE-MALI.HellKSessionConfig", "getSidId: 999");
      AppMethodBeat.o(122603);
      return "999";
    }
    if (s.p("WebViewUI", paramString2)) {
      if (s.p("FindMoreFriendsUI", paramString1))
      {
        if (((eyu)localObject1).abzZ != null)
        {
          if ((paramList != null) && (paramList.size() >= 2) && (s.p(((eyu)localObject1).abzZ.abAb, paramList.get(0))) && (s.p(((eyu)localObject1).abzZ.abAc, paramList.get(1))))
          {
            Log.i("HABBYGE-MALI.HellKSessionConfig", "getSidId, SESSION_ID_WebViewUI_jd_store");
            AppMethodBeat.o(122603);
            return "131";
          }
        }
        else
        {
          localObject2 = com.tencent.mm.plugin.expt.hellhound.ext.g.a.zLC;
          if (com.tencent.mm.plugin.expt.hellhound.ext.g.a.dMH())
          {
            paramActivity = com.tencent.mm.plugin.expt.hellhound.ext.g.a.zLC;
            com.tencent.mm.plugin.expt.hellhound.ext.g.a.pc(false);
            AppMethodBeat.o(122603);
            return "148";
          }
        }
      }
      else if ((s.p("MainUI", paramString1)) || (s.p(com.tencent.mm.plugin.expt.hellhound.core.b.zAX, paramString1)) || (s.p(com.tencent.mm.plugin.expt.hellhound.core.b.zAY, paramString1)))
      {
        localObject2 = com.tencent.mm.plugin.expt.hellhound.ext.g.a.zLC;
        if (com.tencent.mm.plugin.expt.hellhound.ext.g.a.dMH())
        {
          paramActivity = com.tencent.mm.plugin.expt.hellhound.ext.g.a.zLC;
          com.tencent.mm.plugin.expt.hellhound.ext.g.a.pc(false);
          AppMethodBeat.o(122603);
          return "148";
        }
      }
    }
    if (s.p("BaseScanUI", paramString2))
    {
      localObject2 = com.tencent.mm.plugin.expt.hellhound.ext.session.f.b.a.zLc;
      if (com.tencent.mm.plugin.expt.hellhound.ext.session.f.b.a.dMz())
      {
        paramActivity = com.tencent.mm.plugin.expt.hellhound.ext.session.f.b.a.zLc;
        com.tencent.mm.plugin.expt.hellhound.ext.session.f.b.a.oZ(false);
        AppMethodBeat.o(122603);
        return "124";
      }
      localObject2 = com.tencent.mm.plugin.expt.hellhound.ext.g.a.zLC;
      if (com.tencent.mm.plugin.expt.hellhound.ext.g.a.dMG())
      {
        paramActivity = com.tencent.mm.plugin.expt.hellhound.ext.g.a.zLC;
        com.tencent.mm.plugin.expt.hellhound.ext.g.a.pb(false);
        AppMethodBeat.o(122603);
        return "109";
      }
    }
    Object localObject2 = com.tencent.mm.plugin.expt.hellhound.ext.session.f.b.a.zLc;
    com.tencent.mm.plugin.expt.hellhound.ext.session.f.b.a.dMz();
    if ((paramList == null) || (paramList.isEmpty()))
    {
      localObject1 = ((eyu)localObject1).obH.iterator();
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
            localObject2 = (eyw)((Iterator)localObject1).next();
          } while ((localObject2 == null) || (!s.p(((eyw)localObject2).abzW, paramString1)));
          localObject3 = ((eyw)localObject2).hJW;
          s.s(localObject3, "config.pageName");
          localObject3 = n.b((CharSequence)localObject3, new String[] { "," }).iterator();
        }
        str = (String)((Iterator)localObject3).next();
        if (str == null)
        {
          paramActivity = new NullPointerException("null cannot be cast to non-null type kotlin.CharSequence");
          AppMethodBeat.o(122603);
          throw paramActivity;
        }
      } while (!s.p(n.bq((CharSequence)str).toString(), paramString2));
      if (s.p(((eyw)localObject2).zIC, "109"))
      {
        paramActivity = com.tencent.mm.plugin.expt.hellhound.ext.g.a.zLC;
        if (com.tencent.mm.plugin.expt.hellhound.ext.g.a.dMG())
        {
          paramActivity = com.tencent.mm.plugin.expt.hellhound.ext.g.a.zLC;
          com.tencent.mm.plugin.expt.hellhound.ext.g.a.pb(false);
          AppMethodBeat.o(122603);
          return "109";
        }
        AppMethodBeat.o(122603);
        return "124";
      }
      if ((s.p(((eyw)localObject2).zIC, "105")) || (s.p(((eyw)localObject2).zIC, "131")))
      {
        paramActivity = com.tencent.mm.plugin.expt.hellhound.ext.session.f.b.a.zLc;
        if (com.tencent.mm.plugin.expt.hellhound.ext.session.f.b.a.dMy())
        {
          paramActivity = com.tencent.mm.plugin.expt.hellhound.ext.session.f.b.a.zLc;
          com.tencent.mm.plugin.expt.hellhound.ext.session.f.b.a.oY(false);
          AppMethodBeat.o(122603);
          return "131";
        }
        AppMethodBeat.o(122603);
        return "105";
      }
      paramActivity = ((eyw)localObject2).zIC;
      AppMethodBeat.o(122603);
      return paramActivity;
      paramActivity = a.a(paramActivity, paramString1, paramString2);
      if (paramActivity != null)
      {
        AppMethodBeat.o(122603);
        return paramActivity;
      }
    }
    if (s.p("FinderHomeAffinityUI", paramString2))
    {
      AppMethodBeat.o(122603);
      return "155";
    }
    Log.i("HABBYGE-MALI.HellKSessionConfig", "get sid by cloud config, but NULL, dignose sid By local config !!!");
    paramActivity = a.d(paramString1, paramString2, paramList);
    AppMethodBeat.o(122603);
    return paramActivity;
  }
  
  public static final void a(czw paramczw)
  {
    AppMethodBeat.i(122606);
    if (paramczw != null)
    {
      paramczw = paramczw.aaFn;
      s.s(paramczw, "hellSession.sessions");
      Object localObject1 = (Iterable)paramczw;
      paramczw = (Collection)new ArrayList();
      localObject1 = ((Iterable)localObject1).iterator();
      Object localObject2;
      Object localObject3;
      label159:
      while (((Iterator)localObject1).hasNext())
      {
        localObject2 = ((Iterator)localObject1).next();
        localObject3 = (eah)localObject2;
        String str = ((eah)localObject3).sessionId;
        s.s(str, "it.sessionId");
        if ((s.p(a.ass(str), "999")) && ((((eah)localObject3).abft == 0) || (((eah)localObject3).abft == 1) || (((eah)localObject3).abft == 2) || (((eah)localObject3).abft == 4) || (((eah)localObject3).abft == 5))) {}
        for (int i = 1;; i = 0)
        {
          if (i == 0) {
            break label159;
          }
          paramczw.add(localObject2);
          break;
        }
      }
      localObject1 = p.p((Iterable)paramczw);
      if (localObject1 != null)
      {
        Log.i("HABBYGE-MALI.HellKSessionConfig", s.X("after, sessionList.size: ", Integer.valueOf(((List)localObject1).size())));
        paramczw = null;
        localObject1 = ((List)localObject1).iterator();
        while (((Iterator)localObject1).hasNext())
        {
          localObject2 = (eah)((Iterator)localObject1).next();
          localObject3 = a.asu(((eah)localObject2).sessionId);
          if (localObject3 != null) {
            paramczw = s.X("_", ((com.tencent.mm.vending.j.c)localObject3).get(1));
          }
          Log.i("HABBYGE-MALI.HellKSessionConfig", "handleChatting, session, Start: " + ((eah)localObject2).sessionId + ", " + paramczw);
          ((eah)localObject2).sessionId = a.LU(((eah)localObject2).abft);
          if (!s.p(((eah)localObject2).sessionId, "-1")) {
            ((eah)localObject2).sessionId = s.X(((eah)localObject2).sessionId, paramczw);
          }
          Log.i("HABBYGE-MALI.HellKSessionConfig", s.X("handleChatting, session, End: ", ((eah)localObject2).sessionId));
        }
      }
    }
    AppMethodBeat.o(122606);
  }
  
  public static final boolean asA(String paramString)
  {
    AppMethodBeat.i(122615);
    s.u(paramString, "sid");
    boolean bool = s.p("131", paramString);
    AppMethodBeat.o(122615);
    return bool;
  }
  
  public static final List<ezf> asB(String paramString)
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
    d.dLN();
    Object localObject = d.dLO();
    if (localObject == null)
    {
      AppMethodBeat.o(122616);
      return null;
    }
    ArrayList localArrayList = new ArrayList();
    Iterator localIterator = ((ezc)localObject).abAh.iterator();
    while (localIterator.hasNext())
    {
      ezf localezf = (ezf)localIterator.next();
      if ((localezf != null) && (localezf.type == 0) && ((s.p(localezf.zIC, paramString)) || (s.p(localezf.zIC, "-1"))))
      {
        localObject = localezf;
        if (!localezf.lAr) {
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
  
  public static final Long asC(String paramString)
  {
    AppMethodBeat.i(122618);
    paramString = a.asC(paramString);
    AppMethodBeat.o(122618);
    return paramString;
  }
  
  public static final String asD(String paramString)
  {
    AppMethodBeat.i(185599);
    paramString = a.asD(paramString);
    AppMethodBeat.o(185599);
    return paramString;
  }
  
  public static final String asE(String paramString)
  {
    AppMethodBeat.i(300315);
    if (paramString == null)
    {
      AppMethodBeat.o(300315);
      return null;
    }
    if (n.a((CharSequence)paramString, (CharSequence)"_", false))
    {
      paramString = n.a((CharSequence)paramString, new String[] { "_" });
      paramString = a.asD((String)paramString.get(0)) + '_' + (String)paramString.get(1);
      AppMethodBeat.o(300315);
      return paramString;
    }
    AppMethodBeat.o(300315);
    return paramString;
  }
  
  public static final boolean asF(String paramString)
  {
    AppMethodBeat.i(185600);
    if (paramString == null)
    {
      AppMethodBeat.o(185600);
      return false;
    }
    if (n.a((CharSequence)paramString, (CharSequence)"_", false))
    {
      bool = a.asG((String)n.a((CharSequence)paramString, new String[] { "_" }).get(0));
      AppMethodBeat.o(185600);
      return bool;
    }
    boolean bool = a.asG(paramString);
    AppMethodBeat.o(185600);
    return bool;
  }
  
  public static final String ass(String paramString)
  {
    AppMethodBeat.i(122604);
    paramString = a.ass(paramString);
    AppMethodBeat.o(122604);
    return paramString;
  }
  
  public static final String ast(String paramString)
  {
    AppMethodBeat.i(122605);
    s.u(paramString, "pageId");
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
  
  public static final com.tencent.mm.vending.j.c<String, String> asu(String paramString)
  {
    AppMethodBeat.i(177417);
    paramString = a.asu(paramString);
    AppMethodBeat.o(177417);
    return paramString;
  }
  
  public static final void asv(String paramString)
  {
    AppMethodBeat.i(177418);
    if (paramString != null)
    {
      eah localeah = com.tencent.mm.plugin.expt.hellhound.ext.session.b.c.dLX();
      if (localeah != null)
      {
        com.tencent.mm.vending.j.c localc = a.asu(localeah.sessionId);
        if ((localc != null) && (!a.asy(localeah.sessionId)))
        {
          Log.i("HABBYGE-MALI.HellKSessionConfig", s.X("HellK, updateCurSid, old: ", localeah.sessionId));
          paramString = paramString + '_' + localc.get(1);
          localeah.sessionId = paramString;
          com.tencent.mm.plugin.expt.hellhound.ext.session.b.c.k(localeah);
          Log.i("HABBYGE-MALI.HellKSessionConfig", s.X("HellK, updateCurSid, new: ", paramString));
        }
      }
    }
    AppMethodBeat.o(177418);
  }
  
  public static final boolean asw(String paramString)
  {
    AppMethodBeat.i(122610);
    boolean bool = a.asw(paramString);
    AppMethodBeat.o(122610);
    return bool;
  }
  
  public static final boolean asx(String paramString)
  {
    AppMethodBeat.i(122611);
    if (paramString == null)
    {
      AppMethodBeat.o(122611);
      return false;
    }
    boolean bool = s.p("105", a.ass(paramString));
    AppMethodBeat.o(122611);
    return bool;
  }
  
  public static final boolean asy(String paramString)
  {
    AppMethodBeat.i(122612);
    boolean bool = a.asy(paramString);
    AppMethodBeat.o(122612);
    return bool;
  }
  
  public static final boolean asz(String paramString)
  {
    AppMethodBeat.i(122614);
    if (paramString != null)
    {
      paramString = a.ass(paramString);
      if ((s.p("999", paramString)) || (a.asw(paramString)))
      {
        AppMethodBeat.o(122614);
        return true;
      }
    }
    AppMethodBeat.o(122614);
    return false;
  }
  
  public static final boolean dLF()
  {
    AppMethodBeat.i(122619);
    boolean bool = a.dLF();
    AppMethodBeat.o(122619);
    return bool;
  }
  
  public static final boolean dLG()
  {
    AppMethodBeat.i(122620);
    String str = a.dLz();
    if (!TextUtils.isEmpty((CharSequence)str))
    {
      if (str != null)
      {
        str = a.ass(str);
        if ((!s.p("104", str)) && (!s.p("998", str))) {}
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
  
  public static final String dLz()
  {
    AppMethodBeat.i(122621);
    String str = a.dLz();
    AppMethodBeat.o(122621);
    return str;
  }
  
  public static final void g(eah parameah)
  {
    AppMethodBeat.i(122607);
    if (parameah != null)
    {
      com.tencent.mm.vending.j.c localc = a.asu(parameah.sessionId);
      if ((localc != null) && (s.p("999", localc.get(0))))
      {
        String str = a.LU(parameah.abft);
        parameah.sessionId = (str + '_' + localc.get(1));
      }
    }
    AppMethodBeat.o(122607);
  }
  
  public static final String h(eah parameah)
  {
    AppMethodBeat.i(122608);
    if (parameah == null)
    {
      AppMethodBeat.o(122608);
      return null;
    }
    Object localObject1 = a.asu(parameah.sessionId);
    if (localObject1 == null)
    {
      parameah = parameah.sessionId;
      AppMethodBeat.o(122608);
      return parameah;
    }
    if (!s.p("999", ((com.tencent.mm.vending.j.c)localObject1).get(0)))
    {
      localObject2 = ((com.tencent.mm.vending.j.c)localObject1).get(0);
      if (!(localObject2 instanceof Integer)) {}
      while (-1 != ((Number)localObject2).intValue())
      {
        parameah = parameah.sessionId;
        AppMethodBeat.o(122608);
        return parameah;
      }
    }
    Object localObject2 = a.LU(parameah.abft);
    localObject1 = (String)localObject2 + '_' + ((com.tencent.mm.vending.j.c)localObject1).get(1);
    parameah.sessionId = ((String)localObject1);
    AppMethodBeat.o(122608);
    return localObject1;
  }
  
  public static final int hc(int paramInt1, int paramInt2)
  {
    if (paramInt1 >= paramInt2) {
      return paramInt1 + 1;
    }
    return paramInt2 + 1;
  }
  
  public static final String hr(String paramString1, String paramString2)
  {
    AppMethodBeat.i(177416);
    paramString1 = a.d(paramString1, paramString2, null);
    AppMethodBeat.o(177416);
    return paramString1;
  }
  
  public static final String i(eah parameah)
  {
    AppMethodBeat.i(122609);
    if (parameah == null)
    {
      AppMethodBeat.o(122609);
      return null;
    }
    com.tencent.mm.vending.j.c localc = a.asu(parameah.sessionId);
    if (localc == null)
    {
      parameah = parameah.sessionId;
      AppMethodBeat.o(122609);
      return parameah;
    }
    if (!s.p("999", localc.get(0)))
    {
      parameah = parameah.sessionId;
      s.s(parameah, "pageSession.sessionId");
      parameah = a.ass(parameah);
      AppMethodBeat.o(122609);
      return parameah;
    }
    Log.i("HABBYGE-MALI.HellKSessionConfig", s.X("getRealChatSessionId: ", Integer.valueOf(parameah.abft)));
    parameah = a.LU(parameah.abft);
    AppMethodBeat.o(122609);
    return parameah;
  }
  
  @Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/expt/hellhound/ext/session/config/HellKSessionConfig$Companion;", "", "()V", "CHATTING_UI", "", "CHATTING_UI_FRAGMENT", "ILLEGAL_CONFIG_ID", "SESSION_ID_ADDRESS_ADD_FRIEND", "SESSION_ID_ADDRESS_SEARCH", "SESSION_ID_ADD_FRIEND", "SESSION_ID_APPBRAND", "SESSION_ID_AppBrandLauncherUI", "SESSION_ID_BIZ_LIST", "SESSION_ID_BIZ_MESSAGE", "SESSION_ID_BaseScanUI", "SESSION_ID_BottleBeachUI", "SESSION_ID_CHAT", "SESSION_ID_CHAT_PLUGIN_WECHAT_MOVEMENT", "SESSION_ID_CHAT_ROOM", "SESSION_ID_CHAT_SERVICE", "SESSION_ID_CHAT_SERVICE_NOTIFY", "SESSION_ID_CHAT_VIRTUAL", "SESSION_ID_CONTACT_BIZ", "SESSION_ID_CardHomePageUI", "SESSION_ID_ChatroomContactUI", "SESSION_ID_ContactInfoUI", "SESSION_ID_ContactLabelManagerUI", "SESSION_ID_ENTERPRISE", "SESSION_ID_EmojiStoreV2UI", "SESSION_ID_FINDER", "SESSION_ID_FINDER_MUIL", "SESSION_ID_FIND_SEARCH", "SESSION_ID_FMessageConversationUI", "SESSION_ID_FTSSOSHomeWebViewUI", "SESSION_ID_FavoriteIndexUI", "SESSION_ID_Finder_Profile", "SESSION_ID_FloatingWindow", "SESSION_ID_GAME", "SESSION_ID_GLOBAL_SEARCH", "SESSION_ID_HELP", "SESSION_ID_KFSession", "SESSION_ID_LIVING", "SESSION_ID_MINI_GAME", "SESSION_ID_MallIndexUI", "SESSION_ID_NEW_NEARBY", "SESSION_ID_NearbyFriendsUI", "SESSION_ID_Nearby_Rest", "SESSION_ID_ONLY_CAHT_FRIENDS", "SESSION_ID_OpenIMAddressUI", "SESSION_ID_PROXY_FINDER", "SESSION_ID_SEARCH_BaseScanUI", "SESSION_ID_SELECT_CONTACTUI", "SESSION_ID_SettingsPersonalInfoUI", "SESSION_ID_SettingsUI", "SESSION_ID_ShakeReportUI", "SESSION_ID_SnsTimeLineUI", "SESSION_ID_SnsUserUI", "SESSION_ID_StoryCaptureUI", "SESSION_ID_StoryGalleryView", "SESSION_ID_TENCENT_NEWS", "SESSION_ID_TEXT_STATE", "SESSION_ID_TopStoryHomeUI", "SESSION_ID_VOIP_FloatingWindow", "SESSION_ID_WalletOfflineEntranceUI", "SESSION_ID_WebViewUI_jd_store", "TAB_AddressUIFragment", "TAB_FindMoreFriendsUI", "TAB_MainUI", "TAB_MoreTabUI", "TAG", "mSessionIdEntryListLocal", "", "Lcom/tencent/mm/plugin/expt/hellhound/ext/session/dao/SessionKEntry;", "convertChatSid", "", "hellSession", "Lcom/tencent/mm/protocal/protobuf/HellSession;", "pageSession", "Lcom/tencent/mm/protocal/protobuf/PageSession;", "cutInvalidatePageKeyToName", "pageId", "cutSessonToSid", "session", "doNotNeedSessionMonitor", "", "generateSeq", "", "seqOfPage", "seqOfUBA", "getBizIdOfSessionParam", "timestamp", "", "seq", "getCurSession", "getCurSid", "getIdentifySidExpect", "curActivity", "Landroid/app/Activity;", "srcPage", "dstPage", "getLastSession", "getPageStartTimeOfBizId", "bizId", "(Ljava/lang/String;)Ljava/lang/Long;", "getRealChatSid", "chattingType", "getRealChatSidLocal", "getSessionPageOfConfig", "Lcom/tencent/mm/protocal/protobuf/SessionPagePath;", "sid", "isDetailReport", "getSidId", "args", "getSidLocal", "getTabIdOfLauncher", "tabPageName", "getTabSessionIdOfLauncher", "sessionId", "isAppBrandSession", "isBizSid", "isChatSessionId", "isChatSid", "isCurBizSid", "isEffectiveSession", "sessoinId", "isEffectiveSessionBySid", "isFloatSession", "isJdSid", "isVoipSession", "spliteSession", "Lcom/tencent/mm/vending/tuple/Tuple2;", "updateCurSid", "updateRealChatSessionId", "plugin-expt_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class a
  {
    static String LU(int paramInt)
    {
      AppMethodBeat.i(122595);
      c.dLJ();
      Object localObject = c.dLK();
      if (localObject == null)
      {
        localObject = LV(paramInt);
        AppMethodBeat.o(122595);
        return localObject;
      }
      if (((eyu)localObject).lKI)
      {
        Log.e("HABBYGE-MALI.HellKSessionConfig", "getRealChatSid, configCloud.isDel");
        AppMethodBeat.o(122595);
        return "-1";
      }
      localObject = ((eyu)localObject).abzY.iterator();
      while (((Iterator)localObject).hasNext())
      {
        eyt localeyt = (eyt)((Iterator)localObject).next();
        if (localeyt != null)
        {
          Log.i("HABBYGE-MALI.HellKSessionConfig", s.X("getRealChatSid, chatConfig.expect=", localeyt.abzX));
          if (Util.getInt(localeyt.abzX, -1) == paramInt)
          {
            localObject = localeyt.zIC;
            s.s(localObject, "chatConfig.sid");
            AppMethodBeat.o(122595);
            return localObject;
          }
        }
      }
      localObject = LV(paramInt);
      AppMethodBeat.o(122595);
      return localObject;
    }
    
    private static String LV(int paramInt)
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
        Log.i("HABBYGE-MALI.HellKSessionConfig", s.X("getRealChatSidLocal: ", str));
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
      c.dLJ();
      Object localObject1 = c.dLK();
      if (localObject1 == null)
      {
        AppMethodBeat.o(122591);
        return null;
      }
      eyy localeyy;
      do
      {
        String str;
        do
        {
          localObject1 = ((eyu)localObject1).abAa.iterator();
          Object localObject2;
          while (!((Iterator)localObject2).hasNext())
          {
            do
            {
              if (!((Iterator)localObject1).hasNext()) {
                break;
              }
              localeyy = (eyy)((Iterator)localObject1).next();
            } while ((localeyy == null) || (localeyy.abAd.isEmpty()) || (!s.p(localeyy.abzW, paramString1)));
            localObject2 = localeyy.hJW;
            s.s(localObject2, "config.pageName");
            localObject2 = n.a((CharSequence)localObject2, new String[] { "," }).iterator();
          }
          str = (String)((Iterator)localObject2).next();
          if (str == null)
          {
            paramActivity = new NullPointerException("null cannot be cast to non-null type kotlin.CharSequence");
            AppMethodBeat.o(122591);
            throw paramActivity;
          }
        } while (!s.p(n.bq((CharSequence)str).toString(), paramString2));
        Log.i("HABBYGE-MALI.HellKSessionConfig", s.X("getIdentifySidExpect, sid: ", localeyy.zIC));
      } while (!a.a(paramActivity, localeyy));
      paramActivity = localeyy.zIC;
      AppMethodBeat.o(122591);
      return paramActivity;
      AppMethodBeat.o(122591);
      return null;
    }
    
    public static Long asC(String paramString)
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
          Log.printErrStackTrace("HABBYGE-MALI.HellKSessionConfig", (Throwable)paramString, s.X("getPageStartTimeOfBusinessId, crash: ", paramString.getMessage()), new Object[0]);
          paramString = null;
        }
      }
      AppMethodBeat.o(122598);
      return paramString;
    }
    
    public static String asD(String paramString)
    {
      boolean bool = true;
      AppMethodBeat.i(300380);
      if (paramString == null)
      {
        AppMethodBeat.o(300380);
        return null;
      }
      if (n.a((CharSequence)paramString, (CharSequence)".", false))
      {
        if (s.p(paramString, com.tencent.mm.plugin.expt.hellhound.core.b.zAQ))
        {
          AppMethodBeat.o(300380);
          return "0";
        }
        if (s.p(paramString, com.tencent.mm.plugin.expt.hellhound.core.b.zAR)) {}
        while (bool)
        {
          AppMethodBeat.o(300380);
          return "1";
          bool = s.p(paramString, com.tencent.mm.plugin.expt.hellhound.core.b.zAS);
        }
        if (s.p(paramString, com.tencent.mm.plugin.expt.hellhound.core.b.zAT))
        {
          AppMethodBeat.o(300380);
          return "2";
        }
        if (s.p(paramString, com.tencent.mm.plugin.expt.hellhound.core.b.zAU))
        {
          AppMethodBeat.o(300380);
          return "3";
        }
        AppMethodBeat.o(300380);
        return paramString;
      }
      if (s.p(paramString, com.tencent.mm.plugin.expt.hellhound.core.b.zAW))
      {
        AppMethodBeat.o(300380);
        return "0";
      }
      if (s.p(paramString, com.tencent.mm.plugin.expt.hellhound.core.b.zAX)) {}
      for (bool = true; bool; bool = s.p(paramString, com.tencent.mm.plugin.expt.hellhound.core.b.zAY))
      {
        AppMethodBeat.o(300380);
        return "1";
      }
      if (s.p(paramString, com.tencent.mm.plugin.expt.hellhound.core.b.zAZ))
      {
        AppMethodBeat.o(300380);
        return "2";
      }
      if (s.p(paramString, com.tencent.mm.plugin.expt.hellhound.core.b.zBa))
      {
        AppMethodBeat.o(300380);
        return "3";
      }
      AppMethodBeat.o(300380);
      return paramString;
    }
    
    static boolean asG(String paramString)
    {
      AppMethodBeat.i(185598);
      switch (paramString.hashCode())
      {
      default: 
      case 48: 
        do
        {
          boolean bool = com.tencent.mm.plugin.expt.hellhound.core.b.isNumeric(paramString);
          AppMethodBeat.o(185598);
          return bool;
        } while (!paramString.equals("0"));
      }
      for (;;)
      {
        AppMethodBeat.o(185598);
        return false;
        if (!paramString.equals("1"))
        {
          break;
          if (!paramString.equals("2")) {
            if ((goto 40) || (!paramString.equals("3"))) {
              break;
            }
          }
        }
      }
    }
    
    public static String ass(String paramString)
    {
      AppMethodBeat.i(122593);
      s.u(paramString, "session");
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
      s.s(paramString, "(this as java.lang.Strin…ing(startIndex, endIndex)");
      AppMethodBeat.o(122593);
      return paramString;
    }
    
    public static com.tencent.mm.vending.j.c<String, String> asu(String paramString)
    {
      AppMethodBeat.i(122594);
      if (paramString == null) {}
      for (Object localObject = null; localObject == null; localObject = Integer.valueOf(s.compare(paramString.length(), 4)))
      {
        AppMethodBeat.o(122594);
        return null;
      }
      if (((Integer)localObject).intValue() <= 0)
      {
        AppMethodBeat.o(122594);
        return null;
      }
      localObject = n.a((CharSequence)paramString, new String[] { "_" });
      if (localObject == null) {}
      for (paramString = null; paramString == null; paramString = Integer.valueOf(s.compare(((List)localObject).size(), 2)))
      {
        AppMethodBeat.o(122594);
        return null;
      }
      if (paramString.intValue() != 0)
      {
        AppMethodBeat.o(122594);
        return null;
      }
      paramString = com.tencent.mm.vending.j.a.U(((List)localObject).get(0), ((List)localObject).get(1));
      AppMethodBeat.o(122594);
      return paramString;
    }
    
    public static boolean asw(String paramString)
    {
      AppMethodBeat.i(122597);
      if ((s.p("101", paramString)) || (s.p("102", paramString)) || (s.p("103", paramString)) || (s.p("111", paramString)) || (s.p("112", paramString)))
      {
        AppMethodBeat.o(122597);
        return true;
      }
      AppMethodBeat.o(122597);
      return false;
    }
    
    public static boolean asy(String paramString)
    {
      AppMethodBeat.i(300323);
      if (paramString == null)
      {
        AppMethodBeat.o(300323);
        return false;
      }
      boolean bool = s.p("145", ass(paramString));
      AppMethodBeat.o(300323);
      return bool;
    }
    
    public static String d(String paramString1, String paramString2, List<String> paramList)
    {
      AppMethodBeat.i(122592);
      paramString1 = com.tencent.mm.plugin.expt.hellhound.core.b.aqH(paramString1);
      String str1 = com.tencent.mm.plugin.expt.hellhound.core.b.aqH(paramString2);
      Log.i("HABBYGE-MALI.HellKSessionConfig", "getSessionIdLocal: " + paramString1 + ", " + str1);
      if (((s.p("ChattingUI", paramString2)) || (s.p("ChattingUIFragment", paramString2))) && ((s.p(com.tencent.mm.plugin.expt.hellhound.core.b.zAW, paramString1)) || (TextUtils.isEmpty((CharSequence)paramString1))))
      {
        Log.i("HABBYGE-MALI.HellKSessionConfig", "getSidId: 999");
        AppMethodBeat.o(122592);
        return "999";
      }
      if ((s.p("WebViewUI", str1)) && ((s.p("FindMoreFriendsUI", paramString1)) || (s.p("MainUI", paramString1)) || (s.p(com.tencent.mm.plugin.expt.hellhound.core.b.zAX, paramString1)) || (s.p(com.tencent.mm.plugin.expt.hellhound.core.b.zAY, paramString1))))
      {
        paramString2 = com.tencent.mm.plugin.expt.hellhound.ext.g.a.zLC;
        if (com.tencent.mm.plugin.expt.hellhound.ext.g.a.dMH())
        {
          AppMethodBeat.o(122592);
          return "148";
        }
      }
      if (s.p("BaseScanUI", str1))
      {
        paramString2 = com.tencent.mm.plugin.expt.hellhound.ext.session.f.b.a.zLc;
        if (com.tencent.mm.plugin.expt.hellhound.ext.session.f.b.a.dMz())
        {
          AppMethodBeat.o(122592);
          return "124";
        }
        paramString2 = com.tencent.mm.plugin.expt.hellhound.ext.g.a.zLC;
        if (com.tencent.mm.plugin.expt.hellhound.ext.g.a.dMG())
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
          paramString2 = b.dLH().iterator();
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
            } while (!s.p(paramString1, paramList.zKK));
            localObject = paramList.zKL.iterator();
          }
        } while (!s.p(str1, (String)((Iterator)localObject).next()));
        if (s.p(paramList.sessionId, "109"))
        {
          paramString1 = com.tencent.mm.plugin.expt.hellhound.ext.g.a.zLC;
          if (com.tencent.mm.plugin.expt.hellhound.ext.g.a.dMG())
          {
            AppMethodBeat.o(122592);
            return "109";
          }
          AppMethodBeat.o(122592);
          return "124";
        }
        if ((s.p(paramList.sessionId, "105")) || (s.p(paramList.sessionId, "131")))
        {
          paramString1 = com.tencent.mm.plugin.expt.hellhound.ext.session.f.b.a.zLc;
          if (com.tencent.mm.plugin.expt.hellhound.ext.session.f.b.a.dMy())
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
      paramString2 = b.dLH().iterator();
      int i = 0;
      int j = 0;
      Iterator localIterator;
      while (paramString2.hasNext())
      {
        localObject = (i)paramString2.next();
        if (TextUtils.isEmpty((CharSequence)paramString1))
        {
          AppMethodBeat.o(122592);
          return null;
        }
        if (s.p(paramString1, ((i)localObject).zKK)) {
          localIterator = ((i)localObject).zKL.iterator();
        }
      }
      for (;;)
      {
        label527:
        String str2;
        if (localIterator.hasNext())
        {
          str2 = (String)localIterator.next();
          if (j != 0) {
            if (i < paramList.size())
            {
              if (s.p(str2, paramList.get(i))) {
                break label649;
              }
              i = 0;
              j = 0;
            }
          }
        }
        label646:
        for (;;)
        {
          if (j != 0)
          {
            paramString1 = ((i)localObject).sessionId;
            AppMethodBeat.o(122592);
            return paramString1;
            paramString1 = ((i)localObject).sessionId;
            AppMethodBeat.o(122592);
            return paramString1;
            if (!s.p(str1, str2)) {
              break label646;
            }
            i = 0;
            j = 1;
            break label527;
            AppMethodBeat.o(122592);
            return null;
          }
          break;
        }
        label649:
        i += 1;
      }
    }
    
    public static boolean dLF()
    {
      AppMethodBeat.i(122599);
      if (!com.tencent.mm.plugin.expt.hellhound.a.dIK())
      {
        Log.i("HABBYGE-MALI.HellKSessionConfig", "HellSessionMonitor monitor, fetchHellhoundConfig: FALSE");
        AppMethodBeat.o(122599);
        return true;
      }
      c.dLJ();
      if ((c.dLL()) || (com.tencent.mm.plugin.expt.hellhound.core.b.getUin() == 0))
      {
        Log.i("HABBYGE-MALI.HellKSessionConfig", "HellSessionMonitor monitor FALSE");
        AppMethodBeat.o(122599);
        return true;
      }
      if (!com.tencent.mm.plugin.expt.hellhound.a.dIM())
      {
        Log.i("HABBYGE-MALI.HellKSessionConfig", "HellSessionMonitor monitor, close !!!");
        AppMethodBeat.o(122599);
        return true;
      }
      AppMethodBeat.o(122599);
      return false;
    }
    
    public static String dLI()
    {
      AppMethodBeat.i(122600);
      Object localObject = com.tencent.mm.plugin.expt.hellhound.ext.session.b.c.dLX();
      if (localObject == null)
      {
        AppMethodBeat.o(122600);
        return null;
      }
      localObject = ((eah)localObject).sessionId;
      AppMethodBeat.o(122600);
      return localObject;
    }
    
    public static String dLz()
    {
      AppMethodBeat.i(122601);
      String str = dLI();
      if (str == null)
      {
        AppMethodBeat.o(122601);
        return null;
      }
      str = ass(str);
      AppMethodBeat.o(122601);
      return str;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.expt.hellhound.ext.session.config.b
 * JD-Core Version:    0.7.0.1
 */