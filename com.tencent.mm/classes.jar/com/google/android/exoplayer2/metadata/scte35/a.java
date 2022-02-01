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
  private u aWJ;
  private final m bbP;
  private final l beh;
  
  public a()
  {
    AppMethodBeat.i(92485);
    this.bbP = new m();
    this.beh = new l();
    AppMethodBeat.o(92485);
  }
  
  public final Metadata a(d paramd)
  {
    AppMethodBeat.i(92486);
    if ((this.aWJ == null) || (paramd.aNc != this.aWJ.vv()))
    {
      this.aWJ = new u(paramd.timeUs);
      this.aWJ.at(paramd.timeUs - paramd.aNc);
    }
    paramd = paramd.aQU;
    byte[] arrayOfByte = paramd.array();
    int i = paramd.limit();
    this.bbP.n(arrayOfByte, i);
    this.beh.n(arrayOfByte, i);
    this.beh.eB(39);
    long l = this.beh.eA(1);
    l = this.beh.eA(32) | l << 32;
    this.beh.eB(20);
    i = this.beh.eA(12);
    int j = this.beh.eA(8);
    this.bbP.fu(14);
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
      paramd = SpliceScheduleCommand.y(this.bbP);
      continue;
      paramd = SpliceInsertCommand.a(this.bbP, l, this.aWJ);
      continue;
      paramd = TimeSignalCommand.b(this.bbP, l, this.aWJ);
      continue;
      paramd = PrivateCommand.a(this.bbP, i, l);
    }
    paramd = new Metadata(new Metadata.Entry[] { paramd });
    AppMethodBeat.o(92486);
    return paramd;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.google.android.exoplayer2.metadata.scte35.a
 * JD-Core Version:    0.7.0.1
 */