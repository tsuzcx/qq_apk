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
  private static final int[] gu = { 16842910 };
  private int alpha = 255;
  final Context context;
  ColorStateList fS;
  private final RectF fV = new RectF();
  CharSequence gA;
  private CharSequence gB;
  android.support.design.d.b gC;
  boolean gD;
  private Drawable gE;
  ColorStateList gF;
  float gG;
  boolean gH;
  Drawable gI;
  ColorStateList gJ;
  float gK;
  CharSequence gL;
  boolean gM;
  boolean gN;
  Drawable gO;
  h gP;
  h gQ;
  float gR;
  float gS;
  float gT;
  float gU;
  float gV;
  float gW;
  float gX;
  float gY;
  private final TextPaint gZ = new TextPaint(1);
  private final f.a gs = new f.a()
  {
    public final void D(int paramAnonymousInt) {}
    
    public final void a(Typeface paramAnonymousTypeface)
    {
      a.a(a.this);
      a.this.aT();
      a.this.invalidateSelf();
    }
  };
  ColorStateList gv;
  float gw;
  float gx;
  ColorStateList gy;
  float gz;
  private final Paint ha = new Paint(1);
  private final Paint hb;
  private final Paint.FontMetrics hc = new Paint.FontMetrics();
  private final PointF hd = new PointF();
  private int he;
  private int hf;
  private int hg;
  private int hh;
  private boolean hi;
  private int hj;
  private ColorFilter hk;
  private PorterDuffColorFilter hl;
  private ColorStateList hm;
  private PorterDuff.Mode hn = PorterDuff.Mode.SRC_IN;
  private int[] ho;
  private boolean hp;
  private ColorStateList hq;
  private WeakReference<a> hr = new WeakReference(null);
  private boolean hs = true;
  private float ht;
  TextUtils.TruncateAt hu;
  boolean hv;
  int maxWidth;
  
  private a(Context paramContext)
  {
    this.context = paramContext;
    this.gA = "";
    this.gZ.density = paramContext.getResources().getDisplayMetrics().density;
    this.hb = null;
    if (this.hb != null) {
      this.hb.setStyle(Paint.Style.STROKE);
    }
    setState(gu);
    b(gu);
    this.hv = true;
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
      locala.gP = h.a(locala.context, localTypedArray, 31);
      locala.gQ = h.a(locala.context, localTypedArray, 27);
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
      locala.hu = TextUtils.TruncateAt.START;
      continue;
      locala.hu = TextUtils.TruncateAt.MIDDLE;
      continue;
      locala.hu = TextUtils.TruncateAt.END;
    }
  }
  
  private void a(Rect paramRect, RectF paramRectF)
  {
    paramRectF.setEmpty();
    float f;
    if ((aU()) || (aV()))
    {
      f = this.gR + this.gS;
      if (android.support.v4.graphics.drawable.a.k(this) != 0) {
        break label88;
      }
      paramRectF.left = (f + paramRect.left);
      paramRectF.right = (paramRectF.left + this.gG);
    }
    for (;;)
    {
      paramRectF.top = (paramRect.exactCenterY() - this.gG / 2.0F);
      paramRectF.bottom = (paramRectF.top + this.gG);
      return;
      label88:
      paramRectF.right = (paramRect.right - f);
      paramRectF.left = (paramRectF.right - this.gG);
    }
  }
  
  private static boolean a(ColorStateList paramColorStateList)
  {
    return (paramColorStateList != null) && (paramColorStateList.isStateful());
  }
  
  private boolean aU()
  {
    return (this.gD) && (this.gE != null);
  }
  
  private boolean aV()
  {
    return (this.gN) && (this.gO != null) && (this.hi);
  }
  
  private boolean aW()
  {
    return (this.gH) && (this.gI != null);
  }
  
  private float aY()
  {
    if (!this.hs) {
      return this.ht;
    }
    this.ht = b(this.gB);
    this.hs = false;
    return this.ht;
  }
  
  private float aZ()
  {
    if (aW()) {
      return this.gW + this.gK + this.gX;
    }
    return 0.0F;
  }
  
  private float b(CharSequence paramCharSequence)
  {
    if (paramCharSequence == null) {
      return 0.0F;
    }
    return this.gZ.measureText(paramCharSequence, 0, paramCharSequence.length());
  }
  
  private void b(Rect paramRect, RectF paramRectF)
  {
    paramRectF.setEmpty();
    float f;
    if (aW())
    {
      f = this.gY + this.gX;
      if (android.support.v4.graphics.drawable.a.k(this) != 0) {
        break label81;
      }
      paramRectF.right = (paramRect.right - f);
      paramRectF.left = (paramRectF.right - this.gK);
    }
    for (;;)
    {
      paramRectF.top = (paramRect.exactCenterY() - this.gK / 2.0F);
      paramRectF.bottom = (paramRectF.top + this.gK);
      return;
      label81:
      paramRectF.left = (f + paramRect.left);
      paramRectF.right = (paramRectF.left + this.gK);
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
    if (this.gv != null)
    {
      i = this.gv.getColorForState(paramArrayOfInt1, this.he);
      if (this.he == i) {
        break label473;
      }
      this.he = i;
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
      if (this.gy != null)
      {
        i = this.gy.getColorForState(paramArrayOfInt1, this.hf);
        if (this.hf != i)
        {
          this.hf = i;
          bool1 = true;
        }
        if (this.hq == null) {
          break label433;
        }
        i = this.hq.getColorForState(paramArrayOfInt1, this.hg);
        bool2 = bool1;
        if (this.hg != i)
        {
          this.hg = i;
          bool2 = bool1;
          if (this.hp) {
            bool2 = true;
          }
        }
        if ((this.gC == null) || (this.gC.jk == null)) {
          break label439;
        }
        i = this.gC.jk.getColorForState(paramArrayOfInt1, this.hh);
        bool1 = bool2;
        if (this.hh != i)
        {
          this.hh = i;
          bool1 = true;
        }
        if ((!c(getState())) || (!this.gM)) {
          break label445;
        }
        bool2 = true;
        label221:
        if ((this.hi == bool2) || (this.gO == null)) {
          break label467;
        }
        float f = aX();
        this.hi = bool2;
        if (f == aX()) {
          break label458;
        }
        i = 1;
        bool1 = true;
      }
      for (;;)
      {
        if (this.hm != null) {
          j = this.hm.getColorForState(paramArrayOfInt1, this.hj);
        }
        if (this.hj != j)
        {
          this.hj = j;
          this.hl = android.support.design.b.a.a(this, this.hm, this.hn);
        }
        for (bool2 = bool3;; bool2 = bool1)
        {
          bool1 = bool2;
          if (b(this.gE)) {
            bool1 = bool2 | this.gE.setState(paramArrayOfInt1);
          }
          bool2 = bool1;
          if (b(this.gO)) {
            bool2 = bool1 | this.gO.setState(paramArrayOfInt1);
          }
          bool1 = bool2;
          if (b(this.gI)) {
            bool1 = bool2 | this.gI.setState(paramArrayOfInt2);
          }
          if (bool1) {
            invalidateSelf();
          }
          if (i != 0) {
            aT();
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
  
  private ColorFilter ba()
  {
    if (this.hk != null) {
      return this.hk;
    }
    return this.hl;
  }
  
  private void bb()
  {
    if (this.hp) {}
    for (ColorStateList localColorStateList = android.support.design.e.a.b(this.fS);; localColorStateList = null)
    {
      this.hq = localColorStateList;
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
      if (paramDrawable != this.gI) {
        break label70;
      }
      if (paramDrawable.isStateful()) {
        paramDrawable.setState(this.ho);
      }
      android.support.v4.graphics.drawable.a.a(paramDrawable, this.gJ);
    }
    label70:
    while (!paramDrawable.isStateful()) {
      return;
    }
    paramDrawable.setState(getState());
  }
  
  public final void a(a parama)
  {
    this.hr = new WeakReference(parama);
  }
  
  protected final void aT()
  {
    a locala = (a)this.hr.get();
    if (locala != null) {
      locala.aO();
    }
  }
  
  final float aX()
  {
    if ((aU()) || (aV())) {
      return this.gS + this.gG + this.gT;
    }
    return 0.0F;
  }
  
  public final boolean b(int[] paramArrayOfInt)
  {
    if (!Arrays.equals(this.ho, paramArrayOfInt))
    {
      this.ho = paramArrayOfInt;
      if (aW()) {
        return b(getState(), paramArrayOfInt);
      }
    }
    return false;
  }
  
  final void c(Rect paramRect, RectF paramRectF)
  {
    paramRectF.setEmpty();
    float f;
    if (aW())
    {
      f = this.gY + this.gX + this.gK + this.gW + this.gV;
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
      this.ha.setColor(this.he);
      this.ha.setStyle(Paint.Style.FILL);
      this.ha.setColorFilter(ba());
      this.fV.set(localRect);
      paramCanvas.drawRoundRect(this.fV, this.gx, this.gx, this.ha);
      if (this.gz > 0.0F)
      {
        this.ha.setColor(this.hf);
        this.ha.setStyle(Paint.Style.STROKE);
        this.ha.setColorFilter(ba());
        this.fV.set(localRect.left + this.gz / 2.0F, localRect.top + this.gz / 2.0F, localRect.right - this.gz / 2.0F, localRect.bottom - this.gz / 2.0F);
        f1 = this.gx - this.gz / 2.0F;
        paramCanvas.drawRoundRect(this.fV, f1, f1, this.ha);
      }
      this.ha.setColor(this.hg);
      this.ha.setStyle(Paint.Style.FILL);
      this.fV.set(localRect);
      paramCanvas.drawRoundRect(this.fV, this.gx, this.gx, this.ha);
      if (aU())
      {
        a(localRect, this.fV);
        f1 = this.fV.left;
        f2 = this.fV.top;
        paramCanvas.translate(f1, f2);
        this.gE.setBounds(0, 0, (int)this.fV.width(), (int)this.fV.height());
        this.gE.draw(paramCanvas);
        paramCanvas.translate(-f1, -f2);
      }
      if (aV())
      {
        a(localRect, this.fV);
        f1 = this.fV.left;
        f2 = this.fV.top;
        paramCanvas.translate(f1, f2);
        this.gO.setBounds(0, 0, (int)this.fV.width(), (int)this.fV.height());
        this.gO.draw(paramCanvas);
        paramCanvas.translate(-f1, -f2);
      }
      Object localObject2;
      Object localObject1;
      label568:
      int j;
      label692:
      int k;
      if ((this.hv) && (this.gB != null))
      {
        localObject2 = this.hd;
        ((PointF)localObject2).set(0.0F, 0.0F);
        localObject1 = Paint.Align.LEFT;
        if (this.gB != null)
        {
          f1 = this.gR + aX() + this.gU;
          if (android.support.v4.graphics.drawable.a.k(this) != 0) {
            break label1275;
          }
          ((PointF)localObject2).x = (f1 + localRect.left);
          localObject1 = Paint.Align.LEFT;
          f1 = localRect.centerY();
          this.gZ.getFontMetrics(this.hc);
          ((PointF)localObject2).y = (f1 - (this.hc.descent + this.hc.ascent) / 2.0F);
        }
        localObject2 = this.fV;
        ((RectF)localObject2).setEmpty();
        if (this.gB != null)
        {
          f1 = this.gR + aX() + this.gU;
          f2 = this.gY + aZ() + this.gV;
          if (android.support.v4.graphics.drawable.a.k(this) != 0) {
            break label1296;
          }
          ((RectF)localObject2).left = (f1 + localRect.left);
          ((RectF)localObject2).right = (localRect.right - f2);
          ((RectF)localObject2).top = localRect.top;
          ((RectF)localObject2).bottom = localRect.bottom;
        }
        if (this.gC != null)
        {
          this.gZ.drawableState = getState();
          this.gC.b(this.context, this.gZ, this.gs);
        }
        this.gZ.setTextAlign((Paint.Align)localObject1);
        if (Math.round(aY()) <= Math.round(this.fV.width())) {
          break label1325;
        }
        j = 1;
        label783:
        if (j == 0) {
          break label1347;
        }
        k = paramCanvas.save();
        paramCanvas.clipRect(this.fV);
      }
      for (;;)
      {
        localObject2 = this.gB;
        localObject1 = localObject2;
        if (j != 0)
        {
          localObject1 = localObject2;
          if (this.hu != null) {
            localObject1 = TextUtils.ellipsize(this.gB, this.gZ, this.fV.width(), this.hu);
          }
        }
        paramCanvas.drawText((CharSequence)localObject1, 0, ((CharSequence)localObject1).length(), this.hd.x, this.hd.y, this.gZ);
        if (j != 0) {
          paramCanvas.restoreToCount(k);
        }
        if (aW())
        {
          b(localRect, this.fV);
          f1 = this.fV.left;
          f2 = this.fV.top;
          paramCanvas.translate(f1, f2);
          this.gI.setBounds(0, 0, (int)this.fV.width(), (int)this.fV.height());
          this.gI.draw(paramCanvas);
          paramCanvas.translate(-f1, -f2);
        }
        if (this.hb != null)
        {
          this.hb.setColor(android.support.v4.graphics.b.q(-16777216, 127));
          paramCanvas.drawRect(localRect, this.hb);
          if ((aU()) || (aV()))
          {
            a(localRect, this.fV);
            paramCanvas.drawRect(this.fV, this.hb);
          }
          if (this.gB != null) {
            paramCanvas.drawLine(localRect.left, localRect.exactCenterY(), localRect.right, localRect.exactCenterY(), this.hb);
          }
          if (aW())
          {
            b(localRect, this.fV);
            paramCanvas.drawRect(this.fV, this.hb);
          }
          this.hb.setColor(android.support.v4.graphics.b.q(-65536, 127));
          localObject1 = this.fV;
          ((RectF)localObject1).set(localRect);
          if (aW())
          {
            f1 = this.gY + this.gX + this.gK + this.gW + this.gV;
            if (android.support.v4.graphics.drawable.a.k(this) != 0) {
              break label1331;
            }
            ((RectF)localObject1).right = (localRect.right - f1);
          }
        }
        for (;;)
        {
          paramCanvas.drawRect(this.fV, this.hb);
          this.hb.setColor(android.support.v4.graphics.b.q(-16711936, 127));
          c(localRect, this.fV);
          paramCanvas.drawRect(this.fV, this.hb);
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
    if (this.gE != null) {
      return android.support.v4.graphics.drawable.a.j(this.gE);
    }
    return null;
  }
  
  public final Drawable getCloseIcon()
  {
    if (this.gI != null) {
      return android.support.v4.graphics.drawable.a.j(this.gI);
    }
    return null;
  }
  
  public final ColorFilter getColorFilter()
  {
    return this.hk;
  }
  
  public final int getIntrinsicHeight()
  {
    return (int)this.gw;
  }
  
  public final int getIntrinsicWidth()
  {
    return Math.min(Math.round(this.gR + aX() + this.gU + aY() + this.gV + aZ() + this.gY), this.maxWidth);
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
      paramOutline.setRoundRect(localRect, this.gx);
    }
    for (;;)
    {
      paramOutline.setAlpha(getAlpha() / 255.0F);
      return;
      paramOutline.setRoundRect(0, 0, getIntrinsicWidth(), getIntrinsicHeight(), this.gx);
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
    if ((!a(this.gv)) && (!a(this.gy)) && ((!this.hp) || (!a(this.hq))))
    {
      android.support.design.d.b localb = this.gC;
      if ((localb == null) || (localb.jk == null) || (!localb.jk.isStateful())) {
        break label132;
      }
      i = 1;
      if (i == 0) {
        if ((!this.gN) || (this.gO == null) || (!this.gM)) {
          break label137;
        }
      }
    }
    label132:
    label137:
    for (int i = 1;; i = 0)
    {
      if ((i != 0) || (b(this.gE)) || (b(this.gO)) || (a(this.hm))) {
        bool = true;
      }
      return bool;
      i = 0;
      break;
    }
  }
  
  public final void o(boolean paramBoolean)
  {
    if (this.hp != paramBoolean)
    {
      this.hp = paramBoolean;
      bb();
      onStateChange(getState());
    }
  }
  
  @TargetApi(23)
  public final boolean onLayoutDirectionChanged(int paramInt)
  {
    boolean bool2 = super.onLayoutDirectionChanged(paramInt);
    boolean bool1 = bool2;
    if (aU()) {
      bool1 = bool2 | this.gE.setLayoutDirection(paramInt);
    }
    bool2 = bool1;
    if (aV()) {
      bool2 = bool1 | this.gO.setLayoutDirection(paramInt);
    }
    bool1 = bool2;
    if (aW()) {
      bool1 = bool2 | this.gI.setLayoutDirection(paramInt);
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
    if (aU()) {
      bool1 = bool2 | this.gE.setLevel(paramInt);
    }
    bool2 = bool1;
    if (aV()) {
      bool2 = bool1 | this.gO.setLevel(paramInt);
    }
    bool1 = bool2;
    if (aW()) {
      bool1 = bool2 | this.gI.setLevel(paramInt);
    }
    if (bool1) {
      invalidateSelf();
    }
    return bool1;
  }
  
  protected final boolean onStateChange(int[] paramArrayOfInt)
  {
    return b(paramArrayOfInt, this.ho);
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
    if (this.gM != paramBoolean)
    {
      this.gM = paramBoolean;
      float f1 = aX();
      if ((!paramBoolean) && (this.hi)) {
        this.hi = false;
      }
      float f2 = aX();
      invalidateSelf();
      if (f1 != f2) {
        aT();
      }
    }
  }
  
  public final void setCheckedIcon(Drawable paramDrawable)
  {
    if (this.gO != paramDrawable)
    {
      float f1 = aX();
      this.gO = paramDrawable;
      float f2 = aX();
      c(this.gO);
      d(this.gO);
      invalidateSelf();
      if (f1 != f2) {
        aT();
      }
    }
  }
  
  public final void setCheckedIconVisible(boolean paramBoolean)
  {
    int i;
    if (this.gN != paramBoolean)
    {
      boolean bool = aV();
      this.gN = paramBoolean;
      paramBoolean = aV();
      if (bool == paramBoolean) {
        break label55;
      }
      i = 1;
      if (i != 0)
      {
        if (!paramBoolean) {
          break label60;
        }
        d(this.gO);
      }
    }
    for (;;)
    {
      invalidateSelf();
      aT();
      return;
      label55:
      i = 0;
      break;
      label60:
      c(this.gO);
    }
  }
  
  public final void setChipBackgroundColor(ColorStateList paramColorStateList)
  {
    if (this.gv != paramColorStateList)
    {
      this.gv = paramColorStateList;
      onStateChange(getState());
    }
  }
  
  public final void setChipCornerRadius(float paramFloat)
  {
    if (this.gx != paramFloat)
    {
      this.gx = paramFloat;
      invalidateSelf();
    }
  }
  
  public final void setChipEndPadding(float paramFloat)
  {
    if (this.gY != paramFloat)
    {
      this.gY = paramFloat;
      invalidateSelf();
      aT();
    }
  }
  
  public final void setChipIcon(Drawable paramDrawable)
  {
    Drawable localDrawable = getChipIcon();
    float f1;
    if (localDrawable != paramDrawable)
    {
      f1 = aX();
      if (paramDrawable == null) {
        break label74;
      }
    }
    label74:
    for (paramDrawable = android.support.v4.graphics.drawable.a.i(paramDrawable).mutate();; paramDrawable = null)
    {
      this.gE = paramDrawable;
      float f2 = aX();
      c(localDrawable);
      if (aU()) {
        d(this.gE);
      }
      invalidateSelf();
      if (f1 != f2) {
        aT();
      }
      return;
    }
  }
  
  public final void setChipIconSize(float paramFloat)
  {
    if (this.gG != paramFloat)
    {
      float f = aX();
      this.gG = paramFloat;
      paramFloat = aX();
      invalidateSelf();
      if (f != paramFloat) {
        aT();
      }
    }
  }
  
  public final void setChipIconTint(ColorStateList paramColorStateList)
  {
    if (this.gF != paramColorStateList)
    {
      this.gF = paramColorStateList;
      if (aU()) {
        android.support.v4.graphics.drawable.a.a(this.gE, paramColorStateList);
      }
      onStateChange(getState());
    }
  }
  
  public final void setChipIconVisible(boolean paramBoolean)
  {
    int i;
    if (this.gD != paramBoolean)
    {
      boolean bool = aU();
      this.gD = paramBoolean;
      paramBoolean = aU();
      if (bool == paramBoolean) {
        break label55;
      }
      i = 1;
      if (i != 0)
      {
        if (!paramBoolean) {
          break label60;
        }
        d(this.gE);
      }
    }
    for (;;)
    {
      invalidateSelf();
      aT();
      return;
      label55:
      i = 0;
      break;
      label60:
      c(this.gE);
    }
  }
  
  public final void setChipMinHeight(float paramFloat)
  {
    if (this.gw != paramFloat)
    {
      this.gw = paramFloat;
      invalidateSelf();
      aT();
    }
  }
  
  public final void setChipStartPadding(float paramFloat)
  {
    if (this.gR != paramFloat)
    {
      this.gR = paramFloat;
      invalidateSelf();
      aT();
    }
  }
  
  public final void setChipStrokeColor(ColorStateList paramColorStateList)
  {
    if (this.gy != paramColorStateList)
    {
      this.gy = paramColorStateList;
      onStateChange(getState());
    }
  }
  
  public final void setChipStrokeWidth(float paramFloat)
  {
    if (this.gz != paramFloat)
    {
      this.gz = paramFloat;
      this.ha.setStrokeWidth(paramFloat);
      invalidateSelf();
    }
  }
  
  public final void setCloseIcon(Drawable paramDrawable)
  {
    Drawable localDrawable = getCloseIcon();
    float f1;
    if (localDrawable != paramDrawable)
    {
      f1 = aZ();
      if (paramDrawable == null) {
        break label74;
      }
    }
    label74:
    for (paramDrawable = android.support.v4.graphics.drawable.a.i(paramDrawable).mutate();; paramDrawable = null)
    {
      this.gI = paramDrawable;
      float f2 = aZ();
      c(localDrawable);
      if (aW()) {
        d(this.gI);
      }
      invalidateSelf();
      if (f1 != f2) {
        aT();
      }
      return;
    }
  }
  
  public final void setCloseIconEndPadding(float paramFloat)
  {
    if (this.gX != paramFloat)
    {
      this.gX = paramFloat;
      invalidateSelf();
      if (aW()) {
        aT();
      }
    }
  }
  
  public final void setCloseIconSize(float paramFloat)
  {
    if (this.gK != paramFloat)
    {
      this.gK = paramFloat;
      invalidateSelf();
      if (aW()) {
        aT();
      }
    }
  }
  
  public final void setCloseIconStartPadding(float paramFloat)
  {
    if (this.gW != paramFloat)
    {
      this.gW = paramFloat;
      invalidateSelf();
      if (aW()) {
        aT();
      }
    }
  }
  
  public final void setCloseIconTint(ColorStateList paramColorStateList)
  {
    if (this.gJ != paramColorStateList)
    {
      this.gJ = paramColorStateList;
      if (aW()) {
        android.support.v4.graphics.drawable.a.a(this.gI, paramColorStateList);
      }
      onStateChange(getState());
    }
  }
  
  public final void setCloseIconVisible(boolean paramBoolean)
  {
    int i;
    if (this.gH != paramBoolean)
    {
      boolean bool = aW();
      this.gH = paramBoolean;
      paramBoolean = aW();
      if (bool == paramBoolean) {
        break label55;
      }
      i = 1;
      if (i != 0)
      {
        if (!paramBoolean) {
          break label60;
        }
        d(this.gI);
      }
    }
    for (;;)
    {
      invalidateSelf();
      aT();
      return;
      label55:
      i = 0;
      break;
      label60:
      c(this.gI);
    }
  }
  
  public final void setColorFilter(ColorFilter paramColorFilter)
  {
    if (this.hk != paramColorFilter)
    {
      this.hk = paramColorFilter;
      invalidateSelf();
    }
  }
  
  public final void setIconEndPadding(float paramFloat)
  {
    if (this.gT != paramFloat)
    {
      float f = aX();
      this.gT = paramFloat;
      paramFloat = aX();
      invalidateSelf();
      if (f != paramFloat) {
        aT();
      }
    }
  }
  
  public final void setIconStartPadding(float paramFloat)
  {
    if (this.gS != paramFloat)
    {
      float f = aX();
      this.gS = paramFloat;
      paramFloat = aX();
      invalidateSelf();
      if (f != paramFloat) {
        aT();
      }
    }
  }
  
  public final void setRippleColor(ColorStateList paramColorStateList)
  {
    if (this.fS != paramColorStateList)
    {
      this.fS = paramColorStateList;
      bb();
      onStateChange(getState());
    }
  }
  
  public final void setText(CharSequence paramCharSequence)
  {
    Object localObject = paramCharSequence;
    if (paramCharSequence == null) {
      localObject = "";
    }
    if (this.gA != localObject)
    {
      this.gA = ((CharSequence)localObject);
      this.gB = android.support.v4.d.a.eK().unicodeWrap((CharSequence)localObject);
      this.hs = true;
      invalidateSelf();
      aT();
    }
  }
  
  public final void setTextAppearance(android.support.design.d.b paramb)
  {
    if (this.gC != paramb)
    {
      this.gC = paramb;
      if (paramb != null)
      {
        paramb.c(this.context, this.gZ, this.gs);
        this.hs = true;
      }
      onStateChange(getState());
      aT();
    }
  }
  
  public final void setTextAppearanceResource(int paramInt)
  {
    setTextAppearance(new android.support.design.d.b(this.context, paramInt));
  }
  
  public final void setTextEndPadding(float paramFloat)
  {
    if (this.gV != paramFloat)
    {
      this.gV = paramFloat;
      invalidateSelf();
      aT();
    }
  }
  
  public final void setTextStartPadding(float paramFloat)
  {
    if (this.gU != paramFloat)
    {
      this.gU = paramFloat;
      invalidateSelf();
      aT();
    }
  }
  
  public final void setTintList(ColorStateList paramColorStateList)
  {
    if (this.hm != paramColorStateList)
    {
      this.hm = paramColorStateList;
      onStateChange(getState());
    }
  }
  
  public final void setTintMode(PorterDuff.Mode paramMode)
  {
    if (this.hn != paramMode)
    {
      this.hn = paramMode;
      this.hl = android.support.design.b.a.a(this, this.hm, paramMode);
      invalidateSelf();
    }
  }
  
  public final boolean setVisible(boolean paramBoolean1, boolean paramBoolean2)
  {
    boolean bool2 = super.setVisible(paramBoolean1, paramBoolean2);
    boolean bool1 = bool2;
    if (aU()) {
      bool1 = bool2 | this.gE.setVisible(paramBoolean1, paramBoolean2);
    }
    bool2 = bool1;
    if (aV()) {
      bool2 = bool1 | this.gO.setVisible(paramBoolean1, paramBoolean2);
    }
    bool1 = bool2;
    if (aW()) {
      bool1 = bool2 | this.gI.setVisible(paramBoolean1, paramBoolean2);
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
    public abstract void aO();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     android.support.design.chip.a
 * JD-Core Version:    0.7.0.1
 */