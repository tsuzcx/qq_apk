package android.support.v7.widget;

final class GridLayout$d$1
{
  GridLayout.b[] aff = new GridLayout.b[this.afj.length];
  int afg = this.aff.length - 1;
  GridLayout.b[][] afh = this.afk.a(this.afj);
  int[] afi = new int[this.afk.getCount() + 1];
  
  static
  {
    if (!GridLayout.class.desiredAssertionStatus()) {}
    for (boolean bool = true;; bool = false)
    {
      $assertionsDisabled = bool;
      return;
    }
  }
  
  GridLayout$d$1(GridLayout.d paramd, GridLayout.b[] paramArrayOfb) {}
  
  final void bB(int paramInt)
  {
    switch (this.afi[paramInt])
    {
    }
    do
    {
      return;
      this.afi[paramInt] = 1;
      GridLayout.b[] arrayOfb1 = this.afh[paramInt];
      int j = arrayOfb1.length;
      int i = 0;
      while (i < j)
      {
        GridLayout.b localb = arrayOfb1[i];
        bB(localb.aeC.max);
        GridLayout.b[] arrayOfb2 = this.aff;
        int k = this.afg;
        this.afg = (k - 1);
        arrayOfb2[k] = localb;
        i += 1;
      }
      this.afi[paramInt] = 2;
      return;
    } while ($assertionsDisabled);
    throw new AssertionError();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     android.support.v7.widget.GridLayout.d.1
 * JD-Core Version:    0.7.0.1
 */