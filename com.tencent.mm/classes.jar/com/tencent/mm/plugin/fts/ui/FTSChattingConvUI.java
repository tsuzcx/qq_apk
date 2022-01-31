package com.tencent.mm.plugin.fts.ui;

import android.app.ActivityOptions;
import android.content.Intent;
import android.content.res.Resources;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Pair;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.TextView;
import com.tencent.mm.h.c.ao;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.af;
import com.tencent.mm.plugin.fts.a.d.a.a;
import com.tencent.mm.plugin.fts.a.n;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.sdk.platformtools.y;
import com.tencent.mm.storage.ad;
import com.tencent.mm.storage.bd;
import com.tencent.mm.storage.u;
import com.tencent.mm.ui.MMActivity;
import java.util.List;

@com.tencent.mm.kernel.j
public class FTSChattingConvUI
  extends FTSBaseUI
  implements View.OnClickListener
{
  private ad dnp;
  private View kBe;
  private f kBf;
  private String kwY;
  
  private static void R(String paramString, int paramInt1, int paramInt2)
  {
    paramString = String.format("%s,%d,%d,%d,%d", new Object[] { paramString, Integer.valueOf(paramInt1), Integer.valueOf(5), Integer.valueOf(paramInt2), Integer.valueOf(0) });
    y.v("MicroMsg.FTS.FTSChattingConvUI", "reportClick: %s", new Object[] { paramString });
    h.nFQ.aC(13234, paramString);
  }
  
  private boolean aWi()
  {
    return (this.dnp != null) && (ad.aaU(this.dnp.field_username));
  }
  
  private void jdMethod_if(int paramInt)
  {
    if (com.tencent.mm.model.s.gZ(this.kwY))
    {
      u localu = ((com.tencent.mm.plugin.chatroom.a.c)g.r(com.tencent.mm.plugin.chatroom.a.c.class)).FF().io(this.kwY);
      if (localu.MN() != null)
      {
        if (paramInt == 0) {
          h.nFQ.f(14569, new Object[] { Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(1), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(localu.MN().size()), Integer.valueOf(1) });
        }
      }
      else {
        return;
      }
      h.nFQ.f(14569, new Object[] { Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(1), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(localu.MN().size()), Integer.valueOf(1) });
      return;
    }
    if (paramInt == 0)
    {
      h.nFQ.f(14569, new Object[] { Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(1), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0) });
      return;
    }
    h.nFQ.f(14569, new Object[] { Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(1), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0) });
  }
  
  protected final void Ek(String paramString)
  {
    int i = 1;
    super.Ek(paramString);
    boolean bool = com.tencent.mm.model.s.gZ(this.kwY);
    paramString = h.nFQ;
    if (bool) {}
    for (;;)
    {
      paramString.f(14569, new Object[] { Integer.valueOf(0), Integer.valueOf(1), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(i) });
      return;
      i = 0;
    }
  }
  
  protected final d a(e parame)
  {
    if (this.kBf == null) {
      this.kBf = new f(parame, this.kwY);
    }
    return this.kBf;
  }
  
  public final void a(a parama)
  {
    if (com.tencent.mm.model.s.gZ(this.kwY))
    {
      R(this.bVk, 10, parama.position + 1);
      return;
    }
    R(this.bVk, 11, parama.position + 1);
  }
  
  protected final void aWa()
  {
    this.kwY = getIntent().getStringExtra("detail_username");
    this.dnp = ((com.tencent.mm.plugin.messenger.foundation.a.j)g.r(com.tencent.mm.plugin.messenger.foundation.a.j.class)).Fw().abl(this.kwY);
    y.i("MicroMsg.FTS.FTSChattingConvUI", "initSearchData conversation=%s", new Object[] { this.kwY });
  }
  
  protected final void aWc()
  {
    super.aWc();
    this.kBe.setVisibility(8);
  }
  
  protected final void aWd()
  {
    super.aWd();
    this.kBe.setVisibility(8);
  }
  
  protected final void aWe()
  {
    super.aWe();
    this.kBe.setVisibility(8);
  }
  
  protected final void aWf()
  {
    super.aWf();
    this.kBe.setVisibility(0);
  }
  
  protected final int getLayoutId()
  {
    return n.e.fts_detail_ui;
  }
  
  protected final void initView()
  {
    super.initView();
    this.kBe = findViewById(n.d.search_record_layout);
    this.kBe.setVisibility(0);
    RecyclerView localRecyclerView = (RecyclerView)findViewById(n.d.gird_title_view);
    AppCompatActivity localAppCompatActivity = this.mController.uMN;
    if (aWi()) {}
    for (int i = 2;; i = 3)
    {
      localRecyclerView.setLayoutManager(new GridLayoutManager(i));
      localRecyclerView.a(new FTSChattingConvUI.1(this));
      localRecyclerView.setAdapter(new FTSChattingConvUI.a(this));
      return;
    }
  }
  
  public void onClick(View paramView)
  {
    Intent localIntent2 = null;
    Object localObject = null;
    Intent localIntent1 = null;
    if (!(paramView instanceof TextView)) {
      return;
    }
    int i = ((Integer)paramView.getTag()).intValue();
    if (com.tencent.mm.model.s.gZ(this.kwY)) {}
    while (i == 0)
    {
      y.i("MicroMsg.FTS.FTSChattingConvUI", "onSearchMemberDetail");
      paramView = new Intent();
      paramView.putExtra("from_scene", 1);
      paramView.putExtra("RoomInfo_Id", this.kwY);
      paramView.putExtra("title", getResources().getString(n.g.search_by_chatroom_member));
      com.tencent.mm.br.d.e(this, "com.tencent.mm.chatroom.ui.SeeMemberRecordUI", paramView);
      return;
      i += 1;
    }
    if (i == 1)
    {
      y.i("MicroMsg.FTS.FTSChattingConvUI", "onSearchDateDetail");
      paramView = new Intent();
      paramView.putExtra("detail_username", this.kwY);
      com.tencent.mm.br.d.e(this, "com.tencent.mm.chatroom.ui.SelectDateUI", paramView);
      jdMethod_if(0);
      return;
    }
    if (i == 2)
    {
      y.i("MicroMsg.FTS.FTSChattingConvUI", "onSeeImageVideoHistory");
      paramView = new Intent();
      paramView.putExtra("kintent_talker", this.kwY);
      paramView.putExtra("key_media_type", 1);
      com.tencent.mm.br.d.e(this, "com.tencent.mm.ui.chatting.gallery.MediaHistoryGalleryUI", paramView);
      jdMethod_if(1);
      return;
    }
    if (i == 3)
    {
      y.i("MicroMsg.FTS.FTSChattingConvUI", "onSeeFileHistory");
      localIntent1 = new Intent();
      localIntent1.putExtra("kintent_talker", this.kwY);
      localIntent1.putExtra("key_media_type", 2);
      if (Build.VERSION.SDK_INT < 21) {
        break label515;
      }
    }
    label515:
    for (paramView = ActivityOptions.makeSceneTransitionAnimation(this, new Pair[0]).toBundle();; paramView = null)
    {
      com.tencent.mm.br.d.c(this, "com.tencent.mm.ui.chatting.gallery.MediaHistoryListUI", localIntent1, paramView);
      return;
      if (i == 4)
      {
        y.i("MicroMsg.FTS.FTSChattingConvUI", "onSeeUrlHistory");
        localIntent2 = new Intent();
        localIntent2.putExtra("kintent_talker", this.kwY);
        localIntent2.putExtra("key_media_type", 3);
        paramView = localIntent1;
        if (Build.VERSION.SDK_INT >= 21) {
          paramView = ActivityOptions.makeSceneTransitionAnimation(this, new Pair[0]).toBundle();
        }
        com.tencent.mm.br.d.c(this, "com.tencent.mm.ui.chatting.gallery.MediaHistoryListUI", localIntent2, paramView);
        return;
      }
      if (i == 5)
      {
        y.i("MicroMsg.FTS.FTSChattingConvUI", "onSeeUrlHistory");
        localIntent1 = new Intent();
        localIntent1.putExtra("kintent_talker", this.kwY);
        localIntent1.putExtra("key_media_type", 4);
        paramView = localIntent2;
        if (Build.VERSION.SDK_INT >= 21) {
          paramView = ActivityOptions.makeSceneTransitionAnimation(this, new Pair[0]).toBundle();
        }
        com.tencent.mm.br.d.c(this, "com.tencent.mm.ui.chatting.gallery.MediaHistoryListUI", localIntent1, paramView);
        return;
      }
      if (i != 6) {
        break;
      }
      y.i("MicroMsg.FTS.FTSChattingConvUI", "onSeePayHistory");
      localIntent1 = new Intent();
      localIntent1.putExtra("kintent_talker", this.kwY);
      localIntent1.putExtra("key_media_type", 5);
      paramView = localObject;
      if (Build.VERSION.SDK_INT >= 21) {
        paramView = ActivityOptions.makeSceneTransitionAnimation(this, new Pair[0]).toBundle();
      }
      com.tencent.mm.br.d.c(this, "com.tencent.mm.ui.chatting.gallery.MediaHistoryListUI", localIntent1, paramView);
      return;
    }
  }
  
  public void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    initView();
    paramBundle = ((n)g.t(n.class)).getFTSImageLoader();
    if (paramBundle != null) {
      paramBundle.aVm();
    }
  }
  
  protected void onDestroy()
  {
    super.onDestroy();
    this.kBf.finish();
    com.tencent.mm.plugin.fts.a.d.c localc = ((n)g.t(n.class)).getFTSImageLoader();
    if (localc != null) {
      localc.aVk();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.fts.ui.FTSChattingConvUI
 * JD-Core Version:    0.7.0.1
 */