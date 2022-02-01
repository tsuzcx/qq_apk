package com.tencent.mm.plugin.appbrand.jsapi.file;

import android.content.Context;
import android.os.Bundle;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.tbs.reader.ITbsReaderCallback;
import com.tencent.tbs.reader.ReaderEngine;
import com.tencent.tbs.reader.ReaderMixerMode;
import com.tencent.tbs.reader.TbsReaderManager;

public final class av
{
  public static av kQG;
  private TbsReaderManager kQH;
  
  private av(Context paramContext)
  {
    AppMethodBeat.i(222526);
    this.kQH = null;
    ReaderEngine.getInstance().initReaderEntry(paramContext);
    this.kQH = new TbsReaderManager();
    AppMethodBeat.o(222526);
  }
  
  public static boolean canOpenFile(String paramString)
  {
    AppMethodBeat.i(222528);
    boolean bool = ReaderEngine.getInstance().isSupportExt(3, paramString);
    AppMethodBeat.o(222528);
    return bool;
  }
  
  public static av du(Context paramContext)
  {
    try
    {
      AppMethodBeat.i(222525);
      if (kQG == null) {
        kQG = new av(paramContext);
      }
      paramContext = kQG;
      AppMethodBeat.o(222525);
      return paramContext;
    }
    finally {}
  }
  
  public final int a(Context paramContext, Bundle paramBundle, ITbsReaderCallback paramITbsReaderCallback)
  {
    AppMethodBeat.i(222527);
    if (this.kQH == null)
    {
      AppMethodBeat.o(222527);
      return -1;
    }
    int i = this.kQH.createReaderMode(paramContext, paramITbsReaderCallback).openFile(paramBundle, null);
    AppMethodBeat.o(222527);
    return i;
  }
  
  public final void closeFileReader()
  {
    AppMethodBeat.i(222529);
    if (this.kQH != null) {
      this.kQH.destroy();
    }
    AppMethodBeat.o(222529);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.file.av
 * JD-Core Version:    0.7.0.1
 */