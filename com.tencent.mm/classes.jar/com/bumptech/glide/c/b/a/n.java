package com.bumptech.glide.c.b.a;

import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.os.Build.VERSION;
import com.bumptech.glide.h.j;
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
  private static final Bitmap.Config[] aIP;
  private static final Bitmap.Config[] aIQ;
  private static final Bitmap.Config[] aIR;
  private static final Bitmap.Config[] aIS;
  private static final Bitmap.Config[] aIT;
  private final Map<Bitmap.Config, NavigableMap<Integer, Integer>> aIB;
  private final b aIU;
  private final h<a, Bitmap> aIq;
  
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
    aIP = arrayOfConfig1;
    aIQ = arrayOfConfig1;
    aIR = new Bitmap.Config[] { Bitmap.Config.RGB_565 };
    aIS = new Bitmap.Config[] { Bitmap.Config.ARGB_4444 };
    aIT = new Bitmap.Config[] { Bitmap.Config.ALPHA_8 };
    AppMethodBeat.o(77143);
  }
  
  public n()
  {
    AppMethodBeat.i(77132);
    this.aIU = new b();
    this.aIq = new h();
    this.aIB = new HashMap();
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
    NavigableMap localNavigableMap = (NavigableMap)this.aIB.get(paramConfig);
    Object localObject = localNavigableMap;
    if (localNavigableMap == null)
    {
      localObject = new TreeMap();
      this.aIB.put(paramConfig, localObject);
    }
    AppMethodBeat.o(77137);
    return localObject;
  }
  
  public final Bitmap b(int paramInt1, int paramInt2, Bitmap.Config paramConfig)
  {
    int i = 0;
    AppMethodBeat.i(77134);
    int j = j.i(paramInt1, paramInt2, paramConfig);
    a locala = this.aIU.c(j, paramConfig);
    Object localObject;
    label56:
    Bitmap.Config localConfig;
    if ((Build.VERSION.SDK_INT >= 26) && (Bitmap.Config.RGBA_F16.equals(paramConfig)))
    {
      localObject = aIQ;
      int k = localObject.length;
      if (i >= k) {
        break label306;
      }
      localConfig = localObject[i];
      Integer localInteger = (Integer)b(localConfig).ceilingKey(Integer.valueOf(j));
      if ((localInteger == null) || (localInteger.intValue() > j * 8)) {
        break label312;
      }
      if (localInteger.intValue() == j)
      {
        if (localConfig != null) {
          break label297;
        }
        if (paramConfig == null) {
          break label306;
        }
      }
      label128:
      this.aIU.a(locala);
      paramConfig = this.aIU.c(localInteger.intValue(), localConfig);
      label152:
      localObject = (Bitmap)this.aIq.b(paramConfig);
      if (localObject != null)
      {
        a(Integer.valueOf(paramConfig.size), (Bitmap)localObject);
        if (((Bitmap)localObject).getConfig() == null) {
          break label321;
        }
      }
    }
    label297:
    label306:
    label312:
    label321:
    for (paramConfig = ((Bitmap)localObject).getConfig();; paramConfig = Bitmap.Config.ARGB_8888)
    {
      ((Bitmap)localObject).reconfigure(paramInt1, paramInt2, paramConfig);
      AppMethodBeat.o(77134);
      return localObject;
      switch (1.$SwitchMap$android$graphics$Bitmap$Config[paramConfig.ordinal()])
      {
      default: 
        localObject = new Bitmap.Config[] { paramConfig };
        break;
      case 1: 
        localObject = aIP;
        break;
      case 2: 
        localObject = aIR;
        break;
      case 3: 
        localObject = aIS;
        break;
      case 4: 
        localObject = aIT;
        break;
        if (!localConfig.equals(paramConfig)) {
          break label128;
        }
        paramConfig = locala;
        break label152;
        i += 1;
        break label56;
      }
    }
  }
  
  public final String c(int paramInt1, int paramInt2, Bitmap.Config paramConfig)
  {
    AppMethodBeat.i(77139);
    paramConfig = a(j.i(paramInt1, paramInt2, paramConfig), paramConfig);
    AppMethodBeat.o(77139);
    return paramConfig;
  }
  
  public final void g(Bitmap paramBitmap)
  {
    AppMethodBeat.i(77133);
    int i = j.k(paramBitmap);
    a locala = this.aIU.c(i, paramBitmap.getConfig());
    this.aIq.a(locala, paramBitmap);
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
    paramBitmap = a(j.k(paramBitmap), paramBitmap.getConfig());
    AppMethodBeat.o(77138);
    return paramBitmap;
  }
  
  public final int i(Bitmap paramBitmap)
  {
    AppMethodBeat.i(77140);
    int i = j.k(paramBitmap);
    AppMethodBeat.o(77140);
    return i;
  }
  
  public final Bitmap oV()
  {
    AppMethodBeat.i(77135);
    Bitmap localBitmap = (Bitmap)this.aIq.removeLast();
    if (localBitmap != null) {
      a(Integer.valueOf(j.k(localBitmap)), localBitmap);
    }
    AppMethodBeat.o(77135);
    return localBitmap;
  }
  
  public final String toString()
  {
    AppMethodBeat.i(77141);
    Object localObject = new StringBuilder("SizeConfigStrategy{groupedMap=").append(this.aIq).append(", sortedSizes=(");
    Iterator localIterator = this.aIB.entrySet().iterator();
    while (localIterator.hasNext())
    {
      Map.Entry localEntry = (Map.Entry)localIterator.next();
      ((StringBuilder)localObject).append(localEntry.getKey()).append('[').append(localEntry.getValue()).append("], ");
    }
    if (!this.aIB.isEmpty()) {
      ((StringBuilder)localObject).replace(((StringBuilder)localObject).length() - 2, ((StringBuilder)localObject).length(), "");
    }
    localObject = ")}";
    AppMethodBeat.o(77141);
    return localObject;
  }
  
  static final class a
    implements m
  {
    private final n.b aIV;
    private Bitmap.Config aIs;
    int size;
    
    public a(n.b paramb)
    {
      this.aIV = paramb;
    }
    
    public final void b(int paramInt, Bitmap.Config paramConfig)
    {
      this.size = paramInt;
      this.aIs = paramConfig;
    }
    
    public final boolean equals(Object paramObject)
    {
      AppMethodBeat.i(77128);
      if ((paramObject instanceof a))
      {
        paramObject = (a)paramObject;
        if ((this.size == paramObject.size) && (j.g(this.aIs, paramObject.aIs)))
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
      if (this.aIs != null) {}
      for (int i = this.aIs.hashCode();; i = 0)
      {
        AppMethodBeat.o(77129);
        return i + j * 31;
      }
    }
    
    public final void oW()
    {
      AppMethodBeat.i(77126);
      this.aIV.a(this);
      AppMethodBeat.o(77126);
    }
    
    public final String toString()
    {
      AppMethodBeat.i(77127);
      String str = n.a(this.size, this.aIs);
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
      n.a locala = (n.a)oY();
      locala.b(paramInt, paramConfig);
      AppMethodBeat.o(77130);
      return locala;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.bumptech.glide.c.b.a.n
 * JD-Core Version:    0.7.0.1
 */