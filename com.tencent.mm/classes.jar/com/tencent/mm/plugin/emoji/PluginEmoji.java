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
import com.tencent.mm.api.ad;
import com.tencent.mm.api.ae.a;
import com.tencent.mm.emoji.sync.EmojiUpdateReceiver;
import com.tencent.mm.kernel.h;
import com.tencent.mm.plugin.emoji.c.b.a;
import com.tencent.mm.plugin.m.a.e;
import com.tencent.mm.pluginsdk.ui.span.f.a;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.smiley.EmojiHelper;
import com.tencent.mm.smiley.QQSmileyManager;
import com.tencent.mm.smiley.m;
import com.tencent.mm.smiley.n;
import com.tencent.mm.smiley.t;
import com.tencent.mm.smiley.t.a;
import com.tencent.mm.smiley.u;
import com.tencent.mm.storage.bh;
import com.tencent.mm.storage.bl;
import com.tencent.mm.vfs.NativeFileSystem;
import com.tencent.mm.vfs.QuotaFileSystem;
import com.tencent.mm.vfs.af;
import com.tencent.mm.vfs.k.a;
import com.tencent.mm.view.SmileyPanelImpl;
import java.io.IOException;
import kotlin.g.b.ah.d;

public class PluginEmoji
  extends com.tencent.mm.kernel.b.f
  implements com.tencent.mm.plugin.emoji.c.d
{
  private com.tencent.mm.pluginsdk.b.d xFO;
  private long xFP = 838860800L;
  com.tencent.mm.pluginsdk.b.e xFQ;
  
  public void configure(com.tencent.mm.kernel.b.g paramg)
  {
    AppMethodBeat.i(104556);
    f.a.a(u.iVt());
    EmojiHelper.iUM();
    com.tencent.mm.pluginsdk.platformtools.f.iIY();
    h.b(com.tencent.mm.plugin.emoji.c.c.class, f.dxM());
    if (paramg.bbA())
    {
      af.b("emoji", "emoji", this.xFP, 7776000000L, 1);
      paramg = com.tencent.mm.loader.i.b.bmr() + "emoji/cover/";
      QuotaFileSystem localQuotaFileSystem = new QuotaFileSystem(new NativeFileSystem(paramg), 52428800L, 83886080L, 7776000000L);
      com.tencent.mm.vfs.k.kMs().kMv().a("emoji-cover", localQuotaFileSystem).qg(paramg, "emoji-cover").commit();
    }
    AppMethodBeat.o(104556);
  }
  
  public void dependency()
  {
    AppMethodBeat.i(104555);
    dependsOn(com.tencent.mm.plugin.comm.a.b.class);
    AppMethodBeat.o(104555);
  }
  
  public void execute(com.tencent.mm.kernel.b.g paramg)
  {
    AppMethodBeat.i(104557);
    if (paramg.bbA())
    {
      pin(g.dxR());
      if (paramg.bbA()) {
        h.a(com.tencent.mm.plugin.emoji.c.a.class, new com.tencent.mm.kernel.c.e(new b()));
      }
      paramg = com.tencent.mm.sticker.loader.e.acCJ;
      com.tencent.mm.sticker.loader.e.fio();
    }
    for (;;)
    {
      com.tencent.mm.ui.i.b.c.a(new com.tencent.mm.ui.i.b.b()
      {
        public final com.tencent.mm.ui.i.b.a gH(String paramAnonymousString1, String paramAnonymousString2)
        {
          AppMethodBeat.i(104546);
          try
          {
            paramAnonymousString1 = com.tencent.mm.plugin.gif.c.fJa().jj(paramAnonymousString1, paramAnonymousString2);
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
      com.tencent.mm.ui.i.c.b.a(new com.tencent.mm.ui.i.c.a()
      {
        public final CharSequence a(Context paramAnonymousContext, CharSequence paramAnonymousCharSequence, int paramAnonymousInt)
        {
          AppMethodBeat.i(269807);
          paramAnonymousContext = u.iVt().a(paramAnonymousContext, paramAnonymousCharSequence, paramAnonymousInt);
          AppMethodBeat.o(269807);
          return paramAnonymousContext;
        }
        
        public final CharSequence c(Context paramAnonymousContext, CharSequence paramAnonymousCharSequence, float paramAnonymousFloat)
        {
          AppMethodBeat.i(104548);
          paramAnonymousContext = u.iVt().a(paramAnonymousContext, paramAnonymousCharSequence, paramAnonymousFloat);
          AppMethodBeat.o(104548);
          return paramAnonymousContext;
        }
        
        public final int dW(String paramAnonymousString, int paramAnonymousInt)
        {
          AppMethodBeat.i(104549);
          u.iVt();
          t localt = QQSmileyManager.iVq().acyI;
          paramAnonymousString = (CharSequence)paramAnonymousString;
          com.tencent.mm.smiley.f localf = new com.tencent.mm.smiley.f((n)localt.acyv);
          ah.d locald = new ah.d();
          locald.aixb = paramAnonymousInt;
          localf.b(paramAnonymousString, paramAnonymousInt - localt.maxLength, paramAnonymousInt + localt.maxLength, (m)new t.a(paramAnonymousInt, locald));
          paramAnonymousInt = locald.aixb;
          AppMethodBeat.o(104549);
          return paramAnonymousInt;
        }
      });
      com.tencent.mm.api.ae.hek = new ae.a()
      {
        public final ad aBK()
        {
          AppMethodBeat.i(104553);
          com.tencent.mm.pluginsdk.ui.chat.k localk = new com.tencent.mm.pluginsdk.ui.chat.k();
          AppMethodBeat.o(104553);
          return localk;
        }
        
        public final int cp(Context paramAnonymousContext)
        {
          AppMethodBeat.i(104552);
          int i = paramAnonymousContext.getResources().getDimensionPixelOffset(a.e.emoji_panel_max_height);
          int j = paramAnonymousContext.getResources().getDimensionPixelOffset(a.e.Edge_7A);
          boolean bool1;
          Object localObject;
          if (paramAnonymousContext.getResources().getConfiguration().orientation == 1)
          {
            bool1 = true;
            if (!(paramAnonymousContext instanceof Activity)) {
              break label271;
            }
            localObject = (Activity)paramAnonymousContext;
            if (!com.tencent.mm.compatible.util.d.rb(24)) {
              break label271;
            }
          }
          label271:
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
            i = paramAnonymousContext.getResources().getDimensionPixelOffset(a.e.emoji_panel_height_min);
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
        
        public final SmileyPanel cq(Context paramAnonymousContext)
        {
          AppMethodBeat.i(104550);
          paramAnonymousContext = n(paramAnonymousContext, false);
          AppMethodBeat.o(104550);
          return paramAnonymousContext;
        }
        
        public final SmileyPanel n(Context paramAnonymousContext, boolean paramAnonymousBoolean)
        {
          AppMethodBeat.i(104551);
          paramAnonymousContext = new SmileyPanelImpl(paramAnonymousContext, paramAnonymousBoolean);
          AppMethodBeat.o(104551);
          return paramAnonymousContext;
        }
      };
      AppMethodBeat.o(104557);
      return;
      paramg = new IntentFilter(EmojiUpdateReceiver.mnL);
      MMApplicationContext.getContext().registerReceiver(new EmojiUpdateReceiver(), paramg);
    }
  }
  
  public bh getEmojiDescMgr()
  {
    AppMethodBeat.i(104562);
    bh localbh = b.a.xHR.getEmojiDescMgr();
    AppMethodBeat.o(104562);
    return localbh;
  }
  
  public com.tencent.mm.pluginsdk.b.d getEmojiMgr()
  {
    AppMethodBeat.i(104559);
    setEmojiMgr();
    com.tencent.mm.pluginsdk.b.d locald = this.xFO;
    AppMethodBeat.o(104559);
    return locald;
  }
  
  public bl getEmojiStorageMgr()
  {
    AppMethodBeat.i(104561);
    bl localbl = b.a.xHR.getEmojiStorageMgr();
    AppMethodBeat.o(104561);
    return localbl;
  }
  
  public com.tencent.mm.pluginsdk.b.e getProvider()
  {
    AppMethodBeat.i(104560);
    if (this.xFQ == null) {
      this.xFQ = new com.tencent.mm.cc.a();
    }
    com.tencent.mm.pluginsdk.b.e locale = this.xFQ;
    AppMethodBeat.o(104560);
    return locale;
  }
  
  public void installed()
  {
    AppMethodBeat.i(104554);
    alias(com.tencent.mm.plugin.emoji.c.d.class);
    AppMethodBeat.o(104554);
  }
  
  public String name()
  {
    return "plugin-emoji";
  }
  
  public void removeEmojiMgr()
  {
    this.xFO = null;
  }
  
  public void setEmojiMgr()
  {
    AppMethodBeat.i(104558);
    if (this.xFO == null) {
      this.xFO = b.a.xHR.getEmojiMgr();
    }
    AppMethodBeat.o(104558);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.emoji.PluginEmoji
 * JD-Core Version:    0.7.0.1
 */