package com.bumptech.glide.c.b;

import com.bumptech.glide.c.b.b.a.b;
import com.bumptech.glide.c.j;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.io.File;

final class d<DataType>
  implements a.b
{
  private final com.bumptech.glide.c.d<DataType> aGc;
  private final j aGd;
  private final DataType data;
  
  d(com.bumptech.glide.c.d<DataType> paramd, DataType paramDataType, j paramj)
  {
    this.aGc = paramd;
    this.data = paramDataType;
    this.aGd = paramj;
  }
  
  public final boolean s(File paramFile)
  {
    AppMethodBeat.i(76931);
    boolean bool = this.aGc.a(this.data, paramFile, this.aGd);
    AppMethodBeat.o(76931);
    return bool;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.bumptech.glide.c.b.d
 * JD-Core Version:    0.7.0.1
 */