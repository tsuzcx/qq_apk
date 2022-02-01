package com.tencent.mm.ao.a;

import android.database.Cursor;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.f.c.ai;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.sdk.storage.ISQLiteDatabase;
import com.tencent.mm.sdk.storage.MAutoStorage;
import com.tencent.mm.sdk.storage.MStorageEvent;

public final class g
  extends MAutoStorage<ai>
{
  public static final String[] SQL_CREATE;
  private ISQLiteDatabase db;
  private final MStorageEvent<g.a, a.b> lEj;
  
  static
  {
    AppMethodBeat.i(124252);
    SQL_CREATE = new String[] { MAutoStorage.getCreateSQLs(f.info, "BizChatMyUserInfo") };
    AppMethodBeat.o(124252);
  }
  
  public g(ISQLiteDatabase paramISQLiteDatabase)
  {
    super(paramISQLiteDatabase, f.info, "BizChatMyUserInfo", null);
    AppMethodBeat.i(124246);
    this.lEj = new MStorageEvent() {};
    this.db = paramISQLiteDatabase;
    paramISQLiteDatabase.execSQL("BizChatMyUserInfo", "CREATE INDEX IF NOT EXISTS bizChatbrandUserNameIndex ON BizChatMyUserInfo ( brandUserName )");
    AppMethodBeat.o(124246);
  }
  
  public final boolean UW(String paramString)
  {
    AppMethodBeat.i(124248);
    if (Util.isNullOrNil(paramString))
    {
      Log.w("MicroMsg.BizChatMyUserInfoStorage", "delete wrong argument");
      AppMethodBeat.o(124248);
      return false;
    }
    f localf = new f();
    localf.field_brandUserName = paramString;
    boolean bool = super.delete(localf, new String[] { "brandUserName" });
    if (bool)
    {
      paramString = new a.b();
      paramString.fzM = localf.field_brandUserName;
      paramString.lGs = a.a.lGp;
      paramString.lGt = localf;
      this.lEj.event(paramString);
      this.lEj.doNotify();
    }
    AppMethodBeat.o(124248);
    return bool;
  }
  
  public final f Vk(String paramString)
  {
    AppMethodBeat.i(124247);
    if (Util.isNullOrNil(paramString))
    {
      Log.w("MicroMsg.BizChatMyUserInfoStorage", "get： wrong argument");
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
    Log.d("MicroMsg.BizChatMyUserInfoStorage", "BizChatMyUserInfoStorage insert");
    boolean bool = super.insert(paramf);
    if (bool)
    {
      a.b localb = new a.b();
      localb.fzM = paramf.field_brandUserName;
      localb.lGs = a.a.lGo;
      localb.lGt = paramf;
      this.lEj.event(localb);
      this.lEj.doNotify();
    }
    for (;;)
    {
      AppMethodBeat.o(124249);
      return bool;
      Log.w("MicroMsg.BizChatMyUserInfoStorage", "BizChatMyUserInfoStorage insert fail");
    }
  }
  
  public final boolean b(f paramf)
  {
    AppMethodBeat.i(124250);
    Log.d("MicroMsg.BizChatMyUserInfoStorage", "BizChatMyUserInfoStorage update");
    if (paramf == null)
    {
      Log.w("MicroMsg.BizChatMyUserInfoStorage", "update wrong argument");
      AppMethodBeat.o(124250);
      return false;
    }
    boolean bool = super.replace(paramf);
    if (bool)
    {
      a.b localb = new a.b();
      localb.fzM = paramf.field_brandUserName;
      localb.lGs = a.a.lGq;
      localb.lGt = paramf;
      this.lEj.event(localb);
      this.lEj.doNotify();
    }
    for (;;)
    {
      AppMethodBeat.o(124250);
      return bool;
      Log.w("MicroMsg.BizChatMyUserInfoStorage", "BizChatMyUserInfoStorage update fail");
    }
  }
  
  public final int getCount()
  {
    int i = 0;
    AppMethodBeat.i(124251);
    Log.d("MicroMsg.BizChatMyUserInfoStorage", "BizChatMyUserInfoStorage getCount");
    Cursor localCursor = this.db.rawQuery("SELECT COUNT(*) FROM BizChatMyUserInfo", null, 2);
    if (localCursor.moveToFirst()) {
      i = localCursor.getInt(0);
    }
    localCursor.close();
    AppMethodBeat.o(124251);
    return i;
  }
  
  public static enum a$a
  {
    static
    {
      AppMethodBeat.i(124245);
      lGo = new a("INSTERT", 0);
      lGp = new a("DELETE", 1);
      lGq = new a("UPDATE", 2);
      lGr = new a[] { lGo, lGp, lGq };
      AppMethodBeat.o(124245);
    }
    
    private a$a() {}
  }
  
  public static final class a$b
  {
    public String fzM;
    public g.a.a lGs;
    public f lGt;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.ao.a.g
 * JD-Core Version:    0.7.0.1
 */