package com.tencent.mm.plugin.fts.ui;

import android.app.Activity;
import android.app.ActivityOptions;
import android.content.Intent;
import android.content.res.Resources;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.util.Pair;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.TextView;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.RecyclerView.a;
import androidx.recyclerview.widget.RecyclerView.v;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.k;
import com.tencent.mm.model.ab;
import com.tencent.mm.model.aq;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.storage.ah;
import com.tencent.mm.storage.as;
import com.tencent.mm.storage.bv;
import com.tencent.mm.ui.ar;
import com.tencent.mm.ui.search.FTSEditTextView;
import java.util.List;

@k
public class FTSChattingConvUI
  extends FTSBaseUI
  implements View.OnClickListener
{
  private String BIN;
  private View BNj;
  private g BNk;
  private as contact;
  
  private static void am(String paramString, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(111905);
    paramString = String.format("%s,%d,%d,%d,%d", new Object[] { paramString, Integer.valueOf(paramInt1), Integer.valueOf(5), Integer.valueOf(paramInt2), Integer.valueOf(0) });
    Log.v("MicroMsg.FTS.FTSChattingConvUI", "reportClick: %s", new Object[] { paramString });
    com.tencent.mm.plugin.report.service.h.IzE.kvStat(13234, paramString);
    AppMethodBeat.o(111905);
  }
  
  private void rE(int paramInt)
  {
    AppMethodBeat.i(111901);
    if (ab.PO(this.BIN))
    {
      ah localah = ((com.tencent.mm.plugin.chatroom.a.b)com.tencent.mm.kernel.h.ae(com.tencent.mm.plugin.chatroom.a.b.class)).bbV().Rx(this.BIN);
      if (localah.bjL() != null)
      {
        if (paramInt == 0)
        {
          com.tencent.mm.plugin.report.service.h.IzE.a(14569, new Object[] { Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(1), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(localah.bjL().size()), Integer.valueOf(1) });
          AppMethodBeat.o(111901);
          return;
        }
        com.tencent.mm.plugin.report.service.h.IzE.a(14569, new Object[] { Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(1), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(localah.bjL().size()), Integer.valueOf(1) });
      }
      AppMethodBeat.o(111901);
      return;
    }
    if (paramInt == 0)
    {
      com.tencent.mm.plugin.report.service.h.IzE.a(14569, new Object[] { Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(1), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0) });
      AppMethodBeat.o(111901);
      return;
    }
    com.tencent.mm.plugin.report.service.h.IzE.a(14569, new Object[] { Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(1), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0) });
    AppMethodBeat.o(111901);
  }
  
  protected final d a(e parame)
  {
    AppMethodBeat.i(111895);
    if (this.BNk == null) {
      this.BNk = new g(parame, this.BIN);
    }
    parame = this.BNk;
    AppMethodBeat.o(111895);
    return parame;
  }
  
  public final void a(com.tencent.mm.plugin.fts.a.d.a.a parama, boolean paramBoolean)
  {
    AppMethodBeat.i(111896);
    if (ab.PO(this.BIN))
    {
      am(this.query, 10, parama.position + 1);
      AppMethodBeat.o(111896);
      return;
    }
    am(this.query, 11, parama.position + 1);
    AppMethodBeat.o(111896);
  }
  
  protected final void aIi(String paramString)
  {
    int i = 1;
    AppMethodBeat.i(111902);
    super.aIi(paramString);
    boolean bool = ab.PO(this.BIN);
    paramString = com.tencent.mm.plugin.report.service.h.IzE;
    if (bool) {}
    for (;;)
    {
      paramString.a(14569, new Object[] { Integer.valueOf(0), Integer.valueOf(1), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(i) });
      AppMethodBeat.o(111902);
      return;
      i = 0;
    }
  }
  
  protected final void erD()
  {
    AppMethodBeat.i(111894);
    this.BIN = getIntent().getStringExtra("detail_username");
    this.contact = ((com.tencent.mm.plugin.messenger.foundation.a.n)com.tencent.mm.kernel.h.ae(com.tencent.mm.plugin.messenger.foundation.a.n.class)).bbL().RG(this.BIN);
    Log.i("MicroMsg.FTS.FTSChattingConvUI", "initSearchData conversation=%s", new Object[] { this.BIN });
    AppMethodBeat.o(111894);
  }
  
  protected final void erF()
  {
    AppMethodBeat.i(111900);
    super.erF();
    this.BNj.setVisibility(8);
    AppMethodBeat.o(111900);
  }
  
  protected final void erG()
  {
    AppMethodBeat.i(111898);
    super.erG();
    this.BNj.setVisibility(8);
    AppMethodBeat.o(111898);
  }
  
  protected final void erH()
  {
    AppMethodBeat.i(111899);
    super.erH();
    this.BNj.setVisibility(8);
    AppMethodBeat.o(111899);
  }
  
  protected final void erI()
  {
    AppMethodBeat.i(111897);
    super.erI();
    this.BNj.setVisibility(0);
    AppMethodBeat.o(111897);
  }
  
  public int getLayoutId()
  {
    return o.e.fts_conv_detail_ui;
  }
  
  public void initView()
  {
    AppMethodBeat.i(111892);
    super.initView();
    this.BNj = findViewById(o.d.search_record_layout);
    this.BNj.setVisibility(0);
    RecyclerView localRecyclerView = (RecyclerView)findViewById(o.d.gird_title_view);
    getContext();
    localRecyclerView.setLayoutManager(new GridLayoutManager(3));
    localRecyclerView.a(new FTSChattingConvUI.1(this));
    localRecyclerView.setAdapter(new a());
    AppMethodBeat.o(111892);
  }
  
  public void onClick(View paramView)
  {
    Intent localIntent2 = null;
    Object localObject1 = null;
    Object localObject2 = null;
    Intent localIntent1 = null;
    AppMethodBeat.i(111904);
    com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
    localb.bn(paramView);
    com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/fts/ui/FTSChattingConvUI", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.aFi());
    if (!(paramView instanceof TextView))
    {
      com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/fts/ui/FTSChattingConvUI", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
      AppMethodBeat.o(111904);
      return;
    }
    int i = ((Integer)paramView.getTag()).intValue();
    if (ab.PO(this.BIN))
    {
      if (i != 0) {
        break label198;
      }
      Log.i("MicroMsg.FTS.FTSChattingConvUI", "onSearchMemberDetail");
      paramView = new Intent();
      paramView.putExtra("from_scene", 1);
      paramView.putExtra("RoomInfo_Id", this.BIN);
      paramView.putExtra("title", getResources().getString(o.g.search_by_chatroom_member));
      com.tencent.mm.by.c.f(this, "com.tencent.mm.chatroom.ui.SeeMemberRecordUI", paramView);
    }
    for (;;)
    {
      com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/fts/ui/FTSChattingConvUI", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
      AppMethodBeat.o(111904);
      return;
      i += 1;
      break;
      label198:
      if (i == 1)
      {
        Log.i("MicroMsg.FTS.FTSChattingConvUI", "onSearchDateDetail");
        paramView = new Intent();
        paramView.putExtra("detail_username", this.BIN);
        com.tencent.mm.by.c.f(this, "com.tencent.mm.chatroom.ui.SelectDateUI", paramView);
        rE(0);
      }
      else
      {
        if (i != 2) {
          break label304;
        }
        Log.i("MicroMsg.FTS.FTSChattingConvUI", "onSeeImageVideoHistory");
        paramView = new Intent();
        paramView.putExtra("kintent_talker", this.BIN);
        paramView.putExtra("key_media_type", 1);
        com.tencent.mm.by.c.f(this, "com.tencent.mm.ui.chatting.gallery.MediaHistoryGalleryUI", paramView);
        rE(1);
      }
    }
    label304:
    if (i == 3)
    {
      Log.i("MicroMsg.FTS.FTSChattingConvUI", "onSeeFileHistory");
      localIntent1 = new Intent();
      localIntent1.putExtra("kintent_talker", this.BIN);
      localIntent1.putExtra("key_media_type", 2);
      if ((Build.VERSION.SDK_INT < 21) || (ar.isDarkMode())) {
        break label733;
      }
    }
    label733:
    for (paramView = ActivityOptions.makeSceneTransitionAnimation(this, new Pair[0]).toBundle();; paramView = null)
    {
      com.tencent.mm.by.c.c(this, "com.tencent.mm.ui.chatting.gallery.MediaHistoryListUI", localIntent1, paramView);
      break;
      if (i == 4)
      {
        Log.i("MicroMsg.FTS.FTSChattingConvUI", "onSeeUrlHistory");
        localIntent2 = new Intent();
        localIntent2.putExtra("kintent_talker", this.BIN);
        localIntent2.putExtra("key_media_type", 3);
        paramView = localIntent1;
        if (Build.VERSION.SDK_INT >= 21)
        {
          paramView = localIntent1;
          if (!ar.isDarkMode()) {
            paramView = ActivityOptions.makeSceneTransitionAnimation(this, new Pair[0]).toBundle();
          }
        }
        com.tencent.mm.by.c.c(this, "com.tencent.mm.ui.chatting.gallery.MediaHistoryListUI", localIntent2, paramView);
        break;
      }
      if (i == 5)
      {
        Log.i("MicroMsg.FTS.FTSChattingConvUI", "onSeeUrlHistory");
        localIntent1 = new Intent();
        localIntent1.putExtra("kintent_talker", this.BIN);
        localIntent1.putExtra("key_media_type", 4);
        paramView = localIntent2;
        if (Build.VERSION.SDK_INT >= 21)
        {
          paramView = localIntent2;
          if (!ar.isDarkMode()) {
            paramView = ActivityOptions.makeSceneTransitionAnimation(this, new Pair[0]).toBundle();
          }
        }
        com.tencent.mm.by.c.c(this, "com.tencent.mm.ui.chatting.gallery.MediaHistoryListUI", localIntent1, paramView);
        break;
      }
      if (i == 6)
      {
        Log.i("MicroMsg.FTS.FTSChattingConvUI", "onSeePayHistory");
        localIntent1 = new Intent();
        localIntent1.putExtra("kintent_talker", this.BIN);
        localIntent1.putExtra("key_media_type", 5);
        paramView = localObject1;
        if (Build.VERSION.SDK_INT >= 21)
        {
          paramView = localObject1;
          if (!ar.isDarkMode()) {
            paramView = ActivityOptions.makeSceneTransitionAnimation(this, new Pair[0]).toBundle();
          }
        }
        com.tencent.mm.by.c.c(this, "com.tencent.mm.ui.chatting.gallery.MediaHistoryListUI", localIntent1, paramView);
        break;
      }
      if (i != 7) {
        break;
      }
      Log.i("MicroMsg.FTS.FTSChattingConvUI", "onSeeAppBrandHistory");
      localIntent1 = new Intent();
      localIntent1.putExtra("kintent_talker", this.BIN);
      localIntent1.putExtra("key_media_type", 6);
      paramView = localObject2;
      if (Build.VERSION.SDK_INT >= 21)
      {
        paramView = localObject2;
        if (!ar.isDarkMode()) {
          paramView = ActivityOptions.makeSceneTransitionAnimation(this, new Pair[0]).toBundle();
        }
      }
      com.tencent.mm.by.c.c(this, "com.tencent.mm.ui.chatting.gallery.MediaHistoryListUI", localIntent1, paramView);
      break;
    }
  }
  
  public void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(111891);
    super.onCreate(paramBundle);
    initView();
    paramBundle = ((com.tencent.mm.plugin.fts.a.n)com.tencent.mm.kernel.h.ag(com.tencent.mm.plugin.fts.a.n.class)).getFTSImageLoader();
    if (paramBundle != null) {
      paramBundle.eqB();
    }
    AppMethodBeat.o(111891);
  }
  
  public void onDestroy()
  {
    AppMethodBeat.i(111903);
    super.onDestroy();
    this.BNk.finish();
    com.tencent.mm.plugin.fts.a.d.c localc = ((com.tencent.mm.plugin.fts.a.n)com.tencent.mm.kernel.h.ag(com.tencent.mm.plugin.fts.a.n.class)).getFTSImageLoader();
    if (localc != null) {
      localc.eqz();
    }
    AppMethodBeat.o(111903);
  }
  
  public void onResume()
  {
    AppMethodBeat.i(111893);
    super.onResume();
    this.BNj.postDelayed(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(111886);
        FTSChattingConvUI.this.BMN.getFtsEditText().aDU();
        FTSChattingConvUI.this.BMN.getFtsEditText().aDT();
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
  
  final class a
    extends RecyclerView.a<FTSChattingConvUI.b>
  {
    String[] BNm;
    
    a()
    {
      AppMethodBeat.i(111887);
      if (!ab.PO(FTSChattingConvUI.a(FTSChattingConvUI.this)))
      {
        this.BNm = new String[7];
        this.BNm[0] = FTSChattingConvUI.this.getResources().getString(o.g.search_chatroom_date);
        this.BNm[1] = FTSChattingConvUI.this.getResources().getString(o.g.search_chatroom_image_or_video);
        this.BNm[2] = FTSChattingConvUI.this.getResources().getString(o.g.search_chatroom_file);
        this.BNm[3] = FTSChattingConvUI.this.getResources().getString(o.g.search_chatroom_url);
        this.BNm[4] = FTSChattingConvUI.this.getResources().getString(o.g.search_chatroom_music);
        this.BNm[5] = FTSChattingConvUI.this.getResources().getString(o.g.search_chatroom_pay);
        this.BNm[6] = FTSChattingConvUI.this.getResources().getString(o.g.search_chatroom_appbrand);
        AppMethodBeat.o(111887);
        return;
      }
      this.BNm = new String[8];
      this.BNm[0] = FTSChattingConvUI.this.getResources().getString(o.g.search_chatroom_member);
      this.BNm[1] = FTSChattingConvUI.this.getResources().getString(o.g.search_chatroom_date);
      this.BNm[2] = FTSChattingConvUI.this.getResources().getString(o.g.search_chatroom_image_or_video);
      this.BNm[3] = FTSChattingConvUI.this.getResources().getString(o.g.search_chatroom_file);
      this.BNm[4] = FTSChattingConvUI.this.getResources().getString(o.g.search_chatroom_url);
      this.BNm[5] = FTSChattingConvUI.this.getResources().getString(o.g.search_chatroom_music);
      this.BNm[6] = FTSChattingConvUI.this.getResources().getString(o.g.search_chatroom_pay);
      this.BNm[7] = FTSChattingConvUI.this.getResources().getString(o.g.search_chatroom_appbrand);
      AppMethodBeat.o(111887);
    }
    
    public final int getItemCount()
    {
      return this.BNm.length;
    }
  }
  
  final class b
    extends RecyclerView.v
  {
    TextView bFR;
    
    public b(View paramView)
    {
      super();
      AppMethodBeat.i(111890);
      this.bFR = ((TextView)paramView.findViewById(o.d.title));
      this.bFR.setOnClickListener(FTSChattingConvUI.this);
      AppMethodBeat.o(111890);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.fts.ui.FTSChattingConvUI
 * JD-Core Version:    0.7.0.1
 */