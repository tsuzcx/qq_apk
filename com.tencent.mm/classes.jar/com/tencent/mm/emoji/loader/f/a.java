package com.tencent.mm.emoji.loader.f;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.emoji.c;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.storage.emotion.EmojiInfo;
import com.tencent.mm.vfs.i;
import com.tencent.tmassistantsdk.util.Base64;
import d.g.b.k;
import d.l;
import d.n.n;

@l(fvt={1, 1, 16}, fvu={""}, fvv={"Lcom/tencent/mm/emoji/loader/verify/EmojiFileVerify;", "", "()V", "TAG", "", "getTAG", "()Ljava/lang/String;", "reportDecrypt", "", "verifyConfig", "Lcom/tencent/mm/emoji/loader/verify/EmojiVerifyConfig;", "success", "", "reportVerify", "verify", "plugin-emojisdk_release"})
public final class a
{
  private final String TAG = "MicroMsg.EmojiLoader.EmojiFileVerify";
  
  private static void a(b paramb, boolean paramBoolean)
  {
    AppMethodBeat.i(105486);
    if (paramBoolean)
    {
      switch (paramb.fLR)
      {
      }
      for (;;)
      {
        AppMethodBeat.o(105486);
        return;
        c.oF(7L);
        AppMethodBeat.o(105486);
        return;
        c.oF(11L);
      }
    }
    EmojiInfo localEmojiInfo = paramb.fLP;
    switch (paramb.fLR)
    {
    }
    for (;;)
    {
      AppMethodBeat.o(105486);
      return;
      c.oF(8L);
      c.a(localEmojiInfo.JS(), 3, 0, 1, localEmojiInfo.asy(), 1, localEmojiInfo.field_designerID);
      AppMethodBeat.o(105486);
      return;
      c.oF(12L);
      c.a(localEmojiInfo.JS(), 4, 0, 1, localEmojiInfo.asy(), 1, localEmojiInfo.field_designerID);
    }
  }
  
  public final boolean a(b paramb)
  {
    AppMethodBeat.i(105485);
    k.h(paramb, "verifyConfig");
    if (paramb.fMv) {}
    label273:
    label479:
    label486:
    for (;;)
    {
      try
      {
        Object localObject = Base64.encodeToString(bt.aGd(paramb.fMw), 0);
        localObject = com.tencent.mm.b.a.c(i.aR(paramb.fMx, 0, -1), (String)localObject);
        if ((localObject == null) || (i.B(paramb.path, (byte[])localObject) != 0)) {
          break label486;
        }
        i = 1;
        i.deleteFile(paramb.fMx);
        if (i == 0)
        {
          a(paramb, false);
          AppMethodBeat.o(105485);
          return false;
        }
        a(paramb, true);
        localObject = i.aEN(paramb.path);
        ad.i(this.TAG, "file md5 ".concat(String.valueOf(localObject)));
        if ((bt.isNullOrNil((String)localObject)) || (!n.I((String)localObject, paramb.fMu, true))) {
          break label273;
        }
        i = 1;
        localObject = paramb.fLP;
        if (i == 0) {
          break label362;
        }
        switch (paramb.fLR)
        {
        default: 
          if ((i == 0) || (!g.afz().aeI())) {
            break label479;
          }
          localObject = g.ad(com.tencent.mm.plugin.emoji.b.d.class);
          k.g(localObject, "MMKernel.plugin(IPluginEmoji::class.java)");
          ((com.tencent.mm.plugin.emoji.b.d)localObject).getEmojiMgr().a(paramb.fLP, true);
          AppMethodBeat.o(105485);
          return true;
        }
      }
      catch (Exception localException)
      {
        ad.printErrStackTrace(this.TAG, (Throwable)localException, "", new Object[0]);
        a(paramb, false);
        AppMethodBeat.o(105485);
        return false;
      }
      i.lD(paramb.fMx, paramb.path);
      continue;
      int i = 0;
      continue;
      c.a(localException.JS(), 4, 0, 0, localException.asy(), 0, localException.field_designerID);
      c.oF(4L);
      continue;
      c.a(localException.JS(), 2, 0, 0, localException.asy(), 0, localException.field_designerID);
      c.oF(4L);
      continue;
      c.a(localException.JS(), 4, 0, 0, localException.asy(), 1, localException.field_designerID);
      c.oF(13L);
      continue;
      label362:
      switch (paramb.fLR)
      {
      default: 
        break;
      case 0: 
        c.a(localException.JS(), 4, 1, 1, localException.asy(), 1, localException.field_designerID);
        c.oF(5L);
        break;
      case 1: 
        c.a(localException.JS(), 2, 1, 1, localException.asy(), 1, localException.field_designerID);
        c.oF(5L);
        break;
      case 2: 
        c.a(localException.JS(), 4, 1, 1, localException.asy(), 1, localException.field_designerID);
        c.oF(14L);
        continue;
        AppMethodBeat.o(105485);
        return false;
        i = 0;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.emoji.loader.f.a
 * JD-Core Version:    0.7.0.1
 */