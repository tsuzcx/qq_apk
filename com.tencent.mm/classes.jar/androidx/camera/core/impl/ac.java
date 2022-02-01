package androidx.camera.core.impl;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.Set;

public abstract interface ac
{
  public abstract <ValueT> ValueT a(a<ValueT> parama, c paramc);
  
  public abstract void a(String paramString, b paramb);
  
  public abstract boolean a(a<?> parama);
  
  public abstract <ValueT> ValueT b(a<ValueT> parama);
  
  public abstract <ValueT> ValueT b(a<ValueT> parama, ValueT paramValueT);
  
  public abstract c c(a<?> parama);
  
  public abstract Set<c> d(a<?> parama);
  
  public abstract Set<a<?>> ke();
  
  public static abstract class a<T>
  {
    public static <T> a<T> a(String paramString, Class<?> paramClass, Object paramObject)
    {
      return new b(paramString, paramClass, paramObject);
    }
    
    public abstract String getId();
    
    public abstract Class<T> jM();
    
    public abstract Object jN();
  }
  
  public static abstract interface b
  {
    public abstract boolean onOptionMatched(ac.a<?> parama);
  }
  
  public static enum c
  {
    static
    {
      AppMethodBeat.i(198698);
      Mb = new c("ALWAYS_OVERRIDE", 0);
      Mc = new c("REQUIRED", 1);
      Md = new c("OPTIONAL", 2);
      Me = new c[] { Mb, Mc, Md };
      AppMethodBeat.o(198698);
    }
    
    private c() {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     androidx.camera.core.impl.ac
 * JD-Core Version:    0.7.0.1
 */