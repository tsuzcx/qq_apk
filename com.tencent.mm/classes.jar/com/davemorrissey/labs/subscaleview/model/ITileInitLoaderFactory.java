package com.davemorrissey.labs.subscaleview.model;

import android.content.Context;
import android.net.Uri;
import com.davemorrissey.labs.subscaleview.decoder.DecoderFactory;
import com.davemorrissey.labs.subscaleview.decoder.ImageRegionDecoder;
import com.davemorrissey.labs.subscaleview.view.SubsamplingScaleImageView;

public abstract interface ITileInitLoaderFactory
{
  public abstract ILoadable newInstance(SubsamplingScaleImageView paramSubsamplingScaleImageView, Context paramContext, DecoderFactory<? extends ImageRegionDecoder> paramDecoderFactory, Uri paramUri);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes10.jar
 * Qualified Name:     com.davemorrissey.labs.subscaleview.model.ITileInitLoaderFactory
 * JD-Core Version:    0.7.0.1
 */