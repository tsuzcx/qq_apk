package com.tencent.mm.plugin.game.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bw.a;
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
import com.tencent.mm.sdk.platformtools.ac;
import java.io.IOException;
import java.util.Iterator;
import java.util.LinkedList;

public final class z
  extends x
{
  private boolean sZv;
  public ba tfG;
  public c tfH;
  public aa tfI;
  
  public z(a parama)
  {
    AppMethodBeat.i(41525);
    if (parama == null)
    {
      this.tfG = new ba();
      AppMethodBeat.o(41525);
      return;
    }
    this.tfG = ((ba)parama);
    this.sZv = false;
    WJ();
    AppMethodBeat.o(41525);
  }
  
  public z(byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(41526);
    this.tfG = new ba();
    if ((paramArrayOfByte == null) || (paramArrayOfByte.length == 0))
    {
      AppMethodBeat.o(41526);
      return;
    }
    try
    {
      this.tfG.parseFrom(paramArrayOfByte);
      this.sZv = true;
      WJ();
      AppMethodBeat.o(41526);
      return;
    }
    catch (IOException paramArrayOfByte)
    {
      for (;;)
      {
        ac.e("MicroMsg.GamePBDataDetail", "Parsing Failed: %s", new Object[] { paramArrayOfByte.getMessage() });
      }
    }
  }
  
  private void WJ()
  {
    AppMethodBeat.i(41527);
    this.tfH = cQF();
    if (this.sZv)
    {
      this.tfI = new aa(this.tfH.field_appId);
      if (!this.sZv)
      {
        d.c(this.tfH);
        ((e)g.ab(e.class)).cOn().b(this.tfH.field_appId, this.tfG);
      }
      AppMethodBeat.o(41527);
      return;
    }
    String str = this.tfH.field_appId;
    if (this.tfG.tjS != null) {}
    for (LinkedList localLinkedList = this.tfG.tjS.tlr;; localLinkedList = null)
    {
      this.tfI = new aa(str, localLinkedList);
      break;
    }
  }
  
  private c cQF()
  {
    AppMethodBeat.i(41528);
    c localc = a(this.tfG.thi);
    if (localc != null)
    {
      localc.scene = 12;
      localc.dtF = 1201;
    }
    AppMethodBeat.o(41528);
    return localc;
  }
  
  public final String cQG()
  {
    if (this.tfG.tjW != null) {
      return this.tfG.tjW.title;
    }
    if (this.tfG.tjR != null) {
      return this.tfG.tjR.Title;
    }
    return null;
  }
  
  public final LinkedList<b> cQH()
  {
    AppMethodBeat.i(41529);
    LinkedList localLinkedList;
    Iterator localIterator;
    Object localObject;
    b localb;
    if ((this.tfG.tjW != null) && (this.tfG.tjW.nYu != null))
    {
      localLinkedList = new LinkedList();
      localIterator = this.tfG.tjW.nYu.iterator();
      while (localIterator.hasNext())
      {
        localObject = (bz)localIterator.next();
        localb = new b();
        localb.drM = ((bz)localObject).drM;
        localb.desc = ((bz)localObject).desc;
        localLinkedList.add(localb);
      }
      AppMethodBeat.o(41529);
      return localLinkedList;
    }
    if ((this.tfG.tjR != null) && (this.tfG.tjR.tkD != null))
    {
      localLinkedList = new LinkedList();
      localIterator = this.tfG.tjR.tkD.iterator();
      while (localIterator.hasNext())
      {
        localObject = (bt)localIterator.next();
        localb = new b();
        localb.drM = ((bt)localObject).tkG;
        localb.title = ((bt)localObject).Title;
        localb.desc = ((bt)localObject).tiv;
        localb.url = ((bt)localObject).thk;
        localLinkedList.add(localb);
      }
      AppMethodBeat.o(41529);
      return localLinkedList;
    }
    AppMethodBeat.o(41529);
    return null;
  }
  
  public final int cQI()
  {
    if (this.tfG.tjW != null) {
      return 2;
    }
    return 1;
  }
  
  public final String cQJ()
  {
    if ((this.tfG.tjP == null) || (this.tfG.tjP.Title == null)) {
      return null;
    }
    return this.tfG.tjP.Title;
  }
  
  public final String cQK()
  {
    if ((this.tfG.tjP == null) || (this.tfG.tjP.tiv == null)) {
      return null;
    }
    return this.tfG.tjP.tiv;
  }
  
  public final String cQL()
  {
    if (this.tfG.tjQ == null) {
      return null;
    }
    return this.tfG.tjQ.Title;
  }
  
  public final LinkedList<bw> cQM()
  {
    if (this.tfG.tjQ == null) {
      return null;
    }
    return this.tfG.tjQ.tkI;
  }
  
  public final LinkedList<GameMediaList.a> getMediaList()
  {
    AppMethodBeat.i(41530);
    LinkedList localLinkedList = new LinkedList();
    if ((this.tfG.tjP == null) || (this.tfG.tjP.sVR == null))
    {
      AppMethodBeat.o(41530);
      return localLinkedList;
    }
    Iterator localIterator = this.tfG.tjP.sVR.iterator();
    while (localIterator.hasNext())
    {
      cl localcl = (cl)localIterator.next();
      GameMediaList.a locala = new GameMediaList.a();
      locala.type = localcl.sVK;
      locala.tsB = localcl.tlc;
      locala.url = localcl.tld;
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
    public String drM;
    public String title;
    public String url;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.game.model.z
 * JD-Core Version:    0.7.0.1
 */