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
  private static final Property<SwitchCompat, Float> anA = new SwitchCompat.1(Float.class, "thumbPos");
  private static final int[] dP = { 16842912 };
  private int aiC;
  private Drawable anB;
  private ColorStateList anC = null;
  private PorterDuff.Mode anD = null;
  private boolean anE = false;
  private boolean anF = false;
  private Drawable anG;
  private ColorStateList anH = null;
  private PorterDuff.Mode anI = null;
  private boolean anJ = false;
  private boolean anK = false;
  private int anL;
  private int anM;
  private int anN;
  private boolean anO;
  private CharSequence anP;
  private CharSequence anQ;
  private boolean anR;
  private int anS;
  private float anT;
  private float anU;
  float anV;
  private int anW;
  private int anX;
  private int anY;
  private int anZ;
  private int aoa;
  private int aob;
  private int aoc;
  private ColorStateList aod;
  private Layout aoe;
  private Layout aof;
  private TransformationMethod aog;
  ObjectAnimator aoh;
  private final TextPaint hB = new TextPaint(1);
  private final Rect mTempRect = new Rect();
  private int mTouchSlop;
  private VelocityTracker mVelocityTracker = VelocityTracker.obtain();
  
  public SwitchCompat(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 2130772236);
  }
  
  public SwitchCompat(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    Object localObject = getResources();
    this.hB.density = ((Resources)localObject).getDisplayMetrics().density;
    localObject = az.a(paramContext, paramAttributeSet, a.a.SwitchCompat, paramInt, 0);
    this.anB = ((az)localObject).getDrawable(2);
    if (this.anB != null) {
      this.anB.setCallback(this);
    }
    this.anG = ((az)localObject).getDrawable(5);
    if (this.anG != null) {
      this.anG.setCallback(this);
    }
    this.anP = ((az)localObject).getText(0);
    this.anQ = ((az)localObject).getText(1);
    this.anR = ((az)localObject).getBoolean(13, true);
    this.anL = ((az)localObject).getDimensionPixelSize(8, 0);
    this.anM = ((az)localObject).getDimensionPixelSize(10, 0);
    this.anN = ((az)localObject).getDimensionPixelSize(11, 0);
    this.anO = ((az)localObject).getBoolean(12, false);
    paramAttributeSet = ((az)localObject).getColorStateList(3);
    if (paramAttributeSet != null)
    {
      this.anC = paramAttributeSet;
      this.anE = true;
    }
    paramAttributeSet = x.c(((az)localObject).getInt(4, -1), null);
    if (this.anD != paramAttributeSet)
    {
      this.anD = paramAttributeSet;
      this.anF = true;
    }
    if ((this.anE) || (this.anF)) {
      kK();
    }
    paramAttributeSet = ((az)localObject).getColorStateList(6);
    if (paramAttributeSet != null)
    {
      this.anH = paramAttributeSet;
      this.anJ = true;
    }
    paramAttributeSet = x.c(((az)localObject).getInt(7, -1), null);
    if (this.anI != paramAttributeSet)
    {
      this.anI = paramAttributeSet;
      this.anK = true;
    }
    if ((this.anJ) || (this.anK)) {
      kJ();
    }
    paramInt = ((az)localObject).getResourceId(9, 0);
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
      this.aod = paramAttributeSet;
      paramInt = localaz.getDimensionPixelSize(0, 0);
      if ((paramInt != 0) && (paramInt != this.hB.getTextSize()))
      {
        this.hB.setTextSize(paramInt);
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
            paramAttributeSet = this.hB;
            if ((paramInt & 0x1) == 0) {
              break label702;
            }
            bool = true;
            paramAttributeSet.setFakeBoldText(bool);
            paramAttributeSet = this.hB;
            if ((paramInt & 0x2) == 0) {
              break label708;
            }
            f = -0.25F;
            label573:
            paramAttributeSet.setTextSkewX(f);
            label579:
            if (!localaz.getBoolean(11, false)) {
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
    for (this.aog = new android.support.v7.g.a(getContext());; this.aog = null)
    {
      localaz.aoo.recycle();
      ((az)localObject).aoo.recycle();
      paramContext = ViewConfiguration.get(paramContext);
      this.mTouchSlop = paramContext.getScaledTouchSlop();
      this.aiC = paramContext.getScaledMinimumFlingVelocity();
      refreshDrawableState();
      setChecked(isChecked());
      return;
      this.aod = getTextColors();
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
      this.hB.setFakeBoldText(false);
      this.hB.setTextSkewX(0.0F);
      setSwitchTypeface(paramAttributeSet);
      break label579;
    }
  }
  
  private boolean getTargetCheckedState()
  {
    return this.anV > 0.5F;
  }
  
  private int getThumbOffset()
  {
    if (bh.bY(this)) {}
    for (float f = 1.0F - this.anV;; f = this.anV) {
      return (int)(f * getThumbScrollRange() + 0.5F);
    }
  }
  
  private int getThumbScrollRange()
  {
    if (this.anG != null)
    {
      Rect localRect2 = this.mTempRect;
      this.anG.getPadding(localRect2);
      if (this.anB != null) {}
      for (Rect localRect1 = x.m(this.anB);; localRect1 = x.acL) {
        return this.anW - this.anY - localRect2.left - localRect2.right - localRect1.left - localRect1.right;
      }
    }
    return 0;
  }
  
  private void kJ()
  {
    if ((this.anG != null) && ((this.anJ) || (this.anK)))
    {
      this.anG = this.anG.mutate();
      if (this.anJ) {
        android.support.v4.graphics.drawable.a.a(this.anG, this.anH);
      }
      if (this.anK) {
        android.support.v4.graphics.drawable.a.a(this.anG, this.anI);
      }
      if (this.anG.isStateful()) {
        this.anG.setState(getDrawableState());
      }
    }
  }
  
  private void kK()
  {
    if ((this.anB != null) && ((this.anE) || (this.anF)))
    {
      this.anB = this.anB.mutate();
      if (this.anE) {
        android.support.v4.graphics.drawable.a.a(this.anB, this.anC);
      }
      if (this.anF) {
        android.support.v4.graphics.drawable.a.a(this.anB, this.anD);
      }
      if (this.anB.isStateful()) {
        this.anB.setState(getDrawableState());
      }
    }
  }
  
  private Layout n(CharSequence paramCharSequence)
  {
    TextPaint localTextPaint;
    if (this.aog != null)
    {
      paramCharSequence = this.aog.getTransformation(paramCharSequence, this);
      localTextPaint = this.hB;
      if (paramCharSequence == null) {
        break label62;
      }
    }
    label62:
    for (int i = (int)Math.ceil(Layout.getDesiredWidth(paramCharSequence, this.hB));; i = 0)
    {
      return new StaticLayout(paramCharSequence, localTextPaint, i, Layout.Alignment.ALIGN_NORMAL, 1.0F, 0.0F, true);
      break;
    }
  }
  
  public void draw(Canvas paramCanvas)
  {
    Rect localRect = this.mTempRect;
    int j = this.anZ;
    int n = this.aoa;
    int i2 = this.aob;
    int i1 = this.aoc;
    int i3 = j + getThumbOffset();
    Object localObject;
    int i4;
    label139:
    int m;
    int k;
    if (this.anB != null)
    {
      localObject = x.m(this.anB);
      if (this.anG == null) {
        break label340;
      }
      this.anG.getPadding(localRect);
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
      this.anG.setBounds(i, j, m, k);
    }
    label307:
    label314:
    label320:
    label340:
    for (int i = i4 + i3;; i = i3)
    {
      if (this.anB != null)
      {
        this.anB.getPadding(localRect);
        j = i - localRect.left;
        i = i + this.anY + localRect.right;
        this.anB.setBounds(j, n, i, i1);
        localObject = getBackground();
        if (localObject != null) {
          android.support.v4.graphics.drawable.a.a((Drawable)localObject, j, n, i, i1);
        }
      }
      super.draw(paramCanvas);
      return;
      localObject = x.acL;
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
    if (this.anB != null) {
      android.support.v4.graphics.drawable.a.a(this.anB, paramFloat1, paramFloat2);
    }
    if (this.anG != null) {
      android.support.v4.graphics.drawable.a.a(this.anG, paramFloat1, paramFloat2);
    }
  }
  
  protected void drawableStateChanged()
  {
    super.drawableStateChanged();
    int[] arrayOfInt = getDrawableState();
    boolean bool2 = false;
    Drawable localDrawable = this.anB;
    boolean bool1 = bool2;
    if (localDrawable != null)
    {
      bool1 = bool2;
      if (localDrawable.isStateful()) {
        bool1 = localDrawable.setState(arrayOfInt) | false;
      }
    }
    localDrawable = this.anG;
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
    if (!bh.bY(this)) {
      i = super.getCompoundPaddingLeft();
    }
    int j;
    do
    {
      return i;
      j = super.getCompoundPaddingLeft() + this.anW;
      i = j;
    } while (TextUtils.isEmpty(getText()));
    return j + this.anN;
  }
  
  public int getCompoundPaddingRight()
  {
    int i;
    if (bh.bY(this)) {
      i = super.getCompoundPaddingRight();
    }
    int j;
    do
    {
      return i;
      j = super.getCompoundPaddingRight() + this.anW;
      i = j;
    } while (TextUtils.isEmpty(getText()));
    return j + this.anN;
  }
  
  public boolean getShowText()
  {
    return this.anR;
  }
  
  public boolean getSplitTrack()
  {
    return this.anO;
  }
  
  public int getSwitchMinWidth()
  {
    return this.anM;
  }
  
  public int getSwitchPadding()
  {
    return this.anN;
  }
  
  public CharSequence getTextOff()
  {
    return this.anQ;
  }
  
  public CharSequence getTextOn()
  {
    return this.anP;
  }
  
  public Drawable getThumbDrawable()
  {
    return this.anB;
  }
  
  public int getThumbTextPadding()
  {
    return this.anL;
  }
  
  public ColorStateList getThumbTintList()
  {
    return this.anC;
  }
  
  public PorterDuff.Mode getThumbTintMode()
  {
    return this.anD;
  }
  
  public Drawable getTrackDrawable()
  {
    return this.anG;
  }
  
  public ColorStateList getTrackTintList()
  {
    return this.anH;
  }
  
  public PorterDuff.Mode getTrackTintMode()
  {
    return this.anI;
  }
  
  public void jumpDrawablesToCurrentState()
  {
    super.jumpDrawablesToCurrentState();
    if (this.anB != null) {
      this.anB.jumpToCurrentState();
    }
    if (this.anG != null) {
      this.anG.jumpToCurrentState();
    }
    if ((this.aoh != null) && (this.aoh.isStarted()))
    {
      this.aoh.end();
      this.aoh = null;
    }
  }
  
  protected int[] onCreateDrawableState(int paramInt)
  {
    int[] arrayOfInt = super.onCreateDrawableState(paramInt + 1);
    if (isChecked()) {
      mergeDrawableStates(arrayOfInt, dP);
    }
    return arrayOfInt;
  }
  
  protected void onDraw(Canvas paramCanvas)
  {
    super.onDraw(paramCanvas);
    Object localObject1 = this.mTempRect;
    Object localObject3 = this.anG;
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
      k = this.aoa;
      m = this.aoc;
      n = ((Rect)localObject1).top;
      i1 = ((Rect)localObject1).bottom;
      localObject2 = this.anB;
      if (localObject3 != null)
      {
        if ((!this.anO) || (localObject2 == null)) {
          break label322;
        }
        Rect localRect = x.m((Drawable)localObject2);
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
      localObject1 = this.aoe;
      label180:
      if (localObject1 != null)
      {
        localObject3 = getDrawableState();
        if (this.aod != null) {
          this.hB.setColor(this.aod.getColorForState((int[])localObject3, 0));
        }
        this.hB.drawableState = ((int[])localObject3);
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
      localObject1 = this.aof;
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
    for (CharSequence localCharSequence1 = this.anP;; localCharSequence1 = this.anQ)
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
    if (this.anB != null)
    {
      localRect1 = this.mTempRect;
      if (this.anG != null)
      {
        this.anG.getPadding(localRect1);
        Rect localRect2 = x.m(this.anB);
        paramInt2 = Math.max(0, localRect2.left - localRect1.left);
        paramInt1 = Math.max(0, localRect2.right - localRect1.right);
      }
    }
    for (;;)
    {
      if (bh.bY(this))
      {
        paramInt3 = getPaddingLeft() + paramInt2;
        paramInt4 = this.anW + paramInt3 - paramInt2 - paramInt1;
        label110:
        switch (getGravity() & 0x70)
        {
        default: 
          paramInt2 = getPaddingTop();
          paramInt1 = this.anX + paramInt2;
        }
      }
      for (;;)
      {
        this.anZ = paramInt3;
        this.aoa = paramInt2;
        this.aoc = paramInt1;
        this.aob = paramInt4;
        return;
        localRect1.setEmpty();
        break;
        paramInt4 = getWidth() - getPaddingRight() - paramInt1;
        paramInt3 = paramInt1 + (paramInt2 + (paramInt4 - this.anW));
        break label110;
        paramInt2 = (getPaddingTop() + getHeight() - getPaddingBottom()) / 2 - this.anX / 2;
        paramInt1 = this.anX + paramInt2;
        continue;
        paramInt1 = getHeight() - getPaddingBottom();
        paramInt2 = paramInt1 - this.anX;
      }
      paramInt1 = 0;
      paramInt2 = 0;
    }
  }
  
  public void onMeasure(int paramInt1, int paramInt2)
  {
    int m = 0;
    if (this.anR)
    {
      if (this.aoe == null) {
        this.aoe = n(this.anP);
      }
      if (this.aof == null) {
        this.aof = n(this.anQ);
      }
    }
    Rect localRect = this.mTempRect;
    int i;
    int k;
    if (this.anB != null)
    {
      this.anB.getPadding(localRect);
      j = this.anB.getIntrinsicWidth() - localRect.left - localRect.right;
      i = this.anB.getIntrinsicHeight();
      if (!this.anR) {
        break label303;
      }
      k = Math.max(this.aoe.getWidth(), this.aof.getWidth()) + this.anL * 2;
      label133:
      this.anY = Math.max(k, j);
      if (this.anG == null) {
        break label309;
      }
      this.anG.getPadding(localRect);
    }
    for (int j = this.anG.getIntrinsicHeight();; j = m)
    {
      int i1 = localRect.left;
      int n = localRect.right;
      m = i1;
      k = n;
      if (this.anB != null)
      {
        localRect = x.m(this.anB);
        m = Math.max(i1, localRect.left);
        k = Math.max(n, localRect.right);
      }
      k = Math.max(this.anM, m + this.anY * 2 + k);
      i = Math.max(j, i);
      this.anW = k;
      this.anX = i;
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
    for (CharSequence localCharSequence = this.anP;; localCharSequence = this.anQ)
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
        if (this.anB != null)
        {
          i = getThumbOffset();
          this.anB.getPadding(this.mTempRect);
          int k = this.aoa;
          int m = this.mTouchSlop;
          int n = i + this.anZ - this.mTouchSlop;
          int i1 = this.anY;
          int i2 = this.mTempRect.left;
          int i3 = this.mTempRect.right;
          int i4 = this.mTouchSlop;
          int i5 = this.aoc;
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
        this.anS = 1;
        this.anT = f1;
        this.anU = f2;
        break;
        switch (this.anS)
        {
        case 0: 
        default: 
          break;
        case 1: 
          f1 = paramMotionEvent.getX();
          f2 = paramMotionEvent.getY();
          if ((Math.abs(f1 - this.anT) <= this.mTouchSlop) && (Math.abs(f2 - this.anU) <= this.mTouchSlop)) {
            break;
          }
          this.anS = 2;
          getParent().requestDisallowInterceptTouchEvent(true);
          this.anT = f1;
          this.anU = f2;
          return true;
        case 2: 
          float f4 = paramMotionEvent.getX();
          i = getThumbScrollRange();
          f1 = f4 - this.anT;
          if (i != 0)
          {
            f1 /= i;
            f2 = f1;
            if (bh.bY(this)) {
              f2 = -f1;
            }
            f2 += this.anV;
            if (f2 >= 0.0F) {
              break label474;
            }
            f1 = 0.0F;
          }
          for (;;)
          {
            if (f1 == this.anV) {
              break label486;
            }
            this.anT = f4;
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
      if (this.anS == 2)
      {
        this.anS = 0;
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
          if (Math.abs(f1) <= this.aiC) {
            break label657;
          }
          if (!bh.bY(this)) {
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
      this.anS = 0;
      this.mVelocityTracker.clear();
    }
  }
  
  public void setChecked(boolean paramBoolean)
  {
    float f = 1.0F;
    super.setChecked(paramBoolean);
    paramBoolean = isChecked();
    if ((getWindowToken() != null) && (t.as(this)))
    {
      if (paramBoolean) {}
      for (;;)
      {
        this.aoh = ObjectAnimator.ofFloat(this, anA, new float[] { f });
        this.aoh.setDuration(250L);
        if (Build.VERSION.SDK_INT >= 18) {
          this.aoh.setAutoCancel(true);
        }
        this.aoh.start();
        return;
        f = 0.0F;
      }
    }
    if (this.aoh != null) {
      this.aoh.cancel();
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
    if (this.anR != paramBoolean)
    {
      this.anR = paramBoolean;
      requestLayout();
    }
  }
  
  public void setSplitTrack(boolean paramBoolean)
  {
    this.anO = paramBoolean;
    invalidate();
  }
  
  public void setSwitchMinWidth(int paramInt)
  {
    this.anM = paramInt;
    requestLayout();
  }
  
  public void setSwitchPadding(int paramInt)
  {
    this.anN = paramInt;
    requestLayout();
  }
  
  public void setSwitchTypeface(Typeface paramTypeface)
  {
    if (((this.hB.getTypeface() != null) && (!this.hB.getTypeface().equals(paramTypeface))) || ((this.hB.getTypeface() == null) && (paramTypeface != null)))
    {
      this.hB.setTypeface(paramTypeface);
      requestLayout();
      invalidate();
    }
  }
  
  public void setTextOff(CharSequence paramCharSequence)
  {
    this.anQ = paramCharSequence;
    requestLayout();
  }
  
  public void setTextOn(CharSequence paramCharSequence)
  {
    this.anP = paramCharSequence;
    requestLayout();
  }
  
  public void setThumbDrawable(Drawable paramDrawable)
  {
    if (this.anB != null) {
      this.anB.setCallback(null);
    }
    this.anB = paramDrawable;
    if (paramDrawable != null) {
      paramDrawable.setCallback(this);
    }
    requestLayout();
  }
  
  void setThumbPosition(float paramFloat)
  {
    this.anV = paramFloat;
    invalidate();
  }
  
  public void setThumbResource(int paramInt)
  {
    setThumbDrawable(android.support.v7.c.a.a.k(getContext(), paramInt));
  }
  
  public void setThumbTextPadding(int paramInt)
  {
    this.anL = paramInt;
    requestLayout();
  }
  
  public void setThumbTintList(ColorStateList paramColorStateList)
  {
    this.anC = paramColorStateList;
    this.anE = true;
    kK();
  }
  
  public void setThumbTintMode(PorterDuff.Mode paramMode)
  {
    this.anD = paramMode;
    this.anF = true;
    kK();
  }
  
  public void setTrackDrawable(Drawable paramDrawable)
  {
    if (this.anG != null) {
      this.anG.setCallback(null);
    }
    this.anG = paramDrawable;
    if (paramDrawable != null) {
      paramDrawable.setCallback(this);
    }
    requestLayout();
  }
  
  public void setTrackResource(int paramInt)
  {
    setTrackDrawable(android.support.v7.c.a.a.k(getContext(), paramInt));
  }
  
  public void setTrackTintList(ColorStateList paramColorStateList)
  {
    this.anH = paramColorStateList;
    this.anJ = true;
    kJ();
  }
  
  public void setTrackTintMode(PorterDuff.Mode paramMode)
  {
    this.anI = paramMode;
    this.anK = true;
    kJ();
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
    return (super.verifyDrawable(paramDrawable)) || (paramDrawable == this.anB) || (paramDrawable == this.anG);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     android.support.v7.widget.SwitchCompat
 * JD-Core Version:    0.7.0.1
 */