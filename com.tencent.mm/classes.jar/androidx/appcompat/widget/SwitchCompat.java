package androidx.appcompat.widget;

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
import androidx.appcompat.a.a;
import androidx.appcompat.a.j;
import androidx.core.g.z;
import androidx.core.widget.j;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.List;

public class SwitchCompat
  extends CompoundButton
{
  private static final Property<SwitchCompat, Float> wA;
  private static final int[] xk;
  private final Rect mTempRect;
  private int mTouchSlop;
  private VelocityTracker mVelocityTracker;
  private Drawable wB;
  private ColorStateList wC;
  private PorterDuff.Mode wD;
  private boolean wE;
  private boolean wF;
  private Drawable wG;
  private ColorStateList wH;
  private PorterDuff.Mode wI;
  private boolean wJ;
  private boolean wK;
  private int wL;
  private int wM;
  private int wN;
  private boolean wO;
  private CharSequence wP;
  private CharSequence wQ;
  private boolean wR;
  private int wS;
  private float wT;
  private float wU;
  private int wV;
  float wW;
  private int wX;
  private int wY;
  private int wZ;
  private int xa;
  private int xb;
  private int xc;
  private int xd;
  private final TextPaint xe;
  private ColorStateList xf;
  private Layout xg;
  private Layout xh;
  private TransformationMethod xi;
  ObjectAnimator xj;
  
  static
  {
    AppMethodBeat.i(199549);
    wA = new Property(Float.class, "thumbPos") {};
    xk = new int[] { 16842912 };
    AppMethodBeat.o(199549);
  }
  
  public SwitchCompat(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, a.a.switchStyle);
  }
  
  public SwitchCompat(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    AppMethodBeat.i(199469);
    this.wC = null;
    this.wD = null;
    this.wE = false;
    this.wF = false;
    this.wH = null;
    this.wI = null;
    this.wJ = false;
    this.wK = false;
    this.mVelocityTracker = VelocityTracker.obtain();
    this.mTempRect = new Rect();
    this.xe = new TextPaint(1);
    Object localObject = getResources();
    this.xe.density = ((Resources)localObject).getDisplayMetrics().density;
    localObject = ac.a(paramContext, paramAttributeSet, a.j.SwitchCompat, paramInt, 0);
    this.wB = ((ac)localObject).getDrawable(a.j.SwitchCompat_android_thumb);
    if (this.wB != null) {
      this.wB.setCallback(this);
    }
    this.wG = ((ac)localObject).getDrawable(a.j.SwitchCompat_track);
    if (this.wG != null) {
      this.wG.setCallback(this);
    }
    this.wP = ((ac)localObject).getText(a.j.SwitchCompat_android_textOn);
    this.wQ = ((ac)localObject).getText(a.j.SwitchCompat_android_textOff);
    this.wR = ((ac)localObject).m(a.j.SwitchCompat_showText, true);
    this.wL = ((ac)localObject).u(a.j.SwitchCompat_thumbTextPadding, 0);
    this.wM = ((ac)localObject).u(a.j.SwitchCompat_switchMinWidth, 0);
    this.wN = ((ac)localObject).u(a.j.SwitchCompat_switchPadding, 0);
    this.wO = ((ac)localObject).m(a.j.SwitchCompat_splitTrack, false);
    paramAttributeSet = ((ac)localObject).getColorStateList(a.j.SwitchCompat_thumbTint);
    if (paramAttributeSet != null)
    {
      this.wC = paramAttributeSet;
      this.wE = true;
    }
    paramAttributeSet = o.c(((ac)localObject).getInt(a.j.SwitchCompat_thumbTintMode, -1), null);
    if (this.wD != paramAttributeSet)
    {
      this.wD = paramAttributeSet;
      this.wF = true;
    }
    if ((this.wE) || (this.wF)) {
      fo();
    }
    paramAttributeSet = ((ac)localObject).getColorStateList(a.j.SwitchCompat_trackTint);
    if (paramAttributeSet != null)
    {
      this.wH = paramAttributeSet;
      this.wJ = true;
    }
    paramAttributeSet = o.c(((ac)localObject).getInt(a.j.SwitchCompat_trackTintMode, -1), null);
    if (this.wI != paramAttributeSet)
    {
      this.wI = paramAttributeSet;
      this.wK = true;
    }
    if ((this.wJ) || (this.wK)) {
      fn();
    }
    paramInt = ((ac)localObject).w(a.j.SwitchCompat_switchTextAppearance, 0);
    ac localac;
    int i;
    label538:
    label553:
    label567:
    boolean bool;
    label588:
    float f;
    if (paramInt != 0)
    {
      localac = ac.a(paramContext, paramInt, a.j.TextAppearance);
      paramAttributeSet = localac.getColorStateList(a.j.TextAppearance_android_textColor);
      if (paramAttributeSet == null) {
        break label698;
      }
      this.xf = paramAttributeSet;
      paramInt = localac.u(a.j.TextAppearance_android_textSize, 0);
      if ((paramInt != 0) && (paramInt != this.xe.getTextSize()))
      {
        this.xe.setTextSize(paramInt);
        requestLayout();
      }
      paramInt = localac.getInt(a.j.TextAppearance_android_typeface, -1);
      i = localac.getInt(a.j.TextAppearance_android_textStyle, -1);
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
              break label740;
            }
            paramInt = paramAttributeSet.getStyle();
            paramInt = i & (paramInt ^ 0xFFFFFFFF);
            paramAttributeSet = this.xe;
            if ((paramInt & 0x1) == 0) {
              break label745;
            }
            bool = true;
            paramAttributeSet.setFakeBoldText(bool);
            paramAttributeSet = this.xe;
            if ((paramInt & 0x2) == 0) {
              break label751;
            }
            f = -0.25F;
            label610:
            paramAttributeSet.setTextSkewX(f);
            label616:
            if (!localac.m(a.j.TextAppearance_textAllCaps, false)) {
              break label781;
            }
          }
        }
        break;
      }
    }
    label781:
    for (this.xi = new androidx.appcompat.c.a(getContext());; this.xi = null)
    {
      localac.xv.recycle();
      ((ac)localObject).xv.recycle();
      paramContext = ViewConfiguration.get(paramContext);
      this.mTouchSlop = paramContext.getScaledTouchSlop();
      this.wV = paramContext.getScaledMinimumFlingVelocity();
      refreshDrawableState();
      setChecked(isChecked());
      AppMethodBeat.o(199469);
      return;
      label698:
      this.xf = getTextColors();
      break;
      paramAttributeSet = Typeface.SANS_SERIF;
      break label538;
      paramAttributeSet = Typeface.SERIF;
      break label538;
      paramAttributeSet = Typeface.MONOSPACE;
      break label538;
      paramAttributeSet = Typeface.create(paramAttributeSet, i);
      break label553;
      label740:
      paramInt = 0;
      break label567;
      label745:
      bool = false;
      break label588;
      label751:
      f = 0.0F;
      break label610;
      this.xe.setFakeBoldText(false);
      this.xe.setTextSkewX(0.0F);
      setSwitchTypeface(paramAttributeSet);
      break label616;
    }
  }
  
  private void fn()
  {
    AppMethodBeat.i(199482);
    if ((this.wG != null) && ((this.wJ) || (this.wK)))
    {
      this.wG = this.wG.mutate();
      if (this.wJ) {
        androidx.core.graphics.drawable.a.a(this.wG, this.wH);
      }
      if (this.wK) {
        androidx.core.graphics.drawable.a.a(this.wG, this.wI);
      }
      if (this.wG.isStateful()) {
        this.wG.setState(getDrawableState());
      }
    }
    AppMethodBeat.o(199482);
  }
  
  private void fo()
  {
    AppMethodBeat.i(199494);
    if ((this.wB != null) && ((this.wE) || (this.wF)))
    {
      this.wB = this.wB.mutate();
      if (this.wE) {
        androidx.core.graphics.drawable.a.a(this.wB, this.wC);
      }
      if (this.wF) {
        androidx.core.graphics.drawable.a.a(this.wB, this.wD);
      }
      if (this.wB.isStateful()) {
        this.wB.setState(getDrawableState());
      }
    }
    AppMethodBeat.o(199494);
  }
  
  private boolean getTargetCheckedState()
  {
    return this.wW > 0.5F;
  }
  
  private int getThumbOffset()
  {
    AppMethodBeat.i(199528);
    if (ai.s(this)) {}
    for (float f = 1.0F - this.wW;; f = this.wW)
    {
      int i = (int)(f * getThumbScrollRange() + 0.5F);
      AppMethodBeat.o(199528);
      return i;
    }
  }
  
  private int getThumbScrollRange()
  {
    AppMethodBeat.i(199539);
    if (this.wG != null)
    {
      Rect localRect2 = this.mTempRect;
      this.wG.getPadding(localRect2);
      if (this.wB != null) {}
      for (Rect localRect1 = o.h(this.wB);; localRect1 = o.tc)
      {
        int i = this.wX;
        int j = this.wZ;
        int k = localRect2.left;
        int m = localRect2.right;
        int n = localRect1.left;
        int i1 = localRect1.right;
        AppMethodBeat.o(199539);
        return i - j - k - m - n - i1;
      }
    }
    AppMethodBeat.o(199539);
    return 0;
  }
  
  private Layout h(CharSequence paramCharSequence)
  {
    AppMethodBeat.i(199507);
    TextPaint localTextPaint;
    if (this.xi != null)
    {
      paramCharSequence = this.xi.getTransformation(paramCharSequence, this);
      localTextPaint = this.xe;
      if (paramCharSequence == null) {
        break label76;
      }
    }
    label76:
    for (int i = (int)Math.ceil(Layout.getDesiredWidth(paramCharSequence, this.xe));; i = 0)
    {
      paramCharSequence = new StaticLayout(paramCharSequence, localTextPaint, i, Layout.Alignment.ALIGN_NORMAL, 1.0F, 0.0F, true);
      AppMethodBeat.o(199507);
      return paramCharSequence;
      break;
    }
  }
  
  public void draw(Canvas paramCanvas)
  {
    AppMethodBeat.i(199903);
    Rect localRect = this.mTempRect;
    int j = this.xa;
    int n = this.xb;
    int i2 = this.xc;
    int i1 = this.xd;
    int i3 = j + getThumbOffset();
    Object localObject;
    int i4;
    label145:
    int m;
    int k;
    if (this.wB != null)
    {
      localObject = o.h(this.wB);
      if (this.wG == null) {
        break label352;
      }
      this.wG.getPadding(localRect);
      i4 = localRect.left;
      if (localObject == null) {
        break label332;
      }
      i = j;
      if (((Rect)localObject).left > localRect.left) {
        i = j + (((Rect)localObject).left - localRect.left);
      }
      if (((Rect)localObject).top <= localRect.top) {
        break label326;
      }
      j = ((Rect)localObject).top - localRect.top + n;
      m = i2;
      if (((Rect)localObject).right > localRect.right) {
        m = i2 - (((Rect)localObject).right - localRect.right);
      }
      if (((Rect)localObject).bottom <= localRect.bottom) {
        break label319;
      }
      k = i1 - (((Rect)localObject).bottom - localRect.bottom);
      label207:
      this.wG.setBounds(i, j, m, k);
    }
    label319:
    label326:
    label332:
    label352:
    for (int i = i4 + i3;; i = i3)
    {
      if (this.wB != null)
      {
        this.wB.getPadding(localRect);
        j = i - localRect.left;
        i = i + this.wZ + localRect.right;
        this.wB.setBounds(j, n, i, i1);
        localObject = getBackground();
        if (localObject != null) {
          androidx.core.graphics.drawable.a.a((Drawable)localObject, j, n, i, i1);
        }
      }
      super.draw(paramCanvas);
      AppMethodBeat.o(199903);
      return;
      localObject = o.tc;
      break;
      k = i1;
      break label207;
      j = n;
      break label145;
      k = i1;
      m = n;
      i = j;
      j = m;
      m = i2;
      break label207;
    }
  }
  
  public void drawableHotspotChanged(float paramFloat1, float paramFloat2)
  {
    AppMethodBeat.i(199963);
    if (Build.VERSION.SDK_INT >= 21) {
      super.drawableHotspotChanged(paramFloat1, paramFloat2);
    }
    if (this.wB != null) {
      androidx.core.graphics.drawable.a.a(this.wB, paramFloat1, paramFloat2);
    }
    if (this.wG != null) {
      androidx.core.graphics.drawable.a.a(this.wG, paramFloat1, paramFloat2);
    }
    AppMethodBeat.o(199963);
  }
  
  protected void drawableStateChanged()
  {
    AppMethodBeat.i(199954);
    super.drawableStateChanged();
    int[] arrayOfInt = getDrawableState();
    boolean bool2 = false;
    Drawable localDrawable = this.wB;
    boolean bool1 = bool2;
    if (localDrawable != null)
    {
      bool1 = bool2;
      if (localDrawable.isStateful()) {
        bool1 = localDrawable.setState(arrayOfInt) | false;
      }
    }
    localDrawable = this.wG;
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
    AppMethodBeat.o(199954);
  }
  
  public int getCompoundPaddingLeft()
  {
    AppMethodBeat.i(199922);
    if (!ai.s(this))
    {
      i = super.getCompoundPaddingLeft();
      AppMethodBeat.o(199922);
      return i;
    }
    int j = super.getCompoundPaddingLeft() + this.wX;
    int i = j;
    if (!TextUtils.isEmpty(getText())) {
      i = j + this.wN;
    }
    AppMethodBeat.o(199922);
    return i;
  }
  
  public int getCompoundPaddingRight()
  {
    AppMethodBeat.i(199930);
    if (ai.s(this))
    {
      i = super.getCompoundPaddingRight();
      AppMethodBeat.o(199930);
      return i;
    }
    int j = super.getCompoundPaddingRight() + this.wX;
    int i = j;
    if (!TextUtils.isEmpty(getText())) {
      i = j + this.wN;
    }
    AppMethodBeat.o(199930);
    return i;
  }
  
  public boolean getShowText()
  {
    return this.wR;
  }
  
  public boolean getSplitTrack()
  {
    return this.wO;
  }
  
  public int getSwitchMinWidth()
  {
    return this.wM;
  }
  
  public int getSwitchPadding()
  {
    return this.wN;
  }
  
  public CharSequence getTextOff()
  {
    return this.wQ;
  }
  
  public CharSequence getTextOn()
  {
    return this.wP;
  }
  
  public Drawable getThumbDrawable()
  {
    return this.wB;
  }
  
  public int getThumbTextPadding()
  {
    return this.wL;
  }
  
  public ColorStateList getThumbTintList()
  {
    return this.wC;
  }
  
  public PorterDuff.Mode getThumbTintMode()
  {
    return this.wD;
  }
  
  public Drawable getTrackDrawable()
  {
    return this.wG;
  }
  
  public ColorStateList getTrackTintList()
  {
    return this.wH;
  }
  
  public PorterDuff.Mode getTrackTintMode()
  {
    return this.wI;
  }
  
  public void jumpDrawablesToCurrentState()
  {
    AppMethodBeat.i(199994);
    super.jumpDrawablesToCurrentState();
    if (this.wB != null) {
      this.wB.jumpToCurrentState();
    }
    if (this.wG != null) {
      this.wG.jumpToCurrentState();
    }
    if ((this.xj != null) && (this.xj.isStarted()))
    {
      this.xj.end();
      this.xj = null;
    }
    AppMethodBeat.o(199994);
  }
  
  protected int[] onCreateDrawableState(int paramInt)
  {
    AppMethodBeat.i(199938);
    int[] arrayOfInt = super.onCreateDrawableState(paramInt + 1);
    if (isChecked()) {
      mergeDrawableStates(arrayOfInt, xk);
    }
    AppMethodBeat.o(199938);
    return arrayOfInt;
  }
  
  protected void onDraw(Canvas paramCanvas)
  {
    AppMethodBeat.i(199914);
    super.onDraw(paramCanvas);
    Object localObject1 = this.mTempRect;
    Object localObject3 = this.wG;
    int k;
    int m;
    int n;
    int i1;
    Object localObject2;
    label157:
    int j;
    if (localObject3 != null)
    {
      ((Drawable)localObject3).getPadding((Rect)localObject1);
      k = this.xb;
      m = this.xd;
      n = ((Rect)localObject1).top;
      i1 = ((Rect)localObject1).bottom;
      localObject2 = this.wB;
      if (localObject3 != null)
      {
        if ((!this.wO) || (localObject2 == null)) {
          break label334;
        }
        Rect localRect = o.h((Drawable)localObject2);
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
        break label343;
      }
      localObject1 = this.xg;
      label186:
      if (localObject1 != null)
      {
        localObject3 = getDrawableState();
        if (this.xf != null) {
          this.xe.setColor(this.xf.getColorForState((int[])localObject3, 0));
        }
        this.xe.drawableState = ((int[])localObject3);
        if (localObject2 == null) {
          break label352;
        }
        localObject2 = ((Drawable)localObject2).getBounds();
        i = ((Rect)localObject2).left;
      }
    }
    label334:
    label343:
    label352:
    for (int i = ((Rect)localObject2).right + i;; i = getWidth())
    {
      i /= 2;
      int i2 = ((Layout)localObject1).getWidth() / 2;
      k = (k + n + (m - i1)) / 2;
      m = ((Layout)localObject1).getHeight() / 2;
      paramCanvas.translate(i - i2, k - m);
      ((Layout)localObject1).draw(paramCanvas);
      paramCanvas.restoreToCount(j);
      AppMethodBeat.o(199914);
      return;
      ((Rect)localObject1).setEmpty();
      break;
      ((Drawable)localObject3).draw(paramCanvas);
      break label157;
      localObject1 = this.xh;
      break label186;
    }
  }
  
  public void onInitializeAccessibilityEvent(AccessibilityEvent paramAccessibilityEvent)
  {
    AppMethodBeat.i(200004);
    super.onInitializeAccessibilityEvent(paramAccessibilityEvent);
    paramAccessibilityEvent.setClassName("android.widget.Switch");
    AppMethodBeat.o(200004);
  }
  
  public void onInitializeAccessibilityNodeInfo(AccessibilityNodeInfo paramAccessibilityNodeInfo)
  {
    AppMethodBeat.i(200014);
    super.onInitializeAccessibilityNodeInfo(paramAccessibilityNodeInfo);
    paramAccessibilityNodeInfo.setClassName("android.widget.Switch");
    CharSequence localCharSequence1;
    if (isChecked()) {
      localCharSequence1 = this.wP;
    }
    while (!TextUtils.isEmpty(localCharSequence1))
    {
      CharSequence localCharSequence2 = paramAccessibilityNodeInfo.getText();
      if (TextUtils.isEmpty(localCharSequence2))
      {
        paramAccessibilityNodeInfo.setText(localCharSequence1);
        AppMethodBeat.o(200014);
        return;
        localCharSequence1 = this.wQ;
      }
      else
      {
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append(localCharSequence2).append(' ').append(localCharSequence1);
        paramAccessibilityNodeInfo.setText(localStringBuilder);
      }
    }
    AppMethodBeat.o(200014);
  }
  
  protected void onLayout(boolean paramBoolean, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    AppMethodBeat.i(199896);
    super.onLayout(paramBoolean, paramInt1, paramInt2, paramInt3, paramInt4);
    Rect localRect1;
    if (this.wB != null)
    {
      localRect1 = this.mTempRect;
      if (this.wG != null)
      {
        this.wG.getPadding(localRect1);
        Rect localRect2 = o.h(this.wB);
        paramInt2 = Math.max(0, localRect2.left - localRect1.left);
        paramInt1 = Math.max(0, localRect2.right - localRect1.right);
      }
    }
    for (;;)
    {
      if (ai.s(this))
      {
        paramInt3 = getPaddingLeft() + paramInt2;
        paramInt4 = this.wX + paramInt3 - paramInt2 - paramInt1;
        label116:
        switch (getGravity() & 0x70)
        {
        default: 
          paramInt2 = getPaddingTop();
          paramInt1 = this.wY + paramInt2;
        }
      }
      for (;;)
      {
        this.xa = paramInt3;
        this.xb = paramInt2;
        this.xd = paramInt1;
        this.xc = paramInt4;
        AppMethodBeat.o(199896);
        return;
        localRect1.setEmpty();
        break;
        paramInt4 = getWidth() - getPaddingRight() - paramInt1;
        paramInt3 = paramInt1 + (paramInt2 + (paramInt4 - this.wX));
        break label116;
        paramInt2 = (getPaddingTop() + getHeight() - getPaddingBottom()) / 2 - this.wY / 2;
        paramInt1 = this.wY + paramInt2;
        continue;
        paramInt1 = getHeight() - getPaddingBottom();
        paramInt2 = paramInt1 - this.wY;
      }
      paramInt1 = 0;
      paramInt2 = 0;
    }
  }
  
  public void onMeasure(int paramInt1, int paramInt2)
  {
    int m = 0;
    AppMethodBeat.i(199813);
    if (this.wR)
    {
      if (this.xg == null) {
        this.xg = h(this.wP);
      }
      if (this.xh == null) {
        this.xh = h(this.wQ);
      }
    }
    Rect localRect = this.mTempRect;
    int i;
    int k;
    if (this.wB != null)
    {
      this.wB.getPadding(localRect);
      j = this.wB.getIntrinsicWidth() - localRect.left - localRect.right;
      i = this.wB.getIntrinsicHeight();
      if (!this.wR) {
        break label315;
      }
      k = Math.max(this.xg.getWidth(), this.xh.getWidth()) + this.wL * 2;
      label139:
      this.wZ = Math.max(k, j);
      if (this.wG == null) {
        break label321;
      }
      this.wG.getPadding(localRect);
    }
    for (int j = this.wG.getIntrinsicHeight();; j = m)
    {
      int i1 = localRect.left;
      int n = localRect.right;
      m = i1;
      k = n;
      if (this.wB != null)
      {
        localRect = o.h(this.wB);
        m = Math.max(i1, localRect.left);
        k = Math.max(n, localRect.right);
      }
      k = Math.max(this.wM, m + this.wZ * 2 + k);
      i = Math.max(j, i);
      this.wX = k;
      this.wY = i;
      super.onMeasure(paramInt1, paramInt2);
      if (getMeasuredHeight() < i) {
        setMeasuredDimension(getMeasuredWidthAndState(), i);
      }
      AppMethodBeat.o(199813);
      return;
      i = 0;
      j = 0;
      break;
      label315:
      k = 0;
      break label139;
      label321:
      localRect.setEmpty();
    }
  }
  
  public void onPopulateAccessibilityEvent(AccessibilityEvent paramAccessibilityEvent)
  {
    AppMethodBeat.i(199826);
    super.onPopulateAccessibilityEvent(paramAccessibilityEvent);
    if (isChecked()) {}
    for (CharSequence localCharSequence = this.wP;; localCharSequence = this.wQ)
    {
      if (localCharSequence != null) {
        paramAccessibilityEvent.getText().add(localCharSequence);
      }
      AppMethodBeat.o(199826);
      return;
    }
  }
  
  public boolean onTouchEvent(MotionEvent paramMotionEvent)
  {
    float f3 = 1.0F;
    int j = 0;
    AppMethodBeat.i(199852);
    this.mVelocityTracker.addMovement(paramMotionEvent);
    switch (paramMotionEvent.getActionMasked())
    {
    }
    for (;;)
    {
      boolean bool1 = super.onTouchEvent(paramMotionEvent);
      AppMethodBeat.o(199852);
      return bool1;
      float f1 = paramMotionEvent.getX();
      float f2 = paramMotionEvent.getY();
      if (isEnabled())
      {
        int i = j;
        if (this.wB != null)
        {
          i = getThumbOffset();
          this.wB.getPadding(this.mTempRect);
          int k = this.xb;
          int m = this.mTouchSlop;
          int n = i + this.xa - this.mTouchSlop;
          int i1 = this.wZ;
          int i2 = this.mTempRect.left;
          int i3 = this.mTempRect.right;
          int i4 = this.mTouchSlop;
          int i5 = this.xd;
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
        if (i != 0)
        {
          this.wS = 1;
          this.wT = f1;
          this.wU = f2;
          continue;
          switch (this.wS)
          {
          case 0: 
          default: 
            break;
          case 1: 
            f1 = paramMotionEvent.getX();
            f2 = paramMotionEvent.getY();
            if ((Math.abs(f1 - this.wT) > this.mTouchSlop) || (Math.abs(f2 - this.wU) > this.mTouchSlop))
            {
              this.wS = 2;
              getParent().requestDisallowInterceptTouchEvent(true);
              this.wT = f1;
              this.wU = f2;
              AppMethodBeat.o(199852);
              return true;
            }
            break;
          case 2: 
            float f4 = paramMotionEvent.getX();
            i = getThumbScrollRange();
            f1 = f4 - this.wT;
            if (i != 0)
            {
              f1 /= i;
              f2 = f1;
              if (ai.s(this)) {
                f2 = -f1;
              }
              f2 += this.wW;
              if (f2 >= 0.0F) {
                break label494;
              }
              f1 = 0.0F;
            }
            for (;;)
            {
              if (f1 != this.wW)
              {
                this.wT = f4;
                setThumbPosition(f1);
              }
              AppMethodBeat.o(199852);
              return true;
              if (f1 > 0.0F)
              {
                f1 = 1.0F;
                break;
              }
              f1 = -1.0F;
              break;
              label494:
              f1 = f3;
              if (f2 <= 1.0F) {
                f1 = f2;
              }
            }
            if (this.wS == 2)
            {
              this.wS = 0;
              boolean bool2;
              if ((paramMotionEvent.getAction() == 1) && (isEnabled()))
              {
                i = 1;
                bool2 = isChecked();
                if (i == 0) {
                  break label692;
                }
                this.mVelocityTracker.computeCurrentVelocity(1000);
                f1 = this.mVelocityTracker.getXVelocity();
                if (Math.abs(f1) <= this.wV) {
                  break label683;
                }
                if (!ai.s(this)) {
                  break label665;
                }
                if (f1 >= 0.0F) {
                  break label659;
                }
                bool1 = true;
              }
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
                AppMethodBeat.o(199852);
                return true;
                i = 0;
                break;
                label659:
                bool1 = false;
                continue;
                label665:
                if (f1 > 0.0F)
                {
                  bool1 = true;
                }
                else
                {
                  bool1 = false;
                  continue;
                  label683:
                  bool1 = getTargetCheckedState();
                  continue;
                  label692:
                  bool1 = bool2;
                }
              }
            }
            this.wS = 0;
            this.mVelocityTracker.clear();
          }
        }
      }
    }
  }
  
  public void setChecked(boolean paramBoolean)
  {
    float f = 1.0F;
    AppMethodBeat.i(199884);
    super.setChecked(paramBoolean);
    paramBoolean = isChecked();
    if ((getWindowToken() != null) && (z.au(this)))
    {
      if (paramBoolean) {}
      for (;;)
      {
        this.xj = ObjectAnimator.ofFloat(this, wA, new float[] { f });
        this.xj.setDuration(250L);
        if (Build.VERSION.SDK_INT >= 18) {
          this.xj.setAutoCancel(true);
        }
        this.xj.start();
        AppMethodBeat.o(199884);
        return;
        f = 0.0F;
      }
    }
    if (this.xj != null) {
      this.xj.cancel();
    }
    if (paramBoolean) {}
    for (;;)
    {
      setThumbPosition(f);
      AppMethodBeat.o(199884);
      return;
      f = 0.0F;
    }
  }
  
  public void setCustomSelectionActionModeCallback(ActionMode.Callback paramCallback)
  {
    AppMethodBeat.i(200024);
    super.setCustomSelectionActionModeCallback(j.a(this, paramCallback));
    AppMethodBeat.o(200024);
  }
  
  public void setShowText(boolean paramBoolean)
  {
    AppMethodBeat.i(199792);
    if (this.wR != paramBoolean)
    {
      this.wR = paramBoolean;
      requestLayout();
    }
    AppMethodBeat.o(199792);
  }
  
  public void setSplitTrack(boolean paramBoolean)
  {
    AppMethodBeat.i(199747);
    this.wO = paramBoolean;
    invalidate();
    AppMethodBeat.o(199747);
  }
  
  public void setSwitchMinWidth(int paramInt)
  {
    AppMethodBeat.i(199595);
    this.wM = paramInt;
    requestLayout();
    AppMethodBeat.o(199595);
  }
  
  public void setSwitchPadding(int paramInt)
  {
    AppMethodBeat.i(199576);
    this.wN = paramInt;
    requestLayout();
    AppMethodBeat.o(199576);
  }
  
  public void setSwitchTypeface(Typeface paramTypeface)
  {
    AppMethodBeat.i(199564);
    if (((this.xe.getTypeface() != null) && (!this.xe.getTypeface().equals(paramTypeface))) || ((this.xe.getTypeface() == null) && (paramTypeface != null)))
    {
      this.xe.setTypeface(paramTypeface);
      requestLayout();
      invalidate();
    }
    AppMethodBeat.o(199564);
  }
  
  public void setTextOff(CharSequence paramCharSequence)
  {
    AppMethodBeat.i(199783);
    this.wQ = paramCharSequence;
    requestLayout();
    AppMethodBeat.o(199783);
  }
  
  public void setTextOn(CharSequence paramCharSequence)
  {
    AppMethodBeat.i(199769);
    this.wP = paramCharSequence;
    requestLayout();
    AppMethodBeat.o(199769);
  }
  
  public void setThumbDrawable(Drawable paramDrawable)
  {
    AppMethodBeat.i(199693);
    if (this.wB != null) {
      this.wB.setCallback(null);
    }
    this.wB = paramDrawable;
    if (paramDrawable != null) {
      paramDrawable.setCallback(this);
    }
    requestLayout();
    AppMethodBeat.o(199693);
  }
  
  void setThumbPosition(float paramFloat)
  {
    AppMethodBeat.i(199861);
    this.wW = paramFloat;
    invalidate();
    AppMethodBeat.o(199861);
  }
  
  public void setThumbResource(int paramInt)
  {
    AppMethodBeat.i(199704);
    setThumbDrawable(androidx.appcompat.a.a.a.m(getContext(), paramInt));
    AppMethodBeat.o(199704);
  }
  
  public void setThumbTextPadding(int paramInt)
  {
    AppMethodBeat.i(199616);
    this.wL = paramInt;
    requestLayout();
    AppMethodBeat.o(199616);
  }
  
  public void setThumbTintList(ColorStateList paramColorStateList)
  {
    AppMethodBeat.i(199717);
    this.wC = paramColorStateList;
    this.wE = true;
    fo();
    AppMethodBeat.o(199717);
  }
  
  public void setThumbTintMode(PorterDuff.Mode paramMode)
  {
    AppMethodBeat.i(199733);
    this.wD = paramMode;
    this.wF = true;
    fo();
    AppMethodBeat.o(199733);
  }
  
  public void setTrackDrawable(Drawable paramDrawable)
  {
    AppMethodBeat.i(199634);
    if (this.wG != null) {
      this.wG.setCallback(null);
    }
    this.wG = paramDrawable;
    if (paramDrawable != null) {
      paramDrawable.setCallback(this);
    }
    requestLayout();
    AppMethodBeat.o(199634);
  }
  
  public void setTrackResource(int paramInt)
  {
    AppMethodBeat.i(199645);
    setTrackDrawable(androidx.appcompat.a.a.a.m(getContext(), paramInt));
    AppMethodBeat.o(199645);
  }
  
  public void setTrackTintList(ColorStateList paramColorStateList)
  {
    AppMethodBeat.i(199659);
    this.wH = paramColorStateList;
    this.wJ = true;
    fn();
    AppMethodBeat.o(199659);
  }
  
  public void setTrackTintMode(PorterDuff.Mode paramMode)
  {
    AppMethodBeat.i(199673);
    this.wI = paramMode;
    this.wK = true;
    fn();
    AppMethodBeat.o(199673);
  }
  
  public void toggle()
  {
    AppMethodBeat.i(199872);
    if (!isChecked()) {}
    for (boolean bool = true;; bool = false)
    {
      setChecked(bool);
      AppMethodBeat.o(199872);
      return;
    }
  }
  
  protected boolean verifyDrawable(Drawable paramDrawable)
  {
    AppMethodBeat.i(199984);
    if ((super.verifyDrawable(paramDrawable)) || (paramDrawable == this.wB) || (paramDrawable == this.wG))
    {
      AppMethodBeat.o(199984);
      return true;
    }
    AppMethodBeat.o(199984);
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes10.jar
 * Qualified Name:     androidx.appcompat.widget.SwitchCompat
 * JD-Core Version:    0.7.0.1
 */