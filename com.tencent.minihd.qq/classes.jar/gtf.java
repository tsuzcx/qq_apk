import android.graphics.drawable.Drawable;
import android.util.SparseArray;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import com.tencent.common.galleryactivity.AbstractImageAdapter.URLImageView2;
import com.tencent.image.RegionDrawableData;
import com.tencent.image.URLDrawable;
import com.tencent.image.URLDrawable.URLDrawableOptions;
import com.tencent.mobileqq.activity.photo.PhotoPreviewActivity;
import com.tencent.mobileqq.activity.photo.ProGallery.OnProGalleryListener;
import com.tencent.mobileqq.transfile.URLDrawableHelper;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import java.net.URL;
import java.util.ArrayList;

public class gtf
  extends BaseAdapter
  implements ProGallery.OnProGalleryListener
{
  private int jdField_a_of_type_Int = -1;
  private SparseArray jdField_a_of_type_AndroidUtilSparseArray = new SparseArray();
  private URLDrawable jdField_a_of_type_ComTencentImageURLDrawable;
  
  private gtf(PhotoPreviewActivity paramPhotoPreviewActivity) {}
  
  private String a()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("(preview) Actives: ");
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
  
  public View a(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    paramView = (URLDrawable)this.jdField_a_of_type_AndroidUtilSparseArray.get(paramInt);
    if (paramView != null) {
      if (paramView.getStatus() == 3) {
        paramView.restartDownload();
      }
    }
    for (;;)
    {
      if (QLog.isColorLevel()) {
        QLog.d("PEAK", 2, a());
      }
      return null;
      paramView = new File(a(paramInt).toString());
      if (paramView.exists())
      {
        URLDrawable.URLDrawableOptions localURLDrawableOptions = URLDrawable.URLDrawableOptions.obtain();
        localURLDrawableOptions.mRequestWidth = paramViewGroup.getWidth();
        localURLDrawableOptions.mRequestHeight = paramViewGroup.getHeight();
        localURLDrawableOptions.mLoadingDrawable = URLDrawableHelper.d;
        localURLDrawableOptions.mPlayGifImage = true;
        localURLDrawableOptions.mUseAutoScaleParams = false;
        paramView = URLDrawable.getDrawable(paramView, localURLDrawableOptions);
        paramView.setTag(Integer.valueOf(1));
        paramView.startDownload();
        this.jdField_a_of_type_AndroidUtilSparseArray.put(paramInt, paramView);
      }
    }
  }
  
  public String a(int paramInt)
  {
    if ((this.jdField_a_of_type_ComTencentMobileqqActivityPhotoPhotoPreviewActivity.a != null) && (paramInt < this.jdField_a_of_type_ComTencentMobileqqActivityPhotoPhotoPreviewActivity.a.size()) && (paramInt >= 0)) {
      return (String)this.jdField_a_of_type_ComTencentMobileqqActivityPhotoPhotoPreviewActivity.a.get(paramInt);
    }
    return null;
  }
  
  public void a(int paramInt, View paramView, ViewGroup paramViewGroup) {}
  
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
        QLog.d("PEAK", 2, "(preview)destory rawDrawable, position: " + paramInt);
      }
    }
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
    if (QLog.isColorLevel()) {
      QLog.d("PEAK", 2, a());
    }
  }
  
  public void c(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    paramView = (AbstractImageAdapter.URLImageView2)paramView;
    paramViewGroup = paramView.getDrawable();
    Object localObject = paramView.jdField_a_of_type_ComTencentImageURLDrawable;
    if (((paramViewGroup instanceof URLDrawable)) && (((URLDrawable)paramViewGroup).isFakeSize()) && (localObject == null))
    {
      paramViewGroup = ((URLDrawable)paramViewGroup).getURL();
      if (("file".equals(paramViewGroup.getProtocol())) && (paramViewGroup.getRef() == null))
      {
        if ((paramInt != this.jdField_a_of_type_Int) || (this.jdField_a_of_type_ComTencentImageURLDrawable == null)) {
          break label107;
        }
        paramView = this.jdField_a_of_type_ComTencentImageURLDrawable;
        if ((QLog.isColorLevel()) && (this.jdField_a_of_type_ComTencentImageURLDrawable != null)) {
          QLog.d("PEAK", 2, "use exist raw drawable");
        }
      }
    }
    return;
    label107:
    if ((QLog.isColorLevel()) && (this.jdField_a_of_type_ComTencentImageURLDrawable != null)) {
      QLog.d("PEAK", 2, "rawDrawable is exist");
    }
    paramViewGroup = paramViewGroup.toString() + "#NOSAMPLE";
    localObject = URLDrawable.URLDrawableOptions.obtain();
    ((URLDrawable.URLDrawableOptions)localObject).mUseExifOrientation = false;
    ((URLDrawable.URLDrawableOptions)localObject).mUseMemoryCache = false;
    paramViewGroup = URLDrawable.getDrawable(paramViewGroup, (URLDrawable.URLDrawableOptions)localObject);
    paramViewGroup.setTag(Integer.valueOf(2));
    this.jdField_a_of_type_ComTencentImageURLDrawable = null;
    this.jdField_a_of_type_Int = paramInt;
    if (QLog.isColorLevel()) {
      QLog.d("PEAK", 2, "create rawDrawable, position:" + paramInt);
    }
    if (paramViewGroup.getStatus() == 1)
    {
      paramView.jdField_a_of_type_Boolean = true;
      paramView.setImageDrawable(paramViewGroup);
      paramView.jdField_a_of_type_Boolean = false;
      return;
    }
    paramView.setDecodingDrawble(paramViewGroup);
    paramViewGroup.startDownload();
  }
  
  public int getCount()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqActivityPhotoPhotoPreviewActivity.a != null) {
      return this.jdField_a_of_type_ComTencentMobileqqActivityPhotoPhotoPreviewActivity.a.size();
    }
    return 0;
  }
  
  public long getItemId(int paramInt)
  {
    return paramInt;
  }
  
  public View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    if (paramView != null) {
      return paramView;
    }
    AbstractImageAdapter.URLImageView2 localURLImageView2 = new AbstractImageAdapter.URLImageView2(paramViewGroup.getContext());
    Object localObject = (URLDrawable)this.jdField_a_of_type_AndroidUtilSparseArray.get(paramInt);
    if ((localObject != null) && (((URLDrawable)localObject).getStatus() == 1)) {
      localURLImageView2.setImageDrawable((Drawable)localObject);
    }
    for (;;)
    {
      return localURLImageView2;
      localObject = a(paramInt);
      if (localObject == null) {
        break;
      }
      paramView = new File((String)localObject);
      if (paramView.exists())
      {
        localObject = URLDrawable.URLDrawableOptions.obtain();
        ((URLDrawable.URLDrawableOptions)localObject).mRequestWidth = paramViewGroup.getWidth();
        ((URLDrawable.URLDrawableOptions)localObject).mRequestHeight = paramViewGroup.getHeight();
        ((URLDrawable.URLDrawableOptions)localObject).mLoadingDrawable = URLDrawableHelper.d;
        ((URLDrawable.URLDrawableOptions)localObject).mPlayGifImage = true;
        ((URLDrawable.URLDrawableOptions)localObject).mUseAutoScaleParams = false;
        paramView = URLDrawable.getDrawable(paramView, (URLDrawable.URLDrawableOptions)localObject);
        switch (paramView.getStatus())
        {
        default: 
          paramView.setTag(Integer.valueOf(1));
          paramView.startDownload();
        }
        localURLImageView2.setImageDrawable(paramView);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\classes.jar
 * Qualified Name:     gtf
 * JD-Core Version:    0.7.0.1
 */