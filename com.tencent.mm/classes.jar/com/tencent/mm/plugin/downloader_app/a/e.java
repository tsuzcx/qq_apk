package com.tencent.mm.plugin.downloader_app.a;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences.Editor;
import android.content.res.Resources;
import android.os.Bundle;
import android.os.Parcelable;
import android.text.Layout;
import android.text.TextPaint;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ipcinvoker.wx_extension.service.ToolsProcessIPCService;
import com.tencent.mm.plugin.ball.a.d.a;
import com.tencent.mm.plugin.ball.c.f;
import com.tencent.mm.plugin.ball.model.BallInfo;
import com.tencent.mm.plugin.downloader.b.a.b;
import com.tencent.mm.pluginsdk.model.app.h;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.aj;
import com.tencent.mm.sdk.platformtools.ax;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Map;

public final class e
  extends com.tencent.mm.plugin.ball.service.a
{
  private static LinkedList<com.tencent.mm.plugin.downloader_app.api.e> ohM;
  public f jpa;
  LinkedList<String> ohK;
  LinkedList<String> ohL;
  boolean ohN;
  public a.b ohO;
  boolean ohP;
  
  static
  {
    AppMethodBeat.i(183808);
    ohM = new LinkedList();
    AppMethodBeat.o(183808);
  }
  
  private e()
  {
    AppMethodBeat.i(175265);
    this.ohK = new LinkedList();
    this.ohL = new LinkedList();
    this.ohN = false;
    this.ohO = new a.b()
    {
      public final void L(int paramAnonymousInt, long paramAnonymousLong)
      {
        AppMethodBeat.i(175257);
        Object localObject = com.tencent.mm.plugin.downloader.model.d.oq(paramAnonymousLong);
        if ((localObject == null) || (!((com.tencent.mm.plugin.downloader.g.a)localObject).field_fromDownloadApp))
        {
          AppMethodBeat.o(175257);
          return;
        }
        e locale = e.this;
        localObject = ((com.tencent.mm.plugin.downloader.g.a)localObject).field_appId;
        if ((paramAnonymousInt == 1) || (paramAnonymousInt == 7))
        {
          ad.i("MicroMsg.GameDownloadFloatBallHelper", "onTaskStart");
          e.jl(false);
          locale.ohN = false;
          if (!locale.ohK.contains(localObject)) {
            locale.ohK.add(localObject);
          }
          if (!locale.ohL.contains(localObject))
          {
            com.tencent.mm.plugin.downloader.g.a locala = com.tencent.mm.plugin.downloader.model.d.Sk((String)localObject);
            if ((locala != null) && ((locala.field_autoDownload) || (locala.field_reserveInWifi))) {
              locale.ohL.add(localObject);
            }
          }
          ad.i("MicroMsg.GameDownloadFloatBallHelper", "onTaskStart, isInDownloadMainUI:%s", new Object[] { Boolean.valueOf(locale.ohP) });
          if (!locale.bzs())
          {
            ad.i("MicroMsg.GameDownloadFloatBallHelper", "addCurrentBall");
            if ((com.tencent.mm.compatible.d.b.bZ(aj.getContext())) || (!locale.ohL.contains(localObject)))
            {
              locale.wB(com.tencent.mm.plugin.ball.f.d.eB(locale.mDH.state, 16));
              locale.bzu();
            }
          }
          locale.io(locale.ohP);
          locale.bRa();
          locale.updateTitle();
          com.tencent.mm.game.report.e.a(aj.getContext(), 34, 3402, 0, 1, 0, locale.bRb());
          AppMethodBeat.o(175257);
          return;
        }
        if (paramAnonymousInt == 6)
        {
          if (!locale.ohN)
          {
            if (!locale.ohK.contains(localObject)) {
              locale.ohK.add(localObject);
            }
            locale.io(locale.ohP);
            ad.i("MicroMsg.GameDownloadFloatBallHelper", "onProgressChanged, isInDownloadMainUI:%s", new Object[] { Boolean.valueOf(locale.ohP) });
            if ((com.tencent.mm.compatible.d.b.bZ(aj.getContext())) && (!locale.bzs()))
            {
              locale.wB(com.tencent.mm.plugin.ball.f.d.eB(locale.mDH.state, 16));
              locale.bzu();
              locale.updateTitle();
            }
            locale.bRa();
          }
          AppMethodBeat.o(175257);
          return;
        }
        if (paramAnonymousInt == 5)
        {
          locale.aG((String)localObject, true);
          AppMethodBeat.o(175257);
          return;
        }
        locale.aG((String)localObject, false);
        AppMethodBeat.o(175257);
      }
    };
    this.ohP = false;
    this.jpa = new com.tencent.mm.plugin.ball.c.g()
    {
      public final void c(BallInfo paramAnonymousBallInfo)
      {
        AppMethodBeat.i(175261);
        paramAnonymousBallInfo = new Intent();
        paramAnonymousBallInfo.putExtra("from_scene", 2);
        ((com.tencent.mm.plugin.downloader_app.api.c)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.downloader_app.api.c.class)).a(aj.getContext(), paramAnonymousBallInfo, null);
        com.tencent.mm.game.report.e.a(aj.getContext(), 34, 3403, 1, 6, 0, e.b(e.this));
        AppMethodBeat.o(175261);
      }
      
      public final void d(BallInfo paramAnonymousBallInfo)
      {
        AppMethodBeat.i(175262);
        if (e.a(e.this).isEmpty())
        {
          AppMethodBeat.o(175262);
          return;
        }
        com.tencent.mm.game.report.e.a(aj.getContext(), 34, 3403, 2, 21, 0, e.b(e.this));
        ((com.tencent.mm.plugin.downloader_app.api.c)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.downloader_app.api.c.class)).bQN();
        e.a(e.this).clear();
        e.jl(true);
        AppMethodBeat.o(175262);
      }
      
      public final void e(BallInfo paramAnonymousBallInfo)
      {
        AppMethodBeat.i(175263);
        com.tencent.mm.game.report.e.a(aj.getContext(), 34, 3403, 0, 1, 0, e.b(e.this));
        AppMethodBeat.o(175263);
      }
    };
    Z(16, "GameDownloadFloatBall");
    bzz().mDz = 11;
    in(true);
    bzv();
    com.tencent.mm.plugin.ball.a.d locald = d.a.mDj;
    com.tencent.mm.plugin.ball.a.c local2 = new com.tencent.mm.plugin.ball.a.c()
    {
      public final boolean a(Context paramAnonymousContext, BallInfo paramAnonymousBallInfo)
      {
        AppMethodBeat.i(175259);
        paramAnonymousContext = ax.aFD("game_download_float_ball");
        paramAnonymousBallInfo = new StringBuilder("game_download_first_");
        com.tencent.mm.kernel.g.afz();
        boolean bool = paramAnonymousContext.getBoolean(com.tencent.mm.kernel.a.aeo(), true);
        if (e.a(e.this).size() > 0) {}
        for (paramAnonymousContext = (String)e.a(e.this).get(0);; paramAnonymousContext = "")
        {
          if (bool)
          {
            com.tencent.mm.game.report.api.a.fUK.c(paramAnonymousContext, 7, 0, null, "");
            paramAnonymousContext = ax.aFD("game_download_float_ball");
            paramAnonymousBallInfo = new StringBuilder("game_download_first_");
            com.tencent.mm.kernel.g.afz();
            paramAnonymousContext.putBoolean(com.tencent.mm.kernel.a.aeo(), false).commit();
          }
          AppMethodBeat.o(175259);
          return false;
        }
      }
      
      public final boolean a(final TextView paramAnonymousTextView, final BallInfo paramAnonymousBallInfo)
      {
        AppMethodBeat.i(175260);
        paramAnonymousTextView.post(new Runnable()
        {
          public final void run()
          {
            AppMethodBeat.i(175258);
            ad.i("MicroMsg.GameDownloadFloatBallHelper", "onBallNameTextViewSet");
            Layout localLayout = paramAnonymousTextView.getLayout();
            if (localLayout == null)
            {
              ad.e("MicroMsg.GameDownloadFloatBallHelper", "onBallNameTextViewSet layout null");
              AppMethodBeat.o(175258);
              return;
            }
            int i = localLayout.getLineCount();
            if ((i > 0) && (localLayout.getEllipsisCount(i - 1) > 0) && (e.a(e.this).size() > 1))
            {
              ad.i("MicroMsg.GameDownloadFloatBallHelper", "ellipsis");
              TextPaint localTextPaint = paramAnonymousTextView.getPaint();
              int j = localLayout.getLineEnd(0);
              String str2 = String.format("...等%d个游戏", new Object[] { Integer.valueOf(e.a(e.this).size()) });
              String str1 = paramAnonymousBallInfo.name.substring(j);
              int k = (int)localTextPaint.measureText(".");
              i = (int)localTextPaint.measureText(str1);
              int m = (int)localTextPaint.measureText(str2);
              while ((i + m + k * 3 > localLayout.getEllipsizedWidth()) && (str1.length() > 0))
              {
                str1 = str1.substring(0, str1.length() - 1);
                i = (int)localTextPaint.measureText(str1);
              }
              str1 = paramAnonymousBallInfo.name.substring(0, j) + str1 + str2;
              e.this.OE(str1);
            }
            AppMethodBeat.o(175258);
          }
        });
        AppMethodBeat.o(175260);
        return false;
      }
    };
    locald.mDi.put(Integer.valueOf(16), local2);
    AppMethodBeat.o(175265);
  }
  
  public static void a(com.tencent.mm.plugin.downloader_app.api.e parame)
  {
    AppMethodBeat.i(183806);
    ohM.add(parame);
    AppMethodBeat.o(183806);
  }
  
  public static void b(com.tencent.mm.plugin.downloader_app.api.e parame)
  {
    AppMethodBeat.i(183807);
    ohM.remove(parame);
    AppMethodBeat.o(183807);
  }
  
  public static e bQZ()
  {
    return a.ohS;
  }
  
  public static boolean bRc()
  {
    AppMethodBeat.i(183805);
    boolean bool = ax.aFC("download_app").getBoolean("show_red_dot", false);
    if (bool)
    {
      long l = ax.aFC("download_app").getLong("red_dot_create_time", 0L);
      if (System.currentTimeMillis() - l > 86400L)
      {
        ax.aFC("download_app").putBoolean("show_red_dot", false).apply();
        ax.aFC("download_app").putLong("red_dot_create_time", 0L).apply();
        AppMethodBeat.o(183805);
        return false;
      }
    }
    AppMethodBeat.o(183805);
    return bool;
  }
  
  public static void jl(boolean paramBoolean)
  {
    AppMethodBeat.i(183804);
    ax.aFC("download_app").putBoolean("show_red_dot", paramBoolean).apply();
    ax.aFC("download_app").putLong("red_dot_create_time", System.currentTimeMillis()).apply();
    Object localObject = ohM.iterator();
    while (((Iterator)localObject).hasNext()) {
      ((com.tencent.mm.plugin.downloader_app.api.e)((Iterator)localObject).next()).onChange(paramBoolean);
    }
    localObject = new Bundle();
    ((Bundle)localObject).putBoolean("show", paramBoolean);
    ToolsProcessIPCService.a((Parcelable)localObject, b.class, null);
    AppMethodBeat.o(183804);
  }
  
  final void aG(String paramString, boolean paramBoolean)
  {
    AppMethodBeat.i(183803);
    this.ohK.remove(paramString);
    this.ohL.remove(paramString);
    if (this.ohK.isEmpty())
    {
      this.ohN = true;
      bzt();
      if (paramBoolean) {
        jl(true);
      }
      AppMethodBeat.o(183803);
      return;
    }
    io(this.ohP);
    ad.i("MicroMsg.GameDownloadFloatBallHelper", "onTaskFinished, isInDownloadMainUI:%s", new Object[] { Boolean.valueOf(this.ohP) });
    bRa();
    updateTitle();
    AppMethodBeat.o(183803);
  }
  
  final void bRa()
  {
    AppMethodBeat.i(175266);
    LinkedList localLinkedList = new LinkedList();
    Iterator localIterator = this.ohK.iterator();
    long l1 = 0L;
    long l2 = 0L;
    while (localIterator.hasNext())
    {
      String str = (String)localIterator.next();
      com.tencent.mm.plugin.downloader.g.a locala = com.tencent.mm.plugin.downloader.model.d.Sk(str);
      if ((locala == null) || (locala.field_status != 1))
      {
        localLinkedList.add(str);
      }
      else
      {
        l2 += locala.field_downloadedSize;
        l1 = locala.field_totalSize + l1;
      }
    }
    if (l1 > 0L) {
      nu(100L * l2 / l1);
    }
    if (localLinkedList.size() > 0) {
      this.ohK.remove(localLinkedList);
    }
    AppMethodBeat.o(175266);
  }
  
  final String bRb()
  {
    AppMethodBeat.i(175268);
    if (this.ohK.isEmpty())
    {
      AppMethodBeat.o(175268);
      return "";
    }
    Object localObject = new HashMap();
    ((HashMap)localObject).put("gamenum", String.valueOf(this.ohK.size()));
    StringBuilder localStringBuilder = new StringBuilder();
    Iterator localIterator = this.ohK.iterator();
    while (localIterator.hasNext()) {
      localStringBuilder.append((String)localIterator.next()).append("_");
    }
    localStringBuilder.deleteCharAt(localStringBuilder.length() - 1);
    ((HashMap)localObject).put("appidg", localStringBuilder.toString());
    localObject = com.tencent.mm.game.report.d.a.m((Map)localObject);
    AppMethodBeat.o(175268);
    return localObject;
  }
  
  final void updateTitle()
  {
    AppMethodBeat.i(175267);
    int i = this.ohK.size();
    if (i > 0)
    {
      Object localObject = new StringBuilder();
      if (this.ohL.size() > 0) {
        ((StringBuilder)localObject).append(aj.getResources().getString(2131756690));
      }
      i -= 1;
      while (i > 0)
      {
        localg = h.j((String)this.ohK.get(i), true, false);
        if (localg != null) {
          ((StringBuilder)localObject).append(localg.field_appName).append("、");
        }
        i -= 1;
      }
      com.tencent.mm.pluginsdk.model.app.g localg = h.j((String)this.ohK.get(0), true, false);
      if (localg != null) {
        ((StringBuilder)localObject).append(localg.field_appName);
      }
      localObject = ((StringBuilder)localObject).toString();
      ad.i("MicroMsg.GameDownloadFloatBallHelper", "updateTitle, name = %s, length : %d", new Object[] { localObject, Integer.valueOf(((String)localObject).length()) });
      OE((String)localObject);
    }
    AppMethodBeat.o(175267);
  }
  
  static final class a
  {
    static e ohS;
    
    static
    {
      AppMethodBeat.i(175264);
      ohS = new e((byte)0);
      AppMethodBeat.o(175264);
    }
  }
  
  static class b
    implements com.tencent.mm.ipcinvoker.b<Bundle, Bundle>
  {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.downloader_app.a.e
 * JD-Core Version:    0.7.0.1
 */