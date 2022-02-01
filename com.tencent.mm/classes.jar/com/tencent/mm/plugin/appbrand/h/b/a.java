package com.tencent.mm.plugin.appbrand.h.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class a
{
  private static a jil;
  public boolean jim;
  public Map<String, c> jin;
  public List<a> listeners;
  
  private a()
  {
    AppMethodBeat.i(158902);
    this.jim = false;
    this.listeners = new ArrayList();
    this.jin = new HashMap();
    AppMethodBeat.o(158902);
  }
  
  public static a aUI()
  {
    AppMethodBeat.i(158903);
    if (jil == null) {}
    try
    {
      if (jil == null) {
        jil = new a();
      }
      a locala = jil;
      AppMethodBeat.o(158903);
      return locala;
    }
    finally
    {
      AppMethodBeat.o(158903);
    }
  }
  
  public final c GL(String paramString)
  {
    AppMethodBeat.i(158906);
    paramString = (c)this.jin.get(paramString);
    AppMethodBeat.o(158906);
    return paramString;
  }
  
  public final void a(a parama)
  {
    AppMethodBeat.i(158908);
    if (this.jim)
    {
      AppMethodBeat.o(158908);
      return;
    }
    if (!this.listeners.contains(parama)) {
      this.listeners.add(parama);
    }
    AppMethodBeat.o(158908);
  }
  
  public final Collection<c> aUJ()
  {
    AppMethodBeat.i(158907);
    Collection localCollection = this.jin.values();
    AppMethodBeat.o(158907);
    return localCollection;
  }
  
  public final void aUK()
  {
    this.jim = true;
  }
  
  public final void b(a parama)
  {
    AppMethodBeat.i(158909);
    this.listeners.remove(parama);
    AppMethodBeat.o(158909);
  }
  
  public final boolean contains(String paramString)
  {
    AppMethodBeat.i(158904);
    boolean bool = this.jin.containsKey(paramString);
    AppMethodBeat.o(158904);
    return bool;
  }
  
  public final void destroy()
  {
    AppMethodBeat.i(158910);
    this.jin.clear();
    jil = null;
    AppMethodBeat.o(158910);
  }
  
  public final void remove(String paramString)
  {
    AppMethodBeat.i(158905);
    if (this.jim)
    {
      AppMethodBeat.o(158905);
      return;
    }
    paramString = (c)this.jin.remove(paramString);
    int i = 0;
    while (i < this.listeners.size())
    {
      a locala = (a)this.listeners.get(i);
      if (locala != null)
      {
        locala.b(paramString);
        i += 1;
      }
      else
      {
        this.listeners.remove(i);
      }
    }
    AppMethodBeat.o(158905);
  }
  
  public static abstract interface a
  {
    public abstract void a(c paramc);
    
    public abstract void b(c paramc);
    
    public abstract void c(c paramc);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.h.b.a
 * JD-Core Version:    0.7.0.1
 */