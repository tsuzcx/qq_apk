package com.tencent.mm.plugin.cloudvoip.cloudvoice.d;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ad;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;

public final class a
{
  public byte cFps;
  public byte cIPeriod;
  public byte cIReqFlag;
  public byte cResolution;
  public byte cRsvd1;
  public byte cSkipFlag;
  public short iKbps;
  public byte oWc;
  public byte oWd;
  public byte[] s2p;
  
  public a()
  {
    AppMethodBeat.i(90788);
    this.s2p = new byte[10];
    AppMethodBeat.o(90788);
  }
  
  public final void parseS2PData()
  {
    AppMethodBeat.i(190907);
    ByteBuffer localByteBuffer = ByteBuffer.wrap(this.s2p);
    localByteBuffer.order(ByteOrder.LITTLE_ENDIAN);
    this.iKbps = localByteBuffer.getShort();
    this.cFps = localByteBuffer.get();
    this.cIPeriod = localByteBuffer.get();
    this.cResolution = localByteBuffer.get();
    this.oWc = localByteBuffer.get();
    this.oWd = localByteBuffer.get();
    this.cSkipFlag = localByteBuffer.get();
    this.cIReqFlag = localByteBuffer.get();
    this.cRsvd1 = localByteBuffer.get();
    AppMethodBeat.o(190907);
  }
  
  public final void printS2P()
  {
    AppMethodBeat.i(190908);
    ad.d("OpenVoice[HWEnc]", "raw S2P:" + this.s2p);
    ad.d("OpenVoice[HWEnc]", "-S2P- iKbps:" + this.iKbps + ", fps:" + this.cFps + ", IP:" + this.cIPeriod + ", Reso:" + this.cResolution + ", Codec:" + this.oWc + ", HWEnable:" + this.oWd + ", Skip:" + this.cSkipFlag + ", IReq:" + this.cIReqFlag + ", Rsvd1:" + this.cRsvd1);
    AppMethodBeat.o(190908);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.cloudvoip.cloudvoice.d.a
 * JD-Core Version:    0.7.0.1
 */