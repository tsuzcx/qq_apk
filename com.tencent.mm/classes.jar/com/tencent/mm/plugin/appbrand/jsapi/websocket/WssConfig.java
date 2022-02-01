package com.tencent.mm.plugin.appbrand.jsapi.websocket;

public class WssConfig
{
  int bz_type;
  int handshake_timeout;
  boolean per_message_deflate;
  int pong_timeout;
  boolean skip_domain_check;
  boolean tcp_no_delay;
  
  public WssConfig(int paramInt1, int paramInt2, boolean paramBoolean1, boolean paramBoolean2, int paramInt3, boolean paramBoolean3)
  {
    this.pong_timeout = paramInt1;
    this.handshake_timeout = paramInt2;
    this.tcp_no_delay = paramBoolean1;
    this.skip_domain_check = paramBoolean2;
    this.bz_type = paramInt3;
    this.per_message_deflate = paramBoolean3;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.websocket.WssConfig
 * JD-Core Version:    0.7.0.1
 */