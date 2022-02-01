package android.support.v4.view;

import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.database.DataSetObserver;
import android.graphics.drawable.Drawable;
import android.text.TextUtils.TruncateAt;
import android.text.method.SingleLineTransformationMethod;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.view.View;
import android.view.View.MeasureSpec;
import android.view.ViewGroup;
import android.widget.TextView;
import java.lang.ref.WeakReference;
import java.util.Locale;

@ViewPager.a
public class PagerTitleStrip
  extends ViewGroup
{
  private static final int[] QA = { 16842804, 16842901, 16842904, 16842927 };
  private static final int[] QB = { 16843660 };
  private int Ku;
  private int QC;
  int QD;
  ViewPager Qp;
  TextView Qq;
  TextView Qr;
  TextView Qs;
  private int Qt = -1;
  float Qu = -1.0F;
  private int Qv;
  private boolean Qw;
  private boolean Qx;
  private final a Qy = new a();
  private WeakReference<q> Qz;
  
  public PagerTitleStrip(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    TextView localTextView = new TextView(paramContext);
    this.Qq = localTextView;
    addView(localTextView);
    localTextView = new TextView(paramContext);
    this.Qr = localTextView;
    addView(localTextView);
    localTextView = new TextView(paramContext);
    this.Qs = localTextView;
    addView(localTextView);
    paramAttributeSet = paramContext.obtainStyledAttributes(paramAttributeSet, QA);
    int i = paramAttributeSet.getResourceId(0, 0);
    if (i != 0)
    {
      android.support.v4.widget.q.d(this.Qq, i);
      android.support.v4.widget.q.d(this.Qr, i);
      android.support.v4.widget.q.d(this.Qs, i);
    }
    int j = paramAttributeSet.getDimensionPixelSize(1, 0);
    if (j != 0)
    {
      float f = j;
      this.Qq.setTextSize(0, f);
      this.Qr.setTextSize(0, f);
      this.Qs.setTextSize(0, f);
    }
    if (paramAttributeSet.hasValue(2))
    {
      j = paramAttributeSet.getColor(2, 0);
      this.Qq.setTextColor(j);
      this.Qr.setTextColor(j);
      this.Qs.setTextColor(j);
    }
    this.Ku = paramAttributeSet.getInteger(3, 80);
    paramAttributeSet.recycle();
    this.QD = this.Qr.getTextColors().getDefaultColor();
    setNonPrimaryAlpha(0.6F);
    this.Qq.setEllipsize(TextUtils.TruncateAt.END);
    this.Qr.setEllipsize(TextUtils.TruncateAt.END);
    this.Qs.setEllipsize(TextUtils.TruncateAt.END);
    if (i != 0)
    {
      paramAttributeSet = paramContext.obtainStyledAttributes(i, QB);
      bool = paramAttributeSet.getBoolean(0, false);
      paramAttributeSet.recycle();
    }
    if (bool)
    {
      setSingleLineAllCaps(this.Qq);
      setSingleLineAllCaps(this.Qr);
      setSingleLineAllCaps(this.Qs);
    }
    for (;;)
    {
      this.Qv = ((int)(paramContext.getResources().getDisplayMetrics().density * 16.0F));
      return;
      this.Qq.setSingleLine();
      this.Qr.setSingleLine();
      this.Qs.setSingleLine();
    }
  }
  
  private static void setSingleLineAllCaps(TextView paramTextView)
  {
    paramTextView.setTransformationMethod(new b(paramTextView.getContext()));
  }
  
  void a(int paramInt, float paramFloat, boolean paramBoolean)
  {
    int m;
    int i4;
    int k;
    int i3;
    int n;
    int i;
    int i2;
    int i1;
    int j;
    int i5;
    int i7;
    int i6;
    int i8;
    if (paramInt != this.Qt)
    {
      a(paramInt, this.Qp.getAdapter());
      this.Qx = true;
      m = this.Qq.getMeasuredWidth();
      i4 = this.Qr.getMeasuredWidth();
      k = this.Qs.getMeasuredWidth();
      i3 = i4 / 2;
      n = getWidth();
      i = getHeight();
      i2 = getPaddingLeft();
      i1 = getPaddingRight();
      paramInt = getPaddingTop();
      j = getPaddingBottom();
      i5 = i1 + i3;
      float f2 = 0.5F + paramFloat;
      float f1 = f2;
      if (f2 > 1.0F) {
        f1 = f2 - 1.0F;
      }
      i3 = n - i5 - (int)(f1 * (n - (i2 + i3) - i5)) - i3;
      i4 = i3 + i4;
      i7 = this.Qq.getBaseline();
      i6 = this.Qr.getBaseline();
      i5 = this.Qs.getBaseline();
      i8 = Math.max(Math.max(i7, i6), i5);
      i7 = i8 - i7;
      i6 = i8 - i6;
      i5 = i8 - i5;
      i8 = this.Qq.getMeasuredHeight();
      int i9 = this.Qr.getMeasuredHeight();
      int i10 = this.Qs.getMeasuredHeight();
      i8 = Math.max(Math.max(i8 + i7, i9 + i6), i10 + i5);
      switch (this.Ku & 0x70)
      {
      default: 
        j = paramInt + i7;
        i = paramInt + i6;
        paramInt += i5;
      }
    }
    for (;;)
    {
      this.Qr.layout(i3, i, i4, this.Qr.getMeasuredHeight() + i);
      i = Math.min(i2, i3 - this.Qv - m);
      this.Qq.layout(i, j, m + i, this.Qq.getMeasuredHeight() + j);
      i = Math.max(n - i1 - k, this.Qv + i4);
      this.Qs.layout(i, paramInt, i + k, this.Qs.getMeasuredHeight() + paramInt);
      this.Qu = paramFloat;
      this.Qx = false;
      return;
      if ((paramBoolean) || (paramFloat != this.Qu)) {
        break;
      }
      return;
      paramInt = (i - paramInt - j - i8) / 2;
      j = paramInt + i7;
      i = paramInt + i6;
      paramInt += i5;
      continue;
      paramInt = i - j - i8;
      j = paramInt + i7;
      i = paramInt + i6;
      paramInt += i5;
    }
  }
  
  final void a(int paramInt, q paramq)
  {
    Object localObject2 = null;
    int i;
    if (paramq != null)
    {
      i = paramq.getCount();
      this.Qw = true;
      if ((paramInt <= 0) || (paramq == null)) {
        break label235;
      }
    }
    label235:
    for (Object localObject1 = paramq.getPageTitle(paramInt - 1);; localObject1 = null)
    {
      this.Qq.setText((CharSequence)localObject1);
      TextView localTextView = this.Qr;
      if ((paramq != null) && (paramInt < i)) {}
      for (localObject1 = paramq.getPageTitle(paramInt);; localObject1 = null)
      {
        localTextView.setText((CharSequence)localObject1);
        localObject1 = localObject2;
        if (paramInt + 1 < i)
        {
          localObject1 = localObject2;
          if (paramq != null) {
            localObject1 = paramq.getPageTitle(paramInt + 1);
          }
        }
        this.Qs.setText((CharSequence)localObject1);
        i = View.MeasureSpec.makeMeasureSpec(Math.max(0, (int)((getWidth() - getPaddingLeft() - getPaddingRight()) * 0.8F)), -2147483648);
        int j = View.MeasureSpec.makeMeasureSpec(Math.max(0, getHeight() - getPaddingTop() - getPaddingBottom()), -2147483648);
        this.Qq.measure(i, j);
        this.Qr.measure(i, j);
        this.Qs.measure(i, j);
        this.Qt = paramInt;
        if (!this.Qx) {
          a(paramInt, this.Qu, false);
        }
        this.Qw = false;
        return;
        i = 0;
        break;
      }
    }
  }
  
  final void a(q paramq1, q paramq2)
  {
    if (paramq1 != null)
    {
      paramq1.unregisterDataSetObserver(this.Qy);
      this.Qz = null;
    }
    if (paramq2 != null)
    {
      paramq2.registerDataSetObserver(this.Qy);
      this.Qz = new WeakReference(paramq2);
    }
    if (this.Qp != null)
    {
      this.Qt = -1;
      this.Qu = -1.0F;
      a(this.Qp.getCurrentItem(), paramq2);
      requestLayout();
    }
  }
  
  int getMinHeight()
  {
    int i = 0;
    Drawable localDrawable = getBackground();
    if (localDrawable != null) {
      i = localDrawable.getIntrinsicHeight();
    }
    return i;
  }
  
  public int getTextSpacing()
  {
    return this.Qv;
  }
  
  protected void onAttachedToWindow()
  {
    super.onAttachedToWindow();
    Object localObject = getParent();
    if (!(localObject instanceof ViewPager)) {
      throw new IllegalStateException("PagerTitleStrip must be a direct child of a ViewPager.");
    }
    localObject = (ViewPager)localObject;
    q localq = ((ViewPager)localObject).getAdapter();
    ((ViewPager)localObject).setInternalPageChangeListener(this.Qy);
    ((ViewPager)localObject).addOnAdapterChangeListener(this.Qy);
    this.Qp = ((ViewPager)localObject);
    if (this.Qz != null) {}
    for (localObject = (q)this.Qz.get();; localObject = null)
    {
      a((q)localObject, localq);
      return;
    }
  }
  
  protected void onDetachedFromWindow()
  {
    super.onDetachedFromWindow();
    if (this.Qp != null)
    {
      a(this.Qp.getAdapter(), null);
      this.Qp.setInternalPageChangeListener(null);
      this.Qp.removeOnAdapterChangeListener(this.Qy);
      this.Qp = null;
    }
  }
  
  protected void onLayout(boolean paramBoolean, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    float f = 0.0F;
    if (this.Qp != null)
    {
      if (this.Qu >= 0.0F) {
        f = this.Qu;
      }
      a(this.Qt, f, true);
    }
  }
  
  protected void onMeasure(int paramInt1, int paramInt2)
  {
    if (View.MeasureSpec.getMode(paramInt1) != 1073741824) {
      throw new IllegalStateException("Must measure with an exact width");
    }
    int j = getPaddingTop() + getPaddingBottom();
    int k = getChildMeasureSpec(paramInt2, j, -2);
    int i = View.MeasureSpec.getSize(paramInt1);
    paramInt1 = getChildMeasureSpec(paramInt1, (int)(i * 0.2F), -2);
    this.Qq.measure(paramInt1, k);
    this.Qr.measure(paramInt1, k);
    this.Qs.measure(paramInt1, k);
    if (View.MeasureSpec.getMode(paramInt2) == 1073741824) {}
    for (paramInt1 = View.MeasureSpec.getSize(paramInt2);; paramInt1 = Math.max(getMinHeight(), j + paramInt1))
    {
      setMeasuredDimension(i, View.resolveSizeAndState(paramInt1, paramInt2, this.Qr.getMeasuredState() << 16));
      return;
      paramInt1 = this.Qr.getMeasuredHeight();
    }
  }
  
  public void requestLayout()
  {
    if (!this.Qw) {
      super.requestLayout();
    }
  }
  
  public void setGravity(int paramInt)
  {
    this.Ku = paramInt;
    requestLayout();
  }
  
  public void setNonPrimaryAlpha(float paramFloat)
  {
    this.QC = ((int)(255.0F * paramFloat) & 0xFF);
    int i = this.QC << 24 | this.QD & 0xFFFFFF;
    this.Qq.setTextColor(i);
    this.Qs.setTextColor(i);
  }
  
  public void setTextColor(int paramInt)
  {
    this.QD = paramInt;
    this.Qr.setTextColor(paramInt);
    paramInt = this.QC << 24 | this.QD & 0xFFFFFF;
    this.Qq.setTextColor(paramInt);
    this.Qs.setTextColor(paramInt);
  }
  
  public void setTextSpacing(int paramInt)
  {
    this.Qv = paramInt;
    requestLayout();
  }
  
  final class a
    extends DataSetObserver
    implements ViewPager.OnPageChangeListener, ViewPager.c
  {
    private int mScrollState;
    
    a() {}
    
    public final void a(ViewPager paramViewPager, q paramq1, q paramq2)
    {
      PagerTitleStrip.this.a(paramq1, paramq2);
    }
    
    public final void onChanged()
    {
      float f = 0.0F;
      PagerTitleStrip.this.a(PagerTitleStrip.this.Qp.getCurrentItem(), PagerTitleStrip.this.Qp.getAdapter());
      if (PagerTitleStrip.this.Qu >= 0.0F) {
        f = PagerTitleStrip.this.Qu;
      }
      PagerTitleStrip.this.a(PagerTitleStrip.this.Qp.getCurrentItem(), f, true);
    }
    
    public final void onPageScrollStateChanged(int paramInt)
    {
      this.mScrollState = paramInt;
    }
    
    public final void onPageScrolled(int paramInt1, float paramFloat, int paramInt2)
    {
      paramInt2 = paramInt1;
      if (paramFloat > 0.5F) {
        paramInt2 = paramInt1 + 1;
      }
      PagerTitleStrip.this.a(paramInt2, paramFloat, false);
    }
    
    public final void onPageSelected(int paramInt)
    {
      float f = 0.0F;
      if (this.mScrollState == 0)
      {
        PagerTitleStrip.this.a(PagerTitleStrip.this.Qp.getCurrentItem(), PagerTitleStrip.this.Qp.getAdapter());
        if (PagerTitleStrip.this.Qu >= 0.0F) {
          f = PagerTitleStrip.this.Qu;
        }
        PagerTitleStrip.this.a(PagerTitleStrip.this.Qp.getCurrentItem(), f, true);
      }
    }
  }
  
  static final class b
    extends SingleLineTransformationMethod
  {
    private Locale QF;
    
    b(Context paramContext)
    {
      this.QF = paramContext.getResources().getConfiguration().locale;
    }
    
    public final CharSequence getTransformation(CharSequence paramCharSequence, View paramView)
    {
      paramCharSequence = super.getTransformation(paramCharSequence, paramView);
      if (paramCharSequence != null) {
        return paramCharSequence.toString().toUpperCase(this.QF);
      }
      return null;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     android.support.v4.view.PagerTitleStrip
 * JD-Core Version:    0.7.0.1
 */