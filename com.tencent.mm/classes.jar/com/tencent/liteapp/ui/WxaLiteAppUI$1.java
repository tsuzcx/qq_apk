package com.tencent.liteapp.ui;

import android.widget.FrameLayout;
import com.tencent.liteapp.b.b;
import com.tencent.liteapp.d.b.c;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.wxa.d;
import java.util.HashMap;
import java.util.Map;

final class WxaLiteAppUI$1
  implements b.c
{
  private int crC = 0;
  private boolean crD = false;
  
  WxaLiteAppUI$1(WxaLiteAppUI paramWxaLiteAppUI) {}
  
  private static Map e(boolean paramBoolean, int paramInt)
  {
    AppMethodBeat.i(197752);
    HashMap localHashMap = new HashMap();
    localHashMap.put("shown", Boolean.valueOf(paramBoolean));
    localHashMap.put("height", Integer.valueOf(paramInt));
    AppMethodBeat.o(197752);
    return localHashMap;
  }
  
  public final void bQ(boolean paramBoolean)
  {
    AppMethodBeat.i(197751);
    this.crD = paramBoolean;
    b.i("WxaLiteApp.WxaLiteAppUI", "keyboardStateChange shown=%b h=%d", new Object[] { Boolean.valueOf(paramBoolean), Integer.valueOf(this.crC) });
    d.G("notifyKeyboardChanged", e(paramBoolean, this.crC));
    AppMethodBeat.o(197751);
  }
  
  public final int getHeight()
  {
    return this.crC;
  }
  
  public final void hF(int paramInt)
  {
    AppMethodBeat.i(197750);
    int[] arrayOfInt = new int[2];
    this.crE.mContentView.getLocationInWindow(arrayOfInt);
    this.crC = (arrayOfInt[1] + paramInt);
    b.i("WxaLiteApp.WxaLiteAppUI", "keyboardStateChange h=%d mSavedKeyboardHeight=%d", new Object[] { Integer.valueOf(paramInt), Integer.valueOf(this.crC) });
    if (this.crD == true) {
      d.G("notifyKeyboardChanged", e(true, this.crC));
    }
    AppMethodBeat.o(197750);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.liteapp.ui.WxaLiteAppUI.1
 * JD-Core Version:    0.7.0.1
 */