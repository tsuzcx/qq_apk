package com.tencent.mm.plugin.game.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bv.a;
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
import com.tencent.mm.plugin.game.d.cv;
import com.tencent.mm.plugin.game.f.d;
import com.tencent.mm.plugin.game.ui.GameMediaList.a;
import com.tencent.mm.sdk.platformtools.ab;
import java.io.IOException;
import java.util.Iterator;
import java.util.LinkedList;

public final class z
  extends x
{
  public ba nos;
  private boolean not;
  public c nou;
  public aa nov;
  
  public z(a parama)
  {
    AppMethodBeat.i(111360);
    if (parama == null)
    {
      this.nos = new ba();
      AppMethodBeat.o(111360);
      return;
    }
    this.nos = ((ba)parama);
    this.not = false;
    Kc();
    AppMethodBeat.o(111360);
  }
  
  public z(byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(111361);
    this.nos = new ba();
    if ((paramArrayOfByte == null) || (paramArrayOfByte.length == 0))
    {
      AppMethodBeat.o(111361);
      return;
    }
    try
    {
      this.nos.parseFrom(paramArrayOfByte);
      this.not = true;
      Kc();
      AppMethodBeat.o(111361);
      return;
    }
    catch (IOException paramArrayOfByte)
    {
      for (;;)
      {
        ab.e("MicroMsg.GamePBDataDetail", "Parsing Failed: %s", new Object[] { paramArrayOfByte.getMessage() });
      }
    }
  }
  
  private void Kc()
  {
    AppMethodBeat.i(111362);
    this.nou = bGz();
    if (this.not)
    {
      this.nov = new aa(this.nou.field_appId);
      if (!this.not)
      {
        d.c(this.nou);
        ((e)g.E(e.class)).bET().b(this.nou.field_appId, this.nos);
      }
      AppMethodBeat.o(111362);
      return;
    }
    String str = this.nou.field_appId;
    if (this.nos.nsw != null) {}
    for (LinkedList localLinkedList = this.nos.nsw.ntU;; localLinkedList = null)
    {
      this.nov = new aa(str, localLinkedList);
      break;
    }
  }
  
  private c bGz()
  {
    AppMethodBeat.i(111363);
    c localc = a(this.nos.npS);
    if (localc != null)
    {
      localc.scene = 12;
      localc.cFj = 1201;
    }
    AppMethodBeat.o(111363);
    return localc;
  }
  
  public final String bGA()
  {
    if (this.nos.nsA != null) {
      return this.nos.nsA.title;
    }
    if (this.nos.nsv != null) {
      return this.nos.nsv.Title;
    }
    return null;
  }
  
  public final LinkedList<z.b> bGB()
  {
    AppMethodBeat.i(111364);
    LinkedList localLinkedList;
    Iterator localIterator;
    Object localObject;
    z.b localb;
    if ((this.nos.nsA != null) && (this.nos.nsA.kqa != null))
    {
      localLinkedList = new LinkedList();
      localIterator = this.nos.nsA.kqa.iterator();
      while (localIterator.hasNext())
      {
        localObject = (bz)localIterator.next();
        localb = new z.b();
        localb.cDz = ((bz)localObject).cDz;
        localb.desc = ((bz)localObject).desc;
        localLinkedList.add(localb);
      }
      AppMethodBeat.o(111364);
      return localLinkedList;
    }
    if ((this.nos.nsv != null) && (this.nos.nsv.nth != null))
    {
      localLinkedList = new LinkedList();
      localIterator = this.nos.nsv.nth.iterator();
      while (localIterator.hasNext())
      {
        localObject = (bt)localIterator.next();
        localb = new z.b();
        localb.cDz = ((bt)localObject).ntk;
        localb.title = ((bt)localObject).Title;
        localb.desc = ((bt)localObject).nqY;
        localb.url = ((bt)localObject).npU;
        localLinkedList.add(localb);
      }
      AppMethodBeat.o(111364);
      return localLinkedList;
    }
    AppMethodBeat.o(111364);
    return null;
  }
  
  public final int bGC()
  {
    if (this.nos.nsA != null) {
      return 2;
    }
    return 1;
  }
  
  public final LinkedList<GameMediaList.a> bGD()
  {
    AppMethodBeat.i(111365);
    LinkedList localLinkedList = new LinkedList();
    if ((this.nos.nst == null) || (this.nos.nst.niL == null))
    {
      AppMethodBeat.o(111365);
      return localLinkedList;
    }
    Iterator localIterator = this.nos.nst.niL.iterator();
    while (localIterator.hasNext())
    {
      cl localcl = (cl)localIterator.next();
      GameMediaList.a locala = new GameMediaList.a();
      locala.type = localcl.niE;
      locala.nBl = localcl.ntH;
      locala.url = localcl.ntI;
      localLinkedList.add(locala);
    }
    AppMethodBeat.o(111365);
    return localLinkedList;
  }
  
  public final String bGE()
  {
    if ((this.nos.nst == null) || (this.nos.nst.Title == null)) {
      return null;
    }
    return this.nos.nst.Title;
  }
  
  public final String bGF()
  {
    if ((this.nos.nst == null) || (this.nos.nst.nqY == null)) {
      return null;
    }
    return this.nos.nst.nqY;
  }
  
  public final String bGG()
  {
    if (this.nos.nsu == null) {
      return null;
    }
    return this.nos.nsu.Title;
  }
  
  public final LinkedList<bw> bGH()
  {
    if (this.nos.nsu == null) {
      return null;
    }
    return this.nos.nsu.ntm;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.game.model.z
 * JD-Core Version:    0.7.0.1
 */