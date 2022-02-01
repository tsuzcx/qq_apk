package com.tencent.mm.am.a;

import android.database.Cursor;
import android.os.Looper;
import com.tencent.e.h;
import com.tencent.e.i;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.am.ag;
import com.tencent.mm.am.q;
import com.tencent.mm.model.w;
import com.tencent.mm.sdk.e.j;
import com.tencent.mm.sdk.e.n;
import com.tencent.mm.sdk.e.n.b;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.storage.bp;
import com.tencent.mm.storage.r;
import java.util.ArrayList;
import java.util.List;

public final class b
  extends j<a>
  implements n.b
{
  public static final String[] SQL_CREATE;
  public com.tencent.mm.sdk.e.e db;
  final com.tencent.mm.sdk.e.l<a, b.a.b> hPL;
  
  static
  {
    AppMethodBeat.i(124198);
    SQL_CREATE = new String[] { j.getCreateSQLs(a.info, "BizChatConversation") };
    AppMethodBeat.o(124198);
  }
  
  public b(final com.tencent.mm.sdk.e.e parame)
  {
    super(parame, a.info, "BizChatConversation", null);
    AppMethodBeat.i(124179);
    this.hPL = new com.tencent.mm.sdk.e.l() {};
    this.db = parame;
    h.LTJ.r(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(207200);
        parame.execSQL("BizChatConversation", "CREATE INDEX IF NOT EXISTS BizChatConv_bizChatIdIndex ON BizChatConversation ( bizChatId )");
        parame.execSQL("BizChatConversation", "CREATE INDEX IF NOT EXISTS BizChatConv_brandUserNameIndex ON BizChatConversation ( brandUserName )");
        parame.execSQL("BizChatConversation", "CREATE INDEX IF NOT EXISTS unreadCountIndex ON BizChatConversation ( unReadCount )");
        AppMethodBeat.o(207200);
      }
    }, 30000L);
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
    ((com.tencent.mm.plugin.messenger.foundation.a.l)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.messenger.foundation.a.l.class)).azp().a(this);
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
        paramLong = bt.flT();
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
      parama.field_msgCount = ((q)com.tencent.mm.kernel.g.ab(q.class)).azt().cf(str, l);
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
  
  public final int Ek(String paramString)
  {
    int i = 0;
    int j = 0;
    AppMethodBeat.i(207202);
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
    AppMethodBeat.o(207202);
    return i;
  }
  
  public final Cursor El(String paramString)
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
    if ((com.tencent.mm.am.g.vd(paramn)) && (!w.zD(paramn))) {
      e.N(paramn, true);
    }
    AppMethodBeat.o(124183);
  }
  
  public final void a(a parama)
  {
    AppMethodBeat.i(124182);
    if (this.hPL != null) {
      this.hPL.remove(parama);
    }
    AppMethodBeat.o(124182);
  }
  
  public final void a(a parama, Looper paramLooper)
  {
    AppMethodBeat.i(124181);
    this.hPL.a(parama, paramLooper);
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
      localb.hRz = parama.field_bizChatId;
      localb.doD = parama.field_brandUserName;
      localb.hRy = b.a.a.hRu;
      localb.hRA = parama;
      this.hPL.dV(localb);
      this.hPL.doNotify();
    }
    AppMethodBeat.o(124186);
    return bool;
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
      e.g(ag.aGb().bd(parama.field_bizChatId));
      b.a.b localb = new b.a.b();
      localb.hRz = parama.field_bizChatId;
      localb.doD = parama.field_brandUserName;
      localb.hRy = b.a.a.hRw;
      localb.hRA = parama;
      this.hPL.dV(localb);
      this.hPL.doNotify();
    }
    AppMethodBeat.o(124187);
    return bool;
  }
  
  public final List<c> be(String paramString1, String paramString2)
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
  
  protected final void finalize()
  {
    AppMethodBeat.i(124180);
    ((com.tencent.mm.plugin.messenger.foundation.a.l)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.messenger.foundation.a.l.class)).azp().b(this);
    AppMethodBeat.o(124180);
  }
  
  public final a rS(long paramLong)
  {
    AppMethodBeat.i(124184);
    a locala = new a();
    locala.field_bizChatId = paramLong;
    super.get(locala, new String[0]);
    AppMethodBeat.o(124184);
    return locala;
  }
  
  public final boolean rT(long paramLong)
  {
    AppMethodBeat.i(124185);
    a locala = rS(paramLong);
    boolean bool = super.delete(locala, new String[] { "bizChatId" });
    if (bool)
    {
      b.a.b localb = new b.a.b();
      localb.hRz = locala.field_bizChatId;
      localb.doD = locala.field_brandUserName;
      localb.hRy = b.a.a.hRv;
      localb.hRA = locala;
      this.hPL.dV(localb);
      this.hPL.doNotify();
    }
    AppMethodBeat.o(124185);
    return bool;
  }
  
  public final boolean rU(long paramLong)
  {
    AppMethodBeat.i(124191);
    a locala = rS(paramLong);
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
  
  public final boolean rV(long paramLong)
  {
    AppMethodBeat.i(124193);
    boolean bool = c(rS(paramLong));
    AppMethodBeat.o(124193);
    return bool;
  }
  
  public final boolean rW(long paramLong)
  {
    AppMethodBeat.i(124195);
    rS(paramLong);
    a locala = rS(paramLong);
    boolean bool = this.db.execSQL("BizChatConversation", "update BizChatConversation set flag = " + a(locala, 2, locala.field_lastMsgTime) + " where bizChatId = " + locala.field_bizChatId);
    if (bool)
    {
      locala = rS(locala.field_bizChatId);
      b.a.b localb = new b.a.b();
      localb.hRz = locala.field_bizChatId;
      localb.doD = locala.field_brandUserName;
      localb.hRy = b.a.a.hRw;
      localb.hRA = locala;
      this.hPL.dV(localb);
      this.hPL.doNotify();
    }
    AppMethodBeat.o(124195);
    return bool;
  }
  
  public final boolean rX(long paramLong)
  {
    AppMethodBeat.i(124196);
    a locala = rS(paramLong);
    boolean bool = this.db.execSQL("BizChatConversation", "update BizChatConversation set flag = " + a(locala, 3, locala.field_lastMsgTime) + " where bizChatId = " + locala.field_bizChatId);
    if (bool)
    {
      locala = rS(locala.field_bizChatId);
      b.a.b localb = new b.a.b();
      localb.hRz = locala.field_bizChatId;
      localb.doD = locala.field_brandUserName;
      localb.hRy = b.a.a.hRw;
      localb.hRA = locala;
      this.hPL.dV(localb);
      this.hPL.doNotify();
    }
    AppMethodBeat.o(124196);
    return bool;
  }
  
  public static abstract interface a
  {
    public abstract void a(b.a.b paramb);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.am.a.b
 * JD-Core Version:    0.7.0.1
 */