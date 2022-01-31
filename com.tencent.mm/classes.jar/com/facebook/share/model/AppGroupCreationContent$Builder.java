package com.facebook.share.model;

import com.tencent.matrix.trace.core.AppMethodBeat;

public class AppGroupCreationContent$Builder
  implements ShareModelBuilder<AppGroupCreationContent, Builder>
{
  private String description;
  private String name;
  private AppGroupCreationContent.AppGroupPrivacy privacy;
  
  public AppGroupCreationContent build()
  {
    AppMethodBeat.i(97327);
    AppGroupCreationContent localAppGroupCreationContent = new AppGroupCreationContent(this, null);
    AppMethodBeat.o(97327);
    return localAppGroupCreationContent;
  }
  
  public Builder readFrom(AppGroupCreationContent paramAppGroupCreationContent)
  {
    AppMethodBeat.i(97328);
    if (paramAppGroupCreationContent == null)
    {
      AppMethodBeat.o(97328);
      return this;
    }
    paramAppGroupCreationContent = setName(paramAppGroupCreationContent.getName()).setDescription(paramAppGroupCreationContent.getDescription()).setAppGroupPrivacy(paramAppGroupCreationContent.getAppGroupPrivacy());
    AppMethodBeat.o(97328);
    return paramAppGroupCreationContent;
  }
  
  public Builder setAppGroupPrivacy(AppGroupCreationContent.AppGroupPrivacy paramAppGroupPrivacy)
  {
    this.privacy = paramAppGroupPrivacy;
    return this;
  }
  
  public Builder setDescription(String paramString)
  {
    this.description = paramString;
    return this;
  }
  
  public Builder setName(String paramString)
  {
    this.name = paramString;
    return this;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.facebook.share.model.AppGroupCreationContent.Builder
 * JD-Core Version:    0.7.0.1
 */