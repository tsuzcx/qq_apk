package android.support.v4.view;

import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.database.DataSetObserver;
import android.graphics.drawable.Drawable;
import android.text.TextUtils.TruncateAt;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.view.View;
import android.view.View.MeasureSpec;
import android.view.ViewGroup;
import android.widget.TextView;
import java.lang.ref.WeakReference;

@ViewPager.a
public class PagerTitleStrip
  extends ViewGroup
{
  private static final int[] Qo = { 16842804, 16842901, 16842904, 16842927 };
  private static final int[] Qp = { 16843660 };
  private int Kk;
  ViewPager Qd;
  TextView Qe;
  TextView Qf;
  TextView Qg;
  private int Qh = -1;
  float Qi = -1.0F;
  private int Qj;
  private boolean Qk;
  private boolean Ql;
  private final a Qm = new a();
  private WeakReference<q> Qn;
  private int Qq;
  int mTextColor;
  
  public PagerTitleStrip(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    TextView localTextView = new TextView(paramContext);
    this.Qe = localTextView;
    addView(localTextView);
    localTextView = new TextView(paramContext);
    this.Qf = localTextView;
    addView(localTextView);
    localTextView = new TextView(paramContext);
    this.Qg = localTextView;
    addView(localTextView);
    paramAttributeSet = paramContext.obtainStyledAttributes(paramAttributeSet, Qo);
    int i = paramAttributeSet.getResourceId(0, 0);
    if (i != 0)
    {
      android.support.v4.widget.q.d(this.Qe, i);
      android.support.v4.widget.q.d(this.Qf, i);
      android.support.v4.widget.q.d(this.Qg, i);
    }
    int j = paramAttributeSet.getDimensionPixelSize(1, 0);
    if (j != 0)
    {
      float f = j;
      this.Qe.setTextSize(0, f);
      this.Qf.setTextSize(0, f);
      this.Qg.setTextSize(0, f);
    }
    if (paramAttributeSet.hasValue(2))
    {
      j = paramAttributeSet.getColor(2, 0);
      this.Qe.setTextColor(j);
      this.Qf.setTextColor(j);
      this.Qg.setTextColor(j);
    }
    this.Kk = paramAttributeSet.getInteger(3, 80);
    paramAttributeSet.recycle();
    this.mTextColor = this.Qf.getTextColors().getDefaultColor();
    setNonPrimaryAlpha(0.6F);
    this.Qe.setEllipsize(TextUtils.TruncateAt.END);
    this.Qf.setEllipsize(TextUtils.TruncateAt.END);
    this.Qg.setEllipsize(TextUtils.TruncateAt.END);
    if (i != 0)
    {
      paramAttributeSet = paramContext.obtainStyledAttributes(i, Qp);
      bool = paramAttributeSet.getBoolean(0, false);
      paramAttributeSet.recycle();
    }
    if (bool)
    {
      setSingleLineAllCaps(this.Qe);
      setSingleLineAllCaps(this.Qf);
      setSingleLineAllCaps(this.Qg);
    }
    for (;;)
    {
      this.Qj = ((int)(paramContext.getResources().getDisplayMetrics().density * 16.0F));
      return;
      this.Qe.setSingleLine();
      this.Qf.setSingleLine();
      this.Qg.setSingleLine();
    }
  }
  
  private static void setSingleLineAllCaps(TextView paramTextView)
  {
    paramTextView.setTransformationMethod(new PagerTitleStrip.b(paramTextView.getContext()));
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
    if (paramInt != this.Qh)
    {
      a(paramInt, this.Qd.getAdapter());
      this.Ql = true;
      m = this.Qe.getMeasuredWidth();
      i4 = this.Qf.getMeasuredWidth();
      k = this.Qg.getMeasuredWidth();
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
      i7 = this.Qe.getBaseline();
      i6 = this.Qf.getBaseline();
      i5 = this.Qg.getBaseline();
      i8 = Math.max(Math.max(i7, i6), i5);
      i7 = i8 - i7;
      i6 = i8 - i6;
      i5 = i8 - i5;
      i8 = this.Qe.getMeasuredHeight();
      int i9 = this.Qf.getMeasuredHeight();
      int i10 = this.Qg.getMeasuredHeight();
      i8 = Math.max(Math.max(i8 + i7, i9 + i6), i10 + i5);
      switch (this.Kk & 0x70)
      {
      default: 
        j = paramInt + i7;
        i = paramInt + i6;
        paramInt += i5;
      }
    }
    for (;;)
    {
      this.Qf.layout(i3, i, i4, this.Qf.getMeasuredHeight() + i);
      i = Math.min(i2, i3 - this.Qj - m);
      this.Qe.layout(i, j, m + i, this.Qe.getMeasuredHeight() + j);
      i = Math.max(n - i1 - k, this.Qj + i4);
      this.Qg.layout(i, paramInt, i + k, this.Qg.getMeasuredHeight() + paramInt);
      this.Qi = paramFloat;
      this.Ql = false;
      return;
      if ((paramBoolean) || (paramFloat != this.Qi)) {
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
      this.Qk = true;
      if ((paramInt <= 0) || (paramq == null)) {
        break label235;
      }
    }
    label235:
    for (Object localObject1 = paramq.getPageTitle(paramInt - 1);; localObject1 = null)
    {
      this.Qe.setText((CharSequence)localObject1);
      TextView localTextView = this.Qf;
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
        this.Qg.setText((CharSequence)localObject1);
        i = View.MeasureSpec.makeMeasureSpec(Math.max(0, (int)((getWidth() - getPaddingLeft() - getPaddingRight()) * 0.8F)), -2147483648);
        int j = View.MeasureSpec.makeMeasureSpec(Math.max(0, getHeight() - getPaddingTop() - getPaddingBottom()), -2147483648);
        this.Qe.measure(i, j);
        this.Qf.measure(i, j);
        this.Qg.measure(i, j);
        this.Qh = paramInt;
        if (!this.Ql) {
          a(paramInt, this.Qi, false);
        }
        this.Qk = false;
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
      paramq1.unregisterDataSetObserver(this.Qm);
      this.Qn = null;
    }
    if (paramq2 != null)
    {
      paramq2.registerDataSetObserver(this.Qm);
      this.Qn = new WeakReference(paramq2);
    }
    if (this.Qd != null)
    {
      this.Qh = -1;
      this.Qi = -1.0F;
      a(this.Qd.getCurrentItem(), paramq2);
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
    return this.Qj;
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
    ((ViewPager)localObject).setInternalPageChangeListener(this.Qm);
    ((ViewPager)localObject).addOnAdapterChangeListener(this.Qm);
    this.Qd = ((ViewPager)localObject);
    if (this.Qn != null) {}
    for (localObject = (q)this.Qn.get();; localObject = null)
    {
      a((q)localObject, localq);
      return;
    }
  }
  
  protected void onDetachedFromWindow()
  {
    super.onDetachedFromWindow();
    if (this.Qd != null)
    {
      a(this.Qd.getAdapter(), null);
      this.Qd.setInternalPageChangeListener(null);
      this.Qd.removeOnAdapterChangeListener(this.Qm);
      this.Qd = null;
    }
  }
  
  protected void onLayout(boolean paramBoolean, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    float f = 0.0F;
    if (this.Qd != null)
    {
      if (this.Qi >= 0.0F) {
        f = this.Qi;
      }
      a(this.Qh, f, true);
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
    this.Qe.measure(paramInt1, k);
    this.Qf.measure(paramInt1, k);
    this.Qg.measure(paramInt1, k);
    if (View.MeasureSpec.getMode(paramInt2) == 1073741824) {}
    for (paramInt1 = View.MeasureSpec.getSize(paramInt2);; paramInt1 = Math.max(getMinHeight(), j + paramInt1))
    {
      setMeasuredDimension(i, View.resolveSizeAndState(paramInt1, paramInt2, this.Qf.getMeasuredState() << 16));
      return;
      paramInt1 = this.Qf.getMeasuredHeight();
    }
  }
  
  public void requestLayout()
  {
    if (!this.Qk) {
      super.requestLayout();
    }
  }
  
  public void setGravity(int paramInt)
  {
    this.Kk = paramInt;
    requestLayout();
  }
  
  public void setNonPrimaryAlpha(float paramFloat)
  {
    this.Qq = ((int)(255.0F * paramFloat) & 0xFF);
    int i = this.Qq << 24 | this.mTextColor & 0xFFFFFF;
    this.Qe.setTextColor(i);
    this.Qg.setTextColor(i);
  }
  
  public void setTextColor(int paramInt)
  {
    this.mTextColor = paramInt;
    this.Qf.setTextColor(paramInt);
    paramInt = this.Qq << 24 | this.mTextColor & 0xFFFFFF;
    this.Qe.setTextColor(paramInt);
    this.Qg.setTextColor(paramInt);
  }
  
  public void setTextSpacing(int paramInt)
  {
    this.Qj = paramInt;
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
      PagerTitleStrip.this.a(PagerTitleStrip.this.Qd.getCurrentItem(), PagerTitleStrip.this.Qd.getAdapter());
      if (PagerTitleStrip.this.Qi >= 0.0F) {
        f = PagerTitleStrip.this.Qi;
      }
      PagerTitleStrip.this.a(PagerTitleStrip.this.Qd.getCurrentItem(), f, true);
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
        PagerTitleStrip.this.a(PagerTitleStrip.this.Qd.getCurrentItem(), PagerTitleStrip.this.Qd.getAdapter());
        if (PagerTitleStrip.this.Qi >= 0.0F) {
          f = PagerTitleStrip.this.Qi;
        }
        PagerTitleStrip.this.a(PagerTitleStrip.this.Qd.getCurrentItem(), f, true);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     android.support.v4.view.PagerTitleStrip
 * JD-Core Version:    0.7.0.1
 */