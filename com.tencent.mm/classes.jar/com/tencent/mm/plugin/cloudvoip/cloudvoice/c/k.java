package com.tencent.mm.plugin.cloudvoip.cloudvoice.c;

import android.util.SparseArray;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.wxmm.IConfCallBack;
import java.util.HashSet;

final class k
{
  private IConfCallBack kKt;
  final SparseArray<HashSet<k.a>> kKu;
  
  k()
  {
    AppMethodBeat.i(135483);
    this.kKt = null;
    this.kKu = new SparseArray(5);
    AppMethodBeat.o(135483);
  }
  
  final <ConvertedDataType, OutParamType> void a(int paramInt, k.a<ConvertedDataType, OutParamType> parama)
  {
    int i = 1;
    AppMethodBeat.i(135485);
    ab.i("MicroMsg.OpenVoice.OpenVoiceNativeCallbackMgr", "hy: registering event id: %d", new Object[] { Integer.valueOf(paramInt) });
    for (;;)
    {
      try
      {
        HashSet localHashSet = (HashSet)this.kKu.get(paramInt);
        if (localHashSet == null)
        {
          localHashSet = new HashSet(1);
          localHashSet.add(parama);
          if (i != 0) {
            this.kKu.append(paramInt, localHashSet);
          }
          return;
        }
      }
      finally
      {
        AppMethodBeat.o(135485);
      }
      i = 0;
    }
  }
  
  final <ConvertedDataType, OutParamType> void b(int paramInt, k.a<ConvertedDataType, OutParamType> parama)
  {
    AppMethodBeat.i(135486);
    try
    {
      HashSet localHashSet = (HashSet)this.kKu.get(paramInt);
      if (localHashSet != null) {
        localHashSet.remove(parama);
      }
      return;
    }
    finally
    {
      AppMethodBeat.o(135486);
    }
  }
  
  final IConfCallBack gk(boolean paramBoolean)
  {
    AppMethodBeat.i(135484);
    ab.i("MicroMsg.OpenVoice.OpenVoiceNativeCallbackMgr", "hy: trigger validate callback %b", new Object[] { Boolean.valueOf(paramBoolean) });
    if (paramBoolean) {}
    for (;;)
    {
      try
      {
        this.kKt = new k.1(this);
        this.kKu.clear();
        IConfCallBack localIConfCallBack = this.kKt;
        return localIConfCallBack;
      }
      finally
      {
        AppMethodBeat.o(135484);
      }
      this.kKt = null;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.cloudvoip.cloudvoice.c.k
 * JD-Core Version:    0.7.0.1
 */