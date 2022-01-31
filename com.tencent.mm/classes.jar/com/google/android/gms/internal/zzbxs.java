package com.google.android.gms.internal;

import java.io.IOException;

public class zzbxs
  extends IOException
{
  public zzbxs(String paramString)
  {
    super(paramString);
  }
  
  static zzbxs zzaeK()
  {
    return new zzbxs("While parsing a protocol message, the input ended unexpectedly in the middle of a field.  This could mean either than the input has been truncated or that an embedded message misreported its own length.");
  }
  
  static zzbxs zzaeL()
  {
    return new zzbxs("CodedInputStream encountered an embedded string or message which claimed to have negative size.");
  }
  
  static zzbxs zzaeM()
  {
    return new zzbxs("CodedInputStream encountered a malformed varint.");
  }
  
  static zzbxs zzaeN()
  {
    return new zzbxs("Protocol message contained an invalid tag (zero).");
  }
  
  static zzbxs zzaeO()
  {
    return new zzbxs("Protocol message end-group tag did not match expected tag.");
  }
  
  static zzbxs zzaeP()
  {
    return new zzbxs("Protocol message tag had invalid wire type.");
  }
  
  static zzbxs zzaeQ()
  {
    return new zzbxs("Protocol message had too many levels of nesting.  May be malicious.  Use CodedInputStream.setRecursionLimit() to increase the depth limit.");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.google.android.gms.internal.zzbxs
 * JD-Core Version:    0.7.0.1
 */