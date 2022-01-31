package com.tencent.mm.ipcinvoker;

import java.util.HashMap;
import java.util.Map;

public class h
{
  private static volatile h dGL;
  Map<String, BaseIPCService> dGM = new HashMap();
  
  public static h BW()
  {
    if (dGL == null) {}
    try
    {
      if (dGL == null) {
        dGL = new h();
      }
      return dGL;
    }
    finally {}
  }
  
  public final BaseIPCService fH(String paramString)
  {
    return (BaseIPCService)this.dGM.get(paramString);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.ipcinvoker.h
 * JD-Core Version:    0.7.0.1
 */