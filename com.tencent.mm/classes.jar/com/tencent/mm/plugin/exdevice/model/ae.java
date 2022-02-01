package com.tencent.mm.plugin.exdevice.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.Iterator;
import java.util.LinkedList;

public final class ae
{
  public String deviceID;
  public String displayName;
  public boolean hEm = false;
  public String hEr;
  public String hFR;
  public int hFT = 0;
  public LinkedList<Integer> hFU = null;
  public String hFX;
  public String iconUrl;
  public int progress;
  public String ysj;
  
  public final boolean Ld(int paramInt)
  {
    AppMethodBeat.i(274587);
    Object localObject = this.hFU;
    if ((localObject == null) || (((LinkedList)localObject).isEmpty()))
    {
      AppMethodBeat.o(274587);
      return false;
    }
    localObject = ((LinkedList)localObject).iterator();
    while (((Iterator)localObject).hasNext()) {
      if (((Integer)((Iterator)localObject).next()).intValue() == paramInt)
      {
        AppMethodBeat.o(274587);
        return true;
      }
    }
    AppMethodBeat.o(274587);
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.exdevice.model.ae
 * JD-Core Version:    0.7.0.1
 */