package com.tencent.mm.plugin.ipcall.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ab;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public final class f
{
  private static Map<Integer, List<Integer>> nMd;
  public int mCurrentState = -1;
  
  static
  {
    AppMethodBeat.i(21742);
    nMd = new HashMap();
    ArrayList localArrayList = new ArrayList();
    localArrayList.add(Integer.valueOf(3));
    localArrayList.add(Integer.valueOf(2));
    localArrayList.add(Integer.valueOf(8));
    localArrayList.add(Integer.valueOf(12));
    nMd.put(Integer.valueOf(1), localArrayList);
    localArrayList = new ArrayList();
    localArrayList.add(Integer.valueOf(12));
    localArrayList.add(Integer.valueOf(8));
    nMd.put(Integer.valueOf(2), localArrayList);
    localArrayList = new ArrayList();
    localArrayList.add(Integer.valueOf(4));
    localArrayList.add(Integer.valueOf(5));
    localArrayList.add(Integer.valueOf(8));
    localArrayList.add(Integer.valueOf(12));
    nMd.put(Integer.valueOf(3), localArrayList);
    localArrayList = new ArrayList();
    localArrayList.add(Integer.valueOf(5));
    localArrayList.add(Integer.valueOf(8));
    localArrayList.add(Integer.valueOf(12));
    nMd.put(Integer.valueOf(4), localArrayList);
    localArrayList = new ArrayList();
    localArrayList.add(Integer.valueOf(9));
    localArrayList.add(Integer.valueOf(10));
    localArrayList.add(Integer.valueOf(11));
    nMd.put(Integer.valueOf(5), localArrayList);
    AppMethodBeat.o(21742);
  }
  
  public static String stateToString(int paramInt)
  {
    AppMethodBeat.i(21741);
    switch (paramInt)
    {
    case 0: 
    case 6: 
    case 7: 
    default: 
      AppMethodBeat.o(21741);
      return String.valueOf(paramInt);
    case -1: 
      AppMethodBeat.o(21741);
      return "RESET_STATE";
    case 1: 
      AppMethodBeat.o(21741);
      return "START_INVITE";
    case 2: 
      AppMethodBeat.o(21741);
      return "INVITE_FAILED";
    case 3: 
      AppMethodBeat.o(21741);
      return "INVITE_SUCCESS";
    case 4: 
      AppMethodBeat.o(21741);
      return "RING_ING";
    case 5: 
      AppMethodBeat.o(21741);
      return "USER_ACCEPT";
    case 10: 
      AppMethodBeat.o(21741);
      return "OTHER_SIDE_USER_SHUTDOWN";
    case 8: 
      AppMethodBeat.o(21741);
      return "USER_CANCEL";
    case 9: 
      AppMethodBeat.o(21741);
      return "USER_SELF_SHUTDOWN";
    case 11: 
      AppMethodBeat.o(21741);
      return "USER_SELF_SHUTDOWN_BY_ERR";
    }
    AppMethodBeat.o(21741);
    return "CANCEL_BY_ERR";
  }
  
  private boolean xG(int paramInt)
  {
    AppMethodBeat.i(21740);
    if (this.mCurrentState == -1)
    {
      AppMethodBeat.o(21740);
      return true;
    }
    if ((nMd.containsKey(Integer.valueOf(this.mCurrentState))) && (((List)nMd.get(Integer.valueOf(this.mCurrentState))).contains(Integer.valueOf(paramInt))))
    {
      AppMethodBeat.o(21740);
      return true;
    }
    AppMethodBeat.o(21740);
    return false;
  }
  
  public final boolean bJh()
  {
    return (this.mCurrentState == 1) || (this.mCurrentState == 3) || (this.mCurrentState == 4) || (this.mCurrentState == 5);
  }
  
  public final boolean bJi()
  {
    return (this.mCurrentState == 4) || (this.mCurrentState == 5);
  }
  
  public final boolean bJj()
  {
    return this.mCurrentState == 5;
  }
  
  public final boolean bJk()
  {
    return this.mCurrentState == 5;
  }
  
  public final boolean xF(int paramInt)
  {
    AppMethodBeat.i(21739);
    if (xG(paramInt))
    {
      ab.i("MicroMsg.IPCallStateIndicator", "updateState, origin: %s, new: %s", new Object[] { stateToString(this.mCurrentState), stateToString(paramInt) });
      this.mCurrentState = paramInt;
      AppMethodBeat.o(21739);
      return true;
    }
    ab.i("MicroMsg.IPCallStateIndicator", "transform state error, origin state: %s, new state: %s", new Object[] { stateToString(i.bJr().mCurrentState), stateToString(paramInt) });
    AppMethodBeat.o(21739);
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.ipcall.a.f
 * JD-Core Version:    0.7.0.1
 */