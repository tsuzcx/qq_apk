package com.tencent.mm.al.a;

import android.database.Cursor;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.c.ah;
import com.tencent.mm.sdk.e.e;
import com.tencent.mm.sdk.e.j;
import com.tencent.mm.sdk.e.l;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.bs;

public final class g
  extends j<ah>
{
  public static final String[] SQL_CREATE;
  private e db;
  private final l<g.a, a.b> hxq;
  
  static
  {
    AppMethodBeat.i(124252);
    SQL_CREATE = new String[] { j.getCreateSQLs(f.info, "BizChatMyUserInfo") };
    AppMethodBeat.o(124252);
  }
  
  public g(e parame)
  {
    super(parame, f.info, "BizChatMyUserInfo", null);
    AppMethodBeat.i(124246);
    this.hxq = new l() {};
    this.db = parame;
    parame.execSQL("BizChatMyUserInfo", "CREATE INDEX IF NOT EXISTS bizChatbrandUserNameIndex ON BizChatMyUserInfo ( brandUserName )");
    AppMethodBeat.o(124246);
  }
  
  public final boolean BA(String paramString)
  {
    AppMethodBeat.i(124248);
    if (bs.isNullOrNil(paramString))
    {
      ac.w("MicroMsg.BizChatMyUserInfoStorage", "delete wrong argument");
      AppMethodBeat.o(124248);
      return false;
    }
    f localf = new f();
    localf.field_brandUserName = paramString;
    boolean bool = super.delete(localf, new String[] { "brandUserName" });
    if (bool)
    {
      paramString = new a.b();
      paramString.ddh = localf.field_brandUserName;
      paramString.hzC = g.a.a.hzz;
      paramString.hzD = localf;
      this.hxq.dS(paramString);
      this.hxq.doNotify();
    }
    AppMethodBeat.o(124248);
    return bool;
  }
  
  public final f Bz(String paramString)
  {
    AppMethodBeat.i(124247);
    if (bs.isNullOrNil(paramString))
    {
      ac.w("MicroMsg.BizChatMyUserInfoStorage", "get： wrong argument");
      AppMethodBeat.o(124247);
      return null;
    }
    f localf = new f();
    localf.field_brandUserName = paramString;
    super.get(localf, new String[0]);
    AppMethodBeat.o(124247);
    return localf;
  }
  
  public final boolean a(f paramf)
  {
    AppMethodBeat.i(124249);
    ac.d("MicroMsg.BizChatMyUserInfoStorage", "BizChatMyUserInfoStorage insert");
    boolean bool = super.insert(paramf);
    if (bool)
    {
      a.b localb = new a.b();
      localb.ddh = paramf.field_brandUserName;
      localb.hzC = g.a.a.hzy;
      localb.hzD = paramf;
      this.hxq.dS(localb);
      this.hxq.doNotify();
    }
    for (;;)
    {
      AppMethodBeat.o(124249);
      return bool;
      ac.w("MicroMsg.BizChatMyUserInfoStorage", "BizChatMyUserInfoStorage insert fail");
    }
  }
  
  public final boolean b(f paramf)
  {
    AppMethodBeat.i(124250);
    ac.d("MicroMsg.BizChatMyUserInfoStorage", "BizChatMyUserInfoStorage update");
    if (paramf == null)
    {
      ac.w("MicroMsg.BizChatMyUserInfoStorage", "update wrong argument");
      AppMethodBeat.o(124250);
      return false;
    }
    boolean bool = super.replace(paramf);
    if (bool)
    {
      a.b localb = new a.b();
      localb.ddh = paramf.field_brandUserName;
      localb.hzC = g.a.a.hzA;
      localb.hzD = paramf;
      this.hxq.dS(localb);
      this.hxq.doNotify();
    }
    for (;;)
    {
      AppMethodBeat.o(124250);
      return bool;
      ac.w("MicroMsg.BizChatMyUserInfoStorage", "BizChatMyUserInfoStorage update fail");
    }
  }
  
  public final int getCount()
  {
    int i = 0;
    AppMethodBeat.i(124251);
    ac.d("MicroMsg.BizChatMyUserInfoStorage", "BizChatMyUserInfoStorage getCount");
    Cursor localCursor = this.db.a("SELECT COUNT(*) FROM BizChatMyUserInfo", null, 2);
    if (localCursor.moveToFirst()) {
      i = localCursor.getInt(0);
    }
    localCursor.close();
    AppMethodBeat.o(124251);
    return i;
  }
  
  public static final class a$b
  {
    public String ddh;
    public g.a.a hzC;
    public f hzD;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.al.a.g
 * JD-Core Version:    0.7.0.1
 */