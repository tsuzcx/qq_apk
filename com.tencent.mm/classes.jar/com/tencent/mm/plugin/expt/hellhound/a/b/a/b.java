package com.tencent.mm.plugin.expt.hellhound.a.b.a;

import a.l;
import a.l.m;
import a.v;
import android.app.Activity;
import android.text.TextUtils;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.expt.hellhound.a.b.b.e;
import com.tencent.mm.protocal.protobuf.ava;
import com.tencent.mm.protocal.protobuf.bki;
import com.tencent.mm.protocal.protobuf.bzy;
import com.tencent.mm.protocal.protobuf.bzz;
import com.tencent.mm.protocal.protobuf.caa;
import com.tencent.mm.protocal.protobuf.cab;
import com.tencent.mm.protocal.protobuf.cad;
import com.tencent.mm.protocal.protobuf.cae;
import com.tencent.mm.sdk.platformtools.ab;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

@l(eaO={1, 1, 13}, eaP={""}, eaQ={"Lcom/tencent/mm/plugin/expt/hellhound/ext/session/config/HellKSessionConfig;", "", "()V", "Companion", "plugin-expt_release"})
public final class b
{
  private static final List<e> maR;
  public static final b.a maS;
  
  static
  {
    AppMethodBeat.i(152508);
    maS = new b.a((byte)0);
    maR = a.a.j.listOf(new e[] { new e("999", "MainUI", (List)a.a.j.V(new String[] { "ChattingUIFragment", "ChattingUI" })), new e("998", "MainUI", (List)a.a.j.V(new String[] { "BizConversationUI" })), new e("104", "MainUI", (List)a.a.j.V(new String[] { "BizTimeLineUI" })), new e("105", "MainUI", (List)a.a.j.V(new String[] { "AppBrandLaunchProxyUI", "AppBrandUI", "AppBrandUI1", "AppBrandUI2", "AppBrandUI3", "AppBrandUI4" })), new e("105", "MainUI", (List)a.a.j.V(new String[] { "AppBrandUI", "AppBrandUI1", "AppBrandUI2", "AppBrandUI3", "AppBrandUI4" })), new e("105", "LauncherUI", (List)a.a.j.V(new String[] { "AppBrandLaunchProxyUI", "AppBrandUI", "AppBrandUI1", "AppBrandUI2", "AppBrandUI3", "AppBrandUI4" })), new e("105", "LauncherUI", (List)a.a.j.V(new String[] { "AppBrandUI", "AppBrandUI1", "AppBrandUI2", "AppBrandUI3", "AppBrandUI4" })), new e("105", "MainUI", (List)a.a.j.V(new String[] { "AppBrandLauncherUI" })), new e("105", "LauncherUI", (List)a.a.j.V(new String[] { "AppBrandLauncherUI" })), new e("113", "MainUI", (List)a.a.j.V(new String[] { "ReaderAppUI" })), new e("114", "AddressUIFragment", (List)a.a.j.V(new String[] { "FTSMainUI" })), new e("115", "AddressUIFragment", (List)a.a.j.V(new String[] { "AddMoreFriendsUI" })), new e("116", "AddressUIFragment", (List)a.a.j.V(new String[] { "FMessageConversationUI" })), new e("117", "AddressUIFragment", (List)a.a.j.V(new String[] { "ChatroomContactUI" })), new e("118", "AddressUIFragment", (List)a.a.j.V(new String[] { "ContactLabelManagerUI" })), new e("106", "MainUI", (List)a.a.j.V(new String[] { "FTSMainUI" })), new e("107", "MainUI", (List)a.a.j.V(new String[] { "SelectContactUI" })), new e("108", "MainUI", (List)a.a.j.V(new String[] { "AddMoreFriendsUI" })), new e("109", "MainUI", (List)a.a.j.V(new String[] { "BaseScanUI" })), new e("110", "MainUI", (List)a.a.j.V(new String[] { "WalletOfflineEntranceUI" })), new e("119", "AddressUIFragment", (List)a.a.j.V(new String[] { "BrandServiceIndexUI" })), new e("120", "AddressUIFragment", (List)a.a.j.V(new String[] { "EnterpriseBizContactListUI" })), new e("121", "AddressUIFragment", (List)a.a.j.V(new String[] { "OpenIMAddressUI" })), new e("122", "AddressUIFragment", (List)a.a.j.V(new String[] { "ContactInfoUI" })), new e("123", "FindMoreFriendsUI", (List)a.a.j.V(new String[] { "SnsTimeLineUI" })), new e("124", "FindMoreFriendsUI", (List)a.a.j.V(new String[] { "BaseScanUI" })), new e("125", "FindMoreFriendsUI", (List)a.a.j.V(new String[] { "ShakeReportUI" })), new e("126", "FindMoreFriendsUI", (List)a.a.j.V(new String[] { "TopStoryHomeUI" })), new e("127", "FindMoreFriendsUI", (List)a.a.j.V(new String[] { "FTSSOSHomeWebViewUI" })), new e("128", "FindMoreFriendsUI", (List)a.a.j.V(new String[] { "NearbyFriendsIntroUI", "NearbyFriendsUI", "NearbyPersonalInfoUI", "NearbyFriendShowSayHiUI" })), new e("129", "FindMoreFriendsUI", (List)a.a.j.V(new String[] { "BottleBeachUI" })), new e("130", "FindMoreFriendsUI", (List)a.a.j.V(new String[] { "AppBrandPluginUI" })), new e("131", "FindMoreFriendsUI", (List)a.a.j.V(new String[] { "WebViewUI", "1", "jd_store" })), new e("132", "FindMoreFriendsUI", (List)a.a.j.V(new String[] { "GameWebViewUI" })), new e("132", "FindMoreFriendsUI", (List)a.a.j.V(new String[] { "GameCenterUI" })), new e("132", "FindMoreFriendsUI", (List)a.a.j.V(new String[] { "LuggageGameWebViewUI" })), new e("133", "FindMoreFriendsUI", (List)a.a.j.V(new String[] { "AppBrandLauncherUI" })), new e("134", "MoreTabUI", (List)a.a.j.V(new String[] { "SettingsPersonalInfoUI" })), new e("135", "MoreTabUI", (List)a.a.j.V(new String[] { "MallIndexUI" })), new e("136", "MoreTabUI", (List)a.a.j.V(new String[] { "FavoriteIndexUI" })), new e("137", "MoreTabUI", (List)a.a.j.V(new String[] { "SnsUserUI", "AlbumUI" })), new e("138", "MoreTabUI", (List)a.a.j.V(new String[] { "CardHomePageNewUI", "CardHomePageUI", "CardIndexUI", "CardInvalidCardUI", "CardViewUI", "ShareCardListUI" })), new e("139", "MoreTabUI", (List)a.a.j.V(new String[] { "EmojiStoreV2UI" })), new e("140", "MoreTabUI", (List)a.a.j.V(new String[] { "SettingsUI" })), new e("141", "MoreTabUI", (List)a.a.j.V(new String[] { "StoryCaptureUI" })), new e("142", "MoreTabUI", (List)a.a.j.V(new String[] { "StoryGalleryView", "StoryVideoView" })) });
    AppMethodBeat.o(152508);
  }
  
  public static final boolean MA(String paramString)
  {
    AppMethodBeat.i(152519);
    a.f.b.j.q(paramString, "sid");
    boolean bool = a.f.b.j.e("131", paramString);
    AppMethodBeat.o(152519);
    return bool;
  }
  
  public static final List<cae> MB(String paramString)
  {
    AppMethodBeat.i(152520);
    if (paramString != null) {
      if (((CharSequence)paramString).length() != 0) {
        break label36;
      }
    }
    label36:
    for (int i = 1; i != 0; i = 0)
    {
      AppMethodBeat.o(152520);
      return null;
    }
    a.f.b.j.p(c.bsb(), "HellSessionCloudConfig.getInstance()");
    Object localObject1 = c.bsc();
    if (localObject1 == null)
    {
      AppMethodBeat.o(152520);
      return null;
    }
    if ((((bzz)localObject1).xLC != null) && (a.f.b.j.e(paramString, ((bzz)localObject1).xLC.sid)))
    {
      paramString = (List)((bzz)localObject1).xLC.xLz;
      AppMethodBeat.o(152520);
      return paramString;
    }
    Object localObject2 = ((bzz)localObject1).xLA.iterator();
    Object localObject3;
    while (((Iterator)localObject2).hasNext())
    {
      localObject3 = (cab)((Iterator)localObject2).next();
      if (a.f.b.j.e(paramString, ((cab)localObject3).sid))
      {
        paramString = (List)((cab)localObject3).xLz;
        AppMethodBeat.o(152520);
        return paramString;
      }
    }
    localObject2 = ((bzz)localObject1).xLB.iterator();
    while (((Iterator)localObject2).hasNext())
    {
      localObject3 = (bzy)((Iterator)localObject2).next();
      if (a.f.b.j.e(paramString, ((bzy)localObject3).sid))
      {
        paramString = (List)((bzy)localObject3).xLz;
        AppMethodBeat.o(152520);
        return paramString;
      }
    }
    localObject1 = ((bzz)localObject1).xLD.iterator();
    while (((Iterator)localObject1).hasNext())
    {
      localObject2 = (cad)((Iterator)localObject1).next();
      if (a.f.b.j.e(paramString, ((cad)localObject2).sid))
      {
        paramString = (List)((cad)localObject2).xLz;
        AppMethodBeat.o(152520);
        return paramString;
      }
    }
    AppMethodBeat.o(152520);
    return null;
  }
  
  public static final String Mv(String paramString)
  {
    AppMethodBeat.i(152510);
    paramString = b.a.Mv(paramString);
    AppMethodBeat.o(152510);
    return paramString;
  }
  
  public static final boolean Mw(String paramString)
  {
    AppMethodBeat.i(152515);
    boolean bool = b.a.Mw(paramString);
    AppMethodBeat.o(152515);
    return bool;
  }
  
  public static final boolean Mx(String paramString)
  {
    AppMethodBeat.i(152516);
    if (paramString == null)
    {
      AppMethodBeat.o(152516);
      return false;
    }
    boolean bool = a.f.b.j.e("105", b.a.Mv(paramString));
    AppMethodBeat.o(152516);
    return bool;
  }
  
  public static final boolean My(String paramString)
  {
    AppMethodBeat.i(152517);
    if (paramString != null)
    {
      paramString = b.a.Mv(paramString);
      if ((a.f.b.j.e("999", paramString)) || (b.a.Mw(paramString)))
      {
        AppMethodBeat.o(152517);
        return true;
      }
    }
    AppMethodBeat.o(152517);
    return false;
  }
  
  public static final boolean Mz(String paramString)
  {
    AppMethodBeat.i(152518);
    if (paramString != null)
    {
      paramString = b.a.Mv(paramString);
      if ((a.f.b.j.e("104", paramString)) || (a.f.b.j.e("998", paramString)))
      {
        AppMethodBeat.o(152518);
        return true;
      }
    }
    AppMethodBeat.o(152518);
    return false;
  }
  
  public static final String a(Activity paramActivity, String paramString1, String paramString2, List<String> paramList)
  {
    AppMethodBeat.i(152509);
    ab.w("HellKSessionConfig", "HABBYGE-MALI, getSessionId: " + paramString1 + ", " + paramString2);
    a.f.b.j.p(c.bsb(), "HellSessionCloudConfig.getInstance()");
    Object localObject1 = c.bsc();
    if (localObject1 == null)
    {
      paramActivity = b.a.a(paramString1, paramString2, paramList);
      AppMethodBeat.o(152509);
      return paramActivity;
    }
    if (((bzz)localObject1).eht)
    {
      ab.e("HellKSessionConfig", "habbyge-mali, getSidId, sessionCloud.isDel ture");
      AppMethodBeat.o(152509);
      return null;
    }
    if (((a.f.b.j.e("ChattingUI", paramString2)) || (a.f.b.j.e("ChattingUIFragment", paramString2))) && ((a.f.b.j.e("MainUI", paramString1)) || (TextUtils.isEmpty((CharSequence)paramString1))))
    {
      ab.i("HellKSessionConfig", "habbyge-mali, getSidId, SESSION_ID_CHAT_VIRTUAL");
      AppMethodBeat.o(152509);
      return "999";
    }
    if ((a.f.b.j.e("WebViewUI", paramString2)) && (a.f.b.j.e("FindMoreFriendsUI", paramString1)) && (((bzz)localObject1).xLC != null) && (paramList != null) && (paramList.size() >= 2) && (a.f.b.j.e(((bzz)localObject1).xLC.xLE, (String)paramList.get(0))) && (a.f.b.j.e(((bzz)localObject1).xLC.xLF, (String)paramList.get(1))))
    {
      ab.i("HellKSessionConfig", "habbyge-mali, getSidId, SESSION_ID_WebViewUI_jd_store");
      AppMethodBeat.o(152509);
      return "131";
    }
    if ((paramList == null) || (paramList.isEmpty()))
    {
      Object localObject2 = ((bzz)localObject1).xLA.iterator();
      Object localObject3;
      Object localObject4;
      String str;
      do
      {
        while (!((Iterator)localObject4).hasNext())
        {
          do
          {
            if (!((Iterator)localObject2).hasNext()) {
              break;
            }
            localObject3 = (cab)((Iterator)localObject2).next();
          } while ((localObject3 == null) || (!a.f.b.j.e(((cab)localObject3).xLx, paramString1)));
          localObject4 = ((cab)localObject3).xkf;
          a.f.b.j.p(localObject4, "config.pageName");
          localObject4 = m.b((CharSequence)localObject4, new String[] { "," }).iterator();
        }
        str = (String)((Iterator)localObject4).next();
        if (str == null)
        {
          paramActivity = new v("null cannot be cast to non-null type kotlin.CharSequence");
          AppMethodBeat.o(152509);
          throw paramActivity;
        }
      } while (!a.f.b.j.e(m.trim((CharSequence)str).toString(), paramString2));
      ab.i("HellKSessionConfig", "habbyge-mali, getSidId, config.sid: " + ((cab)localObject3).sid);
      paramActivity = ((cab)localObject3).sid;
      AppMethodBeat.o(152509);
      return paramActivity;
      localObject1 = ((bzz)localObject1).xLD.iterator();
      do
      {
        do
        {
          while (!((Iterator)localObject3).hasNext())
          {
            do
            {
              if (!((Iterator)localObject1).hasNext()) {
                break;
              }
              localObject2 = (cad)((Iterator)localObject1).next();
            } while ((localObject2 == null) || (((cad)localObject2).xLG.isEmpty()) || ((a.f.b.j.e(((cad)localObject2).xLx, paramString1) ^ true)));
            localObject3 = ((cad)localObject2).xkf;
            a.f.b.j.p(localObject3, "config.pageName");
            localObject3 = m.b((CharSequence)localObject3, new String[] { "," }).iterator();
          }
          localObject4 = (String)((Iterator)localObject3).next();
          if (localObject4 == null)
          {
            paramActivity = new v("null cannot be cast to non-null type kotlin.CharSequence");
            AppMethodBeat.o(152509);
            throw paramActivity;
          }
        } while (!a.f.b.j.e(m.trim((CharSequence)localObject4).toString(), paramString2));
        ab.i("HellKSessionConfig", "habbyge-mali, getSidId params, config.sid " + ((cad)localObject2).sid);
      } while (!a.a(paramActivity, (cad)localObject2));
      paramActivity = ((cad)localObject2).sid;
      AppMethodBeat.o(152509);
      return paramActivity;
    }
    ab.i("HellKSessionConfig", "habbyge-mali, getSidId by cloud config is NULL，continue dignose session id By local logic !!!");
    paramActivity = b.a.a(paramString1, paramString2, paramList);
    AppMethodBeat.o(152509);
    return paramActivity;
  }
  
  public static final void a(ava paramava)
  {
    AppMethodBeat.i(152511);
    if (paramava != null)
    {
      ab.i("HellKSessionConfig", "HABBYGE-MALI, befor, sessionList.length: " + paramava.xkk.size());
      paramava = paramava.xkk;
      a.f.b.j.p(paramava, "hellSession.sessions");
      Object localObject1 = (Iterable)paramava;
      paramava = (Collection)new ArrayList();
      localObject1 = ((Iterable)localObject1).iterator();
      Object localObject2;
      Object localObject3;
      label230:
      while (((Iterator)localObject1).hasNext())
      {
        localObject2 = ((Iterator)localObject1).next();
        localObject3 = (bki)localObject2;
        String str = ((bki)localObject3).czq;
        a.f.b.j.p(str, "it.session");
        str = b.a.Mv(str);
        ab.i("HellKSessionConfig", "HABBYGE-MALI, handleChatting, sessionId: " + str + ", " + ((bki)localObject3).czq);
        if ((a.f.b.j.e(str, "999")) && ((((bki)localObject3).xyL == 0) || (((bki)localObject3).xyL == 1) || (((bki)localObject3).xyL == 2) || (((bki)localObject3).xyL == 4) || (((bki)localObject3).xyL == 5))) {}
        for (int i = 1;; i = 0)
        {
          if (i == 0) {
            break label230;
          }
          paramava.add(localObject2);
          break;
        }
      }
      localObject1 = a.a.j.m((Iterable)paramava);
      if (localObject1 == null)
      {
        AppMethodBeat.o(152511);
        return;
      }
      ab.i("HellKSessionConfig", "HABBYGE-MALI, after, sessionList.size: " + ((List)localObject1).size());
      paramava = null;
      localObject1 = ((List)localObject1).iterator();
      while (((Iterator)localObject1).hasNext())
      {
        localObject2 = (bki)((Iterator)localObject1).next();
        localObject3 = b.a.MC(((bki)localObject2).czq);
        if (localObject3 != null) {
          paramava = "_" + ((com.tencent.mm.vending.j.c)localObject3).get(1);
        }
        ab.i("HellKSessionConfig", "HABBYGE-MALI, handleChatting, session, Start: " + ((bki)localObject2).czq + ", " + paramava);
        ((bki)localObject2).czq = b.a.vs(((bki)localObject2).xyL);
        if ((a.f.b.j.e(((bki)localObject2).czq, "-1") ^ true))
        {
          localObject3 = ((bki)localObject2).czq;
          ((bki)localObject2).czq = ((String)localObject3 + paramava);
        }
        ab.i("HellKSessionConfig", "HABBYGE-MALI, handleChatting, session, End: " + ((bki)localObject2).czq);
      }
    }
    AppMethodBeat.o(152511);
  }
  
  public static final void b(bki parambki)
  {
    AppMethodBeat.i(152512);
    if (parambki != null)
    {
      com.tencent.mm.vending.j.c localc = b.a.MC(parambki.czq);
      if (localc == null)
      {
        AppMethodBeat.o(152512);
        return;
      }
      if (!(a.f.b.j.e("999", localc.get(0)) ^ true))
      {
        String str = b.a.vs(parambki.xyL);
        parambki.czq = (str + "_" + localc.get(1));
      }
    }
    AppMethodBeat.o(152512);
  }
  
  public static final String c(bki parambki)
  {
    AppMethodBeat.i(152513);
    if (parambki == null)
    {
      AppMethodBeat.o(152513);
      return null;
    }
    com.tencent.mm.vending.j.c localc = b.a.MC(parambki.czq);
    if (localc == null)
    {
      parambki = parambki.czq;
      AppMethodBeat.o(152513);
      return parambki;
    }
    if ((a.f.b.j.e("999", localc.get(0)) ^ true))
    {
      parambki = parambki.czq;
      AppMethodBeat.o(152513);
      return parambki;
    }
    parambki = b.a.vs(parambki.xyL);
    parambki = parambki + "_" + localc.get(1);
    AppMethodBeat.o(152513);
    return parambki;
  }
  
  public static final String d(bki parambki)
  {
    AppMethodBeat.i(152514);
    if (parambki == null)
    {
      AppMethodBeat.o(152514);
      return null;
    }
    com.tencent.mm.vending.j.c localc = b.a.MC(parambki.czq);
    if (localc == null)
    {
      parambki = parambki.czq;
      AppMethodBeat.o(152514);
      return parambki;
    }
    if ((a.f.b.j.e("999", localc.get(0)) ^ true))
    {
      parambki = parambki.czq;
      a.f.b.j.p(parambki, "pageSession.session");
      parambki = b.a.Mv(parambki);
      AppMethodBeat.o(152514);
      return parambki;
    }
    parambki = b.a.vs(parambki.xyL);
    AppMethodBeat.o(152514);
    return parambki;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.expt.hellhound.a.b.a.b
 * JD-Core Version:    0.7.0.1
 */