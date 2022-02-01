package com.tencent.mm.plugin.downloader_app.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.downloader.c.a.a.f;
import com.tencent.mm.plugin.downloader.c.b.c;
import com.tencent.mm.sdk.platformtools.bs;

public final class i
  extends com.tencent.mm.plugin.game.commlib.c.b
{
  public String appId = "";
  public String appName;
  public String iconUrl;
  public boolean isSelected = false;
  public String jumpUrl;
  public boolean kvD = true;
  public boolean nUE = false;
  public boolean oLA;
  public String oLB;
  public int oLC = 0;
  public c oLD;
  public f oLE;
  public com.tencent.mm.plugin.downloader.c.b.b oLF;
  public String packageName;
  public int position;
  public int type;
  
  public i() {}
  
  public i(int paramInt)
  {
    this.type = paramInt;
  }
  
  public final int a(com.tencent.mm.plugin.game.commlib.c.b paramb)
  {
    AppMethodBeat.i(8906);
    int i = Integer.compare(this.type, ((Integer)paramb.bYv()).intValue());
    AppMethodBeat.o(8906);
    return i;
  }
  
  public final boolean bYu()
  {
    return (this.type == 2) || (this.type == 4) || (this.type == 6);
  }
  
  public final Object bYv()
  {
    AppMethodBeat.i(8905);
    int i = this.type;
    AppMethodBeat.o(8905);
    return Integer.valueOf(i);
  }
  
  public final boolean equals(Object paramObject)
  {
    AppMethodBeat.i(8907);
    if ((paramObject != null) && ((paramObject instanceof i)) && (!bs.isNullOrNil(((i)paramObject).appId)) && (!bs.isNullOrNil(this.appId)))
    {
      boolean bool = ((i)paramObject).appId.equals(this.appId);
      AppMethodBeat.o(8907);
      return bool;
    }
    AppMethodBeat.o(8907);
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.downloader_app.a.i
 * JD-Core Version:    0.7.0.1
 */