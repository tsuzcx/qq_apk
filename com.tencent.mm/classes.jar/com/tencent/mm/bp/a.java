package com.tencent.mm.bp;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Build.VERSION;
import android.support.v4.app.s.c;
import android.text.format.Time;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.compatible.util.d;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.bo;

public final class a
{
  private static String etE = "";
  
  public static String Mt()
  {
    AppMethodBeat.i(89331);
    if (bo.isNullOrNil(etE)) {
      etE = com.tencent.mm.kernel.a.Mu().getString("message_channel_id", "message_channel_new_id");
    }
    String str = etE;
    AppMethodBeat.o(89331);
    return str;
  }
  
  public static void akR(String paramString)
  {
    etE = paramString;
  }
  
  public static int bYt()
  {
    if (Build.VERSION.SDK_INT < 19) {
      return 2130839845;
    }
    return 2130839847;
  }
  
  public static s.c br(Context paramContext, String paramString)
  {
    AppMethodBeat.i(89332);
    paramContext = new s.c(paramContext, paramString);
    AppMethodBeat.o(89332);
    return paramContext;
  }
  
  public static String dkN()
  {
    AppMethodBeat.i(89333);
    if (d.fv(26))
    {
      localObject = new Time();
      ((Time)localObject).setToNow();
      int i = ((Time)localObject).hour;
      int j = ((Time)localObject).minute;
      ah.getContext();
      if (!com.tencent.mm.m.a.bX(i, j)) {
        ab.w("MicroMsg.NotificationHelper", "no shake & sound notification during background deactive time");
      }
      for (i = 1; i != 0; i = 0)
      {
        AppMethodBeat.o(89333);
        return "message_dnd_mode_channel_id";
      }
    }
    Object localObject = Mt();
    AppMethodBeat.o(89333);
    return localObject;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.bp.a
 * JD-Core Version:    0.7.0.1
 */