package com.tencent.mobileqq.activity.aio;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.graphics.BitmapFactory.Options;
import android.graphics.Color;
import android.graphics.Shader.TileMode;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.text.SpannableString;
import android.text.style.ImageSpan;
import com.tencent.mobileqq.drawable.ChatBackgroundDrawable;
import com.tencent.mobileqq.theme.diy.ThemeBackground;
import com.tencent.mobileqq.util.BitmapManager;
import com.tencent.qphone.base.util.QLog;
import com.tencent.theme.SkinnableBitmapDrawable;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ChatBackground
{
  public static final int a = -1;
  public static final int b = -10395552;
  public static final String b = "_is_c2c_set";
  public ColorStateList a;
  public Drawable a;
  public String a;
  
  public static int a(Bitmap paramBitmap)
  {
    int i = 0;
    if (paramBitmap != null)
    {
      int j = paramBitmap.getWidth();
      int n = paramBitmap.getHeight();
      int[] arrayOfInt = new int[n];
      paramBitmap.getPixels(arrayOfInt, 0, 1, j / 2, 0, 1, n);
      j = 0;
      int k = 0;
      int m = 0;
      while (i < n)
      {
        int i1 = arrayOfInt[i];
        m += Color.red(i1);
        k += Color.green(i1);
        j += Color.blue(i1);
        i += 1;
      }
      if ((j + (m + k)) / n / 3 > 220) {
        return -10395552;
      }
      return -1;
    }
    return -10395552;
  }
  
  public static CharSequence a(Context paramContext, String paramString, boolean paramBoolean)
  {
    String str = paramContext.getString(2131367772);
    if (a(paramContext, paramString, paramBoolean)) {
      return str;
    }
    paramString = new SpannableString(str + "         ");
    paramString.setSpan(new ImageSpan(paramContext, 2130840888, 1), paramString.length() - 1, paramString.length(), 33);
    return paramString;
  }
  
  private static void a(Context paramContext, ChatBackground paramChatBackground, String paramString)
  {
    for (;;)
    {
      try
      {
        paramString = Shader.TileMode.REPEAT;
        int i = 119;
        Drawable localDrawable = paramContext.getResources().getDrawable(2130837979);
        if ((localDrawable instanceof BitmapDrawable))
        {
          localBitmap = ((BitmapDrawable)localDrawable).getBitmap();
          paramString = ((BitmapDrawable)localDrawable).getTileModeX();
          i = ((BitmapDrawable)localDrawable).getGravity();
          if ((localBitmap == null) || (paramString == Shader.TileMode.REPEAT) || (i != 48)) {
            paramChatBackground.jdField_a_of_type_AndroidGraphicsDrawableDrawable = paramContext.getResources().getDrawable(2130837979);
          }
        }
        else
        {
          if (!(localDrawable instanceof SkinnableBitmapDrawable)) {
            break label175;
          }
          localBitmap = ((SkinnableBitmapDrawable)localDrawable).getBitmap();
          paramString = ((SkinnableBitmapDrawable)localDrawable).getTileModeX();
          i = ((SkinnableBitmapDrawable)localDrawable).getGravity();
          continue;
        }
        paramString = new ChatBackgroundDrawable(paramContext.getResources(), localBitmap);
        paramString.setGravity(i);
        paramChatBackground.jdField_a_of_type_AndroidGraphicsDrawableDrawable = paramString;
        return;
      }
      catch (Exception paramString)
      {
        if (QLog.isColorLevel()) {
          paramString.printStackTrace();
        }
        paramChatBackground.jdField_a_of_type_AndroidGraphicsDrawableDrawable = paramContext.getResources().getDrawable(2130841763);
        return;
      }
      label175:
      Bitmap localBitmap = null;
    }
  }
  
  public static final void a(Context paramContext, String paramString)
  {
    paramContext.getSharedPreferences("chat_background_path_" + paramString, 0).edit().clear().commit();
  }
  
  public static final void a(Context paramContext, String paramString1, String paramString2, String paramString3)
  {
    paramContext = paramContext.getSharedPreferences("chat_background_path_" + paramString1, 0).edit();
    if (paramString2 == null) {
      paramContext.putString("chat_uniform_bg", paramString3);
    }
    for (;;)
    {
      paramContext.commit();
      return;
      paramContext.putString(paramString2, paramString3);
    }
  }
  
  public static void a(Context paramContext, String paramString, boolean paramBoolean)
  {
    paramString = paramContext.getSharedPreferences("chat_background_path_" + paramString, 0);
    if (paramString != null) {
      if (!paramBoolean) {
        break label56;
      }
    }
    label56:
    for (paramContext = "chat_uniform_bg_click";; paramContext = "chat_aio_bg_click")
    {
      paramString.edit().putBoolean(paramContext, true).commit();
      return;
    }
  }
  
  public static boolean a(Context paramContext, String paramString1, String paramString2)
  {
    Object localObject = paramContext.getSharedPreferences("chat_background_path_" + paramString1, 0);
    if (localObject == null) {
      return false;
    }
    if (paramString2 != null)
    {
      localObject = ((SharedPreferences)localObject).getString(paramString2, null);
      paramString2 = (String)localObject;
      if (localObject == null) {
        return a(paramContext, paramString1, null);
      }
    }
    else
    {
      paramString2 = ((SharedPreferences)localObject).getString("chat_uniform_bg", "null");
    }
    if (!paramString2.equals("null")) {}
    for (boolean bool = true;; bool = false) {
      return bool;
    }
  }
  
  public static final boolean a(Context paramContext, String paramString1, String paramString2, boolean paramBoolean, ChatBackground paramChatBackground)
  {
    SharedPreferences localSharedPreferences = paramContext.getSharedPreferences("chat_background_path_" + paramString1, 0);
    String str2 = localSharedPreferences.getString(paramString2, null);
    String str1;
    if (str2 == null)
    {
      str1 = localSharedPreferences.getString("chat_uniform_bg", null);
      paramString2 = str1;
      if (str1 != null) {}
    }
    for (paramString2 = "null";; paramString2 = str2)
    {
      str1 = paramString2;
      if (ThemeBackground.getThemeBackgroundEnable())
      {
        str1 = paramString2;
        if (str2 == null) {
          str1 = paramContext.getSharedPreferences("theme_background_path_" + paramString1, 0).getString("theme_bg_aio_path", "null");
        }
      }
      if (paramChatBackground.jdField_a_of_type_JavaLangString != str1)
      {
        if (("".equals(str1)) || ("null".equals(str1)) || ("none".equals(str1)))
        {
          paramChatBackground.jdField_a_of_type_JavaLangString = "null";
          paramChatBackground.jdField_a_of_type_AndroidContentResColorStateList = paramContext.getResources().getColorStateList(2131427946);
          a(paramContext, paramChatBackground, str1);
        }
        for (;;)
        {
          return true;
          paramString1 = new BitmapFactory.Options();
          paramString1.inPreferredConfig = Bitmap.Config.RGB_565;
          paramString1 = BitmapManager.a(str1, paramString1, true);
          if (paramString1 != null)
          {
            paramChatBackground.jdField_a_of_type_JavaLangString = str1;
            paramChatBackground.jdField_a_of_type_AndroidGraphicsDrawableDrawable = new ChatBackgroundDrawable(paramContext.getResources(), paramString1);
            paramContext = "chat_backgournd_nickname_color." + str1;
            if (localSharedPreferences.contains(paramContext))
            {
              paramChatBackground.jdField_a_of_type_AndroidContentResColorStateList = ColorStateList.valueOf(localSharedPreferences.getInt(paramContext, -10395552));
            }
            else
            {
              int i = a(paramString1);
              paramChatBackground.jdField_a_of_type_AndroidContentResColorStateList = ColorStateList.valueOf(i);
              localSharedPreferences.edit().putInt(paramContext, i).commit();
            }
          }
          else
          {
            paramChatBackground.jdField_a_of_type_JavaLangString = "null";
            paramChatBackground.jdField_a_of_type_AndroidContentResColorStateList = paramContext.getResources().getColorStateList(2131427946);
            a(paramContext, paramChatBackground, str1);
          }
        }
      }
      return false;
    }
  }
  
  public static boolean a(Context paramContext, String paramString, boolean paramBoolean)
  {
    paramString = paramContext.getSharedPreferences("chat_background_path_" + paramString, 0);
    if (paramString == null) {
      return false;
    }
    if (paramBoolean) {}
    for (paramContext = "chat_uniform_bg_click";; paramContext = "chat_aio_bg_click") {
      return paramString.getBoolean(paramContext, false);
    }
  }
  
  public static final void b(Context paramContext, String paramString1, String paramString2, String paramString3)
  {
    paramContext = paramContext.getSharedPreferences("chat_background_path_" + paramString1, 0);
    paramString1 = paramContext.edit();
    if (paramString2 == null)
    {
      paramString1.putString("chat_uniform_bg", paramString3);
      paramString2 = paramContext.getAll();
      if (paramString2 != null)
      {
        paramString2 = paramString2.keySet().iterator();
        while (paramString2.hasNext())
        {
          String str1 = (String)paramString2.next();
          if (Pattern.compile("[0-9]*").matcher(str1).matches())
          {
            String str2 = paramContext.getString(str1, "null");
            boolean bool = paramContext.getBoolean(str1 + "_is_c2c_set", false);
            if ((str2 == null) || (str2.trim().length() == 0) || (str2.equals("null")) || (str2.equals("none")) || (!bool)) {
              paramString1.putString(str1, paramString3);
            }
          }
        }
      }
    }
    else
    {
      paramString1.putString(paramString2, paramString3);
      if (!paramString3.equals("null")) {
        break label254;
      }
      paramString1.putBoolean(paramString2 + "_is_c2c_set", false);
    }
    for (;;)
    {
      paramString1.commit();
      return;
      label254:
      paramString1.putBoolean(paramString2 + "_is_c2c_set", true);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.2.jar\classes.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.ChatBackground
 * JD-Core Version:    0.7.0.1
 */