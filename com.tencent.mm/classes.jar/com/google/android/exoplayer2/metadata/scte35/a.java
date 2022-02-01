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
  private u bcf;
  private final m bhs;
  private final l bjL;
  
  public a()
  {
    AppMethodBeat.i(92485);
    this.bhs = new m();
    this.bjL = new l();
    AppMethodBeat.o(92485);
  }
  
  public final Metadata a(d paramd)
  {
    AppMethodBeat.i(92486);
    if ((this.bcf == null) || (paramd.aSr != this.bcf.vY()))
    {
      this.bcf = new u(paramd.timeUs);
      this.bcf.at(paramd.timeUs - paramd.aSr);
    }
    paramd = paramd.aIq;
    byte[] arrayOfByte = paramd.array();
    int i = paramd.limit();
    this.bhs.q(arrayOfByte, i);
    this.bjL.q(arrayOfByte, i);
    this.bjL.ep(39);
    long l = this.bjL.eo(1);
    l = this.bjL.eo(32) | l << 32;
    this.bjL.ep(20);
    i = this.bjL.eo(12);
    int j = this.bjL.eo(8);
    this.bhs.fl(14);
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
      paramd = SpliceScheduleCommand.y(this.bhs);
      continue;
      paramd = SpliceInsertCommand.a(this.bhs, l, this.bcf);
      continue;
      paramd = TimeSignalCommand.b(this.bhs, l, this.bcf);
      continue;
      paramd = PrivateCommand.a(this.bhs, i, l);
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