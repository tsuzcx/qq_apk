package com.tencent.mm.plugin.expt.hellhound.core.b.b;

import android.os.Bundle;
import android.text.TextUtils;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.expt.hellhound.core.a.b;
import com.tencent.mm.protocal.protobuf.cgh;
import com.tencent.mm.protocal.protobuf.cyi;
import com.tencent.mm.sdk.platformtools.Log;
import java.util.Iterator;
import java.util.LinkedList;

public final class c
{
  public static void ah(Bundle paramBundle)
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
      go("Chat_User", paramBundle);
    }
    AppMethodBeat.o(121992);
  }
  
  public static cyi cNX()
  {
    AppMethodBeat.i(121994);
    byte[] arrayOfByte = b.getBytes("hell_fgm_bun_mmkv_key");
    if ((arrayOfByte == null) || (arrayOfByte.length <= 0))
    {
      AppMethodBeat.o(121994);
      return null;
    }
    cyi localcyi = new cyi();
    try
    {
      localcyi.parseFrom(arrayOfByte);
      AppMethodBeat.o(121994);
      return localcyi;
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
  
  static void go(String paramString1, String paramString2)
  {
    AppMethodBeat.i(121993);
    cyi localcyi = cNX();
    if (localcyi == null) {
      localcyi = new cyi();
    }
    for (;;)
    {
      Object localObject = localcyi.MDh.iterator();
      while (((Iterator)localObject).hasNext())
      {
        cgh localcgh = (cgh)((Iterator)localObject).next();
        if ((localcgh != null) && (paramString1.equals(localcgh.key))) {
          localcyi.MDh.remove(localcgh);
        }
      }
      localObject = new cgh();
      ((cgh)localObject).key = paramString1;
      ((cgh)localObject).value = paramString2;
      localcyi.MDh.add(localObject);
      try
      {
        b.o("hell_fgm_bun_mmkv_key", localcyi.toByteArray());
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.expt.hellhound.core.b.b.c
 * JD-Core Version:    0.7.0.1
 */