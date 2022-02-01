package com.tencent.mm.plugin.expt.hellhound.core.b.b;

import android.os.Bundle;
import android.text.TextUtils;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.expt.hellhound.core.a.b;
import com.tencent.mm.protocal.protobuf.btm;
import com.tencent.mm.protocal.protobuf.cib;
import com.tencent.mm.sdk.platformtools.ae;
import java.util.Iterator;
import java.util.LinkedList;

public final class c
{
  public static void ab(Bundle paramBundle)
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
      ae.d("HABBYGE-MALI.FragmentBundleDao", "FragmentBundleDao, putBundle: %s", new Object[] { paramBundle });
      fV("Chat_User", paramBundle);
    }
    AppMethodBeat.o(121992);
  }
  
  public static cib cpE()
  {
    AppMethodBeat.i(121994);
    byte[] arrayOfByte = b.getBytes("hell_fgm_bun_mmkv_key");
    if ((arrayOfByte == null) || (arrayOfByte.length <= 0))
    {
      AppMethodBeat.o(121994);
      return null;
    }
    cib localcib = new cib();
    try
    {
      localcib.parseFrom(arrayOfByte);
      AppMethodBeat.o(121994);
      return localcib;
    }
    catch (Exception localException)
    {
      for (;;)
      {
        ae.printErrStackTrace("HABBYGE-MALI.FragmentBundleDao", localException, "FragmentBundleDao _doRead parse", new Object[0]);
        Object localObject = null;
      }
    }
  }
  
  static void fV(String paramString1, String paramString2)
  {
    AppMethodBeat.i(121993);
    cib localcib = cpE();
    if (localcib == null) {
      localcib = new cib();
    }
    for (;;)
    {
      Object localObject = localcib.Huj.iterator();
      while (((Iterator)localObject).hasNext())
      {
        btm localbtm = (btm)((Iterator)localObject).next();
        if ((localbtm != null) && (paramString1.equals(localbtm.key))) {
          localcib.Huj.remove(localbtm);
        }
      }
      localObject = new btm();
      ((btm)localObject).key = paramString1;
      ((btm)localObject).value = paramString2;
      localcib.Huj.add(localObject);
      try
      {
        b.p("hell_fgm_bun_mmkv_key", localcib.toByteArray());
        AppMethodBeat.o(121993);
        return;
      }
      catch (Exception paramString1)
      {
        ae.printErrStackTrace("HABBYGE-MALI.FragmentBundleDao", paramString1, "FragmentBundleDao writeBack", new Object[0]);
        AppMethodBeat.o(121993);
        return;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.expt.hellhound.core.b.b.c
 * JD-Core Version:    0.7.0.1
 */