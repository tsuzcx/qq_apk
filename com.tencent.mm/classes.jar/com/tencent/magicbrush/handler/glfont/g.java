package com.tencent.magicbrush.handler.glfont;

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
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

final class g
{
  h eJk;
  private HashMap<String, k> eJl;
  a eJm;
  private FloatBuffer eJn;
  private List<k> eJo;
  private j eJp;
  private StringBuilder eJq;
  
  g(e parame, c paramc)
  {
    AppMethodBeat.i(228989);
    this.eJq = new StringBuilder();
    this.eJk = new h(parame, this);
    this.eJk.eJx = paramc;
    this.eJl = new HashMap();
    this.eJm = new a();
    this.eJo = new ArrayList();
    AppMethodBeat.o(228989);
  }
  
  private static int K(String paramString, int paramInt)
  {
    AppMethodBeat.i(140026);
    if (a.avG() == null)
    {
      AppMethodBeat.o(140026);
      return 0;
    }
    paramInt = a.avG().I(paramString, paramInt);
    AppMethodBeat.o(140026);
    return paramInt;
  }
  
  private List<k> ga(String paramString)
  {
    AppMethodBeat.i(140023);
    if ((paramString == null) || (paramString.length() == 0))
    {
      AppMethodBeat.o(140023);
      return null;
    }
    this.eJo.clear();
    int i = 0;
    while (i < paramString.length())
    {
      int j = K(paramString, i);
      k localk;
      if (j > 0)
      {
        localk = m(paramString, i, j);
        i += j;
      }
      while (localk == null)
      {
        this.eJo.clear();
        AppMethodBeat.o(140023);
        return null;
        localk = o(paramString.charAt(i));
        i += 1;
      }
      this.eJo.add(localk);
    }
    paramString = this.eJo;
    AppMethodBeat.o(140023);
    return paramString;
  }
  
  private k m(String paramString, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(140025);
    String str = n(paramString, paramInt1, paramInt2);
    k localk = (k)this.eJl.get(str);
    if (localk != null)
    {
      AppMethodBeat.o(140025);
      return localk;
    }
    if (a.avG() == null)
    {
      paramString = new IllegalStateException("FontDrawableProvider must support");
      AppMethodBeat.o(140025);
      throw paramString;
    }
    paramString = a.avG().J(paramString, paramInt1);
    if (paramString == null)
    {
      AppMethodBeat.o(140025);
      return null;
    }
    paramInt1 = (int)this.eJp.fontSize;
    int i = (int)this.eJp.fontSize;
    if ((paramInt1 <= 0) || (i <= 0))
    {
      AppMethodBeat.o(140025);
      return null;
    }
    paramString = this.eJk.a(paramString, paramInt1, i);
    if (paramString == null)
    {
      c.c.d("MagicBrush.MBFontGlyphManager", "Load font drawable glyph failed.", new Object[0]);
      AppMethodBeat.o(140025);
      return null;
    }
    paramString.eJW = paramInt2;
    this.eJl.put(str, paramString);
    AppMethodBeat.o(140025);
    return paramString;
  }
  
  private String n(String paramString, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(140027);
    if (paramInt2 <= 0)
    {
      paramString = new IllegalStateException("There is no font drawable");
      AppMethodBeat.o(140027);
      throw paramString;
    }
    this.eJq.setLength(0);
    while (paramInt2 > 0)
    {
      this.eJq.append(paramString.charAt(paramInt1));
      paramInt1 += 1;
      paramInt2 -= 1;
    }
    this.eJq.append("|").append(this.eJp.fontSize);
    paramString = this.eJq.toString();
    AppMethodBeat.o(140027);
    return paramString;
  }
  
  private k o(char paramChar)
  {
    AppMethodBeat.i(140024);
    if (this.eJp == null)
    {
      AppMethodBeat.o(140024);
      return null;
    }
    String str = p(paramChar);
    k localk = (k)this.eJl.get(str);
    if (localk != null)
    {
      AppMethodBeat.o(140024);
      return localk;
    }
    localk = this.eJk.q(paramChar);
    if (localk == null)
    {
      c.c.d("MagicBrush.MBFontGlyphManager", "Load glyph failed. glyph == null [" + paramChar + "]", new Object[0]);
      AppMethodBeat.o(140024);
      return null;
    }
    this.eJl.put(str, localk);
    AppMethodBeat.o(140024);
    return localk;
  }
  
  private String p(char paramChar)
  {
    AppMethodBeat.i(140028);
    if (this.eJp == null)
    {
      AppMethodBeat.o(140028);
      return null;
    }
    this.eJq.setLength(0);
    StringBuilder localStringBuilder = this.eJq.append(paramChar).append("|").append(this.eJp.fontSize).append("|");
    if (this.eJp.bbO == null) {}
    for (Object localObject = "null";; localObject = Integer.valueOf(this.eJp.bbO.hashCode()))
    {
      localObject = localStringBuilder.append(localObject);
      if (this.eJp.eJG) {
        ((StringBuilder)localObject).append("|").append(this.eJp.strokeWidth);
      }
      if (this.eJp.eJH != null) {
        ((StringBuilder)localObject).append("|").append(this.eJp.eJH.eJM);
      }
      localObject = ((StringBuilder)localObject).toString();
      AppMethodBeat.o(140028);
      return localObject;
    }
  }
  
  final void a(j paramj)
  {
    AppMethodBeat.i(140029);
    this.eJp = paramj;
    h localh = this.eJk;
    localh.eJv = paramj;
    localh.eJw.setTypeface(paramj.bbO);
    localh.eJw.setTextSize(paramj.fontSize);
    if (paramj.eJG)
    {
      localh.eJw.setStyle(Paint.Style.STROKE);
      localh.eJw.setStrokeWidth(paramj.strokeWidth);
    }
    for (;;)
    {
      localh.eJw.setTextSkewX(0.0F);
      localh.eJw.setFakeBoldText(false);
      if (paramj.eJH != null)
      {
        if ((paramj.bbO == null) || (paramj.bbO.getStyle() != paramj.eJH.eJM))
        {
          if ((paramj.eJH == j.a.eJK) || (paramj.eJH == j.a.eJL)) {
            localh.eJw.setTextSkewX(-0.25F);
          }
          if ((paramj.eJH == j.a.eJJ) || (paramj.eJH == j.a.eJL)) {
            localh.eJw.setFakeBoldText(true);
          }
        }
        if (paramj.eJH.avO()) {
          localh.eJw.setFakeBoldText(true);
        }
      }
      if (localh.eJx != null) {
        localh.eJx.updateFontStyle(localh.eJw, paramj.bbO, paramj.eJF, paramj.fontSize, paramj.eJG, paramj.strokeWidth, paramj.eJH.avO(), paramj.eJH.avP());
      }
      localh.eJw.getFontMetrics(localh.eJA);
      AppMethodBeat.o(140029);
      return;
      localh.eJw.setStyle(Paint.Style.FILL);
    }
  }
  
  final void clear()
  {
    AppMethodBeat.i(140031);
    if (this.eJl != null)
    {
      Iterator localIterator = this.eJl.values().iterator();
      while (localIterator.hasNext())
      {
        k localk = (k)localIterator.next();
        a locala = this.eJm;
        if (localk != null)
        {
          localk.avQ();
          locala.eJr.offer(localk);
        }
      }
      this.eJl.clear();
    }
    AppMethodBeat.o(140031);
  }
  
  final FloatBuffer fZ(String paramString)
  {
    AppMethodBeat.i(140022);
    if ((paramString == null) || (paramString.length() == 0))
    {
      AppMethodBeat.o(140022);
      return null;
    }
    List localList = ga(paramString);
    if ((localList == null) || (localList.size() == 0))
    {
      AppMethodBeat.o(140022);
      return null;
    }
    int i = Math.max(paramString.length(), 10) * 40 + 16;
    if ((this.eJn == null) || (this.eJn.capacity() * 4 < i)) {
      this.eJn = ByteBuffer.allocateDirect(i).order(ByteOrder.nativeOrder()).asFloatBuffer();
    }
    this.eJn.clear();
    paramString = this.eJn;
    float f = h.bd(localList);
    Paint.FontMetrics localFontMetrics = this.eJk.eJA;
    paramString.put(f).put(localFontMetrics.ascent).put(localFontMetrics.bottom).put(localFontMetrics.bottom - localFontMetrics.ascent);
    k.a(paramString, localList);
    paramString.flip();
    this.eJo.clear();
    AppMethodBeat.o(140022);
    return paramString;
  }
  
  final float gb(String paramString)
  {
    AppMethodBeat.i(140030);
    if ((paramString == null) || (paramString.length() == 0))
    {
      AppMethodBeat.o(140030);
      return 0.0F;
    }
    paramString = ga(paramString);
    if ((paramString == null) || (paramString.size() == 0))
    {
      AppMethodBeat.o(140030);
      return -1.0F;
    }
    float f = h.bd(paramString);
    AppMethodBeat.o(140030);
    return f;
  }
  
  static final class a
  {
    Queue<k> eJr;
    
    a()
    {
      AppMethodBeat.i(140019);
      this.eJr = new LinkedList();
      AppMethodBeat.o(140019);
    }
    
    final k avM()
    {
      AppMethodBeat.i(140020);
      k localk = (k)this.eJr.poll();
      if (localk == null)
      {
        localk = new k();
        AppMethodBeat.o(140020);
        return localk;
      }
      AppMethodBeat.o(140020);
      return localk;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.magicbrush.handler.glfont.g
 * JD-Core Version:    0.7.0.1
 */