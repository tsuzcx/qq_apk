package com.tencent.mm.model;

import android.database.Cursor;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.c.ax;
import com.tencent.mm.g.c.bb;
import com.tencent.mm.kernel.e;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.messenger.foundation.a.a.j;
import com.tencent.mm.plugin.messenger.foundation.a.a.k.a;
import com.tencent.mm.plugin.messenger.foundation.a.t;
import com.tencent.mm.protocal.protobuf.SKBuiltinBuffer_t;
import com.tencent.mm.protocal.protobuf.cpl;
import com.tencent.mm.protocal.protobuf.cqg;
import com.tencent.mm.protocal.protobuf.cqh;
import com.tencent.mm.protocal.protobuf.dqi;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.ah;
import com.tencent.mm.storage.ao;
import com.tencent.mm.storage.as;
import com.tencent.mm.storage.az;
import com.tencent.mm.storage.bv;
import com.tencent.mm.storage.bw;
import com.tencent.mm.storage.ci;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import junit.framework.Assert;

public final class ab
{
  private static ar iCD;
  private static HashMap<String, Boolean> iCE;
  public static final String iCF;
  public static final String iCG;
  public static final String iCH;
  public static final String iCI;
  public static final String iCJ;
  public static final String iCK;
  public static final String iCL;
  public static final String iCM;
  public static final String iCN;
  public static final String[] iCO;
  
  static
  {
    AppMethodBeat.i(42931);
    iCD = null;
    iCE = new HashMap();
    iCF = b("rconversation.username", new String[] { "@im.chatroom", "@chatroom", "@openim", "@micromsg.qq.com" });
    iCG = b("rconversation.username", new String[] { "@chatroom", "@micromsg.qq.com" });
    iCH = b("rconversation.username", new String[] { "@t.qq.com" });
    iCI = b("rconversation.username", new String[] { "@qqim" });
    iCJ = b("rconversation.username", new String[] { "@chatroom_exclusive" });
    iCK = b("rconversation.username", new String[] { "@micromsg.qq.com" });
    iCL = b("rconversation.username", new String[] { "@app" });
    iCM = b("rconversation.username", new String[] { "@chatroom" });
    iCN = b("rconversation.username", new String[] { "@im.chatroom" });
    iCO = new String[] { "qqmail", "fmessage", "tmessage", "qmessage", "qqsync", "floatbottle", "lbsapp", "shakeapp", "medianote", "qqfriend", "newsapp", "blogapp", "facebookapp", "topstoryapp", "masssendapp", "feedsapp", "voipapp", "cardpackage", "voicevoipapp", "voiceinputapp", "officialaccounts", "linkedinplugin", "notifymessage", "appbrandcustomerservicemsg", "appbrand_notify_message" };
    AppMethodBeat.o(42931);
  }
  
  public static void A(as paramas)
  {
    AppMethodBeat.i(42866);
    if (paramas != null) {}
    for (boolean bool = true;; bool = false)
    {
      Assert.assertTrue(bool);
      as localas2 = ((com.tencent.mm.plugin.messenger.foundation.a.l)g.af(com.tencent.mm.plugin.messenger.foundation.a.l.class)).aSN().Kn(paramas.field_username);
      as localas1;
      if (localas2 != null)
      {
        localas1 = localas2;
        if (!Util.isNullOrNil(localas2.field_username)) {}
      }
      else
      {
        localas1 = paramas;
      }
      localas1.are();
      if ((as.bjp(paramas.field_username)) && (iCD != null)) {
        iCD.EF(paramas.field_username);
      }
      G(localas1);
      AppMethodBeat.o(42866);
      return;
    }
  }
  
  public static void B(as paramas)
  {
    boolean bool2 = true;
    AppMethodBeat.i(42867);
    if (paramas != null)
    {
      bool1 = true;
      Assert.assertTrue("MicroMsg.ContactStorageLogic: user is null", bool1);
      if ((int)paramas.gMZ == 0) {
        break label92;
      }
      bool1 = true;
      label29:
      Assert.assertTrue("MicroMsg.ContactStorageLogic: contactId == 0", bool1);
      if (paramas.field_username.length() <= 0) {
        break label97;
      }
    }
    label92:
    label97:
    for (boolean bool1 = bool2;; bool1 = false)
    {
      Assert.assertTrue("MicroMsg.ContactStorageLogic: username length <= 0", bool1);
      paramas.aqQ();
      ((com.tencent.mm.plugin.messenger.foundation.a.l)g.af(com.tencent.mm.plugin.messenger.foundation.a.l.class)).aSN().c(paramas.field_username, paramas);
      AppMethodBeat.o(42867);
      return;
      bool1 = false;
      break;
      bool1 = false;
      break label29;
    }
  }
  
  public static void C(as paramas)
  {
    boolean bool2 = true;
    AppMethodBeat.i(42868);
    if (paramas != null)
    {
      bool1 = true;
      Assert.assertTrue(bool1);
      if ((int)paramas.gMZ == 0) {
        break label90;
      }
      bool1 = true;
      label27:
      Assert.assertTrue(bool1);
      if (paramas.field_username.length() <= 0) {
        break label95;
      }
    }
    label90:
    label95:
    for (boolean bool1 = bool2;; bool1 = false)
    {
      Assert.assertTrue(bool1);
      paramas.aqQ();
      ((com.tencent.mm.plugin.messenger.foundation.a.l)g.af(com.tencent.mm.plugin.messenger.foundation.a.l.class)).aSN().c(paramas.field_username, paramas);
      G(paramas);
      AppMethodBeat.o(42868);
      return;
      bool1 = false;
      break;
      bool1 = false;
      break label27;
    }
  }
  
  public static void D(as paramas)
  {
    boolean bool2 = true;
    AppMethodBeat.i(42870);
    if (paramas != null)
    {
      bool1 = true;
      Assert.assertTrue(bool1);
      if ((int)paramas.gMZ == 0) {
        break label66;
      }
      bool1 = true;
      label27:
      Assert.assertTrue(bool1);
      if (paramas.field_username.length() <= 0) {
        break label71;
      }
    }
    label66:
    label71:
    for (boolean bool1 = bool2;; bool1 = false)
    {
      Assert.assertTrue(bool1);
      paramas.arG();
      G(paramas);
      AppMethodBeat.o(42870);
      return;
      bool1 = false;
      break;
      bool1 = false;
      break label27;
    }
  }
  
  public static void D(String paramString, boolean paramBoolean)
  {
    AppMethodBeat.i(42853);
    paramString = ((com.tencent.mm.plugin.messenger.foundation.a.l)g.af(com.tencent.mm.plugin.messenger.foundation.a.l.class)).aSN().Kn(paramString);
    if ((paramString == null) || (Util.isNullOrNil(paramString.field_username)))
    {
      AppMethodBeat.o(42853);
      return;
    }
    if (paramBoolean) {
      paramString.arf();
    }
    for (;;)
    {
      E(paramString);
      AppMethodBeat.o(42853);
      return;
      paramString.arg();
    }
  }
  
  private static void E(as paramas)
  {
    AppMethodBeat.i(42871);
    boolean bool;
    cqg localcqg;
    if (paramas != null)
    {
      bool = true;
      Assert.assertTrue(bool);
      if ((int)paramas.gMZ == 0)
      {
        ((com.tencent.mm.plugin.messenger.foundation.a.l)g.af(com.tencent.mm.plugin.messenger.foundation.a.l.class)).aSN().aq(paramas);
        ((com.tencent.mm.plugin.messenger.foundation.a.l)g.af(com.tencent.mm.plugin.messenger.foundation.a.l.class)).aSN().Kn(paramas.field_username);
      }
      ((com.tencent.mm.plugin.messenger.foundation.a.l)g.af(com.tencent.mm.plugin.messenger.foundation.a.l.class)).aSN().c(paramas.field_username, paramas);
      localcqg = new cqg();
      localcqg.MvG = paramas.field_username;
      if (!paramas.arB()) {
        break label157;
      }
    }
    label157:
    for (localcqg.MvC = 1;; localcqg.MvC = 2)
    {
      ((com.tencent.mm.plugin.messenger.foundation.a.l)g.af(com.tencent.mm.plugin.messenger.foundation.a.l.class)).aSM().d(new k.a(52, localcqg));
      AppMethodBeat.o(42871);
      return;
      bool = false;
      break;
    }
  }
  
  public static void E(String paramString, boolean paramBoolean)
  {
    AppMethodBeat.i(42862);
    if (!Util.isNullOrNil(paramString)) {}
    as localas;
    for (boolean bool = true;; bool = false)
    {
      Assert.assertTrue(bool);
      localas = ((com.tencent.mm.plugin.messenger.foundation.a.l)g.af(com.tencent.mm.plugin.messenger.foundation.a.l.class)).aSN().Kn(paramString);
      if ((localas != null) && (!Util.isNullOrNil(localas.field_username))) {
        break;
      }
      AppMethodBeat.o(42862);
      return;
    }
    localas.setType(localas.field_type | 0x800);
    if (((as.bjp(paramString)) || (Iy(paramString))) && (iCD != null)) {
      iCD.Ey(paramString);
    }
    G(localas);
    if (paramBoolean) {
      ((com.tencent.mm.plugin.messenger.foundation.a.l)g.af(com.tencent.mm.plugin.messenger.foundation.a.l.class)).aST().bke(paramString);
    }
    AppMethodBeat.o(42862);
  }
  
  public static boolean Eq(String paramString)
  {
    AppMethodBeat.i(42834);
    if ((paramString == null) || (paramString.length() <= 0))
    {
      AppMethodBeat.o(42834);
      return false;
    }
    if ((paramString.endsWith("@chatroom")) || (paramString.endsWith("@im.chatroom")))
    {
      AppMethodBeat.o(42834);
      return true;
    }
    AppMethodBeat.o(42834);
    return false;
  }
  
  public static void F(as paramas)
  {
    AppMethodBeat.i(42872);
    boolean bool;
    cqh localcqh;
    if (paramas != null)
    {
      bool = true;
      Assert.assertTrue(bool);
      if ((int)paramas.gMZ == 0)
      {
        ((com.tencent.mm.plugin.messenger.foundation.a.l)g.af(com.tencent.mm.plugin.messenger.foundation.a.l.class)).aSN().aq(paramas);
        ((com.tencent.mm.plugin.messenger.foundation.a.l)g.af(com.tencent.mm.plugin.messenger.foundation.a.l.class)).aSN().Kn(paramas.field_username);
      }
      ((com.tencent.mm.plugin.messenger.foundation.a.l)g.af(com.tencent.mm.plugin.messenger.foundation.a.l.class)).aSN().c(paramas.field_username, paramas);
      localcqh = new cqh();
      localcqh.MvG = paramas.field_username;
      if (!paramas.arD()) {
        break label159;
      }
    }
    label159:
    for (localcqh.MvC = 1;; localcqh.MvC = 2)
    {
      ((com.tencent.mm.plugin.messenger.foundation.a.l)g.af(com.tencent.mm.plugin.messenger.foundation.a.l.class)).aSM().d(new k.a(72, localcqh));
      AppMethodBeat.o(42872);
      return;
      bool = false;
      break;
    }
  }
  
  public static void F(String paramString, boolean paramBoolean)
  {
    AppMethodBeat.i(42864);
    if (!Util.isNullOrNil(paramString)) {}
    as localas;
    for (boolean bool = true;; bool = false)
    {
      Assert.assertTrue(bool);
      localas = ((com.tencent.mm.plugin.messenger.foundation.a.l)g.af(com.tencent.mm.plugin.messenger.foundation.a.l.class)).aSN().Kn(paramString);
      if ((localas != null) && (!Util.isNullOrNil(localas.field_username))) {
        break;
      }
      AppMethodBeat.o(42864);
      return;
    }
    localas.setType(localas.field_type & 0xFFFFF7FF);
    if (((as.bjp(paramString)) || (Iy(paramString))) && (iCD != null)) {
      iCD.Ez(paramString);
    }
    G(localas);
    if (paramBoolean) {
      ((com.tencent.mm.plugin.messenger.foundation.a.l)g.af(com.tencent.mm.plugin.messenger.foundation.a.l.class)).aST().bkf(paramString);
    }
    AppMethodBeat.o(42864);
  }
  
  public static void G(as paramas)
  {
    AppMethodBeat.i(42873);
    if (paramas != null) {}
    for (boolean bool = true;; bool = false)
    {
      Assert.assertTrue(bool);
      if ((int)paramas.gMZ == 0)
      {
        ((com.tencent.mm.plugin.messenger.foundation.a.l)g.af(com.tencent.mm.plugin.messenger.foundation.a.l.class)).aSN().aq(paramas);
        ((com.tencent.mm.plugin.messenger.foundation.a.l)g.af(com.tencent.mm.plugin.messenger.foundation.a.l.class)).aSN().Kn(paramas.field_username);
      }
      ((com.tencent.mm.plugin.messenger.foundation.a.l)g.af(com.tencent.mm.plugin.messenger.foundation.a.l.class)).aSN().c(paramas.field_username, paramas);
      if (!as.bjp(paramas.field_username)) {
        I(paramas);
      }
      AppMethodBeat.o(42873);
      return;
    }
  }
  
  public static cpl H(as paramas)
  {
    AppMethodBeat.i(225937);
    Log.i("MicroMsg.ContactStorageLogic", "oplog modContact user:%s remark:%s type:%d ", new Object[] { paramas.field_username, paramas.field_conRemark, Integer.valueOf(paramas.field_type) });
    cpl localcpl = new cpl();
    localcpl.Lqk = new dqi().bhy(Util.nullAsNil(paramas.field_username));
    localcpl.Mjj = new dqi().bhy(Util.nullAsNil(paramas.field_nickname));
    localcpl.LpA = new dqi().bhy(Util.nullAsNil(paramas.ajz()));
    localcpl.LpB = new dqi().bhy(Util.nullAsNil(paramas.ajA()));
    localcpl.kdY = paramas.fuA;
    localcpl.LoG = 176787327;
    localcpl.LoH = paramas.field_type;
    localcpl.MuI = new dqi().bhy(Util.nullAsNil(paramas.field_conRemark));
    localcpl.MuJ = new dqi().bhy(Util.nullAsNil(paramas.field_conRemarkPYShort));
    localcpl.MuK = new dqi().bhy(Util.nullAsNil(paramas.field_conRemarkPYFull));
    localcpl.LoM = paramas.fuE;
    localcpl.Mvh = new dqi().bhy(Util.nullAsNil(paramas.field_domainList));
    localcpl.LoQ = paramas.fuH;
    localcpl.kec = paramas.fuI;
    localcpl.keb = Util.nullAsNil(paramas.signature);
    localcpl.kea = Util.nullAsNil(paramas.getCityCode());
    localcpl.kdZ = Util.nullAsNil(paramas.gBR());
    localcpl.MmM = Util.nullAsNil(paramas.fuM);
    localcpl.MmO = paramas.field_weiboFlag;
    localcpl.Mvd = 0;
    localcpl.KHp = new SKBuiltinBuffer_t();
    localcpl.keh = Util.nullAsNil(paramas.getCountryCode());
    AppMethodBeat.o(225937);
    return localcpl;
  }
  
  public static void I(as paramas)
  {
    AppMethodBeat.i(42874);
    ((com.tencent.mm.plugin.messenger.foundation.a.l)g.af(com.tencent.mm.plugin.messenger.foundation.a.l.class)).aSM().d(new k.a(2, H(paramas)));
    AppMethodBeat.o(42874);
  }
  
  public static boolean IA(String paramString)
  {
    AppMethodBeat.i(225931);
    if ((paramString == null) || (paramString.length() <= 0))
    {
      Log.i("MicroMsg.ContactStorageLogic", "union luckymoney logic：isOpenImIncludeAssociateRoomOrOpenIMUser :(username == null) || (username.length() <= 0) ");
      AppMethodBeat.o(225931);
      return false;
    }
    if ((Iz(paramString)) || (as.bjp(paramString))) {}
    for (boolean bool = true;; bool = false)
    {
      Log.i("MicroMsg.ContactStorageLogic", "union luckymoney logic：isOpenImIncludeAssociateRoomOrOpenIMUser :%s ", new Object[] { Boolean.valueOf(bool) });
      AppMethodBeat.o(225931);
      return bool;
    }
  }
  
  public static boolean IB(String paramString)
  {
    AppMethodBeat.i(178865);
    Boolean localBoolean;
    Object localObject;
    if (Ix(paramString))
    {
      localBoolean = null;
      if (iCE.containsKey(paramString)) {
        localBoolean = (Boolean)iCE.get(paramString);
      }
      localObject = localBoolean;
      if (localBoolean == null)
      {
        localBoolean = Boolean.FALSE;
        localObject = ((com.tencent.mm.plugin.chatroom.a.c)g.af(com.tencent.mm.plugin.chatroom.a.c.class)).aSX().Kd(paramString);
        if ((localObject == null) || ((((ah)localObject).field_chatroomStatus & 0x20000) != 131072)) {
          break label121;
        }
        localBoolean = Boolean.TRUE;
      }
    }
    label121:
    for (;;)
    {
      iCE.put(paramString, localBoolean);
      localObject = localBoolean;
      boolean bool = ((Boolean)localObject).booleanValue();
      AppMethodBeat.o(178865);
      return bool;
      AppMethodBeat.o(178865);
      return false;
    }
  }
  
  public static void IC(String paramString)
  {
    AppMethodBeat.i(225933);
    iCE.remove(paramString);
    AppMethodBeat.o(225933);
  }
  
  public static boolean ID(String paramString)
  {
    AppMethodBeat.i(178866);
    if (Ix(paramString))
    {
      paramString = ((com.tencent.mm.plugin.chatroom.a.c)g.af(com.tencent.mm.plugin.chatroom.a.c.class)).aSX().Kd(paramString);
      if ((paramString != null) && ((paramString.field_chatroomStatus & 0x20000) != 131072) && ((paramString.field_chatroomStatus & 0x10000) == 65536))
      {
        AppMethodBeat.o(178866);
        return true;
      }
    }
    AppMethodBeat.o(178866);
    return false;
  }
  
  public static boolean IE(String paramString)
  {
    AppMethodBeat.i(178867);
    if ((((t)g.af(t.class)).ama()) && (Ix(paramString)))
    {
      paramString = ((com.tencent.mm.plugin.chatroom.a.c)g.af(com.tencent.mm.plugin.chatroom.a.c.class)).aSX().Kd(paramString);
      if ((paramString != null) && (paramString.amD()))
      {
        AppMethodBeat.o(178867);
        return true;
      }
    }
    AppMethodBeat.o(178867);
    return false;
  }
  
  public static boolean IF(String paramString)
  {
    AppMethodBeat.i(42836);
    if ((paramString == null) || (paramString.length() <= 0))
    {
      AppMethodBeat.o(42836);
      return false;
    }
    boolean bool = paramString.endsWith("@qy_u");
    AppMethodBeat.o(42836);
    return bool;
  }
  
  public static boolean IG(String paramString)
  {
    AppMethodBeat.i(42837);
    if ((paramString == null) || (paramString.length() <= 0))
    {
      AppMethodBeat.o(42837);
      return false;
    }
    boolean bool = paramString.endsWith("@bottle");
    AppMethodBeat.o(42837);
    return bool;
  }
  
  public static boolean IH(String paramString)
  {
    AppMethodBeat.i(42838);
    if ((paramString == null) || (paramString.length() <= 0))
    {
      AppMethodBeat.o(42838);
      return false;
    }
    boolean bool = paramString.endsWith("@qqim");
    AppMethodBeat.o(42838);
    return bool;
  }
  
  public static boolean II(String paramString)
  {
    AppMethodBeat.i(42839);
    if ((paramString == null) || (paramString.length() <= 0))
    {
      AppMethodBeat.o(42839);
      return false;
    }
    boolean bool = paramString.endsWith("@lbsroom");
    AppMethodBeat.o(42839);
    return bool;
  }
  
  public static boolean IJ(String paramString)
  {
    AppMethodBeat.i(42841);
    boolean bool = "gh_43f2581f6fd6".equals(paramString);
    AppMethodBeat.o(42841);
    return bool;
  }
  
  public static boolean IK(String paramString)
  {
    AppMethodBeat.i(42842);
    boolean bool = "gh_3dfda90e39d6".equals(paramString);
    AppMethodBeat.o(42842);
    return bool;
  }
  
  public static boolean IL(String paramString)
  {
    AppMethodBeat.i(225934);
    boolean bool = "gh_f0a92aa7146c".equals(paramString);
    AppMethodBeat.o(225934);
    return bool;
  }
  
  public static boolean IM(String paramString)
  {
    AppMethodBeat.i(225935);
    boolean bool = "gh_579db1f2cf89".equals(paramString);
    AppMethodBeat.o(225935);
    return bool;
  }
  
  public static boolean IN(String paramString)
  {
    AppMethodBeat.i(163508);
    boolean bool = "1@fackuser".equals(paramString);
    AppMethodBeat.o(163508);
    return bool;
  }
  
  public static boolean IO(String paramString)
  {
    AppMethodBeat.i(225936);
    boolean bool = "msginfo@fakeuser".equals(paramString);
    AppMethodBeat.o(225936);
    return bool;
  }
  
  public static boolean IP(String paramString)
  {
    AppMethodBeat.i(42843);
    boolean bool = "downloaderapp".equals(paramString);
    AppMethodBeat.o(42843);
    return bool;
  }
  
  public static boolean IQ(String paramString)
  {
    AppMethodBeat.i(42844);
    if ((paramString == null) || (paramString.length() <= 0))
    {
      AppMethodBeat.o(42844);
      return false;
    }
    if (!Iw(paramString))
    {
      AppMethodBeat.o(42844);
      return false;
    }
    paramString = ((com.tencent.mm.plugin.messenger.foundation.a.l)g.af(com.tencent.mm.plugin.messenger.foundation.a.l.class)).aSN().Kn(paramString);
    if ((paramString == null) || (!com.tencent.mm.contact.c.oR(paramString.field_type)))
    {
      AppMethodBeat.o(42844);
      return false;
    }
    AppMethodBeat.o(42844);
    return true;
  }
  
  public static boolean IR(String paramString)
  {
    AppMethodBeat.i(42845);
    if ((paramString == null) || (paramString.length() <= 0))
    {
      AppMethodBeat.o(42845);
      return false;
    }
    boolean bool = paramString.endsWith("@stranger");
    AppMethodBeat.o(42845);
    return bool;
  }
  
  public static boolean IS(String paramString)
  {
    AppMethodBeat.i(42849);
    if ((paramString == null) || (paramString.length() <= 0))
    {
      AppMethodBeat.o(42849);
      return true;
    }
    boolean bool = com.tencent.mm.contact.c.oR(((com.tencent.mm.plugin.messenger.foundation.a.l)g.af(com.tencent.mm.plugin.messenger.foundation.a.l.class)).aSN().Kn(paramString).field_type);
    AppMethodBeat.o(42849);
    return bool;
  }
  
  public static boolean IT(String paramString)
  {
    AppMethodBeat.i(42850);
    if (Util.isNullOrNil(paramString))
    {
      AppMethodBeat.o(42850);
      return false;
    }
    paramString = ((com.tencent.mm.plugin.messenger.foundation.a.l)g.af(com.tencent.mm.plugin.messenger.foundation.a.l.class)).aSN().Kn(paramString);
    if (paramString == null)
    {
      AppMethodBeat.o(42850);
      return false;
    }
    boolean bool = as.akh(paramString.field_verifyFlag);
    AppMethodBeat.o(42850);
    return bool;
  }
  
  public static void IU(String paramString)
  {
    AppMethodBeat.i(42863);
    az localaz2 = ((com.tencent.mm.plugin.messenger.foundation.a.l)g.af(com.tencent.mm.plugin.messenger.foundation.a.l.class)).aST().bjY(paramString);
    int i = 0;
    az localaz1 = localaz2;
    if (localaz2 == null)
    {
      localaz1 = new az();
      localaz1.gCr();
      i = 1;
      localaz1.setUsername(paramString);
    }
    localaz1.yA(System.currentTimeMillis());
    if (i != 0)
    {
      ((com.tencent.mm.plugin.messenger.foundation.a.l)g.af(com.tencent.mm.plugin.messenger.foundation.a.l.class)).aST().e(localaz1);
      AppMethodBeat.o(42863);
      return;
    }
    ((com.tencent.mm.plugin.messenger.foundation.a.l)g.af(com.tencent.mm.plugin.messenger.foundation.a.l.class)).aST().a(localaz1, paramString);
    AppMethodBeat.o(42863);
  }
  
  public static void IV(String paramString)
  {
    AppMethodBeat.i(42875);
    if (Util.isNullOrNil(paramString))
    {
      AppMethodBeat.o(42875);
      return;
    }
    as localas = ((com.tencent.mm.plugin.messenger.foundation.a.l)g.af(com.tencent.mm.plugin.messenger.foundation.a.l.class)).aSN().Kn(paramString);
    if (localas == null)
    {
      AppMethodBeat.o(42875);
      return;
    }
    localas.setSource(0);
    localas.aqO();
    ((com.tencent.mm.plugin.messenger.foundation.a.l)g.af(com.tencent.mm.plugin.messenger.foundation.a.l.class)).aSN().c(paramString, localas);
    AppMethodBeat.o(42875);
  }
  
  public static boolean IW(String paramString)
  {
    AppMethodBeat.i(42882);
    if (paramString != null)
    {
      boolean bool = paramString.equalsIgnoreCase("qqmail");
      AppMethodBeat.o(42882);
      return bool;
    }
    AppMethodBeat.o(42882);
    return false;
  }
  
  public static boolean IX(String paramString)
  {
    AppMethodBeat.i(42883);
    if (paramString != null)
    {
      boolean bool = paramString.equalsIgnoreCase("fmessage");
      AppMethodBeat.o(42883);
      return bool;
    }
    AppMethodBeat.o(42883);
    return false;
  }
  
  public static boolean IY(String paramString)
  {
    AppMethodBeat.i(42884);
    if (paramString != null)
    {
      boolean bool = paramString.equalsIgnoreCase("tmessage");
      AppMethodBeat.o(42884);
      return bool;
    }
    AppMethodBeat.o(42884);
    return false;
  }
  
  public static boolean IZ(String paramString)
  {
    AppMethodBeat.i(42885);
    if (paramString != null)
    {
      boolean bool = paramString.equalsIgnoreCase("floatbottle");
      AppMethodBeat.o(42885);
      return bool;
    }
    AppMethodBeat.o(42885);
    return false;
  }
  
  public static boolean Iu(String paramString)
  {
    AppMethodBeat.i(42831);
    if ((paramString == null) || (paramString.length() <= 0))
    {
      AppMethodBeat.o(42831);
      return false;
    }
    if ((!paramString.contains("@")) || (paramString.endsWith("@micromsg.qq.com")))
    {
      AppMethodBeat.o(42831);
      return true;
    }
    AppMethodBeat.o(42831);
    return false;
  }
  
  public static boolean Iv(String paramString)
  {
    AppMethodBeat.i(225930);
    if ((paramString == null) || (paramString.length() <= 0))
    {
      AppMethodBeat.o(225930);
      return false;
    }
    boolean bool = paramString.equalsIgnoreCase("weixin");
    AppMethodBeat.o(225930);
    return bool;
  }
  
  public static boolean Iw(String paramString)
  {
    AppMethodBeat.i(42832);
    if ((Ix(paramString)) || (Iy(paramString)))
    {
      AppMethodBeat.o(42832);
      return true;
    }
    AppMethodBeat.o(42832);
    return false;
  }
  
  public static boolean Ix(String paramString)
  {
    AppMethodBeat.i(42833);
    if ((paramString == null) || (paramString.length() <= 0))
    {
      AppMethodBeat.o(42833);
      return false;
    }
    boolean bool = paramString.endsWith("@chatroom");
    AppMethodBeat.o(42833);
    return bool;
  }
  
  public static boolean Iy(String paramString)
  {
    AppMethodBeat.i(42835);
    if ((paramString == null) || (paramString.length() <= 0))
    {
      AppMethodBeat.o(42835);
      return false;
    }
    boolean bool = paramString.endsWith("@im.chatroom");
    AppMethodBeat.o(42835);
    return bool;
  }
  
  public static boolean Iz(String paramString)
  {
    AppMethodBeat.i(178864);
    if ((paramString == null) || (paramString.length() <= 0))
    {
      AppMethodBeat.o(178864);
      return false;
    }
    if ((paramString.endsWith("@im.chatroom")) || (IB(paramString)))
    {
      AppMethodBeat.o(178864);
      return true;
    }
    AppMethodBeat.o(178864);
    return false;
  }
  
  public static boolean J(as paramas)
  {
    return (paramas.field_weiboFlag & 0x1) != 0;
  }
  
  public static boolean JA(String paramString)
  {
    AppMethodBeat.i(42912);
    g.aAi();
    String str = (String)g.aAh().azQ().get(21, null);
    if (((str != null) && (str.equalsIgnoreCase(paramString))) || (paramString.equalsIgnoreCase("weixin")))
    {
      AppMethodBeat.o(42912);
      return true;
    }
    AppMethodBeat.o(42912);
    return false;
  }
  
  public static boolean JB(String paramString)
  {
    AppMethodBeat.i(42913);
    if (paramString != null)
    {
      boolean bool = paramString.equalsIgnoreCase("appbrandcustomerservicemsg");
      AppMethodBeat.o(42913);
      return bool;
    }
    AppMethodBeat.o(42913);
    return false;
  }
  
  public static boolean JC(String paramString)
  {
    AppMethodBeat.i(225940);
    if (paramString != null)
    {
      boolean bool = paramString.equalsIgnoreCase("appbrand_notify_message");
      AppMethodBeat.o(225940);
      return bool;
    }
    AppMethodBeat.o(225940);
    return false;
  }
  
  public static boolean JD(String paramString)
  {
    AppMethodBeat.i(225941);
    if (paramString != null)
    {
      boolean bool = paramString.equalsIgnoreCase("findersayhisessionholder");
      AppMethodBeat.o(225941);
      return bool;
    }
    AppMethodBeat.o(225941);
    return false;
  }
  
  public static boolean JE(String paramString)
  {
    AppMethodBeat.i(42914);
    String[] arrayOfString = iCO;
    int j = arrayOfString.length;
    int i = 0;
    while (i < j)
    {
      if (arrayOfString[i].equalsIgnoreCase(paramString))
      {
        AppMethodBeat.o(42914);
        return true;
      }
      i += 1;
    }
    AppMethodBeat.o(42914);
    return false;
  }
  
  public static boolean JF(String paramString)
  {
    AppMethodBeat.i(42915);
    if (JE(paramString))
    {
      AppMethodBeat.o(42915);
      return true;
    }
    if (as.bjo(paramString))
    {
      AppMethodBeat.o(42915);
      return true;
    }
    if (as.bjm(paramString))
    {
      AppMethodBeat.o(42915);
      return true;
    }
    if (as.IG(paramString))
    {
      AppMethodBeat.o(42915);
      return true;
    }
    AppMethodBeat.o(42915);
    return false;
  }
  
  public static int JG(String paramString)
  {
    AppMethodBeat.i(42916);
    if (Util.nullAsNil(paramString).length() > 0) {}
    for (boolean bool = true;; bool = false)
    {
      Assert.assertTrue(bool);
      paramString = paramString.trim().toLowerCase();
      if (!paramString.endsWith("@chatroom")) {
        break;
      }
      AppMethodBeat.o(42916);
      return 1;
    }
    if (as.bjm(paramString))
    {
      AppMethodBeat.o(42916);
      return 11;
    }
    if (as.bjo(paramString))
    {
      AppMethodBeat.o(42916);
      return 36;
    }
    if (as.IG(paramString))
    {
      AppMethodBeat.o(42916);
      return 1;
    }
    AppMethodBeat.o(42916);
    return 1;
  }
  
  public static int JH(String paramString)
  {
    AppMethodBeat.i(42917);
    if (Util.nullAsNil(paramString).length() > 0) {}
    for (boolean bool = true;; bool = false)
    {
      Assert.assertTrue(bool);
      paramString = paramString.trim().toLowerCase();
      if (!paramString.endsWith("@chatroom")) {
        break;
      }
      AppMethodBeat.o(42917);
      return 3;
    }
    if (as.bjm(paramString))
    {
      AppMethodBeat.o(42917);
      return 13;
    }
    if (as.bjo(paramString))
    {
      AppMethodBeat.o(42917);
      return 39;
    }
    if (as.IG(paramString))
    {
      AppMethodBeat.o(42917);
      return 3;
    }
    if (paramString.contains("@"))
    {
      AppMethodBeat.o(42917);
      return 3;
    }
    AppMethodBeat.o(42917);
    return 3;
  }
  
  public static boolean JI(String paramString)
  {
    AppMethodBeat.i(42918);
    if (((com.tencent.mm.plugin.messenger.foundation.a.l)g.af(com.tencent.mm.plugin.messenger.foundation.a.l.class)).aSN().Kn(paramString).fuH != 1)
    {
      AppMethodBeat.o(42918);
      return false;
    }
    AppMethodBeat.o(42918);
    return true;
  }
  
  public static boolean JJ(String paramString)
  {
    AppMethodBeat.i(42919);
    paramString = ((com.tencent.mm.plugin.messenger.foundation.a.l)g.af(com.tencent.mm.plugin.messenger.foundation.a.l.class)).aSN().Kn(paramString);
    if ((paramString != null) && (paramString.Zx()))
    {
      AppMethodBeat.o(42919);
      return true;
    }
    AppMethodBeat.o(42919);
    return false;
  }
  
  public static boolean JK(String paramString)
  {
    AppMethodBeat.i(42920);
    if ((paramString == null) || (paramString.length() <= 0))
    {
      AppMethodBeat.o(42920);
      return false;
    }
    if ((paramString.startsWith("t.qq.com/")) || (paramString.startsWith("http://t.qq.com/")))
    {
      AppMethodBeat.o(42920);
      return true;
    }
    AppMethodBeat.o(42920);
    return false;
  }
  
  public static String JL(String paramString)
  {
    AppMethodBeat.i(42921);
    if (JK(paramString))
    {
      paramString = paramString.replace("http://t.qq.com/", "").replace("t.qq.com/", "");
      AppMethodBeat.o(42921);
      return paramString;
    }
    AppMethodBeat.o(42921);
    return "";
  }
  
  public static boolean JM(String paramString)
  {
    AppMethodBeat.i(42930);
    if ((paramString.equals("weixinsrc")) || (paramString.equalsIgnoreCase("gh_6e99ff560306")))
    {
      AppMethodBeat.o(42930);
      return true;
    }
    AppMethodBeat.o(42930);
    return false;
  }
  
  public static boolean JN(String paramString)
  {
    AppMethodBeat.i(178868);
    paramString = ((com.tencent.mm.plugin.chatroom.a.c)g.af(com.tencent.mm.plugin.chatroom.a.c.class)).aSX().Kd(paramString);
    if (paramString == null)
    {
      AppMethodBeat.o(178868);
      return false;
    }
    boolean bool = paramString.amD();
    AppMethodBeat.o(178868);
    return bool;
  }
  
  public static boolean JO(String paramString)
  {
    AppMethodBeat.i(184702);
    paramString = ((com.tencent.mm.plugin.chatroom.a.c)g.af(com.tencent.mm.plugin.chatroom.a.c.class)).aSX().Kd(paramString);
    if (paramString == null)
    {
      AppMethodBeat.o(184702);
      return false;
    }
    boolean bool = paramString.JO(z.aTY());
    AppMethodBeat.o(184702);
    return bool;
  }
  
  public static boolean Ja(String paramString)
  {
    AppMethodBeat.i(42886);
    if (paramString != null)
    {
      boolean bool = paramString.equalsIgnoreCase("qmessage");
      AppMethodBeat.o(42886);
      return bool;
    }
    AppMethodBeat.o(42886);
    return false;
  }
  
  public static boolean Jb(String paramString)
  {
    AppMethodBeat.i(42887);
    if (paramString != null)
    {
      boolean bool = paramString.equalsIgnoreCase("facebookapp");
      AppMethodBeat.o(42887);
      return bool;
    }
    AppMethodBeat.o(42887);
    return false;
  }
  
  public static boolean Jc(String paramString)
  {
    AppMethodBeat.i(42888);
    if (paramString != null)
    {
      boolean bool = paramString.equalsIgnoreCase("masssendapp");
      AppMethodBeat.o(42888);
      return bool;
    }
    AppMethodBeat.o(42888);
    return false;
  }
  
  public static boolean Jd(String paramString)
  {
    AppMethodBeat.i(42889);
    if (paramString != null)
    {
      boolean bool = paramString.equalsIgnoreCase("feedsapp");
      AppMethodBeat.o(42889);
      return bool;
    }
    AppMethodBeat.o(42889);
    return false;
  }
  
  public static boolean Je(String paramString)
  {
    AppMethodBeat.i(42890);
    boolean bool = "qqsync".equalsIgnoreCase(paramString);
    AppMethodBeat.o(42890);
    return bool;
  }
  
  public static boolean Jf(String paramString)
  {
    AppMethodBeat.i(42891);
    if (paramString != null)
    {
      if ((paramString.equalsIgnoreCase("weixin")) || (paramString.equalsIgnoreCase("gh_9639b5a92773")))
      {
        AppMethodBeat.o(42891);
        return true;
      }
      AppMethodBeat.o(42891);
      return false;
    }
    AppMethodBeat.o(42891);
    return false;
  }
  
  public static boolean Jg(String paramString)
  {
    AppMethodBeat.i(42892);
    if (paramString != null)
    {
      boolean bool = paramString.equalsIgnoreCase("lbsapp");
      AppMethodBeat.o(42892);
      return bool;
    }
    AppMethodBeat.o(42892);
    return false;
  }
  
  public static boolean Jh(String paramString)
  {
    AppMethodBeat.i(42893);
    if (paramString != null)
    {
      boolean bool = paramString.equalsIgnoreCase("shakeapp");
      AppMethodBeat.o(42893);
      return bool;
    }
    AppMethodBeat.o(42893);
    return false;
  }
  
  public static boolean Ji(String paramString)
  {
    AppMethodBeat.i(42894);
    if (paramString != null)
    {
      boolean bool = paramString.equalsIgnoreCase("medianote");
      AppMethodBeat.o(42894);
      return bool;
    }
    AppMethodBeat.o(42894);
    return false;
  }
  
  public static boolean Jj(String paramString)
  {
    AppMethodBeat.i(42895);
    if (paramString != null)
    {
      boolean bool = paramString.equalsIgnoreCase("newsapp");
      AppMethodBeat.o(42895);
      return bool;
    }
    AppMethodBeat.o(42895);
    return false;
  }
  
  public static boolean Jk(String paramString)
  {
    AppMethodBeat.i(42896);
    if (paramString != null)
    {
      boolean bool = paramString.equalsIgnoreCase("topstoryapp");
      AppMethodBeat.o(42896);
      return bool;
    }
    AppMethodBeat.o(42896);
    return false;
  }
  
  public static boolean Jl(String paramString)
  {
    AppMethodBeat.i(42897);
    if (paramString != null)
    {
      boolean bool = paramString.equalsIgnoreCase("voipapp");
      AppMethodBeat.o(42897);
      return bool;
    }
    AppMethodBeat.o(42897);
    return false;
  }
  
  public static boolean Jm(String paramString)
  {
    AppMethodBeat.i(42898);
    if (paramString != null)
    {
      boolean bool = paramString.equalsIgnoreCase("voicevoipapp");
      AppMethodBeat.o(42898);
      return bool;
    }
    AppMethodBeat.o(42898);
    return false;
  }
  
  public static boolean Jn(String paramString)
  {
    AppMethodBeat.i(42899);
    if (paramString != null)
    {
      boolean bool = paramString.equalsIgnoreCase("voiceinputapp");
      AppMethodBeat.o(42899);
      return bool;
    }
    AppMethodBeat.o(42899);
    return false;
  }
  
  public static boolean Jo(String paramString)
  {
    AppMethodBeat.i(42900);
    if (paramString != null)
    {
      boolean bool = paramString.equalsIgnoreCase("linkedinplugin");
      AppMethodBeat.o(42900);
      return bool;
    }
    AppMethodBeat.o(42900);
    return false;
  }
  
  public static boolean Jp(String paramString)
  {
    AppMethodBeat.i(42901);
    boolean bool = Jq(paramString);
    AppMethodBeat.o(42901);
    return bool;
  }
  
  public static boolean Jq(String paramString)
  {
    AppMethodBeat.i(42902);
    if (paramString != null)
    {
      boolean bool = paramString.equalsIgnoreCase("gh_22b87fa7cb3c");
      AppMethodBeat.o(42902);
      return bool;
    }
    AppMethodBeat.o(42902);
    return false;
  }
  
  public static boolean Jr(String paramString)
  {
    AppMethodBeat.i(42903);
    if (paramString != null)
    {
      boolean bool = paramString.equalsIgnoreCase("blogapp");
      AppMethodBeat.o(42903);
      return bool;
    }
    AppMethodBeat.o(42903);
    return false;
  }
  
  public static boolean Js(String paramString)
  {
    AppMethodBeat.i(42904);
    if (paramString != null)
    {
      boolean bool = paramString.equalsIgnoreCase("officialaccounts");
      AppMethodBeat.o(42904);
      return bool;
    }
    AppMethodBeat.o(42904);
    return false;
  }
  
  public static boolean Jt(String paramString)
  {
    AppMethodBeat.i(42905);
    if (paramString != null)
    {
      boolean bool = paramString.equalsIgnoreCase("helper_entry");
      AppMethodBeat.o(42905);
      return bool;
    }
    AppMethodBeat.o(42905);
    return false;
  }
  
  public static boolean Ju(String paramString)
  {
    AppMethodBeat.i(42906);
    if (paramString != null)
    {
      boolean bool = paramString.equalsIgnoreCase("qqfriend");
      AppMethodBeat.o(42906);
      return bool;
    }
    AppMethodBeat.o(42906);
    return false;
  }
  
  public static boolean Jv(String paramString)
  {
    AppMethodBeat.i(42907);
    boolean bool = "filehelper".equalsIgnoreCase(paramString);
    AppMethodBeat.o(42907);
    return bool;
  }
  
  public static boolean Jw(String paramString)
  {
    AppMethodBeat.i(42908);
    if (paramString != null)
    {
      boolean bool = paramString.equalsIgnoreCase("pc_share");
      AppMethodBeat.o(42908);
      return bool;
    }
    AppMethodBeat.o(42908);
    return false;
  }
  
  public static boolean Jx(String paramString)
  {
    AppMethodBeat.i(42909);
    if (paramString != null)
    {
      boolean bool = paramString.equalsIgnoreCase("notifymessage");
      AppMethodBeat.o(42909);
      return bool;
    }
    AppMethodBeat.o(42909);
    return false;
  }
  
  public static boolean Jy(String paramString)
  {
    AppMethodBeat.i(42910);
    if (paramString != null)
    {
      boolean bool = paramString.equalsIgnoreCase("notification_messages");
      AppMethodBeat.o(42910);
      return bool;
    }
    AppMethodBeat.o(42910);
    return false;
  }
  
  public static boolean Jz(String paramString)
  {
    AppMethodBeat.i(42911);
    if (JA(paramString))
    {
      AppMethodBeat.o(42911);
      return true;
    }
    if (JE(paramString))
    {
      AppMethodBeat.o(42911);
      return true;
    }
    if (Js(paramString))
    {
      AppMethodBeat.o(42911);
      return true;
    }
    if (Jt(paramString))
    {
      AppMethodBeat.o(42911);
      return true;
    }
    AppMethodBeat.o(42911);
    return false;
  }
  
  public static void a(ar paramar)
  {
    iCD = paramar;
  }
  
  public static boolean a(az paramaz)
  {
    AppMethodBeat.i(42926);
    String str = paramaz.field_username;
    if (JE(str))
    {
      AppMethodBeat.o(42926);
      return false;
    }
    if (JA(str))
    {
      AppMethodBeat.o(42926);
      return false;
    }
    if (Js(str))
    {
      AppMethodBeat.o(42926);
      return false;
    }
    if (Jt(str))
    {
      AppMethodBeat.o(42926);
      return false;
    }
    if (paramaz.field_conversationTime == -1L)
    {
      AppMethodBeat.o(42926);
      return false;
    }
    if (IT(str))
    {
      AppMethodBeat.o(42926);
      return true;
    }
    AppMethodBeat.o(42926);
    return true;
  }
  
  public static int[] a(String paramString1, String paramString2, List<String> paramList, String[] paramArrayOfString)
  {
    AppMethodBeat.i(42878);
    int[] arrayOfInt = ((com.tencent.mm.plugin.messenger.foundation.a.l)g.af(com.tencent.mm.plugin.messenger.foundation.a.l.class)).aSN().b(paramString1, paramString2, paramArrayOfString, paramList);
    if (arrayOfInt.length <= 0)
    {
      AppMethodBeat.o(42878);
      return null;
    }
    paramString1 = ((com.tencent.mm.plugin.messenger.foundation.a.l)g.af(com.tencent.mm.plugin.messenger.foundation.a.l.class)).aSN().c(paramString1, paramString2, paramArrayOfString, paramList);
    if (paramString1 == null)
    {
      AppMethodBeat.o(42878);
      return null;
    }
    if (arrayOfInt.length == paramString1.length) {}
    for (boolean bool = true;; bool = false)
    {
      Assert.assertTrue(bool);
      paramString2 = new int[paramString1.length];
      int j = 0;
      int k = 0;
      int i = 0;
      while (j < arrayOfInt.length)
      {
        paramString2[i] = k;
        k += paramString1[j];
        j += 1;
        i += 1;
      }
    }
    AppMethodBeat.o(42878);
    return paramString2;
  }
  
  public static int[] a(String[] paramArrayOfString, String paramString1, String paramString2, List<String> paramList, String paramString3)
  {
    AppMethodBeat.i(225938);
    long l = System.currentTimeMillis();
    int[] arrayOfInt = ((com.tencent.mm.plugin.messenger.foundation.a.l)g.af(com.tencent.mm.plugin.messenger.foundation.a.l.class)).aSN().b(paramArrayOfString, paramString1, paramString2, paramString3, paramList);
    Log.d("MicroMsg.ContactStorageLogic", "kevin service(IMessengerStorage.class).getContactStg().getShowHeadDistinct(" + (System.currentTimeMillis() - l));
    if (arrayOfInt.length <= 0)
    {
      AppMethodBeat.o(225938);
      return null;
    }
    l = System.currentTimeMillis();
    paramArrayOfString = ((com.tencent.mm.plugin.messenger.foundation.a.l)g.af(com.tencent.mm.plugin.messenger.foundation.a.l.class)).aSN().c(paramArrayOfString, paramString1, paramString2, paramString3, paramList);
    Log.d("MicroMsg.ContactStorageLogic", "kevin service(IMessengerStorage.class).getContactStg().getSectionNumByShowHead" + (System.currentTimeMillis() - l));
    if (paramArrayOfString == null)
    {
      AppMethodBeat.o(225938);
      return null;
    }
    if (arrayOfInt.length != paramArrayOfString.length)
    {
      Log.e("MicroMsg.ContactStorageLogic", "[%s:%s] filterType:%s filterSearchStr:%s blocklist:%s searchString:%s", new Object[] { Integer.valueOf(arrayOfInt.length), Integer.valueOf(paramArrayOfString.length), paramString1, paramString2, paramList, paramString3 });
      AppMethodBeat.o(225938);
      return null;
    }
    paramString1 = new int[paramArrayOfString.length];
    int i = 0;
    int k = 0;
    int j = 0;
    while (j < arrayOfInt.length)
    {
      paramString1[i] = k;
      k += paramArrayOfString[j];
      j += 1;
      i += 1;
    }
    AppMethodBeat.o(225938);
    return paramString1;
  }
  
  public static String[] a(String paramString1, String paramString2, String[] paramArrayOfString, List<String> paramList)
  {
    AppMethodBeat.i(42879);
    long l = System.currentTimeMillis();
    paramString1 = ((com.tencent.mm.plugin.messenger.foundation.a.l)g.af(com.tencent.mm.plugin.messenger.foundation.a.l.class)).aSN().b(paramString1, paramString2, paramArrayOfString, paramList);
    Log.d("MicroMsg.ContactStorageLogic", "kevin service(IMessengerStorage.class).getContactStg().getShowSectionByShowHead" + (System.currentTimeMillis() - l));
    if (paramString1.length <= 0)
    {
      AppMethodBeat.o(42879);
      return null;
    }
    paramString2 = new String[paramString1.length];
    int j = 0;
    int i = 0;
    if (j < paramString1.length)
    {
      char c = (char)paramString1[j];
      int k;
      if (c == '{')
      {
        k = i + 1;
        paramString2[i] = "#";
        i = k;
      }
      for (;;)
      {
        j += 1;
        break;
        if (c == ' ')
        {
          k = i + 1;
          paramString2[i] = "$";
          i = k;
        }
        else
        {
          k = i + 1;
          paramString2[i] = String.valueOf(c);
          i = k;
        }
      }
    }
    AppMethodBeat.o(42879);
    return paramString2;
  }
  
  public static String[] a(String[] paramArrayOfString, String paramString1, String paramString2, String paramString3, List<String> paramList)
  {
    AppMethodBeat.i(225939);
    long l = System.currentTimeMillis();
    paramArrayOfString = ((com.tencent.mm.plugin.messenger.foundation.a.l)g.af(com.tencent.mm.plugin.messenger.foundation.a.l.class)).aSN().b(paramArrayOfString, paramString1, paramString2, paramString3, paramList);
    Log.d("MicroMsg.ContactStorageLogic", "kevin service(IMessengerStorage.class).getContactStg().getShowSectionByShowHead" + (System.currentTimeMillis() - l));
    if (paramArrayOfString.length <= 0)
    {
      AppMethodBeat.o(225939);
      return null;
    }
    paramString1 = new String[paramArrayOfString.length];
    int j = 0;
    int i = 0;
    if (j < paramArrayOfString.length)
    {
      char c = (char)paramArrayOfString[j];
      int k;
      if (c == '{')
      {
        k = i + 1;
        paramString1[i] = "#";
        i = k;
      }
      for (;;)
      {
        j += 1;
        break;
        if (c == ' ')
        {
          k = i + 1;
          paramString1[i] = "$";
          i = k;
        }
        else
        {
          k = i + 1;
          paramString1[i] = String.valueOf(c);
          i = k;
        }
      }
    }
    AppMethodBeat.o(225939);
    return paramString1;
  }
  
  public static List<String> aUU()
  {
    AppMethodBeat.i(42846);
    List localList = ((com.tencent.mm.plugin.messenger.foundation.a.l)g.af(com.tencent.mm.plugin.messenger.foundation.a.l.class)).aSN().gBZ();
    AppMethodBeat.o(42846);
    return localList;
  }
  
  public static List<as> aUV()
  {
    AppMethodBeat.i(42847);
    ArrayList localArrayList = new ArrayList();
    Cursor localCursor = ((com.tencent.mm.plugin.messenger.foundation.a.l)g.af(com.tencent.mm.plugin.messenger.foundation.a.l.class)).aSN().gCa();
    if (localCursor.moveToFirst()) {
      do
      {
        as localas = new as();
        localas.convertFrom(localCursor);
        localArrayList.add(localas);
      } while (localCursor.moveToNext());
    }
    localCursor.close();
    AppMethodBeat.o(42847);
    return localArrayList;
  }
  
  public static boolean aUW()
  {
    return false;
  }
  
  public static boolean aUX()
  {
    AppMethodBeat.i(42922);
    if (!z.aUM())
    {
      AppMethodBeat.o(42922);
      return false;
    }
    ci localci = ((com.tencent.mm.plugin.messenger.foundation.a.l)g.af(com.tencent.mm.plugin.messenger.foundation.a.l.class)).aSW().aEY("@t.qq.com");
    if ((localci == null) || (Util.isNullOrNil(localci.name)))
    {
      AppMethodBeat.o(42922);
      return false;
    }
    AppMethodBeat.o(42922);
    return true;
  }
  
  public static boolean aUY()
  {
    AppMethodBeat.i(42923);
    if (!z.aUM())
    {
      AppMethodBeat.o(42923);
      return false;
    }
    ci localci = ((com.tencent.mm.plugin.messenger.foundation.a.l)g.af(com.tencent.mm.plugin.messenger.foundation.a.l.class)).aSW().aEY("@t.qq.com");
    if ((localci == null) || (Util.nullAsNil(localci.name).length() == 0))
    {
      AppMethodBeat.o(42923);
      return false;
    }
    AppMethodBeat.o(42923);
    return true;
  }
  
  public static List<as> aUZ()
  {
    AppMethodBeat.i(42924);
    LinkedList localLinkedList = new LinkedList();
    Cursor localCursor = ((com.tencent.mm.plugin.messenger.foundation.a.l)g.af(com.tencent.mm.plugin.messenger.foundation.a.l.class)).aSN().gCd();
    if (localCursor.getCount() == 0)
    {
      localCursor.close();
      AppMethodBeat.o(42924);
      return localLinkedList;
    }
    localCursor.moveToFirst();
    do
    {
      as localas = new as();
      localas.convertFrom(localCursor);
      localLinkedList.add(localas);
    } while (localCursor.moveToNext());
    localCursor.close();
    Log.d("MicroMsg.ContactStorageLogic", "getFavourList size:  " + localLinkedList.size());
    AppMethodBeat.o(42924);
    return localLinkedList;
  }
  
  public static List<String> aVa()
  {
    AppMethodBeat.i(42925);
    LinkedList localLinkedList = new LinkedList();
    Cursor localCursor = ((com.tencent.mm.plugin.messenger.foundation.a.l)g.af(com.tencent.mm.plugin.messenger.foundation.a.l.class)).aSN().gCb();
    if (localCursor.getCount() == 0)
    {
      localCursor.close();
      AppMethodBeat.o(42925);
      return localLinkedList;
    }
    localCursor.moveToFirst();
    do
    {
      as localas = new as();
      localas.convertFrom(localCursor);
      localLinkedList.add(localas.field_username);
    } while (localCursor.moveToNext());
    localCursor.close();
    Log.d("MicroMsg.ContactStorageLogic", "getSnsBlackContactList size:  " + localLinkedList.size());
    AppMethodBeat.o(42925);
    return localLinkedList;
  }
  
  public static int aVb()
  {
    AppMethodBeat.i(42928);
    int i = ((com.tencent.mm.plugin.messenger.foundation.a.l)g.af(com.tencent.mm.plugin.messenger.foundation.a.l.class)).aSN().c(iCO, new String[] { z.aTY(), "weixin", "helper_entry", "filehelper" });
    AppMethodBeat.o(42928);
    return i;
  }
  
  public static int aVc()
  {
    AppMethodBeat.i(225942);
    int i = ((com.tencent.mm.plugin.messenger.foundation.a.l)g.af(com.tencent.mm.plugin.messenger.foundation.a.l.class)).aSN().gCn();
    AppMethodBeat.o(225942);
    return i;
  }
  
  public static int[] ap(List<String> paramList)
  {
    AppMethodBeat.i(42877);
    long l = System.currentTimeMillis();
    int[] arrayOfInt1 = ((com.tencent.mm.plugin.messenger.foundation.a.l)g.af(com.tencent.mm.plugin.messenger.foundation.a.l.class)).aSN().iV(paramList);
    Log.d("MicroMsg.ContactStorageLogic", "kevin service(IMessengerStorage.class).getContactStg().getShowHeadDistinct(" + (System.currentTimeMillis() - l));
    if (arrayOfInt1.length <= 0)
    {
      AppMethodBeat.o(42877);
      return null;
    }
    l = System.currentTimeMillis();
    paramList = ((com.tencent.mm.plugin.messenger.foundation.a.l)g.af(com.tencent.mm.plugin.messenger.foundation.a.l.class)).aSN().iW(paramList);
    Log.d("MicroMsg.ContactStorageLogic", "kevin service(IMessengerStorage.class).getContactStg().getSectionNumByShowHead" + (System.currentTimeMillis() - l));
    if (paramList == null)
    {
      AppMethodBeat.o(42877);
      return null;
    }
    if (arrayOfInt1.length == paramList.length) {}
    int[] arrayOfInt2;
    for (boolean bool = true;; bool = false)
    {
      Assert.assertTrue(bool);
      arrayOfInt2 = new int[paramList.length];
      int j = 0;
      int k = 0;
      int i = 0;
      while (j < arrayOfInt1.length)
      {
        arrayOfInt2[i] = k;
        k += paramList[j];
        j += 1;
        i += 1;
      }
    }
    AppMethodBeat.o(42877);
    return arrayOfInt2;
  }
  
  public static String[] aq(List<String> paramList)
  {
    AppMethodBeat.i(42881);
    long l = System.currentTimeMillis();
    paramList = ((com.tencent.mm.plugin.messenger.foundation.a.l)g.af(com.tencent.mm.plugin.messenger.foundation.a.l.class)).aSN().iV(paramList);
    Log.d("MicroMsg.ContactStorageLogic", "kevin service(IMessengerStorage.class).getContactStg().getShowSectionByShowHead" + (System.currentTimeMillis() - l));
    if (paramList.length <= 0)
    {
      AppMethodBeat.o(42881);
      return null;
    }
    String[] arrayOfString = new String[paramList.length];
    int j = 0;
    int i = 0;
    if (j < paramList.length)
    {
      char c = (char)paramList[j];
      int k;
      if (c == '{')
      {
        k = i + 1;
        arrayOfString[i] = "#";
        i = k;
      }
      for (;;)
      {
        j += 1;
        break;
        if (c == ' ')
        {
          k = i + 1;
          arrayOfString[i] = "$";
          i = k;
        }
        else
        {
          k = i + 1;
          arrayOfString[i] = String.valueOf(c);
          i = k;
        }
      }
    }
    AppMethodBeat.o(42881);
    return arrayOfString;
  }
  
  private static String b(String paramString, String[] paramArrayOfString)
  {
    AppMethodBeat.i(42929);
    Object localObject2 = " and ( 1 != 1 ";
    int j = paramArrayOfString.length;
    int i = 0;
    if (i < j)
    {
      String str = paramArrayOfString[i];
      Object localObject1;
      if ("@all.android".equals(str)) {
        localObject1 = (String)localObject2 + " or 1 = 1";
      }
      for (;;)
      {
        i += 1;
        localObject2 = localObject1;
        break;
        if ("@micromsg.qq.com".equals(str))
        {
          localObject1 = (String)localObject2 + " or " + paramString + " not like '%@%'";
        }
        else if ("@chatroom".equals(str))
        {
          localObject1 = (String)localObject2 + " or " + paramString + " like '%@chatroom'";
        }
        else if ("@talkroom".equals(str))
        {
          localObject1 = (String)localObject2 + " or " + paramString + " like '%@talkroom'";
        }
        else if ("@t.qq.com".equals(str))
        {
          localObject1 = (String)localObject2 + " or " + paramString + " like '%@t.qq.com'";
        }
        else if ("@qqim".equals(str))
        {
          localObject1 = (String)localObject2 + " or " + paramString + " like '%@qqim'";
        }
        else if ("@chatroom_exclusive".equals(str))
        {
          localObject1 = (String)localObject2 + " or " + paramString + "not like %@chatroom";
        }
        else if ("@app".equals(str))
        {
          localObject1 = (String)localObject2 + " or " + paramString + " like '%@app'";
        }
        else if ("@openim".equals(str))
        {
          localObject1 = (String)localObject2 + " or " + paramString + " like '%@openim'";
        }
        else
        {
          localObject1 = localObject2;
          if ("@im.chatroom".equals(str)) {
            localObject1 = (String)localObject2 + " or " + paramString + " like '%@im.chatroom'";
          }
        }
      }
    }
    paramString = (String)localObject2 + " ) ";
    AppMethodBeat.o(42929);
    return paramString;
  }
  
  public static boolean b(az paramaz)
  {
    AppMethodBeat.i(42927);
    paramaz = paramaz.field_username;
    if (Js(paramaz))
    {
      AppMethodBeat.o(42927);
      return false;
    }
    if (JB(paramaz))
    {
      AppMethodBeat.o(42927);
      return false;
    }
    if (JC(paramaz))
    {
      AppMethodBeat.o(42927);
      return false;
    }
    AppMethodBeat.o(42927);
    return true;
  }
  
  public static void c(as paramas, String paramString)
  {
    AppMethodBeat.i(42869);
    as localas = ((com.tencent.mm.plugin.messenger.foundation.a.l)g.af(com.tencent.mm.plugin.messenger.foundation.a.l.class)).aSN().Kn(paramas.field_username);
    if ((localas != null) && (paramString != null)) {}
    for (boolean bool = true;; bool = false)
    {
      Assert.assertTrue(bool);
      localas.BD(paramString);
      if ((as.bjp(paramas.field_username)) && (iCD != null)) {
        iCD.am(paramas.field_username, paramString);
      }
      G(localas);
      AppMethodBeat.o(42869);
      return;
    }
  }
  
  public static boolean p(as paramas)
  {
    AppMethodBeat.i(42840);
    if (paramas == null)
    {
      AppMethodBeat.o(42840);
      return false;
    }
    if (!Iw(paramas.field_username))
    {
      AppMethodBeat.o(42840);
      return false;
    }
    if (!com.tencent.mm.contact.c.oR(paramas.field_type))
    {
      AppMethodBeat.o(42840);
      return false;
    }
    AppMethodBeat.o(42840);
    return true;
  }
  
  public static void q(as paramas)
  {
    AppMethodBeat.i(42852);
    boolean bool;
    as localas2;
    if (paramas != null)
    {
      bool = true;
      Assert.assertTrue(bool);
      localas2 = ((com.tencent.mm.plugin.messenger.foundation.a.l)g.af(com.tencent.mm.plugin.messenger.foundation.a.l.class)).aSN().Kn(paramas.field_username);
      localas1 = paramas;
      if (localas2 != null) {
        if (!Util.isNullOrNil(localas2.field_username)) {
          break label77;
        }
      }
    }
    label77:
    for (as localas1 = paramas;; localas1 = localas2)
    {
      localas1.aqW();
      G(localas1);
      AppMethodBeat.o(42852);
      return;
      bool = false;
      break;
    }
  }
  
  public static void r(as paramas)
  {
    AppMethodBeat.i(42854);
    boolean bool;
    as localas2;
    if (paramas != null)
    {
      bool = true;
      Assert.assertTrue(bool);
      localas2 = ((com.tencent.mm.plugin.messenger.foundation.a.l)g.af(com.tencent.mm.plugin.messenger.foundation.a.l.class)).aSN().Kn(paramas.field_username);
      localas1 = paramas;
      if (localas2 != null) {
        if (!Util.isNullOrNil(localas2.field_username)) {
          break label77;
        }
      }
    }
    label77:
    for (as localas1 = paramas;; localas1 = localas2)
    {
      localas1.aqU();
      G(localas1);
      AppMethodBeat.o(42854);
      return;
      bool = false;
      break;
    }
  }
  
  public static boolean rQ(int paramInt)
  {
    AppMethodBeat.i(225932);
    Log.i("MicroMsg.ContactStorageLogic", "union luckymoney logic：isOpenImIncludeAssociateRoomOrOpenIMUser sceneid :%s ", new Object[] { Integer.valueOf(paramInt) });
    if (paramInt == 1005)
    {
      Log.i("MicroMsg.ContactStorageLogic", "union luckymoney logic：use union luckymoney ");
      AppMethodBeat.o(225932);
      return true;
    }
    Log.i("MicroMsg.ContactStorageLogic", "union luckymoney logic：use normal luckymoney ");
    AppMethodBeat.o(225932);
    return false;
  }
  
  public static boolean rR(int paramInt)
  {
    AppMethodBeat.i(42851);
    boolean bool = as.akh(paramInt);
    AppMethodBeat.o(42851);
    return bool;
  }
  
  public static void s(as paramas)
  {
    AppMethodBeat.i(42855);
    boolean bool;
    as localas2;
    if (paramas != null)
    {
      bool = true;
      Assert.assertTrue(bool);
      localas2 = ((com.tencent.mm.plugin.messenger.foundation.a.l)g.af(com.tencent.mm.plugin.messenger.foundation.a.l.class)).aSN().Kn(paramas.field_username);
      localas1 = paramas;
      if (localas2 != null) {
        if (!Util.isNullOrNil(localas2.field_username)) {
          break label77;
        }
      }
    }
    label77:
    for (as localas1 = paramas;; localas1 = localas2)
    {
      localas1.aqV();
      G(localas1);
      AppMethodBeat.o(42855);
      return;
      bool = false;
      break;
    }
  }
  
  public static void t(as paramas)
  {
    AppMethodBeat.i(42856);
    if (paramas != null) {}
    for (boolean bool = true;; bool = false)
    {
      Assert.assertTrue(bool);
      as localas2 = ((com.tencent.mm.plugin.messenger.foundation.a.l)g.af(com.tencent.mm.plugin.messenger.foundation.a.l.class)).aSN().Kn(paramas.field_username);
      as localas1;
      if (localas2 != null)
      {
        localas1 = localas2;
        if (!Util.isNullOrNil(localas2.field_username)) {}
      }
      else
      {
        localas1 = paramas;
      }
      localas1.aqS();
      if ((as.bjp(paramas.field_username)) && (iCD != null)) {
        iCD.EA(paramas.field_username);
      }
      G(localas1);
      AppMethodBeat.o(42856);
      return;
    }
  }
  
  public static void u(as paramas)
  {
    AppMethodBeat.i(42857);
    if (paramas != null) {}
    for (boolean bool = true;; bool = false)
    {
      Assert.assertTrue(bool);
      as localas2 = ((com.tencent.mm.plugin.messenger.foundation.a.l)g.af(com.tencent.mm.plugin.messenger.foundation.a.l.class)).aSN().Kn(paramas.field_username);
      as localas1;
      if (localas2 != null)
      {
        localas1 = localas2;
        if (!Util.isNullOrNil(localas2.field_username)) {}
      }
      else
      {
        localas1 = paramas;
      }
      localas1.aqT();
      if ((as.bjp(paramas.field_username)) && (iCD != null)) {
        iCD.EB(paramas.field_username);
      }
      G(localas1);
      paramas = ((com.tencent.mm.plugin.messenger.foundation.a.l)g.af(com.tencent.mm.plugin.messenger.foundation.a.l.class)).aST().bjY(paramas.field_username);
      if ((paramas != null) && ("@blacklist".equals(paramas.field_parentRef))) {
        ((com.tencent.mm.plugin.messenger.foundation.a.l)g.af(com.tencent.mm.plugin.messenger.foundation.a.l.class)).aST().c(new String[] { paramas.field_username }, "");
      }
      AppMethodBeat.o(42857);
      return;
    }
  }
  
  public static void v(as paramas)
  {
    AppMethodBeat.i(42858);
    if (paramas != null) {}
    for (boolean bool = true;; bool = false)
    {
      Assert.assertTrue(bool);
      as localas2 = ((com.tencent.mm.plugin.messenger.foundation.a.l)g.af(com.tencent.mm.plugin.messenger.foundation.a.l.class)).aSN().Kn(paramas.field_username);
      as localas1;
      if (localas2 != null)
      {
        localas1 = localas2;
        if (!Util.isNullOrNil(localas2.field_username)) {}
      }
      else
      {
        localas1 = paramas;
      }
      localas1.arf();
      localas1.nd(paramas.aqN());
      E(localas1);
      AppMethodBeat.o(42858);
      return;
    }
  }
  
  public static void w(as paramas)
  {
    AppMethodBeat.i(42859);
    if (paramas != null) {}
    for (boolean bool = true;; bool = false)
    {
      Assert.assertTrue(bool);
      as localas2 = ((com.tencent.mm.plugin.messenger.foundation.a.l)g.af(com.tencent.mm.plugin.messenger.foundation.a.l.class)).aSN().Kn(paramas.field_username);
      as localas1;
      if (localas2 != null)
      {
        localas1 = localas2;
        if (!Util.isNullOrNil(localas2.field_username)) {}
      }
      else
      {
        localas1 = paramas;
      }
      localas1.arg();
      localas1.nd(paramas.aqN());
      E(localas1);
      AppMethodBeat.o(42859);
      return;
    }
  }
  
  public static void x(as paramas)
  {
    AppMethodBeat.i(42860);
    if (paramas != null) {}
    for (boolean bool = true;; bool = false)
    {
      Assert.assertTrue(bool);
      as localas2 = ((com.tencent.mm.plugin.messenger.foundation.a.l)g.af(com.tencent.mm.plugin.messenger.foundation.a.l.class)).aSN().Kn(paramas.field_username);
      as localas1;
      if (localas2 != null)
      {
        localas1 = localas2;
        if (!Util.isNullOrNil(localas2.field_username)) {}
      }
      else
      {
        localas1 = paramas;
      }
      localas1.arb();
      localas1.nd(paramas.aqN());
      if ((as.bjp(paramas.field_username)) && (iCD != null)) {
        iCD.EC(paramas.field_username);
      }
      G(localas1);
      AppMethodBeat.o(42860);
      return;
    }
  }
  
  public static void y(as paramas)
  {
    AppMethodBeat.i(42861);
    if (paramas != null) {}
    for (boolean bool = true;; bool = false)
    {
      Assert.assertTrue(bool);
      as localas2 = ((com.tencent.mm.plugin.messenger.foundation.a.l)g.af(com.tencent.mm.plugin.messenger.foundation.a.l.class)).aSN().Kn(paramas.field_username);
      as localas1;
      if (localas2 != null)
      {
        localas1 = localas2;
        if (!Util.isNullOrNil(localas2.field_username)) {}
      }
      else
      {
        localas1 = paramas;
      }
      localas1.arc();
      localas1.nd(paramas.aqN());
      if ((as.bjp(paramas.field_username)) && (iCD != null)) {
        iCD.ED(paramas.field_username);
      }
      G(localas1);
      AppMethodBeat.o(42861);
      return;
    }
  }
  
  public static void z(as paramas)
  {
    AppMethodBeat.i(42865);
    if (paramas != null) {}
    for (boolean bool = true;; bool = false)
    {
      Assert.assertTrue(bool);
      as localas2 = ((com.tencent.mm.plugin.messenger.foundation.a.l)g.af(com.tencent.mm.plugin.messenger.foundation.a.l.class)).aSN().Kn(paramas.field_username);
      as localas1;
      if (localas2 != null)
      {
        localas1 = localas2;
        if (!Util.isNullOrNil(localas2.field_username)) {}
      }
      else
      {
        localas1 = paramas;
      }
      localas1.ard();
      if ((as.bjp(paramas.field_username)) && (iCD != null)) {
        iCD.EE(paramas.field_username);
      }
      G(localas1);
      AppMethodBeat.o(42865);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.model.ab
 * JD-Core Version:    0.7.0.1
 */