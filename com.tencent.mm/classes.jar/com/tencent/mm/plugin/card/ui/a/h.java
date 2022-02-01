package com.tencent.mm.plugin.card.ui.a;

import android.text.TextUtils;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.card.ui.e.b;
import com.tencent.mm.protocal.protobuf.ws;
import com.tencent.mm.ui.MMActivity;
import java.util.ArrayList;

public final class h
  extends a
{
  public h(MMActivity paramMMActivity)
  {
    super(paramMMActivity);
  }
  
  public final boolean dnA()
  {
    return false;
  }
  
  public final boolean dnC()
  {
    AppMethodBeat.i(293806);
    boolean bool = dmH();
    AppMethodBeat.o(293806);
    return bool;
  }
  
  public final boolean dnD()
  {
    return false;
  }
  
  public final boolean dnF()
  {
    return false;
  }
  
  public final boolean dnG()
  {
    AppMethodBeat.i(113652);
    if ((dmH()) && (super.dnG()))
    {
      AppMethodBeat.o(113652);
      return true;
    }
    AppMethodBeat.o(113652);
    return false;
  }
  
  public final boolean dnK()
  {
    return false;
  }
  
  public final boolean dnL()
  {
    return false;
  }
  
  public final boolean dnM()
  {
    AppMethodBeat.i(113653);
    if (super.dnM())
    {
      AppMethodBeat.o(113653);
      return true;
    }
    if (dnN())
    {
      AppMethodBeat.o(113653);
      return true;
    }
    if ((this.wru.djp()) && (dmH()))
    {
      AppMethodBeat.o(113653);
      return true;
    }
    AppMethodBeat.o(113653);
    return false;
  }
  
  public final boolean dnN()
  {
    AppMethodBeat.i(113654);
    if ((!dmH()) && (this.wru.djK().Zeg == 1))
    {
      AppMethodBeat.o(113654);
      return true;
    }
    AppMethodBeat.o(113654);
    return false;
  }
  
  protected final void dnn()
  {
    AppMethodBeat.i(113650);
    super.dnn();
    AppMethodBeat.o(113650);
  }
  
  public final boolean dny()
  {
    AppMethodBeat.i(113651);
    ArrayList localArrayList = com.tencent.mm.plugin.card.sharecard.a.b.akL(this.wru.djP());
    if (((!this.wAo.wsH) || (this.wAo.lCR == 4)) && (!TextUtils.isEmpty(this.wru.djQ())))
    {
      AppMethodBeat.o(113651);
      return true;
    }
    if (((this.wAo.wsH) && (localArrayList != null) && (localArrayList.size() > 0)) || ((!TextUtils.isEmpty(this.wru.djQ())) && (dnz())))
    {
      AppMethodBeat.o(113651);
      return true;
    }
    AppMethodBeat.o(113651);
    return false;
  }
  
  public final boolean dnz()
  {
    return this.wAo.lCR == 3;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes10.jar
 * Qualified Name:     com.tencent.mm.plugin.card.ui.a.h
 * JD-Core Version:    0.7.0.1
 */