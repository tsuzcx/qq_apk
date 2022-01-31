package a.j.b.a.c.e.a;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class b$a
  extends b.c<Boolean>
{
  public b$a(int paramInt)
  {
    super(paramInt, 1, (byte)0);
  }
  
  public final Boolean Vo(int paramInt)
  {
    boolean bool = true;
    AppMethodBeat.i(121065);
    if ((1 << this.offset & paramInt) != 0) {}
    for (;;)
    {
      AppMethodBeat.o(121065);
      return Boolean.valueOf(bool);
      bool = false;
    }
  }
  
  public final int o(Boolean paramBoolean)
  {
    AppMethodBeat.i(121066);
    if (paramBoolean.booleanValue())
    {
      int i = this.offset;
      AppMethodBeat.o(121066);
      return 1 << i;
    }
    AppMethodBeat.o(121066);
    return 0;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     a.j.b.a.c.e.a.b.a
 * JD-Core Version:    0.7.0.1
 */