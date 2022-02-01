package com.tencent.kinda.framework.widget.tools;

import android.content.Context;
import android.graphics.Typeface;
import android.text.TextPaint;
import android.text.style.MetricAffectingSpan;
import com.tencent.kinda.gen.FontStyle;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.ui.aw;
import com.tencent.mm.wallet_core.ui.i;

public class KindaFontUtil
{
  private static final String TAG = "KindaFontUtil";
  private static Typeface[] typefaces;
  
  public static Typeface getTypeface(String paramString)
  {
    AppMethodBeat.i(226447);
    if ((typefaces == null) || (typefaces.length == 0)) {
      typefaces = new Typeface[9];
    }
    int i;
    if (paramString.equalsIgnoreCase("WeChat-Sans-SS-Light")) {
      i = 2;
    }
    while (i >= 9)
    {
      AppMethodBeat.o(226447);
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
        AppMethodBeat.o(226447);
        return null;
      }
    }
    if (typefaces[i] == null)
    {
      paramString = i.aGy(i);
      try
      {
        typefaces[i] = Typeface.createFromAsset(MMApplicationContext.getContext().getAssets(), paramString);
        paramString = typefaces[i];
        AppMethodBeat.o(226447);
        return paramString;
      }
      catch (Exception paramString)
      {
        Log.e("KindaFontUtil", "setTypeface() Exception:%s %s", new Object[] { paramString.getClass().getSimpleName(), paramString.getMessage() });
        AppMethodBeat.o(226447);
        return null;
      }
    }
    paramString = typefaces[i];
    AppMethodBeat.o(226447);
    return paramString;
  }
  
  public static class KindaTypefaceSpan
    extends MetricAffectingSpan
  {
    private String fontName;
    private FontStyle fontStyle;
    
    public KindaTypefaceSpan(String paramString, FontStyle paramFontStyle)
    {
      AppMethodBeat.i(226453);
      if (paramString == null) {}
      for (this.fontName = "";; this.fontName = paramString)
      {
        this.fontStyle = paramFontStyle;
        AppMethodBeat.o(226453);
        return;
      }
    }
    
    private void updateKindaFont(TextPaint paramTextPaint)
    {
      int j = 0;
      AppMethodBeat.i(226454);
      Typeface localTypeface = KindaFontUtil.getTypeface(this.fontName);
      if (localTypeface != null)
      {
        paramTextPaint.setTypeface(localTypeface);
        AppMethodBeat.o(226454);
        return;
      }
      if (this.fontStyle == FontStyle.MEDIUM)
      {
        aw.a(paramTextPaint, 0.8F);
        AppMethodBeat.o(226454);
        return;
      }
      int i;
      if (this.fontStyle == FontStyle.BOLD)
      {
        i = 1;
        localTypeface = paramTextPaint.getTypeface();
        if (localTypeface != null) {
          break label145;
        }
        label79:
        i = j | i;
        if (localTypeface != null) {
          break label154;
        }
      }
      label145:
      label154:
      for (localTypeface = Typeface.defaultFromStyle(i);; localTypeface = Typeface.create(localTypeface, i))
      {
        i &= (localTypeface.getStyle() ^ 0xFFFFFFFF);
        if ((i & 0x1) != 0) {
          paramTextPaint.setFakeBoldText(true);
        }
        if ((i & 0x2) != 0) {
          paramTextPaint.setTextSkewX(-0.25F);
        }
        paramTextPaint.setTypeface(localTypeface);
        AppMethodBeat.o(226454);
        return;
        i = 0;
        break;
        j = localTypeface.getStyle();
        break label79;
      }
    }
    
    public void updateDrawState(TextPaint paramTextPaint)
    {
      AppMethodBeat.i(226457);
      updateKindaFont(paramTextPaint);
      AppMethodBeat.o(226457);
    }
    
    public void updateMeasureState(TextPaint paramTextPaint)
    {
      AppMethodBeat.i(226456);
      updateKindaFont(paramTextPaint);
      AppMethodBeat.o(226456);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.kinda.framework.widget.tools.KindaFontUtil
 * JD-Core Version:    0.7.0.1
 */