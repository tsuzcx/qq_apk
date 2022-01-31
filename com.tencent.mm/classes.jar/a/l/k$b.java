package a.l;

import a.f.b.j;
import a.l;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.io.Serializable;
import java.util.regex.Pattern;

@l(eaO={1, 1, 13}, eaP={""}, eaQ={"Lkotlin/text/Regex$Serialized;", "Ljava/io/Serializable;", "Lkotlin/io/Serializable;", "pattern", "", "flags", "", "(Ljava/lang/String;I)V", "getFlags", "()I", "getPattern", "()Ljava/lang/String;", "readResolve", "", "Companion", "kotlin-stdlib"})
final class k$b
  implements Serializable
{
  public static final k.b.a CGW;
  private final int flags;
  private final String ypq;
  
  static
  {
    AppMethodBeat.i(56304);
    CGW = new k.b.a((byte)0);
    AppMethodBeat.o(56304);
  }
  
  public k$b(String paramString, int paramInt)
  {
    AppMethodBeat.i(56303);
    this.ypq = paramString;
    this.flags = paramInt;
    AppMethodBeat.o(56303);
  }
  
  private final Object readResolve()
  {
    AppMethodBeat.i(56302);
    Object localObject = Pattern.compile(this.ypq, this.flags);
    j.p(localObject, "Pattern.compile(pattern, flags)");
    localObject = new k((Pattern)localObject);
    AppMethodBeat.o(56302);
    return localObject;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     a.l.k.b
 * JD-Core Version:    0.7.0.1
 */