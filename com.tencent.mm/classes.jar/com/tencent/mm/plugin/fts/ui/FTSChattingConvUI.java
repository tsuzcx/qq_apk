package com.tencent.mm.plugin.fts.ui;

import android.app.Activity;
import android.app.ActivityOptions;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Paint.Style;
import android.graphics.Rect;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.RecyclerView.a;
import android.support.v7.widget.RecyclerView.h;
import android.support.v7.widget.RecyclerView.t;
import android.support.v7.widget.RecyclerView.w;
import android.util.Pair;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.hellhoundlib.b.b;
import com.tencent.mm.kernel.i;
import com.tencent.mm.model.x;
import com.tencent.mm.plugin.fts.a.n;
import com.tencent.mm.plugin.messenger.foundation.a.l;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.storage.ac;
import com.tencent.mm.storage.an;
import com.tencent.mm.storage.bq;
import com.tencent.mm.ui.search.FTSEditTextView;
import java.util.List;

@i
public class FTSChattingConvUI
  extends FTSBaseUI
  implements View.OnClickListener
{
  private an contact;
  private String tFT;
  private View tKk;
  private g tKl;
  
  private static void ah(String paramString, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(111905);
    paramString = String.format("%s,%d,%d,%d,%d", new Object[] { paramString, Integer.valueOf(paramInt1), Integer.valueOf(5), Integer.valueOf(paramInt2), Integer.valueOf(0) });
    ae.v("MicroMsg.FTS.FTSChattingConvUI", "reportClick: %s", new Object[] { paramString });
    com.tencent.mm.plugin.report.service.g.yxI.kvStat(13234, paramString);
    AppMethodBeat.o(111905);
  }
  
  private void md(int paramInt)
  {
    AppMethodBeat.i(111901);
    if (x.zT(this.tFT))
    {
      ac localac = ((com.tencent.mm.plugin.chatroom.a.c)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.chatroom.a.c.class)).azP().By(this.tFT);
      if (localac.aGE() != null)
      {
        if (paramInt == 0)
        {
          com.tencent.mm.plugin.report.service.g.yxI.f(14569, new Object[] { Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(1), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(localac.aGE().size()), Integer.valueOf(1) });
          AppMethodBeat.o(111901);
          return;
        }
        com.tencent.mm.plugin.report.service.g.yxI.f(14569, new Object[] { Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(1), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(localac.aGE().size()), Integer.valueOf(1) });
      }
      AppMethodBeat.o(111901);
      return;
    }
    if (paramInt == 0)
    {
      com.tencent.mm.plugin.report.service.g.yxI.f(14569, new Object[] { Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(1), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0) });
      AppMethodBeat.o(111901);
      return;
    }
    com.tencent.mm.plugin.report.service.g.yxI.f(14569, new Object[] { Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(1), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0) });
    AppMethodBeat.o(111901);
  }
  
  protected final d a(e parame)
  {
    AppMethodBeat.i(111895);
    if (this.tKl == null) {
      this.tKl = new g(parame, this.tFT);
    }
    parame = this.tKl;
    AppMethodBeat.o(111895);
    return parame;
  }
  
  public final void a(com.tencent.mm.plugin.fts.a.d.a.a parama, boolean paramBoolean)
  {
    AppMethodBeat.i(111896);
    if (x.zT(this.tFT))
    {
      ah(this.query, 10, parama.position + 1);
      AppMethodBeat.o(111896);
      return;
    }
    ah(this.query, 11, parama.position + 1);
    AppMethodBeat.o(111896);
  }
  
  protected final void alI(String paramString)
  {
    int i = 1;
    AppMethodBeat.i(111902);
    super.alI(paramString);
    boolean bool = x.zT(this.tFT);
    paramString = com.tencent.mm.plugin.report.service.g.yxI;
    if (bool) {}
    for (;;)
    {
      paramString.f(14569, new Object[] { Integer.valueOf(0), Integer.valueOf(1), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(i) });
      AppMethodBeat.o(111902);
      return;
      i = 0;
    }
  }
  
  protected final void cVY()
  {
    AppMethodBeat.i(111894);
    this.tFT = getIntent().getStringExtra("detail_username");
    this.contact = ((l)com.tencent.mm.kernel.g.ab(l.class)).azF().BH(this.tFT);
    ae.i("MicroMsg.FTS.FTSChattingConvUI", "initSearchData conversation=%s", new Object[] { this.tFT });
    AppMethodBeat.o(111894);
  }
  
  protected final void cWa()
  {
    AppMethodBeat.i(111900);
    super.cWa();
    this.tKk.setVisibility(8);
    AppMethodBeat.o(111900);
  }
  
  protected final void cWb()
  {
    AppMethodBeat.i(111898);
    super.cWb();
    this.tKk.setVisibility(8);
    AppMethodBeat.o(111898);
  }
  
  protected final void cWc()
  {
    AppMethodBeat.i(111899);
    super.cWc();
    this.tKk.setVisibility(8);
    AppMethodBeat.o(111899);
  }
  
  protected final void cWd()
  {
    AppMethodBeat.i(111897);
    super.cWd();
    this.tKk.setVisibility(0);
    AppMethodBeat.o(111897);
  }
  
  public int getLayoutId()
  {
    return 2131496402;
  }
  
  public void initView()
  {
    AppMethodBeat.i(111892);
    super.initView();
    this.tKk = findViewById(2131304441);
    this.tKk.setVisibility(0);
    RecyclerView localRecyclerView = (RecyclerView)findViewById(2131300591);
    getContext();
    localRecyclerView.setLayoutManager(new GridLayoutManager(3));
    localRecyclerView.a(new RecyclerView.h()
    {
      final int offset;
      Paint paint;
      
      public final void a(Canvas paramAnonymousCanvas, RecyclerView paramAnonymousRecyclerView, RecyclerView.t paramAnonymoust)
      {
        AppMethodBeat.i(111885);
        super.a(paramAnonymousCanvas, paramAnonymousRecyclerView, paramAnonymoust);
        this.paint.setColor(-2434342);
        this.paint.setStrokeWidth(1.0F);
        this.paint.setStyle(Paint.Style.FILL);
        int j = paramAnonymousRecyclerView.getChildCount();
        int i = 0;
        if (i < j)
        {
          paramAnonymoust = paramAnonymousRecyclerView.getChildAt(i);
          if ((i == 1) || (i == 4))
          {
            paramAnonymousCanvas.drawLine(paramAnonymoust.getLeft() - this.offset, paramAnonymoust.getTop(), paramAnonymoust.getLeft() - this.offset, paramAnonymoust.getBottom(), this.paint);
            paramAnonymousCanvas.drawLine(paramAnonymoust.getRight() + this.offset, paramAnonymoust.getTop(), paramAnonymoust.getRight() + this.offset, paramAnonymoust.getBottom(), this.paint);
          }
          for (;;)
          {
            i += 1;
            break;
            if (i == 7) {
              paramAnonymousCanvas.drawLine(paramAnonymoust.getLeft() - this.offset, paramAnonymoust.getTop(), paramAnonymoust.getLeft() - this.offset, paramAnonymoust.getBottom(), this.paint);
            }
          }
        }
        AppMethodBeat.o(111885);
      }
      
      public final void a(Rect paramAnonymousRect, View paramAnonymousView, RecyclerView paramAnonymousRecyclerView, RecyclerView.t paramAnonymoust)
      {
        AppMethodBeat.i(111884);
        super.a(paramAnonymousRect, paramAnonymousView, paramAnonymousRecyclerView, paramAnonymoust);
        paramAnonymousRect.set(this.offset, this.offset, this.offset, this.offset);
        AppMethodBeat.o(111884);
      }
    });
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
    b localb = new b();
    localb.bd(paramView);
    com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/fts/ui/FTSChattingConvUI", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.ahF());
    if (!(paramView instanceof TextView))
    {
      com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/fts/ui/FTSChattingConvUI", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
      AppMethodBeat.o(111904);
      return;
    }
    int i = ((Integer)paramView.getTag()).intValue();
    if (x.zT(this.tFT))
    {
      if (i != 0) {
        break label189;
      }
      ae.i("MicroMsg.FTS.FTSChattingConvUI", "onSearchMemberDetail");
      paramView = new Intent();
      paramView.putExtra("from_scene", 1);
      paramView.putExtra("RoomInfo_Id", this.tFT);
      paramView.putExtra("title", getResources().getString(2131762903));
      com.tencent.mm.br.d.f(this, "com.tencent.mm.chatroom.ui.SeeMemberRecordUI", paramView);
    }
    for (;;)
    {
      com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/fts/ui/FTSChattingConvUI", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
      AppMethodBeat.o(111904);
      return;
      i += 1;
      break;
      label189:
      if (i == 1)
      {
        ae.i("MicroMsg.FTS.FTSChattingConvUI", "onSearchDateDetail");
        paramView = new Intent();
        paramView.putExtra("detail_username", this.tFT);
        com.tencent.mm.br.d.f(this, "com.tencent.mm.chatroom.ui.SelectDateUI", paramView);
        md(0);
      }
      else
      {
        if (i != 2) {
          break label295;
        }
        ae.i("MicroMsg.FTS.FTSChattingConvUI", "onSeeImageVideoHistory");
        paramView = new Intent();
        paramView.putExtra("kintent_talker", this.tFT);
        paramView.putExtra("key_media_type", 1);
        com.tencent.mm.br.d.f(this, "com.tencent.mm.ui.chatting.gallery.MediaHistoryGalleryUI", paramView);
        md(1);
      }
    }
    label295:
    if (i == 3)
    {
      ae.i("MicroMsg.FTS.FTSChattingConvUI", "onSeeFileHistory");
      localIntent1 = new Intent();
      localIntent1.putExtra("kintent_talker", this.tFT);
      localIntent1.putExtra("key_media_type", 2);
      if ((Build.VERSION.SDK_INT < 21) || (com.tencent.mm.ui.al.isDarkMode())) {
        break label724;
      }
    }
    label724:
    for (paramView = ActivityOptions.makeSceneTransitionAnimation(this, new Pair[0]).toBundle();; paramView = null)
    {
      com.tencent.mm.br.d.c(this, "com.tencent.mm.ui.chatting.gallery.MediaHistoryListUI", localIntent1, paramView);
      break;
      if (i == 4)
      {
        ae.i("MicroMsg.FTS.FTSChattingConvUI", "onSeeUrlHistory");
        localIntent2 = new Intent();
        localIntent2.putExtra("kintent_talker", this.tFT);
        localIntent2.putExtra("key_media_type", 3);
        paramView = localIntent1;
        if (Build.VERSION.SDK_INT >= 21)
        {
          paramView = localIntent1;
          if (!com.tencent.mm.ui.al.isDarkMode()) {
            paramView = ActivityOptions.makeSceneTransitionAnimation(this, new Pair[0]).toBundle();
          }
        }
        com.tencent.mm.br.d.c(this, "com.tencent.mm.ui.chatting.gallery.MediaHistoryListUI", localIntent2, paramView);
        break;
      }
      if (i == 5)
      {
        ae.i("MicroMsg.FTS.FTSChattingConvUI", "onSeeUrlHistory");
        localIntent1 = new Intent();
        localIntent1.putExtra("kintent_talker", this.tFT);
        localIntent1.putExtra("key_media_type", 4);
        paramView = localIntent2;
        if (Build.VERSION.SDK_INT >= 21)
        {
          paramView = localIntent2;
          if (!com.tencent.mm.ui.al.isDarkMode()) {
            paramView = ActivityOptions.makeSceneTransitionAnimation(this, new Pair[0]).toBundle();
          }
        }
        com.tencent.mm.br.d.c(this, "com.tencent.mm.ui.chatting.gallery.MediaHistoryListUI", localIntent1, paramView);
        break;
      }
      if (i == 6)
      {
        ae.i("MicroMsg.FTS.FTSChattingConvUI", "onSeePayHistory");
        localIntent1 = new Intent();
        localIntent1.putExtra("kintent_talker", this.tFT);
        localIntent1.putExtra("key_media_type", 5);
        paramView = localObject1;
        if (Build.VERSION.SDK_INT >= 21)
        {
          paramView = localObject1;
          if (!com.tencent.mm.ui.al.isDarkMode()) {
            paramView = ActivityOptions.makeSceneTransitionAnimation(this, new Pair[0]).toBundle();
          }
        }
        com.tencent.mm.br.d.c(this, "com.tencent.mm.ui.chatting.gallery.MediaHistoryListUI", localIntent1, paramView);
        break;
      }
      if (i != 7) {
        break;
      }
      ae.i("MicroMsg.FTS.FTSChattingConvUI", "onSeeAppBrandHistory");
      localIntent1 = new Intent();
      localIntent1.putExtra("kintent_talker", this.tFT);
      localIntent1.putExtra("key_media_type", 6);
      paramView = localObject2;
      if (Build.VERSION.SDK_INT >= 21)
      {
        paramView = localObject2;
        if (!com.tencent.mm.ui.al.isDarkMode()) {
          paramView = ActivityOptions.makeSceneTransitionAnimation(this, new Pair[0]).toBundle();
        }
      }
      com.tencent.mm.br.d.c(this, "com.tencent.mm.ui.chatting.gallery.MediaHistoryListUI", localIntent1, paramView);
      break;
    }
  }
  
  public void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(111891);
    super.onCreate(paramBundle);
    initView();
    paramBundle = ((n)com.tencent.mm.kernel.g.ad(n.class)).getFTSImageLoader();
    if (paramBundle != null) {
      paramBundle.cVe();
    }
    AppMethodBeat.o(111891);
  }
  
  public void onDestroy()
  {
    AppMethodBeat.i(111903);
    super.onDestroy();
    this.tKl.finish();
    com.tencent.mm.plugin.fts.a.d.c localc = ((n)com.tencent.mm.kernel.g.ad(n.class)).getFTSImageLoader();
    if (localc != null) {
      localc.cVc();
    }
    AppMethodBeat.o(111903);
  }
  
  public void onResume()
  {
    AppMethodBeat.i(111893);
    super.onResume();
    this.tKk.postDelayed(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(111886);
        FTSChattingConvUI.this.tJO.getFtsEditText().fOj();
        FTSChattingConvUI.this.tJO.getFtsEditText().fOi();
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
    String[] tKn;
    
    a()
    {
      AppMethodBeat.i(111887);
      if (!x.zT(FTSChattingConvUI.a(FTSChattingConvUI.this)))
      {
        this.tKn = new String[7];
        this.tKn[0] = FTSChattingConvUI.this.getResources().getString(2131762907);
        this.tKn[1] = FTSChattingConvUI.this.getResources().getString(2131762909);
        this.tKn[2] = FTSChattingConvUI.this.getResources().getString(2131762908);
        this.tKn[3] = FTSChattingConvUI.this.getResources().getString(2131762913);
        this.tKn[4] = FTSChattingConvUI.this.getResources().getString(2131762911);
        this.tKn[5] = FTSChattingConvUI.this.getResources().getString(2131762912);
        this.tKn[6] = FTSChattingConvUI.this.getResources().getString(2131762906);
        AppMethodBeat.o(111887);
        return;
      }
      this.tKn = new String[8];
      this.tKn[0] = FTSChattingConvUI.this.getResources().getString(2131762910);
      this.tKn[1] = FTSChattingConvUI.this.getResources().getString(2131762907);
      this.tKn[2] = FTSChattingConvUI.this.getResources().getString(2131762909);
      this.tKn[3] = FTSChattingConvUI.this.getResources().getString(2131762908);
      this.tKn[4] = FTSChattingConvUI.this.getResources().getString(2131762913);
      this.tKn[5] = FTSChattingConvUI.this.getResources().getString(2131762911);
      this.tKn[6] = FTSChattingConvUI.this.getResources().getString(2131762912);
      this.tKn[7] = FTSChattingConvUI.this.getResources().getString(2131762906);
      AppMethodBeat.o(111887);
    }
    
    public final int getItemCount()
    {
      return this.tKn.length;
    }
  }
  
  final class b
    extends RecyclerView.w
  {
    TextView vk;
    
    public b(View paramView)
    {
      super();
      AppMethodBeat.i(111890);
      this.vk = ((TextView)paramView.findViewById(2131305902));
      this.vk.setOnClickListener(FTSChattingConvUI.this);
      AppMethodBeat.o(111890);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.fts.ui.FTSChattingConvUI
 * JD-Core Version:    0.7.0.1
 */