package com.tencent.mm.plugin.game.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bx.a;
import com.tencent.mm.kernel.h;
import com.tencent.mm.plugin.game.api.f;
import com.tencent.mm.plugin.game.d.d;
import com.tencent.mm.plugin.game.protobuf.bm;
import com.tencent.mm.plugin.game.protobuf.ce;
import com.tencent.mm.plugin.game.protobuf.cg;
import com.tencent.mm.plugin.game.protobuf.ch;
import com.tencent.mm.plugin.game.protobuf.cj;
import com.tencent.mm.plugin.game.protobuf.ck;
import com.tencent.mm.plugin.game.protobuf.cp;
import com.tencent.mm.plugin.game.protobuf.cv;
import com.tencent.mm.plugin.game.protobuf.de;
import com.tencent.mm.plugin.game.protobuf.dr;
import com.tencent.mm.plugin.game.ui.GameMediaList.a;
import com.tencent.mm.sdk.platformtools.Log;
import java.io.IOException;
import java.util.Iterator;
import java.util.LinkedList;

public final class z
  extends x
{
  public bm IFi;
  public c IFj;
  public aa IFk;
  private boolean IyK;
  
  public z(a parama)
  {
    AppMethodBeat.i(41525);
    if (parama == null)
    {
      this.IFi = new bm();
      AppMethodBeat.o(41525);
      return;
    }
    this.IFi = ((bm)parama);
    this.IyK = false;
    aNi();
    AppMethodBeat.o(41525);
  }
  
  public z(byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(41526);
    this.IFi = new bm();
    if ((paramArrayOfByte == null) || (paramArrayOfByte.length == 0))
    {
      AppMethodBeat.o(41526);
      return;
    }
    try
    {
      this.IFi.parseFrom(paramArrayOfByte);
      this.IyK = true;
      aNi();
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
  
  private void aNi()
  {
    AppMethodBeat.i(41527);
    this.IFj = fGH();
    if (this.IyK)
    {
      this.IFk = new aa(this.IFj.field_appId);
      if (!this.IyK)
      {
        d.c(this.IFj);
        ((f)h.ax(f.class)).fCi().b(this.IFj.field_appId, this.IFi);
      }
      AppMethodBeat.o(41527);
      return;
    }
    String str = this.IFj.field_appId;
    if (this.IFi.IJP != null) {}
    for (LinkedList localLinkedList = this.IFi.IJP.ILy;; localLinkedList = null)
    {
      this.IFk = new aa(str, localLinkedList);
      break;
    }
  }
  
  private c fGH()
  {
    AppMethodBeat.i(41528);
    c localc = a(this.IFi.IGJ);
    if (localc != null)
    {
      localc.scene = 12;
      localc.hYi = 1201;
    }
    AppMethodBeat.o(41528);
    return localc;
  }
  
  public final String fGI()
  {
    if (this.IFi.IJT != null) {
      return this.IFi.IJT.title;
    }
    if (this.IFi.IJO != null) {
      return this.IFi.IJO.hAP;
    }
    return null;
  }
  
  public final LinkedList<b> fGJ()
  {
    AppMethodBeat.i(41529);
    LinkedList localLinkedList;
    Iterator localIterator;
    Object localObject;
    b localb;
    if ((this.IFi.IJT != null) && (this.IFi.IJT.wwD != null))
    {
      localLinkedList = new LinkedList();
      localIterator = this.IFi.IJT.wwD.iterator();
      while (localIterator.hasNext())
      {
        localObject = (cp)localIterator.next();
        localb = new b();
        localb.icon = ((cp)localObject).icon;
        localb.desc = ((cp)localObject).desc;
        localLinkedList.add(localb);
      }
      AppMethodBeat.o(41529);
      return localLinkedList;
    }
    if ((this.IFi.IJO != null) && (this.IFi.IJO.IKB != null))
    {
      localLinkedList = new LinkedList();
      localIterator = this.IFi.IJO.IKB.iterator();
      while (localIterator.hasNext())
      {
        localObject = (ch)localIterator.next();
        localb = new b();
        localb.icon = ((ch)localObject).IKE;
        localb.title = ((ch)localObject).hAP;
        localb.desc = ((ch)localObject).IIu;
        localb.url = ((ch)localObject).IGL;
        localLinkedList.add(localb);
      }
      AppMethodBeat.o(41529);
      return localLinkedList;
    }
    AppMethodBeat.o(41529);
    return null;
  }
  
  public final int fGK()
  {
    if (this.IFi.IJT != null) {
      return 2;
    }
    return 1;
  }
  
  public final String fGL()
  {
    if ((this.IFi.IJM == null) || (this.IFi.IJM.hAP == null)) {
      return null;
    }
    return this.IFi.IJM.hAP;
  }
  
  public final String fGM()
  {
    if ((this.IFi.IJM == null) || (this.IFi.IJM.IIu == null)) {
      return null;
    }
    return this.IFi.IJM.IIu;
  }
  
  public final String fGN()
  {
    if (this.IFi.IJN == null) {
      return null;
    }
    return this.IFi.IJN.hAP;
  }
  
  public final LinkedList<ck> fGO()
  {
    if (this.IFi.IJN == null) {
      return null;
    }
    return this.IFi.IJN.IKG;
  }
  
  public final LinkedList<GameMediaList.a> getMediaList()
  {
    AppMethodBeat.i(41530);
    LinkedList localLinkedList = new LinkedList();
    if ((this.IFi.IJM == null) || (this.IFi.IJM.Idy == null))
    {
      AppMethodBeat.o(41530);
      return localLinkedList;
    }
    Iterator localIterator = this.IFi.IJM.Idy.iterator();
    while (localIterator.hasNext())
    {
      de localde = (de)localIterator.next();
      GameMediaList.a locala = new GameMediaList.a();
      locala.type = localde.Idt;
      locala.hgn = localde.ILh;
      locala.url = localde.ILi;
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.game.model.z
 * JD-Core Version:    0.7.0.1
 */