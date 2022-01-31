package a.j.b.a;

import a.l;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.lang.ref.WeakReference;

@l(eaO={1, 1, 13}, eaP={""}, eaQ={"Lkotlin/reflect/jvm/internal/WeakClassLoaderBox;", "", "classLoader", "Ljava/lang/ClassLoader;", "(Ljava/lang/ClassLoader;)V", "identityHashCode", "", "getIdentityHashCode", "()I", "ref", "Ljava/lang/ref/WeakReference;", "getRef", "()Ljava/lang/ref/WeakReference;", "temporaryStrongRef", "getTemporaryStrongRef", "()Ljava/lang/ClassLoader;", "setTemporaryStrongRef", "equals", "", "other", "hashCode", "toString", "", "kotlin-reflect-api"})
final class ah
{
  private final int BQt;
  ClassLoader BQu;
  private final WeakReference<ClassLoader> iyQ;
  
  public ah(ClassLoader paramClassLoader)
  {
    AppMethodBeat.i(118949);
    this.iyQ = new WeakReference(paramClassLoader);
    this.BQt = System.identityHashCode(paramClassLoader);
    this.BQu = paramClassLoader;
    AppMethodBeat.o(118949);
  }
  
  public final boolean equals(Object paramObject)
  {
    AppMethodBeat.i(118947);
    if (((paramObject instanceof ah)) && ((ClassLoader)this.iyQ.get() == (ClassLoader)((ah)paramObject).iyQ.get()))
    {
      AppMethodBeat.o(118947);
      return true;
    }
    AppMethodBeat.o(118947);
    return false;
  }
  
  public final int hashCode()
  {
    return this.BQt;
  }
  
  public final String toString()
  {
    AppMethodBeat.i(118948);
    Object localObject = (ClassLoader)this.iyQ.get();
    if (localObject != null)
    {
      String str = ((ClassLoader)localObject).toString();
      localObject = str;
      if (str != null) {}
    }
    else
    {
      localObject = "<null>";
    }
    AppMethodBeat.o(118948);
    return localObject;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     a.j.b.a.ah
 * JD-Core Version:    0.7.0.1
 */