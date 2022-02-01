package com.tencent.mm.model;

import android.database.Cursor;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.c.av;
import com.tencent.mm.g.c.az;
import com.tencent.mm.kernel.e;
import com.tencent.mm.kernel.g;
import com.tencent.mm.n.b;
import com.tencent.mm.plugin.chatroom.a.c;
import com.tencent.mm.plugin.messenger.foundation.a.a.i;
import com.tencent.mm.plugin.messenger.foundation.a.a.j.a;
import com.tencent.mm.plugin.messenger.foundation.a.r;
import com.tencent.mm.protocal.protobuf.SKBuiltinBuffer_t;
import com.tencent.mm.protocal.protobuf.bva;
import com.tencent.mm.protocal.protobuf.bvu;
import com.tencent.mm.protocal.protobuf.bvv;
import com.tencent.mm.protocal.protobuf.crm;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.bs;
import com.tencent.mm.storage.ae;
import com.tencent.mm.storage.ai;
import com.tencent.mm.storage.ap;
import com.tencent.mm.storage.bj;
import com.tencent.mm.storage.bk;
import com.tencent.mm.storage.bu;
import com.tencent.mm.storage.x;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import junit.framework.Assert;

public final class w
{
  private static ak hmM;
  public static final String hmN;
  public static final String hmO;
  public static final String hmP;
  public static final String hmQ;
  public static final String hmR;
  public static final String hmS;
  public static final String hmT;
  public static final String hmU;
  public static final String hmV;
  public static final String[] hmW;
  
  static
  {
    AppMethodBeat.i(42931);
    hmM = null;
    hmN = b("rconversation.username", new String[] { "@im.chatroom", "@chatroom", "@openim", "@micromsg.qq.com" });
    hmO = b("rconversation.username", new String[] { "@chatroom", "@micromsg.qq.com" });
    hmP = b("rconversation.username", new String[] { "@t.qq.com" });
    hmQ = b("rconversation.username", new String[] { "@qqim" });
    hmR = b("rconversation.username", new String[] { "@chatroom_exclusive" });
    hmS = b("rconversation.username", new String[] { "@micromsg.qq.com" });
    hmT = b("rconversation.username", new String[] { "@app" });
    hmU = b("rconversation.username", new String[] { "@chatroom" });
    hmV = b("rconversation.username", new String[] { "@im.chatroom" });
    hmW = new String[] { "qqmail", "fmessage", "tmessage", "qmessage", "qqsync", "floatbottle", "lbsapp", "shakeapp", "medianote", "qqfriend", "newsapp", "blogapp", "facebookapp", "topstoryapp", "masssendapp", "feedsapp", "voipapp", "cardpackage", "voicevoipapp", "voiceinputapp", "officialaccounts", "linkedinplugin", "notifymessage", "appbrandcustomerservicemsg", "appbrand_notify_message" };
    AppMethodBeat.o(42931);
  }
  
  public static bva A(ai paramai)
  {
    AppMethodBeat.i(194030);
    ac.i("MicroMsg.ContactStorageLogic", "oplog modContact user:%s remark:%s type:%d ", new Object[] { paramai.field_username, paramai.field_conRemark, Integer.valueOf(paramai.field_type) });
    bva localbva = new bva();
    localbva.EuE = new crm().aJV(bs.nullAsNil(paramai.field_username));
    localbva.Fbd = new crm().aJV(bs.nullAsNil(paramai.field_nickname));
    localbva.EtY = new crm().aJV(bs.nullAsNil(paramai.To()));
    localbva.EtZ = new crm().aJV(bs.nullAsNil(paramai.Tp()));
    localbva.iJT = paramai.exL;
    localbva.Etk = 9015167;
    localbva.Etl = paramai.field_type;
    localbva.Fkk = new crm().aJV(bs.nullAsNil(paramai.field_conRemark));
    localbva.Fkl = new crm().aJV(bs.nullAsNil(paramai.field_conRemarkPYShort));
    localbva.Fkm = new crm().aJV(bs.nullAsNil(paramai.field_conRemarkPYFull));
    localbva.Etq = paramai.exQ;
    localbva.FkE = new crm().aJV(bs.nullAsNil(paramai.field_domainList));
    localbva.Etu = paramai.exT;
    localbva.iJX = paramai.exU;
    localbva.iJW = bs.nullAsNil(paramai.signature);
    localbva.iJV = bs.nullAsNil(paramai.getCityCode());
    localbva.iJU = bs.nullAsNil(paramai.fai());
    localbva.Fes = bs.nullAsNil(paramai.exZ);
    localbva.Feu = paramai.field_weiboFlag;
    localbva.FkA = 0;
    localbva.DPX = new SKBuiltinBuffer_t();
    localbva.iKc = bs.nullAsNil(paramai.getCountryCode());
    AppMethodBeat.o(194030);
    return localbva;
  }
  
  public static void B(ai paramai)
  {
    AppMethodBeat.i(42874);
    ((com.tencent.mm.plugin.messenger.foundation.a.k)g.ab(com.tencent.mm.plugin.messenger.foundation.a.k.class)).awA().c(new j.a(2, A(paramai)));
    AppMethodBeat.o(42874);
  }
  
  public static void C(String paramString, boolean paramBoolean)
  {
    AppMethodBeat.i(42853);
    paramString = ((com.tencent.mm.plugin.messenger.foundation.a.k)g.ab(com.tencent.mm.plugin.messenger.foundation.a.k.class)).awB().aNt(paramString);
    if ((paramString == null) || (bs.isNullOrNil(paramString.field_username)))
    {
      AppMethodBeat.o(42853);
      return;
    }
    if (paramBoolean) {
      paramString.aau();
    }
    for (;;)
    {
      x(paramString);
      AppMethodBeat.o(42853);
      return;
      paramString.aav();
    }
  }
  
  public static boolean C(ai paramai)
  {
    return (paramai.field_weiboFlag & 0x1) != 0;
  }
  
  public static void D(String paramString, boolean paramBoolean)
  {
    AppMethodBeat.i(42862);
    if (!bs.isNullOrNil(paramString)) {}
    ai localai;
    for (boolean bool = true;; bool = false)
    {
      Assert.assertTrue(bool);
      localai = ((com.tencent.mm.plugin.messenger.foundation.a.k)g.ab(com.tencent.mm.plugin.messenger.foundation.a.k.class)).awB().aNt(paramString);
      if ((localai != null) && (!bs.isNullOrNil(localai.field_username))) {
        break;
      }
      AppMethodBeat.o(42862);
      return;
    }
    localai.setType(localai.field_type | 0x800);
    if (((ai.aNc(paramString)) || (wq(paramString))) && (hmM != null)) {
      hmM.xV(paramString);
    }
    z(localai);
    if (paramBoolean) {
      ((com.tencent.mm.plugin.messenger.foundation.a.k)g.ab(com.tencent.mm.plugin.messenger.foundation.a.k.class)).awG().aNO(paramString);
    }
    AppMethodBeat.o(42862);
  }
  
  public static void E(String paramString, boolean paramBoolean)
  {
    AppMethodBeat.i(42864);
    if (!bs.isNullOrNil(paramString)) {}
    ai localai;
    for (boolean bool = true;; bool = false)
    {
      Assert.assertTrue(bool);
      localai = ((com.tencent.mm.plugin.messenger.foundation.a.k)g.ab(com.tencent.mm.plugin.messenger.foundation.a.k.class)).awB().aNt(paramString);
      if ((localai != null) && (!bs.isNullOrNil(localai.field_username))) {
        break;
      }
      AppMethodBeat.o(42864);
      return;
    }
    localai.setType(localai.field_type & 0xFFFFF7FF);
    if (((ai.aNc(paramString)) || (wq(paramString))) && (hmM != null)) {
      hmM.xW(paramString);
    }
    z(localai);
    if (paramBoolean) {
      ((com.tencent.mm.plugin.messenger.foundation.a.k)g.ab(com.tencent.mm.plugin.messenger.foundation.a.k.class)).awG().aNP(paramString);
    }
    AppMethodBeat.o(42864);
  }
  
  public static void a(ak paramak)
  {
    hmM = paramak;
  }
  
  public static boolean a(ap paramap)
  {
    AppMethodBeat.i(42926);
    String str = paramap.field_username;
    if (xr(str))
    {
      AppMethodBeat.o(42926);
      return false;
    }
    if (xo(str))
    {
      AppMethodBeat.o(42926);
      return false;
    }
    if (xg(str))
    {
      AppMethodBeat.o(42926);
      return false;
    }
    if (xh(str))
    {
      AppMethodBeat.o(42926);
      return false;
    }
    if (paramap.field_conversationTime == -1L)
    {
      AppMethodBeat.o(42926);
      return false;
    }
    if (wH(str))
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
    int[] arrayOfInt = ((com.tencent.mm.plugin.messenger.foundation.a.k)g.ab(com.tencent.mm.plugin.messenger.foundation.a.k.class)).awB().b(paramString1, paramString2, paramArrayOfString, paramList);
    if (arrayOfInt.length <= 0)
    {
      AppMethodBeat.o(42878);
      return null;
    }
    paramString1 = ((com.tencent.mm.plugin.messenger.foundation.a.k)g.ab(com.tencent.mm.plugin.messenger.foundation.a.k.class)).awB().c(paramString1, paramString2, paramArrayOfString, paramList);
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
    AppMethodBeat.i(194031);
    long l = System.currentTimeMillis();
    int[] arrayOfInt = ((com.tencent.mm.plugin.messenger.foundation.a.k)g.ab(com.tencent.mm.plugin.messenger.foundation.a.k.class)).awB().b(paramArrayOfString, paramString1, paramString2, paramString3, paramList);
    ac.d("MicroMsg.ContactStorageLogic", "kevin service(IMessengerStorage.class).getContactStg().getShowHeadDistinct(" + (System.currentTimeMillis() - l));
    if (arrayOfInt.length <= 0)
    {
      AppMethodBeat.o(194031);
      return null;
    }
    l = System.currentTimeMillis();
    paramArrayOfString = ((com.tencent.mm.plugin.messenger.foundation.a.k)g.ab(com.tencent.mm.plugin.messenger.foundation.a.k.class)).awB().c(paramArrayOfString, paramString1, paramString2, paramString3, paramList);
    ac.d("MicroMsg.ContactStorageLogic", "kevin service(IMessengerStorage.class).getContactStg().getSectionNumByShowHead" + (System.currentTimeMillis() - l));
    if (paramArrayOfString == null)
    {
      AppMethodBeat.o(194031);
      return null;
    }
    if (arrayOfInt.length != paramArrayOfString.length)
    {
      ac.e("MicroMsg.ContactStorageLogic", "[%s:%s] filterType:%s filterSearchStr:%s blocklist:%s searchString:%s", new Object[] { Integer.valueOf(arrayOfInt.length), Integer.valueOf(paramArrayOfString.length), paramString1, paramString2, paramList, paramString3 });
      AppMethodBeat.o(194031);
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
    AppMethodBeat.o(194031);
    return paramString1;
  }
  
  public static String[] a(String paramString1, String paramString2, String[] paramArrayOfString, List<String> paramList)
  {
    AppMethodBeat.i(42879);
    long l = System.currentTimeMillis();
    paramString1 = ((com.tencent.mm.plugin.messenger.foundation.a.k)g.ab(com.tencent.mm.plugin.messenger.foundation.a.k.class)).awB().b(paramString1, paramString2, paramArrayOfString, paramList);
    ac.d("MicroMsg.ContactStorageLogic", "kevin service(IMessengerStorage.class).getContactStg().getShowSectionByShowHead" + (System.currentTimeMillis() - l));
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
    AppMethodBeat.i(194032);
    long l = System.currentTimeMillis();
    paramArrayOfString = ((com.tencent.mm.plugin.messenger.foundation.a.k)g.ab(com.tencent.mm.plugin.messenger.foundation.a.k.class)).awB().b(paramArrayOfString, paramString1, paramString2, paramString3, paramList);
    ac.d("MicroMsg.ContactStorageLogic", "kevin service(IMessengerStorage.class).getContactStg().getShowSectionByShowHead" + (System.currentTimeMillis() - l));
    if (paramArrayOfString.length <= 0)
    {
      AppMethodBeat.o(194032);
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
    AppMethodBeat.o(194032);
    return paramString1;
  }
  
  public static int[] af(List<String> paramList)
  {
    AppMethodBeat.i(42877);
    long l = System.currentTimeMillis();
    int[] arrayOfInt1 = ((com.tencent.mm.plugin.messenger.foundation.a.k)g.ab(com.tencent.mm.plugin.messenger.foundation.a.k.class)).awB().hv(paramList);
    ac.d("MicroMsg.ContactStorageLogic", "kevin service(IMessengerStorage.class).getContactStg().getShowHeadDistinct(" + (System.currentTimeMillis() - l));
    if (arrayOfInt1.length <= 0)
    {
      AppMethodBeat.o(42877);
      return null;
    }
    l = System.currentTimeMillis();
    paramList = ((com.tencent.mm.plugin.messenger.foundation.a.k)g.ab(com.tencent.mm.plugin.messenger.foundation.a.k.class)).awB().hw(paramList);
    ac.d("MicroMsg.ContactStorageLogic", "kevin service(IMessengerStorage.class).getContactStg().getSectionNumByShowHead" + (System.currentTimeMillis() - l));
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
  
  public static String[] ag(List<String> paramList)
  {
    AppMethodBeat.i(42881);
    long l = System.currentTimeMillis();
    paramList = ((com.tencent.mm.plugin.messenger.foundation.a.k)g.ab(com.tencent.mm.plugin.messenger.foundation.a.k.class)).awB().hv(paramList);
    ac.d("MicroMsg.ContactStorageLogic", "kevin service(IMessengerStorage.class).getContactStg().getShowSectionByShowHead" + (System.currentTimeMillis() - l));
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
  
  public static List<String> ayh()
  {
    AppMethodBeat.i(42846);
    List localList = ((com.tencent.mm.plugin.messenger.foundation.a.k)g.ab(com.tencent.mm.plugin.messenger.foundation.a.k.class)).awB().faq();
    AppMethodBeat.o(42846);
    return localList;
  }
  
  public static List<ai> ayi()
  {
    AppMethodBeat.i(42847);
    ArrayList localArrayList = new ArrayList();
    Cursor localCursor = ((com.tencent.mm.plugin.messenger.foundation.a.k)g.ab(com.tencent.mm.plugin.messenger.foundation.a.k.class)).awB().far();
    if (localCursor.moveToFirst()) {
      do
      {
        ai localai = new ai();
        localai.convertFrom(localCursor);
        localArrayList.add(localai);
      } while (localCursor.moveToNext());
    }
    localCursor.close();
    AppMethodBeat.o(42847);
    return localArrayList;
  }
  
  public static boolean ayj()
  {
    return false;
  }
  
  public static boolean ayk()
  {
    AppMethodBeat.i(42922);
    if (!u.ayd())
    {
      AppMethodBeat.o(42922);
      return false;
    }
    bu localbu = ((com.tencent.mm.plugin.messenger.foundation.a.k)g.ab(com.tencent.mm.plugin.messenger.foundation.a.k.class)).awJ().alJ("@t.qq.com");
    if ((localbu == null) || (bs.isNullOrNil(localbu.name)))
    {
      AppMethodBeat.o(42922);
      return false;
    }
    AppMethodBeat.o(42922);
    return true;
  }
  
  public static boolean ayl()
  {
    AppMethodBeat.i(42923);
    if (!u.ayd())
    {
      AppMethodBeat.o(42923);
      return false;
    }
    bu localbu = ((com.tencent.mm.plugin.messenger.foundation.a.k)g.ab(com.tencent.mm.plugin.messenger.foundation.a.k.class)).awJ().alJ("@t.qq.com");
    if ((localbu == null) || (bs.nullAsNil(localbu.name).length() == 0))
    {
      AppMethodBeat.o(42923);
      return false;
    }
    AppMethodBeat.o(42923);
    return true;
  }
  
  public static List<ai> aym()
  {
    AppMethodBeat.i(42924);
    LinkedList localLinkedList = new LinkedList();
    Cursor localCursor = ((com.tencent.mm.plugin.messenger.foundation.a.k)g.ab(com.tencent.mm.plugin.messenger.foundation.a.k.class)).awB().fau();
    if (localCursor.getCount() == 0)
    {
      localCursor.close();
      AppMethodBeat.o(42924);
      return localLinkedList;
    }
    localCursor.moveToFirst();
    do
    {
      ai localai = new ai();
      localai.convertFrom(localCursor);
      localLinkedList.add(localai);
    } while (localCursor.moveToNext());
    localCursor.close();
    ac.d("MicroMsg.ContactStorageLogic", "getFavourList size:  " + localLinkedList.size());
    AppMethodBeat.o(42924);
    return localLinkedList;
  }
  
  public static List<String> ayn()
  {
    AppMethodBeat.i(42925);
    LinkedList localLinkedList = new LinkedList();
    Cursor localCursor = ((com.tencent.mm.plugin.messenger.foundation.a.k)g.ab(com.tencent.mm.plugin.messenger.foundation.a.k.class)).awB().fas();
    if (localCursor.getCount() == 0)
    {
      localCursor.close();
      AppMethodBeat.o(42925);
      return localLinkedList;
    }
    localCursor.moveToFirst();
    do
    {
      ai localai = new ai();
      localai.convertFrom(localCursor);
      localLinkedList.add(localai.field_username);
    } while (localCursor.moveToNext());
    localCursor.close();
    ac.d("MicroMsg.ContactStorageLogic", "getSnsBlackContactList size:  " + localLinkedList.size());
    AppMethodBeat.o(42925);
    return localLinkedList;
  }
  
  public static int ayo()
  {
    AppMethodBeat.i(42928);
    int i = ((com.tencent.mm.plugin.messenger.foundation.a.k)g.ab(com.tencent.mm.plugin.messenger.foundation.a.k.class)).awB().c(hmW, new String[] { u.axw(), "weixin", "helper_entry", "filehelper" });
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
  
  public static boolean b(ap paramap)
  {
    AppMethodBeat.i(42927);
    paramap = paramap.field_username;
    if (xg(paramap))
    {
      AppMethodBeat.o(42927);
      return false;
    }
    if (xp(paramap))
    {
      AppMethodBeat.o(42927);
      return false;
    }
    if (xq(paramap))
    {
      AppMethodBeat.o(42927);
      return false;
    }
    AppMethodBeat.o(42927);
    return true;
  }
  
  public static void c(ai paramai, String paramString)
  {
    AppMethodBeat.i(42869);
    ai localai = ((com.tencent.mm.plugin.messenger.foundation.a.k)g.ab(com.tencent.mm.plugin.messenger.foundation.a.k.class)).awB().aNt(paramai.field_username);
    if ((localai != null) && (paramString != null)) {}
    for (boolean bool = true;; bool = false)
    {
      Assert.assertTrue(bool);
      localai.qh(paramString);
      if ((ai.aNc(paramai.field_username)) && (hmM != null)) {
        hmM.aI(paramai.field_username, paramString);
      }
      z(localai);
      AppMethodBeat.o(42869);
      return;
    }
  }
  
  public static boolean i(ai paramai)
  {
    AppMethodBeat.i(42840);
    if (paramai == null)
    {
      AppMethodBeat.o(42840);
      return false;
    }
    if (!wo(paramai.field_username))
    {
      AppMethodBeat.o(42840);
      return false;
    }
    if (!b.ln(paramai.field_type))
    {
      AppMethodBeat.o(42840);
      return false;
    }
    AppMethodBeat.o(42840);
    return true;
  }
  
  public static void j(ai paramai)
  {
    AppMethodBeat.i(42852);
    boolean bool;
    ai localai2;
    if (paramai != null)
    {
      bool = true;
      Assert.assertTrue(bool);
      localai2 = ((com.tencent.mm.plugin.messenger.foundation.a.k)g.ab(com.tencent.mm.plugin.messenger.foundation.a.k.class)).awB().aNt(paramai.field_username);
      localai1 = paramai;
      if (localai2 != null) {
        if (!bs.isNullOrNil(localai2.field_username)) {
          break label78;
        }
      }
    }
    label78:
    for (ai localai1 = paramai;; localai1 = localai2)
    {
      localai1.aal();
      z(localai1);
      AppMethodBeat.o(42852);
      return;
      bool = false;
      break;
    }
  }
  
  public static void k(ai paramai)
  {
    AppMethodBeat.i(42854);
    boolean bool;
    ai localai2;
    if (paramai != null)
    {
      bool = true;
      Assert.assertTrue(bool);
      localai2 = ((com.tencent.mm.plugin.messenger.foundation.a.k)g.ab(com.tencent.mm.plugin.messenger.foundation.a.k.class)).awB().aNt(paramai.field_username);
      localai1 = paramai;
      if (localai2 != null) {
        if (!bs.isNullOrNil(localai2.field_username)) {
          break label78;
        }
      }
    }
    label78:
    for (ai localai1 = paramai;; localai1 = localai2)
    {
      localai1.aaj();
      z(localai1);
      AppMethodBeat.o(42854);
      return;
      bool = false;
      break;
    }
  }
  
  public static void l(ai paramai)
  {
    AppMethodBeat.i(42855);
    boolean bool;
    ai localai2;
    if (paramai != null)
    {
      bool = true;
      Assert.assertTrue(bool);
      localai2 = ((com.tencent.mm.plugin.messenger.foundation.a.k)g.ab(com.tencent.mm.plugin.messenger.foundation.a.k.class)).awB().aNt(paramai.field_username);
      localai1 = paramai;
      if (localai2 != null) {
        if (!bs.isNullOrNil(localai2.field_username)) {
          break label78;
        }
      }
    }
    label78:
    for (ai localai1 = paramai;; localai1 = localai2)
    {
      localai1.aak();
      z(localai1);
      AppMethodBeat.o(42855);
      return;
      bool = false;
      break;
    }
  }
  
  public static void m(ai paramai)
  {
    AppMethodBeat.i(42856);
    if (paramai != null) {}
    for (boolean bool = true;; bool = false)
    {
      Assert.assertTrue(bool);
      ai localai2 = ((com.tencent.mm.plugin.messenger.foundation.a.k)g.ab(com.tencent.mm.plugin.messenger.foundation.a.k.class)).awB().aNt(paramai.field_username);
      ai localai1;
      if (localai2 != null)
      {
        localai1 = localai2;
        if (!bs.isNullOrNil(localai2.field_username)) {}
      }
      else
      {
        localai1 = paramai;
      }
      localai1.aah();
      if ((ai.aNc(paramai.field_username)) && (hmM != null)) {
        hmM.xX(paramai.field_username);
      }
      z(localai1);
      AppMethodBeat.o(42856);
      return;
    }
  }
  
  public static void n(ai paramai)
  {
    AppMethodBeat.i(42857);
    if (paramai != null) {}
    for (boolean bool = true;; bool = false)
    {
      Assert.assertTrue(bool);
      ai localai2 = ((com.tencent.mm.plugin.messenger.foundation.a.k)g.ab(com.tencent.mm.plugin.messenger.foundation.a.k.class)).awB().aNt(paramai.field_username);
      ai localai1;
      if (localai2 != null)
      {
        localai1 = localai2;
        if (!bs.isNullOrNil(localai2.field_username)) {}
      }
      else
      {
        localai1 = paramai;
      }
      localai1.aai();
      if ((ai.aNc(paramai.field_username)) && (hmM != null)) {
        hmM.xY(paramai.field_username);
      }
      z(localai1);
      paramai = ((com.tencent.mm.plugin.messenger.foundation.a.k)g.ab(com.tencent.mm.plugin.messenger.foundation.a.k.class)).awG().aNI(paramai.field_username);
      if ((paramai != null) && ("@blacklist".equals(paramai.field_parentRef))) {
        ((com.tencent.mm.plugin.messenger.foundation.a.k)g.ab(com.tencent.mm.plugin.messenger.foundation.a.k.class)).awG().c(new String[] { paramai.field_username }, "");
      }
      AppMethodBeat.o(42857);
      return;
    }
  }
  
  public static boolean nN(int paramInt)
  {
    AppMethodBeat.i(42851);
    boolean bool = ai.YI(paramInt);
    AppMethodBeat.o(42851);
    return bool;
  }
  
  public static void o(ai paramai)
  {
    AppMethodBeat.i(42858);
    if (paramai != null) {}
    for (boolean bool = true;; bool = false)
    {
      Assert.assertTrue(bool);
      ai localai2 = ((com.tencent.mm.plugin.messenger.foundation.a.k)g.ab(com.tencent.mm.plugin.messenger.foundation.a.k.class)).awB().aNt(paramai.field_username);
      ai localai1;
      if (localai2 != null)
      {
        localai1 = localai2;
        if (!bs.isNullOrNil(localai2.field_username)) {}
      }
      else
      {
        localai1 = paramai;
      }
      localai1.aau();
      localai1.jB(paramai.aac());
      x(localai1);
      AppMethodBeat.o(42858);
      return;
    }
  }
  
  public static void p(ai paramai)
  {
    AppMethodBeat.i(42859);
    if (paramai != null) {}
    for (boolean bool = true;; bool = false)
    {
      Assert.assertTrue(bool);
      ai localai2 = ((com.tencent.mm.plugin.messenger.foundation.a.k)g.ab(com.tencent.mm.plugin.messenger.foundation.a.k.class)).awB().aNt(paramai.field_username);
      ai localai1;
      if (localai2 != null)
      {
        localai1 = localai2;
        if (!bs.isNullOrNil(localai2.field_username)) {}
      }
      else
      {
        localai1 = paramai;
      }
      localai1.aav();
      localai1.jB(paramai.aac());
      x(localai1);
      AppMethodBeat.o(42859);
      return;
    }
  }
  
  public static void q(ai paramai)
  {
    AppMethodBeat.i(42860);
    if (paramai != null) {}
    for (boolean bool = true;; bool = false)
    {
      Assert.assertTrue(bool);
      ai localai2 = ((com.tencent.mm.plugin.messenger.foundation.a.k)g.ab(com.tencent.mm.plugin.messenger.foundation.a.k.class)).awB().aNt(paramai.field_username);
      ai localai1;
      if (localai2 != null)
      {
        localai1 = localai2;
        if (!bs.isNullOrNil(localai2.field_username)) {}
      }
      else
      {
        localai1 = paramai;
      }
      localai1.aaq();
      localai1.jB(paramai.aac());
      if ((ai.aNc(paramai.field_username)) && (hmM != null)) {
        hmM.xZ(paramai.field_username);
      }
      z(localai1);
      AppMethodBeat.o(42860);
      return;
    }
  }
  
  public static void r(ai paramai)
  {
    AppMethodBeat.i(42861);
    if (paramai != null) {}
    for (boolean bool = true;; bool = false)
    {
      Assert.assertTrue(bool);
      ai localai2 = ((com.tencent.mm.plugin.messenger.foundation.a.k)g.ab(com.tencent.mm.plugin.messenger.foundation.a.k.class)).awB().aNt(paramai.field_username);
      ai localai1;
      if (localai2 != null)
      {
        localai1 = localai2;
        if (!bs.isNullOrNil(localai2.field_username)) {}
      }
      else
      {
        localai1 = paramai;
      }
      localai1.aar();
      localai1.jB(paramai.aac());
      if ((ai.aNc(paramai.field_username)) && (hmM != null)) {
        hmM.ya(paramai.field_username);
      }
      z(localai1);
      AppMethodBeat.o(42861);
      return;
    }
  }
  
  public static void s(ai paramai)
  {
    AppMethodBeat.i(42865);
    if (paramai != null) {}
    for (boolean bool = true;; bool = false)
    {
      Assert.assertTrue(bool);
      ai localai2 = ((com.tencent.mm.plugin.messenger.foundation.a.k)g.ab(com.tencent.mm.plugin.messenger.foundation.a.k.class)).awB().aNt(paramai.field_username);
      ai localai1;
      if (localai2 != null)
      {
        localai1 = localai2;
        if (!bs.isNullOrNil(localai2.field_username)) {}
      }
      else
      {
        localai1 = paramai;
      }
      localai1.aas();
      if ((ai.aNc(paramai.field_username)) && (hmM != null)) {
        hmM.yb(paramai.field_username);
      }
      z(localai1);
      AppMethodBeat.o(42865);
      return;
    }
  }
  
  public static boolean sQ(String paramString)
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
  
  public static void t(ai paramai)
  {
    AppMethodBeat.i(42866);
    if (paramai != null) {}
    for (boolean bool = true;; bool = false)
    {
      Assert.assertTrue(bool);
      ai localai2 = ((com.tencent.mm.plugin.messenger.foundation.a.k)g.ab(com.tencent.mm.plugin.messenger.foundation.a.k.class)).awB().aNt(paramai.field_username);
      ai localai1;
      if (localai2 != null)
      {
        localai1 = localai2;
        if (!bs.isNullOrNil(localai2.field_username)) {}
      }
      else
      {
        localai1 = paramai;
      }
      localai1.aat();
      if ((ai.aNc(paramai.field_username)) && (hmM != null)) {
        hmM.yc(paramai.field_username);
      }
      z(localai1);
      AppMethodBeat.o(42866);
      return;
    }
  }
  
  public static void u(ai paramai)
  {
    boolean bool2 = true;
    AppMethodBeat.i(42867);
    if (paramai != null)
    {
      bool1 = true;
      Assert.assertTrue("MicroMsg.ContactStorageLogic: user is null", bool1);
      if ((int)paramai.fLJ == 0) {
        break label98;
      }
      bool1 = true;
      label31:
      Assert.assertTrue("MicroMsg.ContactStorageLogic: contactId == 0", bool1);
      if (paramai.field_username.length() <= 0) {
        break label103;
      }
    }
    label98:
    label103:
    for (boolean bool1 = bool2;; bool1 = false)
    {
      Assert.assertTrue("MicroMsg.ContactStorageLogic: username length <= 0", bool1);
      paramai.aaf();
      ((com.tencent.mm.plugin.messenger.foundation.a.k)g.ab(com.tencent.mm.plugin.messenger.foundation.a.k.class)).awB().c(paramai.field_username, paramai);
      AppMethodBeat.o(42867);
      return;
      bool1 = false;
      break;
      bool1 = false;
      break label31;
    }
  }
  
  public static void v(ai paramai)
  {
    boolean bool2 = true;
    AppMethodBeat.i(42868);
    if (paramai != null)
    {
      bool1 = true;
      Assert.assertTrue(bool1);
      if ((int)paramai.fLJ == 0) {
        break label93;
      }
      bool1 = true;
      label28:
      Assert.assertTrue(bool1);
      if (paramai.field_username.length() <= 0) {
        break label98;
      }
    }
    label93:
    label98:
    for (boolean bool1 = bool2;; bool1 = false)
    {
      Assert.assertTrue(bool1);
      paramai.aaf();
      ((com.tencent.mm.plugin.messenger.foundation.a.k)g.ab(com.tencent.mm.plugin.messenger.foundation.a.k.class)).awB().c(paramai.field_username, paramai);
      z(paramai);
      AppMethodBeat.o(42868);
      return;
      bool1 = false;
      break;
      bool1 = false;
      break label28;
    }
  }
  
  public static void w(ai paramai)
  {
    boolean bool2 = true;
    AppMethodBeat.i(42870);
    if (paramai != null)
    {
      bool1 = true;
      Assert.assertTrue(bool1);
      if ((int)paramai.fLJ == 0) {
        break label68;
      }
      bool1 = true;
      label28:
      Assert.assertTrue(bool1);
      if (paramai.field_username.length() <= 0) {
        break label73;
      }
    }
    label68:
    label73:
    for (boolean bool1 = bool2;; bool1 = false)
    {
      Assert.assertTrue(bool1);
      paramai.aaP();
      z(paramai);
      AppMethodBeat.o(42870);
      return;
      bool1 = false;
      break;
      bool1 = false;
      break label28;
    }
  }
  
  public static boolean wA(String paramString)
  {
    AppMethodBeat.i(42842);
    boolean bool = "gh_3dfda90e39d6".equals(paramString);
    AppMethodBeat.o(42842);
    return bool;
  }
  
  public static boolean wB(String paramString)
  {
    AppMethodBeat.i(194029);
    boolean bool = "gh_f0a92aa7146c".equals(paramString);
    AppMethodBeat.o(194029);
    return bool;
  }
  
  public static boolean wC(String paramString)
  {
    AppMethodBeat.i(163508);
    boolean bool = "1@fackuser".equals(paramString);
    AppMethodBeat.o(163508);
    return bool;
  }
  
  public static boolean wD(String paramString)
  {
    AppMethodBeat.i(42843);
    boolean bool = "downloaderapp".equals(paramString);
    AppMethodBeat.o(42843);
    return bool;
  }
  
  public static boolean wE(String paramString)
  {
    AppMethodBeat.i(42844);
    if ((paramString == null) || (paramString.length() <= 0))
    {
      AppMethodBeat.o(42844);
      return false;
    }
    if (!wo(paramString))
    {
      AppMethodBeat.o(42844);
      return false;
    }
    paramString = ((com.tencent.mm.plugin.messenger.foundation.a.k)g.ab(com.tencent.mm.plugin.messenger.foundation.a.k.class)).awB().aNt(paramString);
    if ((paramString == null) || (!b.ln(paramString.field_type)))
    {
      AppMethodBeat.o(42844);
      return false;
    }
    AppMethodBeat.o(42844);
    return true;
  }
  
  public static boolean wF(String paramString)
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
  
  public static boolean wG(String paramString)
  {
    AppMethodBeat.i(42849);
    if ((paramString == null) || (paramString.length() <= 0))
    {
      AppMethodBeat.o(42849);
      return true;
    }
    boolean bool = b.ln(((com.tencent.mm.plugin.messenger.foundation.a.k)g.ab(com.tencent.mm.plugin.messenger.foundation.a.k.class)).awB().aNt(paramString).field_type);
    AppMethodBeat.o(42849);
    return bool;
  }
  
  public static boolean wH(String paramString)
  {
    AppMethodBeat.i(42850);
    if (bs.isNullOrNil(paramString))
    {
      AppMethodBeat.o(42850);
      return false;
    }
    paramString = ((com.tencent.mm.plugin.messenger.foundation.a.k)g.ab(com.tencent.mm.plugin.messenger.foundation.a.k.class)).awB().aNt(paramString);
    if (paramString == null)
    {
      AppMethodBeat.o(42850);
      return false;
    }
    boolean bool = ai.YI(paramString.field_verifyFlag);
    AppMethodBeat.o(42850);
    return bool;
  }
  
  public static void wI(String paramString)
  {
    AppMethodBeat.i(42863);
    ap localap2 = ((com.tencent.mm.plugin.messenger.foundation.a.k)g.ab(com.tencent.mm.plugin.messenger.foundation.a.k.class)).awG().aNI(paramString);
    int i = 0;
    ap localap1 = localap2;
    if (localap2 == null)
    {
      localap1 = new ap();
      localap1.faH();
      i = 1;
      localap1.setUsername(paramString);
    }
    localap1.ou(System.currentTimeMillis());
    if (i != 0)
    {
      ((com.tencent.mm.plugin.messenger.foundation.a.k)g.ab(com.tencent.mm.plugin.messenger.foundation.a.k.class)).awG().e(localap1);
      AppMethodBeat.o(42863);
      return;
    }
    ((com.tencent.mm.plugin.messenger.foundation.a.k)g.ab(com.tencent.mm.plugin.messenger.foundation.a.k.class)).awG().a(localap1, paramString);
    AppMethodBeat.o(42863);
  }
  
  public static void wJ(String paramString)
  {
    AppMethodBeat.i(42875);
    if (bs.isNullOrNil(paramString))
    {
      AppMethodBeat.o(42875);
      return;
    }
    ai localai = ((com.tencent.mm.plugin.messenger.foundation.a.k)g.ab(com.tencent.mm.plugin.messenger.foundation.a.k.class)).awB().aNt(paramString);
    if (localai == null)
    {
      AppMethodBeat.o(42875);
      return;
    }
    localai.setSource(0);
    localai.aad();
    ((com.tencent.mm.plugin.messenger.foundation.a.k)g.ab(com.tencent.mm.plugin.messenger.foundation.a.k.class)).awB().c(paramString, localai);
    AppMethodBeat.o(42875);
  }
  
  public static boolean wK(String paramString)
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
  
  public static boolean wL(String paramString)
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
  
  public static boolean wM(String paramString)
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
  
  public static boolean wN(String paramString)
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
  
  public static boolean wO(String paramString)
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
  
  public static boolean wP(String paramString)
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
  
  public static boolean wQ(String paramString)
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
  
  public static boolean wR(String paramString)
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
  
  public static boolean wS(String paramString)
  {
    AppMethodBeat.i(42890);
    boolean bool = "qqsync".equalsIgnoreCase(paramString);
    AppMethodBeat.o(42890);
    return bool;
  }
  
  public static boolean wT(String paramString)
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
  
  public static boolean wU(String paramString)
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
  
  public static boolean wV(String paramString)
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
  
  public static boolean wW(String paramString)
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
  
  public static boolean wX(String paramString)
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
  
  public static boolean wY(String paramString)
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
  
  public static boolean wZ(String paramString)
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
  
  public static boolean wn(String paramString)
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
  
  public static boolean wo(String paramString)
  {
    AppMethodBeat.i(42832);
    if ((wp(paramString)) || (wq(paramString)))
    {
      AppMethodBeat.o(42832);
      return true;
    }
    AppMethodBeat.o(42832);
    return false;
  }
  
  public static boolean wp(String paramString)
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
  
  public static boolean wq(String paramString)
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
  
  public static boolean wr(String paramString)
  {
    AppMethodBeat.i(178864);
    if ((paramString == null) || (paramString.length() <= 0))
    {
      AppMethodBeat.o(178864);
      return false;
    }
    if ((paramString.endsWith("@im.chatroom")) || (ws(paramString)))
    {
      AppMethodBeat.o(178864);
      return true;
    }
    AppMethodBeat.o(178864);
    return false;
  }
  
  public static boolean ws(String paramString)
  {
    AppMethodBeat.i(178865);
    if (wp(paramString))
    {
      paramString = ((c)g.ab(c.class)).awK().xN(paramString);
      if ((paramString != null) && ((paramString.field_chatroomStatus & 0x20000) == 131072))
      {
        AppMethodBeat.o(178865);
        return true;
      }
    }
    AppMethodBeat.o(178865);
    return false;
  }
  
  public static boolean wt(String paramString)
  {
    AppMethodBeat.i(178866);
    if (wp(paramString))
    {
      paramString = ((c)g.ab(c.class)).awK().xN(paramString);
      if ((paramString != null) && ((paramString.field_chatroomStatus & 0x20000) != 131072) && ((paramString.field_chatroomStatus & 0x10000) == 65536))
      {
        AppMethodBeat.o(178866);
        return true;
      }
    }
    AppMethodBeat.o(178866);
    return false;
  }
  
  public static boolean wu(String paramString)
  {
    AppMethodBeat.i(178867);
    if ((((r)g.ab(r.class)).VM()) && (wp(paramString)))
    {
      paramString = ((c)g.ab(c.class)).awK().xN(paramString);
      if ((paramString != null) && (paramString.Wp()))
      {
        AppMethodBeat.o(178867);
        return true;
      }
    }
    AppMethodBeat.o(178867);
    return false;
  }
  
  public static boolean wv(String paramString)
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
  
  public static boolean ww(String paramString)
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
  
  public static boolean wx(String paramString)
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
  
  public static boolean wy(String paramString)
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
  
  public static boolean wz(String paramString)
  {
    AppMethodBeat.i(42841);
    boolean bool = "gh_43f2581f6fd6".equals(paramString);
    AppMethodBeat.o(42841);
    return bool;
  }
  
  private static void x(ai paramai)
  {
    AppMethodBeat.i(42871);
    boolean bool;
    bvu localbvu;
    if (paramai != null)
    {
      bool = true;
      Assert.assertTrue(bool);
      if ((int)paramai.fLJ == 0)
      {
        ((com.tencent.mm.plugin.messenger.foundation.a.k)g.ab(com.tencent.mm.plugin.messenger.foundation.a.k.class)).awB().ah(paramai);
        ((com.tencent.mm.plugin.messenger.foundation.a.k)g.ab(com.tencent.mm.plugin.messenger.foundation.a.k.class)).awB().aNt(paramai.field_username);
      }
      ((com.tencent.mm.plugin.messenger.foundation.a.k)g.ab(com.tencent.mm.plugin.messenger.foundation.a.k.class)).awB().c(paramai.field_username, paramai);
      localbvu = new bvu();
      localbvu.Flc = paramai.field_username;
      if (!paramai.aaK()) {
        break label163;
      }
    }
    label163:
    for (localbvu.FkY = 1;; localbvu.FkY = 2)
    {
      ((com.tencent.mm.plugin.messenger.foundation.a.k)g.ab(com.tencent.mm.plugin.messenger.foundation.a.k.class)).awA().c(new j.a(52, localbvu));
      AppMethodBeat.o(42871);
      return;
      bool = false;
      break;
    }
  }
  
  public static boolean xA(String paramString)
  {
    AppMethodBeat.i(178868);
    paramString = ((c)g.ab(c.class)).awK().xN(paramString);
    if (paramString == null)
    {
      AppMethodBeat.o(178868);
      return false;
    }
    boolean bool = paramString.Wp();
    AppMethodBeat.o(178868);
    return bool;
  }
  
  public static boolean xB(String paramString)
  {
    AppMethodBeat.i(184702);
    paramString = ((c)g.ab(c.class)).awK().xN(paramString);
    if (paramString == null)
    {
      AppMethodBeat.o(184702);
      return false;
    }
    boolean bool = paramString.xB(u.axw());
    AppMethodBeat.o(184702);
    return bool;
  }
  
  public static boolean xa(String paramString)
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
  
  public static boolean xb(String paramString)
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
  
  public static boolean xc(String paramString)
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
  
  public static boolean xd(String paramString)
  {
    AppMethodBeat.i(42901);
    boolean bool = xe(paramString);
    AppMethodBeat.o(42901);
    return bool;
  }
  
  public static boolean xe(String paramString)
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
  
  public static boolean xf(String paramString)
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
  
  public static boolean xg(String paramString)
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
  
  public static boolean xh(String paramString)
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
  
  public static boolean xi(String paramString)
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
  
  public static boolean xj(String paramString)
  {
    AppMethodBeat.i(42907);
    boolean bool = "filehelper".equalsIgnoreCase(paramString);
    AppMethodBeat.o(42907);
    return bool;
  }
  
  public static boolean xk(String paramString)
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
  
  public static boolean xl(String paramString)
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
  
  public static boolean xm(String paramString)
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
  
  public static boolean xn(String paramString)
  {
    AppMethodBeat.i(42911);
    if (xo(paramString))
    {
      AppMethodBeat.o(42911);
      return true;
    }
    if (xr(paramString))
    {
      AppMethodBeat.o(42911);
      return true;
    }
    if (xg(paramString))
    {
      AppMethodBeat.o(42911);
      return true;
    }
    if (xh(paramString))
    {
      AppMethodBeat.o(42911);
      return true;
    }
    AppMethodBeat.o(42911);
    return false;
  }
  
  public static boolean xo(String paramString)
  {
    AppMethodBeat.i(42912);
    g.agS();
    String str = (String)g.agR().agA().get(21, null);
    if (((str != null) && (str.equalsIgnoreCase(paramString))) || (paramString.equalsIgnoreCase("weixin")))
    {
      AppMethodBeat.o(42912);
      return true;
    }
    AppMethodBeat.o(42912);
    return false;
  }
  
  public static boolean xp(String paramString)
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
  
  public static boolean xq(String paramString)
  {
    AppMethodBeat.i(194033);
    if (paramString != null)
    {
      boolean bool = paramString.equalsIgnoreCase("appbrand_notify_message");
      AppMethodBeat.o(194033);
      return bool;
    }
    AppMethodBeat.o(194033);
    return false;
  }
  
  public static boolean xr(String paramString)
  {
    AppMethodBeat.i(42914);
    String[] arrayOfString = hmW;
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
  
  public static boolean xs(String paramString)
  {
    AppMethodBeat.i(42915);
    if (xr(paramString))
    {
      AppMethodBeat.o(42915);
      return true;
    }
    if (ai.aNb(paramString))
    {
      AppMethodBeat.o(42915);
      return true;
    }
    if (ai.aMZ(paramString))
    {
      AppMethodBeat.o(42915);
      return true;
    }
    if (ai.ww(paramString))
    {
      AppMethodBeat.o(42915);
      return true;
    }
    AppMethodBeat.o(42915);
    return false;
  }
  
  public static int xt(String paramString)
  {
    AppMethodBeat.i(42916);
    if (bs.nullAsNil(paramString).length() > 0) {}
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
    if (ai.aMZ(paramString))
    {
      AppMethodBeat.o(42916);
      return 11;
    }
    if (ai.aNb(paramString))
    {
      AppMethodBeat.o(42916);
      return 36;
    }
    if (ai.ww(paramString))
    {
      AppMethodBeat.o(42916);
      return 1;
    }
    AppMethodBeat.o(42916);
    return 1;
  }
  
  public static int xu(String paramString)
  {
    AppMethodBeat.i(42917);
    if (bs.nullAsNil(paramString).length() > 0) {}
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
    if (ai.aMZ(paramString))
    {
      AppMethodBeat.o(42917);
      return 13;
    }
    if (ai.aNb(paramString))
    {
      AppMethodBeat.o(42917);
      return 39;
    }
    if (ai.ww(paramString))
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
  
  public static boolean xv(String paramString)
  {
    AppMethodBeat.i(42918);
    if (((com.tencent.mm.plugin.messenger.foundation.a.k)g.ab(com.tencent.mm.plugin.messenger.foundation.a.k.class)).awB().aNt(paramString).exT != 1)
    {
      AppMethodBeat.o(42918);
      return false;
    }
    AppMethodBeat.o(42918);
    return true;
  }
  
  public static boolean xw(String paramString)
  {
    AppMethodBeat.i(42919);
    paramString = ((com.tencent.mm.plugin.messenger.foundation.a.k)g.ab(com.tencent.mm.plugin.messenger.foundation.a.k.class)).awB().aNt(paramString);
    if ((paramString != null) && (paramString.Nw()))
    {
      AppMethodBeat.o(42919);
      return true;
    }
    AppMethodBeat.o(42919);
    return false;
  }
  
  public static boolean xx(String paramString)
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
  
  public static String xy(String paramString)
  {
    AppMethodBeat.i(42921);
    if (xx(paramString))
    {
      paramString = paramString.replace("http://t.qq.com/", "").replace("t.qq.com/", "");
      AppMethodBeat.o(42921);
      return paramString;
    }
    AppMethodBeat.o(42921);
    return "";
  }
  
  public static boolean xz(String paramString)
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
  
  public static void y(ai paramai)
  {
    AppMethodBeat.i(42872);
    boolean bool;
    bvv localbvv;
    if (paramai != null)
    {
      bool = true;
      Assert.assertTrue(bool);
      if ((int)paramai.fLJ == 0)
      {
        ((com.tencent.mm.plugin.messenger.foundation.a.k)g.ab(com.tencent.mm.plugin.messenger.foundation.a.k.class)).awB().ah(paramai);
        ((com.tencent.mm.plugin.messenger.foundation.a.k)g.ab(com.tencent.mm.plugin.messenger.foundation.a.k.class)).awB().aNt(paramai.field_username);
      }
      ((com.tencent.mm.plugin.messenger.foundation.a.k)g.ab(com.tencent.mm.plugin.messenger.foundation.a.k.class)).awB().c(paramai.field_username, paramai);
      localbvv = new bvv();
      localbvv.Flc = paramai.field_username;
      if (!paramai.aaM()) {
        break label163;
      }
    }
    label163:
    for (localbvv.FkY = 1;; localbvv.FkY = 2)
    {
      ((com.tencent.mm.plugin.messenger.foundation.a.k)g.ab(com.tencent.mm.plugin.messenger.foundation.a.k.class)).awA().c(new j.a(72, localbvv));
      AppMethodBeat.o(42872);
      return;
      bool = false;
      break;
    }
  }
  
  public static void z(ai paramai)
  {
    AppMethodBeat.i(42873);
    if (paramai != null) {}
    for (boolean bool = true;; bool = false)
    {
      Assert.assertTrue(bool);
      if ((int)paramai.fLJ == 0)
      {
        ((com.tencent.mm.plugin.messenger.foundation.a.k)g.ab(com.tencent.mm.plugin.messenger.foundation.a.k.class)).awB().ah(paramai);
        ((com.tencent.mm.plugin.messenger.foundation.a.k)g.ab(com.tencent.mm.plugin.messenger.foundation.a.k.class)).awB().aNt(paramai.field_username);
      }
      ((com.tencent.mm.plugin.messenger.foundation.a.k)g.ab(com.tencent.mm.plugin.messenger.foundation.a.k.class)).awB().c(paramai.field_username, paramai);
      if (!ai.aNc(paramai.field_username)) {
        B(paramai);
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