package com.tencent.mm.plugin.luckymoney.story.b;

import android.database.Cursor;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.protocal.protobuf.dka;
import com.tencent.mm.sdk.e.e;
import com.tencent.mm.sdk.e.j;
import java.util.ArrayList;
import java.util.List;

public final class d
  extends j<c>
{
  public static final String[] SQL_CREATE;
  public e db;
  
  static
  {
    AppMethodBeat.i(163698);
    SQL_CREATE = new String[] { j.getCreateSQLs(c.info, "LocalStoryDetail") };
    AppMethodBeat.o(163698);
  }
  
  public d(e parame)
  {
    super(parame, c.info, "LocalStoryDetail", null);
    this.db = parame;
  }
  
  public final List<dka> aqf(String paramString)
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.luckymoney.story.b.d
 * JD-Core Version:    0.7.0.1
 */