package com.tencent.mm.plugin.downloader_app.search;

import android.app.Activity;
import android.content.pm.PackageInfo;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.widget.ProgressBar;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.an.aa;
import com.tencent.mm.an.aa.a;
import com.tencent.mm.an.d.a;
import com.tencent.mm.an.d.c;
import com.tencent.mm.an.q;
import com.tencent.mm.plugin.appbrand.widget.recyclerview.MRecyclerView.a;
import com.tencent.mm.plugin.downloader.c.a.a.i;
import com.tencent.mm.plugin.downloader.c.a.a.l;
import com.tencent.mm.plugin.downloader.c.a.a.m;
import com.tencent.mm.plugin.downloader.c.a.a.o;
import com.tencent.mm.plugin.downloader.c.b.e;
import com.tencent.mm.plugin.downloader.c.b.g;
import com.tencent.mm.plugin.downloader.c.b.k;
import com.tencent.mm.plugin.downloader_app.e.e;
import com.tencent.mm.plugin.downloader_app.e.f;
import com.tencent.mm.plugin.downloader_app.e.h;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.tools.t;
import com.tencent.mm.ui.tools.t.b;
import com.tencent.mm.vfs.u;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public class DownloadSearchUI
  extends MMActivity
  implements t.b
{
  private t jjS;
  private ProgressBar njo;
  private DownloadSearchListView umU;
  private TextView umV;
  private String umW;
  private boolean umX;
  
  public final boolean aat(String paramString)
  {
    AppMethodBeat.i(8951);
    Log.i("MicroMsg.DownloadSearchUI", "onSearchKeyDown");
    if (Util.isNullOrNil(paramString))
    {
      AppMethodBeat.o(8951);
      return true;
    }
    this.umU.atv(paramString);
    AppMethodBeat.o(8951);
    return true;
  }
  
  public final void aau(final String paramString)
  {
    AppMethodBeat.i(8950);
    Log.i("MicroMsg.DownloadSearchUI", "onSearchChange");
    this.umV.setVisibility(8);
    if ((this.umW != null) && (this.umW.equals(Util.nullAsNil(paramString))))
    {
      Log.d("MicroMsg.DownloadSearchUI", "repeat searchChange");
      AppMethodBeat.o(8950);
      return;
    }
    this.umW = paramString;
    if (Util.isNullOrNil(paramString))
    {
      this.njo.setVisibility(8);
      paramString = this.umU;
      paramString.setVisibility(0);
      if (Util.isNullOrNil(paramString.umQ)) {
        paramString.umQ = b.fb(paramString.mContext);
      }
      paramString.setData(paramString.umQ);
      this.umX = true;
      AppMethodBeat.o(8950);
      return;
    }
    this.umU.setData(null);
    this.umX = false;
    this.umU.setData(null);
    this.njo.setVisibility(0);
    d.a locala = new d.a();
    l locall = new l();
    locall.ufe = paramString;
    o localo = new o();
    localo.offset = 0;
    localo.limit = 5;
    locall.uff = localo;
    locala.lBU = locall;
    locala.lBV = new m();
    locala.uri = "/cgi-bin/mmgame-bin/getgamesearch";
    locala.funcId = 2688;
    aa.a(locala.bgN(), new aa.a()
    {
      public final int a(int paramAnonymousInt1, int paramAnonymousInt2, String paramAnonymousString, com.tencent.mm.an.d paramAnonymousd, q paramAnonymousq)
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
          paramAnonymousString = (m)d.c.b(paramAnonymousd.lBS);
          if ((paramAnonymousString == null) || (paramAnonymousString.ufh == null) || (Util.isNullOrNil(paramAnonymousString.ufh.ufa))) {
            break label626;
          }
          paramAnonymousq = new ArrayList();
          paramAnonymousInt1 = 0;
          Iterator localIterator = paramAnonymousString.ufh.ufa.iterator();
          if (localIterator.hasNext())
          {
            paramAnonymousString = (com.tencent.mm.plugin.downloader.c.a.a.h)localIterator.next();
            localObject1 = paramString;
            if (paramAnonymousString == null)
            {
              paramAnonymousString = null;
              label171:
              if (paramAnonymousString == null) {
                break label702;
              }
              paramAnonymousInt1 += 1;
              paramAnonymousString.position = paramAnonymousInt1;
              paramAnonymousq.add(paramAnonymousString);
            }
          }
        }
        label702:
        for (;;)
        {
          break;
          paramAnonymousd = new b();
          paramAnonymousd.type = 3;
          Object localObject3 = paramAnonymousString.ueY;
          if (localObject3 == null)
          {
            paramAnonymousString = null;
            break label171;
          }
          Object localObject2 = ((com.tencent.mm.plugin.downloader.c.a.a.d)localObject3).ueR;
          localObject3 = ((com.tencent.mm.plugin.downloader.c.a.a.d)localObject3).ueT;
          if (localObject3 != null) {
            paramAnonymousd.jumpUrl = ((com.tencent.mm.plugin.downloader.c.a.a.c)localObject3).ueQ;
          }
          if (localObject2 == null)
          {
            paramAnonymousString = null;
            break label171;
          }
          localObject3 = ((k)localObject2).ufZ;
          e locale = ((k)localObject2).uga;
          localObject2 = ((k)localObject2).ugb;
          if (localObject3 == null)
          {
            paramAnonymousString = null;
            break label171;
          }
          if (((com.tencent.mm.plugin.downloader.c.b.d)localObject3).status != 0)
          {
            paramAnonymousString = null;
            break label171;
          }
          paramAnonymousd.appId = ((com.tencent.mm.plugin.downloader.c.b.d)localObject3).appid;
          paramAnonymousd.unb = paramAnonymousString.ueZ;
          paramAnonymousd.iconUrl = ((com.tencent.mm.plugin.downloader.c.b.d)localObject3).ufC;
          if ((locale != null) && (!Util.isNullOrNil(locale.ufI))) {
            paramAnonymousd.unc = locale.ufI;
          }
          if ((localObject2 != null) && (((g)localObject2).ufQ != null)) {
            paramAnonymousd.size = ((g)localObject2).ufQ.ufr;
          }
          paramAnonymousd.una = ((String)localObject1);
          paramAnonymousd.state = 1;
          paramAnonymousString = paramAnonymousd;
          if (localObject2 == null) {
            break label171;
          }
          paramAnonymousString = paramAnonymousd;
          if (((g)localObject2).ufQ == null) {
            break label171;
          }
          paramAnonymousString = com.tencent.mm.plugin.appbrand.ac.b.getPackageInfo(MMApplicationContext.getContext(), ((g)localObject2).ufQ.ufq);
          localObject1 = com.tencent.mm.plugin.downloader.model.d.asU(paramAnonymousd.appId);
          if (paramAnonymousString == null)
          {
            paramAnonymousString = paramAnonymousd;
            if (localObject1 == null) {
              break label171;
            }
            paramAnonymousString = paramAnonymousd;
            if (((com.tencent.mm.plugin.downloader.g.a)localObject1).field_status != 3) {
              break label171;
            }
            paramAnonymousString = paramAnonymousd;
            if (!u.agG(((com.tencent.mm.plugin.downloader.g.a)localObject1).field_filePath)) {
              break label171;
            }
            paramAnonymousd.state = 4;
            paramAnonymousString = paramAnonymousd;
            break label171;
          }
          if (paramAnonymousString.versionCode < ((g)localObject2).ufQ.ufu)
          {
            paramAnonymousd.state = 3;
            paramAnonymousString = paramAnonymousd;
            break label171;
          }
          paramAnonymousd.state = 2;
          paramAnonymousString = paramAnonymousd;
          break label171;
          DownloadSearchUI.e(DownloadSearchUI.this).setVisibility(8);
          paramAnonymousString = DownloadSearchUI.a(DownloadSearchUI.this);
          paramAnonymousString.setVisibility(0);
          paramAnonymousString.umR.clear();
          if (!Util.isNullOrNil(paramAnonymousq)) {
            paramAnonymousString.umR.addAll(paramAnonymousq);
          }
          paramAnonymousString.setData(paramAnonymousString.umR);
          com.tencent.mm.plugin.downloader_app.b.a.a(13, 1303, 0, 1, "", "", "");
          for (;;)
          {
            AppMethodBeat.o(8943);
            return 0;
            label626:
            DownloadSearchUI.a(DownloadSearchUI.this).setVisibility(8);
            DownloadSearchUI.e(DownloadSearchUI.this).setVisibility(0);
            DownloadSearchUI.e(DownloadSearchUI.this).setText(DownloadSearchUI.this.getString(e.h.ukX, new Object[] { paramString }));
            com.tencent.mm.plugin.downloader_app.b.a.a(13, 1304, 0, 1, "", "", "");
          }
        }
      }
    });
    com.tencent.mm.plugin.downloader_app.b.a.a(13, 1301, 1, 2, "", "", com.tencent.mm.plugin.downloader_app.b.a.fV("search_key_word", paramString));
    AppMethodBeat.o(8950);
  }
  
  public final void bxH()
  {
    AppMethodBeat.i(8949);
    Log.i("MicroMsg.DownloadSearchUI", "onQuitSearch");
    hideVKB();
    onBackPressed();
    AppMethodBeat.o(8949);
  }
  
  public final void bxI()
  {
    AppMethodBeat.i(8948);
    Log.i("MicroMsg.DownloadSearchUI", "onEnterSearch");
    AppMethodBeat.o(8948);
  }
  
  public final void bxJ()
  {
    AppMethodBeat.i(8952);
    Log.i("MicroMsg.DownloadSearchUI", "onClickClearText");
    com.tencent.mm.plugin.downloader_app.b.a.a(13, 1301, 2, 81, "", "", "");
    AppMethodBeat.o(8952);
  }
  
  public final void bxK()
  {
    AppMethodBeat.i(8953);
    Log.i("MicroMsg.DownloadSearchUI", "onSearchEditTextReady");
    AppMethodBeat.o(8953);
  }
  
  public int getLayoutId()
  {
    return e.f.ukC;
  }
  
  public void initView()
  {
    AppMethodBeat.i(8945);
    super.initView();
    this.umU = ((DownloadSearchListView)findViewById(e.e.ukr));
    this.njo = ((ProgressBar)findViewById(e.e.ukq));
    this.umV = ((TextView)findViewById(e.e.no_result));
    this.jjS = new t();
    this.jjS.He(true);
    this.jjS.XUl = this;
    this.umU.setOnItemClickListener(new MRecyclerView.a()
    {
      public final void U(View paramAnonymousView, int paramAnonymousInt)
      {
        AppMethodBeat.i(242845);
        paramAnonymousView = DownloadSearchUI.a(DownloadSearchUI.this).umP.mDataList;
        if ((paramAnonymousView != null) && (paramAnonymousInt >= 0) && (paramAnonymousInt < paramAnonymousView.size())) {}
        for (paramAnonymousView = (b)paramAnonymousView.get(paramAnonymousInt); paramAnonymousView == null; paramAnonymousView = null)
        {
          AppMethodBeat.o(242845);
          return;
        }
        if (paramAnonymousView.type == 2)
        {
          DownloadSearchUI.a(DownloadSearchUI.this).atv(paramAnonymousView.una);
          DownloadSearchUI.b(DownloadSearchUI.this).setSearchContent(paramAnonymousView.una);
          com.tencent.mm.plugin.downloader_app.b.a.a(13, 1302, paramAnonymousView.position, 2, "", "", com.tencent.mm.plugin.downloader_app.b.a.fV("search_key_word", paramAnonymousView.una));
          AppMethodBeat.o(242845);
          return;
        }
        if (paramAnonymousView.type == 3)
        {
          DownloadSearchUI.a(DownloadSearchUI.this).atv(DownloadSearchUI.b(DownloadSearchUI.this).getSearchContent());
          if (!Util.isNullOrNil(paramAnonymousView.jumpUrl))
          {
            Bundle localBundle = new Bundle();
            localBundle.putString("rawUrl", paramAnonymousView.jumpUrl);
            ((com.tencent.mm.plugin.downloader_app.api.c)com.tencent.mm.kernel.h.ae(com.tencent.mm.plugin.downloader_app.api.c.class)).f(DownloadSearchUI.this.getContext(), localBundle);
          }
          com.tencent.mm.plugin.downloader_app.b.a.a(13, 1303, paramAnonymousView.position, 40, paramAnonymousView.appId, "", "");
        }
        AppMethodBeat.o(242845);
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
    this.jjS.a(this, paramMenu);
    this.jjS.setHint(getString(e.h.ukY));
    AppMethodBeat.o(8946);
    return true;
  }
  
  public boolean onPrepareOptionsMenu(Menu paramMenu)
  {
    AppMethodBeat.i(8947);
    this.jjS.a(this, paramMenu);
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