package com.tencent.mm.plugin.forcenotify.ui;

import android.app.Activity;
import android.content.Context;
import android.content.res.Resources;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.RecyclerView.LayoutManager;
import android.support.v7.widget.RecyclerView.a;
import android.support.v7.widget.RecyclerView.v;
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
import com.tencent.f.h;
import com.tencent.f.i;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.av.q;
import com.tencent.mm.hellhoundlib.b.b;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.cl;
import com.tencent.mm.plugin.appbrand.config.WxaAttributes;
import com.tencent.mm.plugin.appbrand.service.q.a;
import com.tencent.mm.plugin.forcenotify.b.c;
import com.tencent.mm.plugin.forcenotify.c.d;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.MMHandlerThread;
import com.tencent.mm.sdk.platformtools.NetStatusUtil;
import com.tencent.mm.sdk.storage.MStorage.IOnStorageChange;
import com.tencent.mm.sdk.storage.MStorageEventData;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.o.g;
import java.util.ArrayList;
import java.util.Collection;
import kotlin.g.b.p;
import kotlin.l;
import kotlin.n.n;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/forcenotify/ui/ForceNotifyListUI;", "Lcom/tencent/mm/ui/MMActivity;", "Lcom/tencent/mm/sdk/storage/MStorage$IOnStorageChange;", "()V", "TAG", "", "adapter", "Lcom/tencent/mm/plugin/forcenotify/ui/ForceNotifyListUI$ForceNotifyListAdapter;", "data", "Ljava/util/ArrayList;", "Lcom/tencent/mm/plugin/forcenotify/model/ForceNotifyInfo;", "emptyTipView", "Landroid/view/View;", "loadingView", "recyclerView", "Landroid/support/v7/widget/RecyclerView;", "touchLoc", "", "getLayoutId", "", "onBackPressed", "", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "onDestroy", "onNotifyChange", "event", "eventData", "Lcom/tencent/mm/sdk/storage/MStorageEventData;", "ForceNotifyListAdapter", "ForceNotifyViewHolder", "plugin-force-notify_release"})
public final class ForceNotifyListUI
  extends MMActivity
  implements MStorage.IOnStorageChange
{
  private final String TAG;
  private final ArrayList<d> data;
  private View hSw;
  private RecyclerView hak;
  private final int[] utT;
  private a wMc;
  private View wMd;
  
  public ForceNotifyListUI()
  {
    AppMethodBeat.i(149229);
    this.TAG = "MicroMsg.ForceNotifyListUI";
    this.data = new ArrayList();
    this.utT = new int[2];
    AppMethodBeat.o(149229);
  }
  
  public final int getLayoutId()
  {
    return 2131494720;
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
    com.tencent.mm.plugin.forcenotify.d.a.wLU.add((MStorage.IOnStorageChange)this);
    setMMTitle(2131760909);
    setBackBtn((MenuItem.OnMenuItemClickListener)new c(this));
    this.hSw = findViewById(2131303690);
    this.wMd = findViewById(2131300101);
    this.hak = ((RecyclerView)findViewById(2131303226));
    paramBundle = this.hak;
    if (paramBundle == null) {
      p.hyc();
    }
    getContext();
    paramBundle.setLayoutManager((RecyclerView.LayoutManager)new LinearLayoutManager());
    this.wMc = new a();
    paramBundle = this.hak;
    if (paramBundle == null) {
      p.hyc();
    }
    paramBundle.setAdapter((RecyclerView.a)this.wMc);
    h.RTc.aX((Runnable)new d(this));
    ((com.tencent.mm.plugin.forcenotify.a.a)g.af(com.tencent.mm.plugin.forcenotify.a.a.class)).B("", 1, cl.aWz() / 1000L);
    AppMethodBeat.o(149226);
  }
  
  public final void onDestroy()
  {
    AppMethodBeat.i(149227);
    super.onDestroy();
    com.tencent.mm.plugin.forcenotify.d.a.wLU.remove((MStorage.IOnStorageChange)this);
    ((com.tencent.mm.plugin.forcenotify.a.a)g.af(com.tencent.mm.plugin.forcenotify.a.a.class)).B("", 2, cl.aWz() / 1000L);
    AppMethodBeat.o(149227);
  }
  
  public final void onNotifyChange(String paramString, MStorageEventData paramMStorageEventData)
  {
    AppMethodBeat.i(149228);
    Log.i(this.TAG, "[onNotifyChange] event:%s", new Object[] { paramString });
    h.RTc.aX((Runnable)new e(this));
    AppMethodBeat.o(149228);
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/forcenotify/ui/ForceNotifyListUI$ForceNotifyListAdapter;", "Landroid/support/v7/widget/RecyclerView$Adapter;", "Lcom/tencent/mm/plugin/forcenotify/ui/ForceNotifyListUI$ForceNotifyViewHolder;", "Lcom/tencent/mm/plugin/forcenotify/ui/ForceNotifyListUI;", "(Lcom/tencent/mm/plugin/forcenotify/ui/ForceNotifyListUI;)V", "getItemCount", "", "getItemViewType", "position", "onBindViewHolder", "", "holder", "onCreateViewHolder", "parent", "Landroid/view/ViewGroup;", "viewType", "plugin-force-notify_release"})
  public final class a
    extends RecyclerView.a<ForceNotifyListUI.b>
  {
    public final int getItemCount()
    {
      AppMethodBeat.i(149210);
      int i = ForceNotifyListUI.a(this.wMe).size();
      AppMethodBeat.o(149210);
      return i;
    }
    
    public final int getItemViewType(int paramInt)
    {
      AppMethodBeat.i(149211);
      Object localObject = ForceNotifyListUI.a(this.wMe).get(paramInt);
      p.g(localObject, "data[position]");
      localObject = ((d)localObject).field_UserName;
      p.g(localObject, "info.field_UserName");
      if (n.K((String)localObject, "@app", false))
      {
        AppMethodBeat.o(149211);
        return 1;
      }
      AppMethodBeat.o(149211);
      return 0;
    }
    
    @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "it", "Lcom/tencent/mm/plugin/appbrand/config/WxaAttributes;", "kotlin.jvm.PlatformType", "onGetWeAppInfo"})
    static final class a
      implements q.a
    {
      a(ForceNotifyListUI.a parama, ForceNotifyListUI.b paramb) {}
      
      public final void b(WxaAttributes paramWxaAttributes)
      {
        AppMethodBeat.i(149208);
        if (paramWxaAttributes == null)
        {
          AppMethodBeat.o(149208);
          return;
        }
        Log.i(ForceNotifyListUI.b(this.wMf.wMe), "getOrSync result=".concat(String.valueOf(paramWxaAttributes)));
        MMHandlerThread.postToMainThread((Runnable)new Runnable()
        {
          public final void run()
          {
            AppMethodBeat.i(149207);
            q.bcV().loadImage(this.wMi, this.wMh.wMg.keC);
            AppMethodBeat.o(149207);
          }
        });
        AppMethodBeat.o(149208);
      }
    }
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/forcenotify/ui/ForceNotifyListUI$ForceNotifyViewHolder;", "Landroid/support/v7/widget/RecyclerView$ViewHolder;", "Landroid/view/View$OnCreateContextMenuListener;", "Lcom/tencent/mm/ui/base/MMMenuListener$OnMMMenuItemSelectedListener;", "itemView", "Landroid/view/View;", "(Lcom/tencent/mm/plugin/forcenotify/ui/ForceNotifyListUI;Landroid/view/View;)V", "avatar", "Landroid/widget/ImageView;", "getAvatar", "()Landroid/widget/ImageView;", "forcePushId", "", "getForcePushId", "()Ljava/lang/String;", "setForcePushId", "(Ljava/lang/String;)V", "refreshView", "getRefreshView", "()Landroid/view/View;", "resetView", "Landroid/widget/LinearLayout;", "getResetView", "()Landroid/widget/LinearLayout;", "timeView", "Landroid/widget/TextView;", "getTimeView", "()Landroid/widget/TextView;", "titleView", "getTitleView", "userView", "getUserView", "username", "getUsername", "setUsername", "onCreateContextMenu", "", "menu", "Landroid/view/ContextMenu;", "v", "menuInfo", "Landroid/view/ContextMenu$ContextMenuInfo;", "onMMMenuItemSelected", "menuItem", "Landroid/view/MenuItem;", "index", "", "plugin-force-notify_release"})
  public final class b
    extends RecyclerView.v
    implements View.OnCreateContextMenuListener, o.g
  {
    final ImageView keC;
    final TextView titleView;
    String username;
    final TextView wMj;
    final TextView wMk;
    final LinearLayout wMl;
    final View wMm;
    String wMn;
    
    public b()
    {
      super();
      AppMethodBeat.i(149219);
      this$1 = localObject.findViewById(2131297134);
      if (ForceNotifyListUI.this == null) {
        p.hyc();
      }
      this.keC = ((ImageView)ForceNotifyListUI.this);
      this$1 = localObject.findViewById(2131309249);
      if (ForceNotifyListUI.this == null) {
        p.hyc();
      }
      this.titleView = ((TextView)ForceNotifyListUI.this);
      this$1 = localObject.findViewById(2131309096);
      if (ForceNotifyListUI.this == null) {
        p.hyc();
      }
      this.wMj = ((TextView)ForceNotifyListUI.this);
      this.wMk = ((TextView)localObject.findViewById(2131309650));
      this$1 = localObject.findViewById(2131306978);
      if (ForceNotifyListUI.this == null) {
        p.hyc();
      }
      this.wMl = ((LinearLayout)ForceNotifyListUI.this);
      this$1 = localObject.findViewById(2131306768);
      if (ForceNotifyListUI.this == null) {
        p.hyc();
      }
      this.wMm = ForceNotifyListUI.this;
      this$1 = localObject.findViewById(2131299180);
      ForceNotifyListUI.this.setOnTouchListener((View.OnTouchListener)new View.OnTouchListener()
      {
        public final boolean onTouch(View paramAnonymousView, MotionEvent paramAnonymousMotionEvent)
        {
          AppMethodBeat.i(149213);
          p.h(paramAnonymousView, "view");
          p.h(paramAnonymousMotionEvent, "event");
          switch (paramAnonymousMotionEvent.getAction())
          {
          }
          for (;;)
          {
            AppMethodBeat.o(149213);
            return false;
            ForceNotifyListUI.f(this.wMo.wMe)[0] = ((int)paramAnonymousMotionEvent.getRawX());
            ForceNotifyListUI.f(this.wMo.wMe)[1] = ((int)paramAnonymousMotionEvent.getRawY());
          }
        }
      });
      ForceNotifyListUI.this.setOnLongClickListener((View.OnLongClickListener)new View.OnLongClickListener()
      {
        public final boolean onLongClick(View paramAnonymousView)
        {
          AppMethodBeat.i(149214);
          b localb = new b();
          localb.bm(paramAnonymousView);
          com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/forcenotify/ui/ForceNotifyListUI$ForceNotifyViewHolder$2", "android/view/View$OnLongClickListener", "onLongClick", "(Landroid/view/View;)Z", this, localb.axR());
          Log.i(ForceNotifyListUI.b(this.wMo.wMe), "OnLongClick!");
          new com.tencent.mm.ui.widget.b.a((Context)this.wMo.wMe.getContext()).a(paramAnonymousView, 0, 0L, (View.OnCreateContextMenuListener)this.wMo, (o.g)this.wMo, ForceNotifyListUI.f(this.wMo.wMe)[0], ForceNotifyListUI.f(this.wMo.wMe)[1]);
          com.tencent.mm.hellhoundlib.a.a.a(true, this, "com/tencent/mm/plugin/forcenotify/ui/ForceNotifyListUI$ForceNotifyViewHolder$2", "android/view/View$OnLongClickListener", "onLongClick", "(Landroid/view/View;)Z");
          AppMethodBeat.o(149214);
          return true;
        }
      });
      this.wMl.setOnClickListener((View.OnClickListener)new View.OnClickListener()
      {
        public final void onClick(View paramAnonymousView)
        {
          AppMethodBeat.i(149216);
          b localb = new b();
          localb.bm(paramAnonymousView);
          com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/forcenotify/ui/ForceNotifyListUI$ForceNotifyViewHolder$3", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.axR());
          Log.i(ForceNotifyListUI.b(this.wMo.wMe), "resetView onClick! username:%s", new Object[] { this.wMo.username });
          c.wLS.axA(this.wMo.username);
          this.wMo.wMm.animate().rotation(360.0F).setDuration(300L).withEndAction((Runnable)new Runnable()
          {
            public final void run()
            {
              AppMethodBeat.i(149215);
              this.wMp.wMo.wMm.animate().start();
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
      p.h(paramContextMenu, "menu");
      paramView = ForceNotifyListUI.this.getContext();
      p.g(paramView, "context");
      paramContextMenu.add((CharSequence)paramView.getResources().getString(2131760917));
      AppMethodBeat.o(149218);
    }
    
    public final void onMMMenuItemSelected(MenuItem paramMenuItem, int paramInt)
    {
      AppMethodBeat.i(149217);
      if (!NetStatusUtil.isNetworkConnected(MMApplicationContext.getContext()))
      {
        Toast.makeText((Context)ForceNotifyListUI.this.getContext(), ForceNotifyListUI.this.getResources().getText(2131760826), 1).show();
        AppMethodBeat.o(149217);
        return;
      }
      ForceNotifyListUI.a(ForceNotifyListUI.this).remove(lR());
      paramMenuItem = ForceNotifyListUI.c(ForceNotifyListUI.this);
      if (paramMenuItem == null) {
        p.hyc();
      }
      paramMenuItem.ck(lR());
      c.wLS.aS(this.wMn, 4);
      if (ForceNotifyListUI.a(ForceNotifyListUI.this).isEmpty())
      {
        paramMenuItem = ForceNotifyListUI.d(ForceNotifyListUI.this);
        if (paramMenuItem == null) {
          p.hyc();
        }
        paramMenuItem.setVisibility(8);
        paramMenuItem = ForceNotifyListUI.e(ForceNotifyListUI.this);
        if (paramMenuItem == null) {
          p.hyc();
        }
        paramMenuItem.setVisibility(0);
      }
      AppMethodBeat.o(149217);
    }
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "it", "Landroid/view/MenuItem;", "kotlin.jvm.PlatformType", "onMenuItemClick"})
  static final class c
    implements MenuItem.OnMenuItemClickListener
  {
    c(ForceNotifyListUI paramForceNotifyListUI) {}
    
    public final boolean onMenuItemClick(MenuItem paramMenuItem)
    {
      AppMethodBeat.i(149220);
      this.wMe.onBackPressed();
      AppMethodBeat.o(149220);
      return true;
    }
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "run"})
  static final class d
    implements Runnable
  {
    d(ForceNotifyListUI paramForceNotifyListUI) {}
    
    public final void run()
    {
      AppMethodBeat.i(149222);
      ForceNotifyListUI.a(this.wMe).clear();
      ArrayList localArrayList = ForceNotifyListUI.a(this.wMe);
      c localc = c.wLS;
      localArrayList.addAll((Collection)c.dMo());
      this.wMe.runOnUiThread((Runnable)new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(149221);
          Log.i(ForceNotifyListUI.b(this.wMq.wMe), "[onCreate] load size=" + ForceNotifyListUI.a(this.wMq.wMe).size());
          Object localObject = ForceNotifyListUI.c(this.wMq.wMe);
          if (localObject == null) {
            p.hyc();
          }
          ((ForceNotifyListUI.a)localObject).notifyDataSetChanged();
          localObject = ForceNotifyListUI.g(this.wMq.wMe);
          if (localObject == null) {
            p.hyc();
          }
          ((View)localObject).setVisibility(8);
          if (ForceNotifyListUI.a(this.wMq.wMe).isEmpty())
          {
            localObject = ForceNotifyListUI.d(this.wMq.wMe);
            if (localObject == null) {
              p.hyc();
            }
            ((RecyclerView)localObject).setVisibility(8);
            localObject = ForceNotifyListUI.e(this.wMq.wMe);
            if (localObject == null) {
              p.hyc();
            }
            ((View)localObject).setVisibility(0);
            AppMethodBeat.o(149221);
            return;
          }
          localObject = ForceNotifyListUI.d(this.wMq.wMe);
          if (localObject == null) {
            p.hyc();
          }
          ((RecyclerView)localObject).setVisibility(0);
          AppMethodBeat.o(149221);
        }
      });
      AppMethodBeat.o(149222);
    }
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "run"})
  static final class e
    implements Runnable
  {
    e(ForceNotifyListUI paramForceNotifyListUI) {}
    
    public final void run()
    {
      AppMethodBeat.i(149224);
      ForceNotifyListUI.a(this.wMe).clear();
      ArrayList localArrayList = ForceNotifyListUI.a(this.wMe);
      c localc = c.wLS;
      localArrayList.addAll((Collection)c.dMo());
      this.wMe.runOnUiThread((Runnable)new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(149223);
          if (ForceNotifyListUI.a(this.wMr.wMe).isEmpty())
          {
            localObject = ForceNotifyListUI.d(this.wMr.wMe);
            if (localObject == null) {
              p.hyc();
            }
            ((RecyclerView)localObject).setVisibility(8);
            localObject = ForceNotifyListUI.e(this.wMr.wMe);
            if (localObject == null) {
              p.hyc();
            }
            ((View)localObject).setVisibility(0);
            AppMethodBeat.o(149223);
            return;
          }
          Object localObject = ForceNotifyListUI.d(this.wMr.wMe);
          if (localObject == null) {
            p.hyc();
          }
          ((RecyclerView)localObject).setVisibility(0);
          localObject = ForceNotifyListUI.c(this.wMr.wMe);
          if (localObject == null) {
            p.hyc();
          }
          ((ForceNotifyListUI.a)localObject).notifyDataSetChanged();
          AppMethodBeat.o(149223);
        }
      });
      AppMethodBeat.o(149224);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.forcenotify.ui.ForceNotifyListUI
 * JD-Core Version:    0.7.0.1
 */