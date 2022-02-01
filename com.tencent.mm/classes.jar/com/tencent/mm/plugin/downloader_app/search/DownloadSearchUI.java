package com.tencent.mm.plugin.downloader_app.search;

import android.app.Activity;
import android.content.pm.PackageInfo;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.widget.ProgressBar;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.al.b.a;
import com.tencent.mm.al.b.c;
import com.tencent.mm.al.n;
import com.tencent.mm.al.x;
import com.tencent.mm.al.x.a;
import com.tencent.mm.plugin.appbrand.widget.recyclerview.MRecyclerView.a;
import com.tencent.mm.plugin.downloader.c.a.a.h;
import com.tencent.mm.plugin.downloader.c.a.a.l;
import com.tencent.mm.plugin.downloader.c.a.a.m;
import com.tencent.mm.plugin.downloader.c.a.a.o;
import com.tencent.mm.plugin.downloader.c.b.e;
import com.tencent.mm.plugin.downloader.c.b.k;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.aj;
import com.tencent.mm.sdk.platformtools.bt;
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
  private r fvI;
  private ProgressBar ixl;
  private DownloadSearchListView oiD;
  private TextView oiE;
  private String oiF;
  private boolean oiG;
  
  public final boolean BX(String paramString)
  {
    AppMethodBeat.i(8951);
    ad.i("MicroMsg.DownloadSearchUI", "onSearchKeyDown");
    if (bt.isNullOrNil(paramString))
    {
      AppMethodBeat.o(8951);
      return true;
    }
    this.oiD.SM(paramString);
    AppMethodBeat.o(8951);
    return true;
  }
  
  public final void BY(final String paramString)
  {
    AppMethodBeat.i(8950);
    ad.i("MicroMsg.DownloadSearchUI", "onSearchChange");
    this.oiE.setVisibility(8);
    if ((this.oiF != null) && (this.oiF.equals(bt.nullAsNil(paramString))))
    {
      ad.d("MicroMsg.DownloadSearchUI", "repeat searchChange");
      AppMethodBeat.o(8950);
      return;
    }
    this.oiF = paramString;
    if (bt.isNullOrNil(paramString))
    {
      this.ixl.setVisibility(8);
      paramString = this.oiD;
      paramString.setVisibility(0);
      if (bt.gL(paramString.oiz)) {
        paramString.oiz = b.eq(paramString.mContext);
      }
      paramString.setData(paramString.oiz);
      this.oiG = true;
      AppMethodBeat.o(8950);
      return;
    }
    this.oiD.setData(null);
    this.oiG = false;
    this.oiD.setData(null);
    this.ixl.setVisibility(0);
    b.a locala = new b.a();
    l locall = new l();
    locall.ocP = paramString;
    o localo = new o();
    localo.offset = 0;
    localo.limit = 5;
    locall.ocQ = localo;
    locala.gUU = locall;
    locala.gUV = new m();
    locala.uri = "/cgi-bin/mmgame-bin/getgamesearch";
    locala.funcId = 2688;
    x.a(locala.atI(), new x.a()
    {
      public final int a(int paramAnonymousInt1, int paramAnonymousInt2, String paramAnonymousString, com.tencent.mm.al.b paramAnonymousb, n paramAnonymousn)
      {
        AppMethodBeat.i(8943);
        ad.i("MicroMsg.DownloadSearchUI", "errType = %d, errCode = %d", new Object[] { Integer.valueOf(paramAnonymousInt1), Integer.valueOf(paramAnonymousInt2) });
        if ((DownloadSearchUI.c(DownloadSearchUI.this)) || (DownloadSearchUI.this.isFinishing()))
        {
          AppMethodBeat.o(8943);
          return 0;
        }
        DownloadSearchUI.d(DownloadSearchUI.this).setVisibility(8);
        Object localObject1;
        if ((paramAnonymousInt1 == 0) && (paramAnonymousInt2 == 0))
        {
          paramAnonymousString = (m)paramAnonymousb.gUT.gUX;
          if ((paramAnonymousString == null) || (paramAnonymousString.ocS == null) || (bt.gL(paramAnonymousString.ocS.ocL))) {
            break label626;
          }
          paramAnonymousn = new ArrayList();
          paramAnonymousInt1 = 0;
          Iterator localIterator = paramAnonymousString.ocS.ocL.iterator();
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
          Object localObject3 = paramAnonymousString.ocJ;
          if (localObject3 == null)
          {
            paramAnonymousString = null;
            break label171;
          }
          Object localObject2 = ((com.tencent.mm.plugin.downloader.c.a.a.d)localObject3).ocC;
          localObject3 = ((com.tencent.mm.plugin.downloader.c.a.a.d)localObject3).ocE;
          if (localObject3 != null) {
            paramAnonymousb.jumpUrl = ((com.tencent.mm.plugin.downloader.c.a.a.c)localObject3).ocB;
          }
          if (localObject2 == null)
          {
            paramAnonymousString = null;
            break label171;
          }
          localObject3 = ((k)localObject2).odL;
          e locale = ((k)localObject2).odM;
          localObject2 = ((k)localObject2).odN;
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
          paramAnonymousb.appId = ((com.tencent.mm.plugin.downloader.c.b.d)localObject3).dlB;
          paramAnonymousb.oiK = paramAnonymousString.ocK;
          paramAnonymousb.iconUrl = ((com.tencent.mm.plugin.downloader.c.b.d)localObject3).odo;
          if ((locale != null) && (!bt.gL(locale.odu))) {
            paramAnonymousb.oiL = locale.odu;
          }
          if ((localObject2 != null) && (((com.tencent.mm.plugin.downloader.c.b.g)localObject2).odC != null)) {
            paramAnonymousb.size = ((com.tencent.mm.plugin.downloader.c.b.g)localObject2).odC.odd;
          }
          paramAnonymousb.oiJ = ((String)localObject1);
          paramAnonymousb.state = 1;
          paramAnonymousString = paramAnonymousb;
          if (localObject2 == null) {
            break label171;
          }
          paramAnonymousString = paramAnonymousb;
          if (((com.tencent.mm.plugin.downloader.c.b.g)localObject2).odC == null) {
            break label171;
          }
          paramAnonymousString = com.tencent.mm.plugin.appbrand.aa.b.getPackageInfo(aj.getContext(), ((com.tencent.mm.plugin.downloader.c.b.g)localObject2).odC.odc);
          localObject1 = com.tencent.mm.plugin.downloader.model.d.Sk(paramAnonymousb.appId);
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
            if (!com.tencent.mm.vfs.i.eK(((com.tencent.mm.plugin.downloader.g.a)localObject1).field_filePath)) {
              break label171;
            }
            paramAnonymousb.state = 4;
            paramAnonymousString = paramAnonymousb;
            break label171;
          }
          if (paramAnonymousString.versionCode < ((com.tencent.mm.plugin.downloader.c.b.g)localObject2).odC.odg)
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
          paramAnonymousString.oiA.clear();
          if (!bt.gL(paramAnonymousn)) {
            paramAnonymousString.oiA.addAll(paramAnonymousn);
          }
          paramAnonymousString.setData(paramAnonymousString.oiA);
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
    com.tencent.mm.plugin.downloader_app.b.a.a(13, 1301, 1, 2, "", "", com.tencent.mm.plugin.downloader_app.b.a.eP("search_key_word", paramString));
    AppMethodBeat.o(8950);
  }
  
  public final void aIj()
  {
    AppMethodBeat.i(8949);
    ad.i("MicroMsg.DownloadSearchUI", "onQuitSearch");
    hideVKB();
    onBackPressed();
    AppMethodBeat.o(8949);
  }
  
  public final void aIk()
  {
    AppMethodBeat.i(8948);
    ad.i("MicroMsg.DownloadSearchUI", "onEnterSearch");
    AppMethodBeat.o(8948);
  }
  
  public final void aIl()
  {
    AppMethodBeat.i(8952);
    ad.i("MicroMsg.DownloadSearchUI", "onClickClearText");
    com.tencent.mm.plugin.downloader_app.b.a.a(13, 1301, 2, 81, "", "", "");
    AppMethodBeat.o(8952);
  }
  
  public final void aIm()
  {
    AppMethodBeat.i(8953);
    ad.i("MicroMsg.DownloadSearchUI", "onSearchEditTextReady");
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
    this.oiD = ((DownloadSearchListView)findViewById(2131304442));
    this.ixl = ((ProgressBar)findViewById(2131304439));
    this.oiE = ((TextView)findViewById(2131302883));
    this.fvI = new r();
    this.fvI.wH(true);
    this.fvI.Htp = this;
    this.oiD.setOnItemClickListener(new MRecyclerView.a()
    {
      public final void S(View paramAnonymousView, int paramAnonymousInt)
      {
        AppMethodBeat.i(8942);
        paramAnonymousView = DownloadSearchUI.a(DownloadSearchUI.this).oiy.hIH;
        if ((paramAnonymousView != null) && (paramAnonymousInt >= 0) && (paramAnonymousInt < paramAnonymousView.size())) {}
        for (paramAnonymousView = (b)paramAnonymousView.get(paramAnonymousInt); paramAnonymousView == null; paramAnonymousView = null)
        {
          AppMethodBeat.o(8942);
          return;
        }
        if (paramAnonymousView.type == 2)
        {
          DownloadSearchUI.a(DownloadSearchUI.this).SM(paramAnonymousView.oiJ);
          DownloadSearchUI.b(DownloadSearchUI.this).setSearchContent(paramAnonymousView.oiJ);
          com.tencent.mm.plugin.downloader_app.b.a.a(13, 1302, paramAnonymousView.position, 2, "", "", com.tencent.mm.plugin.downloader_app.b.a.eP("search_key_word", paramAnonymousView.oiJ));
          AppMethodBeat.o(8942);
          return;
        }
        if (paramAnonymousView.type == 3)
        {
          DownloadSearchUI.a(DownloadSearchUI.this).SM(DownloadSearchUI.b(DownloadSearchUI.this).getSearchContent());
          if (!bt.isNullOrNil(paramAnonymousView.jumpUrl))
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
    this.fvI.a(this, paramMenu);
    this.fvI.setHint(getString(2131758145));
    AppMethodBeat.o(8946);
    return true;
  }
  
  public boolean onPrepareOptionsMenu(Menu paramMenu)
  {
    AppMethodBeat.i(8947);
    this.fvI.a(this, paramMenu);
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