package com.tencent.mm.openim.room.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.protocal.protobuf.dxg;
import com.tencent.mm.sdk.platformtools.Log;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public final class b$b
{
  public final List<String> hSd;
  public final List<String> hSf;
  public final List<String> hSg;
  public final List<String> lyj;
  public final List<String> lyk;
  public final List<String> lyl;
  
  public b$b()
  {
    AppMethodBeat.i(151320);
    this.lyj = new ArrayList();
    this.hSd = new ArrayList();
    this.lyk = new ArrayList();
    this.hSf = new ArrayList();
    this.hSg = new ArrayList();
    this.lyl = new ArrayList();
    AppMethodBeat.o(151320);
  }
  
  public final void q(LinkedList<dxg> paramLinkedList)
  {
    AppMethodBeat.i(151321);
    paramLinkedList = paramLinkedList.iterator();
    while (paramLinkedList.hasNext())
    {
      dxg localdxg = (dxg)paramLinkedList.next();
      int i = localdxg.status;
      if (i == 0)
      {
        this.lyj.add(localdxg.userName);
      }
      else if (i == 3)
      {
        Log.d("OpenIMChatRoomMember.Classifier", " blacklist : " + localdxg.userName);
        this.lyk.add(localdxg.userName);
      }
      else if (i == 1)
      {
        Log.d("OpenIMChatRoomMember.Classifier", " not user : " + localdxg.userName);
        this.hSf.add(localdxg.userName);
      }
      else if (i == 2)
      {
        Log.d("OpenIMChatRoomMember.Classifier", " invalid username : " + localdxg.userName);
        this.hSd.add(localdxg.userName);
      }
      else if (i == 4)
      {
        Log.d("OpenIMChatRoomMember.Classifier", " verify user : " + localdxg.userName);
        this.hSg.add(localdxg.userName);
      }
      else if (i != 5)
      {
        if (i == 6) {
          this.lyl.add(localdxg.userName);
        } else {
          Log.w("OpenIMChatRoomMember.Classifier", "unknown member status : status = ".concat(String.valueOf(i)));
        }
      }
    }
    AppMethodBeat.o(151321);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.openim.room.a.b.b
 * JD-Core Version:    0.7.0.1
 */