package com.tencent.open.agent;

import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.open.agent.datamodel.Friend;
import com.tencent.open.agent.datamodel.ImageLoader;
import com.tencent.open.agent.datamodel.QZonePortraitData;
import java.util.ArrayList;

public class SmartHardwareActivity$FriendListAdapter
  extends BaseAdapter
{
  protected SmartHardwareActivity$FriendListAdapter(SmartHardwareActivity paramSmartHardwareActivity) {}
  
  public int getCount()
  {
    if (this.a.jdField_a_of_type_JavaUtilArrayList.size() < 20) {
      return this.a.jdField_a_of_type_JavaUtilArrayList.size() + 1;
    }
    return this.a.jdField_a_of_type_JavaUtilArrayList.size();
  }
  
  public Object getItem(int paramInt)
  {
    int i = this.a.jdField_a_of_type_JavaUtilArrayList.size();
    if ((this.a.jdField_a_of_type_JavaUtilArrayList == null) || (i == 0) || (paramInt >= i)) {
      return null;
    }
    return this.a.jdField_a_of_type_JavaUtilArrayList.get(paramInt);
  }
  
  public long getItemId(int paramInt)
  {
    return paramInt;
  }
  
  public View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    if (paramView == null)
    {
      paramView = this.a.jdField_a_of_type_AndroidViewLayoutInflater.inflate(2130903263, paramViewGroup, false);
      paramViewGroup = new SmartHardwareActivity.ViewHolder();
      paramViewGroup.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)paramView.findViewById(2131296551));
      paramViewGroup.jdField_a_of_type_AndroidWidgetTextView = ((TextView)paramView.findViewById(2131296582));
      paramView.setTag(paramViewGroup);
    }
    while (this.a.jdField_a_of_type_JavaUtilArrayList == null)
    {
      return null;
      paramViewGroup = (SmartHardwareActivity.ViewHolder)paramView.getTag();
    }
    paramView.setVisibility(0);
    if ((this.a.jdField_a_of_type_JavaUtilArrayList.size() < 20) && (paramInt == getCount() - 1))
    {
      if (getCount() > 20)
      {
        paramView.setVisibility(8);
        return paramView;
      }
      localObject = this.a.getString(2131368106);
      paramViewGroup.jdField_a_of_type_AndroidWidgetTextView.setText((CharSequence)localObject);
      paramViewGroup.jdField_a_of_type_AndroidWidgetTextView.setTextColor(this.a.getResources().getColor(2131427938));
      paramViewGroup.jdField_a_of_type_AndroidWidgetImageView.setAlpha(255);
      paramViewGroup.jdField_a_of_type_AndroidWidgetImageView.setImageResource(2130838032);
      paramViewGroup.jdField_a_of_type_AndroidWidgetImageView.setTag(localObject);
      return paramView;
    }
    paramViewGroup.jdField_a_of_type_AndroidWidgetImageView.setImageResource(2130840087);
    paramViewGroup.jdField_a_of_type_AndroidWidgetTextView.setTextColor(this.a.getResources().getColor(2131427934));
    Object localObject = (Friend)this.a.jdField_a_of_type_JavaUtilArrayList.get(paramInt);
    if ((((Friend)localObject).d == null) || ("".equals(((Friend)localObject).d))) {
      ((Friend)localObject).d = QZonePortraitData.a(this.a.b, ((Friend)localObject).jdField_a_of_type_JavaLangString);
    }
    paramViewGroup.jdField_a_of_type_JavaLangString = ((Friend)localObject).d;
    Bitmap localBitmap = ImageLoader.a().a(((Friend)localObject).d);
    if (localBitmap == null)
    {
      paramViewGroup.jdField_a_of_type_AndroidWidgetImageView.setImageResource(2130838406);
      ImageLoader.a().a(((Friend)localObject).d, this.a);
      if (((Friend)localObject).jdField_a_of_type_Int != 2) {
        break label434;
      }
      if (paramViewGroup.jdField_a_of_type_AndroidWidgetImageView.getBackground() == null) {
        break label422;
      }
      paramViewGroup.jdField_a_of_type_AndroidWidgetImageView.getBackground().setAlpha(100);
    }
    for (;;)
    {
      if ((((Friend)localObject).c == null) || ("".equals(((Friend)localObject).c)))
      {
        if (!TextUtils.isEmpty(((Friend)localObject).b))
        {
          paramViewGroup.jdField_a_of_type_AndroidWidgetTextView.setText(((Friend)localObject).b);
          return paramView;
          paramViewGroup.jdField_a_of_type_AndroidWidgetImageView.setImageBitmap(localBitmap);
          break;
          label422:
          paramViewGroup.jdField_a_of_type_AndroidWidgetImageView.setAlpha(100);
          continue;
          label434:
          if (paramViewGroup.jdField_a_of_type_AndroidWidgetImageView.getBackground() != null)
          {
            paramViewGroup.jdField_a_of_type_AndroidWidgetImageView.getBackground().setAlpha(255);
            continue;
          }
          paramViewGroup.jdField_a_of_type_AndroidWidgetImageView.setAlpha(255);
          continue;
        }
        paramViewGroup.jdField_a_of_type_AndroidWidgetTextView.setText("failed");
        return paramView;
      }
    }
    paramViewGroup.jdField_a_of_type_AndroidWidgetTextView.setText(((Friend)localObject).c);
    return paramView;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.2.jar\classes.jar
 * Qualified Name:     com.tencent.open.agent.SmartHardwareActivity.FriendListAdapter
 * JD-Core Version:    0.7.0.1
 */