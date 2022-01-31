package com.tencent.mm.plugin.collect.b;

import android.content.Context;
import com.tencent.mm.plugin.wxpay.a.i;
import java.text.SimpleDateFormat;
import java.util.Date;

public final class e
{
  public static String a(Context paramContext, long paramLong, int paramInt)
  {
    paramLong = 1000L * paramLong;
    if (paramInt == 0) {
      return new SimpleDateFormat(paramContext.getString(a.i.collect_bill_date_day_format)).format(new Date(paramLong));
    }
    if (paramInt == 1) {
      return new SimpleDateFormat(paramContext.getString(a.i.collect_bill_date_month_format)).format(new Date(paramLong));
    }
    return new SimpleDateFormat(paramContext.getString(a.i.collect_bill_date_year_format)).format(new Date(paramLong));
  }
  
  public static String pw(int paramInt)
  {
    return String.format("%.2f", new Object[] { Double.valueOf(paramInt / 100.0D) });
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.collect.b.e
 * JD-Core Version:    0.7.0.1
 */