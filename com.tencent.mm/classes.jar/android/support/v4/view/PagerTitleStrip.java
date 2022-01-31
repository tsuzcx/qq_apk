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
  private static final int[] GC = { 16842804, 16842901, 16842904, 16842927 };
  private static final int[] GD = { 16843660 };
  private int AZ;
  private final a GA = new a();
  private WeakReference<q> GB;
  private int GE;
  int GF;
  ViewPager Gr;
  TextView Gs;
  TextView Gt;
  TextView Gu;
  private int Gv = -1;
  float Gw = -1.0F;
  private int Gx;
  private boolean Gy;
  private boolean Gz;
  
  public PagerTitleStrip(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    TextView localTextView = new TextView(paramContext);
    this.Gs = localTextView;
    addView(localTextView);
    localTextView = new TextView(paramContext);
    this.Gt = localTextView;
    addView(localTextView);
    localTextView = new TextView(paramContext);
    this.Gu = localTextView;
    addView(localTextView);
    paramAttributeSet = paramContext.obtainStyledAttributes(paramAttributeSet, GC);
    int i = paramAttributeSet.getResourceId(0, 0);
    if (i != 0)
    {
      android.support.v4.widget.q.b(this.Gs, i);
      android.support.v4.widget.q.b(this.Gt, i);
      android.support.v4.widget.q.b(this.Gu, i);
    }
    int j = paramAttributeSet.getDimensionPixelSize(1, 0);
    if (j != 0)
    {
      float f = j;
      this.Gs.setTextSize(0, f);
      this.Gt.setTextSize(0, f);
      this.Gu.setTextSize(0, f);
    }
    if (paramAttributeSet.hasValue(2))
    {
      j = paramAttributeSet.getColor(2, 0);
      this.Gs.setTextColor(j);
      this.Gt.setTextColor(j);
      this.Gu.setTextColor(j);
    }
    this.AZ = paramAttributeSet.getInteger(3, 80);
    paramAttributeSet.recycle();
    this.GF = this.Gt.getTextColors().getDefaultColor();
    setNonPrimaryAlpha(0.6F);
    this.Gs.setEllipsize(TextUtils.TruncateAt.END);
    this.Gt.setEllipsize(TextUtils.TruncateAt.END);
    this.Gu.setEllipsize(TextUtils.TruncateAt.END);
    if (i != 0)
    {
      paramAttributeSet = paramContext.obtainStyledAttributes(i, GD);
      bool = paramAttributeSet.getBoolean(0, false);
      paramAttributeSet.recycle();
    }
    if (bool)
    {
      setSingleLineAllCaps(this.Gs);
      setSingleLineAllCaps(this.Gt);
      setSingleLineAllCaps(this.Gu);
    }
    for (;;)
    {
      this.Gx = ((int)(paramContext.getResources().getDisplayMetrics().density * 16.0F));
      return;
      this.Gs.setSingleLine();
      this.Gt.setSingleLine();
      this.Gu.setSingleLine();
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
    if (paramInt != this.Gv)
    {
      a(paramInt, this.Gr.getAdapter());
      this.Gz = true;
      m = this.Gs.getMeasuredWidth();
      i4 = this.Gt.getMeasuredWidth();
      k = this.Gu.getMeasuredWidth();
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
      i7 = this.Gs.getBaseline();
      i6 = this.Gt.getBaseline();
      i5 = this.Gu.getBaseline();
      i8 = Math.max(Math.max(i7, i6), i5);
      i7 = i8 - i7;
      i6 = i8 - i6;
      i5 = i8 - i5;
      i8 = this.Gs.getMeasuredHeight();
      int i9 = this.Gt.getMeasuredHeight();
      int i10 = this.Gu.getMeasuredHeight();
      i8 = Math.max(Math.max(i8 + i7, i9 + i6), i10 + i5);
      switch (this.AZ & 0x70)
      {
      default: 
        j = paramInt + i7;
        i = paramInt + i6;
        paramInt += i5;
      }
    }
    for (;;)
    {
      this.Gt.layout(i3, i, i4, this.Gt.getMeasuredHeight() + i);
      i = Math.min(i2, i3 - this.Gx - m);
      this.Gs.layout(i, j, m + i, this.Gs.getMeasuredHeight() + j);
      i = Math.max(n - i1 - k, this.Gx + i4);
      this.Gu.layout(i, paramInt, i + k, this.Gu.getMeasuredHeight() + paramInt);
      this.Gw = paramFloat;
      this.Gz = false;
      return;
      if ((paramBoolean) || (paramFloat != this.Gw)) {
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
      this.Gy = true;
      if ((paramInt <= 0) || (paramq == null)) {
        break label235;
      }
    }
    label235:
    for (Object localObject1 = paramq.getPageTitle(paramInt - 1);; localObject1 = null)
    {
      this.Gs.setText((CharSequence)localObject1);
      TextView localTextView = this.Gt;
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
        this.Gu.setText((CharSequence)localObject1);
        i = View.MeasureSpec.makeMeasureSpec(Math.max(0, (int)((getWidth() - getPaddingLeft() - getPaddingRight()) * 0.8F)), -2147483648);
        int j = View.MeasureSpec.makeMeasureSpec(Math.max(0, getHeight() - getPaddingTop() - getPaddingBottom()), -2147483648);
        this.Gs.measure(i, j);
        this.Gt.measure(i, j);
        this.Gu.measure(i, j);
        this.Gv = paramInt;
        if (!this.Gz) {
          a(paramInt, this.Gw, false);
        }
        this.Gy = false;
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
      paramq1.unregisterDataSetObserver(this.GA);
      this.GB = null;
    }
    if (paramq2 != null)
    {
      paramq2.registerDataSetObserver(this.GA);
      this.GB = new WeakReference(paramq2);
    }
    if (this.Gr != null)
    {
      this.Gv = -1;
      this.Gw = -1.0F;
      a(this.Gr.getCurrentItem(), paramq2);
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
    return this.Gx;
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
    ((ViewPager)localObject).setInternalPageChangeListener(this.GA);
    ((ViewPager)localObject).addOnAdapterChangeListener(this.GA);
    this.Gr = ((ViewPager)localObject);
    if (this.GB != null) {}
    for (localObject = (q)this.GB.get();; localObject = null)
    {
      a((q)localObject, localq);
      return;
    }
  }
  
  protected void onDetachedFromWindow()
  {
    super.onDetachedFromWindow();
    if (this.Gr != null)
    {
      a(this.Gr.getAdapter(), null);
      this.Gr.setInternalPageChangeListener(null);
      this.Gr.removeOnAdapterChangeListener(this.GA);
      this.Gr = null;
    }
  }
  
  protected void onLayout(boolean paramBoolean, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    float f = 0.0F;
    if (this.Gr != null)
    {
      if (this.Gw >= 0.0F) {
        f = this.Gw;
      }
      a(this.Gv, f, true);
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
    this.Gs.measure(paramInt1, k);
    this.Gt.measure(paramInt1, k);
    this.Gu.measure(paramInt1, k);
    if (View.MeasureSpec.getMode(paramInt2) == 1073741824) {}
    for (paramInt1 = View.MeasureSpec.getSize(paramInt2);; paramInt1 = Math.max(getMinHeight(), j + paramInt1))
    {
      setMeasuredDimension(i, View.resolveSizeAndState(paramInt1, paramInt2, this.Gt.getMeasuredState() << 16));
      return;
      paramInt1 = this.Gt.getMeasuredHeight();
    }
  }
  
  public void requestLayout()
  {
    if (!this.Gy) {
      super.requestLayout();
    }
  }
  
  public void setGravity(int paramInt)
  {
    this.AZ = paramInt;
    requestLayout();
  }
  
  public void setNonPrimaryAlpha(float paramFloat)
  {
    this.GE = ((int)(255.0F * paramFloat) & 0xFF);
    int i = this.GE << 24 | this.GF & 0xFFFFFF;
    this.Gs.setTextColor(i);
    this.Gu.setTextColor(i);
  }
  
  public void setTextColor(int paramInt)
  {
    this.GF = paramInt;
    this.Gt.setTextColor(paramInt);
    paramInt = this.GE << 24 | this.GF & 0xFFFFFF;
    this.Gs.setTextColor(paramInt);
    this.Gu.setTextColor(paramInt);
  }
  
  public void setTextSpacing(int paramInt)
  {
    this.Gx = paramInt;
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
      PagerTitleStrip.this.a(PagerTitleStrip.this.Gr.getCurrentItem(), PagerTitleStrip.this.Gr.getAdapter());
      if (PagerTitleStrip.this.Gw >= 0.0F) {
        f = PagerTitleStrip.this.Gw;
      }
      PagerTitleStrip.this.a(PagerTitleStrip.this.Gr.getCurrentItem(), f, true);
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
        PagerTitleStrip.this.a(PagerTitleStrip.this.Gr.getCurrentItem(), PagerTitleStrip.this.Gr.getAdapter());
        if (PagerTitleStrip.this.Gw >= 0.0F) {
          f = PagerTitleStrip.this.Gw;
        }
        PagerTitleStrip.this.a(PagerTitleStrip.this.Gr.getCurrentItem(), f, true);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     android.support.v4.view.PagerTitleStrip
 * JD-Core Version:    0.7.0.1
 */