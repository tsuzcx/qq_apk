package com.tencent.mobileqq.activity;

import android.content.Context;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.mobileqq.adapter.FacePreloadBaseAdapter;
import com.tencent.mobileqq.adapter.FacePreloadBaseAdapter.FaceInfo;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.Stranger;
import com.tencent.widget.XListView;
import fch;
import java.util.ArrayList;

public class StrangerManageActivity$StrangeManagerListAdapter
  extends FacePreloadBaseAdapter
{
  public static final String a = "  ";
  String b;
  
  public StrangerManageActivity$StrangeManagerListAdapter(StrangerManageActivity paramStrangerManageActivity, Context paramContext, QQAppInterface paramQQAppInterface, XListView paramXListView)
  {
    super(paramContext, paramQQAppInterface, paramXListView, 1, true);
    this.jdField_b_of_type_JavaLangString = paramContext.getString(2131366575);
  }
  
  protected Object a(int paramInt)
  {
    Stranger localStranger = (Stranger)this.a.jdField_a_of_type_JavaUtilArrayList.get(paramInt);
    if (localStranger == null) {
      return null;
    }
    FacePreloadBaseAdapter.FaceInfo localFaceInfo = new FacePreloadBaseAdapter.FaceInfo(this);
    localFaceInfo.jdField_a_of_type_JavaLangString = localStranger.uin;
    localFaceInfo.jdField_a_of_type_Int = 1;
    return localFaceInfo;
  }
  
  public String a(Stranger paramStranger)
  {
    if (paramStranger == null) {
      return "";
    }
    StringBuilder localStringBuilder = new StringBuilder();
    if (TextUtils.isEmpty(paramStranger.name))
    {
      localStringBuilder.append(paramStranger.uin);
      if (!TextUtils.isEmpty(paramStranger.remark)) {
        localStringBuilder.append(" " + paramStranger.remark);
      }
      switch (paramStranger.gender)
      {
      default: 
        label96:
        localStringBuilder.append(" " + paramStranger.age + "岁");
        if (!TextUtils.isEmpty(paramStranger.groupName)) {
          localStringBuilder.append(" " + paramStranger.groupName);
        }
        if (!TextUtils.isEmpty(paramStranger.login)) {
          localStringBuilder.append(" " + paramStranger.login);
        }
        if (this.a.jdField_a_of_type_Boolean)
        {
          if (!paramStranger.uiSelected) {
            break label263;
          }
          localStringBuilder.append(" 已选择");
        }
        break;
      }
    }
    for (;;)
    {
      return localStringBuilder.toString();
      localStringBuilder.append(paramStranger.name);
      break;
      localStringBuilder.append(" 男");
      break label96;
      localStringBuilder.append(" 女");
      break label96;
      label263:
      localStringBuilder.append(" 未选择");
    }
  }
  
  public int getCount()
  {
    return this.a.jdField_a_of_type_JavaUtilArrayList.size();
  }
  
  public Object getItem(int paramInt)
  {
    return this.a.jdField_a_of_type_JavaUtilArrayList.get(paramInt);
  }
  
  public long getItemId(int paramInt)
  {
    return paramInt;
  }
  
  public View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    Stranger localStranger = (Stranger)this.a.jdField_a_of_type_JavaUtilArrayList.get(paramInt);
    if (paramView == null)
    {
      paramView = LayoutInflater.from(paramViewGroup.getContext()).inflate(2130903629, null);
      paramViewGroup = new fch();
      paramViewGroup.d = ((ImageView)paramView.findViewById(2131296551));
      paramViewGroup.jdField_a_of_type_AndroidWidgetTextView = ((TextView)paramView.findViewById(16908308));
      paramViewGroup.jdField_b_of_type_AndroidWidgetImageView = ((ImageView)paramView.findViewById(2131297505));
      paramViewGroup.c = ((TextView)paramView.findViewById(2131298883));
      paramViewGroup.jdField_b_of_type_AndroidWidgetTextView = ((TextView)paramView.findViewById(2131299005));
      paramViewGroup.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)paramView.findViewById(2131299004));
      paramView.setTag(paramViewGroup);
      paramView.setOnClickListener(this.a);
      paramViewGroup.jdField_a_of_type_Long = localStranger.time;
      paramViewGroup.jdField_b_of_type_JavaLangString = localStranger.uin;
      paramViewGroup.jdField_a_of_type_Int = paramInt;
      if (!TextUtils.isEmpty(localStranger.name)) {
        break label430;
      }
      paramViewGroup.jdField_a_of_type_AndroidWidgetTextView.setText(localStranger.uin);
      label179:
      paramViewGroup.d.setImageBitmap(a(1, localStranger.uin));
      if (!this.a.jdField_a_of_type_Boolean) {
        break label445;
      }
      paramViewGroup.jdField_b_of_type_AndroidWidgetImageView.setVisibility(0);
      label214:
      if (!localStranger.uiSelected) {
        break label457;
      }
      paramViewGroup.jdField_b_of_type_AndroidWidgetImageView.setImageResource(2130838502);
      label231:
      if (!TextUtils.isEmpty(localStranger.remark)) {
        break label469;
      }
      paramViewGroup.c.setVisibility(8);
      paramViewGroup.c.setText("");
      label260:
      switch (localStranger.gender)
      {
      default: 
        paramViewGroup.jdField_a_of_type_AndroidWidgetImageView.setVisibility(8);
      }
    }
    for (;;)
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append(localStranger.age);
      localStringBuilder.append(this.jdField_b_of_type_JavaLangString);
      localStringBuilder.append("  ");
      if (!TextUtils.isEmpty(localStranger.groupName))
      {
        localStringBuilder.append(localStranger.groupName);
        localStringBuilder.append("  ");
      }
      if (!TextUtils.isEmpty(localStranger.login)) {
        localStringBuilder.append(localStranger.login);
      }
      paramViewGroup.jdField_b_of_type_AndroidWidgetTextView.setText(localStringBuilder.toString());
      paramView.setContentDescription(a(localStranger));
      this.a.a(paramViewGroup);
      return paramView;
      paramViewGroup = (fch)paramView.getTag();
      break;
      label430:
      paramViewGroup.jdField_a_of_type_AndroidWidgetTextView.setText(localStranger.name);
      break label179;
      label445:
      paramViewGroup.jdField_b_of_type_AndroidWidgetImageView.setVisibility(8);
      break label214;
      label457:
      paramViewGroup.jdField_b_of_type_AndroidWidgetImageView.setImageResource(2130838500);
      break label231;
      label469:
      paramViewGroup.c.setVisibility(0);
      paramViewGroup.c.setText("(" + localStranger.remark + ")");
      break label260;
      paramViewGroup.jdField_a_of_type_AndroidWidgetImageView.setVisibility(0);
      paramViewGroup.jdField_a_of_type_AndroidWidgetImageView.setImageResource(2130841585);
      continue;
      paramViewGroup.jdField_a_of_type_AndroidWidgetImageView.setVisibility(0);
      paramViewGroup.jdField_a_of_type_AndroidWidgetImageView.setImageResource(2130841576);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.2.jar\classes.jar
 * Qualified Name:     com.tencent.mobileqq.activity.StrangerManageActivity.StrangeManagerListAdapter
 * JD-Core Version:    0.7.0.1
 */