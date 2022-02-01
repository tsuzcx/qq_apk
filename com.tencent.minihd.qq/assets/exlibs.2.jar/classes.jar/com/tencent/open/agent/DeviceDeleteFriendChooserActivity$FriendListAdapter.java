package com.tencent.open.agent;

import android.graphics.Bitmap;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.tencent.open.agent.datamodel.Friend;
import com.tencent.open.agent.datamodel.ImageLoader;
import com.tencent.open.agent.datamodel.QZonePortraitData;
import java.util.ArrayList;

public class DeviceDeleteFriendChooserActivity$FriendListAdapter
  extends BaseAdapter
{
  protected DeviceDeleteFriendChooserActivity$FriendListAdapter(DeviceDeleteFriendChooserActivity paramDeviceDeleteFriendChooserActivity) {}
  
  public int getCount()
  {
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
      paramView = this.a.jdField_a_of_type_AndroidViewLayoutInflater.inflate(2130903271, paramViewGroup, false);
      paramViewGroup = new DeviceFriendListOpenFrame.ViewHolder();
      paramViewGroup.c = ((RelativeLayout)paramView.findViewById(2131297504));
      paramViewGroup.e = ((TextView)paramView.findViewById(2131297503));
      paramViewGroup.jdField_a_of_type_AndroidWidgetCheckBox = ((CheckBox)paramView.findViewById(2131297505));
      paramViewGroup.b = ((ImageView)paramView.findViewById(2131296551));
      paramViewGroup.f = ((TextView)paramView.findViewById(2131296582));
      paramView.setTag(paramViewGroup);
    }
    while ((this.a.jdField_a_of_type_JavaUtilArrayList == null) || (this.a.jdField_a_of_type_JavaUtilArrayList.size() == 0))
    {
      return null;
      paramViewGroup = (DeviceFriendListOpenFrame.ViewHolder)paramView.getTag();
    }
    Friend localFriend = (Friend)this.a.jdField_a_of_type_JavaUtilArrayList.get(paramInt);
    if ((localFriend.d == null) || ("".equals(localFriend.d))) {
      localFriend.d = QZonePortraitData.a(this.a.d, localFriend.jdField_a_of_type_JavaLangString);
    }
    paramViewGroup.jdField_a_of_type_JavaLangString = localFriend.d;
    paramViewGroup.c.setVisibility(0);
    paramViewGroup.e.setVisibility(8);
    paramViewGroup.jdField_a_of_type_AndroidWidgetCheckBox.setChecked(this.a.jdField_a_of_type_ArrayOfBoolean[paramInt]);
    Bitmap localBitmap = ImageLoader.a().a(localFriend.d);
    if (localBitmap == null)
    {
      paramViewGroup.b.setImageResource(2130838406);
      ImageLoader.a().a(localFriend.d, this.a);
    }
    while ((localFriend.c == null) || ("".equals(localFriend.c)))
    {
      paramViewGroup.f.setText(localFriend.b);
      return paramView;
      paramViewGroup.b.setImageBitmap(localBitmap);
    }
    paramViewGroup.f.setText(localFriend.c);
    return paramView;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.2.jar\classes.jar
 * Qualified Name:     com.tencent.open.agent.DeviceDeleteFriendChooserActivity.FriendListAdapter
 * JD-Core Version:    0.7.0.1
 */