package com.tencent.mm.model;

import android.database.Cursor;
import com.tencent.mm.h.c.ao;
import com.tencent.mm.h.c.as;
import com.tencent.mm.kernel.e;
import com.tencent.mm.kernel.g;
import com.tencent.mm.n.a;
import com.tencent.mm.plugin.chatroom.a.c;
import com.tencent.mm.plugin.messenger.foundation.a.a.h;
import com.tencent.mm.plugin.messenger.foundation.a.a.i.a;
import com.tencent.mm.protocal.c.axd;
import com.tencent.mm.protocal.c.axs;
import com.tencent.mm.protocal.c.bmk;
import com.tencent.mm.protocal.c.bml;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.sdk.platformtools.y;
import com.tencent.mm.storage.ad;
import com.tencent.mm.storage.ak;
import com.tencent.mm.storage.bd;
import com.tencent.mm.storage.be;
import com.tencent.mm.storage.bq;
import com.tencent.mm.storage.z;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import junit.framework.Assert;

public final class s
{
  private static ag dUS = null;
  public static final String dUT = b("rconversation.username", new String[] { "@im.chatroom", "@chatroom", "@openim", "@micromsg.qq.com" });
  public static final String dUU = b("rconversation.username", new String[] { "@chatroom", "@micromsg.qq.com" });
  public static final String dUV = b("rconversation.username", new String[] { "@t.qq.com" });
  public static final String dUW = b("rconversation.username", new String[] { "@qqim" });
  public static final String dUX = b("rconversation.username", new String[] { "@chatroom_exclusive" });
  public static final String dUY = b("rconversation.username", new String[] { "@micromsg.qq.com" });
  public static final String dUZ = b("rconversation.username", new String[] { "@app" });
  public static final String dVa = b("rconversation.username", new String[] { "@chatroom" });
  public static final String dVb = b("rconversation.username", new String[] { "@im.chatroom" });
  public static final String[] dVc = { "qqmail", "fmessage", "tmessage", "qmessage", "qqsync", "floatbottle", "lbsapp", "shakeapp", "medianote", "qqfriend", "newsapp", "blogapp", "facebookapp", "topstoryapp", "masssendapp", "feedsapp", "voipapp", "cardpackage", "voicevoipapp", "voiceinputapp", "officialaccounts", "linkedinplugin", "notifymessage", "appbrandcustomerservicemsg" };
  
  public static List<String> GU()
  {
    return ((com.tencent.mm.plugin.messenger.foundation.a.j)g.r(com.tencent.mm.plugin.messenger.foundation.a.j.class)).Fw().cum();
  }
  
  public static List<ad> GV()
  {
    ArrayList localArrayList = new ArrayList();
    Cursor localCursor = ((com.tencent.mm.plugin.messenger.foundation.a.j)g.r(com.tencent.mm.plugin.messenger.foundation.a.j.class)).Fw().cun();
    if (localCursor.moveToFirst()) {
      do
      {
        ad localad = new ad();
        localad.d(localCursor);
        localArrayList.add(localad);
      } while (localCursor.moveToNext());
    }
    localCursor.close();
    return localArrayList;
  }
  
  public static boolean GW()
  {
    return false;
  }
  
  public static boolean GX()
  {
    if (!q.GR()) {
      return false;
    }
    bq localbq = ((com.tencent.mm.plugin.messenger.foundation.a.j)g.r(com.tencent.mm.plugin.messenger.foundation.a.j.class)).FE().Ic("@t.qq.com");
    return (localbq != null) && (!bk.bl(localbq.name));
  }
  
  public static boolean GY()
  {
    if (!q.GR()) {
      return false;
    }
    bq localbq = ((com.tencent.mm.plugin.messenger.foundation.a.j)g.r(com.tencent.mm.plugin.messenger.foundation.a.j.class)).FE().Ic("@t.qq.com");
    return (localbq != null) && (bk.pm(localbq.name).length() != 0);
  }
  
  public static List<ad> GZ()
  {
    LinkedList localLinkedList = new LinkedList();
    Cursor localCursor = ((com.tencent.mm.plugin.messenger.foundation.a.j)g.r(com.tencent.mm.plugin.messenger.foundation.a.j.class)).Fw().cuq();
    if (localCursor.getCount() == 0)
    {
      localCursor.close();
      return localLinkedList;
    }
    localCursor.moveToFirst();
    do
    {
      ad localad = new ad();
      localad.d(localCursor);
      localLinkedList.add(localad);
    } while (localCursor.moveToNext());
    localCursor.close();
    y.d("MicroMsg.ContactStorageLogic", "getFavourList size:  " + localLinkedList.size());
    return localLinkedList;
  }
  
  public static List<String> Ha()
  {
    LinkedList localLinkedList = new LinkedList();
    Cursor localCursor = ((com.tencent.mm.plugin.messenger.foundation.a.j)g.r(com.tencent.mm.plugin.messenger.foundation.a.j.class)).Fw().cuo();
    if (localCursor.getCount() == 0)
    {
      localCursor.close();
      return localLinkedList;
    }
    localCursor.moveToFirst();
    do
    {
      ad localad = new ad();
      localad.d(localCursor);
      localLinkedList.add(localad.field_username);
    } while (localCursor.moveToNext());
    localCursor.close();
    y.d("MicroMsg.ContactStorageLogic", "getSnsBlackContactList size:  " + localLinkedList.size());
    return localLinkedList;
  }
  
  public static int Hb()
  {
    return ((com.tencent.mm.plugin.messenger.foundation.a.j)g.r(com.tencent.mm.plugin.messenger.foundation.a.j.class)).Fw().b(dVc, new String[] { q.Gj(), "weixin", "helper_entry", "filehelper" });
  }
  
  public static int[] L(List<String> paramList)
  {
    long l = System.currentTimeMillis();
    int[] arrayOfInt1 = ((com.tencent.mm.plugin.messenger.foundation.a.j)g.r(com.tencent.mm.plugin.messenger.foundation.a.j.class)).Fw().dE(paramList);
    y.d("MicroMsg.ContactStorageLogic", "kevin service(IMessengerStorage.class).getContactStg().getShowHeadDistinct(" + (System.currentTimeMillis() - l));
    if (arrayOfInt1.length <= 0) {
      return null;
    }
    l = System.currentTimeMillis();
    paramList = ((com.tencent.mm.plugin.messenger.foundation.a.j)g.r(com.tencent.mm.plugin.messenger.foundation.a.j.class)).Fw().dF(paramList);
    y.d("MicroMsg.ContactStorageLogic", "kevin service(IMessengerStorage.class).getContactStg().getSectionNumByShowHead" + (System.currentTimeMillis() - l));
    if (paramList == null) {
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
    return arrayOfInt2;
  }
  
  public static String[] M(List<String> paramList)
  {
    long l = System.currentTimeMillis();
    paramList = ((com.tencent.mm.plugin.messenger.foundation.a.j)g.r(com.tencent.mm.plugin.messenger.foundation.a.j.class)).Fw().dE(paramList);
    y.d("MicroMsg.ContactStorageLogic", "kevin service(IMessengerStorage.class).getContactStg().getShowSectionByShowHead" + (System.currentTimeMillis() - l));
    if (paramList.length <= 0) {
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
    return arrayOfString;
  }
  
  public static String a(ad paramad, String paramString)
  {
    if (paramad == null) {}
    do
    {
      return paramString;
      if ((gZ(paramString)) && (bk.bl(paramad.field_nickname)))
      {
        String str = ((c)g.r(c.class)).FF().gV(paramString);
        if (!bk.bl(str)) {
          return str;
        }
      }
    } while ((paramad.Bq() == null) || (paramad.Bq().length() <= 0));
    return paramad.Bq();
  }
  
  public static void a(ag paramag)
  {
    dUS = paramag;
  }
  
  public static boolean a(ak paramak)
  {
    String str = paramak.field_username;
    if (hU(str)) {}
    while ((hS(str)) || (hK(str)) || (hL(str)) || (paramak.field_conversationTime == -1L)) {
      return false;
    }
    return hl(str);
  }
  
  public static int[] a(String paramString1, String paramString2, List<String> paramList, String[] paramArrayOfString)
  {
    int[] arrayOfInt = ((com.tencent.mm.plugin.messenger.foundation.a.j)g.r(com.tencent.mm.plugin.messenger.foundation.a.j.class)).Fw().b(paramString1, paramString2, paramArrayOfString, paramList);
    if (arrayOfInt.length <= 0) {
      return null;
    }
    paramString1 = ((com.tencent.mm.plugin.messenger.foundation.a.j)g.r(com.tencent.mm.plugin.messenger.foundation.a.j.class)).Fw().c(paramString1, paramString2, paramArrayOfString, paramList);
    if (paramString1 == null) {
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
    return paramString2;
  }
  
  public static String[] a(String paramString1, String paramString2, String paramString3, List<String> paramList)
  {
    long l = System.currentTimeMillis();
    paramString1 = ((com.tencent.mm.plugin.messenger.foundation.a.j)g.r(com.tencent.mm.plugin.messenger.foundation.a.j.class)).Fw().b(paramString1, paramString2, paramString3, paramList);
    y.d("MicroMsg.ContactStorageLogic", "kevin service(IMessengerStorage.class).getContactStg().getShowSectionByShowHead" + (System.currentTimeMillis() - l));
    if (paramString1.length <= 0) {
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
    return paramString2;
  }
  
  public static String[] a(String paramString1, String paramString2, String[] paramArrayOfString, List<String> paramList)
  {
    long l = System.currentTimeMillis();
    paramString1 = ((com.tencent.mm.plugin.messenger.foundation.a.j)g.r(com.tencent.mm.plugin.messenger.foundation.a.j.class)).Fw().b(paramString1, paramString2, paramArrayOfString, paramList);
    y.d("MicroMsg.ContactStorageLogic", "kevin service(IMessengerStorage.class).getContactStg().getShowSectionByShowHead" + (System.currentTimeMillis() - l));
    if (paramString1.length <= 0) {
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
    return paramString2;
  }
  
  private static String b(String paramString, String[] paramArrayOfString)
  {
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
    return (String)localObject2 + " ) ";
  }
  
  public static void b(ad paramad, String paramString)
  {
    ad localad = ((com.tencent.mm.plugin.messenger.foundation.a.j)g.r(com.tencent.mm.plugin.messenger.foundation.a.j.class)).Fw().abl(paramad.field_username);
    if ((localad != null) && (paramString != null)) {}
    for (boolean bool = true;; bool = false)
    {
      Assert.assertTrue(bool);
      localad.df(paramString);
      if ((ad.aaU(paramad.field_username)) && (dUS != null)) {
        dUS.U(paramad.field_username, paramString);
      }
      u(localad);
      return;
    }
  }
  
  public static boolean b(ak paramak)
  {
    paramak = paramak.field_username;
    if (hK(paramak)) {}
    while (hT(paramak)) {
      return false;
    }
    return true;
  }
  
  public static int[] b(String paramString1, String paramString2, List<String> paramList, String paramString3)
  {
    long l = System.currentTimeMillis();
    int[] arrayOfInt = ((com.tencent.mm.plugin.messenger.foundation.a.j)g.r(com.tencent.mm.plugin.messenger.foundation.a.j.class)).Fw().b(paramString1, paramString2, paramString3, paramList);
    y.d("MicroMsg.ContactStorageLogic", "kevin service(IMessengerStorage.class).getContactStg().getShowHeadDistinct(" + (System.currentTimeMillis() - l));
    if (arrayOfInt.length <= 0) {
      return null;
    }
    l = System.currentTimeMillis();
    paramString1 = ((com.tencent.mm.plugin.messenger.foundation.a.j)g.r(com.tencent.mm.plugin.messenger.foundation.a.j.class)).Fw().c(paramString1, paramString2, paramString3, paramList);
    y.d("MicroMsg.ContactStorageLogic", "kevin service(IMessengerStorage.class).getContactStg().getSectionNumByShowHead" + (System.currentTimeMillis() - l));
    if (paramString1 == null) {
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
    return paramString2;
  }
  
  public static boolean e(ad paramad)
  {
    if (paramad == null) {}
    while ((!gZ(paramad.field_username)) || (!a.gR(paramad.field_type))) {
      return false;
    }
    return true;
  }
  
  public static void f(ad paramad)
  {
    boolean bool;
    ad localad2;
    if (paramad != null)
    {
      bool = true;
      Assert.assertTrue(bool);
      localad2 = ((com.tencent.mm.plugin.messenger.foundation.a.j)g.r(com.tencent.mm.plugin.messenger.foundation.a.j.class)).Fw().abl(paramad.field_username);
      localad1 = paramad;
      if (localad2 != null) {
        if (!bk.bl(localad2.field_username)) {
          break label65;
        }
      }
    }
    label65:
    for (ad localad1 = paramad;; localad1 = localad2)
    {
      localad1.AN();
      u(localad1);
      return;
      bool = false;
      break;
    }
  }
  
  public static boolean fn(String paramString)
  {
    if ((paramString == null) || (paramString.length() <= 0)) {}
    while ((!paramString.endsWith("@chatroom")) && (!paramString.endsWith("@im.chatroom"))) {
      return false;
    }
    return true;
  }
  
  public static void g(ad paramad)
  {
    boolean bool;
    ad localad2;
    if (paramad != null)
    {
      bool = true;
      Assert.assertTrue(bool);
      localad2 = ((com.tencent.mm.plugin.messenger.foundation.a.j)g.r(com.tencent.mm.plugin.messenger.foundation.a.j.class)).Fw().abl(paramad.field_username);
      localad1 = paramad;
      if (localad2 != null) {
        if (!bk.bl(localad2.field_username)) {
          break label65;
        }
      }
    }
    label65:
    for (ad localad1 = paramad;; localad1 = localad2)
    {
      localad1.AL();
      u(localad1);
      return;
      bool = false;
      break;
    }
  }
  
  public static boolean gY(String paramString)
  {
    if ((paramString == null) || (paramString.length() <= 0)) {}
    while ((paramString.contains("@")) && (!paramString.endsWith("@micromsg.qq.com"))) {
      return false;
    }
    return true;
  }
  
  public static boolean gZ(String paramString)
  {
    return (ha(paramString)) || (hb(paramString));
  }
  
  public static void h(ad paramad)
  {
    boolean bool;
    ad localad2;
    if (paramad != null)
    {
      bool = true;
      Assert.assertTrue(bool);
      localad2 = ((com.tencent.mm.plugin.messenger.foundation.a.j)g.r(com.tencent.mm.plugin.messenger.foundation.a.j.class)).Fw().abl(paramad.field_username);
      localad1 = paramad;
      if (localad2 != null) {
        if (!bk.bl(localad2.field_username)) {
          break label65;
        }
      }
    }
    label65:
    for (ad localad1 = paramad;; localad1 = localad2)
    {
      localad1.AM();
      u(localad1);
      return;
      bool = false;
      break;
    }
  }
  
  public static boolean hA(String paramString)
  {
    if (paramString != null) {
      return paramString.equalsIgnoreCase("medianote");
    }
    return false;
  }
  
  public static boolean hB(String paramString)
  {
    if (paramString != null) {
      return paramString.equalsIgnoreCase("newsapp");
    }
    return false;
  }
  
  public static boolean hC(String paramString)
  {
    if (paramString != null) {
      return paramString.equalsIgnoreCase("topstoryapp");
    }
    return false;
  }
  
  public static boolean hD(String paramString)
  {
    if (paramString != null) {
      return paramString.equalsIgnoreCase("voipapp");
    }
    return false;
  }
  
  public static boolean hE(String paramString)
  {
    if (paramString != null) {
      return paramString.equalsIgnoreCase("voicevoipapp");
    }
    return false;
  }
  
  public static boolean hF(String paramString)
  {
    if (paramString != null) {
      return paramString.equalsIgnoreCase("voiceinputapp");
    }
    return false;
  }
  
  public static boolean hG(String paramString)
  {
    if (paramString != null) {
      return paramString.equalsIgnoreCase("linkedinplugin");
    }
    return false;
  }
  
  public static boolean hH(String paramString)
  {
    return hI(paramString);
  }
  
  public static boolean hI(int paramInt)
  {
    return ad.Fn(paramInt);
  }
  
  public static boolean hI(String paramString)
  {
    if (paramString != null) {
      return paramString.equalsIgnoreCase("gh_22b87fa7cb3c");
    }
    return false;
  }
  
  public static boolean hJ(String paramString)
  {
    if (paramString != null) {
      return paramString.equalsIgnoreCase("blogapp");
    }
    return false;
  }
  
  public static boolean hK(String paramString)
  {
    if (paramString != null) {
      return paramString.equalsIgnoreCase("officialaccounts");
    }
    return false;
  }
  
  public static boolean hL(String paramString)
  {
    if (paramString != null) {
      return paramString.equalsIgnoreCase("helper_entry");
    }
    return false;
  }
  
  public static boolean hM(String paramString)
  {
    if (paramString != null) {
      return paramString.equalsIgnoreCase("qqfriend");
    }
    return false;
  }
  
  public static boolean hN(String paramString)
  {
    return "filehelper".equalsIgnoreCase(paramString);
  }
  
  public static boolean hO(String paramString)
  {
    if (paramString != null) {
      return paramString.equalsIgnoreCase("pc_share");
    }
    return false;
  }
  
  public static boolean hP(String paramString)
  {
    if (paramString != null) {
      return paramString.equalsIgnoreCase("notifymessage");
    }
    return false;
  }
  
  public static boolean hQ(String paramString)
  {
    if (paramString != null) {
      return paramString.equalsIgnoreCase("notification_messages");
    }
    return false;
  }
  
  public static boolean hR(String paramString)
  {
    if (hS(paramString)) {}
    while ((hU(paramString)) || (hK(paramString)) || (hL(paramString))) {
      return true;
    }
    return false;
  }
  
  public static boolean hS(String paramString)
  {
    g.DQ();
    String str = (String)g.DP().Dz().get(21, null);
    return ((str != null) && (str.equalsIgnoreCase(paramString))) || (paramString.equalsIgnoreCase("weixin"));
  }
  
  public static boolean hT(String paramString)
  {
    if (paramString != null) {
      return paramString.equalsIgnoreCase("appbrandcustomerservicemsg");
    }
    return false;
  }
  
  public static boolean hU(String paramString)
  {
    boolean bool2 = false;
    String[] arrayOfString = dVc;
    int j = arrayOfString.length;
    int i = 0;
    for (;;)
    {
      boolean bool1 = bool2;
      if (i < j)
      {
        if (arrayOfString[i].equalsIgnoreCase(paramString)) {
          bool1 = true;
        }
      }
      else {
        return bool1;
      }
      i += 1;
    }
  }
  
  public static boolean hV(String paramString)
  {
    if (hU(paramString)) {}
    while ((ad.aaT(paramString)) || (ad.aaR(paramString)) || (ad.hd(paramString))) {
      return true;
    }
    return false;
  }
  
  public static int hW(String paramString)
  {
    boolean bool;
    if (bk.pm(paramString).length() > 0)
    {
      bool = true;
      Assert.assertTrue(bool);
      paramString = paramString.trim().toLowerCase();
      if (!paramString.endsWith("@chatroom")) {
        break label40;
      }
    }
    label40:
    do
    {
      return 1;
      bool = false;
      break;
      if (ad.aaR(paramString)) {
        return 11;
      }
      if (ad.aaT(paramString)) {
        return 36;
      }
    } while (!ad.hd(paramString));
    return 1;
  }
  
  public static int hX(String paramString)
  {
    if (bk.pm(paramString).length() > 0) {}
    for (boolean bool = true;; bool = false)
    {
      Assert.assertTrue(bool);
      paramString = paramString.trim().toLowerCase();
      if (!paramString.endsWith("@chatroom")) {
        break;
      }
      return 3;
    }
    if (ad.aaR(paramString)) {
      return 13;
    }
    if (ad.aaT(paramString)) {
      return 39;
    }
    if (ad.hd(paramString)) {
      return 3;
    }
    if (paramString.contains("@")) {
      return 3;
    }
    return 3;
  }
  
  public static boolean hY(String paramString)
  {
    return ((com.tencent.mm.plugin.messenger.foundation.a.j)g.r(com.tencent.mm.plugin.messenger.foundation.a.j.class)).Fw().abl(paramString).cCy == 1;
  }
  
  public static boolean hZ(String paramString)
  {
    paramString = ((com.tencent.mm.plugin.messenger.foundation.a.j)g.r(com.tencent.mm.plugin.messenger.foundation.a.j.class)).Fw().abl(paramString);
    return (paramString != null) && (paramString.Bj());
  }
  
  public static boolean ha(String paramString)
  {
    if ((paramString == null) || (paramString.length() <= 0)) {
      return false;
    }
    return paramString.endsWith("@chatroom");
  }
  
  public static boolean hb(String paramString)
  {
    if ((paramString == null) || (paramString.length() <= 0)) {
      return false;
    }
    return paramString.endsWith("@im.chatroom");
  }
  
  public static boolean hc(String paramString)
  {
    if ((paramString == null) || (paramString.length() <= 0)) {
      return false;
    }
    return paramString.endsWith("@qy_u");
  }
  
  public static boolean hd(String paramString)
  {
    if ((paramString == null) || (paramString.length() <= 0)) {
      return false;
    }
    return paramString.endsWith("@bottle");
  }
  
  public static boolean he(String paramString)
  {
    if ((paramString == null) || (paramString.length() <= 0)) {
      return false;
    }
    return paramString.endsWith("@qqim");
  }
  
  public static boolean hf(String paramString)
  {
    if ((paramString == null) || (paramString.length() <= 0)) {
      return false;
    }
    return paramString.endsWith("@lbsroom");
  }
  
  public static boolean hg(String paramString)
  {
    return "gh_43f2581f6fd6".equals(paramString);
  }
  
  public static boolean hh(String paramString)
  {
    return "downloaderapp".equals(paramString);
  }
  
  public static boolean hi(String paramString)
  {
    if ((paramString == null) || (paramString.length() <= 0)) {
      return false;
    }
    if (!gZ(paramString)) {
      return false;
    }
    paramString = ((com.tencent.mm.plugin.messenger.foundation.a.j)g.r(com.tencent.mm.plugin.messenger.foundation.a.j.class)).Fw().abl(paramString);
    return (paramString != null) && (a.gR(paramString.field_type));
  }
  
  public static boolean hj(String paramString)
  {
    if ((paramString == null) || (paramString.length() <= 0)) {
      return false;
    }
    return paramString.endsWith("@stranger");
  }
  
  public static boolean hk(String paramString)
  {
    if ((paramString == null) || (paramString.length() <= 0)) {
      return true;
    }
    return a.gR(((com.tencent.mm.plugin.messenger.foundation.a.j)g.r(com.tencent.mm.plugin.messenger.foundation.a.j.class)).Fw().abl(paramString).field_type);
  }
  
  public static boolean hl(String paramString)
  {
    if (bk.bl(paramString)) {
      return false;
    }
    paramString = ((com.tencent.mm.plugin.messenger.foundation.a.j)g.r(com.tencent.mm.plugin.messenger.foundation.a.j.class)).Fw().abl(paramString);
    if (paramString == null) {
      return false;
    }
    return ad.Fn(paramString.field_verifyFlag);
  }
  
  public static void hm(String paramString)
  {
    ak localak2 = ((com.tencent.mm.plugin.messenger.foundation.a.j)g.r(com.tencent.mm.plugin.messenger.foundation.a.j.class)).FB().abv(paramString);
    int i = 0;
    ak localak1 = localak2;
    if (localak2 == null)
    {
      localak1 = new ak();
      localak1.cuB();
      i = 1;
      localak1.setUsername(paramString);
    }
    localak1.ba(System.currentTimeMillis());
    if (i != 0)
    {
      ((com.tencent.mm.plugin.messenger.foundation.a.j)g.r(com.tencent.mm.plugin.messenger.foundation.a.j.class)).FB().d(localak1);
      return;
    }
    ((com.tencent.mm.plugin.messenger.foundation.a.j)g.r(com.tencent.mm.plugin.messenger.foundation.a.j.class)).FB().a(localak1, paramString);
  }
  
  public static void hn(String paramString)
  {
    if (bk.bl(paramString)) {}
    ad localad;
    do
    {
      return;
      localad = ((com.tencent.mm.plugin.messenger.foundation.a.j)g.r(com.tencent.mm.plugin.messenger.foundation.a.j.class)).Fw().abl(paramString);
    } while (localad == null);
    localad.AF();
    ((com.tencent.mm.plugin.messenger.foundation.a.j)g.r(com.tencent.mm.plugin.messenger.foundation.a.j.class)).Fw().a(paramString, localad);
  }
  
  public static boolean ho(String paramString)
  {
    if (paramString != null) {
      return paramString.equalsIgnoreCase("qqmail");
    }
    return false;
  }
  
  public static boolean hp(String paramString)
  {
    if (paramString != null) {
      return paramString.equalsIgnoreCase("fmessage");
    }
    return false;
  }
  
  public static boolean hq(String paramString)
  {
    if (paramString != null) {
      return paramString.equalsIgnoreCase("tmessage");
    }
    return false;
  }
  
  public static boolean hr(String paramString)
  {
    if (paramString != null) {
      return paramString.equalsIgnoreCase("floatbottle");
    }
    return false;
  }
  
  public static boolean hs(String paramString)
  {
    if (paramString != null) {
      return paramString.equalsIgnoreCase("qmessage");
    }
    return false;
  }
  
  public static boolean ht(String paramString)
  {
    if (paramString != null) {
      return paramString.equalsIgnoreCase("facebookapp");
    }
    return false;
  }
  
  public static boolean hu(String paramString)
  {
    if (paramString != null) {
      return paramString.equalsIgnoreCase("masssendapp");
    }
    return false;
  }
  
  public static boolean hv(String paramString)
  {
    if (paramString != null) {
      return paramString.equalsIgnoreCase("feedsapp");
    }
    return false;
  }
  
  public static boolean hw(String paramString)
  {
    return "qqsync".equalsIgnoreCase(paramString);
  }
  
  public static boolean hx(String paramString)
  {
    boolean bool2 = false;
    boolean bool1 = bool2;
    if (paramString != null) {
      if (!paramString.equalsIgnoreCase("weixin"))
      {
        bool1 = bool2;
        if (!paramString.equalsIgnoreCase("gh_9639b5a92773")) {}
      }
      else
      {
        bool1 = true;
      }
    }
    return bool1;
  }
  
  public static boolean hy(String paramString)
  {
    if (paramString != null) {
      return paramString.equalsIgnoreCase("lbsapp");
    }
    return false;
  }
  
  public static boolean hz(String paramString)
  {
    if (paramString != null) {
      return paramString.equalsIgnoreCase("shakeapp");
    }
    return false;
  }
  
  public static void i(ad paramad)
  {
    if (paramad != null) {}
    for (boolean bool = true;; bool = false)
    {
      Assert.assertTrue(bool);
      ad localad2 = ((com.tencent.mm.plugin.messenger.foundation.a.j)g.r(com.tencent.mm.plugin.messenger.foundation.a.j.class)).Fw().abl(paramad.field_username);
      ad localad1;
      if (localad2 != null)
      {
        localad1 = localad2;
        if (!bk.bl(localad2.field_username)) {}
      }
      else
      {
        localad1 = paramad;
      }
      localad1.AJ();
      if ((ad.aaU(paramad.field_username)) && (dUS != null)) {
        dUS.iw(paramad.field_username);
      }
      u(localad1);
      return;
    }
  }
  
  public static boolean ia(String paramString)
  {
    if ((paramString == null) || (paramString.length() <= 0)) {}
    while ((!paramString.startsWith("t.qq.com/")) && (!paramString.startsWith("http://t.qq.com/"))) {
      return false;
    }
    return true;
  }
  
  public static String ib(String paramString)
  {
    if (ia(paramString)) {
      return paramString.replace("http://t.qq.com/", "").replace("t.qq.com/", "");
    }
    return "";
  }
  
  public static boolean ic(String paramString)
  {
    return (paramString.equals("weixinsrc")) || (paramString.equalsIgnoreCase("gh_6e99ff560306"));
  }
  
  public static void j(ad paramad)
  {
    if (paramad != null) {}
    for (boolean bool = true;; bool = false)
    {
      Assert.assertTrue(bool);
      ad localad2 = ((com.tencent.mm.plugin.messenger.foundation.a.j)g.r(com.tencent.mm.plugin.messenger.foundation.a.j.class)).Fw().abl(paramad.field_username);
      ad localad1;
      if (localad2 != null)
      {
        localad1 = localad2;
        if (!bk.bl(localad2.field_username)) {}
      }
      else
      {
        localad1 = paramad;
      }
      localad1.AK();
      if ((ad.aaU(paramad.field_username)) && (dUS != null)) {
        dUS.ix(paramad.field_username);
      }
      u(localad1);
      paramad = ((com.tencent.mm.plugin.messenger.foundation.a.j)g.r(com.tencent.mm.plugin.messenger.foundation.a.j.class)).FB().abv(paramad.field_username);
      if ((paramad != null) && ("@blacklist".equals(paramad.field_parentRef))) {
        ((com.tencent.mm.plugin.messenger.foundation.a.j)g.r(com.tencent.mm.plugin.messenger.foundation.a.j.class)).FB().d(new String[] { paramad.field_username }, "");
      }
      return;
    }
  }
  
  public static void k(ad paramad)
  {
    if (paramad != null) {}
    for (boolean bool = true;; bool = false)
    {
      Assert.assertTrue(bool);
      ad localad2 = ((com.tencent.mm.plugin.messenger.foundation.a.j)g.r(com.tencent.mm.plugin.messenger.foundation.a.j.class)).Fw().abl(paramad.field_username);
      ad localad1;
      if (localad2 != null)
      {
        localad1 = localad2;
        if (!bk.bl(localad2.field_username)) {}
      }
      else
      {
        localad1 = paramad;
      }
      localad1.AW();
      localad1.fg(paramad.AE());
      t(localad1);
      return;
    }
  }
  
  public static void l(ad paramad)
  {
    if (paramad != null) {}
    for (boolean bool = true;; bool = false)
    {
      Assert.assertTrue(bool);
      ad localad2 = ((com.tencent.mm.plugin.messenger.foundation.a.j)g.r(com.tencent.mm.plugin.messenger.foundation.a.j.class)).Fw().abl(paramad.field_username);
      ad localad1;
      if (localad2 != null)
      {
        localad1 = localad2;
        if (!bk.bl(localad2.field_username)) {}
      }
      else
      {
        localad1 = paramad;
      }
      localad1.AX();
      localad1.fg(paramad.AE());
      t(localad1);
      return;
    }
  }
  
  public static void m(ad paramad)
  {
    if (paramad != null) {}
    for (boolean bool = true;; bool = false)
    {
      Assert.assertTrue(bool);
      ad localad2 = ((com.tencent.mm.plugin.messenger.foundation.a.j)g.r(com.tencent.mm.plugin.messenger.foundation.a.j.class)).Fw().abl(paramad.field_username);
      ad localad1;
      if (localad2 != null)
      {
        localad1 = localad2;
        if (!bk.bl(localad2.field_username)) {}
      }
      else
      {
        localad1 = paramad;
      }
      localad1.AS();
      localad1.fg(paramad.AE());
      if ((ad.aaU(paramad.field_username)) && (dUS != null)) {
        dUS.iy(paramad.field_username);
      }
      u(localad1);
      return;
    }
  }
  
  public static void n(ad paramad)
  {
    if (paramad != null) {}
    for (boolean bool = true;; bool = false)
    {
      Assert.assertTrue(bool);
      ad localad2 = ((com.tencent.mm.plugin.messenger.foundation.a.j)g.r(com.tencent.mm.plugin.messenger.foundation.a.j.class)).Fw().abl(paramad.field_username);
      ad localad1;
      if (localad2 != null)
      {
        localad1 = localad2;
        if (!bk.bl(localad2.field_username)) {}
      }
      else
      {
        localad1 = paramad;
      }
      localad1.AT();
      localad1.fg(paramad.AE());
      if ((ad.aaU(paramad.field_username)) && (dUS != null)) {
        dUS.iz(paramad.field_username);
      }
      u(localad1);
      return;
    }
  }
  
  public static void o(ad paramad)
  {
    if (paramad != null) {}
    for (boolean bool = true;; bool = false)
    {
      Assert.assertTrue(bool);
      ad localad2 = ((com.tencent.mm.plugin.messenger.foundation.a.j)g.r(com.tencent.mm.plugin.messenger.foundation.a.j.class)).Fw().abl(paramad.field_username);
      ad localad1;
      if (localad2 != null)
      {
        localad1 = localad2;
        if (!bk.bl(localad2.field_username)) {}
      }
      else
      {
        localad1 = paramad;
      }
      localad1.AU();
      if ((ad.aaU(paramad.field_username)) && (dUS != null)) {
        dUS.iA(paramad.field_username);
      }
      u(localad1);
      return;
    }
  }
  
  public static void p(ad paramad)
  {
    if (paramad != null) {}
    for (boolean bool = true;; bool = false)
    {
      Assert.assertTrue(bool);
      ad localad2 = ((com.tencent.mm.plugin.messenger.foundation.a.j)g.r(com.tencent.mm.plugin.messenger.foundation.a.j.class)).Fw().abl(paramad.field_username);
      ad localad1;
      if (localad2 != null)
      {
        localad1 = localad2;
        if (!bk.bl(localad2.field_username)) {}
      }
      else
      {
        localad1 = paramad;
      }
      localad1.AV();
      if ((ad.aaU(paramad.field_username)) && (dUS != null)) {
        dUS.iB(paramad.field_username);
      }
      u(localad1);
      return;
    }
  }
  
  public static void q(ad paramad)
  {
    boolean bool2 = true;
    if (paramad != null)
    {
      bool1 = true;
      Assert.assertTrue("MicroMsg.ContactStorageLogic: user is null", bool1);
      if ((int)paramad.dBe == 0) {
        break label85;
      }
      bool1 = true;
      label25:
      Assert.assertTrue("MicroMsg.ContactStorageLogic: contactId == 0", bool1);
      if (paramad.field_username.length() <= 0) {
        break label90;
      }
    }
    label85:
    label90:
    for (boolean bool1 = bool2;; bool1 = false)
    {
      Assert.assertTrue("MicroMsg.ContactStorageLogic: username length <= 0", bool1);
      paramad.AH();
      ((com.tencent.mm.plugin.messenger.foundation.a.j)g.r(com.tencent.mm.plugin.messenger.foundation.a.j.class)).Fw().a(paramad.field_username, paramad);
      return;
      bool1 = false;
      break;
      bool1 = false;
      break label25;
    }
  }
  
  public static void r(ad paramad)
  {
    boolean bool2 = true;
    if (paramad != null)
    {
      bool1 = true;
      Assert.assertTrue(bool1);
      if ((int)paramad.dBe == 0) {
        break label80;
      }
      bool1 = true;
      label22:
      Assert.assertTrue(bool1);
      if (paramad.field_username.length() <= 0) {
        break label85;
      }
    }
    label80:
    label85:
    for (boolean bool1 = bool2;; bool1 = false)
    {
      Assert.assertTrue(bool1);
      paramad.AH();
      ((com.tencent.mm.plugin.messenger.foundation.a.j)g.r(com.tencent.mm.plugin.messenger.foundation.a.j.class)).Fw().a(paramad.field_username, paramad);
      u(paramad);
      return;
      bool1 = false;
      break;
      bool1 = false;
      break label22;
    }
  }
  
  public static void s(ad paramad)
  {
    boolean bool2 = true;
    if (paramad != null)
    {
      bool1 = true;
      Assert.assertTrue(bool1);
      if ((int)paramad.dBe == 0) {
        break label56;
      }
      bool1 = true;
      label22:
      Assert.assertTrue(bool1);
      if (paramad.field_username.length() <= 0) {
        break label61;
      }
    }
    label56:
    label61:
    for (boolean bool1 = bool2;; bool1 = false)
    {
      Assert.assertTrue(bool1);
      paramad.Bn();
      u(paramad);
      return;
      bool1 = false;
      break;
      bool1 = false;
      break label22;
    }
  }
  
  public static void s(String paramString, boolean paramBoolean)
  {
    paramString = ((com.tencent.mm.plugin.messenger.foundation.a.j)g.r(com.tencent.mm.plugin.messenger.foundation.a.j.class)).Fw().abl(paramString);
    if ((paramString == null) || (bk.bl(paramString.field_username))) {
      return;
    }
    if (paramBoolean) {
      paramString.AW();
    }
    for (;;)
    {
      t(paramString);
      return;
      paramString.AX();
    }
  }
  
  private static void t(ad paramad)
  {
    boolean bool;
    axs localaxs;
    if (paramad != null)
    {
      bool = true;
      Assert.assertTrue(bool);
      if ((int)paramad.dBe == 0)
      {
        ((com.tencent.mm.plugin.messenger.foundation.a.j)g.r(com.tencent.mm.plugin.messenger.foundation.a.j.class)).Fw().W(paramad);
        ((com.tencent.mm.plugin.messenger.foundation.a.j)g.r(com.tencent.mm.plugin.messenger.foundation.a.j.class)).Fw().abl(paramad.field_username);
      }
      ((com.tencent.mm.plugin.messenger.foundation.a.j)g.r(com.tencent.mm.plugin.messenger.foundation.a.j.class)).Fw().a(paramad.field_username, paramad);
      localaxs = new axs();
      localaxs.ttJ = paramad.field_username;
      if (!paramad.Bk()) {
        break label147;
      }
    }
    label147:
    for (localaxs.ttV = 1;; localaxs.ttV = 2)
    {
      ((com.tencent.mm.plugin.messenger.foundation.a.j)g.r(com.tencent.mm.plugin.messenger.foundation.a.j.class)).Fv().b(new i.a(52, localaxs));
      return;
      bool = false;
      break;
    }
  }
  
  public static void t(String paramString, boolean paramBoolean)
  {
    boolean bool;
    ad localad;
    if (!bk.bl(paramString))
    {
      bool = true;
      Assert.assertTrue(bool);
      localad = ((com.tencent.mm.plugin.messenger.foundation.a.j)g.r(com.tencent.mm.plugin.messenger.foundation.a.j.class)).Fw().abl(paramString);
      if ((localad != null) && (!bk.bl(localad.field_username))) {
        break label53;
      }
    }
    label53:
    do
    {
      return;
      bool = false;
      break;
      localad.setType(localad.field_type | 0x800);
      if (((ad.aaU(paramString)) || (hb(paramString))) && (dUS != null)) {
        dUS.iu(paramString);
      }
      u(localad);
    } while (!paramBoolean);
    ((com.tencent.mm.plugin.messenger.foundation.a.j)g.r(com.tencent.mm.plugin.messenger.foundation.a.j.class)).FB().abB(paramString);
  }
  
  public static void u(ad paramad)
  {
    if (paramad != null) {}
    for (boolean bool = true;; bool = false)
    {
      Assert.assertTrue(bool);
      if ((int)paramad.dBe == 0)
      {
        ((com.tencent.mm.plugin.messenger.foundation.a.j)g.r(com.tencent.mm.plugin.messenger.foundation.a.j.class)).Fw().W(paramad);
        ((com.tencent.mm.plugin.messenger.foundation.a.j)g.r(com.tencent.mm.plugin.messenger.foundation.a.j.class)).Fw().abl(paramad.field_username);
      }
      ((com.tencent.mm.plugin.messenger.foundation.a.j)g.r(com.tencent.mm.plugin.messenger.foundation.a.j.class)).Fw().a(paramad.field_username, paramad);
      if (!ad.aaU(paramad.field_username)) {
        v(paramad);
      }
      return;
    }
  }
  
  public static void u(String paramString, boolean paramBoolean)
  {
    boolean bool;
    ad localad;
    if (!bk.bl(paramString))
    {
      bool = true;
      Assert.assertTrue(bool);
      localad = ((com.tencent.mm.plugin.messenger.foundation.a.j)g.r(com.tencent.mm.plugin.messenger.foundation.a.j.class)).Fw().abl(paramString);
      if ((localad != null) && (!bk.bl(localad.field_username))) {
        break label53;
      }
    }
    label53:
    do
    {
      return;
      bool = false;
      break;
      localad.setType(localad.field_type & 0xFFFFF7FF);
      if (((ad.aaU(paramString)) || (hb(paramString))) && (dUS != null)) {
        dUS.iv(paramString);
      }
      u(localad);
    } while (!paramBoolean);
    ((com.tencent.mm.plugin.messenger.foundation.a.j)g.r(com.tencent.mm.plugin.messenger.foundation.a.j.class)).FB().abC(paramString);
  }
  
  public static void v(ad paramad)
  {
    y.i("MicroMsg.ContactStorageLogic", "oplog modContact user:%s remark:%s type:%d ", new Object[] { paramad.field_username, paramad.field_conRemark, Integer.valueOf(paramad.field_type) });
    axd localaxd = new axd();
    localaxd.sQs = new bml().YI(bk.pm(paramad.field_username));
    localaxd.tmw = new bml().YI(bk.pm(paramad.field_nickname));
    localaxd.sQa = new bml().YI(bk.pm(paramad.vn()));
    localaxd.sQb = new bml().YI(bk.pm(paramad.vo()));
    localaxd.ffh = paramad.sex;
    localaxd.sPr = 561023;
    localaxd.sPs = paramad.field_type;
    localaxd.tsS = new bml().YI(bk.pm(paramad.field_conRemark));
    localaxd.tsT = new bml().YI(bk.pm(paramad.field_conRemarkPYShort));
    localaxd.tsU = new bml().YI(bk.pm(paramad.field_conRemarkPYFull));
    localaxd.sPx = paramad.cCv;
    localaxd.tto = new bml().YI(bk.pm(paramad.field_domainList));
    localaxd.sPB = paramad.cCy;
    localaxd.ffl = paramad.cCz;
    localaxd.ffk = bk.pm(paramad.signature);
    localaxd.ffj = bk.pm(paramad.getCityCode());
    localaxd.ffi = bk.pm(paramad.cue());
    localaxd.tpi = bk.pm(paramad.cCE);
    localaxd.tpk = paramad.field_weiboFlag;
    localaxd.ttk = 0;
    localaxd.svJ = new bmk();
    localaxd.ffq = bk.pm(paramad.getCountryCode());
    ((com.tencent.mm.plugin.messenger.foundation.a.j)g.r(com.tencent.mm.plugin.messenger.foundation.a.j.class)).Fv().b(new i.a(2, localaxd));
  }
  
  public static boolean w(ad paramad)
  {
    return (paramad.field_weiboFlag & 0x1) != 0;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.model.s
 * JD-Core Version:    0.7.0.1
 */