package com.tencent.mm.ai.a;

import android.database.Cursor;
import android.os.Looper;
import com.tencent.mm.ai.f;
import com.tencent.mm.ai.z;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.s;
import com.tencent.mm.plugin.messenger.foundation.a.j;
import com.tencent.mm.sdk.e.i;
import com.tencent.mm.sdk.e.k;
import com.tencent.mm.sdk.e.m;
import com.tencent.mm.sdk.e.m.b;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.sdk.platformtools.y;
import com.tencent.mm.storage.bd;

public final class b
  extends i<a>
  implements m.b
{
  public static final String[] dXp = { i.a(a.buS, "BizChatConversation") };
  public com.tencent.mm.sdk.e.e dXw;
  final k<b.a, b.a.b> eeJ = new b.1(this);
  
  public b(com.tencent.mm.sdk.e.e parame)
  {
    super(parame, a.buS, "BizChatConversation", null);
    this.dXw = parame;
    parame.gk("BizChatConversation", "CREATE INDEX IF NOT EXISTS bizChatIdIndex ON BizChatConversation ( bizChatId )");
    parame.gk("BizChatConversation", "CREATE INDEX IF NOT EXISTS brandUserNameIndex ON BizChatConversation ( brandUserName )");
    parame.gk("BizChatConversation", "CREATE INDEX IF NOT EXISTS unreadCountIndex ON BizChatConversation ( unReadCount )");
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
      parame.gk("BizChatConversation", "update BizChatConversation set flag = lastMsgTime");
    }
    ((j)g.r(j.class)).Fw().a(this);
  }
  
  public static long a(a parama, int paramInt, long paramLong)
  {
    if (parama == null) {
      return 0L;
    }
    if (paramLong != 0L) {}
    for (;;)
    {
      switch (paramInt)
      {
      default: 
        return a(parama, paramLong);
        paramLong = bk.UY();
      }
    }
    return a(parama, paramLong) | 0x0;
    return a(parama, paramLong) & 0xFFFFFFFF;
    return a(parama, paramLong) & 0x0;
  }
  
  private static long a(a parama, long paramLong)
  {
    return parama.field_flag & 0x0 | 0xFFFFFFFF & paramLong;
  }
  
  public static void a(a parama, int paramInt1, int paramInt2)
  {
    if (parama.field_msgCount == 0)
    {
      String str = parama.field_brandUserName;
      long l = parama.field_bizChatId;
      parama.field_msgCount = ((com.tencent.mm.ai.o)g.r(com.tencent.mm.ai.o.class)).Fz().ay(str, l);
      y.i("MicroMsg.BizConversationStorage", "getMsgCount from message table");
    }
    for (;;)
    {
      y.i("MicroMsg.BizConversationStorage", "countMsg %d talker :%s deleteCount:%d insertCount:%d", new Object[] { Integer.valueOf(parama.field_msgCount), Long.valueOf(parama.field_bizChatId), Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) });
      return;
      if (paramInt1 > 0)
      {
        parama.field_msgCount -= paramInt1;
        if (parama.field_msgCount < 0)
        {
          y.e("MicroMsg.BizConversationStorage", "msg < 0 ,some path must be ignore!");
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
    if (parama == null) {
      y.e("MicroMsg.BizConversationStorage", "isPlacedTop failed, conversation null");
    }
    while (a(parama, 4, 0L) == 0L) {
      return false;
    }
    return true;
  }
  
  public final void a(int paramInt, m paramm, Object paramObject)
  {
    y.i("MicroMsg.BizConversationStorage", "onNotifyChange");
    if ((paramObject == null) || (!(paramObject instanceof String))) {}
    do
    {
      return;
      paramm = (String)paramObject;
    } while ((!f.eW(paramm)) || (s.hk(paramm)));
    e.D(paramm, true);
  }
  
  public final void a(b.a parama)
  {
    if (this.eeJ != null) {
      this.eeJ.remove(parama);
    }
  }
  
  public final void a(b.a parama, Looper paramLooper)
  {
    this.eeJ.a(parama, paramLooper);
  }
  
  public final boolean a(a parama)
  {
    y.d("MicroMsg.BizConversationStorage", "BizChatConversationStorage insert");
    if (parama == null)
    {
      y.w("MicroMsg.BizConversationStorage", "insert wrong argument");
      return false;
    }
    boolean bool = super.b(parama);
    y.i("MicroMsg.BizConversationStorage", "BizChatConversationStorage insert res:%s", new Object[] { Boolean.valueOf(bool) });
    if (bool)
    {
      b.a.b localb = new b.a.b();
      localb.ehm = parama.field_bizChatId;
      localb.bJw = parama.field_brandUserName;
      localb.ehl = b.a.a.ehh;
      localb.ehn = parama;
      this.eeJ.bV(localb);
      this.eeJ.doNotify();
    }
    return bool;
  }
  
  public final boolean b(a parama)
  {
    if (parama == null)
    {
      y.w("MicroMsg.BizConversationStorage", "update wrong argument");
      return false;
    }
    boolean bool = super.a(parama);
    y.i("MicroMsg.BizConversationStorage", "BizChatConversationStorage update res:%s", new Object[] { Boolean.valueOf(bool) });
    if (bool)
    {
      e.g(z.MA().aj(parama.field_bizChatId));
      b.a.b localb = new b.a.b();
      localb.ehm = parama.field_bizChatId;
      localb.bJw = parama.field_brandUserName;
      localb.ehl = b.a.a.ehj;
      localb.ehn = parama;
      this.eeJ.bV(localb);
      this.eeJ.doNotify();
    }
    return bool;
  }
  
  public final a bK(long paramLong)
  {
    a locala = new a();
    locala.field_bizChatId = paramLong;
    super.b(locala, new String[0]);
    return locala;
  }
  
  public final boolean bL(long paramLong)
  {
    a locala = bK(paramLong);
    boolean bool = super.a(locala, new String[] { "bizChatId" });
    if (bool)
    {
      b.a.b localb = new b.a.b();
      localb.ehm = locala.field_bizChatId;
      localb.bJw = locala.field_brandUserName;
      localb.ehl = b.a.a.ehi;
      localb.ehn = locala;
      this.eeJ.bV(localb);
      this.eeJ.doNotify();
    }
    return bool;
  }
  
  public final boolean bM(long paramLong)
  {
    a locala = bK(paramLong);
    if ((locala.field_unReadCount == 0) && (locala.field_bizChatId == paramLong)) {
      return true;
    }
    locala.field_unReadCount = 0;
    locala.field_atCount = 0;
    b(locala);
    return true;
  }
  
  public final boolean bN(long paramLong)
  {
    return c(bK(paramLong));
  }
  
  public final boolean bO(long paramLong)
  {
    bK(paramLong);
    a locala = bK(paramLong);
    boolean bool = this.dXw.gk("BizChatConversation", "update BizChatConversation set flag = " + a(locala, 2, 0L) + " where bizChatId = " + locala.field_bizChatId);
    if (bool)
    {
      locala = bK(locala.field_bizChatId);
      b.a.b localb = new b.a.b();
      localb.ehm = locala.field_bizChatId;
      localb.bJw = locala.field_brandUserName;
      localb.ehl = b.a.a.ehj;
      localb.ehn = locala;
      this.eeJ.bV(localb);
      this.eeJ.doNotify();
    }
    return bool;
  }
  
  public final boolean bP(long paramLong)
  {
    a locala = bK(paramLong);
    boolean bool = this.dXw.gk("BizChatConversation", "update BizChatConversation set flag = " + a(locala, 3, locala.field_lastMsgTime) + " where bizChatId = " + locala.field_bizChatId);
    if (bool)
    {
      locala = bK(locala.field_bizChatId);
      b.a.b localb = new b.a.b();
      localb.ehm = locala.field_bizChatId;
      localb.bJw = locala.field_brandUserName;
      localb.ehl = b.a.a.ehj;
      localb.ehn = locala;
      this.eeJ.bV(localb);
      this.eeJ.doNotify();
    }
    return bool;
  }
  
  protected final void finalize()
  {
    ((j)g.r(j.class)).Fw().b(this);
  }
  
  public final Cursor ln(String paramString)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("select * from BizChatConversation");
    localStringBuilder.append(" where brandUserName = '").append(paramString).append("'");
    localStringBuilder.append(" order by flag desc , lastMsgTime desc");
    y.d("MicroMsg.BizConversationStorage", "getBizChatConversationCursor: sql:%s", new Object[] { localStringBuilder.toString() });
    return this.dXw.rawQuery(localStringBuilder.toString(), null);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.ai.a.b
 * JD-Core Version:    0.7.0.1
 */