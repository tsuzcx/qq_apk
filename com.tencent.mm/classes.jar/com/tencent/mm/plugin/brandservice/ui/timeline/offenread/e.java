package com.tencent.mm.plugin.brandservice.ui.timeline.offenread;

import android.util.Base64;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.g;
import com.tencent.mm.protocal.protobuf.dbw;
import com.tencent.mm.protocal.protobuf.dby;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.storage.ab;
import com.tencent.mm.storage.ae.a;
import java.io.IOException;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public final class e
{
  static dbw nbQ;
  
  public static boolean Pp(String paramString)
  {
    AppMethodBeat.i(6135);
    if (bt.isNullOrNil(paramString))
    {
      AppMethodBeat.o(6135);
      return false;
    }
    Object localObject = bDe();
    if (localObject == null)
    {
      AppMethodBeat.o(6135);
      return false;
    }
    localObject = ((dbw)localObject).Etz;
    if (bt.gL((List)localObject))
    {
      AppMethodBeat.o(6135);
      return false;
    }
    localObject = ((LinkedList)localObject).iterator();
    while (((Iterator)localObject).hasNext())
    {
      dby localdby = (dby)((Iterator)localObject).next();
      if ((localdby != null) && (paramString.equals(localdby.CAc)))
      {
        AppMethodBeat.o(6135);
        return true;
      }
    }
    AppMethodBeat.o(6135);
    return false;
  }
  
  public static dbw bDe()
  {
    AppMethodBeat.i(6134);
    if (nbQ != null)
    {
      localdbw = nbQ;
      AppMethodBeat.o(6134);
      return localdbw;
    }
    Object localObject = (String)g.afB().afk().get(ae.a.Ftq, "");
    if (bt.isNullOrNil((String)localObject))
    {
      AppMethodBeat.o(6134);
      return null;
    }
    dbw localdbw = new dbw();
    localObject = Base64.decode((String)localObject, 0);
    try
    {
      localdbw.parseFrom((byte[])localObject);
      nbQ = localdbw;
      AppMethodBeat.o(6134);
      return localdbw;
    }
    catch (IOException localIOException)
    {
      ad.e("MicroMsg.BizTimeLineOftenReadHelper", "getOftenRead exp: %s", new Object[] { localIOException.getMessage() });
      AppMethodBeat.o(6134);
    }
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.brandservice.ui.timeline.offenread.e
 * JD-Core Version:    0.7.0.1
 */