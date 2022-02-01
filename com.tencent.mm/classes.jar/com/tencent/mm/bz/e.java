package com.tencent.mm.bz;

import android.content.Context;
import android.text.TextUtils;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ac;

public final class e
{
  public static void hF(Context paramContext)
  {
    AppMethodBeat.i(194746);
    i("MicroMsg.recovery.logger", "flush recovery log to file");
    paramContext = g.b.hI(paramContext);
    paramContext.eRX();
    String str = paramContext.eRY();
    paramContext = str;
    if (TextUtils.isEmpty(str)) {
      paramContext = "nothing";
    }
    ac.i("MicroMsg.recovery.logger", ">>>>>>>>>> dump recovery internal log: <<<<<<<<<<");
    ac.i("MicroMsg.recovery.logger", "\n".concat(String.valueOf(paramContext)));
    ac.i("MicroMsg.recovery.logger", ">>>>>>>>>>>>>>>>>>>>>> end <<<<<<<<<<<<<<<<<<<<<<");
    AppMethodBeat.o(194746);
  }
  
  public static void i(String paramString1, String paramString2)
  {
    AppMethodBeat.i(194743);
    ac.i(paramString1, paramString2);
    a.a.log(4, paramString1, paramString2);
    AppMethodBeat.o(194743);
  }
  
  public static void w(String paramString1, String paramString2)
  {
    AppMethodBeat.i(194744);
    ac.w(paramString1, paramString2);
    a.a.log(5, paramString1, paramString2);
    AppMethodBeat.o(194744);
  }
  
  public static void w(String paramString1, String paramString2, Throwable paramThrowable)
  {
    AppMethodBeat.i(194745);
    ac.printErrStackTrace(paramString1, paramThrowable, paramString2, new Object[0]);
    a.w(paramString1, paramString2, paramThrowable);
    AppMethodBeat.o(194745);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.bz.e
 * JD-Core Version:    0.7.0.1
 */