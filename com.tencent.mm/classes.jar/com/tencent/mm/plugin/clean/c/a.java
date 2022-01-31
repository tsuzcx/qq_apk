package com.tencent.mm.plugin.clean.c;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.vfs.e;
import java.util.Calendar;

public final class a
{
  public long cpg;
  public long fXv;
  public String filePath;
  public long size;
  public String thumbPath;
  public int type;
  private String userName;
  
  public a(String paramString1, String paramString2, int paramInt, String paramString3, long paramLong1, long paramLong2)
  {
    AppMethodBeat.i(18663);
    this.size = e.avI(paramString2);
    ab.v("MicroMsg.AnalyseItem", "add mst %d %d %s %s %d", new Object[] { Long.valueOf(this.size), Integer.valueOf(paramInt), bo.nV(this.size), paramString3, Long.valueOf(paramLong1) });
    this.thumbPath = paramString1;
    this.type = paramInt;
    this.filePath = paramString2;
    this.userName = paramString3;
    this.cpg = paramLong1;
    this.fXv = paramLong2;
    AppMethodBeat.o(18663);
  }
  
  public final long bgF()
  {
    AppMethodBeat.i(18665);
    Calendar localCalendar = Calendar.getInstance();
    localCalendar.setTimeInMillis(this.fXv);
    int i = localCalendar.get(1);
    long l = localCalendar.get(2) + i * 100;
    AppMethodBeat.o(18665);
    return l;
  }
  
  public final String toString()
  {
    AppMethodBeat.i(18664);
    switch (this.type)
    {
    default: 
      AppMethodBeat.o(18664);
      return "";
    case 1: 
      str = String.format("%-8s    %-10s  %s\r\n", new Object[] { "IMG", bo.nV(this.size), this.filePath });
      AppMethodBeat.o(18664);
      return str;
    case 3: 
      str = String.format("%-8s    %-10s  %s\r\n", new Object[] { "VIDEO", bo.nV(this.size), this.filePath });
      AppMethodBeat.o(18664);
      return str;
    case 2: 
      str = String.format("%-8s    %-10s  %s\r\n", new Object[] { "VOICE", bo.nV(this.size), this.filePath });
      AppMethodBeat.o(18664);
      return str;
    }
    String str = String.format("%-8s    %-10s  %s\r\n", new Object[] { "ATTACH", bo.nV(this.size), this.filePath });
    AppMethodBeat.o(18664);
    return str;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.clean.c.a
 * JD-Core Version:    0.7.0.1
 */