package com.tencent.mm.plugin.datareport.j;

import android.os.Looper;
import android.os.Message;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.MMHandler;
import com.tencent.mm.sdk.platformtools.MMHandler.Callback;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public final class c
{
  private static List<MMHandler.Callback> cQ;
  private static final MMHandler xia;
  private static final MMHandler xib;
  
  static
  {
    AppMethodBeat.i(262832);
    xia = new MMHandler(Looper.getMainLooper());
    xib = new MMHandler("DataReportService#ThreadUtils#ASYNC_HANDLER", new MMHandler.Callback()
    {
      public final boolean handleMessage(Message paramAnonymousMessage)
      {
        AppMethodBeat.i(262834);
        boolean bool1 = false;
        Iterator localIterator = c.cQ.iterator();
        while (localIterator.hasNext())
        {
          boolean bool2 = ((MMHandler.Callback)localIterator.next()).handleMessage(paramAnonymousMessage);
          bool1 = bool2;
          if (bool2) {
            bool1 = bool2;
          }
        }
        AppMethodBeat.o(262834);
        return bool1;
      }
    });
    cQ = new ArrayList();
    AppMethodBeat.o(262832);
  }
  
  public static MMHandler a(MMHandler.Callback paramCallback)
  {
    AppMethodBeat.i(262817);
    if ((paramCallback != null) && (paramCallback != null) && (!cQ.contains(paramCallback))) {
      cQ.add(paramCallback);
    }
    paramCallback = xib;
    AppMethodBeat.o(262817);
    return paramCallback;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.datareport.j.c
 * JD-Core Version:    0.7.0.1
 */