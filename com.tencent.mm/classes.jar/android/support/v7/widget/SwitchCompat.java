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
  private static final Property<SwitchCompat, Float> auZ = new Property(Float.class, "thumbPos") {};
  private static final int[] gZ = { 16842912 };
  private int apL;
  private int avA;
  private int avB;
  private int avC;
  private final TextPaint avD = new TextPaint(1);
  private ColorStateList avE;
  private Layout avF;
  private Layout avG;
  private TransformationMethod avH;
  ObjectAnimator avI;
  private Drawable ava;
  private ColorStateList avb = null;
  private PorterDuff.Mode avc = null;
  private boolean avd = false;
  private boolean ave = false;
  private Drawable avf;
  private ColorStateList avh = null;
  private PorterDuff.Mode avi = null;
  private boolean avj = false;
  private boolean avk = false;
  private int avl;
  private int avm;
  private int avn;
  private boolean avo;
  private CharSequence avp;
  private CharSequence avq;
  private boolean avr;
  private int avs;
  private float avt;
  private float avu;
  float avv;
  private int avw;
  private int avx;
  private int avy;
  private int avz;
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
    this.avD.density = ((Resources)localObject).getDisplayMetrics().density;
    localObject = az.a(paramContext, paramAttributeSet, a.a.SwitchCompat, paramInt, 0);
    this.ava = ((az)localObject).getDrawable(2);
    if (this.ava != null) {
      this.ava.setCallback(this);
    }
    this.avf = ((az)localObject).getDrawable(11);
    if (this.avf != null) {
      this.avf.setCallback(this);
    }
    this.avp = ((az)localObject).getText(0);
    this.avq = ((az)localObject).getText(1);
    this.avr = ((az)localObject).getBoolean(3, true);
    this.avl = ((az)localObject).getDimensionPixelSize(8, 0);
    this.avm = ((az)localObject).getDimensionPixelSize(5, 0);
    this.avn = ((az)localObject).getDimensionPixelSize(6, 0);
    this.avo = ((az)localObject).getBoolean(4, false);
    paramAttributeSet = ((az)localObject).getColorStateList(9);
    if (paramAttributeSet != null)
    {
      this.avb = paramAttributeSet;
      this.avd = true;
    }
    paramAttributeSet = x.a(((az)localObject).getInt(10, -1), null);
    if (this.avc != paramAttributeSet)
    {
      this.avc = paramAttributeSet;
      this.ave = true;
    }
    if ((this.avd) || (this.ave)) {
      mq();
    }
    paramAttributeSet = ((az)localObject).getColorStateList(12);
    if (paramAttributeSet != null)
    {
      this.avh = paramAttributeSet;
      this.avj = true;
    }
    paramAttributeSet = x.a(((az)localObject).getInt(13, -1), null);
    if (this.avi != paramAttributeSet)
    {
      this.avi = paramAttributeSet;
      this.avk = true;
    }
    if ((this.avj) || (this.avk)) {
      mp();
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
      this.avE = paramAttributeSet;
      paramInt = localaz.getDimensionPixelSize(0, 0);
      if ((paramInt != 0) && (paramInt != this.avD.getTextSize()))
      {
        this.avD.setTextSize(paramInt);
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
            paramAttributeSet = this.avD;
            if ((paramInt & 0x1) == 0) {
              break label702;
            }
            bool = true;
            paramAttributeSet.setFakeBoldText(bool);
            paramAttributeSet = this.avD;
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
    for (this.avH = new android.support.v7.g.a(getContext());; this.avH = null)
    {
      localaz.avP.recycle();
      ((az)localObject).avP.recycle();
      paramContext = ViewConfiguration.get(paramContext);
      this.mTouchSlop = paramContext.getScaledTouchSlop();
      this.apL = paramContext.getScaledMinimumFlingVelocity();
      refreshDrawableState();
      setChecked(isChecked());
      return;
      this.avE = getTextColors();
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
      this.avD.setFakeBoldText(false);
      this.avD.setTextSkewX(0.0F);
      setSwitchTypeface(paramAttributeSet);
      break label579;
    }
  }
  
  private boolean getTargetCheckedState()
  {
    return this.avv > 0.5F;
  }
  
  private int getThumbOffset()
  {
    if (bh.d(this)) {}
    for (float f = 1.0F - this.avv;; f = this.avv) {
      return (int)(f * getThumbScrollRange() + 0.5F);
    }
  }
  
  private int getThumbScrollRange()
  {
    if (this.avf != null)
    {
      Rect localRect2 = this.mTempRect;
      this.avf.getPadding(localRect2);
      if (this.ava != null) {}
      for (Rect localRect1 = x.r(this.ava);; localRect1 = x.ajS) {
        return this.avw - this.avy - localRect2.left - localRect2.right - localRect1.left - localRect1.right;
      }
    }
    return 0;
  }
  
  private void mp()
  {
    if ((this.avf != null) && ((this.avj) || (this.avk)))
    {
      this.avf = this.avf.mutate();
      if (this.avj) {
        android.support.v4.graphics.drawable.a.a(this.avf, this.avh);
      }
      if (this.avk) {
        android.support.v4.graphics.drawable.a.a(this.avf, this.avi);
      }
      if (this.avf.isStateful()) {
        this.avf.setState(getDrawableState());
      }
    }
  }
  
  private void mq()
  {
    if ((this.ava != null) && ((this.avd) || (this.ave)))
    {
      this.ava = this.ava.mutate();
      if (this.avd) {
        android.support.v4.graphics.drawable.a.a(this.ava, this.avb);
      }
      if (this.ave) {
        android.support.v4.graphics.drawable.a.a(this.ava, this.avc);
      }
      if (this.ava.isStateful()) {
        this.ava.setState(getDrawableState());
      }
    }
  }
  
  private Layout q(CharSequence paramCharSequence)
  {
    TextPaint localTextPaint;
    if (this.avH != null)
    {
      paramCharSequence = this.avH.getTransformation(paramCharSequence, this);
      localTextPaint = this.avD;
      if (paramCharSequence == null) {
        break label62;
      }
    }
    label62:
    for (int i = (int)Math.ceil(Layout.getDesiredWidth(paramCharSequence, this.avD));; i = 0)
    {
      return new StaticLayout(paramCharSequence, localTextPaint, i, Layout.Alignment.ALIGN_NORMAL, 1.0F, 0.0F, true);
      break;
    }
  }
  
  public void draw(Canvas paramCanvas)
  {
    Rect localRect = this.mTempRect;
    int j = this.avz;
    int n = this.avA;
    int i2 = this.avB;
    int i1 = this.avC;
    int i3 = j + getThumbOffset();
    Object localObject;
    int i4;
    label139:
    int m;
    int k;
    if (this.ava != null)
    {
      localObject = x.r(this.ava);
      if (this.avf == null) {
        break label340;
      }
      this.avf.getPadding(localRect);
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
      this.avf.setBounds(i, j, m, k);
    }
    label307:
    label314:
    label320:
    label340:
    for (int i = i4 + i3;; i = i3)
    {
      if (this.ava != null)
      {
        this.ava.getPadding(localRect);
        j = i - localRect.left;
        i = i + this.avy + localRect.right;
        this.ava.setBounds(j, n, i, i1);
        localObject = getBackground();
        if (localObject != null) {
          android.support.v4.graphics.drawable.a.a((Drawable)localObject, j, n, i, i1);
        }
      }
      super.draw(paramCanvas);
      return;
      localObject = x.ajS;
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
    if (this.ava != null) {
      android.support.v4.graphics.drawable.a.a(this.ava, paramFloat1, paramFloat2);
    }
    if (this.avf != null) {
      android.support.v4.graphics.drawable.a.a(this.avf, paramFloat1, paramFloat2);
    }
  }
  
  protected void drawableStateChanged()
  {
    super.drawableStateChanged();
    int[] arrayOfInt = getDrawableState();
    boolean bool2 = false;
    Drawable localDrawable = this.ava;
    boolean bool1 = bool2;
    if (localDrawable != null)
    {
      bool1 = bool2;
      if (localDrawable.isStateful()) {
        bool1 = localDrawable.setState(arrayOfInt) | false;
      }
    }
    localDrawable = this.avf;
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
      j = super.getCompoundPaddingLeft() + this.avw;
      i = j;
    } while (TextUtils.isEmpty(getText()));
    return j + this.avn;
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
      j = super.getCompoundPaddingRight() + this.avw;
      i = j;
    } while (TextUtils.isEmpty(getText()));
    return j + this.avn;
  }
  
  public boolean getShowText()
  {
    return this.avr;
  }
  
  public boolean getSplitTrack()
  {
    return this.avo;
  }
  
  public int getSwitchMinWidth()
  {
    return this.avm;
  }
  
  public int getSwitchPadding()
  {
    return this.avn;
  }
  
  public CharSequence getTextOff()
  {
    return this.avq;
  }
  
  public CharSequence getTextOn()
  {
    return this.avp;
  }
  
  public Drawable getThumbDrawable()
  {
    return this.ava;
  }
  
  public int getThumbTextPadding()
  {
    return this.avl;
  }
  
  public ColorStateList getThumbTintList()
  {
    return this.avb;
  }
  
  public PorterDuff.Mode getThumbTintMode()
  {
    return this.avc;
  }
  
  public Drawable getTrackDrawable()
  {
    return this.avf;
  }
  
  public ColorStateList getTrackTintList()
  {
    return this.avh;
  }
  
  public PorterDuff.Mode getTrackTintMode()
  {
    return this.avi;
  }
  
  public void jumpDrawablesToCurrentState()
  {
    super.jumpDrawablesToCurrentState();
    if (this.ava != null) {
      this.ava.jumpToCurrentState();
    }
    if (this.avf != null) {
      this.avf.jumpToCurrentState();
    }
    if ((this.avI != null) && (this.avI.isStarted()))
    {
      this.avI.end();
      this.avI = null;
    }
  }
  
  protected int[] onCreateDrawableState(int paramInt)
  {
    int[] arrayOfInt = super.onCreateDrawableState(paramInt + 1);
    if (isChecked()) {
      mergeDrawableStates(arrayOfInt, gZ);
    }
    return arrayOfInt;
  }
  
  protected void onDraw(Canvas paramCanvas)
  {
    super.onDraw(paramCanvas);
    Object localObject1 = this.mTempRect;
    Object localObject3 = this.avf;
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
      k = this.avA;
      m = this.avC;
      n = ((Rect)localObject1).top;
      i1 = ((Rect)localObject1).bottom;
      localObject2 = this.ava;
      if (localObject3 != null)
      {
        if ((!this.avo) || (localObject2 == null)) {
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
      localObject1 = this.avF;
      label180:
      if (localObject1 != null)
      {
        localObject3 = getDrawableState();
        if (this.avE != null) {
          this.avD.setColor(this.avE.getColorForState((int[])localObject3, 0));
        }
        this.avD.drawableState = ((int[])localObject3);
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
      localObject1 = this.avG;
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
    for (CharSequence localCharSequence1 = this.avp;; localCharSequence1 = this.avq)
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
    if (this.ava != null)
    {
      localRect1 = this.mTempRect;
      if (this.avf != null)
      {
        this.avf.getPadding(localRect1);
        Rect localRect2 = x.r(this.ava);
        paramInt2 = Math.max(0, localRect2.left - localRect1.left);
        paramInt1 = Math.max(0, localRect2.right - localRect1.right);
      }
    }
    for (;;)
    {
      if (bh.d(this))
      {
        paramInt3 = getPaddingLeft() + paramInt2;
        paramInt4 = this.avw + paramInt3 - paramInt2 - paramInt1;
        label110:
        switch (getGravity() & 0x70)
        {
        default: 
          paramInt2 = getPaddingTop();
          paramInt1 = this.avx + paramInt2;
        }
      }
      for (;;)
      {
        this.avz = paramInt3;
        this.avA = paramInt2;
        this.avC = paramInt1;
        this.avB = paramInt4;
        return;
        localRect1.setEmpty();
        break;
        paramInt4 = getWidth() - getPaddingRight() - paramInt1;
        paramInt3 = paramInt1 + (paramInt2 + (paramInt4 - this.avw));
        break label110;
        paramInt2 = (getPaddingTop() + getHeight() - getPaddingBottom()) / 2 - this.avx / 2;
        paramInt1 = this.avx + paramInt2;
        continue;
        paramInt1 = getHeight() - getPaddingBottom();
        paramInt2 = paramInt1 - this.avx;
      }
      paramInt1 = 0;
      paramInt2 = 0;
    }
  }
  
  public void onMeasure(int paramInt1, int paramInt2)
  {
    int m = 0;
    if (this.avr)
    {
      if (this.avF == null) {
        this.avF = q(this.avp);
      }
      if (this.avG == null) {
        this.avG = q(this.avq);
      }
    }
    Rect localRect = this.mTempRect;
    int i;
    int k;
    if (this.ava != null)
    {
      this.ava.getPadding(localRect);
      j = this.ava.getIntrinsicWidth() - localRect.left - localRect.right;
      i = this.ava.getIntrinsicHeight();
      if (!this.avr) {
        break label303;
      }
      k = Math.max(this.avF.getWidth(), this.avG.getWidth()) + this.avl * 2;
      label133:
      this.avy = Math.max(k, j);
      if (this.avf == null) {
        break label309;
      }
      this.avf.getPadding(localRect);
    }
    for (int j = this.avf.getIntrinsicHeight();; j = m)
    {
      int i1 = localRect.left;
      int n = localRect.right;
      m = i1;
      k = n;
      if (this.ava != null)
      {
        localRect = x.r(this.ava);
        m = Math.max(i1, localRect.left);
        k = Math.max(n, localRect.right);
      }
      k = Math.max(this.avm, m + this.avy * 2 + k);
      i = Math.max(j, i);
      this.avw = k;
      this.avx = i;
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
    for (CharSequence localCharSequence = this.avp;; localCharSequence = this.avq)
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
        if (this.ava != null)
        {
          i = getThumbOffset();
          this.ava.getPadding(this.mTempRect);
          int k = this.avA;
          int m = this.mTouchSlop;
          int n = i + this.avz - this.mTouchSlop;
          int i1 = this.avy;
          int i2 = this.mTempRect.left;
          int i3 = this.mTempRect.right;
          int i4 = this.mTouchSlop;
          int i5 = this.avC;
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
        this.avs = 1;
        this.avt = f1;
        this.avu = f2;
        break;
        switch (this.avs)
        {
        case 0: 
        default: 
          break;
        case 1: 
          f1 = paramMotionEvent.getX();
          f2 = paramMotionEvent.getY();
          if ((Math.abs(f1 - this.avt) <= this.mTouchSlop) && (Math.abs(f2 - this.avu) <= this.mTouchSlop)) {
            break;
          }
          this.avs = 2;
          getParent().requestDisallowInterceptTouchEvent(true);
          this.avt = f1;
          this.avu = f2;
          return true;
        case 2: 
          float f4 = paramMotionEvent.getX();
          i = getThumbScrollRange();
          f1 = f4 - this.avt;
          if (i != 0)
          {
            f1 /= i;
            f2 = f1;
            if (bh.d(this)) {
              f2 = -f1;
            }
            f2 += this.avv;
            if (f2 >= 0.0F) {
              break label474;
            }
            f1 = 0.0F;
          }
          for (;;)
          {
            if (f1 == this.avv) {
              break label486;
            }
            this.avt = f4;
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
      if (this.avs == 2)
      {
        this.avs = 0;
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
          if (Math.abs(f1) <= this.apL) {
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
      this.avs = 0;
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
        this.avI = ObjectAnimator.ofFloat(this, auZ, new float[] { f });
        this.avI.setDuration(250L);
        if (Build.VERSION.SDK_INT >= 18) {
          this.avI.setAutoCancel(true);
        }
        this.avI.start();
        return;
        f = 0.0F;
      }
    }
    if (this.avI != null) {
      this.avI.cancel();
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
    if (this.avr != paramBoolean)
    {
      this.avr = paramBoolean;
      requestLayout();
    }
  }
  
  public void setSplitTrack(boolean paramBoolean)
  {
    this.avo = paramBoolean;
    invalidate();
  }
  
  public void setSwitchMinWidth(int paramInt)
  {
    this.avm = paramInt;
    requestLayout();
  }
  
  public void setSwitchPadding(int paramInt)
  {
    this.avn = paramInt;
    requestLayout();
  }
  
  public void setSwitchTypeface(Typeface paramTypeface)
  {
    if (((this.avD.getTypeface() != null) && (!this.avD.getTypeface().equals(paramTypeface))) || ((this.avD.getTypeface() == null) && (paramTypeface != null)))
    {
      this.avD.setTypeface(paramTypeface);
      requestLayout();
      invalidate();
    }
  }
  
  public void setTextOff(CharSequence paramCharSequence)
  {
    this.avq = paramCharSequence;
    requestLayout();
  }
  
  public void setTextOn(CharSequence paramCharSequence)
  {
    this.avp = paramCharSequence;
    requestLayout();
  }
  
  public void setThumbDrawable(Drawable paramDrawable)
  {
    if (this.ava != null) {
      this.ava.setCallback(null);
    }
    this.ava = paramDrawable;
    if (paramDrawable != null) {
      paramDrawable.setCallback(this);
    }
    requestLayout();
  }
  
  void setThumbPosition(float paramFloat)
  {
    this.avv = paramFloat;
    invalidate();
  }
  
  public void setThumbResource(int paramInt)
  {
    setThumbDrawable(android.support.v7.c.a.a.l(getContext(), paramInt));
  }
  
  public void setThumbTextPadding(int paramInt)
  {
    this.avl = paramInt;
    requestLayout();
  }
  
  public void setThumbTintList(ColorStateList paramColorStateList)
  {
    this.avb = paramColorStateList;
    this.avd = true;
    mq();
  }
  
  public void setThumbTintMode(PorterDuff.Mode paramMode)
  {
    this.avc = paramMode;
    this.ave = true;
    mq();
  }
  
  public void setTrackDrawable(Drawable paramDrawable)
  {
    if (this.avf != null) {
      this.avf.setCallback(null);
    }
    this.avf = paramDrawable;
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
    this.avh = paramColorStateList;
    this.avj = true;
    mp();
  }
  
  public void setTrackTintMode(PorterDuff.Mode paramMode)
  {
    this.avi = paramMode;
    this.avk = true;
    mp();
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
    return (super.verifyDrawable(paramDrawable)) || (paramDrawable == this.ava) || (paramDrawable == this.avf);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     android.support.v7.widget.SwitchCompat
 * JD-Core Version:    0.7.0.1
 */