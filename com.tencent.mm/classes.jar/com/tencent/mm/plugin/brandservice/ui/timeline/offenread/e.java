package com.tencent.mm.plugin.brandservice.ui.timeline.offenread;

import android.util.Base64;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.g;
import com.tencent.mm.protocal.protobuf.dnu;
import com.tencent.mm.protocal.protobuf.dnw;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.bu;
import com.tencent.mm.storage.aj;
import com.tencent.mm.storage.am.a;
import java.io.IOException;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public final class e
{
  static dnu onb;
  
  public static boolean XT(String paramString)
  {
    AppMethodBeat.i(6135);
    if (bu.isNullOrNil(paramString))
    {
      AppMethodBeat.o(6135);
      return false;
    }
    Object localObject = bPQ();
    if (localObject == null)
    {
      AppMethodBeat.o(6135);
      return false;
    }
    localObject = ((dnu)localObject).HUT;
    if (bu.ht((List)localObject))
    {
      AppMethodBeat.o(6135);
      return false;
    }
    localObject = ((LinkedList)localObject).iterator();
    while (((Iterator)localObject).hasNext())
    {
      dnw localdnw = (dnw)((Iterator)localObject).next();
      if ((localdnw != null) && (paramString.equals(localdnw.FQp)))
      {
        AppMethodBeat.o(6135);
        return true;
      }
    }
    AppMethodBeat.o(6135);
    return false;
  }
  
  public static dnu bPQ()
  {
    AppMethodBeat.i(6134);
    if (onb != null)
    {
      localdnu = onb;
      AppMethodBeat.o(6134);
      return localdnu;
    }
    Object localObject = (String)g.ajR().ajA().get(am.a.IYo, "");
    if (bu.isNullOrNil((String)localObject))
    {
      AppMethodBeat.o(6134);
      return null;
    }
    dnu localdnu = new dnu();
    localObject = Base64.decode((String)localObject, 0);
    try
    {
      localdnu.parseFrom((byte[])localObject);
      onb = localdnu;
      AppMethodBeat.o(6134);
      return localdnu;
    }
    catch (IOException localIOException)
    {
      ae.e("MicroMsg.BizTimeLineOftenReadHelper", "getOftenRead exp: %s", new Object[] { localIOException.getMessage() });
      AppMethodBeat.o(6134);
    }
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.brandservice.ui.timeline.offenread.e
 * JD-Core Version:    0.7.0.1
 */