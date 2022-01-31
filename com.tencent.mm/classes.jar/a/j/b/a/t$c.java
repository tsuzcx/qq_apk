package a.j.b.a;

import a.f.a.b;
import a.f.b.j;
import a.f.b.k;
import a.j.b.a.a.e;
import a.j.b.a.a.e.d;
import a.j.b.a.a.e.d.a;
import a.j.b.a.a.e.d.b;
import a.j.b.a.a.e.d.c;
import a.j.b.a.a.e.d.d;
import a.j.b.a.a.e.d.e;
import a.j.b.a.a.e.e;
import a.j.b.a.a.e.e.a;
import a.j.b.a.a.e.e.b;
import a.j.b.a.a.e.e.c;
import a.j.b.a.a.e.e.d;
import a.j.b.a.a.e.e.e;
import a.l;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.lang.reflect.Field;
import java.lang.reflect.Modifier;

@l(eaO={1, 1, 13}, eaP={""}, eaQ={"computeFieldCaller", "Lkotlin/reflect/jvm/internal/calls/CallerImpl;", "Ljava/lang/reflect/Field;", "field", "invoke"})
final class t$c
  extends k
  implements b<Field, e<? extends Field>>
{
  t$c(s.a parama, boolean paramBoolean, t.b paramb, t.a parama1)
  {
    super(1);
  }
  
  public final e<Field> d(Field paramField)
  {
    AppMethodBeat.i(118869);
    j.q(paramField, "field");
    if ((t.a(this.BPR.ebF().ebO())) || (!Modifier.isStatic(paramField.getModifiers())))
    {
      if (this.BPT)
      {
        if (this.BPR.ebF().isBound()) {}
        for (paramField = (e.d)new e.d.a(paramField, this.BPR.ebF().BPg);; paramField = (e.d)new e.d.c(paramField))
        {
          paramField = (e)paramField;
          AppMethodBeat.o(118869);
          return paramField;
        }
      }
      if (this.BPR.ebF().isBound()) {}
      for (paramField = (e.e)new e.e.a(paramField, this.BPU.gg(), this.BPR.ebF().BPg);; paramField = (e.e)new e.e.c(paramField, this.BPU.gg()))
      {
        paramField = (e)paramField;
        AppMethodBeat.o(118869);
        return paramField;
      }
    }
    if (this.BPV.gg())
    {
      if (this.BPT)
      {
        if (this.BPR.ebF().isBound()) {}
        for (paramField = (e.d)new e.d.b(paramField);; paramField = (e.d)new e.d.d(paramField))
        {
          paramField = (e)paramField;
          AppMethodBeat.o(118869);
          return paramField;
        }
      }
      if (this.BPR.ebF().isBound()) {}
      for (paramField = (e.e)new e.e.b(paramField, this.BPU.gg());; paramField = (e.e)new e.e.d(paramField, this.BPU.gg()))
      {
        paramField = (e)paramField;
        AppMethodBeat.o(118869);
        return paramField;
      }
    }
    if (this.BPT)
    {
      paramField = (e)new e.d.e(paramField);
      AppMethodBeat.o(118869);
      return paramField;
    }
    paramField = (e)new e.e.e(paramField, this.BPU.gg());
    AppMethodBeat.o(118869);
    return paramField;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     a.j.b.a.t.c
 * JD-Core Version:    0.7.0.1
 */