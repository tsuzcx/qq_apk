package com.tencent.mm.plugin.appbrand.jsapi.file;

import android.content.Context;
import android.os.Bundle;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.tbs.reader.ITbsReaderCallback;
import com.tencent.tbs.reader.ReaderEngine;
import com.tencent.tbs.reader.ReaderMixerMode;
import com.tencent.tbs.reader.TbsReaderManager;

public final class at
{
  public static at kNj;
  private TbsReaderManager kNk;
  
  private at(Context paramContext)
  {
    AppMethodBeat.i(188399);
    this.kNk = null;
    ReaderEngine.getInstance().initReaderEntry(paramContext);
    this.kNk = new TbsReaderManager();
    AppMethodBeat.o(188399);
  }
  
  public static boolean canOpenFile(String paramString)
  {
    AppMethodBeat.i(188401);
    boolean bool = ReaderEngine.getInstance().isSupportExt(3, paramString);
    AppMethodBeat.o(188401);
    return bool;
  }
  
  public static at ds(Context paramContext)
  {
    try
    {
      AppMethodBeat.i(188398);
      if (kNj == null) {
        kNj = new at(paramContext);
      }
      paramContext = kNj;
      AppMethodBeat.o(188398);
      return paramContext;
    }
    finally {}
  }
  
  public final int a(Context paramContext, Bundle paramBundle, ITbsReaderCallback paramITbsReaderCallback)
  {
    AppMethodBeat.i(188400);
    if (this.kNk == null)
    {
      AppMethodBeat.o(188400);
      return -1;
    }
    int i = this.kNk.createReaderMode(paramContext, paramITbsReaderCallback).openFile(paramBundle, null);
    AppMethodBeat.o(188400);
    return i;
  }
  
  public final void closeFileReader()
  {
    AppMethodBeat.i(188402);
    if (this.kNk != null) {
      this.kNk.destroy();
    }
    AppMethodBeat.o(188402);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.file.at
 * JD-Core Version:    0.7.0.1
 */