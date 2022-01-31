package android.support.v7.widget;

import android.animation.ObjectAnimator;
import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.PorterDuff.Mode;
import android.graphics.Rect;
import android.graphics.Region.Op;
import android.graphics.Typeface;
import android.graphics.drawable.Drawable;
import android.os.Build.VERSION;
import android.support.v4.view.q;
import android.support.v7.a.a.a;
import android.support.v7.a.a.j;
import android.support.v7.c.a.b;
import android.text.Layout;
import android.text.Layout.Alignment;
import android.text.StaticLayout;
import android.text.TextPaint;
import android.text.TextUtils;
import android.text.method.TransformationMethod;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.util.Property;
import android.view.MotionEvent;
import android.view.VelocityTracker;
import android.view.ViewConfiguration;
import android.view.ViewParent;
import android.view.accessibility.AccessibilityEvent;
import android.view.accessibility.AccessibilityNodeInfo;
import android.widget.CompoundButton;
import java.util.List;

public class SwitchCompat
  extends CompoundButton
{
  private static final Property<SwitchCompat, Float> alh = new SwitchCompat.1(Float.class, "thumbPos");
  private static final int[] cL = { 16842912 };
  private int agm;
  private int alA;
  private float alB;
  private float alC;
  private float alD;
  private int alE;
  private int alF;
  private int alG;
  private int alH;
  private int alI;
  private int alJ;
  private int alK;
  private ColorStateList alL;
  private Layout alM;
  private Layout alN;
  private TransformationMethod alO;
  ObjectAnimator alP;
  private Drawable ali;
  private ColorStateList alj = null;
  private PorterDuff.Mode alk = null;
  private boolean alm = false;
  private boolean aln = false;
  private Drawable alo;
  private ColorStateList alp = null;
  private PorterDuff.Mode alq = null;
  private boolean alr = false;
  private boolean als = false;
  private int alt;
  private int alu;
  private int alv;
  private boolean alw;
  private CharSequence alx;
  private CharSequence aly;
  private boolean alz;
  private final Rect ec = new Rect();
  private VelocityTracker fB = VelocityTracker.obtain();
  private final TextPaint gI = new TextPaint(1);
  private int jb;
  
  public SwitchCompat(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, a.a.switchStyle);
  }
  
  public SwitchCompat(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    Object localObject = getResources();
    this.gI.density = ((Resources)localObject).getDisplayMetrics().density;
    localObject = ax.a(paramContext, paramAttributeSet, a.j.SwitchCompat, paramInt, 0);
    this.ali = ((ax)localObject).getDrawable(a.j.SwitchCompat_android_thumb);
    if (this.ali != null) {
      this.ali.setCallback(this);
    }
    this.alo = ((ax)localObject).getDrawable(a.j.SwitchCompat_track);
    if (this.alo != null) {
      this.alo.setCallback(this);
    }
    this.alx = ((ax)localObject).getText(a.j.SwitchCompat_android_textOn);
    this.aly = ((ax)localObject).getText(a.j.SwitchCompat_android_textOff);
    this.alz = ((ax)localObject).getBoolean(a.j.SwitchCompat_showText, true);
    this.alt = ((ax)localObject).getDimensionPixelSize(a.j.SwitchCompat_thumbTextPadding, 0);
    this.alu = ((ax)localObject).getDimensionPixelSize(a.j.SwitchCompat_switchMinWidth, 0);
    this.alv = ((ax)localObject).getDimensionPixelSize(a.j.SwitchCompat_switchPadding, 0);
    this.alw = ((ax)localObject).getBoolean(a.j.SwitchCompat_splitTrack, false);
    paramAttributeSet = ((ax)localObject).getColorStateList(a.j.SwitchCompat_thumbTint);
    if (paramAttributeSet != null)
    {
      this.alj = paramAttributeSet;
      this.alm = true;
    }
    paramAttributeSet = y.c(((ax)localObject).getInt(a.j.SwitchCompat_thumbTintMode, -1), null);
    if (this.alk != paramAttributeSet)
    {
      this.alk = paramAttributeSet;
      this.aln = true;
    }
    if ((this.alm) || (this.aln)) {
      iU();
    }
    paramAttributeSet = ((ax)localObject).getColorStateList(a.j.SwitchCompat_trackTint);
    if (paramAttributeSet != null)
    {
      this.alp = paramAttributeSet;
      this.alr = true;
    }
    paramAttributeSet = y.c(((ax)localObject).getInt(a.j.SwitchCompat_trackTintMode, -1), null);
    if (this.alq != paramAttributeSet)
    {
      this.alq = paramAttributeSet;
      this.als = true;
    }
    if ((this.alr) || (this.als)) {
      iT();
    }
    paramInt = ((ax)localObject).getResourceId(a.j.SwitchCompat_switchTextAppearance, 0);
    ax localax;
    int i;
    label530:
    label545:
    label559:
    boolean bool;
    label580:
    float f;
    if (paramInt != 0)
    {
      localax = ax.a(paramContext, paramInt, a.j.TextAppearance);
      paramAttributeSet = localax.getColorStateList(a.j.TextAppearance_android_textColor);
      if (paramAttributeSet == null) {
        break label685;
      }
      this.alL = paramAttributeSet;
      paramInt = localax.getDimensionPixelSize(a.j.TextAppearance_android_textSize, 0);
      if ((paramInt != 0) && (paramInt != this.gI.getTextSize()))
      {
        this.gI.setTextSize(paramInt);
        requestLayout();
      }
      paramInt = localax.getInt(a.j.TextAppearance_android_typeface, -1);
      i = localax.getInt(a.j.TextAppearance_android_textStyle, -1);
      switch (paramInt)
      {
      default: 
        paramAttributeSet = null;
        if (i > 0) {
          if (paramAttributeSet == null)
          {
            paramAttributeSet = Typeface.defaultFromStyle(i);
            setSwitchTypeface(paramAttributeSet);
            if (paramAttributeSet == null) {
              break label727;
            }
            paramInt = paramAttributeSet.getStyle();
            paramInt = i & (paramInt ^ 0xFFFFFFFF);
            paramAttributeSet = this.gI;
            if ((paramInt & 0x1) == 0) {
              break label732;
            }
            bool = true;
            paramAttributeSet.setFakeBoldText(bool);
            paramAttributeSet = this.gI;
            if ((paramInt & 0x2) == 0) {
              break label738;
            }
            f = -0.25F;
            label602:
            paramAttributeSet.setTextSkewX(f);
            label608:
            if (!localax.getBoolean(a.j.TextAppearance_textAllCaps, false)) {
              break label768;
            }
          }
        }
        break;
      }
    }
    label768:
    for (this.alO = new android.support.v7.f.a(getContext());; this.alO = null)
    {
      localax.alZ.recycle();
      ((ax)localObject).alZ.recycle();
      paramContext = ViewConfiguration.get(paramContext);
      this.jb = paramContext.getScaledTouchSlop();
      this.agm = paramContext.getScaledMinimumFlingVelocity();
      refreshDrawableState();
      setChecked(isChecked());
      return;
      label685:
      this.alL = getTextColors();
      break;
      paramAttributeSet = Typeface.SANS_SERIF;
      break label530;
      paramAttributeSet = Typeface.SERIF;
      break label530;
      paramAttributeSet = Typeface.MONOSPACE;
      break label530;
      paramAttributeSet = Typeface.create(paramAttributeSet, i);
      break label545;
      label727:
      paramInt = 0;
      break label559;
      label732:
      bool = false;
      break label580;
      label738:
      f = 0.0F;
      break label602;
      this.gI.setFakeBoldText(false);
      this.gI.setTextSkewX(0.0F);
      setSwitchTypeface(paramAttributeSet);
      break label608;
    }
  }
  
  private boolean getTargetCheckedState()
  {
    return this.alD > 0.5F;
  }
  
  private int getThumbOffset()
  {
    if (bf.bF(this)) {}
    for (float f = 1.0F - this.alD;; f = this.alD) {
      return (int)(f * getThumbScrollRange() + 0.5F);
    }
  }
  
  private int getThumbScrollRange()
  {
    if (this.alo != null)
    {
      Rect localRect2 = this.ec;
      this.alo.getPadding(localRect2);
      if (this.ali != null) {}
      for (Rect localRect1 = y.k(this.ali);; localRect1 = y.abZ) {
        return this.alE - this.alG - localRect2.left - localRect2.right - localRect1.left - localRect1.right;
      }
    }
    return 0;
  }
  
  private void iT()
  {
    if ((this.alo != null) && ((this.alr) || (this.als)))
    {
      this.alo = this.alo.mutate();
      if (this.alr) {
        android.support.v4.a.a.a.a(this.alo, this.alp);
      }
      if (this.als) {
        android.support.v4.a.a.a.a(this.alo, this.alq);
      }
      if (this.alo.isStateful()) {
        this.alo.setState(getDrawableState());
      }
    }
  }
  
  private void iU()
  {
    if ((this.ali != null) && ((this.alm) || (this.aln)))
    {
      this.ali = this.ali.mutate();
      if (this.alm) {
        android.support.v4.a.a.a.a(this.ali, this.alj);
      }
      if (this.aln) {
        android.support.v4.a.a.a.a(this.ali, this.alk);
      }
      if (this.ali.isStateful()) {
        this.ali.setState(getDrawableState());
      }
    }
  }
  
  private Layout k(CharSequence paramCharSequence)
  {
    TextPaint localTextPaint;
    if (this.alO != null)
    {
      paramCharSequence = this.alO.getTransformation(paramCharSequence, this);
      localTextPaint = this.gI;
      if (paramCharSequence == null) {
        break label62;
      }
    }
    label62:
    for (int i = (int)Math.ceil(Layout.getDesiredWidth(paramCharSequence, this.gI));; i = 0)
    {
      return new StaticLayout(paramCharSequence, localTextPaint, i, Layout.Alignment.ALIGN_NORMAL, 1.0F, 0.0F, true);
      break;
    }
  }
  
  public void draw(Canvas paramCanvas)
  {
    Rect localRect = this.ec;
    int j = this.alH;
    int n = this.alI;
    int i2 = this.alJ;
    int i1 = this.alK;
    int i3 = j + getThumbOffset();
    Object localObject;
    int i4;
    label139:
    int m;
    int k;
    if (this.ali != null)
    {
      localObject = y.k(this.ali);
      if (this.alo == null) {
        break label340;
      }
      this.alo.getPadding(localRect);
      i4 = localRect.left;
      if (localObject == null) {
        break label320;
      }
      i = j;
      if (((Rect)localObject).left > localRect.left) {
        i = j + (((Rect)localObject).left - localRect.left);
      }
      if (((Rect)localObject).top <= localRect.top) {
        break label314;
      }
      j = ((Rect)localObject).top - localRect.top + n;
      m = i2;
      if (((Rect)localObject).right > localRect.right) {
        m = i2 - (((Rect)localObject).right - localRect.right);
      }
      if (((Rect)localObject).bottom <= localRect.bottom) {
        break label307;
      }
      k = i1 - (((Rect)localObject).bottom - localRect.bottom);
      label201:
      this.alo.setBounds(i, j, m, k);
    }
    label307:
    label314:
    label320:
    label340:
    for (int i = i4 + i3;; i = i3)
    {
      if (this.ali != null)
      {
        this.ali.getPadding(localRect);
        j = i - localRect.left;
        i = i + this.alG + localRect.right;
        this.ali.setBounds(j, n, i, i1);
        localObject = getBackground();
        if (localObject != null) {
          android.support.v4.a.a.a.a((Drawable)localObject, j, n, i, i1);
        }
      }
      super.draw(paramCanvas);
      return;
      localObject = y.abZ;
      break;
      k = i1;
      break label201;
      j = n;
      break label139;
      k = i1;
      m = n;
      i = j;
      j = m;
      m = i2;
      break label201;
    }
  }
  
  public void drawableHotspotChanged(float paramFloat1, float paramFloat2)
  {
    if (Build.VERSION.SDK_INT >= 21) {
      super.drawableHotspotChanged(paramFloat1, paramFloat2);
    }
    if (this.ali != null) {
      android.support.v4.a.a.a.a(this.ali, paramFloat1, paramFloat2);
    }
    if (this.alo != null) {
      android.support.v4.a.a.a.a(this.alo, paramFloat1, paramFloat2);
    }
  }
  
  protected void drawableStateChanged()
  {
    super.drawableStateChanged();
    int[] arrayOfInt = getDrawableState();
    boolean bool2 = false;
    Drawable localDrawable = this.ali;
    boolean bool1 = bool2;
    if (localDrawable != null)
    {
      bool1 = bool2;
      if (localDrawable.isStateful()) {
        bool1 = localDrawable.setState(arrayOfInt) | false;
      }
    }
    localDrawable = this.alo;
    bool2 = bool1;
    if (localDrawable != null)
    {
      bool2 = bool1;
      if (localDrawable.isStateful()) {
        bool2 = bool1 | localDrawable.setState(arrayOfInt);
      }
    }
    if (bool2) {
      invalidate();
    }
  }
  
  public int getCompoundPaddingLeft()
  {
    int i;
    if (!bf.bF(this)) {
      i = super.getCompoundPaddingLeft();
    }
    int j;
    do
    {
      return i;
      j = super.getCompoundPaddingLeft() + this.alE;
      i = j;
    } while (TextUtils.isEmpty(getText()));
    return j + this.alv;
  }
  
  public int getCompoundPaddingRight()
  {
    int i;
    if (bf.bF(this)) {
      i = super.getCompoundPaddingRight();
    }
    int j;
    do
    {
      return i;
      j = super.getCompoundPaddingRight() + this.alE;
      i = j;
    } while (TextUtils.isEmpty(getText()));
    return j + this.alv;
  }
  
  public boolean getShowText()
  {
    return this.alz;
  }
  
  public boolean getSplitTrack()
  {
    return this.alw;
  }
  
  public int getSwitchMinWidth()
  {
    return this.alu;
  }
  
  public int getSwitchPadding()
  {
    return this.alv;
  }
  
  public CharSequence getTextOff()
  {
    return this.aly;
  }
  
  public CharSequence getTextOn()
  {
    return this.alx;
  }
  
  public Drawable getThumbDrawable()
  {
    return this.ali;
  }
  
  public int getThumbTextPadding()
  {
    return this.alt;
  }
  
  public ColorStateList getThumbTintList()
  {
    return this.alj;
  }
  
  public PorterDuff.Mode getThumbTintMode()
  {
    return this.alk;
  }
  
  public Drawable getTrackDrawable()
  {
    return this.alo;
  }
  
  public ColorStateList getTrackTintList()
  {
    return this.alp;
  }
  
  public PorterDuff.Mode getTrackTintMode()
  {
    return this.alq;
  }
  
  public void jumpDrawablesToCurrentState()
  {
    super.jumpDrawablesToCurrentState();
    if (this.ali != null) {
      this.ali.jumpToCurrentState();
    }
    if (this.alo != null) {
      this.alo.jumpToCurrentState();
    }
    if ((this.alP != null) && (this.alP.isStarted()))
    {
      this.alP.end();
      this.alP = null;
    }
  }
  
  protected int[] onCreateDrawableState(int paramInt)
  {
    int[] arrayOfInt = super.onCreateDrawableState(paramInt + 1);
    if (isChecked()) {
      mergeDrawableStates(arrayOfInt, cL);
    }
    return arrayOfInt;
  }
  
  protected void onDraw(Canvas paramCanvas)
  {
    super.onDraw(paramCanvas);
    Object localObject1 = this.ec;
    Object localObject3 = this.alo;
    int k;
    int m;
    int n;
    int i1;
    Object localObject2;
    label151:
    int j;
    if (localObject3 != null)
    {
      ((Drawable)localObject3).getPadding((Rect)localObject1);
      k = this.alI;
      m = this.alK;
      n = ((Rect)localObject1).top;
      i1 = ((Rect)localObject1).bottom;
      localObject2 = this.ali;
      if (localObject3 != null)
      {
        if ((!this.alw) || (localObject2 == null)) {
          break label322;
        }
        Rect localRect = y.k((Drawable)localObject2);
        ((Drawable)localObject2).copyBounds((Rect)localObject1);
        ((Rect)localObject1).left += localRect.left;
        ((Rect)localObject1).right -= localRect.right;
        i = paramCanvas.save();
        paramCanvas.clipRect((Rect)localObject1, Region.Op.DIFFERENCE);
        ((Drawable)localObject3).draw(paramCanvas);
        paramCanvas.restoreToCount(i);
      }
      j = paramCanvas.save();
      if (localObject2 != null) {
        ((Drawable)localObject2).draw(paramCanvas);
      }
      if (!getTargetCheckedState()) {
        break label331;
      }
      localObject1 = this.alM;
      label180:
      if (localObject1 != null)
      {
        localObject3 = getDrawableState();
        if (this.alL != null) {
          this.gI.setColor(this.alL.getColorForState((int[])localObject3, 0));
        }
        this.gI.drawableState = ((int[])localObject3);
        if (localObject2 == null) {
          break label340;
        }
        localObject2 = ((Drawable)localObject2).getBounds();
        i = ((Rect)localObject2).left;
      }
    }
    label322:
    label331:
    label340:
    for (int i = ((Rect)localObject2).right + i;; i = getWidth())
    {
      i /= 2;
      int i2 = ((Layout)localObject1).getWidth() / 2;
      k = (k + n + (m - i1)) / 2;
      m = ((Layout)localObject1).getHeight() / 2;
      paramCanvas.translate(i - i2, k - m);
      ((Layout)localObject1).draw(paramCanvas);
      paramCanvas.restoreToCount(j);
      return;
      ((Rect)localObject1).setEmpty();
      break;
      ((Drawable)localObject3).draw(paramCanvas);
      break label151;
      localObject1 = this.alN;
      break label180;
    }
  }
  
  public void onInitializeAccessibilityEvent(AccessibilityEvent paramAccessibilityEvent)
  {
    super.onInitializeAccessibilityEvent(paramAccessibilityEvent);
    paramAccessibilityEvent.setClassName("android.widget.Switch");
  }
  
  public void onInitializeAccessibilityNodeInfo(AccessibilityNodeInfo paramAccessibilityNodeInfo)
  {
    super.onInitializeAccessibilityNodeInfo(paramAccessibilityNodeInfo);
    paramAccessibilityNodeInfo.setClassName("android.widget.Switch");
    if (isChecked()) {}
    CharSequence localCharSequence2;
    for (CharSequence localCharSequence1 = this.alx;; localCharSequence1 = this.aly)
    {
      if (!TextUtils.isEmpty(localCharSequence1))
      {
        localCharSequence2 = paramAccessibilityNodeInfo.getText();
        if (!TextUtils.isEmpty(localCharSequence2)) {
          break;
        }
        paramAccessibilityNodeInfo.setText(localCharSequence1);
      }
      return;
    }
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(localCharSequence2).append(' ').append(localCharSequence1);
    paramAccessibilityNodeInfo.setText(localStringBuilder);
  }
  
  protected void onLayout(boolean paramBoolean, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    super.onLayout(paramBoolean, paramInt1, paramInt2, paramInt3, paramInt4);
    Rect localRect1;
    if (this.ali != null)
    {
      localRect1 = this.ec;
      if (this.alo != null)
      {
        this.alo.getPadding(localRect1);
        Rect localRect2 = y.k(this.ali);
        paramInt2 = Math.max(0, localRect2.left - localRect1.left);
        paramInt1 = Math.max(0, localRect2.right - localRect1.right);
      }
    }
    for (;;)
    {
      if (bf.bF(this))
      {
        paramInt3 = getPaddingLeft() + paramInt2;
        paramInt4 = this.alE + paramInt3 - paramInt2 - paramInt1;
        label110:
        switch (getGravity() & 0x70)
        {
        default: 
          paramInt2 = getPaddingTop();
          paramInt1 = this.alF + paramInt2;
        }
      }
      for (;;)
      {
        this.alH = paramInt3;
        this.alI = paramInt2;
        this.alK = paramInt1;
        this.alJ = paramInt4;
        return;
        localRect1.setEmpty();
        break;
        paramInt4 = getWidth() - getPaddingRight() - paramInt1;
        paramInt3 = paramInt1 + (paramInt2 + (paramInt4 - this.alE));
        break label110;
        paramInt2 = (getPaddingTop() + getHeight() - getPaddingBottom()) / 2 - this.alF / 2;
        paramInt1 = this.alF + paramInt2;
        continue;
        paramInt1 = getHeight() - getPaddingBottom();
        paramInt2 = paramInt1 - this.alF;
      }
      paramInt1 = 0;
      paramInt2 = 0;
    }
  }
  
  public void onMeasure(int paramInt1, int paramInt2)
  {
    int m = 0;
    if (this.alz)
    {
      if (this.alM == null) {
        this.alM = k(this.alx);
      }
      if (this.alN == null) {
        this.alN = k(this.aly);
      }
    }
    Rect localRect = this.ec;
    int i;
    int k;
    if (this.ali != null)
    {
      this.ali.getPadding(localRect);
      j = this.ali.getIntrinsicWidth() - localRect.left - localRect.right;
      i = this.ali.getIntrinsicHeight();
      if (!this.alz) {
        break label303;
      }
      k = Math.max(this.alM.getWidth(), this.alN.getWidth()) + this.alt * 2;
      label133:
      this.alG = Math.max(k, j);
      if (this.alo == null) {
        break label309;
      }
      this.alo.getPadding(localRect);
    }
    for (int j = this.alo.getIntrinsicHeight();; j = m)
    {
      int i1 = localRect.left;
      int n = localRect.right;
      m = i1;
      k = n;
      if (this.ali != null)
      {
        localRect = y.k(this.ali);
        m = Math.max(i1, localRect.left);
        k = Math.max(n, localRect.right);
      }
      k = Math.max(this.alu, m + this.alG * 2 + k);
      i = Math.max(j, i);
      this.alE = k;
      this.alF = i;
      super.onMeasure(paramInt1, paramInt2);
      if (getMeasuredHeight() < i) {
        setMeasuredDimension(getMeasuredWidthAndState(), i);
      }
      return;
      i = 0;
      j = 0;
      break;
      label303:
      k = 0;
      break label133;
      label309:
      localRect.setEmpty();
    }
  }
  
  public void onPopulateAccessibilityEvent(AccessibilityEvent paramAccessibilityEvent)
  {
    super.onPopulateAccessibilityEvent(paramAccessibilityEvent);
    if (isChecked()) {}
    for (CharSequence localCharSequence = this.alx;; localCharSequence = this.aly)
    {
      if (localCharSequence != null) {
        paramAccessibilityEvent.getText().add(localCharSequence);
      }
      return;
    }
  }
  
  public boolean onTouchEvent(MotionEvent paramMotionEvent)
  {
    float f3 = 1.0F;
    int j = 0;
    boolean bool1 = true;
    this.fB.addMovement(paramMotionEvent);
    switch (paramMotionEvent.getActionMasked())
    {
    }
    for (;;)
    {
      bool1 = super.onTouchEvent(paramMotionEvent);
      float f1;
      int i;
      label474:
      label486:
      for (;;)
      {
        return bool1;
        f1 = paramMotionEvent.getX();
        float f2 = paramMotionEvent.getY();
        if (!isEnabled()) {
          break;
        }
        i = j;
        if (this.ali != null)
        {
          i = getThumbOffset();
          this.ali.getPadding(this.ec);
          int k = this.alI;
          int m = this.jb;
          int n = i + this.alH - this.jb;
          int i1 = this.alG;
          int i2 = this.ec.left;
          int i3 = this.ec.right;
          int i4 = this.jb;
          int i5 = this.alK;
          int i6 = this.jb;
          i = j;
          if (f1 > n)
          {
            i = j;
            if (f1 < i1 + n + i2 + i3 + i4)
            {
              i = j;
              if (f2 > k - m)
              {
                i = j;
                if (f2 < i5 + i6) {
                  i = 1;
                }
              }
            }
          }
        }
        if (i == 0) {
          break;
        }
        this.alA = 1;
        this.alB = f1;
        this.alC = f2;
        break;
        switch (this.alA)
        {
        case 0: 
        default: 
          break;
        case 1: 
          f1 = paramMotionEvent.getX();
          f2 = paramMotionEvent.getY();
          if ((Math.abs(f1 - this.alB) <= this.jb) && (Math.abs(f2 - this.alC) <= this.jb)) {
            break;
          }
          this.alA = 2;
          getParent().requestDisallowInterceptTouchEvent(true);
          this.alB = f1;
          this.alC = f2;
          return true;
        case 2: 
          float f4 = paramMotionEvent.getX();
          i = getThumbScrollRange();
          f1 = f4 - this.alB;
          if (i != 0)
          {
            f1 /= i;
            f2 = f1;
            if (bf.bF(this)) {
              f2 = -f1;
            }
            f2 += this.alD;
            if (f2 >= 0.0F) {
              break label474;
            }
            f1 = 0.0F;
          }
          for (;;)
          {
            if (f1 == this.alD) {
              break label486;
            }
            this.alB = f4;
            setThumbPosition(f1);
            return true;
            if (f1 > 0.0F)
            {
              f1 = 1.0F;
              break;
            }
            f1 = -1.0F;
            break;
            f1 = f3;
            if (f2 <= 1.0F) {
              f1 = f2;
            }
          }
        }
      }
      if (this.alA == 2)
      {
        this.alA = 0;
        boolean bool2;
        if ((paramMotionEvent.getAction() == 1) && (isEnabled()))
        {
          i = 1;
          bool2 = isChecked();
          if (i == 0) {
            break label666;
          }
          this.fB.computeCurrentVelocity(1000);
          f1 = this.fB.getXVelocity();
          if (Math.abs(f1) <= this.agm) {
            break label657;
          }
          if (!bf.bF(this)) {
            break label639;
          }
          if (f1 >= 0.0F) {
            break label633;
          }
          bool1 = true;
        }
        label657:
        label666:
        for (;;)
        {
          if (bool1 != bool2) {
            playSoundEffect(0);
          }
          setChecked(bool1);
          MotionEvent localMotionEvent = MotionEvent.obtain(paramMotionEvent);
          localMotionEvent.setAction(3);
          super.onTouchEvent(localMotionEvent);
          localMotionEvent.recycle();
          super.onTouchEvent(paramMotionEvent);
          return true;
          i = 0;
          break;
          label633:
          bool1 = false;
          continue;
          label639:
          if (f1 > 0.0F)
          {
            bool1 = true;
          }
          else
          {
            bool1 = false;
            continue;
            bool1 = getTargetCheckedState();
            continue;
            bool1 = bool2;
          }
        }
      }
      this.alA = 0;
      this.fB.clear();
    }
  }
  
  public void setChecked(boolean paramBoolean)
  {
    float f = 1.0F;
    super.setChecked(paramBoolean);
    paramBoolean = isChecked();
    if ((getWindowToken() != null) && (q.al(this)))
    {
      if (paramBoolean) {}
      for (;;)
      {
        this.alP = ObjectAnimator.ofFloat(this, alh, new float[] { f });
        this.alP.setDuration(250L);
        if (Build.VERSION.SDK_INT >= 18) {
          this.alP.setAutoCancel(true);
        }
        this.alP.start();
        return;
        f = 0.0F;
      }
    }
    if (this.alP != null) {
      this.alP.cancel();
    }
    if (paramBoolean) {}
    for (;;)
    {
      setThumbPosition(f);
      return;
      f = 0.0F;
    }
  }
  
  public void setShowText(boolean paramBoolean)
  {
    if (this.alz != paramBoolean)
    {
      this.alz = paramBoolean;
      requestLayout();
    }
  }
  
  public void setSplitTrack(boolean paramBoolean)
  {
    this.alw = paramBoolean;
    invalidate();
  }
  
  public void setSwitchMinWidth(int paramInt)
  {
    this.alu = paramInt;
    requestLayout();
  }
  
  public void setSwitchPadding(int paramInt)
  {
    this.alv = paramInt;
    requestLayout();
  }
  
  public void setSwitchTypeface(Typeface paramTypeface)
  {
    if (((this.gI.getTypeface() != null) && (!this.gI.getTypeface().equals(paramTypeface))) || ((this.gI.getTypeface() == null) && (paramTypeface != null)))
    {
      this.gI.setTypeface(paramTypeface);
      requestLayout();
      invalidate();
    }
  }
  
  public void setTextOff(CharSequence paramCharSequence)
  {
    this.aly = paramCharSequence;
    requestLayout();
  }
  
  public void setTextOn(CharSequence paramCharSequence)
  {
    this.alx = paramCharSequence;
    requestLayout();
  }
  
  public void setThumbDrawable(Drawable paramDrawable)
  {
    if (this.ali != null) {
      this.ali.setCallback(null);
    }
    this.ali = paramDrawable;
    if (paramDrawable != null) {
      paramDrawable.setCallback(this);
    }
    requestLayout();
  }
  
  void setThumbPosition(float paramFloat)
  {
    this.alD = paramFloat;
    invalidate();
  }
  
  public void setThumbResource(int paramInt)
  {
    setThumbDrawable(b.g(getContext(), paramInt));
  }
  
  public void setThumbTextPadding(int paramInt)
  {
    this.alt = paramInt;
    requestLayout();
  }
  
  public void setThumbTintList(ColorStateList paramColorStateList)
  {
    this.alj = paramColorStateList;
    this.alm = true;
    iU();
  }
  
  public void setThumbTintMode(PorterDuff.Mode paramMode)
  {
    this.alk = paramMode;
    this.aln = true;
    iU();
  }
  
  public void setTrackDrawable(Drawable paramDrawable)
  {
    if (this.alo != null) {
      this.alo.setCallback(null);
    }
    this.alo = paramDrawable;
    if (paramDrawable != null) {
      paramDrawable.setCallback(this);
    }
    requestLayout();
  }
  
  public void setTrackResource(int paramInt)
  {
    setTrackDrawable(b.g(getContext(), paramInt));
  }
  
  public void setTrackTintList(ColorStateList paramColorStateList)
  {
    this.alp = paramColorStateList;
    this.alr = true;
    iT();
  }
  
  public void setTrackTintMode(PorterDuff.Mode paramMode)
  {
    this.alq = paramMode;
    this.als = true;
    iT();
  }
  
  public void toggle()
  {
    if (!isChecked()) {}
    for (boolean bool = true;; bool = false)
    {
      setChecked(bool);
      return;
    }
  }
  
  protected boolean verifyDrawable(Drawable paramDrawable)
  {
    return (super.verifyDrawable(paramDrawable)) || (paramDrawable == this.ali) || (paramDrawable == this.alo);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     android.support.v7.widget.SwitchCompat
 * JD-Core Version:    0.7.0.1
 */