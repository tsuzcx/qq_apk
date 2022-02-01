package com.tencent.mobileqq.activity.aio;

import android.view.View;
import android.view.ViewGroup;
import com.tencent.mobileqq.data.ChatMessage;

public abstract interface ChatItemBuilder
  extends ContextMenuBuilder
{
  public static final String a = ChatItemBuilder.class.getSimpleName();
  public static final boolean b = true;
  public static final boolean c = true;
  
  public abstract View a(int paramInt1, int paramInt2, ChatMessage paramChatMessage, View paramView, ViewGroup paramViewGroup, OnLongClickAndTouchListener paramOnLongClickAndTouchListener);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.2.jar\classes.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.ChatItemBuilder
 * JD-Core Version:    0.7.0.1
 */