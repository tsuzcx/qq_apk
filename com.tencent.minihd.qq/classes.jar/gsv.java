import android.content.res.Resources;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.image.URLDrawable;
import com.tencent.mobileqq.activity.photo.LocalMediaInfo;
import com.tencent.mobileqq.activity.photo.MimeHelper;
import com.tencent.mobileqq.activity.photo.PhotoListActivity;
import com.tencent.mobileqq.utils.AlbumUtil;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.AbsListView.LayoutParams;
import java.net.URL;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;

public class gsv
  extends BaseAdapter
{
  private Resources jdField_a_of_type_AndroidContentResResources;
  ColorDrawable jdField_a_of_type_AndroidGraphicsDrawableColorDrawable = new ColorDrawable(570425344);
  private Drawable jdField_a_of_type_AndroidGraphicsDrawableDrawable;
  private LayoutInflater jdField_a_of_type_AndroidViewLayoutInflater;
  private ArrayList jdField_a_of_type_JavaUtilArrayList = new ArrayList();
  
  public gsv(PhotoListActivity paramPhotoListActivity)
  {
    this.jdField_a_of_type_AndroidViewLayoutInflater = paramPhotoListActivity.getLayoutInflater();
    this.jdField_a_of_type_AndroidContentResResources = paramPhotoListActivity.getResources();
    this.jdField_a_of_type_AndroidGraphicsDrawableDrawable = this.jdField_a_of_type_AndroidContentResResources.getDrawable(2130841071);
  }
  
  private String a(int paramInt1, LocalMediaInfo paramLocalMediaInfo, int paramInt2)
  {
    if (paramInt1 == 0) {}
    for (StringBuilder localStringBuilder = new StringBuilder("照片");; localStringBuilder = new StringBuilder("视频"))
    {
      localStringBuilder.append(paramInt2 + 1).append(" 创建时间: ");
      return new SimpleDateFormat("yyyy年MM月dd HH点mm分ss秒").format(new Date(paramLocalMediaInfo.d * 1000L));
      if (paramInt1 != 1) {
        break;
      }
    }
    if (QLog.isColorLevel()) {
      QLog.e(PhotoListActivity.jdField_a_of_type_JavaLangString, 2, "PhotoListActivity createContentDescription mediaType is error");
    }
    return "";
  }
  
  public LocalMediaInfo a(int paramInt)
  {
    return (LocalMediaInfo)this.jdField_a_of_type_JavaUtilArrayList.get(paramInt);
  }
  
  String a(long paramLong)
  {
    paramLong /= 1000L;
    int i = (int)paramLong % 60;
    int j = (int)paramLong / 60;
    String str1;
    if (i > 9)
    {
      str1 = String.valueOf(i);
      if (j <= 9) {
        break label105;
      }
    }
    label105:
    for (String str2 = String.valueOf(j);; str2 = "0" + String.valueOf(j))
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append(str2).append(":").append(str1);
      return localStringBuilder.toString();
      str1 = "0" + String.valueOf(i);
      break;
    }
  }
  
  public void a(List paramList)
  {
    this.jdField_a_of_type_JavaUtilArrayList.clear();
    if ((paramList == null) || (paramList.size() == 0)) {
      return;
    }
    this.jdField_a_of_type_JavaUtilArrayList.addAll(paramList);
  }
  
  public int getCount()
  {
    return this.jdField_a_of_type_JavaUtilArrayList.size();
  }
  
  public long getItemId(int paramInt)
  {
    return 0L;
  }
  
  public int getItemViewType(int paramInt)
  {
    String[] arrayOfString = MimeHelper.a(((LocalMediaInfo)this.jdField_a_of_type_JavaUtilArrayList.get(paramInt)).jdField_b_of_type_JavaLangString);
    if (arrayOfString == null) {
      return 0;
    }
    return ((Integer)PhotoListActivity.a().get(arrayOfString[0])).intValue();
  }
  
  public View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    int i = getItemViewType(paramInt);
    switch (i)
    {
    default: 
      paramViewGroup = paramView;
    }
    label298:
    label349:
    do
    {
      ImageView localImageView;
      do
      {
        LocalMediaInfo localLocalMediaInfo;
        Object localObject;
        URLDrawable localURLDrawable;
        do
        {
          do
          {
            return paramViewGroup;
            if (paramView == null)
            {
              paramView = this.jdField_a_of_type_AndroidViewLayoutInflater.inflate(2130903981, null);
              paramViewGroup = new gsw(this, null);
              paramViewGroup.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)paramView.findViewById(2131300333));
              paramViewGroup.b = ((ImageView)paramView.findViewById(2131300334));
              paramViewGroup.c = ((ImageView)paramView.findViewById(2131299743));
              paramView.setTag(paramViewGroup);
            }
            for (;;)
            {
              paramView.setLayoutParams(new AbsListView.LayoutParams(this.jdField_a_of_type_ComTencentMobileqqActivityPhotoPhotoListActivity.jdField_a_of_type_Int, this.jdField_a_of_type_ComTencentMobileqqActivityPhotoPhotoListActivity.jdField_b_of_type_Int));
              localImageView = paramViewGroup.jdField_a_of_type_AndroidWidgetImageView;
              localImageView.setAdjustViewBounds(false);
              localLocalMediaInfo = a(paramInt);
              paramView.setContentDescription(a(i, localLocalMediaInfo, paramInt));
              localObject = AlbumUtil.a(localLocalMediaInfo, this.jdField_a_of_type_ComTencentMobileqqActivityPhotoPhotoListActivity.c);
              localURLDrawable = paramViewGroup.jdField_a_of_type_ComTencentImageURLDrawable;
              if ((localURLDrawable == null) || (!localURLDrawable.getURL().equals(localObject)))
              {
                localObject = URLDrawable.getDrawable((URL)localObject, this.jdField_a_of_type_AndroidGraphicsDrawableColorDrawable, this.jdField_a_of_type_AndroidGraphicsDrawableDrawable);
                localImageView.setImageDrawable((Drawable)localObject);
                paramViewGroup.jdField_a_of_type_ComTencentImageURLDrawable = ((URLDrawable)localObject);
                if (localURLDrawable != null) {
                  localURLDrawable.cancelDownload();
                }
              }
              localImageView = paramViewGroup.b;
              paramViewGroup = paramViewGroup.c;
              paramInt = localLocalMediaInfo.jdField_b_of_type_Int;
              if (paramInt != 1) {
                break label298;
              }
              localImageView.setVisibility(0);
              paramViewGroup.setVisibility(0);
              paramViewGroup = paramView;
              if (paramView.getBackground() == null) {
                break;
              }
              paramView.setBackgroundDrawable(null);
              return paramView;
              paramViewGroup = (gsw)paramView.getTag();
            }
            if (paramInt != 3) {
              break label349;
            }
            localImageView.setVisibility(4);
            paramViewGroup.setVisibility(4);
            if (PhotoListActivity.c(this.jdField_a_of_type_ComTencentMobileqqActivityPhotoPhotoListActivity)) {
              break;
            }
            paramViewGroup = paramView;
          } while (paramView.getBackground() != null);
          paramView.setBackgroundResource(2130837625);
          return paramView;
          paramView.setBackgroundDrawable(null);
          return paramView;
          localImageView.setVisibility(4);
          paramViewGroup.setVisibility(4);
          paramViewGroup = paramView;
        } while (paramView.getBackground() == null);
        paramView.setBackgroundDrawable(null);
        return paramView;
        if (paramView == null)
        {
          paramView = this.jdField_a_of_type_AndroidViewLayoutInflater.inflate(2130904063, null);
          paramViewGroup = new gsw(this, null);
          paramViewGroup.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)paramView.findViewById(2131300333));
          paramViewGroup.jdField_a_of_type_AndroidWidgetTextView = ((TextView)paramView.findViewById(2131300669));
          paramViewGroup.b = ((ImageView)paramView.findViewById(2131300334));
          paramViewGroup.c = ((ImageView)paramView.findViewById(2131299743));
          paramView.setTag(paramViewGroup);
        }
        for (;;)
        {
          paramView.setLayoutParams(new AbsListView.LayoutParams(this.jdField_a_of_type_ComTencentMobileqqActivityPhotoPhotoListActivity.jdField_a_of_type_Int, this.jdField_a_of_type_ComTencentMobileqqActivityPhotoPhotoListActivity.jdField_b_of_type_Int));
          localImageView = paramViewGroup.jdField_a_of_type_AndroidWidgetImageView;
          localImageView.setAdjustViewBounds(false);
          localLocalMediaInfo = a(paramInt);
          paramView.setContentDescription(a(i, localLocalMediaInfo, paramInt));
          localObject = AlbumUtil.a(localLocalMediaInfo, this.jdField_a_of_type_ComTencentMobileqqActivityPhotoPhotoListActivity.c);
          localURLDrawable = paramViewGroup.jdField_a_of_type_ComTencentImageURLDrawable;
          if ((localURLDrawable == null) || (!localURLDrawable.getURL().equals(localObject)))
          {
            localObject = URLDrawable.getDrawable((URL)localObject, this.jdField_a_of_type_AndroidGraphicsDrawableColorDrawable, this.jdField_a_of_type_AndroidGraphicsDrawableDrawable);
            ((URLDrawable)localObject).setTag(localLocalMediaInfo);
            localImageView.setImageDrawable((Drawable)localObject);
            paramViewGroup.jdField_a_of_type_ComTencentImageURLDrawable = ((URLDrawable)localObject);
            if (localURLDrawable != null) {
              localURLDrawable.cancelDownload();
            }
          }
          paramViewGroup.jdField_a_of_type_AndroidWidgetTextView.setText(a(localLocalMediaInfo.e));
          localImageView = paramViewGroup.b;
          paramViewGroup = paramViewGroup.c;
          paramInt = localLocalMediaInfo.jdField_b_of_type_Int;
          if (paramInt != 1) {
            break label676;
          }
          localImageView.setVisibility(0);
          paramViewGroup.setVisibility(0);
          paramViewGroup = paramView;
          if (paramView.getBackground() == null) {
            break;
          }
          paramView.setBackgroundDrawable(null);
          return paramView;
          paramViewGroup = (gsw)paramView.getTag();
        }
        if (paramInt != 3) {
          break label727;
        }
        localImageView.setVisibility(4);
        paramViewGroup.setVisibility(4);
        if (PhotoListActivity.c(this.jdField_a_of_type_ComTencentMobileqqActivityPhotoPhotoListActivity)) {
          break;
        }
        paramViewGroup = paramView;
      } while (paramView.getBackground() != null);
      paramView.setBackgroundResource(2130837625);
      return paramView;
      paramView.setBackgroundDrawable(null);
      return paramView;
      localImageView.setVisibility(4);
      paramViewGroup.setVisibility(4);
      paramViewGroup = paramView;
    } while (paramView.getBackground() == null);
    label676:
    label727:
    paramView.setBackgroundDrawable(null);
    return paramView;
  }
  
  public int getViewTypeCount()
  {
    return PhotoListActivity.b();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\classes.jar
 * Qualified Name:     gsv
 * JD-Core Version:    0.7.0.1
 */