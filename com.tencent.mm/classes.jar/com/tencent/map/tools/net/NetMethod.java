package com.tencent.map.tools.net;

import com.tencent.matrix.trace.core.AppMethodBeat;

public enum NetMethod
{
  static
  {
    AppMethodBeat.i(172927);
    POST = new NetMethod("POST", 0);
    GET = new NetMethod("GET", 1);
    URL = new NetMethod("URL", 2);
    $VALUES = new NetMethod[] { POST, GET, URL };
    AppMethodBeat.o(172927);
  }
  
  private NetMethod() {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.map.tools.net.NetMethod
 * JD-Core Version:    0.7.0.1
 */