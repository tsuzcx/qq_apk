package com.facebook.share.model;

import com.facebook.share.ShareBuilder;

public abstract interface ShareModelBuilder<P extends ShareModel, E extends ShareModelBuilder>
  extends ShareBuilder<P, E>
{
  public abstract E readFrom(P paramP);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.facebook.share.model.ShareModelBuilder
 * JD-Core Version:    0.7.0.1
 */