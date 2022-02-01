package com.tencent.maas.analytics;

import android.util.ArraySet;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.Iterator;
import java.util.Set;

public class MJAnalyticsEventBridge
{
  private final Set<MJAnalyticsEventSink> _eventSinks;
  
  public MJAnalyticsEventBridge()
  {
    AppMethodBeat.i(216963);
    this._eventSinks = new ArraySet();
    AppMethodBeat.o(216963);
  }
  
  public void addEventSink(MJAnalyticsEventSink paramMJAnalyticsEventSink)
  {
    AppMethodBeat.i(216968);
    this._eventSinks.add(paramMJAnalyticsEventSink);
    AppMethodBeat.o(216968);
  }
  
  public boolean hasAnyEventSink()
  {
    AppMethodBeat.i(216977);
    if (!this._eventSinks.isEmpty())
    {
      AppMethodBeat.o(216977);
      return true;
    }
    AppMethodBeat.o(216977);
    return false;
  }
  
  public void removeEventSink(MJAnalyticsEventSink paramMJAnalyticsEventSink)
  {
    AppMethodBeat.i(216971);
    this._eventSinks.remove(paramMJAnalyticsEventSink);
    AppMethodBeat.o(216971);
  }
  
  public void sinkEvent(MJAnalyticsEvent paramMJAnalyticsEvent)
  {
    AppMethodBeat.i(216983);
    if (paramMJAnalyticsEvent == null)
    {
      AppMethodBeat.o(216983);
      return;
    }
    Iterator localIterator = this._eventSinks.iterator();
    while (localIterator.hasNext()) {
      ((MJAnalyticsEventSink)localIterator.next()).sinkEvent(paramMJAnalyticsEvent);
    }
    AppMethodBeat.o(216983);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.maas.analytics.MJAnalyticsEventBridge
 * JD-Core Version:    0.7.0.1
 */