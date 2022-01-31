package com.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk.scan;

import android.annotation.TargetApi;
import android.bluetooth.le.ScanCallback;
import android.bluetooth.le.ScanResult;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

@TargetApi(21)
final class b$d
  extends ScanCallback
{
  private final WeakReference<e> gns;
  
  b$d(e parame)
  {
    this.gns = new WeakReference(parame);
  }
  
  public final void onBatchScanResults(List<ScanResult> paramList)
  {
    if ((e)this.gns.get() == null) {}
    for (;;)
    {
      return;
      ArrayList localArrayList = new ArrayList(paramList.size());
      paramList = paramList.iterator();
      while (paramList.hasNext()) {
        localArrayList.add(new ScanResultCompat((ScanResult)paramList.next()));
      }
    }
  }
  
  public final void onScanFailed(int paramInt)
  {
    e locale = (e)this.gns.get();
    if (locale != null) {
      locale.onScanFailed(paramInt);
    }
  }
  
  public final void onScanResult(int paramInt, ScanResult paramScanResult)
  {
    e locale = (e)this.gns.get();
    if (locale != null) {
      locale.a(paramInt, new ScanResultCompat(paramScanResult));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk.scan.b.d
 * JD-Core Version:    0.7.0.1
 */