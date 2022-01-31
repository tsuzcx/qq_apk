package com.facebook.appevents;

import com.facebook.internal.FetchedAppSettingsManager;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

final class AppEventsLogger$5
  implements Runnable
{
  public final void run()
  {
    AppMethodBeat.i(71910);
    Object localObject = new HashSet();
    Iterator localIterator = AppEventQueue.getKeySet().iterator();
    while (localIterator.hasNext()) {
      ((Set)localObject).add(((AccessTokenAppIdPair)localIterator.next()).getApplicationId());
    }
    localObject = ((Set)localObject).iterator();
    while (((Iterator)localObject).hasNext()) {
      FetchedAppSettingsManager.queryAppSettings((String)((Iterator)localObject).next(), true);
    }
    AppMethodBeat.o(71910);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.facebook.appevents.AppEventsLogger.5
 * JD-Core Version:    0.7.0.1
 */