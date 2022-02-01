package com.tencent.mm.emoji.loader.c;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.n;
import com.tencent.mm.ak.q;
import com.tencent.mm.plugin.emoji.b.d;
import com.tencent.mm.plugin.expt.a.b.a;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.protocal.protobuf.ads;
import com.tencent.mm.protocal.protobuf.jd;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.bs;
import com.tencent.mm.storage.az;
import com.tencent.mm.storage.emotion.EmojiInfo;
import d.a.j;
import d.g.a.a;
import d.g.a.m;
import d.g.b.k;
import d.l;
import d.y;
import java.util.Collection;
import java.util.LinkedList;

@l(fNY={1, 1, 16}, fNZ={""}, fOa={"Lcom/tencent/mm/emoji/loader/fetcher/EmojiFetcherConfigRetriever;", "Lcom/tencent/mm/modelbase/IOnSceneEnd;", "emojiInfo", "Lcom/tencent/mm/storage/emotion/EmojiInfo;", "callback", "Lkotlin/Function2;", "", "Lkotlin/ParameterName;", "name", "success", "Lcom/tencent/mm/emoji/loader/fetcher/EmojiFetcherConfig;", "config", "", "(Lcom/tencent/mm/storage/emotion/EmojiInfo;Lkotlin/jvm/functions/Function2;)V", "TAG", "", "getCallback", "()Lkotlin/jvm/functions/Function2;", "getEmojiInfo", "()Lcom/tencent/mm/storage/emotion/EmojiInfo;", "scene", "Lcom/tencent/mm/plugin/emoji/net/NetSceneBatchEmojiDownLoad;", "createFetcherConfig", "onSceneEnd", "errType", "", "errCode", "errMsg", "Lcom/tencent/mm/modelbase/NetSceneBase;", "plugin-emojisdk_release"})
public final class f
  implements com.tencent.mm.ak.g
{
  private final String TAG;
  private final EmojiInfo fPB;
  private final com.tencent.mm.plugin.emoji.f.e fPE;
  final m<Boolean, e, y> fPF;
  
  public f(EmojiInfo paramEmojiInfo, m<? super Boolean, ? super e, y> paramm)
  {
    AppMethodBeat.i(105438);
    this.fPB = paramEmojiInfo;
    this.fPF = paramm;
    this.TAG = "MicroMsg.EmojiFetcherConfigRetriever";
    paramEmojiInfo = new LinkedList();
    paramEmojiInfo.add(this.fPB.JC());
    this.fPE = new com.tencent.mm.plugin.emoji.f.e(paramEmojiInfo);
    paramEmojiInfo = g(this.fPB);
    if (((CharSequence)paramEmojiInfo.url).length() > 0) {}
    for (int i = 1; i != 0; i = 0)
    {
      this.fPF.n(Boolean.TRUE, paramEmojiInfo);
      AppMethodBeat.o(105438);
      return;
    }
    ac.i(this.TAG, "config retriever: db url is empty");
    com.tencent.mm.plugin.emoji.c.sr(9L);
    paramEmojiInfo = com.tencent.mm.kernel.g.agQ();
    k.g(paramEmojiInfo, "network()");
    paramEmojiInfo.agi().a(697, (com.tencent.mm.ak.g)this);
    paramEmojiInfo = com.tencent.mm.kernel.g.agQ();
    k.g(paramEmojiInfo, "MMKernel.network()");
    paramEmojiInfo.agi().b((n)this.fPE);
    AppMethodBeat.o(105438);
  }
  
  private final e g(EmojiInfo paramEmojiInfo)
  {
    int i = 0;
    AppMethodBeat.i(105436);
    String str3 = paramEmojiInfo.ghd() + "_temp";
    String str1;
    if (i.h(paramEmojiInfo))
    {
      ac.i(this.TAG, "createFetcherConfig: " + paramEmojiInfo.JC() + " use tp url");
      str1 = paramEmojiInfo.field_tpurl;
      k.g(str1, "emojiInfo.field_tpurl");
      i = 3;
      if (paramEmojiInfo.field_tpauthkey != null) {
        break label291;
      }
    }
    label291:
    for (String str2 = "";; str2 = paramEmojiInfo.field_tpauthkey)
    {
      k.g(str2, "if (null == emojiInfo.fi…emojiInfo.field_tpauthkey");
      paramEmojiInfo = new e(paramEmojiInfo, str1, str3, str2, i);
      AppMethodBeat.o(105436);
      return paramEmojiInfo;
      if (i.i(paramEmojiInfo))
      {
        ac.i(this.TAG, "createFetcherConfig: " + paramEmojiInfo.JC() + " use wxam");
        str1 = paramEmojiInfo.field_externUrl;
        k.g(str1, "emojiInfo.field_externUrl");
        i = 2;
        break;
      }
      if (i.j(paramEmojiInfo))
      {
        ac.i(this.TAG, "createFetcherConfig: " + paramEmojiInfo.JC() + " use encrypt");
        str1 = paramEmojiInfo.field_encrypturl;
        k.g(str1, "emojiInfo.field_encrypturl");
        i = 1;
        break;
      }
      if (!bs.isNullOrNil(paramEmojiInfo.field_cdnUrl))
      {
        ac.i(this.TAG, "createFetcherConfig: " + paramEmojiInfo.JC() + " use cdn url");
        str1 = paramEmojiInfo.field_cdnUrl;
        k.g(str1, "emojiInfo.field_cdnUrl");
        break;
      }
      str1 = "";
      break;
    }
  }
  
  public final void onSceneEnd(int paramInt1, int paramInt2, String paramString, n paramn)
  {
    AppMethodBeat.i(105437);
    k.h(paramn, "scene");
    int i = paramn.getType();
    ac.i(this.TAG, "onSceneEnd: " + paramInt1 + ", " + paramInt2 + ", " + i);
    if ((i == 697) && (k.g(paramn, this.fPE)))
    {
      paramString = com.tencent.mm.kernel.g.agQ();
      k.g(paramString, "network()");
      paramString.agi().b(697, (com.tencent.mm.ak.g)this);
      paramn = this.fPE.ccx();
      if (paramn != null)
      {
        paramString = paramn.DWQ;
        paramString = (Collection)paramString;
        if ((paramString != null) && (!paramString.isEmpty())) {
          break label306;
        }
      }
      label306:
      for (paramInt1 = 1;; paramInt1 = 0)
      {
        if (paramInt1 == 0) {
          break label311;
        }
        ac.i(this.TAG, "onSceneEnd: response list is empty");
        h.wUl.A(164L, 11L);
        if (((((com.tencent.mm.plugin.expt.a.b)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.expt.a.b.class)).a(b.a.pSc, 0) & 0x4) > 0) && (com.tencent.mm.plugin.emoji.h.b.x(this.fPB)))
        {
          paramString = new com.tencent.mm.plugin.emoji.f.c(0, 2, j.listOf(this.fPB.JC()));
          paramn = com.tencent.mm.kernel.g.agQ();
          k.g(paramn, "MMKernel.network()");
          paramn.agi().b((n)paramString);
          paramString = az.faZ();
          k.g(paramString, "EmojiStorageMgr.getInstance()");
          paramString.bEN().z(j.listOf(this.fPB.JC()), 0);
        }
        this.fPF.n(Boolean.FALSE, null);
        AppMethodBeat.o(105437);
        return;
        paramString = null;
        break;
      }
      label311:
      com.tencent.mm.plugin.emoji.h.b.a((ads)paramn.DWQ.get(0), this.fPB);
      paramString = g(this.fPB);
      if (((CharSequence)paramString.url).length() > 0) {}
      for (paramInt1 = 1; paramInt1 != 0; paramInt1 = 0)
      {
        paramn = com.tencent.mm.kernel.g.ad(d.class);
        k.g(paramn, "MMKernel.plugin(IPluginEmoji::class.java)");
        ((d)paramn).getProvider().updateEmojiInfo(this.fPB);
        com.tencent.mm.ac.c.b("EmojiFetcherConfigRetriever_onSceneEnd", (a)new f.a(this, paramString));
        AppMethodBeat.o(105437);
        return;
      }
      this.fPF.n(Boolean.FALSE, null);
    }
    AppMethodBeat.o(105437);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.emoji.loader.c.f
 * JD-Core Version:    0.7.0.1
 */