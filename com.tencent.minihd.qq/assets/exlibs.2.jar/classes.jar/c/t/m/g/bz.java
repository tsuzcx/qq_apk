package c.t.m.g;

import android.net.wifi.ScanResult;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public final class bz
{
  public final List<ScanResult> a;
  public final long b;
  public final int c;
  
  public bz(List<ScanResult> paramList, long paramLong, int paramInt)
  {
    this.b = paramLong;
    this.c = paramInt;
    if (paramList != null)
    {
      this.a = new ArrayList(paramList);
      return;
    }
    this.a = Collections.emptyList();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.2.jar\classes.jar
 * Qualified Name:     c.t.m.g.bz
 * JD-Core Version:    0.7.0.1
 */