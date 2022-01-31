package com.tencent.mm.plugin.cloudvoip.cloudvoice.c;

import android.os.Looper;
import android.os.Process;
import android.util.SparseArray;
import com.tencent.mars.xlog.Xlog;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.cloudvoip.cloudvoice.b.c;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.wxmm.IConfCallBack;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;

final class k$1
  implements IConfCallBack
{
  k$1(k paramk) {}
  
  public final byte[] callBackFromConf(int paramInt1, int paramInt2, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(135481);
    ab.i("MicroMsg.OpenVoice.OpenVoiceNativeCallbackMgr", "hy: triggered native callback: %d, %d", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) });
    HashSet localHashSet = (HashSet)this.kKv.kKu.get(paramInt1);
    if ((localHashSet != null) && (localHashSet.size() > 0))
    {
      ArrayList localArrayList = new ArrayList(1);
      Object localObject = new byte[1];
      Iterator localIterator = localHashSet.iterator();
      while (localIterator.hasNext())
      {
        k.a locala = (k.a)localIterator.next();
        if (locala != null)
        {
          byte[] arrayOfByte = locala.bE(locala.j(paramInt2, locala.ay(paramArrayOfByte)));
          localObject = arrayOfByte;
          if (!locala.bhp())
          {
            localArrayList.add(locala);
            localObject = arrayOfByte;
          }
        }
        else
        {
          ab.e("MicroMsg.OpenVoice.OpenVoiceNativeCallbackMgr", "hy: item is null! weired");
        }
      }
      paramArrayOfByte = localArrayList.iterator();
      while (paramArrayOfByte.hasNext()) {
        localHashSet.remove((k.a)paramArrayOfByte.next());
      }
      AppMethodBeat.o(135481);
      return localObject;
    }
    ab.w("MicroMsg.OpenVoice.OpenVoiceNativeCallbackMgr", "hy: nobody's listening to event %d, what a pity!", new Object[] { Integer.valueOf(paramInt1) });
    paramArrayOfByte = new byte[1];
    AppMethodBeat.o(135481);
    return paramArrayOfByte;
  }
  
  public final void callbackWriteLog(int paramInt1, String paramString1, String paramString2, int paramInt2, String paramString3, String paramString4, int paramInt3)
  {
    AppMethodBeat.i(135482);
    if (paramInt1 >= c.bhk()) {
      Xlog.logWrite2(paramInt1, "CloudVoIPNative:".concat(String.valueOf(paramString1)), paramString2, paramString3, Process.myTid(), Process.myPid(), Thread.currentThread().getId(), Looper.getMainLooper().getThread().getId(), paramString4);
    }
    AppMethodBeat.o(135482);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.cloudvoip.cloudvoice.c.k.1
 * JD-Core Version:    0.7.0.1
 */