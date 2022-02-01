package com.tencent.image;

import java.io.File;
import java.io.IOException;
import java.net.URL;

public class LocaleFileDownloader
  extends ProtocolDownloader.Adapter
{
  public boolean hasDiskFile(DownloadParams paramDownloadParams)
  {
    return new File(paramDownloadParams.url.getFile()).exists();
  }
  
  public File loadImageFile(DownloadParams paramDownloadParams, URLDrawableHandler paramURLDrawableHandler)
    throws IOException
  {
    paramURLDrawableHandler = new File(paramDownloadParams.url.getFile());
    if (paramURLDrawableHandler.exists()) {
      return paramURLDrawableHandler;
    }
    throw new IOException("File not Found. url: " + paramDownloadParams.url);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\classes.jar
 * Qualified Name:     com.tencent.image.LocaleFileDownloader
 * JD-Core Version:    0.7.0.1
 */