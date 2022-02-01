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
  private static final int[] NC = { 16842804, 16842901, 16842904, 16842927 };
  private static final int[] ND = { 16843660 };
  private int Hu;
  private final a NA = new a();
  private WeakReference<q> NB;
  private int NE;
  ViewPager Nr;
  TextView Ns;
  TextView Nt;
  TextView Nu;
  private int Nv = -1;
  float Nw = -1.0F;
  private int Nx;
  private boolean Ny;
  private boolean Nz;
  int mTextColor;
  
  public PagerTitleStrip(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    TextView localTextView = new TextView(paramContext);
    this.Ns = localTextView;
    addView(localTextView);
    localTextView = new TextView(paramContext);
    this.Nt = localTextView;
    addView(localTextView);
    localTextView = new TextView(paramContext);
    this.Nu = localTextView;
    addView(localTextView);
    paramAttributeSet = paramContext.obtainStyledAttributes(paramAttributeSet, NC);
    int i = paramAttributeSet.getResourceId(0, 0);
    if (i != 0)
    {
      android.support.v4.widget.q.d(this.Ns, i);
      android.support.v4.widget.q.d(this.Nt, i);
      android.support.v4.widget.q.d(this.Nu, i);
    }
    int j = paramAttributeSet.getDimensionPixelSize(1, 0);
    if (j != 0)
    {
      float f = j;
      this.Ns.setTextSize(0, f);
      this.Nt.setTextSize(0, f);
      this.Nu.setTextSize(0, f);
    }
    if (paramAttributeSet.hasValue(2))
    {
      j = paramAttributeSet.getColor(2, 0);
      this.Ns.setTextColor(j);
      this.Nt.setTextColor(j);
      this.Nu.setTextColor(j);
    }
    this.Hu = paramAttributeSet.getInteger(3, 80);
    paramAttributeSet.recycle();
    this.mTextColor = this.Nt.getTextColors().getDefaultColor();
    setNonPrimaryAlpha(0.6F);
    this.Ns.setEllipsize(TextUtils.TruncateAt.END);
    this.Nt.setEllipsize(TextUtils.TruncateAt.END);
    this.Nu.setEllipsize(TextUtils.TruncateAt.END);
    if (i != 0)
    {
      paramAttributeSet = paramContext.obtainStyledAttributes(i, ND);
      bool = paramAttributeSet.getBoolean(0, false);
      paramAttributeSet.recycle();
    }
    if (bool)
    {
      setSingleLineAllCaps(this.Ns);
      setSingleLineAllCaps(this.Nt);
      setSingleLineAllCaps(this.Nu);
    }
    for (;;)
    {
      this.Nx = ((int)(paramContext.getResources().getDisplayMetrics().density * 16.0F));
      return;
      this.Ns.setSingleLine();
      this.Nt.setSingleLine();
      this.Nu.setSingleLine();
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
    if (paramInt != this.Nv)
    {
      a(paramInt, this.Nr.getAdapter());
      this.Nz = true;
      m = this.Ns.getMeasuredWidth();
      i4 = this.Nt.getMeasuredWidth();
      k = this.Nu.getMeasuredWidth();
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
      i7 = this.Ns.getBaseline();
      i6 = this.Nt.getBaseline();
      i5 = this.Nu.getBaseline();
      i8 = Math.max(Math.max(i7, i6), i5);
      i7 = i8 - i7;
      i6 = i8 - i6;
      i5 = i8 - i5;
      i8 = this.Ns.getMeasuredHeight();
      int i9 = this.Nt.getMeasuredHeight();
      int i10 = this.Nu.getMeasuredHeight();
      i8 = Math.max(Math.max(i8 + i7, i9 + i6), i10 + i5);
      switch (this.Hu & 0x70)
      {
      default: 
        j = paramInt + i7;
        i = paramInt + i6;
        paramInt += i5;
      }
    }
    for (;;)
    {
      this.Nt.layout(i3, i, i4, this.Nt.getMeasuredHeight() + i);
      i = Math.min(i2, i3 - this.Nx - m);
      this.Ns.layout(i, j, m + i, this.Ns.getMeasuredHeight() + j);
      i = Math.max(n - i1 - k, this.Nx + i4);
      this.Nu.layout(i, paramInt, i + k, this.Nu.getMeasuredHeight() + paramInt);
      this.Nw = paramFloat;
      this.Nz = false;
      return;
      if ((paramBoolean) || (paramFloat != this.Nw)) {
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
      this.Ny = true;
      if ((paramInt <= 0) || (paramq == null)) {
        break label235;
      }
    }
    label235:
    for (Object localObject1 = paramq.getPageTitle(paramInt - 1);; localObject1 = null)
    {
      this.Ns.setText((CharSequence)localObject1);
      TextView localTextView = this.Nt;
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
        this.Nu.setText((CharSequence)localObject1);
        i = View.MeasureSpec.makeMeasureSpec(Math.max(0, (int)((getWidth() - getPaddingLeft() - getPaddingRight()) * 0.8F)), -2147483648);
        int j = View.MeasureSpec.makeMeasureSpec(Math.max(0, getHeight() - getPaddingTop() - getPaddingBottom()), -2147483648);
        this.Ns.measure(i, j);
        this.Nt.measure(i, j);
        this.Nu.measure(i, j);
        this.Nv = paramInt;
        if (!this.Nz) {
          a(paramInt, this.Nw, false);
        }
        this.Ny = false;
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
      paramq1.unregisterDataSetObserver(this.NA);
      this.NB = null;
    }
    if (paramq2 != null)
    {
      paramq2.registerDataSetObserver(this.NA);
      this.NB = new WeakReference(paramq2);
    }
    if (this.Nr != null)
    {
      this.Nv = -1;
      this.Nw = -1.0F;
      a(this.Nr.getCurrentItem(), paramq2);
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
    return this.Nx;
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
    ((ViewPager)localObject).setInternalPageChangeListener(this.NA);
    ((ViewPager)localObject).addOnAdapterChangeListener(this.NA);
    this.Nr = ((ViewPager)localObject);
    if (this.NB != null) {}
    for (localObject = (q)this.NB.get();; localObject = null)
    {
      a((q)localObject, localq);
      return;
    }
  }
  
  protected void onDetachedFromWindow()
  {
    super.onDetachedFromWindow();
    if (this.Nr != null)
    {
      a(this.Nr.getAdapter(), null);
      this.Nr.setInternalPageChangeListener(null);
      this.Nr.removeOnAdapterChangeListener(this.NA);
      this.Nr = null;
    }
  }
  
  protected void onLayout(boolean paramBoolean, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    float f = 0.0F;
    if (this.Nr != null)
    {
      if (this.Nw >= 0.0F) {
        f = this.Nw;
      }
      a(this.Nv, f, true);
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
    this.Ns.measure(paramInt1, k);
    this.Nt.measure(paramInt1, k);
    this.Nu.measure(paramInt1, k);
    if (View.MeasureSpec.getMode(paramInt2) == 1073741824) {}
    for (paramInt1 = View.MeasureSpec.getSize(paramInt2);; paramInt1 = Math.max(getMinHeight(), j + paramInt1))
    {
      setMeasuredDimension(i, View.resolveSizeAndState(paramInt1, paramInt2, this.Nt.getMeasuredState() << 16));
      return;
      paramInt1 = this.Nt.getMeasuredHeight();
    }
  }
  
  public void requestLayout()
  {
    if (!this.Ny) {
      super.requestLayout();
    }
  }
  
  public void setGravity(int paramInt)
  {
    this.Hu = paramInt;
    requestLayout();
  }
  
  public void setNonPrimaryAlpha(float paramFloat)
  {
    this.NE = ((int)(255.0F * paramFloat) & 0xFF);
    int i = this.NE << 24 | this.mTextColor & 0xFFFFFF;
    this.Ns.setTextColor(i);
    this.Nu.setTextColor(i);
  }
  
  public void setTextColor(int paramInt)
  {
    this.mTextColor = paramInt;
    this.Nt.setTextColor(paramInt);
    paramInt = this.NE << 24 | this.mTextColor & 0xFFFFFF;
    this.Ns.setTextColor(paramInt);
    this.Nu.setTextColor(paramInt);
  }
  
  public void setTextSpacing(int paramInt)
  {
    this.Nx = paramInt;
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
      PagerTitleStrip.this.a(PagerTitleStrip.this.Nr.getCurrentItem(), PagerTitleStrip.this.Nr.getAdapter());
      if (PagerTitleStrip.this.Nw >= 0.0F) {
        f = PagerTitleStrip.this.Nw;
      }
      PagerTitleStrip.this.a(PagerTitleStrip.this.Nr.getCurrentItem(), f, true);
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
        PagerTitleStrip.this.a(PagerTitleStrip.this.Nr.getCurrentItem(), PagerTitleStrip.this.Nr.getAdapter());
        if (PagerTitleStrip.this.Nw >= 0.0F) {
          f = PagerTitleStrip.this.Nw;
        }
        PagerTitleStrip.this.a(PagerTitleStrip.this.Nr.getCurrentItem(), f, true);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     android.support.v4.view.PagerTitleStrip
 * JD-Core Version:    0.7.0.1
 */