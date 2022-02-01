package android.support.d.a;

import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.content.res.Resources.Theme;
import android.content.res.TypedArray;
import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.ColorFilter;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Paint.Cap;
import android.graphics.Paint.Join;
import android.graphics.Paint.Style;
import android.graphics.Path;
import android.graphics.Path.FillType;
import android.graphics.PathMeasure;
import android.graphics.PorterDuff.Mode;
import android.graphics.PorterDuffColorFilter;
import android.graphics.Rect;
import android.graphics.Shader;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.Drawable.ConstantState;
import android.graphics.drawable.VectorDrawable;
import android.os.Build.VERSION;
import android.support.v4.content.a.b;
import android.support.v4.content.a.f;
import android.support.v4.content.a.g;
import android.support.v4.graphics.c;
import android.support.v4.graphics.c.b;
import android.util.AttributeSet;
import android.util.Xml;
import java.io.IOException;
import java.util.ArrayDeque;
import java.util.ArrayList;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;

public final class i
  extends h
{
  static final PorterDuff.Mode xe = PorterDuff.Mode.SRC_IN;
  g xf;
  private PorterDuffColorFilter xg;
  private ColorFilter xh;
  private boolean xi;
  boolean xj = true;
  private Drawable.ConstantState xk;
  private final float[] xl = new float[9];
  private final Matrix xm = new Matrix();
  private final Rect xn = new Rect();
  
  i()
  {
    this.xf = new g();
  }
  
  i(g paramg)
  {
    this.xf = paramg;
    this.xg = a(paramg.ye, paramg.yf);
  }
  
  private PorterDuffColorFilter a(ColorStateList paramColorStateList, PorterDuff.Mode paramMode)
  {
    if ((paramColorStateList == null) || (paramMode == null)) {
      return null;
    }
    return new PorterDuffColorFilter(paramColorStateList.getColorForState(getState(), 0), paramMode);
  }
  
  public static i a(Resources paramResources, int paramInt, Resources.Theme paramTheme)
  {
    Object localObject;
    if (Build.VERSION.SDK_INT >= 24)
    {
      localObject = new i();
      ((i)localObject).xd = f.c(paramResources, paramInt, paramTheme);
      ((i)localObject).xk = new h(((i)localObject).xd.getConstantState());
      return localObject;
    }
    try
    {
      localObject = paramResources.getXml(paramInt);
      AttributeSet localAttributeSet = Xml.asAttributeSet((XmlPullParser)localObject);
      do
      {
        paramInt = ((XmlPullParser)localObject).next();
      } while ((paramInt != 2) && (paramInt != 1));
      if (paramInt != 2) {
        throw new XmlPullParserException("No start tag found");
      }
      paramResources = a(paramResources, (XmlPullParser)localObject, localAttributeSet, paramTheme);
      return paramResources;
    }
    catch (IOException paramResources) {}catch (XmlPullParserException paramResources) {}
    return null;
  }
  
  public static i a(Resources paramResources, XmlPullParser paramXmlPullParser, AttributeSet paramAttributeSet, Resources.Theme paramTheme)
  {
    i locali = new i();
    locali.inflate(paramResources, paramXmlPullParser, paramAttributeSet, paramTheme);
    return locali;
  }
  
  private void b(Resources paramResources, XmlPullParser paramXmlPullParser, AttributeSet paramAttributeSet, Resources.Theme paramTheme)
  {
    g localg = this.xf;
    f localf = localg.yd;
    int i = 1;
    ArrayDeque localArrayDeque = new ArrayDeque();
    localArrayDeque.push(localf.xU);
    int j = paramXmlPullParser.getEventType();
    int k = paramXmlPullParser.getDepth();
    if ((j != 1) && ((paramXmlPullParser.getDepth() >= k + 1) || (j != 3)))
    {
      Object localObject;
      c localc;
      TypedArray localTypedArray;
      if (j == 2)
      {
        localObject = paramXmlPullParser.getName();
        localc = (c)localArrayDeque.peek();
        if ("path".equals(localObject))
        {
          localObject = new b();
          localTypedArray = g.a(paramResources, paramTheme, paramAttributeSet, a.wF);
          ((b)localObject).a(localTypedArray, paramXmlPullParser, paramTheme);
          localTypedArray.recycle();
          localc.mChildren.add(localObject);
          if (((b)localObject).getPathName() != null) {
            localf.yc.put(((b)localObject).getPathName(), localObject);
          }
          i = 0;
          j = localg.mChangingConfigurations;
          localg.mChangingConfigurations = (((b)localObject).mChangingConfigurations | j);
        }
      }
      for (;;)
      {
        j = paramXmlPullParser.next();
        break;
        if ("clip-path".equals(localObject))
        {
          localObject = new a();
          if (g.a(paramXmlPullParser, "pathData"))
          {
            localTypedArray = g.a(paramResources, paramTheme, paramAttributeSet, a.wG);
            ((a)localObject).a(localTypedArray);
            localTypedArray.recycle();
          }
          localc.mChildren.add(localObject);
          if (((a)localObject).getPathName() != null) {
            localf.yc.put(((a)localObject).getPathName(), localObject);
          }
          localg.mChangingConfigurations |= ((a)localObject).mChangingConfigurations;
        }
        else
        {
          if ("group".equals(localObject))
          {
            localObject = new c();
            localTypedArray = g.a(paramResources, paramTheme, paramAttributeSet, a.wE);
            ((c)localObject).xo = null;
            ((c)localObject).xC = g.a(localTypedArray, paramXmlPullParser, "rotation", 5, ((c)localObject).xC);
            ((c)localObject).xD = localTypedArray.getFloat(1, ((c)localObject).xD);
            ((c)localObject).xE = localTypedArray.getFloat(2, ((c)localObject).xE);
            ((c)localObject).xF = g.a(localTypedArray, paramXmlPullParser, "scaleX", 3, ((c)localObject).xF);
            ((c)localObject).xG = g.a(localTypedArray, paramXmlPullParser, "scaleY", 4, ((c)localObject).xG);
            ((c)localObject).xH = g.a(localTypedArray, paramXmlPullParser, "translateX", 6, ((c)localObject).xH);
            ((c)localObject).xI = g.a(localTypedArray, paramXmlPullParser, "translateY", 7, ((c)localObject).xI);
            String str = localTypedArray.getString(0);
            if (str != null) {
              ((c)localObject).xK = str;
            }
            ((c)localObject).dy();
            localTypedArray.recycle();
            localc.mChildren.add(localObject);
            localArrayDeque.push(localObject);
            if (((c)localObject).getGroupName() != null) {
              localf.yc.put(((c)localObject).getGroupName(), localObject);
            }
            localg.mChangingConfigurations |= ((c)localObject).mChangingConfigurations;
          }
          continue;
          if ((j == 3) && ("group".equals(paramXmlPullParser.getName()))) {
            localArrayDeque.pop();
          }
        }
      }
    }
    if (i != 0) {
      throw new XmlPullParserException("no path defined");
    }
  }
  
  static int d(int paramInt, float paramFloat)
  {
    return (int)(Color.alpha(paramInt) * paramFloat) << 24 | 0xFFFFFF & paramInt;
  }
  
  public final boolean canApplyTheme()
  {
    if (this.xd != null) {
      android.support.v4.graphics.drawable.a.g(this.xd);
    }
    return false;
  }
  
  public final void draw(Canvas paramCanvas)
  {
    if (this.xd != null) {
      this.xd.draw(paramCanvas);
    }
    int i;
    int k;
    int m;
    do
    {
      do
      {
        return;
        copyBounds(this.xn);
      } while ((this.xn.width() <= 0) || (this.xn.height() <= 0));
      if (this.xh != null) {
        break;
      }
      localObject = this.xg;
      paramCanvas.getMatrix(this.xm);
      this.xm.getValues(this.xl);
      float f2 = Math.abs(this.xl[0]);
      float f1 = Math.abs(this.xl[4]);
      float f4 = Math.abs(this.xl[1]);
      float f3 = Math.abs(this.xl[3]);
      if ((f4 != 0.0F) || (f3 != 0.0F))
      {
        f1 = 1.0F;
        f2 = 1.0F;
      }
      j = (int)(f2 * this.xn.width());
      i = (int)(f1 * this.xn.height());
      k = Math.min(2048, j);
      m = Math.min(2048, i);
    } while ((k <= 0) || (m <= 0));
    int j = paramCanvas.save();
    paramCanvas.translate(this.xn.left, this.xn.top);
    label244:
    g localg;
    label322:
    label366:
    Rect localRect;
    if (Build.VERSION.SDK_INT >= 17) {
      if ((isAutoMirrored()) && (android.support.v4.graphics.drawable.a.k(this) == 1))
      {
        i = 1;
        if (i != 0)
        {
          paramCanvas.translate(this.xn.width(), 0.0F);
          paramCanvas.scale(-1.0F, 1.0F);
        }
        this.xn.offsetTo(0, 0);
        localg = this.xf;
        if (localg.yh != null)
        {
          if ((k != localg.yh.getWidth()) || (m != localg.yh.getHeight())) {
            break label450;
          }
          i = 1;
          if (i != 0) {}
        }
        else
        {
          localg.yh = Bitmap.createBitmap(k, m, Bitmap.Config.ARGB_8888);
          localg.ym = true;
        }
        if (this.xj) {
          break label456;
        }
        this.xf.s(k, m);
        localg = this.xf;
        localRect = this.xn;
        if (localg.yd.getRootAlpha() >= 255) {
          break label608;
        }
        i = 1;
        label395:
        if ((i != 0) || (localObject != null)) {
          break label614;
        }
      }
    }
    for (Object localObject = null;; localObject = localg.yn)
    {
      paramCanvas.drawBitmap(localg.yh, null, localRect, (Paint)localObject);
      paramCanvas.restoreToCount(j);
      return;
      localObject = this.xh;
      break;
      i = 0;
      break label244;
      i = 0;
      break label244;
      label450:
      i = 0;
      break label322;
      label456:
      localg = this.xf;
      if ((!localg.ym) && (localg.yi == localg.ye) && (localg.yj == localg.yf) && (localg.yl == localg.yg) && (localg.yk == localg.yd.getRootAlpha())) {}
      for (i = 1;; i = 0)
      {
        if (i != 0) {
          break label606;
        }
        this.xf.s(k, m);
        localg = this.xf;
        localg.yi = localg.ye;
        localg.yj = localg.yf;
        localg.yk = localg.yd.getRootAlpha();
        localg.yl = localg.yg;
        localg.ym = false;
        break;
      }
      label606:
      break label366;
      label608:
      i = 0;
      break label395;
      label614:
      if (localg.yn == null)
      {
        localg.yn = new Paint();
        localg.yn.setFilterBitmap(true);
      }
      localg.yn.setAlpha(localg.yd.getRootAlpha());
      localg.yn.setColorFilter((ColorFilter)localObject);
    }
  }
  
  public final int getAlpha()
  {
    if (this.xd != null) {
      return android.support.v4.graphics.drawable.a.f(this.xd);
    }
    return this.xf.yd.getRootAlpha();
  }
  
  public final int getChangingConfigurations()
  {
    if (this.xd != null) {
      return this.xd.getChangingConfigurations();
    }
    return super.getChangingConfigurations() | this.xf.getChangingConfigurations();
  }
  
  public final Drawable.ConstantState getConstantState()
  {
    if ((this.xd != null) && (Build.VERSION.SDK_INT >= 24)) {
      return new h(this.xd.getConstantState());
    }
    this.xf.mChangingConfigurations = getChangingConfigurations();
    return this.xf;
  }
  
  public final int getIntrinsicHeight()
  {
    if (this.xd != null) {
      return this.xd.getIntrinsicHeight();
    }
    return (int)this.xf.yd.xW;
  }
  
  public final int getIntrinsicWidth()
  {
    if (this.xd != null) {
      return this.xd.getIntrinsicWidth();
    }
    return (int)this.xf.yd.xV;
  }
  
  public final int getOpacity()
  {
    if (this.xd != null) {
      return this.xd.getOpacity();
    }
    return -3;
  }
  
  public final void inflate(Resources paramResources, XmlPullParser paramXmlPullParser, AttributeSet paramAttributeSet)
  {
    if (this.xd != null)
    {
      this.xd.inflate(paramResources, paramXmlPullParser, paramAttributeSet);
      return;
    }
    inflate(paramResources, paramXmlPullParser, paramAttributeSet, null);
  }
  
  public final void inflate(Resources paramResources, XmlPullParser paramXmlPullParser, AttributeSet paramAttributeSet, Resources.Theme paramTheme)
  {
    if (this.xd != null)
    {
      android.support.v4.graphics.drawable.a.a(this.xd, paramResources, paramXmlPullParser, paramAttributeSet, paramTheme);
      return;
    }
    g localg1 = this.xf;
    localg1.yd = new f();
    TypedArray localTypedArray = g.a(paramResources, paramTheme, paramAttributeSet, a.wD);
    g localg2 = this.xf;
    f localf = localg2.yd;
    int i = g.a(localTypedArray, paramXmlPullParser, "tintMode", 6, -1);
    PorterDuff.Mode localMode = PorterDuff.Mode.SRC_IN;
    Object localObject = localMode;
    switch (i)
    {
    default: 
      localObject = localMode;
    }
    for (;;)
    {
      localg2.yf = ((PorterDuff.Mode)localObject);
      localObject = localTypedArray.getColorStateList(1);
      if (localObject != null) {
        localg2.ye = ((ColorStateList)localObject);
      }
      localg2.yg = g.a(localTypedArray, paramXmlPullParser, "autoMirrored", 5, localg2.yg);
      localf.xX = g.a(localTypedArray, paramXmlPullParser, "viewportWidth", 7, localf.xX);
      localf.xY = g.a(localTypedArray, paramXmlPullParser, "viewportHeight", 8, localf.xY);
      if (localf.xX > 0.0F) {
        break;
      }
      throw new XmlPullParserException(localTypedArray.getPositionDescription() + "<vector> tag requires viewportWidth > 0");
      localObject = PorterDuff.Mode.SRC_OVER;
      continue;
      localObject = PorterDuff.Mode.SRC_IN;
      continue;
      localObject = PorterDuff.Mode.SRC_ATOP;
      continue;
      localObject = PorterDuff.Mode.MULTIPLY;
      continue;
      localObject = PorterDuff.Mode.SCREEN;
      continue;
      localObject = PorterDuff.Mode.ADD;
    }
    if (localf.xY <= 0.0F) {
      throw new XmlPullParserException(localTypedArray.getPositionDescription() + "<vector> tag requires viewportHeight > 0");
    }
    localf.xV = localTypedArray.getDimension(3, localf.xV);
    localf.xW = localTypedArray.getDimension(2, localf.xW);
    if (localf.xV <= 0.0F) {
      throw new XmlPullParserException(localTypedArray.getPositionDescription() + "<vector> tag requires width > 0");
    }
    if (localf.xW <= 0.0F) {
      throw new XmlPullParserException(localTypedArray.getPositionDescription() + "<vector> tag requires height > 0");
    }
    localf.setAlpha(g.a(localTypedArray, paramXmlPullParser, "alpha", 4, localf.getAlpha()));
    localObject = localTypedArray.getString(0);
    if (localObject != null)
    {
      localf.ya = ((String)localObject);
      localf.yc.put(localObject, localf);
    }
    localTypedArray.recycle();
    localg1.mChangingConfigurations = getChangingConfigurations();
    localg1.ym = true;
    b(paramResources, paramXmlPullParser, paramAttributeSet, paramTheme);
    this.xg = a(localg1.ye, localg1.yf);
  }
  
  public final void invalidateSelf()
  {
    if (this.xd != null)
    {
      this.xd.invalidateSelf();
      return;
    }
    super.invalidateSelf();
  }
  
  public final boolean isAutoMirrored()
  {
    if (this.xd != null) {
      return android.support.v4.graphics.drawable.a.e(this.xd);
    }
    return this.xf.yg;
  }
  
  public final boolean isStateful()
  {
    if (this.xd != null) {
      return this.xd.isStateful();
    }
    return (super.isStateful()) || ((this.xf != null) && ((this.xf.yd.isStateful()) || ((this.xf.ye != null) && (this.xf.ye.isStateful()))));
  }
  
  public final Drawable mutate()
  {
    if (this.xd != null) {
      this.xd.mutate();
    }
    while ((this.xi) || (super.mutate() != this)) {
      return this;
    }
    this.xf = new g(this.xf);
    this.xi = true;
    return this;
  }
  
  protected final void onBoundsChange(Rect paramRect)
  {
    if (this.xd != null) {
      this.xd.setBounds(paramRect);
    }
  }
  
  protected final boolean onStateChange(int[] paramArrayOfInt)
  {
    boolean bool2;
    if (this.xd != null) {
      bool2 = this.xd.setState(paramArrayOfInt);
    }
    boolean bool3;
    do
    {
      g localg;
      boolean bool1;
      do
      {
        return bool2;
        bool2 = false;
        localg = this.xf;
        bool1 = bool2;
        if (localg.ye != null)
        {
          bool1 = bool2;
          if (localg.yf != null)
          {
            this.xg = a(localg.ye, localg.yf);
            invalidateSelf();
            bool1 = true;
          }
        }
        bool2 = bool1;
      } while (!localg.yd.isStateful());
      bool3 = localg.yd.xU.e(paramArrayOfInt);
      localg.ym |= bool3;
      bool2 = bool1;
    } while (!bool3);
    invalidateSelf();
    return true;
  }
  
  public final void scheduleSelf(Runnable paramRunnable, long paramLong)
  {
    if (this.xd != null)
    {
      this.xd.scheduleSelf(paramRunnable, paramLong);
      return;
    }
    super.scheduleSelf(paramRunnable, paramLong);
  }
  
  public final void setAlpha(int paramInt)
  {
    if (this.xd != null) {
      this.xd.setAlpha(paramInt);
    }
    while (this.xf.yd.getRootAlpha() == paramInt) {
      return;
    }
    this.xf.yd.setRootAlpha(paramInt);
    invalidateSelf();
  }
  
  public final void setAutoMirrored(boolean paramBoolean)
  {
    if (this.xd != null)
    {
      android.support.v4.graphics.drawable.a.a(this.xd, paramBoolean);
      return;
    }
    this.xf.yg = paramBoolean;
  }
  
  public final void setColorFilter(ColorFilter paramColorFilter)
  {
    if (this.xd != null)
    {
      this.xd.setColorFilter(paramColorFilter);
      return;
    }
    this.xh = paramColorFilter;
    invalidateSelf();
  }
  
  public final void setTint(int paramInt)
  {
    if (this.xd != null)
    {
      android.support.v4.graphics.drawable.a.a(this.xd, paramInt);
      return;
    }
    setTintList(ColorStateList.valueOf(paramInt));
  }
  
  public final void setTintList(ColorStateList paramColorStateList)
  {
    if (this.xd != null) {
      android.support.v4.graphics.drawable.a.a(this.xd, paramColorStateList);
    }
    g localg;
    do
    {
      return;
      localg = this.xf;
    } while (localg.ye == paramColorStateList);
    localg.ye = paramColorStateList;
    this.xg = a(paramColorStateList, localg.yf);
    invalidateSelf();
  }
  
  public final void setTintMode(PorterDuff.Mode paramMode)
  {
    if (this.xd != null) {
      android.support.v4.graphics.drawable.a.a(this.xd, paramMode);
    }
    g localg;
    do
    {
      return;
      localg = this.xf;
    } while (localg.yf == paramMode);
    localg.yf = paramMode;
    this.xg = a(localg.ye, paramMode);
    invalidateSelf();
  }
  
  public final boolean setVisible(boolean paramBoolean1, boolean paramBoolean2)
  {
    if (this.xd != null) {
      return this.xd.setVisible(paramBoolean1, paramBoolean2);
    }
    return super.setVisible(paramBoolean1, paramBoolean2);
  }
  
  public final void unscheduleSelf(Runnable paramRunnable)
  {
    if (this.xd != null)
    {
      this.xd.unscheduleSelf(paramRunnable);
      return;
    }
    super.unscheduleSelf(paramRunnable);
  }
  
  static final class a
    extends i.e
  {
    public a() {}
    
    public a(a parama)
    {
      super();
    }
    
    final void a(TypedArray paramTypedArray)
    {
      String str = paramTypedArray.getString(0);
      if (str != null) {
        this.xM = str;
      }
      paramTypedArray = paramTypedArray.getString(1);
      if (paramTypedArray != null) {
        this.xL = c.x(paramTypedArray);
      }
    }
    
    public final boolean dx()
    {
      return true;
    }
  }
  
  static final class b
    extends i.e
  {
    float xA = 4.0F;
    private int[] xo;
    b xp;
    float xq = 0.0F;
    b xr;
    float xs = 1.0F;
    int xt = 0;
    float xu = 1.0F;
    float xv = 0.0F;
    float xw = 1.0F;
    float xx = 0.0F;
    Paint.Cap xy = Paint.Cap.BUTT;
    Paint.Join xz = Paint.Join.MITER;
    
    public b() {}
    
    public b(b paramb)
    {
      super();
      this.xo = paramb.xo;
      this.xp = paramb.xp;
      this.xq = paramb.xq;
      this.xs = paramb.xs;
      this.xr = paramb.xr;
      this.xt = paramb.xt;
      this.xu = paramb.xu;
      this.xv = paramb.xv;
      this.xw = paramb.xw;
      this.xx = paramb.xx;
      this.xy = paramb.xy;
      this.xz = paramb.xz;
      this.xA = paramb.xA;
    }
    
    final void a(TypedArray paramTypedArray, XmlPullParser paramXmlPullParser, Resources.Theme paramTheme)
    {
      this.xo = null;
      if (!g.a(paramXmlPullParser, "pathData")) {
        return;
      }
      Object localObject = paramTypedArray.getString(0);
      if (localObject != null) {
        this.xM = ((String)localObject);
      }
      localObject = paramTypedArray.getString(2);
      if (localObject != null) {
        this.xL = c.x((String)localObject);
      }
      this.xr = g.a(paramTypedArray, paramXmlPullParser, paramTheme, "fillColor", 1);
      this.xu = g.a(paramTypedArray, paramXmlPullParser, "fillAlpha", 12, this.xu);
      int i = g.a(paramTypedArray, paramXmlPullParser, "strokeLineCap", 8, -1);
      localObject = this.xy;
      switch (i)
      {
      default: 
        this.xy = ((Paint.Cap)localObject);
        i = g.a(paramTypedArray, paramXmlPullParser, "strokeLineJoin", 9, -1);
        localObject = this.xz;
        switch (i)
        {
        }
        break;
      }
      for (;;)
      {
        this.xz = ((Paint.Join)localObject);
        this.xA = g.a(paramTypedArray, paramXmlPullParser, "strokeMiterLimit", 10, this.xA);
        this.xp = g.a(paramTypedArray, paramXmlPullParser, paramTheme, "strokeColor", 3);
        this.xs = g.a(paramTypedArray, paramXmlPullParser, "strokeAlpha", 11, this.xs);
        this.xq = g.a(paramTypedArray, paramXmlPullParser, "strokeWidth", 4, this.xq);
        this.xw = g.a(paramTypedArray, paramXmlPullParser, "trimPathEnd", 6, this.xw);
        this.xx = g.a(paramTypedArray, paramXmlPullParser, "trimPathOffset", 7, this.xx);
        this.xv = g.a(paramTypedArray, paramXmlPullParser, "trimPathStart", 5, this.xv);
        this.xt = g.a(paramTypedArray, paramXmlPullParser, "fillType", 13, this.xt);
        return;
        localObject = Paint.Cap.BUTT;
        break;
        localObject = Paint.Cap.ROUND;
        break;
        localObject = Paint.Cap.SQUARE;
        break;
        localObject = Paint.Join.MITER;
        continue;
        localObject = Paint.Join.ROUND;
        continue;
        localObject = Paint.Join.BEVEL;
      }
    }
    
    public final boolean e(int[] paramArrayOfInt)
    {
      return this.xr.e(paramArrayOfInt) | this.xp.e(paramArrayOfInt);
    }
    
    final float getFillAlpha()
    {
      return this.xu;
    }
    
    final int getFillColor()
    {
      return this.xr.mColor;
    }
    
    final float getStrokeAlpha()
    {
      return this.xs;
    }
    
    final int getStrokeColor()
    {
      return this.xp.mColor;
    }
    
    final float getStrokeWidth()
    {
      return this.xq;
    }
    
    final float getTrimPathEnd()
    {
      return this.xw;
    }
    
    final float getTrimPathOffset()
    {
      return this.xx;
    }
    
    final float getTrimPathStart()
    {
      return this.xv;
    }
    
    public final boolean isStateful()
    {
      return (this.xr.isStateful()) || (this.xp.isStateful());
    }
    
    final void setFillAlpha(float paramFloat)
    {
      this.xu = paramFloat;
    }
    
    final void setFillColor(int paramInt)
    {
      this.xr.mColor = paramInt;
    }
    
    final void setStrokeAlpha(float paramFloat)
    {
      this.xs = paramFloat;
    }
    
    final void setStrokeColor(int paramInt)
    {
      this.xp.mColor = paramInt;
    }
    
    final void setStrokeWidth(float paramFloat)
    {
      this.xq = paramFloat;
    }
    
    final void setTrimPathEnd(float paramFloat)
    {
      this.xw = paramFloat;
    }
    
    final void setTrimPathOffset(float paramFloat)
    {
      this.xx = paramFloat;
    }
    
    final void setTrimPathStart(float paramFloat)
    {
      this.xv = paramFloat;
    }
  }
  
  static final class c
    extends i.d
  {
    int mChangingConfigurations;
    final ArrayList<i.d> mChildren = new ArrayList();
    final Matrix xB = new Matrix();
    float xC = 0.0F;
    float xD = 0.0F;
    float xE = 0.0F;
    float xF = 1.0F;
    float xG = 1.0F;
    float xH = 0.0F;
    float xI = 0.0F;
    final Matrix xJ = new Matrix();
    String xK = null;
    int[] xo;
    
    public c()
    {
      super();
    }
    
    public c(c paramc, android.support.v4.e.a<String, Object> parama)
    {
      super();
      this.xC = paramc.xC;
      this.xD = paramc.xD;
      this.xE = paramc.xE;
      this.xF = paramc.xF;
      this.xG = paramc.xG;
      this.xH = paramc.xH;
      this.xI = paramc.xI;
      this.xo = paramc.xo;
      this.xK = paramc.xK;
      this.mChangingConfigurations = paramc.mChangingConfigurations;
      if (this.xK != null) {
        parama.put(this.xK, this);
      }
      this.xJ.set(paramc.xJ);
      ArrayList localArrayList = paramc.mChildren;
      int i = 0;
      while (i < localArrayList.size())
      {
        paramc = localArrayList.get(i);
        if ((paramc instanceof c))
        {
          paramc = (c)paramc;
          this.mChildren.add(new c(paramc, parama));
          i += 1;
        }
        else
        {
          if ((paramc instanceof i.b)) {}
          for (paramc = new i.b((i.b)paramc);; paramc = new i.a((i.a)paramc))
          {
            this.mChildren.add(paramc);
            if (paramc.xM == null) {
              break;
            }
            parama.put(paramc.xM, paramc);
            break;
            if (!(paramc instanceof i.a)) {
              break label316;
            }
          }
          label316:
          throw new IllegalStateException("Unknown object in the tree!");
        }
      }
    }
    
    final void dy()
    {
      this.xJ.reset();
      this.xJ.postTranslate(-this.xD, -this.xE);
      this.xJ.postScale(this.xF, this.xG);
      this.xJ.postRotate(this.xC, 0.0F, 0.0F);
      this.xJ.postTranslate(this.xH + this.xD, this.xI + this.xE);
    }
    
    public final boolean e(int[] paramArrayOfInt)
    {
      int i = 0;
      boolean bool = false;
      while (i < this.mChildren.size())
      {
        bool |= ((i.d)this.mChildren.get(i)).e(paramArrayOfInt);
        i += 1;
      }
      return bool;
    }
    
    public final String getGroupName()
    {
      return this.xK;
    }
    
    public final Matrix getLocalMatrix()
    {
      return this.xJ;
    }
    
    public final float getPivotX()
    {
      return this.xD;
    }
    
    public final float getPivotY()
    {
      return this.xE;
    }
    
    public final float getRotation()
    {
      return this.xC;
    }
    
    public final float getScaleX()
    {
      return this.xF;
    }
    
    public final float getScaleY()
    {
      return this.xG;
    }
    
    public final float getTranslateX()
    {
      return this.xH;
    }
    
    public final float getTranslateY()
    {
      return this.xI;
    }
    
    public final boolean isStateful()
    {
      boolean bool2 = false;
      int i = 0;
      for (;;)
      {
        boolean bool1 = bool2;
        if (i < this.mChildren.size())
        {
          if (((i.d)this.mChildren.get(i)).isStateful()) {
            bool1 = true;
          }
        }
        else {
          return bool1;
        }
        i += 1;
      }
    }
    
    public final void setPivotX(float paramFloat)
    {
      if (paramFloat != this.xD)
      {
        this.xD = paramFloat;
        dy();
      }
    }
    
    public final void setPivotY(float paramFloat)
    {
      if (paramFloat != this.xE)
      {
        this.xE = paramFloat;
        dy();
      }
    }
    
    public final void setRotation(float paramFloat)
    {
      if (paramFloat != this.xC)
      {
        this.xC = paramFloat;
        dy();
      }
    }
    
    public final void setScaleX(float paramFloat)
    {
      if (paramFloat != this.xF)
      {
        this.xF = paramFloat;
        dy();
      }
    }
    
    public final void setScaleY(float paramFloat)
    {
      if (paramFloat != this.xG)
      {
        this.xG = paramFloat;
        dy();
      }
    }
    
    public final void setTranslateX(float paramFloat)
    {
      if (paramFloat != this.xH)
      {
        this.xH = paramFloat;
        dy();
      }
    }
    
    public final void setTranslateY(float paramFloat)
    {
      if (paramFloat != this.xI)
      {
        this.xI = paramFloat;
        dy();
      }
    }
  }
  
  static abstract class d
  {
    public boolean e(int[] paramArrayOfInt)
    {
      return false;
    }
    
    public boolean isStateful()
    {
      return false;
    }
  }
  
  static abstract class e
    extends i.d
  {
    int mChangingConfigurations;
    protected c.b[] xL = null;
    String xM;
    
    public e()
    {
      super();
    }
    
    public e(e parame)
    {
      super();
      this.xM = parame.xM;
      this.mChangingConfigurations = parame.mChangingConfigurations;
      this.xL = c.a(parame.xL);
    }
    
    public final void b(Path paramPath)
    {
      paramPath.reset();
      if (this.xL != null) {
        c.b.a(this.xL, paramPath);
      }
    }
    
    public boolean dx()
    {
      return false;
    }
    
    public c.b[] getPathData()
    {
      return this.xL;
    }
    
    public String getPathName()
    {
      return this.xM;
    }
    
    public void setPathData(c.b[] paramArrayOfb)
    {
      if (!c.a(this.xL, paramArrayOfb)) {
        this.xL = c.a(paramArrayOfb);
      }
      for (;;)
      {
        return;
        c.b[] arrayOfb = this.xL;
        int i = 0;
        while (i < paramArrayOfb.length)
        {
          arrayOfb[i].JJ = paramArrayOfb[i].JJ;
          int j = 0;
          while (j < paramArrayOfb[i].JK.length)
          {
            arrayOfb[i].JK[j] = paramArrayOfb[i].JK[j];
            j += 1;
          }
          i += 1;
        }
      }
    }
  }
  
  static final class f
  {
    private static final Matrix xP = new Matrix();
    private int mChangingConfigurations;
    private final Path xN;
    private final Path xO;
    private final Matrix xQ = new Matrix();
    Paint xR;
    Paint xS;
    private PathMeasure xT;
    final i.c xU;
    float xV = 0.0F;
    float xW = 0.0F;
    float xX = 0.0F;
    float xY = 0.0F;
    int xZ = 255;
    String ya = null;
    Boolean yb = null;
    final android.support.v4.e.a<String, Object> yc = new android.support.v4.e.a();
    
    public f()
    {
      this.xU = new i.c();
      this.xN = new Path();
      this.xO = new Path();
    }
    
    public f(f paramf)
    {
      this.xU = new i.c(paramf.xU, this.yc);
      this.xN = new Path(paramf.xN);
      this.xO = new Path(paramf.xO);
      this.xV = paramf.xV;
      this.xW = paramf.xW;
      this.xX = paramf.xX;
      this.xY = paramf.xY;
      this.mChangingConfigurations = paramf.mChangingConfigurations;
      this.xZ = paramf.xZ;
      this.ya = paramf.ya;
      if (paramf.ya != null) {
        this.yc.put(paramf.ya, this);
      }
      this.yb = paramf.yb;
    }
    
    private void a(i.c paramc, Matrix paramMatrix, Canvas paramCanvas, int paramInt1, int paramInt2, ColorFilter paramColorFilter)
    {
      paramc.xB.set(paramMatrix);
      paramc.xB.preConcat(paramc.xJ);
      paramCanvas.save();
      int i = 0;
      if (i < paramc.mChildren.size())
      {
        paramMatrix = (i.d)paramc.mChildren.get(i);
        if ((paramMatrix instanceof i.c)) {
          a((i.c)paramMatrix, paramc.xB, paramCanvas, paramInt1, paramInt2, paramColorFilter);
        }
      }
      label903:
      for (;;)
      {
        i += 1;
        break;
        if ((paramMatrix instanceof i.e))
        {
          paramMatrix = (i.e)paramMatrix;
          float f1 = paramInt1 / this.xX;
          float f3 = paramInt2 / this.xY;
          float f2 = Math.min(f1, f3);
          Object localObject1 = paramc.xB;
          this.xQ.set((Matrix)localObject1);
          this.xQ.postScale(f1, f3);
          Object localObject2 = new float[4];
          tmp163_161 = localObject2;
          tmp163_161[0] = 0.0F;
          tmp167_163 = tmp163_161;
          tmp167_163[1] = 1.0F;
          tmp171_167 = tmp167_163;
          tmp171_167[2] = 1.0F;
          tmp175_171 = tmp171_167;
          tmp175_171[3] = 0.0F;
          tmp175_171;
          ((Matrix)localObject1).mapVectors((float[])localObject2);
          float f6 = (float)Math.hypot(localObject2[0], localObject2[1]);
          float f7 = (float)Math.hypot(localObject2[2], localObject2[3]);
          f1 = localObject2[0];
          f3 = localObject2[1];
          float f4 = localObject2[2];
          float f5 = localObject2[3];
          f6 = Math.max(f6, f7);
          if (f6 > 0.0F) {}
          for (f1 = Math.abs(f5 * f1 - f3 * f4) / f6;; f1 = 0.0F)
          {
            if (f1 == 0.0F) {
              break label903;
            }
            paramMatrix.b(this.xN);
            localObject2 = this.xN;
            this.xO.reset();
            if (paramMatrix.dx())
            {
              this.xO.addPath((Path)localObject2, this.xQ);
              paramCanvas.clipPath(this.xO);
              break;
            }
            localObject1 = (i.b)paramMatrix;
            if ((((i.b)localObject1).xv != 0.0F) || (((i.b)localObject1).xw != 1.0F))
            {
              f6 = ((i.b)localObject1).xv;
              f7 = ((i.b)localObject1).xx;
              f4 = ((i.b)localObject1).xw;
              f5 = ((i.b)localObject1).xx;
              if (this.xT == null) {
                this.xT = new PathMeasure();
              }
              this.xT.setPath(this.xN, false);
              f3 = this.xT.getLength();
              f6 = (f6 + f7) % 1.0F * f3;
              f4 = (f4 + f5) % 1.0F * f3;
              ((Path)localObject2).reset();
              if (f6 > f4)
              {
                this.xT.getSegment(f6, f3, (Path)localObject2, true);
                this.xT.getSegment(0.0F, f4, (Path)localObject2, true);
                label497:
                ((Path)localObject2).rLineTo(0.0F, 0.0F);
              }
            }
            else
            {
              this.xO.addPath((Path)localObject2, this.xQ);
              if (((i.b)localObject1).xr.eu())
              {
                paramMatrix = ((i.b)localObject1).xr;
                if (this.xS == null)
                {
                  this.xS = new Paint(1);
                  this.xS.setStyle(Paint.Style.FILL);
                }
                localObject2 = this.xS;
                if (!paramMatrix.et()) {
                  break label847;
                }
                paramMatrix = paramMatrix.Jt;
                paramMatrix.setLocalMatrix(this.xQ);
                ((Paint)localObject2).setShader(paramMatrix);
                ((Paint)localObject2).setAlpha(Math.round(((i.b)localObject1).xu * 255.0F));
                label612:
                ((Paint)localObject2).setColorFilter(paramColorFilter);
                Path localPath = this.xO;
                if (((i.b)localObject1).xt != 0) {
                  break label867;
                }
                paramMatrix = Path.FillType.WINDING;
                label638:
                localPath.setFillType(paramMatrix);
                paramCanvas.drawPath(this.xO, (Paint)localObject2);
              }
              if (!((i.b)localObject1).xp.eu()) {
                break;
              }
              localObject2 = ((i.b)localObject1).xp;
              if (this.xR == null)
              {
                this.xR = new Paint(1);
                this.xR.setStyle(Paint.Style.STROKE);
              }
              paramMatrix = this.xR;
              if (((i.b)localObject1).xz != null) {
                paramMatrix.setStrokeJoin(((i.b)localObject1).xz);
              }
              if (((i.b)localObject1).xy != null) {
                paramMatrix.setStrokeCap(((i.b)localObject1).xy);
              }
              paramMatrix.setStrokeMiter(((i.b)localObject1).xA);
              if (!((b)localObject2).et()) {
                break label874;
              }
              localObject2 = ((b)localObject2).Jt;
              ((Shader)localObject2).setLocalMatrix(this.xQ);
              paramMatrix.setShader((Shader)localObject2);
              paramMatrix.setAlpha(Math.round(((i.b)localObject1).xs * 255.0F));
            }
            for (;;)
            {
              paramMatrix.setColorFilter(paramColorFilter);
              paramMatrix.setStrokeWidth(((i.b)localObject1).xq * (f2 * f1));
              paramCanvas.drawPath(this.xO, paramMatrix);
              break;
              this.xT.getSegment(f6, f4, (Path)localObject2, true);
              break label497;
              label847:
              ((Paint)localObject2).setColor(i.d(paramMatrix.mColor, ((i.b)localObject1).xu));
              break label612;
              label867:
              paramMatrix = Path.FillType.EVEN_ODD;
              break label638;
              label874:
              paramMatrix.setColor(i.d(((b)localObject2).mColor, ((i.b)localObject1).xs));
            }
            paramCanvas.restore();
            return;
          }
        }
      }
    }
    
    public final void a(Canvas paramCanvas, int paramInt1, int paramInt2)
    {
      a(this.xU, xP, paramCanvas, paramInt1, paramInt2, null);
    }
    
    public final float getAlpha()
    {
      return getRootAlpha() / 255.0F;
    }
    
    public final int getRootAlpha()
    {
      return this.xZ;
    }
    
    public final boolean isStateful()
    {
      if (this.yb == null) {
        this.yb = Boolean.valueOf(this.xU.isStateful());
      }
      return this.yb.booleanValue();
    }
    
    public final void setAlpha(float paramFloat)
    {
      setRootAlpha((int)(255.0F * paramFloat));
    }
    
    public final void setRootAlpha(int paramInt)
    {
      this.xZ = paramInt;
    }
  }
  
  static final class g
    extends Drawable.ConstantState
  {
    int mChangingConfigurations;
    i.f yd;
    ColorStateList ye = null;
    PorterDuff.Mode yf = i.xe;
    boolean yg;
    Bitmap yh;
    ColorStateList yi;
    PorterDuff.Mode yj;
    int yk;
    boolean yl;
    boolean ym;
    Paint yn;
    
    public g()
    {
      this.yd = new i.f();
    }
    
    public g(g paramg)
    {
      if (paramg != null)
      {
        this.mChangingConfigurations = paramg.mChangingConfigurations;
        this.yd = new i.f(paramg.yd);
        if (paramg.yd.xS != null) {
          this.yd.xS = new Paint(paramg.yd.xS);
        }
        if (paramg.yd.xR != null) {
          this.yd.xR = new Paint(paramg.yd.xR);
        }
        this.ye = paramg.ye;
        this.yf = paramg.yf;
        this.yg = paramg.yg;
      }
    }
    
    public final int getChangingConfigurations()
    {
      return this.mChangingConfigurations;
    }
    
    public final Drawable newDrawable()
    {
      return new i(this);
    }
    
    public final Drawable newDrawable(Resources paramResources)
    {
      return new i(this);
    }
    
    public final void s(int paramInt1, int paramInt2)
    {
      this.yh.eraseColor(0);
      Canvas localCanvas = new Canvas(this.yh);
      this.yd.a(localCanvas, paramInt1, paramInt2);
    }
  }
  
  static final class h
    extends Drawable.ConstantState
  {
    private final Drawable.ConstantState wY;
    
    public h(Drawable.ConstantState paramConstantState)
    {
      this.wY = paramConstantState;
    }
    
    public final boolean canApplyTheme()
    {
      return this.wY.canApplyTheme();
    }
    
    public final int getChangingConfigurations()
    {
      return this.wY.getChangingConfigurations();
    }
    
    public final Drawable newDrawable()
    {
      i locali = new i();
      locali.xd = ((VectorDrawable)this.wY.newDrawable());
      return locali;
    }
    
    public final Drawable newDrawable(Resources paramResources)
    {
      i locali = new i();
      locali.xd = ((VectorDrawable)this.wY.newDrawable(paramResources));
      return locali;
    }
    
    public final Drawable newDrawable(Resources paramResources, Resources.Theme paramTheme)
    {
      i locali = new i();
      locali.xd = ((VectorDrawable)this.wY.newDrawable(paramResources, paramTheme));
      return locali;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     android.support.d.a.i
 * JD-Core Version:    0.7.0.1
 */