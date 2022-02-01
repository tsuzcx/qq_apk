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
  private static final int[] iq = { 16842910 };
  private int alpha = 255;
  final Context context;
  ColorStateList hL;
  private final RectF hO = new RectF();
  boolean iA;
  private Drawable iB;
  ColorStateList iC;
  float iD;
  boolean iE;
  Drawable iF;
  ColorStateList iG;
  float iH;
  CharSequence iI;
  boolean iJ;
  boolean iK;
  Drawable iL;
  h iM;
  h iN;
  float iO;
  float iP;
  float iQ;
  float iR;
  float iS;
  float iT;
  float iU;
  float iV;
  private final TextPaint iW = new TextPaint(1);
  private final Paint iX = new Paint(1);
  private final Paint iY;
  private final Paint.FontMetrics iZ = new Paint.FontMetrics();
  private final f.a im = new f.a()
  {
    public final void D(int paramAnonymousInt) {}
    
    public final void a(Typeface paramAnonymousTypeface)
    {
      a.a(a.this);
      a.this.bl();
      a.this.invalidateSelf();
    }
  };
  ColorStateList ir;
  float is;
  float it;
  ColorStateList iu;
  float iw;
  CharSequence ix;
  private CharSequence iy;
  android.support.design.d.b iz;
  private final PointF ja = new PointF();
  private int jb;
  private int jc;
  private int jd;
  private int je;
  private boolean jf;
  private int jg;
  private ColorFilter jh;
  private PorterDuffColorFilter ji;
  private ColorStateList jj;
  private PorterDuff.Mode jk = PorterDuff.Mode.SRC_IN;
  private int[] jl;
  private boolean jm;
  private ColorStateList jn;
  private WeakReference<a> jo = new WeakReference(null);
  private boolean jp = true;
  private float jq;
  TextUtils.TruncateAt jr;
  boolean js;
  int maxWidth;
  
  private a(Context paramContext)
  {
    this.context = paramContext;
    this.ix = "";
    this.iW.density = paramContext.getResources().getDisplayMetrics().density;
    this.iY = null;
    if (this.iY != null) {
      this.iY.setStyle(Paint.Style.STROKE);
    }
    setState(iq);
    b(iq);
    this.js = true;
  }
  
  public static a a(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    a locala = new a(paramContext);
    TypedArray localTypedArray = f.a(locala.context, paramAttributeSet, android.support.design.a.a.Chip, paramInt, 2131821707, new int[0]);
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
      locala.iM = h.a(locala.context, localTypedArray, 31);
      locala.iN = h.a(locala.context, localTypedArray, 27);
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
      locala.jr = TextUtils.TruncateAt.START;
      continue;
      locala.jr = TextUtils.TruncateAt.MIDDLE;
      continue;
      locala.jr = TextUtils.TruncateAt.END;
    }
  }
  
  private void a(Rect paramRect, RectF paramRectF)
  {
    paramRectF.setEmpty();
    float f;
    if ((bm()) || (bn()))
    {
      f = this.iO + this.iP;
      if (android.support.v4.graphics.drawable.a.k(this) != 0) {
        break label88;
      }
      paramRectF.left = (f + paramRect.left);
      paramRectF.right = (paramRectF.left + this.iD);
    }
    for (;;)
    {
      paramRectF.top = (paramRect.exactCenterY() - this.iD / 2.0F);
      paramRectF.bottom = (paramRectF.top + this.iD);
      return;
      label88:
      paramRectF.right = (paramRect.right - f);
      paramRectF.left = (paramRectF.right - this.iD);
    }
  }
  
  private static boolean a(ColorStateList paramColorStateList)
  {
    return (paramColorStateList != null) && (paramColorStateList.isStateful());
  }
  
  private float b(CharSequence paramCharSequence)
  {
    if (paramCharSequence == null) {
      return 0.0F;
    }
    return this.iW.measureText(paramCharSequence, 0, paramCharSequence.length());
  }
  
  private void b(Rect paramRect, RectF paramRectF)
  {
    paramRectF.setEmpty();
    float f;
    if (bo())
    {
      f = this.iV + this.iU;
      if (android.support.v4.graphics.drawable.a.k(this) != 0) {
        break label81;
      }
      paramRectF.right = (paramRect.right - f);
      paramRectF.left = (paramRectF.right - this.iH);
    }
    for (;;)
    {
      paramRectF.top = (paramRect.exactCenterY() - this.iH / 2.0F);
      paramRectF.bottom = (paramRectF.top + this.iH);
      return;
      label81:
      paramRectF.left = (f + paramRect.left);
      paramRectF.right = (paramRectF.left + this.iH);
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
    if (this.ir != null)
    {
      i = this.ir.getColorForState(paramArrayOfInt1, this.jb);
      if (this.jb == i) {
        break label473;
      }
      this.jb = i;
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
      if (this.iu != null)
      {
        i = this.iu.getColorForState(paramArrayOfInt1, this.jc);
        if (this.jc != i)
        {
          this.jc = i;
          bool1 = true;
        }
        if (this.jn == null) {
          break label433;
        }
        i = this.jn.getColorForState(paramArrayOfInt1, this.jd);
        bool2 = bool1;
        if (this.jd != i)
        {
          this.jd = i;
          bool2 = bool1;
          if (this.jm) {
            bool2 = true;
          }
        }
        if ((this.iz == null) || (this.iz.ld == null)) {
          break label439;
        }
        i = this.iz.ld.getColorForState(paramArrayOfInt1, this.je);
        bool1 = bool2;
        if (this.je != i)
        {
          this.je = i;
          bool1 = true;
        }
        if ((!c(getState())) || (!this.iJ)) {
          break label445;
        }
        bool2 = true;
        label221:
        if ((this.jf == bool2) || (this.iL == null)) {
          break label467;
        }
        float f = bp();
        this.jf = bool2;
        if (f == bp()) {
          break label458;
        }
        i = 1;
        bool1 = true;
      }
      for (;;)
      {
        if (this.jj != null) {
          j = this.jj.getColorForState(paramArrayOfInt1, this.jg);
        }
        if (this.jg != j)
        {
          this.jg = j;
          this.ji = android.support.design.b.a.a(this, this.jj, this.jk);
        }
        for (bool2 = bool3;; bool2 = bool1)
        {
          bool1 = bool2;
          if (b(this.iB)) {
            bool1 = bool2 | this.iB.setState(paramArrayOfInt1);
          }
          bool2 = bool1;
          if (b(this.iL)) {
            bool2 = bool1 | this.iL.setState(paramArrayOfInt1);
          }
          bool1 = bool2;
          if (b(this.iF)) {
            bool1 = bool2 | this.iF.setState(paramArrayOfInt2);
          }
          if (bool1) {
            invalidateSelf();
          }
          if (i != 0) {
            bl();
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
  
  private boolean bm()
  {
    return (this.iA) && (this.iB != null);
  }
  
  private boolean bn()
  {
    return (this.iK) && (this.iL != null) && (this.jf);
  }
  
  private boolean bo()
  {
    return (this.iE) && (this.iF != null);
  }
  
  private float bq()
  {
    if (!this.jp) {
      return this.jq;
    }
    this.jq = b(this.iy);
    this.jp = false;
    return this.jq;
  }
  
  private float br()
  {
    if (bo()) {
      return this.iT + this.iH + this.iU;
    }
    return 0.0F;
  }
  
  private ColorFilter bs()
  {
    if (this.jh != null) {
      return this.jh;
    }
    return this.ji;
  }
  
  private void bt()
  {
    if (this.jm) {}
    for (ColorStateList localColorStateList = android.support.design.e.a.b(this.hL);; localColorStateList = null)
    {
      this.jn = localColorStateList;
      return;
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
      if (paramDrawable != this.iF) {
        break label70;
      }
      if (paramDrawable.isStateful()) {
        paramDrawable.setState(this.jl);
      }
      android.support.v4.graphics.drawable.a.a(paramDrawable, this.iG);
    }
    label70:
    while (!paramDrawable.isStateful()) {
      return;
    }
    paramDrawable.setState(getState());
  }
  
  public final void a(a parama)
  {
    this.jo = new WeakReference(parama);
  }
  
  public final boolean b(int[] paramArrayOfInt)
  {
    if (!Arrays.equals(this.jl, paramArrayOfInt))
    {
      this.jl = paramArrayOfInt;
      if (bo()) {
        return b(getState(), paramArrayOfInt);
      }
    }
    return false;
  }
  
  protected final void bl()
  {
    a locala = (a)this.jo.get();
    if (locala != null) {
      locala.bg();
    }
  }
  
  final float bp()
  {
    if ((bm()) || (bn())) {
      return this.iP + this.iD + this.iQ;
    }
    return 0.0F;
  }
  
  final void c(Rect paramRect, RectF paramRectF)
  {
    paramRectF.setEmpty();
    float f;
    if (bo())
    {
      f = this.iV + this.iU + this.iH + this.iT + this.iS;
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
      this.iX.setColor(this.jb);
      this.iX.setStyle(Paint.Style.FILL);
      this.iX.setColorFilter(bs());
      this.hO.set(localRect);
      paramCanvas.drawRoundRect(this.hO, this.it, this.it, this.iX);
      if (this.iw > 0.0F)
      {
        this.iX.setColor(this.jc);
        this.iX.setStyle(Paint.Style.STROKE);
        this.iX.setColorFilter(bs());
        this.hO.set(localRect.left + this.iw / 2.0F, localRect.top + this.iw / 2.0F, localRect.right - this.iw / 2.0F, localRect.bottom - this.iw / 2.0F);
        f1 = this.it - this.iw / 2.0F;
        paramCanvas.drawRoundRect(this.hO, f1, f1, this.iX);
      }
      this.iX.setColor(this.jd);
      this.iX.setStyle(Paint.Style.FILL);
      this.hO.set(localRect);
      paramCanvas.drawRoundRect(this.hO, this.it, this.it, this.iX);
      if (bm())
      {
        a(localRect, this.hO);
        f1 = this.hO.left;
        f2 = this.hO.top;
        paramCanvas.translate(f1, f2);
        this.iB.setBounds(0, 0, (int)this.hO.width(), (int)this.hO.height());
        this.iB.draw(paramCanvas);
        paramCanvas.translate(-f1, -f2);
      }
      if (bn())
      {
        a(localRect, this.hO);
        f1 = this.hO.left;
        f2 = this.hO.top;
        paramCanvas.translate(f1, f2);
        this.iL.setBounds(0, 0, (int)this.hO.width(), (int)this.hO.height());
        this.iL.draw(paramCanvas);
        paramCanvas.translate(-f1, -f2);
      }
      Object localObject2;
      Object localObject1;
      label568:
      int j;
      label692:
      int k;
      if ((this.js) && (this.iy != null))
      {
        localObject2 = this.ja;
        ((PointF)localObject2).set(0.0F, 0.0F);
        localObject1 = Paint.Align.LEFT;
        if (this.iy != null)
        {
          f1 = this.iO + bp() + this.iR;
          if (android.support.v4.graphics.drawable.a.k(this) != 0) {
            break label1275;
          }
          ((PointF)localObject2).x = (f1 + localRect.left);
          localObject1 = Paint.Align.LEFT;
          f1 = localRect.centerY();
          this.iW.getFontMetrics(this.iZ);
          ((PointF)localObject2).y = (f1 - (this.iZ.descent + this.iZ.ascent) / 2.0F);
        }
        localObject2 = this.hO;
        ((RectF)localObject2).setEmpty();
        if (this.iy != null)
        {
          f1 = this.iO + bp() + this.iR;
          f2 = this.iV + br() + this.iS;
          if (android.support.v4.graphics.drawable.a.k(this) != 0) {
            break label1296;
          }
          ((RectF)localObject2).left = (f1 + localRect.left);
          ((RectF)localObject2).right = (localRect.right - f2);
          ((RectF)localObject2).top = localRect.top;
          ((RectF)localObject2).bottom = localRect.bottom;
        }
        if (this.iz != null)
        {
          this.iW.drawableState = getState();
          this.iz.b(this.context, this.iW, this.im);
        }
        this.iW.setTextAlign((Paint.Align)localObject1);
        if (Math.round(bq()) <= Math.round(this.hO.width())) {
          break label1325;
        }
        j = 1;
        label783:
        if (j == 0) {
          break label1347;
        }
        k = paramCanvas.save();
        paramCanvas.clipRect(this.hO);
      }
      for (;;)
      {
        localObject2 = this.iy;
        localObject1 = localObject2;
        if (j != 0)
        {
          localObject1 = localObject2;
          if (this.jr != null) {
            localObject1 = TextUtils.ellipsize(this.iy, this.iW, this.hO.width(), this.jr);
          }
        }
        paramCanvas.drawText((CharSequence)localObject1, 0, ((CharSequence)localObject1).length(), this.ja.x, this.ja.y, this.iW);
        if (j != 0) {
          paramCanvas.restoreToCount(k);
        }
        if (bo())
        {
          b(localRect, this.hO);
          f1 = this.hO.left;
          f2 = this.hO.top;
          paramCanvas.translate(f1, f2);
          this.iF.setBounds(0, 0, (int)this.hO.width(), (int)this.hO.height());
          this.iF.draw(paramCanvas);
          paramCanvas.translate(-f1, -f2);
        }
        if (this.iY != null)
        {
          this.iY.setColor(android.support.v4.graphics.b.x(-16777216, 127));
          paramCanvas.drawRect(localRect, this.iY);
          if ((bm()) || (bn()))
          {
            a(localRect, this.hO);
            paramCanvas.drawRect(this.hO, this.iY);
          }
          if (this.iy != null) {
            paramCanvas.drawLine(localRect.left, localRect.exactCenterY(), localRect.right, localRect.exactCenterY(), this.iY);
          }
          if (bo())
          {
            b(localRect, this.hO);
            paramCanvas.drawRect(this.hO, this.iY);
          }
          this.iY.setColor(android.support.v4.graphics.b.x(-65536, 127));
          localObject1 = this.hO;
          ((RectF)localObject1).set(localRect);
          if (bo())
          {
            f1 = this.iV + this.iU + this.iH + this.iT + this.iS;
            if (android.support.v4.graphics.drawable.a.k(this) != 0) {
              break label1331;
            }
            ((RectF)localObject1).right = (localRect.right - f1);
          }
        }
        for (;;)
        {
          paramCanvas.drawRect(this.hO, this.iY);
          this.iY.setColor(android.support.v4.graphics.b.x(-16711936, 127));
          c(localRect, this.hO);
          paramCanvas.drawRect(this.hO, this.iY);
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
    if (this.iB != null) {
      return android.support.v4.graphics.drawable.a.j(this.iB);
    }
    return null;
  }
  
  public final Drawable getCloseIcon()
  {
    if (this.iF != null) {
      return android.support.v4.graphics.drawable.a.j(this.iF);
    }
    return null;
  }
  
  public final ColorFilter getColorFilter()
  {
    return this.jh;
  }
  
  public final int getIntrinsicHeight()
  {
    return (int)this.is;
  }
  
  public final int getIntrinsicWidth()
  {
    return Math.min(Math.round(this.iO + bp() + this.iR + bq() + this.iS + br() + this.iV), this.maxWidth);
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
      paramOutline.setRoundRect(localRect, this.it);
    }
    for (;;)
    {
      paramOutline.setAlpha(getAlpha() / 255.0F);
      return;
      paramOutline.setRoundRect(0, 0, getIntrinsicWidth(), getIntrinsicHeight(), this.it);
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
    if ((!a(this.ir)) && (!a(this.iu)) && ((!this.jm) || (!a(this.jn))))
    {
      android.support.design.d.b localb = this.iz;
      if ((localb == null) || (localb.ld == null) || (!localb.ld.isStateful())) {
        break label132;
      }
      i = 1;
      if (i == 0) {
        if ((!this.iK) || (this.iL == null) || (!this.iJ)) {
          break label137;
        }
      }
    }
    label132:
    label137:
    for (int i = 1;; i = 0)
    {
      if ((i != 0) || (b(this.iB)) || (b(this.iL)) || (a(this.jj))) {
        bool = true;
      }
      return bool;
      i = 0;
      break;
    }
  }
  
  public final void o(boolean paramBoolean)
  {
    if (this.jm != paramBoolean)
    {
      this.jm = paramBoolean;
      bt();
      onStateChange(getState());
    }
  }
  
  @TargetApi(23)
  public final boolean onLayoutDirectionChanged(int paramInt)
  {
    boolean bool2 = super.onLayoutDirectionChanged(paramInt);
    boolean bool1 = bool2;
    if (bm()) {
      bool1 = bool2 | this.iB.setLayoutDirection(paramInt);
    }
    bool2 = bool1;
    if (bn()) {
      bool2 = bool1 | this.iL.setLayoutDirection(paramInt);
    }
    bool1 = bool2;
    if (bo()) {
      bool1 = bool2 | this.iF.setLayoutDirection(paramInt);
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
    if (bm()) {
      bool1 = bool2 | this.iB.setLevel(paramInt);
    }
    bool2 = bool1;
    if (bn()) {
      bool2 = bool1 | this.iL.setLevel(paramInt);
    }
    bool1 = bool2;
    if (bo()) {
      bool1 = bool2 | this.iF.setLevel(paramInt);
    }
    if (bool1) {
      invalidateSelf();
    }
    return bool1;
  }
  
  protected final boolean onStateChange(int[] paramArrayOfInt)
  {
    return b(paramArrayOfInt, this.jl);
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
    if (this.iJ != paramBoolean)
    {
      this.iJ = paramBoolean;
      float f1 = bp();
      if ((!paramBoolean) && (this.jf)) {
        this.jf = false;
      }
      float f2 = bp();
      invalidateSelf();
      if (f1 != f2) {
        bl();
      }
    }
  }
  
  public final void setCheckedIcon(Drawable paramDrawable)
  {
    if (this.iL != paramDrawable)
    {
      float f1 = bp();
      this.iL = paramDrawable;
      float f2 = bp();
      c(this.iL);
      d(this.iL);
      invalidateSelf();
      if (f1 != f2) {
        bl();
      }
    }
  }
  
  public final void setCheckedIconVisible(boolean paramBoolean)
  {
    int i;
    if (this.iK != paramBoolean)
    {
      boolean bool = bn();
      this.iK = paramBoolean;
      paramBoolean = bn();
      if (bool == paramBoolean) {
        break label55;
      }
      i = 1;
      if (i != 0)
      {
        if (!paramBoolean) {
          break label60;
        }
        d(this.iL);
      }
    }
    for (;;)
    {
      invalidateSelf();
      bl();
      return;
      label55:
      i = 0;
      break;
      label60:
      c(this.iL);
    }
  }
  
  public final void setChipBackgroundColor(ColorStateList paramColorStateList)
  {
    if (this.ir != paramColorStateList)
    {
      this.ir = paramColorStateList;
      onStateChange(getState());
    }
  }
  
  public final void setChipCornerRadius(float paramFloat)
  {
    if (this.it != paramFloat)
    {
      this.it = paramFloat;
      invalidateSelf();
    }
  }
  
  public final void setChipEndPadding(float paramFloat)
  {
    if (this.iV != paramFloat)
    {
      this.iV = paramFloat;
      invalidateSelf();
      bl();
    }
  }
  
  public final void setChipIcon(Drawable paramDrawable)
  {
    Drawable localDrawable = getChipIcon();
    float f1;
    if (localDrawable != paramDrawable)
    {
      f1 = bp();
      if (paramDrawable == null) {
        break label74;
      }
    }
    label74:
    for (paramDrawable = android.support.v4.graphics.drawable.a.i(paramDrawable).mutate();; paramDrawable = null)
    {
      this.iB = paramDrawable;
      float f2 = bp();
      c(localDrawable);
      if (bm()) {
        d(this.iB);
      }
      invalidateSelf();
      if (f1 != f2) {
        bl();
      }
      return;
    }
  }
  
  public final void setChipIconSize(float paramFloat)
  {
    if (this.iD != paramFloat)
    {
      float f = bp();
      this.iD = paramFloat;
      paramFloat = bp();
      invalidateSelf();
      if (f != paramFloat) {
        bl();
      }
    }
  }
  
  public final void setChipIconTint(ColorStateList paramColorStateList)
  {
    if (this.iC != paramColorStateList)
    {
      this.iC = paramColorStateList;
      if (bm()) {
        android.support.v4.graphics.drawable.a.a(this.iB, paramColorStateList);
      }
      onStateChange(getState());
    }
  }
  
  public final void setChipIconVisible(boolean paramBoolean)
  {
    int i;
    if (this.iA != paramBoolean)
    {
      boolean bool = bm();
      this.iA = paramBoolean;
      paramBoolean = bm();
      if (bool == paramBoolean) {
        break label55;
      }
      i = 1;
      if (i != 0)
      {
        if (!paramBoolean) {
          break label60;
        }
        d(this.iB);
      }
    }
    for (;;)
    {
      invalidateSelf();
      bl();
      return;
      label55:
      i = 0;
      break;
      label60:
      c(this.iB);
    }
  }
  
  public final void setChipMinHeight(float paramFloat)
  {
    if (this.is != paramFloat)
    {
      this.is = paramFloat;
      invalidateSelf();
      bl();
    }
  }
  
  public final void setChipStartPadding(float paramFloat)
  {
    if (this.iO != paramFloat)
    {
      this.iO = paramFloat;
      invalidateSelf();
      bl();
    }
  }
  
  public final void setChipStrokeColor(ColorStateList paramColorStateList)
  {
    if (this.iu != paramColorStateList)
    {
      this.iu = paramColorStateList;
      onStateChange(getState());
    }
  }
  
  public final void setChipStrokeWidth(float paramFloat)
  {
    if (this.iw != paramFloat)
    {
      this.iw = paramFloat;
      this.iX.setStrokeWidth(paramFloat);
      invalidateSelf();
    }
  }
  
  public final void setCloseIcon(Drawable paramDrawable)
  {
    Drawable localDrawable = getCloseIcon();
    float f1;
    if (localDrawable != paramDrawable)
    {
      f1 = br();
      if (paramDrawable == null) {
        break label74;
      }
    }
    label74:
    for (paramDrawable = android.support.v4.graphics.drawable.a.i(paramDrawable).mutate();; paramDrawable = null)
    {
      this.iF = paramDrawable;
      float f2 = br();
      c(localDrawable);
      if (bo()) {
        d(this.iF);
      }
      invalidateSelf();
      if (f1 != f2) {
        bl();
      }
      return;
    }
  }
  
  public final void setCloseIconEndPadding(float paramFloat)
  {
    if (this.iU != paramFloat)
    {
      this.iU = paramFloat;
      invalidateSelf();
      if (bo()) {
        bl();
      }
    }
  }
  
  public final void setCloseIconSize(float paramFloat)
  {
    if (this.iH != paramFloat)
    {
      this.iH = paramFloat;
      invalidateSelf();
      if (bo()) {
        bl();
      }
    }
  }
  
  public final void setCloseIconStartPadding(float paramFloat)
  {
    if (this.iT != paramFloat)
    {
      this.iT = paramFloat;
      invalidateSelf();
      if (bo()) {
        bl();
      }
    }
  }
  
  public final void setCloseIconTint(ColorStateList paramColorStateList)
  {
    if (this.iG != paramColorStateList)
    {
      this.iG = paramColorStateList;
      if (bo()) {
        android.support.v4.graphics.drawable.a.a(this.iF, paramColorStateList);
      }
      onStateChange(getState());
    }
  }
  
  public final void setCloseIconVisible(boolean paramBoolean)
  {
    int i;
    if (this.iE != paramBoolean)
    {
      boolean bool = bo();
      this.iE = paramBoolean;
      paramBoolean = bo();
      if (bool == paramBoolean) {
        break label55;
      }
      i = 1;
      if (i != 0)
      {
        if (!paramBoolean) {
          break label60;
        }
        d(this.iF);
      }
    }
    for (;;)
    {
      invalidateSelf();
      bl();
      return;
      label55:
      i = 0;
      break;
      label60:
      c(this.iF);
    }
  }
  
  public final void setColorFilter(ColorFilter paramColorFilter)
  {
    if (this.jh != paramColorFilter)
    {
      this.jh = paramColorFilter;
      invalidateSelf();
    }
  }
  
  public final void setIconEndPadding(float paramFloat)
  {
    if (this.iQ != paramFloat)
    {
      float f = bp();
      this.iQ = paramFloat;
      paramFloat = bp();
      invalidateSelf();
      if (f != paramFloat) {
        bl();
      }
    }
  }
  
  public final void setIconStartPadding(float paramFloat)
  {
    if (this.iP != paramFloat)
    {
      float f = bp();
      this.iP = paramFloat;
      paramFloat = bp();
      invalidateSelf();
      if (f != paramFloat) {
        bl();
      }
    }
  }
  
  public final void setRippleColor(ColorStateList paramColorStateList)
  {
    if (this.hL != paramColorStateList)
    {
      this.hL = paramColorStateList;
      bt();
      onStateChange(getState());
    }
  }
  
  public final void setText(CharSequence paramCharSequence)
  {
    Object localObject = paramCharSequence;
    if (paramCharSequence == null) {
      localObject = "";
    }
    if (this.ix != localObject)
    {
      this.ix = ((CharSequence)localObject);
      this.iy = android.support.v4.d.a.fg().unicodeWrap((CharSequence)localObject);
      this.jp = true;
      invalidateSelf();
      bl();
    }
  }
  
  public final void setTextAppearance(android.support.design.d.b paramb)
  {
    if (this.iz != paramb)
    {
      this.iz = paramb;
      if (paramb != null)
      {
        paramb.c(this.context, this.iW, this.im);
        this.jp = true;
      }
      onStateChange(getState());
      bl();
    }
  }
  
  public final void setTextAppearanceResource(int paramInt)
  {
    setTextAppearance(new android.support.design.d.b(this.context, paramInt));
  }
  
  public final void setTextEndPadding(float paramFloat)
  {
    if (this.iS != paramFloat)
    {
      this.iS = paramFloat;
      invalidateSelf();
      bl();
    }
  }
  
  public final void setTextStartPadding(float paramFloat)
  {
    if (this.iR != paramFloat)
    {
      this.iR = paramFloat;
      invalidateSelf();
      bl();
    }
  }
  
  public final void setTintList(ColorStateList paramColorStateList)
  {
    if (this.jj != paramColorStateList)
    {
      this.jj = paramColorStateList;
      onStateChange(getState());
    }
  }
  
  public final void setTintMode(PorterDuff.Mode paramMode)
  {
    if (this.jk != paramMode)
    {
      this.jk = paramMode;
      this.ji = android.support.design.b.a.a(this, this.jj, paramMode);
      invalidateSelf();
    }
  }
  
  public final boolean setVisible(boolean paramBoolean1, boolean paramBoolean2)
  {
    boolean bool2 = super.setVisible(paramBoolean1, paramBoolean2);
    boolean bool1 = bool2;
    if (bm()) {
      bool1 = bool2 | this.iB.setVisible(paramBoolean1, paramBoolean2);
    }
    bool2 = bool1;
    if (bn()) {
      bool2 = bool1 | this.iL.setVisible(paramBoolean1, paramBoolean2);
    }
    bool1 = bool2;
    if (bo()) {
      bool1 = bool2 | this.iF.setVisible(paramBoolean1, paramBoolean2);
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
    public abstract void bg();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     android.support.design.chip.a
 * JD-Core Version:    0.7.0.1
 */