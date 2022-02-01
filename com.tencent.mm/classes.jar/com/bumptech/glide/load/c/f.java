package com.bumptech.glide.load.c;

import android.os.ParcelFileDescriptor;
import android.util.Log;
import com.bumptech.glide.g;
import com.bumptech.glide.load.a;
import com.bumptech.glide.load.a.d;
import com.bumptech.glide.load.a.d.a;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;

public final class f<Data>
  implements n<File, Data>
{
  private final d<Data> aJP;
  
  public f(d<Data> paramd)
  {
    this.aJP = paramd;
  }
  
  public static class a<Data>
    implements o<File, Data>
  {
    private final f.d<Data> aJQ;
    
    public a(f.d<Data> paramd)
    {
      this.aJQ = paramd;
    }
    
    public final n<File, Data> a(r paramr)
    {
      AppMethodBeat.i(77226);
      paramr = new f(this.aJQ);
      AppMethodBeat.o(77226);
      return paramr;
    }
  }
  
  public static final class b
    extends f.a<ParcelFileDescriptor>
  {
    public b()
    {
      super()
      {
        public final Class<ParcelFileDescriptor> os()
        {
          return ParcelFileDescriptor.class;
        }
      };
      AppMethodBeat.i(77229);
      AppMethodBeat.o(77229);
    }
  }
  
  static final class c<Data>
    implements d<Data>
  {
    private final f.d<Data> aJQ;
    private Data data;
    private final File file;
    
    c(File paramFile, f.d<Data> paramd)
    {
      this.file = paramFile;
      this.aJQ = paramd;
    }
    
    public final void a(g paramg, d.a<? super Data> parama)
    {
      AppMethodBeat.i(77230);
      try
      {
        this.data = this.aJQ.u(this.file);
        parama.S(this.data);
        AppMethodBeat.o(77230);
        return;
      }
      catch (FileNotFoundException paramg)
      {
        Log.isLoggable("FileLoader", 3);
        parama.e(paramg);
        AppMethodBeat.o(77230);
      }
    }
    
    public final void cancel() {}
    
    public final void cleanup()
    {
      AppMethodBeat.i(77231);
      if (this.data != null) {
        try
        {
          this.aJQ.R(this.data);
          AppMethodBeat.o(77231);
          return;
        }
        catch (IOException localIOException) {}
      }
      AppMethodBeat.o(77231);
    }
    
    public final Class<Data> os()
    {
      AppMethodBeat.i(77232);
      Class localClass = this.aJQ.os();
      AppMethodBeat.o(77232);
      return localClass;
    }
    
    public final a ot()
    {
      return a.aEG;
    }
  }
  
  public static abstract interface d<Data>
  {
    public abstract void R(Data paramData);
    
    public abstract Class<Data> os();
    
    public abstract Data u(File paramFile);
  }
  
  public static final class e
    extends f.a<InputStream>
  {
    public e()
    {
      super()
      {
        public final Class<InputStream> os()
        {
          return InputStream.class;
        }
      };
      AppMethodBeat.i(77235);
      AppMethodBeat.o(77235);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.bumptech.glide.load.c.f
 * JD-Core Version:    0.7.0.1
 */