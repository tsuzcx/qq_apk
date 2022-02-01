package com.tencent.mm.plugin.expt.hellhound.core.b.b;

import android.os.Bundle;
import android.text.TextUtils;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.expt.hellhound.core.a.b;
import com.tencent.mm.protocal.protobuf.bss;
import com.tencent.mm.protocal.protobuf.chh;
import com.tencent.mm.sdk.platformtools.ad;
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
      ad.d("HABBYGE-MALI.FragmentBundleDao", "FragmentBundleDao, putBundle: %s", new Object[] { paramBundle });
      fQ("Chat_User", paramBundle);
    }
    AppMethodBeat.o(121992);
  }
  
  public static chh coc()
  {
    AppMethodBeat.i(121994);
    byte[] arrayOfByte = b.getBytes("hell_fgm_bun_mmkv_key");
    if ((arrayOfByte == null) || (arrayOfByte.length <= 0))
    {
      AppMethodBeat.o(121994);
      return null;
    }
    chh localchh = new chh();
    try
    {
      localchh.parseFrom(arrayOfByte);
      AppMethodBeat.o(121994);
      return localchh;
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
  
  static void fQ(String paramString1, String paramString2)
  {
    AppMethodBeat.i(121993);
    chh localchh = coc();
    if (localchh == null) {
      localchh = new chh();
    }
    for (;;)
    {
      Object localObject = localchh.HaJ.iterator();
      while (((Iterator)localObject).hasNext())
      {
        bss localbss = (bss)((Iterator)localObject).next();
        if ((localbss != null) && (paramString1.equals(localbss.key))) {
          localchh.HaJ.remove(localbss);
        }
      }
      localObject = new bss();
      ((bss)localObject).key = paramString1;
      ((bss)localObject).value = paramString2;
      localchh.HaJ.add(localObject);
      try
      {
        b.p("hell_fgm_bun_mmkv_key", localchh.toByteArray());
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.expt.hellhound.core.b.b.c
 * JD-Core Version:    0.7.0.1
 */