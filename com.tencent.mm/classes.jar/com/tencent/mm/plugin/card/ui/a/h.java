package com.tencent.mm.plugin.card.ui.a;

import android.text.TextUtils;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.card.ui.e.a;
import com.tencent.mm.protocal.protobuf.pg;
import com.tencent.mm.ui.MMActivity;
import java.util.ArrayList;

public final class h
  extends a
{
  public h(MMActivity paramMMActivity)
  {
    super(paramMMActivity);
  }
  
  protected final void beC()
  {
    AppMethodBeat.i(88723);
    super.beC();
    AppMethodBeat.o(88723);
  }
  
  public final boolean beM()
  {
    AppMethodBeat.i(88724);
    ArrayList localArrayList = com.tencent.mm.plugin.card.sharecard.a.b.HS(this.klk.bbi());
    if (((!this.ktU.kmw) || (this.ktU.ejF == 4)) && (!TextUtils.isEmpty(this.klk.bbj())))
    {
      AppMethodBeat.o(88724);
      return true;
    }
    if (((this.ktU.kmw) && (localArrayList != null) && (localArrayList.size() > 0)) || ((!TextUtils.isEmpty(this.klk.bbj())) && (beN())))
    {
      AppMethodBeat.o(88724);
      return true;
    }
    AppMethodBeat.o(88724);
    return false;
  }
  
  public final boolean beN()
  {
    return this.ktU.ejF == 3;
  }
  
  public final boolean beO()
  {
    return false;
  }
  
  public final boolean beQ()
  {
    return this.kyA;
  }
  
  public final boolean beR()
  {
    return false;
  }
  
  public final boolean beT()
  {
    return false;
  }
  
  public final boolean beU()
  {
    AppMethodBeat.i(88725);
    if ((this.kyA) && (super.beU()))
    {
      AppMethodBeat.o(88725);
      return true;
    }
    AppMethodBeat.o(88725);
    return false;
  }
  
  public final boolean beY()
  {
    return false;
  }
  
  public final boolean beZ()
  {
    return false;
  }
  
  public final boolean bfa()
  {
    AppMethodBeat.i(88726);
    if (super.bfa())
    {
      AppMethodBeat.o(88726);
      return true;
    }
    if (bfb())
    {
      AppMethodBeat.o(88726);
      return true;
    }
    if ((this.klk.baK()) && (this.kyA))
    {
      AppMethodBeat.o(88726);
      return true;
    }
    AppMethodBeat.o(88726);
    return false;
  }
  
  public final boolean bfb()
  {
    AppMethodBeat.i(88727);
    if ((!this.kyA) && (this.klk.bbd().wGw == 1))
    {
      AppMethodBeat.o(88727);
      return true;
    }
    AppMethodBeat.o(88727);
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.card.ui.a.h
 * JD-Core Version:    0.7.0.1
 */