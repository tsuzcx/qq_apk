package com.tencent.theme;

import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.BitmapShader;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.Shader;
import android.graphics.Shader.TileMode;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.Drawable.ConstantState;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.util.Log;
import android.view.Gravity;
import java.io.IOException;
import java.io.InputStream;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;

public class SkinnableBitmapDrawable
  extends Drawable
{
  private static final int[] i = { 16843033, 16843034, 16843035, 16843036, 16842927, 16843265 };
  private a a;
  private Bitmap b;
  private int c;
  private final Rect d = new Rect();
  private boolean e;
  private boolean f;
  private int g;
  private int h;
  
  SkinnableBitmapDrawable()
  {
    this.a = new a((Bitmap)null);
  }
  
  public SkinnableBitmapDrawable(Resources paramResources)
  {
    this.a = new a((Bitmap)null);
    this.a.m = this.c;
  }
  
  public SkinnableBitmapDrawable(Resources paramResources, Bitmap paramBitmap)
  {
    this(new a(paramBitmap), paramResources);
    this.a.m = this.c;
  }
  
  public SkinnableBitmapDrawable(Resources paramResources, InputStream paramInputStream)
  {
    this(new a(BitmapFactory.decodeStream(paramInputStream)), null);
    this.a.m = this.c;
    if (this.b == null) {
      Log.w("BitmapDrawable", "BitmapDrawable cannot decode " + paramInputStream);
    }
  }
  
  public SkinnableBitmapDrawable(Resources paramResources, String paramString)
  {
    this(new a(BitmapFactory.decodeFile(paramString)), null);
    this.a.m = this.c;
    if (this.b == null) {
      Log.w("BitmapDrawable", "BitmapDrawable cannot decode " + paramString);
    }
  }
  
  @Deprecated
  public SkinnableBitmapDrawable(Bitmap paramBitmap)
  {
    this(new a(paramBitmap), null);
  }
  
  SkinnableBitmapDrawable(a parama, Resources paramResources)
  {
    this.a = parama;
    if (paramResources != null) {
      this.c = paramResources.getDisplayMetrics().densityDpi;
    }
    for (;;)
    {
      a(parama.g);
      if (parama.n)
      {
        this.f = true;
        this.e = true;
      }
      return;
      if (parama != null) {
        this.c = parama.m;
      } else {
        this.c = 160;
      }
    }
  }
  
  @Deprecated
  public SkinnableBitmapDrawable(InputStream paramInputStream)
  {
    this(new a(BitmapFactory.decodeStream(paramInputStream)), null);
    if (this.b == null) {
      Log.w("BitmapDrawable", "BitmapDrawable cannot decode " + paramInputStream);
    }
  }
  
  @Deprecated
  public SkinnableBitmapDrawable(String paramString)
  {
    this(new a(BitmapFactory.decodeFile(paramString)), null);
    if (this.b == null) {
      Log.w("BitmapDrawable", "BitmapDrawable cannot decode " + paramString);
    }
  }
  
  static a a(Resources paramResources, XmlPullParser paramXmlPullParser, AttributeSet paramAttributeSet1, AttributeSet paramAttributeSet2, boolean paramBoolean)
    throws XmlPullParserException, IOException
  {
    int k = paramAttributeSet1.getAttributeCount();
    paramResources = new a((Bitmap)null);
    paramResources.n = true;
    Paint localPaint = new Paint();
    int j = 0;
    int m;
    Object localObject1;
    if (j < k)
    {
      switch (paramAttributeSet1.getAttributeNameResource(j))
      {
      }
      for (;;)
      {
        j += 1;
        break;
        m = paramAttributeSet1.getAttributeResourceValue(j, 0);
        if (m == 0) {
          throw new XmlPullParserException(paramXmlPullParser.getPositionDescription() + ": <bitmap> requires a valid src attribute");
        }
        localObject1 = (a)SkinEngine.getInstances().a(m);
        paramResources.g = ((a)localObject1).g;
        paramResources.f = ((a)localObject1).f;
        continue;
        localPaint.setAntiAlias(paramAttributeSet1.getAttributeBooleanValue(j, localPaint.isAntiAlias()));
        continue;
        localPaint.setFilterBitmap(paramAttributeSet1.getAttributeBooleanValue(j, localPaint.isFilterBitmap()));
        continue;
        localPaint.setDither(paramAttributeSet1.getAttributeBooleanValue(j, localPaint.isDither()));
        continue;
        paramResources.i = paramAttributeSet1.getAttributeIntValue(j, 119);
        continue;
        m = paramAttributeSet1.getAttributeIntValue(j, -1);
        if (m != -1) {
          switch (m)
          {
          default: 
            break;
          case 0: 
            paramResources.k = Shader.TileMode.CLAMP;
            paramResources.l = Shader.TileMode.CLAMP;
            break;
          case 1: 
            paramResources.k = Shader.TileMode.REPEAT;
            paramResources.l = Shader.TileMode.REPEAT;
            break;
          case 2: 
            paramResources.k = Shader.TileMode.MIRROR;
            paramResources.l = Shader.TileMode.MIRROR;
          }
        }
      }
    }
    if (paramAttributeSet2 != null) {
      if (paramBoolean)
      {
        k = paramAttributeSet2.getAttributeCount();
        j = 0;
        if (j < k)
        {
          switch (paramAttributeSet2.getAttributeNameResource(j))
          {
          }
          for (;;)
          {
            j += 1;
            break;
            localPaint.setAntiAlias(paramAttributeSet2.getAttributeBooleanValue(j, localPaint.isAntiAlias()));
            continue;
            localPaint.setFilterBitmap(paramAttributeSet2.getAttributeBooleanValue(j, localPaint.isFilterBitmap()));
            continue;
            localPaint.setDither(paramAttributeSet2.getAttributeBooleanValue(j, localPaint.isDither()));
            continue;
            paramResources.i = paramAttributeSet2.getAttributeIntValue(j, 119);
            continue;
            m = paramAttributeSet2.getAttributeIntValue(j, -2);
            if (m != -2) {
              switch (m)
              {
              default: 
                break;
              case -1: 
                paramResources.k = null;
                paramResources.l = null;
                break;
              case 0: 
                paramResources.k = Shader.TileMode.CLAMP;
                paramResources.l = Shader.TileMode.CLAMP;
                break;
              case 1: 
                paramResources.k = Shader.TileMode.REPEAT;
                paramResources.l = Shader.TileMode.REPEAT;
                break;
              case 2: 
                paramResources.k = Shader.TileMode.MIRROR;
                paramResources.l = Shader.TileMode.MIRROR;
              }
            }
          }
        }
      }
      else
      {
        int n = paramAttributeSet2.getAttributeCount();
        k = 0;
        if (k < n)
        {
          paramAttributeSet1 = paramAttributeSet2.getAttributeName(k);
          if ("antialias".equals(paramAttributeSet1)) {
            localPaint.setAntiAlias(paramAttributeSet2.getAttributeBooleanValue(k, localPaint.isAntiAlias()));
          }
          for (;;)
          {
            k += 1;
            break;
            if ("filter".equals(paramAttributeSet1))
            {
              localPaint.setAntiAlias(paramAttributeSet2.getAttributeBooleanValue(k, localPaint.isAntiAlias()));
            }
            else if ("dither".equals(paramAttributeSet1))
            {
              localPaint.setAntiAlias(paramAttributeSet2.getAttributeBooleanValue(k, localPaint.isAntiAlias()));
            }
            else if ("gravity".equals(paramAttributeSet1))
            {
              paramAttributeSet1 = paramAttributeSet2.getAttributeValue(k);
              localObject1 = paramAttributeSet1.split("\\|");
              int i1 = localObject1.length;
              j = 0;
              m = 0;
              if (m < i1)
              {
                Object localObject2 = localObject1[m];
                if ("top".equals(localObject2)) {
                  j |= 0x30;
                }
                for (;;)
                {
                  m += 1;
                  break;
                  if ("bottom".equals(localObject2))
                  {
                    j |= 0x50;
                  }
                  else if ("left".equals(localObject2))
                  {
                    j |= 0x3;
                  }
                  else if ("right".equals(localObject2))
                  {
                    j |= 0x5;
                  }
                  else if ("center_vertical".equals(localObject2))
                  {
                    j |= 0x10;
                  }
                  else if ("fill_vertical".equals(localObject2))
                  {
                    j |= 0x70;
                  }
                  else if ("center_horizontal".equals(localObject2))
                  {
                    j |= 0x1;
                  }
                  else if ("fill_horizontal".equals(localObject2))
                  {
                    j |= 0x7;
                  }
                  else if ("center".equals(localObject2))
                  {
                    j |= 0x11;
                  }
                  else if ("fill".equals(localObject2))
                  {
                    j |= 0x77;
                  }
                  else if ("clip_vertical".equals(localObject2))
                  {
                    j |= 0x80;
                  }
                  else if ("clip_horizontal".equals(localObject2))
                  {
                    j |= 0x8;
                  }
                  else if ("start".equals(localObject2))
                  {
                    j |= 0x800003;
                  }
                  else
                  {
                    if (!"end".equals(localObject2)) {
                      break label1148;
                    }
                    j |= 0x800005;
                  }
                }
                label1148:
                throw new XmlPullParserException("error attribute value: " + paramAttributeSet1);
              }
              paramResources.i = j;
            }
            else if ("tileMode".equals(paramAttributeSet1))
            {
              paramAttributeSet1 = paramAttributeSet2.getAttributeValue(k);
              if ("clamp".equals(paramAttributeSet1))
              {
                paramResources.k = Shader.TileMode.CLAMP;
                paramResources.l = Shader.TileMode.CLAMP;
              }
              else if ("repeat".equals(paramAttributeSet1))
              {
                paramResources.k = Shader.TileMode.REPEAT;
                paramResources.l = Shader.TileMode.REPEAT;
              }
              else if ("mirror".equals(paramAttributeSet1))
              {
                paramResources.k = Shader.TileMode.MIRROR;
                paramResources.l = Shader.TileMode.MIRROR;
              }
              else
              {
                if (!"disabled".equals(paramAttributeSet1)) {
                  break label1308;
                }
                paramResources.k = null;
                paramResources.l = null;
              }
            }
          }
          label1308:
          throw new XmlPullParserException("error attribute value: " + paramAttributeSet1);
        }
      }
    }
    if ((paramResources.g == null) && (paramResources.f == null)) {
      throw new XmlPullParserException(paramXmlPullParser.getPositionDescription() + ": <bitmap> requires a valid src attribute");
    }
    return paramResources;
  }
  
  private void a()
  {
    b();
    if (this.a.f != null)
    {
      int[] arrayOfInt = this.a.f;
      this.g = b.a(arrayOfInt[0], arrayOfInt[2], this.c);
      this.g = b.a(arrayOfInt[1], arrayOfInt[2], this.c);
      return;
    }
    this.g = this.b.getScaledWidth(this.c);
    this.h = this.b.getScaledHeight(this.c);
  }
  
  private void a(Bitmap paramBitmap)
  {
    this.b = paramBitmap;
    if (paramBitmap != null)
    {
      a();
      return;
    }
    this.h = -1;
    this.g = -1;
  }
  
  private void b()
  {
    if (this.b != this.a.g)
    {
      this.b = this.a.g;
      if (this.a.n)
      {
        this.f = true;
        this.e = true;
      }
      if (this.a.f != null)
      {
        int[] arrayOfInt = this.a.f;
        this.g = b.a(arrayOfInt[0], arrayOfInt[2], this.c);
        this.g = b.a(arrayOfInt[1], arrayOfInt[2], this.c);
      }
    }
    else
    {
      return;
    }
    this.g = this.b.getScaledWidth(this.c);
    this.h = this.b.getScaledHeight(this.c);
  }
  
  public void draw(Canvas paramCanvas)
  {
    b();
    if (this.a.f != null) {}
    Bitmap localBitmap;
    do
    {
      return;
      localBitmap = this.b;
    } while (localBitmap == null);
    Object localObject1;
    if (this.a.c == 1)
    {
      setGravity(48);
      localObject1 = getImageDrawnRect(getBounds());
      paramCanvas.drawBitmap(this.b, (Rect)localObject1, getBounds(), this.a.j);
      return;
    }
    a locala = this.a;
    Object localObject2;
    Shader.TileMode localTileMode;
    if (this.f)
    {
      localObject2 = locala.k;
      localTileMode = locala.l;
      if ((localObject2 != null) || (localTileMode != null)) {
        break label195;
      }
      locala.j.setShader(null);
    }
    for (;;)
    {
      this.f = false;
      copyBounds(this.d);
      if (locala.j.getShader() != null) {
        break;
      }
      if (this.e)
      {
        Gravity.apply(locala.i, this.g, this.h, getBounds(), this.d);
        this.e = false;
      }
      paramCanvas.drawBitmap(localBitmap, null, this.d, locala.j);
      return;
      label195:
      localObject1 = localObject2;
      if (localObject2 == null) {
        localObject1 = Shader.TileMode.CLAMP;
      }
      localObject2 = localTileMode;
      if (localTileMode == null) {
        localObject2 = Shader.TileMode.CLAMP;
      }
      localObject1 = new BitmapShader(localBitmap, (Shader.TileMode)localObject1, (Shader.TileMode)localObject2);
      locala.j.setShader((Shader)localObject1);
    }
    if (this.e)
    {
      this.d.set(getBounds());
      this.e = false;
    }
    paramCanvas.drawRect(this.d, locala.j);
  }
  
  public final Bitmap getBitmap()
  {
    b();
    return this.b;
  }
  
  public int getChangingConfigurations()
  {
    return super.getChangingConfigurations() | this.a.h;
  }
  
  public final Drawable.ConstantState getConstantState()
  {
    return this.a;
  }
  
  public int getGravity()
  {
    return this.a.i;
  }
  
  protected Rect getImageDrawnRect(Rect paramRect)
  {
    int j = getBitmap().getHeight();
    int m = getBitmap().getWidth();
    if (paramRect == null) {
      return new Rect(0, 0, m, j);
    }
    if (paramRect.height() / paramRect.width() >= j / m)
    {
      int k = paramRect.width() * j / paramRect.height();
      m = (int)((m - k) * 0.5D);
      return new Rect(m, 0, k + m, j);
    }
    return new Rect(0, 0, m, paramRect.height() * m / paramRect.width());
  }
  
  public int getIntrinsicHeight()
  {
    b();
    return this.h;
  }
  
  public int getIntrinsicWidth()
  {
    b();
    return this.g;
  }
  
  public int getOpacity()
  {
    if (this.a.i != 119) {}
    Bitmap localBitmap;
    do
    {
      return -3;
      b();
      localBitmap = this.b;
    } while ((localBitmap == null) || (localBitmap.hasAlpha()) || (this.a.j.getAlpha() < 255));
    return -1;
  }
  
  public final Paint getPaint()
  {
    return this.a.j;
  }
  
  public Shader.TileMode getTileModeX()
  {
    return this.a.k;
  }
  
  public Shader.TileMode getTileModeY()
  {
    return this.a.l;
  }
  
  public Drawable mutate()
  {
    return this;
  }
  
  protected void onBoundsChange(Rect paramRect)
  {
    super.onBoundsChange(paramRect);
    this.e = true;
  }
  
  public void setAlpha(int paramInt)
  {
    this.a.j.setAlpha(paramInt);
  }
  
  public void setAntiAlias(boolean paramBoolean)
  {
    this.a.j.setAntiAlias(paramBoolean);
  }
  
  public void setColorFilter(ColorFilter paramColorFilter)
  {
    this.a.j.setColorFilter(paramColorFilter);
  }
  
  public void setDither(boolean paramBoolean)
  {
    this.a.j.setDither(paramBoolean);
  }
  
  public void setFilterBitmap(boolean paramBoolean)
  {
    this.a.j.setFilterBitmap(paramBoolean);
  }
  
  public void setGravity(int paramInt)
  {
    this.a.i = paramInt;
    this.e = true;
  }
  
  public void setTargetDensity(int paramInt)
  {
    int j = paramInt;
    if (paramInt == 0) {
      j = 160;
    }
    this.c = j;
    b();
    if (this.b != null) {
      a();
    }
  }
  
  public void setTargetDensity(Canvas paramCanvas)
  {
    setTargetDensity(paramCanvas.getDensity());
  }
  
  public void setTargetDensity(DisplayMetrics paramDisplayMetrics)
  {
    this.c = paramDisplayMetrics.densityDpi;
    b();
    if (this.b != null) {
      a();
    }
  }
  
  public void setTileModeX(Shader.TileMode paramTileMode)
  {
    setTileModeXY(paramTileMode, this.a.l);
  }
  
  public void setTileModeXY(Shader.TileMode paramTileMode1, Shader.TileMode paramTileMode2)
  {
    a locala = this.a;
    if ((locala.j.getShader() == null) || (locala.k != paramTileMode1) || (locala.l != paramTileMode2))
    {
      locala.k = paramTileMode1;
      locala.l = paramTileMode2;
      this.f = true;
    }
  }
  
  public final void setTileModeY(Shader.TileMode paramTileMode)
  {
    setTileModeXY(this.a.k, paramTileMode);
  }
  
  static final class a
    extends b
  {
    Bitmap g;
    int h;
    int i = 119;
    Paint j = new Paint(6);
    Shader.TileMode k;
    Shader.TileMode l;
    int m = 160;
    boolean n = false;
    
    a(Bitmap paramBitmap)
    {
      this.g = paramBitmap;
    }
    
    public int getChangingConfigurations()
    {
      return this.h;
    }
    
    public Drawable newDrawable()
    {
      return new SkinnableBitmapDrawable(this, null);
    }
    
    public Drawable newDrawable(Resources paramResources)
    {
      return new SkinnableBitmapDrawable(this, paramResources);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\classes.jar
 * Qualified Name:     com.tencent.theme.SkinnableBitmapDrawable
 * JD-Core Version:    0.7.0.1
 */