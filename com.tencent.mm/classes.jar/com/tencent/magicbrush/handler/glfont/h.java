package com.tencent.magicbrush.handler.glfont;

import android.graphics.Bitmap;
import android.graphics.Paint.FontMetrics;
import android.graphics.Rect;
import android.graphics.Typeface;
import com.tencent.magicbrush.a.c.c;
import com.tencent.magicbrush.a.d.a;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.nio.FloatBuffer;
import java.util.HashMap;

public final class h
  implements IMBFontHandler
{
  private f cqH;
  private d cqI;
  public e cqP;
  private i cqQ;
  private boolean cqR = false;
  public b cqy;
  
  private void clear()
  {
    AppMethodBeat.i(140046);
    c.c.i("MicroMsg.MBFontManagerImpl", "FontManager clear", new Object[0]);
    if (this.cqI != null) {
      this.cqI.clear();
    }
    if (this.cqH != null) {
      this.cqH.clear();
    }
    this.cqR = true;
    AppMethodBeat.o(140046);
  }
  
  public final boolean checkAndFlushClearSignal()
  {
    boolean bool = this.cqR;
    this.cqR = false;
    return bool;
  }
  
  public final int[] checkAndFlushDirtySignal()
  {
    AppMethodBeat.i(140045);
    if (this.cqI != null)
    {
      Object localObject = this.cqI;
      if (!((d)localObject).cqv.isEmpty()) {}
      for (int i = 1; i == 0; i = 0)
      {
        AppMethodBeat.o(140045);
        return null;
      }
      ((d)localObject).cqw[0] = ((d)localObject).cqv.left;
      ((d)localObject).cqw[1] = ((d)localObject).cqv.top;
      ((d)localObject).cqw[2] = ((d)localObject).cqv.right;
      ((d)localObject).cqw[3] = ((d)localObject).cqv.bottom;
      ((d)localObject).cqv.setEmpty();
      localObject = ((d)localObject).cqw;
      AppMethodBeat.o(140045);
      return localObject;
    }
    AppMethodBeat.o(140045);
    return null;
  }
  
  public final FloatBuffer drawText(String paramString)
  {
    AppMethodBeat.i(140044);
    this.cqH.a(this.cqQ);
    FloatBuffer localFloatBuffer2 = this.cqH.cL(paramString);
    FloatBuffer localFloatBuffer1 = localFloatBuffer2;
    if (localFloatBuffer2 == null)
    {
      c.c.i("MicroMsg.MBFontManagerImpl", "drawText() load result is null. atlas may be full. first time, clear and retry; text = [%s]; mCurrentState = [%s]", new Object[] { paramString, this.cqQ });
      clear();
      localFloatBuffer1 = this.cqH.cL(paramString);
    }
    if (localFloatBuffer1 == null)
    {
      c.c.i("MicroMsg.MBFontManagerImpl", "drawText() load result is null. atlas may be full. second time, just returned; text = [%s]; mCurrentState = [%s]", new Object[] { paramString, this.cqQ });
      AppMethodBeat.o(140044);
      return null;
    }
    AppMethodBeat.o(140044);
    return localFloatBuffer1;
  }
  
  public final void enableStroke(boolean paramBoolean)
  {
    this.cqQ.cqS = paramBoolean;
  }
  
  public final Bitmap getBitmapAtlas()
  {
    if (this.cqI != null) {
      return this.cqI.cqt;
    }
    return null;
  }
  
  public final float getTextLineHeight(String paramString)
  {
    AppMethodBeat.i(140049);
    if ((paramString == null) || (paramString.length() == 0))
    {
      AppMethodBeat.o(140049);
      return 0.0F;
    }
    if ((this.cqP == null) || (this.cqH == null))
    {
      AppMethodBeat.o(140049);
      return 0.0F;
    }
    this.cqH.a(this.cqQ);
    paramString = this.cqH.cqz;
    if (paramString.cqO == null)
    {
      AppMethodBeat.o(140049);
      return 0.0F;
    }
    float f1 = paramString.cqO.descent;
    float f2 = paramString.cqO.ascent;
    AppMethodBeat.o(140049);
    return f1 - f2 + 1.0F;
  }
  
  public final void init(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(140041);
    c.c.i("MicroMsg.MBFontManagerImpl", "init() called with: m_atlasWidth = [" + paramInt1 + "], m_atlasHeight = [" + paramInt2 + "]", new Object[0]);
    this.cqI = new d(paramInt1, paramInt2);
    this.cqP = new e(this.cqy);
    this.cqH = new f(this.cqI);
    this.cqQ = new i(i.a.cqU);
    AppMethodBeat.o(140041);
  }
  
  public final String loadFont(String paramString)
  {
    AppMethodBeat.i(140042);
    e locale = this.cqP;
    if ((paramString == null) || (paramString.length() == 0))
    {
      AppMethodBeat.o(140042);
      return null;
    }
    if (locale.cqy == null)
    {
      c.c.i("MicroMsg.MBFont", "[MBFontHandler] FaceProvider is null", new Object[0]);
      AppMethodBeat.o(140042);
      return null;
    }
    paramString = locale.cqy.cb(paramString);
    Typeface localTypeface = locale.cqy.ca(paramString);
    if (localTypeface == null)
    {
      AppMethodBeat.o(140042);
      return null;
    }
    String str = e.cK(paramString);
    paramString = str;
    if (com.tencent.magicbrush.utils.h.isNullOrNil(str))
    {
      if (a.Gt() != null) {
        a.Gt().he(0);
      }
      paramString = "font" + localTypeface.hashCode();
    }
    c.c.i("MicroMsg.MBFont", "familyName:".concat(String.valueOf(paramString)), new Object[0]);
    locale.cqx.put(paramString, localTypeface);
    AppMethodBeat.o(140042);
    return paramString;
  }
  
  public final float measureText(String paramString)
  {
    AppMethodBeat.i(140047);
    this.cqH.a(this.cqQ);
    float f2 = this.cqH.cN(paramString);
    float f1 = f2;
    if (f2 == -1.0F)
    {
      c.c.i("MicroMsg.MBFontManagerImpl", "measure() load result is null. atlas may be full. first time, clear and retry; text = [%s]; mCurrentState = [%s]", new Object[] { paramString, this.cqQ });
      clear();
      f1 = this.cqH.cN(paramString);
    }
    if (f1 == -1.0F)
    {
      c.c.i("MicroMsg.MBFontManagerImpl", "measure() load result is null. atlas may be full. second time, just returned; text = [%s]; mCurrentState = [%s]", new Object[] { paramString, this.cqQ });
      AppMethodBeat.o(140047);
      return 0.0F;
    }
    AppMethodBeat.o(140047);
    return f1;
  }
  
  public final void release()
  {
    AppMethodBeat.i(140048);
    Object localObject;
    if (this.cqI != null)
    {
      localObject = this.cqI;
      if (((d)localObject).cqt != null) {
        ((d)localObject).cqt.recycle();
      }
      this.cqI = null;
    }
    if (this.cqP != null)
    {
      localObject = this.cqP;
      if (((e)localObject).cqx != null)
      {
        ((e)localObject).cqx.clear();
        ((e)localObject).cqx = null;
      }
      this.cqP = null;
    }
    if (this.cqH != null)
    {
      localObject = this.cqH;
      if (((f)localObject).cqz != null) {
        ((f)localObject).cqz = null;
      }
      this.cqH = null;
    }
    AppMethodBeat.o(140048);
  }
  
  public final void setStrokeWidth(float paramFloat)
  {
    this.cqQ.strokeWidth = paramFloat;
  }
  
  public final void useFont(String paramString, float paramFloat, boolean paramBoolean1, boolean paramBoolean2)
  {
    AppMethodBeat.i(140043);
    i.a locala2 = i.a.j(paramBoolean1, paramBoolean2);
    i locali = this.cqQ;
    Object localObject = this.cqP;
    if (locala2 == null) {}
    for (i.a locala1 = i.a.cqU;; locala1 = locala2)
    {
      if ((paramString == null) || (paramString.length() == 0)) {
        paramString = Typeface.create(null, locala1.cqY);
      }
      for (;;)
      {
        locali.pC = paramString;
        this.cqQ.buK = paramFloat;
        this.cqQ.cqT = locala2;
        AppMethodBeat.o(140043);
        return;
        localObject = (Typeface)((e)localObject).cqx.get(paramString);
        if (localObject != null)
        {
          paramString = (String)localObject;
          if (((Typeface)localObject).getStyle() != locala1.cqY) {
            paramString = Typeface.create((Typeface)localObject, locala1.cqY);
          }
        }
        else
        {
          paramString = Typeface.create(paramString, locala1.cqY);
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.magicbrush.handler.glfont.h
 * JD-Core Version:    0.7.0.1
 */