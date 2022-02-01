package com.tencent.maas.instamovie.base.asset;

public class MJAssetInfo
{
  private String Identifier;
  private a identifierType;
  private b mediaType;
  
  public MJAssetInfo(a parama, String paramString, b paramb)
  {
    this.identifierType = parama;
    this.Identifier = paramString;
    this.mediaType = paramb;
  }
  
  public String getIdentifier()
  {
    return this.Identifier;
  }
  
  public a getIdentifierType()
  {
    return this.identifierType;
  }
  
  public int getMJAssetIdentifierType()
  {
    return this.identifierType.value;
  }
  
  public int getMJAssetMediaType()
  {
    return this.mediaType.value;
  }
  
  public b getMediaType()
  {
    return this.mediaType;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.maas.instamovie.base.asset.MJAssetInfo
 * JD-Core Version:    0.7.0.1
 */