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
import androidx.core.g.w;
import androidx.core.widget.i;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.List;

public class SwitchCompat
  extends CompoundButton
{
  private static final Property<SwitchCompat, Float> vE;
  private static final int[] wo;
  private final Rect mTempRect;
  private int mTouchSlop;
  private VelocityTracker mVelocityTracker;
  private Drawable vF;
  private ColorStateList vG;
  private PorterDuff.Mode vH;
  private boolean vI;
  private boolean vJ;
  private Drawable vK;
  private ColorStateList vL;
  private PorterDuff.Mode vM;
  private boolean vN;
  private boolean vO;
  private int vP;
  private int vQ;
  private int vR;
  private boolean vS;
  private CharSequence vT;
  private CharSequence vU;
  private boolean vV;
  private int vW;
  private float vX;
  private float vY;
  private int vZ;
  float wa;
  private int wb;
  private int wc;
  private int wd;
  private int we;
  private int wf;
  private int wg;
  private int wh;
  private final TextPaint wi;
  private ColorStateList wj;
  private Layout wk;
  private Layout wl;
  private TransformationMethod wm;
  ObjectAnimator wn;
  
  static
  {
    AppMethodBeat.i(242006);
    vE = new Property(Float.class, "thumbPos") {};
    wo = new int[] { 16842912 };
    AppMethodBeat.o(242006);
  }
  
  public SwitchCompat(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, a.a.switchStyle);
  }
  
  public SwitchCompat(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    AppMethodBeat.i(241934);
    this.vG = null;
    this.vH = null;
    this.vI = false;
    this.vJ = false;
    this.vL = null;
    this.vM = null;
    this.vN = false;
    this.vO = false;
    this.mVelocityTracker = VelocityTracker.obtain();
    this.mTempRect = new Rect();
    this.wi = new TextPaint(1);
    Object localObject = getResources();
    this.wi.density = ((Resources)localObject).getDisplayMetrics().density;
    localObject = ac.a(paramContext, paramAttributeSet, a.j.SwitchCompat, paramInt, 0);
    this.vF = ((ac)localObject).getDrawable(a.j.SwitchCompat_android_thumb);
    if (this.vF != null) {
      this.vF.setCallback(this);
    }
    this.vK = ((ac)localObject).getDrawable(a.j.SwitchCompat_track);
    if (this.vK != null) {
      this.vK.setCallback(this);
    }
    this.vT = ((ac)localObject).getText(a.j.SwitchCompat_android_textOn);
    this.vU = ((ac)localObject).getText(a.j.SwitchCompat_android_textOff);
    this.vV = ((ac)localObject).c(a.j.SwitchCompat_showText, true);
    this.vP = ((ac)localObject).p(a.j.SwitchCompat_thumbTextPadding, 0);
    this.vQ = ((ac)localObject).p(a.j.SwitchCompat_switchMinWidth, 0);
    this.vR = ((ac)localObject).p(a.j.SwitchCompat_switchPadding, 0);
    this.vS = ((ac)localObject).c(a.j.SwitchCompat_splitTrack, false);
    paramAttributeSet = ((ac)localObject).getColorStateList(a.j.SwitchCompat_thumbTint);
    if (paramAttributeSet != null)
    {
      this.vG = paramAttributeSet;
      this.vI = true;
    }
    paramAttributeSet = o.c(((ac)localObject).getInt(a.j.SwitchCompat_thumbTintMode, -1), null);
    if (this.vH != paramAttributeSet)
    {
      this.vH = paramAttributeSet;
      this.vJ = true;
    }
    if ((this.vI) || (this.vJ)) {
      er();
    }
    paramAttributeSet = ((ac)localObject).getColorStateList(a.j.SwitchCompat_trackTint);
    if (paramAttributeSet != null)
    {
      this.vL = paramAttributeSet;
      this.vN = true;
    }
    paramAttributeSet = o.c(((ac)localObject).getInt(a.j.SwitchCompat_trackTintMode, -1), null);
    if (this.vM != paramAttributeSet)
    {
      this.vM = paramAttributeSet;
      this.vO = true;
    }
    if ((this.vN) || (this.vO)) {
      eq();
    }
    paramInt = ((ac)localObject).r(a.j.SwitchCompat_switchTextAppearance, 0);
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
      this.wj = paramAttributeSet;
      paramInt = localac.p(a.j.TextAppearance_android_textSize, 0);
      if ((paramInt != 0) && (paramInt != this.wi.getTextSize()))
      {
        this.wi.setTextSize(paramInt);
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
            paramAttributeSet = this.wi;
            if ((paramInt & 0x1) == 0) {
              break label745;
            }
            bool = true;
            paramAttributeSet.setFakeBoldText(bool);
            paramAttributeSet = this.wi;
            if ((paramInt & 0x2) == 0) {
              break label751;
            }
            f = -0.25F;
            label610:
            paramAttributeSet.setTextSkewX(f);
            label616:
            if (!localac.c(a.j.TextAppearance_textAllCaps, false)) {
              break label781;
            }
          }
        }
        break;
      }
    }
    label781:
    for (this.wm = new androidx.appcompat.c.a(getContext());; this.wm = null)
    {
      localac.wA.recycle();
      ((ac)localObject).wA.recycle();
      paramContext = ViewConfiguration.get(paramContext);
      this.mTouchSlop = paramContext.getScaledTouchSlop();
      this.vZ = paramContext.getScaledMinimumFlingVelocity();
      refreshDrawableState();
      setChecked(isChecked());
      AppMethodBeat.o(241934);
      return;
      label698:
      this.wj = getTextColors();
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
      this.wi.setFakeBoldText(false);
      this.wi.setTextSkewX(0.0F);
      setSwitchTypeface(paramAttributeSet);
      break label616;
    }
  }
  
  private void eq()
  {
    AppMethodBeat.i(241952);
    if ((this.vK != null) && ((this.vN) || (this.vO)))
    {
      this.vK = this.vK.mutate();
      if (this.vN) {
        androidx.core.graphics.drawable.a.a(this.vK, this.vL);
      }
      if (this.vO) {
        androidx.core.graphics.drawable.a.a(this.vK, this.vM);
      }
      if (this.vK.isStateful()) {
        this.vK.setState(getDrawableState());
      }
    }
    AppMethodBeat.o(241952);
  }
  
  private void er()
  {
    AppMethodBeat.i(241961);
    if ((this.vF != null) && ((this.vI) || (this.vJ)))
    {
      this.vF = this.vF.mutate();
      if (this.vI) {
        androidx.core.graphics.drawable.a.a(this.vF, this.vG);
      }
      if (this.vJ) {
        androidx.core.graphics.drawable.a.a(this.vF, this.vH);
      }
      if (this.vF.isStateful()) {
        this.vF.setState(getDrawableState());
      }
    }
    AppMethodBeat.o(241961);
  }
  
  private boolean getTargetCheckedState()
  {
    return this.wa > 0.5F;
  }
  
  private int getThumbOffset()
  {
    AppMethodBeat.i(241989);
    if (ai.s(this)) {}
    for (float f = 1.0F - this.wa;; f = this.wa)
    {
      int i = (int)(f * getThumbScrollRange() + 0.5F);
      AppMethodBeat.o(241989);
      return i;
    }
  }
  
  private int getThumbScrollRange()
  {
    AppMethodBeat.i(241990);
    if (this.vK != null)
    {
      Rect localRect2 = this.mTempRect;
      this.vK.getPadding(localRect2);
      if (this.vF != null) {}
      for (Rect localRect1 = o.g(this.vF);; localRect1 = o.se)
      {
        int i = this.wb;
        int j = this.wd;
        int k = localRect2.left;
        int m = localRect2.right;
        int n = localRect1.left;
        int i1 = localRect1.right;
        AppMethodBeat.o(241990);
        return i - j - k - m - n - i1;
      }
    }
    AppMethodBeat.o(241990);
    return 0;
  }
  
  private Layout h(CharSequence paramCharSequence)
  {
    AppMethodBeat.i(241973);
    TextPaint localTextPaint;
    if (this.wm != null)
    {
      paramCharSequence = this.wm.getTransformation(paramCharSequence, this);
      localTextPaint = this.wi;
      if (paramCharSequence == null) {
        break label76;
      }
    }
    label76:
    for (int i = (int)Math.ceil(Layout.getDesiredWidth(paramCharSequence, this.wi));; i = 0)
    {
      paramCharSequence = new StaticLayout(paramCharSequence, localTextPaint, i, Layout.Alignment.ALIGN_NORMAL, 1.0F, 0.0F, true);
      AppMethodBeat.o(241973);
      return paramCharSequence;
      break;
    }
  }
  
  public void draw(Canvas paramCanvas)
  {
    AppMethodBeat.i(241983);
    Rect localRect = this.mTempRect;
    int j = this.we;
    int n = this.wf;
    int i2 = this.wg;
    int i1 = this.wh;
    int i3 = j + getThumbOffset();
    Object localObject;
    int i4;
    label145:
    int m;
    int k;
    if (this.vF != null)
    {
      localObject = o.g(this.vF);
      if (this.vK == null) {
        break label352;
      }
      this.vK.getPadding(localRect);
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
      this.vK.setBounds(i, j, m, k);
    }
    label319:
    label326:
    label332:
    label352:
    for (int i = i4 + i3;; i = i3)
    {
      if (this.vF != null)
      {
        this.vF.getPadding(localRect);
        j = i - localRect.left;
        i = i + this.wd + localRect.right;
        this.vF.setBounds(j, n, i, i1);
        localObject = getBackground();
        if (localObject != null) {
          androidx.core.graphics.drawable.a.a((Drawable)localObject, j, n, i, i1);
        }
      }
      super.draw(paramCanvas);
      AppMethodBeat.o(241983);
      return;
      localObject = o.se;
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
    AppMethodBeat.i(241995);
    if (Build.VERSION.SDK_INT >= 21) {
      super.drawableHotspotChanged(paramFloat1, paramFloat2);
    }
    if (this.vF != null) {
      androidx.core.graphics.drawable.a.a(this.vF, paramFloat1, paramFloat2);
    }
    if (this.vK != null) {
      androidx.core.graphics.drawable.a.a(this.vK, paramFloat1, paramFloat2);
    }
    AppMethodBeat.o(241995);
  }
  
  protected void drawableStateChanged()
  {
    AppMethodBeat.i(241993);
    super.drawableStateChanged();
    int[] arrayOfInt = getDrawableState();
    boolean bool2 = false;
    Drawable localDrawable = this.vF;
    boolean bool1 = bool2;
    if (localDrawable != null)
    {
      bool1 = bool2;
      if (localDrawable.isStateful()) {
        bool1 = localDrawable.setState(arrayOfInt) | false;
      }
    }
    localDrawable = this.vK;
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
    AppMethodBeat.o(241993);
  }
  
  public int getCompoundPaddingLeft()
  {
    AppMethodBeat.i(241987);
    if (!ai.s(this))
    {
      i = super.getCompoundPaddingLeft();
      AppMethodBeat.o(241987);
      return i;
    }
    int j = super.getCompoundPaddingLeft() + this.wb;
    int i = j;
    if (!TextUtils.isEmpty(getText())) {
      i = j + this.vR;
    }
    AppMethodBeat.o(241987);
    return i;
  }
  
  public int getCompoundPaddingRight()
  {
    AppMethodBeat.i(241988);
    if (ai.s(this))
    {
      i = super.getCompoundPaddingRight();
      AppMethodBeat.o(241988);
      return i;
    }
    int j = super.getCompoundPaddingRight() + this.wb;
    int i = j;
    if (!TextUtils.isEmpty(getText())) {
      i = j + this.vR;
    }
    AppMethodBeat.o(241988);
    return i;
  }
  
  public boolean getShowText()
  {
    return this.vV;
  }
  
  public boolean getSplitTrack()
  {
    return this.vS;
  }
  
  public int getSwitchMinWidth()
  {
    return this.vQ;
  }
  
  public int getSwitchPadding()
  {
    return this.vR;
  }
  
  public CharSequence getTextOff()
  {
    return this.vU;
  }
  
  public CharSequence getTextOn()
  {
    return this.vT;
  }
  
  public Drawable getThumbDrawable()
  {
    return this.vF;
  }
  
  public int getThumbTextPadding()
  {
    return this.vP;
  }
  
  public ColorStateList getThumbTintList()
  {
    return this.vG;
  }
  
  public PorterDuff.Mode getThumbTintMode()
  {
    return this.vH;
  }
  
  public Drawable getTrackDrawable()
  {
    return this.vK;
  }
  
  public ColorStateList getTrackTintList()
  {
    return this.vL;
  }
  
  public PorterDuff.Mode getTrackTintMode()
  {
    return this.vM;
  }
  
  public void jumpDrawablesToCurrentState()
  {
    AppMethodBeat.i(242001);
    super.jumpDrawablesToCurrentState();
    if (this.vF != null) {
      this.vF.jumpToCurrentState();
    }
    if (this.vK != null) {
      this.vK.jumpToCurrentState();
    }
    if ((this.wn != null) && (this.wn.isStarted()))
    {
      this.wn.end();
      this.wn = null;
    }
    AppMethodBeat.o(242001);
  }
  
  protected int[] onCreateDrawableState(int paramInt)
  {
    AppMethodBeat.i(241991);
    int[] arrayOfInt = super.onCreateDrawableState(paramInt + 1);
    if (isChecked()) {
      mergeDrawableStates(arrayOfInt, wo);
    }
    AppMethodBeat.o(241991);
    return arrayOfInt;
  }
  
  protected void onDraw(Canvas paramCanvas)
  {
    AppMethodBeat.i(241986);
    super.onDraw(paramCanvas);
    Object localObject1 = this.mTempRect;
    Object localObject3 = this.vK;
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
      k = this.wf;
      m = this.wh;
      n = ((Rect)localObject1).top;
      i1 = ((Rect)localObject1).bottom;
      localObject2 = this.vF;
      if (localObject3 != null)
      {
        if ((!this.vS) || (localObject2 == null)) {
          break label334;
        }
        Rect localRect = o.g((Drawable)localObject2);
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
      localObject1 = this.wk;
      label186:
      if (localObject1 != null)
      {
        localObject3 = getDrawableState();
        if (this.wj != null) {
          this.wi.setColor(this.wj.getColorForState((int[])localObject3, 0));
        }
        this.wi.drawableState = ((int[])localObject3);
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
      AppMethodBeat.o(241986);
      return;
      ((Rect)localObject1).setEmpty();
      break;
      ((Drawable)localObject3).draw(paramCanvas);
      break label157;
      localObject1 = this.wl;
      break label186;
    }
  }
  
  public void onInitializeAccessibilityEvent(AccessibilityEvent paramAccessibilityEvent)
  {
    AppMethodBeat.i(242003);
    super.onInitializeAccessibilityEvent(paramAccessibilityEvent);
    paramAccessibilityEvent.setClassName("android.widget.Switch");
    AppMethodBeat.o(242003);
  }
  
  public void onInitializeAccessibilityNodeInfo(AccessibilityNodeInfo paramAccessibilityNodeInfo)
  {
    AppMethodBeat.i(242004);
    super.onInitializeAccessibilityNodeInfo(paramAccessibilityNodeInfo);
    paramAccessibilityNodeInfo.setClassName("android.widget.Switch");
    CharSequence localCharSequence1;
    if (isChecked()) {
      localCharSequence1 = this.vT;
    }
    while (!TextUtils.isEmpty(localCharSequence1))
    {
      CharSequence localCharSequence2 = paramAccessibilityNodeInfo.getText();
      if (TextUtils.isEmpty(localCharSequence2))
      {
        paramAccessibilityNodeInfo.setText(localCharSequence1);
        AppMethodBeat.o(242004);
        return;
        localCharSequence1 = this.vU;
      }
      else
      {
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append(localCharSequence2).append(' ').append(localCharSequence1);
        paramAccessibilityNodeInfo.setText(localStringBuilder);
      }
    }
    AppMethodBeat.o(242004);
  }
  
  protected void onLayout(boolean paramBoolean, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    AppMethodBeat.i(241980);
    super.onLayout(paramBoolean, paramInt1, paramInt2, paramInt3, paramInt4);
    Rect localRect1;
    if (this.vF != null)
    {
      localRect1 = this.mTempRect;
      if (this.vK != null)
      {
        this.vK.getPadding(localRect1);
        Rect localRect2 = o.g(this.vF);
        paramInt2 = Math.max(0, localRect2.left - localRect1.left);
        paramInt1 = Math.max(0, localRect2.right - localRect1.right);
      }
    }
    for (;;)
    {
      if (ai.s(this))
      {
        paramInt3 = getPaddingLeft() + paramInt2;
        paramInt4 = this.wb + paramInt3 - paramInt2 - paramInt1;
        label116:
        switch (getGravity() & 0x70)
        {
        default: 
          paramInt2 = getPaddingTop();
          paramInt1 = this.wc + paramInt2;
        }
      }
      for (;;)
      {
        this.we = paramInt3;
        this.wf = paramInt2;
        this.wh = paramInt1;
        this.wg = paramInt4;
        AppMethodBeat.o(241980);
        return;
        localRect1.setEmpty();
        break;
        paramInt4 = getWidth() - getPaddingRight() - paramInt1;
        paramInt3 = paramInt1 + (paramInt2 + (paramInt4 - this.wb));
        break label116;
        paramInt2 = (getPaddingTop() + getHeight() - getPaddingBottom()) / 2 - this.wc / 2;
        paramInt1 = this.wc + paramInt2;
        continue;
        paramInt1 = getHeight() - getPaddingBottom();
        paramInt2 = paramInt1 - this.wc;
      }
      paramInt1 = 0;
      paramInt2 = 0;
    }
  }
  
  public void onMeasure(int paramInt1, int paramInt2)
  {
    int m = 0;
    AppMethodBeat.i(241970);
    if (this.vV)
    {
      if (this.wk == null) {
        this.wk = h(this.vT);
      }
      if (this.wl == null) {
        this.wl = h(this.vU);
      }
    }
    Rect localRect = this.mTempRect;
    int i;
    int k;
    if (this.vF != null)
    {
      this.vF.getPadding(localRect);
      j = this.vF.getIntrinsicWidth() - localRect.left - localRect.right;
      i = this.vF.getIntrinsicHeight();
      if (!this.vV) {
        break label315;
      }
      k = Math.max(this.wk.getWidth(), this.wl.getWidth()) + this.vP * 2;
      label139:
      this.wd = Math.max(k, j);
      if (this.vK == null) {
        break label321;
      }
      this.vK.getPadding(localRect);
    }
    for (int j = this.vK.getIntrinsicHeight();; j = m)
    {
      int i1 = localRect.left;
      int n = localRect.right;
      m = i1;
      k = n;
      if (this.vF != null)
      {
        localRect = o.g(this.vF);
        m = Math.max(i1, localRect.left);
        k = Math.max(n, localRect.right);
      }
      k = Math.max(this.vQ, m + this.wd * 2 + k);
      i = Math.max(j, i);
      this.wb = k;
      this.wc = i;
      super.onMeasure(paramInt1, paramInt2);
      if (getMeasuredHeight() < i) {
        setMeasuredDimension(getMeasuredWidthAndState(), i);
      }
      AppMethodBeat.o(241970);
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
    AppMethodBeat.i(241972);
    super.onPopulateAccessibilityEvent(paramAccessibilityEvent);
    if (isChecked()) {}
    for (CharSequence localCharSequence = this.vT;; localCharSequence = this.vU)
    {
      if (localCharSequence != null) {
        paramAccessibilityEvent.getText().add(localCharSequence);
      }
      AppMethodBeat.o(241972);
      return;
    }
  }
  
  public boolean onTouchEvent(MotionEvent paramMotionEvent)
  {
    float f3 = 1.0F;
    int j = 0;
    AppMethodBeat.i(241974);
    this.mVelocityTracker.addMovement(paramMotionEvent);
    switch (paramMotionEvent.getActionMasked())
    {
    }
    for (;;)
    {
      boolean bool1 = super.onTouchEvent(paramMotionEvent);
      AppMethodBeat.o(241974);
      return bool1;
      float f1 = paramMotionEvent.getX();
      float f2 = paramMotionEvent.getY();
      if (isEnabled())
      {
        int i = j;
        if (this.vF != null)
        {
          i = getThumbOffset();
          this.vF.getPadding(this.mTempRect);
          int k = this.wf;
          int m = this.mTouchSlop;
          int n = i + this.we - this.mTouchSlop;
          int i1 = this.wd;
          int i2 = this.mTempRect.left;
          int i3 = this.mTempRect.right;
          int i4 = this.mTouchSlop;
          int i5 = this.wh;
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
          this.vW = 1;
          this.vX = f1;
          this.vY = f2;
          continue;
          switch (this.vW)
          {
          case 0: 
          default: 
            break;
          case 1: 
            f1 = paramMotionEvent.getX();
            f2 = paramMotionEvent.getY();
            if ((Math.abs(f1 - this.vX) > this.mTouchSlop) || (Math.abs(f2 - this.vY) > this.mTouchSlop))
            {
              this.vW = 2;
              getParent().requestDisallowInterceptTouchEvent(true);
              this.vX = f1;
              this.vY = f2;
              AppMethodBeat.o(241974);
              return true;
            }
            break;
          case 2: 
            float f4 = paramMotionEvent.getX();
            i = getThumbScrollRange();
            f1 = f4 - this.vX;
            if (i != 0)
            {
              f1 /= i;
              f2 = f1;
              if (ai.s(this)) {
                f2 = -f1;
              }
              f2 += this.wa;
              if (f2 >= 0.0F) {
                break label494;
              }
              f1 = 0.0F;
            }
            for (;;)
            {
              if (f1 != this.wa)
              {
                this.vX = f4;
                setThumbPosition(f1);
              }
              AppMethodBeat.o(241974);
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
            if (this.vW == 2)
            {
              this.vW = 0;
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
                if (Math.abs(f1) <= this.vZ) {
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
                AppMethodBeat.o(241974);
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
            this.vW = 0;
            this.mVelocityTracker.clear();
          }
        }
      }
    }
  }
  
  public void setChecked(boolean paramBoolean)
  {
    float f = 1.0F;
    AppMethodBeat.i(241977);
    super.setChecked(paramBoolean);
    paramBoolean = isChecked();
    if ((getWindowToken() != null) && (w.ah(this)))
    {
      if (paramBoolean) {}
      for (;;)
      {
        this.wn = ObjectAnimator.ofFloat(this, vE, new float[] { f });
        this.wn.setDuration(250L);
        if (Build.VERSION.SDK_INT >= 18) {
          this.wn.setAutoCancel(true);
        }
        this.wn.start();
        AppMethodBeat.o(241977);
        return;
        f = 0.0F;
      }
    }
    if (this.wn != null) {
      this.wn.cancel();
    }
    if (paramBoolean) {}
    for (;;)
    {
      setThumbPosition(f);
      AppMethodBeat.o(241977);
      return;
      f = 0.0F;
    }
  }
  
  public void setCustomSelectionActionModeCallback(ActionMode.Callback paramCallback)
  {
    AppMethodBeat.i(242005);
    super.setCustomSelectionActionModeCallback(i.a(this, paramCallback));
    AppMethodBeat.o(242005);
  }
  
  public void setShowText(boolean paramBoolean)
  {
    AppMethodBeat.i(241967);
    if (this.vV != paramBoolean)
    {
      this.vV = paramBoolean;
      requestLayout();
    }
    AppMethodBeat.o(241967);
  }
  
  public void setSplitTrack(boolean paramBoolean)
  {
    AppMethodBeat.i(241962);
    this.vS = paramBoolean;
    invalidate();
    AppMethodBeat.o(241962);
  }
  
  public void setSwitchMinWidth(int paramInt)
  {
    AppMethodBeat.i(241939);
    this.vQ = paramInt;
    requestLayout();
    AppMethodBeat.o(241939);
  }
  
  public void setSwitchPadding(int paramInt)
  {
    AppMethodBeat.i(241937);
    this.vR = paramInt;
    requestLayout();
    AppMethodBeat.o(241937);
  }
  
  public void setSwitchTypeface(Typeface paramTypeface)
  {
    AppMethodBeat.i(241936);
    if (((this.wi.getTypeface() != null) && (!this.wi.getTypeface().equals(paramTypeface))) || ((this.wi.getTypeface() == null) && (paramTypeface != null)))
    {
      this.wi.setTypeface(paramTypeface);
      requestLayout();
      invalidate();
    }
    AppMethodBeat.o(241936);
  }
  
  public void setTextOff(CharSequence paramCharSequence)
  {
    AppMethodBeat.i(241966);
    this.vU = paramCharSequence;
    requestLayout();
    AppMethodBeat.o(241966);
  }
  
  public void setTextOn(CharSequence paramCharSequence)
  {
    AppMethodBeat.i(241964);
    this.vT = paramCharSequence;
    requestLayout();
    AppMethodBeat.o(241964);
  }
  
  public void setThumbDrawable(Drawable paramDrawable)
  {
    AppMethodBeat.i(241954);
    if (this.vF != null) {
      this.vF.setCallback(null);
    }
    this.vF = paramDrawable;
    if (paramDrawable != null) {
      paramDrawable.setCallback(this);
    }
    requestLayout();
    AppMethodBeat.o(241954);
  }
  
  void setThumbPosition(float paramFloat)
  {
    AppMethodBeat.i(241975);
    this.wa = paramFloat;
    invalidate();
    AppMethodBeat.o(241975);
  }
  
  public void setThumbResource(int paramInt)
  {
    AppMethodBeat.i(241955);
    setThumbDrawable(androidx.appcompat.a.a.a.m(getContext(), paramInt));
    AppMethodBeat.o(241955);
  }
  
  public void setThumbTextPadding(int paramInt)
  {
    AppMethodBeat.i(241941);
    this.vP = paramInt;
    requestLayout();
    AppMethodBeat.o(241941);
  }
  
  public void setThumbTintList(ColorStateList paramColorStateList)
  {
    AppMethodBeat.i(241957);
    this.vG = paramColorStateList;
    this.vI = true;
    er();
    AppMethodBeat.o(241957);
  }
  
  public void setThumbTintMode(PorterDuff.Mode paramMode)
  {
    AppMethodBeat.i(241960);
    this.vH = paramMode;
    this.vJ = true;
    er();
    AppMethodBeat.o(241960);
  }
  
  public void setTrackDrawable(Drawable paramDrawable)
  {
    AppMethodBeat.i(241942);
    if (this.vK != null) {
      this.vK.setCallback(null);
    }
    this.vK = paramDrawable;
    if (paramDrawable != null) {
      paramDrawable.setCallback(this);
    }
    requestLayout();
    AppMethodBeat.o(241942);
  }
  
  public void setTrackResource(int paramInt)
  {
    AppMethodBeat.i(241944);
    setTrackDrawable(androidx.appcompat.a.a.a.m(getContext(), paramInt));
    AppMethodBeat.o(241944);
  }
  
  public void setTrackTintList(ColorStateList paramColorStateList)
  {
    AppMethodBeat.i(241947);
    this.vL = paramColorStateList;
    this.vN = true;
    eq();
    AppMethodBeat.o(241947);
  }
  
  public void setTrackTintMode(PorterDuff.Mode paramMode)
  {
    AppMethodBeat.i(241948);
    this.vM = paramMode;
    this.vO = true;
    eq();
    AppMethodBeat.o(241948);
  }
  
  public void toggle()
  {
    AppMethodBeat.i(241976);
    if (!isChecked()) {}
    for (boolean bool = true;; bool = false)
    {
      setChecked(bool);
      AppMethodBeat.o(241976);
      return;
    }
  }
  
  protected boolean verifyDrawable(Drawable paramDrawable)
  {
    AppMethodBeat.i(241998);
    if ((super.verifyDrawable(paramDrawable)) || (paramDrawable == this.vF) || (paramDrawable == this.vK))
    {
      AppMethodBeat.o(241998);
      return true;
    }
    AppMethodBeat.o(241998);
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     androidx.appcompat.widget.SwitchCompat
 * JD-Core Version:    0.7.0.1
 */