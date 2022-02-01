package com.tencent.mm.plugin.downloader_app.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.downloader.c.a.a.f;
import com.tencent.mm.plugin.downloader.c.b.c;
import com.tencent.mm.sdk.platformtools.bu;

public final class i
  extends com.tencent.mm.plugin.game.commlib.c.b
{
  public String appId = "";
  public String appName;
  public String iconUrl;
  public boolean isSelected = false;
  public String jumpUrl;
  public boolean kVo = true;
  public boolean oEB = false;
  public String packageName;
  public int position;
  public boolean pvO;
  public String pvP;
  public int pvQ = 0;
  public c pvR;
  public f pvS;
  public com.tencent.mm.plugin.downloader.c.b.b pvT;
  public int type;
  
  public i() {}
  
  public i(int paramInt)
  {
    this.type = paramInt;
  }
  
  public final int a(com.tencent.mm.plugin.game.commlib.c.b paramb)
  {
    AppMethodBeat.i(8906);
    int i = Integer.compare(this.type, ((Integer)paramb.ceo()).intValue());
    AppMethodBeat.o(8906);
    return i;
  }
  
  public final boolean cen()
  {
    return (this.type == 2) || (this.type == 4) || (this.type == 6);
  }
  
  public final Object ceo()
  {
    AppMethodBeat.i(8905);
    int i = this.type;
    AppMethodBeat.o(8905);
    return Integer.valueOf(i);
  }
  
  public final boolean equals(Object paramObject)
  {
    AppMethodBeat.i(8907);
    if ((paramObject != null) && ((paramObject instanceof i)) && (!bu.isNullOrNil(((i)paramObject).appId)) && (!bu.isNullOrNil(this.appId)))
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