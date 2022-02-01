package com.tencent.mapsdk.internal;

import android.graphics.Bitmap;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map.Entry;
import java.util.Set;

public final class mj
{
  public bd a;
  public sc b;
  public HashMap<Integer, oj> c;
  public HashMap<Integer, oj> d;
  
  mj(bd parambd, sc paramsc)
  {
    AppMethodBeat.i(223009);
    this.a = parambd;
    this.b = paramsc;
    this.c = new HashMap();
    this.d = new HashMap();
    AppMethodBeat.o(223009);
  }
  
  private static Bitmap a(String paramString)
  {
    AppMethodBeat.i(223038);
    paramString = gv.b.a(paramString);
    AppMethodBeat.o(223038);
    return paramString;
  }
  
  private void a(oj paramoj)
  {
    AppMethodBeat.i(223015);
    if ((paramoj.f > 0) && (this.c.containsKey(Integer.valueOf(paramoj.f))))
    {
      if (paramoj.o)
      {
        localsc = this.b;
        if (0L != localsc.e) {
          localsc.a(new sc.121(localsc, paramoj));
        }
        if (paramoj.y)
        {
          gv.b.a(paramoj.g, paramoj.d());
          paramoj.a(false);
        }
      }
      paramoj.o = false;
      this.d.put(Integer.valueOf(paramoj.f), paramoj);
      AppMethodBeat.o(223015);
      return;
    }
    sc localsc = this.b;
    paramoj.f = ((Integer)localsc.a(new sc.120(localsc, paramoj), Integer.valueOf(0))).intValue();
    if (paramoj.f > 0)
    {
      gv.b.a(paramoj.g, paramoj.d());
      paramoj.a(false);
      paramoj.o = false;
      this.d.put(Integer.valueOf(paramoj.f), paramoj);
    }
    AppMethodBeat.o(223015);
  }
  
  private void b()
  {
    AppMethodBeat.i(223025);
    ArrayList localArrayList = new ArrayList();
    Object localObject1 = this.c.entrySet().iterator();
    while (((Iterator)localObject1).hasNext())
    {
      Map.Entry localEntry = (Map.Entry)((Iterator)localObject1).next();
      Object localObject2 = localEntry.getKey();
      localEntry.getValue();
      if (!this.d.containsKey(localObject2)) {
        localArrayList.add(Integer.valueOf(((Integer)localObject2).intValue()));
      }
    }
    int j = localArrayList.size();
    if (j <= 0)
    {
      AppMethodBeat.o(223025);
      return;
    }
    localObject1 = new int[j];
    int i = 0;
    while (i < j)
    {
      localObject1[i] = ((Integer)localArrayList.get(i)).intValue();
      i += 1;
    }
    this.b.a((int[])localObject1, j);
    AppMethodBeat.o(223025);
  }
  
  private void c()
  {
    AppMethodBeat.i(223032);
    this.c.clear();
    this.c.putAll(this.d);
    this.d.clear();
    AppMethodBeat.o(223032);
  }
  
  private bd d()
  {
    return this.a;
  }
  
  private float e()
  {
    AppMethodBeat.i(223048);
    float f = this.a.a().A.b.p;
    AppMethodBeat.o(223048);
    return f;
  }
  
  public final void a()
  {
    AppMethodBeat.i(223057);
    ArrayList localArrayList = new ArrayList();
    Object localObject1 = this.c.entrySet().iterator();
    while (((Iterator)localObject1).hasNext())
    {
      Map.Entry localEntry = (Map.Entry)((Iterator)localObject1).next();
      Object localObject2 = localEntry.getKey();
      localEntry.getValue();
      if (!this.d.containsKey(localObject2)) {
        localArrayList.add(Integer.valueOf(((Integer)localObject2).intValue()));
      }
    }
    int j = localArrayList.size();
    if (j > 0)
    {
      localObject1 = new int[j];
      int i = 0;
      while (i < j)
      {
        localObject1[i] = ((Integer)localArrayList.get(i)).intValue();
        i += 1;
      }
      this.b.a((int[])localObject1, j);
    }
    this.c.clear();
    this.c.putAll(this.d);
    this.d.clear();
    AppMethodBeat.o(223057);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes11.jar
 * Qualified Name:     com.tencent.mapsdk.internal.mj
 * JD-Core Version:    0.7.0.1
 */