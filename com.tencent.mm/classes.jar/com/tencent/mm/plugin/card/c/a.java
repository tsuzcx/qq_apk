package com.tencent.mm.plugin.card.c;

import android.database.Cursor;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.card.d.l;
import com.tencent.mm.plugin.card.model.am;
import com.tencent.mm.plugin.card.model.c;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.storage.ac.a;
import com.tencent.mm.storage.z;

public final class a
  implements b
{
  public final boolean bcu()
  {
    AppMethodBeat.i(87965);
    boolean bool = l.bfA();
    AppMethodBeat.o(87965);
    return bool;
  }
  
  public final boolean bcv()
  {
    AppMethodBeat.i(87966);
    boolean bool = l.bfC();
    AppMethodBeat.o(87966);
    return bool;
  }
  
  public final String bcw()
  {
    AppMethodBeat.i(87967);
    String str = (String)g.RL().Ru().get(ac.a.yyT, null);
    AppMethodBeat.o(87967);
    return str;
  }
  
  public final int bcx()
  {
    int j = 0;
    int i = 0;
    AppMethodBeat.i(87968);
    Object localObject1 = am.bcd();
    Object localObject2 = new StringBuilder();
    ((StringBuilder)localObject2).append(" where (status=0 OR status=5) and (block_mask= '1' OR block_mask= '0' )");
    localObject2 = "select count(*) from UserCardInfo" + ((StringBuilder)localObject2).toString();
    localObject1 = ((c)localObject1).db.a((String)localObject2, null, 2);
    if (localObject1 == null) {}
    for (;;)
    {
      ab.i("MicroMsg.CardMgrImpl", "getGiftCardCount:".concat(String.valueOf(i)));
      AppMethodBeat.o(87968);
      return i;
      i = j;
      if (((Cursor)localObject1).moveToFirst()) {
        i = ((Cursor)localObject1).getInt(0);
      }
      ((Cursor)localObject1).close();
    }
  }
  
  public final boolean sX(int paramInt)
  {
    AppMethodBeat.i(87969);
    boolean bool = l.sX(paramInt);
    AppMethodBeat.o(87969);
    return bool;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.card.c.a
 * JD-Core Version:    0.7.0.1
 */