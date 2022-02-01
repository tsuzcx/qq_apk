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
import com.tencent.mm.model.ak;
import com.tencent.mm.model.w;
import com.tencent.mm.plugin.fts.a.n;
import com.tencent.mm.plugin.messenger.foundation.a.l;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.storage.ab;
import com.tencent.mm.storage.am;
import com.tencent.mm.storage.bp;
import com.tencent.mm.ui.al;
import com.tencent.mm.ui.search.FTSEditTextView;
import java.util.List;

@i
public class FTSChattingConvUI
  extends FTSBaseUI
  implements View.OnClickListener
{
  private am contact;
  private String tvc;
  private View tzt;
  private g tzu;
  
  private static void ah(String paramString, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(111905);
    paramString = String.format("%s,%d,%d,%d,%d", new Object[] { paramString, Integer.valueOf(paramInt1), Integer.valueOf(5), Integer.valueOf(paramInt2), Integer.valueOf(0) });
    ad.v("MicroMsg.FTS.FTSChattingConvUI", "reportClick: %s", new Object[] { paramString });
    com.tencent.mm.plugin.report.service.g.yhR.kvStat(13234, paramString);
    AppMethodBeat.o(111905);
  }
  
  private void ma(int paramInt)
  {
    AppMethodBeat.i(111901);
    if (w.zj(this.tvc))
    {
      ab localab = ((com.tencent.mm.plugin.chatroom.a.c)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.chatroom.a.c.class)).azz().AO(this.tvc);
      if (localab.aGo() != null)
      {
        if (paramInt == 0)
        {
          com.tencent.mm.plugin.report.service.g.yhR.f(14569, new Object[] { Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(1), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(localab.aGo().size()), Integer.valueOf(1) });
          AppMethodBeat.o(111901);
          return;
        }
        com.tencent.mm.plugin.report.service.g.yhR.f(14569, new Object[] { Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(1), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(localab.aGo().size()), Integer.valueOf(1) });
      }
      AppMethodBeat.o(111901);
      return;
    }
    if (paramInt == 0)
    {
      com.tencent.mm.plugin.report.service.g.yhR.f(14569, new Object[] { Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(1), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0) });
      AppMethodBeat.o(111901);
      return;
    }
    com.tencent.mm.plugin.report.service.g.yhR.f(14569, new Object[] { Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(1), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0) });
    AppMethodBeat.o(111901);
  }
  
  protected final d a(e parame)
  {
    AppMethodBeat.i(111895);
    if (this.tzu == null) {
      this.tzu = new g(parame, this.tvc);
    }
    parame = this.tzu;
    AppMethodBeat.o(111895);
    return parame;
  }
  
  public final void a(com.tencent.mm.plugin.fts.a.d.a.a parama, boolean paramBoolean)
  {
    AppMethodBeat.i(111896);
    if (w.zj(this.tvc))
    {
      ah(this.query, 10, parama.position + 1);
      AppMethodBeat.o(111896);
      return;
    }
    ah(this.query, 11, parama.position + 1);
    AppMethodBeat.o(111896);
  }
  
  protected final void akK(String paramString)
  {
    int i = 1;
    AppMethodBeat.i(111902);
    super.akK(paramString);
    boolean bool = w.zj(this.tvc);
    paramString = com.tencent.mm.plugin.report.service.g.yhR;
    if (bool) {}
    for (;;)
    {
      paramString.f(14569, new Object[] { Integer.valueOf(0), Integer.valueOf(1), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(i) });
      AppMethodBeat.o(111902);
      return;
      i = 0;
    }
  }
  
  protected final void cTt()
  {
    AppMethodBeat.i(111894);
    this.tvc = getIntent().getStringExtra("detail_username");
    this.contact = ((l)com.tencent.mm.kernel.g.ab(l.class)).azp().Bf(this.tvc);
    ad.i("MicroMsg.FTS.FTSChattingConvUI", "initSearchData conversation=%s", new Object[] { this.tvc });
    AppMethodBeat.o(111894);
  }
  
  protected final void cTv()
  {
    AppMethodBeat.i(111900);
    super.cTv();
    this.tzt.setVisibility(8);
    AppMethodBeat.o(111900);
  }
  
  protected final void cTw()
  {
    AppMethodBeat.i(111898);
    super.cTw();
    this.tzt.setVisibility(8);
    AppMethodBeat.o(111898);
  }
  
  protected final void cTx()
  {
    AppMethodBeat.i(111899);
    super.cTx();
    this.tzt.setVisibility(8);
    AppMethodBeat.o(111899);
  }
  
  protected final void cTy()
  {
    AppMethodBeat.i(111897);
    super.cTy();
    this.tzt.setVisibility(0);
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
    this.tzt = findViewById(2131304441);
    this.tzt.setVisibility(0);
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
    com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/fts/ui/FTSChattingConvUI", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.ahq());
    if (!(paramView instanceof TextView))
    {
      com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/fts/ui/FTSChattingConvUI", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
      AppMethodBeat.o(111904);
      return;
    }
    int i = ((Integer)paramView.getTag()).intValue();
    if (w.zj(this.tvc))
    {
      if (i != 0) {
        break label189;
      }
      ad.i("MicroMsg.FTS.FTSChattingConvUI", "onSearchMemberDetail");
      paramView = new Intent();
      paramView.putExtra("from_scene", 1);
      paramView.putExtra("RoomInfo_Id", this.tvc);
      paramView.putExtra("title", getResources().getString(2131762903));
      com.tencent.mm.bs.d.f(this, "com.tencent.mm.chatroom.ui.SeeMemberRecordUI", paramView);
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
        ad.i("MicroMsg.FTS.FTSChattingConvUI", "onSearchDateDetail");
        paramView = new Intent();
        paramView.putExtra("detail_username", this.tvc);
        com.tencent.mm.bs.d.f(this, "com.tencent.mm.chatroom.ui.SelectDateUI", paramView);
        ma(0);
      }
      else
      {
        if (i != 2) {
          break label295;
        }
        ad.i("MicroMsg.FTS.FTSChattingConvUI", "onSeeImageVideoHistory");
        paramView = new Intent();
        paramView.putExtra("kintent_talker", this.tvc);
        paramView.putExtra("key_media_type", 1);
        com.tencent.mm.bs.d.f(this, "com.tencent.mm.ui.chatting.gallery.MediaHistoryGalleryUI", paramView);
        ma(1);
      }
    }
    label295:
    if (i == 3)
    {
      ad.i("MicroMsg.FTS.FTSChattingConvUI", "onSeeFileHistory");
      localIntent1 = new Intent();
      localIntent1.putExtra("kintent_talker", this.tvc);
      localIntent1.putExtra("key_media_type", 2);
      if ((Build.VERSION.SDK_INT < 21) || (al.isDarkMode())) {
        break label724;
      }
    }
    label724:
    for (paramView = ActivityOptions.makeSceneTransitionAnimation(this, new Pair[0]).toBundle();; paramView = null)
    {
      com.tencent.mm.bs.d.c(this, "com.tencent.mm.ui.chatting.gallery.MediaHistoryListUI", localIntent1, paramView);
      break;
      if (i == 4)
      {
        ad.i("MicroMsg.FTS.FTSChattingConvUI", "onSeeUrlHistory");
        localIntent2 = new Intent();
        localIntent2.putExtra("kintent_talker", this.tvc);
        localIntent2.putExtra("key_media_type", 3);
        paramView = localIntent1;
        if (Build.VERSION.SDK_INT >= 21)
        {
          paramView = localIntent1;
          if (!al.isDarkMode()) {
            paramView = ActivityOptions.makeSceneTransitionAnimation(this, new Pair[0]).toBundle();
          }
        }
        com.tencent.mm.bs.d.c(this, "com.tencent.mm.ui.chatting.gallery.MediaHistoryListUI", localIntent2, paramView);
        break;
      }
      if (i == 5)
      {
        ad.i("MicroMsg.FTS.FTSChattingConvUI", "onSeeUrlHistory");
        localIntent1 = new Intent();
        localIntent1.putExtra("kintent_talker", this.tvc);
        localIntent1.putExtra("key_media_type", 4);
        paramView = localIntent2;
        if (Build.VERSION.SDK_INT >= 21)
        {
          paramView = localIntent2;
          if (!al.isDarkMode()) {
            paramView = ActivityOptions.makeSceneTransitionAnimation(this, new Pair[0]).toBundle();
          }
        }
        com.tencent.mm.bs.d.c(this, "com.tencent.mm.ui.chatting.gallery.MediaHistoryListUI", localIntent1, paramView);
        break;
      }
      if (i == 6)
      {
        ad.i("MicroMsg.FTS.FTSChattingConvUI", "onSeePayHistory");
        localIntent1 = new Intent();
        localIntent1.putExtra("kintent_talker", this.tvc);
        localIntent1.putExtra("key_media_type", 5);
        paramView = localObject1;
        if (Build.VERSION.SDK_INT >= 21)
        {
          paramView = localObject1;
          if (!al.isDarkMode()) {
            paramView = ActivityOptions.makeSceneTransitionAnimation(this, new Pair[0]).toBundle();
          }
        }
        com.tencent.mm.bs.d.c(this, "com.tencent.mm.ui.chatting.gallery.MediaHistoryListUI", localIntent1, paramView);
        break;
      }
      if (i != 7) {
        break;
      }
      ad.i("MicroMsg.FTS.FTSChattingConvUI", "onSeeAppBrandHistory");
      localIntent1 = new Intent();
      localIntent1.putExtra("kintent_talker", this.tvc);
      localIntent1.putExtra("key_media_type", 6);
      paramView = localObject2;
      if (Build.VERSION.SDK_INT >= 21)
      {
        paramView = localObject2;
        if (!al.isDarkMode()) {
          paramView = ActivityOptions.makeSceneTransitionAnimation(this, new Pair[0]).toBundle();
        }
      }
      com.tencent.mm.bs.d.c(this, "com.tencent.mm.ui.chatting.gallery.MediaHistoryListUI", localIntent1, paramView);
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
      paramBundle.cSz();
    }
    AppMethodBeat.o(111891);
  }
  
  public void onDestroy()
  {
    AppMethodBeat.i(111903);
    super.onDestroy();
    this.tzu.finish();
    com.tencent.mm.plugin.fts.a.d.c localc = ((n)com.tencent.mm.kernel.g.ad(n.class)).getFTSImageLoader();
    if (localc != null) {
      localc.cSx();
    }
    AppMethodBeat.o(111903);
  }
  
  public void onResume()
  {
    AppMethodBeat.i(111893);
    super.onResume();
    this.tzt.postDelayed(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(111886);
        FTSChattingConvUI.this.tyX.getFtsEditText().fJS();
        FTSChattingConvUI.this.tyX.getFtsEditText().fJR();
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
    String[] tzw;
    
    a()
    {
      AppMethodBeat.i(111887);
      if (!w.zj(FTSChattingConvUI.a(FTSChattingConvUI.this)))
      {
        this.tzw = new String[7];
        this.tzw[0] = FTSChattingConvUI.this.getResources().getString(2131762907);
        this.tzw[1] = FTSChattingConvUI.this.getResources().getString(2131762909);
        this.tzw[2] = FTSChattingConvUI.this.getResources().getString(2131762908);
        this.tzw[3] = FTSChattingConvUI.this.getResources().getString(2131762913);
        this.tzw[4] = FTSChattingConvUI.this.getResources().getString(2131762911);
        this.tzw[5] = FTSChattingConvUI.this.getResources().getString(2131762912);
        this.tzw[6] = FTSChattingConvUI.this.getResources().getString(2131762906);
        AppMethodBeat.o(111887);
        return;
      }
      this.tzw = new String[8];
      this.tzw[0] = FTSChattingConvUI.this.getResources().getString(2131762910);
      this.tzw[1] = FTSChattingConvUI.this.getResources().getString(2131762907);
      this.tzw[2] = FTSChattingConvUI.this.getResources().getString(2131762909);
      this.tzw[3] = FTSChattingConvUI.this.getResources().getString(2131762908);
      this.tzw[4] = FTSChattingConvUI.this.getResources().getString(2131762913);
      this.tzw[5] = FTSChattingConvUI.this.getResources().getString(2131762911);
      this.tzw[6] = FTSChattingConvUI.this.getResources().getString(2131762912);
      this.tzw[7] = FTSChattingConvUI.this.getResources().getString(2131762906);
      AppMethodBeat.o(111887);
    }
    
    public final int getItemCount()
    {
      return this.tzw.length;
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