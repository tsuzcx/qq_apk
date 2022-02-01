package com.google.android.material.chip;

import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Outline;
import android.graphics.Paint;
import android.graphics.Paint.Align;
import android.graphics.Paint.FontMetrics;
import android.graphics.Paint.Style;
import android.graphics.PointF;
import android.graphics.PorterDuff.Mode;
import android.graphics.PorterDuffColorFilter;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.Typeface;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.Drawable.Callback;
import android.os.Build.VERSION;
import android.text.TextPaint;
import android.text.TextUtils;
import android.text.TextUtils.TruncateAt;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import androidx.core.content.a.f.c;
import androidx.core.graphics.drawable.e;
import com.google.android.material.a.k;
import com.google.android.material.a.h;
import com.google.android.material.internal.k;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.lang.ref.WeakReference;
import java.util.Arrays;

public class a
  extends Drawable
  implements Drawable.Callback, e
{
  private static final int[] drJ = { 16842910 };
  private int alpha;
  private final RectF avO;
  final Context context;
  private final f.c drH;
  ColorStateList drK;
  float drL;
  float drM;
  ColorStateList drN;
  float drO;
  CharSequence drP;
  private CharSequence drQ;
  com.google.android.material.e.b drR;
  boolean drS;
  private Drawable drT;
  ColorStateList drU;
  float drV;
  boolean drW;
  Drawable drX;
  ColorStateList drY;
  float drZ;
  ColorStateList drj;
  private ColorFilter dsA;
  private PorterDuffColorFilter dsB;
  private ColorStateList dsC;
  private PorterDuff.Mode dsD;
  private int[] dsE;
  private boolean dsF;
  private ColorStateList dsG;
  private WeakReference<a> dsH;
  private boolean dsI;
  private float dsJ;
  TextUtils.TruncateAt dsK;
  boolean dsL;
  CharSequence dsa;
  boolean dsb;
  boolean dsc;
  Drawable dsd;
  h dse;
  h dsf;
  float dsg;
  float dsh;
  float dsi;
  float dsj;
  float dsk;
  float dsl;
  float dsm;
  float dsn;
  private final TextPaint dso;
  private final Paint dsp;
  private final Paint dsq;
  private final Paint.FontMetrics dsr;
  private final PointF dss;
  private int dsu;
  private int dsv;
  private int dsw;
  private int dsx;
  private boolean dsy;
  private int dsz;
  int maxWidth;
  
  private a(Context paramContext)
  {
    AppMethodBeat.i(208989);
    this.drH = new f.c()
    {
      public final void as(int paramAnonymousInt) {}
      
      public final void b(Typeface paramAnonymousTypeface)
      {
        AppMethodBeat.i(209006);
        a.a(a.this);
        a.this.Wc();
        a.this.invalidateSelf();
        AppMethodBeat.o(209006);
      }
    };
    this.dso = new TextPaint(1);
    this.dsp = new Paint(1);
    this.dsr = new Paint.FontMetrics();
    this.avO = new RectF();
    this.dss = new PointF();
    this.alpha = 255;
    this.dsD = PorterDuff.Mode.SRC_IN;
    this.dsH = new WeakReference(null);
    this.dsI = true;
    this.context = paramContext;
    this.drP = "";
    this.dso.density = paramContext.getResources().getDisplayMetrics().density;
    this.dsq = null;
    if (this.dsq != null) {
      this.dsq.setStyle(Paint.Style.STROKE);
    }
    setState(drJ);
    q(drJ);
    this.dsL = true;
    AppMethodBeat.o(208989);
  }
  
  private float B(CharSequence paramCharSequence)
  {
    AppMethodBeat.i(209031);
    if (paramCharSequence == null)
    {
      AppMethodBeat.o(209031);
      return 0.0F;
    }
    float f = this.dso.measureText(paramCharSequence, 0, paramCharSequence.length());
    AppMethodBeat.o(209031);
    return f;
  }
  
  static boolean H(Drawable paramDrawable)
  {
    AppMethodBeat.i(209101);
    if ((paramDrawable != null) && (paramDrawable.isStateful()))
    {
      AppMethodBeat.o(209101);
      return true;
    }
    AppMethodBeat.o(209101);
    return false;
  }
  
  private static void I(Drawable paramDrawable)
  {
    AppMethodBeat.i(209112);
    if (paramDrawable != null) {
      paramDrawable.setCallback(null);
    }
    AppMethodBeat.o(209112);
  }
  
  private void J(Drawable paramDrawable)
  {
    AppMethodBeat.i(209126);
    if (paramDrawable != null)
    {
      paramDrawable.setCallback(this);
      androidx.core.graphics.drawable.a.b(paramDrawable, androidx.core.graphics.drawable.a.u(this));
      paramDrawable.setLevel(getLevel());
      paramDrawable.setVisible(isVisible(), false);
      if (paramDrawable == this.drX)
      {
        if (paramDrawable.isStateful()) {
          paramDrawable.setState(this.dsE);
        }
        androidx.core.graphics.drawable.a.a(paramDrawable, this.drY);
        AppMethodBeat.o(209126);
        return;
      }
      if (paramDrawable.isStateful()) {
        paramDrawable.setState(getState());
      }
    }
    AppMethodBeat.o(209126);
  }
  
  private boolean Wd()
  {
    return (this.drS) && (this.drT != null);
  }
  
  private boolean We()
  {
    return (this.dsc) && (this.dsd != null) && (this.dsy);
  }
  
  private boolean Wf()
  {
    return (this.drW) && (this.drX != null);
  }
  
  private float Wh()
  {
    AppMethodBeat.i(209022);
    if (!this.dsI)
    {
      f = this.dsJ;
      AppMethodBeat.o(209022);
      return f;
    }
    this.dsJ = B(this.drQ);
    this.dsI = false;
    float f = this.dsJ;
    AppMethodBeat.o(209022);
    return f;
  }
  
  private float Wi()
  {
    AppMethodBeat.i(209040);
    if (Wf())
    {
      float f1 = this.dsl;
      float f2 = this.drZ;
      float f3 = this.dsm;
      AppMethodBeat.o(209040);
      return f1 + f2 + f3;
    }
    AppMethodBeat.o(209040);
    return 0.0F;
  }
  
  private ColorFilter Wj()
  {
    if (this.dsA != null) {
      return this.dsA;
    }
    return this.dsB;
  }
  
  private void Wk()
  {
    AppMethodBeat.i(209151);
    if (this.dsF) {}
    for (ColorStateList localColorStateList = com.google.android.material.f.a.g(this.drj);; localColorStateList = null)
    {
      this.dsG = localColorStateList;
      AppMethodBeat.o(209151);
      return;
    }
  }
  
  private void a(Rect paramRect, RectF paramRectF)
  {
    AppMethodBeat.i(209059);
    paramRectF.setEmpty();
    float f;
    if ((Wd()) || (We()))
    {
      f = this.dsg + this.dsh;
      if (androidx.core.graphics.drawable.a.u(this) != 0) {
        break label100;
      }
      paramRectF.left = (f + paramRect.left);
      paramRectF.right = (paramRectF.left + this.drV);
    }
    for (;;)
    {
      paramRectF.top = (paramRect.exactCenterY() - this.drV / 2.0F);
      paramRectF.bottom = (paramRectF.top + this.drV);
      AppMethodBeat.o(209059);
      return;
      label100:
      paramRectF.right = (paramRect.right - f);
      paramRectF.left = (paramRectF.right - this.drV);
    }
  }
  
  public static a b(Context paramContext, AttributeSet paramAttributeSet, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(208981);
    a locala = new a(paramContext);
    TypedArray localTypedArray = k.a(locala.context, paramAttributeSet, a.k.Chip, paramInt1, paramInt2, new int[0]);
    locala.setChipBackgroundColor(com.google.android.material.e.a.b(locala.context, localTypedArray, a.k.Chip_chipBackgroundColor));
    locala.setChipMinHeight(localTypedArray.getDimension(a.k.Chip_chipMinHeight, 0.0F));
    locala.setChipCornerRadius(localTypedArray.getDimension(a.k.Chip_chipCornerRadius, 0.0F));
    locala.setChipStrokeColor(com.google.android.material.e.a.b(locala.context, localTypedArray, a.k.Chip_chipStrokeColor));
    locala.setChipStrokeWidth(localTypedArray.getDimension(a.k.Chip_chipStrokeWidth, 0.0F));
    locala.setRippleColor(com.google.android.material.e.a.b(locala.context, localTypedArray, a.k.Chip_rippleColor));
    locala.setText(localTypedArray.getText(a.k.Chip_android_text));
    paramContext = locala.context;
    paramInt1 = a.k.Chip_android_textAppearance;
    if (localTypedArray.hasValue(paramInt1))
    {
      paramInt1 = localTypedArray.getResourceId(paramInt1, 0);
      if (paramInt1 != 0)
      {
        paramContext = new com.google.android.material.e.b(paramContext, paramInt1);
        locala.setTextAppearance(paramContext);
        switch (localTypedArray.getInt(a.k.Chip_android_ellipsize, 0))
        {
        }
      }
    }
    for (;;)
    {
      locala.setChipIconVisible(localTypedArray.getBoolean(a.k.Chip_chipIconVisible, false));
      if ((paramAttributeSet != null) && (paramAttributeSet.getAttributeValue("http://schemas.android.com/apk/res-auto", "chipIconEnabled") != null) && (paramAttributeSet.getAttributeValue("http://schemas.android.com/apk/res-auto", "chipIconVisible") == null)) {
        locala.setChipIconVisible(localTypedArray.getBoolean(a.k.Chip_chipIconEnabled, false));
      }
      locala.setChipIcon(com.google.android.material.e.a.c(locala.context, localTypedArray, a.k.Chip_chipIcon));
      locala.setChipIconTint(com.google.android.material.e.a.b(locala.context, localTypedArray, a.k.Chip_chipIconTint));
      locala.setChipIconSize(localTypedArray.getDimension(a.k.Chip_chipIconSize, 0.0F));
      locala.setCloseIconVisible(localTypedArray.getBoolean(a.k.Chip_closeIconVisible, false));
      if ((paramAttributeSet != null) && (paramAttributeSet.getAttributeValue("http://schemas.android.com/apk/res-auto", "closeIconEnabled") != null) && (paramAttributeSet.getAttributeValue("http://schemas.android.com/apk/res-auto", "closeIconVisible") == null)) {
        locala.setCloseIconVisible(localTypedArray.getBoolean(a.k.Chip_closeIconEnabled, false));
      }
      locala.setCloseIcon(com.google.android.material.e.a.c(locala.context, localTypedArray, a.k.Chip_closeIcon));
      locala.setCloseIconTint(com.google.android.material.e.a.b(locala.context, localTypedArray, a.k.Chip_closeIconTint));
      locala.setCloseIconSize(localTypedArray.getDimension(a.k.Chip_closeIconSize, 0.0F));
      locala.setCheckable(localTypedArray.getBoolean(a.k.Chip_android_checkable, false));
      locala.setCheckedIconVisible(localTypedArray.getBoolean(a.k.Chip_checkedIconVisible, false));
      if ((paramAttributeSet != null) && (paramAttributeSet.getAttributeValue("http://schemas.android.com/apk/res-auto", "checkedIconEnabled") != null) && (paramAttributeSet.getAttributeValue("http://schemas.android.com/apk/res-auto", "checkedIconVisible") == null)) {
        locala.setCheckedIconVisible(localTypedArray.getBoolean(a.k.Chip_checkedIconEnabled, false));
      }
      locala.setCheckedIcon(com.google.android.material.e.a.c(locala.context, localTypedArray, a.k.Chip_checkedIcon));
      locala.dse = h.a(locala.context, localTypedArray, a.k.Chip_showMotionSpec);
      locala.dsf = h.a(locala.context, localTypedArray, a.k.Chip_hideMotionSpec);
      locala.setChipStartPadding(localTypedArray.getDimension(a.k.Chip_chipStartPadding, 0.0F));
      locala.setIconStartPadding(localTypedArray.getDimension(a.k.Chip_iconStartPadding, 0.0F));
      locala.setIconEndPadding(localTypedArray.getDimension(a.k.Chip_iconEndPadding, 0.0F));
      locala.setTextStartPadding(localTypedArray.getDimension(a.k.Chip_textStartPadding, 0.0F));
      locala.setTextEndPadding(localTypedArray.getDimension(a.k.Chip_textEndPadding, 0.0F));
      locala.setCloseIconStartPadding(localTypedArray.getDimension(a.k.Chip_closeIconStartPadding, 0.0F));
      locala.setCloseIconEndPadding(localTypedArray.getDimension(a.k.Chip_closeIconEndPadding, 0.0F));
      locala.setChipEndPadding(localTypedArray.getDimension(a.k.Chip_chipEndPadding, 0.0F));
      locala.maxWidth = localTypedArray.getDimensionPixelSize(a.k.Chip_android_maxWidth, 2147483647);
      localTypedArray.recycle();
      AppMethodBeat.o(208981);
      return locala;
      paramContext = null;
      break;
      locala.dsK = TextUtils.TruncateAt.START;
      continue;
      locala.dsK = TextUtils.TruncateAt.MIDDLE;
      continue;
      locala.dsK = TextUtils.TruncateAt.END;
    }
  }
  
  private void b(Rect paramRect, RectF paramRectF)
  {
    AppMethodBeat.i(209068);
    paramRectF.setEmpty();
    float f;
    if (Wf())
    {
      f = this.dsn + this.dsm;
      if (androidx.core.graphics.drawable.a.u(this) != 0) {
        break label93;
      }
      paramRectF.right = (paramRect.right - f);
      paramRectF.left = (paramRectF.right - this.drZ);
    }
    for (;;)
    {
      paramRectF.top = (paramRect.exactCenterY() - this.drZ / 2.0F);
      paramRectF.bottom = (paramRectF.top + this.drZ);
      AppMethodBeat.o(209068);
      return;
      label93:
      paramRectF.left = (f + paramRect.left);
      paramRectF.right = (paramRectF.left + this.drZ);
    }
  }
  
  private boolean b(int[] paramArrayOfInt1, int[] paramArrayOfInt2)
  {
    int j = 0;
    boolean bool3 = true;
    AppMethodBeat.i(209080);
    boolean bool1 = super.onStateChange(paramArrayOfInt1);
    int i;
    if (this.drK != null)
    {
      i = this.drK.getColorForState(paramArrayOfInt1, this.dsu);
      if (this.dsu == i) {
        break label485;
      }
      this.dsu = i;
      bool1 = true;
    }
    label79:
    label227:
    label485:
    for (;;)
    {
      label118:
      boolean bool2;
      if (this.drN != null)
      {
        i = this.drN.getColorForState(paramArrayOfInt1, this.dsv);
        if (this.dsv != i)
        {
          this.dsv = i;
          bool1 = true;
        }
        if (this.dsG == null) {
          break label445;
        }
        i = this.dsG.getColorForState(paramArrayOfInt1, this.dsw);
        bool2 = bool1;
        if (this.dsw != i)
        {
          this.dsw = i;
          bool2 = bool1;
          if (this.dsF) {
            bool2 = true;
          }
        }
        if ((this.drR == null) || (this.drR.dvK == null)) {
          break label451;
        }
        i = this.drR.dvK.getColorForState(paramArrayOfInt1, this.dsx);
        bool1 = bool2;
        if (this.dsx != i)
        {
          this.dsx = i;
          bool1 = true;
        }
        if ((!r(getState())) || (!this.dsb)) {
          break label457;
        }
        bool2 = true;
        if ((this.dsy == bool2) || (this.dsd == null)) {
          break label479;
        }
        float f = Wg();
        this.dsy = bool2;
        if (f == Wg()) {
          break label470;
        }
        i = 1;
        bool1 = true;
      }
      for (;;)
      {
        if (this.dsC != null) {
          j = this.dsC.getColorForState(paramArrayOfInt1, this.dsz);
        }
        if (this.dsz != j)
        {
          this.dsz = j;
          this.dsB = com.google.android.material.b.a.a(this, this.dsC, this.dsD);
        }
        for (bool2 = bool3;; bool2 = bool1)
        {
          bool1 = bool2;
          if (H(this.drT)) {
            bool1 = bool2 | this.drT.setState(paramArrayOfInt1);
          }
          bool2 = bool1;
          if (H(this.dsd)) {
            bool2 = bool1 | this.dsd.setState(paramArrayOfInt1);
          }
          bool1 = bool2;
          if (H(this.drX)) {
            bool1 = bool2 | this.drX.setState(paramArrayOfInt2);
          }
          if (bool1) {
            invalidateSelf();
          }
          if (i != 0) {
            Wc();
          }
          AppMethodBeat.o(209080);
          return bool1;
          i = 0;
          break;
          i = 0;
          break label79;
          i = 0;
          break label118;
          i = 0;
          break label185;
          bool2 = false;
          break label227;
        }
        i = 0;
        bool1 = true;
        continue;
        i = 0;
      }
    }
  }
  
  private static boolean c(ColorStateList paramColorStateList)
  {
    AppMethodBeat.i(209092);
    if ((paramColorStateList != null) && (paramColorStateList.isStateful()))
    {
      AppMethodBeat.o(209092);
      return true;
    }
    AppMethodBeat.o(209092);
    return false;
  }
  
  private static boolean r(int[] paramArrayOfInt)
  {
    if (paramArrayOfInt == null) {}
    for (;;)
    {
      return false;
      int j = paramArrayOfInt.length;
      int i = 0;
      while (i < j)
      {
        if (paramArrayOfInt[i] == 16842912) {
          return true;
        }
        i += 1;
      }
    }
  }
  
  protected final void Wc()
  {
    AppMethodBeat.i(209217);
    a locala = (a)this.dsH.get();
    if (locala != null) {
      locala.VX();
    }
    AppMethodBeat.o(209217);
  }
  
  final float Wg()
  {
    AppMethodBeat.i(209246);
    if ((Wd()) || (We()))
    {
      float f1 = this.dsh;
      float f2 = this.drV;
      float f3 = this.dsi;
      AppMethodBeat.o(209246);
      return f1 + f2 + f3;
    }
    AppMethodBeat.o(209246);
    return 0.0F;
  }
  
  public final void a(a parama)
  {
    AppMethodBeat.i(209204);
    this.dsH = new WeakReference(parama);
    AppMethodBeat.o(209204);
  }
  
  public final void bN(boolean paramBoolean)
  {
    AppMethodBeat.i(209193);
    if (this.dsF != paramBoolean)
    {
      this.dsF = paramBoolean;
      Wk();
      onStateChange(getState());
    }
    AppMethodBeat.o(209193);
  }
  
  final void c(Rect paramRect, RectF paramRectF)
  {
    AppMethodBeat.i(209284);
    paramRectF.setEmpty();
    float f;
    if (Wf())
    {
      f = this.dsn + this.dsm + this.drZ + this.dsl + this.dsk;
      if (androidx.core.graphics.drawable.a.u(this) != 0) {
        break label93;
      }
      paramRectF.right = paramRect.right;
      paramRectF.left = (paramRectF.right - f);
    }
    for (;;)
    {
      paramRectF.top = paramRect.top;
      paramRectF.bottom = paramRect.bottom;
      AppMethodBeat.o(209284);
      return;
      label93:
      paramRectF.left = paramRect.left;
      paramRectF.right = (f + paramRect.left);
    }
  }
  
  public void draw(Canvas paramCanvas)
  {
    AppMethodBeat.i(209273);
    Rect localRect = getBounds();
    if ((localRect.isEmpty()) || (getAlpha() == 0))
    {
      AppMethodBeat.o(209273);
      return;
    }
    float f1;
    float f2;
    float f3;
    float f4;
    int i;
    if (this.alpha < 255)
    {
      f1 = localRect.left;
      f2 = localRect.top;
      f3 = localRect.right;
      f4 = localRect.bottom;
      i = this.alpha;
      if (Build.VERSION.SDK_INT > 21) {
        i = paramCanvas.saveLayerAlpha(f1, f2, f3, f4, i);
      }
    }
    for (;;)
    {
      this.dsp.setColor(this.dsu);
      this.dsp.setStyle(Paint.Style.FILL);
      this.dsp.setColorFilter(Wj());
      this.avO.set(localRect);
      paramCanvas.drawRoundRect(this.avO, this.drM, this.drM, this.dsp);
      if (this.drO > 0.0F)
      {
        this.dsp.setColor(this.dsv);
        this.dsp.setStyle(Paint.Style.STROKE);
        this.dsp.setColorFilter(Wj());
        this.avO.set(localRect.left + this.drO / 2.0F, localRect.top + this.drO / 2.0F, localRect.right - this.drO / 2.0F, localRect.bottom - this.drO / 2.0F);
        f1 = this.drM - this.drO / 2.0F;
        paramCanvas.drawRoundRect(this.avO, f1, f1, this.dsp);
      }
      this.dsp.setColor(this.dsw);
      this.dsp.setStyle(Paint.Style.FILL);
      this.avO.set(localRect);
      paramCanvas.drawRoundRect(this.avO, this.drM, this.drM, this.dsp);
      if (Wd())
      {
        a(localRect, this.avO);
        f1 = this.avO.left;
        f2 = this.avO.top;
        paramCanvas.translate(f1, f2);
        this.drT.setBounds(0, 0, (int)this.avO.width(), (int)this.avO.height());
        this.drT.draw(paramCanvas);
        paramCanvas.translate(-f1, -f2);
      }
      if (We())
      {
        a(localRect, this.avO);
        f1 = this.avO.left;
        f2 = this.avO.top;
        paramCanvas.translate(f1, f2);
        this.dsd.setBounds(0, 0, (int)this.avO.width(), (int)this.avO.height());
        this.dsd.draw(paramCanvas);
        paramCanvas.translate(-f1, -f2);
      }
      Object localObject2;
      Object localObject1;
      label580:
      int j;
      label704:
      int k;
      if ((this.dsL) && (this.drQ != null))
      {
        localObject2 = this.dss;
        ((PointF)localObject2).set(0.0F, 0.0F);
        localObject1 = Paint.Align.LEFT;
        if (this.drQ != null)
        {
          f1 = this.dsg + Wg() + this.dsj;
          if (androidx.core.graphics.drawable.a.u(this) != 0) {
            break label1293;
          }
          ((PointF)localObject2).x = (f1 + localRect.left);
          localObject1 = Paint.Align.LEFT;
          f1 = localRect.centerY();
          this.dso.getFontMetrics(this.dsr);
          ((PointF)localObject2).y = (f1 - (this.dsr.descent + this.dsr.ascent) / 2.0F);
        }
        localObject2 = this.avO;
        ((RectF)localObject2).setEmpty();
        if (this.drQ != null)
        {
          f1 = this.dsg + Wg() + this.dsj;
          f2 = this.dsn + Wi() + this.dsk;
          if (androidx.core.graphics.drawable.a.u(this) != 0) {
            break label1314;
          }
          ((RectF)localObject2).left = (f1 + localRect.left);
          ((RectF)localObject2).right = (localRect.right - f2);
          ((RectF)localObject2).top = localRect.top;
          ((RectF)localObject2).bottom = localRect.bottom;
        }
        if (this.drR != null)
        {
          this.dso.drawableState = getState();
          this.drR.b(this.context, this.dso, this.drH);
        }
        this.dso.setTextAlign((Paint.Align)localObject1);
        if (Math.round(Wh()) <= Math.round(this.avO.width())) {
          break label1343;
        }
        j = 1;
        label795:
        if (j == 0) {
          break label1365;
        }
        k = paramCanvas.save();
        paramCanvas.clipRect(this.avO);
      }
      for (;;)
      {
        localObject2 = this.drQ;
        localObject1 = localObject2;
        if (j != 0)
        {
          localObject1 = localObject2;
          if (this.dsK != null) {
            localObject1 = TextUtils.ellipsize(this.drQ, this.dso, this.avO.width(), this.dsK);
          }
        }
        paramCanvas.drawText((CharSequence)localObject1, 0, ((CharSequence)localObject1).length(), this.dss.x, this.dss.y, this.dso);
        if (j != 0) {
          paramCanvas.restoreToCount(k);
        }
        if (Wf())
        {
          b(localRect, this.avO);
          f1 = this.avO.left;
          f2 = this.avO.top;
          paramCanvas.translate(f1, f2);
          this.drX.setBounds(0, 0, (int)this.avO.width(), (int)this.avO.height());
          this.drX.draw(paramCanvas);
          paramCanvas.translate(-f1, -f2);
        }
        if (this.dsq != null)
        {
          this.dsq.setColor(androidx.core.graphics.b.ax(-16777216, 127));
          paramCanvas.drawRect(localRect, this.dsq);
          if ((Wd()) || (We()))
          {
            a(localRect, this.avO);
            paramCanvas.drawRect(this.avO, this.dsq);
          }
          if (this.drQ != null) {
            paramCanvas.drawLine(localRect.left, localRect.exactCenterY(), localRect.right, localRect.exactCenterY(), this.dsq);
          }
          if (Wf())
          {
            b(localRect, this.avO);
            paramCanvas.drawRect(this.avO, this.dsq);
          }
          this.dsq.setColor(androidx.core.graphics.b.ax(-65536, 127));
          localObject1 = this.avO;
          ((RectF)localObject1).set(localRect);
          if (Wf())
          {
            f1 = this.dsn + this.dsm + this.drZ + this.dsl + this.dsk;
            if (androidx.core.graphics.drawable.a.u(this) != 0) {
              break label1349;
            }
            ((RectF)localObject1).right = (localRect.right - f1);
          }
        }
        for (;;)
        {
          paramCanvas.drawRect(this.avO, this.dsq);
          this.dsq.setColor(androidx.core.graphics.b.ax(-16711936, 127));
          c(localRect, this.avO);
          paramCanvas.drawRect(this.avO, this.dsq);
          if (this.alpha < 255) {
            paramCanvas.restoreToCount(i);
          }
          AppMethodBeat.o(209273);
          return;
          i = paramCanvas.saveLayerAlpha(f1, f2, f3, f4, i, 31);
          break;
          label1293:
          ((PointF)localObject2).x = (localRect.right - f1);
          localObject1 = Paint.Align.RIGHT;
          break label580;
          label1314:
          ((RectF)localObject2).left = (f2 + localRect.left);
          ((RectF)localObject2).right = (localRect.right - f1);
          break label704;
          label1343:
          j = 0;
          break label795;
          label1349:
          ((RectF)localObject1).left = (f1 + localRect.left);
        }
        label1365:
        k = 0;
      }
      i = 0;
    }
  }
  
  public int getAlpha()
  {
    return this.alpha;
  }
  
  public final Drawable getChipIcon()
  {
    AppMethodBeat.i(209582);
    if (this.drT != null)
    {
      Drawable localDrawable = androidx.core.graphics.drawable.a.t(this.drT);
      AppMethodBeat.o(209582);
      return localDrawable;
    }
    AppMethodBeat.o(209582);
    return null;
  }
  
  public final Drawable getCloseIcon()
  {
    AppMethodBeat.i(209641);
    if (this.drX != null)
    {
      Drawable localDrawable = androidx.core.graphics.drawable.a.t(this.drX);
      AppMethodBeat.o(209641);
      return localDrawable;
    }
    AppMethodBeat.o(209641);
    return null;
  }
  
  public ColorFilter getColorFilter()
  {
    return this.dsA;
  }
  
  public int getIntrinsicHeight()
  {
    return (int)this.drL;
  }
  
  public int getIntrinsicWidth()
  {
    AppMethodBeat.i(209230);
    int i = Math.min(Math.round(this.dsg + Wg() + this.dsj + Wh() + this.dsk + Wi() + this.dsn), this.maxWidth);
    AppMethodBeat.o(209230);
    return i;
  }
  
  public int getOpacity()
  {
    return -3;
  }
  
  public void getOutline(Outline paramOutline)
  {
    AppMethodBeat.i(209431);
    Rect localRect = getBounds();
    if (!localRect.isEmpty()) {
      paramOutline.setRoundRect(localRect, this.drM);
    }
    for (;;)
    {
      paramOutline.setAlpha(getAlpha() / 255.0F);
      AppMethodBeat.o(209431);
      return;
      paramOutline.setRoundRect(0, 0, getIntrinsicWidth(), getIntrinsicHeight(), this.drM);
    }
  }
  
  public void invalidateDrawable(Drawable paramDrawable)
  {
    AppMethodBeat.i(209442);
    paramDrawable = getCallback();
    if (paramDrawable != null) {
      paramDrawable.invalidateDrawable(this);
    }
    AppMethodBeat.o(209442);
  }
  
  public boolean isStateful()
  {
    AppMethodBeat.i(209295);
    if ((!c(this.drK)) && (!c(this.drN)) && ((!this.dsF) || (!c(this.dsG))))
    {
      com.google.android.material.e.b localb = this.drR;
      if ((localb == null) || (localb.dvK == null) || (!localb.dvK.isStateful())) {
        break label140;
      }
      i = 1;
      if (i == 0) {
        if ((!this.dsc) || (this.dsd == null) || (!this.dsb)) {
          break label145;
        }
      }
    }
    label140:
    label145:
    for (int i = 1;; i = 0)
    {
      if ((i == 0) && (!H(this.drT)) && (!H(this.dsd)) && (!c(this.dsC))) {
        break label150;
      }
      AppMethodBeat.o(209295);
      return true;
      i = 0;
      break;
    }
    label150:
    AppMethodBeat.o(209295);
    return false;
  }
  
  public boolean onLayoutDirectionChanged(int paramInt)
  {
    AppMethodBeat.i(209325);
    boolean bool2 = super.onLayoutDirectionChanged(paramInt);
    boolean bool1 = bool2;
    if (Wd()) {
      bool1 = bool2 | this.drT.setLayoutDirection(paramInt);
    }
    bool2 = bool1;
    if (We()) {
      bool2 = bool1 | this.dsd.setLayoutDirection(paramInt);
    }
    bool1 = bool2;
    if (Wf()) {
      bool1 = bool2 | this.drX.setLayoutDirection(paramInt);
    }
    if (bool1) {
      invalidateSelf();
    }
    AppMethodBeat.o(209325);
    return true;
  }
  
  protected boolean onLevelChange(int paramInt)
  {
    AppMethodBeat.i(209335);
    boolean bool2 = super.onLevelChange(paramInt);
    boolean bool1 = bool2;
    if (Wd()) {
      bool1 = bool2 | this.drT.setLevel(paramInt);
    }
    bool2 = bool1;
    if (We()) {
      bool2 = bool1 | this.dsd.setLevel(paramInt);
    }
    bool1 = bool2;
    if (Wf()) {
      bool1 = bool2 | this.drX.setLevel(paramInt);
    }
    if (bool1) {
      invalidateSelf();
    }
    AppMethodBeat.o(209335);
    return bool1;
  }
  
  protected boolean onStateChange(int[] paramArrayOfInt)
  {
    AppMethodBeat.i(209316);
    boolean bool = b(paramArrayOfInt, this.dsE);
    AppMethodBeat.o(209316);
    return bool;
  }
  
  public final boolean q(int[] paramArrayOfInt)
  {
    AppMethodBeat.i(209308);
    if (!Arrays.equals(this.dsE, paramArrayOfInt))
    {
      this.dsE = paramArrayOfInt;
      if (Wf())
      {
        boolean bool = b(getState(), paramArrayOfInt);
        AppMethodBeat.o(209308);
        return bool;
      }
    }
    AppMethodBeat.o(209308);
    return false;
  }
  
  public void scheduleDrawable(Drawable paramDrawable, Runnable paramRunnable, long paramLong)
  {
    AppMethodBeat.i(209450);
    paramDrawable = getCallback();
    if (paramDrawable != null) {
      paramDrawable.scheduleDrawable(this, paramRunnable, paramLong);
    }
    AppMethodBeat.o(209450);
  }
  
  public void setAlpha(int paramInt)
  {
    AppMethodBeat.i(209355);
    if (this.alpha != paramInt)
    {
      this.alpha = paramInt;
      invalidateSelf();
    }
    AppMethodBeat.o(209355);
  }
  
  public final void setCheckable(boolean paramBoolean)
  {
    AppMethodBeat.i(209676);
    if (this.dsb != paramBoolean)
    {
      this.dsb = paramBoolean;
      float f1 = Wg();
      if ((!paramBoolean) && (this.dsy)) {
        this.dsy = false;
      }
      float f2 = Wg();
      invalidateSelf();
      if (f1 != f2) {
        Wc();
      }
    }
    AppMethodBeat.o(209676);
  }
  
  public final void setCheckedIcon(Drawable paramDrawable)
  {
    AppMethodBeat.i(209701);
    if (this.dsd != paramDrawable)
    {
      float f1 = Wg();
      this.dsd = paramDrawable;
      float f2 = Wg();
      I(this.dsd);
      J(this.dsd);
      invalidateSelf();
      if (f1 != f2) {
        Wc();
      }
    }
    AppMethodBeat.o(209701);
  }
  
  public final void setCheckedIconVisible(boolean paramBoolean)
  {
    AppMethodBeat.i(209685);
    int i;
    if (this.dsc != paramBoolean)
    {
      boolean bool = We();
      this.dsc = paramBoolean;
      paramBoolean = We();
      if (bool == paramBoolean) {
        break label67;
      }
      i = 1;
      if (i != 0)
      {
        if (!paramBoolean) {
          break label72;
        }
        J(this.dsd);
      }
    }
    for (;;)
    {
      invalidateSelf();
      Wc();
      AppMethodBeat.o(209685);
      return;
      label67:
      i = 0;
      break;
      label72:
      I(this.dsd);
    }
  }
  
  public final void setChipBackgroundColor(ColorStateList paramColorStateList)
  {
    AppMethodBeat.i(209471);
    if (this.drK != paramColorStateList)
    {
      this.drK = paramColorStateList;
      onStateChange(getState());
    }
    AppMethodBeat.o(209471);
  }
  
  public final void setChipCornerRadius(float paramFloat)
  {
    AppMethodBeat.i(209490);
    if (this.drM != paramFloat)
    {
      this.drM = paramFloat;
      invalidateSelf();
    }
    AppMethodBeat.o(209490);
  }
  
  public final void setChipEndPadding(float paramFloat)
  {
    AppMethodBeat.i(209795);
    if (this.dsn != paramFloat)
    {
      this.dsn = paramFloat;
      invalidateSelf();
      Wc();
    }
    AppMethodBeat.o(209795);
  }
  
  public final void setChipIcon(Drawable paramDrawable)
  {
    AppMethodBeat.i(209597);
    Drawable localDrawable = getChipIcon();
    float f1;
    if (localDrawable != paramDrawable)
    {
      f1 = Wg();
      if (paramDrawable == null) {
        break label86;
      }
    }
    label86:
    for (paramDrawable = androidx.core.graphics.drawable.a.s(paramDrawable).mutate();; paramDrawable = null)
    {
      this.drT = paramDrawable;
      float f2 = Wg();
      I(localDrawable);
      if (Wd()) {
        J(this.drT);
      }
      invalidateSelf();
      if (f1 != f2) {
        Wc();
      }
      AppMethodBeat.o(209597);
      return;
    }
  }
  
  public final void setChipIconSize(float paramFloat)
  {
    AppMethodBeat.i(209613);
    if (this.drV != paramFloat)
    {
      float f = Wg();
      this.drV = paramFloat;
      paramFloat = Wg();
      invalidateSelf();
      if (f != paramFloat) {
        Wc();
      }
    }
    AppMethodBeat.o(209613);
  }
  
  public final void setChipIconTint(ColorStateList paramColorStateList)
  {
    AppMethodBeat.i(209603);
    if (this.drU != paramColorStateList)
    {
      this.drU = paramColorStateList;
      if (Wd()) {
        androidx.core.graphics.drawable.a.a(this.drT, paramColorStateList);
      }
      onStateChange(getState());
    }
    AppMethodBeat.o(209603);
  }
  
  public final void setChipIconVisible(boolean paramBoolean)
  {
    AppMethodBeat.i(209575);
    int i;
    if (this.drS != paramBoolean)
    {
      boolean bool = Wd();
      this.drS = paramBoolean;
      paramBoolean = Wd();
      if (bool == paramBoolean) {
        break label67;
      }
      i = 1;
      if (i != 0)
      {
        if (!paramBoolean) {
          break label72;
        }
        J(this.drT);
      }
    }
    for (;;)
    {
      invalidateSelf();
      Wc();
      AppMethodBeat.o(209575);
      return;
      label67:
      i = 0;
      break;
      label72:
      I(this.drT);
    }
  }
  
  public final void setChipMinHeight(float paramFloat)
  {
    AppMethodBeat.i(209482);
    if (this.drL != paramFloat)
    {
      this.drL = paramFloat;
      invalidateSelf();
      Wc();
    }
    AppMethodBeat.o(209482);
  }
  
  public final void setChipStartPadding(float paramFloat)
  {
    AppMethodBeat.i(209712);
    if (this.dsg != paramFloat)
    {
      this.dsg = paramFloat;
      invalidateSelf();
      Wc();
    }
    AppMethodBeat.o(209712);
  }
  
  public final void setChipStrokeColor(ColorStateList paramColorStateList)
  {
    AppMethodBeat.i(209502);
    if (this.drN != paramColorStateList)
    {
      this.drN = paramColorStateList;
      onStateChange(getState());
    }
    AppMethodBeat.o(209502);
  }
  
  public final void setChipStrokeWidth(float paramFloat)
  {
    AppMethodBeat.i(209514);
    if (this.drO != paramFloat)
    {
      this.drO = paramFloat;
      this.dsp.setStrokeWidth(paramFloat);
      invalidateSelf();
    }
    AppMethodBeat.o(209514);
  }
  
  public final void setCloseIcon(Drawable paramDrawable)
  {
    AppMethodBeat.i(209651);
    Drawable localDrawable = getCloseIcon();
    float f1;
    if (localDrawable != paramDrawable)
    {
      f1 = Wi();
      if (paramDrawable == null) {
        break label86;
      }
    }
    label86:
    for (paramDrawable = androidx.core.graphics.drawable.a.s(paramDrawable).mutate();; paramDrawable = null)
    {
      this.drX = paramDrawable;
      float f2 = Wi();
      I(localDrawable);
      if (Wf()) {
        J(this.drX);
      }
      invalidateSelf();
      if (f1 != f2) {
        Wc();
      }
      AppMethodBeat.o(209651);
      return;
    }
  }
  
  public final void setCloseIconEndPadding(float paramFloat)
  {
    AppMethodBeat.i(209782);
    if (this.dsm != paramFloat)
    {
      this.dsm = paramFloat;
      invalidateSelf();
      if (Wf()) {
        Wc();
      }
    }
    AppMethodBeat.o(209782);
  }
  
  public final void setCloseIconSize(float paramFloat)
  {
    AppMethodBeat.i(209668);
    if (this.drZ != paramFloat)
    {
      this.drZ = paramFloat;
      invalidateSelf();
      if (Wf()) {
        Wc();
      }
    }
    AppMethodBeat.o(209668);
  }
  
  public final void setCloseIconStartPadding(float paramFloat)
  {
    AppMethodBeat.i(209770);
    if (this.dsl != paramFloat)
    {
      this.dsl = paramFloat;
      invalidateSelf();
      if (Wf()) {
        Wc();
      }
    }
    AppMethodBeat.o(209770);
  }
  
  public final void setCloseIconTint(ColorStateList paramColorStateList)
  {
    AppMethodBeat.i(209659);
    if (this.drY != paramColorStateList)
    {
      this.drY = paramColorStateList;
      if (Wf()) {
        androidx.core.graphics.drawable.a.a(this.drX, paramColorStateList);
      }
      onStateChange(getState());
    }
    AppMethodBeat.o(209659);
  }
  
  public final void setCloseIconVisible(boolean paramBoolean)
  {
    AppMethodBeat.i(209629);
    int i;
    if (this.drW != paramBoolean)
    {
      boolean bool = Wf();
      this.drW = paramBoolean;
      paramBoolean = Wf();
      if (bool == paramBoolean) {
        break label67;
      }
      i = 1;
      if (i != 0)
      {
        if (!paramBoolean) {
          break label72;
        }
        J(this.drX);
      }
    }
    for (;;)
    {
      invalidateSelf();
      Wc();
      AppMethodBeat.o(209629);
      return;
      label67:
      i = 0;
      break;
      label72:
      I(this.drX);
    }
  }
  
  public void setColorFilter(ColorFilter paramColorFilter)
  {
    AppMethodBeat.i(209376);
    if (this.dsA != paramColorFilter)
    {
      this.dsA = paramColorFilter;
      invalidateSelf();
    }
    AppMethodBeat.o(209376);
  }
  
  public final void setIconEndPadding(float paramFloat)
  {
    AppMethodBeat.i(209736);
    if (this.dsi != paramFloat)
    {
      float f = Wg();
      this.dsi = paramFloat;
      paramFloat = Wg();
      invalidateSelf();
      if (f != paramFloat) {
        Wc();
      }
    }
    AppMethodBeat.o(209736);
  }
  
  public final void setIconStartPadding(float paramFloat)
  {
    AppMethodBeat.i(209722);
    if (this.dsh != paramFloat)
    {
      float f = Wg();
      this.dsh = paramFloat;
      paramFloat = Wg();
      invalidateSelf();
      if (f != paramFloat) {
        Wc();
      }
    }
    AppMethodBeat.o(209722);
  }
  
  public final void setRippleColor(ColorStateList paramColorStateList)
  {
    AppMethodBeat.i(209525);
    if (this.drj != paramColorStateList)
    {
      this.drj = paramColorStateList;
      Wk();
      onStateChange(getState());
    }
    AppMethodBeat.o(209525);
  }
  
  public final void setText(CharSequence paramCharSequence)
  {
    AppMethodBeat.i(209539);
    Object localObject = paramCharSequence;
    if (paramCharSequence == null) {
      localObject = "";
    }
    if (this.drP != localObject)
    {
      this.drP = ((CharSequence)localObject);
      this.drQ = androidx.core.e.a.DT().r((CharSequence)localObject);
      this.dsI = true;
      invalidateSelf();
      Wc();
    }
    AppMethodBeat.o(209539);
  }
  
  public final void setTextAppearance(com.google.android.material.e.b paramb)
  {
    AppMethodBeat.i(209561);
    if (this.drR != paramb)
    {
      this.drR = paramb;
      if (paramb != null)
      {
        paramb.c(this.context, this.dso, this.drH);
        this.dsI = true;
      }
      onStateChange(getState());
      Wc();
    }
    AppMethodBeat.o(209561);
  }
  
  public final void setTextAppearanceResource(int paramInt)
  {
    AppMethodBeat.i(209548);
    setTextAppearance(new com.google.android.material.e.b(this.context, paramInt));
    AppMethodBeat.o(209548);
  }
  
  public final void setTextEndPadding(float paramFloat)
  {
    AppMethodBeat.i(209756);
    if (this.dsk != paramFloat)
    {
      this.dsk = paramFloat;
      invalidateSelf();
      Wc();
    }
    AppMethodBeat.o(209756);
  }
  
  public final void setTextStartPadding(float paramFloat)
  {
    AppMethodBeat.i(209745);
    if (this.dsj != paramFloat)
    {
      this.dsj = paramFloat;
      invalidateSelf();
      Wc();
    }
    AppMethodBeat.o(209745);
  }
  
  public void setTintList(ColorStateList paramColorStateList)
  {
    AppMethodBeat.i(209398);
    if (this.dsC != paramColorStateList)
    {
      this.dsC = paramColorStateList;
      onStateChange(getState());
    }
    AppMethodBeat.o(209398);
  }
  
  public void setTintMode(PorterDuff.Mode paramMode)
  {
    AppMethodBeat.i(209413);
    if (this.dsD != paramMode)
    {
      this.dsD = paramMode;
      this.dsB = com.google.android.material.b.a.a(this, this.dsC, paramMode);
      invalidateSelf();
    }
    AppMethodBeat.o(209413);
  }
  
  public boolean setVisible(boolean paramBoolean1, boolean paramBoolean2)
  {
    AppMethodBeat.i(209347);
    boolean bool2 = super.setVisible(paramBoolean1, paramBoolean2);
    boolean bool1 = bool2;
    if (Wd()) {
      bool1 = bool2 | this.drT.setVisible(paramBoolean1, paramBoolean2);
    }
    bool2 = bool1;
    if (We()) {
      bool2 = bool1 | this.dsd.setVisible(paramBoolean1, paramBoolean2);
    }
    bool1 = bool2;
    if (Wf()) {
      bool1 = bool2 | this.drX.setVisible(paramBoolean1, paramBoolean2);
    }
    if (bool1) {
      invalidateSelf();
    }
    AppMethodBeat.o(209347);
    return bool1;
  }
  
  public void unscheduleDrawable(Drawable paramDrawable, Runnable paramRunnable)
  {
    AppMethodBeat.i(209459);
    paramDrawable = getCallback();
    if (paramDrawable != null) {
      paramDrawable.unscheduleDrawable(this, paramRunnable);
    }
    AppMethodBeat.o(209459);
  }
  
  public static abstract interface a
  {
    public abstract void VX();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes10.jar
 * Qualified Name:     com.google.android.material.chip.a
 * JD-Core Version:    0.7.0.1
 */