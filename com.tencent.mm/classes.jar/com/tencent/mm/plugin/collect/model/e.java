package com.tencent.mm.plugin.collect.model;

import android.content.Context;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.wxpay.a.i;
import java.text.SimpleDateFormat;
import java.util.Date;

public final class e
{
  public static String Jm(int paramInt)
  {
    AppMethodBeat.i(63781);
    String str = String.format("%.2f", new Object[] { Double.valueOf(paramInt / 100.0D) });
    AppMethodBeat.o(63781);
    return str;
  }
  
  public static String a(Context paramContext, long paramLong, int paramInt)
  {
    AppMethodBeat.i(63780);
    paramLong = 1000L * paramLong;
    if (paramInt == 0)
    {
      paramContext = new SimpleDateFormat(paramContext.getString(a.i.collect_bill_date_day_format)).format(new Date(paramLong));
      AppMethodBeat.o(63780);
      return paramContext;
    }
    if (paramInt == 1)
    {
      paramContext = new SimpleDateFormat(paramContext.getString(a.i.collect_bill_date_month_format)).format(new Date(paramLong));
      AppMethodBeat.o(63780);
      return paramContext;
    }
    paramContext = new SimpleDateFormat(paramContext.getString(a.i.collect_bill_date_year_format)).format(new Date(paramLong));
    AppMethodBeat.o(63780);
    return paramContext;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.collect.model.e
 * JD-Core Version:    0.7.0.1
 */