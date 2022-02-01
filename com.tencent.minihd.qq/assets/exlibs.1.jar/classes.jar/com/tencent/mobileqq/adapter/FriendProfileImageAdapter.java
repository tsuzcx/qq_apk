package com.tencent.mobileqq.adapter;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.os.Handler;
import android.os.Handler.Callback;
import android.os.Looper;
import android.os.Message;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import com.tencent.image.URLDrawable;
import com.tencent.mobileqq.activity.FriendProfileImageModel;
import com.tencent.mobileqq.activity.FriendProfileImageModel.ProfileImageInfo;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.utils.CustomHandler;
import com.tencent.mobileqq.utils.ImageUtil;
import com.tencent.mobileqq.widget.ImageProgressCircle;
import com.tencent.qphone.base.util.QLog;
import java.net.MalformedURLException;
import java.net.URL;

public class FriendProfileImageAdapter
  extends BaseAdapter
  implements Handler.Callback
{
  private static final int jdField_b_of_type_Int = 1;
  int jdField_a_of_type_Int;
  Context jdField_a_of_type_AndroidContentContext;
  Drawable jdField_a_of_type_AndroidGraphicsDrawableDrawable;
  Handler jdField_a_of_type_AndroidOsHandler;
  FriendProfileImageModel jdField_a_of_type_ComTencentMobileqqActivityFriendProfileImageModel;
  boolean jdField_a_of_type_Boolean = false;
  Drawable jdField_b_of_type_AndroidGraphicsDrawableDrawable;
  
  public FriendProfileImageAdapter(Context paramContext)
  {
    this.jdField_a_of_type_AndroidContentContext = paramContext;
    this.jdField_a_of_type_Int = ((int)this.jdField_a_of_type_AndroidContentContext.getResources().getDimension(2131492955));
    this.jdField_a_of_type_AndroidGraphicsDrawableDrawable = paramContext.getResources().getDrawable(2130842124);
    this.b = paramContext.getResources().getDrawable(2130842125);
    this.jdField_a_of_type_AndroidOsHandler = new CustomHandler(Looper.getMainLooper(), this);
  }
  
  public void a()
  {
    this.jdField_a_of_type_AndroidOsHandler.removeMessages(1);
  }
  
  public void a(View paramView)
  {
    if (paramView == null) {}
    do
    {
      do
      {
        return;
        paramView = (ImageProgressCircle)paramView.findViewById(2131296299);
      } while (paramView == null);
      this.jdField_a_of_type_AndroidOsHandler.removeMessages(1, paramView);
    } while (paramView.getVisibility() == 4);
    paramView.setVisibility(4);
  }
  
  public void a(FriendProfileImageModel.ProfileImageInfo paramProfileImageInfo, View paramView)
  {
    if (paramView == null) {}
    do
    {
      return;
      a(paramView);
      paramView.setTag(paramProfileImageInfo.c);
      paramProfileImageInfo = (ImageView)paramView.findViewById(2131296300);
    } while (paramProfileImageInfo == null);
    paramProfileImageInfo.setImageDrawable(this.jdField_a_of_type_AndroidGraphicsDrawableDrawable);
  }
  
  public void a(FriendProfileImageModel paramFriendProfileImageModel)
  {
    this.jdField_a_of_type_ComTencentMobileqqActivityFriendProfileImageModel = paramFriendProfileImageModel;
  }
  
  public void a(ImageProgressCircle paramImageProgressCircle)
  {
    if (QLog.isColorLevel()) {
      QLog.i("Q.profilecard.PhotoWall", 2, "showProgress() progressCircle = " + paramImageProgressCircle);
    }
    if (paramImageProgressCircle == null) {}
    while (this.jdField_a_of_type_AndroidOsHandler.hasMessages(1, paramImageProgressCircle)) {
      return;
    }
    Message localMessage = Message.obtain();
    localMessage.what = 1;
    localMessage.obj = paramImageProgressCircle;
    this.jdField_a_of_type_AndroidOsHandler.sendMessageDelayed(localMessage, 550L);
  }
  
  public void a(boolean paramBoolean)
  {
    this.jdField_a_of_type_Boolean = paramBoolean;
  }
  
  public void b(FriendProfileImageModel.ProfileImageInfo paramProfileImageInfo, View paramView)
  {
    Object localObject1 = null;
    if (QLog.isColorLevel()) {
      QLog.i("Q.profilecard.PhotoWall", 2, "loadThumbImage() path = " + paramProfileImageInfo.c);
    }
    try
    {
      URL localURL = new URL("profile_img_thumb", null, paramProfileImageInfo.c);
      if (this.jdField_a_of_type_ComTencentMobileqqActivityFriendProfileImageModel != null) {
        localObject1 = this.jdField_a_of_type_ComTencentMobileqqActivityFriendProfileImageModel.a();
      }
      Object localObject2 = localObject1;
      if (localObject1 == null) {
        localObject2 = this.b;
      }
      localObject1 = URLDrawable.getDrawable(localURL, (Drawable)localObject2, this.jdField_a_of_type_AndroidGraphicsDrawableDrawable);
      paramView.setTag(paramProfileImageInfo.c);
      ((ImageView)paramView.findViewById(2131296300)).setImageDrawable((Drawable)localObject1);
      return;
    }
    catch (MalformedURLException paramProfileImageInfo)
    {
      while (!QLog.isColorLevel()) {}
      QLog.i("Q.profilecard.PhotoWall", 2, paramProfileImageInfo.toString());
    }
  }
  
  public void c(FriendProfileImageModel.ProfileImageInfo paramProfileImageInfo, View paramView)
  {
    int i = 1;
    if (QLog.isColorLevel()) {
      QLog.i("Q.profilecard.PhotoWall", 2, "loadBigImage() path = " + paramProfileImageInfo.d);
    }
    if (paramView == null) {
      return;
    }
    URL localURL;
    for (;;)
    {
      try
      {
        a(paramView);
        localObject1 = URLDrawable.getDrawable(new URL("profile_img_thumb", null, paramProfileImageInfo.c));
        localURL = new URL("profile_img_big", null, paramProfileImageInfo.d);
        if (((URLDrawable)localObject1).getStatus() == 1)
        {
          if (i == 0) {
            break label164;
          }
          localObject1 = URLDrawable.getDrawable(localURL, (Drawable)localObject1, this.jdField_a_of_type_AndroidGraphicsDrawableDrawable);
          paramView.setTag(paramProfileImageInfo.d);
          paramProfileImageInfo = (ImageView)paramView.findViewById(2131296300);
          if (paramProfileImageInfo == null) {
            break;
          }
          paramProfileImageInfo.setImageDrawable((Drawable)localObject1);
          return;
        }
      }
      catch (MalformedURLException paramProfileImageInfo)
      {
        if (QLog.isColorLevel()) {
          QLog.i("Q.profilecard.PhotoWall", 2, paramProfileImageInfo.toString());
        }
        paramView.setTag(null);
        return;
      }
      i = 0;
    }
    label164:
    if (this.jdField_a_of_type_ComTencentMobileqqActivityFriendProfileImageModel != null) {}
    for (Object localObject1 = this.jdField_a_of_type_ComTencentMobileqqActivityFriendProfileImageModel.a();; localObject1 = null)
    {
      Object localObject2 = localObject1;
      if (localObject1 == null) {
        localObject2 = this.b;
      }
      localObject1 = URLDrawable.getDrawable(localURL, (Drawable)localObject2, this.jdField_a_of_type_AndroidGraphicsDrawableDrawable);
      break;
    }
  }
  
  public int getCount()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqActivityFriendProfileImageModel != null) {
      return this.jdField_a_of_type_ComTencentMobileqqActivityFriendProfileImageModel.a();
    }
    return 0;
  }
  
  public Object getItem(int paramInt)
  {
    if (this.jdField_a_of_type_ComTencentMobileqqActivityFriendProfileImageModel != null) {
      return this.jdField_a_of_type_ComTencentMobileqqActivityFriendProfileImageModel.a(paramInt);
    }
    return null;
  }
  
  public long getItemId(int paramInt)
  {
    return paramInt;
  }
  
  public View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    Object localObject = paramView;
    ImageView localImageView;
    FriendProfileImageModel.ProfileImageInfo localProfileImageInfo;
    if (paramView == null)
    {
      paramViewGroup = LayoutInflater.from(paramViewGroup.getContext()).inflate(2130903347, null);
      paramView = (ImageProgressCircle)paramViewGroup.findViewById(2131296299);
      paramView.setVisibility(4);
      localImageView = (ImageView)paramViewGroup.findViewById(2131296300);
      localImageView.setMinimumWidth(this.jdField_a_of_type_Int);
      localImageView.setMinimumHeight(this.jdField_a_of_type_Int);
      localProfileImageInfo = (FriendProfileImageModel.ProfileImageInfo)getItem(paramInt);
      localObject = paramViewGroup;
      if (localProfileImageInfo != null)
      {
        if (!this.jdField_a_of_type_Boolean) {
          break label136;
        }
        localObject = this.jdField_a_of_type_ComTencentMobileqqActivityFriendProfileImageModel.a.a(this.jdField_a_of_type_ComTencentMobileqqActivityFriendProfileImageModel.b, (byte)1, false, false);
        paramView = (View)localObject;
        if (localObject == null) {
          paramView = ImageUtil.c();
        }
        localImageView.setImageDrawable(paramView);
        localObject = paramViewGroup;
      }
    }
    label136:
    do
    {
      do
      {
        return localObject;
        if (localProfileImageInfo.h != 6) {
          break;
        }
        c(localProfileImageInfo, paramViewGroup);
        localObject = paramViewGroup;
      } while (!QLog.isColorLevel());
      QLog.d("Q.profilecard.PhotoWall", 2, paramInt + "," + localProfileImageInfo.d);
      return paramViewGroup;
      if ((localProfileImageInfo.h != 3) && (localProfileImageInfo.h != 4)) {
        break;
      }
      b(localProfileImageInfo, paramViewGroup);
      if (QLog.isColorLevel()) {
        QLog.d("Q.profilecard.PhotoWall", 2, "thumb: " + paramInt + "," + localProfileImageInfo.c);
      }
      localObject = paramViewGroup;
    } while (!localProfileImageInfo.jdField_a_of_type_Boolean);
    a(paramView);
    return paramViewGroup;
    localImageView.setImageResource(2130842125);
    return paramViewGroup;
  }
  
  public boolean handleMessage(Message paramMessage)
  {
    if ((paramMessage.what == 1) && ((paramMessage.obj instanceof ImageProgressCircle)))
    {
      paramMessage = (ImageProgressCircle)paramMessage.obj;
      if (paramMessage.getVisibility() != 0) {
        paramMessage.setVisibility(0);
      }
    }
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     com.tencent.mobileqq.adapter.FriendProfileImageAdapter
 * JD-Core Version:    0.7.0.1
 */