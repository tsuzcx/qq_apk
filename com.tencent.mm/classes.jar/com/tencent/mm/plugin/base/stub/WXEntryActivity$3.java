package com.tencent.mm.plugin.base.stub;

import android.content.Intent;
import android.os.Bundle;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.al.n;
import com.tencent.mm.al.q;
import com.tencent.mm.model.az;
import com.tencent.mm.modelsimple.ab;
import com.tencent.mm.opensdk.modelmsg.SendMessageToWX.Req;
import com.tencent.mm.opensdk.modelmsg.WXAppExtendObject;
import com.tencent.mm.opensdk.modelmsg.WXEmojiObject;
import com.tencent.mm.opensdk.modelmsg.WXFileObject;
import com.tencent.mm.opensdk.modelmsg.WXGameVideoFileObject;
import com.tencent.mm.opensdk.modelmsg.WXImageObject;
import com.tencent.mm.opensdk.modelmsg.WXMediaMessage;
import com.tencent.mm.opensdk.modelmsg.WXVideoFileObject;
import com.tencent.mm.plugin.s.a;
import com.tencent.mm.pluginsdk.model.app.h;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.vfs.i;
import java.util.LinkedList;

final class WXEntryActivity$3
  implements Runnable
{
  WXEntryActivity$3(WXEntryActivity paramWXEntryActivity, SendMessageToWX.Req paramReq, String paramString) {}
  
  public final void run()
  {
    AppMethodBeat.i(169738);
    for (;;)
    {
      String str1;
      Object localObject2;
      String str2;
      long l;
      try
      {
        Object localObject1 = this.mKo.message;
        if (localObject1 == null) {
          break label878;
        }
        str1 = a.cZM() + "content_" + bt.eGO();
        if ((((WXMediaMessage)localObject1).mediaObject instanceof WXImageObject))
        {
          localObject2 = (WXImageObject)((WXMediaMessage)localObject1).mediaObject;
          str2 = ((WXImageObject)localObject2).imagePath;
          if (h.aAP(str2))
          {
            if (!str2.startsWith("content")) {
              break label873;
            }
            l = i.lC(str2, str1);
            ad.i("MicroMsg.AppInfoLogic", "copyFileIfNeed filename: %s, type: %d, ret: %d", new Object[] { str1, Integer.valueOf(((WXMediaMessage)localObject1).getType()), Long.valueOf(l) });
            ((WXImageObject)localObject2).imagePath = str1;
            break label873;
            if (i != 0)
            {
              localObject1 = new Bundle();
              this.mKo.toBundle((Bundle)localObject1);
              this.mLo.getIntent().putExtras((Bundle)localObject1);
            }
            az.aeS().a(1200, this.mLo);
            localObject1 = new LinkedList();
            localObject1 = new ab(this.mLp, 1, (LinkedList)localObject1);
            az.aeS().a((n)localObject1, 0);
            AppMethodBeat.o(169738);
            return;
          }
          ad.e("MicroMsg.AppInfoLogic", "copyFileIfNeed file invalid: %s", new Object[] { str2 });
          break label878;
        }
        if ((((WXMediaMessage)localObject1).mediaObject instanceof WXFileObject))
        {
          localObject2 = (WXFileObject)((WXMediaMessage)localObject1).mediaObject;
          str2 = ((WXFileObject)localObject2).filePath;
          if (h.aAP(str2))
          {
            if (!str2.startsWith("content")) {
              break label883;
            }
            l = i.lC(str2, str1);
            ad.i("MicroMsg.AppInfoLogic", "copyFileIfNeed filename: %s, type: %d, ret: %d", new Object[] { str1, Integer.valueOf(((WXMediaMessage)localObject1).getType()), Long.valueOf(l) });
            ((WXFileObject)localObject2).filePath = str1;
            break label883;
          }
          ad.e("MicroMsg.AppInfoLogic", "copyFileIfNeed file invalid: %s", new Object[] { str2 });
        }
      }
      catch (Exception localException)
      {
        ad.e("MicroMsg.WXEntryActivity", "copyFileIfNeed e = %s", new Object[] { localException.getMessage() });
        WXEntryActivity.c(this.mLo);
        AppMethodBeat.o(169738);
        return;
      }
      if ((localException.mediaObject instanceof WXEmojiObject))
      {
        localObject2 = (WXEmojiObject)localException.mediaObject;
        str2 = ((WXEmojiObject)localObject2).emojiPath;
        if (h.aAP(str2))
        {
          if (!str2.startsWith("content")) {
            break label888;
          }
          l = i.lC(str2, str1);
          ad.i("MicroMsg.AppInfoLogic", "copyFileIfNeed filename: %s, type: %d, ret: %d", new Object[] { str1, Integer.valueOf(localException.getType()), Long.valueOf(l) });
          ((WXEmojiObject)localObject2).emojiPath = str1;
          break label888;
        }
        ad.e("MicroMsg.AppInfoLogic", "copyFileIfNeed file invalid: %s", new Object[] { str2 });
      }
      else if ((localException.mediaObject instanceof WXVideoFileObject))
      {
        localObject2 = (WXVideoFileObject)localException.mediaObject;
        str2 = ((WXVideoFileObject)localObject2).filePath;
        if (h.aAP(str2))
        {
          if (!str2.startsWith("content")) {
            break label893;
          }
          l = i.lC(str2, str1);
          ad.i("MicroMsg.AppInfoLogic", "copyFileIfNeed filename: %s, type: %d, ret: %d", new Object[] { str1, Integer.valueOf(localException.getType()), Long.valueOf(l) });
          ((WXVideoFileObject)localObject2).filePath = str1;
          break label893;
        }
        ad.e("MicroMsg.AppInfoLogic", "copyFileIfNeed file invalid: %s", new Object[] { str2 });
      }
      else if ((localException.mediaObject instanceof WXGameVideoFileObject))
      {
        localObject2 = (WXGameVideoFileObject)localException.mediaObject;
        str2 = ((WXGameVideoFileObject)localObject2).filePath;
        if (h.aAP(str2))
        {
          if (!str2.startsWith("content")) {
            break label898;
          }
          l = i.lC(str2, str1);
          ad.i("MicroMsg.AppInfoLogic", "copyFileIfNeed filename: %s, type: %d, ret: %d", new Object[] { str1, Integer.valueOf(localException.getType()), Long.valueOf(l) });
          ((WXGameVideoFileObject)localObject2).filePath = str1;
          break label898;
        }
        ad.e("MicroMsg.AppInfoLogic", "copyFileIfNeed file invalid: %s", new Object[] { str2 });
      }
      else if ((localException.mediaObject instanceof WXAppExtendObject))
      {
        localObject2 = (WXAppExtendObject)localException.mediaObject;
        str2 = ((WXAppExtendObject)localObject2).filePath;
        if (h.aAP(str2))
        {
          if (!str2.startsWith("content")) {
            break label903;
          }
          l = i.lC(str2, str1);
          ad.i("MicroMsg.AppInfoLogic", "copyFileIfNeed filename: %s, type: %d, ret: %d", new Object[] { str1, Integer.valueOf(localException.getType()), Long.valueOf(l) });
          ((WXAppExtendObject)localObject2).filePath = str1;
          break label903;
        }
        ad.e("MicroMsg.AppInfoLogic", "copyFileIfNeed file invalid: %s", new Object[] { str2 });
        break label878;
        label873:
        i = 1;
        continue;
      }
      label878:
      int i = 0;
      continue;
      label883:
      i = 1;
      continue;
      label888:
      i = 1;
      continue;
      label893:
      i = 1;
      continue;
      label898:
      i = 1;
      continue;
      label903:
      i = 1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.base.stub.WXEntryActivity.3
 * JD-Core Version:    0.7.0.1
 */