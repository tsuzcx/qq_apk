package com.tencent.mm.ao.a;

import android.database.Cursor;
import android.os.Looper;
import com.tencent.e.i;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ao.af;
import com.tencent.mm.ao.g;
import com.tencent.mm.ao.q;
import com.tencent.mm.model.ab;
import com.tencent.mm.plugin.messenger.foundation.a.n;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.sdk.storage.ISQLiteDatabase;
import com.tencent.mm.sdk.storage.MAutoStorage;
import com.tencent.mm.sdk.storage.MStorageEvent;
import com.tencent.mm.sdk.storage.MStorageEx;
import com.tencent.mm.sdk.storage.MStorageEx.IOnStorageChange;
import com.tencent.mm.storage.bv;
import com.tencent.mm.storage.t;
import java.util.ArrayList;
import java.util.List;

public final class b
  extends MAutoStorage<a>
  implements MStorageEx.IOnStorageChange
{
  public static final String[] SQL_CREATE;
  public ISQLiteDatabase db;
  private final MStorageEvent<a, b.a.b> lEj;
  
  static
  {
    AppMethodBeat.i(124198);
    SQL_CREATE = new String[] { MAutoStorage.getCreateSQLs(a.info, "BizChatConversation") };
    AppMethodBeat.o(124198);
  }
  
  public b(final ISQLiteDatabase paramISQLiteDatabase)
  {
    super(paramISQLiteDatabase, a.info, "BizChatConversation", null);
    AppMethodBeat.i(124179);
    this.lEj = new MStorageEvent() {};
    this.db = paramISQLiteDatabase;
    com.tencent.e.h.ZvG.o(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(205851);
        paramISQLiteDatabase.execSQL("BizChatConversation", "CREATE INDEX IF NOT EXISTS BizChatConv_bizChatIdIndex ON BizChatConversation ( bizChatId )");
        paramISQLiteDatabase.execSQL("BizChatConversation", "CREATE INDEX IF NOT EXISTS BizChatConv_brandUserNameIndex ON BizChatConversation ( brandUserName )");
        paramISQLiteDatabase.execSQL("BizChatConversation", "CREATE INDEX IF NOT EXISTS unreadCountIndex ON BizChatConversation ( unReadCount )");
        AppMethodBeat.o(205851);
      }
    }, 30000L);
    int j = 0;
    Cursor localCursor = paramISQLiteDatabase.rawQuery("PRAGMA table_info( BizChatConversation)", null, 2);
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
      paramISQLiteDatabase.execSQL("BizChatConversation", "update BizChatConversation set flag = lastMsgTime");
    }
    ((n)com.tencent.mm.kernel.h.ae(n.class)).bbL().add(this);
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
        paramLong = Util.nowMilliSecond();
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
      parama.field_msgCount = ((q)com.tencent.mm.kernel.h.ae(q.class)).bbP().cj(str, l);
      Log.i("MicroMsg.BizConversationStorage", "getMsgCount from message table");
    }
    for (;;)
    {
      Log.i("MicroMsg.BizConversationStorage", "countMsg %d talker :%s deleteCount:%d insertCount:%d", new Object[] { Integer.valueOf(parama.field_msgCount), Long.valueOf(parama.field_bizChatId), Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) });
      AppMethodBeat.o(124190);
      return;
      if (paramInt1 > 0)
      {
        parama.field_msgCount -= paramInt1;
        if (parama.field_msgCount < 0)
        {
          Log.e("MicroMsg.BizConversationStorage", "msg < 0 ,some path must be ignore!");
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
      Log.e("MicroMsg.BizConversationStorage", "isPlacedTop failed, conversation null");
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
  
  public final a Gt(long paramLong)
  {
    AppMethodBeat.i(124184);
    a locala = new a();
    locala.field_bizChatId = paramLong;
    super.get(locala, new String[0]);
    AppMethodBeat.o(124184);
    return locala;
  }
  
  public final boolean Gu(long paramLong)
  {
    AppMethodBeat.i(124185);
    a locala = Gt(paramLong);
    boolean bool = super.delete(locala, new String[] { "bizChatId" });
    if (bool)
    {
      b.a.b localb = new b.a.b();
      localb.lFU = locala.field_bizChatId;
      localb.fzM = locala.field_brandUserName;
      localb.lFT = b.a.a.lFQ;
      localb.lFV = locala;
      this.lEj.event(localb);
      this.lEj.doNotify();
    }
    AppMethodBeat.o(124185);
    return bool;
  }
  
  public final boolean Gv(long paramLong)
  {
    AppMethodBeat.i(124191);
    a locala = Gt(paramLong);
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
  
  public final boolean Gw(long paramLong)
  {
    AppMethodBeat.i(124193);
    boolean bool = c(Gt(paramLong));
    AppMethodBeat.o(124193);
    return bool;
  }
  
  public final boolean Gx(long paramLong)
  {
    AppMethodBeat.i(124195);
    Gt(paramLong);
    a locala = Gt(paramLong);
    boolean bool = this.db.execSQL("BizChatConversation", "update BizChatConversation set flag = " + a(locala, 2, locala.field_lastMsgTime) + " where bizChatId = " + locala.field_bizChatId);
    if (bool)
    {
      locala = Gt(locala.field_bizChatId);
      b.a.b localb = new b.a.b();
      localb.lFU = locala.field_bizChatId;
      localb.fzM = locala.field_brandUserName;
      localb.lFT = b.a.a.lFR;
      localb.lFV = locala;
      this.lEj.event(localb);
      this.lEj.doNotify();
    }
    AppMethodBeat.o(124195);
    return bool;
  }
  
  public final boolean Gy(long paramLong)
  {
    AppMethodBeat.i(124196);
    a locala = Gt(paramLong);
    boolean bool = this.db.execSQL("BizChatConversation", "update BizChatConversation set flag = " + a(locala, 3, locala.field_lastMsgTime) + " where bizChatId = " + locala.field_bizChatId);
    if (bool)
    {
      locala = Gt(locala.field_bizChatId);
      b.a.b localb = new b.a.b();
      localb.lFU = locala.field_bizChatId;
      localb.fzM = locala.field_brandUserName;
      localb.lFT = b.a.a.lFR;
      localb.lFV = locala;
      this.lEj.event(localb);
      this.lEj.doNotify();
    }
    AppMethodBeat.o(124196);
    return bool;
  }
  
  public final int UV(String paramString)
  {
    int i = 0;
    int j = 0;
    AppMethodBeat.i(205306);
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("select count(*) from BizChatConversation");
    localStringBuilder.append(" where brandUserName = '").append(paramString).append("' ");
    paramString = localStringBuilder.toString();
    paramString = this.db.rawQuery(paramString, null, 2);
    if (paramString != null)
    {
      i = j;
      if (paramString.moveToFirst()) {
        i = paramString.getInt(0);
      }
      paramString.close();
    }
    AppMethodBeat.o(205306);
    return i;
  }
  
  public final boolean UW(String paramString)
  {
    AppMethodBeat.i(205309);
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("delete from BizChatConversation");
    ((StringBuilder)localObject).append(" where brandUserName = '").append(paramString).append("' ");
    localObject = ((StringBuilder)localObject).toString();
    boolean bool = this.db.execSQL("BizChatConversation", (String)localObject);
    Log.i("MicroMsg.BizConversationStorage", "deleteByBrandUserName sql %s,%s", new Object[] { localObject, Boolean.valueOf(bool) });
    if (bool)
    {
      localObject = new a();
      b.a.b localb = new b.a.b();
      localb.lFU = -1L;
      localb.fzM = paramString;
      localb.lFT = b.a.a.lFQ;
      localb.lFV = ((a)localObject);
      this.lEj.event(localb);
      this.lEj.doNotify();
    }
    AppMethodBeat.o(205309);
    return bool;
  }
  
  public final Cursor UX(String paramString)
  {
    AppMethodBeat.i(124188);
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("select * from BizChatConversation");
    localStringBuilder.append(" where brandUserName = '").append(paramString).append("'");
    localStringBuilder.append(" order by flag desc , lastMsgTime desc");
    Log.d("MicroMsg.BizConversationStorage", "getBizChatConversationCursor: sql:%s", new Object[] { localStringBuilder.toString() });
    paramString = this.db.rawQuery(localStringBuilder.toString(), null);
    AppMethodBeat.o(124188);
    return paramString;
  }
  
  public final void a(a parama)
  {
    AppMethodBeat.i(124182);
    if (this.lEj != null) {
      this.lEj.remove(parama);
    }
    AppMethodBeat.o(124182);
  }
  
  public final void a(a parama, Looper paramLooper)
  {
    AppMethodBeat.i(124181);
    this.lEj.add(parama, paramLooper);
    AppMethodBeat.o(124181);
  }
  
  public final boolean a(a parama)
  {
    AppMethodBeat.i(124186);
    Log.d("MicroMsg.BizConversationStorage", "BizChatConversationStorage insert");
    if (parama == null)
    {
      Log.w("MicroMsg.BizConversationStorage", "insert wrong argument");
      AppMethodBeat.o(124186);
      return false;
    }
    boolean bool = super.insert(parama);
    Log.i("MicroMsg.BizConversationStorage", "BizChatConversationStorage insert res:%s", new Object[] { Boolean.valueOf(bool) });
    if (bool)
    {
      b.a.b localb = new b.a.b();
      localb.lFU = parama.field_bizChatId;
      localb.fzM = parama.field_brandUserName;
      localb.lFT = b.a.a.lFP;
      localb.lFV = parama;
      this.lEj.event(localb);
      this.lEj.doNotify();
    }
    AppMethodBeat.o(124186);
    return bool;
  }
  
  public final boolean b(a parama)
  {
    AppMethodBeat.i(124187);
    if (parama == null)
    {
      Log.w("MicroMsg.BizConversationStorage", "update wrong argument");
      AppMethodBeat.o(124187);
      return false;
    }
    boolean bool = super.replace(parama);
    Log.i("MicroMsg.BizConversationStorage", "BizChatConversationStorage update res:%s", new Object[] { Boolean.valueOf(bool) });
    if (bool)
    {
      e.g(af.bjx().bF(parama.field_bizChatId));
      b.a.b localb = new b.a.b();
      localb.lFU = parama.field_bizChatId;
      localb.fzM = parama.field_brandUserName;
      localb.lFT = b.a.a.lFR;
      localb.lFV = parama;
      this.lEj.event(localb);
      this.lEj.doNotify();
    }
    AppMethodBeat.o(124187);
    return bool;
  }
  
  public final List<c> bm(String paramString1, String paramString2)
  {
    AppMethodBeat.i(124189);
    ArrayList localArrayList = new ArrayList();
    if (Util.isNullOrNil(paramString2))
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
    Log.d("MicroMsg.BizConversationStorage", "getBizChatConversationSearchCursor: sql:%s", new Object[] { localStringBuilder.toString() });
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
    ((n)com.tencent.mm.kernel.h.ae(n.class)).bbL().remove(this);
    AppMethodBeat.o(124180);
  }
  
  public final void onNotifyChange(int paramInt, MStorageEx paramMStorageEx, Object paramObject)
  {
    AppMethodBeat.i(124183);
    Log.i("MicroMsg.BizConversationStorage", "onNotifyChange");
    if ((paramObject == null) || (!(paramObject instanceof String)))
    {
      AppMethodBeat.o(124183);
      return;
    }
    paramMStorageEx = (String)paramObject;
    if ((g.KI(paramMStorageEx)) && (!ab.Ql(paramMStorageEx))) {
      e.R(paramMStorageEx, true);
    }
    AppMethodBeat.o(124183);
  }
  
  public static abstract interface a
  {
    public abstract void a(b paramb);
    
    public static enum a
    {
      static
      {
        AppMethodBeat.i(124178);
        lFP = new a("INSTERT", 0);
        lFQ = new a("DELETE", 1);
        lFR = new a("UPDATE", 2);
        lFS = new a[] { lFP, lFQ, lFR };
        AppMethodBeat.o(124178);
      }
      
      private a() {}
    }
    
    public static final class b
    {
      public String fzM;
      public b.a.a lFT;
      public long lFU;
      public a lFV;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.ao.a.b
 * JD-Core Version:    0.7.0.1
 */