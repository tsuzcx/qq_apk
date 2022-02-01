package com.tencent.mm.compatible.util;

import android.annotation.TargetApi;
import android.app.Activity;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.Rect;
import android.util.DisplayMetrics;
import android.view.View;
import android.view.Window;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ai;
import com.tencent.mm.sdk.platformtools.aw;
import com.tencent.mm.sdk.platformtools.y;

@Deprecated
public final class i
  extends y
{
  public static final void A(Context paramContext, int paramInt)
  {
    AppMethodBeat.i(155904);
    int j = y.aD(paramContext, 0);
    int i = y.ix(paramContext);
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
        aC(paramContext, paramInt);
        aw.aKT(ai.eUX()).putInt("com.tencent.mm.compatible.util.keybord.height", paramInt);
        AppMethodBeat.o(155904);
        return;
      }
    }
  }
  
  public static final int YL()
  {
    return Grf;
  }
  
  public static final int YM()
  {
    AppMethodBeat.i(155905);
    int i = aw.aKT(ai.eUX()).getInt("com.tencent.mm.compatible.util.keybord.height", 0);
    AppMethodBeat.o(155905);
    return i;
  }
  
  @TargetApi(11)
  public static final void v(Activity paramActivity)
  {
    AppMethodBeat.i(155903);
    if (paramActivity == null)
    {
      AppMethodBeat.o(155903);
      return;
    }
    Rect localRect = new Rect();
    paramActivity.getWindow().getDecorView().getWindowVisibleDisplayFrame(localRect);
    int i = localRect.top;
    int j = a.u(paramActivity);
    Grf = paramActivity.getResources().getDisplayMetrics().heightPixels - j - i;
    AppMethodBeat.o(155903);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.compatible.util.i
 * JD-Core Version:    0.7.0.1
 */