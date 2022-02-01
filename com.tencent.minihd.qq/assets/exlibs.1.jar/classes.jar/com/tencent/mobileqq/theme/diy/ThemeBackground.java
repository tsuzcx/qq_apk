package com.tencent.mobileqq.theme.diy;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.graphics.Bitmap.Config;
import android.graphics.BitmapFactory.Options;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.model.ChatBackgroundManager;
import com.tencent.mobileqq.theme.ThemeUtil;
import com.tencent.mobileqq.util.BitmapManager;

public class ThemeBackground
{
  public Drawable img;
  public boolean isNeedImg = true;
  public String path;
  
  public static void clear(Context paramContext, String paramString1, String paramString2)
  {
    if (paramString1 == null) {
      return;
    }
    paramContext = paramContext.getSharedPreferences("theme_background_path_" + paramString2, 0).edit();
    paramContext.putString(paramString1, "null");
    paramContext.commit();
  }
  
  public static boolean getIfAIOBgSetOnDIY(QQAppInterface paramQQAppInterface, Context paramContext, String paramString)
  {
    paramQQAppInterface = ((ChatBackgroundManager)paramQQAppInterface.getManager(61)).b(null);
    if ((paramQQAppInterface == null) || (paramQQAppInterface.trim().length() == 0) || (paramQQAppInterface.equals("null")) || (paramQQAppInterface.equals("none"))) {
      return false;
    }
    ThemeBackground localThemeBackground = new ThemeBackground();
    getThemeBackground(paramContext, "theme_bg_aio_path", paramString, localThemeBackground);
    return (!"null".equals(localThemeBackground.path)) && (paramQQAppInterface.equals(localThemeBackground.path));
  }
  
  public static boolean getThemeBackground(Context paramContext, String paramString1, String paramString2, ThemeBackground paramThemeBackground)
  {
    if (paramString1 == null) {}
    do
    {
      return false;
      paramString1 = paramContext.getSharedPreferences("theme_background_path_" + paramString2, 0).getString(paramString1, "null");
    } while (paramThemeBackground.path == paramString1);
    if (("".equals(paramString1)) || ("null".equals(paramString1)) || ("none".equals(paramString1))) {
      paramThemeBackground.path = "null";
    }
    for (;;)
    {
      return true;
      if (paramThemeBackground.isNeedImg)
      {
        paramString2 = new BitmapFactory.Options();
        paramString2.inPreferredConfig = Bitmap.Config.RGB_565;
        paramString2 = BitmapManager.a(paramString1, paramString2);
        if (paramString2 != null)
        {
          paramThemeBackground.path = paramString1;
          paramThemeBackground.img = new BitmapDrawable(paramContext.getResources(), paramString2);
        }
        else
        {
          paramThemeBackground.path = "null";
        }
      }
      else
      {
        paramThemeBackground.path = paramString1;
      }
    }
  }
  
  public static boolean getThemeBackgroundEnable()
  {
    return "999".equals(ThemeUtil.getCurrentThemeInfo().getString("themeId"));
  }
  
  public static int getThemeDIYRunTime(Context paramContext, String paramString)
  {
    return paramContext.getSharedPreferences("theme_background_path_" + paramString, 0).getInt("theme_diy_runed_times", 0);
  }
  
  public static void setThemeBackgroundPic(Context paramContext, String paramString1, String paramString2, String paramString3)
  {
    if (paramString1 == null) {
      return;
    }
    paramContext = paramContext.getSharedPreferences("theme_background_path_" + paramString2, 0).edit();
    paramContext.putString(paramString1, paramString3);
    paramContext.commit();
  }
  
  public static void setThemeDIYRunTime(Context paramContext, String paramString)
  {
    paramContext = paramContext.getSharedPreferences("theme_background_path_" + paramString, 0);
    int i = paramContext.getInt("theme_diy_runed_times", 0);
    paramContext = paramContext.edit();
    paramContext.putInt("theme_diy_runed_times", i + 1);
    paramContext.commit();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     com.tencent.mobileqq.theme.diy.ThemeBackground
 * JD-Core Version:    0.7.0.1
 */