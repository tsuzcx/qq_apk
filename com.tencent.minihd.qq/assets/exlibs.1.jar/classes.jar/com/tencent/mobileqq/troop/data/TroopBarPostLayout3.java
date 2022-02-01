package com.tencent.mobileqq.troop.data;

import android.app.Activity;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.drawable.ColorDrawable;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.tencent.image.URLDrawable;
import com.tencent.image.URLImageView;
import com.tencent.mobileqq.data.TroopBarAbsDataEntity;
import com.tencent.mobileqq.data.TroopBarPageEntity;
import com.tencent.mobileqq.data.TroopBarPostContentEntity;
import com.tencent.mobileqq.data.TroopBarPostContentEntity.Pic_list;
import com.tencent.mobileqq.data.TroopBarPostEntity;
import com.tencent.mobileqq.troop.utils.TroopBarUtils;
import java.util.ArrayList;
import kji;

public class TroopBarPostLayout3
  extends TroopBarPostAbsLayout
  implements View.OnClickListener
{
  protected static final int a = 2130903562;
  
  public View a(Activity paramActivity, LayoutInflater paramLayoutInflater, View paramView, TroopBarAbsDataEntity paramTroopBarAbsDataEntity)
  {
    kji localkji;
    if (paramView == null)
    {
      paramView = paramLayoutInflater.inflate(2130903562, null);
      localkji = (kji)a(paramView);
      paramView.setTag(localkji);
    }
    for (;;)
    {
      paramTroopBarAbsDataEntity = (TroopBarPostEntity)paramTroopBarAbsDataEntity;
      localkji.jdField_a_of_type_AndroidWidgetTextView.setText(paramTroopBarAbsDataEntity.title);
      Resources localResources = paramActivity.getResources();
      TroopBarUtils.a(localResources, paramLayoutInflater, localkji.jdField_b_of_type_AndroidWidgetLinearLayout, paramTroopBarAbsDataEntity.getIconListEntitys());
      label107:
      ColorDrawable localColorDrawable;
      if (paramTroopBarAbsDataEntity.contentBytes != null)
      {
        paramLayoutInflater = paramTroopBarAbsDataEntity.getContentEntity();
        if (paramLayoutInflater != null)
        {
          if ((paramLayoutInflater.pic_lists != null) && (!paramLayoutInflater.pic_lists.isEmpty())) {
            break label380;
          }
          paramActivity = null;
          localColorDrawable = new ColorDrawable(-1710619);
          if ((paramActivity == null) || (TextUtils.isEmpty(paramActivity.url))) {
            break label395;
          }
        }
      }
      try
      {
        localkji.jdField_a_of_type_AndroidWidgetImageView.setImageDrawable(URLDrawable.getDrawable(paramActivity.url, localColorDrawable, localColorDrawable));
        label151:
        if ((!TextUtils.isEmpty(paramTroopBarAbsDataEntity.subscript_addr)) && (!TextUtils.isEmpty(TroopBarPageEntity.sPostCornerImgPrefix))) {}
        try
        {
          localkji.jdField_a_of_type_ComTencentImageURLImageView.setURLDrawableDownListener(this.jdField_a_of_type_ComTencentImageURLDrawableDownListener$Adapter);
          localkji.jdField_a_of_type_ComTencentImageURLImageView.setImageDrawable(URLDrawable.getDrawable(TroopBarPageEntity.sPostCornerImgPrefix + paramTroopBarAbsDataEntity.subscript_addr, this.jdField_a_of_type_AndroidGraphicsDrawableDrawable, this.jdField_a_of_type_AndroidGraphicsDrawableDrawable));
          label226:
          localkji.jdField_b_of_type_AndroidWidgetTextView.setText(paramLayoutInflater.price);
          localkji.c.setText(paramLayoutInflater.time);
          if (!TextUtils.isEmpty(paramLayoutInflater.addr))
          {
            localkji.d.setVisibility(0);
            localkji.d.setText(paramLayoutInflater.addr);
          }
          for (;;)
          {
            paramActivity = localResources.getString(2131363860, new Object[] { TroopBarUtils.a(paramTroopBarAbsDataEntity.subscribers) });
            paramLayoutInflater = localResources.getString(2131363859, new Object[] { TroopBarUtils.a(paramTroopBarAbsDataEntity.total_comment) });
            localkji.e.setText(paramActivity);
            localkji.f.setText(paramLayoutInflater);
            localkji.jdField_a_of_type_AndroidWidgetLinearLayout.setTag(2131296417, paramTroopBarAbsDataEntity);
            localkji.jdField_a_of_type_AndroidWidgetLinearLayout.setOnClickListener(this);
            return paramView;
            localkji = (kji)paramView.getTag();
            break;
            label380:
            paramActivity = (TroopBarPostContentEntity.Pic_list)paramLayoutInflater.pic_lists.get(0);
            break label107;
            label395:
            localkji.jdField_a_of_type_AndroidWidgetImageView.setImageDrawable(localColorDrawable);
            break label151;
            localkji.d.setVisibility(4);
          }
        }
        catch (Exception paramActivity)
        {
          break label226;
        }
      }
      catch (Exception paramActivity)
      {
        break label151;
      }
    }
  }
  
  public TroopBarPostAbsLayout.AbsItemViewHolder a(View paramView)
  {
    return new kji(this, paramView);
  }
  
  public void onClick(View paramView)
  {
    switch (paramView.getId())
    {
    }
    Context localContext;
    do
    {
      return;
      localContext = paramView.getContext();
      paramView = paramView.getTag(2131296417);
    } while ((localContext == null) || (!(paramView instanceof TroopBarPostEntity)));
    paramView = (TroopBarPostEntity)paramView;
    TroopBarPostLayout1.a(localContext, paramView.bid, paramView.id, paramView.type);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     com.tencent.mobileqq.troop.data.TroopBarPostLayout3
 * JD-Core Version:    0.7.0.1
 */