package androidx.camera.core;

import com.tencent.matrix.trace.core.AppMethodBeat;

public abstract class r
{
  public static r a(b paramb, a parama)
  {
    return new d(paramb, parama);
  }
  
  public abstract a iA();
  
  public abstract b iz();
  
  public static abstract class a
  {
    public static a a(int paramInt, Throwable paramThrowable)
    {
      return new e(paramInt, paramThrowable);
    }
    
    public abstract Throwable getCause();
    
    public abstract int getCode();
  }
  
  public static enum b
  {
    static
    {
      AppMethodBeat.i(198434);
      Gu = new b("PENDING_OPEN", 0);
      Gv = new b("OPENING", 1);
      Gw = new b("OPEN", 2);
      Gx = new b("CLOSING", 3);
      Gy = new b("CLOSED", 4);
      Gz = new b[] { Gu, Gv, Gw, Gx, Gy };
      AppMethodBeat.o(198434);
    }
    
    private b() {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     androidx.camera.core.r
 * JD-Core Version:    0.7.0.1
 */