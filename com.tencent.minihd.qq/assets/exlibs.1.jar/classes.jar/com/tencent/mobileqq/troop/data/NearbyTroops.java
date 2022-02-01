package com.tencent.mobileqq.troop.data;

import NearbyGroup.GroupInfo;
import NearbyGroup.GroupLabel;
import NearbyGroup.XiaoQuInfo;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.text.SpannableString;
import android.text.TextPaint;
import android.text.TextUtils;
import android.text.style.ImageSpan;
import android.util.DisplayMetrics;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.TextView;
import com.tencent.mobileqq.activity.aio.AIOUtils;
import com.tencent.mobileqq.troop.widget.TroopLabelTextView;
import com.tencent.qphone.base.util.QLog;
import com.tencent.tencentmap.mapsdk.map.GeoPoint;
import com.tencent.widget.AbsListView.LayoutParams;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import kiw;

public class NearbyTroops
{
  public static final int A = 195;
  public static final int B = 213;
  public static final int C = 190;
  public static final int D = 206;
  public static final int E = 220;
  protected static final int F = 5;
  protected static final int G = 1;
  protected static final int H = 2;
  protected static final int I = 3;
  protected static final int J = 4;
  protected static final int K = 7;
  public static final double a = 6378137.0D;
  public static final int a = 1;
  private static final String a;
  public static final boolean a = true;
  public static final int b = 2;
  public static final int c = 3;
  public static final int d = 4;
  public static final int e = 5;
  public static final int f = 6;
  public static final int g = 7;
  public static final int h = 8;
  public static final int i = 9;
  public static final int j = 10;
  public static final int k = 150;
  public static final int l = 55;
  public static final int m = 1;
  public static final int n = 2;
  public static final int o = 1;
  public static final int p = 2;
  public static final int q = 3;
  public static final int r = 4;
  public static final int s = 1;
  public static final int t = 2;
  public static final int u = 3;
  public static final int v = 4;
  public static final int w = 1;
  public static final int x = 2;
  public static final int y = 3;
  public static final int z = 175;
  
  static
  {
    jdField_a_of_type_JavaLangString = NearbyTroops.class.getSimpleName();
  }
  
  public static double a(double paramDouble)
  {
    return 3.141592653589793D * paramDouble / 180.0D;
  }
  
  public static double a(GeoPoint paramGeoPoint1, GeoPoint paramGeoPoint2)
  {
    double d1 = paramGeoPoint1.getLatitudeE6() / 1000000.0D;
    double d3 = paramGeoPoint2.getLatitudeE6() / 1000000.0D;
    double d4 = paramGeoPoint1.getLongitudeE6() / 1000000.0D;
    double d2 = paramGeoPoint2.getLongitudeE6() / 1000000.0D;
    d1 = a(d1);
    d3 = a(d3);
    d4 = a(d4);
    d2 = a(d2);
    double d5 = Math.pow(Math.sin((d1 - d3) / 2.0D), 2.0D);
    return Math.round(Math.asin(Math.sqrt(Math.cos(d1) * Math.cos(d3) * Math.pow(Math.sin((d4 - d2) / 2.0D), 2.0D) + d5)) * 2.0D * 6378137.0D * 10000.0D) / 10000L;
  }
  
  public static View a(Context paramContext, ViewGroup paramViewGroup)
  {
    paramContext = LayoutInflater.from(paramContext).inflate(2130903535, paramViewGroup, false);
    paramViewGroup = new NearbyTroops.GroupViewHolder();
    paramViewGroup.jdField_a_of_type_Int = 1;
    paramContext.setTag(paramViewGroup);
    return paramContext;
  }
  
  public static CharSequence a(GroupInfo paramGroupInfo, Context paramContext, Boolean paramBoolean)
  {
    int i1;
    String str2;
    if ((paramGroupInfo.dwGroupFlagExt & 0x100000) != 0L)
    {
      i1 = 1;
      str2 = "[icon]";
      if (i1 == 0) {
        break label127;
      }
      str2 = "";
    }
    ImageSpan localImageSpan;
    label127:
    for (String str1 = "当前人数：" + paramGroupInfo.iMemberCnt + "人  ";; str1 = "[icon]" + " " + paramGroupInfo.iMemberCnt + "人  ")
    {
      SpannableString localSpannableString = new SpannableString(str1);
      localImageSpan = new ImageSpan(paramContext, 2130842112, 1);
      localSpannableString.setSpan(localImageSpan, 0, str2.length(), 17);
      if ((paramGroupInfo.strLocation != null) && (paramGroupInfo.strLocation.length() != 0) && (paramBoolean.booleanValue())) {
        break label164;
      }
      return localSpannableString;
      i1 = 0;
      break;
    }
    label164:
    paramGroupInfo = "[icon]" + " " + paramGroupInfo.strLocation;
    paramGroupInfo = new SpannableString(str1 + paramGroupInfo);
    paramContext = new ImageSpan(paramContext, 2130842113, 1);
    paramGroupInfo.setSpan(localImageSpan, 0, str2.length(), 17);
    paramGroupInfo.setSpan(paramContext, str1.length(), str1.length() + "[icon]".length(), 17);
    return paramGroupInfo;
  }
  
  public static void a(View paramView)
  {
    paramView.setBackgroundResource(2130837687);
    paramView = (NearbyTroops.MoreBtnViewHolder)paramView.getTag();
    paramView.jdField_a_of_type_AndroidWidgetProgressBar.setVisibility(0);
    paramView.jdField_a_of_type_AndroidWidgetTextView.setText(2131366571);
    paramView.jdField_a_of_type_AndroidWidgetImageView.setVisibility(8);
    paramView.b.setVisibility(8);
    paramView.jdField_a_of_type_Boolean = true;
  }
  
  public static void a(View paramView, int paramInt1, int paramInt2, Context paramContext)
  {
    Object localObject = new AbsListView.LayoutParams(-1, -1);
    ((AbsListView.LayoutParams)localObject).height = paramInt1;
    paramView.setLayoutParams((ViewGroup.LayoutParams)localObject);
    localObject = (NearbyTroops.OccupyViewHolder)paramView.getTag();
    if (paramInt2 == 2) {}
    for (paramInt1 = 2131365807;; paramInt1 = 2131365806)
    {
      ((NearbyTroops.OccupyViewHolder)localObject).jdField_a_of_type_AndroidWidgetTextView.setText(paramInt1);
      ((NearbyTroops.OccupyViewHolder)localObject).jdField_a_of_type_AndroidWidgetTextView.setTextColor(-8814455);
      paramView.setContentDescription(paramContext.getResources().getString(paramInt1));
      return;
    }
  }
  
  public static void a(View paramView, GroupInfo paramGroupInfo, Context paramContext, boolean paramBoolean, long paramLong)
  {
    NearbyTroops.CustomViewHolder localCustomViewHolder = (NearbyTroops.CustomViewHolder)paramView.getTag();
    localCustomViewHolder.jdField_a_of_type_JavaLangString = String.valueOf(paramGroupInfo.lCode);
    localCustomViewHolder.jdField_f_of_type_AndroidWidgetTextView.setText(paramGroupInfo.strName);
    Object localObject;
    label228:
    int i1;
    if (TextUtils.isEmpty(paramGroupInfo.strIntro))
    {
      localCustomViewHolder.h.setVisibility(8);
      if ((paramGroupInfo.getLabels() != null) && (paramGroupInfo.getLabels().size() != 0)) {
        break label455;
      }
      if ((localCustomViewHolder.jdField_a_of_type_JavaUtilArrayList == null) || (localCustomViewHolder.jdField_a_of_type_JavaUtilArrayList.size() == 0))
      {
        localObject = new ArrayList(1);
        ((ArrayList)localObject).add(new GroupLabel(paramGroupInfo.iMemberCnt + "", new NearbyGroup.Color(175L, 195L, 213L), 1L, new NearbyGroup.Color(190L, 206L, 220L)));
        localCustomViewHolder.jdField_a_of_type_JavaUtilArrayList = ((ArrayList)localObject);
      }
      ((GroupLabel)localCustomViewHolder.jdField_a_of_type_JavaUtilArrayList.get(0)).strWording = (paramGroupInfo.iMemberCnt + "");
      paramGroupInfo.setLabels(localCustomViewHolder.jdField_a_of_type_JavaUtilArrayList);
      a(paramContext, localCustomViewHolder, paramGroupInfo);
      if ((paramGroupInfo.dwGroupFlagExt & 0x800) == 0L) {
        break label549;
      }
      if (paramGroupInfo.dwCertType != 2L) {
        break label504;
      }
      localCustomViewHolder.c.setVisibility(0);
      localCustomViewHolder.c.setBackgroundResource(2130838652);
      label272:
      if ((paramGroupInfo.dwExtFlag & 1L) == 0L) {
        break label562;
      }
      localCustomViewHolder.jdField_f_of_type_AndroidWidgetImageView.setBackgroundResource(2130839169);
      localCustomViewHolder.jdField_f_of_type_AndroidWidgetImageView.setVisibility(0);
      label303:
      localObject = "" + paramGroupInfo.strName;
      if ((paramGroupInfo.dwGroupFlagExt & 0x100000) == 0L) {
        break label575;
      }
      i1 = 1;
      label343:
      if (i1 == 0) {
        break label581;
      }
    }
    label549:
    label562:
    label575:
    label581:
    for (paramContext = "当前人数：" + paramGroupInfo.iMemberCnt + "人  ";; paramContext = paramGroupInfo.iMemberCnt + "人  ")
    {
      localCustomViewHolder.g.setContentDescription(paramContext);
      paramContext = (String)localObject + paramContext;
      paramView.setContentDescription(paramContext + paramGroupInfo.strIntro);
      return;
      localCustomViewHolder.h.setVisibility(0);
      localCustomViewHolder.h.setText(paramGroupInfo.strIntro);
      break;
      label455:
      if ((a(paramContext, localCustomViewHolder, paramGroupInfo)) || (!QLog.isColorLevel())) {
        break label228;
      }
      QLog.e(jdField_a_of_type_JavaLangString, 2, "fillTroopLabels failed:" + paramGroupInfo.strName);
      break label228;
      label504:
      if (paramGroupInfo.dwCertType == 1L)
      {
        localCustomViewHolder.c.setVisibility(0);
        localCustomViewHolder.c.setBackgroundResource(2130839096);
        break label272;
      }
      localCustomViewHolder.c.setVisibility(8);
      break label272;
      localCustomViewHolder.c.setVisibility(8);
      break label272;
      localCustomViewHolder.jdField_f_of_type_AndroidWidgetImageView.setVisibility(8);
      break label303;
      i1 = 0;
      break label343;
    }
  }
  
  public static void a(View paramView, XiaoQuInfo paramXiaoQuInfo, Context paramContext)
  {
    paramView = (NearbyTroops.CustomViewHolder)paramView.getTag();
    paramView.jdField_a_of_type_AndroidWidgetImageView.setImageResource(2130839214);
    paramView.jdField_f_of_type_AndroidWidgetTextView.setText(paramXiaoQuInfo.strName);
    paramView.c.setVisibility(8);
    paramView.h.setText(paramXiaoQuInfo.strIntro);
    Object localObject = paramContext.getResources().getDrawable(2130839215);
    ((Drawable)localObject).setBounds(AIOUtils.a(5.0F, paramContext.getResources()), AIOUtils.a(1.0F, paramContext.getResources()), AIOUtils.a(47.5F, paramContext.getResources()), AIOUtils.a(13.5F, paramContext.getResources()));
    paramView.jdField_f_of_type_AndroidWidgetTextView.setCompoundDrawables(null, null, (Drawable)localObject, null);
    paramView.jdField_f_of_type_AndroidWidgetTextView.setPadding(0, 0, AIOUtils.a(6.0F, paramContext.getResources()), 0);
    localObject = paramXiaoQuInfo.iMemberCnt + "人";
    paramXiaoQuInfo = "[icon]" + " " + paramXiaoQuInfo.strLocation;
    paramXiaoQuInfo = new SpannableString((String)localObject + paramXiaoQuInfo);
    paramXiaoQuInfo.setSpan(new ImageSpan(paramContext, 2130842113, 1), ((String)localObject).length(), ((String)localObject).length() + "[icon]".length(), 17);
    paramView.g.setText(paramXiaoQuInfo);
  }
  
  public static void a(View paramView, String paramString, float paramFloat1, float paramFloat2, boolean paramBoolean)
  {
    NearbyTroops.GroupViewHolder localGroupViewHolder = (NearbyTroops.GroupViewHolder)paramView.getTag();
    localGroupViewHolder.jdField_a_of_type_AndroidWidgetTextView.setText(paramString + "(" + (int)paramFloat1 + ")");
    if (paramFloat2 < 1000.0F) {
      if (paramFloat2 <= 50.0F) {
        paramView = "50m";
      }
    }
    for (;;)
    {
      localGroupViewHolder.b.setText(paramView);
      return;
      paramView = (int)(Math.floor(paramFloat2 / 50.0F) * 50.0D) + "m";
      continue;
      paramView = new DecimalFormat("#.##");
      paramView = paramView.format(Math.ceil(paramFloat2 / 50.0F) * 0.05D) + "km";
    }
  }
  
  public static void a(View paramView, kiw paramkiw)
  {
    paramView = (NearbyTroops.CustomViewHolder)paramView.getTag();
    paramView.jdField_a_of_type_AndroidWidgetImageView.setImageResource(paramkiw.jdField_c_of_type_Int);
    paramView.jdField_f_of_type_AndroidWidgetTextView.setText(paramkiw.jdField_a_of_type_JavaLangString);
    paramView.jdField_f_of_type_AndroidWidgetTextView.setCompoundDrawables(null, null, null, null);
    paramView.g.setText(paramkiw.b);
    paramView.h.setText(paramkiw.jdField_c_of_type_JavaLangString);
  }
  
  public static void a(View paramView, boolean paramBoolean, int paramInt)
  {
    int i2 = 8;
    paramView.setBackgroundResource(2130838123);
    paramView = (NearbyTroops.MoreBtnViewHolder)paramView.getTag();
    Object localObject = paramView.jdField_a_of_type_AndroidWidgetProgressBar;
    if (paramBoolean)
    {
      i1 = 0;
      ((ProgressBar)localObject).setVisibility(i1);
      localObject = paramView.jdField_a_of_type_AndroidWidgetTextView;
      if (!paramBoolean) {
        break label119;
      }
      i1 = 0;
      label49:
      ((TextView)localObject).setVisibility(i1);
      localObject = paramView.jdField_a_of_type_AndroidWidgetImageView;
      if (paramBoolean) {
        break label125;
      }
    }
    label119:
    label125:
    for (int i1 = 0;; i1 = 8)
    {
      ((ImageView)localObject).setVisibility(i1);
      localObject = paramView.b;
      i1 = i2;
      if (!paramBoolean) {
        i1 = 0;
      }
      ((TextView)localObject).setVisibility(i1);
      paramView.jdField_a_of_type_Boolean = false;
      if (!paramBoolean) {
        break label131;
      }
      paramView.jdField_a_of_type_AndroidWidgetTextView.setText(2131366571);
      return;
      i1 = 8;
      break;
      i1 = 8;
      break label49;
    }
    label131:
    paramView.b.setText("查看更多(" + paramInt + ")");
  }
  
  protected static boolean a(Context paramContext, NearbyTroops.CustomViewHolder paramCustomViewHolder, GroupInfo paramGroupInfo)
  {
    if ((paramContext == null) || (paramCustomViewHolder == null) || (paramGroupInfo == null) || (paramGroupInfo.getLabels() == null) || (paramGroupInfo.getLabels().size() == 0)) {
      return false;
    }
    paramCustomViewHolder.g.setVisibility(8);
    paramCustomViewHolder.jdField_a_of_type_AndroidWidgetLinearLayout.setVisibility(0);
    int i2 = paramCustomViewHolder.jdField_a_of_type_AndroidWidgetLinearLayout.getMeasuredWidth();
    int i1 = i2;
    if (i2 == 0) {
      i1 = (int)(0.72D * paramContext.getResources().getDisplayMetrics().widthPixels);
    }
    ArrayList localArrayList = paramGroupInfo.getLabels();
    if ((localArrayList != null) && (localArrayList.size() != 0))
    {
      HashMap localHashMap = new HashMap();
      int i3;
      int i4;
      label127:
      GroupLabel localGroupLabel;
      if (localArrayList.size() > 5)
      {
        i3 = 5;
        i4 = 0;
        if (i4 >= i3) {
          break label546;
        }
        localGroupLabel = (GroupLabel)localArrayList.get(i4);
        if (!TextUtils.isEmpty(localGroupLabel.strWording)) {
          break label176;
        }
      }
      for (;;)
      {
        i4 += 1;
        break label127;
        i3 = localArrayList.size();
        break;
        label176:
        int i5 = (int)localGroupLabel.type;
        Object localObject = paramCustomViewHolder.a(i5);
        paramGroupInfo = (GroupInfo)localObject;
        i2 = i1;
        if (localObject == null)
        {
          paramGroupInfo = new TroopLabelTextView(paramContext, android.graphics.Color.rgb((int)localGroupLabel.edging_color.R, (int)localGroupLabel.edging_color.G, (int)localGroupLabel.edging_color.B), android.graphics.Color.rgb((int)localGroupLabel.text_color.R, (int)localGroupLabel.text_color.G, (int)localGroupLabel.text_color.B));
          float f1 = paramGroupInfo.getPaint().measureText((paramGroupInfo.getText() + "").toString()) + paramGroupInfo.a();
          if ((f1 > i1) || (paramCustomViewHolder.jdField_a_of_type_AndroidWidgetLinearLayout.getChildCount() >= 5)) {
            break label546;
          }
          i2 = (int)(i1 - f1);
          paramCustomViewHolder.jdField_a_of_type_AndroidWidgetLinearLayout.addView(paramGroupInfo, i4);
          paramCustomViewHolder.a(i5, paramGroupInfo);
        }
        paramGroupInfo.setVisibility(0);
        localHashMap.put(Integer.valueOf(i5), Boolean.valueOf(true));
        if (localGroupLabel.type == 1L)
        {
          localObject = new SpannableString("[icon]" + " " + localGroupLabel.strWording);
          if (paramCustomViewHolder.jdField_a_of_type_AndroidGraphicsDrawableDrawable == null) {
            paramCustomViewHolder.jdField_a_of_type_AndroidGraphicsDrawableDrawable = paramContext.getResources().getDrawable(2130842105);
          }
          i1 = (int)(paramGroupInfo.getTextSize() * 0.8D + 0.5D);
          paramCustomViewHolder.jdField_a_of_type_AndroidGraphicsDrawableDrawable.setBounds(0, 0, i1, i1);
          ((SpannableString)localObject).setSpan(new ImageSpan(paramCustomViewHolder.jdField_a_of_type_AndroidGraphicsDrawableDrawable, 1), 0, "[icon]".length(), 17);
          paramGroupInfo.setText((CharSequence)localObject);
          i1 = i2;
        }
        else
        {
          paramGroupInfo.setText(localGroupLabel.strWording + "");
          i1 = i2;
        }
      }
      label546:
      paramCustomViewHolder.a(localHashMap);
      localHashMap.clear();
    }
    return true;
  }
  
  public static View b(Context paramContext, ViewGroup paramViewGroup)
  {
    paramContext = LayoutInflater.from(paramContext).inflate(2130903534, paramViewGroup, false);
    paramViewGroup = new NearbyTroops.GroupViewHolder();
    paramViewGroup.jdField_a_of_type_AndroidWidgetTextView = ((TextView)paramContext.findViewById(2131298696));
    paramViewGroup.b = ((TextView)paramContext.findViewById(2131298697));
    paramViewGroup.jdField_a_of_type_Int = 3;
    paramContext.setTag(paramViewGroup);
    return paramContext;
  }
  
  public static View c(Context paramContext, ViewGroup paramViewGroup)
  {
    paramContext = LayoutInflater.from(paramContext).inflate(2130903536, paramViewGroup, false);
    paramViewGroup = new NearbyTroops.GroupViewHolder();
    paramViewGroup.jdField_a_of_type_Int = 2;
    paramContext.setTag(paramViewGroup);
    return paramContext;
  }
  
  public static View d(Context paramContext, ViewGroup paramViewGroup)
  {
    paramContext = LayoutInflater.from(paramContext).inflate(2130904450, paramViewGroup, false);
    paramViewGroup = new NearbyTroops.CustomViewHolder();
    paramViewGroup.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)paramContext.findViewById(2131298599));
    paramViewGroup.jdField_f_of_type_AndroidWidgetTextView = ((TextView)paramContext.findViewById(2131297661));
    paramViewGroup.g = ((TextView)paramContext.findViewById(2131298602));
    paramViewGroup.jdField_a_of_type_AndroidWidgetLinearLayout = ((LinearLayout)paramContext.findViewById(2131302243));
    paramViewGroup.h = ((TextView)paramContext.findViewById(2131298603));
    paramViewGroup.c = ((ImageView)paramContext.findViewById(2131297282));
    paramViewGroup.jdField_f_of_type_AndroidWidgetImageView = ((ImageView)paramContext.findViewById(2131302242));
    paramViewGroup.jdField_a_of_type_AndroidWidgetImageView.setImageBitmap(null);
    paramContext.setTag(paramViewGroup);
    return paramContext;
  }
  
  public static View e(Context paramContext, ViewGroup paramViewGroup)
  {
    paramContext = LayoutInflater.from(paramContext).inflate(2130903540, paramViewGroup, false);
    paramViewGroup = new NearbyTroops.OccupyViewHolder();
    paramViewGroup.jdField_a_of_type_AndroidWidgetTextView = ((TextView)paramContext.findViewById(2131297001));
    paramContext.setTag(paramViewGroup);
    return paramContext;
  }
  
  public static View f(Context paramContext, ViewGroup paramViewGroup)
  {
    paramContext = LayoutInflater.from(paramContext).inflate(2130903539, paramViewGroup, false);
    paramViewGroup = new NearbyTroops.MoreBtnViewHolder();
    paramViewGroup.jdField_a_of_type_AndroidWidgetProgressBar = ((ProgressBar)paramContext.findViewById(2131296735));
    paramViewGroup.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)paramContext.findViewById(2131297996));
    paramViewGroup.jdField_a_of_type_AndroidWidgetTextView = ((TextView)paramContext.findViewById(2131297997));
    paramViewGroup.b = ((TextView)paramContext.findViewById(2131297409));
    paramContext.setTag(paramViewGroup);
    return paramContext;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     com.tencent.mobileqq.troop.data.NearbyTroops
 * JD-Core Version:    0.7.0.1
 */