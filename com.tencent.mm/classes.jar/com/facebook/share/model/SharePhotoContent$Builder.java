package com.facebook.share.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class SharePhotoContent$Builder
  extends ShareContent.Builder<SharePhotoContent, Builder>
{
  private final List<SharePhoto> photos;
  
  public SharePhotoContent$Builder()
  {
    AppMethodBeat.i(97569);
    this.photos = new ArrayList();
    AppMethodBeat.o(97569);
  }
  
  public Builder addPhoto(SharePhoto paramSharePhoto)
  {
    AppMethodBeat.i(97570);
    if (paramSharePhoto != null) {
      this.photos.add(new SharePhoto.Builder().readFrom(paramSharePhoto).build());
    }
    AppMethodBeat.o(97570);
    return this;
  }
  
  public Builder addPhotos(List<SharePhoto> paramList)
  {
    AppMethodBeat.i(97571);
    if (paramList != null)
    {
      paramList = paramList.iterator();
      while (paramList.hasNext()) {
        addPhoto((SharePhoto)paramList.next());
      }
    }
    AppMethodBeat.o(97571);
    return this;
  }
  
  public SharePhotoContent build()
  {
    AppMethodBeat.i(97572);
    SharePhotoContent localSharePhotoContent = new SharePhotoContent(this, null);
    AppMethodBeat.o(97572);
    return localSharePhotoContent;
  }
  
  public Builder readFrom(SharePhotoContent paramSharePhotoContent)
  {
    AppMethodBeat.i(97573);
    if (paramSharePhotoContent == null)
    {
      AppMethodBeat.o(97573);
      return this;
    }
    paramSharePhotoContent = ((Builder)super.readFrom(paramSharePhotoContent)).addPhotos(paramSharePhotoContent.getPhotos());
    AppMethodBeat.o(97573);
    return paramSharePhotoContent;
  }
  
  public Builder setPhotos(List<SharePhoto> paramList)
  {
    AppMethodBeat.i(97574);
    this.photos.clear();
    addPhotos(paramList);
    AppMethodBeat.o(97574);
    return this;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.facebook.share.model.SharePhotoContent.Builder
 * JD-Core Version:    0.7.0.1
 */