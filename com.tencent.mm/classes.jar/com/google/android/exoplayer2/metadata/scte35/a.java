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
  private u bnm;
  private final m bss;
  private final l buL;
  
  public a()
  {
    AppMethodBeat.i(92485);
    this.bss = new m();
    this.buL = new l();
    AppMethodBeat.o(92485);
  }
  
  public final Metadata a(d paramd)
  {
    AppMethodBeat.i(92486);
    if ((this.bnm == null) || (paramd.bdF != this.bnm.xk()))
    {
      this.bnm = new u(paramd.timeUs);
      this.bnm.ap(paramd.timeUs - paramd.bdF);
    }
    paramd = paramd.aKX;
    byte[] arrayOfByte = paramd.array();
    int i = paramd.limit();
    this.bss.n(arrayOfByte, i);
    this.buL.n(arrayOfByte, i);
    this.buL.et(39);
    long l = this.buL.es(1);
    l = this.buL.es(32) | l << 32;
    this.buL.et(20);
    i = this.buL.es(12);
    int j = this.buL.es(8);
    this.bss.fa(14);
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
      paramd = SpliceScheduleCommand.y(this.bss);
      continue;
      paramd = SpliceInsertCommand.a(this.bss, l, this.bnm);
      continue;
      paramd = TimeSignalCommand.b(this.bss, l, this.bnm);
      continue;
      paramd = PrivateCommand.a(this.bss, i, l);
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