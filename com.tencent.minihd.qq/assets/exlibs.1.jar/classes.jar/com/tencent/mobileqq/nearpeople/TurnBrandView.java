package com.tencent.mobileqq.nearpeople;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.MeasureSpec;
import android.view.View.OnClickListener;
import android.view.animation.AccelerateInterpolator;
import android.view.animation.Animation;
import android.view.animation.TranslateAnimation;
import android.widget.FrameLayout;
import android.widget.FrameLayout.LayoutParams;
import android.widget.ImageView;
import com.tencent.mobileqq.activity.aio.AIOUtils;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Queue;
import jku;
import jkz;
import jla;
import jlb;

public class TurnBrandView
  extends FrameLayout
  implements View.OnClickListener
{
  private static final float jdField_a_of_type_Float = 0.0F;
  private static final int jdField_a_of_type_Int = 4;
  private static final String jdField_a_of_type_JavaLangString = "TurnBrandView";
  private static final int jdField_b_of_type_Int = 15;
  private static final int c = 15;
  private static final int d = 25;
  private static final int e = 20;
  private static final int f = 56;
  private Context jdField_a_of_type_AndroidContentContext;
  private Resources jdField_a_of_type_AndroidContentResResources;
  private ImageView jdField_a_of_type_AndroidWidgetImageView;
  private QQAppInterface jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
  private FlingBrandListener.FlingListener jdField_a_of_type_ComTencentMobileqqNearpeopleFlingBrandListener$FlingListener;
  private FlingBrandListener jdField_a_of_type_ComTencentMobileqqNearpeopleFlingBrandListener;
  private TurnBrandCardView jdField_a_of_type_ComTencentMobileqqNearpeopleTurnBrandCardView;
  private TurnBrandView.onFlingListener jdField_a_of_type_ComTencentMobileqqNearpeopleTurnBrandView$onFlingListener;
  private final Object jdField_a_of_type_JavaLangObject = new Object();
  private Queue jdField_a_of_type_JavaUtilQueue;
  private boolean jdField_a_of_type_Boolean;
  private TurnBrandCardView[] jdField_a_of_type_ArrayOfComTencentMobileqqNearpeopleTurnBrandCardView;
  private ImageView jdField_b_of_type_AndroidWidgetImageView;
  private boolean jdField_b_of_type_Boolean;
  private int g;
  private int h;
  private int i;
  private int j;
  private int k;
  private int l;
  private int m;
  private int n;
  private int o;
  private int p;
  
  public TurnBrandView(Context paramContext)
  {
    super(paramContext);
    this.jdField_a_of_type_AndroidContentContext = paramContext;
    this.jdField_a_of_type_AndroidContentResResources = this.jdField_a_of_type_AndroidContentContext.getResources();
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = ((TurnBrandActivity)paramContext).app;
    ((LayoutInflater)this.jdField_a_of_type_AndroidContentContext.getSystemService("layout_inflater")).inflate(2130903975, this, true);
    this.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)findViewById(2131300322));
    this.jdField_a_of_type_AndroidWidgetImageView.setOnClickListener(this);
    this.jdField_b_of_type_AndroidWidgetImageView = ((ImageView)findViewById(2131300323));
    this.jdField_b_of_type_AndroidWidgetImageView.setOnClickListener(this);
    this.jdField_a_of_type_JavaUtilQueue = new LinkedList();
    this.jdField_a_of_type_ComTencentMobileqqNearpeopleFlingBrandListener$FlingListener = new jkz(this);
    this.jdField_a_of_type_ArrayOfComTencentMobileqqNearpeopleTurnBrandCardView = new TurnBrandCardView[4];
    this.h = getChildCount();
    this.m = AIOUtils.a(15.0F, this.jdField_a_of_type_AndroidContentResResources);
    this.n = AIOUtils.a(15.0F, this.jdField_a_of_type_AndroidContentResResources);
    this.o = AIOUtils.a(25.0F, this.jdField_a_of_type_AndroidContentResResources);
    this.p = AIOUtils.a(56.0F, this.jdField_a_of_type_AndroidContentResResources);
    int i1 = 0;
    while (i1 < 4)
    {
      this.jdField_a_of_type_ArrayOfComTencentMobileqqNearpeopleTurnBrandCardView[i1] = new TurnBrandCardView(this.jdField_a_of_type_AndroidContentContext);
      paramContext = new FrameLayout.LayoutParams(-1, -1);
      paramContext.leftMargin = this.m;
      paramContext.rightMargin = this.n;
      paramContext.topMargin = this.o;
      this.jdField_a_of_type_ArrayOfComTencentMobileqqNearpeopleTurnBrandCardView[i1].setLayoutParams(paramContext);
      addView(this.jdField_a_of_type_ArrayOfComTencentMobileqqNearpeopleTurnBrandCardView[i1], this.h, paramContext);
      i1 += 1;
    }
    this.jdField_a_of_type_ComTencentMobileqqNearpeopleTurnBrandCardView = this.jdField_a_of_type_ArrayOfComTencentMobileqqNearpeopleTurnBrandCardView[0];
    this.jdField_a_of_type_Boolean = true;
  }
  
  private void a()
  {
    Iterator localIterator = a();
    if (!localIterator.hasNext())
    {
      this.jdField_a_of_type_ComTencentMobileqqNearpeopleTurnBrandView$onFlingListener.b();
      this.jdField_a_of_type_Boolean = true;
    }
    for (;;)
    {
      return;
      int i1 = 0;
      while ((localIterator.hasNext()) && (i1 < 4))
      {
        TurnBrandCardView localTurnBrandCardView = this.jdField_a_of_type_ArrayOfComTencentMobileqqNearpeopleTurnBrandCardView[i1];
        jku localjku = (jku)localIterator.next();
        localTurnBrandCardView.a(localjku.jdField_b_of_type_JavaLangString, localjku.c, localjku.jdField_b_of_type_Int);
        localTurnBrandCardView.a(TurnBrandDownloader.a(localjku.jdField_b_of_type_JavaLangString));
        i1 += 1;
      }
    }
  }
  
  private void a(boolean paramBoolean)
  {
    if (NetworkUtil.f(BaseApplication.getContext())) {
      this.jdField_a_of_type_ComTencentMobileqqNearpeopleFlingBrandListener.a(paramBoolean);
    }
    for (;;)
    {
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(new jla(this));
      return;
      ((TurnBrandActivity)this.jdField_a_of_type_AndroidContentContext).a(2131369584);
    }
  }
  
  public int a()
  {
    return this.jdField_a_of_type_JavaUtilQueue.size();
  }
  
  public Iterator a()
  {
    return this.jdField_a_of_type_JavaUtilQueue.iterator();
  }
  
  public jku a()
  {
    synchronized (this.jdField_a_of_type_JavaLangObject)
    {
      jku localjku = (jku)this.jdField_a_of_type_JavaUtilQueue.poll();
      a();
      return localjku;
    }
  }
  
  public void a(Bitmap paramBitmap, String paramString)
  {
    int i1 = 0;
    for (;;)
    {
      if (i1 < 4)
      {
        TurnBrandCardView localTurnBrandCardView = this.jdField_a_of_type_ArrayOfComTencentMobileqqNearpeopleTurnBrandCardView[i1];
        if (paramString.equals(localTurnBrandCardView.a())) {
          localTurnBrandCardView.a(paramBitmap);
        }
      }
      else
      {
        return;
      }
      i1 += 1;
    }
  }
  
  public boolean a()
  {
    return this.jdField_a_of_type_JavaUtilQueue.isEmpty();
  }
  
  public jku b()
  {
    synchronized (this.jdField_a_of_type_JavaLangObject)
    {
      jku localjku = (jku)this.jdField_a_of_type_JavaUtilQueue.peek();
      return localjku;
    }
  }
  
  public void onClick(View paramView)
  {
    switch (paramView.getId())
    {
    default: 
      return;
    case 2131300322: 
      if (QLog.isColorLevel()) {
        QLog.d("TurnBrandView", 2, "user clicked dislike!");
      }
      a(true);
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.d("TurnBrandView", 2, "user clicked like!");
    }
    a(false);
  }
  
  @SuppressLint({"DrawAllocation"})
  protected void onLayout(boolean paramBoolean, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    super.onLayout(paramBoolean, paramInt1, paramInt2, paramInt3, paramInt4);
    paramInt2 = (this.o + paramInt4 + this.j + this.l) / 2 - this.p / 2;
    paramInt4 = this.p + paramInt2;
    this.jdField_a_of_type_AndroidWidgetImageView.layout((paramInt3 - paramInt1 - this.p * 2) / 3 + paramInt1, paramInt2, (paramInt3 - paramInt1 - this.p * 2) / 3 + paramInt1 + this.p, paramInt4);
    this.jdField_b_of_type_AndroidWidgetImageView.layout((paramInt3 - paramInt1 - this.p * 2) * 2 / 3 + paramInt1 + this.p, paramInt2, (paramInt3 - paramInt1 - this.p * 2) * 2 / 3 + paramInt1 + this.p * 2, paramInt4);
    paramInt3 = a();
    paramInt1 = 0;
    if (paramInt1 < 4)
    {
      TurnBrandCardView localTurnBrandCardView = this.jdField_a_of_type_ArrayOfComTencentMobileqqNearpeopleTurnBrandCardView[paramInt1];
      Object localObject = (FrameLayout.LayoutParams)localTurnBrandCardView.getLayoutParams();
      paramInt4 = localTurnBrandCardView.getMeasuredWidth();
      int i1 = localTurnBrandCardView.getMeasuredHeight();
      int i2 = (getWidth() + getPaddingLeft() - getPaddingRight() - paramInt4) / 2 + ((FrameLayout.LayoutParams)localObject).leftMargin - ((FrameLayout.LayoutParams)localObject).rightMargin;
      int i3 = getPaddingTop();
      int i4 = ((FrameLayout.LayoutParams)localObject).topMargin;
      if (paramInt1 == 3) {}
      for (paramInt2 = paramInt1 - 1;; paramInt2 = paramInt1)
      {
        paramInt2 = paramInt2 * this.l * 3 + (i3 + i4);
        localTurnBrandCardView.setInitAlpha(255 - paramInt1 * 20);
        localTurnBrandCardView.setInitLeftAndTop(i2, paramInt2);
        localTurnBrandCardView.layout(i2, paramInt2, i2 + paramInt4, paramInt2 + i1);
        if (this.jdField_a_of_type_Boolean)
        {
          localTurnBrandCardView.setVisibility(8);
          localObject = new TranslateAnimation(-paramInt4, 0.0F, -i1, 0.0F);
          ((TranslateAnimation)localObject).setDuration(500L);
          ((TranslateAnimation)localObject).setInterpolator(new AccelerateInterpolator());
          ((TranslateAnimation)localObject).setAnimationListener(new jlb(this, localTurnBrandCardView));
          localTurnBrandCardView.startAnimation((Animation)localObject);
        }
        if (paramInt1 >= paramInt3) {
          localTurnBrandCardView.setVisibility(8);
        }
        paramInt1 += 1;
        break;
      }
    }
    if (!this.jdField_b_of_type_Boolean)
    {
      this.jdField_b_of_type_Boolean = true;
      this.jdField_a_of_type_ComTencentMobileqqNearpeopleFlingBrandListener = new FlingBrandListener(this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_ComTencentMobileqqNearpeopleTurnBrandCardView, b(), 0.0F, this.jdField_a_of_type_ComTencentMobileqqNearpeopleFlingBrandListener$FlingListener);
      this.jdField_a_of_type_ComTencentMobileqqNearpeopleTurnBrandCardView.setOnTouchListener(this.jdField_a_of_type_ComTencentMobileqqNearpeopleFlingBrandListener);
    }
    this.jdField_a_of_type_Boolean = false;
  }
  
  protected void onMeasure(int paramInt1, int paramInt2)
  {
    super.onMeasure(paramInt1, paramInt2);
    paramInt1 = View.MeasureSpec.getSize(paramInt1);
    paramInt2 = View.MeasureSpec.getSize(paramInt2);
    this.i = (paramInt1 - this.m - this.n);
    this.j = (this.i * 21 / 20);
    if (this.j + this.p * 3 / 2 > paramInt2) {
      this.j = (paramInt2 - this.o - this.p * 2);
    }
    this.k = (this.i / 33);
    this.l = (this.j / 33);
    paramInt1 = 0;
    if (paramInt1 < 4)
    {
      TurnBrandCardView localTurnBrandCardView = this.jdField_a_of_type_ArrayOfComTencentMobileqqNearpeopleTurnBrandCardView[paramInt1];
      FrameLayout.LayoutParams localLayoutParams = (FrameLayout.LayoutParams)localTurnBrandCardView.getLayoutParams();
      int i2 = this.i;
      int i3 = this.k;
      label147:
      int i4;
      int i5;
      if (paramInt1 == 3)
      {
        paramInt2 = paramInt1 - 1;
        i4 = this.j;
        i5 = this.l;
        if (paramInt1 != 3) {
          break label215;
        }
      }
      label215:
      for (int i1 = paramInt1 - 1;; i1 = paramInt1)
      {
        localTurnBrandCardView.measure(View.MeasureSpec.makeMeasureSpec(i2 - paramInt2 * (i3 * 2), 1073741824), View.MeasureSpec.makeMeasureSpec(i4 - i1 * (i5 * 2), 1073741824));
        paramInt1 += 1;
        break;
        paramInt2 = paramInt1;
        break label147;
      }
    }
  }
  
  public void setDataList(Collection paramCollection)
  {
    synchronized (this.jdField_a_of_type_JavaLangObject)
    {
      this.jdField_a_of_type_JavaUtilQueue.clear();
      if ((paramCollection != null) && (!paramCollection.isEmpty())) {
        this.jdField_a_of_type_JavaUtilQueue.addAll(paramCollection);
      }
      a();
      requestLayout();
      this.jdField_a_of_type_Boolean = true;
      return;
    }
  }
  
  public void setOnFlingListener(TurnBrandView.onFlingListener paramonFlingListener)
  {
    this.jdField_a_of_type_ComTencentMobileqqNearpeopleTurnBrandView$onFlingListener = paramonFlingListener;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     com.tencent.mobileqq.nearpeople.TurnBrandView
 * JD-Core Version:    0.7.0.1
 */