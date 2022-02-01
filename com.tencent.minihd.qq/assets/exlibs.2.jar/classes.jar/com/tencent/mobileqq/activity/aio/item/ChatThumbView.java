package com.tencent.mobileqq.activity.aio.item;

import android.annotation.TargetApi;
import android.content.Context;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import com.tencent.image.URLDrawable;
import com.tencent.image.URLImageView;
import com.tencent.mobileqq.activity.aio.BaseBubbleBuilder;

public class ChatThumbView
  extends URLImageView
{
  private static final int a = 100;
  public boolean a;
  
  public ChatThumbView(Context paramContext)
  {
    super(paramContext);
  }
  
  @TargetApi(11)
  public void onLoadSuccessed(URLDrawable paramURLDrawable)
  {
    paramURLDrawable.setFadeInImage(false);
    if (this.a)
    {
      paramURLDrawable = new AlphaAnimation(0.0F, 1.0F);
      paramURLDrawable.setDuration(100L);
      startAnimation(paramURLDrawable);
      invalidate();
      return;
    }
    super.onLoadSuccessed(paramURLDrawable);
  }
  
  public void setAdjustViewBounds(boolean paramBoolean)
  {
    if (BaseBubbleBuilder.a) {
      return;
    }
    super.setAdjustViewBounds(paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.2.jar\classes.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.item.ChatThumbView
 * JD-Core Version:    0.7.0.1
 */