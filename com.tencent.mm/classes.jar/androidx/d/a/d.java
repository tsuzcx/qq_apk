package androidx.d.a;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class d
  extends b<d>
{
  private e Ti;
  private float Tj;
  private boolean Tk;
  
  public <K> d(K paramK, c<K> paramc)
  {
    super(paramK, paramc);
    this.Ti = null;
    this.Tj = 3.4028235E+38F;
    this.Tk = false;
  }
  
  public <K> d(K paramK, c<K> paramc, byte paramByte)
  {
    super(paramK, paramc);
    AppMethodBeat.i(250186);
    this.Ti = null;
    this.Tj = 3.4028235E+38F;
    this.Tk = false;
    this.Ti = new e(1.0F);
    AppMethodBeat.o(250186);
  }
  
  public final d a(e parame)
  {
    this.Ti = parame;
    return this;
  }
  
  public final e hZ()
  {
    return this.Ti;
  }
  
  final boolean j(long paramLong)
  {
    AppMethodBeat.i(250193);
    if (this.Tk)
    {
      if (this.Tj != 3.4028235E+38F)
      {
        this.Ti.Ts = this.Tj;
        this.Tj = 3.4028235E+38F;
      }
      this.SY = ((float)this.Ti.Ts);
      this.SX = 0.0F;
      this.Tk = false;
      AppMethodBeat.o(250193);
      return true;
    }
    Object localObject;
    if (this.Tj != 3.4028235E+38F)
    {
      localObject = this.Ti.a(this.SY, this.SX, paramLong / 2L);
      this.Ti.Ts = this.Tj;
      this.Tj = 3.4028235E+38F;
      localObject = this.Ti.a(((b.a)localObject).SY, ((b.a)localObject).SX, paramLong / 2L);
      this.SY = ((b.a)localObject).SY;
      this.SX = ((b.a)localObject).SX;
      this.SY = Math.max(this.SY, this.Td);
      this.SY = Math.min(this.SY, this.Tc);
      float f1 = this.SY;
      float f2 = this.SX;
      localObject = this.Ti;
      if ((Math.abs(f2) >= ((e)localObject).To) || (Math.abs(f1 - (float)((e)localObject).Ts) >= ((e)localObject).Tn)) {
        break label321;
      }
    }
    label321:
    for (int i = 1;; i = 0)
    {
      if (i == 0) {
        break label327;
      }
      this.SY = ((float)this.Ti.Ts);
      this.SX = 0.0F;
      AppMethodBeat.o(250193);
      return true;
      localObject = this.Ti.a(this.SY, this.SX, paramLong);
      this.SY = ((b.a)localObject).SY;
      this.SX = ((b.a)localObject).SX;
      break;
    }
    label327:
    AppMethodBeat.o(250193);
    return false;
  }
  
  public final void start()
  {
    AppMethodBeat.i(250191);
    if (this.Ti == null)
    {
      localObject = new UnsupportedOperationException("Incomplete SpringAnimation: Either final position or a spring force needs to be set.");
      AppMethodBeat.o(250191);
      throw ((Throwable)localObject);
    }
    double d = (float)this.Ti.Ts;
    if (d > this.Tc)
    {
      localObject = new UnsupportedOperationException("Final position of the spring cannot be greater than the max value.");
      AppMethodBeat.o(250191);
      throw ((Throwable)localObject);
    }
    if (d < this.Td)
    {
      localObject = new UnsupportedOperationException("Final position of the spring cannot be less than the min value.");
      AppMethodBeat.o(250191);
      throw ((Throwable)localObject);
    }
    Object localObject = this.Ti;
    ((e)localObject).Tn = Math.abs(hY());
    ((e)localObject).To = (((e)localObject).Tn * 62.5D);
    super.start();
    AppMethodBeat.o(250191);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     androidx.d.a.d
 * JD-Core Version:    0.7.0.1
 */