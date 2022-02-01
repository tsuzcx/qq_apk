package com.tencent.mm.plugin.downloader_app.search;

import android.content.pm.PackageInfo;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.widget.ProgressBar;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.am.c.a;
import com.tencent.mm.am.c.c;
import com.tencent.mm.am.p;
import com.tencent.mm.am.z;
import com.tencent.mm.am.z.a;
import com.tencent.mm.plugin.appbrand.widget.recyclerview.MRecyclerView.a;
import com.tencent.mm.plugin.downloader.b.a.a.i;
import com.tencent.mm.plugin.downloader.b.a.a.l;
import com.tencent.mm.plugin.downloader.b.a.a.m;
import com.tencent.mm.plugin.downloader.b.a.a.o;
import com.tencent.mm.plugin.downloader.b.b.e;
import com.tencent.mm.plugin.downloader.b.b.g;
import com.tencent.mm.plugin.downloader.b.b.k;
import com.tencent.mm.plugin.downloader_app.e.e;
import com.tencent.mm.plugin.downloader_app.e.f;
import com.tencent.mm.plugin.downloader_app.e.h;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.tools.s;
import com.tencent.mm.ui.tools.s.c;
import com.tencent.mm.vfs.y;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public class DownloadSearchUI
  extends MMActivity
  implements s.c
{
  private s lMw;
  private ProgressBar qgC;
  private DownloadSearchListView xtm;
  private TextView xtn;
  private String xto;
  private boolean xtp;
  
  public final boolean SN(String paramString)
  {
    AppMethodBeat.i(8951);
    Log.i("MicroMsg.DownloadSearchUI", "onSearchKeyDown");
    if (Util.isNullOrNil(paramString))
    {
      AppMethodBeat.o(8951);
      return true;
    }
    this.xtm.ank(paramString);
    AppMethodBeat.o(8951);
    return true;
  }
  
  public final void SO(final String paramString)
  {
    AppMethodBeat.i(8950);
    Log.i("MicroMsg.DownloadSearchUI", "onSearchChange");
    this.xtn.setVisibility(8);
    if ((this.xto != null) && (this.xto.equals(Util.nullAsNil(paramString))))
    {
      Log.d("MicroMsg.DownloadSearchUI", "repeat searchChange");
      AppMethodBeat.o(8950);
      return;
    }
    this.xto = paramString;
    if (Util.isNullOrNil(paramString))
    {
      this.qgC.setVisibility(8);
      paramString = this.xtm;
      paramString.setVisibility(0);
      if (Util.isNullOrNil(paramString.xti)) {
        paramString.xti = b.fY(paramString.mContext);
      }
      paramString.setData(paramString.xti);
      this.xtp = true;
      AppMethodBeat.o(8950);
      return;
    }
    this.xtm.setData(null);
    this.xtp = false;
    this.xtm.setData(null);
    this.qgC.setVisibility(0);
    c.a locala = new c.a();
    l locall = new l();
    locall.xlf = paramString;
    o localo = new o();
    localo.offset = 0;
    localo.limit = 5;
    locall.xlg = localo;
    locala.otE = locall;
    locala.otF = new m();
    locala.uri = "/cgi-bin/mmgame-bin/getgamesearch";
    locala.funcId = 2688;
    z.a(locala.bEF(), new z.a()
    {
      public final int callback(int paramAnonymousInt1, int paramAnonymousInt2, String paramAnonymousString, com.tencent.mm.am.c paramAnonymousc, p paramAnonymousp)
      {
        AppMethodBeat.i(8943);
        Log.i("MicroMsg.DownloadSearchUI", "errType = %d, errCode = %d", new Object[] { Integer.valueOf(paramAnonymousInt1), Integer.valueOf(paramAnonymousInt2) });
        if ((DownloadSearchUI.c(DownloadSearchUI.this)) || (DownloadSearchUI.this.isFinishing()))
        {
          AppMethodBeat.o(8943);
          return 0;
        }
        DownloadSearchUI.d(DownloadSearchUI.this).setVisibility(8);
        Object localObject1;
        if ((paramAnonymousInt1 == 0) && (paramAnonymousInt2 == 0))
        {
          paramAnonymousString = (m)c.c.b(paramAnonymousc.otC);
          if ((paramAnonymousString == null) || (paramAnonymousString.xli == null) || (Util.isNullOrNil(paramAnonymousString.xli.xlb))) {
            break label663;
          }
          paramAnonymousp = new ArrayList();
          paramAnonymousInt1 = 0;
          Iterator localIterator = paramAnonymousString.xli.xlb.iterator();
          if (localIterator.hasNext())
          {
            paramAnonymousString = (com.tencent.mm.plugin.downloader.b.a.a.h)localIterator.next();
            localObject1 = paramString;
            if (paramAnonymousString == null)
            {
              paramAnonymousString = null;
              label171:
              if (paramAnonymousString == null) {
                break label739;
              }
              paramAnonymousInt1 += 1;
              paramAnonymousString.position = paramAnonymousInt1;
              paramAnonymousp.add(paramAnonymousString);
            }
          }
        }
        label663:
        label739:
        for (;;)
        {
          break;
          paramAnonymousc = new b();
          paramAnonymousc.type = 3;
          Object localObject3 = paramAnonymousString.xkZ;
          if (localObject3 == null)
          {
            paramAnonymousString = null;
            break label171;
          }
          Object localObject2 = ((com.tencent.mm.plugin.downloader.b.a.a.d)localObject3).xkS;
          localObject3 = ((com.tencent.mm.plugin.downloader.b.a.a.d)localObject3).xkU;
          if (localObject3 != null) {
            paramAnonymousc.jumpUrl = ((com.tencent.mm.plugin.downloader.b.a.a.c)localObject3).xkR;
          }
          if (localObject2 == null)
          {
            paramAnonymousString = null;
            break label171;
          }
          localObject3 = ((k)localObject2).xmf;
          e locale = ((k)localObject2).xmg;
          localObject2 = ((k)localObject2).xmh;
          if (localObject3 == null)
          {
            paramAnonymousString = null;
            break label171;
          }
          if (((com.tencent.mm.plugin.downloader.b.b.d)localObject3).status != 0)
          {
            paramAnonymousString = null;
            break label171;
          }
          paramAnonymousc.appId = ((com.tencent.mm.plugin.downloader.b.b.d)localObject3).appid;
          paramAnonymousc.xtt = paramAnonymousString.xla;
          paramAnonymousc.iconUrl = ((com.tencent.mm.plugin.downloader.b.b.d)localObject3).icon_url;
          if ((locale != null) && (!Util.isNullOrNil(locale.xlP))) {
            paramAnonymousc.xtu = locale.xlP;
          }
          if ((localObject2 != null) && (((g)localObject2).xlW != null)) {
            paramAnonymousc.size = ((g)localObject2).xlW.xls;
          }
          paramAnonymousc.xts = ((String)localObject1);
          paramAnonymousc.state = 1;
          paramAnonymousString = paramAnonymousc;
          if (localObject2 == null) {
            break label171;
          }
          paramAnonymousString = paramAnonymousc;
          if (((g)localObject2).xlW == null) {
            break label171;
          }
          paramAnonymousString = com.tencent.mm.plugin.appbrand.af.b.getPackageInfo(MMApplicationContext.getContext(), ((g)localObject2).xlW.xlr);
          localObject1 = com.tencent.mm.plugin.downloader.model.d.amJ(paramAnonymousc.appId);
          if (paramAnonymousString == null) {
            if ((localObject1 != null) && (((com.tencent.mm.plugin.downloader.f.a)localObject1).field_status == 3) && (y.ZC(((com.tencent.mm.plugin.downloader.f.a)localObject1).field_filePath))) {
              paramAnonymousc.state = 4;
            }
          }
          for (;;)
          {
            paramAnonymousc.xtv = ((g)localObject2).xlW.xlI;
            paramAnonymousc.version = ((g)localObject2).xlW.xlC;
            paramAnonymousc.xtw = ((g)localObject2).xlW.xlG;
            paramAnonymousc.xtx = ((g)localObject2).xlW.xlH;
            paramAnonymousString = paramAnonymousc;
            break;
            if (paramAnonymousString.versionCode < ((g)localObject2).xlW.xlv) {
              paramAnonymousc.state = 3;
            } else {
              paramAnonymousc.state = 2;
            }
          }
          DownloadSearchUI.e(DownloadSearchUI.this).setVisibility(8);
          paramAnonymousString = DownloadSearchUI.a(DownloadSearchUI.this);
          paramAnonymousString.setVisibility(0);
          paramAnonymousString.xtj.clear();
          if (!Util.isNullOrNil(paramAnonymousp)) {
            paramAnonymousString.xtj.addAll(paramAnonymousp);
          }
          paramAnonymousString.setData(paramAnonymousString.xtj);
          com.tencent.mm.plugin.downloader_app.b.a.a(13, 1303, 0, 1, "", "", "");
          for (;;)
          {
            AppMethodBeat.o(8943);
            return 0;
            DownloadSearchUI.a(DownloadSearchUI.this).setVisibility(8);
            DownloadSearchUI.e(DownloadSearchUI.this).setVisibility(0);
            DownloadSearchUI.e(DownloadSearchUI.this).setText(DownloadSearchUI.this.getString(e.h.xrj, new Object[] { paramString }));
            com.tencent.mm.plugin.downloader_app.b.a.a(13, 1304, 0, 1, "", "", "");
          }
        }
      }
    });
    com.tencent.mm.plugin.downloader_app.b.a.a(13, 1301, 1, 2, "", "", com.tencent.mm.plugin.downloader_app.b.a.gy("search_key_word", paramString));
    AppMethodBeat.o(8950);
  }
  
  public final void bWw()
  {
    AppMethodBeat.i(8949);
    Log.i("MicroMsg.DownloadSearchUI", "onQuitSearch");
    hideVKB();
    onBackPressed();
    AppMethodBeat.o(8949);
  }
  
  public final void bWx()
  {
    AppMethodBeat.i(8948);
    Log.i("MicroMsg.DownloadSearchUI", "onEnterSearch");
    AppMethodBeat.o(8948);
  }
  
  public final void bWy()
  {
    AppMethodBeat.i(8952);
    Log.i("MicroMsg.DownloadSearchUI", "onClickClearText");
    com.tencent.mm.plugin.downloader_app.b.a.a(13, 1301, 2, 81, "", "", "");
    AppMethodBeat.o(8952);
  }
  
  public final void bWz()
  {
    AppMethodBeat.i(8953);
    Log.i("MicroMsg.DownloadSearchUI", "onSearchEditTextReady");
    AppMethodBeat.o(8953);
  }
  
  public int getLayoutId()
  {
    return e.f.xqO;
  }
  
  public void initView()
  {
    AppMethodBeat.i(8945);
    super.initView();
    this.xtm = ((DownloadSearchListView)findViewById(e.e.xqD));
    this.qgC = ((ProgressBar)findViewById(e.e.xqC));
    this.xtn = ((TextView)findViewById(e.e.no_result));
    this.lMw = new s();
    this.lMw.MY(true);
    this.lMw.afKz = this;
    this.xtm.setOnItemClickListener(new MRecyclerView.a()
    {
      public final void onItemClick(RecyclerView paramAnonymousRecyclerView, View paramAnonymousView, int paramAnonymousInt, long paramAnonymousLong)
      {
        AppMethodBeat.i(269691);
        paramAnonymousRecyclerView = DownloadSearchUI.a(DownloadSearchUI.this).xth.mDataList;
        if ((paramAnonymousRecyclerView != null) && (paramAnonymousInt >= 0) && (paramAnonymousInt < paramAnonymousRecyclerView.size())) {}
        for (paramAnonymousRecyclerView = (b)paramAnonymousRecyclerView.get(paramAnonymousInt); paramAnonymousRecyclerView == null; paramAnonymousRecyclerView = null)
        {
          AppMethodBeat.o(269691);
          return;
        }
        if (paramAnonymousRecyclerView.type == 2)
        {
          DownloadSearchUI.a(DownloadSearchUI.this).ank(paramAnonymousRecyclerView.xts);
          DownloadSearchUI.b(DownloadSearchUI.this).setSearchContent(paramAnonymousRecyclerView.xts);
          com.tencent.mm.plugin.downloader_app.b.a.a(13, 1302, paramAnonymousRecyclerView.position, 2, "", "", com.tencent.mm.plugin.downloader_app.b.a.gy("search_key_word", paramAnonymousRecyclerView.xts));
          AppMethodBeat.o(269691);
          return;
        }
        if (paramAnonymousRecyclerView.type == 3)
        {
          DownloadSearchUI.a(DownloadSearchUI.this).ank(DownloadSearchUI.b(DownloadSearchUI.this).getSearchContent());
          if (!Util.isNullOrNil(paramAnonymousRecyclerView.jumpUrl))
          {
            paramAnonymousView = new Bundle();
            paramAnonymousView.putString("rawUrl", paramAnonymousRecyclerView.jumpUrl);
            ((com.tencent.mm.plugin.downloader_app.api.c)com.tencent.mm.kernel.h.ax(com.tencent.mm.plugin.downloader_app.api.c.class)).f(DownloadSearchUI.this.getContext(), paramAnonymousView);
          }
          com.tencent.mm.plugin.downloader_app.b.a.a(13, 1303, paramAnonymousRecyclerView.position, 40, paramAnonymousRecyclerView.appId, "", "");
        }
        AppMethodBeat.o(269691);
      }
    });
    AppMethodBeat.o(8945);
  }
  
  public void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(8944);
    super.onCreate(paramBundle);
    initView();
    com.tencent.mm.plugin.downloader_app.b.a.a(13, 0, 0, 1, "", "", "");
    AppMethodBeat.o(8944);
  }
  
  public boolean onCreateOptionsMenu(Menu paramMenu)
  {
    AppMethodBeat.i(8946);
    this.lMw.a(this, paramMenu);
    this.lMw.setHint(getString(e.h.xrk));
    AppMethodBeat.o(8946);
    return true;
  }
  
  public boolean onPrepareOptionsMenu(Menu paramMenu)
  {
    AppMethodBeat.i(8947);
    this.lMw.a(this, paramMenu);
    AppMethodBeat.o(8947);
    return true;
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.downloader_app.search.DownloadSearchUI
 * JD-Core Version:    0.7.0.1
 */