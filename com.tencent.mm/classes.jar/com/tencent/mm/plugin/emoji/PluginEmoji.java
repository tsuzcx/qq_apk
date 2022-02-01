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
import com.tencent.mm.api.ac;
import com.tencent.mm.api.ad.a;
import com.tencent.mm.emoji.sync.EmojiUpdateReceiver;
import com.tencent.mm.plugin.emoji.b.b.a;
import com.tencent.mm.pluginsdk.ui.chat.k;
import com.tencent.mm.pluginsdk.ui.span.f.a;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.bf;
import com.tencent.mm.storage.bj;
import com.tencent.mm.storage.emotion.SmileyInfo;
import com.tencent.mm.vfs.NativeFileSystem;
import com.tencent.mm.vfs.QuotaFileSystem;
import com.tencent.mm.vfs.g.a;
import com.tencent.mm.vfs.y;
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
  private com.tencent.mm.pluginsdk.a.d qWA;
  private long qWB = 838860800L;
  com.tencent.mm.pluginsdk.a.e qWC;
  
  public void configure(com.tencent.mm.kernel.b.g paramg)
  {
    AppMethodBeat.i(104556);
    f.a.a(com.tencent.mm.ce.g.gxZ());
    com.tencent.mm.ce.b.gxI();
    com.tencent.mm.pluginsdk.i.f.gns();
    com.tencent.mm.kernel.g.b(com.tencent.mm.plugin.emoji.b.c.class, e.cEM());
    if (paramg.aBb())
    {
      y.a("emoji", "emoji", this.qWB, 3);
      paramg = com.tencent.mm.loader.j.b.aKB() + "emoji/cover/";
      QuotaFileSystem localQuotaFileSystem = new QuotaFileSystem(new NativeFileSystem(paramg), 52428800L, 83886080L);
      com.tencent.mm.vfs.g.hRR().hRT().a("emoji-cover", localQuotaFileSystem).ns(paramg, "emoji-cover").commit();
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
    if (paramg.aBb())
    {
      pin(f.cER());
      if (paramg.aBb()) {
        com.tencent.mm.kernel.g.a(com.tencent.mm.plugin.emoji.b.a.class, new com.tencent.mm.kernel.c.e(new b()));
      }
      paramg = com.tencent.mm.sticker.loader.e.NNN;
      com.tencent.mm.sticker.loader.e.gzb();
    }
    for (;;)
    {
      com.tencent.mm.ui.g.b.c.a(new com.tencent.mm.ui.g.b.b()
      {
        public final com.tencent.mm.ui.g.b.a fP(String paramAnonymousString1, String paramAnonymousString2)
        {
          AppMethodBeat.i(104546);
          try
          {
            paramAnonymousString1 = com.tencent.mm.plugin.gif.c.dXx().hT(paramAnonymousString1, paramAnonymousString2);
            AppMethodBeat.o(104546);
            return paramAnonymousString1;
          }
          catch (IOException paramAnonymousString1)
          {
            Log.printErrStackTrace("MicroMsg.PluginEmoji", paramAnonymousString1, "", new Object[0]);
            AppMethodBeat.o(104546);
          }
          return null;
        }
      });
      com.tencent.mm.ui.g.c.b.a(new com.tencent.mm.ui.g.c.a()
      {
        public final CharSequence a(Context paramAnonymousContext, CharSequence paramAnonymousCharSequence, int paramAnonymousInt)
        {
          AppMethodBeat.i(199781);
          paramAnonymousContext = com.tencent.mm.ce.g.gxZ().b(paramAnonymousContext, paramAnonymousCharSequence, paramAnonymousInt);
          AppMethodBeat.o(199781);
          return paramAnonymousContext;
        }
        
        public final CharSequence c(Context paramAnonymousContext, CharSequence paramAnonymousCharSequence, float paramAnonymousFloat)
        {
          AppMethodBeat.i(104548);
          paramAnonymousContext = com.tencent.mm.ce.g.gxZ().a(paramAnonymousContext, paramAnonymousCharSequence, paramAnonymousFloat);
          AppMethodBeat.o(104548);
          return paramAnonymousContext;
        }
        
        public final int db(String paramAnonymousString, int paramAnonymousInt)
        {
          AppMethodBeat.i(104549);
          com.tencent.mm.ce.g.gxZ();
          Object localObject = com.tencent.mm.ce.f.gxT();
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
          if (com.tencent.mm.ce.f.NLl == null)
          {
            StringBuilder localStringBuilder = new StringBuilder();
            int k = ((com.tencent.mm.ce.f)localObject).NKX.length;
            i = 0;
            while (i < k)
            {
              localStringBuilder.append(Pattern.quote(localObject.NKX[i]));
              if (i != k - 1) {
                localStringBuilder.append('|');
              }
              i += 1;
            }
            k = ((com.tencent.mm.ce.f)localObject).NKY.length;
            i = 0;
            while (i < k)
            {
              localStringBuilder.append(Pattern.quote(localObject.NKY[i]));
              if (i != k - 1) {
                localStringBuilder.append('|');
              }
              i += 1;
            }
            k = ((com.tencent.mm.ce.f)localObject).NKZ.length;
            i = 0;
            while (i < k)
            {
              localStringBuilder.append(Pattern.quote(localObject.NKZ[i]));
              if (i != k - 1) {
                localStringBuilder.append('|');
              }
              i += 1;
            }
            k = ((com.tencent.mm.ce.f)localObject).NLa.length;
            i = 0;
            while (i < k)
            {
              localStringBuilder.append(Pattern.quote(localObject.NLa[i]));
              if (i != k - 1) {
                localStringBuilder.append('|');
              }
              i += 1;
            }
            k = ((com.tencent.mm.ce.f)localObject).NLb.length;
            i = 0;
            while (i < k)
            {
              localStringBuilder.append(Pattern.quote(localObject.NLb[i]));
              if (i != k - 1) {
                localStringBuilder.append('|');
              }
              i += 1;
            }
            k = ((com.tencent.mm.ce.f)localObject).NLc.length;
            i = 0;
            while (i < k)
            {
              localStringBuilder.append(Pattern.quote(localObject.NLc[i]));
              if (i != k - 1) {
                localStringBuilder.append('|');
              }
              i += 1;
            }
            if ((((com.tencent.mm.ce.f)localObject).NLd != null) && (!((com.tencent.mm.ce.f)localObject).NLd.isEmpty()))
            {
              localObject = ((com.tencent.mm.ce.f)localObject).NLd.iterator();
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
            com.tencent.mm.ce.f.NLl = Pattern.compile(localStringBuilder.toString());
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
            paramAnonymousString = com.tencent.mm.ce.f.NLl.matcher(paramAnonymousString);
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
      com.tencent.mm.api.ad.djd = new ad.a()
      {
        public final ac VL()
        {
          AppMethodBeat.i(104553);
          k localk = new k();
          AppMethodBeat.o(104553);
          return localk;
        }
        
        public final int bD(Context paramAnonymousContext)
        {
          AppMethodBeat.i(104552);
          int i = paramAnonymousContext.getResources().getDimensionPixelOffset(2131166290);
          int j = paramAnonymousContext.getResources().getDimensionPixelOffset(2131165310);
          boolean bool1;
          Object localObject;
          if (paramAnonymousContext.getResources().getConfiguration().orientation == 1)
          {
            bool1 = true;
            if (!(paramAnonymousContext instanceof Activity)) {
              break label268;
            }
            localObject = (Activity)paramAnonymousContext;
            if (!com.tencent.mm.compatible.util.d.oD(24)) {
              break label268;
            }
          }
          label268:
          for (boolean bool2 = ((Activity)localObject).isInMultiWindowMode();; bool2 = false)
          {
            localObject = new Point();
            ((WindowManager)paramAnonymousContext.getSystemService("window")).getDefaultDisplay().getSize((Point)localObject);
            if ((bool1) && (!bool2))
            {
              j = ((Point)localObject).y / 2 - j;
              Log.i("MicroMsg.PluginEmoji", "getRecommendHeight: %s, %s", new Object[] { Integer.valueOf(j), Integer.valueOf(i) });
              if ((j > 0) && (j < i))
              {
                AppMethodBeat.o(104552);
                return j;
                bool1 = false;
                break;
              }
              AppMethodBeat.o(104552);
              return i;
            }
            i = paramAnonymousContext.getResources().getDimensionPixelOffset(2131166283);
            Log.i("MicroMsg.PluginEmoji", "getRecommendHeight: %s, %s, %s, %s", new Object[] { Boolean.valueOf(bool1), Boolean.valueOf(bool2), Integer.valueOf(i), Integer.valueOf(((Point)localObject).y) });
            if ((((Point)localObject).y > 0) && (i > ((Point)localObject).y / 2))
            {
              i = ((Point)localObject).y / 2;
              AppMethodBeat.o(104552);
              return i;
            }
            AppMethodBeat.o(104552);
            return i;
          }
        }
        
        public final SmileyPanel bE(Context paramAnonymousContext)
        {
          AppMethodBeat.i(104550);
          paramAnonymousContext = m(paramAnonymousContext, false);
          AppMethodBeat.o(104550);
          return paramAnonymousContext;
        }
        
        public final SmileyPanel m(Context paramAnonymousContext, boolean paramAnonymousBoolean)
        {
          AppMethodBeat.i(104551);
          paramAnonymousContext = new SmileyPanelImpl(paramAnonymousContext, paramAnonymousBoolean);
          AppMethodBeat.o(104551);
          return paramAnonymousContext;
        }
      };
      AppMethodBeat.o(104557);
      return;
      if ((paramg.FY(":tools")) || (paramg.FY(":toolsmp")))
      {
        paramg = new IntentFilter(EmojiUpdateReceiver.ACTION);
        MMApplicationContext.getContext().registerReceiver(new EmojiUpdateReceiver(), paramg);
      }
    }
  }
  
  public bf getEmojiDescMgr()
  {
    AppMethodBeat.i(104562);
    bf localbf = b.a.qYv.getEmojiDescMgr();
    AppMethodBeat.o(104562);
    return localbf;
  }
  
  public com.tencent.mm.pluginsdk.a.d getEmojiMgr()
  {
    AppMethodBeat.i(104559);
    setEmojiMgr();
    com.tencent.mm.pluginsdk.a.d locald = this.qWA;
    AppMethodBeat.o(104559);
    return locald;
  }
  
  public bj getEmojiStorageMgr()
  {
    AppMethodBeat.i(104561);
    bj localbj = b.a.qYv.getEmojiStorageMgr();
    AppMethodBeat.o(104561);
    return localbj;
  }
  
  public com.tencent.mm.pluginsdk.a.e getProvider()
  {
    AppMethodBeat.i(104560);
    if (this.qWC == null) {
      this.qWC = new com.tencent.mm.ca.a();
    }
    com.tencent.mm.pluginsdk.a.e locale = this.qWC;
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
    this.qWA = null;
  }
  
  public void setEmojiMgr()
  {
    AppMethodBeat.i(104558);
    if (this.qWA == null) {
      this.qWA = b.a.qYv.getEmojiMgr();
    }
    AppMethodBeat.o(104558);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.emoji.PluginEmoji
 * JD-Core Version:    0.7.0.1
 */