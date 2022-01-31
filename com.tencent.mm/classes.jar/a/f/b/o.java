package a.f.b;

import a.l;
import com.tencent.matrix.trace.core.AppMethodBeat;

@l(eaO={1, 1, 13}, eaP={""}, eaQ={"Lkotlin/jvm/internal/PackageReference;", "Lkotlin/jvm/internal/ClassBasedDeclarationContainer;", "jClass", "Ljava/lang/Class;", "moduleName", "", "(Ljava/lang/Class;Ljava/lang/String;)V", "getJClass", "()Ljava/lang/Class;", "members", "", "Lkotlin/reflect/KCallable;", "getMembers", "()Ljava/util/Collection;", "equals", "", "other", "", "hashCode", "", "toString", "kotlin-stdlib"})
public final class o
  implements d
{
  private final Class<?> BNl;
  private final String gVh;
  
  public o(Class<?> paramClass, String paramString)
  {
    AppMethodBeat.i(56239);
    this.BNl = paramClass;
    this.gVh = paramString;
    AppMethodBeat.o(56239);
  }
  
  public final Class<?> ebg()
  {
    return this.BNl;
  }
  
  public final boolean equals(Object paramObject)
  {
    AppMethodBeat.i(56236);
    if (((paramObject instanceof o)) && (j.e(this.BNl, ((o)paramObject).BNl)))
    {
      AppMethodBeat.o(56236);
      return true;
    }
    AppMethodBeat.o(56236);
    return false;
  }
  
  public final int hashCode()
  {
    AppMethodBeat.i(56237);
    int i = this.BNl.hashCode();
    AppMethodBeat.o(56237);
    return i;
  }
  
  public final String toString()
  {
    AppMethodBeat.i(56238);
    String str = this.BNl.toString() + " (Kotlin reflection is not available)";
    AppMethodBeat.o(56238);
    return str;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     a.f.b.o
 * JD-Core Version:    0.7.0.1
 */