package com.tencent.mm.console.a;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Typeface;
import android.view.ViewGroup.LayoutParams;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R.e;
import com.tencent.mm.R.f;
import com.tencent.mm.pluginsdk.cmd.a;
import com.tencent.mm.pluginsdk.cmd.b;
import com.tencent.mm.pluginsdk.o.c.a;
import com.tencent.mm.pluginsdk.o.d;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.ui.base.k;

public final class m
  implements a
{
  static
  {
    AppMethodBeat.i(20194);
    b.a(new m(), new String[] { "//wear" });
    AppMethodBeat.o(20194);
  }
  
  public static void init() {}
  
  public final boolean a(Context paramContext, String[] paramArrayOfString, String paramString)
  {
    int i = 0;
    AppMethodBeat.i(20193);
    if (Log.getLogLevel() > 1)
    {
      AppMethodBeat.o(20193);
      return false;
    }
    if (paramArrayOfString.length < 2)
    {
      AppMethodBeat.o(20193);
      return true;
    }
    paramArrayOfString = paramArrayOfString[1];
    switch (paramArrayOfString.hashCode())
    {
    default: 
      i = -1;
      label83:
      switch (i)
      {
      }
      break;
    }
    for (;;)
    {
      AppMethodBeat.o(20193);
      return true;
      if (!paramArrayOfString.equals("log")) {
        break;
      }
      break label83;
      if (!paramArrayOfString.equals("version")) {
        break;
      }
      i = 1;
      break label83;
      if (!paramArrayOfString.equals("reconnect")) {
        break;
      }
      i = 2;
      break label83;
      o.d.XNU.inS();
      continue;
      paramArrayOfString = new TextView(paramContext);
      paramArrayOfString.setText(o.d.XNU.inR());
      paramArrayOfString.setGravity(19);
      paramArrayOfString.setTextSize(1, 10.0F);
      paramArrayOfString.setLayoutParams(new ViewGroup.LayoutParams(-1, -2));
      paramArrayOfString.setTextColor(paramContext.getResources().getColor(R.e.FG_0));
      paramArrayOfString.setTypeface(Typeface.MONOSPACE);
      i = paramContext.getResources().getDimensionPixelSize(R.f.LargePadding);
      paramArrayOfString.setPadding(i, i, i, i);
      k.a(paramContext, null, paramArrayOfString, null);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.console.a.m
 * JD-Core Version:    0.7.0.1
 */