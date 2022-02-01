package com.tencent.mm.emoji.loader.c;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.t;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.emoji.f.c;
import com.tencent.mm.plugin.expt.b.b.a;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.protocal.protobuf.ait;
import com.tencent.mm.protocal.protobuf.kb;
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

@l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/emoji/loader/fetcher/EmojiFetcherConfigRetriever;", "Lcom/tencent/mm/modelbase/IOnSceneEnd;", "emojiInfo", "Lcom/tencent/mm/storage/emotion/EmojiInfo;", "callback", "Lkotlin/Function2;", "", "Lkotlin/ParameterName;", "name", "success", "Lcom/tencent/mm/emoji/loader/fetcher/EmojiFetcherConfig;", "config", "", "(Lcom/tencent/mm/storage/emotion/EmojiInfo;Lkotlin/jvm/functions/Function2;)V", "TAG", "", "getCallback", "()Lkotlin/jvm/functions/Function2;", "getEmojiInfo", "()Lcom/tencent/mm/storage/emotion/EmojiInfo;", "scene", "Lcom/tencent/mm/plugin/emoji/net/NetSceneBatchEmojiDownLoad;", "createFetcherConfig", "onSceneEnd", "errType", "", "errCode", "errMsg", "Lcom/tencent/mm/modelbase/NetSceneBase;", "plugin-emojisdk_release"})
public final class f
  implements com.tencent.mm.ak.i
{
  private final String TAG;
  private final EmojiInfo gWm;
  private final com.tencent.mm.plugin.emoji.f.e gWo;
  final m<Boolean, e, x> gWp;
  
  public f(EmojiInfo paramEmojiInfo, m<? super Boolean, ? super e, x> paramm)
  {
    AppMethodBeat.i(105438);
    this.gWm = paramEmojiInfo;
    this.gWp = paramm;
    this.TAG = "MicroMsg.EmojiFetcherConfigRetriever";
    paramEmojiInfo = new LinkedList();
    paramEmojiInfo.add(this.gWm.getMd5());
    this.gWo = new com.tencent.mm.plugin.emoji.f.e(paramEmojiInfo);
    paramEmojiInfo = g(this.gWm);
    if (((CharSequence)paramEmojiInfo.url).length() > 0) {}
    for (int i = 1; i != 0; i = 0)
    {
      this.gWp.invoke(Boolean.TRUE, paramEmojiInfo);
      AppMethodBeat.o(105438);
      return;
    }
    Log.i(this.TAG, "config retriever: db url is empty");
    com.tencent.mm.plugin.emoji.d.CK(9L);
    paramEmojiInfo = g.aAg();
    p.g(paramEmojiInfo, "network()");
    paramEmojiInfo.azz().a(697, (com.tencent.mm.ak.i)this);
    paramEmojiInfo = g.aAg();
    p.g(paramEmojiInfo, "MMKernel.network()");
    paramEmojiInfo.azz().b((com.tencent.mm.ak.q)this.gWo);
    AppMethodBeat.o(105438);
  }
  
  private final e g(EmojiInfo paramEmojiInfo)
  {
    int i = 0;
    AppMethodBeat.i(105436);
    String str3 = paramEmojiInfo.hRM() + "_temp";
    String str1;
    if (i.i(paramEmojiInfo))
    {
      Log.i(this.TAG, "createFetcherConfig: " + paramEmojiInfo.getMd5() + " use wxam");
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
        Log.i(this.TAG, "createFetcherConfig: " + paramEmojiInfo.getMd5() + " use encrypt");
        str1 = paramEmojiInfo.field_encrypturl;
        p.g(str1, "emojiInfo.field_encrypturl");
        i = 1;
        break;
      }
      if (!Util.isNullOrNil(paramEmojiInfo.field_cdnUrl))
      {
        Log.i(this.TAG, "createFetcherConfig: " + paramEmojiInfo.getMd5() + " use cdn url");
        str1 = paramEmojiInfo.field_cdnUrl;
        p.g(str1, "emojiInfo.field_cdnUrl");
        break;
      }
      if (i.h(paramEmojiInfo))
      {
        Log.i(this.TAG, "createFetcherConfig: " + paramEmojiInfo.getMd5() + " use tp url");
        str1 = paramEmojiInfo.field_tpurl;
        p.g(str1, "emojiInfo.field_tpurl");
        i = 3;
        break;
      }
      str1 = "";
      break;
    }
  }
  
  public final void onSceneEnd(int paramInt1, int paramInt2, String paramString, final com.tencent.mm.ak.q paramq)
  {
    AppMethodBeat.i(105437);
    p.h(paramq, "scene");
    int i = paramq.getType();
    Log.i(this.TAG, "onSceneEnd: " + paramInt1 + ", " + paramInt2 + ", " + i);
    if ((i == 697) && (p.j(paramq, this.gWo)))
    {
      paramString = g.aAg();
      p.g(paramString, "network()");
      paramString.azz().b(697, (com.tencent.mm.ak.i)this);
      paramq = this.gWo.cGq();
      if (paramq != null)
      {
        paramString = paramq.KOp;
        paramString = (Collection)paramString;
        if ((paramString != null) && (!paramString.isEmpty())) {
          break label307;
        }
      }
      label307:
      for (paramInt1 = 1;; paramInt1 = 0)
      {
        if (paramInt1 == 0) {
          break label312;
        }
        Log.i(this.TAG, "onSceneEnd: response list is empty");
        h.CyF.F(164L, 11L);
        if (((((com.tencent.mm.plugin.expt.b.b)g.af(com.tencent.mm.plugin.expt.b.b.class)).a(b.a.rWt, 0) & 0x4) > 0) && (com.tencent.mm.plugin.emoji.h.b.x(this.gWm)))
        {
          paramString = new c(0, 2, j.listOf(this.gWm.getMd5()));
          paramq = g.aAg();
          p.g(paramq, "MMKernel.network()");
          paramq.azz().b((com.tencent.mm.ak.q)paramString);
          paramString = bj.gCJ();
          p.g(paramString, "EmojiStorageMgr.getInstance()");
          paramString.cgN().I(j.listOf(this.gWm.getMd5()), 0);
        }
        this.gWp.invoke(Boolean.FALSE, null);
        AppMethodBeat.o(105437);
        return;
        paramString = null;
        break;
      }
      label312:
      paramString = bj.gCJ();
      p.g(paramString, "EmojiStorageMgr.getInstance()");
      paramString = paramString.cgN().blk(this.gWm.getMd5());
      if (paramString != null) {
        break label493;
      }
      paramString = this.gWm;
    }
    label493:
    for (;;)
    {
      com.tencent.mm.plugin.emoji.h.b.a((ait)paramq.KOp.get(0), paramString);
      com.tencent.mm.plugin.emoji.h.b.a((ait)paramq.KOp.get(0), this.gWm);
      paramq = g(paramString);
      if (((CharSequence)paramq.url).length() > 0) {}
      for (paramInt1 = 1; paramInt1 != 0; paramInt1 = 0)
      {
        com.tencent.mm.kernel.b.a locala = g.ah(com.tencent.mm.plugin.emoji.b.d.class);
        p.g(locala, "MMKernel.plugin(IPluginEmoji::class.java)");
        ((com.tencent.mm.plugin.emoji.b.d)locala).getProvider().updateEmojiInfo(paramString);
        com.tencent.mm.ac.d.b("EmojiFetcherConfigRetriever_onSceneEnd", (kotlin.g.a.a)new a(this, paramq));
        AppMethodBeat.o(105437);
        return;
      }
      this.gWp.invoke(Boolean.FALSE, null);
      AppMethodBeat.o(105437);
      return;
    }
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "invoke"})
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.emoji.loader.c.f
 * JD-Core Version:    0.7.0.1
 */