package com.tencent.mm.plugin.clean.c;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.f.b.a;
import com.tencent.mm.sdk.platformtools.bt;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

public final class c
{
  public long ded;
  public String filePath;
  public long hAg;
  public int msgType;
  public List<a> nNL;
  public long size;
  public String thumbPath;
  public int type;
  public String userName;
  
  public c()
  {
    AppMethodBeat.i(22824);
    this.nNL = new ArrayList();
    AppMethodBeat.o(22824);
  }
  
  public final long bNR()
  {
    AppMethodBeat.i(22826);
    Calendar localCalendar = Calendar.getInstance();
    localCalendar.setTimeInMillis(this.hAg);
    int i = localCalendar.get(1);
    long l = localCalendar.get(2) + i * 100;
    AppMethodBeat.o(22826);
    return l;
  }
  
  public final String toString()
  {
    AppMethodBeat.i(22825);
    switch (this.type)
    {
    default: 
      AppMethodBeat.o(22825);
      return "";
    case 1: 
      str = String.format("%-8s    %-10s  %s\r\n", new Object[] { "IMG", bt.vK(this.size), this.filePath });
      AppMethodBeat.o(22825);
      return str;
    case 3: 
      str = String.format("%-8s    %-10s  %s\r\n", new Object[] { "VIDEO", bt.vK(this.size), this.filePath });
      AppMethodBeat.o(22825);
      return str;
    case 2: 
      str = String.format("%-8s    %-10s  %s\r\n", new Object[] { "VOICE", bt.vK(this.size), this.filePath });
      AppMethodBeat.o(22825);
      return str;
    }
    String str = String.format("%-8s    %-10s  %s\r\n", new Object[] { "ATTACH", bt.vK(this.size), this.filePath });
    AppMethodBeat.o(22825);
    return str;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.clean.c.c
 * JD-Core Version:    0.7.0.1
 */