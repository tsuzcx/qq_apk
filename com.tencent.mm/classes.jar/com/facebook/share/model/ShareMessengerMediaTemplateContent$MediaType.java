package com.facebook.share.model;

import com.tencent.matrix.trace.core.AppMethodBeat;

public enum ShareMessengerMediaTemplateContent$MediaType
{
  static
  {
    AppMethodBeat.i(8511);
    IMAGE = new MediaType("IMAGE", 0);
    VIDEO = new MediaType("VIDEO", 1);
    $VALUES = new MediaType[] { IMAGE, VIDEO };
    AppMethodBeat.o(8511);
  }
  
  private ShareMessengerMediaTemplateContent$MediaType() {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.facebook.share.model.ShareMessengerMediaTemplateContent.MediaType
 * JD-Core Version:    0.7.0.1
 */