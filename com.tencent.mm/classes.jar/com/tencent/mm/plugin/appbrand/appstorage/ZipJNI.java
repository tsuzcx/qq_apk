package com.tencent.mm.plugin.appbrand.appstorage;

public class ZipJNI
{
  public static final int ERR_ILLEGAL_PATH = 1;
  public static final int ERR_ZIP_FILE_NOT_FOUND = 2;
  public static final int UNZ_BADZIPFILE = -103;
  public static final int UNZ_CRCERROR = -105;
  public static final int UNZ_END_OF_LIST_OF_FILE = -100;
  public static final int UNZ_ERRNO = -1;
  public static final int UNZ_ERR_OPEN_WRITE = -106;
  public static final int UNZ_INTERNALERROR = -104;
  public static final int UNZ_OK = 0;
  public static final int UNZ_PARAMERROR = -102;
  
  public static native int unzip(String paramString1, String paramString2, String paramString3);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.appstorage.ZipJNI
 * JD-Core Version:    0.7.0.1
 */