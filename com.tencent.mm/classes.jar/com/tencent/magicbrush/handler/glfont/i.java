package com.tencent.magicbrush.handler.glfont;

import android.graphics.Bitmap;
import android.graphics.Paint.FontMetrics;
import android.graphics.Rect;
import android.graphics.Typeface;
import android.os.Build.VERSION;
import com.tencent.magicbrush.a.c.c;
import com.tencent.magicbrush.a.d.a;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.nio.FloatBuffer;
import java.util.HashMap;

public final class i
  implements IMBFontHandler
{
  public b cNN;
  private g cNX;
  private e cNY;
  public f cOg;
  private j cOh;
  private c cOi;
  private boolean cOj = false;
  
  private void clear()
  {
    AppMethodBeat.i(140046);
    c.c.i("MicroMsg.MBFontManagerImpl", "FontManager clear", new Object[0]);
    if (this.cNY != null) {
      this.cNY.clear();
    }
    if (this.cNX != null) {
      this.cNX.clear();
    }
    this.cOj = true;
    AppMethodBeat.o(140046);
  }
  
  public final void a(c paramc)
  {
    this.cOi = paramc;
    if (this.cNX != null)
    {
      paramc = this.cNX;
      c localc = this.cOi;
      paramc.cNP.cOc = localc;
    }
  }
  
  public final boolean checkAndFlushClearSignal()
  {
    boolean bool = this.cOj;
    this.cOj = false;
    return bool;
  }
  
  public final int[] checkAndFlushDirtySignal()
  {
    AppMethodBeat.i(140045);
    if (this.cNY != null)
    {
      Object localObject = this.cNY;
      if (!((e)localObject).cNJ.isEmpty()) {}
      for (int i = 1; i == 0; i = 0)
      {
        AppMethodBeat.o(140045);
        return null;
      }
      ((e)localObject).cNK[0] = ((e)localObject).cNJ.left;
      ((e)localObject).cNK[1] = ((e)localObject).cNJ.top;
      ((e)localObject).cNK[2] = ((e)localObject).cNJ.right;
      ((e)localObject).cNK[3] = ((e)localObject).cNJ.bottom;
      ((e)localObject).cNJ.setEmpty();
      localObject = ((e)localObject).cNK;
      AppMethodBeat.o(140045);
      return localObject;
    }
    AppMethodBeat.o(140045);
    return null;
  }
  
  public final FloatBuffer drawText(String paramString)
  {
    AppMethodBeat.i(140044);
    this.cNX.a(this.cOh);
    FloatBuffer localFloatBuffer2 = this.cNX.eC(paramString);
    FloatBuffer localFloatBuffer1 = localFloatBuffer2;
    if (localFloatBuffer2 == null)
    {
      c.c.i("MicroMsg.MBFontManagerImpl", "drawText() load result is null. atlas may be full. first time, clear and retry; text = [%s]; mCurrentState = [%s]", new Object[] { paramString, this.cOh });
      clear();
      localFloatBuffer1 = this.cNX.eC(paramString);
    }
    if (localFloatBuffer1 == null)
    {
      c.c.i("MicroMsg.MBFontManagerImpl", "drawText() load result is null. atlas may be full. second time, just returned; text = [%s]; mCurrentState = [%s]", new Object[] { paramString, this.cOh });
      AppMethodBeat.o(140044);
      return null;
    }
    AppMethodBeat.o(140044);
    return localFloatBuffer1;
  }
  
  public final void enableStroke(boolean paramBoolean)
  {
    this.cOh.cOl = paramBoolean;
  }
  
  public final Bitmap getBitmapAtlas()
  {
    if (this.cNY != null) {
      return this.cNY.cNH;
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
    if ((this.cOg == null) || (this.cNX == null))
    {
      AppMethodBeat.o(140049);
      return 0.0F;
    }
    this.cNX.a(this.cOh);
    paramString = this.cNX.cNP;
    if (paramString.cOf == null)
    {
      AppMethodBeat.o(140049);
      return 0.0F;
    }
    float f1 = paramString.cOf.bottom;
    float f2 = paramString.cOf.ascent;
    AppMethodBeat.o(140049);
    return f1 - f2 + 1.0F;
  }
  
  public final void init(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(140041);
    c.c.i("MicroMsg.MBFontManagerImpl", "init() called with: m_atlasWidth = [" + paramInt1 + "], m_atlasHeight = [" + paramInt2 + "]", new Object[0]);
    this.cNY = new e(paramInt1, paramInt2);
    this.cOg = new f(this.cNN);
    this.cNX = new g(this.cNY, this.cOi);
    this.cOh = new j("normal", j.a.cOn);
    AppMethodBeat.o(140041);
  }
  
  public final String loadFont(String paramString)
  {
    AppMethodBeat.i(140042);
    f localf = this.cOg;
    if ((paramString == null) || (paramString.length() == 0))
    {
      AppMethodBeat.o(140042);
      return null;
    }
    if (localf.cNN == null)
    {
      c.c.i("MicroMsg.MBFont", "[MBFontHandler] FaceProvider is null", new Object[0]);
      AppMethodBeat.o(140042);
      return null;
    }
    paramString = localf.cNN.dC(paramString);
    Typeface localTypeface = localf.cNN.dB(paramString);
    if (localTypeface == null)
    {
      AppMethodBeat.o(140042);
      return null;
    }
    String str = f.eB(paramString);
    paramString = str;
    if (com.tencent.magicbrush.utils.i.isNullOrNil(str))
    {
      if (a.Vh() != null) {
        a.Vh().jn(0);
      }
      paramString = "font" + localTypeface.hashCode();
    }
    c.c.i("MicroMsg.MBFont", "familyName:".concat(String.valueOf(paramString)), new Object[0]);
    localf.cNL.put(paramString, localTypeface);
    AppMethodBeat.o(140042);
    return paramString;
  }
  
  public final float measureText(String paramString)
  {
    AppMethodBeat.i(140047);
    this.cNX.a(this.cOh);
    float f2 = this.cNX.eE(paramString);
    float f1 = f2;
    if (f2 == -1.0F)
    {
      c.c.i("MicroMsg.MBFontManagerImpl", "measure() load result is null. atlas may be full. first time, clear and retry; text = [%s]; mCurrentState = [%s]", new Object[] { paramString, this.cOh });
      clear();
      f1 = this.cNX.eE(paramString);
    }
    if (f1 == -1.0F)
    {
      c.c.i("MicroMsg.MBFontManagerImpl", "measure() load result is null. atlas may be full. second time, just returned; text = [%s]; mCurrentState = [%s]", new Object[] { paramString, this.cOh });
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
    if (this.cNY != null)
    {
      localObject = this.cNY;
      if (((e)localObject).cNH != null) {
        ((e)localObject).cNH.recycle();
      }
      this.cNY = null;
    }
    if (this.cOg != null)
    {
      localObject = this.cOg;
      if (((f)localObject).cNL != null)
      {
        ((f)localObject).cNL.clear();
        ((f)localObject).cNL = null;
      }
      this.cOg = null;
    }
    if (this.cNX != null)
    {
      localObject = this.cNX;
      if (((g)localObject).cNP != null) {
        ((g)localObject).cNP = null;
      }
      this.cNX = null;
    }
    AppMethodBeat.o(140048);
  }
  
  public final void setStrokeWidth(float paramFloat)
  {
    this.cOh.strokeWidth = paramFloat;
  }
  
  public final void useFont(String paramString1, String paramString2, float paramFloat, boolean paramBoolean1, boolean paramBoolean2)
  {
    AppMethodBeat.i(203807);
    j.a locala2 = j.a.m(paramBoolean1, paramBoolean2);
    j localj = this.cOh;
    Object localObject = this.cOg;
    if (locala2 == null) {}
    for (j.a locala1 = j.a.cOn;; locala1 = locala2)
    {
      int i;
      if ((com.tencent.magicbrush.utils.i.isNullOrNil(paramString2)) && (Build.VERSION.SDK_INT >= 28))
      {
        paramString1 = Typeface.create(paramString1, locala1.cOr);
        if ((!com.tencent.magicbrush.utils.i.isNullOrNil(paramString2)) && (((f)localObject).cNM.containsKey(paramString2)))
        {
          i = ((Integer)((f)localObject).cNM.get(paramString2)).intValue();
          if (!locala1.Vm()) {
            break label164;
          }
          paramBoolean1 = true;
          label109:
          paramString1 = Typeface.create(paramString1, i, paramBoolean1);
        }
      }
      for (;;)
      {
        localj.bGp = paramString1;
        this.cOh.cOk = paramString2;
        this.cOh.fontSize = paramFloat;
        this.cOh.cOm = locala2;
        AppMethodBeat.o(203807);
        return;
        i = 400;
        break;
        label164:
        paramBoolean1 = false;
        break label109;
        if ((paramString1 == null) || (paramString1.length() == 0))
        {
          paramString1 = Typeface.create(null, locala1.cOr);
        }
        else
        {
          localObject = (Typeface)((f)localObject).cNL.get(paramString1);
          if (localObject != null)
          {
            paramString1 = (String)localObject;
            if (((Typeface)localObject).getStyle() != locala1.cOr) {
              paramString1 = Typeface.create((Typeface)localObject, locala1.cOr);
            }
          }
          else
          {
            paramString1 = Typeface.create(paramString1, locala1.cOr);
          }
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.magicbrush.handler.glfont.i
 * JD-Core Version:    0.7.0.1
 */