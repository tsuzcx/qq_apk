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
  public b cnF;
  private f cnO;
  private d cnP;
  public e cnW;
  private i cnX;
  private boolean cnY = false;
  
  private void clear()
  {
    AppMethodBeat.i(140046);
    c.c.i("MicroMsg.MBFontManagerImpl", "FontManager clear", new Object[0]);
    if (this.cnP != null) {
      this.cnP.clear();
    }
    if (this.cnO != null) {
      this.cnO.clear();
    }
    this.cnY = true;
    AppMethodBeat.o(140046);
  }
  
  public final boolean checkAndFlushClearSignal()
  {
    boolean bool = this.cnY;
    this.cnY = false;
    return bool;
  }
  
  public final int[] checkAndFlushDirtySignal()
  {
    AppMethodBeat.i(140045);
    if (this.cnP != null)
    {
      Object localObject = this.cnP;
      if (!((d)localObject).cnC.isEmpty()) {}
      for (int i = 1; i == 0; i = 0)
      {
        AppMethodBeat.o(140045);
        return null;
      }
      ((d)localObject).cnD[0] = ((d)localObject).cnC.left;
      ((d)localObject).cnD[1] = ((d)localObject).cnC.top;
      ((d)localObject).cnD[2] = ((d)localObject).cnC.right;
      ((d)localObject).cnD[3] = ((d)localObject).cnC.bottom;
      ((d)localObject).cnC.setEmpty();
      localObject = ((d)localObject).cnD;
      AppMethodBeat.o(140045);
      return localObject;
    }
    AppMethodBeat.o(140045);
    return null;
  }
  
  public final FloatBuffer drawText(String paramString)
  {
    AppMethodBeat.i(140044);
    this.cnO.a(this.cnX);
    FloatBuffer localFloatBuffer2 = this.cnO.cA(paramString);
    FloatBuffer localFloatBuffer1 = localFloatBuffer2;
    if (localFloatBuffer2 == null)
    {
      c.c.i("MicroMsg.MBFontManagerImpl", "drawText() load result is null. atlas may be full. first time, clear and retry; text = [%s]; mCurrentState = [%s]", new Object[] { paramString, this.cnX });
      clear();
      localFloatBuffer1 = this.cnO.cA(paramString);
    }
    if (localFloatBuffer1 == null)
    {
      c.c.i("MicroMsg.MBFontManagerImpl", "drawText() load result is null. atlas may be full. second time, just returned; text = [%s]; mCurrentState = [%s]", new Object[] { paramString, this.cnX });
      AppMethodBeat.o(140044);
      return null;
    }
    AppMethodBeat.o(140044);
    return localFloatBuffer1;
  }
  
  public final void enableStroke(boolean paramBoolean)
  {
    this.cnX.cnZ = paramBoolean;
  }
  
  public final Bitmap getBitmapAtlas()
  {
    if (this.cnP != null) {
      return this.cnP.cnA;
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
    if ((this.cnW == null) || (this.cnO == null))
    {
      AppMethodBeat.o(140049);
      return 0.0F;
    }
    this.cnO.a(this.cnX);
    paramString = this.cnO.cnG;
    if (paramString.cnV == null)
    {
      AppMethodBeat.o(140049);
      return 0.0F;
    }
    float f1 = paramString.cnV.descent;
    float f2 = paramString.cnV.ascent;
    AppMethodBeat.o(140049);
    return f1 - f2 + 1.0F;
  }
  
  public final void init(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(140041);
    c.c.i("MicroMsg.MBFontManagerImpl", "init() called with: m_atlasWidth = [" + paramInt1 + "], m_atlasHeight = [" + paramInt2 + "]", new Object[0]);
    this.cnP = new d(paramInt1, paramInt2);
    this.cnW = new e(this.cnF);
    this.cnO = new f(this.cnP);
    this.cnX = new i(i.a.cob);
    AppMethodBeat.o(140041);
  }
  
  public final String loadFont(String paramString)
  {
    AppMethodBeat.i(140042);
    e locale = this.cnW;
    if ((paramString == null) || (paramString.length() == 0))
    {
      AppMethodBeat.o(140042);
      return null;
    }
    if (locale.cnF == null)
    {
      c.c.i("MicroMsg.MBFont", "[MBFontHandler] FaceProvider is null", new Object[0]);
      AppMethodBeat.o(140042);
      return null;
    }
    paramString = locale.cnF.bR(paramString);
    Typeface localTypeface = locale.cnF.bQ(paramString);
    if (localTypeface == null)
    {
      AppMethodBeat.o(140042);
      return null;
    }
    String str = e.cz(paramString);
    paramString = str;
    if (com.tencent.magicbrush.utils.h.isNullOrNil(str))
    {
      if (a.Gf() != null) {
        a.Gf().gN(0);
      }
      paramString = "font" + localTypeface.hashCode();
    }
    c.c.i("MicroMsg.MBFont", "familyName:".concat(String.valueOf(paramString)), new Object[0]);
    locale.cnE.put(paramString, localTypeface);
    AppMethodBeat.o(140042);
    return paramString;
  }
  
  public final float measureText(String paramString)
  {
    AppMethodBeat.i(140047);
    this.cnO.a(this.cnX);
    float f2 = this.cnO.cC(paramString);
    float f1 = f2;
    if (f2 == -1.0F)
    {
      c.c.i("MicroMsg.MBFontManagerImpl", "measure() load result is null. atlas may be full. first time, clear and retry; text = [%s]; mCurrentState = [%s]", new Object[] { paramString, this.cnX });
      clear();
      f1 = this.cnO.cC(paramString);
    }
    if (f1 == -1.0F)
    {
      c.c.i("MicroMsg.MBFontManagerImpl", "measure() load result is null. atlas may be full. second time, just returned; text = [%s]; mCurrentState = [%s]", new Object[] { paramString, this.cnX });
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
    if (this.cnP != null)
    {
      localObject = this.cnP;
      if (((d)localObject).cnA != null) {
        ((d)localObject).cnA.recycle();
      }
      this.cnP = null;
    }
    if (this.cnW != null)
    {
      localObject = this.cnW;
      if (((e)localObject).cnE != null)
      {
        ((e)localObject).cnE.clear();
        ((e)localObject).cnE = null;
      }
      this.cnW = null;
    }
    if (this.cnO != null)
    {
      localObject = this.cnO;
      if (((f)localObject).cnG != null) {
        ((f)localObject).cnG = null;
      }
      this.cnO = null;
    }
    AppMethodBeat.o(140048);
  }
  
  public final void setStrokeWidth(float paramFloat)
  {
    this.cnX.strokeWidth = paramFloat;
  }
  
  public final void useFont(String paramString, float paramFloat, boolean paramBoolean1, boolean paramBoolean2)
  {
    AppMethodBeat.i(140043);
    i.a locala2 = i.a.j(paramBoolean1, paramBoolean2);
    i locali = this.cnX;
    Object localObject = this.cnW;
    if (locala2 == null) {}
    for (i.a locala1 = i.a.cob;; locala1 = locala2)
    {
      if ((paramString == null) || (paramString.length() == 0)) {
        paramString = Typeface.create(null, locala1.cof);
      }
      for (;;)
      {
        locali.qC = paramString;
        this.cnX.bsJ = paramFloat;
        this.cnX.coa = locala2;
        AppMethodBeat.o(140043);
        return;
        localObject = (Typeface)((e)localObject).cnE.get(paramString);
        if (localObject != null)
        {
          paramString = (String)localObject;
          if (((Typeface)localObject).getStyle() != locala1.cof) {
            paramString = Typeface.create((Typeface)localObject, locala1.cof);
          }
        }
        else
        {
          paramString = Typeface.create(paramString, locala1.cof);
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.magicbrush.handler.glfont.h
 * JD-Core Version:    0.7.0.1
 */