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
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

@SuppressLint({"LongLogTag"})
final class g
{
  h cyn;
  private HashMap<String, k> cyo;
  a cyp;
  private FloatBuffer cyq;
  private List<k> cyr;
  private j cys;
  private StringBuilder cyt;
  
  g(e parame, c paramc)
  {
    AppMethodBeat.i(215083);
    this.cyt = new StringBuilder();
    this.cyn = new h(parame, this);
    this.cyn.cyA = paramc;
    this.cyo = new HashMap();
    this.cyp = new a();
    this.cyr = new ArrayList();
    AppMethodBeat.o(215083);
  }
  
  private List<k> dE(String paramString)
  {
    AppMethodBeat.i(140023);
    if ((paramString == null) || (paramString.length() == 0))
    {
      AppMethodBeat.o(140023);
      return null;
    }
    this.cyr.clear();
    int i = 0;
    while (i < paramString.length())
    {
      int j = r(paramString, i);
      k localk;
      if (j > 0)
      {
        localk = i(paramString, i, j);
        i += j;
      }
      while (localk == null)
      {
        this.cyr.clear();
        AppMethodBeat.o(140023);
        return null;
        localk = s(paramString.charAt(i));
        i += 1;
      }
      this.cyr.add(localk);
    }
    paramString = this.cyr;
    AppMethodBeat.o(140023);
    return paramString;
  }
  
  private k i(String paramString, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(140025);
    String str = j(paramString, paramInt1, paramInt2);
    k localk = (k)this.cyo.get(str);
    if (localk != null)
    {
      AppMethodBeat.o(140025);
      return localk;
    }
    if (a.Hw() == null)
    {
      paramString = new IllegalStateException("FontDrawableProvider must support");
      AppMethodBeat.o(140025);
      throw paramString;
    }
    paramString = a.Hw().q(paramString, paramInt1);
    if (paramString == null)
    {
      AppMethodBeat.o(140025);
      return null;
    }
    paramInt1 = (int)this.cys.fontSize;
    int i = (int)this.cys.fontSize;
    if ((paramInt1 <= 0) || (i <= 0))
    {
      AppMethodBeat.o(140025);
      return null;
    }
    paramString = this.cyn.a(paramString, paramInt1, i);
    if (paramString == null)
    {
      c.c.d("MagicBrush.MBFontGlyphManager", "Load font drawable glyph failed.", new Object[0]);
      AppMethodBeat.o(140025);
      return null;
    }
    paramString.cyZ = paramInt2;
    this.cyo.put(str, paramString);
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
    this.cyt.setLength(0);
    while (paramInt2 > 0)
    {
      this.cyt.append(paramString.charAt(paramInt1));
      paramInt1 += 1;
      paramInt2 -= 1;
    }
    this.cyt.append("|").append(this.cys.fontSize);
    paramString = this.cyt.toString();
    AppMethodBeat.o(140027);
    return paramString;
  }
  
  private static int r(String paramString, int paramInt)
  {
    AppMethodBeat.i(140026);
    if (a.Hw() == null)
    {
      AppMethodBeat.o(140026);
      return 0;
    }
    paramInt = a.Hw().p(paramString, paramInt);
    AppMethodBeat.o(140026);
    return paramInt;
  }
  
  private k s(char paramChar)
  {
    AppMethodBeat.i(140024);
    if (this.cys == null)
    {
      AppMethodBeat.o(140024);
      return null;
    }
    String str = t(paramChar);
    k localk = (k)this.cyo.get(str);
    if (localk != null)
    {
      AppMethodBeat.o(140024);
      return localk;
    }
    localk = this.cyn.u(paramChar);
    if (localk == null)
    {
      c.c.d("MagicBrush.MBFontGlyphManager", "Load glyph failed. glyph == null [" + paramChar + "]", new Object[0]);
      AppMethodBeat.o(140024);
      return null;
    }
    this.cyo.put(str, localk);
    AppMethodBeat.o(140024);
    return localk;
  }
  
  private String t(char paramChar)
  {
    AppMethodBeat.i(140028);
    if (this.cys == null)
    {
      AppMethodBeat.o(140028);
      return null;
    }
    this.cyt.setLength(0);
    StringBuilder localStringBuilder = this.cyt.append(paramChar).append("|").append(this.cys.fontSize).append("|");
    if (this.cys.sx == null) {}
    for (Object localObject = "null";; localObject = Integer.valueOf(this.cys.sx.hashCode()))
    {
      localObject = localStringBuilder.append(localObject);
      if (this.cys.cyJ) {
        ((StringBuilder)localObject).append("|").append(this.cys.strokeWidth);
      }
      if (this.cys.cyK != null) {
        ((StringBuilder)localObject).append("|").append(this.cys.cyK.cyP);
      }
      localObject = ((StringBuilder)localObject).toString();
      AppMethodBeat.o(140028);
      return localObject;
    }
  }
  
  final void a(j paramj)
  {
    AppMethodBeat.i(140029);
    this.cys = paramj;
    h localh = this.cyn;
    localh.cyy = paramj;
    localh.cyz.setTypeface(paramj.sx);
    localh.cyz.setTextSize(paramj.fontSize);
    if (paramj.cyJ)
    {
      localh.cyz.setStyle(Paint.Style.STROKE);
      localh.cyz.setStrokeWidth(paramj.strokeWidth);
    }
    for (;;)
    {
      localh.cyz.setTextSkewX(0.0F);
      localh.cyz.setFakeBoldText(false);
      if (paramj.cyK != null)
      {
        if ((paramj.sx == null) || (paramj.sx.getStyle() != paramj.cyK.cyP))
        {
          if ((paramj.cyK == j.a.cyN) || (paramj.cyK == j.a.cyO)) {
            localh.cyz.setTextSkewX(-0.25F);
          }
          if ((paramj.cyK == j.a.cyM) || (paramj.cyK == j.a.cyO)) {
            localh.cyz.setFakeBoldText(true);
          }
        }
        if (paramj.cyK.isBold()) {
          localh.cyz.setFakeBoldText(true);
        }
      }
      localh.cyz.getFontMetrics(localh.cyD);
      if (localh.cyA != null) {
        localh.cyA.a(localh.cyz, paramj.cyI, paramj.fontSize);
      }
      AppMethodBeat.o(140029);
      return;
      localh.cyz.setStyle(Paint.Style.FILL);
    }
  }
  
  final void clear()
  {
    AppMethodBeat.i(140031);
    if (this.cyo != null)
    {
      Iterator localIterator = this.cyo.values().iterator();
      while (localIterator.hasNext())
      {
        k localk = (k)localIterator.next();
        a locala = this.cyp;
        if (localk != null)
        {
          localk.setEmpty();
          locala.cyu.offer(localk);
        }
      }
      this.cyo.clear();
    }
    AppMethodBeat.o(140031);
  }
  
  final FloatBuffer dD(String paramString)
  {
    AppMethodBeat.i(140022);
    if ((paramString == null) || (paramString.length() == 0))
    {
      AppMethodBeat.o(140022);
      return null;
    }
    List localList = dE(paramString);
    if ((localList == null) || (localList.size() == 0))
    {
      AppMethodBeat.o(140022);
      return null;
    }
    int i = Math.max(paramString.length(), 10) * 40 + 16;
    if ((this.cyq == null) || (this.cyq.capacity() * 4 < i)) {
      this.cyq = ByteBuffer.allocateDirect(i).order(ByteOrder.nativeOrder()).asFloatBuffer();
    }
    this.cyq.clear();
    paramString = this.cyq;
    float f = h.E(localList);
    Paint.FontMetrics localFontMetrics = this.cyn.cyD;
    paramString.put(f).put(localFontMetrics.ascent).put(localFontMetrics.descent).put(localFontMetrics.descent - localFontMetrics.ascent);
    k.a(paramString, localList);
    paramString.flip();
    this.cyr.clear();
    AppMethodBeat.o(140022);
    return paramString;
  }
  
  final float dF(String paramString)
  {
    AppMethodBeat.i(140030);
    if ((paramString == null) || (paramString.length() == 0))
    {
      AppMethodBeat.o(140030);
      return 0.0F;
    }
    paramString = dE(paramString);
    if ((paramString == null) || (paramString.size() == 0))
    {
      AppMethodBeat.o(140030);
      return -1.0F;
    }
    float f = h.E(paramString);
    AppMethodBeat.o(140030);
    return f;
  }
  
  static final class a
  {
    Queue<k> cyu;
    
    a()
    {
      AppMethodBeat.i(140019);
      this.cyu = new LinkedList();
      AppMethodBeat.o(140019);
    }
    
    final k HC()
    {
      AppMethodBeat.i(140020);
      k localk = (k)this.cyu.poll();
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.magicbrush.handler.glfont.g
 * JD-Core Version:    0.7.0.1
 */