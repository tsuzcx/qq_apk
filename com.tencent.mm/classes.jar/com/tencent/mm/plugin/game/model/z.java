package com.tencent.mm.plugin.game.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bx.a;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.game.api.f;
import com.tencent.mm.plugin.game.d.bd;
import com.tencent.mm.plugin.game.d.bv;
import com.tencent.mm.plugin.game.d.bx;
import com.tencent.mm.plugin.game.d.by;
import com.tencent.mm.plugin.game.d.ca;
import com.tencent.mm.plugin.game.d.cb;
import com.tencent.mm.plugin.game.d.cf;
import com.tencent.mm.plugin.game.d.cl;
import com.tencent.mm.plugin.game.d.cs;
import com.tencent.mm.plugin.game.d.de;
import com.tencent.mm.plugin.game.f.d;
import com.tencent.mm.plugin.game.ui.GameMediaList.a;
import com.tencent.mm.sdk.platformtools.ad;
import java.io.IOException;
import java.util.Iterator;
import java.util.LinkedList;

public final class z
  extends x
{
  private boolean tXm;
  public bd udw;
  public c udx;
  public aa udy;
  
  public z(a parama)
  {
    AppMethodBeat.i(41525);
    if (parama == null)
    {
      this.udw = new bd();
      AppMethodBeat.o(41525);
      return;
    }
    this.udw = ((bd)parama);
    this.tXm = false;
    Zd();
    AppMethodBeat.o(41525);
  }
  
  public z(byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(41526);
    this.udw = new bd();
    if ((paramArrayOfByte == null) || (paramArrayOfByte.length == 0))
    {
      AppMethodBeat.o(41526);
      return;
    }
    try
    {
      this.udw.parseFrom(paramArrayOfByte);
      this.tXm = true;
      Zd();
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
  
  private void Zd()
  {
    AppMethodBeat.i(41527);
    this.udx = cZl();
    if (this.tXm)
    {
      this.udy = new aa(this.udx.field_appId);
      if (!this.tXm)
      {
        d.c(this.udx);
        ((f)g.ab(f.class)).cWI().b(this.udx.field_appId, this.udw);
      }
      AppMethodBeat.o(41527);
      return;
    }
    String str = this.udx.field_appId;
    if (this.udw.uhU != null) {}
    for (LinkedList localLinkedList = this.udw.uhU.ujA;; localLinkedList = null)
    {
      this.udy = new aa(str, localLinkedList);
      break;
    }
  }
  
  private c cZl()
  {
    AppMethodBeat.i(41528);
    c localc = a(this.udw.ueZ);
    if (localc != null)
    {
      localc.scene = 12;
      localc.dFG = 1201;
    }
    AppMethodBeat.o(41528);
    return localc;
  }
  
  public final String cZm()
  {
    if (this.udw.uhY != null) {
      return this.udw.uhY.title;
    }
    if (this.udw.uhT != null) {
      return this.udw.uhT.Title;
    }
    return null;
  }
  
  public final LinkedList<b> cZn()
  {
    AppMethodBeat.i(41529);
    LinkedList localLinkedList;
    Iterator localIterator;
    Object localObject;
    b localb;
    if ((this.udw.uhY != null) && (this.udw.uhY.oBO != null))
    {
      localLinkedList = new LinkedList();
      localIterator = this.udw.uhY.oBO.iterator();
      while (localIterator.hasNext())
      {
        localObject = (cf)localIterator.next();
        localb = new b();
        localb.dDH = ((cf)localObject).dDH;
        localb.desc = ((cf)localObject).desc;
        localLinkedList.add(localb);
      }
      AppMethodBeat.o(41529);
      return localLinkedList;
    }
    if ((this.udw.uhT != null) && (this.udw.uhT.uiJ != null))
    {
      localLinkedList = new LinkedList();
      localIterator = this.udw.uhT.uiJ.iterator();
      while (localIterator.hasNext())
      {
        localObject = (by)localIterator.next();
        localb = new b();
        localb.dDH = ((by)localObject).uiM;
        localb.title = ((by)localObject).Title;
        localb.desc = ((by)localObject).ugo;
        localb.url = ((by)localObject).ufb;
        localLinkedList.add(localb);
      }
      AppMethodBeat.o(41529);
      return localLinkedList;
    }
    AppMethodBeat.o(41529);
    return null;
  }
  
  public final int cZo()
  {
    if (this.udw.uhY != null) {
      return 2;
    }
    return 1;
  }
  
  public final String cZp()
  {
    if ((this.udw.uhR == null) || (this.udw.uhR.Title == null)) {
      return null;
    }
    return this.udw.uhR.Title;
  }
  
  public final String cZq()
  {
    if ((this.udw.uhR == null) || (this.udw.uhR.ugo == null)) {
      return null;
    }
    return this.udw.uhR.ugo;
  }
  
  public final String cZr()
  {
    if (this.udw.uhS == null) {
      return null;
    }
    return this.udw.uhS.Title;
  }
  
  public final LinkedList<cb> cZs()
  {
    if (this.udw.uhS == null) {
      return null;
    }
    return this.udw.uhS.uiO;
  }
  
  public final LinkedList<GameMediaList.a> getMediaList()
  {
    AppMethodBeat.i(41530);
    LinkedList localLinkedList = new LinkedList();
    if ((this.udw.uhR == null) || (this.udw.uhR.tSw == null))
    {
      AppMethodBeat.o(41530);
      return localLinkedList;
    }
    Iterator localIterator = this.udw.uhR.tSw.iterator();
    while (localIterator.hasNext())
    {
      cs localcs = (cs)localIterator.next();
      GameMediaList.a locala = new GameMediaList.a();
      locala.type = localcs.tSp;
      locala.uqY = localcs.ujl;
      locala.url = localcs.ujm;
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
    public String dDH;
    public String desc;
    public String title;
    public String url;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.game.model.z
 * JD-Core Version:    0.7.0.1
 */