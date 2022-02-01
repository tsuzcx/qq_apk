package com.tencent.mobileqq.troop.data;

import android.app.Activity;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.view.LayoutInflater;
import android.view.View;
import com.tencent.image.URLDrawableDownListener.Adapter;
import com.tencent.mobileqq.data.TroopBarAbsDataEntity;
import kjf;

public abstract class TroopBarPostAbsLayout
{
  protected Drawable a;
  protected URLDrawableDownListener.Adapter a;
  
  public TroopBarPostAbsLayout()
  {
    this.jdField_a_of_type_AndroidGraphicsDrawableDrawable = new ColorDrawable(0);
    this.jdField_a_of_type_ComTencentImageURLDrawableDownListener$Adapter = new kjf(this);
  }
  
  public abstract View a(Activity paramActivity, LayoutInflater paramLayoutInflater, View paramView, TroopBarAbsDataEntity paramTroopBarAbsDataEntity);
  
  public abstract TroopBarPostAbsLayout.AbsItemViewHolder a(View paramView);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     com.tencent.mobileqq.troop.data.TroopBarPostAbsLayout
 * JD-Core Version:    0.7.0.1
 */