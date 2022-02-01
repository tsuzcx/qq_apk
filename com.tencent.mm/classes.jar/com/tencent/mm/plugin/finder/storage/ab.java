package com.tencent.mm.plugin.finder.storage;

import android.content.ContentValues;
import android.database.Cursor;
import android.os.SystemClock;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.autogen.b.cj;
import com.tencent.mm.model.cn;
import com.tencent.mm.plugin.finder.PluginFinder;
import com.tencent.mm.plugin.finder.api.m;
import com.tencent.mm.plugin.finder.api.m.a;
import com.tencent.mm.plugin.finder.conv.a.a;
import com.tencent.mm.plugin.finder.conv.a.b;
import com.tencent.mm.plugin.messenger.foundation.a.n;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.storage.ISQLiteDatabase;
import com.tencent.mm.sdk.storage.MAutoStorage;
import com.tencent.mm.storage.bx;
import java.io.Closeable;
import kotlin.Metadata;
import kotlin.ah;
import kotlin.f.b;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/storage/FinderMsgStrangerContactStorage;", "Lcom/tencent/mm/sdk/storage/MAutoStorage;", "Lcom/tencent/mm/autogen/table/BaseFinderContact;", "storage", "Lcom/tencent/mm/sdk/storage/ISQLiteDatabase;", "(Lcom/tencent/mm/sdk/storage/ISQLiteDatabase;)V", "getStorage", "()Lcom/tencent/mm/sdk/storage/ISQLiteDatabase;", "getContact", "Lcom/tencent/mm/plugin/finder/api/LocalFinderContact;", "username", "", "insertContact", "", "contact", "removeCacheFromWx", "", "replaceContact", "", "ct", "isUpdateTime", "replaceContactIngoreInteract", "reportSize", "updateContact", "Companion", "plugin-finder_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class ab
  extends MAutoStorage<cj>
{
  public static final a FLW;
  private static final String[] INDEX_CREATE;
  private static final String[] SQL_CREATE;
  public final ISQLiteDatabase psb;
  
  static
  {
    AppMethodBeat.i(339567);
    FLW = new a((byte)0);
    INDEX_CREATE = new String[] { "CREATE INDEX IF NOT EXISTS FinderMsgContactStorage_username_index ON FinderMsgContactStorage(username)" };
    m.a locala = m.Axk;
    SQL_CREATE = new String[] { MAutoStorage.getCreateSQLs(m.access$getInfo$cp(), "FinderMsgContactStorage") };
    AppMethodBeat.o(339567);
  }
  
  public ab(ISQLiteDatabase paramISQLiteDatabase)
  {
    super(paramISQLiteDatabase, m.access$getInfo$cp(), "FinderMsgContactStorage", INDEX_CREATE);
    AppMethodBeat.i(339507);
    this.psb = paramISQLiteDatabase;
    AppMethodBeat.o(339507);
  }
  
  private boolean d(m paramm)
  {
    AppMethodBeat.i(339516);
    s.u(paramm, "contact");
    Object localObject = paramm.convertTo();
    ((ContentValues)localObject).remove("rowid");
    long l = SystemClock.uptimeMillis();
    int i = this.psb.update("FinderMsgContactStorage", (ContentValues)localObject, "username=?", new String[] { s.X("", paramm.field_username) });
    localObject = new a.a();
    String str = Thread.currentThread().getName();
    s.s(str, "currentThread().name");
    localObject = ((a.a)localObject).avh(str).avg("updateContact");
    ((a.a)localObject).duration = (SystemClock.uptimeMillis() - l);
    ((a.a)localObject).avf("FinderMsgStrangerContactStorage.updateContact").dWL().report();
    Log.i("Finder.MsgContactStorage", "updateContact " + paramm.dUw() + ' ' + i);
    if (i > 0) {
      l(paramm);
    }
    if (i > 0)
    {
      AppMethodBeat.o(339516);
      return true;
    }
    AppMethodBeat.o(339516);
    return false;
  }
  
  private long k(m paramm)
  {
    AppMethodBeat.i(339526);
    s.u(paramm, "contact");
    Object localObject = paramm.convertTo();
    long l1 = SystemClock.uptimeMillis();
    long l2 = this.psb.insert("FinderMsgContactStorage", "", (ContentValues)localObject);
    localObject = new a.a();
    String str = Thread.currentThread().getName();
    s.s(str, "currentThread().name");
    localObject = ((a.a)localObject).avh(str).avg("insertContact");
    ((a.a)localObject).duration = (SystemClock.uptimeMillis() - l1);
    ((a.a)localObject).avf("FinderMsgStrangerContactStorage.insertContact").dWL().report();
    Log.i("Finder.MsgContactStorage", "insert contact " + paramm + ' ' + l2);
    AppMethodBeat.o(339526);
    return l2;
  }
  
  private static void l(m paramm)
  {
    AppMethodBeat.i(339552);
    bx localbx = ((n)com.tencent.mm.kernel.h.ax(n.class)).bzA();
    String str = ((PluginFinder)com.tencent.mm.kernel.h.az(PluginFinder.class)).getSessionInfoStorage().eK(paramm.getUsername(), 3);
    localbx.aDW(paramm.getUsername());
    localbx.aDW(str);
    AppMethodBeat.o(339552);
  }
  
  public final m auT(String paramString)
  {
    int i = 1;
    AppMethodBeat.i(339577);
    s.u(paramString, "username");
    localObject1 = s.X("SELECT *, rowid FROM FinderMsgContactStorage WHERE username = ", com.tencent.mm.storagebase.h.EQ(paramString));
    long l = SystemClock.uptimeMillis();
    paramString = this.psb.rawQuery((String)localObject1, null, 2);
    Object localObject2 = new a.a();
    String str = Thread.currentThread().getName();
    s.s(str, "currentThread().name");
    localObject1 = ((a.a)localObject2).avh(str).avg((String)localObject1);
    ((a.a)localObject1).duration = (SystemClock.uptimeMillis() - l);
    ((a.a)localObject1).avf("FinderMsgStrangerContactStorage.getContact").dWL().report();
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
          AppMethodBeat.o(339577);
          throw paramString;
        }
        finally
        {
          b.a((Closeable)localObject1, paramString);
          AppMethodBeat.o(339577);
        }
        paramString = null;
        continue;
      }
      localObject2 = ah.aiuX;
      b.a((Closeable)localObject1, null);
      AppMethodBeat.o(339577);
      return paramString;
      i = 0;
    }
  }
  
  public final boolean b(m paramm, boolean paramBoolean)
  {
    AppMethodBeat.i(339584);
    s.u(paramm, "ct");
    if (paramBoolean) {
      paramm.field_updateTime = cn.bDw();
    }
    if (auT(paramm.getUsername()) == null)
    {
      long l = k(paramm);
      paramm.systemRowid = l;
      if (l > 0L) {
        paramBoolean = true;
      }
    }
    for (;;)
    {
      if (paramBoolean)
      {
        l(paramm);
        doNotify("FinderMsgContactStorage", 4, paramm.getUsername());
      }
      AppMethodBeat.o(339584);
      return paramBoolean;
      paramBoolean = false;
      continue;
      paramBoolean = d(paramm);
    }
  }
  
  @Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/storage/FinderMsgStrangerContactStorage$Companion;", "", "()V", "INDEX_CREATE", "", "", "getINDEX_CREATE", "()[Ljava/lang/String;", "[Ljava/lang/String;", "SQL_CREATE", "kotlin.jvm.PlatformType", "getSQL_CREATE", "TABLE_NAME", "TAG", "plugin-finder_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class a {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.storage.ab
 * JD-Core Version:    0.7.0.1
 */