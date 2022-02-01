package com.tencent.mm.plugin.emoji.e;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.am.c;
import com.tencent.mm.am.c.a;
import com.tencent.mm.am.c.b;
import com.tencent.mm.am.c.c;
import com.tencent.mm.am.p;
import com.tencent.mm.am.p.b;
import com.tencent.mm.autogen.a.ty;
import com.tencent.mm.emoji.c.l;
import com.tencent.mm.emoji.c.o;
import com.tencent.mm.emoji.sync.j;
import com.tencent.mm.network.s;
import com.tencent.mm.plugin.emoji.g.d;
import com.tencent.mm.protocal.protobuf.amn;
import com.tencent.mm.protocal.protobuf.km;
import com.tencent.mm.protocal.protobuf.kn;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.NetStatusUtil;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.aq;
import com.tencent.mm.storage.at.a;
import com.tencent.mm.storage.bl;
import com.tencent.mm.storage.emotion.EmojiInfo;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public final class e
  extends p
  implements com.tencent.mm.network.m
{
  public static int xOc = 0;
  public static int xOd = 1;
  private com.tencent.mm.am.h callback;
  private int mIndex;
  private final c rr;
  private int xNZ;
  private ArrayList<String> xOb;
  private ArrayList<EmojiInfo> xOe;
  private int xOf;
  private at.a xOg;
  private at.a xOh;
  private LinkedList<String> xOi;
  
  public e(LinkedList<String> paramLinkedList)
  {
    this(paramLinkedList, xOd);
  }
  
  private e(LinkedList<String> paramLinkedList, int paramInt)
  {
    AppMethodBeat.i(269821);
    this.xOb = new ArrayList();
    this.xOe = new ArrayList();
    this.mIndex = 0;
    this.xOf = 0;
    this.xOi = new LinkedList();
    c.a locala = new c.a();
    locala.otE = new km();
    locala.otF = new kn();
    locala.uri = "/cgi-bin/micromsg-bin/mmbatchemojidownload";
    locala.funcId = 697;
    locala.otG = 0;
    locala.respCmdId = 0;
    this.rr = locala.bEF();
    this.mIndex = 0;
    this.xOf = paramInt;
    this.xOi = paramLinkedList;
    this.xNZ = 0;
    if (this.xNZ == 1)
    {
      this.xOg = at.a.acIe;
      this.xOh = at.a.acIj;
      AppMethodBeat.o(269821);
      return;
    }
    this.xOg = at.a.acId;
    this.xOh = at.a.acIi;
    AppMethodBeat.o(269821);
  }
  
  private void b(kn paramkn)
  {
    AppMethodBeat.i(104572);
    Log.i("MicroMsg.emoji.NetSceneBatchEmojiDownLoad", "addEmojiInfoList mCustomType: %d", new Object[] { Integer.valueOf(this.xNZ) });
    if (paramkn == null)
    {
      Log.i("MicroMsg.emoji.NetSceneBatchEmojiDownLoad", "addEmojiInfoList response is null.");
      AppMethodBeat.o(104572);
      return;
    }
    if ((paramkn.YMz == null) || (paramkn.YMz.size() <= 0))
    {
      Log.i("MicroMsg.emoji.NetSceneBatchEmojiDownLoad", "addemojiInfoList EmojiList is null or size is empty.");
      AppMethodBeat.o(104572);
      return;
    }
    paramkn = paramkn.YMz.iterator();
    while (paramkn.hasNext())
    {
      amn localamn = (amn)paramkn.next();
      if (Util.isNullOrNil(localamn.Md5))
      {
        Log.w("MicroMsg.emoji.NetSceneBatchEmojiDownLoad", "addEmojiInfoList: empty md5 %s", new Object[] { localamn });
      }
      else
      {
        Object localObject = localamn.Md5.toLowerCase();
        this.xOb.add(localObject);
        localObject = new EmojiInfo();
        d.a(localamn, (EmojiInfo)localObject);
        if (this.xNZ == 1) {
          ((EmojiInfo)localObject).field_groupId = "capture";
        }
        for (;;)
        {
          this.xOe.add(localObject);
          break;
          ((EmojiInfo)localObject).field_catalog = EmojiInfo.aklM;
        }
      }
    }
    AppMethodBeat.o(104572);
  }
  
  public final kn dAy()
  {
    AppMethodBeat.i(269843);
    if (this.rr == null)
    {
      AppMethodBeat.o(269843);
      return null;
    }
    kn localkn = (kn)c.c.b(this.rr.otC);
    AppMethodBeat.o(269843);
    return localkn;
  }
  
  public final int doScene(com.tencent.mm.network.g paramg, com.tencent.mm.am.h paramh)
  {
    AppMethodBeat.i(104573);
    this.callback = paramh;
    paramh = (km)c.b.b(this.rr.otB);
    paramh.crs = this.mIndex;
    paramh.nUz = this.xOf;
    paramh.YMx = this.xOi;
    paramh.IHj = this.xNZ;
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
    if (this.xOf == xOc)
    {
      if ((paramInt2 != 0) || (paramInt3 != 0))
      {
        this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
        com.tencent.mm.plugin.report.service.h.OAn.idkeyStat(164L, 1L, 1L, false);
        com.tencent.mm.kernel.h.baE().ban().set(this.xOh, Long.valueOf(System.currentTimeMillis() + 3600000L));
        com.tencent.mm.kernel.h.baE().ban().set(this.xOg, Boolean.TRUE);
        AppMethodBeat.o(104571);
        return;
      }
      params = (kn)c.c.b(this.rr.otC);
      paramArrayOfByte = (km)c.b.b(this.rr.otB);
      if ((params.oOu == 0) && ((params.YKG == null) || (params.YKG.size() <= 0)))
      {
        this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
        Log.i("MicroMsg.emoji.NetSceneBatchEmojiDownLoad", "[cpan] donwload list is null");
        com.tencent.mm.plugin.report.service.h.OAn.idkeyStat(164L, 0L, 1L, false);
        AppMethodBeat.o(104571);
        return;
      }
      if (params.oOu == 1)
      {
        this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
        com.tencent.mm.kernel.h.baE().ban().set(this.xOh, Long.valueOf(System.currentTimeMillis() + 86400000L));
        com.tencent.mm.kernel.h.baE().ban().set(this.xOg, Boolean.FALSE);
        b(params);
        if (this.xOe == null)
        {
          paramInt1 = 0;
          Log.i("MicroMsg.emoji.NetSceneBatchEmojiDownLoad", "[cpan] preparedDownloadCustomEmojiList size:%s", new Object[] { Integer.valueOf(paramInt1) });
          paramString = this.xOb;
          if ((paramString != null) && (paramString.size() > 0)) {
            break label426;
          }
          Log.w("MicroMsg.emoji.NetSceneBatchEmojiDownLoad", "[cpan] perparedDownloadCustomEmojiList failed. list is null.");
          com.tencent.mm.kernel.h.baE().ban().set(at.a.acHU, Boolean.FALSE);
          if (this.xNZ == 0)
          {
            if ((this.xOb.contains("08f223fa83f1ca34e143d1e580252c7c")) && (this.xOb.contains("9bd1281af3a31710a45b84d736363691"))) {
              break label945;
            }
            d.dDu();
          }
        }
        for (;;)
        {
          com.tencent.mm.plugin.report.service.h.OAn.idkeyStat(164L, 0L, 1L, false);
          AppMethodBeat.o(104571);
          return;
          paramInt1 = this.xOe.size();
          break;
          label426:
          if (paramString.size() < o.aUQ()) {
            com.tencent.mm.kernel.h.baE().ban().set(at.a.acHU, Boolean.FALSE);
          }
          ((Boolean)com.tencent.mm.kernel.h.baE().ban().get(at.a.acHX, Boolean.TRUE)).booleanValue();
          bl.jba().adju.W(this.xNZ, this.xOe);
          com.tencent.mm.kernel.h.baE().ban().set(at.a.acHX, Boolean.FALSE);
          params = bl.jba().adju;
          paramInt1 = this.xNZ;
          Log.i("MicroMsg.emoji.EmojiInfoStorage", "[cpan] begin preparedDeleteCustomEmojiList");
          long l = System.currentTimeMillis();
          if ((paramString == null) || (paramString.size() <= 0))
          {
            Log.i("MicroMsg.emoji.EmojiInfoStorage", "[cpan] preparedDeleteCustomEmojiList failed. list is null");
            label560:
            paramString = (ArrayList)bl.jba().adju.jdF();
            if ((paramString == null) || (paramString.size() <= 0)) {
              break label892;
            }
            Log.i("MicroMsg.emoji.NetSceneBatchEmojiDownLoad", "try to sync emoji downloadList:%d", new Object[] { Integer.valueOf(paramString.size()) });
            com.tencent.mm.plugin.report.service.h.OAn.b(11595, new Object[] { Integer.valueOf(2), Integer.valueOf(this.xNZ) });
            if (NetStatusUtil.isWifi(MMApplicationContext.getContext())) {
              com.tencent.mm.plugin.report.service.h.OAn.b(11595, new Object[] { Integer.valueOf(3), Integer.valueOf(this.xNZ) });
            }
            label679:
            if (this.xNZ != 1) {
              break label919;
            }
            l.aUF().fi(true);
            com.tencent.mm.emoji.sync.g.aWo().fo(true);
          }
          for (;;)
          {
            paramString = com.tencent.mm.emoji.c.m.mhY;
            com.tencent.mm.emoji.c.m.aUM();
            new ty().publish();
            break;
            Object localObject = params.azg(paramInt1);
            if ((localObject == null) || (((List)localObject).size() <= 0))
            {
              Log.i("MicroMsg.emoji.EmojiInfoStorage", "[cpan] preparedDeleteCustomEmojiList failed. sync list is null");
              break label560;
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
            params.ab(paramArrayOfByte, paramInt1);
            Log.i("MicroMsg.emoji.EmojiInfoStorage", "[cpan] end preparedDeleteCustomEmojiList user time:%d succes. size:%d", new Object[] { Long.valueOf(System.currentTimeMillis() - l), Integer.valueOf(paramArrayOfByte.size()) });
            break label560;
            label892:
            com.tencent.mm.kernel.h.baE().ban().set(this.xOg, Boolean.FALSE);
            Log.i("MicroMsg.emoji.NetSceneBatchEmojiDownLoad", "no things need to download.");
            break label679;
            label919:
            l.aUF().fg(true);
            l.aUF().ff(true);
            com.tencent.mm.emoji.sync.g.aWn().fo(true);
          }
          label945:
          paramString = com.tencent.mm.emoji.c.m.mhY;
          com.tencent.mm.emoji.c.m.fj(true);
        }
      }
      Log.i("MicroMsg.emoji.NetSceneBatchEmojiDownLoad", "[cpan] do next scene. index:%d size:%d", new Object[] { Integer.valueOf(paramArrayOfByte.crs), Integer.valueOf(params.YKG.size()) });
      this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
      paramArrayOfByte.crs = params.crs;
      this.mIndex = paramArrayOfByte.crs;
      b(params);
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
    params = (kn)c.c.b(this.rr.otC);
    c.b.b(this.rr.otB);
    if ((params.YMz == null) || (params.YMz.size() <= 0)) {
      Log.i("MicroMsg.emoji.NetSceneBatchEmojiDownLoad", "Change MD5 to URL failed.");
    }
    for (;;)
    {
      this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
      AppMethodBeat.o(104571);
      return;
      bl.jba().adju.nh(params.YMz);
    }
  }
  
  public final int securityLimitCount()
  {
    return 150;
  }
  
  public final p.b securityVerificationChecked(s params)
  {
    return p.b.ouh;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.emoji.e.e
 * JD-Core Version:    0.7.0.1
 */