package com.tencent.mm.plugin.ac.b;

import android.content.ContentValues;
import android.database.Cursor;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.autogen.b.bd;
import com.tencent.mm.kernel.h;
import com.tencent.mm.plugin.messenger.foundation.a.n;
import com.tencent.mm.sdk.storage.ISQLiteDatabase;
import com.tencent.mm.sdk.storage.MStorageEx;
import com.tencent.mm.sdk.storage.sql.Column;
import com.tencent.mm.sdk.storage.sql.FunctionColumn;
import com.tencent.mm.sdk.storage.sql.ISqlCondition;
import com.tencent.mm.sdk.storage.sql.SelectSql;
import com.tencent.mm.sdk.storage.sql.SelectSql.Builder;
import com.tencent.mm.sdk.storage.sql.SingleTable;
import com.tencent.mm.sdk.storage.sql.UpdateSql;
import com.tencent.mm.sdk.storage.sql.UpdateSql.Builder;
import com.tencent.mm.storage.by;
import java.io.Closeable;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.a.p;
import kotlin.ah;
import kotlin.g.b.s;
import kotlin.j;
import kotlin.k;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/mvvmstorage/conversation/MvvmConversationStorage;", "Lcom/tencent/mm/plugin/mvvmstorage/BaseMvvmStorage;", "()V", "dbProvider", "Lcom/tencent/mm/kernel/mvvm/MainDBProvider;", "getDbProvider", "()Lcom/tencent/mm/kernel/mvvm/MainDBProvider;", "dbProvider$delegate", "Lkotlin/Lazy;", "getAllFoldedNames", "", "", "getAllFoldedSize", "", "updateParentRefAndAttrFlagByUserName", "username", "parentRef", "attrflag", "updateParentRefByUserName", "updateParentRefByUserNameList", "userNames", "plugin-mvvmstorage_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class a
  extends com.tencent.mm.plugin.ac.b
{
  private final j DHI;
  
  public a()
  {
    AppMethodBeat.i(262746);
    this.DHI = k.cm((kotlin.g.a.a)a.a.MnZ);
    AppMethodBeat.o(262746);
  }
  
  public final int C(List<String> paramList, String paramString)
  {
    AppMethodBeat.i(262754);
    s.u(paramList, "userNames");
    s.u(paramString, "parentRef");
    Object localObject = bd.TABLE;
    ContentValues localContentValues = new ContentValues();
    localContentValues.put(bd.kaZ.getName(), paramString);
    paramString = ah.aiuX;
    int i = ((SingleTable)localObject).update(localContentValues).where((ISqlCondition)bd.USERNAME.inString(paramList)).build().run(gsF().getDB());
    paramString = ((n)h.ax(n.class)).bzG();
    if (((paramString instanceof MStorageEx)) && (i > 0))
    {
      paramList = paramList.iterator();
      while (paramList.hasNext())
      {
        localObject = (String)paramList.next();
        paramString.doNotify(8, (MStorageEx)paramString, localObject);
      }
    }
    AppMethodBeat.o(262754);
    return i;
  }
  
  public final int au(String paramString1, String paramString2, int paramInt)
  {
    AppMethodBeat.i(262757);
    s.u(paramString1, "username");
    SingleTable localSingleTable = bd.TABLE;
    ContentValues localContentValues = new ContentValues();
    localContentValues.put(bd.kaZ.getName(), paramString2);
    localContentValues.put(bd.kba.getName(), Integer.valueOf(paramInt));
    paramString2 = ah.aiuX;
    paramInt = localSingleTable.update(localContentValues).where((ISqlCondition)bd.USERNAME.equal(paramString1)).build().run(gsF().getDB());
    paramString2 = ((n)h.ax(n.class)).bzG();
    if (((paramString2 instanceof MStorageEx)) && (paramInt > 0)) {
      paramString2.doNotify(3, (MStorageEx)paramString2, paramString1);
    }
    AppMethodBeat.o(262757);
    return paramInt;
  }
  
  public final com.tencent.mm.kernel.mvvm.b gsF()
  {
    AppMethodBeat.i(262750);
    com.tencent.mm.kernel.mvvm.b localb = (com.tencent.mm.kernel.mvvm.b)this.DHI.getValue();
    AppMethodBeat.o(262750);
    return localb;
  }
  
  public final int gsG()
  {
    AppMethodBeat.i(262760);
    Object localObject1 = new FunctionColumn("username", "string", bd.TABLE.getName(), null, "count", 8, null);
    localObject1 = bd.TABLE.select(p.listOf(localObject1)).where((ISqlCondition)bd.kaZ.equal("message_fold")).build();
    Object localObject2 = gsF().getDB();
    if (localObject2 != null)
    {
      localObject1 = ((ISQLiteDatabase)localObject2).rawQuery(((SelectSql)localObject1).toSql(), ((SelectSql)localObject1).getParams());
      if (localObject1 != null) {
        localObject1 = (Closeable)localObject1;
      }
    }
    try
    {
      localObject2 = (Cursor)localObject1;
      if (((Cursor)localObject2).moveToNext())
      {
        int i = ((Cursor)localObject2).getInt(0);
        kotlin.f.b.a((Closeable)localObject1, null);
        AppMethodBeat.o(262760);
        return i;
      }
      localObject2 = ah.aiuX;
      kotlin.f.b.a((Closeable)localObject1, null);
      AppMethodBeat.o(262760);
      return 0;
    }
    finally
    {
      try
      {
        AppMethodBeat.o(262760);
        throw localThrowable;
      }
      finally
      {
        kotlin.f.b.a((Closeable)localObject1, localThrowable);
        AppMethodBeat.o(262760);
      }
    }
  }
  
  public final List<String> gsH()
  {
    AppMethodBeat.i(262762);
    Object localObject1 = bd.TABLE.select(p.listOf(bd.USERNAME)).where((ISqlCondition)bd.kaZ.equal("message_fold")).build();
    ArrayList localArrayList = new ArrayList();
    Object localObject2 = gsF().getDB();
    if (localObject2 != null)
    {
      localObject1 = ((ISQLiteDatabase)localObject2).rawQuery(((SelectSql)localObject1).toSql(), ((SelectSql)localObject1).getParams());
      if (localObject1 != null)
      {
        localObject1 = (Closeable)localObject1;
        try
        {
          localObject2 = (Cursor)localObject1;
          while (((Cursor)localObject2).moveToNext()) {
            localArrayList.add(((Cursor)localObject2).getString(0));
          }
          ah localah;
          localList = (List)localThrowable;
        }
        finally
        {
          try
          {
            AppMethodBeat.o(262762);
            throw localThrowable;
          }
          finally
          {
            kotlin.f.b.a((Closeable)localObject1, localThrowable);
            AppMethodBeat.o(262762);
          }
          localah = ah.aiuX;
          kotlin.f.b.a((Closeable)localObject1, null);
        }
      }
    }
    List localList;
    AppMethodBeat.o(262762);
    return localList;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.ac.b.a
 * JD-Core Version:    0.7.0.1
 */