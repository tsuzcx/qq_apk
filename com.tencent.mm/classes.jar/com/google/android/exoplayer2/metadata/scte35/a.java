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
  private u cQF;
  private final m cVK;
  private final l cYa;
  
  public a()
  {
    AppMethodBeat.i(92485);
    this.cVK = new m();
    this.cYa = new l();
    AppMethodBeat.o(92485);
  }
  
  public final Metadata a(d paramd)
  {
    AppMethodBeat.i(92486);
    if ((this.cQF == null) || (paramd.cGY != this.cQF.UU()))
    {
      this.cQF = new u(paramd.timeUs);
      this.cQF.cH(paramd.timeUs - paramd.cGY);
    }
    paramd = paramd.cKQ;
    byte[] arrayOfByte = paramd.array();
    int i = paramd.limit();
    this.cVK.n(arrayOfByte, i);
    this.cYa.n(arrayOfByte, i);
    this.cYa.hR(39);
    long l = this.cYa.hQ(1);
    l = this.cYa.hQ(32) | l << 32;
    this.cYa.hR(20);
    i = this.cYa.hQ(12);
    int j = this.cYa.hQ(8);
    this.cVK.iH(14);
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
      paramd = SpliceScheduleCommand.y(this.cVK);
      continue;
      paramd = SpliceInsertCommand.a(this.cVK, l, this.cQF);
      continue;
      paramd = TimeSignalCommand.b(this.cVK, l, this.cQF);
      continue;
      paramd = PrivateCommand.a(this.cVK, i, l);
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