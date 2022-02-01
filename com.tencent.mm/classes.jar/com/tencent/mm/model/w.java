package com.tencent.mm.model;

import android.database.Cursor;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.c.aw;
import com.tencent.mm.g.c.ba;
import com.tencent.mm.kernel.e;
import com.tencent.mm.kernel.g;
import com.tencent.mm.o.b;
import com.tencent.mm.plugin.chatroom.a.c;
import com.tencent.mm.plugin.messenger.foundation.a.a.j;
import com.tencent.mm.plugin.messenger.foundation.a.a.k.a;
import com.tencent.mm.plugin.messenger.foundation.a.s;
import com.tencent.mm.protocal.protobuf.SKBuiltinBuffer_t;
import com.tencent.mm.protocal.protobuf.bzp;
import com.tencent.mm.protocal.protobuf.cak;
import com.tencent.mm.protocal.protobuf.cal;
import com.tencent.mm.protocal.protobuf.cwt;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.storage.ab;
import com.tencent.mm.storage.ai;
import com.tencent.mm.storage.am;
import com.tencent.mm.storage.at;
import com.tencent.mm.storage.bp;
import com.tencent.mm.storage.bq;
import com.tencent.mm.storage.ca;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import junit.framework.Assert;

public final class w
{
  private static al hFb;
  private static HashMap<String, Boolean> hFc;
  public static final String hFd;
  public static final String hFe;
  public static final String hFf;
  public static final String hFg;
  public static final String hFh;
  public static final String hFi;
  public static final String hFj;
  public static final String hFk;
  public static final String hFl;
  public static final String[] hFm;
  
  static
  {
    AppMethodBeat.i(42931);
    hFb = null;
    hFc = new HashMap();
    hFd = b("rconversation.username", new String[] { "@im.chatroom", "@chatroom", "@openim", "@micromsg.qq.com" });
    hFe = b("rconversation.username", new String[] { "@chatroom", "@micromsg.qq.com" });
    hFf = b("rconversation.username", new String[] { "@t.qq.com" });
    hFg = b("rconversation.username", new String[] { "@qqim" });
    hFh = b("rconversation.username", new String[] { "@chatroom_exclusive" });
    hFi = b("rconversation.username", new String[] { "@micromsg.qq.com" });
    hFj = b("rconversation.username", new String[] { "@app" });
    hFk = b("rconversation.username", new String[] { "@chatroom" });
    hFl = b("rconversation.username", new String[] { "@im.chatroom" });
    hFm = new String[] { "qqmail", "fmessage", "tmessage", "qmessage", "qqsync", "floatbottle", "lbsapp", "shakeapp", "medianote", "qqfriend", "newsapp", "blogapp", "facebookapp", "topstoryapp", "masssendapp", "feedsapp", "voipapp", "cardpackage", "voicevoipapp", "voiceinputapp", "officialaccounts", "linkedinplugin", "notifymessage", "appbrandcustomerservicemsg", "appbrand_notify_message" };
    AppMethodBeat.o(42931);
  }
  
  public static bzp A(am paramam)
  {
    AppMethodBeat.i(192531);
    ad.i("MicroMsg.ContactStorageLogic", "oplog modContact user:%s remark:%s type:%d ", new Object[] { paramam.field_username, paramam.field_conRemark, Integer.valueOf(paramam.field_type) });
    bzp localbzp = new bzp();
    localbzp.GbY = new cwt().aPy(bt.nullAsNil(paramam.field_username));
    localbzp.GKC = new cwt().aPy(bt.nullAsNil(paramam.field_nickname));
    localbzp.Gbr = new cwt().aPy(bt.nullAsNil(paramam.VD()));
    localbzp.Gbs = new cwt().aPy(bt.nullAsNil(paramam.VE()));
    localbzp.jdc = paramam.ePk;
    localbzp.GaB = 9015167;
    localbzp.GaC = paramam.field_type;
    localbzp.GTS = new cwt().aPy(bt.nullAsNil(paramam.field_conRemark));
    localbzp.GTT = new cwt().aPy(bt.nullAsNil(paramam.field_conRemarkPYShort));
    localbzp.GTU = new cwt().aPy(bt.nullAsNil(paramam.field_conRemarkPYFull));
    localbzp.GaH = paramam.ePp;
    localbzp.GUm = new cwt().aPy(bt.nullAsNil(paramam.field_domainList));
    localbzp.GaL = paramam.ePs;
    localbzp.jdg = paramam.ePt;
    localbzp.jdf = bt.nullAsNil(paramam.signature);
    localbzp.jde = bt.nullAsNil(paramam.getCityCode());
    localbzp.jdd = bt.nullAsNil(paramam.fql());
    localbzp.GNW = bt.nullAsNil(paramam.ePy);
    localbzp.GNY = paramam.field_weiboFlag;
    localbzp.GUi = 0;
    localbzp.Fvm = new SKBuiltinBuffer_t();
    localbzp.jdl = bt.nullAsNil(paramam.getCountryCode());
    AppMethodBeat.o(192531);
    return localbzp;
  }
  
  public static boolean Aa(String paramString)
  {
    AppMethodBeat.i(42901);
    boolean bool = Ab(paramString);
    AppMethodBeat.o(42901);
    return bool;
  }
  
  public static boolean Ab(String paramString)
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
  
  public static boolean Ac(String paramString)
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
  
  public static boolean Ad(String paramString)
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
  
  public static boolean Ae(String paramString)
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
  
  public static boolean Af(String paramString)
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
  
  public static boolean Ag(String paramString)
  {
    AppMethodBeat.i(42907);
    boolean bool = "filehelper".equalsIgnoreCase(paramString);
    AppMethodBeat.o(42907);
    return bool;
  }
  
  public static boolean Ah(String paramString)
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
  
  public static boolean Ai(String paramString)
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
  
  public static boolean Aj(String paramString)
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
  
  public static boolean Ak(String paramString)
  {
    AppMethodBeat.i(42911);
    if (Al(paramString))
    {
      AppMethodBeat.o(42911);
      return true;
    }
    if (Ap(paramString))
    {
      AppMethodBeat.o(42911);
      return true;
    }
    if (Ad(paramString))
    {
      AppMethodBeat.o(42911);
      return true;
    }
    if (Ae(paramString))
    {
      AppMethodBeat.o(42911);
      return true;
    }
    AppMethodBeat.o(42911);
    return false;
  }
  
  public static boolean Al(String paramString)
  {
    AppMethodBeat.i(42912);
    g.ajD();
    String str = (String)g.ajC().ajl().get(21, null);
    if (((str != null) && (str.equalsIgnoreCase(paramString))) || (paramString.equalsIgnoreCase("weixin")))
    {
      AppMethodBeat.o(42912);
      return true;
    }
    AppMethodBeat.o(42912);
    return false;
  }
  
  public static boolean Am(String paramString)
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
  
  public static boolean An(String paramString)
  {
    AppMethodBeat.i(192534);
    if (paramString != null)
    {
      boolean bool = paramString.equalsIgnoreCase("appbrand_notify_message");
      AppMethodBeat.o(192534);
      return bool;
    }
    AppMethodBeat.o(192534);
    return false;
  }
  
  public static boolean Ao(String paramString)
  {
    AppMethodBeat.i(192535);
    if (paramString != null)
    {
      boolean bool = paramString.equalsIgnoreCase("findersayhisessionholder");
      AppMethodBeat.o(192535);
      return bool;
    }
    AppMethodBeat.o(192535);
    return false;
  }
  
  public static boolean Ap(String paramString)
  {
    AppMethodBeat.i(42914);
    String[] arrayOfString = hFm;
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
  
  public static boolean Aq(String paramString)
  {
    AppMethodBeat.i(42915);
    if (Ap(paramString))
    {
      AppMethodBeat.o(42915);
      return true;
    }
    if (am.aSP(paramString))
    {
      AppMethodBeat.o(42915);
      return true;
    }
    if (am.aSN(paramString))
    {
      AppMethodBeat.o(42915);
      return true;
    }
    if (am.zs(paramString))
    {
      AppMethodBeat.o(42915);
      return true;
    }
    AppMethodBeat.o(42915);
    return false;
  }
  
  public static int Ar(String paramString)
  {
    AppMethodBeat.i(42916);
    if (bt.nullAsNil(paramString).length() > 0) {}
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
    if (am.aSN(paramString))
    {
      AppMethodBeat.o(42916);
      return 11;
    }
    if (am.aSP(paramString))
    {
      AppMethodBeat.o(42916);
      return 36;
    }
    if (am.zs(paramString))
    {
      AppMethodBeat.o(42916);
      return 1;
    }
    AppMethodBeat.o(42916);
    return 1;
  }
  
  public static int As(String paramString)
  {
    AppMethodBeat.i(42917);
    if (bt.nullAsNil(paramString).length() > 0) {}
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
    if (am.aSN(paramString))
    {
      AppMethodBeat.o(42917);
      return 13;
    }
    if (am.aSP(paramString))
    {
      AppMethodBeat.o(42917);
      return 39;
    }
    if (am.zs(paramString))
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
  
  public static boolean At(String paramString)
  {
    AppMethodBeat.i(42918);
    if (((com.tencent.mm.plugin.messenger.foundation.a.l)g.ab(com.tencent.mm.plugin.messenger.foundation.a.l.class)).azp().Bf(paramString).ePs != 1)
    {
      AppMethodBeat.o(42918);
      return false;
    }
    AppMethodBeat.o(42918);
    return true;
  }
  
  public static boolean Au(String paramString)
  {
    AppMethodBeat.i(42919);
    paramString = ((com.tencent.mm.plugin.messenger.foundation.a.l)g.ab(com.tencent.mm.plugin.messenger.foundation.a.l.class)).azp().Bf(paramString);
    if ((paramString != null) && (paramString.Pf()))
    {
      AppMethodBeat.o(42919);
      return true;
    }
    AppMethodBeat.o(42919);
    return false;
  }
  
  public static boolean Av(String paramString)
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
  
  public static String Aw(String paramString)
  {
    AppMethodBeat.i(42921);
    if (Av(paramString))
    {
      paramString = paramString.replace("http://t.qq.com/", "").replace("t.qq.com/", "");
      AppMethodBeat.o(42921);
      return paramString;
    }
    AppMethodBeat.o(42921);
    return "";
  }
  
  public static boolean Ax(String paramString)
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
  
  public static boolean Ay(String paramString)
  {
    AppMethodBeat.i(178868);
    paramString = ((c)g.ab(c.class)).azz().AN(paramString);
    if (paramString == null)
    {
      AppMethodBeat.o(178868);
      return false;
    }
    boolean bool = paramString.YH();
    AppMethodBeat.o(178868);
    return bool;
  }
  
  public static boolean Az(String paramString)
  {
    AppMethodBeat.i(184702);
    paramString = ((c)g.ab(c.class)).azz().AN(paramString);
    if (paramString == null)
    {
      AppMethodBeat.o(184702);
      return false;
    }
    boolean bool = paramString.Az(u.aAm());
    AppMethodBeat.o(184702);
    return bool;
  }
  
  public static void B(am paramam)
  {
    AppMethodBeat.i(42874);
    ((com.tencent.mm.plugin.messenger.foundation.a.l)g.ab(com.tencent.mm.plugin.messenger.foundation.a.l.class)).azo().c(new k.a(2, A(paramam)));
    AppMethodBeat.o(42874);
  }
  
  public static void C(String paramString, boolean paramBoolean)
  {
    AppMethodBeat.i(42853);
    paramString = ((com.tencent.mm.plugin.messenger.foundation.a.l)g.ab(com.tencent.mm.plugin.messenger.foundation.a.l.class)).azp().Bf(paramString);
    if ((paramString == null) || (bt.isNullOrNil(paramString.field_username)))
    {
      AppMethodBeat.o(42853);
      return;
    }
    if (paramBoolean) {
      paramString.acW();
    }
    for (;;)
    {
      x(paramString);
      AppMethodBeat.o(42853);
      return;
      paramString.acX();
    }
  }
  
  public static boolean C(am paramam)
  {
    return (paramam.field_weiboFlag & 0x1) != 0;
  }
  
  public static void D(String paramString, boolean paramBoolean)
  {
    AppMethodBeat.i(42862);
    if (!bt.isNullOrNil(paramString)) {}
    am localam;
    for (boolean bool = true;; bool = false)
    {
      Assert.assertTrue(bool);
      localam = ((com.tencent.mm.plugin.messenger.foundation.a.l)g.ab(com.tencent.mm.plugin.messenger.foundation.a.l.class)).azp().Bf(paramString);
      if ((localam != null) && (!bt.isNullOrNil(localam.field_username))) {
        break;
      }
      AppMethodBeat.o(42862);
      return;
    }
    localam.setType(localam.field_type | 0x800);
    if (((am.aSQ(paramString)) || (zl(paramString))) && (hFb != null)) {
      hFb.AV(paramString);
    }
    z(localam);
    if (paramBoolean) {
      ((com.tencent.mm.plugin.messenger.foundation.a.l)g.ab(com.tencent.mm.plugin.messenger.foundation.a.l.class)).azv().aTF(paramString);
    }
    AppMethodBeat.o(42862);
  }
  
  public static void E(String paramString, boolean paramBoolean)
  {
    AppMethodBeat.i(42864);
    if (!bt.isNullOrNil(paramString)) {}
    am localam;
    for (boolean bool = true;; bool = false)
    {
      Assert.assertTrue(bool);
      localam = ((com.tencent.mm.plugin.messenger.foundation.a.l)g.ab(com.tencent.mm.plugin.messenger.foundation.a.l.class)).azp().Bf(paramString);
      if ((localam != null) && (!bt.isNullOrNil(localam.field_username))) {
        break;
      }
      AppMethodBeat.o(42864);
      return;
    }
    localam.setType(localam.field_type & 0xFFFFF7FF);
    if (((am.aSQ(paramString)) || (zl(paramString))) && (hFb != null)) {
      hFb.AW(paramString);
    }
    z(localam);
    if (paramBoolean) {
      ((com.tencent.mm.plugin.messenger.foundation.a.l)g.ab(com.tencent.mm.plugin.messenger.foundation.a.l.class)).azv().aTG(paramString);
    }
    AppMethodBeat.o(42864);
  }
  
  public static void a(al paramal)
  {
    hFb = paramal;
  }
  
  public static boolean a(at paramat)
  {
    AppMethodBeat.i(42926);
    String str = paramat.field_username;
    if (Ap(str))
    {
      AppMethodBeat.o(42926);
      return false;
    }
    if (Al(str))
    {
      AppMethodBeat.o(42926);
      return false;
    }
    if (Ad(str))
    {
      AppMethodBeat.o(42926);
      return false;
    }
    if (Ae(str))
    {
      AppMethodBeat.o(42926);
      return false;
    }
    if (paramat.field_conversationTime == -1L)
    {
      AppMethodBeat.o(42926);
      return false;
    }
    if (zE(str))
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
    int[] arrayOfInt = ((com.tencent.mm.plugin.messenger.foundation.a.l)g.ab(com.tencent.mm.plugin.messenger.foundation.a.l.class)).azp().b(paramString1, paramString2, paramArrayOfString, paramList);
    if (arrayOfInt.length <= 0)
    {
      AppMethodBeat.o(42878);
      return null;
    }
    paramString1 = ((com.tencent.mm.plugin.messenger.foundation.a.l)g.ab(com.tencent.mm.plugin.messenger.foundation.a.l.class)).azp().c(paramString1, paramString2, paramArrayOfString, paramList);
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
    AppMethodBeat.i(192532);
    long l = System.currentTimeMillis();
    int[] arrayOfInt = ((com.tencent.mm.plugin.messenger.foundation.a.l)g.ab(com.tencent.mm.plugin.messenger.foundation.a.l.class)).azp().b(paramArrayOfString, paramString1, paramString2, paramString3, paramList);
    ad.d("MicroMsg.ContactStorageLogic", "kevin service(IMessengerStorage.class).getContactStg().getShowHeadDistinct(" + (System.currentTimeMillis() - l));
    if (arrayOfInt.length <= 0)
    {
      AppMethodBeat.o(192532);
      return null;
    }
    l = System.currentTimeMillis();
    paramArrayOfString = ((com.tencent.mm.plugin.messenger.foundation.a.l)g.ab(com.tencent.mm.plugin.messenger.foundation.a.l.class)).azp().c(paramArrayOfString, paramString1, paramString2, paramString3, paramList);
    ad.d("MicroMsg.ContactStorageLogic", "kevin service(IMessengerStorage.class).getContactStg().getSectionNumByShowHead" + (System.currentTimeMillis() - l));
    if (paramArrayOfString == null)
    {
      AppMethodBeat.o(192532);
      return null;
    }
    if (arrayOfInt.length != paramArrayOfString.length)
    {
      ad.e("MicroMsg.ContactStorageLogic", "[%s:%s] filterType:%s filterSearchStr:%s blocklist:%s searchString:%s", new Object[] { Integer.valueOf(arrayOfInt.length), Integer.valueOf(paramArrayOfString.length), paramString1, paramString2, paramList, paramString3 });
      AppMethodBeat.o(192532);
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
    AppMethodBeat.o(192532);
    return paramString1;
  }
  
  public static String[] a(String paramString1, String paramString2, String[] paramArrayOfString, List<String> paramList)
  {
    AppMethodBeat.i(42879);
    long l = System.currentTimeMillis();
    paramString1 = ((com.tencent.mm.plugin.messenger.foundation.a.l)g.ab(com.tencent.mm.plugin.messenger.foundation.a.l.class)).azp().b(paramString1, paramString2, paramArrayOfString, paramList);
    ad.d("MicroMsg.ContactStorageLogic", "kevin service(IMessengerStorage.class).getContactStg().getShowSectionByShowHead" + (System.currentTimeMillis() - l));
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
    AppMethodBeat.i(192533);
    long l = System.currentTimeMillis();
    paramArrayOfString = ((com.tencent.mm.plugin.messenger.foundation.a.l)g.ab(com.tencent.mm.plugin.messenger.foundation.a.l.class)).azp().b(paramArrayOfString, paramString1, paramString2, paramString3, paramList);
    ad.d("MicroMsg.ContactStorageLogic", "kevin service(IMessengerStorage.class).getContactStg().getShowSectionByShowHead" + (System.currentTimeMillis() - l));
    if (paramArrayOfString.length <= 0)
    {
      AppMethodBeat.o(192533);
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
    AppMethodBeat.o(192533);
    return paramString1;
  }
  
  public static List<String> aBh()
  {
    AppMethodBeat.i(42846);
    List localList = ((com.tencent.mm.plugin.messenger.foundation.a.l)g.ab(com.tencent.mm.plugin.messenger.foundation.a.l.class)).azp().fqt();
    AppMethodBeat.o(42846);
    return localList;
  }
  
  public static List<am> aBi()
  {
    AppMethodBeat.i(42847);
    ArrayList localArrayList = new ArrayList();
    Cursor localCursor = ((com.tencent.mm.plugin.messenger.foundation.a.l)g.ab(com.tencent.mm.plugin.messenger.foundation.a.l.class)).azp().fqu();
    if (localCursor.moveToFirst()) {
      do
      {
        am localam = new am();
        localam.convertFrom(localCursor);
        localArrayList.add(localam);
      } while (localCursor.moveToNext());
    }
    localCursor.close();
    AppMethodBeat.o(42847);
    return localArrayList;
  }
  
  public static boolean aBj()
  {
    return false;
  }
  
  public static boolean aBk()
  {
    AppMethodBeat.i(42922);
    if (!u.aAZ())
    {
      AppMethodBeat.o(42922);
      return false;
    }
    ca localca = ((com.tencent.mm.plugin.messenger.foundation.a.l)g.ab(com.tencent.mm.plugin.messenger.foundation.a.l.class)).azy().aqy("@t.qq.com");
    if ((localca == null) || (bt.isNullOrNil(localca.name)))
    {
      AppMethodBeat.o(42922);
      return false;
    }
    AppMethodBeat.o(42922);
    return true;
  }
  
  public static boolean aBl()
  {
    AppMethodBeat.i(42923);
    if (!u.aAZ())
    {
      AppMethodBeat.o(42923);
      return false;
    }
    ca localca = ((com.tencent.mm.plugin.messenger.foundation.a.l)g.ab(com.tencent.mm.plugin.messenger.foundation.a.l.class)).azy().aqy("@t.qq.com");
    if ((localca == null) || (bt.nullAsNil(localca.name).length() == 0))
    {
      AppMethodBeat.o(42923);
      return false;
    }
    AppMethodBeat.o(42923);
    return true;
  }
  
  public static List<am> aBm()
  {
    AppMethodBeat.i(42924);
    LinkedList localLinkedList = new LinkedList();
    Cursor localCursor = ((com.tencent.mm.plugin.messenger.foundation.a.l)g.ab(com.tencent.mm.plugin.messenger.foundation.a.l.class)).azp().fqx();
    if (localCursor.getCount() == 0)
    {
      localCursor.close();
      AppMethodBeat.o(42924);
      return localLinkedList;
    }
    localCursor.moveToFirst();
    do
    {
      am localam = new am();
      localam.convertFrom(localCursor);
      localLinkedList.add(localam);
    } while (localCursor.moveToNext());
    localCursor.close();
    ad.d("MicroMsg.ContactStorageLogic", "getFavourList size:  " + localLinkedList.size());
    AppMethodBeat.o(42924);
    return localLinkedList;
  }
  
  public static List<String> aBn()
  {
    AppMethodBeat.i(42925);
    LinkedList localLinkedList = new LinkedList();
    Cursor localCursor = ((com.tencent.mm.plugin.messenger.foundation.a.l)g.ab(com.tencent.mm.plugin.messenger.foundation.a.l.class)).azp().fqv();
    if (localCursor.getCount() == 0)
    {
      localCursor.close();
      AppMethodBeat.o(42925);
      return localLinkedList;
    }
    localCursor.moveToFirst();
    do
    {
      am localam = new am();
      localam.convertFrom(localCursor);
      localLinkedList.add(localam.field_username);
    } while (localCursor.moveToNext());
    localCursor.close();
    ad.d("MicroMsg.ContactStorageLogic", "getSnsBlackContactList size:  " + localLinkedList.size());
    AppMethodBeat.o(42925);
    return localLinkedList;
  }
  
  public static int aBo()
  {
    AppMethodBeat.i(42928);
    int i = ((com.tencent.mm.plugin.messenger.foundation.a.l)g.ab(com.tencent.mm.plugin.messenger.foundation.a.l.class)).azp().c(hFm, new String[] { u.aAm(), "weixin", "helper_entry", "filehelper" });
    AppMethodBeat.o(42928);
    return i;
  }
  
  public static int[] ag(List<String> paramList)
  {
    AppMethodBeat.i(42877);
    long l = System.currentTimeMillis();
    int[] arrayOfInt1 = ((com.tencent.mm.plugin.messenger.foundation.a.l)g.ab(com.tencent.mm.plugin.messenger.foundation.a.l.class)).azp().hH(paramList);
    ad.d("MicroMsg.ContactStorageLogic", "kevin service(IMessengerStorage.class).getContactStg().getShowHeadDistinct(" + (System.currentTimeMillis() - l));
    if (arrayOfInt1.length <= 0)
    {
      AppMethodBeat.o(42877);
      return null;
    }
    l = System.currentTimeMillis();
    paramList = ((com.tencent.mm.plugin.messenger.foundation.a.l)g.ab(com.tencent.mm.plugin.messenger.foundation.a.l.class)).azp().hI(paramList);
    ad.d("MicroMsg.ContactStorageLogic", "kevin service(IMessengerStorage.class).getContactStg().getSectionNumByShowHead" + (System.currentTimeMillis() - l));
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
    paramList = ((com.tencent.mm.plugin.messenger.foundation.a.l)g.ab(com.tencent.mm.plugin.messenger.foundation.a.l.class)).azp().hH(paramList);
    ad.d("MicroMsg.ContactStorageLogic", "kevin service(IMessengerStorage.class).getContactStg().getShowSectionByShowHead" + (System.currentTimeMillis() - l));
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
  
  public static boolean b(at paramat)
  {
    AppMethodBeat.i(42927);
    paramat = paramat.field_username;
    if (Ad(paramat))
    {
      AppMethodBeat.o(42927);
      return false;
    }
    if (Am(paramat))
    {
      AppMethodBeat.o(42927);
      return false;
    }
    if (An(paramat))
    {
      AppMethodBeat.o(42927);
      return false;
    }
    AppMethodBeat.o(42927);
    return true;
  }
  
  public static void c(am paramam, String paramString)
  {
    AppMethodBeat.i(42869);
    am localam = ((com.tencent.mm.plugin.messenger.foundation.a.l)g.ab(com.tencent.mm.plugin.messenger.foundation.a.l.class)).azp().Bf(paramam.field_username);
    if ((localam != null) && (paramString != null)) {}
    for (boolean bool = true;; bool = false)
    {
      Assert.assertTrue(bool);
      localam.sR(paramString);
      if ((am.aSQ(paramam.field_username)) && (hFb != null)) {
        hFb.aL(paramam.field_username, paramString);
      }
      z(localam);
      AppMethodBeat.o(42869);
      return;
    }
  }
  
  public static boolean i(am paramam)
  {
    AppMethodBeat.i(42840);
    if (paramam == null)
    {
      AppMethodBeat.o(42840);
      return false;
    }
    if (!zj(paramam.field_username))
    {
      AppMethodBeat.o(42840);
      return false;
    }
    if (!b.lM(paramam.field_type))
    {
      AppMethodBeat.o(42840);
      return false;
    }
    AppMethodBeat.o(42840);
    return true;
  }
  
  public static void j(am paramam)
  {
    AppMethodBeat.i(42852);
    boolean bool;
    am localam2;
    if (paramam != null)
    {
      bool = true;
      Assert.assertTrue(bool);
      localam2 = ((com.tencent.mm.plugin.messenger.foundation.a.l)g.ab(com.tencent.mm.plugin.messenger.foundation.a.l.class)).azp().Bf(paramam.field_username);
      localam1 = paramam;
      if (localam2 != null) {
        if (!bt.isNullOrNil(localam2.field_username)) {
          break label78;
        }
      }
    }
    label78:
    for (am localam1 = paramam;; localam1 = localam2)
    {
      localam1.acN();
      z(localam1);
      AppMethodBeat.o(42852);
      return;
      bool = false;
      break;
    }
  }
  
  public static void k(am paramam)
  {
    AppMethodBeat.i(42854);
    boolean bool;
    am localam2;
    if (paramam != null)
    {
      bool = true;
      Assert.assertTrue(bool);
      localam2 = ((com.tencent.mm.plugin.messenger.foundation.a.l)g.ab(com.tencent.mm.plugin.messenger.foundation.a.l.class)).azp().Bf(paramam.field_username);
      localam1 = paramam;
      if (localam2 != null) {
        if (!bt.isNullOrNil(localam2.field_username)) {
          break label78;
        }
      }
    }
    label78:
    for (am localam1 = paramam;; localam1 = localam2)
    {
      localam1.acL();
      z(localam1);
      AppMethodBeat.o(42854);
      return;
      bool = false;
      break;
    }
  }
  
  public static void l(am paramam)
  {
    AppMethodBeat.i(42855);
    boolean bool;
    am localam2;
    if (paramam != null)
    {
      bool = true;
      Assert.assertTrue(bool);
      localam2 = ((com.tencent.mm.plugin.messenger.foundation.a.l)g.ab(com.tencent.mm.plugin.messenger.foundation.a.l.class)).azp().Bf(paramam.field_username);
      localam1 = paramam;
      if (localam2 != null) {
        if (!bt.isNullOrNil(localam2.field_username)) {
          break label78;
        }
      }
    }
    label78:
    for (am localam1 = paramam;; localam1 = localam2)
    {
      localam1.acM();
      z(localam1);
      AppMethodBeat.o(42855);
      return;
      bool = false;
      break;
    }
  }
  
  public static void m(am paramam)
  {
    AppMethodBeat.i(42856);
    if (paramam != null) {}
    for (boolean bool = true;; bool = false)
    {
      Assert.assertTrue(bool);
      am localam2 = ((com.tencent.mm.plugin.messenger.foundation.a.l)g.ab(com.tencent.mm.plugin.messenger.foundation.a.l.class)).azp().Bf(paramam.field_username);
      am localam1;
      if (localam2 != null)
      {
        localam1 = localam2;
        if (!bt.isNullOrNil(localam2.field_username)) {}
      }
      else
      {
        localam1 = paramam;
      }
      localam1.acJ();
      if ((am.aSQ(paramam.field_username)) && (hFb != null)) {
        hFb.AX(paramam.field_username);
      }
      z(localam1);
      AppMethodBeat.o(42856);
      return;
    }
  }
  
  public static void n(am paramam)
  {
    AppMethodBeat.i(42857);
    if (paramam != null) {}
    for (boolean bool = true;; bool = false)
    {
      Assert.assertTrue(bool);
      am localam2 = ((com.tencent.mm.plugin.messenger.foundation.a.l)g.ab(com.tencent.mm.plugin.messenger.foundation.a.l.class)).azp().Bf(paramam.field_username);
      am localam1;
      if (localam2 != null)
      {
        localam1 = localam2;
        if (!bt.isNullOrNil(localam2.field_username)) {}
      }
      else
      {
        localam1 = paramam;
      }
      localam1.acK();
      if ((am.aSQ(paramam.field_username)) && (hFb != null)) {
        hFb.AY(paramam.field_username);
      }
      z(localam1);
      paramam = ((com.tencent.mm.plugin.messenger.foundation.a.l)g.ab(com.tencent.mm.plugin.messenger.foundation.a.l.class)).azv().aTz(paramam.field_username);
      if ((paramam != null) && ("@blacklist".equals(paramam.field_parentRef))) {
        ((com.tencent.mm.plugin.messenger.foundation.a.l)g.ab(com.tencent.mm.plugin.messenger.foundation.a.l.class)).azv().c(new String[] { paramam.field_username }, "");
      }
      AppMethodBeat.o(42857);
      return;
    }
  }
  
  public static void o(am paramam)
  {
    AppMethodBeat.i(42858);
    if (paramam != null) {}
    for (boolean bool = true;; bool = false)
    {
      Assert.assertTrue(bool);
      am localam2 = ((com.tencent.mm.plugin.messenger.foundation.a.l)g.ab(com.tencent.mm.plugin.messenger.foundation.a.l.class)).azp().Bf(paramam.field_username);
      am localam1;
      if (localam2 != null)
      {
        localam1 = localam2;
        if (!bt.isNullOrNil(localam2.field_username)) {}
      }
      else
      {
        localam1 = paramam;
      }
      localam1.acW();
      localam1.jZ(paramam.acE());
      x(localam1);
      AppMethodBeat.o(42858);
      return;
    }
  }
  
  public static boolean on(int paramInt)
  {
    AppMethodBeat.i(42851);
    boolean bool = am.aaR(paramInt);
    AppMethodBeat.o(42851);
    return bool;
  }
  
  public static void p(am paramam)
  {
    AppMethodBeat.i(42859);
    if (paramam != null) {}
    for (boolean bool = true;; bool = false)
    {
      Assert.assertTrue(bool);
      am localam2 = ((com.tencent.mm.plugin.messenger.foundation.a.l)g.ab(com.tencent.mm.plugin.messenger.foundation.a.l.class)).azp().Bf(paramam.field_username);
      am localam1;
      if (localam2 != null)
      {
        localam1 = localam2;
        if (!bt.isNullOrNil(localam2.field_username)) {}
      }
      else
      {
        localam1 = paramam;
      }
      localam1.acX();
      localam1.jZ(paramam.acE());
      x(localam1);
      AppMethodBeat.o(42859);
      return;
    }
  }
  
  public static void q(am paramam)
  {
    AppMethodBeat.i(42860);
    if (paramam != null) {}
    for (boolean bool = true;; bool = false)
    {
      Assert.assertTrue(bool);
      am localam2 = ((com.tencent.mm.plugin.messenger.foundation.a.l)g.ab(com.tencent.mm.plugin.messenger.foundation.a.l.class)).azp().Bf(paramam.field_username);
      am localam1;
      if (localam2 != null)
      {
        localam1 = localam2;
        if (!bt.isNullOrNil(localam2.field_username)) {}
      }
      else
      {
        localam1 = paramam;
      }
      localam1.acS();
      localam1.jZ(paramam.acE());
      if ((am.aSQ(paramam.field_username)) && (hFb != null)) {
        hFb.AZ(paramam.field_username);
      }
      z(localam1);
      AppMethodBeat.o(42860);
      return;
    }
  }
  
  public static void r(am paramam)
  {
    AppMethodBeat.i(42861);
    if (paramam != null) {}
    for (boolean bool = true;; bool = false)
    {
      Assert.assertTrue(bool);
      am localam2 = ((com.tencent.mm.plugin.messenger.foundation.a.l)g.ab(com.tencent.mm.plugin.messenger.foundation.a.l.class)).azp().Bf(paramam.field_username);
      am localam1;
      if (localam2 != null)
      {
        localam1 = localam2;
        if (!bt.isNullOrNil(localam2.field_username)) {}
      }
      else
      {
        localam1 = paramam;
      }
      localam1.acT();
      localam1.jZ(paramam.acE());
      if ((am.aSQ(paramam.field_username)) && (hFb != null)) {
        hFb.Ba(paramam.field_username);
      }
      z(localam1);
      AppMethodBeat.o(42861);
      return;
    }
  }
  
  public static void s(am paramam)
  {
    AppMethodBeat.i(42865);
    if (paramam != null) {}
    for (boolean bool = true;; bool = false)
    {
      Assert.assertTrue(bool);
      am localam2 = ((com.tencent.mm.plugin.messenger.foundation.a.l)g.ab(com.tencent.mm.plugin.messenger.foundation.a.l.class)).azp().Bf(paramam.field_username);
      am localam1;
      if (localam2 != null)
      {
        localam1 = localam2;
        if (!bt.isNullOrNil(localam2.field_username)) {}
      }
      else
      {
        localam1 = paramam;
      }
      localam1.acU();
      if ((am.aSQ(paramam.field_username)) && (hFb != null)) {
        hFb.Bb(paramam.field_username);
      }
      z(localam1);
      AppMethodBeat.o(42865);
      return;
    }
  }
  
  public static void t(am paramam)
  {
    AppMethodBeat.i(42866);
    if (paramam != null) {}
    for (boolean bool = true;; bool = false)
    {
      Assert.assertTrue(bool);
      am localam2 = ((com.tencent.mm.plugin.messenger.foundation.a.l)g.ab(com.tencent.mm.plugin.messenger.foundation.a.l.class)).azp().Bf(paramam.field_username);
      am localam1;
      if (localam2 != null)
      {
        localam1 = localam2;
        if (!bt.isNullOrNil(localam2.field_username)) {}
      }
      else
      {
        localam1 = paramam;
      }
      localam1.acV();
      if ((am.aSQ(paramam.field_username)) && (hFb != null)) {
        hFb.Bc(paramam.field_username);
      }
      z(localam1);
      AppMethodBeat.o(42866);
      return;
    }
  }
  
  public static void u(am paramam)
  {
    boolean bool2 = true;
    AppMethodBeat.i(42867);
    if (paramam != null)
    {
      bool1 = true;
      Assert.assertTrue("MicroMsg.ContactStorageLogic: user is null", bool1);
      if ((int)paramam.gfj == 0) {
        break label98;
      }
      bool1 = true;
      label31:
      Assert.assertTrue("MicroMsg.ContactStorageLogic: contactId == 0", bool1);
      if (paramam.field_username.length() <= 0) {
        break label103;
      }
    }
    label98:
    label103:
    for (boolean bool1 = bool2;; bool1 = false)
    {
      Assert.assertTrue("MicroMsg.ContactStorageLogic: username length <= 0", bool1);
      paramam.acH();
      ((com.tencent.mm.plugin.messenger.foundation.a.l)g.ab(com.tencent.mm.plugin.messenger.foundation.a.l.class)).azp().c(paramam.field_username, paramam);
      AppMethodBeat.o(42867);
      return;
      bool1 = false;
      break;
      bool1 = false;
      break label31;
    }
  }
  
  public static void v(am paramam)
  {
    boolean bool2 = true;
    AppMethodBeat.i(42868);
    if (paramam != null)
    {
      bool1 = true;
      Assert.assertTrue(bool1);
      if ((int)paramam.gfj == 0) {
        break label93;
      }
      bool1 = true;
      label28:
      Assert.assertTrue(bool1);
      if (paramam.field_username.length() <= 0) {
        break label98;
      }
    }
    label93:
    label98:
    for (boolean bool1 = bool2;; bool1 = false)
    {
      Assert.assertTrue(bool1);
      paramam.acH();
      ((com.tencent.mm.plugin.messenger.foundation.a.l)g.ab(com.tencent.mm.plugin.messenger.foundation.a.l.class)).azp().c(paramam.field_username, paramam);
      z(paramam);
      AppMethodBeat.o(42868);
      return;
      bool1 = false;
      break;
      bool1 = false;
      break label28;
    }
  }
  
  public static boolean vF(String paramString)
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
  
  public static void w(am paramam)
  {
    boolean bool2 = true;
    AppMethodBeat.i(42870);
    if (paramam != null)
    {
      bool1 = true;
      Assert.assertTrue(bool1);
      if ((int)paramam.gfj == 0) {
        break label68;
      }
      bool1 = true;
      label28:
      Assert.assertTrue(bool1);
      if (paramam.field_username.length() <= 0) {
        break label73;
      }
    }
    label68:
    label73:
    for (boolean bool1 = bool2;; bool1 = false)
    {
      Assert.assertTrue(bool1);
      paramam.ads();
      z(paramam);
      AppMethodBeat.o(42870);
      return;
      bool1 = false;
      break;
      bool1 = false;
      break label28;
    }
  }
  
  private static void x(am paramam)
  {
    AppMethodBeat.i(42871);
    boolean bool;
    cak localcak;
    if (paramam != null)
    {
      bool = true;
      Assert.assertTrue(bool);
      if ((int)paramam.gfj == 0)
      {
        ((com.tencent.mm.plugin.messenger.foundation.a.l)g.ab(com.tencent.mm.plugin.messenger.foundation.a.l.class)).azp().ah(paramam);
        ((com.tencent.mm.plugin.messenger.foundation.a.l)g.ab(com.tencent.mm.plugin.messenger.foundation.a.l.class)).azp().Bf(paramam.field_username);
      }
      ((com.tencent.mm.plugin.messenger.foundation.a.l)g.ab(com.tencent.mm.plugin.messenger.foundation.a.l.class)).azp().c(paramam.field_username, paramam);
      localcak = new cak();
      localcak.GUK = paramam.field_username;
      if (!paramam.adn()) {
        break label163;
      }
    }
    label163:
    for (localcak.GUG = 1;; localcak.GUG = 2)
    {
      ((com.tencent.mm.plugin.messenger.foundation.a.l)g.ab(com.tencent.mm.plugin.messenger.foundation.a.l.class)).azo().c(new k.a(52, localcak));
      AppMethodBeat.o(42871);
      return;
      bool = false;
      break;
    }
  }
  
  public static void y(am paramam)
  {
    AppMethodBeat.i(42872);
    boolean bool;
    cal localcal;
    if (paramam != null)
    {
      bool = true;
      Assert.assertTrue(bool);
      if ((int)paramam.gfj == 0)
      {
        ((com.tencent.mm.plugin.messenger.foundation.a.l)g.ab(com.tencent.mm.plugin.messenger.foundation.a.l.class)).azp().ah(paramam);
        ((com.tencent.mm.plugin.messenger.foundation.a.l)g.ab(com.tencent.mm.plugin.messenger.foundation.a.l.class)).azp().Bf(paramam.field_username);
      }
      ((com.tencent.mm.plugin.messenger.foundation.a.l)g.ab(com.tencent.mm.plugin.messenger.foundation.a.l.class)).azp().c(paramam.field_username, paramam);
      localcal = new cal();
      localcal.GUK = paramam.field_username;
      if (!paramam.adp()) {
        break label163;
      }
    }
    label163:
    for (localcal.GUG = 1;; localcal.GUG = 2)
    {
      ((com.tencent.mm.plugin.messenger.foundation.a.l)g.ab(com.tencent.mm.plugin.messenger.foundation.a.l.class)).azo().c(new k.a(72, localcal));
      AppMethodBeat.o(42872);
      return;
      bool = false;
      break;
    }
  }
  
  public static void z(am paramam)
  {
    AppMethodBeat.i(42873);
    if (paramam != null) {}
    for (boolean bool = true;; bool = false)
    {
      Assert.assertTrue(bool);
      if ((int)paramam.gfj == 0)
      {
        ((com.tencent.mm.plugin.messenger.foundation.a.l)g.ab(com.tencent.mm.plugin.messenger.foundation.a.l.class)).azp().ah(paramam);
        ((com.tencent.mm.plugin.messenger.foundation.a.l)g.ab(com.tencent.mm.plugin.messenger.foundation.a.l.class)).azp().Bf(paramam.field_username);
      }
      ((com.tencent.mm.plugin.messenger.foundation.a.l)g.ab(com.tencent.mm.plugin.messenger.foundation.a.l.class)).azp().c(paramam.field_username, paramam);
      if (!am.aSQ(paramam.field_username)) {
        B(paramam);
      }
      AppMethodBeat.o(42873);
      return;
    }
  }
  
  public static boolean zA(String paramString)
  {
    AppMethodBeat.i(42843);
    boolean bool = "downloaderapp".equals(paramString);
    AppMethodBeat.o(42843);
    return bool;
  }
  
  public static boolean zB(String paramString)
  {
    AppMethodBeat.i(42844);
    if ((paramString == null) || (paramString.length() <= 0))
    {
      AppMethodBeat.o(42844);
      return false;
    }
    if (!zj(paramString))
    {
      AppMethodBeat.o(42844);
      return false;
    }
    paramString = ((com.tencent.mm.plugin.messenger.foundation.a.l)g.ab(com.tencent.mm.plugin.messenger.foundation.a.l.class)).azp().Bf(paramString);
    if ((paramString == null) || (!b.lM(paramString.field_type)))
    {
      AppMethodBeat.o(42844);
      return false;
    }
    AppMethodBeat.o(42844);
    return true;
  }
  
  public static boolean zC(String paramString)
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
  
  public static boolean zD(String paramString)
  {
    AppMethodBeat.i(42849);
    if ((paramString == null) || (paramString.length() <= 0))
    {
      AppMethodBeat.o(42849);
      return true;
    }
    boolean bool = b.lM(((com.tencent.mm.plugin.messenger.foundation.a.l)g.ab(com.tencent.mm.plugin.messenger.foundation.a.l.class)).azp().Bf(paramString).field_type);
    AppMethodBeat.o(42849);
    return bool;
  }
  
  public static boolean zE(String paramString)
  {
    AppMethodBeat.i(42850);
    if (bt.isNullOrNil(paramString))
    {
      AppMethodBeat.o(42850);
      return false;
    }
    paramString = ((com.tencent.mm.plugin.messenger.foundation.a.l)g.ab(com.tencent.mm.plugin.messenger.foundation.a.l.class)).azp().Bf(paramString);
    if (paramString == null)
    {
      AppMethodBeat.o(42850);
      return false;
    }
    boolean bool = am.aaR(paramString.field_verifyFlag);
    AppMethodBeat.o(42850);
    return bool;
  }
  
  public static void zF(String paramString)
  {
    AppMethodBeat.i(42863);
    at localat2 = ((com.tencent.mm.plugin.messenger.foundation.a.l)g.ab(com.tencent.mm.plugin.messenger.foundation.a.l.class)).azv().aTz(paramString);
    int i = 0;
    at localat1 = localat2;
    if (localat2 == null)
    {
      localat1 = new at();
      localat1.fqK();
      i = 1;
      localat1.setUsername(paramString);
    }
    localat1.qu(System.currentTimeMillis());
    if (i != 0)
    {
      ((com.tencent.mm.plugin.messenger.foundation.a.l)g.ab(com.tencent.mm.plugin.messenger.foundation.a.l.class)).azv().e(localat1);
      AppMethodBeat.o(42863);
      return;
    }
    ((com.tencent.mm.plugin.messenger.foundation.a.l)g.ab(com.tencent.mm.plugin.messenger.foundation.a.l.class)).azv().a(localat1, paramString);
    AppMethodBeat.o(42863);
  }
  
  public static void zG(String paramString)
  {
    AppMethodBeat.i(42875);
    if (bt.isNullOrNil(paramString))
    {
      AppMethodBeat.o(42875);
      return;
    }
    am localam = ((com.tencent.mm.plugin.messenger.foundation.a.l)g.ab(com.tencent.mm.plugin.messenger.foundation.a.l.class)).azp().Bf(paramString);
    if (localam == null)
    {
      AppMethodBeat.o(42875);
      return;
    }
    localam.setSource(0);
    localam.acF();
    ((com.tencent.mm.plugin.messenger.foundation.a.l)g.ab(com.tencent.mm.plugin.messenger.foundation.a.l.class)).azp().c(paramString, localam);
    AppMethodBeat.o(42875);
  }
  
  public static boolean zH(String paramString)
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
  
  public static boolean zI(String paramString)
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
  
  public static boolean zJ(String paramString)
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
  
  public static boolean zK(String paramString)
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
  
  public static boolean zL(String paramString)
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
  
  public static boolean zM(String paramString)
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
  
  public static boolean zN(String paramString)
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
  
  public static boolean zO(String paramString)
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
  
  public static boolean zP(String paramString)
  {
    AppMethodBeat.i(42890);
    boolean bool = "qqsync".equalsIgnoreCase(paramString);
    AppMethodBeat.o(42890);
    return bool;
  }
  
  public static boolean zQ(String paramString)
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
  
  public static boolean zR(String paramString)
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
  
  public static boolean zS(String paramString)
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
  
  public static boolean zT(String paramString)
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
  
  public static boolean zU(String paramString)
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
  
  public static boolean zV(String paramString)
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
  
  public static boolean zW(String paramString)
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
  
  public static boolean zX(String paramString)
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
  
  public static boolean zY(String paramString)
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
  
  public static boolean zZ(String paramString)
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
  
  public static boolean zi(String paramString)
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
  
  public static boolean zj(String paramString)
  {
    AppMethodBeat.i(42832);
    if ((zk(paramString)) || (zl(paramString)))
    {
      AppMethodBeat.o(42832);
      return true;
    }
    AppMethodBeat.o(42832);
    return false;
  }
  
  public static boolean zk(String paramString)
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
  
  public static boolean zl(String paramString)
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
  
  public static boolean zm(String paramString)
  {
    AppMethodBeat.i(178864);
    if ((paramString == null) || (paramString.length() <= 0))
    {
      AppMethodBeat.o(178864);
      return false;
    }
    if ((paramString.endsWith("@im.chatroom")) || (zn(paramString)))
    {
      AppMethodBeat.o(178864);
      return true;
    }
    AppMethodBeat.o(178864);
    return false;
  }
  
  public static boolean zn(String paramString)
  {
    AppMethodBeat.i(178865);
    Boolean localBoolean;
    Object localObject;
    if (zk(paramString))
    {
      localBoolean = null;
      if (hFc.containsKey(paramString)) {
        localBoolean = (Boolean)hFc.get(paramString);
      }
      localObject = localBoolean;
      if (localBoolean == null)
      {
        localBoolean = Boolean.FALSE;
        localObject = ((c)g.ab(c.class)).azz().AN(paramString);
        if ((localObject == null) || ((((ab)localObject).field_chatroomStatus & 0x20000) != 131072)) {
          break label121;
        }
        localBoolean = Boolean.TRUE;
      }
    }
    label121:
    for (;;)
    {
      hFc.put(paramString, localBoolean);
      localObject = localBoolean;
      boolean bool = ((Boolean)localObject).booleanValue();
      AppMethodBeat.o(178865);
      return bool;
      AppMethodBeat.o(178865);
      return false;
    }
  }
  
  public static void zo(String paramString)
  {
    AppMethodBeat.i(192528);
    hFc.remove(paramString);
    AppMethodBeat.o(192528);
  }
  
  public static boolean zp(String paramString)
  {
    AppMethodBeat.i(178866);
    if (zk(paramString))
    {
      paramString = ((c)g.ab(c.class)).azz().AN(paramString);
      if ((paramString != null) && ((paramString.field_chatroomStatus & 0x20000) != 131072) && ((paramString.field_chatroomStatus & 0x10000) == 65536))
      {
        AppMethodBeat.o(178866);
        return true;
      }
    }
    AppMethodBeat.o(178866);
    return false;
  }
  
  public static boolean zq(String paramString)
  {
    AppMethodBeat.i(178867);
    if ((((s)g.ab(s.class)).Yd()) && (zk(paramString)))
    {
      paramString = ((c)g.ab(c.class)).azz().AN(paramString);
      if ((paramString != null) && (paramString.YH()))
      {
        AppMethodBeat.o(178867);
        return true;
      }
    }
    AppMethodBeat.o(178867);
    return false;
  }
  
  public static boolean zr(String paramString)
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
  
  public static boolean zs(String paramString)
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
  
  public static boolean zt(String paramString)
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
  
  public static boolean zu(String paramString)
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
  
  public static boolean zv(String paramString)
  {
    AppMethodBeat.i(42841);
    boolean bool = "gh_43f2581f6fd6".equals(paramString);
    AppMethodBeat.o(42841);
    return bool;
  }
  
  public static boolean zw(String paramString)
  {
    AppMethodBeat.i(42842);
    boolean bool = "gh_3dfda90e39d6".equals(paramString);
    AppMethodBeat.o(42842);
    return bool;
  }
  
  public static boolean zx(String paramString)
  {
    AppMethodBeat.i(192529);
    boolean bool = "gh_f0a92aa7146c".equals(paramString);
    AppMethodBeat.o(192529);
    return bool;
  }
  
  public static boolean zy(String paramString)
  {
    AppMethodBeat.i(163508);
    boolean bool = "1@fackuser".equals(paramString);
    AppMethodBeat.o(163508);
    return bool;
  }
  
  public static boolean zz(String paramString)
  {
    AppMethodBeat.i(192530);
    boolean bool = "msginfo@fakeuser".equals(paramString);
    AppMethodBeat.o(192530);
    return bool;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.model.w
 * JD-Core Version:    0.7.0.1
 */