package com.tencent.mm.openim.room.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.protocal.protobuf.cfn;
import com.tencent.mm.sdk.platformtools.ae;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public final class b$b
{
  public final List<String> dBi;
  public final List<String> dBk;
  public final List<String> dBl;
  public final List<String> fML;
  public final List<String> fMM;
  public final List<String> fMN;
  
  public b$b()
  {
    AppMethodBeat.i(151320);
    this.fML = new ArrayList();
    this.dBi = new ArrayList();
    this.fMM = new ArrayList();
    this.dBk = new ArrayList();
    this.dBl = new ArrayList();
    this.fMN = new ArrayList();
    AppMethodBeat.o(151320);
  }
  
  public final void q(LinkedList<cfn> paramLinkedList)
  {
    AppMethodBeat.i(151321);
    paramLinkedList = paramLinkedList.iterator();
    while (paramLinkedList.hasNext())
    {
      cfn localcfn = (cfn)paramLinkedList.next();
      int i = localcfn.status;
      if (i == 0)
      {
        this.fML.add(localcfn.userName);
      }
      else if (i == 3)
      {
        ae.d("OpenIMChatRoomMember.Classifier", " blacklist : " + localcfn.userName);
        this.fMM.add(localcfn.userName);
      }
      else if (i == 1)
      {
        ae.d("OpenIMChatRoomMember.Classifier", " not user : " + localcfn.userName);
        this.dBk.add(localcfn.userName);
      }
      else if (i == 2)
      {
        ae.d("OpenIMChatRoomMember.Classifier", " invalid username : " + localcfn.userName);
        this.dBi.add(localcfn.userName);
      }
      else if (i == 4)
      {
        ae.d("OpenIMChatRoomMember.Classifier", " verify user : " + localcfn.userName);
        this.dBl.add(localcfn.userName);
      }
      else if (i != 5)
      {
        if (i == 6) {
          this.fMN.add(localcfn.userName);
        } else {
          ae.w("OpenIMChatRoomMember.Classifier", "unknown member status : status = ".concat(String.valueOf(i)));
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