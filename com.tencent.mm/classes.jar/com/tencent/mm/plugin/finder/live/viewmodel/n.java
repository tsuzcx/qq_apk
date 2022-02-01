package com.tencent.mm.plugin.finder.live.viewmodel;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.text.format.Time;
import android.view.ContextMenu;
import android.view.ContextMenu.ContextMenuInfo;
import android.view.MenuItem;
import android.view.MotionEvent;
import android.view.View;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.RecyclerView.LayoutManager;
import androidx.recyclerview.widget.RecyclerView.a;
import androidx.recyclerview.widget.RecyclerView.b;
import androidx.recyclerview.widget.RecyclerView.k;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ae.d;
import com.tencent.mm.model.cn;
import com.tencent.mm.plugin.finder.api.j;
import com.tencent.mm.plugin.finder.live.cgi.h.a;
import com.tencent.mm.plugin.finder.live.cgi.w.a;
import com.tencent.mm.plugin.finder.live.p.a;
import com.tencent.mm.plugin.finder.live.p.b;
import com.tencent.mm.plugin.finder.live.p.e;
import com.tencent.mm.plugin.finder.live.p.f;
import com.tencent.mm.plugin.finder.live.p.g;
import com.tencent.mm.plugin.finder.live.p.h;
import com.tencent.mm.plugin.finder.live.view.adapter.ai;
import com.tencent.mm.plugin.finder.utils.aw;
import com.tencent.mm.plugin.findersdk.a.a;
import com.tencent.mm.plugin.findersdk.a.az;
import com.tencent.mm.pluginsdk.platformtools.e;
import com.tencent.mm.protocal.protobuf.bcz;
import com.tencent.mm.protocal.protobuf.bni;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.storage.aq;
import com.tencent.mm.storage.at.a;
import com.tencent.mm.ui.base.aa;
import com.tencent.mm.ui.component.UIComponent;
import com.tencent.mm.ui.widget.a.g.a;
import com.tencent.mm.ui.widget.imageview.WeImageView;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import kotlin.Metadata;
import kotlin.ah;
import kotlin.g.a.m;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/live/viewmodel/FinderLiveVisitorRoleUIC;", "Lcom/tencent/mm/ui/component/UIComponent;", "Lcom/tencent/mm/plugin/findersdk/api/IFinderLiveVisitorRoleUIC;", "activity", "Landroidx/appcompat/app/AppCompatActivity;", "(Landroidx/appcompat/app/AppCompatActivity;)V", "TAG", "", "getTAG", "()Ljava/lang/String;", "aliasInfoList", "Ljava/util/LinkedList;", "Lcom/tencent/mm/protocal/protobuf/FinderLiveAliasInfo;", "canModifyAlias", "", "curRoleType", "", "deleteBottomSheet", "Lcom/tencent/mm/ui/widget/dialog/MMBottomSheet;", "enableVisitorRoleEntrance", "getEnableVisitorRoleEntrance", "()Z", "setEnableVisitorRoleEntrance", "(Z)V", "fromSetting", "liveVisitorRoleGroup", "Landroid/view/View;", "getLiveVisitorRoleGroup", "()Landroid/view/View;", "setLiveVisitorRoleGroup", "(Landroid/view/View;)V", "loadingProgress", "Landroid/widget/ProgressBar;", "modifyTime", "", "popupMenu", "Lcom/tencent/mm/ui/widget/menu/MMPopupMenu;", "roleTypeOnEnter", "sourceType", "touchLoc", "", "visitorRoleAdapter", "Lcom/tencent/mm/plugin/finder/live/view/adapter/FinderLiveVisitorRoleAdapter;", "visitorRv", "Landroidx/recyclerview/widget/RecyclerView;", "visitorTips", "Landroid/widget/TextView;", "doRemoveAliasInfo", "", "getModifyTimeInfo", "goBack", "onActivityResult", "requestCode", "resultCode", "data", "Landroid/content/Intent;", "onBackPressed", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "onResume", "parseData", "refreshLayout", "removeAliasInfo", "setActivityResult", "showAlertDialog", "title", "content", "buttonTitle", "showBottomSheet", "showPopupMenu", "itemView", "aliasInfo", "anchorPosX", "anchorPosY", "updateVisitorRole", "Companion", "plugin-finder-live_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class n
  extends UIComponent
  implements az
{
  public static final n.a DZH;
  private int[] Cxl;
  private int DTI;
  private ProgressBar DZB;
  private View DZI;
  private TextView DZJ;
  private com.tencent.mm.ui.widget.a.f DZK;
  private boolean DZL;
  private LinkedList<bcz> DZM;
  private long DZN;
  private boolean DZO;
  private int DZP;
  private boolean Dgj;
  private RecyclerView DmN;
  private ai DmR;
  final String TAG;
  private int sourceType;
  private com.tencent.mm.ui.widget.b.a vEV;
  
  static
  {
    AppMethodBeat.i(356371);
    DZH = new n.a((byte)0);
    AppMethodBeat.o(356371);
  }
  
  public n(AppCompatActivity paramAppCompatActivity)
  {
    super(paramAppCompatActivity);
    AppMethodBeat.i(356162);
    this.TAG = "FinderLiveVisitorRoleUIC";
    this.Dgj = true;
    this.Cxl = new int[2];
    this.DZM = new LinkedList();
    this.DTI = 1;
    this.DZN = -9223372036854775808L;
    this.DZO = true;
    this.DZP = 1;
    AppMethodBeat.o(356162);
  }
  
  private static final void a(n paramn, ContextMenu paramContextMenu, View paramView, ContextMenu.ContextMenuInfo paramContextMenuInfo)
  {
    AppMethodBeat.i(356215);
    kotlin.g.b.s.u(paramn, "this$0");
    paramContextMenu.add(0, 1, 0, (CharSequence)paramn.getContext().getResources().getString(p.h.CtK));
    paramContextMenu.add(0, 2, 1, (CharSequence)paramn.getContext().getResources().getString(p.h.CtI));
    AppMethodBeat.o(356215);
  }
  
  private static final void a(n paramn, MenuItem paramMenuItem, int paramInt)
  {
    AppMethodBeat.i(356255);
    kotlin.g.b.s.u(paramn, "this$0");
    if (paramMenuItem.getItemId() == 10001) {
      new com.tencent.mm.plugin.finder.live.cgi.h((h.a)new n.e(paramn)).bFJ();
    }
    paramn = paramn.DZK;
    if (paramn != null) {
      paramn.cyW();
    }
    AppMethodBeat.o(356255);
  }
  
  private static final void a(n paramn, bcz parambcz, MenuItem paramMenuItem, int paramInt)
  {
    AppMethodBeat.i(356235);
    kotlin.g.b.s.u(paramn, "this$0");
    kotlin.g.b.s.u(parambcz, "$aliasInfo");
    Object localObject1;
    Object localObject2;
    switch (paramMenuItem.getItemId())
    {
    default: 
      AppMethodBeat.o(356235);
      return;
    case 1: 
      paramMenuItem = paramn.vEV;
      if (paramMenuItem != null) {
        paramMenuItem.diW();
      }
      paramInt = cn.getSyncServerTimeSecond();
      Log.i(paramn.TAG, "showPopupMenu modifyTime:" + paramn.DZN + ",serverTime:" + paramInt);
      paramMenuItem = paramn.getContext().getResources().getString(p.h.CtD);
      kotlin.g.b.s.s(paramMenuItem, "context.resources.getStr…bidden_edit_dialog_title)");
      if (paramn.DZN == -9223372036854775808L)
      {
        aa.makeText((Context)paramn.getContext(), (CharSequence)paramMenuItem, 0).show();
        AppMethodBeat.o(356235);
        return;
      }
      localObject1 = aw.Gjk;
      if ((aw.bgV()) || (paramn.DZN - cn.getSyncServerTimeSecond() <= 0L))
      {
        paramMenuItem = (com.tencent.mm.plugin.f)com.tencent.mm.kernel.h.ax(com.tencent.mm.plugin.f.class);
        localObject1 = (Activity)paramn.getActivity();
        localObject2 = new Intent();
        localObject3 = a.a.Hbu;
        ((Intent)localObject2).putExtra(a.a.fqV(), parambcz.nickname);
        localObject3 = a.a.Hbu;
        ((Intent)localObject2).putExtra(a.a.fqW(), parambcz.xkY);
        ((Intent)localObject2).putExtra("KEY_SOURCE", paramn.getIntent().getIntExtra("KEY_SOURCE", 0));
        paramn = ah.aiuX;
        paramMenuItem.h((Activity)localObject1, (Intent)localObject2);
        AppMethodBeat.o(356235);
        return;
      }
      localObject2 = paramn.exB();
      parambcz = "";
      localObject1 = new g.a((Context)paramn.getContext());
      Object localObject3 = (CharSequence)paramMenuItem;
      if ((localObject3 == null) || (((CharSequence)localObject3).length() == 0))
      {
        paramInt = 1;
        label346:
        if (paramInt == 0) {
          break label440;
        }
        ((g.a)localObject1).bDE((String)localObject2);
        label358:
        ((g.a)localObject1).Xdm = true;
        paramMenuItem = paramn.getContext().getResources().getString(p.h.ChT);
        kotlin.g.b.s.s(paramMenuItem, "context.resources.getStr…ive_alert_dialog_btn_txt)");
        if (((CharSequence)"").length() != 0) {
          break label458;
        }
        paramInt = 1;
        label401:
        if (paramInt != 0) {
          break label484;
        }
      }
      break;
    }
    for (;;)
    {
      ((g.a)localObject1).bDI(parambcz);
      ((g.a)localObject1).b(new n..ExternalSyntheticLambda4(paramn)).show();
      AppMethodBeat.o(356235);
      return;
      paramInt = 0;
      break label346;
      label440:
      ((g.a)localObject1).bf((CharSequence)paramMenuItem).bDE((String)localObject2);
      break label358;
      label458:
      paramInt = 0;
      break label401;
      parambcz = paramn.vEV;
      if (parambcz != null) {
        parambcz.diW();
      }
      paramn.cpX();
      break;
      label484:
      parambcz = paramMenuItem;
    }
  }
  
  private static final void a(n paramn, com.tencent.mm.ui.base.s params)
  {
    AppMethodBeat.i(356245);
    kotlin.g.b.s.u(paramn, "this$0");
    params.a(10001, paramn.getContext().getResources().getColor(p.b.Red_100), (CharSequence)paramn.getContext().getResources().getString(p.h.CtI));
    AppMethodBeat.o(356245);
  }
  
  private static final void a(n paramn, boolean paramBoolean, String paramString)
  {
    AppMethodBeat.i(356267);
    kotlin.g.b.s.u(paramn, "this$0");
    Log.i(paramn.TAG, kotlin.g.b.s.X("showAlertDialog click bOk:", Boolean.valueOf(paramBoolean)));
    AppMethodBeat.o(356267);
  }
  
  private final void cpX()
  {
    AppMethodBeat.i(356187);
    this.DZK = new com.tencent.mm.ui.widget.a.f((Context)getContext(), 1, false);
    Object localObject1 = View.inflate((Context)getContext(), p.f.live_bottom_sheet_title_view, null);
    Object localObject2 = (TextView)((View)localObject1).findViewById(p.e.live_bottom_sheet_title_tv);
    ((TextView)localObject2).setText((CharSequence)getContext().getResources().getString(p.h.CtB));
    ((TextView)localObject2).setTextColor(MMApplicationContext.getContext().getResources().getColor(p.b.UN_BW_0_Alpha_0_5));
    localObject2 = this.DZK;
    if (localObject2 != null) {
      ((com.tencent.mm.ui.widget.a.f)localObject2).af((View)localObject1, false);
    }
    localObject1 = this.DZK;
    if (localObject1 != null) {
      ((com.tencent.mm.ui.widget.a.f)localObject1).Vtg = new n..ExternalSyntheticLambda1(this);
    }
    localObject1 = this.DZK;
    if (localObject1 != null) {
      ((com.tencent.mm.ui.widget.a.f)localObject1).GAC = new n..ExternalSyntheticLambda2(this);
    }
    localObject1 = this.DZK;
    if (localObject1 != null) {
      ((com.tencent.mm.ui.widget.a.f)localObject1).dDn();
    }
    AppMethodBeat.o(356187);
  }
  
  private final void exA()
  {
    AppMethodBeat.i(356198);
    Log.i(this.TAG, kotlin.g.b.s.X("before removeAliasInfo size:", Integer.valueOf(this.DZM.size())));
    Object localObject1 = this.DZM.iterator();
    kotlin.g.b.s.s(localObject1, "aliasInfoList.iterator()");
    while (((Iterator)localObject1).hasNext())
    {
      Object localObject2 = ((Iterator)localObject1).next();
      kotlin.g.b.s.s(localObject2, "iterator.next()");
      localObject2 = (bcz)localObject2;
      if (((bcz)localObject2).ZNI == 2)
      {
        ((Iterator)localObject1).remove();
        Log.i(this.TAG, kotlin.g.b.s.X("removeAliasInfo:", com.tencent.mm.ae.f.dg(localObject2)));
      }
    }
    Log.i(this.TAG, kotlin.g.b.s.X("after removeAliasInfo size:", Integer.valueOf(this.DZM.size())));
    localObject1 = com.tencent.mm.plugin.finder.live.utils.a.DJT;
    com.tencent.mm.plugin.finder.live.utils.a.u(this.DZM);
    AppMethodBeat.o(356198);
  }
  
  private final String exB()
  {
    AppMethodBeat.i(356206);
    Object localObject = new Time();
    ((Time)localObject).set(this.DZN * 1000L);
    localObject = e.a((CharSequence)getContext().getString(p.h.fmt_longdate), (Time)localObject);
    localObject = getContext().getResources().getString(p.h.CtC, new Object[] { localObject });
    kotlin.g.b.s.s(localObject, "context.resources.getStr…_dialog_content, timeStr)");
    AppMethodBeat.o(356206);
    return localObject;
  }
  
  private final void exy()
  {
    boolean bool = true;
    AppMethodBeat.i(356168);
    Object localObject1 = this.TAG;
    Object localObject2 = new StringBuilder("setActivityResult fromSetting:").append(this.DZL).append(", ");
    Object localObject3 = com.tencent.mm.plugin.finder.live.utils.a.DJT;
    Log.i((String)localObject1, com.tencent.mm.plugin.finder.live.utils.a.a(this.TAG, this.DZM, this.DTI, this.DZN));
    localObject1 = com.tencent.mm.plugin.finder.live.utils.a.DJT;
    com.tencent.mm.plugin.finder.live.utils.a.a(this.DZM, this.DTI, this.DZN);
    localObject1 = getActivity();
    localObject2 = new Intent();
    if (this.sourceType == 1) {
      ((Intent)localObject2).putExtra("KEY_IS_FROM_SETTING", this.DZL);
    }
    while (this.sourceType != 2)
    {
      localObject3 = ah.aiuX;
      ((AppCompatActivity)localObject1).setResult(-1, (Intent)localObject2);
      AppMethodBeat.o(356168);
      return;
    }
    if (this.DZP != this.DTI) {}
    for (;;)
    {
      ((Intent)localObject2).putExtra("KEY_HAS_CHANGE_ROLE", bool);
      break;
      bool = false;
    }
  }
  
  private final void exz()
  {
    boolean bool2 = true;
    AppMethodBeat.i(356176);
    boolean bool1;
    Object localObject;
    if (this.DZN - cn.getSyncServerTimeSecond() <= 0L)
    {
      bool1 = true;
      localObject = aw.Gjk;
      if (!aw.bgV()) {
        break label187;
      }
      bool1 = bool2;
    }
    label180:
    label187:
    for (;;)
    {
      localObject = com.tencent.mm.plugin.finder.live.utils.a.DJT;
      bool2 = com.tencent.mm.plugin.finder.live.utils.a.as(this.DZM);
      localObject = this.DmR;
      if (localObject != null) {
        ((ai)localObject).a(this.DTI, this.DZM, bool1);
      }
      localObject = this.DmR;
      if (localObject != null) {
        ((RecyclerView.a)localObject).bZE.notifyChanged();
      }
      if (bool1)
      {
        if (!bool2)
        {
          localObject = this.DZJ;
          if (localObject == null) {
            break label180;
          }
          ((TextView)localObject).setText((CharSequence)MMApplicationContext.getContext().getResources().getString(p.h.finder_live_visitor_role_create_tips));
          AppMethodBeat.o(356176);
          return;
          bool1 = false;
          break;
        }
        localObject = this.DZJ;
        if (localObject == null) {
          break label180;
        }
        ((TextView)localObject).setText((CharSequence)"");
        AppMethodBeat.o(356176);
        return;
      }
      localObject = this.DZJ;
      if (localObject != null) {
        ((TextView)localObject).setText((CharSequence)exB());
      }
      AppMethodBeat.o(356176);
      return;
    }
  }
  
  public final void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    AppMethodBeat.i(356468);
    Object localObject1;
    Object localObject2;
    label78:
    label86:
    Object localObject3;
    if (paramInt1 == 1)
    {
      Log.i(this.TAG, "requestCode:" + paramInt1 + ",resultCode:" + paramInt2 + ",data:" + paramIntent);
      if (paramInt2 == -1)
      {
        if (paramIntent != null) {
          break label201;
        }
        localObject1 = "";
        if (paramIntent != null) {
          break label231;
        }
        localObject2 = "";
        if (paramIntent != null) {
          break label261;
        }
        paramIntent = "";
        localObject3 = new bcz();
        ((bcz)localObject3).nickname = ((String)localObject1);
        ((bcz)localObject3).xkY = ((String)localObject2);
        ((bcz)localObject3).ZNJ = paramIntent;
        ((bcz)localObject3).ZNI = 2;
        exA();
        if (this.DZM.size() <= 0) {
          break label290;
        }
        this.DZM.add(1, localObject3);
      }
    }
    for (;;)
    {
      paramIntent = this.DmR;
      if (paramIntent != null) {
        paramIntent.a(this.DTI, this.DZM, true);
      }
      paramIntent = this.DmR;
      if (paramIntent != null) {
        paramIntent.bZE.notifyChanged();
      }
      paramIntent = com.tencent.mm.plugin.finder.live.utils.a.DJT;
      com.tencent.mm.plugin.finder.live.utils.a.u(this.DZM);
      AppMethodBeat.o(356468);
      return;
      label201:
      localObject1 = a.a.Hbu;
      localObject1 = paramIntent.getStringExtra(a.a.fqV());
      if (localObject1 == null)
      {
        localObject1 = "";
        break;
      }
      break;
      label231:
      localObject2 = a.a.Hbu;
      localObject2 = paramIntent.getStringExtra(a.a.fqW());
      if (localObject2 == null)
      {
        localObject2 = "";
        break label78;
      }
      break label78;
      label261:
      localObject3 = a.a.Hbu;
      localObject3 = paramIntent.getStringExtra(a.a.fqX());
      paramIntent = (Intent)localObject3;
      if (localObject3 != null) {
        break label86;
      }
      paramIntent = "";
      break label86;
      label290:
      this.DZM.add(localObject3);
    }
  }
  
  public final boolean onBackPressed()
  {
    AppMethodBeat.i(356454);
    if ((this.Dgj) && ((this.sourceType == 1) || (this.sourceType == 2))) {
      exy();
    }
    getActivity().finish();
    if (this.sourceType != 0) {
      getActivity().overridePendingTransition(p.a.anim_not_change, p.a.sight_slide_bottom_out);
    }
    AppMethodBeat.o(356454);
    return true;
  }
  
  public final void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(356447);
    super.onCreate(paramBundle);
    this.DZI = findViewById(p.e.live_role_group);
    this.DZB = ((ProgressBar)findViewById(p.e.loading_progress));
    paramBundle = com.tencent.mm.plugin.finder.live.utils.a.DJT;
    this.Dgj = com.tencent.mm.plugin.finder.live.utils.a.euD();
    if (this.Dgj)
    {
      paramBundle = this.DZI;
      if (paramBundle != null) {
        paramBundle.setVisibility(0);
      }
    }
    Object localObject;
    for (;;)
    {
      if (getIntent().getBooleanExtra("intent_status_from_privacy_to_video_setting", false))
      {
        paramBundle = this.DZI;
        if (paramBundle != null) {
          paramBundle.setVisibility(8);
        }
      }
      this.DmN = ((RecyclerView)findViewById(p.e.visitor_rv));
      this.DZJ = ((TextView)findViewById(p.e.visitor_tips));
      this.DmR = new ai();
      paramBundle = this.DmR;
      if (paramBundle != null)
      {
        paramBundle.DTG = ((kotlin.g.a.b)new b(this));
        paramBundle.DTH = ((m)new c(this));
      }
      paramBundle = this.DmN;
      if (paramBundle != null)
      {
        paramBundle.getContext();
        paramBundle.setLayoutManager((RecyclerView.LayoutManager)new LinearLayoutManager(1, false));
        paramBundle.setAdapter((RecyclerView.a)this.DmR);
        paramBundle.a((RecyclerView.k)new d(this));
      }
      this.sourceType = getIntent().getIntExtra("KEY_SOURCE", 0);
      this.DZL = getIntent().getBooleanExtra("KEY_IS_FROM_SETTING", true);
      this.DZO = getIntent().getBooleanExtra("KEY_CAN_MODEI_ALIAS", true);
      if ((!this.DZL) && (this.sourceType != 2)) {
        break;
      }
      paramBundle = com.tencent.mm.plugin.finder.live.util.u.DJC;
      this.DZM = com.tencent.mm.plugin.finder.live.util.u.euA();
      this.DTI = com.tencent.mm.kernel.h.baE().ban().getInt(at.a.adaO, 1);
      this.DZN = com.tencent.mm.kernel.h.baE().ban().a(at.a.adaS, -9223372036854775808L);
      if (this.DZM.size() > 0) {
        com.tencent.mm.kernel.h.baE().ban().set(at.a.adaT, Boolean.TRUE);
      }
      this.DZP = this.DTI;
      paramBundle = this.TAG;
      localObject = new StringBuilder("parseInten fromSetting:").append(this.DZL).append(',');
      com.tencent.mm.plugin.finder.live.utils.a locala = com.tencent.mm.plugin.finder.live.utils.a.DJT;
      Log.i(paramBundle, com.tencent.mm.plugin.finder.live.utils.a.a(this.TAG, this.DZM, this.DTI, this.DZN));
      exz();
      Log.i(this.TAG, kotlin.g.b.s.X("onCreate enableVisitorRoleEntrance:", Boolean.valueOf(this.Dgj)));
      AppMethodBeat.o(356447);
      return;
      paramBundle = this.DZI;
      if (paramBundle != null) {
        paramBundle.setVisibility(8);
      }
      paramBundle = this.DZB;
      if (paramBundle != null) {
        paramBundle.setVisibility(8);
      }
    }
    paramBundle = getIntent().getSerializableExtra("KEY_VISITOR_ROLE_LIST");
    if ((paramBundle instanceof List)) {}
    for (paramBundle = (List)paramBundle;; paramBundle = null)
    {
      if (paramBundle != null)
      {
        localObject = com.tencent.mm.plugin.finder.live.utils.a.DJT;
        com.tencent.mm.plugin.finder.live.utils.a.b(paramBundle, this.DZM);
      }
      this.DTI = getIntent().getIntExtra("KEY_VISITOR_ROLE", 1);
      this.DZN = getIntent().getLongExtra("KEY_MODIFY_TIME", -9223372036854775808L);
      break;
    }
  }
  
  public final void onResume()
  {
    AppMethodBeat.i(356478);
    super.onResume();
    ((com.tencent.mm.plugin.h)com.tencent.mm.kernel.h.ax(com.tencent.mm.plugin.h.class)).getFinderSyncExtension().ho(65536, 9);
    AppMethodBeat.o(356478);
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", "", "it", "Lcom/tencent/mm/protocal/protobuf/FinderLiveAliasInfo;"}, k=3, mv={1, 5, 1}, xi=48)
  static final class b
    extends kotlin.g.b.u
    implements kotlin.g.a.b<bcz, ah>
  {
    b(n paramn)
    {
      super();
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", "", "aliasInfo", "Lcom/tencent/mm/protocal/protobuf/FinderLiveAliasInfo;", "itemView", "Landroid/view/View;"}, k=3, mv={1, 5, 1}, xi=48)
  static final class c
    extends kotlin.g.b.u
    implements m<bcz, View, ah>
  {
    c(n paramn)
    {
      super();
    }
  }
  
  @Metadata(d1={""}, d2={"com/tencent/mm/plugin/finder/live/viewmodel/FinderLiveVisitorRoleUIC$onCreate$2$1", "Landroidx/recyclerview/widget/RecyclerView$OnItemTouchListener;", "onInterceptTouchEvent", "", "recyclerView", "Landroidx/recyclerview/widget/RecyclerView;", "motionEvent", "Landroid/view/MotionEvent;", "onRequestDisallowInterceptTouchEvent", "", "p0", "onTouchEvent", "p1", "plugin-finder-live_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class d
    implements RecyclerView.k
  {
    d(n paramn) {}
    
    public final boolean a(RecyclerView paramRecyclerView, MotionEvent paramMotionEvent)
    {
      AppMethodBeat.i(356533);
      kotlin.g.b.s.u(paramRecyclerView, "recyclerView");
      kotlin.g.b.s.u(paramMotionEvent, "motionEvent");
      n.i(this.DZQ)[0] = ((int)paramMotionEvent.getRawX());
      n.i(this.DZQ)[1] = ((int)paramMotionEvent.getRawY());
      AppMethodBeat.o(356533);
      return false;
    }
    
    public final void aX(boolean paramBoolean) {}
    
    public final void b(RecyclerView paramRecyclerView, MotionEvent paramMotionEvent)
    {
      AppMethodBeat.i(356531);
      com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
      localb.cH(paramRecyclerView);
      localb.cH(paramMotionEvent);
      com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/finder/live/viewmodel/FinderLiveVisitorRoleUIC$onCreate$2$1", "androidx/recyclerview/widget/RecyclerView$OnItemTouchListener", "onTouchEvent", "(Landroidx/recyclerview/widget/RecyclerView;Landroid/view/MotionEvent;)V", this, localb.aYj());
      kotlin.g.b.s.u(paramRecyclerView, "p0");
      kotlin.g.b.s.u(paramMotionEvent, "p1");
      com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/finder/live/viewmodel/FinderLiveVisitorRoleUIC$onCreate$2$1", "androidx/recyclerview/widget/RecyclerView$OnItemTouchListener", "onTouchEvent", "(Landroidx/recyclerview/widget/RecyclerView;Landroid/view/MotionEvent;)V");
      AppMethodBeat.o(356531);
    }
  }
  
  @Metadata(d1={""}, d2={"com/tencent/mm/plugin/finder/live/viewmodel/FinderLiveVisitorRoleUIC$updateVisitorRole$2", "Lcom/tencent/mm/plugin/finder/live/cgi/CgiFinderLiveSwitchIdentity$CallBack;", "onFail", "", "errType", "", "errCode", "errMsg", "", "onSuccess", "resp", "Lcom/tencent/mm/protocal/protobuf/FinderLiveSwitchIdentityResponse;", "plugin-finder-live_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class f
    implements w.a
  {
    f(n paramn, int paramInt) {}
    
    public final void a(bni parambni)
    {
      AppMethodBeat.i(356541);
      kotlin.g.b.s.u(parambni, "resp");
      d.uiThread((kotlin.g.a.a)new b(this.DZQ, this.DZR));
      AppMethodBeat.o(356541);
    }
    
    public final void awj(final String paramString)
    {
      AppMethodBeat.i(356547);
      d.uiThread((kotlin.g.a.a)new a(this.DZQ, paramString));
      AppMethodBeat.o(356547);
    }
    
    @Metadata(d1={""}, d2={"<anonymous>", ""}, k=3, mv={1, 5, 1}, xi=48)
    static final class a
      extends kotlin.g.b.u
      implements kotlin.g.a.a<ah>
    {
      a(n paramn, String paramString)
      {
        super();
      }
      
      private static final void invoke$lambda-0(View paramView)
      {
        AppMethodBeat.i(356157);
        if (paramView != null)
        {
          TextView localTextView = (TextView)paramView.findViewById(p.e.toast_text);
          if (localTextView != null) {
            localTextView.setTextSize(1, 14.0F);
          }
        }
        if (paramView != null)
        {
          paramView = (WeImageView)paramView.findViewById(p.e.toast_img);
          if (paramView != null) {
            paramView.setImageResource(p.g.icons_filled_error);
          }
        }
        AppMethodBeat.o(356157);
      }
    }
    
    @Metadata(d1={""}, d2={"<anonymous>", ""}, k=3, mv={1, 5, 1}, xi=48)
    static final class b
      extends kotlin.g.b.u
      implements kotlin.g.a.a<ah>
    {
      b(n paramn, int paramInt)
      {
        super();
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.live.viewmodel.n
 * JD-Core Version:    0.7.0.1
 */