package com.tencent.mm.bq;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.MultiProcessMMKV;

public final class b
{
  private static String XNf = "mmkv_gpu_info";
  private static String XNg = "channel_id";
  public static String XNh = "voip_norify_channel_silent";
  public static String XNi = "voip_ringtone_channel_";
  
  public static String iGr()
  {
    AppMethodBeat.i(230936);
    String str = MultiProcessMMKV.getMMKV(XNf).getString(XNg, XNh);
    AppMethodBeat.o(230936);
    return str;
  }
  
  public static String xX(long paramLong)
  {
    AppMethodBeat.i(230934);
    String str = XNh + paramLong;
    MultiProcessMMKV.getMMKV(XNf).putString(XNg, str);
    AppMethodBeat.o(230934);
    return str;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.bq.b
 * JD-Core Version:    0.7.0.1
 */