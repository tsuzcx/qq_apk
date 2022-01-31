package com.tencent.magicbrush.handler.a;

import android.graphics.Bitmap;
import android.graphics.Paint.FontMetrics;
import android.graphics.Rect;
import android.graphics.Typeface;
import com.tencent.magicbrush.a.d.f;
import com.tencent.magicbrush.a.e.a;
import java.nio.FloatBuffer;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Queue;

public final class i
  implements c
{
  private b bkQ;
  private g bkZ;
  private e bla;
  private f blh;
  private j bli;
  private boolean blj = false;
  
  public i(b paramb)
  {
    this.bkQ = paramb;
  }
  
  private void clear()
  {
    d.f.i("MicroMsg.MBFontManagerImpl", "FontManager clear", new Object[0]);
    Object localObject;
    if (this.bla != null)
    {
      localObject = this.bla;
      ((e)localObject).bkN.setEmpty();
      ((e)localObject).bkM.reset();
      if (((e)localObject).bkL != null) {
        ((e)localObject).bkL.eraseColor(0);
      }
    }
    if (this.bkZ != null)
    {
      localObject = this.bkZ;
      if (((g)localObject).bkS != null)
      {
        Iterator localIterator = ((g)localObject).bkS.values().iterator();
        while (localIterator.hasNext())
        {
          k localk = (k)localIterator.next();
          ((g)localObject).bkT.bkY.offer(localk);
        }
        ((g)localObject).bkS.clear();
      }
    }
    this.blj = true;
  }
  
  public final boolean checkAndFlushClearSignal()
  {
    boolean bool = this.blj;
    this.blj = false;
    return bool;
  }
  
  public final int[] checkAndFlushDirtySignal()
  {
    e locale;
    if (this.bla != null)
    {
      locale = this.bla;
      if (locale.bkN.isEmpty()) {
        break label30;
      }
    }
    label30:
    for (int i = 1; i == 0; i = 0) {
      return null;
    }
    locale.bkO[0] = locale.bkN.left;
    locale.bkO[1] = locale.bkN.top;
    locale.bkO[2] = locale.bkN.right;
    locale.bkO[3] = locale.bkN.bottom;
    locale.bkN.setEmpty();
    return locale.bkO;
  }
  
  public final FloatBuffer drawText(String paramString)
  {
    this.bkZ.a(this.bli);
    Object localObject2 = this.bkZ.bp(paramString);
    Object localObject1 = localObject2;
    if (localObject2 == null)
    {
      d.f.i("MicroMsg.MBFontManagerImpl", "drawText() load result is null. atlas may be full. first time, clear and retry; text = [%s]; mCurrentState = [%s]", new Object[] { paramString, this.bli });
      clear();
      localObject1 = this.bkZ.bp(paramString);
    }
    localObject2 = localObject1;
    if (localObject1 == null)
    {
      d.f.i("MicroMsg.MBFontManagerImpl", "drawText() load result is null. atlas may be full. second time, just returned; text = [%s]; mCurrentState = [%s]", new Object[] { paramString, this.bli });
      localObject2 = null;
    }
    return localObject2;
  }
  
  public final void enableStroke(boolean paramBoolean)
  {
    this.bli.bll = paramBoolean;
  }
  
  public final Bitmap getBitmapAtlas()
  {
    if (this.bla != null) {
      return this.bla.bkL;
    }
    return null;
  }
  
  public final float getTextLineHeight(String paramString)
  {
    if ((paramString == null) || (paramString.length() == 0)) {}
    do
    {
      do
      {
        return 0.0F;
      } while ((this.blh == null) || (this.bkZ == null));
      this.bkZ.a(this.bli);
      paramString = this.bkZ.bkR;
    } while (paramString.blg == null);
    return paramString.blg.descent - paramString.blg.ascent + 1.0F;
  }
  
  public final void init(int paramInt1, int paramInt2)
  {
    d.f.i("MicroMsg.MBFontManagerImpl", "init() called with: m_atlasWidth = [" + paramInt1 + "], m_atlasHeight = [" + paramInt2 + "]", new Object[0]);
    this.bla = new e(paramInt1, paramInt2);
    this.blh = new f(this.bkQ);
    this.bkZ = new g(this.bla);
    this.bli = new j(j.a.bln);
  }
  
  public final String loadFont(String paramString)
  {
    f localf = this.blh;
    if ((paramString == null) || (paramString.length() == 0)) {}
    Typeface localTypeface;
    do
    {
      do
      {
        return null;
      } while (localf.bkQ == null);
      paramString = localf.bkQ.bn(paramString);
      localTypeface = localf.bkQ.bm(paramString);
    } while (localTypeface == null);
    String str = f.bo(paramString);
    paramString = str;
    if (com.tencent.magicbrush.a.bl(str))
    {
      if (a.qK() != null) {
        a.qK().eb(0);
      }
      paramString = "font" + localTypeface.hashCode();
    }
    d.f.i("MicroMsg.MBFont", "familyName:" + paramString, new Object[0]);
    localf.bkP.put(paramString, localTypeface);
    return paramString;
  }
  
  public final float measureText(String paramString)
  {
    this.bkZ.a(this.bli);
    float f2 = this.bkZ.br(paramString);
    float f1 = f2;
    if (f2 == -1.0F)
    {
      d.f.i("MicroMsg.MBFontManagerImpl", "measure() load result is null. atlas may be full. first time, clear and retry; text = [%s]; mCurrentState = [%s]", new Object[] { paramString, this.bli });
      clear();
      f1 = this.bkZ.br(paramString);
    }
    f2 = f1;
    if (f1 == -1.0F)
    {
      d.f.i("MicroMsg.MBFontManagerImpl", "measure() load result is null. atlas may be full. second time, just returned; text = [%s]; mCurrentState = [%s]", new Object[] { paramString, this.bli });
      f2 = 0.0F;
    }
    return f2;
  }
  
  public final void release()
  {
    Object localObject;
    if (this.bla != null)
    {
      localObject = this.bla;
      if (((e)localObject).bkL != null) {
        ((e)localObject).bkL.recycle();
      }
      this.bla = null;
    }
    if (this.blh != null)
    {
      localObject = this.blh;
      if (((f)localObject).bkP != null)
      {
        ((f)localObject).bkP.clear();
        ((f)localObject).bkP = null;
      }
      this.blh = null;
    }
    if (this.bkZ != null)
    {
      localObject = this.bkZ;
      if (((g)localObject).bkR != null) {
        ((g)localObject).bkR = null;
      }
      this.bkZ = null;
    }
  }
  
  public final void setStrokeWidth(float paramFloat)
  {
    this.bli.strokeWidth = paramFloat;
  }
  
  public final void useFont(String paramString, float paramFloat, boolean paramBoolean1, boolean paramBoolean2)
  {
    j.a locala2 = j.a.h(paramBoolean1, paramBoolean2);
    j localj = this.bli;
    Object localObject = this.blh;
    if (locala2 == null) {}
    for (j.a locala1 = j.a.bln;; locala1 = locala2)
    {
      if ((paramString == null) || (paramString.length() == 0)) {
        paramString = Typeface.create(null, locala1.blr);
      }
      for (;;)
      {
        localj.blk = paramString;
        this.bli.fontSize = paramFloat;
        this.bli.blm = locala2;
        return;
        localObject = (Typeface)((f)localObject).bkP.get(paramString);
        if (localObject != null)
        {
          paramString = (String)localObject;
          if (((Typeface)localObject).getStyle() != locala1.blr) {
            paramString = Typeface.create((Typeface)localObject, locala1.blr);
          }
        }
        else
        {
          paramString = Typeface.create(paramString, locala1.blr);
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.magicbrush.handler.a.i
 * JD-Core Version:    0.7.0.1
 */