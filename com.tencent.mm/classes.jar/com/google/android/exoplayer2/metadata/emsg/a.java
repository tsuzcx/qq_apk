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
    AppMethodBeat.i(95273);
    Object localObject = paramd.aAS;
    paramd = ((ByteBuffer)localObject).array();
    int i = ((ByteBuffer)localObject).limit();
    localObject = new m(paramd, i);
    String str1 = ((m)localObject).qW();
    String str2 = ((m)localObject).qW();
    long l = ((m)localObject).cc();
    ((m)localObject).en(4);
    paramd = new Metadata(new Metadata.Entry[] { new EventMessage(str1, str2, ((m)localObject).cc() * 1000L / l, ((m)localObject).cc(), Arrays.copyOfRange(paramd, ((m)localObject).position, i)) });
    AppMethodBeat.o(95273);
    return paramd;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.google.android.exoplayer2.metadata.emsg.a
 * JD-Core Version:    0.7.0.1
 */