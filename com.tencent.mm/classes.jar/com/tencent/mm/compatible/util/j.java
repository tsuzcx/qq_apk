package com.tencent.mm.compatible.util;

import android.annotation.TargetApi;
import android.app.Activity;
import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.content.res.Resources;
import android.graphics.Rect;
import android.util.DisplayMetrics;
import android.view.View;
import android.view.Window;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.as;
import com.tencent.mm.sdk.platformtools.x;

@Deprecated
public final class j
  extends x
{
  public static final int Mq()
  {
    return ync;
  }
  
  public static final int Mr()
  {
    AppMethodBeat.i(93100);
    int i = as.apq(ah.dsP()).getInt("com.tencent.mm.compatible.util.keybord.height", 0);
    AppMethodBeat.o(93100);
    return i;
  }
  
  @TargetApi(11)
  public static final void q(Activity paramActivity)
  {
    AppMethodBeat.i(93098);
    if (paramActivity == null)
    {
      AppMethodBeat.o(93098);
      return;
    }
    Rect localRect = new Rect();
    paramActivity.getWindow().getDecorView().getWindowVisibleDisplayFrame(localRect);
    int i = localRect.top;
    int j = a.p(paramActivity);
    ync = paramActivity.getResources().getDisplayMetrics().heightPixels - j - i;
    AppMethodBeat.o(93098);
  }
  
  public static final void z(Context paramContext, int paramInt)
  {
    AppMethodBeat.i(93099);
    int j = x.av(paramContext, 0);
    int i = x.gK(paramContext);
    if (paramInt < j) {
      paramInt = j;
    }
    for (;;)
    {
      if (paramInt > i) {
        paramInt = i;
      }
      for (;;)
      {
        if ((x.ynb != paramInt) && (x.gM(paramContext)) && (paramInt >= 0))
        {
          x.ynb = paramInt;
          ab.d("MicroMsg.KeyBordUtil", "save keybord: %d", new Object[] { Integer.valueOf(paramInt) });
          ah.dsQ().edit().putInt("com.tencent.mm.compatible.util.keybord.height", paramInt).commit();
        }
        as.apq(ah.dsP()).putInt("com.tencent.mm.compatible.util.keybord.height", paramInt);
        AppMethodBeat.o(93099);
        return;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.compatible.util.j
 * JD-Core Version:    0.7.0.1
 */