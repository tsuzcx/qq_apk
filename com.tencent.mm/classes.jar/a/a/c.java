package a.a;

import a.f.b.a.e;
import a.l;
import java.util.AbstractList;
import java.util.List;

@l(eaO={1, 1, 13}, eaP={""}, eaQ={"Lkotlin/collections/AbstractMutableList;", "E", "", "Ljava/util/AbstractList;", "()V", "add", "", "index", "", "element", "(ILjava/lang/Object;)V", "removeAt", "(I)Ljava/lang/Object;", "set", "(ILjava/lang/Object;)Ljava/lang/Object;", "kotlin-stdlib"})
public abstract class c<E>
  extends AbstractList<E>
  implements e, List<E>
{
  public abstract int getSize();
  
  public final E remove(int paramInt)
  {
    return removeAt(paramInt);
  }
  
  public abstract E removeAt(int paramInt);
  
  public final int size()
  {
    return getSize();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     a.a.c
 * JD-Core Version:    0.7.0.1
 */