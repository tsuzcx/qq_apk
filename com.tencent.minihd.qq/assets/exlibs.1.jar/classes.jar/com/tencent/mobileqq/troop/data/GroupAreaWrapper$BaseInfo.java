package com.tencent.mobileqq.troop.data;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.ImageView.ScaleType;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.tencent.image.URLDrawable;
import com.tencent.mobileqq.activity.QQBrowserActivity;
import com.tencent.mobileqq.activity.aio.AIOUtils;
import com.tencent.mobileqq.app.QQAppInterface;
import java.io.Serializable;
import java.text.DecimalFormat;

public abstract class GroupAreaWrapper$BaseInfo
  implements View.OnClickListener, Serializable
{
  public String address;
  public QQAppInterface app;
  public String desc;
  public String desc_url;
  public int distance;
  public String image_url;
  public boolean isShowZeroDistance = true;
  public int number;
  public String title;
  public String title_url;
  public String type;
  
  public View createView(Context paramContext, ViewGroup paramViewGroup)
  {
    paramContext = LayoutInflater.from(paramContext).inflate(2130903530, paramViewGroup, false);
    paramViewGroup = new NearbyTroops.ActivityAndTopicViewHolder();
    paramViewGroup.a = ((TextView)paramContext.findViewById(2131298664));
    paramViewGroup.jdField_b_of_type_AndroidWidgetTextView = ((TextView)paramContext.findViewById(2131298666));
    paramViewGroup.c = ((TextView)paramContext.findViewById(2131298670));
    paramViewGroup.d = ((TextView)paramContext.findViewById(2131298671));
    paramViewGroup.e = ((TextView)paramContext.findViewById(2131298672));
    paramViewGroup.jdField_b_of_type_AndroidWidgetImageView = ((ImageView)paramContext.findViewById(2131298668));
    paramContext.setTag(paramViewGroup);
    initUI(paramContext);
    return paramContext;
  }
  
  public void fillView(View paramView)
  {
    NearbyTroops.ActivityAndTopicViewHolder localActivityAndTopicViewHolder = (NearbyTroops.ActivityAndTopicViewHolder)paramView.getTag();
    localActivityAndTopicViewHolder.a.setText(this.type);
    localActivityAndTopicViewHolder.jdField_b_of_type_AndroidWidgetTextView.setText(this.desc);
    localActivityAndTopicViewHolder.c.setText(this.title);
    DecimalFormat localDecimalFormat = new DecimalFormat("#.#");
    Object localObject = "";
    if ((this.isShowZeroDistance) || (this.distance > 0))
    {
      if (this.distance < 100) {
        break label264;
      }
      localObject = localDecimalFormat.format(Math.ceil(this.distance / 50) * 0.05D) + "km";
    }
    for (;;)
    {
      localActivityAndTopicViewHolder.d.setText(this.address + " " + (String)localObject);
      localActivityAndTopicViewHolder.d.setCompoundDrawablePadding(8);
      localActivityAndTopicViewHolder.d.setCompoundDrawablesWithIntrinsicBounds(2130839126, 0, 0, 0);
      setNumberText(localActivityAndTopicViewHolder.e);
      localActivityAndTopicViewHolder.jdField_b_of_type_AndroidWidgetImageView.setScaleType(ImageView.ScaleType.CENTER);
      try
      {
        int i = AIOUtils.a(70.0F, paramView.getResources());
        localActivityAndTopicViewHolder.jdField_b_of_type_AndroidWidgetImageView.setImageDrawable(URLDrawable.getDrawable(this.image_url, i, i));
        localObject = (RelativeLayout)paramView.findViewById(2131298663);
        if (localObject != null) {
          ((RelativeLayout)localObject).setOnClickListener(this);
        }
        paramView = (RelativeLayout)paramView.findViewById(2131298667);
        if (paramView != null) {
          paramView.setOnClickListener(this);
        }
        return;
        label264:
        localObject = "0.1km";
      }
      catch (IllegalArgumentException localIllegalArgumentException)
      {
        for (;;)
        {
          localIllegalArgumentException.printStackTrace();
        }
      }
    }
  }
  
  protected abstract void initUI(View paramView);
  
  public void onClick(View paramView)
  {
    int i = paramView.getId();
    if (i == 2131298663)
    {
      localIntent = new Intent(paramView.getContext(), QQBrowserActivity.class);
      localIntent.putExtra("url", this.title_url);
      localIntent.putExtra("hide_operation_bar", true);
      localIntent.putExtra("hide_more_button", true);
      paramView.getContext().startActivity(localIntent);
    }
    while (i != 2131298667) {
      return;
    }
    Intent localIntent = new Intent(paramView.getContext(), QQBrowserActivity.class);
    localIntent.putExtra("url", this.desc_url);
    localIntent.putExtra("hide_operation_bar", true);
    localIntent.putExtra("hide_more_button", true);
    paramView.getContext().startActivity(localIntent);
  }
  
  protected abstract void setNumberText(TextView paramTextView);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     com.tencent.mobileqq.troop.data.GroupAreaWrapper.BaseInfo
 * JD-Core Version:    0.7.0.1
 */