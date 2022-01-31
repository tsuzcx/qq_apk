package com.tencent.mm.plugin.emoji.model;

import android.util.Base64;
import com.tencent.mm.a.a;
import com.tencent.mm.protocal.c.ut;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.sdk.platformtools.o;
import com.tencent.mm.sdk.platformtools.y;
import com.tencent.mm.storage.at;
import com.tencent.mm.storage.emotion.EmojiInfo;
import com.tencent.mm.storage.emotion.d;
import com.tencent.mm.vfs.e;
import com.tencent.mm.vfs.j;

final class c$1
  implements com.tencent.mm.as.a.c.c
{
  c$1(c paramc) {}
  
  public final void a(boolean paramBoolean, Object... paramVarArgs)
  {
    if ((paramVarArgs == null) || (paramVarArgs.length < 2))
    {
      y.w("MicroMsg.emoji.EmojiAppMsgDownloadService", "extra obj error");
      return;
    }
    int i = ((Integer)paramVarArgs[1]).intValue();
    if ((paramVarArgs[0] instanceof ut)) {}
    for (ut localut = (ut)paramVarArgs[0];; localut = null)
    {
      if (localut == null)
      {
        y.e("MicroMsg.emoji.EmojiAppMsgDownloadService", "msginfo or  emojiInfo");
        return;
      }
      String str2 = EmojiLogic.J(com.tencent.mm.plugin.emoji.h.b.FL(), "", localut.jnU);
      new StringBuilder().append(str2).append("_encrypt");
      boolean bool1;
      if (i == 101)
      {
        paramVarArgs = str2 + "_extern";
        bool1 = true;
      }
      for (;;)
      {
        if (paramBoolean)
        {
          Object localObject;
          String str3;
          if (bool1)
          {
            paramBoolean = false;
            if (e.aeQ(paramVarArgs) > 0L)
            {
              long l = System.currentTimeMillis();
              for (;;)
              {
                try
                {
                  bool2 = a.e(Base64.encodeToString(bk.ZM(localut.sRu), 0), paramVarArgs, str2);
                  if (!bool2) {
                    continue;
                  }
                  paramBoolean = bool2;
                  com.tencent.mm.plugin.emoji.c.dt(7L);
                  paramBoolean = bool2;
                }
                catch (Exception localException)
                {
                  boolean bool2;
                  String str1;
                  y.e("MicroMsg.emoji.EmojiAppMsgDownloadService", "encrypt file failed. exception:%s", new Object[] { bk.j(localException) });
                  com.tencent.mm.plugin.emoji.c.dt(8L);
                  continue;
                  localObject = e.aeY(paramVarArgs);
                  continue;
                  e.deleteFile(paramVarArgs);
                }
                y.i("MicroMsg.emoji.EmojiAppMsgDownloadService", "encrypt file use time:%d", new Object[] { Long.valueOf(System.currentTimeMillis() - l) });
                if (paramBoolean) {
                  continue;
                }
                str2 = localut.jnU;
                l = e.aeQ(paramVarArgs);
                if (e.aeY(paramVarArgs) != null) {
                  continue;
                }
                str1 = "";
                y.i("MicroMsg.emoji.EmojiAppMsgDownloadService", "handleCNDDownloadResult file aes failed. try to download by cgi.emojiMd5:%s buf size:%d buf md5:%s key:%s eUrl:%s ", new Object[] { str2, Long.valueOf(l), str1, localut.sRu, localut.sRt });
                com.tencent.mm.plugin.emoji.c.a(localut.jnU, 3, 0, 1, "", 1, "");
                e.deleteFile(paramVarArgs);
                c.bx(localut.jnU, 2);
                return;
                if (i != 102) {
                  break label829;
                }
                paramVarArgs = str2 + "_encrypt";
                bool1 = true;
                break;
                paramBoolean = bool2;
                com.tencent.mm.plugin.emoji.c.dt(8L);
                paramBoolean = bool2;
              }
            }
          }
          else
          {
            localObject = new com.tencent.mm.vfs.b(str2);
            int j = (int)e.aeQ(str2);
            byte[] arrayOfByte = e.c(str2, 0, 10);
            if ((j <= 0) || (arrayOfByte == null)) {
              break label813;
            }
            str3 = e.aeY(j.n(((com.tencent.mm.vfs.b)localObject).mUri));
            paramVarArgs = localut.jnU;
            if (i == 101) {
              paramVarArgs = localut.sRw;
            }
            if ((bk.bl(str3)) || (!str3.equalsIgnoreCase(paramVarArgs))) {
              break label714;
            }
            if (!bool1) {
              break label682;
            }
            com.tencent.mm.plugin.emoji.c.dt(4L);
            com.tencent.mm.plugin.emoji.c.a(localut.jnU, 3, 0, 0, "", 0, "");
            i = EmojiInfo.uDe;
            if (!o.bx(arrayOfByte)) {
              break label707;
            }
          }
          label682:
          label707:
          for (i = EmojiInfo.uDd;; i = EmojiInfo.uDe)
          {
            localObject = i.getEmojiStorageMgr().uBb.acC(str3);
            paramVarArgs = (Object[])localObject;
            if (localObject == null)
            {
              paramVarArgs = new EmojiInfo();
              paramVarArgs.field_md5 = localut.jnU;
              paramVarArgs.field_catalog = EmojiInfo.uCT;
              paramVarArgs.field_size = ((int)e.aeQ(str2));
            }
            paramVarArgs.field_type = i;
            paramVarArgs.field_state = EmojiInfo.uDh;
            i.getEmojiStorageMgr().uBb.q(paramVarArgs);
            c.bx(localut.jnU, 1);
            EmojiLogic.a(ae.getContext(), null, paramVarArgs.Wv(), paramVarArgs.ndA, paramVarArgs);
            return;
            y.i("MicroMsg.emoji.EmojiAppMsgDownloadService", "handleCNDDownloadResult file aes download failed., try to download by cgi.emojiMd5:%s", new Object[] { localut.jnU });
            com.tencent.mm.plugin.emoji.c.a(localut.jnU, 3, 1, 1, "", 1, "");
            c.bx(localut.jnU, 2);
            return;
            com.tencent.mm.plugin.emoji.c.dt(4L);
            com.tencent.mm.plugin.emoji.c.a(localut.jnU, 2, 0, 0, "", 1, "");
            break;
          }
          label714:
          y.i("MicroMsg.emoji.EmojiAppMsgDownloadService", "handleCNDDownloadResult md5 check failed, try to download by cgi. buf md5:%s emojiMd5:%s field_cdnUrl:%s", new Object[] { str3, localut.jnU, localut.kSC });
          ((com.tencent.mm.vfs.b)localObject).delete();
          c.bx(localut.jnU, 2);
          if (bool1)
          {
            com.tencent.mm.plugin.emoji.c.dt(5L);
            com.tencent.mm.plugin.emoji.c.a(localut.jnU, 3, 0, 1, "", 1, "");
            return;
          }
          com.tencent.mm.plugin.emoji.c.dt(5L);
          com.tencent.mm.plugin.emoji.c.a(localut.jnU, 2, 0, 1, "", 1, "");
          return;
          label813:
          c.a(localut, bool1);
          return;
        }
        c.a(localut, bool1);
        return;
        label829:
        paramVarArgs = null;
        bool1 = false;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.emoji.model.c.1
 * JD-Core Version:    0.7.0.1
 */