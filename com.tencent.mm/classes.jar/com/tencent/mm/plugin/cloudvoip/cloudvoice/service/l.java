package com.tencent.mm.plugin.cloudvoip.cloudvoice.service;

import android.os.Looper;
import android.os.Process;
import android.util.SparseArray;
import com.tencent.mars.xlog.Xlog;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.cloudvoip.cloudvoice.c.c;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.wxmm.IConfCallBack;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;

final class l
{
  final SparseArray<HashSet<a>> wUA;
  private IConfCallBack wUz;
  
  l()
  {
    AppMethodBeat.i(90820);
    this.wUz = null;
    this.wUA = new SparseArray(5);
    AppMethodBeat.o(90820);
  }
  
  final <ConvertedDataType, OutParamType> void a(int paramInt, a<ConvertedDataType, OutParamType> parama)
  {
    int i = 1;
    AppMethodBeat.i(90822);
    Log.i("MicroMsg.OpenVoice.OpenVoiceNativeCallbackMgr", "hy: registering event id: %d", new Object[] { Integer.valueOf(paramInt) });
    for (;;)
    {
      try
      {
        HashSet localHashSet = (HashSet)this.wUA.get(paramInt);
        if (localHashSet == null)
        {
          localHashSet = new HashSet(1);
          localHashSet.add(parama);
          if (i != 0) {
            this.wUA.append(paramInt, localHashSet);
          }
          return;
        }
      }
      finally
      {
        AppMethodBeat.o(90822);
      }
      i = 0;
    }
  }
  
  final <ConvertedDataType, OutParamType> void b(int paramInt, a<ConvertedDataType, OutParamType> parama)
  {
    AppMethodBeat.i(90823);
    try
    {
      HashSet localHashSet = (HashSet)this.wUA.get(paramInt);
      if (localHashSet != null) {
        localHashSet.remove(parama);
      }
      return;
    }
    finally
    {
      AppMethodBeat.o(90823);
    }
  }
  
  final IConfCallBack nr(boolean paramBoolean)
  {
    AppMethodBeat.i(90821);
    Log.i("MicroMsg.OpenVoice.OpenVoiceNativeCallbackMgr", "hy: trigger validate callback %b", new Object[] { Boolean.valueOf(paramBoolean) });
    if (paramBoolean) {}
    for (;;)
    {
      try
      {
        this.wUz = new IConfCallBack()
        {
          public final byte[] callBackFromConf(int paramAnonymousInt1, int paramAnonymousInt2, byte[] paramAnonymousArrayOfByte)
          {
            AppMethodBeat.i(90818);
            Log.i("MicroMsg.OpenVoice.OpenVoiceNativeCallbackMgr", "hy: triggered native callback: %d, %d", new Object[] { Integer.valueOf(paramAnonymousInt1), Integer.valueOf(paramAnonymousInt2) });
            HashSet localHashSet = (HashSet)l.this.wUA.get(paramAnonymousInt1);
            if ((localHashSet != null) && (localHashSet.size() > 0))
            {
              ArrayList localArrayList = new ArrayList(1);
              Object localObject1 = new byte[1];
              Iterator localIterator = localHashSet.iterator();
              while (localIterator.hasNext())
              {
                l.a locala = (l.a)localIterator.next();
                if (locala != null)
                {
                  Object localObject3 = locala.H(paramAnonymousInt2, locala.bu(paramAnonymousArrayOfByte));
                  Object localObject2 = localObject1;
                  if (localObject3 != null) {
                    localObject2 = locala.ev(localObject3);
                  }
                  localObject1 = localObject2;
                  if (!locala.drh())
                  {
                    localArrayList.add(locala);
                    localObject1 = localObject2;
                  }
                }
                else
                {
                  Log.e("MicroMsg.OpenVoice.OpenVoiceNativeCallbackMgr", "hy: item is null! weired");
                }
              }
              paramAnonymousArrayOfByte = localArrayList.iterator();
              while (paramAnonymousArrayOfByte.hasNext()) {
                localHashSet.remove((l.a)paramAnonymousArrayOfByte.next());
              }
              AppMethodBeat.o(90818);
              return localObject1;
            }
            Log.w("MicroMsg.OpenVoice.OpenVoiceNativeCallbackMgr", "hy: nobody's listening to event %d, what a pity!", new Object[] { Integer.valueOf(paramAnonymousInt1) });
            paramAnonymousArrayOfByte = new byte[1];
            AppMethodBeat.o(90818);
            return paramAnonymousArrayOfByte;
          }
          
          public final void callbackWriteLog(int paramAnonymousInt1, String paramAnonymousString1, String paramAnonymousString2, int paramAnonymousInt2, String paramAnonymousString3, String paramAnonymousString4, int paramAnonymousInt3)
          {
            AppMethodBeat.i(90819);
            if (paramAnonymousInt1 >= c.dqY()) {
              Xlog.logWrite2(paramAnonymousInt1, "CloudVoIPNative:".concat(String.valueOf(paramAnonymousString1)), paramAnonymousString2, paramAnonymousString3, Process.myTid(), Process.myPid(), Thread.currentThread().getId(), Looper.getMainLooper().getThread().getId(), paramAnonymousString4);
            }
            AppMethodBeat.o(90819);
          }
        };
        this.wUA.clear();
        IConfCallBack localIConfCallBack = this.wUz;
        return localIConfCallBack;
      }
      finally
      {
        AppMethodBeat.o(90821);
      }
      this.wUz = null;
    }
  }
  
  static abstract interface a<InParamType, OutParamType>
  {
    public abstract OutParamType H(int paramInt, InParamType paramInParamType);
    
    public abstract InParamType bu(byte[] paramArrayOfByte);
    
    public abstract boolean drh();
    
    public abstract byte[] ev(OutParamType paramOutParamType);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.cloudvoip.cloudvoice.service.l
 * JD-Core Version:    0.7.0.1
 */