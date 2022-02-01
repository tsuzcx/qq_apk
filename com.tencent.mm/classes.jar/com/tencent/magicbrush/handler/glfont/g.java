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
  h cNb;
  private HashMap<String, k> cNc;
  a cNd;
  private FloatBuffer cNe;
  private List<k> cNf;
  private j cNg;
  private StringBuilder cNh;
  
  g(e parame, c paramc)
  {
    AppMethodBeat.i(206812);
    this.cNh = new StringBuilder();
    this.cNb = new h(parame, this);
    this.cNb.cNo = paramc;
    this.cNc = new HashMap();
    this.cNd = new a();
    this.cNf = new ArrayList();
    AppMethodBeat.o(206812);
  }
  
  private List<k> ec(String paramString)
  {
    AppMethodBeat.i(140023);
    if ((paramString == null) || (paramString.length() == 0))
    {
      AppMethodBeat.o(140023);
      return null;
    }
    this.cNf.clear();
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
        this.cNf.clear();
        AppMethodBeat.o(140023);
        return null;
        localk = s(paramString.charAt(i));
        i += 1;
      }
      this.cNf.add(localk);
    }
    paramString = this.cNf;
    AppMethodBeat.o(140023);
    return paramString;
  }
  
  private k i(String paramString, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(140025);
    String str = j(paramString, paramInt1, paramInt2);
    k localk = (k)this.cNc.get(str);
    if (localk != null)
    {
      AppMethodBeat.o(140025);
      return localk;
    }
    if (a.Rt() == null)
    {
      paramString = new IllegalStateException("FontDrawableProvider must support");
      AppMethodBeat.o(140025);
      throw paramString;
    }
    paramString = a.Rt().r(paramString, paramInt1);
    if (paramString == null)
    {
      AppMethodBeat.o(140025);
      return null;
    }
    paramInt1 = (int)this.cNg.fontSize;
    int i = (int)this.cNg.fontSize;
    if ((paramInt1 <= 0) || (i <= 0))
    {
      AppMethodBeat.o(140025);
      return null;
    }
    paramString = this.cNb.a(paramString, paramInt1, i);
    if (paramString == null)
    {
      c.c.d("MagicBrush.MBFontGlyphManager", "Load font drawable glyph failed.", new Object[0]);
      AppMethodBeat.o(140025);
      return null;
    }
    paramString.cNN = paramInt2;
    this.cNc.put(str, paramString);
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
    this.cNh.setLength(0);
    while (paramInt2 > 0)
    {
      this.cNh.append(paramString.charAt(paramInt1));
      paramInt1 += 1;
      paramInt2 -= 1;
    }
    this.cNh.append("|").append(this.cNg.fontSize);
    paramString = this.cNh.toString();
    AppMethodBeat.o(140027);
    return paramString;
  }
  
  private static int s(String paramString, int paramInt)
  {
    AppMethodBeat.i(140026);
    if (a.Rt() == null)
    {
      AppMethodBeat.o(140026);
      return 0;
    }
    paramInt = a.Rt().q(paramString, paramInt);
    AppMethodBeat.o(140026);
    return paramInt;
  }
  
  private k s(char paramChar)
  {
    AppMethodBeat.i(140024);
    if (this.cNg == null)
    {
      AppMethodBeat.o(140024);
      return null;
    }
    String str = t(paramChar);
    k localk = (k)this.cNc.get(str);
    if (localk != null)
    {
      AppMethodBeat.o(140024);
      return localk;
    }
    localk = this.cNb.u(paramChar);
    if (localk == null)
    {
      c.c.d("MagicBrush.MBFontGlyphManager", "Load glyph failed. glyph == null [" + paramChar + "]", new Object[0]);
      AppMethodBeat.o(140024);
      return null;
    }
    this.cNc.put(str, localk);
    AppMethodBeat.o(140024);
    return localk;
  }
  
  private String t(char paramChar)
  {
    AppMethodBeat.i(140028);
    if (this.cNg == null)
    {
      AppMethodBeat.o(140028);
      return null;
    }
    this.cNh.setLength(0);
    StringBuilder localStringBuilder = this.cNh.append(paramChar).append("|").append(this.cNg.fontSize).append("|");
    if (this.cNg.sB == null) {}
    for (Object localObject = "null";; localObject = Integer.valueOf(this.cNg.sB.hashCode()))
    {
      localObject = localStringBuilder.append(localObject);
      if (this.cNg.cNx) {
        ((StringBuilder)localObject).append("|").append(this.cNg.strokeWidth);
      }
      if (this.cNg.cNy != null) {
        ((StringBuilder)localObject).append("|").append(this.cNg.cNy.cND);
      }
      localObject = ((StringBuilder)localObject).toString();
      AppMethodBeat.o(140028);
      return localObject;
    }
  }
  
  final void a(j paramj)
  {
    AppMethodBeat.i(140029);
    this.cNg = paramj;
    h localh = this.cNb;
    localh.cNm = paramj;
    localh.cNn.setTypeface(paramj.sB);
    localh.cNn.setTextSize(paramj.fontSize);
    if (paramj.cNx)
    {
      localh.cNn.setStyle(Paint.Style.STROKE);
      localh.cNn.setStrokeWidth(paramj.strokeWidth);
    }
    for (;;)
    {
      localh.cNn.setTextSkewX(0.0F);
      localh.cNn.setFakeBoldText(false);
      if (paramj.cNy != null)
      {
        if ((paramj.sB == null) || (paramj.sB.getStyle() != paramj.cNy.cND))
        {
          if ((paramj.cNy == j.a.cNB) || (paramj.cNy == j.a.cNC)) {
            localh.cNn.setTextSkewX(-0.25F);
          }
          if ((paramj.cNy == j.a.cNA) || (paramj.cNy == j.a.cNC)) {
            localh.cNn.setFakeBoldText(true);
          }
        }
        if (paramj.cNy.isBold()) {
          localh.cNn.setFakeBoldText(true);
        }
      }
      if (localh.cNo != null) {
        localh.cNo.a(localh.cNn, paramj.cNw, paramj.fontSize);
      }
      localh.cNn.getFontMetrics(localh.cNr);
      AppMethodBeat.o(140029);
      return;
      localh.cNn.setStyle(Paint.Style.FILL);
    }
  }
  
  final void clear()
  {
    AppMethodBeat.i(140031);
    if (this.cNc != null)
    {
      Iterator localIterator = this.cNc.values().iterator();
      while (localIterator.hasNext())
      {
        k localk = (k)localIterator.next();
        a locala = this.cNd;
        if (localk != null)
        {
          localk.setEmpty();
          locala.cNi.offer(localk);
        }
      }
      this.cNc.clear();
    }
    AppMethodBeat.o(140031);
  }
  
  final FloatBuffer eb(String paramString)
  {
    AppMethodBeat.i(140022);
    if ((paramString == null) || (paramString.length() == 0))
    {
      AppMethodBeat.o(140022);
      return null;
    }
    List localList = ec(paramString);
    if ((localList == null) || (localList.size() == 0))
    {
      AppMethodBeat.o(140022);
      return null;
    }
    int i = Math.max(paramString.length(), 10) * 40 + 16;
    if ((this.cNe == null) || (this.cNe.capacity() * 4 < i)) {
      this.cNe = ByteBuffer.allocateDirect(i).order(ByteOrder.nativeOrder()).asFloatBuffer();
    }
    this.cNe.clear();
    paramString = this.cNe;
    float f = h.I(localList);
    Paint.FontMetrics localFontMetrics = this.cNb.cNr;
    paramString.put(f).put(localFontMetrics.ascent).put(localFontMetrics.bottom).put(localFontMetrics.bottom - localFontMetrics.ascent);
    k.a(paramString, localList);
    paramString.flip();
    this.cNf.clear();
    AppMethodBeat.o(140022);
    return paramString;
  }
  
  final float ed(String paramString)
  {
    AppMethodBeat.i(140030);
    if ((paramString == null) || (paramString.length() == 0))
    {
      AppMethodBeat.o(140030);
      return 0.0F;
    }
    paramString = ec(paramString);
    if ((paramString == null) || (paramString.size() == 0))
    {
      AppMethodBeat.o(140030);
      return -1.0F;
    }
    float f = h.I(paramString);
    AppMethodBeat.o(140030);
    return f;
  }
  
  static final class a
  {
    Queue<k> cNi;
    
    a()
    {
      AppMethodBeat.i(140019);
      this.cNi = new LinkedList();
      AppMethodBeat.o(140019);
    }
    
    final k Rz()
    {
      AppMethodBeat.i(140020);
      k localk = (k)this.cNi.poll();
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