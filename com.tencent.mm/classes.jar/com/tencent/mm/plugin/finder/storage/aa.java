package com.tencent.mm.plugin.finder.storage;

import android.content.ContentValues;
import android.database.Cursor;
import android.os.SystemClock;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.autogen.b.cj;
import com.tencent.mm.model.cn;
import com.tencent.mm.plugin.finder.api.m;
import com.tencent.mm.plugin.finder.api.m.a;
import com.tencent.mm.plugin.finder.conv.a.a;
import com.tencent.mm.plugin.finder.conv.a.b;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.storage.ISQLiteDatabase;
import com.tencent.mm.sdk.storage.MAutoStorage;
import com.tencent.mm.storagebase.h;
import java.io.Closeable;
import kotlin.Metadata;
import kotlin.ah;
import kotlin.f.b;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/storage/FinderMsgAliasContactStorage;", "Lcom/tencent/mm/sdk/storage/MAutoStorage;", "Lcom/tencent/mm/autogen/table/BaseFinderContact;", "storage", "Lcom/tencent/mm/sdk/storage/ISQLiteDatabase;", "(Lcom/tencent/mm/sdk/storage/ISQLiteDatabase;)V", "getStorage", "()Lcom/tencent/mm/sdk/storage/ISQLiteDatabase;", "getContact", "Lcom/tencent/mm/plugin/finder/api/LocalFinderContact;", "username", "", "insertContact", "", "contact", "replaceContact", "", "ct", "isUpdateTime", "reportSize", "", "updateContact", "Companion", "plugin-finder_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class aa
  extends MAutoStorage<cj>
{
  public static final a FLV;
  private static final String[] INDEX_CREATE;
  private static final String[] SQL_CREATE;
  public final ISQLiteDatabase psb;
  
  static
  {
    AppMethodBeat.i(339529);
    FLV = new a((byte)0);
    INDEX_CREATE = new String[] { "CREATE INDEX IF NOT EXISTS FinderMsgAliasContactStorage_username_index ON FinderMsgAliasContactStorage(username)" };
    m.a locala = m.Axk;
    SQL_CREATE = new String[] { MAutoStorage.getCreateSQLs(m.access$getInfo$cp(), "FinderMsgAliasContactStorage") };
    AppMethodBeat.o(339529);
  }
  
  public aa(ISQLiteDatabase paramISQLiteDatabase)
  {
    super(paramISQLiteDatabase, m.access$getInfo$cp(), "FinderMsgAliasContactStorage", INDEX_CREATE);
    AppMethodBeat.i(339508);
    this.psb = paramISQLiteDatabase;
    AppMethodBeat.o(339508);
  }
  
  public final m auT(String paramString)
  {
    int i = 1;
    AppMethodBeat.i(339541);
    s.u(paramString, "username");
    localObject1 = s.X("SELECT *, rowid FROM FinderMsgAliasContactStorage WHERE username = ", h.EQ(paramString));
    long l = SystemClock.uptimeMillis();
    paramString = this.psb.rawQuery((String)localObject1, null, 2);
    Object localObject2 = new a.a();
    String str = Thread.currentThread().getName();
    s.s(str, "currentThread().name");
    localObject1 = ((a.a)localObject2).avh(str).avg((String)localObject1);
    ((a.a)localObject1).duration = (SystemClock.uptimeMillis() - l);
    ((a.a)localObject1).avf("FinderMsgAliasContactStorage.getContact").dWL().report();
    localObject1 = (Closeable)paramString;
    for (;;)
    {
      try
      {
        localObject2 = (Cursor)localObject1;
        if ((localObject2 == null) || (((Cursor)localObject2).moveToFirst() != true)) {
          continue;
        }
        if (i == 0) {
          continue;
        }
        paramString = new m();
        paramString.convertFrom((Cursor)localObject2);
      }
      finally
      {
        try
        {
          AppMethodBeat.o(339541);
          throw paramString;
        }
        finally
        {
          b.a((Closeable)localObject1, paramString);
          AppMethodBeat.o(339541);
        }
        paramString = null;
        continue;
      }
      localObject2 = ah.aiuX;
      b.a((Closeable)localObject1, null);
      AppMethodBeat.o(339541);
      return paramString;
      i = 0;
    }
  }
  
  public final boolean j(m paramm)
  {
    boolean bool = true;
    AppMethodBeat.i(339555);
    s.u(paramm, "ct");
    paramm.field_updateTime = cn.bDw();
    Object localObject;
    long l1;
    String str;
    if (auT(paramm.getUsername()) == null)
    {
      s.u(paramm, "contact");
      localObject = paramm.convertTo();
      l1 = SystemClock.uptimeMillis();
      long l2 = this.psb.insert("FinderMsgAliasContactStorage", "", (ContentValues)localObject);
      localObject = new a.a();
      str = Thread.currentThread().getName();
      s.s(str, "currentThread().name");
      localObject = ((a.a)localObject).avh(str).avg("insertContact");
      ((a.a)localObject).duration = (SystemClock.uptimeMillis() - l1);
      ((a.a)localObject).avf("FinderMsgAliasContactStorage.insertContact").dWL().report();
      Log.i("Finder.FinderMsgAliasContactStorage", "insert contact " + paramm + ' ' + l2);
      paramm.systemRowid = l2;
      if (l2 <= 0L) {}
    }
    for (;;)
    {
      if (bool) {
        doNotify("FinderMsgAliasContactStorage", 4, paramm.getUsername());
      }
      AppMethodBeat.o(339555);
      return bool;
      bool = false;
      continue;
      s.u(paramm, "contact");
      localObject = paramm.convertTo();
      ((ContentValues)localObject).remove("rowid");
      l1 = SystemClock.uptimeMillis();
      int i = this.psb.update("FinderMsgAliasContactStorage", (ContentValues)localObject, "username=?", new String[] { s.X("", paramm.field_username) });
      localObject = new a.a();
      str = Thread.currentThread().getName();
      s.s(str, "currentThread().name");
      localObject = ((a.a)localObject).avh(str).avg("updateContact");
      ((a.a)localObject).duration = (SystemClock.uptimeMillis() - l1);
      ((a.a)localObject).avf("FinderMsgAliasContactStorage.updateContact").dWL().report();
      Log.i("Finder.FinderMsgAliasContactStorage", "updateContact " + paramm.dUw() + ' ' + i);
      if (i <= 0) {
        bool = false;
      }
    }
  }
  
  @Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/storage/FinderMsgAliasContactStorage$Companion;", "", "()V", "INDEX_CREATE", "", "", "getINDEX_CREATE", "()[Ljava/lang/String;", "[Ljava/lang/String;", "SQL_CREATE", "kotlin.jvm.PlatformType", "getSQL_CREATE", "TABLE_NAME", "TAG", "plugin-finder_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class a {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.storage.aa
 * JD-Core Version:    0.7.0.1
 */