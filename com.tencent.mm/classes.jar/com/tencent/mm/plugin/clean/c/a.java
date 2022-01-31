package com.tencent.mm.plugin.clean.c;

import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.sdk.platformtools.y;
import com.tencent.mm.vfs.e;
import java.util.Calendar;

public final class a
{
  public long bHR;
  public long eHF;
  public String filePath;
  public long size;
  public String thumbPath;
  public int type;
  private String userName;
  
  public a(String paramString1, String paramString2, int paramInt, String paramString3, long paramLong1, long paramLong2)
  {
    this.size = e.aeQ(paramString2);
    y.v("MicroMsg.AnalyseItem", "add mst %d %d %s %s %d", new Object[] { Long.valueOf(this.size), Integer.valueOf(paramInt), bk.ht(this.size), paramString3, Long.valueOf(paramLong1) });
    this.thumbPath = paramString1;
    this.type = paramInt;
    this.filePath = paramString2;
    this.userName = paramString3;
    this.bHR = paramLong1;
    this.eHF = paramLong2;
  }
  
  public final long aDF()
  {
    Calendar localCalendar = Calendar.getInstance();
    localCalendar.setTimeInMillis(this.eHF);
    int i = localCalendar.get(1);
    return localCalendar.get(2) + i * 100;
  }
  
  public final String toString()
  {
    switch (this.type)
    {
    default: 
      return "";
    case 1: 
      return String.format("%-8s    %-10s  %s\r\n", new Object[] { "IMG", bk.ht(this.size), this.filePath });
    case 3: 
      return String.format("%-8s    %-10s  %s\r\n", new Object[] { "VIDEO", bk.ht(this.size), this.filePath });
    case 2: 
      return String.format("%-8s    %-10s  %s\r\n", new Object[] { "VOICE", bk.ht(this.size), this.filePath });
    }
    return String.format("%-8s    %-10s  %s\r\n", new Object[] { "ATTACH", bk.ht(this.size), this.filePath });
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.clean.c.a
 * JD-Core Version:    0.7.0.1
 */