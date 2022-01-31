package com.tencent.mm.openim.room.a;

import com.tencent.mm.protocal.c.bbb;
import com.tencent.mm.sdk.platformtools.y;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public final class b$b
{
  public final List<String> bSQ = new ArrayList();
  public final List<String> bSS = new ArrayList();
  public final List<String> bST = new ArrayList();
  public final List<String> dmM = new ArrayList();
  public final List<String> dmN = new ArrayList();
  public final List<String> dmO = new ArrayList();
  
  public final void q(LinkedList<bbb> paramLinkedList)
  {
    paramLinkedList = paramLinkedList.iterator();
    while (paramLinkedList.hasNext())
    {
      bbb localbbb = (bbb)paramLinkedList.next();
      int i = localbbb.status;
      if (i == 0)
      {
        this.dmM.add(localbbb.userName);
      }
      else if (i == 3)
      {
        y.d("OpenIMChatRoomMember.Classifier", " blacklist : " + localbbb.userName);
        this.dmN.add(localbbb.userName);
      }
      else if (i == 1)
      {
        y.d("OpenIMChatRoomMember.Classifier", " not user : " + localbbb.userName);
        this.bSS.add(localbbb.userName);
      }
      else if (i == 2)
      {
        y.d("OpenIMChatRoomMember.Classifier", " invalid username : " + localbbb.userName);
        this.bSQ.add(localbbb.userName);
      }
      else if (i == 4)
      {
        y.d("OpenIMChatRoomMember.Classifier", " verify user : " + localbbb.userName);
        this.bST.add(localbbb.userName);
      }
      else if (i != 5)
      {
        if (i == 6) {
          this.dmO.add(localbbb.userName);
        } else {
          y.w("OpenIMChatRoomMember.Classifier", "unknown member status : status = " + i);
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.openim.room.a.b.b
 * JD-Core Version:    0.7.0.1
 */