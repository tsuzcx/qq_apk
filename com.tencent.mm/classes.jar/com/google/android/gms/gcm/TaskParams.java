package com.google.android.gms.gcm;

import android.net.Uri;
import android.os.Bundle;
import java.util.List;

public class TaskParams
{
  private final Bundle extras;
  private final String tag;
  private final List<Uri> zzz;
  
  public TaskParams(String paramString)
  {
    this(paramString, null, null);
  }
  
  public TaskParams(String paramString, Bundle paramBundle)
  {
    this(paramString, paramBundle, null);
  }
  
  public TaskParams(String paramString, Bundle paramBundle, List<Uri> paramList)
  {
    this.tag = paramString;
    this.extras = paramBundle;
    this.zzz = paramList;
  }
  
  public Bundle getExtras()
  {
    return this.extras;
  }
  
  public String getTag()
  {
    return this.tag;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.google.android.gms.gcm.TaskParams
 * JD-Core Version:    0.7.0.1
 */