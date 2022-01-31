package com.tencent.mm.plugin.fts.ui;

import android.app.Activity;
import android.app.ActivityOptions;
import android.content.Intent;
import android.content.res.Resources;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Pair;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.g;
import com.tencent.mm.kernel.i;
import com.tencent.mm.model.ag;
import com.tencent.mm.model.t;
import com.tencent.mm.plugin.fts.a.d.a.a;
import com.tencent.mm.plugin.fts.a.n;
import com.tencent.mm.plugin.messenger.foundation.a.j;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.storage.ad;
import com.tencent.mm.storage.bd;
import com.tencent.mm.storage.u;
import java.util.List;

@i
public class FTSChattingConvUI
  extends FTSBaseUI
  implements View.OnClickListener
{
  private ad contact;
  private String mSN;
  private View mWW;
  private f mWX;
  
  private static void af(String paramString, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(61810);
    paramString = String.format("%s,%d,%d,%d,%d", new Object[] { paramString, Integer.valueOf(paramInt1), Integer.valueOf(5), Integer.valueOf(paramInt2), Integer.valueOf(0) });
    ab.v("MicroMsg.FTS.FTSChattingConvUI", "reportClick: %s", new Object[] { paramString });
    h.qsU.kvStat(13234, paramString);
    AppMethodBeat.o(61810);
  }
  
  private void kS(int paramInt)
  {
    AppMethodBeat.i(61806);
    if (t.nI(this.mSN))
    {
      u localu = ((com.tencent.mm.plugin.chatroom.a.c)g.E(com.tencent.mm.plugin.chatroom.a.c.class)).YJ().oV(this.mSN);
      if (localu.afx() != null)
      {
        if (paramInt == 0)
        {
          h.qsU.e(14569, new Object[] { Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(1), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(localu.afx().size()), Integer.valueOf(1) });
          AppMethodBeat.o(61806);
          return;
        }
        h.qsU.e(14569, new Object[] { Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(1), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(localu.afx().size()), Integer.valueOf(1) });
      }
      AppMethodBeat.o(61806);
      return;
    }
    if (paramInt == 0)
    {
      h.qsU.e(14569, new Object[] { Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(1), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0) });
      AppMethodBeat.o(61806);
      return;
    }
    h.qsU.e(14569, new Object[] { Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(1), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0) });
    AppMethodBeat.o(61806);
  }
  
  protected final void Pv(String paramString)
  {
    int i = 1;
    AppMethodBeat.i(61807);
    super.Pv(paramString);
    boolean bool = t.nI(this.mSN);
    paramString = h.qsU;
    if (bool) {}
    for (;;)
    {
      paramString.e(14569, new Object[] { Integer.valueOf(0), Integer.valueOf(1), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(i) });
      AppMethodBeat.o(61807);
      return;
      i = 0;
    }
  }
  
  protected final d a(e parame)
  {
    AppMethodBeat.i(61800);
    if (this.mWX == null) {
      this.mWX = new f(parame, this.mSN);
    }
    parame = this.mWX;
    AppMethodBeat.o(61800);
    return parame;
  }
  
  public final void a(a parama)
  {
    AppMethodBeat.i(61801);
    if (t.nI(this.mSN))
    {
      af(this.query, 10, parama.position + 1);
      AppMethodBeat.o(61801);
      return;
    }
    af(this.query, 11, parama.position + 1);
    AppMethodBeat.o(61801);
  }
  
  protected final void bCD()
  {
    AppMethodBeat.i(61799);
    this.mSN = getIntent().getStringExtra("detail_username");
    this.contact = ((j)g.E(j.class)).YA().arw(this.mSN);
    ab.i("MicroMsg.FTS.FTSChattingConvUI", "initSearchData conversation=%s", new Object[] { this.mSN });
    AppMethodBeat.o(61799);
  }
  
  protected final void bCF()
  {
    AppMethodBeat.i(61805);
    super.bCF();
    this.mWW.setVisibility(8);
    AppMethodBeat.o(61805);
  }
  
  protected final void bCG()
  {
    AppMethodBeat.i(61803);
    super.bCG();
    this.mWW.setVisibility(8);
    AppMethodBeat.o(61803);
  }
  
  protected final void bCH()
  {
    AppMethodBeat.i(61804);
    super.bCH();
    this.mWW.setVisibility(8);
    AppMethodBeat.o(61804);
  }
  
  protected final void bCI()
  {
    AppMethodBeat.i(61802);
    super.bCI();
    this.mWW.setVisibility(0);
    AppMethodBeat.o(61802);
  }
  
  public int getLayoutId()
  {
    return 2130969655;
  }
  
  public void initView()
  {
    AppMethodBeat.i(61798);
    super.initView();
    this.mWW = findViewById(2131824343);
    this.mWW.setVisibility(0);
    RecyclerView localRecyclerView = (RecyclerView)findViewById(2131824344);
    getContext();
    localRecyclerView.setLayoutManager(new GridLayoutManager(3));
    localRecyclerView.a(new FTSChattingConvUI.1(this));
    localRecyclerView.setAdapter(new FTSChattingConvUI.a(this));
    AppMethodBeat.o(61798);
  }
  
  public void onClick(View paramView)
  {
    Intent localIntent2 = null;
    Object localObject1 = null;
    Object localObject2 = null;
    Intent localIntent1 = null;
    AppMethodBeat.i(61809);
    if (!(paramView instanceof TextView))
    {
      AppMethodBeat.o(61809);
      return;
    }
    int i = ((Integer)paramView.getTag()).intValue();
    if (t.nI(this.mSN)) {}
    while (i == 0)
    {
      ab.i("MicroMsg.FTS.FTSChattingConvUI", "onSearchMemberDetail");
      paramView = new Intent();
      paramView.putExtra("from_scene", 1);
      paramView.putExtra("RoomInfo_Id", this.mSN);
      paramView.putExtra("title", getResources().getString(2131302965));
      com.tencent.mm.bq.d.f(this, "com.tencent.mm.chatroom.ui.SeeMemberRecordUI", paramView);
      AppMethodBeat.o(61809);
      return;
      i += 1;
    }
    if (i == 1)
    {
      ab.i("MicroMsg.FTS.FTSChattingConvUI", "onSearchDateDetail");
      paramView = new Intent();
      paramView.putExtra("detail_username", this.mSN);
      com.tencent.mm.bq.d.f(this, "com.tencent.mm.chatroom.ui.SelectDateUI", paramView);
      kS(0);
      AppMethodBeat.o(61809);
      return;
    }
    if (i == 2)
    {
      ab.i("MicroMsg.FTS.FTSChattingConvUI", "onSeeImageVideoHistory");
      paramView = new Intent();
      paramView.putExtra("kintent_talker", this.mSN);
      paramView.putExtra("key_media_type", 1);
      com.tencent.mm.bq.d.f(this, "com.tencent.mm.ui.chatting.gallery.MediaHistoryGalleryUI", paramView);
      kS(1);
      AppMethodBeat.o(61809);
      return;
    }
    if (i == 3)
    {
      ab.i("MicroMsg.FTS.FTSChattingConvUI", "onSeeFileHistory");
      localIntent1 = new Intent();
      localIntent1.putExtra("kintent_talker", this.mSN);
      localIntent1.putExtra("key_media_type", 2);
      if (Build.VERSION.SDK_INT < 21) {
        break label644;
      }
    }
    label644:
    for (paramView = ActivityOptions.makeSceneTransitionAnimation(this, new Pair[0]).toBundle();; paramView = null)
    {
      com.tencent.mm.bq.d.c(this, "com.tencent.mm.ui.chatting.gallery.MediaHistoryListUI", localIntent1, paramView);
      AppMethodBeat.o(61809);
      return;
      if (i == 4)
      {
        ab.i("MicroMsg.FTS.FTSChattingConvUI", "onSeeUrlHistory");
        localIntent2 = new Intent();
        localIntent2.putExtra("kintent_talker", this.mSN);
        localIntent2.putExtra("key_media_type", 3);
        paramView = localIntent1;
        if (Build.VERSION.SDK_INT >= 21) {
          paramView = ActivityOptions.makeSceneTransitionAnimation(this, new Pair[0]).toBundle();
        }
        com.tencent.mm.bq.d.c(this, "com.tencent.mm.ui.chatting.gallery.MediaHistoryListUI", localIntent2, paramView);
        AppMethodBeat.o(61809);
        return;
      }
      if (i == 5)
      {
        ab.i("MicroMsg.FTS.FTSChattingConvUI", "onSeeUrlHistory");
        localIntent1 = new Intent();
        localIntent1.putExtra("kintent_talker", this.mSN);
        localIntent1.putExtra("key_media_type", 4);
        paramView = localIntent2;
        if (Build.VERSION.SDK_INT >= 21) {
          paramView = ActivityOptions.makeSceneTransitionAnimation(this, new Pair[0]).toBundle();
        }
        com.tencent.mm.bq.d.c(this, "com.tencent.mm.ui.chatting.gallery.MediaHistoryListUI", localIntent1, paramView);
        AppMethodBeat.o(61809);
        return;
      }
      if (i == 6)
      {
        ab.i("MicroMsg.FTS.FTSChattingConvUI", "onSeePayHistory");
        localIntent1 = new Intent();
        localIntent1.putExtra("kintent_talker", this.mSN);
        localIntent1.putExtra("key_media_type", 5);
        paramView = localObject1;
        if (Build.VERSION.SDK_INT >= 21) {
          paramView = ActivityOptions.makeSceneTransitionAnimation(this, new Pair[0]).toBundle();
        }
        com.tencent.mm.bq.d.c(this, "com.tencent.mm.ui.chatting.gallery.MediaHistoryListUI", localIntent1, paramView);
        AppMethodBeat.o(61809);
        return;
      }
      if (i == 7)
      {
        ab.i("MicroMsg.FTS.FTSChattingConvUI", "onSeeAppBrandHistory");
        localIntent1 = new Intent();
        localIntent1.putExtra("kintent_talker", this.mSN);
        localIntent1.putExtra("key_media_type", 6);
        paramView = localObject2;
        if (Build.VERSION.SDK_INT >= 21) {
          paramView = ActivityOptions.makeSceneTransitionAnimation(this, new Pair[0]).toBundle();
        }
        com.tencent.mm.bq.d.c(this, "com.tencent.mm.ui.chatting.gallery.MediaHistoryListUI", localIntent1, paramView);
      }
      AppMethodBeat.o(61809);
      return;
    }
  }
  
  public void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(61797);
    super.onCreate(paramBundle);
    initView();
    paramBundle = ((n)g.G(n.class)).getFTSImageLoader();
    if (paramBundle != null) {
      paramBundle.bBL();
    }
    AppMethodBeat.o(61797);
  }
  
  public void onDestroy()
  {
    AppMethodBeat.i(61808);
    super.onDestroy();
    this.mWX.finish();
    com.tencent.mm.plugin.fts.a.d.c localc = ((n)g.G(n.class)).getFTSImageLoader();
    if (localc != null) {
      localc.bBJ();
    }
    AppMethodBeat.o(61808);
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.fts.ui.FTSChattingConvUI
 * JD-Core Version:    0.7.0.1
 */