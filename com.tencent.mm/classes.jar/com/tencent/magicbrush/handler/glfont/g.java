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
  h cNP;
  private HashMap<String, k> cNQ;
  a cNR;
  private FloatBuffer cNS;
  private List<k> cNT;
  private j cNU;
  private StringBuilder cNV;
  
  g(e parame, c paramc)
  {
    AppMethodBeat.i(203734);
    this.cNV = new StringBuilder();
    this.cNP = new h(parame, this);
    this.cNP.cOc = paramc;
    this.cNQ = new HashMap();
    this.cNR = new a();
    this.cNT = new ArrayList();
    AppMethodBeat.o(203734);
  }
  
  private static int C(String paramString, int paramInt)
  {
    AppMethodBeat.i(140026);
    if (a.Vd() == null)
    {
      AppMethodBeat.o(140026);
      return 0;
    }
    paramInt = a.Vd().A(paramString, paramInt);
    AppMethodBeat.o(140026);
    return paramInt;
  }
  
  private List<k> eD(String paramString)
  {
    AppMethodBeat.i(140023);
    if ((paramString == null) || (paramString.length() == 0))
    {
      AppMethodBeat.o(140023);
      return null;
    }
    this.cNT.clear();
    int i = 0;
    while (i < paramString.length())
    {
      int j = C(paramString, i);
      k localk;
      if (j > 0)
      {
        localk = j(paramString, i, j);
        i += j;
      }
      while (localk == null)
      {
        this.cNT.clear();
        AppMethodBeat.o(140023);
        return null;
        localk = x(paramString.charAt(i));
        i += 1;
      }
      this.cNT.add(localk);
    }
    paramString = this.cNT;
    AppMethodBeat.o(140023);
    return paramString;
  }
  
  private k j(String paramString, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(140025);
    String str = k(paramString, paramInt1, paramInt2);
    k localk = (k)this.cNQ.get(str);
    if (localk != null)
    {
      AppMethodBeat.o(140025);
      return localk;
    }
    if (a.Vd() == null)
    {
      paramString = new IllegalStateException("FontDrawableProvider must support");
      AppMethodBeat.o(140025);
      throw paramString;
    }
    paramString = a.Vd().B(paramString, paramInt1);
    if (paramString == null)
    {
      AppMethodBeat.o(140025);
      return null;
    }
    paramInt1 = (int)this.cNU.fontSize;
    int i = (int)this.cNU.fontSize;
    if ((paramInt1 <= 0) || (i <= 0))
    {
      AppMethodBeat.o(140025);
      return null;
    }
    paramString = this.cNP.a(paramString, paramInt1, i);
    if (paramString == null)
    {
      c.c.d("MagicBrush.MBFontGlyphManager", "Load font drawable glyph failed.", new Object[0]);
      AppMethodBeat.o(140025);
      return null;
    }
    paramString.cOB = paramInt2;
    this.cNQ.put(str, paramString);
    AppMethodBeat.o(140025);
    return paramString;
  }
  
  private String k(String paramString, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(140027);
    if (paramInt2 <= 0)
    {
      paramString = new IllegalStateException("There is no font drawable");
      AppMethodBeat.o(140027);
      throw paramString;
    }
    this.cNV.setLength(0);
    while (paramInt2 > 0)
    {
      this.cNV.append(paramString.charAt(paramInt1));
      paramInt1 += 1;
      paramInt2 -= 1;
    }
    this.cNV.append("|").append(this.cNU.fontSize);
    paramString = this.cNV.toString();
    AppMethodBeat.o(140027);
    return paramString;
  }
  
  private k x(char paramChar)
  {
    AppMethodBeat.i(140024);
    if (this.cNU == null)
    {
      AppMethodBeat.o(140024);
      return null;
    }
    String str = y(paramChar);
    k localk = (k)this.cNQ.get(str);
    if (localk != null)
    {
      AppMethodBeat.o(140024);
      return localk;
    }
    localk = this.cNP.z(paramChar);
    if (localk == null)
    {
      c.c.d("MagicBrush.MBFontGlyphManager", "Load glyph failed. glyph == null [" + paramChar + "]", new Object[0]);
      AppMethodBeat.o(140024);
      return null;
    }
    this.cNQ.put(str, localk);
    AppMethodBeat.o(140024);
    return localk;
  }
  
  private String y(char paramChar)
  {
    AppMethodBeat.i(140028);
    if (this.cNU == null)
    {
      AppMethodBeat.o(140028);
      return null;
    }
    this.cNV.setLength(0);
    StringBuilder localStringBuilder = this.cNV.append(paramChar).append("|").append(this.cNU.fontSize).append("|");
    if (this.cNU.bGp == null) {}
    for (Object localObject = "null";; localObject = Integer.valueOf(this.cNU.bGp.hashCode()))
    {
      localObject = localStringBuilder.append(localObject);
      if (this.cNU.cOl) {
        ((StringBuilder)localObject).append("|").append(this.cNU.strokeWidth);
      }
      if (this.cNU.cOm != null) {
        ((StringBuilder)localObject).append("|").append(this.cNU.cOm.cOr);
      }
      localObject = ((StringBuilder)localObject).toString();
      AppMethodBeat.o(140028);
      return localObject;
    }
  }
  
  final void a(j paramj)
  {
    AppMethodBeat.i(140029);
    this.cNU = paramj;
    h localh = this.cNP;
    localh.cOa = paramj;
    localh.cOb.setTypeface(paramj.bGp);
    localh.cOb.setTextSize(paramj.fontSize);
    if (paramj.cOl)
    {
      localh.cOb.setStyle(Paint.Style.STROKE);
      localh.cOb.setStrokeWidth(paramj.strokeWidth);
    }
    for (;;)
    {
      localh.cOb.setTextSkewX(0.0F);
      localh.cOb.setFakeBoldText(false);
      if (paramj.cOm != null)
      {
        if ((paramj.bGp == null) || (paramj.bGp.getStyle() != paramj.cOm.cOr))
        {
          if ((paramj.cOm == j.a.cOp) || (paramj.cOm == j.a.cOq)) {
            localh.cOb.setTextSkewX(-0.25F);
          }
          if ((paramj.cOm == j.a.cOo) || (paramj.cOm == j.a.cOq)) {
            localh.cOb.setFakeBoldText(true);
          }
        }
        if (paramj.cOm.Vl()) {
          localh.cOb.setFakeBoldText(true);
        }
      }
      if (localh.cOc != null) {
        localh.cOc.a(localh.cOb, paramj.cOk, paramj.fontSize);
      }
      localh.cOb.getFontMetrics(localh.cOf);
      AppMethodBeat.o(140029);
      return;
      localh.cOb.setStyle(Paint.Style.FILL);
    }
  }
  
  final void clear()
  {
    AppMethodBeat.i(140031);
    if (this.cNQ != null)
    {
      Iterator localIterator = this.cNQ.values().iterator();
      while (localIterator.hasNext())
      {
        k localk = (k)localIterator.next();
        a locala = this.cNR;
        if (localk != null)
        {
          localk.Vn();
          locala.cNW.offer(localk);
        }
      }
      this.cNQ.clear();
    }
    AppMethodBeat.o(140031);
  }
  
  final FloatBuffer eC(String paramString)
  {
    AppMethodBeat.i(140022);
    if ((paramString == null) || (paramString.length() == 0))
    {
      AppMethodBeat.o(140022);
      return null;
    }
    List localList = eD(paramString);
    if ((localList == null) || (localList.size() == 0))
    {
      AppMethodBeat.o(140022);
      return null;
    }
    int i = Math.max(paramString.length(), 10) * 40 + 16;
    if ((this.cNS == null) || (this.cNS.capacity() * 4 < i)) {
      this.cNS = ByteBuffer.allocateDirect(i).order(ByteOrder.nativeOrder()).asFloatBuffer();
    }
    this.cNS.clear();
    paramString = this.cNS;
    float f = h.F(localList);
    Paint.FontMetrics localFontMetrics = this.cNP.cOf;
    paramString.put(f).put(localFontMetrics.ascent).put(localFontMetrics.bottom).put(localFontMetrics.bottom - localFontMetrics.ascent);
    k.a(paramString, localList);
    paramString.flip();
    this.cNT.clear();
    AppMethodBeat.o(140022);
    return paramString;
  }
  
  final float eE(String paramString)
  {
    AppMethodBeat.i(140030);
    if ((paramString == null) || (paramString.length() == 0))
    {
      AppMethodBeat.o(140030);
      return 0.0F;
    }
    paramString = eD(paramString);
    if ((paramString == null) || (paramString.size() == 0))
    {
      AppMethodBeat.o(140030);
      return -1.0F;
    }
    float f = h.F(paramString);
    AppMethodBeat.o(140030);
    return f;
  }
  
  static final class a
  {
    Queue<k> cNW;
    
    a()
    {
      AppMethodBeat.i(140019);
      this.cNW = new LinkedList();
      AppMethodBeat.o(140019);
    }
    
    final k Vj()
    {
      AppMethodBeat.i(140020);
      k localk = (k)this.cNW.poll();
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