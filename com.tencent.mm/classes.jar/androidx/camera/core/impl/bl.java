package androidx.camera.core.impl;

import android.content.Context;
import com.tencent.matrix.trace.core.AppMethodBeat;

public abstract interface bl
{
  public static final bl NL = new bl()
  {
    public final ac a(bl.a paramAnonymousa)
    {
      return null;
    }
  };
  
  public abstract ac a(a parama);
  
  public static enum a
  {
    static
    {
      AppMethodBeat.i(198671);
      NM = new a("IMAGE_CAPTURE", 0);
      NN = new a("PREVIEW", 1);
      NO = new a("IMAGE_ANALYSIS", 2);
      NP = new a("VIDEO_CAPTURE", 3);
      NQ = new a[] { NM, NN, NO, NP };
      AppMethodBeat.o(198671);
    }
    
    private a() {}
  }
  
  public static abstract interface b
  {
    public abstract bl newInstance(Context paramContext);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     androidx.camera.core.impl.bl
 * JD-Core Version:    0.7.0.1
 */