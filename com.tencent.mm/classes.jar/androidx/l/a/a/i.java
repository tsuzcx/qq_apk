package androidx.l.a.a;

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
import android.util.AttributeSet;
import android.util.Xml;
import androidx.core.content.a.b;
import androidx.core.content.a.f;
import androidx.core.content.a.g;
import androidx.core.graphics.d;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.io.IOException;
import java.util.ArrayDeque;
import java.util.ArrayList;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;

public final class i
  extends h
{
  static final PorterDuff.Mode bqY = PorterDuff.Mode.SRC_IN;
  private PorterDuffColorFilter Rp;
  private Drawable.ConstantState ciA;
  private final float[] ciB;
  private final Matrix ciC;
  private final Rect ciD;
  g ciy;
  boolean ciz;
  private boolean jA;
  private ColorFilter kx;
  
  i()
  {
    AppMethodBeat.i(192610);
    this.ciz = true;
    this.ciB = new float[9];
    this.ciC = new Matrix();
    this.ciD = new Rect();
    this.ciy = new g();
    AppMethodBeat.o(192610);
  }
  
  i(g paramg)
  {
    AppMethodBeat.i(192620);
    this.ciz = true;
    this.ciB = new float[9];
    this.ciC = new Matrix();
    this.ciD = new Rect();
    this.ciy = paramg;
    this.Rp = b(paramg.Rq, paramg.kA);
    AppMethodBeat.o(192620);
  }
  
  private PorterDuffColorFilter b(ColorStateList paramColorStateList, PorterDuff.Mode paramMode)
  {
    AppMethodBeat.i(192632);
    if ((paramColorStateList == null) || (paramMode == null))
    {
      AppMethodBeat.o(192632);
      return null;
    }
    paramColorStateList = new PorterDuffColorFilter(paramColorStateList.getColorForState(getState(), 0), paramMode);
    AppMethodBeat.o(192632);
    return paramColorStateList;
  }
  
  public static i d(Resources paramResources, XmlPullParser paramXmlPullParser, AttributeSet paramAttributeSet, Resources.Theme paramTheme)
  {
    AppMethodBeat.i(192654);
    i locali = new i();
    locali.inflate(paramResources, paramXmlPullParser, paramAttributeSet, paramTheme);
    AppMethodBeat.o(192654);
    return locali;
  }
  
  public static i e(Resources paramResources, int paramInt, Resources.Theme paramTheme)
  {
    AppMethodBeat.i(192644);
    Object localObject;
    if (Build.VERSION.SDK_INT >= 24)
    {
      localObject = new i();
      ((i)localObject).cix = f.b(paramResources, paramInt, paramTheme);
      ((i)localObject).ciA = new h(((i)localObject).cix.getConstantState());
      AppMethodBeat.o(192644);
      return localObject;
    }
    try
    {
      localObject = paramResources.getXml(paramInt);
      localAttributeSet = Xml.asAttributeSet((XmlPullParser)localObject);
      do
      {
        paramInt = ((XmlPullParser)localObject).next();
      } while ((paramInt != 2) && (paramInt != 1));
      if (paramInt != 2)
      {
        paramResources = new XmlPullParserException("No start tag found");
        AppMethodBeat.o(192644);
        throw paramResources;
      }
    }
    catch (XmlPullParserException paramResources)
    {
      AttributeSet localAttributeSet;
      AppMethodBeat.o(192644);
      return null;
      paramResources = d(paramResources, (XmlPullParser)localObject, localAttributeSet, paramTheme);
      AppMethodBeat.o(192644);
      return paramResources;
    }
    catch (IOException paramResources)
    {
      label108:
      break label108;
    }
  }
  
  private void e(Resources paramResources, XmlPullParser paramXmlPullParser, AttributeSet paramAttributeSet, Resources.Theme paramTheme)
  {
    AppMethodBeat.i(192674);
    g localg = this.ciy;
    f localf = localg.cjo;
    int i = 1;
    ArrayDeque localArrayDeque = new ArrayDeque();
    localArrayDeque.push(localf.cjf);
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
          localTypedArray = g.a(paramResources, paramTheme, paramAttributeSet, a.aEe);
          ((b)localObject).a(localTypedArray, paramXmlPullParser, paramTheme);
          localTypedArray.recycle();
          localc.bkE.add(localObject);
          if (((b)localObject).getPathName() != null) {
            localf.cjn.put(((b)localObject).getPathName(), localObject);
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
          localObject = new i.a();
          if (g.a(paramXmlPullParser, "pathData"))
          {
            localTypedArray = g.a(paramResources, paramTheme, paramAttributeSet, a.aEt);
            ((i.a)localObject).b(localTypedArray);
            localTypedArray.recycle();
          }
          localc.bkE.add(localObject);
          if (((i.a)localObject).getPathName() != null) {
            localf.cjn.put(((i.a)localObject).getPathName(), localObject);
          }
          localg.mChangingConfigurations |= ((i.a)localObject).mChangingConfigurations;
        }
        else
        {
          if ("group".equals(localObject))
          {
            localObject = new c();
            localTypedArray = g.a(paramResources, paramTheme, paramAttributeSet, a.aDV);
            ((c)localObject).ciE = null;
            ((c)localObject).ciR = g.a(localTypedArray, paramXmlPullParser, "rotation", 5, ((c)localObject).ciR);
            ((c)localObject).ciS = localTypedArray.getFloat(1, ((c)localObject).ciS);
            ((c)localObject).ciT = localTypedArray.getFloat(2, ((c)localObject).ciT);
            ((c)localObject).ceV = g.a(localTypedArray, paramXmlPullParser, "scaleX", 3, ((c)localObject).ceV);
            ((c)localObject).ceW = g.a(localTypedArray, paramXmlPullParser, "scaleY", 4, ((c)localObject).ceW);
            ((c)localObject).ciU = g.a(localTypedArray, paramXmlPullParser, "translateX", 6, ((c)localObject).ciU);
            ((c)localObject).ciV = g.a(localTypedArray, paramXmlPullParser, "translateY", 7, ((c)localObject).ciV);
            String str = localTypedArray.getString(0);
            if (str != null) {
              ((c)localObject).ciX = str;
            }
            ((c)localObject).Mh();
            localTypedArray.recycle();
            localc.bkE.add(localObject);
            localArrayDeque.push(localObject);
            if (((c)localObject).getGroupName() != null) {
              localf.cjn.put(((c)localObject).getGroupName(), localObject);
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
    if (i != 0)
    {
      paramResources = new XmlPullParserException("no path defined");
      AppMethodBeat.o(192674);
      throw paramResources;
    }
    AppMethodBeat.o(192674);
  }
  
  static int h(int paramInt, float paramFloat)
  {
    AppMethodBeat.i(192663);
    int i = (int)(Color.alpha(paramInt) * paramFloat);
    AppMethodBeat.o(192663);
    return i << 24 | 0xFFFFFF & paramInt;
  }
  
  public final boolean canApplyTheme()
  {
    AppMethodBeat.i(192832);
    if (this.cix != null) {
      androidx.core.graphics.drawable.a.p(this.cix);
    }
    AppMethodBeat.o(192832);
    return false;
  }
  
  public final void draw(Canvas paramCanvas)
  {
    AppMethodBeat.i(192716);
    if (this.cix != null)
    {
      this.cix.draw(paramCanvas);
      AppMethodBeat.o(192716);
      return;
    }
    copyBounds(this.ciD);
    if ((this.ciD.width() <= 0) || (this.ciD.height() <= 0))
    {
      AppMethodBeat.o(192716);
      return;
    }
    if (this.kx == null) {}
    int i;
    int k;
    int m;
    for (Object localObject = this.Rp;; localObject = this.kx)
    {
      paramCanvas.getMatrix(this.ciC);
      this.ciC.getValues(this.ciB);
      float f2 = Math.abs(this.ciB[0]);
      float f1 = Math.abs(this.ciB[4]);
      float f4 = Math.abs(this.ciB[1]);
      float f3 = Math.abs(this.ciB[3]);
      if ((f4 != 0.0F) || (f3 != 0.0F))
      {
        f1 = 1.0F;
        f2 = 1.0F;
      }
      j = (int)(f2 * this.ciD.width());
      i = (int)(f1 * this.ciD.height());
      k = Math.min(2048, j);
      m = Math.min(2048, i);
      if ((k > 0) && (m > 0)) {
        break;
      }
      AppMethodBeat.o(192716);
      return;
    }
    int j = paramCanvas.save();
    paramCanvas.translate(this.ciD.left, this.ciD.top);
    g localg;
    label357:
    Rect localRect;
    if (Build.VERSION.SDK_INT >= 17) {
      if ((isAutoMirrored()) && (androidx.core.graphics.drawable.a.u(this) == 1))
      {
        i = 1;
        if (i != 0)
        {
          paramCanvas.translate(this.ciD.width(), 0.0F);
          paramCanvas.scale(-1.0F, 1.0F);
        }
        this.ciD.offsetTo(0, 0);
        localg = this.ciy;
        if (localg.cjp != null)
        {
          if ((k != localg.cjp.getWidth()) || (m != localg.cjp.getHeight())) {
            break label482;
          }
          i = 1;
          if (i != 0) {}
        }
        else
        {
          localg.cjp = Bitmap.createBitmap(k, m, Bitmap.Config.ARGB_8888);
          localg.cju = true;
        }
        if (this.ciz) {
          break label488;
        }
        this.ciy.bR(k, m);
        label401:
        localg = this.ciy;
        localRect = this.ciD;
        if (localg.cjo.getRootAlpha() >= 255) {
          break label640;
        }
        i = 1;
        label430:
        if ((i != 0) || (localObject != null)) {
          break label646;
        }
      }
    }
    for (localObject = null;; localObject = localg.cjv)
    {
      paramCanvas.drawBitmap(localg.cjp, null, localRect, (Paint)localObject);
      paramCanvas.restoreToCount(j);
      AppMethodBeat.o(192716);
      return;
      i = 0;
      break;
      i = 0;
      break;
      label482:
      i = 0;
      break label357;
      label488:
      localg = this.ciy;
      if ((!localg.cju) && (localg.cjq == localg.Rq) && (localg.cjr == localg.kA) && (localg.cjt == localg.kw) && (localg.cjs == localg.cjo.getRootAlpha())) {}
      for (i = 1;; i = 0)
      {
        if (i != 0) {
          break label638;
        }
        this.ciy.bR(k, m);
        localg = this.ciy;
        localg.cjq = localg.Rq;
        localg.cjr = localg.kA;
        localg.cjs = localg.cjo.getRootAlpha();
        localg.cjt = localg.kw;
        localg.cju = false;
        break;
      }
      label638:
      break label401;
      label640:
      i = 0;
      break label430;
      label646:
      if (localg.cjv == null)
      {
        localg.cjv = new Paint();
        localg.cjv.setFilterBitmap(true);
      }
      localg.cjv.setAlpha(localg.cjo.getRootAlpha());
      localg.cjv.setColorFilter((ColorFilter)localObject);
    }
  }
  
  public final int getAlpha()
  {
    AppMethodBeat.i(192726);
    if (this.cix != null)
    {
      i = androidx.core.graphics.drawable.a.o(this.cix);
      AppMethodBeat.o(192726);
      return i;
    }
    int i = this.ciy.cjo.getRootAlpha();
    AppMethodBeat.o(192726);
    return i;
  }
  
  public final int getChangingConfigurations()
  {
    AppMethodBeat.i(192874);
    if (this.cix != null)
    {
      i = this.cix.getChangingConfigurations();
      AppMethodBeat.o(192874);
      return i;
    }
    int i = super.getChangingConfigurations();
    int j = this.ciy.getChangingConfigurations();
    AppMethodBeat.o(192874);
    return i | j;
  }
  
  public final Drawable.ConstantState getConstantState()
  {
    AppMethodBeat.i(192701);
    if ((this.cix != null) && (Build.VERSION.SDK_INT >= 24))
    {
      localObject = new h(this.cix.getConstantState());
      AppMethodBeat.o(192701);
      return localObject;
    }
    this.ciy.mChangingConfigurations = getChangingConfigurations();
    Object localObject = this.ciy;
    AppMethodBeat.o(192701);
    return localObject;
  }
  
  public final int getIntrinsicHeight()
  {
    AppMethodBeat.i(192822);
    if (this.cix != null)
    {
      i = this.cix.getIntrinsicHeight();
      AppMethodBeat.o(192822);
      return i;
    }
    int i = (int)this.ciy.cjo.cjh;
    AppMethodBeat.o(192822);
    return i;
  }
  
  public final int getIntrinsicWidth()
  {
    AppMethodBeat.i(192813);
    if (this.cix != null)
    {
      i = this.cix.getIntrinsicWidth();
      AppMethodBeat.o(192813);
      return i;
    }
    int i = (int)this.ciy.cjo.cjg;
    AppMethodBeat.o(192813);
    return i;
  }
  
  public final int getOpacity()
  {
    AppMethodBeat.i(192803);
    if (this.cix != null)
    {
      int i = this.cix.getOpacity();
      AppMethodBeat.o(192803);
      return i;
    }
    AppMethodBeat.o(192803);
    return -3;
  }
  
  public final void inflate(Resources paramResources, XmlPullParser paramXmlPullParser, AttributeSet paramAttributeSet)
  {
    AppMethodBeat.i(192854);
    if (this.cix != null)
    {
      this.cix.inflate(paramResources, paramXmlPullParser, paramAttributeSet);
      AppMethodBeat.o(192854);
      return;
    }
    inflate(paramResources, paramXmlPullParser, paramAttributeSet, null);
    AppMethodBeat.o(192854);
  }
  
  public final void inflate(Resources paramResources, XmlPullParser paramXmlPullParser, AttributeSet paramAttributeSet, Resources.Theme paramTheme)
  {
    AppMethodBeat.i(192860);
    if (this.cix != null)
    {
      androidx.core.graphics.drawable.a.a(this.cix, paramResources, paramXmlPullParser, paramAttributeSet, paramTheme);
      AppMethodBeat.o(192860);
      return;
    }
    g localg1 = this.ciy;
    localg1.cjo = new f();
    TypedArray localTypedArray = g.a(paramResources, paramTheme, paramAttributeSet, a.aDM);
    g localg2 = this.ciy;
    f localf = localg2.cjo;
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
      localg2.kA = ((PorterDuff.Mode)localObject);
      localObject = localTypedArray.getColorStateList(1);
      if (localObject != null) {
        localg2.Rq = ((ColorStateList)localObject);
      }
      localg2.kw = g.a(localTypedArray, paramXmlPullParser, "autoMirrored", 5, localg2.kw);
      localf.cji = g.a(localTypedArray, paramXmlPullParser, "viewportWidth", 7, localf.cji);
      localf.cjj = g.a(localTypedArray, paramXmlPullParser, "viewportHeight", 8, localf.cjj);
      if (localf.cji > 0.0F) {
        break;
      }
      paramResources = new XmlPullParserException(localTypedArray.getPositionDescription() + "<vector> tag requires viewportWidth > 0");
      AppMethodBeat.o(192860);
      throw paramResources;
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
    if (localf.cjj <= 0.0F)
    {
      paramResources = new XmlPullParserException(localTypedArray.getPositionDescription() + "<vector> tag requires viewportHeight > 0");
      AppMethodBeat.o(192860);
      throw paramResources;
    }
    localf.cjg = localTypedArray.getDimension(3, localf.cjg);
    localf.cjh = localTypedArray.getDimension(2, localf.cjh);
    if (localf.cjg <= 0.0F)
    {
      paramResources = new XmlPullParserException(localTypedArray.getPositionDescription() + "<vector> tag requires width > 0");
      AppMethodBeat.o(192860);
      throw paramResources;
    }
    if (localf.cjh <= 0.0F)
    {
      paramResources = new XmlPullParserException(localTypedArray.getPositionDescription() + "<vector> tag requires height > 0");
      AppMethodBeat.o(192860);
      throw paramResources;
    }
    localf.setAlpha(g.a(localTypedArray, paramXmlPullParser, "alpha", 4, localf.getAlpha()));
    localObject = localTypedArray.getString(0);
    if (localObject != null)
    {
      localf.cjl = ((String)localObject);
      localf.cjn.put(localObject, localf);
    }
    localTypedArray.recycle();
    localg1.mChangingConfigurations = getChangingConfigurations();
    localg1.cju = true;
    e(paramResources, paramXmlPullParser, paramAttributeSet, paramTheme);
    this.Rp = b(localg1.Rq, localg1.kA);
    AppMethodBeat.o(192860);
  }
  
  public final void invalidateSelf()
  {
    AppMethodBeat.i(192882);
    if (this.cix != null)
    {
      this.cix.invalidateSelf();
      AppMethodBeat.o(192882);
      return;
    }
    super.invalidateSelf();
    AppMethodBeat.o(192882);
  }
  
  public final boolean isAutoMirrored()
  {
    AppMethodBeat.i(192841);
    if (this.cix != null)
    {
      bool = androidx.core.graphics.drawable.a.n(this.cix);
      AppMethodBeat.o(192841);
      return bool;
    }
    boolean bool = this.ciy.kw;
    AppMethodBeat.o(192841);
    return bool;
  }
  
  public final boolean isStateful()
  {
    AppMethodBeat.i(192785);
    if (this.cix != null)
    {
      boolean bool = this.cix.isStateful();
      AppMethodBeat.o(192785);
      return bool;
    }
    if ((super.isStateful()) || ((this.ciy != null) && ((this.ciy.cjo.isStateful()) || ((this.ciy.Rq != null) && (this.ciy.Rq.isStateful())))))
    {
      AppMethodBeat.o(192785);
      return true;
    }
    AppMethodBeat.o(192785);
    return false;
  }
  
  public final Drawable mutate()
  {
    AppMethodBeat.i(192690);
    if (this.cix != null)
    {
      this.cix.mutate();
      AppMethodBeat.o(192690);
      return this;
    }
    if ((!this.jA) && (super.mutate() == this))
    {
      this.ciy = new g(this.ciy);
      this.jA = true;
    }
    AppMethodBeat.o(192690);
    return this;
  }
  
  protected final void onBoundsChange(Rect paramRect)
  {
    AppMethodBeat.i(192870);
    if (this.cix != null) {
      this.cix.setBounds(paramRect);
    }
    AppMethodBeat.o(192870);
  }
  
  protected final boolean onStateChange(int[] paramArrayOfInt)
  {
    AppMethodBeat.i(192795);
    if (this.cix != null)
    {
      bool1 = this.cix.setState(paramArrayOfInt);
      AppMethodBeat.o(192795);
      return bool1;
    }
    boolean bool2 = false;
    g localg = this.ciy;
    boolean bool1 = bool2;
    if (localg.Rq != null)
    {
      bool1 = bool2;
      if (localg.kA != null)
      {
        this.Rp = b(localg.Rq, localg.kA);
        invalidateSelf();
        bool1 = true;
      }
    }
    bool2 = bool1;
    if (localg.cjo.isStateful())
    {
      boolean bool3 = localg.cjo.cjf.h(paramArrayOfInt);
      localg.cju |= bool3;
      bool2 = bool1;
      if (bool3)
      {
        invalidateSelf();
        bool2 = true;
      }
    }
    AppMethodBeat.o(192795);
    return bool2;
  }
  
  public final void scheduleSelf(Runnable paramRunnable, long paramLong)
  {
    AppMethodBeat.i(192890);
    if (this.cix != null)
    {
      this.cix.scheduleSelf(paramRunnable, paramLong);
      AppMethodBeat.o(192890);
      return;
    }
    super.scheduleSelf(paramRunnable, paramLong);
    AppMethodBeat.o(192890);
  }
  
  public final void setAlpha(int paramInt)
  {
    AppMethodBeat.i(192734);
    if (this.cix != null)
    {
      this.cix.setAlpha(paramInt);
      AppMethodBeat.o(192734);
      return;
    }
    if (this.ciy.cjo.getRootAlpha() != paramInt)
    {
      this.ciy.cjo.setRootAlpha(paramInt);
      invalidateSelf();
    }
    AppMethodBeat.o(192734);
  }
  
  public final void setAutoMirrored(boolean paramBoolean)
  {
    AppMethodBeat.i(192847);
    if (this.cix != null)
    {
      androidx.core.graphics.drawable.a.b(this.cix, paramBoolean);
      AppMethodBeat.o(192847);
      return;
    }
    this.ciy.kw = paramBoolean;
    AppMethodBeat.o(192847);
  }
  
  public final void setColorFilter(ColorFilter paramColorFilter)
  {
    AppMethodBeat.i(192746);
    if (this.cix != null)
    {
      this.cix.setColorFilter(paramColorFilter);
      AppMethodBeat.o(192746);
      return;
    }
    this.kx = paramColorFilter;
    invalidateSelf();
    AppMethodBeat.o(192746);
  }
  
  public final void setTint(int paramInt)
  {
    AppMethodBeat.i(192756);
    if (this.cix != null)
    {
      androidx.core.graphics.drawable.a.a(this.cix, paramInt);
      AppMethodBeat.o(192756);
      return;
    }
    setTintList(ColorStateList.valueOf(paramInt));
    AppMethodBeat.o(192756);
  }
  
  public final void setTintList(ColorStateList paramColorStateList)
  {
    AppMethodBeat.i(192767);
    if (this.cix != null)
    {
      androidx.core.graphics.drawable.a.a(this.cix, paramColorStateList);
      AppMethodBeat.o(192767);
      return;
    }
    g localg = this.ciy;
    if (localg.Rq != paramColorStateList)
    {
      localg.Rq = paramColorStateList;
      this.Rp = b(paramColorStateList, localg.kA);
      invalidateSelf();
    }
    AppMethodBeat.o(192767);
  }
  
  public final void setTintMode(PorterDuff.Mode paramMode)
  {
    AppMethodBeat.i(192777);
    if (this.cix != null)
    {
      androidx.core.graphics.drawable.a.a(this.cix, paramMode);
      AppMethodBeat.o(192777);
      return;
    }
    g localg = this.ciy;
    if (localg.kA != paramMode)
    {
      localg.kA = paramMode;
      this.Rp = b(localg.Rq, paramMode);
      invalidateSelf();
    }
    AppMethodBeat.o(192777);
  }
  
  public final boolean setVisible(boolean paramBoolean1, boolean paramBoolean2)
  {
    AppMethodBeat.i(192899);
    if (this.cix != null)
    {
      paramBoolean1 = this.cix.setVisible(paramBoolean1, paramBoolean2);
      AppMethodBeat.o(192899);
      return paramBoolean1;
    }
    paramBoolean1 = super.setVisible(paramBoolean1, paramBoolean2);
    AppMethodBeat.o(192899);
    return paramBoolean1;
  }
  
  public final void unscheduleSelf(Runnable paramRunnable)
  {
    AppMethodBeat.i(192906);
    if (this.cix != null)
    {
      this.cix.unscheduleSelf(paramRunnable);
      AppMethodBeat.o(192906);
      return;
    }
    super.unscheduleSelf(paramRunnable);
    AppMethodBeat.o(192906);
  }
  
  static final class b
    extends i.e
  {
    private int[] ciE;
    b ciF;
    b ciG;
    float ciH = 1.0F;
    int ciI = 0;
    float ciJ = 1.0F;
    float ciK = 0.0F;
    float ciL = 1.0F;
    float ciM = 0.0F;
    Paint.Cap ciN = Paint.Cap.BUTT;
    Paint.Join ciO = Paint.Join.MITER;
    float ciP = 4.0F;
    float mStrokeWidth = 0.0F;
    
    public b() {}
    
    public b(b paramb)
    {
      super();
      this.ciE = paramb.ciE;
      this.ciF = paramb.ciF;
      this.mStrokeWidth = paramb.mStrokeWidth;
      this.ciH = paramb.ciH;
      this.ciG = paramb.ciG;
      this.ciI = paramb.ciI;
      this.ciJ = paramb.ciJ;
      this.ciK = paramb.ciK;
      this.ciL = paramb.ciL;
      this.ciM = paramb.ciM;
      this.ciN = paramb.ciN;
      this.ciO = paramb.ciO;
      this.ciP = paramb.ciP;
    }
    
    final void a(TypedArray paramTypedArray, XmlPullParser paramXmlPullParser, Resources.Theme paramTheme)
    {
      AppMethodBeat.i(192664);
      this.ciE = null;
      if (!g.a(paramXmlPullParser, "pathData"))
      {
        AppMethodBeat.o(192664);
        return;
      }
      Object localObject = paramTypedArray.getString(0);
      if (localObject != null) {
        this.ciZ = ((String)localObject);
      }
      localObject = paramTypedArray.getString(2);
      if (localObject != null) {
        this.ciY = d.av((String)localObject);
      }
      this.ciG = g.a(paramTypedArray, paramXmlPullParser, paramTheme, "fillColor", 1);
      this.ciJ = g.a(paramTypedArray, paramXmlPullParser, "fillAlpha", 12, this.ciJ);
      int i = g.a(paramTypedArray, paramXmlPullParser, "strokeLineCap", 8, -1);
      localObject = this.ciN;
      switch (i)
      {
      default: 
        this.ciN = ((Paint.Cap)localObject);
        i = g.a(paramTypedArray, paramXmlPullParser, "strokeLineJoin", 9, -1);
        localObject = this.ciO;
        switch (i)
        {
        }
        break;
      }
      for (;;)
      {
        this.ciO = ((Paint.Join)localObject);
        this.ciP = g.a(paramTypedArray, paramXmlPullParser, "strokeMiterLimit", 10, this.ciP);
        this.ciF = g.a(paramTypedArray, paramXmlPullParser, paramTheme, "strokeColor", 3);
        this.ciH = g.a(paramTypedArray, paramXmlPullParser, "strokeAlpha", 11, this.ciH);
        this.mStrokeWidth = g.a(paramTypedArray, paramXmlPullParser, "strokeWidth", 4, this.mStrokeWidth);
        this.ciL = g.a(paramTypedArray, paramXmlPullParser, "trimPathEnd", 6, this.ciL);
        this.ciM = g.a(paramTypedArray, paramXmlPullParser, "trimPathOffset", 7, this.ciM);
        this.ciK = g.a(paramTypedArray, paramXmlPullParser, "trimPathStart", 5, this.ciK);
        this.ciI = g.a(paramTypedArray, paramXmlPullParser, "fillType", 13, this.ciI);
        AppMethodBeat.o(192664);
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
    
    final float getFillAlpha()
    {
      return this.ciJ;
    }
    
    final int getFillColor()
    {
      AppMethodBeat.i(192759);
      int i = this.ciG.getColor();
      AppMethodBeat.o(192759);
      return i;
    }
    
    final float getStrokeAlpha()
    {
      return this.ciH;
    }
    
    final int getStrokeColor()
    {
      AppMethodBeat.i(192691);
      int i = this.ciF.getColor();
      AppMethodBeat.o(192691);
      return i;
    }
    
    final float getStrokeWidth()
    {
      return this.mStrokeWidth;
    }
    
    final float getTrimPathEnd()
    {
      return this.ciL;
    }
    
    final float getTrimPathOffset()
    {
      return this.ciM;
    }
    
    final float getTrimPathStart()
    {
      return this.ciK;
    }
    
    public final boolean h(int[] paramArrayOfInt)
    {
      AppMethodBeat.i(192680);
      boolean bool1 = this.ciG.h(paramArrayOfInt);
      boolean bool2 = this.ciF.h(paramArrayOfInt);
      AppMethodBeat.o(192680);
      return bool1 | bool2;
    }
    
    public final boolean isStateful()
    {
      AppMethodBeat.i(192673);
      if ((this.ciG.isStateful()) || (this.ciF.isStateful()))
      {
        AppMethodBeat.o(192673);
        return true;
      }
      AppMethodBeat.o(192673);
      return false;
    }
    
    final void setFillAlpha(float paramFloat)
    {
      this.ciJ = paramFloat;
    }
    
    final void setFillColor(int paramInt)
    {
      AppMethodBeat.i(192772);
      this.ciG.setColor(paramInt);
      AppMethodBeat.o(192772);
    }
    
    final void setStrokeAlpha(float paramFloat)
    {
      this.ciH = paramFloat;
    }
    
    final void setStrokeColor(int paramInt)
    {
      AppMethodBeat.i(192705);
      this.ciF.setColor(paramInt);
      AppMethodBeat.o(192705);
    }
    
    final void setStrokeWidth(float paramFloat)
    {
      this.mStrokeWidth = paramFloat;
    }
    
    final void setTrimPathEnd(float paramFloat)
    {
      this.ciL = paramFloat;
    }
    
    final void setTrimPathOffset(float paramFloat)
    {
      this.ciM = paramFloat;
    }
    
    final void setTrimPathStart(float paramFloat)
    {
      this.ciK = paramFloat;
    }
  }
  
  static final class c
    extends i.d
  {
    final ArrayList<i.d> bkE;
    float ceV;
    float ceW;
    int[] ciE;
    final Matrix ciQ;
    float ciR;
    float ciS;
    float ciT;
    float ciU;
    float ciV;
    final Matrix ciW;
    String ciX;
    int mChangingConfigurations;
    
    public c()
    {
      super();
      AppMethodBeat.i(192640);
      this.ciQ = new Matrix();
      this.bkE = new ArrayList();
      this.ciR = 0.0F;
      this.ciS = 0.0F;
      this.ciT = 0.0F;
      this.ceV = 1.0F;
      this.ceW = 1.0F;
      this.ciU = 0.0F;
      this.ciV = 0.0F;
      this.ciW = new Matrix();
      this.ciX = null;
      AppMethodBeat.o(192640);
    }
    
    public c(c paramc, androidx.b.a<String, Object> parama)
    {
      super();
      AppMethodBeat.i(192625);
      this.ciQ = new Matrix();
      this.bkE = new ArrayList();
      this.ciR = 0.0F;
      this.ciS = 0.0F;
      this.ciT = 0.0F;
      this.ceV = 1.0F;
      this.ceW = 1.0F;
      this.ciU = 0.0F;
      this.ciV = 0.0F;
      this.ciW = new Matrix();
      this.ciX = null;
      this.ciR = paramc.ciR;
      this.ciS = paramc.ciS;
      this.ciT = paramc.ciT;
      this.ceV = paramc.ceV;
      this.ceW = paramc.ceW;
      this.ciU = paramc.ciU;
      this.ciV = paramc.ciV;
      this.ciE = paramc.ciE;
      this.ciX = paramc.ciX;
      this.mChangingConfigurations = paramc.mChangingConfigurations;
      if (this.ciX != null) {
        parama.put(this.ciX, this);
      }
      this.ciW.set(paramc.ciW);
      ArrayList localArrayList = paramc.bkE;
      int i = 0;
      while (i < localArrayList.size())
      {
        paramc = localArrayList.get(i);
        if ((paramc instanceof c))
        {
          paramc = (c)paramc;
          this.bkE.add(new c(paramc, parama));
          i += 1;
        }
        else
        {
          if ((paramc instanceof i.b)) {}
          for (paramc = new i.b((i.b)paramc);; paramc = new i.a((i.a)paramc))
          {
            this.bkE.add(paramc);
            if (paramc.ciZ == null) {
              break;
            }
            parama.put(paramc.ciZ, paramc);
            break;
            if (!(paramc instanceof i.a)) {
              break label321;
            }
          }
          label321:
          paramc = new IllegalStateException("Unknown object in the tree!");
          AppMethodBeat.o(192625);
          throw paramc;
        }
      }
      AppMethodBeat.o(192625);
    }
    
    final void Mh()
    {
      AppMethodBeat.i(192672);
      this.ciW.reset();
      this.ciW.postTranslate(-this.ciS, -this.ciT);
      this.ciW.postScale(this.ceV, this.ceW);
      this.ciW.postRotate(this.ciR, 0.0F, 0.0F);
      this.ciW.postTranslate(this.ciU + this.ciS, this.ciV + this.ciT);
      AppMethodBeat.o(192672);
    }
    
    public final String getGroupName()
    {
      return this.ciX;
    }
    
    public final Matrix getLocalMatrix()
    {
      return this.ciW;
    }
    
    public final float getPivotX()
    {
      return this.ciS;
    }
    
    public final float getPivotY()
    {
      return this.ciT;
    }
    
    public final float getRotation()
    {
      return this.ciR;
    }
    
    public final float getScaleX()
    {
      return this.ceV;
    }
    
    public final float getScaleY()
    {
      return this.ceW;
    }
    
    public final float getTranslateX()
    {
      return this.ciU;
    }
    
    public final float getTranslateY()
    {
      return this.ciV;
    }
    
    public final boolean h(int[] paramArrayOfInt)
    {
      AppMethodBeat.i(192843);
      int i = 0;
      boolean bool = false;
      while (i < this.bkE.size())
      {
        bool |= ((i.d)this.bkE.get(i)).h(paramArrayOfInt);
        i += 1;
      }
      AppMethodBeat.o(192843);
      return bool;
    }
    
    public final boolean isStateful()
    {
      AppMethodBeat.i(192834);
      int i = 0;
      while (i < this.bkE.size())
      {
        if (((i.d)this.bkE.get(i)).isStateful())
        {
          AppMethodBeat.o(192834);
          return true;
        }
        i += 1;
      }
      AppMethodBeat.o(192834);
      return false;
    }
    
    public final void setPivotX(float paramFloat)
    {
      AppMethodBeat.i(192715);
      if (paramFloat != this.ciS)
      {
        this.ciS = paramFloat;
        Mh();
      }
      AppMethodBeat.o(192715);
    }
    
    public final void setPivotY(float paramFloat)
    {
      AppMethodBeat.i(192738);
      if (paramFloat != this.ciT)
      {
        this.ciT = paramFloat;
        Mh();
      }
      AppMethodBeat.o(192738);
    }
    
    public final void setRotation(float paramFloat)
    {
      AppMethodBeat.i(192688);
      if (paramFloat != this.ciR)
      {
        this.ciR = paramFloat;
        Mh();
      }
      AppMethodBeat.o(192688);
    }
    
    public final void setScaleX(float paramFloat)
    {
      AppMethodBeat.i(192760);
      if (paramFloat != this.ceV)
      {
        this.ceV = paramFloat;
        Mh();
      }
      AppMethodBeat.o(192760);
    }
    
    public final void setScaleY(float paramFloat)
    {
      AppMethodBeat.i(192781);
      if (paramFloat != this.ceW)
      {
        this.ceW = paramFloat;
        Mh();
      }
      AppMethodBeat.o(192781);
    }
    
    public final void setTranslateX(float paramFloat)
    {
      AppMethodBeat.i(192799);
      if (paramFloat != this.ciU)
      {
        this.ciU = paramFloat;
        Mh();
      }
      AppMethodBeat.o(192799);
    }
    
    public final void setTranslateY(float paramFloat)
    {
      AppMethodBeat.i(192821);
      if (paramFloat != this.ciV)
      {
        this.ciV = paramFloat;
        Mh();
      }
      AppMethodBeat.o(192821);
    }
  }
  
  static final class f
  {
    private static final Matrix cfz;
    private PathMeasure cfB;
    private final Path cja;
    private final Path cjb;
    private final Matrix cjc;
    Paint cjd;
    Paint cje;
    final i.c cjf;
    float cjg;
    float cjh;
    float cji;
    float cjj;
    int cjk;
    String cjl;
    Boolean cjm;
    final androidx.b.a<String, Object> cjn;
    private int mChangingConfigurations;
    
    static
    {
      AppMethodBeat.i(192653);
      cfz = new Matrix();
      AppMethodBeat.o(192653);
    }
    
    public f()
    {
      AppMethodBeat.i(192617);
      this.cjc = new Matrix();
      this.cjg = 0.0F;
      this.cjh = 0.0F;
      this.cji = 0.0F;
      this.cjj = 0.0F;
      this.cjk = 255;
      this.cjl = null;
      this.cjm = null;
      this.cjn = new androidx.b.a();
      this.cjf = new i.c();
      this.cja = new Path();
      this.cjb = new Path();
      AppMethodBeat.o(192617);
    }
    
    public f(f paramf)
    {
      AppMethodBeat.i(192629);
      this.cjc = new Matrix();
      this.cjg = 0.0F;
      this.cjh = 0.0F;
      this.cji = 0.0F;
      this.cjj = 0.0F;
      this.cjk = 255;
      this.cjl = null;
      this.cjm = null;
      this.cjn = new androidx.b.a();
      this.cjf = new i.c(paramf.cjf, this.cjn);
      this.cja = new Path(paramf.cja);
      this.cjb = new Path(paramf.cjb);
      this.cjg = paramf.cjg;
      this.cjh = paramf.cjh;
      this.cji = paramf.cji;
      this.cjj = paramf.cjj;
      this.mChangingConfigurations = paramf.mChangingConfigurations;
      this.cjk = paramf.cjk;
      this.cjl = paramf.cjl;
      if (paramf.cjl != null) {
        this.cjn.put(paramf.cjl, this);
      }
      this.cjm = paramf.cjm;
      AppMethodBeat.o(192629);
    }
    
    private void a(i.c paramc, Matrix paramMatrix, Canvas paramCanvas, int paramInt1, int paramInt2, ColorFilter paramColorFilter)
    {
      AppMethodBeat.i(192643);
      paramc.ciQ.set(paramMatrix);
      paramc.ciQ.preConcat(paramc.ciW);
      paramCanvas.save();
      int i = 0;
      if (i < paramc.bkE.size())
      {
        paramMatrix = (i.d)paramc.bkE.get(i);
        if ((paramMatrix instanceof i.c)) {
          a((i.c)paramMatrix, paramc.ciQ, paramCanvas, paramInt1, paramInt2, paramColorFilter);
        }
      }
      label644:
      label915:
      for (;;)
      {
        i += 1;
        break;
        if ((paramMatrix instanceof i.e))
        {
          paramMatrix = (i.e)paramMatrix;
          float f1 = paramInt1 / this.cji;
          float f3 = paramInt2 / this.cjj;
          float f2 = Math.min(f1, f3);
          Object localObject1 = paramc.ciQ;
          this.cjc.set((Matrix)localObject1);
          this.cjc.postScale(f1, f3);
          Object localObject2 = new float[4];
          tmp168_166 = localObject2;
          tmp168_166[0] = 0.0F;
          tmp172_168 = tmp168_166;
          tmp172_168[1] = 1.0F;
          tmp176_172 = tmp172_168;
          tmp176_172[2] = 1.0F;
          tmp180_176 = tmp176_172;
          tmp180_176[3] = 0.0F;
          tmp180_176;
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
              break label915;
            }
            paramMatrix.c(this.cja);
            localObject2 = this.cja;
            this.cjb.reset();
            if (paramMatrix.Mg())
            {
              this.cjb.addPath((Path)localObject2, this.cjc);
              paramCanvas.clipPath(this.cjb);
              break;
            }
            localObject1 = (i.b)paramMatrix;
            if ((((i.b)localObject1).ciK != 0.0F) || (((i.b)localObject1).ciL != 1.0F))
            {
              f6 = ((i.b)localObject1).ciK;
              f7 = ((i.b)localObject1).ciM;
              f4 = ((i.b)localObject1).ciL;
              f5 = ((i.b)localObject1).ciM;
              if (this.cfB == null) {
                this.cfB = new PathMeasure();
              }
              this.cfB.setPath(this.cja, false);
              f3 = this.cfB.getLength();
              f6 = (f6 + f7) % 1.0F * f3;
              f4 = (f4 + f5) % 1.0F * f3;
              ((Path)localObject2).reset();
              if (f6 > f4)
              {
                this.cfB.getSegment(f6, f3, (Path)localObject2, true);
                this.cfB.getSegment(0.0F, f4, (Path)localObject2, true);
                label502:
                ((Path)localObject2).rLineTo(0.0F, 0.0F);
              }
            }
            else
            {
              this.cjb.addPath((Path)localObject2, this.cjc);
              if (((i.b)localObject1).ciG.DF())
              {
                paramMatrix = ((i.b)localObject1).ciG;
                if (this.cje == null)
                {
                  this.cje = new Paint(1);
                  this.cje.setStyle(Paint.Style.FILL);
                }
                localObject2 = this.cje;
                if (!paramMatrix.DE()) {
                  break label854;
                }
                paramMatrix = paramMatrix.sK();
                paramMatrix.setLocalMatrix(this.cjc);
                ((Paint)localObject2).setShader(paramMatrix);
                ((Paint)localObject2).setAlpha(Math.round(((i.b)localObject1).ciJ * 255.0F));
                label618:
                ((Paint)localObject2).setColorFilter(paramColorFilter);
                Path localPath = this.cjb;
                if (((i.b)localObject1).ciI != 0) {
                  break label874;
                }
                paramMatrix = Path.FillType.WINDING;
                localPath.setFillType(paramMatrix);
                paramCanvas.drawPath(this.cjb, (Paint)localObject2);
              }
              if (!((i.b)localObject1).ciF.DF()) {
                break;
              }
              localObject2 = ((i.b)localObject1).ciF;
              if (this.cjd == null)
              {
                this.cjd = new Paint(1);
                this.cjd.setStyle(Paint.Style.STROKE);
              }
              paramMatrix = this.cjd;
              if (((i.b)localObject1).ciO != null) {
                paramMatrix.setStrokeJoin(((i.b)localObject1).ciO);
              }
              if (((i.b)localObject1).ciN != null) {
                paramMatrix.setStrokeCap(((i.b)localObject1).ciN);
              }
              paramMatrix.setStrokeMiter(((i.b)localObject1).ciP);
              if (!((b)localObject2).DE()) {
                break label881;
              }
              localObject2 = ((b)localObject2).sK();
              ((Shader)localObject2).setLocalMatrix(this.cjc);
              paramMatrix.setShader((Shader)localObject2);
              paramMatrix.setAlpha(Math.round(((i.b)localObject1).ciH * 255.0F));
            }
            for (;;)
            {
              paramMatrix.setColorFilter(paramColorFilter);
              paramMatrix.setStrokeWidth(((i.b)localObject1).mStrokeWidth * (f2 * f1));
              paramCanvas.drawPath(this.cjb, paramMatrix);
              break;
              this.cfB.getSegment(f6, f4, (Path)localObject2, true);
              break label502;
              label854:
              ((Paint)localObject2).setColor(i.h(paramMatrix.getColor(), ((i.b)localObject1).ciJ));
              break label618;
              label874:
              paramMatrix = Path.FillType.EVEN_ODD;
              break label644;
              label881:
              paramMatrix.setColor(i.h(((b)localObject2).getColor(), ((i.b)localObject1).ciH));
            }
            paramCanvas.restore();
            AppMethodBeat.o(192643);
            return;
          }
        }
      }
    }
    
    public final void a(Canvas paramCanvas, int paramInt1, int paramInt2)
    {
      AppMethodBeat.i(192698);
      a(this.cjf, cfz, paramCanvas, paramInt1, paramInt2, null);
      AppMethodBeat.o(192698);
    }
    
    public final float getAlpha()
    {
      AppMethodBeat.i(192686);
      float f = getRootAlpha() / 255.0F;
      AppMethodBeat.o(192686);
      return f;
    }
    
    public final int getRootAlpha()
    {
      return this.cjk;
    }
    
    public final boolean isStateful()
    {
      AppMethodBeat.i(192710);
      if (this.cjm == null) {
        this.cjm = Boolean.valueOf(this.cjf.isStateful());
      }
      boolean bool = this.cjm.booleanValue();
      AppMethodBeat.o(192710);
      return bool;
    }
    
    public final void setAlpha(float paramFloat)
    {
      AppMethodBeat.i(192679);
      setRootAlpha((int)(255.0F * paramFloat));
      AppMethodBeat.o(192679);
    }
    
    public final void setRootAlpha(int paramInt)
    {
      this.cjk = paramInt;
    }
  }
  
  static final class g
    extends Drawable.ConstantState
  {
    ColorStateList Rq;
    i.f cjo;
    Bitmap cjp;
    ColorStateList cjq;
    PorterDuff.Mode cjr;
    int cjs;
    boolean cjt;
    boolean cju;
    Paint cjv;
    PorterDuff.Mode kA;
    boolean kw;
    int mChangingConfigurations;
    
    public g()
    {
      AppMethodBeat.i(192628);
      this.Rq = null;
      this.kA = i.bqY;
      this.cjo = new i.f();
      AppMethodBeat.o(192628);
    }
    
    public g(g paramg)
    {
      AppMethodBeat.i(192615);
      this.Rq = null;
      this.kA = i.bqY;
      if (paramg != null)
      {
        this.mChangingConfigurations = paramg.mChangingConfigurations;
        this.cjo = new i.f(paramg.cjo);
        if (paramg.cjo.cje != null) {
          this.cjo.cje = new Paint(paramg.cjo.cje);
        }
        if (paramg.cjo.cjd != null) {
          this.cjo.cjd = new Paint(paramg.cjo.cjd);
        }
        this.Rq = paramg.Rq;
        this.kA = paramg.kA;
        this.kw = paramg.kw;
      }
      AppMethodBeat.o(192615);
    }
    
    public final void bR(int paramInt1, int paramInt2)
    {
      AppMethodBeat.i(192639);
      this.cjp.eraseColor(0);
      Canvas localCanvas = new Canvas(this.cjp);
      this.cjo.a(localCanvas, paramInt1, paramInt2);
      AppMethodBeat.o(192639);
    }
    
    public final int getChangingConfigurations()
    {
      return this.mChangingConfigurations;
    }
    
    public final Drawable newDrawable()
    {
      AppMethodBeat.i(192650);
      i locali = new i(this);
      AppMethodBeat.o(192650);
      return locali;
    }
    
    public final Drawable newDrawable(Resources paramResources)
    {
      AppMethodBeat.i(192662);
      paramResources = new i(this);
      AppMethodBeat.o(192662);
      return paramResources;
    }
  }
  
  static final class h
    extends Drawable.ConstantState
  {
    private final Drawable.ConstantState ciu;
    
    public h(Drawable.ConstantState paramConstantState)
    {
      this.ciu = paramConstantState;
    }
    
    public final boolean canApplyTheme()
    {
      AppMethodBeat.i(192655);
      boolean bool = this.ciu.canApplyTheme();
      AppMethodBeat.o(192655);
      return bool;
    }
    
    public final int getChangingConfigurations()
    {
      AppMethodBeat.i(192666);
      int i = this.ciu.getChangingConfigurations();
      AppMethodBeat.o(192666);
      return i;
    }
    
    public final Drawable newDrawable()
    {
      AppMethodBeat.i(192623);
      i locali = new i();
      locali.cix = ((VectorDrawable)this.ciu.newDrawable());
      AppMethodBeat.o(192623);
      return locali;
    }
    
    public final Drawable newDrawable(Resources paramResources)
    {
      AppMethodBeat.i(192634);
      i locali = new i();
      locali.cix = ((VectorDrawable)this.ciu.newDrawable(paramResources));
      AppMethodBeat.o(192634);
      return locali;
    }
    
    public final Drawable newDrawable(Resources paramResources, Resources.Theme paramTheme)
    {
      AppMethodBeat.i(192647);
      i locali = new i();
      locali.cix = ((VectorDrawable)this.ciu.newDrawable(paramResources, paramTheme));
      AppMethodBeat.o(192647);
      return locali;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes10.jar
 * Qualified Name:     androidx.l.a.a.i
 * JD-Core Version:    0.7.0.1
 */