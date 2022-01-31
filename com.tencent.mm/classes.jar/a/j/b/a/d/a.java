package a.j.b.a.d;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.Iterator;
import java.util.NoSuchElementException;

public final class a<E>
  implements Iterable<E>
{
  private static final a<Object> CFo;
  public final a<E> CFp;
  public final E first;
  public final int size;
  
  static
  {
    AppMethodBeat.i(122989);
    CFo = new a();
    AppMethodBeat.o(122989);
  }
  
  private a()
  {
    this.size = 0;
    this.first = null;
    this.CFp = null;
  }
  
  private a(E paramE, a<E> parama)
  {
    AppMethodBeat.i(122981);
    this.first = paramE;
    this.CFp = parama;
    parama.size += 1;
    AppMethodBeat.o(122981);
  }
  
  private Iterator<E> Wa(int paramInt)
  {
    AppMethodBeat.i(122984);
    a.a locala = new a.a(Wc(paramInt));
    AppMethodBeat.o(122984);
    return locala;
  }
  
  private a<E> Wc(int paramInt)
  {
    AppMethodBeat.i(122988);
    Object localObject = this;
    for (;;)
    {
      if ((paramInt < 0) || (paramInt > ((a)localObject).size))
      {
        localObject = new IndexOutOfBoundsException();
        AppMethodBeat.o(122988);
        throw ((Throwable)localObject);
      }
      if (paramInt == 0)
      {
        AppMethodBeat.o(122988);
        return localObject;
      }
      localObject = ((a)localObject).CFp;
      paramInt -= 1;
    }
  }
  
  private a<E> dV(Object paramObject)
  {
    AppMethodBeat.i(122986);
    if (this.size == 0)
    {
      AppMethodBeat.o(122986);
      return this;
    }
    if (this.first.equals(paramObject))
    {
      paramObject = this.CFp;
      AppMethodBeat.o(122986);
      return paramObject;
    }
    paramObject = this.CFp.dV(paramObject);
    if (paramObject == this.CFp)
    {
      AppMethodBeat.o(122986);
      return this;
    }
    paramObject = new a(this.first, paramObject);
    AppMethodBeat.o(122986);
    return paramObject;
  }
  
  public static <E> a<E> epc()
  {
    return CFo;
  }
  
  private E get(int paramInt)
  {
    AppMethodBeat.i(122982);
    Object localObject;
    if ((paramInt < 0) || (paramInt > this.size))
    {
      localObject = new IndexOutOfBoundsException();
      AppMethodBeat.o(122982);
      throw ((Throwable)localObject);
    }
    try
    {
      localObject = Wa(paramInt).next();
      AppMethodBeat.o(122982);
      return localObject;
    }
    catch (NoSuchElementException localNoSuchElementException)
    {
      IndexOutOfBoundsException localIndexOutOfBoundsException = new IndexOutOfBoundsException("Index: ".concat(String.valueOf(paramInt)));
      AppMethodBeat.o(122982);
      throw localIndexOutOfBoundsException;
    }
  }
  
  public final a<E> Wb(int paramInt)
  {
    AppMethodBeat.i(122987);
    a locala = dV(get(paramInt));
    AppMethodBeat.o(122987);
    return locala;
  }
  
  public final a<E> dU(E paramE)
  {
    AppMethodBeat.i(122985);
    paramE = new a(paramE, this);
    AppMethodBeat.o(122985);
    return paramE;
  }
  
  public final Iterator<E> iterator()
  {
    AppMethodBeat.i(122983);
    Iterator localIterator = Wa(0);
    AppMethodBeat.o(122983);
    return localIterator;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     a.j.b.a.d.a
 * JD-Core Version:    0.7.0.1
 */