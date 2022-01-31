package com.tencent.mm.plugin.downloader_app.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.downloader.c.a.a.f;
import com.tencent.mm.plugin.downloader.c.b.a;
import com.tencent.mm.plugin.downloader.c.b.b;
import com.tencent.mm.sdk.platformtools.bo;

public final class i
  extends e
{
  public String appId = "";
  public String appName;
  public boolean gDG = false;
  public boolean hPf = true;
  public String iconUrl;
  public String jumpUrl;
  public boolean kmz = false;
  public boolean laY;
  public String laZ;
  public int lba = 0;
  public b lbb;
  public f lbc;
  public a lbd;
  public String packageName;
  public int position;
  public int type;
  
  public i() {}
  
  public i(int paramInt)
  {
    this.type = paramInt;
  }
  
  public final int bjP()
  {
    return this.type;
  }
  
  public final boolean bjS()
  {
    return (this.type == 2) || (this.type == 4) || (this.type == 6);
  }
  
  public final boolean equals(Object paramObject)
  {
    AppMethodBeat.i(136146);
    if ((paramObject != null) && ((paramObject instanceof i)) && (!bo.isNullOrNil(((i)paramObject).appId)) && (!bo.isNullOrNil(this.appId)))
    {
      boolean bool = ((i)paramObject).appId.equals(this.appId);
      AppMethodBeat.o(136146);
      return bool;
    }
    AppMethodBeat.o(136146);
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.downloader_app.b.i
 * JD-Core Version:    0.7.0.1
 */