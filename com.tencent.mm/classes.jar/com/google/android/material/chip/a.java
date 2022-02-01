package com.google.android.material.chip;

import android.annotation.TargetApi;
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
import androidx.core.content.a.f.a;
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
  private static final int[] byJ = { 16842910 };
  private int alpha;
  private final f.a byH;
  ColorStateList byK;
  float byL;
  float byM;
  ColorStateList byN;
  float byO;
  CharSequence byP;
  private CharSequence byQ;
  com.google.android.material.e.b byR;
  boolean byS;
  private Drawable byT;
  ColorStateList byU;
  float byV;
  boolean byW;
  Drawable byX;
  ColorStateList byY;
  float byZ;
  ColorStateList byg;
  private final RectF byj;
  private PorterDuffColorFilter bzA;
  private ColorStateList bzB;
  private PorterDuff.Mode bzC;
  private int[] bzD;
  private boolean bzE;
  private ColorStateList bzF;
  private WeakReference<a> bzG;
  private boolean bzH;
  private float bzI;
  TextUtils.TruncateAt bzJ;
  boolean bzK;
  CharSequence bza;
  boolean bzb;
  boolean bzc;
  Drawable bzd;
  h bze;
  h bzf;
  float bzg;
  float bzh;
  float bzi;
  float bzj;
  float bzk;
  float bzl;
  float bzm;
  float bzn;
  private final TextPaint bzo;
  private final Paint bzp;
  private final Paint bzq;
  private final Paint.FontMetrics bzr;
  private final PointF bzs;
  private int bzt;
  private int bzu;
  private int bzv;
  private int bzw;
  private boolean bzx;
  private int bzy;
  private ColorFilter bzz;
  final Context context;
  int maxWidth;
  
  private a(Context paramContext)
  {
    AppMethodBeat.i(236012);
    this.byH = new f.a()
    {
      public final void a(Typeface paramAnonymousTypeface)
      {
        AppMethodBeat.i(235954);
        a.a(a.this);
        a.this.wD();
        a.this.invalidateSelf();
        AppMethodBeat.o(235954);
      }
      
      public final void au(int paramAnonymousInt) {}
    };
    this.bzo = new TextPaint(1);
    this.bzp = new Paint(1);
    this.bzr = new Paint.FontMetrics();
    this.byj = new RectF();
    this.bzs = new PointF();
    this.alpha = 255;
    this.bzC = PorterDuff.Mode.SRC_IN;
    this.bzG = new WeakReference(null);
    this.bzH = true;
    this.context = paramContext;
    this.byP = "";
    this.bzo.density = paramContext.getResources().getDisplayMetrics().density;
    this.bzq = null;
    if (this.bzq != null) {
      this.bzq.setStyle(Paint.Style.STROKE);
    }
    setState(byJ);
    n(byJ);
    this.bzK = true;
    AppMethodBeat.o(236012);
  }
  
  private void a(Rect paramRect, RectF paramRectF)
  {
    AppMethodBeat.i(236053);
    paramRectF.setEmpty();
    float f;
    if ((wE()) || (wF()))
    {
      f = this.bzg + this.bzh;
      if (androidx.core.graphics.drawable.a.r(this) != 0) {
        break label98;
      }
      paramRectF.left = (f + paramRect.left);
      paramRectF.right = (paramRectF.left + this.byV);
    }
    for (;;)
    {
      paramRectF.top = (paramRect.exactCenterY() - this.byV / 2.0F);
      paramRectF.bottom = (paramRectF.top + this.byV);
      AppMethodBeat.o(236053);
      return;
      label98:
      paramRectF.right = (paramRect.right - f);
      paramRectF.left = (paramRectF.right - this.byV);
    }
  }
  
  public static a b(Context paramContext, AttributeSet paramAttributeSet, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(236007);
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
      locala.bze = h.a(locala.context, localTypedArray, a.k.Chip_showMotionSpec);
      locala.bzf = h.a(locala.context, localTypedArray, a.k.Chip_hideMotionSpec);
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
      AppMethodBeat.o(236007);
      return locala;
      paramContext = null;
      break;
      locala.bzJ = TextUtils.TruncateAt.START;
      continue;
      locala.bzJ = TextUtils.TruncateAt.MIDDLE;
      continue;
      locala.bzJ = TextUtils.TruncateAt.END;
    }
  }
  
  private void b(Rect paramRect, RectF paramRectF)
  {
    AppMethodBeat.i(236055);
    paramRectF.setEmpty();
    float f;
    if (wG())
    {
      f = this.bzn + this.bzm;
      if (androidx.core.graphics.drawable.a.r(this) != 0) {
        break label93;
      }
      paramRectF.right = (paramRect.right - f);
      paramRectF.left = (paramRectF.right - this.byZ);
    }
    for (;;)
    {
      paramRectF.top = (paramRect.exactCenterY() - this.byZ / 2.0F);
      paramRectF.bottom = (paramRectF.top + this.byZ);
      AppMethodBeat.o(236055);
      return;
      label93:
      paramRectF.left = (f + paramRect.left);
      paramRectF.right = (paramRectF.left + this.byZ);
    }
  }
  
  private boolean b(int[] paramArrayOfInt1, int[] paramArrayOfInt2)
  {
    int j = 0;
    boolean bool3 = true;
    AppMethodBeat.i(236064);
    boolean bool1 = super.onStateChange(paramArrayOfInt1);
    int i;
    if (this.byK != null)
    {
      i = this.byK.getColorForState(paramArrayOfInt1, this.bzt);
      if (this.bzt == i) {
        break label485;
      }
      this.bzt = i;
      bool1 = true;
    }
    label79:
    label227:
    label485:
    for (;;)
    {
      label118:
      boolean bool2;
      if (this.byN != null)
      {
        i = this.byN.getColorForState(paramArrayOfInt1, this.bzu);
        if (this.bzu != i)
        {
          this.bzu = i;
          bool1 = true;
        }
        if (this.bzF == null) {
          break label445;
        }
        i = this.bzF.getColorForState(paramArrayOfInt1, this.bzv);
        bool2 = bool1;
        if (this.bzv != i)
        {
          this.bzv = i;
          bool2 = bool1;
          if (this.bzE) {
            bool2 = true;
          }
        }
        if ((this.byR == null) || (this.byR.bCI == null)) {
          break label451;
        }
        i = this.byR.bCI.getColorForState(paramArrayOfInt1, this.bzw);
        bool1 = bool2;
        if (this.bzw != i)
        {
          this.bzw = i;
          bool1 = true;
        }
        if ((!o(getState())) || (!this.bzb)) {
          break label457;
        }
        bool2 = true;
        if ((this.bzx == bool2) || (this.bzd == null)) {
          break label479;
        }
        float f = wH();
        this.bzx = bool2;
        if (f == wH()) {
          break label470;
        }
        i = 1;
        bool1 = true;
      }
      for (;;)
      {
        if (this.bzB != null) {
          j = this.bzB.getColorForState(paramArrayOfInt1, this.bzy);
        }
        if (this.bzy != j)
        {
          this.bzy = j;
          this.bzA = com.google.android.material.b.a.a(this, this.bzB, this.bzC);
        }
        for (bool2 = bool3;; bool2 = bool1)
        {
          bool1 = bool2;
          if (x(this.byT)) {
            bool1 = bool2 | this.byT.setState(paramArrayOfInt1);
          }
          bool2 = bool1;
          if (x(this.bzd)) {
            bool2 = bool1 | this.bzd.setState(paramArrayOfInt1);
          }
          bool1 = bool2;
          if (x(this.byX)) {
            bool1 = bool2 | this.byX.setState(paramArrayOfInt2);
          }
          if (bool1) {
            invalidateSelf();
          }
          if (i != 0) {
            wD();
          }
          AppMethodBeat.o(236064);
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
    AppMethodBeat.i(236066);
    if ((paramColorStateList != null) && (paramColorStateList.isStateful()))
    {
      AppMethodBeat.o(236066);
      return true;
    }
    AppMethodBeat.o(236066);
    return false;
  }
  
  private static boolean o(int[] paramArrayOfInt)
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
  
  private float w(CharSequence paramCharSequence)
  {
    AppMethodBeat.i(236039);
    if (paramCharSequence == null)
    {
      AppMethodBeat.o(236039);
      return 0.0F;
    }
    float f = this.bzo.measureText(paramCharSequence, 0, paramCharSequence.length());
    AppMethodBeat.o(236039);
    return f;
  }
  
  private boolean wE()
  {
    return (this.byS) && (this.byT != null);
  }
  
  private boolean wF()
  {
    return (this.bzc) && (this.bzd != null) && (this.bzx);
  }
  
  private boolean wG()
  {
    return (this.byW) && (this.byX != null);
  }
  
  private float wI()
  {
    AppMethodBeat.i(236037);
    if (!this.bzH)
    {
      f = this.bzI;
      AppMethodBeat.o(236037);
      return f;
    }
    this.bzI = w(this.byQ);
    this.bzH = false;
    float f = this.bzI;
    AppMethodBeat.o(236037);
    return f;
  }
  
  private float wJ()
  {
    AppMethodBeat.i(236042);
    if (wG())
    {
      float f1 = this.bzl;
      float f2 = this.byZ;
      float f3 = this.bzm;
      AppMethodBeat.o(236042);
      return f1 + f2 + f3;
    }
    AppMethodBeat.o(236042);
    return 0.0F;
  }
  
  private ColorFilter wK()
  {
    if (this.bzz != null) {
      return this.bzz;
    }
    return this.bzA;
  }
  
  private void wL()
  {
    AppMethodBeat.i(236104);
    if (this.bzE) {}
    for (ColorStateList localColorStateList = com.google.android.material.f.a.g(this.byg);; localColorStateList = null)
    {
      this.bzF = localColorStateList;
      AppMethodBeat.o(236104);
      return;
    }
  }
  
  static boolean x(Drawable paramDrawable)
  {
    AppMethodBeat.i(236068);
    if ((paramDrawable != null) && (paramDrawable.isStateful()))
    {
      AppMethodBeat.o(236068);
      return true;
    }
    AppMethodBeat.o(236068);
    return false;
  }
  
  private static void y(Drawable paramDrawable)
  {
    AppMethodBeat.i(236101);
    if (paramDrawable != null) {
      paramDrawable.setCallback(null);
    }
    AppMethodBeat.o(236101);
  }
  
  private void z(Drawable paramDrawable)
  {
    AppMethodBeat.i(236103);
    if (paramDrawable != null)
    {
      paramDrawable.setCallback(this);
      androidx.core.graphics.drawable.a.b(paramDrawable, androidx.core.graphics.drawable.a.r(this));
      paramDrawable.setLevel(getLevel());
      paramDrawable.setVisible(isVisible(), false);
      if (paramDrawable == this.byX)
      {
        if (paramDrawable.isStateful()) {
          paramDrawable.setState(this.bzD);
        }
        androidx.core.graphics.drawable.a.a(paramDrawable, this.byY);
        AppMethodBeat.o(236103);
        return;
      }
      if (paramDrawable.isStateful()) {
        paramDrawable.setState(getState());
      }
    }
    AppMethodBeat.o(236103);
  }
  
  public final void a(a parama)
  {
    AppMethodBeat.i(236019);
    this.bzG = new WeakReference(parama);
    AppMethodBeat.o(236019);
  }
  
  public final void bg(boolean paramBoolean)
  {
    AppMethodBeat.i(236015);
    if (this.bzE != paramBoolean)
    {
      this.bzE = paramBoolean;
      wL();
      onStateChange(getState());
    }
    AppMethodBeat.o(236015);
  }
  
  final void c(Rect paramRect, RectF paramRectF)
  {
    AppMethodBeat.i(236056);
    paramRectF.setEmpty();
    float f;
    if (wG())
    {
      f = this.bzn + this.bzm + this.byZ + this.bzl + this.bzk;
      if (androidx.core.graphics.drawable.a.r(this) != 0) {
        break label93;
      }
      paramRectF.right = paramRect.right;
      paramRectF.left = (paramRectF.right - f);
    }
    for (;;)
    {
      paramRectF.top = paramRect.top;
      paramRectF.bottom = paramRect.bottom;
      AppMethodBeat.o(236056);
      return;
      label93:
      paramRectF.left = paramRect.left;
      paramRectF.right = (f + paramRect.left);
    }
  }
  
  public void draw(Canvas paramCanvas)
  {
    AppMethodBeat.i(236050);
    Rect localRect = getBounds();
    if ((localRect.isEmpty()) || (getAlpha() == 0))
    {
      AppMethodBeat.o(236050);
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
      this.bzp.setColor(this.bzt);
      this.bzp.setStyle(Paint.Style.FILL);
      this.bzp.setColorFilter(wK());
      this.byj.set(localRect);
      paramCanvas.drawRoundRect(this.byj, this.byM, this.byM, this.bzp);
      if (this.byO > 0.0F)
      {
        this.bzp.setColor(this.bzu);
        this.bzp.setStyle(Paint.Style.STROKE);
        this.bzp.setColorFilter(wK());
        this.byj.set(localRect.left + this.byO / 2.0F, localRect.top + this.byO / 2.0F, localRect.right - this.byO / 2.0F, localRect.bottom - this.byO / 2.0F);
        f1 = this.byM - this.byO / 2.0F;
        paramCanvas.drawRoundRect(this.byj, f1, f1, this.bzp);
      }
      this.bzp.setColor(this.bzv);
      this.bzp.setStyle(Paint.Style.FILL);
      this.byj.set(localRect);
      paramCanvas.drawRoundRect(this.byj, this.byM, this.byM, this.bzp);
      if (wE())
      {
        a(localRect, this.byj);
        f1 = this.byj.left;
        f2 = this.byj.top;
        paramCanvas.translate(f1, f2);
        this.byT.setBounds(0, 0, (int)this.byj.width(), (int)this.byj.height());
        this.byT.draw(paramCanvas);
        paramCanvas.translate(-f1, -f2);
      }
      if (wF())
      {
        a(localRect, this.byj);
        f1 = this.byj.left;
        f2 = this.byj.top;
        paramCanvas.translate(f1, f2);
        this.bzd.setBounds(0, 0, (int)this.byj.width(), (int)this.byj.height());
        this.bzd.draw(paramCanvas);
        paramCanvas.translate(-f1, -f2);
      }
      Object localObject2;
      Object localObject1;
      label580:
      int j;
      label704:
      int k;
      if ((this.bzK) && (this.byQ != null))
      {
        localObject2 = this.bzs;
        ((PointF)localObject2).set(0.0F, 0.0F);
        localObject1 = Paint.Align.LEFT;
        if (this.byQ != null)
        {
          f1 = this.bzg + wH() + this.bzj;
          if (androidx.core.graphics.drawable.a.r(this) != 0) {
            break label1293;
          }
          ((PointF)localObject2).x = (f1 + localRect.left);
          localObject1 = Paint.Align.LEFT;
          f1 = localRect.centerY();
          this.bzo.getFontMetrics(this.bzr);
          ((PointF)localObject2).y = (f1 - (this.bzr.descent + this.bzr.ascent) / 2.0F);
        }
        localObject2 = this.byj;
        ((RectF)localObject2).setEmpty();
        if (this.byQ != null)
        {
          f1 = this.bzg + wH() + this.bzj;
          f2 = this.bzn + wJ() + this.bzk;
          if (androidx.core.graphics.drawable.a.r(this) != 0) {
            break label1314;
          }
          ((RectF)localObject2).left = (f1 + localRect.left);
          ((RectF)localObject2).right = (localRect.right - f2);
          ((RectF)localObject2).top = localRect.top;
          ((RectF)localObject2).bottom = localRect.bottom;
        }
        if (this.byR != null)
        {
          this.bzo.drawableState = getState();
          this.byR.b(this.context, this.bzo, this.byH);
        }
        this.bzo.setTextAlign((Paint.Align)localObject1);
        if (Math.round(wI()) <= Math.round(this.byj.width())) {
          break label1343;
        }
        j = 1;
        label795:
        if (j == 0) {
          break label1365;
        }
        k = paramCanvas.save();
        paramCanvas.clipRect(this.byj);
      }
      for (;;)
      {
        localObject2 = this.byQ;
        localObject1 = localObject2;
        if (j != 0)
        {
          localObject1 = localObject2;
          if (this.bzJ != null) {
            localObject1 = TextUtils.ellipsize(this.byQ, this.bzo, this.byj.width(), this.bzJ);
          }
        }
        paramCanvas.drawText((CharSequence)localObject1, 0, ((CharSequence)localObject1).length(), this.bzs.x, this.bzs.y, this.bzo);
        if (j != 0) {
          paramCanvas.restoreToCount(k);
        }
        if (wG())
        {
          b(localRect, this.byj);
          f1 = this.byj.left;
          f2 = this.byj.top;
          paramCanvas.translate(f1, f2);
          this.byX.setBounds(0, 0, (int)this.byj.width(), (int)this.byj.height());
          this.byX.draw(paramCanvas);
          paramCanvas.translate(-f1, -f2);
        }
        if (this.bzq != null)
        {
          this.bzq.setColor(androidx.core.graphics.b.C(-16777216, 127));
          paramCanvas.drawRect(localRect, this.bzq);
          if ((wE()) || (wF()))
          {
            a(localRect, this.byj);
            paramCanvas.drawRect(this.byj, this.bzq);
          }
          if (this.byQ != null) {
            paramCanvas.drawLine(localRect.left, localRect.exactCenterY(), localRect.right, localRect.exactCenterY(), this.bzq);
          }
          if (wG())
          {
            b(localRect, this.byj);
            paramCanvas.drawRect(this.byj, this.bzq);
          }
          this.bzq.setColor(androidx.core.graphics.b.C(-65536, 127));
          localObject1 = this.byj;
          ((RectF)localObject1).set(localRect);
          if (wG())
          {
            f1 = this.bzn + this.bzm + this.byZ + this.bzl + this.bzk;
            if (androidx.core.graphics.drawable.a.r(this) != 0) {
              break label1349;
            }
            ((RectF)localObject1).right = (localRect.right - f1);
          }
        }
        for (;;)
        {
          paramCanvas.drawRect(this.byj, this.bzq);
          this.bzq.setColor(androidx.core.graphics.b.C(-16711936, 127));
          c(localRect, this.byj);
          paramCanvas.drawRect(this.byj, this.bzq);
          if (this.alpha < 255) {
            paramCanvas.restoreToCount(i);
          }
          AppMethodBeat.o(236050);
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
    AppMethodBeat.i(236124);
    if (this.byT != null)
    {
      Drawable localDrawable = androidx.core.graphics.drawable.a.q(this.byT);
      AppMethodBeat.o(236124);
      return localDrawable;
    }
    AppMethodBeat.o(236124);
    return null;
  }
  
  public final Drawable getCloseIcon()
  {
    AppMethodBeat.i(236132);
    if (this.byX != null)
    {
      Drawable localDrawable = androidx.core.graphics.drawable.a.q(this.byX);
      AppMethodBeat.o(236132);
      return localDrawable;
    }
    AppMethodBeat.o(236132);
    return null;
  }
  
  public ColorFilter getColorFilter()
  {
    return this.bzz;
  }
  
  public int getIntrinsicHeight()
  {
    return (int)this.byL;
  }
  
  public int getIntrinsicWidth()
  {
    AppMethodBeat.i(236026);
    int i = Math.min(Math.round(this.bzg + wH() + this.bzj + wI() + this.bzk + wJ() + this.bzn), this.maxWidth);
    AppMethodBeat.o(236026);
    return i;
  }
  
  public int getOpacity()
  {
    return -3;
  }
  
  @TargetApi(21)
  public void getOutline(Outline paramOutline)
  {
    AppMethodBeat.i(236087);
    Rect localRect = getBounds();
    if (!localRect.isEmpty()) {
      paramOutline.setRoundRect(localRect, this.byM);
    }
    for (;;)
    {
      paramOutline.setAlpha(getAlpha() / 255.0F);
      AppMethodBeat.o(236087);
      return;
      paramOutline.setRoundRect(0, 0, getIntrinsicWidth(), getIntrinsicHeight(), this.byM);
    }
  }
  
  public void invalidateDrawable(Drawable paramDrawable)
  {
    AppMethodBeat.i(236088);
    paramDrawable = getCallback();
    if (paramDrawable != null) {
      paramDrawable.invalidateDrawable(this);
    }
    AppMethodBeat.o(236088);
  }
  
  public boolean isStateful()
  {
    AppMethodBeat.i(236057);
    if ((!c(this.byK)) && (!c(this.byN)) && ((!this.bzE) || (!c(this.bzF))))
    {
      com.google.android.material.e.b localb = this.byR;
      if ((localb == null) || (localb.bCI == null) || (!localb.bCI.isStateful())) {
        break label140;
      }
      i = 1;
      if (i == 0) {
        if ((!this.bzc) || (this.bzd == null) || (!this.bzb)) {
          break label145;
        }
      }
    }
    label140:
    label145:
    for (int i = 1;; i = 0)
    {
      if ((i == 0) && (!x(this.byT)) && (!x(this.bzd)) && (!c(this.bzB))) {
        break label150;
      }
      AppMethodBeat.o(236057);
      return true;
      i = 0;
      break;
    }
    label150:
    AppMethodBeat.o(236057);
    return false;
  }
  
  public final boolean n(int[] paramArrayOfInt)
  {
    AppMethodBeat.i(236059);
    if (!Arrays.equals(this.bzD, paramArrayOfInt))
    {
      this.bzD = paramArrayOfInt;
      if (wG())
      {
        boolean bool = b(getState(), paramArrayOfInt);
        AppMethodBeat.o(236059);
        return bool;
      }
    }
    AppMethodBeat.o(236059);
    return false;
  }
  
  @TargetApi(23)
  public boolean onLayoutDirectionChanged(int paramInt)
  {
    AppMethodBeat.i(236071);
    boolean bool2 = super.onLayoutDirectionChanged(paramInt);
    boolean bool1 = bool2;
    if (wE()) {
      bool1 = bool2 | this.byT.setLayoutDirection(paramInt);
    }
    bool2 = bool1;
    if (wF()) {
      bool2 = bool1 | this.bzd.setLayoutDirection(paramInt);
    }
    bool1 = bool2;
    if (wG()) {
      bool1 = bool2 | this.byX.setLayoutDirection(paramInt);
    }
    if (bool1) {
      invalidateSelf();
    }
    AppMethodBeat.o(236071);
    return true;
  }
  
  protected boolean onLevelChange(int paramInt)
  {
    AppMethodBeat.i(236073);
    boolean bool2 = super.onLevelChange(paramInt);
    boolean bool1 = bool2;
    if (wE()) {
      bool1 = bool2 | this.byT.setLevel(paramInt);
    }
    bool2 = bool1;
    if (wF()) {
      bool2 = bool1 | this.bzd.setLevel(paramInt);
    }
    bool1 = bool2;
    if (wG()) {
      bool1 = bool2 | this.byX.setLevel(paramInt);
    }
    if (bool1) {
      invalidateSelf();
    }
    AppMethodBeat.o(236073);
    return bool1;
  }
  
  protected boolean onStateChange(int[] paramArrayOfInt)
  {
    AppMethodBeat.i(236060);
    boolean bool = b(paramArrayOfInt, this.bzD);
    AppMethodBeat.o(236060);
    return bool;
  }
  
  public void scheduleDrawable(Drawable paramDrawable, Runnable paramRunnable, long paramLong)
  {
    AppMethodBeat.i(236094);
    paramDrawable = getCallback();
    if (paramDrawable != null) {
      paramDrawable.scheduleDrawable(this, paramRunnable, paramLong);
    }
    AppMethodBeat.o(236094);
  }
  
  public void setAlpha(int paramInt)
  {
    AppMethodBeat.i(236076);
    if (this.alpha != paramInt)
    {
      this.alpha = paramInt;
      invalidateSelf();
    }
    AppMethodBeat.o(236076);
  }
  
  public final void setCheckable(boolean paramBoolean)
  {
    AppMethodBeat.i(236139);
    if (this.bzb != paramBoolean)
    {
      this.bzb = paramBoolean;
      float f1 = wH();
      if ((!paramBoolean) && (this.bzx)) {
        this.bzx = false;
      }
      float f2 = wH();
      invalidateSelf();
      if (f1 != f2) {
        wD();
      }
    }
    AppMethodBeat.o(236139);
  }
  
  public final void setCheckedIcon(Drawable paramDrawable)
  {
    AppMethodBeat.i(236141);
    if (this.bzd != paramDrawable)
    {
      float f1 = wH();
      this.bzd = paramDrawable;
      float f2 = wH();
      y(this.bzd);
      z(this.bzd);
      invalidateSelf();
      if (f1 != f2) {
        wD();
      }
    }
    AppMethodBeat.o(236141);
  }
  
  public final void setCheckedIconVisible(boolean paramBoolean)
  {
    AppMethodBeat.i(236140);
    int i;
    if (this.bzc != paramBoolean)
    {
      boolean bool = wF();
      this.bzc = paramBoolean;
      paramBoolean = wF();
      if (bool == paramBoolean) {
        break label67;
      }
      i = 1;
      if (i != 0)
      {
        if (!paramBoolean) {
          break label72;
        }
        z(this.bzd);
      }
    }
    for (;;)
    {
      invalidateSelf();
      wD();
      AppMethodBeat.o(236140);
      return;
      label67:
      i = 0;
      break;
      label72:
      y(this.bzd);
    }
  }
  
  public final void setChipBackgroundColor(ColorStateList paramColorStateList)
  {
    AppMethodBeat.i(236105);
    if (this.byK != paramColorStateList)
    {
      this.byK = paramColorStateList;
      onStateChange(getState());
    }
    AppMethodBeat.o(236105);
  }
  
  public final void setChipCornerRadius(float paramFloat)
  {
    AppMethodBeat.i(236110);
    if (this.byM != paramFloat)
    {
      this.byM = paramFloat;
      invalidateSelf();
    }
    AppMethodBeat.o(236110);
  }
  
  public final void setChipEndPadding(float paramFloat)
  {
    AppMethodBeat.i(236153);
    if (this.bzn != paramFloat)
    {
      this.bzn = paramFloat;
      invalidateSelf();
      wD();
    }
    AppMethodBeat.o(236153);
  }
  
  public final void setChipIcon(Drawable paramDrawable)
  {
    AppMethodBeat.i(236127);
    Drawable localDrawable = getChipIcon();
    float f1;
    if (localDrawable != paramDrawable)
    {
      f1 = wH();
      if (paramDrawable == null) {
        break label86;
      }
    }
    label86:
    for (paramDrawable = androidx.core.graphics.drawable.a.p(paramDrawable).mutate();; paramDrawable = null)
    {
      this.byT = paramDrawable;
      float f2 = wH();
      y(localDrawable);
      if (wE()) {
        z(this.byT);
      }
      invalidateSelf();
      if (f1 != f2) {
        wD();
      }
      AppMethodBeat.o(236127);
      return;
    }
  }
  
  public final void setChipIconSize(float paramFloat)
  {
    AppMethodBeat.i(236130);
    if (this.byV != paramFloat)
    {
      float f = wH();
      this.byV = paramFloat;
      paramFloat = wH();
      invalidateSelf();
      if (f != paramFloat) {
        wD();
      }
    }
    AppMethodBeat.o(236130);
  }
  
  public final void setChipIconTint(ColorStateList paramColorStateList)
  {
    AppMethodBeat.i(236128);
    if (this.byU != paramColorStateList)
    {
      this.byU = paramColorStateList;
      if (wE()) {
        androidx.core.graphics.drawable.a.a(this.byT, paramColorStateList);
      }
      onStateChange(getState());
    }
    AppMethodBeat.o(236128);
  }
  
  public final void setChipIconVisible(boolean paramBoolean)
  {
    AppMethodBeat.i(236122);
    int i;
    if (this.byS != paramBoolean)
    {
      boolean bool = wE();
      this.byS = paramBoolean;
      paramBoolean = wE();
      if (bool == paramBoolean) {
        break label67;
      }
      i = 1;
      if (i != 0)
      {
        if (!paramBoolean) {
          break label72;
        }
        z(this.byT);
      }
    }
    for (;;)
    {
      invalidateSelf();
      wD();
      AppMethodBeat.o(236122);
      return;
      label67:
      i = 0;
      break;
      label72:
      y(this.byT);
    }
  }
  
  public final void setChipMinHeight(float paramFloat)
  {
    AppMethodBeat.i(236108);
    if (this.byL != paramFloat)
    {
      this.byL = paramFloat;
      invalidateSelf();
      wD();
    }
    AppMethodBeat.o(236108);
  }
  
  public final void setChipStartPadding(float paramFloat)
  {
    AppMethodBeat.i(236143);
    if (this.bzg != paramFloat)
    {
      this.bzg = paramFloat;
      invalidateSelf();
      wD();
    }
    AppMethodBeat.o(236143);
  }
  
  public final void setChipStrokeColor(ColorStateList paramColorStateList)
  {
    AppMethodBeat.i(236114);
    if (this.byN != paramColorStateList)
    {
      this.byN = paramColorStateList;
      onStateChange(getState());
    }
    AppMethodBeat.o(236114);
  }
  
  public final void setChipStrokeWidth(float paramFloat)
  {
    AppMethodBeat.i(236116);
    if (this.byO != paramFloat)
    {
      this.byO = paramFloat;
      this.bzp.setStrokeWidth(paramFloat);
      invalidateSelf();
    }
    AppMethodBeat.o(236116);
  }
  
  public final void setCloseIcon(Drawable paramDrawable)
  {
    AppMethodBeat.i(236133);
    Drawable localDrawable = getCloseIcon();
    float f1;
    if (localDrawable != paramDrawable)
    {
      f1 = wJ();
      if (paramDrawable == null) {
        break label86;
      }
    }
    label86:
    for (paramDrawable = androidx.core.graphics.drawable.a.p(paramDrawable).mutate();; paramDrawable = null)
    {
      this.byX = paramDrawable;
      float f2 = wJ();
      y(localDrawable);
      if (wG()) {
        z(this.byX);
      }
      invalidateSelf();
      if (f1 != f2) {
        wD();
      }
      AppMethodBeat.o(236133);
      return;
    }
  }
  
  public final void setCloseIconEndPadding(float paramFloat)
  {
    AppMethodBeat.i(236151);
    if (this.bzm != paramFloat)
    {
      this.bzm = paramFloat;
      invalidateSelf();
      if (wG()) {
        wD();
      }
    }
    AppMethodBeat.o(236151);
  }
  
  public final void setCloseIconSize(float paramFloat)
  {
    AppMethodBeat.i(236137);
    if (this.byZ != paramFloat)
    {
      this.byZ = paramFloat;
      invalidateSelf();
      if (wG()) {
        wD();
      }
    }
    AppMethodBeat.o(236137);
  }
  
  public final void setCloseIconStartPadding(float paramFloat)
  {
    AppMethodBeat.i(236150);
    if (this.bzl != paramFloat)
    {
      this.bzl = paramFloat;
      invalidateSelf();
      if (wG()) {
        wD();
      }
    }
    AppMethodBeat.o(236150);
  }
  
  public final void setCloseIconTint(ColorStateList paramColorStateList)
  {
    AppMethodBeat.i(236136);
    if (this.byY != paramColorStateList)
    {
      this.byY = paramColorStateList;
      if (wG()) {
        androidx.core.graphics.drawable.a.a(this.byX, paramColorStateList);
      }
      onStateChange(getState());
    }
    AppMethodBeat.o(236136);
  }
  
  public final void setCloseIconVisible(boolean paramBoolean)
  {
    AppMethodBeat.i(236131);
    int i;
    if (this.byW != paramBoolean)
    {
      boolean bool = wG();
      this.byW = paramBoolean;
      paramBoolean = wG();
      if (bool == paramBoolean) {
        break label67;
      }
      i = 1;
      if (i != 0)
      {
        if (!paramBoolean) {
          break label72;
        }
        z(this.byX);
      }
    }
    for (;;)
    {
      invalidateSelf();
      wD();
      AppMethodBeat.o(236131);
      return;
      label67:
      i = 0;
      break;
      label72:
      y(this.byX);
    }
  }
  
  public void setColorFilter(ColorFilter paramColorFilter)
  {
    AppMethodBeat.i(236077);
    if (this.bzz != paramColorFilter)
    {
      this.bzz = paramColorFilter;
      invalidateSelf();
    }
    AppMethodBeat.o(236077);
  }
  
  public final void setIconEndPadding(float paramFloat)
  {
    AppMethodBeat.i(236147);
    if (this.bzi != paramFloat)
    {
      float f = wH();
      this.bzi = paramFloat;
      paramFloat = wH();
      invalidateSelf();
      if (f != paramFloat) {
        wD();
      }
    }
    AppMethodBeat.o(236147);
  }
  
  public final void setIconStartPadding(float paramFloat)
  {
    AppMethodBeat.i(236145);
    if (this.bzh != paramFloat)
    {
      float f = wH();
      this.bzh = paramFloat;
      paramFloat = wH();
      invalidateSelf();
      if (f != paramFloat) {
        wD();
      }
    }
    AppMethodBeat.o(236145);
  }
  
  public final void setRippleColor(ColorStateList paramColorStateList)
  {
    AppMethodBeat.i(236117);
    if (this.byg != paramColorStateList)
    {
      this.byg = paramColorStateList;
      wL();
      onStateChange(getState());
    }
    AppMethodBeat.o(236117);
  }
  
  public final void setText(CharSequence paramCharSequence)
  {
    AppMethodBeat.i(236118);
    Object localObject = paramCharSequence;
    if (paramCharSequence == null) {
      localObject = "";
    }
    if (this.byP != localObject)
    {
      this.byP = ((CharSequence)localObject);
      this.byQ = androidx.core.e.a.gI().p((CharSequence)localObject);
      this.bzH = true;
      invalidateSelf();
      wD();
    }
    AppMethodBeat.o(236118);
  }
  
  public final void setTextAppearance(com.google.android.material.e.b paramb)
  {
    AppMethodBeat.i(236120);
    if (this.byR != paramb)
    {
      this.byR = paramb;
      if (paramb != null)
      {
        paramb.c(this.context, this.bzo, this.byH);
        this.bzH = true;
      }
      onStateChange(getState());
      wD();
    }
    AppMethodBeat.o(236120);
  }
  
  public final void setTextAppearanceResource(int paramInt)
  {
    AppMethodBeat.i(236119);
    setTextAppearance(new com.google.android.material.e.b(this.context, paramInt));
    AppMethodBeat.o(236119);
  }
  
  public final void setTextEndPadding(float paramFloat)
  {
    AppMethodBeat.i(236149);
    if (this.bzk != paramFloat)
    {
      this.bzk = paramFloat;
      invalidateSelf();
      wD();
    }
    AppMethodBeat.o(236149);
  }
  
  public final void setTextStartPadding(float paramFloat)
  {
    AppMethodBeat.i(236148);
    if (this.bzj != paramFloat)
    {
      this.bzj = paramFloat;
      invalidateSelf();
      wD();
    }
    AppMethodBeat.o(236148);
  }
  
  public void setTintList(ColorStateList paramColorStateList)
  {
    AppMethodBeat.i(236081);
    if (this.bzB != paramColorStateList)
    {
      this.bzB = paramColorStateList;
      onStateChange(getState());
    }
    AppMethodBeat.o(236081);
  }
  
  public void setTintMode(PorterDuff.Mode paramMode)
  {
    AppMethodBeat.i(236083);
    if (this.bzC != paramMode)
    {
      this.bzC = paramMode;
      this.bzA = com.google.android.material.b.a.a(this, this.bzB, paramMode);
      invalidateSelf();
    }
    AppMethodBeat.o(236083);
  }
  
  public boolean setVisible(boolean paramBoolean1, boolean paramBoolean2)
  {
    AppMethodBeat.i(236075);
    boolean bool2 = super.setVisible(paramBoolean1, paramBoolean2);
    boolean bool1 = bool2;
    if (wE()) {
      bool1 = bool2 | this.byT.setVisible(paramBoolean1, paramBoolean2);
    }
    bool2 = bool1;
    if (wF()) {
      bool2 = bool1 | this.bzd.setVisible(paramBoolean1, paramBoolean2);
    }
    bool1 = bool2;
    if (wG()) {
      bool1 = bool2 | this.byX.setVisible(paramBoolean1, paramBoolean2);
    }
    if (bool1) {
      invalidateSelf();
    }
    AppMethodBeat.o(236075);
    return bool1;
  }
  
  public void unscheduleDrawable(Drawable paramDrawable, Runnable paramRunnable)
  {
    AppMethodBeat.i(236097);
    paramDrawable = getCallback();
    if (paramDrawable != null) {
      paramDrawable.unscheduleDrawable(this, paramRunnable);
    }
    AppMethodBeat.o(236097);
  }
  
  protected final void wD()
  {
    AppMethodBeat.i(236022);
    a locala = (a)this.bzG.get();
    if (locala != null) {
      locala.wy();
    }
    AppMethodBeat.o(236022);
  }
  
  final float wH()
  {
    AppMethodBeat.i(236035);
    if ((wE()) || (wF()))
    {
      float f1 = this.bzh;
      float f2 = this.byV;
      float f3 = this.bzi;
      AppMethodBeat.o(236035);
      return f1 + f2 + f3;
    }
    AppMethodBeat.o(236035);
    return 0.0F;
  }
  
  public static abstract interface a
  {
    public abstract void wy();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.google.android.material.chip.a
 * JD-Core Version:    0.7.0.1
 */