package com.tencent.mm.plugin.expt.hellhound.core.b.b;

import android.os.Bundle;
import android.text.TextUtils;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.expt.hellhound.core.a.b;
import com.tencent.mm.protocal.protobuf.dfx;
import com.tencent.mm.protocal.protobuf.eae;
import com.tencent.mm.sdk.platformtools.Log;
import java.util.Iterator;
import java.util.LinkedList;

public final class c
{
  public static void al(Bundle paramBundle)
  {
    AppMethodBeat.i(121992);
    if (paramBundle == null)
    {
      AppMethodBeat.o(121992);
      return;
    }
    paramBundle = paramBundle.getString("Chat_User");
    if (!TextUtils.isEmpty(paramBundle))
    {
      Log.d("HABBYGE-MALI.FragmentBundleDao", "FragmentBundleDao, putBundle: %s", new Object[] { paramBundle });
      hj("Chat_User", paramBundle);
    }
    AppMethodBeat.o(121992);
  }
  
  public static eae dJr()
  {
    AppMethodBeat.i(121994);
    byte[] arrayOfByte = b.ard("hell_fgm_bun_mmkv_key");
    if ((arrayOfByte == null) || (arrayOfByte.length <= 0))
    {
      AppMethodBeat.o(121994);
      return null;
    }
    eae localeae = new eae();
    try
    {
      localeae.parseFrom(arrayOfByte);
      AppMethodBeat.o(121994);
      return localeae;
    }
    catch (Exception localException)
    {
      for (;;)
      {
        Log.printErrStackTrace("HABBYGE-MALI.FragmentBundleDao", localException, "FragmentBundleDao _doRead parse", new Object[0]);
        Object localObject = null;
      }
    }
  }
  
  static void hj(String paramString1, String paramString2)
  {
    AppMethodBeat.i(121993);
    eae localeae = dJr();
    if (localeae == null) {
      localeae = new eae();
    }
    for (;;)
    {
      Object localObject = localeae.abfm.iterator();
      while (((Iterator)localObject).hasNext())
      {
        dfx localdfx = (dfx)((Iterator)localObject).next();
        if ((localdfx != null) && (paramString1.equals(localdfx.key))) {
          localeae.abfm.remove(localdfx);
        }
      }
      localObject = new dfx();
      ((dfx)localObject).key = paramString1;
      ((dfx)localObject).value = paramString2;
      localeae.abfm.add(localObject);
      try
      {
        b.u("hell_fgm_bun_mmkv_key", localeae.toByteArray());
        AppMethodBeat.o(121993);
        return;
      }
      catch (Exception paramString1)
      {
        Log.printErrStackTrace("HABBYGE-MALI.FragmentBundleDao", paramString1, "FragmentBundleDao writeBack", new Object[0]);
        AppMethodBeat.o(121993);
        return;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.expt.hellhound.core.b.b.c
 * JD-Core Version:    0.7.0.1
 */