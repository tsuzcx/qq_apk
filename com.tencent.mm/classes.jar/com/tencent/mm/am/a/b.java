package com.tencent.mm.am.a;

import android.database.Cursor;
import android.os.Looper;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.am.af;
import com.tencent.mm.am.f;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.w;
import com.tencent.mm.plugin.messenger.foundation.a.k;
import com.tencent.mm.sdk.e.j;
import com.tencent.mm.sdk.e.l;
import com.tencent.mm.sdk.e.n;
import com.tencent.mm.sdk.e.n.b;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.storage.bg;
import java.util.ArrayList;
import java.util.List;

public final class b
  extends j<a>
  implements n.b
{
  public static final String[] SQL_CREATE;
  public com.tencent.mm.sdk.e.e db;
  final l<a, b.a.b> gWR;
  
  static
  {
    AppMethodBeat.i(124198);
    SQL_CREATE = new String[] { j.getCreateSQLs(a.info, "BizChatConversation") };
    AppMethodBeat.o(124198);
  }
  
  public b(com.tencent.mm.sdk.e.e parame)
  {
    super(parame, a.info, "BizChatConversation", null);
    AppMethodBeat.i(124179);
    this.gWR = new l() {};
    this.db = parame;
    parame.execSQL("BizChatConversation", "CREATE INDEX IF NOT EXISTS bizChatIdIndex ON BizChatConversation ( bizChatId )");
    parame.execSQL("BizChatConversation", "CREATE INDEX IF NOT EXISTS brandUserNameIndex ON BizChatConversation ( brandUserName )");
    parame.execSQL("BizChatConversation", "CREATE INDEX IF NOT EXISTS unreadCountIndex ON BizChatConversation ( unReadCount )");
    int j = 0;
    Cursor localCursor = parame.a("PRAGMA table_info( BizChatConversation)", null, 2);
    do
    {
      i = j;
      if (!localCursor.moveToNext()) {
        break;
      }
      i = localCursor.getColumnIndex("name");
    } while ((i < 0) || (!"flag".equalsIgnoreCase(localCursor.getString(i))));
    int i = 1;
    localCursor.close();
    if (i == 0) {
      parame.execSQL("BizChatConversation", "update BizChatConversation set flag = lastMsgTime");
    }
    ((k)g.ab(k.class)).apM().a(this);
    AppMethodBeat.o(124179);
  }
  
  public static long a(a parama, int paramInt, long paramLong)
  {
    AppMethodBeat.i(124192);
    if (parama == null)
    {
      AppMethodBeat.o(124192);
      return 0L;
    }
    if (paramLong != 0L) {}
    for (;;)
    {
      switch (paramInt)
      {
      default: 
        paramLong = a(parama, paramLong);
        AppMethodBeat.o(124192);
        return paramLong;
        paramLong = bt.eGO();
      }
    }
    paramLong = a(parama, paramLong);
    AppMethodBeat.o(124192);
    return paramLong | 0x0;
    paramLong = a(parama, paramLong);
    AppMethodBeat.o(124192);
    return paramLong & 0xFFFFFFFF;
    paramLong = a(parama, paramLong);
    AppMethodBeat.o(124192);
    return paramLong & 0x0;
  }
  
  private static long a(a parama, long paramLong)
  {
    return parama.field_flag & 0x0 | 0xFFFFFFFF & paramLong;
  }
  
  public static void a(a parama, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(124190);
    if (parama.field_msgCount == 0)
    {
      String str = parama.field_brandUserName;
      long l = parama.field_bizChatId;
      parama.field_msgCount = ((com.tencent.mm.am.p)g.ab(com.tencent.mm.am.p.class)).apP().bZ(str, l);
      ad.i("MicroMsg.BizConversationStorage", "getMsgCount from message table");
    }
    for (;;)
    {
      ad.i("MicroMsg.BizConversationStorage", "countMsg %d talker :%s deleteCount:%d insertCount:%d", new Object[] { Integer.valueOf(parama.field_msgCount), Long.valueOf(parama.field_bizChatId), Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) });
      AppMethodBeat.o(124190);
      return;
      if (paramInt1 > 0)
      {
        parama.field_msgCount -= paramInt1;
        if (parama.field_msgCount < 0)
        {
          ad.e("MicroMsg.BizConversationStorage", "msg < 0 ,some path must be ignore!");
          parama.field_msgCount = 0;
        }
      }
      else if (paramInt2 > 0)
      {
        parama.field_msgCount += paramInt2;
      }
    }
  }
  
  public static boolean c(a parama)
  {
    AppMethodBeat.i(124194);
    if (parama == null)
    {
      ad.e("MicroMsg.BizConversationStorage", "isPlacedTop failed, conversation null");
      AppMethodBeat.o(124194);
      return false;
    }
    if (a(parama, 4, 0L) != 0L)
    {
      AppMethodBeat.o(124194);
      return true;
    }
    AppMethodBeat.o(124194);
    return false;
  }
  
  public final void a(int paramInt, n paramn, Object paramObject)
  {
    AppMethodBeat.i(124183);
    ad.i("MicroMsg.BizConversationStorage", "onNotifyChange");
    if ((paramObject == null) || (!(paramObject instanceof String)))
    {
      AppMethodBeat.o(124183);
      return;
    }
    paramn = (String)paramObject;
    if ((f.pc(paramn)) && (!w.sD(paramn))) {
      e.M(paramn, true);
    }
    AppMethodBeat.o(124183);
  }
  
  public final void a(a parama)
  {
    AppMethodBeat.i(124182);
    if (this.gWR != null) {
      this.gWR.remove(parama);
    }
    AppMethodBeat.o(124182);
  }
  
  public final void a(a parama, Looper paramLooper)
  {
    AppMethodBeat.i(124181);
    this.gWR.a(parama, paramLooper);
    AppMethodBeat.o(124181);
  }
  
  public final boolean a(a parama)
  {
    AppMethodBeat.i(124186);
    ad.d("MicroMsg.BizConversationStorage", "BizChatConversationStorage insert");
    if (parama == null)
    {
      ad.w("MicroMsg.BizConversationStorage", "insert wrong argument");
      AppMethodBeat.o(124186);
      return false;
    }
    boolean bool = super.insert(parama);
    ad.i("MicroMsg.BizConversationStorage", "BizChatConversationStorage insert res:%s", new Object[] { Boolean.valueOf(bool) });
    if (bool)
    {
      b.a.b localb = new b.a.b();
      localb.gYF = parama.field_bizChatId;
      localb.dfM = parama.field_brandUserName;
      localb.gYE = b.a.a.gYA;
      localb.gYG = parama;
      this.gWR.dR(localb);
      this.gWR.doNotify();
    }
    AppMethodBeat.o(124186);
    return bool;
  }
  
  public final List<c> aV(String paramString1, String paramString2)
  {
    AppMethodBeat.i(124189);
    ArrayList localArrayList = new ArrayList();
    if (bt.isNullOrNil(paramString2))
    {
      AppMethodBeat.o(124189);
      return localArrayList;
    }
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("select BizChatInfo.*");
    localStringBuilder.append(" from BizChatConversation , BizChatInfo");
    localStringBuilder.append(" where BizChatConversation.brandUserName = '").append(paramString1).append("'");
    localStringBuilder.append(" and BizChatInfo.brandUserName = '").append(paramString1).append("'");
    localStringBuilder.append(" and BizChatConversation.bizChatId");
    localStringBuilder.append(" = BizChatInfo.bizChatLocalId");
    localStringBuilder.append(" and BizChatInfo.chatName like '%").append(paramString2).append("%'");
    localStringBuilder.append(" order by BizChatConversation.flag desc");
    localStringBuilder.append(" , BizChatConversation.lastMsgTime desc");
    ad.d("MicroMsg.BizConversationStorage", "getBizChatConversationSearchCursor: sql:%s", new Object[] { localStringBuilder.toString() });
    paramString1 = rawQuery(localStringBuilder.toString(), new String[0]);
    if (paramString1 != null)
    {
      if (paramString1.moveToFirst()) {
        do
        {
          paramString2 = new c();
          paramString2.convertFrom(paramString1);
          localArrayList.add(paramString2);
        } while (paramString1.moveToNext());
      }
      paramString1.close();
    }
    AppMethodBeat.o(124189);
    return localArrayList;
  }
  
  public final boolean b(a parama)
  {
    AppMethodBeat.i(124187);
    if (parama == null)
    {
      ad.w("MicroMsg.BizConversationStorage", "update wrong argument");
      AppMethodBeat.o(124187);
      return false;
    }
    boolean bool = super.replace(parama);
    ad.i("MicroMsg.BizConversationStorage", "BizChatConversationStorage update res:%s", new Object[] { Boolean.valueOf(bool) });
    if (bool)
    {
      e.g(af.awg().bg(parama.field_bizChatId));
      b.a.b localb = new b.a.b();
      localb.gYF = parama.field_bizChatId;
      localb.dfM = parama.field_brandUserName;
      localb.gYE = b.a.a.gYC;
      localb.gYG = parama;
      this.gWR.dR(localb);
      this.gWR.doNotify();
    }
    AppMethodBeat.o(124187);
    return bool;
  }
  
  protected final void finalize()
  {
    AppMethodBeat.i(124180);
    ((k)g.ab(k.class)).apM().b(this);
    AppMethodBeat.o(124180);
  }
  
  public final a mf(long paramLong)
  {
    AppMethodBeat.i(124184);
    a locala = new a();
    locala.field_bizChatId = paramLong;
    super.get(locala, new String[0]);
    AppMethodBeat.o(124184);
    return locala;
  }
  
  public final boolean mg(long paramLong)
  {
    AppMethodBeat.i(124185);
    a locala = mf(paramLong);
    boolean bool = super.delete(locala, new String[] { "bizChatId" });
    if (bool)
    {
      b.a.b localb = new b.a.b();
      localb.gYF = locala.field_bizChatId;
      localb.dfM = locala.field_brandUserName;
      localb.gYE = b.a.a.gYB;
      localb.gYG = locala;
      this.gWR.dR(localb);
      this.gWR.doNotify();
    }
    AppMethodBeat.o(124185);
    return bool;
  }
  
  public final boolean mh(long paramLong)
  {
    AppMethodBeat.i(124191);
    a locala = mf(paramLong);
    if ((locala.field_unReadCount == 0) && (locala.field_bizChatId == paramLong))
    {
      AppMethodBeat.o(124191);
      return true;
    }
    locala.field_unReadCount = 0;
    locala.field_atCount = 0;
    locala.field_atAll = 0;
    b(locala);
    AppMethodBeat.o(124191);
    return true;
  }
  
  public final boolean mi(long paramLong)
  {
    AppMethodBeat.i(124193);
    boolean bool = c(mf(paramLong));
    AppMethodBeat.o(124193);
    return bool;
  }
  
  public final boolean mj(long paramLong)
  {
    AppMethodBeat.i(124195);
    mf(paramLong);
    a locala = mf(paramLong);
    boolean bool = this.db.execSQL("BizChatConversation", "update BizChatConversation set flag = " + a(locala, 2, locala.field_lastMsgTime) + " where bizChatId = " + locala.field_bizChatId);
    if (bool)
    {
      locala = mf(locala.field_bizChatId);
      b.a.b localb = new b.a.b();
      localb.gYF = locala.field_bizChatId;
      localb.dfM = locala.field_brandUserName;
      localb.gYE = b.a.a.gYC;
      localb.gYG = locala;
      this.gWR.dR(localb);
      this.gWR.doNotify();
    }
    AppMethodBeat.o(124195);
    return bool;
  }
  
  public final boolean mk(long paramLong)
  {
    AppMethodBeat.i(124196);
    a locala = mf(paramLong);
    boolean bool = this.db.execSQL("BizChatConversation", "update BizChatConversation set flag = " + a(locala, 3, locala.field_lastMsgTime) + " where bizChatId = " + locala.field_bizChatId);
    if (bool)
    {
      locala = mf(locala.field_bizChatId);
      b.a.b localb = new b.a.b();
      localb.gYF = locala.field_bizChatId;
      localb.dfM = locala.field_brandUserName;
      localb.gYE = b.a.a.gYC;
      localb.gYG = locala;
      this.gWR.dR(localb);
      this.gWR.doNotify();
    }
    AppMethodBeat.o(124196);
    return bool;
  }
  
  public final int xf(String paramString)
  {
    int i = 0;
    int j = 0;
    AppMethodBeat.i(191073);
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("select count(*) from BizChatConversation");
    localStringBuilder.append(" where brandUserName = '").append(paramString).append("' ");
    paramString = localStringBuilder.toString();
    paramString = this.db.a(paramString, null, 2);
    if (paramString != null)
    {
      i = j;
      if (paramString.moveToFirst()) {
        i = paramString.getInt(0);
      }
      paramString.close();
    }
    AppMethodBeat.o(191073);
    return i;
  }
  
  public final Cursor xg(String paramString)
  {
    AppMethodBeat.i(124188);
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("select * from BizChatConversation");
    localStringBuilder.append(" where brandUserName = '").append(paramString).append("'");
    localStringBuilder.append(" order by flag desc , lastMsgTime desc");
    ad.d("MicroMsg.BizConversationStorage", "getBizChatConversationCursor: sql:%s", new Object[] { localStringBuilder.toString() });
    paramString = this.db.rawQuery(localStringBuilder.toString(), null);
    AppMethodBeat.o(124188);
    return paramString;
  }
  
  public static abstract interface a
  {
    public abstract void a(b paramb);
    
    public static enum a
    {
      static
      {
        AppMethodBeat.i(124178);
        gYA = new a("INSTERT", 0);
        gYB = new a("DELETE", 1);
        gYC = new a("UPDATE", 2);
        gYD = new a[] { gYA, gYB, gYC };
        AppMethodBeat.o(124178);
      }
      
      private a() {}
    }
    
    public static final class b
    {
      public String dfM;
      public b.a.a gYE;
      public long gYF;
      public a gYG;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.am.a.b
 * JD-Core Version:    0.7.0.1
 */