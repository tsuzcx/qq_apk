package com.tencent.mobileqq.redtouch;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Color;
import android.graphics.drawable.BitmapDrawable;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import android.util.TypedValue;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.FrameLayout.LayoutParams;
import android.widget.ImageView;
import android.widget.ImageView.ScaleType;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.utils.ImageUtil;
import com.tencent.pb.getbusiinfo.BusinessInfoCheckUpdate.AppInfo;
import com.tencent.pb.getbusiinfo.BusinessInfoCheckUpdate.RedDisplayInfo;
import com.tencent.pb.getbusiinfo.BusinessInfoCheckUpdate.RedTypeInfo;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import jqb;
import org.json.JSONObject;

public class RedTouch
  extends FrameLayout
{
  public static final int a = 0;
  public static final int b = 3;
  public static final int c = 4;
  public static final int d = 5;
  public static final int e = 9;
  public static final int f = 99;
  public static final int g = 100;
  public static final int h = 10;
  public static final int i = 20;
  public static final int j = 30;
  public static final int k = 40;
  private static int p = 1;
  private int A;
  private Context jdField_a_of_type_AndroidContentContext;
  private Handler jdField_a_of_type_AndroidOsHandler;
  private View jdField_a_of_type_AndroidViewView;
  private LinearLayout jdField_a_of_type_AndroidWidgetLinearLayout;
  private List jdField_a_of_type_JavaUtilList;
  private boolean jdField_a_of_type_Boolean = false;
  private boolean b;
  private int l;
  private int m;
  private int n;
  private int o;
  private int q = 21;
  private int r = 0;
  private int s = 0;
  private int t = 0;
  private int u = 0;
  private int v;
  private int w;
  private int x;
  private int y;
  private int z;
  
  public RedTouch(Context paramContext)
  {
    this(paramContext, null, true);
  }
  
  public RedTouch(Context paramContext, View paramView)
  {
    this(paramContext, paramView, true);
  }
  
  public RedTouch(Context paramContext, View paramView, boolean paramBoolean)
  {
    super(paramContext);
    this.jdField_a_of_type_AndroidContentContext = paramContext;
    this.jdField_a_of_type_AndroidViewView = paramView;
    if (paramBoolean) {}
    for (int i1 = 5;; i1 = 3)
    {
      this.q = (i1 | 0x10);
      d();
      return;
    }
  }
  
  private int a(int paramInt)
  {
    Resources localResources = getResources();
    return (int)TypedValue.applyDimension(1, paramInt, localResources.getDisplayMetrics());
  }
  
  private int a(String paramString)
  {
    if ((TextUtils.isEmpty(paramString)) || (paramString.equals("#"))) {
      return 0;
    }
    return Color.parseColor(paramString);
  }
  
  private Bitmap a(File paramFile)
  {
    try
    {
      paramFile = new BitmapDrawable(new FileInputStream(paramFile)).getBitmap();
      return paramFile;
    }
    catch (FileNotFoundException paramFile)
    {
      paramFile.printStackTrace();
      return null;
    }
    catch (OutOfMemoryError paramFile)
    {
      paramFile.printStackTrace();
    }
    return null;
  }
  
  private View a(String paramString)
  {
    try
    {
      i1 = Integer.parseInt(paramString);
      if (i1 <= 0) {
        return null;
      }
    }
    catch (NumberFormatException paramString)
    {
      int i1;
      for (;;)
      {
        i1 = 0;
      }
      paramString = new View(this.jdField_a_of_type_AndroidContentContext);
      LinearLayout.LayoutParams localLayoutParams = a();
      localLayoutParams.width = a(i1);
      localLayoutParams.height = 1;
      paramString.setLayoutParams(localLayoutParams);
    }
    return paramString;
  }
  
  private View a(String paramString, int paramInt1, int paramInt2, int paramInt3)
  {
    ImageView localImageView = new ImageView(this.jdField_a_of_type_AndroidContentContext);
    localImageView.setScaleType(ImageView.ScaleType.FIT_XY);
    localImageView.setBackgroundColor(paramInt3);
    a(paramString, localImageView, paramInt1);
    if (paramInt2 == 1)
    {
      paramString = new FrameLayout(getContext());
      localImageView.setLayoutParams(new FrameLayout.LayoutParams(a(36), a(36)));
      localImageView.setPadding(a(3), a(3), a(3), a(3));
      paramString.addView(localImageView);
      localImageView = new ImageView(this.jdField_a_of_type_AndroidContentContext);
      localImageView.setImageResource(2130841952);
      FrameLayout.LayoutParams localLayoutParams = new FrameLayout.LayoutParams(-2, -2);
      localLayoutParams.gravity = 53;
      localImageView.setLayoutParams(localLayoutParams);
      paramString.addView(localImageView);
      paramString.setLayoutParams(a());
      return paramString;
    }
    paramString = a();
    paramString.width = a(36);
    paramString.height = a(36);
    localImageView.setLayoutParams(paramString);
    localImageView.setPadding(a(3), a(3), a(3), a(3));
    return localImageView;
  }
  
  private FrameLayout.LayoutParams a()
  {
    try
    {
      QLog.d("getRedTouchContainerLayoutParams1", 2, "getRedTouchContainerLayoutParams1");
      FrameLayout.LayoutParams localLayoutParams = new FrameLayout.LayoutParams(-2, -2);
      QLog.d("getRedTouchContainerLayoutParams2 layoutParams" + localLayoutParams, 2, "getRedTouchContainerLayoutParams2");
      localLayoutParams.gravity = this.v;
      QLog.d("getRedTouchContainerLayoutParams3 gravity" + this.v, 2, "getRedTouchContainerLayoutParams3");
      localLayoutParams.leftMargin = this.w;
      QLog.d("getRedTouchContainerLayoutParams4 leftMargin" + this.w, 2, "getRedTouchContainerLayoutParams4");
      localLayoutParams.rightMargin = this.x;
      QLog.d("getRedTouchContainerLayoutParams5 rightMargin" + this.x, 2, "getRedTouchContainerLayoutParams5");
      localLayoutParams.topMargin = this.y;
      QLog.d("getRedTouchContainerLayoutParams6 topMargin" + this.y, 2, "getRedTouchContainerLayoutParams6");
      localLayoutParams.bottomMargin = this.z;
      QLog.d("getRedTouchContainerLayoutParams7 buttomMargin" + this.z, 2, "getRedTouchContainerLayoutParams7");
      return localLayoutParams;
    }
    catch (Exception localException)
    {
      QLog.d("getRedTouchContainerLayoutParams", 2, "getRedTouchContainerLayoutParams:         error" + localException);
    }
    return null;
  }
  
  private ImageView a(int paramInt)
  {
    ImageView localImageView = new ImageView(this.jdField_a_of_type_AndroidContentContext);
    localImageView.setImageResource(2130841952);
    localImageView.setBackgroundColor(paramInt);
    localImageView.setLayoutParams(a());
    return localImageView;
  }
  
  private LinearLayout.LayoutParams a()
  {
    LinearLayout.LayoutParams localLayoutParams = new LinearLayout.LayoutParams(-2, -2);
    localLayoutParams.gravity = 16;
    return localLayoutParams;
  }
  
  private TextView a(String paramString, int paramInt1, int paramInt2, int paramInt3)
  {
    TextView localTextView = new TextView(this.jdField_a_of_type_AndroidContentContext);
    try
    {
      if (Integer.parseInt(paramString) > this.A) {
        localTextView.setText(this.A + "+");
      }
      for (;;)
      {
        localTextView.setTextColor(paramInt1);
        localTextView.setGravity(17);
        localTextView.setSingleLine(true);
        if (paramInt2 == 0) {
          break;
        }
        localTextView.setTextSize(11.0F);
        localTextView.setBackgroundResource(2130841956);
        localTextView.setLayoutParams(a());
        if (this.b)
        {
          localTextView.measure(0, 0);
          this.w = (localTextView.getMeasuredWidth() / 2);
          f();
        }
        return localTextView;
        localTextView.setText(paramString);
      }
    }
    catch (NumberFormatException localNumberFormatException)
    {
      for (;;)
      {
        localTextView.setText(paramString);
        continue;
        localTextView.setTextSize(13.0F);
      }
    }
  }
  
  private void a(View paramView)
  {
    ViewGroup localViewGroup = (ViewGroup)paramView.getParent();
    if (localViewGroup == null) {
      return;
    }
    if ((localViewGroup instanceof RelativeLayout))
    {
      i1 = p;
      p = i1 + 1;
      setId(i1);
      int i3 = paramView.getId();
      RelativeLayout localRelativeLayout = (RelativeLayout)localViewGroup;
      i1 = 0;
      while (i1 < localRelativeLayout.getChildCount())
      {
        View localView = localRelativeLayout.getChildAt(i1);
        RelativeLayout.LayoutParams localLayoutParams = (RelativeLayout.LayoutParams)localView.getLayoutParams();
        int[] arrayOfInt = localLayoutParams.getRules();
        int i2 = 0;
        while (i2 < arrayOfInt.length)
        {
          if (arrayOfInt[i2] == i3) {
            arrayOfInt[i2] = getId();
          }
          i2 += 1;
        }
        localView.setLayoutParams(localLayoutParams);
        i1 += 1;
      }
    }
    int i1 = localViewGroup.indexOfChild(paramView);
    localViewGroup.removeView(paramView);
    setLayoutParams(paramView.getLayoutParams());
    localViewGroup.addView(this, i1);
  }
  
  private void a(String paramString, ImageView paramImageView, int paramInt)
  {
    Object localObject = new File(this.jdField_a_of_type_AndroidContentContext.getFilesDir(), paramString);
    if (((File)localObject).exists())
    {
      localObject = a((File)localObject);
      paramString = (String)localObject;
      if (paramInt == 1) {
        paramString = ImageUtil.a((Bitmap)localObject, ((Bitmap)localObject).getWidth(), ((Bitmap)localObject).getWidth(), ((Bitmap)localObject).getHeight());
      }
      paramImageView.setImageBitmap(paramString);
      return;
    }
    new Thread(new jqb(this, paramString, (File)localObject, paramInt, paramImageView)).start();
  }
  
  private boolean a(BusinessInfoCheckUpdate.RedTypeInfo paramRedTypeInfo1, BusinessInfoCheckUpdate.RedTypeInfo paramRedTypeInfo2)
  {
    if (paramRedTypeInfo1.red_type.get() != paramRedTypeInfo2.red_type.get()) {}
    while ((!paramRedTypeInfo1.red_content.get().equals(paramRedTypeInfo2.red_content.get())) || (!paramRedTypeInfo1.red_desc.get().equals(paramRedTypeInfo2.red_desc.get())) || (paramRedTypeInfo1.red_priority.get() != paramRedTypeInfo2.red_priority.get())) {
      return false;
    }
    return true;
  }
  
  private boolean a(List paramList)
  {
    if (this.jdField_a_of_type_JavaUtilList.size() == 0) {}
    while (this.jdField_a_of_type_JavaUtilList.size() != paramList.size()) {
      return false;
    }
    int i1 = 0;
    for (;;)
    {
      if (i1 >= this.jdField_a_of_type_JavaUtilList.size()) {
        break label84;
      }
      if (!a((BusinessInfoCheckUpdate.RedTypeInfo)this.jdField_a_of_type_JavaUtilList.get(i1), (BusinessInfoCheckUpdate.RedTypeInfo)paramList.get(i1))) {
        break;
      }
      i1 += 1;
    }
    label84:
    return true;
  }
  
  private FrameLayout.LayoutParams b()
  {
    return new FrameLayout.LayoutParams(-1, -1);
  }
  
  private void b(View paramView)
  {
    paramView.setLayoutParams(b());
    addView(paramView);
  }
  
  private void b(BusinessInfoCheckUpdate.RedTypeInfo paramRedTypeInfo)
  {
    int i4 = 0;
    int i3 = 0;
    this.jdField_a_of_type_AndroidWidgetLinearLayout.setVisibility(0);
    try
    {
      Object localObject;
      if (TextUtils.isEmpty(paramRedTypeInfo.red_desc.get()))
      {
        localObject = new JSONObject();
        if (!((JSONObject)localObject).has("bg")) {
          break label423;
        }
      }
      label423:
      for (int i1 = a(((JSONObject)localObject).getString("bg"));; i1 = 0) {
        switch (paramRedTypeInfo.red_type.get())
        {
        case 0: 
          localObject = new JSONObject(paramRedTypeInfo.red_desc.get());
          break;
          paramRedTypeInfo = a(i1);
          if (paramRedTypeInfo == null) {
            break label428;
          }
          i1 = this.l;
          this.l = (i1 + 1);
          paramRedTypeInfo.setId(i1);
          this.jdField_a_of_type_AndroidWidgetLinearLayout.addView(paramRedTypeInfo);
          return;
        case 3: 
          if (!((JSONObject)localObject).has("av")) {}
        case 4: 
        case 5: 
        case 9: 
          for (int i2 = ((JSONObject)localObject).getInt("av");; i2 = 0)
          {
            if (((JSONObject)localObject).has("dot")) {
              i3 = ((JSONObject)localObject).getInt("dot");
            }
            paramRedTypeInfo = a(paramRedTypeInfo.red_content.get(), i2, i3, i1);
            if (paramRedTypeInfo == null) {
              break;
            }
            i1 = this.m;
            this.m = (i1 + 1);
            paramRedTypeInfo.setId(i1);
            this.jdField_a_of_type_AndroidWidgetLinearLayout.addView(paramRedTypeInfo);
            return;
            i2 = -1;
            if (((JSONObject)localObject).has("cr")) {
              i2 = a(((JSONObject)localObject).getString("cr"));
            }
            i3 = i4;
            if (((JSONObject)localObject).has("cn")) {
              i3 = a(((JSONObject)localObject).getString("cn"));
            }
            localObject = a(paramRedTypeInfo.red_content.get(), i2, i3, i1);
            if (localObject == null) {
              break;
            }
            if (paramRedTypeInfo.red_type.get() == 4)
            {
              i1 = this.n;
              this.n = (i1 + 1);
            }
            for (;;)
            {
              ((View)localObject).setId(i1);
              this.jdField_a_of_type_AndroidWidgetLinearLayout.addView((View)localObject);
              return;
              i1 = this.o;
              this.o = (i1 + 1);
            }
            paramRedTypeInfo = a(paramRedTypeInfo.red_content.get());
            if (paramRedTypeInfo == null) {
              break;
            }
            this.jdField_a_of_type_AndroidWidgetLinearLayout.addView(paramRedTypeInfo);
            return;
          }
        }
      }
      label428:
      return;
    }
    catch (Exception paramRedTypeInfo) {}
  }
  
  private void d()
  {
    this.v = this.q;
    this.w = this.r;
    this.x = this.s;
    this.y = this.t;
    this.z = this.u;
    this.A = 99;
    this.jdField_a_of_type_JavaUtilList = new ArrayList();
    this.jdField_a_of_type_AndroidOsHandler = new Handler(Looper.getMainLooper());
    this.l = 10;
    this.m = 20;
    this.n = 30;
    this.o = 40;
  }
  
  private void e()
  {
    this.jdField_a_of_type_AndroidWidgetLinearLayout = new LinearLayout(this.jdField_a_of_type_AndroidContentContext);
    this.jdField_a_of_type_AndroidWidgetLinearLayout.setLayoutParams(a());
    this.jdField_a_of_type_AndroidWidgetLinearLayout.setOrientation(0);
    this.jdField_a_of_type_AndroidWidgetLinearLayout.setId(100);
    this.jdField_a_of_type_AndroidWidgetLinearLayout.setVisibility(8);
    addView(this.jdField_a_of_type_AndroidWidgetLinearLayout);
  }
  
  private void f()
  {
    this.jdField_a_of_type_AndroidWidgetLinearLayout.setLayoutParams(a());
  }
  
  public int a()
  {
    return this.v;
  }
  
  public RedTouch a()
  {
    if (!this.jdField_a_of_type_Boolean)
    {
      a(this.jdField_a_of_type_AndroidViewView);
      b(this.jdField_a_of_type_AndroidViewView);
      e();
      this.jdField_a_of_type_Boolean = true;
      return this;
    }
    f();
    return this;
  }
  
  public RedTouch a(int paramInt)
  {
    this.v = paramInt;
    return this;
  }
  
  public RedTouch a(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    this.w = a(paramInt1);
    this.x = a(paramInt2);
    this.y = a(paramInt3);
    this.z = a(paramInt4);
    return this;
  }
  
  public RedTouch a(boolean paramBoolean)
  {
    this.b = paramBoolean;
    return this;
  }
  
  public void a()
  {
    if (this.jdField_a_of_type_AndroidWidgetLinearLayout != null)
    {
      this.jdField_a_of_type_AndroidWidgetLinearLayout.removeAllViews();
      this.jdField_a_of_type_AndroidWidgetLinearLayout.setVisibility(8);
      this.l = 10;
      this.m = 20;
      this.n = 30;
      this.o = 40;
    }
  }
  
  public void a(BusinessInfoCheckUpdate.AppInfo paramAppInfo)
  {
    a();
    if (this.jdField_a_of_type_JavaUtilList != null) {
      this.jdField_a_of_type_JavaUtilList.clear();
    }
    if (paramAppInfo.iNewFlag.get() == 0) {}
    for (;;)
    {
      return;
      if (!a(paramAppInfo.red_display_info.red_type_info.get()))
      {
        this.jdField_a_of_type_JavaUtilList.addAll(paramAppInfo.red_display_info.red_type_info.get());
        paramAppInfo = this.jdField_a_of_type_JavaUtilList.iterator();
        while (paramAppInfo.hasNext()) {
          b((BusinessInfoCheckUpdate.RedTypeInfo)paramAppInfo.next());
        }
      }
    }
  }
  
  public void a(BusinessInfoCheckUpdate.RedTypeInfo paramRedTypeInfo)
  {
    a();
    if (paramRedTypeInfo == null) {
      return;
    }
    b(paramRedTypeInfo);
  }
  
  public boolean a()
  {
    if (this.jdField_a_of_type_AndroidWidgetLinearLayout == null) {}
    while (this.jdField_a_of_type_AndroidWidgetLinearLayout.getChildCount() == 0) {
      return false;
    }
    return true;
  }
  
  public int b()
  {
    return this.w;
  }
  
  public RedTouch b(int paramInt)
  {
    this.w = a(paramInt);
    return this;
  }
  
  public void b()
  {
    setVisibility(0);
  }
  
  public int c()
  {
    return this.x;
  }
  
  public RedTouch c(int paramInt)
  {
    this.w = paramInt;
    return this;
  }
  
  public void c()
  {
    setVisibility(8);
  }
  
  public int d()
  {
    return this.y;
  }
  
  public RedTouch d(int paramInt)
  {
    this.x = a(paramInt);
    return this;
  }
  
  public int e()
  {
    return this.z;
  }
  
  public RedTouch e(int paramInt)
  {
    this.y = a(paramInt);
    return this;
  }
  
  public RedTouch f(int paramInt)
  {
    this.z = a(paramInt);
    return this;
  }
  
  public void setMaxNum(int paramInt)
  {
    this.A = paramInt;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\classes.jar
 * Qualified Name:     com.tencent.mobileqq.redtouch.RedTouch
 * JD-Core Version:    0.7.0.1
 */