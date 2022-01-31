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
  private ImageRequest.Callback callback;
  private Object callerTag;
  private Context context;
  private Uri imageUri;
  
  private ImageRequest(ImageRequest.Builder paramBuilder)
  {
    AppMethodBeat.i(72391);
    this.context = ImageRequest.Builder.access$000(paramBuilder);
    this.imageUri = ImageRequest.Builder.access$100(paramBuilder);
    this.callback = ImageRequest.Builder.access$200(paramBuilder);
    this.allowCachedRedirects = ImageRequest.Builder.access$300(paramBuilder);
    if (ImageRequest.Builder.access$400(paramBuilder) == null) {}
    for (paramBuilder = new Object();; paramBuilder = ImageRequest.Builder.access$400(paramBuilder))
    {
      this.callerTag = paramBuilder;
      AppMethodBeat.o(72391);
      return;
    }
  }
  
  public static Uri getProfilePictureUri(String paramString, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(72390);
    Validate.notNullOrEmpty(paramString, "userId");
    paramInt1 = Math.max(paramInt1, 0);
    paramInt2 = Math.max(paramInt2, 0);
    if ((paramInt1 == 0) && (paramInt2 == 0))
    {
      paramString = new IllegalArgumentException("Either width or height must be greater than 0");
      AppMethodBeat.o(72390);
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
    AppMethodBeat.o(72390);
    return paramString;
  }
  
  public ImageRequest.Callback getCallback()
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
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.facebook.internal.ImageRequest
 * JD-Core Version:    0.7.0.1
 */