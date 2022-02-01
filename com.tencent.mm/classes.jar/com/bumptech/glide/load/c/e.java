package com.bumptech.glide.load.c;

import com.bumptech.glide.f.b;
import com.bumptech.glide.g;
import com.bumptech.glide.load.a;
import com.bumptech.glide.load.a.d;
import com.bumptech.glide.load.a.d.a;
import com.bumptech.glide.load.i;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.io.IOException;
import java.io.InputStream;

public final class e<Model, Data>
  implements n<Model, Data>
{
  private final a<Data> aJK;
  
  public e(a<Data> parama)
  {
    this.aJK = parama;
  }
  
  public final boolean X(Model paramModel)
  {
    AppMethodBeat.i(77225);
    boolean bool = paramModel.toString().startsWith("data:image");
    AppMethodBeat.o(77225);
    return bool;
  }
  
  public final n.a<Data> b(Model paramModel, int paramInt1, int paramInt2, i parami)
  {
    AppMethodBeat.i(77224);
    paramModel = new n.a(new b(paramModel), new b(paramModel.toString(), this.aJK));
    AppMethodBeat.o(77224);
    return paramModel;
  }
  
  public static abstract interface a<Data>
  {
    public abstract Data R(String paramString);
    
    public abstract void R(Data paramData);
    
    public abstract Class<Data> os();
  }
  
  static final class b<Data>
    implements d<Data>
  {
    private final String aJL;
    private final e.a<Data> aJM;
    private Data data;
    
    b(String paramString, e.a<Data> parama)
    {
      this.aJL = paramString;
      this.aJM = parama;
    }
    
    public final void a(g paramg, d.a<? super Data> parama)
    {
      AppMethodBeat.i(77217);
      try
      {
        this.data = this.aJM.R(this.aJL);
        parama.S(this.data);
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
        this.aJM.R(this.data);
        AppMethodBeat.o(77218);
        return;
      }
      catch (IOException localIOException)
      {
        AppMethodBeat.o(77218);
      }
    }
    
    public final Class<Data> os()
    {
      AppMethodBeat.i(77219);
      Class localClass = this.aJM.os();
      AppMethodBeat.o(77219);
      return localClass;
    }
    
    public final a ot()
    {
      return a.aEG;
    }
  }
  
  public static final class c<Model>
    implements o<Model, InputStream>
  {
    private final e.a<InputStream> aJN;
    
    public c()
    {
      AppMethodBeat.i(77222);
      this.aJN = new e.a()
      {
        public final Class<InputStream> os()
        {
          return InputStream.class;
        }
      };
      AppMethodBeat.o(77222);
    }
    
    public final n<Model, InputStream> a(r paramr)
    {
      AppMethodBeat.i(77223);
      paramr = new e(this.aJN);
      AppMethodBeat.o(77223);
      return paramr;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.bumptech.glide.load.c.e
 * JD-Core Version:    0.7.0.1
 */