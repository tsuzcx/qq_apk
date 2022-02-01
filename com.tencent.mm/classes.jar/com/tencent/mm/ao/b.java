package com.tencent.mm.ao;

import android.database.Cursor;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.model.as;
import com.tencent.mm.model.bg;
import com.tencent.mm.model.c;
import com.tencent.mm.sdk.platformtools.Log;

public final class b
  extends as
{
  public final String getTag()
  {
    return "MicroMsg.App.BizPlaceTopDataTransfer";
  }
  
  public final boolean rT(int paramInt)
  {
    return (paramInt != 0) && (paramInt < 637735215);
  }
  
  public final void transfer(int paramInt)
  {
    AppMethodBeat.i(20476);
    Log.d("MicroMsg.App.BizPlaceTopDataTransfer", "the previous version is %d", new Object[] { Integer.valueOf(paramInt) });
    long l1;
    long l2;
    if (rT(paramInt))
    {
      Log.i("MicroMsg.App.BizPlaceTopDataTransfer", "begin biz place to top data transfer.");
      l1 = System.currentTimeMillis();
      com.tencent.mm.plugin.report.service.h.CyF.idkeyStat(336L, 0L, 1L, true);
      bg.aVF();
      com.tencent.mm.storagebase.h localh = c.getDataDB();
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
      Log.v("MicroMsg.App.BizPlaceTopDataTransfer", "transfer query sql(%s)", new Object[] { localObject });
      localObject = localh.rawQuery((String)localObject, null, 2);
      if (localObject == null)
      {
        Log.i("MicroMsg.App.BizPlaceTopDataTransfer", "cursor is null.");
        AppMethodBeat.o(20476);
        return;
      }
      l2 = System.currentTimeMillis();
      Log.i("MicroMsg.App.BizPlaceTopDataTransfer", "do biz place to top data transfer, query cost : %s msec.", new Object[] { Long.valueOf(l2 - l1) });
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
        com.tencent.mm.plugin.report.service.h.CyF.idkeyStat(336L, 1L, 1L, true);
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
      Log.i("MicroMsg.App.BizPlaceTopDataTransfer", "cursor count is 0.");
      AppMethodBeat.o(20476);
      return;
      localStringBuilder.append(")");
      String str = localStringBuilder.toString();
      Log.i("MicroMsg.App.BizPlaceTopDataTransfer", "transfer update count(%d)", new Object[] { Integer.valueOf(paramInt) });
      Log.v("MicroMsg.App.BizPlaceTopDataTransfer", "transfer update sql(%s)", new Object[] { str });
      ((Cursor)localObject).close();
      if (!localh.execSQL("rconversation", localStringBuilder.toString())) {
        break label628;
      }
      com.tencent.mm.plugin.report.service.h.CyF.idkeyStat(336L, 2L, 1L, true);
    }
    for (;;)
    {
      long l3 = System.currentTimeMillis();
      Log.i("MicroMsg.App.BizPlaceTopDataTransfer", "do biz place to top data transfer, update cost : %s msec,  total cost : %s msec.", new Object[] { Long.valueOf(l3 - l2), Long.valueOf(l3 - l1) });
      AppMethodBeat.o(20476);
      return;
      label628:
      com.tencent.mm.plugin.report.service.h.CyF.idkeyStat(336L, 3L, 1L, true);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.ao.b
 * JD-Core Version:    0.7.0.1
 */