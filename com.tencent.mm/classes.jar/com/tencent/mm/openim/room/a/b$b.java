package com.tencent.mm.openim.room.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.protocal.protobuf.cvu;
import com.tencent.mm.sdk.platformtools.Log;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public final class b$b
{
  public final List<String> dSX;
  public final List<String> dSZ;
  public final List<String> dTa;
  public final List<String> grX;
  public final List<String> grY;
  public final List<String> grZ;
  
  public b$b()
  {
    AppMethodBeat.i(151320);
    this.grX = new ArrayList();
    this.dSX = new ArrayList();
    this.grY = new ArrayList();
    this.dSZ = new ArrayList();
    this.dTa = new ArrayList();
    this.grZ = new ArrayList();
    AppMethodBeat.o(151320);
  }
  
  public final void q(LinkedList<cvu> paramLinkedList)
  {
    AppMethodBeat.i(151321);
    paramLinkedList = paramLinkedList.iterator();
    while (paramLinkedList.hasNext())
    {
      cvu localcvu = (cvu)paramLinkedList.next();
      int i = localcvu.status;
      if (i == 0)
      {
        this.grX.add(localcvu.userName);
      }
      else if (i == 3)
      {
        Log.d("OpenIMChatRoomMember.Classifier", " blacklist : " + localcvu.userName);
        this.grY.add(localcvu.userName);
      }
      else if (i == 1)
      {
        Log.d("OpenIMChatRoomMember.Classifier", " not user : " + localcvu.userName);
        this.dSZ.add(localcvu.userName);
      }
      else if (i == 2)
      {
        Log.d("OpenIMChatRoomMember.Classifier", " invalid username : " + localcvu.userName);
        this.dSX.add(localcvu.userName);
      }
      else if (i == 4)
      {
        Log.d("OpenIMChatRoomMember.Classifier", " verify user : " + localcvu.userName);
        this.dTa.add(localcvu.userName);
      }
      else if (i != 5)
      {
        if (i == 6) {
          this.grZ.add(localcvu.userName);
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