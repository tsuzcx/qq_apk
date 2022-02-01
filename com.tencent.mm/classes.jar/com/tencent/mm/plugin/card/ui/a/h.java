package com.tencent.mm.plugin.card.ui.a;

import android.text.TextUtils;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.card.ui.e.a;
import com.tencent.mm.protocal.protobuf.ts;
import com.tencent.mm.ui.MMActivity;
import java.util.ArrayList;

public final class h
  extends a
{
  public h(MMActivity paramMMActivity)
  {
    super(paramMMActivity);
  }
  
  public final boolean bXA()
  {
    AppMethodBeat.i(113651);
    ArrayList localArrayList = com.tencent.mm.plugin.card.sharecard.a.b.Yx(this.owK.bTS());
    if (((!this.oFE.oxW) || (this.oFE.fPp == 4)) && (!TextUtils.isEmpty(this.owK.bTT())))
    {
      AppMethodBeat.o(113651);
      return true;
    }
    if (((this.oFE.oxW) && (localArrayList != null) && (localArrayList.size() > 0)) || ((!TextUtils.isEmpty(this.owK.bTT())) && (bXB())))
    {
      AppMethodBeat.o(113651);
      return true;
    }
    AppMethodBeat.o(113651);
    return false;
  }
  
  public final boolean bXB()
  {
    return this.oFE.fPp == 3;
  }
  
  public final boolean bXC()
  {
    return false;
  }
  
  public final boolean bXE()
  {
    return this.oKn;
  }
  
  public final boolean bXF()
  {
    return false;
  }
  
  public final boolean bXH()
  {
    return false;
  }
  
  public final boolean bXI()
  {
    AppMethodBeat.i(113652);
    if ((this.oKn) && (super.bXI()))
    {
      AppMethodBeat.o(113652);
      return true;
    }
    AppMethodBeat.o(113652);
    return false;
  }
  
  public final boolean bXM()
  {
    return false;
  }
  
  public final boolean bXN()
  {
    return false;
  }
  
  public final boolean bXO()
  {
    AppMethodBeat.i(113653);
    if (super.bXO())
    {
      AppMethodBeat.o(113653);
      return true;
    }
    if (bXP())
    {
      AppMethodBeat.o(113653);
      return true;
    }
    if ((this.owK.bTt()) && (this.oKn))
    {
      AppMethodBeat.o(113653);
      return true;
    }
    AppMethodBeat.o(113653);
    return false;
  }
  
  public final boolean bXP()
  {
    AppMethodBeat.i(113654);
    if ((!this.oKn) && (this.owK.bTN().FRV == 1))
    {
      AppMethodBeat.o(113654);
      return true;
    }
    AppMethodBeat.o(113654);
    return false;
  }
  
  protected final void bXq()
  {
    AppMethodBeat.i(113650);
    super.bXq();
    AppMethodBeat.o(113650);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.card.ui.a.h
 * JD-Core Version:    0.7.0.1
 */