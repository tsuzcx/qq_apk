package com.google.android.gms.tagmanager;

import android.net.Uri;
import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;

class zzcj
{
  private static zzcj zzbHh;
  private volatile String zzbEY;
  private volatile zzcj.zza zzbHi;
  private volatile String zzbHj;
  private volatile String zzbHk;
  
  zzcj()
  {
    clear();
  }
  
  static zzcj zzRd()
  {
    try
    {
      if (zzbHh == null) {
        zzbHh = new zzcj();
      }
      zzcj localzzcj = zzbHh;
      return localzzcj;
    }
    finally {}
  }
  
  private String zzhn(String paramString)
  {
    return paramString.split("&")[0].split("=")[1];
  }
  
  private String zzw(Uri paramUri)
  {
    return paramUri.getQuery().replace("&gtm_debug=x", "");
  }
  
  void clear()
  {
    this.zzbHi = zzcj.zza.zzbHl;
    this.zzbHj = null;
    this.zzbEY = null;
    this.zzbHk = null;
  }
  
  String getContainerId()
  {
    return this.zzbEY;
  }
  
  zzcj.zza zzRe()
  {
    return this.zzbHi;
  }
  
  String zzRf()
  {
    return this.zzbHj;
  }
  
  boolean zzv(Uri paramUri)
  {
    boolean bool = true;
    String str2;
    try
    {
      str2 = URLDecoder.decode(paramUri.toString(), "UTF-8");
      if (!str2.matches("^tagmanager.c.\\S+:\\/\\/preview\\/p\\?id=\\S+&gtm_auth=\\S+&gtm_preview=\\d+(&gtm_debug=x)?$")) {
        break label177;
      }
      str1 = String.valueOf(str2);
      if (str1.length() == 0) {
        break label149;
      }
      str1 = "Container preview url: ".concat(str1);
    }
    catch (UnsupportedEncodingException paramUri)
    {
      for (;;)
      {
        label122:
        bool = false;
        continue;
        label149:
        String str1 = new String("Container preview url: ");
      }
    }
    finally {}
    zzbo.v(str1);
    if (str2.matches(".*?&gtm_debug=x$"))
    {
      this.zzbHi = zzcj.zza.zzbHn;
      this.zzbHk = zzw(paramUri);
      if ((this.zzbHi == zzcj.zza.zzbHm) || (this.zzbHi == zzcj.zza.zzbHn))
      {
        paramUri = String.valueOf("/r?");
        str1 = String.valueOf(this.zzbHk);
        if (str1.length() == 0) {
          break label301;
        }
        paramUri = paramUri.concat(str1);
        this.zzbHj = paramUri;
      }
      this.zzbEY = zzhn(this.zzbHk);
    }
    for (;;)
    {
      return bool;
      this.zzbHi = zzcj.zza.zzbHm;
      break;
      label177:
      if (str2.matches("^tagmanager.c.\\S+:\\/\\/preview\\/p\\?id=\\S+&gtm_preview=$"))
      {
        if (zzhn(paramUri.getQuery()).equals(this.zzbEY))
        {
          paramUri = String.valueOf(this.zzbEY);
          if (paramUri.length() != 0) {}
          for (paramUri = "Exit preview mode for container: ".concat(paramUri);; paramUri = new String("Exit preview mode for container: "))
          {
            zzbo.v(paramUri);
            this.zzbHi = zzcj.zza.zzbHl;
            this.zzbHj = null;
            break;
          }
        }
      }
      else
      {
        paramUri = String.valueOf(str2);
        if (paramUri.length() != 0) {}
        for (paramUri = "Invalid preview uri: ".concat(paramUri);; paramUri = new String("Invalid preview uri: "))
        {
          zzbo.zzbh(paramUri);
          bool = false;
          break;
        }
        paramUri = new String(paramUri);
        break label122;
      }
      label301:
      bool = false;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.google.android.gms.tagmanager.zzcj
 * JD-Core Version:    0.7.0.1
 */