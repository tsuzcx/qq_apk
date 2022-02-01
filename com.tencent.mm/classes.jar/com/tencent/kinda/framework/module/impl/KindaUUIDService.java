package com.tencent.kinda.framework.module.impl;

import com.tencent.kinda.gen.KUUIDService;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.UUID;

public class KindaUUIDService
  implements KUUIDService
{
  public String getUuid()
  {
    AppMethodBeat.i(18659);
    String str = UUID.randomUUID().toString();
    AppMethodBeat.o(18659);
    return str;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.kinda.framework.module.impl.KindaUUIDService
 * JD-Core Version:    0.7.0.1
 */