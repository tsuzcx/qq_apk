package com.tencent.mm.plugin.forcenotify.ui;

import a.f.b.j;
import a.l;
import android.app.Activity;
import android.content.Context;
import android.content.res.Resources;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.RecyclerView.a;
import android.support.v7.widget.RecyclerView.i;
import android.support.v7.widget.RecyclerView.v;
import android.view.ContextMenu;
import android.view.ContextMenu.ContextMenuInfo;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnCreateContextMenuListener;
import android.view.View.OnLongClickListener;
import android.view.View.OnTouchListener;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.cb;
import com.tencent.mm.plugin.forcenotify.b.c;
import com.tencent.mm.sdk.e.k.a;
import com.tencent.mm.sdk.e.m;
import com.tencent.mm.sdk.g.a.e;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.at;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.n.d;
import java.util.ArrayList;

@l(eaO={1, 1, 13}, eaP={""}, eaQ={"Lcom/tencent/mm/plugin/forcenotify/ui/ForceNotifyListUI;", "Lcom/tencent/mm/ui/MMActivity;", "Lcom/tencent/mm/sdk/storage/MStorage$IOnStorageChange;", "()V", "TAG", "", "adapter", "Lcom/tencent/mm/plugin/forcenotify/ui/ForceNotifyListUI$ForceNotifyListAdapter;", "data", "Ljava/util/ArrayList;", "Lcom/tencent/mm/plugin/forcenotify/model/ForceNotifyInfo;", "emptyTipView", "Landroid/view/View;", "loadingView", "recyclerView", "Landroid/support/v7/widget/RecyclerView;", "touchLoc", "", "getLayoutId", "", "onBackPressed", "", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "onDestroy", "onNotifyChange", "event", "eventData", "Lcom/tencent/mm/sdk/storage/MStorageEventData;", "ForceNotifyListAdapter", "ForceNotifyViewHolder", "plugin-force-notify_release"})
public final class ForceNotifyListUI
  extends MMActivity
  implements k.a
{
  private final String TAG;
  private RecyclerView iQe;
  private View jjH;
  private ForceNotifyListUI.a mHE;
  private View mHF;
  private final ArrayList<com.tencent.mm.plugin.forcenotify.c.d> mHG;
  private final int[] mHH;
  
  public ForceNotifyListUI()
  {
    AppMethodBeat.i(51083);
    this.TAG = "MicroMsg.ForceNotifyListUI";
    this.mHG = new ArrayList();
    this.mHH = new int[2];
    AppMethodBeat.o(51083);
  }
  
  public final void a(String paramString, m paramm)
  {
    AppMethodBeat.i(51082);
    ab.i(this.TAG, "[onNotifyChange] event:%s", new Object[] { paramString });
    com.tencent.mm.sdk.g.d.ysm.execute((Runnable)new ForceNotifyListUI.e(this));
    AppMethodBeat.o(51082);
  }
  
  public final int getLayoutId()
  {
    return 2130969624;
  }
  
  public final void onBackPressed()
  {
    AppMethodBeat.i(51079);
    super.onBackPressed();
    finish();
    AppMethodBeat.o(51079);
  }
  
  public final void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(51080);
    super.onCreate(paramBundle);
    com.tencent.mm.plugin.forcenotify.d.a.mHw.add((k.a)this);
    setMMTitle(2131300119);
    setBackBtn((MenuItem.OnMenuItemClickListener)new ForceNotifyListUI.c(this));
    this.jjH = findViewById(2131824243);
    this.mHF = findViewById(2131821537);
    this.iQe = ((RecyclerView)findViewById(2131821002));
    paramBundle = this.iQe;
    if (paramBundle == null) {
      j.ebi();
    }
    getContext();
    paramBundle.setLayoutManager((RecyclerView.i)new LinearLayoutManager());
    this.mHE = new ForceNotifyListUI.a(this);
    paramBundle = this.iQe;
    if (paramBundle == null) {
      j.ebi();
    }
    paramBundle.setAdapter((RecyclerView.a)this.mHE);
    com.tencent.mm.sdk.g.d.ysm.execute((Runnable)new ForceNotifyListUI.d(this));
    ((com.tencent.mm.plugin.forcenotify.a.a)g.E(com.tencent.mm.plugin.forcenotify.a.a.class)).g("", 1, cb.abq() / 1000L);
    AppMethodBeat.o(51080);
  }
  
  public final void onDestroy()
  {
    AppMethodBeat.i(51081);
    super.onDestroy();
    com.tencent.mm.plugin.forcenotify.d.a.mHw.remove((k.a)this);
    ((com.tencent.mm.plugin.forcenotify.a.a)g.E(com.tencent.mm.plugin.forcenotify.a.a.class)).g("", 2, cb.abq() / 1000L);
    AppMethodBeat.o(51081);
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
  
  @l(eaO={1, 1, 13}, eaP={""}, eaQ={"Lcom/tencent/mm/plugin/forcenotify/ui/ForceNotifyListUI$ForceNotifyViewHolder;", "Landroid/support/v7/widget/RecyclerView$ViewHolder;", "Landroid/view/View$OnCreateContextMenuListener;", "Lcom/tencent/mm/ui/base/MMMenuListener$OnMMMenuItemSelectedListener;", "itemView", "Landroid/view/View;", "(Lcom/tencent/mm/plugin/forcenotify/ui/ForceNotifyListUI;Landroid/view/View;)V", "avatar", "Landroid/widget/ImageView;", "getAvatar", "()Landroid/widget/ImageView;", "forcePushId", "", "getForcePushId", "()Ljava/lang/String;", "setForcePushId", "(Ljava/lang/String;)V", "refreshView", "getRefreshView", "()Landroid/view/View;", "resetView", "Landroid/widget/LinearLayout;", "getResetView", "()Landroid/widget/LinearLayout;", "timeView", "Landroid/widget/TextView;", "getTimeView", "()Landroid/widget/TextView;", "titleView", "getTitleView", "userView", "getUserView", "username", "getUsername", "setUsername", "onCreateContextMenu", "", "menu", "Landroid/view/ContextMenu;", "v", "menuInfo", "Landroid/view/ContextMenu$ContextMenuInfo;", "onMMMenuItemSelected", "menuItem", "Landroid/view/MenuItem;", "index", "", "plugin-force-notify_release"})
  public final class b
    extends RecyclerView.v
    implements View.OnCreateContextMenuListener, n.d
  {
    final ImageView gxs;
    final TextView mHJ;
    final TextView mHK;
    final LinearLayout mHL;
    final View mHM;
    String mHN;
    final TextView titleView;
    String username;
    
    public b()
    {
      super();
      AppMethodBeat.i(51073);
      this$1 = localObject.findViewById(2131821210);
      if (ForceNotifyListUI.this == null) {
        j.ebi();
      }
      this.gxs = ((ImageView)ForceNotifyListUI.this);
      this$1 = localObject.findViewById(2131821212);
      if (ForceNotifyListUI.this == null) {
        j.ebi();
      }
      this.titleView = ((TextView)ForceNotifyListUI.this);
      this$1 = localObject.findViewById(2131824239);
      if (ForceNotifyListUI.this == null) {
        j.ebi();
      }
      this.mHJ = ((TextView)ForceNotifyListUI.this);
      this.mHK = ((TextView)localObject.findViewById(2131824242));
      this$1 = localObject.findViewById(2131824240);
      if (ForceNotifyListUI.this == null) {
        j.ebi();
      }
      this.mHL = ((LinearLayout)ForceNotifyListUI.this);
      this$1 = localObject.findViewById(2131824241);
      if (ForceNotifyListUI.this == null) {
        j.ebi();
      }
      this.mHM = ForceNotifyListUI.this;
      this$1 = localObject.findViewById(2131820946);
      ForceNotifyListUI.this.setOnTouchListener((View.OnTouchListener)new ForceNotifyListUI.b.1(this));
      ForceNotifyListUI.this.setOnLongClickListener((View.OnLongClickListener)new ForceNotifyListUI.b.2(this));
      this.mHL.setOnClickListener((View.OnClickListener)new ForceNotifyListUI.b.3(this));
      AppMethodBeat.o(51073);
    }
    
    public final void onCreateContextMenu(ContextMenu paramContextMenu, View paramView, ContextMenu.ContextMenuInfo paramContextMenuInfo)
    {
      AppMethodBeat.i(51072);
      j.q(paramContextMenu, "menu");
      paramView = ForceNotifyListUI.this.getBaseContext();
      j.p(paramView, "baseContext");
      paramContextMenu.add((CharSequence)paramView.getResources().getString(2131300127));
      AppMethodBeat.o(51072);
    }
    
    public final void onMMMenuItemSelected(MenuItem paramMenuItem, int paramInt)
    {
      AppMethodBeat.i(51071);
      if (!at.isNetworkConnected(ah.getContext()))
      {
        Toast.makeText((Context)ForceNotifyListUI.this.getContext(), ForceNotifyListUI.this.getResources().getText(2131300044), 1).show();
        AppMethodBeat.o(51071);
        return;
      }
      ForceNotifyListUI.a(ForceNotifyListUI.this).remove(jN());
      paramMenuItem = ForceNotifyListUI.b(ForceNotifyListUI.this);
      if (paramMenuItem == null) {
        j.ebi();
      }
      paramMenuItem.bT(jN());
      c.mHu.an(this.mHN, 4);
      if (ForceNotifyListUI.a(ForceNotifyListUI.this).isEmpty())
      {
        paramMenuItem = ForceNotifyListUI.c(ForceNotifyListUI.this);
        if (paramMenuItem == null) {
          j.ebi();
        }
        paramMenuItem.setVisibility(8);
        paramMenuItem = ForceNotifyListUI.d(ForceNotifyListUI.this);
        if (paramMenuItem == null) {
          j.ebi();
        }
        paramMenuItem.setVisibility(0);
      }
      AppMethodBeat.o(51071);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.forcenotify.ui.ForceNotifyListUI
 * JD-Core Version:    0.7.0.1
 */