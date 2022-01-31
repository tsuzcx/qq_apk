package android.support.v4.view;

import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.database.DataSetObserver;
import android.graphics.drawable.Drawable;
import android.support.v4.widget.o;
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
  private static final int[] FV = { 16842804, 16842901, 16842904, 16842927 };
  private static final int[] FW = { 16843660 };
  private int An;
  ViewPager FK;
  TextView FL;
  TextView FM;
  TextView FN;
  private int FO = -1;
  float FP = -1.0F;
  private int FQ;
  private boolean FR;
  private boolean FS;
  private final a FT = new a();
  private WeakReference<n> FU;
  private int FX;
  int FY;
  
  public PagerTitleStrip(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    TextView localTextView = new TextView(paramContext);
    this.FL = localTextView;
    addView(localTextView);
    localTextView = new TextView(paramContext);
    this.FM = localTextView;
    addView(localTextView);
    localTextView = new TextView(paramContext);
    this.FN = localTextView;
    addView(localTextView);
    paramAttributeSet = paramContext.obtainStyledAttributes(paramAttributeSet, FV);
    int i = paramAttributeSet.getResourceId(0, 0);
    if (i != 0)
    {
      o.b(this.FL, i);
      o.b(this.FM, i);
      o.b(this.FN, i);
    }
    int j = paramAttributeSet.getDimensionPixelSize(1, 0);
    if (j != 0)
    {
      float f = j;
      this.FL.setTextSize(0, f);
      this.FM.setTextSize(0, f);
      this.FN.setTextSize(0, f);
    }
    if (paramAttributeSet.hasValue(2))
    {
      j = paramAttributeSet.getColor(2, 0);
      this.FL.setTextColor(j);
      this.FM.setTextColor(j);
      this.FN.setTextColor(j);
    }
    this.An = paramAttributeSet.getInteger(3, 80);
    paramAttributeSet.recycle();
    this.FY = this.FM.getTextColors().getDefaultColor();
    setNonPrimaryAlpha(0.6F);
    this.FL.setEllipsize(TextUtils.TruncateAt.END);
    this.FM.setEllipsize(TextUtils.TruncateAt.END);
    this.FN.setEllipsize(TextUtils.TruncateAt.END);
    if (i != 0)
    {
      paramAttributeSet = paramContext.obtainStyledAttributes(i, FW);
      bool = paramAttributeSet.getBoolean(0, false);
      paramAttributeSet.recycle();
    }
    if (bool)
    {
      setSingleLineAllCaps(this.FL);
      setSingleLineAllCaps(this.FM);
      setSingleLineAllCaps(this.FN);
    }
    for (;;)
    {
      this.FQ = ((int)(paramContext.getResources().getDisplayMetrics().density * 16.0F));
      return;
      this.FL.setSingleLine();
      this.FM.setSingleLine();
      this.FN.setSingleLine();
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
    if (paramInt != this.FO)
    {
      a(paramInt, this.FK.getAdapter());
      this.FS = true;
      m = this.FL.getMeasuredWidth();
      i4 = this.FM.getMeasuredWidth();
      k = this.FN.getMeasuredWidth();
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
      i7 = this.FL.getBaseline();
      i6 = this.FM.getBaseline();
      i5 = this.FN.getBaseline();
      i8 = Math.max(Math.max(i7, i6), i5);
      i7 = i8 - i7;
      i6 = i8 - i6;
      i5 = i8 - i5;
      i8 = this.FL.getMeasuredHeight();
      int i9 = this.FM.getMeasuredHeight();
      int i10 = this.FN.getMeasuredHeight();
      i8 = Math.max(Math.max(i8 + i7, i9 + i6), i10 + i5);
      switch (this.An & 0x70)
      {
      default: 
        j = paramInt + i7;
        i = paramInt + i6;
        paramInt += i5;
      }
    }
    for (;;)
    {
      this.FM.layout(i3, i, i4, this.FM.getMeasuredHeight() + i);
      i = Math.min(i2, i3 - this.FQ - m);
      this.FL.layout(i, j, m + i, this.FL.getMeasuredHeight() + j);
      i = Math.max(n - i1 - k, this.FQ + i4);
      this.FN.layout(i, paramInt, i + k, this.FN.getMeasuredHeight() + paramInt);
      this.FP = paramFloat;
      this.FS = false;
      return;
      if ((paramBoolean) || (paramFloat != this.FP)) {
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
  
  final void a(int paramInt, n paramn)
  {
    Object localObject2 = null;
    int i;
    if (paramn != null)
    {
      i = paramn.getCount();
      this.FR = true;
      if ((paramInt <= 0) || (paramn == null)) {
        break label228;
      }
    }
    label228:
    for (Object localObject1 = paramn.dj();; localObject1 = null)
    {
      this.FL.setText((CharSequence)localObject1);
      TextView localTextView = this.FM;
      if ((paramn != null) && (paramInt < i)) {}
      for (localObject1 = paramn.dj();; localObject1 = null)
      {
        localTextView.setText((CharSequence)localObject1);
        localObject1 = localObject2;
        if (paramInt + 1 < i)
        {
          localObject1 = localObject2;
          if (paramn != null) {
            localObject1 = paramn.dj();
          }
        }
        this.FN.setText((CharSequence)localObject1);
        i = View.MeasureSpec.makeMeasureSpec(Math.max(0, (int)((getWidth() - getPaddingLeft() - getPaddingRight()) * 0.8F)), -2147483648);
        int j = View.MeasureSpec.makeMeasureSpec(Math.max(0, getHeight() - getPaddingTop() - getPaddingBottom()), -2147483648);
        this.FL.measure(i, j);
        this.FM.measure(i, j);
        this.FN.measure(i, j);
        this.FO = paramInt;
        if (!this.FS) {
          a(paramInt, this.FP, false);
        }
        this.FR = false;
        return;
        i = 0;
        break;
      }
    }
  }
  
  final void a(n paramn1, n paramn2)
  {
    if (paramn1 != null)
    {
      paramn1.unregisterDataSetObserver(this.FT);
      this.FU = null;
    }
    if (paramn2 != null)
    {
      paramn2.registerDataSetObserver(this.FT);
      this.FU = new WeakReference(paramn2);
    }
    if (this.FK != null)
    {
      this.FO = -1;
      this.FP = -1.0F;
      a(this.FK.getCurrentItem(), paramn2);
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
    return this.FQ;
  }
  
  protected void onAttachedToWindow()
  {
    super.onAttachedToWindow();
    Object localObject = getParent();
    if (!(localObject instanceof ViewPager)) {
      throw new IllegalStateException("PagerTitleStrip must be a direct child of a ViewPager.");
    }
    localObject = (ViewPager)localObject;
    n localn = ((ViewPager)localObject).getAdapter();
    ((ViewPager)localObject).b(this.FT);
    ((ViewPager)localObject).a(this.FT);
    this.FK = ((ViewPager)localObject);
    if (this.FU != null) {}
    for (localObject = (n)this.FU.get();; localObject = null)
    {
      a((n)localObject, localn);
      return;
    }
  }
  
  protected void onDetachedFromWindow()
  {
    super.onDetachedFromWindow();
    if (this.FK != null)
    {
      a(this.FK.getAdapter(), null);
      this.FK.b(null);
      this.FK.b(this.FT);
      this.FK = null;
    }
  }
  
  protected void onLayout(boolean paramBoolean, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    float f = 0.0F;
    if (this.FK != null)
    {
      if (this.FP >= 0.0F) {
        f = this.FP;
      }
      a(this.FO, f, true);
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
    this.FL.measure(paramInt1, k);
    this.FM.measure(paramInt1, k);
    this.FN.measure(paramInt1, k);
    if (View.MeasureSpec.getMode(paramInt2) == 1073741824) {}
    for (paramInt1 = View.MeasureSpec.getSize(paramInt2);; paramInt1 = Math.max(getMinHeight(), j + paramInt1))
    {
      setMeasuredDimension(i, View.resolveSizeAndState(paramInt1, paramInt2, this.FM.getMeasuredState() << 16));
      return;
      paramInt1 = this.FM.getMeasuredHeight();
    }
  }
  
  public void requestLayout()
  {
    if (!this.FR) {
      super.requestLayout();
    }
  }
  
  public void setGravity(int paramInt)
  {
    this.An = paramInt;
    requestLayout();
  }
  
  public void setNonPrimaryAlpha(float paramFloat)
  {
    this.FX = ((int)(255.0F * paramFloat) & 0xFF);
    int i = this.FX << 24 | this.FY & 0xFFFFFF;
    this.FL.setTextColor(i);
    this.FN.setTextColor(i);
  }
  
  public void setTextColor(int paramInt)
  {
    this.FY = paramInt;
    this.FM.setTextColor(paramInt);
    paramInt = this.FX << 24 | this.FY & 0xFFFFFF;
    this.FL.setTextColor(paramInt);
    this.FN.setTextColor(paramInt);
  }
  
  public void setTextSpacing(int paramInt)
  {
    this.FQ = paramInt;
    requestLayout();
  }
  
  private final class a
    extends DataSetObserver
    implements ViewPager.d, ViewPager.e
  {
    private int lf;
    
    a() {}
    
    public final void Q(int paramInt)
    {
      this.lf = paramInt;
    }
    
    public final void R(int paramInt)
    {
      float f = 0.0F;
      if (this.lf == 0)
      {
        PagerTitleStrip.this.a(PagerTitleStrip.this.FK.getCurrentItem(), PagerTitleStrip.this.FK.getAdapter());
        if (PagerTitleStrip.this.FP >= 0.0F) {
          f = PagerTitleStrip.this.FP;
        }
        PagerTitleStrip.this.a(PagerTitleStrip.this.FK.getCurrentItem(), f, true);
      }
    }
    
    public final void a(int paramInt1, float paramFloat, int paramInt2)
    {
      paramInt2 = paramInt1;
      if (paramFloat > 0.5F) {
        paramInt2 = paramInt1 + 1;
      }
      PagerTitleStrip.this.a(paramInt2, paramFloat, false);
    }
    
    public final void a(ViewPager paramViewPager, n paramn1, n paramn2)
    {
      PagerTitleStrip.this.a(paramn1, paramn2);
    }
    
    public final void onChanged()
    {
      float f = 0.0F;
      PagerTitleStrip.this.a(PagerTitleStrip.this.FK.getCurrentItem(), PagerTitleStrip.this.FK.getAdapter());
      if (PagerTitleStrip.this.FP >= 0.0F) {
        f = PagerTitleStrip.this.FP;
      }
      PagerTitleStrip.this.a(PagerTitleStrip.this.FK.getCurrentItem(), f, true);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     android.support.v4.view.PagerTitleStrip
 * JD-Core Version:    0.7.0.1
 */