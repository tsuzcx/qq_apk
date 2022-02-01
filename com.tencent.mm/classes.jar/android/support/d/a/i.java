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
  static final PorterDuff.Mode xl = PorterDuff.Mode.SRC_IN;
  g xm;
  private PorterDuffColorFilter xn;
  private ColorFilter xo;
  private boolean xp;
  boolean xq = true;
  private Drawable.ConstantState xr;
  private final float[] xs = new float[9];
  private final Matrix xt = new Matrix();
  private final Rect xu = new Rect();
  
  i()
  {
    this.xm = new g();
  }
  
  i(g paramg)
  {
    this.xm = paramg;
    this.xn = a(paramg.yk, paramg.yl);
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
      ((i)localObject).xk = f.c(paramResources, paramInt, paramTheme);
      ((i)localObject).xr = new h(((i)localObject).xk.getConstantState());
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
    g localg = this.xm;
    f localf = localg.yj;
    int i = 1;
    ArrayDeque localArrayDeque = new ArrayDeque();
    localArrayDeque.push(localf.ya);
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
          localTypedArray = g.a(paramResources, paramTheme, paramAttributeSet, a.wM);
          ((b)localObject).a(localTypedArray, paramXmlPullParser, paramTheme);
          localTypedArray.recycle();
          localc.mChildren.add(localObject);
          if (((b)localObject).getPathName() != null) {
            localf.yi.put(((b)localObject).getPathName(), localObject);
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
            localTypedArray = g.a(paramResources, paramTheme, paramAttributeSet, a.wN);
            ((a)localObject).a(localTypedArray);
            localTypedArray.recycle();
          }
          localc.mChildren.add(localObject);
          if (((a)localObject).getPathName() != null) {
            localf.yi.put(((a)localObject).getPathName(), localObject);
          }
          localg.mChangingConfigurations |= ((a)localObject).mChangingConfigurations;
        }
        else
        {
          if ("group".equals(localObject))
          {
            localObject = new c();
            localTypedArray = g.a(paramResources, paramTheme, paramAttributeSet, a.wL);
            ((c)localObject).xv = null;
            ((c)localObject).xI = g.a(localTypedArray, paramXmlPullParser, "rotation", 5, ((c)localObject).xI);
            ((c)localObject).xJ = localTypedArray.getFloat(1, ((c)localObject).xJ);
            ((c)localObject).xK = localTypedArray.getFloat(2, ((c)localObject).xK);
            ((c)localObject).xL = g.a(localTypedArray, paramXmlPullParser, "scaleX", 3, ((c)localObject).xL);
            ((c)localObject).xM = g.a(localTypedArray, paramXmlPullParser, "scaleY", 4, ((c)localObject).xM);
            ((c)localObject).xN = g.a(localTypedArray, paramXmlPullParser, "translateX", 6, ((c)localObject).xN);
            ((c)localObject).xO = g.a(localTypedArray, paramXmlPullParser, "translateY", 7, ((c)localObject).xO);
            String str = localTypedArray.getString(0);
            if (str != null) {
              ((c)localObject).xQ = str;
            }
            ((c)localObject).dB();
            localTypedArray.recycle();
            localc.mChildren.add(localObject);
            localArrayDeque.push(localObject);
            if (((c)localObject).getGroupName() != null) {
              localf.yi.put(((c)localObject).getGroupName(), localObject);
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
    if (this.xk != null) {
      android.support.v4.graphics.drawable.a.g(this.xk);
    }
    return false;
  }
  
  public final void draw(Canvas paramCanvas)
  {
    if (this.xk != null) {
      this.xk.draw(paramCanvas);
    }
    int i;
    int k;
    int m;
    do
    {
      do
      {
        return;
        copyBounds(this.xu);
      } while ((this.xu.width() <= 0) || (this.xu.height() <= 0));
      if (this.xo != null) {
        break;
      }
      localObject = this.xn;
      paramCanvas.getMatrix(this.xt);
      this.xt.getValues(this.xs);
      float f2 = Math.abs(this.xs[0]);
      float f1 = Math.abs(this.xs[4]);
      float f4 = Math.abs(this.xs[1]);
      float f3 = Math.abs(this.xs[3]);
      if ((f4 != 0.0F) || (f3 != 0.0F))
      {
        f1 = 1.0F;
        f2 = 1.0F;
      }
      j = (int)(f2 * this.xu.width());
      i = (int)(f1 * this.xu.height());
      k = Math.min(2048, j);
      m = Math.min(2048, i);
    } while ((k <= 0) || (m <= 0));
    int j = paramCanvas.save();
    paramCanvas.translate(this.xu.left, this.xu.top);
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
          paramCanvas.translate(this.xu.width(), 0.0F);
          paramCanvas.scale(-1.0F, 1.0F);
        }
        this.xu.offsetTo(0, 0);
        localg = this.xm;
        if (localg.yn != null)
        {
          if ((k != localg.yn.getWidth()) || (m != localg.yn.getHeight())) {
            break label450;
          }
          i = 1;
          if (i != 0) {}
        }
        else
        {
          localg.yn = Bitmap.createBitmap(k, m, Bitmap.Config.ARGB_8888);
          localg.ys = true;
        }
        if (this.xq) {
          break label456;
        }
        this.xm.s(k, m);
        localg = this.xm;
        localRect = this.xu;
        if (localg.yj.getRootAlpha() >= 255) {
          break label608;
        }
        i = 1;
        label395:
        if ((i != 0) || (localObject != null)) {
          break label614;
        }
      }
    }
    for (Object localObject = null;; localObject = localg.yt)
    {
      paramCanvas.drawBitmap(localg.yn, null, localRect, (Paint)localObject);
      paramCanvas.restoreToCount(j);
      return;
      localObject = this.xo;
      break;
      i = 0;
      break label244;
      i = 0;
      break label244;
      label450:
      i = 0;
      break label322;
      label456:
      localg = this.xm;
      if ((!localg.ys) && (localg.yo == localg.yk) && (localg.yp == localg.yl) && (localg.yr == localg.ym) && (localg.yq == localg.yj.getRootAlpha())) {}
      for (i = 1;; i = 0)
      {
        if (i != 0) {
          break label606;
        }
        this.xm.s(k, m);
        localg = this.xm;
        localg.yo = localg.yk;
        localg.yp = localg.yl;
        localg.yq = localg.yj.getRootAlpha();
        localg.yr = localg.ym;
        localg.ys = false;
        break;
      }
      label606:
      break label366;
      label608:
      i = 0;
      break label395;
      label614:
      if (localg.yt == null)
      {
        localg.yt = new Paint();
        localg.yt.setFilterBitmap(true);
      }
      localg.yt.setAlpha(localg.yj.getRootAlpha());
      localg.yt.setColorFilter((ColorFilter)localObject);
    }
  }
  
  public final int getAlpha()
  {
    if (this.xk != null) {
      return android.support.v4.graphics.drawable.a.f(this.xk);
    }
    return this.xm.yj.getRootAlpha();
  }
  
  public final int getChangingConfigurations()
  {
    if (this.xk != null) {
      return this.xk.getChangingConfigurations();
    }
    return super.getChangingConfigurations() | this.xm.getChangingConfigurations();
  }
  
  public final Drawable.ConstantState getConstantState()
  {
    if ((this.xk != null) && (Build.VERSION.SDK_INT >= 24)) {
      return new h(this.xk.getConstantState());
    }
    this.xm.mChangingConfigurations = getChangingConfigurations();
    return this.xm;
  }
  
  public final int getIntrinsicHeight()
  {
    if (this.xk != null) {
      return this.xk.getIntrinsicHeight();
    }
    return (int)this.xm.yj.yc;
  }
  
  public final int getIntrinsicWidth()
  {
    if (this.xk != null) {
      return this.xk.getIntrinsicWidth();
    }
    return (int)this.xm.yj.yb;
  }
  
  public final int getOpacity()
  {
    if (this.xk != null) {
      return this.xk.getOpacity();
    }
    return -3;
  }
  
  public final void inflate(Resources paramResources, XmlPullParser paramXmlPullParser, AttributeSet paramAttributeSet)
  {
    if (this.xk != null)
    {
      this.xk.inflate(paramResources, paramXmlPullParser, paramAttributeSet);
      return;
    }
    inflate(paramResources, paramXmlPullParser, paramAttributeSet, null);
  }
  
  public final void inflate(Resources paramResources, XmlPullParser paramXmlPullParser, AttributeSet paramAttributeSet, Resources.Theme paramTheme)
  {
    if (this.xk != null)
    {
      android.support.v4.graphics.drawable.a.a(this.xk, paramResources, paramXmlPullParser, paramAttributeSet, paramTheme);
      return;
    }
    g localg1 = this.xm;
    localg1.yj = new f();
    TypedArray localTypedArray = g.a(paramResources, paramTheme, paramAttributeSet, a.wK);
    g localg2 = this.xm;
    f localf = localg2.yj;
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
      localg2.yl = ((PorterDuff.Mode)localObject);
      localObject = localTypedArray.getColorStateList(1);
      if (localObject != null) {
        localg2.yk = ((ColorStateList)localObject);
      }
      localg2.ym = g.a(localTypedArray, paramXmlPullParser, "autoMirrored", 5, localg2.ym);
      localf.yd = g.a(localTypedArray, paramXmlPullParser, "viewportWidth", 7, localf.yd);
      localf.ye = g.a(localTypedArray, paramXmlPullParser, "viewportHeight", 8, localf.ye);
      if (localf.yd > 0.0F) {
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
    if (localf.ye <= 0.0F) {
      throw new XmlPullParserException(localTypedArray.getPositionDescription() + "<vector> tag requires viewportHeight > 0");
    }
    localf.yb = localTypedArray.getDimension(3, localf.yb);
    localf.yc = localTypedArray.getDimension(2, localf.yc);
    if (localf.yb <= 0.0F) {
      throw new XmlPullParserException(localTypedArray.getPositionDescription() + "<vector> tag requires width > 0");
    }
    if (localf.yc <= 0.0F) {
      throw new XmlPullParserException(localTypedArray.getPositionDescription() + "<vector> tag requires height > 0");
    }
    localf.setAlpha(g.a(localTypedArray, paramXmlPullParser, "alpha", 4, localf.getAlpha()));
    localObject = localTypedArray.getString(0);
    if (localObject != null)
    {
      localf.yg = ((String)localObject);
      localf.yi.put(localObject, localf);
    }
    localTypedArray.recycle();
    localg1.mChangingConfigurations = getChangingConfigurations();
    localg1.ys = true;
    b(paramResources, paramXmlPullParser, paramAttributeSet, paramTheme);
    this.xn = a(localg1.yk, localg1.yl);
  }
  
  public final void invalidateSelf()
  {
    if (this.xk != null)
    {
      this.xk.invalidateSelf();
      return;
    }
    super.invalidateSelf();
  }
  
  public final boolean isAutoMirrored()
  {
    if (this.xk != null) {
      return android.support.v4.graphics.drawable.a.e(this.xk);
    }
    return this.xm.ym;
  }
  
  public final boolean isStateful()
  {
    if (this.xk != null) {
      return this.xk.isStateful();
    }
    return (super.isStateful()) || ((this.xm != null) && ((this.xm.yj.isStateful()) || ((this.xm.yk != null) && (this.xm.yk.isStateful()))));
  }
  
  public final Drawable mutate()
  {
    if (this.xk != null) {
      this.xk.mutate();
    }
    while ((this.xp) || (super.mutate() != this)) {
      return this;
    }
    this.xm = new g(this.xm);
    this.xp = true;
    return this;
  }
  
  protected final void onBoundsChange(Rect paramRect)
  {
    if (this.xk != null) {
      this.xk.setBounds(paramRect);
    }
  }
  
  protected final boolean onStateChange(int[] paramArrayOfInt)
  {
    boolean bool2;
    if (this.xk != null) {
      bool2 = this.xk.setState(paramArrayOfInt);
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
        localg = this.xm;
        bool1 = bool2;
        if (localg.yk != null)
        {
          bool1 = bool2;
          if (localg.yl != null)
          {
            this.xn = a(localg.yk, localg.yl);
            invalidateSelf();
            bool1 = true;
          }
        }
        bool2 = bool1;
      } while (!localg.yj.isStateful());
      bool3 = localg.yj.ya.e(paramArrayOfInt);
      localg.ys |= bool3;
      bool2 = bool1;
    } while (!bool3);
    invalidateSelf();
    return true;
  }
  
  public final void scheduleSelf(Runnable paramRunnable, long paramLong)
  {
    if (this.xk != null)
    {
      this.xk.scheduleSelf(paramRunnable, paramLong);
      return;
    }
    super.scheduleSelf(paramRunnable, paramLong);
  }
  
  public final void setAlpha(int paramInt)
  {
    if (this.xk != null) {
      this.xk.setAlpha(paramInt);
    }
    while (this.xm.yj.getRootAlpha() == paramInt) {
      return;
    }
    this.xm.yj.setRootAlpha(paramInt);
    invalidateSelf();
  }
  
  public final void setAutoMirrored(boolean paramBoolean)
  {
    if (this.xk != null)
    {
      android.support.v4.graphics.drawable.a.a(this.xk, paramBoolean);
      return;
    }
    this.xm.ym = paramBoolean;
  }
  
  public final void setColorFilter(ColorFilter paramColorFilter)
  {
    if (this.xk != null)
    {
      this.xk.setColorFilter(paramColorFilter);
      return;
    }
    this.xo = paramColorFilter;
    invalidateSelf();
  }
  
  public final void setTint(int paramInt)
  {
    if (this.xk != null)
    {
      android.support.v4.graphics.drawable.a.a(this.xk, paramInt);
      return;
    }
    setTintList(ColorStateList.valueOf(paramInt));
  }
  
  public final void setTintList(ColorStateList paramColorStateList)
  {
    if (this.xk != null) {
      android.support.v4.graphics.drawable.a.a(this.xk, paramColorStateList);
    }
    g localg;
    do
    {
      return;
      localg = this.xm;
    } while (localg.yk == paramColorStateList);
    localg.yk = paramColorStateList;
    this.xn = a(paramColorStateList, localg.yl);
    invalidateSelf();
  }
  
  public final void setTintMode(PorterDuff.Mode paramMode)
  {
    if (this.xk != null) {
      android.support.v4.graphics.drawable.a.a(this.xk, paramMode);
    }
    g localg;
    do
    {
      return;
      localg = this.xm;
    } while (localg.yl == paramMode);
    localg.yl = paramMode;
    this.xn = a(localg.yk, paramMode);
    invalidateSelf();
  }
  
  public final boolean setVisible(boolean paramBoolean1, boolean paramBoolean2)
  {
    if (this.xk != null) {
      return this.xk.setVisible(paramBoolean1, paramBoolean2);
    }
    return super.setVisible(paramBoolean1, paramBoolean2);
  }
  
  public final void unscheduleSelf(Runnable paramRunnable)
  {
    if (this.xk != null)
    {
      this.xk.unscheduleSelf(paramRunnable);
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
        this.xS = str;
      }
      paramTypedArray = paramTypedArray.getString(1);
      if (paramTypedArray != null) {
        this.xR = c.y(paramTypedArray);
      }
    }
    
    public final boolean dA()
    {
      return true;
    }
  }
  
  static final class b
    extends i.e
  {
    float mStrokeWidth = 0.0F;
    float xA = 1.0F;
    float xB = 0.0F;
    float xC = 1.0F;
    float xD = 0.0F;
    Paint.Cap xE = Paint.Cap.BUTT;
    Paint.Join xF = Paint.Join.MITER;
    float xG = 4.0F;
    private int[] xv;
    b xw;
    b xx;
    float xy = 1.0F;
    int xz = 0;
    
    public b() {}
    
    public b(b paramb)
    {
      super();
      this.xv = paramb.xv;
      this.xw = paramb.xw;
      this.mStrokeWidth = paramb.mStrokeWidth;
      this.xy = paramb.xy;
      this.xx = paramb.xx;
      this.xz = paramb.xz;
      this.xA = paramb.xA;
      this.xB = paramb.xB;
      this.xC = paramb.xC;
      this.xD = paramb.xD;
      this.xE = paramb.xE;
      this.xF = paramb.xF;
      this.xG = paramb.xG;
    }
    
    final void a(TypedArray paramTypedArray, XmlPullParser paramXmlPullParser, Resources.Theme paramTheme)
    {
      this.xv = null;
      if (!g.a(paramXmlPullParser, "pathData")) {
        return;
      }
      Object localObject = paramTypedArray.getString(0);
      if (localObject != null) {
        this.xS = ((String)localObject);
      }
      localObject = paramTypedArray.getString(2);
      if (localObject != null) {
        this.xR = c.y((String)localObject);
      }
      this.xx = g.a(paramTypedArray, paramXmlPullParser, paramTheme, "fillColor", 1);
      this.xA = g.a(paramTypedArray, paramXmlPullParser, "fillAlpha", 12, this.xA);
      int i = g.a(paramTypedArray, paramXmlPullParser, "strokeLineCap", 8, -1);
      localObject = this.xE;
      switch (i)
      {
      default: 
        this.xE = ((Paint.Cap)localObject);
        i = g.a(paramTypedArray, paramXmlPullParser, "strokeLineJoin", 9, -1);
        localObject = this.xF;
        switch (i)
        {
        }
        break;
      }
      for (;;)
      {
        this.xF = ((Paint.Join)localObject);
        this.xG = g.a(paramTypedArray, paramXmlPullParser, "strokeMiterLimit", 10, this.xG);
        this.xw = g.a(paramTypedArray, paramXmlPullParser, paramTheme, "strokeColor", 3);
        this.xy = g.a(paramTypedArray, paramXmlPullParser, "strokeAlpha", 11, this.xy);
        this.mStrokeWidth = g.a(paramTypedArray, paramXmlPullParser, "strokeWidth", 4, this.mStrokeWidth);
        this.xC = g.a(paramTypedArray, paramXmlPullParser, "trimPathEnd", 6, this.xC);
        this.xD = g.a(paramTypedArray, paramXmlPullParser, "trimPathOffset", 7, this.xD);
        this.xB = g.a(paramTypedArray, paramXmlPullParser, "trimPathStart", 5, this.xB);
        this.xz = g.a(paramTypedArray, paramXmlPullParser, "fillType", 13, this.xz);
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
      return this.xx.e(paramArrayOfInt) | this.xw.e(paramArrayOfInt);
    }
    
    final float getFillAlpha()
    {
      return this.xA;
    }
    
    final int getFillColor()
    {
      return this.xx.mColor;
    }
    
    final float getStrokeAlpha()
    {
      return this.xy;
    }
    
    final int getStrokeColor()
    {
      return this.xw.mColor;
    }
    
    final float getStrokeWidth()
    {
      return this.mStrokeWidth;
    }
    
    final float getTrimPathEnd()
    {
      return this.xC;
    }
    
    final float getTrimPathOffset()
    {
      return this.xD;
    }
    
    final float getTrimPathStart()
    {
      return this.xB;
    }
    
    public final boolean isStateful()
    {
      return (this.xx.isStateful()) || (this.xw.isStateful());
    }
    
    final void setFillAlpha(float paramFloat)
    {
      this.xA = paramFloat;
    }
    
    final void setFillColor(int paramInt)
    {
      this.xx.mColor = paramInt;
    }
    
    final void setStrokeAlpha(float paramFloat)
    {
      this.xy = paramFloat;
    }
    
    final void setStrokeColor(int paramInt)
    {
      this.xw.mColor = paramInt;
    }
    
    final void setStrokeWidth(float paramFloat)
    {
      this.mStrokeWidth = paramFloat;
    }
    
    final void setTrimPathEnd(float paramFloat)
    {
      this.xC = paramFloat;
    }
    
    final void setTrimPathOffset(float paramFloat)
    {
      this.xD = paramFloat;
    }
    
    final void setTrimPathStart(float paramFloat)
    {
      this.xB = paramFloat;
    }
  }
  
  static final class c
    extends i.d
  {
    int mChangingConfigurations;
    final ArrayList<i.d> mChildren = new ArrayList();
    final Matrix xH = new Matrix();
    float xI = 0.0F;
    float xJ = 0.0F;
    float xK = 0.0F;
    float xL = 1.0F;
    float xM = 1.0F;
    float xN = 0.0F;
    float xO = 0.0F;
    final Matrix xP = new Matrix();
    String xQ = null;
    int[] xv;
    
    public c()
    {
      super();
    }
    
    public c(c paramc, android.support.v4.e.a<String, Object> parama)
    {
      super();
      this.xI = paramc.xI;
      this.xJ = paramc.xJ;
      this.xK = paramc.xK;
      this.xL = paramc.xL;
      this.xM = paramc.xM;
      this.xN = paramc.xN;
      this.xO = paramc.xO;
      this.xv = paramc.xv;
      this.xQ = paramc.xQ;
      this.mChangingConfigurations = paramc.mChangingConfigurations;
      if (this.xQ != null) {
        parama.put(this.xQ, this);
      }
      this.xP.set(paramc.xP);
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
            if (paramc.xS == null) {
              break;
            }
            parama.put(paramc.xS, paramc);
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
    
    final void dB()
    {
      this.xP.reset();
      this.xP.postTranslate(-this.xJ, -this.xK);
      this.xP.postScale(this.xL, this.xM);
      this.xP.postRotate(this.xI, 0.0F, 0.0F);
      this.xP.postTranslate(this.xN + this.xJ, this.xO + this.xK);
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
      return this.xQ;
    }
    
    public final Matrix getLocalMatrix()
    {
      return this.xP;
    }
    
    public final float getPivotX()
    {
      return this.xJ;
    }
    
    public final float getPivotY()
    {
      return this.xK;
    }
    
    public final float getRotation()
    {
      return this.xI;
    }
    
    public final float getScaleX()
    {
      return this.xL;
    }
    
    public final float getScaleY()
    {
      return this.xM;
    }
    
    public final float getTranslateX()
    {
      return this.xN;
    }
    
    public final float getTranslateY()
    {
      return this.xO;
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
      if (paramFloat != this.xJ)
      {
        this.xJ = paramFloat;
        dB();
      }
    }
    
    public final void setPivotY(float paramFloat)
    {
      if (paramFloat != this.xK)
      {
        this.xK = paramFloat;
        dB();
      }
    }
    
    public final void setRotation(float paramFloat)
    {
      if (paramFloat != this.xI)
      {
        this.xI = paramFloat;
        dB();
      }
    }
    
    public final void setScaleX(float paramFloat)
    {
      if (paramFloat != this.xL)
      {
        this.xL = paramFloat;
        dB();
      }
    }
    
    public final void setScaleY(float paramFloat)
    {
      if (paramFloat != this.xM)
      {
        this.xM = paramFloat;
        dB();
      }
    }
    
    public final void setTranslateX(float paramFloat)
    {
      if (paramFloat != this.xN)
      {
        this.xN = paramFloat;
        dB();
      }
    }
    
    public final void setTranslateY(float paramFloat)
    {
      if (paramFloat != this.xO)
      {
        this.xO = paramFloat;
        dB();
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
    protected c.b[] xR = null;
    String xS;
    
    public e()
    {
      super();
    }
    
    public e(e parame)
    {
      super();
      this.xS = parame.xS;
      this.mChangingConfigurations = parame.mChangingConfigurations;
      this.xR = c.a(parame.xR);
    }
    
    public final void b(Path paramPath)
    {
      paramPath.reset();
      if (this.xR != null) {
        c.b.a(this.xR, paramPath);
      }
    }
    
    public boolean dA()
    {
      return false;
    }
    
    public c.b[] getPathData()
    {
      return this.xR;
    }
    
    public String getPathName()
    {
      return this.xS;
    }
    
    public void setPathData(c.b[] paramArrayOfb)
    {
      if (!c.a(this.xR, paramArrayOfb)) {
        this.xR = c.a(paramArrayOfb);
      }
      for (;;)
      {
        return;
        c.b[] arrayOfb = this.xR;
        int i = 0;
        while (i < paramArrayOfb.length)
        {
          arrayOfb[i].JT = paramArrayOfb[i].JT;
          int j = 0;
          while (j < paramArrayOfb[i].JU.length)
          {
            arrayOfb[i].JU[j] = paramArrayOfb[i].JU[j];
            j += 1;
          }
          i += 1;
        }
      }
    }
  }
  
  static final class f
  {
    private static final Matrix xV = new Matrix();
    private int mChangingConfigurations;
    private final Path xT;
    private final Path xU;
    private final Matrix xW = new Matrix();
    Paint xX;
    Paint xY;
    private PathMeasure xZ;
    final i.c ya;
    float yb = 0.0F;
    float yc = 0.0F;
    float yd = 0.0F;
    float ye = 0.0F;
    int yf = 255;
    String yg = null;
    Boolean yh = null;
    final android.support.v4.e.a<String, Object> yi = new android.support.v4.e.a();
    
    public f()
    {
      this.ya = new i.c();
      this.xT = new Path();
      this.xU = new Path();
    }
    
    public f(f paramf)
    {
      this.ya = new i.c(paramf.ya, this.yi);
      this.xT = new Path(paramf.xT);
      this.xU = new Path(paramf.xU);
      this.yb = paramf.yb;
      this.yc = paramf.yc;
      this.yd = paramf.yd;
      this.ye = paramf.ye;
      this.mChangingConfigurations = paramf.mChangingConfigurations;
      this.yf = paramf.yf;
      this.yg = paramf.yg;
      if (paramf.yg != null) {
        this.yi.put(paramf.yg, this);
      }
      this.yh = paramf.yh;
    }
    
    private void a(i.c paramc, Matrix paramMatrix, Canvas paramCanvas, int paramInt1, int paramInt2, ColorFilter paramColorFilter)
    {
      paramc.xH.set(paramMatrix);
      paramc.xH.preConcat(paramc.xP);
      paramCanvas.save();
      int i = 0;
      if (i < paramc.mChildren.size())
      {
        paramMatrix = (i.d)paramc.mChildren.get(i);
        if ((paramMatrix instanceof i.c)) {
          a((i.c)paramMatrix, paramc.xH, paramCanvas, paramInt1, paramInt2, paramColorFilter);
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
          float f1 = paramInt1 / this.yd;
          float f3 = paramInt2 / this.ye;
          float f2 = Math.min(f1, f3);
          Object localObject1 = paramc.xH;
          this.xW.set((Matrix)localObject1);
          this.xW.postScale(f1, f3);
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
            paramMatrix.b(this.xT);
            localObject2 = this.xT;
            this.xU.reset();
            if (paramMatrix.dA())
            {
              this.xU.addPath((Path)localObject2, this.xW);
              paramCanvas.clipPath(this.xU);
              break;
            }
            localObject1 = (i.b)paramMatrix;
            if ((((i.b)localObject1).xB != 0.0F) || (((i.b)localObject1).xC != 1.0F))
            {
              f6 = ((i.b)localObject1).xB;
              f7 = ((i.b)localObject1).xD;
              f4 = ((i.b)localObject1).xC;
              f5 = ((i.b)localObject1).xD;
              if (this.xZ == null) {
                this.xZ = new PathMeasure();
              }
              this.xZ.setPath(this.xT, false);
              f3 = this.xZ.getLength();
              f6 = (f6 + f7) % 1.0F * f3;
              f4 = (f4 + f5) % 1.0F * f3;
              ((Path)localObject2).reset();
              if (f6 > f4)
              {
                this.xZ.getSegment(f6, f3, (Path)localObject2, true);
                this.xZ.getSegment(0.0F, f4, (Path)localObject2, true);
                label497:
                ((Path)localObject2).rLineTo(0.0F, 0.0F);
              }
            }
            else
            {
              this.xU.addPath((Path)localObject2, this.xW);
              if (((i.b)localObject1).xx.ey())
              {
                paramMatrix = ((i.b)localObject1).xx;
                if (this.xY == null)
                {
                  this.xY = new Paint(1);
                  this.xY.setStyle(Paint.Style.FILL);
                }
                localObject2 = this.xY;
                if (!paramMatrix.ex()) {
                  break label847;
                }
                paramMatrix = paramMatrix.JC;
                paramMatrix.setLocalMatrix(this.xW);
                ((Paint)localObject2).setShader(paramMatrix);
                ((Paint)localObject2).setAlpha(Math.round(((i.b)localObject1).xA * 255.0F));
                label612:
                ((Paint)localObject2).setColorFilter(paramColorFilter);
                Path localPath = this.xU;
                if (((i.b)localObject1).xz != 0) {
                  break label867;
                }
                paramMatrix = Path.FillType.WINDING;
                label638:
                localPath.setFillType(paramMatrix);
                paramCanvas.drawPath(this.xU, (Paint)localObject2);
              }
              if (!((i.b)localObject1).xw.ey()) {
                break;
              }
              localObject2 = ((i.b)localObject1).xw;
              if (this.xX == null)
              {
                this.xX = new Paint(1);
                this.xX.setStyle(Paint.Style.STROKE);
              }
              paramMatrix = this.xX;
              if (((i.b)localObject1).xF != null) {
                paramMatrix.setStrokeJoin(((i.b)localObject1).xF);
              }
              if (((i.b)localObject1).xE != null) {
                paramMatrix.setStrokeCap(((i.b)localObject1).xE);
              }
              paramMatrix.setStrokeMiter(((i.b)localObject1).xG);
              if (!((b)localObject2).ex()) {
                break label874;
              }
              localObject2 = ((b)localObject2).JC;
              ((Shader)localObject2).setLocalMatrix(this.xW);
              paramMatrix.setShader((Shader)localObject2);
              paramMatrix.setAlpha(Math.round(((i.b)localObject1).xy * 255.0F));
            }
            for (;;)
            {
              paramMatrix.setColorFilter(paramColorFilter);
              paramMatrix.setStrokeWidth(((i.b)localObject1).mStrokeWidth * (f2 * f1));
              paramCanvas.drawPath(this.xU, paramMatrix);
              break;
              this.xZ.getSegment(f6, f4, (Path)localObject2, true);
              break label497;
              label847:
              ((Paint)localObject2).setColor(i.d(paramMatrix.mColor, ((i.b)localObject1).xA));
              break label612;
              label867:
              paramMatrix = Path.FillType.EVEN_ODD;
              break label638;
              label874:
              paramMatrix.setColor(i.d(((b)localObject2).mColor, ((i.b)localObject1).xy));
            }
            paramCanvas.restore();
            return;
          }
        }
      }
    }
    
    public final void a(Canvas paramCanvas, int paramInt1, int paramInt2)
    {
      a(this.ya, xV, paramCanvas, paramInt1, paramInt2, null);
    }
    
    public final float getAlpha()
    {
      return getRootAlpha() / 255.0F;
    }
    
    public final int getRootAlpha()
    {
      return this.yf;
    }
    
    public final boolean isStateful()
    {
      if (this.yh == null) {
        this.yh = Boolean.valueOf(this.ya.isStateful());
      }
      return this.yh.booleanValue();
    }
    
    public final void setAlpha(float paramFloat)
    {
      setRootAlpha((int)(255.0F * paramFloat));
    }
    
    public final void setRootAlpha(int paramInt)
    {
      this.yf = paramInt;
    }
  }
  
  static final class g
    extends Drawable.ConstantState
  {
    int mChangingConfigurations;
    i.f yj;
    ColorStateList yk = null;
    PorterDuff.Mode yl = i.xl;
    boolean ym;
    Bitmap yn;
    ColorStateList yo;
    PorterDuff.Mode yp;
    int yq;
    boolean yr;
    boolean ys;
    Paint yt;
    
    public g()
    {
      this.yj = new i.f();
    }
    
    public g(g paramg)
    {
      if (paramg != null)
      {
        this.mChangingConfigurations = paramg.mChangingConfigurations;
        this.yj = new i.f(paramg.yj);
        if (paramg.yj.xY != null) {
          this.yj.xY = new Paint(paramg.yj.xY);
        }
        if (paramg.yj.xX != null) {
          this.yj.xX = new Paint(paramg.yj.xX);
        }
        this.yk = paramg.yk;
        this.yl = paramg.yl;
        this.ym = paramg.ym;
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
      this.yn.eraseColor(0);
      Canvas localCanvas = new Canvas(this.yn);
      this.yj.a(localCanvas, paramInt1, paramInt2);
    }
  }
  
  static final class h
    extends Drawable.ConstantState
  {
    private final Drawable.ConstantState xf;
    
    public h(Drawable.ConstantState paramConstantState)
    {
      this.xf = paramConstantState;
    }
    
    public final boolean canApplyTheme()
    {
      return this.xf.canApplyTheme();
    }
    
    public final int getChangingConfigurations()
    {
      return this.xf.getChangingConfigurations();
    }
    
    public final Drawable newDrawable()
    {
      i locali = new i();
      locali.xk = ((VectorDrawable)this.xf.newDrawable());
      return locali;
    }
    
    public final Drawable newDrawable(Resources paramResources)
    {
      i locali = new i();
      locali.xk = ((VectorDrawable)this.xf.newDrawable(paramResources));
      return locali;
    }
    
    public final Drawable newDrawable(Resources paramResources, Resources.Theme paramTheme)
    {
      i locali = new i();
      locali.xk = ((VectorDrawable)this.xf.newDrawable(paramResources, paramTheme));
      return locali;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     android.support.d.a.i
 * JD-Core Version:    0.7.0.1
 */