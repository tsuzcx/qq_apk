package com.tencent.widget;

import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.os.Handler;
import android.os.Looper;
import android.util.DisplayMetrics;
import android.util.Pair;
import android.util.SparseArray;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewGroup.MarginLayoutParams;
import android.view.Window;
import android.view.WindowManager.LayoutParams;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.TextView;
import com.tencent.mobileqq.pluginsdk.BasePluginActivity;
import com.tencent.mobileqq.util.Utils;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import lqz;
import lra;
import lrb;
import lrc;
import lre;
import lrf;
import mqq.app.BasePadActivity;

public class ActionSheet
  extends Dialog
{
  public static final int a = 0;
  private static Dialog jdField_a_of_type_AndroidAppDialog;
  public static final String a = "ActionSheet";
  @Deprecated
  public static final int b = 1;
  private static final String jdField_b_of_type_JavaLangString = "common_button_tag";
  @Deprecated
  public static final int c = 2;
  @Deprecated
  public static final int d = 4;
  public static final int e = 3;
  public static final int f = 5;
  public static final int g = 0;
  public static final int h = 1;
  public static final int i = 2;
  public static final int j = 3;
  private Context jdField_a_of_type_AndroidContentContext;
  private Resources jdField_a_of_type_AndroidContentResResources;
  private Handler jdField_a_of_type_AndroidOsHandler;
  private SparseArray jdField_a_of_type_AndroidUtilSparseArray;
  private LayoutInflater jdField_a_of_type_AndroidViewLayoutInflater;
  private View.OnClickListener jdField_a_of_type_AndroidViewView$OnClickListener = new lre(this);
  private ViewGroup jdField_a_of_type_AndroidViewViewGroup;
  private Animation jdField_a_of_type_AndroidViewAnimationAnimation;
  private Button jdField_a_of_type_AndroidWidgetButton;
  private LinearLayout jdField_a_of_type_AndroidWidgetLinearLayout;
  private ActionSheet.OnButtonClickListener jdField_a_of_type_ComTencentWidgetActionSheet$OnButtonClickListener = null;
  private ActionSheet.OnDismissListener jdField_a_of_type_ComTencentWidgetActionSheet$OnDismissListener = null;
  private CharSequence jdField_a_of_type_JavaLangCharSequence;
  public Object a;
  private ArrayList jdField_a_of_type_JavaUtilArrayList;
  private HashSet jdField_a_of_type_JavaUtilHashSet;
  private boolean jdField_a_of_type_Boolean = false;
  private View.OnClickListener jdField_b_of_type_AndroidViewView$OnClickListener = new lrf(this);
  private Animation jdField_b_of_type_AndroidViewAnimationAnimation;
  private LinearLayout jdField_b_of_type_AndroidWidgetLinearLayout;
  private CharSequence jdField_b_of_type_JavaLangCharSequence;
  private boolean jdField_b_of_type_Boolean;
  private LinearLayout jdField_c_of_type_AndroidWidgetLinearLayout;
  private CharSequence jdField_c_of_type_JavaLangCharSequence;
  private boolean jdField_c_of_type_Boolean;
  private boolean d = true;
  private int k = -1;
  private int l = 300;
  
  protected ActionSheet(Context paramContext)
  {
    this(paramContext, false, false);
  }
  
  protected ActionSheet(Context paramContext, boolean paramBoolean1, boolean paramBoolean2)
  {
    super(paramContext, 2131558953);
    this.jdField_a_of_type_AndroidContentContext = paramContext;
    this.jdField_b_of_type_Boolean = paramBoolean1;
    this.jdField_a_of_type_AndroidViewLayoutInflater = LayoutInflater.from(paramContext);
    this.jdField_a_of_type_AndroidContentResResources = paramContext.getResources();
    this.jdField_a_of_type_AndroidOsHandler = new Handler(Looper.getMainLooper());
    if (paramBoolean2)
    {
      requestWindowFeature(1);
      getWindow().setFlags(1024, 1024);
    }
    this.jdField_a_of_type_AndroidViewViewGroup = ((ViewGroup)this.jdField_a_of_type_AndroidViewLayoutInflater.inflate(2130903054, null));
    super.setContentView(this.jdField_a_of_type_AndroidViewViewGroup);
    this.jdField_a_of_type_AndroidWidgetLinearLayout = ((LinearLayout)this.jdField_a_of_type_AndroidViewViewGroup.findViewById(2131296637));
    this.jdField_b_of_type_AndroidWidgetLinearLayout = ((LinearLayout)this.jdField_a_of_type_AndroidViewViewGroup.findViewById(2131296638));
    this.jdField_a_of_type_AndroidViewViewGroup.getChildAt(0).setOnClickListener(this.jdField_b_of_type_AndroidViewView$OnClickListener);
    setCanceledOnTouchOutside(true);
    setOnKeyListener(new lqz(this));
    Utils.a(getWindow(), true);
    a(AnimationUtils.loadAnimation(paramContext, 17432576));
    b(AnimationUtils.loadAnimation(paramContext, 17432577));
  }
  
  private int a(int paramInt)
  {
    switch (paramInt)
    {
    default: 
      return this.jdField_a_of_type_AndroidContentResResources.getColor(2131427482);
    case 0: 
      return this.jdField_a_of_type_AndroidContentResResources.getColor(2131427482);
    case 1: 
      return this.jdField_a_of_type_AndroidContentResResources.getColor(2131427482);
    case 2: 
      return this.jdField_a_of_type_AndroidContentResResources.getColor(2131427482);
    case 4: 
      return this.jdField_a_of_type_AndroidContentResResources.getColor(2131427482);
    case 3: 
      return this.jdField_a_of_type_AndroidContentResResources.getColor(2131427481);
    }
    return this.jdField_a_of_type_AndroidContentResResources.getColor(2131427482);
  }
  
  private LinearLayout a()
  {
    int m = (int)this.jdField_a_of_type_AndroidContentContext.getResources().getDisplayMetrics().density * 16;
    LinearLayout localLinearLayout = new LinearLayout(this.jdField_a_of_type_AndroidContentContext);
    new LinearLayout.LayoutParams(-1, -2).gravity = 17;
    localLinearLayout.setPadding(0, m, 0, m);
    localLinearLayout.setOrientation(1);
    localLinearLayout.setBackgroundResource(17170443);
    return localLinearLayout;
  }
  
  public static ActionSheet a(Context paramContext)
  {
    paramContext = new ActionSheet(paramContext, false, false);
    jdField_a_of_type_AndroidAppDialog = paramContext;
    paramContext.getWindow().setWindowAnimations(2131558950);
    return paramContext;
  }
  
  public static ActionSheet b(Context paramContext)
  {
    paramContext = new ActionSheet(paramContext, false, true);
    jdField_a_of_type_AndroidAppDialog = paramContext;
    paramContext.getWindow().setWindowAnimations(2131558950);
    return paramContext;
  }
  
  public static void b()
  {
    if (jdField_a_of_type_AndroidAppDialog != null) {
      jdField_a_of_type_AndroidAppDialog.dismiss();
    }
  }
  
  public static ActionSheet c(Context paramContext)
  {
    paramContext = new ActionSheet(paramContext, true, false);
    jdField_a_of_type_AndroidAppDialog = paramContext;
    paramContext.getWindow().setWindowAnimations(2131558950);
    return paramContext;
  }
  
  private void c()
  {
    Object localObject = this.jdField_a_of_type_AndroidContentContext;
    int m;
    boolean bool;
    if ((localObject instanceof Activity))
    {
      m = ((Activity)localObject).getWindow().getDecorView().getWidth();
      if (!(localObject instanceof BasePluginActivity)) {
        break label97;
      }
      localObject = ((BasePluginActivity)localObject).getOutActivity();
      if (!(localObject instanceof BasePadActivity)) {
        break label130;
      }
      bool = ((BasePadActivity)localObject).isModeleWindow();
    }
    for (;;)
    {
      localObject = getWindow();
      WindowManager.LayoutParams localLayoutParams = ((Window)localObject).getAttributes();
      localLayoutParams.gravity = 17;
      if (bool) {
        localLayoutParams.width = m;
      }
      for (localLayoutParams.height = -1;; localLayoutParams.height = -1)
      {
        ((Window)localObject).setAttributes(localLayoutParams);
        return;
        label97:
        if (!(localObject instanceof BasePadActivity)) {
          break label130;
        }
        bool = ((BasePadActivity)localObject).isModeleWindow();
        break;
        localLayoutParams.width = -1;
      }
      label130:
      bool = false;
    }
  }
  
  private void d()
  {
    if (this.jdField_c_of_type_AndroidWidgetLinearLayout == null)
    {
      this.jdField_c_of_type_AndroidWidgetLinearLayout = a();
      if (this.jdField_b_of_type_AndroidWidgetLinearLayout != null) {
        this.jdField_b_of_type_AndroidWidgetLinearLayout.addView(this.jdField_c_of_type_AndroidWidgetLinearLayout);
      }
    }
  }
  
  private void e()
  {
    if (this.jdField_c_of_type_Boolean) {
      return;
    }
    View localView;
    Object localObject;
    if (this.jdField_a_of_type_JavaLangCharSequence != null)
    {
      localView = this.jdField_a_of_type_AndroidViewLayoutInflater.inflate(2130903062, null);
      localView.setOnClickListener(new lra(this));
      localObject = (TextView)localView.findViewById(2131296646);
      ((TextView)localObject).setVisibility(0);
      ((TextView)localObject).setText(this.jdField_a_of_type_JavaLangCharSequence);
      ((TextView)localObject).setContentDescription(this.jdField_a_of_type_JavaLangCharSequence);
      if (this.jdField_b_of_type_JavaLangCharSequence != null)
      {
        localObject = (TextView)localView.findViewById(2131296647);
        ((TextView)localObject).setVisibility(0);
        ((TextView)localObject).setText(this.jdField_b_of_type_JavaLangCharSequence);
        ((TextView)localObject).setContentDescription(this.jdField_b_of_type_JavaLangCharSequence);
      }
      this.jdField_b_of_type_AndroidWidgetLinearLayout.addView(localView, 0);
    }
    for (int i1 = 1;; i1 = 0)
    {
      if (this.jdField_a_of_type_JavaUtilArrayList != null)
      {
        this.jdField_a_of_type_JavaUtilArrayList.size();
        int n = this.jdField_a_of_type_JavaUtilArrayList.size();
        int m = 0;
        if (m < n)
        {
          localView = this.jdField_a_of_type_AndroidViewLayoutInflater.inflate(2130903056, null);
          localView.setTag("common_button_tag");
          localObject = (TextView)localView.findViewById(2131296641);
          Pair localPair = (Pair)this.jdField_a_of_type_JavaUtilArrayList.get(m);
          ((TextView)localObject).setText((CharSequence)localPair.first);
          ((TextView)localObject).setContentDescription(localPair.first + "按钮");
          localView.setId(m);
          localView.setOnClickListener(this.jdField_a_of_type_AndroidViewView$OnClickListener);
          this.jdField_b_of_type_AndroidWidgetLinearLayout.addView(localView);
          if (this.jdField_a_of_type_Boolean)
          {
            if (this.jdField_a_of_type_AndroidUtilSparseArray == null) {
              this.jdField_a_of_type_AndroidUtilSparseArray = new SparseArray();
            }
            this.jdField_a_of_type_AndroidUtilSparseArray.append(m, localView);
            if (m != this.k) {
              break label368;
            }
            localView.findViewById(2131296642).setVisibility(8);
            ((TextView)localObject).setContentDescription("已选定" + localPair.first);
          }
          for (;;)
          {
            m += 1;
            break;
            label368:
            ((TextView)localObject).setContentDescription("未选定" + localPair.first);
          }
        }
        f();
      }
      if (this.jdField_c_of_type_JavaLangCharSequence != null)
      {
        localView = this.jdField_a_of_type_AndroidViewLayoutInflater.inflate(2130903173, null);
        localObject = (Button)localView.findViewById(2131296643);
        ((Button)localObject).setOnClickListener(this.jdField_b_of_type_AndroidViewView$OnClickListener);
        ((Button)localObject).setText(this.jdField_c_of_type_JavaLangCharSequence);
        ((Button)localObject).setContentDescription(this.jdField_c_of_type_JavaLangCharSequence);
        localObject = new LinearLayout.LayoutParams(-2, -2);
        ((LinearLayout.LayoutParams)localObject).gravity = 5;
        ((LinearLayout.LayoutParams)localObject).rightMargin = this.jdField_a_of_type_AndroidContentResResources.getDimensionPixelSize(2131493503);
        ((LinearLayout.LayoutParams)localObject).bottomMargin = this.jdField_a_of_type_AndroidContentResResources.getDimensionPixelSize(2131493504);
        localView.setLayoutParams((ViewGroup.LayoutParams)localObject);
        this.jdField_b_of_type_AndroidWidgetLinearLayout.addView(localView);
        localView.setVisibility(8);
      }
      this.jdField_c_of_type_Boolean = true;
      return;
    }
  }
  
  private void f()
  {
    int n = this.jdField_a_of_type_AndroidContentResResources.getDimensionPixelSize(2131493499);
    Object localObject1 = new ArrayList();
    int m = 0;
    while (m < this.jdField_b_of_type_AndroidWidgetLinearLayout.getChildCount())
    {
      localObject2 = this.jdField_b_of_type_AndroidWidgetLinearLayout.getChildAt(m);
      if ((localObject2 != null) && (((View)localObject2).getTag() != null) && ("common_button_tag".equals(((View)localObject2).getTag().toString()))) {
        ((List)localObject1).add(localObject2);
      }
      m += 1;
    }
    Object localObject2 = (View)((List)localObject1).get(0);
    localObject1 = (View)((List)localObject1).get(((List)localObject1).size() - 1);
    if (localObject2 != null)
    {
      localObject2 = (ViewGroup.MarginLayoutParams)((View)localObject2).getLayoutParams();
      ((ViewGroup.MarginLayoutParams)localObject2).topMargin += n;
    }
    if (localObject1 != null)
    {
      localObject1 = (ViewGroup.MarginLayoutParams)((View)localObject1).getLayoutParams();
      ((ViewGroup.MarginLayoutParams)localObject1).bottomMargin += n;
    }
  }
  
  public Drawable a(int paramInt)
  {
    switch (paramInt)
    {
    default: 
      return this.jdField_a_of_type_AndroidContentResResources.getDrawable(2130837533);
    case 0: 
      return this.jdField_a_of_type_AndroidContentResResources.getDrawable(2130837530);
    case 1: 
      return this.jdField_a_of_type_AndroidContentResResources.getDrawable(2130837533);
    case 2: 
      return this.jdField_a_of_type_AndroidContentResResources.getDrawable(2130837527);
    }
    return this.jdField_a_of_type_AndroidContentResResources.getDrawable(2130837524);
  }
  
  public String a(int paramInt)
  {
    if ((this.jdField_a_of_type_JavaUtilArrayList != null) && (paramInt < this.jdField_a_of_type_JavaUtilArrayList.size()))
    {
      Pair localPair = (Pair)this.jdField_a_of_type_JavaUtilArrayList.get(paramInt);
      if (localPair != null) {
        return ((CharSequence)localPair.first).toString();
      }
    }
    return null;
  }
  
  /* Error */
  public void a()
  {
    // Byte code:
    //   0: aconst_null
    //   1: putstatic 247	com/tencent/widget/ActionSheet:jdField_a_of_type_AndroidAppDialog	Landroid/app/Dialog;
    //   4: aload_0
    //   5: invokespecial 262	android/app/Dialog:dismiss	()V
    //   8: aload_0
    //   9: invokestatic 472	com/tencent/mobileqq/memoryleak/ActivityLeakSolution:a	(Landroid/app/Dialog;)V
    //   12: return
    //   13: astore_1
    //   14: aload_0
    //   15: invokestatic 472	com/tencent/mobileqq/memoryleak/ActivityLeakSolution:a	(Landroid/app/Dialog;)V
    //   18: return
    //   19: astore_1
    //   20: aload_0
    //   21: invokestatic 472	com/tencent/mobileqq/memoryleak/ActivityLeakSolution:a	(Landroid/app/Dialog;)V
    //   24: aload_1
    //   25: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	26	0	this	ActionSheet
    //   13	1	1	localException	Exception
    //   19	6	1	localObject	Object
    // Exception table:
    //   from	to	target	type
    //   0	8	13	java/lang/Exception
    //   0	8	19	finally
  }
  
  public void a(int paramInt)
  {
    a(this.jdField_a_of_type_AndroidContentResResources.getText(paramInt));
  }
  
  public void a(int paramInt1, int paramInt2)
  {
    a(this.jdField_a_of_type_AndroidContentResResources.getText(paramInt1), paramInt2);
  }
  
  public void a(int paramInt1, int paramInt2, boolean paramBoolean)
  {
    a(this.jdField_a_of_type_AndroidContentResResources.getText(paramInt1), paramInt2, paramBoolean);
  }
  
  public void a(int paramInt, CharSequence paramCharSequence)
  {
    a(paramInt, paramCharSequence, 0);
  }
  
  public void a(int paramInt1, CharSequence paramCharSequence, int paramInt2)
  {
    if ((paramInt1 >= 0) && (this.jdField_a_of_type_JavaUtilArrayList != null) && (paramInt1 < this.jdField_a_of_type_JavaUtilArrayList.size()))
    {
      Object localObject = this.jdField_b_of_type_AndroidWidgetLinearLayout.findViewById(paramInt1);
      if (localObject != null)
      {
        localObject = ((View)localObject).findViewById(2131296640);
        if ((localObject != null) && (TextView.class.isInstance(localObject)))
        {
          localObject = (TextView)localObject;
          ((TextView)localObject).setText(paramCharSequence);
          ((TextView)localObject).setTextColor(a(paramInt2));
          paramCharSequence = new Pair(paramCharSequence, Integer.valueOf(paramInt2));
          this.jdField_a_of_type_JavaUtilArrayList.set(paramInt1, paramCharSequence);
        }
      }
    }
  }
  
  public void a(int paramInt, boolean paramBoolean)
  {
    a(paramInt, 0, paramBoolean);
  }
  
  public void a(View paramView)
  {
    this.jdField_b_of_type_AndroidWidgetLinearLayout.addView(paramView);
  }
  
  @Deprecated
  public void a(View paramView, LinearLayout.LayoutParams paramLayoutParams)
  {
    if (paramView != null)
    {
      LinearLayout.LayoutParams localLayoutParams = paramLayoutParams;
      if (paramLayoutParams == null) {
        localLayoutParams = new LinearLayout.LayoutParams(-1, -2);
      }
      this.jdField_b_of_type_AndroidWidgetLinearLayout.addView(paramView, 0, localLayoutParams);
    }
  }
  
  public void a(Animation paramAnimation)
  {
    this.jdField_a_of_type_AndroidViewAnimationAnimation = paramAnimation;
  }
  
  public void a(ActionSheet.OnButtonClickListener paramOnButtonClickListener)
  {
    this.jdField_a_of_type_ComTencentWidgetActionSheet$OnButtonClickListener = paramOnButtonClickListener;
  }
  
  public void a(ActionSheet.OnDismissListener paramOnDismissListener)
  {
    this.jdField_a_of_type_ComTencentWidgetActionSheet$OnDismissListener = paramOnDismissListener;
  }
  
  public void a(CharSequence paramCharSequence)
  {
    if (paramCharSequence != null) {
      this.jdField_a_of_type_JavaLangCharSequence = paramCharSequence;
    }
  }
  
  public void a(CharSequence paramCharSequence, int paramInt)
  {
    if (paramCharSequence != null)
    {
      if (this.jdField_a_of_type_JavaUtilArrayList == null) {
        this.jdField_a_of_type_JavaUtilArrayList = new ArrayList();
      }
      paramCharSequence = new Pair(paramCharSequence, Integer.valueOf(paramInt));
      if (!this.jdField_a_of_type_JavaUtilArrayList.contains(paramCharSequence)) {
        this.jdField_a_of_type_JavaUtilArrayList.add(paramCharSequence);
      }
      if (this.jdField_a_of_type_Boolean) {
        throw new UnsupportedOperationException("ActionSheet is in radio group mode,shouldn't call addButton!");
      }
    }
  }
  
  public void a(CharSequence paramCharSequence, int paramInt, boolean paramBoolean)
  {
    a(paramCharSequence, paramInt, paramBoolean, true);
  }
  
  public void a(CharSequence paramCharSequence, int paramInt, boolean paramBoolean1, boolean paramBoolean2)
  {
    if (paramCharSequence != null)
    {
      if ((!this.jdField_a_of_type_Boolean) && (this.jdField_a_of_type_JavaUtilArrayList != null) && (this.jdField_a_of_type_JavaUtilArrayList.size() > 0)) {
        throw new UnsupportedOperationException("ActionSheet is in normal button mode,shouldn't call addRadioButton!");
      }
      if (this.jdField_a_of_type_JavaUtilArrayList == null) {
        this.jdField_a_of_type_JavaUtilArrayList = new ArrayList();
      }
      paramCharSequence = new Pair(paramCharSequence, Integer.valueOf(paramInt));
      if (!this.jdField_a_of_type_JavaUtilArrayList.contains(paramCharSequence)) {
        this.jdField_a_of_type_JavaUtilArrayList.add(paramCharSequence);
      }
      if (paramBoolean2) {
        break label139;
      }
      if (this.jdField_a_of_type_JavaUtilHashSet == null) {
        this.jdField_a_of_type_JavaUtilHashSet = new HashSet();
      }
      this.jdField_a_of_type_JavaUtilHashSet.add(Integer.valueOf(this.jdField_a_of_type_JavaUtilArrayList.size() - 1));
    }
    for (;;)
    {
      this.jdField_a_of_type_Boolean = true;
      return;
      label139:
      if (paramBoolean1) {
        this.k = (this.jdField_a_of_type_JavaUtilArrayList.size() - 1);
      }
    }
  }
  
  public void a(CharSequence paramCharSequence, boolean paramBoolean)
  {
    a(paramCharSequence, 0, paramBoolean);
  }
  
  public void a(String paramString)
  {
    d();
    View localView = this.jdField_a_of_type_AndroidViewLayoutInflater.inflate(2130903060, null);
    localView.setOnClickListener(this.jdField_a_of_type_AndroidViewView$OnClickListener);
    ((TextView)localView.findViewById(2131296641)).setText(paramString);
    this.jdField_c_of_type_AndroidWidgetLinearLayout.addView(localView);
  }
  
  public void a(boolean paramBoolean)
  {
    if (paramBoolean)
    {
      this.jdField_a_of_type_AndroidViewViewGroup.setOnClickListener(this.jdField_b_of_type_AndroidViewView$OnClickListener);
      return;
    }
    this.jdField_a_of_type_AndroidViewViewGroup.setOnClickListener(null);
  }
  
  public void a(int... paramVarArgs)
  {
    d();
    int n = paramVarArgs.length;
    int m = 0;
    while (m < n)
    {
      int i1 = paramVarArgs[m];
      View localView = this.jdField_a_of_type_AndroidViewLayoutInflater.inflate(2130903060, null);
      localView.setId(i1);
      localView.setOnClickListener(this.jdField_a_of_type_AndroidViewView$OnClickListener);
      ((TextView)localView.findViewById(2131296641)).setText(this.jdField_a_of_type_AndroidContentResResources.getString(i1));
      this.jdField_c_of_type_AndroidWidgetLinearLayout.addView(localView);
      m += 1;
    }
  }
  
  public void a(String[] paramArrayOfString, int[] paramArrayOfInt)
  {
    if ((paramArrayOfString == null) || (paramArrayOfInt == null)) {
      throw new IllegalArgumentException("arg is error");
    }
    int n = paramArrayOfString.length;
    if (n != paramArrayOfInt.length) {
      throw new IllegalArgumentException("arg is error");
    }
    d();
    int m = 0;
    while (m < n)
    {
      View localView = this.jdField_a_of_type_AndroidViewLayoutInflater.inflate(2130903060, null);
      localView.setId(paramArrayOfInt[m]);
      localView.setOnClickListener(this.jdField_a_of_type_AndroidViewView$OnClickListener);
      ((TextView)localView.findViewById(2131296641)).setText(paramArrayOfString[m]);
      this.jdField_c_of_type_AndroidWidgetLinearLayout.addView(localView);
      m += 1;
    }
  }
  
  public void b(int paramInt)
  {
    b(this.jdField_a_of_type_AndroidContentResResources.getText(paramInt));
  }
  
  public void b(View paramView, LinearLayout.LayoutParams paramLayoutParams)
  {
    if (paramView != null)
    {
      this.jdField_a_of_type_AndroidWidgetLinearLayout.removeAllViews();
      LinearLayout.LayoutParams localLayoutParams = paramLayoutParams;
      if (paramLayoutParams == null) {
        localLayoutParams = new LinearLayout.LayoutParams(-1, -2);
      }
      this.jdField_a_of_type_AndroidWidgetLinearLayout.addView(paramView, localLayoutParams);
    }
  }
  
  public void b(Animation paramAnimation)
  {
    this.jdField_b_of_type_AndroidViewAnimationAnimation = paramAnimation;
  }
  
  public void b(CharSequence paramCharSequence)
  {
    if (paramCharSequence != null) {
      this.jdField_b_of_type_JavaLangCharSequence = paramCharSequence;
    }
  }
  
  public void c(int paramInt)
  {
    a(this.jdField_a_of_type_AndroidContentResResources.getText(paramInt), 0);
  }
  
  public void c(CharSequence paramCharSequence)
  {
    a(paramCharSequence, 0);
  }
  
  public void d(int paramInt)
  {
    d();
    View localView = this.jdField_a_of_type_AndroidViewLayoutInflater.inflate(2130903060, null);
    localView.setId(paramInt);
    localView.setOnClickListener(this.jdField_a_of_type_AndroidViewView$OnClickListener);
    ((TextView)localView.findViewById(2131296641)).setText(this.jdField_a_of_type_AndroidContentResResources.getString(paramInt));
    this.jdField_c_of_type_AndroidWidgetLinearLayout.addView(localView);
  }
  
  public void d(CharSequence paramCharSequence)
  {
    if (paramCharSequence != null) {
      this.jdField_c_of_type_JavaLangCharSequence = paramCharSequence;
    }
  }
  
  public void dismiss()
  {
    if (this.d)
    {
      this.d = false;
      this.jdField_a_of_type_AndroidOsHandler.postDelayed(new lrc(this), 0L);
    }
  }
  
  public void e(int paramInt)
  {
    d(this.jdField_a_of_type_AndroidContentResResources.getText(paramInt));
  }
  
  public void f(int paramInt)
  {
    if ((paramInt >= 0) && (this.jdField_a_of_type_JavaUtilArrayList != null) && (paramInt < this.jdField_a_of_type_JavaUtilArrayList.size()))
    {
      this.k = paramInt;
      if (this.jdField_a_of_type_AndroidUtilSparseArray != null)
      {
        View localView = (View)this.jdField_a_of_type_AndroidUtilSparseArray.get(this.k);
        if (localView != null) {
          localView.findViewById(2131296642).setVisibility(0);
        }
      }
    }
  }
  
  public void g(int paramInt)
  {
    if (paramInt > 0) {
      this.l = paramInt;
    }
  }
  
  public boolean onPrepareOptionsMenu(Menu paramMenu)
  {
    if (this.jdField_b_of_type_Boolean) {}
    try
    {
      dismiss();
      label11:
      return super.onPrepareOptionsMenu(paramMenu);
    }
    catch (Exception localException)
    {
      break label11;
    }
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    if (paramBoolean) {
      c();
    }
  }
  
  public void setContentView(int paramInt)
  {
    throw new UnsupportedOperationException("this method is not support");
  }
  
  public void setContentView(View paramView)
  {
    throw new UnsupportedOperationException("this method is not support");
  }
  
  public void setTitle(int paramInt)
  {
    throw new UnsupportedOperationException("this method is not support");
  }
  
  public void setTitle(CharSequence paramCharSequence)
  {
    throw new UnsupportedOperationException("this method is not support");
  }
  
  public void show()
  {
    super.show();
    jdField_a_of_type_AndroidAppDialog = this;
    e();
    this.jdField_a_of_type_AndroidOsHandler.postDelayed(new lrb(this), 0L);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     com.tencent.widget.ActionSheet
 * JD-Core Version:    0.7.0.1
 */