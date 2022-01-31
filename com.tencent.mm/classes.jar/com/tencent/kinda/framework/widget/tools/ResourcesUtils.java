package com.tencent.kinda.framework.widget.tools;

import android.content.Context;
import android.content.res.Resources;
import com.tencent.matrix.trace.core.AppMethodBeat;

public class ResourcesUtils
{
  public static final String JPG = ".jpg";
  private static final String RES_ANIM = "anim";
  private static final String RES_COLOR = "color";
  private static final String RES_DIMEN = "dimen";
  private static final String RES_DRABLE = "drawable";
  private static final String RES_ID = "id";
  private static final String RES_LAYOUT = "layout";
  private static final String RES_MENU = "menu";
  private static final String RES_STRING = "string";
  private static final String RES_STYLE = "style";
  
  private static String filter(String paramString)
  {
    AppMethodBeat.i(145212);
    if (paramString.endsWith(".jpg"))
    {
      paramString = paramString.substring(0, paramString.length() - 4);
      AppMethodBeat.o(145212);
      return paramString;
    }
    AppMethodBeat.o(145212);
    return paramString;
  }
  
  public static int getAnimId(Context paramContext, String paramString)
  {
    AppMethodBeat.i(145220);
    int i = getResId(paramContext, filter(paramString), "anim");
    AppMethodBeat.o(145220);
    return i;
  }
  
  public static int getColorId(Context paramContext, String paramString)
  {
    AppMethodBeat.i(145218);
    int i = getResId(paramContext, filter(paramString), "color");
    AppMethodBeat.o(145218);
    return i;
  }
  
  public static int getDimenId(Context paramContext, String paramString)
  {
    AppMethodBeat.i(145219);
    int i = getResId(paramContext, filter(paramString), "dimen");
    AppMethodBeat.o(145219);
    return i;
  }
  
  public static int getDrawableId(Context paramContext, String paramString)
  {
    AppMethodBeat.i(145215);
    int i = getResId(paramContext, filter(paramString), "drawable");
    AppMethodBeat.o(145215);
    return i;
  }
  
  public static int getId(Context paramContext, String paramString)
  {
    AppMethodBeat.i(145213);
    int i = getResId(paramContext, filter(paramString), "id");
    AppMethodBeat.o(145213);
    return i;
  }
  
  public static int getLayoutId(Context paramContext, String paramString)
  {
    AppMethodBeat.i(145216);
    int i = getResId(paramContext, paramString, "layout");
    AppMethodBeat.o(145216);
    return i;
  }
  
  public static int getMenuId(Context paramContext, String paramString)
  {
    AppMethodBeat.i(145221);
    int i = getResId(paramContext, filter(paramString), "menu");
    AppMethodBeat.o(145221);
    return i;
  }
  
  public static int getResId(Context paramContext, String paramString1, String paramString2)
  {
    AppMethodBeat.i(145222);
    int i = paramContext.getResources().getIdentifier(filter(paramString1), paramString2, paramContext.getPackageName());
    AppMethodBeat.o(145222);
    return i;
  }
  
  public static int getStringId(Context paramContext, String paramString)
  {
    AppMethodBeat.i(145214);
    int i = getResId(paramContext, filter(paramString), "string");
    AppMethodBeat.o(145214);
    return i;
  }
  
  public static int getStyleId(Context paramContext, String paramString)
  {
    AppMethodBeat.i(145217);
    int i = getResId(paramContext, filter(paramString), "style");
    AppMethodBeat.o(145217);
    return i;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.kinda.framework.widget.tools.ResourcesUtils
 * JD-Core Version:    0.7.0.1
 */