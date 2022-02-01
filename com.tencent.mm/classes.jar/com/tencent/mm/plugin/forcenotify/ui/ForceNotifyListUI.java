package com.tencent.mm.plugin.forcenotify.ui;

import android.app.Activity;
import android.content.Context;
import android.content.res.Resources;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.RecyclerView.a;
import android.support.v7.widget.RecyclerView.i;
import android.support.v7.widget.RecyclerView.w;
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
import com.tencent.e.h;
import com.tencent.e.i;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.av.o;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.ce;
import com.tencent.mm.plugin.appbrand.config.WxaAttributes;
import com.tencent.mm.plugin.appbrand.service.m.a;
import com.tencent.mm.plugin.forcenotify.b.c;
import com.tencent.mm.plugin.forcenotify.c.d;
import com.tencent.mm.sdk.e.k.a;
import com.tencent.mm.sdk.e.m;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.ai;
import com.tencent.mm.sdk.platformtools.ap;
import com.tencent.mm.sdk.platformtools.ax;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.n.d;
import d.g.b.k;
import d.l;
import d.n.n;
import java.util.ArrayList;
import java.util.Collection;

@l(fNY={1, 1, 16}, fNZ={""}, fOa={"Lcom/tencent/mm/plugin/forcenotify/ui/ForceNotifyListUI;", "Lcom/tencent/mm/ui/MMActivity;", "Lcom/tencent/mm/sdk/storage/MStorage$IOnStorageChange;", "()V", "TAG", "", "adapter", "Lcom/tencent/mm/plugin/forcenotify/ui/ForceNotifyListUI$ForceNotifyListAdapter;", "data", "Ljava/util/ArrayList;", "Lcom/tencent/mm/plugin/forcenotify/model/ForceNotifyInfo;", "emptyTipView", "Landroid/view/View;", "loadingView", "recyclerView", "Landroid/support/v7/widget/RecyclerView;", "touchLoc", "", "getLayoutId", "", "onBackPressed", "", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "onDestroy", "onNotifyChange", "event", "eventData", "Lcom/tencent/mm/sdk/storage/MStorageEventData;", "ForceNotifyListAdapter", "ForceNotifyViewHolder", "plugin-force-notify_release"})
public final class ForceNotifyListUI
  extends MMActivity
  implements k.a
{
  private final String TAG;
  private final ArrayList<d> data;
  private RecyclerView fTr;
  private View gDe;
  private a snA;
  private View snB;
  private final int[] snC;
  
  public ForceNotifyListUI()
  {
    AppMethodBeat.i(149229);
    this.TAG = "MicroMsg.ForceNotifyListUI";
    this.data = new ArrayList();
    this.snC = new int[2];
    AppMethodBeat.o(149229);
  }
  
  public final void a(String paramString, m paramm)
  {
    AppMethodBeat.i(149228);
    ac.i(this.TAG, "[onNotifyChange] event:%s", new Object[] { paramString });
    h.JZN.aS((Runnable)new e(this));
    AppMethodBeat.o(149228);
  }
  
  public final int getLayoutId()
  {
    return 2131494165;
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
    com.tencent.mm.plugin.forcenotify.d.a.snr.add((k.a)this);
    setMMTitle(2131759588);
    setBackBtn((MenuItem.OnMenuItemClickListener)new c(this));
    this.gDe = findViewById(2131301491);
    this.snB = findViewById(2131299472);
    this.fTr = ((RecyclerView)findViewById(2131301443));
    paramBundle = this.fTr;
    if (paramBundle == null) {
      k.fOy();
    }
    getContext();
    paramBundle.setLayoutManager((RecyclerView.i)new LinearLayoutManager());
    this.snA = new a();
    paramBundle = this.fTr;
    if (paramBundle == null) {
      k.fOy();
    }
    paramBundle.setAdapter((RecyclerView.a)this.snA);
    h.JZN.aS((Runnable)new d(this));
    ((com.tencent.mm.plugin.forcenotify.a.a)g.ab(com.tencent.mm.plugin.forcenotify.a.a.class)).h("", 1, ce.azI() / 1000L);
    AppMethodBeat.o(149226);
  }
  
  public final void onDestroy()
  {
    AppMethodBeat.i(149227);
    super.onDestroy();
    com.tencent.mm.plugin.forcenotify.d.a.snr.remove((k.a)this);
    ((com.tencent.mm.plugin.forcenotify.a.a)g.ab(com.tencent.mm.plugin.forcenotify.a.a.class)).h("", 2, ce.azI() / 1000L);
    AppMethodBeat.o(149227);
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
  
  @l(fNY={1, 1, 16}, fNZ={""}, fOa={"Lcom/tencent/mm/plugin/forcenotify/ui/ForceNotifyListUI$ForceNotifyListAdapter;", "Landroid/support/v7/widget/RecyclerView$Adapter;", "Lcom/tencent/mm/plugin/forcenotify/ui/ForceNotifyListUI$ForceNotifyViewHolder;", "Lcom/tencent/mm/plugin/forcenotify/ui/ForceNotifyListUI;", "(Lcom/tencent/mm/plugin/forcenotify/ui/ForceNotifyListUI;)V", "getItemCount", "", "getItemViewType", "position", "onBindViewHolder", "", "holder", "onCreateViewHolder", "parent", "Landroid/view/ViewGroup;", "viewType", "plugin-force-notify_release"})
  public final class a
    extends RecyclerView.a<ForceNotifyListUI.b>
  {
    public final int getItemCount()
    {
      AppMethodBeat.i(149210);
      int i = ForceNotifyListUI.a(this.snD).size();
      AppMethodBeat.o(149210);
      return i;
    }
    
    public final int getItemViewType(int paramInt)
    {
      AppMethodBeat.i(149211);
      Object localObject = ForceNotifyListUI.a(this.snD).get(paramInt);
      k.g(localObject, "data[position]");
      localObject = ((d)localObject).field_UserName;
      k.g(localObject, "info.field_UserName");
      if (n.nc((String)localObject, "@app"))
      {
        AppMethodBeat.o(149211);
        return 1;
      }
      AppMethodBeat.o(149211);
      return 0;
    }
    
    @l(fNY={1, 1, 16}, fNZ={""}, fOa={"<anonymous>", "", "it", "Lcom/tencent/mm/plugin/appbrand/config/WxaAttributes;", "kotlin.jvm.PlatformType", "onGetWeAppInfo"})
    static final class a
      implements m.a
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
        ac.i(ForceNotifyListUI.b(this.snE.snD), "getOrSync result=".concat(String.valueOf(paramWxaAttributes)));
        ap.f((Runnable)new Runnable()
        {
          public final void run()
          {
            AppMethodBeat.i(149207);
            o.aFB().loadImage(this.snH, this.snG.snF.iKw);
            AppMethodBeat.o(149207);
          }
        });
        AppMethodBeat.o(149208);
      }
    }
  }
  
  @l(fNY={1, 1, 16}, fNZ={""}, fOa={"Lcom/tencent/mm/plugin/forcenotify/ui/ForceNotifyListUI$ForceNotifyViewHolder;", "Landroid/support/v7/widget/RecyclerView$ViewHolder;", "Landroid/view/View$OnCreateContextMenuListener;", "Lcom/tencent/mm/ui/base/MMMenuListener$OnMMMenuItemSelectedListener;", "itemView", "Landroid/view/View;", "(Lcom/tencent/mm/plugin/forcenotify/ui/ForceNotifyListUI;Landroid/view/View;)V", "avatar", "Landroid/widget/ImageView;", "getAvatar", "()Landroid/widget/ImageView;", "forcePushId", "", "getForcePushId", "()Ljava/lang/String;", "setForcePushId", "(Ljava/lang/String;)V", "refreshView", "getRefreshView", "()Landroid/view/View;", "resetView", "Landroid/widget/LinearLayout;", "getResetView", "()Landroid/widget/LinearLayout;", "timeView", "Landroid/widget/TextView;", "getTimeView", "()Landroid/widget/TextView;", "titleView", "getTitleView", "userView", "getUserView", "username", "getUsername", "setUsername", "onCreateContextMenu", "", "menu", "Landroid/view/ContextMenu;", "v", "menuInfo", "Landroid/view/ContextMenu$ContextMenuInfo;", "onMMMenuItemSelected", "menuItem", "Landroid/view/MenuItem;", "index", "", "plugin-force-notify_release"})
  public final class b
    extends RecyclerView.w
    implements View.OnCreateContextMenuListener, n.d
  {
    final ImageView iKw;
    final TextView snI;
    final TextView snJ;
    final LinearLayout snK;
    final View snL;
    String snM;
    final TextView titleView;
    String username;
    
    public b()
    {
      super();
      AppMethodBeat.i(149219);
      this$1 = localObject.findViewById(2131297008);
      if (ForceNotifyListUI.this == null) {
        k.fOy();
      }
      this.iKw = ((ImageView)ForceNotifyListUI.this);
      this$1 = localObject.findViewById(2131305948);
      if (ForceNotifyListUI.this == null) {
        k.fOy();
      }
      this.titleView = ((TextView)ForceNotifyListUI.this);
      this$1 = localObject.findViewById(2131305817);
      if (ForceNotifyListUI.this == null) {
        k.fOy();
      }
      this.snI = ((TextView)ForceNotifyListUI.this);
      this.snJ = ((TextView)localObject.findViewById(2131306251));
      this$1 = localObject.findViewById(2131304110);
      if (ForceNotifyListUI.this == null) {
        k.fOy();
      }
      this.snK = ((LinearLayout)ForceNotifyListUI.this);
      this$1 = localObject.findViewById(2131303924);
      if (ForceNotifyListUI.this == null) {
        k.fOy();
      }
      this.snL = ForceNotifyListUI.this;
      this$1 = localObject.findViewById(2131298739);
      ForceNotifyListUI.this.setOnTouchListener((View.OnTouchListener)new View.OnTouchListener()
      {
        public final boolean onTouch(View paramAnonymousView, MotionEvent paramAnonymousMotionEvent)
        {
          AppMethodBeat.i(149213);
          k.h(paramAnonymousView, "view");
          k.h(paramAnonymousMotionEvent, "event");
          switch (paramAnonymousMotionEvent.getAction())
          {
          }
          for (;;)
          {
            AppMethodBeat.o(149213);
            return false;
            ForceNotifyListUI.f(this.snN.snD)[0] = ((int)paramAnonymousMotionEvent.getRawX());
            ForceNotifyListUI.f(this.snN.snD)[1] = ((int)paramAnonymousMotionEvent.getRawY());
          }
        }
      });
      ForceNotifyListUI.this.setOnLongClickListener((View.OnLongClickListener)new View.OnLongClickListener()
      {
        public final boolean onLongClick(View paramAnonymousView)
        {
          AppMethodBeat.i(149214);
          ac.i(ForceNotifyListUI.b(this.snN.snD), "OnLongClick!");
          new com.tencent.mm.ui.widget.b.a((Context)this.snN.snD.getContext()).a(paramAnonymousView, 0, 0L, (View.OnCreateContextMenuListener)this.snN, (n.d)this.snN, ForceNotifyListUI.f(this.snN.snD)[0], ForceNotifyListUI.f(this.snN.snD)[1]);
          AppMethodBeat.o(149214);
          return true;
        }
      });
      this.snK.setOnClickListener((View.OnClickListener)new View.OnClickListener()
      {
        public final void onClick(View paramAnonymousView)
        {
          AppMethodBeat.i(149216);
          ac.i(ForceNotifyListUI.b(this.snN.snD), "resetView onClick! username:%s", new Object[] { this.snN.username });
          c.snp.aeZ(this.snN.username);
          this.snN.snL.animate().rotation(360.0F).setDuration(300L).withEndAction((Runnable)new Runnable()
          {
            public final void run()
            {
              AppMethodBeat.i(149215);
              this.snO.snN.snL.animate().start();
              AppMethodBeat.o(149215);
            }
          }).start();
          AppMethodBeat.o(149216);
        }
      });
      AppMethodBeat.o(149219);
    }
    
    public final void onCreateContextMenu(ContextMenu paramContextMenu, View paramView, ContextMenu.ContextMenuInfo paramContextMenuInfo)
    {
      AppMethodBeat.i(149218);
      k.h(paramContextMenu, "menu");
      paramView = ForceNotifyListUI.this.getBaseContext();
      k.g(paramView, "baseContext");
      paramContextMenu.add((CharSequence)paramView.getResources().getString(2131759596));
      AppMethodBeat.o(149218);
    }
    
    public final void onMMMenuItemSelected(MenuItem paramMenuItem, int paramInt)
    {
      AppMethodBeat.i(149217);
      if (!ax.isNetworkConnected(ai.getContext()))
      {
        Toast.makeText((Context)ForceNotifyListUI.this.getContext(), ForceNotifyListUI.this.getResources().getText(2131759511), 1).show();
        AppMethodBeat.o(149217);
        return;
      }
      ForceNotifyListUI.a(ForceNotifyListUI.this).remove(lv());
      paramMenuItem = ForceNotifyListUI.c(ForceNotifyListUI.this);
      if (paramMenuItem == null) {
        k.fOy();
      }
      paramMenuItem.cl(lv());
      c.snp.aH(this.snM, 4);
      if (ForceNotifyListUI.a(ForceNotifyListUI.this).isEmpty())
      {
        paramMenuItem = ForceNotifyListUI.d(ForceNotifyListUI.this);
        if (paramMenuItem == null) {
          k.fOy();
        }
        paramMenuItem.setVisibility(8);
        paramMenuItem = ForceNotifyListUI.e(ForceNotifyListUI.this);
        if (paramMenuItem == null) {
          k.fOy();
        }
        paramMenuItem.setVisibility(0);
      }
      AppMethodBeat.o(149217);
    }
  }
  
  @l(fNY={1, 1, 16}, fNZ={""}, fOa={"<anonymous>", "", "it", "Landroid/view/MenuItem;", "kotlin.jvm.PlatformType", "onMenuItemClick"})
  static final class c
    implements MenuItem.OnMenuItemClickListener
  {
    c(ForceNotifyListUI paramForceNotifyListUI) {}
    
    public final boolean onMenuItemClick(MenuItem paramMenuItem)
    {
      AppMethodBeat.i(149220);
      this.snD.onBackPressed();
      AppMethodBeat.o(149220);
      return true;
    }
  }
  
  @l(fNY={1, 1, 16}, fNZ={""}, fOa={"<anonymous>", "", "run"})
  static final class d
    implements Runnable
  {
    d(ForceNotifyListUI paramForceNotifyListUI) {}
    
    public final void run()
    {
      AppMethodBeat.i(149222);
      ForceNotifyListUI.a(this.snD).clear();
      ArrayList localArrayList = ForceNotifyListUI.a(this.snD);
      c localc = c.snp;
      localArrayList.addAll((Collection)c.cIl());
      this.snD.runOnUiThread((Runnable)new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(149221);
          ac.i(ForceNotifyListUI.b(this.snP.snD), "[onCreate] load size=" + ForceNotifyListUI.a(this.snP.snD).size());
          Object localObject = ForceNotifyListUI.c(this.snP.snD);
          if (localObject == null) {
            k.fOy();
          }
          ((ForceNotifyListUI.a)localObject).notifyDataSetChanged();
          localObject = ForceNotifyListUI.g(this.snP.snD);
          if (localObject == null) {
            k.fOy();
          }
          ((View)localObject).setVisibility(8);
          if (ForceNotifyListUI.a(this.snP.snD).isEmpty())
          {
            localObject = ForceNotifyListUI.d(this.snP.snD);
            if (localObject == null) {
              k.fOy();
            }
            ((RecyclerView)localObject).setVisibility(8);
            localObject = ForceNotifyListUI.e(this.snP.snD);
            if (localObject == null) {
              k.fOy();
            }
            ((View)localObject).setVisibility(0);
            AppMethodBeat.o(149221);
            return;
          }
          localObject = ForceNotifyListUI.d(this.snP.snD);
          if (localObject == null) {
            k.fOy();
          }
          ((RecyclerView)localObject).setVisibility(0);
          AppMethodBeat.o(149221);
        }
      });
      AppMethodBeat.o(149222);
    }
  }
  
  @l(fNY={1, 1, 16}, fNZ={""}, fOa={"<anonymous>", "", "run"})
  static final class e
    implements Runnable
  {
    e(ForceNotifyListUI paramForceNotifyListUI) {}
    
    public final void run()
    {
      AppMethodBeat.i(149224);
      ForceNotifyListUI.a(this.snD).clear();
      ArrayList localArrayList = ForceNotifyListUI.a(this.snD);
      c localc = c.snp;
      localArrayList.addAll((Collection)c.cIl());
      this.snD.runOnUiThread((Runnable)new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(149223);
          if (ForceNotifyListUI.a(this.snQ.snD).isEmpty())
          {
            localObject = ForceNotifyListUI.d(this.snQ.snD);
            if (localObject == null) {
              k.fOy();
            }
            ((RecyclerView)localObject).setVisibility(8);
            localObject = ForceNotifyListUI.e(this.snQ.snD);
            if (localObject == null) {
              k.fOy();
            }
            ((View)localObject).setVisibility(0);
            AppMethodBeat.o(149223);
            return;
          }
          Object localObject = ForceNotifyListUI.d(this.snQ.snD);
          if (localObject == null) {
            k.fOy();
          }
          ((RecyclerView)localObject).setVisibility(0);
          localObject = ForceNotifyListUI.c(this.snQ.snD);
          if (localObject == null) {
            k.fOy();
          }
          ((ForceNotifyListUI.a)localObject).notifyDataSetChanged();
          AppMethodBeat.o(149223);
        }
      });
      AppMethodBeat.o(149224);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.forcenotify.ui.ForceNotifyListUI
 * JD-Core Version:    0.7.0.1
 */