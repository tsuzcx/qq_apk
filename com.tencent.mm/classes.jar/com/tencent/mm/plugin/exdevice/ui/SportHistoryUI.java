package com.tencent.mm.plugin.exdevice.ui;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.graphics.Rect;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import android.view.View;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.RecyclerView.LayoutManager;
import androidx.recyclerview.widget.RecyclerView.a;
import androidx.recyclerview.widget.RecyclerView.h;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R.h;
import com.tencent.mm.R.i;
import com.tencent.mm.R.l;
import com.tencent.mm.an.i;
import com.tencent.mm.an.q;
import com.tencent.mm.an.t;
import com.tencent.mm.kernel.h;
import com.tencent.mm.plugin.exdevice.g.a.k;
import com.tencent.mm.protocal.protobuf.afb;
import com.tencent.mm.protocal.protobuf.cdh;
import com.tencent.mm.protocal.protobuf.cdi;
import com.tencent.mm.ui.report.MMSecDataActivity;
import com.tencent.mm.view.recyclerview.WxRecyclerAdapter;
import com.tencent.mm.view.recyclerview.WxRecyclerView;
import com.tencent.mm.view.recyclerview.e;
import com.tencent.mm.view.recyclerview.f;
import java.util.ArrayList;
import java.util.Iterator;
import kotlin.a.j;
import kotlin.g.b.p;
import kotlin.l;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/exdevice/ui/SportHistoryUI;", "Lcom/tencent/mm/ui/report/MMSecDataActivity;", "Lcom/tencent/mm/modelbase/IOnSceneEnd;", "()V", "adapter", "Lcom/tencent/mm/view/recyclerview/WxRecyclerAdapter;", "Lcom/tencent/mm/plugin/exdevice/ui/SportHistoryUI$HistoryItem;", "getAdapter", "()Lcom/tencent/mm/view/recyclerview/WxRecyclerAdapter;", "setAdapter", "(Lcom/tencent/mm/view/recyclerview/WxRecyclerAdapter;)V", "dataList", "Ljava/util/ArrayList;", "Lkotlin/collections/ArrayList;", "getDataList", "()Ljava/util/ArrayList;", "setDataList", "(Ljava/util/ArrayList;)V", "netSceneGetSportHistory", "Lcom/tencent/mm/plugin/exdevice/rank/model/NetSceneGetSportHistory;", "getNetSceneGetSportHistory", "()Lcom/tencent/mm/plugin/exdevice/rank/model/NetSceneGetSportHistory;", "setNetSceneGetSportHistory", "(Lcom/tencent/mm/plugin/exdevice/rank/model/NetSceneGetSportHistory;)V", "recycleView", "Lcom/tencent/mm/view/recyclerview/WxRecyclerView;", "getRecycleView", "()Lcom/tencent/mm/view/recyclerview/WxRecyclerView;", "setRecycleView", "(Lcom/tencent/mm/view/recyclerview/WxRecyclerView;)V", "buildItemConverts", "Lcom/tencent/mm/view/recyclerview/ItemConvertFactory;", "formatDay", "", "time", "", "getLayoutId", "onCreate", "", "savedInstanceState", "Landroid/os/Bundle;", "onDestroy", "onSceneEnd", "errType", "errCode", "errMsg", "scene", "Lcom/tencent/mm/modelbase/NetSceneBase;", "HistoryItem", "HistoryItemConvert", "app_release"})
public final class SportHistoryUI
  extends MMSecDataActivity
  implements i
{
  private ArrayList<a> mXB;
  WxRecyclerView vnF;
  private k vsp;
  
  public SportHistoryUI()
  {
    AppMethodBeat.i(281163);
    this.mXB = new ArrayList();
    AppMethodBeat.o(281163);
  }
  
  public final int getLayoutId()
  {
    return R.i.els;
  }
  
  public final void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(281160);
    super.onCreate(paramBundle);
    setMMTitle(R.l.eEe);
    setBackBtn((MenuItem.OnMenuItemClickListener)new d(this));
    this.vnF = ((WxRecyclerView)findViewById(R.h.recycler_view));
    paramBundle = this.vnF;
    if (paramBundle != null) {
      paramBundle.setLayoutManager((RecyclerView.LayoutManager)new LinearLayoutManager(1, false));
    }
    paramBundle = this.vnF;
    if (paramBundle != null) {
      paramBundle.setAdapter((RecyclerView.a)new WxRecyclerAdapter((f)new c(this), this.mXB));
    }
    paramBundle = this.vnF;
    if (paramBundle != null) {
      paramBundle.b((RecyclerView.h)new e(this));
    }
    h.aGY().a(4835, (i)this);
    paramBundle = new cdh();
    paramBundle.username = getIntent().getStringExtra("username");
    this.vsp = new k(paramBundle);
    h.aGY().b((q)this.vsp);
    AppMethodBeat.o(281160);
  }
  
  public final void onDestroy()
  {
    AppMethodBeat.i(281161);
    k localk = this.vsp;
    if (localk != null) {
      h.aGY().a((q)localk);
    }
    h.aGY().b(4835, (i)this);
    super.onDestroy();
    AppMethodBeat.o(281161);
  }
  
  public final void onSceneEnd(int paramInt1, int paramInt2, String paramString, q paramq)
  {
    AppMethodBeat.i(281162);
    if ((paramInt1 == 0) && (paramInt2 == 0))
    {
      paramString = this.vsp;
      if (paramString != null)
      {
        paramString = paramString.viz;
        if (paramString != null)
        {
          paramString = paramString.Tlf;
          if (paramString != null)
          {
            paramString = (Iterable)paramString;
            paramInt1 = 0;
            paramString = paramString.iterator();
            while (paramString.hasNext())
            {
              paramq = paramString.next();
              if (paramInt1 < 0) {
                j.iBO();
              }
              paramq = (afb)paramq;
              ArrayList localArrayList = this.mXB;
              long l = paramInt1;
              p.j(paramq, "dailySportRecord");
              localArrayList.add(new a(l, paramq));
              paramInt1 += 1;
            }
          }
        }
      }
      paramString = this.vnF;
      if (paramString != null)
      {
        paramString = paramString.getAdapter();
        if (paramString != null) {
          paramString.notifyDataSetChanged();
        }
      }
    }
    paramString = findViewById(R.h.loading_bar);
    p.j(paramString, "findViewById<View>(R.id.loading_bar)");
    paramString.setVisibility(8);
    this.vsp = null;
    AppMethodBeat.o(281162);
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/exdevice/ui/SportHistoryUI$HistoryItem;", "Lcom/tencent/mm/view/recyclerview/ConvertData;", "id", "", "record", "Lcom/tencent/mm/protocal/protobuf/DailySportRecord;", "(Lcom/tencent/mm/plugin/exdevice/ui/SportHistoryUI;JLcom/tencent/mm/protocal/protobuf/DailySportRecord;)V", "getId", "()J", "getRecord", "()Lcom/tencent/mm/protocal/protobuf/DailySportRecord;", "getItemId", "getItemType", "", "app_release"})
  public final class a
    implements com.tencent.mm.view.recyclerview.a
  {
    private final long id;
    final afb vsq;
    
    public a(afb paramafb)
    {
      AppMethodBeat.i(265380);
      this.id = ???;
      this.vsq = localObject;
      AppMethodBeat.o(265380);
    }
    
    public final int bAQ()
    {
      return 3;
    }
    
    public final long mf()
    {
      return this.id;
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"com/tencent/mm/plugin/exdevice/ui/SportHistoryUI$buildItemConverts$1", "Lcom/tencent/mm/view/recyclerview/ItemConvertFactory;", "getItemConvert", "Lcom/tencent/mm/view/recyclerview/ItemConvert;", "type", "", "app_release"})
  public static final class c
    implements f
  {
    public final e<?> yx(int paramInt)
    {
      AppMethodBeat.i(278655);
      e locale = (e)new SportHistoryUI.b(this.vsr);
      AppMethodBeat.o(278655);
      return locale;
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "it", "Landroid/view/MenuItem;", "kotlin.jvm.PlatformType", "onMenuItemClick"})
  static final class d
    implements MenuItem.OnMenuItemClickListener
  {
    d(SportHistoryUI paramSportHistoryUI) {}
    
    public final boolean onMenuItemClick(MenuItem paramMenuItem)
    {
      AppMethodBeat.i(205968);
      this.vsr.finish();
      AppMethodBeat.o(205968);
      return true;
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"com/tencent/mm/plugin/exdevice/ui/SportHistoryUI$onCreate$2", "Landroidx/recyclerview/widget/RecyclerView$ItemDecoration;", "getItemOffsets", "", "outRect", "Landroid/graphics/Rect;", "itemPosition", "", "parent", "Landroidx/recyclerview/widget/RecyclerView;", "app_release"})
  public static final class e
    extends RecyclerView.h
  {
    public final void a(Rect paramRect, int paramInt, RecyclerView paramRecyclerView)
    {
      AppMethodBeat.i(252469);
      p.k(paramRect, "outRect");
      p.k(paramRecyclerView, "parent");
      paramRecyclerView = this.vsr.vnF;
      if (paramRecyclerView != null)
      {
        paramRecyclerView = paramRecyclerView.getAdapter();
        if (paramRecyclerView == null) {}
      }
      for (int i = paramRecyclerView.getItemCount();; i = 1)
      {
        if (paramInt == i - 1) {
          paramRect.bottom = com.tencent.mm.ci.a.fromDPToPix((Context)this.vsr, 16);
        }
        AppMethodBeat.o(252469);
        return;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.exdevice.ui.SportHistoryUI
 * JD-Core Version:    0.7.0.1
 */