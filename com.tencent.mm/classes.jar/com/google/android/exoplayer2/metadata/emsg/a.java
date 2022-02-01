package com.google.android.exoplayer2.metadata.emsg;

import com.google.android.exoplayer2.i.m;
import com.google.android.exoplayer2.metadata.Metadata;
import com.google.android.exoplayer2.metadata.Metadata.Entry;
import com.google.android.exoplayer2.metadata.d;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.nio.ByteBuffer;
import java.util.Arrays;

public final class a
  implements com.google.android.exoplayer2.metadata.a
{
  public final Metadata a(d paramd)
  {
    AppMethodBeat.i(92395);
    Object localObject = paramd.cKQ;
    paramd = ((ByteBuffer)localObject).array();
    int i = ((ByteBuffer)localObject).limit();
    localObject = new m(paramd, i);
    String str1 = ((m)localObject).UQ();
    String str2 = ((m)localObject).UQ();
    long l = ((m)localObject).FT();
    ((m)localObject).iH(4);
    paramd = new Metadata(new Metadata.Entry[] { new EventMessage(str1, str2, ((m)localObject).FT() * 1000L / l, ((m)localObject).FT(), Arrays.copyOfRange(paramd, ((m)localObject).position, i)) });
    AppMethodBeat.o(92395);
    return paramd;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.google.android.exoplayer2.metadata.emsg.a
 * JD-Core Version:    0.7.0.1
 */