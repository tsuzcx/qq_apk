package com.tencent.mm.plugin.fts.b;

import android.content.Context;
import android.database.Cursor;
import android.os.HandlerThread;
import com.tencent.mm.h.c.ao;
import com.tencent.mm.model.af;
import com.tencent.mm.model.s;
import com.tencent.mm.openim.a.c.b;
import com.tencent.mm.plugin.fts.PluginFTS;
import com.tencent.mm.plugin.fts.a.a.l;
import com.tencent.mm.plugin.fts.a.d;
import com.tencent.mm.plugin.fts.a.n;
import com.tencent.mm.plugin.fts.h.a;
import com.tencent.mm.sdk.e.j.a;
import com.tencent.mm.sdk.e.m.b;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.ai;
import com.tencent.mm.sdk.platformtools.am;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.sdk.platformtools.y;
import com.tencent.mm.storage.ad;
import com.tencent.mm.storage.bd;
import com.tencent.mm.storage.be;
import com.tencent.wcdb.database.SQLiteStatement;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;
import java.util.regex.Pattern;
import junit.framework.AssertionFailedError;

public final class a
  extends com.tencent.mm.plugin.fts.a.b
{
  private static Set<String> kys = new HashSet();
  private com.tencent.mm.plugin.fts.a.m dBO;
  private com.tencent.mm.plugin.fts.a.j kal;
  private com.tencent.mm.plugin.fts.c.a kye;
  private HashSet<String> kyf;
  private HashMap<String, List<Long>> kyg;
  private HashMap<String, String[]> kyh;
  private HashMap<String, List<Long>> kyi;
  private Method kyj;
  private m.b kyk = new a.1(this);
  private m.b kyl = new a.2(this);
  private j.a kym = new a.3(this);
  private j.a kyn = new a.4(this);
  private com.tencent.mm.sdk.b.c kyo = new a.5(this);
  private com.tencent.mm.sdk.b.c kyp = new a.6(this);
  private am kyq = new am(com.tencent.mm.kernel.g.DS().mnU.getLooper(), new a.7(this), true);
  private am kyr = new am(com.tencent.mm.kernel.g.DS().mnU.getLooper(), new a.8(this), false);
  
  static
  {
    String[] arrayOfString = ae.getContext().getString(h.a.country_others).split(";");
    if (arrayOfString != null)
    {
      int j = arrayOfString.length;
      int i = 0;
      while (i < j)
      {
        String str = arrayOfString[i];
        kys.add(str);
        i += 1;
      }
    }
  }
  
  static boolean Ea(String paramString)
  {
    if (bk.bl(paramString)) {}
    while ((paramString.endsWith("@stranger")) || (paramString.endsWith("@qqim")) || (paramString.endsWith("@app")) || (paramString.startsWith("fake_"))) {
      return false;
    }
    return true;
  }
  
  static boolean F(ad paramad)
  {
    if ((paramad.isHidden()) && (!"notifymessage".equals(paramad.field_username))) {}
    while ((paramad.Bg()) || (paramad.field_deleteFlag != 0) || ((!com.tencent.mm.n.a.gR(paramad.field_type)) && ((paramad.Bf()) || (paramad.cua())))) {
      return false;
    }
    return true;
  }
  
  private int a(ad paramad, long paramLong)
  {
    int j = 0;
    Object localObject = paramad.cCU;
    int i = j;
    if (!bk.bl((String)localObject))
    {
      com.tencent.mm.openim.a.c localc = new com.tencent.mm.openim.a.c();
      localc.oT((String)localObject);
      localObject = new StringBuffer();
      i = 0;
      while (i < localc.ePL.size())
      {
        Iterator localIterator = ((com.tencent.mm.openim.a.c.a)localc.ePL.get(i)).ePM.iterator();
        while (localIterator.hasNext())
        {
          String str = ((c.b)localIterator.next()).oU(paramad.field_openImAppid);
          if (!bk.bl(str))
          {
            ((StringBuffer)localObject).append(str);
            ((StringBuffer)localObject).append("‌");
          }
        }
        ((StringBuffer)localObject).append("​");
        i += 1;
      }
      i = j;
      if (!bk.bl(((StringBuffer)localObject).toString()))
      {
        y.i("MicroMsg.FTS.FTS5SearchContactLogic", "buildOpenIMContact %s", new Object[] { ((StringBuffer)localObject).toString() });
        this.kye.a(131081, 51, paramad.dBe, paramad.field_username, paramLong, ((StringBuffer)localObject).toString());
        i = 1;
      }
    }
    return i;
  }
  
  protected final boolean BB()
  {
    this.kyo.dead();
    this.kyp.dead();
    this.kyr.stopTimer();
    this.kyq.stopTimer();
    ((com.tencent.mm.plugin.messenger.foundation.a.j)com.tencent.mm.kernel.g.r(com.tencent.mm.plugin.messenger.foundation.a.j.class)).Fw().b(this.kyl);
    ((com.tencent.mm.plugin.chatroom.a.c)com.tencent.mm.kernel.g.r(com.tencent.mm.plugin.chatroom.a.c.class)).FF().d(this.kym);
    ((com.tencent.mm.plugin.messenger.foundation.a.j)com.tencent.mm.kernel.g.r(com.tencent.mm.plugin.messenger.foundation.a.j.class)).FB().b(this.kyk);
    j.a locala = this.kyn;
    if (com.tencent.mm.au.b.esj != null) {
      com.tencent.mm.au.b.esj.b(locala);
    }
    if (this.kyg != null) {
      this.kyg.clear();
    }
    if (this.kyf != null) {
      this.kyf.clear();
    }
    this.kye = null;
    this.dBO = null;
    return true;
  }
  
  final void E(ad paramad)
  {
    try
    {
      this.kyj.invoke(paramad, new Object[0]);
      return;
    }
    catch (Exception paramad)
    {
      y.printErrStackTrace("MicroMsg.FTS.FTS5SearchContactLogic", paramad, "Failed parsing RContact LVBuffer.", new Object[0]);
    }
  }
  
  final boolean G(ad paramad)
  {
    String str = paramad.field_username;
    if (!F(paramad)) {}
    do
    {
      do
      {
        return false;
      } while (!Ea(str));
      if (com.tencent.mm.n.a.gR(paramad.field_type)) {
        break;
      }
    } while ((paramad.Bf()) || (paramad.cua()) || (!this.kal.DL(str)));
    return true;
    return true;
  }
  
  final int H(ad paramad)
  {
    Object localObject1;
    Object localObject3;
    if (s.fn(paramad.field_username))
    {
      localObject1 = String.format("SELECT memberlist, roomdata FROM %s WHERE chatroomname = ?", new Object[] { "chatroom" });
      localObject3 = this.kal.g((String)localObject1, new String[] { paramad.field_username });
    }
    for (;;)
    {
      try
      {
        if (!((Cursor)localObject3).moveToNext()) {
          break label458;
        }
        localObject2 = ((Cursor)localObject3).getString(0);
        localObject1 = ((Cursor)localObject3).getBlob(1);
        if (localObject3 != null) {
          ((Cursor)localObject3).close();
        }
        if ((bk.bl((String)localObject2)) || (localObject1 == null))
        {
          y.i("MicroMsg.FTS.FTS5SearchContactLogic", "error chatroom data %s", new Object[] { paramad.field_username });
          i = h(paramad.field_username, null);
          if (i > 0) {
            y.i("MicroMsg.FTS.FTS5SearchContactLogic", "updateChatroomMember %s %d", new Object[] { paramad.field_username, Integer.valueOf(i) });
          }
          return 0;
        }
      }
      finally
      {
        if (localObject3 != null) {
          ((Cursor)localObject3).close();
        }
      }
      Object localObject2 = com.tencent.mm.plugin.fts.a.c.a.kvj.split((CharSequence)localObject2);
      Arrays.sort((Object[])localObject2, new a.9(this));
      int i = h(paramad.field_username, (String[])localObject2);
      if (i > 0) {
        y.i("MicroMsg.FTS.FTS5SearchContactLogic", "updateChatroomMember %s %d", new Object[] { paramad.field_username, Integer.valueOf(i) });
      }
      localObject3 = new HashMap();
      Object localObject4 = "SELECT rowid, username, alias, conRemark, nickname , lvbuff FROM rcontact WHERE username IN " + d.w((String[])localObject2) + ";";
      localObject4 = this.kal.g((String)localObject4, null);
      try
      {
        ad localad;
        if (((Cursor)localObject4).moveToNext())
        {
          localad = new ad();
          localad.dBe = ((Cursor)localObject4).getLong(0);
          localad.setUsername(((Cursor)localObject4).getString(1));
          localad.cZ(((Cursor)localObject4).getString(2));
          localad.df(((Cursor)localObject4).getString(3));
          localad.dk(((Cursor)localObject4).getString(4));
          localad.v(((Cursor)localObject4).getBlob(5));
        }
        return a(paramad.field_username, paramad, (String[])localObject2, (byte[])localObject1, (HashMap)localObject3);
      }
      finally
      {
        if (localObject4 != null) {
          ((Cursor)localObject4).close();
        }
      }
      return I(paramad);
      label458:
      localObject1 = null;
      localObject2 = null;
    }
  }
  
  final int I(ad paramad)
  {
    long l2 = paramad.dBe;
    String str1 = paramad.field_username;
    String str4 = paramad.vk();
    Object localObject1 = paramad.field_nickname;
    Object localObject2 = d.aD((String)localObject1, false);
    Object localObject3 = d.aD((String)localObject1, true);
    Object localObject7 = paramad.field_conRemark;
    Object localObject6 = d.aD((String)localObject7, false);
    Object localObject8 = d.aD((String)localObject7, true);
    String str2 = paramad.cCJ;
    Object localObject4 = paramad.field_contactLabelIds;
    String str3 = paramad.cCP;
    int i = paramad.field_verifyFlag;
    Object localObject9 = "";
    long l1 = System.currentTimeMillis();
    int j;
    Object localObject5;
    if ((i & ad.cuc()) != 0)
    {
      j = 131076;
      localObject5 = bk.c(((com.tencent.mm.api.i)com.tencent.mm.kernel.g.r(com.tencent.mm.api.i.class)).cb(str1), "​");
      i = 0;
    }
    for (;;)
    {
      localObject4 = d.dk(str1, str4);
      label215:
      int k;
      if ((localObject4 != null) && (((String)localObject4).length() != 0))
      {
        this.kye.a(j, 15, l2, str1, l1, (String)localObject4);
        i += 1;
        if ((localObject7 == null) || (((String)localObject7).length() == 0))
        {
          localObject9 = null;
          localObject8 = null;
          localObject4 = localObject2;
          localObject7 = localObject1;
          localObject6 = null;
          localObject2 = localObject9;
          localObject1 = localObject8;
          k = i;
          if (localObject7 != null)
          {
            k = i;
            if (((String)localObject7).length() != 0)
            {
              if (!((String)localObject7).equalsIgnoreCase((String)localObject4)) {
                break label1481;
              }
              localObject4 = null;
              label247:
              if ((localObject4 != null) && (((String)localObject4).length() != 0) && (!((String)localObject4).equalsIgnoreCase((String)localObject3))) {
                break label1478;
              }
              localObject3 = null;
              label273:
              this.kye.a(j, 1, l2, str1, l1, (String)localObject7);
              if ((localObject4 != null) && (((String)localObject4).length() != 0)) {
                this.kye.a(j, 2, l2, str1, l1, (String)localObject4);
              }
              if ((localObject3 != null) && (((String)localObject3).length() != 0)) {
                this.kye.a(j, 3, l2, str1, l1, (String)localObject3);
              }
              k = i + 3;
            }
          }
          if ((localObject6 != null) && (((String)localObject6).length() != 0))
          {
            localObject3 = localObject2;
            if (((String)localObject6).equalsIgnoreCase((String)localObject2)) {
              localObject3 = null;
            }
            if ((localObject3 == null) || (((String)localObject3).length() == 0) || (((String)localObject3).equalsIgnoreCase((String)localObject1)))
            {
              localObject1 = null;
              label411:
              this.kye.a(j, 5, l2, str1, l1, (String)localObject6);
              if ((localObject3 != null) && (((String)localObject3).length() != 0)) {
                this.kye.a(j, 6, l2, str1, l1, (String)localObject3);
              }
              if ((localObject1 != null) && (((String)localObject1).length() != 0)) {
                this.kye.a(j, 7, l2, str1, l1, (String)localObject1);
              }
              i = k + 3;
              label495:
              k = i;
              if (str2 != null)
              {
                k = i;
                if (str2.length() > 0)
                {
                  this.kye.a(j, 4, l2, str1, l1, str2);
                  k = i + 1;
                }
              }
              i = k;
              if (j == 131072)
              {
                if (bk.bl(str3)) {
                  break label1381;
                }
                localObject1 = str3.replace(",", "​");
                this.kye.a(j, 16, l2, str1, l1, (String)localObject1);
                i = k + 1;
                localObject2 = paramad.getProvince();
                localObject1 = localObject2;
                if (kys.contains(localObject2)) {
                  localObject1 = "";
                }
                k = i;
                if (localObject1 != null)
                {
                  k = i;
                  if (((String)localObject1).length() != 0)
                  {
                    this.kye.a(j, 18, l2, str1, l1, (String)localObject1);
                    k = i + 1;
                  }
                }
                localObject1 = paramad.getCity();
                i = k;
                if (localObject1 != null)
                {
                  i = k;
                  if (((String)localObject1).length() != 0)
                  {
                    this.kye.a(j, 17, l2, str1, l1, (String)localObject1);
                    i = k + 1;
                  }
                }
              }
              k = i;
              if (j == 131076)
              {
                k = i;
                if (!bk.bl((String)localObject5))
                {
                  this.kye.a(j, 19, l2, str1, l1, (String)localObject5);
                  k = i + 1;
                  localObject1 = d.aD((String)localObject5, false);
                  i = k;
                  if (!bk.bl((String)localObject1))
                  {
                    this.kye.a(j, 20, l2, str1, l1, (String)localObject1);
                    i = k + 1;
                  }
                  localObject1 = d.aD((String)localObject5, true);
                  k = i;
                  if (!bk.bl((String)localObject1))
                  {
                    this.kye.a(j, 21, l2, str1, l1, (String)localObject1);
                    i += 1;
                    label835:
                    k = i;
                    if (j == 131081) {
                      k = i + a(paramad, l1);
                    }
                    return k;
                    if (ad.aaU(str1))
                    {
                      j = 131081;
                      i = 0;
                      localObject5 = localObject9;
                      continue;
                    }
                    l1 = this.kal.DM(str1);
                    if ((localObject4 == null) || (((String)localObject4).length() <= 0)) {
                      break label1527;
                    }
                    if (localObject4 != null)
                    {
                      if (!((String)localObject4).endsWith("")) {
                        break label1524;
                      }
                      localObject4 = ((String)localObject4).substring(0, ((String)localObject4).length() - 1);
                    }
                  }
                }
              }
            }
          }
        }
      }
      label947:
      label1346:
      label1381:
      label1524:
      for (;;)
      {
        if (((String)localObject4).length() == 0) {
          for (i = 0;; i = 0)
          {
            i += 0;
            j = 131072;
            localObject5 = localObject9;
            break;
          }
        }
        Object localObject10 = com.tencent.mm.plugin.fts.a.c.a.kvq.split((CharSequence)localObject4);
        if (localObject10.length != 0)
        {
          localObject5 = new ArrayList(localObject10.length);
          j = localObject10.length;
          i = 0;
          while (i < j)
          {
            ((List)localObject5).add(Long.valueOf(bk.getLong(localObject10[i], 0L)));
            i += 1;
          }
        }
        for (;;)
        {
          localObject10 = (List)this.kyi.get(str1);
          if (localObject10 == null)
          {
            this.kye.Ee(str1);
            if ((localObject5 != null) && (!((List)localObject5).isEmpty()))
            {
              this.kye.k(str1, (List)localObject5);
              this.kyi.put(str1, localObject5);
            }
          }
          for (;;)
          {
            localObject4 = this.kal.DN((String)localObject4);
            if (((List)localObject4).size() != 0) {
              break label1346;
            }
            i = 0;
            break;
            if ((localObject5 == null) || (((List)localObject5).isEmpty()))
            {
              this.kye.Ee(str1);
              this.kyi.remove(str1);
            }
            else
            {
              localObject10 = new HashSet((Collection)localObject10);
              Object localObject11 = ((List)localObject5).iterator();
              long l3;
              while (((Iterator)localObject11).hasNext())
              {
                l3 = ((Long)((Iterator)localObject11).next()).longValue();
                if (!((HashSet)localObject10).remove(Long.valueOf(l3)))
                {
                  com.tencent.mm.plugin.fts.c.a locala = this.kye;
                  locala.kzK.bindString(1, str1);
                  locala.kzK.bindLong(2, l3);
                  locala.kzK.execute();
                }
              }
              localObject10 = ((HashSet)localObject10).iterator();
              while (((Iterator)localObject10).hasNext())
              {
                l3 = ((Long)((Iterator)localObject10).next()).longValue();
                localObject11 = this.kye;
                ((com.tencent.mm.plugin.fts.c.a)localObject11).kzL.bindString(1, str1);
                ((com.tencent.mm.plugin.fts.c.a)localObject11).kzL.bindLong(2, l3);
                ((com.tencent.mm.plugin.fts.c.a)localObject11).kzL.execute();
              }
              this.kyi.put(str1, localObject5);
            }
          }
          localObject4 = bk.c((List)localObject4, "​");
          this.kye.a(131072, 11, l2, str1, l1, (String)localObject4);
          i = 1;
          break label947;
          localObject1 = this.kal.g("SELECT moblie FROM addr_upload2 WHERE username=?;", new String[] { str1 });
          if (((Cursor)localObject1).moveToFirst())
          {
            localObject2 = ((Cursor)localObject1).getString(0);
            this.kye.a(j, 16, l2, str1, l1, (String)localObject2);
          }
          for (i = k + 1;; i = k)
          {
            ((Cursor)localObject1).close();
            break;
            i = k;
            break label835;
          }
          break label411;
          i = k;
          break label495;
          break label273;
          break label247;
          localObject4 = localObject8;
          localObject8 = localObject3;
          localObject9 = localObject1;
          localObject3 = localObject4;
          localObject4 = localObject6;
          localObject1 = localObject8;
          localObject6 = localObject9;
          break label215;
          break;
          localObject5 = null;
        }
      }
      label1478:
      label1481:
      label1527:
      i = 0;
      j = 131072;
      localObject5 = localObject9;
    }
  }
  
  final int a(String paramString, ad paramad, String[] paramArrayOfString, byte[] paramArrayOfByte, HashMap<String, ad> paramHashMap)
  {
    int j = 0;
    paramad = paramad.field_nickname;
    String str1 = d.aD(paramad, false);
    String str2 = d.aD(paramad, true);
    long l1 = 0L;
    long l3 = this.kal.DM(paramString);
    StringBuffer localStringBuffer = new StringBuffer();
    if (paramArrayOfString != null)
    {
      long l2 = paramArrayOfString.length;
      HashMap localHashMap = new HashMap();
      Object localObject = new com.tencent.mm.k.a.a.a();
      int k;
      try
      {
        ((com.tencent.mm.k.a.a.a)localObject).aH(paramArrayOfByte);
        paramArrayOfByte = ((com.tencent.mm.k.a.a.a)localObject).dtH.iterator();
        while (paramArrayOfByte.hasNext())
        {
          localObject = (com.tencent.mm.k.a.a.b)paramArrayOfByte.next();
          if (!bk.bl(((com.tencent.mm.k.a.a.b)localObject).dtK)) {
            localHashMap.put(((com.tencent.mm.k.a.a.b)localObject).userName, ((com.tencent.mm.k.a.a.b)localObject).dtK);
          }
        }
      }
      catch (Exception paramArrayOfByte)
      {
        for (;;)
        {
          y.printErrStackTrace("MicroMsg.FTS.FTS5SearchContactLogic", paramArrayOfByte, "parse chatroom data", new Object[0]);
        }
        k = paramArrayOfString.length;
        i = 0;
      }
      for (;;)
      {
        l1 = l2;
        if (i >= k) {
          break;
        }
        paramArrayOfByte = paramArrayOfString[i];
        localObject = (ad)paramHashMap.get(paramArrayOfByte);
        if (localObject != null)
        {
          String str4 = ((ao)localObject).field_conRemark;
          String str3 = ((ao)localObject).field_nickname;
          String str5 = d.aD(str4, false);
          String str6 = d.aD(str4, true);
          localStringBuffer.append(bk.aM(str4, " ")).append("‌");
          localStringBuffer.append(bk.aM(str5, " ")).append("‌");
          localStringBuffer.append(bk.aM(str6, " ")).append("‌");
          str4 = d.aD(str3, false);
          str5 = d.aD(str3, true);
          localStringBuffer.append(bk.aM(str3, " ")).append("‌");
          localStringBuffer.append(bk.aM(str4, " ")).append("‌");
          localStringBuffer.append(bk.aM(str5, " ")).append("‌");
          localStringBuffer.append(bk.aM((String)localHashMap.get(paramArrayOfByte), " ")).append("‌");
          E((ad)localObject);
          localStringBuffer.append(bk.aM(((ao)localObject).cCJ, " ")).append("‌");
          localStringBuffer.append(bk.aM(d.dk(paramArrayOfByte, ((ad)localObject).vk()), " ")).append("‌");
          localStringBuffer.append("​");
        }
        i += 1;
      }
    }
    int i = j;
    if (!bk.bl(paramad))
    {
      this.kye.a(131075, 5, l1, paramString, l3, paramad);
      if (bk.bl(str1)) {
        break label623;
      }
      this.kye.a(131075, 6, l1, paramString, l3, str1);
    }
    label623:
    for (j = 2;; j = 1)
    {
      i = j;
      if (!bk.bl(str2))
      {
        this.kye.a(131075, 7, l1, paramString, l3, str2);
        i = j + 1;
      }
      j = i;
      if (localStringBuffer.length() > 0)
      {
        localStringBuffer.setLength(localStringBuffer.length() - 1);
        this.kye.a(131075, 38, l1, paramString, l3, localStringBuffer.toString());
        j = i + 1;
      }
      return j;
    }
  }
  
  public final com.tencent.mm.plugin.fts.a.a.a a(com.tencent.mm.plugin.fts.a.a.i parami)
  {
    switch (parami.kwX)
    {
    default: 
      parami = new j(parami);
    }
    for (;;)
    {
      return this.dBO.a(-65536, parami);
      parami = new a.q(this, parami);
      continue;
      parami = new a.n(this, parami);
      continue;
      parami = new a.t(this, parami);
      continue;
      parami = new s(parami);
      continue;
      parami = new a.l(this, parami);
      continue;
      parami = new a.k(this, parami);
      continue;
      parami = new a.m(this, parami);
      continue;
      parami = new a.r(this, parami);
      continue;
      parami = new a.o(this, parami);
      continue;
      parami = new a.p(this, parami);
    }
  }
  
  public final String getName()
  {
    return "FTS5SearchContactLogic";
  }
  
  public final int h(String paramString, String[] paramArrayOfString)
  {
    Object localObject = (String[])this.kyh.get(paramString);
    this.kye.beginTransaction();
    int j;
    int i;
    if (localObject == null)
    {
      this.kye.Eg(paramString);
      j = (int)this.kye.kzN.simpleQueryForLong() + 0;
      i = j;
      if (paramArrayOfString != null)
      {
        this.kye.i(paramString, paramArrayOfString);
        this.kyh.put(paramString, paramArrayOfString);
        i = j + paramArrayOfString.length;
      }
    }
    for (;;)
    {
      this.kye.commit();
      return i;
      if (paramArrayOfString == null)
      {
        this.kye.Eg(paramString);
        i = (int)this.kye.kzN.simpleQueryForLong() + 0;
        this.kyh.remove(paramString);
      }
      else
      {
        localObject = new HashSet(Arrays.asList((Object[])localObject));
        int m = paramArrayOfString.length;
        j = 0;
        String str;
        int k;
        com.tencent.mm.plugin.fts.c.a locala;
        for (i = 0; j < m; i = k)
        {
          str = paramArrayOfString[j];
          k = i;
          if (!((HashSet)localObject).remove(str))
          {
            locala = this.kye;
            locala.kzH.bindString(1, paramString);
            locala.kzH.bindString(2, str);
            locala.kzH.execute();
            k = i + 1;
          }
          j += 1;
        }
        localObject = ((HashSet)localObject).iterator();
        while (((Iterator)localObject).hasNext())
        {
          str = (String)((Iterator)localObject).next();
          locala = this.kye;
          locala.kzI.bindString(1, paramString);
          locala.kzI.bindString(2, str);
          locala.kzI.execute();
          i += 1;
        }
        this.kyh.put(paramString, paramArrayOfString);
      }
    }
  }
  
  protected final boolean onCreate()
  {
    if (!((n)com.tencent.mm.kernel.g.t(n.class)).isFTSContextReady())
    {
      y.i("MicroMsg.FTS.FTS5SearchContactLogic", "Create Fail!");
      return false;
    }
    y.i("MicroMsg.FTS.FTS5SearchContactLogic", "Create Success!");
    this.kye = ((com.tencent.mm.plugin.fts.c.a)((n)com.tencent.mm.kernel.g.t(n.class)).getFTSIndexStorage(3));
    this.dBO = ((n)com.tencent.mm.kernel.g.t(n.class)).getFTSTaskDaemon();
    this.kal = ((n)com.tencent.mm.kernel.g.t(n.class)).getFTSMainDB();
    this.kyf = new HashSet();
    this.kyg = new HashMap();
    this.kyh = new HashMap();
    this.kyi = new HashMap();
    try
    {
      this.kyj = ao.class.getDeclaredMethod("vq", new Class[0]);
      this.kyj.setAccessible(true);
      this.dBO.a(131072, new a.f(this, (byte)0));
      this.dBO.a(131082, new a((byte)0));
      this.dBO.a(131092, new a.b(this, (byte)0));
      this.dBO.a(2147483647, new a.c(this, (byte)0));
      ((com.tencent.mm.plugin.chatroom.a.c)com.tencent.mm.kernel.g.r(com.tencent.mm.plugin.chatroom.a.c.class)).FF().c(this.kym);
      ((com.tencent.mm.plugin.messenger.foundation.a.j)com.tencent.mm.kernel.g.r(com.tencent.mm.plugin.messenger.foundation.a.j.class)).Fw().a(this.kyl);
      ((com.tencent.mm.plugin.messenger.foundation.a.j)com.tencent.mm.kernel.g.r(com.tencent.mm.plugin.messenger.foundation.a.j.class)).FB().a(this.kyk);
      j.a locala = this.kyn;
      if (com.tencent.mm.au.b.esj != null) {
        com.tencent.mm.au.b.esj.a(locala);
      }
      this.kyq.S(600000L, 600000L);
      this.kyo.cqo();
      this.kyp.cqo();
      return true;
    }
    catch (NoSuchMethodException localNoSuchMethodException)
    {
      AssertionFailedError localAssertionFailedError = new AssertionFailedError("Can't find BaseContact.parseBuff method, class prototype has changed.");
      localAssertionFailedError.initCause(localNoSuchMethodException);
      throw localAssertionFailedError;
    }
  }
  
  private final class a
    extends com.tencent.mm.plugin.fts.a.a.a
  {
    private int kas = 0;
    private int kat = 0;
    
    private a() {}
    
    public final String afJ()
    {
      return String.format("{new: %d removed: %d}", new Object[] { Integer.valueOf(this.kas), Integer.valueOf(this.kat) });
    }
    
    public final boolean execute()
    {
      y.i("MicroMsg.FTS.FTS5SearchContactLogic", "Start building chatroom index.");
      Object localObject1 = new HashSet();
      Object localObject2 = a.a(a.this).kuE.rawQuery("SELECT DISTINCT chatroom FROM FTS5ChatRoomMembers;", null);
      while (((Cursor)localObject2).moveToNext()) {
        ((HashSet)localObject1).add(((Cursor)localObject2).getString(0));
      }
      ((Cursor)localObject2).close();
      localObject2 = a.d(a.this).g("SELECT chatroomname, memberlist FROM chatroom;", null);
      int i = 5;
      int j;
      while (((Cursor)localObject2).moveToNext())
      {
        if (Thread.interrupted())
        {
          ((Cursor)localObject2).close();
          a.a(a.this).commit();
          throw new InterruptedException();
        }
        String str = ((Cursor)localObject2).getString(0);
        String[] arrayOfString = com.tencent.mm.plugin.fts.a.c.a.kvj.split(((Cursor)localObject2).getString(1));
        a.f(a.this).put(str, arrayOfString);
        if (!((HashSet)localObject1).remove(str))
        {
          j = i;
          if (i >= 5)
          {
            a.a(a.this).commit();
            a.a(a.this).beginTransaction();
            j = 0;
          }
          a.a(a.this).i(str, arrayOfString);
          i = j + 1;
          this.kas += 1;
        }
      }
      ((Cursor)localObject2).close();
      a.a(a.this).commit();
      localObject1 = ((HashSet)localObject1).iterator();
      for (i = 5; ((Iterator)localObject1).hasNext(); i = j + 1)
      {
        localObject2 = (String)((Iterator)localObject1).next();
        j = i;
        if (i >= 5)
        {
          a.a(a.this).commit();
          a.a(a.this).beginTransaction();
          j = 0;
        }
        a.a(a.this).Eg((String)localObject2);
        this.kat += 1;
      }
      a.a(a.this).commit();
      return true;
    }
    
    public final int getId()
    {
      return 3;
    }
    
    public final String getName()
    {
      return "BuildChatroomIndexTask";
    }
  }
  
  private final class h
    extends com.tencent.mm.plugin.fts.a.a.a
  {
    private boolean dCg = false;
    private String djD;
    private boolean kyM = false;
    
    public h(String paramString)
    {
      this.djD = paramString;
    }
    
    public final String afJ()
    {
      return String.format("{username: %s cached: %b isSkipped: %b}", new Object[] { this.djD, Boolean.valueOf(this.kyM), Boolean.valueOf(this.dCg) });
    }
    
    public final boolean execute()
    {
      y.i("MicroMsg.FTS.FTS5SearchContactLogic", "Dirty Contact %s", new Object[] { this.djD });
      if (a.b(a.this).containsKey(this.djD))
      {
        this.kyM = true;
        return true;
      }
      a.a(a.this).DO(this.djD);
      Object localObject1 = a.a(a.this).c(com.tencent.mm.plugin.fts.a.c.kuV, this.djD);
      a.b(a.this).put(this.djD, localObject1);
      if (((List)localObject1).isEmpty())
      {
        this.dCg = true;
        a.e(a.this).a(65556, new a.e(a.this, this.djD));
        return true;
      }
      localObject1 = a.a(a.this).Ef(this.djD);
      Object localObject2 = new HashSet();
      while (((Cursor)localObject1).moveToNext()) {
        ((HashSet)localObject2).add(((Cursor)localObject1).getString(0));
      }
      ((Cursor)localObject1).close();
      localObject1 = ((HashSet)localObject2).iterator();
      while (((Iterator)localObject1).hasNext())
      {
        localObject2 = (String)((Iterator)localObject1).next();
        a.a(a.this).DO((String)localObject2);
        if (!a.b(a.this).containsKey(localObject2))
        {
          List localList = a.a(a.this).c(com.tencent.mm.plugin.fts.a.c.kuV, (String)localObject2);
          a.b(a.this).put(localObject2, localList);
        }
      }
      a.c(a.this).remove(this.djD);
      ((PluginFTS)com.tencent.mm.kernel.g.t(PluginFTS.class)).getTopHitsLogic().Ed(this.djD);
      return true;
    }
    
    public final int getId()
    {
      return 17;
    }
    
    public final String getName()
    {
      return "MarkContactDirtyTask";
    }
  }
  
  private final class j
    extends com.tencent.mm.plugin.fts.a.a.h
  {
    public j(com.tencent.mm.plugin.fts.a.a.i parami)
    {
      super();
    }
    
    protected final void a(com.tencent.mm.plugin.fts.a.a.j paramj)
    {
      paramj.kwi = com.tencent.mm.plugin.fts.a.a.g.aF(this.kwT.bVk, true);
      Object localObject1 = a.a(a.this).a(paramj.kwi, this.kwT.kxa, this.kwT.kxb, true, true);
      Object localObject2 = new HashMap();
      HashMap localHashMap = new HashMap();
      while (((Cursor)localObject1).moveToNext())
      {
        com.tencent.mm.plugin.fts.a.a.m localm = new com.tencent.mm.plugin.fts.a.a.m().j((Cursor)localObject1);
        if (!this.kwT.kxd.contains(localm.kwg))
        {
          l locall;
          if (d.g(com.tencent.mm.plugin.fts.a.c.kuV, localm.type))
          {
            locall = (l)((HashMap)localObject2).get(localm.kwg);
            if ((locall == null) || (d.e(com.tencent.mm.plugin.fts.a.c.kvg, localm.kwf, locall.kwf) < 0)) {
              ((HashMap)localObject2).put(localm.kwg, localm);
            }
          }
          while (Thread.interrupted())
          {
            ((Cursor)localObject1).close();
            throw new InterruptedException();
            if (d.g(com.tencent.mm.plugin.fts.a.c.kuX, localm.type))
            {
              locall = (l)localHashMap.get(Long.valueOf(localm.kxk));
              if ((locall == null) || (d.e(com.tencent.mm.plugin.fts.a.c.kvg, localm.kwf, locall.kwf) < 0)) {
                localHashMap.put(Long.valueOf(localm.kxk), localm);
              }
            }
          }
        }
      }
      ((Cursor)localObject1).close();
      if (Thread.interrupted()) {
        throw new InterruptedException();
      }
      paramj.kxh = new ArrayList(((HashMap)localObject2).size());
      localObject1 = ((HashMap)localObject2).values().iterator();
      while (((Iterator)localObject1).hasNext())
      {
        localObject2 = (com.tencent.mm.plugin.fts.a.a.m)((Iterator)localObject1).next();
        ((com.tencent.mm.plugin.fts.a.a.m)localObject2).aVA();
        ((com.tencent.mm.plugin.fts.a.a.m)localObject2).a(paramj.kwi);
        paramj.kxh.add(localObject2);
      }
      paramj.kxh.addAll(localHashMap.values());
      if (Thread.interrupted()) {
        throw new InterruptedException();
      }
      if (this.kwT.kxe != null) {
        Collections.sort(paramj.kxh, this.kwT.kxe);
      }
    }
    
    public final int getId()
    {
      return 11;
    }
    
    public final String getName()
    {
      return "SearchContactLogic.SearchTask";
    }
  }
  
  private final class s
    extends com.tencent.mm.plugin.fts.a.a.h
  {
    public s(com.tencent.mm.plugin.fts.a.a.i parami)
    {
      super();
    }
    
    protected final void a(com.tencent.mm.plugin.fts.a.a.j paramj)
    {
      paramj.kwi = com.tencent.mm.plugin.fts.a.a.g.aF(this.kwT.bVk, true);
      Object localObject1 = a.a(a.this);
      Object localObject2 = paramj.kwi;
      Object localObject3 = this.kwT.kxa;
      Object localObject4 = ((com.tencent.mm.plugin.fts.a.a.g)localObject2).aVy();
      long l1 = System.currentTimeMillis();
      long l2 = ((com.tencent.mm.plugin.fts.a.a.g)localObject2).kwK.size();
      localObject3 = String.format("SELECT %s.docid, type, subtype, entity_id, aux_index, timestamp, content, MMHighlight(%s, %d, type, subtype), MMContactRank(%s, timestamp / 1000 - %d / 1000, subtype, ?, %d) AS Rank FROM %s NOT INDEXED JOIN %s ON (%s.docid = %s.rowid) WHERE %s MATCH '%s' AND type IN " + d.l((int[])localObject3) + " ORDER BY Rank ;", new Object[] { ((com.tencent.mm.plugin.fts.c.a)localObject1).aVs(), ((com.tencent.mm.plugin.fts.c.a)localObject1).aVt(), Long.valueOf(l2), ((com.tencent.mm.plugin.fts.c.a)localObject1).aVt(), Long.valueOf(l1 - 1105032704L), Long.valueOf(l2), ((com.tencent.mm.plugin.fts.c.a)localObject1).aVs(), ((com.tencent.mm.plugin.fts.c.a)localObject1).aVt(), ((com.tencent.mm.plugin.fts.c.a)localObject1).aVs(), ((com.tencent.mm.plugin.fts.c.a)localObject1).aVt(), ((com.tencent.mm.plugin.fts.c.a)localObject1).aVt(), localObject4 });
      localObject1 = ((com.tencent.mm.plugin.fts.a.a)localObject1).kuE.rawQuery((String)localObject3, new String[] { ((com.tencent.mm.plugin.fts.a.a.g)localObject2).kwH });
      localObject2 = new ArrayList();
      localObject3 = new HashSet();
      ((HashSet)localObject3).addAll(this.kwT.kxd);
      l1 = 0L;
      while (((Cursor)localObject1).moveToNext())
      {
        localObject4 = new com.tencent.mm.plugin.fts.a.a.m().i((Cursor)localObject1);
        if (((HashSet)localObject3).add(((com.tencent.mm.plugin.fts.a.a.m)localObject4).kwg))
        {
          if (l1 >= ((com.tencent.mm.plugin.fts.a.a.m)localObject4).kxs) {
            ((List)localObject2).add(localObject4);
          }
          while (Thread.interrupted())
          {
            ((Cursor)localObject1).close();
            throw new InterruptedException("Task is Cancel: " + this.kwT.bVk);
            if (((List)localObject2).size() > this.kwT.kxc) {
              break label395;
            }
            l1 = ((com.tencent.mm.plugin.fts.a.a.m)localObject4).kxs;
            ((List)localObject2).add(localObject4);
          }
        }
      }
      label395:
      ((Cursor)localObject1).close();
      paramj.kxh = new ArrayList();
      localObject1 = ((List)localObject2).iterator();
      while (((Iterator)localObject1).hasNext())
      {
        localObject2 = (com.tencent.mm.plugin.fts.a.a.m)((Iterator)localObject1).next();
        ((com.tencent.mm.plugin.fts.a.a.m)localObject2).aVA();
        ((com.tencent.mm.plugin.fts.a.a.m)localObject2).a(paramj.kwi);
        paramj.kxh.add(localObject2);
      }
      if (this.kwT.kxe != null) {
        Collections.sort(paramj.kxh, this.kwT.kxe);
      }
    }
    
    public final int getId()
    {
      return 26;
    }
    
    public final String getName()
    {
      return "SearchTopContactInnerRankTask";
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.fts.b.a
 * JD-Core Version:    0.7.0.1
 */