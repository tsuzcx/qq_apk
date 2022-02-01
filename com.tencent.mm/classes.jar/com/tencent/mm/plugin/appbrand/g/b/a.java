package com.tencent.mm.plugin.appbrand.g.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class a
{
  private static a oeu;
  public List<a> listeners;
  public boolean oev;
  public Map<String, c> oew;
  
  private a()
  {
    AppMethodBeat.i(158902);
    this.oev = false;
    this.listeners = new ArrayList();
    this.oew = new HashMap();
    AppMethodBeat.o(158902);
  }
  
  public static a bMG()
  {
    AppMethodBeat.i(158903);
    if (oeu == null) {}
    try
    {
      if (oeu == null) {
        oeu = new a();
      }
      a locala = oeu;
      AppMethodBeat.o(158903);
      return locala;
    }
    finally
    {
      AppMethodBeat.o(158903);
    }
  }
  
  public final void a(a parama)
  {
    AppMethodBeat.i(158908);
    if (this.oev)
    {
      AppMethodBeat.o(158908);
      return;
    }
    if (!this.listeners.contains(parama)) {
      this.listeners.add(parama);
    }
    AppMethodBeat.o(158908);
  }
  
  public final c afP(String paramString)
  {
    AppMethodBeat.i(158906);
    paramString = (c)this.oew.get(paramString);
    AppMethodBeat.o(158906);
    return paramString;
  }
  
  public final void b(a parama)
  {
    AppMethodBeat.i(158909);
    this.listeners.remove(parama);
    AppMethodBeat.o(158909);
  }
  
  public final Collection<c> bMH()
  {
    AppMethodBeat.i(158907);
    Collection localCollection = this.oew.values();
    AppMethodBeat.o(158907);
    return localCollection;
  }
  
  public final void bMI()
  {
    this.oev = true;
  }
  
  public final boolean contains(String paramString)
  {
    AppMethodBeat.i(158904);
    boolean bool = this.oew.containsKey(paramString);
    AppMethodBeat.o(158904);
    return bool;
  }
  
  public final void destroy()
  {
    AppMethodBeat.i(158910);
    this.oew.clear();
    oeu = null;
    AppMethodBeat.o(158910);
  }
  
  public final void remove(String paramString)
  {
    AppMethodBeat.i(158905);
    if (this.oev)
    {
      AppMethodBeat.o(158905);
      return;
    }
    paramString = (c)this.oew.remove(paramString);
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