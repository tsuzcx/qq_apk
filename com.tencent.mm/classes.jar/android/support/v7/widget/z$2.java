package android.support.v7.widget;

final class z$2
  extends RecyclerView.m
{
  z$2(z paramz) {}
  
  public final void a(RecyclerView paramRecyclerView, int paramInt1, int paramInt2)
  {
    z localz = this.adB;
    paramInt1 = paramRecyclerView.computeHorizontalScrollOffset();
    paramInt2 = paramRecyclerView.computeVerticalScrollOffset();
    int i = localz.adt.computeVerticalScrollRange();
    int j = localz.ads;
    boolean bool;
    int k;
    int m;
    if ((i - j > 0) && (localz.ads >= localz.adc))
    {
      bool = true;
      localz.adu = bool;
      k = localz.adt.computeHorizontalScrollRange();
      m = localz.adr;
      if ((k - m <= 0) || (localz.adr < localz.adc)) {
        break label149;
      }
      bool = true;
      label105:
      localz.adv = bool;
      if ((localz.adu) || (localz.adv)) {
        break label155;
      }
      if (localz.mState != 0) {
        localz.setState(0);
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
      if (localz.adu)
      {
        localz.adm = ((int)((paramInt2 + j / 2.0F) * j / i));
        localz.adl = Math.min(j, j * j / i);
      }
      if (localz.adv)
      {
        localz.adp = ((int)((paramInt1 + m / 2.0F) * m / k));
        localz.ado = Math.min(m, m * m / k);
      }
    } while ((localz.mState != 0) && (localz.mState != 1));
    localz.setState(1);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     android.support.v7.widget.z.2
 * JD-Core Version:    0.7.0.1
 */