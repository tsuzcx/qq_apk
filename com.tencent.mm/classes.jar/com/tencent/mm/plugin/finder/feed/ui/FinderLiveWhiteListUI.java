package com.tencent.mm.plugin.finder.feed.ui;

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
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.RecyclerView.LayoutManager;
import androidx.recyclerview.widget.RecyclerView.a;
import androidx.recyclerview.widget.RecyclerView.b;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.hellhoundlib.b.b;
import com.tencent.mm.plugin.finder.live.p.e;
import com.tencent.mm.plugin.finder.live.p.f;
import com.tencent.mm.plugin.finder.live.view.adapter.aj;
import com.tencent.mm.plugin.finder.live.view.adapter.aj.c;
import com.tencent.mm.plugin.finder.ui.MMFinderUI;
import com.tencent.mm.plugin.findersdk.a.d;
import com.tencent.mm.protocal.protobuf.bfh;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.ui.bf;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import kotlin.Metadata;
import kotlin.a.p;
import kotlin.ah;
import kotlin.g.b.s;
import kotlin.g.b.u;

@com.tencent.mm.ui.base.a(32)
@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/feed/ui/FinderLiveWhiteListUI;", "Lcom/tencent/mm/plugin/finder/ui/MMFinderUI;", "Landroid/view/View$OnClickListener;", "()V", "cancelTv", "Landroid/widget/TextView;", "chooseWhiteList", "Ljava/util/LinkedList;", "Lcom/tencent/mm/protocal/protobuf/FinderLiveAudienceListFile;", "getChooseWhiteList", "()Ljava/util/LinkedList;", "setChooseWhiteList", "(Ljava/util/LinkedList;)V", "contentView", "Landroidx/recyclerview/widget/RecyclerView;", "finishTv", "titleGroup", "Landroid/view/View;", "visitorWhiteList", "getVisitorWhiteList", "setVisitorWhiteList", "whiteListAdapter", "Lcom/tencent/mm/plugin/finder/live/view/adapter/FinderLiveWhiteListAdapter;", "whiteListWrapper", "Lcom/tencent/mm/plugin/finder/live/view/adapter/FinderLiveWhiteListAdapter$FinderLiveAudienceListFileWrapper;", "getWhiteListWrapper", "setWhiteListWrapper", "getLayoutId", "", "getReportTag", "", "handleFinish", "", "initLogic", "initViews", "mergeWhiteList", "onClick", "v", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "parseInten", "setWindowStyle", "updateChooseList", "Companion", "plugin-finder-live_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class FinderLiveWhiteListUI
  extends MMFinderUI
  implements View.OnClickListener
{
  public static final a BpV;
  private TextView BpM;
  private TextView BpN;
  private RecyclerView BpW;
  private aj BpX;
  private LinkedList<bfh> BpY;
  private LinkedList<bfh> BpZ;
  private LinkedList<aj.c> Bqa;
  private View njm;
  
  static
  {
    AppMethodBeat.i(365101);
    BpV = new a((byte)0);
    AppMethodBeat.o(365101);
  }
  
  public FinderLiveWhiteListUI()
  {
    AppMethodBeat.i(365076);
    this.BpY = new LinkedList();
    this.BpZ = new LinkedList();
    this.Bqa = new LinkedList();
    AppMethodBeat.o(365076);
  }
  
  private static final void a(FinderLiveWhiteListUI paramFinderLiveWhiteListUI)
  {
    ViewGroup localViewGroup = null;
    AppMethodBeat.i(365086);
    s.u(paramFinderLiveWhiteListUI, "this$0");
    int i = bf.getStatusBarHeight((Context)paramFinderLiveWhiteListUI.getContext());
    Object localObject1 = paramFinderLiveWhiteListUI.njm;
    if (localObject1 == null)
    {
      localObject1 = null;
      if (!(localObject1 instanceof ViewGroup.MarginLayoutParams)) {
        break label113;
      }
      localObject1 = (ViewGroup.MarginLayoutParams)localObject1;
      label48:
      if (localObject1 != null) {
        ((ViewGroup.MarginLayoutParams)localObject1).topMargin = i;
      }
      localObject2 = paramFinderLiveWhiteListUI.njm;
      if (localObject2 != null) {
        break label118;
      }
    }
    label113:
    label118:
    for (Object localObject2 = null;; localObject2 = ((View)localObject2).getParent())
    {
      if ((localObject2 instanceof ViewGroup)) {
        localViewGroup = (ViewGroup)localObject2;
      }
      if (localViewGroup != null) {
        localViewGroup.updateViewLayout(paramFinderLiveWhiteListUI.njm, (ViewGroup.LayoutParams)localObject1);
      }
      AppMethodBeat.o(365086);
      return;
      localObject1 = ((View)localObject1).getLayoutParams();
      break;
      localObject1 = null;
      break label48;
    }
  }
  
  public final void _$_clearFindViewByIdCache() {}
  
  public final String efe()
  {
    return "Finder.FinderLiveWhiteListUI";
  }
  
  public final int getLayoutId()
  {
    return p.f.Cgn;
  }
  
  public final void onClick(View paramView)
  {
    AppMethodBeat.i(365151);
    Object localObject1 = new b();
    ((b)localObject1).cH(paramView);
    com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/finder/feed/ui/FinderLiveWhiteListUI", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, ((b)localObject1).aYj());
    int i;
    if (paramView == null)
    {
      paramView = null;
      i = p.e.BUN;
      if (paramView != null) {
        break label85;
      }
      label48:
      i = p.e.BBU;
      if (paramView != null) {
        break label300;
      }
    }
    for (;;)
    {
      com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/finder/feed/ui/FinderLiveWhiteListUI", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
      AppMethodBeat.o(365151);
      return;
      paramView = Integer.valueOf(paramView.getId());
      break;
      label85:
      if (paramView.intValue() != i) {
        break label48;
      }
      paramView = new Intent();
      localObject1 = a.d.HbG;
      localObject1 = a.d.fri();
      Object localObject2 = (Iterable)this.BpZ;
      Collection localCollection = (Collection)new ArrayList(p.a((Iterable)localObject2, 10));
      localObject2 = ((Iterable)localObject2).iterator();
      while (((Iterator)localObject2).hasNext()) {
        localCollection.add(((bfh)((Iterator)localObject2).next()).toByteArray());
      }
      paramView.putExtra((String)localObject1, (Serializable)localCollection);
      localObject1 = a.d.HbG;
      localObject1 = a.d.fri();
      localObject2 = (Iterable)this.BpZ;
      localCollection = (Collection)new ArrayList(p.a((Iterable)localObject2, 10));
      localObject2 = ((Iterable)localObject2).iterator();
      while (((Iterator)localObject2).hasNext()) {
        localCollection.add(((bfh)((Iterator)localObject2).next()).toByteArray());
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
    AppMethodBeat.i(365129);
    supportRequestWindowFeature(1);
    super.onCreate(paramBundle);
    getContext().getWindow().addFlags(2097280);
    getContext().getWindow().addFlags(67108864);
    if (Build.VERSION.SDK_INT >= 21)
    {
      getContext().getWindow().clearFlags(67108864);
      getContext().getWindow().getDecorView().setSystemUiVisibility(1792);
      getContext().getWindow().addFlags(-2147483648);
      getContext().getWindow().setStatusBarColor(0);
      getContext().getWindow().setNavigationBarColor(0);
    }
    getContext().getWindow().setFormat(-3);
    getContext().getWindow().setSoftInputMode(51);
    this.njm = findViewById(p.e.title_group);
    paramBundle = this.njm;
    if (paramBundle != null) {
      paramBundle.post(new FinderLiveWhiteListUI..ExternalSyntheticLambda0(this));
    }
    this.BpM = ((TextView)findViewById(p.e.BBU));
    this.BpN = ((TextView)findViewById(p.e.BUN));
    this.BpW = ((RecyclerView)findViewById(p.e.Cci));
    paramBundle = this.BpN;
    if (paramBundle != null) {
      paramBundle.setOnClickListener((View.OnClickListener)this);
    }
    paramBundle = this.BpM;
    if (paramBundle != null) {
      paramBundle.setOnClickListener((View.OnClickListener)this);
    }
    paramBundle = new aj();
    paramBundle.DTS = ((kotlin.g.a.a)new b(this));
    Object localObject1 = ah.aiuX;
    this.BpX = paramBundle;
    localObject1 = this.BpW;
    if (localObject1 != null)
    {
      ((RecyclerView)localObject1).getContext();
      ((RecyclerView)localObject1).setLayoutManager((RecyclerView.LayoutManager)new LinearLayoutManager(1, false));
      ((RecyclerView)localObject1).setAdapter((RecyclerView.a)this.BpX);
      paramBundle = ((RecyclerView)localObject1).getLayoutParams();
      if (!(paramBundle instanceof ViewGroup.MarginLayoutParams)) {
        break label562;
      }
      paramBundle = (ViewGroup.MarginLayoutParams)paramBundle;
      if (paramBundle != null) {
        paramBundle.bottomMargin = bf.bk(((RecyclerView)localObject1).getContext());
      }
    }
    paramBundle = getIntent();
    localObject1 = a.d.HbG;
    paramBundle = paramBundle.getSerializableExtra(a.d.frh());
    label382:
    Object localObject2;
    label428:
    label465:
    Object localObject3;
    if ((paramBundle instanceof List))
    {
      paramBundle = (List)paramBundle;
      if (paramBundle != null)
      {
        localObject1 = com.tencent.mm.plugin.finder.live.utils.a.DJT;
        com.tencent.mm.plugin.finder.live.utils.a.a(paramBundle, this.BpY);
      }
      paramBundle = getIntent();
      localObject1 = a.d.HbG;
      paramBundle = paramBundle.getSerializableExtra(a.d.fri());
      if (!(paramBundle instanceof List)) {
        break label572;
      }
      paramBundle = (List)paramBundle;
      if (paramBundle != null)
      {
        localObject1 = com.tencent.mm.plugin.finder.live.utils.a.DJT;
        com.tencent.mm.plugin.finder.live.utils.a.a(paramBundle, this.BpZ);
      }
      this.Bqa.clear();
      localObject1 = ((Iterable)this.BpY).iterator();
      if (!((Iterator)localObject1).hasNext()) {
        break label587;
      }
      localObject2 = (bfh)((Iterator)localObject1).next();
      localObject3 = ((Iterable)this.BpZ).iterator();
      while (((Iterator)localObject3).hasNext())
      {
        paramBundle = ((Iterator)localObject3).next();
        if (s.p(((bfh)paramBundle).YPy, ((bfh)localObject2).YPy)) {
          label535:
          if (paramBundle == null) {
            break label582;
          }
        }
      }
    }
    label562:
    label572:
    label582:
    for (boolean bool = true;; bool = false)
    {
      this.Bqa.add(new aj.c(bool, (bfh)localObject2));
      break label465;
      paramBundle = null;
      break;
      paramBundle = null;
      break label382;
      paramBundle = null;
      break label428;
      paramBundle = null;
      break label535;
    }
    label587:
    localObject1 = this.BpX;
    if (localObject1 != null)
    {
      localObject2 = this.Bqa;
      localObject3 = new StringBuilder("updateWhiteList,ori size:").append(((aj)localObject1).vEn.size()).append(",new size:");
      if (localObject2 != null) {
        break label768;
      }
    }
    label768:
    for (paramBundle = null;; paramBundle = Integer.valueOf(((LinkedList)localObject2).size()))
    {
      Log.i("FinderLiveWhiteListAdapter", paramBundle);
      if (localObject2 != null)
      {
        ((aj)localObject1).vEn.clear();
        ((aj)localObject1).vEn.addAll((Collection)localObject2);
        ((aj)localObject1).vEn.add(new aj.c(false, new bfh(), 2));
      }
      paramBundle = this.BpX;
      if (paramBundle != null) {
        paramBundle.bZE.notifyChanged();
      }
      Log.i("Finder.FinderLiveWhiteListUI", "initLogic visitorWhiteList size:" + this.BpY.size() + ",chooseWhiteList size:" + this.BpZ.size());
      AppMethodBeat.o(365129);
      return;
    }
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
  
  @Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/feed/ui/FinderLiveWhiteListUI$Companion;", "", "()V", "TAG", "", "plugin-finder-live_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class a {}
  
  @Metadata(d1={""}, d2={"<anonymous>", ""}, k=3, mv={1, 5, 1}, xi=48)
  static final class b
    extends u
    implements kotlin.g.a.a<ah>
  {
    b(FinderLiveWhiteListUI paramFinderLiveWhiteListUI)
    {
      super();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.feed.ui.FinderLiveWhiteListUI
 * JD-Core Version:    0.7.0.1
 */