package com.google.android.gms.internal.measurement;

import com.tencent.matrix.trace.core.AppMethodBeat;

final class zzabg
{
  static String zza(zzyw paramzzyw)
  {
    AppMethodBeat.i(40200);
    paramzzyw = new zzabh(paramzzyw);
    StringBuilder localStringBuilder = new StringBuilder(paramzzyw.size());
    int i = 0;
    if (i < paramzzyw.size())
    {
      int j = paramzzyw.zzae(i);
      switch (j)
      {
      default: 
        if ((j >= 32) && (j <= 126)) {
          localStringBuilder.append((char)j);
        }
        break;
      }
      for (;;)
      {
        i += 1;
        break;
        localStringBuilder.append("\\a");
        continue;
        localStringBuilder.append("\\b");
        continue;
        localStringBuilder.append("\\f");
        continue;
        localStringBuilder.append("\\n");
        continue;
        localStringBuilder.append("\\r");
        continue;
        localStringBuilder.append("\\t");
        continue;
        localStringBuilder.append("\\v");
        continue;
        localStringBuilder.append("\\\\");
        continue;
        localStringBuilder.append("\\'");
        continue;
        localStringBuilder.append("\\\"");
        continue;
        localStringBuilder.append('\\');
        localStringBuilder.append((char)((j >>> 6 & 0x3) + 48));
        localStringBuilder.append((char)((j >>> 3 & 0x7) + 48));
        localStringBuilder.append((char)((j & 0x7) + 48));
      }
    }
    paramzzyw = localStringBuilder.toString();
    AppMethodBeat.o(40200);
    return paramzzyw;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.google.android.gms.internal.measurement.zzabg
 * JD-Core Version:    0.7.0.1
 */