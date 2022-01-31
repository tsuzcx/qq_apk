package com.tencent.mm.plugin.card.c;

import android.database.Cursor;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.card.d.l;
import com.tencent.mm.plugin.card.model.am;
import com.tencent.mm.plugin.card.model.c;
import com.tencent.mm.sdk.platformtools.y;
import com.tencent.mm.storage.ac.a;
import com.tencent.mm.storage.z;

public final class a
  implements b
{
  public final boolean aAJ()
  {
    return l.aDd();
  }
  
  public final boolean aAK()
  {
    return l.aDf();
  }
  
  public final String aAL()
  {
    return (String)g.DP().Dz().get(ac.a.uoX, null);
  }
  
  public final int aAM()
  {
    int j = 0;
    int i = 0;
    Object localObject1 = am.aAs();
    Object localObject2 = new StringBuilder();
    ((StringBuilder)localObject2).append(" where (status=0 OR status=5) and (block_mask= '1' OR block_mask= '0' )");
    localObject2 = "select count(*) from UserCardInfo" + ((StringBuilder)localObject2).toString();
    localObject1 = ((c)localObject1).dXw.a((String)localObject2, null, 2);
    if (localObject1 == null) {}
    for (;;)
    {
      y.i("MicroMsg.CardMgrImpl", "getGiftCardCount:" + i);
      return i;
      i = j;
      if (((Cursor)localObject1).moveToFirst()) {
        i = ((Cursor)localObject1).getInt(0);
      }
      ((Cursor)localObject1).close();
    }
  }
  
  public final boolean oN(int paramInt)
  {
    return l.oN(paramInt);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.card.c.a
 * JD-Core Version:    0.7.0.1
 */