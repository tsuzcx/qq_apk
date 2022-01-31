package a.j.b.a.b;

import a.f.b.j;
import a.l;
import com.tencent.matrix.trace.core.AppMethodBeat;

@l(eaO={1, 1, 13}, eaP={""}, eaQ={"tryLoadClass", "Ljava/lang/Class;", "Ljava/lang/ClassLoader;", "fqName", "", "descriptors.runtime"})
public final class d
{
  public static final Class<?> a(ClassLoader paramClassLoader, String paramString)
  {
    AppMethodBeat.i(119031);
    j.q(paramClassLoader, "receiver$0");
    j.q(paramString, "fqName");
    try
    {
      paramClassLoader = paramClassLoader.loadClass(paramString);
      AppMethodBeat.o(119031);
      return paramClassLoader;
    }
    catch (ClassNotFoundException paramClassLoader)
    {
      for (;;)
      {
        paramClassLoader = null;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     a.j.b.a.b.d
 * JD-Core Version:    0.7.0.1
 */