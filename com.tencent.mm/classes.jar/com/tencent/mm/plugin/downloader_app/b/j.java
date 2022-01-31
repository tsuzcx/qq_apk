package com.tencent.mm.plugin.downloader_app.b;

import com.tencent.mm.plugin.downloader.e.d;
import com.tencent.mm.sdk.platformtools.bk;

public final class j
  extends e
{
  public String appId = "";
  public String appName;
  public boolean fmm = false;
  public boolean gun = true;
  public String iSr;
  public int iSs = 0;
  public d iSt;
  public String iconUrl;
  public boolean ilB = false;
  public String jumpUrl;
  public String packageName;
  public int type;
  
  public j() {}
  
  public j(int paramInt)
  {
    this.type = paramInt;
  }
  
  public final int aGm()
  {
    return this.type;
  }
  
  public final boolean aGp()
  {
    return (this.type == 2) || (this.type == 4) || (this.type == 6);
  }
  
  public final boolean equals(Object paramObject)
  {
    if ((paramObject != null) && ((paramObject instanceof j)) && (!bk.bl(((j)paramObject).appId)) && (!bk.bl(this.appId))) {
      return ((j)paramObject).appId.equals(this.appId);
    }
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.downloader_app.b.j
 * JD-Core Version:    0.7.0.1
 */