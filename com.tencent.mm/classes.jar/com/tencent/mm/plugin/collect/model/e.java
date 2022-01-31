package com.tencent.mm.plugin.collect.model;

import android.content.Context;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.text.SimpleDateFormat;
import java.util.Date;

public final class e
{
  public static String a(Context paramContext, long paramLong, int paramInt)
  {
    AppMethodBeat.i(40930);
    paramLong = 1000L * paramLong;
    if (paramInt == 0)
    {
      paramContext = new SimpleDateFormat(paramContext.getString(2131298420)).format(new Date(paramLong));
      AppMethodBeat.o(40930);
      return paramContext;
    }
    if (paramInt == 1)
    {
      paramContext = new SimpleDateFormat(paramContext.getString(2131298421)).format(new Date(paramLong));
      AppMethodBeat.o(40930);
      return paramContext;
    }
    paramContext = new SimpleDateFormat(paramContext.getString(2131298422)).format(new Date(paramLong));
    AppMethodBeat.o(40930);
    return paramContext;
  }
  
  public static String tN(int paramInt)
  {
    AppMethodBeat.i(40931);
    String str = String.format("%.2f", new Object[] { Double.valueOf(paramInt / 100.0D) });
    AppMethodBeat.o(40931);
    return str;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.collect.model.e
 * JD-Core Version:    0.7.0.1
 */