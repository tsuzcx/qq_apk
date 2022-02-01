package androidx.camera.core.impl;

import com.tencent.matrix.trace.core.AppMethodBeat;

public abstract class bg
{
  public static bg a(bg.b paramb, a parama)
  {
    return new e(paramb, parama);
  }
  
  public abstract bg.b jO();
  
  public abstract a jP();
  
  public static enum a
  {
    public final int mId;
    
    static
    {
      AppMethodBeat.i(198919);
      Nq = new a("ANALYSIS", 0, 0);
      Nr = new a("PREVIEW", 1, 1);
      Ns = new a("RECORD", 2, 2);
      Nt = new a("MAXIMUM", 3, 3);
      Nu = new a("NOT_SUPPORT", 4, 4);
      Nv = new a[] { Nq, Nr, Ns, Nt, Nu };
      AppMethodBeat.o(198919);
    }
    
    private a(int paramInt)
    {
      this.mId = paramInt;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     androidx.camera.core.impl.bg
 * JD-Core Version:    0.7.0.1
 */