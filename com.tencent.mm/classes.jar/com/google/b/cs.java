package com.google.b;

public final class cs<MType extends a, BType extends a.a, IType extends bz>
  implements a.b
{
  private boolean bYn;
  BType caD;
  MType caE;
  private a.b cat;
  
  public cs(MType paramMType, a.b paramb, boolean paramBoolean)
  {
    this.caE = ((a)be.checkNotNull(paramMType));
    this.cat = paramb;
    this.bYn = paramBoolean;
  }
  
  private BType IW()
  {
    if (this.caD == null)
    {
      this.caD = ((a.a)this.caE.a(this));
      this.caD.a(this.caE);
      this.caD.Ag();
    }
    return this.caD;
  }
  
  private void onChanged()
  {
    if (this.caD != null) {
      this.caE = null;
    }
    if ((this.bYn) && (this.cat != null))
    {
      this.cat.Ai();
      this.bYn = false;
    }
  }
  
  public final void Ai()
  {
    onChanged();
  }
  
  public final MType IU()
  {
    if (this.caE == null) {
      this.caE = ((a)this.caD.CP());
    }
    return this.caE;
  }
  
  public final MType IV()
  {
    this.bYn = true;
    return IU();
  }
  
  public final cs<MType, BType, IType> b(MType paramMType)
  {
    this.caE = ((a)be.checkNotNull(paramMType));
    if (this.caD != null)
    {
      this.caD.dispose();
      this.caD = null;
    }
    onChanged();
    return this;
  }
  
  public final cs<MType, BType, IType> c(MType paramMType)
  {
    if ((this.caD == null) && (this.caE == this.caE.Ct())) {
      this.caE = paramMType;
    }
    for (;;)
    {
      onChanged();
      return this;
      IW().a(paramMType);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.google.b.cs
 * JD-Core Version:    0.7.0.1
 */