package com.tencent.mm.plugin.luckymoney.story.b;

import android.database.Cursor;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.protocal.protobuf.eno;
import com.tencent.mm.sdk.storage.ISQLiteDatabase;
import com.tencent.mm.sdk.storage.MAutoStorage;
import java.util.ArrayList;
import java.util.List;

public final class d
  extends MAutoStorage<c>
{
  public static final String[] SQL_CREATE;
  public ISQLiteDatabase db;
  
  static
  {
    AppMethodBeat.i(163698);
    SQL_CREATE = new String[] { MAutoStorage.getCreateSQLs(c.info, "LocalStoryDetail") };
    AppMethodBeat.o(163698);
  }
  
  public d(ISQLiteDatabase paramISQLiteDatabase)
  {
    super(paramISQLiteDatabase, c.info, "LocalStoryDetail", null);
    this.db = paramISQLiteDatabase;
  }
  
  public final List<eno> aNK(String paramString)
  {
    AppMethodBeat.i(163697);
    Object localObject = String.format("SELECT * from %s where %s=?", new Object[] { "LocalStoryDetail", "packet_id" });
    paramString = this.db.rawQuery((String)localObject, new String[] { paramString });
    localObject = new ArrayList();
    while (paramString.moveToNext())
    {
      c localc = new c();
      localc.convertFrom(paramString);
      ((List)localObject).add(c.a(localc));
    }
    paramString.close();
    AppMethodBeat.o(163697);
    return localObject;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.luckymoney.story.b.d
 * JD-Core Version:    0.7.0.1
 */