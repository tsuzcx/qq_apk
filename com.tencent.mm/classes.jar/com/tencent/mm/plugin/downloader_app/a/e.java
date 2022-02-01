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
import com.tencent.mm.plugin.ball.service.FloatBallHelper;
import com.tencent.mm.plugin.downloader.b.a.b;
import com.tencent.mm.plugin.downloader_app.e.h;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.MultiProcessMMKV;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Map;

public final class e
  extends FloatBallHelper
{
  private static LinkedList<com.tencent.mm.plugin.downloader_app.api.e> umd;
  public com.tencent.mm.plugin.teenmode.a.c nCC;
  public com.tencent.mm.plugin.ball.c.e old;
  LinkedList<String> umb;
  LinkedList<String> umc;
  boolean ume;
  public a.b umf;
  boolean umg;
  
  static
  {
    AppMethodBeat.i(183808);
    umd = new LinkedList();
    AppMethodBeat.o(183808);
  }
  
  private e()
  {
    AppMethodBeat.i(175265);
    this.umb = new LinkedList();
    this.umc = new LinkedList();
    this.ume = false;
    this.umf = new a.b()
    {
      public final void O(int paramAnonymousInt, long paramAnonymousLong)
      {
        AppMethodBeat.i(175257);
        Object localObject = com.tencent.mm.plugin.downloader.model.d.IF(paramAnonymousLong);
        if ((localObject == null) || (!((com.tencent.mm.plugin.downloader.g.a)localObject).field_fromDownloadApp))
        {
          AppMethodBeat.o(175257);
          return;
        }
        e locale = e.this;
        localObject = ((com.tencent.mm.plugin.downloader.g.a)localObject).field_appId;
        if ((paramAnonymousInt == 1) || (paramAnonymousInt == 7))
        {
          Log.i("MicroMsg.GameDownloadFloatBallHelper", "onTaskStart");
          e.mn(false);
          locale.ume = false;
          if (!locale.umb.contains(localObject)) {
            locale.umb.add(localObject);
          }
          if (!locale.umc.contains(localObject))
          {
            com.tencent.mm.plugin.downloader.g.a locala = com.tencent.mm.plugin.downloader.model.d.asU((String)localObject);
            if ((locala != null) && ((locala.field_autoDownload) || (locala.field_reserveInWifi))) {
              locale.umc.add(localObject);
            }
          }
          Log.i("MicroMsg.GameDownloadFloatBallHelper", "onTaskStart, isInDownloadMainUI:%s", new Object[] { Boolean.valueOf(locale.umg) });
          if (!locale.cvD())
          {
            Log.i("MicroMsg.GameDownloadFloatBallHelper", "addCurrentBall");
            if ((com.tencent.mm.compatible.e.b.ct(MMApplicationContext.getContext())) || (!locale.umc.contains(localObject)))
            {
              locale.Fi(com.tencent.mm.plugin.ball.f.d.fu(locale.rYE.state, 16));
              locale.cvF();
            }
          }
          locale.lf(locale.umg);
          locale.cQC();
          locale.updateTitle();
          com.tencent.mm.game.report.g.a(MMApplicationContext.getContext(), 34, 3402, 0, 1, 0, locale.cQD());
          AppMethodBeat.o(175257);
          return;
        }
        if (paramAnonymousInt == 6)
        {
          if (!locale.ume)
          {
            if (!locale.umb.contains(localObject)) {
              locale.umb.add(localObject);
            }
            locale.lf(locale.umg);
            Log.i("MicroMsg.GameDownloadFloatBallHelper", "onProgressChanged, isInDownloadMainUI:%s", new Object[] { Boolean.valueOf(locale.umg) });
            if ((com.tencent.mm.compatible.e.b.ct(MMApplicationContext.getContext())) && (!locale.cvD()))
            {
              locale.Fi(com.tencent.mm.plugin.ball.f.d.fu(locale.rYE.state, 16));
              locale.cvF();
              locale.updateTitle();
            }
            locale.cQC();
          }
          AppMethodBeat.o(175257);
          return;
        }
        if (paramAnonymousInt == 5)
        {
          locale.aQ((String)localObject, true);
          AppMethodBeat.o(175257);
          return;
        }
        locale.aQ((String)localObject, false);
        AppMethodBeat.o(175257);
      }
    };
    this.nCC = new com.tencent.mm.plugin.teenmode.a.c()
    {
      public final void onDataChanged()
      {
        AppMethodBeat.i(243103);
        boolean bool = ((com.tencent.mm.plugin.teenmode.a.b)com.tencent.mm.kernel.h.ae(com.tencent.mm.plugin.teenmode.a.b.class)).ZM();
        Log.i("MicroMsg.GameDownloadFloatBallHelper", "onTeenModeDataChanged isTeenMode: %s, taskList.empty(): %s", new Object[] { Boolean.valueOf(bool), Boolean.valueOf(e.a(e.this).isEmpty()) });
        if ((bool) && (!e.a(e.this).isEmpty()) && (e.this.cvD())) {
          e.this.cvE();
        }
        AppMethodBeat.o(243103);
      }
    };
    this.umg = false;
    this.old = new f()
    {
      public final void b(BallInfo paramAnonymousBallInfo)
      {
        AppMethodBeat.i(242967);
        paramAnonymousBallInfo = new Intent();
        paramAnonymousBallInfo.putExtra("from_scene", 2);
        ((com.tencent.mm.plugin.downloader_app.api.c)com.tencent.mm.kernel.h.ae(com.tencent.mm.plugin.downloader_app.api.c.class)).a(MMApplicationContext.getContext(), paramAnonymousBallInfo, null);
        com.tencent.mm.game.report.g.a(MMApplicationContext.getContext(), 34, 3403, 1, 6, 0, e.b(e.this));
        AppMethodBeat.o(242967);
      }
      
      public final void c(BallInfo paramAnonymousBallInfo)
      {
        AppMethodBeat.i(242968);
        if (e.a(e.this).isEmpty())
        {
          AppMethodBeat.o(242968);
          return;
        }
        com.tencent.mm.game.report.g.a(MMApplicationContext.getContext(), 34, 3403, 2, 21, 0, e.b(e.this));
        ((com.tencent.mm.plugin.downloader_app.api.c)com.tencent.mm.kernel.h.ae(com.tencent.mm.plugin.downloader_app.api.c.class)).cQw();
        e.a(e.this).clear();
        e.mn(true);
        AppMethodBeat.o(242968);
      }
      
      public final void d(BallInfo paramAnonymousBallInfo)
      {
        AppMethodBeat.i(242969);
        com.tencent.mm.game.report.g.a(MMApplicationContext.getContext(), 34, 3403, 0, 1, 0, e.b(e.this));
        AppMethodBeat.o(242969);
      }
    };
    I(16, "GameDownloadFloatBall");
    cvL().kqZ = 11;
    le(true);
    cvG();
    com.tencent.mm.plugin.ball.a.d locald = d.a.rYa;
    com.tencent.mm.plugin.ball.a.c local3 = new com.tencent.mm.plugin.ball.a.c()
    {
      public final boolean a(Context paramAnonymousContext, BallInfo paramAnonymousBallInfo)
      {
        AppMethodBeat.i(243005);
        paramAnonymousContext = MultiProcessMMKV.getSingleMMKV("game_download_float_ball");
        paramAnonymousBallInfo = new StringBuilder("game_download_first_");
        com.tencent.mm.kernel.h.aHE();
        boolean bool = paramAnonymousContext.getBoolean(com.tencent.mm.kernel.b.aGq(), true);
        if (e.a(e.this).size() > 0) {}
        for (paramAnonymousContext = (String)e.a(e.this).get(0);; paramAnonymousContext = "")
        {
          if (bool)
          {
            com.tencent.mm.game.report.api.a.jTp.c(paramAnonymousContext, 7, 0, null, "");
            paramAnonymousContext = MultiProcessMMKV.getSingleMMKV("game_download_float_ball");
            paramAnonymousBallInfo = new StringBuilder("game_download_first_");
            com.tencent.mm.kernel.h.aHE();
            paramAnonymousContext.putBoolean(com.tencent.mm.kernel.b.aGq(), false).commit();
          }
          AppMethodBeat.o(243005);
          return false;
        }
      }
      
      public final boolean a(final TextView paramAnonymousTextView, final BallInfo paramAnonymousBallInfo)
      {
        AppMethodBeat.i(243006);
        paramAnonymousTextView.post(new Runnable()
        {
          public final void run()
          {
            AppMethodBeat.i(243018);
            Log.i("MicroMsg.GameDownloadFloatBallHelper", "onBallNameTextViewSet");
            Layout localLayout = paramAnonymousTextView.getLayout();
            if (localLayout == null)
            {
              Log.e("MicroMsg.GameDownloadFloatBallHelper", "onBallNameTextViewSet layout null");
              AppMethodBeat.o(243018);
              return;
            }
            int i = localLayout.getLineCount();
            if ((i > 0) && (localLayout.getEllipsisCount(i - 1) > 0) && (e.a(e.this).size() > 1))
            {
              Log.i("MicroMsg.GameDownloadFloatBallHelper", "ellipsis");
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
              e.this.aoy(str1);
            }
            AppMethodBeat.o(243018);
          }
        });
        AppMethodBeat.o(243006);
        return false;
      }
    };
    locald.rXZ.put(Integer.valueOf(16), local3);
    AppMethodBeat.o(175265);
  }
  
  public static void a(com.tencent.mm.plugin.downloader_app.api.e parame)
  {
    AppMethodBeat.i(183806);
    umd.add(parame);
    AppMethodBeat.o(183806);
  }
  
  public static void b(com.tencent.mm.plugin.downloader_app.api.e parame)
  {
    AppMethodBeat.i(183807);
    umd.remove(parame);
    AppMethodBeat.o(183807);
  }
  
  public static e cQB()
  {
    return a.umj;
  }
  
  public static boolean cQE()
  {
    AppMethodBeat.i(183805);
    boolean bool = MultiProcessMMKV.getMMKV("download_app").getBoolean("show_red_dot", false);
    if (bool)
    {
      long l = MultiProcessMMKV.getMMKV("download_app").getLong("red_dot_create_time", 0L);
      if (System.currentTimeMillis() - l > 86400L)
      {
        MultiProcessMMKV.getMMKV("download_app").putBoolean("show_red_dot", false).apply();
        MultiProcessMMKV.getMMKV("download_app").putLong("red_dot_create_time", 0L).apply();
        AppMethodBeat.o(183805);
        return false;
      }
    }
    AppMethodBeat.o(183805);
    return bool;
  }
  
  public static void mn(boolean paramBoolean)
  {
    AppMethodBeat.i(183804);
    MultiProcessMMKV.getMMKV("download_app").putBoolean("show_red_dot", paramBoolean).apply();
    MultiProcessMMKV.getMMKV("download_app").putLong("red_dot_create_time", System.currentTimeMillis()).apply();
    Object localObject = umd.iterator();
    while (((Iterator)localObject).hasNext()) {
      ((com.tencent.mm.plugin.downloader_app.api.e)((Iterator)localObject).next()).onChange(paramBoolean);
    }
    localObject = new Bundle();
    ((Bundle)localObject).putBoolean("show", paramBoolean);
    ToolsProcessIPCService.a((Parcelable)localObject, b.class, null);
    AppMethodBeat.o(183804);
  }
  
  final void aQ(String paramString, boolean paramBoolean)
  {
    AppMethodBeat.i(183803);
    this.umb.remove(paramString);
    this.umc.remove(paramString);
    if (this.umb.isEmpty())
    {
      this.ume = true;
      cvE();
      if (paramBoolean) {
        mn(true);
      }
      AppMethodBeat.o(183803);
      return;
    }
    lf(this.umg);
    Log.i("MicroMsg.GameDownloadFloatBallHelper", "onTaskFinished, isInDownloadMainUI:%s", new Object[] { Boolean.valueOf(this.umg) });
    cQC();
    updateTitle();
    AppMethodBeat.o(183803);
  }
  
  final void cQC()
  {
    AppMethodBeat.i(175266);
    LinkedList localLinkedList = new LinkedList();
    Iterator localIterator = this.umb.iterator();
    long l1 = 0L;
    long l2 = 0L;
    while (localIterator.hasNext())
    {
      String str = (String)localIterator.next();
      com.tencent.mm.plugin.downloader.g.a locala = com.tencent.mm.plugin.downloader.model.d.asU(str);
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
      HM(100L * l2 / l1);
    }
    if (localLinkedList.size() > 0) {
      this.umb.remove(localLinkedList);
    }
    AppMethodBeat.o(175266);
  }
  
  final String cQD()
  {
    AppMethodBeat.i(175268);
    if (this.umb.isEmpty())
    {
      AppMethodBeat.o(175268);
      return "";
    }
    Object localObject = new HashMap();
    ((HashMap)localObject).put("gamenum", String.valueOf(this.umb.size()));
    StringBuilder localStringBuilder = new StringBuilder();
    Iterator localIterator = this.umb.iterator();
    while (localIterator.hasNext()) {
      localStringBuilder.append((String)localIterator.next()).append("_");
    }
    localStringBuilder.deleteCharAt(localStringBuilder.length() - 1);
    ((HashMap)localObject).put("appidg", localStringBuilder.toString());
    localObject = com.tencent.mm.game.report.e.a.m((Map)localObject);
    AppMethodBeat.o(175268);
    return localObject;
  }
  
  final void updateTitle()
  {
    AppMethodBeat.i(175267);
    int i = this.umb.size();
    if (i > 0)
    {
      Object localObject = new StringBuilder();
      if (this.umc.size() > 0) {
        ((StringBuilder)localObject).append(MMApplicationContext.getResources().getString(e.h.ukK));
      }
      i -= 1;
      while (i > 0)
      {
        localg = com.tencent.mm.pluginsdk.model.app.h.o((String)this.umb.get(i), true, false);
        if (localg != null) {
          ((StringBuilder)localObject).append(localg.field_appName).append("、");
        }
        i -= 1;
      }
      com.tencent.mm.pluginsdk.model.app.g localg = com.tencent.mm.pluginsdk.model.app.h.o((String)this.umb.get(0), true, false);
      if (localg != null) {
        ((StringBuilder)localObject).append(localg.field_appName);
      }
      localObject = ((StringBuilder)localObject).toString();
      Log.i("MicroMsg.GameDownloadFloatBallHelper", "updateTitle, name = %s, length : %d", new Object[] { localObject, Integer.valueOf(((String)localObject).length()) });
      aoy((String)localObject);
    }
    AppMethodBeat.o(175267);
  }
  
  static final class a
  {
    static e umj;
    
    static
    {
      AppMethodBeat.i(175264);
      umj = new e((byte)0);
      AppMethodBeat.o(175264);
    }
  }
  
  static class b
    implements com.tencent.mm.ipcinvoker.d<Bundle, Bundle>
  {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.downloader_app.a.e
 * JD-Core Version:    0.7.0.1
 */