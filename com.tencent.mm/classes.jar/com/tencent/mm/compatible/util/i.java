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
import com.tencent.mm.sdk.platformtools.aj;
import com.tencent.mm.sdk.platformtools.ax;
import com.tencent.mm.sdk.platformtools.z;

@Deprecated
public final class i
  extends z
{
  public static final void A(Context paramContext, int paramInt)
  {
    AppMethodBeat.i(155904);
    int j = z.aG(paramContext, 0);
    int i = z.iH(paramContext);
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
        aF(paramContext, paramInt);
        ax.aQz(aj.fkC()).putInt("com.tencent.mm.compatible.util.keybord.height", paramInt);
        AppMethodBeat.o(155904);
        return;
      }
    }
  }
  
  public static final int abn()
  {
    return IcT;
  }
  
  public static final int abo()
  {
    AppMethodBeat.i(155905);
    int i = ax.aQz(aj.fkC()).getInt("com.tencent.mm.compatible.util.keybord.height", 0);
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
    IcT = paramActivity.getResources().getDisplayMetrics().heightPixels - j - i;
    AppMethodBeat.o(155903);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.compatible.util.i
 * JD-Core Version:    0.7.0.1
 */