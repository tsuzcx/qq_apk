package com.tencent.mm.plugin.emoji;

import android.app.Activity;
import android.content.Context;
import android.content.IntentFilter;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.graphics.Point;
import android.view.Display;
import android.view.WindowManager;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.api.SmileyPanel;
import com.tencent.mm.api.aa.a;
import com.tencent.mm.api.z;
import com.tencent.mm.emoji.sync.EmojiUpdateReceiver;
import com.tencent.mm.plugin.emoji.b.b.a;
import com.tencent.mm.pluginsdk.g.h;
import com.tencent.mm.pluginsdk.ui.chat.k;
import com.tencent.mm.pluginsdk.ui.span.e.a;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.ai;
import com.tencent.mm.sdk.platformtools.bs;
import com.tencent.mm.storage.av;
import com.tencent.mm.storage.az;
import com.tencent.mm.storage.emotion.SmileyInfo;
import com.tencent.mm.vfs.NativeFileSystem;
import com.tencent.mm.vfs.QuotaFileSystem;
import com.tencent.mm.vfs.a.a;
import com.tencent.mm.vfs.o;
import com.tencent.mm.view.SmileyPanelImpl;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class PluginEmoji
  extends com.tencent.mm.kernel.b.f
  implements com.tencent.mm.plugin.emoji.b.d
{
  private com.tencent.mm.pluginsdk.a.d oWA;
  private long oWB = 838860800L;
  com.tencent.mm.pluginsdk.a.e oWC;
  
  public void configure(com.tencent.mm.kernel.b.g paramg)
  {
    AppMethodBeat.i(104556);
    e.a.a(com.tencent.mm.cf.g.eXw());
    com.tencent.mm.cf.b.eXh();
    h.eLx();
    com.tencent.mm.kernel.g.b(com.tencent.mm.plugin.emoji.b.c.class, d.cbg());
    if (paramg.ahL())
    {
      o.a("emoji", "emoji", this.oWB, 3);
      paramg = com.tencent.mm.loader.j.b.aoZ() + "emoji/cover/";
      QuotaFileSystem localQuotaFileSystem = new QuotaFileSystem(new NativeFileSystem(paramg), 52428800L, 83886080L);
      com.tencent.mm.vfs.a.ghk().ghm().a("emoji-cover", localQuotaFileSystem).lV(paramg, "emoji-cover").commit();
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
    if (paramg.ahL())
    {
      pin(e.cbl());
      if (paramg.ahL()) {
        com.tencent.mm.kernel.g.a(com.tencent.mm.plugin.emoji.b.a.class, new com.tencent.mm.kernel.c.e(new a()));
      }
      paramg = com.tencent.mm.sticker.loader.e.GAP;
      com.tencent.mm.sticker.loader.e.cDq();
    }
    for (;;)
    {
      com.tencent.mm.ui.f.b.c.a(new com.tencent.mm.ui.f.b.b()
      {
        public final com.tencent.mm.ui.f.b.a fj(String paramAnonymousString1, String paramAnonymousString2)
        {
          AppMethodBeat.i(104546);
          try
          {
            paramAnonymousString1 = com.tencent.mm.plugin.gif.c.cRR().gT(paramAnonymousString1, paramAnonymousString2);
            AppMethodBeat.o(104546);
            return paramAnonymousString1;
          }
          catch (IOException paramAnonymousString1)
          {
            ac.printErrStackTrace("MicroMsg.PluginEmoji", paramAnonymousString1, "", new Object[0]);
            AppMethodBeat.o(104546);
          }
          return null;
        }
      });
      com.tencent.mm.ui.f.c.b.a(new com.tencent.mm.ui.f.c.a()
      {
        public final CharSequence c(Context paramAnonymousContext, CharSequence paramAnonymousCharSequence, float paramAnonymousFloat)
        {
          AppMethodBeat.i(104548);
          paramAnonymousContext = com.tencent.mm.cf.g.eXw().b(paramAnonymousCharSequence, paramAnonymousFloat);
          AppMethodBeat.o(104548);
          return paramAnonymousContext;
        }
        
        public final int cO(String paramAnonymousString, int paramAnonymousInt)
        {
          AppMethodBeat.i(104549);
          com.tencent.mm.cf.g.eXw();
          Object localObject = com.tencent.mm.cf.f.eXr();
          if (bs.isNullOrNil(paramAnonymousString))
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
          if (com.tencent.mm.cf.f.Gyn == null)
          {
            StringBuilder localStringBuilder = new StringBuilder();
            int k = ((com.tencent.mm.cf.f)localObject).Gyc.length;
            i = 0;
            while (i < k)
            {
              localStringBuilder.append(Pattern.quote(localObject.Gyc[i]));
              if (i != k - 1) {
                localStringBuilder.append('|');
              }
              i += 1;
            }
            k = ((com.tencent.mm.cf.f)localObject).Gyd.length;
            i = 0;
            while (i < k)
            {
              localStringBuilder.append(Pattern.quote(localObject.Gyd[i]));
              if (i != k - 1) {
                localStringBuilder.append('|');
              }
              i += 1;
            }
            k = ((com.tencent.mm.cf.f)localObject).Gye.length;
            i = 0;
            while (i < k)
            {
              localStringBuilder.append(Pattern.quote(localObject.Gye[i]));
              if (i != k - 1) {
                localStringBuilder.append('|');
              }
              i += 1;
            }
            k = ((com.tencent.mm.cf.f)localObject).Gyf.length;
            i = 0;
            while (i < k)
            {
              localStringBuilder.append(Pattern.quote(localObject.Gyf[i]));
              if (i != k - 1) {
                localStringBuilder.append('|');
              }
              i += 1;
            }
            k = ((com.tencent.mm.cf.f)localObject).Gyg.length;
            i = 0;
            while (i < k)
            {
              localStringBuilder.append(Pattern.quote(localObject.Gyg[i]));
              if (i != k - 1) {
                localStringBuilder.append('|');
              }
              i += 1;
            }
            k = ((com.tencent.mm.cf.f)localObject).Gyh.length;
            i = 0;
            while (i < k)
            {
              localStringBuilder.append(Pattern.quote(localObject.Gyh[i]));
              if (i != k - 1) {
                localStringBuilder.append('|');
              }
              i += 1;
            }
            if ((((com.tencent.mm.cf.f)localObject).Gyi != null) && (!((com.tencent.mm.cf.f)localObject).Gyi.isEmpty()))
            {
              localObject = ((com.tencent.mm.cf.f)localObject).Gyi.iterator();
              while (((Iterator)localObject).hasNext())
              {
                SmileyInfo localSmileyInfo = (SmileyInfo)((Iterator)localObject).next();
                localStringBuilder.append(Pattern.quote(localSmileyInfo.field_key)).append("|");
                if (!bs.isNullOrNil(localSmileyInfo.field_cnValue)) {
                  localStringBuilder.append(Pattern.quote(localSmileyInfo.field_cnValue)).append("|");
                }
                if (!bs.isNullOrNil(localSmileyInfo.field_enValue)) {
                  localStringBuilder.append(Pattern.quote(localSmileyInfo.field_enValue)).append("|");
                }
                if (!bs.isNullOrNil(localSmileyInfo.field_qqValue)) {
                  localStringBuilder.append(Pattern.quote(localSmileyInfo.field_qqValue)).append("|");
                }
                if (!bs.isNullOrNil(localSmileyInfo.field_twValue)) {
                  localStringBuilder.append(Pattern.quote(localSmileyInfo.field_twValue)).append("|");
                }
                if (!bs.isNullOrNil(localSmileyInfo.field_thValue)) {
                  localStringBuilder.append(Pattern.quote(localSmileyInfo.field_thValue)).append("|");
                }
              }
            }
            com.tencent.mm.cf.f.Gyn = Pattern.compile(localStringBuilder.toString());
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
            paramAnonymousString = com.tencent.mm.cf.f.Gyn.matcher(paramAnonymousString);
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
        
        public final CharSequence i(CharSequence paramAnonymousCharSequence, int paramAnonymousInt)
        {
          AppMethodBeat.i(104547);
          paramAnonymousCharSequence = com.tencent.mm.cf.g.eXw().n(paramAnonymousCharSequence, paramAnonymousInt);
          AppMethodBeat.o(104547);
          return paramAnonymousCharSequence;
        }
      });
      com.tencent.mm.api.aa.cGT = new aa.a()
      {
        public final z JQ()
        {
          AppMethodBeat.i(104553);
          k localk = new k();
          AppMethodBeat.o(104553);
          return localk;
        }
        
        public final int bi(Context paramAnonymousContext)
        {
          boolean bool2 = false;
          AppMethodBeat.i(104552);
          int j = paramAnonymousContext.getResources().getDimensionPixelOffset(2131166247);
          int k = paramAnonymousContext.getResources().getDimensionPixelOffset(2131165299);
          if (paramAnonymousContext.getResources().getConfiguration().orientation == 1) {}
          Object localObject;
          for (int i = 1;; i = 0)
          {
            boolean bool1 = bool2;
            if ((paramAnonymousContext instanceof Activity))
            {
              localObject = (Activity)paramAnonymousContext;
              bool1 = bool2;
              if (com.tencent.mm.compatible.util.d.kZ(24)) {
                bool1 = ((Activity)localObject).isInMultiWindowMode();
              }
            }
            localObject = new Point();
            ((WindowManager)paramAnonymousContext.getSystemService("window")).getDefaultDisplay().getSize((Point)localObject);
            if ((i == 0) || (bool1)) {
              break label157;
            }
            i = ((Point)localObject).y / 2 - k;
            if ((i <= 0) || (i >= j)) {
              break;
            }
            AppMethodBeat.o(104552);
            return i;
          }
          AppMethodBeat.o(104552);
          return j;
          label157:
          i = paramAnonymousContext.getResources().getDimensionPixelOffset(2131166240);
          if ((((Point)localObject).y > 0) && (i > ((Point)localObject).y / 2))
          {
            i = ((Point)localObject).y / 2;
            AppMethodBeat.o(104552);
            return i;
          }
          AppMethodBeat.o(104552);
          return i;
        }
        
        public final SmileyPanel bj(Context paramAnonymousContext)
        {
          AppMethodBeat.i(104550);
          paramAnonymousContext = l(paramAnonymousContext, false);
          AppMethodBeat.o(104550);
          return paramAnonymousContext;
        }
        
        public final SmileyPanel l(Context paramAnonymousContext, boolean paramAnonymousBoolean)
        {
          AppMethodBeat.i(104551);
          paramAnonymousContext = new SmileyPanelImpl(paramAnonymousContext, paramAnonymousBoolean);
          AppMethodBeat.o(104551);
          return paramAnonymousContext;
        }
      };
      AppMethodBeat.o(104557);
      return;
      if ((paramg.up(":tools")) || (paramg.up(":toolsmp")))
      {
        paramg = new IntentFilter(EmojiUpdateReceiver.ACTION);
        ai.getContext().registerReceiver(new EmojiUpdateReceiver(), paramg);
      }
    }
  }
  
  public av getEmojiDescMgr()
  {
    AppMethodBeat.i(104562);
    av localav = b.a.oYv.getEmojiDescMgr();
    AppMethodBeat.o(104562);
    return localav;
  }
  
  public com.tencent.mm.pluginsdk.a.d getEmojiMgr()
  {
    AppMethodBeat.i(104559);
    setEmojiMgr();
    com.tencent.mm.pluginsdk.a.d locald = this.oWA;
    AppMethodBeat.o(104559);
    return locald;
  }
  
  public az getEmojiStorageMgr()
  {
    AppMethodBeat.i(104561);
    az localaz = b.a.oYv.getEmojiStorageMgr();
    AppMethodBeat.o(104561);
    return localaz;
  }
  
  public com.tencent.mm.pluginsdk.a.e getProvider()
  {
    AppMethodBeat.i(104560);
    if (this.oWC == null) {
      this.oWC = new com.tencent.mm.cb.a();
    }
    com.tencent.mm.pluginsdk.a.e locale = this.oWC;
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
    this.oWA = null;
  }
  
  public void setEmojiMgr()
  {
    AppMethodBeat.i(104558);
    if (this.oWA == null) {
      this.oWA = b.a.oYv.getEmojiMgr();
    }
    AppMethodBeat.o(104558);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.emoji.PluginEmoji
 * JD-Core Version:    0.7.0.1
 */