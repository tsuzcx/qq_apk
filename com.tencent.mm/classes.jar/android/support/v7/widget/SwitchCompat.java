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
import android.support.v4.view.u;
import android.support.v4.widget.q;
import android.support.v7.a.a.a;
import android.text.Layout;
import android.text.Layout.Alignment;
import android.text.StaticLayout;
import android.text.TextPaint;
import android.text.TextUtils;
import android.text.method.TransformationMethod;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.util.Property;
import android.view.ActionMode.Callback;
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
  private static final Property<SwitchCompat, Float> axK = new Property(Float.class, "thumbPos") {};
  private static final int[] jV = { 16842912 };
  private int asJ;
  private Drawable axL;
  private ColorStateList axM = null;
  private PorterDuff.Mode axN = null;
  private boolean axO = false;
  private boolean axP = false;
  private Drawable axQ;
  private ColorStateList axR = null;
  private PorterDuff.Mode axS = null;
  private boolean axT = false;
  private boolean axU = false;
  private int axV;
  private int axW;
  private int axX;
  private boolean axY;
  private CharSequence axZ;
  private CharSequence aya;
  private boolean ayb;
  private int ayc;
  private float ayd;
  private float aye;
  float ayf;
  private int ayg;
  private int ayh;
  private int ayi;
  private int ayj;
  private int ayk;
  private int ayl;
  private int aym;
  private final TextPaint ayn = new TextPaint(1);
  private ColorStateList ayo;
  private Layout ayp;
  private Layout ayq;
  private TransformationMethod ayr;
  ObjectAnimator ays;
  private final Rect mTempRect = new Rect();
  private int mTouchSlop;
  private VelocityTracker mVelocityTracker = VelocityTracker.obtain();
  
  public SwitchCompat(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 2130969585);
  }
  
  public SwitchCompat(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    Object localObject = getResources();
    this.ayn.density = ((Resources)localObject).getDisplayMetrics().density;
    localObject = az.a(paramContext, paramAttributeSet, a.a.SwitchCompat, paramInt, 0);
    this.axL = ((az)localObject).getDrawable(2);
    if (this.axL != null) {
      this.axL.setCallback(this);
    }
    this.axQ = ((az)localObject).getDrawable(11);
    if (this.axQ != null) {
      this.axQ.setCallback(this);
    }
    this.axZ = ((az)localObject).getText(0);
    this.aya = ((az)localObject).getText(1);
    this.ayb = ((az)localObject).getBoolean(3, true);
    this.axV = ((az)localObject).getDimensionPixelSize(8, 0);
    this.axW = ((az)localObject).getDimensionPixelSize(5, 0);
    this.axX = ((az)localObject).getDimensionPixelSize(6, 0);
    this.axY = ((az)localObject).getBoolean(4, false);
    paramAttributeSet = ((az)localObject).getColorStateList(9);
    if (paramAttributeSet != null)
    {
      this.axM = paramAttributeSet;
      this.axO = true;
    }
    paramAttributeSet = x.a(((az)localObject).getInt(10, -1), null);
    if (this.axN != paramAttributeSet)
    {
      this.axN = paramAttributeSet;
      this.axP = true;
    }
    if ((this.axO) || (this.axP)) {
      mU();
    }
    paramAttributeSet = ((az)localObject).getColorStateList(12);
    if (paramAttributeSet != null)
    {
      this.axR = paramAttributeSet;
      this.axT = true;
    }
    paramAttributeSet = x.a(((az)localObject).getInt(13, -1), null);
    if (this.axS != paramAttributeSet)
    {
      this.axS = paramAttributeSet;
      this.axU = true;
    }
    if ((this.axT) || (this.axU)) {
      mT();
    }
    paramInt = ((az)localObject).getResourceId(7, 0);
    az localaz;
    int i;
    label502:
    boolean bool;
    label517:
    label531:
    label552:
    float f;
    if (paramInt != 0)
    {
      localaz = az.a(paramContext, paramInt, a.a.TextAppearance);
      paramAttributeSet = localaz.getColorStateList(3);
      if (paramAttributeSet == null) {
        break label655;
      }
      this.ayo = paramAttributeSet;
      paramInt = localaz.getDimensionPixelSize(0, 0);
      if ((paramInt != 0) && (paramInt != this.ayn.getTextSize()))
      {
        this.ayn.setTextSize(paramInt);
        requestLayout();
      }
      paramInt = localaz.getInt(1, -1);
      i = localaz.getInt(2, -1);
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
              break label697;
            }
            paramInt = paramAttributeSet.getStyle();
            paramInt = i & (paramInt ^ 0xFFFFFFFF);
            paramAttributeSet = this.ayn;
            if ((paramInt & 0x1) == 0) {
              break label702;
            }
            bool = true;
            paramAttributeSet.setFakeBoldText(bool);
            paramAttributeSet = this.ayn;
            if ((paramInt & 0x2) == 0) {
              break label708;
            }
            f = -0.25F;
            label573:
            paramAttributeSet.setTextSkewX(f);
            label579:
            if (!localaz.getBoolean(12, false)) {
              break label738;
            }
          }
        }
        break;
      }
    }
    label655:
    label697:
    label702:
    label708:
    label738:
    for (this.ayr = new android.support.v7.g.a(getContext());; this.ayr = null)
    {
      localaz.ayy.recycle();
      ((az)localObject).ayy.recycle();
      paramContext = ViewConfiguration.get(paramContext);
      this.mTouchSlop = paramContext.getScaledTouchSlop();
      this.asJ = paramContext.getScaledMinimumFlingVelocity();
      refreshDrawableState();
      setChecked(isChecked());
      return;
      this.ayo = getTextColors();
      break;
      paramAttributeSet = Typeface.SANS_SERIF;
      break label502;
      paramAttributeSet = Typeface.SERIF;
      break label502;
      paramAttributeSet = Typeface.MONOSPACE;
      break label502;
      paramAttributeSet = Typeface.create(paramAttributeSet, i);
      break label517;
      paramInt = 0;
      break label531;
      bool = false;
      break label552;
      f = 0.0F;
      break label573;
      this.ayn.setFakeBoldText(false);
      this.ayn.setTextSkewX(0.0F);
      setSwitchTypeface(paramAttributeSet);
      break label579;
    }
  }
  
  private boolean getTargetCheckedState()
  {
    return this.ayf > 0.5F;
  }
  
  private int getThumbOffset()
  {
    if (bh.d(this)) {}
    for (float f = 1.0F - this.ayf;; f = this.ayf) {
      return (int)(f * getThumbScrollRange() + 0.5F);
    }
  }
  
  private int getThumbScrollRange()
  {
    if (this.axQ != null)
    {
      Rect localRect2 = this.mTempRect;
      this.axQ.getPadding(localRect2);
      if (this.axL != null) {}
      for (Rect localRect1 = x.r(this.axL);; localRect1 = x.amQ) {
        return this.ayg - this.ayi - localRect2.left - localRect2.right - localRect1.left - localRect1.right;
      }
    }
    return 0;
  }
  
  private void mT()
  {
    if ((this.axQ != null) && ((this.axT) || (this.axU)))
    {
      this.axQ = this.axQ.mutate();
      if (this.axT) {
        android.support.v4.graphics.drawable.a.a(this.axQ, this.axR);
      }
      if (this.axU) {
        android.support.v4.graphics.drawable.a.a(this.axQ, this.axS);
      }
      if (this.axQ.isStateful()) {
        this.axQ.setState(getDrawableState());
      }
    }
  }
  
  private void mU()
  {
    if ((this.axL != null) && ((this.axO) || (this.axP)))
    {
      this.axL = this.axL.mutate();
      if (this.axO) {
        android.support.v4.graphics.drawable.a.a(this.axL, this.axM);
      }
      if (this.axP) {
        android.support.v4.graphics.drawable.a.a(this.axL, this.axN);
      }
      if (this.axL.isStateful()) {
        this.axL.setState(getDrawableState());
      }
    }
  }
  
  private Layout q(CharSequence paramCharSequence)
  {
    TextPaint localTextPaint;
    if (this.ayr != null)
    {
      paramCharSequence = this.ayr.getTransformation(paramCharSequence, this);
      localTextPaint = this.ayn;
      if (paramCharSequence == null) {
        break label62;
      }
    }
    label62:
    for (int i = (int)Math.ceil(Layout.getDesiredWidth(paramCharSequence, this.ayn));; i = 0)
    {
      return new StaticLayout(paramCharSequence, localTextPaint, i, Layout.Alignment.ALIGN_NORMAL, 1.0F, 0.0F, true);
      break;
    }
  }
  
  public void draw(Canvas paramCanvas)
  {
    Rect localRect = this.mTempRect;
    int j = this.ayj;
    int n = this.ayk;
    int i2 = this.ayl;
    int i1 = this.aym;
    int i3 = j + getThumbOffset();
    Object localObject;
    int i4;
    label139:
    int m;
    int k;
    if (this.axL != null)
    {
      localObject = x.r(this.axL);
      if (this.axQ == null) {
        break label340;
      }
      this.axQ.getPadding(localRect);
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
      this.axQ.setBounds(i, j, m, k);
    }
    label307:
    label314:
    label320:
    label340:
    for (int i = i4 + i3;; i = i3)
    {
      if (this.axL != null)
      {
        this.axL.getPadding(localRect);
        j = i - localRect.left;
        i = i + this.ayi + localRect.right;
        this.axL.setBounds(j, n, i, i1);
        localObject = getBackground();
        if (localObject != null) {
          android.support.v4.graphics.drawable.a.a((Drawable)localObject, j, n, i, i1);
        }
      }
      super.draw(paramCanvas);
      return;
      localObject = x.amQ;
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
    if (this.axL != null) {
      android.support.v4.graphics.drawable.a.a(this.axL, paramFloat1, paramFloat2);
    }
    if (this.axQ != null) {
      android.support.v4.graphics.drawable.a.a(this.axQ, paramFloat1, paramFloat2);
    }
  }
  
  protected void drawableStateChanged()
  {
    super.drawableStateChanged();
    int[] arrayOfInt = getDrawableState();
    boolean bool2 = false;
    Drawable localDrawable = this.axL;
    boolean bool1 = bool2;
    if (localDrawable != null)
    {
      bool1 = bool2;
      if (localDrawable.isStateful()) {
        bool1 = localDrawable.setState(arrayOfInt) | false;
      }
    }
    localDrawable = this.axQ;
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
    if (!bh.d(this)) {
      i = super.getCompoundPaddingLeft();
    }
    int j;
    do
    {
      return i;
      j = super.getCompoundPaddingLeft() + this.ayg;
      i = j;
    } while (TextUtils.isEmpty(getText()));
    return j + this.axX;
  }
  
  public int getCompoundPaddingRight()
  {
    int i;
    if (bh.d(this)) {
      i = super.getCompoundPaddingRight();
    }
    int j;
    do
    {
      return i;
      j = super.getCompoundPaddingRight() + this.ayg;
      i = j;
    } while (TextUtils.isEmpty(getText()));
    return j + this.axX;
  }
  
  public boolean getShowText()
  {
    return this.ayb;
  }
  
  public boolean getSplitTrack()
  {
    return this.axY;
  }
  
  public int getSwitchMinWidth()
  {
    return this.axW;
  }
  
  public int getSwitchPadding()
  {
    return this.axX;
  }
  
  public CharSequence getTextOff()
  {
    return this.aya;
  }
  
  public CharSequence getTextOn()
  {
    return this.axZ;
  }
  
  public Drawable getThumbDrawable()
  {
    return this.axL;
  }
  
  public int getThumbTextPadding()
  {
    return this.axV;
  }
  
  public ColorStateList getThumbTintList()
  {
    return this.axM;
  }
  
  public PorterDuff.Mode getThumbTintMode()
  {
    return this.axN;
  }
  
  public Drawable getTrackDrawable()
  {
    return this.axQ;
  }
  
  public ColorStateList getTrackTintList()
  {
    return this.axR;
  }
  
  public PorterDuff.Mode getTrackTintMode()
  {
    return this.axS;
  }
  
  public void jumpDrawablesToCurrentState()
  {
    super.jumpDrawablesToCurrentState();
    if (this.axL != null) {
      this.axL.jumpToCurrentState();
    }
    if (this.axQ != null) {
      this.axQ.jumpToCurrentState();
    }
    if ((this.ays != null) && (this.ays.isStarted()))
    {
      this.ays.end();
      this.ays = null;
    }
  }
  
  protected int[] onCreateDrawableState(int paramInt)
  {
    int[] arrayOfInt = super.onCreateDrawableState(paramInt + 1);
    if (isChecked()) {
      mergeDrawableStates(arrayOfInt, jV);
    }
    return arrayOfInt;
  }
  
  protected void onDraw(Canvas paramCanvas)
  {
    super.onDraw(paramCanvas);
    Object localObject1 = this.mTempRect;
    Object localObject3 = this.axQ;
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
      k = this.ayk;
      m = this.aym;
      n = ((Rect)localObject1).top;
      i1 = ((Rect)localObject1).bottom;
      localObject2 = this.axL;
      if (localObject3 != null)
      {
        if ((!this.axY) || (localObject2 == null)) {
          break label322;
        }
        Rect localRect = x.r((Drawable)localObject2);
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
      localObject1 = this.ayp;
      label180:
      if (localObject1 != null)
      {
        localObject3 = getDrawableState();
        if (this.ayo != null) {
          this.ayn.setColor(this.ayo.getColorForState((int[])localObject3, 0));
        }
        this.ayn.drawableState = ((int[])localObject3);
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
      localObject1 = this.ayq;
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
    for (CharSequence localCharSequence1 = this.axZ;; localCharSequence1 = this.aya)
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
    if (this.axL != null)
    {
      localRect1 = this.mTempRect;
      if (this.axQ != null)
      {
        this.axQ.getPadding(localRect1);
        Rect localRect2 = x.r(this.axL);
        paramInt2 = Math.max(0, localRect2.left - localRect1.left);
        paramInt1 = Math.max(0, localRect2.right - localRect1.right);
      }
    }
    for (;;)
    {
      if (bh.d(this))
      {
        paramInt3 = getPaddingLeft() + paramInt2;
        paramInt4 = this.ayg + paramInt3 - paramInt2 - paramInt1;
        label110:
        switch (getGravity() & 0x70)
        {
        default: 
          paramInt2 = getPaddingTop();
          paramInt1 = this.ayh + paramInt2;
        }
      }
      for (;;)
      {
        this.ayj = paramInt3;
        this.ayk = paramInt2;
        this.aym = paramInt1;
        this.ayl = paramInt4;
        return;
        localRect1.setEmpty();
        break;
        paramInt4 = getWidth() - getPaddingRight() - paramInt1;
        paramInt3 = paramInt1 + (paramInt2 + (paramInt4 - this.ayg));
        break label110;
        paramInt2 = (getPaddingTop() + getHeight() - getPaddingBottom()) / 2 - this.ayh / 2;
        paramInt1 = this.ayh + paramInt2;
        continue;
        paramInt1 = getHeight() - getPaddingBottom();
        paramInt2 = paramInt1 - this.ayh;
      }
      paramInt1 = 0;
      paramInt2 = 0;
    }
  }
  
  public void onMeasure(int paramInt1, int paramInt2)
  {
    int m = 0;
    if (this.ayb)
    {
      if (this.ayp == null) {
        this.ayp = q(this.axZ);
      }
      if (this.ayq == null) {
        this.ayq = q(this.aya);
      }
    }
    Rect localRect = this.mTempRect;
    int i;
    int k;
    if (this.axL != null)
    {
      this.axL.getPadding(localRect);
      j = this.axL.getIntrinsicWidth() - localRect.left - localRect.right;
      i = this.axL.getIntrinsicHeight();
      if (!this.ayb) {
        break label303;
      }
      k = Math.max(this.ayp.getWidth(), this.ayq.getWidth()) + this.axV * 2;
      label133:
      this.ayi = Math.max(k, j);
      if (this.axQ == null) {
        break label309;
      }
      this.axQ.getPadding(localRect);
    }
    for (int j = this.axQ.getIntrinsicHeight();; j = m)
    {
      int i1 = localRect.left;
      int n = localRect.right;
      m = i1;
      k = n;
      if (this.axL != null)
      {
        localRect = x.r(this.axL);
        m = Math.max(i1, localRect.left);
        k = Math.max(n, localRect.right);
      }
      k = Math.max(this.axW, m + this.ayi * 2 + k);
      i = Math.max(j, i);
      this.ayg = k;
      this.ayh = i;
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
    for (CharSequence localCharSequence = this.axZ;; localCharSequence = this.aya)
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
    this.mVelocityTracker.addMovement(paramMotionEvent);
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
        if (this.axL != null)
        {
          i = getThumbOffset();
          this.axL.getPadding(this.mTempRect);
          int k = this.ayk;
          int m = this.mTouchSlop;
          int n = i + this.ayj - this.mTouchSlop;
          int i1 = this.ayi;
          int i2 = this.mTempRect.left;
          int i3 = this.mTempRect.right;
          int i4 = this.mTouchSlop;
          int i5 = this.aym;
          int i6 = this.mTouchSlop;
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
        this.ayc = 1;
        this.ayd = f1;
        this.aye = f2;
        break;
        switch (this.ayc)
        {
        case 0: 
        default: 
          break;
        case 1: 
          f1 = paramMotionEvent.getX();
          f2 = paramMotionEvent.getY();
          if ((Math.abs(f1 - this.ayd) <= this.mTouchSlop) && (Math.abs(f2 - this.aye) <= this.mTouchSlop)) {
            break;
          }
          this.ayc = 2;
          getParent().requestDisallowInterceptTouchEvent(true);
          this.ayd = f1;
          this.aye = f2;
          return true;
        case 2: 
          float f4 = paramMotionEvent.getX();
          i = getThumbScrollRange();
          f1 = f4 - this.ayd;
          if (i != 0)
          {
            f1 /= i;
            f2 = f1;
            if (bh.d(this)) {
              f2 = -f1;
            }
            f2 += this.ayf;
            if (f2 >= 0.0F) {
              break label474;
            }
            f1 = 0.0F;
          }
          for (;;)
          {
            if (f1 == this.ayf) {
              break label486;
            }
            this.ayd = f4;
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
      if (this.ayc == 2)
      {
        this.ayc = 0;
        boolean bool2;
        if ((paramMotionEvent.getAction() == 1) && (isEnabled()))
        {
          i = 1;
          bool2 = isChecked();
          if (i == 0) {
            break label666;
          }
          this.mVelocityTracker.computeCurrentVelocity(1000);
          f1 = this.mVelocityTracker.getXVelocity();
          if (Math.abs(f1) <= this.asJ) {
            break label657;
          }
          if (!bh.d(this)) {
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
      this.ayc = 0;
      this.mVelocityTracker.clear();
    }
  }
  
  public void setChecked(boolean paramBoolean)
  {
    float f = 1.0F;
    super.setChecked(paramBoolean);
    paramBoolean = isChecked();
    if ((getWindowToken() != null) && (u.az(this)))
    {
      if (paramBoolean) {}
      for (;;)
      {
        this.ays = ObjectAnimator.ofFloat(this, axK, new float[] { f });
        this.ays.setDuration(250L);
        if (Build.VERSION.SDK_INT >= 18) {
          this.ays.setAutoCancel(true);
        }
        this.ays.start();
        return;
        f = 0.0F;
      }
    }
    if (this.ays != null) {
      this.ays.cancel();
    }
    if (paramBoolean) {}
    for (;;)
    {
      setThumbPosition(f);
      return;
      f = 0.0F;
    }
  }
  
  public void setCustomSelectionActionModeCallback(ActionMode.Callback paramCallback)
  {
    super.setCustomSelectionActionModeCallback(q.a(this, paramCallback));
  }
  
  public void setShowText(boolean paramBoolean)
  {
    if (this.ayb != paramBoolean)
    {
      this.ayb = paramBoolean;
      requestLayout();
    }
  }
  
  public void setSplitTrack(boolean paramBoolean)
  {
    this.axY = paramBoolean;
    invalidate();
  }
  
  public void setSwitchMinWidth(int paramInt)
  {
    this.axW = paramInt;
    requestLayout();
  }
  
  public void setSwitchPadding(int paramInt)
  {
    this.axX = paramInt;
    requestLayout();
  }
  
  public void setSwitchTypeface(Typeface paramTypeface)
  {
    if (((this.ayn.getTypeface() != null) && (!this.ayn.getTypeface().equals(paramTypeface))) || ((this.ayn.getTypeface() == null) && (paramTypeface != null)))
    {
      this.ayn.setTypeface(paramTypeface);
      requestLayout();
      invalidate();
    }
  }
  
  public void setTextOff(CharSequence paramCharSequence)
  {
    this.aya = paramCharSequence;
    requestLayout();
  }
  
  public void setTextOn(CharSequence paramCharSequence)
  {
    this.axZ = paramCharSequence;
    requestLayout();
  }
  
  public void setThumbDrawable(Drawable paramDrawable)
  {
    if (this.axL != null) {
      this.axL.setCallback(null);
    }
    this.axL = paramDrawable;
    if (paramDrawable != null) {
      paramDrawable.setCallback(this);
    }
    requestLayout();
  }
  
  void setThumbPosition(float paramFloat)
  {
    this.ayf = paramFloat;
    invalidate();
  }
  
  public void setThumbResource(int paramInt)
  {
    setThumbDrawable(android.support.v7.c.a.a.l(getContext(), paramInt));
  }
  
  public void setThumbTextPadding(int paramInt)
  {
    this.axV = paramInt;
    requestLayout();
  }
  
  public void setThumbTintList(ColorStateList paramColorStateList)
  {
    this.axM = paramColorStateList;
    this.axO = true;
    mU();
  }
  
  public void setThumbTintMode(PorterDuff.Mode paramMode)
  {
    this.axN = paramMode;
    this.axP = true;
    mU();
  }
  
  public void setTrackDrawable(Drawable paramDrawable)
  {
    if (this.axQ != null) {
      this.axQ.setCallback(null);
    }
    this.axQ = paramDrawable;
    if (paramDrawable != null) {
      paramDrawable.setCallback(this);
    }
    requestLayout();
  }
  
  public void setTrackResource(int paramInt)
  {
    setTrackDrawable(android.support.v7.c.a.a.l(getContext(), paramInt));
  }
  
  public void setTrackTintList(ColorStateList paramColorStateList)
  {
    this.axR = paramColorStateList;
    this.axT = true;
    mT();
  }
  
  public void setTrackTintMode(PorterDuff.Mode paramMode)
  {
    this.axS = paramMode;
    this.axU = true;
    mT();
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
    return (super.verifyDrawable(paramDrawable)) || (paramDrawable == this.axL) || (paramDrawable == this.axQ);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     android.support.v7.widget.SwitchCompat
 * JD-Core Version:    0.7.0.1
 */