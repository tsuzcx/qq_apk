package com.tencent.mm.plugin.game.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bw.a;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.game.api.f;
import com.tencent.mm.plugin.game.d.bk;
import com.tencent.mm.plugin.game.d.cc;
import com.tencent.mm.plugin.game.d.ce;
import com.tencent.mm.plugin.game.d.cf;
import com.tencent.mm.plugin.game.d.ch;
import com.tencent.mm.plugin.game.d.ci;
import com.tencent.mm.plugin.game.d.cm;
import com.tencent.mm.plugin.game.d.cs;
import com.tencent.mm.plugin.game.d.da;
import com.tencent.mm.plugin.game.d.dm;
import com.tencent.mm.plugin.game.f.d;
import com.tencent.mm.plugin.game.ui.GameMediaList.a;
import com.tencent.mm.sdk.platformtools.ae;
import java.io.IOException;
import java.util.Iterator;
import java.util.LinkedList;

public final class z
  extends x
{
  private boolean uil;
  public bk uoE;
  public c uoF;
  public aa uoG;
  
  public z(a parama)
  {
    AppMethodBeat.i(41525);
    if (parama == null)
    {
      this.uoE = new bk();
      AppMethodBeat.o(41525);
      return;
    }
    this.uoE = ((bk)parama);
    this.uil = false;
    Zm();
    AppMethodBeat.o(41525);
  }
  
  public z(byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(41526);
    this.uoE = new bk();
    if ((paramArrayOfByte == null) || (paramArrayOfByte.length == 0))
    {
      AppMethodBeat.o(41526);
      return;
    }
    try
    {
      this.uoE.parseFrom(paramArrayOfByte);
      this.uil = true;
      Zm();
      AppMethodBeat.o(41526);
      return;
    }
    catch (IOException paramArrayOfByte)
    {
      for (;;)
      {
        ae.e("MicroMsg.GamePBDataDetail", "Parsing Failed: %s", new Object[] { paramArrayOfByte.getMessage() });
      }
    }
  }
  
  private void Zm()
  {
    AppMethodBeat.i(41527);
    this.uoF = dbW();
    if (this.uil)
    {
      this.uoG = new aa(this.uoF.field_appId);
      if (!this.uil)
      {
        d.c(this.uoF);
        ((f)g.ab(f.class)).cZm().b(this.uoF.field_appId, this.uoE);
      }
      AppMethodBeat.o(41527);
      return;
    }
    String str = this.uoF.field_appId;
    if (this.uoE.utu != null) {}
    for (LinkedList localLinkedList = this.uoE.utu.uuY;; localLinkedList = null)
    {
      this.uoG = new aa(str, localLinkedList);
      break;
    }
  }
  
  private c dbW()
  {
    AppMethodBeat.i(41528);
    c localc = a(this.uoE.uqg);
    if (localc != null)
    {
      localc.scene = 12;
      localc.dGL = 1201;
    }
    AppMethodBeat.o(41528);
    return localc;
  }
  
  public final String dbX()
  {
    if (this.uoE.uty != null) {
      return this.uoE.uty.title;
    }
    if (this.uoE.utt != null) {
      return this.uoE.utt.Title;
    }
    return null;
  }
  
  public final LinkedList<b> dbY()
  {
    AppMethodBeat.i(41529);
    LinkedList localLinkedList;
    Iterator localIterator;
    Object localObject;
    b localb;
    if ((this.uoE.uty != null) && (this.uoE.uty.oIq != null))
    {
      localLinkedList = new LinkedList();
      localIterator = this.uoE.uty.oIq.iterator();
      while (localIterator.hasNext())
      {
        localObject = (cm)localIterator.next();
        localb = new b();
        localb.dEM = ((cm)localObject).dEM;
        localb.desc = ((cm)localObject).desc;
        localLinkedList.add(localb);
      }
      AppMethodBeat.o(41529);
      return localLinkedList;
    }
    if ((this.uoE.utt != null) && (this.uoE.utt.uug != null))
    {
      localLinkedList = new LinkedList();
      localIterator = this.uoE.utt.uug.iterator();
      while (localIterator.hasNext())
      {
        localObject = (cf)localIterator.next();
        localb = new b();
        localb.dEM = ((cf)localObject).uuj;
        localb.title = ((cf)localObject).Title;
        localb.desc = ((cf)localObject).urL;
        localb.url = ((cf)localObject).uqi;
        localLinkedList.add(localb);
      }
      AppMethodBeat.o(41529);
      return localLinkedList;
    }
    AppMethodBeat.o(41529);
    return null;
  }
  
  public final int dbZ()
  {
    if (this.uoE.uty != null) {
      return 2;
    }
    return 1;
  }
  
  public final String dca()
  {
    if ((this.uoE.utr == null) || (this.uoE.utr.Title == null)) {
      return null;
    }
    return this.uoE.utr.Title;
  }
  
  public final String dcb()
  {
    if ((this.uoE.utr == null) || (this.uoE.utr.urL == null)) {
      return null;
    }
    return this.uoE.utr.urL;
  }
  
  public final String dcc()
  {
    if (this.uoE.uts == null) {
      return null;
    }
    return this.uoE.uts.Title;
  }
  
  public final LinkedList<ci> dcd()
  {
    if (this.uoE.uts == null) {
      return null;
    }
    return this.uoE.uts.uul;
  }
  
  public final LinkedList<GameMediaList.a> getMediaList()
  {
    AppMethodBeat.i(41530);
    LinkedList localLinkedList = new LinkedList();
    if ((this.uoE.utr == null) || (this.uoE.utr.udn == null))
    {
      AppMethodBeat.o(41530);
      return localLinkedList;
    }
    Iterator localIterator = this.uoE.utr.udn.iterator();
    while (localIterator.hasNext())
    {
      da localda = (da)localIterator.next();
      GameMediaList.a locala = new GameMediaList.a();
      locala.type = localda.udg;
      locala.cUF = localda.uuJ;
      locala.url = localda.uuK;
      localLinkedList.add(locala);
    }
    AppMethodBeat.o(41530);
    return localLinkedList;
  }
  
  public static final class b
  {
    public String dEM;
    public String desc;
    public String title;
    public String url;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.game.model.z
 * JD-Core Version:    0.7.0.1
 */