package com.tencent.mm.openim.room.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.protocal.protobuf.bib;
import com.tencent.mm.sdk.platformtools.ab;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public final class b$b
{
  public final List<String> cAv;
  public final List<String> cAx;
  public final List<String> cAy;
  public final List<String> een;
  public final List<String> eeo;
  public final List<String> eep;
  
  public b$b()
  {
    AppMethodBeat.i(78976);
    this.een = new ArrayList();
    this.cAv = new ArrayList();
    this.eeo = new ArrayList();
    this.cAx = new ArrayList();
    this.cAy = new ArrayList();
    this.eep = new ArrayList();
    AppMethodBeat.o(78976);
  }
  
  public final void q(LinkedList<bib> paramLinkedList)
  {
    AppMethodBeat.i(78977);
    paramLinkedList = paramLinkedList.iterator();
    while (paramLinkedList.hasNext())
    {
      bib localbib = (bib)paramLinkedList.next();
      int i = localbib.status;
      if (i == 0)
      {
        this.een.add(localbib.userName);
      }
      else if (i == 3)
      {
        ab.d("OpenIMChatRoomMember.Classifier", " blacklist : " + localbib.userName);
        this.eeo.add(localbib.userName);
      }
      else if (i == 1)
      {
        ab.d("OpenIMChatRoomMember.Classifier", " not user : " + localbib.userName);
        this.cAx.add(localbib.userName);
      }
      else if (i == 2)
      {
        ab.d("OpenIMChatRoomMember.Classifier", " invalid username : " + localbib.userName);
        this.cAv.add(localbib.userName);
      }
      else if (i == 4)
      {
        ab.d("OpenIMChatRoomMember.Classifier", " verify user : " + localbib.userName);
        this.cAy.add(localbib.userName);
      }
      else if (i != 5)
      {
        if (i == 6) {
          this.eep.add(localbib.userName);
        } else {
          ab.w("OpenIMChatRoomMember.Classifier", "unknown member status : status = ".concat(String.valueOf(i)));
        }
      }
    }
    AppMethodBeat.o(78977);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.openim.room.a.b.b
 * JD-Core Version:    0.7.0.1
 */