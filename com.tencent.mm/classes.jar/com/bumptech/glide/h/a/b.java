package com.bumptech.glide.h.a;

import com.tencent.matrix.trace.core.AppMethodBeat;

public abstract class b
{
  abstract void aI(boolean paramBoolean);
  
  public abstract void pU();
  
  public static final class a
    extends b
  {
    private volatile boolean isReleased;
    
    public a()
    {
      super();
    }
    
    public final void aI(boolean paramBoolean)
    {
      this.isReleased = paramBoolean;
    }
    
    public final void pU()
    {
      AppMethodBeat.i(77795);
      if (this.isReleased)
      {
        IllegalStateException localIllegalStateException = new IllegalStateException("Already released");
        AppMethodBeat.o(77795);
        throw localIllegalStateException;
      }
      AppMethodBeat.o(77795);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.bumptech.glide.h.a.b
 * JD-Core Version:    0.7.0.1
 */