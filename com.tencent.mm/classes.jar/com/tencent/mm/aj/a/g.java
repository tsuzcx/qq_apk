package com.tencent.mm.aj.a;

import android.database.Cursor;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.c.ac;
import com.tencent.mm.sdk.e.e;
import com.tencent.mm.sdk.e.j;
import com.tencent.mm.sdk.e.l;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;

public final class g
  extends j<ac>
{
  public static final String[] SQL_CREATE;
  private e db;
  private final l<g.a, g.a.b> fuL;
  
  static
  {
    AppMethodBeat.i(11566);
    SQL_CREATE = new String[] { j.getCreateSQLs(f.info, "BizChatMyUserInfo") };
    AppMethodBeat.o(11566);
  }
  
  public g(e parame)
  {
    super(parame, f.info, "BizChatMyUserInfo", null);
    AppMethodBeat.i(11560);
    this.fuL = new l() {};
    this.db = parame;
    parame.execSQL("BizChatMyUserInfo", "CREATE INDEX IF NOT EXISTS bizChatbrandUserNameIndex ON BizChatMyUserInfo ( brandUserName )");
    AppMethodBeat.o(11560);
  }
  
  public final boolean a(f paramf)
  {
    AppMethodBeat.i(11563);
    ab.d("MicroMsg.BizChatMyUserInfoStorage", "BizChatMyUserInfoStorage insert");
    boolean bool = super.insert(paramf);
    if (bool)
    {
      g.a.b localb = new g.a.b();
      localb.cqQ = paramf.field_brandUserName;
      localb.fxN = g.a.a.fxJ;
      localb.fxO = paramf;
      this.fuL.cy(localb);
      this.fuL.doNotify();
    }
    for (;;)
    {
      AppMethodBeat.o(11563);
      return bool;
      ab.w("MicroMsg.BizChatMyUserInfoStorage", "BizChatMyUserInfoStorage insert fail");
    }
  }
  
  public final boolean b(f paramf)
  {
    AppMethodBeat.i(11564);
    ab.d("MicroMsg.BizChatMyUserInfoStorage", "BizChatMyUserInfoStorage update");
    if (paramf == null)
    {
      ab.w("MicroMsg.BizChatMyUserInfoStorage", "update wrong argument");
      AppMethodBeat.o(11564);
      return false;
    }
    boolean bool = super.replace(paramf);
    if (bool)
    {
      g.a.b localb = new g.a.b();
      localb.cqQ = paramf.field_brandUserName;
      localb.fxN = g.a.a.fxL;
      localb.fxO = paramf;
      this.fuL.cy(localb);
      this.fuL.doNotify();
    }
    for (;;)
    {
      AppMethodBeat.o(11564);
      return bool;
      ab.w("MicroMsg.BizChatMyUserInfoStorage", "BizChatMyUserInfoStorage update fail");
    }
  }
  
  public final int getCount()
  {
    int i = 0;
    AppMethodBeat.i(11565);
    ab.d("MicroMsg.BizChatMyUserInfoStorage", "BizChatMyUserInfoStorage getCount");
    Cursor localCursor = this.db.a("SELECT COUNT(*) FROM BizChatMyUserInfo", null, 2);
    if (localCursor.moveToFirst()) {
      i = localCursor.getInt(0);
    }
    localCursor.close();
    AppMethodBeat.o(11565);
    return i;
  }
  
  public final f sv(String paramString)
  {
    AppMethodBeat.i(11561);
    if (bo.isNullOrNil(paramString))
    {
      ab.w("MicroMsg.BizChatMyUserInfoStorage", "get： wrong argument");
      AppMethodBeat.o(11561);
      return null;
    }
    f localf = new f();
    localf.field_brandUserName = paramString;
    super.get(localf, new String[0]);
    AppMethodBeat.o(11561);
    return localf;
  }
  
  public final boolean sw(String paramString)
  {
    AppMethodBeat.i(11562);
    if (bo.isNullOrNil(paramString))
    {
      ab.w("MicroMsg.BizChatMyUserInfoStorage", "delete wrong argument");
      AppMethodBeat.o(11562);
      return false;
    }
    f localf = new f();
    localf.field_brandUserName = paramString;
    boolean bool = super.delete(localf, new String[] { "brandUserName" });
    if (bool)
    {
      paramString = new g.a.b();
      paramString.cqQ = localf.field_brandUserName;
      paramString.fxN = g.a.a.fxK;
      paramString.fxO = localf;
      this.fuL.cy(paramString);
      this.fuL.doNotify();
    }
    AppMethodBeat.o(11562);
    return bool;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.aj.a.g
 * JD-Core Version:    0.7.0.1
 */