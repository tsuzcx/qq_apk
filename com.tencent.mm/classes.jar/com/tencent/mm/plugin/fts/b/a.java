package com.tencent.mm.plugin.fts.b;

import android.content.Context;
import android.database.Cursor;
import android.os.HandlerThread;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.c.aq;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.ag;
import com.tencent.mm.model.t;
import com.tencent.mm.openim.a.c.b;
import com.tencent.mm.plugin.fts.PluginFTS;
import com.tencent.mm.plugin.fts.a.a.i;
import com.tencent.mm.plugin.fts.a.d;
import com.tencent.mm.plugin.fts.a.m;
import com.tencent.mm.plugin.fts.a.n;
import com.tencent.mm.sdk.e.k.a;
import com.tencent.mm.sdk.e.n.b;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.al;
import com.tencent.mm.sdk.platformtools.ap;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.storage.ad;
import com.tencent.mm.storage.bd;
import com.tencent.mm.storage.be;
import com.tencent.wcdb.database.SQLiteStatement;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
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
  private static Set<String> mUf;
  private m ezf;
  private com.tencent.mm.plugin.fts.c.a mTR;
  private HashSet<String> mTS;
  private HashMap<String, List<Long>> mTT;
  private HashMap<String, String[]> mTU;
  private HashMap<String, List<Long>> mTV;
  private Method mTW;
  private n.b mTX;
  private n.b mTY;
  private k.a mTZ;
  private k.a mUa;
  private com.tencent.mm.sdk.b.c mUb;
  private com.tencent.mm.sdk.b.c mUc;
  private ap mUd;
  private ap mUe;
  private com.tencent.mm.plugin.fts.a.j muH;
  
  static
  {
    AppMethodBeat.i(136713);
    mUf = new HashSet();
    String[] arrayOfString = ah.getContext().getString(2131298874).split(";");
    if (arrayOfString != null)
    {
      int j = arrayOfString.length;
      int i = 0;
      while (i < j)
      {
        String str = arrayOfString[i];
        mUf.add(str);
        i += 1;
      }
    }
    AppMethodBeat.o(136713);
  }
  
  public a()
  {
    AppMethodBeat.i(136702);
    this.mTX = new a.1(this);
    this.mTY = new a.2(this);
    this.mTZ = new a.3(this);
    this.mUa = new a.4(this);
    this.mUb = new a.5(this);
    this.mUc = new a.6(this);
    this.mUd = new ap(g.RO().oNc.getLooper(), new a.7(this), true);
    this.mUe = new ap(g.RO().oNc.getLooper(), new a.8(this), false);
    AppMethodBeat.o(136702);
  }
  
  static boolean G(ad paramad)
  {
    AppMethodBeat.i(136705);
    if ((paramad.isHidden()) && (!"notifymessage".equals(paramad.field_username)))
    {
      AppMethodBeat.o(136705);
      return false;
    }
    if (paramad.NW())
    {
      AppMethodBeat.o(136705);
      return false;
    }
    if (paramad.field_deleteFlag != 0)
    {
      AppMethodBeat.o(136705);
      return false;
    }
    if (!com.tencent.mm.n.a.je(paramad.field_type))
    {
      if (paramad.NV())
      {
        AppMethodBeat.o(136705);
        return false;
      }
      if (paramad.dwz())
      {
        AppMethodBeat.o(136705);
        return false;
      }
    }
    AppMethodBeat.o(136705);
    return true;
  }
  
  static boolean Pk(String paramString)
  {
    AppMethodBeat.i(136704);
    if (bo.isNullOrNil(paramString))
    {
      AppMethodBeat.o(136704);
      return false;
    }
    if (paramString.endsWith("@stranger"))
    {
      AppMethodBeat.o(136704);
      return false;
    }
    if (paramString.endsWith("@qqim"))
    {
      AppMethodBeat.o(136704);
      return false;
    }
    if (paramString.endsWith("@app"))
    {
      AppMethodBeat.o(136704);
      return false;
    }
    if (paramString.startsWith("fake_"))
    {
      AppMethodBeat.o(136704);
      return false;
    }
    AppMethodBeat.o(136704);
    return true;
  }
  
  private int a(long paramLong1, String paramString1, String paramString2, long paramLong2)
  {
    AppMethodBeat.i(136711);
    String str;
    if (paramString2 != null)
    {
      str = paramString2;
      if (paramString2.endsWith("")) {
        str = paramString2.substring(0, paramString2.length() - 1);
      }
      if (str.length() == 0)
      {
        AppMethodBeat.o(136711);
        return 0;
      }
    }
    else
    {
      AppMethodBeat.o(136711);
      return 0;
    }
    ez(paramString1, str);
    paramString2 = this.muH.OW(str);
    if (paramString2.size() == 0)
    {
      AppMethodBeat.o(136711);
      return 0;
    }
    paramString2 = bo.d(paramString2, "​");
    this.mTR.a(131072, 11, paramLong1, paramString1, paramLong2, paramString2);
    AppMethodBeat.o(136711);
    return 1;
  }
  
  private int a(ad paramad, long paramLong)
  {
    int j = 0;
    AppMethodBeat.i(136709);
    Object localObject = paramad.dre;
    int i = j;
    if (!bo.isNullOrNil((String)localObject))
    {
      com.tencent.mm.openim.a.c localc = new com.tencent.mm.openim.a.c();
      localc.wl((String)localObject);
      localObject = new StringBuffer();
      i = 0;
      while (i < localc.gfG.size())
      {
        Iterator localIterator = ((com.tencent.mm.openim.a.c.a)localc.gfG.get(i)).gfH.iterator();
        while (localIterator.hasNext())
        {
          String str = ((c.b)localIterator.next()).wm(paramad.field_openImAppid);
          if (!bo.isNullOrNil(str))
          {
            ((StringBuffer)localObject).append(str);
            ((StringBuffer)localObject).append("‌");
          }
        }
        ((StringBuffer)localObject).append("​");
        i += 1;
      }
      i = j;
      if (!bo.isNullOrNil(((StringBuffer)localObject).toString()))
      {
        this.mTR.a(131081, 51, paramad.euF, paramad.field_username, paramLong, ((StringBuffer)localObject).toString());
        i = 1;
      }
    }
    AppMethodBeat.o(136709);
    return i;
  }
  
  private void ez(String paramString1, String paramString2)
  {
    AppMethodBeat.i(136710);
    Object localObject1 = com.tencent.mm.plugin.fts.a.c.a.mRd.split(paramString2);
    if (localObject1.length != 0)
    {
      paramString2 = new ArrayList(localObject1.length);
      int j = localObject1.length;
      int i = 0;
      while (i < j)
      {
        paramString2.add(Long.valueOf(bo.getLong(localObject1[i], 0L)));
        i += 1;
      }
    }
    for (;;)
    {
      localObject1 = (List)this.mTV.get(paramString1);
      if (localObject1 == null)
      {
        this.mTR.Po(paramString1);
        if ((paramString2 != null) && (!paramString2.isEmpty()))
        {
          this.mTR.l(paramString1, paramString2);
          this.mTV.put(paramString1, paramString2);
          AppMethodBeat.o(136710);
        }
      }
      else
      {
        if ((paramString2 == null) || (paramString2.isEmpty()))
        {
          this.mTR.Po(paramString1);
          this.mTV.remove(paramString1);
          AppMethodBeat.o(136710);
          return;
        }
        localObject1 = new HashSet((Collection)localObject1);
        Object localObject2 = paramString2.iterator();
        long l;
        while (((Iterator)localObject2).hasNext())
        {
          l = ((Long)((Iterator)localObject2).next()).longValue();
          if (!((HashSet)localObject1).remove(Long.valueOf(l)))
          {
            com.tencent.mm.plugin.fts.c.a locala = this.mTR;
            locala.mVA.bindString(1, paramString1);
            locala.mVA.bindLong(2, l);
            locala.mVA.execute();
          }
        }
        localObject1 = ((HashSet)localObject1).iterator();
        while (((Iterator)localObject1).hasNext())
        {
          l = ((Long)((Iterator)localObject1).next()).longValue();
          localObject2 = this.mTR;
          ((com.tencent.mm.plugin.fts.c.a)localObject2).mVB.bindString(1, paramString1);
          ((com.tencent.mm.plugin.fts.c.a)localObject2).mVB.bindLong(2, l);
          ((com.tencent.mm.plugin.fts.c.a)localObject2).mVB.execute();
        }
        this.mTV.put(paramString1, paramString2);
      }
      AppMethodBeat.o(136710);
      return;
      paramString2 = null;
    }
  }
  
  private static String nG(String paramString)
  {
    AppMethodBeat.i(136712);
    if (mUf.contains(paramString))
    {
      AppMethodBeat.o(136712);
      return "";
    }
    AppMethodBeat.o(136712);
    return paramString;
  }
  
  final void F(ad paramad)
  {
    AppMethodBeat.i(136703);
    try
    {
      this.mTW.invoke(paramad, new Object[0]);
      AppMethodBeat.o(136703);
      return;
    }
    catch (Exception paramad)
    {
      ab.printErrStackTrace("MicroMsg.FTS.FTS5SearchContactLogic", paramad, "Failed parsing RContact LVBuffer.", new Object[0]);
      AppMethodBeat.o(136703);
    }
  }
  
  final boolean H(ad paramad)
  {
    AppMethodBeat.i(136706);
    String str = paramad.field_username;
    if (!G(paramad))
    {
      AppMethodBeat.o(136706);
      return false;
    }
    if (!Pk(str))
    {
      AppMethodBeat.o(136706);
      return false;
    }
    if (!com.tencent.mm.n.a.je(paramad.field_type))
    {
      if ((!paramad.NV()) && (!paramad.dwz()))
      {
        if (this.muH.OU(str))
        {
          AppMethodBeat.o(136706);
          return true;
        }
        AppMethodBeat.o(136706);
        return false;
      }
      AppMethodBeat.o(136706);
      return false;
    }
    AppMethodBeat.o(136706);
    return true;
  }
  
  final int I(ad paramad)
  {
    AppMethodBeat.i(136707);
    Object localObject1;
    Object localObject3;
    if (t.lA(paramad.field_username))
    {
      localObject1 = String.format("SELECT memberlist, roomdata FROM %s WHERE chatroomname = ?", new Object[] { "chatroom" });
      localObject3 = this.muH.i((String)localObject1, new String[] { paramad.field_username });
    }
    for (;;)
    {
      try
      {
        if (!((Cursor)localObject3).moveToNext()) {
          break label498;
        }
        localObject2 = ((Cursor)localObject3).getString(0);
        localObject1 = ((Cursor)localObject3).getBlob(1);
        if (localObject3 != null) {
          ((Cursor)localObject3).close();
        }
        if ((bo.isNullOrNil((String)localObject2)) || (localObject1 == null))
        {
          ab.i("MicroMsg.FTS.FTS5SearchContactLogic", "error chatroom data %s", new Object[] { paramad.field_username });
          i = j(paramad.field_username, null);
          if (i > 0) {
            ab.i("MicroMsg.FTS.FTS5SearchContactLogic", "updateChatroomMember %s %d", new Object[] { paramad.field_username, Integer.valueOf(i) });
          }
          AppMethodBeat.o(136707);
          return 0;
        }
      }
      finally
      {
        if (localObject3 != null) {
          ((Cursor)localObject3).close();
        }
        AppMethodBeat.o(136707);
      }
      Object localObject2 = com.tencent.mm.plugin.fts.a.c.a.mQW.split((CharSequence)localObject2);
      Arrays.sort((Object[])localObject2, new a.9(this));
      int i = j(paramad.field_username, (String[])localObject2);
      if (i > 0) {
        ab.i("MicroMsg.FTS.FTS5SearchContactLogic", "updateChatroomMember %s %d", new Object[] { paramad.field_username, Integer.valueOf(i) });
      }
      localObject3 = new HashMap();
      Object localObject4 = "SELECT rowid, username, alias, conRemark, nickname , lvbuff FROM rcontact WHERE username IN " + d.A((String[])localObject2) + ";";
      localObject4 = this.muH.i((String)localObject4, null);
      try
      {
        while (((Cursor)localObject4).moveToNext())
        {
          ad localad = new ad();
          localad.euF = ((Cursor)localObject4).getLong(0);
          localad.setUsername(((Cursor)localObject4).getString(1));
          localad.jm(((Cursor)localObject4).getString(2));
          localad.jn(((Cursor)localObject4).getString(3));
          localad.jp(((Cursor)localObject4).getString(4));
          localad.G(((Cursor)localObject4).getBlob(5));
          ((HashMap)localObject3).put(localad.field_username, localad);
        }
        AppMethodBeat.o(136707);
      }
      finally
      {
        if (localObject4 != null) {
          ((Cursor)localObject4).close();
        }
        AppMethodBeat.o(136707);
      }
      return i;
      i = J(paramad);
      AppMethodBeat.o(136707);
      return i;
      label498:
      localObject1 = null;
      localObject2 = null;
    }
  }
  
  final int J(ad paramad)
  {
    AppMethodBeat.i(136708);
    long l2 = paramad.euF;
    String str2 = paramad.field_username;
    Object localObject7 = paramad.Hq();
    Object localObject1 = paramad.field_nickname;
    Object localObject2 = d.aR((String)localObject1, false);
    Object localObject3 = d.aR((String)localObject1, true);
    Object localObject6 = paramad.field_conRemark;
    Object localObject4 = d.aR((String)localObject6, false);
    Object localObject5 = d.aR((String)localObject6, true);
    String str3 = paramad.dqT;
    String str1 = paramad.field_contactLabelIds;
    String str4 = paramad.dqZ;
    int i = paramad.field_verifyFlag;
    long l1 = System.currentTimeMillis();
    int j;
    if ((i & ad.dwB()) != 0)
    {
      str1 = bo.d(((com.tencent.mm.api.j)g.E(com.tencent.mm.api.j.class)).dl(str2), "​");
      i = 0;
      j = 131076;
    }
    for (;;)
    {
      localObject7 = d.ey(str2, (String)localObject7);
      if ((localObject7 != null) && (((String)localObject7).length() != 0))
      {
        this.mTR.a(j, 15, l2, str2, l1, (String)localObject7);
        i += 1;
      }
      for (;;)
      {
        if ((localObject6 == null) || (((String)localObject6).length() == 0))
        {
          localObject6 = null;
          localObject7 = null;
          localObject4 = localObject2;
          localObject5 = null;
          localObject2 = localObject6;
          localObject6 = localObject1;
          localObject1 = localObject7;
        }
        for (;;)
        {
          int k = i;
          if (localObject6 != null)
          {
            k = i;
            if (((String)localObject6).length() != 0)
            {
              if (!((String)localObject6).equalsIgnoreCase((String)localObject4)) {
                break label1013;
              }
              localObject4 = null;
            }
          }
          label416:
          label928:
          label1013:
          for (;;)
          {
            if ((localObject4 != null) && (((String)localObject4).length() != 0))
            {
              localObject7 = localObject3;
              if (!((String)localObject4).equalsIgnoreCase((String)localObject3)) {}
            }
            else
            {
              localObject7 = null;
            }
            this.mTR.a(j, 1, l2, str2, l1, (String)localObject6);
            if ((localObject4 != null) && (((String)localObject4).length() != 0)) {
              this.mTR.a(j, 2, l2, str2, l1, (String)localObject4);
            }
            if ((localObject7 != null) && (((String)localObject7).length() != 0)) {
              this.mTR.a(j, 3, l2, str2, l1, (String)localObject7);
            }
            k = i + 3;
            if ((localObject5 != null) && (((String)localObject5).length() != 0))
            {
              localObject3 = localObject2;
              if (((String)localObject5).equalsIgnoreCase((String)localObject2)) {
                localObject3 = null;
              }
              if ((localObject3 == null) || (((String)localObject3).length() == 0) || (((String)localObject3).equalsIgnoreCase((String)localObject1)))
              {
                localObject1 = null;
                this.mTR.a(j, 5, l2, str2, l1, (String)localObject5);
                if ((localObject3 != null) && (((String)localObject3).length() != 0)) {
                  this.mTR.a(j, 6, l2, str2, l1, (String)localObject3);
                }
                if ((localObject1 != null) && (((String)localObject1).length() != 0)) {
                  this.mTR.a(j, 7, l2, str2, l1, (String)localObject1);
                }
                k += 3;
              }
            }
            for (;;)
            {
              i = k;
              if (str3 != null)
              {
                i = k;
                if (str3.length() > 0)
                {
                  this.mTR.a(j, 4, l2, str2, l1, str3);
                  i = k + 1;
                }
              }
              k = i;
              if (j == 131072)
              {
                if (bo.isNullOrNil(str4)) {
                  break label928;
                }
                localObject1 = str4.replace(",", "​");
                this.mTR.a(j, 16, l2, str2, l1, (String)localObject1);
                k = i + 1;
              }
              for (;;)
              {
                localObject1 = nG(paramad.getProvince());
                i = k;
                if (localObject1 != null)
                {
                  i = k;
                  if (((String)localObject1).length() != 0)
                  {
                    this.mTR.a(j, 18, l2, str2, l1, (String)localObject1);
                    i = k + 1;
                  }
                }
                localObject1 = paramad.getCity();
                k = i;
                if (localObject1 != null)
                {
                  k = i;
                  if (((String)localObject1).length() != 0)
                  {
                    this.mTR.a(j, 17, l2, str2, l1, (String)localObject1);
                    k = i + 1;
                  }
                }
                i = k;
                if (j == 131076)
                {
                  i = k;
                  if (!bo.isNullOrNil(str1))
                  {
                    this.mTR.a(j, 19, l2, str2, l1, str1);
                    i = k + 1;
                    localObject1 = d.aR(str1, false);
                    k = i;
                    if (!bo.isNullOrNil((String)localObject1))
                    {
                      this.mTR.a(j, 20, l2, str2, l1, (String)localObject1);
                      k = i + 1;
                    }
                    str1 = d.aR(str1, true);
                    i = k;
                    if (!bo.isNullOrNil(str1))
                    {
                      this.mTR.a(j, 21, l2, str2, l1, str1);
                      i = k + 1;
                    }
                  }
                }
                k = i;
                if (j == 131081) {
                  k = i + a(paramad, l1);
                }
                AppMethodBeat.o(136708);
                return k;
                if (ad.arf(str2))
                {
                  i = 0;
                  str1 = "";
                  j = 131081;
                  break;
                }
                l1 = this.muH.OV(str2);
                if ((str1 == null) || (str1.length() <= 0)) {
                  break label1042;
                }
                i = a(l2, str2, str1, l1) + 0;
                str1 = "";
                j = 131072;
                break;
                localObject1 = this.muH.i("SELECT moblie FROM addr_upload2 WHERE username=?;", new String[] { str2 });
                k = i;
                if (((Cursor)localObject1).moveToFirst())
                {
                  localObject2 = ((Cursor)localObject1).getString(0);
                  this.mTR.a(j, 16, l2, str2, l1, (String)localObject2);
                  k = i + 1;
                }
                ((Cursor)localObject1).close();
              }
              break label416;
            }
          }
          Object localObject8 = localObject3;
          localObject7 = localObject1;
          localObject3 = localObject5;
          localObject1 = localObject8;
          localObject5 = localObject7;
        }
      }
      label1042:
      i = 0;
      str1 = "";
      j = 131072;
    }
  }
  
  public final boolean Pp()
  {
    AppMethodBeat.i(136699);
    this.mUb.dead();
    this.mUc.dead();
    this.mUe.stopTimer();
    this.mUd.stopTimer();
    ((com.tencent.mm.plugin.messenger.foundation.a.j)g.E(com.tencent.mm.plugin.messenger.foundation.a.j.class)).YA().b(this.mTY);
    ((com.tencent.mm.plugin.chatroom.a.c)g.E(com.tencent.mm.plugin.chatroom.a.c.class)).YJ().remove(this.mTZ);
    ((com.tencent.mm.plugin.messenger.foundation.a.j)g.E(com.tencent.mm.plugin.messenger.foundation.a.j.class)).YF().b(this.mTX);
    k.a locala = this.mUa;
    if (com.tencent.mm.av.b.fHW != null) {
      com.tencent.mm.av.b.fHW.b(locala);
    }
    if (this.mTT != null) {
      this.mTT.clear();
    }
    if (this.mTS != null) {
      this.mTS.clear();
    }
    this.mTR = null;
    this.ezf = null;
    AppMethodBeat.o(136699);
    return true;
  }
  
  final int a(String paramString, ad paramad, String[] paramArrayOfString, byte[] paramArrayOfByte, HashMap<String, ad> paramHashMap)
  {
    AppMethodBeat.i(136700);
    int j = 0;
    paramad = paramad.field_nickname;
    String str1 = d.aR(paramad, false);
    String str2 = d.aR(paramad, true);
    long l1 = 0L;
    long l3 = this.muH.OV(paramString);
    StringBuffer localStringBuffer = new StringBuffer();
    if (paramArrayOfString != null)
    {
      long l2 = paramArrayOfString.length;
      HashMap localHashMap = new HashMap();
      Object localObject = new com.tencent.mm.j.a.a.a();
      int k;
      try
      {
        ((com.tencent.mm.j.a.a.a)localObject).parseFrom(paramArrayOfByte);
        paramArrayOfByte = ((com.tencent.mm.j.a.a.a)localObject).elu.iterator();
        while (paramArrayOfByte.hasNext())
        {
          localObject = (com.tencent.mm.j.a.a.b)paramArrayOfByte.next();
          if (!bo.isNullOrNil(((com.tencent.mm.j.a.a.b)localObject).elx)) {
            localHashMap.put(((com.tencent.mm.j.a.a.b)localObject).userName, ((com.tencent.mm.j.a.a.b)localObject).elx);
          }
        }
      }
      catch (Exception paramArrayOfByte)
      {
        for (;;)
        {
          ab.printErrStackTrace("MicroMsg.FTS.FTS5SearchContactLogic", paramArrayOfByte, "parse chatroom data", new Object[0]);
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
          String str4 = ((aq)localObject).field_conRemark;
          String str3 = ((aq)localObject).field_nickname;
          String str5 = d.aR(str4, false);
          String str6 = d.aR(str4, true);
          localStringBuffer.append(bo.bf(str4, " ")).append("‌");
          localStringBuffer.append(bo.bf(str5, " ")).append("‌");
          localStringBuffer.append(bo.bf(str6, " ")).append("‌");
          str4 = d.aR(str3, false);
          str5 = d.aR(str3, true);
          localStringBuffer.append(bo.bf(str3, " ")).append("‌");
          localStringBuffer.append(bo.bf(str4, " ")).append("‌");
          localStringBuffer.append(bo.bf(str5, " ")).append("‌");
          localStringBuffer.append(bo.bf((String)localHashMap.get(paramArrayOfByte), " ")).append("‌");
          F((ad)localObject);
          localStringBuffer.append(bo.bf(((aq)localObject).dqT, " ")).append("‌");
          localStringBuffer.append(bo.bf(d.ey(paramArrayOfByte, ((ad)localObject).Hq()), " ")).append("‌");
          localStringBuffer.append("​");
        }
        i += 1;
      }
    }
    int i = j;
    if (!bo.isNullOrNil(paramad))
    {
      this.mTR.a(131075, 5, l1, paramString, l3, paramad);
      if (bo.isNullOrNil(str1)) {
        break label635;
      }
      this.mTR.a(131075, 6, l1, paramString, l3, str1);
    }
    label635:
    for (j = 2;; j = 1)
    {
      i = j;
      if (!bo.isNullOrNil(str2))
      {
        this.mTR.a(131075, 7, l1, paramString, l3, str2);
        i = j + 1;
      }
      j = i;
      if (localStringBuffer.length() > 0)
      {
        localStringBuffer.setLength(localStringBuffer.length() - 1);
        this.mTR.a(131075, 38, l1, paramString, l3, localStringBuffer.toString());
        j = i + 1;
      }
      AppMethodBeat.o(136700);
      return j;
    }
  }
  
  public final com.tencent.mm.plugin.fts.a.a.a a(i parami)
  {
    AppMethodBeat.i(136697);
    switch (parami.hdl)
    {
    default: 
      parami = new a.j(this, parami);
    }
    for (;;)
    {
      parami = this.ezf.a(-65536, parami);
      AppMethodBeat.o(136697);
      return parami;
      parami = new a.q(this, parami);
      continue;
      parami = new a.n(this, parami);
      continue;
      parami = new a.t(this, parami);
      continue;
      parami = new a.s(this, parami);
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
  
  public final int j(String paramString, String[] paramArrayOfString)
  {
    AppMethodBeat.i(136701);
    Object localObject = (String[])this.mTU.get(paramString);
    this.mTR.beginTransaction();
    int j;
    int i;
    if (localObject == null)
    {
      this.mTR.Pq(paramString);
      j = (int)this.mTR.mVD.simpleQueryForLong() + 0;
      i = j;
      if (paramArrayOfString != null)
      {
        this.mTR.k(paramString, paramArrayOfString);
        this.mTU.put(paramString, paramArrayOfString);
        i = j + paramArrayOfString.length;
      }
    }
    for (;;)
    {
      this.mTR.commit();
      AppMethodBeat.o(136701);
      return i;
      if (paramArrayOfString == null)
      {
        this.mTR.Pq(paramString);
        i = (int)this.mTR.mVD.simpleQueryForLong() + 0;
        this.mTU.remove(paramString);
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
            locala = this.mTR;
            locala.mVx.bindString(1, paramString);
            locala.mVx.bindString(2, str);
            locala.mVx.execute();
            k = i + 1;
          }
          j += 1;
        }
        localObject = ((HashSet)localObject).iterator();
        while (((Iterator)localObject).hasNext())
        {
          str = (String)((Iterator)localObject).next();
          locala = this.mTR;
          locala.mVy.bindString(1, paramString);
          locala.mVy.bindString(2, str);
          locala.mVy.execute();
          i += 1;
        }
        this.mTU.put(paramString, paramArrayOfString);
      }
    }
  }
  
  public final boolean onCreate()
  {
    AppMethodBeat.i(136698);
    if (!((n)g.G(n.class)).isFTSContextReady())
    {
      ab.i("MicroMsg.FTS.FTS5SearchContactLogic", "Create Fail!");
      AppMethodBeat.o(136698);
      return false;
    }
    ab.i("MicroMsg.FTS.FTS5SearchContactLogic", "Create Success!");
    this.mTR = ((com.tencent.mm.plugin.fts.c.a)((n)g.G(n.class)).getFTSIndexStorage(3));
    this.ezf = ((n)g.G(n.class)).getFTSTaskDaemon();
    this.muH = ((n)g.G(n.class)).getFTSMainDB();
    this.mTS = new HashSet();
    this.mTT = new HashMap();
    this.mTU = new HashMap();
    this.mTV = new HashMap();
    try
    {
      this.mTW = aq.class.getDeclaredMethod("parseBuff", new Class[0]);
      this.mTW.setAccessible(true);
      this.ezf.a(131072, new a.f(this, (byte)0));
      this.ezf.a(131082, new a.a(this, (byte)0));
      this.ezf.a(131092, new a.b(this, (byte)0));
      this.ezf.a(2147483647, new a.c(this, (byte)0));
      ((com.tencent.mm.plugin.chatroom.a.c)g.E(com.tencent.mm.plugin.chatroom.a.c.class)).YJ().add(this.mTZ);
      ((com.tencent.mm.plugin.messenger.foundation.a.j)g.E(com.tencent.mm.plugin.messenger.foundation.a.j.class)).YA().a(this.mTY);
      ((com.tencent.mm.plugin.messenger.foundation.a.j)g.E(com.tencent.mm.plugin.messenger.foundation.a.j.class)).YF().a(this.mTX);
      k.a locala = this.mUa;
      if (com.tencent.mm.av.b.fHW != null) {
        com.tencent.mm.av.b.fHW.a(locala);
      }
      this.mUd.ag(600000L, 600000L);
      this.mUb.alive();
      this.mUc.alive();
      AppMethodBeat.o(136698);
      return true;
    }
    catch (NoSuchMethodException localNoSuchMethodException)
    {
      AssertionFailedError localAssertionFailedError = new AssertionFailedError("Can't find BaseContact.parseBuff method, class prototype has changed.");
      localAssertionFailedError.initCause(localNoSuchMethodException);
      AppMethodBeat.o(136698);
      throw localAssertionFailedError;
    }
  }
  
  final class h
    extends com.tencent.mm.plugin.fts.a.a.a
  {
    private String eaX;
    private boolean ezx = false;
    private boolean mUB = false;
    
    public h(String paramString)
    {
      this.eaX = paramString;
    }
    
    public final String aAn()
    {
      AppMethodBeat.i(136679);
      String str = String.format("{username: %s cached: %b isSkipped: %b}", new Object[] { this.eaX, Boolean.valueOf(this.mUB), Boolean.valueOf(this.ezx) });
      AppMethodBeat.o(136679);
      return str;
    }
    
    public final boolean execute()
    {
      AppMethodBeat.i(136678);
      ab.i("MicroMsg.FTS.FTS5SearchContactLogic", "Dirty Contact %s", new Object[] { this.eaX });
      if (a.b(a.this).containsKey(this.eaX))
      {
        this.mUB = true;
        AppMethodBeat.o(136678);
        return true;
      }
      a.a(a.this).OX(this.eaX);
      Object localObject1 = a.a(a.this).c(com.tencent.mm.plugin.fts.a.c.mQI, this.eaX);
      a.b(a.this).put(this.eaX, localObject1);
      if (((List)localObject1).isEmpty())
      {
        this.ezx = true;
        a.e(a.this).a(65556, new a.e(a.this, this.eaX));
        AppMethodBeat.o(136678);
        return true;
      }
      localObject1 = a.a(a.this).Pp(this.eaX);
      Object localObject2 = new HashSet();
      while (((Cursor)localObject1).moveToNext()) {
        ((HashSet)localObject2).add(((Cursor)localObject1).getString(0));
      }
      ((Cursor)localObject1).close();
      localObject1 = ((HashSet)localObject2).iterator();
      while (((Iterator)localObject1).hasNext())
      {
        localObject2 = (String)((Iterator)localObject1).next();
        a.a(a.this).OX((String)localObject2);
        if (!a.b(a.this).containsKey(localObject2))
        {
          List localList = a.a(a.this).c(com.tencent.mm.plugin.fts.a.c.mQI, (String)localObject2);
          a.b(a.this).put(localObject2, localList);
        }
      }
      a.c(a.this).remove(this.eaX);
      ((PluginFTS)g.G(PluginFTS.class)).getTopHitsLogic().Pn(this.eaX);
      AppMethodBeat.o(136678);
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
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.fts.b.a
 * JD-Core Version:    0.7.0.1
 */