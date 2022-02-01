package android.support.design.chip;

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
import android.support.design.a.h;
import android.support.design.internal.f;
import android.support.v4.content.a.f.a;
import android.support.v4.graphics.drawable.e;
import android.text.TextPaint;
import android.text.TextUtils;
import android.text.TextUtils.TruncateAt;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import java.lang.ref.WeakReference;
import java.util.Arrays;

public final class a
  extends Drawable
  implements Drawable.Callback, e
{
  private static final int[] fv = { 16842910 };
  private int alpha = 255;
  final Context context;
  ColorStateList eR;
  private final RectF eU = new RectF();
  float fA;
  CharSequence fB;
  private CharSequence fC;
  android.support.design.d.b fD;
  boolean fE;
  private Drawable fF;
  ColorStateList fG;
  float fH;
  boolean fI;
  Drawable fJ;
  ColorStateList fK;
  float fL;
  CharSequence fM;
  boolean fN;
  boolean fO;
  Drawable fP;
  h fQ;
  h fR;
  float fS;
  float fT;
  float fU;
  float fV;
  float fW;
  float fX;
  float fY;
  float fZ;
  private final f.a ft = new f.a()
  {
    public final void D(int paramAnonymousInt) {}
    
    public final void a(Typeface paramAnonymousTypeface)
    {
      a.a(a.this);
      a.this.aM();
      a.this.invalidateSelf();
    }
  };
  ColorStateList fw;
  float fx;
  float fy;
  ColorStateList fz;
  private final TextPaint ga = new TextPaint(1);
  private final Paint gb = new Paint(1);
  private final Paint gc;
  private final Paint.FontMetrics gd = new Paint.FontMetrics();
  private final PointF ge = new PointF();
  private int gf;
  private int gg;
  private int gh;
  private int gi;
  private boolean gj;
  private int gk;
  private ColorFilter gl;
  private PorterDuffColorFilter gm;
  private ColorStateList gn;
  private PorterDuff.Mode go = PorterDuff.Mode.SRC_IN;
  private int[] gp;
  private boolean gq;
  private ColorStateList gr;
  private WeakReference<a> gs = new WeakReference(null);
  private boolean gt = true;
  private float gu;
  TextUtils.TruncateAt gv;
  boolean gw;
  int maxWidth;
  
  private a(Context paramContext)
  {
    this.context = paramContext;
    this.fB = "";
    this.ga.density = paramContext.getResources().getDisplayMetrics().density;
    this.gc = null;
    if (this.gc != null) {
      this.gc.setStyle(Paint.Style.STROKE);
    }
    setState(fv);
    b(fv);
    this.gw = true;
  }
  
  public static a a(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    a locala = new a(paramContext);
    TypedArray localTypedArray = f.a(locala.context, paramAttributeSet, android.support.design.a.a.Chip, paramInt, 2131821659, new int[0]);
    locala.setChipBackgroundColor(android.support.design.d.a.b(locala.context, localTypedArray, 8));
    locala.setChipMinHeight(localTypedArray.getDimension(16, 0.0F));
    locala.setChipCornerRadius(localTypedArray.getDimension(9, 0.0F));
    locala.setChipStrokeColor(android.support.design.d.a.b(locala.context, localTypedArray, 18));
    locala.setChipStrokeWidth(localTypedArray.getDimension(19, 0.0F));
    locala.setRippleColor(android.support.design.d.a.b(locala.context, localTypedArray, 30));
    locala.setText(localTypedArray.getText(3));
    paramContext = locala.context;
    if (localTypedArray.hasValue(0))
    {
      paramInt = localTypedArray.getResourceId(0, 0);
      if (paramInt != 0)
      {
        paramContext = new android.support.design.d.b(paramContext, paramInt);
        locala.setTextAppearance(paramContext);
        switch (localTypedArray.getInt(1, 0))
        {
        }
      }
    }
    for (;;)
    {
      locala.setChipIconVisible(localTypedArray.getBoolean(15, false));
      if ((paramAttributeSet != null) && (paramAttributeSet.getAttributeValue("http://schemas.android.com/apk/res-auto", "chipIconEnabled") != null) && (paramAttributeSet.getAttributeValue("http://schemas.android.com/apk/res-auto", "chipIconVisible") == null)) {
        locala.setChipIconVisible(localTypedArray.getBoolean(12, false));
      }
      locala.setChipIcon(android.support.design.d.a.c(locala.context, localTypedArray, 11));
      locala.setChipIconTint(android.support.design.d.a.b(locala.context, localTypedArray, 14));
      locala.setChipIconSize(localTypedArray.getDimension(13, 0.0F));
      locala.setCloseIconVisible(localTypedArray.getBoolean(26, false));
      if ((paramAttributeSet != null) && (paramAttributeSet.getAttributeValue("http://schemas.android.com/apk/res-auto", "closeIconEnabled") != null) && (paramAttributeSet.getAttributeValue("http://schemas.android.com/apk/res-auto", "closeIconVisible") == null)) {
        locala.setCloseIconVisible(localTypedArray.getBoolean(21, false));
      }
      locala.setCloseIcon(android.support.design.d.a.c(locala.context, localTypedArray, 20));
      locala.setCloseIconTint(android.support.design.d.a.b(locala.context, localTypedArray, 25));
      locala.setCloseIconSize(localTypedArray.getDimension(23, 0.0F));
      locala.setCheckable(localTypedArray.getBoolean(4, false));
      locala.setCheckedIconVisible(localTypedArray.getBoolean(7, false));
      if ((paramAttributeSet != null) && (paramAttributeSet.getAttributeValue("http://schemas.android.com/apk/res-auto", "checkedIconEnabled") != null) && (paramAttributeSet.getAttributeValue("http://schemas.android.com/apk/res-auto", "checkedIconVisible") == null)) {
        locala.setCheckedIconVisible(localTypedArray.getBoolean(6, false));
      }
      locala.setCheckedIcon(android.support.design.d.a.c(locala.context, localTypedArray, 5));
      locala.fQ = h.a(locala.context, localTypedArray, 31);
      locala.fR = h.a(locala.context, localTypedArray, 27);
      locala.setChipStartPadding(localTypedArray.getDimension(17, 0.0F));
      locala.setIconStartPadding(localTypedArray.getDimension(29, 0.0F));
      locala.setIconEndPadding(localTypedArray.getDimension(28, 0.0F));
      locala.setTextStartPadding(localTypedArray.getDimension(33, 0.0F));
      locala.setTextEndPadding(localTypedArray.getDimension(32, 0.0F));
      locala.setCloseIconStartPadding(localTypedArray.getDimension(24, 0.0F));
      locala.setCloseIconEndPadding(localTypedArray.getDimension(22, 0.0F));
      locala.setChipEndPadding(localTypedArray.getDimension(10, 0.0F));
      locala.maxWidth = localTypedArray.getDimensionPixelSize(2, 2147483647);
      localTypedArray.recycle();
      return locala;
      paramContext = null;
      break;
      locala.gv = TextUtils.TruncateAt.START;
      continue;
      locala.gv = TextUtils.TruncateAt.MIDDLE;
      continue;
      locala.gv = TextUtils.TruncateAt.END;
    }
  }
  
  private void a(Rect paramRect, RectF paramRectF)
  {
    paramRectF.setEmpty();
    float f;
    if ((aN()) || (aO()))
    {
      f = this.fS + this.fT;
      if (android.support.v4.graphics.drawable.a.k(this) != 0) {
        break label88;
      }
      paramRectF.left = (f + paramRect.left);
      paramRectF.right = (paramRectF.left + this.fH);
    }
    for (;;)
    {
      paramRectF.top = (paramRect.exactCenterY() - this.fH / 2.0F);
      paramRectF.bottom = (paramRectF.top + this.fH);
      return;
      label88:
      paramRectF.right = (paramRect.right - f);
      paramRectF.left = (paramRectF.right - this.fH);
    }
  }
  
  private static boolean a(ColorStateList paramColorStateList)
  {
    return (paramColorStateList != null) && (paramColorStateList.isStateful());
  }
  
  private boolean aN()
  {
    return (this.fE) && (this.fF != null);
  }
  
  private boolean aO()
  {
    return (this.fO) && (this.fP != null) && (this.gj);
  }
  
  private boolean aP()
  {
    return (this.fI) && (this.fJ != null);
  }
  
  private float aR()
  {
    if (!this.gt) {
      return this.gu;
    }
    this.gu = b(this.fC);
    this.gt = false;
    return this.gu;
  }
  
  private float aS()
  {
    if (aP()) {
      return this.fX + this.fL + this.fY;
    }
    return 0.0F;
  }
  
  private ColorFilter aT()
  {
    if (this.gl != null) {
      return this.gl;
    }
    return this.gm;
  }
  
  private void aU()
  {
    if (this.gq) {}
    for (ColorStateList localColorStateList = android.support.design.e.a.b(this.eR);; localColorStateList = null)
    {
      this.gr = localColorStateList;
      return;
    }
  }
  
  private float b(CharSequence paramCharSequence)
  {
    if (paramCharSequence == null) {
      return 0.0F;
    }
    return this.ga.measureText(paramCharSequence, 0, paramCharSequence.length());
  }
  
  private void b(Rect paramRect, RectF paramRectF)
  {
    paramRectF.setEmpty();
    float f;
    if (aP())
    {
      f = this.fZ + this.fY;
      if (android.support.v4.graphics.drawable.a.k(this) != 0) {
        break label81;
      }
      paramRectF.right = (paramRect.right - f);
      paramRectF.left = (paramRectF.right - this.fL);
    }
    for (;;)
    {
      paramRectF.top = (paramRect.exactCenterY() - this.fL / 2.0F);
      paramRectF.bottom = (paramRectF.top + this.fL);
      return;
      label81:
      paramRectF.left = (f + paramRect.left);
      paramRectF.right = (paramRectF.left + this.fL);
    }
  }
  
  static boolean b(Drawable paramDrawable)
  {
    return (paramDrawable != null) && (paramDrawable.isStateful());
  }
  
  private boolean b(int[] paramArrayOfInt1, int[] paramArrayOfInt2)
  {
    int j = 0;
    boolean bool3 = true;
    boolean bool1 = super.onStateChange(paramArrayOfInt1);
    int i;
    if (this.fw != null)
    {
      i = this.fw.getColorForState(paramArrayOfInt1, this.gf);
      if (this.gf == i) {
        break label473;
      }
      this.gf = i;
      bool1 = true;
    }
    label73:
    label458:
    label467:
    label473:
    for (;;)
    {
      label112:
      boolean bool2;
      if (this.fz != null)
      {
        i = this.fz.getColorForState(paramArrayOfInt1, this.gg);
        if (this.gg != i)
        {
          this.gg = i;
          bool1 = true;
        }
        if (this.gr == null) {
          break label433;
        }
        i = this.gr.getColorForState(paramArrayOfInt1, this.gh);
        bool2 = bool1;
        if (this.gh != i)
        {
          this.gh = i;
          bool2 = bool1;
          if (this.gq) {
            bool2 = true;
          }
        }
        if ((this.fD == null) || (this.fD.ii == null)) {
          break label439;
        }
        i = this.fD.ii.getColorForState(paramArrayOfInt1, this.gi);
        bool1 = bool2;
        if (this.gi != i)
        {
          this.gi = i;
          bool1 = true;
        }
        if ((!c(getState())) || (!this.fN)) {
          break label445;
        }
        bool2 = true;
        label221:
        if ((this.gj == bool2) || (this.fP == null)) {
          break label467;
        }
        float f = aQ();
        this.gj = bool2;
        if (f == aQ()) {
          break label458;
        }
        i = 1;
        bool1 = true;
      }
      for (;;)
      {
        if (this.gn != null) {
          j = this.gn.getColorForState(paramArrayOfInt1, this.gk);
        }
        if (this.gk != j)
        {
          this.gk = j;
          this.gm = android.support.design.b.a.a(this, this.gn, this.go);
        }
        for (bool2 = bool3;; bool2 = bool1)
        {
          bool1 = bool2;
          if (b(this.fF)) {
            bool1 = bool2 | this.fF.setState(paramArrayOfInt1);
          }
          bool2 = bool1;
          if (b(this.fP)) {
            bool2 = bool1 | this.fP.setState(paramArrayOfInt1);
          }
          bool1 = bool2;
          if (b(this.fJ)) {
            bool1 = bool2 | this.fJ.setState(paramArrayOfInt2);
          }
          if (bool1) {
            invalidateSelf();
          }
          if (i != 0) {
            aM();
          }
          return bool1;
          i = 0;
          break;
          i = 0;
          break label73;
          i = 0;
          break label112;
          i = 0;
          break label179;
          bool2 = false;
          break label221;
        }
        i = 0;
        bool1 = true;
        continue;
        i = 0;
      }
    }
  }
  
  private static void c(Drawable paramDrawable)
  {
    if (paramDrawable != null) {
      paramDrawable.setCallback(null);
    }
  }
  
  private static boolean c(int[] paramArrayOfInt)
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
  
  private void d(Drawable paramDrawable)
  {
    if (paramDrawable != null)
    {
      paramDrawable.setCallback(this);
      android.support.v4.graphics.drawable.a.b(paramDrawable, android.support.v4.graphics.drawable.a.k(this));
      paramDrawable.setLevel(getLevel());
      paramDrawable.setVisible(isVisible(), false);
      if (paramDrawable != this.fJ) {
        break label70;
      }
      if (paramDrawable.isStateful()) {
        paramDrawable.setState(this.gp);
      }
      android.support.v4.graphics.drawable.a.a(paramDrawable, this.fK);
    }
    label70:
    while (!paramDrawable.isStateful()) {
      return;
    }
    paramDrawable.setState(getState());
  }
  
  public final void a(a parama)
  {
    this.gs = new WeakReference(parama);
  }
  
  protected final void aM()
  {
    a locala = (a)this.gs.get();
    if (locala != null) {
      locala.aH();
    }
  }
  
  final float aQ()
  {
    if ((aN()) || (aO())) {
      return this.fT + this.fH + this.fU;
    }
    return 0.0F;
  }
  
  public final boolean b(int[] paramArrayOfInt)
  {
    if (!Arrays.equals(this.gp, paramArrayOfInt))
    {
      this.gp = paramArrayOfInt;
      if (aP()) {
        return b(getState(), paramArrayOfInt);
      }
    }
    return false;
  }
  
  final void c(Rect paramRect, RectF paramRectF)
  {
    paramRectF.setEmpty();
    float f;
    if (aP())
    {
      f = this.fZ + this.fY + this.fL + this.fX + this.fW;
      if (android.support.v4.graphics.drawable.a.k(this) != 0) {
        break label81;
      }
      paramRectF.right = paramRect.right;
      paramRectF.left = (paramRectF.right - f);
    }
    for (;;)
    {
      paramRectF.top = paramRect.top;
      paramRectF.bottom = paramRect.bottom;
      return;
      label81:
      paramRectF.left = paramRect.left;
      paramRectF.right = (f + paramRect.left);
    }
  }
  
  public final void draw(Canvas paramCanvas)
  {
    Rect localRect = getBounds();
    if ((localRect.isEmpty()) || (getAlpha() == 0)) {
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
      label90:
      this.gb.setColor(this.gf);
      this.gb.setStyle(Paint.Style.FILL);
      this.gb.setColorFilter(aT());
      this.eU.set(localRect);
      paramCanvas.drawRoundRect(this.eU, this.fy, this.fy, this.gb);
      if (this.fA > 0.0F)
      {
        this.gb.setColor(this.gg);
        this.gb.setStyle(Paint.Style.STROKE);
        this.gb.setColorFilter(aT());
        this.eU.set(localRect.left + this.fA / 2.0F, localRect.top + this.fA / 2.0F, localRect.right - this.fA / 2.0F, localRect.bottom - this.fA / 2.0F);
        f1 = this.fy - this.fA / 2.0F;
        paramCanvas.drawRoundRect(this.eU, f1, f1, this.gb);
      }
      this.gb.setColor(this.gh);
      this.gb.setStyle(Paint.Style.FILL);
      this.eU.set(localRect);
      paramCanvas.drawRoundRect(this.eU, this.fy, this.fy, this.gb);
      if (aN())
      {
        a(localRect, this.eU);
        f1 = this.eU.left;
        f2 = this.eU.top;
        paramCanvas.translate(f1, f2);
        this.fF.setBounds(0, 0, (int)this.eU.width(), (int)this.eU.height());
        this.fF.draw(paramCanvas);
        paramCanvas.translate(-f1, -f2);
      }
      if (aO())
      {
        a(localRect, this.eU);
        f1 = this.eU.left;
        f2 = this.eU.top;
        paramCanvas.translate(f1, f2);
        this.fP.setBounds(0, 0, (int)this.eU.width(), (int)this.eU.height());
        this.fP.draw(paramCanvas);
        paramCanvas.translate(-f1, -f2);
      }
      Object localObject2;
      Object localObject1;
      label568:
      int j;
      label692:
      int k;
      if ((this.gw) && (this.fC != null))
      {
        localObject2 = this.ge;
        ((PointF)localObject2).set(0.0F, 0.0F);
        localObject1 = Paint.Align.LEFT;
        if (this.fC != null)
        {
          f1 = this.fS + aQ() + this.fV;
          if (android.support.v4.graphics.drawable.a.k(this) != 0) {
            break label1275;
          }
          ((PointF)localObject2).x = (f1 + localRect.left);
          localObject1 = Paint.Align.LEFT;
          f1 = localRect.centerY();
          this.ga.getFontMetrics(this.gd);
          ((PointF)localObject2).y = (f1 - (this.gd.descent + this.gd.ascent) / 2.0F);
        }
        localObject2 = this.eU;
        ((RectF)localObject2).setEmpty();
        if (this.fC != null)
        {
          f1 = this.fS + aQ() + this.fV;
          f2 = this.fZ + aS() + this.fW;
          if (android.support.v4.graphics.drawable.a.k(this) != 0) {
            break label1296;
          }
          ((RectF)localObject2).left = (f1 + localRect.left);
          ((RectF)localObject2).right = (localRect.right - f2);
          ((RectF)localObject2).top = localRect.top;
          ((RectF)localObject2).bottom = localRect.bottom;
        }
        if (this.fD != null)
        {
          this.ga.drawableState = getState();
          this.fD.b(this.context, this.ga, this.ft);
        }
        this.ga.setTextAlign((Paint.Align)localObject1);
        if (Math.round(aR()) <= Math.round(this.eU.width())) {
          break label1325;
        }
        j = 1;
        label783:
        if (j == 0) {
          break label1347;
        }
        k = paramCanvas.save();
        paramCanvas.clipRect(this.eU);
      }
      for (;;)
      {
        localObject2 = this.fC;
        localObject1 = localObject2;
        if (j != 0)
        {
          localObject1 = localObject2;
          if (this.gv != null) {
            localObject1 = TextUtils.ellipsize(this.fC, this.ga, this.eU.width(), this.gv);
          }
        }
        paramCanvas.drawText((CharSequence)localObject1, 0, ((CharSequence)localObject1).length(), this.ge.x, this.ge.y, this.ga);
        if (j != 0) {
          paramCanvas.restoreToCount(k);
        }
        if (aP())
        {
          b(localRect, this.eU);
          f1 = this.eU.left;
          f2 = this.eU.top;
          paramCanvas.translate(f1, f2);
          this.fJ.setBounds(0, 0, (int)this.eU.width(), (int)this.eU.height());
          this.fJ.draw(paramCanvas);
          paramCanvas.translate(-f1, -f2);
        }
        if (this.gc != null)
        {
          this.gc.setColor(android.support.v4.graphics.b.q(-16777216, 127));
          paramCanvas.drawRect(localRect, this.gc);
          if ((aN()) || (aO()))
          {
            a(localRect, this.eU);
            paramCanvas.drawRect(this.eU, this.gc);
          }
          if (this.fC != null) {
            paramCanvas.drawLine(localRect.left, localRect.exactCenterY(), localRect.right, localRect.exactCenterY(), this.gc);
          }
          if (aP())
          {
            b(localRect, this.eU);
            paramCanvas.drawRect(this.eU, this.gc);
          }
          this.gc.setColor(android.support.v4.graphics.b.q(-65536, 127));
          localObject1 = this.eU;
          ((RectF)localObject1).set(localRect);
          if (aP())
          {
            f1 = this.fZ + this.fY + this.fL + this.fX + this.fW;
            if (android.support.v4.graphics.drawable.a.k(this) != 0) {
              break label1331;
            }
            ((RectF)localObject1).right = (localRect.right - f1);
          }
        }
        for (;;)
        {
          paramCanvas.drawRect(this.eU, this.gc);
          this.gc.setColor(android.support.v4.graphics.b.q(-16711936, 127));
          c(localRect, this.eU);
          paramCanvas.drawRect(this.eU, this.gc);
          if (this.alpha >= 255) {
            break;
          }
          paramCanvas.restoreToCount(i);
          return;
          i = paramCanvas.saveLayerAlpha(f1, f2, f3, f4, i, 31);
          break label90;
          label1275:
          ((PointF)localObject2).x = (localRect.right - f1);
          localObject1 = Paint.Align.RIGHT;
          break label568;
          label1296:
          ((RectF)localObject2).left = (f2 + localRect.left);
          ((RectF)localObject2).right = (localRect.right - f1);
          break label692;
          label1325:
          j = 0;
          break label783;
          label1331:
          ((RectF)localObject1).left = (f1 + localRect.left);
        }
        label1347:
        k = 0;
      }
      i = 0;
    }
  }
  
  public final int getAlpha()
  {
    return this.alpha;
  }
  
  public final Drawable getChipIcon()
  {
    if (this.fF != null) {
      return android.support.v4.graphics.drawable.a.j(this.fF);
    }
    return null;
  }
  
  public final Drawable getCloseIcon()
  {
    if (this.fJ != null) {
      return android.support.v4.graphics.drawable.a.j(this.fJ);
    }
    return null;
  }
  
  public final ColorFilter getColorFilter()
  {
    return this.gl;
  }
  
  public final int getIntrinsicHeight()
  {
    return (int)this.fx;
  }
  
  public final int getIntrinsicWidth()
  {
    return Math.min(Math.round(this.fS + aQ() + this.fV + aR() + this.fW + aS() + this.fZ), this.maxWidth);
  }
  
  public final int getOpacity()
  {
    return -3;
  }
  
  @TargetApi(21)
  public final void getOutline(Outline paramOutline)
  {
    Rect localRect = getBounds();
    if (!localRect.isEmpty()) {
      paramOutline.setRoundRect(localRect, this.fy);
    }
    for (;;)
    {
      paramOutline.setAlpha(getAlpha() / 255.0F);
      return;
      paramOutline.setRoundRect(0, 0, getIntrinsicWidth(), getIntrinsicHeight(), this.fy);
    }
  }
  
  public final void invalidateDrawable(Drawable paramDrawable)
  {
    paramDrawable = getCallback();
    if (paramDrawable != null) {
      paramDrawable.invalidateDrawable(this);
    }
  }
  
  public final boolean isStateful()
  {
    boolean bool = false;
    if ((!a(this.fw)) && (!a(this.fz)) && ((!this.gq) || (!a(this.gr))))
    {
      android.support.design.d.b localb = this.fD;
      if ((localb == null) || (localb.ii == null) || (!localb.ii.isStateful())) {
        break label132;
      }
      i = 1;
      if (i == 0) {
        if ((!this.fO) || (this.fP == null) || (!this.fN)) {
          break label137;
        }
      }
    }
    label132:
    label137:
    for (int i = 1;; i = 0)
    {
      if ((i != 0) || (b(this.fF)) || (b(this.fP)) || (a(this.gn))) {
        bool = true;
      }
      return bool;
      i = 0;
      break;
    }
  }
  
  public final void o(boolean paramBoolean)
  {
    if (this.gq != paramBoolean)
    {
      this.gq = paramBoolean;
      aU();
      onStateChange(getState());
    }
  }
  
  @TargetApi(23)
  public final boolean onLayoutDirectionChanged(int paramInt)
  {
    boolean bool2 = super.onLayoutDirectionChanged(paramInt);
    boolean bool1 = bool2;
    if (aN()) {
      bool1 = bool2 | this.fF.setLayoutDirection(paramInt);
    }
    bool2 = bool1;
    if (aO()) {
      bool2 = bool1 | this.fP.setLayoutDirection(paramInt);
    }
    bool1 = bool2;
    if (aP()) {
      bool1 = bool2 | this.fJ.setLayoutDirection(paramInt);
    }
    if (bool1) {
      invalidateSelf();
    }
    return true;
  }
  
  protected final boolean onLevelChange(int paramInt)
  {
    boolean bool2 = super.onLevelChange(paramInt);
    boolean bool1 = bool2;
    if (aN()) {
      bool1 = bool2 | this.fF.setLevel(paramInt);
    }
    bool2 = bool1;
    if (aO()) {
      bool2 = bool1 | this.fP.setLevel(paramInt);
    }
    bool1 = bool2;
    if (aP()) {
      bool1 = bool2 | this.fJ.setLevel(paramInt);
    }
    if (bool1) {
      invalidateSelf();
    }
    return bool1;
  }
  
  protected final boolean onStateChange(int[] paramArrayOfInt)
  {
    return b(paramArrayOfInt, this.gp);
  }
  
  public final void scheduleDrawable(Drawable paramDrawable, Runnable paramRunnable, long paramLong)
  {
    paramDrawable = getCallback();
    if (paramDrawable != null) {
      paramDrawable.scheduleDrawable(this, paramRunnable, paramLong);
    }
  }
  
  public final void setAlpha(int paramInt)
  {
    if (this.alpha != paramInt)
    {
      this.alpha = paramInt;
      invalidateSelf();
    }
  }
  
  public final void setCheckable(boolean paramBoolean)
  {
    if (this.fN != paramBoolean)
    {
      this.fN = paramBoolean;
      float f1 = aQ();
      if ((!paramBoolean) && (this.gj)) {
        this.gj = false;
      }
      float f2 = aQ();
      invalidateSelf();
      if (f1 != f2) {
        aM();
      }
    }
  }
  
  public final void setCheckedIcon(Drawable paramDrawable)
  {
    if (this.fP != paramDrawable)
    {
      float f1 = aQ();
      this.fP = paramDrawable;
      float f2 = aQ();
      c(this.fP);
      d(this.fP);
      invalidateSelf();
      if (f1 != f2) {
        aM();
      }
    }
  }
  
  public final void setCheckedIconVisible(boolean paramBoolean)
  {
    int i;
    if (this.fO != paramBoolean)
    {
      boolean bool = aO();
      this.fO = paramBoolean;
      paramBoolean = aO();
      if (bool == paramBoolean) {
        break label55;
      }
      i = 1;
      if (i != 0)
      {
        if (!paramBoolean) {
          break label60;
        }
        d(this.fP);
      }
    }
    for (;;)
    {
      invalidateSelf();
      aM();
      return;
      label55:
      i = 0;
      break;
      label60:
      c(this.fP);
    }
  }
  
  public final void setChipBackgroundColor(ColorStateList paramColorStateList)
  {
    if (this.fw != paramColorStateList)
    {
      this.fw = paramColorStateList;
      onStateChange(getState());
    }
  }
  
  public final void setChipCornerRadius(float paramFloat)
  {
    if (this.fy != paramFloat)
    {
      this.fy = paramFloat;
      invalidateSelf();
    }
  }
  
  public final void setChipEndPadding(float paramFloat)
  {
    if (this.fZ != paramFloat)
    {
      this.fZ = paramFloat;
      invalidateSelf();
      aM();
    }
  }
  
  public final void setChipIcon(Drawable paramDrawable)
  {
    Drawable localDrawable = getChipIcon();
    float f1;
    if (localDrawable != paramDrawable)
    {
      f1 = aQ();
      if (paramDrawable == null) {
        break label74;
      }
    }
    label74:
    for (paramDrawable = android.support.v4.graphics.drawable.a.i(paramDrawable).mutate();; paramDrawable = null)
    {
      this.fF = paramDrawable;
      float f2 = aQ();
      c(localDrawable);
      if (aN()) {
        d(this.fF);
      }
      invalidateSelf();
      if (f1 != f2) {
        aM();
      }
      return;
    }
  }
  
  public final void setChipIconSize(float paramFloat)
  {
    if (this.fH != paramFloat)
    {
      float f = aQ();
      this.fH = paramFloat;
      paramFloat = aQ();
      invalidateSelf();
      if (f != paramFloat) {
        aM();
      }
    }
  }
  
  public final void setChipIconTint(ColorStateList paramColorStateList)
  {
    if (this.fG != paramColorStateList)
    {
      this.fG = paramColorStateList;
      if (aN()) {
        android.support.v4.graphics.drawable.a.a(this.fF, paramColorStateList);
      }
      onStateChange(getState());
    }
  }
  
  public final void setChipIconVisible(boolean paramBoolean)
  {
    int i;
    if (this.fE != paramBoolean)
    {
      boolean bool = aN();
      this.fE = paramBoolean;
      paramBoolean = aN();
      if (bool == paramBoolean) {
        break label55;
      }
      i = 1;
      if (i != 0)
      {
        if (!paramBoolean) {
          break label60;
        }
        d(this.fF);
      }
    }
    for (;;)
    {
      invalidateSelf();
      aM();
      return;
      label55:
      i = 0;
      break;
      label60:
      c(this.fF);
    }
  }
  
  public final void setChipMinHeight(float paramFloat)
  {
    if (this.fx != paramFloat)
    {
      this.fx = paramFloat;
      invalidateSelf();
      aM();
    }
  }
  
  public final void setChipStartPadding(float paramFloat)
  {
    if (this.fS != paramFloat)
    {
      this.fS = paramFloat;
      invalidateSelf();
      aM();
    }
  }
  
  public final void setChipStrokeColor(ColorStateList paramColorStateList)
  {
    if (this.fz != paramColorStateList)
    {
      this.fz = paramColorStateList;
      onStateChange(getState());
    }
  }
  
  public final void setChipStrokeWidth(float paramFloat)
  {
    if (this.fA != paramFloat)
    {
      this.fA = paramFloat;
      this.gb.setStrokeWidth(paramFloat);
      invalidateSelf();
    }
  }
  
  public final void setCloseIcon(Drawable paramDrawable)
  {
    Drawable localDrawable = getCloseIcon();
    float f1;
    if (localDrawable != paramDrawable)
    {
      f1 = aS();
      if (paramDrawable == null) {
        break label74;
      }
    }
    label74:
    for (paramDrawable = android.support.v4.graphics.drawable.a.i(paramDrawable).mutate();; paramDrawable = null)
    {
      this.fJ = paramDrawable;
      float f2 = aS();
      c(localDrawable);
      if (aP()) {
        d(this.fJ);
      }
      invalidateSelf();
      if (f1 != f2) {
        aM();
      }
      return;
    }
  }
  
  public final void setCloseIconEndPadding(float paramFloat)
  {
    if (this.fY != paramFloat)
    {
      this.fY = paramFloat;
      invalidateSelf();
      if (aP()) {
        aM();
      }
    }
  }
  
  public final void setCloseIconSize(float paramFloat)
  {
    if (this.fL != paramFloat)
    {
      this.fL = paramFloat;
      invalidateSelf();
      if (aP()) {
        aM();
      }
    }
  }
  
  public final void setCloseIconStartPadding(float paramFloat)
  {
    if (this.fX != paramFloat)
    {
      this.fX = paramFloat;
      invalidateSelf();
      if (aP()) {
        aM();
      }
    }
  }
  
  public final void setCloseIconTint(ColorStateList paramColorStateList)
  {
    if (this.fK != paramColorStateList)
    {
      this.fK = paramColorStateList;
      if (aP()) {
        android.support.v4.graphics.drawable.a.a(this.fJ, paramColorStateList);
      }
      onStateChange(getState());
    }
  }
  
  public final void setCloseIconVisible(boolean paramBoolean)
  {
    int i;
    if (this.fI != paramBoolean)
    {
      boolean bool = aP();
      this.fI = paramBoolean;
      paramBoolean = aP();
      if (bool == paramBoolean) {
        break label55;
      }
      i = 1;
      if (i != 0)
      {
        if (!paramBoolean) {
          break label60;
        }
        d(this.fJ);
      }
    }
    for (;;)
    {
      invalidateSelf();
      aM();
      return;
      label55:
      i = 0;
      break;
      label60:
      c(this.fJ);
    }
  }
  
  public final void setColorFilter(ColorFilter paramColorFilter)
  {
    if (this.gl != paramColorFilter)
    {
      this.gl = paramColorFilter;
      invalidateSelf();
    }
  }
  
  public final void setIconEndPadding(float paramFloat)
  {
    if (this.fU != paramFloat)
    {
      float f = aQ();
      this.fU = paramFloat;
      paramFloat = aQ();
      invalidateSelf();
      if (f != paramFloat) {
        aM();
      }
    }
  }
  
  public final void setIconStartPadding(float paramFloat)
  {
    if (this.fT != paramFloat)
    {
      float f = aQ();
      this.fT = paramFloat;
      paramFloat = aQ();
      invalidateSelf();
      if (f != paramFloat) {
        aM();
      }
    }
  }
  
  public final void setRippleColor(ColorStateList paramColorStateList)
  {
    if (this.eR != paramColorStateList)
    {
      this.eR = paramColorStateList;
      aU();
      onStateChange(getState());
    }
  }
  
  public final void setText(CharSequence paramCharSequence)
  {
    Object localObject = paramCharSequence;
    if (paramCharSequence == null) {
      localObject = "";
    }
    if (this.fB != localObject)
    {
      this.fB = ((CharSequence)localObject);
      this.fC = android.support.v4.d.a.eC().unicodeWrap((CharSequence)localObject);
      this.gt = true;
      invalidateSelf();
      aM();
    }
  }
  
  public final void setTextAppearance(android.support.design.d.b paramb)
  {
    if (this.fD != paramb)
    {
      this.fD = paramb;
      if (paramb != null)
      {
        paramb.c(this.context, this.ga, this.ft);
        this.gt = true;
      }
      onStateChange(getState());
      aM();
    }
  }
  
  public final void setTextAppearanceResource(int paramInt)
  {
    setTextAppearance(new android.support.design.d.b(this.context, paramInt));
  }
  
  public final void setTextEndPadding(float paramFloat)
  {
    if (this.fW != paramFloat)
    {
      this.fW = paramFloat;
      invalidateSelf();
      aM();
    }
  }
  
  public final void setTextStartPadding(float paramFloat)
  {
    if (this.fV != paramFloat)
    {
      this.fV = paramFloat;
      invalidateSelf();
      aM();
    }
  }
  
  public final void setTintList(ColorStateList paramColorStateList)
  {
    if (this.gn != paramColorStateList)
    {
      this.gn = paramColorStateList;
      onStateChange(getState());
    }
  }
  
  public final void setTintMode(PorterDuff.Mode paramMode)
  {
    if (this.go != paramMode)
    {
      this.go = paramMode;
      this.gm = android.support.design.b.a.a(this, this.gn, paramMode);
      invalidateSelf();
    }
  }
  
  public final boolean setVisible(boolean paramBoolean1, boolean paramBoolean2)
  {
    boolean bool2 = super.setVisible(paramBoolean1, paramBoolean2);
    boolean bool1 = bool2;
    if (aN()) {
      bool1 = bool2 | this.fF.setVisible(paramBoolean1, paramBoolean2);
    }
    bool2 = bool1;
    if (aO()) {
      bool2 = bool1 | this.fP.setVisible(paramBoolean1, paramBoolean2);
    }
    bool1 = bool2;
    if (aP()) {
      bool1 = bool2 | this.fJ.setVisible(paramBoolean1, paramBoolean2);
    }
    if (bool1) {
      invalidateSelf();
    }
    return bool1;
  }
  
  public final void unscheduleDrawable(Drawable paramDrawable, Runnable paramRunnable)
  {
    paramDrawable = getCallback();
    if (paramDrawable != null) {
      paramDrawable.unscheduleDrawable(this, paramRunnable);
    }
  }
  
  public static abstract interface a
  {
    public abstract void aH();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     android.support.design.chip.a
 * JD-Core Version:    0.7.0.1
 */