package com.tencent.mm.plugin.gamelife.e;

import android.database.Cursor;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.autogen.b.dn;
import com.tencent.mm.sdk.storage.ISQLiteDatabase;
import com.tencent.mm.sdk.storage.MAutoStorage;
import com.tencent.mm.storagebase.h;
import java.io.Closeable;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.ah;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/gamelife/contact/GameLifeContactStorage;", "Lcom/tencent/mm/sdk/storage/MAutoStorage;", "Lcom/tencent/mm/autogen/table/BaseGameLifeContact;", "storage", "Lcom/tencent/mm/sdk/storage/ISQLiteDatabase;", "(Lcom/tencent/mm/sdk/storage/ISQLiteDatabase;)V", "getStorage", "()Lcom/tencent/mm/sdk/storage/ISQLiteDatabase;", "getContact", "Lcom/tencent/mm/plugin/gamelife/contact/GameLifeContact;", "username", "", "", "", "insertContact", "", "contact", "replaceContact", "", "updateContact", "Companion", "plugin-gamelife_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class c
  extends MAutoStorage<dn>
{
  public static final c.a Jbo;
  private static final String[] SQL_CREATE;
  final ISQLiteDatabase psb;
  
  static
  {
    AppMethodBeat.i(268030);
    Jbo = new c.a((byte)0);
    a.a locala = a.Jbe;
    SQL_CREATE = new String[] { MAutoStorage.getCreateSQLs(a.access$getInfo$cp(), "GameLifeContact") };
    AppMethodBeat.o(268030);
  }
  
  public c(ISQLiteDatabase paramISQLiteDatabase)
  {
    super(paramISQLiteDatabase, a.access$getInfo$cp(), "GameLifeContact", dn.INDEX_CREATE);
    AppMethodBeat.i(268011);
    this.psb = paramISQLiteDatabase;
    AppMethodBeat.o(268011);
  }
  
  public final a aHC(String paramString)
  {
    int i = 1;
    AppMethodBeat.i(268040);
    s.u(paramString, "username");
    paramString = s.X("SELECT *, rowid FROM GameLifeContact WHERE username = ", h.EQ(paramString));
    localCloseable = (Closeable)this.psb.rawQuery(paramString, null, 2);
    for (;;)
    {
      try
      {
        localObject1 = (Cursor)localCloseable;
        if ((localObject1 == null) || (((Cursor)localObject1).moveToFirst() != true)) {
          continue;
        }
        if (i == 0) {
          continue;
        }
        paramString = new a();
        paramString.convertFrom((Cursor)localObject1);
      }
      finally
      {
        try
        {
          Object localObject1;
          AppMethodBeat.o(268040);
          throw paramString;
        }
        finally
        {
          kotlin.f.b.a(localCloseable, paramString);
          AppMethodBeat.o(268040);
        }
        paramString = null;
        continue;
      }
      localObject1 = ah.aiuX;
      kotlin.f.b.a(localCloseable, null);
      AppMethodBeat.o(268040);
      return paramString;
      i = 0;
    }
  }
  
  public final Map<String, a> ij(List<String> paramList)
  {
    AppMethodBeat.i(268053);
    s.u(paramList, "username");
    Object localObject1 = com.tencent.mm.plugin.gamelife.b.IYX;
    s.u(paramList, "stringList");
    if (paramList.isEmpty())
    {
      paramList = "()";
      paramList = s.X("SELECT *, rowid FROM GameLifeContact WHERE username IN ", paramList);
      localObject1 = new HashMap();
      paramList = (Closeable)this.psb.rawQuery(paramList, null, 2);
      try
      {
        Cursor localCursor = (Cursor)paramList;
        if (!localCursor.moveToFirst()) {
          break label296;
        }
        while (!localCursor.isAfterLast())
        {
          a locala = new a();
          locala.convertFrom(localCursor);
          Map localMap = (Map)localObject1;
          String str = locala.field_username;
          s.s(str, "field_username");
          localMap.put(str, locala);
          localCursor.moveToNext();
        }
        localStringBuilder = new StringBuilder();
      }
      finally
      {
        try
        {
          AppMethodBeat.o(268053);
          throw localThrowable;
        }
        finally
        {
          kotlin.f.b.a(paramList, localThrowable);
          AppMethodBeat.o(268053);
        }
      }
    }
    StringBuilder localStringBuilder;
    localStringBuilder.append("(");
    int i = 0;
    int k = paramList.size() - 1;
    if (k > 0) {}
    for (;;)
    {
      int j = i + 1;
      localStringBuilder.append("'").append((String)paramList.get(i)).append("',");
      if (j >= k)
      {
        localStringBuilder.append("'").append((String)paramList.get(paramList.size() - 1)).append("')");
        paramList = localStringBuilder.toString();
        s.s(paramList, "sb.toString()");
        break;
        label296:
        ah localah = ah.aiuX;
        kotlin.f.b.a(paramList, null);
        paramList = (Map)localStringBuilder;
        AppMethodBeat.o(268053);
        return paramList;
      }
      i = j;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.gamelife.e.c
 * JD-Core Version:    0.7.0.1
 */