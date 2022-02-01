package com.tencent.mobileqq.emoticonview;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.text.Editable;
import android.widget.EditText;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.text.TextUtils;
import java.util.ArrayList;
import java.util.List;

public class SystemAndEmojiEmoticonInfo
  extends EmoticonInfo
{
  public static final int a = 1;
  public static final int b = 2;
  public static final int g = -1;
  public static final int h;
  public static final int i;
  public int e;
  public int f;
  
  static
  {
    int k = 0;
    int m = SystemEmoticonInfo.a.length / 20;
    if (SystemEmoticonInfo.a.length % 20 == 0)
    {
      j = 0;
      h = j + m;
      m = EmojiEmoticonInfo.b / 20;
      if (EmojiEmoticonInfo.b % 20 != 0) {
        break label58;
      }
    }
    label58:
    for (int j = k;; j = 1)
    {
      i = m + j;
      return;
      j = 1;
      break;
    }
  }
  
  public SystemAndEmojiEmoticonInfo(int paramInt1, int paramInt2, int paramInt3)
  {
    this.c = paramInt1;
    this.e = paramInt2;
    this.f = paramInt3;
  }
  
  public static List a()
  {
    ArrayList localArrayList = new ArrayList(SystemEmoticonInfo.a.length + EmojiEmoticonInfo.b);
    int k = EmojiEmoticonInfo.b % 20;
    int j = EmojiEmoticonInfo.b - 1;
    while (j >= EmojiEmoticonInfo.b - k)
    {
      localArrayList.add(new SystemAndEmojiEmoticonInfo(7, 2, j));
      j -= 1;
    }
    j = 0;
    while (j < 20 - k)
    {
      localArrayList.add(new SystemAndEmojiEmoticonInfo(7, 2, -1));
      j += 1;
    }
    j = EmojiEmoticonInfo.b - k - 1;
    while (j >= 0)
    {
      localArrayList.add(new SystemAndEmojiEmoticonInfo(7, 2, j));
      j -= 1;
    }
    k = SystemEmoticonInfo.a.length;
    j = 0;
    while (j < k)
    {
      localArrayList.add(new SystemAndEmojiEmoticonInfo(7, 1, SystemEmoticonInfo.a[j]));
      j += 1;
    }
    return localArrayList;
  }
  
  public Drawable a(Context paramContext, float paramFloat)
  {
    Object localObject = null;
    if (this.e == 1) {
      paramContext = TextUtils.a(this.f, false);
    }
    do
    {
      do
      {
        return paramContext;
        paramContext = localObject;
      } while (this.e != 2);
      paramContext = localObject;
    } while (this.f == -1);
    return TextUtils.a(this.f);
  }
  
  public void a(QQAppInterface paramQQAppInterface, Context paramContext, EditText paramEditText, SessionInfo paramSessionInfo)
  {
    if ((this.e == 2) && (this.f == -1)) {
      return;
    }
    int j = paramEditText.getSelectionStart();
    int k = paramEditText.getSelectionEnd();
    paramContext = paramEditText.getEditableText();
    if (this.e == 1) {}
    for (paramQQAppInterface = TextUtils.b(this.f);; paramQQAppInterface = TextUtils.a(this.f))
    {
      paramContext.replace(j, k, paramQQAppInterface);
      paramEditText.requestFocus();
      return;
    }
  }
  
  public Drawable b(Context paramContext, float paramFloat)
  {
    Object localObject2 = null;
    Object localObject1;
    if (this.e == 1) {
      localObject1 = TextUtils.a(this.f, true);
    }
    do
    {
      do
      {
        return localObject1;
        localObject1 = localObject2;
      } while (this.e != 2);
      localObject1 = localObject2;
    } while (this.f == -1);
    return super.b(paramContext, paramFloat);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     com.tencent.mobileqq.emoticonview.SystemAndEmojiEmoticonInfo
 * JD-Core Version:    0.7.0.1
 */