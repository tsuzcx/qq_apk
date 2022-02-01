package com.tencent.mm.plugin.fts.ui;

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
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.k;
import com.tencent.mm.model.ar;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.aj;
import com.tencent.mm.storage.au;
import com.tencent.mm.storage.bx;
import com.tencent.mm.ui.aw;
import com.tencent.mm.ui.search.FTSEditTextView;
import com.tencent.mm.ui.search.FTSSearchView;
import java.util.List;

@k
public class FTSChattingConvUI
  extends FTSBaseUI
  implements View.OnClickListener
{
  private String Htv;
  private boolean HyA = true;
  private aj HyB;
  private int HyC;
  private g HyD;
  private View Hyz;
  private au contact;
  private boolean lzR = false;
  
  private static void at(String paramString, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(111905);
    paramString = String.format("%s,%d,%d,%d,%d", new Object[] { paramString, Integer.valueOf(paramInt1), Integer.valueOf(5), Integer.valueOf(paramInt2), Integer.valueOf(0) });
    Log.v("MicroMsg.FTS.FTSChattingConvUI", "reportClick: %s", new Object[] { paramString });
    com.tencent.mm.plugin.report.service.h.OAn.kvStat(13234, paramString);
    AppMethodBeat.o(111905);
  }
  
  private void rG(int paramInt)
  {
    int i = 2;
    AppMethodBeat.i(111901);
    if (au.bwE(this.Htv))
    {
      localObject = ((com.tencent.mm.plugin.chatroom.a.b)com.tencent.mm.kernel.h.ax(com.tencent.mm.plugin.chatroom.a.b.class)).bzK().Jv(this.Htv);
      com.tencent.mm.plugin.report.service.h localh;
      if (((aj)localObject).bHw() != null)
      {
        if (paramInt == 0)
        {
          localh = com.tencent.mm.plugin.report.service.h.OAn;
          i = ((aj)localObject).bHw().size();
          if (this.lzR) {}
          for (paramInt = 2;; paramInt = 1)
          {
            localh.b(14569, new Object[] { Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(1), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(i), Integer.valueOf(paramInt) });
            AppMethodBeat.o(111901);
            return;
          }
        }
        localh = com.tencent.mm.plugin.report.service.h.OAn;
        paramInt = ((aj)localObject).bHw().size();
        if (!this.lzR) {
          break label272;
        }
      }
      for (;;)
      {
        localh.b(14569, new Object[] { Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(1), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(paramInt), Integer.valueOf(i) });
        AppMethodBeat.o(111901);
        return;
        label272:
        i = 1;
      }
    }
    if (paramInt == 0)
    {
      localObject = com.tencent.mm.plugin.report.service.h.OAn;
      if (this.lzR) {}
      for (;;)
      {
        ((com.tencent.mm.plugin.report.service.h)localObject).b(14569, new Object[] { Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(1), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(i) });
        AppMethodBeat.o(111901);
        return;
        i = 0;
      }
    }
    Object localObject = com.tencent.mm.plugin.report.service.h.OAn;
    if (this.lzR) {}
    for (;;)
    {
      ((com.tencent.mm.plugin.report.service.h)localObject).b(14569, new Object[] { Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(1), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(i) });
      AppMethodBeat.o(111901);
      return;
      i = 0;
    }
  }
  
  protected final d a(e parame)
  {
    AppMethodBeat.i(111895);
    if (this.HyD == null) {
      this.HyD = new g(parame, this.Htv);
    }
    parame = this.HyD;
    AppMethodBeat.o(111895);
    return parame;
  }
  
  public final void a(com.tencent.mm.plugin.fts.a.d.a.a parama, boolean paramBoolean)
  {
    AppMethodBeat.i(111896);
    if (au.bwE(this.Htv))
    {
      at(this.query, 10, parama.position + 1);
      AppMethodBeat.o(111896);
      return;
    }
    at(this.query, 11, parama.position + 1);
    AppMethodBeat.o(111896);
  }
  
  protected final void aEJ(String paramString)
  {
    AppMethodBeat.i(111902);
    super.aEJ(paramString);
    if (!Util.isNullOrNil(paramString)) {
      this.HyA = false;
    }
    if (au.bwE(this.Htv)) {}
    for (int i = 1;; i = 0)
    {
      if (this.lzR) {
        i = 2;
      }
      com.tencent.mm.plugin.report.service.h.OAn.b(14569, new Object[] { Integer.valueOf(0), Integer.valueOf(1), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(this.HyC), Integer.valueOf(i) });
      AppMethodBeat.o(111902);
      return;
    }
  }
  
  protected final void fyk()
  {
    AppMethodBeat.i(111894);
    this.Htv = getIntent().getStringExtra("detail_username");
    this.contact = ((com.tencent.mm.plugin.messenger.foundation.a.n)com.tencent.mm.kernel.h.ax(com.tencent.mm.plugin.messenger.foundation.a.n.class)).bzA().JE(this.Htv);
    this.lzR = getIntent().getBooleanExtra("detail_user_dismiss", false);
    Log.i("MicroMsg.FTS.FTSChattingConvUI", "initSearchData conversation=%s", new Object[] { this.Htv });
    AppMethodBeat.o(111894);
  }
  
  protected final void fyn()
  {
    AppMethodBeat.i(111897);
    super.fyn();
    this.Hyz.setVisibility(0);
    AppMethodBeat.o(111897);
  }
  
  protected final void fyo()
  {
    AppMethodBeat.i(111899);
    super.fyo();
    this.Hyz.setVisibility(8);
    AppMethodBeat.o(111899);
  }
  
  protected final void fyp()
  {
    AppMethodBeat.i(111898);
    super.fyp();
    this.Hyz.setVisibility(8);
    AppMethodBeat.o(111898);
  }
  
  protected final void fyq()
  {
    AppMethodBeat.i(111900);
    super.fyq();
    this.Hyz.setVisibility(8);
    AppMethodBeat.o(111900);
  }
  
  public int getLayoutId()
  {
    return p.e.fts_conv_detail_ui;
  }
  
  public void initView()
  {
    AppMethodBeat.i(111892);
    super.initView();
    if (au.bwE(this.Htv))
    {
      this.HyB = ((com.tencent.mm.plugin.chatroom.a.b)com.tencent.mm.kernel.h.ax(com.tencent.mm.plugin.chatroom.a.b.class)).bzK().Jv(this.Htv);
      if ((this.HyB != null) && (this.HyB.bHw() != null)) {
        this.HyC = this.HyB.bHw().size();
      }
    }
    this.Hyz = findViewById(p.d.search_record_layout);
    this.Hyz.setVisibility(0);
    RecyclerView localRecyclerView = (RecyclerView)findViewById(p.d.gird_title_view);
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
    com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
    localb.cH(paramView);
    com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/fts/ui/FTSChattingConvUI", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.aYj());
    if (!(paramView instanceof TextView))
    {
      com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/fts/ui/FTSChattingConvUI", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
      AppMethodBeat.o(111904);
      return;
    }
    this.HyA = false;
    int i = ((Integer)paramView.getTag()).intValue();
    if (au.bwE(this.Htv))
    {
      if (i != 0) {
        break label206;
      }
      Log.i("MicroMsg.FTS.FTSChattingConvUI", "onSearchMemberDetail");
      paramView = new Intent();
      paramView.putExtra("from_scene", 1);
      paramView.putExtra("RoomInfo_Id", this.Htv);
      paramView.putExtra("title", getResources().getString(p.g.search_by_chatroom_member));
      com.tencent.mm.br.c.g(this, "com.tencent.mm.chatroom.ui.SeeMemberRecordUI", paramView);
    }
    for (;;)
    {
      com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/fts/ui/FTSChattingConvUI", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
      AppMethodBeat.o(111904);
      return;
      i += 1;
      break;
      label206:
      if (i == 1)
      {
        Log.i("MicroMsg.FTS.FTSChattingConvUI", "onSearchDateDetail");
        paramView = new Intent();
        paramView.putExtra("detail_username", this.Htv);
        com.tencent.mm.br.c.g(this, "com.tencent.mm.chatroom.ui.SelectDateUI", paramView);
        rG(0);
      }
      else
      {
        if (i != 2) {
          break label312;
        }
        Log.i("MicroMsg.FTS.FTSChattingConvUI", "onSeeImageVideoHistory");
        paramView = new Intent();
        paramView.putExtra("kintent_talker", this.Htv);
        paramView.putExtra("key_media_type", 1);
        com.tencent.mm.br.c.g(this, "com.tencent.mm.ui.chatting.gallery.MediaHistoryGalleryUI", paramView);
        rG(1);
      }
    }
    label312:
    if (i == 3)
    {
      Log.i("MicroMsg.FTS.FTSChattingConvUI", "onSeeFileHistory");
      localIntent1 = new Intent();
      localIntent1.putExtra("kintent_talker", this.Htv);
      localIntent1.putExtra("key_media_type", 2);
      if ((Build.VERSION.SDK_INT < 21) || (aw.isDarkMode())) {
        break label797;
      }
    }
    label797:
    for (paramView = ActivityOptions.makeSceneTransitionAnimation(this, new Pair[0]).toBundle();; paramView = null)
    {
      localIntent1.putExtra("detail_user_dismiss", this.lzR);
      com.tencent.mm.br.c.c(this, "com.tencent.mm.ui.chatting.gallery.MediaHistoryListUI", localIntent1, paramView);
      break;
      if (i == 4)
      {
        Log.i("MicroMsg.FTS.FTSChattingConvUI", "onSeeUrlHistory");
        localIntent2 = new Intent();
        localIntent2.putExtra("kintent_talker", this.Htv);
        localIntent2.putExtra("key_media_type", 3);
        paramView = localIntent1;
        if (Build.VERSION.SDK_INT >= 21)
        {
          paramView = localIntent1;
          if (!aw.isDarkMode()) {
            paramView = ActivityOptions.makeSceneTransitionAnimation(this, new Pair[0]).toBundle();
          }
        }
        localIntent2.putExtra("detail_user_dismiss", this.lzR);
        com.tencent.mm.br.c.c(this, "com.tencent.mm.ui.chatting.gallery.MediaHistoryListUI", localIntent2, paramView);
        break;
      }
      if (i == 5)
      {
        Log.i("MicroMsg.FTS.FTSChattingConvUI", "onSeeUrlHistory");
        localIntent1 = new Intent();
        localIntent1.putExtra("kintent_talker", this.Htv);
        localIntent1.putExtra("key_media_type", 4);
        paramView = localIntent2;
        if (Build.VERSION.SDK_INT >= 21)
        {
          paramView = localIntent2;
          if (!aw.isDarkMode()) {
            paramView = ActivityOptions.makeSceneTransitionAnimation(this, new Pair[0]).toBundle();
          }
        }
        localIntent1.putExtra("detail_user_dismiss", this.lzR);
        com.tencent.mm.br.c.c(this, "com.tencent.mm.ui.chatting.gallery.MediaHistoryListUI", localIntent1, paramView);
        break;
      }
      if (i == 6)
      {
        Log.i("MicroMsg.FTS.FTSChattingConvUI", "onSeePayHistory");
        localIntent1 = new Intent();
        localIntent1.putExtra("kintent_talker", this.Htv);
        localIntent1.putExtra("key_media_type", 5);
        paramView = localObject1;
        if (Build.VERSION.SDK_INT >= 21)
        {
          paramView = localObject1;
          if (!aw.isDarkMode()) {
            paramView = ActivityOptions.makeSceneTransitionAnimation(this, new Pair[0]).toBundle();
          }
        }
        localIntent1.putExtra("detail_user_dismiss", this.lzR);
        com.tencent.mm.br.c.c(this, "com.tencent.mm.ui.chatting.gallery.MediaHistoryListUI", localIntent1, paramView);
        break;
      }
      if (i != 7) {
        break;
      }
      Log.i("MicroMsg.FTS.FTSChattingConvUI", "onSeeAppBrandHistory");
      localIntent1 = new Intent();
      localIntent1.putExtra("kintent_talker", this.Htv);
      localIntent1.putExtra("key_media_type", 6);
      paramView = localObject2;
      if (Build.VERSION.SDK_INT >= 21)
      {
        paramView = localObject2;
        if (!aw.isDarkMode()) {
          paramView = ActivityOptions.makeSceneTransitionAnimation(this, new Pair[0]).toBundle();
        }
      }
      localIntent1.putExtra("detail_user_dismiss", this.lzR);
      com.tencent.mm.br.c.c(this, "com.tencent.mm.ui.chatting.gallery.MediaHistoryListUI", localIntent1, paramView);
      break;
    }
  }
  
  public void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(111891);
    super.onCreate(paramBundle);
    initView();
    paramBundle = ((com.tencent.mm.plugin.fts.a.n)com.tencent.mm.kernel.h.az(com.tencent.mm.plugin.fts.a.n.class)).getFTSImageLoader();
    if (paramBundle != null) {
      paramBundle.fxg();
    }
    AppMethodBeat.o(111891);
  }
  
  public void onDestroy()
  {
    AppMethodBeat.i(111903);
    super.onDestroy();
    this.HyD.finish();
    Object localObject = ((com.tencent.mm.plugin.fts.a.n)com.tencent.mm.kernel.h.az(com.tencent.mm.plugin.fts.a.n.class)).getFTSImageLoader();
    if (localObject != null) {
      ((com.tencent.mm.plugin.fts.a.d.c)localObject).fxe();
    }
    if ((this.HyA) && (this.lzR))
    {
      if (!au.bwE(this.Htv)) {
        break label210;
      }
      localObject = ((com.tencent.mm.plugin.chatroom.a.b)com.tencent.mm.kernel.h.ax(com.tencent.mm.plugin.chatroom.a.b.class)).bzK().Jv(this.Htv);
      if (((aj)localObject).bHw() == null) {
        break label210;
      }
    }
    label210:
    for (int i = ((aj)localObject).bHw().size();; i = 0)
    {
      com.tencent.mm.plugin.report.service.h.OAn.b(14569, new Object[] { Integer.valueOf(1), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(i), Integer.valueOf(2), Integer.valueOf(0), Integer.valueOf(99) });
      AppMethodBeat.o(111903);
      return;
    }
  }
  
  public void onResume()
  {
    AppMethodBeat.i(111893);
    super.onResume();
    this.Hyz.postDelayed(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(111886);
        FTSChattingConvUI.this.Hye.getFtsEditText().aWT();
        FTSChattingConvUI.this.Hye.getFtsEditText().aWS();
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.fts.ui.FTSChattingConvUI
 * JD-Core Version:    0.7.0.1
 */