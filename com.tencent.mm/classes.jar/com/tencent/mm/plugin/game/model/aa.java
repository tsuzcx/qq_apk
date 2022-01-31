package com.tencent.mm.plugin.game.model;

import com.tencent.mm.bv.a;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.game.a.c;
import com.tencent.mm.plugin.game.d.az;
import com.tencent.mm.plugin.game.d.bq;
import com.tencent.mm.plugin.game.d.br;
import com.tencent.mm.plugin.game.d.bs;
import com.tencent.mm.plugin.game.d.bu;
import com.tencent.mm.plugin.game.d.bv;
import com.tencent.mm.plugin.game.d.by;
import com.tencent.mm.plugin.game.d.ce;
import com.tencent.mm.plugin.game.d.ck;
import com.tencent.mm.plugin.game.d.cu;
import com.tencent.mm.plugin.game.ui.GameMediaList.a;
import java.io.IOException;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public final class aa
  extends y
{
  public az kQo;
  private boolean kQp;
  public d kQq;
  public ab kQr;
  
  public aa(a parama)
  {
    if (parama == null)
    {
      this.kQo = new az();
      return;
    }
    this.kQo = ((az)parama);
    this.kQp = false;
    xK();
  }
  
  public aa(byte[] paramArrayOfByte)
  {
    this.kQo = new az();
    if ((paramArrayOfByte == null) || (paramArrayOfByte.length == 0)) {
      return;
    }
    try
    {
      this.kQo.aH(paramArrayOfByte);
      this.kQp = true;
      xK();
      return;
    }
    catch (IOException paramArrayOfByte)
    {
      for (;;)
      {
        com.tencent.mm.sdk.platformtools.y.e("MicroMsg.GamePBDataDetail", "Parsing Failed: %s", new Object[] { paramArrayOfByte.getMessage() });
      }
    }
  }
  
  private void xK()
  {
    Object localObject = a(this.kQo.kRQ);
    if (localObject != null)
    {
      ((d)localObject).scene = 12;
      ((d)localObject).bXn = 1201;
    }
    this.kQq = ((d)localObject);
    if (this.kQp)
    {
      this.kQr = new ab(this.kQq.field_appId);
      if (!this.kQp)
      {
        com.tencent.mm.plugin.game.f.d.a(this.kQq);
        ((c)g.r(c.class)).aYg().b(this.kQq.field_appId, this.kQo);
      }
      return;
    }
    String str = this.kQq.field_appId;
    if (this.kQo.kUu != null) {}
    for (localObject = this.kQo.kUu.kVU;; localObject = null)
    {
      this.kQr = new ab(str, (List)localObject);
      break;
    }
  }
  
  public final LinkedList<GameMediaList.a> aZA()
  {
    LinkedList localLinkedList = new LinkedList();
    if ((this.kQo.kUr == null) || (this.kQo.kUr.kVy == null)) {
      return localLinkedList;
    }
    Iterator localIterator = this.kQo.kUr.kVy.iterator();
    while (localIterator.hasNext())
    {
      ck localck = (ck)localIterator.next();
      GameMediaList.a locala = new GameMediaList.a();
      locala.type = localck.kVG;
      locala.ldq = localck.kVH;
      locala.url = localck.kVI;
      localLinkedList.add(locala);
    }
    return localLinkedList;
  }
  
  public final String aZB()
  {
    if ((this.kQo.kUr == null) || (this.kQo.kUr.bGw == null)) {
      return null;
    }
    return this.kQo.kUr.bGw;
  }
  
  public final String aZC()
  {
    if ((this.kQo.kUr == null) || (this.kQo.kUr.kSY == null)) {
      return null;
    }
    return this.kQo.kUr.kSY;
  }
  
  public final String aZD()
  {
    if (this.kQo.kUs == null) {
      return null;
    }
    return this.kQo.kUs.bGw;
  }
  
  public final LinkedList<bv> aZE()
  {
    if (this.kQo.kUs == null) {
      return null;
    }
    return this.kQo.kUs.kVk;
  }
  
  public final String aZx()
  {
    if (this.kQo.kUy != null) {
      return this.kQo.kUy.title;
    }
    if (this.kQo.kUt != null) {
      return this.kQo.kUt.bGw;
    }
    return null;
  }
  
  public final LinkedList<aa.b> aZy()
  {
    LinkedList localLinkedList;
    Iterator localIterator;
    Object localObject;
    aa.b localb;
    if ((this.kQo.kUy != null) && (this.kQo.kUy.ioT != null))
    {
      localLinkedList = new LinkedList();
      localIterator = this.kQo.kUy.ioT.iterator();
      while (localIterator.hasNext())
      {
        localObject = (by)localIterator.next();
        localb = new aa.b();
        localb.bVO = ((by)localObject).bVO;
        localb.desc = ((by)localObject).desc;
        localLinkedList.add(localb);
      }
      return localLinkedList;
    }
    if ((this.kQo.kUt != null) && (this.kQo.kUt.kVf != null))
    {
      localLinkedList = new LinkedList();
      localIterator = this.kQo.kUt.kVf.iterator();
      while (localIterator.hasNext())
      {
        localObject = (bs)localIterator.next();
        localb = new aa.b();
        localb.bVO = ((bs)localObject).kVi;
        localb.title = ((bs)localObject).bGw;
        localb.desc = ((bs)localObject).kSY;
        localb.url = ((bs)localObject).kRS;
        localLinkedList.add(localb);
      }
      return localLinkedList;
    }
    return null;
  }
  
  public final int aZz()
  {
    if (this.kQo.kUy != null) {
      return 2;
    }
    return 1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.game.model.aa
 * JD-Core Version:    0.7.0.1
 */