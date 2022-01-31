package com.tencent.mm.emoji.loader.f;

import a.f.b.j;
import a.l;
import a.l.m;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.emoji.c;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.storage.emotion.EmojiInfo;
import com.tencent.mm.vfs.e;
import com.tencent.tmassistantsdk.util.Base64;

@l(eaO={1, 1, 13}, eaP={""}, eaQ={"Lcom/tencent/mm/emoji/loader/verify/EmojiFileVerify;", "", "()V", "TAG", "", "getTAG", "()Ljava/lang/String;", "reportDecrypt", "", "verifyConfig", "Lcom/tencent/mm/emoji/loader/verify/EmojiVerifyConfig;", "success", "", "reportVerify", "verify", "plugin-emojisdk_release"})
public final class a
{
  private final String TAG = "MicroMsg.EmojiLoader.EmojiFileVerify";
  
  private static void a(b paramb, boolean paramBoolean)
  {
    AppMethodBeat.i(63230);
    if (paramBoolean)
    {
      switch (paramb.evJ)
      {
      }
      for (;;)
      {
        AppMethodBeat.o(63230);
        return;
        c.iX(7L);
        AppMethodBeat.o(63230);
        return;
        c.iX(11L);
      }
    }
    EmojiInfo localEmojiInfo = paramb.evH;
    switch (paramb.evJ)
    {
    }
    for (;;)
    {
      AppMethodBeat.o(63230);
      return;
      c.iX(8L);
      c.a(localEmojiInfo.Al(), 3, 0, 1, localEmojiInfo.avS(), 1, localEmojiInfo.field_designerID);
      AppMethodBeat.o(63230);
      return;
      c.iX(12L);
      c.a(localEmojiInfo.Al(), 4, 0, 1, localEmojiInfo.avS(), 1, localEmojiInfo.field_designerID);
    }
  }
  
  public final boolean a(b paramb)
  {
    AppMethodBeat.i(63229);
    j.q(paramb, "verifyConfig");
    if (paramb.ewi) {}
    for (;;)
    {
      try
      {
        boolean bool = com.tencent.mm.a.a.g(Base64.encodeToString(bo.apQ(paramb.ewj), 0), paramb.ewk, paramb.path);
        e.deleteFile(paramb.ewk);
        if (!bool)
        {
          a(paramb, false);
          AppMethodBeat.o(63229);
          return false;
        }
        a(paramb, true);
        Object localObject = e.avP(paramb.path);
        ab.i(this.TAG, "file md5 ".concat(String.valueOf(localObject)));
        if ((bo.isNullOrNil((String)localObject)) || (!m.I((String)localObject, paramb.ewh, true))) {
          break label262;
        }
        i = 1;
        localObject = paramb.evH;
        if (i == 0) {
          break label360;
        }
        switch (paramb.evJ)
        {
        default: 
          if ((i == 0) || (!g.RJ().QU())) {
            break label488;
          }
          localObject = g.G(com.tencent.mm.plugin.emoji.b.d.class);
          j.p(localObject, "MMKernel.plugin(IPluginEmoji::class.java)");
          ((com.tencent.mm.plugin.emoji.b.d)localObject).getEmojiMgr().c(paramb.evH, true);
          AppMethodBeat.o(63229);
          return true;
        }
      }
      catch (Exception localException)
      {
        ab.printErrStackTrace(this.TAG, (Throwable)localException, "", new Object[0]);
        a(paramb, false);
        AppMethodBeat.o(63229);
        return false;
      }
      e.aT(paramb.ewk, paramb.path);
      continue;
      label262:
      int i = 0;
      continue;
      c.a(localException.Al(), 4, 0, 0, localException.avS(), 0, localException.field_designerID);
      c.iX(4L);
      continue;
      c.a(localException.Al(), 2, 0, 0, localException.avS(), 0, localException.field_designerID);
      c.iX(4L);
      continue;
      c.a(localException.Al(), 4, 0, 0, localException.avS(), 1, localException.field_designerID);
      c.iX(13L);
      continue;
      label360:
      switch (paramb.evJ)
      {
      default: 
        break;
      case 0: 
        c.a(localException.Al(), 4, 1, 1, localException.avS(), 1, localException.field_designerID);
        c.iX(5L);
        break;
      case 1: 
        c.a(localException.Al(), 2, 1, 1, localException.avS(), 1, localException.field_designerID);
        c.iX(5L);
        break;
      case 2: 
        c.a(localException.Al(), 4, 1, 1, localException.avS(), 1, localException.field_designerID);
        c.iX(14L);
      }
    }
    label488:
    AppMethodBeat.o(63229);
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.emoji.loader.f.a
 * JD-Core Version:    0.7.0.1
 */