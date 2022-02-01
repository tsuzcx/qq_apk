package com.google.b;

import java.io.IOException;

public class bf
  extends IOException
{
  public bw bZj = null;
  
  public bf(IOException paramIOException)
  {
    super(paramIOException.getMessage(), paramIOException);
  }
  
  public bf(String paramString)
  {
    super(paramString);
  }
  
  static bf In()
  {
    return new bf("While parsing a protocol message, the input ended unexpectedly in the middle of a field.  This could mean either that the input has been truncated or that an embedded message misreported its own length.");
  }
  
  static bf Io()
  {
    return new bf("CodedInputStream encountered an embedded string or message which claimed to have negative size.");
  }
  
  static bf Ip()
  {
    return new bf("CodedInputStream encountered a malformed varint.");
  }
  
  static bf Iq()
  {
    return new bf("Protocol message contained an invalid tag (zero).");
  }
  
  static bf Ir()
  {
    return new bf("Protocol message end-group tag did not match expected tag.");
  }
  
  static a Is()
  {
    return new a("Protocol message tag had invalid wire type.");
  }
  
  static bf It()
  {
    return new bf("Protocol message had too many levels of nesting.  May be malicious.  Use CodedInputStream.setRecursionLimit() to increase the depth limit.");
  }
  
  static bf Iu()
  {
    return new bf("Protocol message had invalid UTF-8.");
  }
  
  public final IOException Im()
  {
    if ((getCause() instanceof IOException)) {
      return (IOException)getCause();
    }
    return this;
  }
  
  public static final class a
    extends bf
  {
    public a(String paramString)
    {
      super();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.google.b.bf
 * JD-Core Version:    0.7.0.1
 */