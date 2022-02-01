package com.tencent.mobileqq.activity.aio.rebuild;

import android.content.Context;
import android.content.res.Resources;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.ImageView.ScaleType;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import com.tencent.mobileqq.activity.aio.AIOUtils;
import com.tencent.mobileqq.activity.aio.InputLinearLayout;
import com.tencent.mobileqq.activity.aio.anim.AIOAnimationConatiner;
import com.tencent.mobileqq.bubble.ChatXListView;
import com.tencent.widget.XEditTextEx;
import com.tencent.widget.XPanelContainer;

public class ChatLayoutFactory
{
  public static View a(Context paramContext)
  {
    Object localObject2 = paramContext.getResources();
    XPanelContainer localXPanelContainer = new XPanelContainer(paramContext);
    localXPanelContainer.setId(2131296742);
    localXPanelContainer.setLayoutParams(new ViewGroup.LayoutParams(-1, -1));
    Object localObject1 = new RelativeLayout(paramContext);
    ((RelativeLayout)localObject1).setLayoutParams(new ViewGroup.LayoutParams(-1, -1));
    ((RelativeLayout)localObject1).setId(2131297026);
    localXPanelContainer.addView((View)localObject1);
    Object localObject3 = new InputLinearLayout(paramContext);
    ((InputLinearLayout)localObject3).setId(2131297027);
    Object localObject4 = new RelativeLayout.LayoutParams(-1, -1);
    ((RelativeLayout.LayoutParams)localObject4).height = -2;
    ((RelativeLayout.LayoutParams)localObject4).addRule(12);
    ((InputLinearLayout)localObject3).setLayoutParams((ViewGroup.LayoutParams)localObject4);
    ((InputLinearLayout)localObject3).setGravity(17);
    ((InputLinearLayout)localObject3).setMinimumHeight(AIOUtils.a(50.0F, (Resources)localObject2));
    ((InputLinearLayout)localObject3).setOrientation(0);
    ((InputLinearLayout)localObject3).setBackgroundResource(2130841714);
    ((RelativeLayout)localObject1).addView((View)localObject3);
    localObject4 = new View(paramContext);
    ((View)localObject4).setId(2131297028);
    LinearLayout.LayoutParams localLayoutParams = new LinearLayout.LayoutParams(-1, -1);
    localLayoutParams.height = 0;
    localLayoutParams.width = 0;
    ((View)localObject4).setLayoutParams(localLayoutParams);
    ((InputLinearLayout)localObject3).addView((View)localObject4);
    localObject4 = new ImageButton(paramContext);
    ((ImageButton)localObject4).setId(2131297032);
    localLayoutParams = new LinearLayout.LayoutParams(-1, -1);
    localLayoutParams.width = AIOUtils.a(34.0F, (Resources)localObject2);
    localLayoutParams.height = AIOUtils.a(34.0F, (Resources)localObject2);
    localLayoutParams.leftMargin = AIOUtils.a(4.0F, (Resources)localObject2);
    localLayoutParams.rightMargin = AIOUtils.a(3.0F, (Resources)localObject2);
    localLayoutParams.bottomMargin = AIOUtils.a(8.0F, (Resources)localObject2);
    localLayoutParams.gravity = 80;
    ((ImageButton)localObject4).setLayoutParams(localLayoutParams);
    ((ImageButton)localObject4).setBackgroundResource(2130842210);
    ((ImageButton)localObject4).setImageResource(2130841082);
    ((ImageButton)localObject4).setPadding(0, AIOUtils.a(1.0F, (Resources)localObject2), 0, 0);
    ((ImageButton)localObject4).setContentDescription("选择表情面板");
    ((InputLinearLayout)localObject3).addView((View)localObject4);
    localObject4 = new ImageButton(paramContext);
    ((ImageButton)localObject4).setId(2131297033);
    localLayoutParams = new LinearLayout.LayoutParams(-1, -1);
    localLayoutParams.width = AIOUtils.a(34.0F, (Resources)localObject2);
    localLayoutParams.height = AIOUtils.a(34.0F, (Resources)localObject2);
    localLayoutParams.rightMargin = AIOUtils.a(3.0F, (Resources)localObject2);
    localLayoutParams.bottomMargin = AIOUtils.a(8.0F, (Resources)localObject2);
    localLayoutParams.gravity = 80;
    ((ImageButton)localObject4).setLayoutParams(localLayoutParams);
    ((ImageButton)localObject4).setBackgroundResource(2130842210);
    ((ImageButton)localObject4).setImageResource(2130837573);
    ((ImageButton)localObject4).setPadding(0, AIOUtils.a(1.0F, (Resources)localObject2), 0, 0);
    ((ImageButton)localObject4).setContentDescription("发照片等功能面板");
    ((InputLinearLayout)localObject3).addView((View)localObject4);
    localObject4 = new XEditTextEx(paramContext);
    ((XEditTextEx)localObject4).setId(2131297030);
    localLayoutParams = new LinearLayout.LayoutParams(-1, -1);
    localLayoutParams.width = AIOUtils.a(206.0F, (Resources)localObject2);
    localLayoutParams.height = -2;
    localLayoutParams.topMargin = AIOUtils.a(8.0F, (Resources)localObject2);
    localLayoutParams.bottomMargin = AIOUtils.a(8.0F, (Resources)localObject2);
    localLayoutParams.weight = 1.0F;
    ((XEditTextEx)localObject4).setLayoutParams(localLayoutParams);
    ((XEditTextEx)localObject4).setBackgroundResource(2130841717);
    ((XEditTextEx)localObject4).setContentDescription("文本框  连按两次来编辑");
    ((XEditTextEx)localObject4).setInputType(131073);
    ((XEditTextEx)localObject4).setMaxLines(5);
    ((XEditTextEx)localObject4).setTextColor(((Resources)localObject2).getColor(2131427985));
    ((XEditTextEx)localObject4).setShadowLayer(1.0F, 0.0F, 1.0F, ((Resources)localObject2).getColor(2131427526));
    ((XEditTextEx)localObject4).setTextSize(2, 16.0F);
    ((InputLinearLayout)localObject3).addView((View)localObject4);
    localObject4 = new ImageView(paramContext);
    ((ImageView)localObject4).setId(2131297031);
    localLayoutParams = new LinearLayout.LayoutParams(-1, -1);
    localLayoutParams.width = AIOUtils.a(206.0F, (Resources)localObject2);
    localLayoutParams.height = -2;
    localLayoutParams.topMargin = AIOUtils.a(8.0F, (Resources)localObject2);
    localLayoutParams.bottomMargin = AIOUtils.a(8.0F, (Resources)localObject2);
    localLayoutParams.weight = 1.0F;
    ((ImageView)localObject4).setLayoutParams(localLayoutParams);
    ((ImageView)localObject4).setImageResource(2130837544);
    ((ImageView)localObject4).setBackgroundResource(2130842210);
    ((ImageView)localObject4).setScaleType(ImageView.ScaleType.CENTER);
    ((ImageView)localObject4).setVisibility(8);
    ((InputLinearLayout)localObject3).addView((View)localObject4);
    localObject4 = new Button(paramContext);
    ((Button)localObject4).setId(2131297029);
    localLayoutParams = new LinearLayout.LayoutParams(-1, -1);
    localLayoutParams.width = AIOUtils.a(57.0F, (Resources)localObject2);
    localLayoutParams.height = ((Resources)localObject2).getDimensionPixelSize(2131493080);
    localLayoutParams.gravity = 80;
    localLayoutParams.bottomMargin = AIOUtils.a(4.0F, (Resources)localObject2);
    localLayoutParams.leftMargin = AIOUtils.a(7.0F, (Resources)localObject2);
    localLayoutParams.rightMargin = AIOUtils.a(5.0F, (Resources)localObject2);
    ((Button)localObject4).setLayoutParams(localLayoutParams);
    ((Button)localObject4).setBackgroundResource(2130837621);
    ((Button)localObject4).setTextSize(2, 14.0F);
    ((Button)localObject4).setTextColor(((Resources)localObject2).getColorStateList(2131427924));
    ((InputLinearLayout)localObject3).addView((View)localObject4);
    localObject2 = new ChatXListView(paramContext);
    ((ChatXListView)localObject2).setId(2131297034);
    localObject3 = new RelativeLayout.LayoutParams(-1, -1);
    ((RelativeLayout.LayoutParams)localObject3).addRule(2, 2131297027);
    ((ChatXListView)localObject2).setLayoutParams((ViewGroup.LayoutParams)localObject3);
    ((ChatXListView)localObject2).setDivider(null);
    ((ChatXListView)localObject2).setTranscriptMode(1);
    ((RelativeLayout)localObject1).addView((View)localObject2);
    localObject2 = new AIOAnimationConatiner(paramContext);
    ((AIOAnimationConatiner)localObject2).setId(2131296719);
    localObject3 = new RelativeLayout.LayoutParams(-1, -1);
    ((RelativeLayout.LayoutParams)localObject3).addRule(6, 2131297034);
    ((RelativeLayout.LayoutParams)localObject3).addRule(8, 2131297034);
    ((AIOAnimationConatiner)localObject2).setLayoutParams((ViewGroup.LayoutParams)localObject3);
    ((RelativeLayout)localObject1).addView((View)localObject2);
    localObject2 = new LinearLayout(paramContext);
    ((LinearLayout)localObject2).setId(2131297035);
    ((LinearLayout)localObject2).setOrientation(1);
    localObject3 = new RelativeLayout.LayoutParams(-1, -1);
    ((RelativeLayout.LayoutParams)localObject3).height = -2;
    ((LinearLayout)localObject2).setLayoutParams((ViewGroup.LayoutParams)localObject3);
    ((RelativeLayout)localObject1).addView((View)localObject2);
    localObject1 = new RelativeLayout(paramContext);
    ((RelativeLayout)localObject1).setId(2131297036);
    new LinearLayout.LayoutParams(-1, -1).height = -2;
    ((RelativeLayout)localObject1).setLayoutParams((ViewGroup.LayoutParams)localObject3);
    ((LinearLayout)localObject2).addView((View)localObject1);
    paramContext = new RelativeLayout(paramContext);
    paramContext.setId(2131297037);
    localObject1 = new LinearLayout.LayoutParams(-1, -1);
    ((LinearLayout.LayoutParams)localObject1).height = -2;
    paramContext.setLayoutParams((ViewGroup.LayoutParams)localObject1);
    ((LinearLayout)localObject2).addView(paramContext);
    return localXPanelContainer;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.2.jar\classes.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.rebuild.ChatLayoutFactory
 * JD-Core Version:    0.7.0.1
 */