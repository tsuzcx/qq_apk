package com.tencent.mm.plugin.card.ui.a;

import com.tencent.mm.plugin.card.base.b;
import com.tencent.mm.plugin.card.d.l;
import com.tencent.mm.plugin.card.ui.e.a;
import com.tencent.mm.protocal.c.mg;
import com.tencent.mm.ui.MMActivity;

public final class e
  extends a
{
  public e(MMActivity paramMMActivity)
  {
    super(paramMMActivity);
  }
  
  public final boolean aCB()
  {
    return (!this.ikk.azf()) || (l.pg(this.isN.drX)) || (!this.ikk.isNormal()) || (this.ixx);
  }
  
  public final boolean aCF()
  {
    return (this.ikk.azf()) && (!l.pg(this.isN.drX)) && (this.ikk.isNormal()) && (!this.ixx);
  }
  
  public final boolean aCG()
  {
    return this.ixx;
  }
  
  public final boolean aCI()
  {
    return (this.ikk.azx() != null) && (this.ikk.azx().sIW);
  }
  
  public final boolean aCJ()
  {
    return (super.aCJ()) || ((this.ikk.isNormal()) && (!this.ixx) && ((aCq()) || (aCr())));
  }
  
  public final boolean aCO()
  {
    return (this.ikk.isNormal()) && (super.aCO()) && (!aCI());
  }
  
  public final boolean aCS()
  {
    return (this.ikk.azf()) && (this.ikk.azx().sII != null) && (this.ikk.isNormal()) && (!this.ixx) && (!aCq()) && (!aCr());
  }
  
  public final boolean aCt()
  {
    return (super.aCt()) && (this.ikk.isNormal()) && (!this.ixx) && (!aCq()) && (!aCr());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.card.ui.a.e
 * JD-Core Version:    0.7.0.1
 */