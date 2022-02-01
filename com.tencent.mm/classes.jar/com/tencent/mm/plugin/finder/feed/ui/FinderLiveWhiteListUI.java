package com.tencent.mm.plugin.finder.feed.ui;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewGroup.MarginLayoutParams;
import android.view.Window;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.RecyclerView.LayoutManager;
import androidx.recyclerview.widget.RecyclerView.a;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.hellhoundlib.b.b;
import com.tencent.mm.plugin.finder.b.f;
import com.tencent.mm.plugin.finder.b.g;
import com.tencent.mm.plugin.finder.live.view.adapter.aa;
import com.tencent.mm.plugin.finder.live.view.adapter.aa.c;
import com.tencent.mm.plugin.finder.ui.MMFinderUI;
import com.tencent.mm.plugin.findersdk.a.d;
import com.tencent.mm.protocal.protobuf.ayj;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.ui.ax;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import kotlin.a.j;
import kotlin.g.b.p;
import kotlin.g.b.q;
import kotlin.l;
import kotlin.x;

@com.tencent.mm.ui.base.a(32)
@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/finder/feed/ui/FinderLiveWhiteListUI;", "Lcom/tencent/mm/plugin/finder/ui/MMFinderUI;", "Landroid/view/View$OnClickListener;", "()V", "cancelTv", "Landroid/widget/TextView;", "chooseWhiteList", "Ljava/util/LinkedList;", "Lcom/tencent/mm/protocal/protobuf/FinderLiveAudienceListFile;", "getChooseWhiteList", "()Ljava/util/LinkedList;", "setChooseWhiteList", "(Ljava/util/LinkedList;)V", "contentView", "Landroidx/recyclerview/widget/RecyclerView;", "finishTv", "titleGroup", "Landroid/view/View;", "visitorWhiteList", "getVisitorWhiteList", "setVisitorWhiteList", "whiteListAdapter", "Lcom/tencent/mm/plugin/finder/live/view/adapter/FinderLiveWhiteListAdapter;", "whiteListWrapper", "Lcom/tencent/mm/plugin/finder/live/view/adapter/FinderLiveWhiteListAdapter$FinderLiveAudienceListFileWrapper;", "getWhiteListWrapper", "setWhiteListWrapper", "getLayoutId", "", "getReportTag", "", "handleFinish", "", "initLogic", "initViews", "mergeWhiteList", "onClick", "v", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "parseInten", "setWindowStyle", "updateChooseList", "Companion", "plugin-finder-live_release"})
public final class FinderLiveWhiteListUI
  extends MMFinderUI
  implements View.OnClickListener
{
  public static final a xQz;
  private HashMap _$_findViewCache;
  private View kGo;
  private TextView xPY;
  private TextView xPZ;
  private LinkedList<ayj> xQn;
  private LinkedList<ayj> xQo;
  private RecyclerView xQw;
  private aa xQx;
  private LinkedList<aa.c> xQy;
  
  static
  {
    AppMethodBeat.i(233940);
    xQz = new a((byte)0);
    AppMethodBeat.o(233940);
  }
  
  public FinderLiveWhiteListUI()
  {
    AppMethodBeat.i(233938);
    this.xQn = new LinkedList();
    this.xQo = new LinkedList();
    this.xQy = new LinkedList();
    AppMethodBeat.o(233938);
  }
  
  public final void _$_clearFindViewByIdCache()
  {
    AppMethodBeat.i(233951);
    if (this._$_findViewCache != null) {
      this._$_findViewCache.clear();
    }
    AppMethodBeat.o(233951);
  }
  
  public final View _$_findCachedViewById(int paramInt)
  {
    AppMethodBeat.i(233950);
    if (this._$_findViewCache == null) {
      this._$_findViewCache = new HashMap();
    }
    View localView2 = (View)this._$_findViewCache.get(Integer.valueOf(paramInt));
    View localView1 = localView2;
    if (localView2 == null)
    {
      localView1 = findViewById(paramInt);
      this._$_findViewCache.put(Integer.valueOf(paramInt), localView1);
    }
    AppMethodBeat.o(233950);
    return localView1;
  }
  
  public final String dvl()
  {
    return "Finder.FinderLiveWhiteListUI";
  }
  
  public final int getLayoutId()
  {
    return b.g.finder_live_white_list_ui;
  }
  
  public final void onClick(View paramView)
  {
    AppMethodBeat.i(233935);
    Object localObject1 = new b();
    ((b)localObject1).bn(paramView);
    com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/finder/feed/ui/FinderLiveWhiteListUI", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, ((b)localObject1).aFi());
    int i;
    if (paramView != null)
    {
      paramView = Integer.valueOf(paramView.getId());
      i = b.f.finish_tv;
      if (paramView != null) {
        break label85;
      }
      label54:
      i = b.f.cancel_tv;
      if (paramView != null) {
        break label300;
      }
    }
    for (;;)
    {
      com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/finder/feed/ui/FinderLiveWhiteListUI", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
      AppMethodBeat.o(233935);
      return;
      paramView = null;
      break;
      label85:
      if (paramView.intValue() != i) {
        break label54;
      }
      paramView = new Intent();
      localObject1 = a.d.BuY;
      localObject1 = a.d.emZ();
      Object localObject2 = (Iterable)this.xQo;
      Collection localCollection = (Collection)new ArrayList(j.a((Iterable)localObject2, 10));
      localObject2 = ((Iterable)localObject2).iterator();
      while (((Iterator)localObject2).hasNext()) {
        localCollection.add(((ayj)((Iterator)localObject2).next()).toByteArray());
      }
      paramView.putExtra((String)localObject1, (Serializable)localCollection);
      localObject1 = a.d.BuY;
      localObject1 = a.d.emZ();
      localObject2 = (Iterable)this.xQo;
      localCollection = (Collection)new ArrayList(j.a((Iterable)localObject2, 10));
      localObject2 = ((Iterable)localObject2).iterator();
      while (((Iterator)localObject2).hasNext()) {
        localCollection.add(((ayj)((Iterator)localObject2).next()).toByteArray());
      }
      paramView.putExtra((String)localObject1, (Serializable)localCollection);
      setResult(-1, paramView);
      finish();
      continue;
      label300:
      if (paramView.intValue() == i)
      {
        setResult(0);
        finish();
      }
    }
  }
  
  public final void onCreate(Bundle paramBundle)
  {
    Object localObject1 = null;
    AppMethodBeat.i(233934);
    supportRequestWindowFeature(1);
    super.onCreate(paramBundle);
    paramBundle = getContext();
    p.j(paramBundle, "context");
    paramBundle.getWindow().addFlags(2097280);
    paramBundle = getContext();
    p.j(paramBundle, "context");
    paramBundle.getWindow().addFlags(67108864);
    if (Build.VERSION.SDK_INT >= 21)
    {
      paramBundle = getContext();
      p.j(paramBundle, "context");
      paramBundle.getWindow().clearFlags(67108864);
      paramBundle = getContext();
      p.j(paramBundle, "context");
      paramBundle = paramBundle.getWindow();
      p.j(paramBundle, "context.window");
      paramBundle = paramBundle.getDecorView();
      p.j(paramBundle, "context.window.decorView");
      paramBundle.setSystemUiVisibility(1792);
      paramBundle = getContext();
      p.j(paramBundle, "context");
      paramBundle.getWindow().addFlags(-2147483648);
      paramBundle = getContext();
      p.j(paramBundle, "context");
      paramBundle = paramBundle.getWindow();
      p.j(paramBundle, "context.window");
      paramBundle.setStatusBarColor(0);
      paramBundle = getContext();
      p.j(paramBundle, "context");
      paramBundle = paramBundle.getWindow();
      p.j(paramBundle, "context.window");
      paramBundle.setNavigationBarColor(0);
    }
    paramBundle = getContext();
    p.j(paramBundle, "context");
    paramBundle.getWindow().setFormat(-3);
    paramBundle = getContext();
    p.j(paramBundle, "context");
    paramBundle.getWindow().setSoftInputMode(51);
    this.kGo = findViewById(b.f.title_group);
    paramBundle = this.kGo;
    if (paramBundle != null) {
      paramBundle.post((Runnable)new c(this));
    }
    this.xPY = ((TextView)findViewById(b.f.cancel_tv));
    this.xPZ = ((TextView)findViewById(b.f.finish_tv));
    this.xQw = ((RecyclerView)findViewById(b.f.white_list_content_rv));
    paramBundle = this.xPZ;
    if (paramBundle != null) {
      paramBundle.setOnClickListener((View.OnClickListener)this);
    }
    paramBundle = this.xPY;
    if (paramBundle != null) {
      paramBundle.setOnClickListener((View.OnClickListener)this);
    }
    paramBundle = new aa();
    paramBundle.zao = ((kotlin.g.a.a)new b(this));
    this.xQx = paramBundle;
    Object localObject3 = this.xQw;
    if (localObject3 != null)
    {
      ((RecyclerView)localObject3).getContext();
      ((RecyclerView)localObject3).setLayoutManager((RecyclerView.LayoutManager)new LinearLayoutManager(1, false));
      ((RecyclerView)localObject3).setAdapter((RecyclerView.a)this.xQx);
      localObject2 = ((RecyclerView)localObject3).getLayoutParams();
      paramBundle = (Bundle)localObject2;
      if (!(localObject2 instanceof ViewGroup.MarginLayoutParams)) {
        paramBundle = null;
      }
      paramBundle = (ViewGroup.MarginLayoutParams)paramBundle;
      if (paramBundle != null) {
        paramBundle.bottomMargin = ax.aB(((RecyclerView)localObject3).getContext());
      }
    }
    paramBundle = getIntent();
    Object localObject2 = a.d.BuY;
    localObject2 = paramBundle.getSerializableExtra(a.d.emY());
    paramBundle = (Bundle)localObject2;
    if (!(localObject2 instanceof List)) {
      paramBundle = null;
    }
    paramBundle = (List)paramBundle;
    if (paramBundle != null)
    {
      localObject2 = com.tencent.mm.plugin.finder.live.utils.a.yRm;
      com.tencent.mm.plugin.finder.live.utils.a.a(paramBundle, this.xQn);
    }
    paramBundle = getIntent();
    localObject2 = a.d.BuY;
    localObject2 = paramBundle.getSerializableExtra(a.d.emZ());
    paramBundle = (Bundle)localObject2;
    if (!(localObject2 instanceof List)) {
      paramBundle = null;
    }
    paramBundle = (List)paramBundle;
    if (paramBundle != null)
    {
      localObject2 = com.tencent.mm.plugin.finder.live.utils.a.yRm;
      com.tencent.mm.plugin.finder.live.utils.a.a(paramBundle, this.xQo);
    }
    this.xQy.clear();
    localObject2 = ((Iterable)this.xQn).iterator();
    Object localObject4;
    if (((Iterator)localObject2).hasNext())
    {
      localObject3 = (ayj)((Iterator)localObject2).next();
      localObject4 = ((Iterable)this.xQo).iterator();
      while (((Iterator)localObject4).hasNext())
      {
        paramBundle = ((Iterator)localObject4).next();
        if (p.h(((ayj)paramBundle).RRY, ((ayj)localObject3).RRY)) {
          label688:
          if (paramBundle == null) {
            break label720;
          }
        }
      }
      label720:
      for (boolean bool = true;; bool = false)
      {
        this.xQy.add(new aa.c(bool, (ayj)localObject3));
        break;
        paramBundle = null;
        break label688;
      }
    }
    localObject2 = this.xQx;
    if (localObject2 != null)
    {
      localObject3 = this.xQy;
      localObject4 = new StringBuilder("updateWhiteList,ori size:").append(((aa)localObject2).syG.size()).append(",new size:");
      paramBundle = localObject1;
      if (localObject3 != null) {
        paramBundle = Integer.valueOf(((LinkedList)localObject3).size());
      }
      Log.i("FinderLiveWhiteListAdapter", paramBundle);
      if (localObject3 != null)
      {
        ((aa)localObject2).syG.clear();
        ((aa)localObject2).syG.addAll((Collection)localObject3);
        ((aa)localObject2).syG.add(new aa.c(false, new ayj(), 2));
      }
    }
    paramBundle = this.xQx;
    if (paramBundle != null) {
      paramBundle.notifyDataSetChanged();
    }
    Log.i("Finder.FinderLiveWhiteListUI", "initLogic visitorWhiteList size:" + this.xQn.size() + ",chooseWhiteList size:" + this.xQo.size());
    AppMethodBeat.o(233934);
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/finder/feed/ui/FinderLiveWhiteListUI$Companion;", "", "()V", "TAG", "", "plugin-finder-live_release"})
  public static final class a {}
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "invoke", "com/tencent/mm/plugin/finder/feed/ui/FinderLiveWhiteListUI$initViews$2$1"})
  static final class b
    extends q
    implements kotlin.g.a.a<x>
  {
    b(FinderLiveWhiteListUI paramFinderLiveWhiteListUI)
    {
      super();
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "run"})
  static final class c
    implements Runnable
  {
    c(FinderLiveWhiteListUI paramFinderLiveWhiteListUI) {}
    
    public final void run()
    {
      Object localObject3 = null;
      AppMethodBeat.i(233510);
      int i = ax.getStatusBarHeight((Context)this.xQA.getContext());
      Object localObject1 = FinderLiveWhiteListUI.a(this.xQA);
      Object localObject2;
      if (localObject1 != null)
      {
        localObject1 = ((View)localObject1).getLayoutParams();
        localObject2 = localObject1;
        if (!(localObject1 instanceof ViewGroup.MarginLayoutParams)) {
          localObject2 = null;
        }
        localObject2 = (ViewGroup.MarginLayoutParams)localObject2;
        if (localObject2 != null) {
          ((ViewGroup.MarginLayoutParams)localObject2).topMargin = i;
        }
        localObject1 = FinderLiveWhiteListUI.a(this.xQA);
        if (localObject1 == null) {
          break label126;
        }
        localObject1 = ((View)localObject1).getParent();
        label81:
        if ((localObject1 instanceof ViewGroup)) {
          break label137;
        }
        localObject1 = localObject3;
      }
      label137:
      for (;;)
      {
        localObject1 = (ViewGroup)localObject1;
        if (localObject1 != null)
        {
          ((ViewGroup)localObject1).updateViewLayout(FinderLiveWhiteListUI.a(this.xQA), (ViewGroup.LayoutParams)localObject2);
          AppMethodBeat.o(233510);
          return;
          localObject1 = null;
          break;
          label126:
          localObject1 = null;
          break label81;
        }
        AppMethodBeat.o(233510);
        return;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.feed.ui.FinderLiveWhiteListUI
 * JD-Core Version:    0.7.0.1
 */