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
  public b cyS;
  private g czc;
  private e czd;
  public f czl;
  private j czm;
  private c czn;
  private boolean czo = false;
  
  private void clear()
  {
    AppMethodBeat.i(140046);
    c.c.i("MicroMsg.MBFontManagerImpl", "FontManager clear", new Object[0]);
    if (this.czd != null) {
      this.czd.clear();
    }
    if (this.czc != null) {
      this.czc.clear();
    }
    this.czo = true;
    AppMethodBeat.o(140046);
  }
  
  public final void a(c paramc)
  {
    this.czn = paramc;
    if (this.czc != null)
    {
      paramc = this.czc;
      c localc = this.czn;
      paramc.cyU.czh = localc;
    }
  }
  
  public final boolean checkAndFlushClearSignal()
  {
    boolean bool = this.czo;
    this.czo = false;
    return bool;
  }
  
  public final int[] checkAndFlushDirtySignal()
  {
    AppMethodBeat.i(140045);
    if (this.czd != null)
    {
      Object localObject = this.czd;
      if (!((e)localObject).cyO.isEmpty()) {}
      for (int i = 1; i == 0; i = 0)
      {
        AppMethodBeat.o(140045);
        return null;
      }
      ((e)localObject).cyP[0] = ((e)localObject).cyO.left;
      ((e)localObject).cyP[1] = ((e)localObject).cyO.top;
      ((e)localObject).cyP[2] = ((e)localObject).cyO.right;
      ((e)localObject).cyP[3] = ((e)localObject).cyO.bottom;
      ((e)localObject).cyO.setEmpty();
      localObject = ((e)localObject).cyP;
      AppMethodBeat.o(140045);
      return localObject;
    }
    AppMethodBeat.o(140045);
    return null;
  }
  
  public final FloatBuffer drawText(String paramString)
  {
    AppMethodBeat.i(140044);
    this.czc.a(this.czm);
    FloatBuffer localFloatBuffer2 = this.czc.dG(paramString);
    FloatBuffer localFloatBuffer1 = localFloatBuffer2;
    if (localFloatBuffer2 == null)
    {
      c.c.i("MicroMsg.MBFontManagerImpl", "drawText() load result is null. atlas may be full. first time, clear and retry; text = [%s]; mCurrentState = [%s]", new Object[] { paramString, this.czm });
      clear();
      localFloatBuffer1 = this.czc.dG(paramString);
    }
    if (localFloatBuffer1 == null)
    {
      c.c.i("MicroMsg.MBFontManagerImpl", "drawText() load result is null. atlas may be full. second time, just returned; text = [%s]; mCurrentState = [%s]", new Object[] { paramString, this.czm });
      AppMethodBeat.o(140044);
      return null;
    }
    AppMethodBeat.o(140044);
    return localFloatBuffer1;
  }
  
  public final void enableStroke(boolean paramBoolean)
  {
    this.czm.czq = paramBoolean;
  }
  
  public final Bitmap getBitmapAtlas()
  {
    if (this.czd != null) {
      return this.czd.cyM;
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
    if ((this.czl == null) || (this.czc == null))
    {
      AppMethodBeat.o(140049);
      return 0.0F;
    }
    this.czc.a(this.czm);
    paramString = this.czc.cyU;
    if (paramString.czk == null)
    {
      AppMethodBeat.o(140049);
      return 0.0F;
    }
    float f1 = paramString.czk.bottom;
    float f2 = paramString.czk.ascent;
    AppMethodBeat.o(140049);
    return f1 - f2 + 1.0F;
  }
  
  public final void init(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(140041);
    c.c.i("MicroMsg.MBFontManagerImpl", "init() called with: m_atlasWidth = [" + paramInt1 + "], m_atlasHeight = [" + paramInt2 + "]", new Object[0]);
    this.czd = new e(paramInt1, paramInt2);
    this.czl = new f(this.cyS);
    this.czc = new g(this.czd, this.czn);
    this.czm = new j("normal", j.a.czs);
    AppMethodBeat.o(140041);
  }
  
  public final String loadFont(String paramString)
  {
    AppMethodBeat.i(140042);
    f localf = this.czl;
    if ((paramString == null) || (paramString.length() == 0))
    {
      AppMethodBeat.o(140042);
      return null;
    }
    if (localf.cyS == null)
    {
      c.c.i("MicroMsg.MBFont", "[MBFontHandler] FaceProvider is null", new Object[0]);
      AppMethodBeat.o(140042);
      return null;
    }
    paramString = localf.cyS.cM(paramString);
    Typeface localTypeface = localf.cyS.cL(paramString);
    if (localTypeface == null)
    {
      AppMethodBeat.o(140042);
      return null;
    }
    String str = f.dF(paramString);
    paramString = str;
    if (com.tencent.magicbrush.utils.h.isNullOrNil(str))
    {
      if (a.HI() != null) {
        a.HI().gT(0);
      }
      paramString = "font" + localTypeface.hashCode();
    }
    c.c.i("MicroMsg.MBFont", "familyName:".concat(String.valueOf(paramString)), new Object[0]);
    localf.cyQ.put(paramString, localTypeface);
    AppMethodBeat.o(140042);
    return paramString;
  }
  
  public final float measureText(String paramString)
  {
    AppMethodBeat.i(140047);
    this.czc.a(this.czm);
    float f2 = this.czc.dI(paramString);
    float f1 = f2;
    if (f2 == -1.0F)
    {
      c.c.i("MicroMsg.MBFontManagerImpl", "measure() load result is null. atlas may be full. first time, clear and retry; text = [%s]; mCurrentState = [%s]", new Object[] { paramString, this.czm });
      clear();
      f1 = this.czc.dI(paramString);
    }
    if (f1 == -1.0F)
    {
      c.c.i("MicroMsg.MBFontManagerImpl", "measure() load result is null. atlas may be full. second time, just returned; text = [%s]; mCurrentState = [%s]", new Object[] { paramString, this.czm });
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
    if (this.czd != null)
    {
      localObject = this.czd;
      if (((e)localObject).cyM != null) {
        ((e)localObject).cyM.recycle();
      }
      this.czd = null;
    }
    if (this.czl != null)
    {
      localObject = this.czl;
      if (((f)localObject).cyQ != null)
      {
        ((f)localObject).cyQ.clear();
        ((f)localObject).cyQ = null;
      }
      this.czl = null;
    }
    if (this.czc != null)
    {
      localObject = this.czc;
      if (((g)localObject).cyU != null) {
        ((g)localObject).cyU = null;
      }
      this.czc = null;
    }
    AppMethodBeat.o(140048);
  }
  
  public final void setStrokeWidth(float paramFloat)
  {
    this.czm.strokeWidth = paramFloat;
  }
  
  public final void useFont(String paramString1, String paramString2, float paramFloat, boolean paramBoolean1, boolean paramBoolean2)
  {
    AppMethodBeat.i(213317);
    j.a locala2 = j.a.j(paramBoolean1, paramBoolean2);
    j localj = this.czm;
    Object localObject = this.czl;
    if (locala2 == null) {}
    for (j.a locala1 = j.a.czs;; locala1 = locala2)
    {
      int i;
      if ((com.tencent.magicbrush.utils.h.isNullOrNil(paramString2)) && (Build.VERSION.SDK_INT >= 28))
      {
        paramString1 = Typeface.create(paramString1, locala1.czw);
        if ((!com.tencent.magicbrush.utils.h.isNullOrNil(paramString2)) && (((f)localObject).cyR.containsKey(paramString2)))
        {
          i = ((Integer)((f)localObject).cyR.get(paramString2)).intValue();
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
        localj.sx = paramString1;
        this.czm.czp = paramString2;
        this.czm.fontSize = paramFloat;
        this.czm.czr = locala2;
        AppMethodBeat.o(213317);
        return;
        i = 400;
        break;
        label164:
        paramBoolean1 = false;
        break label109;
        if ((paramString1 == null) || (paramString1.length() == 0))
        {
          paramString1 = Typeface.create(null, locala1.czw);
        }
        else
        {
          localObject = (Typeface)((f)localObject).cyQ.get(paramString1);
          if (localObject != null)
          {
            paramString1 = (String)localObject;
            if (((Typeface)localObject).getStyle() != locala1.czw) {
              paramString1 = Typeface.create((Typeface)localObject, locala1.czw);
            }
          }
          else
          {
            paramString1 = Typeface.create(paramString1, locala1.czw);
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