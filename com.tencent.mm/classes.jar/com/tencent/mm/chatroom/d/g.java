package com.tencent.mm.chatroom.d;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.d;
import com.tencent.mm.ak.d.a;
import com.tencent.mm.ak.d.b;
import com.tencent.mm.ak.d.c;
import com.tencent.mm.ak.i;
import com.tencent.mm.chatroom.ui.ChatroomInfoUI.LocalHistoryInfo;
import com.tencent.mm.model.v;
import com.tencent.mm.network.m;
import com.tencent.mm.network.s;
import com.tencent.mm.platformtools.z;
import com.tencent.mm.protocal.protobuf.cbr;
import com.tencent.mm.protocal.protobuf.con;
import com.tencent.mm.protocal.protobuf.coo;
import com.tencent.mm.protocal.protobuf.cs;
import com.tencent.mm.protocal.protobuf.ct;
import com.tencent.mm.roomsdk.a.b.c;
import com.tencent.mm.sdk.platformtools.Log;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public final class g
  extends com.tencent.mm.roomsdk.a.a
  implements m
{
  private i callback;
  private String chatroomName;
  private int dRN;
  public final List<String> dSU;
  private final List<String> dSX;
  private final List<String> dSZ;
  private final List<String> dTa;
  private final List<String> grX;
  private final List<String> grY;
  private final List<String> grZ;
  private final d rr;
  
  public g(String paramString1, List<String> paramList, String paramString2, Object paramObject)
  {
    AppMethodBeat.i(194023);
    this.callback = null;
    this.dRN = 0;
    this.chatroomName = null;
    Object localObject = new d.a();
    ((d.a)localObject).iLN = new cs();
    ((d.a)localObject).iLO = new ct();
    ((d.a)localObject).uri = "/cgi-bin/micromsg-bin/addchatroommember";
    ((d.a)localObject).funcId = 120;
    ((d.a)localObject).iLP = 36;
    ((d.a)localObject).respCmdId = 1000000036;
    this.rr = ((d.a)localObject).aXF();
    localObject = (cs)this.rr.iLK.iLR;
    ((cs)localObject).KGR = z.Su(paramString1);
    this.chatroomName = paramString1;
    paramString1 = new LinkedList();
    Iterator localIterator = paramList.iterator();
    while (localIterator.hasNext())
    {
      String str = (String)localIterator.next();
      con localcon = new con();
      localcon.Lqp = z.Su(str);
      paramString1.add(localcon);
    }
    ((cs)localObject).KGQ = paramString1;
    ((cs)localObject).gsq = paramString1.size();
    this.grX = new ArrayList();
    this.dSX = new LinkedList();
    this.grY = new LinkedList();
    this.dSZ = new LinkedList();
    this.dTa = new LinkedList();
    this.grZ = new ArrayList();
    this.dSU = paramList;
    ((cs)localObject).KGT = paramString2;
    if ((paramObject instanceof ChatroomInfoUI.LocalHistoryInfo))
    {
      Log.i("MicroMsg.NetSceneAddChatRoomMember", "localHistoryInfo:%s", new Object[] { paramObject.toString() });
      ((cs)localObject).KGU = new cbr();
      ((cs)localObject).KGU.fileid = ((ChatroomInfoUI.LocalHistoryInfo)paramObject).fileid;
      ((cs)localObject).KGU.aeskey = ((ChatroomInfoUI.LocalHistoryInfo)paramObject).aeskey;
      ((cs)localObject).KGU.filemd5 = ((ChatroomInfoUI.LocalHistoryInfo)paramObject).filemd5;
      ((cs)localObject).KGU.guR = ((ChatroomInfoUI.LocalHistoryInfo)paramObject).guR;
      ((cs)localObject).KGU.guS = ((ChatroomInfoUI.LocalHistoryInfo)paramObject).guS;
    }
    AppMethodBeat.o(194023);
  }
  
  private int T(List<coo> paramList)
  {
    AppMethodBeat.i(194024);
    int j = 0;
    int k = 0;
    if (j < paramList.size())
    {
      int m = ((coo)paramList.get(j)).MuH;
      int i;
      if (m == 0)
      {
        this.grX.add(z.a(((coo)paramList.get(j)).Lqp));
        i = k;
      }
      for (;;)
      {
        j += 1;
        k = i;
        break;
        if (m == 3)
        {
          Log.d("MicroMsg.NetSceneAddChatRoomMember", " blacklist : " + ((coo)paramList.get(j)).Lqp);
          this.grY.add(z.a(((coo)paramList.get(j)).Lqp));
          i = -22;
        }
        else if (m == 1)
        {
          Log.d("MicroMsg.NetSceneAddChatRoomMember", " not user : " + ((coo)paramList.get(j)).Lqp);
          this.dSZ.add(z.a(((coo)paramList.get(j)).Lqp));
          i = -4;
        }
        else if (m == 2)
        {
          Log.d("MicroMsg.NetSceneAddChatRoomMember", " invalid username : " + ((coo)paramList.get(j)).Lqp);
          i = -14;
          this.dSX.add(z.a(((coo)paramList.get(j)).Lqp));
        }
        else if (m == 4)
        {
          Log.d("MicroMsg.NetSceneAddChatRoomMember", " verify user : " + ((coo)paramList.get(j)).Lqp);
          i = -44;
          this.dTa.add(z.a(((coo)paramList.get(j)).Lqp));
        }
        else
        {
          i = k;
          if (m != 5) {
            if (m == 6)
            {
              this.grZ.add(z.a(((coo)paramList.get(j)).Lqp));
              i = k;
            }
            else
            {
              Log.w("MicroMsg.NetSceneAddChatRoomMember", "unknown member status : status = ".concat(String.valueOf(m)));
              i = k;
            }
          }
        }
      }
    }
    AppMethodBeat.o(194024);
    return k;
  }
  
  public final com.tencent.mm.roomsdk.a.b.a a(com.tencent.mm.roomsdk.a.b.a parama)
  {
    Object localObject = parama;
    if ((parama instanceof c))
    {
      localObject = (c)parama;
      ((c)localObject).chatroomName = this.chatroomName;
      ((c)localObject).dSX = this.dSX;
      ((c)localObject).dRN = this.dRN;
      ((c)localObject).dSU = this.dSU;
      ((c)localObject).grY = this.grY;
      ((c)localObject).grX = this.grX;
      ((c)localObject).dSZ = this.dSZ;
      ((c)localObject).grZ = this.grZ;
      ((c)localObject).dTa = this.dTa;
    }
    return localObject;
  }
  
  public final int doScene(com.tencent.mm.network.g paramg, i parami)
  {
    AppMethodBeat.i(12456);
    this.callback = parami;
    int i = dispatch(paramg, this.rr, this);
    AppMethodBeat.o(12456);
    return i;
  }
  
  public final int getType()
  {
    return 120;
  }
  
  public final void onGYNetEnd(int paramInt1, int paramInt2, int paramInt3, String paramString, s params, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(12457);
    Log.i("MicroMsg.NetSceneAddChatRoomMember", "onSceneEnd: errType = " + paramInt2 + " errCode = " + paramInt3 + " errMsg = " + paramString);
    updateDispatchId(paramInt1);
    params = (cs)this.rr.iLK.iLR;
    paramArrayOfByte = (ct)this.rr.iLL.iLR;
    this.dRN = paramArrayOfByte.gsq;
    T(paramArrayOfByte.KGQ);
    this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
    if ((paramInt2 == 0) && (paramInt3 == 0)) {
      v.a(z.a(params.KGR), paramArrayOfByte);
    }
    AppMethodBeat.o(12457);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.chatroom.d.g
 * JD-Core Version:    0.7.0.1
 */