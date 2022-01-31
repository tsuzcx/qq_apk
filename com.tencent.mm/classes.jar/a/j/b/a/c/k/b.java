package a.j.b.a.c.k;

import a.f.b.j;
import a.l.m;
import a.y;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class b
  implements i
{
  public static final i CAv;
  private static final String PACKAGE_NAME;
  private final b.c CAw;
  private final String CAx;
  protected final Lock mHZ;
  
  static
  {
    AppMethodBeat.i(122473);
    boolean bool;
    String str;
    int i;
    if (!b.class.desiredAssertionStatus())
    {
      bool = true;
      $assertionsDisabled = bool;
      str = b.class.getCanonicalName();
      j.q(str, "receiver$0");
      j.q(".", "delimiter");
      j.q("", "missingDelimiterValue");
      i = m.d((CharSequence)str, ".");
      if (i != -1) {
        break label96;
      }
      str = "";
    }
    for (;;)
    {
      PACKAGE_NAME = str;
      CAv = new b.1("NO_LOCKS", b.c.CAC, e.CAN);
      AppMethodBeat.o(122473);
      return;
      bool = false;
      break;
      label96:
      str = str.substring(0, i);
      j.p(str, "(this as java.lang.Strin…ing(startIndex, endIndex)");
    }
  }
  
  public b()
  {
    this("<unknown creating class>", b.c.CAC, new ReentrantLock());
    AppMethodBeat.i(122460);
    AppMethodBeat.o(122460);
  }
  
  private b(String paramString, b.c paramc, Lock paramLock)
  {
    this.mHZ = paramLock;
    this.CAw = paramc;
    this.CAx = paramString;
  }
  
  private static <K> ConcurrentMap<K, Object> eoA()
  {
    AppMethodBeat.i(122468);
    ConcurrentHashMap localConcurrentHashMap = new ConcurrentHashMap(3, 1.0F, 2);
    AppMethodBeat.o(122468);
    return localConcurrentHashMap;
  }
  
  private static <T extends Throwable> T o(T paramT)
  {
    AppMethodBeat.i(122470);
    Object localObject = paramT.getStackTrace();
    int j = localObject.length;
    int i = 0;
    if (i < j) {
      if (localObject[i].getClassName().startsWith(PACKAGE_NAME)) {}
    }
    for (;;)
    {
      if ((!$assertionsDisabled) && (i < 0))
      {
        paramT = new AssertionError("This method should only be called on exceptions created in LockBasedStorageManager");
        AppMethodBeat.o(122470);
        throw paramT;
        i += 1;
        break;
      }
      localObject = Arrays.asList((Object[])localObject).subList(i, j);
      paramT.setStackTrace((StackTraceElement[])((List)localObject).toArray(new StackTraceElement[((List)localObject).size()]));
      AppMethodBeat.o(122470);
      return paramT;
      i = -1;
    }
  }
  
  public final <T> f<T> a(a.f.a.a<? extends T> parama, a.f.a.b<? super Boolean, ? extends T> paramb, a.f.a.b<? super T, y> paramb1)
  {
    AppMethodBeat.i(122466);
    parama = new b.3(this, this, parama, paramb, paramb1);
    AppMethodBeat.o(122466);
    return parama;
  }
  
  public final <T> f<T> a(a.f.a.a<? extends T> parama, T paramT)
  {
    AppMethodBeat.i(122465);
    parama = new b.2(this, this, parama, paramT);
    AppMethodBeat.o(122465);
    return parama;
  }
  
  protected <T> b.j<T> eoB()
  {
    AppMethodBeat.i(122469);
    IllegalStateException localIllegalStateException = (IllegalStateException)o(new IllegalStateException("Recursive call in a lazy value under ".concat(String.valueOf(this))));
    AppMethodBeat.o(122469);
    throw localIllegalStateException;
  }
  
  public final <K, V> a<K, V> eoC()
  {
    AppMethodBeat.i(122471);
    b.a locala = new b.a(this, eoA(), (byte)0);
    AppMethodBeat.o(122471);
    return locala;
  }
  
  public final <K, V> c<K, V> i(a.f.a.b<? super K, ? extends V> paramb)
  {
    AppMethodBeat.i(122462);
    paramb = new b.h(this, eoA(), paramb);
    AppMethodBeat.o(122462);
    return paramb;
  }
  
  public final <K, V> d<K, V> j(a.f.a.b<? super K, ? extends V> paramb)
  {
    AppMethodBeat.i(122463);
    paramb = new b.g(this, eoA(), paramb);
    AppMethodBeat.o(122463);
    return paramb;
  }
  
  public final <T> f<T> l(a.f.a.a<? extends T> parama)
  {
    AppMethodBeat.i(122464);
    parama = new b.f(this, parama);
    AppMethodBeat.o(122464);
    return parama;
  }
  
  public final <T> g<T> m(a.f.a.a<? extends T> parama)
  {
    AppMethodBeat.i(122467);
    parama = new b.e(this, parama);
    AppMethodBeat.o(122467);
    return parama;
  }
  
  public String toString()
  {
    AppMethodBeat.i(122461);
    String str = getClass().getSimpleName() + "@" + Integer.toHexString(hashCode()) + " (" + this.CAx + ")";
    AppMethodBeat.o(122461);
    return str;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     a.j.b.a.c.k.b
 * JD-Core Version:    0.7.0.1
 */