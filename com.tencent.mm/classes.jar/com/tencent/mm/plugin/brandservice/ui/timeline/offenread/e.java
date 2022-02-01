package com.tencent.mm.plugin.brandservice.ui.timeline.offenread;

import android.util.Base64;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.g;
import com.tencent.mm.protocal.protobuf.dhi;
import com.tencent.mm.protocal.protobuf.dhk;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.bs;
import com.tencent.mm.storage.ae;
import com.tencent.mm.storage.ah.a;
import java.io.IOException;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public final class e
{
  static dhi nEA;
  
  public static boolean TA(String paramString)
  {
    AppMethodBeat.i(6135);
    if (bs.isNullOrNil(paramString))
    {
      AppMethodBeat.o(6135);
      return false;
    }
    Object localObject = bKr();
    if (localObject == null)
    {
      AppMethodBeat.o(6135);
      return false;
    }
    localObject = ((dhi)localObject).FQB;
    if (bs.gY((List)localObject))
    {
      AppMethodBeat.o(6135);
      return false;
    }
    localObject = ((LinkedList)localObject).iterator();
    while (((Iterator)localObject).hasNext())
    {
      dhk localdhk = (dhk)((Iterator)localObject).next();
      if ((localdhk != null) && (paramString.equals(localdhk.DSy)))
      {
        AppMethodBeat.o(6135);
        return true;
      }
    }
    AppMethodBeat.o(6135);
    return false;
  }
  
  public static dhi bKr()
  {
    AppMethodBeat.i(6134);
    if (nEA != null)
    {
      localdhi = nEA;
      AppMethodBeat.o(6134);
      return localdhi;
    }
    Object localObject = (String)g.agR().agA().get(ah.a.GRk, "");
    if (bs.isNullOrNil((String)localObject))
    {
      AppMethodBeat.o(6134);
      return null;
    }
    dhi localdhi = new dhi();
    localObject = Base64.decode((String)localObject, 0);
    try
    {
      localdhi.parseFrom((byte[])localObject);
      nEA = localdhi;
      AppMethodBeat.o(6134);
      return localdhi;
    }
    catch (IOException localIOException)
    {
      ac.e("MicroMsg.BizTimeLineOftenReadHelper", "getOftenRead exp: %s", new Object[] { localIOException.getMessage() });
      AppMethodBeat.o(6134);
    }
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.brandservice.ui.timeline.offenread.e
 * JD-Core Version:    0.7.0.1
 */