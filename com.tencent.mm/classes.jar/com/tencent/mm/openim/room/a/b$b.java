package com.tencent.mm.openim.room.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.protocal.protobuf.cet;
import com.tencent.mm.sdk.platformtools.ad;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public final class b$b
{
  public final List<String> dAd;
  public final List<String> dAf;
  public final List<String> dAg;
  public final List<String> fKI;
  public final List<String> fKJ;
  public final List<String> fKK;
  
  public b$b()
  {
    AppMethodBeat.i(151320);
    this.fKI = new ArrayList();
    this.dAd = new ArrayList();
    this.fKJ = new ArrayList();
    this.dAf = new ArrayList();
    this.dAg = new ArrayList();
    this.fKK = new ArrayList();
    AppMethodBeat.o(151320);
  }
  
  public final void q(LinkedList<cet> paramLinkedList)
  {
    AppMethodBeat.i(151321);
    paramLinkedList = paramLinkedList.iterator();
    while (paramLinkedList.hasNext())
    {
      cet localcet = (cet)paramLinkedList.next();
      int i = localcet.status;
      if (i == 0)
      {
        this.fKI.add(localcet.userName);
      }
      else if (i == 3)
      {
        ad.d("OpenIMChatRoomMember.Classifier", " blacklist : " + localcet.userName);
        this.fKJ.add(localcet.userName);
      }
      else if (i == 1)
      {
        ad.d("OpenIMChatRoomMember.Classifier", " not user : " + localcet.userName);
        this.dAf.add(localcet.userName);
      }
      else if (i == 2)
      {
        ad.d("OpenIMChatRoomMember.Classifier", " invalid username : " + localcet.userName);
        this.dAd.add(localcet.userName);
      }
      else if (i == 4)
      {
        ad.d("OpenIMChatRoomMember.Classifier", " verify user : " + localcet.userName);
        this.dAg.add(localcet.userName);
      }
      else if (i != 5)
      {
        if (i == 6) {
          this.fKK.add(localcet.userName);
        } else {
          ad.w("OpenIMChatRoomMember.Classifier", "unknown member status : status = ".concat(String.valueOf(i)));
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