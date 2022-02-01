package com.tencent.magicbrush.handler.glfont;

import android.annotation.SuppressLint;
import android.graphics.Paint;
import android.graphics.Paint.FontMetrics;
import android.graphics.Paint.Style;
import android.graphics.Typeface;
import com.tencent.magicbrush.a.a;
import com.tencent.magicbrush.a.a.a;
import com.tencent.magicbrush.a.c.c;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.FloatBuffer;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Queue;

@SuppressLint({"LongLogTag"})
final class g
{
  h cyU;
  private HashMap<String, k> cyV;
  g.a cyW;
  private FloatBuffer cyX;
  private List<k> cyY;
  private j cyZ;
  private StringBuilder cza;
  
  g(e parame, c paramc)
  {
    AppMethodBeat.i(213316);
    this.cza = new StringBuilder();
    this.cyU = new h(parame, this);
    this.cyU.czh = paramc;
    this.cyV = new HashMap();
    this.cyW = new g.a();
    this.cyY = new ArrayList();
    AppMethodBeat.o(213316);
  }
  
  private List<k> dH(String paramString)
  {
    AppMethodBeat.i(140023);
    if ((paramString == null) || (paramString.length() == 0))
    {
      AppMethodBeat.o(140023);
      return null;
    }
    this.cyY.clear();
    int i = 0;
    while (i < paramString.length())
    {
      int j = s(paramString, i);
      k localk;
      if (j > 0)
      {
        localk = i(paramString, i, j);
        i += j;
      }
      while (localk == null)
      {
        this.cyY.clear();
        AppMethodBeat.o(140023);
        return null;
        localk = s(paramString.charAt(i));
        i += 1;
      }
      this.cyY.add(localk);
    }
    paramString = this.cyY;
    AppMethodBeat.o(140023);
    return paramString;
  }
  
  private k i(String paramString, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(140025);
    String str = j(paramString, paramInt1, paramInt2);
    k localk = (k)this.cyV.get(str);
    if (localk != null)
    {
      AppMethodBeat.o(140025);
      return localk;
    }
    if (a.HE() == null)
    {
      paramString = new IllegalStateException("FontDrawableProvider must support");
      AppMethodBeat.o(140025);
      throw paramString;
    }
    paramString = a.HE().r(paramString, paramInt1);
    if (paramString == null)
    {
      AppMethodBeat.o(140025);
      return null;
    }
    paramInt1 = (int)this.cyZ.fontSize;
    int i = (int)this.cyZ.fontSize;
    if ((paramInt1 <= 0) || (i <= 0))
    {
      AppMethodBeat.o(140025);
      return null;
    }
    paramString = this.cyU.a(paramString, paramInt1, i);
    if (paramString == null)
    {
      c.c.d("MagicBrush.MBFontGlyphManager", "Load font drawable glyph failed.", new Object[0]);
      AppMethodBeat.o(140025);
      return null;
    }
    paramString.czG = paramInt2;
    this.cyV.put(str, paramString);
    AppMethodBeat.o(140025);
    return paramString;
  }
  
  private String j(String paramString, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(140027);
    if (paramInt2 <= 0)
    {
      paramString = new IllegalStateException("There is no font drawable");
      AppMethodBeat.o(140027);
      throw paramString;
    }
    this.cza.setLength(0);
    while (paramInt2 > 0)
    {
      this.cza.append(paramString.charAt(paramInt1));
      paramInt1 += 1;
      paramInt2 -= 1;
    }
    this.cza.append("|").append(this.cyZ.fontSize);
    paramString = this.cza.toString();
    AppMethodBeat.o(140027);
    return paramString;
  }
  
  private static int s(String paramString, int paramInt)
  {
    AppMethodBeat.i(140026);
    if (a.HE() == null)
    {
      AppMethodBeat.o(140026);
      return 0;
    }
    paramInt = a.HE().q(paramString, paramInt);
    AppMethodBeat.o(140026);
    return paramInt;
  }
  
  private k s(char paramChar)
  {
    AppMethodBeat.i(140024);
    if (this.cyZ == null)
    {
      AppMethodBeat.o(140024);
      return null;
    }
    String str = t(paramChar);
    k localk = (k)this.cyV.get(str);
    if (localk != null)
    {
      AppMethodBeat.o(140024);
      return localk;
    }
    localk = this.cyU.u(paramChar);
    if (localk == null)
    {
      c.c.d("MagicBrush.MBFontGlyphManager", "Load glyph failed. glyph == null [" + paramChar + "]", new Object[0]);
      AppMethodBeat.o(140024);
      return null;
    }
    this.cyV.put(str, localk);
    AppMethodBeat.o(140024);
    return localk;
  }
  
  private String t(char paramChar)
  {
    AppMethodBeat.i(140028);
    if (this.cyZ == null)
    {
      AppMethodBeat.o(140028);
      return null;
    }
    this.cza.setLength(0);
    StringBuilder localStringBuilder = this.cza.append(paramChar).append("|").append(this.cyZ.fontSize).append("|");
    if (this.cyZ.sx == null) {}
    for (Object localObject = "null";; localObject = Integer.valueOf(this.cyZ.sx.hashCode()))
    {
      localObject = localStringBuilder.append(localObject);
      if (this.cyZ.czq) {
        ((StringBuilder)localObject).append("|").append(this.cyZ.strokeWidth);
      }
      if (this.cyZ.czr != null) {
        ((StringBuilder)localObject).append("|").append(this.cyZ.czr.czw);
      }
      localObject = ((StringBuilder)localObject).toString();
      AppMethodBeat.o(140028);
      return localObject;
    }
  }
  
  final void a(j paramj)
  {
    AppMethodBeat.i(140029);
    this.cyZ = paramj;
    h localh = this.cyU;
    localh.czf = paramj;
    localh.czg.setTypeface(paramj.sx);
    localh.czg.setTextSize(paramj.fontSize);
    if (paramj.czq)
    {
      localh.czg.setStyle(Paint.Style.STROKE);
      localh.czg.setStrokeWidth(paramj.strokeWidth);
    }
    for (;;)
    {
      localh.czg.setTextSkewX(0.0F);
      localh.czg.setFakeBoldText(false);
      if (paramj.czr != null)
      {
        if ((paramj.sx == null) || (paramj.sx.getStyle() != paramj.czr.czw))
        {
          if ((paramj.czr == j.a.czu) || (paramj.czr == j.a.czv)) {
            localh.czg.setTextSkewX(-0.25F);
          }
          if ((paramj.czr == j.a.czt) || (paramj.czr == j.a.czv)) {
            localh.czg.setFakeBoldText(true);
          }
        }
        if (paramj.czr.isBold()) {
          localh.czg.setFakeBoldText(true);
        }
      }
      if (localh.czh != null) {
        localh.czh.a(localh.czg, paramj.czp, paramj.fontSize);
      }
      localh.czg.getFontMetrics(localh.czk);
      AppMethodBeat.o(140029);
      return;
      localh.czg.setStyle(Paint.Style.FILL);
    }
  }
  
  final void clear()
  {
    AppMethodBeat.i(140031);
    if (this.cyV != null)
    {
      Iterator localIterator = this.cyV.values().iterator();
      while (localIterator.hasNext())
      {
        k localk = (k)localIterator.next();
        g.a locala = this.cyW;
        if (localk != null)
        {
          localk.setEmpty();
          locala.czb.offer(localk);
        }
      }
      this.cyV.clear();
    }
    AppMethodBeat.o(140031);
  }
  
  final FloatBuffer dG(String paramString)
  {
    AppMethodBeat.i(140022);
    if ((paramString == null) || (paramString.length() == 0))
    {
      AppMethodBeat.o(140022);
      return null;
    }
    List localList = dH(paramString);
    if ((localList == null) || (localList.size() == 0))
    {
      AppMethodBeat.o(140022);
      return null;
    }
    int i = Math.max(paramString.length(), 10) * 40 + 16;
    if ((this.cyX == null) || (this.cyX.capacity() * 4 < i)) {
      this.cyX = ByteBuffer.allocateDirect(i).order(ByteOrder.nativeOrder()).asFloatBuffer();
    }
    this.cyX.clear();
    paramString = this.cyX;
    float f = h.E(localList);
    Paint.FontMetrics localFontMetrics = this.cyU.czk;
    paramString.put(f).put(localFontMetrics.ascent).put(localFontMetrics.bottom).put(localFontMetrics.bottom - localFontMetrics.ascent);
    k.a(paramString, localList);
    paramString.flip();
    this.cyY.clear();
    AppMethodBeat.o(140022);
    return paramString;
  }
  
  final float dI(String paramString)
  {
    AppMethodBeat.i(140030);
    if ((paramString == null) || (paramString.length() == 0))
    {
      AppMethodBeat.o(140030);
      return 0.0F;
    }
    paramString = dH(paramString);
    if ((paramString == null) || (paramString.size() == 0))
    {
      AppMethodBeat.o(140030);
      return -1.0F;
    }
    float f = h.E(paramString);
    AppMethodBeat.o(140030);
    return f;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.magicbrush.handler.glfont.g
 * JD-Core Version:    0.7.0.1
 */