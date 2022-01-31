package com.tencent.mm.plugin.appbrand.report.quality;

import android.app.ActivityManager;
import android.content.Context;
import android.os.Debug.MemoryInfo;
import android.os.Process;
import com.tencent.mm.sdk.platformtools.ae;

public enum f
{
  private f() {}
  
  static Debug.MemoryInfo aoy()
  {
    Object localObject = (ActivityManager)ae.getContext().getSystemService("activity");
    if (localObject == null) {
      return null;
    }
    localObject = ((ActivityManager)localObject).getProcessMemoryInfo(new int[] { Process.myPid() });
    if ((localObject != null) && (localObject.length > 0)) {
      return localObject[0];
    }
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.report.quality.f
 * JD-Core Version:    0.7.0.1
 */