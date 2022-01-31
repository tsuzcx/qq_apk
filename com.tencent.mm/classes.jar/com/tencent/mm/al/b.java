package com.tencent.mm.al;

import android.database.Cursor;
import com.tencent.mm.model.ah;
import com.tencent.mm.model.au;
import com.tencent.mm.model.c;
import com.tencent.mm.sdk.platformtools.y;

public final class b
  extends ah
{
  public final String getTag()
  {
    return "MicroMsg.App.BizPlaceTopDataTransfer";
  }
  
  public final boolean hJ(int paramInt)
  {
    return (paramInt != 0) && (paramInt < 637735215);
  }
  
  public final void transfer(int paramInt)
  {
    y.d("MicroMsg.App.BizPlaceTopDataTransfer", "the previous version is %d", new Object[] { Integer.valueOf(paramInt) });
    long l1;
    com.tencent.mm.cf.h localh;
    Object localObject;
    if (hJ(paramInt))
    {
      y.i("MicroMsg.App.BizPlaceTopDataTransfer", "begin biz place to top data transfer.");
      l1 = System.currentTimeMillis();
      com.tencent.mm.plugin.report.service.h.nFQ.a(336L, 0L, 1L, true);
      au.Hx();
      localh = c.Dv();
      localObject = new StringBuilder();
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
      y.v("MicroMsg.App.BizPlaceTopDataTransfer", "transfer query sql(%s)", new Object[] { localObject });
      localObject = localh.a((String)localObject, null, 2);
      if (localObject == null) {
        y.i("MicroMsg.App.BizPlaceTopDataTransfer", "cursor is null.");
      }
    }
    else
    {
      return;
    }
    long l2 = System.currentTimeMillis();
    y.i("MicroMsg.App.BizPlaceTopDataTransfer", "do biz place to top data transfer, query cost : %s msec.", new Object[] { Long.valueOf(l2 - l1) });
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
      com.tencent.mm.plugin.report.service.h.nFQ.a(336L, 1L, 1L, true);
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
    y.i("MicroMsg.App.BizPlaceTopDataTransfer", "cursor count is 0.");
    return;
    localStringBuilder.append(")");
    String str = localStringBuilder.toString();
    y.i("MicroMsg.App.BizPlaceTopDataTransfer", "transfer update count(%d)", new Object[] { Integer.valueOf(paramInt) });
    y.v("MicroMsg.App.BizPlaceTopDataTransfer", "transfer update sql(%s)", new Object[] { str });
    ((Cursor)localObject).close();
    if (localh.gk("rconversation", localStringBuilder.toString())) {
      com.tencent.mm.plugin.report.service.h.nFQ.a(336L, 2L, 1L, true);
    }
    for (;;)
    {
      long l3 = System.currentTimeMillis();
      y.i("MicroMsg.App.BizPlaceTopDataTransfer", "do biz place to top data transfer, update cost : %s msec,  total cost : %s msec.", new Object[] { Long.valueOf(l3 - l2), Long.valueOf(l3 - l1) });
      return;
      com.tencent.mm.plugin.report.service.h.nFQ.a(336L, 3L, 1L, true);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.al.b
 * JD-Core Version:    0.7.0.1
 */