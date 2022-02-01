package com.tencent.mm.openim.a;

import android.content.ContentValues;
import android.net.Uri;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.autogen.b.az;
import com.tencent.mm.b.f;
import com.tencent.mm.modelavatar.AvatarStorage;
import com.tencent.mm.modelavatar.j;
import com.tencent.mm.modelavatar.k;
import com.tencent.mm.modelavatar.q;
import com.tencent.mm.openim.PluginOpenIM;
import com.tencent.mm.openim.f.b;
import com.tencent.mm.plugin.messenger.foundation.a.n;
import com.tencent.mm.protocal.protobuf.dxj;
import com.tencent.mm.protocal.protobuf.dxl;
import com.tencent.mm.protocal.protobuf.dxn;
import com.tencent.mm.sdk.platformtools.BuildInfo;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMStack;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.sdk.storage.IAutoDBItem.MAutoDBInfo;
import com.tencent.mm.sdk.storage.ISQLiteDatabase;
import com.tencent.mm.storage.au;
import com.tencent.mm.storage.bx;
import kotlin.Metadata;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/openim/contact/OpenIMKefuContactLogic;", "", "()V", "DEBUG", "", "TAG", "", "cardContentCache", "Lcom/tencent/mm/algorithm/LRUMap;", "", "Lcom/tencent/mm/openim/contact/OpenIMKefuContactCardContent;", "contactCache", "Lcom/tencent/mm/openim/contact/OpenIMKefuContactCache;", "wxContactCache", "Lcom/tencent/mm/storage/Contact;", "clearContact", "", "convertFromContactProto", "Lcom/tencent/mm/openim/contact/OpenIMKefuContact;", "kfUrl", "openIMContact", "Lcom/tencent/mm/protocal/protobuf/OpenIMKefuContact;", "convertToWxContact", "dealWithAvatarFromGetContactResp", "getCardContent", "content", "getContact", "username", "getContactByKfUrl", "url", "getContactByKfUrlFromDB", "getContactFromDB", "getFromCache", "getWXContact", "insertContact", "", "needUpdateContact", "contact", "processGetContact", "uct", "replaceContact", "replaceContactInDB", "saveFinderInfo", "openContact", "trimKfUrl", "updateCache", "key", "updateWxContactCache", "wxContact", "plugin-comm_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class g
{
  private static final boolean DEBUG;
  public static final g prW;
  private static final d prX;
  private static final f<String, au> prY;
  private static final f<Integer, e> prZ;
  
  static
  {
    AppMethodBeat.i(236122);
    prW = new g();
    DEBUG = BuildInfo.DEBUG;
    prX = new d();
    prY = (f)new com.tencent.mm.memory.a.c(20);
    prZ = (f)new com.tencent.mm.memory.a.c(20);
    AppMethodBeat.o(236122);
  }
  
  public static final e RD(String paramString)
  {
    AppMethodBeat.i(236112);
    Object localObject = (CharSequence)paramString;
    if ((localObject == null) || (((CharSequence)localObject).length() == 0)) {}
    for (int i = 1; i == 0; i = 0)
    {
      localObject = (e)prZ.get(Integer.valueOf(paramString.hashCode()));
      if (localObject == null) {
        break label96;
      }
      Log.v("MicroMsg.OpenIMKefuContactLogic", "alvinluo kefuCard getCardContent from cache %s", new Object[] { ((e)localObject).username });
      AppMethodBeat.o(236112);
      return localObject;
    }
    Log.e("MicroMsg.OpenIMKefuContactLogic", "alvinluo kefuCard getCardContent content null");
    AppMethodBeat.o(236112);
    return null;
    label96:
    localObject = e.prN;
    e locale = e.a.RK(paramString);
    if (locale != null)
    {
      f localf = prZ;
      localObject = paramString;
      if (paramString == null) {
        localObject = "";
      }
      localf.B(Integer.valueOf(((String)localObject).hashCode()), locale);
    }
    AppMethodBeat.o(236112);
    return locale;
  }
  
  public static final c RL(String paramString)
  {
    c localc = null;
    AppMethodBeat.i(236034);
    Object localObject = (CharSequence)paramString;
    if ((localObject == null) || (((CharSequence)localObject).length() == 0)) {}
    for (int i = 1; i != 0; i = 0)
    {
      AppMethodBeat.o(236034);
      return null;
    }
    localObject = prX.RJ(paramString);
    if (localObject != null)
    {
      AppMethodBeat.o(236034);
      return localObject;
    }
    localObject = ((PluginOpenIM)com.tencent.mm.kernel.h.az(PluginOpenIM.class)).getContactStorage();
    if (localObject == null) {}
    for (;;)
    {
      if (localc != null) {
        b(localc);
      }
      paramString = prX.RJ(paramString);
      AppMethodBeat.o(236034);
      return paramString;
      localc = ((h)localObject).RL(paramString);
    }
  }
  
  public static final au RM(String paramString)
  {
    AppMethodBeat.i(236040);
    Object localObject = (CharSequence)paramString;
    if ((localObject == null) || (((CharSequence)localObject).length() == 0)) {}
    for (int i = 1; i != 0; i = 0)
    {
      AppMethodBeat.o(236040);
      return null;
    }
    localObject = (au)prY.ct(paramString);
    if (localObject != null)
    {
      CharSequence localCharSequence = (CharSequence)((az)localObject).field_username;
      if ((localCharSequence == null) || (localCharSequence.length() == 0)) {}
      for (i = 1; i == 0; i = 0)
      {
        AppMethodBeat.o(236040);
        return localObject;
      }
    }
    localObject = RL(paramString);
    if (localObject == null) {}
    for (localObject = null;; localObject = ((c)localObject).bSb())
    {
      a(paramString, (au)localObject);
      AppMethodBeat.o(236040);
      return localObject;
    }
  }
  
  public static final c RN(String paramString)
  {
    Object localObject1 = null;
    AppMethodBeat.i(236058);
    Object localObject2 = (CharSequence)paramString;
    if ((localObject2 == null) || (((CharSequence)localObject2).length() == 0)) {}
    for (int i = 1; i != 0; i = 0)
    {
      AppMethodBeat.o(236058);
      return null;
    }
    localObject2 = RO(paramString);
    paramString = prX.RJ((String)localObject2);
    if (paramString != null)
    {
      AppMethodBeat.o(236058);
      return paramString;
    }
    paramString = ((PluginOpenIM)com.tencent.mm.kernel.h.az(PluginOpenIM.class)).getContactStorage();
    if (paramString == null) {}
    for (paramString = localObject1;; paramString = paramString.RP((String)localObject2))
    {
      if (paramString != null) {
        b((String)localObject2, paramString);
      }
      paramString = prX.RJ((String)localObject2);
      AppMethodBeat.o(236058);
      return paramString;
    }
  }
  
  private static String RO(String paramString)
  {
    AppMethodBeat.i(236120);
    paramString = Uri.parse(paramString);
    paramString = paramString.getScheme() + "://" + paramString.getHost() + '/' + paramString.getPath();
    Log.i("MicroMsg.OpenIMKefuContactLogic", "trimKfUrl %s", new Object[] { paramString });
    AppMethodBeat.o(236120);
    return paramString;
  }
  
  public static boolean V(au paramau)
  {
    AppMethodBeat.i(236117);
    s.u(paramau, "contact");
    if (Util.nowSecond() - paramau.kak > b.bSE())
    {
      AppMethodBeat.o(236117);
      return true;
    }
    AppMethodBeat.o(236117);
    return false;
  }
  
  public static c a(String paramString, dxl paramdxl)
  {
    int j = 1;
    AppMethodBeat.i(236089);
    if (paramdxl == null)
    {
      AppMethodBeat.o(236089);
      return null;
    }
    c localc = RL(paramdxl.YFY);
    Object localObject;
    label148:
    label168:
    String str;
    long l;
    label214:
    boolean bool;
    if (localc == null)
    {
      localc = new c();
      localc.field_username = paramdxl.YFY;
      localc.field_nickname = paramdxl.nickname;
      localc.field_bigHeadImg = paramdxl.abdc;
      localc.field_smallHeadImg = paramdxl.abdd;
      localc.field_nicknamePyInit = paramdxl.abdp;
      localc.field_nicknamePyQuanPin = paramdxl.abdq;
      localc.field_openImAppId = paramdxl.app_id;
      localc.field_openImDescWordingId = paramdxl.abdn;
      localc.field_source = paramdxl.source;
      localc.field_checkTime = ((int)Util.nowSecond());
      localObject = paramdxl.abdt;
      if (localObject != null) {
        break label334;
      }
      localObject = "";
      localc.field_customInfoDetail = ((String)localObject);
      localObject = paramdxl.abdt;
      if (localObject != null) {
        break label357;
      }
      i = 0;
      localc.field_customInfoDetailVisible = i;
      str = paramdxl.hFb;
      localObject = str;
      if (str == null) {
        localObject = "";
      }
      localc.field_ticket = ((String)localObject);
      localObject = paramdxl.abdv;
      if (localObject != null) {
        break label366;
      }
      l = 0L;
      localc.field_type = l;
      str = paramdxl.YIZ;
      localObject = str;
      if (str == null) {
        localObject = "";
      }
      localc.field_finderUsername = ((String)localObject);
      paramdxl = (CharSequence)paramdxl.YFY;
      if ((paramdxl != null) && (paramdxl.length() != 0)) {
        break label376;
      }
      i = 1;
      label270:
      if (i != 0) {
        break label381;
      }
      bool = true;
      label277:
      localc.clZ = bool;
      if (paramString == null) {
        break label392;
      }
      if (((CharSequence)paramString).length() <= 0) {
        break label387;
      }
      i = 1;
      label302:
      if (i != 1) {
        break label392;
      }
    }
    label387:
    label392:
    for (int i = j;; i = 0)
    {
      if (i != 0) {
        localc.field_kfUrl = RO(paramString);
      }
      AppMethodBeat.o(236089);
      return localc;
      break;
      label334:
      str = ((dxj)localObject).IIu;
      localObject = str;
      if (str != null) {
        break label148;
      }
      localObject = "";
      break label148;
      label357:
      i = ((dxj)localObject).abdu;
      break label168;
      label366:
      l = ((dxn)localObject).NlD;
      break label214;
      label376:
      i = 0;
      break label270;
      label381:
      bool = false;
      break label277;
      i = 0;
      break label302;
    }
  }
  
  private static void a(String paramString, au paramau)
  {
    AppMethodBeat.i(236072);
    if (paramau != null) {
      prY.B(paramString, paramau);
    }
    AppMethodBeat.o(236072);
  }
  
  public static final boolean a(c paramc)
  {
    boolean bool2 = false;
    AppMethodBeat.i(236051);
    s.u(paramc, "contact");
    Object localObject1 = ((PluginOpenIM)com.tencent.mm.kernel.h.az(PluginOpenIM.class)).getContactStorage();
    boolean bool1 = bool2;
    if (localObject1 != null)
    {
      s.u(paramc, "contact");
      localObject2 = paramc.field_username;
      s.s(localObject2, "contact.field_username");
      if (((h)localObject1).RL((String)localObject2) != null) {
        break label299;
      }
      s.u(paramc, "contact");
      localObject2 = paramc.convertTo();
      ISQLiteDatabase localISQLiteDatabase = ((h)localObject1).psb;
      c.a locala = c.prK;
      long l = localISQLiteDatabase.insert("OpenIMKefuContact", c.access$getInfo$cp().primaryKey, (ContentValues)localObject2);
      if (l > 0L)
      {
        paramc.maN = l;
        ((h)localObject1).a(2, paramc);
      }
      Log.i("MicroMsg.OpenIMKefuContactStorage", "insertContact username: " + paramc.field_username + ", result: " + l);
      bool1 = bool2;
      if (l > 0L) {
        bool1 = true;
      }
    }
    Object localObject2 = new StringBuilder("alvinluo replaceContactInDB success=").append(bool1).append(' ').append(paramc.field_username).append(", info: ").append(paramc.bRT()).append(", ");
    if (DEBUG)
    {
      localObject1 = Util.getStack().toString();
      label240:
      Log.i("MicroMsg.OpenIMKefuContactLogic", (String)localObject1);
      if (bool1) {
        ((n)com.tencent.mm.kernel.h.ax(n.class)).bzA().d(paramc.bSb(), true);
      }
      if (!bool1) {
        break label433;
      }
      b(paramc);
    }
    for (;;)
    {
      AppMethodBeat.o(236051);
      return bool1;
      label299:
      s.u(paramc, "contact");
      localObject2 = paramc.convertTo();
      ((ContentValues)localObject2).remove("rowid");
      int i = ((h)localObject1).psb.update("OpenIMKefuContact", (ContentValues)localObject2, "username=?", new String[] { s.X("", paramc.field_username) });
      if (i > 0) {
        ((h)localObject1).a(3, paramc);
      }
      Log.i("MicroMsg.OpenIMKefuContactStorage", "updateContact " + paramc.bRU() + ", result: " + i + ", type: " + paramc.field_type);
      bool1 = bool2;
      if (i <= 0) {
        break;
      }
      bool1 = true;
      break;
      localObject1 = "";
      break label240;
      label433:
      Log.e("MicroMsg.OpenIMKefuContactLogic", "replaceContact failed contactId: " + paramc.maN + ", username: " + paramc.field_username);
    }
  }
  
  private static void b(c paramc)
  {
    AppMethodBeat.i(236062);
    b(paramc.field_username, paramc);
    AppMethodBeat.o(236062);
  }
  
  private static void b(String paramString, c paramc)
  {
    AppMethodBeat.i(236067);
    CharSequence localCharSequence = (CharSequence)paramString;
    if ((localCharSequence == null) || (localCharSequence.length() == 0)) {}
    for (int i = 1; i != 0; i = 0)
    {
      AppMethodBeat.o(236067);
      return;
    }
    prX.a(paramString, paramc);
    a(paramString, paramc.bSb());
    AppMethodBeat.o(236067);
  }
  
  public static void bRW()
  {
    AppMethodBeat.i(236097);
    h localh = ((PluginOpenIM)com.tencent.mm.kernel.h.az(PluginOpenIM.class)).getContactStorage();
    if (localh != null) {
      localh.psb.delete("OpenIMKefuContact", "", new String[0]);
    }
    prX.prM.clear();
    prY.clear();
    AppMethodBeat.o(236097);
  }
  
  public static void c(c paramc)
  {
    int j = 0;
    AppMethodBeat.i(236079);
    if (paramc == null)
    {
      AppMethodBeat.o(236079);
      return;
    }
    Log.i("MicroMsg.OpenIMKefuContactLogic", s.X("alvinluo processGetContact openImKefuContact ", paramc.bRT()));
    a(paramc);
    String str2 = paramc.field_username;
    String str1 = "";
    Object localObject = "";
    j localj = q.bFE().LS(str2);
    if (localj != null)
    {
      str1 = localj.bFw();
      s.s(str1, "oldImgFlag.bigUrl");
      localObject = localj.bFx();
      s.s(localObject, "oldImgFlag.smallUrl");
    }
    localj = new j();
    localj.eQp = -1;
    localj.username = str2;
    localj.osM = paramc.field_smallHeadImg;
    localj.osN = paramc.field_bigHeadImg;
    Log.i("MicroMsg.OpenIMKefuContactLogic", "dealWithAvatarFromGetContactResp contact %s b[%s] s[%s]", new Object[] { localj.getUsername(), localj.bFw(), localj.bFx() });
    if (!s.p(localj.bFw(), str1))
    {
      q.bFp();
      AvatarStorage.T(str2, true);
    }
    for (int i = 1;; i = 0)
    {
      if (!s.p(localj.bFx(), localObject))
      {
        q.bFp();
        AvatarStorage.T(str2, false);
        i = 1;
      }
      if (i != 0)
      {
        q.bFG().LB(str2);
        q.bFE().b(localj);
      }
      ((com.tencent.mm.openim.api.e)com.tencent.mm.kernel.h.ax(com.tencent.mm.openim.api.e.class)).cb(paramc.field_openImAppId, paramc.field_openImDescWordingId);
      localObject = (CharSequence)paramc.field_username;
      if (localObject != null)
      {
        i = j;
        if (((CharSequence)localObject).length() != 0) {}
      }
      else
      {
        i = 1;
      }
      if (i == 0)
      {
        localObject = new com.tencent.mm.openim.e.g();
        ((com.tencent.mm.openim.e.g)localObject).field_openIMUsername = paramc.field_username;
        ((com.tencent.mm.openim.e.g)localObject).field_finder_username = paramc.field_finderUsername;
        ((PluginOpenIM)com.tencent.mm.kernel.h.az(PluginOpenIM.class)).getFinderInfoStg().a((com.tencent.mm.openim.e.g)localObject);
      }
      AppMethodBeat.o(236079);
      return;
    }
  }
  
  public static au d(c paramc)
  {
    AppMethodBeat.i(236092);
    s.u(paramc, "openIMContact");
    au localau = new au();
    localau.setNickname(paramc.field_nickname);
    localau.setUsername(paramc.field_username);
    localau.maN = paramc.maN;
    localau.Bg(paramc.field_openImAppId);
    localau.Bf(paramc.field_openImDescWordingId);
    localau.setSource(paramc.field_source);
    localau.pB(paramc.field_checkTime);
    localau.BD(paramc.field_customInfoDetail);
    localau.pE(paramc.field_customInfoDetailVisible);
    localau.Bi(paramc.field_ticket);
    localau.setType((int)paramc.field_type);
    AppMethodBeat.o(236092);
    return localau;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.openim.a.g
 * JD-Core Version:    0.7.0.1
 */