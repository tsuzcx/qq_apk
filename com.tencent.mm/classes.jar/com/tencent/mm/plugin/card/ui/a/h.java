package com.tencent.mm.plugin.card.ui.a;

import android.text.TextUtils;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.card.ui.e.a;
import com.tencent.mm.protocal.protobuf.tu;
import com.tencent.mm.ui.MMActivity;
import java.util.ArrayList;

public final class h
  extends a
{
  public h(MMActivity paramMMActivity)
  {
    super(paramMMActivity);
  }
  
  protected final void bYF()
  {
    AppMethodBeat.i(113650);
    super.bYF();
    AppMethodBeat.o(113650);
  }
  
  public final boolean bYP()
  {
    AppMethodBeat.i(113651);
    ArrayList localArrayList = com.tencent.mm.plugin.card.sharecard.a.b.Zo(this.oDm.bVh());
    if (((!this.oMg.oEy) || (this.oMg.fRv == 4)) && (!TextUtils.isEmpty(this.oDm.bVi())))
    {
      AppMethodBeat.o(113651);
      return true;
    }
    if (((this.oMg.oEy) && (localArrayList != null) && (localArrayList.size() > 0)) || ((!TextUtils.isEmpty(this.oDm.bVi())) && (bYQ())))
    {
      AppMethodBeat.o(113651);
      return true;
    }
    AppMethodBeat.o(113651);
    return false;
  }
  
  public final boolean bYQ()
  {
    return this.oMg.fRv == 3;
  }
  
  public final boolean bYR()
  {
    return false;
  }
  
  public final boolean bYT()
  {
    return this.oQP;
  }
  
  public final boolean bYU()
  {
    return false;
  }
  
  public final boolean bYW()
  {
    return false;
  }
  
  public final boolean bYX()
  {
    AppMethodBeat.i(113652);
    if ((this.oQP) && (super.bYX()))
    {
      AppMethodBeat.o(113652);
      return true;
    }
    AppMethodBeat.o(113652);
    return false;
  }
  
  public final boolean bZb()
  {
    return false;
  }
  
  public final boolean bZc()
  {
    return false;
  }
  
  public final boolean bZd()
  {
    AppMethodBeat.i(113653);
    if (super.bZd())
    {
      AppMethodBeat.o(113653);
      return true;
    }
    if (bZe())
    {
      AppMethodBeat.o(113653);
      return true;
    }
    if ((this.oDm.bUI()) && (this.oQP))
    {
      AppMethodBeat.o(113653);
      return true;
    }
    AppMethodBeat.o(113653);
    return false;
  }
  
  public final boolean bZe()
  {
    AppMethodBeat.i(113654);
    if ((!this.oQP) && (this.oDm.bVc().Gku == 1))
    {
      AppMethodBeat.o(113654);
      return true;
    }
    AppMethodBeat.o(113654);
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.card.ui.a.h
 * JD-Core Version:    0.7.0.1
 */