import android.content.Context;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.common.galleryactivity.AbstractImageAdapter.URLImageView2;
import com.tencent.image.URLDrawable;
import com.tencent.image.URLDrawable.URLDrawableOptions;
import com.tencent.mobileqq.activity.aio.photo.AIOImageData;
import com.tencent.mobileqq.activity.flaotaio.FloatImagePreview;
import com.tencent.mobileqq.transfile.URLDrawableHelper;
import com.tencent.mobileqq.util.SizeMeasure;
import java.net.URL;

public class gmn
  extends BaseAdapter
{
  private int jdField_a_of_type_Int;
  private int b;
  
  public gmn(FloatImagePreview paramFloatImagePreview)
  {
    this.jdField_a_of_type_Int = SizeMeasure.h(FloatImagePreview.a(paramFloatImagePreview));
    this.b = SizeMeasure.i(FloatImagePreview.a(paramFloatImagePreview));
  }
  
  public void a(int paramInt, View paramView, boolean paramBoolean)
  {
    paramView = (AbstractImageAdapter.URLImageView2)paramView;
    Object localObject2 = this.jdField_a_of_type_ComTencentMobileqqActivityFlaotaioFloatImagePreview.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIOImageData;
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
    }
  }
  
  public void b(int paramInt, View paramView, boolean paramBoolean)
  {
    Object localObject2 = null;
    AbstractImageAdapter.URLImageView2 localURLImageView2 = (AbstractImageAdapter.URLImageView2)paramView;
    AIOImageData localAIOImageData = this.jdField_a_of_type_ComTencentMobileqqActivityFlaotaioFloatImagePreview.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIOImageData;
    Object localObject1;
    if (localAIOImageData.b)
    {
      paramView = localURLImageView2.getDrawable();
      if (!URLDrawable.class.isInstance(paramView)) {
        break label238;
      }
      paramView = (URLDrawable)paramView;
      localObject1 = paramView.getURL().getRef();
    }
    for (;;)
    {
      if ((paramView == null) || (localObject1 == null) || ((!"PART".equals(localObject1)) && (!"DISPLAY".equals(localObject1))))
      {
        localURLImageView2.setImageDrawable(BaseApplicationImpl.a().getResources().getDrawable(2130837581));
        this.jdField_a_of_type_ComTencentMobileqqActivityFlaotaioFloatImagePreview.a(paramInt, false);
      }
      do
      {
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
      if ((paramView.getStatus() == 1) && (!localAIOImageData.d))
      {
        localURLImageView2.setImageDrawable(paramView);
        this.jdField_a_of_type_ComTencentMobileqqActivityFlaotaioFloatImagePreview.a(paramInt, true);
      }
      for (;;)
      {
        localAIOImageData.d = paramBoolean;
        return;
        paramView.setTag(Integer.valueOf(1));
        paramView.startDownload();
        localURLImageView2.setDecodingDrawble(paramView);
      }
      label238:
      localObject1 = null;
      paramView = localObject2;
    }
  }
  
  public int getCount()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqActivityFlaotaioFloatImagePreview.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIOImageData == null) {
      return 0;
    }
    return 1;
  }
  
  public Object getItem(int paramInt)
  {
    return this.jdField_a_of_type_ComTencentMobileqqActivityFlaotaioFloatImagePreview.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIOImageData;
  }
  
  public long getItemId(int paramInt)
  {
    return 0L;
  }
  
  public View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    boolean bool = false;
    Log.i("app2", "getView position=" + paramInt + " convertView=" + paramView);
    if (paramView != null) {
      return paramView;
    }
    paramViewGroup = new gmo(this.jdField_a_of_type_ComTencentMobileqqActivityFlaotaioFloatImagePreview, FloatImagePreview.a(this.jdField_a_of_type_ComTencentMobileqqActivityFlaotaioFloatImagePreview));
    AIOImageData localAIOImageData = this.jdField_a_of_type_ComTencentMobileqqActivityFlaotaioFloatImagePreview.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIOImageData;
    Object localObject = localAIOImageData.a(4);
    if (localObject == null)
    {
      paramView = localAIOImageData.a(2);
      if (paramView == null) {}
    }
    for (;;)
    {
      int i;
      if (localObject != null)
      {
        i = 1;
        localObject = URLDrawable.URLDrawableOptions.obtain();
        ((URLDrawable.URLDrawableOptions)localObject).mRequestWidth = this.jdField_a_of_type_Int;
        ((URLDrawable.URLDrawableOptions)localObject).mRequestHeight = this.b;
        ((URLDrawable.URLDrawableOptions)localObject).mLoadingDrawable = URLDrawableHelper.d;
        ((URLDrawable.URLDrawableOptions)localObject).mPlayGifImage = true;
        ((URLDrawable.URLDrawableOptions)localObject).mUseExifOrientation = false;
        if ((i != 0) || (!localAIOImageData.d)) {
          break label318;
        }
        paramView = URLDrawable.getDrawable(localAIOImageData.a(2) + "#" + "PART", (URLDrawable.URLDrawableOptions)localObject);
        label194:
        Log.i("app2", "status =" + paramView.getStatus());
        switch (paramView.getStatus())
        {
        }
      }
      for (;;)
      {
        paramViewGroup.setImageDrawable(paramView);
        if (!this.jdField_a_of_type_ComTencentMobileqqActivityFlaotaioFloatImagePreview.b) {
          paramView.downloadImediatly();
        }
        if ((i != 0) || (!localAIOImageData.d) || (localAIOImageData.b)) {
          break label356;
        }
        this.jdField_a_of_type_ComTencentMobileqqActivityFlaotaioFloatImagePreview.a(localAIOImageData.jdField_a_of_type_Long, localAIOImageData.e, 2);
        return paramViewGroup;
        i = 0;
        break;
        label318:
        paramView = URLDrawable.getDrawable(paramView, (URLDrawable.URLDrawableOptions)localObject);
        break label194;
        localObject = this.jdField_a_of_type_ComTencentMobileqqActivityFlaotaioFloatImagePreview;
        if (paramView.getStatus() == 1) {
          bool = true;
        }
        ((FloatImagePreview)localObject).a(paramInt, bool);
      }
      label356:
      paramView = paramViewGroup;
      if (!this.jdField_a_of_type_ComTencentMobileqqActivityFlaotaioFloatImagePreview.b) {
        break;
      }
      this.jdField_a_of_type_ComTencentMobileqqActivityFlaotaioFloatImagePreview.b = true;
      return paramViewGroup;
      if (localAIOImageData.a(8) != null)
      {
        paramView = URLDrawable.URLDrawableOptions.obtain();
        paramView.mLoadingDrawable = URLDrawableHelper.d;
        paramView.mFailedDrawable = URLDrawableHelper.d;
        paramView.mUseExifOrientation = false;
        paramViewGroup.setImageDrawable(URLDrawable.getDrawable(localAIOImageData.a(8), paramView));
        this.jdField_a_of_type_ComTencentMobileqqActivityFlaotaioFloatImagePreview.a(paramInt, this.jdField_a_of_type_ComTencentMobileqqActivityFlaotaioFloatImagePreview.jdField_a_of_type_Int / 100);
        paramView = paramViewGroup;
        if (localAIOImageData.b) {
          break;
        }
        this.jdField_a_of_type_ComTencentMobileqqActivityFlaotaioFloatImagePreview.a(localAIOImageData.jdField_a_of_type_Long, localAIOImageData.e, 2);
        return paramViewGroup;
      }
      if ((localAIOImageData.c) || (localAIOImageData.b) || (localAIOImageData.jdField_a_of_type_Boolean))
      {
        paramViewGroup.setImageDrawable(FloatImagePreview.a(this.jdField_a_of_type_ComTencentMobileqqActivityFlaotaioFloatImagePreview).getResources().getDrawable(2130837581));
        this.jdField_a_of_type_ComTencentMobileqqActivityFlaotaioFloatImagePreview.a(paramInt, false);
        return paramViewGroup;
      }
      if (localAIOImageData.a(1) != null)
      {
        paramView = URLDrawable.URLDrawableOptions.obtain();
        paramView.mLoadingDrawable = URLDrawableHelper.d;
        paramView.mFailedDrawable = URLDrawableHelper.d;
        paramView = URLDrawable.getDrawable(localAIOImageData.a(1), paramView);
        paramViewGroup.setImageDrawable(paramView);
        paramView.downloadImediatly();
        this.jdField_a_of_type_ComTencentMobileqqActivityFlaotaioFloatImagePreview.a(paramInt, this.jdField_a_of_type_ComTencentMobileqqActivityFlaotaioFloatImagePreview.jdField_a_of_type_Int / 100);
        this.jdField_a_of_type_ComTencentMobileqqActivityFlaotaioFloatImagePreview.a(localAIOImageData.jdField_a_of_type_Long, localAIOImageData.e, 2);
        return paramViewGroup;
      }
      this.jdField_a_of_type_ComTencentMobileqqActivityFlaotaioFloatImagePreview.a(paramInt, this.jdField_a_of_type_ComTencentMobileqqActivityFlaotaioFloatImagePreview.jdField_a_of_type_Int / 100);
      paramViewGroup.setImageDrawable(URLDrawableHelper.d);
      this.jdField_a_of_type_ComTencentMobileqqActivityFlaotaioFloatImagePreview.a(localAIOImageData.jdField_a_of_type_Long, localAIOImageData.e, 2);
      return paramViewGroup;
      paramView = (View)localObject;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.2.jar\classes.jar
 * Qualified Name:     gmn
 * JD-Core Version:    0.7.0.1
 */