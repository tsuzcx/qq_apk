package com.tencent.liteav.muxer;

import android.content.Context;
import android.media.MediaFormat;
import com.tencent.liteav.basic.log.TXCLog;
import com.tencent.matrix.trace.core.AppMethodBeat;

public class c
  implements a
{
  private int a;
  private a b;
  
  public c(Context paramContext, int paramInt)
  {
    AppMethodBeat.i(14901);
    this.a = 0;
    switch (paramInt)
    {
    default: 
      if (a(paramContext))
      {
        this.a = 0;
        this.b = new d();
        TXCLog.i("TXCMP4Muxer", "TXCMP4Muxer: use sw model ");
        AppMethodBeat.o(14901);
        return;
      }
      break;
    case 0: 
      this.a = 0;
      this.b = new d();
      TXCLog.i("TXCMP4Muxer", "TXCMP4Muxer: use sw model ");
      AppMethodBeat.o(14901);
      return;
    case 1: 
      this.a = 1;
      this.b = new b();
      TXCLog.i("TXCMP4Muxer", "TXCMP4Muxer: use hw model ");
      AppMethodBeat.o(14901);
      return;
    }
    this.a = 1;
    this.b = new b();
    TXCLog.i("TXCMP4Muxer", "TXCMP4Muxer: use hw model ");
    AppMethodBeat.o(14901);
  }
  
  public static boolean a(Context paramContext)
  {
    AppMethodBeat.i(14902);
    com.tencent.liteav.basic.e.b.a().a(paramContext);
    if (com.tencent.liteav.basic.e.b.a().e() == 1)
    {
      AppMethodBeat.o(14902);
      return true;
    }
    AppMethodBeat.o(14902);
    return false;
  }
  
  public int a()
  {
    AppMethodBeat.i(14908);
    int i = this.b.a();
    AppMethodBeat.o(14908);
    return i;
  }
  
  public void a(MediaFormat paramMediaFormat)
  {
    AppMethodBeat.i(14903);
    this.b.a(paramMediaFormat);
    AppMethodBeat.o(14903);
  }
  
  public void a(String paramString)
  {
    AppMethodBeat.i(14905);
    this.b.a(paramString);
    AppMethodBeat.o(14905);
  }
  
  public void a(byte[] paramArrayOfByte, int paramInt1, int paramInt2, long paramLong, int paramInt3)
  {
    AppMethodBeat.i(14906);
    this.b.a(paramArrayOfByte, paramInt1, paramInt2, paramLong, paramInt3);
    AppMethodBeat.o(14906);
  }
  
  public int b()
  {
    AppMethodBeat.i(14909);
    int i = this.b.b();
    AppMethodBeat.o(14909);
    return i;
  }
  
  public void b(MediaFormat paramMediaFormat)
  {
    AppMethodBeat.i(14904);
    this.b.b(paramMediaFormat);
    AppMethodBeat.o(14904);
  }
  
  public void b(byte[] paramArrayOfByte, int paramInt1, int paramInt2, long paramLong, int paramInt3)
  {
    AppMethodBeat.i(14907);
    this.b.b(paramArrayOfByte, paramInt1, paramInt2, paramLong, paramInt3);
    AppMethodBeat.o(14907);
  }
  
  public boolean c()
  {
    AppMethodBeat.i(14910);
    boolean bool = this.b.c();
    AppMethodBeat.o(14910);
    return bool;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.liteav.muxer.c
 * JD-Core Version:    0.7.0.1
 */