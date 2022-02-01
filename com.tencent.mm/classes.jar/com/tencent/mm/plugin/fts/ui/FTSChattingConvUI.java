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
import android.support.v7.widget.RecyclerView.s;
import android.support.v7.widget.RecyclerView.v;
import android.util.Pair;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.hellhoundlib.b.b;
import com.tencent.mm.kernel.i;
import com.tencent.mm.model.ab;
import com.tencent.mm.model.ap;
import com.tencent.mm.plugin.fts.a.n;
import com.tencent.mm.plugin.messenger.foundation.a.l;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.storage.ah;
import com.tencent.mm.storage.as;
import com.tencent.mm.storage.bv;
import com.tencent.mm.ui.ao;
import com.tencent.mm.ui.search.FTSEditTextView;
import java.util.List;

@i
public class FTSChattingConvUI
  extends FTSBaseUI
  implements View.OnClickListener
{
  private as contact;
  private String wWS;
  private View xbj;
  private g xbk;
  
  private static void ak(String paramString, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(111905);
    paramString = String.format("%s,%d,%d,%d,%d", new Object[] { paramString, Integer.valueOf(paramInt1), Integer.valueOf(5), Integer.valueOf(paramInt2), Integer.valueOf(0) });
    Log.v("MicroMsg.FTS.FTSChattingConvUI", "reportClick: %s", new Object[] { paramString });
    h.CyF.kvStat(13234, paramString);
    AppMethodBeat.o(111905);
  }
  
  private void pl(int paramInt)
  {
    AppMethodBeat.i(111901);
    if (ab.Iw(this.wWS))
    {
      ah localah = ((com.tencent.mm.plugin.chatroom.a.c)com.tencent.mm.kernel.g.af(com.tencent.mm.plugin.chatroom.a.c.class)).aSX().Ke(this.wWS);
      if (localah.bax() != null)
      {
        if (paramInt == 0)
        {
          h.CyF.a(14569, new Object[] { Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(1), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(localah.bax().size()), Integer.valueOf(1) });
          AppMethodBeat.o(111901);
          return;
        }
        h.CyF.a(14569, new Object[] { Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(1), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(localah.bax().size()), Integer.valueOf(1) });
      }
      AppMethodBeat.o(111901);
      return;
    }
    if (paramInt == 0)
    {
      h.CyF.a(14569, new Object[] { Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(1), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0) });
      AppMethodBeat.o(111901);
      return;
    }
    h.CyF.a(14569, new Object[] { Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(1), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0) });
    AppMethodBeat.o(111901);
  }
  
  protected final d a(e parame)
  {
    AppMethodBeat.i(111895);
    if (this.xbk == null) {
      this.xbk = new g(parame, this.wWS);
    }
    parame = this.xbk;
    AppMethodBeat.o(111895);
    return parame;
  }
  
  public final void a(com.tencent.mm.plugin.fts.a.d.a.a parama, boolean paramBoolean)
  {
    AppMethodBeat.i(111896);
    if (ab.Iw(this.wWS))
    {
      ak(this.query, 10, parama.position + 1);
      AppMethodBeat.o(111896);
      return;
    }
    ak(this.query, 11, parama.position + 1);
    AppMethodBeat.o(111896);
  }
  
  protected final void ayM(String paramString)
  {
    int i = 1;
    AppMethodBeat.i(111902);
    super.ayM(paramString);
    boolean bool = ab.Iw(this.wWS);
    paramString = h.CyF;
    if (bool) {}
    for (;;)
    {
      paramString.a(14569, new Object[] { Integer.valueOf(0), Integer.valueOf(1), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(i) });
      AppMethodBeat.o(111902);
      return;
      i = 0;
    }
  }
  
  protected final void dPh()
  {
    AppMethodBeat.i(111894);
    this.wWS = getIntent().getStringExtra("detail_username");
    this.contact = ((l)com.tencent.mm.kernel.g.af(l.class)).aSN().Kn(this.wWS);
    Log.i("MicroMsg.FTS.FTSChattingConvUI", "initSearchData conversation=%s", new Object[] { this.wWS });
    AppMethodBeat.o(111894);
  }
  
  protected final void dPj()
  {
    AppMethodBeat.i(111900);
    super.dPj();
    this.xbj.setVisibility(8);
    AppMethodBeat.o(111900);
  }
  
  protected final void dPk()
  {
    AppMethodBeat.i(111898);
    super.dPk();
    this.xbj.setVisibility(8);
    AppMethodBeat.o(111898);
  }
  
  protected final void dPl()
  {
    AppMethodBeat.i(111899);
    super.dPl();
    this.xbj.setVisibility(8);
    AppMethodBeat.o(111899);
  }
  
  protected final void dPm()
  {
    AppMethodBeat.i(111897);
    super.dPm();
    this.xbj.setVisibility(0);
    AppMethodBeat.o(111897);
  }
  
  public int getLayoutId()
  {
    return 2131494745;
  }
  
  public void initView()
  {
    AppMethodBeat.i(111892);
    super.initView();
    this.xbj = findViewById(2131307417);
    this.xbj.setVisibility(0);
    RecyclerView localRecyclerView = (RecyclerView)findViewById(2131302138);
    getContext();
    localRecyclerView.setLayoutManager(new GridLayoutManager(3));
    localRecyclerView.a(new RecyclerView.h()
    {
      final int offset;
      Paint paint;
      
      public final void a(Canvas paramAnonymousCanvas, RecyclerView paramAnonymousRecyclerView, RecyclerView.s paramAnonymouss)
      {
        AppMethodBeat.i(111885);
        super.a(paramAnonymousCanvas, paramAnonymousRecyclerView, paramAnonymouss);
        this.paint.setColor(-2434342);
        this.paint.setStrokeWidth(1.0F);
        this.paint.setStyle(Paint.Style.FILL);
        int j = paramAnonymousRecyclerView.getChildCount();
        int i = 0;
        if (i < j)
        {
          paramAnonymouss = paramAnonymousRecyclerView.getChildAt(i);
          if ((i == 1) || (i == 4))
          {
            paramAnonymousCanvas.drawLine(paramAnonymouss.getLeft() - this.offset, paramAnonymouss.getTop(), paramAnonymouss.getLeft() - this.offset, paramAnonymouss.getBottom(), this.paint);
            paramAnonymousCanvas.drawLine(paramAnonymouss.getRight() + this.offset, paramAnonymouss.getTop(), paramAnonymouss.getRight() + this.offset, paramAnonymouss.getBottom(), this.paint);
          }
          for (;;)
          {
            i += 1;
            break;
            if (i == 7) {
              paramAnonymousCanvas.drawLine(paramAnonymouss.getLeft() - this.offset, paramAnonymouss.getTop(), paramAnonymouss.getLeft() - this.offset, paramAnonymouss.getBottom(), this.paint);
            }
          }
        }
        AppMethodBeat.o(111885);
      }
      
      public final void a(Rect paramAnonymousRect, View paramAnonymousView, RecyclerView paramAnonymousRecyclerView, RecyclerView.s paramAnonymouss)
      {
        AppMethodBeat.i(111884);
        super.a(paramAnonymousRect, paramAnonymousView, paramAnonymousRecyclerView, paramAnonymouss);
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
    localb.bm(paramView);
    com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/fts/ui/FTSChattingConvUI", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.axR());
    if (!(paramView instanceof TextView))
    {
      com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/fts/ui/FTSChattingConvUI", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
      AppMethodBeat.o(111904);
      return;
    }
    int i = ((Integer)paramView.getTag()).intValue();
    if (ab.Iw(this.wWS))
    {
      if (i != 0) {
        break label186;
      }
      Log.i("MicroMsg.FTS.FTSChattingConvUI", "onSearchMemberDetail");
      paramView = new Intent();
      paramView.putExtra("from_scene", 1);
      paramView.putExtra("RoomInfo_Id", this.wWS);
      paramView.putExtra("title", getResources().getString(2131765039));
      com.tencent.mm.br.c.f(this, "com.tencent.mm.chatroom.ui.SeeMemberRecordUI", paramView);
    }
    for (;;)
    {
      com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/fts/ui/FTSChattingConvUI", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
      AppMethodBeat.o(111904);
      return;
      i += 1;
      break;
      label186:
      if (i == 1)
      {
        Log.i("MicroMsg.FTS.FTSChattingConvUI", "onSearchDateDetail");
        paramView = new Intent();
        paramView.putExtra("detail_username", this.wWS);
        com.tencent.mm.br.c.f(this, "com.tencent.mm.chatroom.ui.SelectDateUI", paramView);
        pl(0);
      }
      else
      {
        if (i != 2) {
          break label292;
        }
        Log.i("MicroMsg.FTS.FTSChattingConvUI", "onSeeImageVideoHistory");
        paramView = new Intent();
        paramView.putExtra("kintent_talker", this.wWS);
        paramView.putExtra("key_media_type", 1);
        com.tencent.mm.br.c.f(this, "com.tencent.mm.ui.chatting.gallery.MediaHistoryGalleryUI", paramView);
        pl(1);
      }
    }
    label292:
    if (i == 3)
    {
      Log.i("MicroMsg.FTS.FTSChattingConvUI", "onSeeFileHistory");
      localIntent1 = new Intent();
      localIntent1.putExtra("kintent_talker", this.wWS);
      localIntent1.putExtra("key_media_type", 2);
      if ((Build.VERSION.SDK_INT < 21) || (ao.isDarkMode())) {
        break label721;
      }
    }
    label721:
    for (paramView = ActivityOptions.makeSceneTransitionAnimation(this, new Pair[0]).toBundle();; paramView = null)
    {
      com.tencent.mm.br.c.c(this, "com.tencent.mm.ui.chatting.gallery.MediaHistoryListUI", localIntent1, paramView);
      break;
      if (i == 4)
      {
        Log.i("MicroMsg.FTS.FTSChattingConvUI", "onSeeUrlHistory");
        localIntent2 = new Intent();
        localIntent2.putExtra("kintent_talker", this.wWS);
        localIntent2.putExtra("key_media_type", 3);
        paramView = localIntent1;
        if (Build.VERSION.SDK_INT >= 21)
        {
          paramView = localIntent1;
          if (!ao.isDarkMode()) {
            paramView = ActivityOptions.makeSceneTransitionAnimation(this, new Pair[0]).toBundle();
          }
        }
        com.tencent.mm.br.c.c(this, "com.tencent.mm.ui.chatting.gallery.MediaHistoryListUI", localIntent2, paramView);
        break;
      }
      if (i == 5)
      {
        Log.i("MicroMsg.FTS.FTSChattingConvUI", "onSeeUrlHistory");
        localIntent1 = new Intent();
        localIntent1.putExtra("kintent_talker", this.wWS);
        localIntent1.putExtra("key_media_type", 4);
        paramView = localIntent2;
        if (Build.VERSION.SDK_INT >= 21)
        {
          paramView = localIntent2;
          if (!ao.isDarkMode()) {
            paramView = ActivityOptions.makeSceneTransitionAnimation(this, new Pair[0]).toBundle();
          }
        }
        com.tencent.mm.br.c.c(this, "com.tencent.mm.ui.chatting.gallery.MediaHistoryListUI", localIntent1, paramView);
        break;
      }
      if (i == 6)
      {
        Log.i("MicroMsg.FTS.FTSChattingConvUI", "onSeePayHistory");
        localIntent1 = new Intent();
        localIntent1.putExtra("kintent_talker", this.wWS);
        localIntent1.putExtra("key_media_type", 5);
        paramView = localObject1;
        if (Build.VERSION.SDK_INT >= 21)
        {
          paramView = localObject1;
          if (!ao.isDarkMode()) {
            paramView = ActivityOptions.makeSceneTransitionAnimation(this, new Pair[0]).toBundle();
          }
        }
        com.tencent.mm.br.c.c(this, "com.tencent.mm.ui.chatting.gallery.MediaHistoryListUI", localIntent1, paramView);
        break;
      }
      if (i != 7) {
        break;
      }
      Log.i("MicroMsg.FTS.FTSChattingConvUI", "onSeeAppBrandHistory");
      localIntent1 = new Intent();
      localIntent1.putExtra("kintent_talker", this.wWS);
      localIntent1.putExtra("key_media_type", 6);
      paramView = localObject2;
      if (Build.VERSION.SDK_INT >= 21)
      {
        paramView = localObject2;
        if (!ao.isDarkMode()) {
          paramView = ActivityOptions.makeSceneTransitionAnimation(this, new Pair[0]).toBundle();
        }
      }
      com.tencent.mm.br.c.c(this, "com.tencent.mm.ui.chatting.gallery.MediaHistoryListUI", localIntent1, paramView);
      break;
    }
  }
  
  public void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(111891);
    super.onCreate(paramBundle);
    initView();
    paramBundle = ((n)com.tencent.mm.kernel.g.ah(n.class)).getFTSImageLoader();
    if (paramBundle != null) {
      paramBundle.dOn();
    }
    AppMethodBeat.o(111891);
  }
  
  public void onDestroy()
  {
    AppMethodBeat.i(111903);
    super.onDestroy();
    this.xbk.finish();
    com.tencent.mm.plugin.fts.a.d.c localc = ((n)com.tencent.mm.kernel.g.ah(n.class)).getFTSImageLoader();
    if (localc != null) {
      localc.dOl();
    }
    AppMethodBeat.o(111903);
  }
  
  public void onResume()
  {
    AppMethodBeat.i(111893);
    super.onResume();
    this.xbj.postDelayed(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(111886);
        FTSChattingConvUI.this.xaN.getFtsEditText().awD();
        FTSChattingConvUI.this.xaN.getFtsEditText().awC();
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
    String[] xbm;
    
    a()
    {
      AppMethodBeat.i(111887);
      if (!ab.Iw(FTSChattingConvUI.a(FTSChattingConvUI.this)))
      {
        this.xbm = new String[7];
        this.xbm[0] = FTSChattingConvUI.this.getResources().getString(2131765043);
        this.xbm[1] = FTSChattingConvUI.this.getResources().getString(2131765045);
        this.xbm[2] = FTSChattingConvUI.this.getResources().getString(2131765044);
        this.xbm[3] = FTSChattingConvUI.this.getResources().getString(2131765049);
        this.xbm[4] = FTSChattingConvUI.this.getResources().getString(2131765047);
        this.xbm[5] = FTSChattingConvUI.this.getResources().getString(2131765048);
        this.xbm[6] = FTSChattingConvUI.this.getResources().getString(2131765042);
        AppMethodBeat.o(111887);
        return;
      }
      this.xbm = new String[8];
      this.xbm[0] = FTSChattingConvUI.this.getResources().getString(2131765046);
      this.xbm[1] = FTSChattingConvUI.this.getResources().getString(2131765043);
      this.xbm[2] = FTSChattingConvUI.this.getResources().getString(2131765045);
      this.xbm[3] = FTSChattingConvUI.this.getResources().getString(2131765044);
      this.xbm[4] = FTSChattingConvUI.this.getResources().getString(2131765049);
      this.xbm[5] = FTSChattingConvUI.this.getResources().getString(2131765047);
      this.xbm[6] = FTSChattingConvUI.this.getResources().getString(2131765048);
      this.xbm[7] = FTSChattingConvUI.this.getResources().getString(2131765042);
      AppMethodBeat.o(111887);
    }
    
    public final int getItemCount()
    {
      return this.xbm.length;
    }
  }
  
  final class b
    extends RecyclerView.v
  {
    TextView vr;
    
    public b(View paramView)
    {
      super();
      AppMethodBeat.i(111890);
      this.vr = ((TextView)paramView.findViewById(2131309195));
      this.vr.setOnClickListener(FTSChattingConvUI.this);
      AppMethodBeat.o(111890);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.fts.ui.FTSChattingConvUI
 * JD-Core Version:    0.7.0.1
 */