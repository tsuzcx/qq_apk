package android.support.v7.widget;

import java.util.Arrays;

final class StaggeredGridLayoutManager$a
{
  int El;
  boolean aen;
  boolean aeo;
  int[] akA;
  boolean akz;
  int mPosition;
  
  final void reset()
  {
    this.mPosition = -1;
    this.El = -2147483648;
    this.aen = false;
    this.akz = false;
    this.aeo = false;
    if (this.akA != null) {
      Arrays.fill(this.akA, -1);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     android.support.v7.widget.StaggeredGridLayoutManager.a
 * JD-Core Version:    0.7.0.1
 */