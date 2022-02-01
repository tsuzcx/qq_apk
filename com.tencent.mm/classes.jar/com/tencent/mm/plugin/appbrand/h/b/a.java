package com.tencent.mm.plugin.appbrand.h.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class a
{
  private static a jIz;
  public boolean jIA;
  public Map<String, c> jIB;
  public List<a> listeners;
  
  private a()
  {
    AppMethodBeat.i(158902);
    this.jIA = false;
    this.listeners = new ArrayList();
    this.jIB = new HashMap();
    AppMethodBeat.o(158902);
  }
  
  public static a bbG()
  {
    AppMethodBeat.i(158903);
    if (jIz == null) {}
    try
    {
      if (jIz == null) {
        jIz = new a();
      }
      a locala = jIz;
      AppMethodBeat.o(158903);
      return locala;
    }
    finally
    {
      AppMethodBeat.o(158903);
    }
  }
  
  public final c KP(String paramString)
  {
    AppMethodBeat.i(158906);
    paramString = (c)this.jIB.get(paramString);
    AppMethodBeat.o(158906);
    return paramString;
  }
  
  public final void a(a parama)
  {
    AppMethodBeat.i(158908);
    if (this.jIA)
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
  
  public final Collection<c> bbH()
  {
    AppMethodBeat.i(158907);
    Collection localCollection = this.jIB.values();
    AppMethodBeat.o(158907);
    return localCollection;
  }
  
  public final void bbI()
  {
    this.jIA = true;
  }
  
  public final boolean contains(String paramString)
  {
    AppMethodBeat.i(158904);
    boolean bool = this.jIB.containsKey(paramString);
    AppMethodBeat.o(158904);
    return bool;
  }
  
  public final void destroy()
  {
    AppMethodBeat.i(158910);
    this.jIB.clear();
    jIz = null;
    AppMethodBeat.o(158910);
  }
  
  public final void remove(String paramString)
  {
    AppMethodBeat.i(158905);
    if (this.jIA)
    {
      AppMethodBeat.o(158905);
      return;
    }
    paramString = (c)this.jIB.remove(paramString);
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