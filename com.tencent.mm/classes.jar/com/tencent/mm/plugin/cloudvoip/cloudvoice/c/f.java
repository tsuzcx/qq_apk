package com.tencent.mm.plugin.cloudvoip.cloudvoice.c;

import android.util.SparseArray;
import com.tencent.mm.sdk.platformtools.y;
import com.tencent.wxmm.IConfCallBack;
import java.util.HashSet;

final class f
{
  private IConfCallBack iEU = null;
  final SparseArray<HashSet<f.a>> iEV = new SparseArray(5);
  
  final <ConvertedDataType, OutParamType> void a(int paramInt, f.a<ConvertedDataType, OutParamType> parama)
  {
    int i = 1;
    y.i("MicroMsg.OpenVoice.OpenVoiceNativeCallbackMgr", "hy: registering event id: %d", new Object[] { Integer.valueOf(paramInt) });
    for (;;)
    {
      try
      {
        HashSet localHashSet = (HashSet)this.iEV.get(paramInt);
        if (localHashSet == null)
        {
          localHashSet = new HashSet(1);
          localHashSet.add(parama);
          if (i != 0) {
            this.iEV.append(paramInt, localHashSet);
          }
          return;
        }
      }
      finally {}
      i = 0;
    }
  }
  
  final <ConvertedDataType, OutParamType> void b(int paramInt, f.a<ConvertedDataType, OutParamType> parama)
  {
    try
    {
      HashSet localHashSet = (HashSet)this.iEV.get(paramInt);
      if (localHashSet != null) {
        localHashSet.remove(parama);
      }
      return;
    }
    finally {}
  }
  
  final IConfCallBack eI(boolean paramBoolean)
  {
    y.i("MicroMsg.OpenVoice.OpenVoiceNativeCallbackMgr", "hy: trigger validate callback %b", new Object[] { Boolean.valueOf(paramBoolean) });
    if (paramBoolean) {}
    for (;;)
    {
      try
      {
        this.iEU = new f.1(this);
        this.iEV.clear();
        IConfCallBack localIConfCallBack = this.iEU;
        return localIConfCallBack;
      }
      finally {}
      this.iEU = null;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.cloudvoip.cloudvoice.c.f
 * JD-Core Version:    0.7.0.1
 */