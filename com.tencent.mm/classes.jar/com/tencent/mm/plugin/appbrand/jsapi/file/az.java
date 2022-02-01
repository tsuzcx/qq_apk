package com.tencent.mm.plugin.appbrand.jsapi.file;

import android.content.Context;
import android.os.Bundle;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.tbs.reader.ITbsReaderCallback;
import com.tencent.tbs.reader.ReaderEngine;
import com.tencent.tbs.reader.TbsFileInterfaceImpl;

public final class az
{
  public static az rYh;
  private TbsFileInterfaceImpl rYi;
  
  private az(Context paramContext)
  {
    AppMethodBeat.i(329087);
    this.rYi = null;
    ReaderEngine.getInstance().initReaderEntry(paramContext);
    this.rYi = new TbsFileInterfaceImpl();
    AppMethodBeat.o(329087);
  }
  
  public static az eJ(Context paramContext)
  {
    try
    {
      AppMethodBeat.i(329083);
      if (rYh == null) {
        rYh = new az(paramContext);
      }
      paramContext = rYh;
      AppMethodBeat.o(329083);
      return paramContext;
    }
    finally {}
  }
  
  public final int a(Context paramContext, Bundle paramBundle, ITbsReaderCallback paramITbsReaderCallback)
  {
    AppMethodBeat.i(329093);
    if (this.rYi == null)
    {
      AppMethodBeat.o(329093);
      return -1;
    }
    int i = this.rYi.openFileReader(paramContext, paramBundle, paramITbsReaderCallback, null);
    AppMethodBeat.o(329093);
    return i;
  }
  
  public final void closeFileReader()
  {
    AppMethodBeat.i(329095);
    if (this.rYi != null) {
      this.rYi.closeFileReader();
    }
    AppMethodBeat.o(329095);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.file.az
 * JD-Core Version:    0.7.0.1
 */