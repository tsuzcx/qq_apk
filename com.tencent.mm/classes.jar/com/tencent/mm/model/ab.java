package com.tencent.mm.model;

import android.database.Cursor;
import android.text.TextUtils;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.autogen.b.az;
import com.tencent.mm.autogen.b.bd;
import com.tencent.mm.contact.d;
import com.tencent.mm.kernel.f;
import com.tencent.mm.kernel.h;
import com.tencent.mm.plugin.messenger.foundation.a.a.j;
import com.tencent.mm.plugin.messenger.foundation.a.a.k.a;
import com.tencent.mm.plugin.messenger.foundation.a.a.l;
import com.tencent.mm.plugin.messenger.foundation.a.n;
import com.tencent.mm.plugin.messenger.foundation.a.w;
import com.tencent.mm.protocal.protobuf.dph;
import com.tencent.mm.protocal.protobuf.dqd;
import com.tencent.mm.protocal.protobuf.dqe;
import com.tencent.mm.protocal.protobuf.etl;
import com.tencent.mm.protocal.protobuf.gol;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.aj;
import com.tencent.mm.storage.aq;
import com.tencent.mm.storage.au;
import com.tencent.mm.storage.bb;
import com.tencent.mm.storage.bx;
import com.tencent.mm.storage.by;
import com.tencent.mm.storage.cm;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import junit.framework.Assert;

public final class ab
{
  public static volatile boolean maI;
  private static at ojW;
  private static HashMap<String, Boolean> ojX;
  public static final String[] ojY;
  public static final String ojZ;
  public static final String oka;
  public static final String okb;
  public static final String okc;
  public static final String okd;
  public static final String oke;
  public static final String okf;
  public static final String okg;
  public static final String okh;
  public static final String oki;
  public static final String okj;
  public static final String okk;
  public static final String okl;
  public static final String okm;
  public static final String okn;
  public static final String[] oko;
  
  static
  {
    AppMethodBeat.i(42931);
    ojW = null;
    ojX = new HashMap();
    ojY = new String[] { "@im.chatroom", "@chatroom", "@openim", "@micromsg.qq.com" };
    ojZ = a("rconversation.username", ojY, new String[0]);
    oka = b("rcontact.usernameFlag", ojY, new String[0]);
    okb = a("rconversation.username", new String[] { "@chatroom", "@micromsg.qq.com" }, new String[0]);
    okc = a("rconversation.username", new String[] { "@t.qq.com" }, new String[0]);
    okd = a("rconversation.username", new String[] { "@qqim" }, new String[0]);
    oke = b("rcontact.usernameFlag", new String[] { "@qqim" }, new String[0]);
    okf = a("rconversation.username", new String[] { "@chatroom_exclusive" }, new String[0]);
    okg = a("rconversation.username", new String[] { "@micromsg.qq.com" }, new String[0]);
    okh = b("rcontact.usernameFlag", new String[] { "@micromsg.qq.com" }, new String[0]);
    oki = a("rconversation.username", new String[] { "@app" }, new String[0]);
    okj = b("rcontact.usernameFlag", new String[] { "@app" }, new String[0]);
    okk = a("rconversation.username", new String[] { "@chatroom" }, new String[0]);
    okl = b("rcontact.usernameFlag", new String[] { "@chatroom" }, new String[0]);
    okm = a("rconversation.username", new String[] { "@im.chatroom" }, new String[0]);
    okn = a("rconversation.username", new String[] { "@kefu.openim" }, new String[0]);
    oko = new String[] { "qqmail", "fmessage", "tmessage", "qmessage", "qqsync", "floatbottle", "lbsapp", "shakeapp", "medianote", "qqfriend", "newsapp", "blogapp", "facebookapp", "topstoryapp", "masssendapp", "feedsapp", "voipapp", "cardpackage", "voicevoipapp", "voiceinputapp", "officialaccounts", "linkedinplugin", "notifymessage", "appbrandcustomerservicemsg", "appbrand_notify_message", "opencustomerservicemsg", "conversationboxservice" };
    AppMethodBeat.o(42931);
  }
  
  public static void A(au paramau)
  {
    AppMethodBeat.i(42856);
    if (paramau != null) {}
    for (boolean bool = true;; bool = false)
    {
      Assert.assertTrue(bool);
      au localau2 = ((n)h.ax(n.class)).bzA().JE(paramau.field_username);
      au localau1;
      if (localau2 != null)
      {
        localau1 = localau2;
        if (!Util.isNullOrNil(localau2.field_username)) {}
      }
      else
      {
        localau1 = paramau;
      }
      localau1.aRM();
      if ((au.bwO(paramau.field_username)) && (ojW != null)) {
        ojW.Ea(paramau.field_username);
      }
      N(localau1);
      AppMethodBeat.o(42856);
      return;
    }
  }
  
  public static void B(au paramau)
  {
    AppMethodBeat.i(42857);
    if (paramau != null) {}
    for (boolean bool = true;; bool = false)
    {
      Assert.assertTrue(bool);
      au localau2 = ((n)h.ax(n.class)).bzA().JE(paramau.field_username);
      au localau1;
      if (localau2 != null)
      {
        localau1 = localau2;
        if (!Util.isNullOrNil(localau2.field_username)) {}
      }
      else
      {
        localau1 = paramau;
      }
      localau1.aRN();
      if ((au.bwO(paramau.field_username)) && (ojW != null)) {
        ojW.Eb(paramau.field_username);
      }
      N(localau1);
      paramau = ((n)h.ax(n.class)).bzG().bxM(paramau.field_username);
      if ((paramau != null) && ("@blacklist".equals(paramau.field_parentRef))) {
        ((n)h.ax(n.class)).bzG().e(new String[] { paramau.field_username }, "");
      }
      AppMethodBeat.o(42857);
      return;
    }
  }
  
  public static void C(au paramau)
  {
    AppMethodBeat.i(42858);
    if (paramau != null) {}
    for (boolean bool = true;; bool = false)
    {
      Assert.assertTrue(bool);
      au localau2 = ((n)h.ax(n.class)).bzA().JE(paramau.field_username);
      au localau1;
      if (localau2 != null)
      {
        localau1 = localau2;
        if (!Util.isNullOrNil(localau2.field_username)) {}
      }
      else
      {
        localau1 = paramau;
      }
      localau1.aSf();
      localau1.pp(paramau.aRH());
      L(localau1);
      AppMethodBeat.o(42858);
      return;
    }
  }
  
  public static void D(au paramau)
  {
    AppMethodBeat.i(42859);
    if (paramau != null) {}
    for (boolean bool = true;; bool = false)
    {
      Assert.assertTrue(bool);
      au localau2 = ((n)h.ax(n.class)).bzA().JE(paramau.field_username);
      au localau1;
      if (localau2 != null)
      {
        localau1 = localau2;
        if (!Util.isNullOrNil(localau2.field_username)) {}
      }
      else
      {
        localau1 = paramau;
      }
      localau1.aSg();
      localau1.pp(paramau.aRH());
      L(localau1);
      AppMethodBeat.o(42859);
      return;
    }
  }
  
  public static void E(au paramau)
  {
    AppMethodBeat.i(42860);
    if (paramau != null) {}
    for (boolean bool = true;; bool = false)
    {
      Assert.assertTrue(bool);
      au localau2 = ((n)h.ax(n.class)).bzA().JE(paramau.field_username);
      au localau1;
      if (localau2 != null)
      {
        localau1 = localau2;
        if (!Util.isNullOrNil(localau2.field_username)) {}
      }
      else
      {
        localau1 = paramau;
      }
      localau1.aSb();
      localau1.pp(paramau.aRH());
      if ((au.bwO(paramau.field_username)) && (ojW != null)) {
        ojW.Ec(paramau.field_username);
      }
      N(localau1);
      AppMethodBeat.o(42860);
      return;
    }
  }
  
  public static void F(au paramau)
  {
    AppMethodBeat.i(42861);
    if (paramau != null) {}
    for (boolean bool = true;; bool = false)
    {
      Assert.assertTrue(bool);
      au localau2 = ((n)h.ax(n.class)).bzA().JE(paramau.field_username);
      au localau1;
      if (localau2 != null)
      {
        localau1 = localau2;
        if (!Util.isNullOrNil(localau2.field_username)) {}
      }
      else
      {
        localau1 = paramau;
      }
      localau1.aSc();
      localau1.pp(paramau.aRH());
      if ((au.bwO(paramau.field_username)) && (ojW != null)) {
        ojW.Ed(paramau.field_username);
      }
      N(localau1);
      AppMethodBeat.o(42861);
      return;
    }
  }
  
  public static void G(au paramau)
  {
    AppMethodBeat.i(42865);
    if (paramau != null) {}
    for (boolean bool = true;; bool = false)
    {
      Assert.assertTrue(bool);
      au localau2 = ((n)h.ax(n.class)).bzA().JE(paramau.field_username);
      au localau1;
      if (localau2 != null)
      {
        localau1 = localau2;
        if (!Util.isNullOrNil(localau2.field_username)) {}
      }
      else
      {
        localau1 = paramau;
      }
      localau1.aSd();
      if (((au.bwO(paramau.field_username)) || (au.bwQ(paramau.field_username))) && (ojW != null)) {
        ojW.Ee(paramau.field_username);
      }
      N(localau1);
      AppMethodBeat.o(42865);
      return;
    }
  }
  
  public static void H(au paramau)
  {
    AppMethodBeat.i(42866);
    if (paramau != null) {}
    for (boolean bool = true;; bool = false)
    {
      Assert.assertTrue(bool);
      au localau2 = ((n)h.ax(n.class)).bzA().JE(paramau.field_username);
      au localau1;
      if (localau2 != null)
      {
        localau1 = localau2;
        if (!Util.isNullOrNil(localau2.field_username)) {}
      }
      else
      {
        localau1 = paramau;
      }
      localau1.aSe();
      if (((au.bwO(paramau.field_username)) || (au.bwQ(paramau.field_username))) && (ojW != null)) {
        ojW.Ef(paramau.field_username);
      }
      N(localau1);
      AppMethodBeat.o(42866);
      return;
    }
  }
  
  public static void I(au paramau)
  {
    boolean bool2 = true;
    AppMethodBeat.i(42867);
    if (paramau != null)
    {
      bool1 = true;
      Assert.assertTrue("MicroMsg.ContactStorageLogic: user is null", bool1);
      if ((int)paramau.maN == 0) {
        break label97;
      }
      bool1 = true;
      label31:
      Assert.assertTrue("MicroMsg.ContactStorageLogic: contactId == 0", bool1);
      if (paramau.field_username.length() <= 0) {
        break label102;
      }
    }
    label97:
    label102:
    for (boolean bool1 = bool2;; bool1 = false)
    {
      Assert.assertTrue("MicroMsg.ContactStorageLogic: username length <= 0", bool1);
      paramau.aRK();
      ((n)h.ax(n.class)).bzA().d(paramau.field_username, paramau);
      AppMethodBeat.o(42867);
      return;
      bool1 = false;
      break;
      bool1 = false;
      break label31;
    }
  }
  
  public static boolean IG(String paramString)
  {
    AppMethodBeat.i(178864);
    if ((paramString == null) || (paramString.length() <= 0))
    {
      AppMethodBeat.o(178864);
      return false;
    }
    if ((paramString.endsWith("@im.chatroom")) || (II(paramString)))
    {
      AppMethodBeat.o(178864);
      return true;
    }
    AppMethodBeat.o(178864);
    return false;
  }
  
  public static boolean IH(String paramString)
  {
    AppMethodBeat.i(242072);
    if ((paramString == null) || (paramString.length() <= 0))
    {
      Log.i("MicroMsg.ContactStorageLogic", "union luckymoney logic：isOpenImIncludeAssociateRoomOrOpenIMUser :(username == null) || (username.length() <= 0) ");
      AppMethodBeat.o(242072);
      return false;
    }
    if ((IG(paramString)) || (au.bwO(paramString))) {}
    for (boolean bool = true;; bool = false)
    {
      Log.i("MicroMsg.ContactStorageLogic", "union luckymoney logic：isOpenImIncludeAssociateRoomOrOpenIMUser :%s ", new Object[] { Boolean.valueOf(bool) });
      AppMethodBeat.o(242072);
      return bool;
    }
  }
  
  public static boolean II(String paramString)
  {
    AppMethodBeat.i(178865);
    Boolean localBoolean;
    Object localObject;
    if (au.bwG(paramString))
    {
      localBoolean = null;
      if (ojX.containsKey(paramString)) {
        localBoolean = (Boolean)ojX.get(paramString);
      }
      localObject = localBoolean;
      if (localBoolean == null)
      {
        localBoolean = Boolean.FALSE;
        localObject = ((com.tencent.mm.plugin.chatroom.a.b)h.ax(com.tencent.mm.plugin.chatroom.a.b.class)).bzK().Ju(paramString);
        if ((localObject == null) || ((((aj)localObject).field_chatroomStatus & 0x20000) != 131072)) {
          break label121;
        }
        localBoolean = Boolean.TRUE;
      }
    }
    label121:
    for (;;)
    {
      ojX.put(paramString, localBoolean);
      localObject = localBoolean;
      boolean bool = ((Boolean)localObject).booleanValue();
      AppMethodBeat.o(178865);
      return bool;
      AppMethodBeat.o(178865);
      return false;
    }
  }
  
  public static void IJ(String paramString)
  {
    AppMethodBeat.i(242085);
    ojX.remove(paramString);
    AppMethodBeat.o(242085);
  }
  
  public static boolean IK(String paramString)
  {
    AppMethodBeat.i(178866);
    if (au.bwG(paramString))
    {
      paramString = ((com.tencent.mm.plugin.chatroom.a.b)h.ax(com.tencent.mm.plugin.chatroom.a.b.class)).bzK().Ju(paramString);
      if ((paramString != null) && ((paramString.field_chatroomStatus & 0x20000) != 131072) && ((paramString.field_chatroomStatus & 0x10000) == 65536))
      {
        AppMethodBeat.o(178866);
        return true;
      }
    }
    AppMethodBeat.o(178866);
    return false;
  }
  
  public static boolean IL(String paramString)
  {
    AppMethodBeat.i(178867);
    if ((((w)h.ax(w.class)).aLX()) && (au.bwG(paramString)))
    {
      paramString = ((com.tencent.mm.plugin.chatroom.a.b)h.ax(com.tencent.mm.plugin.chatroom.a.b.class)).bzK().Ju(paramString);
      if ((paramString != null) && (paramString.aMF()))
      {
        AppMethodBeat.o(178867);
        return true;
      }
    }
    AppMethodBeat.o(178867);
    return false;
  }
  
  public static boolean IM(String paramString)
  {
    AppMethodBeat.i(242093);
    boolean bool = "gh_579db1f2cf89".equals(paramString);
    AppMethodBeat.o(242093);
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
    AppMethodBeat.i(242100);
    boolean bool = "msginfo@fakeuser".equals(paramString);
    AppMethodBeat.o(242100);
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
    if (!au.bwE(paramString))
    {
      AppMethodBeat.o(42844);
      return false;
    }
    paramString = ((n)h.ax(n.class)).bzA().JE(paramString);
    if ((paramString == null) || (!d.rs(paramString.field_type)))
    {
      AppMethodBeat.o(42844);
      return false;
    }
    AppMethodBeat.o(42844);
    return true;
  }
  
  public static boolean IR(String paramString)
  {
    AppMethodBeat.i(42849);
    if ((paramString == null) || (paramString.length() <= 0))
    {
      AppMethodBeat.o(42849);
      return true;
    }
    boolean bool = d.rs(((n)h.ax(n.class)).bzA().JE(paramString).field_type);
    AppMethodBeat.o(42849);
    return bool;
  }
  
  public static boolean IS(String paramString)
  {
    AppMethodBeat.i(42850);
    if (Util.isNullOrNil(paramString))
    {
      AppMethodBeat.o(42850);
      return false;
    }
    paramString = ((n)h.ax(n.class)).bzA().JE(paramString);
    if (paramString == null)
    {
      AppMethodBeat.o(42850);
      return false;
    }
    boolean bool = au.ayS(paramString.field_verifyFlag);
    AppMethodBeat.o(42850);
    return bool;
  }
  
  public static void IT(String paramString)
  {
    AppMethodBeat.i(42863);
    bb localbb2 = ((n)h.ax(n.class)).bzG().bxM(paramString);
    int i = 0;
    bb localbb1 = localbb2;
    if (localbb2 == null)
    {
      localbb1 = new bb();
      localbb1.jaJ();
      i = 1;
      localbb1.setUsername(paramString);
    }
    localbb1.gR(System.currentTimeMillis());
    if (i != 0)
    {
      ((n)h.ax(n.class)).bzG().h(localbb1);
      AppMethodBeat.o(42863);
      return;
    }
    ((n)h.ax(n.class)).bzG().c(localbb1, paramString);
    AppMethodBeat.o(42863);
  }
  
  public static void IU(String paramString)
  {
    AppMethodBeat.i(42875);
    if (Util.isNullOrNil(paramString))
    {
      AppMethodBeat.o(42875);
      return;
    }
    au localau = ((n)h.ax(n.class)).bzA().JE(paramString);
    if (localau == null)
    {
      AppMethodBeat.o(42875);
      return;
    }
    localau.setSource(0);
    localau.aRI();
    ((n)h.ax(n.class)).bzA().d(paramString, localau);
    AppMethodBeat.o(42875);
  }
  
  public static boolean IV(String paramString)
  {
    AppMethodBeat.i(42914);
    String[] arrayOfString = oko;
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
  
  public static boolean IW(String paramString)
  {
    AppMethodBeat.i(42915);
    if (IV(paramString))
    {
      AppMethodBeat.o(42915);
      return true;
    }
    if (au.bwN(paramString))
    {
      AppMethodBeat.o(42915);
      return true;
    }
    if (au.bwL(paramString))
    {
      AppMethodBeat.o(42915);
      return true;
    }
    if (au.bwS(paramString))
    {
      AppMethodBeat.o(42915);
      return true;
    }
    AppMethodBeat.o(42915);
    return false;
  }
  
  public static int IX(String paramString)
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
    if (au.bwL(paramString))
    {
      AppMethodBeat.o(42916);
      return 11;
    }
    if (au.bwN(paramString))
    {
      AppMethodBeat.o(42916);
      return 36;
    }
    if (au.bwS(paramString))
    {
      AppMethodBeat.o(42916);
      return 1;
    }
    AppMethodBeat.o(42916);
    return 1;
  }
  
  public static int IY(String paramString)
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
    if (au.bwL(paramString))
    {
      AppMethodBeat.o(42917);
      return 13;
    }
    if (au.bwN(paramString))
    {
      AppMethodBeat.o(42917);
      return 39;
    }
    if (au.bwS(paramString))
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
  
  public static boolean IZ(String paramString)
  {
    AppMethodBeat.i(42918);
    if (((n)h.ax(n.class)).bzA().JE(paramString).kaf != 1)
    {
      AppMethodBeat.o(42918);
      return false;
    }
    AppMethodBeat.o(42918);
    return true;
  }
  
  public static void J(au paramau)
  {
    boolean bool2 = true;
    AppMethodBeat.i(42868);
    if (paramau != null)
    {
      bool1 = true;
      Assert.assertTrue(bool1);
      if ((int)paramau.maN == 0) {
        break label92;
      }
      bool1 = true;
      label28:
      Assert.assertTrue(bool1);
      if (paramau.field_username.length() <= 0) {
        break label97;
      }
    }
    label92:
    label97:
    for (boolean bool1 = bool2;; bool1 = false)
    {
      Assert.assertTrue(bool1);
      paramau.aRK();
      ((n)h.ax(n.class)).bzA().d(paramau.field_username, paramau);
      N(paramau);
      AppMethodBeat.o(42868);
      return;
      bool1 = false;
      break;
      bool1 = false;
      break label28;
    }
  }
  
  public static void J(String paramString, boolean paramBoolean)
  {
    AppMethodBeat.i(42853);
    paramString = ((n)h.ax(n.class)).bzA().JE(paramString);
    if ((paramString == null) || (Util.isNullOrNil(paramString.field_username)))
    {
      AppMethodBeat.o(42853);
      return;
    }
    if (paramBoolean) {
      paramString.aSf();
    }
    for (;;)
    {
      L(paramString);
      AppMethodBeat.o(42853);
      return;
      paramString.aSg();
    }
  }
  
  public static boolean Ja(String paramString)
  {
    AppMethodBeat.i(42919);
    paramString = ((n)h.ax(n.class)).bzA().JE(paramString);
    if ((paramString != null) && (paramString.aGe()))
    {
      AppMethodBeat.o(42919);
      return true;
    }
    AppMethodBeat.o(42919);
    return false;
  }
  
  public static boolean Jb(String paramString)
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
  
  public static String Jc(String paramString)
  {
    AppMethodBeat.i(42921);
    if (Jb(paramString))
    {
      paramString = paramString.replace("http://t.qq.com/", "").replace("t.qq.com/", "");
      AppMethodBeat.o(42921);
      return paramString;
    }
    AppMethodBeat.o(42921);
    return "";
  }
  
  public static boolean Jd(String paramString)
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
  
  public static boolean Je(String paramString)
  {
    AppMethodBeat.i(178868);
    paramString = ((com.tencent.mm.plugin.chatroom.a.b)h.ax(com.tencent.mm.plugin.chatroom.a.b.class)).bzK().Ju(paramString);
    if (paramString == null)
    {
      AppMethodBeat.o(178868);
      return false;
    }
    boolean bool = paramString.aMF();
    AppMethodBeat.o(178868);
    return bool;
  }
  
  public static boolean Jf(String paramString)
  {
    AppMethodBeat.i(184702);
    paramString = ((com.tencent.mm.plugin.chatroom.a.b)h.ax(com.tencent.mm.plugin.chatroom.a.b.class)).bzK().Ju(paramString);
    if (paramString == null)
    {
      AppMethodBeat.o(184702);
      return false;
    }
    boolean bool = paramString.Jf(z.bAM());
    AppMethodBeat.o(184702);
    return bool;
  }
  
  public static au Jg(String paramString)
  {
    AppMethodBeat.i(242167);
    if (maI)
    {
      paramString = ((n)h.ax(n.class)).bzA().bxw(paramString);
      AppMethodBeat.o(242167);
      return paramString;
    }
    paramString = ((n)h.ax(n.class)).bzA().JE(paramString);
    AppMethodBeat.o(242167);
    return paramString;
  }
  
  public static void K(au paramau)
  {
    boolean bool2 = true;
    AppMethodBeat.i(42870);
    if (paramau != null)
    {
      bool1 = true;
      Assert.assertTrue(bool1);
      if ((int)paramau.maN == 0) {
        break label68;
      }
      bool1 = true;
      label28:
      Assert.assertTrue(bool1);
      if (paramau.field_username.length() <= 0) {
        break label73;
      }
    }
    label68:
    label73:
    for (boolean bool1 = bool2;; bool1 = false)
    {
      Assert.assertTrue(bool1);
      paramau.aSS();
      N(paramau);
      AppMethodBeat.o(42870);
      return;
      bool1 = false;
      break;
      bool1 = false;
      break label28;
    }
  }
  
  public static void K(String paramString, boolean paramBoolean)
  {
    AppMethodBeat.i(42862);
    if (!Util.isNullOrNil(paramString)) {}
    au localau;
    for (boolean bool = true;; bool = false)
    {
      Assert.assertTrue(bool);
      localau = ((n)h.ax(n.class)).bzA().JE(paramString);
      if ((localau != null) && (!Util.isNullOrNil(localau.field_username))) {
        break;
      }
      AppMethodBeat.o(42862);
      return;
    }
    localau.setType(localau.field_type | 0x800);
    if (((au.bwO(paramString)) || (au.bwF(paramString))) && (ojW != null)) {
      ojW.DY(paramString);
    }
    N(localau);
    if (paramBoolean) {
      ((n)h.ax(n.class)).bzG().bxT(paramString);
    }
    AppMethodBeat.o(42862);
  }
  
  private static void L(au paramau)
  {
    AppMethodBeat.i(42871);
    boolean bool;
    dqd localdqd;
    if (paramau != null)
    {
      bool = true;
      Assert.assertTrue(bool);
      if ((int)paramau.maN == 0)
      {
        ((n)h.ax(n.class)).bzA().aC(paramau);
        ((n)h.ax(n.class)).bzA().JE(paramau.field_username);
      }
      ((n)h.ax(n.class)).bzA().d(paramau.field_username, paramau);
      localdqd = new dqd();
      localdqd.aaWl = paramau.field_username;
      if (!paramau.aSL()) {
        break label159;
      }
    }
    label159:
    for (localdqd.aaWh = 1;; localdqd.aaWh = 2)
    {
      ((n)h.ax(n.class)).bzz().d(new k.a(52, localdqd));
      AppMethodBeat.o(42871);
      return;
      bool = false;
      break;
    }
  }
  
  public static void L(String paramString, boolean paramBoolean)
  {
    AppMethodBeat.i(42864);
    if (!Util.isNullOrNil(paramString)) {}
    au localau;
    for (boolean bool = true;; bool = false)
    {
      Assert.assertTrue(bool);
      localau = ((n)h.ax(n.class)).bzA().JE(paramString);
      if ((localau != null) && (!Util.isNullOrNil(localau.field_username))) {
        break;
      }
      AppMethodBeat.o(42864);
      return;
    }
    localau.setType(localau.field_type & 0xFFFFF7FF);
    if (((au.bwO(paramString)) || (au.bwF(paramString))) && (ojW != null)) {
      ojW.DZ(paramString);
    }
    N(localau);
    if (paramBoolean) {
      ((n)h.ax(n.class)).bzG().bxU(paramString);
    }
    AppMethodBeat.o(42864);
  }
  
  public static void M(au paramau)
  {
    AppMethodBeat.i(42872);
    boolean bool;
    dqe localdqe;
    if (paramau != null)
    {
      bool = true;
      Assert.assertTrue(bool);
      if ((int)paramau.maN == 0)
      {
        ((n)h.ax(n.class)).bzA().aC(paramau);
        ((n)h.ax(n.class)).bzA().JE(paramau.field_username);
      }
      ((n)h.ax(n.class)).bzA().d(paramau.field_username, paramau);
      localdqe = new dqe();
      localdqe.aaWl = paramau.field_username;
      if (!paramau.aSN()) {
        break label159;
      }
    }
    label159:
    for (localdqe.aaWh = 1;; localdqe.aaWh = 2)
    {
      ((n)h.ax(n.class)).bzz().d(new k.a(72, localdqe));
      AppMethodBeat.o(42872);
      return;
      bool = false;
      break;
    }
  }
  
  public static void N(au paramau)
  {
    AppMethodBeat.i(42873);
    if (paramau != null) {}
    for (boolean bool = true;; bool = false)
    {
      Assert.assertTrue(bool);
      if ((int)paramau.maN == 0)
      {
        ((n)h.ax(n.class)).bzA().aC(paramau);
        ((n)h.ax(n.class)).bzA().JE(paramau.field_username);
      }
      ((n)h.ax(n.class)).bzA().d(paramau.field_username, paramau);
      if ((!au.bwO(paramau.field_username)) && (!au.bwQ(paramau.field_username))) {
        Q(paramau);
      }
      AppMethodBeat.o(42873);
      return;
    }
  }
  
  public static void O(au paramau)
  {
    AppMethodBeat.i(242134);
    if (paramau != null) {}
    for (boolean bool = true;; bool = false)
    {
      Assert.assertTrue(bool);
      if ((int)paramau.maN == 0)
      {
        ((n)h.ax(n.class)).bzA().aC(paramau);
        ((n)h.ax(n.class)).bzA().JE(paramau.field_username);
      }
      ((n)h.ax(n.class)).bzA().d(paramau.field_username, paramau);
      AppMethodBeat.o(242134);
      return;
    }
  }
  
  public static dph P(au paramau)
  {
    AppMethodBeat.i(242135);
    Log.i("MicroMsg.ContactStorageLogic", "oplog modContact user:%s remark:%s type:%d ", new Object[] { paramau.field_username, paramau.field_conRemark, Integer.valueOf(paramau.field_type) });
    dph localdph = new dph();
    localdph.ZqL = new etl().btH(Util.nullAsNil(paramau.field_username));
    localdph.aaIz = new etl().btH(Util.nullAsNil(paramau.field_nickname));
    localdph.ZpX = new etl().btH(Util.nullAsNil(paramau.aJt()));
    localdph.ZpY = new etl().btH(Util.nullAsNil(paramau.aJu()));
    localdph.pSf = paramau.sex;
    localdph.ZoY = 2057277311;
    localdph.ZoZ = paramau.field_type;
    localdph.aaVg = new etl().btH(Util.nullAsNil(paramau.field_conRemark));
    localdph.aaVh = new etl().btH(Util.nullAsNil(paramau.field_conRemarkPYShort));
    localdph.aaVi = new etl().btH(Util.nullAsNil(paramau.field_conRemarkPYFull));
    localdph.Zpe = paramau.kac;
    localdph.aaVL = new etl().btH(Util.nullAsNil(paramau.field_domainList));
    localdph.Zpi = paramau.kaf;
    localdph.pSj = paramau.kag;
    localdph.pSi = Util.nullAsNil(paramau.signature);
    localdph.pSh = Util.nullAsNil(paramau.getCityCode());
    localdph.pSg = Util.nullAsNil(paramau.iZJ());
    localdph.aaMo = Util.nullAsNil(paramau.kai);
    localdph.aaMq = paramau.field_weiboFlag;
    localdph.aaVH = 0;
    localdph.YFI = new gol();
    localdph.pSo = Util.nullAsNil(paramau.getCountryCode());
    AppMethodBeat.o(242135);
    return localdph;
  }
  
  public static void Q(au paramau)
  {
    AppMethodBeat.i(42874);
    ((n)h.ax(n.class)).bzz().d(new k.a(2, P(paramau)));
    AppMethodBeat.o(42874);
  }
  
  public static boolean R(au paramau)
  {
    return (paramau.field_weiboFlag & 0x1) != 0;
  }
  
  public static String a(String paramString1, String paramString2, boolean paramBoolean, String... paramVarArgs)
  {
    AppMethodBeat.i(242163);
    paramString1 = a(com.tencent.mm.contact.b.maH.aRG(), paramString1, paramString2, paramBoolean, paramVarArgs);
    AppMethodBeat.o(242163);
    return paramString1;
  }
  
  public static String a(String paramString1, String paramString2, String... paramVarArgs)
  {
    AppMethodBeat.i(242162);
    paramString1 = a(paramString1, paramString2, false, paramVarArgs);
    AppMethodBeat.o(242162);
    return paramString1;
  }
  
  private static String a(String paramString, String[] paramArrayOfString1, boolean paramBoolean, String... paramVarArgs)
  {
    AppMethodBeat.i(242156);
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
    AppMethodBeat.o(242156);
    return paramString;
  }
  
  private static String a(String paramString, String[] paramArrayOfString1, String... paramVarArgs)
  {
    AppMethodBeat.i(242153);
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
        else if ("@im.chatroom".equals(str))
        {
          localObject1 = (String)localObject2 + " or " + paramString + " like '%@im.chatroom'";
        }
        else
        {
          localObject1 = localObject2;
          if ("@kefu.openim".equalsIgnoreCase(str)) {
            localObject1 = (String)localObject2 + " or " + paramString + " like '%@kefu.openim'";
          }
        }
      }
    }
    paramString = (String)localObject2 + i(paramVarArgs);
    AppMethodBeat.o(242153);
    return paramString;
  }
  
  public static String a(boolean paramBoolean, String paramString1, String paramString2)
  {
    AppMethodBeat.i(242159);
    if (paramBoolean)
    {
      StringBuilder localStringBuilder1 = new StringBuilder();
      StringBuilder localStringBuilder2 = new StringBuilder();
      localStringBuilder2.append(paramString1).append(" inner join ").append("rcontact").append(" WHERE ").append(paramString1 + "." + paramString2 + " = ").append("rcontact" + "." + "username");
      paramString1 = localStringBuilder2.toString() + " AND ";
      AppMethodBeat.o(242159);
      return paramString1;
    }
    paramString1 = paramString1 + " WHERE ";
    AppMethodBeat.o(242159);
    return paramString1;
  }
  
  private static String a(boolean paramBoolean1, String paramString1, String paramString2, boolean paramBoolean2, String... paramVarArgs)
  {
    AppMethodBeat.i(242161);
    if (paramBoolean1)
    {
      paramString1 = a("usernameFlag", new String[] { paramString2 }, paramBoolean2, paramVarArgs);
      AppMethodBeat.o(242161);
      return paramString1;
    }
    String str = " and ( ";
    if ("@all.android".equals(paramString2)) {
      str = " and ( " + " 1 = 1";
    }
    for (;;)
    {
      paramString1 = str + i(paramVarArgs);
      AppMethodBeat.o(242161);
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
  
  public static void a(at paramat)
  {
    ojW = paramat;
  }
  
  public static boolean a(bb parambb)
  {
    AppMethodBeat.i(42926);
    String str = parambb.field_username;
    if (IV(str))
    {
      if (str.equalsIgnoreCase("newsapp")) {}
      for (int i = 1; i == 0; i = 0)
      {
        AppMethodBeat.o(42926);
        return false;
      }
    }
    if (au.bwx(str))
    {
      AppMethodBeat.o(42926);
      return false;
    }
    if (au.bwp(str))
    {
      AppMethodBeat.o(42926);
      return false;
    }
    if (au.bwq(str))
    {
      AppMethodBeat.o(42926);
      return false;
    }
    if (parambb.field_conversationTime == -1L)
    {
      AppMethodBeat.o(42926);
      return false;
    }
    if (IS(str))
    {
      AppMethodBeat.o(42926);
      return true;
    }
    if (au.bwB(str))
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
    int[] arrayOfInt = ((n)h.ax(n.class)).bzA().b(paramString1, paramString2, paramArrayOfString, paramList);
    if ((arrayOfInt == null) || (arrayOfInt.length <= 0))
    {
      AppMethodBeat.o(42878);
      return null;
    }
    paramString1 = ((n)h.ax(n.class)).bzA().c(paramString1, paramString2, paramArrayOfString, paramList);
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
    AppMethodBeat.i(242136);
    long l = System.currentTimeMillis();
    int[] arrayOfInt = ((n)h.ax(n.class)).bzA().b(paramArrayOfString, paramString1, paramString2, paramString3, paramList);
    Log.d("MicroMsg.ContactStorageLogic", "kevin service(IMessengerStorage.class).getContactStg().getShowHeadDistinct(" + (System.currentTimeMillis() - l));
    if ((arrayOfInt == null) || (arrayOfInt.length <= 0))
    {
      AppMethodBeat.o(242136);
      return null;
    }
    l = System.currentTimeMillis();
    paramArrayOfString = ((n)h.ax(n.class)).bzA().c(paramArrayOfString, paramString1, paramString2, paramString3, paramList);
    Log.d("MicroMsg.ContactStorageLogic", "kevin service(IMessengerStorage.class).getContactStg().getSectionNumByShowHead" + (System.currentTimeMillis() - l));
    if (paramArrayOfString == null)
    {
      AppMethodBeat.o(242136);
      return null;
    }
    if (arrayOfInt.length != paramArrayOfString.length)
    {
      Log.e("MicroMsg.ContactStorageLogic", "[%s:%s] filterType:%s filterSearchStr:%s blocklist:%s searchString:%s", new Object[] { Integer.valueOf(arrayOfInt.length), Integer.valueOf(paramArrayOfString.length), paramString1, paramString2, paramList, paramString3 });
      AppMethodBeat.o(242136);
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
    AppMethodBeat.o(242136);
    return paramString1;
  }
  
  public static String[] a(String paramString1, String paramString2, String[] paramArrayOfString, List<String> paramList)
  {
    AppMethodBeat.i(42879);
    long l = System.currentTimeMillis();
    paramString1 = ((n)h.ax(n.class)).bzA().b(paramString1, paramString2, paramArrayOfString, paramList);
    Log.d("MicroMsg.ContactStorageLogic", "kevin service(IMessengerStorage.class).getContactStg().getShowSectionByShowHead" + (System.currentTimeMillis() - l));
    if ((paramString1 == null) || (paramString1.length <= 0))
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
    AppMethodBeat.i(242137);
    long l = System.currentTimeMillis();
    paramArrayOfString = ((n)h.ax(n.class)).bzA().b(paramArrayOfString, paramString1, paramString2, paramString3, paramList);
    Log.d("MicroMsg.ContactStorageLogic", "kevin service(IMessengerStorage.class).getContactStg().getShowSectionByShowHead" + (System.currentTimeMillis() - l));
    if ((paramArrayOfString == null) || (paramArrayOfString.length <= 0))
    {
      AppMethodBeat.o(242137);
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
    AppMethodBeat.o(242137);
    return paramString1;
  }
  
  public static String aW(String paramString1, String paramString2)
  {
    AppMethodBeat.i(242169);
    h.baF();
    au localau = ((n)h.ax(n.class)).bzA().JE(paramString2);
    if (!Util.isNullOrNil(localau.field_conRemark)) {
      paramString1 = localau.field_conRemark;
    }
    for (;;)
    {
      paramString2 = paramString1;
      if (Util.isNullOrNil(paramString1)) {
        paramString2 = localau.field_conRemark;
      }
      paramString1 = paramString2;
      if (Util.isNullOrNil(paramString2)) {
        paramString1 = localau.aSU();
      }
      paramString2 = paramString1;
      if (Util.isNullOrNil(paramString1)) {
        paramString2 = localau.field_username;
      }
      AppMethodBeat.o(242169);
      return paramString2;
      paramString1 = ((com.tencent.mm.plugin.chatroom.a.b)h.ax(com.tencent.mm.plugin.chatroom.a.b.class)).bzK().Ju(paramString1);
      if (paramString1 != null) {
        paramString1 = paramString1.getDisplayName(localau.field_username);
      } else {
        paramString1 = null;
      }
    }
  }
  
  public static String b(aj paramaj, String paramString)
  {
    AppMethodBeat.i(242171);
    h.baF();
    au localau = ((n)h.ax(n.class)).bzA().JE(paramString);
    paramString = null;
    if (!Util.isNullOrNil(localau.field_conRemark)) {
      paramString = localau.field_conRemark;
    }
    for (;;)
    {
      paramaj = paramString;
      if (Util.isNullOrNil(paramString)) {
        paramaj = localau.field_conRemark;
      }
      paramString = paramaj;
      if (Util.isNullOrNil(paramaj)) {
        paramString = localau.aSU();
      }
      paramaj = paramString;
      if (Util.isNullOrNil(paramString)) {
        paramaj = localau.field_username;
      }
      AppMethodBeat.o(242171);
      return paramaj;
      if (paramaj != null) {
        paramString = paramaj.getDisplayName(localau.field_username);
      }
    }
  }
  
  private static String b(String paramString, String[] paramArrayOfString1, String... paramVarArgs)
  {
    AppMethodBeat.i(242154);
    paramString = a(paramString, paramArrayOfString1, false, paramVarArgs);
    AppMethodBeat.o(242154);
    return paramString;
  }
  
  public static boolean b(bb parambb)
  {
    AppMethodBeat.i(42927);
    parambb = parambb.field_username;
    if (au.bwp(parambb))
    {
      AppMethodBeat.o(42927);
      return false;
    }
    if (au.bwy(parambb))
    {
      AppMethodBeat.o(42927);
      return false;
    }
    if (au.bwA(parambb))
    {
      AppMethodBeat.o(42927);
      return false;
    }
    if (au.bwD(parambb))
    {
      AppMethodBeat.o(42927);
      return false;
    }
    if (au.bwz(parambb))
    {
      AppMethodBeat.o(42927);
      return false;
    }
    AppMethodBeat.o(42927);
    return true;
  }
  
  public static boolean b(String[] paramArrayOfString, String paramString)
  {
    AppMethodBeat.i(242152);
    if (paramArrayOfString == null)
    {
      AppMethodBeat.o(242152);
      return true;
    }
    int j = paramArrayOfString.length;
    int i = 0;
    boolean bool2 = false;
    String str;
    if (i < j)
    {
      str = paramArrayOfString[i];
      if ("@all.android".equals(str)) {
        bool2 = true;
      }
    }
    for (;;)
    {
      i += 1;
      break;
      boolean bool1;
      if ("@micromsg.qq.com".equals(str))
      {
        if (!paramString.contains("@")) {}
        for (bool1 = true;; bool1 = false)
        {
          bool2 = bool1 | bool2;
          break;
        }
      }
      if ("@chatroom".equals(str))
      {
        bool2 = paramString.endsWith("@chatroom") | bool2;
      }
      else if ("@talkroom".equals(str))
      {
        bool2 = paramString.endsWith("@talkroom") | bool2;
      }
      else if ("@t.qq.com".equals(str))
      {
        bool2 = paramString.endsWith("@t.qq.com") | bool2;
      }
      else if ("@qqim".equals(str))
      {
        bool2 = paramString.endsWith("@qqim") | bool2;
      }
      else
      {
        if ("@chatroom_exclusive".equals(str))
        {
          if (!paramString.endsWith("@chatroom")) {}
          for (bool1 = true;; bool1 = false)
          {
            bool2 = bool1 | bool2;
            break;
          }
        }
        if ("@app".equals(str))
        {
          bool2 = paramString.endsWith("@app") | bool2;
        }
        else if ("@openim".equals(str))
        {
          bool2 = paramString.endsWith("@openim") | bool2;
        }
        else if ("@im.chatroom".equals(str))
        {
          bool2 = paramString.endsWith("@im.chatroom") | bool2;
        }
        else if ("@kefu.openim".equalsIgnoreCase(str))
        {
          bool2 = paramString.endsWith("@kefu.openim") | bool2;
          continue;
          AppMethodBeat.o(242152);
          return bool2;
        }
      }
    }
  }
  
  public static List<String> bBO()
  {
    AppMethodBeat.i(42846);
    List localList = ((n)h.ax(n.class)).bzA().iZT();
    AppMethodBeat.o(42846);
    return localList;
  }
  
  public static List<au> bBP()
  {
    AppMethodBeat.i(42847);
    ArrayList localArrayList = new ArrayList();
    Cursor localCursor = ((n)h.ax(n.class)).bzA().iZU();
    if (localCursor.moveToFirst()) {
      do
      {
        au localau = new au();
        localau.convertFrom(localCursor);
        localArrayList.add(localau);
      } while (localCursor.moveToNext());
    }
    localCursor.close();
    AppMethodBeat.o(42847);
    return localArrayList;
  }
  
  public static boolean bBQ()
  {
    AppMethodBeat.i(42922);
    if (!z.bBG())
    {
      AppMethodBeat.o(42922);
      return false;
    }
    cm localcm = ((n)h.ax(n.class)).bzJ().aMh("@t.qq.com");
    if ((localcm == null) || (Util.isNullOrNil(localcm.name)))
    {
      AppMethodBeat.o(42922);
      return false;
    }
    AppMethodBeat.o(42922);
    return true;
  }
  
  public static boolean bBR()
  {
    AppMethodBeat.i(42923);
    if (!z.bBG())
    {
      AppMethodBeat.o(42923);
      return false;
    }
    cm localcm = ((n)h.ax(n.class)).bzJ().aMh("@t.qq.com");
    if ((localcm == null) || (Util.nullAsNil(localcm.name).length() == 0))
    {
      AppMethodBeat.o(42923);
      return false;
    }
    AppMethodBeat.o(42923);
    return true;
  }
  
  public static List<au> bBS()
  {
    AppMethodBeat.i(242142);
    LinkedList localLinkedList = new LinkedList();
    Cursor localCursor = ((n)h.ax(n.class)).bzA().jaI();
    if (localCursor.getCount() == 0)
    {
      localCursor.close();
      AppMethodBeat.o(242142);
      return localLinkedList;
    }
    localCursor.moveToFirst();
    do
    {
      au localau = new au();
      localau.convertFrom(localCursor);
      localLinkedList.add(localau);
    } while (localCursor.moveToNext());
    localCursor.close();
    Log.d("MicroMsg.ContactStorageLogic", "getTotalList size:  " + localLinkedList.size());
    AppMethodBeat.o(242142);
    return localLinkedList;
  }
  
  public static List<au> bBT()
  {
    AppMethodBeat.i(42924);
    LinkedList localLinkedList = new LinkedList();
    Cursor localCursor = ((n)h.ax(n.class)).bzA().iZW();
    if (localCursor.getCount() == 0)
    {
      localCursor.close();
      AppMethodBeat.o(42924);
      return localLinkedList;
    }
    localCursor.moveToFirst();
    do
    {
      au localau = new au();
      localau.convertFrom(localCursor);
      localLinkedList.add(localau);
    } while (localCursor.moveToNext());
    localCursor.close();
    Log.d("MicroMsg.ContactStorageLogic", "getFavourList size:  " + localLinkedList.size());
    AppMethodBeat.o(42924);
    return localLinkedList;
  }
  
  public static List<String> bBU()
  {
    AppMethodBeat.i(42925);
    LinkedList localLinkedList = new LinkedList();
    Cursor localCursor = ((n)h.ax(n.class)).bzA().ayT(256);
    if (localCursor.getCount() == 0)
    {
      localCursor.close();
      AppMethodBeat.o(42925);
      return localLinkedList;
    }
    localCursor.moveToFirst();
    do
    {
      au localau = new au();
      localau.convertFrom(localCursor);
      localLinkedList.add(localau.field_username);
    } while (localCursor.moveToNext());
    localCursor.close();
    Log.d("MicroMsg.ContactStorageLogic", "getSnsBlackContactList size:  " + localLinkedList.size());
    AppMethodBeat.o(42925);
    return localLinkedList;
  }
  
  public static int bBV()
  {
    AppMethodBeat.i(42928);
    int i = ((n)h.ax(n.class)).bzA().d(oko, new String[] { z.bAM(), "weixin", "helper_entry", "filehelper" });
    AppMethodBeat.o(42928);
    return i;
  }
  
  public static int bBW()
  {
    AppMethodBeat.i(242151);
    int i = ((n)h.ax(n.class)).bzA().jaE();
    AppMethodBeat.o(242151);
    return i;
  }
  
  public static boolean bBX()
  {
    AppMethodBeat.i(242172);
    String str = (String)h.baE().ban().d(274436, null);
    if (TextUtils.isEmpty(str))
    {
      AppMethodBeat.o(242172);
      return false;
    }
    if (!"CN".equalsIgnoreCase(str))
    {
      AppMethodBeat.o(242172);
      return true;
    }
    AppMethodBeat.o(242172);
    return false;
  }
  
  public static int[] bS(List<String> paramList)
  {
    AppMethodBeat.i(42877);
    long l = System.currentTimeMillis();
    int[] arrayOfInt1 = ((n)h.ax(n.class)).bzA().na(paramList);
    Log.d("MicroMsg.ContactStorageLogic", "kevin service(IMessengerStorage.class).getContactStg().getShowHeadDistinct(" + (System.currentTimeMillis() - l));
    if ((arrayOfInt1 == null) || (arrayOfInt1.length <= 0))
    {
      AppMethodBeat.o(42877);
      return null;
    }
    l = System.currentTimeMillis();
    paramList = ((n)h.ax(n.class)).bzA().nb(paramList);
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
  
  public static String[] bT(List<String> paramList)
  {
    AppMethodBeat.i(42881);
    long l = System.currentTimeMillis();
    paramList = ((n)h.ax(n.class)).bzA().na(paramList);
    Log.d("MicroMsg.ContactStorageLogic", "kevin service(IMessengerStorage.class).getContactStg().getShowSectionByShowHead" + (System.currentTimeMillis() - l));
    if ((paramList == null) || (paramList.length <= 0))
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
  
  public static String c(String paramString, String[] paramArrayOfString1, String... paramVarArgs)
  {
    AppMethodBeat.i(242160);
    if (com.tencent.mm.contact.b.maH.aRG())
    {
      paramString = a("usernameFlag", paramArrayOfString1, false, paramVarArgs);
      AppMethodBeat.o(242160);
      return paramString;
    }
    paramString = a(paramString, paramArrayOfString1, paramVarArgs);
    AppMethodBeat.o(242160);
    return paramString;
  }
  
  public static void c(au paramau, String paramString)
  {
    AppMethodBeat.i(42869);
    au localau = ((n)h.ax(n.class)).bzA().JE(paramau.field_username);
    if ((localau != null) && (paramString != null)) {}
    for (boolean bool = true;; bool = false)
    {
      Assert.assertTrue(bool);
      localau.AW(paramString);
      if ((au.bwO(paramau.field_username)) && (ojW != null)) {
        ojW.aw(paramau.field_username, paramString);
      }
      N(localau);
      AppMethodBeat.o(42869);
      return;
    }
  }
  
  public static boolean c(bb parambb)
  {
    AppMethodBeat.i(242175);
    boolean bool2 = au.bwp(parambb.field_username);
    boolean bool1 = bool2;
    if (!bool2) {
      bool1 = parambb.rx(2097152);
    }
    bool2 = bool1;
    if (!bool1) {
      bool2 = parambb.rx(8388608);
    }
    bool1 = bool2;
    if (!bool2) {
      bool1 = parambb.rx(16777216);
    }
    bool2 = bool1;
    if (!bool1) {
      bool2 = au.bwy(parambb.field_username);
    }
    bool1 = bool2;
    if (!bool2) {
      bool1 = au.bwD(parambb.field_username);
    }
    AppMethodBeat.o(242175);
    return bool1;
  }
  
  private static String i(String... paramVarArgs)
  {
    AppMethodBeat.i(242157);
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
    AppMethodBeat.o(242157);
    return paramVarArgs;
  }
  
  public static String j(boolean paramBoolean, int paramInt)
  {
    switch (paramInt)
    {
    default: 
      return "";
    case 4: 
      if (paramBoolean) {
        return okj;
      }
      return oki;
    case 5: 
      if (paramBoolean) {
        return okl;
      }
      return okk;
    case 1: 
      if (paramBoolean) {
        return oka;
      }
      return ojZ;
    case 2: 
      if (paramBoolean) {
        return oke;
      }
      return okd;
    case 3: 
      if (paramBoolean) {
        return okh;
      }
      return okg;
    }
    return okn;
  }
  
  public static boolean q(au paramau)
  {
    AppMethodBeat.i(42840);
    if (paramau == null)
    {
      AppMethodBeat.o(42840);
      return false;
    }
    if (!au.bwE(paramau.field_username))
    {
      AppMethodBeat.o(42840);
      return false;
    }
    if (!d.rs(paramau.field_type))
    {
      AppMethodBeat.o(42840);
      return false;
    }
    AppMethodBeat.o(42840);
    return true;
  }
  
  public static void r(au paramau)
  {
    AppMethodBeat.i(42852);
    boolean bool;
    au localau2;
    if (paramau != null)
    {
      bool = true;
      Assert.assertTrue(bool);
      localau2 = ((n)h.ax(n.class)).bzA().JE(paramau.field_username);
      localau1 = paramau;
      if (localau2 != null) {
        if (!Util.isNullOrNil(localau2.field_username)) {
          break label77;
        }
      }
    }
    label77:
    for (au localau1 = paramau;; localau1 = localau2)
    {
      localau1.aRU();
      N(localau1);
      AppMethodBeat.o(42852);
      return;
      bool = false;
      break;
    }
  }
  
  public static void s(au paramau)
  {
    AppMethodBeat.i(42854);
    boolean bool;
    au localau2;
    if (paramau != null)
    {
      bool = true;
      Assert.assertTrue(bool);
      localau2 = ((n)h.ax(n.class)).bzA().JE(paramau.field_username);
      localau1 = paramau;
      if (localau2 != null) {
        if (!Util.isNullOrNil(localau2.field_username)) {
          break label77;
        }
      }
    }
    label77:
    for (au localau1 = paramau;; localau1 = localau2)
    {
      localau1.aRS();
      N(localau1);
      AppMethodBeat.o(42854);
      return;
      bool = false;
      break;
    }
  }
  
  public static void t(au paramau)
  {
    AppMethodBeat.i(42855);
    boolean bool;
    au localau2;
    if (paramau != null)
    {
      bool = true;
      Assert.assertTrue(bool);
      localau2 = ((n)h.ax(n.class)).bzA().JE(paramau.field_username);
      localau1 = paramau;
      if (localau2 != null) {
        if (!Util.isNullOrNil(localau2.field_username)) {
          break label77;
        }
      }
    }
    label77:
    for (au localau1 = paramau;; localau1 = localau2)
    {
      localau1.aRT();
      N(localau1);
      AppMethodBeat.o(42855);
      return;
      bool = false;
      break;
    }
  }
  
  public static void u(au paramau)
  {
    AppMethodBeat.i(242107);
    boolean bool;
    au localau2;
    if (paramau != null)
    {
      bool = true;
      Assert.assertTrue(bool);
      localau2 = ((n)h.ax(n.class)).bzA().JE(paramau.field_username);
      localau1 = paramau;
      if (localau2 != null) {
        if (!Util.isNullOrNil(localau2.field_username)) {
          break label77;
        }
      }
    }
    label77:
    for (au localau1 = paramau;; localau1 = localau2)
    {
      localau1.aRO();
      O(localau1);
      AppMethodBeat.o(242107);
      return;
      bool = false;
      break;
    }
  }
  
  public static boolean uX(int paramInt)
  {
    AppMethodBeat.i(242078);
    Log.i("MicroMsg.ContactStorageLogic", "union luckymoney logic：isOpenImIncludeAssociateRoomOrOpenIMUser sceneid :%s ", new Object[] { Integer.valueOf(paramInt) });
    if (paramInt == 1005)
    {
      Log.i("MicroMsg.ContactStorageLogic", "union luckymoney logic：use union luckymoney ");
      AppMethodBeat.o(242078);
      return true;
    }
    Log.i("MicroMsg.ContactStorageLogic", "union luckymoney logic：use normal luckymoney ");
    AppMethodBeat.o(242078);
    return false;
  }
  
  public static boolean uY(int paramInt)
  {
    AppMethodBeat.i(42851);
    boolean bool = au.ayS(paramInt);
    AppMethodBeat.o(42851);
    return bool;
  }
  
  public static void v(au paramau)
  {
    AppMethodBeat.i(242108);
    boolean bool;
    au localau2;
    if (paramau != null)
    {
      bool = true;
      Assert.assertTrue(bool);
      localau2 = ((n)h.ax(n.class)).bzA().JE(paramau.field_username);
      localau1 = paramau;
      if (localau2 != null) {
        if (!Util.isNullOrNil(localau2.field_username)) {
          break label77;
        }
      }
    }
    label77:
    for (au localau1 = paramau;; localau1 = localau2)
    {
      localau1.aRP();
      O(localau1);
      AppMethodBeat.o(242108);
      return;
      bool = false;
      break;
    }
  }
  
  public static void w(au paramau)
  {
    AppMethodBeat.i(242109);
    boolean bool;
    au localau2;
    if (paramau != null)
    {
      bool = true;
      Assert.assertTrue(bool);
      localau2 = ((n)h.ax(n.class)).bzA().JE(paramau.field_username);
      localau1 = paramau;
      if (localau2 != null) {
        if (!Util.isNullOrNil(localau2.field_username)) {
          break label77;
        }
      }
    }
    label77:
    for (au localau1 = paramau;; localau1 = localau2)
    {
      localau1.aRQ();
      O(localau1);
      AppMethodBeat.o(242109);
      return;
      bool = false;
      break;
    }
  }
  
  public static void x(au paramau)
  {
    AppMethodBeat.i(242111);
    boolean bool;
    au localau2;
    if (paramau != null)
    {
      bool = true;
      Assert.assertTrue(bool);
      localau2 = ((n)h.ax(n.class)).bzA().JE(paramau.field_username);
      localau1 = paramau;
      if (localau2 != null) {
        if (!Util.isNullOrNil(localau2.field_username)) {
          break label77;
        }
      }
    }
    label77:
    for (au localau1 = paramau;; localau1 = localau2)
    {
      localau1.aRR();
      O(localau1);
      AppMethodBeat.o(242111);
      return;
      bool = false;
      break;
    }
  }
  
  public static void y(au paramau)
  {
    AppMethodBeat.i(242113);
    boolean bool;
    au localau2;
    if (paramau != null)
    {
      bool = true;
      Assert.assertTrue(bool);
      localau2 = ((n)h.ax(n.class)).bzA().JE(paramau.field_username);
      localau1 = paramau;
      if (localau2 != null) {
        if (!Util.isNullOrNil(localau2.field_username)) {
          break label77;
        }
      }
    }
    label77:
    for (au localau1 = paramau;; localau1 = localau2)
    {
      localau1.aSh();
      O(localau1);
      AppMethodBeat.o(242113);
      return;
      bool = false;
      break;
    }
  }
  
  public static void z(au paramau)
  {
    AppMethodBeat.i(242115);
    boolean bool;
    au localau2;
    if (paramau != null)
    {
      bool = true;
      Assert.assertTrue(bool);
      localau2 = ((n)h.ax(n.class)).bzA().JE(paramau.field_username);
      localau1 = paramau;
      if (localau2 != null) {
        if (!Util.isNullOrNil(localau2.field_username)) {
          break label77;
        }
      }
    }
    label77:
    for (au localau1 = paramau;; localau1 = localau2)
    {
      localau1.aSi();
      O(localau1);
      AppMethodBeat.o(242115);
      return;
      bool = false;
      break;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.model.ab
 * JD-Core Version:    0.7.0.1
 */