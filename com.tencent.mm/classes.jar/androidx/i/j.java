package androidx.i;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.AbstractList;
import java.util.ArrayList;
import java.util.List;

final class j<T>
  extends AbstractList<T>
{
  private static final List aen;
  private int aeh;
  int aeo;
  final ArrayList<List<T>> aep;
  int aeq;
  private int aer;
  int aes;
  int aet;
  int aeu;
  
  static
  {
    AppMethodBeat.i(219579);
    aen = new ArrayList();
    AppMethodBeat.o(219579);
  }
  
  j()
  {
    AppMethodBeat.i(219548);
    this.aeo = 0;
    this.aep = new ArrayList();
    this.aeq = 0;
    this.aer = 0;
    this.aes = 0;
    this.aeh = 1;
    this.aet = 0;
    this.aeu = 0;
    AppMethodBeat.o(219548);
  }
  
  j(j<T> paramj)
  {
    AppMethodBeat.i(219555);
    this.aeo = paramj.aeo;
    this.aep = new ArrayList(paramj.aep);
    this.aeq = paramj.aeq;
    this.aer = paramj.aer;
    this.aes = paramj.aes;
    this.aeh = paramj.aeh;
    this.aet = paramj.aet;
    this.aeu = paramj.aeu;
    AppMethodBeat.o(219555);
  }
  
  public final T get(int paramInt)
  {
    int i = 0;
    AppMethodBeat.i(219561);
    Object localObject;
    if ((paramInt < 0) || (paramInt >= size()))
    {
      localObject = new IndexOutOfBoundsException("Index: " + paramInt + ", Size: " + size());
      AppMethodBeat.o(219561);
      throw ((Throwable)localObject);
    }
    int j = paramInt - this.aeo;
    if ((j < 0) || (j >= this.aes))
    {
      AppMethodBeat.o(219561);
      return null;
    }
    if (this.aeh > 0)
    {
      paramInt = 1;
      if (paramInt == 0) {
        break label157;
      }
      i = j / this.aeh;
      paramInt = j % this.aeh;
    }
    for (;;)
    {
      localObject = (List)this.aep.get(i);
      label157:
      int k;
      if ((localObject == null) || (((List)localObject).size() == 0))
      {
        AppMethodBeat.o(219561);
        return null;
        paramInt = 0;
        break;
        k = this.aep.size();
        paramInt = j;
      }
      while (i < k)
      {
        j = ((List)this.aep.get(i)).size();
        if (j <= paramInt)
        {
          paramInt -= j;
          i += 1;
          continue;
          localObject = ((List)localObject).get(paramInt);
          AppMethodBeat.o(219561);
          return localObject;
        }
      }
    }
  }
  
  final int jJ()
  {
    AppMethodBeat.i(219568);
    int j = this.aeo;
    int k = this.aep.size();
    int i = 0;
    while (i < k)
    {
      List localList = (List)this.aep.get(i);
      if ((localList != null) && (localList != aen)) {
        break;
      }
      j += this.aeh;
      i += 1;
    }
    AppMethodBeat.o(219568);
    return j;
  }
  
  final int jK()
  {
    AppMethodBeat.i(219571);
    int j = this.aeq;
    int i = this.aep.size() - 1;
    while (i >= 0)
    {
      List localList = (List)this.aep.get(i);
      if ((localList != null) && (localList != aen)) {
        break;
      }
      j += this.aeh;
      i -= 1;
    }
    AppMethodBeat.o(219571);
    return j;
  }
  
  public final int size()
  {
    return this.aeo + this.aes + this.aeq;
  }
  
  public final String toString()
  {
    AppMethodBeat.i(219576);
    Object localObject = new StringBuilder("leading " + this.aeo + ", storage " + this.aes + ", trailing " + this.aeq);
    int i = 0;
    while (i < this.aep.size())
    {
      ((StringBuilder)localObject).append(" ").append(this.aep.get(i));
      i += 1;
    }
    localObject = ((StringBuilder)localObject).toString();
    AppMethodBeat.o(219576);
    return localObject;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     androidx.i.j
 * JD-Core Version:    0.7.0.1
 */