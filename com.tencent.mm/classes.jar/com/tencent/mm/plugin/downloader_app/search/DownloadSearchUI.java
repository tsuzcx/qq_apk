package com.tencent.mm.plugin.downloader_app.search;

import android.app.Activity;
import android.content.pm.PackageInfo;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.widget.ProgressBar;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.aa;
import com.tencent.mm.ak.aa.a;
import com.tencent.mm.ak.d.a;
import com.tencent.mm.ak.d.c;
import com.tencent.mm.ak.q;
import com.tencent.mm.plugin.appbrand.widget.recyclerview.MRecyclerView.a;
import com.tencent.mm.plugin.downloader.c.a.a.h;
import com.tencent.mm.plugin.downloader.c.a.a.i;
import com.tencent.mm.plugin.downloader.c.a.a.l;
import com.tencent.mm.plugin.downloader.c.a.a.m;
import com.tencent.mm.plugin.downloader.c.a.a.o;
import com.tencent.mm.plugin.downloader.c.b.e;
import com.tencent.mm.plugin.downloader.c.b.k;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.tools.s.b;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public class DownloadSearchUI
  extends MMActivity
  implements s.b
{
  private com.tencent.mm.ui.tools.s gzP;
  private ProgressBar krF;
  private DownloadSearchListView qLI;
  private TextView qLJ;
  private String qLK;
  private boolean qLL;
  
  public final boolean SN(String paramString)
  {
    AppMethodBeat.i(8951);
    Log.i("MicroMsg.DownloadSearchUI", "onSearchKeyDown");
    if (Util.isNullOrNil(paramString))
    {
      AppMethodBeat.o(8951);
      return true;
    }
    this.qLI.alC(paramString);
    AppMethodBeat.o(8951);
    return true;
  }
  
  public final void SO(final String paramString)
  {
    AppMethodBeat.i(8950);
    Log.i("MicroMsg.DownloadSearchUI", "onSearchChange");
    this.qLJ.setVisibility(8);
    if ((this.qLK != null) && (this.qLK.equals(Util.nullAsNil(paramString))))
    {
      Log.d("MicroMsg.DownloadSearchUI", "repeat searchChange");
      AppMethodBeat.o(8950);
      return;
    }
    this.qLK = paramString;
    if (Util.isNullOrNil(paramString))
    {
      this.krF.setVisibility(8);
      paramString = this.qLI;
      paramString.setVisibility(0);
      if (Util.isNullOrNil(paramString.qLE)) {
        paramString.qLE = b.eX(paramString.mContext);
      }
      paramString.setData(paramString.qLE);
      this.qLL = true;
      AppMethodBeat.o(8950);
      return;
    }
    this.qLI.setData(null);
    this.qLL = false;
    this.qLI.setData(null);
    this.krF.setVisibility(0);
    d.a locala = new d.a();
    l locall = new l();
    locall.qGc = paramString;
    o localo = new o();
    localo.offset = 0;
    localo.limit = 5;
    locall.qGd = localo;
    locala.iLN = locall;
    locala.iLO = new m();
    locala.uri = "/cgi-bin/mmgame-bin/getgamesearch";
    locala.funcId = 2688;
    aa.a(locala.aXF(), new aa.a()
    {
      public final int a(int paramAnonymousInt1, int paramAnonymousInt2, String paramAnonymousString, com.tencent.mm.ak.d paramAnonymousd, q paramAnonymousq)
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
          paramAnonymousString = (m)paramAnonymousd.iLL.iLR;
          if ((paramAnonymousString == null) || (paramAnonymousString.qGf == null) || (Util.isNullOrNil(paramAnonymousString.qGf.qFY))) {
            break label626;
          }
          paramAnonymousq = new ArrayList();
          paramAnonymousInt1 = 0;
          Iterator localIterator = paramAnonymousString.qGf.qFY.iterator();
          if (localIterator.hasNext())
          {
            paramAnonymousString = (h)localIterator.next();
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
          Object localObject3 = paramAnonymousString.qFW;
          if (localObject3 == null)
          {
            paramAnonymousString = null;
            break label171;
          }
          Object localObject2 = ((com.tencent.mm.plugin.downloader.c.a.a.d)localObject3).qFP;
          localObject3 = ((com.tencent.mm.plugin.downloader.c.a.a.d)localObject3).qFR;
          if (localObject3 != null) {
            paramAnonymousd.jumpUrl = ((com.tencent.mm.plugin.downloader.c.a.a.c)localObject3).qFO;
          }
          if (localObject2 == null)
          {
            paramAnonymousString = null;
            break label171;
          }
          localObject3 = ((k)localObject2).qGY;
          e locale = ((k)localObject2).qGZ;
          localObject2 = ((k)localObject2).qHa;
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
          paramAnonymousd.appId = ((com.tencent.mm.plugin.downloader.c.b.d)localObject3).dNI;
          paramAnonymousd.qLP = paramAnonymousString.qFX;
          paramAnonymousd.iconUrl = ((com.tencent.mm.plugin.downloader.c.b.d)localObject3).qGB;
          if ((locale != null) && (!Util.isNullOrNil(locale.qGH))) {
            paramAnonymousd.qLQ = locale.qGH;
          }
          if ((localObject2 != null) && (((com.tencent.mm.plugin.downloader.c.b.g)localObject2).qGP != null)) {
            paramAnonymousd.size = ((com.tencent.mm.plugin.downloader.c.b.g)localObject2).qGP.qGq;
          }
          paramAnonymousd.qLO = ((String)localObject1);
          paramAnonymousd.state = 1;
          paramAnonymousString = paramAnonymousd;
          if (localObject2 == null) {
            break label171;
          }
          paramAnonymousString = paramAnonymousd;
          if (((com.tencent.mm.plugin.downloader.c.b.g)localObject2).qGP == null) {
            break label171;
          }
          paramAnonymousString = com.tencent.mm.plugin.appbrand.ac.b.getPackageInfo(MMApplicationContext.getContext(), ((com.tencent.mm.plugin.downloader.c.b.g)localObject2).qGP.qGp);
          localObject1 = com.tencent.mm.plugin.downloader.model.d.alb(paramAnonymousd.appId);
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
            if (!com.tencent.mm.vfs.s.YS(((com.tencent.mm.plugin.downloader.g.a)localObject1).field_filePath)) {
              break label171;
            }
            paramAnonymousd.state = 4;
            paramAnonymousString = paramAnonymousd;
            break label171;
          }
          if (paramAnonymousString.versionCode < ((com.tencent.mm.plugin.downloader.c.b.g)localObject2).qGP.qGt)
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
          paramAnonymousString.qLF.clear();
          if (!Util.isNullOrNil(paramAnonymousq)) {
            paramAnonymousString.qLF.addAll(paramAnonymousq);
          }
          paramAnonymousString.setData(paramAnonymousString.qLF);
          com.tencent.mm.plugin.downloader_app.b.a.a(13, 1303, 0, 1, "", "", "");
          for (;;)
          {
            AppMethodBeat.o(8943);
            return 0;
            label626:
            DownloadSearchUI.a(DownloadSearchUI.this).setVisibility(8);
            DownloadSearchUI.e(DownloadSearchUI.this).setVisibility(0);
            DownloadSearchUI.e(DownloadSearchUI.this).setText(DownloadSearchUI.this.getString(2131758416, new Object[] { paramString }));
            com.tencent.mm.plugin.downloader_app.b.a.a(13, 1304, 0, 1, "", "", "");
          }
        }
      }
    });
    com.tencent.mm.plugin.downloader_app.b.a.a(13, 1301, 1, 2, "", "", com.tencent.mm.plugin.downloader_app.b.a.fH("search_key_word", paramString));
    AppMethodBeat.o(8950);
  }
  
  public final void bnA()
  {
    AppMethodBeat.i(8952);
    Log.i("MicroMsg.DownloadSearchUI", "onClickClearText");
    com.tencent.mm.plugin.downloader_app.b.a.a(13, 1301, 2, 81, "", "", "");
    AppMethodBeat.o(8952);
  }
  
  public final void bnB()
  {
    AppMethodBeat.i(8953);
    Log.i("MicroMsg.DownloadSearchUI", "onSearchEditTextReady");
    AppMethodBeat.o(8953);
  }
  
  public final void bny()
  {
    AppMethodBeat.i(8949);
    Log.i("MicroMsg.DownloadSearchUI", "onQuitSearch");
    hideVKB();
    onBackPressed();
    AppMethodBeat.o(8949);
  }
  
  public final void bnz()
  {
    AppMethodBeat.i(8948);
    Log.i("MicroMsg.DownloadSearchUI", "onEnterSearch");
    AppMethodBeat.o(8948);
  }
  
  public int getLayoutId()
  {
    return 2131493858;
  }
  
  public void initView()
  {
    AppMethodBeat.i(8945);
    super.initView();
    this.qLI = ((DownloadSearchListView)findViewById(2131307418));
    this.krF = ((ProgressBar)findViewById(2131307415));
    this.qLJ = ((TextView)findViewById(2131305459));
    this.gzP = new com.tencent.mm.ui.tools.s();
    this.gzP.CK(true);
    this.gzP.Qwi = this;
    this.qLI.setOnItemClickListener(new MRecyclerView.a()
    {
      public final void S(View paramAnonymousView, int paramAnonymousInt)
      {
        AppMethodBeat.i(8942);
        paramAnonymousView = DownloadSearchUI.a(DownloadSearchUI.this).qLD.mDataList;
        if ((paramAnonymousView != null) && (paramAnonymousInt >= 0) && (paramAnonymousInt < paramAnonymousView.size())) {}
        for (paramAnonymousView = (b)paramAnonymousView.get(paramAnonymousInt); paramAnonymousView == null; paramAnonymousView = null)
        {
          AppMethodBeat.o(8942);
          return;
        }
        if (paramAnonymousView.type == 2)
        {
          DownloadSearchUI.a(DownloadSearchUI.this).alC(paramAnonymousView.qLO);
          DownloadSearchUI.b(DownloadSearchUI.this).setSearchContent(paramAnonymousView.qLO);
          com.tencent.mm.plugin.downloader_app.b.a.a(13, 1302, paramAnonymousView.position, 2, "", "", com.tencent.mm.plugin.downloader_app.b.a.fH("search_key_word", paramAnonymousView.qLO));
          AppMethodBeat.o(8942);
          return;
        }
        if (paramAnonymousView.type == 3)
        {
          DownloadSearchUI.a(DownloadSearchUI.this).alC(DownloadSearchUI.b(DownloadSearchUI.this).getSearchContent());
          if (!Util.isNullOrNil(paramAnonymousView.jumpUrl))
          {
            Bundle localBundle = new Bundle();
            localBundle.putString("rawUrl", paramAnonymousView.jumpUrl);
            ((com.tencent.mm.plugin.downloader_app.api.c)com.tencent.mm.kernel.g.af(com.tencent.mm.plugin.downloader_app.api.c.class)).e(DownloadSearchUI.this.getContext(), localBundle);
          }
          com.tencent.mm.plugin.downloader_app.b.a.a(13, 1303, paramAnonymousView.position, 40, paramAnonymousView.appId, "", "");
        }
        AppMethodBeat.o(8942);
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
    this.gzP.a(this, paramMenu);
    this.gzP.setHint(getString(2131758418));
    AppMethodBeat.o(8946);
    return true;
  }
  
  public boolean onPrepareOptionsMenu(Menu paramMenu)
  {
    AppMethodBeat.i(8947);
    this.gzP.a(this, paramMenu);
    AppMethodBeat.o(8947);
    return true;
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.downloader_app.search.DownloadSearchUI
 * JD-Core Version:    0.7.0.1
 */