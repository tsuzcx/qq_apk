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
  static final PorterDuff.Mode vl = PorterDuff.Mode.SRC_IN;
  g vm;
  private PorterDuffColorFilter vn;
  private ColorFilter vo;
  private boolean vp;
  boolean vq = true;
  private Drawable.ConstantState vr;
  private final float[] vs = new float[9];
  private final Matrix vt = new Matrix();
  private final Rect vu = new Rect();
  
  i()
  {
    this.vm = new g();
  }
  
  i(g paramg)
  {
    this.vm = paramg;
    this.vn = a(paramg.wm, paramg.wn);
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
      ((i)localObject).vk = f.c(paramResources, paramInt, paramTheme);
      ((i)localObject).vr = new h(((i)localObject).vk.getConstantState());
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
    g localg = this.vm;
    f localf = localg.wl;
    int i = 1;
    ArrayDeque localArrayDeque = new ArrayDeque();
    localArrayDeque.push(localf.wb);
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
          localTypedArray = g.a(paramResources, paramTheme, paramAttributeSet, a.uM);
          ((b)localObject).a(localTypedArray, paramXmlPullParser, paramTheme);
          localTypedArray.recycle();
          localc.mChildren.add(localObject);
          if (((b)localObject).getPathName() != null) {
            localf.wk.put(((b)localObject).getPathName(), localObject);
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
            localTypedArray = g.a(paramResources, paramTheme, paramAttributeSet, a.uN);
            ((a)localObject).a(localTypedArray);
            localTypedArray.recycle();
          }
          localc.mChildren.add(localObject);
          if (((a)localObject).getPathName() != null) {
            localf.wk.put(((a)localObject).getPathName(), localObject);
          }
          localg.mChangingConfigurations |= ((a)localObject).mChangingConfigurations;
        }
        else
        {
          if ("group".equals(localObject))
          {
            localObject = new c();
            localTypedArray = g.a(paramResources, paramTheme, paramAttributeSet, a.uL);
            ((c)localObject).vv = null;
            ((c)localObject).vJ = g.a(localTypedArray, paramXmlPullParser, "rotation", 5, ((c)localObject).vJ);
            ((c)localObject).vK = localTypedArray.getFloat(1, ((c)localObject).vK);
            ((c)localObject).vL = localTypedArray.getFloat(2, ((c)localObject).vL);
            ((c)localObject).vM = g.a(localTypedArray, paramXmlPullParser, "scaleX", 3, ((c)localObject).vM);
            ((c)localObject).vN = g.a(localTypedArray, paramXmlPullParser, "scaleY", 4, ((c)localObject).vN);
            ((c)localObject).vO = g.a(localTypedArray, paramXmlPullParser, "translateX", 6, ((c)localObject).vO);
            ((c)localObject).vP = g.a(localTypedArray, paramXmlPullParser, "translateY", 7, ((c)localObject).vP);
            String str = localTypedArray.getString(0);
            if (str != null) {
              ((c)localObject).vR = str;
            }
            ((c)localObject).dj();
            localTypedArray.recycle();
            localc.mChildren.add(localObject);
            localArrayDeque.push(localObject);
            if (((c)localObject).getGroupName() != null) {
              localf.wk.put(((c)localObject).getGroupName(), localObject);
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
    if (this.vk != null) {
      android.support.v4.graphics.drawable.a.g(this.vk);
    }
    return false;
  }
  
  public final void draw(Canvas paramCanvas)
  {
    if (this.vk != null) {
      this.vk.draw(paramCanvas);
    }
    int i;
    int k;
    int m;
    do
    {
      do
      {
        return;
        copyBounds(this.vu);
      } while ((this.vu.width() <= 0) || (this.vu.height() <= 0));
      if (this.vo != null) {
        break;
      }
      localObject = this.vn;
      paramCanvas.getMatrix(this.vt);
      this.vt.getValues(this.vs);
      float f2 = Math.abs(this.vs[0]);
      float f1 = Math.abs(this.vs[4]);
      float f4 = Math.abs(this.vs[1]);
      float f3 = Math.abs(this.vs[3]);
      if ((f4 != 0.0F) || (f3 != 0.0F))
      {
        f1 = 1.0F;
        f2 = 1.0F;
      }
      j = (int)(f2 * this.vu.width());
      i = (int)(f1 * this.vu.height());
      k = Math.min(2048, j);
      m = Math.min(2048, i);
    } while ((k <= 0) || (m <= 0));
    int j = paramCanvas.save();
    paramCanvas.translate(this.vu.left, this.vu.top);
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
          paramCanvas.translate(this.vu.width(), 0.0F);
          paramCanvas.scale(-1.0F, 1.0F);
        }
        this.vu.offsetTo(0, 0);
        localg = this.vm;
        if (localg.wp != null)
        {
          if ((k != localg.wp.getWidth()) || (m != localg.wp.getHeight())) {
            break label450;
          }
          i = 1;
          if (i != 0) {}
        }
        else
        {
          localg.wp = Bitmap.createBitmap(k, m, Bitmap.Config.ARGB_8888);
          localg.wu = true;
        }
        if (this.vq) {
          break label456;
        }
        this.vm.l(k, m);
        localg = this.vm;
        localRect = this.vu;
        if (localg.wl.getRootAlpha() >= 255) {
          break label608;
        }
        i = 1;
        label395:
        if ((i != 0) || (localObject != null)) {
          break label614;
        }
      }
    }
    for (Object localObject = null;; localObject = localg.wv)
    {
      paramCanvas.drawBitmap(localg.wp, null, localRect, (Paint)localObject);
      paramCanvas.restoreToCount(j);
      return;
      localObject = this.vo;
      break;
      i = 0;
      break label244;
      i = 0;
      break label244;
      label450:
      i = 0;
      break label322;
      label456:
      localg = this.vm;
      if ((!localg.wu) && (localg.wq == localg.wm) && (localg.wr == localg.wn) && (localg.wt == localg.wo) && (localg.ws == localg.wl.getRootAlpha())) {}
      for (i = 1;; i = 0)
      {
        if (i != 0) {
          break label606;
        }
        this.vm.l(k, m);
        localg = this.vm;
        localg.wq = localg.wm;
        localg.wr = localg.wn;
        localg.ws = localg.wl.getRootAlpha();
        localg.wt = localg.wo;
        localg.wu = false;
        break;
      }
      label606:
      break label366;
      label608:
      i = 0;
      break label395;
      label614:
      if (localg.wv == null)
      {
        localg.wv = new Paint();
        localg.wv.setFilterBitmap(true);
      }
      localg.wv.setAlpha(localg.wl.getRootAlpha());
      localg.wv.setColorFilter((ColorFilter)localObject);
    }
  }
  
  public final int getAlpha()
  {
    if (this.vk != null) {
      return android.support.v4.graphics.drawable.a.f(this.vk);
    }
    return this.vm.wl.getRootAlpha();
  }
  
  public final int getChangingConfigurations()
  {
    if (this.vk != null) {
      return this.vk.getChangingConfigurations();
    }
    return super.getChangingConfigurations() | this.vm.getChangingConfigurations();
  }
  
  public final Drawable.ConstantState getConstantState()
  {
    if ((this.vk != null) && (Build.VERSION.SDK_INT >= 24)) {
      return new h(this.vk.getConstantState());
    }
    this.vm.mChangingConfigurations = getChangingConfigurations();
    return this.vm;
  }
  
  public final int getIntrinsicHeight()
  {
    if (this.vk != null) {
      return this.vk.getIntrinsicHeight();
    }
    return (int)this.vm.wl.we;
  }
  
  public final int getIntrinsicWidth()
  {
    if (this.vk != null) {
      return this.vk.getIntrinsicWidth();
    }
    return (int)this.vm.wl.wd;
  }
  
  public final int getOpacity()
  {
    if (this.vk != null) {
      return this.vk.getOpacity();
    }
    return -3;
  }
  
  public final void inflate(Resources paramResources, XmlPullParser paramXmlPullParser, AttributeSet paramAttributeSet)
  {
    if (this.vk != null)
    {
      this.vk.inflate(paramResources, paramXmlPullParser, paramAttributeSet);
      return;
    }
    inflate(paramResources, paramXmlPullParser, paramAttributeSet, null);
  }
  
  public final void inflate(Resources paramResources, XmlPullParser paramXmlPullParser, AttributeSet paramAttributeSet, Resources.Theme paramTheme)
  {
    if (this.vk != null)
    {
      android.support.v4.graphics.drawable.a.a(this.vk, paramResources, paramXmlPullParser, paramAttributeSet, paramTheme);
      return;
    }
    g localg1 = this.vm;
    localg1.wl = new f();
    TypedArray localTypedArray = g.a(paramResources, paramTheme, paramAttributeSet, a.uK);
    g localg2 = this.vm;
    f localf = localg2.wl;
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
      localg2.wn = ((PorterDuff.Mode)localObject);
      localObject = localTypedArray.getColorStateList(1);
      if (localObject != null) {
        localg2.wm = ((ColorStateList)localObject);
      }
      localg2.wo = g.a(localTypedArray, paramXmlPullParser, "autoMirrored", 5, localg2.wo);
      localf.wf = g.a(localTypedArray, paramXmlPullParser, "viewportWidth", 7, localf.wf);
      localf.wg = g.a(localTypedArray, paramXmlPullParser, "viewportHeight", 8, localf.wg);
      if (localf.wf > 0.0F) {
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
    if (localf.wg <= 0.0F) {
      throw new XmlPullParserException(localTypedArray.getPositionDescription() + "<vector> tag requires viewportHeight > 0");
    }
    localf.wd = localTypedArray.getDimension(3, localf.wd);
    localf.we = localTypedArray.getDimension(2, localf.we);
    if (localf.wd <= 0.0F) {
      throw new XmlPullParserException(localTypedArray.getPositionDescription() + "<vector> tag requires width > 0");
    }
    if (localf.we <= 0.0F) {
      throw new XmlPullParserException(localTypedArray.getPositionDescription() + "<vector> tag requires height > 0");
    }
    localf.setAlpha(g.a(localTypedArray, paramXmlPullParser, "alpha", 4, localf.getAlpha()));
    localObject = localTypedArray.getString(0);
    if (localObject != null)
    {
      localf.wi = ((String)localObject);
      localf.wk.put(localObject, localf);
    }
    localTypedArray.recycle();
    localg1.mChangingConfigurations = getChangingConfigurations();
    localg1.wu = true;
    b(paramResources, paramXmlPullParser, paramAttributeSet, paramTheme);
    this.vn = a(localg1.wm, localg1.wn);
  }
  
  public final void invalidateSelf()
  {
    if (this.vk != null)
    {
      this.vk.invalidateSelf();
      return;
    }
    super.invalidateSelf();
  }
  
  public final boolean isAutoMirrored()
  {
    if (this.vk != null) {
      return android.support.v4.graphics.drawable.a.e(this.vk);
    }
    return this.vm.wo;
  }
  
  public final boolean isStateful()
  {
    if (this.vk != null) {
      return this.vk.isStateful();
    }
    return (super.isStateful()) || ((this.vm != null) && ((this.vm.wl.isStateful()) || ((this.vm.wm != null) && (this.vm.wm.isStateful()))));
  }
  
  public final Drawable mutate()
  {
    if (this.vk != null) {
      this.vk.mutate();
    }
    while ((this.vp) || (super.mutate() != this)) {
      return this;
    }
    this.vm = new g(this.vm);
    this.vp = true;
    return this;
  }
  
  protected final void onBoundsChange(Rect paramRect)
  {
    if (this.vk != null) {
      this.vk.setBounds(paramRect);
    }
  }
  
  protected final boolean onStateChange(int[] paramArrayOfInt)
  {
    boolean bool2;
    if (this.vk != null) {
      bool2 = this.vk.setState(paramArrayOfInt);
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
        localg = this.vm;
        bool1 = bool2;
        if (localg.wm != null)
        {
          bool1 = bool2;
          if (localg.wn != null)
          {
            this.vn = a(localg.wm, localg.wn);
            invalidateSelf();
            bool1 = true;
          }
        }
        bool2 = bool1;
      } while (!localg.wl.isStateful());
      bool3 = localg.wl.wb.e(paramArrayOfInt);
      localg.wu |= bool3;
      bool2 = bool1;
    } while (!bool3);
    invalidateSelf();
    return true;
  }
  
  public final void scheduleSelf(Runnable paramRunnable, long paramLong)
  {
    if (this.vk != null)
    {
      this.vk.scheduleSelf(paramRunnable, paramLong);
      return;
    }
    super.scheduleSelf(paramRunnable, paramLong);
  }
  
  public final void setAlpha(int paramInt)
  {
    if (this.vk != null) {
      this.vk.setAlpha(paramInt);
    }
    while (this.vm.wl.getRootAlpha() == paramInt) {
      return;
    }
    this.vm.wl.setRootAlpha(paramInt);
    invalidateSelf();
  }
  
  public final void setAutoMirrored(boolean paramBoolean)
  {
    if (this.vk != null)
    {
      android.support.v4.graphics.drawable.a.a(this.vk, paramBoolean);
      return;
    }
    this.vm.wo = paramBoolean;
  }
  
  public final void setColorFilter(ColorFilter paramColorFilter)
  {
    if (this.vk != null)
    {
      this.vk.setColorFilter(paramColorFilter);
      return;
    }
    this.vo = paramColorFilter;
    invalidateSelf();
  }
  
  public final void setTint(int paramInt)
  {
    if (this.vk != null)
    {
      android.support.v4.graphics.drawable.a.a(this.vk, paramInt);
      return;
    }
    setTintList(ColorStateList.valueOf(paramInt));
  }
  
  public final void setTintList(ColorStateList paramColorStateList)
  {
    if (this.vk != null) {
      android.support.v4.graphics.drawable.a.a(this.vk, paramColorStateList);
    }
    g localg;
    do
    {
      return;
      localg = this.vm;
    } while (localg.wm == paramColorStateList);
    localg.wm = paramColorStateList;
    this.vn = a(paramColorStateList, localg.wn);
    invalidateSelf();
  }
  
  public final void setTintMode(PorterDuff.Mode paramMode)
  {
    if (this.vk != null) {
      android.support.v4.graphics.drawable.a.a(this.vk, paramMode);
    }
    g localg;
    do
    {
      return;
      localg = this.vm;
    } while (localg.wn == paramMode);
    localg.wn = paramMode;
    this.vn = a(localg.wm, paramMode);
    invalidateSelf();
  }
  
  public final boolean setVisible(boolean paramBoolean1, boolean paramBoolean2)
  {
    if (this.vk != null) {
      return this.vk.setVisible(paramBoolean1, paramBoolean2);
    }
    return super.setVisible(paramBoolean1, paramBoolean2);
  }
  
  public final void unscheduleSelf(Runnable paramRunnable)
  {
    if (this.vk != null)
    {
      this.vk.unscheduleSelf(paramRunnable);
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
        this.vT = str;
      }
      paramTypedArray = paramTypedArray.getString(1);
      if (paramTypedArray != null) {
        this.vS = c.y(paramTypedArray);
      }
    }
    
    public final boolean di()
    {
      return true;
    }
  }
  
  static final class b
    extends i.e
  {
    int vA = 0;
    float vB = 1.0F;
    float vC = 0.0F;
    float vD = 1.0F;
    float vE = 0.0F;
    Paint.Cap vF = Paint.Cap.BUTT;
    Paint.Join vG = Paint.Join.MITER;
    float vH = 4.0F;
    private int[] vv;
    b vw;
    float vx = 0.0F;
    b vy;
    float vz = 1.0F;
    
    public b() {}
    
    public b(b paramb)
    {
      super();
      this.vv = paramb.vv;
      this.vw = paramb.vw;
      this.vx = paramb.vx;
      this.vz = paramb.vz;
      this.vy = paramb.vy;
      this.vA = paramb.vA;
      this.vB = paramb.vB;
      this.vC = paramb.vC;
      this.vD = paramb.vD;
      this.vE = paramb.vE;
      this.vF = paramb.vF;
      this.vG = paramb.vG;
      this.vH = paramb.vH;
    }
    
    final void a(TypedArray paramTypedArray, XmlPullParser paramXmlPullParser, Resources.Theme paramTheme)
    {
      this.vv = null;
      if (!g.a(paramXmlPullParser, "pathData")) {
        return;
      }
      Object localObject = paramTypedArray.getString(0);
      if (localObject != null) {
        this.vT = ((String)localObject);
      }
      localObject = paramTypedArray.getString(2);
      if (localObject != null) {
        this.vS = c.y((String)localObject);
      }
      this.vy = g.a(paramTypedArray, paramXmlPullParser, paramTheme, "fillColor", 1);
      this.vB = g.a(paramTypedArray, paramXmlPullParser, "fillAlpha", 12, this.vB);
      int i = g.a(paramTypedArray, paramXmlPullParser, "strokeLineCap", 8, -1);
      localObject = this.vF;
      switch (i)
      {
      default: 
        this.vF = ((Paint.Cap)localObject);
        i = g.a(paramTypedArray, paramXmlPullParser, "strokeLineJoin", 9, -1);
        localObject = this.vG;
        switch (i)
        {
        }
        break;
      }
      for (;;)
      {
        this.vG = ((Paint.Join)localObject);
        this.vH = g.a(paramTypedArray, paramXmlPullParser, "strokeMiterLimit", 10, this.vH);
        this.vw = g.a(paramTypedArray, paramXmlPullParser, paramTheme, "strokeColor", 3);
        this.vz = g.a(paramTypedArray, paramXmlPullParser, "strokeAlpha", 11, this.vz);
        this.vx = g.a(paramTypedArray, paramXmlPullParser, "strokeWidth", 4, this.vx);
        this.vD = g.a(paramTypedArray, paramXmlPullParser, "trimPathEnd", 6, this.vD);
        this.vE = g.a(paramTypedArray, paramXmlPullParser, "trimPathOffset", 7, this.vE);
        this.vC = g.a(paramTypedArray, paramXmlPullParser, "trimPathStart", 5, this.vC);
        this.vA = g.a(paramTypedArray, paramXmlPullParser, "fillType", 13, this.vA);
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
      return this.vy.e(paramArrayOfInt) | this.vw.e(paramArrayOfInt);
    }
    
    final float getFillAlpha()
    {
      return this.vB;
    }
    
    final int getFillColor()
    {
      return this.vy.mColor;
    }
    
    final float getStrokeAlpha()
    {
      return this.vz;
    }
    
    final int getStrokeColor()
    {
      return this.vw.mColor;
    }
    
    final float getStrokeWidth()
    {
      return this.vx;
    }
    
    final float getTrimPathEnd()
    {
      return this.vD;
    }
    
    final float getTrimPathOffset()
    {
      return this.vE;
    }
    
    final float getTrimPathStart()
    {
      return this.vC;
    }
    
    public final boolean isStateful()
    {
      return (this.vy.isStateful()) || (this.vw.isStateful());
    }
    
    final void setFillAlpha(float paramFloat)
    {
      this.vB = paramFloat;
    }
    
    final void setFillColor(int paramInt)
    {
      this.vy.mColor = paramInt;
    }
    
    final void setStrokeAlpha(float paramFloat)
    {
      this.vz = paramFloat;
    }
    
    final void setStrokeColor(int paramInt)
    {
      this.vw.mColor = paramInt;
    }
    
    final void setStrokeWidth(float paramFloat)
    {
      this.vx = paramFloat;
    }
    
    final void setTrimPathEnd(float paramFloat)
    {
      this.vD = paramFloat;
    }
    
    final void setTrimPathOffset(float paramFloat)
    {
      this.vE = paramFloat;
    }
    
    final void setTrimPathStart(float paramFloat)
    {
      this.vC = paramFloat;
    }
  }
  
  static final class c
    extends i.d
  {
    int mChangingConfigurations;
    final ArrayList<i.d> mChildren = new ArrayList();
    final Matrix vI = new Matrix();
    float vJ = 0.0F;
    float vK = 0.0F;
    float vL = 0.0F;
    float vM = 1.0F;
    float vN = 1.0F;
    float vO = 0.0F;
    float vP = 0.0F;
    final Matrix vQ = new Matrix();
    String vR = null;
    int[] vv;
    
    public c()
    {
      super();
    }
    
    public c(c paramc, android.support.v4.e.a<String, Object> parama)
    {
      super();
      this.vJ = paramc.vJ;
      this.vK = paramc.vK;
      this.vL = paramc.vL;
      this.vM = paramc.vM;
      this.vN = paramc.vN;
      this.vO = paramc.vO;
      this.vP = paramc.vP;
      this.vv = paramc.vv;
      this.vR = paramc.vR;
      this.mChangingConfigurations = paramc.mChangingConfigurations;
      if (this.vR != null) {
        parama.put(this.vR, this);
      }
      this.vQ.set(paramc.vQ);
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
            if (paramc.vT == null) {
              break;
            }
            parama.put(paramc.vT, paramc);
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
    
    final void dj()
    {
      this.vQ.reset();
      this.vQ.postTranslate(-this.vK, -this.vL);
      this.vQ.postScale(this.vM, this.vN);
      this.vQ.postRotate(this.vJ, 0.0F, 0.0F);
      this.vQ.postTranslate(this.vO + this.vK, this.vP + this.vL);
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
      return this.vR;
    }
    
    public final Matrix getLocalMatrix()
    {
      return this.vQ;
    }
    
    public final float getPivotX()
    {
      return this.vK;
    }
    
    public final float getPivotY()
    {
      return this.vL;
    }
    
    public final float getRotation()
    {
      return this.vJ;
    }
    
    public final float getScaleX()
    {
      return this.vM;
    }
    
    public final float getScaleY()
    {
      return this.vN;
    }
    
    public final float getTranslateX()
    {
      return this.vO;
    }
    
    public final float getTranslateY()
    {
      return this.vP;
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
      if (paramFloat != this.vK)
      {
        this.vK = paramFloat;
        dj();
      }
    }
    
    public final void setPivotY(float paramFloat)
    {
      if (paramFloat != this.vL)
      {
        this.vL = paramFloat;
        dj();
      }
    }
    
    public final void setRotation(float paramFloat)
    {
      if (paramFloat != this.vJ)
      {
        this.vJ = paramFloat;
        dj();
      }
    }
    
    public final void setScaleX(float paramFloat)
    {
      if (paramFloat != this.vM)
      {
        this.vM = paramFloat;
        dj();
      }
    }
    
    public final void setScaleY(float paramFloat)
    {
      if (paramFloat != this.vN)
      {
        this.vN = paramFloat;
        dj();
      }
    }
    
    public final void setTranslateX(float paramFloat)
    {
      if (paramFloat != this.vO)
      {
        this.vO = paramFloat;
        dj();
      }
    }
    
    public final void setTranslateY(float paramFloat)
    {
      if (paramFloat != this.vP)
      {
        this.vP = paramFloat;
        dj();
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
    protected c.b[] vS = null;
    String vT;
    
    public e()
    {
      super();
    }
    
    public e(e parame)
    {
      super();
      this.vT = parame.vT;
      this.mChangingConfigurations = parame.mChangingConfigurations;
      this.vS = c.a(parame.vS);
    }
    
    public final void b(Path paramPath)
    {
      paramPath.reset();
      if (this.vS != null) {
        c.b.a(this.vS, paramPath);
      }
    }
    
    public boolean di()
    {
      return false;
    }
    
    public c.b[] getPathData()
    {
      return this.vS;
    }
    
    public String getPathName()
    {
      return this.vT;
    }
    
    public void setPathData(c.b[] paramArrayOfb)
    {
      if (!c.a(this.vS, paramArrayOfb)) {
        this.vS = c.a(paramArrayOfb);
      }
      for (;;)
      {
        return;
        c.b[] arrayOfb = this.vS;
        int i = 0;
        while (i < paramArrayOfb.length)
        {
          arrayOfb[i].HQ = paramArrayOfb[i].HQ;
          int j = 0;
          while (j < paramArrayOfb[i].HR.length)
          {
            arrayOfb[i].HR[j] = paramArrayOfb[i].HR[j];
            j += 1;
          }
          i += 1;
        }
      }
    }
  }
  
  static final class f
  {
    private static final Matrix vW = new Matrix();
    private int mChangingConfigurations;
    private final Path vU;
    private final Path vV;
    private final Matrix vX = new Matrix();
    Paint vY;
    Paint vZ;
    private PathMeasure wa;
    final i.c wb;
    float wd = 0.0F;
    float we = 0.0F;
    float wf = 0.0F;
    float wg = 0.0F;
    int wh = 255;
    String wi = null;
    Boolean wj = null;
    final android.support.v4.e.a<String, Object> wk = new android.support.v4.e.a();
    
    public f()
    {
      this.wb = new i.c();
      this.vU = new Path();
      this.vV = new Path();
    }
    
    public f(f paramf)
    {
      this.wb = new i.c(paramf.wb, this.wk);
      this.vU = new Path(paramf.vU);
      this.vV = new Path(paramf.vV);
      this.wd = paramf.wd;
      this.we = paramf.we;
      this.wf = paramf.wf;
      this.wg = paramf.wg;
      this.mChangingConfigurations = paramf.mChangingConfigurations;
      this.wh = paramf.wh;
      this.wi = paramf.wi;
      if (paramf.wi != null) {
        this.wk.put(paramf.wi, this);
      }
      this.wj = paramf.wj;
    }
    
    private void a(i.c paramc, Matrix paramMatrix, Canvas paramCanvas, int paramInt1, int paramInt2, ColorFilter paramColorFilter)
    {
      paramc.vI.set(paramMatrix);
      paramc.vI.preConcat(paramc.vQ);
      paramCanvas.save();
      int i = 0;
      if (i < paramc.mChildren.size())
      {
        paramMatrix = (i.d)paramc.mChildren.get(i);
        if ((paramMatrix instanceof i.c)) {
          a((i.c)paramMatrix, paramc.vI, paramCanvas, paramInt1, paramInt2, paramColorFilter);
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
          float f1 = paramInt1 / this.wf;
          float f3 = paramInt2 / this.wg;
          float f2 = Math.min(f1, f3);
          Object localObject1 = paramc.vI;
          this.vX.set((Matrix)localObject1);
          this.vX.postScale(f1, f3);
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
            paramMatrix.b(this.vU);
            localObject2 = this.vU;
            this.vV.reset();
            if (paramMatrix.di())
            {
              this.vV.addPath((Path)localObject2, this.vX);
              paramCanvas.clipPath(this.vV);
              break;
            }
            localObject1 = (i.b)paramMatrix;
            if ((((i.b)localObject1).vC != 0.0F) || (((i.b)localObject1).vD != 1.0F))
            {
              f6 = ((i.b)localObject1).vC;
              f7 = ((i.b)localObject1).vE;
              f4 = ((i.b)localObject1).vD;
              f5 = ((i.b)localObject1).vE;
              if (this.wa == null) {
                this.wa = new PathMeasure();
              }
              this.wa.setPath(this.vU, false);
              f3 = this.wa.getLength();
              f6 = (f6 + f7) % 1.0F * f3;
              f4 = (f4 + f5) % 1.0F * f3;
              ((Path)localObject2).reset();
              if (f6 > f4)
              {
                this.wa.getSegment(f6, f3, (Path)localObject2, true);
                this.wa.getSegment(0.0F, f4, (Path)localObject2, true);
                label497:
                ((Path)localObject2).rLineTo(0.0F, 0.0F);
              }
            }
            else
            {
              this.vV.addPath((Path)localObject2, this.vX);
              if (((i.b)localObject1).vy.dZ())
              {
                paramMatrix = ((i.b)localObject1).vy;
                if (this.vZ == null)
                {
                  this.vZ = new Paint(1);
                  this.vZ.setStyle(Paint.Style.FILL);
                }
                localObject2 = this.vZ;
                if (!paramMatrix.dY()) {
                  break label847;
                }
                paramMatrix = paramMatrix.Hz;
                paramMatrix.setLocalMatrix(this.vX);
                ((Paint)localObject2).setShader(paramMatrix);
                ((Paint)localObject2).setAlpha(Math.round(((i.b)localObject1).vB * 255.0F));
                label612:
                ((Paint)localObject2).setColorFilter(paramColorFilter);
                Path localPath = this.vV;
                if (((i.b)localObject1).vA != 0) {
                  break label867;
                }
                paramMatrix = Path.FillType.WINDING;
                label638:
                localPath.setFillType(paramMatrix);
                paramCanvas.drawPath(this.vV, (Paint)localObject2);
              }
              if (!((i.b)localObject1).vw.dZ()) {
                break;
              }
              localObject2 = ((i.b)localObject1).vw;
              if (this.vY == null)
              {
                this.vY = new Paint(1);
                this.vY.setStyle(Paint.Style.STROKE);
              }
              paramMatrix = this.vY;
              if (((i.b)localObject1).vG != null) {
                paramMatrix.setStrokeJoin(((i.b)localObject1).vG);
              }
              if (((i.b)localObject1).vF != null) {
                paramMatrix.setStrokeCap(((i.b)localObject1).vF);
              }
              paramMatrix.setStrokeMiter(((i.b)localObject1).vH);
              if (!((b)localObject2).dY()) {
                break label874;
              }
              localObject2 = ((b)localObject2).Hz;
              ((Shader)localObject2).setLocalMatrix(this.vX);
              paramMatrix.setShader((Shader)localObject2);
              paramMatrix.setAlpha(Math.round(((i.b)localObject1).vz * 255.0F));
            }
            for (;;)
            {
              paramMatrix.setColorFilter(paramColorFilter);
              paramMatrix.setStrokeWidth(((i.b)localObject1).vx * (f2 * f1));
              paramCanvas.drawPath(this.vV, paramMatrix);
              break;
              this.wa.getSegment(f6, f4, (Path)localObject2, true);
              break label497;
              label847:
              ((Paint)localObject2).setColor(i.d(paramMatrix.mColor, ((i.b)localObject1).vB));
              break label612;
              label867:
              paramMatrix = Path.FillType.EVEN_ODD;
              break label638;
              label874:
              paramMatrix.setColor(i.d(((b)localObject2).mColor, ((i.b)localObject1).vz));
            }
            paramCanvas.restore();
            return;
          }
        }
      }
    }
    
    public final void a(Canvas paramCanvas, int paramInt1, int paramInt2)
    {
      a(this.wb, vW, paramCanvas, paramInt1, paramInt2, null);
    }
    
    public final float getAlpha()
    {
      return getRootAlpha() / 255.0F;
    }
    
    public final int getRootAlpha()
    {
      return this.wh;
    }
    
    public final boolean isStateful()
    {
      if (this.wj == null) {
        this.wj = Boolean.valueOf(this.wb.isStateful());
      }
      return this.wj.booleanValue();
    }
    
    public final void setAlpha(float paramFloat)
    {
      setRootAlpha((int)(255.0F * paramFloat));
    }
    
    public final void setRootAlpha(int paramInt)
    {
      this.wh = paramInt;
    }
  }
  
  static final class g
    extends Drawable.ConstantState
  {
    int mChangingConfigurations;
    i.f wl;
    ColorStateList wm = null;
    PorterDuff.Mode wn = i.vl;
    boolean wo;
    Bitmap wp;
    ColorStateList wq;
    PorterDuff.Mode wr;
    int ws;
    boolean wt;
    boolean wu;
    Paint wv;
    
    public g()
    {
      this.wl = new i.f();
    }
    
    public g(g paramg)
    {
      if (paramg != null)
      {
        this.mChangingConfigurations = paramg.mChangingConfigurations;
        this.wl = new i.f(paramg.wl);
        if (paramg.wl.vZ != null) {
          this.wl.vZ = new Paint(paramg.wl.vZ);
        }
        if (paramg.wl.vY != null) {
          this.wl.vY = new Paint(paramg.wl.vY);
        }
        this.wm = paramg.wm;
        this.wn = paramg.wn;
        this.wo = paramg.wo;
      }
    }
    
    public final int getChangingConfigurations()
    {
      return this.mChangingConfigurations;
    }
    
    public final void l(int paramInt1, int paramInt2)
    {
      this.wp.eraseColor(0);
      Canvas localCanvas = new Canvas(this.wp);
      this.wl.a(localCanvas, paramInt1, paramInt2);
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
    private final Drawable.ConstantState vf;
    
    public h(Drawable.ConstantState paramConstantState)
    {
      this.vf = paramConstantState;
    }
    
    public final boolean canApplyTheme()
    {
      return this.vf.canApplyTheme();
    }
    
    public final int getChangingConfigurations()
    {
      return this.vf.getChangingConfigurations();
    }
    
    public final Drawable newDrawable()
    {
      i locali = new i();
      locali.vk = ((VectorDrawable)this.vf.newDrawable());
      return locali;
    }
    
    public final Drawable newDrawable(Resources paramResources)
    {
      i locali = new i();
      locali.vk = ((VectorDrawable)this.vf.newDrawable(paramResources));
      return locali;
    }
    
    public final Drawable newDrawable(Resources paramResources, Resources.Theme paramTheme)
    {
      i locali = new i();
      locali.vk = ((VectorDrawable)this.vf.newDrawable(paramResources, paramTheme));
      return locali;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     android.support.d.a.i
 * JD-Core Version:    0.7.0.1
 */