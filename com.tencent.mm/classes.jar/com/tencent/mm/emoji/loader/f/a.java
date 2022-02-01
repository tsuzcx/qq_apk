package com.tencent.mm.emoji.loader.f;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.emoji.loader.c.f;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.emoji.c;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.bu;
import com.tencent.mm.storage.emotion.EmojiInfo;
import com.tencent.mm.vfs.o;
import com.tencent.tmassistantsdk.util.Base64;
import d.g.a.m;
import d.g.b.p;
import d.l;
import d.n.n;
import javax.crypto.BadPaddingException;

@l(gjZ={1, 1, 16}, gka={""}, gkb={"Lcom/tencent/mm/emoji/loader/verify/EmojiFileVerify;", "", "()V", "TAG", "", "getTAG", "()Ljava/lang/String;", "checkFixAesKey", "", "verifyConfig", "Lcom/tencent/mm/emoji/loader/verify/EmojiVerifyConfig;", "e", "Ljava/lang/Exception;", "Lkotlin/Exception;", "reportDecrypt", "success", "", "reportVerify", "verify", "plugin-emojisdk_release"})
public final class a
{
  private final String TAG = "MicroMsg.EmojiLoader.EmojiFileVerify";
  
  private static void a(b paramb, boolean paramBoolean)
  {
    AppMethodBeat.i(105486);
    if (paramBoolean)
    {
      switch (paramb.glv)
      {
      default: 
        AppMethodBeat.o(105486);
        return;
      case 1: 
        c.uG(7L);
        AppMethodBeat.o(105486);
        return;
      case 2: 
        c.uG(11L);
        AppMethodBeat.o(105486);
        return;
      }
      c.uG(24L);
      AppMethodBeat.o(105486);
      return;
    }
    EmojiInfo localEmojiInfo = paramb.glt;
    switch (paramb.glv)
    {
    }
    for (;;)
    {
      AppMethodBeat.o(105486);
      return;
      c.uG(8L);
      c.a(localEmojiInfo.Lj(), 3, 0, 1, localEmojiInfo.afK(), 1, localEmojiInfo.field_designerID);
      AppMethodBeat.o(105486);
      return;
      c.uG(12L);
      c.a(localEmojiInfo.Lj(), 4, 0, 1, localEmojiInfo.afK(), 1, localEmojiInfo.field_designerID);
      AppMethodBeat.o(105486);
      return;
      c.uG(25L);
    }
  }
  
  public final boolean a(b paramb)
  {
    AppMethodBeat.i(105485);
    p.h(paramb, "verifyConfig");
    if (paramb.gma) {}
    for (;;)
    {
      try
      {
        Object localObject = Base64.encodeToString(bu.aSx(paramb.gmb), 0);
        localObject = com.tencent.mm.b.a.c(o.bb(paramb.gmc, 0, -1), (String)localObject);
        if ((localObject == null) || (o.C(paramb.path, (byte[])localObject) != 0)) {
          break label667;
        }
        i = 1;
        o.deleteFile(paramb.gmc);
        if (i == 0)
        {
          ae.w(this.TAG, "decrypt failed : " + paramb.gmb);
          a(paramb, false);
          AppMethodBeat.o(105485);
          return false;
        }
        a(paramb, true);
        localObject = o.aRh(paramb.path);
        ae.i(this.TAG, "file md5 " + (String)localObject + ", " + paramb.glZ);
        if ((bu.isNullOrNil((String)localObject)) || (!n.H((String)localObject, paramb.glZ, true))) {
          break label431;
        }
        i = 1;
        localObject = paramb.glt;
        if (i == 0) {
          break label529;
        }
        switch (paramb.glv)
        {
        default: 
          if ((i == 0) || (!g.ajP().aiZ())) {
            break label660;
          }
          localObject = g.ad(com.tencent.mm.plugin.emoji.b.d.class);
          p.g(localObject, "MMKernel.plugin(IPluginEmoji::class.java)");
          ((com.tencent.mm.plugin.emoji.b.d)localObject).getEmojiMgr().a(paramb.glt, true);
          AppMethodBeat.o(105485);
          return true;
        }
      }
      catch (Exception localException)
      {
        ae.printErrStackTrace(this.TAG, (Throwable)localException, "decrypt exception : " + paramb.gmb, new Object[0]);
        a(paramb, false);
        if ((localException instanceof BadPaddingException))
        {
          ae.i(this.TAG, "checkFixAesKey: " + paramb.gmb);
          paramb = paramb.glt;
          if (!bu.isNullOrNil(paramb.field_tpurl))
          {
            paramb.field_externUrl = "";
            paramb.field_encrypturl = "";
            paramb.field_cdnUrl = "";
            paramb.field_tpurl = "";
            paramb.field_aeskey = "";
            new f(paramb, (m)a.a.glY);
          }
        }
        AppMethodBeat.o(105485);
        return false;
      }
      o.mG(paramb.gmc, paramb.path);
      continue;
      label431:
      int i = 0;
      continue;
      c.a(localException.Lj(), 4, 0, 0, localException.afK(), 0, localException.field_designerID);
      c.uG(4L);
      continue;
      c.a(localException.Lj(), 2, 0, 0, localException.afK(), 0, localException.field_designerID);
      c.uG(4L);
      continue;
      c.a(localException.Lj(), 4, 0, 0, localException.afK(), 1, localException.field_designerID);
      c.uG(13L);
      continue;
      c.uG(26L);
      continue;
      label529:
      switch (paramb.glv)
      {
      default: 
        break;
      case 0: 
        c.a(localException.Lj(), 4, 1, 1, localException.afK(), 1, localException.field_designerID);
        c.uG(5L);
        break;
      case 1: 
        c.a(localException.Lj(), 2, 1, 1, localException.afK(), 1, localException.field_designerID);
        c.uG(5L);
        break;
      case 2: 
        c.a(localException.Lj(), 4, 1, 1, localException.afK(), 1, localException.field_designerID);
        c.uG(14L);
        break;
      case 3: 
        c.uG(27L);
        continue;
        label660:
        AppMethodBeat.o(105485);
        return false;
        label667:
        i = 0;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.emoji.loader.f.a
 * JD-Core Version:    0.7.0.1
 */