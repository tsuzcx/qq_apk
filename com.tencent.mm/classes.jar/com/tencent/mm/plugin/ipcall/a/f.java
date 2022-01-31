package com.tencent.mm.plugin.ipcall.a;

import com.tencent.mm.sdk.platformtools.y;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public final class f
{
  private static Map<Integer, List<Integer>> loH = new HashMap();
  public int mCurrentState = -1;
  
  static
  {
    ArrayList localArrayList = new ArrayList();
    localArrayList.add(Integer.valueOf(3));
    localArrayList.add(Integer.valueOf(2));
    localArrayList.add(Integer.valueOf(8));
    localArrayList.add(Integer.valueOf(12));
    loH.put(Integer.valueOf(1), localArrayList);
    localArrayList = new ArrayList();
    localArrayList.add(Integer.valueOf(12));
    localArrayList.add(Integer.valueOf(8));
    loH.put(Integer.valueOf(2), localArrayList);
    localArrayList = new ArrayList();
    localArrayList.add(Integer.valueOf(4));
    localArrayList.add(Integer.valueOf(5));
    localArrayList.add(Integer.valueOf(8));
    localArrayList.add(Integer.valueOf(12));
    loH.put(Integer.valueOf(3), localArrayList);
    localArrayList = new ArrayList();
    localArrayList.add(Integer.valueOf(5));
    localArrayList.add(Integer.valueOf(8));
    localArrayList.add(Integer.valueOf(12));
    loH.put(Integer.valueOf(4), localArrayList);
    localArrayList = new ArrayList();
    localArrayList.add(Integer.valueOf(9));
    localArrayList.add(Integer.valueOf(10));
    localArrayList.add(Integer.valueOf(11));
    loH.put(Integer.valueOf(5), localArrayList);
  }
  
  public static String stateToString(int paramInt)
  {
    switch (paramInt)
    {
    case 0: 
    case 6: 
    case 7: 
    default: 
      return String.valueOf(paramInt);
    case -1: 
      return "RESET_STATE";
    case 1: 
      return "START_INVITE";
    case 2: 
      return "INVITE_FAILED";
    case 3: 
      return "INVITE_SUCCESS";
    case 4: 
      return "RING_ING";
    case 5: 
      return "USER_ACCEPT";
    case 10: 
      return "OTHER_SIDE_USER_SHUTDOWN";
    case 8: 
      return "USER_CANCEL";
    case 9: 
      return "USER_SELF_SHUTDOWN";
    case 11: 
      return "USER_SELF_SHUTDOWN_BY_ERR";
    }
    return "CANCEL_BY_ERR";
  }
  
  public final boolean bca()
  {
    return (this.mCurrentState == 1) || (this.mCurrentState == 3) || (this.mCurrentState == 4) || (this.mCurrentState == 5);
  }
  
  public final boolean bcb()
  {
    return (this.mCurrentState == 4) || (this.mCurrentState == 5);
  }
  
  public final boolean bcc()
  {
    return this.mCurrentState == 5;
  }
  
  public final boolean bcd()
  {
    return this.mCurrentState == 5;
  }
  
  public final boolean sF(int paramInt)
  {
    int i;
    if (this.mCurrentState == -1) {
      i = 1;
    }
    while (i != 0)
    {
      y.i("MicroMsg.IPCallStateIndicator", "updateState, origin: %s, new: %s", new Object[] { stateToString(this.mCurrentState), stateToString(paramInt) });
      this.mCurrentState = paramInt;
      return true;
      if ((loH.containsKey(Integer.valueOf(this.mCurrentState))) && (((List)loH.get(Integer.valueOf(this.mCurrentState))).contains(Integer.valueOf(paramInt)))) {
        i = 1;
      } else {
        i = 0;
      }
    }
    y.i("MicroMsg.IPCallStateIndicator", "transform state error, origin state: %s, new state: %s", new Object[] { stateToString(i.bck().mCurrentState), stateToString(paramInt) });
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.ipcall.a.f
 * JD-Core Version:    0.7.0.1
 */