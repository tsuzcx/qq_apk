package com.tencent.mm.plugin.appbrand.ipc;

import android.os.Parcelable.Creator;
import com.tencent.mm.sdk.platformtools.y;

public class SampleTask2
  extends MainProcessTask
{
  public static final Parcelable.Creator<SampleTask2> CREATOR = new SampleTask2.1();
  
  public final void Zu()
  {
    y.e("SampleTask2", "Run in Main Process");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.ipc.SampleTask2
 * JD-Core Version:    0.7.0.1
 */