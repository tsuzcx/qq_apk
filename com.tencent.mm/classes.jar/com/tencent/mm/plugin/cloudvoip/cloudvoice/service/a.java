package com.tencent.mm.plugin.cloudvoip.cloudvoice.service;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class a
{
  public byte cFps;
  public byte cIPeriod;
  public byte cIReqFlag;
  public byte cResolution;
  public byte cRsvd1;
  public byte cSkipFlag;
  public short iKbps;
  public byte[] s2p;
  public byte wTD;
  public byte wTE;
  
  public a()
  {
    AppMethodBeat.i(90788);
    this.s2p = new byte[10];
    AppMethodBeat.o(90788);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.cloudvoip.cloudvoice.service.a
 * JD-Core Version:    0.7.0.1
 */