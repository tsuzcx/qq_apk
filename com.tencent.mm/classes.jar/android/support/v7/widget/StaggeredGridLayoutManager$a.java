package android.support.v7.widget;

import java.util.Arrays;

final class StaggeredGridLayoutManager$a
{
  int Fb;
  boolean agA;
  boolean agB;
  boolean amS;
  int[] amT;
  int mPosition;
  
  final void reset()
  {
    this.mPosition = -1;
    this.Fb = -2147483648;
    this.agA = false;
    this.amS = false;
    this.agB = false;
    if (this.amT != null) {
      Arrays.fill(this.amT, -1);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     android.support.v7.widget.StaggeredGridLayoutManager.a
 * JD-Core Version:    0.7.0.1
 */