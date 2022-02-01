package com.tencent.mm.openim.room.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.protocal.protobuf.bvk;
import com.tencent.mm.sdk.platformtools.ad;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public final class b$b
{
  public final List<String> dqE;
  public final List<String> dqG;
  public final List<String> dqH;
  public final List<String> foI;
  public final List<String> foJ;
  public final List<String> foK;
  
  public b$b()
  {
    AppMethodBeat.i(151320);
    this.foI = new ArrayList();
    this.dqE = new ArrayList();
    this.foJ = new ArrayList();
    this.dqG = new ArrayList();
    this.dqH = new ArrayList();
    this.foK = new ArrayList();
    AppMethodBeat.o(151320);
  }
  
  public final void q(LinkedList<bvk> paramLinkedList)
  {
    AppMethodBeat.i(151321);
    paramLinkedList = paramLinkedList.iterator();
    while (paramLinkedList.hasNext())
    {
      bvk localbvk = (bvk)paramLinkedList.next();
      int i = localbvk.status;
      if (i == 0)
      {
        this.foI.add(localbvk.userName);
      }
      else if (i == 3)
      {
        ad.d("OpenIMChatRoomMember.Classifier", " blacklist : " + localbvk.userName);
        this.foJ.add(localbvk.userName);
      }
      else if (i == 1)
      {
        ad.d("OpenIMChatRoomMember.Classifier", " not user : " + localbvk.userName);
        this.dqG.add(localbvk.userName);
      }
      else if (i == 2)
      {
        ad.d("OpenIMChatRoomMember.Classifier", " invalid username : " + localbvk.userName);
        this.dqE.add(localbvk.userName);
      }
      else if (i == 4)
      {
        ad.d("OpenIMChatRoomMember.Classifier", " verify user : " + localbvk.userName);
        this.dqH.add(localbvk.userName);
      }
      else if (i != 5)
      {
        if (i == 6) {
          this.foK.add(localbvk.userName);
        } else {
          ad.w("OpenIMChatRoomMember.Classifier", "unknown member status : status = ".concat(String.valueOf(i)));
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