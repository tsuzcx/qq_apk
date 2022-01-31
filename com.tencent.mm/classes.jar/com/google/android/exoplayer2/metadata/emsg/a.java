package com.google.android.exoplayer2.metadata.emsg;

import com.google.android.exoplayer2.i.j;
import com.google.android.exoplayer2.metadata.Metadata;
import com.google.android.exoplayer2.metadata.Metadata.Entry;
import com.google.android.exoplayer2.metadata.d;
import java.nio.ByteBuffer;
import java.util.Arrays;

public final class a
  implements com.google.android.exoplayer2.metadata.a
{
  public final Metadata a(d paramd)
  {
    Object localObject = paramd.ayD;
    paramd = ((ByteBuffer)localObject).array();
    int i = ((ByteBuffer)localObject).limit();
    localObject = new j(paramd, i);
    String str1 = ((j)localObject).oj();
    String str2 = ((j)localObject).oj();
    long l = ((j)localObject).bp();
    ((j)localObject).dB(4);
    return new Metadata(new Metadata.Entry[] { new EventMessage(str1, str2, ((j)localObject).bp() * 1000L / l, ((j)localObject).bp(), Arrays.copyOfRange(paramd, ((j)localObject).position, i)) });
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.google.android.exoplayer2.metadata.emsg.a
 * JD-Core Version:    0.7.0.1
 */