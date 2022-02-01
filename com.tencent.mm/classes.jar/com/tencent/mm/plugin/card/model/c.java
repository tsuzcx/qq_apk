package com.tencent.mm.plugin.card.model;

import android.database.Cursor;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.f;
import com.tencent.mm.kernel.h;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.sdk.storage.ISQLiteDatabase;
import com.tencent.mm.sdk.storage.MAutoStorage;
import com.tencent.mm.storage.ao;
import com.tencent.mm.storage.ar.a;

public final class c
  extends MAutoStorage<CardInfo>
{
  public static final String[] SQL_CREATE;
  public ISQLiteDatabase db;
  
  static
  {
    AppMethodBeat.i(112770);
    SQL_CREATE = new String[] { MAutoStorage.getCreateSQLs(CardInfo.info, "UserCardInfo"), "CREATE INDEX IF NOT EXISTS  stickyIndexIndex ON UserCardInfo ( stickyIndex ) " };
    AppMethodBeat.o(112770);
  }
  
  public c(ISQLiteDatabase paramISQLiteDatabase)
  {
    super(paramISQLiteDatabase, CardInfo.info, "UserCardInfo", null);
    this.db = paramISQLiteDatabase;
  }
  
  public final Cursor a(n.a parama)
  {
    AppMethodBeat.i(112767);
    long l = Util.nowSecond();
    Object localObject = "update UserCardInfo set stickyIndex=0, stickyEndTime=0 where stickyIndex>0 and (" + l + ">stickyEndTime and stickyEndTime<>0)";
    this.db.execSQL("UserCardInfo", (String)localObject);
    localObject = new StringBuilder("select * from UserCardInfo");
    switch (1.tpn[parama.ordinal()])
    {
    }
    for (;;)
    {
      ((StringBuilder)localObject).append(" order by stickyIndex desc, status asc , updateTime desc");
      if (parama == n.a.tpW)
      {
        int i = ((Integer)h.aHG().aHp().get(ar.a.Vio, Integer.valueOf(3))).intValue();
        ((StringBuilder)localObject).append(" LIMIT ").append(i);
      }
      parama = this.db.rawQuery(((StringBuilder)localObject).toString(), null);
      AppMethodBeat.o(112767);
      return parama;
      ((StringBuilder)localObject).append(" where (status=0 OR status=5)");
      continue;
      ((StringBuilder)localObject).append(" where (status=0 OR status=5) AND ").append("card_type=10");
      continue;
      ((StringBuilder)localObject).append(" where (status=0 OR status=5) AND ").append("card_type!=10");
      continue;
      ((StringBuilder)localObject).append(" where (status=0 OR status=5) AND ").append("card_type!=10 AND card_type!=30");
      continue;
      ((StringBuilder)localObject).append(" where (status=1 OR status=2 OR status").append("=3 OR status=4 OR status=6)");
      continue;
      ((StringBuilder)localObject).append(" where (status=0 OR status=5) and (block_mask").append("= '1' OR block_mask= '0' )");
    }
  }
  
  public final CardInfo aqX(String paramString)
  {
    AppMethodBeat.i(112768);
    CardInfo localCardInfo = new CardInfo();
    localCardInfo.field_card_id = paramString;
    if (super.get(localCardInfo, new String[0]))
    {
      AppMethodBeat.o(112768);
      return localCardInfo;
    }
    AppMethodBeat.o(112768);
    return null;
  }
  
  /* Error */
  public final java.util.List<CardInfo> cHi()
  {
    // Byte code:
    //   0: ldc 179
    //   2: invokestatic 20	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   5: aload_0
    //   6: getfield 49	com/tencent/mm/plugin/card/model/c:db	Lcom/tencent/mm/sdk/storage/ISQLiteDatabase;
    //   9: ldc 181
    //   11: iconst_1
    //   12: anewarray 22	java/lang/String
    //   15: dup
    //   16: iconst_0
    //   17: ldc 183
    //   19: aastore
    //   20: invokeinterface 144 3 0
    //   25: astore_1
    //   26: aload_1
    //   27: ifnonnull +17 -> 44
    //   30: ldc 185
    //   32: ldc 187
    //   34: invokestatic 193	com/tencent/mm/sdk/platformtools/Log:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   37: ldc 179
    //   39: invokestatic 41	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   42: aconst_null
    //   43: areturn
    //   44: new 195	java/util/ArrayList
    //   47: dup
    //   48: invokespecial 196	java/util/ArrayList:<init>	()V
    //   51: astore_2
    //   52: aload_1
    //   53: invokeinterface 202 1 0
    //   58: ifeq +59 -> 117
    //   61: new 24	com/tencent/mm/plugin/card/model/CardInfo
    //   64: dup
    //   65: invokespecial 167	com/tencent/mm/plugin/card/model/CardInfo:<init>	()V
    //   68: astore_3
    //   69: aload_3
    //   70: aload_1
    //   71: invokevirtual 206	com/tencent/mm/plugin/card/model/CardInfo:convertFrom	(Landroid/database/Cursor;)V
    //   74: aload_2
    //   75: aload_3
    //   76: invokeinterface 212 2 0
    //   81: pop
    //   82: goto -30 -> 52
    //   85: astore_3
    //   86: ldc 185
    //   88: ldc 214
    //   90: iconst_1
    //   91: anewarray 216	java/lang/Object
    //   94: dup
    //   95: iconst_0
    //   96: aload_3
    //   97: invokevirtual 219	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   100: aastore
    //   101: invokestatic 222	com/tencent/mm/sdk/platformtools/Log:e	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   104: aload_1
    //   105: invokeinterface 225 1 0
    //   110: ldc 179
    //   112: invokestatic 41	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   115: aload_2
    //   116: areturn
    //   117: aload_1
    //   118: invokeinterface 225 1 0
    //   123: goto -13 -> 110
    //   126: astore_2
    //   127: aload_1
    //   128: invokeinterface 225 1 0
    //   133: ldc 179
    //   135: invokestatic 41	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   138: aload_2
    //   139: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	140	0	this	c
    //   25	103	1	localCursor	Cursor
    //   51	65	2	localArrayList	java.util.ArrayList
    //   126	13	2	localObject	Object
    //   68	8	3	localCardInfo	CardInfo
    //   85	12	3	localException	java.lang.Exception
    // Exception table:
    //   from	to	target	type
    //   52	82	85	java/lang/Exception
    //   52	82	126	finally
    //   86	104	126	finally
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.card.model.c
 * JD-Core Version:    0.7.0.1
 */