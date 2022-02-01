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

public class EmojiEmoticonInfo
  extends EmoticonInfo
{
  public static int b = 165;
  public int a;
  
  public static List a()
  {
    ArrayList localArrayList = new ArrayList();
    int i = 0;
    while (i < b)
    {
      EmojiEmoticonInfo localEmojiEmoticonInfo = new EmojiEmoticonInfo();
      localEmojiEmoticonInfo.c = 2;
      localEmojiEmoticonInfo.a = i;
      localArrayList.add(localEmojiEmoticonInfo);
      i += 1;
    }
    return localArrayList;
  }
  
  public Drawable a(Context paramContext, float paramFloat)
  {
    return TextUtils.a(this.a);
  }
  
  public void a(QQAppInterface paramQQAppInterface, Context paramContext, EditText paramEditText, SessionInfo paramSessionInfo)
  {
    int i = paramEditText.getSelectionStart();
    int j = paramEditText.getSelectionEnd();
    paramEditText.getEditableText().replace(i, j, TextUtils.a(this.a));
    paramEditText.requestFocus();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     com.tencent.mobileqq.emoticonview.EmojiEmoticonInfo
 * JD-Core Version:    0.7.0.1
 */