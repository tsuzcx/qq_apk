package com.facebook.share.internal;

import com.facebook.FacebookException;
import com.facebook.internal.Utility;
import com.facebook.share.model.ShareLinkContent;
import com.facebook.share.model.ShareMediaContent;
import com.facebook.share.model.SharePhoto;
import com.facebook.share.model.ShareVideoContent;
import com.tencent.matrix.trace.core.AppMethodBeat;

class ShareContentValidation$ApiValidator
  extends ShareContentValidation.Validator
{
  private ShareContentValidation$ApiValidator()
  {
    super(null);
  }
  
  public void validate(ShareLinkContent paramShareLinkContent)
  {
    AppMethodBeat.i(97169);
    if (!Utility.isNullOrEmpty(paramShareLinkContent.getQuote()))
    {
      paramShareLinkContent = new FacebookException("Cannot share link content with quote using the share api");
      AppMethodBeat.o(97169);
      throw paramShareLinkContent;
    }
    AppMethodBeat.o(97169);
  }
  
  public void validate(ShareMediaContent paramShareMediaContent)
  {
    AppMethodBeat.i(97168);
    paramShareMediaContent = new FacebookException("Cannot share ShareMediaContent using the share api");
    AppMethodBeat.o(97168);
    throw paramShareMediaContent;
  }
  
  public void validate(SharePhoto paramSharePhoto)
  {
    AppMethodBeat.i(97166);
    ShareContentValidation.access$600(paramSharePhoto, this);
    AppMethodBeat.o(97166);
  }
  
  public void validate(ShareVideoContent paramShareVideoContent)
  {
    AppMethodBeat.i(97167);
    if (!Utility.isNullOrEmpty(paramShareVideoContent.getPlaceId()))
    {
      paramShareVideoContent = new FacebookException("Cannot share video content with place IDs using the share api");
      AppMethodBeat.o(97167);
      throw paramShareVideoContent;
    }
    if (!Utility.isNullOrEmpty(paramShareVideoContent.getPeopleIds()))
    {
      paramShareVideoContent = new FacebookException("Cannot share video content with people IDs using the share api");
      AppMethodBeat.o(97167);
      throw paramShareVideoContent;
    }
    if (!Utility.isNullOrEmpty(paramShareVideoContent.getRef()))
    {
      paramShareVideoContent = new FacebookException("Cannot share video content with referrer URL using the share api");
      AppMethodBeat.o(97167);
      throw paramShareVideoContent;
    }
    AppMethodBeat.o(97167);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.facebook.share.internal.ShareContentValidation.ApiValidator
 * JD-Core Version:    0.7.0.1
 */