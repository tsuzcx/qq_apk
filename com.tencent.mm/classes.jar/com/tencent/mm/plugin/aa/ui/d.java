package com.tencent.mm.plugin.aa.ui;

import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.aa.a.h;
import com.tencent.mm.plugin.messenger.foundation.a.j;
import com.tencent.mm.sdk.platformtools.y;
import com.tencent.mm.storage.ad;
import com.tencent.mm.storage.bd;
import com.tencent.mm.ui.contact.a.a;
import com.tencent.mm.ui.contact.l;
import com.tencent.mm.ui.contact.o;
import java.util.List;

public final class d
  extends o
{
  private String chatroomName;
  private List<String> eYb;
  
  public d(l paraml, String paramString)
  {
    super(paraml, null, true, true);
    this.chatroomName = paramString;
    y.i("MicroMsg.AASelectInitAdapter", "resetData");
    this.eYb = h.pr(this.chatroomName);
  }
  
  public final int getCount()
  {
    return this.eYb.size();
  }
  
  protected final a jQ(int paramInt)
  {
    Object localObject = (String)this.eYb.get(paramInt);
    g.DQ();
    localObject = ((j)g.r(j.class)).Fw().abl((String)localObject);
    c localc = new c(paramInt);
    localc.bHQ = this.chatroomName;
    localc.dnp = ((ad)localObject);
    localc.vLJ = true;
    return localc;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.aa.ui.d
 * JD-Core Version:    0.7.0.1
 */