package com.tencent.mm.plugin.forcenotify.ui;

import android.content.Context;
import android.content.res.Resources;
import android.os.Bundle;
import android.view.ContextMenu;
import android.view.ContextMenu.ContextMenuInfo;
import android.view.MenuItem;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnCreateContextMenuListener;
import android.view.ViewPropertyAnimator;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.RecyclerView.LayoutManager;
import androidx.recyclerview.widget.RecyclerView.a;
import androidx.recyclerview.widget.RecyclerView.b;
import androidx.recyclerview.widget.RecyclerView.v;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.model.cn;
import com.tencent.mm.plugin.forcenotify.a.e;
import com.tencent.mm.plugin.forcenotify.a.f;
import com.tencent.mm.plugin.forcenotify.a.h;
import com.tencent.mm.plugin.forcenotify.core.c;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.NetStatusUtil;
import com.tencent.mm.sdk.storage.MStorage.IOnStorageChange;
import com.tencent.mm.sdk.storage.MStorageEventData;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.u.i;
import com.tencent.threadpool.i;
import java.util.ArrayList;
import java.util.Collection;
import kotlin.Metadata;
import kotlin.g.b.s;
import kotlin.n.n;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/forcenotify/ui/ForceNotifyListUI;", "Lcom/tencent/mm/ui/MMActivity;", "Lcom/tencent/mm/sdk/storage/MStorage$IOnStorageChange;", "()V", "TAG", "", "adapter", "Lcom/tencent/mm/plugin/forcenotify/ui/ForceNotifyListUI$ForceNotifyListAdapter;", "data", "Ljava/util/ArrayList;", "Lcom/tencent/mm/plugin/forcenotify/model/ForceNotifyInfo;", "emptyTipView", "Landroid/view/View;", "loadingView", "recyclerView", "Landroidx/recyclerview/widget/RecyclerView;", "touchLoc", "", "getLayoutId", "", "onBackPressed", "", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "onDestroy", "onNotifyChange", "event", "eventData", "Lcom/tencent/mm/sdk/storage/MStorageEventData;", "ForceNotifyListAdapter", "ForceNotifyViewHolder", "plugin-force-notify_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class ForceNotifyListUI
  extends MMActivity
  implements MStorage.IOnStorageChange
{
  private final int[] Cxl;
  private a HoK;
  private View HoL;
  private final String TAG;
  private final ArrayList<com.tencent.mm.plugin.forcenotify.c.h> data;
  private RecyclerView mkw;
  private View njN;
  
  public ForceNotifyListUI()
  {
    AppMethodBeat.i(149229);
    this.TAG = "MicroMsg.ForceNotifyListUI";
    this.data = new ArrayList();
    this.Cxl = new int[2];
    AppMethodBeat.o(149229);
  }
  
  private static final void a(ForceNotifyListUI paramForceNotifyListUI)
  {
    AppMethodBeat.i(274955);
    s.u(paramForceNotifyListUI, "this$0");
    Log.i(paramForceNotifyListUI.TAG, s.X("[onCreate] load size=", Integer.valueOf(paramForceNotifyListUI.data.size())));
    Object localObject = paramForceNotifyListUI.HoK;
    s.checkNotNull(localObject);
    ((RecyclerView.a)localObject).bZE.notifyChanged();
    localObject = paramForceNotifyListUI.njN;
    s.checkNotNull(localObject);
    ((View)localObject).setVisibility(8);
    if (paramForceNotifyListUI.data.isEmpty())
    {
      localObject = paramForceNotifyListUI.mkw;
      s.checkNotNull(localObject);
      ((RecyclerView)localObject).setVisibility(8);
      paramForceNotifyListUI = paramForceNotifyListUI.HoL;
      s.checkNotNull(paramForceNotifyListUI);
      paramForceNotifyListUI.setVisibility(0);
      AppMethodBeat.o(274955);
      return;
    }
    paramForceNotifyListUI = paramForceNotifyListUI.mkw;
    s.checkNotNull(paramForceNotifyListUI);
    paramForceNotifyListUI.setVisibility(0);
    AppMethodBeat.o(274955);
  }
  
  private static final boolean a(ForceNotifyListUI paramForceNotifyListUI, MenuItem paramMenuItem)
  {
    AppMethodBeat.i(274947);
    s.u(paramForceNotifyListUI, "this$0");
    paramForceNotifyListUI.onBackPressed();
    AppMethodBeat.o(274947);
    return true;
  }
  
  private static final void b(ForceNotifyListUI paramForceNotifyListUI)
  {
    AppMethodBeat.i(274961);
    s.u(paramForceNotifyListUI, "this$0");
    paramForceNotifyListUI.data.clear();
    ArrayList localArrayList = paramForceNotifyListUI.data;
    c localc = c.Hoc;
    localArrayList.addAll((Collection)c.fwB());
    paramForceNotifyListUI.runOnUiThread(new ForceNotifyListUI..ExternalSyntheticLambda4(paramForceNotifyListUI));
    AppMethodBeat.o(274961);
  }
  
  private static final void c(ForceNotifyListUI paramForceNotifyListUI)
  {
    AppMethodBeat.i(274967);
    s.u(paramForceNotifyListUI, "this$0");
    if (paramForceNotifyListUI.data.isEmpty())
    {
      localRecyclerView = paramForceNotifyListUI.mkw;
      s.checkNotNull(localRecyclerView);
      localRecyclerView.setVisibility(8);
      paramForceNotifyListUI = paramForceNotifyListUI.HoL;
      s.checkNotNull(paramForceNotifyListUI);
      paramForceNotifyListUI.setVisibility(0);
      AppMethodBeat.o(274967);
      return;
    }
    RecyclerView localRecyclerView = paramForceNotifyListUI.mkw;
    s.checkNotNull(localRecyclerView);
    localRecyclerView.setVisibility(0);
    paramForceNotifyListUI = paramForceNotifyListUI.HoK;
    s.checkNotNull(paramForceNotifyListUI);
    paramForceNotifyListUI.bZE.notifyChanged();
    AppMethodBeat.o(274967);
  }
  
  private static final void d(ForceNotifyListUI paramForceNotifyListUI)
  {
    AppMethodBeat.i(274972);
    s.u(paramForceNotifyListUI, "this$0");
    paramForceNotifyListUI.data.clear();
    ArrayList localArrayList = paramForceNotifyListUI.data;
    c localc = c.Hoc;
    localArrayList.addAll((Collection)c.fwB());
    paramForceNotifyListUI.runOnUiThread(new ForceNotifyListUI..ExternalSyntheticLambda2(paramForceNotifyListUI));
    AppMethodBeat.o(274972);
  }
  
  public final int getLayoutId()
  {
    return a.f.force_notify_list_ui;
  }
  
  public final void onBackPressed()
  {
    AppMethodBeat.i(149225);
    super.onBackPressed();
    finish();
    AppMethodBeat.o(149225);
  }
  
  public final void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(149226);
    super.onCreate(paramBundle);
    com.tencent.mm.plugin.forcenotify.d.b.Hoz.add((MStorage.IOnStorageChange)this);
    setMMTitle(a.h.force_notify);
    setBackBtn(new ForceNotifyListUI..ExternalSyntheticLambda0(this));
    this.njN = findViewById(a.e.loading);
    this.HoL = findViewById(a.e.empty_tip);
    this.mkw = ((RecyclerView)findViewById(a.e.list));
    paramBundle = this.mkw;
    s.checkNotNull(paramBundle);
    getContext();
    paramBundle.setLayoutManager((RecyclerView.LayoutManager)new LinearLayoutManager());
    this.HoK = new a();
    paramBundle = this.mkw;
    s.checkNotNull(paramBundle);
    paramBundle.setAdapter((RecyclerView.a)this.HoK);
    com.tencent.threadpool.h.ahAA.bm(new ForceNotifyListUI..ExternalSyntheticLambda1(this));
    ((com.tencent.mm.plugin.forcenotify.a.a)com.tencent.mm.kernel.h.ax(com.tencent.mm.plugin.forcenotify.a.a.class)).D("", 1, cn.bDv() / 1000L);
    AppMethodBeat.o(149226);
  }
  
  public final void onDestroy()
  {
    AppMethodBeat.i(149227);
    super.onDestroy();
    com.tencent.mm.plugin.forcenotify.d.b.Hoz.remove((MStorage.IOnStorageChange)this);
    ((com.tencent.mm.plugin.forcenotify.a.a)com.tencent.mm.kernel.h.ax(com.tencent.mm.plugin.forcenotify.a.a.class)).D("", 2, cn.bDv() / 1000L);
    AppMethodBeat.o(149227);
  }
  
  public final void onNotifyChange(String paramString, MStorageEventData paramMStorageEventData)
  {
    AppMethodBeat.i(149228);
    Log.i(this.TAG, "[onNotifyChange] event:%s", new Object[] { paramString });
    com.tencent.threadpool.h.ahAA.bm(new ForceNotifyListUI..ExternalSyntheticLambda3(this));
    AppMethodBeat.o(149228);
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
  
  @Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/forcenotify/ui/ForceNotifyListUI$ForceNotifyListAdapter;", "Landroidx/recyclerview/widget/RecyclerView$Adapter;", "Lcom/tencent/mm/plugin/forcenotify/ui/ForceNotifyListUI$ForceNotifyViewHolder;", "Lcom/tencent/mm/plugin/forcenotify/ui/ForceNotifyListUI;", "(Lcom/tencent/mm/plugin/forcenotify/ui/ForceNotifyListUI;)V", "getItemCount", "", "getItemViewType", "position", "onBindViewHolder", "", "holder", "onCreateViewHolder", "parent", "Landroid/view/ViewGroup;", "viewType", "plugin-force-notify_release"}, k=1, mv={1, 5, 1}, xi=48)
  public final class a
    extends RecyclerView.a<ForceNotifyListUI.b>
  {
    public a()
    {
      AppMethodBeat.i(275027);
      AppMethodBeat.o(275027);
    }
    
    public final int getItemCount()
    {
      AppMethodBeat.i(149210);
      int i = ForceNotifyListUI.e(this.HoM).size();
      AppMethodBeat.o(149210);
      return i;
    }
    
    public final int getItemViewType(int paramInt)
    {
      AppMethodBeat.i(149211);
      Object localObject = ForceNotifyListUI.e(this.HoM).get(paramInt);
      s.s(localObject, "data[position]");
      localObject = ((com.tencent.mm.plugin.forcenotify.c.h)localObject).field_UserName;
      s.s(localObject, "info.field_UserName");
      if (n.rs((String)localObject, "@app"))
      {
        AppMethodBeat.o(149211);
        return 1;
      }
      AppMethodBeat.o(149211);
      return 0;
    }
  }
  
  @Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/forcenotify/ui/ForceNotifyListUI$ForceNotifyViewHolder;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "Landroid/view/View$OnCreateContextMenuListener;", "Lcom/tencent/mm/ui/base/MMMenuListener$OnMMMenuItemSelectedListener;", "itemView", "Landroid/view/View;", "(Lcom/tencent/mm/plugin/forcenotify/ui/ForceNotifyListUI;Landroid/view/View;)V", "avatar", "Landroid/widget/ImageView;", "getAvatar", "()Landroid/widget/ImageView;", "forcePushId", "", "getForcePushId", "()Ljava/lang/String;", "setForcePushId", "(Ljava/lang/String;)V", "refreshView", "getRefreshView", "()Landroid/view/View;", "resetView", "Landroid/widget/LinearLayout;", "getResetView", "()Landroid/widget/LinearLayout;", "timeView", "Landroid/widget/TextView;", "getTimeView", "()Landroid/widget/TextView;", "titleView", "getTitleView", "userView", "getUserView", "username", "getUsername", "setUsername", "onCreateContextMenu", "", "menu", "Landroid/view/ContextMenu;", "v", "menuInfo", "Landroid/view/ContextMenu$ContextMenuInfo;", "onMMMenuItemSelected", "menuItem", "Landroid/view/MenuItem;", "index", "", "plugin-force-notify_release"}, k=1, mv={1, 5, 1}, xi=48)
  public final class b
    extends RecyclerView.v
    implements View.OnCreateContextMenuListener, u.i
  {
    final TextView HoN;
    final LinearLayout HoO;
    final View HoP;
    String HoQ;
    private final ImageView avatar;
    private final TextView titleView;
    final TextView ule;
    String username;
    
    public b()
    {
      super();
      AppMethodBeat.i(149219);
      this$1 = localObject.findViewById(a.e.avatar_iv);
      s.checkNotNull(ForceNotifyListUI.this);
      this.avatar = ((ImageView)ForceNotifyListUI.this);
      this$1 = localObject.findViewById(a.e.title_tv);
      s.checkNotNull(ForceNotifyListUI.this);
      this.titleView = ((TextView)ForceNotifyListUI.this);
      this$1 = localObject.findViewById(a.e.time_tip);
      s.checkNotNull(ForceNotifyListUI.this);
      this.ule = ((TextView)ForceNotifyListUI.this);
      this.HoN = ((TextView)localObject.findViewById(a.e.user_tv));
      this$1 = localObject.findViewById(a.e.reset);
      s.checkNotNull(ForceNotifyListUI.this);
      this.HoO = ((LinearLayout)ForceNotifyListUI.this);
      this$1 = localObject.findViewById(a.e.refresh);
      s.checkNotNull(ForceNotifyListUI.this);
      this.HoP = ForceNotifyListUI.this;
      this$1 = localObject.findViewById(a.e.content);
      ForceNotifyListUI.this.setOnTouchListener(new ForceNotifyListUI.b..ExternalSyntheticLambda2(ForceNotifyListUI.this));
      ForceNotifyListUI.this.setOnLongClickListener(new ForceNotifyListUI.b..ExternalSyntheticLambda1(ForceNotifyListUI.this, this));
      this.HoO.setOnClickListener(new ForceNotifyListUI.b..ExternalSyntheticLambda0(ForceNotifyListUI.this, this));
      AppMethodBeat.o(149219);
    }
    
    private static final void a(b paramb)
    {
      AppMethodBeat.i(275051);
      s.u(paramb, "this$0");
      paramb.HoP.animate().start();
      AppMethodBeat.o(275051);
    }
    
    private static final boolean a(ForceNotifyListUI paramForceNotifyListUI, View paramView, MotionEvent paramMotionEvent)
    {
      AppMethodBeat.i(275043);
      s.u(paramForceNotifyListUI, "this$0");
      s.u(paramView, "view");
      s.u(paramMotionEvent, "event");
      if (paramMotionEvent.getAction() == 0)
      {
        ForceNotifyListUI.i(paramForceNotifyListUI)[0] = ((int)paramMotionEvent.getRawX());
        ForceNotifyListUI.i(paramForceNotifyListUI)[1] = ((int)paramMotionEvent.getRawY());
      }
      AppMethodBeat.o(275043);
      return false;
    }
    
    private static final boolean a(ForceNotifyListUI paramForceNotifyListUI, b paramb, View paramView)
    {
      AppMethodBeat.i(275047);
      Object localObject = new Object();
      com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
      localb.cH(paramForceNotifyListUI);
      localb.cH(paramb);
      localb.cH(paramView);
      com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/forcenotify/ui/ForceNotifyListUI$ForceNotifyViewHolder", "android/view/View$OnLongClickListener", "onLongClick", "(Landroid/view/View;)Z", localObject, localb.aYj());
      s.u(paramForceNotifyListUI, "this$0");
      s.u(paramb, "this$1");
      Log.i(ForceNotifyListUI.j(paramForceNotifyListUI), "OnLongClick!");
      new com.tencent.mm.ui.widget.b.a((Context)paramForceNotifyListUI.getContext()).a(paramView, 0, 0L, (View.OnCreateContextMenuListener)paramb, (u.i)paramb, ForceNotifyListUI.i(paramForceNotifyListUI)[0], ForceNotifyListUI.i(paramForceNotifyListUI)[1]);
      com.tencent.mm.hellhoundlib.a.a.a(true, new Object(), "com/tencent/mm/plugin/forcenotify/ui/ForceNotifyListUI$ForceNotifyViewHolder", "android/view/View$OnLongClickListener", "onLongClick", "(Landroid/view/View;)Z");
      AppMethodBeat.o(275047);
      return true;
    }
    
    private static final void b(ForceNotifyListUI paramForceNotifyListUI, b paramb, View paramView)
    {
      AppMethodBeat.i(275059);
      Object localObject = new Object();
      com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
      localb.cH(paramForceNotifyListUI);
      localb.cH(paramb);
      localb.cH(paramView);
      com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/forcenotify/ui/ForceNotifyListUI$ForceNotifyViewHolder", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", localObject, localb.aYj());
      s.u(paramForceNotifyListUI, "this$0");
      s.u(paramb, "this$1");
      Log.i(ForceNotifyListUI.j(paramForceNotifyListUI), "resetView onClick! username:%s", new Object[] { paramb.username });
      c.Hoc.aDK(paramb.username);
      paramb.HoP.animate().rotation(360.0F).setDuration(300L).withEndAction(new ForceNotifyListUI.b..ExternalSyntheticLambda3(paramb)).start();
      com.tencent.mm.hellhoundlib.a.a.a(new Object(), "com/tencent/mm/plugin/forcenotify/ui/ForceNotifyListUI$ForceNotifyViewHolder", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
      AppMethodBeat.o(275059);
    }
    
    public final void onCreateContextMenu(ContextMenu paramContextMenu, View paramView, ContextMenu.ContextMenuInfo paramContextMenuInfo)
    {
      AppMethodBeat.i(149218);
      s.u(paramContextMenu, "menu");
      paramContextMenu.add((CharSequence)ForceNotifyListUI.this.getContext().getResources().getString(a.h.force_notify_off));
      AppMethodBeat.o(149218);
    }
    
    public final void onMMMenuItemSelected(MenuItem paramMenuItem, int paramInt)
    {
      AppMethodBeat.i(149217);
      if (!NetStatusUtil.isNetworkConnected(MMApplicationContext.getContext()))
      {
        Toast.makeText((Context)ForceNotifyListUI.this.getContext(), ForceNotifyListUI.this.getResources().getText(a.h.fmt_iap_err), 1).show();
        AppMethodBeat.o(149217);
        return;
      }
      ForceNotifyListUI.e(ForceNotifyListUI.this).remove(KJ());
      paramMenuItem = ForceNotifyListUI.f(ForceNotifyListUI.this);
      s.checkNotNull(paramMenuItem);
      paramMenuItem.fX(KJ());
      c.Hoc.bB(this.HoQ, 4);
      if (ForceNotifyListUI.e(ForceNotifyListUI.this).isEmpty())
      {
        paramMenuItem = ForceNotifyListUI.g(ForceNotifyListUI.this);
        s.checkNotNull(paramMenuItem);
        paramMenuItem.setVisibility(8);
        paramMenuItem = ForceNotifyListUI.h(ForceNotifyListUI.this);
        s.checkNotNull(paramMenuItem);
        paramMenuItem.setVisibility(0);
      }
      AppMethodBeat.o(149217);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.forcenotify.ui.ForceNotifyListUI
 * JD-Core Version:    0.7.0.1
 */