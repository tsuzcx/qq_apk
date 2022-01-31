package com.tencent.mm.chatroom.c;

import com.tencent.mm.ah.b;
import com.tencent.mm.ah.b.a;
import com.tencent.mm.ah.b.b;
import com.tencent.mm.ah.b.c;
import com.tencent.mm.ah.f;
import com.tencent.mm.network.e;
import com.tencent.mm.network.k;
import com.tencent.mm.network.q;
import com.tencent.mm.platformtools.aa;
import com.tencent.mm.protocal.c.sp;
import com.tencent.mm.protocal.c.sq;
import com.tencent.mm.protocal.c.sy;
import com.tencent.mm.protocal.k.e;
import com.tencent.mm.sdk.platformtools.y;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public final class h
  extends com.tencent.mm.ah.m
  implements k
{
  public List<String> bSN;
  private b dmK;
  private f dmL;
  
  public h(String paramString, List<String> paramList, int paramInt)
  {
    Object localObject = new b.a();
    ((b.a)localObject).ecH = new sp();
    ((b.a)localObject).ecI = new sq();
    ((b.a)localObject).uri = "/cgi-bin/micromsg-bin/delchatroommember";
    ((b.a)localObject).ecG = 179;
    ((b.a)localObject).ecJ = 0;
    ((b.a)localObject).ecK = 0;
    this.dmK = ((b.a)localObject).Kt();
    localObject = (sp)this.dmK.ecE.ecN;
    ((sp)localObject).svm = paramString;
    paramString = new LinkedList();
    Iterator localIterator = paramList.iterator();
    while (localIterator.hasNext())
    {
      String str = (String)localIterator.next();
      sy localsy = new sy();
      localsy.sQx = aa.pj(str);
      paramString.add(localsy);
    }
    ((sp)localObject).svo = paramString;
    ((sp)localObject).dne = paramString.size();
    ((sp)localObject).pyo = paramInt;
    this.bSN = paramList;
  }
  
  public final int a(e parame, f paramf)
  {
    this.dmL = paramf;
    return a(parame, this.dmK, this);
  }
  
  public final void a(int paramInt1, int paramInt2, int paramInt3, String paramString, q paramq, byte[] paramArrayOfByte)
  {
    y.d("MicroMsg.NetSceneDelChatRoomMember", "netId : " + paramInt1 + " errType :" + paramInt2 + " errCode: " + paramInt3 + " errMsg :" + paramString);
    paramq = (sp)this.dmK.ecE.ecN;
    paramArrayOfByte = (sq)this.dmK.ecF.ecN;
    if (this.dmK.ecF.spN != 0)
    {
      this.dmL.onSceneEnd(paramInt2, paramInt3, paramString, this);
      return;
    }
    com.tencent.mm.model.m.a(paramq.svm, paramArrayOfByte);
    this.dmL.onSceneEnd(paramInt2, paramInt3, paramString, this);
  }
  
  public final int getType()
  {
    return 179;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.chatroom.c.h
 * JD-Core Version:    0.7.0.1
 */