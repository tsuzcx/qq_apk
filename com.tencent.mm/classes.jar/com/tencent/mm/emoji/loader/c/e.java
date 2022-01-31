package com.tencent.mm.emoji.loader.c;

import a.f.a.a;
import a.f.b.j;
import a.l;
import a.y;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ai.f;
import com.tencent.mm.ai.p;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.emoji.c;
import com.tencent.mm.protocal.protobuf.ia;
import com.tencent.mm.protocal.protobuf.zg;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.storage.emotion.EmojiInfo;
import java.util.Collection;
import java.util.LinkedList;

@l(eaO={1, 1, 13}, eaP={""}, eaQ={"Lcom/tencent/mm/emoji/loader/fetcher/EmojiFetcherConfigRetriever;", "Lcom/tencent/mm/modelbase/IOnSceneEnd;", "emojiInfo", "Lcom/tencent/mm/storage/emotion/EmojiInfo;", "callback", "Lkotlin/Function2;", "", "Lkotlin/ParameterName;", "name", "success", "Lcom/tencent/mm/emoji/loader/fetcher/EmojiFetcherConfig;", "config", "", "(Lcom/tencent/mm/storage/emotion/EmojiInfo;Lkotlin/jvm/functions/Function2;)V", "TAG", "", "getCallback", "()Lkotlin/jvm/functions/Function2;", "getEmojiInfo", "()Lcom/tencent/mm/storage/emotion/EmojiInfo;", "scene", "Lcom/tencent/mm/plugin/emoji/net/NetSceneBatchEmojiDownLoad;", "createFetcherConfig", "onSceneEnd", "errType", "", "errCode", "errMsg", "Lcom/tencent/mm/modelbase/NetSceneBase;", "plugin-emojisdk_release"})
public final class e
  implements f
{
  private final String TAG;
  private final EmojiInfo evH;
  private final com.tencent.mm.plugin.emoji.f.e evK;
  final a.f.a.m<Boolean, d, y> evL;
  
  public e(EmojiInfo paramEmojiInfo, a.f.a.m<? super Boolean, ? super d, y> paramm)
  {
    AppMethodBeat.i(63188);
    this.evH = paramEmojiInfo;
    this.evL = paramm;
    this.TAG = "MicroMsg.EmojiFetcherConfigRetriever";
    paramEmojiInfo = new LinkedList();
    paramEmojiInfo.add(this.evH.Al());
    this.evK = new com.tencent.mm.plugin.emoji.f.e(paramEmojiInfo);
    paramEmojiInfo = e(this.evH);
    if (((CharSequence)paramEmojiInfo.url).length() > 0) {}
    for (int i = 1; i != 0; i = 0)
    {
      this.evL.h(Boolean.TRUE, paramEmojiInfo);
      AppMethodBeat.o(63188);
      return;
    }
    ab.i(this.TAG, "config retriever: db url is empty");
    c.iX(9L);
    paramEmojiInfo = g.RK();
    j.p(paramEmojiInfo, "network()");
    paramEmojiInfo.Rc().a(697, (f)this);
    paramEmojiInfo = g.RK();
    j.p(paramEmojiInfo, "MMKernel.network()");
    paramEmojiInfo.Rc().b((com.tencent.mm.ai.m)this.evK);
    AppMethodBeat.o(63188);
  }
  
  private final d e(EmojiInfo paramEmojiInfo)
  {
    int i = 0;
    AppMethodBeat.i(63186);
    String str3 = paramEmojiInfo.dQB() + "_temp";
    String str1;
    if (h.f(paramEmojiInfo))
    {
      ab.i(this.TAG, "createFetcherConfig: " + paramEmojiInfo.Al() + " use tp url");
      str1 = paramEmojiInfo.field_tpurl;
      j.p(str1, "emojiInfo.field_tpurl");
      i = 3;
      if (paramEmojiInfo.field_tpauthkey != null) {
        break label291;
      }
    }
    label291:
    for (String str2 = "";; str2 = paramEmojiInfo.field_tpauthkey)
    {
      j.p(str2, "if (null == emojiInfo.fi…emojiInfo.field_tpauthkey");
      paramEmojiInfo = new d(paramEmojiInfo, str1, str3, str2, i);
      AppMethodBeat.o(63186);
      return paramEmojiInfo;
      if (h.g(paramEmojiInfo))
      {
        ab.i(this.TAG, "createFetcherConfig: " + paramEmojiInfo.Al() + " use wxam");
        str1 = paramEmojiInfo.field_externUrl;
        j.p(str1, "emojiInfo.field_externUrl");
        i = 2;
        break;
      }
      if (h.h(paramEmojiInfo))
      {
        ab.i(this.TAG, "createFetcherConfig: " + paramEmojiInfo.Al() + " use encrypt");
        str1 = paramEmojiInfo.field_encrypturl;
        j.p(str1, "emojiInfo.field_encrypturl");
        i = 1;
        break;
      }
      if (!bo.isNullOrNil(paramEmojiInfo.field_cdnUrl))
      {
        ab.i(this.TAG, "createFetcherConfig: " + paramEmojiInfo.Al() + " use cdn url");
        str1 = paramEmojiInfo.field_cdnUrl;
        j.p(str1, "emojiInfo.field_cdnUrl");
        break;
      }
      str1 = "";
      break;
    }
  }
  
  public final void onSceneEnd(int paramInt1, int paramInt2, String paramString, com.tencent.mm.ai.m paramm)
  {
    AppMethodBeat.i(63187);
    j.q(paramm, "scene");
    int i = paramm.getType();
    ab.i(this.TAG, "onSceneEnd: " + paramInt1 + ", " + paramInt2 + ", " + i);
    if ((i == 697) && (j.e(paramm, this.evK)))
    {
      paramString = g.RK();
      j.p(paramString, "network()");
      paramString.Rc().b(697, (f)this);
      paramm = this.evK.blA();
      if (paramm != null)
      {
        paramString = paramm.wuz;
        paramString = (Collection)paramString;
        if ((paramString != null) && (!paramString.isEmpty())) {
          break label199;
        }
      }
      label199:
      for (paramInt1 = 1;; paramInt1 = 0)
      {
        if (paramInt1 == 0) {
          break label204;
        }
        ab.i(this.TAG, "onSceneEnd: response list is empty");
        com.tencent.mm.plugin.report.service.h.qsU.B(164L, 11L);
        this.evL.h(Boolean.FALSE, null);
        AppMethodBeat.o(63187);
        return;
        paramString = null;
        break;
      }
      label204:
      com.tencent.mm.plugin.emoji.h.b.a((zg)paramm.wuz.get(0), this.evH);
      paramString = e(this.evH);
      if (((CharSequence)paramString.url).length() > 0) {}
      for (paramInt1 = 1; paramInt1 != 0; paramInt1 = 0)
      {
        paramm = g.G(com.tencent.mm.plugin.emoji.b.d.class);
        j.p(paramm, "MMKernel.plugin(IPluginEmoji::class.java)");
        ((com.tencent.mm.plugin.emoji.b.d)paramm).getProvider().updateEmojiInfo(this.evH);
        com.tencent.mm.ab.b.a("EmojiFetcherConfigRetriever_onSceneEnd", (a)new e.a(this, paramString));
        AppMethodBeat.o(63187);
        return;
      }
      this.evL.h(Boolean.FALSE, null);
    }
    AppMethodBeat.o(63187);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.emoji.loader.c.e
 * JD-Core Version:    0.7.0.1
 */