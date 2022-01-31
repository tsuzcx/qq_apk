package android.support.v7.widget.a;

import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.RecyclerView.d;

final class a$5
  implements RecyclerView.d
{
  a$5(a parama) {}
  
  public final int av(int paramInt1, int paramInt2)
  {
    if (this.aqr.aql == null) {}
    int i;
    do
    {
      return paramInt2;
      int j = this.aqr.aqm;
      i = j;
      if (j == -1)
      {
        i = this.aqr.adt.indexOfChild(this.aqr.aql);
        this.aqr.aqm = i;
      }
      if (paramInt2 == paramInt1 - 1) {
        return i;
      }
    } while (paramInt2 < i);
    return paramInt2 + 1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     android.support.v7.widget.a.a.5
 * JD-Core Version:    0.7.0.1
 */