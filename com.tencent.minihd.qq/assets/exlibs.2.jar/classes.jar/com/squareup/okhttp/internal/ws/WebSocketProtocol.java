package com.squareup.okhttp.internal.ws;

public final class WebSocketProtocol
{
  public static final String ACCEPT_MAGIC = "258EAFA5-E914-47DA-95CA-C5AB0DC85B11";
  static final int B0_FLAG_FIN = 128;
  static final int B0_FLAG_RSV1 = 64;
  static final int B0_FLAG_RSV2 = 32;
  static final int B0_FLAG_RSV3 = 16;
  static final int B0_MASK_OPCODE = 15;
  static final int B1_FLAG_MASK = 128;
  static final int B1_MASK_LENGTH = 127;
  static final int OPCODE_BINARY = 2;
  static final int OPCODE_CONTINUATION = 0;
  static final int OPCODE_CONTROL_CLOSE = 8;
  static final int OPCODE_CONTROL_PING = 9;
  static final int OPCODE_CONTROL_PONG = 10;
  static final int OPCODE_FLAG_CONTROL = 8;
  static final int OPCODE_TEXT = 1;
  static final long PAYLOAD_BYTE_MAX = 125L;
  static final int PAYLOAD_LONG = 127;
  static final int PAYLOAD_SHORT = 126;
  static final long PAYLOAD_SHORT_MAX = 65535L;
  
  private WebSocketProtocol()
  {
    throw new AssertionError("No instances.");
  }
  
  static void toggleMask(byte[] paramArrayOfByte1, long paramLong1, byte[] paramArrayOfByte2, long paramLong2)
  {
    int j = paramArrayOfByte2.length;
    int i = 0;
    while (i < paramLong1)
    {
      int k = (int)(paramLong2 % j);
      paramArrayOfByte1[i] = ((byte)(paramArrayOfByte1[i] ^ paramArrayOfByte2[k]));
      i += 1;
      paramLong2 += 1L;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.2.jar\classes.jar
 * Qualified Name:     com.squareup.okhttp.internal.ws.WebSocketProtocol
 * JD-Core Version:    0.7.0.1
 */