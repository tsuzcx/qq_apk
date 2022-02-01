package com.tencent.mm.plugin.brandservice.ui.timeline.offenread;

import android.util.Base64;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.e;
import com.tencent.mm.kernel.g;
import com.tencent.mm.protocal.protobuf.ehp;
import com.tencent.mm.protocal.protobuf.ehs;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.ao;
import com.tencent.mm.storage.ar.a;
import java.io.IOException;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public final class f
{
  static ehp pzR;
  
  public static boolean ahR(String paramString)
  {
    AppMethodBeat.i(6135);
    if (Util.isNullOrNil(paramString))
    {
      AppMethodBeat.o(6135);
      return false;
    }
    Object localObject = cnr();
    if (localObject == null)
    {
      AppMethodBeat.o(6135);
      return false;
    }
    localObject = ((ehp)localObject).Nhd;
    if (Util.isNullOrNil((List)localObject))
    {
      AppMethodBeat.o(6135);
      return false;
    }
    localObject = ((LinkedList)localObject).iterator();
    while (((Iterator)localObject).hasNext())
    {
      ehs localehs = (ehs)((Iterator)localObject).next();
      if ((localehs != null) && (paramString.equals(localehs.KJV)))
      {
        AppMethodBeat.o(6135);
        return true;
      }
    }
    AppMethodBeat.o(6135);
    return false;
  }
  
  public static ehp cnr()
  {
    AppMethodBeat.i(6134);
    if (pzR != null)
    {
      localehp = pzR;
      AppMethodBeat.o(6134);
      return localehp;
    }
    Object localObject = (String)g.aAh().azQ().get(ar.a.OgL, "");
    if (Util.isNullOrNil((String)localObject))
    {
      AppMethodBeat.o(6134);
      return null;
    }
    ehp localehp = new ehp();
    localObject = Base64.decode((String)localObject, 0);
    try
    {
      localehp.parseFrom((byte[])localObject);
      pzR = localehp;
      AppMethodBeat.o(6134);
      return localehp;
    }
    catch (IOException localIOException)
    {
      Log.e("MicroMsg.BizTimeLineOftenReadHelper", "getOftenRead exp: %s", new Object[] { localIOException.getMessage() });
      AppMethodBeat.o(6134);
    }
    return null;
  }
  
  public static boolean cns()
  {
    AppMethodBeat.i(195021);
    ehp localehp = cnr();
    if ((localehp != null) && (!Util.isNullOrNil(localehp.Nhd)))
    {
      AppMethodBeat.o(195021);
      return false;
    }
    AppMethodBeat.o(195021);
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.brandservice.ui.timeline.offenread.f
 * JD-Core Version:    0.7.0.1
 */