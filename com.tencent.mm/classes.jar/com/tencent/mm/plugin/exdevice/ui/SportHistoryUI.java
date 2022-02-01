package com.tencent.mm.plugin.exdevice.ui;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.graphics.Rect;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.RecyclerView.LayoutManager;
import android.support.v7.widget.RecyclerView.a;
import android.support.v7.widget.RecyclerView.h;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import android.view.View;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.i;
import com.tencent.mm.ak.q;
import com.tencent.mm.ak.t;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.exdevice.g.a.k;
import com.tencent.mm.protocal.protobuf.aes;
import com.tencent.mm.protocal.protobuf.bvp;
import com.tencent.mm.protocal.protobuf.bvq;
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

@l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/exdevice/ui/SportHistoryUI;", "Lcom/tencent/mm/ui/report/MMSecDataActivity;", "Lcom/tencent/mm/modelbase/IOnSceneEnd;", "()V", "adapter", "Lcom/tencent/mm/view/recyclerview/WxRecyclerAdapter;", "Lcom/tencent/mm/plugin/exdevice/ui/SportHistoryUI$HistoryItem;", "getAdapter", "()Lcom/tencent/mm/view/recyclerview/WxRecyclerAdapter;", "setAdapter", "(Lcom/tencent/mm/view/recyclerview/WxRecyclerAdapter;)V", "dataList", "Ljava/util/ArrayList;", "Lkotlin/collections/ArrayList;", "getDataList", "()Ljava/util/ArrayList;", "setDataList", "(Ljava/util/ArrayList;)V", "netSceneGetSportHistory", "Lcom/tencent/mm/plugin/exdevice/rank/model/NetSceneGetSportHistory;", "getNetSceneGetSportHistory", "()Lcom/tencent/mm/plugin/exdevice/rank/model/NetSceneGetSportHistory;", "setNetSceneGetSportHistory", "(Lcom/tencent/mm/plugin/exdevice/rank/model/NetSceneGetSportHistory;)V", "recycleView", "Lcom/tencent/mm/view/recyclerview/WxRecyclerView;", "getRecycleView", "()Lcom/tencent/mm/view/recyclerview/WxRecyclerView;", "setRecycleView", "(Lcom/tencent/mm/view/recyclerview/WxRecyclerView;)V", "buildItemConverts", "Lcom/tencent/mm/view/recyclerview/ItemConvertFactory;", "formatDay", "", "time", "", "getLayoutId", "onCreate", "", "savedInstanceState", "Landroid/os/Bundle;", "onDestroy", "onSceneEnd", "errType", "errCode", "errMsg", "scene", "Lcom/tencent/mm/modelbase/NetSceneBase;", "HistoryItem", "HistoryItemConvert", "app_release"})
public final class SportHistoryUI
  extends MMSecDataActivity
  implements i
{
  private ArrayList<a> kgc;
  WxRecyclerView rHX;
  private k rMF;
  
  public SportHistoryUI()
  {
    AppMethodBeat.i(230635);
    this.kgc = new ArrayList();
    AppMethodBeat.o(230635);
  }
  
  public final int getLayoutId()
  {
    return 2131496541;
  }
  
  public final void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(230632);
    super.onCreate(paramBundle);
    setMMTitle(2131758908);
    setBackBtn((MenuItem.OnMenuItemClickListener)new d(this));
    this.rHX = ((WxRecyclerView)findViewById(2131306757));
    paramBundle = this.rHX;
    if (paramBundle != null) {
      paramBundle.setLayoutManager((RecyclerView.LayoutManager)new LinearLayoutManager(1, false));
    }
    paramBundle = this.rHX;
    if (paramBundle != null) {
      paramBundle.setAdapter((RecyclerView.a)new WxRecyclerAdapter((f)new c(this), this.kgc));
    }
    paramBundle = this.rHX;
    if (paramBundle != null) {
      paramBundle.b((RecyclerView.h)new e(this));
    }
    g.azz().a(4835, (i)this);
    paramBundle = new bvp();
    paramBundle.username = getIntent().getStringExtra("username");
    this.rMF = new k(paramBundle);
    g.azz().b((q)this.rMF);
    AppMethodBeat.o(230632);
  }
  
  public final void onDestroy()
  {
    AppMethodBeat.i(230633);
    k localk = this.rMF;
    if (localk != null) {
      g.azz().a((q)localk);
    }
    g.azz().b(4835, (i)this);
    super.onDestroy();
    AppMethodBeat.o(230633);
  }
  
  public final void onSceneEnd(int paramInt1, int paramInt2, String paramString, q paramq)
  {
    AppMethodBeat.i(230634);
    if ((paramInt1 == 0) && (paramInt2 == 0))
    {
      paramString = this.rMF;
      if (paramString != null)
      {
        paramString = paramString.rCP;
        if (paramString != null)
        {
          paramString = paramString.MbD;
          if (paramString != null)
          {
            paramString = (Iterable)paramString;
            paramInt1 = 0;
            paramString = paramString.iterator();
            while (paramString.hasNext())
            {
              paramq = paramString.next();
              if (paramInt1 < 0) {
                j.hxH();
              }
              paramq = (aes)paramq;
              ArrayList localArrayList = this.kgc;
              long l = paramInt1;
              p.g(paramq, "dailySportRecord");
              localArrayList.add(new a(l, paramq));
              paramInt1 += 1;
            }
          }
        }
      }
      paramString = this.rHX;
      if (paramString != null)
      {
        paramString = paramString.getAdapter();
        if (paramString != null) {
          paramString.notifyDataSetChanged();
        }
      }
    }
    paramString = findViewById(2131303694);
    p.g(paramString, "findViewById<View>(R.id.loading_bar)");
    paramString.setVisibility(8);
    this.rMF = null;
    AppMethodBeat.o(230634);
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/exdevice/ui/SportHistoryUI$HistoryItem;", "Lcom/tencent/mm/view/recyclerview/ConvertData;", "id", "", "record", "Lcom/tencent/mm/protocal/protobuf/DailySportRecord;", "(Lcom/tencent/mm/plugin/exdevice/ui/SportHistoryUI;JLcom/tencent/mm/protocal/protobuf/DailySportRecord;)V", "getId", "()J", "getRecord", "()Lcom/tencent/mm/protocal/protobuf/DailySportRecord;", "getItemId", "getItemType", "", "app_release"})
  public final class a
    implements com.tencent.mm.view.recyclerview.a
  {
    private final long id;
    final aes rMG;
    
    public a(aes paramaes)
    {
      AppMethodBeat.i(230621);
      this.id = ???;
      this.rMG = localObject;
      AppMethodBeat.o(230621);
    }
    
    public final int cxn()
    {
      return 3;
    }
    
    public final long lT()
    {
      return this.id;
    }
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"com/tencent/mm/plugin/exdevice/ui/SportHistoryUI$buildItemConverts$1", "Lcom/tencent/mm/view/recyclerview/ItemConvertFactory;", "getItemConvert", "Lcom/tencent/mm/view/recyclerview/ItemConvert;", "type", "", "app_release"})
  public static final class c
    implements f
  {
    public final e<?> EC(int paramInt)
    {
      AppMethodBeat.i(230629);
      e locale = (e)new SportHistoryUI.b(this.rMH);
      AppMethodBeat.o(230629);
      return locale;
    }
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "it", "Landroid/view/MenuItem;", "kotlin.jvm.PlatformType", "onMenuItemClick"})
  static final class d
    implements MenuItem.OnMenuItemClickListener
  {
    d(SportHistoryUI paramSportHistoryUI) {}
    
    public final boolean onMenuItemClick(MenuItem paramMenuItem)
    {
      AppMethodBeat.i(230630);
      this.rMH.finish();
      AppMethodBeat.o(230630);
      return true;
    }
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"com/tencent/mm/plugin/exdevice/ui/SportHistoryUI$onCreate$2", "Landroid/support/v7/widget/RecyclerView$ItemDecoration;", "getItemOffsets", "", "outRect", "Landroid/graphics/Rect;", "itemPosition", "", "parent", "Landroid/support/v7/widget/RecyclerView;", "app_release"})
  public static final class e
    extends RecyclerView.h
  {
    public final void a(Rect paramRect, int paramInt, RecyclerView paramRecyclerView)
    {
      AppMethodBeat.i(230631);
      p.h(paramRect, "outRect");
      p.h(paramRecyclerView, "parent");
      paramRecyclerView = this.rMH.rHX;
      if (paramRecyclerView != null)
      {
        paramRecyclerView = paramRecyclerView.getAdapter();
        if (paramRecyclerView == null) {}
      }
      for (int i = paramRecyclerView.getItemCount();; i = 1)
      {
        if (paramInt == i - 1) {
          paramRect.bottom = com.tencent.mm.cb.a.fromDPToPix((Context)this.rMH, 16);
        }
        AppMethodBeat.o(230631);
        return;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.exdevice.ui.SportHistoryUI
 * JD-Core Version:    0.7.0.1
 */