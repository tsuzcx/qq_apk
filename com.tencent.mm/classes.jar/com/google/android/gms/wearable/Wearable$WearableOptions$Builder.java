package com.google.android.gms.wearable;

import android.os.Looper;
import com.tencent.matrix.trace.core.AppMethodBeat;

public class Wearable$WearableOptions$Builder
{
  private Looper zzac;
  
  public Wearable.WearableOptions build()
  {
    AppMethodBeat.i(70889);
    Wearable.WearableOptions localWearableOptions = new Wearable.WearableOptions(this, null);
    AppMethodBeat.o(70889);
    return localWearableOptions;
  }
  
  public Builder setLooper(Looper paramLooper)
  {
    this.zzac = paramLooper;
    return this;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.google.android.gms.wearable.Wearable.WearableOptions.Builder
 * JD-Core Version:    0.7.0.1
 */