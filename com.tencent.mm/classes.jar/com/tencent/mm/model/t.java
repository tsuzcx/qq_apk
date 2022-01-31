package com.tencent.mm.model;

import android.database.Cursor;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.c.aq;
import com.tencent.mm.g.c.au;
import com.tencent.mm.kernel.e;
import com.tencent.mm.kernel.g;
import com.tencent.mm.n.a;
import com.tencent.mm.plugin.chatroom.a.c;
import com.tencent.mm.plugin.messenger.foundation.a.a.i;
import com.tencent.mm.plugin.messenger.foundation.a.a.j.a;
import com.tencent.mm.plugin.messenger.foundation.a.a.k;
import com.tencent.mm.plugin.messenger.foundation.a.j;
import com.tencent.mm.protocal.protobuf.SKBuiltinBuffer_t;
import com.tencent.mm.protocal.protobuf.bdt;
import com.tencent.mm.protocal.protobuf.bel;
import com.tencent.mm.protocal.protobuf.bwc;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;
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

public final class t
{
  private static ah flb;
  public static final String flc;
  public static final String fld;
  public static final String fle;
  public static final String flf;
  public static final String flg;
  public static final String flh;
  public static final String fli;
  public static final String flj;
  public static final String flk;
  public static final String[] fll;
  
  static
  {
    AppMethodBeat.i(59878);
    flb = null;
    flc = b("rconversation.username", new String[] { "@im.chatroom", "@chatroom", "@openim", "@micromsg.qq.com" });
    fld = b("rconversation.username", new String[] { "@chatroom", "@micromsg.qq.com" });
    fle = b("rconversation.username", new String[] { "@t.qq.com" });
    flf = b("rconversation.username", new String[] { "@qqim" });
    flg = b("rconversation.username", new String[] { "@chatroom_exclusive" });
    flh = b("rconversation.username", new String[] { "@micromsg.qq.com" });
    fli = b("rconversation.username", new String[] { "@app" });
    flj = b("rconversation.username", new String[] { "@chatroom" });
    flk = b("rconversation.username", new String[] { "@im.chatroom" });
    fll = new String[] { "qqmail", "fmessage", "tmessage", "qmessage", "qqsync", "floatbottle", "lbsapp", "shakeapp", "medianote", "qqfriend", "newsapp", "blogapp", "facebookapp", "topstoryapp", "masssendapp", "feedsapp", "voipapp", "cardpackage", "voicevoipapp", "voiceinputapp", "officialaccounts", "linkedinplugin", "notifymessage", "appbrandcustomerservicemsg" };
    AppMethodBeat.o(59878);
  }
  
  public static int[] S(List<String> paramList)
  {
    AppMethodBeat.i(59824);
    long l = System.currentTimeMillis();
    int[] arrayOfInt1 = ((j)g.E(j.class)).YA().eN(paramList);
    ab.d("MicroMsg.ContactStorageLogic", "kevin service(IMessengerStorage.class).getContactStg().getShowHeadDistinct(" + (System.currentTimeMillis() - l));
    if (arrayOfInt1.length <= 0)
    {
      AppMethodBeat.o(59824);
      return null;
    }
    l = System.currentTimeMillis();
    paramList = ((j)g.E(j.class)).YA().eO(paramList);
    ab.d("MicroMsg.ContactStorageLogic", "kevin service(IMessengerStorage.class).getContactStg().getSectionNumByShowHead" + (System.currentTimeMillis() - l));
    if (paramList == null)
    {
      AppMethodBeat.o(59824);
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
    AppMethodBeat.o(59824);
    return arrayOfInt2;
  }
  
  public static String[] T(List<String> paramList)
  {
    AppMethodBeat.i(59828);
    long l = System.currentTimeMillis();
    paramList = ((j)g.E(j.class)).YA().eN(paramList);
    ab.d("MicroMsg.ContactStorageLogic", "kevin service(IMessengerStorage.class).getContactStg().getShowSectionByShowHead" + (System.currentTimeMillis() - l));
    if (paramList.length <= 0)
    {
      AppMethodBeat.o(59828);
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
    AppMethodBeat.o(59828);
    return arrayOfString;
  }
  
  public static List<String> ZW()
  {
    AppMethodBeat.i(59794);
    List localList = ((j)g.E(j.class)).YA().dwL();
    AppMethodBeat.o(59794);
    return localList;
  }
  
  public static List<ad> ZX()
  {
    AppMethodBeat.i(59795);
    ArrayList localArrayList = new ArrayList();
    Cursor localCursor = ((j)g.E(j.class)).YA().dwM();
    if (localCursor.moveToFirst()) {
      do
      {
        ad localad = new ad();
        localad.convertFrom(localCursor);
        localArrayList.add(localad);
      } while (localCursor.moveToNext());
    }
    localCursor.close();
    AppMethodBeat.o(59795);
    return localArrayList;
  }
  
  public static boolean ZY()
  {
    return false;
  }
  
  public static boolean ZZ()
  {
    AppMethodBeat.i(59869);
    if (!r.ZT())
    {
      AppMethodBeat.o(59869);
      return false;
    }
    bq localbq = ((j)g.E(j.class)).YI().TL("@t.qq.com");
    if ((localbq == null) || (bo.isNullOrNil(localbq.name)))
    {
      AppMethodBeat.o(59869);
      return false;
    }
    AppMethodBeat.o(59869);
    return true;
  }
  
  public static String a(ad paramad, String paramString)
  {
    AppMethodBeat.i(59796);
    if (paramad == null)
    {
      AppMethodBeat.o(59796);
      return paramString;
    }
    if ((nI(paramString)) && (bo.isNullOrNil(paramad.field_nickname)))
    {
      String str = ((c)g.E(c.class)).YJ().nE(paramString);
      if (!bo.isNullOrNil(str))
      {
        AppMethodBeat.o(59796);
        return str;
      }
    }
    if ((paramad.Of() != null) && (paramad.Of().length() > 0))
    {
      paramad = paramad.Of();
      AppMethodBeat.o(59796);
      return paramad;
    }
    AppMethodBeat.o(59796);
    return paramString;
  }
  
  public static void a(ah paramah)
  {
    flb = paramah;
  }
  
  public static boolean a(ak paramak)
  {
    AppMethodBeat.i(59873);
    String str = paramak.field_username;
    if (oD(str))
    {
      AppMethodBeat.o(59873);
      return false;
    }
    if (oB(str))
    {
      AppMethodBeat.o(59873);
      return false;
    }
    if (ot(str))
    {
      AppMethodBeat.o(59873);
      return false;
    }
    if (ou(str))
    {
      AppMethodBeat.o(59873);
      return false;
    }
    if (paramak.field_conversationTime == -1L)
    {
      AppMethodBeat.o(59873);
      return false;
    }
    if (nU(str))
    {
      AppMethodBeat.o(59873);
      return true;
    }
    AppMethodBeat.o(59873);
    return true;
  }
  
  public static int[] a(String paramString1, String paramString2, List<String> paramList, String paramString3)
  {
    AppMethodBeat.i(59823);
    long l = System.currentTimeMillis();
    int[] arrayOfInt1 = ((j)g.E(j.class)).YA().c(paramString1, paramString2, paramString3, paramList);
    ab.d("MicroMsg.ContactStorageLogic", "kevin service(IMessengerStorage.class).getContactStg().getShowHeadDistinct(" + (System.currentTimeMillis() - l));
    if (arrayOfInt1.length <= 0)
    {
      AppMethodBeat.o(59823);
      return null;
    }
    l = System.currentTimeMillis();
    int[] arrayOfInt2 = ((j)g.E(j.class)).YA().d(paramString1, paramString2, paramString3, paramList);
    ab.d("MicroMsg.ContactStorageLogic", "kevin service(IMessengerStorage.class).getContactStg().getSectionNumByShowHead" + (System.currentTimeMillis() - l));
    if (arrayOfInt2 == null)
    {
      AppMethodBeat.o(59823);
      return null;
    }
    if (arrayOfInt1.length != arrayOfInt2.length)
    {
      ab.e("MicroMsg.ContactStorageLogic", "[%s:%s] filterType:%s filterSearchStr:%s blocklist:%s searchString:%s", new Object[] { Integer.valueOf(arrayOfInt1.length), Integer.valueOf(arrayOfInt2.length), paramString1, paramString2, paramList, paramString3 });
      AppMethodBeat.o(59823);
      return null;
    }
    paramString1 = new int[arrayOfInt2.length];
    int k = 0;
    int j = 0;
    int i = 0;
    while (k < arrayOfInt1.length)
    {
      paramString1[i] = j;
      int m = arrayOfInt2[k];
      k += 1;
      j = m + j;
      i += 1;
    }
    AppMethodBeat.o(59823);
    return paramString1;
  }
  
  public static int[] a(String paramString1, String paramString2, List<String> paramList, String[] paramArrayOfString)
  {
    AppMethodBeat.i(59825);
    int[] arrayOfInt = ((j)g.E(j.class)).YA().b(paramString1, paramString2, paramArrayOfString, paramList);
    if (arrayOfInt.length <= 0)
    {
      AppMethodBeat.o(59825);
      return null;
    }
    paramString1 = ((j)g.E(j.class)).YA().c(paramString1, paramString2, paramArrayOfString, paramList);
    if (paramString1 == null)
    {
      AppMethodBeat.o(59825);
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
    AppMethodBeat.o(59825);
    return paramString2;
  }
  
  public static String[] a(String paramString1, String paramString2, String paramString3, List<String> paramList)
  {
    AppMethodBeat.i(59827);
    long l = System.currentTimeMillis();
    paramString1 = ((j)g.E(j.class)).YA().c(paramString1, paramString2, paramString3, paramList);
    ab.d("MicroMsg.ContactStorageLogic", "kevin service(IMessengerStorage.class).getContactStg().getShowSectionByShowHead" + (System.currentTimeMillis() - l));
    if (paramString1.length <= 0)
    {
      AppMethodBeat.o(59827);
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
    AppMethodBeat.o(59827);
    return paramString2;
  }
  
  public static String[] a(String paramString1, String paramString2, String[] paramArrayOfString, List<String> paramList)
  {
    AppMethodBeat.i(59826);
    long l = System.currentTimeMillis();
    paramString1 = ((j)g.E(j.class)).YA().b(paramString1, paramString2, paramArrayOfString, paramList);
    ab.d("MicroMsg.ContactStorageLogic", "kevin service(IMessengerStorage.class).getContactStg().getShowSectionByShowHead" + (System.currentTimeMillis() - l));
    if (paramString1.length <= 0)
    {
      AppMethodBeat.o(59826);
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
    AppMethodBeat.o(59826);
    return paramString2;
  }
  
  public static boolean aaa()
  {
    AppMethodBeat.i(59870);
    if (!r.ZT())
    {
      AppMethodBeat.o(59870);
      return false;
    }
    bq localbq = ((j)g.E(j.class)).YI().TL("@t.qq.com");
    if ((localbq == null) || (bo.nullAsNil(localbq.name).length() == 0))
    {
      AppMethodBeat.o(59870);
      return false;
    }
    AppMethodBeat.o(59870);
    return true;
  }
  
  public static List<ad> aab()
  {
    AppMethodBeat.i(59871);
    LinkedList localLinkedList = new LinkedList();
    Cursor localCursor = ((j)g.E(j.class)).YA().dwP();
    if (localCursor.getCount() == 0)
    {
      localCursor.close();
      AppMethodBeat.o(59871);
      return localLinkedList;
    }
    localCursor.moveToFirst();
    do
    {
      ad localad = new ad();
      localad.convertFrom(localCursor);
      localLinkedList.add(localad);
    } while (localCursor.moveToNext());
    localCursor.close();
    ab.d("MicroMsg.ContactStorageLogic", "getFavourList size:  " + localLinkedList.size());
    AppMethodBeat.o(59871);
    return localLinkedList;
  }
  
  public static List<String> aac()
  {
    AppMethodBeat.i(59872);
    LinkedList localLinkedList = new LinkedList();
    Cursor localCursor = ((j)g.E(j.class)).YA().dwN();
    if (localCursor.getCount() == 0)
    {
      localCursor.close();
      AppMethodBeat.o(59872);
      return localLinkedList;
    }
    localCursor.moveToFirst();
    do
    {
      ad localad = new ad();
      localad.convertFrom(localCursor);
      localLinkedList.add(localad.field_username);
    } while (localCursor.moveToNext());
    localCursor.close();
    ab.d("MicroMsg.ContactStorageLogic", "getSnsBlackContactList size:  " + localLinkedList.size());
    AppMethodBeat.o(59872);
    return localLinkedList;
  }
  
  public static int aad()
  {
    AppMethodBeat.i(59875);
    int i = ((j)g.E(j.class)).YA().b(fll, new String[] { r.Zn(), "weixin", "helper_entry", "filehelper" });
    AppMethodBeat.o(59875);
    return i;
  }
  
  private static String b(String paramString, String[] paramArrayOfString)
  {
    AppMethodBeat.i(59876);
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
    AppMethodBeat.o(59876);
    return paramString;
  }
  
  public static void b(ad paramad, String paramString)
  {
    AppMethodBeat.i(59817);
    ad localad = ((j)g.E(j.class)).YA().arw(paramad.field_username);
    if ((localad != null) && (paramString != null)) {}
    for (boolean bool = true;; bool = false)
    {
      Assert.assertTrue(bool);
      localad.jn(paramString);
      if ((ad.arf(paramad.field_username)) && (flb != null)) {
        flb.al(paramad.field_username, paramString);
      }
      u(localad);
      AppMethodBeat.o(59817);
      return;
    }
  }
  
  public static boolean b(ak paramak)
  {
    AppMethodBeat.i(59874);
    paramak = paramak.field_username;
    if (ot(paramak))
    {
      AppMethodBeat.o(59874);
      return false;
    }
    if (oC(paramak))
    {
      AppMethodBeat.o(59874);
      return false;
    }
    AppMethodBeat.o(59874);
    return true;
  }
  
  public static boolean e(ad paramad)
  {
    AppMethodBeat.i(59789);
    if (paramad == null)
    {
      AppMethodBeat.o(59789);
      return false;
    }
    if (!nI(paramad.field_username))
    {
      AppMethodBeat.o(59789);
      return false;
    }
    if (!a.je(paramad.field_type))
    {
      AppMethodBeat.o(59789);
      return false;
    }
    AppMethodBeat.o(59789);
    return true;
  }
  
  public static void f(ad paramad)
  {
    AppMethodBeat.i(59800);
    boolean bool;
    ad localad2;
    if (paramad != null)
    {
      bool = true;
      Assert.assertTrue(bool);
      localad2 = ((j)g.E(j.class)).YA().arw(paramad.field_username);
      localad1 = paramad;
      if (localad2 != null) {
        if (!bo.isNullOrNil(localad2.field_username)) {
          break label77;
        }
      }
    }
    label77:
    for (ad localad1 = paramad;; localad1 = localad2)
    {
      localad1.ND();
      u(localad1);
      AppMethodBeat.o(59800);
      return;
      bool = false;
      break;
    }
  }
  
  public static void g(ad paramad)
  {
    AppMethodBeat.i(59802);
    boolean bool;
    ad localad2;
    if (paramad != null)
    {
      bool = true;
      Assert.assertTrue(bool);
      localad2 = ((j)g.E(j.class)).YA().arw(paramad.field_username);
      localad1 = paramad;
      if (localad2 != null) {
        if (!bo.isNullOrNil(localad2.field_username)) {
          break label77;
        }
      }
    }
    label77:
    for (ad localad1 = paramad;; localad1 = localad2)
    {
      localad1.NB();
      u(localad1);
      AppMethodBeat.o(59802);
      return;
      bool = false;
      break;
    }
  }
  
  public static void h(ad paramad)
  {
    AppMethodBeat.i(59803);
    boolean bool;
    ad localad2;
    if (paramad != null)
    {
      bool = true;
      Assert.assertTrue(bool);
      localad2 = ((j)g.E(j.class)).YA().arw(paramad.field_username);
      localad1 = paramad;
      if (localad2 != null) {
        if (!bo.isNullOrNil(localad2.field_username)) {
          break label77;
        }
      }
    }
    label77:
    for (ad localad1 = paramad;; localad1 = localad2)
    {
      localad1.NC();
      u(localad1);
      AppMethodBeat.o(59803);
      return;
      bool = false;
      break;
    }
  }
  
  public static void i(ad paramad)
  {
    AppMethodBeat.i(59804);
    if (paramad != null) {}
    for (boolean bool = true;; bool = false)
    {
      Assert.assertTrue(bool);
      ad localad2 = ((j)g.E(j.class)).YA().arw(paramad.field_username);
      ad localad1;
      if (localad2 != null)
      {
        localad1 = localad2;
        if (!bo.isNullOrNil(localad2.field_username)) {}
      }
      else
      {
        localad1 = paramad;
      }
      localad1.Nz();
      if ((ad.arf(paramad.field_username)) && (flb != null)) {
        flb.pe(paramad.field_username);
      }
      u(localad1);
      AppMethodBeat.o(59804);
      return;
    }
  }
  
  public static void j(ad paramad)
  {
    AppMethodBeat.i(59805);
    if (paramad != null) {}
    for (boolean bool = true;; bool = false)
    {
      Assert.assertTrue(bool);
      ad localad2 = ((j)g.E(j.class)).YA().arw(paramad.field_username);
      ad localad1;
      if (localad2 != null)
      {
        localad1 = localad2;
        if (!bo.isNullOrNil(localad2.field_username)) {}
      }
      else
      {
        localad1 = paramad;
      }
      localad1.NA();
      if ((ad.arf(paramad.field_username)) && (flb != null)) {
        flb.pf(paramad.field_username);
      }
      u(localad1);
      paramad = ((j)g.E(j.class)).YF().arH(paramad.field_username);
      if ((paramad != null) && ("@blacklist".equals(paramad.field_parentRef))) {
        ((j)g.E(j.class)).YF().c(new String[] { paramad.field_username }, "");
      }
      AppMethodBeat.o(59805);
      return;
    }
  }
  
  public static void k(ad paramad)
  {
    AppMethodBeat.i(59806);
    if (paramad != null) {}
    for (boolean bool = true;; bool = false)
    {
      Assert.assertTrue(bool);
      ad localad2 = ((j)g.E(j.class)).YA().arw(paramad.field_username);
      ad localad1;
      if (localad2 != null)
      {
        localad1 = localad2;
        if (!bo.isNullOrNil(localad2.field_username)) {}
      }
      else
      {
        localad1 = paramad;
      }
      localad1.NM();
      localad1.hs(paramad.Nu());
      t(localad1);
      AppMethodBeat.o(59806);
      return;
    }
  }
  
  public static boolean ku(int paramInt)
  {
    AppMethodBeat.i(59799);
    boolean bool = ad.Nt(paramInt);
    AppMethodBeat.o(59799);
    return bool;
  }
  
  public static void l(ad paramad)
  {
    AppMethodBeat.i(59807);
    if (paramad != null) {}
    for (boolean bool = true;; bool = false)
    {
      Assert.assertTrue(bool);
      ad localad2 = ((j)g.E(j.class)).YA().arw(paramad.field_username);
      ad localad1;
      if (localad2 != null)
      {
        localad1 = localad2;
        if (!bo.isNullOrNil(localad2.field_username)) {}
      }
      else
      {
        localad1 = paramad;
      }
      localad1.NN();
      localad1.hs(paramad.Nu());
      t(localad1);
      AppMethodBeat.o(59807);
      return;
    }
  }
  
  public static boolean lA(String paramString)
  {
    AppMethodBeat.i(59783);
    if ((paramString == null) || (paramString.length() <= 0))
    {
      AppMethodBeat.o(59783);
      return false;
    }
    if ((paramString.endsWith("@chatroom")) || (paramString.endsWith("@im.chatroom")))
    {
      AppMethodBeat.o(59783);
      return true;
    }
    AppMethodBeat.o(59783);
    return false;
  }
  
  public static void m(ad paramad)
  {
    AppMethodBeat.i(59808);
    if (paramad != null) {}
    for (boolean bool = true;; bool = false)
    {
      Assert.assertTrue(bool);
      ad localad2 = ((j)g.E(j.class)).YA().arw(paramad.field_username);
      ad localad1;
      if (localad2 != null)
      {
        localad1 = localad2;
        if (!bo.isNullOrNil(localad2.field_username)) {}
      }
      else
      {
        localad1 = paramad;
      }
      localad1.NI();
      localad1.hs(paramad.Nu());
      if ((ad.arf(paramad.field_username)) && (flb != null)) {
        flb.pg(paramad.field_username);
      }
      u(localad1);
      AppMethodBeat.o(59808);
      return;
    }
  }
  
  public static void n(ad paramad)
  {
    AppMethodBeat.i(59809);
    if (paramad != null) {}
    for (boolean bool = true;; bool = false)
    {
      Assert.assertTrue(bool);
      ad localad2 = ((j)g.E(j.class)).YA().arw(paramad.field_username);
      ad localad1;
      if (localad2 != null)
      {
        localad1 = localad2;
        if (!bo.isNullOrNil(localad2.field_username)) {}
      }
      else
      {
        localad1 = paramad;
      }
      localad1.NJ();
      localad1.hs(paramad.Nu());
      if ((ad.arf(paramad.field_username)) && (flb != null)) {
        flb.ph(paramad.field_username);
      }
      u(localad1);
      AppMethodBeat.o(59809);
      return;
    }
  }
  
  public static boolean nH(String paramString)
  {
    AppMethodBeat.i(59780);
    if ((paramString == null) || (paramString.length() <= 0))
    {
      AppMethodBeat.o(59780);
      return false;
    }
    if ((!paramString.contains("@")) || (paramString.endsWith("@micromsg.qq.com")))
    {
      AppMethodBeat.o(59780);
      return true;
    }
    AppMethodBeat.o(59780);
    return false;
  }
  
  public static boolean nI(String paramString)
  {
    AppMethodBeat.i(59781);
    if ((nJ(paramString)) || (nK(paramString)))
    {
      AppMethodBeat.o(59781);
      return true;
    }
    AppMethodBeat.o(59781);
    return false;
  }
  
  public static boolean nJ(String paramString)
  {
    AppMethodBeat.i(59782);
    if ((paramString == null) || (paramString.length() <= 0))
    {
      AppMethodBeat.o(59782);
      return false;
    }
    boolean bool = paramString.endsWith("@chatroom");
    AppMethodBeat.o(59782);
    return bool;
  }
  
  public static boolean nK(String paramString)
  {
    AppMethodBeat.i(59784);
    if ((paramString == null) || (paramString.length() <= 0))
    {
      AppMethodBeat.o(59784);
      return false;
    }
    boolean bool = paramString.endsWith("@im.chatroom");
    AppMethodBeat.o(59784);
    return bool;
  }
  
  public static boolean nL(String paramString)
  {
    AppMethodBeat.i(59785);
    if ((paramString == null) || (paramString.length() <= 0))
    {
      AppMethodBeat.o(59785);
      return false;
    }
    boolean bool = paramString.endsWith("@qy_u");
    AppMethodBeat.o(59785);
    return bool;
  }
  
  public static boolean nM(String paramString)
  {
    AppMethodBeat.i(59786);
    if ((paramString == null) || (paramString.length() <= 0))
    {
      AppMethodBeat.o(59786);
      return false;
    }
    boolean bool = paramString.endsWith("@bottle");
    AppMethodBeat.o(59786);
    return bool;
  }
  
  public static boolean nN(String paramString)
  {
    AppMethodBeat.i(59787);
    if ((paramString == null) || (paramString.length() <= 0))
    {
      AppMethodBeat.o(59787);
      return false;
    }
    boolean bool = paramString.endsWith("@qqim");
    AppMethodBeat.o(59787);
    return bool;
  }
  
  public static boolean nO(String paramString)
  {
    AppMethodBeat.i(59788);
    if ((paramString == null) || (paramString.length() <= 0))
    {
      AppMethodBeat.o(59788);
      return false;
    }
    boolean bool = paramString.endsWith("@lbsroom");
    AppMethodBeat.o(59788);
    return bool;
  }
  
  public static boolean nP(String paramString)
  {
    AppMethodBeat.i(59790);
    boolean bool = "gh_43f2581f6fd6".equals(paramString);
    AppMethodBeat.o(59790);
    return bool;
  }
  
  public static boolean nQ(String paramString)
  {
    AppMethodBeat.i(59791);
    boolean bool = "downloaderapp".equals(paramString);
    AppMethodBeat.o(59791);
    return bool;
  }
  
  public static boolean nR(String paramString)
  {
    AppMethodBeat.i(59792);
    if ((paramString == null) || (paramString.length() <= 0))
    {
      AppMethodBeat.o(59792);
      return false;
    }
    if (!nI(paramString))
    {
      AppMethodBeat.o(59792);
      return false;
    }
    paramString = ((j)g.E(j.class)).YA().arw(paramString);
    if ((paramString == null) || (!a.je(paramString.field_type)))
    {
      AppMethodBeat.o(59792);
      return false;
    }
    AppMethodBeat.o(59792);
    return true;
  }
  
  public static boolean nS(String paramString)
  {
    AppMethodBeat.i(59793);
    if ((paramString == null) || (paramString.length() <= 0))
    {
      AppMethodBeat.o(59793);
      return false;
    }
    boolean bool = paramString.endsWith("@stranger");
    AppMethodBeat.o(59793);
    return bool;
  }
  
  public static boolean nT(String paramString)
  {
    AppMethodBeat.i(59797);
    if ((paramString == null) || (paramString.length() <= 0))
    {
      AppMethodBeat.o(59797);
      return true;
    }
    boolean bool = a.je(((j)g.E(j.class)).YA().arw(paramString).field_type);
    AppMethodBeat.o(59797);
    return bool;
  }
  
  public static boolean nU(String paramString)
  {
    AppMethodBeat.i(59798);
    if (bo.isNullOrNil(paramString))
    {
      AppMethodBeat.o(59798);
      return false;
    }
    paramString = ((j)g.E(j.class)).YA().arw(paramString);
    if (paramString == null)
    {
      AppMethodBeat.o(59798);
      return false;
    }
    boolean bool = ad.Nt(paramString.field_verifyFlag);
    AppMethodBeat.o(59798);
    return bool;
  }
  
  public static void nV(String paramString)
  {
    AppMethodBeat.i(59811);
    ak localak2 = ((j)g.E(j.class)).YF().arH(paramString);
    int i = 0;
    ak localak1 = localak2;
    if (localak2 == null)
    {
      localak1 = new ak();
      localak1.dxc();
      i = 1;
      localak1.setUsername(paramString);
    }
    localak1.fK(System.currentTimeMillis());
    if (i != 0)
    {
      ((j)g.E(j.class)).YF().d(localak1);
      AppMethodBeat.o(59811);
      return;
    }
    ((j)g.E(j.class)).YF().a(localak1, paramString);
    AppMethodBeat.o(59811);
  }
  
  public static void nW(String paramString)
  {
    AppMethodBeat.i(59822);
    if (bo.isNullOrNil(paramString))
    {
      AppMethodBeat.o(59822);
      return;
    }
    ad localad = ((j)g.E(j.class)).YA().arw(paramString);
    if (localad == null)
    {
      AppMethodBeat.o(59822);
      return;
    }
    localad.setSource(0);
    localad.Nv();
    ((j)g.E(j.class)).YA().b(paramString, localad);
    AppMethodBeat.o(59822);
  }
  
  public static boolean nX(String paramString)
  {
    AppMethodBeat.i(59829);
    if (paramString != null)
    {
      boolean bool = paramString.equalsIgnoreCase("qqmail");
      AppMethodBeat.o(59829);
      return bool;
    }
    AppMethodBeat.o(59829);
    return false;
  }
  
  public static boolean nY(String paramString)
  {
    AppMethodBeat.i(59830);
    if (paramString != null)
    {
      boolean bool = paramString.equalsIgnoreCase("fmessage");
      AppMethodBeat.o(59830);
      return bool;
    }
    AppMethodBeat.o(59830);
    return false;
  }
  
  public static boolean nZ(String paramString)
  {
    AppMethodBeat.i(59831);
    if (paramString != null)
    {
      boolean bool = paramString.equalsIgnoreCase("tmessage");
      AppMethodBeat.o(59831);
      return bool;
    }
    AppMethodBeat.o(59831);
    return false;
  }
  
  public static void o(ad paramad)
  {
    AppMethodBeat.i(59813);
    if (paramad != null) {}
    for (boolean bool = true;; bool = false)
    {
      Assert.assertTrue(bool);
      ad localad2 = ((j)g.E(j.class)).YA().arw(paramad.field_username);
      ad localad1;
      if (localad2 != null)
      {
        localad1 = localad2;
        if (!bo.isNullOrNil(localad2.field_username)) {}
      }
      else
      {
        localad1 = paramad;
      }
      localad1.NK();
      if ((ad.arf(paramad.field_username)) && (flb != null)) {
        flb.pi(paramad.field_username);
      }
      u(localad1);
      AppMethodBeat.o(59813);
      return;
    }
  }
  
  public static boolean oA(String paramString)
  {
    AppMethodBeat.i(59858);
    if (oB(paramString))
    {
      AppMethodBeat.o(59858);
      return true;
    }
    if (oD(paramString))
    {
      AppMethodBeat.o(59858);
      return true;
    }
    if (ot(paramString))
    {
      AppMethodBeat.o(59858);
      return true;
    }
    if (ou(paramString))
    {
      AppMethodBeat.o(59858);
      return true;
    }
    AppMethodBeat.o(59858);
    return false;
  }
  
  public static boolean oB(String paramString)
  {
    AppMethodBeat.i(59859);
    g.RM();
    String str = (String)g.RL().Ru().get(21, null);
    if (((str != null) && (str.equalsIgnoreCase(paramString))) || (paramString.equalsIgnoreCase("weixin")))
    {
      AppMethodBeat.o(59859);
      return true;
    }
    AppMethodBeat.o(59859);
    return false;
  }
  
  public static boolean oC(String paramString)
  {
    AppMethodBeat.i(59860);
    if (paramString != null)
    {
      boolean bool = paramString.equalsIgnoreCase("appbrandcustomerservicemsg");
      AppMethodBeat.o(59860);
      return bool;
    }
    AppMethodBeat.o(59860);
    return false;
  }
  
  public static boolean oD(String paramString)
  {
    AppMethodBeat.i(59861);
    String[] arrayOfString = fll;
    int j = arrayOfString.length;
    int i = 0;
    while (i < j)
    {
      if (arrayOfString[i].equalsIgnoreCase(paramString))
      {
        AppMethodBeat.o(59861);
        return true;
      }
      i += 1;
    }
    AppMethodBeat.o(59861);
    return false;
  }
  
  public static boolean oE(String paramString)
  {
    AppMethodBeat.i(59862);
    if (oD(paramString))
    {
      AppMethodBeat.o(59862);
      return true;
    }
    if (ad.are(paramString))
    {
      AppMethodBeat.o(59862);
      return true;
    }
    if (ad.arc(paramString))
    {
      AppMethodBeat.o(59862);
      return true;
    }
    if (ad.nM(paramString))
    {
      AppMethodBeat.o(59862);
      return true;
    }
    AppMethodBeat.o(59862);
    return false;
  }
  
  public static int oF(String paramString)
  {
    AppMethodBeat.i(59863);
    if (bo.nullAsNil(paramString).length() > 0) {}
    for (boolean bool = true;; bool = false)
    {
      Assert.assertTrue(bool);
      paramString = paramString.trim().toLowerCase();
      if (!paramString.endsWith("@chatroom")) {
        break;
      }
      AppMethodBeat.o(59863);
      return 1;
    }
    if (ad.arc(paramString))
    {
      AppMethodBeat.o(59863);
      return 11;
    }
    if (ad.are(paramString))
    {
      AppMethodBeat.o(59863);
      return 36;
    }
    if (ad.nM(paramString))
    {
      AppMethodBeat.o(59863);
      return 1;
    }
    AppMethodBeat.o(59863);
    return 1;
  }
  
  public static int oG(String paramString)
  {
    AppMethodBeat.i(59864);
    if (bo.nullAsNil(paramString).length() > 0) {}
    for (boolean bool = true;; bool = false)
    {
      Assert.assertTrue(bool);
      paramString = paramString.trim().toLowerCase();
      if (!paramString.endsWith("@chatroom")) {
        break;
      }
      AppMethodBeat.o(59864);
      return 3;
    }
    if (ad.arc(paramString))
    {
      AppMethodBeat.o(59864);
      return 13;
    }
    if (ad.are(paramString))
    {
      AppMethodBeat.o(59864);
      return 39;
    }
    if (ad.nM(paramString))
    {
      AppMethodBeat.o(59864);
      return 3;
    }
    if (paramString.contains("@"))
    {
      AppMethodBeat.o(59864);
      return 3;
    }
    AppMethodBeat.o(59864);
    return 3;
  }
  
  public static boolean oH(String paramString)
  {
    AppMethodBeat.i(59865);
    if (((j)g.E(j.class)).YA().arw(paramString).dqK != 1)
    {
      AppMethodBeat.o(59865);
      return false;
    }
    AppMethodBeat.o(59865);
    return true;
  }
  
  public static boolean oI(String paramString)
  {
    AppMethodBeat.i(59866);
    paramString = ((j)g.E(j.class)).YA().arw(paramString);
    if ((paramString != null) && (paramString.DP()))
    {
      AppMethodBeat.o(59866);
      return true;
    }
    AppMethodBeat.o(59866);
    return false;
  }
  
  public static boolean oJ(String paramString)
  {
    AppMethodBeat.i(59867);
    if ((paramString == null) || (paramString.length() <= 0))
    {
      AppMethodBeat.o(59867);
      return false;
    }
    if ((paramString.startsWith("t.qq.com/")) || (paramString.startsWith("http://t.qq.com/")))
    {
      AppMethodBeat.o(59867);
      return true;
    }
    AppMethodBeat.o(59867);
    return false;
  }
  
  public static String oK(String paramString)
  {
    AppMethodBeat.i(59868);
    if (oJ(paramString))
    {
      paramString = paramString.replace("http://t.qq.com/", "").replace("t.qq.com/", "");
      AppMethodBeat.o(59868);
      return paramString;
    }
    AppMethodBeat.o(59868);
    return "";
  }
  
  public static boolean oL(String paramString)
  {
    AppMethodBeat.i(59877);
    if ((paramString.equals("weixinsrc")) || (paramString.equalsIgnoreCase("gh_6e99ff560306")))
    {
      AppMethodBeat.o(59877);
      return true;
    }
    AppMethodBeat.o(59877);
    return false;
  }
  
  public static boolean oa(String paramString)
  {
    AppMethodBeat.i(59832);
    if (paramString != null)
    {
      boolean bool = paramString.equalsIgnoreCase("floatbottle");
      AppMethodBeat.o(59832);
      return bool;
    }
    AppMethodBeat.o(59832);
    return false;
  }
  
  public static boolean ob(String paramString)
  {
    AppMethodBeat.i(59833);
    if (paramString != null)
    {
      boolean bool = paramString.equalsIgnoreCase("qmessage");
      AppMethodBeat.o(59833);
      return bool;
    }
    AppMethodBeat.o(59833);
    return false;
  }
  
  public static boolean oc(String paramString)
  {
    AppMethodBeat.i(59834);
    if (paramString != null)
    {
      boolean bool = paramString.equalsIgnoreCase("facebookapp");
      AppMethodBeat.o(59834);
      return bool;
    }
    AppMethodBeat.o(59834);
    return false;
  }
  
  public static boolean od(String paramString)
  {
    AppMethodBeat.i(59835);
    if (paramString != null)
    {
      boolean bool = paramString.equalsIgnoreCase("masssendapp");
      AppMethodBeat.o(59835);
      return bool;
    }
    AppMethodBeat.o(59835);
    return false;
  }
  
  public static boolean oe(String paramString)
  {
    AppMethodBeat.i(59836);
    if (paramString != null)
    {
      boolean bool = paramString.equalsIgnoreCase("feedsapp");
      AppMethodBeat.o(59836);
      return bool;
    }
    AppMethodBeat.o(59836);
    return false;
  }
  
  public static boolean of(String paramString)
  {
    AppMethodBeat.i(59837);
    boolean bool = "qqsync".equalsIgnoreCase(paramString);
    AppMethodBeat.o(59837);
    return bool;
  }
  
  public static boolean og(String paramString)
  {
    AppMethodBeat.i(59838);
    if (paramString != null)
    {
      if ((paramString.equalsIgnoreCase("weixin")) || (paramString.equalsIgnoreCase("gh_9639b5a92773")))
      {
        AppMethodBeat.o(59838);
        return true;
      }
      AppMethodBeat.o(59838);
      return false;
    }
    AppMethodBeat.o(59838);
    return false;
  }
  
  public static boolean oh(String paramString)
  {
    AppMethodBeat.i(59839);
    if (paramString != null)
    {
      boolean bool = paramString.equalsIgnoreCase("lbsapp");
      AppMethodBeat.o(59839);
      return bool;
    }
    AppMethodBeat.o(59839);
    return false;
  }
  
  public static boolean oi(String paramString)
  {
    AppMethodBeat.i(59840);
    if (paramString != null)
    {
      boolean bool = paramString.equalsIgnoreCase("shakeapp");
      AppMethodBeat.o(59840);
      return bool;
    }
    AppMethodBeat.o(59840);
    return false;
  }
  
  public static boolean oj(String paramString)
  {
    AppMethodBeat.i(59841);
    if (paramString != null)
    {
      boolean bool = paramString.equalsIgnoreCase("medianote");
      AppMethodBeat.o(59841);
      return bool;
    }
    AppMethodBeat.o(59841);
    return false;
  }
  
  public static boolean ok(String paramString)
  {
    AppMethodBeat.i(59842);
    if (paramString != null)
    {
      boolean bool = paramString.equalsIgnoreCase("newsapp");
      AppMethodBeat.o(59842);
      return bool;
    }
    AppMethodBeat.o(59842);
    return false;
  }
  
  public static boolean ol(String paramString)
  {
    AppMethodBeat.i(59843);
    if (paramString != null)
    {
      boolean bool = paramString.equalsIgnoreCase("topstoryapp");
      AppMethodBeat.o(59843);
      return bool;
    }
    AppMethodBeat.o(59843);
    return false;
  }
  
  public static boolean om(String paramString)
  {
    AppMethodBeat.i(59844);
    if (paramString != null)
    {
      boolean bool = paramString.equalsIgnoreCase("voipapp");
      AppMethodBeat.o(59844);
      return bool;
    }
    AppMethodBeat.o(59844);
    return false;
  }
  
  public static boolean on(String paramString)
  {
    AppMethodBeat.i(59845);
    if (paramString != null)
    {
      boolean bool = paramString.equalsIgnoreCase("voicevoipapp");
      AppMethodBeat.o(59845);
      return bool;
    }
    AppMethodBeat.o(59845);
    return false;
  }
  
  public static boolean oo(String paramString)
  {
    AppMethodBeat.i(59846);
    if (paramString != null)
    {
      boolean bool = paramString.equalsIgnoreCase("voiceinputapp");
      AppMethodBeat.o(59846);
      return bool;
    }
    AppMethodBeat.o(59846);
    return false;
  }
  
  public static boolean op(String paramString)
  {
    AppMethodBeat.i(59847);
    if (paramString != null)
    {
      boolean bool = paramString.equalsIgnoreCase("linkedinplugin");
      AppMethodBeat.o(59847);
      return bool;
    }
    AppMethodBeat.o(59847);
    return false;
  }
  
  public static boolean oq(String paramString)
  {
    AppMethodBeat.i(59848);
    boolean bool = or(paramString);
    AppMethodBeat.o(59848);
    return bool;
  }
  
  public static boolean or(String paramString)
  {
    AppMethodBeat.i(59849);
    if (paramString != null)
    {
      boolean bool = paramString.equalsIgnoreCase("gh_22b87fa7cb3c");
      AppMethodBeat.o(59849);
      return bool;
    }
    AppMethodBeat.o(59849);
    return false;
  }
  
  public static boolean os(String paramString)
  {
    AppMethodBeat.i(59850);
    if (paramString != null)
    {
      boolean bool = paramString.equalsIgnoreCase("blogapp");
      AppMethodBeat.o(59850);
      return bool;
    }
    AppMethodBeat.o(59850);
    return false;
  }
  
  public static boolean ot(String paramString)
  {
    AppMethodBeat.i(59851);
    if (paramString != null)
    {
      boolean bool = paramString.equalsIgnoreCase("officialaccounts");
      AppMethodBeat.o(59851);
      return bool;
    }
    AppMethodBeat.o(59851);
    return false;
  }
  
  public static boolean ou(String paramString)
  {
    AppMethodBeat.i(59852);
    if (paramString != null)
    {
      boolean bool = paramString.equalsIgnoreCase("helper_entry");
      AppMethodBeat.o(59852);
      return bool;
    }
    AppMethodBeat.o(59852);
    return false;
  }
  
  public static boolean ov(String paramString)
  {
    AppMethodBeat.i(59853);
    if (paramString != null)
    {
      boolean bool = paramString.equalsIgnoreCase("qqfriend");
      AppMethodBeat.o(59853);
      return bool;
    }
    AppMethodBeat.o(59853);
    return false;
  }
  
  public static boolean ow(String paramString)
  {
    AppMethodBeat.i(59854);
    boolean bool = "filehelper".equalsIgnoreCase(paramString);
    AppMethodBeat.o(59854);
    return bool;
  }
  
  public static boolean ox(String paramString)
  {
    AppMethodBeat.i(59855);
    if (paramString != null)
    {
      boolean bool = paramString.equalsIgnoreCase("pc_share");
      AppMethodBeat.o(59855);
      return bool;
    }
    AppMethodBeat.o(59855);
    return false;
  }
  
  public static boolean oy(String paramString)
  {
    AppMethodBeat.i(59856);
    if (paramString != null)
    {
      boolean bool = paramString.equalsIgnoreCase("notifymessage");
      AppMethodBeat.o(59856);
      return bool;
    }
    AppMethodBeat.o(59856);
    return false;
  }
  
  public static boolean oz(String paramString)
  {
    AppMethodBeat.i(59857);
    if (paramString != null)
    {
      boolean bool = paramString.equalsIgnoreCase("notification_messages");
      AppMethodBeat.o(59857);
      return bool;
    }
    AppMethodBeat.o(59857);
    return false;
  }
  
  public static void p(ad paramad)
  {
    AppMethodBeat.i(59814);
    if (paramad != null) {}
    for (boolean bool = true;; bool = false)
    {
      Assert.assertTrue(bool);
      ad localad2 = ((j)g.E(j.class)).YA().arw(paramad.field_username);
      ad localad1;
      if (localad2 != null)
      {
        localad1 = localad2;
        if (!bo.isNullOrNil(localad2.field_username)) {}
      }
      else
      {
        localad1 = paramad;
      }
      localad1.NL();
      if ((ad.arf(paramad.field_username)) && (flb != null)) {
        flb.pj(paramad.field_username);
      }
      u(localad1);
      AppMethodBeat.o(59814);
      return;
    }
  }
  
  public static void q(ad paramad)
  {
    boolean bool2 = true;
    AppMethodBeat.i(59815);
    if (paramad != null)
    {
      bool1 = true;
      Assert.assertTrue("MicroMsg.ContactStorageLogic: user is null", bool1);
      if ((int)paramad.euF == 0) {
        break label97;
      }
      bool1 = true;
      label31:
      Assert.assertTrue("MicroMsg.ContactStorageLogic: contactId == 0", bool1);
      if (paramad.field_username.length() <= 0) {
        break label102;
      }
    }
    label97:
    label102:
    for (boolean bool1 = bool2;; bool1 = false)
    {
      Assert.assertTrue("MicroMsg.ContactStorageLogic: username length <= 0", bool1);
      paramad.Nx();
      ((j)g.E(j.class)).YA().b(paramad.field_username, paramad);
      AppMethodBeat.o(59815);
      return;
      bool1 = false;
      break;
      bool1 = false;
      break label31;
    }
  }
  
  public static void r(ad paramad)
  {
    boolean bool2 = true;
    AppMethodBeat.i(59816);
    if (paramad != null)
    {
      bool1 = true;
      Assert.assertTrue(bool1);
      if ((int)paramad.euF == 0) {
        break label92;
      }
      bool1 = true;
      label28:
      Assert.assertTrue(bool1);
      if (paramad.field_username.length() <= 0) {
        break label97;
      }
    }
    label92:
    label97:
    for (boolean bool1 = bool2;; bool1 = false)
    {
      Assert.assertTrue(bool1);
      paramad.Nx();
      ((j)g.E(j.class)).YA().b(paramad.field_username, paramad);
      u(paramad);
      AppMethodBeat.o(59816);
      return;
      bool1 = false;
      break;
      bool1 = false;
      break label28;
    }
  }
  
  public static void s(ad paramad)
  {
    boolean bool2 = true;
    AppMethodBeat.i(59818);
    if (paramad != null)
    {
      bool1 = true;
      Assert.assertTrue(bool1);
      if ((int)paramad.euF == 0) {
        break label68;
      }
      bool1 = true;
      label28:
      Assert.assertTrue(bool1);
      if (paramad.field_username.length() <= 0) {
        break label73;
      }
    }
    label68:
    label73:
    for (boolean bool1 = bool2;; bool1 = false)
    {
      Assert.assertTrue(bool1);
      paramad.Oc();
      u(paramad);
      AppMethodBeat.o(59818);
      return;
      bool1 = false;
      break;
      bool1 = false;
      break label28;
    }
  }
  
  private static void t(ad paramad)
  {
    AppMethodBeat.i(59819);
    boolean bool;
    bel localbel;
    if (paramad != null)
    {
      bool = true;
      Assert.assertTrue(bool);
      if ((int)paramad.euF == 0)
      {
        ((j)g.E(j.class)).YA().Z(paramad);
        ((j)g.E(j.class)).YA().arw(paramad.field_username);
      }
      ((j)g.E(j.class)).YA().b(paramad.field_username, paramad);
      localbel = new bel();
      localbel.xtI = paramad.field_username;
      if (!paramad.NZ()) {
        break label159;
      }
    }
    label159:
    for (localbel.xtX = 1;; localbel.xtX = 2)
    {
      ((j)g.E(j.class)).Yz().c(new j.a(52, localbel));
      AppMethodBeat.o(59819);
      return;
      bool = false;
      break;
    }
  }
  
  public static void u(ad paramad)
  {
    AppMethodBeat.i(59820);
    if (paramad != null) {}
    for (boolean bool = true;; bool = false)
    {
      Assert.assertTrue(bool);
      if ((int)paramad.euF == 0)
      {
        ((j)g.E(j.class)).YA().Z(paramad);
        ((j)g.E(j.class)).YA().arw(paramad.field_username);
      }
      ((j)g.E(j.class)).YA().b(paramad.field_username, paramad);
      if (!ad.arf(paramad.field_username)) {
        v(paramad);
      }
      AppMethodBeat.o(59820);
      return;
    }
  }
  
  public static void v(ad paramad)
  {
    AppMethodBeat.i(59821);
    ab.i("MicroMsg.ContactStorageLogic", "oplog modContact user:%s remark:%s type:%d ", new Object[] { paramad.field_username, paramad.field_conRemark, Integer.valueOf(paramad.field_type) });
    bdt localbdt = new bdt();
    localbdt.wOT = new bwc().aoF(bo.nullAsNil(paramad.field_username));
    localbdt.xmi = new bwc().aoF(bo.nullAsNil(paramad.field_nickname));
    localbdt.wOv = new bwc().aoF(bo.nullAsNil(paramad.Ht()));
    localbdt.wOw = new bwc().aoF(bo.nullAsNil(paramad.Hu()));
    localbdt.gwP = paramad.dqC;
    localbdt.wNK = 561023;
    localbdt.wNL = paramad.field_type;
    localbdt.xsT = new bwc().aoF(bo.nullAsNil(paramad.field_conRemark));
    localbdt.xsU = new bwc().aoF(bo.nullAsNil(paramad.field_conRemarkPYShort));
    localbdt.xsV = new bwc().aoF(bo.nullAsNil(paramad.field_conRemarkPYFull));
    localbdt.wNQ = paramad.dqH;
    localbdt.xto = new bwc().aoF(bo.nullAsNil(paramad.field_domainList));
    localbdt.wNU = paramad.dqK;
    localbdt.gwT = paramad.dqL;
    localbdt.gwS = bo.nullAsNil(paramad.signature);
    localbdt.gwR = bo.nullAsNil(paramad.getCityCode());
    localbdt.gwQ = bo.nullAsNil(paramad.dwD());
    localbdt.xpg = bo.nullAsNil(paramad.dqO);
    localbdt.xpi = paramad.field_weiboFlag;
    localbdt.xtk = 0;
    localbdt.woT = new SKBuiltinBuffer_t();
    localbdt.gwY = bo.nullAsNil(paramad.getCountryCode());
    ((j)g.E(j.class)).Yz().c(new j.a(2, localbdt));
    AppMethodBeat.o(59821);
  }
  
  public static void w(String paramString, boolean paramBoolean)
  {
    AppMethodBeat.i(59801);
    paramString = ((j)g.E(j.class)).YA().arw(paramString);
    if ((paramString == null) || (bo.isNullOrNil(paramString.field_username)))
    {
      AppMethodBeat.o(59801);
      return;
    }
    if (paramBoolean) {
      paramString.NM();
    }
    for (;;)
    {
      t(paramString);
      AppMethodBeat.o(59801);
      return;
      paramString.NN();
    }
  }
  
  public static boolean w(ad paramad)
  {
    return (paramad.field_weiboFlag & 0x1) != 0;
  }
  
  public static void x(String paramString, boolean paramBoolean)
  {
    AppMethodBeat.i(59810);
    if (!bo.isNullOrNil(paramString)) {}
    ad localad;
    for (boolean bool = true;; bool = false)
    {
      Assert.assertTrue(bool);
      localad = ((j)g.E(j.class)).YA().arw(paramString);
      if ((localad != null) && (!bo.isNullOrNil(localad.field_username))) {
        break;
      }
      AppMethodBeat.o(59810);
      return;
    }
    localad.setType(localad.field_type | 0x800);
    if (((ad.arf(paramString)) || (nK(paramString))) && (flb != null)) {
      flb.pc(paramString);
    }
    u(localad);
    if (paramBoolean) {
      ((j)g.E(j.class)).YF().arN(paramString);
    }
    AppMethodBeat.o(59810);
  }
  
  public static void y(String paramString, boolean paramBoolean)
  {
    AppMethodBeat.i(59812);
    if (!bo.isNullOrNil(paramString)) {}
    ad localad;
    for (boolean bool = true;; bool = false)
    {
      Assert.assertTrue(bool);
      localad = ((j)g.E(j.class)).YA().arw(paramString);
      if ((localad != null) && (!bo.isNullOrNil(localad.field_username))) {
        break;
      }
      AppMethodBeat.o(59812);
      return;
    }
    localad.setType(localad.field_type & 0xFFFFF7FF);
    if (((ad.arf(paramString)) || (nK(paramString))) && (flb != null)) {
      flb.pd(paramString);
    }
    u(localad);
    if (paramBoolean) {
      ((j)g.E(j.class)).YF().arO(paramString);
    }
    AppMethodBeat.o(59812);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.model.t
 * JD-Core Version:    0.7.0.1
 */