package android.arch.b;

import java.util.AbstractList;
import java.util.ArrayList;
import java.util.List;

final class j<T>
  extends AbstractList<T>
{
  private static final List eZ = new ArrayList();
  private int eT;
  int fe;
  final ArrayList<List<T>> ff;
  int fg;
  private int fh;
  int fi;
  int fj;
  int fk;
  
  j()
  {
    this.fe = 0;
    this.ff = new ArrayList();
    this.fg = 0;
    this.fh = 0;
    this.fi = 0;
    this.eT = 1;
    this.fj = 0;
    this.fk = 0;
  }
  
  j(j<T> paramj)
  {
    this.fe = paramj.fe;
    this.ff = new ArrayList(paramj.ff);
    this.fg = paramj.fg;
    this.fh = paramj.fh;
    this.fi = paramj.fi;
    this.eT = paramj.eT;
    this.fj = paramj.fj;
    this.fk = paramj.fk;
  }
  
  final int aA()
  {
    int j = this.fg;
    int i = this.ff.size() - 1;
    while (i >= 0)
    {
      List localList = (List)this.ff.get(i);
      if ((localList != null) && (localList != eZ)) {
        break;
      }
      j += this.eT;
      i -= 1;
    }
    return j;
  }
  
  final int az()
  {
    int j = this.fe;
    int k = this.ff.size();
    int i = 0;
    while (i < k)
    {
      List localList = (List)this.ff.get(i);
      if ((localList != null) && (localList != eZ)) {
        break;
      }
      j += this.eT;
      i += 1;
    }
    return j;
  }
  
  public final T get(int paramInt)
  {
    int i = 0;
    if ((paramInt < 0) || (paramInt >= size())) {
      throw new IndexOutOfBoundsException("Index: " + paramInt + ", Size: " + size());
    }
    int j = paramInt - this.fe;
    if ((j < 0) || (j >= this.fi)) {
      return null;
    }
    if (this.eT > 0)
    {
      paramInt = 1;
      if (paramInt == 0) {
        break label133;
      }
      i = j / this.eT;
      paramInt = j % this.eT;
    }
    for (;;)
    {
      List localList = (List)this.ff.get(i);
      label133:
      int k;
      if ((localList == null) || (localList.size() == 0))
      {
        return null;
        paramInt = 0;
        break;
        k = this.ff.size();
        paramInt = j;
      }
      while (i < k)
      {
        j = ((List)this.ff.get(i)).size();
        if (j <= paramInt)
        {
          paramInt -= j;
          i += 1;
          continue;
          return localList.get(paramInt);
        }
      }
    }
  }
  
  public final int size()
  {
    return this.fe + this.fi + this.fg;
  }
  
  public final String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder("leading " + this.fe + ", storage " + this.fi + ", trailing " + this.fg);
    int i = 0;
    while (i < this.ff.size())
    {
      localStringBuilder.append(" ").append(this.ff.get(i));
      i += 1;
    }
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     android.arch.b.j
 * JD-Core Version:    0.7.0.1
 */