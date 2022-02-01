package com.tencent.mm.plugin.brandservice.ui.timeline.offenread;

import androidx.recyclerview.widget.g.a;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.Util;
import java.util.List;

public final class d
  extends g.a
{
  private List<e> vPM;
  private List<e> vPN;
  boolean vPO = false;
  
  public d(List<e> paramList1, List<e> paramList2)
  {
    this.vPM = paramList1;
    this.vPN = paramList2;
  }
  
  private static e A(List<e> paramList, int paramInt)
  {
    AppMethodBeat.i(302226);
    if (paramInt < paramList.size())
    {
      paramList = (e)paramList.get(paramInt);
      AppMethodBeat.o(302226);
      return paramList;
    }
    AppMethodBeat.o(302226);
    return null;
  }
  
  public final int If()
  {
    AppMethodBeat.i(302230);
    if (this.vPM != null)
    {
      int i = this.vPM.size();
      AppMethodBeat.o(302230);
      return i;
    }
    AppMethodBeat.o(302230);
    return 0;
  }
  
  public final int Ig()
  {
    AppMethodBeat.i(302234);
    if (this.vPN != null)
    {
      int i = this.vPN.size();
      AppMethodBeat.o(302234);
      return i;
    }
    AppMethodBeat.o(302234);
    return 0;
  }
  
  public final boolean aU(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(302241);
    e locale1 = A(this.vPM, paramInt1);
    e locale2 = A(this.vPN, paramInt2);
    if ((locale1 != null) && (locale2 != null))
    {
      boolean bool = Util.isEqual(locale1.YIf, locale2.YIf);
      AppMethodBeat.o(302241);
      return bool;
    }
    AppMethodBeat.o(302241);
    return false;
  }
  
  public final boolean aV(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(302247);
    e locale1 = A(this.vPM, paramInt1);
    e locale2 = A(this.vPN, paramInt2);
    if (((locale1 instanceof f)) && ((locale2 instanceof f)))
    {
      if (this.vPO)
      {
        AppMethodBeat.o(302247);
        return false;
      }
      AppMethodBeat.o(302247);
      return true;
    }
    if ((locale1.vPQ == locale2.vPQ) && (locale1.vPT == locale2.vPT) && (locale1.vPU == locale2.vPU)) {
      if ((locale1.nQG == null) || (!locale1.nQG.equalsIgnoreCase(locale2.nQG))) {
        break label193;
      }
    }
    label193:
    for (paramInt1 = 1; (paramInt1 == 0) || (locale1.uWw != locale2.uWw) || (locale1.weight != locale2.weight) || (locale1.vPP != locale2.vPP) || (locale1.YSM != locale2.YSM) || (locale1.vPR != locale2.vPR); paramInt1 = 0)
    {
      AppMethodBeat.o(302247);
      return false;
    }
    AppMethodBeat.o(302247);
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes10.jar
 * Qualified Name:     com.tencent.mm.plugin.brandservice.ui.timeline.offenread.d
 * JD-Core Version:    0.7.0.1
 */