package com.tencent.mm.ca;

import android.content.Context;
import android.text.TextUtils;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ad;

public final class e
{
  public static void hu(Context paramContext)
  {
    AppMethodBeat.i(190236);
    i("MicroMsg.recovery.logger", "flush recovery log to file");
    paramContext = g.b.hx(paramContext);
    paramContext.eCD();
    String str = paramContext.eCE();
    paramContext = str;
    if (TextUtils.isEmpty(str)) {
      paramContext = "nothing";
    }
    ad.i("MicroMsg.recovery.logger", ">>>>>>>>>> dump recovery internal log: <<<<<<<<<<");
    ad.i("MicroMsg.recovery.logger", "\n".concat(String.valueOf(paramContext)));
    ad.i("MicroMsg.recovery.logger", ">>>>>>>>>>>>>>>>>>>>>> end <<<<<<<<<<<<<<<<<<<<<<");
    AppMethodBeat.o(190236);
  }
  
  public static void i(String paramString1, String paramString2)
  {
    AppMethodBeat.i(190233);
    ad.i(paramString1, paramString2);
    a.a.log(4, paramString1, paramString2);
    AppMethodBeat.o(190233);
  }
  
  public static void w(String paramString1, String paramString2)
  {
    AppMethodBeat.i(190234);
    ad.w(paramString1, paramString2);
    a.a.log(5, paramString1, paramString2);
    AppMethodBeat.o(190234);
  }
  
  public static void w(String paramString1, String paramString2, Throwable paramThrowable)
  {
    AppMethodBeat.i(190235);
    ad.printErrStackTrace(paramString1, paramThrowable, paramString2, new Object[0]);
    a.w(paramString1, paramString2, paramThrowable);
    AppMethodBeat.o(190235);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.ca.e
 * JD-Core Version:    0.7.0.1
 */