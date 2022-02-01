package com.tencent.mapsdk.internal;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Locale;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

public class kp<K, V>
{
  private final LinkedHashMap<K, V> a;
  private int b;
  private int c;
  private int d;
  private int e;
  private int f;
  private int g;
  private int h;
  
  public kp(int paramInt)
  {
    AppMethodBeat.i(222382);
    if (paramInt <= 0)
    {
      IllegalArgumentException localIllegalArgumentException = new IllegalArgumentException("maxSize <= 0");
      AppMethodBeat.o(222382);
      throw localIllegalArgumentException;
    }
    this.c = paramInt;
    this.a = new LinkedHashMap(0, 0.75F, true);
    AppMethodBeat.o(222382);
  }
  
  private void a(int paramInt)
  {
    AppMethodBeat.i(222391);
    if (paramInt <= 0)
    {
      IllegalArgumentException localIllegalArgumentException = new IllegalArgumentException("maxSize <= 0");
      AppMethodBeat.o(222391);
      throw localIllegalArgumentException;
    }
    try
    {
      this.c = paramInt;
      b(paramInt);
      AppMethodBeat.o(222391);
      return;
    }
    finally
    {
      AppMethodBeat.o(222391);
    }
  }
  
  private int b(K paramK, V paramV)
  {
    AppMethodBeat.i(222421);
    int i = a(paramV);
    if (i < 0)
    {
      paramK = new IllegalStateException("Negative size: " + paramK + "=" + paramV);
      AppMethodBeat.o(222421);
      throw paramK;
    }
    AppMethodBeat.o(222421);
    return i;
  }
  
  private void b(int paramInt)
  {
    AppMethodBeat.i(222405);
    for (;;)
    {
      try
      {
        if ((this.b < 0) || ((this.a.isEmpty()) && (this.b != 0)))
        {
          IllegalStateException localIllegalStateException = new IllegalStateException(getClass().getName() + ".sizeOf() is reporting inconsistent results!");
          AppMethodBeat.o(222405);
          throw localIllegalStateException;
        }
      }
      finally
      {
        AppMethodBeat.o(222405);
      }
      if ((this.b <= paramInt) || (this.a.isEmpty()))
      {
        AppMethodBeat.o(222405);
        return;
      }
      Object localObject3 = (Map.Entry)this.a.entrySet().iterator().next();
      Object localObject2 = ((Map.Entry)localObject3).getKey();
      localObject3 = ((Map.Entry)localObject3).getValue();
      this.a.remove(localObject2);
      this.b -= b(localObject2, localObject3);
      this.f += 1;
      a(true, localObject3);
    }
  }
  
  private static V e()
  {
    return null;
  }
  
  private int f()
  {
    try
    {
      int i = this.g;
      return i;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  private int g()
  {
    try
    {
      int i = this.h;
      return i;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  private int h()
  {
    try
    {
      int i = this.e;
      return i;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  private int i()
  {
    try
    {
      int i = this.d;
      return i;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  private int j()
  {
    try
    {
      int i = this.f;
      return i;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  protected int a(V paramV)
  {
    return 1;
  }
  
  public final V a(K paramK, V paramV)
  {
    AppMethodBeat.i(222462);
    if ((paramK == null) || (paramV == null))
    {
      paramK = new NullPointerException("key == null || value == null");
      AppMethodBeat.o(222462);
      throw paramK;
    }
    try
    {
      this.d += 1;
      this.b += b(paramK, paramV);
      paramV = this.a.put(paramK, paramV);
      if (paramV != null) {
        this.b -= b(paramK, paramV);
      }
      if (paramV != null) {
        a(false, paramV);
      }
      b(this.c);
      AppMethodBeat.o(222462);
      return paramV;
    }
    finally
    {
      AppMethodBeat.o(222462);
    }
  }
  
  public final void a()
  {
    AppMethodBeat.i(222495);
    b(-1);
    AppMethodBeat.o(222495);
  }
  
  protected void a(boolean paramBoolean, V paramV) {}
  
  public final int b()
  {
    try
    {
      int i = this.b;
      return i;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  public final V b(K paramK)
  {
    AppMethodBeat.i(222452);
    if (paramK == null)
    {
      paramK = new NullPointerException("key == null");
      AppMethodBeat.o(222452);
      throw paramK;
    }
    try
    {
      paramK = this.a.get(paramK);
      if (paramK != null)
      {
        this.g += 1;
        return paramK;
      }
      this.h += 1;
      return null;
    }
    finally
    {
      AppMethodBeat.o(222452);
    }
  }
  
  public final int c()
  {
    try
    {
      int i = this.c;
      return i;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  public final V c(K paramK)
  {
    AppMethodBeat.i(222470);
    if (paramK == null)
    {
      paramK = new NullPointerException("key == null");
      AppMethodBeat.o(222470);
      throw paramK;
    }
    try
    {
      Object localObject = this.a.remove(paramK);
      if (localObject != null) {
        this.b -= b(paramK, localObject);
      }
      if (localObject != null) {
        a(false, localObject);
      }
      AppMethodBeat.o(222470);
      return localObject;
    }
    finally
    {
      AppMethodBeat.o(222470);
    }
  }
  
  public final Map<K, V> d()
  {
    try
    {
      AppMethodBeat.i(222516);
      LinkedHashMap localLinkedHashMap = new LinkedHashMap(this.a);
      AppMethodBeat.o(222516);
      return localLinkedHashMap;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  public final String toString()
  {
    int i = 0;
    try
    {
      AppMethodBeat.i(222525);
      int j = this.g + this.h;
      if (j != 0) {
        i = this.g * 100 / j;
      }
      String str = String.format(Locale.US, "LruCache[maxSize=%d,hits=%d,misses=%d,hitRate=%d%%]", new Object[] { Integer.valueOf(this.c), Integer.valueOf(this.g), Integer.valueOf(this.h), Integer.valueOf(i) });
      AppMethodBeat.o(222525);
      return str;
    }
    finally {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mapsdk.internal.kp
 * JD-Core Version:    0.7.0.1
 */