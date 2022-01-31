package com.tencent.mm.plugin.card.ui.a;

import com.tencent.mm.plugin.card.base.b;
import com.tencent.mm.protocal.c.lv;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.ui.MMActivity;

public final class f
  extends a
{
  public f(MMActivity paramMMActivity)
  {
    super(paramMMActivity);
  }
  
  public final boolean aCG()
  {
    return this.ixx;
  }
  
  public final boolean aCH()
  {
    return (this.ikk.isNormal()) && (super.aCH()) && ((this.ikk.azs()) || (!bk.bl(this.ikk.azy().code)));
  }
  
  public final boolean aCI()
  {
    return true;
  }
  
  public final boolean aCL()
  {
    return (this.ikk.isNormal()) && (super.aCL());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.card.ui.a.f
 * JD-Core Version:    0.7.0.1
 */