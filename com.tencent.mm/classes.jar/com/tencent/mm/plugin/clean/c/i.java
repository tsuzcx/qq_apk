package com.tencent.mm.plugin.clean.c;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.f.b.a;
import com.tencent.mm.sdk.platformtools.bo;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

public final class i
{
  public long cpg;
  public long fXv;
  public String filePath;
  public List<a> kHd;
  public long size;
  public String thumbPath;
  public int type;
  public String userName;
  
  public i()
  {
    AppMethodBeat.i(18715);
    this.kHd = new ArrayList();
    AppMethodBeat.o(18715);
  }
  
  public final long bgF()
  {
    AppMethodBeat.i(18717);
    Calendar localCalendar = Calendar.getInstance();
    localCalendar.setTimeInMillis(this.fXv);
    int i = localCalendar.get(1);
    long l = localCalendar.get(2) + i * 100;
    AppMethodBeat.o(18717);
    return l;
  }
  
  public final String toString()
  {
    AppMethodBeat.i(18716);
    switch (this.type)
    {
    default: 
      AppMethodBeat.o(18716);
      return "";
    case 1: 
      str = String.format("%-8s    %-10s  %s\r\n", new Object[] { "IMG", bo.nV(this.size), this.filePath });
      AppMethodBeat.o(18716);
      return str;
    case 3: 
      str = String.format("%-8s    %-10s  %s\r\n", new Object[] { "VIDEO", bo.nV(this.size), this.filePath });
      AppMethodBeat.o(18716);
      return str;
    case 2: 
      str = String.format("%-8s    %-10s  %s\r\n", new Object[] { "VOICE", bo.nV(this.size), this.filePath });
      AppMethodBeat.o(18716);
      return str;
    }
    String str = String.format("%-8s    %-10s  %s\r\n", new Object[] { "ATTACH", bo.nV(this.size), this.filePath });
    AppMethodBeat.o(18716);
    return str;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.clean.c.i
 * JD-Core Version:    0.7.0.1
 */