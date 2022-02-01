package com.tencent.mm.plugin.forcenotify.ui;

import android.app.Activity;
import android.content.Context;
import android.content.res.Resources;
import android.os.Bundle;
import android.view.ContextMenu;
import android.view.ContextMenu.ContextMenuInfo;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnCreateContextMenuListener;
import android.view.View.OnLongClickListener;
import android.view.View.OnTouchListener;
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
import androidx.recyclerview.widget.RecyclerView.v;
import com.tencent.e.i;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.model.cm;
import com.tencent.mm.plugin.forcenotify.a.e;
import com.tencent.mm.plugin.forcenotify.a.f;
import com.tencent.mm.plugin.forcenotify.a.h;
import com.tencent.mm.plugin.forcenotify.c.c;
import com.tencent.mm.plugin.forcenotify.d.d;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.NetStatusUtil;
import com.tencent.mm.sdk.storage.MStorage.IOnStorageChange;
import com.tencent.mm.sdk.storage.MStorageEventData;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.q.g;
import java.util.ArrayList;
import java.util.Collection;
import kotlin.g.b.p;
import kotlin.l;
import kotlin.n.n;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/forcenotify/ui/ForceNotifyListUI;", "Lcom/tencent/mm/ui/MMActivity;", "Lcom/tencent/mm/sdk/storage/MStorage$IOnStorageChange;", "()V", "TAG", "", "adapter", "Lcom/tencent/mm/plugin/forcenotify/ui/ForceNotifyListUI$ForceNotifyListAdapter;", "data", "Ljava/util/ArrayList;", "Lcom/tencent/mm/plugin/forcenotify/model/ForceNotifyInfo;", "emptyTipView", "Landroid/view/View;", "loadingView", "recyclerView", "Landroidx/recyclerview/widget/RecyclerView;", "touchLoc", "", "getLayoutId", "", "onBackPressed", "", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "onDestroy", "onNotifyChange", "event", "eventData", "Lcom/tencent/mm/sdk/storage/MStorageEventData;", "ForceNotifyListAdapter", "ForceNotifyViewHolder", "plugin-force-notify_release"})
public final class ForceNotifyListUI
  extends MMActivity
  implements MStorage.IOnStorageChange
{
  private a BEo;
  private View BEp;
  private final String TAG;
  private final ArrayList<d> data;
  private RecyclerView jLl;
  private View kGT;
  private final int[] xYT;
  
  public ForceNotifyListUI()
  {
    AppMethodBeat.i(149229);
    this.TAG = "MicroMsg.ForceNotifyListUI";
    this.data = new ArrayList();
    this.xYT = new int[2];
    AppMethodBeat.o(149229);
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
    com.tencent.mm.plugin.forcenotify.e.b.BEa.add((MStorage.IOnStorageChange)this);
    setMMTitle(a.h.force_notify);
    setBackBtn((MenuItem.OnMenuItemClickListener)new c(this));
    this.kGT = findViewById(a.e.loading);
    this.BEp = findViewById(a.e.empty_tip);
    this.jLl = ((RecyclerView)findViewById(a.e.list));
    paramBundle = this.jLl;
    if (paramBundle == null) {
      p.iCn();
    }
    getContext();
    paramBundle.setLayoutManager((RecyclerView.LayoutManager)new LinearLayoutManager());
    this.BEo = new a();
    paramBundle = this.jLl;
    if (paramBundle == null) {
      p.iCn();
    }
    paramBundle.setAdapter((RecyclerView.a)this.BEo);
    com.tencent.e.h.ZvG.be((Runnable)new d(this));
    ((com.tencent.mm.plugin.forcenotify.a.a)com.tencent.mm.kernel.h.ae(com.tencent.mm.plugin.forcenotify.a.a.class)).C("", 1, cm.bfD() / 1000L);
    AppMethodBeat.o(149226);
  }
  
  public final void onDestroy()
  {
    AppMethodBeat.i(149227);
    super.onDestroy();
    com.tencent.mm.plugin.forcenotify.e.b.BEa.remove((MStorage.IOnStorageChange)this);
    ((com.tencent.mm.plugin.forcenotify.a.a)com.tencent.mm.kernel.h.ae(com.tencent.mm.plugin.forcenotify.a.a.class)).C("", 2, cm.bfD() / 1000L);
    AppMethodBeat.o(149227);
  }
  
  public final void onNotifyChange(String paramString, MStorageEventData paramMStorageEventData)
  {
    AppMethodBeat.i(149228);
    Log.i(this.TAG, "[onNotifyChange] event:%s", new Object[] { paramString });
    com.tencent.e.h.ZvG.be((Runnable)new e(this));
    AppMethodBeat.o(149228);
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/forcenotify/ui/ForceNotifyListUI$ForceNotifyListAdapter;", "Landroidx/recyclerview/widget/RecyclerView$Adapter;", "Lcom/tencent/mm/plugin/forcenotify/ui/ForceNotifyListUI$ForceNotifyViewHolder;", "Lcom/tencent/mm/plugin/forcenotify/ui/ForceNotifyListUI;", "(Lcom/tencent/mm/plugin/forcenotify/ui/ForceNotifyListUI;)V", "getItemCount", "", "getItemViewType", "position", "onBindViewHolder", "", "holder", "onCreateViewHolder", "parent", "Landroid/view/ViewGroup;", "viewType", "plugin-force-notify_release"})
  public final class a
    extends RecyclerView.a<ForceNotifyListUI.b>
  {
    public final int getItemCount()
    {
      AppMethodBeat.i(149210);
      int i = ForceNotifyListUI.a(this.BEq).size();
      AppMethodBeat.o(149210);
      return i;
    }
    
    public final int getItemViewType(int paramInt)
    {
      AppMethodBeat.i(149211);
      Object localObject = ForceNotifyListUI.a(this.BEq).get(paramInt);
      p.j(localObject, "data[position]");
      localObject = ((d)localObject).field_UserName;
      p.j(localObject, "info.field_UserName");
      if (n.pu((String)localObject, "@app"))
      {
        AppMethodBeat.o(149211);
        return 1;
      }
      AppMethodBeat.o(149211);
      return 0;
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/forcenotify/ui/ForceNotifyListUI$ForceNotifyViewHolder;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "Landroid/view/View$OnCreateContextMenuListener;", "Lcom/tencent/mm/ui/base/MMMenuListener$OnMMMenuItemSelectedListener;", "itemView", "Landroid/view/View;", "(Lcom/tencent/mm/plugin/forcenotify/ui/ForceNotifyListUI;Landroid/view/View;)V", "avatar", "Landroid/widget/ImageView;", "getAvatar", "()Landroid/widget/ImageView;", "forcePushId", "", "getForcePushId", "()Ljava/lang/String;", "setForcePushId", "(Ljava/lang/String;)V", "refreshView", "getRefreshView", "()Landroid/view/View;", "resetView", "Landroid/widget/LinearLayout;", "getResetView", "()Landroid/widget/LinearLayout;", "timeView", "Landroid/widget/TextView;", "getTimeView", "()Landroid/widget/TextView;", "titleView", "getTitleView", "userView", "getUserView", "username", "getUsername", "setUsername", "onCreateContextMenu", "", "menu", "Landroid/view/ContextMenu;", "v", "menuInfo", "Landroid/view/ContextMenu$ContextMenuInfo;", "onMMMenuItemSelected", "menuItem", "Landroid/view/MenuItem;", "index", "", "plugin-force-notify_release"})
  public final class b
    extends RecyclerView.v
    implements View.OnCreateContextMenuListener, q.g
  {
    String BDR;
    final TextView BEr;
    final TextView BEs;
    final LinearLayout BEt;
    final View BEu;
    private final ImageView mWb;
    private final TextView titleView;
    String username;
    
    public b()
    {
      super();
      AppMethodBeat.i(149219);
      this$1 = localObject.findViewById(a.e.avatar_iv);
      if (ForceNotifyListUI.this == null) {
        p.iCn();
      }
      this.mWb = ((ImageView)ForceNotifyListUI.this);
      this$1 = localObject.findViewById(a.e.title_tv);
      if (ForceNotifyListUI.this == null) {
        p.iCn();
      }
      this.titleView = ((TextView)ForceNotifyListUI.this);
      this$1 = localObject.findViewById(a.e.time_tip);
      if (ForceNotifyListUI.this == null) {
        p.iCn();
      }
      this.BEr = ((TextView)ForceNotifyListUI.this);
      this.BEs = ((TextView)localObject.findViewById(a.e.user_tv));
      this$1 = localObject.findViewById(a.e.reset);
      if (ForceNotifyListUI.this == null) {
        p.iCn();
      }
      this.BEt = ((LinearLayout)ForceNotifyListUI.this);
      this$1 = localObject.findViewById(a.e.refresh);
      if (ForceNotifyListUI.this == null) {
        p.iCn();
      }
      this.BEu = ForceNotifyListUI.this;
      this$1 = localObject.findViewById(a.e.content);
      ForceNotifyListUI.this.setOnTouchListener((View.OnTouchListener)new View.OnTouchListener()
      {
        public final boolean onTouch(View paramAnonymousView, MotionEvent paramAnonymousMotionEvent)
        {
          AppMethodBeat.i(149213);
          p.k(paramAnonymousView, "view");
          p.k(paramAnonymousMotionEvent, "event");
          switch (paramAnonymousMotionEvent.getAction())
          {
          }
          for (;;)
          {
            AppMethodBeat.o(149213);
            return false;
            ForceNotifyListUI.e(this.BEv.BEq)[0] = ((int)paramAnonymousMotionEvent.getRawX());
            ForceNotifyListUI.e(this.BEv.BEq)[1] = ((int)paramAnonymousMotionEvent.getRawY());
          }
        }
      });
      ForceNotifyListUI.this.setOnLongClickListener((View.OnLongClickListener)new View.OnLongClickListener()
      {
        public final boolean onLongClick(View paramAnonymousView)
        {
          AppMethodBeat.i(149214);
          com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
          localb.bn(paramAnonymousView);
          com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/forcenotify/ui/ForceNotifyListUI$ForceNotifyViewHolder$2", "android/view/View$OnLongClickListener", "onLongClick", "(Landroid/view/View;)Z", this, localb.aFi());
          Log.i(ForceNotifyListUI.f(this.BEv.BEq), "OnLongClick!");
          new com.tencent.mm.ui.widget.b.a((Context)this.BEv.BEq.getContext()).a(paramAnonymousView, 0, 0L, (View.OnCreateContextMenuListener)this.BEv, (q.g)this.BEv, ForceNotifyListUI.e(this.BEv.BEq)[0], ForceNotifyListUI.e(this.BEv.BEq)[1]);
          com.tencent.mm.hellhoundlib.a.a.a(true, this, "com/tencent/mm/plugin/forcenotify/ui/ForceNotifyListUI$ForceNotifyViewHolder$2", "android/view/View$OnLongClickListener", "onLongClick", "(Landroid/view/View;)Z");
          AppMethodBeat.o(149214);
          return true;
        }
      });
      this.BEt.setOnClickListener((View.OnClickListener)new View.OnClickListener()
      {
        public final void onClick(View paramAnonymousView)
        {
          AppMethodBeat.i(149216);
          com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
          localb.bn(paramAnonymousView);
          com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/forcenotify/ui/ForceNotifyListUI$ForceNotifyViewHolder$3", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.aFi());
          Log.i(ForceNotifyListUI.f(this.BEv.BEq), "resetView onClick! username:%s", new Object[] { this.BEv.username });
          c.BDQ.aHn(this.BEv.username);
          this.BEv.BEu.animate().rotation(360.0F).setDuration(300L).withEndAction((Runnable)new Runnable()
          {
            public final void run()
            {
              AppMethodBeat.i(149215);
              this.BEw.BEv.BEu.animate().start();
              AppMethodBeat.o(149215);
            }
          }).start();
          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/forcenotify/ui/ForceNotifyListUI$ForceNotifyViewHolder$3", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
          AppMethodBeat.o(149216);
        }
      });
      AppMethodBeat.o(149219);
    }
    
    public final void onCreateContextMenu(ContextMenu paramContextMenu, View paramView, ContextMenu.ContextMenuInfo paramContextMenuInfo)
    {
      AppMethodBeat.i(149218);
      p.k(paramContextMenu, "menu");
      paramView = ForceNotifyListUI.this.getContext();
      p.j(paramView, "context");
      paramContextMenu.add((CharSequence)paramView.getResources().getString(a.h.force_notify_off));
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
      ForceNotifyListUI.a(ForceNotifyListUI.this).remove(md());
      paramMenuItem = ForceNotifyListUI.b(ForceNotifyListUI.this);
      if (paramMenuItem == null) {
        p.iCn();
      }
      paramMenuItem.cN(md());
      c.BDQ.bk(this.BDR, 4);
      if (ForceNotifyListUI.a(ForceNotifyListUI.this).isEmpty())
      {
        paramMenuItem = ForceNotifyListUI.c(ForceNotifyListUI.this);
        if (paramMenuItem == null) {
          p.iCn();
        }
        paramMenuItem.setVisibility(8);
        paramMenuItem = ForceNotifyListUI.d(ForceNotifyListUI.this);
        if (paramMenuItem == null) {
          p.iCn();
        }
        paramMenuItem.setVisibility(0);
      }
      AppMethodBeat.o(149217);
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "it", "Landroid/view/MenuItem;", "kotlin.jvm.PlatformType", "onMenuItemClick"})
  static final class c
    implements MenuItem.OnMenuItemClickListener
  {
    c(ForceNotifyListUI paramForceNotifyListUI) {}
    
    public final boolean onMenuItemClick(MenuItem paramMenuItem)
    {
      AppMethodBeat.i(149220);
      this.BEq.onBackPressed();
      AppMethodBeat.o(149220);
      return true;
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "run"})
  static final class d
    implements Runnable
  {
    d(ForceNotifyListUI paramForceNotifyListUI) {}
    
    public final void run()
    {
      AppMethodBeat.i(149222);
      ForceNotifyListUI.a(this.BEq).clear();
      ArrayList localArrayList = ForceNotifyListUI.a(this.BEq);
      c localc = c.BDQ;
      localArrayList.addAll((Collection)c.eqg());
      this.BEq.runOnUiThread((Runnable)new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(149221);
          Log.i(ForceNotifyListUI.f(this.BEx.BEq), "[onCreate] load size=" + ForceNotifyListUI.a(this.BEx.BEq).size());
          Object localObject = ForceNotifyListUI.b(this.BEx.BEq);
          if (localObject == null) {
            p.iCn();
          }
          ((ForceNotifyListUI.a)localObject).notifyDataSetChanged();
          localObject = ForceNotifyListUI.g(this.BEx.BEq);
          if (localObject == null) {
            p.iCn();
          }
          ((View)localObject).setVisibility(8);
          if (ForceNotifyListUI.a(this.BEx.BEq).isEmpty())
          {
            localObject = ForceNotifyListUI.c(this.BEx.BEq);
            if (localObject == null) {
              p.iCn();
            }
            ((RecyclerView)localObject).setVisibility(8);
            localObject = ForceNotifyListUI.d(this.BEx.BEq);
            if (localObject == null) {
              p.iCn();
            }
            ((View)localObject).setVisibility(0);
            AppMethodBeat.o(149221);
            return;
          }
          localObject = ForceNotifyListUI.c(this.BEx.BEq);
          if (localObject == null) {
            p.iCn();
          }
          ((RecyclerView)localObject).setVisibility(0);
          AppMethodBeat.o(149221);
        }
      });
      AppMethodBeat.o(149222);
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "run"})
  static final class e
    implements Runnable
  {
    e(ForceNotifyListUI paramForceNotifyListUI) {}
    
    public final void run()
    {
      AppMethodBeat.i(149224);
      ForceNotifyListUI.a(this.BEq).clear();
      ArrayList localArrayList = ForceNotifyListUI.a(this.BEq);
      c localc = c.BDQ;
      localArrayList.addAll((Collection)c.eqg());
      this.BEq.runOnUiThread((Runnable)new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(149223);
          if (ForceNotifyListUI.a(this.BEy.BEq).isEmpty())
          {
            localObject = ForceNotifyListUI.c(this.BEy.BEq);
            if (localObject == null) {
              p.iCn();
            }
            ((RecyclerView)localObject).setVisibility(8);
            localObject = ForceNotifyListUI.d(this.BEy.BEq);
            if (localObject == null) {
              p.iCn();
            }
            ((View)localObject).setVisibility(0);
            AppMethodBeat.o(149223);
            return;
          }
          Object localObject = ForceNotifyListUI.c(this.BEy.BEq);
          if (localObject == null) {
            p.iCn();
          }
          ((RecyclerView)localObject).setVisibility(0);
          localObject = ForceNotifyListUI.b(this.BEy.BEq);
          if (localObject == null) {
            p.iCn();
          }
          ((ForceNotifyListUI.a)localObject).notifyDataSetChanged();
          AppMethodBeat.o(149223);
        }
      });
      AppMethodBeat.o(149224);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.forcenotify.ui.ForceNotifyListUI
 * JD-Core Version:    0.7.0.1
 */