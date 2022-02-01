package com.tencent.mm.plugin.finder.feed.ui;

import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewGroup.MarginLayoutParams;
import android.view.Window;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.RecyclerView.LayoutManager;
import androidx.recyclerview.widget.RecyclerView.a;
import androidx.recyclerview.widget.RecyclerView.b;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ae.d;
import com.tencent.mm.autogen.b.az;
import com.tencent.mm.kernel.h;
import com.tencent.mm.plugin.finder.live.p.b;
import com.tencent.mm.plugin.finder.live.p.e;
import com.tencent.mm.plugin.finder.live.p.f;
import com.tencent.mm.plugin.finder.live.report.j;
import com.tencent.mm.plugin.finder.live.report.q;
import com.tencent.mm.plugin.finder.live.report.q.bt;
import com.tencent.mm.plugin.finder.live.view.adapter.FinderLiveWhiteListGroupAdapter;
import com.tencent.mm.plugin.finder.live.viewmodel.i;
import com.tencent.mm.plugin.finder.live.viewmodel.i.a;
import com.tencent.mm.plugin.finder.live.viewmodel.state.a.a;
import com.tencent.mm.plugin.finder.ui.MMFinderUI;
import com.tencent.mm.plugin.findersdk.a.d;
import com.tencent.mm.plugin.messenger.foundation.a.n;
import com.tencent.mm.protocal.protobuf.bfh;
import com.tencent.mm.protocal.protobuf.bfy;
import com.tencent.mm.protocal.protobuf.boe;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.storage.au;
import com.tencent.mm.storage.bx;
import com.tencent.mm.ui.bf;
import com.tencent.mm.ui.component.UIComponent;
import com.tencent.mm.ui.component.k;
import com.tencent.mm.ui.component.k.b;
import com.tencent.mm.ui.widget.imageview.WeImageView;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import kotlin.Metadata;
import kotlin.a.p;
import kotlin.ah;
import kotlin.g.b.s;

@com.tencent.mm.ui.base.a(32)
@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/feed/ui/FinderLiveVisitorWhiteListUI;", "Lcom/tencent/mm/plugin/finder/ui/MMFinderUI;", "Landroid/view/View$OnClickListener;", "()V", "cancelTv", "Landroid/widget/TextView;", "getCancelTv", "()Landroid/widget/TextView;", "setCancelTv", "(Landroid/widget/TextView;)V", "value", "", "chooseMode", "getChooseMode", "()I", "setChooseMode", "(I)V", "finishTv", "getFinishTv", "setFinishTv", "publicChooseIcon", "Lcom/tencent/mm/ui/widget/imageview/WeImageView;", "getPublicChooseIcon", "()Lcom/tencent/mm/ui/widget/imageview/WeImageView;", "setPublicChooseIcon", "(Lcom/tencent/mm/ui/widget/imageview/WeImageView;)V", "publicGroup", "Landroid/view/View;", "getPublicGroup", "()Landroid/view/View;", "setPublicGroup", "(Landroid/view/View;)V", "shareChooseIcon", "getShareChooseIcon", "setShareChooseIcon", "shareGroup", "getShareGroup", "setShareGroup", "titleGroup", "getTitleGroup", "setTitleGroup", "addModeFlag", "", "newMode", "checkChargeListState", "checkWhiteListState", "mode", "choosePublicMode", "choose", "", "chooseShareMode", "expandWhiteListGroupPanel", "finish", "getLayoutId", "getReportTag", "", "goBack", "isCancel", "initLayout", "initLogic", "onActivityResult", "requestCode", "resultCode", "data", "Landroid/content/Intent;", "onClick", "v", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "onDestroy", "onPause", "onResume", "onStart", "onStop", "onSwipeBack", "setFinishBtnEnable", "enable", "setWindowStyle", "superImportUIComponents", "set", "Ljava/util/HashSet;", "Ljava/lang/Class;", "Lcom/tencent/mm/ui/component/UIComponent;", "Companion", "plugin-finder-live_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class FinderLiveVisitorWhiteListUI
  extends MMFinderUI
  implements View.OnClickListener
{
  public static final a BpL;
  private TextView BpM;
  private TextView BpN;
  private View BpO;
  private WeImageView BpP;
  private View BpQ;
  private WeImageView BpR;
  public int BpS;
  private View njm;
  
  static
  {
    AppMethodBeat.i(364407);
    BpL = new a((byte)0);
    AppMethodBeat.o(364407);
  }
  
  private void Om(int paramInt)
  {
    AppMethodBeat.i(364332);
    Log.i("FinderLiveVisitorWhiteListUI", "chooseMode from:" + this.BpS + " - to:" + paramInt);
    this.BpS = paramInt;
    AppMethodBeat.o(364332);
  }
  
  private static final void a(FinderLiveVisitorWhiteListUI paramFinderLiveVisitorWhiteListUI)
  {
    ViewGroup localViewGroup = null;
    AppMethodBeat.i(364399);
    s.u(paramFinderLiveVisitorWhiteListUI, "this$0");
    int i = bf.getStatusBarHeight((Context)paramFinderLiveVisitorWhiteListUI.getContext());
    Object localObject1 = paramFinderLiveVisitorWhiteListUI.njm;
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
      localObject2 = paramFinderLiveVisitorWhiteListUI.njm;
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
        localViewGroup.updateViewLayout(paramFinderLiveVisitorWhiteListUI.njm, (ViewGroup.LayoutParams)localObject1);
      }
      AppMethodBeat.o(364399);
      return;
      localObject1 = ((View)localObject1).getLayoutParams();
      break;
      localObject1 = null;
      break label48;
    }
  }
  
  private final void efw()
  {
    AppMethodBeat.i(364338);
    k localk = k.aeZF;
    if (((com.tencent.mm.plugin.finder.live.viewmodel.state.a)k.d((AppCompatActivity)this).q(com.tencent.mm.plugin.finder.live.viewmodel.state.a.class)).ezo())
    {
      qd(true);
      AppMethodBeat.o(364338);
      return;
    }
    qd(false);
    AppMethodBeat.o(364338);
  }
  
  private final void efx()
  {
    AppMethodBeat.i(364348);
    k localk = k.aeZF;
    if (((i)k.d((AppCompatActivity)this).q(i.class)).exe())
    {
      qd(true);
      AppMethodBeat.o(364348);
      return;
    }
    qd(false);
    AppMethodBeat.o(364348);
  }
  
  private final void efy()
  {
    AppMethodBeat.i(364372);
    WeImageView localWeImageView = this.BpR;
    if (localWeImageView != null) {
      localWeImageView.setVisibility(8);
    }
    AppMethodBeat.o(364372);
  }
  
  private final void pq(boolean paramBoolean)
  {
    AppMethodBeat.i(364388);
    Object localObject1 = new StringBuilder("goBack isCancel:").append(paramBoolean).append(" chooseMode:").append(this.BpS).append(", chooseWhiteList.size:");
    Object localObject2 = k.aeZF;
    localObject1 = ((StringBuilder)localObject1).append(((com.tencent.mm.plugin.finder.live.viewmodel.state.a)k.d((AppCompatActivity)this).q(com.tencent.mm.plugin.finder.live.viewmodel.state.a.class)).BpZ.size()).append(", partician whiteList:");
    localObject2 = com.tencent.mm.plugin.finder.live.view.convert.a.DUC;
    localObject2 = k.aeZF;
    localObject1 = ((StringBuilder)localObject1).append(com.tencent.mm.plugin.finder.live.view.convert.a.a(((com.tencent.mm.plugin.finder.live.viewmodel.state.a)k.d((AppCompatActivity)this).q(com.tencent.mm.plugin.finder.live.viewmodel.state.a.class)).EiH)).append(", chargeInfo:");
    localObject2 = com.tencent.mm.plugin.finder.live.view.convert.a.DUC;
    localObject2 = k.aeZF;
    Log.i("FinderLiveVisitorWhiteListUI", com.tencent.mm.plugin.finder.live.view.convert.a.a(((i)k.d((AppCompatActivity)this).q(i.class)).DYw));
    if (paramBoolean)
    {
      setResult(0);
      finish();
      AppMethodBeat.o(364388);
      return;
    }
    localObject1 = new Intent();
    localObject2 = a.d.HbG;
    ((Intent)localObject1).putExtra(a.d.frg(), this.BpS);
    Object localObject3;
    if (this.BpS == 524288)
    {
      localObject2 = a.d.HbG;
      localObject2 = a.d.frm();
      localObject3 = k.aeZF;
      ((Intent)localObject1).putExtra((String)localObject2, ((i)k.d((AppCompatActivity)this).q(i.class)).DYw.toByteArray());
    }
    for (;;)
    {
      setResult(-1, (Intent)localObject1);
      break;
      localObject2 = a.d.HbG;
      localObject2 = a.d.fri();
      localObject3 = k.aeZF;
      Object localObject4 = (Iterable)((com.tencent.mm.plugin.finder.live.viewmodel.state.a)k.d((AppCompatActivity)this).q(com.tencent.mm.plugin.finder.live.viewmodel.state.a.class)).BpZ;
      localObject3 = (Collection)new ArrayList(p.a((Iterable)localObject4, 10));
      localObject4 = ((Iterable)localObject4).iterator();
      while (((Iterator)localObject4).hasNext()) {
        ((Collection)localObject3).add(((bfh)((Iterator)localObject4).next()).toByteArray());
      }
      ((Intent)localObject1).putExtra((String)localObject2, (Serializable)localObject3);
      localObject2 = a.d.HbG;
      localObject2 = a.d.frj();
      localObject3 = k.aeZF;
      ((Intent)localObject1).putStringArrayListExtra((String)localObject2, new ArrayList((Collection)((com.tencent.mm.plugin.finder.live.viewmodel.state.a)k.d((AppCompatActivity)this).q(com.tencent.mm.plugin.finder.live.viewmodel.state.a.class)).EiF));
      localObject2 = a.d.HbG;
      localObject2 = a.d.frk();
      localObject3 = k.aeZF;
      ((Intent)localObject1).putStringArrayListExtra((String)localObject2, new ArrayList((Collection)((com.tencent.mm.plugin.finder.live.viewmodel.state.a)k.d((AppCompatActivity)this).q(com.tencent.mm.plugin.finder.live.viewmodel.state.a.class)).EiG));
      localObject2 = a.d.HbG;
      localObject2 = a.d.frn();
      localObject3 = k.aeZF;
      ((Intent)localObject1).putExtra((String)localObject2, ((com.tencent.mm.plugin.finder.live.viewmodel.state.a)k.d((AppCompatActivity)this).q(com.tencent.mm.plugin.finder.live.viewmodel.state.a.class)).EiH.toByteArray());
    }
  }
  
  private final void qd(boolean paramBoolean)
  {
    AppMethodBeat.i(364357);
    TextView localTextView = this.BpN;
    if (localTextView != null) {
      localTextView.setEnabled(paramBoolean);
    }
    if (paramBoolean)
    {
      localTextView = this.BpN;
      if (localTextView != null)
      {
        localTextView.setTextColor(MMApplicationContext.getContext().getResources().getColor(p.b.White));
        AppMethodBeat.o(364357);
      }
    }
    else
    {
      localTextView = this.BpN;
      if (localTextView != null) {
        localTextView.setTextColor(MMApplicationContext.getContext().getResources().getColor(p.b.BW_100_Alpha_0_2));
      }
    }
    AppMethodBeat.o(364357);
  }
  
  private final void qe(boolean paramBoolean)
  {
    AppMethodBeat.i(364365);
    WeImageView localWeImageView;
    if (paramBoolean)
    {
      localWeImageView = this.BpP;
      if (localWeImageView != null)
      {
        localWeImageView.setVisibility(0);
        AppMethodBeat.o(364365);
      }
    }
    else
    {
      localWeImageView = this.BpP;
      if (localWeImageView != null) {
        localWeImageView.setVisibility(8);
      }
    }
    AppMethodBeat.o(364365);
  }
  
  public final void On(int paramInt)
  {
    AppMethodBeat.i(364487);
    Om(this.BpS | paramInt);
    AppMethodBeat.o(364487);
  }
  
  public final void Oo(int paramInt)
  {
    AppMethodBeat.i(364498);
    Log.i("FinderLiveVisitorWhiteListUI", s.X("chooseMode:", Integer.valueOf(paramInt)));
    Object localObject;
    if (paramInt == 524288)
    {
      Om(524288);
      qe(false);
      efy();
      localObject = k.aeZF;
      ((com.tencent.mm.plugin.finder.live.viewmodel.state.a)k.d((AppCompatActivity)this).q(com.tencent.mm.plugin.finder.live.viewmodel.state.a.class)).sr(false);
      localObject = k.aeZF;
      ((i)k.d((AppCompatActivity)this).q(i.class)).sf(true);
      efx();
      AppMethodBeat.o(364498);
      return;
    }
    if (paramInt == 0)
    {
      Om(0);
      qe(true);
      efy();
      localObject = k.aeZF;
      ((com.tencent.mm.plugin.finder.live.viewmodel.state.a)k.d((AppCompatActivity)this).q(com.tencent.mm.plugin.finder.live.viewmodel.state.a.class)).sr(false);
      localObject = k.aeZF;
      ((i)k.d((AppCompatActivity)this).q(i.class)).sf(false);
      qd(true);
      localObject = j.Dob;
      j.Doc.a(q.bt.DCd);
      AppMethodBeat.o(364498);
      return;
    }
    if ((d.ee(paramInt, 2)) || (d.ee(paramInt, 4)) || (d.ee(paramInt, 1))) {
      efv();
    }
    AppMethodBeat.o(364498);
  }
  
  public final void _$_clearFindViewByIdCache() {}
  
  public final String efe()
  {
    return "FinderLiveVisitorWhiteListUI";
  }
  
  public final void efv()
  {
    AppMethodBeat.i(364481);
    qe(false);
    efy();
    Object localObject = k.aeZF;
    ((i)k.d((AppCompatActivity)this).q(i.class)).sf(false);
    localObject = k.aeZF;
    localObject = k.d((AppCompatActivity)this).q(com.tencent.mm.plugin.finder.live.viewmodel.state.a.class);
    s.s(localObject, "UICProvider.of(this).get…WhiteListUIC::class.java)");
    com.tencent.mm.plugin.finder.live.viewmodel.state.a.a((com.tencent.mm.plugin.finder.live.viewmodel.state.a)localObject);
    efw();
    AppMethodBeat.o(364481);
  }
  
  public final void finish()
  {
    AppMethodBeat.i(364562);
    super.finish();
    AppMethodBeat.o(364562);
  }
  
  public final int getLayoutId()
  {
    return p.f.CfX;
  }
  
  public final void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    int i = 0;
    AppMethodBeat.i(364588);
    super.onActivityResult(paramInt1, paramInt2, paramIntent);
    Log.i("FinderLiveVisitorWhiteListUI", "onActivityResult requestCode:" + paramInt1 + " resultCode:" + paramInt2);
    switch (paramInt1)
    {
    }
    label127:
    Object localObject2;
    label278:
    label283:
    do
    {
      do
      {
        AppMethodBeat.o(364588);
        return;
        localObject1 = k.aeZF;
        localObject1 = (com.tencent.mm.plugin.finder.live.viewmodel.state.a)k.d((AppCompatActivity)this).q(com.tencent.mm.plugin.finder.live.viewmodel.state.a.class);
        if (paramIntent == null)
        {
          paramIntent = null;
          if (!(paramIntent instanceof List)) {
            break label278;
          }
          paramIntent = (List)paramIntent;
          if (paramIntent != null)
          {
            localObject2 = com.tencent.mm.plugin.finder.live.utils.a.DJT;
            com.tencent.mm.plugin.finder.live.utils.a.a(paramIntent, ((com.tencent.mm.plugin.finder.live.viewmodel.state.a)localObject1).BpZ);
            paramIntent = (Collection)((com.tencent.mm.plugin.finder.live.viewmodel.state.a)localObject1).BpZ;
            if (paramIntent != null)
            {
              paramInt1 = i;
              if (!paramIntent.isEmpty()) {}
            }
            else
            {
              paramInt1 = 1;
            }
            if (paramInt1 == 0)
            {
              paramIntent = ((com.tencent.mm.plugin.finder.live.viewmodel.state.a)localObject1).getActivity();
              if (!(paramIntent instanceof FinderLiveVisitorWhiteListUI)) {
                break label283;
              }
            }
          }
        }
        for (paramIntent = (FinderLiveVisitorWhiteListUI)paramIntent;; paramIntent = null)
        {
          if (paramIntent != null) {
            paramIntent.On(1);
          }
          ((com.tencent.mm.plugin.finder.live.viewmodel.state.a)localObject1).exc();
          paramIntent = ((com.tencent.mm.plugin.finder.live.viewmodel.state.a)localObject1).EiE;
          if (paramIntent != null) {
            paramIntent.bZE.notifyChanged();
          }
          Log.i(((com.tencent.mm.plugin.finder.live.viewmodel.state.a)localObject1).TAG, s.X("onSelectWebListActivityResult chooseWhiteList.size:", Integer.valueOf(((com.tencent.mm.plugin.finder.live.viewmodel.state.a)localObject1).BpZ.size())));
          efw();
          AppMethodBeat.o(364588);
          return;
          localObject2 = a.d.HbG;
          paramIntent = paramIntent.getSerializableExtra(a.d.fri());
          break;
          paramIntent = null;
          break label127;
        }
        if (paramIntent != null)
        {
          localObject1 = a.d.HbG;
          localObject2 = paramIntent.getByteArrayExtra(a.d.frh());
          if (localObject2 != null)
          {
            paramIntent = k.aeZF;
            paramIntent = (com.tencent.mm.plugin.finder.live.viewmodel.state.a)k.d((AppCompatActivity)this).q(com.tencent.mm.plugin.finder.live.viewmodel.state.a.class);
            localObject1 = new boe();
            ((boe)localObject1).parseFrom((byte[])localObject2);
            localObject2 = ah.aiuX;
            s.u(localObject1, "tmpChargeInfo");
            paramIntent.EiH = ((boe)localObject1);
            localObject2 = ((boe)localObject1).ZWy;
            s.s(localObject2, "tmpChargeInfo.chatroom_id_list");
            com.tencent.mm.plugin.finder.live.viewmodel.state.a.a(paramIntent, (LinkedList)localObject2);
            localObject1 = ((boe)localObject1).username_list;
            s.s(localObject1, "tmpChargeInfo.username_list");
            com.tencent.mm.plugin.finder.live.viewmodel.state.a.b(paramIntent, (LinkedList)localObject1);
            paramIntent.exc();
            localObject1 = paramIntent.EiE;
            if (localObject1 != null) {
              ((RecyclerView.a)localObject1).bZE.notifyChanged();
            }
            localObject1 = paramIntent.TAG;
            localObject2 = com.tencent.mm.plugin.finder.live.view.convert.a.DUC;
            Log.i((String)localObject1, s.X("onSelectContactActivityResult white list:", com.tencent.mm.plugin.finder.live.view.convert.a.a(paramIntent.EiH)));
          }
        }
        efw();
        AppMethodBeat.o(364588);
        return;
      } while (paramIntent == null);
      localObject1 = a.d.HbG;
      localObject1 = paramIntent.getByteArrayExtra(a.d.frh());
    } while (localObject1 == null);
    paramIntent = new boe();
    paramIntent.parseFrom((byte[])localObject1);
    Object localObject1 = paramIntent.ZWz;
    s.s(localObject1, "tmpChargeInfo.contact_list");
    if (!((Collection)localObject1).isEmpty()) {}
    for (paramInt1 = 1;; paramInt1 = 0)
    {
      if (paramInt1 != 0) {
        Om(524288);
      }
      localObject1 = k.aeZF;
      localObject1 = (i)k.d((AppCompatActivity)this).q(i.class);
      s.u(paramIntent, "tmpChargeInfo");
      ((i)localObject1).DYw.ZPJ = paramIntent;
      ((i)localObject1).exc();
      paramIntent = ((i)localObject1).TAG;
      localObject2 = com.tencent.mm.plugin.finder.live.view.convert.a.DUC;
      Log.i(paramIntent, s.X("live_charge_step100 onActivityResult liveChargeInfo:", com.tencent.mm.plugin.finder.live.view.convert.a.a(((i)localObject1).DYw)));
      efx();
      break;
    }
  }
  
  public final void onClick(View paramView)
  {
    AppMethodBeat.i(364568);
    com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
    localb.cH(paramView);
    com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/finder/feed/ui/FinderLiveVisitorWhiteListUI", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.aYj());
    int i;
    if (paramView == null)
    {
      paramView = null;
      i = p.e.BBU;
      if (paramView != null) {
        break label107;
      }
      label53:
      i = p.e.BUN;
      if (paramView != null) {
        break label123;
      }
      label61:
      i = p.e.Cae;
      if (paramView != null) {
        break label139;
      }
      label69:
      if (paramView != null) {
        break label155;
      }
    }
    for (;;)
    {
      com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/finder/feed/ui/FinderLiveVisitorWhiteListUI", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
      AppMethodBeat.o(364568);
      return;
      paramView = Integer.valueOf(paramView.getId());
      break;
      label107:
      if (paramView.intValue() != i) {
        break label53;
      }
      pq(true);
      continue;
      label123:
      if (paramView.intValue() != i) {
        break label61;
      }
      pq(false);
      continue;
      label139:
      if (paramView.intValue() != i) {
        break label69;
      }
      Oo(0);
      continue;
      label155:
      paramView.intValue();
    }
  }
  
  public final void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(364472);
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
    Log.i("FinderLiveVisitorWhiteListUI", "[onCreate]");
    this.njm = findViewById(p.e.title_group);
    paramBundle = this.njm;
    if (paramBundle != null) {
      paramBundle.post(new FinderLiveVisitorWhiteListUI..ExternalSyntheticLambda0(this));
    }
    this.BpM = ((TextView)findViewById(p.e.BBU));
    paramBundle = this.BpM;
    if (paramBundle != null) {
      paramBundle.setOnClickListener((View.OnClickListener)this);
    }
    this.BpN = ((TextView)findViewById(p.e.BUN));
    paramBundle = this.BpN;
    if (paramBundle != null) {
      paramBundle.setOnClickListener((View.OnClickListener)this);
    }
    this.BpO = findViewById(p.e.Cae);
    paramBundle = this.BpO;
    if (paramBundle != null) {
      paramBundle.setOnClickListener((View.OnClickListener)this);
    }
    this.BpP = ((WeImageView)findViewById(p.e.Cad));
    this.BpQ = findViewById(p.e.CaK);
    paramBundle = this.BpQ;
    if (paramBundle != null) {
      paramBundle.setOnClickListener((View.OnClickListener)this);
    }
    this.BpR = ((WeImageView)findViewById(p.e.CaJ));
    paramBundle = k.aeZF;
    Object localObject1 = (com.tencent.mm.plugin.finder.live.viewmodel.state.a)k.d((AppCompatActivity)this).q(com.tencent.mm.plugin.finder.live.viewmodel.state.a.class);
    ((com.tencent.mm.plugin.finder.live.viewmodel.state.a)localObject1).Eix = ((com.tencent.mm.plugin.finder.live.viewmodel.state.a)localObject1).findViewById(p.e.Ccl);
    paramBundle = ((com.tencent.mm.plugin.finder.live.viewmodel.state.a)localObject1).Eix;
    if (paramBundle != null) {
      paramBundle.setOnClickListener((View.OnClickListener)localObject1);
    }
    ((com.tencent.mm.plugin.finder.live.viewmodel.state.a)localObject1).Eiy = ((WeImageView)((com.tencent.mm.plugin.finder.live.viewmodel.state.a)localObject1).findViewById(p.e.Ccf));
    ((com.tencent.mm.plugin.finder.live.viewmodel.state.a)localObject1).Eiz = ((TextView)((com.tencent.mm.plugin.finder.live.viewmodel.state.a)localObject1).findViewById(p.e.Ccn));
    ((com.tencent.mm.plugin.finder.live.viewmodel.state.a)localObject1).EiA = ((TextView)((com.tencent.mm.plugin.finder.live.viewmodel.state.a)localObject1).findViewById(p.e.Ccm));
    ((com.tencent.mm.plugin.finder.live.viewmodel.state.a)localObject1).EiB = ((ImageView)((com.tencent.mm.plugin.finder.live.viewmodel.state.a)localObject1).findViewById(p.e.Cck));
    ((com.tencent.mm.plugin.finder.live.viewmodel.state.a)localObject1).EiC = ((com.tencent.mm.plugin.finder.live.viewmodel.state.a)localObject1).findViewById(p.e.Cch);
    paramBundle = new FinderLiveWhiteListGroupAdapter();
    paramBundle.DTG = ((kotlin.g.a.b)new a.a((com.tencent.mm.plugin.finder.live.viewmodel.state.a)localObject1));
    Object localObject2 = ah.aiuX;
    ((com.tencent.mm.plugin.finder.live.viewmodel.state.a)localObject1).EiE = paramBundle;
    localObject2 = ((com.tencent.mm.plugin.finder.live.viewmodel.state.a)localObject1).findViewById(p.e.Cci);
    Object localObject3 = (RecyclerView)localObject2;
    ((RecyclerView)localObject3).getContext();
    ((RecyclerView)localObject3).setLayoutManager((RecyclerView.LayoutManager)new LinearLayoutManager(1, false));
    ((RecyclerView)localObject3).setAdapter((RecyclerView.a)((com.tencent.mm.plugin.finder.live.viewmodel.state.a)localObject1).EiE);
    paramBundle = ((RecyclerView)localObject3).getLayoutParams();
    label795:
    label845:
    int i;
    if ((paramBundle instanceof ViewGroup.MarginLayoutParams))
    {
      paramBundle = (ViewGroup.MarginLayoutParams)paramBundle;
      if (paramBundle != null) {
        paramBundle.bottomMargin = bf.bk(((RecyclerView)localObject3).getContext());
      }
      paramBundle = ah.aiuX;
      ((com.tencent.mm.plugin.finder.live.viewmodel.state.a)localObject1).EiD = ((RecyclerView)localObject2);
      paramBundle = k.aeZF;
      paramBundle = (i)k.d((AppCompatActivity)this).q(i.class);
      paramBundle.DYo = paramBundle.findViewById(p.e.BWr);
      paramBundle.DYs = paramBundle.findViewById(p.e.BWw);
      if (!paramBundle.DYy) {
        break label1549;
      }
      localObject1 = paramBundle.DYo;
      if (localObject1 != null) {
        ((View)localObject1).setVisibility(0);
      }
      localObject1 = paramBundle.DYs;
      if (localObject1 != null) {
        ((View)localObject1).setVisibility(0);
      }
      localObject1 = paramBundle.DYo;
      if (localObject1 != null) {
        ((View)localObject1).setOnClickListener((View.OnClickListener)paramBundle);
      }
      paramBundle.DYp = ((WeImageView)paramBundle.findViewById(p.e.BWq));
      paramBundle.DYq = paramBundle.findViewById(p.e.BWu);
      paramBundle.DYr = ((TextView)paramBundle.findViewById(p.e.BWv));
      paramBundle.DYt = ((RecyclerView)paramBundle.findViewById(p.e.BWx));
      paramBundle.DYu = new FinderLiveWhiteListGroupAdapter();
      localObject1 = paramBundle.DYu;
      if (localObject1 != null) {
        ((FinderLiveWhiteListGroupAdapter)localObject1).DTG = ((kotlin.g.a.b)new i.a(paramBundle));
      }
      localObject1 = paramBundle.DYt;
      if (localObject1 != null)
      {
        ((RecyclerView)localObject1).getContext();
        ((RecyclerView)localObject1).setLayoutManager((RecyclerView.LayoutManager)new LinearLayoutManager(1, false));
        ((RecyclerView)localObject1).setAdapter((RecyclerView.a)paramBundle.DYu);
      }
      paramBundle = k.aeZF;
      localObject1 = (com.tencent.mm.plugin.finder.live.viewmodel.state.a)k.d((AppCompatActivity)this).q(com.tencent.mm.plugin.finder.live.viewmodel.state.a.class);
      paramBundle = ((com.tencent.mm.plugin.finder.live.viewmodel.state.a)localObject1).getIntent();
      localObject2 = a.d.HbG;
      paramBundle = paramBundle.getSerializableExtra(a.d.frh());
      if (!(paramBundle instanceof List)) {
        break label1582;
      }
      paramBundle = (List)paramBundle;
      if (paramBundle != null)
      {
        localObject2 = com.tencent.mm.plugin.finder.live.utils.a.DJT;
        com.tencent.mm.plugin.finder.live.utils.a.a(paramBundle, ((com.tencent.mm.plugin.finder.live.viewmodel.state.a)localObject1).BpY);
        paramBundle = ((com.tencent.mm.plugin.finder.live.viewmodel.state.a)localObject1).EiE;
        if (paramBundle != null)
        {
          localObject2 = ((com.tencent.mm.plugin.finder.live.viewmodel.state.a)localObject1).BpY;
          s.u(localObject2, "list");
          paramBundle.DTY.clear();
          paramBundle.DTY.addAll((Collection)localObject2);
        }
      }
      paramBundle = ((com.tencent.mm.plugin.finder.live.viewmodel.state.a)localObject1).getIntent();
      localObject2 = a.d.HbG;
      paramBundle = paramBundle.getSerializableExtra(a.d.fri());
      if (!(paramBundle instanceof List)) {
        break label1587;
      }
      paramBundle = (List)paramBundle;
      label936:
      if (paramBundle != null)
      {
        localObject2 = com.tencent.mm.plugin.finder.live.utils.a.DJT;
        com.tencent.mm.plugin.finder.live.utils.a.a(paramBundle, ((com.tencent.mm.plugin.finder.live.viewmodel.state.a)localObject1).BpZ);
        paramBundle = (Collection)((com.tencent.mm.plugin.finder.live.viewmodel.state.a)localObject1).BpZ;
        if ((paramBundle != null) && (!paramBundle.isEmpty())) {
          break label1592;
        }
        i = 1;
        label977:
        if (i == 0)
        {
          paramBundle = ((com.tencent.mm.plugin.finder.live.viewmodel.state.a)localObject1).getActivity();
          if (!(paramBundle instanceof FinderLiveVisitorWhiteListUI)) {
            break label1597;
          }
          paramBundle = (FinderLiveVisitorWhiteListUI)paramBundle;
          label998:
          if (paramBundle != null) {
            paramBundle.On(1);
          }
        }
      }
      paramBundle = ((com.tencent.mm.plugin.finder.live.viewmodel.state.a)localObject1).getIntent();
      localObject2 = a.d.HbG;
      paramBundle = paramBundle.getStringArrayListExtra(a.d.frj());
      if (paramBundle != null)
      {
        ((com.tencent.mm.plugin.finder.live.viewmodel.state.a)localObject1).EiF.clear();
        ((com.tencent.mm.plugin.finder.live.viewmodel.state.a)localObject1).EiF.addAll((Collection)paramBundle);
        paramBundle = (Collection)((com.tencent.mm.plugin.finder.live.viewmodel.state.a)localObject1).EiF;
        if ((paramBundle != null) && (!paramBundle.isEmpty())) {
          break label1602;
        }
        i = 1;
        label1071:
        if (i == 0)
        {
          paramBundle = ((com.tencent.mm.plugin.finder.live.viewmodel.state.a)localObject1).getActivity();
          if (!(paramBundle instanceof FinderLiveVisitorWhiteListUI)) {
            break label1607;
          }
          paramBundle = (FinderLiveVisitorWhiteListUI)paramBundle;
          label1092:
          if (paramBundle != null) {
            paramBundle.On(2);
          }
        }
      }
      paramBundle = ((com.tencent.mm.plugin.finder.live.viewmodel.state.a)localObject1).getIntent();
      localObject2 = a.d.HbG;
      paramBundle = paramBundle.getStringArrayListExtra(a.d.frk());
      if (paramBundle != null)
      {
        ((com.tencent.mm.plugin.finder.live.viewmodel.state.a)localObject1).EiG.clear();
        ((com.tencent.mm.plugin.finder.live.viewmodel.state.a)localObject1).EiG.addAll((Collection)paramBundle);
        paramBundle = (Collection)((com.tencent.mm.plugin.finder.live.viewmodel.state.a)localObject1).EiG;
        if ((paramBundle != null) && (!paramBundle.isEmpty())) {
          break label1612;
        }
        i = 1;
        label1165:
        if (i == 0)
        {
          paramBundle = ((com.tencent.mm.plugin.finder.live.viewmodel.state.a)localObject1).getActivity();
          if (!(paramBundle instanceof FinderLiveVisitorWhiteListUI)) {
            break label1617;
          }
          paramBundle = (FinderLiveVisitorWhiteListUI)paramBundle;
          label1186:
          if (paramBundle != null) {
            paramBundle.On(4);
          }
        }
      }
      paramBundle = ((com.tencent.mm.plugin.finder.live.viewmodel.state.a)localObject1).getIntent();
      localObject2 = a.d.HbG;
      paramBundle = paramBundle.getByteArrayExtra(a.d.frn());
      if (paramBundle != null)
      {
        localObject2 = new boe();
        ((boe)localObject2).parseFrom(paramBundle);
        ((com.tencent.mm.plugin.finder.live.viewmodel.state.a)localObject1).EiH.ZWz = ((boe)localObject2).ZWz;
      }
      paramBundle = ((com.tencent.mm.plugin.finder.live.viewmodel.state.a)localObject1).getIntent();
      localObject2 = a.d.HbG;
      ((com.tencent.mm.plugin.finder.live.viewmodel.state.a)localObject1).BsR = paramBundle.getIntExtra(a.d.frl(), 0);
      paramBundle = ((com.tencent.mm.plugin.finder.live.viewmodel.state.a)localObject1).getActivity();
      if (!(paramBundle instanceof FinderLiveVisitorWhiteListUI)) {
        break label1622;
      }
      paramBundle = (FinderLiveVisitorWhiteListUI)paramBundle;
      label1284:
      if (paramBundle != null)
      {
        localObject2 = ((com.tencent.mm.plugin.finder.live.viewmodel.state.a)localObject1).getIntent();
        localObject3 = a.d.HbG;
        paramBundle.Om(((Intent)localObject2).getIntExtra(a.d.frg(), 0));
      }
      ((com.tencent.mm.plugin.finder.live.viewmodel.state.a)localObject1).exc();
      localObject2 = ((com.tencent.mm.plugin.finder.live.viewmodel.state.a)localObject1).TAG;
      localObject3 = new StringBuilder("initLogic chooseMode:");
      paramBundle = ((com.tencent.mm.plugin.finder.live.viewmodel.state.a)localObject1).getActivity();
      if (!(paramBundle instanceof FinderLiveVisitorWhiteListUI)) {
        break label1627;
      }
      paramBundle = (FinderLiveVisitorWhiteListUI)paramBundle;
      label1351:
      if (paramBundle != null) {
        break label1632;
      }
    }
    label1549:
    label1582:
    label1587:
    label1592:
    label1597:
    label1602:
    label1607:
    label1612:
    label1617:
    label1622:
    label1627:
    label1632:
    for (paramBundle = null;; paramBundle = Integer.valueOf(paramBundle.BpS))
    {
      paramBundle = ((StringBuilder)localObject3).append(paramBundle).append(", visitorWhiteList size:").append(((com.tencent.mm.plugin.finder.live.viewmodel.state.a)localObject1).BpY.size()).append(",chooseWhiteList size:").append(((com.tencent.mm.plugin.finder.live.viewmodel.state.a)localObject1).BpZ.size()).append(",whiteList:");
      localObject3 = com.tencent.mm.plugin.finder.live.view.convert.a.DUC;
      Log.i((String)localObject2, com.tencent.mm.plugin.finder.live.view.convert.a.a(((com.tencent.mm.plugin.finder.live.viewmodel.state.a)localObject1).EiH));
      paramBundle = k.aeZF;
      paramBundle = (i)k.d((AppCompatActivity)this).q(i.class);
      localObject1 = paramBundle.getIntent();
      localObject2 = a.d.HbG;
      localObject2 = ((Intent)localObject1).getByteArrayExtra(a.d.frm());
      if (localObject2 != null)
      {
        localObject1 = new bfy();
        ((bfy)localObject1).parseFrom((byte[])localObject2);
        localObject2 = ah.aiuX;
        s.u(localObject1, "<set-?>");
        paramBundle.DYw = ((bfy)localObject1);
      }
      localObject1 = paramBundle.TAG;
      localObject2 = com.tencent.mm.plugin.finder.live.view.convert.a.DUC;
      Log.i((String)localObject1, s.X("live_charge_step1 initLogic liveChargeInfo:", com.tencent.mm.plugin.finder.live.view.convert.a.a(paramBundle.DYw)));
      Oo(this.BpS);
      AppMethodBeat.o(364472);
      return;
      paramBundle = null;
      break;
      localObject1 = paramBundle.DYo;
      if (localObject1 != null) {
        ((View)localObject1).setVisibility(8);
      }
      paramBundle = paramBundle.DYs;
      if (paramBundle == null) {
        break label795;
      }
      paramBundle.setVisibility(8);
      break label795;
      paramBundle = null;
      break label845;
      paramBundle = null;
      break label936;
      i = 0;
      break label977;
      paramBundle = null;
      break label998;
      i = 0;
      break label1071;
      paramBundle = null;
      break label1092;
      i = 0;
      break label1165;
      paramBundle = null;
      break label1186;
      paramBundle = null;
      break label1284;
      paramBundle = null;
      break label1351;
    }
  }
  
  public final void onDestroy()
  {
    AppMethodBeat.i(364542);
    super.onDestroy();
    Log.i("FinderLiveVisitorWhiteListUI", "[onDestroy]");
    AppMethodBeat.o(364542);
  }
  
  public final void onPause()
  {
    AppMethodBeat.i(364525);
    super.onPause();
    Log.i("FinderLiveVisitorWhiteListUI", "[onPause]");
    AppMethodBeat.o(364525);
  }
  
  public final void onResume()
  {
    AppMethodBeat.i(364514);
    super.onResume();
    Log.i("FinderLiveVisitorWhiteListUI", "[onResume]");
    AppMethodBeat.o(364514);
  }
  
  public final void onStart()
  {
    AppMethodBeat.i(364504);
    super.onStart();
    Log.i("FinderLiveVisitorWhiteListUI", "[onStart]");
    AppMethodBeat.o(364504);
  }
  
  public final void onStop()
  {
    AppMethodBeat.i(364534);
    super.onStop();
    Log.i("FinderLiveVisitorWhiteListUI", "[onStop]");
    AppMethodBeat.o(364534);
  }
  
  public final void onSwipeBack()
  {
    AppMethodBeat.i(364558);
    super.onSwipeBack();
    pq(true);
    AppMethodBeat.o(364558);
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
  
  public final void setPublicGroup(View paramView)
  {
    this.BpO = paramView;
  }
  
  public final void setShareGroup(View paramView)
  {
    this.BpQ = paramView;
  }
  
  public final void setTitleGroup(View paramView)
  {
    this.njm = paramView;
  }
  
  public final void superImportUIComponents(HashSet<Class<? extends UIComponent>> paramHashSet)
  {
    AppMethodBeat.i(364434);
    s.u(paramHashSet, "set");
    super.superImportUIComponents(paramHashSet);
    paramHashSet.add(com.tencent.mm.plugin.finder.live.viewmodel.state.a.class);
    paramHashSet.add(i.class);
    AppMethodBeat.o(364434);
  }
  
  @Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/feed/ui/FinderLiveVisitorWhiteListUI$Companion;", "", "()V", "TAG", "", "formatSelectedList", "selectedList", "Ljava/util/LinkedList;", "Lcom/tencent/mm/protocal/protobuf/FinderLiveAudienceListFile;", "formatSelectedListRoom", "", "formatSelectedUser", "Ljava/util/ArrayList;", "Lkotlin/collections/ArrayList;", "plugin-finder-live_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class a
  {
    public static String am(LinkedList<bfh> paramLinkedList)
    {
      AppMethodBeat.i(365549);
      s.u(paramLinkedList, "selectedList");
      StringBuilder localStringBuilder = new StringBuilder();
      Object localObject1 = (Iterable)paramLinkedList;
      int i = 0;
      localObject1 = ((Iterable)localObject1).iterator();
      while (((Iterator)localObject1).hasNext())
      {
        Object localObject2 = ((Iterator)localObject1).next();
        if (i < 0) {
          p.kkW();
        }
        localStringBuilder.append(((bfh)localObject2).title);
        if (i < paramLinkedList.size() - 1) {
          localStringBuilder.append(",");
        }
        i += 1;
      }
      paramLinkedList = localStringBuilder.toString();
      s.s(paramLinkedList, "result.toString()");
      AppMethodBeat.o(365549);
      return paramLinkedList;
    }
    
    public static String gi(List<String> paramList)
    {
      AppMethodBeat.i(365560);
      s.u(paramList, "selectedList");
      StringBuilder localStringBuilder = new StringBuilder();
      Iterator localIterator = ((Iterable)paramList).iterator();
      int i = 0;
      while (localIterator.hasNext())
      {
        Object localObject1 = localIterator.next();
        if (i < 0) {
          p.kkW();
        }
        localObject1 = (String)localObject1;
        Object localObject2 = ((n)h.ax(n.class)).bzA().bxu((String)localObject1);
        localObject1 = "";
        if (localObject2 != null)
        {
          localObject2 = ((com.tencent.mm.plugin.messenger.a.b)h.ax(com.tencent.mm.plugin.messenger.a.b.class)).b((au)localObject2, ((az)localObject2).field_username);
          localObject1 = localObject2;
          if (localObject2 == null) {
            localObject1 = "";
          }
        }
        localStringBuilder.append((String)localObject1);
        if (i < paramList.size() - 1) {
          localStringBuilder.append(",");
        }
        i += 1;
      }
      paramList = localStringBuilder.toString();
      s.s(paramList, "result.toString()");
      AppMethodBeat.o(365560);
      return paramList;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.feed.ui.FinderLiveVisitorWhiteListUI
 * JD-Core Version:    0.7.0.1
 */