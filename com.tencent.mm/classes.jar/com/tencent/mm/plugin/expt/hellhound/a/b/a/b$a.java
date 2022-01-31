package com.tencent.mm.plugin.expt.hellhound.a.b.a;

import a.f.b.j;
import a.l;
import a.l.m;
import android.text.TextUtils;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.expt.hellhound.a.b.b.e;
import com.tencent.mm.protocal.protobuf.bzy;
import com.tencent.mm.protocal.protobuf.bzz;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.vending.j.a;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

@l(eaO={1, 1, 13}, eaP={""}, eaQ={"Lcom/tencent/mm/plugin/expt/hellhound/ext/session/config/HellKSessionConfig$Companion;", "", "()V", "CHATTING_UI", "", "CHATTING_UI_FRAGMENT", "SESSION_ID_ADDRESS_ADD_FRIEND", "SESSION_ID_ADDRESS_SEARCH", "SESSION_ID_ADD_FRIEND", "SESSION_ID_APPBRAND", "SESSION_ID_AppBrandLauncherUI", "SESSION_ID_BIZ_LIST", "SESSION_ID_BIZ_MESSAGE", "SESSION_ID_BaseScanUI", "SESSION_ID_BottleBeachUI", "SESSION_ID_CHAT", "SESSION_ID_CHAT_PLUGIN_WECHAT_MOVEMENT", "SESSION_ID_CHAT_ROOM", "SESSION_ID_CHAT_SERVICE", "SESSION_ID_CHAT_SERVICE_NOTIFY", "SESSION_ID_CHAT_VIRTUAL", "SESSION_ID_CONTACT_BIZ", "SESSION_ID_CardHomePageUI", "SESSION_ID_ChatroomContactUI", "SESSION_ID_ContactInfoUI", "SESSION_ID_ContactLabelManagerUI", "SESSION_ID_ENTERPRISE", "SESSION_ID_EmojiStoreV2UI", "SESSION_ID_FMessageConversationUI", "SESSION_ID_FTSSOSHomeWebViewUI", "SESSION_ID_FavoriteIndexUI", "SESSION_ID_GAME", "SESSION_ID_GLOBAL_SEARCH", "SESSION_ID_MallIndexUI", "SESSION_ID_NearbyFriendsUI", "SESSION_ID_Nearby_Rest", "SESSION_ID_OpenIMAddressUI", "SESSION_ID_SEARCH_BaseScanUI", "SESSION_ID_SELECT_CONTACTUI", "SESSION_ID_SettingsPersonalInfoUI", "SESSION_ID_SettingsUI", "SESSION_ID_ShakeReportUI", "SESSION_ID_SnsTimeLineUI", "SESSION_ID_SnsUserUI", "SESSION_ID_StoryCaptureUI", "SESSION_ID_StoryGalleryView", "SESSION_ID_TENCENT_NEWS", "SESSION_ID_TopStoryHomeUI", "SESSION_ID_WalletOfflineEntranceUI", "SESSION_ID_WebViewUI_jd_store", "TAG", "mSessionIdEntryListLocal", "", "Lcom/tencent/mm/plugin/expt/hellhound/ext/session/dao/SessionKEntry;", "convertChatSid", "", "hellSession", "Lcom/tencent/mm/protocal/protobuf/HellSession;", "pageSession", "Lcom/tencent/mm/protocal/protobuf/PageSession;", "cutSessonToSessionId", "session", "getRealChatSessionId", "getRealChatSid", "chattingType", "", "getRealChatSidLocal", "getSessionPageOfConfig", "Lcom/tencent/mm/protocal/protobuf/SessionPage;", "sid", "getSidId", "curActivity", "Landroid/app/Activity;", "srcPageName", "dstPageName", "args", "getSidLocal", "srcPage", "dstPage", "isAppBrandSession", "", "isBizSid", "isChatSessionId", "isChatSid", "isJdSid", "isSelectContactUiSession", "spliteSession", "Lcom/tencent/mm/vending/tuple/Tuple2;", "plugin-expt_release"})
public final class b$a
{
  public static com.tencent.mm.vending.j.c<String, String> MC(String paramString)
  {
    AppMethodBeat.i(152505);
    if (paramString != null)
    {
      if (j.compare(paramString.length(), 4) <= 0)
      {
        AppMethodBeat.o(152505);
        return null;
      }
    }
    else
    {
      AppMethodBeat.o(152505);
      return null;
    }
    paramString = m.a((CharSequence)paramString, new String[] { "_" });
    if (paramString != null)
    {
      if (j.compare(paramString.size(), 2) != 0)
      {
        AppMethodBeat.o(152505);
        return null;
      }
    }
    else
    {
      AppMethodBeat.o(152505);
      return null;
    }
    paramString = a.C(paramString.get(0), paramString.get(1));
    AppMethodBeat.o(152505);
    return paramString;
  }
  
  public static String Mv(String paramString)
  {
    AppMethodBeat.i(152504);
    j.q(paramString, "session");
    if (paramString.length() <= 3)
    {
      AppMethodBeat.o(152504);
      return paramString;
    }
    paramString = paramString.substring(0, 3);
    j.p(paramString, "(this as java.lang.Strin…ing(startIndex, endIndex)");
    AppMethodBeat.o(152504);
    return paramString;
  }
  
  public static boolean Mw(String paramString)
  {
    AppMethodBeat.i(152507);
    if ((j.e("101", paramString)) || (j.e("102", paramString)) || (j.e("103", paramString)) || (j.e("111", paramString)) || (j.e("112", paramString)))
    {
      AppMethodBeat.o(152507);
      return true;
    }
    AppMethodBeat.o(152507);
    return false;
  }
  
  static String a(String paramString1, String paramString2, List<String> paramList)
  {
    AppMethodBeat.i(152503);
    ab.w("HellKSessionConfig", "HABBYGE-MALI, getSessionIdLocal: " + paramString1 + ", " + paramString2);
    Object localObject2;
    if ((paramList == null) || (paramList.isEmpty()))
    {
      do
      {
        paramList = b.bsa().iterator();
        while (!((Iterator)localObject2).hasNext())
        {
          do
          {
            if (!paramList.hasNext()) {
              break;
            }
            localObject1 = (e)paramList.next();
            if (TextUtils.isEmpty((CharSequence)paramString1))
            {
              AppMethodBeat.o(152503);
              return null;
            }
          } while (!j.e(paramString1, ((e)localObject1).mba));
          localObject2 = ((e)localObject1).mbb.iterator();
        }
      } while (!j.e(paramString2, (String)((Iterator)localObject2).next()));
      paramString1 = ((e)localObject1).cpW;
      AppMethodBeat.o(152503);
      return paramString1;
    }
    Object localObject1 = b.bsa().iterator();
    int j = 0;
    int i = 0;
    if (((Iterator)localObject1).hasNext())
    {
      localObject2 = (e)((Iterator)localObject1).next();
      if (TextUtils.isEmpty((CharSequence)paramString1))
      {
        AppMethodBeat.o(152503);
        return null;
      }
      if ((j.e(paramString1, ((e)localObject2).mba) ^ true)) {
        break label368;
      }
      Iterator localIterator = ((e)localObject2).mbb.iterator();
      label298:
      label345:
      for (;;)
      {
        if (!localIterator.hasNext()) {
          break label358;
        }
        String str = (String)localIterator.next();
        if (j != 0)
        {
          if (i < paramList.size())
          {
            if (j.e(str, (String)paramList.get(i))) {
              break label361;
            }
            j = 0;
            i = 0;
            if (j == 0) {
              break;
            }
            paramString1 = ((e)localObject2).cpW;
            AppMethodBeat.o(152503);
            return paramString1;
          }
          paramString1 = ((e)localObject2).cpW;
          AppMethodBeat.o(152503);
          return paramString1;
        }
        if ((j.e(paramString2, str) ^ true)) {
          break label358;
        }
        j = 1;
        i = 0;
      }
    }
    label358:
    label361:
    label368:
    for (;;)
    {
      break;
      AppMethodBeat.o(152503);
      return null;
      break label298;
      i += 1;
      break label345;
    }
  }
  
  static String vs(int paramInt)
  {
    AppMethodBeat.i(152506);
    j.p(c.bsb(), "HellSessionCloudConfig.getInstance()");
    Object localObject = c.bsc();
    if (localObject == null)
    {
      localObject = vt(paramInt);
      AppMethodBeat.o(152506);
      return localObject;
    }
    if (((bzz)localObject).eht)
    {
      AppMethodBeat.o(152506);
      return "-1";
    }
    localObject = ((bzz)localObject).xLB.iterator();
    while (((Iterator)localObject).hasNext())
    {
      bzy localbzy = (bzy)((Iterator)localObject).next();
      if ((localbzy != null) && (bo.getInt(localbzy.xLy, -1) == paramInt))
      {
        localObject = localbzy.sid;
        j.p(localObject, "chatConfig.sid");
        AppMethodBeat.o(152506);
        return localObject;
      }
    }
    AppMethodBeat.o(152506);
    return "-1";
  }
  
  private static String vt(int paramInt)
  {
    switch (paramInt)
    {
    case 3: 
    default: 
      return "-1";
    case 0: 
      return "101";
    case 1: 
      return "102";
    case 2: 
      return "103";
    case 4: 
      return "111";
    }
    return "112";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.expt.hellhound.a.b.a.b.a
 * JD-Core Version:    0.7.0.1
 */