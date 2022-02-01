package com.tencent.mm.chatroom.d;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.an.d;
import com.tencent.mm.an.d.a;
import com.tencent.mm.an.d.b;
import com.tencent.mm.an.d.c;
import com.tencent.mm.an.i;
import com.tencent.mm.chatroom.ui.ChatroomInfoUI.LocalHistoryInfo;
import com.tencent.mm.model.v;
import com.tencent.mm.network.m;
import com.tencent.mm.network.s;
import com.tencent.mm.platformtools.z;
import com.tencent.mm.protocal.protobuf.cju;
import com.tencent.mm.protocal.protobuf.cr;
import com.tencent.mm.protocal.protobuf.cs;
import com.tencent.mm.protocal.protobuf.cwz;
import com.tencent.mm.protocal.protobuf.cxa;
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
  private int fLk;
  public final List<String> fMr;
  private final List<String> fMt;
  private final List<String> fMv;
  private final List<String> fMw;
  private final List<String> iWi;
  private final List<String> iWj;
  private final List<String> iWk;
  private final d rr;
  
  public g(String paramString1, List<String> paramList, String paramString2, Object paramObject)
  {
    AppMethodBeat.i(189968);
    this.callback = null;
    this.fLk = 0;
    this.chatroomName = null;
    Object localObject = new d.a();
    ((d.a)localObject).lBU = new cr();
    ((d.a)localObject).lBV = new cs();
    ((d.a)localObject).uri = "/cgi-bin/micromsg-bin/addchatroommember";
    ((d.a)localObject).funcId = 120;
    ((d.a)localObject).lBW = 36;
    ((d.a)localObject).respCmdId = 1000000036;
    this.rr = ((d.a)localObject).bgN();
    localObject = (cr)d.b.b(this.rr.lBR);
    ((cr)localObject).RIl = z.ZW(paramString1);
    this.chatroomName = paramString1;
    paramString1 = new LinkedList();
    Iterator localIterator = paramList.iterator();
    while (localIterator.hasNext())
    {
      String str = (String)localIterator.next();
      cwz localcwz = new cwz();
      localcwz.SrM = z.ZW(str);
      paramString1.add(localcwz);
    }
    ((cr)localObject).RIk = paramString1;
    ((cr)localObject).iWB = paramString1.size();
    this.iWi = new ArrayList();
    this.fMt = new LinkedList();
    this.iWj = new LinkedList();
    this.fMv = new LinkedList();
    this.fMw = new LinkedList();
    this.iWk = new ArrayList();
    this.fMr = paramList;
    ((cr)localObject).RIn = paramString2;
    if ((paramObject instanceof ChatroomInfoUI.LocalHistoryInfo))
    {
      Log.i("MicroMsg.NetSceneAddChatRoomMember", "localHistoryInfo:%s", new Object[] { paramObject.toString() });
      ((cr)localObject).RIo = new cju();
      ((cr)localObject).RIo.fileid = ((ChatroomInfoUI.LocalHistoryInfo)paramObject).fileid;
      ((cr)localObject).RIo.aeskey = ((ChatroomInfoUI.LocalHistoryInfo)paramObject).aeskey;
      ((cr)localObject).RIo.filemd5 = ((ChatroomInfoUI.LocalHistoryInfo)paramObject).filemd5;
      ((cr)localObject).RIo.iZc = ((ChatroomInfoUI.LocalHistoryInfo)paramObject).iZc;
      ((cr)localObject).RIo.iZd = ((ChatroomInfoUI.LocalHistoryInfo)paramObject).iZd;
    }
    AppMethodBeat.o(189968);
  }
  
  private int Q(List<cxa> paramList)
  {
    AppMethodBeat.i(189997);
    int j = 0;
    int k = 0;
    if (j < paramList.size())
    {
      int m = ((cxa)paramList.get(j)).TFy;
      int i;
      if (m == 0)
      {
        this.iWi.add(z.a(((cxa)paramList.get(j)).SrM));
        i = k;
      }
      for (;;)
      {
        j += 1;
        k = i;
        break;
        if (m == 3)
        {
          Log.d("MicroMsg.NetSceneAddChatRoomMember", " blacklist : " + ((cxa)paramList.get(j)).SrM);
          this.iWj.add(z.a(((cxa)paramList.get(j)).SrM));
          i = -22;
        }
        else if (m == 1)
        {
          Log.d("MicroMsg.NetSceneAddChatRoomMember", " not user : " + ((cxa)paramList.get(j)).SrM);
          this.fMv.add(z.a(((cxa)paramList.get(j)).SrM));
          i = -4;
        }
        else if (m == 2)
        {
          Log.d("MicroMsg.NetSceneAddChatRoomMember", " invalid username : " + ((cxa)paramList.get(j)).SrM);
          i = -14;
          this.fMt.add(z.a(((cxa)paramList.get(j)).SrM));
        }
        else if (m == 4)
        {
          Log.d("MicroMsg.NetSceneAddChatRoomMember", " verify user : " + ((cxa)paramList.get(j)).SrM);
          i = -44;
          this.fMw.add(z.a(((cxa)paramList.get(j)).SrM));
        }
        else
        {
          i = k;
          if (m != 5) {
            if (m == 6)
            {
              this.iWk.add(z.a(((cxa)paramList.get(j)).SrM));
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
    AppMethodBeat.o(189997);
    return k;
  }
  
  public final com.tencent.mm.roomsdk.a.b.a a(com.tencent.mm.roomsdk.a.b.a parama)
  {
    Object localObject = parama;
    if ((parama instanceof c))
    {
      localObject = (c)parama;
      ((c)localObject).chatroomName = this.chatroomName;
      ((c)localObject).fMt = this.fMt;
      ((c)localObject).fLk = this.fLk;
      ((c)localObject).fMr = this.fMr;
      ((c)localObject).iWj = this.iWj;
      ((c)localObject).iWi = this.iWi;
      ((c)localObject).fMv = this.fMv;
      ((c)localObject).iWk = this.iWk;
      ((c)localObject).fMw = this.fMw;
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
    params = (cr)d.b.b(this.rr.lBR);
    paramArrayOfByte = (cs)d.c.b(this.rr.lBS);
    this.fLk = paramArrayOfByte.iWB;
    Q(paramArrayOfByte.RIk);
    this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
    if ((paramInt2 == 0) && (paramInt3 == 0)) {
      v.a(z.a(params.RIl), paramArrayOfByte);
    }
    AppMethodBeat.o(12457);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.chatroom.d.g
 * JD-Core Version:    0.7.0.1
 */