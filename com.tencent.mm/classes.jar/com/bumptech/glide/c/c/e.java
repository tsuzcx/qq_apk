package com.bumptech.glide.c.c;

import com.bumptech.glide.c.a;
import com.bumptech.glide.c.a.d;
import com.bumptech.glide.c.a.d.a;
import com.bumptech.glide.c.j;
import com.bumptech.glide.g;
import com.bumptech.glide.g.b;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.io.IOException;
import java.io.InputStream;

public final class e<Model, Data>
  implements n<Model, Data>
{
  private final a<Data> aHk;
  
  public e(a<Data> parama)
  {
    this.aHk = parama;
  }
  
  public final boolean U(Model paramModel)
  {
    AppMethodBeat.i(77225);
    boolean bool = paramModel.toString().startsWith("data:image");
    AppMethodBeat.o(77225);
    return bool;
  }
  
  public final n.a<Data> b(Model paramModel, int paramInt1, int paramInt2, j paramj)
  {
    AppMethodBeat.i(77224);
    paramModel = new n.a(new b(paramModel), new b(paramModel.toString(), this.aHk));
    AppMethodBeat.o(77224);
    return paramModel;
  }
  
  public static abstract interface a<Data>
  {
    public abstract void O(Data paramData);
    
    public abstract Data P(String paramString);
    
    public abstract Class<Data> nK();
  }
  
  static final class b<Data>
    implements d<Data>
  {
    private final String aHl;
    private final e.a<Data> aHm;
    private Data data;
    
    b(String paramString, e.a<Data> parama)
    {
      this.aHl = paramString;
      this.aHm = parama;
    }
    
    public final void a(g paramg, d.a<? super Data> parama)
    {
      AppMethodBeat.i(77217);
      try
      {
        this.data = this.aHm.P(this.aHl);
        parama.P(this.data);
        AppMethodBeat.o(77217);
        return;
      }
      catch (IllegalArgumentException paramg)
      {
        parama.e(paramg);
        AppMethodBeat.o(77217);
      }
    }
    
    public final void cancel() {}
    
    public final void cleanup()
    {
      AppMethodBeat.i(77218);
      try
      {
        this.aHm.O(this.data);
        AppMethodBeat.o(77218);
        return;
      }
      catch (IOException localIOException)
      {
        AppMethodBeat.o(77218);
      }
    }
    
    public final Class<Data> nK()
    {
      AppMethodBeat.i(77219);
      Class localClass = this.aHm.nK();
      AppMethodBeat.o(77219);
      return localClass;
    }
    
    public final a nL()
    {
      return a.aBX;
    }
  }
  
  public static final class c<Model>
    implements o<Model, InputStream>
  {
    private final e.a<InputStream> aHn;
    
    public c()
    {
      AppMethodBeat.i(77222);
      this.aHn = new e.a()
      {
        public final Class<InputStream> nK()
        {
          return InputStream.class;
        }
      };
      AppMethodBeat.o(77222);
    }
    
    public final n<Model, InputStream> a(r paramr)
    {
      AppMethodBeat.i(77223);
      paramr = new e(this.aHn);
      AppMethodBeat.o(77223);
      return paramr;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.bumptech.glide.c.c.e
 * JD-Core Version:    0.7.0.1
 */