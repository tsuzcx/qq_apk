package com.tencent.mm.plugin.fav.ui;

import android.content.Context;
import android.content.res.Resources;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.bk;

public final class k
{
  public static String B(Context paramContext, int paramInt)
  {
    if (paramInt <= 0) {
      return paramContext.getString(n.i.favorite_voice_length, new Object[] { Integer.valueOf(0) });
    }
    int i = paramInt / 60;
    paramInt %= 60;
    if (i == 0) {
      return paramContext.getString(n.i.favorite_voice_length, new Object[] { Integer.valueOf(paramInt) });
    }
    return paramContext.getString(n.i.favorite_video_length, new Object[] { Integer.valueOf(i), Integer.valueOf(paramInt) });
  }
  
  public static String C(Context paramContext, int paramInt)
  {
    return "[" + paramContext.getResources().getString(paramInt) + "]";
  }
  
  public static boolean CZ(String paramString)
  {
    if (bk.bl(paramString)) {}
    while (paramString.equals(ae.getContext().getResources().getString(n.i.location_sub_title_location_with_bracket))) {
      return false;
    }
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.fav.ui.k
 * JD-Core Version:    0.7.0.1
 */