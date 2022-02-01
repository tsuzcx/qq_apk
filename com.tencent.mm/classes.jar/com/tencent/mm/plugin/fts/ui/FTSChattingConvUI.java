package com.tencent.mm.plugin.fts.ui;

import android.app.Activity;
import android.app.ActivityOptions;
import android.content.Intent;
import android.content.res.Resources;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.RecyclerView.a;
import android.support.v7.widget.RecyclerView.w;
import android.util.Pair;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.g;
import com.tencent.mm.kernel.i;
import com.tencent.mm.model.w;
import com.tencent.mm.plugin.fts.a.n;
import com.tencent.mm.plugin.messenger.foundation.a.k;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.storage.ai;
import com.tencent.mm.storage.bj;
import com.tencent.mm.storage.x;
import com.tencent.mm.ui.search.FTSEditTextView;
import java.util.List;

@i
public class FTSChattingConvUI
  extends FTSBaseUI
  implements View.OnClickListener
{
  private ai contact;
  private View sCE;
  private f sCF;
  private String syB;
  
  private static void ad(String paramString, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(111905);
    paramString = String.format("%s,%d,%d,%d,%d", new Object[] { paramString, Integer.valueOf(paramInt1), Integer.valueOf(5), Integer.valueOf(paramInt2), Integer.valueOf(0) });
    ac.v("MicroMsg.FTS.FTSChattingConvUI", "reportClick: %s", new Object[] { paramString });
    h.wUl.kvStat(13234, paramString);
    AppMethodBeat.o(111905);
  }
  
  private void lA(int paramInt)
  {
    AppMethodBeat.i(111901);
    if (w.wo(this.syB))
    {
      x localx = ((com.tencent.mm.plugin.chatroom.a.c)g.ab(com.tencent.mm.plugin.chatroom.a.c.class)).awK().xO(this.syB);
      if (localx.aDl() != null)
      {
        if (paramInt == 0)
        {
          h.wUl.f(14569, new Object[] { Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(1), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(localx.aDl().size()), Integer.valueOf(1) });
          AppMethodBeat.o(111901);
          return;
        }
        h.wUl.f(14569, new Object[] { Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(1), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(localx.aDl().size()), Integer.valueOf(1) });
      }
      AppMethodBeat.o(111901);
      return;
    }
    if (paramInt == 0)
    {
      h.wUl.f(14569, new Object[] { Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(1), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0) });
      AppMethodBeat.o(111901);
      return;
    }
    h.wUl.f(14569, new Object[] { Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(1), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0) });
    AppMethodBeat.o(111901);
  }
  
  protected final d a(e parame)
  {
    AppMethodBeat.i(111895);
    if (this.sCF == null) {
      this.sCF = new f(parame, this.syB);
    }
    parame = this.sCF;
    AppMethodBeat.o(111895);
    return parame;
  }
  
  public final void a(com.tencent.mm.plugin.fts.a.d.a.a parama, boolean paramBoolean)
  {
    AppMethodBeat.i(111896);
    if (w.wo(this.syB))
    {
      ad(this.query, 10, parama.position + 1);
      AppMethodBeat.o(111896);
      return;
    }
    ad(this.query, 11, parama.position + 1);
    AppMethodBeat.o(111896);
  }
  
  protected final void agm(String paramString)
  {
    int i = 1;
    AppMethodBeat.i(111902);
    super.agm(paramString);
    boolean bool = w.wo(this.syB);
    paramString = h.wUl;
    if (bool) {}
    for (;;)
    {
      paramString.f(14569, new Object[] { Integer.valueOf(0), Integer.valueOf(1), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(i) });
      AppMethodBeat.o(111902);
      return;
      i = 0;
    }
  }
  
  protected final void cLd()
  {
    AppMethodBeat.i(111894);
    this.syB = getIntent().getStringExtra("detail_username");
    this.contact = ((k)g.ab(k.class)).awB().aNt(this.syB);
    ac.i("MicroMsg.FTS.FTSChattingConvUI", "initSearchData conversation=%s", new Object[] { this.syB });
    AppMethodBeat.o(111894);
  }
  
  protected final void cLe()
  {
    AppMethodBeat.i(111900);
    super.cLe();
    this.sCE.setVisibility(8);
    AppMethodBeat.o(111900);
  }
  
  protected final void cLf()
  {
    AppMethodBeat.i(111898);
    super.cLf();
    this.sCE.setVisibility(8);
    AppMethodBeat.o(111898);
  }
  
  protected final void cLg()
  {
    AppMethodBeat.i(111899);
    super.cLg();
    this.sCE.setVisibility(8);
    AppMethodBeat.o(111899);
  }
  
  protected final void cLh()
  {
    AppMethodBeat.i(111897);
    super.cLh();
    this.sCE.setVisibility(0);
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
    this.sCE = findViewById(2131304441);
    this.sCE.setVisibility(0);
    RecyclerView localRecyclerView = (RecyclerView)findViewById(2131300591);
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
    if (!(paramView instanceof TextView))
    {
      AppMethodBeat.o(111904);
      return;
    }
    int i = ((Integer)paramView.getTag()).intValue();
    if (w.wo(this.syB)) {}
    while (i == 0)
    {
      ac.i("MicroMsg.FTS.FTSChattingConvUI", "onSearchMemberDetail");
      paramView = new Intent();
      paramView.putExtra("from_scene", 1);
      paramView.putExtra("RoomInfo_Id", this.syB);
      paramView.putExtra("title", getResources().getString(2131762903));
      com.tencent.mm.br.d.e(this, "com.tencent.mm.chatroom.ui.SeeMemberRecordUI", paramView);
      AppMethodBeat.o(111904);
      return;
      i += 1;
    }
    if (i == 1)
    {
      ac.i("MicroMsg.FTS.FTSChattingConvUI", "onSearchDateDetail");
      paramView = new Intent();
      paramView.putExtra("detail_username", this.syB);
      com.tencent.mm.br.d.e(this, "com.tencent.mm.chatroom.ui.SelectDateUI", paramView);
      lA(0);
      AppMethodBeat.o(111904);
      return;
    }
    if (i == 2)
    {
      ac.i("MicroMsg.FTS.FTSChattingConvUI", "onSeeImageVideoHistory");
      paramView = new Intent();
      paramView.putExtra("kintent_talker", this.syB);
      paramView.putExtra("key_media_type", 1);
      com.tencent.mm.br.d.e(this, "com.tencent.mm.ui.chatting.gallery.MediaHistoryGalleryUI", paramView);
      lA(1);
      AppMethodBeat.o(111904);
      return;
    }
    if (i == 3)
    {
      ac.i("MicroMsg.FTS.FTSChattingConvUI", "onSeeFileHistory");
      localIntent1 = new Intent();
      localIntent1.putExtra("kintent_talker", this.syB);
      localIntent1.putExtra("key_media_type", 2);
      if ((Build.VERSION.SDK_INT < 21) || (com.tencent.mm.ui.aj.DT())) {
        break label686;
      }
    }
    label686:
    for (paramView = ActivityOptions.makeSceneTransitionAnimation(this, new Pair[0]).toBundle();; paramView = null)
    {
      com.tencent.mm.br.d.c(this, "com.tencent.mm.ui.chatting.gallery.MediaHistoryListUI", localIntent1, paramView);
      AppMethodBeat.o(111904);
      return;
      if (i == 4)
      {
        ac.i("MicroMsg.FTS.FTSChattingConvUI", "onSeeUrlHistory");
        localIntent2 = new Intent();
        localIntent2.putExtra("kintent_talker", this.syB);
        localIntent2.putExtra("key_media_type", 3);
        paramView = localIntent1;
        if (Build.VERSION.SDK_INT >= 21)
        {
          paramView = localIntent1;
          if (!com.tencent.mm.ui.aj.DT()) {
            paramView = ActivityOptions.makeSceneTransitionAnimation(this, new Pair[0]).toBundle();
          }
        }
        com.tencent.mm.br.d.c(this, "com.tencent.mm.ui.chatting.gallery.MediaHistoryListUI", localIntent2, paramView);
        AppMethodBeat.o(111904);
        return;
      }
      if (i == 5)
      {
        ac.i("MicroMsg.FTS.FTSChattingConvUI", "onSeeUrlHistory");
        localIntent1 = new Intent();
        localIntent1.putExtra("kintent_talker", this.syB);
        localIntent1.putExtra("key_media_type", 4);
        paramView = localIntent2;
        if (Build.VERSION.SDK_INT >= 21)
        {
          paramView = localIntent2;
          if (!com.tencent.mm.ui.aj.DT()) {
            paramView = ActivityOptions.makeSceneTransitionAnimation(this, new Pair[0]).toBundle();
          }
        }
        com.tencent.mm.br.d.c(this, "com.tencent.mm.ui.chatting.gallery.MediaHistoryListUI", localIntent1, paramView);
        AppMethodBeat.o(111904);
        return;
      }
      if (i == 6)
      {
        ac.i("MicroMsg.FTS.FTSChattingConvUI", "onSeePayHistory");
        localIntent1 = new Intent();
        localIntent1.putExtra("kintent_talker", this.syB);
        localIntent1.putExtra("key_media_type", 5);
        paramView = localObject1;
        if (Build.VERSION.SDK_INT >= 21)
        {
          paramView = localObject1;
          if (!com.tencent.mm.ui.aj.DT()) {
            paramView = ActivityOptions.makeSceneTransitionAnimation(this, new Pair[0]).toBundle();
          }
        }
        com.tencent.mm.br.d.c(this, "com.tencent.mm.ui.chatting.gallery.MediaHistoryListUI", localIntent1, paramView);
        AppMethodBeat.o(111904);
        return;
      }
      if (i == 7)
      {
        ac.i("MicroMsg.FTS.FTSChattingConvUI", "onSeeAppBrandHistory");
        localIntent1 = new Intent();
        localIntent1.putExtra("kintent_talker", this.syB);
        localIntent1.putExtra("key_media_type", 6);
        paramView = localObject2;
        if (Build.VERSION.SDK_INT >= 21)
        {
          paramView = localObject2;
          if (!com.tencent.mm.ui.aj.DT()) {
            paramView = ActivityOptions.makeSceneTransitionAnimation(this, new Pair[0]).toBundle();
          }
        }
        com.tencent.mm.br.d.c(this, "com.tencent.mm.ui.chatting.gallery.MediaHistoryListUI", localIntent1, paramView);
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
      paramBundle.cKk();
    }
    AppMethodBeat.o(111891);
  }
  
  public void onDestroy()
  {
    AppMethodBeat.i(111903);
    super.onDestroy();
    this.sCF.finish();
    com.tencent.mm.plugin.fts.a.d.c localc = ((n)g.ad(n.class)).getFTSImageLoader();
    if (localc != null) {
      localc.cKi();
    }
    AppMethodBeat.o(111903);
  }
  
  public void onResume()
  {
    AppMethodBeat.i(111893);
    super.onResume();
    this.sCE.postDelayed(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(111886);
        FTSChattingConvUI.this.sCw.getFtsEditText().fte();
        FTSChattingConvUI.this.sCw.getFtsEditText().ftd();
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
    String[] sCH;
    
    a()
    {
      AppMethodBeat.i(111887);
      if (!w.wo(FTSChattingConvUI.a(FTSChattingConvUI.this)))
      {
        this.sCH = new String[7];
        this.sCH[0] = FTSChattingConvUI.this.getResources().getString(2131762907);
        this.sCH[1] = FTSChattingConvUI.this.getResources().getString(2131762909);
        this.sCH[2] = FTSChattingConvUI.this.getResources().getString(2131762908);
        this.sCH[3] = FTSChattingConvUI.this.getResources().getString(2131762913);
        this.sCH[4] = FTSChattingConvUI.this.getResources().getString(2131762911);
        this.sCH[5] = FTSChattingConvUI.this.getResources().getString(2131762912);
        this.sCH[6] = FTSChattingConvUI.this.getResources().getString(2131762906);
        AppMethodBeat.o(111887);
        return;
      }
      this.sCH = new String[8];
      this.sCH[0] = FTSChattingConvUI.this.getResources().getString(2131762910);
      this.sCH[1] = FTSChattingConvUI.this.getResources().getString(2131762907);
      this.sCH[2] = FTSChattingConvUI.this.getResources().getString(2131762909);
      this.sCH[3] = FTSChattingConvUI.this.getResources().getString(2131762908);
      this.sCH[4] = FTSChattingConvUI.this.getResources().getString(2131762913);
      this.sCH[5] = FTSChattingConvUI.this.getResources().getString(2131762911);
      this.sCH[6] = FTSChattingConvUI.this.getResources().getString(2131762912);
      this.sCH[7] = FTSChattingConvUI.this.getResources().getString(2131762906);
      AppMethodBeat.o(111887);
    }
    
    public final int getItemCount()
    {
      return this.sCH.length;
    }
  }
  
  final class b
    extends RecyclerView.w
  {
    TextView tr;
    
    public b(View paramView)
    {
      super();
      AppMethodBeat.i(111890);
      this.tr = ((TextView)paramView.findViewById(2131305902));
      this.tr.setOnClickListener(FTSChattingConvUI.this);
      AppMethodBeat.o(111890);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.fts.ui.FTSChattingConvUI
 * JD-Core Version:    0.7.0.1
 */