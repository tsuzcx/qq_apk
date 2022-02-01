package com.tencent.mm.plugin.downloader_app.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.downloader.b.a.a.f;
import com.tencent.mm.plugin.downloader.b.b.c;
import com.tencent.mm.sdk.platformtools.Util;

public class i
  extends com.tencent.mm.plugin.game.commlib.c.b
{
  public String appId = "";
  public String appName;
  public String iconUrl;
  public boolean isSelected = false;
  public String jumpUrl;
  public String packageName;
  public int position;
  public boolean sdN = true;
  public int type;
  public boolean wsK = false;
  public boolean xsD;
  public String xsE;
  public int xsF = 0;
  public c xsG;
  public f xsH;
  public com.tencent.mm.plugin.downloader.b.b.b xsI;
  
  public i() {}
  
  public i(int paramInt)
  {
    this.type = paramInt;
  }
  
  public final int a(com.tencent.mm.plugin.game.commlib.c.b paramb)
  {
    AppMethodBeat.i(8906);
    int i = Integer.compare(this.type, ((Integer)paramb.dvb()).intValue());
    AppMethodBeat.o(8906);
    return i;
  }
  
  public final boolean dva()
  {
    return (this.type == 2) || (this.type == 4) || (this.type == 6);
  }
  
  public final Object dvb()
  {
    AppMethodBeat.i(8905);
    int i = this.type;
    AppMethodBeat.o(8905);
    return Integer.valueOf(i);
  }
  
  public boolean equals(Object paramObject)
  {
    AppMethodBeat.i(8907);
    if ((paramObject != null) && ((paramObject instanceof i)) && (!Util.isNullOrNil(((i)paramObject).appId)) && (!Util.isNullOrNil(this.appId)))
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