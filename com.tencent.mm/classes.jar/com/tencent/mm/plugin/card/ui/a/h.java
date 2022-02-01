package com.tencent.mm.plugin.card.ui.a;

import android.text.TextUtils;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.card.ui.e.a;
import com.tencent.mm.protocal.protobuf.uz;
import com.tencent.mm.ui.MMActivity;
import java.util.ArrayList;

public final class h
  extends a
{
  public h(MMActivity paramMMActivity)
  {
    super(paramMMActivity);
  }
  
  public final boolean cwF()
  {
    AppMethodBeat.i(113651);
    ArrayList localArrayList = com.tencent.mm.plugin.card.sharecard.a.b.ajt(this.pQV.csV());
    if (((!this.pZU.pSh) || (this.pZU.gwE == 4)) && (!TextUtils.isEmpty(this.pQV.csW())))
    {
      AppMethodBeat.o(113651);
      return true;
    }
    if (((this.pZU.pSh) && (localArrayList != null) && (localArrayList.size() > 0)) || ((!TextUtils.isEmpty(this.pQV.csW())) && (cwG())))
    {
      AppMethodBeat.o(113651);
      return true;
    }
    AppMethodBeat.o(113651);
    return false;
  }
  
  public final boolean cwG()
  {
    return this.pZU.gwE == 3;
  }
  
  public final boolean cwH()
  {
    return false;
  }
  
  public final boolean cwJ()
  {
    return this.qeD;
  }
  
  public final boolean cwK()
  {
    return false;
  }
  
  public final boolean cwM()
  {
    return false;
  }
  
  public final boolean cwN()
  {
    AppMethodBeat.i(113652);
    if ((this.qeD) && (super.cwN()))
    {
      AppMethodBeat.o(113652);
      return true;
    }
    AppMethodBeat.o(113652);
    return false;
  }
  
  public final boolean cwR()
  {
    return false;
  }
  
  public final boolean cwS()
  {
    return false;
  }
  
  public final boolean cwT()
  {
    AppMethodBeat.i(113653);
    if (super.cwT())
    {
      AppMethodBeat.o(113653);
      return true;
    }
    if (cwU())
    {
      AppMethodBeat.o(113653);
      return true;
    }
    if ((this.pQV.csw()) && (this.qeD))
    {
      AppMethodBeat.o(113653);
      return true;
    }
    AppMethodBeat.o(113653);
    return false;
  }
  
  public final boolean cwU()
  {
    AppMethodBeat.i(113654);
    if ((!this.qeD) && (this.pQV.csQ().LeX == 1))
    {
      AppMethodBeat.o(113654);
      return true;
    }
    AppMethodBeat.o(113654);
    return false;
  }
  
  protected final void cwv()
  {
    AppMethodBeat.i(113650);
    super.cwv();
    AppMethodBeat.o(113650);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.card.ui.a.h
 * JD-Core Version:    0.7.0.1
 */