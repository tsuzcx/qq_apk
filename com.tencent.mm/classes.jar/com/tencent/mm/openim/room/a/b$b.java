package com.tencent.mm.openim.room.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.protocal.protobuf.cac;
import com.tencent.mm.sdk.platformtools.ac;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public final class b$b
{
  public final List<String> dop;
  public final List<String> dor;
  public final List<String> dos;
  public final List<String> fsi;
  public final List<String> fsj;
  public final List<String> fsk;
  
  public b$b()
  {
    AppMethodBeat.i(151320);
    this.fsi = new ArrayList();
    this.dop = new ArrayList();
    this.fsj = new ArrayList();
    this.dor = new ArrayList();
    this.dos = new ArrayList();
    this.fsk = new ArrayList();
    AppMethodBeat.o(151320);
  }
  
  public final void q(LinkedList<cac> paramLinkedList)
  {
    AppMethodBeat.i(151321);
    paramLinkedList = paramLinkedList.iterator();
    while (paramLinkedList.hasNext())
    {
      cac localcac = (cac)paramLinkedList.next();
      int i = localcac.status;
      if (i == 0)
      {
        this.fsi.add(localcac.userName);
      }
      else if (i == 3)
      {
        ac.d("OpenIMChatRoomMember.Classifier", " blacklist : " + localcac.userName);
        this.fsj.add(localcac.userName);
      }
      else if (i == 1)
      {
        ac.d("OpenIMChatRoomMember.Classifier", " not user : " + localcac.userName);
        this.dor.add(localcac.userName);
      }
      else if (i == 2)
      {
        ac.d("OpenIMChatRoomMember.Classifier", " invalid username : " + localcac.userName);
        this.dop.add(localcac.userName);
      }
      else if (i == 4)
      {
        ac.d("OpenIMChatRoomMember.Classifier", " verify user : " + localcac.userName);
        this.dos.add(localcac.userName);
      }
      else if (i != 5)
      {
        if (i == 6) {
          this.fsk.add(localcac.userName);
        } else {
          ac.w("OpenIMChatRoomMember.Classifier", "unknown member status : status = ".concat(String.valueOf(i)));
        }
      }
    }
    AppMethodBeat.o(151321);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.openim.room.a.b.b
 * JD-Core Version:    0.7.0.1
 */