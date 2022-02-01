package androidx.camera.camera2.b.a.a;

import android.hardware.camera2.params.InputConfiguration;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.Objects;

public final class a
{
  private final b Fm;
  
  a(b paramb)
  {
    this.Fm = paramb;
  }
  
  public final boolean equals(Object paramObject)
  {
    AppMethodBeat.i(198152);
    if (!(paramObject instanceof a))
    {
      AppMethodBeat.o(198152);
      return false;
    }
    boolean bool = this.Fm.equals(((a)paramObject).Fm);
    AppMethodBeat.o(198152);
    return bool;
  }
  
  public final Object hV()
  {
    AppMethodBeat.i(198168);
    Object localObject = this.Fm.hW();
    AppMethodBeat.o(198168);
    return localObject;
  }
  
  public final int hashCode()
  {
    AppMethodBeat.i(198155);
    int i = this.Fm.hashCode();
    AppMethodBeat.o(198155);
    return i;
  }
  
  public final String toString()
  {
    AppMethodBeat.i(198161);
    String str = this.Fm.toString();
    AppMethodBeat.o(198161);
    return str;
  }
  
  static final class a
    implements a.b
  {
    private final InputConfiguration Fn;
    
    a(Object paramObject)
    {
      AppMethodBeat.i(198126);
      this.Fn = ((InputConfiguration)paramObject);
      AppMethodBeat.o(198126);
    }
    
    public final boolean equals(Object paramObject)
    {
      AppMethodBeat.i(198135);
      if (!(paramObject instanceof a.b))
      {
        AppMethodBeat.o(198135);
        return false;
      }
      boolean bool = Objects.equals(this.Fn, ((a.b)paramObject).hW());
      AppMethodBeat.o(198135);
      return bool;
    }
    
    public final Object hW()
    {
      return this.Fn;
    }
    
    public final int hashCode()
    {
      AppMethodBeat.i(198140);
      int i = this.Fn.hashCode();
      AppMethodBeat.o(198140);
      return i;
    }
    
    public final String toString()
    {
      AppMethodBeat.i(198144);
      String str = this.Fn.toString();
      AppMethodBeat.o(198144);
      return str;
    }
  }
  
  static abstract interface b
  {
    public abstract Object hW();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     androidx.camera.camera2.b.a.a.a
 * JD-Core Version:    0.7.0.1
 */