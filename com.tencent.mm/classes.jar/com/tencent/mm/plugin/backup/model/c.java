package com.tencent.mm.plugin.backup.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.backup.b.d;
import com.tencent.mm.plugin.backup.bakoldlogic.bakoldpcmodel.a;

public final class c
{
  private static String TAG = "MicroMsg.BackupModelFactory";
  
  public static d FC(int paramInt)
  {
    AppMethodBeat.i(22163);
    switch (paramInt)
    {
    case 0: 
    default: 
      AppMethodBeat.o(22163);
      return null;
    case 1: 
      localObject = com.tencent.mm.plugin.backup.backuppcmodel.b.cVW();
      AppMethodBeat.o(22163);
      return localObject;
    case 2: 
      localObject = com.tencent.mm.plugin.backup.d.b.cVs();
      AppMethodBeat.o(22163);
      return localObject;
    }
    Object localObject = a.cWU();
    AppMethodBeat.o(22163);
    return localObject;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes11.jar
 * Qualified Name:     com.tencent.mm.plugin.backup.model.c
 * JD-Core Version:    0.7.0.1
 */