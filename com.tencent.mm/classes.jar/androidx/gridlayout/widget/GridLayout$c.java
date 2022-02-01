package androidx.gridlayout.widget;

import android.util.Pair;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.lang.reflect.Array;
import java.util.ArrayList;

final class GridLayout$c<K, V>
  extends ArrayList<Pair<K, V>>
{
  private final Class<K> Yn;
  private final Class<V> Yo;
  
  private GridLayout$c(Class<K> paramClass, Class<V> paramClass1)
  {
    this.Yn = paramClass;
    this.Yo = paramClass1;
  }
  
  public static <K, V> c<K, V> a(Class<K> paramClass, Class<V> paramClass1)
  {
    AppMethodBeat.i(255442);
    paramClass = new c(paramClass, paramClass1);
    AppMethodBeat.o(255442);
    return paramClass;
  }
  
  public final void e(K paramK, V paramV)
  {
    AppMethodBeat.i(255444);
    add(Pair.create(paramK, paramV));
    AppMethodBeat.o(255444);
  }
  
  public final GridLayout.h<K, V> iP()
  {
    AppMethodBeat.i(255446);
    int j = size();
    Object localObject = (Object[])Array.newInstance(this.Yn, j);
    Object[] arrayOfObject = (Object[])Array.newInstance(this.Yo, j);
    int i = 0;
    while (i < j)
    {
      localObject[i] = ((Pair)get(i)).first;
      arrayOfObject[i] = ((Pair)get(i)).second;
      i += 1;
    }
    localObject = new GridLayout.h((Object[])localObject, arrayOfObject);
    AppMethodBeat.o(255446);
    return localObject;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     androidx.gridlayout.widget.GridLayout.c
 * JD-Core Version:    0.7.0.1
 */