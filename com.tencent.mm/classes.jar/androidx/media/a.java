package androidx.media;

import android.os.Bundle;
import com.tencent.matrix.trace.core.AppMethodBeat;

public final class a
{
  public static boolean b(Bundle paramBundle1, Bundle paramBundle2)
  {
    AppMethodBeat.i(193005);
    if (paramBundle1 == paramBundle2)
    {
      AppMethodBeat.o(193005);
      return true;
    }
    if (paramBundle1 == null)
    {
      if ((paramBundle2.getInt("android.media.browse.extra.PAGE", -1) == -1) && (paramBundle2.getInt("android.media.browse.extra.PAGE_SIZE", -1) == -1))
      {
        AppMethodBeat.o(193005);
        return true;
      }
      AppMethodBeat.o(193005);
      return false;
    }
    if (paramBundle2 == null)
    {
      if ((paramBundle1.getInt("android.media.browse.extra.PAGE", -1) == -1) && (paramBundle1.getInt("android.media.browse.extra.PAGE_SIZE", -1) == -1))
      {
        AppMethodBeat.o(193005);
        return true;
      }
      AppMethodBeat.o(193005);
      return false;
    }
    if ((paramBundle1.getInt("android.media.browse.extra.PAGE", -1) == paramBundle2.getInt("android.media.browse.extra.PAGE", -1)) && (paramBundle1.getInt("android.media.browse.extra.PAGE_SIZE", -1) == paramBundle2.getInt("android.media.browse.extra.PAGE_SIZE", -1)))
    {
      AppMethodBeat.o(193005);
      return true;
    }
    AppMethodBeat.o(193005);
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     androidx.media.a
 * JD-Core Version:    0.7.0.1
 */