package android.support.a;

public final class d
  extends b<d>
{
  private e eo = null;
  private float ep = 3.4028235E+38F;
  private boolean eq = false;
  
  public <K> d(K paramK, c<K> paramc)
  {
    super(paramK, paramc);
  }
  
  public <K> d(K paramK, c<K> paramc, byte paramByte)
  {
    super(paramK, paramc);
    this.eo = new e(1.0F);
  }
  
  public final d a(e parame)
  {
    this.eo = parame;
    return this;
  }
  
  public final e ar()
  {
    return this.eo;
  }
  
  final boolean e(long paramLong)
  {
    if (this.eq)
    {
      if (this.ep != 3.4028235E+38F)
      {
        this.eo.ey = this.ep;
        this.ep = 3.4028235E+38F;
      }
      this.ed = ((float)this.eo.ey);
      this.ec = 0.0F;
      this.eq = false;
      return true;
    }
    Object localObject;
    if (this.ep != 3.4028235E+38F)
    {
      localObject = this.eo.a(this.ed, this.ec, paramLong / 2L);
      this.eo.ey = this.ep;
      this.ep = 3.4028235E+38F;
      localObject = this.eo.a(((b.a)localObject).ed, ((b.a)localObject).ec, paramLong / 2L);
      this.ed = ((b.a)localObject).ed;
      this.ec = ((b.a)localObject).ec;
      this.ed = Math.max(this.ed, this.ei);
      this.ed = Math.min(this.ed, this.eh);
      float f1 = this.ed;
      float f2 = this.ec;
      localObject = this.eo;
      if ((Math.abs(f2) >= ((e)localObject).eu) || (Math.abs(f1 - (float)((e)localObject).ey) >= ((e)localObject).et)) {
        break label306;
      }
    }
    label306:
    for (int i = 1;; i = 0)
    {
      if (i == 0) {
        break label312;
      }
      this.ed = ((float)this.eo.ey);
      this.ec = 0.0F;
      return true;
      localObject = this.eo.a(this.ed, this.ec, paramLong);
      this.ed = ((b.a)localObject).ed;
      this.ec = ((b.a)localObject).ec;
      break;
    }
    label312:
    return false;
  }
  
  public final void start()
  {
    if (this.eo == null) {
      throw new UnsupportedOperationException("Incomplete SpringAnimation: Either final position or a spring force needs to be set.");
    }
    double d = (float)this.eo.ey;
    if (d > this.eh) {
      throw new UnsupportedOperationException("Final position of the spring cannot be greater than the max value.");
    }
    if (d < this.ei) {
      throw new UnsupportedOperationException("Final position of the spring cannot be less than the min value.");
    }
    e locale = this.eo;
    locale.et = Math.abs(this.ej * 0.75F);
    locale.eu = (locale.et * 62.5D);
    super.start();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     android.support.a.d
 * JD-Core Version:    0.7.0.1
 */