package com.tencent.mm.plugin.appbrand.jsapi.file;

import android.content.Context;
import android.os.Bundle;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.tbs.reader.ITbsReaderCallback;
import com.tencent.tbs.reader.ReaderEngine;
import com.tencent.tbs.reader.TbsFileInterfaceImpl;

public final class ax
{
  public static ax oSO;
  private TbsFileInterfaceImpl oSP;
  
  private ax(Context paramContext)
  {
    AppMethodBeat.i(272761);
    this.oSP = null;
    ReaderEngine.getInstance().initReaderEntry(paramContext);
    this.oSP = new TbsFileInterfaceImpl();
    AppMethodBeat.o(272761);
  }
  
  public static ax dO(Context paramContext)
  {
    try
    {
      AppMethodBeat.i(272760);
      if (oSO == null) {
        oSO = new ax(paramContext);
      }
      paramContext = oSO;
      AppMethodBeat.o(272760);
      return paramContext;
    }
    finally {}
  }
  
  public final int a(Context paramContext, Bundle paramBundle, ITbsReaderCallback paramITbsReaderCallback)
  {
    AppMethodBeat.i(272762);
    if (this.oSP == null)
    {
      AppMethodBeat.o(272762);
      return -1;
    }
    int i = this.oSP.openFileReader(paramContext, paramBundle, paramITbsReaderCallback, null);
    AppMethodBeat.o(272762);
    return i;
  }
  
  public final void closeFileReader()
  {
    AppMethodBeat.i(272763);
    if (this.oSP != null) {
      this.oSP.closeFileReader();
    }
    AppMethodBeat.o(272763);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.file.ax
 * JD-Core Version:    0.7.0.1
 */