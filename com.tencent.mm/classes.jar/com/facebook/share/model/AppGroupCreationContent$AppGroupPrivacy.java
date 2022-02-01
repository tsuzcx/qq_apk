package com.facebook.share.model;

import com.tencent.matrix.trace.core.AppMethodBeat;

public enum AppGroupCreationContent$AppGroupPrivacy
{
  static
  {
    AppMethodBeat.i(8350);
    Open = new AppGroupPrivacy("Open", 0);
    Closed = new AppGroupPrivacy("Closed", 1);
    $VALUES = new AppGroupPrivacy[] { Open, Closed };
    AppMethodBeat.o(8350);
  }
  
  private AppGroupCreationContent$AppGroupPrivacy() {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.facebook.share.model.AppGroupCreationContent.AppGroupPrivacy
 * JD-Core Version:    0.7.0.1
 */