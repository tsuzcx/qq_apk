package com.tencent.mm.plugin.emoji;

import android.content.Context;
import android.content.IntentFilter;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.emoji.sync.EmojiUpdateReceiver;
import com.tencent.mm.plugin.emoji.b.b.a;
import com.tencent.mm.pluginsdk.ui.span.f.a;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.bf;
import com.tencent.mm.storage.bj;
import com.tencent.mm.storage.emotion.SmileyInfo;
import com.tencent.mm.vfs.NativeFileSystem;
import com.tencent.mm.vfs.QuotaFileSystem;
import com.tencent.mm.vfs.ab;
import com.tencent.mm.vfs.h.a;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class PluginEmoji
  extends com.tencent.mm.kernel.b.f
  implements com.tencent.mm.plugin.emoji.b.d
{
  private com.tencent.mm.pluginsdk.b.d uzo;
  private long uzp = 838860800L;
  com.tencent.mm.pluginsdk.b.e uzq;
  
  public void configure(com.tencent.mm.kernel.b.g paramg)
  {
    AppMethodBeat.i(104556);
    f.a.a(com.tencent.mm.cl.h.htZ());
    com.tencent.mm.cl.b.htF();
    com.tencent.mm.pluginsdk.j.f.hhY();
    com.tencent.mm.kernel.h.b(com.tencent.mm.plugin.emoji.b.c.class, g.cTr());
    if (paramg.aIE())
    {
      ab.a("emoji", "emoji", this.uzp, 7776000000L, 1);
      paramg = com.tencent.mm.loader.j.b.aSD() + "emoji/cover/";
      QuotaFileSystem localQuotaFileSystem = new QuotaFileSystem(new NativeFileSystem(paramg), 52428800L, 83886080L, 7776000000L);
      com.tencent.mm.vfs.h.iWH().iWK().a("emoji-cover", localQuotaFileSystem).oi(paramg, "emoji-cover").commit();
    }
    AppMethodBeat.o(104556);
  }
  
  public void dependency()
  {
    AppMethodBeat.i(104555);
    dependsOn(com.tencent.mm.plugin.comm.a.a.class);
    AppMethodBeat.o(104555);
  }
  
  public void execute(com.tencent.mm.kernel.b.g paramg)
  {
    AppMethodBeat.i(104557);
    if (paramg.aIE())
    {
      pin(h.cTw());
      if (paramg.aIE()) {
        com.tencent.mm.kernel.h.a(com.tencent.mm.plugin.emoji.b.a.class, new com.tencent.mm.kernel.c.e(new b()));
      }
      paramg = com.tencent.mm.sticker.loader.e.Vbx;
      com.tencent.mm.sticker.loader.e.hqw();
    }
    for (;;)
    {
      com.tencent.mm.ui.h.b.c.a(new PluginEmoji.1(this));
      com.tencent.mm.ui.h.c.b.a(new com.tencent.mm.ui.h.c.a()
      {
        public final CharSequence a(Context paramAnonymousContext, CharSequence paramAnonymousCharSequence, int paramAnonymousInt)
        {
          AppMethodBeat.i(236142);
          paramAnonymousContext = com.tencent.mm.cl.h.htZ().a(paramAnonymousContext, paramAnonymousCharSequence, paramAnonymousInt);
          AppMethodBeat.o(236142);
          return paramAnonymousContext;
        }
        
        public final CharSequence c(Context paramAnonymousContext, CharSequence paramAnonymousCharSequence, float paramAnonymousFloat)
        {
          AppMethodBeat.i(104548);
          paramAnonymousContext = com.tencent.mm.cl.h.htZ().a(paramAnonymousContext, paramAnonymousCharSequence, paramAnonymousFloat);
          AppMethodBeat.o(104548);
          return paramAnonymousContext;
        }
        
        public final int dv(String paramAnonymousString, int paramAnonymousInt)
        {
          AppMethodBeat.i(104549);
          com.tencent.mm.cl.h.htZ();
          Object localObject = com.tencent.mm.cl.g.htS();
          if (Util.isNullOrNil(paramAnonymousString))
          {
            AppMethodBeat.o(104549);
            return paramAnonymousInt;
          }
          int j = paramAnonymousString.length();
          if ((paramAnonymousInt == 0) || (paramAnonymousInt == j))
          {
            AppMethodBeat.o(104549);
            return paramAnonymousInt;
          }
          if (com.tencent.mm.cl.g.UYR == null)
          {
            StringBuilder localStringBuilder = new StringBuilder();
            int k = ((com.tencent.mm.cl.g)localObject).UYD.length;
            i = 0;
            while (i < k)
            {
              localStringBuilder.append(Pattern.quote(localObject.UYD[i]));
              if (i != k - 1) {
                localStringBuilder.append('|');
              }
              i += 1;
            }
            k = ((com.tencent.mm.cl.g)localObject).UYE.length;
            i = 0;
            while (i < k)
            {
              localStringBuilder.append(Pattern.quote(localObject.UYE[i]));
              if (i != k - 1) {
                localStringBuilder.append('|');
              }
              i += 1;
            }
            k = ((com.tencent.mm.cl.g)localObject).UYF.length;
            i = 0;
            while (i < k)
            {
              localStringBuilder.append(Pattern.quote(localObject.UYF[i]));
              if (i != k - 1) {
                localStringBuilder.append('|');
              }
              i += 1;
            }
            k = ((com.tencent.mm.cl.g)localObject).UYG.length;
            i = 0;
            while (i < k)
            {
              localStringBuilder.append(Pattern.quote(localObject.UYG[i]));
              if (i != k - 1) {
                localStringBuilder.append('|');
              }
              i += 1;
            }
            k = ((com.tencent.mm.cl.g)localObject).UYH.length;
            i = 0;
            while (i < k)
            {
              localStringBuilder.append(Pattern.quote(localObject.UYH[i]));
              if (i != k - 1) {
                localStringBuilder.append('|');
              }
              i += 1;
            }
            k = ((com.tencent.mm.cl.g)localObject).UYI.length;
            i = 0;
            while (i < k)
            {
              localStringBuilder.append(Pattern.quote(localObject.UYI[i]));
              if (i != k - 1) {
                localStringBuilder.append('|');
              }
              i += 1;
            }
            if ((((com.tencent.mm.cl.g)localObject).UYJ != null) && (!((com.tencent.mm.cl.g)localObject).UYJ.isEmpty()))
            {
              localObject = ((com.tencent.mm.cl.g)localObject).UYJ.iterator();
              while (((Iterator)localObject).hasNext())
              {
                SmileyInfo localSmileyInfo = (SmileyInfo)((Iterator)localObject).next();
                localStringBuilder.append(Pattern.quote(localSmileyInfo.field_key)).append("|");
                if (!Util.isNullOrNil(localSmileyInfo.field_cnValue)) {
                  localStringBuilder.append(Pattern.quote(localSmileyInfo.field_cnValue)).append("|");
                }
                if (!Util.isNullOrNil(localSmileyInfo.field_enValue)) {
                  localStringBuilder.append(Pattern.quote(localSmileyInfo.field_enValue)).append("|");
                }
                if (!Util.isNullOrNil(localSmileyInfo.field_qqValue)) {
                  localStringBuilder.append(Pattern.quote(localSmileyInfo.field_qqValue)).append("|");
                }
                if (!Util.isNullOrNil(localSmileyInfo.field_twValue)) {
                  localStringBuilder.append(Pattern.quote(localSmileyInfo.field_twValue)).append("|");
                }
                if (!Util.isNullOrNil(localSmileyInfo.field_thValue)) {
                  localStringBuilder.append(Pattern.quote(localSmileyInfo.field_thValue)).append("|");
                }
              }
            }
            com.tencent.mm.cl.g.UYR = Pattern.compile(localStringBuilder.toString());
          }
          if (paramAnonymousInt < 6)
          {
            i = 0;
            if (paramAnonymousInt + 6 < j) {
              break label728;
            }
            j -= 1;
            label653:
            paramAnonymousString = paramAnonymousString.substring(i, j);
            paramAnonymousString = com.tencent.mm.cl.g.UYR.matcher(paramAnonymousString);
            do
            {
              if (!paramAnonymousString.find()) {
                break;
              }
            } while ((6 <= paramAnonymousString.start()) || (6 >= paramAnonymousString.end()));
          }
          for (int i = paramAnonymousString.start();; i = 6)
          {
            if (i - 6 > 0) {
              i -= 6;
            }
            for (;;)
            {
              AppMethodBeat.o(104549);
              return paramAnonymousInt + i;
              i = paramAnonymousInt - 6;
              break;
              label728:
              j = paramAnonymousInt + 6;
              break label653;
              i = 0;
            }
          }
        }
      });
      com.tencent.mm.api.ad.faK = new PluginEmoji.3(this);
      AppMethodBeat.o(104557);
      return;
      if ((paramg.MY(":tools")) || (paramg.MY(":toolsmp")))
      {
        paramg = new IntentFilter(EmojiUpdateReceiver.ACTION);
        MMApplicationContext.getContext().registerReceiver(new EmojiUpdateReceiver(), paramg);
      }
    }
  }
  
  public bf getEmojiDescMgr()
  {
    AppMethodBeat.i(104562);
    bf localbf = b.a.uBk.getEmojiDescMgr();
    AppMethodBeat.o(104562);
    return localbf;
  }
  
  public com.tencent.mm.pluginsdk.b.d getEmojiMgr()
  {
    AppMethodBeat.i(104559);
    setEmojiMgr();
    com.tencent.mm.pluginsdk.b.d locald = this.uzo;
    AppMethodBeat.o(104559);
    return locald;
  }
  
  public bj getEmojiStorageMgr()
  {
    AppMethodBeat.i(104561);
    bj localbj = b.a.uBk.getEmojiStorageMgr();
    AppMethodBeat.o(104561);
    return localbj;
  }
  
  public com.tencent.mm.pluginsdk.b.e getProvider()
  {
    AppMethodBeat.i(104560);
    if (this.uzq == null) {
      this.uzq = new com.tencent.mm.ch.a();
    }
    com.tencent.mm.pluginsdk.b.e locale = this.uzq;
    AppMethodBeat.o(104560);
    return locale;
  }
  
  public void installed()
  {
    AppMethodBeat.i(104554);
    alias(com.tencent.mm.plugin.emoji.b.d.class);
    AppMethodBeat.o(104554);
  }
  
  public String name()
  {
    return "plugin-emoji";
  }
  
  public void removeEmojiMgr()
  {
    this.uzo = null;
  }
  
  public void setEmojiMgr()
  {
    AppMethodBeat.i(104558);
    if (this.uzo == null) {
      this.uzo = b.a.uBk.getEmojiMgr();
    }
    AppMethodBeat.o(104558);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.emoji.PluginEmoji
 * JD-Core Version:    0.7.0.1
 */