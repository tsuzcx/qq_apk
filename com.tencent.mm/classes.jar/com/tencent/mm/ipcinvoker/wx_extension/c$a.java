package com.tencent.mm.ipcinvoker.wx_extension;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.MultiProcessMMKV;

final class c$a
{
  private static final MultiProcessMMKV hnJ;
  
  static
  {
    AppMethodBeat.i(146410);
    hnJ = MultiProcessMMKV.getMMKV("MicroMsg_XIPC_MMProtoBufTransfer");
    AppMethodBeat.o(146410);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.ipcinvoker.wx_extension.c.a
 * JD-Core Version:    0.7.0.1
 */