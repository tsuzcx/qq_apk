package com.tencent.mm.plugin.brandservice.ui.timeline.offenread;

import android.util.Base64;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.g;
import com.tencent.mm.protocal.protobuf.dmx;
import com.tencent.mm.protocal.protobuf.dmz;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.storage.ai;
import com.tencent.mm.storage.al.a;
import java.io.IOException;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public final class e
{
  static dmx ohc;
  
  public static boolean Xh(String paramString)
  {
    AppMethodBeat.i(6135);
    if (bt.isNullOrNil(paramString))
    {
      AppMethodBeat.o(6135);
      return false;
    }
    Object localObject = bOS();
    if (localObject == null)
    {
      AppMethodBeat.o(6135);
      return false;
    }
    localObject = ((dmx)localObject).HBg;
    if (bt.hj((List)localObject))
    {
      AppMethodBeat.o(6135);
      return false;
    }
    localObject = ((LinkedList)localObject).iterator();
    while (((Iterator)localObject).hasNext())
    {
      dmz localdmz = (dmz)((Iterator)localObject).next();
      if ((localdmz != null) && (paramString.equals(localdmz.FxR)))
      {
        AppMethodBeat.o(6135);
        return true;
      }
    }
    AppMethodBeat.o(6135);
    return false;
  }
  
  public static dmx bOS()
  {
    AppMethodBeat.i(6134);
    if (ohc != null)
    {
      localdmx = ohc;
      AppMethodBeat.o(6134);
      return localdmx;
    }
    Object localObject = (String)g.ajC().ajl().get(al.a.IDO, "");
    if (bt.isNullOrNil((String)localObject))
    {
      AppMethodBeat.o(6134);
      return null;
    }
    dmx localdmx = new dmx();
    localObject = Base64.decode((String)localObject, 0);
    try
    {
      localdmx.parseFrom((byte[])localObject);
      ohc = localdmx;
      AppMethodBeat.o(6134);
      return localdmx;
    }
    catch (IOException localIOException)
    {
      ad.e("MicroMsg.BizTimeLineOftenReadHelper", "getOftenRead exp: %s", new Object[] { localIOException.getMessage() });
      AppMethodBeat.o(6134);
    }
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.brandservice.ui.timeline.offenread.e
 * JD-Core Version:    0.7.0.1
 */