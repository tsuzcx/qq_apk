package com.tencent.mm.plugin.game.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bx.a;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.game.api.e;
import com.tencent.mm.plugin.game.d.ba;
import com.tencent.mm.plugin.game.d.br;
import com.tencent.mm.plugin.game.d.bs;
import com.tencent.mm.plugin.game.d.bt;
import com.tencent.mm.plugin.game.d.bv;
import com.tencent.mm.plugin.game.d.bw;
import com.tencent.mm.plugin.game.d.bz;
import com.tencent.mm.plugin.game.d.cf;
import com.tencent.mm.plugin.game.d.cl;
import com.tencent.mm.plugin.game.d.cw;
import com.tencent.mm.plugin.game.f.d;
import com.tencent.mm.plugin.game.ui.GameMediaList.a;
import com.tencent.mm.sdk.platformtools.ad;
import java.io.IOException;
import java.util.Iterator;
import java.util.LinkedList;

public final class z
  extends x
{
  private boolean rRF;
  public ba rXO;
  public c rXP;
  public aa rXQ;
  
  public z(a parama)
  {
    AppMethodBeat.i(41525);
    if (parama == null)
    {
      this.rXO = new ba();
      AppMethodBeat.o(41525);
      return;
    }
    this.rXO = ((ba)parama);
    this.rRF = false;
    VL();
    AppMethodBeat.o(41525);
  }
  
  public z(byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(41526);
    this.rXO = new ba();
    if ((paramArrayOfByte == null) || (paramArrayOfByte.length == 0))
    {
      AppMethodBeat.o(41526);
      return;
    }
    try
    {
      this.rXO.parseFrom(paramArrayOfByte);
      this.rRF = true;
      VL();
      AppMethodBeat.o(41526);
      return;
    }
    catch (IOException paramArrayOfByte)
    {
      for (;;)
      {
        ad.e("MicroMsg.GamePBDataDetail", "Parsing Failed: %s", new Object[] { paramArrayOfByte.getMessage() });
      }
    }
  }
  
  private void VL()
  {
    AppMethodBeat.i(41527);
    this.rXP = cDv();
    if (this.rRF)
    {
      this.rXQ = new aa(this.rXP.field_appId);
      if (!this.rRF)
      {
        d.c(this.rXP);
        ((e)g.ab(e.class)).cBe().b(this.rXP.field_appId, this.rXO);
      }
      AppMethodBeat.o(41527);
      return;
    }
    String str = this.rXP.field_appId;
    if (this.rXO.sbY != null) {}
    for (LinkedList localLinkedList = this.rXO.sbY.sdx;; localLinkedList = null)
    {
      this.rXQ = new aa(str, localLinkedList);
      break;
    }
  }
  
  private c cDv()
  {
    AppMethodBeat.i(41528);
    c localc = a(this.rXO.rZp);
    if (localc != null)
    {
      localc.scene = 12;
      localc.dvS = 1201;
    }
    AppMethodBeat.o(41528);
    return localc;
  }
  
  public final String cDA()
  {
    if ((this.rXO.sbV == null) || (this.rXO.sbV.saB == null)) {
      return null;
    }
    return this.rXO.sbV.saB;
  }
  
  public final String cDB()
  {
    if (this.rXO.sbW == null) {
      return null;
    }
    return this.rXO.sbW.Title;
  }
  
  public final LinkedList<bw> cDC()
  {
    if (this.rXO.sbW == null) {
      return null;
    }
    return this.rXO.sbW.scO;
  }
  
  public final String cDw()
  {
    if (this.rXO.scc != null) {
      return this.rXO.scc.title;
    }
    if (this.rXO.sbX != null) {
      return this.rXO.sbX.Title;
    }
    return null;
  }
  
  public final LinkedList<b> cDx()
  {
    AppMethodBeat.i(41529);
    LinkedList localLinkedList;
    Iterator localIterator;
    Object localObject;
    b localb;
    if ((this.rXO.scc != null) && (this.rXO.scc.nvu != null))
    {
      localLinkedList = new LinkedList();
      localIterator = this.rXO.scc.nvu.iterator();
      while (localIterator.hasNext())
      {
        localObject = (bz)localIterator.next();
        localb = new b();
        localb.dub = ((bz)localObject).dub;
        localb.desc = ((bz)localObject).desc;
        localLinkedList.add(localb);
      }
      AppMethodBeat.o(41529);
      return localLinkedList;
    }
    if ((this.rXO.sbX != null) && (this.rXO.sbX.scJ != null))
    {
      localLinkedList = new LinkedList();
      localIterator = this.rXO.sbX.scJ.iterator();
      while (localIterator.hasNext())
      {
        localObject = (bt)localIterator.next();
        localb = new b();
        localb.dub = ((bt)localObject).scM;
        localb.title = ((bt)localObject).Title;
        localb.desc = ((bt)localObject).saB;
        localb.url = ((bt)localObject).rZr;
        localLinkedList.add(localb);
      }
      AppMethodBeat.o(41529);
      return localLinkedList;
    }
    AppMethodBeat.o(41529);
    return null;
  }
  
  public final int cDy()
  {
    if (this.rXO.scc != null) {
      return 2;
    }
    return 1;
  }
  
  public final String cDz()
  {
    if ((this.rXO.sbV == null) || (this.rXO.sbV.Title == null)) {
      return null;
    }
    return this.rXO.sbV.Title;
  }
  
  public final LinkedList<GameMediaList.a> getMediaList()
  {
    AppMethodBeat.i(41530);
    LinkedList localLinkedList = new LinkedList();
    if ((this.rXO.sbV == null) || (this.rXO.sbV.rOa == null))
    {
      AppMethodBeat.o(41530);
      return localLinkedList;
    }
    Iterator localIterator = this.rXO.sbV.rOa.iterator();
    while (localIterator.hasNext())
    {
      cl localcl = (cl)localIterator.next();
      GameMediaList.a locala = new GameMediaList.a();
      locala.type = localcl.rNT;
      locala.skI = localcl.sdi;
      locala.url = localcl.sdj;
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
    public String dub;
    public String title;
    public String url;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.game.model.z
 * JD-Core Version:    0.7.0.1
 */