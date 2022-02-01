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
final class f
{
  private HashMap<String, j> cqA;
  a cqB;
  private FloatBuffer cqC;
  private List<j> cqD;
  private i cqE;
  private StringBuilder cqF;
  g cqz;
  
  f(d paramd)
  {
    AppMethodBeat.i(140021);
    this.cqF = new StringBuilder();
    this.cqz = new g(paramd, this);
    this.cqA = new HashMap();
    this.cqB = new a();
    this.cqD = new ArrayList();
    AppMethodBeat.o(140021);
  }
  
  private List<j> cM(String paramString)
  {
    AppMethodBeat.i(140023);
    if ((paramString == null) || (paramString.length() == 0))
    {
      AppMethodBeat.o(140023);
      return null;
    }
    this.cqD.clear();
    int i = 0;
    while (i < paramString.length())
    {
      int j = p(paramString, i);
      j localj;
      if (j > 0)
      {
        localj = g(paramString, i, j);
        i += j;
      }
      while (localj == null)
      {
        this.cqD.clear();
        AppMethodBeat.o(140023);
        return null;
        localj = q(paramString.charAt(i));
        i += 1;
      }
      this.cqD.add(localj);
    }
    paramString = this.cqD;
    AppMethodBeat.o(140023);
    return paramString;
  }
  
  private j g(String paramString, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(140025);
    String str = h(paramString, paramInt1, paramInt2);
    j localj = (j)this.cqA.get(str);
    if (localj != null)
    {
      AppMethodBeat.o(140025);
      return localj;
    }
    if (a.Gp() == null)
    {
      paramString = new IllegalStateException("FontDrawableProvider must support");
      AppMethodBeat.o(140025);
      throw paramString;
    }
    paramString = a.Gp().o(paramString, paramInt1);
    if (paramString == null)
    {
      AppMethodBeat.o(140025);
      return null;
    }
    paramInt1 = (int)this.cqE.buK;
    int i = (int)this.cqE.buK;
    if ((paramInt1 <= 0) || (i <= 0))
    {
      AppMethodBeat.o(140025);
      return null;
    }
    paramString = this.cqz.a(paramString, paramInt1, i);
    if (paramString == null)
    {
      c.c.d("MagicBrush.MBFontGlyphManager", "Load font drawable glyph failed.", new Object[0]);
      AppMethodBeat.o(140025);
      return null;
    }
    paramString.crj = paramInt2;
    this.cqA.put(str, paramString);
    AppMethodBeat.o(140025);
    return paramString;
  }
  
  private String h(String paramString, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(140027);
    if (paramInt2 <= 0)
    {
      paramString = new IllegalStateException("There is no font drawable");
      AppMethodBeat.o(140027);
      throw paramString;
    }
    this.cqF.setLength(0);
    while (paramInt2 > 0)
    {
      this.cqF.append(paramString.charAt(paramInt1));
      paramInt1 += 1;
      paramInt2 -= 1;
    }
    this.cqF.append("|").append(this.cqE.buK);
    paramString = this.cqF.toString();
    AppMethodBeat.o(140027);
    return paramString;
  }
  
  private static int p(String paramString, int paramInt)
  {
    AppMethodBeat.i(140026);
    if (a.Gp() == null)
    {
      AppMethodBeat.o(140026);
      return 0;
    }
    paramInt = a.Gp().n(paramString, paramInt);
    AppMethodBeat.o(140026);
    return paramInt;
  }
  
  private j q(char paramChar)
  {
    AppMethodBeat.i(140024);
    if (this.cqE == null)
    {
      AppMethodBeat.o(140024);
      return null;
    }
    String str = r(paramChar);
    j localj = (j)this.cqA.get(str);
    if (localj != null)
    {
      AppMethodBeat.o(140024);
      return localj;
    }
    localj = this.cqz.s(paramChar);
    if (localj == null)
    {
      c.c.d("MagicBrush.MBFontGlyphManager", "Load glyph failed. glyph == null [" + paramChar + "]", new Object[0]);
      AppMethodBeat.o(140024);
      return null;
    }
    this.cqA.put(str, localj);
    AppMethodBeat.o(140024);
    return localj;
  }
  
  private String r(char paramChar)
  {
    AppMethodBeat.i(140028);
    if (this.cqE == null)
    {
      AppMethodBeat.o(140028);
      return null;
    }
    this.cqF.setLength(0);
    StringBuilder localStringBuilder = this.cqF.append(paramChar).append("|").append(this.cqE.buK).append("|");
    if (this.cqE.pC == null) {}
    for (Object localObject = "null";; localObject = Integer.valueOf(this.cqE.pC.hashCode()))
    {
      localObject = localStringBuilder.append(localObject);
      if (this.cqE.cqS) {
        ((StringBuilder)localObject).append("|").append(this.cqE.strokeWidth);
      }
      if (this.cqE.cqT != null) {
        ((StringBuilder)localObject).append("|").append(this.cqE.cqT.cqY);
      }
      localObject = ((StringBuilder)localObject).toString();
      AppMethodBeat.o(140028);
      return localObject;
    }
  }
  
  final void a(i parami)
  {
    AppMethodBeat.i(140029);
    this.cqE = parami;
    g localg = this.cqz;
    localg.cqK = parami;
    localg.cqL.setTypeface(parami.pC);
    localg.cqL.setTextSize(parami.buK);
    if (parami.cqS)
    {
      localg.cqL.setStyle(Paint.Style.STROKE);
      localg.cqL.setStrokeWidth(parami.strokeWidth);
    }
    for (;;)
    {
      localg.cqL.setTextSkewX(0.0F);
      localg.cqL.setFakeBoldText(false);
      if (parami.cqT != null)
      {
        if ((parami.pC == null) || (parami.pC.getStyle() != parami.cqT.cqY))
        {
          if ((parami.cqT == i.a.cqW) || (parami.cqT == i.a.cqX)) {
            localg.cqL.setTextSkewX(-0.25F);
          }
          if ((parami.cqT == i.a.cqV) || (parami.cqT == i.a.cqX)) {
            localg.cqL.setFakeBoldText(true);
          }
        }
        if (parami.cqT.isBold()) {
          localg.cqL.setFakeBoldText(true);
        }
      }
      localg.cqL.getFontMetrics(localg.cqO);
      AppMethodBeat.o(140029);
      return;
      localg.cqL.setStyle(Paint.Style.FILL);
    }
  }
  
  final FloatBuffer cL(String paramString)
  {
    AppMethodBeat.i(140022);
    if ((paramString == null) || (paramString.length() == 0))
    {
      AppMethodBeat.o(140022);
      return null;
    }
    List localList = cM(paramString);
    if ((localList == null) || (localList.size() == 0))
    {
      AppMethodBeat.o(140022);
      return null;
    }
    int i = Math.max(paramString.length(), 10) * 40 + 16;
    if ((this.cqC == null) || (this.cqC.capacity() * 4 < i)) {
      this.cqC = ByteBuffer.allocateDirect(i).order(ByteOrder.nativeOrder()).asFloatBuffer();
    }
    this.cqC.clear();
    paramString = this.cqC;
    float f = g.N(localList);
    Paint.FontMetrics localFontMetrics = this.cqz.cqO;
    paramString.put(f).put(localFontMetrics.ascent).put(localFontMetrics.descent).put(localFontMetrics.descent - localFontMetrics.ascent);
    j.a(paramString, localList);
    paramString.flip();
    this.cqD.clear();
    AppMethodBeat.o(140022);
    return paramString;
  }
  
  final float cN(String paramString)
  {
    AppMethodBeat.i(140030);
    if ((paramString == null) || (paramString.length() == 0))
    {
      AppMethodBeat.o(140030);
      return 0.0F;
    }
    paramString = cM(paramString);
    if ((paramString == null) || (paramString.size() == 0))
    {
      AppMethodBeat.o(140030);
      return -1.0F;
    }
    float f = g.N(paramString);
    AppMethodBeat.o(140030);
    return f;
  }
  
  final void clear()
  {
    AppMethodBeat.i(140031);
    if (this.cqA != null)
    {
      Iterator localIterator = this.cqA.values().iterator();
      while (localIterator.hasNext())
      {
        j localj = (j)localIterator.next();
        a locala = this.cqB;
        if (localj != null)
        {
          localj.setEmpty();
          locala.cqG.offer(localj);
        }
      }
      this.cqA.clear();
    }
    AppMethodBeat.o(140031);
  }
  
  static final class a
  {
    Queue<j> cqG;
    
    a()
    {
      AppMethodBeat.i(140019);
      this.cqG = new LinkedList();
      AppMethodBeat.o(140019);
    }
    
    final j Gv()
    {
      AppMethodBeat.i(140020);
      j localj = (j)this.cqG.poll();
      if (localj == null)
      {
        localj = new j();
        AppMethodBeat.o(140020);
        return localj;
      }
      AppMethodBeat.o(140020);
      return localj;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.magicbrush.handler.glfont.f
 * JD-Core Version:    0.7.0.1
 */