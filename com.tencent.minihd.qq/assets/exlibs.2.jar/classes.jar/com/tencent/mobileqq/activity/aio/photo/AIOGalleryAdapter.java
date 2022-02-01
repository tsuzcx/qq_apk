package com.tencent.mobileqq.activity.aio.photo;

import android.content.Context;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.media.ExifInterface;
import android.support.v4.util.MQLruCache;
import android.util.SparseArray;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.common.galleryactivity.AbstractImageAdapter;
import com.tencent.common.galleryactivity.AbstractImageAdapter.URLImageView2;
import com.tencent.common.galleryactivity.AbstractImageListModel;
import com.tencent.image.RegionDrawableData;
import com.tencent.image.URLDrawable;
import com.tencent.image.URLDrawable.URLDrawableOptions;
import com.tencent.image.URLImageView;
import com.tencent.mobileqq.activity.photo.ProGallery.OnProGalleryListener;
import com.tencent.mobileqq.richmedia.dc.DCAIOPreview;
import com.tencent.mobileqq.richmedia.dc.DCAIOPreviewProgressive;
import com.tencent.mobileqq.transfile.URLDrawableHelper;
import com.tencent.mobileqq.util.SizeMeasure;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;

public class AIOGalleryAdapter
  extends AbstractImageAdapter
  implements ProGallery.OnProGalleryListener
{
  static final String jdField_a_of_type_JavaLangString = "AIOGalleryAdapter";
  private static final String jdField_b_of_type_JavaLangString = "NOSAMPLE";
  private static final String jdField_c_of_type_JavaLangString = "DISPLAY";
  private static final String d = "PART";
  private int jdField_a_of_type_Int = -1;
  private SparseArray jdField_a_of_type_AndroidUtilSparseArray = new SparseArray();
  private URLDrawable jdField_a_of_type_ComTencentImageURLDrawable;
  AIOGalleryActivity jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIOGalleryActivity;
  private AIOGalleryAdapter.GalleryURLImageView jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIOGalleryAdapter$GalleryURLImageView;
  IAIOImageProvider jdField_a_of_type_ComTencentMobileqqActivityAioPhotoIAIOImageProvider;
  private ArrayList jdField_a_of_type_JavaUtilArrayList = new ArrayList();
  private int jdField_b_of_type_Int;
  private int jdField_c_of_type_Int;
  
  public AIOGalleryAdapter(Context paramContext, IAIOImageProvider paramIAIOImageProvider)
  {
    this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIOGalleryActivity = ((AIOGalleryActivity)paramContext);
    this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoIAIOImageProvider = paramIAIOImageProvider;
    this.b = SizeMeasure.h(paramContext);
    this.c = SizeMeasure.i(paramContext);
  }
  
  private String a()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("Actives: ");
    int i = 0;
    while (i < this.jdField_a_of_type_AndroidUtilSparseArray.size())
    {
      if (i > 0) {
        localStringBuilder.append(" , ");
      }
      localStringBuilder.append(this.jdField_a_of_type_AndroidUtilSparseArray.keyAt(i) + 1);
      i += 1;
    }
    return localStringBuilder.toString();
  }
  
  private void a()
  {
    this.jdField_a_of_type_AndroidUtilSparseArray.clear();
    if ((this.jdField_a_of_type_ComTencentImageURLDrawable != null) && (this.jdField_a_of_type_ComTencentImageURLDrawable.getStatus() == 0)) {
      this.jdField_a_of_type_ComTencentImageURLDrawable.cancelDownload(true);
    }
    this.jdField_a_of_type_ComTencentImageURLDrawable = null;
    this.jdField_a_of_type_Int = -1;
  }
  
  public View a(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    paramView = (URLDrawable)this.jdField_a_of_type_AndroidUtilSparseArray.get(paramInt);
    if (paramView != null) {
      if (paramView.getStatus() == 3) {
        paramView.restartDownload();
      }
    }
    do
    {
      return null;
      paramView = (AIOImageInfo)a(paramInt);
    } while (paramView == null);
    AIOImageData localAIOImageData = paramView.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIOImageData;
    paramViewGroup = localAIOImageData.a(4);
    if (paramViewGroup == null)
    {
      paramView = localAIOImageData.a(2);
      if (paramView == null) {}
    }
    for (;;)
    {
      int i;
      if (paramViewGroup != null)
      {
        i = 1;
        paramViewGroup = URLDrawable.URLDrawableOptions.obtain();
        paramViewGroup.mLoadingDrawable = URLDrawableHelper.d;
        paramViewGroup.mFailedDrawable = URLDrawableHelper.d;
        paramViewGroup.mPlayGifImage = true;
        paramViewGroup.mUseExifOrientation = false;
        if ((i != 0) || (!localAIOImageData.jdField_d_of_type_Boolean)) {
          break label182;
        }
      }
      label182:
      for (paramView = URLDrawable.getDrawable(localAIOImageData.a(2) + "#" + "PART", paramViewGroup);; paramView = URLDrawable.getDrawable(paramView, paramViewGroup))
      {
        paramView.setTag(Integer.valueOf(1));
        paramView.startDownload();
        this.jdField_a_of_type_AndroidUtilSparseArray.put(paramInt, paramView);
        return null;
        i = 0;
        break;
      }
      if ((localAIOImageData.c) || (localAIOImageData.b) || (localAIOImageData.jdField_a_of_type_Boolean)) {
        break;
      }
      if (localAIOImageData.a(1) != null)
      {
        paramView = URLDrawable.URLDrawableOptions.obtain();
        paramView.mLoadingDrawable = URLDrawableHelper.d;
        paramView.mFailedDrawable = URLDrawableHelper.d;
        URLDrawable.getDrawable(localAIOImageData.a(1), paramView).startDownload();
        if (!NetworkUtil.g(this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIOGalleryActivity)) {
          break;
        }
        this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoIAIOImageProvider.a(localAIOImageData.jdField_a_of_type_Long, localAIOImageData.jdField_e_of_type_Int, 2);
        return null;
      }
      if (!NetworkUtil.g(this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIOGalleryActivity)) {
        break;
      }
      this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoIAIOImageProvider.a(localAIOImageData.jdField_a_of_type_Long, localAIOImageData.jdField_e_of_type_Int, 2);
      if (!QLog.isDevelopLevel()) {
        break;
      }
      QLog.d("AIOGalleryAdapter", 4, "onCreateView():Thumb and large pic is not exist, download it. Gallery position is " + paramInt);
      return null;
      paramView = paramViewGroup;
    }
  }
  
  public void a(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    if (QLog.isColorLevel()) {
      QLog.i("AIOGalleryAdapter", 2, "AIOGalleryAdapter.onSlot(): position is " + paramInt);
    }
    System.gc();
  }
  
  public void a(int paramInt, View paramView, ViewGroup paramViewGroup, boolean paramBoolean)
  {
    if (paramInt == this.jdField_a_of_type_Int)
    {
      if ((this.jdField_a_of_type_ComTencentImageURLDrawable != null) && (this.jdField_a_of_type_ComTencentImageURLDrawable.getStatus() == 0)) {
        this.jdField_a_of_type_ComTencentImageURLDrawable.cancelDownload(true);
      }
      this.jdField_a_of_type_ComTencentImageURLDrawable = null;
      this.jdField_a_of_type_Int = -1;
      if (QLog.isColorLevel()) {
        QLog.d("AIOGalleryAdapter", 2, "destory rawDrawable, position: " + paramInt);
      }
    }
    if (URLImageView.class.isInstance(paramView))
    {
      paramViewGroup = (AIOImageInfo)a(paramInt);
      if (URLDrawable.class.isInstance(((URLImageView)paramView).getDrawable())) {
        this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIOGalleryActivity.a().b(paramViewGroup.hashCode());
      }
    }
    this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIOGalleryActivity.a().a();
  }
  
  public void a(int paramInt, View paramView, RegionDrawableData paramRegionDrawableData)
  {
    if (!ImageView.class.isInstance(paramView)) {}
    do
    {
      return;
      paramView = ((ImageView)paramView).getDrawable();
    } while (!URLDrawable.class.isInstance(paramView));
    ((URLDrawable)paramView).updateRegionBitmap(paramRegionDrawableData);
  }
  
  public void a(int paramInt, View paramView, boolean paramBoolean)
  {
    paramView = (AbstractImageAdapter.URLImageView2)paramView;
    Object localObject2 = ((AIOImageInfo)a(paramInt)).jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIOImageData;
    if ((paramBoolean) && (((AIOImageData)localObject2).a(8) != null))
    {
      Object localObject1 = paramView.getDrawable();
      localObject2 = ((AIOImageData)localObject2).a(8);
      localObject2 = (String)localObject2 + "#" + "DISPLAY";
      URLDrawable.URLDrawableOptions localURLDrawableOptions = URLDrawable.URLDrawableOptions.obtain();
      localURLDrawableOptions.mLoadingDrawable = ((Drawable)localObject1);
      localURLDrawableOptions.mFailedDrawable = ((Drawable)localObject1);
      localURLDrawableOptions.mPlayGifImage = true;
      localURLDrawableOptions.mUseExifOrientation = false;
      localObject1 = URLDrawable.getDrawable((String)localObject2, localURLDrawableOptions);
      paramView.setDecodingDrawble((URLDrawable)localObject1);
      ((URLDrawable)localObject1).startDownload();
      if (QLog.isColorLevel()) {
        QLog.i("AIOGalleryAdapter", 2, "AIOGalleryAdapter.updateDisplayView(): Update dp image, position=" + paramInt);
      }
      this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIOGalleryActivity.a().b();
    }
  }
  
  public void a(Configuration paramConfiguration)
  {
    int i = SizeMeasure.h(this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIOGalleryActivity);
    int j = SizeMeasure.i(this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIOGalleryActivity);
    if ((i != this.b) || (j != this.c))
    {
      this.b = i;
      this.c = j;
      URLDrawable.clearMemoryCache();
      a();
    }
  }
  
  public void a(View paramView, int paramInt) {}
  
  public void a(AbstractImageListModel paramAbstractImageListModel)
  {
    super.a(paramAbstractImageListModel);
    a();
  }
  
  public void a(URLDrawable paramURLDrawable, int paramInt)
  {
    if (this.jdField_a_of_type_AndroidUtilSparseArray.get(paramInt) != null) {
      this.jdField_a_of_type_AndroidUtilSparseArray.put(paramInt, paramURLDrawable);
    }
  }
  
  public void a(boolean paramBoolean)
  {
    super.notifyDataSetChanged();
    if (QLog.isColorLevel()) {
      QLog.d("AIOGalleryAdapter", 2, "notifyDataSetChanged(): Data changed");
    }
    a();
  }
  
  public void b(int paramInt1, int paramInt2)
  {
    if (!((AIOImageInfo)a(paramInt1)).jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIOImageData.jdField_d_of_type_Boolean) {
      super.b(paramInt1, paramInt2);
    }
  }
  
  public void b(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    paramView = (URLDrawable)this.jdField_a_of_type_AndroidUtilSparseArray.get(paramInt);
    if (paramView != null)
    {
      if (paramView.getStatus() == 0) {
        paramView.cancelDownload(true);
      }
      this.jdField_a_of_type_AndroidUtilSparseArray.remove(paramInt);
    }
    if (paramInt == this.jdField_a_of_type_Int)
    {
      if ((this.jdField_a_of_type_ComTencentImageURLDrawable != null) && (this.jdField_a_of_type_ComTencentImageURLDrawable.getStatus() == 0)) {
        this.jdField_a_of_type_ComTencentImageURLDrawable.cancelDownload(true);
      }
      this.jdField_a_of_type_ComTencentImageURLDrawable = null;
      this.jdField_a_of_type_Int = -1;
    }
    if (QLog.isColorLevel()) {
      QLog.d("AIOGalleryAdapter", 2, a());
    }
  }
  
  public void b(int paramInt, View paramView, boolean paramBoolean)
  {
    Object localObject2 = null;
    AbstractImageAdapter.URLImageView2 localURLImageView2 = (AbstractImageAdapter.URLImageView2)paramView;
    AIOImageData localAIOImageData = ((AIOImageInfo)a(paramInt)).jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIOImageData;
    Object localObject1;
    if (localAIOImageData.b)
    {
      paramView = localURLImageView2.getDrawable();
      if (!URLDrawable.class.isInstance(paramView)) {
        break label366;
      }
      paramView = (URLDrawable)paramView;
      localObject1 = paramView.getURL().getRef();
    }
    for (;;)
    {
      if ((paramView == null) || (localObject1 == null) || ((!"PART".equals(localObject1)) && (!"DISPLAY".equals(localObject1))))
      {
        localURLImageView2.setImageDrawable(BaseApplicationImpl.a().getResources().getDrawable(2130837581));
        a(paramInt, false);
        this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIOGalleryActivity.a().d();
      }
      if (QLog.isColorLevel()) {
        QLog.i("AIOGalleryAdapter", 2, "AIOGalleryAdapter.updateView(): IMAGE_FILE_ERROR");
      }
      if ((QLog.isDevelopLevel()) && (localAIOImageData.jdField_d_of_type_Boolean)) {
        QQToast.a(localURLImageView2.getContext(), "AIOGalleryAdapter.updateView(): error!", 2000).a();
      }
      do
      {
        if (!this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIOGalleryActivity.jdField_a_of_type_Boolean)
        {
          this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoIAIOImageProvider.b();
          this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIOGalleryActivity.jdField_a_of_type_Boolean = true;
        }
        return;
      } while (localAIOImageData.a(2) == null);
      localObject1 = localAIOImageData.a(2);
      paramView = (View)localObject1;
      if (paramBoolean) {
        paramView = (String)localObject1 + "#PART";
      }
      localObject1 = URLDrawable.URLDrawableOptions.obtain();
      ((URLDrawable.URLDrawableOptions)localObject1).mUseExifOrientation = false;
      ((URLDrawable.URLDrawableOptions)localObject1).mPlayGifImage = true;
      paramView = URLDrawable.getDrawable(paramView, (URLDrawable.URLDrawableOptions)localObject1);
      if ((paramView.getStatus() == 1) && (!localAIOImageData.jdField_d_of_type_Boolean))
      {
        localURLImageView2.setImageDrawable(paramView);
        a(paramInt, true);
      }
      for (;;)
      {
        if (QLog.isColorLevel()) {
          QLog.i("AIOGalleryAdapter", 2, "AIOGalleryAdapter.updateView(): Update large image, position=" + paramInt);
        }
        localAIOImageData.jdField_d_of_type_Boolean = paramBoolean;
        this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIOGalleryActivity.a().c();
        break;
        paramView.setTag(Integer.valueOf(1));
        paramView.startDownload();
        localURLImageView2.setDecodingDrawble(paramView);
      }
      label366:
      localObject1 = null;
      paramView = localObject2;
    }
  }
  
  public void c(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    AbstractImageAdapter.URLImageView2 localURLImageView2 = (AbstractImageAdapter.URLImageView2)paramView;
    paramView = localURLImageView2.getDrawable();
    paramViewGroup = localURLImageView2.jdField_a_of_type_ComTencentImageURLDrawable;
    if (((paramView instanceof URLDrawable)) && (((URLDrawable)paramView).isFakeSize()) && (paramViewGroup == null))
    {
      paramView = ((URLDrawable)paramView).getURL();
      if (("file".equals(paramView.getProtocol())) && (paramView.getRef() == null))
      {
        if ((paramInt != this.jdField_a_of_type_Int) || (this.jdField_a_of_type_ComTencentImageURLDrawable == null)) {
          break label165;
        }
        paramViewGroup = this.jdField_a_of_type_ComTencentImageURLDrawable;
        paramView = paramViewGroup;
        if (QLog.isColorLevel())
        {
          paramView = paramViewGroup;
          if (this.jdField_a_of_type_ComTencentImageURLDrawable != null)
          {
            QLog.d("AIOGalleryAdapter", 2, "use exist raw drawable");
            paramView = paramViewGroup;
          }
        }
        if (paramView.getStatus() != 1) {
          break label292;
        }
        localURLImageView2.jdField_a_of_type_Boolean = true;
        localURLImageView2.setImageDrawable(paramView);
        localURLImageView2.jdField_a_of_type_Boolean = false;
      }
    }
    for (;;)
    {
      paramView = (AIOImageInfo)a(paramInt);
      this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIOGalleryActivity.a().c(paramView.hashCode());
      return;
      label165:
      if ((QLog.isColorLevel()) && (this.jdField_a_of_type_ComTencentImageURLDrawable != null)) {
        QLog.d("AIOGalleryAdapter", 2, "rawDrawable is exist");
      }
      paramView = paramView.toString() + "#" + "NOSAMPLE";
      paramViewGroup = URLDrawable.URLDrawableOptions.obtain();
      paramViewGroup.mUseExifOrientation = false;
      paramViewGroup.mUseMemoryCache = false;
      paramViewGroup = URLDrawable.getDrawable(paramView, paramViewGroup);
      paramViewGroup.setTag(Integer.valueOf(2));
      this.jdField_a_of_type_ComTencentImageURLDrawable = paramViewGroup;
      this.jdField_a_of_type_Int = paramInt;
      paramView = paramViewGroup;
      if (!QLog.isColorLevel()) {
        break;
      }
      QLog.d("AIOGalleryAdapter", 2, "create rawDrawable, position:" + paramInt);
      paramView = paramViewGroup;
      break;
      label292:
      localURLImageView2.setDecodingDrawble(paramView);
      paramView.startDownload();
    }
  }
  
  public View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    Object localObject = null;
    boolean bool3 = false;
    int i = 1;
    if (paramView != null) {}
    AIOGalleryAdapter.GalleryURLImageView localGalleryURLImageView;
    AIOImageInfo localAIOImageInfo;
    AIOImageData localAIOImageData;
    boolean bool1;
    for (;;)
    {
      return paramView;
      if (QLog.isColorLevel()) {
        QLog.i("AIOGalleryAdapter", 2, "AIOGalleryAdapter.getView(): position=" + paramInt + " this=" + this);
      }
      localGalleryURLImageView = new AIOGalleryAdapter.GalleryURLImageView(this, this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIOGalleryActivity);
      localAIOImageInfo = (AIOImageInfo)a(paramInt);
      localAIOImageData = localAIOImageInfo.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIOImageData;
      localGalleryURLImageView.jdField_a_of_type_Int = paramInt;
      localGalleryURLImageView.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIOImageInfo = localAIOImageInfo;
      localGalleryURLImageView.jdField_a_of_type_Boolean = false;
      paramView = (URLDrawable)this.jdField_a_of_type_AndroidUtilSparseArray.get(paramInt);
      if ((paramView != null) && (paramView.getStatus() == 1))
      {
        localGalleryURLImageView.setImageDrawable(paramView);
        String str = localAIOImageData.a(4);
        paramViewGroup = paramView.getURL().toString();
        if (paramViewGroup.equals(str)) {
          localGalleryURLImageView.b = true;
        }
        if (localAIOImageInfo.b == -2) {}
        try
        {
          localAIOImageInfo.b = new ExifInterface(paramView.getURL().getFile()).getAttributeInt("Orientation", 1);
          a(localGalleryURLImageView, paramView, localAIOImageInfo.b);
          if (QLog.isColorLevel()) {
            QLog.i("AIOGalleryAdapter", 2, "AIOGalleryAdapter.getView(): cache url is " + paramViewGroup + ", cache type is " + localAIOImageData.a(paramView.getURL().getFile()));
          }
          if (localAIOImageData.jdField_d_of_type_Boolean) {
            this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoIAIOImageProvider.a(localAIOImageData.jdField_a_of_type_Long, localAIOImageData.jdField_e_of_type_Int, 2);
          }
          if (localGalleryURLImageView.b)
          {
            paramView = "original";
            bool1 = true;
            paramInt = i;
            if (paramInt != 0)
            {
              paramInt = localAIOImageInfo.hashCode();
              this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIOGalleryActivity.jdField_a_of_type_Int = paramInt;
              paramViewGroup = this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIOGalleryActivity.a();
              paramViewGroup.a(paramInt);
              paramViewGroup.a(paramInt, localAIOImageData.jdField_d_of_type_Long, localAIOImageData.jdField_e_of_type_Long);
              if (localAIOImageData.jdField_e_of_type_Boolean) {
                paramViewGroup.d(paramInt);
              }
              if (paramView != null)
              {
                paramViewGroup.a(paramInt, paramView);
                paramViewGroup.a(paramInt, bool1);
              }
            }
            paramViewGroup = localAIOImageData.jdField_a_of_type_Long + "_" + localAIOImageData.jdField_e_of_type_Int;
            paramView = localGalleryURLImageView;
            if (this.jdField_a_of_type_JavaUtilArrayList.contains(paramViewGroup)) {
              continue;
            }
            this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoIAIOImageProvider.a(localAIOImageData.jdField_a_of_type_Long, localAIOImageData.jdField_e_of_type_Int);
            this.jdField_a_of_type_JavaUtilArrayList.add(paramViewGroup);
            return localGalleryURLImageView;
          }
        }
        catch (IOException localIOException)
        {
          for (;;)
          {
            if (QLog.isColorLevel()) {
              QLog.e("AIOGalleryAdapter", 2, "read exif error", localIOException);
            }
            localAIOImageInfo.b = 1;
            continue;
            paramView = "large";
          }
        }
      }
    }
    paramView = localAIOImageData.a(4);
    if (paramView == null)
    {
      paramViewGroup = localAIOImageData.a(2);
      if (paramViewGroup == null) {}
    }
    for (;;)
    {
      boolean bool2;
      label532:
      URLDrawable localURLDrawable;
      if (paramView != null)
      {
        bool2 = true;
        paramView = URLDrawable.URLDrawableOptions.obtain();
        paramView.mRequestWidth = this.b;
        paramView.mRequestHeight = this.c;
        paramView.mLoadingDrawable = URLDrawableHelper.d;
        paramView.mPlayGifImage = true;
        paramView.mUseExifOrientation = false;
        if ((this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIOGalleryActivity.jdField_a_of_type_Boolean) && (this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIOGalleryAdapter$GalleryURLImageView != null))
        {
          paramView.mLoadingDrawable = this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIOGalleryAdapter$GalleryURLImageView.getDrawable();
          this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIOGalleryAdapter$GalleryURLImageView = null;
        }
        if ((bool2) || (!localAIOImageData.jdField_d_of_type_Boolean)) {
          break label895;
        }
        localURLDrawable = URLDrawable.getDrawable(localAIOImageData.a(2) + "#" + "PART", paramView);
        label650:
        localURLDrawable.setTag(Integer.valueOf(1));
        this.jdField_a_of_type_AndroidUtilSparseArray.put(paramInt, localURLDrawable);
        if (!localURLDrawable.isDownloadStarted()) {
          break label1673;
        }
        if (BaseApplicationImpl.a.get(localURLDrawable.getURL().toString()) == null) {
          break label905;
        }
        bool1 = true;
        label697:
        if (!bool2) {
          break label911;
        }
        paramView = "original";
      }
      for (;;)
      {
        label706:
        switch (localURLDrawable.getStatus())
        {
        default: 
          localGalleryURLImageView.setImageDrawable(localURLDrawable);
          localGalleryURLImageView.b = bool2;
          if (!this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIOGalleryActivity.jdField_a_of_type_Boolean) {
            localURLDrawable.downloadImediatly();
          }
          if (QLog.isColorLevel()) {
            QLog.i("AIOGalleryAdapter", 2, "AIOGalleryAdapter.getView(): url is " + localURLDrawable.getURL().toString() + ", file type is " + localAIOImageData.a(localURLDrawable.getURL().toString()));
          }
          if ((!bool2) && (localAIOImageData.jdField_d_of_type_Boolean) && (!localAIOImageData.b)) {
            this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoIAIOImageProvider.a(localAIOImageData.jdField_a_of_type_Long, localAIOImageData.jdField_e_of_type_Int, 2);
          }
          break;
        }
        for (;;)
        {
          for (;;)
          {
            if (!this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIOGalleryActivity.jdField_a_of_type_Boolean) {
              this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIOGalleryAdapter$GalleryURLImageView = localGalleryURLImageView;
            }
            paramInt = i;
            break;
            bool2 = false;
            break label532;
            label895:
            localURLDrawable = URLDrawable.getDrawable(paramViewGroup, paramView);
            break label650;
            label905:
            bool1 = false;
            break label697;
            label911:
            paramView = "large";
            break label706;
            if (localAIOImageInfo.b == -2) {}
            try
            {
              localAIOImageInfo.b = new ExifInterface(paramViewGroup.getAbsolutePath()).getAttributeInt("Orientation", 1);
              a(localGalleryURLImageView, localURLDrawable, localAIOImageInfo.b);
              if (localURLDrawable.getStatus() == 1) {
                bool3 = true;
              }
              a(paramInt, bool3);
            }
            catch (IOException paramViewGroup)
            {
              for (;;)
              {
                if (QLog.isColorLevel()) {
                  QLog.e("AIOGalleryAdapter", 2, "read exif error", paramViewGroup);
                }
                localAIOImageInfo.b = 1;
              }
            }
          }
          if (!this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIOGalleryActivity.jdField_a_of_type_Boolean)
          {
            this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoIAIOImageProvider.b();
            this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIOGalleryActivity.jdField_a_of_type_Boolean = true;
          }
        }
        if (localAIOImageData.a(8) != null)
        {
          paramView = URLDrawable.URLDrawableOptions.obtain();
          paramView.mLoadingDrawable = URLDrawableHelper.d;
          paramView.mFailedDrawable = URLDrawableHelper.d;
          paramView.mUseExifOrientation = false;
          localGalleryURLImageView.setImageDrawable(URLDrawable.getDrawable(localAIOImageData.a(8), paramView));
          a(paramInt, localAIOImageInfo.jdField_a_of_type_Int / 100);
          if (QLog.isColorLevel()) {
            QLog.i("AIOGalleryAdapter", 2, "AIOGalleryAdapter.getView(): url is " + localAIOImageData.a(8) + ", file type is " + 8);
          }
          if (!localAIOImageData.b) {
            this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoIAIOImageProvider.a(localAIOImageData.jdField_a_of_type_Long, localAIOImageData.jdField_e_of_type_Int, 2);
          }
          for (;;)
          {
            if (!this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIOGalleryActivity.jdField_a_of_type_Boolean)
            {
              this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIOGalleryAdapter$GalleryURLImageView = localGalleryURLImageView;
              this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIOGalleryActivity.a().a(true);
            }
            if ((QLog.isDevelopLevel()) && (localAIOImageData.jdField_d_of_type_Boolean)) {
              QQToast.a(localGalleryURLImageView.getContext(), "Refresh temp display image", 2000).a();
            }
            paramView = null;
            bool1 = false;
            paramInt = i;
            break;
            if (!this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIOGalleryActivity.jdField_a_of_type_Boolean)
            {
              this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoIAIOImageProvider.b();
              this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIOGalleryActivity.jdField_a_of_type_Boolean = true;
            }
          }
        }
        if ((localAIOImageData.c) || (localAIOImageData.b) || (localAIOImageData.jdField_a_of_type_Boolean)) {
          if ((this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIOGalleryActivity.jdField_a_of_type_Boolean) && (this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIOGalleryAdapter$GalleryURLImageView != null))
          {
            paramView = this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIOGalleryAdapter$GalleryURLImageView.getDrawable();
            localGalleryURLImageView.setImageDrawable(paramView);
            if (URLDrawable.class.isInstance(paramView)) {
              this.jdField_a_of_type_AndroidUtilSparseArray.put(paramInt, (URLDrawable)paramView);
            }
            this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIOGalleryAdapter$GalleryURLImageView = null;
          }
        }
        for (;;)
        {
          if (QLog.isColorLevel())
          {
            QLog.i("AIOGalleryAdapter", 2, "AIOGalleryAdapter.getView(): IMAGE_FILE_ERROR");
            paramView = null;
            bool1 = false;
            paramInt = 0;
            break;
            localGalleryURLImageView.setImageDrawable(BaseApplicationImpl.a().getResources().getDrawable(2130837581));
            a(paramInt, false);
            continue;
            if (localAIOImageData.a(1) != null)
            {
              paramView = URLDrawable.URLDrawableOptions.obtain();
              paramView.mLoadingDrawable = URLDrawableHelper.d;
              paramView.mFailedDrawable = URLDrawableHelper.d;
              paramView = URLDrawable.getDrawable(localAIOImageData.a(1), paramView);
              localGalleryURLImageView.setImageDrawable(paramView);
              paramView.downloadImediatly();
              a(paramInt, localAIOImageInfo.jdField_a_of_type_Int / 100);
              this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoIAIOImageProvider.a(localAIOImageData.jdField_a_of_type_Long, localAIOImageData.jdField_e_of_type_Int, 2);
              if (QLog.isColorLevel()) {
                QLog.i("AIOGalleryAdapter", 2, "AIOGalleryAdapter.getView(): url is " + localAIOImageData.a(1) + ", file type is " + 1);
              }
              if (!this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIOGalleryActivity.jdField_a_of_type_Boolean)
              {
                this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIOGalleryAdapter$GalleryURLImageView = localGalleryURLImageView;
                this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIOGalleryActivity.a().a(localAIOImageData.f);
              }
              paramView = null;
              bool1 = false;
              paramInt = i;
              break;
            }
            a(paramInt, localAIOImageInfo.jdField_a_of_type_Int / 100);
            localGalleryURLImageView.setImageDrawable(URLDrawableHelper.d);
            this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoIAIOImageProvider.a(localAIOImageData.jdField_a_of_type_Long, localAIOImageData.jdField_e_of_type_Int, 2);
            if (QLog.isColorLevel()) {
              QLog.i("AIOGalleryAdapter", 2, "AIOGalleryAdapter.getView(): No pic");
            }
            if (!this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIOGalleryActivity.jdField_a_of_type_Boolean) {
              this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIOGalleryActivity.a().a(localAIOImageData.f);
            }
          }
        }
        paramView = null;
        bool1 = false;
        paramInt = 0;
        break;
        label1673:
        bool1 = false;
        paramView = localObject;
      }
      paramViewGroup = paramView;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.2.jar\classes.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.photo.AIOGalleryAdapter
 * JD-Core Version:    0.7.0.1
 */