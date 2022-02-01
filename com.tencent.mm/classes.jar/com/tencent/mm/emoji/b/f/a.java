package com.tencent.mm.emoji.b.f;

import android.util.Base64;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.emoji.b.c.f;
import com.tencent.mm.kernel.h;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.emotion.EmojiInfo;
import com.tencent.mm.vfs.y;
import javax.crypto.BadPaddingException;
import kotlin.Metadata;
import kotlin.g.a.m;
import kotlin.g.b.s;
import kotlin.n.n;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/emoji/loader/verify/EmojiFileVerify;", "", "()V", "TAG", "", "getTAG", "()Ljava/lang/String;", "checkFixAesKey", "", "verifyConfig", "Lcom/tencent/mm/emoji/loader/verify/EmojiVerifyConfig;", "e", "Ljava/lang/Exception;", "Lkotlin/Exception;", "reportDecrypt", "success", "", "reportVerify", "verify", "plugin-emojisdk_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class a
{
  private final String TAG = "MicroMsg.EmojiLoader.EmojiFileVerify";
  
  private static void a(b paramb, boolean paramBoolean)
  {
    AppMethodBeat.i(105486);
    if (paramBoolean)
    {
      switch (paramb.mgL)
      {
      }
      for (;;)
      {
        AppMethodBeat.o(105486);
        return;
        com.tencent.mm.plugin.emoji.d.lo(7L);
        AppMethodBeat.o(105486);
        return;
        com.tencent.mm.plugin.emoji.d.lo(11L);
        AppMethodBeat.o(105486);
        return;
        com.tencent.mm.plugin.emoji.d.lo(24L);
      }
    }
    EmojiInfo localEmojiInfo = paramb.mgK;
    switch (paramb.mgL)
    {
    }
    for (;;)
    {
      AppMethodBeat.o(105486);
      return;
      com.tencent.mm.plugin.emoji.d.lo(8L);
      com.tencent.mm.plugin.emoji.d.a(localEmojiInfo.getMd5(), 3, 0, 1, localEmojiInfo.field_groupId, 1, localEmojiInfo.field_designerID);
      AppMethodBeat.o(105486);
      return;
      com.tencent.mm.plugin.emoji.d.lo(12L);
      com.tencent.mm.plugin.emoji.d.a(localEmojiInfo.getMd5(), 4, 0, 1, localEmojiInfo.field_groupId, 1, localEmojiInfo.field_designerID);
      AppMethodBeat.o(105486);
      return;
      com.tencent.mm.plugin.emoji.d.lo(25L);
    }
  }
  
  public final boolean a(b paramb)
  {
    AppMethodBeat.i(105485);
    s.u(paramb, "verifyConfig");
    if (paramb.mhw) {}
    for (;;)
    {
      try
      {
        Object localObject = Base64.encodeToString(Util.decodeHexString(paramb.aesKey), 0);
        localObject = com.tencent.mm.b.a.c(y.bi(paramb.mhx, 0, -1), (String)localObject);
        if ((localObject == null) || (y.f(paramb.path, (byte[])localObject, localObject.length) != 0)) {
          break label631;
        }
        i = 1;
        y.deleteFile(paramb.mhx);
        if (i == 0)
        {
          Log.w(this.TAG, s.X("decrypt failed : ", paramb.aesKey));
          a(paramb, false);
          AppMethodBeat.o(105485);
          return false;
        }
        a(paramb, true);
        localObject = y.bub(paramb.path);
        Log.i(this.TAG, "file md5 " + localObject + ", " + paramb.mhv);
        if ((Util.isNullOrNil((String)localObject)) || (!n.T((String)localObject, paramb.mhv, true))) {
          break label395;
        }
        i = 1;
        localObject = paramb.mgK;
        if (i == 0) {
          break label493;
        }
        switch (paramb.mgL)
        {
        default: 
          if ((i == 0) || (!h.baC().aZN())) {
            break label624;
          }
          ((com.tencent.mm.plugin.emoji.c.d)h.az(com.tencent.mm.plugin.emoji.c.d.class)).getEmojiMgr().a(paramb.mgK, true);
          AppMethodBeat.o(105485);
          return true;
        }
      }
      catch (Exception localException)
      {
        Log.printErrStackTrace(this.TAG, (Throwable)localException, s.X("decrypt exception : ", paramb.aesKey), new Object[0]);
        a(paramb, false);
        if ((localException instanceof BadPaddingException))
        {
          Log.i(this.TAG, s.X("checkFixAesKey: ", paramb.aesKey));
          paramb = paramb.mgK;
          if (!Util.isNullOrNil(paramb.field_tpurl))
          {
            paramb.field_externUrl = "";
            paramb.field_encrypturl = "";
            paramb.field_cdnUrl = "";
            paramb.field_tpurl = "";
            paramb.field_aeskey = "";
            new f(paramb, (m)a.a.mhu);
          }
        }
        AppMethodBeat.o(105485);
        return false;
      }
      y.qn(paramb.mhx, paramb.path);
      continue;
      label395:
      int i = 0;
      continue;
      com.tencent.mm.plugin.emoji.d.a(localException.getMd5(), 4, 0, 0, localException.field_groupId, 0, localException.field_designerID);
      com.tencent.mm.plugin.emoji.d.lo(4L);
      continue;
      com.tencent.mm.plugin.emoji.d.a(localException.getMd5(), 2, 0, 0, localException.field_groupId, 0, localException.field_designerID);
      com.tencent.mm.plugin.emoji.d.lo(4L);
      continue;
      com.tencent.mm.plugin.emoji.d.a(localException.getMd5(), 4, 0, 0, localException.field_groupId, 1, localException.field_designerID);
      com.tencent.mm.plugin.emoji.d.lo(13L);
      continue;
      com.tencent.mm.plugin.emoji.d.lo(26L);
      continue;
      label493:
      switch (paramb.mgL)
      {
      default: 
        break;
      case 0: 
        com.tencent.mm.plugin.emoji.d.a(localException.getMd5(), 4, 1, 1, localException.field_groupId, 1, localException.field_designerID);
        com.tencent.mm.plugin.emoji.d.lo(5L);
        break;
      case 1: 
        com.tencent.mm.plugin.emoji.d.a(localException.getMd5(), 2, 1, 1, localException.field_groupId, 1, localException.field_designerID);
        com.tencent.mm.plugin.emoji.d.lo(5L);
        break;
      case 2: 
        com.tencent.mm.plugin.emoji.d.a(localException.getMd5(), 4, 1, 1, localException.field_groupId, 1, localException.field_designerID);
        com.tencent.mm.plugin.emoji.d.lo(14L);
        break;
      case 3: 
        com.tencent.mm.plugin.emoji.d.lo(27L);
        continue;
        label624:
        AppMethodBeat.o(105485);
        return false;
        label631:
        i = 0;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.emoji.b.f.a
 * JD-Core Version:    0.7.0.1
 */