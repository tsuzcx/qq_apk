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
  g cnG;
  private HashMap<String, j> cnH;
  a cnI;
  private FloatBuffer cnJ;
  private List<j> cnK;
  private i cnL;
  private StringBuilder cnM;
  
  f(d paramd)
  {
    AppMethodBeat.i(140021);
    this.cnM = new StringBuilder();
    this.cnG = new g(paramd, this);
    this.cnH = new HashMap();
    this.cnI = new a();
    this.cnK = new ArrayList();
    AppMethodBeat.o(140021);
  }
  
  private List<j> cB(String paramString)
  {
    AppMethodBeat.i(140023);
    if ((paramString == null) || (paramString.length() == 0))
    {
      AppMethodBeat.o(140023);
      return null;
    }
    this.cnK.clear();
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
        this.cnK.clear();
        AppMethodBeat.o(140023);
        return null;
        localj = q(paramString.charAt(i));
        i += 1;
      }
      this.cnK.add(localj);
    }
    paramString = this.cnK;
    AppMethodBeat.o(140023);
    return paramString;
  }
  
  private j g(String paramString, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(140025);
    String str = h(paramString, paramInt1, paramInt2);
    j localj = (j)this.cnH.get(str);
    if (localj != null)
    {
      AppMethodBeat.o(140025);
      return localj;
    }
    if (a.Gb() == null)
    {
      paramString = new IllegalStateException("FontDrawableProvider must support");
      AppMethodBeat.o(140025);
      throw paramString;
    }
    paramString = a.Gb().o(paramString, paramInt1);
    if (paramString == null)
    {
      AppMethodBeat.o(140025);
      return null;
    }
    paramInt1 = (int)this.cnL.bsJ;
    int i = (int)this.cnL.bsJ;
    if ((paramInt1 <= 0) || (i <= 0))
    {
      AppMethodBeat.o(140025);
      return null;
    }
    paramString = this.cnG.a(paramString, paramInt1, i);
    if (paramString == null)
    {
      c.c.d("MagicBrush.MBFontGlyphManager", "Load font drawable glyph failed.", new Object[0]);
      AppMethodBeat.o(140025);
      return null;
    }
    paramString.cop = paramInt2;
    this.cnH.put(str, paramString);
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
    this.cnM.setLength(0);
    while (paramInt2 > 0)
    {
      this.cnM.append(paramString.charAt(paramInt1));
      paramInt1 += 1;
      paramInt2 -= 1;
    }
    this.cnM.append("|").append(this.cnL.bsJ);
    paramString = this.cnM.toString();
    AppMethodBeat.o(140027);
    return paramString;
  }
  
  private static int p(String paramString, int paramInt)
  {
    AppMethodBeat.i(140026);
    if (a.Gb() == null)
    {
      AppMethodBeat.o(140026);
      return 0;
    }
    paramInt = a.Gb().n(paramString, paramInt);
    AppMethodBeat.o(140026);
    return paramInt;
  }
  
  private j q(char paramChar)
  {
    AppMethodBeat.i(140024);
    if (this.cnL == null)
    {
      AppMethodBeat.o(140024);
      return null;
    }
    String str = r(paramChar);
    j localj = (j)this.cnH.get(str);
    if (localj != null)
    {
      AppMethodBeat.o(140024);
      return localj;
    }
    localj = this.cnG.s(paramChar);
    if (localj == null)
    {
      c.c.d("MagicBrush.MBFontGlyphManager", "Load glyph failed. glyph == null [" + paramChar + "]", new Object[0]);
      AppMethodBeat.o(140024);
      return null;
    }
    this.cnH.put(str, localj);
    AppMethodBeat.o(140024);
    return localj;
  }
  
  private String r(char paramChar)
  {
    AppMethodBeat.i(140028);
    if (this.cnL == null)
    {
      AppMethodBeat.o(140028);
      return null;
    }
    this.cnM.setLength(0);
    StringBuilder localStringBuilder = this.cnM.append(paramChar).append("|").append(this.cnL.bsJ).append("|");
    if (this.cnL.qC == null) {}
    for (Object localObject = "null";; localObject = Integer.valueOf(this.cnL.qC.hashCode()))
    {
      localObject = localStringBuilder.append(localObject);
      if (this.cnL.cnZ) {
        ((StringBuilder)localObject).append("|").append(this.cnL.strokeWidth);
      }
      if (this.cnL.coa != null) {
        ((StringBuilder)localObject).append("|").append(this.cnL.coa.cof);
      }
      localObject = ((StringBuilder)localObject).toString();
      AppMethodBeat.o(140028);
      return localObject;
    }
  }
  
  final void a(i parami)
  {
    AppMethodBeat.i(140029);
    this.cnL = parami;
    g localg = this.cnG;
    localg.cnR = parami;
    localg.cnS.setTypeface(parami.qC);
    localg.cnS.setTextSize(parami.bsJ);
    if (parami.cnZ)
    {
      localg.cnS.setStyle(Paint.Style.STROKE);
      localg.cnS.setStrokeWidth(parami.strokeWidth);
    }
    for (;;)
    {
      localg.cnS.setTextSkewX(0.0F);
      localg.cnS.setFakeBoldText(false);
      if (parami.coa != null)
      {
        if ((parami.qC == null) || (parami.qC.getStyle() != parami.coa.cof))
        {
          if ((parami.coa == i.a.cod) || (parami.coa == i.a.coe)) {
            localg.cnS.setTextSkewX(-0.25F);
          }
          if ((parami.coa == i.a.coc) || (parami.coa == i.a.coe)) {
            localg.cnS.setFakeBoldText(true);
          }
        }
        if (parami.coa.isBold()) {
          localg.cnS.setFakeBoldText(true);
        }
      }
      localg.cnS.getFontMetrics(localg.cnV);
      AppMethodBeat.o(140029);
      return;
      localg.cnS.setStyle(Paint.Style.FILL);
    }
  }
  
  final FloatBuffer cA(String paramString)
  {
    AppMethodBeat.i(140022);
    if ((paramString == null) || (paramString.length() == 0))
    {
      AppMethodBeat.o(140022);
      return null;
    }
    List localList = cB(paramString);
    if ((localList == null) || (localList.size() == 0))
    {
      AppMethodBeat.o(140022);
      return null;
    }
    int i = Math.max(paramString.length(), 10) * 40 + 16;
    if ((this.cnJ == null) || (this.cnJ.capacity() * 4 < i)) {
      this.cnJ = ByteBuffer.allocateDirect(i).order(ByteOrder.nativeOrder()).asFloatBuffer();
    }
    this.cnJ.clear();
    paramString = this.cnJ;
    float f = g.E(localList);
    Paint.FontMetrics localFontMetrics = this.cnG.cnV;
    paramString.put(f).put(localFontMetrics.ascent).put(localFontMetrics.descent).put(localFontMetrics.descent - localFontMetrics.ascent);
    j.a(paramString, localList);
    paramString.flip();
    this.cnK.clear();
    AppMethodBeat.o(140022);
    return paramString;
  }
  
  final float cC(String paramString)
  {
    AppMethodBeat.i(140030);
    if ((paramString == null) || (paramString.length() == 0))
    {
      AppMethodBeat.o(140030);
      return 0.0F;
    }
    paramString = cB(paramString);
    if ((paramString == null) || (paramString.size() == 0))
    {
      AppMethodBeat.o(140030);
      return -1.0F;
    }
    float f = g.E(paramString);
    AppMethodBeat.o(140030);
    return f;
  }
  
  final void clear()
  {
    AppMethodBeat.i(140031);
    if (this.cnH != null)
    {
      Iterator localIterator = this.cnH.values().iterator();
      while (localIterator.hasNext())
      {
        j localj = (j)localIterator.next();
        a locala = this.cnI;
        if (localj != null)
        {
          localj.setEmpty();
          locala.cnN.offer(localj);
        }
      }
      this.cnH.clear();
    }
    AppMethodBeat.o(140031);
  }
  
  static final class a
  {
    Queue<j> cnN;
    
    a()
    {
      AppMethodBeat.i(140019);
      this.cnN = new LinkedList();
      AppMethodBeat.o(140019);
    }
    
    final j Gh()
    {
      AppMethodBeat.i(140020);
      j localj = (j)this.cnN.poll();
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.magicbrush.handler.glfont.f
 * JD-Core Version:    0.7.0.1
 */