package com.bumptech.glide.load.b;

import com.bumptech.glide.load.b.b.a.b;
import com.bumptech.glide.load.d;
import com.bumptech.glide.load.i;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.io.File;

final class e<DataType>
  implements a.b
{
  private final d<DataType> aFU;
  private final i aFV;
  private final DataType data;
  
  e(d<DataType> paramd, DataType paramDataType, i parami)
  {
    this.aFU = paramd;
    this.data = paramDataType;
    this.aFV = parami;
  }
  
  public final boolean s(File paramFile)
  {
    AppMethodBeat.i(76931);
    boolean bool = this.aFU.a(this.data, paramFile, this.aFV);
    AppMethodBeat.o(76931);
    return bool;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.bumptech.glide.load.b.e
 * JD-Core Version:    0.7.0.1
 */