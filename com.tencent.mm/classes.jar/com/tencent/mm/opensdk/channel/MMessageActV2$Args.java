package com.tencent.mm.opensdk.channel;

import android.os.Bundle;
import com.tencent.matrix.trace.core.AppMethodBeat;

public class MMessageActV2$Args
{
  public static final int INVALID_FLAGS = -1;
  public Bundle bundle;
  public String content;
  public int flags = -1;
  public String targetClassName;
  public String targetPkgName;
  public String token;
  
  public String toString()
  {
    AppMethodBeat.i(128141);
    String str = "targetPkgName:" + this.targetPkgName + ", targetClassName:" + this.targetClassName + ", content:" + this.content + ", flags:" + this.flags + ", bundle:" + this.bundle;
    AppMethodBeat.o(128141);
    return str;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.opensdk.channel.MMessageActV2.Args
 * JD-Core Version:    0.7.0.1
 */