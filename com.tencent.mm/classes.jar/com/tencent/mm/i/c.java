package com.tencent.mm.i;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class c
{
  public String cBO;
  public int field_finishedLength;
  public boolean field_isUploadTask = false;
  public boolean field_mtlnotify;
  public int field_status;
  public int field_toltalLength;
  
  public final String toString()
  {
    AppMethodBeat.i(128589);
    String str = String.format("id:%s total:%d finLen:%d status:%d,mtl:%b, upload:%b", new Object[] { this.cBO, Integer.valueOf(this.field_toltalLength), Integer.valueOf(this.field_finishedLength), Integer.valueOf(this.field_status), Boolean.valueOf(this.field_mtlnotify), Boolean.valueOf(this.field_isUploadTask) });
    AppMethodBeat.o(128589);
    return str;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.i.c
 * JD-Core Version:    0.7.0.1
 */