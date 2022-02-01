package android.support.c.a;

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
  static final PorterDuff.Mode um = PorterDuff.Mode.SRC_IN;
  g un;
  private PorterDuffColorFilter uo;
  private ColorFilter up;
  private boolean uq;
  boolean ur = true;
  private Drawable.ConstantState ut;
  private final float[] uu = new float[9];
  private final Matrix uv = new Matrix();
  private final Rect uw = new Rect();
  
  i()
  {
    this.un = new g();
  }
  
  i(g paramg)
  {
    this.un = paramg;
    this.uo = a(paramg.vn, paramg.vo);
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
      ((i)localObject).ul = f.c(paramResources, paramInt, paramTheme);
      ((i)localObject).ut = new h(((i)localObject).ul.getConstantState());
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
    g localg = this.un;
    f localf = localg.vm;
    int i = 1;
    ArrayDeque localArrayDeque = new ArrayDeque();
    localArrayDeque.push(localf.vd);
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
          localTypedArray = g.a(paramResources, paramTheme, paramAttributeSet, a.tL);
          ((b)localObject).a(localTypedArray, paramXmlPullParser, paramTheme);
          localTypedArray.recycle();
          localc.mChildren.add(localObject);
          if (((b)localObject).getPathName() != null) {
            localf.vl.put(((b)localObject).getPathName(), localObject);
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
            localTypedArray = g.a(paramResources, paramTheme, paramAttributeSet, a.tM);
            ((a)localObject).a(localTypedArray);
            localTypedArray.recycle();
          }
          localc.mChildren.add(localObject);
          if (((a)localObject).getPathName() != null) {
            localf.vl.put(((a)localObject).getPathName(), localObject);
          }
          localg.mChangingConfigurations |= ((a)localObject).mChangingConfigurations;
        }
        else
        {
          if ("group".equals(localObject))
          {
            localObject = new c();
            localTypedArray = g.a(paramResources, paramTheme, paramAttributeSet, a.tK);
            ((c)localObject).ux = null;
            ((c)localObject).uL = g.a(localTypedArray, paramXmlPullParser, "rotation", 5, ((c)localObject).uL);
            ((c)localObject).uM = localTypedArray.getFloat(1, ((c)localObject).uM);
            ((c)localObject).uN = localTypedArray.getFloat(2, ((c)localObject).uN);
            ((c)localObject).uO = g.a(localTypedArray, paramXmlPullParser, "scaleX", 3, ((c)localObject).uO);
            ((c)localObject).uP = g.a(localTypedArray, paramXmlPullParser, "scaleY", 4, ((c)localObject).uP);
            ((c)localObject).uQ = g.a(localTypedArray, paramXmlPullParser, "translateX", 6, ((c)localObject).uQ);
            ((c)localObject).uR = g.a(localTypedArray, paramXmlPullParser, "translateY", 7, ((c)localObject).uR);
            String str = localTypedArray.getString(0);
            if (str != null) {
              ((c)localObject).uT = str;
            }
            ((c)localObject).dc();
            localTypedArray.recycle();
            localc.mChildren.add(localObject);
            localArrayDeque.push(localObject);
            if (((c)localObject).getGroupName() != null) {
              localf.vl.put(((c)localObject).getGroupName(), localObject);
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
    if (this.ul != null) {
      android.support.v4.graphics.drawable.a.g(this.ul);
    }
    return false;
  }
  
  public final void draw(Canvas paramCanvas)
  {
    if (this.ul != null) {
      this.ul.draw(paramCanvas);
    }
    int i;
    int k;
    int m;
    do
    {
      do
      {
        return;
        copyBounds(this.uw);
      } while ((this.uw.width() <= 0) || (this.uw.height() <= 0));
      if (this.up != null) {
        break;
      }
      localObject = this.uo;
      paramCanvas.getMatrix(this.uv);
      this.uv.getValues(this.uu);
      float f2 = Math.abs(this.uu[0]);
      float f1 = Math.abs(this.uu[4]);
      float f4 = Math.abs(this.uu[1]);
      float f3 = Math.abs(this.uu[3]);
      if ((f4 != 0.0F) || (f3 != 0.0F))
      {
        f1 = 1.0F;
        f2 = 1.0F;
      }
      j = (int)(f2 * this.uw.width());
      i = (int)(f1 * this.uw.height());
      k = Math.min(2048, j);
      m = Math.min(2048, i);
    } while ((k <= 0) || (m <= 0));
    int j = paramCanvas.save();
    paramCanvas.translate(this.uw.left, this.uw.top);
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
          paramCanvas.translate(this.uw.width(), 0.0F);
          paramCanvas.scale(-1.0F, 1.0F);
        }
        this.uw.offsetTo(0, 0);
        localg = this.un;
        if (localg.vq != null)
        {
          if ((k != localg.vq.getWidth()) || (m != localg.vq.getHeight())) {
            break label450;
          }
          i = 1;
          if (i != 0) {}
        }
        else
        {
          localg.vq = Bitmap.createBitmap(k, m, Bitmap.Config.ARGB_8888);
          localg.vv = true;
        }
        if (this.ur) {
          break label456;
        }
        this.un.l(k, m);
        localg = this.un;
        localRect = this.uw;
        if (localg.vm.getRootAlpha() >= 255) {
          break label608;
        }
        i = 1;
        label395:
        if ((i != 0) || (localObject != null)) {
          break label614;
        }
      }
    }
    for (Object localObject = null;; localObject = localg.vw)
    {
      paramCanvas.drawBitmap(localg.vq, null, localRect, (Paint)localObject);
      paramCanvas.restoreToCount(j);
      return;
      localObject = this.up;
      break;
      i = 0;
      break label244;
      i = 0;
      break label244;
      label450:
      i = 0;
      break label322;
      label456:
      localg = this.un;
      if ((!localg.vv) && (localg.vr == localg.vn) && (localg.vs == localg.vo) && (localg.vu == localg.vp) && (localg.vt == localg.vm.getRootAlpha())) {}
      for (i = 1;; i = 0)
      {
        if (i != 0) {
          break label606;
        }
        this.un.l(k, m);
        localg = this.un;
        localg.vr = localg.vn;
        localg.vs = localg.vo;
        localg.vt = localg.vm.getRootAlpha();
        localg.vu = localg.vp;
        localg.vv = false;
        break;
      }
      label606:
      break label366;
      label608:
      i = 0;
      break label395;
      label614:
      if (localg.vw == null)
      {
        localg.vw = new Paint();
        localg.vw.setFilterBitmap(true);
      }
      localg.vw.setAlpha(localg.vm.getRootAlpha());
      localg.vw.setColorFilter((ColorFilter)localObject);
    }
  }
  
  public final int getAlpha()
  {
    if (this.ul != null) {
      return android.support.v4.graphics.drawable.a.f(this.ul);
    }
    return this.un.vm.getRootAlpha();
  }
  
  public final int getChangingConfigurations()
  {
    if (this.ul != null) {
      return this.ul.getChangingConfigurations();
    }
    return super.getChangingConfigurations() | this.un.getChangingConfigurations();
  }
  
  public final Drawable.ConstantState getConstantState()
  {
    if ((this.ul != null) && (Build.VERSION.SDK_INT >= 24)) {
      return new h(this.ul.getConstantState());
    }
    this.un.mChangingConfigurations = getChangingConfigurations();
    return this.un;
  }
  
  public final int getIntrinsicHeight()
  {
    if (this.ul != null) {
      return this.ul.getIntrinsicHeight();
    }
    return (int)this.un.vm.vf;
  }
  
  public final int getIntrinsicWidth()
  {
    if (this.ul != null) {
      return this.ul.getIntrinsicWidth();
    }
    return (int)this.un.vm.ve;
  }
  
  public final int getOpacity()
  {
    if (this.ul != null) {
      return this.ul.getOpacity();
    }
    return -3;
  }
  
  public final void inflate(Resources paramResources, XmlPullParser paramXmlPullParser, AttributeSet paramAttributeSet)
  {
    if (this.ul != null)
    {
      this.ul.inflate(paramResources, paramXmlPullParser, paramAttributeSet);
      return;
    }
    inflate(paramResources, paramXmlPullParser, paramAttributeSet, null);
  }
  
  public final void inflate(Resources paramResources, XmlPullParser paramXmlPullParser, AttributeSet paramAttributeSet, Resources.Theme paramTheme)
  {
    if (this.ul != null)
    {
      android.support.v4.graphics.drawable.a.a(this.ul, paramResources, paramXmlPullParser, paramAttributeSet, paramTheme);
      return;
    }
    g localg1 = this.un;
    localg1.vm = new f();
    TypedArray localTypedArray = g.a(paramResources, paramTheme, paramAttributeSet, a.tJ);
    g localg2 = this.un;
    f localf = localg2.vm;
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
      localg2.vo = ((PorterDuff.Mode)localObject);
      localObject = localTypedArray.getColorStateList(1);
      if (localObject != null) {
        localg2.vn = ((ColorStateList)localObject);
      }
      localg2.vp = g.a(localTypedArray, paramXmlPullParser, "autoMirrored", 5, localg2.vp);
      localf.vg = g.a(localTypedArray, paramXmlPullParser, "viewportWidth", 7, localf.vg);
      localf.vh = g.a(localTypedArray, paramXmlPullParser, "viewportHeight", 8, localf.vh);
      if (localf.vg > 0.0F) {
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
    if (localf.vh <= 0.0F) {
      throw new XmlPullParserException(localTypedArray.getPositionDescription() + "<vector> tag requires viewportHeight > 0");
    }
    localf.ve = localTypedArray.getDimension(3, localf.ve);
    localf.vf = localTypedArray.getDimension(2, localf.vf);
    if (localf.ve <= 0.0F) {
      throw new XmlPullParserException(localTypedArray.getPositionDescription() + "<vector> tag requires width > 0");
    }
    if (localf.vf <= 0.0F) {
      throw new XmlPullParserException(localTypedArray.getPositionDescription() + "<vector> tag requires height > 0");
    }
    localf.setAlpha(g.a(localTypedArray, paramXmlPullParser, "alpha", 4, localf.getAlpha()));
    localObject = localTypedArray.getString(0);
    if (localObject != null)
    {
      localf.vj = ((String)localObject);
      localf.vl.put(localObject, localf);
    }
    localTypedArray.recycle();
    localg1.mChangingConfigurations = getChangingConfigurations();
    localg1.vv = true;
    b(paramResources, paramXmlPullParser, paramAttributeSet, paramTheme);
    this.uo = a(localg1.vn, localg1.vo);
  }
  
  public final void invalidateSelf()
  {
    if (this.ul != null)
    {
      this.ul.invalidateSelf();
      return;
    }
    super.invalidateSelf();
  }
  
  public final boolean isAutoMirrored()
  {
    if (this.ul != null) {
      return android.support.v4.graphics.drawable.a.e(this.ul);
    }
    return this.un.vp;
  }
  
  public final boolean isStateful()
  {
    if (this.ul != null) {
      return this.ul.isStateful();
    }
    return (super.isStateful()) || ((this.un != null) && ((this.un.vm.isStateful()) || ((this.un.vn != null) && (this.un.vn.isStateful()))));
  }
  
  public final Drawable mutate()
  {
    if (this.ul != null) {
      this.ul.mutate();
    }
    while ((this.uq) || (super.mutate() != this)) {
      return this;
    }
    this.un = new g(this.un);
    this.uq = true;
    return this;
  }
  
  protected final void onBoundsChange(Rect paramRect)
  {
    if (this.ul != null) {
      this.ul.setBounds(paramRect);
    }
  }
  
  protected final boolean onStateChange(int[] paramArrayOfInt)
  {
    boolean bool2;
    if (this.ul != null) {
      bool2 = this.ul.setState(paramArrayOfInt);
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
        localg = this.un;
        bool1 = bool2;
        if (localg.vn != null)
        {
          bool1 = bool2;
          if (localg.vo != null)
          {
            this.uo = a(localg.vn, localg.vo);
            invalidateSelf();
            bool1 = true;
          }
        }
        bool2 = bool1;
      } while (!localg.vm.isStateful());
      bool3 = localg.vm.vd.e(paramArrayOfInt);
      localg.vv |= bool3;
      bool2 = bool1;
    } while (!bool3);
    invalidateSelf();
    return true;
  }
  
  public final void scheduleSelf(Runnable paramRunnable, long paramLong)
  {
    if (this.ul != null)
    {
      this.ul.scheduleSelf(paramRunnable, paramLong);
      return;
    }
    super.scheduleSelf(paramRunnable, paramLong);
  }
  
  public final void setAlpha(int paramInt)
  {
    if (this.ul != null) {
      this.ul.setAlpha(paramInt);
    }
    while (this.un.vm.getRootAlpha() == paramInt) {
      return;
    }
    this.un.vm.setRootAlpha(paramInt);
    invalidateSelf();
  }
  
  public final void setAutoMirrored(boolean paramBoolean)
  {
    if (this.ul != null)
    {
      android.support.v4.graphics.drawable.a.a(this.ul, paramBoolean);
      return;
    }
    this.un.vp = paramBoolean;
  }
  
  public final void setColorFilter(ColorFilter paramColorFilter)
  {
    if (this.ul != null)
    {
      this.ul.setColorFilter(paramColorFilter);
      return;
    }
    this.up = paramColorFilter;
    invalidateSelf();
  }
  
  public final void setTint(int paramInt)
  {
    if (this.ul != null)
    {
      android.support.v4.graphics.drawable.a.a(this.ul, paramInt);
      return;
    }
    setTintList(ColorStateList.valueOf(paramInt));
  }
  
  public final void setTintList(ColorStateList paramColorStateList)
  {
    if (this.ul != null) {
      android.support.v4.graphics.drawable.a.a(this.ul, paramColorStateList);
    }
    g localg;
    do
    {
      return;
      localg = this.un;
    } while (localg.vn == paramColorStateList);
    localg.vn = paramColorStateList;
    this.uo = a(paramColorStateList, localg.vo);
    invalidateSelf();
  }
  
  public final void setTintMode(PorterDuff.Mode paramMode)
  {
    if (this.ul != null) {
      android.support.v4.graphics.drawable.a.a(this.ul, paramMode);
    }
    g localg;
    do
    {
      return;
      localg = this.un;
    } while (localg.vo == paramMode);
    localg.vo = paramMode;
    this.uo = a(localg.vn, paramMode);
    invalidateSelf();
  }
  
  public final boolean setVisible(boolean paramBoolean1, boolean paramBoolean2)
  {
    if (this.ul != null) {
      return this.ul.setVisible(paramBoolean1, paramBoolean2);
    }
    return super.setVisible(paramBoolean1, paramBoolean2);
  }
  
  public final void unscheduleSelf(Runnable paramRunnable)
  {
    if (this.ul != null)
    {
      this.ul.unscheduleSelf(paramRunnable);
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
        this.uV = str;
      }
      paramTypedArray = paramTypedArray.getString(1);
      if (paramTypedArray != null) {
        this.uU = c.w(paramTypedArray);
      }
    }
    
    public final boolean db()
    {
      return true;
    }
  }
  
  static final class b
    extends i.e
  {
    b uA;
    float uB = 1.0F;
    int uC = 0;
    float uD = 1.0F;
    float uE = 0.0F;
    float uF = 1.0F;
    float uG = 0.0F;
    Paint.Cap uH = Paint.Cap.BUTT;
    Paint.Join uI = Paint.Join.MITER;
    float uJ = 4.0F;
    private int[] ux;
    b uy;
    float uz = 0.0F;
    
    public b() {}
    
    public b(b paramb)
    {
      super();
      this.ux = paramb.ux;
      this.uy = paramb.uy;
      this.uz = paramb.uz;
      this.uB = paramb.uB;
      this.uA = paramb.uA;
      this.uC = paramb.uC;
      this.uD = paramb.uD;
      this.uE = paramb.uE;
      this.uF = paramb.uF;
      this.uG = paramb.uG;
      this.uH = paramb.uH;
      this.uI = paramb.uI;
      this.uJ = paramb.uJ;
    }
    
    final void a(TypedArray paramTypedArray, XmlPullParser paramXmlPullParser, Resources.Theme paramTheme)
    {
      this.ux = null;
      if (!g.a(paramXmlPullParser, "pathData")) {
        return;
      }
      Object localObject = paramTypedArray.getString(0);
      if (localObject != null) {
        this.uV = ((String)localObject);
      }
      localObject = paramTypedArray.getString(2);
      if (localObject != null) {
        this.uU = c.w((String)localObject);
      }
      this.uA = g.a(paramTypedArray, paramXmlPullParser, paramTheme, "fillColor", 1);
      this.uD = g.a(paramTypedArray, paramXmlPullParser, "fillAlpha", 12, this.uD);
      int i = g.a(paramTypedArray, paramXmlPullParser, "strokeLineCap", 8, -1);
      localObject = this.uH;
      switch (i)
      {
      default: 
        this.uH = ((Paint.Cap)localObject);
        i = g.a(paramTypedArray, paramXmlPullParser, "strokeLineJoin", 9, -1);
        localObject = this.uI;
        switch (i)
        {
        }
        break;
      }
      for (;;)
      {
        this.uI = ((Paint.Join)localObject);
        this.uJ = g.a(paramTypedArray, paramXmlPullParser, "strokeMiterLimit", 10, this.uJ);
        this.uy = g.a(paramTypedArray, paramXmlPullParser, paramTheme, "strokeColor", 3);
        this.uB = g.a(paramTypedArray, paramXmlPullParser, "strokeAlpha", 11, this.uB);
        this.uz = g.a(paramTypedArray, paramXmlPullParser, "strokeWidth", 4, this.uz);
        this.uF = g.a(paramTypedArray, paramXmlPullParser, "trimPathEnd", 6, this.uF);
        this.uG = g.a(paramTypedArray, paramXmlPullParser, "trimPathOffset", 7, this.uG);
        this.uE = g.a(paramTypedArray, paramXmlPullParser, "trimPathStart", 5, this.uE);
        this.uC = g.a(paramTypedArray, paramXmlPullParser, "fillType", 13, this.uC);
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
      return this.uA.e(paramArrayOfInt) | this.uy.e(paramArrayOfInt);
    }
    
    final float getFillAlpha()
    {
      return this.uD;
    }
    
    final int getFillColor()
    {
      return this.uA.mColor;
    }
    
    final float getStrokeAlpha()
    {
      return this.uB;
    }
    
    final int getStrokeColor()
    {
      return this.uy.mColor;
    }
    
    final float getStrokeWidth()
    {
      return this.uz;
    }
    
    final float getTrimPathEnd()
    {
      return this.uF;
    }
    
    final float getTrimPathOffset()
    {
      return this.uG;
    }
    
    final float getTrimPathStart()
    {
      return this.uE;
    }
    
    public final boolean isStateful()
    {
      return (this.uA.isStateful()) || (this.uy.isStateful());
    }
    
    final void setFillAlpha(float paramFloat)
    {
      this.uD = paramFloat;
    }
    
    final void setFillColor(int paramInt)
    {
      this.uA.mColor = paramInt;
    }
    
    final void setStrokeAlpha(float paramFloat)
    {
      this.uB = paramFloat;
    }
    
    final void setStrokeColor(int paramInt)
    {
      this.uy.mColor = paramInt;
    }
    
    final void setStrokeWidth(float paramFloat)
    {
      this.uz = paramFloat;
    }
    
    final void setTrimPathEnd(float paramFloat)
    {
      this.uF = paramFloat;
    }
    
    final void setTrimPathOffset(float paramFloat)
    {
      this.uG = paramFloat;
    }
    
    final void setTrimPathStart(float paramFloat)
    {
      this.uE = paramFloat;
    }
  }
  
  static final class c
    extends i.d
  {
    int mChangingConfigurations;
    final ArrayList<i.d> mChildren = new ArrayList();
    final Matrix uK = new Matrix();
    float uL = 0.0F;
    float uM = 0.0F;
    float uN = 0.0F;
    float uO = 1.0F;
    float uP = 1.0F;
    float uQ = 0.0F;
    float uR = 0.0F;
    final Matrix uS = new Matrix();
    String uT = null;
    int[] ux;
    
    public c()
    {
      super();
    }
    
    public c(c paramc, android.support.v4.e.a<String, Object> parama)
    {
      super();
      this.uL = paramc.uL;
      this.uM = paramc.uM;
      this.uN = paramc.uN;
      this.uO = paramc.uO;
      this.uP = paramc.uP;
      this.uQ = paramc.uQ;
      this.uR = paramc.uR;
      this.ux = paramc.ux;
      this.uT = paramc.uT;
      this.mChangingConfigurations = paramc.mChangingConfigurations;
      if (this.uT != null) {
        parama.put(this.uT, this);
      }
      this.uS.set(paramc.uS);
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
            if (paramc.uV == null) {
              break;
            }
            parama.put(paramc.uV, paramc);
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
    
    final void dc()
    {
      this.uS.reset();
      this.uS.postTranslate(-this.uM, -this.uN);
      this.uS.postScale(this.uO, this.uP);
      this.uS.postRotate(this.uL, 0.0F, 0.0F);
      this.uS.postTranslate(this.uQ + this.uM, this.uR + this.uN);
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
      return this.uT;
    }
    
    public final Matrix getLocalMatrix()
    {
      return this.uS;
    }
    
    public final float getPivotX()
    {
      return this.uM;
    }
    
    public final float getPivotY()
    {
      return this.uN;
    }
    
    public final float getRotation()
    {
      return this.uL;
    }
    
    public final float getScaleX()
    {
      return this.uO;
    }
    
    public final float getScaleY()
    {
      return this.uP;
    }
    
    public final float getTranslateX()
    {
      return this.uQ;
    }
    
    public final float getTranslateY()
    {
      return this.uR;
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
      if (paramFloat != this.uM)
      {
        this.uM = paramFloat;
        dc();
      }
    }
    
    public final void setPivotY(float paramFloat)
    {
      if (paramFloat != this.uN)
      {
        this.uN = paramFloat;
        dc();
      }
    }
    
    public final void setRotation(float paramFloat)
    {
      if (paramFloat != this.uL)
      {
        this.uL = paramFloat;
        dc();
      }
    }
    
    public final void setScaleX(float paramFloat)
    {
      if (paramFloat != this.uO)
      {
        this.uO = paramFloat;
        dc();
      }
    }
    
    public final void setScaleY(float paramFloat)
    {
      if (paramFloat != this.uP)
      {
        this.uP = paramFloat;
        dc();
      }
    }
    
    public final void setTranslateX(float paramFloat)
    {
      if (paramFloat != this.uQ)
      {
        this.uQ = paramFloat;
        dc();
      }
    }
    
    public final void setTranslateY(float paramFloat)
    {
      if (paramFloat != this.uR)
      {
        this.uR = paramFloat;
        dc();
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
    protected c.b[] uU = null;
    String uV;
    
    public e()
    {
      super();
    }
    
    public e(e parame)
    {
      super();
      this.uV = parame.uV;
      this.mChangingConfigurations = parame.mChangingConfigurations;
      this.uU = c.a(parame.uU);
    }
    
    public final void b(Path paramPath)
    {
      paramPath.reset();
      if (this.uU != null) {
        c.b.a(this.uU, paramPath);
      }
    }
    
    public boolean db()
    {
      return false;
    }
    
    public c.b[] getPathData()
    {
      return this.uU;
    }
    
    public String getPathName()
    {
      return this.uV;
    }
    
    public void setPathData(c.b[] paramArrayOfb)
    {
      if (!c.a(this.uU, paramArrayOfb)) {
        this.uU = c.a(paramArrayOfb);
      }
      for (;;)
      {
        return;
        c.b[] arrayOfb = this.uU;
        int i = 0;
        while (i < paramArrayOfb.length)
        {
          arrayOfb[i].GT = paramArrayOfb[i].GT;
          int j = 0;
          while (j < paramArrayOfb[i].GU.length)
          {
            arrayOfb[i].GU[j] = paramArrayOfb[i].GU[j];
            j += 1;
          }
          i += 1;
        }
      }
    }
  }
  
  static final class f
  {
    private static final Matrix uY = new Matrix();
    private int mChangingConfigurations;
    private final Path uW;
    private final Path uX;
    private final Matrix uZ = new Matrix();
    Paint va;
    Paint vb;
    private PathMeasure vc;
    final i.c vd;
    float ve = 0.0F;
    float vf = 0.0F;
    float vg = 0.0F;
    float vh = 0.0F;
    int vi = 255;
    String vj = null;
    Boolean vk = null;
    final android.support.v4.e.a<String, Object> vl = new android.support.v4.e.a();
    
    public f()
    {
      this.vd = new i.c();
      this.uW = new Path();
      this.uX = new Path();
    }
    
    public f(f paramf)
    {
      this.vd = new i.c(paramf.vd, this.vl);
      this.uW = new Path(paramf.uW);
      this.uX = new Path(paramf.uX);
      this.ve = paramf.ve;
      this.vf = paramf.vf;
      this.vg = paramf.vg;
      this.vh = paramf.vh;
      this.mChangingConfigurations = paramf.mChangingConfigurations;
      this.vi = paramf.vi;
      this.vj = paramf.vj;
      if (paramf.vj != null) {
        this.vl.put(paramf.vj, this);
      }
      this.vk = paramf.vk;
    }
    
    private void a(i.c paramc, Matrix paramMatrix, Canvas paramCanvas, int paramInt1, int paramInt2, ColorFilter paramColorFilter)
    {
      paramc.uK.set(paramMatrix);
      paramc.uK.preConcat(paramc.uS);
      paramCanvas.save();
      int i = 0;
      if (i < paramc.mChildren.size())
      {
        paramMatrix = (i.d)paramc.mChildren.get(i);
        if ((paramMatrix instanceof i.c)) {
          a((i.c)paramMatrix, paramc.uK, paramCanvas, paramInt1, paramInt2, paramColorFilter);
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
          float f1 = paramInt1 / this.vg;
          float f3 = paramInt2 / this.vh;
          float f2 = Math.min(f1, f3);
          Object localObject1 = paramc.uK;
          this.uZ.set((Matrix)localObject1);
          this.uZ.postScale(f1, f3);
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
            paramMatrix.b(this.uW);
            localObject2 = this.uW;
            this.uX.reset();
            if (paramMatrix.db())
            {
              this.uX.addPath((Path)localObject2, this.uZ);
              paramCanvas.clipPath(this.uX);
              break;
            }
            localObject1 = (i.b)paramMatrix;
            if ((((i.b)localObject1).uE != 0.0F) || (((i.b)localObject1).uF != 1.0F))
            {
              f6 = ((i.b)localObject1).uE;
              f7 = ((i.b)localObject1).uG;
              f4 = ((i.b)localObject1).uF;
              f5 = ((i.b)localObject1).uG;
              if (this.vc == null) {
                this.vc = new PathMeasure();
              }
              this.vc.setPath(this.uW, false);
              f3 = this.vc.getLength();
              f6 = (f6 + f7) % 1.0F * f3;
              f4 = (f4 + f5) % 1.0F * f3;
              ((Path)localObject2).reset();
              if (f6 > f4)
              {
                this.vc.getSegment(f6, f3, (Path)localObject2, true);
                this.vc.getSegment(0.0F, f4, (Path)localObject2, true);
                label497:
                ((Path)localObject2).rLineTo(0.0F, 0.0F);
              }
            }
            else
            {
              this.uX.addPath((Path)localObject2, this.uZ);
              if (((i.b)localObject1).uA.dS())
              {
                paramMatrix = ((i.b)localObject1).uA;
                if (this.vb == null)
                {
                  this.vb = new Paint(1);
                  this.vb.setStyle(Paint.Style.FILL);
                }
                localObject2 = this.vb;
                if (!paramMatrix.dR()) {
                  break label847;
                }
                paramMatrix = paramMatrix.GB;
                paramMatrix.setLocalMatrix(this.uZ);
                ((Paint)localObject2).setShader(paramMatrix);
                ((Paint)localObject2).setAlpha(Math.round(((i.b)localObject1).uD * 255.0F));
                label612:
                ((Paint)localObject2).setColorFilter(paramColorFilter);
                Path localPath = this.uX;
                if (((i.b)localObject1).uC != 0) {
                  break label867;
                }
                paramMatrix = Path.FillType.WINDING;
                label638:
                localPath.setFillType(paramMatrix);
                paramCanvas.drawPath(this.uX, (Paint)localObject2);
              }
              if (!((i.b)localObject1).uy.dS()) {
                break;
              }
              localObject2 = ((i.b)localObject1).uy;
              if (this.va == null)
              {
                this.va = new Paint(1);
                this.va.setStyle(Paint.Style.STROKE);
              }
              paramMatrix = this.va;
              if (((i.b)localObject1).uI != null) {
                paramMatrix.setStrokeJoin(((i.b)localObject1).uI);
              }
              if (((i.b)localObject1).uH != null) {
                paramMatrix.setStrokeCap(((i.b)localObject1).uH);
              }
              paramMatrix.setStrokeMiter(((i.b)localObject1).uJ);
              if (!((b)localObject2).dR()) {
                break label874;
              }
              localObject2 = ((b)localObject2).GB;
              ((Shader)localObject2).setLocalMatrix(this.uZ);
              paramMatrix.setShader((Shader)localObject2);
              paramMatrix.setAlpha(Math.round(((i.b)localObject1).uB * 255.0F));
            }
            for (;;)
            {
              paramMatrix.setColorFilter(paramColorFilter);
              paramMatrix.setStrokeWidth(((i.b)localObject1).uz * (f2 * f1));
              paramCanvas.drawPath(this.uX, paramMatrix);
              break;
              this.vc.getSegment(f6, f4, (Path)localObject2, true);
              break label497;
              label847:
              ((Paint)localObject2).setColor(i.d(paramMatrix.mColor, ((i.b)localObject1).uD));
              break label612;
              label867:
              paramMatrix = Path.FillType.EVEN_ODD;
              break label638;
              label874:
              paramMatrix.setColor(i.d(((b)localObject2).mColor, ((i.b)localObject1).uB));
            }
            paramCanvas.restore();
            return;
          }
        }
      }
    }
    
    public final void a(Canvas paramCanvas, int paramInt1, int paramInt2)
    {
      a(this.vd, uY, paramCanvas, paramInt1, paramInt2, null);
    }
    
    public final float getAlpha()
    {
      return getRootAlpha() / 255.0F;
    }
    
    public final int getRootAlpha()
    {
      return this.vi;
    }
    
    public final boolean isStateful()
    {
      if (this.vk == null) {
        this.vk = Boolean.valueOf(this.vd.isStateful());
      }
      return this.vk.booleanValue();
    }
    
    public final void setAlpha(float paramFloat)
    {
      setRootAlpha((int)(255.0F * paramFloat));
    }
    
    public final void setRootAlpha(int paramInt)
    {
      this.vi = paramInt;
    }
  }
  
  static final class g
    extends Drawable.ConstantState
  {
    int mChangingConfigurations;
    i.f vm;
    ColorStateList vn = null;
    PorterDuff.Mode vo = i.um;
    boolean vp;
    Bitmap vq;
    ColorStateList vr;
    PorterDuff.Mode vs;
    int vt;
    boolean vu;
    boolean vv;
    Paint vw;
    
    public g()
    {
      this.vm = new i.f();
    }
    
    public g(g paramg)
    {
      if (paramg != null)
      {
        this.mChangingConfigurations = paramg.mChangingConfigurations;
        this.vm = new i.f(paramg.vm);
        if (paramg.vm.vb != null) {
          this.vm.vb = new Paint(paramg.vm.vb);
        }
        if (paramg.vm.va != null) {
          this.vm.va = new Paint(paramg.vm.va);
        }
        this.vn = paramg.vn;
        this.vo = paramg.vo;
        this.vp = paramg.vp;
      }
    }
    
    public final int getChangingConfigurations()
    {
      return this.mChangingConfigurations;
    }
    
    public final void l(int paramInt1, int paramInt2)
    {
      this.vq.eraseColor(0);
      Canvas localCanvas = new Canvas(this.vq);
      this.vm.a(localCanvas, paramInt1, paramInt2);
    }
    
    public final Drawable newDrawable()
    {
      return new i(this);
    }
    
    public final Drawable newDrawable(Resources paramResources)
    {
      return new i(this);
    }
  }
  
  static final class h
    extends Drawable.ConstantState
  {
    private final Drawable.ConstantState uf;
    
    public h(Drawable.ConstantState paramConstantState)
    {
      this.uf = paramConstantState;
    }
    
    public final boolean canApplyTheme()
    {
      return this.uf.canApplyTheme();
    }
    
    public final int getChangingConfigurations()
    {
      return this.uf.getChangingConfigurations();
    }
    
    public final Drawable newDrawable()
    {
      i locali = new i();
      locali.ul = ((VectorDrawable)this.uf.newDrawable());
      return locali;
    }
    
    public final Drawable newDrawable(Resources paramResources)
    {
      i locali = new i();
      locali.ul = ((VectorDrawable)this.uf.newDrawable(paramResources));
      return locali;
    }
    
    public final Drawable newDrawable(Resources paramResources, Resources.Theme paramTheme)
    {
      i locali = new i();
      locali.ul = ((VectorDrawable)this.uf.newDrawable(paramResources, paramTheme));
      return locali;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     android.support.c.a.i
 * JD-Core Version:    0.7.0.1
 */