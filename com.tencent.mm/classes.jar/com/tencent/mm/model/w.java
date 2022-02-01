package com.tencent.mm.model;

import android.database.Cursor;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.c.au;
import com.tencent.mm.g.c.ay;
import com.tencent.mm.kernel.e;
import com.tencent.mm.kernel.g;
import com.tencent.mm.n.b;
import com.tencent.mm.plugin.chatroom.a.c;
import com.tencent.mm.plugin.messenger.foundation.a.a.i;
import com.tencent.mm.plugin.messenger.foundation.a.a.j.a;
import com.tencent.mm.plugin.messenger.foundation.a.r;
import com.tencent.mm.protocal.protobuf.SKBuiltinBuffer_t;
import com.tencent.mm.protocal.protobuf.bqj;
import com.tencent.mm.protocal.protobuf.brd;
import com.tencent.mm.protocal.protobuf.bre;
import com.tencent.mm.protocal.protobuf.cmf;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.storage.ab;
import com.tencent.mm.storage.af;
import com.tencent.mm.storage.am;
import com.tencent.mm.storage.bg;
import com.tencent.mm.storage.bh;
import com.tencent.mm.storage.br;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import junit.framework.Assert;

public final class w
{
  private static ak gMm;
  public static final String gMn;
  public static final String gMo;
  public static final String gMp;
  public static final String gMq;
  public static final String gMr;
  public static final String gMs;
  public static final String gMt;
  public static final String gMu;
  public static final String gMv;
  public static final String[] gMw;
  
  static
  {
    AppMethodBeat.i(42931);
    gMm = null;
    gMn = b("rconversation.username", new String[] { "@im.chatroom", "@chatroom", "@openim", "@micromsg.qq.com" });
    gMo = b("rconversation.username", new String[] { "@chatroom", "@micromsg.qq.com" });
    gMp = b("rconversation.username", new String[] { "@t.qq.com" });
    gMq = b("rconversation.username", new String[] { "@qqim" });
    gMr = b("rconversation.username", new String[] { "@chatroom_exclusive" });
    gMs = b("rconversation.username", new String[] { "@micromsg.qq.com" });
    gMt = b("rconversation.username", new String[] { "@app" });
    gMu = b("rconversation.username", new String[] { "@chatroom" });
    gMv = b("rconversation.username", new String[] { "@im.chatroom" });
    gMw = new String[] { "qqmail", "fmessage", "tmessage", "qmessage", "qqsync", "floatbottle", "lbsapp", "shakeapp", "medianote", "qqfriend", "newsapp", "blogapp", "facebookapp", "topstoryapp", "masssendapp", "feedsapp", "voipapp", "cardpackage", "voicevoipapp", "voiceinputapp", "officialaccounts", "linkedinplugin", "notifymessage", "appbrandcustomerservicemsg", "appbrand_notify_message" };
    AppMethodBeat.o(42931);
  }
  
  public static bqj A(af paramaf)
  {
    AppMethodBeat.i(186476);
    ad.i("MicroMsg.ContactStorageLogic", "oplog modContact user:%s remark:%s type:%d ", new Object[] { paramaf.field_username, paramaf.field_conRemark, Integer.valueOf(paramaf.field_type) });
    bqj localbqj = new bqj();
    localbqj.Dby = new cmf().aEE(bt.nullAsNil(paramaf.field_username));
    localbqj.DFJ = new cmf().aEE(bt.nullAsNil(paramaf.field_nickname));
    localbqj.Dbb = new cmf().aEE(bt.nullAsNil(paramaf.Sv()));
    localbqj.Dbc = new cmf().aEE(bt.nullAsNil(paramaf.Sw()));
    localbqj.ijM = paramaf.evp;
    localbqj.Dan = 9015167;
    localbqj.Dao = paramaf.field_type;
    localbqj.DNT = new cmf().aEE(bt.nullAsNil(paramaf.field_conRemark));
    localbqj.DNU = new cmf().aEE(bt.nullAsNil(paramaf.field_conRemarkPYShort));
    localbqj.DNV = new cmf().aEE(bt.nullAsNil(paramaf.field_conRemarkPYFull));
    localbqj.Dat = paramaf.evu;
    localbqj.DOn = new cmf().aEE(bt.nullAsNil(paramaf.field_domainList));
    localbqj.Dax = paramaf.evx;
    localbqj.ijQ = paramaf.evy;
    localbqj.ijP = bt.nullAsNil(paramaf.signature);
    localbqj.ijO = bt.nullAsNil(paramaf.getCityCode());
    localbqj.ijN = bt.nullAsNil(paramaf.eKG());
    localbqj.DIX = bt.nullAsNil(paramaf.evD);
    localbqj.DIZ = paramaf.field_weiboFlag;
    localbqj.DOj = 0;
    localbqj.CxB = new SKBuiltinBuffer_t();
    localbqj.ijV = bt.nullAsNil(paramaf.getCountryCode());
    AppMethodBeat.o(186476);
    return localbqj;
  }
  
  public static void B(af paramaf)
  {
    AppMethodBeat.i(42874);
    ((com.tencent.mm.plugin.messenger.foundation.a.k)g.ab(com.tencent.mm.plugin.messenger.foundation.a.k.class)).apL().c(new j.a(2, A(paramaf)));
    AppMethodBeat.o(42874);
  }
  
  public static void B(String paramString, boolean paramBoolean)
  {
    AppMethodBeat.i(42853);
    paramString = ((com.tencent.mm.plugin.messenger.foundation.a.k)g.ab(com.tencent.mm.plugin.messenger.foundation.a.k.class)).apM().aHY(paramString);
    if ((paramString == null) || (bt.isNullOrNil(paramString.field_username)))
    {
      AppMethodBeat.o(42853);
      return;
    }
    if (paramBoolean) {
      paramString.Zz();
    }
    for (;;)
    {
      x(paramString);
      AppMethodBeat.o(42853);
      return;
      paramString.ZA();
    }
  }
  
  public static void C(String paramString, boolean paramBoolean)
  {
    AppMethodBeat.i(42862);
    if (!bt.isNullOrNil(paramString)) {}
    af localaf;
    for (boolean bool = true;; bool = false)
    {
      Assert.assertTrue(bool);
      localaf = ((com.tencent.mm.plugin.messenger.foundation.a.k)g.ab(com.tencent.mm.plugin.messenger.foundation.a.k.class)).apM().aHY(paramString);
      if ((localaf != null) && (!bt.isNullOrNil(localaf.field_username))) {
        break;
      }
      AppMethodBeat.o(42862);
      return;
    }
    localaf.setType(localaf.field_type | 0x800);
    if (((af.aHH(paramString)) || (sn(paramString))) && (gMm != null)) {
      gMm.tP(paramString);
    }
    z(localaf);
    if (paramBoolean) {
      ((com.tencent.mm.plugin.messenger.foundation.a.k)g.ab(com.tencent.mm.plugin.messenger.foundation.a.k.class)).apR().aIt(paramString);
    }
    AppMethodBeat.o(42862);
  }
  
  public static boolean C(af paramaf)
  {
    return (paramaf.field_weiboFlag & 0x1) != 0;
  }
  
  public static void D(String paramString, boolean paramBoolean)
  {
    AppMethodBeat.i(42864);
    if (!bt.isNullOrNil(paramString)) {}
    af localaf;
    for (boolean bool = true;; bool = false)
    {
      Assert.assertTrue(bool);
      localaf = ((com.tencent.mm.plugin.messenger.foundation.a.k)g.ab(com.tencent.mm.plugin.messenger.foundation.a.k.class)).apM().aHY(paramString);
      if ((localaf != null) && (!bt.isNullOrNil(localaf.field_username))) {
        break;
      }
      AppMethodBeat.o(42864);
      return;
    }
    localaf.setType(localaf.field_type & 0xFFFFF7FF);
    if (((af.aHH(paramString)) || (sn(paramString))) && (gMm != null)) {
      gMm.tQ(paramString);
    }
    z(localaf);
    if (paramBoolean) {
      ((com.tencent.mm.plugin.messenger.foundation.a.k)g.ab(com.tencent.mm.plugin.messenger.foundation.a.k.class)).apR().aIu(paramString);
    }
    AppMethodBeat.o(42864);
  }
  
  public static void a(ak paramak)
  {
    gMm = paramak;
  }
  
  public static boolean a(am paramam)
  {
    AppMethodBeat.i(42926);
    String str = paramam.field_username;
    if (to(str))
    {
      AppMethodBeat.o(42926);
      return false;
    }
    if (tl(str))
    {
      AppMethodBeat.o(42926);
      return false;
    }
    if (td(str))
    {
      AppMethodBeat.o(42926);
      return false;
    }
    if (te(str))
    {
      AppMethodBeat.o(42926);
      return false;
    }
    if (paramam.field_conversationTime == -1L)
    {
      AppMethodBeat.o(42926);
      return false;
    }
    if (sE(str))
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
    int[] arrayOfInt = ((com.tencent.mm.plugin.messenger.foundation.a.k)g.ab(com.tencent.mm.plugin.messenger.foundation.a.k.class)).apM().b(paramString1, paramString2, paramArrayOfString, paramList);
    if (arrayOfInt.length <= 0)
    {
      AppMethodBeat.o(42878);
      return null;
    }
    paramString1 = ((com.tencent.mm.plugin.messenger.foundation.a.k)g.ab(com.tencent.mm.plugin.messenger.foundation.a.k.class)).apM().c(paramString1, paramString2, paramArrayOfString, paramList);
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
    AppMethodBeat.i(186477);
    long l = System.currentTimeMillis();
    int[] arrayOfInt = ((com.tencent.mm.plugin.messenger.foundation.a.k)g.ab(com.tencent.mm.plugin.messenger.foundation.a.k.class)).apM().b(paramArrayOfString, paramString1, paramString2, paramString3, paramList);
    ad.d("MicroMsg.ContactStorageLogic", "kevin service(IMessengerStorage.class).getContactStg().getShowHeadDistinct(" + (System.currentTimeMillis() - l));
    if (arrayOfInt.length <= 0)
    {
      AppMethodBeat.o(186477);
      return null;
    }
    l = System.currentTimeMillis();
    paramArrayOfString = ((com.tencent.mm.plugin.messenger.foundation.a.k)g.ab(com.tencent.mm.plugin.messenger.foundation.a.k.class)).apM().c(paramArrayOfString, paramString1, paramString2, paramString3, paramList);
    ad.d("MicroMsg.ContactStorageLogic", "kevin service(IMessengerStorage.class).getContactStg().getSectionNumByShowHead" + (System.currentTimeMillis() - l));
    if (paramArrayOfString == null)
    {
      AppMethodBeat.o(186477);
      return null;
    }
    if (arrayOfInt.length != paramArrayOfString.length)
    {
      ad.e("MicroMsg.ContactStorageLogic", "[%s:%s] filterType:%s filterSearchStr:%s blocklist:%s searchString:%s", new Object[] { Integer.valueOf(arrayOfInt.length), Integer.valueOf(paramArrayOfString.length), paramString1, paramString2, paramList, paramString3 });
      AppMethodBeat.o(186477);
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
    AppMethodBeat.o(186477);
    return paramString1;
  }
  
  public static String[] a(String paramString1, String paramString2, String[] paramArrayOfString, List<String> paramList)
  {
    AppMethodBeat.i(42879);
    long l = System.currentTimeMillis();
    paramString1 = ((com.tencent.mm.plugin.messenger.foundation.a.k)g.ab(com.tencent.mm.plugin.messenger.foundation.a.k.class)).apM().b(paramString1, paramString2, paramArrayOfString, paramList);
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
    AppMethodBeat.i(186478);
    long l = System.currentTimeMillis();
    paramArrayOfString = ((com.tencent.mm.plugin.messenger.foundation.a.k)g.ab(com.tencent.mm.plugin.messenger.foundation.a.k.class)).apM().b(paramArrayOfString, paramString1, paramString2, paramString3, paramList);
    ad.d("MicroMsg.ContactStorageLogic", "kevin service(IMessengerStorage.class).getContactStg().getShowSectionByShowHead" + (System.currentTimeMillis() - l));
    if (paramArrayOfString.length <= 0)
    {
      AppMethodBeat.o(186478);
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
    AppMethodBeat.o(186478);
    return paramString1;
  }
  
  public static int[] ai(List<String> paramList)
  {
    AppMethodBeat.i(42877);
    long l = System.currentTimeMillis();
    int[] arrayOfInt1 = ((com.tencent.mm.plugin.messenger.foundation.a.k)g.ab(com.tencent.mm.plugin.messenger.foundation.a.k.class)).apM().hi(paramList);
    ad.d("MicroMsg.ContactStorageLogic", "kevin service(IMessengerStorage.class).getContactStg().getShowHeadDistinct(" + (System.currentTimeMillis() - l));
    if (arrayOfInt1.length <= 0)
    {
      AppMethodBeat.o(42877);
      return null;
    }
    l = System.currentTimeMillis();
    paramList = ((com.tencent.mm.plugin.messenger.foundation.a.k)g.ab(com.tencent.mm.plugin.messenger.foundation.a.k.class)).apM().hj(paramList);
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
  
  public static String[] aj(List<String> paramList)
  {
    AppMethodBeat.i(42881);
    long l = System.currentTimeMillis();
    paramList = ((com.tencent.mm.plugin.messenger.foundation.a.k)g.ab(com.tencent.mm.plugin.messenger.foundation.a.k.class)).apM().hi(paramList);
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
  
  public static List<String> arr()
  {
    AppMethodBeat.i(42846);
    List localList = ((com.tencent.mm.plugin.messenger.foundation.a.k)g.ab(com.tencent.mm.plugin.messenger.foundation.a.k.class)).apM().eKO();
    AppMethodBeat.o(42846);
    return localList;
  }
  
  public static List<af> ars()
  {
    AppMethodBeat.i(42847);
    ArrayList localArrayList = new ArrayList();
    Cursor localCursor = ((com.tencent.mm.plugin.messenger.foundation.a.k)g.ab(com.tencent.mm.plugin.messenger.foundation.a.k.class)).apM().eKP();
    if (localCursor.moveToFirst()) {
      do
      {
        af localaf = new af();
        localaf.convertFrom(localCursor);
        localArrayList.add(localaf);
      } while (localCursor.moveToNext());
    }
    localCursor.close();
    AppMethodBeat.o(42847);
    return localArrayList;
  }
  
  public static boolean art()
  {
    return false;
  }
  
  public static boolean aru()
  {
    AppMethodBeat.i(42922);
    if (!u.arn())
    {
      AppMethodBeat.o(42922);
      return false;
    }
    br localbr = ((com.tencent.mm.plugin.messenger.foundation.a.k)g.ab(com.tencent.mm.plugin.messenger.foundation.a.k.class)).apU().agP("@t.qq.com");
    if ((localbr == null) || (bt.isNullOrNil(localbr.name)))
    {
      AppMethodBeat.o(42922);
      return false;
    }
    AppMethodBeat.o(42922);
    return true;
  }
  
  public static boolean arv()
  {
    AppMethodBeat.i(42923);
    if (!u.arn())
    {
      AppMethodBeat.o(42923);
      return false;
    }
    br localbr = ((com.tencent.mm.plugin.messenger.foundation.a.k)g.ab(com.tencent.mm.plugin.messenger.foundation.a.k.class)).apU().agP("@t.qq.com");
    if ((localbr == null) || (bt.nullAsNil(localbr.name).length() == 0))
    {
      AppMethodBeat.o(42923);
      return false;
    }
    AppMethodBeat.o(42923);
    return true;
  }
  
  public static List<af> arw()
  {
    AppMethodBeat.i(42924);
    LinkedList localLinkedList = new LinkedList();
    Cursor localCursor = ((com.tencent.mm.plugin.messenger.foundation.a.k)g.ab(com.tencent.mm.plugin.messenger.foundation.a.k.class)).apM().eKS();
    if (localCursor.getCount() == 0)
    {
      localCursor.close();
      AppMethodBeat.o(42924);
      return localLinkedList;
    }
    localCursor.moveToFirst();
    do
    {
      af localaf = new af();
      localaf.convertFrom(localCursor);
      localLinkedList.add(localaf);
    } while (localCursor.moveToNext());
    localCursor.close();
    ad.d("MicroMsg.ContactStorageLogic", "getFavourList size:  " + localLinkedList.size());
    AppMethodBeat.o(42924);
    return localLinkedList;
  }
  
  public static List<String> arx()
  {
    AppMethodBeat.i(42925);
    LinkedList localLinkedList = new LinkedList();
    Cursor localCursor = ((com.tencent.mm.plugin.messenger.foundation.a.k)g.ab(com.tencent.mm.plugin.messenger.foundation.a.k.class)).apM().eKQ();
    if (localCursor.getCount() == 0)
    {
      localCursor.close();
      AppMethodBeat.o(42925);
      return localLinkedList;
    }
    localCursor.moveToFirst();
    do
    {
      af localaf = new af();
      localaf.convertFrom(localCursor);
      localLinkedList.add(localaf.field_username);
    } while (localCursor.moveToNext());
    localCursor.close();
    ad.d("MicroMsg.ContactStorageLogic", "getSnsBlackContactList size:  " + localLinkedList.size());
    AppMethodBeat.o(42925);
    return localLinkedList;
  }
  
  public static int ary()
  {
    AppMethodBeat.i(42928);
    int i = ((com.tencent.mm.plugin.messenger.foundation.a.k)g.ab(com.tencent.mm.plugin.messenger.foundation.a.k.class)).apM().c(gMw, new String[] { u.aqG(), "weixin", "helper_entry", "filehelper" });
    AppMethodBeat.o(42928);
    return i;
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
  
  public static boolean b(am paramam)
  {
    AppMethodBeat.i(42927);
    paramam = paramam.field_username;
    if (td(paramam))
    {
      AppMethodBeat.o(42927);
      return false;
    }
    if (tm(paramam))
    {
      AppMethodBeat.o(42927);
      return false;
    }
    if (tn(paramam))
    {
      AppMethodBeat.o(42927);
      return false;
    }
    AppMethodBeat.o(42927);
    return true;
  }
  
  public static void c(af paramaf, String paramString)
  {
    AppMethodBeat.i(42869);
    af localaf = ((com.tencent.mm.plugin.messenger.foundation.a.k)g.ab(com.tencent.mm.plugin.messenger.foundation.a.k.class)).apM().aHY(paramaf.field_username);
    if ((localaf != null) && (paramString != null)) {}
    for (boolean bool = true;; bool = false)
    {
      Assert.assertTrue(bool);
      localaf.nb(paramString);
      if ((af.aHH(paramaf.field_username)) && (gMm != null)) {
        gMm.aA(paramaf.field_username, paramString);
      }
      z(localaf);
      AppMethodBeat.o(42869);
      return;
    }
  }
  
  public static boolean i(af paramaf)
  {
    AppMethodBeat.i(42840);
    if (paramaf == null)
    {
      AppMethodBeat.o(42840);
      return false;
    }
    if (!sl(paramaf.field_username))
    {
      AppMethodBeat.o(42840);
      return false;
    }
    if (!b.ls(paramaf.field_type))
    {
      AppMethodBeat.o(42840);
      return false;
    }
    AppMethodBeat.o(42840);
    return true;
  }
  
  public static void j(af paramaf)
  {
    AppMethodBeat.i(42852);
    boolean bool;
    af localaf2;
    if (paramaf != null)
    {
      bool = true;
      Assert.assertTrue(bool);
      localaf2 = ((com.tencent.mm.plugin.messenger.foundation.a.k)g.ab(com.tencent.mm.plugin.messenger.foundation.a.k.class)).apM().aHY(paramaf.field_username);
      localaf1 = paramaf;
      if (localaf2 != null) {
        if (!bt.isNullOrNil(localaf2.field_username)) {
          break label78;
        }
      }
    }
    label78:
    for (af localaf1 = paramaf;; localaf1 = localaf2)
    {
      localaf1.Zq();
      z(localaf1);
      AppMethodBeat.o(42852);
      return;
      bool = false;
      break;
    }
  }
  
  public static void k(af paramaf)
  {
    AppMethodBeat.i(42854);
    boolean bool;
    af localaf2;
    if (paramaf != null)
    {
      bool = true;
      Assert.assertTrue(bool);
      localaf2 = ((com.tencent.mm.plugin.messenger.foundation.a.k)g.ab(com.tencent.mm.plugin.messenger.foundation.a.k.class)).apM().aHY(paramaf.field_username);
      localaf1 = paramaf;
      if (localaf2 != null) {
        if (!bt.isNullOrNil(localaf2.field_username)) {
          break label78;
        }
      }
    }
    label78:
    for (af localaf1 = paramaf;; localaf1 = localaf2)
    {
      localaf1.Zo();
      z(localaf1);
      AppMethodBeat.o(42854);
      return;
      bool = false;
      break;
    }
  }
  
  public static void l(af paramaf)
  {
    AppMethodBeat.i(42855);
    boolean bool;
    af localaf2;
    if (paramaf != null)
    {
      bool = true;
      Assert.assertTrue(bool);
      localaf2 = ((com.tencent.mm.plugin.messenger.foundation.a.k)g.ab(com.tencent.mm.plugin.messenger.foundation.a.k.class)).apM().aHY(paramaf.field_username);
      localaf1 = paramaf;
      if (localaf2 != null) {
        if (!bt.isNullOrNil(localaf2.field_username)) {
          break label78;
        }
      }
    }
    label78:
    for (af localaf1 = paramaf;; localaf1 = localaf2)
    {
      localaf1.Zp();
      z(localaf1);
      AppMethodBeat.o(42855);
      return;
      bool = false;
      break;
    }
  }
  
  public static void m(af paramaf)
  {
    AppMethodBeat.i(42856);
    if (paramaf != null) {}
    for (boolean bool = true;; bool = false)
    {
      Assert.assertTrue(bool);
      af localaf2 = ((com.tencent.mm.plugin.messenger.foundation.a.k)g.ab(com.tencent.mm.plugin.messenger.foundation.a.k.class)).apM().aHY(paramaf.field_username);
      af localaf1;
      if (localaf2 != null)
      {
        localaf1 = localaf2;
        if (!bt.isNullOrNil(localaf2.field_username)) {}
      }
      else
      {
        localaf1 = paramaf;
      }
      localaf1.Zm();
      if ((af.aHH(paramaf.field_username)) && (gMm != null)) {
        gMm.tR(paramaf.field_username);
      }
      z(localaf1);
      AppMethodBeat.o(42856);
      return;
    }
  }
  
  public static boolean mZ(int paramInt)
  {
    AppMethodBeat.i(42851);
    boolean bool = af.Wy(paramInt);
    AppMethodBeat.o(42851);
    return bool;
  }
  
  public static void n(af paramaf)
  {
    AppMethodBeat.i(42857);
    if (paramaf != null) {}
    for (boolean bool = true;; bool = false)
    {
      Assert.assertTrue(bool);
      af localaf2 = ((com.tencent.mm.plugin.messenger.foundation.a.k)g.ab(com.tencent.mm.plugin.messenger.foundation.a.k.class)).apM().aHY(paramaf.field_username);
      af localaf1;
      if (localaf2 != null)
      {
        localaf1 = localaf2;
        if (!bt.isNullOrNil(localaf2.field_username)) {}
      }
      else
      {
        localaf1 = paramaf;
      }
      localaf1.Zn();
      if ((af.aHH(paramaf.field_username)) && (gMm != null)) {
        gMm.tS(paramaf.field_username);
      }
      z(localaf1);
      paramaf = ((com.tencent.mm.plugin.messenger.foundation.a.k)g.ab(com.tencent.mm.plugin.messenger.foundation.a.k.class)).apR().aIn(paramaf.field_username);
      if ((paramaf != null) && ("@blacklist".equals(paramaf.field_parentRef))) {
        ((com.tencent.mm.plugin.messenger.foundation.a.k)g.ab(com.tencent.mm.plugin.messenger.foundation.a.k.class)).apR().c(new String[] { paramaf.field_username }, "");
      }
      AppMethodBeat.o(42857);
      return;
    }
  }
  
  public static void o(af paramaf)
  {
    AppMethodBeat.i(42858);
    if (paramaf != null) {}
    for (boolean bool = true;; bool = false)
    {
      Assert.assertTrue(bool);
      af localaf2 = ((com.tencent.mm.plugin.messenger.foundation.a.k)g.ab(com.tencent.mm.plugin.messenger.foundation.a.k.class)).apM().aHY(paramaf.field_username);
      af localaf1;
      if (localaf2 != null)
      {
        localaf1 = localaf2;
        if (!bt.isNullOrNil(localaf2.field_username)) {}
      }
      else
      {
        localaf1 = paramaf;
      }
      localaf1.Zz();
      localaf1.jD(paramaf.Zh());
      x(localaf1);
      AppMethodBeat.o(42858);
      return;
    }
  }
  
  public static void p(af paramaf)
  {
    AppMethodBeat.i(42859);
    if (paramaf != null) {}
    for (boolean bool = true;; bool = false)
    {
      Assert.assertTrue(bool);
      af localaf2 = ((com.tencent.mm.plugin.messenger.foundation.a.k)g.ab(com.tencent.mm.plugin.messenger.foundation.a.k.class)).apM().aHY(paramaf.field_username);
      af localaf1;
      if (localaf2 != null)
      {
        localaf1 = localaf2;
        if (!bt.isNullOrNil(localaf2.field_username)) {}
      }
      else
      {
        localaf1 = paramaf;
      }
      localaf1.ZA();
      localaf1.jD(paramaf.Zh());
      x(localaf1);
      AppMethodBeat.o(42859);
      return;
    }
  }
  
  public static boolean pF(String paramString)
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
  
  public static void q(af paramaf)
  {
    AppMethodBeat.i(42860);
    if (paramaf != null) {}
    for (boolean bool = true;; bool = false)
    {
      Assert.assertTrue(bool);
      af localaf2 = ((com.tencent.mm.plugin.messenger.foundation.a.k)g.ab(com.tencent.mm.plugin.messenger.foundation.a.k.class)).apM().aHY(paramaf.field_username);
      af localaf1;
      if (localaf2 != null)
      {
        localaf1 = localaf2;
        if (!bt.isNullOrNil(localaf2.field_username)) {}
      }
      else
      {
        localaf1 = paramaf;
      }
      localaf1.Zv();
      localaf1.jD(paramaf.Zh());
      if ((af.aHH(paramaf.field_username)) && (gMm != null)) {
        gMm.tT(paramaf.field_username);
      }
      z(localaf1);
      AppMethodBeat.o(42860);
      return;
    }
  }
  
  public static void r(af paramaf)
  {
    AppMethodBeat.i(42861);
    if (paramaf != null) {}
    for (boolean bool = true;; bool = false)
    {
      Assert.assertTrue(bool);
      af localaf2 = ((com.tencent.mm.plugin.messenger.foundation.a.k)g.ab(com.tencent.mm.plugin.messenger.foundation.a.k.class)).apM().aHY(paramaf.field_username);
      af localaf1;
      if (localaf2 != null)
      {
        localaf1 = localaf2;
        if (!bt.isNullOrNil(localaf2.field_username)) {}
      }
      else
      {
        localaf1 = paramaf;
      }
      localaf1.Zw();
      localaf1.jD(paramaf.Zh());
      if ((af.aHH(paramaf.field_username)) && (gMm != null)) {
        gMm.tU(paramaf.field_username);
      }
      z(localaf1);
      AppMethodBeat.o(42861);
      return;
    }
  }
  
  public static void s(af paramaf)
  {
    AppMethodBeat.i(42865);
    if (paramaf != null) {}
    for (boolean bool = true;; bool = false)
    {
      Assert.assertTrue(bool);
      af localaf2 = ((com.tencent.mm.plugin.messenger.foundation.a.k)g.ab(com.tencent.mm.plugin.messenger.foundation.a.k.class)).apM().aHY(paramaf.field_username);
      af localaf1;
      if (localaf2 != null)
      {
        localaf1 = localaf2;
        if (!bt.isNullOrNil(localaf2.field_username)) {}
      }
      else
      {
        localaf1 = paramaf;
      }
      localaf1.Zx();
      if ((af.aHH(paramaf.field_username)) && (gMm != null)) {
        gMm.tV(paramaf.field_username);
      }
      z(localaf1);
      AppMethodBeat.o(42865);
      return;
    }
  }
  
  public static boolean sA(String paramString)
  {
    AppMethodBeat.i(42843);
    boolean bool = "downloaderapp".equals(paramString);
    AppMethodBeat.o(42843);
    return bool;
  }
  
  public static boolean sB(String paramString)
  {
    AppMethodBeat.i(42844);
    if ((paramString == null) || (paramString.length() <= 0))
    {
      AppMethodBeat.o(42844);
      return false;
    }
    if (!sl(paramString))
    {
      AppMethodBeat.o(42844);
      return false;
    }
    paramString = ((com.tencent.mm.plugin.messenger.foundation.a.k)g.ab(com.tencent.mm.plugin.messenger.foundation.a.k.class)).apM().aHY(paramString);
    if ((paramString == null) || (!b.ls(paramString.field_type)))
    {
      AppMethodBeat.o(42844);
      return false;
    }
    AppMethodBeat.o(42844);
    return true;
  }
  
  public static boolean sC(String paramString)
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
  
  public static boolean sD(String paramString)
  {
    AppMethodBeat.i(42849);
    if ((paramString == null) || (paramString.length() <= 0))
    {
      AppMethodBeat.o(42849);
      return true;
    }
    boolean bool = b.ls(((com.tencent.mm.plugin.messenger.foundation.a.k)g.ab(com.tencent.mm.plugin.messenger.foundation.a.k.class)).apM().aHY(paramString).field_type);
    AppMethodBeat.o(42849);
    return bool;
  }
  
  public static boolean sE(String paramString)
  {
    AppMethodBeat.i(42850);
    if (bt.isNullOrNil(paramString))
    {
      AppMethodBeat.o(42850);
      return false;
    }
    paramString = ((com.tencent.mm.plugin.messenger.foundation.a.k)g.ab(com.tencent.mm.plugin.messenger.foundation.a.k.class)).apM().aHY(paramString);
    if (paramString == null)
    {
      AppMethodBeat.o(42850);
      return false;
    }
    boolean bool = af.Wy(paramString.field_verifyFlag);
    AppMethodBeat.o(42850);
    return bool;
  }
  
  public static void sF(String paramString)
  {
    AppMethodBeat.i(42863);
    am localam2 = ((com.tencent.mm.plugin.messenger.foundation.a.k)g.ab(com.tencent.mm.plugin.messenger.foundation.a.k.class)).apR().aIn(paramString);
    int i = 0;
    am localam1 = localam2;
    if (localam2 == null)
    {
      localam1 = new am();
      localam1.eLf();
      i = 1;
      localam1.setUsername(paramString);
    }
    localam1.kS(System.currentTimeMillis());
    if (i != 0)
    {
      ((com.tencent.mm.plugin.messenger.foundation.a.k)g.ab(com.tencent.mm.plugin.messenger.foundation.a.k.class)).apR().e(localam1);
      AppMethodBeat.o(42863);
      return;
    }
    ((com.tencent.mm.plugin.messenger.foundation.a.k)g.ab(com.tencent.mm.plugin.messenger.foundation.a.k.class)).apR().a(localam1, paramString);
    AppMethodBeat.o(42863);
  }
  
  public static void sG(String paramString)
  {
    AppMethodBeat.i(42875);
    if (bt.isNullOrNil(paramString))
    {
      AppMethodBeat.o(42875);
      return;
    }
    af localaf = ((com.tencent.mm.plugin.messenger.foundation.a.k)g.ab(com.tencent.mm.plugin.messenger.foundation.a.k.class)).apM().aHY(paramString);
    if (localaf == null)
    {
      AppMethodBeat.o(42875);
      return;
    }
    localaf.setSource(0);
    localaf.Zi();
    ((com.tencent.mm.plugin.messenger.foundation.a.k)g.ab(com.tencent.mm.plugin.messenger.foundation.a.k.class)).apM().c(paramString, localaf);
    AppMethodBeat.o(42875);
  }
  
  public static boolean sH(String paramString)
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
  
  public static boolean sI(String paramString)
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
  
  public static boolean sJ(String paramString)
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
  
  public static boolean sK(String paramString)
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
  
  public static boolean sL(String paramString)
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
  
  public static boolean sM(String paramString)
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
  
  public static boolean sN(String paramString)
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
  
  public static boolean sO(String paramString)
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
  
  public static boolean sP(String paramString)
  {
    AppMethodBeat.i(42890);
    boolean bool = "qqsync".equalsIgnoreCase(paramString);
    AppMethodBeat.o(42890);
    return bool;
  }
  
  public static boolean sQ(String paramString)
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
  
  public static boolean sR(String paramString)
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
  
  public static boolean sS(String paramString)
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
  
  public static boolean sT(String paramString)
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
  
  public static boolean sU(String paramString)
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
  
  public static boolean sV(String paramString)
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
  
  public static boolean sW(String paramString)
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
  
  public static boolean sX(String paramString)
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
  
  public static boolean sY(String paramString)
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
  
  public static boolean sZ(String paramString)
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
  
  public static boolean sk(String paramString)
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
  
  public static boolean sl(String paramString)
  {
    AppMethodBeat.i(42832);
    if ((sm(paramString)) || (sn(paramString)))
    {
      AppMethodBeat.o(42832);
      return true;
    }
    AppMethodBeat.o(42832);
    return false;
  }
  
  public static boolean sm(String paramString)
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
  
  public static boolean sn(String paramString)
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
  
  public static boolean so(String paramString)
  {
    AppMethodBeat.i(178864);
    if ((paramString == null) || (paramString.length() <= 0))
    {
      AppMethodBeat.o(178864);
      return false;
    }
    if ((paramString.endsWith("@im.chatroom")) || (sp(paramString)))
    {
      AppMethodBeat.o(178864);
      return true;
    }
    AppMethodBeat.o(178864);
    return false;
  }
  
  public static boolean sp(String paramString)
  {
    AppMethodBeat.i(178865);
    if (sm(paramString))
    {
      paramString = ((c)g.ab(c.class)).apV().tH(paramString);
      if ((paramString != null) && ((paramString.field_chatroomStatus & 0x20000) == 131072))
      {
        AppMethodBeat.o(178865);
        return true;
      }
    }
    AppMethodBeat.o(178865);
    return false;
  }
  
  public static boolean sq(String paramString)
  {
    AppMethodBeat.i(178866);
    if (sm(paramString))
    {
      paramString = ((c)g.ab(c.class)).apV().tH(paramString);
      if ((paramString != null) && ((paramString.field_chatroomStatus & 0x20000) != 131072) && ((paramString.field_chatroomStatus & 0x10000) == 65536))
      {
        AppMethodBeat.o(178866);
        return true;
      }
    }
    AppMethodBeat.o(178866);
    return false;
  }
  
  public static boolean sr(String paramString)
  {
    AppMethodBeat.i(178867);
    if ((((r)g.ab(r.class)).UQ()) && (sm(paramString)))
    {
      paramString = ((c)g.ab(c.class)).apV().tH(paramString);
      if ((paramString != null) && (paramString.Vq()))
      {
        AppMethodBeat.o(178867);
        return true;
      }
    }
    AppMethodBeat.o(178867);
    return false;
  }
  
  public static boolean ss(String paramString)
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
  
  public static boolean st(String paramString)
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
  
  public static boolean su(String paramString)
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
  
  public static boolean sv(String paramString)
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
  
  public static boolean sw(String paramString)
  {
    AppMethodBeat.i(42841);
    boolean bool = "gh_43f2581f6fd6".equals(paramString);
    AppMethodBeat.o(42841);
    return bool;
  }
  
  public static boolean sx(String paramString)
  {
    AppMethodBeat.i(42842);
    boolean bool = "gh_3dfda90e39d6".equals(paramString);
    AppMethodBeat.o(42842);
    return bool;
  }
  
  public static boolean sy(String paramString)
  {
    AppMethodBeat.i(186475);
    boolean bool = "gh_f0a92aa7146c".equals(paramString);
    AppMethodBeat.o(186475);
    return bool;
  }
  
  public static boolean sz(String paramString)
  {
    AppMethodBeat.i(163508);
    boolean bool = "1@fackuser".equals(paramString);
    AppMethodBeat.o(163508);
    return bool;
  }
  
  public static void t(af paramaf)
  {
    AppMethodBeat.i(42866);
    if (paramaf != null) {}
    for (boolean bool = true;; bool = false)
    {
      Assert.assertTrue(bool);
      af localaf2 = ((com.tencent.mm.plugin.messenger.foundation.a.k)g.ab(com.tencent.mm.plugin.messenger.foundation.a.k.class)).apM().aHY(paramaf.field_username);
      af localaf1;
      if (localaf2 != null)
      {
        localaf1 = localaf2;
        if (!bt.isNullOrNil(localaf2.field_username)) {}
      }
      else
      {
        localaf1 = paramaf;
      }
      localaf1.Zy();
      if ((af.aHH(paramaf.field_username)) && (gMm != null)) {
        gMm.tW(paramaf.field_username);
      }
      z(localaf1);
      AppMethodBeat.o(42866);
      return;
    }
  }
  
  public static boolean ta(String paramString)
  {
    AppMethodBeat.i(42901);
    boolean bool = tb(paramString);
    AppMethodBeat.o(42901);
    return bool;
  }
  
  public static boolean tb(String paramString)
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
  
  public static boolean tc(String paramString)
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
  
  public static boolean td(String paramString)
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
  
  public static boolean te(String paramString)
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
  
  public static boolean tf(String paramString)
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
  
  public static boolean tg(String paramString)
  {
    AppMethodBeat.i(42907);
    boolean bool = "filehelper".equalsIgnoreCase(paramString);
    AppMethodBeat.o(42907);
    return bool;
  }
  
  public static boolean th(String paramString)
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
  
  public static boolean ti(String paramString)
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
  
  public static boolean tj(String paramString)
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
  
  public static boolean tk(String paramString)
  {
    AppMethodBeat.i(42911);
    if (tl(paramString))
    {
      AppMethodBeat.o(42911);
      return true;
    }
    if (to(paramString))
    {
      AppMethodBeat.o(42911);
      return true;
    }
    if (td(paramString))
    {
      AppMethodBeat.o(42911);
      return true;
    }
    if (te(paramString))
    {
      AppMethodBeat.o(42911);
      return true;
    }
    AppMethodBeat.o(42911);
    return false;
  }
  
  public static boolean tl(String paramString)
  {
    AppMethodBeat.i(42912);
    g.afC();
    String str = (String)g.afB().afk().get(21, null);
    if (((str != null) && (str.equalsIgnoreCase(paramString))) || (paramString.equalsIgnoreCase("weixin")))
    {
      AppMethodBeat.o(42912);
      return true;
    }
    AppMethodBeat.o(42912);
    return false;
  }
  
  public static boolean tm(String paramString)
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
  
  public static boolean tn(String paramString)
  {
    AppMethodBeat.i(186479);
    if (paramString != null)
    {
      boolean bool = paramString.equalsIgnoreCase("appbrand_notify_message");
      AppMethodBeat.o(186479);
      return bool;
    }
    AppMethodBeat.o(186479);
    return false;
  }
  
  public static boolean to(String paramString)
  {
    AppMethodBeat.i(42914);
    String[] arrayOfString = gMw;
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
  
  public static boolean tp(String paramString)
  {
    AppMethodBeat.i(42915);
    if (to(paramString))
    {
      AppMethodBeat.o(42915);
      return true;
    }
    if (af.aHG(paramString))
    {
      AppMethodBeat.o(42915);
      return true;
    }
    if (af.aHE(paramString))
    {
      AppMethodBeat.o(42915);
      return true;
    }
    if (af.st(paramString))
    {
      AppMethodBeat.o(42915);
      return true;
    }
    AppMethodBeat.o(42915);
    return false;
  }
  
  public static int tq(String paramString)
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
    if (af.aHE(paramString))
    {
      AppMethodBeat.o(42916);
      return 11;
    }
    if (af.aHG(paramString))
    {
      AppMethodBeat.o(42916);
      return 36;
    }
    if (af.st(paramString))
    {
      AppMethodBeat.o(42916);
      return 1;
    }
    AppMethodBeat.o(42916);
    return 1;
  }
  
  public static int tr(String paramString)
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
    if (af.aHE(paramString))
    {
      AppMethodBeat.o(42917);
      return 13;
    }
    if (af.aHG(paramString))
    {
      AppMethodBeat.o(42917);
      return 39;
    }
    if (af.st(paramString))
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
  
  public static boolean ts(String paramString)
  {
    AppMethodBeat.i(42918);
    if (((com.tencent.mm.plugin.messenger.foundation.a.k)g.ab(com.tencent.mm.plugin.messenger.foundation.a.k.class)).apM().aHY(paramString).evx != 1)
    {
      AppMethodBeat.o(42918);
      return false;
    }
    AppMethodBeat.o(42918);
    return true;
  }
  
  public static boolean tt(String paramString)
  {
    AppMethodBeat.i(42919);
    paramString = ((com.tencent.mm.plugin.messenger.foundation.a.k)g.ab(com.tencent.mm.plugin.messenger.foundation.a.k.class)).apM().aHY(paramString);
    if ((paramString != null) && (paramString.Ny()))
    {
      AppMethodBeat.o(42919);
      return true;
    }
    AppMethodBeat.o(42919);
    return false;
  }
  
  public static boolean tu(String paramString)
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
  
  public static String tv(String paramString)
  {
    AppMethodBeat.i(42921);
    if (tu(paramString))
    {
      paramString = paramString.replace("http://t.qq.com/", "").replace("t.qq.com/", "");
      AppMethodBeat.o(42921);
      return paramString;
    }
    AppMethodBeat.o(42921);
    return "";
  }
  
  public static boolean tw(String paramString)
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
  
  public static boolean tx(String paramString)
  {
    AppMethodBeat.i(178868);
    paramString = ((c)g.ab(c.class)).apV().tH(paramString);
    if (paramString == null)
    {
      AppMethodBeat.o(178868);
      return false;
    }
    boolean bool = paramString.Vq();
    AppMethodBeat.o(178868);
    return bool;
  }
  
  public static boolean ty(String paramString)
  {
    AppMethodBeat.i(184702);
    paramString = ((c)g.ab(c.class)).apV().tH(paramString);
    if (paramString == null)
    {
      AppMethodBeat.o(184702);
      return false;
    }
    boolean bool = paramString.ty(u.aqG());
    AppMethodBeat.o(184702);
    return bool;
  }
  
  public static void u(af paramaf)
  {
    boolean bool2 = true;
    AppMethodBeat.i(42867);
    if (paramaf != null)
    {
      bool1 = true;
      Assert.assertTrue("MicroMsg.ContactStorageLogic: user is null", bool1);
      if ((int)paramaf.fId == 0) {
        break label98;
      }
      bool1 = true;
      label31:
      Assert.assertTrue("MicroMsg.ContactStorageLogic: contactId == 0", bool1);
      if (paramaf.field_username.length() <= 0) {
        break label103;
      }
    }
    label98:
    label103:
    for (boolean bool1 = bool2;; bool1 = false)
    {
      Assert.assertTrue("MicroMsg.ContactStorageLogic: username length <= 0", bool1);
      paramaf.Zk();
      ((com.tencent.mm.plugin.messenger.foundation.a.k)g.ab(com.tencent.mm.plugin.messenger.foundation.a.k.class)).apM().c(paramaf.field_username, paramaf);
      AppMethodBeat.o(42867);
      return;
      bool1 = false;
      break;
      bool1 = false;
      break label31;
    }
  }
  
  public static void v(af paramaf)
  {
    boolean bool2 = true;
    AppMethodBeat.i(42868);
    if (paramaf != null)
    {
      bool1 = true;
      Assert.assertTrue(bool1);
      if ((int)paramaf.fId == 0) {
        break label93;
      }
      bool1 = true;
      label28:
      Assert.assertTrue(bool1);
      if (paramaf.field_username.length() <= 0) {
        break label98;
      }
    }
    label93:
    label98:
    for (boolean bool1 = bool2;; bool1 = false)
    {
      Assert.assertTrue(bool1);
      paramaf.Zk();
      ((com.tencent.mm.plugin.messenger.foundation.a.k)g.ab(com.tencent.mm.plugin.messenger.foundation.a.k.class)).apM().c(paramaf.field_username, paramaf);
      z(paramaf);
      AppMethodBeat.o(42868);
      return;
      bool1 = false;
      break;
      bool1 = false;
      break label28;
    }
  }
  
  public static void w(af paramaf)
  {
    boolean bool2 = true;
    AppMethodBeat.i(42870);
    if (paramaf != null)
    {
      bool1 = true;
      Assert.assertTrue(bool1);
      if ((int)paramaf.fId == 0) {
        break label68;
      }
      bool1 = true;
      label28:
      Assert.assertTrue(bool1);
      if (paramaf.field_username.length() <= 0) {
        break label73;
      }
    }
    label68:
    label73:
    for (boolean bool1 = bool2;; bool1 = false)
    {
      Assert.assertTrue(bool1);
      paramaf.ZU();
      z(paramaf);
      AppMethodBeat.o(42870);
      return;
      bool1 = false;
      break;
      bool1 = false;
      break label28;
    }
  }
  
  private static void x(af paramaf)
  {
    AppMethodBeat.i(42871);
    boolean bool;
    brd localbrd;
    if (paramaf != null)
    {
      bool = true;
      Assert.assertTrue(bool);
      if ((int)paramaf.fId == 0)
      {
        ((com.tencent.mm.plugin.messenger.foundation.a.k)g.ab(com.tencent.mm.plugin.messenger.foundation.a.k.class)).apM().ag(paramaf);
        ((com.tencent.mm.plugin.messenger.foundation.a.k)g.ab(com.tencent.mm.plugin.messenger.foundation.a.k.class)).apM().aHY(paramaf.field_username);
      }
      ((com.tencent.mm.plugin.messenger.foundation.a.k)g.ab(com.tencent.mm.plugin.messenger.foundation.a.k.class)).apM().c(paramaf.field_username, paramaf);
      localbrd = new brd();
      localbrd.DOL = paramaf.field_username;
      if (!paramaf.ZP()) {
        break label163;
      }
    }
    label163:
    for (localbrd.DOH = 1;; localbrd.DOH = 2)
    {
      ((com.tencent.mm.plugin.messenger.foundation.a.k)g.ab(com.tencent.mm.plugin.messenger.foundation.a.k.class)).apL().c(new j.a(52, localbrd));
      AppMethodBeat.o(42871);
      return;
      bool = false;
      break;
    }
  }
  
  public static void y(af paramaf)
  {
    AppMethodBeat.i(42872);
    boolean bool;
    bre localbre;
    if (paramaf != null)
    {
      bool = true;
      Assert.assertTrue(bool);
      if ((int)paramaf.fId == 0)
      {
        ((com.tencent.mm.plugin.messenger.foundation.a.k)g.ab(com.tencent.mm.plugin.messenger.foundation.a.k.class)).apM().ag(paramaf);
        ((com.tencent.mm.plugin.messenger.foundation.a.k)g.ab(com.tencent.mm.plugin.messenger.foundation.a.k.class)).apM().aHY(paramaf.field_username);
      }
      ((com.tencent.mm.plugin.messenger.foundation.a.k)g.ab(com.tencent.mm.plugin.messenger.foundation.a.k.class)).apM().c(paramaf.field_username, paramaf);
      localbre = new bre();
      localbre.DOL = paramaf.field_username;
      if (!paramaf.ZR()) {
        break label163;
      }
    }
    label163:
    for (localbre.DOH = 1;; localbre.DOH = 2)
    {
      ((com.tencent.mm.plugin.messenger.foundation.a.k)g.ab(com.tencent.mm.plugin.messenger.foundation.a.k.class)).apL().c(new j.a(72, localbre));
      AppMethodBeat.o(42872);
      return;
      bool = false;
      break;
    }
  }
  
  public static void z(af paramaf)
  {
    AppMethodBeat.i(42873);
    if (paramaf != null) {}
    for (boolean bool = true;; bool = false)
    {
      Assert.assertTrue(bool);
      if ((int)paramaf.fId == 0)
      {
        ((com.tencent.mm.plugin.messenger.foundation.a.k)g.ab(com.tencent.mm.plugin.messenger.foundation.a.k.class)).apM().ag(paramaf);
        ((com.tencent.mm.plugin.messenger.foundation.a.k)g.ab(com.tencent.mm.plugin.messenger.foundation.a.k.class)).apM().aHY(paramaf.field_username);
      }
      ((com.tencent.mm.plugin.messenger.foundation.a.k)g.ab(com.tencent.mm.plugin.messenger.foundation.a.k.class)).apM().c(paramaf.field_username, paramaf);
      if (!af.aHH(paramaf.field_username)) {
        B(paramaf);
      }
      AppMethodBeat.o(42873);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.model.w
 * JD-Core Version:    0.7.0.1
 */