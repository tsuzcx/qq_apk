package com.tencent.mm.plugin.expt.hellhound.core.v2.a;

import android.os.Bundle;
import android.text.TextUtils;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.protocal.protobuf.azc;
import com.tencent.mm.protocal.protobuf.bkf;
import com.tencent.mm.sdk.platformtools.ab;
import java.util.Iterator;
import java.util.LinkedList;

public final class b
{
  public static void Q(Bundle paramBundle)
  {
    AppMethodBeat.i(152293);
    if (paramBundle == null)
    {
      AppMethodBeat.o(152293);
      return;
    }
    paramBundle = paramBundle.getString("Chat_User");
    if (!TextUtils.isEmpty(paramBundle))
    {
      ab.d("FragmentBundleDao", "habbyge-mali, FragmentBundleDao, putBundle: ".concat(String.valueOf(paramBundle)));
      eh("Chat_User", paramBundle);
    }
    AppMethodBeat.o(152293);
  }
  
  public static bkf brN()
  {
    AppMethodBeat.i(152295);
    byte[] arrayOfByte = com.tencent.mm.plugin.expt.hellhound.core.a.b.getBytes("hell_fgm_bun_mmkv_key");
    if ((arrayOfByte == null) || (arrayOfByte.length <= 0))
    {
      AppMethodBeat.o(152295);
      return null;
    }
    bkf localbkf = new bkf();
    try
    {
      localbkf.parseFrom(arrayOfByte);
      AppMethodBeat.o(152295);
      return localbkf;
    }
    catch (Exception localException)
    {
      for (;;)
      {
        ab.printErrStackTrace("FragmentBundleDao", localException, "habbyge-mali, FragmentBundleDao _doRead parse", new Object[0]);
        Object localObject = null;
      }
    }
  }
  
  private static void eh(String paramString1, String paramString2)
  {
    AppMethodBeat.i(152294);
    bkf localbkf = brN();
    if (localbkf == null) {
      localbkf = new bkf();
    }
    for (;;)
    {
      Object localObject = localbkf.xyH.iterator();
      while (((Iterator)localObject).hasNext())
      {
        azc localazc = (azc)((Iterator)localObject).next();
        if ((localazc != null) && (paramString1.equals(localazc.key))) {
          localbkf.xyH.remove(localazc);
        }
      }
      localObject = new azc();
      ((azc)localObject).key = paramString1;
      ((azc)localObject).value = paramString2;
      localbkf.xyH.add(localObject);
      try
      {
        com.tencent.mm.plugin.expt.hellhound.core.a.b.v("hell_fgm_bun_mmkv_key", localbkf.toByteArray());
        AppMethodBeat.o(152294);
        return;
      }
      catch (Exception paramString1)
      {
        ab.printErrStackTrace("FragmentBundleDao", paramString1, "habbyge-mali, FragmentBundleDao writeBack", new Object[0]);
        AppMethodBeat.o(152294);
        return;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.expt.hellhound.core.v2.a.b
 * JD-Core Version:    0.7.0.1
 */