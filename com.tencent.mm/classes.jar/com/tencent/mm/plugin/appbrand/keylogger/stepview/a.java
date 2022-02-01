package com.tencent.mm.plugin.appbrand.keylogger.stepview;

import com.tencent.luggage.a.d;

public final class a
{
  public static int BE(int paramInt)
  {
    switch (paramInt)
    {
    case -1: 
    case 1: 
    default: 
      return a.d.step_error;
    case 0: 
      return a.d.step_ok;
    case -2: 
      return a.d.step_optional;
    }
    return a.d.step_attention;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.keylogger.stepview.a
 * JD-Core Version:    0.7.0.1
 */