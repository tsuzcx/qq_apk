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
  private u bcR;
  private final m bhY;
  private final l bkq;
  
  public a()
  {
    AppMethodBeat.i(92485);
    this.bhY = new m();
    this.bkq = new l();
    AppMethodBeat.o(92485);
  }
  
  public final Metadata a(d paramd)
  {
    AppMethodBeat.i(92486);
    if ((this.bcR == null) || (paramd.aTk != this.bcR.vN()))
    {
      this.bcR = new u(paramd.timeUs);
      this.bcR.ap(paramd.timeUs - paramd.aTk);
    }
    paramd = paramd.aJg;
    byte[] arrayOfByte = paramd.array();
    int i = paramd.limit();
    this.bhY.n(arrayOfByte, i);
    this.bkq.n(arrayOfByte, i);
    this.bkq.ep(39);
    long l = this.bkq.eo(1);
    l = this.bkq.eo(32) | l << 32;
    this.bkq.ep(20);
    i = this.bkq.eo(12);
    int j = this.bkq.eo(8);
    this.bhY.eX(14);
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
      paramd = SpliceScheduleCommand.y(this.bhY);
      continue;
      paramd = SpliceInsertCommand.a(this.bhY, l, this.bcR);
      continue;
      paramd = TimeSignalCommand.b(this.bhY, l, this.bcR);
      continue;
      paramd = PrivateCommand.a(this.bhY, i, l);
    }
    paramd = new Metadata(new Metadata.Entry[] { paramd });
    AppMethodBeat.o(92486);
    return paramd;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.google.android.exoplayer2.metadata.scte35.a
 * JD-Core Version:    0.7.0.1
 */