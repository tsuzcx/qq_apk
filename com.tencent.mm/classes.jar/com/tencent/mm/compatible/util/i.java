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
import com.tencent.mm.sdk.platformtools.KeyBoardUtil;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.MultiProcessMMKV;

@Deprecated
public final class i
  extends KeyBoardUtil
{
  public static final void E(Context paramContext, int paramInt)
  {
    AppMethodBeat.i(155904);
    int j = KeyBoardUtil.getMinPanelHeightPx(paramContext);
    int i = KeyBoardUtil.getMaxPanelHeightPx(paramContext);
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
        saveKeyBordHeightPx(paramContext, paramInt);
        MultiProcessMMKV.getMMKV(MMApplicationContext.getDefaultPreferencePath()).putInt("com.tencent.mm.compatible.util.keybord.height", paramInt);
        AppMethodBeat.o(155904);
        return;
      }
    }
  }
  
  public static final int avL()
  {
    return CONTENT_HEIGHT;
  }
  
  public static final int avM()
  {
    AppMethodBeat.i(155905);
    int i = MultiProcessMMKV.getMMKV(MMApplicationContext.getDefaultPreferencePath()).getInt("com.tencent.mm.compatible.util.keybord.height", 0);
    AppMethodBeat.o(155905);
    return i;
  }
  
  @TargetApi(11)
  public static final void u(Activity paramActivity)
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
    int j = a.t(paramActivity);
    CONTENT_HEIGHT = paramActivity.getResources().getDisplayMetrics().heightPixels - j - i;
    AppMethodBeat.o(155903);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.compatible.util.i
 * JD-Core Version:    0.7.0.1
 */