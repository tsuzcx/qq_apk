package com.facebook.share.model;

import android.os.Parcel;
import com.tencent.matrix.trace.core.AppMethodBeat;

public class ShareHashtag$Builder
  implements ShareModelBuilder<ShareHashtag, Builder>
{
  private String hashtag;
  
  public ShareHashtag build()
  {
    AppMethodBeat.i(97411);
    ShareHashtag localShareHashtag = new ShareHashtag(this, null);
    AppMethodBeat.o(97411);
    return localShareHashtag;
  }
  
  public String getHashtag()
  {
    return this.hashtag;
  }
  
  Builder readFrom(Parcel paramParcel)
  {
    AppMethodBeat.i(97410);
    paramParcel = readFrom((ShareHashtag)paramParcel.readParcelable(ShareHashtag.class.getClassLoader()));
    AppMethodBeat.o(97410);
    return paramParcel;
  }
  
  public Builder readFrom(ShareHashtag paramShareHashtag)
  {
    AppMethodBeat.i(97409);
    if (paramShareHashtag == null)
    {
      AppMethodBeat.o(97409);
      return this;
    }
    paramShareHashtag = setHashtag(paramShareHashtag.getHashtag());
    AppMethodBeat.o(97409);
    return paramShareHashtag;
  }
  
  public Builder setHashtag(String paramString)
  {
    this.hashtag = paramString;
    return this;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.facebook.share.model.ShareHashtag.Builder
 * JD-Core Version:    0.7.0.1
 */