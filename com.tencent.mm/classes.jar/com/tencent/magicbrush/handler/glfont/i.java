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
  public b cMZ;
  private g cNj;
  private e cNk;
  public f cNs;
  private j cNt;
  private c cNu;
  private boolean cNv = false;
  
  private void clear()
  {
    AppMethodBeat.i(140046);
    c.c.i("MicroMsg.MBFontManagerImpl", "FontManager clear", new Object[0]);
    if (this.cNk != null) {
      this.cNk.clear();
    }
    if (this.cNj != null) {
      this.cNj.clear();
    }
    this.cNv = true;
    AppMethodBeat.o(140046);
  }
  
  public final void a(c paramc)
  {
    this.cNu = paramc;
    if (this.cNj != null)
    {
      paramc = this.cNj;
      c localc = this.cNu;
      paramc.cNb.cNo = localc;
    }
  }
  
  public final boolean checkAndFlushClearSignal()
  {
    boolean bool = this.cNv;
    this.cNv = false;
    return bool;
  }
  
  public final int[] checkAndFlushDirtySignal()
  {
    AppMethodBeat.i(140045);
    if (this.cNk != null)
    {
      Object localObject = this.cNk;
      if (!((e)localObject).cMV.isEmpty()) {}
      for (int i = 1; i == 0; i = 0)
      {
        AppMethodBeat.o(140045);
        return null;
      }
      ((e)localObject).cMW[0] = ((e)localObject).cMV.left;
      ((e)localObject).cMW[1] = ((e)localObject).cMV.top;
      ((e)localObject).cMW[2] = ((e)localObject).cMV.right;
      ((e)localObject).cMW[3] = ((e)localObject).cMV.bottom;
      ((e)localObject).cMV.setEmpty();
      localObject = ((e)localObject).cMW;
      AppMethodBeat.o(140045);
      return localObject;
    }
    AppMethodBeat.o(140045);
    return null;
  }
  
  public final FloatBuffer drawText(String paramString)
  {
    AppMethodBeat.i(140044);
    this.cNj.a(this.cNt);
    FloatBuffer localFloatBuffer2 = this.cNj.eb(paramString);
    FloatBuffer localFloatBuffer1 = localFloatBuffer2;
    if (localFloatBuffer2 == null)
    {
      c.c.i("MicroMsg.MBFontManagerImpl", "drawText() load result is null. atlas may be full. first time, clear and retry; text = [%s]; mCurrentState = [%s]", new Object[] { paramString, this.cNt });
      clear();
      localFloatBuffer1 = this.cNj.eb(paramString);
    }
    if (localFloatBuffer1 == null)
    {
      c.c.i("MicroMsg.MBFontManagerImpl", "drawText() load result is null. atlas may be full. second time, just returned; text = [%s]; mCurrentState = [%s]", new Object[] { paramString, this.cNt });
      AppMethodBeat.o(140044);
      return null;
    }
    AppMethodBeat.o(140044);
    return localFloatBuffer1;
  }
  
  public final void enableStroke(boolean paramBoolean)
  {
    this.cNt.cNx = paramBoolean;
  }
  
  public final Bitmap getBitmapAtlas()
  {
    if (this.cNk != null) {
      return this.cNk.cMT;
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
    if ((this.cNs == null) || (this.cNj == null))
    {
      AppMethodBeat.o(140049);
      return 0.0F;
    }
    this.cNj.a(this.cNt);
    paramString = this.cNj.cNb;
    if (paramString.cNr == null)
    {
      AppMethodBeat.o(140049);
      return 0.0F;
    }
    float f1 = paramString.cNr.bottom;
    float f2 = paramString.cNr.ascent;
    AppMethodBeat.o(140049);
    return f1 - f2 + 1.0F;
  }
  
  public final void init(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(140041);
    c.c.i("MicroMsg.MBFontManagerImpl", "init() called with: m_atlasWidth = [" + paramInt1 + "], m_atlasHeight = [" + paramInt2 + "]", new Object[0]);
    this.cNk = new e(paramInt1, paramInt2);
    this.cNs = new f(this.cMZ);
    this.cNj = new g(this.cNk, this.cNu);
    this.cNt = new j("normal", j.a.cNz);
    AppMethodBeat.o(140041);
  }
  
  public final String loadFont(String paramString)
  {
    AppMethodBeat.i(140042);
    f localf = this.cNs;
    if ((paramString == null) || (paramString.length() == 0))
    {
      AppMethodBeat.o(140042);
      return null;
    }
    if (localf.cMZ == null)
    {
      c.c.i("MicroMsg.MBFont", "[MBFontHandler] FaceProvider is null", new Object[0]);
      AppMethodBeat.o(140042);
      return null;
    }
    paramString = localf.cMZ.dl(paramString);
    Typeface localTypeface = localf.cMZ.dg(paramString);
    if (localTypeface == null)
    {
      AppMethodBeat.o(140042);
      return null;
    }
    String str = f.ea(paramString);
    paramString = str;
    if (com.tencent.magicbrush.utils.h.isNullOrNil(str))
    {
      if (a.Rx() != null) {
        a.Rx().ik(0);
      }
      paramString = "font" + localTypeface.hashCode();
    }
    c.c.i("MicroMsg.MBFont", "familyName:".concat(String.valueOf(paramString)), new Object[0]);
    localf.cMX.put(paramString, localTypeface);
    AppMethodBeat.o(140042);
    return paramString;
  }
  
  public final float measureText(String paramString)
  {
    AppMethodBeat.i(140047);
    this.cNj.a(this.cNt);
    float f2 = this.cNj.ed(paramString);
    float f1 = f2;
    if (f2 == -1.0F)
    {
      c.c.i("MicroMsg.MBFontManagerImpl", "measure() load result is null. atlas may be full. first time, clear and retry; text = [%s]; mCurrentState = [%s]", new Object[] { paramString, this.cNt });
      clear();
      f1 = this.cNj.ed(paramString);
    }
    if (f1 == -1.0F)
    {
      c.c.i("MicroMsg.MBFontManagerImpl", "measure() load result is null. atlas may be full. second time, just returned; text = [%s]; mCurrentState = [%s]", new Object[] { paramString, this.cNt });
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
    if (this.cNk != null)
    {
      localObject = this.cNk;
      if (((e)localObject).cMT != null) {
        ((e)localObject).cMT.recycle();
      }
      this.cNk = null;
    }
    if (this.cNs != null)
    {
      localObject = this.cNs;
      if (((f)localObject).cMX != null)
      {
        ((f)localObject).cMX.clear();
        ((f)localObject).cMX = null;
      }
      this.cNs = null;
    }
    if (this.cNj != null)
    {
      localObject = this.cNj;
      if (((g)localObject).cNb != null) {
        ((g)localObject).cNb = null;
      }
      this.cNj = null;
    }
    AppMethodBeat.o(140048);
  }
  
  public final void setStrokeWidth(float paramFloat)
  {
    this.cNt.strokeWidth = paramFloat;
  }
  
  public final void useFont(String paramString1, String paramString2, float paramFloat, boolean paramBoolean1, boolean paramBoolean2)
  {
    AppMethodBeat.i(206813);
    j.a locala2 = j.a.j(paramBoolean1, paramBoolean2);
    j localj = this.cNt;
    Object localObject = this.cNs;
    if (locala2 == null) {}
    for (j.a locala1 = j.a.cNz;; locala1 = locala2)
    {
      int i;
      if ((com.tencent.magicbrush.utils.h.isNullOrNil(paramString2)) && (Build.VERSION.SDK_INT >= 28))
      {
        paramString1 = Typeface.create(paramString1, locala1.cND);
        if ((!com.tencent.magicbrush.utils.h.isNullOrNil(paramString2)) && (((f)localObject).cMY.containsKey(paramString2)))
        {
          i = ((Integer)((f)localObject).cMY.get(paramString2)).intValue();
          if (!locala1.isItalic()) {
            break label164;
          }
          paramBoolean1 = true;
          label109:
          paramString1 = Typeface.create(paramString1, i, paramBoolean1);
        }
      }
      for (;;)
      {
        localj.sB = paramString1;
        this.cNt.cNw = paramString2;
        this.cNt.fontSize = paramFloat;
        this.cNt.cNy = locala2;
        AppMethodBeat.o(206813);
        return;
        i = 400;
        break;
        label164:
        paramBoolean1 = false;
        break label109;
        if ((paramString1 == null) || (paramString1.length() == 0))
        {
          paramString1 = Typeface.create(null, locala1.cND);
        }
        else
        {
          localObject = (Typeface)((f)localObject).cMX.get(paramString1);
          if (localObject != null)
          {
            paramString1 = (String)localObject;
            if (((Typeface)localObject).getStyle() != locala1.cND) {
              paramString1 = Typeface.create((Typeface)localObject, locala1.cND);
            }
          }
          else
          {
            paramString1 = Typeface.create(paramString1, locala1.cND);
          }
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.magicbrush.handler.glfont.i
 * JD-Core Version:    0.7.0.1
 */