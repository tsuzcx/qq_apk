package com.tencent.mm.plugin.expt.hellhound.core.b.b;

import android.os.Bundle;
import android.text.TextUtils;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.protocal.protobuf.bkl;
import com.tencent.mm.protocal.protobuf.bxu;
import com.tencent.mm.sdk.platformtools.ad;
import java.util.Iterator;
import java.util.LinkedList;

public final class b
{
  public static void X(Bundle paramBundle)
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
      ad.d("HABBYGE-MALI.FragmentBundleDao", "FragmentBundleDao, putBundle: %s", new Object[] { paramBundle });
      fu("Chat_User", paramBundle);
    }
    AppMethodBeat.o(121992);
  }
  
  public static bxu cbR()
  {
    AppMethodBeat.i(121994);
    byte[] arrayOfByte = com.tencent.mm.plugin.expt.hellhound.core.a.b.getBytes("hell_fgm_bun_mmkv_key");
    if ((arrayOfByte == null) || (arrayOfByte.length <= 0))
    {
      AppMethodBeat.o(121994);
      return null;
    }
    bxu localbxu = new bxu();
    try
    {
      localbxu.parseFrom(arrayOfByte);
      AppMethodBeat.o(121994);
      return localbxu;
    }
    catch (Exception localException)
    {
      for (;;)
      {
        ad.printErrStackTrace("HABBYGE-MALI.FragmentBundleDao", localException, "FragmentBundleDao _doRead parse", new Object[0]);
        Object localObject = null;
      }
    }
  }
  
  static void fu(String paramString1, String paramString2)
  {
    AppMethodBeat.i(121993);
    bxu localbxu = cbR();
    if (localbxu == null) {
      localbxu = new bxu();
    }
    for (;;)
    {
      Object localObject = localbxu.DUn.iterator();
      while (((Iterator)localObject).hasNext())
      {
        bkl localbkl = (bkl)((Iterator)localObject).next();
        if ((localbkl != null) && (paramString1.equals(localbkl.key))) {
          localbxu.DUn.remove(localbkl);
        }
      }
      localObject = new bkl();
      ((bkl)localObject).key = paramString1;
      ((bkl)localObject).value = paramString2;
      localbxu.DUn.add(localObject);
      try
      {
        com.tencent.mm.plugin.expt.hellhound.core.a.b.o("hell_fgm_bun_mmkv_key", localbxu.toByteArray());
        AppMethodBeat.o(121993);
        return;
      }
      catch (Exception paramString1)
      {
        ad.printErrStackTrace("HABBYGE-MALI.FragmentBundleDao", paramString1, "FragmentBundleDao writeBack", new Object[0]);
        AppMethodBeat.o(121993);
        return;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.expt.hellhound.core.b.b.b
 * JD-Core Version:    0.7.0.1
 */