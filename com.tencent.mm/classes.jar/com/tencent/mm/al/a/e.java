package com.tencent.mm.al.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.al.af;
import com.tencent.mm.g.c.az;
import com.tencent.mm.g.c.dy;
import com.tencent.mm.model.bi.a;
import com.tencent.mm.protocal.protobuf.apz;
import com.tencent.mm.protocal.protobuf.mm;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.bs;
import com.tencent.mm.storage.bk;
import com.tencent.mm.vfs.i;
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
  public static String eul;
  public static final Object hzq;
  
  static
  {
    AppMethodBeat.i(124241);
    eul = null;
    hzq = new Object();
    AppMethodBeat.o(124241);
  }
  
  public static boolean Bq(String paramString)
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
  
  public static boolean Br(String paramString)
  {
    AppMethodBeat.i(124219);
    if (paramString == null)
    {
      ac.i("MicroMsg.BizChatInfoStorageLogic", "isGroupChat chatId == null");
      AppMethodBeat.o(124219);
      return false;
    }
    boolean bool = paramString.endsWith("@qy_g");
    AppMethodBeat.o(124219);
    return bool;
  }
  
  public static String Bs(String paramString)
  {
    AppMethodBeat.i(124223);
    if (paramString == null)
    {
      ac.w("MicroMsg.BizChatInfoStorageLogic", "getUserName bizChatId == null");
      AppMethodBeat.o(124223);
      return null;
    }
    paramString = af.aDa().dP(paramString);
    if (paramString != null)
    {
      paramString = paramString.field_userName;
      AppMethodBeat.o(124223);
      return paramString;
    }
    ac.i("MicroMsg.BizChatInfoStorageLogic", "getUserName userInfo == null");
    AppMethodBeat.o(124223);
    return null;
  }
  
  public static String Bt(String paramString)
  {
    AppMethodBeat.i(124224);
    paramString = af.aDa().dP(paramString);
    if (paramString != null)
    {
      paramString = paramString.field_headImageUrl;
      AppMethodBeat.o(124224);
      return paramString;
    }
    AppMethodBeat.o(124224);
    return null;
  }
  
  public static k Bu(String paramString)
  {
    AppMethodBeat.i(124227);
    if (bs.isNullOrNil(paramString))
    {
      ac.w("MicroMsg.BizChatInfoStorageLogic", "getBizChatMyUserInfo brandUserName==null");
      AppMethodBeat.o(124227);
      return null;
    }
    paramString = af.aDb().Bz(paramString);
    if (paramString == null)
    {
      ac.w("MicroMsg.BizChatInfoStorageLogic", "getBizChatMyUserInfo bizChatMyUserInfo==null");
      AppMethodBeat.o(124227);
      return null;
    }
    paramString = af.aDa().dP(paramString.field_userId);
    if (paramString == null) {
      ac.w("MicroMsg.BizChatInfoStorageLogic", "getBizChatMyUserInfo bizChatUserInfo==null");
    }
    AppMethodBeat.o(124227);
    return paramString;
  }
  
  public static String Bv(String paramString)
  {
    AppMethodBeat.i(124228);
    if (paramString == null)
    {
      ac.w("MicroMsg.BizChatInfoStorageLogic", "getFormatMsgSource msgSource==null");
      AppMethodBeat.o(124228);
      return null;
    }
    int i = paramString.indexOf("<enterprise_info>") + 17;
    int j = paramString.indexOf("</enterprise_info>");
    if ((i == -1) || (j == -1) || (i >= j))
    {
      ac.w("MicroMsg.BizChatInfoStorageLogic", "getFormatMsgSource error start:%s,end:%s", new Object[] { Integer.valueOf(i), Integer.valueOf(j) });
      AppMethodBeat.o(124228);
      return null;
    }
    String str = paramString.substring(i, j);
    paramString = paramString.replace(str, str.replace("<", "&lt;").replace(">", "&gt;"));
    AppMethodBeat.o(124228);
    return paramString;
  }
  
  public static void Bw(String paramString)
  {
    synchronized (hzq)
    {
      eul = paramString;
      return;
    }
  }
  
  public static long Bx(String paramString)
  {
    AppMethodBeat.i(124233);
    if (bs.isNullOrNil(paramString))
    {
      ac.w("MicroMsg.BizChatInfoStorageLogic", "chatId == null");
      AppMethodBeat.o(124233);
      return -1L;
    }
    paramString = af.aCY().Bp(paramString);
    if (paramString != null)
    {
      long l = paramString.field_bizChatLocalId;
      AppMethodBeat.o(124233);
      return l;
    }
    ac.w("MicroMsg.BizChatInfoStorageLogic", "bizChatInfo == null");
    AppMethodBeat.o(124233);
    return -1L;
  }
  
  public static String By(String paramString)
  {
    AppMethodBeat.i(124237);
    String str = paramString;
    if (bs.isNullOrNil(paramString)) {
      str = "tempUser";
    }
    paramString = new StringBuilder(com.tencent.mm.plugin.image.d.awM());
    paramString.append(com.tencent.mm.b.g.getMessageDigest(str.getBytes())).append("/");
    paramString.append("user/");
    paramString = paramString.toString();
    AppMethodBeat.o(124237);
    return paramString;
  }
  
  public static void N(String paramString, final boolean paramBoolean)
  {
    AppMethodBeat.i(124234);
    if (bs.isNullOrNil(paramString))
    {
      ac.d("MicroMsg.BizChatInfoStorageLogic", "delEnterpriseChatConvAndHeadImg, empty brandUserName");
      AppMethodBeat.o(124234);
      return;
    }
    ac.d("MicroMsg.BizChatInfoStorageLogic", "deleteMsgByTalkers");
    com.tencent.mm.kernel.g.agU().az(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(124214);
        Object localObject1 = af.aCZ();
        Object localObject2 = this.hzr;
        Object localObject3 = new StringBuilder();
        ((StringBuilder)localObject3).append("delete from BizChatConversation");
        ((StringBuilder)localObject3).append(" where brandUserName = '").append((String)localObject2).append("' ");
        localObject3 = ((StringBuilder)localObject3).toString();
        boolean bool = ((b)localObject1).db.execSQL("BizChatConversation", (String)localObject3);
        ac.i("MicroMsg.BizConversationStorage", "deleteByBrandUserName sql %s,%s", new Object[] { localObject3, Boolean.valueOf(bool) });
        Object localObject4;
        if (bool)
        {
          localObject3 = new a();
          localObject4 = new b.a.b();
          ((b.a.b)localObject4).hze = -1L;
          ((b.a.b)localObject4).ddh = ((String)localObject2);
          ((b.a.b)localObject4).hzd = b.a.a.hza;
          ((b.a.b)localObject4).hzf = ((a)localObject3);
          ((b)localObject1).hxq.dS(localObject4);
          ((b)localObject1).hxq.doNotify();
        }
        ((com.tencent.mm.plugin.messenger.foundation.a.k)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.messenger.foundation.a.k.class)).awG().aNG(this.hzr);
        localObject1 = af.aCY();
        localObject2 = this.hzr;
        localObject3 = new StringBuilder();
        ((StringBuilder)localObject3).append("delete from BizChatInfo");
        ((StringBuilder)localObject3).append(" where brandUserName = '").append((String)localObject2).append("' ");
        localObject3 = ((StringBuilder)localObject3).toString();
        bool = ((d)localObject1).db.execSQL("BizChatInfo", (String)localObject3);
        ac.i("MicroMsg.BizChatInfoStorage", "deleteByBrandUserName sql %s,%s", new Object[] { localObject3, Boolean.valueOf(bool) });
        if (bool)
        {
          localObject3 = new c();
          localObject4 = new d.a.b();
          ((d.a.b)localObject4).hze = -1L;
          ((d.a.b)localObject4).ddh = ((String)localObject2);
          ((d.a.b)localObject4).hzo = d.a.a.hzl;
          ((d.a.b)localObject4).hzp = ((c)localObject3);
          ((d)localObject1).hxq.dS(localObject4);
          ((d)localObject1).hxq.doNotify();
        }
        i.cU(e.dw(this.hzr), true);
        if (paramBoolean)
        {
          localObject1 = af.aDa();
          localObject2 = this.hzr;
          localObject3 = new StringBuilder();
          ((StringBuilder)localObject3).append("delete from BizChatUserInfo");
          ((StringBuilder)localObject3).append(" where brandUserName = '").append((String)localObject2).append("' ");
          localObject2 = ((StringBuilder)localObject3).toString();
          bool = ((l)localObject1).db.execSQL("BizChatUserInfo", (String)localObject2);
          ac.i("MicroMsg.BizChatUserInfoStorage", "deleteByBrandUserName sql %s,%s", new Object[] { localObject2, Boolean.valueOf(bool) });
          if (bool)
          {
            localObject2 = new k();
            localObject3 = new l.a.b();
            ((l.a.b)localObject3).hzX = l.a.a.hzU;
            ((l.a.b)localObject3).hzY = ((k)localObject2);
            ((l)localObject1).hxq.dS(localObject3);
            ((l)localObject1).hxq.doNotify();
          }
          af.aDb().BA(this.hzr);
          i.cU(e.By(this.hzr), true);
        }
        com.tencent.mm.sdk.platformtools.ap.f(new Runnable()
        {
          public final void run()
          {
            AppMethodBeat.i(124213);
            if (e.1.this.hmC != null) {
              e.1.this.hmC.Ws();
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
  
  public static String TG()
  {
    synchronized (hzq)
    {
      String str = eul;
      return str;
    }
  }
  
  public static c a(c paramc, long paramLong)
  {
    AppMethodBeat.i(124225);
    if (paramc == null) {}
    for (long l = -1L;; l = paramc.field_bizChatLocalId)
    {
      ac.w("MicroMsg.BizChatInfoStorageLogic", "protectBizChatNotExist bizChatId:%s BizChatInfo:%s ", new Object[] { Long.valueOf(paramLong), Long.valueOf(l) });
      c localc = paramc;
      if (paramc == null)
      {
        paramc = new c();
        paramc.field_bizChatLocalId = paramLong;
        af.aCY().b(paramc);
        localc = af.aCY().bd(paramLong);
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
      ac.w("MicroMsg.BizChatInfoStorageLogic", "protectBizChatNotExist userId:%s BizChatUserInfo:%s ", new Object[] { paramString, localObject });
      localObject = paramk;
      if (paramk != null) {
        break;
      }
      k localk = new k();
      localk.field_userId = paramString;
      af.aDa().b(localk);
      paramk = af.aDa().dP(paramString);
      localObject = paramk;
      if (paramk != null) {
        break;
      }
      ac.e("MicroMsg.BizChatInfoStorageLogic", "protectContactNotExist contact get from db is null!");
      AppMethodBeat.o(124226);
      return localk;
    }
    AppMethodBeat.o(124226);
    return localObject;
  }
  
  public static boolean a(c paramc, String paramString1, String paramString2, apz paramapz)
  {
    AppMethodBeat.i(124238);
    if ((paramString1 != null) && (!bs.isNullOrNil(paramc.field_brandUserName))) {}
    for (;;)
    {
      int i;
      try
      {
        paramString1 = new JSONArray(paramString1);
        if ((paramString1.length() == 1) && (bs.isNullOrNil(paramString2)))
        {
          paramString2 = paramString1.getJSONObject(0);
          paramapz = paramString2.getString("id");
          paramString1 = af.aDa().dP(paramapz);
          if (paramString1 != null) {
            break label564;
          }
          paramString1 = new k();
          i = 1;
          paramString1.field_userId = paramapz;
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
          if (!af.aDa().b(paramString1)) {
            af.aDa().a(paramString1);
          }
          if (i != 0) {
            af.aDe().bh(paramString1.field_userId, paramString1.field_brandUserName);
          }
          paramString2 = new c();
          paramString2.field_bizChatServId = paramString1.field_userId;
          paramString2.field_brandUserName = paramString1.field_brandUserName;
          paramString2.field_chatName = paramString1.field_userName;
          paramString2.field_chatType = j.hzN.hzQ;
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
        if (bs.isNullOrNil(paramString2)) {
          break label570;
        }
        localObject = new mm();
        ((mm)localObject).Ebt = paramString2;
        localLinkedList.add(localObject);
      }
      catch (JSONException paramc)
      {
        LinkedList localLinkedList;
        Object localObject;
        ac.i("MicroMsg.BizChatInfoStorageLogic", "parse memberJson Exception:%s", new Object[] { paramc.getMessage() });
        ac.printErrStackTrace("MicroMsg.BizChatInfoStorageLogic", paramc, "", new Object[0]);
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
        if (!af.aDa().b(paramString2)) {
          af.aDa().a(paramString2);
        }
        localObject = new mm();
        ((mm)localObject).Ebt = paramString2.field_userId;
        localLinkedList.add(localObject);
        i += 1;
      }
      else
      {
        paramapz.Ebu = localLinkedList;
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
    List localList = paramc.aDl();
    paramc = ((com.tencent.mm.api.k)com.tencent.mm.kernel.g.ab(com.tencent.mm.api.k.class)).dQ(paramc.field_brandUserName);
    if (paramc == null)
    {
      ac.w("MicroMsg.BaseBizChatInfo", "bizchat myUserId is null");
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
    ac.w("MicroMsg.BaseBizChatInfo", "bizchat not in chatroom myUserId is %s", new Object[] { paramc });
    ac.w("MicroMsg.BaseBizChatInfo", "bizchat not in chatroom memberlist is %s", new Object[] { Arrays.toString(localList.toArray()) });
    AppMethodBeat.o(124220);
    return false;
  }
  
  public static String d(c paramc)
  {
    AppMethodBeat.i(124229);
    if (paramc == null)
    {
      ac.w("MicroMsg.BizChatInfoStorageLogic", "getMsgSource bizChatInfo=%s");
      AppMethodBeat.o(124229);
      return null;
    }
    ac.d("MicroMsg.BizChatInfoStorageLogic", "format msgSource");
    if (paramc.field_bizChatServId == null)
    {
      ac.d("MicroMsg.BizChatInfoStorageLogic", "getMsgSource field_bizChatId=%s", new Object[] { paramc.field_bizChatServId });
      AppMethodBeat.o(124229);
      return null;
    }
    Object localObject2 = Bu(paramc.field_brandUserName);
    if ((localObject2 == null) || (((k)localObject2).field_userId == null))
    {
      ac.d("MicroMsg.BizChatInfoStorageLogic", " bizChatMyUserInfo.field_userId is null getMsgSource field_bizChatId=%s", new Object[] { paramc.field_bizChatServId });
      AppMethodBeat.o(124229);
      return null;
    }
    synchronized (hzq)
    {
      String str1 = paramc.field_bizChatServId;
      int i = paramc.field_chatVersion;
      String str2 = ((k)localObject2).field_userId;
      long l = paramc.field_bizChatLocalId;
      paramc = ((k)localObject2).field_userId;
      localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append(2);
      ((StringBuilder)localObject2).append(bs.aNx());
      ((StringBuilder)localObject2).append(paramc);
      ((StringBuilder)localObject2).append(e.a.hzw.nextInt());
      eul = String.format("<msgsource><enterprise_info><qy_msg_type>%d</qy_msg_type><bizchat_id>%s</bizchat_id><bizchat_ver>%d</bizchat_ver><user_id>%s</user_id><climsgid>%s</climsgid></enterprise_info></msgsource>", new Object[] { Integer.valueOf(1), str1, Integer.valueOf(i), str2, Long.valueOf(l), ((StringBuilder)localObject2).toString() });
      ac.d("MicroMsg.BizChatInfoStorageLogic", "send msgSource:%s", new Object[] { eul });
      paramc = eul;
      AppMethodBeat.o(124229);
      return paramc;
    }
  }
  
  public static String dw(String paramString)
  {
    AppMethodBeat.i(124236);
    paramString = com.tencent.mm.api.a.dw(paramString);
    AppMethodBeat.o(124236);
    return paramString;
  }
  
  public static c e(c paramc)
  {
    AppMethodBeat.i(124230);
    if (paramc.field_bizChatServId == null)
    {
      AppMethodBeat.o(124230);
      return null;
    }
    c localc2 = af.aCY().Bp(paramc.field_bizChatServId);
    c localc1;
    if (localc2 != null)
    {
      if ((paramc.field_chatVersion <= localc2.field_chatVersion) && (!bs.isNullOrNil(localc2.field_brandUserName))) {
        break label159;
      }
      if (!bs.isNullOrNil(paramc.field_chatName)) {
        localc2.field_chatName = paramc.field_chatName;
      }
      localc2.field_brandUserName = paramc.field_brandUserName;
      localc2.field_needToUpdate = true;
      localc2.field_chatType = paramc.field_chatType;
      af.aCY().b(localc2);
      localc1 = localc2;
      if (localc1.aDm())
      {
        if (!localc1.isGroup()) {
          break label164;
        }
        af.aDe().be(localc1.field_bizChatServId, localc1.field_brandUserName);
      }
    }
    for (;;)
    {
      AppMethodBeat.o(124230);
      return localc1;
      paramc.field_needToUpdate = true;
      localc1 = paramc;
      if (af.aCY().a(paramc)) {
        break;
      }
      label159:
      localc1 = localc2;
      break;
      label164:
      af.aDe().bg(localc1.field_bizChatServId, localc1.field_brandUserName);
    }
  }
  
  public static boolean f(c paramc)
  {
    AppMethodBeat.i(124231);
    ac.d("MicroMsg.BizChatInfoStorageLogic", "updateBizChatMember");
    if (paramc == null)
    {
      ac.w("MicroMsg.BizChatInfoStorageLogic", "updateBizChatMember: bizChatInfo == null");
      AppMethodBeat.o(124231);
      return false;
    }
    Object localObject = paramc.aDl();
    if (localObject == null)
    {
      ac.w("MicroMsg.BizChatInfoStorageLogic", "updateBizChatMember: list == null");
      AppMethodBeat.o(124231);
      return false;
    }
    LinkedList localLinkedList = new LinkedList();
    localObject = ((List)localObject).iterator();
    while (((Iterator)localObject).hasNext())
    {
      String str = (String)((Iterator)localObject).next();
      k localk = af.aDa().dP(str);
      if ((localk != null) && (localk.aDm())) {
        localLinkedList.add(str);
      }
    }
    if (localLinkedList.size() > 0)
    {
      af.aDe().c(localLinkedList, paramc.field_brandUserName);
      AppMethodBeat.o(124231);
      return true;
    }
    ac.w("MicroMsg.BizChatInfoStorageLogic", "updateBizChatMember: no need to update");
    AppMethodBeat.o(124231);
    return false;
  }
  
  public static void g(c paramc)
  {
    AppMethodBeat.i(124239);
    if (paramc == null)
    {
      ac.w("MicroMsg.BizChatInfoStorageLogic", "bizChatInfo is null");
      AppMethodBeat.o(124239);
      return;
    }
    boolean bool1 = af.aCZ().pW(paramc.field_bizChatLocalId);
    boolean bool2 = paramc.hc(16);
    ac.d("MicroMsg.BizChatInfoStorageLogic", "convPlaceTop: %s ,bizChatPlaceTop: %s, chatName: %s ", new Object[] { Boolean.valueOf(bool1), Boolean.valueOf(bool2), paramc.field_chatName });
    if ((bool2) && (!bool1))
    {
      af.aCZ().pX(paramc.field_bizChatLocalId);
      AppMethodBeat.o(124239);
      return;
    }
    if ((!bool2) && (bool1)) {
      af.aCZ().pY(paramc.field_bizChatLocalId);
    }
    AppMethodBeat.o(124239);
  }
  
  public static void h(c paramc)
  {
    AppMethodBeat.i(124240);
    if (paramc == null)
    {
      ac.w("MicroMsg.BizChatInfoStorageLogic", "updateBrandUserConvName bizChatInfo is null");
      AppMethodBeat.o(124240);
      return;
    }
    com.tencent.mm.storage.ap localap = ((com.tencent.mm.plugin.messenger.foundation.a.k)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.messenger.foundation.a.k.class)).awG().aNI(paramc.field_brandUserName);
    if (localap == null)
    {
      ac.w("MicroMsg.BizChatInfoStorageLogic", "updateBrandUserConvName cvs is null");
      AppMethodBeat.o(124240);
      return;
    }
    Object localObject1 = ((com.tencent.mm.plugin.messenger.foundation.a.k)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.messenger.foundation.a.k.class)).dcr().alk(paramc.field_brandUserName);
    Object localObject2 = ((com.tencent.mm.al.p)com.tencent.mm.kernel.g.ab(com.tencent.mm.al.p.class)).awE().bW(paramc.field_brandUserName, paramc.field_bizChatLocalId);
    if ((localObject1 != null) && (localObject2 != null) && (((dy)localObject1).field_msgId == ((dy)localObject2).field_msgId))
    {
      localObject2 = localap.field_digest;
      if (localObject2 != null)
      {
        int i = ((String)localObject2).indexOf(":");
        if (i != -1)
        {
          localObject1 = ((String)localObject2).substring(0, i);
          localObject2 = ((String)localObject2).substring(i + 1);
          if ((localObject1 != null) && (!((String)localObject1).equals(paramc.field_chatName)))
          {
            localap.qR(paramc.field_chatName + ":" + (String)localObject2);
            ((com.tencent.mm.plugin.messenger.foundation.a.k)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.messenger.foundation.a.k.class)).awG().a(localap, localap.field_username);
          }
        }
      }
    }
    AppMethodBeat.o(124240);
  }
  
  public static void o(final String paramString1, String paramString2, final String paramString3)
  {
    AppMethodBeat.i(124235);
    ac.i("MicroMsg.BizChatInfoStorageLogic", "qy_chat_update %s, %s, %s", new Object[] { paramString1, paramString2, paramString3 });
    com.tencent.mm.kernel.g.agU().az(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(124216);
        c localc = af.aCY().Bp(this.hzu);
        if (localc == null)
        {
          AppMethodBeat.o(124216);
          return;
        }
        if (localc.field_chatVersion < bs.getInt(paramString3, 2147483647))
        {
          localc.field_needToUpdate = true;
          af.aCY().b(localc);
        }
        if (localc.isGroup())
        {
          af.aDe().be(localc.field_bizChatServId, paramString1);
          AppMethodBeat.o(124216);
          return;
        }
        af.aDe().bg(localc.field_bizChatServId, paramString1);
        AppMethodBeat.o(124216);
      }
    });
    AppMethodBeat.o(124235);
  }
  
  public static int pZ(long paramLong)
  {
    AppMethodBeat.i(124221);
    List localList = qa(paramLong);
    if (localList != null)
    {
      int i = localList.size();
      AppMethodBeat.o(124221);
      return i;
    }
    ac.w("MicroMsg.BizChatInfoStorageLogic", "getMembersCountByBizChatId list == null");
    AppMethodBeat.o(124221);
    return 0;
  }
  
  public static List<String> qa(long paramLong)
  {
    AppMethodBeat.i(124222);
    List localList = af.aCY().bd(paramLong).aDl();
    AppMethodBeat.o(124222);
    return localList;
  }
  
  public static String qb(long paramLong)
  {
    AppMethodBeat.i(124232);
    String str = af.aCY().bd(paramLong).field_bizChatServId;
    AppMethodBeat.o(124232);
    return str;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.al.a.e
 * JD-Core Version:    0.7.0.1
 */