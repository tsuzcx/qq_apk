package com.tencent.mapsdk.engine.jni;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.Arrays;

public class JNIEvent
{
  public byte[] data;
  public Object extra;
  public int id;
  public String name;
  
  public String toString()
  {
    AppMethodBeat.i(221099);
    String str = "JNIEvent{id=" + this.id + ", name='" + this.name + '\'' + ", data=" + Arrays.toString(this.data) + ", extra=" + this.extra + '}';
    AppMethodBeat.o(221099);
    return str;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mapsdk.engine.jni.JNIEvent
 * JD-Core Version:    0.7.0.1
 */