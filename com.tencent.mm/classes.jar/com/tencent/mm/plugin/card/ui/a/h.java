package com.tencent.mm.plugin.card.ui.a;

import android.text.TextUtils;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.card.ui.e.a;
import com.tencent.mm.protocal.protobuf.vb;
import com.tencent.mm.ui.MMActivity;
import java.util.ArrayList;

public final class h
  extends a
{
  public h(MMActivity paramMMActivity)
  {
    super(paramMMActivity);
  }
  
  protected final void cJX()
  {
    AppMethodBeat.i(113650);
    super.cJX();
    AppMethodBeat.o(113650);
  }
  
  public final boolean cKi()
  {
    AppMethodBeat.i(113651);
    ArrayList localArrayList = com.tencent.mm.plugin.card.sharecard.a.b.arg(this.tmU.cGx());
    if (((!this.tvQ.tog) || (this.tvQ.jaR == 4)) && (!TextUtils.isEmpty(this.tmU.cGy())))
    {
      AppMethodBeat.o(113651);
      return true;
    }
    if (((this.tvQ.tog) && (localArrayList != null) && (localArrayList.size() > 0)) || ((!TextUtils.isEmpty(this.tmU.cGy())) && (cKj())))
    {
      AppMethodBeat.o(113651);
      return true;
    }
    AppMethodBeat.o(113651);
    return false;
  }
  
  public final boolean cKj()
  {
    return this.tvQ.jaR == 3;
  }
  
  public final boolean cKk()
  {
    return false;
  }
  
  public final boolean cKm()
  {
    AppMethodBeat.i(252287);
    boolean bool = cJq();
    AppMethodBeat.o(252287);
    return bool;
  }
  
  public final boolean cKn()
  {
    return false;
  }
  
  public final boolean cKp()
  {
    return false;
  }
  
  public final boolean cKq()
  {
    AppMethodBeat.i(113652);
    if ((cJq()) && (super.cKq()))
    {
      AppMethodBeat.o(113652);
      return true;
    }
    AppMethodBeat.o(113652);
    return false;
  }
  
  public final boolean cKu()
  {
    return false;
  }
  
  public final boolean cKv()
  {
    return false;
  }
  
  public final boolean cKw()
  {
    AppMethodBeat.i(113653);
    if (super.cKw())
    {
      AppMethodBeat.o(113653);
      return true;
    }
    if (cKx())
    {
      AppMethodBeat.o(113653);
      return true;
    }
    if ((this.tmU.cFX()) && (cJq()))
    {
      AppMethodBeat.o(113653);
      return true;
    }
    AppMethodBeat.o(113653);
    return false;
  }
  
  public final boolean cKx()
  {
    AppMethodBeat.i(113654);
    if ((!cJq()) && (this.tmU.cGs().Sgl == 1))
    {
      AppMethodBeat.o(113654);
      return true;
    }
    AppMethodBeat.o(113654);
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.card.ui.a.h
 * JD-Core Version:    0.7.0.1
 */