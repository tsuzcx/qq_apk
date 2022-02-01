package android.support.a;

public final class d
  extends b<d>
{
  private e gj = null;
  private float gk = 3.4028235E+38F;
  private boolean gl = false;
  
  public <K> d(K paramK, c<K> paramc)
  {
    super(paramK, paramc);
  }
  
  public <K> d(K paramK, c<K> paramc, byte paramByte)
  {
    super(paramK, paramc);
    this.gj = new e(1.0F);
  }
  
  public final d a(e parame)
  {
    this.gj = parame;
    return this;
  }
  
  public final e aJ()
  {
    return this.gj;
  }
  
  final boolean e(long paramLong)
  {
    if (this.gl)
    {
      if (this.gk != 3.4028235E+38F)
      {
        this.gj.gt = this.gk;
        this.gk = 3.4028235E+38F;
      }
      this.fZ = ((float)this.gj.gt);
      this.fY = 0.0F;
      this.gl = false;
      return true;
    }
    Object localObject;
    if (this.gk != 3.4028235E+38F)
    {
      localObject = this.gj.a(this.fZ, this.fY, paramLong / 2L);
      this.gj.gt = this.gk;
      this.gk = 3.4028235E+38F;
      localObject = this.gj.a(((b.a)localObject).fZ, ((b.a)localObject).fY, paramLong / 2L);
      this.fZ = ((b.a)localObject).fZ;
      this.fY = ((b.a)localObject).fY;
      this.fZ = Math.max(this.fZ, this.ge);
      this.fZ = Math.min(this.fZ, this.gd);
      float f1 = this.fZ;
      float f2 = this.fY;
      localObject = this.gj;
      if ((Math.abs(f2) >= ((e)localObject).gp) || (Math.abs(f1 - (float)((e)localObject).gt) >= ((e)localObject).go)) {
        break label306;
      }
    }
    label306:
    for (int i = 1;; i = 0)
    {
      if (i == 0) {
        break label312;
      }
      this.fZ = ((float)this.gj.gt);
      this.fY = 0.0F;
      return true;
      localObject = this.gj.a(this.fZ, this.fY, paramLong);
      this.fZ = ((b.a)localObject).fZ;
      this.fY = ((b.a)localObject).fY;
      break;
    }
    label312:
    return false;
  }
  
  public final void start()
  {
    if (this.gj == null) {
      throw new UnsupportedOperationException("Incomplete SpringAnimation: Either final position or a spring force needs to be set.");
    }
    double d = (float)this.gj.gt;
    if (d > this.gd) {
      throw new UnsupportedOperationException("Final position of the spring cannot be greater than the max value.");
    }
    if (d < this.ge) {
      throw new UnsupportedOperationException("Final position of the spring cannot be less than the min value.");
    }
    e locale = this.gj;
    locale.go = Math.abs(this.gf * 0.75F);
    locale.gp = (locale.go * 62.5D);
    super.start();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     android.support.a.d
 * JD-Core Version:    0.7.0.1
 */