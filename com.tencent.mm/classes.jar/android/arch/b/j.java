package android.arch.b;

import java.util.AbstractList;
import java.util.ArrayList;
import java.util.List;

final class j<T>
  extends AbstractList<T>
{
  private static final List fa = new ArrayList();
  private int eU;
  int fb;
  final ArrayList<List<T>> fc;
  int fe;
  private int ff;
  int fg;
  int fh;
  int fi;
  
  j()
  {
    this.fb = 0;
    this.fc = new ArrayList();
    this.fe = 0;
    this.ff = 0;
    this.fg = 0;
    this.eU = 1;
    this.fh = 0;
    this.fi = 0;
  }
  
  j(j<T> paramj)
  {
    this.fb = paramj.fb;
    this.fc = new ArrayList(paramj.fc);
    this.fe = paramj.fe;
    this.ff = paramj.ff;
    this.fg = paramj.fg;
    this.eU = paramj.eU;
    this.fh = paramj.fh;
    this.fi = paramj.fi;
  }
  
  final int ax()
  {
    int j = this.fb;
    int k = this.fc.size();
    int i = 0;
    while (i < k)
    {
      List localList = (List)this.fc.get(i);
      if ((localList != null) && (localList != fa)) {
        break;
      }
      j += this.eU;
      i += 1;
    }
    return j;
  }
  
  final int ay()
  {
    int j = this.fe;
    int i = this.fc.size() - 1;
    while (i >= 0)
    {
      List localList = (List)this.fc.get(i);
      if ((localList != null) && (localList != fa)) {
        break;
      }
      j += this.eU;
      i -= 1;
    }
    return j;
  }
  
  public final T get(int paramInt)
  {
    int i = 0;
    if ((paramInt < 0) || (paramInt >= size())) {
      throw new IndexOutOfBoundsException("Index: " + paramInt + ", Size: " + size());
    }
    int j = paramInt - this.fb;
    if ((j < 0) || (j >= this.fg)) {
      return null;
    }
    if (this.eU > 0)
    {
      paramInt = 1;
      if (paramInt == 0) {
        break label133;
      }
      i = j / this.eU;
      paramInt = j % this.eU;
    }
    for (;;)
    {
      List localList = (List)this.fc.get(i);
      label133:
      int k;
      if ((localList == null) || (localList.size() == 0))
      {
        return null;
        paramInt = 0;
        break;
        k = this.fc.size();
        paramInt = j;
      }
      while (i < k)
      {
        j = ((List)this.fc.get(i)).size();
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
    return this.fb + this.fg + this.fe;
  }
  
  public final String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder("leading " + this.fb + ", storage " + this.fg + ", trailing " + this.fe);
    int i = 0;
    while (i < this.fc.size())
    {
      localStringBuilder.append(" ").append(this.fc.get(i));
      i += 1;
    }
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     android.arch.b.j
 * JD-Core Version:    0.7.0.1
 */