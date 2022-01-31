package com.tencent.mm.plugin.clean.c;

import com.tencent.mm.plugin.h.b.a;
import com.tencent.mm.sdk.platformtools.bk;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

public final class i
{
  public long bHR;
  public long eHF;
  public String filePath;
  public List<a> iBW = new ArrayList();
  public long size;
  public String thumbPath;
  public int type;
  public String userName;
  
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.clean.c.i
 * JD-Core Version:    0.7.0.1
 */