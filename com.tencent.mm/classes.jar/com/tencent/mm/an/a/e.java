package com.tencent.mm.an.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.an.af;
import com.tencent.mm.an.q;
import com.tencent.mm.api.a;
import com.tencent.mm.api.m;
import com.tencent.mm.autogen.b.bd;
import com.tencent.mm.autogen.b.fi;
import com.tencent.mm.model.br.a;
import com.tencent.mm.plugin.messenger.foundation.a.a.i;
import com.tencent.mm.plugin.messenger.foundation.a.n;
import com.tencent.mm.protocal.protobuf.cam;
import com.tencent.mm.protocal.protobuf.or;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMHandlerThread;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.sdk.storage.ISQLiteDatabase;
import com.tencent.mm.sdk.storage.MStorageEvent;
import com.tencent.mm.storage.bb;
import com.tencent.mm.storage.by;
import com.tencent.mm.storage.t;
import com.tencent.mm.vfs.y;
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
  public static String jUr;
  public static final Object oxN;
  
  static
  {
    AppMethodBeat.i(124241);
    jUr = null;
    oxN = new Object();
    AppMethodBeat.o(124241);
  }
  
  public static boolean Na(String paramString)
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
  
  public static boolean Nb(String paramString)
  {
    AppMethodBeat.i(124219);
    if (paramString == null)
    {
      Log.i("MicroMsg.BizChatInfoStorageLogic", "isGroupChat chatId == null");
      AppMethodBeat.o(124219);
      return false;
    }
    boolean bool = paramString.endsWith("@qy_g");
    AppMethodBeat.o(124219);
    return bool;
  }
  
  public static String Nc(String paramString)
  {
    AppMethodBeat.i(124223);
    if (paramString == null)
    {
      Log.w("MicroMsg.BizChatInfoStorageLogic", "getUserName bizChatId == null");
      AppMethodBeat.o(124223);
      return null;
    }
    paramString = af.bHj().hM(paramString);
    if (paramString != null)
    {
      paramString = paramString.field_userName;
      AppMethodBeat.o(124223);
      return paramString;
    }
    Log.i("MicroMsg.BizChatInfoStorageLogic", "getUserName userInfo == null");
    AppMethodBeat.o(124223);
    return null;
  }
  
  public static String Nd(String paramString)
  {
    AppMethodBeat.i(124224);
    paramString = af.bHj().hM(paramString);
    if (paramString != null)
    {
      paramString = paramString.field_headImageUrl;
      AppMethodBeat.o(124224);
      return paramString;
    }
    AppMethodBeat.o(124224);
    return null;
  }
  
  public static k Ne(String paramString)
  {
    AppMethodBeat.i(124227);
    if (Util.isNullOrNil(paramString))
    {
      Log.w("MicroMsg.BizChatInfoStorageLogic", "getBizChatMyUserInfo brandUserName==null");
      AppMethodBeat.o(124227);
      return null;
    }
    paramString = af.bHk().Nj(paramString);
    if (paramString == null)
    {
      Log.w("MicroMsg.BizChatInfoStorageLogic", "getBizChatMyUserInfo bizChatMyUserInfo==null");
      AppMethodBeat.o(124227);
      return null;
    }
    paramString = af.bHj().hM(paramString.field_userId);
    if (paramString == null) {
      Log.w("MicroMsg.BizChatInfoStorageLogic", "getBizChatMyUserInfo bizChatUserInfo==null");
    }
    AppMethodBeat.o(124227);
    return paramString;
  }
  
  public static String Nf(String paramString)
  {
    AppMethodBeat.i(124228);
    if (paramString == null)
    {
      Log.w("MicroMsg.BizChatInfoStorageLogic", "getFormatMsgSource msgSource==null");
      AppMethodBeat.o(124228);
      return null;
    }
    int i = paramString.indexOf("<enterprise_info>") + 17;
    int j = paramString.indexOf("</enterprise_info>");
    if ((i == -1) || (j == -1) || (i >= j))
    {
      Log.w("MicroMsg.BizChatInfoStorageLogic", "getFormatMsgSource error start:%s,end:%s", new Object[] { Integer.valueOf(i), Integer.valueOf(j) });
      AppMethodBeat.o(124228);
      return null;
    }
    String str = paramString.substring(i, j);
    paramString = paramString.replace(str, str.replace("<", "&lt;").replace(">", "&gt;"));
    AppMethodBeat.o(124228);
    return paramString;
  }
  
  public static void Ng(String paramString)
  {
    synchronized (oxN)
    {
      jUr = paramString;
      return;
    }
  }
  
  public static long Nh(String paramString)
  {
    AppMethodBeat.i(124233);
    if (Util.isNullOrNil(paramString))
    {
      Log.w("MicroMsg.BizChatInfoStorageLogic", "chatId == null");
      AppMethodBeat.o(124233);
      return -1L;
    }
    paramString = af.bHh().MZ(paramString);
    if (paramString != null)
    {
      long l = paramString.field_bizChatLocalId;
      AppMethodBeat.o(124233);
      return l;
    }
    Log.w("MicroMsg.BizChatInfoStorageLogic", "bizChatInfo == null");
    AppMethodBeat.o(124233);
    return -1L;
  }
  
  public static String Ni(String paramString)
  {
    AppMethodBeat.i(124237);
    String str = paramString;
    if (Util.isNullOrNil(paramString)) {
      str = "tempUser";
    }
    paramString = new StringBuilder(com.tencent.mm.plugin.image.d.bzM());
    paramString.append(com.tencent.mm.b.g.getMessageDigest(str.getBytes())).append("/");
    paramString.append("user/");
    paramString = paramString.toString();
    AppMethodBeat.o(124237);
    return paramString;
  }
  
  public static void V(String paramString, final boolean paramBoolean)
  {
    AppMethodBeat.i(124234);
    if (Util.isNullOrNil(paramString))
    {
      Log.d("MicroMsg.BizChatInfoStorageLogic", "delEnterpriseChatConvAndHeadImg, empty brandUserName");
      AppMethodBeat.o(124234);
      return;
    }
    Log.d("MicroMsg.BizChatInfoStorageLogic", "deleteMsgByTalkers");
    com.tencent.mm.kernel.h.baH().postToWorker(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(124214);
        af.bHi().MV(e.this);
        ((n)com.tencent.mm.kernel.h.ax(n.class)).bzG().bxK(e.this);
        Object localObject1 = af.bHh();
        Object localObject2 = e.this;
        Object localObject3 = new StringBuilder();
        ((StringBuilder)localObject3).append("delete from BizChatInfo");
        ((StringBuilder)localObject3).append(" where brandUserName = '").append((String)localObject2).append("' ");
        localObject3 = ((StringBuilder)localObject3).toString();
        boolean bool = ((d)localObject1).db.execSQL("BizChatInfo", (String)localObject3);
        Log.i("MicroMsg.BizChatInfoStorage", "deleteByBrandUserName sql %s,%s", new Object[] { localObject3, Boolean.valueOf(bool) });
        if (bool)
        {
          localObject3 = new c();
          d.a.b localb = new d.a.b();
          localb.oxB = -1L;
          localb.hEy = ((String)localObject2);
          localb.oxL = d.a.a.oxI;
          localb.oxM = ((c)localObject3);
          ((d)localObject1).ovQ.event(localb);
          ((d)localObject1).ovQ.doNotify();
        }
        y.ew(e.hx(e.this), true);
        if (paramBoolean)
        {
          localObject1 = af.bHj();
          localObject2 = e.this;
          localObject3 = new StringBuilder();
          ((StringBuilder)localObject3).append("delete from BizChatUserInfo");
          ((StringBuilder)localObject3).append(" where brandUserName = '").append((String)localObject2).append("' ");
          localObject2 = ((StringBuilder)localObject3).toString();
          bool = ((l)localObject1).db.execSQL("BizChatUserInfo", (String)localObject2);
          Log.i("MicroMsg.BizChatUserInfoStorage", "deleteByBrandUserName sql %s,%s", new Object[] { localObject2, Boolean.valueOf(bool) });
          if (bool)
          {
            localObject2 = new k();
            localObject3 = new l.a.b();
            ((l.a.b)localObject3).oyu = l.a.a.oyr;
            ((l.a.b)localObject3).oyv = ((k)localObject2);
            ((l)localObject1).ovQ.event(localObject3);
            ((l)localObject1).ovQ.doNotify();
          }
          af.bHk().MV(e.this);
          y.ew(e.Ni(e.this), true);
        }
        MMHandlerThread.postToMainThread(new Runnable()
        {
          public final void run()
          {
            AppMethodBeat.i(124213);
            if (e.1.this.oiY != null) {
              e.1.this.oiY.aMK();
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
  
  public static c a(c paramc, long paramLong)
  {
    AppMethodBeat.i(124225);
    if (paramc == null) {}
    c localc1;
    for (long l = -1L;; l = paramc.field_bizChatLocalId)
    {
      Log.w("MicroMsg.BizChatInfoStorageLogic", "protectBizChatNotExist bizChatId:%s BizChatInfo:%s ", new Object[] { Long.valueOf(paramLong), Long.valueOf(l) });
      localc1 = paramc;
      if (paramc != null) {
        break;
      }
      c localc2 = new c();
      localc2.field_bizChatLocalId = paramLong;
      af.bHh().b(localc2);
      paramc = af.bHh().dW(paramLong);
      localc1 = paramc;
      if (paramc != null) {
        break;
      }
      Log.e("MicroMsg.BizChatInfoStorageLogic", "protectContactNotExist contact get from db is null!");
      AppMethodBeat.o(124225);
      return localc2;
    }
    AppMethodBeat.o(124225);
    return localc1;
  }
  
  public static k a(k paramk, String paramString)
  {
    AppMethodBeat.i(124226);
    if (paramk == null) {}
    for (Object localObject = Integer.valueOf(-1);; localObject = paramk.field_userId)
    {
      Log.w("MicroMsg.BizChatInfoStorageLogic", "protectBizChatNotExist userId:%s BizChatUserInfo:%s ", new Object[] { paramString, localObject });
      localObject = paramk;
      if (paramk != null) {
        break;
      }
      k localk = new k();
      localk.field_userId = paramString;
      af.bHj().b(localk);
      paramk = af.bHj().hM(paramString);
      localObject = paramk;
      if (paramk != null) {
        break;
      }
      Log.e("MicroMsg.BizChatInfoStorageLogic", "protectContactNotExist contact get from db is null!");
      AppMethodBeat.o(124226);
      return localk;
    }
    AppMethodBeat.o(124226);
    return localObject;
  }
  
  public static boolean a(c paramc, String paramString1, String paramString2, cam paramcam)
  {
    AppMethodBeat.i(124238);
    if ((paramString1 != null) && (!Util.isNullOrNil(paramc.field_brandUserName))) {}
    for (;;)
    {
      int i;
      try
      {
        paramString1 = new JSONArray(paramString1);
        if ((paramString1.length() == 1) && (Util.isNullOrNil(paramString2)))
        {
          paramString2 = paramString1.getJSONObject(0);
          paramcam = paramString2.getString("id");
          paramString1 = af.bHj().hM(paramcam);
          if (paramString1 != null) {
            break label564;
          }
          paramString1 = new k();
          i = 1;
          paramString1.field_userId = paramcam;
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
          if (!af.bHj().b(paramString1)) {
            af.bHj().a(paramString1);
          }
          if (i != 0) {
            af.bHp().bB(paramString1.field_userId, paramString1.field_brandUserName);
          }
          paramString2 = new c();
          paramString2.field_bizChatServId = paramString1.field_userId;
          paramString2.field_brandUserName = paramString1.field_brandUserName;
          paramString2.field_chatName = paramString1.field_userName;
          paramString2.field_chatType = j.oyk.oyn;
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
        if (Util.isNullOrNil(paramString2)) {
          break label570;
        }
        localObject = new or();
        ((or)localObject).YRR = paramString2;
        localLinkedList.add(localObject);
      }
      catch (JSONException paramc)
      {
        LinkedList localLinkedList;
        Object localObject;
        Log.i("MicroMsg.BizChatInfoStorageLogic", "parse memberJson Exception:%s", new Object[] { paramc.getMessage() });
        Log.printErrStackTrace("MicroMsg.BizChatInfoStorageLogic", paramc, "", new Object[0]);
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
        if (!af.bHj().b(paramString2)) {
          af.bHj().a(paramString2);
        }
        localObject = new or();
        ((or)localObject).YRR = paramString2.field_userId;
        localLinkedList.add(localObject);
        i += 1;
      }
      else
      {
        paramcam.YRS = localLinkedList;
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
  
  public static String bCQ()
  {
    synchronized (oxN)
    {
      String str = jUr;
      return str;
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
    List localList = paramc.bHw();
    paramc = ((m)com.tencent.mm.kernel.h.ax(m.class)).hN(paramc.field_brandUserName);
    if (paramc == null)
    {
      Log.w("MicroMsg.BaseBizChatInfo", "bizchat myUserId is null");
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
    Log.w("MicroMsg.BaseBizChatInfo", "bizchat not in chatroom myUserId is %s", new Object[] { paramc });
    Log.w("MicroMsg.BaseBizChatInfo", "bizchat not in chatroom memberlist is %s", new Object[] { Arrays.toString(localList.toArray()) });
    AppMethodBeat.o(124220);
    return false;
  }
  
  public static String d(c paramc)
  {
    AppMethodBeat.i(124229);
    if (paramc == null)
    {
      Log.w("MicroMsg.BizChatInfoStorageLogic", "getMsgSource bizChatInfo=%s");
      AppMethodBeat.o(124229);
      return null;
    }
    Log.d("MicroMsg.BizChatInfoStorageLogic", "format msgSource");
    if (paramc.field_bizChatServId == null)
    {
      Log.d("MicroMsg.BizChatInfoStorageLogic", "getMsgSource field_bizChatId=%s", new Object[] { paramc.field_bizChatServId });
      AppMethodBeat.o(124229);
      return null;
    }
    Object localObject2 = Ne(paramc.field_brandUserName);
    if ((localObject2 == null) || (((k)localObject2).field_userId == null))
    {
      Log.d("MicroMsg.BizChatInfoStorageLogic", " bizChatMyUserInfo.field_userId is null getMsgSource field_bizChatId=%s", new Object[] { paramc.field_bizChatServId });
      AppMethodBeat.o(124229);
      return null;
    }
    synchronized (oxN)
    {
      String str1 = paramc.field_bizChatServId;
      int i = paramc.field_chatVersion;
      String str2 = ((k)localObject2).field_userId;
      long l = paramc.field_bizChatLocalId;
      paramc = ((k)localObject2).field_userId;
      localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append(2);
      ((StringBuilder)localObject2).append(Util.nowSecond());
      ((StringBuilder)localObject2).append(paramc);
      ((StringBuilder)localObject2).append(e.a.oxT.nextInt());
      jUr = String.format("<msgsource><enterprise_info><qy_msg_type>%d</qy_msg_type><bizchat_id>%s</bizchat_id><bizchat_ver>%d</bizchat_ver><user_id>%s</user_id><climsgid>%s</climsgid></enterprise_info></msgsource>", new Object[] { Integer.valueOf(1), str1, Integer.valueOf(i), str2, Long.valueOf(l), ((StringBuilder)localObject2).toString() });
      Log.d("MicroMsg.BizChatInfoStorageLogic", "send msgSource:%s", new Object[] { jUr });
      paramc = jUr;
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
    c localc2 = af.bHh().MZ(paramc.field_bizChatServId);
    c localc1;
    if (localc2 != null)
    {
      if ((paramc.field_chatVersion <= localc2.field_chatVersion) && (!Util.isNullOrNil(localc2.field_brandUserName))) {
        break label159;
      }
      if (!Util.isNullOrNil(paramc.field_chatName)) {
        localc2.field_chatName = paramc.field_chatName;
      }
      localc2.field_brandUserName = paramc.field_brandUserName;
      localc2.field_needToUpdate = true;
      localc2.field_chatType = paramc.field_chatType;
      af.bHh().b(localc2);
      localc1 = localc2;
      if (localc1.bHy())
      {
        if (!localc1.bHx()) {
          break label164;
        }
        af.bHp().by(localc1.field_bizChatServId, localc1.field_brandUserName);
      }
    }
    for (;;)
    {
      AppMethodBeat.o(124230);
      return localc1;
      paramc.field_needToUpdate = true;
      localc1 = paramc;
      if (af.bHh().a(paramc)) {
        break;
      }
      label159:
      localc1 = localc2;
      break;
      label164:
      af.bHp().bA(localc1.field_bizChatServId, localc1.field_brandUserName);
    }
  }
  
  public static boolean f(c paramc)
  {
    AppMethodBeat.i(124231);
    Log.d("MicroMsg.BizChatInfoStorageLogic", "updateBizChatMember");
    if (paramc == null)
    {
      Log.w("MicroMsg.BizChatInfoStorageLogic", "updateBizChatMember: bizChatInfo == null");
      AppMethodBeat.o(124231);
      return false;
    }
    Object localObject = paramc.bHw();
    if (localObject == null)
    {
      Log.w("MicroMsg.BizChatInfoStorageLogic", "updateBizChatMember: list == null");
      AppMethodBeat.o(124231);
      return false;
    }
    LinkedList localLinkedList = new LinkedList();
    localObject = ((List)localObject).iterator();
    while (((Iterator)localObject).hasNext())
    {
      String str = (String)((Iterator)localObject).next();
      k localk = af.bHj().hM(str);
      if ((localk != null) && (localk.bHy())) {
        localLinkedList.add(str);
      }
    }
    if (localLinkedList.size() > 0)
    {
      af.bHp().c(localLinkedList, paramc.field_brandUserName);
      AppMethodBeat.o(124231);
      return true;
    }
    Log.w("MicroMsg.BizChatInfoStorageLogic", "updateBizChatMember: no need to update");
    AppMethodBeat.o(124231);
    return false;
  }
  
  public static void g(c paramc)
  {
    AppMethodBeat.i(124239);
    if (paramc == null)
    {
      Log.w("MicroMsg.BizChatInfoStorageLogic", "bizChatInfo is null");
      AppMethodBeat.o(124239);
      return;
    }
    boolean bool1 = af.bHi().iG(paramc.field_bizChatLocalId);
    boolean bool2 = paramc.nG(16);
    Log.d("MicroMsg.BizChatInfoStorageLogic", "convPlaceTop: %s ,bizChatPlaceTop: %s, chatName: %s ", new Object[] { Boolean.valueOf(bool1), Boolean.valueOf(bool2), paramc.field_chatName });
    if ((bool2) && (!bool1))
    {
      af.bHi().iH(paramc.field_bizChatLocalId);
      AppMethodBeat.o(124239);
      return;
    }
    if ((!bool2) && (bool1)) {
      af.bHi().iI(paramc.field_bizChatLocalId);
    }
    AppMethodBeat.o(124239);
  }
  
  public static void h(c paramc)
  {
    AppMethodBeat.i(124240);
    if (paramc == null)
    {
      Log.w("MicroMsg.BizChatInfoStorageLogic", "updateBrandUserConvName bizChatInfo is null");
      AppMethodBeat.o(124240);
      return;
    }
    bb localbb = ((n)com.tencent.mm.kernel.h.ax(n.class)).bzG().bxM(paramc.field_brandUserName);
    if (localbb == null)
    {
      Log.w("MicroMsg.BizChatInfoStorageLogic", "updateBrandUserConvName cvs is null");
      AppMethodBeat.o(124240);
      return;
    }
    Object localObject1 = ((n)com.tencent.mm.kernel.h.ax(n.class)).gaZ().aLG(paramc.field_brandUserName);
    Object localObject2 = ((q)com.tencent.mm.kernel.h.ax(q.class)).bzE().cq(paramc.field_brandUserName, paramc.field_bizChatLocalId);
    if ((localObject1 != null) && (localObject2 != null) && (((fi)localObject1).field_msgId == ((fi)localObject2).field_msgId))
    {
      localObject2 = localbb.field_digest;
      if (localObject2 != null)
      {
        int i = ((String)localObject2).indexOf(":");
        if (i != -1)
        {
          localObject1 = ((String)localObject2).substring(0, i);
          localObject2 = ((String)localObject2).substring(i + 1);
          if ((localObject1 != null) && (!((String)localObject1).equals(paramc.field_chatName)))
          {
            localbb.BF(paramc.field_chatName + ":" + (String)localObject2);
            ((n)com.tencent.mm.kernel.h.ax(n.class)).bzG().c(localbb, localbb.field_username);
          }
        }
      }
    }
    AppMethodBeat.o(124240);
  }
  
  public static String hx(String paramString)
  {
    AppMethodBeat.i(124236);
    paramString = a.hx(paramString);
    AppMethodBeat.o(124236);
    return paramString;
  }
  
  public static int iK(long paramLong)
  {
    AppMethodBeat.i(124221);
    List localList = iL(paramLong);
    if (localList != null)
    {
      int i = localList.size();
      AppMethodBeat.o(124221);
      return i;
    }
    Log.w("MicroMsg.BizChatInfoStorageLogic", "getMembersCountByBizChatId list == null");
    AppMethodBeat.o(124221);
    return 0;
  }
  
  public static List<String> iL(long paramLong)
  {
    AppMethodBeat.i(124222);
    Object localObject = af.bHh().dW(paramLong);
    if (localObject != null)
    {
      localObject = ((c)localObject).bHw();
      AppMethodBeat.o(124222);
      return localObject;
    }
    AppMethodBeat.o(124222);
    return null;
  }
  
  public static String iM(long paramLong)
  {
    AppMethodBeat.i(124232);
    Object localObject = af.bHh().dW(paramLong);
    if (localObject != null)
    {
      localObject = ((c)localObject).field_bizChatServId;
      AppMethodBeat.o(124232);
      return localObject;
    }
    Log.w("MicroMsg.BizChatInfoStorageLogic", "bizChatInfo == null");
    AppMethodBeat.o(124232);
    return null;
  }
  
  public static void u(final String paramString1, String paramString2, final String paramString3)
  {
    AppMethodBeat.i(124235);
    Log.i("MicroMsg.BizChatInfoStorageLogic", "qy_chat_update %s, %s, %s", new Object[] { paramString1, paramString2, paramString3 });
    com.tencent.mm.kernel.h.baH().postToWorker(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(124216);
        c localc = af.bHh().MZ(e.this);
        if (localc == null)
        {
          AppMethodBeat.o(124216);
          return;
        }
        if (localc.field_chatVersion < Util.getInt(paramString3, 2147483647))
        {
          localc.field_needToUpdate = true;
          af.bHh().b(localc);
        }
        if (localc.bHx())
        {
          af.bHp().by(localc.field_bizChatServId, paramString1);
          AppMethodBeat.o(124216);
          return;
        }
        af.bHp().bA(localc.field_bizChatServId, paramString1);
        AppMethodBeat.o(124216);
      }
    });
    AppMethodBeat.o(124235);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.an.a.e
 * JD-Core Version:    0.7.0.1
 */