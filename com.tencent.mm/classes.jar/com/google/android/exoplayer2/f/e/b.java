package com.google.android.exoplayer2.f.e;

import android.text.SpannableStringBuilder;
import android.text.style.AbsoluteSizeSpan;
import android.text.style.AlignmentSpan.Standard;
import android.text.style.BackgroundColorSpan;
import android.text.style.ForegroundColorSpan;
import android.text.style.RelativeSizeSpan;
import android.text.style.StrikethroughSpan;
import android.text.style.StyleSpan;
import android.text.style.TypefaceSpan;
import android.text.style.UnderlineSpan;
import com.google.android.exoplayer2.i.a;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.TreeSet;

final class b
{
  private List<b> ayS;
  public final long bgP;
  public final long bgQ;
  public final boolean bmr;
  public final d bms;
  public final String bmt;
  private final String[] bmu;
  private final HashMap<String, Integer> bmv;
  private final HashMap<String, Integer> bmw;
  public final String tag;
  public final String text;
  
  b(String paramString1, String paramString2, long paramLong1, long paramLong2, d paramd, String[] paramArrayOfString, String paramString3)
  {
    AppMethodBeat.i(92848);
    this.tag = paramString1;
    this.text = paramString2;
    this.bms = paramd;
    this.bmu = paramArrayOfString;
    if (paramString2 != null) {}
    for (boolean bool = true;; bool = false)
    {
      this.bmr = bool;
      this.bgP = paramLong1;
      this.bgQ = paramLong2;
      this.bmt = ((String)a.checkNotNull(paramString3));
      this.bmv = new HashMap();
      this.bmw = new HashMap();
      AppMethodBeat.o(92848);
      return;
    }
  }
  
  static SpannableStringBuilder a(SpannableStringBuilder paramSpannableStringBuilder)
  {
    AppMethodBeat.i(92857);
    int i = paramSpannableStringBuilder.length();
    int j = 0;
    int k;
    if (j < i)
    {
      if (paramSpannableStringBuilder.charAt(j) != ' ') {
        break label300;
      }
      k = j + 1;
      while ((k < paramSpannableStringBuilder.length()) && (paramSpannableStringBuilder.charAt(k) == ' ')) {
        k += 1;
      }
      k -= j + 1;
      if (k <= 0) {
        break label300;
      }
      paramSpannableStringBuilder.delete(j, j + k);
      i -= k;
    }
    label300:
    for (;;)
    {
      j += 1;
      break;
      j = i;
      if (i > 0)
      {
        j = i;
        if (paramSpannableStringBuilder.charAt(0) == ' ')
        {
          paramSpannableStringBuilder.delete(0, 1);
          j = i - 1;
        }
      }
      k = 0;
      i = j;
      j = k;
      while (j < i - 1)
      {
        k = i;
        if (paramSpannableStringBuilder.charAt(j) == '\n')
        {
          k = i;
          if (paramSpannableStringBuilder.charAt(j + 1) == ' ')
          {
            paramSpannableStringBuilder.delete(j + 1, j + 2);
            k = i - 1;
          }
        }
        j += 1;
        i = k;
      }
      j = i;
      if (i > 0)
      {
        j = i;
        if (paramSpannableStringBuilder.charAt(i - 1) == ' ')
        {
          paramSpannableStringBuilder.delete(i - 1, i);
          j = i - 1;
        }
      }
      i = 0;
      while (i < j - 1)
      {
        k = j;
        if (paramSpannableStringBuilder.charAt(i) == ' ')
        {
          k = j;
          if (paramSpannableStringBuilder.charAt(i + 1) == '\n')
          {
            paramSpannableStringBuilder.delete(i, i + 1);
            k = j - 1;
          }
        }
        i += 1;
        j = k;
      }
      if ((j > 0) && (paramSpannableStringBuilder.charAt(j - 1) == '\n')) {
        paramSpannableStringBuilder.delete(j - 1, j);
      }
      AppMethodBeat.o(92857);
      return paramSpannableStringBuilder;
    }
  }
  
  private void a(TreeSet<Long> paramTreeSet, boolean paramBoolean)
  {
    AppMethodBeat.i(92853);
    boolean bool2 = "p".equals(this.tag);
    if ((paramBoolean) || (bool2))
    {
      if (this.bgP != -9223372036854775807L) {
        paramTreeSet.add(Long.valueOf(this.bgP));
      }
      if (this.bgQ != -9223372036854775807L) {
        paramTreeSet.add(Long.valueOf(this.bgQ));
      }
    }
    if (this.ayS == null)
    {
      AppMethodBeat.o(92853);
      return;
    }
    int i = 0;
    if (i < this.ayS.size())
    {
      b localb = (b)this.ayS.get(i);
      if ((paramBoolean) || (bool2)) {}
      for (boolean bool1 = true;; bool1 = false)
      {
        localb.a(paramTreeSet, bool1);
        i += 1;
        break;
      }
    }
    AppMethodBeat.o(92853);
  }
  
  private static SpannableStringBuilder c(String paramString, Map<String, SpannableStringBuilder> paramMap)
  {
    AppMethodBeat.i(92855);
    if (!paramMap.containsKey(paramString)) {
      paramMap.put(paramString, new SpannableStringBuilder());
    }
    paramString = (SpannableStringBuilder)paramMap.get(paramString);
    AppMethodBeat.o(92855);
    return paramString;
  }
  
  private b fj(int paramInt)
  {
    AppMethodBeat.i(92850);
    if (this.ayS == null)
    {
      localObject = new IndexOutOfBoundsException();
      AppMethodBeat.o(92850);
      throw ((Throwable)localObject);
    }
    Object localObject = (b)this.ayS.get(paramInt);
    AppMethodBeat.o(92850);
    return localObject;
  }
  
  private int getChildCount()
  {
    AppMethodBeat.i(92851);
    if (this.ayS == null)
    {
      AppMethodBeat.o(92851);
      return 0;
    }
    int i = this.ayS.size();
    AppMethodBeat.o(92851);
    return i;
  }
  
  final void a(long paramLong, boolean paramBoolean, String paramString, Map<String, SpannableStringBuilder> paramMap)
  {
    AppMethodBeat.i(92854);
    this.bmv.clear();
    this.bmw.clear();
    Object localObject2 = this.bmt;
    Object localObject1 = localObject2;
    if ("".equals(localObject2)) {
      localObject1 = paramString;
    }
    if ((this.bmr) && (paramBoolean))
    {
      c((String)localObject1, paramMap).append(this.text);
      AppMethodBeat.o(92854);
      return;
    }
    if (("br".equals(this.tag)) && (paramBoolean))
    {
      c((String)localObject1, paramMap).append('\n');
      AppMethodBeat.o(92854);
      return;
    }
    if (!"metadata".equals(this.tag))
    {
      int i;
      if (((this.bgP == -9223372036854775807L) && (this.bgQ == -9223372036854775807L)) || ((this.bgP <= paramLong) && (this.bgQ == -9223372036854775807L)) || ((this.bgP == -9223372036854775807L) && (paramLong < this.bgQ)) || ((this.bgP <= paramLong) && (paramLong < this.bgQ))) {
        i = 1;
      }
      while (i != 0)
      {
        boolean bool2 = "p".equals(this.tag);
        paramString = paramMap.entrySet().iterator();
        for (;;)
        {
          if (paramString.hasNext())
          {
            localObject2 = (Map.Entry)paramString.next();
            this.bmv.put(((Map.Entry)localObject2).getKey(), Integer.valueOf(((SpannableStringBuilder)((Map.Entry)localObject2).getValue()).length()));
            continue;
            i = 0;
            break;
          }
        }
        i = 0;
        if (i < getChildCount())
        {
          paramString = fj(i);
          if ((paramBoolean) || (bool2)) {}
          for (boolean bool1 = true;; bool1 = false)
          {
            paramString.a(paramLong, bool1, (String)localObject1, paramMap);
            i += 1;
            break;
          }
        }
        if (bool2)
        {
          paramString = c((String)localObject1, paramMap);
          i = paramString.length() - 1;
          while ((i >= 0) && (paramString.charAt(i) == ' ')) {
            i -= 1;
          }
          if ((i >= 0) && (paramString.charAt(i) != '\n')) {
            paramString.append('\n');
          }
        }
        paramString = paramMap.entrySet().iterator();
        while (paramString.hasNext())
        {
          paramMap = (Map.Entry)paramString.next();
          this.bmw.put(paramMap.getKey(), Integer.valueOf(((SpannableStringBuilder)paramMap.getValue()).length()));
        }
      }
    }
    AppMethodBeat.o(92854);
  }
  
  public final void a(b paramb)
  {
    AppMethodBeat.i(92849);
    if (this.ayS == null) {
      this.ayS = new ArrayList();
    }
    this.ayS.add(paramb);
    AppMethodBeat.o(92849);
  }
  
  final void a(Map<String, d> paramMap, Map<String, SpannableStringBuilder> paramMap1)
  {
    AppMethodBeat.i(92856);
    Iterator localIterator = this.bmw.entrySet().iterator();
    if (localIterator.hasNext())
    {
      Object localObject1 = (Map.Entry)localIterator.next();
      Object localObject2 = (String)((Map.Entry)localObject1).getKey();
      int i;
      SpannableStringBuilder localSpannableStringBuilder;
      int k;
      String[] arrayOfString;
      if (this.bmv.containsKey(localObject2))
      {
        i = ((Integer)this.bmv.get(localObject2)).intValue();
        localSpannableStringBuilder = (SpannableStringBuilder)paramMap1.get(localObject2);
        k = ((Integer)((Map.Entry)localObject1).getValue()).intValue();
        if (i == k) {
          break label680;
        }
        localObject2 = this.bms;
        arrayOfString = this.bmu;
        if ((localObject2 != null) || (arrayOfString != null)) {
          break label283;
        }
        localObject1 = null;
        label140:
        if (localObject1 == null) {
          break label680;
        }
        if (((d)localObject1).uv() != -1) {
          localSpannableStringBuilder.setSpan(new StyleSpan(((d)localObject1).uv()), i, k, 33);
        }
        if (((d)localObject1).bmA != 1) {
          break label499;
        }
        j = 1;
        label188:
        if (j != 0) {
          localSpannableStringBuilder.setSpan(new StrikethroughSpan(), i, k, 33);
        }
        if (((d)localObject1).bmB != 1) {
          break label505;
        }
      }
      label283:
      label499:
      label505:
      for (int j = 1;; j = 0)
      {
        if (j != 0) {
          localSpannableStringBuilder.setSpan(new UnderlineSpan(), i, k, 33);
        }
        if (!((d)localObject1).bmy) {
          break label533;
        }
        if (((d)localObject1).bmy) {
          break label511;
        }
        paramMap = new IllegalStateException("Font color has not been defined.");
        AppMethodBeat.o(92856);
        throw paramMap;
        i = 0;
        break;
        if ((localObject2 == null) && (arrayOfString.length == 1))
        {
          localObject1 = (d)paramMap.get(arrayOfString[0]);
          break label140;
        }
        if ((localObject2 == null) && (arrayOfString.length > 1))
        {
          localObject2 = new d();
          m = arrayOfString.length;
          j = 0;
          for (;;)
          {
            localObject1 = localObject2;
            if (j >= m) {
              break;
            }
            ((d)localObject2).b((d)paramMap.get(arrayOfString[j]));
            j += 1;
          }
        }
        if ((localObject2 != null) && (arrayOfString != null) && (arrayOfString.length == 1))
        {
          localObject1 = ((d)localObject2).b((d)paramMap.get(arrayOfString[0]));
          break label140;
        }
        localObject1 = localObject2;
        if (localObject2 == null) {
          break label140;
        }
        localObject1 = localObject2;
        if (arrayOfString == null) {
          break label140;
        }
        localObject1 = localObject2;
        if (arrayOfString.length <= 1) {
          break label140;
        }
        int m = arrayOfString.length;
        j = 0;
        for (;;)
        {
          localObject1 = localObject2;
          if (j >= m) {
            break;
          }
          ((d)localObject2).b((d)paramMap.get(arrayOfString[j]));
          j += 1;
        }
        j = 0;
        break label188;
      }
      label511:
      localSpannableStringBuilder.setSpan(new ForegroundColorSpan(((d)localObject1).bmx), i, k, 33);
      label533:
      if (((d)localObject1).bmz)
      {
        if (!((d)localObject1).bmz)
        {
          paramMap = new IllegalStateException("Background color has not been defined.");
          AppMethodBeat.o(92856);
          throw paramMap;
        }
        localSpannableStringBuilder.setSpan(new BackgroundColorSpan(((d)localObject1).backgroundColor), i, k, 33);
      }
      if (((d)localObject1).fontFamily != null) {
        localSpannableStringBuilder.setSpan(new TypefaceSpan(((d)localObject1).fontFamily), i, k, 33);
      }
      if (((d)localObject1).bmF != null) {
        localSpannableStringBuilder.setSpan(new AlignmentSpan.Standard(((d)localObject1).bmF), i, k, 33);
      }
      switch (((d)localObject1).bmD)
      {
      }
      for (;;)
      {
        label680:
        i = 0;
        while (i < getChildCount())
        {
          fj(i).a(paramMap, paramMap1);
          i += 1;
        }
        localSpannableStringBuilder.setSpan(new AbsoluteSizeSpan((int)((d)localObject1).fontSize, true), i, k, 33);
        continue;
        localSpannableStringBuilder.setSpan(new RelativeSizeSpan(((d)localObject1).fontSize), i, k, 33);
        continue;
        localSpannableStringBuilder.setSpan(new RelativeSizeSpan(((d)localObject1).fontSize / 100.0F), i, k, 33);
      }
    }
    AppMethodBeat.o(92856);
  }
  
  public final long[] uu()
  {
    AppMethodBeat.i(92852);
    Object localObject = new TreeSet();
    a((TreeSet)localObject, false);
    long[] arrayOfLong = new long[((TreeSet)localObject).size()];
    localObject = ((TreeSet)localObject).iterator();
    int i = 0;
    while (((Iterator)localObject).hasNext())
    {
      arrayOfLong[i] = ((Long)((Iterator)localObject).next()).longValue();
      i += 1;
    }
    AppMethodBeat.o(92852);
    return arrayOfLong;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.google.android.exoplayer2.f.e.b
 * JD-Core Version:    0.7.0.1
 */