package com.tencent.mm.plugin.card.ui.a;

import android.text.TextUtils;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.card.ui.e.a;
import com.tencent.mm.protocal.protobuf.ro;
import com.tencent.mm.ui.MMActivity;
import java.util.ArrayList;

public final class h
  extends a
{
  public h(MMActivity paramMMActivity)
  {
    super(paramMMActivity);
  }
  
  public final boolean bLI()
  {
    AppMethodBeat.i(113651);
    ArrayList localArrayList = com.tencent.mm.plugin.card.sharecard.a.b.QC(this.nqp.bIa());
    if (((!this.nzk.nrB) || (this.nzk.fsv == 4)) && (!TextUtils.isEmpty(this.nqp.bIb())))
    {
      AppMethodBeat.o(113651);
      return true;
    }
    if (((this.nzk.nrB) && (localArrayList != null) && (localArrayList.size() > 0)) || ((!TextUtils.isEmpty(this.nqp.bIb())) && (bLJ())))
    {
      AppMethodBeat.o(113651);
      return true;
    }
    AppMethodBeat.o(113651);
    return false;
  }
  
  public final boolean bLJ()
  {
    return this.nzk.fsv == 3;
  }
  
  public final boolean bLK()
  {
    return false;
  }
  
  public final boolean bLM()
  {
    return this.nDT;
  }
  
  public final boolean bLN()
  {
    return false;
  }
  
  public final boolean bLP()
  {
    return false;
  }
  
  public final boolean bLQ()
  {
    AppMethodBeat.i(113652);
    if ((this.nDT) && (super.bLQ()))
    {
      AppMethodBeat.o(113652);
      return true;
    }
    AppMethodBeat.o(113652);
    return false;
  }
  
  public final boolean bLU()
  {
    return false;
  }
  
  public final boolean bLV()
  {
    return false;
  }
  
  public final boolean bLW()
  {
    AppMethodBeat.i(113653);
    if (super.bLW())
    {
      AppMethodBeat.o(113653);
      return true;
    }
    if (bLX())
    {
      AppMethodBeat.o(113653);
      return true;
    }
    if ((this.nqp.bHB()) && (this.nDT))
    {
      AppMethodBeat.o(113653);
      return true;
    }
    AppMethodBeat.o(113653);
    return false;
  }
  
  public final boolean bLX()
  {
    AppMethodBeat.i(113654);
    if ((!this.nDT) && (this.nqp.bHV().CSb == 1))
    {
      AppMethodBeat.o(113654);
      return true;
    }
    AppMethodBeat.o(113654);
    return false;
  }
  
  protected final void bLy()
  {
    AppMethodBeat.i(113650);
    super.bLy();
    AppMethodBeat.o(113650);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.card.ui.a.h
 * JD-Core Version:    0.7.0.1
 */