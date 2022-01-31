package com.tencent.mm.console.a;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Typeface;
import android.view.ViewGroup.LayoutParams;
import android.widget.TextView;
import com.tencent.mm.R.f;
import com.tencent.mm.pluginsdk.cmd.a;
import com.tencent.mm.pluginsdk.cmd.b;
import com.tencent.mm.pluginsdk.o.d.a;
import com.tencent.mm.pluginsdk.o.f;
import com.tencent.mm.sdk.platformtools.y;
import com.tencent.mm.ui.base.h;

public final class l
  implements a
{
  static
  {
    b.a(new l(), new String[] { "//wear" });
  }
  
  public static void init() {}
  
  public final boolean a(Context paramContext, String[] paramArrayOfString)
  {
    int i = 0;
    if (y.getLogLevel() > 1) {
      return false;
    }
    if (paramArrayOfString.length < 2) {
      return true;
    }
    paramArrayOfString = paramArrayOfString[1];
    switch (paramArrayOfString.hashCode())
    {
    default: 
      i = -1;
      label62:
      switch (i)
      {
      }
      break;
    }
    for (;;)
    {
      return true;
      if (!paramArrayOfString.equals("log")) {
        break;
      }
      break label62;
      if (!paramArrayOfString.equals("version")) {
        break;
      }
      i = 1;
      break label62;
      if (!paramArrayOfString.equals("reconnect")) {
        break;
      }
      i = 2;
      break label62;
      o.f.rSG.bYO();
      continue;
      paramArrayOfString = new TextView(paramContext);
      paramArrayOfString.setText(o.f.rSG.bYN());
      paramArrayOfString.setGravity(19);
      paramArrayOfString.setTextSize(1, 10.0F);
      paramArrayOfString.setLayoutParams(new ViewGroup.LayoutParams(-1, -2));
      paramArrayOfString.setTextColor(-16711936);
      paramArrayOfString.setTypeface(Typeface.MONOSPACE);
      i = paramContext.getResources().getDimensionPixelSize(R.f.LargePadding);
      paramArrayOfString.setPadding(i, i, i, i);
      h.a(paramContext, null, paramArrayOfString, null);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.console.a.l
 * JD-Core Version:    0.7.0.1
 */