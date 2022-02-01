package com.tencent.mm.plugin.brandservice.ui.timeline.offenread;

import android.util.Base64;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.f;
import com.tencent.mm.kernel.h;
import com.tencent.mm.protocal.protobuf.fmz;
import com.tencent.mm.protocal.protobuf.fnc;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.aq;
import com.tencent.mm.storage.at.a;
import java.io.IOException;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public final class g
{
  private static fmz vPZ;
  
  public static boolean ajf(String paramString)
  {
    AppMethodBeat.i(6135);
    if (Util.isNullOrNil(paramString))
    {
      AppMethodBeat.o(6135);
      return false;
    }
    Object localObject = deD();
    if (localObject == null)
    {
      AppMethodBeat.o(6135);
      return false;
    }
    localObject = ((fmz)localObject).abNc;
    if (Util.isNullOrNil((List)localObject))
    {
      AppMethodBeat.o(6135);
      return false;
    }
    localObject = ((LinkedList)localObject).iterator();
    while (((Iterator)localObject).hasNext())
    {
      fnc localfnc = (fnc)((Iterator)localObject).next();
      if ((localfnc != null) && (paramString.equals(localfnc.YIf)))
      {
        AppMethodBeat.o(6135);
        return true;
      }
    }
    AppMethodBeat.o(6135);
    return false;
  }
  
  public static void b(fmz paramfmz)
  {
    AppMethodBeat.i(302251);
    vPZ = paramfmz;
    try
    {
      paramfmz = Base64.encodeToString(paramfmz.toByteArray(), 0);
      h.baE().ban().set(at.a.acWK, paramfmz);
      AppMethodBeat.o(302251);
      return;
    }
    catch (IOException paramfmz)
    {
      Log.e("MicroMsg.BizTimeLineOftenReadHelper", "resetOftenRead exp: %s", new Object[] { paramfmz.getMessage() });
      h.baE().ban().set(at.a.acWK, "");
      AppMethodBeat.o(302251);
    }
  }
  
  public static fmz deD()
  {
    AppMethodBeat.i(6134);
    if (vPZ != null)
    {
      localfmz = vPZ;
      AppMethodBeat.o(6134);
      return localfmz;
    }
    Object localObject = (String)h.baE().ban().get(at.a.acWK, "");
    if (Util.isNullOrNil((String)localObject))
    {
      AppMethodBeat.o(6134);
      return null;
    }
    fmz localfmz = new fmz();
    localObject = Base64.decode((String)localObject, 0);
    try
    {
      localfmz.parseFrom((byte[])localObject);
      vPZ = localfmz;
      AppMethodBeat.o(6134);
      return localfmz;
    }
    catch (IOException localIOException)
    {
      Log.e("MicroMsg.BizTimeLineOftenReadHelper", "getOftenRead exp: %s", new Object[] { localIOException.getMessage() });
      AppMethodBeat.o(6134);
    }
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.brandservice.ui.timeline.offenread.g
 * JD-Core Version:    0.7.0.1
 */