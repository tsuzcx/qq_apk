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
  public static at jRb;
  private TbsReaderManager jRc;
  
  private at(Context paramContext)
  {
    AppMethodBeat.i(195892);
    this.jRc = null;
    ReaderEngine.getInstance().initReaderEntry(paramContext);
    this.jRc = new TbsReaderManager();
    AppMethodBeat.o(195892);
  }
  
  public static boolean canOpenFile(String paramString)
  {
    AppMethodBeat.i(195894);
    boolean bool = ReaderEngine.getInstance().isSupportExt(3, paramString);
    AppMethodBeat.o(195894);
    return bool;
  }
  
  public static at dl(Context paramContext)
  {
    try
    {
      AppMethodBeat.i(195891);
      if (jRb == null) {
        jRb = new at(paramContext);
      }
      paramContext = jRb;
      AppMethodBeat.o(195891);
      return paramContext;
    }
    finally {}
  }
  
  public final int a(Context paramContext, Bundle paramBundle, ITbsReaderCallback paramITbsReaderCallback)
  {
    AppMethodBeat.i(195893);
    if (this.jRc == null)
    {
      AppMethodBeat.o(195893);
      return -1;
    }
    int i = this.jRc.createReaderMode(paramContext, paramITbsReaderCallback).openFile(paramBundle, null);
    AppMethodBeat.o(195893);
    return i;
  }
  
  public final void closeFileReader()
  {
    AppMethodBeat.i(195895);
    if (this.jRc != null) {
      this.jRc.destroy();
    }
    AppMethodBeat.o(195895);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.file.at
 * JD-Core Version:    0.7.0.1
 */