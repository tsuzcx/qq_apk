package com.tencent.mm.ai.a;

import com.tencent.mm.ai.z;
import com.tencent.mm.api.a;
import com.tencent.mm.h.c.as;
import com.tencent.mm.h.c.cs;
import com.tencent.mm.protocal.c.iq;
import com.tencent.mm.protocal.c.zp;
import com.tencent.mm.sdk.platformtools.ai;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.sdk.platformtools.y;
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
  public static String czr = null;
  public static final Object ehy = new Object();
  
  public static void D(String paramString, boolean paramBoolean)
  {
    if (bk.bl(paramString))
    {
      y.d("MicroMsg.BizChatInfoStorageLogic", "delEnterpriseChatConvAndHeadImg, empty brandUserName");
      return;
    }
    y.d("MicroMsg.BizChatInfoStorageLogic", "deleteMsgByTalkers");
    com.tencent.mm.kernel.g.DS().O(new e.1(paramString, paramBoolean));
  }
  
  public static String HR()
  {
    synchronized (ehy)
    {
      String str = czr;
      return str;
    }
  }
  
  public static c a(c paramc, long paramLong)
  {
    if (paramc == null) {}
    for (long l = -1L;; l = paramc.field_bizChatLocalId)
    {
      y.w("MicroMsg.BizChatInfoStorageLogic", "protectBizChatNotExist bizChatId:%s BizChatInfo:%s ", new Object[] { Long.valueOf(paramLong), Long.valueOf(l) });
      c localc = paramc;
      if (paramc == null)
      {
        paramc = new c();
        paramc.field_bizChatLocalId = paramLong;
        z.MA().b(paramc);
        localc = z.MA().aj(paramLong);
      }
      return localc;
    }
  }
  
  public static j a(j paramj, String paramString)
  {
    if (paramj == null) {}
    for (Object localObject = Integer.valueOf(-1);; localObject = paramj.field_userId)
    {
      y.w("MicroMsg.BizChatInfoStorageLogic", "protectBizChatNotExist userId:%s BizChatUserInfo:%s ", new Object[] { paramString, localObject });
      localObject = paramj;
      if (paramj == null)
      {
        paramj = new j();
        paramj.field_userId = paramString;
        z.MC().b(paramj);
        paramString = z.MC().bY(paramString);
        localObject = paramString;
        if (paramString == null)
        {
          y.e("MicroMsg.BizChatInfoStorageLogic", "protectContactNotExist contact get from db is null!");
          localObject = paramj;
        }
      }
      return localObject;
    }
  }
  
  public static boolean a(c paramc, String paramString1, String paramString2, zp paramzp)
  {
    if ((paramString1 != null) && (!bk.bl(paramc.field_brandUserName))) {}
    for (;;)
    {
      int i;
      try
      {
        paramString1 = new JSONArray(paramString1);
        if ((paramString1.length() == 1) && (bk.bl(paramString2)))
        {
          paramString2 = paramString1.getJSONObject(0);
          paramzp = paramString2.getString("id");
          paramString1 = z.MC().bY(paramzp);
          if (paramString1 != null) {
            break label515;
          }
          paramString1 = new j();
          i = 1;
          paramString1.field_userId = paramzp;
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
          if (!z.MC().b(paramString1)) {
            z.MC().a(paramString1);
          }
          if (i != 0) {
            z.MG().aq(paramString1.field_userId, paramString1.field_brandUserName);
          }
          paramString2 = new c();
          paramString2.field_bizChatServId = paramString1.field_userId;
          paramString2.field_brandUserName = paramString1.field_brandUserName;
          paramString2.field_chatName = paramString1.field_userName;
          paramString2.field_chatType = 1;
          paramString2 = e(paramString2);
          if (paramString2 == null) {
            break label521;
          }
          paramc.field_bizChatLocalId = paramString2.field_bizChatLocalId;
          paramc.field_chatName = paramString1.field_userName;
          return true;
        }
        localLinkedList = new LinkedList();
        if (bk.bl(paramString2)) {
          break label523;
        }
        localObject = new iq();
        ((iq)localObject).sCP = paramString2;
        localLinkedList.add(localObject);
      }
      catch (JSONException paramc)
      {
        LinkedList localLinkedList;
        Object localObject;
        y.i("MicroMsg.BizChatInfoStorageLogic", "parse memberJson Exception:%s", new Object[] { paramc.getMessage() });
        y.printErrStackTrace("MicroMsg.BizChatInfoStorageLogic", paramc, "", new Object[0]);
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
        if (!z.MC().b(paramString2)) {
          z.MC().a(paramString2);
        }
        localObject = new iq();
        ((iq)localObject).sCP = paramString2.field_userId;
        localLinkedList.add(localObject);
        i += 1;
      }
      else
      {
        paramzp.sCQ = localLinkedList;
        paramc.field_bizChatLocalId = -1L;
        return true;
        return false;
        label515:
        i = 0;
        continue;
        label521:
        return false;
        label523:
        i = 0;
      }
    }
  }
  
  public static int bQ(long paramLong)
  {
    List localList = bR(paramLong);
    if (localList != null) {
      return localList.size();
    }
    y.w("MicroMsg.BizChatInfoStorageLogic", "getMembersCountByBizChatId list == null");
    return 0;
  }
  
  public static List<String> bR(long paramLong)
  {
    return z.MA().aj(paramLong).MN();
  }
  
  public static String bS(long paramLong)
  {
    return z.MA().aj(paramLong).field_bizChatServId;
  }
  
  public static String bT(String paramString)
  {
    return a.bT(paramString);
  }
  
  public static boolean c(c paramc)
  {
    if (paramc == null) {
      return false;
    }
    List localList = paramc.MN();
    paramc = ((com.tencent.mm.api.h)com.tencent.mm.kernel.g.r(com.tencent.mm.api.h.class)).bZ(paramc.field_brandUserName);
    if (paramc == null)
    {
      y.w("MicroMsg.BaseBizChatInfo", "bizchat myUserId is null");
      return false;
    }
    Iterator localIterator = localList.iterator();
    while (localIterator.hasNext()) {
      if (paramc.equals((String)localIterator.next())) {
        return true;
      }
    }
    y.w("MicroMsg.BaseBizChatInfo", "bizchat not in chatroom myUserId is %s", new Object[] { paramc });
    y.w("MicroMsg.BaseBizChatInfo", "bizchat not in chatroom memberlist is %s", new Object[] { Arrays.toString(localList.toArray()) });
    return false;
  }
  
  public static String d(c paramc)
  {
    if (paramc == null)
    {
      y.w("MicroMsg.BizChatInfoStorageLogic", "getMsgSource bizChatInfo=%s");
      return null;
    }
    y.d("MicroMsg.BizChatInfoStorageLogic", "format msgSource");
    if (paramc.field_bizChatServId == null)
    {
      y.d("MicroMsg.BizChatInfoStorageLogic", "getMsgSource field_bizChatId=%s", new Object[] { paramc.field_bizChatServId });
      return null;
    }
    j localj = lu(paramc.field_brandUserName);
    if ((localj == null) || (localj.field_userId == null))
    {
      y.d("MicroMsg.BizChatInfoStorageLogic", " bizChatMyUserInfo.field_userId is null getMsgSource field_bizChatId=%s", new Object[] { paramc.field_bizChatServId });
      return null;
    }
    synchronized (ehy)
    {
      czr = String.format("<msgsource><enterprise_info><qy_msg_type>%d</qy_msg_type><bizchat_id>%s</bizchat_id><bizchat_ver>%d</bizchat_ver><user_id>%s</user_id></enterprise_info></msgsource>", new Object[] { Integer.valueOf(1), paramc.field_bizChatServId, Integer.valueOf(paramc.field_chatVersion), localj.field_userId });
      y.d("MicroMsg.BizChatInfoStorageLogic", "send msgSource:%s", new Object[] { czr });
      return czr;
    }
  }
  
  public static c e(c paramc)
  {
    if (paramc.field_bizChatServId == null)
    {
      paramc = null;
      return paramc;
    }
    c localc2 = z.MA().lp(paramc.field_bizChatServId);
    c localc1;
    if (localc2 != null)
    {
      if ((paramc.field_chatVersion <= localc2.field_chatVersion) && (!bk.bl(localc2.field_brandUserName))) {
        break label145;
      }
      if (!bk.bl(paramc.field_chatName)) {
        localc2.field_chatName = paramc.field_chatName;
      }
      localc2.field_brandUserName = paramc.field_brandUserName;
      localc2.field_needToUpdate = true;
      localc2.field_chatType = paramc.field_chatType;
      z.MA().b(localc2);
      localc1 = localc2;
    }
    for (;;)
    {
      paramc = localc1;
      if (!localc1.MO()) {
        break;
      }
      if (!localc1.isGroup()) {
        break label150;
      }
      z.MG().ao(localc1.field_bizChatServId, localc1.field_brandUserName);
      return localc1;
      paramc.field_needToUpdate = true;
      localc1 = paramc;
      if (!z.MA().a(paramc)) {
        label145:
        localc1 = localc2;
      }
    }
    label150:
    z.MG().ap(localc1.field_bizChatServId, localc1.field_brandUserName);
    return localc1;
  }
  
  public static boolean f(c paramc)
  {
    y.d("MicroMsg.BizChatInfoStorageLogic", "updateBizChatMember");
    if (paramc == null)
    {
      y.w("MicroMsg.BizChatInfoStorageLogic", "updateBizChatMember: bizChatInfo == null");
      return false;
    }
    Object localObject = paramc.MN();
    if (localObject == null)
    {
      y.w("MicroMsg.BizChatInfoStorageLogic", "updateBizChatMember: list == null");
      return false;
    }
    LinkedList localLinkedList = new LinkedList();
    localObject = ((List)localObject).iterator();
    while (((Iterator)localObject).hasNext())
    {
      String str = (String)((Iterator)localObject).next();
      j localj = z.MC().bY(str);
      if ((localj != null) && (localj.MO())) {
        localLinkedList.add(str);
      }
    }
    if (localLinkedList.size() > 0)
    {
      z.MG().b(localLinkedList, paramc.field_brandUserName);
      return true;
    }
    y.w("MicroMsg.BizChatInfoStorageLogic", "updateBizChatMember: no need to update");
    return false;
  }
  
  public static void g(c paramc)
  {
    if (paramc == null) {
      y.w("MicroMsg.BizChatInfoStorageLogic", "bizChatInfo is null");
    }
    boolean bool1;
    boolean bool2;
    do
    {
      return;
      bool1 = z.MB().bN(paramc.field_bizChatLocalId);
      bool2 = paramc.il(16);
      y.d("MicroMsg.BizChatInfoStorageLogic", "convPlaceTop: %s ,bizChatPlaceTop: %s, chatName: %s ", new Object[] { Boolean.valueOf(bool1), Boolean.valueOf(bool2), paramc.field_chatName });
      if ((bool2) && (!bool1))
      {
        z.MB().bO(paramc.field_bizChatLocalId);
        return;
      }
    } while ((bool2) || (!bool1));
    z.MB().bP(paramc.field_bizChatLocalId);
  }
  
  public static void h(c paramc)
  {
    if (paramc == null) {
      y.w("MicroMsg.BizChatInfoStorageLogic", "updateBrandUserConvName bizChatInfo is null");
    }
    ak localak;
    Object localObject1;
    Object localObject2;
    do
    {
      int i;
      do
      {
        do
        {
          do
          {
            return;
            localak = ((com.tencent.mm.plugin.messenger.foundation.a.j)com.tencent.mm.kernel.g.r(com.tencent.mm.plugin.messenger.foundation.a.j.class)).FB().abv(paramc.field_brandUserName);
            if (localak == null)
            {
              y.w("MicroMsg.BizChatInfoStorageLogic", "updateBrandUserConvName cvs is null");
              return;
            }
            localObject1 = ((com.tencent.mm.plugin.messenger.foundation.a.j)com.tencent.mm.kernel.g.r(com.tencent.mm.plugin.messenger.foundation.a.j.class)).bhO().HA(paramc.field_brandUserName);
            localObject2 = ((com.tencent.mm.ai.o)com.tencent.mm.kernel.g.r(com.tencent.mm.ai.o.class)).Fz().at(paramc.field_brandUserName, paramc.field_bizChatLocalId);
          } while ((localObject1 == null) || (localObject2 == null) || (((cs)localObject1).field_msgId != ((cs)localObject2).field_msgId));
          localObject2 = localak.field_digest;
        } while (localObject2 == null);
        i = ((String)localObject2).indexOf(":");
      } while (i == -1);
      localObject1 = ((String)localObject2).substring(0, i);
      localObject2 = ((String)localObject2).substring(i + 1);
    } while ((localObject1 == null) || (((String)localObject1).equals(paramc.field_chatName)));
    localak.dQ(paramc.field_chatName + ":" + (String)localObject2);
    ((com.tencent.mm.plugin.messenger.foundation.a.j)com.tencent.mm.kernel.g.r(com.tencent.mm.plugin.messenger.foundation.a.j.class)).FB().a(localak, localak.field_username);
  }
  
  public static boolean lq(String paramString)
  {
    if (paramString == null) {}
    while ((!paramString.endsWith("@qy_u")) && (!paramString.endsWith("@qy_g"))) {
      return false;
    }
    return true;
  }
  
  public static boolean lr(String paramString)
  {
    if (paramString == null)
    {
      y.i("MicroMsg.BizChatInfoStorageLogic", "isGroupChat chatId == null");
      return false;
    }
    return paramString.endsWith("@qy_g");
  }
  
  public static String ls(String paramString)
  {
    if (paramString == null)
    {
      y.w("MicroMsg.BizChatInfoStorageLogic", "getUserName bizChatId == null");
      return null;
    }
    paramString = z.MC().bY(paramString);
    if (paramString != null) {
      return paramString.field_userName;
    }
    y.i("MicroMsg.BizChatInfoStorageLogic", "getUserName userInfo == null");
    return null;
  }
  
  public static String lt(String paramString)
  {
    paramString = z.MC().bY(paramString);
    if (paramString != null) {
      return paramString.field_headImageUrl;
    }
    return null;
  }
  
  public static j lu(String paramString)
  {
    j localj = null;
    if (bk.bl(paramString))
    {
      y.w("MicroMsg.BizChatInfoStorageLogic", "getBizChatMyUserInfo brandUserName==null");
      paramString = localj;
    }
    do
    {
      return paramString;
      paramString = z.MD().lz(paramString);
      if (paramString == null)
      {
        y.w("MicroMsg.BizChatInfoStorageLogic", "getBizChatMyUserInfo bizChatMyUserInfo==null");
        return null;
      }
      localj = z.MC().bY(paramString.field_userId);
      paramString = localj;
    } while (localj != null);
    y.w("MicroMsg.BizChatInfoStorageLogic", "getBizChatMyUserInfo bizChatUserInfo==null");
    return localj;
  }
  
  public static String lv(String paramString)
  {
    if (paramString == null)
    {
      y.w("MicroMsg.BizChatInfoStorageLogic", "getFormatMsgSource msgSource==null");
      return null;
    }
    int i = paramString.indexOf("<enterprise_info>") + 17;
    int j = paramString.indexOf("</enterprise_info>");
    if ((i == -1) || (j == -1) || (i >= j))
    {
      y.w("MicroMsg.BizChatInfoStorageLogic", "getFormatMsgSource error start:%s,end:%s", new Object[] { Integer.valueOf(i), Integer.valueOf(j) });
      return null;
    }
    String str = paramString.substring(i, j);
    return paramString.replace(str, str.replace("<", "&lt;").replace(">", "&gt;"));
  }
  
  public static void lw(String paramString)
  {
    synchronized (ehy)
    {
      czr = paramString;
      return;
    }
  }
  
  public static long lx(String paramString)
  {
    if (bk.bl(paramString))
    {
      y.w("MicroMsg.BizChatInfoStorageLogic", "chatId == null");
      return -1L;
    }
    paramString = z.MA().lp(paramString);
    if (paramString != null) {
      return paramString.field_bizChatLocalId;
    }
    y.w("MicroMsg.BizChatInfoStorageLogic", "bizChatInfo == null");
    return -1L;
  }
  
  public static String ly(String paramString)
  {
    String str = paramString;
    if (bk.bl(paramString)) {
      str = "tempUser";
    }
    paramString = new StringBuilder(com.tencent.mm.plugin.n.c.FH());
    paramString.append(com.tencent.mm.a.g.o(str.getBytes())).append("/");
    paramString.append("user/");
    return paramString.toString();
  }
  
  public static void n(String paramString1, String paramString2, String paramString3)
  {
    y.i("MicroMsg.BizChatInfoStorageLogic", "qy_chat_update %s, %s, %s", new Object[] { paramString1, paramString2, paramString3 });
    com.tencent.mm.kernel.g.DS().O(new e.2(paramString2, paramString3, paramString1));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.ai.a.e
 * JD-Core Version:    0.7.0.1
 */