package com.tencent.mobileqq.activity.aio;

import android.content.Context;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.image.URLDrawable;
import com.tencent.image.URLImageView;
import com.tencent.mobileqq.activity.aio.item.PicItemBuilder;
import com.tencent.mobileqq.data.MessageForPic;
import com.tencent.mobileqq.utils.FileUtils;

public class MixedImageOnclickListener
  implements View.OnClickListener
{
  private long a;
  public Context a;
  public SessionInfo a;
  
  public MixedImageOnclickListener()
  {
    this.jdField_a_of_type_Long = 0L;
  }
  
  public void onClick(View paramView)
  {
    long l = System.currentTimeMillis();
    if (l - this.jdField_a_of_type_Long < 1000L) {}
    URLImageView localURLImageView;
    MessageForPic localMessageForPic;
    URLDrawable localURLDrawable;
    do
    {
      do
      {
        return;
        this.jdField_a_of_type_Long = l;
        localURLImageView = (URLImageView)paramView;
        localMessageForPic = (MessageForPic)localURLImageView.getTag(2131296335);
        localURLDrawable = (URLDrawable)localURLImageView.getDrawable();
        switch (localURLDrawable.getStatus())
        {
        default: 
          return;
        }
      } while (localURLDrawable.isDownloadStarted());
      localURLDrawable.startDownload();
      return;
    } while (!FileUtils.a(paramView.getContext()));
    localURLDrawable.restartDownload();
    return;
    PicItemBuilder.a(this.jdField_a_of_type_AndroidContentContext, localURLImageView, localMessageForPic, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.2.jar\classes.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.MixedImageOnclickListener
 * JD-Core Version:    0.7.0.1
 */