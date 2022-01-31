package com.tencent.mm.plugin.expt.hellhound.a.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.expt.hellhound.core.a.b;
import com.tencent.mm.protocal.protobuf.aef;
import com.tencent.mm.sdk.platformtools.ab;

public final class a
{
  static void a(aef paramaef)
  {
    AppMethodBeat.i(73448);
    try
    {
      b.v("hell_fntbck_pter_mmkv_key", paramaef.toByteArray());
      AppMethodBeat.o(73448);
      return;
    }
    catch (Exception paramaef)
    {
      ab.printErrStackTrace("FrontBackDao", paramaef, "habbyge-mali, writeBackFrontBack", new Object[0]);
      AppMethodBeat.o(73448);
    }
  }
  
  static aef brU()
  {
    AppMethodBeat.i(73449);
    byte[] arrayOfByte = b.getBytes("hell_fntbck_pter_mmkv_key");
    if ((arrayOfByte == null) || (arrayOfByte.length <= 0))
    {
      AppMethodBeat.o(73449);
      return null;
    }
    aef localaef = new aef();
    try
    {
      localaef.parseFrom(arrayOfByte);
      AppMethodBeat.o(73449);
      return localaef;
    }
    catch (Exception localException)
    {
      for (;;)
      {
        ab.printErrStackTrace("FrontBackDao", localException, "habbyge-mali, _doReadFrontBack parse", new Object[0]);
        Object localObject = null;
      }
    }
  }
  
  public static void hi(boolean paramBoolean)
  {
    AppMethodBeat.i(73446);
    aef localaef2 = brU();
    aef localaef1 = localaef2;
    if (localaef2 == null) {
      localaef1 = new aef();
    }
    localaef1.wXh = paramBoolean;
    ab.d("FrontBackDao", "habbyge-mali, logout8EventFromAdd: " + localaef1.wXh);
    a(localaef1);
    AppMethodBeat.o(73446);
  }
  
  public static void vq(int paramInt)
  {
    AppMethodBeat.i(73447);
    aef localaef2 = brU();
    aef localaef1 = localaef2;
    if (localaef2 == null) {
      localaef1 = new aef();
    }
    localaef1.wXc = paramInt;
    ab.d("FrontBackDao", "habbyge-mali, setFrontBackEvent_LastTime: ".concat(String.valueOf(paramInt)));
    a(localaef1);
    AppMethodBeat.o(73447);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.expt.hellhound.a.a.a
 * JD-Core Version:    0.7.0.1
 */