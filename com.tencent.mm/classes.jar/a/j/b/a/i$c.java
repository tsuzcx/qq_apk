package a.j.b.a;

import a.f.b.j;
import a.j.b.a.c.b.b;
import a.j.b.a.c.b.b.a;
import a.l;
import com.tencent.matrix.trace.core.AppMethodBeat;

@l(eaO={1, 1, 13}, eaP={""}, eaQ={"Lkotlin/reflect/jvm/internal/KDeclarationContainerImpl$MemberBelonginess;", "", "(Ljava/lang/String;I)V", "accept", "", "member", "Lkotlin/reflect/jvm/internal/impl/descriptors/CallableMemberDescriptor;", "DECLARED", "INHERITED", "kotlin-reflect-api"})
public enum i$c
{
  static
  {
    AppMethodBeat.i(118743);
    c localc1 = new c("DECLARED", 0);
    BOW = localc1;
    c localc2 = new c("INHERITED", 1);
    BOX = localc2;
    BOZ = new c[] { localc1, localc2 };
    AppMethodBeat.o(118743);
  }
  
  private i$c() {}
  
  public final boolean a(b paramb)
  {
    AppMethodBeat.i(118744);
    j.q(paramb, "member");
    paramb = paramb.edy();
    j.p(paramb, "member.kind");
    boolean bool2 = paramb.edz();
    if ((c)this == BOW) {}
    for (boolean bool1 = true; bool2 == bool1; bool1 = false)
    {
      AppMethodBeat.o(118744);
      return true;
    }
    AppMethodBeat.o(118744);
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     a.j.b.a.i.c
 * JD-Core Version:    0.7.0.1
 */