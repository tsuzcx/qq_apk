package com.google.android.gms.internal.measurement;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Map.Entry;

final class zzaaz
  extends zzaay<FieldDescriptorType, Object>
{
  zzaaz(int paramInt)
  {
    super(paramInt, null);
  }
  
  public final void zzrg()
  {
    AppMethodBeat.i(3388);
    if (!isImmutable())
    {
      int i = 0;
      while (i < zzuj())
      {
        localObject = zzah(i);
        if (((zzzo)((Map.Entry)localObject).getKey()).zztk()) {
          ((Map.Entry)localObject).setValue(Collections.unmodifiableList((List)((Map.Entry)localObject).getValue()));
        }
        i += 1;
      }
      Object localObject = zzuk().iterator();
      while (((Iterator)localObject).hasNext())
      {
        Map.Entry localEntry = (Map.Entry)((Iterator)localObject).next();
        if (((zzzo)localEntry.getKey()).zztk()) {
          localEntry.setValue(Collections.unmodifiableList((List)localEntry.getValue()));
        }
      }
    }
    super.zzrg();
    AppMethodBeat.o(3388);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.google.android.gms.internal.measurement.zzaaz
 * JD-Core Version:    0.7.0.1
 */