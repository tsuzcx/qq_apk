package com.facebook.share.model;

import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Parcel;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public final class SharePhoto$Builder
  extends ShareMedia.Builder<SharePhoto, Builder>
{
  private Bitmap bitmap;
  private String caption;
  private Uri imageUrl;
  private boolean userGenerated;
  
  static List<SharePhoto> readPhotoListFrom(Parcel paramParcel)
  {
    AppMethodBeat.i(97558);
    Object localObject = readListFrom(paramParcel);
    paramParcel = new ArrayList();
    localObject = ((List)localObject).iterator();
    while (((Iterator)localObject).hasNext())
    {
      ShareMedia localShareMedia = (ShareMedia)((Iterator)localObject).next();
      if ((localShareMedia instanceof SharePhoto)) {
        paramParcel.add((SharePhoto)localShareMedia);
      }
    }
    AppMethodBeat.o(97558);
    return paramParcel;
  }
  
  static void writePhotoListTo(Parcel paramParcel, int paramInt, List<SharePhoto> paramList)
  {
    AppMethodBeat.i(97557);
    ShareMedia[] arrayOfShareMedia = new ShareMedia[paramList.size()];
    int i = 0;
    while (i < paramList.size())
    {
      arrayOfShareMedia[i] = ((ShareMedia)paramList.get(i));
      i += 1;
    }
    paramParcel.writeParcelableArray(arrayOfShareMedia, paramInt);
    AppMethodBeat.o(97557);
  }
  
  public final SharePhoto build()
  {
    AppMethodBeat.i(97554);
    SharePhoto localSharePhoto = new SharePhoto(this, null);
    AppMethodBeat.o(97554);
    return localSharePhoto;
  }
  
  final Bitmap getBitmap()
  {
    return this.bitmap;
  }
  
  final Uri getImageUrl()
  {
    return this.imageUrl;
  }
  
  final Builder readFrom(Parcel paramParcel)
  {
    AppMethodBeat.i(97556);
    paramParcel = readFrom((SharePhoto)paramParcel.readParcelable(SharePhoto.class.getClassLoader()));
    AppMethodBeat.o(97556);
    return paramParcel;
  }
  
  public final Builder readFrom(SharePhoto paramSharePhoto)
  {
    AppMethodBeat.i(97555);
    if (paramSharePhoto == null)
    {
      AppMethodBeat.o(97555);
      return this;
    }
    paramSharePhoto = ((Builder)super.readFrom(paramSharePhoto)).setBitmap(paramSharePhoto.getBitmap()).setImageUrl(paramSharePhoto.getImageUrl()).setUserGenerated(paramSharePhoto.getUserGenerated()).setCaption(paramSharePhoto.getCaption());
    AppMethodBeat.o(97555);
    return paramSharePhoto;
  }
  
  public final Builder setBitmap(Bitmap paramBitmap)
  {
    this.bitmap = paramBitmap;
    return this;
  }
  
  public final Builder setCaption(String paramString)
  {
    this.caption = paramString;
    return this;
  }
  
  public final Builder setImageUrl(Uri paramUri)
  {
    this.imageUrl = paramUri;
    return this;
  }
  
  public final Builder setUserGenerated(boolean paramBoolean)
  {
    this.userGenerated = paramBoolean;
    return this;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.facebook.share.model.SharePhoto.Builder
 * JD-Core Version:    0.7.0.1
 */