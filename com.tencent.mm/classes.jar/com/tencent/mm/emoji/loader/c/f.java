package com.tencent.mm.emoji.loader.c;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.n;
import com.tencent.mm.ak.q;
import com.tencent.mm.plugin.emoji.b.d;
import com.tencent.mm.plugin.expt.b.b.a;
import com.tencent.mm.protocal.protobuf.agk;
import com.tencent.mm.protocal.protobuf.jm;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.bu;
import com.tencent.mm.storage.be;
import com.tencent.mm.storage.emotion.EmojiInfo;
import d.a.j;
import d.g.a.m;
import d.g.b.p;
import d.l;
import d.z;
import java.util.Collection;
import java.util.LinkedList;

@l(gjZ={1, 1, 16}, gka={""}, gkb={"Lcom/tencent/mm/emoji/loader/fetcher/EmojiFetcherConfigRetriever;", "Lcom/tencent/mm/modelbase/IOnSceneEnd;", "emojiInfo", "Lcom/tencent/mm/storage/emotion/EmojiInfo;", "callback", "Lkotlin/Function2;", "", "Lkotlin/ParameterName;", "name", "success", "Lcom/tencent/mm/emoji/loader/fetcher/EmojiFetcherConfig;", "config", "", "(Lcom/tencent/mm/storage/emotion/EmojiInfo;Lkotlin/jvm/functions/Function2;)V", "TAG", "", "getCallback", "()Lkotlin/jvm/functions/Function2;", "getEmojiInfo", "()Lcom/tencent/mm/storage/emotion/EmojiInfo;", "scene", "Lcom/tencent/mm/plugin/emoji/net/NetSceneBatchEmojiDownLoad;", "createFetcherConfig", "onSceneEnd", "errType", "", "errCode", "errMsg", "Lcom/tencent/mm/modelbase/NetSceneBase;", "plugin-emojisdk_release"})
public final class f
  implements com.tencent.mm.ak.f
{
  private final String TAG;
  private final EmojiInfo glt;
  private final com.tencent.mm.plugin.emoji.f.e glw;
  final m<Boolean, e, z> glx;
  
  public f(EmojiInfo paramEmojiInfo, m<? super Boolean, ? super e, z> paramm)
  {
    AppMethodBeat.i(105438);
    this.glt = paramEmojiInfo;
    this.glx = paramm;
    this.TAG = "MicroMsg.EmojiFetcherConfigRetriever";
    paramEmojiInfo = new LinkedList();
    paramEmojiInfo.add(this.glt.Lj());
    this.glw = new com.tencent.mm.plugin.emoji.f.e(paramEmojiInfo);
    paramEmojiInfo = g(this.glt);
    if (((CharSequence)paramEmojiInfo.url).length() > 0) {}
    for (int i = 1; i != 0; i = 0)
    {
      this.glx.p(Boolean.TRUE, paramEmojiInfo);
      AppMethodBeat.o(105438);
      return;
    }
    ae.i(this.TAG, "config retriever: db url is empty");
    com.tencent.mm.plugin.emoji.c.uG(9L);
    paramEmojiInfo = com.tencent.mm.kernel.g.ajQ();
    p.g(paramEmojiInfo, "network()");
    paramEmojiInfo.ajj().a(697, (com.tencent.mm.ak.f)this);
    paramEmojiInfo = com.tencent.mm.kernel.g.ajQ();
    p.g(paramEmojiInfo, "MMKernel.network()");
    paramEmojiInfo.ajj().b((n)this.glw);
    AppMethodBeat.o(105438);
  }
  
  private final e g(EmojiInfo paramEmojiInfo)
  {
    int i = 0;
    AppMethodBeat.i(105436);
    String str3 = paramEmojiInfo.fSQ() + "_temp";
    String str1;
    if (i.i(paramEmojiInfo))
    {
      ae.i(this.TAG, "createFetcherConfig: " + paramEmojiInfo.Lj() + " use wxam");
      str1 = paramEmojiInfo.field_externUrl;
      p.g(str1, "emojiInfo.field_externUrl");
      i = 2;
      if (paramEmojiInfo.field_tpauthkey != null) {
        break label291;
      }
    }
    label291:
    for (String str2 = "";; str2 = paramEmojiInfo.field_tpauthkey)
    {
      p.g(str2, "if (null == emojiInfo.fi…emojiInfo.field_tpauthkey");
      paramEmojiInfo = new e(paramEmojiInfo, str1, str3, str2, i);
      AppMethodBeat.o(105436);
      return paramEmojiInfo;
      if (i.j(paramEmojiInfo))
      {
        ae.i(this.TAG, "createFetcherConfig: " + paramEmojiInfo.Lj() + " use encrypt");
        str1 = paramEmojiInfo.field_encrypturl;
        p.g(str1, "emojiInfo.field_encrypturl");
        i = 1;
        break;
      }
      if (!bu.isNullOrNil(paramEmojiInfo.field_cdnUrl))
      {
        ae.i(this.TAG, "createFetcherConfig: " + paramEmojiInfo.Lj() + " use cdn url");
        str1 = paramEmojiInfo.field_cdnUrl;
        p.g(str1, "emojiInfo.field_cdnUrl");
        break;
      }
      if (i.h(paramEmojiInfo))
      {
        ae.i(this.TAG, "createFetcherConfig: " + paramEmojiInfo.Lj() + " use tp url");
        str1 = paramEmojiInfo.field_tpurl;
        p.g(str1, "emojiInfo.field_tpurl");
        i = 3;
        break;
      }
      str1 = "";
      break;
    }
  }
  
  public final void onSceneEnd(int paramInt1, int paramInt2, String paramString, n paramn)
  {
    AppMethodBeat.i(105437);
    p.h(paramn, "scene");
    int i = paramn.getType();
    ae.i(this.TAG, "onSceneEnd: " + paramInt1 + ", " + paramInt2 + ", " + i);
    if ((i == 697) && (p.i(paramn, this.glw)))
    {
      paramString = com.tencent.mm.kernel.g.ajQ();
      p.g(paramString, "network()");
      paramString.ajj().b(697, (com.tencent.mm.ak.f)this);
      paramn = this.glw.cir();
      if (paramn != null)
      {
        paramString = paramn.FUH;
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
        ae.i(this.TAG, "onSceneEnd: response list is empty");
        com.tencent.mm.plugin.report.service.g.yxI.A(164L, 11L);
        if (((((com.tencent.mm.plugin.expt.b.b)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.expt.b.b.class)).a(b.a.qDz, 0) & 0x4) > 0) && (com.tencent.mm.plugin.emoji.h.b.x(this.glt)))
        {
          paramString = new com.tencent.mm.plugin.emoji.f.c(0, 2, j.listOf(this.glt.Lj()));
          paramn = com.tencent.mm.kernel.g.ajQ();
          p.g(paramn, "MMKernel.network()");
          paramn.ajj().b((n)paramString);
          paramString = be.fvc();
          p.g(paramString, "EmojiStorageMgr.getInstance()");
          paramString.bJU().C(j.listOf(this.glt.Lj()), 0);
        }
        this.glx.p(Boolean.FALSE, null);
        AppMethodBeat.o(105437);
        return;
        paramString = null;
        break;
      }
      label311:
      paramString = be.fvc();
      p.g(paramString, "EmojiStorageMgr.getInstance()");
      paramString = paramString.bJU().aWl(this.glt.Lj());
      if (paramString != null) {
        break label492;
      }
      paramString = this.glt;
    }
    label492:
    for (;;)
    {
      com.tencent.mm.plugin.emoji.h.b.a((agk)paramn.FUH.get(0), paramString);
      com.tencent.mm.plugin.emoji.h.b.a((agk)paramn.FUH.get(0), this.glt);
      paramn = g(paramString);
      if (((CharSequence)paramn.url).length() > 0) {}
      for (paramInt1 = 1; paramInt1 != 0; paramInt1 = 0)
      {
        com.tencent.mm.kernel.b.a locala = com.tencent.mm.kernel.g.ad(d.class);
        p.g(locala, "MMKernel.plugin(IPluginEmoji::class.java)");
        ((d)locala).getProvider().updateEmojiInfo(paramString);
        com.tencent.mm.ac.c.b("EmojiFetcherConfigRetriever_onSceneEnd", (d.g.a.a)new f.a(this, paramn));
        AppMethodBeat.o(105437);
        return;
      }
      this.glx.p(Boolean.FALSE, null);
      AppMethodBeat.o(105437);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.emoji.loader.c.f
 * JD-Core Version:    0.7.0.1
 */