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
import androidx.core.widget.j;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.lang.ref.WeakReference;

@ViewPager.a
public class PagerTitleStrip
  extends ViewGroup
{
  private static final int[] ckd = { 16843660 };
  private static final int[] pD = { 16842804, 16842901, 16842904, 16842927 };
  ViewPager cjS;
  TextView cjT;
  TextView cjU;
  TextView cjV;
  private int cjW;
  float cjX;
  private int cjY;
  private boolean cjZ;
  private boolean cka;
  private final a ckb;
  private WeakReference<a> ckc;
  private int cke;
  int ckf;
  private int tJ;
  
  public PagerTitleStrip(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(193342);
    this.cjW = -1;
    this.cjX = -1.0F;
    this.ckb = new a();
    TextView localTextView = new TextView(paramContext);
    this.cjT = localTextView;
    addView(localTextView);
    localTextView = new TextView(paramContext);
    this.cjU = localTextView;
    addView(localTextView);
    localTextView = new TextView(paramContext);
    this.cjV = localTextView;
    addView(localTextView);
    paramAttributeSet = paramContext.obtainStyledAttributes(paramAttributeSet, pD);
    int i = paramAttributeSet.getResourceId(0, 0);
    if (i != 0)
    {
      j.a(this.cjT, i);
      j.a(this.cjU, i);
      j.a(this.cjV, i);
    }
    int j = paramAttributeSet.getDimensionPixelSize(1, 0);
    if (j != 0)
    {
      float f = j;
      this.cjT.setTextSize(0, f);
      this.cjU.setTextSize(0, f);
      this.cjV.setTextSize(0, f);
    }
    if (paramAttributeSet.hasValue(2))
    {
      j = paramAttributeSet.getColor(2, 0);
      this.cjT.setTextColor(j);
      this.cjU.setTextColor(j);
      this.cjV.setTextColor(j);
    }
    this.tJ = paramAttributeSet.getInteger(3, 80);
    paramAttributeSet.recycle();
    this.ckf = this.cjU.getTextColors().getDefaultColor();
    setNonPrimaryAlpha(0.6F);
    this.cjT.setEllipsize(TextUtils.TruncateAt.END);
    this.cjU.setEllipsize(TextUtils.TruncateAt.END);
    this.cjV.setEllipsize(TextUtils.TruncateAt.END);
    if (i != 0)
    {
      paramAttributeSet = paramContext.obtainStyledAttributes(i, ckd);
      bool = paramAttributeSet.getBoolean(0, false);
      paramAttributeSet.recycle();
    }
    if (bool)
    {
      setSingleLineAllCaps(this.cjT);
      setSingleLineAllCaps(this.cjU);
      setSingleLineAllCaps(this.cjV);
    }
    for (;;)
    {
      this.cjY = ((int)(paramContext.getResources().getDisplayMetrics().density * 16.0F));
      AppMethodBeat.o(193342);
      return;
      this.cjT.setSingleLine();
      this.cjU.setSingleLine();
      this.cjV.setSingleLine();
    }
  }
  
  private static void setSingleLineAllCaps(TextView paramTextView)
  {
    AppMethodBeat.i(193330);
    paramTextView.setTransformationMethod(new PagerTitleStrip.b(paramTextView.getContext()));
    AppMethodBeat.o(193330);
  }
  
  void a(int paramInt, float paramFloat, boolean paramBoolean)
  {
    AppMethodBeat.i(193436);
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
    if (paramInt != this.cjW)
    {
      a(paramInt, this.cjS.getAdapter());
      this.cka = true;
      m = this.cjT.getMeasuredWidth();
      i4 = this.cjU.getMeasuredWidth();
      k = this.cjV.getMeasuredWidth();
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
      i7 = this.cjT.getBaseline();
      i6 = this.cjU.getBaseline();
      i5 = this.cjV.getBaseline();
      i8 = Math.max(Math.max(i7, i6), i5);
      i7 = i8 - i7;
      i6 = i8 - i6;
      i5 = i8 - i5;
      i8 = this.cjT.getMeasuredHeight();
      int i9 = this.cjU.getMeasuredHeight();
      int i10 = this.cjV.getMeasuredHeight();
      i8 = Math.max(Math.max(i8 + i7, i9 + i6), i10 + i5);
      switch (this.tJ & 0x70)
      {
      default: 
        j = paramInt + i7;
        i = paramInt + i6;
        paramInt += i5;
      }
    }
    for (;;)
    {
      this.cjU.layout(i3, i, i4, this.cjU.getMeasuredHeight() + i);
      i = Math.min(i2, i3 - this.cjY - m);
      this.cjT.layout(i, j, m + i, this.cjT.getMeasuredHeight() + j);
      i = Math.max(n - i1 - k, this.cjY + i4);
      this.cjV.layout(i, paramInt, i + k, this.cjV.getMeasuredHeight() + paramInt);
      this.cjX = paramFloat;
      this.cka = false;
      AppMethodBeat.o(193436);
      return;
      if ((paramBoolean) || (paramFloat != this.cjX)) {
        break;
      }
      AppMethodBeat.o(193436);
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
    AppMethodBeat.i(193408);
    int i;
    if (parama != null)
    {
      i = parama.getCount();
      this.cjZ = true;
      if ((paramInt <= 0) || (parama == null)) {
        break label245;
      }
    }
    label245:
    for (Object localObject1 = parama.getPageTitle(paramInt - 1);; localObject1 = null)
    {
      this.cjT.setText((CharSequence)localObject1);
      TextView localTextView = this.cjU;
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
        this.cjV.setText((CharSequence)localObject1);
        i = View.MeasureSpec.makeMeasureSpec(Math.max(0, (int)((getWidth() - getPaddingLeft() - getPaddingRight()) * 0.8F)), -2147483648);
        int j = View.MeasureSpec.makeMeasureSpec(Math.max(0, getHeight() - getPaddingTop() - getPaddingBottom()), -2147483648);
        this.cjT.measure(i, j);
        this.cjU.measure(i, j);
        this.cjV.measure(i, j);
        this.cjW = paramInt;
        if (!this.cka) {
          a(paramInt, this.cjX, false);
        }
        this.cjZ = false;
        AppMethodBeat.o(193408);
        return;
        i = 0;
        break;
      }
    }
  }
  
  final void a(a parama1, a parama2)
  {
    AppMethodBeat.i(193420);
    if (parama1 != null)
    {
      parama1.unregisterDataSetObserver(this.ckb);
      this.ckc = null;
    }
    if (parama2 != null)
    {
      parama2.registerDataSetObserver(this.ckb);
      this.ckc = new WeakReference(parama2);
    }
    if (this.cjS != null)
    {
      this.cjW = -1;
      this.cjX = -1.0F;
      a(this.cjS.getCurrentItem(), parama2);
      requestLayout();
    }
    AppMethodBeat.o(193420);
  }
  
  int getMinHeight()
  {
    AppMethodBeat.i(193458);
    int i = 0;
    Drawable localDrawable = getBackground();
    if (localDrawable != null) {
      i = localDrawable.getIntrinsicHeight();
    }
    AppMethodBeat.o(193458);
    return i;
  }
  
  public int getTextSpacing()
  {
    return this.cjY;
  }
  
  protected void onAttachedToWindow()
  {
    AppMethodBeat.i(193390);
    super.onAttachedToWindow();
    Object localObject = getParent();
    if (!(localObject instanceof ViewPager))
    {
      localObject = new IllegalStateException("PagerTitleStrip must be a direct child of a ViewPager.");
      AppMethodBeat.o(193390);
      throw ((Throwable)localObject);
    }
    localObject = (ViewPager)localObject;
    a locala = ((ViewPager)localObject).getAdapter();
    ((ViewPager)localObject).setInternalPageChangeListener(this.ckb);
    ((ViewPager)localObject).addOnAdapterChangeListener(this.ckb);
    this.cjS = ((ViewPager)localObject);
    if (this.ckc != null) {}
    for (localObject = (a)this.ckc.get();; localObject = null)
    {
      a((a)localObject, locala);
      AppMethodBeat.o(193390);
      return;
    }
  }
  
  protected void onDetachedFromWindow()
  {
    AppMethodBeat.i(193398);
    super.onDetachedFromWindow();
    if (this.cjS != null)
    {
      a(this.cjS.getAdapter(), null);
      this.cjS.setInternalPageChangeListener(null);
      this.cjS.removeOnAdapterChangeListener(this.ckb);
      this.cjS = null;
    }
    AppMethodBeat.o(193398);
  }
  
  protected void onLayout(boolean paramBoolean, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    float f = 0.0F;
    AppMethodBeat.i(193448);
    if (this.cjS != null)
    {
      if (this.cjX >= 0.0F) {
        f = this.cjX;
      }
      a(this.cjW, f, true);
    }
    AppMethodBeat.o(193448);
  }
  
  protected void onMeasure(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(193444);
    if (View.MeasureSpec.getMode(paramInt1) != 1073741824)
    {
      IllegalStateException localIllegalStateException = new IllegalStateException("Must measure with an exact width");
      AppMethodBeat.o(193444);
      throw localIllegalStateException;
    }
    int j = getPaddingTop() + getPaddingBottom();
    int k = getChildMeasureSpec(paramInt2, j, -2);
    int i = View.MeasureSpec.getSize(paramInt1);
    paramInt1 = getChildMeasureSpec(paramInt1, (int)(i * 0.2F), -2);
    this.cjT.measure(paramInt1, k);
    this.cjU.measure(paramInt1, k);
    this.cjV.measure(paramInt1, k);
    if (View.MeasureSpec.getMode(paramInt2) == 1073741824) {}
    for (paramInt1 = View.MeasureSpec.getSize(paramInt2);; paramInt1 = Math.max(getMinHeight(), j + paramInt1))
    {
      setMeasuredDimension(i, View.resolveSizeAndState(paramInt1, paramInt2, this.cjU.getMeasuredState() << 16));
      AppMethodBeat.o(193444);
      return;
      paramInt1 = this.cjU.getMeasuredHeight();
    }
  }
  
  public void requestLayout()
  {
    AppMethodBeat.i(193414);
    if (!this.cjZ) {
      super.requestLayout();
    }
    AppMethodBeat.o(193414);
  }
  
  public void setGravity(int paramInt)
  {
    AppMethodBeat.i(193380);
    this.tJ = paramInt;
    requestLayout();
    AppMethodBeat.o(193380);
  }
  
  public void setNonPrimaryAlpha(float paramFloat)
  {
    AppMethodBeat.i(193365);
    this.cke = ((int)(255.0F * paramFloat) & 0xFF);
    int i = this.cke << 24 | this.ckf & 0xFFFFFF;
    this.cjT.setTextColor(i);
    this.cjV.setTextColor(i);
    AppMethodBeat.o(193365);
  }
  
  public void setTextColor(int paramInt)
  {
    AppMethodBeat.i(193372);
    this.ckf = paramInt;
    this.cjU.setTextColor(paramInt);
    paramInt = this.cke << 24 | this.ckf & 0xFFFFFF;
    this.cjT.setTextColor(paramInt);
    this.cjV.setTextColor(paramInt);
    AppMethodBeat.o(193372);
  }
  
  public void setTextSpacing(int paramInt)
  {
    AppMethodBeat.i(193355);
    this.cjY = paramInt;
    requestLayout();
    AppMethodBeat.o(193355);
  }
  
  final class a
    extends DataSetObserver
    implements ViewPager.OnPageChangeListener, ViewPager.c
  {
    private int mScrollState;
    
    a() {}
    
    public final void a(ViewPager paramViewPager, a parama1, a parama2)
    {
      AppMethodBeat.i(193320);
      PagerTitleStrip.this.a(parama1, parama2);
      AppMethodBeat.o(193320);
    }
    
    public final void onChanged()
    {
      float f = 0.0F;
      AppMethodBeat.i(193328);
      PagerTitleStrip.this.a(PagerTitleStrip.this.cjS.getCurrentItem(), PagerTitleStrip.this.cjS.getAdapter());
      if (PagerTitleStrip.this.cjX >= 0.0F) {
        f = PagerTitleStrip.this.cjX;
      }
      PagerTitleStrip.this.a(PagerTitleStrip.this.cjS.getCurrentItem(), f, true);
      AppMethodBeat.o(193328);
    }
    
    public final void onPageScrollStateChanged(int paramInt)
    {
      this.mScrollState = paramInt;
    }
    
    public final void onPageScrolled(int paramInt1, float paramFloat, int paramInt2)
    {
      AppMethodBeat.i(193302);
      paramInt2 = paramInt1;
      if (paramFloat > 0.5F) {
        paramInt2 = paramInt1 + 1;
      }
      PagerTitleStrip.this.a(paramInt2, paramFloat, false);
      AppMethodBeat.o(193302);
    }
    
    public final void onPageSelected(int paramInt)
    {
      float f = 0.0F;
      AppMethodBeat.i(193308);
      if (this.mScrollState == 0)
      {
        PagerTitleStrip.this.a(PagerTitleStrip.this.cjS.getCurrentItem(), PagerTitleStrip.this.cjS.getAdapter());
        if (PagerTitleStrip.this.cjX >= 0.0F) {
          f = PagerTitleStrip.this.cjX;
        }
        PagerTitleStrip.this.a(PagerTitleStrip.this.cjS.getCurrentItem(), f, true);
      }
      AppMethodBeat.o(193308);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes10.jar
 * Qualified Name:     androidx.viewpager.widget.PagerTitleStrip
 * JD-Core Version:    0.7.0.1
 */