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
    AppMethodBeat.i(19392);
    if (paramString.endsWith(".jpg"))
    {
      paramString = paramString.substring(0, paramString.length() - 4);
      AppMethodBeat.o(19392);
      return paramString;
    }
    AppMethodBeat.o(19392);
    return paramString;
  }
  
  public static int getAnimId(Context paramContext, String paramString)
  {
    AppMethodBeat.i(19400);
    int i = getResId(paramContext, filter(paramString), "anim");
    AppMethodBeat.o(19400);
    return i;
  }
  
  public static int getColorId(Context paramContext, String paramString)
  {
    AppMethodBeat.i(19398);
    int i = getResId(paramContext, filter(paramString), "color");
    AppMethodBeat.o(19398);
    return i;
  }
  
  public static int getDimenId(Context paramContext, String paramString)
  {
    AppMethodBeat.i(19399);
    int i = getResId(paramContext, filter(paramString), "dimen");
    AppMethodBeat.o(19399);
    return i;
  }
  
  public static int getDrawableId(Context paramContext, String paramString)
  {
    AppMethodBeat.i(19395);
    int i = getResId(paramContext, filter(paramString), "drawable");
    AppMethodBeat.o(19395);
    return i;
  }
  
  public static int getId(Context paramContext, String paramString)
  {
    AppMethodBeat.i(19393);
    int i = getResId(paramContext, filter(paramString), "id");
    AppMethodBeat.o(19393);
    return i;
  }
  
  public static int getLayoutId(Context paramContext, String paramString)
  {
    AppMethodBeat.i(19396);
    int i = getResId(paramContext, paramString, "layout");
    AppMethodBeat.o(19396);
    return i;
  }
  
  public static int getMenuId(Context paramContext, String paramString)
  {
    AppMethodBeat.i(19401);
    int i = getResId(paramContext, filter(paramString), "menu");
    AppMethodBeat.o(19401);
    return i;
  }
  
  public static int getResId(Context paramContext, String paramString1, String paramString2)
  {
    AppMethodBeat.i(19402);
    int i = paramContext.getResources().getIdentifier(filter(paramString1), paramString2, paramContext.getPackageName());
    AppMethodBeat.o(19402);
    return i;
  }
  
  public static int getStringId(Context paramContext, String paramString)
  {
    AppMethodBeat.i(19394);
    int i = getResId(paramContext, filter(paramString), "string");
    AppMethodBeat.o(19394);
    return i;
  }
  
  public static int getStyleId(Context paramContext, String paramString)
  {
    AppMethodBeat.i(19397);
    int i = getResId(paramContext, filter(paramString), "style");
    AppMethodBeat.o(19397);
    return i;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.kinda.framework.widget.tools.ResourcesUtils
 * JD-Core Version:    0.7.0.1
 */