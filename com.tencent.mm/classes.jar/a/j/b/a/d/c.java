package a.j.b.a.d;

import com.tencent.matrix.trace.core.AppMethodBeat;

final class c<V>
{
  static final c<Object> CFt;
  private final c<V> CFu;
  private final c<V> CFv;
  private final long key;
  private final int size;
  private final V value;
  
  static
  {
    AppMethodBeat.i(122999);
    CFt = new c();
    AppMethodBeat.o(122999);
  }
  
  private c()
  {
    this.size = 0;
    this.key = 0L;
    this.value = null;
    this.CFu = null;
    this.CFv = null;
  }
  
  private c(long paramLong, V paramV, c<V> paramc1, c<V> paramc2)
  {
    AppMethodBeat.i(122994);
    this.key = paramLong;
    this.value = paramV;
    this.CFu = paramc1;
    this.CFv = paramc2;
    this.size = (paramc1.size + 1 + paramc2.size);
    AppMethodBeat.o(122994);
  }
  
  private static <V> c<V> a(long paramLong, V paramV, c<V> paramc1, c<V> paramc2)
  {
    AppMethodBeat.i(122998);
    if (paramc1.size + paramc2.size > 1)
    {
      c localc3;
      c localc1;
      c localc2;
      Object localObject;
      if (paramc1.size >= paramc2.size * 5)
      {
        localc3 = paramc1.CFu;
        localc1 = paramc1.CFv;
        if (localc1.size < localc3.size * 2)
        {
          paramV = new c(paramc1.key + paramLong, paramc1.value, localc3, new c(-paramc1.key, paramV, localc1.pu(localc1.key + paramc1.key), paramc2));
          AppMethodBeat.o(122998);
          return paramV;
        }
        c localc4 = localc1.CFu;
        localc2 = localc1.CFv;
        long l1 = localc1.key;
        long l2 = paramc1.key;
        localObject = localc1.value;
        localc3 = new c(-localc1.key, paramc1.value, localc3, localc4.pu(localc4.key + localc1.key));
        long l3 = -paramc1.key;
        long l4 = localc1.key;
        long l5 = localc2.key;
        paramV = new c(l1 + l2 + paramLong, localObject, localc3, new c(l3 - l4, paramV, localc2.pu(localc1.key + l5 + paramc1.key), paramc2));
        AppMethodBeat.o(122998);
        return paramV;
      }
      if (paramc2.size >= paramc1.size * 5)
      {
        localc1 = paramc2.CFu;
        localc2 = paramc2.CFv;
        if (localc1.size < localc2.size * 2)
        {
          paramV = new c(paramc2.key + paramLong, paramc2.value, new c(-paramc2.key, paramV, paramc1, localc1.pu(localc1.key + paramc2.key)), localc2);
          AppMethodBeat.o(122998);
          return paramV;
        }
        localObject = localc1.CFu;
        localc3 = localc1.CFv;
        paramV = new c(localc1.key + paramc2.key + paramLong, localc1.value, new c(-paramc2.key - localc1.key, paramV, paramc1, ((c)localObject).pu(((c)localObject).key + localc1.key + paramc2.key)), new c(-localc1.key, paramc2.value, localc3.pu(localc3.key + localc1.key), localc2));
        AppMethodBeat.o(122998);
        return paramV;
      }
    }
    paramV = new c(paramLong, paramV, paramc1, paramc2);
    AppMethodBeat.o(122998);
    return paramV;
  }
  
  private c<V> a(c<V> paramc1, c<V> paramc2)
  {
    AppMethodBeat.i(122997);
    if ((paramc1 == this.CFu) && (paramc2 == this.CFv))
    {
      AppMethodBeat.o(122997);
      return this;
    }
    paramc1 = a(this.key, this.value, paramc1, paramc2);
    AppMethodBeat.o(122997);
    return paramc1;
  }
  
  private c<V> pu(long paramLong)
  {
    AppMethodBeat.i(122995);
    if ((this.size == 0) || (paramLong == this.key))
    {
      AppMethodBeat.o(122995);
      return this;
    }
    c localc = new c(paramLong, this.value, this.CFu, this.CFv);
    AppMethodBeat.o(122995);
    return localc;
  }
  
  final c<V> b(long paramLong, V paramV)
  {
    AppMethodBeat.i(122996);
    if (this.size == 0)
    {
      paramV = new c(paramLong, paramV, this, this);
      AppMethodBeat.o(122996);
      return paramV;
    }
    if (paramLong < this.key)
    {
      paramV = a(this.CFu.b(paramLong - this.key, paramV), this.CFv);
      AppMethodBeat.o(122996);
      return paramV;
    }
    if (paramLong > this.key)
    {
      paramV = a(this.CFu, this.CFv.b(paramLong - this.key, paramV));
      AppMethodBeat.o(122996);
      return paramV;
    }
    if (paramV == this.value)
    {
      AppMethodBeat.o(122996);
      return this;
    }
    paramV = new c(paramLong, paramV, this.CFu, this.CFv);
    AppMethodBeat.o(122996);
    return paramV;
  }
  
  final V get(long paramLong)
  {
    Object localObject = this;
    for (;;)
    {
      if (((c)localObject).size == 0) {
        return null;
      }
      c localc;
      if (paramLong < ((c)localObject).key)
      {
        localc = ((c)localObject).CFu;
        paramLong -= ((c)localObject).key;
        localObject = localc;
      }
      else
      {
        if (paramLong <= ((c)localObject).key) {
          break;
        }
        localc = ((c)localObject).CFv;
        paramLong -= ((c)localObject).key;
        localObject = localc;
      }
    }
    return ((c)localObject).value;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     a.j.b.a.d.c
 * JD-Core Version:    0.7.0.1
 */