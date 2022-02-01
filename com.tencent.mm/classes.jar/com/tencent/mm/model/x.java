package com.tencent.mm.model;

import android.database.Cursor;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.c.aw;
import com.tencent.mm.g.c.ba;
import com.tencent.mm.kernel.e;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.messenger.foundation.a.a.j;
import com.tencent.mm.plugin.messenger.foundation.a.a.k.a;
import com.tencent.mm.plugin.messenger.foundation.a.t;
import com.tencent.mm.protocal.protobuf.SKBuiltinBuffer_t;
import com.tencent.mm.protocal.protobuf.caj;
import com.tencent.mm.protocal.protobuf.cbe;
import com.tencent.mm.protocal.protobuf.cbf;
import com.tencent.mm.protocal.protobuf.cxn;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.bu;
import com.tencent.mm.storage.ac;
import com.tencent.mm.storage.aj;
import com.tencent.mm.storage.au;
import com.tencent.mm.storage.bq;
import com.tencent.mm.storage.br;
import com.tencent.mm.storage.cb;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import junit.framework.Assert;

public final class x
{
  private static an hHT;
  private static HashMap<String, Boolean> hHU;
  public static final String hHV;
  public static final String hHW;
  public static final String hHX;
  public static final String hHY;
  public static final String hHZ;
  public static final String hIa;
  public static final String hIb;
  public static final String hIc;
  public static final String hId;
  public static final String[] hIe;
  
  static
  {
    AppMethodBeat.i(42931);
    hHT = null;
    hHU = new HashMap();
    hHV = b("rconversation.username", new String[] { "@im.chatroom", "@chatroom", "@openim", "@micromsg.qq.com" });
    hHW = b("rconversation.username", new String[] { "@chatroom", "@micromsg.qq.com" });
    hHX = b("rconversation.username", new String[] { "@t.qq.com" });
    hHY = b("rconversation.username", new String[] { "@qqim" });
    hHZ = b("rconversation.username", new String[] { "@chatroom_exclusive" });
    hIa = b("rconversation.username", new String[] { "@micromsg.qq.com" });
    hIb = b("rconversation.username", new String[] { "@app" });
    hIc = b("rconversation.username", new String[] { "@chatroom" });
    hId = b("rconversation.username", new String[] { "@im.chatroom" });
    hIe = new String[] { "qqmail", "fmessage", "tmessage", "qmessage", "qqsync", "floatbottle", "lbsapp", "shakeapp", "medianote", "qqfriend", "newsapp", "blogapp", "facebookapp", "topstoryapp", "masssendapp", "feedsapp", "voipapp", "cardpackage", "voicevoipapp", "voiceinputapp", "officialaccounts", "linkedinplugin", "notifymessage", "appbrandcustomerservicemsg", "appbrand_notify_message" };
    AppMethodBeat.o(42931);
  }
  
  public static void A(com.tencent.mm.storage.an paraman)
  {
    AppMethodBeat.i(42866);
    if (paraman != null) {}
    for (boolean bool = true;; bool = false)
    {
      Assert.assertTrue(bool);
      com.tencent.mm.storage.an localan2 = ((com.tencent.mm.plugin.messenger.foundation.a.l)g.ab(com.tencent.mm.plugin.messenger.foundation.a.l.class)).azF().BH(paraman.field_username);
      com.tencent.mm.storage.an localan1;
      if (localan2 != null)
      {
        localan1 = localan2;
        if (!bu.isNullOrNil(localan2.field_username)) {}
      }
      else
      {
        localan1 = paraman;
      }
      localan1.adh();
      if ((com.tencent.mm.storage.an.aUq(paraman.field_username)) && (hHT != null)) {
        hHT.wq(paraman.field_username);
      }
      G(localan1);
      AppMethodBeat.o(42866);
      return;
    }
  }
  
  public static boolean AA(String paramString)
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
  
  public static boolean AB(String paramString)
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
  
  public static boolean AC(String paramString)
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
  
  public static boolean AD(String paramString)
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
  
  public static boolean AE(String paramString)
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
  
  public static boolean AF(String paramString)
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
  
  public static boolean AG(String paramString)
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
  
  public static boolean AH(String paramString)
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
  
  public static boolean AI(String paramString)
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
  
  public static boolean AJ(String paramString)
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
  
  public static boolean AK(String paramString)
  {
    AppMethodBeat.i(42901);
    boolean bool = AL(paramString);
    AppMethodBeat.o(42901);
    return bool;
  }
  
  public static boolean AL(String paramString)
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
  
  public static boolean AM(String paramString)
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
  
  public static boolean AN(String paramString)
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
  
  public static boolean AO(String paramString)
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
  
  public static boolean AP(String paramString)
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
  
  public static boolean AQ(String paramString)
  {
    AppMethodBeat.i(42907);
    boolean bool = "filehelper".equalsIgnoreCase(paramString);
    AppMethodBeat.o(42907);
    return bool;
  }
  
  public static boolean AR(String paramString)
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
  
  public static boolean AS(String paramString)
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
  
  public static boolean AT(String paramString)
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
  
  public static boolean AU(String paramString)
  {
    AppMethodBeat.i(42911);
    if (AV(paramString))
    {
      AppMethodBeat.o(42911);
      return true;
    }
    if (AZ(paramString))
    {
      AppMethodBeat.o(42911);
      return true;
    }
    if (AN(paramString))
    {
      AppMethodBeat.o(42911);
      return true;
    }
    if (AO(paramString))
    {
      AppMethodBeat.o(42911);
      return true;
    }
    AppMethodBeat.o(42911);
    return false;
  }
  
  public static boolean AV(String paramString)
  {
    AppMethodBeat.i(42912);
    g.ajS();
    String str = (String)g.ajR().ajA().get(21, null);
    if (((str != null) && (str.equalsIgnoreCase(paramString))) || (paramString.equalsIgnoreCase("weixin")))
    {
      AppMethodBeat.o(42912);
      return true;
    }
    AppMethodBeat.o(42912);
    return false;
  }
  
  public static boolean AW(String paramString)
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
  
  public static boolean AX(String paramString)
  {
    AppMethodBeat.i(213408);
    if (paramString != null)
    {
      boolean bool = paramString.equalsIgnoreCase("appbrand_notify_message");
      AppMethodBeat.o(213408);
      return bool;
    }
    AppMethodBeat.o(213408);
    return false;
  }
  
  public static boolean AY(String paramString)
  {
    AppMethodBeat.i(213409);
    if (paramString != null)
    {
      boolean bool = paramString.equalsIgnoreCase("findersayhisessionholder");
      AppMethodBeat.o(213409);
      return bool;
    }
    AppMethodBeat.o(213409);
    return false;
  }
  
  public static boolean AZ(String paramString)
  {
    AppMethodBeat.i(42914);
    String[] arrayOfString = hIe;
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
  
  public static boolean Aa(String paramString)
  {
    AppMethodBeat.i(178867);
    if ((((t)g.ab(t.class)).Yn()) && (zU(paramString)))
    {
      paramString = ((com.tencent.mm.plugin.chatroom.a.c)g.ab(com.tencent.mm.plugin.chatroom.a.c.class)).azP().Bx(paramString);
      if ((paramString != null) && (paramString.YQ()))
      {
        AppMethodBeat.o(178867);
        return true;
      }
    }
    AppMethodBeat.o(178867);
    return false;
  }
  
  public static boolean Ab(String paramString)
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
  
  public static boolean Ac(String paramString)
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
  
  public static boolean Ad(String paramString)
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
  
  public static boolean Ae(String paramString)
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
  
  public static boolean Af(String paramString)
  {
    AppMethodBeat.i(42841);
    boolean bool = "gh_43f2581f6fd6".equals(paramString);
    AppMethodBeat.o(42841);
    return bool;
  }
  
  public static boolean Ag(String paramString)
  {
    AppMethodBeat.i(42842);
    boolean bool = "gh_3dfda90e39d6".equals(paramString);
    AppMethodBeat.o(42842);
    return bool;
  }
  
  public static boolean Ah(String paramString)
  {
    AppMethodBeat.i(213403);
    boolean bool = "gh_f0a92aa7146c".equals(paramString);
    AppMethodBeat.o(213403);
    return bool;
  }
  
  public static boolean Ai(String paramString)
  {
    AppMethodBeat.i(163508);
    boolean bool = "1@fackuser".equals(paramString);
    AppMethodBeat.o(163508);
    return bool;
  }
  
  public static boolean Aj(String paramString)
  {
    AppMethodBeat.i(213404);
    boolean bool = "msginfo@fakeuser".equals(paramString);
    AppMethodBeat.o(213404);
    return bool;
  }
  
  public static boolean Ak(String paramString)
  {
    AppMethodBeat.i(42843);
    boolean bool = "downloaderapp".equals(paramString);
    AppMethodBeat.o(42843);
    return bool;
  }
  
  public static boolean Al(String paramString)
  {
    AppMethodBeat.i(42844);
    if ((paramString == null) || (paramString.length() <= 0))
    {
      AppMethodBeat.o(42844);
      return false;
    }
    if (!zT(paramString))
    {
      AppMethodBeat.o(42844);
      return false;
    }
    paramString = ((com.tencent.mm.plugin.messenger.foundation.a.l)g.ab(com.tencent.mm.plugin.messenger.foundation.a.l.class)).azF().BH(paramString);
    if ((paramString == null) || (!com.tencent.mm.contact.c.lO(paramString.field_type)))
    {
      AppMethodBeat.o(42844);
      return false;
    }
    AppMethodBeat.o(42844);
    return true;
  }
  
  public static boolean Am(String paramString)
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
  
  public static boolean An(String paramString)
  {
    AppMethodBeat.i(42849);
    if ((paramString == null) || (paramString.length() <= 0))
    {
      AppMethodBeat.o(42849);
      return true;
    }
    boolean bool = com.tencent.mm.contact.c.lO(((com.tencent.mm.plugin.messenger.foundation.a.l)g.ab(com.tencent.mm.plugin.messenger.foundation.a.l.class)).azF().BH(paramString).field_type);
    AppMethodBeat.o(42849);
    return bool;
  }
  
  public static boolean Ao(String paramString)
  {
    AppMethodBeat.i(42850);
    if (bu.isNullOrNil(paramString))
    {
      AppMethodBeat.o(42850);
      return false;
    }
    paramString = ((com.tencent.mm.plugin.messenger.foundation.a.l)g.ab(com.tencent.mm.plugin.messenger.foundation.a.l.class)).azF().BH(paramString);
    if (paramString == null)
    {
      AppMethodBeat.o(42850);
      return false;
    }
    boolean bool = com.tencent.mm.storage.an.abz(paramString.field_verifyFlag);
    AppMethodBeat.o(42850);
    return bool;
  }
  
  public static void Ap(String paramString)
  {
    AppMethodBeat.i(42863);
    au localau2 = ((com.tencent.mm.plugin.messenger.foundation.a.l)g.ab(com.tencent.mm.plugin.messenger.foundation.a.l.class)).azL().aVa(paramString);
    int i = 0;
    au localau1 = localau2;
    if (localau2 == null)
    {
      localau1 = new au();
      localau1.fuK();
      i = 1;
      localau1.setUsername(paramString);
    }
    localau1.qH(System.currentTimeMillis());
    if (i != 0)
    {
      ((com.tencent.mm.plugin.messenger.foundation.a.l)g.ab(com.tencent.mm.plugin.messenger.foundation.a.l.class)).azL().e(localau1);
      AppMethodBeat.o(42863);
      return;
    }
    ((com.tencent.mm.plugin.messenger.foundation.a.l)g.ab(com.tencent.mm.plugin.messenger.foundation.a.l.class)).azL().a(localau1, paramString);
    AppMethodBeat.o(42863);
  }
  
  public static void Aq(String paramString)
  {
    AppMethodBeat.i(42875);
    if (bu.isNullOrNil(paramString))
    {
      AppMethodBeat.o(42875);
      return;
    }
    com.tencent.mm.storage.an localan = ((com.tencent.mm.plugin.messenger.foundation.a.l)g.ab(com.tencent.mm.plugin.messenger.foundation.a.l.class)).azF().BH(paramString);
    if (localan == null)
    {
      AppMethodBeat.o(42875);
      return;
    }
    localan.setSource(0);
    localan.acQ();
    ((com.tencent.mm.plugin.messenger.foundation.a.l)g.ab(com.tencent.mm.plugin.messenger.foundation.a.l.class)).azF().c(paramString, localan);
    AppMethodBeat.o(42875);
  }
  
  public static boolean Ar(String paramString)
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
  
  public static boolean As(String paramString)
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
  
  public static boolean At(String paramString)
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
  
  public static boolean Au(String paramString)
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
  
  public static boolean Av(String paramString)
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
  
  public static boolean Aw(String paramString)
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
  
  public static boolean Ax(String paramString)
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
  
  public static boolean Ay(String paramString)
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
  
  public static boolean Az(String paramString)
  {
    AppMethodBeat.i(42890);
    boolean bool = "qqsync".equalsIgnoreCase(paramString);
    AppMethodBeat.o(42890);
    return bool;
  }
  
  public static void B(com.tencent.mm.storage.an paraman)
  {
    boolean bool2 = true;
    AppMethodBeat.i(42867);
    if (paraman != null)
    {
      bool1 = true;
      Assert.assertTrue("MicroMsg.ContactStorageLogic: user is null", bool1);
      if ((int)paraman.ght == 0) {
        break label97;
      }
      bool1 = true;
      label31:
      Assert.assertTrue("MicroMsg.ContactStorageLogic: contactId == 0", bool1);
      if (paraman.field_username.length() <= 0) {
        break label102;
      }
    }
    label97:
    label102:
    for (boolean bool1 = bool2;; bool1 = false)
    {
      Assert.assertTrue("MicroMsg.ContactStorageLogic: username length <= 0", bool1);
      paraman.acS();
      ((com.tencent.mm.plugin.messenger.foundation.a.l)g.ab(com.tencent.mm.plugin.messenger.foundation.a.l.class)).azF().c(paraman.field_username, paraman);
      AppMethodBeat.o(42867);
      return;
      bool1 = false;
      break;
      bool1 = false;
      break label31;
    }
  }
  
  public static boolean Ba(String paramString)
  {
    AppMethodBeat.i(42915);
    if (AZ(paramString))
    {
      AppMethodBeat.o(42915);
      return true;
    }
    if (com.tencent.mm.storage.an.aUp(paramString))
    {
      AppMethodBeat.o(42915);
      return true;
    }
    if (com.tencent.mm.storage.an.aUn(paramString))
    {
      AppMethodBeat.o(42915);
      return true;
    }
    if (com.tencent.mm.storage.an.Ac(paramString))
    {
      AppMethodBeat.o(42915);
      return true;
    }
    AppMethodBeat.o(42915);
    return false;
  }
  
  public static int Bb(String paramString)
  {
    AppMethodBeat.i(42916);
    if (bu.nullAsNil(paramString).length() > 0) {}
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
    if (com.tencent.mm.storage.an.aUn(paramString))
    {
      AppMethodBeat.o(42916);
      return 11;
    }
    if (com.tencent.mm.storage.an.aUp(paramString))
    {
      AppMethodBeat.o(42916);
      return 36;
    }
    if (com.tencent.mm.storage.an.Ac(paramString))
    {
      AppMethodBeat.o(42916);
      return 1;
    }
    AppMethodBeat.o(42916);
    return 1;
  }
  
  public static int Bc(String paramString)
  {
    AppMethodBeat.i(42917);
    if (bu.nullAsNil(paramString).length() > 0) {}
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
    if (com.tencent.mm.storage.an.aUn(paramString))
    {
      AppMethodBeat.o(42917);
      return 13;
    }
    if (com.tencent.mm.storage.an.aUp(paramString))
    {
      AppMethodBeat.o(42917);
      return 39;
    }
    if (com.tencent.mm.storage.an.Ac(paramString))
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
  
  public static boolean Bd(String paramString)
  {
    AppMethodBeat.i(42918);
    if (((com.tencent.mm.plugin.messenger.foundation.a.l)g.ab(com.tencent.mm.plugin.messenger.foundation.a.l.class)).azF().BH(paramString).eRd != 1)
    {
      AppMethodBeat.o(42918);
      return false;
    }
    AppMethodBeat.o(42918);
    return true;
  }
  
  public static boolean Be(String paramString)
  {
    AppMethodBeat.i(42919);
    paramString = ((com.tencent.mm.plugin.messenger.foundation.a.l)g.ab(com.tencent.mm.plugin.messenger.foundation.a.l.class)).azF().BH(paramString);
    if ((paramString != null) && (paramString.Pd()))
    {
      AppMethodBeat.o(42919);
      return true;
    }
    AppMethodBeat.o(42919);
    return false;
  }
  
  public static boolean Bf(String paramString)
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
  
  public static String Bg(String paramString)
  {
    AppMethodBeat.i(42921);
    if (Bf(paramString))
    {
      paramString = paramString.replace("http://t.qq.com/", "").replace("t.qq.com/", "");
      AppMethodBeat.o(42921);
      return paramString;
    }
    AppMethodBeat.o(42921);
    return "";
  }
  
  public static boolean Bh(String paramString)
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
  
  public static boolean Bi(String paramString)
  {
    AppMethodBeat.i(178868);
    paramString = ((com.tencent.mm.plugin.chatroom.a.c)g.ab(com.tencent.mm.plugin.chatroom.a.c.class)).azP().Bx(paramString);
    if (paramString == null)
    {
      AppMethodBeat.o(178868);
      return false;
    }
    boolean bool = paramString.YQ();
    AppMethodBeat.o(178868);
    return bool;
  }
  
  public static boolean Bj(String paramString)
  {
    AppMethodBeat.i(184702);
    paramString = ((com.tencent.mm.plugin.chatroom.a.c)g.ab(com.tencent.mm.plugin.chatroom.a.c.class)).azP().Bx(paramString);
    if (paramString == null)
    {
      AppMethodBeat.o(184702);
      return false;
    }
    boolean bool = paramString.Bj(v.aAC());
    AppMethodBeat.o(184702);
    return bool;
  }
  
  public static void C(com.tencent.mm.storage.an paraman)
  {
    boolean bool2 = true;
    AppMethodBeat.i(42868);
    if (paraman != null)
    {
      bool1 = true;
      Assert.assertTrue(bool1);
      if ((int)paraman.ght == 0) {
        break label92;
      }
      bool1 = true;
      label28:
      Assert.assertTrue(bool1);
      if (paraman.field_username.length() <= 0) {
        break label97;
      }
    }
    label92:
    label97:
    for (boolean bool1 = bool2;; bool1 = false)
    {
      Assert.assertTrue(bool1);
      paraman.acS();
      ((com.tencent.mm.plugin.messenger.foundation.a.l)g.ab(com.tencent.mm.plugin.messenger.foundation.a.l.class)).azF().c(paraman.field_username, paraman);
      G(paraman);
      AppMethodBeat.o(42868);
      return;
      bool1 = false;
      break;
      bool1 = false;
      break label28;
    }
  }
  
  public static void C(String paramString, boolean paramBoolean)
  {
    AppMethodBeat.i(42853);
    paramString = ((com.tencent.mm.plugin.messenger.foundation.a.l)g.ab(com.tencent.mm.plugin.messenger.foundation.a.l.class)).azF().BH(paramString);
    if ((paramString == null) || (bu.isNullOrNil(paramString.field_username)))
    {
      AppMethodBeat.o(42853);
      return;
    }
    if (paramBoolean) {
      paramString.adi();
    }
    for (;;)
    {
      E(paramString);
      AppMethodBeat.o(42853);
      return;
      paramString.adj();
    }
  }
  
  public static void D(com.tencent.mm.storage.an paraman)
  {
    boolean bool2 = true;
    AppMethodBeat.i(42870);
    if (paraman != null)
    {
      bool1 = true;
      Assert.assertTrue(bool1);
      if ((int)paraman.ght == 0) {
        break label68;
      }
      bool1 = true;
      label28:
      Assert.assertTrue(bool1);
      if (paraman.field_username.length() <= 0) {
        break label73;
      }
    }
    label68:
    label73:
    for (boolean bool1 = bool2;; bool1 = false)
    {
      Assert.assertTrue(bool1);
      paraman.adD();
      G(paraman);
      AppMethodBeat.o(42870);
      return;
      bool1 = false;
      break;
      bool1 = false;
      break label28;
    }
  }
  
  public static void D(String paramString, boolean paramBoolean)
  {
    AppMethodBeat.i(42862);
    if (!bu.isNullOrNil(paramString)) {}
    com.tencent.mm.storage.an localan;
    for (boolean bool = true;; bool = false)
    {
      Assert.assertTrue(bool);
      localan = ((com.tencent.mm.plugin.messenger.foundation.a.l)g.ab(com.tencent.mm.plugin.messenger.foundation.a.l.class)).azF().BH(paramString);
      if ((localan != null) && (!bu.isNullOrNil(localan.field_username))) {
        break;
      }
      AppMethodBeat.o(42862);
      return;
    }
    localan.setType(localan.field_type | 0x800);
    if (((com.tencent.mm.storage.an.aUq(paramString)) || (zV(paramString))) && (hHT != null)) {
      hHT.wj(paramString);
    }
    G(localan);
    if (paramBoolean) {
      ((com.tencent.mm.plugin.messenger.foundation.a.l)g.ab(com.tencent.mm.plugin.messenger.foundation.a.l.class)).azL().aVg(paramString);
    }
    AppMethodBeat.o(42862);
  }
  
  private static void E(com.tencent.mm.storage.an paraman)
  {
    AppMethodBeat.i(42871);
    boolean bool;
    cbe localcbe;
    if (paraman != null)
    {
      bool = true;
      Assert.assertTrue(bool);
      if ((int)paraman.ght == 0)
      {
        ((com.tencent.mm.plugin.messenger.foundation.a.l)g.ab(com.tencent.mm.plugin.messenger.foundation.a.l.class)).azF().ao(paraman);
        ((com.tencent.mm.plugin.messenger.foundation.a.l)g.ab(com.tencent.mm.plugin.messenger.foundation.a.l.class)).azF().BH(paraman.field_username);
      }
      ((com.tencent.mm.plugin.messenger.foundation.a.l)g.ab(com.tencent.mm.plugin.messenger.foundation.a.l.class)).azF().c(paraman.field_username, paraman);
      localcbe = new cbe();
      localcbe.Hol = paraman.field_username;
      if (!paraman.ady()) {
        break label159;
      }
    }
    label159:
    for (localcbe.Hoh = 1;; localcbe.Hoh = 2)
    {
      ((com.tencent.mm.plugin.messenger.foundation.a.l)g.ab(com.tencent.mm.plugin.messenger.foundation.a.l.class)).azE().d(new k.a(52, localcbe));
      AppMethodBeat.o(42871);
      return;
      bool = false;
      break;
    }
  }
  
  public static void E(String paramString, boolean paramBoolean)
  {
    AppMethodBeat.i(42864);
    if (!bu.isNullOrNil(paramString)) {}
    com.tencent.mm.storage.an localan;
    for (boolean bool = true;; bool = false)
    {
      Assert.assertTrue(bool);
      localan = ((com.tencent.mm.plugin.messenger.foundation.a.l)g.ab(com.tencent.mm.plugin.messenger.foundation.a.l.class)).azF().BH(paramString);
      if ((localan != null) && (!bu.isNullOrNil(localan.field_username))) {
        break;
      }
      AppMethodBeat.o(42864);
      return;
    }
    localan.setType(localan.field_type & 0xFFFFF7FF);
    if (((com.tencent.mm.storage.an.aUq(paramString)) || (zV(paramString))) && (hHT != null)) {
      hHT.wk(paramString);
    }
    G(localan);
    if (paramBoolean) {
      ((com.tencent.mm.plugin.messenger.foundation.a.l)g.ab(com.tencent.mm.plugin.messenger.foundation.a.l.class)).azL().aVh(paramString);
    }
    AppMethodBeat.o(42864);
  }
  
  public static void F(com.tencent.mm.storage.an paraman)
  {
    AppMethodBeat.i(42872);
    boolean bool;
    cbf localcbf;
    if (paraman != null)
    {
      bool = true;
      Assert.assertTrue(bool);
      if ((int)paraman.ght == 0)
      {
        ((com.tencent.mm.plugin.messenger.foundation.a.l)g.ab(com.tencent.mm.plugin.messenger.foundation.a.l.class)).azF().ao(paraman);
        ((com.tencent.mm.plugin.messenger.foundation.a.l)g.ab(com.tencent.mm.plugin.messenger.foundation.a.l.class)).azF().BH(paraman.field_username);
      }
      ((com.tencent.mm.plugin.messenger.foundation.a.l)g.ab(com.tencent.mm.plugin.messenger.foundation.a.l.class)).azF().c(paraman.field_username, paraman);
      localcbf = new cbf();
      localcbf.Hol = paraman.field_username;
      if (!paraman.adA()) {
        break label159;
      }
    }
    label159:
    for (localcbf.Hoh = 1;; localcbf.Hoh = 2)
    {
      ((com.tencent.mm.plugin.messenger.foundation.a.l)g.ab(com.tencent.mm.plugin.messenger.foundation.a.l.class)).azE().d(new k.a(72, localcbf));
      AppMethodBeat.o(42872);
      return;
      bool = false;
      break;
    }
  }
  
  public static void G(com.tencent.mm.storage.an paraman)
  {
    AppMethodBeat.i(42873);
    if (paraman != null) {}
    for (boolean bool = true;; bool = false)
    {
      Assert.assertTrue(bool);
      if ((int)paraman.ght == 0)
      {
        ((com.tencent.mm.plugin.messenger.foundation.a.l)g.ab(com.tencent.mm.plugin.messenger.foundation.a.l.class)).azF().ao(paraman);
        ((com.tencent.mm.plugin.messenger.foundation.a.l)g.ab(com.tencent.mm.plugin.messenger.foundation.a.l.class)).azF().BH(paraman.field_username);
      }
      ((com.tencent.mm.plugin.messenger.foundation.a.l)g.ab(com.tencent.mm.plugin.messenger.foundation.a.l.class)).azF().c(paraman.field_username, paraman);
      if (!com.tencent.mm.storage.an.aUq(paraman.field_username)) {
        I(paraman);
      }
      AppMethodBeat.o(42873);
      return;
    }
  }
  
  public static caj H(com.tencent.mm.storage.an paraman)
  {
    AppMethodBeat.i(213405);
    ae.i("MicroMsg.ContactStorageLogic", "oplog modContact user:%s remark:%s type:%d ", new Object[] { paraman.field_username, paraman.field_conRemark, Integer.valueOf(paraman.field_type) });
    caj localcaj = new caj();
    localcaj.GuF = new cxn().aQV(bu.nullAsNil(paraman.field_username));
    localcaj.Hed = new cxn().aQV(bu.nullAsNil(paraman.field_nickname));
    localcaj.GtY = new cxn().aQV(bu.nullAsNil(paraman.VL()));
    localcaj.GtZ = new cxn().aQV(bu.nullAsNil(paraman.VM()));
    localcaj.jfV = paraman.eQV;
    localcaj.Gti = 9015167;
    localcaj.Gtj = paraman.field_type;
    localcaj.Hnt = new cxn().aQV(bu.nullAsNil(paraman.field_conRemark));
    localcaj.Hnu = new cxn().aQV(bu.nullAsNil(paraman.field_conRemarkPYShort));
    localcaj.Hnv = new cxn().aQV(bu.nullAsNil(paraman.field_conRemarkPYFull));
    localcaj.Gto = paraman.eRa;
    localcaj.HnN = new cxn().aQV(bu.nullAsNil(paraman.field_domainList));
    localcaj.Gts = paraman.eRd;
    localcaj.jfZ = paraman.eRe;
    localcaj.jfY = bu.nullAsNil(paraman.signature);
    localcaj.jfX = bu.nullAsNil(paraman.getCityCode());
    localcaj.jfW = bu.nullAsNil(paraman.ful());
    localcaj.Hhw = bu.nullAsNil(paraman.eRj);
    localcaj.Hhy = paraman.field_weiboFlag;
    localcaj.HnJ = 0;
    localcaj.FNK = new SKBuiltinBuffer_t();
    localcaj.jge = bu.nullAsNil(paraman.getCountryCode());
    AppMethodBeat.o(213405);
    return localcaj;
  }
  
  public static void I(com.tencent.mm.storage.an paraman)
  {
    AppMethodBeat.i(42874);
    ((com.tencent.mm.plugin.messenger.foundation.a.l)g.ab(com.tencent.mm.plugin.messenger.foundation.a.l.class)).azE().d(new k.a(2, H(paraman)));
    AppMethodBeat.o(42874);
  }
  
  public static boolean J(com.tencent.mm.storage.an paraman)
  {
    return (paraman.field_weiboFlag & 0x1) != 0;
  }
  
  public static void a(an paraman)
  {
    hHT = paraman;
  }
  
  public static boolean a(au paramau)
  {
    AppMethodBeat.i(42926);
    String str = paramau.field_username;
    if (AZ(str))
    {
      AppMethodBeat.o(42926);
      return false;
    }
    if (AV(str))
    {
      AppMethodBeat.o(42926);
      return false;
    }
    if (AN(str))
    {
      AppMethodBeat.o(42926);
      return false;
    }
    if (AO(str))
    {
      AppMethodBeat.o(42926);
      return false;
    }
    if (paramau.field_conversationTime == -1L)
    {
      AppMethodBeat.o(42926);
      return false;
    }
    if (Ao(str))
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
    int[] arrayOfInt = ((com.tencent.mm.plugin.messenger.foundation.a.l)g.ab(com.tencent.mm.plugin.messenger.foundation.a.l.class)).azF().b(paramString1, paramString2, paramArrayOfString, paramList);
    if (arrayOfInt.length <= 0)
    {
      AppMethodBeat.o(42878);
      return null;
    }
    paramString1 = ((com.tencent.mm.plugin.messenger.foundation.a.l)g.ab(com.tencent.mm.plugin.messenger.foundation.a.l.class)).azF().c(paramString1, paramString2, paramArrayOfString, paramList);
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
    AppMethodBeat.i(213406);
    long l = System.currentTimeMillis();
    int[] arrayOfInt = ((com.tencent.mm.plugin.messenger.foundation.a.l)g.ab(com.tencent.mm.plugin.messenger.foundation.a.l.class)).azF().b(paramArrayOfString, paramString1, paramString2, paramString3, paramList);
    ae.d("MicroMsg.ContactStorageLogic", "kevin service(IMessengerStorage.class).getContactStg().getShowHeadDistinct(" + (System.currentTimeMillis() - l));
    if (arrayOfInt.length <= 0)
    {
      AppMethodBeat.o(213406);
      return null;
    }
    l = System.currentTimeMillis();
    paramArrayOfString = ((com.tencent.mm.plugin.messenger.foundation.a.l)g.ab(com.tencent.mm.plugin.messenger.foundation.a.l.class)).azF().c(paramArrayOfString, paramString1, paramString2, paramString3, paramList);
    ae.d("MicroMsg.ContactStorageLogic", "kevin service(IMessengerStorage.class).getContactStg().getSectionNumByShowHead" + (System.currentTimeMillis() - l));
    if (paramArrayOfString == null)
    {
      AppMethodBeat.o(213406);
      return null;
    }
    if (arrayOfInt.length != paramArrayOfString.length)
    {
      ae.e("MicroMsg.ContactStorageLogic", "[%s:%s] filterType:%s filterSearchStr:%s blocklist:%s searchString:%s", new Object[] { Integer.valueOf(arrayOfInt.length), Integer.valueOf(paramArrayOfString.length), paramString1, paramString2, paramList, paramString3 });
      AppMethodBeat.o(213406);
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
    AppMethodBeat.o(213406);
    return paramString1;
  }
  
  public static String[] a(String paramString1, String paramString2, String[] paramArrayOfString, List<String> paramList)
  {
    AppMethodBeat.i(42879);
    long l = System.currentTimeMillis();
    paramString1 = ((com.tencent.mm.plugin.messenger.foundation.a.l)g.ab(com.tencent.mm.plugin.messenger.foundation.a.l.class)).azF().b(paramString1, paramString2, paramArrayOfString, paramList);
    ae.d("MicroMsg.ContactStorageLogic", "kevin service(IMessengerStorage.class).getContactStg().getShowSectionByShowHead" + (System.currentTimeMillis() - l));
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
    AppMethodBeat.i(213407);
    long l = System.currentTimeMillis();
    paramArrayOfString = ((com.tencent.mm.plugin.messenger.foundation.a.l)g.ab(com.tencent.mm.plugin.messenger.foundation.a.l.class)).azF().b(paramArrayOfString, paramString1, paramString2, paramString3, paramList);
    ae.d("MicroMsg.ContactStorageLogic", "kevin service(IMessengerStorage.class).getContactStg().getShowSectionByShowHead" + (System.currentTimeMillis() - l));
    if (paramArrayOfString.length <= 0)
    {
      AppMethodBeat.o(213407);
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
    AppMethodBeat.o(213407);
    return paramString1;
  }
  
  public static boolean aBA()
  {
    AppMethodBeat.i(42922);
    if (!v.aBp())
    {
      AppMethodBeat.o(42922);
      return false;
    }
    cb localcb = ((com.tencent.mm.plugin.messenger.foundation.a.l)g.ab(com.tencent.mm.plugin.messenger.foundation.a.l.class)).azO().arD("@t.qq.com");
    if ((localcb == null) || (bu.isNullOrNil(localcb.name)))
    {
      AppMethodBeat.o(42922);
      return false;
    }
    AppMethodBeat.o(42922);
    return true;
  }
  
  public static boolean aBB()
  {
    AppMethodBeat.i(42923);
    if (!v.aBp())
    {
      AppMethodBeat.o(42923);
      return false;
    }
    cb localcb = ((com.tencent.mm.plugin.messenger.foundation.a.l)g.ab(com.tencent.mm.plugin.messenger.foundation.a.l.class)).azO().arD("@t.qq.com");
    if ((localcb == null) || (bu.nullAsNil(localcb.name).length() == 0))
    {
      AppMethodBeat.o(42923);
      return false;
    }
    AppMethodBeat.o(42923);
    return true;
  }
  
  public static List<com.tencent.mm.storage.an> aBC()
  {
    AppMethodBeat.i(42924);
    LinkedList localLinkedList = new LinkedList();
    Cursor localCursor = ((com.tencent.mm.plugin.messenger.foundation.a.l)g.ab(com.tencent.mm.plugin.messenger.foundation.a.l.class)).azF().fux();
    if (localCursor.getCount() == 0)
    {
      localCursor.close();
      AppMethodBeat.o(42924);
      return localLinkedList;
    }
    localCursor.moveToFirst();
    do
    {
      com.tencent.mm.storage.an localan = new com.tencent.mm.storage.an();
      localan.convertFrom(localCursor);
      localLinkedList.add(localan);
    } while (localCursor.moveToNext());
    localCursor.close();
    ae.d("MicroMsg.ContactStorageLogic", "getFavourList size:  " + localLinkedList.size());
    AppMethodBeat.o(42924);
    return localLinkedList;
  }
  
  public static List<String> aBD()
  {
    AppMethodBeat.i(42925);
    LinkedList localLinkedList = new LinkedList();
    Cursor localCursor = ((com.tencent.mm.plugin.messenger.foundation.a.l)g.ab(com.tencent.mm.plugin.messenger.foundation.a.l.class)).azF().fuv();
    if (localCursor.getCount() == 0)
    {
      localCursor.close();
      AppMethodBeat.o(42925);
      return localLinkedList;
    }
    localCursor.moveToFirst();
    do
    {
      com.tencent.mm.storage.an localan = new com.tencent.mm.storage.an();
      localan.convertFrom(localCursor);
      localLinkedList.add(localan.field_username);
    } while (localCursor.moveToNext());
    localCursor.close();
    ae.d("MicroMsg.ContactStorageLogic", "getSnsBlackContactList size:  " + localLinkedList.size());
    AppMethodBeat.o(42925);
    return localLinkedList;
  }
  
  public static int aBE()
  {
    AppMethodBeat.i(42928);
    int i = ((com.tencent.mm.plugin.messenger.foundation.a.l)g.ab(com.tencent.mm.plugin.messenger.foundation.a.l.class)).azF().c(hIe, new String[] { v.aAC(), "weixin", "helper_entry", "filehelper" });
    AppMethodBeat.o(42928);
    return i;
  }
  
  public static List<String> aBx()
  {
    AppMethodBeat.i(42846);
    List localList = ((com.tencent.mm.plugin.messenger.foundation.a.l)g.ab(com.tencent.mm.plugin.messenger.foundation.a.l.class)).azF().fut();
    AppMethodBeat.o(42846);
    return localList;
  }
  
  public static List<com.tencent.mm.storage.an> aBy()
  {
    AppMethodBeat.i(42847);
    ArrayList localArrayList = new ArrayList();
    Cursor localCursor = ((com.tencent.mm.plugin.messenger.foundation.a.l)g.ab(com.tencent.mm.plugin.messenger.foundation.a.l.class)).azF().fuu();
    if (localCursor.moveToFirst()) {
      do
      {
        com.tencent.mm.storage.an localan = new com.tencent.mm.storage.an();
        localan.convertFrom(localCursor);
        localArrayList.add(localan);
      } while (localCursor.moveToNext());
    }
    localCursor.close();
    AppMethodBeat.o(42847);
    return localArrayList;
  }
  
  public static boolean aBz()
  {
    return false;
  }
  
  public static int[] ag(List<String> paramList)
  {
    AppMethodBeat.i(42877);
    long l = System.currentTimeMillis();
    int[] arrayOfInt1 = ((com.tencent.mm.plugin.messenger.foundation.a.l)g.ab(com.tencent.mm.plugin.messenger.foundation.a.l.class)).azF().hR(paramList);
    ae.d("MicroMsg.ContactStorageLogic", "kevin service(IMessengerStorage.class).getContactStg().getShowHeadDistinct(" + (System.currentTimeMillis() - l));
    if (arrayOfInt1.length <= 0)
    {
      AppMethodBeat.o(42877);
      return null;
    }
    l = System.currentTimeMillis();
    paramList = ((com.tencent.mm.plugin.messenger.foundation.a.l)g.ab(com.tencent.mm.plugin.messenger.foundation.a.l.class)).azF().hS(paramList);
    ae.d("MicroMsg.ContactStorageLogic", "kevin service(IMessengerStorage.class).getContactStg().getSectionNumByShowHead" + (System.currentTimeMillis() - l));
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
  
  public static String[] ah(List<String> paramList)
  {
    AppMethodBeat.i(42881);
    long l = System.currentTimeMillis();
    paramList = ((com.tencent.mm.plugin.messenger.foundation.a.l)g.ab(com.tencent.mm.plugin.messenger.foundation.a.l.class)).azF().hR(paramList);
    ae.d("MicroMsg.ContactStorageLogic", "kevin service(IMessengerStorage.class).getContactStg().getShowSectionByShowHead" + (System.currentTimeMillis() - l));
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
  
  public static boolean b(au paramau)
  {
    AppMethodBeat.i(42927);
    paramau = paramau.field_username;
    if (AN(paramau))
    {
      AppMethodBeat.o(42927);
      return false;
    }
    if (AW(paramau))
    {
      AppMethodBeat.o(42927);
      return false;
    }
    if (AX(paramau))
    {
      AppMethodBeat.o(42927);
      return false;
    }
    AppMethodBeat.o(42927);
    return true;
  }
  
  public static void c(com.tencent.mm.storage.an paraman, String paramString)
  {
    AppMethodBeat.i(42869);
    com.tencent.mm.storage.an localan = ((com.tencent.mm.plugin.messenger.foundation.a.l)g.ab(com.tencent.mm.plugin.messenger.foundation.a.l.class)).azF().BH(paraman.field_username);
    if ((localan != null) && (paramString != null)) {}
    for (boolean bool = true;; bool = false)
    {
      Assert.assertTrue(bool);
      localan.tm(paramString);
      if ((com.tencent.mm.storage.an.aUq(paraman.field_username)) && (hHT != null)) {
        hHT.ak(paraman.field_username, paramString);
      }
      G(localan);
      AppMethodBeat.o(42869);
      return;
    }
  }
  
  public static boolean oq(int paramInt)
  {
    AppMethodBeat.i(42851);
    boolean bool = com.tencent.mm.storage.an.abz(paramInt);
    AppMethodBeat.o(42851);
    return bool;
  }
  
  public static boolean p(com.tencent.mm.storage.an paraman)
  {
    AppMethodBeat.i(42840);
    if (paraman == null)
    {
      AppMethodBeat.o(42840);
      return false;
    }
    if (!zT(paraman.field_username))
    {
      AppMethodBeat.o(42840);
      return false;
    }
    if (!com.tencent.mm.contact.c.lO(paraman.field_type))
    {
      AppMethodBeat.o(42840);
      return false;
    }
    AppMethodBeat.o(42840);
    return true;
  }
  
  public static void q(com.tencent.mm.storage.an paraman)
  {
    AppMethodBeat.i(42852);
    boolean bool;
    com.tencent.mm.storage.an localan2;
    if (paraman != null)
    {
      bool = true;
      Assert.assertTrue(bool);
      localan2 = ((com.tencent.mm.plugin.messenger.foundation.a.l)g.ab(com.tencent.mm.plugin.messenger.foundation.a.l.class)).azF().BH(paraman.field_username);
      localan1 = paraman;
      if (localan2 != null) {
        if (!bu.isNullOrNil(localan2.field_username)) {
          break label77;
        }
      }
    }
    label77:
    for (com.tencent.mm.storage.an localan1 = paraman;; localan1 = localan2)
    {
      localan1.acY();
      G(localan1);
      AppMethodBeat.o(42852);
      return;
      bool = false;
      break;
    }
  }
  
  public static void r(com.tencent.mm.storage.an paraman)
  {
    AppMethodBeat.i(42854);
    boolean bool;
    com.tencent.mm.storage.an localan2;
    if (paraman != null)
    {
      bool = true;
      Assert.assertTrue(bool);
      localan2 = ((com.tencent.mm.plugin.messenger.foundation.a.l)g.ab(com.tencent.mm.plugin.messenger.foundation.a.l.class)).azF().BH(paraman.field_username);
      localan1 = paraman;
      if (localan2 != null) {
        if (!bu.isNullOrNil(localan2.field_username)) {
          break label77;
        }
      }
    }
    label77:
    for (com.tencent.mm.storage.an localan1 = paraman;; localan1 = localan2)
    {
      localan1.acW();
      G(localan1);
      AppMethodBeat.o(42854);
      return;
      bool = false;
      break;
    }
  }
  
  public static void s(com.tencent.mm.storage.an paraman)
  {
    AppMethodBeat.i(42855);
    boolean bool;
    com.tencent.mm.storage.an localan2;
    if (paraman != null)
    {
      bool = true;
      Assert.assertTrue(bool);
      localan2 = ((com.tencent.mm.plugin.messenger.foundation.a.l)g.ab(com.tencent.mm.plugin.messenger.foundation.a.l.class)).azF().BH(paraman.field_username);
      localan1 = paraman;
      if (localan2 != null) {
        if (!bu.isNullOrNil(localan2.field_username)) {
          break label77;
        }
      }
    }
    label77:
    for (com.tencent.mm.storage.an localan1 = paraman;; localan1 = localan2)
    {
      localan1.acX();
      G(localan1);
      AppMethodBeat.o(42855);
      return;
      bool = false;
      break;
    }
  }
  
  public static void t(com.tencent.mm.storage.an paraman)
  {
    AppMethodBeat.i(42856);
    if (paraman != null) {}
    for (boolean bool = true;; bool = false)
    {
      Assert.assertTrue(bool);
      com.tencent.mm.storage.an localan2 = ((com.tencent.mm.plugin.messenger.foundation.a.l)g.ab(com.tencent.mm.plugin.messenger.foundation.a.l.class)).azF().BH(paraman.field_username);
      com.tencent.mm.storage.an localan1;
      if (localan2 != null)
      {
        localan1 = localan2;
        if (!bu.isNullOrNil(localan2.field_username)) {}
      }
      else
      {
        localan1 = paraman;
      }
      localan1.acU();
      if ((com.tencent.mm.storage.an.aUq(paraman.field_username)) && (hHT != null)) {
        hHT.wl(paraman.field_username);
      }
      G(localan1);
      AppMethodBeat.o(42856);
      return;
    }
  }
  
  public static void u(com.tencent.mm.storage.an paraman)
  {
    AppMethodBeat.i(42857);
    if (paraman != null) {}
    for (boolean bool = true;; bool = false)
    {
      Assert.assertTrue(bool);
      com.tencent.mm.storage.an localan2 = ((com.tencent.mm.plugin.messenger.foundation.a.l)g.ab(com.tencent.mm.plugin.messenger.foundation.a.l.class)).azF().BH(paraman.field_username);
      com.tencent.mm.storage.an localan1;
      if (localan2 != null)
      {
        localan1 = localan2;
        if (!bu.isNullOrNil(localan2.field_username)) {}
      }
      else
      {
        localan1 = paraman;
      }
      localan1.acV();
      if ((com.tencent.mm.storage.an.aUq(paraman.field_username)) && (hHT != null)) {
        hHT.wm(paraman.field_username);
      }
      G(localan1);
      paraman = ((com.tencent.mm.plugin.messenger.foundation.a.l)g.ab(com.tencent.mm.plugin.messenger.foundation.a.l.class)).azL().aVa(paraman.field_username);
      if ((paraman != null) && ("@blacklist".equals(paraman.field_parentRef))) {
        ((com.tencent.mm.plugin.messenger.foundation.a.l)g.ab(com.tencent.mm.plugin.messenger.foundation.a.l.class)).azL().c(new String[] { paraman.field_username }, "");
      }
      AppMethodBeat.o(42857);
      return;
    }
  }
  
  public static void v(com.tencent.mm.storage.an paraman)
  {
    AppMethodBeat.i(42858);
    if (paraman != null) {}
    for (boolean bool = true;; bool = false)
    {
      Assert.assertTrue(bool);
      com.tencent.mm.storage.an localan2 = ((com.tencent.mm.plugin.messenger.foundation.a.l)g.ab(com.tencent.mm.plugin.messenger.foundation.a.l.class)).azF().BH(paraman.field_username);
      com.tencent.mm.storage.an localan1;
      if (localan2 != null)
      {
        localan1 = localan2;
        if (!bu.isNullOrNil(localan2.field_username)) {}
      }
      else
      {
        localan1 = paraman;
      }
      localan1.adi();
      localan1.kb(paraman.acP());
      E(localan1);
      AppMethodBeat.o(42858);
      return;
    }
  }
  
  public static void w(com.tencent.mm.storage.an paraman)
  {
    AppMethodBeat.i(42859);
    if (paraman != null) {}
    for (boolean bool = true;; bool = false)
    {
      Assert.assertTrue(bool);
      com.tencent.mm.storage.an localan2 = ((com.tencent.mm.plugin.messenger.foundation.a.l)g.ab(com.tencent.mm.plugin.messenger.foundation.a.l.class)).azF().BH(paraman.field_username);
      com.tencent.mm.storage.an localan1;
      if (localan2 != null)
      {
        localan1 = localan2;
        if (!bu.isNullOrNil(localan2.field_username)) {}
      }
      else
      {
        localan1 = paraman;
      }
      localan1.adj();
      localan1.kb(paraman.acP());
      E(localan1);
      AppMethodBeat.o(42859);
      return;
    }
  }
  
  public static boolean wb(String paramString)
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
  
  public static void x(com.tencent.mm.storage.an paraman)
  {
    AppMethodBeat.i(42860);
    if (paraman != null) {}
    for (boolean bool = true;; bool = false)
    {
      Assert.assertTrue(bool);
      com.tencent.mm.storage.an localan2 = ((com.tencent.mm.plugin.messenger.foundation.a.l)g.ab(com.tencent.mm.plugin.messenger.foundation.a.l.class)).azF().BH(paraman.field_username);
      com.tencent.mm.storage.an localan1;
      if (localan2 != null)
      {
        localan1 = localan2;
        if (!bu.isNullOrNil(localan2.field_username)) {}
      }
      else
      {
        localan1 = paraman;
      }
      localan1.ade();
      localan1.kb(paraman.acP());
      if ((com.tencent.mm.storage.an.aUq(paraman.field_username)) && (hHT != null)) {
        hHT.wn(paraman.field_username);
      }
      G(localan1);
      AppMethodBeat.o(42860);
      return;
    }
  }
  
  public static void y(com.tencent.mm.storage.an paraman)
  {
    AppMethodBeat.i(42861);
    if (paraman != null) {}
    for (boolean bool = true;; bool = false)
    {
      Assert.assertTrue(bool);
      com.tencent.mm.storage.an localan2 = ((com.tencent.mm.plugin.messenger.foundation.a.l)g.ab(com.tencent.mm.plugin.messenger.foundation.a.l.class)).azF().BH(paraman.field_username);
      com.tencent.mm.storage.an localan1;
      if (localan2 != null)
      {
        localan1 = localan2;
        if (!bu.isNullOrNil(localan2.field_username)) {}
      }
      else
      {
        localan1 = paraman;
      }
      localan1.adf();
      localan1.kb(paraman.acP());
      if ((com.tencent.mm.storage.an.aUq(paraman.field_username)) && (hHT != null)) {
        hHT.wo(paraman.field_username);
      }
      G(localan1);
      AppMethodBeat.o(42861);
      return;
    }
  }
  
  public static void z(com.tencent.mm.storage.an paraman)
  {
    AppMethodBeat.i(42865);
    if (paraman != null) {}
    for (boolean bool = true;; bool = false)
    {
      Assert.assertTrue(bool);
      com.tencent.mm.storage.an localan2 = ((com.tencent.mm.plugin.messenger.foundation.a.l)g.ab(com.tencent.mm.plugin.messenger.foundation.a.l.class)).azF().BH(paraman.field_username);
      com.tencent.mm.storage.an localan1;
      if (localan2 != null)
      {
        localan1 = localan2;
        if (!bu.isNullOrNil(localan2.field_username)) {}
      }
      else
      {
        localan1 = paraman;
      }
      localan1.adg();
      if ((com.tencent.mm.storage.an.aUq(paraman.field_username)) && (hHT != null)) {
        hHT.wp(paraman.field_username);
      }
      G(localan1);
      AppMethodBeat.o(42865);
      return;
    }
  }
  
  public static boolean zS(String paramString)
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
  
  public static boolean zT(String paramString)
  {
    AppMethodBeat.i(42832);
    if ((zU(paramString)) || (zV(paramString)))
    {
      AppMethodBeat.o(42832);
      return true;
    }
    AppMethodBeat.o(42832);
    return false;
  }
  
  public static boolean zU(String paramString)
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
  
  public static boolean zV(String paramString)
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
  
  public static boolean zW(String paramString)
  {
    AppMethodBeat.i(178864);
    if ((paramString == null) || (paramString.length() <= 0))
    {
      AppMethodBeat.o(178864);
      return false;
    }
    if ((paramString.endsWith("@im.chatroom")) || (zX(paramString)))
    {
      AppMethodBeat.o(178864);
      return true;
    }
    AppMethodBeat.o(178864);
    return false;
  }
  
  public static boolean zX(String paramString)
  {
    AppMethodBeat.i(178865);
    Boolean localBoolean;
    Object localObject;
    if (zU(paramString))
    {
      localBoolean = null;
      if (hHU.containsKey(paramString)) {
        localBoolean = (Boolean)hHU.get(paramString);
      }
      localObject = localBoolean;
      if (localBoolean == null)
      {
        localBoolean = Boolean.FALSE;
        localObject = ((com.tencent.mm.plugin.chatroom.a.c)g.ab(com.tencent.mm.plugin.chatroom.a.c.class)).azP().Bx(paramString);
        if ((localObject == null) || ((((ac)localObject).field_chatroomStatus & 0x20000) != 131072)) {
          break label121;
        }
        localBoolean = Boolean.TRUE;
      }
    }
    label121:
    for (;;)
    {
      hHU.put(paramString, localBoolean);
      localObject = localBoolean;
      boolean bool = ((Boolean)localObject).booleanValue();
      AppMethodBeat.o(178865);
      return bool;
      AppMethodBeat.o(178865);
      return false;
    }
  }
  
  public static void zY(String paramString)
  {
    AppMethodBeat.i(213402);
    hHU.remove(paramString);
    AppMethodBeat.o(213402);
  }
  
  public static boolean zZ(String paramString)
  {
    AppMethodBeat.i(178866);
    if (zU(paramString))
    {
      paramString = ((com.tencent.mm.plugin.chatroom.a.c)g.ab(com.tencent.mm.plugin.chatroom.a.c.class)).azP().Bx(paramString);
      if ((paramString != null) && ((paramString.field_chatroomStatus & 0x20000) != 131072) && ((paramString.field_chatroomStatus & 0x10000) == 65536))
      {
        AppMethodBeat.o(178866);
        return true;
      }
    }
    AppMethodBeat.o(178866);
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.model.x
 * JD-Core Version:    0.7.0.1
 */