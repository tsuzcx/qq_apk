package com.facebook.internal;

import android.content.Context;
import android.net.Uri;
import com.tencent.matrix.trace.core.AppMethodBeat;

public class ImageRequest$Builder
{
  private boolean allowCachedRedirects;
  private ImageRequest.Callback callback;
  private Object callerTag;
  private Context context;
  private Uri imageUrl;
  
  public ImageRequest$Builder(Context paramContext, Uri paramUri)
  {
    AppMethodBeat.i(72388);
    Validate.notNull(paramUri, "imageUri");
    this.context = paramContext;
    this.imageUrl = paramUri;
    AppMethodBeat.o(72388);
  }
  
  public ImageRequest build()
  {
    AppMethodBeat.i(72389);
    ImageRequest localImageRequest = new ImageRequest(this, null);
    AppMethodBeat.o(72389);
    return localImageRequest;
  }
  
  public Builder setAllowCachedRedirects(boolean paramBoolean)
  {
    this.allowCachedRedirects = paramBoolean;
    return this;
  }
  
  public Builder setCallback(ImageRequest.Callback paramCallback)
  {
    this.callback = paramCallback;
    return this;
  }
  
  public Builder setCallerTag(Object paramObject)
  {
    this.callerTag = paramObject;
    return this;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.facebook.internal.ImageRequest.Builder
 * JD-Core Version:    0.7.0.1
 */