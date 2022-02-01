package com.tencent.mapsdk.internal;

import com.tencent.matrix.trace.core.AppMethodBeat;

public abstract class jf<D extends jh>
  extends jo<D>
  implements je<D>
{
  public final je<D> a()
  {
    return this;
  }
  
  public final void a(je.a<Boolean> parama)
  {
    jw.a(new jw.g()
    {
      private Boolean a()
      {
        AppMethodBeat.i(223725);
        jf.this.j();
        Boolean localBoolean = Boolean.TRUE;
        AppMethodBeat.o(223725);
        return localBoolean;
      }
    }).a(new jw.e(Boolean.FALSE)).b(parama);
  }
  
  public final void a(final String paramString, je.a<Boolean> parama)
  {
    jw.a(new jw.g()
    {
      private Boolean a()
      {
        AppMethodBeat.i(223694);
        boolean bool = jf.this.b(paramString);
        AppMethodBeat.o(223694);
        return Boolean.valueOf(bool);
      }
    }).a(new jw.e(Boolean.FALSE)).b(parama);
  }
  
  public final void a(final String paramString, final D paramD, je.a<Boolean> parama)
  {
    jw.a(new jw.g()
    {
      private Boolean a()
      {
        AppMethodBeat.i(223763);
        jf.this.b(paramString, paramD);
        Boolean localBoolean = Boolean.TRUE;
        AppMethodBeat.o(223763);
        return localBoolean;
      }
    }).a(new jw.e(Boolean.FALSE)).b(parama);
  }
  
  public final void a(final String paramString, final Class<D> paramClass, je.a<D> parama)
  {
    try
    {
      jh localjh = (jh)paramClass.newInstance();
      jw.a(new jw.g()
      {
        private D a()
        {
          AppMethodBeat.i(223799);
          jh localjh = jf.this.b(paramString, paramClass);
          AppMethodBeat.o(223799);
          return localjh;
        }
      }).a(new jw.e(localjh)).b(parama);
      return;
    }
    catch (IllegalAccessException paramString)
    {
      throw new Error("The " + paramClass.getSimpleName() + " must have a empty construct. #" + paramString.getMessage(), paramString);
    }
    catch (InstantiationException paramString)
    {
      throw new Error("The " + paramClass.getSimpleName() + " must have a empty construct. #" + paramString.getMessage(), paramString);
    }
  }
  
  public final void b(je.a<Long> parama)
  {
    jw.a(new jw.g()
    {
      private Long a()
      {
        AppMethodBeat.i(223649);
        long l = jf.this.k();
        AppMethodBeat.o(223649);
        return Long.valueOf(l);
      }
    }).a(new jw.e(Long.valueOf(0L))).b(parama);
  }
  
  public final void c(je.a<Long> parama)
  {
    jw.a(new jw.g()
    {
      private Long a()
      {
        AppMethodBeat.i(223669);
        long l = jf.this.l();
        AppMethodBeat.o(223669);
        return Long.valueOf(l);
      }
    }).a(new jw.e(Long.valueOf(0L))).b(parama);
  }
  
  public final void d(je.a<Long> parama)
  {
    jw.a(new jw.g()
    {
      private Long a()
      {
        AppMethodBeat.i(223621);
        long l = jf.this.e();
        AppMethodBeat.o(223621);
        return Long.valueOf(l);
      }
    }).a(new jw.e(Long.valueOf(0L))).b(parama);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes11.jar
 * Qualified Name:     com.tencent.mapsdk.internal.jf
 * JD-Core Version:    0.7.0.1
 */