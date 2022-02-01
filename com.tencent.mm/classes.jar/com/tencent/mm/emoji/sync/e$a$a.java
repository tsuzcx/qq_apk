package com.tencent.mm.emoji.sync;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.am.b.a;
import com.tencent.mm.kernel.h;
import com.tencent.mm.plugin.emoji.c.d;
import com.tencent.mm.protocal.protobuf.aoi;
import com.tencent.mm.protocal.protobuf.goe;
import com.tencent.mm.protocal.protobuf.gok;
import com.tencent.mm.sdk.platformtools.LocaleUtil;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.storage.bl;
import com.tencent.mm.storage.emotion.m;
import kotlin.Metadata;
import kotlin.ah;
import kotlin.g.a.a;
import kotlin.g.a.b;
import kotlin.g.b.s;
import kotlin.g.b.u;

@Metadata(d1={""}, d2={"<anonymous>", ""}, k=3, mv={1, 5, 1}, xi=48)
public final class e$a$a
  extends u
  implements a<ah>
{
  public e$a$a(String paramString, b<? super Integer, ah> paramb)
  {
    super(0);
  }
  
  private static final ah a(String paramString, b paramb, b.a parama)
  {
    AppMethodBeat.i(242589);
    s.u(paramString, "$productId");
    s.u(paramb, "$checkDesigner");
    int i = parama.errType;
    int j = parama.errCode;
    Log.i(e.access$getTAG$cp(), "CgiGetEmotionDetail end: " + i + ", " + j);
    parama = (goe)parama.ott;
    if ((i == 0) && (j == 0))
    {
      ((d)h.az(d.class)).getEmojiStorageMgr().adjz.a(paramString, parama, LocaleUtil.getCurrentLanguage(MMApplicationContext.getContext()));
      paramString = parama.akkU;
      if (paramString != null)
      {
        paramString = paramString.akks;
        if (paramString != null) {
          paramb.invoke(Integer.valueOf(paramString.ZtX));
        }
      }
    }
    paramString = ah.aiuX;
    AppMethodBeat.o(242589);
    return paramString;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.emoji.sync.e.a.a
 * JD-Core Version:    0.7.0.1
 */