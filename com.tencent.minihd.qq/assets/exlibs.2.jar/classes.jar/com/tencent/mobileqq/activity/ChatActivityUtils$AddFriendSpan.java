package com.tencent.mobileqq.activity;

import android.text.TextPaint;
import android.text.style.URLSpan;
import android.view.View;
import com.tencent.mobileqq.activity.aio.rebuild.StrangerChatPie;

class ChatActivityUtils$AddFriendSpan
  extends URLSpan
{
  int a = -16776961;
  
  public ChatActivityUtils$AddFriendSpan(String paramString, int paramInt)
  {
    super(paramString);
    this.a = paramInt;
  }
  
  public void onClick(View paramView)
  {
    paramView = paramView.getContext();
    if ((paramView instanceof ChatActivity))
    {
      paramView = (ChatActivity)paramView;
      if ((paramView.a() instanceof StrangerChatPie)) {
        ((StrangerChatPie)paramView.a()).ad();
      }
    }
  }
  
  public void updateDrawState(TextPaint paramTextPaint)
  {
    paramTextPaint.setColor(this.a);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.2.jar\classes.jar
 * Qualified Name:     com.tencent.mobileqq.activity.ChatActivityUtils.AddFriendSpan
 * JD-Core Version:    0.7.0.1
 */