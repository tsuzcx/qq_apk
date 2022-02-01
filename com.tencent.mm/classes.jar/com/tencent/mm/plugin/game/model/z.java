package com.tencent.mm.plugin.game.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bw.a;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.game.api.f;
import com.tencent.mm.plugin.game.e.d;
import com.tencent.mm.plugin.game.protobuf.bk;
import com.tencent.mm.plugin.game.protobuf.cc;
import com.tencent.mm.plugin.game.protobuf.ce;
import com.tencent.mm.plugin.game.protobuf.cf;
import com.tencent.mm.plugin.game.protobuf.ch;
import com.tencent.mm.plugin.game.protobuf.ci;
import com.tencent.mm.plugin.game.protobuf.cm;
import com.tencent.mm.plugin.game.protobuf.cs;
import com.tencent.mm.plugin.game.protobuf.da;
import com.tencent.mm.plugin.game.protobuf.dm;
import com.tencent.mm.plugin.game.ui.GameMediaList.a;
import com.tencent.mm.sdk.platformtools.Log;
import java.io.IOException;
import java.util.Iterator;
import java.util.LinkedList;

public final class z
  extends x
{
  private boolean xAG;
  public bk xGX;
  public c xGY;
  public aa xGZ;
  
  public z(a parama)
  {
    AppMethodBeat.i(41525);
    if (parama == null)
    {
      this.xGX = new bk();
      AppMethodBeat.o(41525);
      return;
    }
    this.xGX = ((bk)parama);
    this.xAG = false;
    amZ();
    AppMethodBeat.o(41525);
  }
  
  public z(byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(41526);
    this.xGX = new bk();
    if ((paramArrayOfByte == null) || (paramArrayOfByte.length == 0))
    {
      AppMethodBeat.o(41526);
      return;
    }
    try
    {
      this.xGX.parseFrom(paramArrayOfByte);
      this.xAG = true;
      amZ();
      AppMethodBeat.o(41526);
      return;
    }
    catch (IOException paramArrayOfByte)
    {
      for (;;)
      {
        Log.e("MicroMsg.GamePBDataDetail", "Parsing Failed: %s", new Object[] { paramArrayOfByte.getMessage() });
      }
    }
  }
  
  private void amZ()
  {
    AppMethodBeat.i(41527);
    this.xGY = dVD();
    if (this.xAG)
    {
      this.xGZ = new aa(this.xGY.field_appId);
      if (!this.xAG)
      {
        d.c(this.xGY);
        ((f)g.af(f.class)).dSL().b(this.xGY.field_appId, this.xGX);
      }
      AppMethodBeat.o(41527);
      return;
    }
    String str = this.xGY.field_appId;
    if (this.xGX.xLw != null) {}
    for (LinkedList localLinkedList = this.xGX.xLw.xMZ;; localLinkedList = null)
    {
      this.xGZ = new aa(str, localLinkedList);
      break;
    }
  }
  
  private c dVD()
  {
    AppMethodBeat.i(41528);
    c localc = a(this.xGX.xIz);
    if (localc != null)
    {
      localc.scene = 12;
      localc.dYu = 1201;
    }
    AppMethodBeat.o(41528);
    return localc;
  }
  
  public final String dVE()
  {
    if (this.xGX.xLA != null) {
      return this.xGX.xLA.title;
    }
    if (this.xGX.xLv != null) {
      return this.xGX.xLv.Title;
    }
    return null;
  }
  
  public final LinkedList<b> dVF()
  {
    AppMethodBeat.i(41529);
    LinkedList localLinkedList;
    Iterator localIterator;
    Object localObject;
    b localb;
    if ((this.xGX.xLA != null) && (this.xGX.xLA.pWe != null))
    {
      localLinkedList = new LinkedList();
      localIterator = this.xGX.xLA.pWe.iterator();
      while (localIterator.hasNext())
      {
        localObject = (cm)localIterator.next();
        localb = new b();
        localb.icon = ((cm)localObject).icon;
        localb.desc = ((cm)localObject).desc;
        localLinkedList.add(localb);
      }
      AppMethodBeat.o(41529);
      return localLinkedList;
    }
    if ((this.xGX.xLv != null) && (this.xGX.xLv.xMi != null))
    {
      localLinkedList = new LinkedList();
      localIterator = this.xGX.xLv.xMi.iterator();
      while (localIterator.hasNext())
      {
        localObject = (cf)localIterator.next();
        localb = new b();
        localb.icon = ((cf)localObject).xMl;
        localb.title = ((cf)localObject).Title;
        localb.desc = ((cf)localObject).xKd;
        localb.url = ((cf)localObject).xIB;
        localLinkedList.add(localb);
      }
      AppMethodBeat.o(41529);
      return localLinkedList;
    }
    AppMethodBeat.o(41529);
    return null;
  }
  
  public final int dVG()
  {
    if (this.xGX.xLA != null) {
      return 2;
    }
    return 1;
  }
  
  public final String dVH()
  {
    if ((this.xGX.xLt == null) || (this.xGX.xLt.Title == null)) {
      return null;
    }
    return this.xGX.xLt.Title;
  }
  
  public final String dVI()
  {
    if ((this.xGX.xLt == null) || (this.xGX.xLt.xKd == null)) {
      return null;
    }
    return this.xGX.xLt.xKd;
  }
  
  public final String dVJ()
  {
    if (this.xGX.xLu == null) {
      return null;
    }
    return this.xGX.xLu.Title;
  }
  
  public final LinkedList<ci> dVK()
  {
    if (this.xGX.xLu == null) {
      return null;
    }
    return this.xGX.xLu.xMn;
  }
  
  public final LinkedList<GameMediaList.a> getMediaList()
  {
    AppMethodBeat.i(41530);
    LinkedList localLinkedList = new LinkedList();
    if ((this.xGX.xLt == null) || (this.xGX.xLt.xuZ == null))
    {
      AppMethodBeat.o(41530);
      return localLinkedList;
    }
    Iterator localIterator = this.xGX.xLt.xuZ.iterator();
    while (localIterator.hasNext())
    {
      da localda = (da)localIterator.next();
      GameMediaList.a locala = new GameMediaList.a();
      locala.type = localda.xuT;
      locala.dkZ = localda.xMK;
      locala.url = localda.xML;
      localLinkedList.add(locala);
    }
    AppMethodBeat.o(41530);
    return localLinkedList;
  }
  
  public static final class a
  {
    public String desc;
    public String title;
    public String url;
  }
  
  public static final class b
  {
    public String desc;
    public String icon;
    public String title;
    public String url;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.game.model.z
 * JD-Core Version:    0.7.0.1
 */