package com.tencent.mm.chatroom.d;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.am.c.a;
import com.tencent.mm.am.c.b;
import com.tencent.mm.am.c.c;
import com.tencent.mm.am.h;
import com.tencent.mm.chatroom.ui.ChatroomInfoUI.LocalHistoryInfo;
import com.tencent.mm.model.v;
import com.tencent.mm.network.g;
import com.tencent.mm.network.m;
import com.tencent.mm.network.s;
import com.tencent.mm.platformtools.w;
import com.tencent.mm.protocal.protobuf.daa;
import com.tencent.mm.protocal.protobuf.db;
import com.tencent.mm.protocal.protobuf.dc;
import com.tencent.mm.protocal.protobuf.doe;
import com.tencent.mm.protocal.protobuf.dof;
import com.tencent.mm.sdk.platformtools.Log;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public final class i
  extends com.tencent.mm.roomsdk.model.a
  implements m
{
  private h callback;
  private String chatroomName;
  private int hQS;
  public final List<String> hSb;
  private final List<String> hSd;
  private final List<String> hSf;
  private final List<String> hSg;
  private final List<String> lyj;
  private final List<String> lyk;
  private final List<String> lyl;
  private String lym;
  private final com.tencent.mm.am.c rr;
  
  public i(String paramString1, List<String> paramList, String paramString2, Object paramObject)
  {
    AppMethodBeat.i(241428);
    this.callback = null;
    this.hQS = 0;
    this.chatroomName = null;
    this.lym = "";
    Object localObject = new c.a();
    ((c.a)localObject).otE = new db();
    ((c.a)localObject).otF = new dc();
    ((c.a)localObject).uri = "/cgi-bin/micromsg-bin/addchatroommember";
    ((c.a)localObject).funcId = 120;
    ((c.a)localObject).otG = 36;
    ((c.a)localObject).respCmdId = 1000000036;
    this.rr = ((c.a)localObject).bEF();
    localObject = (db)c.b.b(this.rr.otB);
    ((db)localObject).YFn = w.Sk(paramString1);
    this.chatroomName = paramString1;
    paramString1 = new LinkedList();
    Iterator localIterator = paramList.iterator();
    while (localIterator.hasNext())
    {
      String str = (String)localIterator.next();
      doe localdoe = new doe();
      localdoe.ZqQ = w.Sk(str);
      paramString1.add(localdoe);
    }
    ((db)localObject).YFm = paramString1;
    ((db)localObject).lyF = paramString1.size();
    this.lyj = new ArrayList();
    this.hSd = new LinkedList();
    this.lyk = new LinkedList();
    this.hSf = new LinkedList();
    this.hSg = new LinkedList();
    this.lyl = new ArrayList();
    this.hSb = paramList;
    ((db)localObject).YFp = paramString2;
    if ((paramObject instanceof ChatroomInfoUI.LocalHistoryInfo))
    {
      Log.i("MicroMsg.NetSceneAddChatRoomMember", "localHistoryInfo:%s", new Object[] { paramObject.toString() });
      ((db)localObject).YFq = new daa();
      ((db)localObject).YFq.fileid = ((ChatroomInfoUI.LocalHistoryInfo)paramObject).fileid;
      ((db)localObject).YFq.aeskey = ((ChatroomInfoUI.LocalHistoryInfo)paramObject).aeskey;
      ((db)localObject).YFq.filemd5 = ((ChatroomInfoUI.LocalHistoryInfo)paramObject).filemd5;
      ((db)localObject).YFq.lAT = ((ChatroomInfoUI.LocalHistoryInfo)paramObject).lAT;
      ((db)localObject).YFq.lAU = ((ChatroomInfoUI.LocalHistoryInfo)paramObject).lAU;
      ((db)localObject).YFq.lAV = ((ChatroomInfoUI.LocalHistoryInfo)paramObject).lAV;
      ((db)localObject).YFq.lAW = ((ChatroomInfoUI.LocalHistoryInfo)paramObject).lAW;
      ((db)localObject).YFq.lAX = ((ChatroomInfoUI.LocalHistoryInfo)paramObject).lAX;
      ((db)localObject).YFq.lAY = ((ChatroomInfoUI.LocalHistoryInfo)paramObject).lAY;
      ((db)localObject).YFq.lAZ = ((ChatroomInfoUI.LocalHistoryInfo)paramObject).lAZ;
    }
    AppMethodBeat.o(241428);
  }
  
  private int bq(List<dof> paramList)
  {
    AppMethodBeat.i(241433);
    int j = 0;
    int k = 0;
    if (j < paramList.size())
    {
      int m = ((dof)paramList.get(j)).aaVf;
      int i;
      if (m == 0)
      {
        this.lyj.add(w.a(((dof)paramList.get(j)).ZqQ));
        i = k;
      }
      for (;;)
      {
        j += 1;
        k = i;
        break;
        if (m == 3)
        {
          Log.d("MicroMsg.NetSceneAddChatRoomMember", " blacklist : " + ((dof)paramList.get(j)).ZqQ);
          this.lyk.add(w.a(((dof)paramList.get(j)).ZqQ));
          i = -22;
        }
        else if (m == 1)
        {
          Log.d("MicroMsg.NetSceneAddChatRoomMember", " not user : " + ((dof)paramList.get(j)).ZqQ);
          this.hSf.add(w.a(((dof)paramList.get(j)).ZqQ));
          i = -4;
        }
        else if (m == 2)
        {
          Log.d("MicroMsg.NetSceneAddChatRoomMember", " invalid username : " + ((dof)paramList.get(j)).ZqQ);
          i = -14;
          this.hSd.add(w.a(((dof)paramList.get(j)).ZqQ));
        }
        else if (m == 4)
        {
          Log.d("MicroMsg.NetSceneAddChatRoomMember", " verify user : " + ((dof)paramList.get(j)).ZqQ);
          i = -44;
          this.hSg.add(w.a(((dof)paramList.get(j)).ZqQ));
        }
        else
        {
          i = k;
          if (m != 5) {
            if (m == 6)
            {
              this.lyl.add(w.a(((dof)paramList.get(j)).ZqQ));
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
    AppMethodBeat.o(241433);
    return k;
  }
  
  public final com.tencent.mm.roomsdk.model.b.a a(com.tencent.mm.roomsdk.model.b.a parama)
  {
    Object localObject = parama;
    if ((parama instanceof com.tencent.mm.roomsdk.model.b.c))
    {
      localObject = (com.tencent.mm.roomsdk.model.b.c)parama;
      ((com.tencent.mm.roomsdk.model.b.c)localObject).chatroomName = this.chatroomName;
      ((com.tencent.mm.roomsdk.model.b.c)localObject).hSd = this.hSd;
      ((com.tencent.mm.roomsdk.model.b.c)localObject).hQS = this.hQS;
      ((com.tencent.mm.roomsdk.model.b.c)localObject).hSb = this.hSb;
      ((com.tencent.mm.roomsdk.model.b.c)localObject).lyk = this.lyk;
      ((com.tencent.mm.roomsdk.model.b.c)localObject).lyj = this.lyj;
      ((com.tencent.mm.roomsdk.model.b.c)localObject).hSf = this.hSf;
      ((com.tencent.mm.roomsdk.model.b.c)localObject).lyl = this.lyl;
      ((com.tencent.mm.roomsdk.model.b.c)localObject).hSg = this.hSg;
      ((com.tencent.mm.roomsdk.model.b.c)localObject).lym = this.lym;
    }
    return localObject;
  }
  
  public final int doScene(g paramg, h paramh)
  {
    AppMethodBeat.i(12456);
    this.callback = paramh;
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
    params = (db)c.b.b(this.rr.otB);
    paramArrayOfByte = (dc)c.c.b(this.rr.otC);
    this.hQS = paramArrayOfByte.lyF;
    this.lym = paramArrayOfByte.MRj;
    bq(paramArrayOfByte.YFm);
    this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
    if ((paramInt2 == 0) && (paramInt3 == 0)) {
      v.a(w.a(params.YFn), paramArrayOfByte);
    }
    AppMethodBeat.o(12457);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.chatroom.d.i
 * JD-Core Version:    0.7.0.1
 */