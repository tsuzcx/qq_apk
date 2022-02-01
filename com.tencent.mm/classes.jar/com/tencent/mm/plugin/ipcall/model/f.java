package com.tencent.mm.plugin.ipcall.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.Log;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public final class f
{
  private static Map<Integer, List<Integer>> JFY;
  public int sEu = -1;
  
  static
  {
    AppMethodBeat.i(25362);
    JFY = new HashMap();
    ArrayList localArrayList = new ArrayList();
    localArrayList.add(Integer.valueOf(3));
    localArrayList.add(Integer.valueOf(2));
    localArrayList.add(Integer.valueOf(8));
    localArrayList.add(Integer.valueOf(12));
    JFY.put(Integer.valueOf(1), localArrayList);
    localArrayList = new ArrayList();
    localArrayList.add(Integer.valueOf(12));
    localArrayList.add(Integer.valueOf(8));
    JFY.put(Integer.valueOf(2), localArrayList);
    localArrayList = new ArrayList();
    localArrayList.add(Integer.valueOf(4));
    localArrayList.add(Integer.valueOf(5));
    localArrayList.add(Integer.valueOf(8));
    localArrayList.add(Integer.valueOf(12));
    JFY.put(Integer.valueOf(3), localArrayList);
    localArrayList = new ArrayList();
    localArrayList.add(Integer.valueOf(5));
    localArrayList.add(Integer.valueOf(8));
    localArrayList.add(Integer.valueOf(12));
    JFY.put(Integer.valueOf(4), localArrayList);
    localArrayList = new ArrayList();
    localArrayList.add(Integer.valueOf(9));
    localArrayList.add(Integer.valueOf(10));
    localArrayList.add(Integer.valueOf(11));
    JFY.put(Integer.valueOf(5), localArrayList);
    AppMethodBeat.o(25362);
  }
  
  private boolean Zd(int paramInt)
  {
    AppMethodBeat.i(25360);
    if (this.sEu == -1)
    {
      AppMethodBeat.o(25360);
      return true;
    }
    if ((JFY.containsKey(Integer.valueOf(this.sEu))) && (((List)JFY.get(Integer.valueOf(this.sEu))).contains(Integer.valueOf(paramInt))))
    {
      AppMethodBeat.o(25360);
      return true;
    }
    AppMethodBeat.o(25360);
    return false;
  }
  
  public static String Ze(int paramInt)
  {
    AppMethodBeat.i(25361);
    switch (paramInt)
    {
    case 0: 
    case 6: 
    case 7: 
    default: 
      AppMethodBeat.o(25361);
      return String.valueOf(paramInt);
    case -1: 
      AppMethodBeat.o(25361);
      return "RESET_STATE";
    case 1: 
      AppMethodBeat.o(25361);
      return "START_INVITE";
    case 2: 
      AppMethodBeat.o(25361);
      return "INVITE_FAILED";
    case 3: 
      AppMethodBeat.o(25361);
      return "INVITE_SUCCESS";
    case 4: 
      AppMethodBeat.o(25361);
      return "RING_ING";
    case 5: 
      AppMethodBeat.o(25361);
      return "USER_ACCEPT";
    case 10: 
      AppMethodBeat.o(25361);
      return "OTHER_SIDE_USER_SHUTDOWN";
    case 8: 
      AppMethodBeat.o(25361);
      return "USER_CANCEL";
    case 9: 
      AppMethodBeat.o(25361);
      return "USER_SELF_SHUTDOWN";
    case 11: 
      AppMethodBeat.o(25361);
      return "USER_SELF_SHUTDOWN_BY_ERR";
    }
    AppMethodBeat.o(25361);
    return "CANCEL_BY_ERR";
  }
  
  public final boolean Zc(int paramInt)
  {
    AppMethodBeat.i(25359);
    if (Zd(paramInt))
    {
      Log.i("MicroMsg.IPCallStateIndicator", "updateState, origin: %s, new: %s", new Object[] { Ze(this.sEu), Ze(paramInt) });
      this.sEu = paramInt;
      AppMethodBeat.o(25359);
      return true;
    }
    Log.i("MicroMsg.IPCallStateIndicator", "transform state error, origin state: %s, new state: %s", new Object[] { Ze(h.fRu().sEu), Ze(paramInt) });
    AppMethodBeat.o(25359);
    return false;
  }
  
  public final boolean fRj()
  {
    return (this.sEu == 1) || (this.sEu == 3) || (this.sEu == 4) || (this.sEu == 5);
  }
  
  public final boolean fRk()
  {
    return (this.sEu == 4) || (this.sEu == 5);
  }
  
  public final boolean fRl()
  {
    return this.sEu == 5;
  }
  
  public final boolean fRm()
  {
    return this.sEu == 5;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes10.jar
 * Qualified Name:     com.tencent.mm.plugin.ipcall.model.f
 * JD-Core Version:    0.7.0.1
 */