package com.tencent.mm.f.b;

import com.tencent.mm.plugin.zero.b.a;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.sdk.platformtools.y;

public class g
{
  public static final String bDs = com.tencent.mm.compatible.util.e.bkH + "test.wav";
  public static final String bDt = com.tencent.mm.compatible.util.e.bkH + "test.pcm";
  
  public static int r(String paramString, int paramInt)
  {
    try
    {
      int i = bk.getInt(((a)com.tencent.mm.kernel.g.r(a.class)).AA().getValue(paramString), paramInt);
      return i;
    }
    catch (Exception localException)
    {
      y.e("MicroMsg.RecorderUtil", "getIntValFromDynamicConfig parseInt failed, key: " + paramString);
      return paramInt;
    }
    catch (Error localError)
    {
      y.e("MicroMsg.RecorderUtil", "error on parseInt failed, key: " + paramString);
    }
    return paramInt;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.f.b.g
 * JD-Core Version:    0.7.0.1
 */