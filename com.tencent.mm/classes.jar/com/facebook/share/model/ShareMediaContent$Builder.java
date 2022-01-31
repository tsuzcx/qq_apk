package com.facebook.share.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class ShareMediaContent$Builder
  extends ShareContent.Builder<ShareMediaContent, Builder>
{
  private final List<ShareMedia> media;
  
  public ShareMediaContent$Builder()
  {
    AppMethodBeat.i(97437);
    this.media = new ArrayList();
    AppMethodBeat.o(97437);
  }
  
  public Builder addMedia(List<ShareMedia> paramList)
  {
    AppMethodBeat.i(97439);
    if (paramList != null)
    {
      paramList = paramList.iterator();
      while (paramList.hasNext()) {
        addMedium((ShareMedia)paramList.next());
      }
    }
    AppMethodBeat.o(97439);
    return this;
  }
  
  public Builder addMedium(ShareMedia paramShareMedia)
  {
    AppMethodBeat.i(97438);
    if (paramShareMedia != null) {
      if (!(paramShareMedia instanceof SharePhoto)) {
        break label52;
      }
    }
    for (paramShareMedia = new SharePhoto.Builder().readFrom((SharePhoto)paramShareMedia).build();; paramShareMedia = new ShareVideo.Builder().readFrom((ShareVideo)paramShareMedia).build())
    {
      this.media.add(paramShareMedia);
      AppMethodBeat.o(97438);
      return this;
      label52:
      if (!(paramShareMedia instanceof ShareVideo)) {
        break;
      }
    }
    paramShareMedia = new IllegalArgumentException("medium must be either a SharePhoto or ShareVideo");
    AppMethodBeat.o(97438);
    throw paramShareMedia;
  }
  
  public ShareMediaContent build()
  {
    AppMethodBeat.i(97440);
    ShareMediaContent localShareMediaContent = new ShareMediaContent(this, null);
    AppMethodBeat.o(97440);
    return localShareMediaContent;
  }
  
  public Builder readFrom(ShareMediaContent paramShareMediaContent)
  {
    AppMethodBeat.i(97441);
    if (paramShareMediaContent == null)
    {
      AppMethodBeat.o(97441);
      return this;
    }
    paramShareMediaContent = ((Builder)super.readFrom(paramShareMediaContent)).addMedia(paramShareMediaContent.getMedia());
    AppMethodBeat.o(97441);
    return paramShareMediaContent;
  }
  
  public Builder setMedia(List<ShareMedia> paramList)
  {
    AppMethodBeat.i(97442);
    this.media.clear();
    addMedia(paramList);
    AppMethodBeat.o(97442);
    return this;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.facebook.share.model.ShareMediaContent.Builder
 * JD-Core Version:    0.7.0.1
 */