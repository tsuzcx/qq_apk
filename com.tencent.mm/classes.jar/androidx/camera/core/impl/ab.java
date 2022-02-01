package androidx.camera.core.impl;

import com.tencent.matrix.trace.core.AppMethodBeat;

public abstract interface ab
{
  public abstract int getId();
  
  public abstract z kd();
  
  public static final class a
    implements ab
  {
    private final z HF;
    
    public a()
    {
      AppMethodBeat.i(198838);
      this.HF = new z.a().kc();
      AppMethodBeat.o(198838);
    }
    
    public final int getId()
    {
      return 0;
    }
    
    public final z kd()
    {
      return this.HF;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     androidx.camera.core.impl.ab
 * JD-Core Version:    0.7.0.1
 */