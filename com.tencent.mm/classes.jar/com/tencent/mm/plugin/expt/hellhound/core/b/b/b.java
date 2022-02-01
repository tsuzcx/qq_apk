package com.tencent.mm.plugin.expt.hellhound.core.b.b;

import android.os.Bundle;
import android.text.TextUtils;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.protocal.protobuf.bof;
import com.tencent.mm.protocal.protobuf.ccp;
import com.tencent.mm.sdk.platformtools.ac;
import java.util.Iterator;
import java.util.LinkedList;

public final class b
{
  public static void Y(Bundle paramBundle)
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
      ac.d("HABBYGE-MALI.FragmentBundleDao", "FragmentBundleDao, putBundle: %s", new Object[] { paramBundle });
      fH("Chat_User", paramBundle);
    }
    AppMethodBeat.o(121992);
  }
  
  public static ccp cjc()
  {
    AppMethodBeat.i(121994);
    byte[] arrayOfByte = com.tencent.mm.plugin.expt.hellhound.core.a.b.getBytes("hell_fgm_bun_mmkv_key");
    if ((arrayOfByte == null) || (arrayOfByte.length <= 0))
    {
      AppMethodBeat.o(121994);
      return null;
    }
    ccp localccp = new ccp();
    try
    {
      localccp.parseFrom(arrayOfByte);
      AppMethodBeat.o(121994);
      return localccp;
    }
    catch (Exception localException)
    {
      for (;;)
      {
        ac.printErrStackTrace("HABBYGE-MALI.FragmentBundleDao", localException, "FragmentBundleDao _doRead parse", new Object[0]);
        Object localObject = null;
      }
    }
  }
  
  static void fH(String paramString1, String paramString2)
  {
    AppMethodBeat.i(121993);
    ccp localccp = cjc();
    if (localccp == null) {
      localccp = new ccp();
    }
    for (;;)
    {
      Object localObject = localccp.Fra.iterator();
      while (((Iterator)localObject).hasNext())
      {
        bof localbof = (bof)((Iterator)localObject).next();
        if ((localbof != null) && (paramString1.equals(localbof.key))) {
          localccp.Fra.remove(localbof);
        }
      }
      localObject = new bof();
      ((bof)localObject).key = paramString1;
      ((bof)localObject).value = paramString2;
      localccp.Fra.add(localObject);
      try
      {
        com.tencent.mm.plugin.expt.hellhound.core.a.b.o("hell_fgm_bun_mmkv_key", localccp.toByteArray());
        AppMethodBeat.o(121993);
        return;
      }
      catch (Exception paramString1)
      {
        ac.printErrStackTrace("HABBYGE-MALI.FragmentBundleDao", paramString1, "FragmentBundleDao writeBack", new Object[0]);
        AppMethodBeat.o(121993);
        return;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.expt.hellhound.core.b.b.b
 * JD-Core Version:    0.7.0.1
 */