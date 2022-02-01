package android.support.a;

public final class d
  extends b<d>
{
  private e gh = null;
  private float gi = 3.4028235E+38F;
  private boolean gj = false;
  
  public <K> d(K paramK, c<K> paramc)
  {
    super(paramK, paramc);
  }
  
  public <K> d(K paramK, c<K> paramc, byte paramByte)
  {
    super(paramK, paramc);
    this.gh = new e(1.0F);
  }
  
  public final d a(e parame)
  {
    this.gh = parame;
    return this;
  }
  
  public final e aH()
  {
    return this.gh;
  }
  
  final boolean e(long paramLong)
  {
    if (this.gj)
    {
      if (this.gi != 3.4028235E+38F)
      {
        this.gh.gr = this.gi;
        this.gi = 3.4028235E+38F;
      }
      this.fX = ((float)this.gh.gr);
      this.fW = 0.0F;
      this.gj = false;
      return true;
    }
    Object localObject;
    if (this.gi != 3.4028235E+38F)
    {
      localObject = this.gh.a(this.fX, this.fW, paramLong / 2L);
      this.gh.gr = this.gi;
      this.gi = 3.4028235E+38F;
      localObject = this.gh.a(((b.a)localObject).fX, ((b.a)localObject).fW, paramLong / 2L);
      this.fX = ((b.a)localObject).fX;
      this.fW = ((b.a)localObject).fW;
      this.fX = Math.max(this.fX, this.gc);
      this.fX = Math.min(this.fX, this.gb);
      float f1 = this.fX;
      float f2 = this.fW;
      localObject = this.gh;
      if ((Math.abs(f2) >= ((e)localObject).gn) || (Math.abs(f1 - (float)((e)localObject).gr) >= ((e)localObject).gm)) {
        break label306;
      }
    }
    label306:
    for (int i = 1;; i = 0)
    {
      if (i == 0) {
        break label312;
      }
      this.fX = ((float)this.gh.gr);
      this.fW = 0.0F;
      return true;
      localObject = this.gh.a(this.fX, this.fW, paramLong);
      this.fX = ((b.a)localObject).fX;
      this.fW = ((b.a)localObject).fW;
      break;
    }
    label312:
    return false;
  }
  
  public final void start()
  {
    if (this.gh == null) {
      throw new UnsupportedOperationException("Incomplete SpringAnimation: Either final position or a spring force needs to be set.");
    }
    double d = (float)this.gh.gr;
    if (d > this.gb) {
      throw new UnsupportedOperationException("Final position of the spring cannot be greater than the max value.");
    }
    if (d < this.gc) {
      throw new UnsupportedOperationException("Final position of the spring cannot be less than the min value.");
    }
    e locale = this.gh;
    locale.gm = Math.abs(this.gd * 0.75F);
    locale.gn = (locale.gm * 62.5D);
    super.start();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     android.support.a.d
 * JD-Core Version:    0.7.0.1
 */