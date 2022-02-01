package com.tencent.mm.plugin.ai.d;

import android.database.Cursor;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.platformtools.o.a;
import com.tencent.mm.pointers.PInt;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.sdk.storage.MAutoStorage;
import java.util.List;

public final class i
  extends a<h>
{
  public static final String[] INDEX_CREATE;
  public static final String[] SQL_CREATE;
  
  static
  {
    AppMethodBeat.i(267387);
    SQL_CREATE = new String[] { MAutoStorage.getCreateSQLs(h.info, "WechatAppHistory") };
    INDEX_CREATE = new String[0];
    AppMethodBeat.o(267387);
  }
  
  public i(o.a parama)
  {
    super(parama, h.info, "WechatAppHistory", INDEX_CREATE);
    AppMethodBeat.i(267378);
    Log.i("MicroMsg.WechatDurationHistoryStorage", "WechatDurationHistoryStorage init finish");
    AppMethodBeat.o(267378);
  }
  
  public final long Ua(String paramString)
  {
    localObject2 = null;
    localObject1 = null;
    AppMethodBeat.i(267423);
    l2 = 0L;
    try
    {
      Cursor localCursor = this.qpk.rawQuery(paramString, null);
      long l1 = l2;
      if (localCursor != null)
      {
        l1 = l2;
        localObject1 = localCursor;
        localObject2 = localCursor;
        if (localCursor.moveToFirst())
        {
          localObject1 = localCursor;
          localObject2 = localCursor;
          l1 = localCursor.getLong(0);
        }
      }
      l3 = l1;
      if (localCursor != null)
      {
        localCursor.close();
        l3 = l1;
      }
    }
    catch (Exception localException)
    {
      for (;;)
      {
        localObject2 = localObject1;
        Log.e("MicroMsg.WechatDurationHistoryStorage", "do sql error[%s] sql[%s]", new Object[] { localException.toString(), paramString });
        long l3 = l2;
        if (localObject1 != null)
        {
          localObject1.close();
          l3 = l2;
        }
      }
    }
    finally
    {
      if (localObject2 == null) {
        break label162;
      }
      localObject2.close();
      AppMethodBeat.o(267423);
    }
    AppMethodBeat.o(267423);
    return l3;
  }
  
  public final int cF(List<h> paramList)
  {
    AppMethodBeat.i(267410);
    l4 = Util.currentTicks();
    if (paramList.size() <= 0)
    {
      AppMethodBeat.o(267410);
      return 0;
    }
    l3 = 0L;
    l1 = l3;
    try
    {
      l2 = this.qpk.beginTransaction(Thread.currentThread().getId());
      l1 = l2;
      l3 = l2;
      paramList = paramList.iterator();
      i = 0;
    }
    catch (Exception paramList)
    {
      for (;;)
      {
        paramList = paramList;
        int i = 0;
        this.qpk.endTransaction(l1);
      }
    }
    finally
    {
      this.qpk.endTransaction(l3);
      AppMethodBeat.o(267410);
    }
    l3 = l2;
  }
  
  public final int caF()
  {
    return 7;
  }
  
  public final String caG()
  {
    return "appDs";
  }
  
  public final String tableName()
  {
    return "WechatAppHistory";
  }
  
  public final long yQ(int paramInt)
  {
    AppMethodBeat.i(267415);
    PInt localPInt1 = new PInt();
    PInt localPInt2 = new PInt();
    if (!com.tencent.mm.plugin.ai.b.a.a(7, Util.nowMilliSecond(), localPInt1, localPInt2))
    {
      AppMethodBeat.o(267415);
      return 0L;
    }
    long l = Ua("SELECT SUM( appIn ) FROM WechatAppHistory WHERE  ( appDs >= " + localPInt1.value + " AND appDs <= " + localPInt2.value + " )  AND appHour = " + paramInt);
    AppMethodBeat.o(267415);
    return l;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.ai.d.i
 * JD-Core Version:    0.7.0.1
 */