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
import android.support.v4.view.t;
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
  private static final Property<SwitchCompat, Float> axM = new Property(Float.class, "thumbPos") {};
  private static final int[] jT = { 16842912 };
  private int asy;
  private Drawable axN;
  private ColorStateList axO = null;
  private PorterDuff.Mode axP = null;
  private boolean axQ = false;
  private boolean axR = false;
  private Drawable axS;
  private ColorStateList axT = null;
  private PorterDuff.Mode axU = null;
  private boolean axV = false;
  private boolean axW = false;
  private int axX;
  private int axY;
  private int axZ;
  private boolean aya;
  private CharSequence ayb;
  private CharSequence ayc;
  private boolean ayd;
  private int aye;
  private float ayf;
  private float ayg;
  float ayh;
  private int ayi;
  private int ayj;
  private int ayk;
  private int ayl;
  private int aym;
  private int ayn;
  private int ayo;
  private final TextPaint ayp = new TextPaint(1);
  private ColorStateList ayq;
  private Layout ayr;
  private Layout ays;
  private TransformationMethod ayt;
  ObjectAnimator ayu;
  private final Rect mTempRect = new Rect();
  private int mTouchSlop;
  private VelocityTracker mVelocityTracker = VelocityTracker.obtain();
  
  public SwitchCompat(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 2130969500);
  }
  
  public SwitchCompat(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    Object localObject = getResources();
    this.ayp.density = ((Resources)localObject).getDisplayMetrics().density;
    localObject = az.a(paramContext, paramAttributeSet, a.a.SwitchCompat, paramInt, 0);
    this.axN = ((az)localObject).getDrawable(2);
    if (this.axN != null) {
      this.axN.setCallback(this);
    }
    this.axS = ((az)localObject).getDrawable(11);
    if (this.axS != null) {
      this.axS.setCallback(this);
    }
    this.ayb = ((az)localObject).getText(0);
    this.ayc = ((az)localObject).getText(1);
    this.ayd = ((az)localObject).getBoolean(3, true);
    this.axX = ((az)localObject).getDimensionPixelSize(8, 0);
    this.axY = ((az)localObject).getDimensionPixelSize(5, 0);
    this.axZ = ((az)localObject).getDimensionPixelSize(6, 0);
    this.aya = ((az)localObject).getBoolean(4, false);
    paramAttributeSet = ((az)localObject).getColorStateList(9);
    if (paramAttributeSet != null)
    {
      this.axO = paramAttributeSet;
      this.axQ = true;
    }
    paramAttributeSet = x.a(((az)localObject).getInt(10, -1), null);
    if (this.axP != paramAttributeSet)
    {
      this.axP = paramAttributeSet;
      this.axR = true;
    }
    if ((this.axQ) || (this.axR)) {
      mS();
    }
    paramAttributeSet = ((az)localObject).getColorStateList(12);
    if (paramAttributeSet != null)
    {
      this.axT = paramAttributeSet;
      this.axV = true;
    }
    paramAttributeSet = x.a(((az)localObject).getInt(13, -1), null);
    if (this.axU != paramAttributeSet)
    {
      this.axU = paramAttributeSet;
      this.axW = true;
    }
    if ((this.axV) || (this.axW)) {
      mR();
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
      this.ayq = paramAttributeSet;
      paramInt = localaz.getDimensionPixelSize(0, 0);
      if ((paramInt != 0) && (paramInt != this.ayp.getTextSize()))
      {
        this.ayp.setTextSize(paramInt);
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
            paramAttributeSet = this.ayp;
            if ((paramInt & 0x1) == 0) {
              break label702;
            }
            bool = true;
            paramAttributeSet.setFakeBoldText(bool);
            paramAttributeSet = this.ayp;
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
    for (this.ayt = new android.support.v7.g.a(getContext());; this.ayt = null)
    {
      localaz.ayA.recycle();
      ((az)localObject).ayA.recycle();
      paramContext = ViewConfiguration.get(paramContext);
      this.mTouchSlop = paramContext.getScaledTouchSlop();
      this.asy = paramContext.getScaledMinimumFlingVelocity();
      refreshDrawableState();
      setChecked(isChecked());
      return;
      this.ayq = getTextColors();
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
      this.ayp.setFakeBoldText(false);
      this.ayp.setTextSkewX(0.0F);
      setSwitchTypeface(paramAttributeSet);
      break label579;
    }
  }
  
  private boolean getTargetCheckedState()
  {
    return this.ayh > 0.5F;
  }
  
  private int getThumbOffset()
  {
    if (bh.d(this)) {}
    for (float f = 1.0F - this.ayh;; f = this.ayh) {
      return (int)(f * getThumbScrollRange() + 0.5F);
    }
  }
  
  private int getThumbScrollRange()
  {
    if (this.axS != null)
    {
      Rect localRect2 = this.mTempRect;
      this.axS.getPadding(localRect2);
      if (this.axN != null) {}
      for (Rect localRect1 = x.r(this.axN);; localRect1 = x.amD) {
        return this.ayi - this.ayk - localRect2.left - localRect2.right - localRect1.left - localRect1.right;
      }
    }
    return 0;
  }
  
  private void mR()
  {
    if ((this.axS != null) && ((this.axV) || (this.axW)))
    {
      this.axS = this.axS.mutate();
      if (this.axV) {
        android.support.v4.graphics.drawable.a.a(this.axS, this.axT);
      }
      if (this.axW) {
        android.support.v4.graphics.drawable.a.a(this.axS, this.axU);
      }
      if (this.axS.isStateful()) {
        this.axS.setState(getDrawableState());
      }
    }
  }
  
  private void mS()
  {
    if ((this.axN != null) && ((this.axQ) || (this.axR)))
    {
      this.axN = this.axN.mutate();
      if (this.axQ) {
        android.support.v4.graphics.drawable.a.a(this.axN, this.axO);
      }
      if (this.axR) {
        android.support.v4.graphics.drawable.a.a(this.axN, this.axP);
      }
      if (this.axN.isStateful()) {
        this.axN.setState(getDrawableState());
      }
    }
  }
  
  private Layout q(CharSequence paramCharSequence)
  {
    TextPaint localTextPaint;
    if (this.ayt != null)
    {
      paramCharSequence = this.ayt.getTransformation(paramCharSequence, this);
      localTextPaint = this.ayp;
      if (paramCharSequence == null) {
        break label62;
      }
    }
    label62:
    for (int i = (int)Math.ceil(Layout.getDesiredWidth(paramCharSequence, this.ayp));; i = 0)
    {
      return new StaticLayout(paramCharSequence, localTextPaint, i, Layout.Alignment.ALIGN_NORMAL, 1.0F, 0.0F, true);
      break;
    }
  }
  
  public void draw(Canvas paramCanvas)
  {
    Rect localRect = this.mTempRect;
    int j = this.ayl;
    int n = this.aym;
    int i2 = this.ayn;
    int i1 = this.ayo;
    int i3 = j + getThumbOffset();
    Object localObject;
    int i4;
    label139:
    int m;
    int k;
    if (this.axN != null)
    {
      localObject = x.r(this.axN);
      if (this.axS == null) {
        break label340;
      }
      this.axS.getPadding(localRect);
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
      this.axS.setBounds(i, j, m, k);
    }
    label307:
    label314:
    label320:
    label340:
    for (int i = i4 + i3;; i = i3)
    {
      if (this.axN != null)
      {
        this.axN.getPadding(localRect);
        j = i - localRect.left;
        i = i + this.ayk + localRect.right;
        this.axN.setBounds(j, n, i, i1);
        localObject = getBackground();
        if (localObject != null) {
          android.support.v4.graphics.drawable.a.a((Drawable)localObject, j, n, i, i1);
        }
      }
      super.draw(paramCanvas);
      return;
      localObject = x.amD;
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
    if (this.axN != null) {
      android.support.v4.graphics.drawable.a.a(this.axN, paramFloat1, paramFloat2);
    }
    if (this.axS != null) {
      android.support.v4.graphics.drawable.a.a(this.axS, paramFloat1, paramFloat2);
    }
  }
  
  protected void drawableStateChanged()
  {
    super.drawableStateChanged();
    int[] arrayOfInt = getDrawableState();
    boolean bool2 = false;
    Drawable localDrawable = this.axN;
    boolean bool1 = bool2;
    if (localDrawable != null)
    {
      bool1 = bool2;
      if (localDrawable.isStateful()) {
        bool1 = localDrawable.setState(arrayOfInt) | false;
      }
    }
    localDrawable = this.axS;
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
      j = super.getCompoundPaddingLeft() + this.ayi;
      i = j;
    } while (TextUtils.isEmpty(getText()));
    return j + this.axZ;
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
      j = super.getCompoundPaddingRight() + this.ayi;
      i = j;
    } while (TextUtils.isEmpty(getText()));
    return j + this.axZ;
  }
  
  public boolean getShowText()
  {
    return this.ayd;
  }
  
  public boolean getSplitTrack()
  {
    return this.aya;
  }
  
  public int getSwitchMinWidth()
  {
    return this.axY;
  }
  
  public int getSwitchPadding()
  {
    return this.axZ;
  }
  
  public CharSequence getTextOff()
  {
    return this.ayc;
  }
  
  public CharSequence getTextOn()
  {
    return this.ayb;
  }
  
  public Drawable getThumbDrawable()
  {
    return this.axN;
  }
  
  public int getThumbTextPadding()
  {
    return this.axX;
  }
  
  public ColorStateList getThumbTintList()
  {
    return this.axO;
  }
  
  public PorterDuff.Mode getThumbTintMode()
  {
    return this.axP;
  }
  
  public Drawable getTrackDrawable()
  {
    return this.axS;
  }
  
  public ColorStateList getTrackTintList()
  {
    return this.axT;
  }
  
  public PorterDuff.Mode getTrackTintMode()
  {
    return this.axU;
  }
  
  public void jumpDrawablesToCurrentState()
  {
    super.jumpDrawablesToCurrentState();
    if (this.axN != null) {
      this.axN.jumpToCurrentState();
    }
    if (this.axS != null) {
      this.axS.jumpToCurrentState();
    }
    if ((this.ayu != null) && (this.ayu.isStarted()))
    {
      this.ayu.end();
      this.ayu = null;
    }
  }
  
  protected int[] onCreateDrawableState(int paramInt)
  {
    int[] arrayOfInt = super.onCreateDrawableState(paramInt + 1);
    if (isChecked()) {
      mergeDrawableStates(arrayOfInt, jT);
    }
    return arrayOfInt;
  }
  
  protected void onDraw(Canvas paramCanvas)
  {
    super.onDraw(paramCanvas);
    Object localObject1 = this.mTempRect;
    Object localObject3 = this.axS;
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
      k = this.aym;
      m = this.ayo;
      n = ((Rect)localObject1).top;
      i1 = ((Rect)localObject1).bottom;
      localObject2 = this.axN;
      if (localObject3 != null)
      {
        if ((!this.aya) || (localObject2 == null)) {
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
      localObject1 = this.ayr;
      label180:
      if (localObject1 != null)
      {
        localObject3 = getDrawableState();
        if (this.ayq != null) {
          this.ayp.setColor(this.ayq.getColorForState((int[])localObject3, 0));
        }
        this.ayp.drawableState = ((int[])localObject3);
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
      localObject1 = this.ays;
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
    for (CharSequence localCharSequence1 = this.ayb;; localCharSequence1 = this.ayc)
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
    if (this.axN != null)
    {
      localRect1 = this.mTempRect;
      if (this.axS != null)
      {
        this.axS.getPadding(localRect1);
        Rect localRect2 = x.r(this.axN);
        paramInt2 = Math.max(0, localRect2.left - localRect1.left);
        paramInt1 = Math.max(0, localRect2.right - localRect1.right);
      }
    }
    for (;;)
    {
      if (bh.d(this))
      {
        paramInt3 = getPaddingLeft() + paramInt2;
        paramInt4 = this.ayi + paramInt3 - paramInt2 - paramInt1;
        label110:
        switch (getGravity() & 0x70)
        {
        default: 
          paramInt2 = getPaddingTop();
          paramInt1 = this.ayj + paramInt2;
        }
      }
      for (;;)
      {
        this.ayl = paramInt3;
        this.aym = paramInt2;
        this.ayo = paramInt1;
        this.ayn = paramInt4;
        return;
        localRect1.setEmpty();
        break;
        paramInt4 = getWidth() - getPaddingRight() - paramInt1;
        paramInt3 = paramInt1 + (paramInt2 + (paramInt4 - this.ayi));
        break label110;
        paramInt2 = (getPaddingTop() + getHeight() - getPaddingBottom()) / 2 - this.ayj / 2;
        paramInt1 = this.ayj + paramInt2;
        continue;
        paramInt1 = getHeight() - getPaddingBottom();
        paramInt2 = paramInt1 - this.ayj;
      }
      paramInt1 = 0;
      paramInt2 = 0;
    }
  }
  
  public void onMeasure(int paramInt1, int paramInt2)
  {
    int m = 0;
    if (this.ayd)
    {
      if (this.ayr == null) {
        this.ayr = q(this.ayb);
      }
      if (this.ays == null) {
        this.ays = q(this.ayc);
      }
    }
    Rect localRect = this.mTempRect;
    int i;
    int k;
    if (this.axN != null)
    {
      this.axN.getPadding(localRect);
      j = this.axN.getIntrinsicWidth() - localRect.left - localRect.right;
      i = this.axN.getIntrinsicHeight();
      if (!this.ayd) {
        break label303;
      }
      k = Math.max(this.ayr.getWidth(), this.ays.getWidth()) + this.axX * 2;
      label133:
      this.ayk = Math.max(k, j);
      if (this.axS == null) {
        break label309;
      }
      this.axS.getPadding(localRect);
    }
    for (int j = this.axS.getIntrinsicHeight();; j = m)
    {
      int i1 = localRect.left;
      int n = localRect.right;
      m = i1;
      k = n;
      if (this.axN != null)
      {
        localRect = x.r(this.axN);
        m = Math.max(i1, localRect.left);
        k = Math.max(n, localRect.right);
      }
      k = Math.max(this.axY, m + this.ayk * 2 + k);
      i = Math.max(j, i);
      this.ayi = k;
      this.ayj = i;
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
    for (CharSequence localCharSequence = this.ayb;; localCharSequence = this.ayc)
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
        if (this.axN != null)
        {
          i = getThumbOffset();
          this.axN.getPadding(this.mTempRect);
          int k = this.aym;
          int m = this.mTouchSlop;
          int n = i + this.ayl - this.mTouchSlop;
          int i1 = this.ayk;
          int i2 = this.mTempRect.left;
          int i3 = this.mTempRect.right;
          int i4 = this.mTouchSlop;
          int i5 = this.ayo;
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
        this.aye = 1;
        this.ayf = f1;
        this.ayg = f2;
        break;
        switch (this.aye)
        {
        case 0: 
        default: 
          break;
        case 1: 
          f1 = paramMotionEvent.getX();
          f2 = paramMotionEvent.getY();
          if ((Math.abs(f1 - this.ayf) <= this.mTouchSlop) && (Math.abs(f2 - this.ayg) <= this.mTouchSlop)) {
            break;
          }
          this.aye = 2;
          getParent().requestDisallowInterceptTouchEvent(true);
          this.ayf = f1;
          this.ayg = f2;
          return true;
        case 2: 
          float f4 = paramMotionEvent.getX();
          i = getThumbScrollRange();
          f1 = f4 - this.ayf;
          if (i != 0)
          {
            f1 /= i;
            f2 = f1;
            if (bh.d(this)) {
              f2 = -f1;
            }
            f2 += this.ayh;
            if (f2 >= 0.0F) {
              break label474;
            }
            f1 = 0.0F;
          }
          for (;;)
          {
            if (f1 == this.ayh) {
              break label486;
            }
            this.ayf = f4;
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
      if (this.aye == 2)
      {
        this.aye = 0;
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
          if (Math.abs(f1) <= this.asy) {
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
      this.aye = 0;
      this.mVelocityTracker.clear();
    }
  }
  
  public void setChecked(boolean paramBoolean)
  {
    float f = 1.0F;
    super.setChecked(paramBoolean);
    paramBoolean = isChecked();
    if ((getWindowToken() != null) && (t.ay(this)))
    {
      if (paramBoolean) {}
      for (;;)
      {
        this.ayu = ObjectAnimator.ofFloat(this, axM, new float[] { f });
        this.ayu.setDuration(250L);
        if (Build.VERSION.SDK_INT >= 18) {
          this.ayu.setAutoCancel(true);
        }
        this.ayu.start();
        return;
        f = 0.0F;
      }
    }
    if (this.ayu != null) {
      this.ayu.cancel();
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
    if (this.ayd != paramBoolean)
    {
      this.ayd = paramBoolean;
      requestLayout();
    }
  }
  
  public void setSplitTrack(boolean paramBoolean)
  {
    this.aya = paramBoolean;
    invalidate();
  }
  
  public void setSwitchMinWidth(int paramInt)
  {
    this.axY = paramInt;
    requestLayout();
  }
  
  public void setSwitchPadding(int paramInt)
  {
    this.axZ = paramInt;
    requestLayout();
  }
  
  public void setSwitchTypeface(Typeface paramTypeface)
  {
    if (((this.ayp.getTypeface() != null) && (!this.ayp.getTypeface().equals(paramTypeface))) || ((this.ayp.getTypeface() == null) && (paramTypeface != null)))
    {
      this.ayp.setTypeface(paramTypeface);
      requestLayout();
      invalidate();
    }
  }
  
  public void setTextOff(CharSequence paramCharSequence)
  {
    this.ayc = paramCharSequence;
    requestLayout();
  }
  
  public void setTextOn(CharSequence paramCharSequence)
  {
    this.ayb = paramCharSequence;
    requestLayout();
  }
  
  public void setThumbDrawable(Drawable paramDrawable)
  {
    if (this.axN != null) {
      this.axN.setCallback(null);
    }
    this.axN = paramDrawable;
    if (paramDrawable != null) {
      paramDrawable.setCallback(this);
    }
    requestLayout();
  }
  
  void setThumbPosition(float paramFloat)
  {
    this.ayh = paramFloat;
    invalidate();
  }
  
  public void setThumbResource(int paramInt)
  {
    setThumbDrawable(android.support.v7.c.a.a.l(getContext(), paramInt));
  }
  
  public void setThumbTextPadding(int paramInt)
  {
    this.axX = paramInt;
    requestLayout();
  }
  
  public void setThumbTintList(ColorStateList paramColorStateList)
  {
    this.axO = paramColorStateList;
    this.axQ = true;
    mS();
  }
  
  public void setThumbTintMode(PorterDuff.Mode paramMode)
  {
    this.axP = paramMode;
    this.axR = true;
    mS();
  }
  
  public void setTrackDrawable(Drawable paramDrawable)
  {
    if (this.axS != null) {
      this.axS.setCallback(null);
    }
    this.axS = paramDrawable;
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
    this.axT = paramColorStateList;
    this.axV = true;
    mR();
  }
  
  public void setTrackTintMode(PorterDuff.Mode paramMode)
  {
    this.axU = paramMode;
    this.axW = true;
    mR();
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
    return (super.verifyDrawable(paramDrawable)) || (paramDrawable == this.axN) || (paramDrawable == this.axS);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     android.support.v7.widget.SwitchCompat
 * JD-Core Version:    0.7.0.1
 */