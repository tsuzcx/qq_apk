package com.tencent.mm.emoji.loader.c;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.al.n;
import com.tencent.mm.plugin.emoji.b.d;
import com.tencent.mm.plugin.expt.b.b.a;
import com.tencent.mm.protocal.protobuf.agb;
import com.tencent.mm.protocal.protobuf.jm;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.storage.bd;
import com.tencent.mm.storage.emotion.EmojiInfo;
import d.a.j;
import d.g.a.a;
import d.g.a.m;
import d.g.b.p;
import d.l;
import d.z;
import java.util.Collection;
import java.util.LinkedList;

@l(gfx={1, 1, 16}, gfy={""}, gfz={"Lcom/tencent/mm/emoji/loader/fetcher/EmojiFetcherConfigRetriever;", "Lcom/tencent/mm/modelbase/IOnSceneEnd;", "emojiInfo", "Lcom/tencent/mm/storage/emotion/EmojiInfo;", "callback", "Lkotlin/Function2;", "", "Lkotlin/ParameterName;", "name", "success", "Lcom/tencent/mm/emoji/loader/fetcher/EmojiFetcherConfig;", "config", "", "(Lcom/tencent/mm/storage/emotion/EmojiInfo;Lkotlin/jvm/functions/Function2;)V", "TAG", "", "getCallback", "()Lkotlin/jvm/functions/Function2;", "getEmojiInfo", "()Lcom/tencent/mm/storage/emotion/EmojiInfo;", "scene", "Lcom/tencent/mm/plugin/emoji/net/NetSceneBatchEmojiDownLoad;", "createFetcherConfig", "onSceneEnd", "errType", "", "errCode", "errMsg", "Lcom/tencent/mm/modelbase/NetSceneBase;", "plugin-emojisdk_release"})
public final class f
  implements com.tencent.mm.al.f
{
  private final String TAG;
  private final EmojiInfo gjb;
  private final com.tencent.mm.plugin.emoji.f.e gje;
  final m<Boolean, e, z> gjf;
  
  public f(EmojiInfo paramEmojiInfo, m<? super Boolean, ? super e, z> paramm)
  {
    AppMethodBeat.i(105438);
    this.gjb = paramEmojiInfo;
    this.gjf = paramm;
    this.TAG = "MicroMsg.EmojiFetcherConfigRetriever";
    paramEmojiInfo = new LinkedList();
    paramEmojiInfo.add(this.gjb.Lb());
    this.gje = new com.tencent.mm.plugin.emoji.f.e(paramEmojiInfo);
    paramEmojiInfo = g(this.gjb);
    if (((CharSequence)paramEmojiInfo.url).length() > 0) {}
    for (int i = 1; i != 0; i = 0)
    {
      this.gjf.p(Boolean.TRUE, paramEmojiInfo);
      AppMethodBeat.o(105438);
      return;
    }
    ad.i(this.TAG, "config retriever: db url is empty");
    com.tencent.mm.plugin.emoji.c.up(9L);
    paramEmojiInfo = com.tencent.mm.kernel.g.ajB();
    p.g(paramEmojiInfo, "network()");
    paramEmojiInfo.aiU().a(697, (com.tencent.mm.al.f)this);
    paramEmojiInfo = com.tencent.mm.kernel.g.ajB();
    p.g(paramEmojiInfo, "MMKernel.network()");
    paramEmojiInfo.aiU().b((n)this.gje);
    AppMethodBeat.o(105438);
  }
  
  private final e g(EmojiInfo paramEmojiInfo)
  {
    int i = 0;
    AppMethodBeat.i(105436);
    String str3 = paramEmojiInfo.gzQ() + "_temp";
    String str1;
    if (i.h(paramEmojiInfo))
    {
      ad.i(this.TAG, "createFetcherConfig: " + paramEmojiInfo.Lb() + " use tp url");
      str1 = paramEmojiInfo.field_tpurl;
      p.g(str1, "emojiInfo.field_tpurl");
      i = 3;
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
      if (i.i(paramEmojiInfo))
      {
        ad.i(this.TAG, "createFetcherConfig: " + paramEmojiInfo.Lb() + " use wxam");
        str1 = paramEmojiInfo.field_externUrl;
        p.g(str1, "emojiInfo.field_externUrl");
        i = 2;
        break;
      }
      if (i.j(paramEmojiInfo))
      {
        ad.i(this.TAG, "createFetcherConfig: " + paramEmojiInfo.Lb() + " use encrypt");
        str1 = paramEmojiInfo.field_encrypturl;
        p.g(str1, "emojiInfo.field_encrypturl");
        i = 1;
        break;
      }
      if (!bt.isNullOrNil(paramEmojiInfo.field_cdnUrl))
      {
        ad.i(this.TAG, "createFetcherConfig: " + paramEmojiInfo.Lb() + " use cdn url");
        str1 = paramEmojiInfo.field_cdnUrl;
        p.g(str1, "emojiInfo.field_cdnUrl");
        break;
      }
      str1 = "";
      break;
    }
  }
  
  public final void onSceneEnd(int paramInt1, int paramInt2, final String paramString, n paramn)
  {
    AppMethodBeat.i(105437);
    p.h(paramn, "scene");
    int i = paramn.getType();
    ad.i(this.TAG, "onSceneEnd: " + paramInt1 + ", " + paramInt2 + ", " + i);
    if ((i == 697) && (p.i(paramn, this.gje)))
    {
      paramString = com.tencent.mm.kernel.g.ajB();
      p.g(paramString, "network()");
      paramString.aiU().b(697, (com.tencent.mm.al.f)this);
      paramn = this.gje.chb();
      if (paramn != null)
      {
        paramString = paramn.FCm;
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
        ad.i(this.TAG, "onSceneEnd: response list is empty");
        com.tencent.mm.plugin.report.service.g.yhR.A(164L, 11L);
        if (((((com.tencent.mm.plugin.expt.b.b)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.expt.b.b.class)).a(b.a.qwA, 0) & 0x4) > 0) && (com.tencent.mm.plugin.emoji.h.b.x(this.gjb)))
        {
          paramString = new com.tencent.mm.plugin.emoji.f.c(0, 2, j.listOf(this.gjb.Lb()));
          paramn = com.tencent.mm.kernel.g.ajB();
          p.g(paramn, "MMKernel.network()");
          paramn.aiU().b((n)paramString);
          paramString = bd.frc();
          p.g(paramString, "EmojiStorageMgr.getInstance()");
          paramString.bIW().B(j.listOf(this.gjb.Lb()), 0);
        }
        this.gjf.p(Boolean.FALSE, null);
        AppMethodBeat.o(105437);
        return;
        paramString = null;
        break;
      }
      label312:
      com.tencent.mm.plugin.emoji.h.b.a((agb)paramn.FCm.get(0), this.gjb);
      paramString = g(this.gjb);
      if (((CharSequence)paramString.url).length() > 0) {}
      for (paramInt1 = 1; paramInt1 != 0; paramInt1 = 0)
      {
        paramn = com.tencent.mm.kernel.g.ad(d.class);
        p.g(paramn, "MMKernel.plugin(IPluginEmoji::class.java)");
        ((d)paramn).getProvider().updateEmojiInfo(this.gjb);
        com.tencent.mm.ad.c.b("EmojiFetcherConfigRetriever_onSceneEnd", (a)new a(this, paramString));
        AppMethodBeat.o(105437);
        return;
      }
      this.gjf.p(Boolean.FALSE, null);
    }
    AppMethodBeat.o(105437);
  }
  
  @l(gfx={1, 1, 16}, gfy={""}, gfz={"<anonymous>", "", "invoke"})
  static final class a
    extends d.g.b.q
    implements a<z>
  {
    a(f paramf, e parame)
    {
      super();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.emoji.loader.c.f
 * JD-Core Version:    0.7.0.1
 */