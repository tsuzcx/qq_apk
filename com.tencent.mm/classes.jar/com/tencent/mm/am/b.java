package com.tencent.mm.am;

import android.database.Cursor;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.model.ai;
import com.tencent.mm.model.aw;
import com.tencent.mm.model.c;
import com.tencent.mm.sdk.platformtools.ab;

public final class b
  extends ai
{
  public final String getTag()
  {
    return "MicroMsg.App.BizPlaceTopDataTransfer";
  }
  
  public final boolean kv(int paramInt)
  {
    return (paramInt != 0) && (paramInt < 637735215);
  }
  
  public final void transfer(int paramInt)
  {
    AppMethodBeat.i(16430);
    ab.d("MicroMsg.App.BizPlaceTopDataTransfer", "the previous version is %d", new Object[] { Integer.valueOf(paramInt) });
    long l1;
    long l2;
    if (kv(paramInt))
    {
      ab.i("MicroMsg.App.BizPlaceTopDataTransfer", "begin biz place to top data transfer.");
      l1 = System.currentTimeMillis();
      com.tencent.mm.plugin.report.service.h.qsU.idkeyStat(336L, 0L, 1L, true);
      aw.aaz();
      com.tencent.mm.cg.h localh = c.Rq();
      Object localObject = new StringBuilder();
      ((StringBuilder)localObject).append("select conv.username");
      ((StringBuilder)localObject).append(" from ");
      ((StringBuilder)localObject).append("rconversation");
      ((StringBuilder)localObject).append(" as conv, ");
      ((StringBuilder)localObject).append("rcontact");
      ((StringBuilder)localObject).append(" as ct ");
      ((StringBuilder)localObject).append(" where conv.");
      ((StringBuilder)localObject).append("parentRef");
      ((StringBuilder)localObject).append("='");
      ((StringBuilder)localObject).append("officialaccounts");
      ((StringBuilder)localObject).append("' and conv.");
      ((StringBuilder)localObject).append("username");
      ((StringBuilder)localObject).append(" = ct.");
      ((StringBuilder)localObject).append("username");
      ((StringBuilder)localObject).append(" and ct.");
      ((StringBuilder)localObject).append("verifyFlag");
      ((StringBuilder)localObject).append(" & ");
      ((StringBuilder)localObject).append(8);
      ((StringBuilder)localObject).append(" = 0");
      localObject = ((StringBuilder)localObject).toString();
      ab.v("MicroMsg.App.BizPlaceTopDataTransfer", "transfer query sql(%s)", new Object[] { localObject });
      localObject = localh.a((String)localObject, null, 2);
      if (localObject == null)
      {
        ab.i("MicroMsg.App.BizPlaceTopDataTransfer", "cursor is null.");
        AppMethodBeat.o(16430);
        return;
      }
      l2 = System.currentTimeMillis();
      ab.i("MicroMsg.App.BizPlaceTopDataTransfer", "do biz place to top data transfer, query cost : %s msec.", new Object[] { Long.valueOf(l2 - l1) });
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("update ");
      localStringBuilder.append("rconversation");
      localStringBuilder.append(" set ");
      localStringBuilder.append("parentRef");
      localStringBuilder.append("='' where ");
      localStringBuilder.append("username");
      localStringBuilder.append(" in (");
      if (((Cursor)localObject).moveToFirst())
      {
        com.tencent.mm.plugin.report.service.h.qsU.idkeyStat(336L, 1L, 1L, true);
        localStringBuilder.append("'");
        localStringBuilder.append(((Cursor)localObject).getString(0));
        localStringBuilder.append("'");
        paramInt = 1;
        while (((Cursor)localObject).moveToNext())
        {
          localStringBuilder.append(",");
          localStringBuilder.append("'");
          localStringBuilder.append(((Cursor)localObject).getString(0));
          localStringBuilder.append("'");
          paramInt += 1;
        }
      }
      ((Cursor)localObject).close();
      ab.i("MicroMsg.App.BizPlaceTopDataTransfer", "cursor count is 0.");
      AppMethodBeat.o(16430);
      return;
      localStringBuilder.append(")");
      String str = localStringBuilder.toString();
      ab.i("MicroMsg.App.BizPlaceTopDataTransfer", "transfer update count(%d)", new Object[] { Integer.valueOf(paramInt) });
      ab.v("MicroMsg.App.BizPlaceTopDataTransfer", "transfer update sql(%s)", new Object[] { str });
      ((Cursor)localObject).close();
      if (!localh.execSQL("rconversation", localStringBuilder.toString())) {
        break label628;
      }
      com.tencent.mm.plugin.report.service.h.qsU.idkeyStat(336L, 2L, 1L, true);
    }
    for (;;)
    {
      long l3 = System.currentTimeMillis();
      ab.i("MicroMsg.App.BizPlaceTopDataTransfer", "do biz place to top data transfer, update cost : %s msec,  total cost : %s msec.", new Object[] { Long.valueOf(l3 - l2), Long.valueOf(l3 - l1) });
      AppMethodBeat.o(16430);
      return;
      label628:
      com.tencent.mm.plugin.report.service.h.qsU.idkeyStat(336L, 3L, 1L, true);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.am.b
 * JD-Core Version:    0.7.0.1
 */