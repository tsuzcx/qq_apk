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
  public static at krN;
  private TbsReaderManager krO;
  
  private at(Context paramContext)
  {
    AppMethodBeat.i(186666);
    this.krO = null;
    ReaderEngine.getInstance().initReaderEntry(paramContext);
    this.krO = new TbsReaderManager();
    AppMethodBeat.o(186666);
  }
  
  public static boolean canOpenFile(String paramString)
  {
    AppMethodBeat.i(186668);
    boolean bool = ReaderEngine.getInstance().isSupportExt(3, paramString);
    AppMethodBeat.o(186668);
    return bool;
  }
  
  public static at du(Context paramContext)
  {
    try
    {
      AppMethodBeat.i(186665);
      if (krN == null) {
        krN = new at(paramContext);
      }
      paramContext = krN;
      AppMethodBeat.o(186665);
      return paramContext;
    }
    finally {}
  }
  
  public final int a(Context paramContext, Bundle paramBundle, ITbsReaderCallback paramITbsReaderCallback)
  {
    AppMethodBeat.i(186667);
    if (this.krO == null)
    {
      AppMethodBeat.o(186667);
      return -1;
    }
    int i = this.krO.createReaderMode(paramContext, paramITbsReaderCallback).openFile(paramBundle, null);
    AppMethodBeat.o(186667);
    return i;
  }
  
  public final void closeFileReader()
  {
    AppMethodBeat.i(186669);
    if (this.krO != null) {
      this.krO.destroy();
    }
    AppMethodBeat.o(186669);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.file.at
 * JD-Core Version:    0.7.0.1
 */