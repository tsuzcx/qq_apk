package com.tencent.mm.plugin.card.b;

import android.database.Cursor;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.f;
import com.tencent.mm.kernel.h;
import com.tencent.mm.plugin.card.c.l;
import com.tencent.mm.plugin.card.model.am;
import com.tencent.mm.plugin.card.model.c;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.storage.ISQLiteDatabase;
import com.tencent.mm.storage.aq;
import com.tencent.mm.storage.at.a;

public final class a
  implements b
{
  public final boolean Ii(int paramInt)
  {
    AppMethodBeat.i(112908);
    boolean bool = l.Ii(paramInt);
    AppMethodBeat.o(112908);
    return bool;
  }
  
  public final boolean dlj()
  {
    AppMethodBeat.i(112904);
    boolean bool = l.doP();
    AppMethodBeat.o(112904);
    return bool;
  }
  
  public final boolean dlk()
  {
    AppMethodBeat.i(112905);
    boolean bool = l.doR();
    AppMethodBeat.o(112905);
    return bool;
  }
  
  public final String dll()
  {
    AppMethodBeat.i(112906);
    String str = (String)h.baE().ban().get(at.a.acJn, null);
    AppMethodBeat.o(112906);
    return str;
  }
  
  public final int dlm()
  {
    int j = 0;
    int i = 0;
    AppMethodBeat.i(112907);
    Object localObject1 = am.dkJ();
    Object localObject2 = new StringBuilder();
    ((StringBuilder)localObject2).append(" where (status=0 OR status=5) and (block_mask").append("= '1' OR block_mask= '0' )");
    localObject2 = "select count(*) from UserCardInfo" + ((StringBuilder)localObject2).toString();
    localObject1 = ((c)localObject1).db.rawQuery((String)localObject2, null, 2);
    if (localObject1 == null) {}
    for (;;)
    {
      Log.i("MicroMsg.CardMgrImpl", "getGiftCardCount:".concat(String.valueOf(i)));
      AppMethodBeat.o(112907);
      return i;
      i = j;
      if (((Cursor)localObject1).moveToFirst()) {
        i = ((Cursor)localObject1).getInt(0);
      }
      ((Cursor)localObject1).close();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes10.jar
 * Qualified Name:     com.tencent.mm.plugin.card.b.a
 * JD-Core Version:    0.7.0.1
 */