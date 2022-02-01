package com.tencent.mm.plugin.expt.hellhound.core.b.b;

import android.os.Bundle;
import android.text.TextUtils;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.expt.hellhound.core.a.b;
import com.tencent.mm.protocal.protobuf.cpd;
import com.tencent.mm.protocal.protobuf.dhu;
import com.tencent.mm.sdk.platformtools.Log;
import java.util.Iterator;
import java.util.LinkedList;

public final class c
{
  public static void aa(Bundle paramBundle)
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
      gC("Chat_User", paramBundle);
    }
    AppMethodBeat.o(121992);
  }
  
  public static dhu dcP()
  {
    AppMethodBeat.i(121994);
    byte[] arrayOfByte = b.awZ("hell_fgm_bun_mmkv_key");
    if ((arrayOfByte == null) || (arrayOfByte.length <= 0))
    {
      AppMethodBeat.o(121994);
      return null;
    }
    dhu localdhu = new dhu();
    try
    {
      localdhu.parseFrom(arrayOfByte);
      AppMethodBeat.o(121994);
      return localdhu;
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
  
  static void gC(String paramString1, String paramString2)
  {
    AppMethodBeat.i(121993);
    dhu localdhu = dcP();
    if (localdhu == null) {
      localdhu = new dhu();
    }
    for (;;)
    {
      Object localObject = localdhu.TOQ.iterator();
      while (((Iterator)localObject).hasNext())
      {
        cpd localcpd = (cpd)((Iterator)localObject).next();
        if ((localcpd != null) && (paramString1.equals(localcpd.key))) {
          localdhu.TOQ.remove(localcpd);
        }
      }
      localObject = new cpd();
      ((cpd)localObject).key = paramString1;
      ((cpd)localObject).value = paramString2;
      localdhu.TOQ.add(localObject);
      try
      {
        b.r("hell_fgm_bun_mmkv_key", localdhu.toByteArray());
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.expt.hellhound.core.b.b.c
 * JD-Core Version:    0.7.0.1
 */