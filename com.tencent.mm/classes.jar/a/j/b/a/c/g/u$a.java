package a.j.b.a.c.g;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.Arrays;
import java.util.Stack;

final class u$a
{
  final Stack<d> Csb;
  
  private u$a()
  {
    AppMethodBeat.i(121583);
    this.Csb = new Stack();
    AppMethodBeat.o(121583);
  }
  
  private static int VL(int paramInt)
  {
    AppMethodBeat.i(121585);
    int i = Arrays.binarySearch(u.emY(), paramInt);
    paramInt = i;
    if (i < 0) {
      paramInt = -(i + 1) - 1;
    }
    AppMethodBeat.o(121585);
    return paramInt;
  }
  
  final void f(d paramd)
  {
    AppMethodBeat.i(121584);
    for (;;)
    {
      if (paramd.emr())
      {
        int i = VL(paramd.size());
        int j = u.emY()[(i + 1)];
        if ((this.Csb.isEmpty()) || (((d)this.Csb.peek()).size() >= j))
        {
          this.Csb.push(paramd);
          AppMethodBeat.o(121584);
          return;
        }
        i = u.emY()[i];
        for (Object localObject = (d)this.Csb.pop(); (!this.Csb.isEmpty()) && (((d)this.Csb.peek()).size() < i); localObject = new u((d)this.Csb.pop(), (d)localObject, (byte)0)) {}
        for (paramd = new u((d)localObject, paramd, (byte)0); !this.Csb.isEmpty(); paramd = new u((d)this.Csb.pop(), paramd, (byte)0))
        {
          i = VL(paramd.size());
          i = u.emY()[(i + 1)];
          if (((d)this.Csb.peek()).size() >= i) {
            break;
          }
        }
        this.Csb.push(paramd);
        AppMethodBeat.o(121584);
        return;
      }
      if (!(paramd instanceof u)) {
        break;
      }
      paramd = (u)paramd;
      f(u.a(paramd));
      paramd = u.b(paramd);
    }
    paramd = String.valueOf(String.valueOf(paramd.getClass()));
    paramd = new IllegalArgumentException(paramd.length() + 49 + "Has a new type of ByteString been created? Found " + paramd);
    AppMethodBeat.o(121584);
    throw paramd;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     a.j.b.a.c.g.u.a
 * JD-Core Version:    0.7.0.1
 */