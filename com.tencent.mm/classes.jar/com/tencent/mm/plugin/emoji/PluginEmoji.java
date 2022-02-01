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
import com.tencent.mm.kernel.b.f;
import com.tencent.mm.plugin.emoji.b.b.a;
import com.tencent.mm.pluginsdk.i.i;
import com.tencent.mm.pluginsdk.ui.chat.k;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.ak;
import com.tencent.mm.storage.ba;
import com.tencent.mm.storage.be;
import com.tencent.mm.vfs.NativeFileSystem;
import com.tencent.mm.vfs.QuotaFileSystem;
import com.tencent.mm.vfs.u;
import com.tencent.mm.view.SmileyPanelImpl;
import java.io.IOException;

public class PluginEmoji
  extends f
  implements com.tencent.mm.plugin.emoji.b.d
{
  private com.tencent.mm.pluginsdk.a.d pGO;
  private long pGP = 838860800L;
  com.tencent.mm.pluginsdk.a.e pGQ;
  
  public void configure(com.tencent.mm.kernel.b.g paramg)
  {
    AppMethodBeat.i(104556);
    com.tencent.mm.pluginsdk.ui.span.e.a.a(com.tencent.mm.ce.g.fqZ());
    com.tencent.mm.ce.b.fqL();
    i.fei();
    com.tencent.mm.kernel.g.b(com.tencent.mm.plugin.emoji.b.c.class, d.cha());
    if (paramg.akL())
    {
      u.a("emoji", "emoji", this.pGP, 3);
      paramg = com.tencent.mm.loader.j.b.asb() + "emoji/cover/";
      QuotaFileSystem localQuotaFileSystem = new QuotaFileSystem(new NativeFileSystem(paramg), 52428800L, 83886080L);
      com.tencent.mm.vfs.e.fSU().gEk().a("emoji-cover", localQuotaFileSystem).mB(paramg, "emoji-cover").commit();
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
    if (paramg.akL())
    {
      pin(e.chf());
      if (paramg.akL()) {
        com.tencent.mm.kernel.g.a(com.tencent.mm.plugin.emoji.b.a.class, new com.tencent.mm.kernel.c.e(new a()));
      }
      paramg = com.tencent.mm.sticker.loader.e.IGU;
      com.tencent.mm.sticker.loader.e.cOs();
    }
    for (;;)
    {
      com.tencent.mm.ui.f.b.c.a(new com.tencent.mm.ui.f.b.b()
      {
        public final com.tencent.mm.ui.f.b.a fx(String paramAnonymousString1, String paramAnonymousString2)
        {
          AppMethodBeat.i(104546);
          try
          {
            paramAnonymousString1 = com.tencent.mm.plugin.gif.c.ddO().hm(paramAnonymousString1, paramAnonymousString2);
            AppMethodBeat.o(104546);
            return paramAnonymousString1;
          }
          catch (IOException paramAnonymousString1)
          {
            ae.printErrStackTrace("MicroMsg.PluginEmoji", paramAnonymousString1, "", new Object[0]);
            AppMethodBeat.o(104546);
          }
          return null;
        }
      });
      com.tencent.mm.ui.f.c.b.a(new PluginEmoji.2(this));
      com.tencent.mm.api.aa.cSH = new aa.a()
      {
        public final z Lx()
        {
          AppMethodBeat.i(104553);
          k localk = new k();
          AppMethodBeat.o(104553);
          return localk;
        }
        
        public final int bj(Context paramAnonymousContext)
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
              if (com.tencent.mm.compatible.util.d.lA(24)) {
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
        
        public final SmileyPanel bk(Context paramAnonymousContext)
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
      if ((paramg.xO(":tools")) || (paramg.xO(":toolsmp")))
      {
        paramg = new IntentFilter(EmojiUpdateReceiver.ACTION);
        ak.getContext().registerReceiver(new EmojiUpdateReceiver(), paramg);
      }
    }
  }
  
  public ba getEmojiDescMgr()
  {
    AppMethodBeat.i(104562);
    ba localba = b.a.pIJ.getEmojiDescMgr();
    AppMethodBeat.o(104562);
    return localba;
  }
  
  public com.tencent.mm.pluginsdk.a.d getEmojiMgr()
  {
    AppMethodBeat.i(104559);
    setEmojiMgr();
    com.tencent.mm.pluginsdk.a.d locald = this.pGO;
    AppMethodBeat.o(104559);
    return locald;
  }
  
  public be getEmojiStorageMgr()
  {
    AppMethodBeat.i(104561);
    be localbe = b.a.pIJ.getEmojiStorageMgr();
    AppMethodBeat.o(104561);
    return localbe;
  }
  
  public com.tencent.mm.pluginsdk.a.e getProvider()
  {
    AppMethodBeat.i(104560);
    if (this.pGQ == null) {
      this.pGQ = new com.tencent.mm.ca.a();
    }
    com.tencent.mm.pluginsdk.a.e locale = this.pGQ;
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
    this.pGO = null;
  }
  
  public void setEmojiMgr()
  {
    AppMethodBeat.i(104558);
    if (this.pGO == null) {
      this.pGO = b.a.pIJ.getEmojiMgr();
    }
    AppMethodBeat.o(104558);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.emoji.PluginEmoji
 * JD-Core Version:    0.7.0.1
 */