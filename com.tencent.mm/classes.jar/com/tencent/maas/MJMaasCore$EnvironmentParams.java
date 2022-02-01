package com.tencent.maas;

public class MJMaasCore$EnvironmentParams
{
  private final String cachesDirectory;
  private final boolean createDirectoryIfNotExist;
  private final String localeID;
  private final String persistentDirectory;
  private final String resourcesDirectory;
  private final String temporaryDirectory;
  
  public MJMaasCore$EnvironmentParams(String paramString1, String paramString2, String paramString3, String paramString4, boolean paramBoolean, String paramString5)
  {
    this.persistentDirectory = paramString1;
    this.cachesDirectory = paramString2;
    this.temporaryDirectory = paramString3;
    this.resourcesDirectory = paramString4;
    this.createDirectoryIfNotExist = paramBoolean;
    this.localeID = paramString5;
  }
  
  public String getCachesDirectory()
  {
    return this.cachesDirectory;
  }
  
  public String getLocaleID()
  {
    return this.localeID;
  }
  
  public String getPersistentDirectory()
  {
    return this.persistentDirectory;
  }
  
  public String getResourcesDirectory()
  {
    return this.resourcesDirectory;
  }
  
  public String getTemporaryDirectory()
  {
    return this.temporaryDirectory;
  }
  
  public boolean isCreateDirectoryIfNotExist()
  {
    return this.createDirectoryIfNotExist;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.maas.MJMaasCore.EnvironmentParams
 * JD-Core Version:    0.7.0.1
 */