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
  static final PorterDuff.Mode nL = PorterDuff.Mode.SRC_IN;
  g nM;
  private PorterDuffColorFilter nN;
  private ColorFilter nO;
  private boolean nP;
  boolean nQ = true;
  private Drawable.ConstantState nR;
  private final float[] nS = new float[9];
  private final Matrix nT = new Matrix();
  private final Rect nU = new Rect();
  
  i()
  {
    this.nM = new g();
  }
  
  i(g paramg)
  {
    this.nM = paramg;
    this.nN = a(paramg.oL, paramg.oM);
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
      ((i)localObject).nK = f.c(paramResources, paramInt, paramTheme);
      ((i)localObject).nR = new h(((i)localObject).nK.getConstantState());
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
    g localg = this.nM;
    f localf = localg.oK;
    int i = 1;
    ArrayDeque localArrayDeque = new ArrayDeque();
    localArrayDeque.push(localf.oB);
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
          localTypedArray = g.a(paramResources, paramTheme, paramAttributeSet, a.nl);
          ((b)localObject).a(localTypedArray, paramXmlPullParser, paramTheme);
          localTypedArray.recycle();
          localc.mChildren.add(localObject);
          if (((b)localObject).getPathName() != null) {
            localf.oJ.put(((b)localObject).getPathName(), localObject);
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
            localTypedArray = g.a(paramResources, paramTheme, paramAttributeSet, a.nm);
            ((a)localObject).a(localTypedArray);
            localTypedArray.recycle();
          }
          localc.mChildren.add(localObject);
          if (((a)localObject).getPathName() != null) {
            localf.oJ.put(((a)localObject).getPathName(), localObject);
          }
          localg.mChangingConfigurations |= ((a)localObject).mChangingConfigurations;
        }
        else
        {
          if ("group".equals(localObject))
          {
            localObject = new c();
            localTypedArray = g.a(paramResources, paramTheme, paramAttributeSet, a.nk);
            ((c)localObject).nV = null;
            ((c)localObject).oj = g.a(localTypedArray, paramXmlPullParser, "rotation", 5, ((c)localObject).oj);
            ((c)localObject).ok = localTypedArray.getFloat(1, ((c)localObject).ok);
            ((c)localObject).ol = localTypedArray.getFloat(2, ((c)localObject).ol);
            ((c)localObject).mScaleX = g.a(localTypedArray, paramXmlPullParser, "scaleX", 3, ((c)localObject).mScaleX);
            ((c)localObject).mScaleY = g.a(localTypedArray, paramXmlPullParser, "scaleY", 4, ((c)localObject).mScaleY);
            ((c)localObject).om = g.a(localTypedArray, paramXmlPullParser, "translateX", 6, ((c)localObject).om);
            ((c)localObject).oo = g.a(localTypedArray, paramXmlPullParser, "translateY", 7, ((c)localObject).oo);
            String str = localTypedArray.getString(0);
            if (str != null) {
              ((c)localObject).or = str;
            }
            ((c)localObject).bW();
            localTypedArray.recycle();
            localc.mChildren.add(localObject);
            localArrayDeque.push(localObject);
            if (((c)localObject).getGroupName() != null) {
              localf.oJ.put(((c)localObject).getGroupName(), localObject);
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
    if (this.nK != null) {
      android.support.v4.graphics.drawable.a.c(this.nK);
    }
    return false;
  }
  
  public final void draw(Canvas paramCanvas)
  {
    if (this.nK != null) {
      this.nK.draw(paramCanvas);
    }
    int i;
    int k;
    int m;
    do
    {
      do
      {
        return;
        copyBounds(this.nU);
      } while ((this.nU.width() <= 0) || (this.nU.height() <= 0));
      if (this.nO != null) {
        break;
      }
      localObject = this.nN;
      paramCanvas.getMatrix(this.nT);
      this.nT.getValues(this.nS);
      float f2 = Math.abs(this.nS[0]);
      float f1 = Math.abs(this.nS[4]);
      float f4 = Math.abs(this.nS[1]);
      float f3 = Math.abs(this.nS[3]);
      if ((f4 != 0.0F) || (f3 != 0.0F))
      {
        f1 = 1.0F;
        f2 = 1.0F;
      }
      j = (int)(f2 * this.nU.width());
      i = (int)(f1 * this.nU.height());
      k = Math.min(2048, j);
      m = Math.min(2048, i);
    } while ((k <= 0) || (m <= 0));
    int j = paramCanvas.save();
    paramCanvas.translate(this.nU.left, this.nU.top);
    label244:
    g localg;
    label322:
    label366:
    Rect localRect;
    if (Build.VERSION.SDK_INT >= 17) {
      if ((isAutoMirrored()) && (android.support.v4.graphics.drawable.a.f(this) == 1))
      {
        i = 1;
        if (i != 0)
        {
          paramCanvas.translate(this.nU.width(), 0.0F);
          paramCanvas.scale(-1.0F, 1.0F);
        }
        this.nU.offsetTo(0, 0);
        localg = this.nM;
        if (localg.oO != null)
        {
          if ((k != localg.oO.getWidth()) || (m != localg.oO.getHeight())) {
            break label450;
          }
          i = 1;
          if (i != 0) {}
        }
        else
        {
          localg.oO = Bitmap.createBitmap(k, m, Bitmap.Config.ARGB_8888);
          localg.oT = true;
        }
        if (this.nQ) {
          break label456;
        }
        this.nM.k(k, m);
        localg = this.nM;
        localRect = this.nU;
        if (localg.oK.getRootAlpha() >= 255) {
          break label608;
        }
        i = 1;
        label395:
        if ((i != 0) || (localObject != null)) {
          break label614;
        }
      }
    }
    for (Object localObject = null;; localObject = localg.oU)
    {
      paramCanvas.drawBitmap(localg.oO, null, localRect, (Paint)localObject);
      paramCanvas.restoreToCount(j);
      return;
      localObject = this.nO;
      break;
      i = 0;
      break label244;
      i = 0;
      break label244;
      label450:
      i = 0;
      break label322;
      label456:
      localg = this.nM;
      if ((!localg.oT) && (localg.oP == localg.oL) && (localg.oQ == localg.oM) && (localg.oS == localg.oN) && (localg.oR == localg.oK.getRootAlpha())) {}
      for (i = 1;; i = 0)
      {
        if (i != 0) {
          break label606;
        }
        this.nM.k(k, m);
        localg = this.nM;
        localg.oP = localg.oL;
        localg.oQ = localg.oM;
        localg.oR = localg.oK.getRootAlpha();
        localg.oS = localg.oN;
        localg.oT = false;
        break;
      }
      label606:
      break label366;
      label608:
      i = 0;
      break label395;
      label614:
      if (localg.oU == null)
      {
        localg.oU = new Paint();
        localg.oU.setFilterBitmap(true);
      }
      localg.oU.setAlpha(localg.oK.getRootAlpha());
      localg.oU.setColorFilter((ColorFilter)localObject);
    }
  }
  
  public final int getAlpha()
  {
    if (this.nK != null) {
      return android.support.v4.graphics.drawable.a.b(this.nK);
    }
    return this.nM.oK.getRootAlpha();
  }
  
  public final int getChangingConfigurations()
  {
    if (this.nK != null) {
      return this.nK.getChangingConfigurations();
    }
    return super.getChangingConfigurations() | this.nM.getChangingConfigurations();
  }
  
  public final Drawable.ConstantState getConstantState()
  {
    if ((this.nK != null) && (Build.VERSION.SDK_INT >= 24)) {
      return new h(this.nK.getConstantState());
    }
    this.nM.mChangingConfigurations = getChangingConfigurations();
    return this.nM;
  }
  
  public final int getIntrinsicHeight()
  {
    if (this.nK != null) {
      return this.nK.getIntrinsicHeight();
    }
    return (int)this.nM.oK.oD;
  }
  
  public final int getIntrinsicWidth()
  {
    if (this.nK != null) {
      return this.nK.getIntrinsicWidth();
    }
    return (int)this.nM.oK.oC;
  }
  
  public final int getOpacity()
  {
    if (this.nK != null) {
      return this.nK.getOpacity();
    }
    return -3;
  }
  
  public final void inflate(Resources paramResources, XmlPullParser paramXmlPullParser, AttributeSet paramAttributeSet)
  {
    if (this.nK != null)
    {
      this.nK.inflate(paramResources, paramXmlPullParser, paramAttributeSet);
      return;
    }
    inflate(paramResources, paramXmlPullParser, paramAttributeSet, null);
  }
  
  public final void inflate(Resources paramResources, XmlPullParser paramXmlPullParser, AttributeSet paramAttributeSet, Resources.Theme paramTheme)
  {
    if (this.nK != null)
    {
      android.support.v4.graphics.drawable.a.a(this.nK, paramResources, paramXmlPullParser, paramAttributeSet, paramTheme);
      return;
    }
    g localg1 = this.nM;
    localg1.oK = new f();
    TypedArray localTypedArray = g.a(paramResources, paramTheme, paramAttributeSet, a.nj);
    g localg2 = this.nM;
    f localf = localg2.oK;
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
      localg2.oM = ((PorterDuff.Mode)localObject);
      localObject = localTypedArray.getColorStateList(1);
      if (localObject != null) {
        localg2.oL = ((ColorStateList)localObject);
      }
      localg2.oN = g.a(localTypedArray, paramXmlPullParser, "autoMirrored", 5, localg2.oN);
      localf.oE = g.a(localTypedArray, paramXmlPullParser, "viewportWidth", 7, localf.oE);
      localf.oF = g.a(localTypedArray, paramXmlPullParser, "viewportHeight", 8, localf.oF);
      if (localf.oE > 0.0F) {
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
    if (localf.oF <= 0.0F) {
      throw new XmlPullParserException(localTypedArray.getPositionDescription() + "<vector> tag requires viewportHeight > 0");
    }
    localf.oC = localTypedArray.getDimension(3, localf.oC);
    localf.oD = localTypedArray.getDimension(2, localf.oD);
    if (localf.oC <= 0.0F) {
      throw new XmlPullParserException(localTypedArray.getPositionDescription() + "<vector> tag requires width > 0");
    }
    if (localf.oD <= 0.0F) {
      throw new XmlPullParserException(localTypedArray.getPositionDescription() + "<vector> tag requires height > 0");
    }
    localf.setAlpha(g.a(localTypedArray, paramXmlPullParser, "alpha", 4, localf.getAlpha()));
    localObject = localTypedArray.getString(0);
    if (localObject != null)
    {
      localf.oH = ((String)localObject);
      localf.oJ.put(localObject, localf);
    }
    localTypedArray.recycle();
    localg1.mChangingConfigurations = getChangingConfigurations();
    localg1.oT = true;
    b(paramResources, paramXmlPullParser, paramAttributeSet, paramTheme);
    this.nN = a(localg1.oL, localg1.oM);
  }
  
  public final void invalidateSelf()
  {
    if (this.nK != null)
    {
      this.nK.invalidateSelf();
      return;
    }
    super.invalidateSelf();
  }
  
  public final boolean isAutoMirrored()
  {
    if (this.nK != null) {
      return android.support.v4.graphics.drawable.a.a(this.nK);
    }
    return this.nM.oN;
  }
  
  public final boolean isStateful()
  {
    if (this.nK != null) {
      return this.nK.isStateful();
    }
    return (super.isStateful()) || ((this.nM != null) && ((this.nM.oK.isStateful()) || ((this.nM.oL != null) && (this.nM.oL.isStateful()))));
  }
  
  public final Drawable mutate()
  {
    if (this.nK != null) {
      this.nK.mutate();
    }
    while ((this.nP) || (super.mutate() != this)) {
      return this;
    }
    this.nM = new g(this.nM);
    this.nP = true;
    return this;
  }
  
  protected final void onBoundsChange(Rect paramRect)
  {
    if (this.nK != null) {
      this.nK.setBounds(paramRect);
    }
  }
  
  protected final boolean onStateChange(int[] paramArrayOfInt)
  {
    boolean bool2;
    if (this.nK != null) {
      bool2 = this.nK.setState(paramArrayOfInt);
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
        localg = this.nM;
        bool1 = bool2;
        if (localg.oL != null)
        {
          bool1 = bool2;
          if (localg.oM != null)
          {
            this.nN = a(localg.oL, localg.oM);
            invalidateSelf();
            bool1 = true;
          }
        }
        bool2 = bool1;
      } while (!localg.oK.isStateful());
      bool3 = localg.oK.oB.e(paramArrayOfInt);
      localg.oT |= bool3;
      bool2 = bool1;
    } while (!bool3);
    invalidateSelf();
    return true;
  }
  
  public final void scheduleSelf(Runnable paramRunnable, long paramLong)
  {
    if (this.nK != null)
    {
      this.nK.scheduleSelf(paramRunnable, paramLong);
      return;
    }
    super.scheduleSelf(paramRunnable, paramLong);
  }
  
  public final void setAlpha(int paramInt)
  {
    if (this.nK != null) {
      this.nK.setAlpha(paramInt);
    }
    while (this.nM.oK.getRootAlpha() == paramInt) {
      return;
    }
    this.nM.oK.setRootAlpha(paramInt);
    invalidateSelf();
  }
  
  public final void setAutoMirrored(boolean paramBoolean)
  {
    if (this.nK != null)
    {
      android.support.v4.graphics.drawable.a.a(this.nK, paramBoolean);
      return;
    }
    this.nM.oN = paramBoolean;
  }
  
  public final void setColorFilter(ColorFilter paramColorFilter)
  {
    if (this.nK != null)
    {
      this.nK.setColorFilter(paramColorFilter);
      return;
    }
    this.nO = paramColorFilter;
    invalidateSelf();
  }
  
  public final void setTint(int paramInt)
  {
    if (this.nK != null)
    {
      android.support.v4.graphics.drawable.a.a(this.nK, paramInt);
      return;
    }
    setTintList(ColorStateList.valueOf(paramInt));
  }
  
  public final void setTintList(ColorStateList paramColorStateList)
  {
    if (this.nK != null) {
      android.support.v4.graphics.drawable.a.a(this.nK, paramColorStateList);
    }
    g localg;
    do
    {
      return;
      localg = this.nM;
    } while (localg.oL == paramColorStateList);
    localg.oL = paramColorStateList;
    this.nN = a(paramColorStateList, localg.oM);
    invalidateSelf();
  }
  
  public final void setTintMode(PorterDuff.Mode paramMode)
  {
    if (this.nK != null) {
      android.support.v4.graphics.drawable.a.a(this.nK, paramMode);
    }
    g localg;
    do
    {
      return;
      localg = this.nM;
    } while (localg.oM == paramMode);
    localg.oM = paramMode;
    this.nN = a(localg.oL, paramMode);
    invalidateSelf();
  }
  
  public final boolean setVisible(boolean paramBoolean1, boolean paramBoolean2)
  {
    if (this.nK != null) {
      return this.nK.setVisible(paramBoolean1, paramBoolean2);
    }
    return super.setVisible(paramBoolean1, paramBoolean2);
  }
  
  public final void unscheduleSelf(Runnable paramRunnable)
  {
    if (this.nK != null)
    {
      this.nK.unscheduleSelf(paramRunnable);
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
        this.ot = str;
      }
      paramTypedArray = paramTypedArray.getString(1);
      if (paramTypedArray != null) {
        this.os = c.K(paramTypedArray);
      }
    }
    
    public final boolean bV()
    {
      return true;
    }
  }
  
  static final class b
    extends i.e
  {
    private int[] nV;
    b nW;
    float nX = 0.0F;
    b nY;
    float nZ = 1.0F;
    int oa = 0;
    float ob = 1.0F;
    float oc = 0.0F;
    float od = 1.0F;
    float oe = 0.0F;
    Paint.Cap of = Paint.Cap.BUTT;
    Paint.Join og = Paint.Join.MITER;
    float oh = 4.0F;
    
    public b() {}
    
    public b(b paramb)
    {
      super();
      this.nV = paramb.nV;
      this.nW = paramb.nW;
      this.nX = paramb.nX;
      this.nZ = paramb.nZ;
      this.nY = paramb.nY;
      this.oa = paramb.oa;
      this.ob = paramb.ob;
      this.oc = paramb.oc;
      this.od = paramb.od;
      this.oe = paramb.oe;
      this.of = paramb.of;
      this.og = paramb.og;
      this.oh = paramb.oh;
    }
    
    final void a(TypedArray paramTypedArray, XmlPullParser paramXmlPullParser, Resources.Theme paramTheme)
    {
      this.nV = null;
      if (!g.a(paramXmlPullParser, "pathData")) {
        return;
      }
      Object localObject = paramTypedArray.getString(0);
      if (localObject != null) {
        this.ot = ((String)localObject);
      }
      localObject = paramTypedArray.getString(2);
      if (localObject != null) {
        this.os = c.K((String)localObject);
      }
      this.nY = g.a(paramTypedArray, paramXmlPullParser, paramTheme, "fillColor", 1);
      this.ob = g.a(paramTypedArray, paramXmlPullParser, "fillAlpha", 12, this.ob);
      int i = g.a(paramTypedArray, paramXmlPullParser, "strokeLineCap", 8, -1);
      localObject = this.of;
      switch (i)
      {
      default: 
        this.of = ((Paint.Cap)localObject);
        i = g.a(paramTypedArray, paramXmlPullParser, "strokeLineJoin", 9, -1);
        localObject = this.og;
        switch (i)
        {
        }
        break;
      }
      for (;;)
      {
        this.og = ((Paint.Join)localObject);
        this.oh = g.a(paramTypedArray, paramXmlPullParser, "strokeMiterLimit", 10, this.oh);
        this.nW = g.a(paramTypedArray, paramXmlPullParser, paramTheme, "strokeColor", 3);
        this.nZ = g.a(paramTypedArray, paramXmlPullParser, "strokeAlpha", 11, this.nZ);
        this.nX = g.a(paramTypedArray, paramXmlPullParser, "strokeWidth", 4, this.nX);
        this.od = g.a(paramTypedArray, paramXmlPullParser, "trimPathEnd", 6, this.od);
        this.oe = g.a(paramTypedArray, paramXmlPullParser, "trimPathOffset", 7, this.oe);
        this.oc = g.a(paramTypedArray, paramXmlPullParser, "trimPathStart", 5, this.oc);
        this.oa = g.a(paramTypedArray, paramXmlPullParser, "fillType", 13, this.oa);
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
      return this.nY.e(paramArrayOfInt) | this.nW.e(paramArrayOfInt);
    }
    
    final float getFillAlpha()
    {
      return this.ob;
    }
    
    final int getFillColor()
    {
      return this.nY.mColor;
    }
    
    final float getStrokeAlpha()
    {
      return this.nZ;
    }
    
    final int getStrokeColor()
    {
      return this.nW.mColor;
    }
    
    final float getStrokeWidth()
    {
      return this.nX;
    }
    
    final float getTrimPathEnd()
    {
      return this.od;
    }
    
    final float getTrimPathOffset()
    {
      return this.oe;
    }
    
    final float getTrimPathStart()
    {
      return this.oc;
    }
    
    public final boolean isStateful()
    {
      return (this.nY.isStateful()) || (this.nW.isStateful());
    }
    
    final void setFillAlpha(float paramFloat)
    {
      this.ob = paramFloat;
    }
    
    final void setFillColor(int paramInt)
    {
      this.nY.mColor = paramInt;
    }
    
    final void setStrokeAlpha(float paramFloat)
    {
      this.nZ = paramFloat;
    }
    
    final void setStrokeColor(int paramInt)
    {
      this.nW.mColor = paramInt;
    }
    
    final void setStrokeWidth(float paramFloat)
    {
      this.nX = paramFloat;
    }
    
    final void setTrimPathEnd(float paramFloat)
    {
      this.od = paramFloat;
    }
    
    final void setTrimPathOffset(float paramFloat)
    {
      this.oe = paramFloat;
    }
    
    final void setTrimPathStart(float paramFloat)
    {
      this.oc = paramFloat;
    }
  }
  
  static final class c
    extends i.d
  {
    int mChangingConfigurations;
    final ArrayList<i.d> mChildren = new ArrayList();
    float mScaleX = 1.0F;
    float mScaleY = 1.0F;
    int[] nV;
    final Matrix oi = new Matrix();
    float oj = 0.0F;
    float ok = 0.0F;
    float ol = 0.0F;
    float om = 0.0F;
    float oo = 0.0F;
    final Matrix oq = new Matrix();
    String or = null;
    
    public c()
    {
      super();
    }
    
    public c(c paramc, android.support.v4.e.a<String, Object> parama)
    {
      super();
      this.oj = paramc.oj;
      this.ok = paramc.ok;
      this.ol = paramc.ol;
      this.mScaleX = paramc.mScaleX;
      this.mScaleY = paramc.mScaleY;
      this.om = paramc.om;
      this.oo = paramc.oo;
      this.nV = paramc.nV;
      this.or = paramc.or;
      this.mChangingConfigurations = paramc.mChangingConfigurations;
      if (this.or != null) {
        parama.put(this.or, this);
      }
      this.oq.set(paramc.oq);
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
            if (paramc.ot == null) {
              break;
            }
            parama.put(paramc.ot, paramc);
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
    
    final void bW()
    {
      this.oq.reset();
      this.oq.postTranslate(-this.ok, -this.ol);
      this.oq.postScale(this.mScaleX, this.mScaleY);
      this.oq.postRotate(this.oj, 0.0F, 0.0F);
      this.oq.postTranslate(this.om + this.ok, this.oo + this.ol);
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
      return this.or;
    }
    
    public final Matrix getLocalMatrix()
    {
      return this.oq;
    }
    
    public final float getPivotX()
    {
      return this.ok;
    }
    
    public final float getPivotY()
    {
      return this.ol;
    }
    
    public final float getRotation()
    {
      return this.oj;
    }
    
    public final float getScaleX()
    {
      return this.mScaleX;
    }
    
    public final float getScaleY()
    {
      return this.mScaleY;
    }
    
    public final float getTranslateX()
    {
      return this.om;
    }
    
    public final float getTranslateY()
    {
      return this.oo;
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
      if (paramFloat != this.ok)
      {
        this.ok = paramFloat;
        bW();
      }
    }
    
    public final void setPivotY(float paramFloat)
    {
      if (paramFloat != this.ol)
      {
        this.ol = paramFloat;
        bW();
      }
    }
    
    public final void setRotation(float paramFloat)
    {
      if (paramFloat != this.oj)
      {
        this.oj = paramFloat;
        bW();
      }
    }
    
    public final void setScaleX(float paramFloat)
    {
      if (paramFloat != this.mScaleX)
      {
        this.mScaleX = paramFloat;
        bW();
      }
    }
    
    public final void setScaleY(float paramFloat)
    {
      if (paramFloat != this.mScaleY)
      {
        this.mScaleY = paramFloat;
        bW();
      }
    }
    
    public final void setTranslateX(float paramFloat)
    {
      if (paramFloat != this.om)
      {
        this.om = paramFloat;
        bW();
      }
    }
    
    public final void setTranslateY(float paramFloat)
    {
      if (paramFloat != this.oo)
      {
        this.oo = paramFloat;
        bW();
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
    protected c.b[] os = null;
    String ot;
    
    public e()
    {
      super();
    }
    
    public e(e parame)
    {
      super();
      this.ot = parame.ot;
      this.mChangingConfigurations = parame.mChangingConfigurations;
      this.os = c.a(parame.os);
    }
    
    public final void b(Path paramPath)
    {
      paramPath.reset();
      if (this.os != null) {
        c.b.a(this.os, paramPath);
      }
    }
    
    public boolean bV()
    {
      return false;
    }
    
    public c.b[] getPathData()
    {
      return this.os;
    }
    
    public String getPathName()
    {
      return this.ot;
    }
    
    public void setPathData(c.b[] paramArrayOfb)
    {
      if (!c.a(this.os, paramArrayOfb)) {
        this.os = c.a(paramArrayOfb);
      }
      for (;;)
      {
        return;
        c.b[] arrayOfb = this.os;
        int i = 0;
        while (i < paramArrayOfb.length)
        {
          arrayOfb[i].Ay = paramArrayOfb[i].Ay;
          int j = 0;
          while (j < paramArrayOfb[i].Az.length)
          {
            arrayOfb[i].Az[j] = paramArrayOfb[i].Az[j];
            j += 1;
          }
          i += 1;
        }
      }
    }
  }
  
  static final class f
  {
    private static final Matrix ow = new Matrix();
    private int mChangingConfigurations;
    private PathMeasure oA;
    final i.c oB;
    float oC = 0.0F;
    float oD = 0.0F;
    float oE = 0.0F;
    float oF = 0.0F;
    int oG = 255;
    String oH = null;
    Boolean oI = null;
    final android.support.v4.e.a<String, Object> oJ = new android.support.v4.e.a();
    private final Path ou;
    private final Path ov;
    private final Matrix ox = new Matrix();
    Paint oy;
    Paint oz;
    
    public f()
    {
      this.oB = new i.c();
      this.ou = new Path();
      this.ov = new Path();
    }
    
    public f(f paramf)
    {
      this.oB = new i.c(paramf.oB, this.oJ);
      this.ou = new Path(paramf.ou);
      this.ov = new Path(paramf.ov);
      this.oC = paramf.oC;
      this.oD = paramf.oD;
      this.oE = paramf.oE;
      this.oF = paramf.oF;
      this.mChangingConfigurations = paramf.mChangingConfigurations;
      this.oG = paramf.oG;
      this.oH = paramf.oH;
      if (paramf.oH != null) {
        this.oJ.put(paramf.oH, this);
      }
      this.oI = paramf.oI;
    }
    
    private void a(i.c paramc, Matrix paramMatrix, Canvas paramCanvas, int paramInt1, int paramInt2, ColorFilter paramColorFilter)
    {
      paramc.oi.set(paramMatrix);
      paramc.oi.preConcat(paramc.oq);
      paramCanvas.save();
      int i = 0;
      if (i < paramc.mChildren.size())
      {
        paramMatrix = (i.d)paramc.mChildren.get(i);
        if ((paramMatrix instanceof i.c)) {
          a((i.c)paramMatrix, paramc.oi, paramCanvas, paramInt1, paramInt2, paramColorFilter);
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
          float f1 = paramInt1 / this.oE;
          float f3 = paramInt2 / this.oF;
          float f2 = Math.min(f1, f3);
          Object localObject1 = paramc.oi;
          this.ox.set((Matrix)localObject1);
          this.ox.postScale(f1, f3);
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
            paramMatrix.b(this.ou);
            localObject2 = this.ou;
            this.ov.reset();
            if (paramMatrix.bV())
            {
              this.ov.addPath((Path)localObject2, this.ox);
              paramCanvas.clipPath(this.ov);
              break;
            }
            localObject1 = (i.b)paramMatrix;
            if ((((i.b)localObject1).oc != 0.0F) || (((i.b)localObject1).od != 1.0F))
            {
              f6 = ((i.b)localObject1).oc;
              f7 = ((i.b)localObject1).oe;
              f4 = ((i.b)localObject1).od;
              f5 = ((i.b)localObject1).oe;
              if (this.oA == null) {
                this.oA = new PathMeasure();
              }
              this.oA.setPath(this.ou, false);
              f3 = this.oA.getLength();
              f6 = (f6 + f7) % 1.0F * f3;
              f4 = (f4 + f5) % 1.0F * f3;
              ((Path)localObject2).reset();
              if (f6 > f4)
              {
                this.oA.getSegment(f6, f3, (Path)localObject2, true);
                this.oA.getSegment(0.0F, f4, (Path)localObject2, true);
                label497:
                ((Path)localObject2).rLineTo(0.0F, 0.0F);
              }
            }
            else
            {
              this.ov.addPath((Path)localObject2, this.ox);
              if (((i.b)localObject1).nY.cN())
              {
                paramMatrix = ((i.b)localObject1).nY;
                if (this.oz == null)
                {
                  this.oz = new Paint(1);
                  this.oz.setStyle(Paint.Style.FILL);
                }
                localObject2 = this.oz;
                if (!paramMatrix.cM()) {
                  break label847;
                }
                paramMatrix = paramMatrix.Af;
                paramMatrix.setLocalMatrix(this.ox);
                ((Paint)localObject2).setShader(paramMatrix);
                ((Paint)localObject2).setAlpha(Math.round(((i.b)localObject1).ob * 255.0F));
                label612:
                ((Paint)localObject2).setColorFilter(paramColorFilter);
                Path localPath = this.ov;
                if (((i.b)localObject1).oa != 0) {
                  break label867;
                }
                paramMatrix = Path.FillType.WINDING;
                label638:
                localPath.setFillType(paramMatrix);
                paramCanvas.drawPath(this.ov, (Paint)localObject2);
              }
              if (!((i.b)localObject1).nW.cN()) {
                break;
              }
              localObject2 = ((i.b)localObject1).nW;
              if (this.oy == null)
              {
                this.oy = new Paint(1);
                this.oy.setStyle(Paint.Style.STROKE);
              }
              paramMatrix = this.oy;
              if (((i.b)localObject1).og != null) {
                paramMatrix.setStrokeJoin(((i.b)localObject1).og);
              }
              if (((i.b)localObject1).of != null) {
                paramMatrix.setStrokeCap(((i.b)localObject1).of);
              }
              paramMatrix.setStrokeMiter(((i.b)localObject1).oh);
              if (!((b)localObject2).cM()) {
                break label874;
              }
              localObject2 = ((b)localObject2).Af;
              ((Shader)localObject2).setLocalMatrix(this.ox);
              paramMatrix.setShader((Shader)localObject2);
              paramMatrix.setAlpha(Math.round(((i.b)localObject1).nZ * 255.0F));
            }
            for (;;)
            {
              paramMatrix.setColorFilter(paramColorFilter);
              paramMatrix.setStrokeWidth(((i.b)localObject1).nX * (f2 * f1));
              paramCanvas.drawPath(this.ov, paramMatrix);
              break;
              this.oA.getSegment(f6, f4, (Path)localObject2, true);
              break label497;
              label847:
              ((Paint)localObject2).setColor(i.d(paramMatrix.mColor, ((i.b)localObject1).ob));
              break label612;
              label867:
              paramMatrix = Path.FillType.EVEN_ODD;
              break label638;
              label874:
              paramMatrix.setColor(i.d(((b)localObject2).mColor, ((i.b)localObject1).nZ));
            }
            paramCanvas.restore();
            return;
          }
        }
      }
    }
    
    public final void a(Canvas paramCanvas, int paramInt1, int paramInt2)
    {
      a(this.oB, ow, paramCanvas, paramInt1, paramInt2, null);
    }
    
    public final float getAlpha()
    {
      return getRootAlpha() / 255.0F;
    }
    
    public final int getRootAlpha()
    {
      return this.oG;
    }
    
    public final boolean isStateful()
    {
      if (this.oI == null) {
        this.oI = Boolean.valueOf(this.oB.isStateful());
      }
      return this.oI.booleanValue();
    }
    
    public final void setAlpha(float paramFloat)
    {
      setRootAlpha((int)(255.0F * paramFloat));
    }
    
    public final void setRootAlpha(int paramInt)
    {
      this.oG = paramInt;
    }
  }
  
  static final class g
    extends Drawable.ConstantState
  {
    int mChangingConfigurations;
    i.f oK;
    ColorStateList oL = null;
    PorterDuff.Mode oM = i.nL;
    boolean oN;
    Bitmap oO;
    ColorStateList oP;
    PorterDuff.Mode oQ;
    int oR;
    boolean oS;
    boolean oT;
    Paint oU;
    
    public g()
    {
      this.oK = new i.f();
    }
    
    public g(g paramg)
    {
      if (paramg != null)
      {
        this.mChangingConfigurations = paramg.mChangingConfigurations;
        this.oK = new i.f(paramg.oK);
        if (paramg.oK.oz != null) {
          this.oK.oz = new Paint(paramg.oK.oz);
        }
        if (paramg.oK.oy != null) {
          this.oK.oy = new Paint(paramg.oK.oy);
        }
        this.oL = paramg.oL;
        this.oM = paramg.oM;
        this.oN = paramg.oN;
      }
    }
    
    public final int getChangingConfigurations()
    {
      return this.mChangingConfigurations;
    }
    
    public final void k(int paramInt1, int paramInt2)
    {
      this.oO.eraseColor(0);
      Canvas localCanvas = new Canvas(this.oO);
      this.oK.a(localCanvas, paramInt1, paramInt2);
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
    private final Drawable.ConstantState nF;
    
    public h(Drawable.ConstantState paramConstantState)
    {
      this.nF = paramConstantState;
    }
    
    public final boolean canApplyTheme()
    {
      return this.nF.canApplyTheme();
    }
    
    public final int getChangingConfigurations()
    {
      return this.nF.getChangingConfigurations();
    }
    
    public final Drawable newDrawable()
    {
      i locali = new i();
      locali.nK = ((VectorDrawable)this.nF.newDrawable());
      return locali;
    }
    
    public final Drawable newDrawable(Resources paramResources)
    {
      i locali = new i();
      locali.nK = ((VectorDrawable)this.nF.newDrawable(paramResources));
      return locali;
    }
    
    public final Drawable newDrawable(Resources paramResources, Resources.Theme paramTheme)
    {
      i locali = new i();
      locali.nK = ((VectorDrawable)this.nF.newDrawable(paramResources, paramTheme));
      return locali;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     android.support.c.a.i
 * JD-Core Version:    0.7.0.1
 */