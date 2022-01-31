package com.tencent.mm.aj.a;

import android.database.Cursor;
import android.os.Looper;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.aj.f;
import com.tencent.mm.aj.z;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.t;
import com.tencent.mm.sdk.e.l;
import com.tencent.mm.sdk.e.n;
import com.tencent.mm.sdk.e.n.b;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.storage.bd;
import java.util.ArrayList;
import java.util.List;

public final class b
  extends com.tencent.mm.sdk.e.j<a>
  implements n.b
{
  public static final String[] SQL_CREATE;
  public com.tencent.mm.sdk.e.e db;
  final l<b.a, a.b> fuL;
  
  static
  {
    AppMethodBeat.i(11513);
    SQL_CREATE = new String[] { com.tencent.mm.sdk.e.j.getCreateSQLs(a.info, "BizChatConversation") };
    AppMethodBeat.o(11513);
  }
  
  public b(com.tencent.mm.sdk.e.e parame)
  {
    super(parame, a.info, "BizChatConversation", null);
    AppMethodBeat.i(11494);
    this.fuL = new b.1(this);
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
    ((com.tencent.mm.plugin.messenger.foundation.a.j)g.E(com.tencent.mm.plugin.messenger.foundation.a.j.class)).YA().a(this);
    AppMethodBeat.o(11494);
  }
  
  public static long a(a parama, int paramInt, long paramLong)
  {
    AppMethodBeat.i(11507);
    if (parama == null)
    {
      AppMethodBeat.o(11507);
      return 0L;
    }
    if (paramLong != 0L) {}
    for (;;)
    {
      switch (paramInt)
      {
      default: 
        paramLong = a(parama, paramLong);
        AppMethodBeat.o(11507);
        return paramLong;
        paramLong = bo.aoy();
      }
    }
    paramLong = a(parama, paramLong);
    AppMethodBeat.o(11507);
    return paramLong | 0x0;
    paramLong = a(parama, paramLong);
    AppMethodBeat.o(11507);
    return paramLong & 0xFFFFFFFF;
    paramLong = a(parama, paramLong);
    AppMethodBeat.o(11507);
    return paramLong & 0x0;
  }
  
  private static long a(a parama, long paramLong)
  {
    return parama.field_flag & 0x0 | 0xFFFFFFFF & paramLong;
  }
  
  public static void a(a parama, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(11505);
    if (parama.field_msgCount == 0)
    {
      String str = parama.field_brandUserName;
      long l = parama.field_bizChatId;
      parama.field_msgCount = ((com.tencent.mm.aj.o)g.E(com.tencent.mm.aj.o.class)).YD().bg(str, l);
      ab.i("MicroMsg.BizConversationStorage", "getMsgCount from message table");
    }
    for (;;)
    {
      ab.i("MicroMsg.BizConversationStorage", "countMsg %d talker :%s deleteCount:%d insertCount:%d", new Object[] { Integer.valueOf(parama.field_msgCount), Long.valueOf(parama.field_bizChatId), Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) });
      AppMethodBeat.o(11505);
      return;
      if (paramInt1 > 0)
      {
        parama.field_msgCount -= paramInt1;
        if (parama.field_msgCount < 0)
        {
          ab.e("MicroMsg.BizConversationStorage", "msg < 0 ,some path must be ignore!");
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
    AppMethodBeat.i(11509);
    if (parama == null)
    {
      ab.e("MicroMsg.BizConversationStorage", "isPlacedTop failed, conversation null");
      AppMethodBeat.o(11509);
      return false;
    }
    if (a(parama, 4, 0L) != 0L)
    {
      AppMethodBeat.o(11509);
      return true;
    }
    AppMethodBeat.o(11509);
    return false;
  }
  
  public final void a(int paramInt, n paramn, Object paramObject)
  {
    AppMethodBeat.i(11498);
    ab.i("MicroMsg.BizConversationStorage", "onNotifyChange");
    if ((paramObject == null) || (!(paramObject instanceof String)))
    {
      AppMethodBeat.o(11498);
      return;
    }
    paramn = (String)paramObject;
    if ((f.lg(paramn)) && (!t.nT(paramn))) {
      e.H(paramn, true);
    }
    AppMethodBeat.o(11498);
  }
  
  public final void a(b.a parama)
  {
    AppMethodBeat.i(11497);
    if (this.fuL != null) {
      this.fuL.remove(parama);
    }
    AppMethodBeat.o(11497);
  }
  
  public final void a(b.a parama, Looper paramLooper)
  {
    AppMethodBeat.i(11496);
    this.fuL.a(parama, paramLooper);
    AppMethodBeat.o(11496);
  }
  
  public final boolean a(a parama)
  {
    AppMethodBeat.i(11501);
    ab.d("MicroMsg.BizConversationStorage", "BizChatConversationStorage insert");
    if (parama == null)
    {
      ab.w("MicroMsg.BizConversationStorage", "insert wrong argument");
      AppMethodBeat.o(11501);
      return false;
    }
    boolean bool = super.insert(parama);
    ab.i("MicroMsg.BizConversationStorage", "BizChatConversationStorage insert res:%s", new Object[] { Boolean.valueOf(bool) });
    if (bool)
    {
      a.b localb = new a.b();
      localb.fxq = parama.field_bizChatId;
      localb.cqQ = parama.field_brandUserName;
      localb.fxp = b.a.a.fxl;
      localb.fxr = parama;
      this.fuL.cy(localb);
      this.fuL.doNotify();
    }
    AppMethodBeat.o(11501);
    return bool;
  }
  
  public final List<c> aG(String paramString1, String paramString2)
  {
    AppMethodBeat.i(11504);
    ArrayList localArrayList = new ArrayList();
    if (bo.isNullOrNil(paramString2))
    {
      AppMethodBeat.o(11504);
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
    ab.d("MicroMsg.BizConversationStorage", "getBizChatConversationSearchCursor: sql:%s", new Object[] { localStringBuilder.toString() });
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
    AppMethodBeat.o(11504);
    return localArrayList;
  }
  
  public final boolean b(a parama)
  {
    AppMethodBeat.i(11502);
    if (parama == null)
    {
      ab.w("MicroMsg.BizConversationStorage", "update wrong argument");
      AppMethodBeat.o(11502);
      return false;
    }
    boolean bool = super.replace(parama);
    ab.i("MicroMsg.BizConversationStorage", "BizChatConversationStorage update res:%s", new Object[] { Boolean.valueOf(bool) });
    if (bool)
    {
      e.g(z.afk().aG(parama.field_bizChatId));
      a.b localb = new a.b();
      localb.fxq = parama.field_bizChatId;
      localb.cqQ = parama.field_brandUserName;
      localb.fxp = b.a.a.fxn;
      localb.fxr = parama;
      this.fuL.cy(localb);
      this.fuL.doNotify();
    }
    AppMethodBeat.o(11502);
    return bool;
  }
  
  protected final void finalize()
  {
    AppMethodBeat.i(11495);
    ((com.tencent.mm.plugin.messenger.foundation.a.j)g.E(com.tencent.mm.plugin.messenger.foundation.a.j.class)).YA().b(this);
    AppMethodBeat.o(11495);
  }
  
  public final a gF(long paramLong)
  {
    AppMethodBeat.i(11499);
    a locala = new a();
    locala.field_bizChatId = paramLong;
    super.get(locala, new String[0]);
    AppMethodBeat.o(11499);
    return locala;
  }
  
  public final boolean gG(long paramLong)
  {
    AppMethodBeat.i(11500);
    a locala = gF(paramLong);
    boolean bool = super.delete(locala, new String[] { "bizChatId" });
    if (bool)
    {
      a.b localb = new a.b();
      localb.fxq = locala.field_bizChatId;
      localb.cqQ = locala.field_brandUserName;
      localb.fxp = b.a.a.fxm;
      localb.fxr = locala;
      this.fuL.cy(localb);
      this.fuL.doNotify();
    }
    AppMethodBeat.o(11500);
    return bool;
  }
  
  public final boolean gH(long paramLong)
  {
    AppMethodBeat.i(11506);
    a locala = gF(paramLong);
    if ((locala.field_unReadCount == 0) && (locala.field_bizChatId == paramLong))
    {
      AppMethodBeat.o(11506);
      return true;
    }
    locala.field_unReadCount = 0;
    locala.field_atCount = 0;
    b(locala);
    AppMethodBeat.o(11506);
    return true;
  }
  
  public final boolean gI(long paramLong)
  {
    AppMethodBeat.i(11508);
    boolean bool = c(gF(paramLong));
    AppMethodBeat.o(11508);
    return bool;
  }
  
  public final boolean gJ(long paramLong)
  {
    AppMethodBeat.i(11510);
    gF(paramLong);
    a locala = gF(paramLong);
    boolean bool = this.db.execSQL("BizChatConversation", "update BizChatConversation set flag = " + a(locala, 2, 0L) + " where bizChatId = " + locala.field_bizChatId);
    if (bool)
    {
      locala = gF(locala.field_bizChatId);
      a.b localb = new a.b();
      localb.fxq = locala.field_bizChatId;
      localb.cqQ = locala.field_brandUserName;
      localb.fxp = b.a.a.fxn;
      localb.fxr = locala;
      this.fuL.cy(localb);
      this.fuL.doNotify();
    }
    AppMethodBeat.o(11510);
    return bool;
  }
  
  public final boolean gK(long paramLong)
  {
    AppMethodBeat.i(11511);
    a locala = gF(paramLong);
    boolean bool = this.db.execSQL("BizChatConversation", "update BizChatConversation set flag = " + a(locala, 3, locala.field_lastMsgTime) + " where bizChatId = " + locala.field_bizChatId);
    if (bool)
    {
      locala = gF(locala.field_bizChatId);
      a.b localb = new a.b();
      localb.fxq = locala.field_bizChatId;
      localb.cqQ = locala.field_brandUserName;
      localb.fxp = b.a.a.fxn;
      localb.fxr = locala;
      this.fuL.cy(localb);
      this.fuL.doNotify();
    }
    AppMethodBeat.o(11511);
    return bool;
  }
  
  public final Cursor si(String paramString)
  {
    AppMethodBeat.i(11503);
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("select * from BizChatConversation");
    localStringBuilder.append(" where brandUserName = '").append(paramString).append("'");
    localStringBuilder.append(" order by flag desc , lastMsgTime desc");
    ab.d("MicroMsg.BizConversationStorage", "getBizChatConversationCursor: sql:%s", new Object[] { localStringBuilder.toString() });
    paramString = this.db.rawQuery(localStringBuilder.toString(), null);
    AppMethodBeat.o(11503);
    return paramString;
  }
  
  public static final class a$b
  {
    public String cqQ;
    public b.a.a fxp;
    public long fxq;
    public a fxr;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.aj.a.b
 * JD-Core Version:    0.7.0.1
 */