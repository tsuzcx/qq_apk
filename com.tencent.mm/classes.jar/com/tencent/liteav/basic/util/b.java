package com.tencent.liteav.basic.util;

import android.os.Process;
import android.text.TextUtils;
import com.tencent.liteav.basic.log.TXCLog;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.util.Locale;
import java.util.concurrent.TimeUnit;

public class b
{
  private static final long a;
  private final long b;
  private final int c;
  private RandomAccessFile d;
  private RandomAccessFile e;
  private long f;
  private float g;
  private float h;
  private long i;
  private long j;
  private float k;
  
  static
  {
    AppMethodBeat.i(14738);
    a = TimeUnit.SECONDS.toMillis(2L);
    AppMethodBeat.o(14738);
  }
  
  public b()
  {
    AppMethodBeat.i(14733);
    this.f = 0L;
    this.g = 0.0F;
    this.h = 0.0F;
    this.i = 0L;
    this.j = 0L;
    this.k = 0.0F;
    this.b = TXCTimeUtil.getClockTickInHz();
    this.c = Runtime.getRuntime().availableProcessors();
    String str = String.format(Locale.ENGLISH, "/proc/%d/stat", new Object[] { Integer.valueOf(Process.myPid()) });
    try
    {
      this.d = new RandomAccessFile(str, "r");
    }
    catch (IOException localIOException1)
    {
      for (;;)
      {
        try
        {
          this.e = new RandomAccessFile("/proc/stat", "r");
          AppMethodBeat.o(14733);
          return;
        }
        catch (IOException localIOException2)
        {
          AppMethodBeat.o(14733);
        }
        localIOException1 = localIOException1;
        TXCLog.e("CpuUsageMeasurer", "open /proc/[PID]/stat failed. " + localIOException1.getMessage());
      }
    }
  }
  
  private static String[] a(RandomAccessFile paramRandomAccessFile)
  {
    AppMethodBeat.i(14736);
    if (paramRandomAccessFile == null)
    {
      AppMethodBeat.o(14736);
      return null;
    }
    try
    {
      paramRandomAccessFile.seek(0L);
      paramRandomAccessFile = paramRandomAccessFile.readLine();
      if (TextUtils.isEmpty(paramRandomAccessFile))
      {
        AppMethodBeat.o(14736);
        return null;
      }
    }
    catch (IOException paramRandomAccessFile)
    {
      for (;;)
      {
        TXCLog.e("CpuUsageMeasurer", "read line failed. " + paramRandomAccessFile.getMessage());
        paramRandomAccessFile = null;
      }
      paramRandomAccessFile = paramRandomAccessFile.split("\\s+");
      AppMethodBeat.o(14736);
    }
    return paramRandomAccessFile;
  }
  
  private void b()
  {
    AppMethodBeat.i(14735);
    String[] arrayOfString = a(this.d);
    if ((arrayOfString == null) || (arrayOfString.length < 52))
    {
      AppMethodBeat.o(14735);
      return;
    }
    long l1 = Long.parseLong(arrayOfString[13]);
    long l2 = Long.parseLong(arrayOfString[14]);
    long l3 = Long.parseLong(arrayOfString[15]);
    l3 = ((float)(Long.parseLong(arrayOfString[16]) + (l1 + l2 + l3)) * 1000.0F / (float)this.b);
    arrayOfString = a(this.e);
    if ((arrayOfString == null) || (arrayOfString.length < 8))
    {
      l1 = TXCTimeUtil.getTimeTick();
      l2 = this.c * l1;
      l1 = l2;
    }
    for (;;)
    {
      long l4 = l1 - this.i;
      this.h = (((float)l3 - this.g) * 100.0F / (float)l4);
      this.k = ((float)(l4 - (l2 - this.j)) * 100.0F / (float)l4);
      this.g = ((float)l3);
      this.j = l2;
      this.i = l1;
      this.f = TXCTimeUtil.getTimeTick();
      AppMethodBeat.o(14735);
      return;
      l1 = Long.parseLong(arrayOfString[1]);
      long l5 = Long.parseLong(arrayOfString[2]);
      long l6 = Long.parseLong(arrayOfString[3]);
      long l7 = Long.parseLong(arrayOfString[4]);
      long l8 = Long.parseLong(arrayOfString[5]);
      long l9 = Long.parseLong(arrayOfString[6]);
      long l10 = Long.parseLong(arrayOfString[7]);
      l2 = Long.parseLong(arrayOfString[4]);
      l4 = Long.parseLong(arrayOfString[5]);
      l1 = ((float)(l1 + l5 + l6 + l7 + l8 + l9 + l10) * 1000.0F / (float)this.b);
      l2 = ((float)(l2 + l4) * 1000.0F / (float)this.b);
    }
  }
  
  public int[] a()
  {
    AppMethodBeat.i(14734);
    try
    {
      if (TXCTimeUtil.getTimeTick() - this.f >= a) {
        b();
      }
      int m = (int)(this.h * 10.0F);
      int n = (int)(this.k * 10.0F);
      AppMethodBeat.o(14734);
      return new int[] { m, n };
    }
    finally
    {
      AppMethodBeat.o(14734);
    }
  }
  
  protected void finalize()
  {
    AppMethodBeat.i(14737);
    super.finalize();
    d.a(this.d);
    d.a(this.e);
    TXCLog.i("CpuUsageMeasurer", "measurer is released");
    AppMethodBeat.o(14737);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.liteav.basic.util.b
 * JD-Core Version:    0.7.0.1
 */