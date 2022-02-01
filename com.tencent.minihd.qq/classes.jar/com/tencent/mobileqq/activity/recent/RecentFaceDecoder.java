package com.tencent.mobileqq.activity.recent;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.LayerDrawable;
import android.util.Pair;
import com.tencent.device.DeviceHeadMgr;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.app.HotChatManager;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.util.FaceDecoder;
import com.tencent.mobileqq.util.FaceDecoder.DecodeTaskCompletionListener;
import com.tencent.mobileqq.utils.ImageUtil;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.theme.SkinnableBitmapDrawable;

public class RecentFaceDecoder
{
  private QQAppInterface jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
  private FaceDecoder.DecodeTaskCompletionListener jdField_a_of_type_ComTencentMobileqqUtilFaceDecoder$DecodeTaskCompletionListener;
  public FaceDecoder a;
  private boolean jdField_a_of_type_Boolean;
  
  public RecentFaceDecoder(QQAppInterface paramQQAppInterface)
  {
    this.jdField_a_of_type_Boolean = true;
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = paramQQAppInterface;
  }
  
  public RecentFaceDecoder(QQAppInterface paramQQAppInterface, FaceDecoder.DecodeTaskCompletionListener paramDecodeTaskCompletionListener)
  {
    this.jdField_a_of_type_ComTencentMobileqqUtilFaceDecoder = new FaceDecoder(BaseApplication.getContext(), paramQQAppInterface);
    this.jdField_a_of_type_ComTencentMobileqqUtilFaceDecoder.a(paramDecodeTaskCompletionListener);
    this.jdField_a_of_type_ComTencentMobileqqUtilFaceDecoder$DecodeTaskCompletionListener = paramDecodeTaskCompletionListener;
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = paramQQAppInterface;
  }
  
  public static Pair a(QQAppInterface paramQQAppInterface, int paramInt, String paramString)
  {
    int k = -2147483648;
    int m = 2130838442;
    int i = m;
    int j = k;
    switch (paramInt)
    {
    default: 
      i = -2147483648;
      j = k;
    }
    for (;;)
    {
      return Pair.create(Integer.valueOf(j), Integer.valueOf(i));
      i = m;
      j = k;
      if (!String.valueOf(AppConstants.ae).equals(paramString))
      {
        i = m;
        j = k;
        if (!String.valueOf(AppConstants.ag).equals(paramString)) {
          if (String.valueOf(AppConstants.V).equals(paramString))
          {
            i = 2130838444;
            j = k;
          }
          else if (AppConstants.ac.equals(paramString))
          {
            i = 2130838511;
            j = k;
          }
          else
          {
            j = 1;
            i = -2147483648;
            continue;
            if (String.valueOf(AppConstants.af).equals(paramString))
            {
              i = 2130838437;
              j = k;
            }
            else if (String.valueOf(AppConstants.au).equals(paramString))
            {
              i = 2130840223;
              j = k;
            }
            else
            {
              j = 32;
              i = -2147483648;
              continue;
              j = 102;
              i = 2130839616;
              continue;
              i = -2147483648;
              j = 104;
              continue;
              j = 11;
              i = -2147483648;
              continue;
              j = 101;
              i = -2147483648;
              continue;
              if (((HotChatManager)paramQQAppInterface.getManager(58)).d(paramString))
              {
                i = HotChatManager.a(paramString, paramQQAppInterface);
                j = k;
              }
              else if (HotChatManager.b(paramString))
              {
                i = 2130839232;
                j = k;
              }
              else
              {
                j = 4;
                i = -2147483648;
                continue;
                i = 2130838434;
                j = k;
                continue;
                i = 2130839803;
                j = k;
                continue;
                i = 2130838443;
                j = k;
                continue;
                if (AppConstants.W.equals(paramString))
                {
                  i = 2130838441;
                  j = k;
                }
                else
                {
                  j = 103;
                  i = -2147483648;
                  continue;
                  i = 2130838440;
                  j = k;
                  continue;
                  i = 2130838238;
                  j = 104;
                  continue;
                  i = 2130840890;
                  j = k;
                  continue;
                  i = 2130839271;
                  j = k;
                  continue;
                  i = 2130840695;
                  j = k;
                }
              }
            }
          }
        }
      }
    }
  }
  
  public Drawable a(int paramInt, String paramString)
  {
    return a(paramInt, paramString, true);
  }
  
  public Drawable a(int paramInt, String paramString, boolean paramBoolean)
  {
    Pair localPair = a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramInt, paramString);
    paramInt = ((Integer)localPair.first).intValue();
    int i = ((Integer)localPair.second).intValue();
    if (paramInt != -2147483648) {
      return a(paramString, paramInt);
    }
    if ((i != -2147483648) && (paramBoolean)) {
      return BaseApplication.getContext().getResources().getDrawable(i);
    }
    return null;
  }
  
  public Drawable a(String paramString, int paramInt)
  {
    if (paramInt == 104)
    {
      paramString = DeviceHeadMgr.a().a(paramString);
      return new BitmapDrawable(BaseApplication.getContext().getResources(), paramString);
    }
    if (this.jdField_a_of_type_Boolean)
    {
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(paramInt, paramString, false, 0);
      return null;
    }
    if (paramInt == 103) {}
    for (int i = 1;; i = paramInt)
    {
      Bitmap localBitmap;
      if (this.jdField_a_of_type_ComTencentMobileqqUtilFaceDecoder != null) {
        if (paramInt == 32) {
          localBitmap = this.jdField_a_of_type_ComTencentMobileqqUtilFaceDecoder.a(i, paramString, 3000);
        }
      }
      for (;;)
      {
        label85:
        if ((QLog.isDevelopLevel()) && (paramInt == 101)) {
          QLog.i("Q.recent", 4, "requestDecodeFace| [" + paramString + "," + paramInt + "," + localBitmap + "], isPausing=" + this.jdField_a_of_type_ComTencentMobileqqUtilFaceDecoder.a());
        }
        if (localBitmap == null)
        {
          if ((this.jdField_a_of_type_ComTencentMobileqqUtilFaceDecoder != null) && (!this.jdField_a_of_type_ComTencentMobileqqUtilFaceDecoder.a()))
          {
            if (i != 32) {
              break label284;
            }
            this.jdField_a_of_type_ComTencentMobileqqUtilFaceDecoder.a(paramString, 3000, true, false);
          }
          for (;;)
          {
            switch (paramInt)
            {
            default: 
              return null;
            case 1: 
              return ImageUtil.b();
              localBitmap = this.jdField_a_of_type_ComTencentMobileqqUtilFaceDecoder.a(i, paramString);
              break label85;
              label284:
              this.jdField_a_of_type_ComTencentMobileqqUtilFaceDecoder.a(paramString, i, true, (byte)2);
            }
          }
          return ImageUtil.c();
          return ImageUtil.d();
          return ImageUtil.b();
          return ImageUtil.e();
          return ImageUtil.f();
          return ImageUtil.b();
        }
        if (paramInt == 103)
        {
          paramString = BaseApplication.getContext().getResources().getDrawable(2130838432);
          if ((paramString instanceof SkinnableBitmapDrawable)) {
            ((SkinnableBitmapDrawable)paramString).setGravity(81);
          }
          if ((paramString instanceof BitmapDrawable)) {
            ((BitmapDrawable)paramString).setGravity(81);
          }
          paramString.setBounds(0, 0, paramString.getIntrinsicWidth(), paramString.getIntrinsicHeight());
          return new LayerDrawable(new Drawable[] { new BitmapDrawable(BaseApplication.getContext().getResources(), localBitmap), paramString });
        }
        return new BitmapDrawable(BaseApplication.getContext().getResources(), localBitmap);
        localBitmap = null;
      }
    }
  }
  
  public void a()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqUtilFaceDecoder != null)
    {
      this.jdField_a_of_type_ComTencentMobileqqUtilFaceDecoder.d();
      this.jdField_a_of_type_ComTencentMobileqqUtilFaceDecoder = null;
    }
    this.jdField_a_of_type_ComTencentMobileqqUtilFaceDecoder$DecodeTaskCompletionListener = null;
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = null;
  }
  
  public void a(QQAppInterface paramQQAppInterface)
  {
    if (this.jdField_a_of_type_ComTencentMobileqqUtilFaceDecoder != null)
    {
      this.jdField_a_of_type_ComTencentMobileqqUtilFaceDecoder.a(paramQQAppInterface);
      this.jdField_a_of_type_ComTencentMobileqqUtilFaceDecoder.a(this.jdField_a_of_type_ComTencentMobileqqUtilFaceDecoder$DecodeTaskCompletionListener);
    }
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = paramQQAppInterface;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\classes.jar
 * Qualified Name:     com.tencent.mobileqq.activity.recent.RecentFaceDecoder
 * JD-Core Version:    0.7.0.1
 */