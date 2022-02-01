package com.tencent.mm.emoji.loader.f;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.emoji.c;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.storage.emotion.EmojiInfo;
import com.tencent.mm.vfs.i;
import com.tencent.tmassistantsdk.util.Base64;
import d.g.b.p;
import d.l;
import d.n.n;

@l(gfx={1, 1, 16}, gfy={""}, gfz={"Lcom/tencent/mm/emoji/loader/verify/EmojiFileVerify;", "", "()V", "TAG", "", "getTAG", "()Ljava/lang/String;", "reportDecrypt", "", "verifyConfig", "Lcom/tencent/mm/emoji/loader/verify/EmojiVerifyConfig;", "success", "", "reportVerify", "verify", "plugin-emojisdk_release"})
public final class a
{
  private final String TAG = "MicroMsg.EmojiLoader.EmojiFileVerify";
  
  private static void a(b paramb, boolean paramBoolean)
  {
    AppMethodBeat.i(105486);
    if (paramBoolean)
    {
      switch (paramb.gjd)
      {
      default: 
        AppMethodBeat.o(105486);
        return;
      case 1: 
        c.up(7L);
        AppMethodBeat.o(105486);
        return;
      }
      c.up(11L);
      AppMethodBeat.o(105486);
      return;
    }
    EmojiInfo localEmojiInfo = paramb.gjb;
    switch (paramb.gjd)
    {
    }
    for (;;)
    {
      AppMethodBeat.o(105486);
      return;
      c.up(8L);
      c.a(localEmojiInfo.Lb(), 3, 0, 1, localEmojiInfo.afw(), 1, localEmojiInfo.field_designerID);
      AppMethodBeat.o(105486);
      return;
      c.up(12L);
      c.a(localEmojiInfo.Lb(), 4, 0, 1, localEmojiInfo.afw(), 1, localEmojiInfo.field_designerID);
    }
  }
  
  public final boolean a(b paramb)
  {
    AppMethodBeat.i(105485);
    p.h(paramb, "verifyConfig");
    if (paramb.gjH) {}
    label273:
    label479:
    label486:
    for (;;)
    {
      try
      {
        Object localObject = Base64.encodeToString(bt.aRa(paramb.gjI), 0);
        localObject = com.tencent.mm.b.a.c(i.aY(paramb.gjJ, 0, -1), (String)localObject);
        if ((localObject == null) || (i.C(paramb.path, (byte[])localObject) != 0)) {
          break label486;
        }
        i = 1;
        i.deleteFile(paramb.gjJ);
        if (i == 0)
        {
          a(paramb, false);
          AppMethodBeat.o(105485);
          return false;
        }
        a(paramb, true);
        localObject = i.aPK(paramb.path);
        ad.i(this.TAG, "file md5 ".concat(String.valueOf(localObject)));
        if ((bt.isNullOrNil((String)localObject)) || (!n.H((String)localObject, paramb.gjG, true))) {
          break label273;
        }
        i = 1;
        localObject = paramb.gjb;
        if (i == 0) {
          break label362;
        }
        switch (paramb.gjd)
        {
        default: 
          if ((i == 0) || (!g.ajA().aiK())) {
            break label479;
          }
          localObject = g.ad(com.tencent.mm.plugin.emoji.b.d.class);
          p.g(localObject, "MMKernel.plugin(IPluginEmoji::class.java)");
          ((com.tencent.mm.plugin.emoji.b.d)localObject).getEmojiMgr().a(paramb.gjb, true);
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
      i.mA(paramb.gjJ, paramb.path);
      continue;
      int i = 0;
      continue;
      c.a(localException.Lb(), 4, 0, 0, localException.afw(), 0, localException.field_designerID);
      c.up(4L);
      continue;
      c.a(localException.Lb(), 2, 0, 0, localException.afw(), 0, localException.field_designerID);
      c.up(4L);
      continue;
      c.a(localException.Lb(), 4, 0, 0, localException.afw(), 1, localException.field_designerID);
      c.up(13L);
      continue;
      label362:
      switch (paramb.gjd)
      {
      default: 
        break;
      case 0: 
        c.a(localException.Lb(), 4, 1, 1, localException.afw(), 1, localException.field_designerID);
        c.up(5L);
        break;
      case 1: 
        c.a(localException.Lb(), 2, 1, 1, localException.afw(), 1, localException.field_designerID);
        c.up(5L);
        break;
      case 2: 
        c.a(localException.Lb(), 4, 1, 1, localException.afw(), 1, localException.field_designerID);
        c.up(14L);
        continue;
        AppMethodBeat.o(105485);
        return false;
        i = 0;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.emoji.loader.f.a
 * JD-Core Version:    0.7.0.1
 */