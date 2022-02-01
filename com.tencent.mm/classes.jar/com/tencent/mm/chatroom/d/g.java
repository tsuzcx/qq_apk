package com.tencent.mm.chatroom.d;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.al.b;
import com.tencent.mm.al.b.a;
import com.tencent.mm.al.b.b;
import com.tencent.mm.al.b.c;
import com.tencent.mm.al.f;
import com.tencent.mm.chatroom.ui.ChatroomInfoUI.LocalHistoryInfo;
import com.tencent.mm.network.e;
import com.tencent.mm.network.k;
import com.tencent.mm.platformtools.z;
import com.tencent.mm.protocal.protobuf.boh;
import com.tencent.mm.protocal.protobuf.bys;
import com.tencent.mm.protocal.protobuf.byt;
import com.tencent.mm.protocal.protobuf.cj;
import com.tencent.mm.protocal.protobuf.ck;
import com.tencent.mm.roomsdk.a.b.c;
import com.tencent.mm.sdk.platformtools.ad;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public final class g
  extends com.tencent.mm.roomsdk.a.a
  implements k
{
  private f callback;
  private String chatroomName;
  public final List<String> dAa;
  private final List<String> dAd;
  private final List<String> dAf;
  private final List<String> dAg;
  private int dyW;
  private final List<String> fKI;
  private final List<String> fKJ;
  private final List<String> fKK;
  private final b rr;
  
  public g(String paramString1, List<String> paramList, String paramString2, Object paramObject)
  {
    AppMethodBeat.i(213397);
    this.callback = null;
    this.dyW = 0;
    this.chatroomName = null;
    Object localObject = new b.a();
    ((b.a)localObject).hNM = new cj();
    ((b.a)localObject).hNN = new ck();
    ((b.a)localObject).uri = "/cgi-bin/micromsg-bin/addchatroommember";
    ((b.a)localObject).funcId = 120;
    ((b.a)localObject).hNO = 36;
    ((b.a)localObject).respCmdId = 1000000036;
    this.rr = ((b.a)localObject).aDC();
    localObject = (cj)this.rr.hNK.hNQ;
    ((cj)localObject).FuO = z.IX(paramString1);
    this.chatroomName = paramString1;
    paramString1 = new LinkedList();
    Iterator localIterator = paramList.iterator();
    while (localIterator.hasNext())
    {
      String str = (String)localIterator.next();
      bys localbys = new bys();
      localbys.Gcd = z.IX(str);
      paramString1.add(localbys);
    }
    ((cj)localObject).FuN = paramString1;
    ((cj)localObject).fLb = paramString1.size();
    this.fKI = new ArrayList();
    this.dAd = new LinkedList();
    this.fKJ = new LinkedList();
    this.dAf = new LinkedList();
    this.dAg = new LinkedList();
    this.fKK = new ArrayList();
    this.dAa = paramList;
    ((cj)localObject).FuQ = paramString2;
    if ((paramObject instanceof ChatroomInfoUI.LocalHistoryInfo))
    {
      ad.i("MicroMsg.NetSceneAddChatRoomMember", "localHistoryInfo:%s", new Object[] { paramObject.toString() });
      ((cj)localObject).FuR = new boh();
      ((cj)localObject).FuR.fileid = ((ChatroomInfoUI.LocalHistoryInfo)paramObject).fileid;
      ((cj)localObject).FuR.aeskey = ((ChatroomInfoUI.LocalHistoryInfo)paramObject).aeskey;
      ((cj)localObject).FuR.filemd5 = ((ChatroomInfoUI.LocalHistoryInfo)paramObject).filemd5;
      ((cj)localObject).FuR.fNA = ((ChatroomInfoUI.LocalHistoryInfo)paramObject).fNA;
      ((cj)localObject).FuR.fNB = ((ChatroomInfoUI.LocalHistoryInfo)paramObject).fNB;
    }
    AppMethodBeat.o(213397);
  }
  
  private int N(List<byt> paramList)
  {
    AppMethodBeat.i(213398);
    int j = 0;
    int k = 0;
    if (j < paramList.size())
    {
      int m = ((byt)paramList.get(j)).GTR;
      int i;
      if (m == 0)
      {
        this.fKI.add(z.a(((byt)paramList.get(j)).Gcd));
        i = k;
      }
      for (;;)
      {
        j += 1;
        k = i;
        break;
        if (m == 3)
        {
          ad.d("MicroMsg.NetSceneAddChatRoomMember", " blacklist : " + ((byt)paramList.get(j)).Gcd);
          this.fKJ.add(z.a(((byt)paramList.get(j)).Gcd));
          i = -22;
        }
        else if (m == 1)
        {
          ad.d("MicroMsg.NetSceneAddChatRoomMember", " not user : " + ((byt)paramList.get(j)).Gcd);
          this.dAf.add(z.a(((byt)paramList.get(j)).Gcd));
          i = -4;
        }
        else if (m == 2)
        {
          ad.d("MicroMsg.NetSceneAddChatRoomMember", " invalid username : " + ((byt)paramList.get(j)).Gcd);
          i = -14;
          this.dAd.add(z.a(((byt)paramList.get(j)).Gcd));
        }
        else if (m == 4)
        {
          ad.d("MicroMsg.NetSceneAddChatRoomMember", " verify user : " + ((byt)paramList.get(j)).Gcd);
          i = -44;
          this.dAg.add(z.a(((byt)paramList.get(j)).Gcd));
        }
        else
        {
          i = k;
          if (m != 5) {
            if (m == 6)
            {
              this.fKK.add(z.a(((byt)paramList.get(j)).Gcd));
              i = k;
            }
            else
            {
              ad.w("MicroMsg.NetSceneAddChatRoomMember", "unknown member status : status = ".concat(String.valueOf(m)));
              i = k;
            }
          }
        }
      }
    }
    AppMethodBeat.o(213398);
    return k;
  }
  
  public final com.tencent.mm.roomsdk.a.b.a a(com.tencent.mm.roomsdk.a.b.a parama)
  {
    Object localObject = parama;
    if ((parama instanceof c))
    {
      localObject = (c)parama;
      ((c)localObject).chatroomName = this.chatroomName;
      ((c)localObject).dAd = this.dAd;
      ((c)localObject).dyW = this.dyW;
      ((c)localObject).dAa = this.dAa;
      ((c)localObject).fKJ = this.fKJ;
      ((c)localObject).fKI = this.fKI;
      ((c)localObject).dAf = this.dAf;
      ((c)localObject).fKK = this.fKK;
      ((c)localObject).dAg = this.dAg;
    }
    return localObject;
  }
  
  public final int doScene(e parame, f paramf)
  {
    AppMethodBeat.i(12456);
    this.callback = paramf;
    int i = dispatch(parame, this.rr, this);
    AppMethodBeat.o(12456);
    return i;
  }
  
  public final int getType()
  {
    return 120;
  }
  
  public final void onGYNetEnd(int paramInt1, int paramInt2, int paramInt3, String paramString, com.tencent.mm.network.q paramq, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(12457);
    ad.i("MicroMsg.NetSceneAddChatRoomMember", "onSceneEnd: errType = " + paramInt2 + " errCode = " + paramInt3 + " errMsg = " + paramString);
    updateDispatchId(paramInt1);
    paramq = (cj)this.rr.hNK.hNQ;
    paramArrayOfByte = (ck)this.rr.hNL.hNQ;
    this.dyW = paramArrayOfByte.fLb;
    N(paramArrayOfByte.FuN);
    this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
    if ((paramInt2 == 0) && (paramInt3 == 0)) {
      com.tencent.mm.model.q.a(z.a(paramq.FuO), paramArrayOfByte);
    }
    AppMethodBeat.o(12457);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.chatroom.d.g
 * JD-Core Version:    0.7.0.1
 */