package com.tencent.mm.plugin.downloader_app.search;

import android.app.Activity;
import android.content.pm.PackageInfo;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.widget.ProgressBar;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.b.a;
import com.tencent.mm.ak.b.c;
import com.tencent.mm.ak.n;
import com.tencent.mm.ak.x;
import com.tencent.mm.ak.x.a;
import com.tencent.mm.plugin.appbrand.widget.recyclerview.MRecyclerView.a;
import com.tencent.mm.plugin.downloader.c.a.a.h;
import com.tencent.mm.plugin.downloader.c.a.a.i;
import com.tencent.mm.plugin.downloader.c.a.a.l;
import com.tencent.mm.plugin.downloader.c.a.a.m;
import com.tencent.mm.plugin.downloader.c.b.e;
import com.tencent.mm.plugin.downloader.c.b.k;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.ak;
import com.tencent.mm.sdk.platformtools.bu;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.tools.r;
import com.tencent.mm.ui.tools.r.b;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public class DownloadSearchUI
  extends MMActivity
  implements r.b
{
  private r fUI;
  private ProgressBar jtq;
  private DownloadSearchListView pwr;
  private TextView pws;
  private String pwt;
  private boolean pwu;
  
  public final boolean JO(String paramString)
  {
    AppMethodBeat.i(8951);
    ae.i("MicroMsg.DownloadSearchUI", "onSearchKeyDown");
    if (bu.isNullOrNil(paramString))
    {
      AppMethodBeat.o(8951);
      return true;
    }
    this.pwr.abw(paramString);
    AppMethodBeat.o(8951);
    return true;
  }
  
  public final void JP(final String paramString)
  {
    AppMethodBeat.i(8950);
    ae.i("MicroMsg.DownloadSearchUI", "onSearchChange");
    this.pws.setVisibility(8);
    if ((this.pwt != null) && (this.pwt.equals(bu.nullAsNil(paramString))))
    {
      ae.d("MicroMsg.DownloadSearchUI", "repeat searchChange");
      AppMethodBeat.o(8950);
      return;
    }
    this.pwt = paramString;
    if (bu.isNullOrNil(paramString))
    {
      this.jtq.setVisibility(8);
      paramString = this.pwr;
      paramString.setVisibility(0);
      if (bu.ht(paramString.pwn)) {
        paramString.pwn = b.eC(paramString.mContext);
      }
      paramString.setData(paramString.pwn);
      this.pwu = true;
      AppMethodBeat.o(8950);
      return;
    }
    this.pwr.setData(null);
    this.pwu = false;
    this.pwr.setData(null);
    this.jtq.setVisibility(0);
    b.a locala = new b.a();
    l locall = new l();
    locall.pqx = paramString;
    com.tencent.mm.plugin.downloader.c.a.a.o localo = new com.tencent.mm.plugin.downloader.c.a.a.o();
    localo.offset = 0;
    localo.limit = 5;
    locall.pqy = localo;
    locala.hQF = locall;
    locala.hQG = new m();
    locala.uri = "/cgi-bin/mmgame-bin/getgamesearch";
    locala.funcId = 2688;
    x.a(locala.aDS(), new x.a()
    {
      public final int a(int paramAnonymousInt1, int paramAnonymousInt2, String paramAnonymousString, com.tencent.mm.ak.b paramAnonymousb, n paramAnonymousn)
      {
        AppMethodBeat.i(8943);
        ae.i("MicroMsg.DownloadSearchUI", "errType = %d, errCode = %d", new Object[] { Integer.valueOf(paramAnonymousInt1), Integer.valueOf(paramAnonymousInt2) });
        if ((DownloadSearchUI.c(DownloadSearchUI.this)) || (DownloadSearchUI.this.isFinishing()))
        {
          AppMethodBeat.o(8943);
          return 0;
        }
        DownloadSearchUI.d(DownloadSearchUI.this).setVisibility(8);
        Object localObject1;
        if ((paramAnonymousInt1 == 0) && (paramAnonymousInt2 == 0))
        {
          paramAnonymousString = (m)paramAnonymousb.hQE.hQJ;
          if ((paramAnonymousString == null) || (paramAnonymousString.pqA == null) || (bu.ht(paramAnonymousString.pqA.pqt))) {
            break label626;
          }
          paramAnonymousn = new ArrayList();
          paramAnonymousInt1 = 0;
          Iterator localIterator = paramAnonymousString.pqA.pqt.iterator();
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
              paramAnonymousn.add(paramAnonymousString);
            }
          }
        }
        label702:
        for (;;)
        {
          break;
          paramAnonymousb = new b();
          paramAnonymousb.type = 3;
          Object localObject3 = paramAnonymousString.pqr;
          if (localObject3 == null)
          {
            paramAnonymousString = null;
            break label171;
          }
          Object localObject2 = ((com.tencent.mm.plugin.downloader.c.a.a.d)localObject3).pqk;
          localObject3 = ((com.tencent.mm.plugin.downloader.c.a.a.d)localObject3).pqm;
          if (localObject3 != null) {
            paramAnonymousb.jumpUrl = ((com.tencent.mm.plugin.downloader.c.a.a.c)localObject3).pqj;
          }
          if (localObject2 == null)
          {
            paramAnonymousString = null;
            break label171;
          }
          localObject3 = ((k)localObject2).prt;
          e locale = ((k)localObject2).pru;
          localObject2 = ((k)localObject2).prv;
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
          paramAnonymousb.appId = ((com.tencent.mm.plugin.downloader.c.b.d)localObject3).dwb;
          paramAnonymousb.pwy = paramAnonymousString.pqs;
          paramAnonymousb.iconUrl = ((com.tencent.mm.plugin.downloader.c.b.d)localObject3).pqW;
          if ((locale != null) && (!bu.ht(locale.prc))) {
            paramAnonymousb.pwz = locale.prc;
          }
          if ((localObject2 != null) && (((com.tencent.mm.plugin.downloader.c.b.g)localObject2).prk != null)) {
            paramAnonymousb.size = ((com.tencent.mm.plugin.downloader.c.b.g)localObject2).prk.pqL;
          }
          paramAnonymousb.pwx = ((String)localObject1);
          paramAnonymousb.state = 1;
          paramAnonymousString = paramAnonymousb;
          if (localObject2 == null) {
            break label171;
          }
          paramAnonymousString = paramAnonymousb;
          if (((com.tencent.mm.plugin.downloader.c.b.g)localObject2).prk == null) {
            break label171;
          }
          paramAnonymousString = com.tencent.mm.plugin.appbrand.y.b.getPackageInfo(ak.getContext(), ((com.tencent.mm.plugin.downloader.c.b.g)localObject2).prk.pqK);
          localObject1 = com.tencent.mm.plugin.downloader.model.d.aaU(paramAnonymousb.appId);
          if (paramAnonymousString == null)
          {
            paramAnonymousString = paramAnonymousb;
            if (localObject1 == null) {
              break label171;
            }
            paramAnonymousString = paramAnonymousb;
            if (((com.tencent.mm.plugin.downloader.g.a)localObject1).field_status != 3) {
              break label171;
            }
            paramAnonymousString = paramAnonymousb;
            if (!com.tencent.mm.vfs.o.fB(((com.tencent.mm.plugin.downloader.g.a)localObject1).field_filePath)) {
              break label171;
            }
            paramAnonymousb.state = 4;
            paramAnonymousString = paramAnonymousb;
            break label171;
          }
          if (paramAnonymousString.versionCode < ((com.tencent.mm.plugin.downloader.c.b.g)localObject2).prk.pqO)
          {
            paramAnonymousb.state = 3;
            paramAnonymousString = paramAnonymousb;
            break label171;
          }
          paramAnonymousb.state = 2;
          paramAnonymousString = paramAnonymousb;
          break label171;
          DownloadSearchUI.e(DownloadSearchUI.this).setVisibility(8);
          paramAnonymousString = DownloadSearchUI.a(DownloadSearchUI.this);
          paramAnonymousString.setVisibility(0);
          paramAnonymousString.pwo.clear();
          if (!bu.ht(paramAnonymousn)) {
            paramAnonymousString.pwo.addAll(paramAnonymousn);
          }
          paramAnonymousString.setData(paramAnonymousString.pwo);
          com.tencent.mm.plugin.downloader_app.b.a.a(13, 1303, 0, 1, "", "", "");
          for (;;)
          {
            AppMethodBeat.o(8943);
            return 0;
            label626:
            DownloadSearchUI.a(DownloadSearchUI.this).setVisibility(8);
            DownloadSearchUI.e(DownloadSearchUI.this).setVisibility(0);
            DownloadSearchUI.e(DownloadSearchUI.this).setText(DownloadSearchUI.this.getString(2131758143, new Object[] { paramString }));
            com.tencent.mm.plugin.downloader_app.b.a.a(13, 1304, 0, 1, "", "", "");
          }
        }
      }
    });
    com.tencent.mm.plugin.downloader_app.b.a.a(13, 1301, 1, 2, "", "", com.tencent.mm.plugin.downloader_app.b.a.fq("search_key_word", paramString));
    AppMethodBeat.o(8950);
  }
  
  public final void aSL()
  {
    AppMethodBeat.i(8949);
    ae.i("MicroMsg.DownloadSearchUI", "onQuitSearch");
    hideVKB();
    onBackPressed();
    AppMethodBeat.o(8949);
  }
  
  public final void aSM()
  {
    AppMethodBeat.i(8948);
    ae.i("MicroMsg.DownloadSearchUI", "onEnterSearch");
    AppMethodBeat.o(8948);
  }
  
  public final void aSN()
  {
    AppMethodBeat.i(8952);
    ae.i("MicroMsg.DownloadSearchUI", "onClickClearText");
    com.tencent.mm.plugin.downloader_app.b.a.a(13, 1301, 2, 81, "", "", "");
    AppMethodBeat.o(8952);
  }
  
  public final void aSO()
  {
    AppMethodBeat.i(8953);
    ae.i("MicroMsg.DownloadSearchUI", "onSearchEditTextReady");
    AppMethodBeat.o(8953);
  }
  
  public int getLayoutId()
  {
    return 2131493724;
  }
  
  public void initView()
  {
    AppMethodBeat.i(8945);
    super.initView();
    this.pwr = ((DownloadSearchListView)findViewById(2131304442));
    this.jtq = ((ProgressBar)findViewById(2131304439));
    this.pws = ((TextView)findViewById(2131302883));
    this.fUI = new r();
    this.fUI.yP(true);
    this.fUI.Lhk = this;
    this.pwr.setOnItemClickListener(new MRecyclerView.a()
    {
      public final void T(View paramAnonymousView, int paramAnonymousInt)
      {
        AppMethodBeat.i(8942);
        paramAnonymousView = DownloadSearchUI.a(DownloadSearchUI.this).pwm.mDataList;
        if ((paramAnonymousView != null) && (paramAnonymousInt >= 0) && (paramAnonymousInt < paramAnonymousView.size())) {}
        for (paramAnonymousView = (b)paramAnonymousView.get(paramAnonymousInt); paramAnonymousView == null; paramAnonymousView = null)
        {
          AppMethodBeat.o(8942);
          return;
        }
        if (paramAnonymousView.type == 2)
        {
          DownloadSearchUI.a(DownloadSearchUI.this).abw(paramAnonymousView.pwx);
          DownloadSearchUI.b(DownloadSearchUI.this).setSearchContent(paramAnonymousView.pwx);
          com.tencent.mm.plugin.downloader_app.b.a.a(13, 1302, paramAnonymousView.position, 2, "", "", com.tencent.mm.plugin.downloader_app.b.a.fq("search_key_word", paramAnonymousView.pwx));
          AppMethodBeat.o(8942);
          return;
        }
        if (paramAnonymousView.type == 3)
        {
          DownloadSearchUI.a(DownloadSearchUI.this).abw(DownloadSearchUI.b(DownloadSearchUI.this).getSearchContent());
          if (!bu.isNullOrNil(paramAnonymousView.jumpUrl))
          {
            Bundle localBundle = new Bundle();
            localBundle.putString("rawUrl", paramAnonymousView.jumpUrl);
            ((com.tencent.mm.plugin.downloader_app.api.c)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.downloader_app.api.c.class)).e(DownloadSearchUI.this.getContext(), localBundle);
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
    this.fUI.a(this, paramMenu);
    this.fUI.setHint(getString(2131758145));
    AppMethodBeat.o(8946);
    return true;
  }
  
  public boolean onPrepareOptionsMenu(Menu paramMenu)
  {
    AppMethodBeat.i(8947);
    this.fUI.a(this, paramMenu);
    AppMethodBeat.o(8947);
    return true;
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.downloader_app.search.DownloadSearchUI
 * JD-Core Version:    0.7.0.1
 */