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
  private u aGN;
  private final m aLT;
  private final l aOl;
  
  public a()
  {
    AppMethodBeat.i(95363);
    this.aLT = new m();
    this.aOl = new l();
    AppMethodBeat.o(95363);
  }
  
  public final Metadata a(d paramd)
  {
    AppMethodBeat.i(95364);
    if ((this.aGN == null) || (paramd.awY != this.aGN.rb()))
    {
      this.aGN = new u(paramd.aAT);
      this.aGN.ai(paramd.aAT - paramd.awY);
    }
    paramd = paramd.aAS;
    byte[] arrayOfByte = paramd.array();
    int i = paramd.limit();
    this.aLT.l(arrayOfByte, i);
    this.aOl.l(arrayOfByte, i);
    this.aOl.dE(39);
    long l = this.aOl.dD(1);
    l = this.aOl.dD(32) | l << 32;
    this.aOl.dE(20);
    i = this.aOl.dD(12);
    int j = this.aOl.dD(8);
    this.aLT.en(14);
    switch (j)
    {
    default: 
      paramd = null;
    }
    while (paramd == null)
    {
      paramd = new Metadata(new Metadata.Entry[0]);
      AppMethodBeat.o(95364);
      return paramd;
      paramd = new SpliceNullCommand();
      continue;
      paramd = SpliceScheduleCommand.y(this.aLT);
      continue;
      paramd = SpliceInsertCommand.a(this.aLT, l, this.aGN);
      continue;
      paramd = TimeSignalCommand.b(this.aLT, l, this.aGN);
      continue;
      paramd = PrivateCommand.a(this.aLT, i, l);
    }
    paramd = new Metadata(new Metadata.Entry[] { paramd });
    AppMethodBeat.o(95364);
    return paramd;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.google.android.exoplayer2.metadata.scte35.a
 * JD-Core Version:    0.7.0.1
 */