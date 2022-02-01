package com.tencent.mm.emoji.loader.c;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.an.t;
import com.tencent.mm.plugin.expt.b.b.a;
import com.tencent.mm.protocal.protobuf.aji;
import com.tencent.mm.protocal.protobuf.jr;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.bj;
import com.tencent.mm.storage.emotion.EmojiInfo;
import java.util.Collection;
import java.util.LinkedList;
import kotlin.a.j;
import kotlin.g.a.m;
import kotlin.g.b.p;
import kotlin.l;
import kotlin.x;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/emoji/loader/fetcher/EmojiFetcherConfigRetriever;", "Lcom/tencent/mm/modelbase/IOnSceneEnd;", "emojiInfo", "Lcom/tencent/mm/storage/emotion/EmojiInfo;", "callback", "Lkotlin/Function2;", "", "Lkotlin/ParameterName;", "name", "success", "Lcom/tencent/mm/emoji/loader/fetcher/EmojiFetcherConfig;", "config", "", "(Lcom/tencent/mm/storage/emotion/EmojiInfo;Lkotlin/jvm/functions/Function2;)V", "TAG", "", "getCallback", "()Lkotlin/jvm/functions/Function2;", "getEmojiInfo", "()Lcom/tencent/mm/storage/emotion/EmojiInfo;", "scene", "Lcom/tencent/mm/plugin/emoji/net/NetSceneBatchEmojiDownLoad;", "createFetcherConfig", "onSceneEnd", "errType", "", "errCode", "errMsg", "Lcom/tencent/mm/modelbase/NetSceneBase;", "plugin-emojisdk_release"})
public final class f
  implements com.tencent.mm.an.i
{
  private final String TAG;
  private final EmojiInfo jHh;
  private final com.tencent.mm.plugin.emoji.f.e jHj;
  final m<Boolean, e, x> jHk;
  
  public f(EmojiInfo paramEmojiInfo, m<? super Boolean, ? super e, x> paramm)
  {
    AppMethodBeat.i(105438);
    this.jHh = paramEmojiInfo;
    this.jHk = paramm;
    this.TAG = "MicroMsg.EmojiFetcherConfigRetriever";
    paramEmojiInfo = new LinkedList();
    paramEmojiInfo.add(this.jHh.getMd5());
    this.jHj = new com.tencent.mm.plugin.emoji.f.e(paramEmojiInfo);
    paramEmojiInfo = g(this.jHh);
    if (((CharSequence)paramEmojiInfo.url).length() > 0) {}
    for (int i = 1; i != 0; i = 0)
    {
      this.jHk.invoke(Boolean.TRUE, paramEmojiInfo);
      AppMethodBeat.o(105438);
      return;
    }
    Log.i(this.TAG, "config retriever: db url is empty");
    com.tencent.mm.plugin.emoji.d.IT(9L);
    paramEmojiInfo = com.tencent.mm.kernel.h.aHF();
    p.j(paramEmojiInfo, "network()");
    paramEmojiInfo.aGY().a(697, (com.tencent.mm.an.i)this);
    paramEmojiInfo = com.tencent.mm.kernel.h.aHF();
    p.j(paramEmojiInfo, "MMKernel.network()");
    paramEmojiInfo.aGY().b((com.tencent.mm.an.q)this.jHj);
    AppMethodBeat.o(105438);
  }
  
  private final e g(EmojiInfo paramEmojiInfo)
  {
    int i = 0;
    AppMethodBeat.i(105436);
    String str3 = paramEmojiInfo.ifh() + "_temp";
    String str1;
    if (i.i(paramEmojiInfo))
    {
      Log.i(this.TAG, "createFetcherConfig: " + paramEmojiInfo.getMd5() + " use wxam");
      str1 = paramEmojiInfo.field_externUrl;
      p.j(str1, "emojiInfo.field_externUrl");
      i = 2;
      if (paramEmojiInfo.field_tpauthkey != null) {
        break label291;
      }
    }
    label291:
    for (String str2 = "";; str2 = paramEmojiInfo.field_tpauthkey)
    {
      p.j(str2, "if (null == emojiInfo.fi…emojiInfo.field_tpauthkey");
      paramEmojiInfo = new e(paramEmojiInfo, str1, str3, str2, i);
      AppMethodBeat.o(105436);
      return paramEmojiInfo;
      if (i.j(paramEmojiInfo))
      {
        Log.i(this.TAG, "createFetcherConfig: " + paramEmojiInfo.getMd5() + " use encrypt");
        str1 = paramEmojiInfo.field_encrypturl;
        p.j(str1, "emojiInfo.field_encrypturl");
        i = 1;
        break;
      }
      if (!Util.isNullOrNil(paramEmojiInfo.field_cdnUrl))
      {
        Log.i(this.TAG, "createFetcherConfig: " + paramEmojiInfo.getMd5() + " use cdn url");
        str1 = paramEmojiInfo.field_cdnUrl;
        p.j(str1, "emojiInfo.field_cdnUrl");
        break;
      }
      if (i.h(paramEmojiInfo))
      {
        Log.i(this.TAG, "createFetcherConfig: " + paramEmojiInfo.getMd5() + " use tp url");
        str1 = paramEmojiInfo.field_tpurl;
        p.j(str1, "emojiInfo.field_tpurl");
        i = 3;
        break;
      }
      str1 = "";
      break;
    }
  }
  
  public final void onSceneEnd(int paramInt1, int paramInt2, String paramString, final com.tencent.mm.an.q paramq)
  {
    AppMethodBeat.i(105437);
    p.k(paramq, "scene");
    int i = paramq.getType();
    Log.i(this.TAG, "onSceneEnd: " + paramInt1 + ", " + paramInt2 + ", " + i);
    if ((i == 697) && (p.h(paramq, this.jHj)))
    {
      paramString = com.tencent.mm.kernel.h.aHF();
      p.j(paramString, "network()");
      paramString.aGY().b(697, (com.tencent.mm.an.i)this);
      paramq = this.jHj.cUZ();
      if (paramq != null)
      {
        paramString = paramq.RPm;
        paramString = (Collection)paramString;
        if ((paramString != null) && (!paramString.isEmpty())) {
          break label317;
        }
      }
      label317:
      for (i = 1;; i = 0)
      {
        if (i == 0) {
          break label323;
        }
        if ((paramInt1 == 0) && (paramInt2 == 0))
        {
          Log.i(this.TAG, "onSceneEnd: response list is empty");
          com.tencent.mm.plugin.report.service.h.IzE.F(164L, 11L);
          if (((((com.tencent.mm.plugin.expt.b.b)com.tencent.mm.kernel.h.ae(com.tencent.mm.plugin.expt.b.b.class)).a(b.a.vCY, 0) & 0x4) > 0) && (com.tencent.mm.plugin.emoji.i.b.y(this.jHh)))
          {
            paramString = new com.tencent.mm.plugin.emoji.f.c(0, 2, j.listOf(this.jHh.getMd5()));
            paramq = com.tencent.mm.kernel.h.aHF();
            p.j(paramq, "MMKernel.network()");
            paramq.aGY().b((com.tencent.mm.an.q)paramString);
            paramString = bj.hyV();
            p.j(paramString, "EmojiStorageMgr.getInstance()");
            paramString.ctY().J(j.listOf(this.jHh.getMd5()), 0);
          }
        }
        this.jHk.invoke(Boolean.FALSE, null);
        AppMethodBeat.o(105437);
        return;
        paramString = null;
        break;
      }
      label323:
      paramString = bj.hyV();
      p.j(paramString, "EmojiStorageMgr.getInstance()");
      paramString = paramString.ctY().bxK(this.jHh.getMd5());
      if (paramString != null) {
        break label504;
      }
      paramString = this.jHh;
    }
    label504:
    for (;;)
    {
      com.tencent.mm.plugin.emoji.i.b.a((aji)paramq.RPm.get(0), paramString);
      com.tencent.mm.plugin.emoji.i.b.a((aji)paramq.RPm.get(0), this.jHh);
      paramq = g(paramString);
      if (((CharSequence)paramq.url).length() > 0) {}
      for (paramInt1 = 1; paramInt1 != 0; paramInt1 = 0)
      {
        com.tencent.mm.kernel.b.a locala = com.tencent.mm.kernel.h.ag(com.tencent.mm.plugin.emoji.b.d.class);
        p.j(locala, "MMKernel.plugin(IPluginEmoji::class.java)");
        ((com.tencent.mm.plugin.emoji.b.d)locala).getProvider().updateEmojiInfo(paramString);
        com.tencent.mm.ae.d.b("EmojiFetcherConfigRetriever_onSceneEnd", (kotlin.g.a.a)new a(this, paramq));
        AppMethodBeat.o(105437);
        return;
      }
      this.jHk.invoke(Boolean.FALSE, null);
      AppMethodBeat.o(105437);
      return;
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "invoke"})
  static final class a
    extends kotlin.g.b.q
    implements kotlin.g.a.a<x>
  {
    a(f paramf, e parame)
    {
      super();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.emoji.loader.c.f
 * JD-Core Version:    0.7.0.1
 */