package androidx.k.a.a;

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
import androidx.core.graphics.d.b;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.io.IOException;
import java.util.ArrayDeque;
import java.util.ArrayList;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;

public final class i
  extends h
{
  static final PorterDuff.Mode KQ = PorterDuff.Mode.SRC_IN;
  g aub;
  boolean auc;
  private Drawable.ConstantState aud;
  private final float[] aue;
  private final Matrix auf;
  private final Rect aug;
  private boolean iF;
  private ColorFilter jC;
  private PorterDuffColorFilter za;
  
  i()
  {
    AppMethodBeat.i(213193);
    this.auc = true;
    this.aue = new float[9];
    this.auf = new Matrix();
    this.aug = new Rect();
    this.aub = new g();
    AppMethodBeat.o(213193);
  }
  
  i(g paramg)
  {
    AppMethodBeat.i(213196);
    this.auc = true;
    this.aue = new float[9];
    this.auf = new Matrix();
    this.aug = new Rect();
    this.aub = paramg;
    this.za = b(paramg.zb, paramg.jF);
    AppMethodBeat.o(213196);
  }
  
  private PorterDuffColorFilter b(ColorStateList paramColorStateList, PorterDuff.Mode paramMode)
  {
    AppMethodBeat.i(213217);
    if ((paramColorStateList == null) || (paramMode == null))
    {
      AppMethodBeat.o(213217);
      return null;
    }
    paramColorStateList = new PorterDuffColorFilter(paramColorStateList.getColorForState(getState(), 0), paramMode);
    AppMethodBeat.o(213217);
    return paramColorStateList;
  }
  
  public static i c(Resources paramResources, int paramInt, Resources.Theme paramTheme)
  {
    AppMethodBeat.i(213244);
    Object localObject;
    if (Build.VERSION.SDK_INT >= 24)
    {
      localObject = new i();
      ((i)localObject).aua = f.b(paramResources, paramInt, paramTheme);
      ((i)localObject).aud = new h(((i)localObject).aua.getConstantState());
      AppMethodBeat.o(213244);
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
        AppMethodBeat.o(213244);
        throw paramResources;
      }
    }
    catch (XmlPullParserException paramResources)
    {
      AttributeSet localAttributeSet;
      AppMethodBeat.o(213244);
      return null;
      paramResources = d(paramResources, (XmlPullParser)localObject, localAttributeSet, paramTheme);
      AppMethodBeat.o(213244);
      return paramResources;
    }
    catch (IOException paramResources)
    {
      label108:
      break label108;
    }
  }
  
  public static i d(Resources paramResources, XmlPullParser paramXmlPullParser, AttributeSet paramAttributeSet, Resources.Theme paramTheme)
  {
    AppMethodBeat.i(213246);
    i locali = new i();
    locali.inflate(paramResources, paramXmlPullParser, paramAttributeSet, paramTheme);
    AppMethodBeat.o(213246);
    return locali;
  }
  
  static int e(int paramInt, float paramFloat)
  {
    AppMethodBeat.i(213247);
    int i = (int)(Color.alpha(paramInt) * paramFloat);
    AppMethodBeat.o(213247);
    return i << 24 | 0xFFFFFF & paramInt;
  }
  
  private void e(Resources paramResources, XmlPullParser paramXmlPullParser, AttributeSet paramAttributeSet, Resources.Theme paramTheme)
  {
    AppMethodBeat.i(213256);
    g localg = this.aub;
    f localf = localg.auR;
    int i = 1;
    ArrayDeque localArrayDeque = new ArrayDeque();
    localArrayDeque.push(localf.auI);
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
          localTypedArray = g.a(paramResources, paramTheme, paramAttributeSet, a.atG);
          ((b)localObject).a(localTypedArray, paramXmlPullParser, paramTheme);
          localTypedArray.recycle();
          localc.Ew.add(localObject);
          if (((b)localObject).getPathName() != null) {
            localf.auQ.put(((b)localObject).getPathName(), localObject);
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
            localTypedArray = g.a(paramResources, paramTheme, paramAttributeSet, a.atH);
            ((a)localObject).b(localTypedArray);
            localTypedArray.recycle();
          }
          localc.Ew.add(localObject);
          if (((a)localObject).getPathName() != null) {
            localf.auQ.put(((a)localObject).getPathName(), localObject);
          }
          localg.mChangingConfigurations |= ((a)localObject).mChangingConfigurations;
        }
        else
        {
          if ("group".equals(localObject))
          {
            localObject = new c();
            localTypedArray = g.a(paramResources, paramTheme, paramAttributeSet, a.atF);
            ((c)localObject).auh = null;
            ((c)localObject).auu = g.a(localTypedArray, paramXmlPullParser, "rotation", 5, ((c)localObject).auu);
            ((c)localObject).auv = localTypedArray.getFloat(1, ((c)localObject).auv);
            ((c)localObject).auw = localTypedArray.getFloat(2, ((c)localObject).auw);
            ((c)localObject).aqn = g.a(localTypedArray, paramXmlPullParser, "scaleX", 3, ((c)localObject).aqn);
            ((c)localObject).aqo = g.a(localTypedArray, paramXmlPullParser, "scaleY", 4, ((c)localObject).aqo);
            ((c)localObject).aux = g.a(localTypedArray, paramXmlPullParser, "translateX", 6, ((c)localObject).aux);
            ((c)localObject).auy = g.a(localTypedArray, paramXmlPullParser, "translateY", 7, ((c)localObject).auy);
            String str = localTypedArray.getString(0);
            if (str != null) {
              ((c)localObject).auA = str;
            }
            ((c)localObject).nD();
            localTypedArray.recycle();
            localc.Ew.add(localObject);
            localArrayDeque.push(localObject);
            if (((c)localObject).getGroupName() != null) {
              localf.auQ.put(((c)localObject).getGroupName(), localObject);
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
      AppMethodBeat.o(213256);
      throw paramResources;
    }
    AppMethodBeat.o(213256);
  }
  
  public final boolean canApplyTheme()
  {
    AppMethodBeat.i(213234);
    if (this.aua != null) {
      androidx.core.graphics.drawable.a.n(this.aua);
    }
    AppMethodBeat.o(213234);
    return false;
  }
  
  public final void draw(Canvas paramCanvas)
  {
    AppMethodBeat.i(213205);
    if (this.aua != null)
    {
      this.aua.draw(paramCanvas);
      AppMethodBeat.o(213205);
      return;
    }
    copyBounds(this.aug);
    if ((this.aug.width() <= 0) || (this.aug.height() <= 0))
    {
      AppMethodBeat.o(213205);
      return;
    }
    if (this.jC == null) {}
    int i;
    int k;
    int m;
    for (Object localObject = this.za;; localObject = this.jC)
    {
      paramCanvas.getMatrix(this.auf);
      this.auf.getValues(this.aue);
      float f2 = Math.abs(this.aue[0]);
      float f1 = Math.abs(this.aue[4]);
      float f4 = Math.abs(this.aue[1]);
      float f3 = Math.abs(this.aue[3]);
      if ((f4 != 0.0F) || (f3 != 0.0F))
      {
        f1 = 1.0F;
        f2 = 1.0F;
      }
      j = (int)(f2 * this.aug.width());
      i = (int)(f1 * this.aug.height());
      k = Math.min(2048, j);
      m = Math.min(2048, i);
      if ((k > 0) && (m > 0)) {
        break;
      }
      AppMethodBeat.o(213205);
      return;
    }
    int j = paramCanvas.save();
    paramCanvas.translate(this.aug.left, this.aug.top);
    g localg;
    label357:
    Rect localRect;
    if (Build.VERSION.SDK_INT >= 17) {
      if ((isAutoMirrored()) && (androidx.core.graphics.drawable.a.r(this) == 1))
      {
        i = 1;
        if (i != 0)
        {
          paramCanvas.translate(this.aug.width(), 0.0F);
          paramCanvas.scale(-1.0F, 1.0F);
        }
        this.aug.offsetTo(0, 0);
        localg = this.aub;
        if (localg.auS != null)
        {
          if ((k != localg.auS.getWidth()) || (m != localg.auS.getHeight())) {
            break label482;
          }
          i = 1;
          if (i != 0) {}
        }
        else
        {
          localg.auS = Bitmap.createBitmap(k, m, Bitmap.Config.ARGB_8888);
          localg.auX = true;
        }
        if (this.auc) {
          break label488;
        }
        this.aub.aX(k, m);
        label401:
        localg = this.aub;
        localRect = this.aug;
        if (localg.auR.getRootAlpha() >= 255) {
          break label640;
        }
        i = 1;
        label430:
        if ((i != 0) || (localObject != null)) {
          break label646;
        }
      }
    }
    for (localObject = null;; localObject = localg.auY)
    {
      paramCanvas.drawBitmap(localg.auS, null, localRect, (Paint)localObject);
      paramCanvas.restoreToCount(j);
      AppMethodBeat.o(213205);
      return;
      i = 0;
      break;
      i = 0;
      break;
      label482:
      i = 0;
      break label357;
      label488:
      localg = this.aub;
      if ((!localg.auX) && (localg.auT == localg.zb) && (localg.auU == localg.jF) && (localg.auW == localg.jB) && (localg.auV == localg.auR.getRootAlpha())) {}
      for (i = 1;; i = 0)
      {
        if (i != 0) {
          break label638;
        }
        this.aub.aX(k, m);
        localg = this.aub;
        localg.auT = localg.zb;
        localg.auU = localg.jF;
        localg.auV = localg.auR.getRootAlpha();
        localg.auW = localg.jB;
        localg.auX = false;
        break;
      }
      label638:
      break label401;
      label640:
      i = 0;
      break label430;
      label646:
      if (localg.auY == null)
      {
        localg.auY = new Paint();
        localg.auY.setFilterBitmap(true);
      }
      localg.auY.setAlpha(localg.auR.getRootAlpha());
      localg.auY.setColorFilter((ColorFilter)localObject);
    }
  }
  
  public final int getAlpha()
  {
    AppMethodBeat.i(213206);
    if (this.aua != null)
    {
      i = androidx.core.graphics.drawable.a.m(this.aua);
      AppMethodBeat.o(213206);
      return i;
    }
    int i = this.aub.auR.getRootAlpha();
    AppMethodBeat.o(213206);
    return i;
  }
  
  public final int getChangingConfigurations()
  {
    AppMethodBeat.i(213262);
    if (this.aua != null)
    {
      i = this.aua.getChangingConfigurations();
      AppMethodBeat.o(213262);
      return i;
    }
    int i = super.getChangingConfigurations();
    int j = this.aub.getChangingConfigurations();
    AppMethodBeat.o(213262);
    return i | j;
  }
  
  public final Drawable.ConstantState getConstantState()
  {
    AppMethodBeat.i(213201);
    if ((this.aua != null) && (Build.VERSION.SDK_INT >= 24))
    {
      localObject = new h(this.aua.getConstantState());
      AppMethodBeat.o(213201);
      return localObject;
    }
    this.aub.mChangingConfigurations = getChangingConfigurations();
    Object localObject = this.aub;
    AppMethodBeat.o(213201);
    return localObject;
  }
  
  public final int getIntrinsicHeight()
  {
    AppMethodBeat.i(213232);
    if (this.aua != null)
    {
      i = this.aua.getIntrinsicHeight();
      AppMethodBeat.o(213232);
      return i;
    }
    int i = (int)this.aub.auR.auK;
    AppMethodBeat.o(213232);
    return i;
  }
  
  public final int getIntrinsicWidth()
  {
    AppMethodBeat.i(213230);
    if (this.aua != null)
    {
      i = this.aua.getIntrinsicWidth();
      AppMethodBeat.o(213230);
      return i;
    }
    int i = (int)this.aub.auR.auJ;
    AppMethodBeat.o(213230);
    return i;
  }
  
  public final int getOpacity()
  {
    AppMethodBeat.i(213229);
    if (this.aua != null)
    {
      int i = this.aua.getOpacity();
      AppMethodBeat.o(213229);
      return i;
    }
    AppMethodBeat.o(213229);
    return -3;
  }
  
  public final void inflate(Resources paramResources, XmlPullParser paramXmlPullParser, AttributeSet paramAttributeSet)
  {
    AppMethodBeat.i(213249);
    if (this.aua != null)
    {
      this.aua.inflate(paramResources, paramXmlPullParser, paramAttributeSet);
      AppMethodBeat.o(213249);
      return;
    }
    inflate(paramResources, paramXmlPullParser, paramAttributeSet, null);
    AppMethodBeat.o(213249);
  }
  
  public final void inflate(Resources paramResources, XmlPullParser paramXmlPullParser, AttributeSet paramAttributeSet, Resources.Theme paramTheme)
  {
    AppMethodBeat.i(213253);
    if (this.aua != null)
    {
      androidx.core.graphics.drawable.a.a(this.aua, paramResources, paramXmlPullParser, paramAttributeSet, paramTheme);
      AppMethodBeat.o(213253);
      return;
    }
    g localg1 = this.aub;
    localg1.auR = new f();
    TypedArray localTypedArray = g.a(paramResources, paramTheme, paramAttributeSet, a.atE);
    g localg2 = this.aub;
    f localf = localg2.auR;
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
      localg2.jF = ((PorterDuff.Mode)localObject);
      localObject = localTypedArray.getColorStateList(1);
      if (localObject != null) {
        localg2.zb = ((ColorStateList)localObject);
      }
      localg2.jB = g.a(localTypedArray, paramXmlPullParser, "autoMirrored", 5, localg2.jB);
      localf.auL = g.a(localTypedArray, paramXmlPullParser, "viewportWidth", 7, localf.auL);
      localf.auM = g.a(localTypedArray, paramXmlPullParser, "viewportHeight", 8, localf.auM);
      if (localf.auL > 0.0F) {
        break;
      }
      paramResources = new XmlPullParserException(localTypedArray.getPositionDescription() + "<vector> tag requires viewportWidth > 0");
      AppMethodBeat.o(213253);
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
    if (localf.auM <= 0.0F)
    {
      paramResources = new XmlPullParserException(localTypedArray.getPositionDescription() + "<vector> tag requires viewportHeight > 0");
      AppMethodBeat.o(213253);
      throw paramResources;
    }
    localf.auJ = localTypedArray.getDimension(3, localf.auJ);
    localf.auK = localTypedArray.getDimension(2, localf.auK);
    if (localf.auJ <= 0.0F)
    {
      paramResources = new XmlPullParserException(localTypedArray.getPositionDescription() + "<vector> tag requires width > 0");
      AppMethodBeat.o(213253);
      throw paramResources;
    }
    if (localf.auK <= 0.0F)
    {
      paramResources = new XmlPullParserException(localTypedArray.getPositionDescription() + "<vector> tag requires height > 0");
      AppMethodBeat.o(213253);
      throw paramResources;
    }
    localf.setAlpha(g.a(localTypedArray, paramXmlPullParser, "alpha", 4, localf.getAlpha()));
    localObject = localTypedArray.getString(0);
    if (localObject != null)
    {
      localf.auO = ((String)localObject);
      localf.auQ.put(localObject, localf);
    }
    localTypedArray.recycle();
    localg1.mChangingConfigurations = getChangingConfigurations();
    localg1.auX = true;
    e(paramResources, paramXmlPullParser, paramAttributeSet, paramTheme);
    this.za = b(localg1.zb, localg1.jF);
    AppMethodBeat.o(213253);
  }
  
  public final void invalidateSelf()
  {
    AppMethodBeat.i(213264);
    if (this.aua != null)
    {
      this.aua.invalidateSelf();
      AppMethodBeat.o(213264);
      return;
    }
    super.invalidateSelf();
    AppMethodBeat.o(213264);
  }
  
  public final boolean isAutoMirrored()
  {
    AppMethodBeat.i(213237);
    if (this.aua != null)
    {
      bool = androidx.core.graphics.drawable.a.l(this.aua);
      AppMethodBeat.o(213237);
      return bool;
    }
    boolean bool = this.aub.jB;
    AppMethodBeat.o(213237);
    return bool;
  }
  
  public final boolean isStateful()
  {
    AppMethodBeat.i(213226);
    if (this.aua != null)
    {
      boolean bool = this.aua.isStateful();
      AppMethodBeat.o(213226);
      return bool;
    }
    if ((super.isStateful()) || ((this.aub != null) && ((this.aub.auR.isStateful()) || ((this.aub.zb != null) && (this.aub.zb.isStateful())))))
    {
      AppMethodBeat.o(213226);
      return true;
    }
    AppMethodBeat.o(213226);
    return false;
  }
  
  public final Drawable mutate()
  {
    AppMethodBeat.i(213198);
    if (this.aua != null)
    {
      this.aua.mutate();
      AppMethodBeat.o(213198);
      return this;
    }
    if ((!this.iF) && (super.mutate() == this))
    {
      this.aub = new g(this.aub);
      this.iF = true;
    }
    AppMethodBeat.o(213198);
    return this;
  }
  
  protected final void onBoundsChange(Rect paramRect)
  {
    AppMethodBeat.i(213258);
    if (this.aua != null) {
      this.aua.setBounds(paramRect);
    }
    AppMethodBeat.o(213258);
  }
  
  protected final boolean onStateChange(int[] paramArrayOfInt)
  {
    AppMethodBeat.i(213227);
    if (this.aua != null)
    {
      bool1 = this.aua.setState(paramArrayOfInt);
      AppMethodBeat.o(213227);
      return bool1;
    }
    boolean bool2 = false;
    g localg = this.aub;
    boolean bool1 = bool2;
    if (localg.zb != null)
    {
      bool1 = bool2;
      if (localg.jF != null)
      {
        this.za = b(localg.zb, localg.jF);
        invalidateSelf();
        bool1 = true;
      }
    }
    bool2 = bool1;
    if (localg.auR.isStateful())
    {
      boolean bool3 = localg.auR.auI.e(paramArrayOfInt);
      localg.auX |= bool3;
      bool2 = bool1;
      if (bool3)
      {
        invalidateSelf();
        bool2 = true;
      }
    }
    AppMethodBeat.o(213227);
    return bool2;
  }
  
  public final void scheduleSelf(Runnable paramRunnable, long paramLong)
  {
    AppMethodBeat.i(213267);
    if (this.aua != null)
    {
      this.aua.scheduleSelf(paramRunnable, paramLong);
      AppMethodBeat.o(213267);
      return;
    }
    super.scheduleSelf(paramRunnable, paramLong);
    AppMethodBeat.o(213267);
  }
  
  public final void setAlpha(int paramInt)
  {
    AppMethodBeat.i(213212);
    if (this.aua != null)
    {
      this.aua.setAlpha(paramInt);
      AppMethodBeat.o(213212);
      return;
    }
    if (this.aub.auR.getRootAlpha() != paramInt)
    {
      this.aub.auR.setRootAlpha(paramInt);
      invalidateSelf();
    }
    AppMethodBeat.o(213212);
  }
  
  public final void setAutoMirrored(boolean paramBoolean)
  {
    AppMethodBeat.i(213239);
    if (this.aua != null)
    {
      androidx.core.graphics.drawable.a.b(this.aua, paramBoolean);
      AppMethodBeat.o(213239);
      return;
    }
    this.aub.jB = paramBoolean;
    AppMethodBeat.o(213239);
  }
  
  public final void setColorFilter(ColorFilter paramColorFilter)
  {
    AppMethodBeat.i(213214);
    if (this.aua != null)
    {
      this.aua.setColorFilter(paramColorFilter);
      AppMethodBeat.o(213214);
      return;
    }
    this.jC = paramColorFilter;
    invalidateSelf();
    AppMethodBeat.o(213214);
  }
  
  public final void setTint(int paramInt)
  {
    AppMethodBeat.i(213220);
    if (this.aua != null)
    {
      androidx.core.graphics.drawable.a.a(this.aua, paramInt);
      AppMethodBeat.o(213220);
      return;
    }
    setTintList(ColorStateList.valueOf(paramInt));
    AppMethodBeat.o(213220);
  }
  
  public final void setTintList(ColorStateList paramColorStateList)
  {
    AppMethodBeat.i(213223);
    if (this.aua != null)
    {
      androidx.core.graphics.drawable.a.a(this.aua, paramColorStateList);
      AppMethodBeat.o(213223);
      return;
    }
    g localg = this.aub;
    if (localg.zb != paramColorStateList)
    {
      localg.zb = paramColorStateList;
      this.za = b(paramColorStateList, localg.jF);
      invalidateSelf();
    }
    AppMethodBeat.o(213223);
  }
  
  public final void setTintMode(PorterDuff.Mode paramMode)
  {
    AppMethodBeat.i(213225);
    if (this.aua != null)
    {
      androidx.core.graphics.drawable.a.a(this.aua, paramMode);
      AppMethodBeat.o(213225);
      return;
    }
    g localg = this.aub;
    if (localg.jF != paramMode)
    {
      localg.jF = paramMode;
      this.za = b(localg.zb, paramMode);
      invalidateSelf();
    }
    AppMethodBeat.o(213225);
  }
  
  public final boolean setVisible(boolean paramBoolean1, boolean paramBoolean2)
  {
    AppMethodBeat.i(213269);
    if (this.aua != null)
    {
      paramBoolean1 = this.aua.setVisible(paramBoolean1, paramBoolean2);
      AppMethodBeat.o(213269);
      return paramBoolean1;
    }
    paramBoolean1 = super.setVisible(paramBoolean1, paramBoolean2);
    AppMethodBeat.o(213269);
    return paramBoolean1;
  }
  
  public final void unscheduleSelf(Runnable paramRunnable)
  {
    AppMethodBeat.i(213272);
    if (this.aua != null)
    {
      this.aua.unscheduleSelf(paramRunnable);
      AppMethodBeat.o(213272);
      return;
    }
    super.unscheduleSelf(paramRunnable);
    AppMethodBeat.o(213272);
  }
  
  static final class a
    extends i.e
  {
    public a() {}
    
    public a(a parama)
    {
      super();
    }
    
    final void b(TypedArray paramTypedArray)
    {
      AppMethodBeat.i(213003);
      String str = paramTypedArray.getString(0);
      if (str != null) {
        this.auC = str;
      }
      paramTypedArray = paramTypedArray.getString(1);
      if (paramTypedArray != null) {
        this.auB = d.B(paramTypedArray);
      }
      AppMethodBeat.o(213003);
    }
    
    public final boolean nC()
    {
      return true;
    }
  }
  
  static final class b
    extends i.e
  {
    private int[] auh;
    b aui;
    b auj;
    float auk = 1.0F;
    int aul = 0;
    float aum = 1.0F;
    float aun = 0.0F;
    float auo = 1.0F;
    float aup = 0.0F;
    Paint.Cap auq = Paint.Cap.BUTT;
    Paint.Join aur = Paint.Join.MITER;
    float aus = 4.0F;
    float mStrokeWidth = 0.0F;
    
    public b() {}
    
    public b(b paramb)
    {
      super();
      this.auh = paramb.auh;
      this.aui = paramb.aui;
      this.mStrokeWidth = paramb.mStrokeWidth;
      this.auk = paramb.auk;
      this.auj = paramb.auj;
      this.aul = paramb.aul;
      this.aum = paramb.aum;
      this.aun = paramb.aun;
      this.auo = paramb.auo;
      this.aup = paramb.aup;
      this.auq = paramb.auq;
      this.aur = paramb.aur;
      this.aus = paramb.aus;
    }
    
    final void a(TypedArray paramTypedArray, XmlPullParser paramXmlPullParser, Resources.Theme paramTheme)
    {
      AppMethodBeat.i(213013);
      this.auh = null;
      if (!g.a(paramXmlPullParser, "pathData"))
      {
        AppMethodBeat.o(213013);
        return;
      }
      Object localObject = paramTypedArray.getString(0);
      if (localObject != null) {
        this.auC = ((String)localObject);
      }
      localObject = paramTypedArray.getString(2);
      if (localObject != null) {
        this.auB = d.B((String)localObject);
      }
      this.auj = g.a(paramTypedArray, paramXmlPullParser, paramTheme, "fillColor", 1);
      this.aum = g.a(paramTypedArray, paramXmlPullParser, "fillAlpha", 12, this.aum);
      int i = g.a(paramTypedArray, paramXmlPullParser, "strokeLineCap", 8, -1);
      localObject = this.auq;
      switch (i)
      {
      default: 
        this.auq = ((Paint.Cap)localObject);
        i = g.a(paramTypedArray, paramXmlPullParser, "strokeLineJoin", 9, -1);
        localObject = this.aur;
        switch (i)
        {
        }
        break;
      }
      for (;;)
      {
        this.aur = ((Paint.Join)localObject);
        this.aus = g.a(paramTypedArray, paramXmlPullParser, "strokeMiterLimit", 10, this.aus);
        this.aui = g.a(paramTypedArray, paramXmlPullParser, paramTheme, "strokeColor", 3);
        this.auk = g.a(paramTypedArray, paramXmlPullParser, "strokeAlpha", 11, this.auk);
        this.mStrokeWidth = g.a(paramTypedArray, paramXmlPullParser, "strokeWidth", 4, this.mStrokeWidth);
        this.auo = g.a(paramTypedArray, paramXmlPullParser, "trimPathEnd", 6, this.auo);
        this.aup = g.a(paramTypedArray, paramXmlPullParser, "trimPathOffset", 7, this.aup);
        this.aun = g.a(paramTypedArray, paramXmlPullParser, "trimPathStart", 5, this.aun);
        this.aul = g.a(paramTypedArray, paramXmlPullParser, "fillType", 13, this.aul);
        AppMethodBeat.o(213013);
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
      AppMethodBeat.i(213016);
      boolean bool1 = this.auj.e(paramArrayOfInt);
      boolean bool2 = this.aui.e(paramArrayOfInt);
      AppMethodBeat.o(213016);
      return bool1 | bool2;
    }
    
    final float getFillAlpha()
    {
      return this.aum;
    }
    
    final int getFillColor()
    {
      return this.auj.mColor;
    }
    
    final float getStrokeAlpha()
    {
      return this.auk;
    }
    
    final int getStrokeColor()
    {
      return this.aui.mColor;
    }
    
    final float getStrokeWidth()
    {
      return this.mStrokeWidth;
    }
    
    final float getTrimPathEnd()
    {
      return this.auo;
    }
    
    final float getTrimPathOffset()
    {
      return this.aup;
    }
    
    final float getTrimPathStart()
    {
      return this.aun;
    }
    
    public final boolean isStateful()
    {
      AppMethodBeat.i(213015);
      if ((this.auj.isStateful()) || (this.aui.isStateful()))
      {
        AppMethodBeat.o(213015);
        return true;
      }
      AppMethodBeat.o(213015);
      return false;
    }
    
    final void setFillAlpha(float paramFloat)
    {
      this.aum = paramFloat;
    }
    
    final void setFillColor(int paramInt)
    {
      this.auj.mColor = paramInt;
    }
    
    final void setStrokeAlpha(float paramFloat)
    {
      this.auk = paramFloat;
    }
    
    final void setStrokeColor(int paramInt)
    {
      this.aui.mColor = paramInt;
    }
    
    final void setStrokeWidth(float paramFloat)
    {
      this.mStrokeWidth = paramFloat;
    }
    
    final void setTrimPathEnd(float paramFloat)
    {
      this.auo = paramFloat;
    }
    
    final void setTrimPathOffset(float paramFloat)
    {
      this.aup = paramFloat;
    }
    
    final void setTrimPathStart(float paramFloat)
    {
      this.aun = paramFloat;
    }
  }
  
  static final class c
    extends i.d
  {
    final ArrayList<i.d> Ew;
    float aqn;
    float aqo;
    String auA;
    int[] auh;
    final Matrix aut;
    float auu;
    float auv;
    float auw;
    float aux;
    float auy;
    final Matrix auz;
    int mChangingConfigurations;
    
    public c()
    {
      super();
      AppMethodBeat.i(213048);
      this.aut = new Matrix();
      this.Ew = new ArrayList();
      this.auu = 0.0F;
      this.auv = 0.0F;
      this.auw = 0.0F;
      this.aqn = 1.0F;
      this.aqo = 1.0F;
      this.aux = 0.0F;
      this.auy = 0.0F;
      this.auz = new Matrix();
      this.auA = null;
      AppMethodBeat.o(213048);
    }
    
    public c(c paramc, androidx.b.a<String, Object> parama)
    {
      super();
      AppMethodBeat.i(213046);
      this.aut = new Matrix();
      this.Ew = new ArrayList();
      this.auu = 0.0F;
      this.auv = 0.0F;
      this.auw = 0.0F;
      this.aqn = 1.0F;
      this.aqo = 1.0F;
      this.aux = 0.0F;
      this.auy = 0.0F;
      this.auz = new Matrix();
      this.auA = null;
      this.auu = paramc.auu;
      this.auv = paramc.auv;
      this.auw = paramc.auw;
      this.aqn = paramc.aqn;
      this.aqo = paramc.aqo;
      this.aux = paramc.aux;
      this.auy = paramc.auy;
      this.auh = paramc.auh;
      this.auA = paramc.auA;
      this.mChangingConfigurations = paramc.mChangingConfigurations;
      if (this.auA != null) {
        parama.put(this.auA, this);
      }
      this.auz.set(paramc.auz);
      ArrayList localArrayList = paramc.Ew;
      int i = 0;
      while (i < localArrayList.size())
      {
        paramc = localArrayList.get(i);
        if ((paramc instanceof c))
        {
          paramc = (c)paramc;
          this.Ew.add(new c(paramc, parama));
          i += 1;
        }
        else
        {
          if ((paramc instanceof i.b)) {}
          for (paramc = new i.b((i.b)paramc);; paramc = new i.a((i.a)paramc))
          {
            this.Ew.add(paramc);
            if (paramc.auC == null) {
              break;
            }
            parama.put(paramc.auC, paramc);
            break;
            if (!(paramc instanceof i.a)) {
              break label321;
            }
          }
          label321:
          paramc = new IllegalStateException("Unknown object in the tree!");
          AppMethodBeat.o(213046);
          throw paramc;
        }
      }
      AppMethodBeat.o(213046);
    }
    
    public final boolean e(int[] paramArrayOfInt)
    {
      AppMethodBeat.i(213085);
      int i = 0;
      boolean bool = false;
      while (i < this.Ew.size())
      {
        bool |= ((i.d)this.Ew.get(i)).e(paramArrayOfInt);
        i += 1;
      }
      AppMethodBeat.o(213085);
      return bool;
    }
    
    public final String getGroupName()
    {
      return this.auA;
    }
    
    public final Matrix getLocalMatrix()
    {
      return this.auz;
    }
    
    public final float getPivotX()
    {
      return this.auv;
    }
    
    public final float getPivotY()
    {
      return this.auw;
    }
    
    public final float getRotation()
    {
      return this.auu;
    }
    
    public final float getScaleX()
    {
      return this.aqn;
    }
    
    public final float getScaleY()
    {
      return this.aqo;
    }
    
    public final float getTranslateX()
    {
      return this.aux;
    }
    
    public final float getTranslateY()
    {
      return this.auy;
    }
    
    public final boolean isStateful()
    {
      AppMethodBeat.i(213081);
      int i = 0;
      while (i < this.Ew.size())
      {
        if (((i.d)this.Ew.get(i)).isStateful())
        {
          AppMethodBeat.o(213081);
          return true;
        }
        i += 1;
      }
      AppMethodBeat.o(213081);
      return false;
    }
    
    final void nD()
    {
      AppMethodBeat.i(213051);
      this.auz.reset();
      this.auz.postTranslate(-this.auv, -this.auw);
      this.auz.postScale(this.aqn, this.aqo);
      this.auz.postRotate(this.auu, 0.0F, 0.0F);
      this.auz.postTranslate(this.aux + this.auv, this.auy + this.auw);
      AppMethodBeat.o(213051);
    }
    
    public final void setPivotX(float paramFloat)
    {
      AppMethodBeat.i(213057);
      if (paramFloat != this.auv)
      {
        this.auv = paramFloat;
        nD();
      }
      AppMethodBeat.o(213057);
    }
    
    public final void setPivotY(float paramFloat)
    {
      AppMethodBeat.i(213060);
      if (paramFloat != this.auw)
      {
        this.auw = paramFloat;
        nD();
      }
      AppMethodBeat.o(213060);
    }
    
    public final void setRotation(float paramFloat)
    {
      AppMethodBeat.i(213054);
      if (paramFloat != this.auu)
      {
        this.auu = paramFloat;
        nD();
      }
      AppMethodBeat.o(213054);
    }
    
    public final void setScaleX(float paramFloat)
    {
      AppMethodBeat.i(213065);
      if (paramFloat != this.aqn)
      {
        this.aqn = paramFloat;
        nD();
      }
      AppMethodBeat.o(213065);
    }
    
    public final void setScaleY(float paramFloat)
    {
      AppMethodBeat.i(213069);
      if (paramFloat != this.aqo)
      {
        this.aqo = paramFloat;
        nD();
      }
      AppMethodBeat.o(213069);
    }
    
    public final void setTranslateX(float paramFloat)
    {
      AppMethodBeat.i(213072);
      if (paramFloat != this.aux)
      {
        this.aux = paramFloat;
        nD();
      }
      AppMethodBeat.o(213072);
    }
    
    public final void setTranslateY(float paramFloat)
    {
      AppMethodBeat.i(213077);
      if (paramFloat != this.auy)
      {
        this.auy = paramFloat;
        nD();
      }
      AppMethodBeat.o(213077);
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
    protected d.b[] auB = null;
    String auC;
    int mChangingConfigurations;
    
    public e()
    {
      super();
    }
    
    public e(e parame)
    {
      super();
      this.auC = parame.auC;
      this.mChangingConfigurations = parame.mChangingConfigurations;
      this.auB = d.a(parame.auB);
    }
    
    public final void c(Path paramPath)
    {
      paramPath.reset();
      if (this.auB != null) {
        d.b.a(this.auB, paramPath);
      }
    }
    
    public d.b[] getPathData()
    {
      return this.auB;
    }
    
    public String getPathName()
    {
      return this.auC;
    }
    
    public boolean nC()
    {
      return false;
    }
    
    public void setPathData(d.b[] paramArrayOfb)
    {
      if (!d.a(this.auB, paramArrayOfb)) {
        this.auB = d.a(paramArrayOfb);
      }
      for (;;)
      {
        return;
        d.b[] arrayOfb = this.auB;
        int i = 0;
        while (i < paramArrayOfb.length)
        {
          arrayOfb[i].Kq = paramArrayOfb[i].Kq;
          int j = 0;
          while (j < paramArrayOfb[i].Kr.length)
          {
            arrayOfb[i].Kr[j] = paramArrayOfb[i].Kr[j];
            j += 1;
          }
          i += 1;
        }
      }
    }
  }
  
  static final class f
  {
    private static final Matrix aqQ;
    private PathMeasure aqS;
    private final Path auD;
    private final Path auE;
    private final Matrix auF;
    Paint auG;
    Paint auH;
    final i.c auI;
    float auJ;
    float auK;
    float auL;
    float auM;
    int auN;
    String auO;
    Boolean auP;
    final androidx.b.a<String, Object> auQ;
    private int mChangingConfigurations;
    
    static
    {
      AppMethodBeat.i(213124);
      aqQ = new Matrix();
      AppMethodBeat.o(213124);
    }
    
    public f()
    {
      AppMethodBeat.i(213101);
      this.auF = new Matrix();
      this.auJ = 0.0F;
      this.auK = 0.0F;
      this.auL = 0.0F;
      this.auM = 0.0F;
      this.auN = 255;
      this.auO = null;
      this.auP = null;
      this.auQ = new androidx.b.a();
      this.auI = new i.c();
      this.auD = new Path();
      this.auE = new Path();
      AppMethodBeat.o(213101);
    }
    
    public f(f paramf)
    {
      AppMethodBeat.i(213112);
      this.auF = new Matrix();
      this.auJ = 0.0F;
      this.auK = 0.0F;
      this.auL = 0.0F;
      this.auM = 0.0F;
      this.auN = 255;
      this.auO = null;
      this.auP = null;
      this.auQ = new androidx.b.a();
      this.auI = new i.c(paramf.auI, this.auQ);
      this.auD = new Path(paramf.auD);
      this.auE = new Path(paramf.auE);
      this.auJ = paramf.auJ;
      this.auK = paramf.auK;
      this.auL = paramf.auL;
      this.auM = paramf.auM;
      this.mChangingConfigurations = paramf.mChangingConfigurations;
      this.auN = paramf.auN;
      this.auO = paramf.auO;
      if (paramf.auO != null) {
        this.auQ.put(paramf.auO, this);
      }
      this.auP = paramf.auP;
      AppMethodBeat.o(213112);
    }
    
    private void a(i.c paramc, Matrix paramMatrix, Canvas paramCanvas, int paramInt1, int paramInt2, ColorFilter paramColorFilter)
    {
      AppMethodBeat.i(213118);
      paramc.aut.set(paramMatrix);
      paramc.aut.preConcat(paramc.auz);
      paramCanvas.save();
      int i = 0;
      if (i < paramc.Ew.size())
      {
        paramMatrix = (i.d)paramc.Ew.get(i);
        if ((paramMatrix instanceof i.c)) {
          a((i.c)paramMatrix, paramc.aut, paramCanvas, paramInt1, paramInt2, paramColorFilter);
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
          float f1 = paramInt1 / this.auL;
          float f3 = paramInt2 / this.auM;
          float f2 = Math.min(f1, f3);
          Object localObject1 = paramc.aut;
          this.auF.set((Matrix)localObject1);
          this.auF.postScale(f1, f3);
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
            paramMatrix.c(this.auD);
            localObject2 = this.auD;
            this.auE.reset();
            if (paramMatrix.nC())
            {
              this.auE.addPath((Path)localObject2, this.auF);
              paramCanvas.clipPath(this.auE);
              break;
            }
            localObject1 = (i.b)paramMatrix;
            if ((((i.b)localObject1).aun != 0.0F) || (((i.b)localObject1).auo != 1.0F))
            {
              f6 = ((i.b)localObject1).aun;
              f7 = ((i.b)localObject1).aup;
              f4 = ((i.b)localObject1).auo;
              f5 = ((i.b)localObject1).aup;
              if (this.aqS == null) {
                this.aqS = new PathMeasure();
              }
              this.aqS.setPath(this.auD, false);
              f3 = this.aqS.getLength();
              f6 = (f6 + f7) % 1.0F * f3;
              f4 = (f4 + f5) % 1.0F * f3;
              ((Path)localObject2).reset();
              if (f6 > f4)
              {
                this.aqS.getSegment(f6, f3, (Path)localObject2, true);
                this.aqS.getSegment(0.0F, f4, (Path)localObject2, true);
                label502:
                ((Path)localObject2).rLineTo(0.0F, 0.0F);
              }
            }
            else
            {
              this.auE.addPath((Path)localObject2, this.auF);
              if (((i.b)localObject1).auj.gv())
              {
                paramMatrix = ((i.b)localObject1).auj;
                if (this.auH == null)
                {
                  this.auH = new Paint(1);
                  this.auH.setStyle(Paint.Style.FILL);
                }
                localObject2 = this.auH;
                if (!paramMatrix.gu()) {
                  break label854;
                }
                paramMatrix = paramMatrix.JY;
                paramMatrix.setLocalMatrix(this.auF);
                ((Paint)localObject2).setShader(paramMatrix);
                ((Paint)localObject2).setAlpha(Math.round(((i.b)localObject1).aum * 255.0F));
                label618:
                ((Paint)localObject2).setColorFilter(paramColorFilter);
                Path localPath = this.auE;
                if (((i.b)localObject1).aul != 0) {
                  break label874;
                }
                paramMatrix = Path.FillType.WINDING;
                localPath.setFillType(paramMatrix);
                paramCanvas.drawPath(this.auE, (Paint)localObject2);
              }
              if (!((i.b)localObject1).aui.gv()) {
                break;
              }
              localObject2 = ((i.b)localObject1).aui;
              if (this.auG == null)
              {
                this.auG = new Paint(1);
                this.auG.setStyle(Paint.Style.STROKE);
              }
              paramMatrix = this.auG;
              if (((i.b)localObject1).aur != null) {
                paramMatrix.setStrokeJoin(((i.b)localObject1).aur);
              }
              if (((i.b)localObject1).auq != null) {
                paramMatrix.setStrokeCap(((i.b)localObject1).auq);
              }
              paramMatrix.setStrokeMiter(((i.b)localObject1).aus);
              if (!((b)localObject2).gu()) {
                break label881;
              }
              localObject2 = ((b)localObject2).JY;
              ((Shader)localObject2).setLocalMatrix(this.auF);
              paramMatrix.setShader((Shader)localObject2);
              paramMatrix.setAlpha(Math.round(((i.b)localObject1).auk * 255.0F));
            }
            for (;;)
            {
              paramMatrix.setColorFilter(paramColorFilter);
              paramMatrix.setStrokeWidth(((i.b)localObject1).mStrokeWidth * (f2 * f1));
              paramCanvas.drawPath(this.auE, paramMatrix);
              break;
              this.aqS.getSegment(f6, f4, (Path)localObject2, true);
              break label502;
              label854:
              ((Paint)localObject2).setColor(i.e(paramMatrix.mColor, ((i.b)localObject1).aum));
              break label618;
              label874:
              paramMatrix = Path.FillType.EVEN_ODD;
              break label644;
              label881:
              paramMatrix.setColor(i.e(((b)localObject2).mColor, ((i.b)localObject1).auk));
            }
            paramCanvas.restore();
            AppMethodBeat.o(213118);
            return;
          }
        }
      }
    }
    
    public final void a(Canvas paramCanvas, int paramInt1, int paramInt2)
    {
      AppMethodBeat.i(213120);
      a(this.auI, aqQ, paramCanvas, paramInt1, paramInt2, null);
      AppMethodBeat.o(213120);
    }
    
    public final float getAlpha()
    {
      AppMethodBeat.i(213107);
      float f = getRootAlpha() / 255.0F;
      AppMethodBeat.o(213107);
      return f;
    }
    
    public final int getRootAlpha()
    {
      return this.auN;
    }
    
    public final boolean isStateful()
    {
      AppMethodBeat.i(213122);
      if (this.auP == null) {
        this.auP = Boolean.valueOf(this.auI.isStateful());
      }
      boolean bool = this.auP.booleanValue();
      AppMethodBeat.o(213122);
      return bool;
    }
    
    public final void setAlpha(float paramFloat)
    {
      AppMethodBeat.i(213106);
      setRootAlpha((int)(255.0F * paramFloat));
      AppMethodBeat.o(213106);
    }
    
    public final void setRootAlpha(int paramInt)
    {
      this.auN = paramInt;
    }
  }
  
  static final class g
    extends Drawable.ConstantState
  {
    i.f auR;
    Bitmap auS;
    ColorStateList auT;
    PorterDuff.Mode auU;
    int auV;
    boolean auW;
    boolean auX;
    Paint auY;
    boolean jB;
    PorterDuff.Mode jF;
    int mChangingConfigurations;
    ColorStateList zb;
    
    public g()
    {
      AppMethodBeat.i(213131);
      this.zb = null;
      this.jF = i.KQ;
      this.auR = new i.f();
      AppMethodBeat.o(213131);
    }
    
    public g(g paramg)
    {
      AppMethodBeat.i(213128);
      this.zb = null;
      this.jF = i.KQ;
      if (paramg != null)
      {
        this.mChangingConfigurations = paramg.mChangingConfigurations;
        this.auR = new i.f(paramg.auR);
        if (paramg.auR.auH != null) {
          this.auR.auH = new Paint(paramg.auR.auH);
        }
        if (paramg.auR.auG != null) {
          this.auR.auG = new Paint(paramg.auR.auG);
        }
        this.zb = paramg.zb;
        this.jF = paramg.jF;
        this.jB = paramg.jB;
      }
      AppMethodBeat.o(213128);
    }
    
    public final void aX(int paramInt1, int paramInt2)
    {
      AppMethodBeat.i(213129);
      this.auS.eraseColor(0);
      Canvas localCanvas = new Canvas(this.auS);
      this.auR.a(localCanvas, paramInt1, paramInt2);
      AppMethodBeat.o(213129);
    }
    
    public final int getChangingConfigurations()
    {
      return this.mChangingConfigurations;
    }
    
    public final Drawable newDrawable()
    {
      AppMethodBeat.i(213133);
      i locali = new i(this);
      AppMethodBeat.o(213133);
      return locali;
    }
    
    public final Drawable newDrawable(Resources paramResources)
    {
      AppMethodBeat.i(213136);
      paramResources = new i(this);
      AppMethodBeat.o(213136);
      return paramResources;
    }
  }
  
  static final class h
    extends Drawable.ConstantState
  {
    private final Drawable.ConstantState atX;
    
    public h(Drawable.ConstantState paramConstantState)
    {
      this.atX = paramConstantState;
    }
    
    public final boolean canApplyTheme()
    {
      AppMethodBeat.i(213179);
      boolean bool = this.atX.canApplyTheme();
      AppMethodBeat.o(213179);
      return bool;
    }
    
    public final int getChangingConfigurations()
    {
      AppMethodBeat.i(213181);
      int i = this.atX.getChangingConfigurations();
      AppMethodBeat.o(213181);
      return i;
    }
    
    public final Drawable newDrawable()
    {
      AppMethodBeat.i(213172);
      i locali = new i();
      locali.aua = ((VectorDrawable)this.atX.newDrawable());
      AppMethodBeat.o(213172);
      return locali;
    }
    
    public final Drawable newDrawable(Resources paramResources)
    {
      AppMethodBeat.i(213175);
      i locali = new i();
      locali.aua = ((VectorDrawable)this.atX.newDrawable(paramResources));
      AppMethodBeat.o(213175);
      return locali;
    }
    
    public final Drawable newDrawable(Resources paramResources, Resources.Theme paramTheme)
    {
      AppMethodBeat.i(213177);
      i locali = new i();
      locali.aua = ((VectorDrawable)this.atX.newDrawable(paramResources, paramTheme));
      AppMethodBeat.o(213177);
      return locali;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     androidx.k.a.a.i
 * JD-Core Version:    0.7.0.1
 */