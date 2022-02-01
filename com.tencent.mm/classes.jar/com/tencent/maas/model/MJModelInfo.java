package com.tencent.maas.model;

public class MJModelInfo
{
  private String modelFilePath;
  private String modelName;
  private String modelVersion;
  
  public MJModelInfo(String paramString1, String paramString2, String paramString3)
  {
    this.modelName = paramString1;
    this.modelFilePath = paramString2;
    this.modelVersion = paramString3;
  }
  
  public String getModelFilePath()
  {
    return this.modelFilePath;
  }
  
  public String getModelName()
  {
    return this.modelName;
  }
  
  public String getModelVersion()
  {
    return this.modelVersion;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.maas.model.MJModelInfo
 * JD-Core Version:    0.7.0.1
 */