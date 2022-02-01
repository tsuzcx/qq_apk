package com.tencent.mm.plugin.emoji.f;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.d;
import com.tencent.mm.ak.d.a;
import com.tencent.mm.ak.d.b;
import com.tencent.mm.ak.d.c;
import com.tencent.mm.ak.i;
import com.tencent.mm.ak.q;
import com.tencent.mm.ak.q.b;
import com.tencent.mm.emoji.b.j;
import com.tencent.mm.emoji.b.k;
import com.tencent.mm.emoji.b.n;
import com.tencent.mm.emoji.sync.EmojiSyncManager;
import com.tencent.mm.emoji.sync.EmojiSyncManager.a;
import com.tencent.mm.g.a.rj;
import com.tencent.mm.network.m;
import com.tencent.mm.network.s;
import com.tencent.mm.plugin.emoji.h.b;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.protocal.protobuf.ait;
import com.tencent.mm.protocal.protobuf.ka;
import com.tencent.mm.protocal.protobuf.kb;
import com.tencent.mm.sdk.event.EventCenter;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.NetStatusUtil;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.ao;
import com.tencent.mm.storage.ar.a;
import com.tencent.mm.storage.bj;
import com.tencent.mm.storage.emotion.EmojiInfo;
import com.tencent.mm.storage.emotion.f;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public final class e
  extends q
  implements m
{
  public static int rcv = 0;
  public static int rcw = 1;
  private i callback;
  private int mIndex;
  private ar.a rcA;
  private LinkedList<String> rcB;
  private int rcs;
  private ArrayList<String> rcu;
  private ArrayList<EmojiInfo> rcx;
  private int rcy;
  private ar.a rcz;
  private final d rr;
  
  public e(int paramInt)
  {
    this(new LinkedList(), paramInt, rcv);
    AppMethodBeat.i(104569);
    AppMethodBeat.o(104569);
  }
  
  public e(LinkedList<String> paramLinkedList)
  {
    this(paramLinkedList, 0, rcw);
  }
  
  private e(LinkedList<String> paramLinkedList, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(104570);
    this.rcu = new ArrayList();
    this.rcx = new ArrayList();
    this.mIndex = 0;
    this.rcy = 0;
    this.rcB = new LinkedList();
    d.a locala = new d.a();
    locala.iLN = new ka();
    locala.iLO = new kb();
    locala.uri = "/cgi-bin/micromsg-bin/mmbatchemojidownload";
    locala.funcId = 697;
    locala.iLP = 0;
    locala.respCmdId = 0;
    this.rr = locala.aXF();
    this.mIndex = 0;
    this.rcy = paramInt2;
    this.rcB = paramLinkedList;
    this.rcs = paramInt1;
    if (this.rcs == 1)
    {
      this.rcz = ar.a.NSQ;
      this.rcA = ar.a.NSU;
      AppMethodBeat.o(104570);
      return;
    }
    this.rcz = ar.a.NSP;
    this.rcA = ar.a.NST;
    AppMethodBeat.o(104570);
  }
  
  private void a(kb paramkb)
  {
    AppMethodBeat.i(104572);
    Log.i("MicroMsg.emoji.NetSceneBatchEmojiDownLoad", "addEmojiInfoList mCustomType: %d", new Object[] { Integer.valueOf(this.rcs) });
    if (paramkb == null)
    {
      Log.i("MicroMsg.emoji.NetSceneBatchEmojiDownLoad", "addEmojiInfoList response is null.");
      AppMethodBeat.o(104572);
      return;
    }
    if ((paramkb.KOp == null) || (paramkb.KOp.size() <= 0))
    {
      Log.i("MicroMsg.emoji.NetSceneBatchEmojiDownLoad", "addemojiInfoList EmojiList is null or size is empty.");
      AppMethodBeat.o(104572);
      return;
    }
    paramkb = paramkb.KOp.iterator();
    while (paramkb.hasNext())
    {
      ait localait = (ait)paramkb.next();
      if (Util.isNullOrNil(localait.Md5))
      {
        Log.w("MicroMsg.emoji.NetSceneBatchEmojiDownLoad", "addEmojiInfoList: empty md5 %s", new Object[] { localait });
      }
      else
      {
        Object localObject = localait.Md5.toLowerCase();
        this.rcu.add(localObject);
        localObject = new EmojiInfo();
        b.a(localait, (EmojiInfo)localObject);
        if (this.rcs == 1) {
          ((EmojiInfo)localObject).field_groupId = "capture";
        }
        for (;;)
        {
          this.rcx.add(localObject);
          break;
          ((EmojiInfo)localObject).field_catalog = EmojiInfo.Uuv;
        }
      }
    }
    AppMethodBeat.o(104572);
  }
  
  public final kb cGq()
  {
    if (this.rr == null) {
      return null;
    }
    return (kb)this.rr.iLL.iLR;
  }
  
  public final int doScene(com.tencent.mm.network.g paramg, i parami)
  {
    AppMethodBeat.i(104573);
    this.callback = parami;
    parami = (ka)this.rr.iLK.iLR;
    parami.xuA = this.mIndex;
    parami.ReqType = this.rcy;
    parami.KOo = this.rcB;
    parami.xIY = this.rcs;
    int i = dispatch(paramg, this.rr, this);
    AppMethodBeat.o(104573);
    return i;
  }
  
  public final int getType()
  {
    return 697;
  }
  
  public final void onGYNetEnd(int paramInt1, int paramInt2, int paramInt3, String paramString, s params, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(104571);
    Log.i("MicroMsg.emoji.NetSceneBatchEmojiDownLoad", "errType:%d, errCode:%d", new Object[] { Integer.valueOf(paramInt2), Integer.valueOf(paramInt3) });
    if (this.rcy == rcv)
    {
      if ((paramInt2 != 0) || (paramInt3 != 0))
      {
        this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
        h.CyF.idkeyStat(164L, 1L, 1L, false);
        com.tencent.mm.kernel.g.aAh().azQ().set(this.rcA, Long.valueOf(System.currentTimeMillis() + 3600000L));
        com.tencent.mm.kernel.g.aAh().azQ().set(this.rcz, Boolean.TRUE);
        AppMethodBeat.o(104571);
        return;
      }
      params = (kb)this.rr.iLL.iLR;
      paramArrayOfByte = (ka)this.rr.iLK.iLR;
      if ((params.jeU == 0) && ((params.KMy == null) || (params.KMy.size() <= 0)))
      {
        this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
        Log.i("MicroMsg.emoji.NetSceneBatchEmojiDownLoad", "[cpan] donwload list is null");
        h.CyF.idkeyStat(164L, 0L, 1L, false);
        AppMethodBeat.o(104571);
        return;
      }
      if (params.jeU == 1)
      {
        this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
        com.tencent.mm.kernel.g.aAh().azQ().set(this.rcA, Long.valueOf(System.currentTimeMillis() + 86400000L));
        com.tencent.mm.kernel.g.aAh().azQ().set(this.rcz, Boolean.FALSE);
        a(params);
        if (this.rcx == null) {}
        for (paramInt1 = 0;; paramInt1 = this.rcx.size())
        {
          Log.i("MicroMsg.emoji.NetSceneBatchEmojiDownLoad", "[cpan] preparedDownloadCustomEmojiList size:%s", new Object[] { Integer.valueOf(paramInt1) });
          paramString = this.rcu;
          if ((paramString != null) && (paramString.size() > 0)) {
            break;
          }
          Log.w("MicroMsg.emoji.NetSceneBatchEmojiDownLoad", "[cpan] perparedDownloadCustomEmojiList failed. list is null.");
          com.tencent.mm.kernel.g.aAh().azQ().set(ar.a.NSH, Boolean.FALSE);
          h.CyF.idkeyStat(164L, 0L, 1L, false);
          AppMethodBeat.o(104571);
          return;
        }
        if (paramString.size() < n.auY()) {
          com.tencent.mm.kernel.g.aAh().azQ().set(ar.a.NSH, Boolean.FALSE);
        }
        ((Boolean)com.tencent.mm.kernel.g.aAh().azQ().get(ar.a.NSK, Boolean.TRUE)).booleanValue();
        bj.gCJ().OpN.y(this.rcs, this.rcx);
        com.tencent.mm.kernel.g.aAh().azQ().set(ar.a.NSK, Boolean.FALSE);
        params = bj.gCJ().OpN;
        paramInt1 = this.rcs;
        Log.i("MicroMsg.emoji.EmojiInfoStorage", "[cpan] begin preparedDeleteCustomEmojiList");
        long l = System.currentTimeMillis();
        if ((paramString == null) || (paramString.size() <= 0))
        {
          Log.i("MicroMsg.emoji.EmojiInfoStorage", "[cpan] preparedDeleteCustomEmojiList failed. list is null");
          label524:
          paramString = (ArrayList)bj.gCJ().OpN.akw(0);
          if (paramString.size() <= 0) {
            break label853;
          }
          Log.i("MicroMsg.emoji.NetSceneBatchEmojiDownLoad", "try to sync emoji downloadList:%d", new Object[] { Integer.valueOf(paramString.size()) });
          h.CyF.a(11595, new Object[] { Integer.valueOf(2), Integer.valueOf(this.rcs) });
          if (NetStatusUtil.isWifi(MMApplicationContext.getContext())) {
            h.CyF.a(11595, new Object[] { Integer.valueOf(3), Integer.valueOf(this.rcs) });
          }
          label639:
          if (this.rcs != 1) {
            break label880;
          }
          j.auL().dY(true);
          paramString = EmojiSyncManager.hda;
          EmojiSyncManager.a.awo().eg(false);
        }
        for (;;)
        {
          paramString = k.gXr;
          k.auS();
          EventCenter.instance.publish(new rj());
          break;
          Object localObject = params.akt(paramInt1);
          if (((List)localObject).size() <= 0)
          {
            Log.i("MicroMsg.emoji.EmojiInfoStorage", "[cpan] preparedDeleteCustomEmojiList failed. sync list is null");
            break label524;
          }
          paramArrayOfByte = new ArrayList();
          localObject = ((List)localObject).iterator();
          while (((Iterator)localObject).hasNext())
          {
            String str = (String)((Iterator)localObject).next();
            if (!paramString.contains(str.toLowerCase()))
            {
              paramArrayOfByte.add(str);
              Log.i("MicroMsg.emoji.EmojiInfoStorage", "[cpan] delete:%s", new Object[] { str });
            }
          }
          params.I(paramArrayOfByte, paramInt1);
          Log.i("MicroMsg.emoji.EmojiInfoStorage", "[cpan] end preparedDeleteCustomEmojiList user time:%d succes. size:%d", new Object[] { Long.valueOf(System.currentTimeMillis() - l), Integer.valueOf(paramArrayOfByte.size()) });
          break label524;
          label853:
          com.tencent.mm.kernel.g.aAh().azQ().set(this.rcz, Boolean.FALSE);
          Log.i("MicroMsg.emoji.NetSceneBatchEmojiDownLoad", "no things need to download.");
          break label639;
          label880:
          j.auL().dW(true);
          j.auL().dV(true);
          paramString = EmojiSyncManager.hda;
          EmojiSyncManager.a.awn().eg(false);
        }
      }
      Log.i("MicroMsg.emoji.NetSceneBatchEmojiDownLoad", "[cpan] do next scene. index:%d size:%d", new Object[] { Integer.valueOf(paramArrayOfByte.xuA), Integer.valueOf(params.KMy.size()) });
      this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
      paramArrayOfByte.xuA = params.xuA;
      this.mIndex = paramArrayOfByte.xuA;
      a(params);
      paramInt2 = doScene(dispatcher(), this.callback);
      if (paramInt1 < 0) {
        Log.e("MicroMsg.emoji.NetSceneBatchEmojiDownLoad", "[cpan] doScene error.nextNetId:%d", new Object[] { Integer.valueOf(paramInt2) });
      }
      AppMethodBeat.o(104571);
      return;
    }
    if ((paramInt2 != 0) || (paramInt3 != 0))
    {
      this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
      AppMethodBeat.o(104571);
      return;
    }
    params = (kb)this.rr.iLL.iLR;
    if ((params.KOp == null) || (params.KOp.size() <= 0)) {
      Log.i("MicroMsg.emoji.NetSceneBatchEmojiDownLoad", "Change MD5 to URL failed.");
    }
    for (;;)
    {
      this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
      AppMethodBeat.o(104571);
      return;
      bj.gCJ().OpN.jb(params.KOp);
    }
  }
  
  public final int securityLimitCount()
  {
    return 20;
  }
  
  public final q.b securityVerificationChecked(s params)
  {
    return q.b.iMq;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.emoji.f.e
 * JD-Core Version:    0.7.0.1
 */