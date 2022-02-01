package com.facebook.share.model;

import com.tencent.matrix.trace.core.AppMethodBeat;

public enum ShareMedia$Type
{
  static
  {
    AppMethodBeat.i(8457);
    PHOTO = new Type("PHOTO", 0);
    VIDEO = new Type("VIDEO", 1);
    $VALUES = new Type[] { PHOTO, VIDEO };
    AppMethodBeat.o(8457);
  }
  
  private ShareMedia$Type() {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.facebook.share.model.ShareMedia.Type
 * JD-Core Version:    0.7.0.1
 */