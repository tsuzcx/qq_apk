package com.google.a;

import java.io.IOException;

public class af
  extends IOException
{
  aw bXr = null;
  
  public af(IOException paramIOException)
  {
    super(paramIOException.getMessage(), paramIOException);
  }
  
  public af(String paramString)
  {
    super(paramString);
  }
  
  static af GG()
  {
    return new af("While parsing a protocol message, the input ended unexpectedly in the middle of a field.  This could mean either that the input has been truncated or that an embedded message misreported its own length.");
  }
  
  static af GH()
  {
    return new af("CodedInputStream encountered an embedded string or message which claimed to have negative size.");
  }
  
  static af GI()
  {
    return new af("CodedInputStream encountered a malformed varint.");
  }
  
  static af GJ()
  {
    return new af("Protocol message contained an invalid tag (zero).");
  }
  
  static af GK()
  {
    return new af("Protocol message end-group tag did not match expected tag.");
  }
  
  static a GL()
  {
    return new a("Protocol message tag had invalid wire type.");
  }
  
  static af GM()
  {
    return new af("Protocol message had too many levels of nesting.  May be malicious.  Use CodedInputStream.setRecursionLimit() to increase the depth limit.");
  }
  
  static af GN()
  {
    return new af("Protocol message had invalid UTF-8.");
  }
  
  public final IOException GF()
  {
    if ((getCause() instanceof IOException)) {
      return (IOException)getCause();
    }
    return this;
  }
  
  public static final class a
    extends af
  {
    public a(String paramString)
    {
      super();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.google.a.af
 * JD-Core Version:    0.7.0.1
 */