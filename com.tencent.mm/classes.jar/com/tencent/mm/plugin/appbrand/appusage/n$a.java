package com.tencent.mm.plugin.appbrand.appusage;

import android.os.Bundle;
import android.os.Parcel;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ipcinvoker.m;
import com.tencent.mm.kernel.h;

final class n$a
  implements m<Bundle, Parcel>
{
  private static Parcel V(Bundle paramBundle)
  {
    AppMethodBeat.i(44513);
    int i = paramBundle.getInt("count");
    int j = paramBundle.getInt("versionType", 2147483647);
    long l = paramBundle.getLong("maxUpdateTime", 9223372036854775807L);
    paramBundle = Parcel.obtain();
    if (l != 9223372036854775807L) {}
    for (;;)
    {
      try
      {
        paramBundle.writeTypedList(((ag)h.ax(ag.class)).r(l, i));
        AppMethodBeat.o(44513);
        return paramBundle;
      }
      catch (Exception localException)
      {
        paramBundle.setDataPosition(0);
        paramBundle.writeTypedList(null);
        AppMethodBeat.o(44513);
      }
      paramBundle.writeTypedList(((ag)h.ax(ag.class)).fg(i, j));
    }
    return paramBundle;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.appusage.n.a
 * JD-Core Version:    0.7.0.1
 */