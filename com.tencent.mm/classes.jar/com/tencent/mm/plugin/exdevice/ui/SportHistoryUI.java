package com.tencent.mm.plugin.exdevice.ui;

import android.content.Context;
import android.content.Intent;
import android.graphics.Rect;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.RecyclerView.LayoutManager;
import androidx.recyclerview.widget.RecyclerView.a;
import androidx.recyclerview.widget.RecyclerView.b;
import androidx.recyclerview.widget.RecyclerView.h;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R.h;
import com.tencent.mm.R.i;
import com.tencent.mm.R.l;
import com.tencent.mm.plugin.exdevice.g.a.k;
import com.tencent.mm.plugin.secdata.ui.MMSecDataActivity;
import com.tencent.mm.protocal.protobuf.ahn;
import com.tencent.mm.protocal.protobuf.csv;
import com.tencent.mm.protocal.protobuf.csw;
import com.tencent.mm.view.recyclerview.WxRecyclerAdapter;
import com.tencent.mm.view.recyclerview.WxRecyclerView;
import com.tencent.mm.view.recyclerview.f;
import com.tencent.mm.view.recyclerview.g;
import java.util.ArrayList;
import java.util.Iterator;
import kotlin.Metadata;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/exdevice/ui/SportHistoryUI;", "Lcom/tencent/mm/plugin/secdata/ui/MMSecDataActivity;", "Lcom/tencent/mm/modelbase/IOnSceneEnd;", "()V", "adapter", "Lcom/tencent/mm/view/recyclerview/WxRecyclerAdapter;", "Lcom/tencent/mm/plugin/exdevice/ui/SportHistoryUI$HistoryItem;", "getAdapter", "()Lcom/tencent/mm/view/recyclerview/WxRecyclerAdapter;", "setAdapter", "(Lcom/tencent/mm/view/recyclerview/WxRecyclerAdapter;)V", "dataList", "Ljava/util/ArrayList;", "Lkotlin/collections/ArrayList;", "getDataList", "()Ljava/util/ArrayList;", "setDataList", "(Ljava/util/ArrayList;)V", "netSceneGetSportHistory", "Lcom/tencent/mm/plugin/exdevice/rank/model/NetSceneGetSportHistory;", "getNetSceneGetSportHistory", "()Lcom/tencent/mm/plugin/exdevice/rank/model/NetSceneGetSportHistory;", "setNetSceneGetSportHistory", "(Lcom/tencent/mm/plugin/exdevice/rank/model/NetSceneGetSportHistory;)V", "recycleView", "Lcom/tencent/mm/view/recyclerview/WxRecyclerView;", "getRecycleView", "()Lcom/tencent/mm/view/recyclerview/WxRecyclerView;", "setRecycleView", "(Lcom/tencent/mm/view/recyclerview/WxRecyclerView;)V", "buildItemConverts", "Lcom/tencent/mm/view/recyclerview/ItemConvertFactory;", "formatDay", "", "time", "", "getLayoutId", "initSportRecordList", "Ljava/util/LinkedList;", "Lcom/tencent/mm/protocal/protobuf/SportRecord;", "record", "Lcom/tencent/mm/protocal/protobuf/DailySportRecord;", "onCreate", "", "savedInstanceState", "Landroid/os/Bundle;", "onDestroy", "onSceneEnd", "errType", "errCode", "errMsg", "scene", "Lcom/tencent/mm/modelbase/NetSceneBase;", "setFixedTextSize", "textView", "Landroid/widget/TextView;", "size", "", "HistoryItem", "HistoryItemConvert", "app_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class SportHistoryUI
  extends MMSecDataActivity
  implements com.tencent.mm.am.h
{
  private ArrayList<a> pUj;
  WxRecyclerView yAg;
  private k yEE;
  
  public SportHistoryUI()
  {
    AppMethodBeat.i(274781);
    this.pUj = new ArrayList();
    AppMethodBeat.o(274781);
  }
  
  private static final boolean a(SportHistoryUI paramSportHistoryUI, MenuItem paramMenuItem)
  {
    AppMethodBeat.i(274785);
    kotlin.g.b.s.u(paramSportHistoryUI, "this$0");
    paramSportHistoryUI.finish();
    AppMethodBeat.o(274785);
    return true;
  }
  
  public final int getLayoutId()
  {
    return R.i.gox;
  }
  
  public final void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(274803);
    super.onCreate(paramBundle);
    setMMTitle(R.l.gGU);
    setBackBtn(new SportHistoryUI..ExternalSyntheticLambda0(this));
    this.yAg = ((WxRecyclerView)findViewById(R.h.recycler_view));
    paramBundle = this.yAg;
    if (paramBundle != null) {
      paramBundle.setLayoutManager((RecyclerView.LayoutManager)new LinearLayoutManager(1, false));
    }
    paramBundle = this.yAg;
    if (paramBundle != null) {
      paramBundle.setAdapter((RecyclerView.a)new WxRecyclerAdapter((g)new c(this), this.pUj));
    }
    paramBundle = this.yAg;
    if (paramBundle != null) {
      paramBundle.a((RecyclerView.h)new d(this));
    }
    com.tencent.mm.kernel.h.aZW().a(4835, (com.tencent.mm.am.h)this);
    paramBundle = new csv();
    paramBundle.username = getIntent().getStringExtra("username");
    this.yEE = new k(paramBundle);
    com.tencent.mm.kernel.h.aZW().a((com.tencent.mm.am.p)this.yEE, 0);
    AppMethodBeat.o(274803);
  }
  
  public final void onDestroy()
  {
    AppMethodBeat.i(274805);
    k localk = this.yEE;
    if (localk != null) {
      com.tencent.mm.kernel.h.aZW().a((com.tencent.mm.am.p)localk);
    }
    com.tencent.mm.kernel.h.aZW().b(4835, (com.tencent.mm.am.h)this);
    super.onDestroy();
    AppMethodBeat.o(274805);
  }
  
  public final void onSceneEnd(int paramInt1, int paramInt2, String paramString, com.tencent.mm.am.p paramp)
  {
    AppMethodBeat.i(274809);
    if ((paramInt1 == 0) && (paramInt2 == 0))
    {
      paramString = this.yEE;
      if (paramString != null)
      {
        paramString = paramString.yuz;
        if (paramString != null)
        {
          paramString = paramString.aayN;
          if (paramString != null)
          {
            paramString = (Iterable)paramString;
            paramInt1 = 0;
            paramString = paramString.iterator();
            while (paramString.hasNext())
            {
              paramp = paramString.next();
              if (paramInt1 < 0) {
                kotlin.a.p.kkW();
              }
              paramp = (ahn)paramp;
              ArrayList localArrayList = this.pUj;
              long l = paramInt1;
              kotlin.g.b.s.s(paramp, "dailySportRecord");
              localArrayList.add(new a(l, paramp));
              paramInt1 += 1;
            }
          }
        }
      }
      paramString = this.yAg;
      if (paramString != null)
      {
        paramString = paramString.getAdapter();
        if (paramString != null) {
          paramString.bZE.notifyChanged();
        }
      }
    }
    findViewById(R.h.loading_bar).setVisibility(8);
    this.yEE = null;
    AppMethodBeat.o(274809);
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
  
  @Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/exdevice/ui/SportHistoryUI$HistoryItem;", "Lcom/tencent/mm/view/recyclerview/ConvertData;", "id", "", "record", "Lcom/tencent/mm/protocal/protobuf/DailySportRecord;", "(Lcom/tencent/mm/plugin/exdevice/ui/SportHistoryUI;JLcom/tencent/mm/protocal/protobuf/DailySportRecord;)V", "getId", "()J", "getRecord", "()Lcom/tencent/mm/protocal/protobuf/DailySportRecord;", "getItemId", "getItemType", "", "app_release"}, k=1, mv={1, 5, 1}, xi=48)
  public final class a
    implements com.tencent.mm.view.recyclerview.a
  {
    private final long id;
    final ahn yEF;
    
    public a(ahn paramahn)
    {
      AppMethodBeat.i(274740);
      this.id = ???;
      this.yEF = localObject;
      AppMethodBeat.o(274740);
    }
    
    public final long bZA()
    {
      return this.id;
    }
    
    public final int bZB()
    {
      return 5;
    }
  }
  
  @Metadata(d1={""}, d2={"com/tencent/mm/plugin/exdevice/ui/SportHistoryUI$buildItemConverts$1", "Lcom/tencent/mm/view/recyclerview/ItemConvertFactory;", "getItemConvert", "Lcom/tencent/mm/view/recyclerview/ItemConvert;", "type", "", "app_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class c
    implements g
  {
    c(SportHistoryUI paramSportHistoryUI) {}
    
    public final f<?> yF(int paramInt)
    {
      AppMethodBeat.i(274742);
      f localf = (f)new SportHistoryUI.b(this.yEG);
      AppMethodBeat.o(274742);
      return localf;
    }
  }
  
  @Metadata(d1={""}, d2={"com/tencent/mm/plugin/exdevice/ui/SportHistoryUI$onCreate$2", "Landroidx/recyclerview/widget/RecyclerView$ItemDecoration;", "getItemOffsets", "", "outRect", "Landroid/graphics/Rect;", "itemPosition", "", "parent", "Landroidx/recyclerview/widget/RecyclerView;", "app_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class d
    extends RecyclerView.h
  {
    d(SportHistoryUI paramSportHistoryUI) {}
    
    public final void a(Rect paramRect, int paramInt, RecyclerView paramRecyclerView)
    {
      int i = 1;
      AppMethodBeat.i(274745);
      kotlin.g.b.s.u(paramRect, "outRect");
      kotlin.g.b.s.u(paramRecyclerView, "parent");
      paramRecyclerView = this.yEG.yAg;
      if (paramRecyclerView == null) {}
      for (;;)
      {
        if (paramInt == i - 1) {
          paramRect.bottom = com.tencent.mm.cd.a.fromDPToPix((Context)this.yEG, 16);
        }
        AppMethodBeat.o(274745);
        return;
        paramRecyclerView = paramRecyclerView.getAdapter();
        if (paramRecyclerView != null) {
          i = paramRecyclerView.getItemCount();
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.exdevice.ui.SportHistoryUI
 * JD-Core Version:    0.7.0.1
 */