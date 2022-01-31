package android.support.v7.widget;

import android.util.Pair;
import java.lang.reflect.Array;
import java.util.ArrayList;

final class GridLayout$c<K, V>
  extends ArrayList<Pair<K, V>>
{
  private final Class<K> aeF;
  private final Class<V> aeG;
  
  private GridLayout$c(Class<K> paramClass, Class<V> paramClass1)
  {
    this.aeF = paramClass;
    this.aeG = paramClass1;
  }
  
  public static <K, V> c<K, V> a(Class<K> paramClass, Class<V> paramClass1)
  {
    return new c(paramClass, paramClass1);
  }
  
  public final void d(K paramK, V paramV)
  {
    add(Pair.create(paramK, paramV));
  }
  
  public final GridLayout.h<K, V> hR()
  {
    int j = size();
    Object[] arrayOfObject1 = (Object[])Array.newInstance(this.aeF, j);
    Object[] arrayOfObject2 = (Object[])Array.newInstance(this.aeG, j);
    int i = 0;
    while (i < j)
    {
      arrayOfObject1[i] = ((Pair)get(i)).first;
      arrayOfObject2[i] = ((Pair)get(i)).second;
      i += 1;
    }
    return new GridLayout.h(arrayOfObject1, arrayOfObject2);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     android.support.v7.widget.GridLayout.c
 * JD-Core Version:    0.7.0.1
 */