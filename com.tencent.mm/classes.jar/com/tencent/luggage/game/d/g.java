package com.tencent.luggage.game.d;

import android.app.ActivityManager;
import android.content.Context;
import android.os.Debug.MemoryInfo;
import android.os.Process;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ah;

public enum g
{
  static
  {
    AppMethodBeat.i(140411);
    bAQ = new g("INST");
    bAR = new g[] { bAQ };
    AppMethodBeat.o(140411);
  }
  
  private g() {}
  
  public static g.a uL()
  {
    AppMethodBeat.i(140410);
    g.a locala = new g.a();
    Object localObject = (ActivityManager)ah.getContext().getSystemService("activity");
    if (localObject != null)
    {
      localObject = ((ActivityManager)localObject).getProcessMemoryInfo(new int[] { Process.myPid() });
      if ((localObject == null) || (localObject.length <= 0)) {}
    }
    for (localObject = localObject[0]; localObject == null; localObject = null)
    {
      AppMethodBeat.o(140410);
      return locala;
    }
    locala.bAS = (((Debug.MemoryInfo)localObject).getTotalPss() / 1024);
    locala.bAT = (((Debug.MemoryInfo)localObject).nativePss / 1024);
    locala.bAU = (((Debug.MemoryInfo)localObject).dalvikPss / 1024);
    locala.bAV = (((Debug.MemoryInfo)localObject).otherPss / 1024);
    AppMethodBeat.o(140410);
    return locala;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.luggage.game.d.g
 * JD-Core Version:    0.7.0.1
 */