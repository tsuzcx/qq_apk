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
  public f eJB;
  private j eJC;
  private c eJD;
  private boolean eJE = false;
  public b eJi;
  private g eJs;
  private e eJt;
  
  private void clear()
  {
    AppMethodBeat.i(140046);
    c.c.i("MicroMsg.MBFontManagerImpl", "FontManager clear", new Object[0]);
    if (this.eJt != null) {
      this.eJt.clear();
    }
    if (this.eJs != null) {
      this.eJs.clear();
    }
    this.eJE = true;
    AppMethodBeat.o(140046);
  }
  
  public final void a(c paramc)
  {
    this.eJD = paramc;
    if (this.eJs != null)
    {
      paramc = this.eJs;
      c localc = this.eJD;
      paramc.eJk.eJx = localc;
    }
  }
  
  public final boolean checkAndFlushClearSignal()
  {
    boolean bool = this.eJE;
    this.eJE = false;
    return bool;
  }
  
  public final int[] checkAndFlushDirtySignal()
  {
    AppMethodBeat.i(140045);
    if (this.eJt != null)
    {
      Object localObject = this.eJt;
      if (!((e)localObject).eJe.isEmpty()) {}
      for (int i = 1; i == 0; i = 0)
      {
        AppMethodBeat.o(140045);
        return null;
      }
      ((e)localObject).eJf[0] = ((e)localObject).eJe.left;
      ((e)localObject).eJf[1] = ((e)localObject).eJe.top;
      ((e)localObject).eJf[2] = ((e)localObject).eJe.right;
      ((e)localObject).eJf[3] = ((e)localObject).eJe.bottom;
      ((e)localObject).eJe.setEmpty();
      localObject = ((e)localObject).eJf;
      AppMethodBeat.o(140045);
      return localObject;
    }
    AppMethodBeat.o(140045);
    return null;
  }
  
  public final FloatBuffer drawText(String paramString)
  {
    AppMethodBeat.i(140044);
    this.eJs.a(this.eJC);
    FloatBuffer localFloatBuffer2 = this.eJs.fZ(paramString);
    FloatBuffer localFloatBuffer1 = localFloatBuffer2;
    if (localFloatBuffer2 == null)
    {
      c.c.i("MicroMsg.MBFontManagerImpl", "drawText() load result is null. atlas may be full. first time, clear and retry; text = [%s]; mCurrentState = [%s]", new Object[] { paramString, this.eJC });
      clear();
      localFloatBuffer1 = this.eJs.fZ(paramString);
    }
    if (localFloatBuffer1 == null)
    {
      c.c.i("MicroMsg.MBFontManagerImpl", "drawText() load result is null. atlas may be full. second time, just returned; text = [%s]; mCurrentState = [%s]", new Object[] { paramString, this.eJC });
      AppMethodBeat.o(140044);
      return null;
    }
    AppMethodBeat.o(140044);
    return localFloatBuffer1;
  }
  
  public final void enableStroke(boolean paramBoolean)
  {
    this.eJC.eJG = paramBoolean;
  }
  
  public final Bitmap getBitmapAtlas()
  {
    if (this.eJt != null) {
      return this.eJt.eJc;
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
    if ((this.eJB == null) || (this.eJs == null))
    {
      AppMethodBeat.o(140049);
      return 0.0F;
    }
    this.eJs.a(this.eJC);
    paramString = this.eJs.eJk;
    if (paramString.eJA == null)
    {
      AppMethodBeat.o(140049);
      return 0.0F;
    }
    float f1 = paramString.eJA.bottom;
    float f2 = paramString.eJA.ascent;
    AppMethodBeat.o(140049);
    return f1 - f2 + 1.0F;
  }
  
  public final void init(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(140041);
    c.c.i("MicroMsg.MBFontManagerImpl", "init() called with: m_atlasWidth = [" + paramInt1 + "], m_atlasHeight = [" + paramInt2 + "]", new Object[0]);
    this.eJt = new e(paramInt1, paramInt2);
    this.eJB = new f(this.eJi);
    this.eJs = new g(this.eJt, this.eJD);
    this.eJC = new j("normal", j.a.eJI);
    AppMethodBeat.o(140041);
  }
  
  public final String loadFont(String paramString)
  {
    AppMethodBeat.i(140042);
    f localf = this.eJB;
    if ((paramString == null) || (paramString.length() == 0))
    {
      AppMethodBeat.o(140042);
      return null;
    }
    if (localf.eJi == null)
    {
      c.c.i("MicroMsg.MBFont", "[MBFontHandler] FaceProvider is null", new Object[0]);
      AppMethodBeat.o(140042);
      return null;
    }
    paramString = localf.eJi.eN(paramString);
    Typeface localTypeface = localf.eJi.eM(paramString);
    if (localTypeface == null)
    {
      AppMethodBeat.o(140042);
      return null;
    }
    String str = f.fY(paramString);
    paramString = str;
    if (com.tencent.magicbrush.utils.i.isNullOrNil(str))
    {
      if (a.avK() != null) {
        a.avK().mQ(0);
      }
      paramString = "font" + localTypeface.hashCode();
    }
    c.c.i("MicroMsg.MBFont", "familyName:".concat(String.valueOf(paramString)), new Object[0]);
    localf.eJg.put(paramString, localTypeface);
    AppMethodBeat.o(140042);
    return paramString;
  }
  
  public final float measureText(String paramString)
  {
    AppMethodBeat.i(140047);
    this.eJs.a(this.eJC);
    float f2 = this.eJs.gb(paramString);
    float f1 = f2;
    if (f2 == -1.0F)
    {
      c.c.i("MicroMsg.MBFontManagerImpl", "measure() load result is null. atlas may be full. first time, clear and retry; text = [%s]; mCurrentState = [%s]", new Object[] { paramString, this.eJC });
      clear();
      f1 = this.eJs.gb(paramString);
    }
    if (f1 == -1.0F)
    {
      c.c.i("MicroMsg.MBFontManagerImpl", "measure() load result is null. atlas may be full. second time, just returned; text = [%s]; mCurrentState = [%s]", new Object[] { paramString, this.eJC });
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
    if (this.eJt != null)
    {
      localObject = this.eJt;
      if (((e)localObject).eJc != null) {
        ((e)localObject).eJc.recycle();
      }
      this.eJt = null;
    }
    if (this.eJB != null)
    {
      localObject = this.eJB;
      if (((f)localObject).eJg != null)
      {
        ((f)localObject).eJg.clear();
        ((f)localObject).eJg = null;
      }
      this.eJB = null;
    }
    if (this.eJs != null)
    {
      localObject = this.eJs;
      if (((g)localObject).eJk != null) {
        ((g)localObject).eJk = null;
      }
      this.eJs = null;
    }
    AppMethodBeat.o(140048);
  }
  
  public final void setStrokeWidth(float paramFloat)
  {
    this.eJC.strokeWidth = paramFloat;
  }
  
  public final void useFont(String paramString1, String paramString2, float paramFloat, boolean paramBoolean1, boolean paramBoolean2)
  {
    AppMethodBeat.i(228999);
    j.a locala2 = j.a.o(paramBoolean1, paramBoolean2);
    j localj = this.eJC;
    Object localObject = this.eJB;
    if (locala2 == null) {}
    for (j.a locala1 = j.a.eJI;; locala1 = locala2)
    {
      int i;
      if ((com.tencent.magicbrush.utils.i.isNullOrNil(paramString2)) && (Build.VERSION.SDK_INT >= 28))
      {
        paramString1 = Typeface.create(paramString1, locala1.eJM);
        if ((!com.tencent.magicbrush.utils.i.isNullOrNil(paramString2)) && (((f)localObject).eJh.containsKey(paramString2)))
        {
          i = ((Integer)((f)localObject).eJh.get(paramString2)).intValue();
          if (!locala1.avP()) {
            break label164;
          }
          paramBoolean1 = true;
          label109:
          paramString1 = Typeface.create(paramString1, i, paramBoolean1);
        }
      }
      for (;;)
      {
        localj.bbO = paramString1;
        this.eJC.eJF = paramString2;
        this.eJC.fontSize = paramFloat;
        this.eJC.eJH = locala2;
        AppMethodBeat.o(228999);
        return;
        i = 400;
        break;
        label164:
        paramBoolean1 = false;
        break label109;
        if ((paramString1 == null) || (paramString1.length() == 0))
        {
          paramString1 = Typeface.create(null, locala1.eJM);
        }
        else
        {
          localObject = (Typeface)((f)localObject).eJg.get(paramString1);
          if (localObject != null)
          {
            paramString1 = (String)localObject;
            if (((Typeface)localObject).getStyle() != locala1.eJM) {
              paramString1 = Typeface.create((Typeface)localObject, locala1.eJM);
            }
          }
          else
          {
            paramString1 = Typeface.create(paramString1, locala1.eJM);
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