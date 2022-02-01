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
  private static final int[] im = { 16842910 };
  private int alpha = 255;
  final Context context;
  ColorStateList hJ;
  private final RectF hM = new RectF();
  ColorStateList iA;
  float iB;
  boolean iC;
  Drawable iD;
  ColorStateList iE;
  float iF;
  CharSequence iG;
  boolean iH;
  boolean iI;
  Drawable iJ;
  h iK;
  h iL;
  float iM;
  float iN;
  float iO;
  float iP;
  float iQ;
  float iR;
  float iS;
  float iT;
  private final TextPaint iU = new TextPaint(1);
  private final Paint iV = new Paint(1);
  private final Paint iW;
  private final Paint.FontMetrics iX = new Paint.FontMetrics();
  private final PointF iY = new PointF();
  private int iZ;
  private final f.a ik = new f.a()
  {
    public final void D(int paramAnonymousInt) {}
    
    public final void a(Typeface paramAnonymousTypeface)
    {
      a.a(a.this);
      a.this.bj();
      a.this.invalidateSelf();
    }
  };
  ColorStateList io;
  float iq;
  float ir;
  ColorStateList is;
  float it;
  CharSequence iu;
  private CharSequence iw;
  android.support.design.d.b ix;
  boolean iy;
  private Drawable iz;
  private int ja;
  private int jb;
  private int jc;
  private boolean jd;
  private int je;
  private ColorFilter jf;
  private PorterDuffColorFilter jg;
  private ColorStateList jh;
  private PorterDuff.Mode ji = PorterDuff.Mode.SRC_IN;
  private int[] jj;
  private boolean jk;
  private ColorStateList jl;
  private WeakReference<a> jm = new WeakReference(null);
  private boolean jn = true;
  private float jo;
  TextUtils.TruncateAt jp;
  boolean jq;
  int maxWidth;
  
  private a(Context paramContext)
  {
    this.context = paramContext;
    this.iu = "";
    this.iU.density = paramContext.getResources().getDisplayMetrics().density;
    this.iW = null;
    if (this.iW != null) {
      this.iW.setStyle(Paint.Style.STROKE);
    }
    setState(im);
    b(im);
    this.jq = true;
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
      locala.iK = h.a(locala.context, localTypedArray, 31);
      locala.iL = h.a(locala.context, localTypedArray, 27);
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
      locala.jp = TextUtils.TruncateAt.START;
      continue;
      locala.jp = TextUtils.TruncateAt.MIDDLE;
      continue;
      locala.jp = TextUtils.TruncateAt.END;
    }
  }
  
  private void a(Rect paramRect, RectF paramRectF)
  {
    paramRectF.setEmpty();
    float f;
    if ((bk()) || (bl()))
    {
      f = this.iM + this.iN;
      if (android.support.v4.graphics.drawable.a.k(this) != 0) {
        break label88;
      }
      paramRectF.left = (f + paramRect.left);
      paramRectF.right = (paramRectF.left + this.iB);
    }
    for (;;)
    {
      paramRectF.top = (paramRect.exactCenterY() - this.iB / 2.0F);
      paramRectF.bottom = (paramRectF.top + this.iB);
      return;
      label88:
      paramRectF.right = (paramRect.right - f);
      paramRectF.left = (paramRectF.right - this.iB);
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
    return this.iU.measureText(paramCharSequence, 0, paramCharSequence.length());
  }
  
  private void b(Rect paramRect, RectF paramRectF)
  {
    paramRectF.setEmpty();
    float f;
    if (bm())
    {
      f = this.iT + this.iS;
      if (android.support.v4.graphics.drawable.a.k(this) != 0) {
        break label81;
      }
      paramRectF.right = (paramRect.right - f);
      paramRectF.left = (paramRectF.right - this.iF);
    }
    for (;;)
    {
      paramRectF.top = (paramRect.exactCenterY() - this.iF / 2.0F);
      paramRectF.bottom = (paramRectF.top + this.iF);
      return;
      label81:
      paramRectF.left = (f + paramRect.left);
      paramRectF.right = (paramRectF.left + this.iF);
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
    if (this.io != null)
    {
      i = this.io.getColorForState(paramArrayOfInt1, this.iZ);
      if (this.iZ == i) {
        break label473;
      }
      this.iZ = i;
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
      if (this.is != null)
      {
        i = this.is.getColorForState(paramArrayOfInt1, this.ja);
        if (this.ja != i)
        {
          this.ja = i;
          bool1 = true;
        }
        if (this.jl == null) {
          break label433;
        }
        i = this.jl.getColorForState(paramArrayOfInt1, this.jb);
        bool2 = bool1;
        if (this.jb != i)
        {
          this.jb = i;
          bool2 = bool1;
          if (this.jk) {
            bool2 = true;
          }
        }
        if ((this.ix == null) || (this.ix.lb == null)) {
          break label439;
        }
        i = this.ix.lb.getColorForState(paramArrayOfInt1, this.jc);
        bool1 = bool2;
        if (this.jc != i)
        {
          this.jc = i;
          bool1 = true;
        }
        if ((!c(getState())) || (!this.iH)) {
          break label445;
        }
        bool2 = true;
        label221:
        if ((this.jd == bool2) || (this.iJ == null)) {
          break label467;
        }
        float f = bn();
        this.jd = bool2;
        if (f == bn()) {
          break label458;
        }
        i = 1;
        bool1 = true;
      }
      for (;;)
      {
        if (this.jh != null) {
          j = this.jh.getColorForState(paramArrayOfInt1, this.je);
        }
        if (this.je != j)
        {
          this.je = j;
          this.jg = android.support.design.b.a.a(this, this.jh, this.ji);
        }
        for (bool2 = bool3;; bool2 = bool1)
        {
          bool1 = bool2;
          if (b(this.iz)) {
            bool1 = bool2 | this.iz.setState(paramArrayOfInt1);
          }
          bool2 = bool1;
          if (b(this.iJ)) {
            bool2 = bool1 | this.iJ.setState(paramArrayOfInt1);
          }
          bool1 = bool2;
          if (b(this.iD)) {
            bool1 = bool2 | this.iD.setState(paramArrayOfInt2);
          }
          if (bool1) {
            invalidateSelf();
          }
          if (i != 0) {
            bj();
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
  
  private boolean bk()
  {
    return (this.iy) && (this.iz != null);
  }
  
  private boolean bl()
  {
    return (this.iI) && (this.iJ != null) && (this.jd);
  }
  
  private boolean bm()
  {
    return (this.iC) && (this.iD != null);
  }
  
  private float bo()
  {
    if (!this.jn) {
      return this.jo;
    }
    this.jo = b(this.iw);
    this.jn = false;
    return this.jo;
  }
  
  private float bp()
  {
    if (bm()) {
      return this.iR + this.iF + this.iS;
    }
    return 0.0F;
  }
  
  private ColorFilter bq()
  {
    if (this.jf != null) {
      return this.jf;
    }
    return this.jg;
  }
  
  private void br()
  {
    if (this.jk) {}
    for (ColorStateList localColorStateList = android.support.design.e.a.b(this.hJ);; localColorStateList = null)
    {
      this.jl = localColorStateList;
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
      if (paramDrawable != this.iD) {
        break label70;
      }
      if (paramDrawable.isStateful()) {
        paramDrawable.setState(this.jj);
      }
      android.support.v4.graphics.drawable.a.a(paramDrawable, this.iE);
    }
    label70:
    while (!paramDrawable.isStateful()) {
      return;
    }
    paramDrawable.setState(getState());
  }
  
  public final void a(a parama)
  {
    this.jm = new WeakReference(parama);
  }
  
  public final boolean b(int[] paramArrayOfInt)
  {
    if (!Arrays.equals(this.jj, paramArrayOfInt))
    {
      this.jj = paramArrayOfInt;
      if (bm()) {
        return b(getState(), paramArrayOfInt);
      }
    }
    return false;
  }
  
  protected final void bj()
  {
    a locala = (a)this.jm.get();
    if (locala != null) {
      locala.be();
    }
  }
  
  final float bn()
  {
    if ((bk()) || (bl())) {
      return this.iN + this.iB + this.iO;
    }
    return 0.0F;
  }
  
  final void c(Rect paramRect, RectF paramRectF)
  {
    paramRectF.setEmpty();
    float f;
    if (bm())
    {
      f = this.iT + this.iS + this.iF + this.iR + this.iQ;
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
      this.iV.setColor(this.iZ);
      this.iV.setStyle(Paint.Style.FILL);
      this.iV.setColorFilter(bq());
      this.hM.set(localRect);
      paramCanvas.drawRoundRect(this.hM, this.ir, this.ir, this.iV);
      if (this.it > 0.0F)
      {
        this.iV.setColor(this.ja);
        this.iV.setStyle(Paint.Style.STROKE);
        this.iV.setColorFilter(bq());
        this.hM.set(localRect.left + this.it / 2.0F, localRect.top + this.it / 2.0F, localRect.right - this.it / 2.0F, localRect.bottom - this.it / 2.0F);
        f1 = this.ir - this.it / 2.0F;
        paramCanvas.drawRoundRect(this.hM, f1, f1, this.iV);
      }
      this.iV.setColor(this.jb);
      this.iV.setStyle(Paint.Style.FILL);
      this.hM.set(localRect);
      paramCanvas.drawRoundRect(this.hM, this.ir, this.ir, this.iV);
      if (bk())
      {
        a(localRect, this.hM);
        f1 = this.hM.left;
        f2 = this.hM.top;
        paramCanvas.translate(f1, f2);
        this.iz.setBounds(0, 0, (int)this.hM.width(), (int)this.hM.height());
        this.iz.draw(paramCanvas);
        paramCanvas.translate(-f1, -f2);
      }
      if (bl())
      {
        a(localRect, this.hM);
        f1 = this.hM.left;
        f2 = this.hM.top;
        paramCanvas.translate(f1, f2);
        this.iJ.setBounds(0, 0, (int)this.hM.width(), (int)this.hM.height());
        this.iJ.draw(paramCanvas);
        paramCanvas.translate(-f1, -f2);
      }
      Object localObject2;
      Object localObject1;
      label568:
      int j;
      label692:
      int k;
      if ((this.jq) && (this.iw != null))
      {
        localObject2 = this.iY;
        ((PointF)localObject2).set(0.0F, 0.0F);
        localObject1 = Paint.Align.LEFT;
        if (this.iw != null)
        {
          f1 = this.iM + bn() + this.iP;
          if (android.support.v4.graphics.drawable.a.k(this) != 0) {
            break label1275;
          }
          ((PointF)localObject2).x = (f1 + localRect.left);
          localObject1 = Paint.Align.LEFT;
          f1 = localRect.centerY();
          this.iU.getFontMetrics(this.iX);
          ((PointF)localObject2).y = (f1 - (this.iX.descent + this.iX.ascent) / 2.0F);
        }
        localObject2 = this.hM;
        ((RectF)localObject2).setEmpty();
        if (this.iw != null)
        {
          f1 = this.iM + bn() + this.iP;
          f2 = this.iT + bp() + this.iQ;
          if (android.support.v4.graphics.drawable.a.k(this) != 0) {
            break label1296;
          }
          ((RectF)localObject2).left = (f1 + localRect.left);
          ((RectF)localObject2).right = (localRect.right - f2);
          ((RectF)localObject2).top = localRect.top;
          ((RectF)localObject2).bottom = localRect.bottom;
        }
        if (this.ix != null)
        {
          this.iU.drawableState = getState();
          this.ix.b(this.context, this.iU, this.ik);
        }
        this.iU.setTextAlign((Paint.Align)localObject1);
        if (Math.round(bo()) <= Math.round(this.hM.width())) {
          break label1325;
        }
        j = 1;
        label783:
        if (j == 0) {
          break label1347;
        }
        k = paramCanvas.save();
        paramCanvas.clipRect(this.hM);
      }
      for (;;)
      {
        localObject2 = this.iw;
        localObject1 = localObject2;
        if (j != 0)
        {
          localObject1 = localObject2;
          if (this.jp != null) {
            localObject1 = TextUtils.ellipsize(this.iw, this.iU, this.hM.width(), this.jp);
          }
        }
        paramCanvas.drawText((CharSequence)localObject1, 0, ((CharSequence)localObject1).length(), this.iY.x, this.iY.y, this.iU);
        if (j != 0) {
          paramCanvas.restoreToCount(k);
        }
        if (bm())
        {
          b(localRect, this.hM);
          f1 = this.hM.left;
          f2 = this.hM.top;
          paramCanvas.translate(f1, f2);
          this.iD.setBounds(0, 0, (int)this.hM.width(), (int)this.hM.height());
          this.iD.draw(paramCanvas);
          paramCanvas.translate(-f1, -f2);
        }
        if (this.iW != null)
        {
          this.iW.setColor(android.support.v4.graphics.b.x(-16777216, 127));
          paramCanvas.drawRect(localRect, this.iW);
          if ((bk()) || (bl()))
          {
            a(localRect, this.hM);
            paramCanvas.drawRect(this.hM, this.iW);
          }
          if (this.iw != null) {
            paramCanvas.drawLine(localRect.left, localRect.exactCenterY(), localRect.right, localRect.exactCenterY(), this.iW);
          }
          if (bm())
          {
            b(localRect, this.hM);
            paramCanvas.drawRect(this.hM, this.iW);
          }
          this.iW.setColor(android.support.v4.graphics.b.x(-65536, 127));
          localObject1 = this.hM;
          ((RectF)localObject1).set(localRect);
          if (bm())
          {
            f1 = this.iT + this.iS + this.iF + this.iR + this.iQ;
            if (android.support.v4.graphics.drawable.a.k(this) != 0) {
              break label1331;
            }
            ((RectF)localObject1).right = (localRect.right - f1);
          }
        }
        for (;;)
        {
          paramCanvas.drawRect(this.hM, this.iW);
          this.iW.setColor(android.support.v4.graphics.b.x(-16711936, 127));
          c(localRect, this.hM);
          paramCanvas.drawRect(this.hM, this.iW);
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
    if (this.iz != null) {
      return android.support.v4.graphics.drawable.a.j(this.iz);
    }
    return null;
  }
  
  public final Drawable getCloseIcon()
  {
    if (this.iD != null) {
      return android.support.v4.graphics.drawable.a.j(this.iD);
    }
    return null;
  }
  
  public final ColorFilter getColorFilter()
  {
    return this.jf;
  }
  
  public final int getIntrinsicHeight()
  {
    return (int)this.iq;
  }
  
  public final int getIntrinsicWidth()
  {
    return Math.min(Math.round(this.iM + bn() + this.iP + bo() + this.iQ + bp() + this.iT), this.maxWidth);
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
      paramOutline.setRoundRect(localRect, this.ir);
    }
    for (;;)
    {
      paramOutline.setAlpha(getAlpha() / 255.0F);
      return;
      paramOutline.setRoundRect(0, 0, getIntrinsicWidth(), getIntrinsicHeight(), this.ir);
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
    if ((!a(this.io)) && (!a(this.is)) && ((!this.jk) || (!a(this.jl))))
    {
      android.support.design.d.b localb = this.ix;
      if ((localb == null) || (localb.lb == null) || (!localb.lb.isStateful())) {
        break label132;
      }
      i = 1;
      if (i == 0) {
        if ((!this.iI) || (this.iJ == null) || (!this.iH)) {
          break label137;
        }
      }
    }
    label132:
    label137:
    for (int i = 1;; i = 0)
    {
      if ((i != 0) || (b(this.iz)) || (b(this.iJ)) || (a(this.jh))) {
        bool = true;
      }
      return bool;
      i = 0;
      break;
    }
  }
  
  public final void o(boolean paramBoolean)
  {
    if (this.jk != paramBoolean)
    {
      this.jk = paramBoolean;
      br();
      onStateChange(getState());
    }
  }
  
  @TargetApi(23)
  public final boolean onLayoutDirectionChanged(int paramInt)
  {
    boolean bool2 = super.onLayoutDirectionChanged(paramInt);
    boolean bool1 = bool2;
    if (bk()) {
      bool1 = bool2 | this.iz.setLayoutDirection(paramInt);
    }
    bool2 = bool1;
    if (bl()) {
      bool2 = bool1 | this.iJ.setLayoutDirection(paramInt);
    }
    bool1 = bool2;
    if (bm()) {
      bool1 = bool2 | this.iD.setLayoutDirection(paramInt);
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
    if (bk()) {
      bool1 = bool2 | this.iz.setLevel(paramInt);
    }
    bool2 = bool1;
    if (bl()) {
      bool2 = bool1 | this.iJ.setLevel(paramInt);
    }
    bool1 = bool2;
    if (bm()) {
      bool1 = bool2 | this.iD.setLevel(paramInt);
    }
    if (bool1) {
      invalidateSelf();
    }
    return bool1;
  }
  
  protected final boolean onStateChange(int[] paramArrayOfInt)
  {
    return b(paramArrayOfInt, this.jj);
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
    if (this.iH != paramBoolean)
    {
      this.iH = paramBoolean;
      float f1 = bn();
      if ((!paramBoolean) && (this.jd)) {
        this.jd = false;
      }
      float f2 = bn();
      invalidateSelf();
      if (f1 != f2) {
        bj();
      }
    }
  }
  
  public final void setCheckedIcon(Drawable paramDrawable)
  {
    if (this.iJ != paramDrawable)
    {
      float f1 = bn();
      this.iJ = paramDrawable;
      float f2 = bn();
      c(this.iJ);
      d(this.iJ);
      invalidateSelf();
      if (f1 != f2) {
        bj();
      }
    }
  }
  
  public final void setCheckedIconVisible(boolean paramBoolean)
  {
    int i;
    if (this.iI != paramBoolean)
    {
      boolean bool = bl();
      this.iI = paramBoolean;
      paramBoolean = bl();
      if (bool == paramBoolean) {
        break label55;
      }
      i = 1;
      if (i != 0)
      {
        if (!paramBoolean) {
          break label60;
        }
        d(this.iJ);
      }
    }
    for (;;)
    {
      invalidateSelf();
      bj();
      return;
      label55:
      i = 0;
      break;
      label60:
      c(this.iJ);
    }
  }
  
  public final void setChipBackgroundColor(ColorStateList paramColorStateList)
  {
    if (this.io != paramColorStateList)
    {
      this.io = paramColorStateList;
      onStateChange(getState());
    }
  }
  
  public final void setChipCornerRadius(float paramFloat)
  {
    if (this.ir != paramFloat)
    {
      this.ir = paramFloat;
      invalidateSelf();
    }
  }
  
  public final void setChipEndPadding(float paramFloat)
  {
    if (this.iT != paramFloat)
    {
      this.iT = paramFloat;
      invalidateSelf();
      bj();
    }
  }
  
  public final void setChipIcon(Drawable paramDrawable)
  {
    Drawable localDrawable = getChipIcon();
    float f1;
    if (localDrawable != paramDrawable)
    {
      f1 = bn();
      if (paramDrawable == null) {
        break label74;
      }
    }
    label74:
    for (paramDrawable = android.support.v4.graphics.drawable.a.i(paramDrawable).mutate();; paramDrawable = null)
    {
      this.iz = paramDrawable;
      float f2 = bn();
      c(localDrawable);
      if (bk()) {
        d(this.iz);
      }
      invalidateSelf();
      if (f1 != f2) {
        bj();
      }
      return;
    }
  }
  
  public final void setChipIconSize(float paramFloat)
  {
    if (this.iB != paramFloat)
    {
      float f = bn();
      this.iB = paramFloat;
      paramFloat = bn();
      invalidateSelf();
      if (f != paramFloat) {
        bj();
      }
    }
  }
  
  public final void setChipIconTint(ColorStateList paramColorStateList)
  {
    if (this.iA != paramColorStateList)
    {
      this.iA = paramColorStateList;
      if (bk()) {
        android.support.v4.graphics.drawable.a.a(this.iz, paramColorStateList);
      }
      onStateChange(getState());
    }
  }
  
  public final void setChipIconVisible(boolean paramBoolean)
  {
    int i;
    if (this.iy != paramBoolean)
    {
      boolean bool = bk();
      this.iy = paramBoolean;
      paramBoolean = bk();
      if (bool == paramBoolean) {
        break label55;
      }
      i = 1;
      if (i != 0)
      {
        if (!paramBoolean) {
          break label60;
        }
        d(this.iz);
      }
    }
    for (;;)
    {
      invalidateSelf();
      bj();
      return;
      label55:
      i = 0;
      break;
      label60:
      c(this.iz);
    }
  }
  
  public final void setChipMinHeight(float paramFloat)
  {
    if (this.iq != paramFloat)
    {
      this.iq = paramFloat;
      invalidateSelf();
      bj();
    }
  }
  
  public final void setChipStartPadding(float paramFloat)
  {
    if (this.iM != paramFloat)
    {
      this.iM = paramFloat;
      invalidateSelf();
      bj();
    }
  }
  
  public final void setChipStrokeColor(ColorStateList paramColorStateList)
  {
    if (this.is != paramColorStateList)
    {
      this.is = paramColorStateList;
      onStateChange(getState());
    }
  }
  
  public final void setChipStrokeWidth(float paramFloat)
  {
    if (this.it != paramFloat)
    {
      this.it = paramFloat;
      this.iV.setStrokeWidth(paramFloat);
      invalidateSelf();
    }
  }
  
  public final void setCloseIcon(Drawable paramDrawable)
  {
    Drawable localDrawable = getCloseIcon();
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
      this.iD = paramDrawable;
      float f2 = bp();
      c(localDrawable);
      if (bm()) {
        d(this.iD);
      }
      invalidateSelf();
      if (f1 != f2) {
        bj();
      }
      return;
    }
  }
  
  public final void setCloseIconEndPadding(float paramFloat)
  {
    if (this.iS != paramFloat)
    {
      this.iS = paramFloat;
      invalidateSelf();
      if (bm()) {
        bj();
      }
    }
  }
  
  public final void setCloseIconSize(float paramFloat)
  {
    if (this.iF != paramFloat)
    {
      this.iF = paramFloat;
      invalidateSelf();
      if (bm()) {
        bj();
      }
    }
  }
  
  public final void setCloseIconStartPadding(float paramFloat)
  {
    if (this.iR != paramFloat)
    {
      this.iR = paramFloat;
      invalidateSelf();
      if (bm()) {
        bj();
      }
    }
  }
  
  public final void setCloseIconTint(ColorStateList paramColorStateList)
  {
    if (this.iE != paramColorStateList)
    {
      this.iE = paramColorStateList;
      if (bm()) {
        android.support.v4.graphics.drawable.a.a(this.iD, paramColorStateList);
      }
      onStateChange(getState());
    }
  }
  
  public final void setCloseIconVisible(boolean paramBoolean)
  {
    int i;
    if (this.iC != paramBoolean)
    {
      boolean bool = bm();
      this.iC = paramBoolean;
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
        d(this.iD);
      }
    }
    for (;;)
    {
      invalidateSelf();
      bj();
      return;
      label55:
      i = 0;
      break;
      label60:
      c(this.iD);
    }
  }
  
  public final void setColorFilter(ColorFilter paramColorFilter)
  {
    if (this.jf != paramColorFilter)
    {
      this.jf = paramColorFilter;
      invalidateSelf();
    }
  }
  
  public final void setIconEndPadding(float paramFloat)
  {
    if (this.iO != paramFloat)
    {
      float f = bn();
      this.iO = paramFloat;
      paramFloat = bn();
      invalidateSelf();
      if (f != paramFloat) {
        bj();
      }
    }
  }
  
  public final void setIconStartPadding(float paramFloat)
  {
    if (this.iN != paramFloat)
    {
      float f = bn();
      this.iN = paramFloat;
      paramFloat = bn();
      invalidateSelf();
      if (f != paramFloat) {
        bj();
      }
    }
  }
  
  public final void setRippleColor(ColorStateList paramColorStateList)
  {
    if (this.hJ != paramColorStateList)
    {
      this.hJ = paramColorStateList;
      br();
      onStateChange(getState());
    }
  }
  
  public final void setText(CharSequence paramCharSequence)
  {
    Object localObject = paramCharSequence;
    if (paramCharSequence == null) {
      localObject = "";
    }
    if (this.iu != localObject)
    {
      this.iu = ((CharSequence)localObject);
      this.iw = android.support.v4.d.a.fb().unicodeWrap((CharSequence)localObject);
      this.jn = true;
      invalidateSelf();
      bj();
    }
  }
  
  public final void setTextAppearance(android.support.design.d.b paramb)
  {
    if (this.ix != paramb)
    {
      this.ix = paramb;
      if (paramb != null)
      {
        paramb.c(this.context, this.iU, this.ik);
        this.jn = true;
      }
      onStateChange(getState());
      bj();
    }
  }
  
  public final void setTextAppearanceResource(int paramInt)
  {
    setTextAppearance(new android.support.design.d.b(this.context, paramInt));
  }
  
  public final void setTextEndPadding(float paramFloat)
  {
    if (this.iQ != paramFloat)
    {
      this.iQ = paramFloat;
      invalidateSelf();
      bj();
    }
  }
  
  public final void setTextStartPadding(float paramFloat)
  {
    if (this.iP != paramFloat)
    {
      this.iP = paramFloat;
      invalidateSelf();
      bj();
    }
  }
  
  public final void setTintList(ColorStateList paramColorStateList)
  {
    if (this.jh != paramColorStateList)
    {
      this.jh = paramColorStateList;
      onStateChange(getState());
    }
  }
  
  public final void setTintMode(PorterDuff.Mode paramMode)
  {
    if (this.ji != paramMode)
    {
      this.ji = paramMode;
      this.jg = android.support.design.b.a.a(this, this.jh, paramMode);
      invalidateSelf();
    }
  }
  
  public final boolean setVisible(boolean paramBoolean1, boolean paramBoolean2)
  {
    boolean bool2 = super.setVisible(paramBoolean1, paramBoolean2);
    boolean bool1 = bool2;
    if (bk()) {
      bool1 = bool2 | this.iz.setVisible(paramBoolean1, paramBoolean2);
    }
    bool2 = bool1;
    if (bl()) {
      bool2 = bool1 | this.iJ.setVisible(paramBoolean1, paramBoolean2);
    }
    bool1 = bool2;
    if (bm()) {
      bool1 = bool2 | this.iD.setVisible(paramBoolean1, paramBoolean2);
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
    public abstract void be();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     android.support.design.chip.a
 * JD-Core Version:    0.7.0.1
 */