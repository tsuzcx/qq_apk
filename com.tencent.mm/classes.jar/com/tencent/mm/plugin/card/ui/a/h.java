package com.tencent.mm.plugin.card.ui.a;

import android.text.TextUtils;
import com.tencent.mm.plugin.card.ui.e.a;
import com.tencent.mm.protocal.c.mg;
import com.tencent.mm.ui.MMActivity;
import java.util.ArrayList;

public final class h
  extends a
{
  public h(MMActivity paramMMActivity)
  {
    super(paramMMActivity);
  }
  
  public final boolean aCC()
  {
    ArrayList localArrayList = com.tencent.mm.plugin.card.sharecard.a.b.yr(this.ikk.azC());
    if (((!this.isN.ily) || (this.isN.drX == 4)) && (!TextUtils.isEmpty(this.ikk.azD()))) {}
    while (((this.isN.ily) && (localArrayList != null) && (localArrayList.size() > 0)) || ((!TextUtils.isEmpty(this.ikk.azD())) && (aCD()))) {
      return true;
    }
    return false;
  }
  
  public final boolean aCD()
  {
    return this.isN.drX == 3;
  }
  
  public final boolean aCE()
  {
    return false;
  }
  
  public final boolean aCG()
  {
    return this.ixx;
  }
  
  public final boolean aCH()
  {
    return false;
  }
  
  public final boolean aCJ()
  {
    return false;
  }
  
  public final boolean aCK()
  {
    return (this.ixx) && (super.aCK());
  }
  
  public final boolean aCO()
  {
    return false;
  }
  
  public final boolean aCP()
  {
    return false;
  }
  
  public final boolean aCQ()
  {
    if (super.aCQ()) {}
    while ((aCR()) || ((this.ikk.aze()) && (this.ixx))) {
      return true;
    }
    return false;
  }
  
  public final boolean aCR()
  {
    return (!this.ixx) && (this.ikk.azx().sIN == 1);
  }
  
  protected final void aCs()
  {
    super.aCs();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.card.ui.a.h
 * JD-Core Version:    0.7.0.1
 */