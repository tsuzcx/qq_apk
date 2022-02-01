package com.google.a;

public final class bu<MType extends a, BType extends a.a, IType extends az>
  implements a.b
{
  private boolean bWv;
  private a.b bYP;
  BType bZa;
  MType bZb;
  
  public bu(MType paramMType, a.b paramb, boolean paramBoolean)
  {
    this.bZb = ((a)ae.checkNotNull(paramMType));
    this.bYP = paramb;
    this.bWv = paramBoolean;
  }
  
  private void onChanged()
  {
    if (this.bZa != null) {
      this.bZb = null;
    }
    if ((this.bWv) && (this.bYP != null))
    {
      this.bYP.yH();
      this.bWv = false;
    }
  }
  
  public final MType Hu()
  {
    if (this.bZb == null) {
      this.bZb = ((a)this.bZa.Bm());
    }
    return this.bZb;
  }
  
  public final MType Hv()
  {
    this.bWv = true;
    return Hu();
  }
  
  public final BType Hw()
  {
    if (this.bZa == null)
    {
      this.bZa = ((a.a)this.bZb.a(this));
      this.bZa.a(this.bZb);
      this.bZa.yF();
    }
    return this.bZa;
  }
  
  public final bu<MType, BType, IType> b(MType paramMType)
  {
    if ((this.bZa == null) && (this.bZb == this.bZb.AQ())) {
      this.bZb = paramMType;
    }
    for (;;)
    {
      onChanged();
      return this;
      Hw().a(paramMType);
    }
  }
  
  public final void yH()
  {
    onChanged();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.google.a.bu
 * JD-Core Version:    0.7.0.1
 */