package com.tencent.mm.am.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.am.af;
import com.tencent.mm.g.c.ay;
import com.tencent.mm.g.c.du;
import com.tencent.mm.model.bi.a;
import com.tencent.mm.protocal.protobuf.amv;
import com.tencent.mm.protocal.protobuf.mf;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.aq;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.storage.am;
import com.tencent.mm.storage.bh;
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
  public static String esh;
  public static final Object gYR;
  
  static
  {
    AppMethodBeat.i(124241);
    esh = null;
    gYR = new Object();
    AppMethodBeat.o(124241);
  }
  
  public static void M(String paramString, final boolean paramBoolean)
  {
    AppMethodBeat.i(124234);
    if (bt.isNullOrNil(paramString))
    {
      ad.d("MicroMsg.BizChatInfoStorageLogic", "delEnterpriseChatConvAndHeadImg, empty brandUserName");
      AppMethodBeat.o(124234);
      return;
    }
    ad.d("MicroMsg.BizChatInfoStorageLogic", "deleteMsgByTalkers");
    com.tencent.mm.kernel.g.afE().ax(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(124214);
        Object localObject1 = af.awh();
        Object localObject2 = this.gYS;
        Object localObject3 = new StringBuilder();
        ((StringBuilder)localObject3).append("delete from BizChatConversation");
        ((StringBuilder)localObject3).append(" where brandUserName = '").append((String)localObject2).append("' ");
        localObject3 = ((StringBuilder)localObject3).toString();
        boolean bool = ((b)localObject1).db.execSQL("BizChatConversation", (String)localObject3);
        ad.i("MicroMsg.BizConversationStorage", "deleteByBrandUserName sql %s,%s", new Object[] { localObject3, Boolean.valueOf(bool) });
        Object localObject4;
        if (bool)
        {
          localObject3 = new a();
          localObject4 = new b.a.b();
          ((b.a.b)localObject4).gYF = -1L;
          ((b.a.b)localObject4).dfM = ((String)localObject2);
          ((b.a.b)localObject4).gYE = b.a.a.gYB;
          ((b.a.b)localObject4).gYG = ((a)localObject3);
          ((b)localObject1).gWR.dR(localObject4);
          ((b)localObject1).gWR.doNotify();
        }
        ((com.tencent.mm.plugin.messenger.foundation.a.k)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.messenger.foundation.a.k.class)).apR().aIl(this.gYS);
        localObject1 = af.awg();
        localObject2 = this.gYS;
        localObject3 = new StringBuilder();
        ((StringBuilder)localObject3).append("delete from BizChatInfo");
        ((StringBuilder)localObject3).append(" where brandUserName = '").append((String)localObject2).append("' ");
        localObject3 = ((StringBuilder)localObject3).toString();
        bool = ((d)localObject1).db.execSQL("BizChatInfo", (String)localObject3);
        ad.i("MicroMsg.BizChatInfoStorage", "deleteByBrandUserName sql %s,%s", new Object[] { localObject3, Boolean.valueOf(bool) });
        if (bool)
        {
          localObject3 = new c();
          localObject4 = new d.a.b();
          ((d.a.b)localObject4).gYF = -1L;
          ((d.a.b)localObject4).dfM = ((String)localObject2);
          ((d.a.b)localObject4).gYP = d.a.a.gYM;
          ((d.a.b)localObject4).gYQ = ((c)localObject3);
          ((d)localObject1).gWR.dR(localObject4);
          ((d)localObject1).gWR.doNotify();
        }
        i.cO(e.dH(this.gYS), true);
        if (paramBoolean)
        {
          localObject1 = af.awi();
          localObject2 = this.gYS;
          localObject3 = new StringBuilder();
          ((StringBuilder)localObject3).append("delete from BizChatUserInfo");
          ((StringBuilder)localObject3).append(" where brandUserName = '").append((String)localObject2).append("' ");
          localObject2 = ((StringBuilder)localObject3).toString();
          bool = ((l)localObject1).db.execSQL("BizChatUserInfo", (String)localObject2);
          ad.i("MicroMsg.BizChatUserInfoStorage", "deleteByBrandUserName sql %s,%s", new Object[] { localObject2, Boolean.valueOf(bool) });
          if (bool)
          {
            localObject2 = new k();
            localObject3 = new l.a.b();
            ((l.a.b)localObject3).gZy = l.a.a.gZv;
            ((l.a.b)localObject3).gZz = ((k)localObject2);
            ((l)localObject1).gWR.dR(localObject3);
            ((l)localObject1).gWR.doNotify();
          }
          af.awj().xu(this.gYS);
          i.cO(e.xs(this.gYS), true);
        }
        aq.f(new Runnable()
        {
          public final void run()
          {
            AppMethodBeat.i(124213);
            if (e.1.this.gMc != null) {
              e.1.this.gMc.Vu();
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
  
  public static String SM()
  {
    synchronized (gYR)
    {
      String str = esh;
      return str;
    }
  }
  
  public static c a(c paramc, long paramLong)
  {
    AppMethodBeat.i(124225);
    if (paramc == null) {}
    for (long l = -1L;; l = paramc.field_bizChatLocalId)
    {
      ad.w("MicroMsg.BizChatInfoStorageLogic", "protectBizChatNotExist bizChatId:%s BizChatInfo:%s ", new Object[] { Long.valueOf(paramLong), Long.valueOf(l) });
      c localc = paramc;
      if (paramc == null)
      {
        paramc = new c();
        paramc.field_bizChatLocalId = paramLong;
        af.awg().b(paramc);
        localc = af.awg().bg(paramLong);
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
      ad.w("MicroMsg.BizChatInfoStorageLogic", "protectBizChatNotExist userId:%s BizChatUserInfo:%s ", new Object[] { paramString, localObject });
      localObject = paramk;
      if (paramk != null) {
        break;
      }
      k localk = new k();
      localk.field_userId = paramString;
      af.awi().b(localk);
      paramk = af.awi().ea(paramString);
      localObject = paramk;
      if (paramk != null) {
        break;
      }
      ad.e("MicroMsg.BizChatInfoStorageLogic", "protectContactNotExist contact get from db is null!");
      AppMethodBeat.o(124226);
      return localk;
    }
    AppMethodBeat.o(124226);
    return localObject;
  }
  
  public static boolean a(c paramc, String paramString1, String paramString2, amv paramamv)
  {
    AppMethodBeat.i(124238);
    if ((paramString1 != null) && (!bt.isNullOrNil(paramc.field_brandUserName))) {}
    for (;;)
    {
      int i;
      try
      {
        paramString1 = new JSONArray(paramString1);
        if ((paramString1.length() == 1) && (bt.isNullOrNil(paramString2)))
        {
          paramString2 = paramString1.getJSONObject(0);
          paramamv = paramString2.getString("id");
          paramString1 = af.awi().ea(paramamv);
          if (paramString1 != null) {
            break label549;
          }
          paramString1 = new k();
          i = 1;
          paramString1.field_userId = paramamv;
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
          if (!af.awi().b(paramString1)) {
            af.awi().a(paramString1);
          }
          if (i != 0) {
            af.awm().aZ(paramString1.field_userId, paramString1.field_brandUserName);
          }
          paramString2 = new c();
          paramString2.field_bizChatServId = paramString1.field_userId;
          paramString2.field_brandUserName = paramString1.field_brandUserName;
          paramString2.field_chatName = paramString1.field_userName;
          paramString2.field_chatType = j.gZo.gZr;
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
        if (bt.isNullOrNil(paramString2)) {
          break label555;
        }
        localObject = new mf();
        ((mf)localObject).CIR = paramString2;
        localLinkedList.add(localObject);
      }
      catch (JSONException paramc)
      {
        LinkedList localLinkedList;
        Object localObject;
        ad.i("MicroMsg.BizChatInfoStorageLogic", "parse memberJson Exception:%s", new Object[] { paramc.getMessage() });
        ad.printErrStackTrace("MicroMsg.BizChatInfoStorageLogic", paramc, "", new Object[0]);
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
        if (!af.awi().b(paramString2)) {
          af.awi().a(paramString2);
        }
        localObject = new mf();
        ((mf)localObject).CIR = paramString2.field_userId;
        localLinkedList.add(localObject);
        i += 1;
      }
      else
      {
        paramamv.CIS = localLinkedList;
        paramc.field_bizChatLocalId = -1L;
        AppMethodBeat.o(124238);
        return true;
        AppMethodBeat.o(124238);
        return false;
        label549:
        i = 0;
        continue;
        label555:
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
    List localList = paramc.awt();
    paramc = ((com.tencent.mm.api.k)com.tencent.mm.kernel.g.ab(com.tencent.mm.api.k.class)).eb(paramc.field_brandUserName);
    if (paramc == null)
    {
      ad.w("MicroMsg.BaseBizChatInfo", "bizchat myUserId is null");
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
    ad.w("MicroMsg.BaseBizChatInfo", "bizchat not in chatroom myUserId is %s", new Object[] { paramc });
    ad.w("MicroMsg.BaseBizChatInfo", "bizchat not in chatroom memberlist is %s", new Object[] { Arrays.toString(localList.toArray()) });
    AppMethodBeat.o(124220);
    return false;
  }
  
  public static String d(c paramc)
  {
    AppMethodBeat.i(124229);
    if (paramc == null)
    {
      ad.w("MicroMsg.BizChatInfoStorageLogic", "getMsgSource bizChatInfo=%s");
      AppMethodBeat.o(124229);
      return null;
    }
    ad.d("MicroMsg.BizChatInfoStorageLogic", "format msgSource");
    if (paramc.field_bizChatServId == null)
    {
      ad.d("MicroMsg.BizChatInfoStorageLogic", "getMsgSource field_bizChatId=%s", new Object[] { paramc.field_bizChatServId });
      AppMethodBeat.o(124229);
      return null;
    }
    Object localObject2 = xo(paramc.field_brandUserName);
    if ((localObject2 == null) || (((k)localObject2).field_userId == null))
    {
      ad.d("MicroMsg.BizChatInfoStorageLogic", " bizChatMyUserInfo.field_userId is null getMsgSource field_bizChatId=%s", new Object[] { paramc.field_bizChatServId });
      AppMethodBeat.o(124229);
      return null;
    }
    synchronized (gYR)
    {
      String str1 = paramc.field_bizChatServId;
      int i = paramc.field_chatVersion;
      String str2 = ((k)localObject2).field_userId;
      long l = paramc.field_bizChatLocalId;
      paramc = ((k)localObject2).field_userId;
      localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append(2);
      ((StringBuilder)localObject2).append(bt.aGK());
      ((StringBuilder)localObject2).append(paramc);
      ((StringBuilder)localObject2).append(a.gYX.nextInt());
      esh = String.format("<msgsource><enterprise_info><qy_msg_type>%d</qy_msg_type><bizchat_id>%s</bizchat_id><bizchat_ver>%d</bizchat_ver><user_id>%s</user_id><climsgid>%s</climsgid></enterprise_info></msgsource>", new Object[] { Integer.valueOf(1), str1, Integer.valueOf(i), str2, Long.valueOf(l), ((StringBuilder)localObject2).toString() });
      ad.d("MicroMsg.BizChatInfoStorageLogic", "send msgSource:%s", new Object[] { esh });
      paramc = esh;
      AppMethodBeat.o(124229);
      return paramc;
    }
  }
  
  public static String dH(String paramString)
  {
    AppMethodBeat.i(124236);
    paramString = com.tencent.mm.api.a.dH(paramString);
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
    c localc2 = af.awg().xj(paramc.field_bizChatServId);
    c localc1;
    if (localc2 != null)
    {
      if ((paramc.field_chatVersion <= localc2.field_chatVersion) && (!bt.isNullOrNil(localc2.field_brandUserName))) {
        break label159;
      }
      if (!bt.isNullOrNil(paramc.field_chatName)) {
        localc2.field_chatName = paramc.field_chatName;
      }
      localc2.field_brandUserName = paramc.field_brandUserName;
      localc2.field_needToUpdate = true;
      localc2.field_chatType = paramc.field_chatType;
      af.awg().b(localc2);
      localc1 = localc2;
      if (localc1.awu())
      {
        if (!localc1.isGroup()) {
          break label164;
        }
        af.awm().aW(localc1.field_bizChatServId, localc1.field_brandUserName);
      }
    }
    for (;;)
    {
      AppMethodBeat.o(124230);
      return localc1;
      paramc.field_needToUpdate = true;
      localc1 = paramc;
      if (af.awg().a(paramc)) {
        break;
      }
      label159:
      localc1 = localc2;
      break;
      label164:
      af.awm().aY(localc1.field_bizChatServId, localc1.field_brandUserName);
    }
  }
  
  public static boolean f(c paramc)
  {
    AppMethodBeat.i(124231);
    ad.d("MicroMsg.BizChatInfoStorageLogic", "updateBizChatMember");
    if (paramc == null)
    {
      ad.w("MicroMsg.BizChatInfoStorageLogic", "updateBizChatMember: bizChatInfo == null");
      AppMethodBeat.o(124231);
      return false;
    }
    Object localObject = paramc.awt();
    if (localObject == null)
    {
      ad.w("MicroMsg.BizChatInfoStorageLogic", "updateBizChatMember: list == null");
      AppMethodBeat.o(124231);
      return false;
    }
    LinkedList localLinkedList = new LinkedList();
    localObject = ((List)localObject).iterator();
    while (((Iterator)localObject).hasNext())
    {
      String str = (String)((Iterator)localObject).next();
      k localk = af.awi().ea(str);
      if ((localk != null) && (localk.awu())) {
        localLinkedList.add(str);
      }
    }
    if (localLinkedList.size() > 0)
    {
      af.awm().b(localLinkedList, paramc.field_brandUserName);
      AppMethodBeat.o(124231);
      return true;
    }
    ad.w("MicroMsg.BizChatInfoStorageLogic", "updateBizChatMember: no need to update");
    AppMethodBeat.o(124231);
    return false;
  }
  
  public static void g(c paramc)
  {
    AppMethodBeat.i(124239);
    if (paramc == null)
    {
      ad.w("MicroMsg.BizChatInfoStorageLogic", "bizChatInfo is null");
      AppMethodBeat.o(124239);
      return;
    }
    boolean bool1 = af.awh().mi(paramc.field_bizChatLocalId);
    boolean bool2 = paramc.ht(16);
    ad.d("MicroMsg.BizChatInfoStorageLogic", "convPlaceTop: %s ,bizChatPlaceTop: %s, chatName: %s ", new Object[] { Boolean.valueOf(bool1), Boolean.valueOf(bool2), paramc.field_chatName });
    if ((bool2) && (!bool1))
    {
      af.awh().mj(paramc.field_bizChatLocalId);
      AppMethodBeat.o(124239);
      return;
    }
    if ((!bool2) && (bool1)) {
      af.awh().mk(paramc.field_bizChatLocalId);
    }
    AppMethodBeat.o(124239);
  }
  
  public static void h(c paramc)
  {
    AppMethodBeat.i(124240);
    if (paramc == null)
    {
      ad.w("MicroMsg.BizChatInfoStorageLogic", "updateBrandUserConvName bizChatInfo is null");
      AppMethodBeat.o(124240);
      return;
    }
    am localam = ((com.tencent.mm.plugin.messenger.foundation.a.k)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.messenger.foundation.a.k.class)).apR().aIn(paramc.field_brandUserName);
    if (localam == null)
    {
      ad.w("MicroMsg.BizChatInfoStorageLogic", "updateBrandUserConvName cvs is null");
      AppMethodBeat.o(124240);
      return;
    }
    Object localObject1 = ((com.tencent.mm.plugin.messenger.foundation.a.k)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.messenger.foundation.a.k.class)).cOI().agq(paramc.field_brandUserName);
    Object localObject2 = ((com.tencent.mm.am.p)com.tencent.mm.kernel.g.ab(com.tencent.mm.am.p.class)).apP().bU(paramc.field_brandUserName, paramc.field_bizChatLocalId);
    if ((localObject1 != null) && (localObject2 != null) && (((du)localObject1).field_msgId == ((du)localObject2).field_msgId))
    {
      localObject2 = localam.field_digest;
      if (localObject2 != null)
      {
        int i = ((String)localObject2).indexOf(":");
        if (i != -1)
        {
          localObject1 = ((String)localObject2).substring(0, i);
          localObject2 = ((String)localObject2).substring(i + 1);
          if ((localObject1 != null) && (!((String)localObject1).equals(paramc.field_chatName)))
          {
            localam.nL(paramc.field_chatName + ":" + (String)localObject2);
            ((com.tencent.mm.plugin.messenger.foundation.a.k)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.messenger.foundation.a.k.class)).apR().a(localam, localam.field_username);
          }
        }
      }
    }
    AppMethodBeat.o(124240);
  }
  
  public static int ml(long paramLong)
  {
    AppMethodBeat.i(124221);
    List localList = mm(paramLong);
    if (localList != null)
    {
      int i = localList.size();
      AppMethodBeat.o(124221);
      return i;
    }
    ad.w("MicroMsg.BizChatInfoStorageLogic", "getMembersCountByBizChatId list == null");
    AppMethodBeat.o(124221);
    return 0;
  }
  
  public static List<String> mm(long paramLong)
  {
    AppMethodBeat.i(124222);
    List localList = af.awg().bg(paramLong).awt();
    AppMethodBeat.o(124222);
    return localList;
  }
  
  public static String mn(long paramLong)
  {
    AppMethodBeat.i(124232);
    String str = af.awg().bg(paramLong).field_bizChatServId;
    AppMethodBeat.o(124232);
    return str;
  }
  
  public static void o(final String paramString1, String paramString2, final String paramString3)
  {
    AppMethodBeat.i(124235);
    ad.i("MicroMsg.BizChatInfoStorageLogic", "qy_chat_update %s, %s, %s", new Object[] { paramString1, paramString2, paramString3 });
    com.tencent.mm.kernel.g.afE().ax(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(124216);
        c localc = af.awg().xj(this.gYV);
        if (localc == null)
        {
          AppMethodBeat.o(124216);
          return;
        }
        if (localc.field_chatVersion < bt.getInt(paramString3, 2147483647))
        {
          localc.field_needToUpdate = true;
          af.awg().b(localc);
        }
        if (localc.isGroup())
        {
          af.awm().aW(localc.field_bizChatServId, paramString1);
          AppMethodBeat.o(124216);
          return;
        }
        af.awm().aY(localc.field_bizChatServId, paramString1);
        AppMethodBeat.o(124216);
      }
    });
    AppMethodBeat.o(124235);
  }
  
  public static boolean xk(String paramString)
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
  
  public static boolean xl(String paramString)
  {
    AppMethodBeat.i(124219);
    if (paramString == null)
    {
      ad.i("MicroMsg.BizChatInfoStorageLogic", "isGroupChat chatId == null");
      AppMethodBeat.o(124219);
      return false;
    }
    boolean bool = paramString.endsWith("@qy_g");
    AppMethodBeat.o(124219);
    return bool;
  }
  
  public static String xm(String paramString)
  {
    AppMethodBeat.i(124223);
    if (paramString == null)
    {
      ad.w("MicroMsg.BizChatInfoStorageLogic", "getUserName bizChatId == null");
      AppMethodBeat.o(124223);
      return null;
    }
    paramString = af.awi().ea(paramString);
    if (paramString != null)
    {
      paramString = paramString.field_userName;
      AppMethodBeat.o(124223);
      return paramString;
    }
    ad.i("MicroMsg.BizChatInfoStorageLogic", "getUserName userInfo == null");
    AppMethodBeat.o(124223);
    return null;
  }
  
  public static String xn(String paramString)
  {
    AppMethodBeat.i(124224);
    paramString = af.awi().ea(paramString);
    if (paramString != null)
    {
      paramString = paramString.field_headImageUrl;
      AppMethodBeat.o(124224);
      return paramString;
    }
    AppMethodBeat.o(124224);
    return null;
  }
  
  public static k xo(String paramString)
  {
    AppMethodBeat.i(124227);
    if (bt.isNullOrNil(paramString))
    {
      ad.w("MicroMsg.BizChatInfoStorageLogic", "getBizChatMyUserInfo brandUserName==null");
      AppMethodBeat.o(124227);
      return null;
    }
    paramString = af.awj().xt(paramString);
    if (paramString == null)
    {
      ad.w("MicroMsg.BizChatInfoStorageLogic", "getBizChatMyUserInfo bizChatMyUserInfo==null");
      AppMethodBeat.o(124227);
      return null;
    }
    paramString = af.awi().ea(paramString.field_userId);
    if (paramString == null) {
      ad.w("MicroMsg.BizChatInfoStorageLogic", "getBizChatMyUserInfo bizChatUserInfo==null");
    }
    AppMethodBeat.o(124227);
    return paramString;
  }
  
  public static String xp(String paramString)
  {
    AppMethodBeat.i(124228);
    if (paramString == null)
    {
      ad.w("MicroMsg.BizChatInfoStorageLogic", "getFormatMsgSource msgSource==null");
      AppMethodBeat.o(124228);
      return null;
    }
    int i = paramString.indexOf("<enterprise_info>") + 17;
    int j = paramString.indexOf("</enterprise_info>");
    if ((i == -1) || (j == -1) || (i >= j))
    {
      ad.w("MicroMsg.BizChatInfoStorageLogic", "getFormatMsgSource error start:%s,end:%s", new Object[] { Integer.valueOf(i), Integer.valueOf(j) });
      AppMethodBeat.o(124228);
      return null;
    }
    String str = paramString.substring(i, j);
    paramString = paramString.replace(str, str.replace("<", "&lt;").replace(">", "&gt;"));
    AppMethodBeat.o(124228);
    return paramString;
  }
  
  public static void xq(String paramString)
  {
    synchronized (gYR)
    {
      esh = paramString;
      return;
    }
  }
  
  public static long xr(String paramString)
  {
    AppMethodBeat.i(124233);
    if (bt.isNullOrNil(paramString))
    {
      ad.w("MicroMsg.BizChatInfoStorageLogic", "chatId == null");
      AppMethodBeat.o(124233);
      return -1L;
    }
    paramString = af.awg().xj(paramString);
    if (paramString != null)
    {
      long l = paramString.field_bizChatLocalId;
      AppMethodBeat.o(124233);
      return l;
    }
    ad.w("MicroMsg.BizChatInfoStorageLogic", "bizChatInfo == null");
    AppMethodBeat.o(124233);
    return -1L;
  }
  
  public static String xs(String paramString)
  {
    AppMethodBeat.i(124237);
    String str = paramString;
    if (bt.isNullOrNil(paramString)) {
      str = "tempUser";
    }
    paramString = new StringBuilder(com.tencent.mm.plugin.image.d.apX());
    paramString.append(com.tencent.mm.b.g.getMessageDigest(str.getBytes())).append("/");
    paramString.append("user/");
    paramString = paramString.toString();
    AppMethodBeat.o(124237);
    return paramString;
  }
  
  static final class a
  {
    static final Random gYX;
    
    static
    {
      AppMethodBeat.i(124217);
      gYX = new Random(bt.eGO());
      AppMethodBeat.o(124217);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.am.a.e
 * JD-Core Version:    0.7.0.1
 */