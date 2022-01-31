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
import android.graphics.drawable.Drawable;
import android.graphics.drawable.Drawable.ConstantState;
import android.graphics.drawable.VectorDrawable;
import android.os.Build.VERSION;
import android.support.v4.a.c.b;
import android.support.v4.content.a.b;
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
  static final PorterDuff.Mode mO = PorterDuff.Mode.SRC_IN;
  f mP;
  private PorterDuffColorFilter mQ;
  private ColorFilter mR;
  private boolean mS;
  boolean mT = true;
  private Drawable.ConstantState mU;
  private final float[] mV = new float[9];
  private final Matrix mW = new Matrix();
  private final Rect mX = new Rect();
  
  i()
  {
    this.mP = new f();
  }
  
  i(f paramf)
  {
    this.mP = paramf;
    this.mQ = a(paramf.nM, paramf.nN);
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
      ((i)localObject).mN = b.b(paramResources, paramInt, paramTheme);
      ((i)localObject).mU = new g(((i)localObject).mN.getConstantState());
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
    f localf = this.mP;
    e locale = localf.nL;
    int i = 1;
    ArrayDeque localArrayDeque = new ArrayDeque();
    localArrayDeque.push(locale.nD);
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
          localTypedArray = android.support.v4.content.a.c.a(paramResources, paramTheme, paramAttributeSet, a.mo);
          ((b)localObject).a(localTypedArray, paramXmlPullParser);
          localTypedArray.recycle();
          localc.nm.add(localObject);
          if (((d)localObject).nv != null) {
            locale.nK.put(((d)localObject).nv, localObject);
          }
          i = 0;
          j = localf.mChangingConfigurations;
          localf.mChangingConfigurations = (((b)localObject).mChangingConfigurations | j);
        }
      }
      for (;;)
      {
        j = paramXmlPullParser.next();
        break;
        if ("clip-path".equals(localObject))
        {
          localObject = new a();
          if (android.support.v4.content.a.c.a(paramXmlPullParser, "pathData"))
          {
            localTypedArray = android.support.v4.content.a.c.a(paramResources, paramTheme, paramAttributeSet, a.mp);
            ((a)localObject).a(localTypedArray);
            localTypedArray.recycle();
          }
          localc.nm.add(localObject);
          if (((d)localObject).nv != null) {
            locale.nK.put(((d)localObject).nv, localObject);
          }
          localf.mChangingConfigurations |= ((a)localObject).mChangingConfigurations;
        }
        else
        {
          if ("group".equals(localObject))
          {
            localObject = new c();
            localTypedArray = android.support.v4.content.a.c.a(paramResources, paramTheme, paramAttributeSet, a.mn);
            ((c)localObject).mY = null;
            ((c)localObject).nn = android.support.v4.content.a.c.a(localTypedArray, paramXmlPullParser, "rotation", 5, ((c)localObject).nn);
            ((c)localObject).no = localTypedArray.getFloat(1, ((c)localObject).no);
            ((c)localObject).np = localTypedArray.getFloat(2, ((c)localObject).np);
            ((c)localObject).mScaleX = android.support.v4.content.a.c.a(localTypedArray, paramXmlPullParser, "scaleX", 3, ((c)localObject).mScaleX);
            ((c)localObject).mScaleY = android.support.v4.content.a.c.a(localTypedArray, paramXmlPullParser, "scaleY", 4, ((c)localObject).mScaleY);
            ((c)localObject).nq = android.support.v4.content.a.c.a(localTypedArray, paramXmlPullParser, "translateX", 6, ((c)localObject).nq);
            ((c)localObject).nr = android.support.v4.content.a.c.a(localTypedArray, paramXmlPullParser, "translateY", 7, ((c)localObject).nr);
            String str = localTypedArray.getString(0);
            if (str != null) {
              ((c)localObject).nt = str;
            }
            ((c)localObject).ns.reset();
            ((c)localObject).ns.postTranslate(-((c)localObject).no, -((c)localObject).np);
            ((c)localObject).ns.postScale(((c)localObject).mScaleX, ((c)localObject).mScaleY);
            ((c)localObject).ns.postRotate(((c)localObject).nn, 0.0F, 0.0F);
            ((c)localObject).ns.postTranslate(((c)localObject).nq + ((c)localObject).no, ((c)localObject).nr + ((c)localObject).np);
            localTypedArray.recycle();
            localc.nm.add(localObject);
            localArrayDeque.push(localObject);
            if (((c)localObject).nt != null) {
              locale.nK.put(((c)localObject).nt, localObject);
            }
            localf.mChangingConfigurations |= ((c)localObject).mChangingConfigurations;
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
  
  static int c(int paramInt, float paramFloat)
  {
    return (int)(Color.alpha(paramInt) * paramFloat) << 24 | 0xFFFFFF & paramInt;
  }
  
  public final boolean canApplyTheme()
  {
    if (this.mN != null) {
      android.support.v4.a.a.a.d(this.mN);
    }
    return false;
  }
  
  public final void draw(Canvas paramCanvas)
  {
    if (this.mN != null) {
      this.mN.draw(paramCanvas);
    }
    int i;
    int k;
    int m;
    do
    {
      do
      {
        return;
        copyBounds(this.mX);
      } while ((this.mX.width() <= 0) || (this.mX.height() <= 0));
      if (this.mR != null) {
        break;
      }
      localObject = this.mQ;
      paramCanvas.getMatrix(this.mW);
      this.mW.getValues(this.mV);
      float f2 = Math.abs(this.mV[0]);
      float f1 = Math.abs(this.mV[4]);
      float f4 = Math.abs(this.mV[1]);
      float f3 = Math.abs(this.mV[3]);
      if ((f4 != 0.0F) || (f3 != 0.0F))
      {
        f1 = 1.0F;
        f2 = 1.0F;
      }
      j = (int)(f2 * this.mX.width());
      i = (int)(f1 * this.mX.height());
      k = Math.min(2048, j);
      m = Math.min(2048, i);
    } while ((k <= 0) || (m <= 0));
    int j = paramCanvas.save();
    paramCanvas.translate(this.mX.left, this.mX.top);
    label244:
    f localf;
    label322:
    label366:
    Rect localRect;
    if (Build.VERSION.SDK_INT >= 17) {
      if ((isAutoMirrored()) && (android.support.v4.a.a.a.g(this) == 1))
      {
        i = 1;
        if (i != 0)
        {
          paramCanvas.translate(this.mX.width(), 0.0F);
          paramCanvas.scale(-1.0F, 1.0F);
        }
        this.mX.offsetTo(0, 0);
        localf = this.mP;
        if (localf.nP != null)
        {
          if ((k != localf.nP.getWidth()) || (m != localf.nP.getHeight())) {
            break label450;
          }
          i = 1;
          if (i != 0) {}
        }
        else
        {
          localf.nP = Bitmap.createBitmap(k, m, Bitmap.Config.ARGB_8888);
          localf.nU = true;
        }
        if (this.mT) {
          break label456;
        }
        this.mP.k(k, m);
        localf = this.mP;
        localRect = this.mX;
        if (localf.nL.nI >= 255) {
          break label608;
        }
        i = 1;
        label395:
        if ((i != 0) || (localObject != null)) {
          break label614;
        }
      }
    }
    for (Object localObject = null;; localObject = localf.nV)
    {
      paramCanvas.drawBitmap(localf.nP, null, localRect, (Paint)localObject);
      paramCanvas.restoreToCount(j);
      return;
      localObject = this.mR;
      break;
      i = 0;
      break label244;
      i = 0;
      break label244;
      label450:
      i = 0;
      break label322;
      label456:
      localf = this.mP;
      if ((!localf.nU) && (localf.nQ == localf.nM) && (localf.nR == localf.nN) && (localf.nT == localf.nO) && (localf.nS == localf.nL.nI)) {}
      for (i = 1;; i = 0)
      {
        if (i != 0) {
          break label606;
        }
        this.mP.k(k, m);
        localf = this.mP;
        localf.nQ = localf.nM;
        localf.nR = localf.nN;
        localf.nS = localf.nL.nI;
        localf.nT = localf.nO;
        localf.nU = false;
        break;
      }
      label606:
      break label366;
      label608:
      i = 0;
      break label395;
      label614:
      if (localf.nV == null)
      {
        localf.nV = new Paint();
        localf.nV.setFilterBitmap(true);
      }
      localf.nV.setAlpha(localf.nL.nI);
      localf.nV.setColorFilter((ColorFilter)localObject);
    }
  }
  
  public final int getAlpha()
  {
    if (this.mN != null) {
      return android.support.v4.a.a.a.c(this.mN);
    }
    return this.mP.nL.nI;
  }
  
  public final int getChangingConfigurations()
  {
    if (this.mN != null) {
      return this.mN.getChangingConfigurations();
    }
    return super.getChangingConfigurations() | this.mP.getChangingConfigurations();
  }
  
  public final Drawable.ConstantState getConstantState()
  {
    if ((this.mN != null) && (Build.VERSION.SDK_INT >= 24)) {
      return new g(this.mN.getConstantState());
    }
    this.mP.mChangingConfigurations = getChangingConfigurations();
    return this.mP;
  }
  
  public final int getIntrinsicHeight()
  {
    if (this.mN != null) {
      return this.mN.getIntrinsicHeight();
    }
    return (int)this.mP.nL.nF;
  }
  
  public final int getIntrinsicWidth()
  {
    if (this.mN != null) {
      return this.mN.getIntrinsicWidth();
    }
    return (int)this.mP.nL.nE;
  }
  
  public final int getOpacity()
  {
    if (this.mN != null) {
      return this.mN.getOpacity();
    }
    return -3;
  }
  
  public final void inflate(Resources paramResources, XmlPullParser paramXmlPullParser, AttributeSet paramAttributeSet)
  {
    if (this.mN != null)
    {
      this.mN.inflate(paramResources, paramXmlPullParser, paramAttributeSet);
      return;
    }
    inflate(paramResources, paramXmlPullParser, paramAttributeSet, null);
  }
  
  public final void inflate(Resources paramResources, XmlPullParser paramXmlPullParser, AttributeSet paramAttributeSet, Resources.Theme paramTheme)
  {
    if (this.mN != null)
    {
      android.support.v4.a.a.a.a(this.mN, paramResources, paramXmlPullParser, paramAttributeSet, paramTheme);
      return;
    }
    f localf1 = this.mP;
    localf1.nL = new e();
    TypedArray localTypedArray = android.support.v4.content.a.c.a(paramResources, paramTheme, paramAttributeSet, a.mm);
    f localf2 = this.mP;
    e locale = localf2.nL;
    int i = android.support.v4.content.a.c.a(localTypedArray, paramXmlPullParser, "tintMode", 6, -1);
    PorterDuff.Mode localMode = PorterDuff.Mode.SRC_IN;
    Object localObject = localMode;
    switch (i)
    {
    default: 
      localObject = localMode;
    }
    for (;;)
    {
      localf2.nN = ((PorterDuff.Mode)localObject);
      localObject = localTypedArray.getColorStateList(1);
      if (localObject != null) {
        localf2.nM = ((ColorStateList)localObject);
      }
      localf2.nO = android.support.v4.content.a.c.a(localTypedArray, paramXmlPullParser, "autoMirrored", 5, localf2.nO);
      locale.nG = android.support.v4.content.a.c.a(localTypedArray, paramXmlPullParser, "viewportWidth", 7, locale.nG);
      locale.nH = android.support.v4.content.a.c.a(localTypedArray, paramXmlPullParser, "viewportHeight", 8, locale.nH);
      if (locale.nG > 0.0F) {
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
    if (locale.nH <= 0.0F) {
      throw new XmlPullParserException(localTypedArray.getPositionDescription() + "<vector> tag requires viewportHeight > 0");
    }
    locale.nE = localTypedArray.getDimension(3, locale.nE);
    locale.nF = localTypedArray.getDimension(2, locale.nF);
    if (locale.nE <= 0.0F) {
      throw new XmlPullParserException(localTypedArray.getPositionDescription() + "<vector> tag requires width > 0");
    }
    if (locale.nF <= 0.0F) {
      throw new XmlPullParserException(localTypedArray.getPositionDescription() + "<vector> tag requires height > 0");
    }
    locale.nI = ((int)(android.support.v4.content.a.c.a(localTypedArray, paramXmlPullParser, "alpha", 4, locale.nI / 255.0F) * 255.0F));
    localObject = localTypedArray.getString(0);
    if (localObject != null)
    {
      locale.nJ = ((String)localObject);
      locale.nK.put(localObject, locale);
    }
    localTypedArray.recycle();
    localf1.mChangingConfigurations = getChangingConfigurations();
    localf1.nU = true;
    b(paramResources, paramXmlPullParser, paramAttributeSet, paramTheme);
    this.mQ = a(localf1.nM, localf1.nN);
  }
  
  public final void invalidateSelf()
  {
    if (this.mN != null)
    {
      this.mN.invalidateSelf();
      return;
    }
    super.invalidateSelf();
  }
  
  public final boolean isAutoMirrored()
  {
    if (this.mN != null) {
      return android.support.v4.a.a.a.b(this.mN);
    }
    return this.mP.nO;
  }
  
  public final boolean isStateful()
  {
    if (this.mN != null) {
      return this.mN.isStateful();
    }
    return (super.isStateful()) || ((this.mP != null) && (this.mP.nM != null) && (this.mP.nM.isStateful()));
  }
  
  public final Drawable mutate()
  {
    if (this.mN != null) {
      this.mN.mutate();
    }
    while ((this.mS) || (super.mutate() != this)) {
      return this;
    }
    this.mP = new f(this.mP);
    this.mS = true;
    return this;
  }
  
  protected final void onBoundsChange(Rect paramRect)
  {
    if (this.mN != null) {
      this.mN.setBounds(paramRect);
    }
  }
  
  protected final boolean onStateChange(int[] paramArrayOfInt)
  {
    if (this.mN != null) {
      return this.mN.setState(paramArrayOfInt);
    }
    paramArrayOfInt = this.mP;
    if ((paramArrayOfInt.nM != null) && (paramArrayOfInt.nN != null))
    {
      this.mQ = a(paramArrayOfInt.nM, paramArrayOfInt.nN);
      invalidateSelf();
      return true;
    }
    return false;
  }
  
  public final void scheduleSelf(Runnable paramRunnable, long paramLong)
  {
    if (this.mN != null)
    {
      this.mN.scheduleSelf(paramRunnable, paramLong);
      return;
    }
    super.scheduleSelf(paramRunnable, paramLong);
  }
  
  public final void setAlpha(int paramInt)
  {
    if (this.mN != null) {
      this.mN.setAlpha(paramInt);
    }
    while (this.mP.nL.nI == paramInt) {
      return;
    }
    this.mP.nL.nI = paramInt;
    invalidateSelf();
  }
  
  public final void setAutoMirrored(boolean paramBoolean)
  {
    if (this.mN != null)
    {
      android.support.v4.a.a.a.a(this.mN, paramBoolean);
      return;
    }
    this.mP.nO = paramBoolean;
  }
  
  public final void setColorFilter(ColorFilter paramColorFilter)
  {
    if (this.mN != null)
    {
      this.mN.setColorFilter(paramColorFilter);
      return;
    }
    this.mR = paramColorFilter;
    invalidateSelf();
  }
  
  public final void setTint(int paramInt)
  {
    if (this.mN != null)
    {
      android.support.v4.a.a.a.a(this.mN, paramInt);
      return;
    }
    setTintList(ColorStateList.valueOf(paramInt));
  }
  
  public final void setTintList(ColorStateList paramColorStateList)
  {
    if (this.mN != null) {
      android.support.v4.a.a.a.a(this.mN, paramColorStateList);
    }
    f localf;
    do
    {
      return;
      localf = this.mP;
    } while (localf.nM == paramColorStateList);
    localf.nM = paramColorStateList;
    this.mQ = a(paramColorStateList, localf.nN);
    invalidateSelf();
  }
  
  public final void setTintMode(PorterDuff.Mode paramMode)
  {
    if (this.mN != null) {
      android.support.v4.a.a.a.a(this.mN, paramMode);
    }
    f localf;
    do
    {
      return;
      localf = this.mP;
    } while (localf.nN == paramMode);
    localf.nN = paramMode;
    this.mQ = a(localf.nM, paramMode);
    invalidateSelf();
  }
  
  public final boolean setVisible(boolean paramBoolean1, boolean paramBoolean2)
  {
    if (this.mN != null) {
      return this.mN.setVisible(paramBoolean1, paramBoolean2);
    }
    return super.setVisible(paramBoolean1, paramBoolean2);
  }
  
  public final void unscheduleSelf(Runnable paramRunnable)
  {
    if (this.mN != null)
    {
      this.mN.unscheduleSelf(paramRunnable);
      return;
    }
    super.unscheduleSelf(paramRunnable);
  }
  
  private static final class a
    extends i.d
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
        this.nv = str;
      }
      paramTypedArray = paramTypedArray.getString(1);
      if (paramTypedArray != null) {
        this.nu = android.support.v4.a.c.J(paramTypedArray);
      }
    }
    
    public final boolean bk()
    {
      return true;
    }
  }
  
  private static final class b
    extends i.d
  {
    private int[] mY;
    int mZ = 0;
    float na = 0.0F;
    int nb = 0;
    float nc = 1.0F;
    int nd = 0;
    float ne = 1.0F;
    float nf = 0.0F;
    float ng = 1.0F;
    float nh = 0.0F;
    Paint.Cap ni = Paint.Cap.BUTT;
    Paint.Join nj = Paint.Join.MITER;
    float nk = 4.0F;
    
    public b() {}
    
    public b(b paramb)
    {
      super();
      this.mY = paramb.mY;
      this.mZ = paramb.mZ;
      this.na = paramb.na;
      this.nc = paramb.nc;
      this.nb = paramb.nb;
      this.nd = paramb.nd;
      this.ne = paramb.ne;
      this.nf = paramb.nf;
      this.ng = paramb.ng;
      this.nh = paramb.nh;
      this.ni = paramb.ni;
      this.nj = paramb.nj;
      this.nk = paramb.nk;
    }
    
    final void a(TypedArray paramTypedArray, XmlPullParser paramXmlPullParser)
    {
      this.mY = null;
      if (!android.support.v4.content.a.c.a(paramXmlPullParser, "pathData")) {
        return;
      }
      Object localObject = paramTypedArray.getString(0);
      if (localObject != null) {
        this.nv = ((String)localObject);
      }
      localObject = paramTypedArray.getString(2);
      if (localObject != null) {
        this.nu = android.support.v4.a.c.J((String)localObject);
      }
      this.nb = android.support.v4.content.a.c.b(paramTypedArray, paramXmlPullParser, "fillColor", 1, this.nb);
      this.ne = android.support.v4.content.a.c.a(paramTypedArray, paramXmlPullParser, "fillAlpha", 12, this.ne);
      int i = android.support.v4.content.a.c.a(paramTypedArray, paramXmlPullParser, "strokeLineCap", 8, -1);
      localObject = this.ni;
      switch (i)
      {
      default: 
        this.ni = ((Paint.Cap)localObject);
        i = android.support.v4.content.a.c.a(paramTypedArray, paramXmlPullParser, "strokeLineJoin", 9, -1);
        localObject = this.nj;
        switch (i)
        {
        }
        break;
      }
      for (;;)
      {
        this.nj = ((Paint.Join)localObject);
        this.nk = android.support.v4.content.a.c.a(paramTypedArray, paramXmlPullParser, "strokeMiterLimit", 10, this.nk);
        this.mZ = android.support.v4.content.a.c.b(paramTypedArray, paramXmlPullParser, "strokeColor", 3, this.mZ);
        this.nc = android.support.v4.content.a.c.a(paramTypedArray, paramXmlPullParser, "strokeAlpha", 11, this.nc);
        this.na = android.support.v4.content.a.c.a(paramTypedArray, paramXmlPullParser, "strokeWidth", 4, this.na);
        this.ng = android.support.v4.content.a.c.a(paramTypedArray, paramXmlPullParser, "trimPathEnd", 6, this.ng);
        this.nh = android.support.v4.content.a.c.a(paramTypedArray, paramXmlPullParser, "trimPathOffset", 7, this.nh);
        this.nf = android.support.v4.content.a.c.a(paramTypedArray, paramXmlPullParser, "trimPathStart", 5, this.nf);
        this.nd = android.support.v4.content.a.c.a(paramTypedArray, paramXmlPullParser, "fillType", 13, this.nd);
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
  }
  
  private static final class c
  {
    int mChangingConfigurations;
    float mScaleX = 1.0F;
    float mScaleY = 1.0F;
    int[] mY;
    final Matrix nl = new Matrix();
    final ArrayList<Object> nm = new ArrayList();
    float nn = 0.0F;
    float no = 0.0F;
    float np = 0.0F;
    float nq = 0.0F;
    float nr = 0.0F;
    final Matrix ns = new Matrix();
    String nt = null;
    
    public c() {}
    
    public c(c paramc, android.support.v4.f.a<String, Object> parama)
    {
      this.nn = paramc.nn;
      this.no = paramc.no;
      this.np = paramc.np;
      this.mScaleX = paramc.mScaleX;
      this.mScaleY = paramc.mScaleY;
      this.nq = paramc.nq;
      this.nr = paramc.nr;
      this.mY = paramc.mY;
      this.nt = paramc.nt;
      this.mChangingConfigurations = paramc.mChangingConfigurations;
      if (this.nt != null) {
        parama.put(this.nt, this);
      }
      this.ns.set(paramc.ns);
      ArrayList localArrayList = paramc.nm;
      int i = 0;
      while (i < localArrayList.size())
      {
        paramc = localArrayList.get(i);
        if ((paramc instanceof c))
        {
          paramc = (c)paramc;
          this.nm.add(new c(paramc, parama));
          i += 1;
        }
        else
        {
          if ((paramc instanceof i.b)) {}
          for (paramc = new i.b((i.b)paramc);; paramc = new i.a((i.a)paramc))
          {
            this.nm.add(paramc);
            if (paramc.nv == null) {
              break;
            }
            parama.put(paramc.nv, paramc);
            break;
            if (!(paramc instanceof i.a)) {
              break label315;
            }
          }
          label315:
          throw new IllegalStateException("Unknown object in the tree!");
        }
      }
    }
  }
  
  private static class d
  {
    int mChangingConfigurations;
    protected c.b[] nu = null;
    String nv;
    
    public d() {}
    
    public d(d paramd)
    {
      this.nv = paramd.nv;
      this.mChangingConfigurations = paramd.mChangingConfigurations;
      this.nu = android.support.v4.a.c.a(paramd.nu);
    }
    
    public final void b(Path paramPath)
    {
      paramPath.reset();
      if (this.nu != null) {
        c.b.a(this.nu, paramPath);
      }
    }
    
    public boolean bk()
    {
      return false;
    }
  }
  
  private static final class e
  {
    private static final Matrix ny = new Matrix();
    private int mChangingConfigurations;
    private Paint nA;
    private Paint nB;
    private PathMeasure nC;
    final i.c nD;
    float nE = 0.0F;
    float nF = 0.0F;
    float nG = 0.0F;
    float nH = 0.0F;
    int nI = 255;
    String nJ = null;
    final android.support.v4.f.a<String, Object> nK = new android.support.v4.f.a();
    private final Path nw;
    private final Path nx;
    private final Matrix nz = new Matrix();
    
    public e()
    {
      this.nD = new i.c();
      this.nw = new Path();
      this.nx = new Path();
    }
    
    public e(e parame)
    {
      this.nD = new i.c(parame.nD, this.nK);
      this.nw = new Path(parame.nw);
      this.nx = new Path(parame.nx);
      this.nE = parame.nE;
      this.nF = parame.nF;
      this.nG = parame.nG;
      this.nH = parame.nH;
      this.mChangingConfigurations = parame.mChangingConfigurations;
      this.nI = parame.nI;
      this.nJ = parame.nJ;
      if (parame.nJ != null) {
        this.nK.put(parame.nJ, this);
      }
    }
    
    private void a(i.c paramc, Matrix paramMatrix, Canvas paramCanvas, int paramInt1, int paramInt2, ColorFilter paramColorFilter)
    {
      paramc.nl.set(paramMatrix);
      paramc.nl.preConcat(paramc.ns);
      paramCanvas.save();
      int i = 0;
      if (i < paramc.nm.size())
      {
        paramMatrix = paramc.nm.get(i);
        if ((paramMatrix instanceof i.c)) {
          a((i.c)paramMatrix, paramc.nl, paramCanvas, paramInt1, paramInt2, paramColorFilter);
        }
      }
      label785:
      label801:
      for (;;)
      {
        i += 1;
        break;
        if ((paramMatrix instanceof i.d))
        {
          paramMatrix = (i.d)paramMatrix;
          float f1 = paramInt1 / this.nG;
          float f3 = paramInt2 / this.nH;
          float f2 = Math.min(f1, f3);
          Object localObject1 = paramc.nl;
          this.nz.set((Matrix)localObject1);
          this.nz.postScale(f1, f3);
          Object localObject2 = new float[4];
          tmp160_158 = localObject2;
          tmp160_158[0] = 0.0F;
          tmp164_160 = tmp160_158;
          tmp164_160[1] = 1.0F;
          tmp168_164 = tmp164_160;
          tmp168_164[2] = 1.0F;
          tmp172_168 = tmp168_164;
          tmp172_168[3] = 0.0F;
          tmp172_168;
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
              break label801;
            }
            paramMatrix.b(this.nw);
            localObject2 = this.nw;
            this.nx.reset();
            if (paramMatrix.bk())
            {
              this.nx.addPath((Path)localObject2, this.nz);
              paramCanvas.clipPath(this.nx);
              break;
            }
            localObject1 = (i.b)paramMatrix;
            label494:
            Path localPath;
            if ((((i.b)localObject1).nf != 0.0F) || (((i.b)localObject1).ng != 1.0F))
            {
              f6 = ((i.b)localObject1).nf;
              f7 = ((i.b)localObject1).nh;
              f4 = ((i.b)localObject1).ng;
              f5 = ((i.b)localObject1).nh;
              if (this.nC == null) {
                this.nC = new PathMeasure();
              }
              this.nC.setPath(this.nw, false);
              f3 = this.nC.getLength();
              f6 = (f6 + f7) % 1.0F * f3;
              f4 = (f4 + f5) % 1.0F * f3;
              ((Path)localObject2).reset();
              if (f6 > f4)
              {
                this.nC.getSegment(f6, f3, (Path)localObject2, true);
                this.nC.getSegment(0.0F, f4, (Path)localObject2, true);
                ((Path)localObject2).rLineTo(0.0F, 0.0F);
              }
            }
            else
            {
              this.nx.addPath((Path)localObject2, this.nz);
              if (((i.b)localObject1).nb != 0)
              {
                if (this.nB == null)
                {
                  this.nB = new Paint();
                  this.nB.setStyle(Paint.Style.FILL);
                  this.nB.setAntiAlias(true);
                }
                localObject2 = this.nB;
                ((Paint)localObject2).setColor(i.c(((i.b)localObject1).nb, ((i.b)localObject1).ne));
                ((Paint)localObject2).setColorFilter(paramColorFilter);
                localPath = this.nx;
                if (((i.b)localObject1).nd != 0) {
                  break label785;
                }
              }
            }
            for (paramMatrix = Path.FillType.WINDING;; paramMatrix = Path.FillType.EVEN_ODD)
            {
              localPath.setFillType(paramMatrix);
              paramCanvas.drawPath(this.nx, (Paint)localObject2);
              if (((i.b)localObject1).mZ == 0) {
                break;
              }
              if (this.nA == null)
              {
                this.nA = new Paint();
                this.nA.setStyle(Paint.Style.STROKE);
                this.nA.setAntiAlias(true);
              }
              paramMatrix = this.nA;
              if (((i.b)localObject1).nj != null) {
                paramMatrix.setStrokeJoin(((i.b)localObject1).nj);
              }
              if (((i.b)localObject1).ni != null) {
                paramMatrix.setStrokeCap(((i.b)localObject1).ni);
              }
              paramMatrix.setStrokeMiter(((i.b)localObject1).nk);
              paramMatrix.setColor(i.c(((i.b)localObject1).mZ, ((i.b)localObject1).nc));
              paramMatrix.setColorFilter(paramColorFilter);
              paramMatrix.setStrokeWidth(((i.b)localObject1).na * (f1 * f2));
              paramCanvas.drawPath(this.nx, paramMatrix);
              break;
              this.nC.getSegment(f6, f4, (Path)localObject2, true);
              break label494;
            }
            paramCanvas.restore();
            return;
          }
        }
      }
    }
    
    public final void a(Canvas paramCanvas, int paramInt1, int paramInt2)
    {
      a(this.nD, ny, paramCanvas, paramInt1, paramInt2, null);
    }
  }
  
  private static final class f
    extends Drawable.ConstantState
  {
    int mChangingConfigurations;
    i.e nL;
    ColorStateList nM = null;
    PorterDuff.Mode nN = i.mO;
    boolean nO;
    Bitmap nP;
    ColorStateList nQ;
    PorterDuff.Mode nR;
    int nS;
    boolean nT;
    boolean nU;
    Paint nV;
    
    public f()
    {
      this.nL = new i.e();
    }
    
    public f(f paramf)
    {
      if (paramf != null)
      {
        this.mChangingConfigurations = paramf.mChangingConfigurations;
        this.nL = new i.e(paramf.nL);
        if (i.e.a(paramf.nL) != null) {
          i.e.a(this.nL, new Paint(i.e.a(paramf.nL)));
        }
        if (i.e.b(paramf.nL) != null) {
          i.e.b(this.nL, new Paint(i.e.b(paramf.nL)));
        }
        this.nM = paramf.nM;
        this.nN = paramf.nN;
        this.nO = paramf.nO;
      }
    }
    
    public final int getChangingConfigurations()
    {
      return this.mChangingConfigurations;
    }
    
    public final void k(int paramInt1, int paramInt2)
    {
      this.nP.eraseColor(0);
      Canvas localCanvas = new Canvas(this.nP);
      this.nL.a(localCanvas, paramInt1, paramInt2);
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
  
  private static final class g
    extends Drawable.ConstantState
  {
    private final Drawable.ConstantState mI;
    
    public g(Drawable.ConstantState paramConstantState)
    {
      this.mI = paramConstantState;
    }
    
    public final boolean canApplyTheme()
    {
      return this.mI.canApplyTheme();
    }
    
    public final int getChangingConfigurations()
    {
      return this.mI.getChangingConfigurations();
    }
    
    public final Drawable newDrawable()
    {
      i locali = new i();
      locali.mN = ((VectorDrawable)this.mI.newDrawable());
      return locali;
    }
    
    public final Drawable newDrawable(Resources paramResources)
    {
      i locali = new i();
      locali.mN = ((VectorDrawable)this.mI.newDrawable(paramResources));
      return locali;
    }
    
    public final Drawable newDrawable(Resources paramResources, Resources.Theme paramTheme)
    {
      i locali = new i();
      locali.mN = ((VectorDrawable)this.mI.newDrawable(paramResources, paramTheme));
      return locali;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     android.support.c.a.i
 * JD-Core Version:    0.7.0.1
 */