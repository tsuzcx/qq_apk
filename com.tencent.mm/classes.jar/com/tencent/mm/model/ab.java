package com.tencent.mm.model;

import android.database.Cursor;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.contact.d;
import com.tencent.mm.f.c.ax;
import com.tencent.mm.f.c.bb;
import com.tencent.mm.kernel.f;
import com.tencent.mm.kernel.h;
import com.tencent.mm.plugin.messenger.foundation.a.a.j;
import com.tencent.mm.plugin.messenger.foundation.a.a.k.a;
import com.tencent.mm.plugin.messenger.foundation.a.a.l;
import com.tencent.mm.plugin.messenger.foundation.a.n;
import com.tencent.mm.plugin.messenger.foundation.a.w;
import com.tencent.mm.protocal.protobuf.cyb;
import com.tencent.mm.protocal.protobuf.cyx;
import com.tencent.mm.protocal.protobuf.cyy;
import com.tencent.mm.protocal.protobuf.eae;
import com.tencent.mm.protocal.protobuf.eaf;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.ah;
import com.tencent.mm.storage.ao;
import com.tencent.mm.storage.az;
import com.tencent.mm.storage.bv;
import com.tencent.mm.storage.bw;
import com.tencent.mm.storage.cj;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import junit.framework.Assert;

public final class ab
{
  public static volatile boolean jxo;
  public static final String lsA;
  public static final String lsB;
  public static final String lsC;
  public static final String lsD;
  public static final String lsE;
  public static final String lsF;
  public static final String lsG;
  public static final String lsH;
  public static final String lsI;
  public static final String lsJ;
  public static final String lsK;
  public static final String lsL;
  public static final String lsM;
  public static final String lsN;
  public static final String[] lsO;
  private static as lsy;
  private static HashMap<String, Boolean> lsz;
  
  static
  {
    AppMethodBeat.i(42931);
    lsy = null;
    lsz = new HashMap();
    lsA = a("rconversation.username", new String[] { "@im.chatroom", "@chatroom", "@openim", "@micromsg.qq.com" }, new String[0]);
    lsB = b("rcontact.usernameFlag", new String[] { "@im.chatroom", "@chatroom", "@openim", "@micromsg.qq.com" }, new String[0]);
    lsC = a("rconversation.username", new String[] { "@chatroom", "@micromsg.qq.com" }, new String[0]);
    lsD = a("rconversation.username", new String[] { "@t.qq.com" }, new String[0]);
    lsE = a("rconversation.username", new String[] { "@qqim" }, new String[0]);
    lsF = b("rcontact.usernameFlag", new String[] { "@qqim" }, new String[0]);
    lsG = a("rconversation.username", new String[] { "@chatroom_exclusive" }, new String[0]);
    lsH = a("rconversation.username", new String[] { "@micromsg.qq.com" }, new String[0]);
    lsI = b("rcontact.usernameFlag", new String[] { "@micromsg.qq.com" }, new String[0]);
    lsJ = a("rconversation.username", new String[] { "@app" }, new String[0]);
    lsK = b("rcontact.usernameFlag", new String[] { "@app" }, new String[0]);
    lsL = a("rconversation.username", new String[] { "@chatroom" }, new String[0]);
    lsM = b("rcontact.usernameFlag", new String[] { "@chatroom" }, new String[0]);
    lsN = a("rconversation.username", new String[] { "@im.chatroom" }, new String[0]);
    lsO = new String[] { "qqmail", "fmessage", "tmessage", "qmessage", "qqsync", "floatbottle", "lbsapp", "shakeapp", "medianote", "qqfriend", "newsapp", "blogapp", "facebookapp", "topstoryapp", "masssendapp", "feedsapp", "voipapp", "cardpackage", "voicevoipapp", "voiceinputapp", "officialaccounts", "linkedinplugin", "notifymessage", "appbrandcustomerservicemsg", "appbrand_notify_message" };
    AppMethodBeat.o(42931);
  }
  
  public static void A(com.tencent.mm.storage.as paramas)
  {
    AppMethodBeat.i(42857);
    if (paramas != null) {}
    for (boolean bool = true;; bool = false)
    {
      Assert.assertTrue(bool);
      com.tencent.mm.storage.as localas2 = ((n)h.ae(n.class)).bbL().RG(paramas.field_username);
      com.tencent.mm.storage.as localas1;
      if (localas2 != null)
      {
        localas1 = localas2;
        if (!Util.isNullOrNil(localas2.field_username)) {}
      }
      else
      {
        localas1 = paramas;
      }
      localas1.axn();
      if ((com.tencent.mm.storage.as.bvK(paramas.field_username)) && (lsy != null)) {
        lsy.Lu(paramas.field_username);
      }
      M(localas1);
      paramas = ((n)h.ae(n.class)).bbR().bwx(paramas.field_username);
      if ((paramas != null) && ("@blacklist".equals(paramas.field_parentRef))) {
        ((n)h.ae(n.class)).bbR().c(new String[] { paramas.field_username }, "");
      }
      AppMethodBeat.o(42857);
      return;
    }
  }
  
  public static void B(com.tencent.mm.storage.as paramas)
  {
    AppMethodBeat.i(42858);
    if (paramas != null) {}
    for (boolean bool = true;; bool = false)
    {
      Assert.assertTrue(bool);
      com.tencent.mm.storage.as localas2 = ((n)h.ae(n.class)).bbL().RG(paramas.field_username);
      com.tencent.mm.storage.as localas1;
      if (localas2 != null)
      {
        localas1 = localas2;
        if (!Util.isNullOrNil(localas2.field_username)) {}
      }
      else
      {
        localas1 = paramas;
      }
      localas1.axD();
      localas1.pq(paramas.axh());
      K(localas1);
      AppMethodBeat.o(42858);
      return;
    }
  }
  
  public static void C(com.tencent.mm.storage.as paramas)
  {
    AppMethodBeat.i(42859);
    if (paramas != null) {}
    for (boolean bool = true;; bool = false)
    {
      Assert.assertTrue(bool);
      com.tencent.mm.storage.as localas2 = ((n)h.ae(n.class)).bbL().RG(paramas.field_username);
      com.tencent.mm.storage.as localas1;
      if (localas2 != null)
      {
        localas1 = localas2;
        if (!Util.isNullOrNil(localas2.field_username)) {}
      }
      else
      {
        localas1 = paramas;
      }
      localas1.axE();
      localas1.pq(paramas.axh());
      K(localas1);
      AppMethodBeat.o(42859);
      return;
    }
  }
  
  public static void D(com.tencent.mm.storage.as paramas)
  {
    AppMethodBeat.i(42860);
    if (paramas != null) {}
    for (boolean bool = true;; bool = false)
    {
      Assert.assertTrue(bool);
      com.tencent.mm.storage.as localas2 = ((n)h.ae(n.class)).bbL().RG(paramas.field_username);
      com.tencent.mm.storage.as localas1;
      if (localas2 != null)
      {
        localas1 = localas2;
        if (!Util.isNullOrNil(localas2.field_username)) {}
      }
      else
      {
        localas1 = paramas;
      }
      localas1.axz();
      localas1.pq(paramas.axh());
      if ((com.tencent.mm.storage.as.bvK(paramas.field_username)) && (lsy != null)) {
        lsy.Lv(paramas.field_username);
      }
      M(localas1);
      AppMethodBeat.o(42860);
      return;
    }
  }
  
  public static void E(com.tencent.mm.storage.as paramas)
  {
    AppMethodBeat.i(42861);
    if (paramas != null) {}
    for (boolean bool = true;; bool = false)
    {
      Assert.assertTrue(bool);
      com.tencent.mm.storage.as localas2 = ((n)h.ae(n.class)).bbL().RG(paramas.field_username);
      com.tencent.mm.storage.as localas1;
      if (localas2 != null)
      {
        localas1 = localas2;
        if (!Util.isNullOrNil(localas2.field_username)) {}
      }
      else
      {
        localas1 = paramas;
      }
      localas1.axA();
      localas1.pq(paramas.axh());
      if ((com.tencent.mm.storage.as.bvK(paramas.field_username)) && (lsy != null)) {
        lsy.Lw(paramas.field_username);
      }
      M(localas1);
      AppMethodBeat.o(42861);
      return;
    }
  }
  
  public static void F(com.tencent.mm.storage.as paramas)
  {
    AppMethodBeat.i(42865);
    if (paramas != null) {}
    for (boolean bool = true;; bool = false)
    {
      Assert.assertTrue(bool);
      com.tencent.mm.storage.as localas2 = ((n)h.ae(n.class)).bbL().RG(paramas.field_username);
      com.tencent.mm.storage.as localas1;
      if (localas2 != null)
      {
        localas1 = localas2;
        if (!Util.isNullOrNil(localas2.field_username)) {}
      }
      else
      {
        localas1 = paramas;
      }
      localas1.axB();
      if ((com.tencent.mm.storage.as.bvK(paramas.field_username)) && (lsy != null)) {
        lsy.Lx(paramas.field_username);
      }
      M(localas1);
      AppMethodBeat.o(42865);
      return;
    }
  }
  
  public static void F(String paramString, boolean paramBoolean)
  {
    AppMethodBeat.i(42853);
    paramString = ((n)h.ae(n.class)).bbL().RG(paramString);
    if ((paramString == null) || (Util.isNullOrNil(paramString.field_username)))
    {
      AppMethodBeat.o(42853);
      return;
    }
    if (paramBoolean) {
      paramString.axD();
    }
    for (;;)
    {
      K(paramString);
      AppMethodBeat.o(42853);
      return;
      paramString.axE();
    }
  }
  
  public static void G(com.tencent.mm.storage.as paramas)
  {
    AppMethodBeat.i(42866);
    if (paramas != null) {}
    for (boolean bool = true;; bool = false)
    {
      Assert.assertTrue(bool);
      com.tencent.mm.storage.as localas2 = ((n)h.ae(n.class)).bbL().RG(paramas.field_username);
      com.tencent.mm.storage.as localas1;
      if (localas2 != null)
      {
        localas1 = localas2;
        if (!Util.isNullOrNil(localas2.field_username)) {}
      }
      else
      {
        localas1 = paramas;
      }
      localas1.axC();
      if ((com.tencent.mm.storage.as.bvK(paramas.field_username)) && (lsy != null)) {
        lsy.Ly(paramas.field_username);
      }
      M(localas1);
      AppMethodBeat.o(42866);
      return;
    }
  }
  
  public static void G(String paramString, boolean paramBoolean)
  {
    AppMethodBeat.i(42862);
    if (!Util.isNullOrNil(paramString)) {}
    com.tencent.mm.storage.as localas;
    for (boolean bool = true;; bool = false)
    {
      Assert.assertTrue(bool);
      localas = ((n)h.ae(n.class)).bbL().RG(paramString);
      if ((localas != null) && (!Util.isNullOrNil(localas.field_username))) {
        break;
      }
      AppMethodBeat.o(42862);
      return;
    }
    localas.setType(localas.field_type | 0x800);
    if (((com.tencent.mm.storage.as.bvK(paramString)) || (PQ(paramString))) && (lsy != null)) {
      lsy.Lr(paramString);
    }
    M(localas);
    if (paramBoolean) {
      ((n)h.ae(n.class)).bbR().bwD(paramString);
    }
    AppMethodBeat.o(42862);
  }
  
  public static void H(com.tencent.mm.storage.as paramas)
  {
    boolean bool2 = true;
    AppMethodBeat.i(42867);
    if (paramas != null)
    {
      bool1 = true;
      Assert.assertTrue("MicroMsg.ContactStorageLogic: user is null", bool1);
      if ((int)paramas.jxt == 0) {
        break label97;
      }
      bool1 = true;
      label31:
      Assert.assertTrue("MicroMsg.ContactStorageLogic: contactId == 0", bool1);
      if (paramas.field_username.length() <= 0) {
        break label102;
      }
    }
    label97:
    label102:
    for (boolean bool1 = bool2;; bool1 = false)
    {
      Assert.assertTrue("MicroMsg.ContactStorageLogic: username length <= 0", bool1);
      paramas.axk();
      ((n)h.ae(n.class)).bbL().c(paramas.field_username, paramas);
      AppMethodBeat.o(42867);
      return;
      bool1 = false;
      break;
      bool1 = false;
      break label31;
    }
  }
  
  public static void H(String paramString, boolean paramBoolean)
  {
    AppMethodBeat.i(42864);
    if (!Util.isNullOrNil(paramString)) {}
    com.tencent.mm.storage.as localas;
    for (boolean bool = true;; bool = false)
    {
      Assert.assertTrue(bool);
      localas = ((n)h.ae(n.class)).bbL().RG(paramString);
      if ((localas != null) && (!Util.isNullOrNil(localas.field_username))) {
        break;
      }
      AppMethodBeat.o(42864);
      return;
    }
    localas.setType(localas.field_type & 0xFFFFF7FF);
    if (((com.tencent.mm.storage.as.bvK(paramString)) || (PQ(paramString))) && (lsy != null)) {
      lsy.Ls(paramString);
    }
    M(localas);
    if (paramBoolean) {
      ((n)h.ae(n.class)).bbR().bwE(paramString);
    }
    AppMethodBeat.o(42864);
  }
  
  public static void I(com.tencent.mm.storage.as paramas)
  {
    boolean bool2 = true;
    AppMethodBeat.i(42868);
    if (paramas != null)
    {
      bool1 = true;
      Assert.assertTrue(bool1);
      if ((int)paramas.jxt == 0) {
        break label92;
      }
      bool1 = true;
      label28:
      Assert.assertTrue(bool1);
      if (paramas.field_username.length() <= 0) {
        break label97;
      }
    }
    label92:
    label97:
    for (boolean bool1 = bool2;; bool1 = false)
    {
      Assert.assertTrue(bool1);
      paramas.axk();
      ((n)h.ae(n.class)).bbL().c(paramas.field_username, paramas);
      M(paramas);
      AppMethodBeat.o(42868);
      return;
      bool1 = false;
      break;
      bool1 = false;
      break label28;
    }
  }
  
  public static void J(com.tencent.mm.storage.as paramas)
  {
    boolean bool2 = true;
    AppMethodBeat.i(42870);
    if (paramas != null)
    {
      bool1 = true;
      Assert.assertTrue(bool1);
      if ((int)paramas.jxt == 0) {
        break label68;
      }
      bool1 = true;
      label28:
      Assert.assertTrue(bool1);
      if (paramas.field_username.length() <= 0) {
        break label73;
      }
    }
    label68:
    label73:
    for (boolean bool1 = bool2;; bool1 = false)
    {
      Assert.assertTrue(bool1);
      paramas.ayp();
      M(paramas);
      AppMethodBeat.o(42870);
      return;
      bool1 = false;
      break;
      bool1 = false;
      break label28;
    }
  }
  
  private static void K(com.tencent.mm.storage.as paramas)
  {
    AppMethodBeat.i(42871);
    boolean bool;
    cyx localcyx;
    if (paramas != null)
    {
      bool = true;
      Assert.assertTrue(bool);
      if ((int)paramas.jxt == 0)
      {
        ((n)h.ae(n.class)).bbL().aw(paramas);
        ((n)h.ae(n.class)).bbL().RG(paramas.field_username);
      }
      ((n)h.ae(n.class)).bbL().c(paramas.field_username, paramas);
      localcyx = new cyx();
      localcyx.TGE = paramas.field_username;
      if (!paramas.ayi()) {
        break label159;
      }
    }
    label159:
    for (localcyx.TGA = 1;; localcyx.TGA = 2)
    {
      ((n)h.ae(n.class)).bbK().d(new k.a(52, localcyx));
      AppMethodBeat.o(42871);
      return;
      bool = false;
      break;
    }
  }
  
  public static void L(com.tencent.mm.storage.as paramas)
  {
    AppMethodBeat.i(42872);
    boolean bool;
    cyy localcyy;
    if (paramas != null)
    {
      bool = true;
      Assert.assertTrue(bool);
      if ((int)paramas.jxt == 0)
      {
        ((n)h.ae(n.class)).bbL().aw(paramas);
        ((n)h.ae(n.class)).bbL().RG(paramas.field_username);
      }
      ((n)h.ae(n.class)).bbL().c(paramas.field_username, paramas);
      localcyy = new cyy();
      localcyy.TGE = paramas.field_username;
      if (!paramas.ayk()) {
        break label159;
      }
    }
    label159:
    for (localcyy.TGA = 1;; localcyy.TGA = 2)
    {
      ((n)h.ae(n.class)).bbK().d(new k.a(72, localcyy));
      AppMethodBeat.o(42872);
      return;
      bool = false;
      break;
    }
  }
  
  public static boolean Lj(String paramString)
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
  
  public static void M(com.tencent.mm.storage.as paramas)
  {
    AppMethodBeat.i(42873);
    if (paramas != null) {}
    for (boolean bool = true;; bool = false)
    {
      Assert.assertTrue(bool);
      if ((int)paramas.jxt == 0)
      {
        ((n)h.ae(n.class)).bbL().aw(paramas);
        ((n)h.ae(n.class)).bbL().RG(paramas.field_username);
      }
      ((n)h.ae(n.class)).bbL().c(paramas.field_username, paramas);
      if (!com.tencent.mm.storage.as.bvK(paramas.field_username)) {
        P(paramas);
      }
      AppMethodBeat.o(42873);
      return;
    }
  }
  
  private static void N(com.tencent.mm.storage.as paramas)
  {
    AppMethodBeat.i(241318);
    if (paramas != null) {}
    for (boolean bool = true;; bool = false)
    {
      Assert.assertTrue(bool);
      if ((int)paramas.jxt == 0)
      {
        ((n)h.ae(n.class)).bbL().aw(paramas);
        ((n)h.ae(n.class)).bbL().RG(paramas.field_username);
      }
      ((n)h.ae(n.class)).bbL().c(paramas.field_username, paramas);
      AppMethodBeat.o(241318);
      return;
    }
  }
  
  public static cyb O(com.tencent.mm.storage.as paramas)
  {
    AppMethodBeat.i(241321);
    Log.i("MicroMsg.ContactStorageLogic", "oplog modContact user:%s remark:%s type:%d ", new Object[] { paramas.field_username, paramas.field_conRemark, Integer.valueOf(paramas.field_type) });
    cyb localcyb = new cyb();
    localcyb.SrH = new eaf().btQ(Util.nullAsNil(paramas.field_username));
    localcyb.TtX = new eaf().btQ(Util.nullAsNil(paramas.field_nickname));
    localcyb.SqW = new eaf().btQ(Util.nullAsNil(paramas.aph()));
    localcyb.SqX = new eaf().btQ(Util.nullAsNil(paramas.api()));
    localcyb.mVy = paramas.sex;
    localcyb.Sqc = 178229119;
    localcyb.Sqd = paramas.field_type;
    localcyb.TFz = new eaf().btQ(Util.nullAsNil(paramas.field_conRemark));
    localcyb.TFA = new eaf().btQ(Util.nullAsNil(paramas.field_conRemarkPYShort));
    localcyb.TFB = new eaf().btQ(Util.nullAsNil(paramas.field_conRemarkPYFull));
    localcyb.Sqi = paramas.hDg;
    localcyb.TGf = new eaf().btQ(Util.nullAsNil(paramas.field_domainList));
    localcyb.Sqm = paramas.hDj;
    localcyb.mVC = paramas.hDk;
    localcyb.mVB = Util.nullAsNil(paramas.signature);
    localcyb.mVA = Util.nullAsNil(paramas.getCityCode());
    localcyb.mVz = Util.nullAsNil(paramas.hyc());
    localcyb.TxH = Util.nullAsNil(paramas.hDm);
    localcyb.TxJ = paramas.field_weiboFlag;
    localcyb.TGb = 0;
    localcyb.RIH = new eae();
    localcyb.mVH = Util.nullAsNil(paramas.getCountryCode());
    AppMethodBeat.o(241321);
    return localcyb;
  }
  
  public static void P(com.tencent.mm.storage.as paramas)
  {
    AppMethodBeat.i(42874);
    ((n)h.ae(n.class)).bbK().d(new k.a(2, O(paramas)));
    AppMethodBeat.o(42874);
  }
  
  public static boolean PM(String paramString)
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
  
  public static boolean PN(String paramString)
  {
    AppMethodBeat.i(241292);
    if ((paramString == null) || (paramString.length() <= 0))
    {
      AppMethodBeat.o(241292);
      return false;
    }
    boolean bool = paramString.equalsIgnoreCase("weixin");
    AppMethodBeat.o(241292);
    return bool;
  }
  
  public static boolean PO(String paramString)
  {
    AppMethodBeat.i(42832);
    if ((PP(paramString)) || (PQ(paramString)))
    {
      AppMethodBeat.o(42832);
      return true;
    }
    AppMethodBeat.o(42832);
    return false;
  }
  
  public static boolean PP(String paramString)
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
  
  public static boolean PQ(String paramString)
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
  
  public static boolean PR(String paramString)
  {
    AppMethodBeat.i(178864);
    if ((paramString == null) || (paramString.length() <= 0))
    {
      AppMethodBeat.o(178864);
      return false;
    }
    if ((paramString.endsWith("@im.chatroom")) || (PT(paramString)))
    {
      AppMethodBeat.o(178864);
      return true;
    }
    AppMethodBeat.o(178864);
    return false;
  }
  
  public static boolean PS(String paramString)
  {
    AppMethodBeat.i(241294);
    if ((paramString == null) || (paramString.length() <= 0))
    {
      Log.i("MicroMsg.ContactStorageLogic", "union luckymoney logic：isOpenImIncludeAssociateRoomOrOpenIMUser :(username == null) || (username.length() <= 0) ");
      AppMethodBeat.o(241294);
      return false;
    }
    if ((PR(paramString)) || (com.tencent.mm.storage.as.bvK(paramString))) {}
    for (boolean bool = true;; bool = false)
    {
      Log.i("MicroMsg.ContactStorageLogic", "union luckymoney logic：isOpenImIncludeAssociateRoomOrOpenIMUser :%s ", new Object[] { Boolean.valueOf(bool) });
      AppMethodBeat.o(241294);
      return bool;
    }
  }
  
  public static boolean PT(String paramString)
  {
    AppMethodBeat.i(178865);
    Boolean localBoolean;
    Object localObject;
    if (PP(paramString))
    {
      localBoolean = null;
      if (lsz.containsKey(paramString)) {
        localBoolean = (Boolean)lsz.get(paramString);
      }
      localObject = localBoolean;
      if (localBoolean == null)
      {
        localBoolean = Boolean.FALSE;
        localObject = ((com.tencent.mm.plugin.chatroom.a.b)h.ae(com.tencent.mm.plugin.chatroom.a.b.class)).bbV().Rw(paramString);
        if ((localObject == null) || ((((ah)localObject).field_chatroomStatus & 0x20000) != 131072)) {
          break label121;
        }
        localBoolean = Boolean.TRUE;
      }
    }
    label121:
    for (;;)
    {
      lsz.put(paramString, localBoolean);
      localObject = localBoolean;
      boolean bool = ((Boolean)localObject).booleanValue();
      AppMethodBeat.o(178865);
      return bool;
      AppMethodBeat.o(178865);
      return false;
    }
  }
  
  public static void PU(String paramString)
  {
    AppMethodBeat.i(241300);
    lsz.remove(paramString);
    AppMethodBeat.o(241300);
  }
  
  public static boolean PV(String paramString)
  {
    AppMethodBeat.i(178866);
    if (PP(paramString))
    {
      paramString = ((com.tencent.mm.plugin.chatroom.a.b)h.ae(com.tencent.mm.plugin.chatroom.a.b.class)).bbV().Rw(paramString);
      if ((paramString != null) && ((paramString.field_chatroomStatus & 0x20000) != 131072) && ((paramString.field_chatroomStatus & 0x10000) == 65536))
      {
        AppMethodBeat.o(178866);
        return true;
      }
    }
    AppMethodBeat.o(178866);
    return false;
  }
  
  public static boolean PW(String paramString)
  {
    AppMethodBeat.i(178867);
    if ((((w)h.ae(w.class)).asb()) && (PP(paramString)))
    {
      paramString = ((com.tencent.mm.plugin.chatroom.a.b)h.ae(com.tencent.mm.plugin.chatroom.a.b.class)).bbV().Rw(paramString);
      if ((paramString != null) && (paramString.asE()))
      {
        AppMethodBeat.o(178867);
        return true;
      }
    }
    AppMethodBeat.o(178867);
    return false;
  }
  
  public static boolean PX(String paramString)
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
  
  public static boolean PY(String paramString)
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
  
  public static boolean PZ(String paramString)
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
  
  public static boolean Q(com.tencent.mm.storage.as paramas)
  {
    return (paramas.field_weiboFlag & 0x1) != 0;
  }
  
  public static boolean QA(String paramString)
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
  
  public static boolean QB(String paramString)
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
  
  public static boolean QC(String paramString)
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
  
  public static boolean QD(String paramString)
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
  
  public static boolean QE(String paramString)
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
  
  public static boolean QF(String paramString)
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
  
  public static boolean QG(String paramString)
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
  
  public static boolean QH(String paramString)
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
  
  public static boolean QI(String paramString)
  {
    AppMethodBeat.i(42901);
    boolean bool = QJ(paramString);
    AppMethodBeat.o(42901);
    return bool;
  }
  
  public static boolean QJ(String paramString)
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
  
  public static boolean QK(String paramString)
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
  
  public static boolean QL(String paramString)
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
  
  public static boolean QM(String paramString)
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
  
  public static boolean QN(String paramString)
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
  
  public static boolean QO(String paramString)
  {
    AppMethodBeat.i(42907);
    boolean bool = "filehelper".equalsIgnoreCase(paramString);
    AppMethodBeat.o(42907);
    return bool;
  }
  
  public static boolean QP(String paramString)
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
  
  public static boolean QQ(String paramString)
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
  
  public static boolean QR(String paramString)
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
  
  public static boolean QS(String paramString)
  {
    AppMethodBeat.i(42911);
    if (QT(paramString))
    {
      AppMethodBeat.o(42911);
      return true;
    }
    if (QX(paramString))
    {
      AppMethodBeat.o(42911);
      return true;
    }
    if (QL(paramString))
    {
      AppMethodBeat.o(42911);
      return true;
    }
    if (QM(paramString))
    {
      AppMethodBeat.o(42911);
      return true;
    }
    AppMethodBeat.o(42911);
    return false;
  }
  
  public static boolean QT(String paramString)
  {
    AppMethodBeat.i(42912);
    h.aHH();
    String str = (String)h.aHG().aHp().b(21, null);
    if (((str != null) && (str.equalsIgnoreCase(paramString))) || (paramString.equalsIgnoreCase("weixin")))
    {
      AppMethodBeat.o(42912);
      return true;
    }
    AppMethodBeat.o(42912);
    return false;
  }
  
  public static boolean QU(String paramString)
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
  
  public static boolean QV(String paramString)
  {
    AppMethodBeat.i(241359);
    if (paramString != null)
    {
      boolean bool = paramString.equalsIgnoreCase("appbrand_notify_message");
      AppMethodBeat.o(241359);
      return bool;
    }
    AppMethodBeat.o(241359);
    return false;
  }
  
  public static boolean QW(String paramString)
  {
    AppMethodBeat.i(241361);
    if (paramString != null)
    {
      boolean bool = paramString.equalsIgnoreCase("findersayhisessionholder");
      AppMethodBeat.o(241361);
      return bool;
    }
    AppMethodBeat.o(241361);
    return false;
  }
  
  public static boolean QX(String paramString)
  {
    AppMethodBeat.i(42914);
    String[] arrayOfString = lsO;
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
  
  public static boolean QY(String paramString)
  {
    AppMethodBeat.i(42915);
    if (QX(paramString))
    {
      AppMethodBeat.o(42915);
      return true;
    }
    if (com.tencent.mm.storage.as.bvJ(paramString))
    {
      AppMethodBeat.o(42915);
      return true;
    }
    if (com.tencent.mm.storage.as.bvH(paramString))
    {
      AppMethodBeat.o(42915);
      return true;
    }
    if (com.tencent.mm.storage.as.PY(paramString))
    {
      AppMethodBeat.o(42915);
      return true;
    }
    AppMethodBeat.o(42915);
    return false;
  }
  
  public static int QZ(String paramString)
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
    if (com.tencent.mm.storage.as.bvH(paramString))
    {
      AppMethodBeat.o(42916);
      return 11;
    }
    if (com.tencent.mm.storage.as.bvJ(paramString))
    {
      AppMethodBeat.o(42916);
      return 36;
    }
    if (com.tencent.mm.storage.as.PY(paramString))
    {
      AppMethodBeat.o(42916);
      return 1;
    }
    AppMethodBeat.o(42916);
    return 1;
  }
  
  public static boolean Qa(String paramString)
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
  
  public static boolean Qb(String paramString)
  {
    AppMethodBeat.i(42841);
    boolean bool = "gh_43f2581f6fd6".equals(paramString);
    AppMethodBeat.o(42841);
    return bool;
  }
  
  public static boolean Qc(String paramString)
  {
    AppMethodBeat.i(42842);
    boolean bool = "gh_3dfda90e39d6".equals(paramString);
    AppMethodBeat.o(42842);
    return bool;
  }
  
  public static boolean Qd(String paramString)
  {
    AppMethodBeat.i(241301);
    boolean bool = "gh_b4af18eac3d5".equals(paramString);
    AppMethodBeat.o(241301);
    return bool;
  }
  
  public static boolean Qe(String paramString)
  {
    AppMethodBeat.i(241302);
    boolean bool = "gh_f0a92aa7146c".equals(paramString);
    AppMethodBeat.o(241302);
    return bool;
  }
  
  public static boolean Qf(String paramString)
  {
    AppMethodBeat.i(241303);
    boolean bool = "gh_579db1f2cf89".equals(paramString);
    AppMethodBeat.o(241303);
    return bool;
  }
  
  public static boolean Qg(String paramString)
  {
    AppMethodBeat.i(163508);
    boolean bool = "1@fackuser".equals(paramString);
    AppMethodBeat.o(163508);
    return bool;
  }
  
  public static boolean Qh(String paramString)
  {
    AppMethodBeat.i(241304);
    boolean bool = "msginfo@fakeuser".equals(paramString);
    AppMethodBeat.o(241304);
    return bool;
  }
  
  public static boolean Qi(String paramString)
  {
    AppMethodBeat.i(42843);
    boolean bool = "downloaderapp".equals(paramString);
    AppMethodBeat.o(42843);
    return bool;
  }
  
  public static boolean Qj(String paramString)
  {
    AppMethodBeat.i(42844);
    if ((paramString == null) || (paramString.length() <= 0))
    {
      AppMethodBeat.o(42844);
      return false;
    }
    if (!PO(paramString))
    {
      AppMethodBeat.o(42844);
      return false;
    }
    paramString = ((n)h.ae(n.class)).bbL().RG(paramString);
    if ((paramString == null) || (!d.rk(paramString.field_type)))
    {
      AppMethodBeat.o(42844);
      return false;
    }
    AppMethodBeat.o(42844);
    return true;
  }
  
  public static boolean Qk(String paramString)
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
  
  public static boolean Ql(String paramString)
  {
    AppMethodBeat.i(42849);
    if ((paramString == null) || (paramString.length() <= 0))
    {
      AppMethodBeat.o(42849);
      return true;
    }
    boolean bool = d.rk(((n)h.ae(n.class)).bbL().RG(paramString).field_type);
    AppMethodBeat.o(42849);
    return bool;
  }
  
  public static boolean Qm(String paramString)
  {
    AppMethodBeat.i(42850);
    if (Util.isNullOrNil(paramString))
    {
      AppMethodBeat.o(42850);
      return false;
    }
    paramString = ((n)h.ae(n.class)).bbL().RG(paramString);
    if (paramString == null)
    {
      AppMethodBeat.o(42850);
      return false;
    }
    boolean bool = com.tencent.mm.storage.as.asD(paramString.field_verifyFlag);
    AppMethodBeat.o(42850);
    return bool;
  }
  
  public static void Qn(String paramString)
  {
    AppMethodBeat.i(42863);
    az localaz2 = ((n)h.ae(n.class)).bbR().bwx(paramString);
    int i = 0;
    az localaz1 = localaz2;
    if (localaz2 == null)
    {
      localaz1 = new az();
      localaz1.hyE();
      i = 1;
      localaz1.setUsername(paramString);
    }
    localaz1.EB(System.currentTimeMillis());
    if (i != 0)
    {
      ((n)h.ae(n.class)).bbR().e(localaz1);
      AppMethodBeat.o(42863);
      return;
    }
    ((n)h.ae(n.class)).bbR().a(localaz1, paramString);
    AppMethodBeat.o(42863);
  }
  
  public static void Qo(String paramString)
  {
    AppMethodBeat.i(42875);
    if (Util.isNullOrNil(paramString))
    {
      AppMethodBeat.o(42875);
      return;
    }
    com.tencent.mm.storage.as localas = ((n)h.ae(n.class)).bbL().RG(paramString);
    if (localas == null)
    {
      AppMethodBeat.o(42875);
      return;
    }
    localas.setSource(0);
    localas.axi();
    ((n)h.ae(n.class)).bbL().c(paramString, localas);
    AppMethodBeat.o(42875);
  }
  
  public static boolean Qp(String paramString)
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
  
  public static boolean Qq(String paramString)
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
  
  public static boolean Qr(String paramString)
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
  
  public static boolean Qs(String paramString)
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
  
  public static boolean Qt(String paramString)
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
  
  public static boolean Qu(String paramString)
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
  
  public static boolean Qv(String paramString)
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
  
  public static boolean Qw(String paramString)
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
  
  public static boolean Qx(String paramString)
  {
    AppMethodBeat.i(42890);
    boolean bool = "qqsync".equalsIgnoreCase(paramString);
    AppMethodBeat.o(42890);
    return bool;
  }
  
  public static boolean Qy(String paramString)
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
  
  public static boolean Qz(String paramString)
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
  
  public static int Ra(String paramString)
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
    if (com.tencent.mm.storage.as.bvH(paramString))
    {
      AppMethodBeat.o(42917);
      return 13;
    }
    if (com.tencent.mm.storage.as.bvJ(paramString))
    {
      AppMethodBeat.o(42917);
      return 39;
    }
    if (com.tencent.mm.storage.as.PY(paramString))
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
  
  public static boolean Rb(String paramString)
  {
    AppMethodBeat.i(42918);
    if (((n)h.ae(n.class)).bbL().RG(paramString).hDj != 1)
    {
      AppMethodBeat.o(42918);
      return false;
    }
    AppMethodBeat.o(42918);
    return true;
  }
  
  public static boolean Rc(String paramString)
  {
    AppMethodBeat.i(42919);
    paramString = ((n)h.ae(n.class)).bbL().RG(paramString);
    if ((paramString != null) && (paramString.aeg()))
    {
      AppMethodBeat.o(42919);
      return true;
    }
    AppMethodBeat.o(42919);
    return false;
  }
  
  public static boolean Rd(String paramString)
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
  
  public static String Re(String paramString)
  {
    AppMethodBeat.i(42921);
    if (Rd(paramString))
    {
      paramString = paramString.replace("http://t.qq.com/", "").replace("t.qq.com/", "");
      AppMethodBeat.o(42921);
      return paramString;
    }
    AppMethodBeat.o(42921);
    return "";
  }
  
  public static boolean Rf(String paramString)
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
  
  public static boolean Rg(String paramString)
  {
    AppMethodBeat.i(178868);
    paramString = ((com.tencent.mm.plugin.chatroom.a.b)h.ae(com.tencent.mm.plugin.chatroom.a.b.class)).bbV().Rw(paramString);
    if (paramString == null)
    {
      AppMethodBeat.o(178868);
      return false;
    }
    boolean bool = paramString.asE();
    AppMethodBeat.o(178868);
    return bool;
  }
  
  public static boolean Rh(String paramString)
  {
    AppMethodBeat.i(184702);
    paramString = ((com.tencent.mm.plugin.chatroom.a.b)h.ae(com.tencent.mm.plugin.chatroom.a.b.class)).bbV().Rw(paramString);
    if (paramString == null)
    {
      AppMethodBeat.o(184702);
      return false;
    }
    boolean bool = paramString.Rh(z.bcZ());
    AppMethodBeat.o(184702);
    return bool;
  }
  
  public static com.tencent.mm.storage.as Ri(String paramString)
  {
    AppMethodBeat.i(241393);
    if (jxo)
    {
      paramString = ((n)h.ae(n.class)).bbL().bwj(paramString);
      AppMethodBeat.o(241393);
      return paramString;
    }
    paramString = ((n)h.ae(n.class)).bbL().RG(paramString);
    AppMethodBeat.o(241393);
    return paramString;
  }
  
  public static String a(String paramString1, String paramString2, boolean paramBoolean, String... paramVarArgs)
  {
    AppMethodBeat.i(241390);
    paramString1 = a(com.tencent.mm.contact.b.jxn.axg(), paramString1, paramString2, paramBoolean, paramVarArgs);
    AppMethodBeat.o(241390);
    return paramString1;
  }
  
  public static String a(String paramString1, String paramString2, String... paramVarArgs)
  {
    AppMethodBeat.i(241388);
    paramString1 = a(paramString1, paramString2, false, paramVarArgs);
    AppMethodBeat.o(241388);
    return paramString1;
  }
  
  private static String a(String paramString, String[] paramArrayOfString1, boolean paramBoolean, String... paramVarArgs)
  {
    AppMethodBeat.i(241380);
    String str1 = " and ( " + paramString + " in ( ";
    if (paramBoolean) {
      str1 = " and ( " + paramString + " not in ( ";
    }
    int k = paramArrayOfString1.length;
    int m = paramArrayOfString1.length;
    int j = 0;
    int i = 0;
    paramString = str1;
    if (j < m)
    {
      String str2 = paramArrayOfString1[j];
      str1 = paramString;
      if (i > 0)
      {
        str1 = paramString;
        if (i < k) {
          str1 = paramString + " , ";
        }
      }
      if ("@all.android".equals(str2)) {
        paramString = str1 + "1 = 1";
      }
      for (;;)
      {
        j += 1;
        i += 1;
        break;
        if ("@micromsg.qq.com".equals(str2))
        {
          paramString = str1 + "0";
        }
        else if ("@chatroom".equals(str2))
        {
          paramString = str1 + "2";
        }
        else if ("@talkroom".equals(str2))
        {
          paramString = str1 + "16";
        }
        else if ("@t.qq.com".equals(str2))
        {
          paramString = str1 + "256";
        }
        else if ("@qqim".equals(str2))
        {
          paramString = str1 + "1024";
        }
        else if ("@app".equals(str2))
        {
          paramString = str1 + "32768";
        }
        else if ("@openim".equals(str2))
        {
          paramString = str1 + "65536";
        }
        else
        {
          paramString = str1;
          if ("@im.chatroom".equals(str2)) {
            paramString = str1 + "4";
          }
        }
      }
    }
    paramString = paramString + " ) " + i(paramVarArgs);
    AppMethodBeat.o(241380);
    return paramString;
  }
  
  private static String a(String paramString, String[] paramArrayOfString1, String... paramVarArgs)
  {
    AppMethodBeat.i(241375);
    Object localObject2 = " and ( 1 != 1 ";
    int j = paramArrayOfString1.length;
    int i = 0;
    if (i < j)
    {
      String str = paramArrayOfString1[i];
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
    paramString = (String)localObject2 + i(paramVarArgs);
    AppMethodBeat.o(241375);
    return paramString;
  }
  
  private static String a(boolean paramBoolean1, String paramString1, String paramString2, boolean paramBoolean2, String... paramVarArgs)
  {
    AppMethodBeat.i(241387);
    if (paramBoolean1)
    {
      paramString1 = a("usernameFlag", new String[] { paramString2 }, paramBoolean2, paramVarArgs);
      AppMethodBeat.o(241387);
      return paramString1;
    }
    String str = " and ( ";
    if ("@all.android".equals(paramString2)) {
      str = " and ( " + " 1 = 1";
    }
    for (;;)
    {
      paramString1 = str + i(paramVarArgs);
      AppMethodBeat.o(241387);
      return paramString1;
      if ("@micromsg.qq.com".equals(paramString2)) {
        str = " and ( " + " " + paramString1 + " not like '%@%'";
      } else if ("@chatroom".equals(paramString2)) {
        str = " and ( " + " " + paramString1 + " like '%@chatroom'";
      } else if ("@talkroom".equals(paramString2)) {
        str = " and ( " + " " + paramString1 + " like '%@talkroom'";
      } else if ("@t.qq.com".equals(paramString2)) {
        str = " and ( " + " " + paramString1 + " like '%@t.qq.com'";
      } else if ("@qqim".equals(paramString2)) {
        str = " and ( " + " " + paramString1 + " like '%@qqim'";
      } else if ("@chatroom_exclusive".equals(paramString2)) {
        str = " and ( " + " " + paramString1 + "not like %@chatroom";
      } else if ("@app".equals(paramString2)) {
        str = " and ( " + " " + paramString1 + " like '%@app'";
      } else if ("@openim".equals(paramString2)) {
        str = " and ( " + " " + paramString1 + " like '%@openim'";
      } else if ("@im.chatroom".equals(paramString2)) {
        str = " and ( " + " " + paramString1 + " like '%@im.chatroom'";
      }
    }
  }
  
  public static void a(as paramas)
  {
    lsy = paramas;
  }
  
  public static boolean a(az paramaz)
  {
    AppMethodBeat.i(42926);
    String str = paramaz.field_username;
    if (QX(str))
    {
      AppMethodBeat.o(42926);
      return false;
    }
    if (QT(str))
    {
      AppMethodBeat.o(42926);
      return false;
    }
    if (QL(str))
    {
      AppMethodBeat.o(42926);
      return false;
    }
    if (QM(str))
    {
      AppMethodBeat.o(42926);
      return false;
    }
    if (paramaz.field_conversationTime == -1L)
    {
      AppMethodBeat.o(42926);
      return false;
    }
    if (Qm(str))
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
    int[] arrayOfInt = ((n)h.ae(n.class)).bbL().b(paramString1, paramString2, paramArrayOfString, paramList);
    if (arrayOfInt.length <= 0)
    {
      AppMethodBeat.o(42878);
      return null;
    }
    paramString1 = ((n)h.ae(n.class)).bbL().c(paramString1, paramString2, paramArrayOfString, paramList);
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
    AppMethodBeat.i(241324);
    long l = System.currentTimeMillis();
    int[] arrayOfInt = ((n)h.ae(n.class)).bbL().b(paramArrayOfString, paramString1, paramString2, paramString3, paramList);
    Log.d("MicroMsg.ContactStorageLogic", "kevin service(IMessengerStorage.class).getContactStg().getShowHeadDistinct(" + (System.currentTimeMillis() - l));
    if (arrayOfInt.length <= 0)
    {
      AppMethodBeat.o(241324);
      return null;
    }
    l = System.currentTimeMillis();
    paramArrayOfString = ((n)h.ae(n.class)).bbL().c(paramArrayOfString, paramString1, paramString2, paramString3, paramList);
    Log.d("MicroMsg.ContactStorageLogic", "kevin service(IMessengerStorage.class).getContactStg().getSectionNumByShowHead" + (System.currentTimeMillis() - l));
    if (paramArrayOfString == null)
    {
      AppMethodBeat.o(241324);
      return null;
    }
    if (arrayOfInt.length != paramArrayOfString.length)
    {
      Log.e("MicroMsg.ContactStorageLogic", "[%s:%s] filterType:%s filterSearchStr:%s blocklist:%s searchString:%s", new Object[] { Integer.valueOf(arrayOfInt.length), Integer.valueOf(paramArrayOfString.length), paramString1, paramString2, paramList, paramString3 });
      AppMethodBeat.o(241324);
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
    AppMethodBeat.o(241324);
    return paramString1;
  }
  
  public static String[] a(String paramString1, String paramString2, String[] paramArrayOfString, List<String> paramList)
  {
    AppMethodBeat.i(42879);
    long l = System.currentTimeMillis();
    paramString1 = ((n)h.ae(n.class)).bbL().b(paramString1, paramString2, paramArrayOfString, paramList);
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
    AppMethodBeat.i(241328);
    long l = System.currentTimeMillis();
    paramArrayOfString = ((n)h.ae(n.class)).bbL().b(paramArrayOfString, paramString1, paramString2, paramString3, paramList);
    Log.d("MicroMsg.ContactStorageLogic", "kevin service(IMessengerStorage.class).getContactStg().getShowSectionByShowHead" + (System.currentTimeMillis() - l));
    if (paramArrayOfString.length <= 0)
    {
      AppMethodBeat.o(241328);
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
    AppMethodBeat.o(241328);
    return paramString1;
  }
  
  public static int[] an(List<String> paramList)
  {
    AppMethodBeat.i(42877);
    long l = System.currentTimeMillis();
    int[] arrayOfInt1 = ((n)h.ae(n.class)).bbL().jN(paramList);
    Log.d("MicroMsg.ContactStorageLogic", "kevin service(IMessengerStorage.class).getContactStg().getShowHeadDistinct(" + (System.currentTimeMillis() - l));
    if (arrayOfInt1.length <= 0)
    {
      AppMethodBeat.o(42877);
      return null;
    }
    l = System.currentTimeMillis();
    paramList = ((n)h.ae(n.class)).bbL().jO(paramList);
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
  
  public static String[] ao(List<String> paramList)
  {
    AppMethodBeat.i(42881);
    long l = System.currentTimeMillis();
    paramList = ((n)h.ae(n.class)).bbL().jN(paramList);
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
  
  private static String b(String paramString, String[] paramArrayOfString1, String... paramVarArgs)
  {
    AppMethodBeat.i(241377);
    paramString = a(paramString, paramArrayOfString1, false, paramVarArgs);
    AppMethodBeat.o(241377);
    return paramString;
  }
  
  public static String b(boolean paramBoolean, String paramString1, String paramString2)
  {
    AppMethodBeat.i(241384);
    if (paramBoolean)
    {
      StringBuilder localStringBuilder1 = new StringBuilder();
      StringBuilder localStringBuilder2 = new StringBuilder();
      localStringBuilder2.append(paramString1).append(" inner join ").append("rcontact").append(" WHERE ").append(paramString1 + "." + paramString2 + " = ").append("rcontact" + "." + "username");
      paramString1 = localStringBuilder2.toString() + " AND ";
      AppMethodBeat.o(241384);
      return paramString1;
    }
    paramString1 = paramString1 + " WHERE ";
    AppMethodBeat.o(241384);
    return paramString1;
  }
  
  public static boolean b(az paramaz)
  {
    AppMethodBeat.i(42927);
    paramaz = paramaz.field_username;
    if (QL(paramaz))
    {
      AppMethodBeat.o(42927);
      return false;
    }
    if (QU(paramaz))
    {
      AppMethodBeat.o(42927);
      return false;
    }
    if (QV(paramaz))
    {
      AppMethodBeat.o(42927);
      return false;
    }
    AppMethodBeat.o(42927);
    return true;
  }
  
  public static List<String> bdW()
  {
    AppMethodBeat.i(42846);
    List localList = ((n)h.ae(n.class)).bbL().hyl();
    AppMethodBeat.o(42846);
    return localList;
  }
  
  public static List<com.tencent.mm.storage.as> bdX()
  {
    AppMethodBeat.i(42847);
    ArrayList localArrayList = new ArrayList();
    Cursor localCursor = ((n)h.ae(n.class)).bbL().hym();
    if (localCursor.moveToFirst()) {
      do
      {
        com.tencent.mm.storage.as localas = new com.tencent.mm.storage.as();
        localas.convertFrom(localCursor);
        localArrayList.add(localas);
      } while (localCursor.moveToNext());
    }
    localCursor.close();
    AppMethodBeat.o(42847);
    return localArrayList;
  }
  
  public static boolean bdY()
  {
    return false;
  }
  
  public static boolean bdZ()
  {
    AppMethodBeat.i(42922);
    if (!z.bdO())
    {
      AppMethodBeat.o(42922);
      return false;
    }
    cj localcj = ((n)h.ae(n.class)).bbU().aPi("@t.qq.com");
    if ((localcj == null) || (Util.isNullOrNil(localcj.name)))
    {
      AppMethodBeat.o(42922);
      return false;
    }
    AppMethodBeat.o(42922);
    return true;
  }
  
  public static boolean bea()
  {
    AppMethodBeat.i(42923);
    if (!z.bdO())
    {
      AppMethodBeat.o(42923);
      return false;
    }
    cj localcj = ((n)h.ae(n.class)).bbU().aPi("@t.qq.com");
    if ((localcj == null) || (Util.nullAsNil(localcj.name).length() == 0))
    {
      AppMethodBeat.o(42923);
      return false;
    }
    AppMethodBeat.o(42923);
    return true;
  }
  
  public static List<com.tencent.mm.storage.as> beb()
  {
    AppMethodBeat.i(241371);
    LinkedList localLinkedList = new LinkedList();
    Cursor localCursor = ((n)h.ae(n.class)).bbL().hyD();
    if (localCursor.getCount() == 0)
    {
      localCursor.close();
      AppMethodBeat.o(241371);
      return localLinkedList;
    }
    localCursor.moveToFirst();
    do
    {
      com.tencent.mm.storage.as localas = new com.tencent.mm.storage.as();
      localas.convertFrom(localCursor);
      localLinkedList.add(localas);
    } while (localCursor.moveToNext());
    localCursor.close();
    Log.d("MicroMsg.ContactStorageLogic", "getTotalList size:  " + localLinkedList.size());
    AppMethodBeat.o(241371);
    return localLinkedList;
  }
  
  public static List<com.tencent.mm.storage.as> bec()
  {
    AppMethodBeat.i(42924);
    LinkedList localLinkedList = new LinkedList();
    Cursor localCursor = ((n)h.ae(n.class)).bbL().hyp();
    if (localCursor.getCount() == 0)
    {
      localCursor.close();
      AppMethodBeat.o(42924);
      return localLinkedList;
    }
    localCursor.moveToFirst();
    do
    {
      com.tencent.mm.storage.as localas = new com.tencent.mm.storage.as();
      localas.convertFrom(localCursor);
      localLinkedList.add(localas);
    } while (localCursor.moveToNext());
    localCursor.close();
    Log.d("MicroMsg.ContactStorageLogic", "getFavourList size:  " + localLinkedList.size());
    AppMethodBeat.o(42924);
    return localLinkedList;
  }
  
  public static List<String> bed()
  {
    AppMethodBeat.i(42925);
    LinkedList localLinkedList = new LinkedList();
    Cursor localCursor = ((n)h.ae(n.class)).bbL().hyn();
    if (localCursor.getCount() == 0)
    {
      localCursor.close();
      AppMethodBeat.o(42925);
      return localLinkedList;
    }
    localCursor.moveToFirst();
    do
    {
      com.tencent.mm.storage.as localas = new com.tencent.mm.storage.as();
      localas.convertFrom(localCursor);
      localLinkedList.add(localas.field_username);
    } while (localCursor.moveToNext());
    localCursor.close();
    Log.d("MicroMsg.ContactStorageLogic", "getSnsBlackContactList size:  " + localLinkedList.size());
    AppMethodBeat.o(42925);
    return localLinkedList;
  }
  
  public static int bee()
  {
    AppMethodBeat.i(42928);
    int i = ((n)h.ae(n.class)).bbL().c(lsO, new String[] { z.bcZ(), "weixin", "helper_entry", "filehelper" });
    AppMethodBeat.o(42928);
    return i;
  }
  
  public static int bef()
  {
    AppMethodBeat.i(241374);
    int i = ((n)h.ae(n.class)).bbL().hyz();
    AppMethodBeat.o(241374);
    return i;
  }
  
  public static String c(String paramString, String[] paramArrayOfString1, String... paramVarArgs)
  {
    AppMethodBeat.i(241386);
    if (com.tencent.mm.contact.b.jxn.axg())
    {
      paramString = a("usernameFlag", paramArrayOfString1, false, paramVarArgs);
      AppMethodBeat.o(241386);
      return paramString;
    }
    paramString = a(paramString, paramArrayOfString1, paramVarArgs);
    AppMethodBeat.o(241386);
    return paramString;
  }
  
  public static void c(com.tencent.mm.storage.as paramas, String paramString)
  {
    AppMethodBeat.i(42869);
    com.tencent.mm.storage.as localas = ((n)h.ae(n.class)).bbL().RG(paramas.field_username);
    if ((localas != null) && (paramString != null)) {}
    for (boolean bool = true;; bool = false)
    {
      Assert.assertTrue(bool);
      localas.Ir(paramString);
      if ((com.tencent.mm.storage.as.bvK(paramas.field_username)) && (lsy != null)) {
        lsy.ar(paramas.field_username, paramString);
      }
      M(localas);
      AppMethodBeat.o(42869);
      return;
    }
  }
  
  private static String i(String... paramVarArgs)
  {
    AppMethodBeat.i(241382);
    String str1 = "";
    String str2 = str1;
    if (!Util.isNullOrNil(paramVarArgs))
    {
      int i = 0;
      for (;;)
      {
        str2 = str1;
        if (i >= paramVarArgs.length) {
          break;
        }
        str1 = str1 + paramVarArgs[i];
        i += 1;
      }
    }
    paramVarArgs = str2 + " ) ";
    AppMethodBeat.o(241382);
    return paramVarArgs;
  }
  
  public static String m(boolean paramBoolean, int paramInt)
  {
    switch (paramInt)
    {
    default: 
      return "";
    case 4: 
      if (paramBoolean) {
        return lsK;
      }
      return lsJ;
    case 5: 
      if (paramBoolean) {
        return lsM;
      }
      return lsL;
    case 1: 
      if (paramBoolean) {
        return lsB;
      }
      return lsA;
    case 2: 
      if (paramBoolean) {
        return lsF;
      }
      return lsE;
    }
    if (paramBoolean) {
      return lsI;
    }
    return lsH;
  }
  
  public static boolean p(com.tencent.mm.storage.as paramas)
  {
    AppMethodBeat.i(42840);
    if (paramas == null)
    {
      AppMethodBeat.o(42840);
      return false;
    }
    if (!PO(paramas.field_username))
    {
      AppMethodBeat.o(42840);
      return false;
    }
    if (!d.rk(paramas.field_type))
    {
      AppMethodBeat.o(42840);
      return false;
    }
    AppMethodBeat.o(42840);
    return true;
  }
  
  public static void q(com.tencent.mm.storage.as paramas)
  {
    AppMethodBeat.i(42852);
    boolean bool;
    com.tencent.mm.storage.as localas2;
    if (paramas != null)
    {
      bool = true;
      Assert.assertTrue(bool);
      localas2 = ((n)h.ae(n.class)).bbL().RG(paramas.field_username);
      localas1 = paramas;
      if (localas2 != null) {
        if (!Util.isNullOrNil(localas2.field_username)) {
          break label77;
        }
      }
    }
    label77:
    for (com.tencent.mm.storage.as localas1 = paramas;; localas1 = localas2)
    {
      localas1.axu();
      M(localas1);
      AppMethodBeat.o(42852);
      return;
      bool = false;
      break;
    }
  }
  
  public static void r(com.tencent.mm.storage.as paramas)
  {
    AppMethodBeat.i(42854);
    boolean bool;
    com.tencent.mm.storage.as localas2;
    if (paramas != null)
    {
      bool = true;
      Assert.assertTrue(bool);
      localas2 = ((n)h.ae(n.class)).bbL().RG(paramas.field_username);
      localas1 = paramas;
      if (localas2 != null) {
        if (!Util.isNullOrNil(localas2.field_username)) {
          break label77;
        }
      }
    }
    label77:
    for (com.tencent.mm.storage.as localas1 = paramas;; localas1 = localas2)
    {
      localas1.axs();
      M(localas1);
      AppMethodBeat.o(42854);
      return;
      bool = false;
      break;
    }
  }
  
  public static void s(com.tencent.mm.storage.as paramas)
  {
    AppMethodBeat.i(42855);
    boolean bool;
    com.tencent.mm.storage.as localas2;
    if (paramas != null)
    {
      bool = true;
      Assert.assertTrue(bool);
      localas2 = ((n)h.ae(n.class)).bbL().RG(paramas.field_username);
      localas1 = paramas;
      if (localas2 != null) {
        if (!Util.isNullOrNil(localas2.field_username)) {
          break label77;
        }
      }
    }
    label77:
    for (com.tencent.mm.storage.as localas1 = paramas;; localas1 = localas2)
    {
      localas1.axt();
      M(localas1);
      AppMethodBeat.o(42855);
      return;
      bool = false;
      break;
    }
  }
  
  public static void t(com.tencent.mm.storage.as paramas)
  {
    AppMethodBeat.i(241307);
    boolean bool;
    com.tencent.mm.storage.as localas2;
    if (paramas != null)
    {
      bool = true;
      Assert.assertTrue(bool);
      localas2 = ((n)h.ae(n.class)).bbL().RG(paramas.field_username);
      localas1 = paramas;
      if (localas2 != null) {
        if (!Util.isNullOrNil(localas2.field_username)) {
          break label77;
        }
      }
    }
    label77:
    for (com.tencent.mm.storage.as localas1 = paramas;; localas1 = localas2)
    {
      localas1.axo();
      N(localas1);
      AppMethodBeat.o(241307);
      return;
      bool = false;
      break;
    }
  }
  
  public static void u(com.tencent.mm.storage.as paramas)
  {
    AppMethodBeat.i(241308);
    boolean bool;
    com.tencent.mm.storage.as localas2;
    if (paramas != null)
    {
      bool = true;
      Assert.assertTrue(bool);
      localas2 = ((n)h.ae(n.class)).bbL().RG(paramas.field_username);
      localas1 = paramas;
      if (localas2 != null) {
        if (!Util.isNullOrNil(localas2.field_username)) {
          break label77;
        }
      }
    }
    label77:
    for (com.tencent.mm.storage.as localas1 = paramas;; localas1 = localas2)
    {
      localas1.axp();
      N(localas1);
      AppMethodBeat.o(241308);
      return;
      bool = false;
      break;
    }
  }
  
  public static boolean uK(int paramInt)
  {
    AppMethodBeat.i(241297);
    Log.i("MicroMsg.ContactStorageLogic", "union luckymoney logic：isOpenImIncludeAssociateRoomOrOpenIMUser sceneid :%s ", new Object[] { Integer.valueOf(paramInt) });
    if (paramInt == 1005)
    {
      Log.i("MicroMsg.ContactStorageLogic", "union luckymoney logic：use union luckymoney ");
      AppMethodBeat.o(241297);
      return true;
    }
    Log.i("MicroMsg.ContactStorageLogic", "union luckymoney logic：use normal luckymoney ");
    AppMethodBeat.o(241297);
    return false;
  }
  
  public static boolean uL(int paramInt)
  {
    AppMethodBeat.i(42851);
    boolean bool = com.tencent.mm.storage.as.asD(paramInt);
    AppMethodBeat.o(42851);
    return bool;
  }
  
  public static void v(com.tencent.mm.storage.as paramas)
  {
    AppMethodBeat.i(241309);
    boolean bool;
    com.tencent.mm.storage.as localas2;
    if (paramas != null)
    {
      bool = true;
      Assert.assertTrue(bool);
      localas2 = ((n)h.ae(n.class)).bbL().RG(paramas.field_username);
      localas1 = paramas;
      if (localas2 != null) {
        if (!Util.isNullOrNil(localas2.field_username)) {
          break label77;
        }
      }
    }
    label77:
    for (com.tencent.mm.storage.as localas1 = paramas;; localas1 = localas2)
    {
      localas1.axq();
      N(localas1);
      AppMethodBeat.o(241309);
      return;
      bool = false;
      break;
    }
  }
  
  public static void w(com.tencent.mm.storage.as paramas)
  {
    AppMethodBeat.i(241310);
    boolean bool;
    com.tencent.mm.storage.as localas2;
    if (paramas != null)
    {
      bool = true;
      Assert.assertTrue(bool);
      localas2 = ((n)h.ae(n.class)).bbL().RG(paramas.field_username);
      localas1 = paramas;
      if (localas2 != null) {
        if (!Util.isNullOrNil(localas2.field_username)) {
          break label77;
        }
      }
    }
    label77:
    for (com.tencent.mm.storage.as localas1 = paramas;; localas1 = localas2)
    {
      localas1.axr();
      N(localas1);
      AppMethodBeat.o(241310);
      return;
      bool = false;
      break;
    }
  }
  
  public static void x(com.tencent.mm.storage.as paramas)
  {
    AppMethodBeat.i(241311);
    boolean bool;
    com.tencent.mm.storage.as localas2;
    if (paramas != null)
    {
      bool = true;
      Assert.assertTrue(bool);
      localas2 = ((n)h.ae(n.class)).bbL().RG(paramas.field_username);
      localas1 = paramas;
      if (localas2 != null) {
        if (!Util.isNullOrNil(localas2.field_username)) {
          break label77;
        }
      }
    }
    label77:
    for (com.tencent.mm.storage.as localas1 = paramas;; localas1 = localas2)
    {
      localas1.axF();
      N(localas1);
      AppMethodBeat.o(241311);
      return;
      bool = false;
      break;
    }
  }
  
  public static void y(com.tencent.mm.storage.as paramas)
  {
    AppMethodBeat.i(241312);
    boolean bool;
    com.tencent.mm.storage.as localas2;
    if (paramas != null)
    {
      bool = true;
      Assert.assertTrue(bool);
      localas2 = ((n)h.ae(n.class)).bbL().RG(paramas.field_username);
      localas1 = paramas;
      if (localas2 != null) {
        if (!Util.isNullOrNil(localas2.field_username)) {
          break label77;
        }
      }
    }
    label77:
    for (com.tencent.mm.storage.as localas1 = paramas;; localas1 = localas2)
    {
      localas1.axG();
      N(localas1);
      AppMethodBeat.o(241312);
      return;
      bool = false;
      break;
    }
  }
  
  public static void z(com.tencent.mm.storage.as paramas)
  {
    AppMethodBeat.i(42856);
    if (paramas != null) {}
    for (boolean bool = true;; bool = false)
    {
      Assert.assertTrue(bool);
      com.tencent.mm.storage.as localas2 = ((n)h.ae(n.class)).bbL().RG(paramas.field_username);
      com.tencent.mm.storage.as localas1;
      if (localas2 != null)
      {
        localas1 = localas2;
        if (!Util.isNullOrNil(localas2.field_username)) {}
      }
      else
      {
        localas1 = paramas;
      }
      localas1.axm();
      if ((com.tencent.mm.storage.as.bvK(paramas.field_username)) && (lsy != null)) {
        lsy.Lt(paramas.field_username);
      }
      M(localas1);
      AppMethodBeat.o(42856);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.model.ab
 * JD-Core Version:    0.7.0.1
 */