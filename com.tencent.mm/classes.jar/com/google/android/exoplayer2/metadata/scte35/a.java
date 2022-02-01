package com.google.android.exoplayer2.metadata.scte35;

import com.google.android.exoplayer2.i.l;
import com.google.android.exoplayer2.i.m;
import com.google.android.exoplayer2.i.u;
import com.google.android.exoplayer2.metadata.Metadata;
import com.google.android.exoplayer2.metadata.Metadata.Entry;
import com.google.android.exoplayer2.metadata.d;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.nio.ByteBuffer;

public final class a
  implements com.google.android.exoplayer2.metadata.a
{
  private u bnh;
  private final m bsn;
  private final l buF;
  
  public a()
  {
    AppMethodBeat.i(92485);
    this.bsn = new m();
    this.buF = new l();
    AppMethodBeat.o(92485);
  }
  
  public final Metadata a(d paramd)
  {
    AppMethodBeat.i(92486);
    if ((this.bnh == null) || (paramd.bdC != this.bnh.xs()))
    {
      this.bnh = new u(paramd.timeUs);
      this.bnh.ap(paramd.timeUs - paramd.bdC);
    }
    paramd = paramd.aKP;
    byte[] arrayOfByte = paramd.array();
    int i = paramd.limit();
    this.bsn.n(arrayOfByte, i);
    this.buF.n(arrayOfByte, i);
    this.buF.en(39);
    long l = this.buF.em(1);
    l = this.buF.em(32) | l << 32;
    this.buF.en(20);
    i = this.buF.em(12);
    int j = this.buF.em(8);
    this.bsn.eZ(14);
    switch (j)
    {
    default: 
      paramd = null;
    }
    while (paramd == null)
    {
      paramd = new Metadata(new Metadata.Entry[0]);
      AppMethodBeat.o(92486);
      return paramd;
      paramd = new SpliceNullCommand();
      continue;
      paramd = SpliceScheduleCommand.y(this.bsn);
      continue;
      paramd = SpliceInsertCommand.a(this.bsn, l, this.bnh);
      continue;
      paramd = TimeSignalCommand.b(this.bsn, l, this.bnh);
      continue;
      paramd = PrivateCommand.a(this.bsn, i, l);
    }
    paramd = new Metadata(new Metadata.Entry[] { paramd });
    AppMethodBeat.o(92486);
    return paramd;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.google.android.exoplayer2.metadata.scte35.a
 * JD-Core Version:    0.7.0.1
 */