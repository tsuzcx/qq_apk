package com.tencent.mm.aj.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.aj.z;
import com.tencent.mm.api.a;
import com.tencent.mm.api.i;
import com.tencent.mm.g.c.au;
import com.tencent.mm.g.c.dd;
import com.tencent.mm.protocal.protobuf.aeh;
import com.tencent.mm.protocal.protobuf.kr;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.al;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.storage.ak;
import com.tencent.mm.storage.be;
import java.util.Arrays;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public final class e
{
  public static String dns;
  public static final Object fxC;
  
  static
  {
    AppMethodBeat.i(11555);
    dns = null;
    fxC = new Object();
    AppMethodBeat.o(11555);
  }
  
  public static void H(String paramString, boolean paramBoolean)
  {
    AppMethodBeat.i(11548);
    if (bo.isNullOrNil(paramString))
    {
      ab.d("MicroMsg.BizChatInfoStorageLogic", "delEnterpriseChatConvAndHeadImg, empty brandUserName");
      AppMethodBeat.o(11548);
      return;
    }
    ab.d("MicroMsg.BizChatInfoStorageLogic", "deleteMsgByTalkers");
    com.tencent.mm.kernel.g.RO().ac(new e.1(paramString, paramBoolean));
    AppMethodBeat.o(11548);
  }
  
  public static c a(c paramc, long paramLong)
  {
    AppMethodBeat.i(11539);
    if (paramc == null) {}
    for (long l = -1L;; l = paramc.field_bizChatLocalId)
    {
      ab.w("MicroMsg.BizChatInfoStorageLogic", "protectBizChatNotExist bizChatId:%s BizChatInfo:%s ", new Object[] { Long.valueOf(paramLong), Long.valueOf(l) });
      c localc = paramc;
      if (paramc == null)
      {
        paramc = new c();
        paramc.field_bizChatLocalId = paramLong;
        z.afk().b(paramc);
        localc = z.afk().aG(paramLong);
      }
      AppMethodBeat.o(11539);
      return localc;
    }
  }
  
  public static j a(j paramj, String paramString)
  {
    AppMethodBeat.i(11540);
    if (paramj == null) {}
    for (Object localObject = Integer.valueOf(-1);; localObject = paramj.field_userId)
    {
      ab.w("MicroMsg.BizChatInfoStorageLogic", "protectBizChatNotExist userId:%s BizChatUserInfo:%s ", new Object[] { paramString, localObject });
      localObject = paramj;
      if (paramj != null) {
        break;
      }
      j localj = new j();
      localj.field_userId = paramString;
      z.afm().b(localj);
      paramj = z.afm().df(paramString);
      localObject = paramj;
      if (paramj != null) {
        break;
      }
      ab.e("MicroMsg.BizChatInfoStorageLogic", "protectContactNotExist contact get from db is null!");
      AppMethodBeat.o(11540);
      return localj;
    }
    AppMethodBeat.o(11540);
    return localObject;
  }
  
  public static boolean a(c paramc, String paramString1, String paramString2, aeh paramaeh)
  {
    AppMethodBeat.i(11552);
    if ((paramString1 != null) && (!bo.isNullOrNil(paramc.field_brandUserName))) {}
    for (;;)
    {
      int i;
      try
      {
        paramString1 = new JSONArray(paramString1);
        if ((paramString1.length() == 1) && (bo.isNullOrNil(paramString2)))
        {
          paramString2 = paramString1.getJSONObject(0);
          paramaeh = paramString2.getString("id");
          paramString1 = z.afm().df(paramaeh);
          if (paramString1 != null) {
            break label547;
          }
          paramString1 = new j();
          i = 1;
          paramString1.field_userId = paramaeh;
          paramString1.field_userName = paramString2.getString("nick_name");
          paramString1.field_headImageUrl = paramString2.getString("head_img_url");
          paramString1.field_profileUrl = paramString2.getString("profile_url");
          paramString1.field_UserVersion = paramString2.getInt("ver");
          if ((paramString1.field_brandUserName == null) || (paramString1.field_brandUserName.length() == 0))
          {
            paramString1.field_brandUserName = paramc.field_brandUserName;
            i = 1;
          }
          if ((paramString1.field_addMemberUrl == null) || (paramString1.field_addMemberUrl.length() == 0))
          {
            paramString1.field_addMemberUrl = paramc.field_addMemberUrl;
            i = 1;
          }
          if (!z.afm().b(paramString1)) {
            z.afm().a(paramString1);
          }
          if (i != 0) {
            z.afq().aK(paramString1.field_userId, paramString1.field_brandUserName);
          }
          paramString2 = new c();
          paramString2.field_bizChatServId = paramString1.field_userId;
          paramString2.field_brandUserName = paramString1.field_brandUserName;
          paramString2.field_chatName = paramString1.field_userName;
          paramString2.field_chatType = 1;
          paramString2 = e(paramString2);
          if (paramString2 != null)
          {
            paramc.field_bizChatLocalId = paramString2.field_bizChatLocalId;
            paramc.field_chatName = paramString1.field_userName;
            AppMethodBeat.o(11552);
            return true;
          }
          AppMethodBeat.o(11552);
          return false;
        }
        localLinkedList = new LinkedList();
        if (bo.isNullOrNil(paramString2)) {
          break label553;
        }
        localObject = new kr();
        ((kr)localObject).wyi = paramString2;
        localLinkedList.add(localObject);
      }
      catch (JSONException paramc)
      {
        LinkedList localLinkedList;
        Object localObject;
        ab.i("MicroMsg.BizChatInfoStorageLogic", "parse memberJson Exception:%s", new Object[] { paramc.getMessage() });
        ab.printErrStackTrace("MicroMsg.BizChatInfoStorageLogic", paramc, "", new Object[0]);
      }
      if (i < paramString1.length())
      {
        paramString2 = new j();
        localObject = paramString1.getJSONObject(i);
        paramString2.field_userId = ((JSONObject)localObject).getString("id");
        paramString2.field_userName = ((JSONObject)localObject).getString("nick_name");
        paramString2.field_brandUserName = paramc.field_brandUserName;
        paramString2.field_headImageUrl = ((JSONObject)localObject).getString("head_img_url");
        paramString2.field_profileUrl = ((JSONObject)localObject).getString("profile_url");
        paramString2.field_UserVersion = ((JSONObject)localObject).getInt("ver");
        paramString2.field_addMemberUrl = paramc.field_addMemberUrl;
        if (!z.afm().b(paramString2)) {
          z.afm().a(paramString2);
        }
        localObject = new kr();
        ((kr)localObject).wyi = paramString2.field_userId;
        localLinkedList.add(localObject);
        i += 1;
      }
      else
      {
        paramaeh.wyj = localLinkedList;
        paramc.field_bizChatLocalId = -1L;
        AppMethodBeat.o(11552);
        return true;
        AppMethodBeat.o(11552);
        return false;
        label547:
        i = 0;
        continue;
        label553:
        i = 0;
      }
    }
  }
  
  public static String aaQ()
  {
    synchronized (fxC)
    {
      String str = dns;
      return str;
    }
  }
  
  public static boolean c(c paramc)
  {
    AppMethodBeat.i(11534);
    if (paramc == null)
    {
      AppMethodBeat.o(11534);
      return false;
    }
    List localList = paramc.afx();
    paramc = ((i)com.tencent.mm.kernel.g.E(i.class)).dg(paramc.field_brandUserName);
    if (paramc == null)
    {
      ab.w("MicroMsg.BaseBizChatInfo", "bizchat myUserId is null");
      AppMethodBeat.o(11534);
      return false;
    }
    Iterator localIterator = localList.iterator();
    while (localIterator.hasNext()) {
      if (paramc.equals((String)localIterator.next()))
      {
        AppMethodBeat.o(11534);
        return true;
      }
    }
    ab.w("MicroMsg.BaseBizChatInfo", "bizchat not in chatroom myUserId is %s", new Object[] { paramc });
    ab.w("MicroMsg.BaseBizChatInfo", "bizchat not in chatroom memberlist is %s", new Object[] { Arrays.toString(localList.toArray()) });
    AppMethodBeat.o(11534);
    return false;
  }
  
  public static String cV(String paramString)
  {
    AppMethodBeat.i(11550);
    paramString = a.cV(paramString);
    AppMethodBeat.o(11550);
    return paramString;
  }
  
  public static String d(c paramc)
  {
    AppMethodBeat.i(11543);
    if (paramc == null)
    {
      ab.w("MicroMsg.BizChatInfoStorageLogic", "getMsgSource bizChatInfo=%s");
      AppMethodBeat.o(11543);
      return null;
    }
    ab.d("MicroMsg.BizChatInfoStorageLogic", "format msgSource");
    if (paramc.field_bizChatServId == null)
    {
      ab.d("MicroMsg.BizChatInfoStorageLogic", "getMsgSource field_bizChatId=%s", new Object[] { paramc.field_bizChatServId });
      AppMethodBeat.o(11543);
      return null;
    }
    j localj = sq(paramc.field_brandUserName);
    if ((localj == null) || (localj.field_userId == null))
    {
      ab.d("MicroMsg.BizChatInfoStorageLogic", " bizChatMyUserInfo.field_userId is null getMsgSource field_bizChatId=%s", new Object[] { paramc.field_bizChatServId });
      AppMethodBeat.o(11543);
      return null;
    }
    synchronized (fxC)
    {
      dns = String.format("<msgsource><enterprise_info><qy_msg_type>%d</qy_msg_type><bizchat_id>%s</bizchat_id><bizchat_ver>%d</bizchat_ver><user_id>%s</user_id></enterprise_info></msgsource>", new Object[] { Integer.valueOf(1), paramc.field_bizChatServId, Integer.valueOf(paramc.field_chatVersion), localj.field_userId });
      ab.d("MicroMsg.BizChatInfoStorageLogic", "send msgSource:%s", new Object[] { dns });
      paramc = dns;
      AppMethodBeat.o(11543);
      return paramc;
    }
  }
  
  public static c e(c paramc)
  {
    AppMethodBeat.i(11544);
    if (paramc.field_bizChatServId == null)
    {
      AppMethodBeat.o(11544);
      return null;
    }
    c localc2 = z.afk().sl(paramc.field_bizChatServId);
    c localc1;
    if (localc2 != null)
    {
      if ((paramc.field_chatVersion <= localc2.field_chatVersion) && (!bo.isNullOrNil(localc2.field_brandUserName))) {
        break label159;
      }
      if (!bo.isNullOrNil(paramc.field_chatName)) {
        localc2.field_chatName = paramc.field_chatName;
      }
      localc2.field_brandUserName = paramc.field_brandUserName;
      localc2.field_needToUpdate = true;
      localc2.field_chatType = paramc.field_chatType;
      z.afk().b(localc2);
      localc1 = localc2;
      if (localc1.afy())
      {
        if (!localc1.isGroup()) {
          break label164;
        }
        z.afq().aH(localc1.field_bizChatServId, localc1.field_brandUserName);
      }
    }
    for (;;)
    {
      AppMethodBeat.o(11544);
      return localc1;
      paramc.field_needToUpdate = true;
      localc1 = paramc;
      if (z.afk().a(paramc)) {
        break;
      }
      label159:
      localc1 = localc2;
      break;
      label164:
      z.afq().aJ(localc1.field_bizChatServId, localc1.field_brandUserName);
    }
  }
  
  public static boolean f(c paramc)
  {
    AppMethodBeat.i(11545);
    ab.d("MicroMsg.BizChatInfoStorageLogic", "updateBizChatMember");
    if (paramc == null)
    {
      ab.w("MicroMsg.BizChatInfoStorageLogic", "updateBizChatMember: bizChatInfo == null");
      AppMethodBeat.o(11545);
      return false;
    }
    Object localObject = paramc.afx();
    if (localObject == null)
    {
      ab.w("MicroMsg.BizChatInfoStorageLogic", "updateBizChatMember: list == null");
      AppMethodBeat.o(11545);
      return false;
    }
    LinkedList localLinkedList = new LinkedList();
    localObject = ((List)localObject).iterator();
    while (((Iterator)localObject).hasNext())
    {
      String str = (String)((Iterator)localObject).next();
      j localj = z.afm().df(str);
      if ((localj != null) && (localj.afy())) {
        localLinkedList.add(str);
      }
    }
    if (localLinkedList.size() > 0)
    {
      z.afq().b(localLinkedList, paramc.field_brandUserName);
      AppMethodBeat.o(11545);
      return true;
    }
    ab.w("MicroMsg.BizChatInfoStorageLogic", "updateBizChatMember: no need to update");
    AppMethodBeat.o(11545);
    return false;
  }
  
  public static void g(c paramc)
  {
    AppMethodBeat.i(11553);
    if (paramc == null)
    {
      ab.w("MicroMsg.BizChatInfoStorageLogic", "bizChatInfo is null");
      AppMethodBeat.o(11553);
      return;
    }
    boolean bool1 = z.afl().gI(paramc.field_bizChatLocalId);
    boolean bool2 = paramc.kY(16);
    ab.d("MicroMsg.BizChatInfoStorageLogic", "convPlaceTop: %s ,bizChatPlaceTop: %s, chatName: %s ", new Object[] { Boolean.valueOf(bool1), Boolean.valueOf(bool2), paramc.field_chatName });
    if ((bool2) && (!bool1))
    {
      z.afl().gJ(paramc.field_bizChatLocalId);
      AppMethodBeat.o(11553);
      return;
    }
    if ((!bool2) && (bool1)) {
      z.afl().gK(paramc.field_bizChatLocalId);
    }
    AppMethodBeat.o(11553);
  }
  
  public static int gL(long paramLong)
  {
    AppMethodBeat.i(11535);
    List localList = gM(paramLong);
    if (localList != null)
    {
      int i = localList.size();
      AppMethodBeat.o(11535);
      return i;
    }
    ab.w("MicroMsg.BizChatInfoStorageLogic", "getMembersCountByBizChatId list == null");
    AppMethodBeat.o(11535);
    return 0;
  }
  
  public static List<String> gM(long paramLong)
  {
    AppMethodBeat.i(11536);
    List localList = z.afk().aG(paramLong).afx();
    AppMethodBeat.o(11536);
    return localList;
  }
  
  public static String gN(long paramLong)
  {
    AppMethodBeat.i(11546);
    String str = z.afk().aG(paramLong).field_bizChatServId;
    AppMethodBeat.o(11546);
    return str;
  }
  
  public static void h(c paramc)
  {
    AppMethodBeat.i(11554);
    if (paramc == null)
    {
      ab.w("MicroMsg.BizChatInfoStorageLogic", "updateBrandUserConvName bizChatInfo is null");
      AppMethodBeat.o(11554);
      return;
    }
    ak localak = ((com.tencent.mm.plugin.messenger.foundation.a.j)com.tencent.mm.kernel.g.E(com.tencent.mm.plugin.messenger.foundation.a.j.class)).YF().arH(paramc.field_brandUserName);
    if (localak == null)
    {
      ab.w("MicroMsg.BizChatInfoStorageLogic", "updateBrandUserConvName cvs is null");
      AppMethodBeat.o(11554);
      return;
    }
    Object localObject1 = ((com.tencent.mm.plugin.messenger.foundation.a.j)com.tencent.mm.kernel.g.E(com.tencent.mm.plugin.messenger.foundation.a.j.class)).bPQ().Tm(paramc.field_brandUserName);
    Object localObject2 = ((com.tencent.mm.aj.o)com.tencent.mm.kernel.g.E(com.tencent.mm.aj.o.class)).YD().bb(paramc.field_brandUserName, paramc.field_bizChatLocalId);
    if ((localObject1 != null) && (localObject2 != null) && (((dd)localObject1).field_msgId == ((dd)localObject2).field_msgId))
    {
      localObject2 = localak.field_digest;
      if (localObject2 != null)
      {
        int i = ((String)localObject2).indexOf(":");
        if (i != -1)
        {
          localObject1 = ((String)localObject2).substring(0, i);
          localObject2 = ((String)localObject2).substring(i + 1);
          if ((localObject1 != null) && (!((String)localObject1).equals(paramc.field_chatName)))
          {
            localak.jW(paramc.field_chatName + ":" + (String)localObject2);
            ((com.tencent.mm.plugin.messenger.foundation.a.j)com.tencent.mm.kernel.g.E(com.tencent.mm.plugin.messenger.foundation.a.j.class)).YF().a(localak, localak.field_username);
          }
        }
      }
    }
    AppMethodBeat.o(11554);
  }
  
  public static void p(String paramString1, String paramString2, String paramString3)
  {
    AppMethodBeat.i(11549);
    ab.i("MicroMsg.BizChatInfoStorageLogic", "qy_chat_update %s, %s, %s", new Object[] { paramString1, paramString2, paramString3 });
    com.tencent.mm.kernel.g.RO().ac(new e.2(paramString2, paramString3, paramString1));
    AppMethodBeat.o(11549);
  }
  
  public static boolean sm(String paramString)
  {
    AppMethodBeat.i(11532);
    if (paramString == null)
    {
      AppMethodBeat.o(11532);
      return false;
    }
    if ((paramString.endsWith("@qy_u")) || (paramString.endsWith("@qy_g")))
    {
      AppMethodBeat.o(11532);
      return true;
    }
    AppMethodBeat.o(11532);
    return false;
  }
  
  public static boolean sn(String paramString)
  {
    AppMethodBeat.i(11533);
    if (paramString == null)
    {
      ab.i("MicroMsg.BizChatInfoStorageLogic", "isGroupChat chatId == null");
      AppMethodBeat.o(11533);
      return false;
    }
    boolean bool = paramString.endsWith("@qy_g");
    AppMethodBeat.o(11533);
    return bool;
  }
  
  public static String so(String paramString)
  {
    AppMethodBeat.i(11537);
    if (paramString == null)
    {
      ab.w("MicroMsg.BizChatInfoStorageLogic", "getUserName bizChatId == null");
      AppMethodBeat.o(11537);
      return null;
    }
    paramString = z.afm().df(paramString);
    if (paramString != null)
    {
      paramString = paramString.field_userName;
      AppMethodBeat.o(11537);
      return paramString;
    }
    ab.i("MicroMsg.BizChatInfoStorageLogic", "getUserName userInfo == null");
    AppMethodBeat.o(11537);
    return null;
  }
  
  public static String sp(String paramString)
  {
    AppMethodBeat.i(11538);
    paramString = z.afm().df(paramString);
    if (paramString != null)
    {
      paramString = paramString.field_headImageUrl;
      AppMethodBeat.o(11538);
      return paramString;
    }
    AppMethodBeat.o(11538);
    return null;
  }
  
  public static j sq(String paramString)
  {
    AppMethodBeat.i(11541);
    if (bo.isNullOrNil(paramString))
    {
      ab.w("MicroMsg.BizChatInfoStorageLogic", "getBizChatMyUserInfo brandUserName==null");
      AppMethodBeat.o(11541);
      return null;
    }
    paramString = z.afn().sv(paramString);
    if (paramString == null)
    {
      ab.w("MicroMsg.BizChatInfoStorageLogic", "getBizChatMyUserInfo bizChatMyUserInfo==null");
      AppMethodBeat.o(11541);
      return null;
    }
    paramString = z.afm().df(paramString.field_userId);
    if (paramString == null) {
      ab.w("MicroMsg.BizChatInfoStorageLogic", "getBizChatMyUserInfo bizChatUserInfo==null");
    }
    AppMethodBeat.o(11541);
    return paramString;
  }
  
  public static String sr(String paramString)
  {
    AppMethodBeat.i(11542);
    if (paramString == null)
    {
      ab.w("MicroMsg.BizChatInfoStorageLogic", "getFormatMsgSource msgSource==null");
      AppMethodBeat.o(11542);
      return null;
    }
    int i = paramString.indexOf("<enterprise_info>") + 17;
    int j = paramString.indexOf("</enterprise_info>");
    if ((i == -1) || (j == -1) || (i >= j))
    {
      ab.w("MicroMsg.BizChatInfoStorageLogic", "getFormatMsgSource error start:%s,end:%s", new Object[] { Integer.valueOf(i), Integer.valueOf(j) });
      AppMethodBeat.o(11542);
      return null;
    }
    String str = paramString.substring(i, j);
    paramString = paramString.replace(str, str.replace("<", "&lt;").replace(">", "&gt;"));
    AppMethodBeat.o(11542);
    return paramString;
  }
  
  public static void ss(String paramString)
  {
    synchronized (fxC)
    {
      dns = paramString;
      return;
    }
  }
  
  public static long st(String paramString)
  {
    AppMethodBeat.i(11547);
    if (bo.isNullOrNil(paramString))
    {
      ab.w("MicroMsg.BizChatInfoStorageLogic", "chatId == null");
      AppMethodBeat.o(11547);
      return -1L;
    }
    paramString = z.afk().sl(paramString);
    if (paramString != null)
    {
      long l = paramString.field_bizChatLocalId;
      AppMethodBeat.o(11547);
      return l;
    }
    ab.w("MicroMsg.BizChatInfoStorageLogic", "bizChatInfo == null");
    AppMethodBeat.o(11547);
    return -1L;
  }
  
  public static String su(String paramString)
  {
    AppMethodBeat.i(11551);
    String str = paramString;
    if (bo.isNullOrNil(paramString)) {
      str = "tempUser";
    }
    paramString = new StringBuilder(com.tencent.mm.plugin.i.c.YL());
    paramString.append(com.tencent.mm.a.g.w(str.getBytes())).append("/");
    paramString.append("user/");
    paramString = paramString.toString();
    AppMethodBeat.o(11551);
    return paramString;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.aj.a.e
 * JD-Core Version:    0.7.0.1
 */