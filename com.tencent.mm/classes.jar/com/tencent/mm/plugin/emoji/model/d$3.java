package com.tencent.mm.plugin.emoji.model;

import android.util.Base64;
import com.tencent.mm.a.a;
import com.tencent.mm.kernel.g;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.sdk.platformtools.y;
import com.tencent.mm.storage.as;
import com.tencent.mm.storage.emotion.EmojiInfo;
import com.tencent.mm.vfs.b;
import com.tencent.mm.vfs.e;
import com.tencent.mm.vfs.j;
import java.util.List;

final class d$3
  implements com.tencent.mm.as.a.c.c
{
  d$3(d paramd) {}
  
  public final void a(boolean paramBoolean, Object... paramVarArgs)
  {
    if ((paramVarArgs == null) || (paramVarArgs.length < 4))
    {
      y.w("MicroMsg.emoji.EmojiService", "extra obj error");
      return;
    }
    int i = ((Integer)paramVarArgs[2]).intValue();
    if ((paramVarArgs[0] instanceof as)) {}
    for (as localas = (as)paramVarArgs[0];; localas = null)
    {
      if ((paramVarArgs[1] instanceof EmojiInfo)) {}
      for (Object localObject1 = (EmojiInfo)paramVarArgs[1];; localObject1 = null)
      {
        if ((paramVarArgs[3] instanceof Long)) {
          ((Long)paramVarArgs[3]).longValue();
        }
        if ((localas == null) || (localObject1 == null))
        {
          y.w("MicroMsg.emoji.EmojiService", "msginfo or  emojiInfo");
          return;
        }
        this.iYc.iYb.remove(localas.bIW);
        if (((EmojiInfo)localObject1).field_state == EmojiInfo.uDj)
        {
          y.d("MicroMsg.emoji.EmojiService", "first receive emoji,then update.");
          ((EmojiInfo)localObject1).field_state = EmojiInfo.uDh;
          ((com.tencent.mm.plugin.emoji.b.d)g.t(com.tencent.mm.plugin.emoji.b.d.class)).getEmojiMgr().d((EmojiInfo)localObject1);
        }
        y.i("MicroMsg.emoji.EmojiService", "download finish %s, success %b", new Object[] { ((EmojiInfo)localObject1).Wv(), Boolean.valueOf(paramBoolean) });
        if (paramBoolean)
        {
          String str2 = ((EmojiInfo)localObject1).cwL();
          Object localObject2;
          if ((i == 102) || (i == 101) || (i == 103))
          {
            long l;
            if (i == 103)
            {
              paramVarArgs = str2 + "_openim";
              paramBoolean = false;
              if (e.aeQ(paramVarArgs) > 0L) {
                l = System.currentTimeMillis();
              }
            }
            else
            {
              for (;;)
              {
                try
                {
                  bool = a.e(Base64.encodeToString(bk.ZM(localas.aeskey), 0), paramVarArgs, str2);
                  if (!bool) {
                    continue;
                  }
                  if (i != 101) {
                    continue;
                  }
                  paramBoolean = bool;
                  com.tencent.mm.plugin.emoji.c.dt(11L);
                  paramBoolean = bool;
                }
                catch (Exception localException)
                {
                  boolean bool;
                  String str1;
                  y.e("MicroMsg.emoji.EmojiService", "encrypt file failed. exception:%s", new Object[] { bk.j(localException) });
                  if (i != 101) {
                    continue;
                  }
                  com.tencent.mm.plugin.emoji.c.dt(12L);
                  continue;
                  if (i != 101) {
                    continue;
                  }
                  paramBoolean = bool;
                  com.tencent.mm.plugin.emoji.c.dt(12L);
                  paramBoolean = bool;
                  continue;
                  paramBoolean = bool;
                  com.tencent.mm.plugin.emoji.c.dt(8L);
                  paramBoolean = bool;
                  continue;
                  com.tencent.mm.plugin.emoji.c.dt(8L);
                  continue;
                  localObject2 = ((EmojiInfo)localObject1).Wv();
                  continue;
                  str2 = e.aeY(paramVarArgs);
                  continue;
                  String str3 = ((EmojiInfo)localObject1).field_aeskey;
                  continue;
                  localObject1 = ((EmojiInfo)localObject1).field_encrypturl;
                  continue;
                  String str4 = localas.uAV;
                  continue;
                  com.tencent.mm.plugin.emoji.c.a(localas.bIW, 3, 0, 1, localas.bJd, 1, localas.uAW);
                  continue;
                  e.deleteFile(paramVarArgs);
                }
                y.i("MicroMsg.emoji.EmojiService", "encrypt file use time:%d %s", new Object[] { Long.valueOf(System.currentTimeMillis() - l), str2 });
                if (paramBoolean) {
                  continue;
                }
                if (localObject1 != null) {
                  continue;
                }
                str1 = "";
                l = e.aeQ(paramVarArgs);
                if (e.aeY(paramVarArgs) != null) {
                  continue;
                }
                str2 = "";
                if (localObject1 != null) {
                  continue;
                }
                str3 = "";
                if (localObject1 != null) {
                  continue;
                }
                localObject1 = "";
                if (localas != null) {
                  continue;
                }
                str4 = "";
                y.i("MicroMsg.emoji.EmojiService", "handleCNDDownloadResult file aes failed. try to download by cgi.emojiMd5:%s buf size:%d buf md5:%s key:%s eUrl:%s srcContent:%s", new Object[] { str1, Long.valueOf(l), str2, str3, localObject1, str4 });
                if (i != 101) {
                  continue;
                }
                com.tencent.mm.plugin.emoji.c.a(localas.bIW, 4, 0, 1, localas.bJd, 1, localas.uAW);
                e.deleteFile(paramVarArgs);
                d.a(localas);
                return;
                if (i == 101)
                {
                  paramVarArgs = str2 + "_extern";
                  break;
                }
                paramVarArgs = str2 + "_encrypt";
                break;
                paramBoolean = bool;
                com.tencent.mm.plugin.emoji.c.dt(7L);
                paramBoolean = bool;
              }
            }
          }
          else
          {
            localObject2 = new b(str2);
            if (e.aeQ(str2) <= 0L) {
              break label1164;
            }
            str2 = e.aeY(j.n(((b)localObject2).mUri));
            paramVarArgs = ((EmojiInfo)localObject1).Wv();
            if (i == 101) {
              paramVarArgs = ((EmojiInfo)localObject1).field_externMd5;
            }
            if ((bk.bl(str2)) || (!str2.equalsIgnoreCase(paramVarArgs))) {
              break label992;
            }
            if (i != 101) {
              break label924;
            }
            com.tencent.mm.plugin.emoji.c.dt(13L);
            com.tencent.mm.plugin.emoji.c.a(localas.bIW, 4, 0, 0, localas.bJd, 0, localas.uAW);
          }
          for (;;)
          {
            com.tencent.mm.plugin.emoji.e.d.aHc().c((EmojiInfo)localObject1, true);
            if (this.iYc.iYa != null) {
              this.iYc.iYa.j((EmojiInfo)localObject1);
            }
            d.a(localas);
            return;
            y.i("MicroMsg.emoji.EmojiService", "handleCNDDownloadResult file aes download failed., try to download by cgi.emojiMd5:%s", new Object[] { ((EmojiInfo)localObject1).Wv() });
            if (i == 101) {
              com.tencent.mm.plugin.emoji.c.a(localas.bIW, 4, 1, 1, localas.bJd, 1, localas.uAW);
            }
            for (;;)
            {
              d.a(localas);
              return;
              com.tencent.mm.plugin.emoji.c.a(localas.bIW, 3, 1, 1, localas.bJd, 1, localas.uAW);
            }
            label924:
            if (i == 102)
            {
              com.tencent.mm.plugin.emoji.c.dt(4L);
              com.tencent.mm.plugin.emoji.c.a(localas.bIW, 3, 0, 0, localas.bJd, 0, localas.uAW);
            }
            else
            {
              com.tencent.mm.plugin.emoji.c.dt(4L);
              com.tencent.mm.plugin.emoji.c.a(localas.bIW, 2, 0, 0, localas.bJd, 1, localas.uAW);
            }
          }
          label992:
          if (localObject1 == null)
          {
            paramVarArgs = "";
            if (localObject1 != null) {
              break label1090;
            }
          }
          label1090:
          for (localObject1 = "";; localObject1 = ((EmojiInfo)localObject1).field_cdnUrl)
          {
            y.i("MicroMsg.emoji.EmojiService", "handleCNDDownloadResult md5 check failed, try to download by cgi. buf md5:%s emojiMd5:%s field_cdnUrl:%s", new Object[] { str2, paramVarArgs, localObject1 });
            ((b)localObject2).delete();
            d.a(localas);
            if (i != 101) {
              break label1100;
            }
            com.tencent.mm.plugin.emoji.c.dt(14L);
            com.tencent.mm.plugin.emoji.c.a(localas.bIW, 4, 0, 1, localas.bJd, 0, localas.uAW);
            return;
            paramVarArgs = ((EmojiInfo)localObject1).Wv();
            break;
          }
          label1100:
          if (i == 102)
          {
            com.tencent.mm.plugin.emoji.c.dt(5L);
            com.tencent.mm.plugin.emoji.c.a(localas.bIW, 3, 0, 1, localas.bJd, 1, localas.uAW);
            return;
          }
          com.tencent.mm.plugin.emoji.c.dt(5L);
          com.tencent.mm.plugin.emoji.c.a(localas.bIW, 2, 0, 1, localas.bJd, 1, localas.uAW);
          return;
          label1164:
          if (localObject1 == null)
          {
            paramVarArgs = "";
            if (localObject1 != null) {
              break label1251;
            }
            localObject1 = "";
            label1181:
            y.i("MicroMsg.emoji.EmojiService", "handleCNDDownloadResult file no exist., try to donwload by cgi.emojiMd5:%s field_cdnUrl:%s", new Object[] { paramVarArgs, localObject1 });
            if (i != 101) {
              break label1261;
            }
            com.tencent.mm.plugin.emoji.c.a(localas.bIW, 4, 1, 1, localas.bJd, 1, localas.uAW);
            com.tencent.mm.plugin.emoji.c.dt(3L);
          }
          for (;;)
          {
            d.a(localas);
            return;
            paramVarArgs = ((EmojiInfo)localObject1).Wv();
            break;
            label1251:
            localObject1 = ((EmojiInfo)localObject1).field_cdnUrl;
            break label1181;
            label1261:
            com.tencent.mm.plugin.emoji.c.a(localas.bIW, 2, 1, 1, localas.bJd, 1, localas.uAW);
            com.tencent.mm.plugin.emoji.c.dt(3L);
          }
        }
        y.i("MicroMsg.emoji.EmojiService", "handleCNDDownloadResult file no exist., try to donwload by cgi.emojiMd5:%s", new Object[] { ((EmojiInfo)localObject1).Wv() });
        if (i == 101)
        {
          com.tencent.mm.plugin.emoji.c.a(localas.bIW, 4, 1, 1, localas.bJd, 1, localas.uAW);
          com.tencent.mm.plugin.emoji.c.dt(3L);
        }
        for (;;)
        {
          d.a(localas);
          return;
          com.tencent.mm.plugin.emoji.c.a(localas.bIW, 2, 1, 1, localas.bJd, 1, localas.uAW);
          com.tencent.mm.plugin.emoji.c.dt(3L);
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.emoji.model.d.3
 * JD-Core Version:    0.7.0.1
 */