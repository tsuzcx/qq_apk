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
import com.tencent.mm.model.aj;
import com.tencent.mm.plugin.fts.a.n;
import com.tencent.mm.plugin.messenger.foundation.a.k;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.storage.af;
import com.tencent.mm.storage.bg;
import com.tencent.mm.ui.ai;
import com.tencent.mm.ui.search.FTSEditTextView;
import java.util.List;

@i
public class FTSChattingConvUI
  extends FTSBaseUI
  implements View.OnClickListener
{
  private af contact;
  private String rpH;
  private View rtL;
  private f rtM;
  
  private static void ae(String paramString, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(111905);
    paramString = String.format("%s,%d,%d,%d,%d", new Object[] { paramString, Integer.valueOf(paramInt1), Integer.valueOf(5), Integer.valueOf(paramInt2), Integer.valueOf(0) });
    ad.v("MicroMsg.FTS.FTSChattingConvUI", "reportClick: %s", new Object[] { paramString });
    h.vKh.kvStat(13234, paramString);
    AppMethodBeat.o(111905);
  }
  
  private void lI(int paramInt)
  {
    AppMethodBeat.i(111901);
    if (com.tencent.mm.model.w.sl(this.rpH))
    {
      com.tencent.mm.storage.w localw = ((com.tencent.mm.plugin.chatroom.a.c)g.ab(com.tencent.mm.plugin.chatroom.a.c.class)).apV().tI(this.rpH);
      if (localw.awt() != null)
      {
        if (paramInt == 0)
        {
          h.vKh.f(14569, new Object[] { Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(1), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(localw.awt().size()), Integer.valueOf(1) });
          AppMethodBeat.o(111901);
          return;
        }
        h.vKh.f(14569, new Object[] { Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(1), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(localw.awt().size()), Integer.valueOf(1) });
      }
      AppMethodBeat.o(111901);
      return;
    }
    if (paramInt == 0)
    {
      h.vKh.f(14569, new Object[] { Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(1), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0) });
      AppMethodBeat.o(111901);
      return;
    }
    h.vKh.f(14569, new Object[] { Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(1), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0) });
    AppMethodBeat.o(111901);
  }
  
  protected final d a(e parame)
  {
    AppMethodBeat.i(111895);
    if (this.rtM == null) {
      this.rtM = new f(parame, this.rpH);
    }
    parame = this.rtM;
    AppMethodBeat.o(111895);
    return parame;
  }
  
  public final void a(com.tencent.mm.plugin.fts.a.d.a.a parama, boolean paramBoolean)
  {
    AppMethodBeat.i(111896);
    if (com.tencent.mm.model.w.sl(this.rpH))
    {
      ae(this.query, 10, parama.position + 1);
      AppMethodBeat.o(111896);
      return;
    }
    ae(this.query, 11, parama.position + 1);
    AppMethodBeat.o(111896);
  }
  
  protected final void abu(String paramString)
  {
    int i = 1;
    AppMethodBeat.i(111902);
    super.abu(paramString);
    boolean bool = com.tencent.mm.model.w.sl(this.rpH);
    paramString = h.vKh;
    if (bool) {}
    for (;;)
    {
      paramString.f(14569, new Object[] { Integer.valueOf(0), Integer.valueOf(1), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(i) });
      AppMethodBeat.o(111902);
      return;
      i = 0;
    }
  }
  
  protected final void cxR()
  {
    AppMethodBeat.i(111894);
    this.rpH = getIntent().getStringExtra("detail_username");
    this.contact = ((k)g.ab(k.class)).apM().aHY(this.rpH);
    ad.i("MicroMsg.FTS.FTSChattingConvUI", "initSearchData conversation=%s", new Object[] { this.rpH });
    AppMethodBeat.o(111894);
  }
  
  protected final void cxS()
  {
    AppMethodBeat.i(111900);
    super.cxS();
    this.rtL.setVisibility(8);
    AppMethodBeat.o(111900);
  }
  
  protected final void cxT()
  {
    AppMethodBeat.i(111898);
    super.cxT();
    this.rtL.setVisibility(8);
    AppMethodBeat.o(111898);
  }
  
  protected final void cxU()
  {
    AppMethodBeat.i(111899);
    super.cxU();
    this.rtL.setVisibility(8);
    AppMethodBeat.o(111899);
  }
  
  protected final void cxV()
  {
    AppMethodBeat.i(111897);
    super.cxV();
    this.rtL.setVisibility(0);
    AppMethodBeat.o(111897);
  }
  
  public int getLayoutId()
  {
    return 2131494197;
  }
  
  public void initView()
  {
    AppMethodBeat.i(111892);
    super.initView();
    this.rtL = findViewById(2131304441);
    this.rtL.setVisibility(0);
    RecyclerView localRecyclerView = (RecyclerView)findViewById(2131300591);
    getContext();
    localRecyclerView.setLayoutManager(new GridLayoutManager(3));
    localRecyclerView.a(new FTSChattingConvUI.1(this));
    localRecyclerView.setAdapter(new FTSChattingConvUI.a(this));
    AppMethodBeat.o(111892);
  }
  
  public void onClick(View paramView)
  {
    Intent localIntent2 = null;
    Object localObject1 = null;
    Object localObject2 = null;
    Intent localIntent1 = null;
    AppMethodBeat.i(111904);
    if (!(paramView instanceof TextView))
    {
      AppMethodBeat.o(111904);
      return;
    }
    int i = ((Integer)paramView.getTag()).intValue();
    if (com.tencent.mm.model.w.sl(this.rpH)) {}
    while (i == 0)
    {
      ad.i("MicroMsg.FTS.FTSChattingConvUI", "onSearchMemberDetail");
      paramView = new Intent();
      paramView.putExtra("from_scene", 1);
      paramView.putExtra("RoomInfo_Id", this.rpH);
      paramView.putExtra("title", getResources().getString(2131762903));
      com.tencent.mm.bs.d.e(this, "com.tencent.mm.chatroom.ui.SeeMemberRecordUI", paramView);
      AppMethodBeat.o(111904);
      return;
      i += 1;
    }
    if (i == 1)
    {
      ad.i("MicroMsg.FTS.FTSChattingConvUI", "onSearchDateDetail");
      paramView = new Intent();
      paramView.putExtra("detail_username", this.rpH);
      com.tencent.mm.bs.d.e(this, "com.tencent.mm.chatroom.ui.SelectDateUI", paramView);
      lI(0);
      AppMethodBeat.o(111904);
      return;
    }
    if (i == 2)
    {
      ad.i("MicroMsg.FTS.FTSChattingConvUI", "onSeeImageVideoHistory");
      paramView = new Intent();
      paramView.putExtra("kintent_talker", this.rpH);
      paramView.putExtra("key_media_type", 1);
      com.tencent.mm.bs.d.e(this, "com.tencent.mm.ui.chatting.gallery.MediaHistoryGalleryUI", paramView);
      lI(1);
      AppMethodBeat.o(111904);
      return;
    }
    if (i == 3)
    {
      ad.i("MicroMsg.FTS.FTSChattingConvUI", "onSeeFileHistory");
      localIntent1 = new Intent();
      localIntent1.putExtra("kintent_talker", this.rpH);
      localIntent1.putExtra("key_media_type", 2);
      if ((Build.VERSION.SDK_INT < 21) || (ai.Eq())) {
        break label685;
      }
    }
    label685:
    for (paramView = ActivityOptions.makeSceneTransitionAnimation(this, new Pair[0]).toBundle();; paramView = null)
    {
      com.tencent.mm.bs.d.c(this, "com.tencent.mm.ui.chatting.gallery.MediaHistoryListUI", localIntent1, paramView);
      AppMethodBeat.o(111904);
      return;
      if (i == 4)
      {
        ad.i("MicroMsg.FTS.FTSChattingConvUI", "onSeeUrlHistory");
        localIntent2 = new Intent();
        localIntent2.putExtra("kintent_talker", this.rpH);
        localIntent2.putExtra("key_media_type", 3);
        paramView = localIntent1;
        if (Build.VERSION.SDK_INT >= 21)
        {
          paramView = localIntent1;
          if (!ai.Eq()) {
            paramView = ActivityOptions.makeSceneTransitionAnimation(this, new Pair[0]).toBundle();
          }
        }
        com.tencent.mm.bs.d.c(this, "com.tencent.mm.ui.chatting.gallery.MediaHistoryListUI", localIntent2, paramView);
        AppMethodBeat.o(111904);
        return;
      }
      if (i == 5)
      {
        ad.i("MicroMsg.FTS.FTSChattingConvUI", "onSeeUrlHistory");
        localIntent1 = new Intent();
        localIntent1.putExtra("kintent_talker", this.rpH);
        localIntent1.putExtra("key_media_type", 4);
        paramView = localIntent2;
        if (Build.VERSION.SDK_INT >= 21)
        {
          paramView = localIntent2;
          if (!ai.Eq()) {
            paramView = ActivityOptions.makeSceneTransitionAnimation(this, new Pair[0]).toBundle();
          }
        }
        com.tencent.mm.bs.d.c(this, "com.tencent.mm.ui.chatting.gallery.MediaHistoryListUI", localIntent1, paramView);
        AppMethodBeat.o(111904);
        return;
      }
      if (i == 6)
      {
        ad.i("MicroMsg.FTS.FTSChattingConvUI", "onSeePayHistory");
        localIntent1 = new Intent();
        localIntent1.putExtra("kintent_talker", this.rpH);
        localIntent1.putExtra("key_media_type", 5);
        paramView = localObject1;
        if (Build.VERSION.SDK_INT >= 21)
        {
          paramView = localObject1;
          if (!ai.Eq()) {
            paramView = ActivityOptions.makeSceneTransitionAnimation(this, new Pair[0]).toBundle();
          }
        }
        com.tencent.mm.bs.d.c(this, "com.tencent.mm.ui.chatting.gallery.MediaHistoryListUI", localIntent1, paramView);
        AppMethodBeat.o(111904);
        return;
      }
      if (i == 7)
      {
        ad.i("MicroMsg.FTS.FTSChattingConvUI", "onSeeAppBrandHistory");
        localIntent1 = new Intent();
        localIntent1.putExtra("kintent_talker", this.rpH);
        localIntent1.putExtra("key_media_type", 6);
        paramView = localObject2;
        if (Build.VERSION.SDK_INT >= 21)
        {
          paramView = localObject2;
          if (!ai.Eq()) {
            paramView = ActivityOptions.makeSceneTransitionAnimation(this, new Pair[0]).toBundle();
          }
        }
        com.tencent.mm.bs.d.c(this, "com.tencent.mm.ui.chatting.gallery.MediaHistoryListUI", localIntent1, paramView);
      }
      AppMethodBeat.o(111904);
      return;
    }
  }
  
  public void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(111891);
    super.onCreate(paramBundle);
    initView();
    paramBundle = ((n)g.ad(n.class)).getFTSImageLoader();
    if (paramBundle != null) {
      paramBundle.cwY();
    }
    AppMethodBeat.o(111891);
  }
  
  public void onDestroy()
  {
    AppMethodBeat.i(111903);
    super.onDestroy();
    this.rtM.finish();
    com.tencent.mm.plugin.fts.a.d.c localc = ((n)g.ad(n.class)).getFTSImageLoader();
    if (localc != null) {
      localc.cwW();
    }
    AppMethodBeat.o(111903);
  }
  
  public void onResume()
  {
    AppMethodBeat.i(111893);
    super.onResume();
    this.rtL.postDelayed(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(111886);
        FTSChattingConvUI.this.rtD.getFtsEditText().fdj();
        FTSChattingConvUI.this.rtD.getFtsEditText().fdi();
        AppMethodBeat.o(111886);
      }
    }, 128L);
    AppMethodBeat.o(111893);
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.fts.ui.FTSChattingConvUI
 * JD-Core Version:    0.7.0.1
 */