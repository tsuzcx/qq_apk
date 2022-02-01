package androidx.e.a;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class d
  extends b<d>
{
  private boolean bzA;
  public e bzy;
  private float bzz;
  
  public <K> d(K paramK, c<K> paramc)
  {
    super(paramK, paramc);
    this.bzy = null;
    this.bzz = 3.4028235E+38F;
    this.bzA = false;
  }
  
  public <K> d(K paramK, c<K> paramc, byte paramByte)
  {
    super(paramK, paramc);
    AppMethodBeat.i(196497);
    this.bzy = null;
    this.bzz = 3.4028235E+38F;
    this.bzA = false;
    this.bzy = new e(1.0F);
    AppMethodBeat.o(196497);
  }
  
  final boolean by(long paramLong)
  {
    AppMethodBeat.i(196528);
    if (this.bzA)
    {
      if (this.bzz != 3.4028235E+38F)
      {
        this.bzy.bzI = this.bzz;
        this.bzz = 3.4028235E+38F;
      }
      this.bzo = ((float)this.bzy.bzI);
      this.bzn = 0.0F;
      this.bzA = false;
      AppMethodBeat.o(196528);
      return true;
    }
    Object localObject;
    if (this.bzz != 3.4028235E+38F)
    {
      localObject = this.bzy.a(this.bzo, this.bzn, paramLong / 2L);
      this.bzy.bzI = this.bzz;
      this.bzz = 3.4028235E+38F;
      localObject = this.bzy.a(((b.a)localObject).bzo, ((b.a)localObject).bzn, paramLong / 2L);
      this.bzo = ((b.a)localObject).bzo;
      this.bzn = ((b.a)localObject).bzn;
      this.bzo = Math.max(this.bzo, this.bzt);
      this.bzo = Math.min(this.bzo, this.bzs);
      float f1 = this.bzo;
      float f2 = this.bzn;
      localObject = this.bzy;
      if ((Math.abs(f2) >= ((e)localObject).bzE) || (Math.abs(f1 - (float)((e)localObject).bzI) >= ((e)localObject).bzD)) {
        break label321;
      }
    }
    label321:
    for (int i = 1;; i = 0)
    {
      if (i == 0) {
        break label327;
      }
      this.bzo = ((float)this.bzy.bzI);
      this.bzn = 0.0F;
      AppMethodBeat.o(196528);
      return true;
      localObject = this.bzy.a(this.bzo, this.bzn, paramLong);
      this.bzo = ((b.a)localObject).bzo;
      this.bzn = ((b.a)localObject).bzn;
      break;
    }
    label327:
    AppMethodBeat.o(196528);
    return false;
  }
  
  public final void cancel()
  {
    AppMethodBeat.i(196514);
    super.cancel();
    if (this.bzz != 3.4028235E+38F)
    {
      if (this.bzy != null) {
        break label53;
      }
      this.bzy = new e(this.bzz);
    }
    for (;;)
    {
      this.bzz = 3.4028235E+38F;
      AppMethodBeat.o(196514);
      return;
      label53:
      this.bzy.bzI = this.bzz;
    }
  }
  
  public final void start()
  {
    AppMethodBeat.i(196505);
    if (this.bzy == null)
    {
      localObject = new UnsupportedOperationException("Incomplete SpringAnimation: Either final position or a spring force needs to be set.");
      AppMethodBeat.o(196505);
      throw ((Throwable)localObject);
    }
    double d = (float)this.bzy.bzI;
    if (d > this.bzs)
    {
      localObject = new UnsupportedOperationException("Final position of the spring cannot be greater than the max value.");
      AppMethodBeat.o(196505);
      throw ((Throwable)localObject);
    }
    if (d < this.bzt)
    {
      localObject = new UnsupportedOperationException("Final position of the spring cannot be less than the min value.");
      AppMethodBeat.o(196505);
      throw ((Throwable)localObject);
    }
    Object localObject = this.bzy;
    ((e)localObject).bzD = Math.abs(FJ());
    ((e)localObject).bzE = (((e)localObject).bzD * 62.5D);
    super.start();
    AppMethodBeat.o(196505);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     androidx.e.a.d
 * JD-Core Version:    0.7.0.1
 */