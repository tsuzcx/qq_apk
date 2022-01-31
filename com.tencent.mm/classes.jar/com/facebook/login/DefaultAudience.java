package com.facebook.login;

import com.tencent.matrix.trace.core.AppMethodBeat;

public enum DefaultAudience
{
  private final String nativeProtocolAudience;
  
  static
  {
    AppMethodBeat.i(72613);
    NONE = new DefaultAudience("NONE", 0, null);
    ONLY_ME = new DefaultAudience("ONLY_ME", 1, "only_me");
    FRIENDS = new DefaultAudience("FRIENDS", 2, "friends");
    EVERYONE = new DefaultAudience("EVERYONE", 3, "everyone");
    $VALUES = new DefaultAudience[] { NONE, ONLY_ME, FRIENDS, EVERYONE };
    AppMethodBeat.o(72613);
  }
  
  private DefaultAudience(String paramString)
  {
    this.nativeProtocolAudience = paramString;
  }
  
  public final String getNativeProtocolAudience()
  {
    return this.nativeProtocolAudience;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.facebook.login.DefaultAudience
 * JD-Core Version:    0.7.0.1
 */