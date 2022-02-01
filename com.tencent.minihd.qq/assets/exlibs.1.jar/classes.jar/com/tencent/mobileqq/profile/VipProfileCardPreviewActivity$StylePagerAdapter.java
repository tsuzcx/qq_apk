package com.tencent.mobileqq.profile;

import android.annotation.TargetApi;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.os.Build.VERSION;
import android.support.v4.view.PagerAdapter;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.widget.ImageView.ScaleType;
import android.widget.RelativeLayout.LayoutParams;
import com.tencent.mobileqq.widget.ProfileCardScrollImageView;
import com.tencent.qphone.base.util.QLog;
import java.util.List;

public class VipProfileCardPreviewActivity$StylePagerAdapter
  extends PagerAdapter
{
  public Context a;
  public LayoutInflater a;
  
  public VipProfileCardPreviewActivity$StylePagerAdapter(VipProfileCardPreviewActivity paramVipProfileCardPreviewActivity, Context paramContext)
  {
    this.jdField_a_of_type_AndroidContentContext = paramContext;
    this.jdField_a_of_type_AndroidViewLayoutInflater = LayoutInflater.from(this.jdField_a_of_type_AndroidContentContext);
  }
  
  public void destroyItem(ViewGroup paramViewGroup, int paramInt, Object paramObject)
  {
    if (QLog.isColorLevel()) {
      QLog.d("ProfileCard.VipProfileCardPreviewActivity", 2, "destroyItem, pos = " + paramInt);
    }
    paramObject = (View)paramObject;
    VipProfileCardPreviewActivity.StylePagerAdapter.ViewHolder localViewHolder = (VipProfileCardPreviewActivity.StylePagerAdapter.ViewHolder)paramObject.getTag();
    paramViewGroup.removeView(paramObject);
  }
  
  public int getCount()
  {
    return this.jdField_a_of_type_ComTencentMobileqqProfileVipProfileCardPreviewActivity.jdField_a_of_type_JavaUtilList.size();
  }
  
  @TargetApi(16)
  public Object instantiateItem(ViewGroup paramViewGroup, int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.d("ProfileCard.VipProfileCardPreviewActivity", 2, "instantiateItem, pos = " + paramInt);
    }
    View localView = this.jdField_a_of_type_AndroidViewLayoutInflater.inflate(2130904129, paramViewGroup, false);
    VipProfileCardPreviewActivity.StylePagerAdapter.ViewHolder localViewHolder = new VipProfileCardPreviewActivity.StylePagerAdapter.ViewHolder(this);
    localViewHolder.a = ((ProfileCardScrollImageView)localView.findViewById(2131300966));
    localView.setTag(localViewHolder);
    localViewHolder.a.setScaleType(ImageView.ScaleType.FIT_XY);
    Object localObject = (RelativeLayout.LayoutParams)localViewHolder.a.getLayoutParams();
    ((RelativeLayout.LayoutParams)localObject).width = this.jdField_a_of_type_ComTencentMobileqqProfileVipProfileCardPreviewActivity.ax;
    ((RelativeLayout.LayoutParams)localObject).height = this.jdField_a_of_type_ComTencentMobileqqProfileVipProfileCardPreviewActivity.aw;
    localViewHolder.a.setLayoutParams((ViewGroup.LayoutParams)localObject);
    if (Build.VERSION.SDK_INT >= 16) {
      localViewHolder.a.setBackground(this.jdField_a_of_type_ComTencentMobileqqProfileVipProfileCardPreviewActivity.jdField_a_of_type_AndroidGraphicsDrawableDrawable);
    }
    for (;;)
    {
      localObject = this.jdField_a_of_type_AndroidContentContext.getResources().getDrawable(2130840878);
      localViewHolder.a.setImageDrawable((Drawable)localObject);
      localView.setId(paramInt);
      localObject = (ProfileCardTemplateInfo)this.jdField_a_of_type_ComTencentMobileqqProfileVipProfileCardPreviewActivity.jdField_a_of_type_JavaUtilList.get(paramInt);
      paramViewGroup.addView(localView);
      this.jdField_a_of_type_ComTencentMobileqqProfileVipProfileCardPreviewActivity.a(localViewHolder, (ProfileCardTemplateInfo)localObject, paramInt);
      return localView;
      localViewHolder.a.setBackgroundDrawable(this.jdField_a_of_type_ComTencentMobileqqProfileVipProfileCardPreviewActivity.jdField_a_of_type_AndroidGraphicsDrawableDrawable);
    }
  }
  
  public boolean isViewFromObject(View paramView, Object paramObject)
  {
    return paramView == paramObject;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     com.tencent.mobileqq.profile.VipProfileCardPreviewActivity.StylePagerAdapter
 * JD-Core Version:    0.7.0.1
 */