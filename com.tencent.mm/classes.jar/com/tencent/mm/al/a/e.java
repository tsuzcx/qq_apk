package com.tencent.mm.al.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.al.ag;
import com.tencent.mm.al.q;
import com.tencent.mm.g.c.ba;
import com.tencent.mm.g.c.ei;
import com.tencent.mm.model.bl.a;
import com.tencent.mm.plugin.messenger.foundation.a.a.i;
import com.tencent.mm.protocal.protobuf.auj;
import com.tencent.mm.protocal.protobuf.nd;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.ar;
import com.tencent.mm.sdk.platformtools.bu;
import com.tencent.mm.storage.au;
import com.tencent.mm.storage.br;
import com.tencent.mm.storage.r;
import com.tencent.mm.vfs.o;
import java.util.Arrays;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Random;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public final class e
{
  public static String eNd;
  public static final Object hUD;
  
  static
  {
    AppMethodBeat.i(124241);
    eNd = null;
    hUD = new Object();
    AppMethodBeat.o(124241);
  }
  
  public static boolean ER(String paramString)
  {
    AppMethodBeat.i(124218);
    if (paramString == null)
    {
      AppMethodBeat.o(124218);
      return false;
    }
    if ((paramString.endsWith("@qy_u")) || (paramString.endsWith("@qy_g")))
    {
      AppMethodBeat.o(124218);
      return true;
    }
    AppMethodBeat.o(124218);
    return false;
  }
  
  public static boolean ES(String paramString)
  {
    AppMethodBeat.i(124219);
    if (paramString == null)
    {
      ae.i("MicroMsg.BizChatInfoStorageLogic", "isGroupChat chatId == null");
      AppMethodBeat.o(124219);
      return false;
    }
    boolean bool = paramString.endsWith("@qy_g");
    AppMethodBeat.o(124219);
    return bool;
  }
  
  public static String ET(String paramString)
  {
    AppMethodBeat.i(124223);
    if (paramString == null)
    {
      ae.w("MicroMsg.BizChatInfoStorageLogic", "getUserName bizChatId == null");
      AppMethodBeat.o(124223);
      return null;
    }
    paramString = ag.aGt().eP(paramString);
    if (paramString != null)
    {
      paramString = paramString.field_userName;
      AppMethodBeat.o(124223);
      return paramString;
    }
    ae.i("MicroMsg.BizChatInfoStorageLogic", "getUserName userInfo == null");
    AppMethodBeat.o(124223);
    return null;
  }
  
  public static String EU(String paramString)
  {
    AppMethodBeat.i(124224);
    paramString = ag.aGt().eP(paramString);
    if (paramString != null)
    {
      paramString = paramString.field_headImageUrl;
      AppMethodBeat.o(124224);
      return paramString;
    }
    AppMethodBeat.o(124224);
    return null;
  }
  
  public static k EV(String paramString)
  {
    AppMethodBeat.i(124227);
    if (bu.isNullOrNil(paramString))
    {
      ae.w("MicroMsg.BizChatInfoStorageLogic", "getBizChatMyUserInfo brandUserName==null");
      AppMethodBeat.o(124227);
      return null;
    }
    paramString = ag.aGu().Fa(paramString);
    if (paramString == null)
    {
      ae.w("MicroMsg.BizChatInfoStorageLogic", "getBizChatMyUserInfo bizChatMyUserInfo==null");
      AppMethodBeat.o(124227);
      return null;
    }
    paramString = ag.aGt().eP(paramString.field_userId);
    if (paramString == null) {
      ae.w("MicroMsg.BizChatInfoStorageLogic", "getBizChatMyUserInfo bizChatUserInfo==null");
    }
    AppMethodBeat.o(124227);
    return paramString;
  }
  
  public static String EW(String paramString)
  {
    AppMethodBeat.i(124228);
    if (paramString == null)
    {
      ae.w("MicroMsg.BizChatInfoStorageLogic", "getFormatMsgSource msgSource==null");
      AppMethodBeat.o(124228);
      return null;
    }
    int i = paramString.indexOf("<enterprise_info>") + 17;
    int j = paramString.indexOf("</enterprise_info>");
    if ((i == -1) || (j == -1) || (i >= j))
    {
      ae.w("MicroMsg.BizChatInfoStorageLogic", "getFormatMsgSource error start:%s,end:%s", new Object[] { Integer.valueOf(i), Integer.valueOf(j) });
      AppMethodBeat.o(124228);
      return null;
    }
    String str = paramString.substring(i, j);
    paramString = paramString.replace(str, str.replace("<", "&lt;").replace(">", "&gt;"));
    AppMethodBeat.o(124228);
    return paramString;
  }
  
  public static void EX(String paramString)
  {
    synchronized (hUD)
    {
      eNd = paramString;
      return;
    }
  }
  
  public static long EY(String paramString)
  {
    AppMethodBeat.i(124233);
    if (bu.isNullOrNil(paramString))
    {
      ae.w("MicroMsg.BizChatInfoStorageLogic", "chatId == null");
      AppMethodBeat.o(124233);
      return -1L;
    }
    paramString = ag.aGr().EQ(paramString);
    if (paramString != null)
    {
      long l = paramString.field_bizChatLocalId;
      AppMethodBeat.o(124233);
      return l;
    }
    ae.w("MicroMsg.BizChatInfoStorageLogic", "bizChatInfo == null");
    AppMethodBeat.o(124233);
    return -1L;
  }
  
  public static String EZ(String paramString)
  {
    AppMethodBeat.i(124237);
    String str = paramString;
    if (bu.isNullOrNil(paramString)) {
      str = "tempUser";
    }
    paramString = new StringBuilder(com.tencent.mm.plugin.image.d.azR());
    paramString.append(com.tencent.mm.b.g.getMessageDigest(str.getBytes())).append("/");
    paramString.append("user/");
    paramString = paramString.toString();
    AppMethodBeat.o(124237);
    return paramString;
  }
  
  public static void N(String paramString, final boolean paramBoolean)
  {
    AppMethodBeat.i(124234);
    if (bu.isNullOrNil(paramString))
    {
      ae.d("MicroMsg.BizChatInfoStorageLogic", "delEnterpriseChatConvAndHeadImg, empty brandUserName");
      AppMethodBeat.o(124234);
      return;
    }
    ae.d("MicroMsg.BizChatInfoStorageLogic", "deleteMsgByTalkers");
    com.tencent.mm.kernel.g.ajU().aw(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(124214);
        Object localObject1 = ag.aGs();
        Object localObject2 = this.hUE;
        Object localObject3 = new StringBuilder();
        ((StringBuilder)localObject3).append("delete from BizChatConversation");
        ((StringBuilder)localObject3).append(" where brandUserName = '").append((String)localObject2).append("' ");
        localObject3 = ((StringBuilder)localObject3).toString();
        boolean bool = ((b)localObject1).db.execSQL("BizChatConversation", (String)localObject3);
        ae.i("MicroMsg.BizConversationStorage", "deleteByBrandUserName sql %s,%s", new Object[] { localObject3, Boolean.valueOf(bool) });
        Object localObject4;
        if (bool)
        {
          localObject3 = new a();
          localObject4 = new b.a.b();
          ((b.a.b)localObject4).hUr = -1L;
          ((b.a.b)localObject4).dpI = ((String)localObject2);
          ((b.a.b)localObject4).hUq = b.a.a.hUn;
          ((b.a.b)localObject4).hUs = ((a)localObject3);
          ((b)localObject1).hSD.dW(localObject4);
          ((b)localObject1).hSD.doNotify();
        }
        ((com.tencent.mm.plugin.messenger.foundation.a.l)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.messenger.foundation.a.l.class)).azL().aUY(this.hUE);
        localObject1 = ag.aGr();
        localObject2 = this.hUE;
        localObject3 = new StringBuilder();
        ((StringBuilder)localObject3).append("delete from BizChatInfo");
        ((StringBuilder)localObject3).append(" where brandUserName = '").append((String)localObject2).append("' ");
        localObject3 = ((StringBuilder)localObject3).toString();
        bool = ((d)localObject1).db.execSQL("BizChatInfo", (String)localObject3);
        ae.i("MicroMsg.BizChatInfoStorage", "deleteByBrandUserName sql %s,%s", new Object[] { localObject3, Boolean.valueOf(bool) });
        if (bool)
        {
          localObject3 = new c();
          localObject4 = new d.a.b();
          ((d.a.b)localObject4).hUr = -1L;
          ((d.a.b)localObject4).dpI = ((String)localObject2);
          ((d.a.b)localObject4).hUB = d.a.a.hUy;
          ((d.a.b)localObject4).hUC = ((c)localObject3);
          ((d)localObject1).hSD.dW(localObject4);
          ((d)localObject1).hSD.doNotify();
        }
        o.dd(e.ex(this.hUE), true);
        if (paramBoolean)
        {
          localObject1 = ag.aGt();
          localObject2 = this.hUE;
          localObject3 = new StringBuilder();
          ((StringBuilder)localObject3).append("delete from BizChatUserInfo");
          ((StringBuilder)localObject3).append(" where brandUserName = '").append((String)localObject2).append("' ");
          localObject2 = ((StringBuilder)localObject3).toString();
          bool = ((l)localObject1).db.execSQL("BizChatUserInfo", (String)localObject2);
          ae.i("MicroMsg.BizChatUserInfoStorage", "deleteByBrandUserName sql %s,%s", new Object[] { localObject2, Boolean.valueOf(bool) });
          if (bool)
          {
            localObject2 = new k();
            localObject3 = new l.a.b();
            ((l.a.b)localObject3).hVk = l.a.a.hVh;
            ((l.a.b)localObject3).hVl = ((k)localObject2);
            ((l)localObject1).hSD.dW(localObject3);
            ((l)localObject1).hSD.doNotify();
          }
          ag.aGu().Fb(this.hUE);
          o.dd(e.EZ(this.hUE), true);
        }
        ar.f(new Runnable()
        {
          public final void run()
          {
            AppMethodBeat.i(124213);
            if (e.1.this.hHI != null) {
              e.1.this.hHI.YU();
            }
            AppMethodBeat.o(124213);
          }
        });
        AppMethodBeat.o(124214);
      }
      
      public final String toString()
      {
        AppMethodBeat.i(124215);
        String str = super.toString() + "|deleteMsgByTalkers";
        AppMethodBeat.o(124215);
        return str;
      }
    });
    AppMethodBeat.o(124234);
  }
  
  public static String We()
  {
    synchronized (hUD)
    {
      String str = eNd;
      return str;
    }
  }
  
  public static c a(c paramc, long paramLong)
  {
    AppMethodBeat.i(124225);
    if (paramc == null) {}
    for (long l = -1L;; l = paramc.field_bizChatLocalId)
    {
      ae.w("MicroMsg.BizChatInfoStorageLogic", "protectBizChatNotExist bizChatId:%s BizChatInfo:%s ", new Object[] { Long.valueOf(paramLong), Long.valueOf(l) });
      c localc = paramc;
      if (paramc == null)
      {
        paramc = new c();
        paramc.field_bizChatLocalId = paramLong;
        ag.aGr().b(paramc);
        localc = ag.aGr().bd(paramLong);
      }
      AppMethodBeat.o(124225);
      return localc;
    }
  }
  
  public static k a(k paramk, String paramString)
  {
    AppMethodBeat.i(124226);
    if (paramk == null) {}
    for (Object localObject = Integer.valueOf(-1);; localObject = paramk.field_userId)
    {
      ae.w("MicroMsg.BizChatInfoStorageLogic", "protectBizChatNotExist userId:%s BizChatUserInfo:%s ", new Object[] { paramString, localObject });
      localObject = paramk;
      if (paramk != null) {
        break;
      }
      k localk = new k();
      localk.field_userId = paramString;
      ag.aGt().b(localk);
      paramk = ag.aGt().eP(paramString);
      localObject = paramk;
      if (paramk != null) {
        break;
      }
      ae.e("MicroMsg.BizChatInfoStorageLogic", "protectContactNotExist contact get from db is null!");
      AppMethodBeat.o(124226);
      return localk;
    }
    AppMethodBeat.o(124226);
    return localObject;
  }
  
  public static boolean a(c paramc, String paramString1, String paramString2, auj paramauj)
  {
    AppMethodBeat.i(124238);
    if ((paramString1 != null) && (!bu.isNullOrNil(paramc.field_brandUserName))) {}
    for (;;)
    {
      int i;
      try
      {
        paramString1 = new JSONArray(paramString1);
        if ((paramString1.length() == 1) && (bu.isNullOrNil(paramString2)))
        {
          paramString2 = paramString1.getJSONObject(0);
          paramauj = paramString2.getString("id");
          paramString1 = ag.aGt().eP(paramauj);
          if (paramString1 != null) {
            break label564;
          }
          paramString1 = new k();
          i = 1;
          paramString1.field_userId = paramauj;
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
          if (!ag.aGt().b(paramString1)) {
            ag.aGt().a(paramString1);
          }
          if (i != 0) {
            ag.aGx().bi(paramString1.field_userId, paramString1.field_brandUserName);
          }
          paramString2 = new c();
          paramString2.field_bizChatServId = paramString1.field_userId;
          paramString2.field_brandUserName = paramString1.field_brandUserName;
          paramString2.field_chatName = paramString1.field_userName;
          paramString2.field_chatType = j.hVa.hVd;
          paramString2 = e(paramString2);
          if (paramString2 != null)
          {
            paramc.field_bizChatLocalId = paramString2.field_bizChatLocalId;
            paramc.field_chatName = paramString1.field_userName;
            AppMethodBeat.o(124238);
            return true;
          }
          AppMethodBeat.o(124238);
          return false;
        }
        localLinkedList = new LinkedList();
        if (bu.isNullOrNil(paramString2)) {
          break label570;
        }
        localObject = new nd();
        ((nd)localObject).FZy = paramString2;
        localLinkedList.add(localObject);
      }
      catch (JSONException paramc)
      {
        LinkedList localLinkedList;
        Object localObject;
        ae.i("MicroMsg.BizChatInfoStorageLogic", "parse memberJson Exception:%s", new Object[] { paramc.getMessage() });
        ae.printErrStackTrace("MicroMsg.BizChatInfoStorageLogic", paramc, "", new Object[0]);
      }
      if (i < paramString1.length())
      {
        paramString2 = new k();
        localObject = paramString1.getJSONObject(i);
        paramString2.field_userId = ((JSONObject)localObject).getString("id");
        paramString2.field_userName = ((JSONObject)localObject).getString("nick_name");
        paramString2.field_brandUserName = paramc.field_brandUserName;
        paramString2.field_headImageUrl = ((JSONObject)localObject).getString("head_img_url");
        paramString2.field_profileUrl = ((JSONObject)localObject).getString("profile_url");
        paramString2.field_UserVersion = ((JSONObject)localObject).getInt("ver");
        paramString2.field_addMemberUrl = paramc.field_addMemberUrl;
        if (!ag.aGt().b(paramString2)) {
          ag.aGt().a(paramString2);
        }
        localObject = new nd();
        ((nd)localObject).FZy = paramString2.field_userId;
        localLinkedList.add(localObject);
        i += 1;
      }
      else
      {
        paramauj.FZz = localLinkedList;
        paramc.field_bizChatLocalId = -1L;
        AppMethodBeat.o(124238);
        return true;
        AppMethodBeat.o(124238);
        return false;
        label564:
        i = 0;
        continue;
        label570:
        i = 0;
      }
    }
  }
  
  public static boolean c(c paramc)
  {
    AppMethodBeat.i(124220);
    if (paramc == null)
    {
      AppMethodBeat.o(124220);
      return false;
    }
    List localList = paramc.aGE();
    paramc = ((com.tencent.mm.api.k)com.tencent.mm.kernel.g.ab(com.tencent.mm.api.k.class)).eQ(paramc.field_brandUserName);
    if (paramc == null)
    {
      ae.w("MicroMsg.BaseBizChatInfo", "bizchat myUserId is null");
      AppMethodBeat.o(124220);
      return false;
    }
    Iterator localIterator = localList.iterator();
    while (localIterator.hasNext()) {
      if (paramc.equals((String)localIterator.next()))
      {
        AppMethodBeat.o(124220);
        return true;
      }
    }
    ae.w("MicroMsg.BaseBizChatInfo", "bizchat not in chatroom myUserId is %s", new Object[] { paramc });
    ae.w("MicroMsg.BaseBizChatInfo", "bizchat not in chatroom memberlist is %s", new Object[] { Arrays.toString(localList.toArray()) });
    AppMethodBeat.o(124220);
    return false;
  }
  
  public static String d(c paramc)
  {
    AppMethodBeat.i(124229);
    if (paramc == null)
    {
      ae.w("MicroMsg.BizChatInfoStorageLogic", "getMsgSource bizChatInfo=%s");
      AppMethodBeat.o(124229);
      return null;
    }
    ae.d("MicroMsg.BizChatInfoStorageLogic", "format msgSource");
    if (paramc.field_bizChatServId == null)
    {
      ae.d("MicroMsg.BizChatInfoStorageLogic", "getMsgSource field_bizChatId=%s", new Object[] { paramc.field_bizChatServId });
      AppMethodBeat.o(124229);
      return null;
    }
    Object localObject2 = EV(paramc.field_brandUserName);
    if ((localObject2 == null) || (((k)localObject2).field_userId == null))
    {
      ae.d("MicroMsg.BizChatInfoStorageLogic", " bizChatMyUserInfo.field_userId is null getMsgSource field_bizChatId=%s", new Object[] { paramc.field_bizChatServId });
      AppMethodBeat.o(124229);
      return null;
    }
    synchronized (hUD)
    {
      String str1 = paramc.field_bizChatServId;
      int i = paramc.field_chatVersion;
      String str2 = ((k)localObject2).field_userId;
      long l = paramc.field_bizChatLocalId;
      paramc = ((k)localObject2).field_userId;
      localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append(2);
      ((StringBuilder)localObject2).append(bu.aRi());
      ((StringBuilder)localObject2).append(paramc);
      ((StringBuilder)localObject2).append(e.a.hUJ.nextInt());
      eNd = String.format("<msgsource><enterprise_info><qy_msg_type>%d</qy_msg_type><bizchat_id>%s</bizchat_id><bizchat_ver>%d</bizchat_ver><user_id>%s</user_id><climsgid>%s</climsgid></enterprise_info></msgsource>", new Object[] { Integer.valueOf(1), str1, Integer.valueOf(i), str2, Long.valueOf(l), ((StringBuilder)localObject2).toString() });
      ae.d("MicroMsg.BizChatInfoStorageLogic", "send msgSource:%s", new Object[] { eNd });
      paramc = eNd;
      AppMethodBeat.o(124229);
      return paramc;
    }
  }
  
  public static c e(c paramc)
  {
    AppMethodBeat.i(124230);
    if (paramc.field_bizChatServId == null)
    {
      AppMethodBeat.o(124230);
      return null;
    }
    c localc2 = ag.aGr().EQ(paramc.field_bizChatServId);
    c localc1;
    if (localc2 != null)
    {
      if ((paramc.field_chatVersion <= localc2.field_chatVersion) && (!bu.isNullOrNil(localc2.field_brandUserName))) {
        break label159;
      }
      if (!bu.isNullOrNil(paramc.field_chatName)) {
        localc2.field_chatName = paramc.field_chatName;
      }
      localc2.field_brandUserName = paramc.field_brandUserName;
      localc2.field_needToUpdate = true;
      localc2.field_chatType = paramc.field_chatType;
      ag.aGr().b(localc2);
      localc1 = localc2;
      if (localc1.aGF())
      {
        if (!localc1.isGroup()) {
          break label164;
        }
        ag.aGx().bf(localc1.field_bizChatServId, localc1.field_brandUserName);
      }
    }
    for (;;)
    {
      AppMethodBeat.o(124230);
      return localc1;
      paramc.field_needToUpdate = true;
      localc1 = paramc;
      if (ag.aGr().a(paramc)) {
        break;
      }
      label159:
      localc1 = localc2;
      break;
      label164:
      ag.aGx().bh(localc1.field_bizChatServId, localc1.field_brandUserName);
    }
  }
  
  public static String ex(String paramString)
  {
    AppMethodBeat.i(124236);
    paramString = com.tencent.mm.api.a.ex(paramString);
    AppMethodBeat.o(124236);
    return paramString;
  }
  
  public static boolean f(c paramc)
  {
    AppMethodBeat.i(124231);
    ae.d("MicroMsg.BizChatInfoStorageLogic", "updateBizChatMember");
    if (paramc == null)
    {
      ae.w("MicroMsg.BizChatInfoStorageLogic", "updateBizChatMember: bizChatInfo == null");
      AppMethodBeat.o(124231);
      return false;
    }
    Object localObject = paramc.aGE();
    if (localObject == null)
    {
      ae.w("MicroMsg.BizChatInfoStorageLogic", "updateBizChatMember: list == null");
      AppMethodBeat.o(124231);
      return false;
    }
    LinkedList localLinkedList = new LinkedList();
    localObject = ((List)localObject).iterator();
    while (((Iterator)localObject).hasNext())
    {
      String str = (String)((Iterator)localObject).next();
      k localk = ag.aGt().eP(str);
      if ((localk != null) && (localk.aGF())) {
        localLinkedList.add(str);
      }
    }
    if (localLinkedList.size() > 0)
    {
      ag.aGx().c(localLinkedList, paramc.field_brandUserName);
      AppMethodBeat.o(124231);
      return true;
    }
    ae.w("MicroMsg.BizChatInfoStorageLogic", "updateBizChatMember: no need to update");
    AppMethodBeat.o(124231);
    return false;
  }
  
  public static void g(c paramc)
  {
    AppMethodBeat.i(124239);
    if (paramc == null)
    {
      ae.w("MicroMsg.BizChatInfoStorageLogic", "bizChatInfo is null");
      AppMethodBeat.o(124239);
      return;
    }
    boolean bool1 = ag.aGs().si(paramc.field_bizChatLocalId);
    boolean bool2 = paramc.hk(16);
    ae.d("MicroMsg.BizChatInfoStorageLogic", "convPlaceTop: %s ,bizChatPlaceTop: %s, chatName: %s ", new Object[] { Boolean.valueOf(bool1), Boolean.valueOf(bool2), paramc.field_chatName });
    if ((bool2) && (!bool1))
    {
      ag.aGs().sj(paramc.field_bizChatLocalId);
      AppMethodBeat.o(124239);
      return;
    }
    if ((!bool2) && (bool1)) {
      ag.aGs().sk(paramc.field_bizChatLocalId);
    }
    AppMethodBeat.o(124239);
  }
  
  public static void h(c paramc)
  {
    AppMethodBeat.i(124240);
    if (paramc == null)
    {
      ae.w("MicroMsg.BizChatInfoStorageLogic", "updateBrandUserConvName bizChatInfo is null");
      AppMethodBeat.o(124240);
      return;
    }
    au localau = ((com.tencent.mm.plugin.messenger.foundation.a.l)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.messenger.foundation.a.l.class)).azL().aVa(paramc.field_brandUserName);
    if (localau == null)
    {
      ae.w("MicroMsg.BizChatInfoStorageLogic", "updateBrandUserConvName cvs is null");
      AppMethodBeat.o(124240);
      return;
    }
    Object localObject1 = ((com.tencent.mm.plugin.messenger.foundation.a.l)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.messenger.foundation.a.l.class)).doJ().arc(paramc.field_brandUserName);
    Object localObject2 = ((q)com.tencent.mm.kernel.g.ab(q.class)).azJ().cb(paramc.field_brandUserName, paramc.field_bizChatLocalId);
    if ((localObject1 != null) && (localObject2 != null) && (((ei)localObject1).field_msgId == ((ei)localObject2).field_msgId))
    {
      localObject2 = localau.field_digest;
      if (localObject2 != null)
      {
        int i = ((String)localObject2).indexOf(":");
        if (i != -1)
        {
          localObject1 = ((String)localObject2).substring(0, i);
          localObject2 = ((String)localObject2).substring(i + 1);
          if ((localObject1 != null) && (!((String)localObject1).equals(paramc.field_chatName)))
          {
            localau.tW(paramc.field_chatName + ":" + (String)localObject2);
            ((com.tencent.mm.plugin.messenger.foundation.a.l)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.messenger.foundation.a.l.class)).azL().a(localau, localau.field_username);
          }
        }
      }
    }
    AppMethodBeat.o(124240);
  }
  
  public static void n(final String paramString1, String paramString2, final String paramString3)
  {
    AppMethodBeat.i(124235);
    ae.i("MicroMsg.BizChatInfoStorageLogic", "qy_chat_update %s, %s, %s", new Object[] { paramString1, paramString2, paramString3 });
    com.tencent.mm.kernel.g.ajU().aw(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(124216);
        c localc = ag.aGr().EQ(this.hUH);
        if (localc == null)
        {
          AppMethodBeat.o(124216);
          return;
        }
        if (localc.field_chatVersion < bu.getInt(paramString3, 2147483647))
        {
          localc.field_needToUpdate = true;
          ag.aGr().b(localc);
        }
        if (localc.isGroup())
        {
          ag.aGx().bf(localc.field_bizChatServId, paramString1);
          AppMethodBeat.o(124216);
          return;
        }
        ag.aGx().bh(localc.field_bizChatServId, paramString1);
        AppMethodBeat.o(124216);
      }
    });
    AppMethodBeat.o(124235);
  }
  
  public static int sl(long paramLong)
  {
    AppMethodBeat.i(124221);
    List localList = sm(paramLong);
    if (localList != null)
    {
      int i = localList.size();
      AppMethodBeat.o(124221);
      return i;
    }
    ae.w("MicroMsg.BizChatInfoStorageLogic", "getMembersCountByBizChatId list == null");
    AppMethodBeat.o(124221);
    return 0;
  }
  
  public static List<String> sm(long paramLong)
  {
    AppMethodBeat.i(124222);
    List localList = ag.aGr().bd(paramLong).aGE();
    AppMethodBeat.o(124222);
    return localList;
  }
  
  public static String sn(long paramLong)
  {
    AppMethodBeat.i(124232);
    String str = ag.aGr().bd(paramLong).field_bizChatServId;
    AppMethodBeat.o(124232);
    return str;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.al.a.e
 * JD-Core Version:    0.7.0.1
 */