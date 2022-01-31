package com.tencent.mm.plugin.card.model;

import android.database.Cursor;
import com.tencent.mm.kernel.g;
import com.tencent.mm.sdk.e.i;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.storage.ac.a;
import com.tencent.mm.storage.z;

public final class c
  extends i<CardInfo>
{
  public static final String[] dXp = { i.a(CardInfo.buS, "UserCardInfo"), "CREATE INDEX IF NOT EXISTS  stickyIndexIndex ON UserCardInfo ( stickyIndex ) " };
  public com.tencent.mm.sdk.e.e dXw;
  
  public c(com.tencent.mm.sdk.e.e parame)
  {
    super(parame, CardInfo.buS, "UserCardInfo", null);
    this.dXw = parame;
  }
  
  public final Cursor a(n.a parama)
  {
    long l = bk.UX();
    Object localObject = "update UserCardInfo set stickyIndex=0, stickyEndTime=0 where stickyIndex>0 and (" + l + ">stickyEndTime and stickyEndTime<>0)";
    this.dXw.gk("UserCardInfo", (String)localObject);
    localObject = new StringBuilder("select * from UserCardInfo");
    switch (c.1.imx[parama.ordinal()])
    {
    }
    for (;;)
    {
      ((StringBuilder)localObject).append(" order by stickyIndex desc, status asc , updateTime desc");
      if (parama == n.a.ink)
      {
        int i = ((Integer)g.DP().Dz().get(ac.a.ups, Integer.valueOf(3))).intValue();
        ((StringBuilder)localObject).append(" LIMIT ").append(i);
      }
      return this.dXw.rawQuery(((StringBuilder)localObject).toString(), null);
      ((StringBuilder)localObject).append(" where (status=0 OR status=5)");
      continue;
      ((StringBuilder)localObject).append(" where (status=0 OR status=5) AND card_type=10");
      continue;
      ((StringBuilder)localObject).append(" where (status=0 OR status=5) AND card_type!=10");
      continue;
      ((StringBuilder)localObject).append(" where (status=0 OR status=5) AND card_type!=10 AND card_type!=30");
      continue;
      ((StringBuilder)localObject).append(" where (status=1 OR status=2 OR status=3 OR status=4 OR status=6)");
      continue;
      ((StringBuilder)localObject).append(" where (status=0 OR status=5) and (block_mask= '1' OR block_mask= '0' )");
    }
  }
  
  /* Error */
  public final java.util.List<CardInfo> aAh()
  {
    // Byte code:
    //   0: aload_0
    //   1: getfield 37	com/tencent/mm/plugin/card/model/c:dXw	Lcom/tencent/mm/sdk/e/e;
    //   4: ldc 150
    //   6: iconst_1
    //   7: anewarray 13	java/lang/String
    //   10: dup
    //   11: iconst_0
    //   12: ldc 152
    //   14: aastore
    //   15: invokeinterface 132 3 0
    //   20: astore_1
    //   21: aload_1
    //   22: ifnonnull +12 -> 34
    //   25: ldc 154
    //   27: ldc 156
    //   29: invokestatic 162	com/tencent/mm/sdk/platformtools/y:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   32: aconst_null
    //   33: areturn
    //   34: new 164	java/util/ArrayList
    //   37: dup
    //   38: invokespecial 166	java/util/ArrayList:<init>	()V
    //   41: astore_2
    //   42: aload_1
    //   43: invokeinterface 172 1 0
    //   48: ifeq +54 -> 102
    //   51: new 15	com/tencent/mm/plugin/card/model/CardInfo
    //   54: dup
    //   55: invokespecial 173	com/tencent/mm/plugin/card/model/CardInfo:<init>	()V
    //   58: astore_3
    //   59: aload_3
    //   60: aload_1
    //   61: invokevirtual 177	com/tencent/mm/plugin/card/model/CardInfo:d	(Landroid/database/Cursor;)V
    //   64: aload_2
    //   65: aload_3
    //   66: invokeinterface 183 2 0
    //   71: pop
    //   72: goto -30 -> 42
    //   75: astore_3
    //   76: ldc 154
    //   78: ldc 185
    //   80: iconst_1
    //   81: anewarray 187	java/lang/Object
    //   84: dup
    //   85: iconst_0
    //   86: aload_3
    //   87: invokevirtual 190	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   90: aastore
    //   91: invokestatic 193	com/tencent/mm/sdk/platformtools/y:e	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   94: aload_1
    //   95: invokeinterface 196 1 0
    //   100: aload_2
    //   101: areturn
    //   102: aload_1
    //   103: invokeinterface 196 1 0
    //   108: aload_2
    //   109: areturn
    //   110: astore_2
    //   111: aload_1
    //   112: invokeinterface 196 1 0
    //   117: aload_2
    //   118: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	119	0	this	c
    //   20	92	1	localCursor	Cursor
    //   41	68	2	localArrayList	java.util.ArrayList
    //   110	8	2	localObject	Object
    //   58	8	3	localCardInfo	CardInfo
    //   75	12	3	localException	java.lang.Exception
    // Exception table:
    //   from	to	target	type
    //   42	72	75	java/lang/Exception
    //   42	72	110	finally
    //   76	94	110	finally
  }
  
  public final CardInfo yi(String paramString)
  {
    CardInfo localCardInfo = new CardInfo();
    localCardInfo.field_card_id = paramString;
    if (super.b(localCardInfo, new String[0])) {
      return localCardInfo;
    }
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.card.model.c
 * JD-Core Version:    0.7.0.1
 */