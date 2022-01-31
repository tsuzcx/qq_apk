package com.tencent.mm.plugin.expt.hellhound.a.b.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.expt.hellhound.core.a.b;
import com.tencent.mm.protocal.protobuf.cag;
import com.tencent.mm.sdk.platformtools.ab;
import java.io.IOException;

public final class d
{
  public static void a(cag paramcag)
  {
    AppMethodBeat.i(152386);
    try
    {
      b.v("mkv_k_hellsubascld", paramcag.toByteArray());
      AppMethodBeat.o(152386);
      return;
    }
    catch (Exception paramcag)
    {
      ab.printErrStackTrace("HellSessionUBACloudConfigDao", paramcag, "habbyge-mali, HellSessionUBACloudConfigDao writeBack", new Object[0]);
      AppMethodBeat.o(152386);
    }
  }
  
  public static cag bst()
  {
    AppMethodBeat.i(152387);
    byte[] arrayOfByte = b.getBytes("mkv_k_hellsubascld");
    if ((arrayOfByte == null) || (arrayOfByte.length <= 0))
    {
      ab.e("HellSessionUBACloudConfigDao", "habbyge-mali, HellSessionUBACloudConfigDao read(): NULL");
      AppMethodBeat.o(152387);
      return null;
    }
    cag localcag = new cag();
    try
    {
      localcag.parseFrom(arrayOfByte);
      AppMethodBeat.o(152387);
      return localcag;
    }
    catch (IOException localIOException)
    {
      ab.printErrStackTrace("HellSessionUBACloudConfigDao", localIOException, "habbyge-mali, SessionUBACloudConfig read", new Object[0]);
      AppMethodBeat.o(152387);
    }
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.expt.hellhound.a.b.b.d
 * JD-Core Version:    0.7.0.1
 */