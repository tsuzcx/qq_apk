package android.support.v7.widget;

final class aa$2
  extends RecyclerView.m
{
  aa$2(aa paramaa) {}
  
  public final void a(RecyclerView paramRecyclerView, int paramInt1, int paramInt2)
  {
    aa localaa = this.acR;
    paramInt1 = paramRecyclerView.computeHorizontalScrollOffset();
    paramInt2 = paramRecyclerView.computeVerticalScrollOffset();
    int i = localaa.acI.computeVerticalScrollRange();
    int j = localaa.acH;
    boolean bool;
    int k;
    int m;
    if ((i - j > 0) && (localaa.acH >= localaa.acq))
    {
      bool = true;
      localaa.acJ = bool;
      k = localaa.acI.computeHorizontalScrollRange();
      m = localaa.acG;
      if ((k - m <= 0) || (localaa.acG < localaa.acq)) {
        break label149;
      }
      bool = true;
      label105:
      localaa.acK = bool;
      if ((localaa.acJ) || (localaa.acK)) {
        break label155;
      }
      if (localaa.mState != 0) {
        localaa.setState(0);
      }
    }
    label149:
    label155:
    do
    {
      return;
      bool = false;
      break;
      bool = false;
      break label105;
      if (localaa.acJ)
      {
        localaa.acB = ((int)((paramInt2 + j / 2.0F) * j / i));
        localaa.acA = Math.min(j, j * j / i);
      }
      if (localaa.acK)
      {
        localaa.acE = ((int)((paramInt1 + m / 2.0F) * m / k));
        localaa.acD = Math.min(m, m * m / k);
      }
    } while ((localaa.mState != 0) && (localaa.mState != 1));
    localaa.setState(1);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     android.support.v7.widget.aa.2
 * JD-Core Version:    0.7.0.1
 */