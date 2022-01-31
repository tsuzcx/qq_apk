package com.google.a.a;

import java.io.IOException;

public final class d
  extends IOException
{
  private d(String paramString)
  {
    super(paramString);
  }
  
  static d sq()
  {
    return new d("While parsing a protocol message, the input ended unexpectedly in the middle of a field.  This could mean either than the input has been truncated or that an embedded message misreported its own length.");
  }
  
  static d sr()
  {
    return new d("CodedInputStream encountered an embedded string or message which claimed to have negative size.");
  }
  
  static d ss()
  {
    return new d("CodedInputStream encountered a malformed varint.");
  }
  
  static d st()
  {
    return new d("Protocol message contained an invalid tag (zero).");
  }
  
  static d su()
  {
    return new d("Protocol message end-group tag did not match expected tag.");
  }
  
  static d sv()
  {
    return new d("Protocol message tag had invalid wire type.");
  }
  
  static d sw()
  {
    return new d("Protocol message had too many levels of nesting.  May be malicious.  Use CodedInputStream.setRecursionLimit() to increase the depth limit.");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.google.a.a.d
 * JD-Core Version:    0.7.0.1
 */