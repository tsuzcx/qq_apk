package com.tencent.mm.br;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Build.VERSION;
import android.support.v4.app.s.c;
import android.text.format.Time;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.compatible.util.d;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.aj;
import com.tencent.mm.sdk.platformtools.bt;

public final class a
{
  private static String BMN = "";
  private static String fHd = "";
  
  public static String Ye()
  {
    AppMethodBeat.i(116804);
    if (bt.isNullOrNil(fHd)) {
      fHd = com.tencent.mm.kernel.a.Yf().getString("message_channel_id", "message_channel_new_id");
    }
    String str = fHd;
    AppMethodBeat.o(116804);
    return str;
  }
  
  public static void aAl(String paramString)
  {
    fHd = paramString;
  }
  
  public static s.c bD(Context paramContext, String paramString)
  {
    AppMethodBeat.i(116806);
    paramContext = new s.c(paramContext, paramString);
    AppMethodBeat.o(116806);
    return paramContext;
  }
  
  public static int cYf()
  {
    if (Build.VERSION.SDK_INT < 19) {
      return 2131233500;
    }
    return 2131233502;
  }
  
  public static String eux()
  {
    AppMethodBeat.i(116805);
    if (bt.isNullOrNil(BMN)) {
      BMN = com.tencent.mm.kernel.a.Yf().getString("voip_notify_channel_new_id", "voip_notify_channel_new_id");
    }
    String str = BMN;
    AppMethodBeat.o(116805);
    return str;
  }
  
  public static String euy()
  {
    AppMethodBeat.i(116807);
    if (d.lf(26))
    {
      localObject = new Time();
      ((Time)localObject).setToNow();
      int i = ((Time)localObject).hour;
      int j = ((Time)localObject).minute;
      aj.getContext();
      if (!com.tencent.mm.m.a.cr(i, j)) {
        ad.w("MicroMsg.NotificationHelper", "no shake & sound notification during background deactive time");
      }
      for (i = 1; i != 0; i = 0)
      {
        AppMethodBeat.o(116807);
        return "message_dnd_mode_channel_id";
      }
    }
    Object localObject = Ye();
    AppMethodBeat.o(116807);
    return localObject;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.br.a
 * JD-Core Version:    0.7.0.1
 */