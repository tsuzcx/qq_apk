package com.tencent.mm.plugin.downloader_app.search;

import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.widget.ProgressBar;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ai.b.a;
import com.tencent.mm.ai.w;
import com.tencent.mm.plugin.downloader.c.a.a.l;
import com.tencent.mm.plugin.downloader.c.a.a.m;
import com.tencent.mm.plugin.downloader.c.a.a.o;
import com.tencent.mm.plugin.downloader_app.c.a;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.tools.q;
import com.tencent.mm.ui.tools.q.b;

public class DownloadSearchUI
  extends MMActivity
  implements q.b
{
  private q eiV;
  private ProgressBar gJE;
  private DownloadSearchListView lbC;
  private TextView lbD;
  private String lbE;
  private boolean lbF;
  
  public final void apN()
  {
    AppMethodBeat.i(136188);
    ab.i("MicroMsg.DownloadSearchUI", "onQuitSearch");
    hideVKB();
    onBackPressed();
    AppMethodBeat.o(136188);
  }
  
  public final void apO()
  {
    AppMethodBeat.i(136187);
    ab.i("MicroMsg.DownloadSearchUI", "onEnterSearch");
    AppMethodBeat.o(136187);
  }
  
  public final void apP()
  {
    AppMethodBeat.i(136191);
    ab.i("MicroMsg.DownloadSearchUI", "onClickClearText");
    a.a(13, 1301, 2, 81, "", "", "");
    AppMethodBeat.o(136191);
  }
  
  public final void apQ()
  {
    AppMethodBeat.i(136192);
    ab.i("MicroMsg.DownloadSearchUI", "onSearchEditTextReady");
    AppMethodBeat.o(136192);
  }
  
  public int getLayoutId()
  {
    return 2130969335;
  }
  
  public void initView()
  {
    AppMethodBeat.i(136184);
    super.initView();
    this.lbC = ((DownloadSearchListView)findViewById(2131823449));
    this.gJE = ((ProgressBar)findViewById(2131823450));
    this.lbD = ((TextView)findViewById(2131821961));
    this.eiV = new q();
    this.eiV.ru(true);
    this.eiV.Axg = this;
    this.lbC.setOnItemClickListener(new DownloadSearchUI.1(this));
    AppMethodBeat.o(136184);
  }
  
  public void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(136183);
    super.onCreate(paramBundle);
    initView();
    a.a(13, 0, 0, 1, "", "", "");
    AppMethodBeat.o(136183);
  }
  
  public boolean onCreateOptionsMenu(Menu paramMenu)
  {
    AppMethodBeat.i(136185);
    this.eiV.a(this, paramMenu);
    this.eiV.setHint(getString(2131299042));
    AppMethodBeat.o(136185);
    return true;
  }
  
  public boolean onPrepareOptionsMenu(Menu paramMenu)
  {
    AppMethodBeat.i(136186);
    this.eiV.a(this, paramMenu);
    AppMethodBeat.o(136186);
    return true;
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
  
  public final boolean wR(String paramString)
  {
    AppMethodBeat.i(136190);
    ab.i("MicroMsg.DownloadSearchUI", "onSearchKeyDown");
    if (bo.isNullOrNil(paramString))
    {
      AppMethodBeat.o(136190);
      return true;
    }
    this.lbC.Kd(paramString);
    AppMethodBeat.o(136190);
    return true;
  }
  
  public final void wS(String paramString)
  {
    AppMethodBeat.i(136189);
    ab.i("MicroMsg.DownloadSearchUI", "onSearchChange");
    this.lbD.setVisibility(8);
    if ((this.lbE != null) && (this.lbE.equals(bo.nullAsNil(paramString))))
    {
      ab.d("MicroMsg.DownloadSearchUI", "repeat searchChange");
      AppMethodBeat.o(136189);
      return;
    }
    this.lbE = paramString;
    if (bo.isNullOrNil(paramString))
    {
      this.gJE.setVisibility(8);
      paramString = this.lbC;
      paramString.setVisibility(0);
      if (bo.es(paramString.lby)) {
        paramString.lby = b.dI(paramString.mContext);
      }
      paramString.setData(paramString.lby);
      this.lbF = true;
      AppMethodBeat.o(136189);
      return;
    }
    this.lbC.setData(null);
    this.lbF = false;
    this.lbC.setData(null);
    this.gJE.setVisibility(0);
    b.a locala = new b.a();
    l locall = new l();
    locall.kWd = paramString;
    o localo = new o();
    localo.offset = 0;
    localo.limit = 5;
    locall.kWe = localo;
    locala.fsX = locall;
    locala.fsY = new m();
    locala.uri = "/cgi-bin/mmgame-bin/getgamesearch";
    locala.funcId = 2688;
    w.a(locala.ado(), new DownloadSearchUI.2(this, paramString));
    a.a(13, 1301, 1, 2, "", "", a.dG("search_key_word", paramString));
    AppMethodBeat.o(136189);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.downloader_app.search.DownloadSearchUI
 * JD-Core Version:    0.7.0.1
 */