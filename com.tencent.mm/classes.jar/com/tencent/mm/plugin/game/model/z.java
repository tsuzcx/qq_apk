package com.tencent.mm.plugin.game.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.cd.a;
import com.tencent.mm.kernel.h;
import com.tencent.mm.plugin.game.api.f;
import com.tencent.mm.plugin.game.d.d;
import com.tencent.mm.plugin.game.protobuf.bl;
import com.tencent.mm.plugin.game.protobuf.cd;
import com.tencent.mm.plugin.game.protobuf.cf;
import com.tencent.mm.plugin.game.protobuf.cg;
import com.tencent.mm.plugin.game.protobuf.ci;
import com.tencent.mm.plugin.game.protobuf.cj;
import com.tencent.mm.plugin.game.protobuf.cn;
import com.tencent.mm.plugin.game.protobuf.ct;
import com.tencent.mm.plugin.game.protobuf.db;
import com.tencent.mm.plugin.game.protobuf.dn;
import com.tencent.mm.plugin.game.ui.GameMediaList.a;
import com.tencent.mm.sdk.platformtools.Log;
import java.io.IOException;
import java.util.Iterator;
import java.util.LinkedList;

public final class z
  extends x
{
  private boolean CEH;
  public bl CLa;
  public c CLb;
  public aa CLc;
  
  public z(a parama)
  {
    AppMethodBeat.i(41525);
    if (parama == null)
    {
      this.CLa = new bl();
      AppMethodBeat.o(41525);
      return;
    }
    this.CLa = ((bl)parama);
    this.CEH = false;
    ata();
    AppMethodBeat.o(41525);
  }
  
  public z(byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(41526);
    this.CLa = new bl();
    if ((paramArrayOfByte == null) || (paramArrayOfByte.length == 0))
    {
      AppMethodBeat.o(41526);
      return;
    }
    try
    {
      this.CLa.parseFrom(paramArrayOfByte);
      this.CEH = true;
      ata();
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
  
  private void ata()
  {
    AppMethodBeat.i(41527);
    this.CLb = eyL();
    if (this.CEH)
    {
      this.CLc = new aa(this.CLb.field_appId);
      if (!this.CEH)
      {
        d.c(this.CLb);
        ((f)h.ae(f.class)).evp().b(this.CLb.field_appId, this.CLa);
      }
      AppMethodBeat.o(41527);
      return;
    }
    String str = this.CLb.field_appId;
    if (this.CLa.CPF != null) {}
    for (LinkedList localLinkedList = this.CLa.CPF.CRi;; localLinkedList = null)
    {
      this.CLc = new aa(str, localLinkedList);
      break;
    }
  }
  
  private c eyL()
  {
    AppMethodBeat.i(41528);
    c localc = a(this.CLa.CME);
    if (localc != null)
    {
      localc.scene = 12;
      localc.fSl = 1201;
    }
    AppMethodBeat.o(41528);
    return localc;
  }
  
  public final String eyM()
  {
    if (this.CLa.CPJ != null) {
      return this.CLa.CPJ.title;
    }
    if (this.CLa.CPE != null) {
      return this.CLa.CPE.fwr;
    }
    return null;
  }
  
  public final LinkedList<b> eyN()
  {
    AppMethodBeat.i(41529);
    LinkedList localLinkedList;
    Iterator localIterator;
    Object localObject;
    b localb;
    if ((this.CLa.CPJ != null) && (this.CLa.CPJ.tse != null))
    {
      localLinkedList = new LinkedList();
      localIterator = this.CLa.CPJ.tse.iterator();
      while (localIterator.hasNext())
      {
        localObject = (cn)localIterator.next();
        localb = new b();
        localb.icon = ((cn)localObject).icon;
        localb.desc = ((cn)localObject).desc;
        localLinkedList.add(localb);
      }
      AppMethodBeat.o(41529);
      return localLinkedList;
    }
    if ((this.CLa.CPE != null) && (this.CLa.CPE.CQr != null))
    {
      localLinkedList = new LinkedList();
      localIterator = this.CLa.CPE.CQr.iterator();
      while (localIterator.hasNext())
      {
        localObject = (cg)localIterator.next();
        localb = new b();
        localb.icon = ((cg)localObject).CQu;
        localb.title = ((cg)localObject).fwr;
        localb.desc = ((cg)localObject).COk;
        localb.url = ((cg)localObject).CMG;
        localLinkedList.add(localb);
      }
      AppMethodBeat.o(41529);
      return localLinkedList;
    }
    AppMethodBeat.o(41529);
    return null;
  }
  
  public final int eyO()
  {
    if (this.CLa.CPJ != null) {
      return 2;
    }
    return 1;
  }
  
  public final String eyP()
  {
    if ((this.CLa.CPC == null) || (this.CLa.CPC.fwr == null)) {
      return null;
    }
    return this.CLa.CPC.fwr;
  }
  
  public final String eyQ()
  {
    if ((this.CLa.CPC == null) || (this.CLa.CPC.COk == null)) {
      return null;
    }
    return this.CLa.CPC.COk;
  }
  
  public final String eyR()
  {
    if (this.CLa.CPD == null) {
      return null;
    }
    return this.CLa.CPD.fwr;
  }
  
  public final LinkedList<cj> eyS()
  {
    if (this.CLa.CPD == null) {
      return null;
    }
    return this.CLa.CPD.CQw;
  }
  
  public final LinkedList<GameMediaList.a> getMediaList()
  {
    AppMethodBeat.i(41530);
    LinkedList localLinkedList = new LinkedList();
    if ((this.CLa.CPC == null) || (this.CLa.CPC.Crs == null))
    {
      AppMethodBeat.o(41530);
      return localLinkedList;
    }
    Iterator localIterator = this.CLa.CPC.Crs.iterator();
    while (localIterator.hasNext())
    {
      db localdb = (db)localIterator.next();
      GameMediaList.a locala = new GameMediaList.a();
      locala.type = localdb.Crm;
      locala.fcF = localdb.CQT;
      locala.url = localdb.CQU;
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.game.model.z
 * JD-Core Version:    0.7.0.1
 */