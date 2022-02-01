package com.facebook.internal;

import android.content.Context;
import android.net.Uri;
import android.net.Uri.Builder;
import com.facebook.FacebookSdk;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.Locale;

public class ImageRequest
{
  private static final String HEIGHT_PARAM = "height";
  private static final String MIGRATION_PARAM = "migration_overrides";
  private static final String MIGRATION_VALUE = "{october_2012:true}";
  private static final String PATH = "%s/%s/picture";
  public static final int UNSPECIFIED_DIMENSION = 0;
  private static final String WIDTH_PARAM = "width";
  private boolean allowCachedRedirects;
  private Callback callback;
  private Object callerTag;
  private Context context;
  private Uri imageUri;
  
  private ImageRequest(Builder paramBuilder)
  {
    AppMethodBeat.i(17827);
    this.context = paramBuilder.context;
    this.imageUri = paramBuilder.imageUrl;
    this.callback = paramBuilder.callback;
    this.allowCachedRedirects = paramBuilder.allowCachedRedirects;
    if (paramBuilder.callerTag == null) {}
    for (paramBuilder = new Object();; paramBuilder = paramBuilder.callerTag)
    {
      this.callerTag = paramBuilder;
      AppMethodBeat.o(17827);
      return;
    }
  }
  
  public static Uri getProfilePictureUri(String paramString, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(17826);
    Validate.notNullOrEmpty(paramString, "userId");
    paramInt1 = Math.max(paramInt1, 0);
    paramInt2 = Math.max(paramInt2, 0);
    if ((paramInt1 == 0) && (paramInt2 == 0))
    {
      paramString = new IllegalArgumentException("Either width or height must be greater than 0");
      AppMethodBeat.o(17826);
      throw paramString;
    }
    paramString = Uri.parse(ServerProtocol.getGraphUrlBase()).buildUpon().path(String.format(Locale.US, "%s/%s/picture", new Object[] { FacebookSdk.getGraphApiVersion(), paramString }));
    if (paramInt2 != 0) {
      paramString.appendQueryParameter("height", String.valueOf(paramInt2));
    }
    if (paramInt1 != 0) {
      paramString.appendQueryParameter("width", String.valueOf(paramInt1));
    }
    paramString.appendQueryParameter("migration_overrides", "{october_2012:true}");
    paramString = paramString.build();
    AppMethodBeat.o(17826);
    return paramString;
  }
  
  public Callback getCallback()
  {
    return this.callback;
  }
  
  public Object getCallerTag()
  {
    return this.callerTag;
  }
  
  public Context getContext()
  {
    return this.context;
  }
  
  public Uri getImageUri()
  {
    return this.imageUri;
  }
  
  public boolean isCachedRedirectAllowed()
  {
    return this.allowCachedRedirects;
  }
  
  public static class Builder
  {
    private boolean allowCachedRedirects;
    private ImageRequest.Callback callback;
    private Object callerTag;
    private Context context;
    private Uri imageUrl;
    
    public Builder(Context paramContext, Uri paramUri)
    {
      AppMethodBeat.i(17824);
      Validate.notNull(paramUri, "imageUri");
      this.context = paramContext;
      this.imageUrl = paramUri;
      AppMethodBeat.o(17824);
    }
    
    public ImageRequest build()
    {
      AppMethodBeat.i(17825);
      ImageRequest localImageRequest = new ImageRequest(this, null);
      AppMethodBeat.o(17825);
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
  
  public static abstract interface Callback
  {
    public abstract void onCompleted(ImageResponse paramImageResponse);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.facebook.internal.ImageRequest
 * JD-Core Version:    0.7.0.1
 */