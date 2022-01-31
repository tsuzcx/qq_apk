package com.google.android.gms.stats.netstats;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.Map;
import java.util.regex.Matcher;

public class NetstatsParserPatterns$NetstatsMatcher
{
  private Matcher zzaff;
  private Map<String, Integer> zzafg;
  
  public NetstatsParserPatterns$NetstatsMatcher(Matcher paramMatcher, Map<String, Integer> paramMap)
  {
    this.zzaff = paramMatcher;
    this.zzafg = paramMap;
  }
  
  public boolean find()
  {
    AppMethodBeat.i(113979);
    boolean bool = this.zzaff.find();
    AppMethodBeat.o(113979);
    return bool;
  }
  
  public String get(String paramString)
  {
    AppMethodBeat.i(113980);
    if (!this.zzafg.containsKey(paramString))
    {
      paramString = String.valueOf(paramString);
      if (paramString.length() != 0) {}
      for (paramString = "Unknown group ".concat(paramString);; paramString = new String("Unknown group "))
      {
        paramString = new IllegalArgumentException(paramString);
        AppMethodBeat.o(113980);
        throw paramString;
      }
    }
    paramString = this.zzaff.group(((Integer)this.zzafg.get(paramString)).intValue());
    AppMethodBeat.o(113980);
    return paramString;
  }
  
  public boolean matches()
  {
    AppMethodBeat.i(113978);
    boolean bool = this.zzaff.matches();
    AppMethodBeat.o(113978);
    return bool;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.google.android.gms.stats.netstats.NetstatsParserPatterns.NetstatsMatcher
 * JD-Core Version:    0.7.0.1
 */