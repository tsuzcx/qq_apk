package com.tencent.mm.plugin.brandservice.ui.timeline.offenread;

import android.util.Base64;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.f;
import com.tencent.mm.kernel.h;
import com.tencent.mm.protocal.protobuf.err;
import com.tencent.mm.protocal.protobuf.eru;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.ao;
import com.tencent.mm.storage.ar.a;
import java.io.IOException;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public final class g
{
  private static err sKa;
  
  public static boolean apE(String paramString)
  {
    AppMethodBeat.i(6135);
    if (Util.isNullOrNil(paramString))
    {
      AppMethodBeat.o(6135);
      return false;
    }
    Object localObject = cBq();
    if (localObject == null)
    {
      AppMethodBeat.o(6135);
      return false;
    }
    localObject = ((err)localObject).UtH;
    if (Util.isNullOrNil((List)localObject))
    {
      AppMethodBeat.o(6135);
      return false;
    }
    localObject = ((LinkedList)localObject).iterator();
    while (((Iterator)localObject).hasNext())
    {
      eru localeru = (eru)((Iterator)localObject).next();
      if ((localeru != null) && (paramString.equals(localeru.RKL)))
      {
        AppMethodBeat.o(6135);
        return true;
      }
    }
    AppMethodBeat.o(6135);
    return false;
  }
  
  public static void b(err paramerr)
  {
    AppMethodBeat.i(265640);
    sKa = paramerr;
    try
    {
      paramerr = Base64.encodeToString(paramerr.toByteArray(), 0);
      h.aHG().aHp().set(ar.a.Vvb, paramerr);
      AppMethodBeat.o(265640);
      return;
    }
    catch (IOException paramerr)
    {
      Log.e("MicroMsg.BizTimeLineOftenReadHelper", "resetOftenRead exp: %s", new Object[] { paramerr.getMessage() });
      h.aHG().aHp().set(ar.a.Vvb, "");
      AppMethodBeat.o(265640);
    }
  }
  
  public static err cBq()
  {
    AppMethodBeat.i(6134);
    if (sKa != null)
    {
      localerr = sKa;
      AppMethodBeat.o(6134);
      return localerr;
    }
    Object localObject = (String)h.aHG().aHp().get(ar.a.Vvb, "");
    if (Util.isNullOrNil((String)localObject))
    {
      AppMethodBeat.o(6134);
      return null;
    }
    err localerr = new err();
    localObject = Base64.decode((String)localObject, 0);
    try
    {
      localerr.parseFrom((byte[])localObject);
      sKa = localerr;
      AppMethodBeat.o(6134);
      return localerr;
    }
    catch (IOException localIOException)
    {
      Log.e("MicroMsg.BizTimeLineOftenReadHelper", "getOftenRead exp: %s", new Object[] { localIOException.getMessage() });
      AppMethodBeat.o(6134);
    }
    return null;
  }
  
  public static boolean cBr()
  {
    AppMethodBeat.i(265643);
    err localerr = cBq();
    if ((localerr != null) && (!Util.isNullOrNil(localerr.UtH)))
    {
      AppMethodBeat.o(265643);
      return false;
    }
    AppMethodBeat.o(265643);
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.brandservice.ui.timeline.offenread.g
 * JD-Core Version:    0.7.0.1
 */