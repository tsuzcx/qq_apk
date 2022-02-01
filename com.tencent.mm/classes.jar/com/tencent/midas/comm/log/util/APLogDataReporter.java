package com.tencent.midas.comm.log.util;

import com.tencent.matrix.trace.core.AppMethodBeat;

public class APLogDataReporter
{
  public static final String MIDAS_LOG_ERROR_APPEND = "sdk.log.error.append";
  public static final String MIDAS_LOG_ERROR_CLOSE = "sdk.log.error.close";
  public static final String MIDAS_LOG_ERROR_FLUSH = "sdk.log.error.flush";
  public static final String MIDAS_LOG_ERROR_INIT = "sdk.log.error.init";
  public static final String MIDAS_LOG_ERROR_MMAP_OPEN = "sdk.log.error.mmap.open";
  public static final String MIDAS_LOG_ERROR_PRINT = "sdk.log.error.print";
  public static final String MIDAS_LOG_ERROR_PROCESS = "sdk.log.error.process";
  public static final String MIDAS_LOG_ERROR_WRITE = "sdk.log.error.write";
  public static final String MIDAS_LOG_INIT = "sdk.log.init";
  private Reporter reporter;
  
  public static APLogDataReporter getInstance()
  {
    AppMethodBeat.i(217270);
    APLogDataReporter localAPLogDataReporter = Holder.INSTANCE;
    AppMethodBeat.o(217270);
    return localAPLogDataReporter;
  }
  
  public Reporter getReporter()
  {
    return this.reporter;
  }
  
  public void report(String paramString1, String paramString2)
  {
    AppMethodBeat.i(217300);
    report("launchpay", paramString1, paramString2);
    AppMethodBeat.o(217300);
  }
  
  public void report(String paramString1, String paramString2, String paramString3)
  {
    AppMethodBeat.i(217307);
    try
    {
      if (this.reporter != null) {
        this.reporter.report(paramString1, paramString2, paramString3);
      }
      AppMethodBeat.o(217307);
      return;
    }
    finally
    {
      new StringBuilder("report error: ").append(paramString1.getMessage());
      AppMethodBeat.o(217307);
    }
  }
  
  public void reportTimeEx(String paramString, long paramLong)
  {
    AppMethodBeat.i(217318);
    report(paramString, String.valueOf(System.currentTimeMillis() - paramLong));
    AppMethodBeat.o(217318);
  }
  
  public void setReporter(Reporter paramReporter)
  {
    this.reporter = paramReporter;
  }
  
  static class Holder
  {
    private static final APLogDataReporter INSTANCE;
    
    static
    {
      AppMethodBeat.i(217267);
      INSTANCE = new APLogDataReporter(null);
      AppMethodBeat.o(217267);
    }
  }
  
  public static abstract interface Reporter
  {
    public abstract void report(String paramString1, String paramString2, String paramString3);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.midas.comm.log.util.APLogDataReporter
 * JD-Core Version:    0.7.0.1
 */