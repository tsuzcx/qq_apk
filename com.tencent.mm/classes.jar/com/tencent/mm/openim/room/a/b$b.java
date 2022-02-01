package com.tencent.mm.openim.room.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.protocal.protobuf.dfe;
import com.tencent.mm.sdk.platformtools.Log;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public final class b$b
{
  public final List<String> fMt;
  public final List<String> fMv;
  public final List<String> fMw;
  public final List<String> iWi;
  public final List<String> iWj;
  public final List<String> iWk;
  
  public b$b()
  {
    AppMethodBeat.i(151320);
    this.iWi = new ArrayList();
    this.fMt = new ArrayList();
    this.iWj = new ArrayList();
    this.fMv = new ArrayList();
    this.fMw = new ArrayList();
    this.iWk = new ArrayList();
    AppMethodBeat.o(151320);
  }
  
  public final void q(LinkedList<dfe> paramLinkedList)
  {
    AppMethodBeat.i(151321);
    paramLinkedList = paramLinkedList.iterator();
    while (paramLinkedList.hasNext())
    {
      dfe localdfe = (dfe)paramLinkedList.next();
      int i = localdfe.status;
      if (i == 0)
      {
        this.iWi.add(localdfe.userName);
      }
      else if (i == 3)
      {
        Log.d("OpenIMChatRoomMember.Classifier", " blacklist : " + localdfe.userName);
        this.iWj.add(localdfe.userName);
      }
      else if (i == 1)
      {
        Log.d("OpenIMChatRoomMember.Classifier", " not user : " + localdfe.userName);
        this.fMv.add(localdfe.userName);
      }
      else if (i == 2)
      {
        Log.d("OpenIMChatRoomMember.Classifier", " invalid username : " + localdfe.userName);
        this.fMt.add(localdfe.userName);
      }
      else if (i == 4)
      {
        Log.d("OpenIMChatRoomMember.Classifier", " verify user : " + localdfe.userName);
        this.fMw.add(localdfe.userName);
      }
      else if (i != 5)
      {
        if (i == 6) {
          this.iWk.add(localdfe.userName);
        } else {
          Log.w("OpenIMChatRoomMember.Classifier", "unknown member status : status = ".concat(String.valueOf(i)));
        }
      }
    }
    AppMethodBeat.o(151321);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.openim.room.a.b.b
 * JD-Core Version:    0.7.0.1
 */