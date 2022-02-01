package com.tencent.mm.plugin.appbrand.jsapi.file;

import android.content.Context;
import android.os.Bundle;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.tbs.reader.ITbsReaderCallback;
import com.tencent.tbs.reader.ReaderEngine;
import com.tencent.tbs.reader.TbsFileInterfaceImpl;

public final class av
{
  public static av lVK;
  private TbsFileInterfaceImpl lVL;
  
  private av(Context paramContext)
  {
    AppMethodBeat.i(226831);
    this.lVL = null;
    ReaderEngine.getInstance().initReaderEntry(paramContext);
    this.lVL = new TbsFileInterfaceImpl();
    AppMethodBeat.o(226831);
  }
  
  public static av dP(Context paramContext)
  {
    try
    {
      AppMethodBeat.i(226830);
      if (lVK == null) {
        lVK = new av(paramContext);
      }
      paramContext = lVK;
      AppMethodBeat.o(226830);
      return paramContext;
    }
    finally {}
  }
  
  public final int a(Context paramContext, Bundle paramBundle, ITbsReaderCallback paramITbsReaderCallback)
  {
    AppMethodBeat.i(226832);
    if (this.lVL == null)
    {
      AppMethodBeat.o(226832);
      return -1;
    }
    int i = this.lVL.openFileReader(paramContext, paramBundle, paramITbsReaderCallback, null);
    AppMethodBeat.o(226832);
    return i;
  }
  
  public final void closeFileReader()
  {
    AppMethodBeat.i(226833);
    if (this.lVL != null) {
      this.lVL.closeFileReader();
    }
    AppMethodBeat.o(226833);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.file.av
 * JD-Core Version:    0.7.0.1
 */