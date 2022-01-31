package com.tencent.mm.plugin.cloudvoip.cloudvoice.c;

import android.os.Looper;
import android.os.Process;
import android.util.SparseArray;
import com.tencent.mars.xlog.Xlog;
import com.tencent.mm.plugin.cloudvoip.cloudvoice.b.b;
import com.tencent.mm.sdk.platformtools.y;
import com.tencent.wxmm.IConfCallBack;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;

final class f$1
  implements IConfCallBack
{
  f$1(f paramf) {}
  
  public final byte[] callBackFromConf(int paramInt1, int paramInt2, byte[] paramArrayOfByte)
  {
    y.i("MicroMsg.OpenVoice.OpenVoiceNativeCallbackMgr", "hy: triggered native callback: %d, %d", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) });
    HashSet localHashSet = (HashSet)this.iEW.iEV.get(paramInt1);
    if ((localHashSet != null) && (localHashSet.size() > 0))
    {
      ArrayList localArrayList = new ArrayList(1);
      Object localObject1 = new byte[1];
      Iterator localIterator = localHashSet.iterator();
      while (localIterator.hasNext())
      {
        f.a locala = (f.a)localIterator.next();
        if (locala != null)
        {
          Object localObject3 = locala.h(paramInt2, locala.ag(paramArrayOfByte));
          localObject2 = localObject1;
          if (localObject3 != null) {
            localObject2 = locala.bh(localObject3);
          }
          localObject1 = localObject2;
          if (!locala.aEl())
          {
            localArrayList.add(locala);
            localObject1 = localObject2;
          }
        }
        else
        {
          y.e("MicroMsg.OpenVoice.OpenVoiceNativeCallbackMgr", "hy: item is null! weired");
        }
      }
      Object localObject2 = localArrayList.iterator();
      for (;;)
      {
        paramArrayOfByte = (byte[])localObject1;
        if (!((Iterator)localObject2).hasNext()) {
          break;
        }
        localHashSet.remove((f.a)((Iterator)localObject2).next());
      }
    }
    y.w("MicroMsg.OpenVoice.OpenVoiceNativeCallbackMgr", "hy: nobody's listening to event %d, what a pity!", new Object[] { Integer.valueOf(paramInt1) });
    paramArrayOfByte = new byte[1];
    return paramArrayOfByte;
  }
  
  public final void callbackWriteLog(int paramInt1, String paramString1, String paramString2, int paramInt2, String paramString3, String paramString4, int paramInt3)
  {
    if (paramInt1 >= b.aEk()) {
      Xlog.logWrite2(paramInt1, "CloudVoIPNative:" + paramString1, paramString2, paramString3, Process.myTid(), Process.myPid(), Thread.currentThread().getId(), Looper.getMainLooper().getThread().getId(), paramString4);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.cloudvoip.cloudvoice.c.f.1
 * JD-Core Version:    0.7.0.1
 */