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
  public b bJO;
  private f bJX;
  private d bJY;
  public e bKf;
  private i bKg;
  private boolean bKh = false;
  
  private void clear()
  {
    AppMethodBeat.i(115945);
    c.c.i("MicroMsg.MBFontManagerImpl", "FontManager clear", new Object[0]);
    if (this.bJY != null) {
      this.bJY.clear();
    }
    if (this.bJX != null) {
      this.bJX.clear();
    }
    this.bKh = true;
    AppMethodBeat.o(115945);
  }
  
  public final boolean checkAndFlushClearSignal()
  {
    boolean bool = this.bKh;
    this.bKh = false;
    return bool;
  }
  
  public final int[] checkAndFlushDirtySignal()
  {
    AppMethodBeat.i(115944);
    if (this.bJY != null)
    {
      Object localObject = this.bJY;
      if (!((d)localObject).bJL.isEmpty()) {}
      for (int i = 1; i == 0; i = 0)
      {
        AppMethodBeat.o(115944);
        return null;
      }
      ((d)localObject).bJM[0] = ((d)localObject).bJL.left;
      ((d)localObject).bJM[1] = ((d)localObject).bJL.top;
      ((d)localObject).bJM[2] = ((d)localObject).bJL.right;
      ((d)localObject).bJM[3] = ((d)localObject).bJL.bottom;
      ((d)localObject).bJL.setEmpty();
      localObject = ((d)localObject).bJM;
      AppMethodBeat.o(115944);
      return localObject;
    }
    AppMethodBeat.o(115944);
    return null;
  }
  
  public final FloatBuffer drawText(String paramString)
  {
    AppMethodBeat.i(115943);
    this.bJX.a(this.bKg);
    FloatBuffer localFloatBuffer2 = this.bJX.cr(paramString);
    FloatBuffer localFloatBuffer1 = localFloatBuffer2;
    if (localFloatBuffer2 == null)
    {
      c.c.i("MicroMsg.MBFontManagerImpl", "drawText() load result is null. atlas may be full. first time, clear and retry; text = [%s]; mCurrentState = [%s]", new Object[] { paramString, this.bKg });
      clear();
      localFloatBuffer1 = this.bJX.cr(paramString);
    }
    if (localFloatBuffer1 == null)
    {
      c.c.i("MicroMsg.MBFontManagerImpl", "drawText() load result is null. atlas may be full. second time, just returned; text = [%s]; mCurrentState = [%s]", new Object[] { paramString, this.bKg });
      AppMethodBeat.o(115943);
      return null;
    }
    AppMethodBeat.o(115943);
    return localFloatBuffer1;
  }
  
  public final void enableStroke(boolean paramBoolean)
  {
    this.bKg.bKj = paramBoolean;
  }
  
  public final Bitmap getBitmapAtlas()
  {
    if (this.bJY != null) {
      return this.bJY.bJJ;
    }
    return null;
  }
  
  public final float getTextLineHeight(String paramString)
  {
    AppMethodBeat.i(115948);
    if ((paramString == null) || (paramString.length() == 0))
    {
      AppMethodBeat.o(115948);
      return 0.0F;
    }
    if ((this.bKf == null) || (this.bJX == null))
    {
      AppMethodBeat.o(115948);
      return 0.0F;
    }
    this.bJX.a(this.bKg);
    paramString = this.bJX.bJP;
    if (paramString.bKe == null)
    {
      AppMethodBeat.o(115948);
      return 0.0F;
    }
    float f1 = paramString.bKe.descent;
    float f2 = paramString.bKe.ascent;
    AppMethodBeat.o(115948);
    return f1 - f2 + 1.0F;
  }
  
  public final void init(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(115940);
    c.c.i("MicroMsg.MBFontManagerImpl", "init() called with: m_atlasWidth = [" + paramInt1 + "], m_atlasHeight = [" + paramInt2 + "]", new Object[0]);
    this.bJY = new d(paramInt1, paramInt2);
    this.bKf = new e(this.bJO);
    this.bJX = new f(this.bJY);
    this.bKg = new i(i.a.bKl);
    AppMethodBeat.o(115940);
  }
  
  public final String loadFont(String paramString)
  {
    AppMethodBeat.i(115941);
    e locale = this.bKf;
    if ((paramString == null) || (paramString.length() == 0))
    {
      AppMethodBeat.o(115941);
      return null;
    }
    if (locale.bJO == null)
    {
      c.c.i("MicroMsg.MBFont", "[MBFontHandler] FaceProvider is null", new Object[0]);
      AppMethodBeat.o(115941);
      return null;
    }
    paramString = locale.bJO.bK(paramString);
    Typeface localTypeface = locale.bJO.bJ(paramString);
    if (localTypeface == null)
    {
      AppMethodBeat.o(115941);
      return null;
    }
    String str = e.cq(paramString);
    paramString = str;
    if (com.tencent.magicbrush.d.e.isNullOrNil(str))
    {
      if (a.ys() != null) {
        a.ys().fI(0);
      }
      paramString = "font" + localTypeface.hashCode();
    }
    c.c.i("MicroMsg.MBFont", "familyName:".concat(String.valueOf(paramString)), new Object[0]);
    locale.bJN.put(paramString, localTypeface);
    AppMethodBeat.o(115941);
    return paramString;
  }
  
  public final float measureText(String paramString)
  {
    AppMethodBeat.i(115946);
    this.bJX.a(this.bKg);
    float f2 = this.bJX.ct(paramString);
    float f1 = f2;
    if (f2 == -1.0F)
    {
      c.c.i("MicroMsg.MBFontManagerImpl", "measure() load result is null. atlas may be full. first time, clear and retry; text = [%s]; mCurrentState = [%s]", new Object[] { paramString, this.bKg });
      clear();
      f1 = this.bJX.ct(paramString);
    }
    if (f1 == -1.0F)
    {
      c.c.i("MicroMsg.MBFontManagerImpl", "measure() load result is null. atlas may be full. second time, just returned; text = [%s]; mCurrentState = [%s]", new Object[] { paramString, this.bKg });
      AppMethodBeat.o(115946);
      return 0.0F;
    }
    AppMethodBeat.o(115946);
    return f1;
  }
  
  public final void release()
  {
    AppMethodBeat.i(115947);
    Object localObject;
    if (this.bJY != null)
    {
      localObject = this.bJY;
      if (((d)localObject).bJJ != null) {
        ((d)localObject).bJJ.recycle();
      }
      this.bJY = null;
    }
    if (this.bKf != null)
    {
      localObject = this.bKf;
      if (((e)localObject).bJN != null)
      {
        ((e)localObject).bJN.clear();
        ((e)localObject).bJN = null;
      }
      this.bKf = null;
    }
    if (this.bJX != null)
    {
      localObject = this.bJX;
      if (((f)localObject).bJP != null) {
        ((f)localObject).bJP = null;
      }
      this.bJX = null;
    }
    AppMethodBeat.o(115947);
  }
  
  public final void setStrokeWidth(float paramFloat)
  {
    this.bKg.strokeWidth = paramFloat;
  }
  
  public final void useFont(String paramString, float paramFloat, boolean paramBoolean1, boolean paramBoolean2)
  {
    AppMethodBeat.i(115942);
    i.a locala2 = i.a.i(paramBoolean1, paramBoolean2);
    i locali = this.bKg;
    Object localObject = this.bKf;
    if (locala2 == null) {}
    for (i.a locala1 = i.a.bKl;; locala1 = locala2)
    {
      if ((paramString == null) || (paramString.length() == 0)) {
        paramString = Typeface.create(null, locala1.bKp);
      }
      for (;;)
      {
        locali.bKi = paramString;
        this.bKg.fontSize = paramFloat;
        this.bKg.bKk = locala2;
        AppMethodBeat.o(115942);
        return;
        localObject = (Typeface)((e)localObject).bJN.get(paramString);
        if (localObject != null)
        {
          paramString = (String)localObject;
          if (((Typeface)localObject).getStyle() != locala1.bKp) {
            paramString = Typeface.create((Typeface)localObject, locala1.bKp);
          }
        }
        else
        {
          paramString = Typeface.create(paramString, locala1.bKp);
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.magicbrush.handler.glfont.h
 * JD-Core Version:    0.7.0.1
 */