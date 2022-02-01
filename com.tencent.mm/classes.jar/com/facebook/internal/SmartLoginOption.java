package com.facebook.internal;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.EnumSet;
import java.util.Iterator;

public enum SmartLoginOption
{
  public static final EnumSet<SmartLoginOption> ALL;
  private final long mValue;
  
  static
  {
    AppMethodBeat.i(17920);
    None = new SmartLoginOption("None", 0, 0L);
    Enabled = new SmartLoginOption("Enabled", 1, 1L);
    RequireConfirm = new SmartLoginOption("RequireConfirm", 2, 2L);
    $VALUES = new SmartLoginOption[] { None, Enabled, RequireConfirm };
    ALL = EnumSet.allOf(SmartLoginOption.class);
    AppMethodBeat.o(17920);
  }
  
  private SmartLoginOption(long paramLong)
  {
    this.mValue = paramLong;
  }
  
  public static EnumSet<SmartLoginOption> parseOptions(long paramLong)
  {
    AppMethodBeat.i(17919);
    EnumSet localEnumSet = EnumSet.noneOf(SmartLoginOption.class);
    Iterator localIterator = ALL.iterator();
    while (localIterator.hasNext())
    {
      SmartLoginOption localSmartLoginOption = (SmartLoginOption)localIterator.next();
      if ((localSmartLoginOption.getValue() & paramLong) != 0L) {
        localEnumSet.add(localSmartLoginOption);
      }
    }
    AppMethodBeat.o(17919);
    return localEnumSet;
  }
  
  public final long getValue()
  {
    return this.mValue;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.facebook.internal.SmartLoginOption
 * JD-Core Version:    0.7.0.1
 */