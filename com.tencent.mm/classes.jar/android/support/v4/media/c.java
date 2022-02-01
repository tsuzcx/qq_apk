package android.support.v4.media;

import android.os.Bundle;

public final class c
{
  public static boolean a(Bundle paramBundle1, Bundle paramBundle2)
  {
    if (paramBundle1 == paramBundle2) {}
    do
    {
      do
      {
        do
        {
          return true;
          if (paramBundle1 != null) {
            break;
          }
        } while ((paramBundle2.getInt("android.media.browse.extra.PAGE", -1) == -1) && (paramBundle2.getInt("android.media.browse.extra.PAGE_SIZE", -1) == -1));
        return false;
        if (paramBundle2 != null) {
          break;
        }
      } while ((paramBundle1.getInt("android.media.browse.extra.PAGE", -1) == -1) && (paramBundle1.getInt("android.media.browse.extra.PAGE_SIZE", -1) == -1));
      return false;
    } while ((paramBundle1.getInt("android.media.browse.extra.PAGE", -1) == paramBundle2.getInt("android.media.browse.extra.PAGE", -1)) && (paramBundle1.getInt("android.media.browse.extra.PAGE_SIZE", -1) == paramBundle2.getInt("android.media.browse.extra.PAGE_SIZE", -1)));
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     android.support.v4.media.c
 * JD-Core Version:    0.7.0.1
 */