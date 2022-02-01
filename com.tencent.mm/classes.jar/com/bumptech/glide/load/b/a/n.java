package com.bumptech.glide.load.b.a;

import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.os.Build.VERSION;
import com.bumptech.glide.g.k;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.NavigableMap;
import java.util.Set;
import java.util.TreeMap;

public final class n
  implements l
{
  private static final Bitmap.Config[] aII;
  private static final Bitmap.Config[] aIJ;
  private static final Bitmap.Config[] aIK;
  private static final Bitmap.Config[] aIL;
  private static final Bitmap.Config[] aIM;
  private final b aIN;
  private final h<a, Bitmap> aIk;
  private final Map<Bitmap.Config, NavigableMap<Integer, Integer>> aIu;
  
  static
  {
    AppMethodBeat.i(77143);
    Bitmap.Config[] arrayOfConfig2 = new Bitmap.Config[2];
    arrayOfConfig2[0] = Bitmap.Config.ARGB_8888;
    arrayOfConfig2[1] = null;
    Bitmap.Config[] arrayOfConfig1 = arrayOfConfig2;
    if (Build.VERSION.SDK_INT >= 26)
    {
      arrayOfConfig1 = (Bitmap.Config[])Arrays.copyOf(arrayOfConfig2, 3);
      arrayOfConfig1[(arrayOfConfig1.length - 1)] = Bitmap.Config.RGBA_F16;
    }
    aII = arrayOfConfig1;
    aIJ = arrayOfConfig1;
    aIK = new Bitmap.Config[] { Bitmap.Config.RGB_565 };
    aIL = new Bitmap.Config[] { Bitmap.Config.ARGB_4444 };
    aIM = new Bitmap.Config[] { Bitmap.Config.ALPHA_8 };
    AppMethodBeat.o(77143);
  }
  
  public n()
  {
    AppMethodBeat.i(77132);
    this.aIN = new b();
    this.aIk = new h();
    this.aIu = new HashMap();
    AppMethodBeat.o(77132);
  }
  
  static String a(int paramInt, Bitmap.Config paramConfig)
  {
    AppMethodBeat.i(77142);
    paramConfig = "[" + paramInt + "](" + paramConfig + ")";
    AppMethodBeat.o(77142);
    return paramConfig;
  }
  
  private void a(Integer paramInteger, Bitmap paramBitmap)
  {
    AppMethodBeat.i(77136);
    NavigableMap localNavigableMap = b(paramBitmap.getConfig());
    Integer localInteger = (Integer)localNavigableMap.get(paramInteger);
    if (localInteger == null)
    {
      paramInteger = new NullPointerException("Tried to decrement empty size, size: " + paramInteger + ", removed: " + h(paramBitmap) + ", this: " + this);
      AppMethodBeat.o(77136);
      throw paramInteger;
    }
    if (localInteger.intValue() == 1)
    {
      localNavigableMap.remove(paramInteger);
      AppMethodBeat.o(77136);
      return;
    }
    localNavigableMap.put(paramInteger, Integer.valueOf(localInteger.intValue() - 1));
    AppMethodBeat.o(77136);
  }
  
  private NavigableMap<Integer, Integer> b(Bitmap.Config paramConfig)
  {
    AppMethodBeat.i(77137);
    NavigableMap localNavigableMap = (NavigableMap)this.aIu.get(paramConfig);
    Object localObject = localNavigableMap;
    if (localNavigableMap == null)
    {
      localObject = new TreeMap();
      this.aIu.put(paramConfig, localObject);
    }
    AppMethodBeat.o(77137);
    return localObject;
  }
  
  public final Bitmap b(int paramInt1, int paramInt2, Bitmap.Config paramConfig)
  {
    int i = 0;
    AppMethodBeat.i(77134);
    int j = k.i(paramInt1, paramInt2, paramConfig);
    Object localObject2 = this.aIN.c(j, paramConfig);
    Object localObject1;
    int k;
    if ((Build.VERSION.SDK_INT >= 26) && (Bitmap.Config.RGBA_F16.equals(paramConfig)))
    {
      localObject1 = aIJ;
      k = localObject1.length;
    }
    for (;;)
    {
      Bitmap.Config localConfig;
      Integer localInteger;
      if (i < k)
      {
        localConfig = localObject1[i];
        localInteger = (Integer)b(localConfig).ceilingKey(Integer.valueOf(j));
        if ((localInteger == null) || (localInteger.intValue() > j * 8)) {
          break label301;
        }
        if (localInteger.intValue() == j)
        {
          if (localConfig == null) {
            if (paramConfig == null) {
              break label294;
            }
          }
        }
        else {
          label128:
          this.aIN.a((m)localObject2);
        }
      }
      label294:
      for (localObject1 = this.aIN.c(localInteger.intValue(), localConfig);; localObject1 = localObject2)
      {
        localObject2 = (Bitmap)this.aIk.b((m)localObject1);
        if (localObject2 != null)
        {
          a(Integer.valueOf(((a)localObject1).size), (Bitmap)localObject2);
          ((Bitmap)localObject2).reconfigure(paramInt1, paramInt2, paramConfig);
        }
        AppMethodBeat.o(77134);
        return localObject2;
        switch (1.$SwitchMap$android$graphics$Bitmap$Config[paramConfig.ordinal()])
        {
        default: 
          localObject1 = new Bitmap.Config[] { paramConfig };
          break;
        case 1: 
          localObject1 = aII;
          break;
        case 2: 
          localObject1 = aIK;
          break;
        case 3: 
          localObject1 = aIL;
          break;
        case 4: 
          localObject1 = aIM;
          break;
          if (!localConfig.equals(paramConfig)) {
            break label128;
          }
        }
      }
      label301:
      i += 1;
    }
  }
  
  public final String c(int paramInt1, int paramInt2, Bitmap.Config paramConfig)
  {
    AppMethodBeat.i(77139);
    paramConfig = a(k.i(paramInt1, paramInt2, paramConfig), paramConfig);
    AppMethodBeat.o(77139);
    return paramConfig;
  }
  
  public final void g(Bitmap paramBitmap)
  {
    AppMethodBeat.i(77133);
    int i = k.k(paramBitmap);
    a locala = this.aIN.c(i, paramBitmap.getConfig());
    this.aIk.a(locala, paramBitmap);
    paramBitmap = b(paramBitmap.getConfig());
    Integer localInteger = (Integer)paramBitmap.get(Integer.valueOf(locala.size));
    int j = locala.size;
    if (localInteger == null) {}
    for (i = 1;; i = localInteger.intValue() + 1)
    {
      paramBitmap.put(Integer.valueOf(j), Integer.valueOf(i));
      AppMethodBeat.o(77133);
      return;
    }
  }
  
  public final String h(Bitmap paramBitmap)
  {
    AppMethodBeat.i(77138);
    paramBitmap = a(k.k(paramBitmap), paramBitmap.getConfig());
    AppMethodBeat.o(77138);
    return paramBitmap;
  }
  
  public final int i(Bitmap paramBitmap)
  {
    AppMethodBeat.i(77140);
    int i = k.k(paramBitmap);
    AppMethodBeat.o(77140);
    return i;
  }
  
  public final Bitmap pa()
  {
    AppMethodBeat.i(77135);
    Bitmap localBitmap = (Bitmap)this.aIk.removeLast();
    if (localBitmap != null) {
      a(Integer.valueOf(k.k(localBitmap)), localBitmap);
    }
    AppMethodBeat.o(77135);
    return localBitmap;
  }
  
  public final String toString()
  {
    AppMethodBeat.i(77141);
    Object localObject = new StringBuilder("SizeConfigStrategy{groupedMap=").append(this.aIk).append(", sortedSizes=(");
    Iterator localIterator = this.aIu.entrySet().iterator();
    while (localIterator.hasNext())
    {
      Map.Entry localEntry = (Map.Entry)localIterator.next();
      ((StringBuilder)localObject).append(localEntry.getKey()).append('[').append(localEntry.getValue()).append("], ");
    }
    if (!this.aIu.isEmpty()) {
      ((StringBuilder)localObject).replace(((StringBuilder)localObject).length() - 2, ((StringBuilder)localObject).length(), "");
    }
    localObject = ")}";
    AppMethodBeat.o(77141);
    return localObject;
  }
  
  static final class a
    implements m
  {
    private final n.b aIO;
    private Bitmap.Config aIm;
    int size;
    
    public a(n.b paramb)
    {
      this.aIO = paramb;
    }
    
    public final void b(int paramInt, Bitmap.Config paramConfig)
    {
      this.size = paramInt;
      this.aIm = paramConfig;
    }
    
    public final boolean equals(Object paramObject)
    {
      AppMethodBeat.i(77128);
      if ((paramObject instanceof a))
      {
        paramObject = (a)paramObject;
        if ((this.size == paramObject.size) && (k.h(this.aIm, paramObject.aIm)))
        {
          AppMethodBeat.o(77128);
          return true;
        }
        AppMethodBeat.o(77128);
        return false;
      }
      AppMethodBeat.o(77128);
      return false;
    }
    
    public final int hashCode()
    {
      AppMethodBeat.i(77129);
      int j = this.size;
      if (this.aIm != null) {}
      for (int i = this.aIm.hashCode();; i = 0)
      {
        AppMethodBeat.o(77129);
        return i + j * 31;
      }
    }
    
    public final void pb()
    {
      AppMethodBeat.i(77126);
      this.aIO.a(this);
      AppMethodBeat.o(77126);
    }
    
    public final String toString()
    {
      AppMethodBeat.i(77127);
      String str = n.a(this.size, this.aIm);
      AppMethodBeat.o(77127);
      return str;
    }
  }
  
  static final class b
    extends d<n.a>
  {
    public final n.a c(int paramInt, Bitmap.Config paramConfig)
    {
      AppMethodBeat.i(77130);
      n.a locala = (n.a)pd();
      locala.b(paramInt, paramConfig);
      AppMethodBeat.o(77130);
      return locala;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.bumptech.glide.load.b.a.n
 * JD-Core Version:    0.7.0.1
 */