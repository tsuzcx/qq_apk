package com.tencent.mm.plugin.appbrand.g.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class a
{
  private static a ria;
  public List<a> listeners;
  public boolean rib;
  public Map<String, c> ric;
  
  private a()
  {
    AppMethodBeat.i(158902);
    this.rib = false;
    this.listeners = new ArrayList();
    this.ric = new HashMap();
    AppMethodBeat.o(158902);
  }
  
  public static a cmW()
  {
    AppMethodBeat.i(158903);
    if (ria == null) {}
    try
    {
      if (ria == null) {
        ria = new a();
      }
      a locala = ria;
      AppMethodBeat.o(158903);
      return locala;
    }
    finally
    {
      AppMethodBeat.o(158903);
    }
  }
  
  public final c YL(String paramString)
  {
    AppMethodBeat.i(158906);
    paramString = (c)this.ric.get(paramString);
    AppMethodBeat.o(158906);
    return paramString;
  }
  
  public final void a(a parama)
  {
    AppMethodBeat.i(158908);
    if (this.rib)
    {
      AppMethodBeat.o(158908);
      return;
    }
    if (!this.listeners.contains(parama)) {
      this.listeners.add(parama);
    }
    AppMethodBeat.o(158908);
  }
  
  public final void b(a parama)
  {
    AppMethodBeat.i(158909);
    this.listeners.remove(parama);
    AppMethodBeat.o(158909);
  }
  
  public final Collection<c> cmX()
  {
    AppMethodBeat.i(158907);
    Collection localCollection = this.ric.values();
    AppMethodBeat.o(158907);
    return localCollection;
  }
  
  public final boolean contains(String paramString)
  {
    AppMethodBeat.i(158904);
    boolean bool = this.ric.containsKey(paramString);
    AppMethodBeat.o(158904);
    return bool;
  }
  
  public final void destroy()
  {
    AppMethodBeat.i(158910);
    this.ric.clear();
    ria = null;
    AppMethodBeat.o(158910);
  }
  
  public final void remove(String paramString)
  {
    AppMethodBeat.i(158905);
    if (this.rib)
    {
      AppMethodBeat.o(158905);
      return;
    }
    paramString = (c)this.ric.remove(paramString);
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.g.b.a
 * JD-Core Version:    0.7.0.1
 */