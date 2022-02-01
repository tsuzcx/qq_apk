package com.tencent.kinda.framework.widget.tools;

import android.content.Context;
import android.graphics.Typeface;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.wallet_core.ui.g;

public class KindaFontUtil
{
  private static final String TAG = "KindaFontUtil";
  private static Typeface[] typefaces;
  
  public static Typeface getTypeface(String paramString)
  {
    AppMethodBeat.i(264310);
    if ((typefaces == null) || (typefaces.length == 0)) {
      typefaces = new Typeface[9];
    }
    int i;
    if (paramString.equalsIgnoreCase("WeChat-Sans-SS-Light")) {
      i = 2;
    }
    while (i >= 9)
    {
      AppMethodBeat.o(264310);
      return null;
      if (paramString.equalsIgnoreCase("WeChat-Sans-SS-Medium"))
      {
        i = 0;
      }
      else if (paramString.equalsIgnoreCase("WeChat-Sans-SS-Regular"))
      {
        i = 3;
      }
      else if (paramString.equalsIgnoreCase("WeChat-Sans-SS-Bold"))
      {
        i = 1;
      }
      else if (paramString.equalsIgnoreCase("WeChat-Sans-Std-Medium"))
      {
        i = 4;
      }
      else if (paramString.equalsIgnoreCase("WeChat-Sans-Std-Light"))
      {
        i = 6;
      }
      else if (paramString.equalsIgnoreCase("WeChat-Sans-Std-Bold"))
      {
        i = 5;
      }
      else if (paramString.equalsIgnoreCase("WeChat-Sans-Std-Regular"))
      {
        i = 7;
      }
      else
      {
        AppMethodBeat.o(264310);
        return null;
      }
    }
    if (typefaces[i] == null)
    {
      paramString = g.azI(i);
      try
      {
        typefaces[i] = Typeface.createFromAsset(MMApplicationContext.getContext().getAssets(), paramString);
        paramString = typefaces[i];
        AppMethodBeat.o(264310);
        return paramString;
      }
      catch (Exception paramString)
      {
        Log.e("KindaFontUtil", "setTypeface() Exception:%s %s", new Object[] { paramString.getClass().getSimpleName(), paramString.getMessage() });
        AppMethodBeat.o(264310);
        return null;
      }
    }
    paramString = typefaces[i];
    AppMethodBeat.o(264310);
    return paramString;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.kinda.framework.widget.tools.KindaFontUtil
 * JD-Core Version:    0.7.0.1
 */