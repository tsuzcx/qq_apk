package com.google.d;

import java.io.IOException;

public class bk
  extends IOException
{
  public ce dST = null;
  
  public bk(IOException paramIOException)
  {
    super(paramIOException.getMessage(), paramIOException);
  }
  
  public bk(String paramString)
  {
    super(paramString);
  }
  
  static bk aij()
  {
    return new bk("While parsing a protocol message, the input ended unexpectedly in the middle of a field.  This could mean either that the input has been truncated or that an embedded message misreported its own length.");
  }
  
  static bk aik()
  {
    return new bk("CodedInputStream encountered an embedded string or message which claimed to have negative size.");
  }
  
  static bk ail()
  {
    return new bk("CodedInputStream encountered a malformed varint.");
  }
  
  static bk aim()
  {
    return new bk("Protocol message contained an invalid tag (zero).");
  }
  
  static bk ain()
  {
    return new bk("Protocol message end-group tag did not match expected tag.");
  }
  
  static a aio()
  {
    return new a("Protocol message tag had invalid wire type.");
  }
  
  static bk aip()
  {
    return new bk("Protocol message had too many levels of nesting.  May be malicious.  Use CodedInputStream.setRecursionLimit() to increase the depth limit.");
  }
  
  static bk aiq()
  {
    return new bk("Protocol message was too large.  May be malicious.  Use CodedInputStream.setSizeLimit() to increase the size limit.");
  }
  
  static bk air()
  {
    return new bk("Failed to parse the message.");
  }
  
  static bk ais()
  {
    return new bk("Protocol message had invalid UTF-8.");
  }
  
  public final IOException aii()
  {
    if ((getCause() instanceof IOException)) {
      return (IOException)getCause();
    }
    return this;
  }
  
  public static final class a
    extends bk
  {
    public a(String paramString)
    {
      super();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes11.jar
 * Qualified Name:     com.google.d.bk
 * JD-Core Version:    0.7.0.1
 */