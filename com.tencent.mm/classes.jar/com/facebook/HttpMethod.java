package com.facebook;

import com.tencent.matrix.trace.core.AppMethodBeat;

public enum HttpMethod
{
  static
  {
    AppMethodBeat.i(17209);
    GET = new HttpMethod("GET", 0);
    POST = new HttpMethod("POST", 1);
    DELETE = new HttpMethod("DELETE", 2);
    $VALUES = new HttpMethod[] { GET, POST, DELETE };
    AppMethodBeat.o(17209);
  }
  
  private HttpMethod() {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.facebook.HttpMethod
 * JD-Core Version:    0.7.0.1
 */