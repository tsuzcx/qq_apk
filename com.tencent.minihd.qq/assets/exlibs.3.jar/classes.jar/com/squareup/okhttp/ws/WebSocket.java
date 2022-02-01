package com.squareup.okhttp.ws;

import com.squareup.okhttp.MediaType;
import com.squareup.okhttp.RequestBody;
import java.io.IOException;
import okio.Buffer;

public abstract interface WebSocket
{
  public static final MediaType BINARY = MediaType.parse("application/vnd.okhttp.websocket+binary");
  public static final MediaType TEXT = MediaType.parse("application/vnd.okhttp.websocket+text; charset=utf-8");
  
  public abstract void close(int paramInt, String paramString)
    throws IOException;
  
  public abstract void sendMessage(RequestBody paramRequestBody)
    throws IOException;
  
  public abstract void sendPing(Buffer paramBuffer)
    throws IOException;
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.3.jar\classes.jar
 * Qualified Name:     com.squareup.okhttp.ws.WebSocket
 * JD-Core Version:    0.7.0.1
 */