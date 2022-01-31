package com.tencent.mm.plugin.downloader_app.search;

import android.content.pm.PackageInfo;
import android.os.Bundle;
import android.view.Menu;
import android.widget.ProgressBar;
import android.widget.TextView;
import com.tencent.mm.ah.b.a;
import com.tencent.mm.ah.b.c;
import com.tencent.mm.ah.m;
import com.tencent.mm.ah.w;
import com.tencent.mm.ah.w.a;
import com.tencent.mm.plugin.downloader.e.d;
import com.tencent.mm.plugin.downloader.e.f;
import com.tencent.mm.plugin.downloader.e.g;
import com.tencent.mm.plugin.downloader.e.h;
import com.tencent.mm.plugin.downloader.e.i;
import com.tencent.mm.plugin.downloader.e.k;
import com.tencent.mm.plugin.downloader.e.o;
import com.tencent.mm.plugin.downloader.e.q;
import com.tencent.mm.plugin.downloader.e.s;
import com.tencent.mm.plugin.downloader.f.a;
import com.tencent.mm.plugin.downloader.model.c;
import com.tencent.mm.plugin.downloader_app.b.e;
import com.tencent.mm.plugin.downloader_app.b.f;
import com.tencent.mm.plugin.downloader_app.b.h;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.sdk.platformtools.y;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.tools.n.b;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public class DownloadSearchUI
  extends MMActivity
  implements n.b
{
  private com.tencent.mm.ui.tools.n drn;
  private ProgressBar fsc;
  private DownloadSearchListView iSS;
  private TextView iST;
  private String iSU;
  
  public final void Wl()
  {
    y.i("MicroMsg.DownloadSearchUI", "onQuitSearch");
    XM();
    onBackPressed();
  }
  
  public final void Wm()
  {
    y.i("MicroMsg.DownloadSearchUI", "onEnterSearch");
  }
  
  public final void Wn()
  {
    y.i("MicroMsg.DownloadSearchUI", "onClickClearText");
  }
  
  public final void Wo()
  {
    y.i("MicroMsg.DownloadSearchUI", "onSearchEditTextReady");
  }
  
  protected final int getLayoutId()
  {
    return b.f.download_search_layout;
  }
  
  protected final void initView()
  {
    super.initView();
    this.iSS = ((DownloadSearchListView)findViewById(b.e.search_result));
    this.fsc = ((ProgressBar)findViewById(b.e.search_progress_bar));
    this.iST = ((TextView)findViewById(b.e.no_result));
    this.drn = new com.tencent.mm.ui.tools.n();
    this.drn.nK(true);
    this.drn.weq = this;
    this.iSS.setOnItemClickListener(new DownloadSearchUI.1(this));
  }
  
  public void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    initView();
  }
  
  public boolean onCreateOptionsMenu(Menu paramMenu)
  {
    this.drn.a(this, paramMenu);
    this.drn.setHint(getString(b.h.downloaderapp_search_hint));
    return true;
  }
  
  public boolean onPrepareOptionsMenu(Menu paramMenu)
  {
    this.drn.a(this, paramMenu);
    return true;
  }
  
  public final boolean pB(String paramString)
  {
    y.i("MicroMsg.DownloadSearchUI", "onSearchKeyDown");
    if (bk.bl(paramString)) {
      return true;
    }
    this.iSS.Ag(paramString);
    return true;
  }
  
  public final void pC(final String paramString)
  {
    y.i("MicroMsg.DownloadSearchUI", "onSearchChange");
    this.iST.setVisibility(8);
    if ((this.iSU != null) && (this.iSU.equals(bk.pm(paramString))))
    {
      y.d("MicroMsg.DownloadSearchUI", "repeat searchChange");
      return;
    }
    this.iSU = paramString;
    if (bk.bl(paramString))
    {
      this.fsc.setVisibility(8);
      paramString = this.iSS;
      paramString.setVisibility(0);
      if (bk.dk(paramString.iSO)) {
        paramString.iSO = b.cV(paramString.mContext);
      }
      paramString.setData(paramString.iSO);
      return;
    }
    this.iSS.setData(null);
    this.iSS.setData(null);
    this.fsc.setVisibility(0);
    b.a locala = new b.a();
    com.tencent.mm.plugin.downloader.e.p localp = new com.tencent.mm.plugin.downloader.e.p();
    localp.iQX = paramString;
    s locals = new s();
    locals.offset = 0;
    locals.limit = 5;
    localp.iQY = locals;
    locala.ecH = localp;
    locala.ecI = new q();
    locala.uri = "/cgi-bin/mmgame-bin/getgamesearch";
    locala.ecG = 2688;
    w.a(locala.Kt(), new w.a()
    {
      public final int a(int paramAnonymousInt1, int paramAnonymousInt2, String paramAnonymousString, com.tencent.mm.ah.b paramAnonymousb, m paramAnonymousm)
      {
        y.i("MicroMsg.DownloadSearchUI", "errType = %d, errCode = %d", new Object[] { Integer.valueOf(paramAnonymousInt1), Integer.valueOf(paramAnonymousInt2) });
        DownloadSearchUI.c(DownloadSearchUI.this).setVisibility(8);
        if ((paramAnonymousInt1 == 0) && (paramAnonymousInt2 == 0))
        {
          paramAnonymousString = (q)paramAnonymousb.ecF.ecN;
          if ((paramAnonymousString == null) || (paramAnonymousString.iRa == null) || (bk.dk(paramAnonymousString.iRa.iQW))) {
            break label525;
          }
          paramAnonymousb = new ArrayList();
          paramAnonymousm = paramAnonymousString.iRa.iQW.iterator();
          if (paramAnonymousm.hasNext())
          {
            Object localObject1 = (com.tencent.mm.plugin.downloader.e.n)paramAnonymousm.next();
            Object localObject2 = paramString;
            if (localObject1 == null) {
              paramAnonymousString = null;
            }
            label137:
            Object localObject3;
            for (;;)
            {
              if (paramAnonymousString != null)
              {
                paramAnonymousb.add(paramAnonymousString);
                break;
                paramAnonymousString = new b();
                paramAnonymousString.type = 3;
                Object localObject4 = ((com.tencent.mm.plugin.downloader.e.n)localObject1).iQU;
                if (localObject4 == null)
                {
                  paramAnonymousString = null;
                }
                else
                {
                  localObject3 = ((i)localObject4).iQy;
                  localObject4 = ((i)localObject4).iQA;
                  if (localObject4 != null) {
                    paramAnonymousString.jumpUrl = ((g)localObject4).iQu;
                  }
                  if (localObject3 == null)
                  {
                    paramAnonymousString = null;
                  }
                  else
                  {
                    localObject4 = ((k)localObject3).iQG;
                    f localf = ((k)localObject3).iQH;
                    localObject3 = ((k)localObject3).iQI;
                    if (localObject4 == null)
                    {
                      paramAnonymousString = null;
                    }
                    else if (((com.tencent.mm.plugin.downloader.e.e)localObject4).status != 0)
                    {
                      paramAnonymousString = null;
                    }
                    else
                    {
                      paramAnonymousString.appId = ((com.tencent.mm.plugin.downloader.e.e)localObject4).bOL;
                      paramAnonymousString.iSY = ((com.tencent.mm.plugin.downloader.e.n)localObject1).iQV;
                      paramAnonymousString.iconUrl = ((com.tencent.mm.plugin.downloader.e.e)localObject4).iQn;
                      if ((localf != null) && (!bk.dk(localf.iQq))) {
                        paramAnonymousString.iSZ = localf.iQq;
                      }
                      if ((localObject3 != null) && (((h)localObject3).iQv != null)) {
                        paramAnonymousString.size = ((h)localObject3).iQv.iQf;
                      }
                      paramAnonymousString.iSX = ((String)localObject2);
                      paramAnonymousString.state = 1;
                      if ((localObject3 != null) && (((h)localObject3).iQv != null))
                      {
                        localObject1 = com.tencent.mm.pluginsdk.model.app.p.getPackageInfo(ae.getContext(), ((h)localObject3).iQv.iQe);
                        localObject2 = c.zH(paramAnonymousString.appId);
                        if (localObject1 != null) {
                          break label429;
                        }
                        if ((localObject2 != null) && (((a)localObject2).field_status == 3) && (com.tencent.mm.vfs.e.bK(((a)localObject2).field_filePath))) {
                          paramAnonymousString.state = 4;
                        }
                      }
                    }
                  }
                }
              }
            }
            for (;;)
            {
              break label137;
              break;
              label429:
              if (((PackageInfo)localObject1).versionCode < ((h)localObject3).iQv.iQi) {
                paramAnonymousString.state = 3;
              } else {
                paramAnonymousString.state = 2;
              }
            }
          }
          DownloadSearchUI.d(DownloadSearchUI.this).setVisibility(8);
          paramAnonymousString = DownloadSearchUI.a(DownloadSearchUI.this);
          paramAnonymousString.setVisibility(0);
          paramAnonymousString.iSP.clear();
          if (!bk.dk(paramAnonymousb)) {
            paramAnonymousString.iSP.addAll(paramAnonymousb);
          }
          paramAnonymousString.setData(paramAnonymousString.iSP);
        }
        for (;;)
        {
          return 0;
          label525:
          DownloadSearchUI.a(DownloadSearchUI.this).setVisibility(8);
          DownloadSearchUI.d(DownloadSearchUI.this).setVisibility(0);
          DownloadSearchUI.d(DownloadSearchUI.this).setText(DownloadSearchUI.this.getString(b.h.downloaderapp_no_search_result, new Object[] { paramString }));
        }
      }
    });
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.downloader_app.search.DownloadSearchUI
 * JD-Core Version:    0.7.0.1
 */