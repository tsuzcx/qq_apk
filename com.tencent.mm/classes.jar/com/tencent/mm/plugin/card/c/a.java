package com.tencent.mm.plugin.card.c;

import android.database.Cursor;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.card.d.l;
import com.tencent.mm.plugin.card.model.am;
import com.tencent.mm.plugin.card.model.c;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.storage.ab;
import com.tencent.mm.storage.ae.a;

public final class a
  implements b
{
  public final boolean bJs()
  {
    AppMethodBeat.i(112904);
    boolean bool = l.bML();
    AppMethodBeat.o(112904);
    return bool;
  }
  
  public final boolean bJt()
  {
    AppMethodBeat.i(112905);
    boolean bool = l.bMN();
    AppMethodBeat.o(112905);
    return bool;
  }
  
  public final String bJu()
  {
    AppMethodBeat.i(112906);
    String str = (String)g.afB().afk().get(ae.a.Fho, null);
    AppMethodBeat.o(112906);
    return str;
  }
  
  public final int bJv()
  {
    int j = 0;
    int i = 0;
    AppMethodBeat.i(112907);
    Object localObject1 = am.bIV();
    Object localObject2 = new StringBuilder();
    ((StringBuilder)localObject2).append(" where (status=0 OR status=5) and (block_mask= '1' OR block_mask= '0' )");
    localObject2 = "select count(*) from UserCardInfo" + ((StringBuilder)localObject2).toString();
    localObject1 = ((c)localObject1).db.a((String)localObject2, null, 2);
    if (localObject1 == null) {}
    for (;;)
    {
      ad.i("MicroMsg.CardMgrImpl", "getGiftCardCount:".concat(String.valueOf(i)));
      AppMethodBeat.o(112907);
      return i;
      i = j;
      if (((Cursor)localObject1).moveToFirst()) {
        i = ((Cursor)localObject1).getInt(0);
      }
      ((Cursor)localObject1).close();
    }
  }
  
  public final boolean yQ(int paramInt)
  {
    AppMethodBeat.i(112908);
    boolean bool = l.yQ(paramInt);
    AppMethodBeat.o(112908);
    return bool;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.card.c.a
 * JD-Core Version:    0.7.0.1
 */