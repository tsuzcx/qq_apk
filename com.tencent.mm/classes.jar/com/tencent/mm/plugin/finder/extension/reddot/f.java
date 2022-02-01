package com.tencent.mm.plugin.finder.extension.reddot;

import android.database.Cursor;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ae.e;
import com.tencent.mm.ae.e.a;
import com.tencent.mm.autogen.b.dc;
import com.tencent.mm.autogen.mmdata.rpt.di;
import com.tencent.mm.protocal.protobuf.FinderTipsShowEntranceExtInfo;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.storage.IAutoDBItem;
import com.tencent.mm.sdk.storage.ISQLiteDatabase;
import com.tencent.mm.sdk.storage.MAutoStorage;
import java.io.Closeable;
import java.util.LinkedList;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.Result.Companion;
import kotlin.ResultKt;
import kotlin.ah;
import kotlin.g.a.a;
import kotlin.g.b.ah.a;
import kotlin.g.b.ah.f;
import kotlin.g.b.s;
import kotlin.g.b.u;
import kotlin.n.d;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/extension/reddot/FinderRedDotCtrInfoStorage;", "Lcom/tencent/mm/sdk/storage/MAutoStorage;", "Lcom/tencent/mm/plugin/finder/extension/reddot/LocalFinderRedDotCtrInfo;", "db", "Lcom/tencent/mm/sdk/storage/ISQLiteDatabase;", "(Lcom/tencent/mm/sdk/storage/ISQLiteDatabase;)V", "getDb", "()Lcom/tencent/mm/sdk/storage/ISQLiteDatabase;", "delete", "", "item", "isNotify", "keys", "", "", "(Lcom/tencent/mm/plugin/finder/extension/reddot/LocalFinderRedDotCtrInfo;Z[Ljava/lang/String;)Z", "deleteAll", "insertDataForTest", "", "count", "", "isExist", "id", "optMsgInfo", "timeStamp", "", "tipsShowEntranceExtInfo", "Lcom/tencent/mm/protocal/protobuf/FinderTipsShowEntranceExtInfo;", "optPostRedDot", "queryAll", "Ljava/util/LinkedList;", "replace", "update", "Companion", "plugin-finder_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class f
  extends MAutoStorage<p>
{
  public static final a AQh;
  private static final String[] SQL_CREATE;
  final ISQLiteDatabase db;
  
  static
  {
    AppMethodBeat.i(178147);
    AQh = new a((byte)0);
    p.a locala = p.ASw;
    SQL_CREATE = new String[] { MAutoStorage.getCreateSQLs(p.access$getInfo$cp(), "FinderRedDotInfo") };
    AppMethodBeat.o(178147);
  }
  
  public f(ISQLiteDatabase paramISQLiteDatabase)
  {
    super(paramISQLiteDatabase, p.access$getInfo$cp(), "FinderRedDotInfo", dc.INDEX_CREATE);
    AppMethodBeat.i(178146);
    this.db = paramISQLiteDatabase;
    AppMethodBeat.o(178146);
  }
  
  private boolean a(p paramp, boolean paramBoolean)
  {
    bool1 = true;
    AppMethodBeat.i(366774);
    if (paramp == null)
    {
      Log.i("Finder.RedDotCtrInfoStorage", "[replace] failure!");
      AppMethodBeat.o(366774);
      return false;
    }
    Object localObject = paramp.field_tipsId;
    s.s(localObject, "item.field_tipsId");
    s.u(localObject, "id");
    localObject = "select * from FinderRedDotInfo  where tipsId = '" + (String)localObject + "' ";
    localObject = this.db.rawQuery((String)localObject, null);
    boolean bool2;
    if (((Cursor)localObject).getCount() > 0)
    {
      bool2 = true;
      ((Cursor)localObject).close();
      if (!bool2) {
        break label273;
      }
    }
    for (;;)
    {
      try
      {
        s.u(paramp, "item");
        if (this.db.update(getTableName(), paramp.convertTo(), "tipsId = ?", new String[] { paramp.field_tipsId }) <= 0) {
          continue;
        }
        if ((bool1) && (paramBoolean)) {
          doNotify("update");
        }
        Log.i("Finder.RedDotCtrInfoStorage", "[update] ret=" + bool1 + " item=" + paramp.field_tipsId + " isNotify=" + paramBoolean);
      }
      catch (Exception localException)
      {
        label273:
        Log.printErrStackTrace("Finder.RedDotCtrInfoStorage", (Throwable)localException, "tipsId=" + paramp.field_tipsId + " type=" + paramp.field_ctrType, new Object[0]);
        di localdi = new di();
        localdi.nq("1");
        localdi.izr = 10003L;
        localdi.bMH();
        bool1 = false;
        continue;
      }
      Log.i("Finder.RedDotCtrInfoStorage", "[replace] ret=" + bool1 + " isExist=" + bool2 + " item=" + paramp.field_tipsId + " isNotify=" + paramBoolean);
      AppMethodBeat.o(366774);
      return bool1;
      bool2 = false;
      break;
      bool1 = false;
      continue;
      bool1 = insertNotify((IAutoDBItem)paramp, paramBoolean);
    }
  }
  
  public final LinkedList<p> dZg()
  {
    AppMethodBeat.i(366802);
    long l = System.currentTimeMillis();
    localLinkedList = new LinkedList();
    for (;;)
    {
      try
      {
        localObject1 = getAll();
        if (localObject1 != null) {
          localObject1 = (Closeable)localObject1;
        }
      }
      catch (Exception localException)
      {
        Object localObject1;
        Object localObject2;
        final p localp;
        Log.printErrStackTrace("Finder.RedDotCtrInfoStorage", (Throwable)localException, "", new Object[0]);
        continue;
        int i = localThrowable2.length;
        continue;
      }
      try
      {
        localObject2 = (Cursor)localObject1;
        if (((Cursor)localObject2).moveToFirst())
        {
          localp = new p();
          localp.convertFrom((Cursor)localObject2);
        }
        try
        {
          localObject4 = Result.Companion;
          if (localp.field_ctrInfo == null)
          {
            localObject4 = ((Cursor)localObject2).getBlob(((Cursor)localObject2).getColumnIndex("ctrInfo"));
            localObject5 = new ah.a();
          }
        }
        finally
        {
          Object localObject4;
          Object localObject6;
          Result.Companion localCompanion1;
          boolean bool;
          Object localObject5 = Result.Companion;
          Result.constructor-impl(ResultKt.createFailure(localThrowable2));
          continue;
        }
        try
        {
          localObject6 = Result.Companion;
          if (localObject4 != null) {
            continue;
          }
          i = -1;
          if (i > 0)
          {
            new FinderTipsShowEntranceExtInfo().parseFrom((byte[])localObject4);
            ((ah.a)localObject5).aiwY = true;
          }
          Result.constructor-impl(ah.aiuX);
        }
        finally
        {
          localCompanion1 = Result.Companion;
          Result.constructor-impl(ResultKt.createFailure(localThrowable3));
          continue;
        }
        localObject6 = new ah.f();
        ((ah.f)localObject6).aqH = "";
      }
      finally
      {
        try
        {
          AppMethodBeat.o(366802);
          throw localThrowable1;
        }
        finally
        {
          kotlin.f.b.a((Closeable)localObject1, localThrowable1);
          AppMethodBeat.o(366802);
        }
      }
      try
      {
        localCompanion1 = Result.Companion;
        if (localObject4 != null) {
          continue;
        }
        i = -1;
        if (i > 0)
        {
          s.s(localObject4, "buf");
          ((ah.f)localObject6).aqH = new String((byte[])localObject4, d.UTF_8);
        }
        Result.constructor-impl(ah.aiuX);
      }
      finally
      {
        Result.Companion localCompanion2 = Result.Companion;
        Result.constructor-impl(ResultKt.createFailure(localThrowable4));
        continue;
        localLinkedList.add(localObject3);
        continue;
      }
      e.a.a((e)com.tencent.mm.plugin.findersdk.b.HbT, "field_ctrInfo_null_blob", true, (a)new b((byte[])localObject4, (ah.a)localObject5, (ah.f)localObject6, localp));
      Result.constructor-impl(ah.aiuX);
      if (localp.field_ctrInfo != null) {
        break label519;
      }
      bool = delete(localp.systemRowid);
      Log.e("Finder.RedDotCtrInfoStorage", "delete[" + bool + "] valid rowId=" + localp.systemRowid + " tipsId=" + localp.field_tipsId + " type=" + localp.field_ctrType);
      if (!((Cursor)localObject2).moveToNext())
      {
        localObject2 = ah.aiuX;
        kotlin.f.b.a((Closeable)localObject1, null);
        Log.i("Finder.RedDotCtrInfoStorage", "[queryAll] COST=" + (System.currentTimeMillis() - l) + "ms");
        AppMethodBeat.o(366802);
        return localLinkedList;
        i = localObject4.length;
      }
    }
  }
  
  @Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/extension/reddot/FinderRedDotCtrInfoStorage$Companion;", "", "()V", "SQL_CREATE", "", "", "kotlin.jvm.PlatformType", "getSQL_CREATE", "()[Ljava/lang/String;", "[Ljava/lang/String;", "TABLE", "TAG", "plugin-finder_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class a {}
  
  @Metadata(d1={""}, d2={"<anonymous>", ""}, k=3, mv={1, 5, 1}, xi=48)
  static final class b
    extends u
    implements a<String>
  {
    b(byte[] paramArrayOfByte, ah.a parama, ah.f<String> paramf, p paramp)
    {
      super();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.extension.reddot.f
 * JD-Core Version:    0.7.0.1
 */