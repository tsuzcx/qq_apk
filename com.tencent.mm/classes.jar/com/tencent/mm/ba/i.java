package com.tencent.mm.ba;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.messenger.foundation.a.a.k.b;
import com.tencent.mm.protocal.protobuf.cga;
import com.tencent.mm.protocal.protobuf.cgb;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

@Deprecated
public final class i
  extends k.b
{
  private cgb jgm;
  
  public i(List<a> paramList)
  {
    super(36);
    AppMethodBeat.i(43056);
    LinkedList localLinkedList = new LinkedList();
    Iterator localIterator = paramList.iterator();
    while (localIterator.hasNext()) {
      localLinkedList.add(((a)localIterator.next()).jgn);
    }
    this.jgm = new cgb();
    this.jgm.oTz = paramList.size();
    this.jgm.oTA = localLinkedList;
    this.zqv = this.jgm;
    AppMethodBeat.o(43056);
  }
  
  public static final class a
  {
    cga jgn;
    private int key;
    private String value;
    
    public a()
    {
      AppMethodBeat.i(43054);
      this.key = 0;
      this.value = "";
      this.jgn = new cga();
      this.jgn.Cya = 0;
      this.jgn.Cyk = "";
      AppMethodBeat.o(43054);
    }
    
    public a(int paramInt, String paramString)
    {
      AppMethodBeat.i(43055);
      this.key = paramInt;
      this.value = paramString;
      this.jgn = new cga();
      this.jgn.Cya = paramInt;
      this.jgn.Cyk = paramString;
      AppMethodBeat.o(43055);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.ba.i
 * JD-Core Version:    0.7.0.1
 */