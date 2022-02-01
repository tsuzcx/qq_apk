package com.tencent.maas.camerafun;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.HashMap;
import java.util.Map;

public enum MJAuditCaptureSettings$MJAuditCaptureOutputType
{
  private static final Map<Integer, MJAuditCaptureOutputType> intToTypeMap;
  private final int value;
  
  static
  {
    int i = 0;
    AppMethodBeat.i(216854);
    None = new MJAuditCaptureOutputType("None", 0, 0);
    JPEGs = new MJAuditCaptureOutputType("JPEGs", 1, 1);
    $VALUES = new MJAuditCaptureOutputType[] { None, JPEGs };
    intToTypeMap = new HashMap();
    MJAuditCaptureOutputType[] arrayOfMJAuditCaptureOutputType = values();
    int j = arrayOfMJAuditCaptureOutputType.length;
    while (i < j)
    {
      MJAuditCaptureOutputType localMJAuditCaptureOutputType = arrayOfMJAuditCaptureOutputType[i];
      intToTypeMap.put(Integer.valueOf(localMJAuditCaptureOutputType.value), localMJAuditCaptureOutputType);
      i += 1;
    }
    AppMethodBeat.o(216854);
  }
  
  private MJAuditCaptureSettings$MJAuditCaptureOutputType(int paramInt)
  {
    this.value = paramInt;
  }
  
  public static MJAuditCaptureOutputType fromValue(int paramInt)
  {
    switch (paramInt)
    {
    default: 
      return None;
    case 0: 
      return None;
    }
    return JPEGs;
  }
  
  public final int getValue()
  {
    return this.value;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.maas.camerafun.MJAuditCaptureSettings.MJAuditCaptureOutputType
 * JD-Core Version:    0.7.0.1
 */