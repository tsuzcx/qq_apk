package com.tencent.mm.ay;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.messenger.foundation.a.a.k.b;
import com.tencent.mm.protocal.protobuf.dfq;
import com.tencent.mm.protocal.protobuf.dfr;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

@Deprecated
public final class i
  extends k.b
{
  private dfr oPR;
  
  public i(List<a> paramList)
  {
    super(36);
    AppMethodBeat.i(43056);
    LinkedList localLinkedList = new LinkedList();
    Iterator localIterator = paramList.iterator();
    while (localIterator.hasNext()) {
      localLinkedList.add(((a)localIterator.next()).oPS);
    }
    this.oPR = new dfr();
    this.oPR.vgN = paramList.size();
    this.oPR.vgO = localLinkedList;
    this.KRu = this.oPR;
    AppMethodBeat.o(43056);
  }
  
  public static final class a
  {
    private int key;
    dfq oPS;
    private String value;
    
    public a()
    {
      AppMethodBeat.i(43054);
      this.key = 0;
      this.value = "";
      this.oPS = new dfq();
      this.oPS.OzG = 0;
      this.oPS.OzQ = "";
      AppMethodBeat.o(43054);
    }
    
    public a(int paramInt, String paramString)
    {
      AppMethodBeat.i(43055);
      this.key = paramInt;
      this.value = paramString;
      this.oPS = new dfq();
      this.oPS.OzG = paramInt;
      this.oPS.OzQ = paramString;
      AppMethodBeat.o(43055);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.ay.i
 * JD-Core Version:    0.7.0.1
 */