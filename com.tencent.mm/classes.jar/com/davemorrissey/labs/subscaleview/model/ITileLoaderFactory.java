package com.davemorrissey.labs.subscaleview.model;

import com.davemorrissey.labs.subscaleview.decoder.ImageRegionDecoder;
import com.davemorrissey.labs.subscaleview.view.SubsamplingScaleImageView;

public abstract interface ITileLoaderFactory
{
  public abstract ILoadable newInstance(SubsamplingScaleImageView paramSubsamplingScaleImageView, ImageRegionDecoder paramImageRegionDecoder, Tile paramTile);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes10.jar
 * Qualified Name:     com.davemorrissey.labs.subscaleview.model.ITileLoaderFactory
 * JD-Core Version:    0.7.0.1
 */