package com.tencent.mm.emoji.b.c;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.expt.b.c.a;
import com.tencent.mm.protocal.protobuf.amn;
import com.tencent.mm.protocal.protobuf.kn;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.bl;
import com.tencent.mm.storage.emotion.EmojiInfo;
import java.util.Collection;
import java.util.LinkedList;
import kotlin.Metadata;
import kotlin.ah;
import kotlin.g.a.a;
import kotlin.g.a.m;
import kotlin.g.b.u;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/emoji/loader/fetcher/EmojiFetcherConfigRetriever;", "Lcom/tencent/mm/modelbase/IOnSceneEnd;", "emojiInfo", "Lcom/tencent/mm/storage/emotion/EmojiInfo;", "callback", "Lkotlin/Function2;", "", "Lkotlin/ParameterName;", "name", "success", "Lcom/tencent/mm/emoji/loader/fetcher/EmojiFetcherConfig;", "config", "", "(Lcom/tencent/mm/storage/emotion/EmojiInfo;Lkotlin/jvm/functions/Function2;)V", "TAG", "", "getCallback", "()Lkotlin/jvm/functions/Function2;", "getEmojiInfo", "()Lcom/tencent/mm/storage/emotion/EmojiInfo;", "scene", "Lcom/tencent/mm/plugin/emoji/net/NetSceneBatchEmojiDownLoad;", "createFetcherConfig", "onSceneEnd", "errType", "", "errCode", "errMsg", "Lcom/tencent/mm/modelbase/NetSceneBase;", "plugin-emojisdk_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class f
  implements com.tencent.mm.am.h
{
  private final String TAG;
  private final EmojiInfo mgK;
  final m<Boolean, e, ah> mgM;
  private final com.tencent.mm.plugin.emoji.e.e mgN;
  
  public f(EmojiInfo paramEmojiInfo, m<? super Boolean, ? super e, ah> paramm)
  {
    AppMethodBeat.i(105438);
    this.mgK = paramEmojiInfo;
    this.mgM = paramm;
    this.TAG = "MicroMsg.EmojiFetcherConfigRetriever";
    paramEmojiInfo = new LinkedList();
    paramEmojiInfo.add(this.mgK.getMd5());
    this.mgN = new com.tencent.mm.plugin.emoji.e.e(paramEmojiInfo);
    paramEmojiInfo = f(this.mgK);
    if (((CharSequence)paramEmojiInfo.url).length() > 0) {}
    for (int i = 1; i != 0; i = 0)
    {
      this.mgM.invoke(Boolean.TRUE, paramEmojiInfo);
      AppMethodBeat.o(105438);
      return;
    }
    Log.i(this.TAG, "config retriever: db url is empty");
    com.tencent.mm.plugin.emoji.d.lo(9L);
    com.tencent.mm.kernel.h.baD().mCm.a(697, (com.tencent.mm.am.h)this);
    com.tencent.mm.kernel.h.baD().mCm.a((com.tencent.mm.am.p)this.mgN, 0);
    AppMethodBeat.o(105438);
  }
  
  private final e f(EmojiInfo paramEmojiInfo)
  {
    int i = 0;
    AppMethodBeat.i(105436);
    String str3 = kotlin.g.b.s.X(paramEmojiInfo.kMn(), "_temp");
    String str1;
    if (h.h(paramEmojiInfo))
    {
      Log.i(this.TAG, "createFetcherConfig: " + paramEmojiInfo.getMd5() + " use wxam");
      str1 = paramEmojiInfo.field_externUrl;
      kotlin.g.b.s.s(str1, "emojiInfo.field_externUrl");
      i = 2;
      if (paramEmojiInfo.field_tpauthkey != null) {
        break label278;
      }
    }
    label278:
    for (String str2 = "";; str2 = paramEmojiInfo.field_tpauthkey)
    {
      kotlin.g.b.s.s(str2, "if (null == emojiInfo.fi…emojiInfo.field_tpauthkey");
      paramEmojiInfo = new e(paramEmojiInfo, str1, str3, str2, i);
      AppMethodBeat.o(105436);
      return paramEmojiInfo;
      if (h.i(paramEmojiInfo))
      {
        Log.i(this.TAG, "createFetcherConfig: " + paramEmojiInfo.getMd5() + " use encrypt");
        str1 = paramEmojiInfo.field_encrypturl;
        kotlin.g.b.s.s(str1, "emojiInfo.field_encrypturl");
        i = 1;
        break;
      }
      if (!Util.isNullOrNil(paramEmojiInfo.field_cdnUrl))
      {
        Log.i(this.TAG, "createFetcherConfig: " + paramEmojiInfo.getMd5() + " use cdn url");
        str1 = paramEmojiInfo.field_cdnUrl;
        kotlin.g.b.s.s(str1, "emojiInfo.field_cdnUrl");
        break;
      }
      if (h.g(paramEmojiInfo))
      {
        Log.i(this.TAG, "createFetcherConfig: " + paramEmojiInfo.getMd5() + " use tp url");
        str1 = paramEmojiInfo.field_tpurl;
        kotlin.g.b.s.s(str1, "emojiInfo.field_tpurl");
        i = 3;
        break;
      }
      str1 = "";
      break;
    }
  }
  
  public final void onSceneEnd(int paramInt1, int paramInt2, String paramString, final com.tencent.mm.am.p paramp)
  {
    AppMethodBeat.i(105437);
    kotlin.g.b.s.u(paramp, "scene");
    int i = paramp.getType();
    Log.i(this.TAG, "onSceneEnd: " + paramInt1 + ", " + paramInt2 + ", " + i);
    if ((i == 697) && (kotlin.g.b.s.p(paramp, this.mgN)))
    {
      com.tencent.mm.kernel.h.baD().mCm.b(697, (com.tencent.mm.am.h)this);
      paramp = this.mgN.dAy();
      if (paramp == null)
      {
        paramString = null;
        paramString = (Collection)paramString;
        if ((paramString != null) && (!paramString.isEmpty())) {
          break label294;
        }
      }
      label294:
      for (i = 1;; i = 0)
      {
        if (i == 0) {
          break label300;
        }
        if ((paramInt1 == 0) && (paramInt2 == 0))
        {
          Log.i(this.TAG, "onSceneEnd: response list is empty");
          com.tencent.mm.plugin.report.service.h.OAn.p(164L, 11L, 1L);
          if (((((com.tencent.mm.plugin.expt.b.c)com.tencent.mm.kernel.h.ax(com.tencent.mm.plugin.expt.b.c.class)).a(c.a.yRu, 0) & 0x4) > 0) && (com.tencent.mm.plugin.emoji.g.d.y(this.mgK)))
          {
            paramString = new com.tencent.mm.plugin.emoji.e.c(0, 2, kotlin.a.p.listOf(this.mgK.getMd5()));
            com.tencent.mm.kernel.h.baD().mCm.a((com.tencent.mm.am.p)paramString, 0);
            bl.jba().adju.ab(kotlin.a.p.listOf(this.mgK.getMd5()), 0);
          }
        }
        this.mgM.invoke(Boolean.FALSE, null);
        AppMethodBeat.o(105437);
        return;
        paramString = paramp.YMz;
        break;
      }
      label300:
      paramString = bl.jba().adju.bza(this.mgK.getMd5());
      if (paramString != null) {
        break label469;
      }
      paramString = this.mgK;
    }
    label469:
    for (;;)
    {
      com.tencent.mm.plugin.emoji.g.d.a((amn)paramp.YMz.get(0), paramString);
      com.tencent.mm.plugin.emoji.g.d.a((amn)paramp.YMz.get(0), this.mgK);
      kotlin.g.b.s.s(paramString, "dbEmojiInfo");
      paramp = f(paramString);
      if (((CharSequence)paramp.url).length() > 0) {}
      for (paramInt1 = 1; paramInt1 != 0; paramInt1 = 0)
      {
        ((com.tencent.mm.plugin.emoji.c.d)com.tencent.mm.kernel.h.az(com.tencent.mm.plugin.emoji.c.d.class)).getProvider().updateEmojiInfo(paramString);
        com.tencent.mm.ae.d.d("EmojiFetcherConfigRetriever_onSceneEnd", (a)new a(this, paramp));
        AppMethodBeat.o(105437);
        return;
      }
      this.mgM.invoke(Boolean.FALSE, null);
      AppMethodBeat.o(105437);
      return;
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", ""}, k=3, mv={1, 5, 1}, xi=48)
  static final class a
    extends u
    implements a<ah>
  {
    a(f paramf, e parame)
    {
      super();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.emoji.b.c.f
 * JD-Core Version:    0.7.0.1
 */