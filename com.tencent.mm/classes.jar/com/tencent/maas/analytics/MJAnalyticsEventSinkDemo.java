package com.tencent.maas.analytics;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.io.PrintStream;
import java.nio.ByteBuffer;

public class MJAnalyticsEventSinkDemo
  extends MJAnalyticsEventSink
{
  public void sinkEvent(MJAnalyticsEvent paramMJAnalyticsEvent)
  {
    AppMethodBeat.i(216951);
    System.out.println(paramMJAnalyticsEvent.getPBData().toString());
    AppMethodBeat.o(216951);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.maas.analytics.MJAnalyticsEventSinkDemo
 * JD-Core Version:    0.7.0.1
 */