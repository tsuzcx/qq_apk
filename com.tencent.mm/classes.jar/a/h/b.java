package a.h;

import a.f.b.j;
import a.j.k;
import a.l;

@l(eaO={1, 1, 13}, eaP={""}, eaQ={"Lkotlin/properties/ObservableProperty;", "T", "Lkotlin/properties/ReadWriteProperty;", "", "initialValue", "(Ljava/lang/Object;)V", "value", "Ljava/lang/Object;", "afterChange", "", "property", "Lkotlin/reflect/KProperty;", "oldValue", "newValue", "(Lkotlin/reflect/KProperty;Ljava/lang/Object;Ljava/lang/Object;)V", "beforeChange", "", "(Lkotlin/reflect/KProperty;Ljava/lang/Object;Ljava/lang/Object;)Z", "getValue", "thisRef", "(Ljava/lang/Object;Lkotlin/reflect/KProperty;)Ljava/lang/Object;", "setValue", "(Ljava/lang/Object;Lkotlin/reflect/KProperty;Ljava/lang/Object;)V", "kotlin-stdlib"})
public abstract class b<T>
  implements c<Object, T>
{
  private T value;
  
  public b(T paramT)
  {
    this.value = paramT;
  }
  
  public final T a(k<?> paramk)
  {
    j.q(paramk, "property");
    return this.value;
  }
  
  public final void a(k<?> paramk, T paramT)
  {
    j.q(paramk, "property");
    b(paramk);
    this.value = paramT;
    j.q(paramk, "property");
  }
  
  protected boolean b(k<?> paramk)
  {
    j.q(paramk, "property");
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     a.h.b
 * JD-Core Version:    0.7.0.1
 */