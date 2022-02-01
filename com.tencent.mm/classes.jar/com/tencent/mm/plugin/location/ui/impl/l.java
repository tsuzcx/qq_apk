package com.tencent.mm.plugin.location.ui.impl;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.protocal.protobuf.pp;
import java.util.ArrayList;
import java.util.List;

public final class l
{
  private static l sXB;
  List<pp> sOM;
  
  static
  {
    AppMethodBeat.i(56227);
    sXB = new l();
    AppMethodBeat.o(56227);
  }
  
  private l()
  {
    AppMethodBeat.i(56226);
    this.sOM = new ArrayList(8);
    AppMethodBeat.o(56226);
  }
  
  public static l cKK()
  {
    return sXB;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.location.ui.impl.l
 * JD-Core Version:    0.7.0.1
 */