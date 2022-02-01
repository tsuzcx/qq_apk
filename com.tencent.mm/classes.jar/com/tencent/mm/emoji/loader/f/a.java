package com.tencent.mm.emoji.loader.f;

import android.util.Base64;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.emoji.loader.c.f;
import com.tencent.mm.kernel.h;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.emotion.EmojiInfo;
import com.tencent.mm.vfs.u;
import javax.crypto.BadPaddingException;
import kotlin.g.a.m;
import kotlin.g.b.p;
import kotlin.l;
import kotlin.n.n;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/emoji/loader/verify/EmojiFileVerify;", "", "()V", "TAG", "", "getTAG", "()Ljava/lang/String;", "checkFixAesKey", "", "verifyConfig", "Lcom/tencent/mm/emoji/loader/verify/EmojiVerifyConfig;", "e", "Ljava/lang/Exception;", "Lkotlin/Exception;", "reportDecrypt", "success", "", "reportVerify", "verify", "plugin-emojisdk_release"})
public final class a
{
  private final String TAG = "MicroMsg.EmojiLoader.EmojiFileVerify";
  
  private static void a(b paramb, boolean paramBoolean)
  {
    AppMethodBeat.i(105486);
    if (paramBoolean)
    {
      switch (paramb.jHi)
      {
      default: 
        AppMethodBeat.o(105486);
        return;
      case 1: 
        com.tencent.mm.plugin.emoji.d.IT(7L);
        AppMethodBeat.o(105486);
        return;
      case 2: 
        com.tencent.mm.plugin.emoji.d.IT(11L);
        AppMethodBeat.o(105486);
        return;
      }
      com.tencent.mm.plugin.emoji.d.IT(24L);
      AppMethodBeat.o(105486);
      return;
    }
    EmojiInfo localEmojiInfo = paramb.jHh;
    switch (paramb.jHi)
    {
    }
    for (;;)
    {
      AppMethodBeat.o(105486);
      return;
      com.tencent.mm.plugin.emoji.d.IT(8L);
      com.tencent.mm.plugin.emoji.d.a(localEmojiInfo.getMd5(), 3, 0, 1, localEmojiInfo.aCt(), 1, localEmojiInfo.field_designerID);
      AppMethodBeat.o(105486);
      return;
      com.tencent.mm.plugin.emoji.d.IT(12L);
      com.tencent.mm.plugin.emoji.d.a(localEmojiInfo.getMd5(), 4, 0, 1, localEmojiInfo.aCt(), 1, localEmojiInfo.field_designerID);
      AppMethodBeat.o(105486);
      return;
      com.tencent.mm.plugin.emoji.d.IT(25L);
    }
  }
  
  public final boolean a(b paramb)
  {
    AppMethodBeat.i(105485);
    p.k(paramb, "verifyConfig");
    if (paramb.jHP) {}
    for (;;)
    {
      try
      {
        Object localObject = Base64.encodeToString(Util.decodeHexString(paramb.aesKey), 0);
        localObject = com.tencent.mm.b.a.c(u.aY(paramb.jHQ, 0, -1), (String)localObject);
        if ((localObject == null) || (u.H(paramb.path, (byte[])localObject) != 0)) {
          break label667;
        }
        i = 1;
        u.deleteFile(paramb.jHQ);
        if (i == 0)
        {
          Log.w(this.TAG, "decrypt failed : " + paramb.aesKey);
          a(paramb, false);
          AppMethodBeat.o(105485);
          return false;
        }
        a(paramb, true);
        localObject = u.buc(paramb.path);
        Log.i(this.TAG, "file md5 " + (String)localObject + ", " + paramb.jHO);
        if ((Util.isNullOrNil((String)localObject)) || (!n.L((String)localObject, paramb.jHO, true))) {
          break label431;
        }
        i = 1;
        localObject = paramb.jHh;
        if (i == 0) {
          break label529;
        }
        switch (paramb.jHi)
        {
        default: 
          if ((i == 0) || (!h.aHE().aGM())) {
            break label660;
          }
          localObject = h.ag(com.tencent.mm.plugin.emoji.b.d.class);
          p.j(localObject, "MMKernel.plugin(IPluginEmoji::class.java)");
          ((com.tencent.mm.plugin.emoji.b.d)localObject).getEmojiMgr().a(paramb.jHh, true);
          AppMethodBeat.o(105485);
          return true;
        }
      }
      catch (Exception localException)
      {
        Log.printErrStackTrace(this.TAG, (Throwable)localException, "decrypt exception : " + paramb.aesKey, new Object[0]);
        a(paramb, false);
        if ((localException instanceof BadPaddingException))
        {
          Log.i(this.TAG, "checkFixAesKey: " + paramb.aesKey);
          paramb = paramb.jHh;
          if (!Util.isNullOrNil(paramb.field_tpurl))
          {
            paramb.field_externUrl = "";
            paramb.field_encrypturl = "";
            paramb.field_cdnUrl = "";
            paramb.field_tpurl = "";
            paramb.field_aeskey = "";
            new f(paramb, (m)a.a.jHN);
          }
        }
        AppMethodBeat.o(105485);
        return false;
      }
      u.oo(paramb.jHQ, paramb.path);
      continue;
      label431:
      int i = 0;
      continue;
      com.tencent.mm.plugin.emoji.d.a(localException.getMd5(), 4, 0, 0, localException.aCt(), 0, localException.field_designerID);
      com.tencent.mm.plugin.emoji.d.IT(4L);
      continue;
      com.tencent.mm.plugin.emoji.d.a(localException.getMd5(), 2, 0, 0, localException.aCt(), 0, localException.field_designerID);
      com.tencent.mm.plugin.emoji.d.IT(4L);
      continue;
      com.tencent.mm.plugin.emoji.d.a(localException.getMd5(), 4, 0, 0, localException.aCt(), 1, localException.field_designerID);
      com.tencent.mm.plugin.emoji.d.IT(13L);
      continue;
      com.tencent.mm.plugin.emoji.d.IT(26L);
      continue;
      label529:
      switch (paramb.jHi)
      {
      default: 
        break;
      case 0: 
        com.tencent.mm.plugin.emoji.d.a(localException.getMd5(), 4, 1, 1, localException.aCt(), 1, localException.field_designerID);
        com.tencent.mm.plugin.emoji.d.IT(5L);
        break;
      case 1: 
        com.tencent.mm.plugin.emoji.d.a(localException.getMd5(), 2, 1, 1, localException.aCt(), 1, localException.field_designerID);
        com.tencent.mm.plugin.emoji.d.IT(5L);
        break;
      case 2: 
        com.tencent.mm.plugin.emoji.d.a(localException.getMd5(), 4, 1, 1, localException.aCt(), 1, localException.field_designerID);
        com.tencent.mm.plugin.emoji.d.IT(14L);
        break;
      case 3: 
        com.tencent.mm.plugin.emoji.d.IT(27L);
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