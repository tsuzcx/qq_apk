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
  public f cyE;
  private j cyF;
  private c cyG;
  private boolean cyH = false;
  public b cyl;
  private g cyv;
  private e cyw;
  
  private void clear()
  {
    AppMethodBeat.i(140046);
    c.c.i("MicroMsg.MBFontManagerImpl", "FontManager clear", new Object[0]);
    if (this.cyw != null) {
      this.cyw.clear();
    }
    if (this.cyv != null) {
      this.cyv.clear();
    }
    this.cyH = true;
    AppMethodBeat.o(140046);
  }
  
  public final void a(c paramc)
  {
    this.cyG = paramc;
    if (this.cyv != null)
    {
      paramc = this.cyv;
      c localc = this.cyG;
      paramc.cyn.cyA = localc;
    }
  }
  
  public final boolean checkAndFlushClearSignal()
  {
    boolean bool = this.cyH;
    this.cyH = false;
    return bool;
  }
  
  public final int[] checkAndFlushDirtySignal()
  {
    AppMethodBeat.i(140045);
    if (this.cyw != null)
    {
      Object localObject = this.cyw;
      if (!((e)localObject).cyh.isEmpty()) {}
      for (int i = 1; i == 0; i = 0)
      {
        AppMethodBeat.o(140045);
        return null;
      }
      ((e)localObject).cyi[0] = ((e)localObject).cyh.left;
      ((e)localObject).cyi[1] = ((e)localObject).cyh.top;
      ((e)localObject).cyi[2] = ((e)localObject).cyh.right;
      ((e)localObject).cyi[3] = ((e)localObject).cyh.bottom;
      ((e)localObject).cyh.setEmpty();
      localObject = ((e)localObject).cyi;
      AppMethodBeat.o(140045);
      return localObject;
    }
    AppMethodBeat.o(140045);
    return null;
  }
  
  public final FloatBuffer drawText(String paramString)
  {
    AppMethodBeat.i(140044);
    this.cyv.a(this.cyF);
    FloatBuffer localFloatBuffer2 = this.cyv.dD(paramString);
    FloatBuffer localFloatBuffer1 = localFloatBuffer2;
    if (localFloatBuffer2 == null)
    {
      c.c.i("MicroMsg.MBFontManagerImpl", "drawText() load result is null. atlas may be full. first time, clear and retry; text = [%s]; mCurrentState = [%s]", new Object[] { paramString, this.cyF });
      clear();
      localFloatBuffer1 = this.cyv.dD(paramString);
    }
    if (localFloatBuffer1 == null)
    {
      c.c.i("MicroMsg.MBFontManagerImpl", "drawText() load result is null. atlas may be full. second time, just returned; text = [%s]; mCurrentState = [%s]", new Object[] { paramString, this.cyF });
      AppMethodBeat.o(140044);
      return null;
    }
    AppMethodBeat.o(140044);
    return localFloatBuffer1;
  }
  
  public final void enableStroke(boolean paramBoolean)
  {
    this.cyF.cyJ = paramBoolean;
  }
  
  public final Bitmap getBitmapAtlas()
  {
    if (this.cyw != null) {
      return this.cyw.cyf;
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
    if ((this.cyE == null) || (this.cyv == null))
    {
      AppMethodBeat.o(140049);
      return 0.0F;
    }
    this.cyv.a(this.cyF);
    paramString = this.cyv.cyn;
    if (paramString.cyD == null)
    {
      AppMethodBeat.o(140049);
      return 0.0F;
    }
    float f1 = paramString.cyD.descent;
    float f2 = paramString.cyD.ascent;
    AppMethodBeat.o(140049);
    return f1 - f2 + 1.0F;
  }
  
  public final void init(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(140041);
    c.c.i("MicroMsg.MBFontManagerImpl", "init() called with: m_atlasWidth = [" + paramInt1 + "], m_atlasHeight = [" + paramInt2 + "]", new Object[0]);
    this.cyw = new e(paramInt1, paramInt2);
    this.cyE = new f(this.cyl);
    this.cyv = new g(this.cyw, this.cyG);
    this.cyF = new j("normal", j.a.cyL);
    AppMethodBeat.o(140041);
  }
  
  public final String loadFont(String paramString)
  {
    AppMethodBeat.i(140042);
    f localf = this.cyE;
    if ((paramString == null) || (paramString.length() == 0))
    {
      AppMethodBeat.o(140042);
      return null;
    }
    if (localf.cyl == null)
    {
      c.c.i("MicroMsg.MBFont", "[MBFontHandler] FaceProvider is null", new Object[0]);
      AppMethodBeat.o(140042);
      return null;
    }
    paramString = localf.cyl.cK(paramString);
    Typeface localTypeface = localf.cyl.cJ(paramString);
    if (localTypeface == null)
    {
      AppMethodBeat.o(140042);
      return null;
    }
    String str = f.dC(paramString);
    paramString = str;
    if (com.tencent.magicbrush.utils.h.isNullOrNil(str))
    {
      if (a.HA() != null) {
        a.HA().gS(0);
      }
      paramString = "font" + localTypeface.hashCode();
    }
    c.c.i("MicroMsg.MBFont", "familyName:".concat(String.valueOf(paramString)), new Object[0]);
    localf.cyj.put(paramString, localTypeface);
    AppMethodBeat.o(140042);
    return paramString;
  }
  
  public final float measureText(String paramString)
  {
    AppMethodBeat.i(140047);
    this.cyv.a(this.cyF);
    float f2 = this.cyv.dF(paramString);
    float f1 = f2;
    if (f2 == -1.0F)
    {
      c.c.i("MicroMsg.MBFontManagerImpl", "measure() load result is null. atlas may be full. first time, clear and retry; text = [%s]; mCurrentState = [%s]", new Object[] { paramString, this.cyF });
      clear();
      f1 = this.cyv.dF(paramString);
    }
    if (f1 == -1.0F)
    {
      c.c.i("MicroMsg.MBFontManagerImpl", "measure() load result is null. atlas may be full. second time, just returned; text = [%s]; mCurrentState = [%s]", new Object[] { paramString, this.cyF });
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
    if (this.cyw != null)
    {
      localObject = this.cyw;
      if (((e)localObject).cyf != null) {
        ((e)localObject).cyf.recycle();
      }
      this.cyw = null;
    }
    if (this.cyE != null)
    {
      localObject = this.cyE;
      if (((f)localObject).cyj != null)
      {
        ((f)localObject).cyj.clear();
        ((f)localObject).cyj = null;
      }
      this.cyE = null;
    }
    if (this.cyv != null)
    {
      localObject = this.cyv;
      if (((g)localObject).cyn != null) {
        ((g)localObject).cyn = null;
      }
      this.cyv = null;
    }
    AppMethodBeat.o(140048);
  }
  
  public final void setStrokeWidth(float paramFloat)
  {
    this.cyF.strokeWidth = paramFloat;
  }
  
  public final void useFont(String paramString1, String paramString2, float paramFloat, boolean paramBoolean1, boolean paramBoolean2)
  {
    AppMethodBeat.i(215084);
    j.a locala2 = j.a.j(paramBoolean1, paramBoolean2);
    j localj = this.cyF;
    Object localObject = this.cyE;
    if (locala2 == null) {}
    for (j.a locala1 = j.a.cyL;; locala1 = locala2)
    {
      int i;
      if ((com.tencent.magicbrush.utils.h.isNullOrNil(paramString2)) && (Build.VERSION.SDK_INT >= 28))
      {
        paramString1 = Typeface.create(paramString1, locala1.cyP);
        if ((!com.tencent.magicbrush.utils.h.isNullOrNil(paramString2)) && (((f)localObject).cyk.containsKey(paramString2)))
        {
          i = ((Integer)((f)localObject).cyk.get(paramString2)).intValue();
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
        this.cyF.cyI = paramString2;
        this.cyF.fontSize = paramFloat;
        this.cyF.cyK = locala2;
        AppMethodBeat.o(215084);
        return;
        i = 400;
        break;
        label164:
        paramBoolean1 = false;
        break label109;
        if ((paramString1 == null) || (paramString1.length() == 0))
        {
          paramString1 = Typeface.create(null, locala1.cyP);
        }
        else
        {
          localObject = (Typeface)((f)localObject).cyj.get(paramString1);
          if (localObject != null)
          {
            paramString1 = (String)localObject;
            if (((Typeface)localObject).getStyle() != locala1.cyP) {
              paramString1 = Typeface.create((Typeface)localObject, locala1.cyP);
            }
          }
          else
          {
            paramString1 = Typeface.create(paramString1, locala1.cyP);
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