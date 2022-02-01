package com.google.d;

public final class df<MType extends a, BType extends a.a, IType extends ch>
  implements a.b
{
  a.b dUC;
  BType dVd;
  MType dVe;
  private boolean isClean;
  
  public df(MType paramMType, a.b paramb, boolean paramBoolean)
  {
    this.dVe = ((a)bj.checkNotNull(paramMType));
    this.dUC = paramb;
    this.isClean = paramBoolean;
  }
  
  private BType ajo()
  {
    if (this.dVd == null)
    {
      this.dVd = ((a.a)this.dVe.newBuilderForType(this));
      this.dVd.mergeFrom(this.dVe);
      this.dVd.markClean();
    }
    return this.dVd;
  }
  
  private void onChanged()
  {
    if (this.dVd != null) {
      this.dVe = null;
    }
    if ((this.isClean) && (this.dUC != null))
    {
      this.dUC.ZN();
      this.isClean = false;
    }
  }
  
  public final void ZN()
  {
    onChanged();
  }
  
  public final MType ajm()
  {
    if (this.dVe == null) {
      this.dVe = ((a)this.dVd.buildPartial());
    }
    return this.dVe;
  }
  
  public final MType ajn()
  {
    this.isClean = true;
    return ajm();
  }
  
  public final df<MType, BType, IType> ajp()
  {
    if (this.dVe != null) {}
    for (cb localcb = this.dVe.getDefaultInstanceForType();; localcb = this.dVd.getDefaultInstanceForType())
    {
      this.dVe = ((a)localcb);
      if (this.dVd != null)
      {
        this.dVd.dispose();
        this.dVd = null;
      }
      onChanged();
      return this;
    }
  }
  
  public final df<MType, BType, IType> b(MType paramMType)
  {
    this.dVe = ((a)bj.checkNotNull(paramMType));
    if (this.dVd != null)
    {
      this.dVd.dispose();
      this.dVd = null;
    }
    onChanged();
    return this;
  }
  
  public final df<MType, BType, IType> c(MType paramMType)
  {
    if ((this.dVd == null) && (this.dVe == this.dVe.getDefaultInstanceForType())) {
      this.dVe = paramMType;
    }
    for (;;)
    {
      onChanged();
      return this;
      ajo().mergeFrom(paramMType);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes11.jar
 * Qualified Name:     com.google.d.df
 * JD-Core Version:    0.7.0.1
 */