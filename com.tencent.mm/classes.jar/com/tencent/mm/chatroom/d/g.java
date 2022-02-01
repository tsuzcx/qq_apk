package com.tencent.mm.chatroom.d;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.b;
import com.tencent.mm.ak.b.a;
import com.tencent.mm.ak.b.b;
import com.tencent.mm.ak.b.c;
import com.tencent.mm.ak.f;
import com.tencent.mm.chatroom.ui.ChatroomInfoUI.LocalHistoryInfo;
import com.tencent.mm.model.r;
import com.tencent.mm.network.e;
import com.tencent.mm.network.k;
import com.tencent.mm.network.q;
import com.tencent.mm.platformtools.z;
import com.tencent.mm.protocal.protobuf.boz;
import com.tencent.mm.protocal.protobuf.bzm;
import com.tencent.mm.protocal.protobuf.bzn;
import com.tencent.mm.protocal.protobuf.cj;
import com.tencent.mm.protocal.protobuf.ck;
import com.tencent.mm.roomsdk.a.b.c;
import com.tencent.mm.sdk.platformtools.ae;
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
  private int dAb;
  public final List<String> dBf;
  private final List<String> dBi;
  private final List<String> dBk;
  private final List<String> dBl;
  private final List<String> fML;
  private final List<String> fMM;
  private final List<String> fMN;
  private final b rr;
  
  public g(String paramString1, List<String> paramList, String paramString2, Object paramObject)
  {
    AppMethodBeat.i(217109);
    this.callback = null;
    this.dAb = 0;
    this.chatroomName = null;
    Object localObject = new b.a();
    ((b.a)localObject).hQF = new cj();
    ((b.a)localObject).hQG = new ck();
    ((b.a)localObject).uri = "/cgi-bin/micromsg-bin/addchatroommember";
    ((b.a)localObject).funcId = 120;
    ((b.a)localObject).hQH = 36;
    ((b.a)localObject).respCmdId = 1000000036;
    this.rr = ((b.a)localObject).aDS();
    localObject = (cj)this.rr.hQD.hQJ;
    ((cj)localObject).FNm = z.Jw(paramString1);
    this.chatroomName = paramString1;
    paramString1 = new LinkedList();
    Iterator localIterator = paramList.iterator();
    while (localIterator.hasNext())
    {
      String str = (String)localIterator.next();
      bzm localbzm = new bzm();
      localbzm.GuK = z.Jw(str);
      paramString1.add(localbzm);
    }
    ((cj)localObject).FNl = paramString1;
    ((cj)localObject).fNf = paramString1.size();
    this.fML = new ArrayList();
    this.dBi = new LinkedList();
    this.fMM = new LinkedList();
    this.dBk = new LinkedList();
    this.dBl = new LinkedList();
    this.fMN = new ArrayList();
    this.dBf = paramList;
    ((cj)localObject).FNo = paramString2;
    if ((paramObject instanceof ChatroomInfoUI.LocalHistoryInfo))
    {
      ae.i("MicroMsg.NetSceneAddChatRoomMember", "localHistoryInfo:%s", new Object[] { paramObject.toString() });
      ((cj)localObject).FNp = new boz();
      ((cj)localObject).FNp.fileid = ((ChatroomInfoUI.LocalHistoryInfo)paramObject).fileid;
      ((cj)localObject).FNp.aeskey = ((ChatroomInfoUI.LocalHistoryInfo)paramObject).aeskey;
      ((cj)localObject).FNp.filemd5 = ((ChatroomInfoUI.LocalHistoryInfo)paramObject).filemd5;
      ((cj)localObject).FNp.fPH = ((ChatroomInfoUI.LocalHistoryInfo)paramObject).fPH;
      ((cj)localObject).FNp.fPI = ((ChatroomInfoUI.LocalHistoryInfo)paramObject).fPI;
    }
    AppMethodBeat.o(217109);
  }
  
  private int N(List<bzn> paramList)
  {
    AppMethodBeat.i(217110);
    int j = 0;
    int k = 0;
    if (j < paramList.size())
    {
      int m = ((bzn)paramList.get(j)).Hns;
      int i;
      if (m == 0)
      {
        this.fML.add(z.a(((bzn)paramList.get(j)).GuK));
        i = k;
      }
      for (;;)
      {
        j += 1;
        k = i;
        break;
        if (m == 3)
        {
          ae.d("MicroMsg.NetSceneAddChatRoomMember", " blacklist : " + ((bzn)paramList.get(j)).GuK);
          this.fMM.add(z.a(((bzn)paramList.get(j)).GuK));
          i = -22;
        }
        else if (m == 1)
        {
          ae.d("MicroMsg.NetSceneAddChatRoomMember", " not user : " + ((bzn)paramList.get(j)).GuK);
          this.dBk.add(z.a(((bzn)paramList.get(j)).GuK));
          i = -4;
        }
        else if (m == 2)
        {
          ae.d("MicroMsg.NetSceneAddChatRoomMember", " invalid username : " + ((bzn)paramList.get(j)).GuK);
          i = -14;
          this.dBi.add(z.a(((bzn)paramList.get(j)).GuK));
        }
        else if (m == 4)
        {
          ae.d("MicroMsg.NetSceneAddChatRoomMember", " verify user : " + ((bzn)paramList.get(j)).GuK);
          i = -44;
          this.dBl.add(z.a(((bzn)paramList.get(j)).GuK));
        }
        else
        {
          i = k;
          if (m != 5) {
            if (m == 6)
            {
              this.fMN.add(z.a(((bzn)paramList.get(j)).GuK));
              i = k;
            }
            else
            {
              ae.w("MicroMsg.NetSceneAddChatRoomMember", "unknown member status : status = ".concat(String.valueOf(m)));
              i = k;
            }
          }
        }
      }
    }
    AppMethodBeat.o(217110);
    return k;
  }
  
  public final com.tencent.mm.roomsdk.a.b.a a(com.tencent.mm.roomsdk.a.b.a parama)
  {
    Object localObject = parama;
    if ((parama instanceof c))
    {
      localObject = (c)parama;
      ((c)localObject).chatroomName = this.chatroomName;
      ((c)localObject).dBi = this.dBi;
      ((c)localObject).dAb = this.dAb;
      ((c)localObject).dBf = this.dBf;
      ((c)localObject).fMM = this.fMM;
      ((c)localObject).fML = this.fML;
      ((c)localObject).dBk = this.dBk;
      ((c)localObject).fMN = this.fMN;
      ((c)localObject).dBl = this.dBl;
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
  
  public final void onGYNetEnd(int paramInt1, int paramInt2, int paramInt3, String paramString, q paramq, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(12457);
    ae.i("MicroMsg.NetSceneAddChatRoomMember", "onSceneEnd: errType = " + paramInt2 + " errCode = " + paramInt3 + " errMsg = " + paramString);
    updateDispatchId(paramInt1);
    paramq = (cj)this.rr.hQD.hQJ;
    paramArrayOfByte = (ck)this.rr.hQE.hQJ;
    this.dAb = paramArrayOfByte.fNf;
    N(paramArrayOfByte.FNl);
    this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
    if ((paramInt2 == 0) && (paramInt3 == 0)) {
      r.a(z.a(paramq.FNm), paramArrayOfByte);
    }
    AppMethodBeat.o(12457);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.chatroom.d.g
 * JD-Core Version:    0.7.0.1
 */