package com.tencent.mm.plugin.brandservice.ui.timeline.offenread;

import android.util.Base64;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.e;
import com.tencent.mm.kernel.g;
import com.tencent.mm.protocal.protobuf.ckd;
import com.tencent.mm.protocal.protobuf.cke;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.storage.ac.a;
import com.tencent.mm.storage.z;
import java.io.IOException;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public final class d
{
  static ckd jZu;
  
  public static boolean GO(String paramString)
  {
    AppMethodBeat.i(14343);
    if (bo.isNullOrNil(paramString))
    {
      AppMethodBeat.o(14343);
      return false;
    }
    Object localObject = aXb();
    if (localObject == null)
    {
      AppMethodBeat.o(14343);
      return false;
    }
    localObject = ((ckd)localObject).xUg;
    if (bo.es((List)localObject))
    {
      AppMethodBeat.o(14343);
      return false;
    }
    localObject = ((LinkedList)localObject).iterator();
    while (((Iterator)localObject).hasNext())
    {
      cke localcke = (cke)((Iterator)localObject).next();
      if ((localcke != null) && (paramString.equals(localcke.wqR)))
      {
        AppMethodBeat.o(14343);
        return true;
      }
    }
    AppMethodBeat.o(14343);
    return false;
  }
  
  public static ckd aXb()
  {
    AppMethodBeat.i(14342);
    if (jZu != null)
    {
      localckd = jZu;
      AppMethodBeat.o(14342);
      return localckd;
    }
    Object localObject = (String)g.RL().Ru().get(ac.a.yKf, "");
    if (bo.isNullOrNil((String)localObject))
    {
      AppMethodBeat.o(14342);
      return null;
    }
    ckd localckd = new ckd();
    localObject = Base64.decode((String)localObject, 0);
    try
    {
      localckd.parseFrom((byte[])localObject);
      jZu = localckd;
      AppMethodBeat.o(14342);
      return localckd;
    }
    catch (IOException localIOException)
    {
      ab.e("MicroMsg.BizTimeLineOftenReadHelper", "getOftenRead exp: %s", new Object[] { localIOException.getMessage() });
      AppMethodBeat.o(14342);
    }
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.brandservice.ui.timeline.offenread.d
 * JD-Core Version:    0.7.0.1
 */