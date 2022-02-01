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
  private static final int[] Ox = { 16842804, 16842901, 16842904, 16842927 };
  private static final int[] Oy = { 16843660 };
  private int Is;
  ViewPager Om;
  TextView On;
  TextView Oo;
  TextView Op;
  private int Oq = -1;
  float Or = -1.0F;
  private int Os;
  private boolean Ot;
  private boolean Ou;
  private final a Ov = new a();
  private WeakReference<q> Ow;
  private int Oz;
  int mTextColor;
  
  public PagerTitleStrip(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    TextView localTextView = new TextView(paramContext);
    this.On = localTextView;
    addView(localTextView);
    localTextView = new TextView(paramContext);
    this.Oo = localTextView;
    addView(localTextView);
    localTextView = new TextView(paramContext);
    this.Op = localTextView;
    addView(localTextView);
    paramAttributeSet = paramContext.obtainStyledAttributes(paramAttributeSet, Ox);
    int i = paramAttributeSet.getResourceId(0, 0);
    if (i != 0)
    {
      android.support.v4.widget.q.d(this.On, i);
      android.support.v4.widget.q.d(this.Oo, i);
      android.support.v4.widget.q.d(this.Op, i);
    }
    int j = paramAttributeSet.getDimensionPixelSize(1, 0);
    if (j != 0)
    {
      float f = j;
      this.On.setTextSize(0, f);
      this.Oo.setTextSize(0, f);
      this.Op.setTextSize(0, f);
    }
    if (paramAttributeSet.hasValue(2))
    {
      j = paramAttributeSet.getColor(2, 0);
      this.On.setTextColor(j);
      this.Oo.setTextColor(j);
      this.Op.setTextColor(j);
    }
    this.Is = paramAttributeSet.getInteger(3, 80);
    paramAttributeSet.recycle();
    this.mTextColor = this.Oo.getTextColors().getDefaultColor();
    setNonPrimaryAlpha(0.6F);
    this.On.setEllipsize(TextUtils.TruncateAt.END);
    this.Oo.setEllipsize(TextUtils.TruncateAt.END);
    this.Op.setEllipsize(TextUtils.TruncateAt.END);
    if (i != 0)
    {
      paramAttributeSet = paramContext.obtainStyledAttributes(i, Oy);
      bool = paramAttributeSet.getBoolean(0, false);
      paramAttributeSet.recycle();
    }
    if (bool)
    {
      setSingleLineAllCaps(this.On);
      setSingleLineAllCaps(this.Oo);
      setSingleLineAllCaps(this.Op);
    }
    for (;;)
    {
      this.Os = ((int)(paramContext.getResources().getDisplayMetrics().density * 16.0F));
      return;
      this.On.setSingleLine();
      this.Oo.setSingleLine();
      this.Op.setSingleLine();
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
    if (paramInt != this.Oq)
    {
      a(paramInt, this.Om.getAdapter());
      this.Ou = true;
      m = this.On.getMeasuredWidth();
      i4 = this.Oo.getMeasuredWidth();
      k = this.Op.getMeasuredWidth();
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
      i7 = this.On.getBaseline();
      i6 = this.Oo.getBaseline();
      i5 = this.Op.getBaseline();
      i8 = Math.max(Math.max(i7, i6), i5);
      i7 = i8 - i7;
      i6 = i8 - i6;
      i5 = i8 - i5;
      i8 = this.On.getMeasuredHeight();
      int i9 = this.Oo.getMeasuredHeight();
      int i10 = this.Op.getMeasuredHeight();
      i8 = Math.max(Math.max(i8 + i7, i9 + i6), i10 + i5);
      switch (this.Is & 0x70)
      {
      default: 
        j = paramInt + i7;
        i = paramInt + i6;
        paramInt += i5;
      }
    }
    for (;;)
    {
      this.Oo.layout(i3, i, i4, this.Oo.getMeasuredHeight() + i);
      i = Math.min(i2, i3 - this.Os - m);
      this.On.layout(i, j, m + i, this.On.getMeasuredHeight() + j);
      i = Math.max(n - i1 - k, this.Os + i4);
      this.Op.layout(i, paramInt, i + k, this.Op.getMeasuredHeight() + paramInt);
      this.Or = paramFloat;
      this.Ou = false;
      return;
      if ((paramBoolean) || (paramFloat != this.Or)) {
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
      this.Ot = true;
      if ((paramInt <= 0) || (paramq == null)) {
        break label235;
      }
    }
    label235:
    for (Object localObject1 = paramq.getPageTitle(paramInt - 1);; localObject1 = null)
    {
      this.On.setText((CharSequence)localObject1);
      TextView localTextView = this.Oo;
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
        this.Op.setText((CharSequence)localObject1);
        i = View.MeasureSpec.makeMeasureSpec(Math.max(0, (int)((getWidth() - getPaddingLeft() - getPaddingRight()) * 0.8F)), -2147483648);
        int j = View.MeasureSpec.makeMeasureSpec(Math.max(0, getHeight() - getPaddingTop() - getPaddingBottom()), -2147483648);
        this.On.measure(i, j);
        this.Oo.measure(i, j);
        this.Op.measure(i, j);
        this.Oq = paramInt;
        if (!this.Ou) {
          a(paramInt, this.Or, false);
        }
        this.Ot = false;
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
      paramq1.unregisterDataSetObserver(this.Ov);
      this.Ow = null;
    }
    if (paramq2 != null)
    {
      paramq2.registerDataSetObserver(this.Ov);
      this.Ow = new WeakReference(paramq2);
    }
    if (this.Om != null)
    {
      this.Oq = -1;
      this.Or = -1.0F;
      a(this.Om.getCurrentItem(), paramq2);
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
    return this.Os;
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
    ((ViewPager)localObject).setInternalPageChangeListener(this.Ov);
    ((ViewPager)localObject).addOnAdapterChangeListener(this.Ov);
    this.Om = ((ViewPager)localObject);
    if (this.Ow != null) {}
    for (localObject = (q)this.Ow.get();; localObject = null)
    {
      a((q)localObject, localq);
      return;
    }
  }
  
  protected void onDetachedFromWindow()
  {
    super.onDetachedFromWindow();
    if (this.Om != null)
    {
      a(this.Om.getAdapter(), null);
      this.Om.setInternalPageChangeListener(null);
      this.Om.removeOnAdapterChangeListener(this.Ov);
      this.Om = null;
    }
  }
  
  protected void onLayout(boolean paramBoolean, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    float f = 0.0F;
    if (this.Om != null)
    {
      if (this.Or >= 0.0F) {
        f = this.Or;
      }
      a(this.Oq, f, true);
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
    this.On.measure(paramInt1, k);
    this.Oo.measure(paramInt1, k);
    this.Op.measure(paramInt1, k);
    if (View.MeasureSpec.getMode(paramInt2) == 1073741824) {}
    for (paramInt1 = View.MeasureSpec.getSize(paramInt2);; paramInt1 = Math.max(getMinHeight(), j + paramInt1))
    {
      setMeasuredDimension(i, View.resolveSizeAndState(paramInt1, paramInt2, this.Oo.getMeasuredState() << 16));
      return;
      paramInt1 = this.Oo.getMeasuredHeight();
    }
  }
  
  public void requestLayout()
  {
    if (!this.Ot) {
      super.requestLayout();
    }
  }
  
  public void setGravity(int paramInt)
  {
    this.Is = paramInt;
    requestLayout();
  }
  
  public void setNonPrimaryAlpha(float paramFloat)
  {
    this.Oz = ((int)(255.0F * paramFloat) & 0xFF);
    int i = this.Oz << 24 | this.mTextColor & 0xFFFFFF;
    this.On.setTextColor(i);
    this.Op.setTextColor(i);
  }
  
  public void setTextColor(int paramInt)
  {
    this.mTextColor = paramInt;
    this.Oo.setTextColor(paramInt);
    paramInt = this.Oz << 24 | this.mTextColor & 0xFFFFFF;
    this.On.setTextColor(paramInt);
    this.Op.setTextColor(paramInt);
  }
  
  public void setTextSpacing(int paramInt)
  {
    this.Os = paramInt;
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
      PagerTitleStrip.this.a(PagerTitleStrip.this.Om.getCurrentItem(), PagerTitleStrip.this.Om.getAdapter());
      if (PagerTitleStrip.this.Or >= 0.0F) {
        f = PagerTitleStrip.this.Or;
      }
      PagerTitleStrip.this.a(PagerTitleStrip.this.Om.getCurrentItem(), f, true);
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
        PagerTitleStrip.this.a(PagerTitleStrip.this.Om.getCurrentItem(), PagerTitleStrip.this.Om.getAdapter());
        if (PagerTitleStrip.this.Or >= 0.0F) {
          f = PagerTitleStrip.this.Or;
        }
        PagerTitleStrip.this.a(PagerTitleStrip.this.Om.getCurrentItem(), f, true);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     android.support.v4.view.PagerTitleStrip
 * JD-Core Version:    0.7.0.1
 */