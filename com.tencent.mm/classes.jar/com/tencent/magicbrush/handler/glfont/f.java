package com.tencent.magicbrush.handler.glfont;

import android.annotation.SuppressLint;
import android.graphics.Paint;
import android.graphics.Paint.FontMetrics;
import android.graphics.Paint.Style;
import android.graphics.Typeface;
import com.tencent.magicbrush.a.a;
import com.tencent.magicbrush.a.a.a;
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
final class f
{
  g bJP;
  private HashMap<String, j> bJQ;
  f.a bJR;
  private FloatBuffer bJS;
  private List<j> bJT;
  private i bJU;
  private StringBuilder bJV;
  
  f(d paramd)
  {
    AppMethodBeat.i(115920);
    this.bJV = new StringBuilder();
    this.bJP = new g(paramd, this);
    this.bJQ = new HashMap();
    this.bJR = new f.a();
    this.bJT = new ArrayList();
    AppMethodBeat.o(115920);
  }
  
  private List<j> cs(String paramString)
  {
    AppMethodBeat.i(115922);
    if ((paramString == null) || (paramString.length() == 0))
    {
      AppMethodBeat.o(115922);
      return null;
    }
    this.bJT.clear();
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
        this.bJT.clear();
        AppMethodBeat.o(115922);
        return null;
        localj = p(paramString.charAt(i));
        i += 1;
      }
      this.bJT.add(localj);
    }
    paramString = this.bJT;
    AppMethodBeat.o(115922);
    return paramString;
  }
  
  private j g(String paramString, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(115924);
    String str = h(paramString, paramInt1, paramInt2);
    j localj = (j)this.bJQ.get(str);
    if (localj != null)
    {
      AppMethodBeat.o(115924);
      return localj;
    }
    if (a.yp() == null)
    {
      paramString = new IllegalStateException("FontDrawableProvider must support");
      AppMethodBeat.o(115924);
      throw paramString;
    }
    paramString = a.yp().o(paramString, paramInt1);
    if (paramString == null)
    {
      paramString = j.bKr;
      AppMethodBeat.o(115924);
      return paramString;
    }
    paramInt1 = (int)this.bJU.fontSize;
    paramInt2 = (int)this.bJU.fontSize;
    if ((paramInt1 <= 0) || (paramInt2 <= 0))
    {
      paramString = j.bKr;
      AppMethodBeat.o(115924);
      return paramString;
    }
    paramString = this.bJP.a(paramString, paramInt1, paramInt2);
    if (paramString == null)
    {
      AppMethodBeat.o(115924);
      return null;
    }
    this.bJQ.put(str, paramString);
    AppMethodBeat.o(115924);
    return paramString;
  }
  
  private String h(String paramString, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(115926);
    if (paramInt2 <= 0)
    {
      paramString = new IllegalStateException("There is no font drawable");
      AppMethodBeat.o(115926);
      throw paramString;
    }
    this.bJV.setLength(0);
    while (paramInt2 > 0)
    {
      this.bJV.append(paramString.charAt(paramInt1));
      paramInt1 += 1;
      paramInt2 -= 1;
    }
    this.bJV.append("|").append(this.bJU.fontSize);
    paramString = this.bJV.toString();
    AppMethodBeat.o(115926);
    return paramString;
  }
  
  private static int p(String paramString, int paramInt)
  {
    AppMethodBeat.i(115925);
    if (a.yp() == null)
    {
      AppMethodBeat.o(115925);
      return 0;
    }
    paramInt = a.yp().n(paramString, paramInt);
    AppMethodBeat.o(115925);
    return paramInt;
  }
  
  private j p(char paramChar)
  {
    AppMethodBeat.i(115923);
    if (this.bJU == null)
    {
      AppMethodBeat.o(115923);
      return null;
    }
    String str = q(paramChar);
    j localj = (j)this.bJQ.get(str);
    if (localj != null)
    {
      AppMethodBeat.o(115923);
      return localj;
    }
    localj = this.bJP.r(paramChar);
    if (localj == null)
    {
      new StringBuilder("Load glyph failed. glyph == null [").append(paramChar).append("]");
      AppMethodBeat.o(115923);
      return null;
    }
    this.bJQ.put(str, localj);
    AppMethodBeat.o(115923);
    return localj;
  }
  
  private String q(char paramChar)
  {
    AppMethodBeat.i(115927);
    if (this.bJU == null)
    {
      AppMethodBeat.o(115927);
      return null;
    }
    this.bJV.setLength(0);
    StringBuilder localStringBuilder = this.bJV.append(paramChar).append("|").append(this.bJU.fontSize).append("|");
    if (this.bJU.bKi == null) {}
    for (Object localObject = "null";; localObject = Integer.valueOf(this.bJU.bKi.hashCode()))
    {
      localObject = localStringBuilder.append(localObject);
      if (this.bJU.bKj) {
        ((StringBuilder)localObject).append("|").append(this.bJU.strokeWidth);
      }
      if (this.bJU.bKk != null) {
        ((StringBuilder)localObject).append("|").append(this.bJU.bKk.bKp);
      }
      localObject = ((StringBuilder)localObject).toString();
      AppMethodBeat.o(115927);
      return localObject;
    }
  }
  
  final void a(i parami)
  {
    int i = 0;
    AppMethodBeat.i(115928);
    this.bJU = parami;
    g localg = this.bJP;
    localg.bKa.setTypeface(parami.bKi);
    localg.bKa.setTextSize(parami.fontSize);
    if (parami.bKj)
    {
      localg.bKa.setStyle(Paint.Style.STROKE);
      localg.bKa.setStrokeWidth(parami.strokeWidth);
    }
    for (;;)
    {
      localg.bKa.setTextSkewX(0.0F);
      localg.bKa.setFakeBoldText(false);
      if (parami.bKk != null)
      {
        if ((parami.bKi == null) || (parami.bKi.getStyle() != parami.bKk.bKp))
        {
          if ((parami.bKk == i.a.bKn) || (parami.bKk == i.a.bKo)) {
            localg.bKa.setTextSkewX(-0.25F);
          }
          if ((parami.bKk == i.a.bKm) || (parami.bKk == i.a.bKo)) {
            localg.bKa.setFakeBoldText(true);
          }
        }
        parami = parami.bKk;
        if ((parami == i.a.bKm) || (parami == i.a.bKo)) {
          i = 1;
        }
        if (i != 0) {
          localg.bKa.setFakeBoldText(true);
        }
      }
      localg.bKa.getFontMetrics(localg.bKe);
      AppMethodBeat.o(115928);
      return;
      localg.bKa.setStyle(Paint.Style.FILL);
    }
  }
  
  final void clear()
  {
    AppMethodBeat.i(115930);
    if (this.bJQ != null)
    {
      Iterator localIterator = this.bJQ.values().iterator();
      while (localIterator.hasNext())
      {
        j localj = (j)localIterator.next();
        this.bJR.bJW.offer(localj);
      }
      this.bJQ.clear();
    }
    AppMethodBeat.o(115930);
  }
  
  final FloatBuffer cr(String paramString)
  {
    AppMethodBeat.i(115921);
    if ((paramString == null) || (paramString.length() == 0))
    {
      AppMethodBeat.o(115921);
      return null;
    }
    List localList = cs(paramString);
    if ((localList == null) || (localList.size() == 0))
    {
      AppMethodBeat.o(115921);
      return null;
    }
    int i = Math.max(paramString.length(), 10) * 36 + 16;
    if ((this.bJS == null) || (this.bJS.capacity() * 4 < i)) {
      this.bJS = ByteBuffer.allocateDirect(i).order(ByteOrder.nativeOrder()).asFloatBuffer();
    }
    this.bJS.clear();
    paramString = this.bJS;
    float f = g.C(localList);
    Paint.FontMetrics localFontMetrics = this.bJP.bKe;
    paramString.put(f).put(localFontMetrics.ascent).put(localFontMetrics.descent).put(localFontMetrics.descent - localFontMetrics.ascent);
    j.a(paramString, localList);
    paramString.flip();
    this.bJT.clear();
    AppMethodBeat.o(115921);
    return paramString;
  }
  
  final float ct(String paramString)
  {
    AppMethodBeat.i(115929);
    if ((paramString == null) || (paramString.length() == 0))
    {
      AppMethodBeat.o(115929);
      return 0.0F;
    }
    paramString = cs(paramString);
    if ((paramString == null) || (paramString.size() == 0))
    {
      AppMethodBeat.o(115929);
      return -1.0F;
    }
    float f = g.C(paramString);
    AppMethodBeat.o(115929);
    return f;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.magicbrush.handler.glfont.f
 * JD-Core Version:    0.7.0.1
 */