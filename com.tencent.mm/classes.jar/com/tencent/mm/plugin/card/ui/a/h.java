package com.tencent.mm.plugin.card.ui.a;

import android.text.TextUtils;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.card.ui.e.a;
import com.tencent.mm.protocal.protobuf.ry;
import com.tencent.mm.ui.MMActivity;
import java.util.ArrayList;

public final class h
  extends a
{
  public h(MMActivity paramMMActivity)
  {
    super(paramMMActivity);
  }
  
  protected final void bSL()
  {
    AppMethodBeat.i(113650);
    super.bSL();
    AppMethodBeat.o(113650);
  }
  
  public final boolean bSV()
  {
    AppMethodBeat.i(113651);
    ArrayList localArrayList = com.tencent.mm.plugin.card.sharecard.a.b.UO(this.nTp.bPn());
    if (((!this.ocl.nUB) || (this.ocl.fwc == 4)) && (!TextUtils.isEmpty(this.nTp.bPo())))
    {
      AppMethodBeat.o(113651);
      return true;
    }
    if (((this.ocl.nUB) && (localArrayList != null) && (localArrayList.size() > 0)) || ((!TextUtils.isEmpty(this.nTp.bPo())) && (bSW())))
    {
      AppMethodBeat.o(113651);
      return true;
    }
    AppMethodBeat.o(113651);
    return false;
  }
  
  public final boolean bSW()
  {
    return this.ocl.fwc == 3;
  }
  
  public final boolean bSX()
  {
    return false;
  }
  
  public final boolean bSZ()
  {
    return this.ogU;
  }
  
  public final boolean bTa()
  {
    return false;
  }
  
  public final boolean bTc()
  {
    return false;
  }
  
  public final boolean bTd()
  {
    AppMethodBeat.i(113652);
    if ((this.ogU) && (super.bTd()))
    {
      AppMethodBeat.o(113652);
      return true;
    }
    AppMethodBeat.o(113652);
    return false;
  }
  
  public final boolean bTh()
  {
    return false;
  }
  
  public final boolean bTi()
  {
    return false;
  }
  
  public final boolean bTj()
  {
    AppMethodBeat.i(113653);
    if (super.bTj())
    {
      AppMethodBeat.o(113653);
      return true;
    }
    if (bTk())
    {
      AppMethodBeat.o(113653);
      return true;
    }
    if ((this.nTp.bOO()) && (this.ogU))
    {
      AppMethodBeat.o(113653);
      return true;
    }
    AppMethodBeat.o(113653);
    return false;
  }
  
  public final boolean bTk()
  {
    AppMethodBeat.i(113654);
    if ((!this.ogU) && (this.nTp.bPi().EkM == 1))
    {
      AppMethodBeat.o(113654);
      return true;
    }
    AppMethodBeat.o(113654);
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.card.ui.a.h
 * JD-Core Version:    0.7.0.1
 */