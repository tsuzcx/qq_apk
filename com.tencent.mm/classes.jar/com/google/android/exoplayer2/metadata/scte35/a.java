package com.google.android.exoplayer2.metadata.scte35;

import com.google.android.exoplayer2.i.i;
import com.google.android.exoplayer2.i.j;
import com.google.android.exoplayer2.i.q;
import com.google.android.exoplayer2.metadata.Metadata;
import com.google.android.exoplayer2.metadata.Metadata.Entry;
import com.google.android.exoplayer2.metadata.d;
import java.nio.ByteBuffer;

public final class a
  implements com.google.android.exoplayer2.metadata.a
{
  private q aBX;
  private final j aFe = new j();
  private final i aHr = new i();
  
  public final Metadata a(d paramd)
  {
    if ((this.aBX == null) || (paramd.auG != this.aBX.op()))
    {
      this.aBX = new q(paramd.ayE);
      this.aBX.X(paramd.ayE - paramd.auG);
    }
    paramd = paramd.ayD;
    byte[] arrayOfByte = paramd.array();
    int i = paramd.limit();
    this.aFe.m(arrayOfByte, i);
    this.aHr.m(arrayOfByte, i);
    this.aHr.dy(39);
    long l = this.aHr.dz(1);
    l = this.aHr.dz(32) | l << 32;
    this.aHr.dy(20);
    i = this.aHr.dz(12);
    int j = this.aHr.dz(8);
    this.aFe.dB(14);
    switch (j)
    {
    default: 
      paramd = null;
    }
    while (paramd == null)
    {
      return new Metadata(new Metadata.Entry[0]);
      paramd = new SpliceNullCommand();
      continue;
      paramd = SpliceScheduleCommand.c(this.aFe);
      continue;
      paramd = SpliceInsertCommand.a(this.aFe, l, this.aBX);
      continue;
      paramd = TimeSignalCommand.b(this.aFe, l, this.aBX);
      continue;
      paramd = PrivateCommand.a(this.aFe, i, l);
    }
    return new Metadata(new Metadata.Entry[] { paramd });
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.google.android.exoplayer2.metadata.scte35.a
 * JD-Core Version:    0.7.0.1
 */