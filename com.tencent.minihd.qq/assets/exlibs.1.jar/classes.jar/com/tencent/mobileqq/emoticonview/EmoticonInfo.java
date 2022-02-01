package com.tencent.mobileqq.emoticonview;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.widget.EditText;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.text.TextUtils;

public class EmoticonInfo
{
  public static final String c = "delete";
  public static final String d = "setting";
  public static final String e = "add";
  public static final String f = "push";
  public static final String g = "show_fav_menu";
  public static final String h = "donothing";
  EmoticonCallback a;
  public String a;
  public String b;
  public int c = -1;
  public int d;
  
  public Drawable a(Context paramContext, float paramFloat)
  {
    return TextUtils.a(paramContext.getResources(), this.d);
  }
  
  public void a(QQAppInterface paramQQAppInterface, Context paramContext, EditText paramEditText, SessionInfo paramSessionInfo) {}
  
  public void a(EmoticonCallback paramEmoticonCallback)
  {
    this.a = paramEmoticonCallback;
  }
  
  public Drawable b(Context paramContext, float paramFloat)
  {
    return a(paramContext, paramFloat);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     com.tencent.mobileqq.emoticonview.EmoticonInfo
 * JD-Core Version:    0.7.0.1
 */