package androidx.viewpager.widget;

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
import androidx.core.widget.i;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.lang.ref.WeakReference;

@ViewPager.a
public class PagerTitleStrip
  extends ViewGroup
{
  private static final int[] avH = { 16843660 };
  private static final int[] oG = { 16842804, 16842901, 16842904, 16842927 };
  private int avA;
  float avB;
  private int avC;
  private boolean avD;
  private boolean avE;
  private final a avF;
  private WeakReference<a> avG;
  private int avI;
  int avJ;
  ViewPager avw;
  TextView avx;
  TextView avy;
  TextView avz;
  private int sK;
  
  public PagerTitleStrip(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(235164);
    this.avA = -1;
    this.avB = -1.0F;
    this.avF = new a();
    TextView localTextView = new TextView(paramContext);
    this.avx = localTextView;
    addView(localTextView);
    localTextView = new TextView(paramContext);
    this.avy = localTextView;
    addView(localTextView);
    localTextView = new TextView(paramContext);
    this.avz = localTextView;
    addView(localTextView);
    paramAttributeSet = paramContext.obtainStyledAttributes(paramAttributeSet, oG);
    int i = paramAttributeSet.getResourceId(0, 0);
    if (i != 0)
    {
      i.a(this.avx, i);
      i.a(this.avy, i);
      i.a(this.avz, i);
    }
    int j = paramAttributeSet.getDimensionPixelSize(1, 0);
    if (j != 0)
    {
      float f = j;
      this.avx.setTextSize(0, f);
      this.avy.setTextSize(0, f);
      this.avz.setTextSize(0, f);
    }
    if (paramAttributeSet.hasValue(2))
    {
      j = paramAttributeSet.getColor(2, 0);
      this.avx.setTextColor(j);
      this.avy.setTextColor(j);
      this.avz.setTextColor(j);
    }
    this.sK = paramAttributeSet.getInteger(3, 80);
    paramAttributeSet.recycle();
    this.avJ = this.avy.getTextColors().getDefaultColor();
    setNonPrimaryAlpha(0.6F);
    this.avx.setEllipsize(TextUtils.TruncateAt.END);
    this.avy.setEllipsize(TextUtils.TruncateAt.END);
    this.avz.setEllipsize(TextUtils.TruncateAt.END);
    if (i != 0)
    {
      paramAttributeSet = paramContext.obtainStyledAttributes(i, avH);
      bool = paramAttributeSet.getBoolean(0, false);
      paramAttributeSet.recycle();
    }
    if (bool)
    {
      setSingleLineAllCaps(this.avx);
      setSingleLineAllCaps(this.avy);
      setSingleLineAllCaps(this.avz);
    }
    for (;;)
    {
      this.avC = ((int)(paramContext.getResources().getDisplayMetrics().density * 16.0F));
      AppMethodBeat.o(235164);
      return;
      this.avx.setSingleLine();
      this.avy.setSingleLine();
      this.avz.setSingleLine();
    }
  }
  
  private static void setSingleLineAllCaps(TextView paramTextView)
  {
    AppMethodBeat.i(235159);
    paramTextView.setTransformationMethod(new PagerTitleStrip.b(paramTextView.getContext()));
    AppMethodBeat.o(235159);
  }
  
  void a(int paramInt, float paramFloat, boolean paramBoolean)
  {
    AppMethodBeat.i(235183);
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
    if (paramInt != this.avA)
    {
      a(paramInt, this.avw.getAdapter());
      this.avE = true;
      m = this.avx.getMeasuredWidth();
      i4 = this.avy.getMeasuredWidth();
      k = this.avz.getMeasuredWidth();
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
      i7 = this.avx.getBaseline();
      i6 = this.avy.getBaseline();
      i5 = this.avz.getBaseline();
      i8 = Math.max(Math.max(i7, i6), i5);
      i7 = i8 - i7;
      i6 = i8 - i6;
      i5 = i8 - i5;
      i8 = this.avx.getMeasuredHeight();
      int i9 = this.avy.getMeasuredHeight();
      int i10 = this.avz.getMeasuredHeight();
      i8 = Math.max(Math.max(i8 + i7, i9 + i6), i10 + i5);
      switch (this.sK & 0x70)
      {
      default: 
        j = paramInt + i7;
        i = paramInt + i6;
        paramInt += i5;
      }
    }
    for (;;)
    {
      this.avy.layout(i3, i, i4, this.avy.getMeasuredHeight() + i);
      i = Math.min(i2, i3 - this.avC - m);
      this.avx.layout(i, j, m + i, this.avx.getMeasuredHeight() + j);
      i = Math.max(n - i1 - k, this.avC + i4);
      this.avz.layout(i, paramInt, i + k, this.avz.getMeasuredHeight() + paramInt);
      this.avB = paramFloat;
      this.avE = false;
      AppMethodBeat.o(235183);
      return;
      if ((paramBoolean) || (paramFloat != this.avB)) {
        break;
      }
      AppMethodBeat.o(235183);
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
  
  final void a(int paramInt, a parama)
  {
    Object localObject2 = null;
    AppMethodBeat.i(235178);
    int i;
    if (parama != null)
    {
      i = parama.getCount();
      this.avD = true;
      if ((paramInt <= 0) || (parama == null)) {
        break label245;
      }
    }
    label245:
    for (Object localObject1 = parama.getPageTitle(paramInt - 1);; localObject1 = null)
    {
      this.avx.setText((CharSequence)localObject1);
      TextView localTextView = this.avy;
      if ((parama != null) && (paramInt < i)) {}
      for (localObject1 = parama.getPageTitle(paramInt);; localObject1 = null)
      {
        localTextView.setText((CharSequence)localObject1);
        localObject1 = localObject2;
        if (paramInt + 1 < i)
        {
          localObject1 = localObject2;
          if (parama != null) {
            localObject1 = parama.getPageTitle(paramInt + 1);
          }
        }
        this.avz.setText((CharSequence)localObject1);
        i = View.MeasureSpec.makeMeasureSpec(Math.max(0, (int)((getWidth() - getPaddingLeft() - getPaddingRight()) * 0.8F)), -2147483648);
        int j = View.MeasureSpec.makeMeasureSpec(Math.max(0, getHeight() - getPaddingTop() - getPaddingBottom()), -2147483648);
        this.avx.measure(i, j);
        this.avy.measure(i, j);
        this.avz.measure(i, j);
        this.avA = paramInt;
        if (!this.avE) {
          a(paramInt, this.avB, false);
        }
        this.avD = false;
        AppMethodBeat.o(235178);
        return;
        i = 0;
        break;
      }
    }
  }
  
  final void a(a parama1, a parama2)
  {
    AppMethodBeat.i(235181);
    if (parama1 != null)
    {
      parama1.unregisterDataSetObserver(this.avF);
      this.avG = null;
    }
    if (parama2 != null)
    {
      parama2.registerDataSetObserver(this.avF);
      this.avG = new WeakReference(parama2);
    }
    if (this.avw != null)
    {
      this.avA = -1;
      this.avB = -1.0F;
      a(this.avw.getCurrentItem(), parama2);
      requestLayout();
    }
    AppMethodBeat.o(235181);
  }
  
  int getMinHeight()
  {
    AppMethodBeat.i(235189);
    int i = 0;
    Drawable localDrawable = getBackground();
    if (localDrawable != null) {
      i = localDrawable.getIntrinsicHeight();
    }
    AppMethodBeat.o(235189);
    return i;
  }
  
  public int getTextSpacing()
  {
    return this.avC;
  }
  
  protected void onAttachedToWindow()
  {
    AppMethodBeat.i(235175);
    super.onAttachedToWindow();
    Object localObject = getParent();
    if (!(localObject instanceof ViewPager))
    {
      localObject = new IllegalStateException("PagerTitleStrip must be a direct child of a ViewPager.");
      AppMethodBeat.o(235175);
      throw ((Throwable)localObject);
    }
    localObject = (ViewPager)localObject;
    a locala = ((ViewPager)localObject).getAdapter();
    ((ViewPager)localObject).setInternalPageChangeListener(this.avF);
    ((ViewPager)localObject).addOnAdapterChangeListener(this.avF);
    this.avw = ((ViewPager)localObject);
    if (this.avG != null) {}
    for (localObject = (a)this.avG.get();; localObject = null)
    {
      a((a)localObject, locala);
      AppMethodBeat.o(235175);
      return;
    }
  }
  
  protected void onDetachedFromWindow()
  {
    AppMethodBeat.i(235177);
    super.onDetachedFromWindow();
    if (this.avw != null)
    {
      a(this.avw.getAdapter(), null);
      this.avw.setInternalPageChangeListener(null);
      this.avw.removeOnAdapterChangeListener(this.avF);
      this.avw = null;
    }
    AppMethodBeat.o(235177);
  }
  
  protected void onLayout(boolean paramBoolean, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    float f = 0.0F;
    AppMethodBeat.i(235188);
    if (this.avw != null)
    {
      if (this.avB >= 0.0F) {
        f = this.avB;
      }
      a(this.avA, f, true);
    }
    AppMethodBeat.o(235188);
  }
  
  protected void onMeasure(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(235187);
    if (View.MeasureSpec.getMode(paramInt1) != 1073741824)
    {
      IllegalStateException localIllegalStateException = new IllegalStateException("Must measure with an exact width");
      AppMethodBeat.o(235187);
      throw localIllegalStateException;
    }
    int j = getPaddingTop() + getPaddingBottom();
    int k = getChildMeasureSpec(paramInt2, j, -2);
    int i = View.MeasureSpec.getSize(paramInt1);
    paramInt1 = getChildMeasureSpec(paramInt1, (int)(i * 0.2F), -2);
    this.avx.measure(paramInt1, k);
    this.avy.measure(paramInt1, k);
    this.avz.measure(paramInt1, k);
    if (View.MeasureSpec.getMode(paramInt2) == 1073741824) {}
    for (paramInt1 = View.MeasureSpec.getSize(paramInt2);; paramInt1 = Math.max(getMinHeight(), j + paramInt1))
    {
      setMeasuredDimension(i, View.resolveSizeAndState(paramInt1, paramInt2, this.avy.getMeasuredState() << 16));
      AppMethodBeat.o(235187);
      return;
      paramInt1 = this.avy.getMeasuredHeight();
    }
  }
  
  public void requestLayout()
  {
    AppMethodBeat.i(235179);
    if (!this.avD) {
      super.requestLayout();
    }
    AppMethodBeat.o(235179);
  }
  
  public void setGravity(int paramInt)
  {
    AppMethodBeat.i(235173);
    this.sK = paramInt;
    requestLayout();
    AppMethodBeat.o(235173);
  }
  
  public void setNonPrimaryAlpha(float paramFloat)
  {
    AppMethodBeat.i(235169);
    this.avI = ((int)(255.0F * paramFloat) & 0xFF);
    int i = this.avI << 24 | this.avJ & 0xFFFFFF;
    this.avx.setTextColor(i);
    this.avz.setTextColor(i);
    AppMethodBeat.o(235169);
  }
  
  public void setTextColor(int paramInt)
  {
    AppMethodBeat.i(235172);
    this.avJ = paramInt;
    this.avy.setTextColor(paramInt);
    paramInt = this.avI << 24 | this.avJ & 0xFFFFFF;
    this.avx.setTextColor(paramInt);
    this.avz.setTextColor(paramInt);
    AppMethodBeat.o(235172);
  }
  
  public void setTextSpacing(int paramInt)
  {
    AppMethodBeat.i(235166);
    this.avC = paramInt;
    requestLayout();
    AppMethodBeat.o(235166);
  }
  
  final class a
    extends DataSetObserver
    implements ViewPager.OnPageChangeListener, ViewPager.c
  {
    private int mScrollState;
    
    a() {}
    
    public final void a(ViewPager paramViewPager, a parama1, a parama2)
    {
      AppMethodBeat.i(235144);
      PagerTitleStrip.this.a(parama1, parama2);
      AppMethodBeat.o(235144);
    }
    
    public final void onChanged()
    {
      float f = 0.0F;
      AppMethodBeat.i(235145);
      PagerTitleStrip.this.a(PagerTitleStrip.this.avw.getCurrentItem(), PagerTitleStrip.this.avw.getAdapter());
      if (PagerTitleStrip.this.avB >= 0.0F) {
        f = PagerTitleStrip.this.avB;
      }
      PagerTitleStrip.this.a(PagerTitleStrip.this.avw.getCurrentItem(), f, true);
      AppMethodBeat.o(235145);
    }
    
    public final void onPageScrollStateChanged(int paramInt)
    {
      this.mScrollState = paramInt;
    }
    
    public final void onPageScrolled(int paramInt1, float paramFloat, int paramInt2)
    {
      AppMethodBeat.i(235138);
      paramInt2 = paramInt1;
      if (paramFloat > 0.5F) {
        paramInt2 = paramInt1 + 1;
      }
      PagerTitleStrip.this.a(paramInt2, paramFloat, false);
      AppMethodBeat.o(235138);
    }
    
    public final void onPageSelected(int paramInt)
    {
      float f = 0.0F;
      AppMethodBeat.i(235140);
      if (this.mScrollState == 0)
      {
        PagerTitleStrip.this.a(PagerTitleStrip.this.avw.getCurrentItem(), PagerTitleStrip.this.avw.getAdapter());
        if (PagerTitleStrip.this.avB >= 0.0F) {
          f = PagerTitleStrip.this.avB;
        }
        PagerTitleStrip.this.a(PagerTitleStrip.this.avw.getCurrentItem(), f, true);
      }
      AppMethodBeat.o(235140);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     androidx.viewpager.widget.PagerTitleStrip
 * JD-Core Version:    0.7.0.1
 */