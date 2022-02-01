package com.tencent.mm.cs;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.io.IOException;
import java.io.StringWriter;
import java.io.Writer;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;

final class a
  implements Iterable<Object>
{
  final ArrayList<Object> agYV;
  
  public a()
  {
    AppMethodBeat.i(231603);
    this.agYV = new ArrayList();
    AppMethodBeat.o(231603);
  }
  
  public a(g paramg)
  {
    this();
    AppMethodBeat.i(231610);
    if (paramg.jQt() != '[')
    {
      paramg = paramg.bFc("A JSONArray text must start with '['");
      AppMethodBeat.o(231610);
      throw paramg;
    }
    int i = paramg.jQt();
    if (i == 0)
    {
      paramg = paramg.bFc("Expected a ',' or ']'");
      AppMethodBeat.o(231610);
      throw paramg;
    }
    if (i != 93)
    {
      paramg.cLO();
      for (;;)
      {
        if (paramg.jQt() == ',')
        {
          paramg.cLO();
          this.agYV.add(c.bfF);
        }
        for (;;)
        {
          switch (paramg.jQt())
          {
          default: 
            paramg = paramg.bFc("Expected a ',' or ']'");
            AppMethodBeat.o(231610);
            throw paramg;
            paramg.cLO();
            this.agYV.add(paramg.jQu());
          }
        }
        paramg = paramg.bFc("Expected a ',' or ']'");
        AppMethodBeat.o(231610);
        throw paramg;
        i = paramg.jQt();
        if (i == 0)
        {
          paramg = paramg.bFc("Expected a ',' or ']'");
          AppMethodBeat.o(231610);
          throw paramg;
        }
        if (i == 93)
        {
          AppMethodBeat.o(231610);
          return;
        }
        paramg.cLO();
      }
      AppMethodBeat.o(231610);
      return;
    }
    AppMethodBeat.o(231610);
  }
  
  public a(Object paramObject)
  {
    this();
    AppMethodBeat.i(231629);
    if (!paramObject.getClass().isArray())
    {
      paramObject = new b("JSONArray initial value should be a string or collection or array.");
      AppMethodBeat.o(231629);
      throw paramObject;
    }
    if (paramObject.getClass().isArray())
    {
      int j = Array.getLength(paramObject);
      this.agYV.ensureCapacity(this.agYV.size() + j);
      int i = 0;
      while (i < j)
      {
        hb(c.wrap(Array.get(paramObject, i)));
        i += 1;
      }
      AppMethodBeat.o(231629);
      return;
    }
    if ((paramObject instanceof a))
    {
      this.agYV.addAll(((a)paramObject).agYV);
      AppMethodBeat.o(231629);
      return;
    }
    if ((paramObject instanceof Collection))
    {
      D((Collection)paramObject);
      AppMethodBeat.o(231629);
      return;
    }
    if ((paramObject instanceof Iterable))
    {
      paramObject = ((Iterable)paramObject).iterator();
      while (paramObject.hasNext()) {
        hb(c.wrap(paramObject.next()));
      }
      AppMethodBeat.o(231629);
      return;
    }
    paramObject = new b("JSONArray initial value should be a string or collection or array.");
    AppMethodBeat.o(231629);
    throw paramObject;
  }
  
  public a(Collection<?> paramCollection)
  {
    AppMethodBeat.i(231618);
    if (paramCollection == null)
    {
      this.agYV = new ArrayList();
      AppMethodBeat.o(231618);
      return;
    }
    this.agYV = new ArrayList(paramCollection.size());
    D(paramCollection);
    AppMethodBeat.o(231618);
  }
  
  private void D(Collection<?> paramCollection)
  {
    AppMethodBeat.i(231639);
    this.agYV.ensureCapacity(this.agYV.size() + paramCollection.size());
    paramCollection = paramCollection.iterator();
    while (paramCollection.hasNext()) {
      hb(c.wrap(paramCollection.next()));
    }
    AppMethodBeat.o(231639);
  }
  
  private String jQo()
  {
    AppMethodBeat.i(231633);
    Object localObject1 = new StringWriter();
    synchronized (((StringWriter)localObject1).getBuffer())
    {
      localObject1 = a((Writer)localObject1, 0, 0).toString();
      AppMethodBeat.o(231633);
      return localObject1;
    }
  }
  
  public final Writer a(Writer paramWriter, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(231675);
    for (;;)
    {
      int k;
      try
      {
        k = this.agYV.size();
        paramWriter.write(91);
        if (k == 1) {
          try
          {
            c.a(paramWriter, this.agYV.get(0), paramInt1, paramInt2);
            paramWriter.write(93);
            AppMethodBeat.o(231675);
            return paramWriter;
          }
          catch (Exception paramWriter)
          {
            paramWriter = new b("Unable to write JSONArray value at index: 0", paramWriter);
            AppMethodBeat.o(231675);
            throw paramWriter;
          }
        }
        if (k == 0) {
          continue;
        }
      }
      catch (IOException paramWriter)
      {
        paramWriter = new b(paramWriter);
        AppMethodBeat.o(231675);
        throw paramWriter;
      }
      int m = paramInt2 + paramInt1;
      int i = 0;
      int j = 0;
      while (i < k)
      {
        if (j != 0) {
          paramWriter.write(44);
        }
        if (paramInt1 > 0) {
          paramWriter.write(10);
        }
        c.a(paramWriter, m);
        try
        {
          c.a(paramWriter, this.agYV.get(i), paramInt1, m);
          i += 1;
          j = 1;
        }
        catch (Exception paramWriter)
        {
          paramWriter = new b("Unable to write JSONArray value at index: ".concat(String.valueOf(i)), paramWriter);
          AppMethodBeat.o(231675);
          throw paramWriter;
        }
      }
      if (paramInt1 > 0) {
        paramWriter.write(10);
      }
      c.a(paramWriter, paramInt2);
    }
  }
  
  public final a hb(Object paramObject)
  {
    AppMethodBeat.i(231657);
    c.hc(paramObject);
    this.agYV.add(paramObject);
    AppMethodBeat.o(231657);
    return this;
  }
  
  public final Iterator<Object> iterator()
  {
    AppMethodBeat.i(231645);
    Iterator localIterator = this.agYV.iterator();
    AppMethodBeat.o(231645);
    return localIterator;
  }
  
  public final Object opt(int paramInt)
  {
    AppMethodBeat.i(231652);
    if ((paramInt < 0) || (paramInt >= this.agYV.size()))
    {
      AppMethodBeat.o(231652);
      return null;
    }
    Object localObject = this.agYV.get(paramInt);
    AppMethodBeat.o(231652);
    return localObject;
  }
  
  public final String toString()
  {
    AppMethodBeat.i(231664);
    try
    {
      String str = jQo();
      AppMethodBeat.o(231664);
      return str;
    }
    catch (Exception localException)
    {
      AppMethodBeat.o(231664);
    }
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes11.jar
 * Qualified Name:     com.tencent.mm.cs.a
 * JD-Core Version:    0.7.0.1
 */