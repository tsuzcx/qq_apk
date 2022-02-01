package com.tencent.mm.chatroom.ui;

import android.app.Activity;
import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.Canvas;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.RecyclerView.a;
import android.support.v7.widget.RecyclerView.b;
import android.support.v7.widget.RecyclerView.v;
import android.support.v7.widget.a.a.a;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnLongClickListener;
import android.view.ViewGroup;
import android.view.ViewPropertyAnimator;
import android.view.Window;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.i;
import com.tencent.mm.ak.t;
import com.tencent.mm.av.a.a.c;
import com.tencent.mm.av.a.a.c.a;
import com.tencent.mm.chatroom.d.ab;
import com.tencent.mm.chatroom.plugin.PluginChatroomUI;
import com.tencent.mm.chatroom.storage.GroupToolItem;
import com.tencent.mm.chatroom.storage.e;
import com.tencent.mm.chatroom.storage.f;
import com.tencent.mm.hellhoundlib.b.b;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.cl;
import com.tencent.mm.plugin.appbrand.config.WxaAttributes;
import com.tencent.mm.plugin.appbrand.service.q.a;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.MMHandlerThread;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.ui.base.u;
import com.tencent.mm.ui.t.b;
import java.util.Collections;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public class GroupToolsManagereUI
  extends MMActivity
  implements i
{
  private LinkedList<GroupToolItem> gtx;
  private LinearLayout gvA;
  private RecyclerView gvB;
  private LinearLayoutManager gvC;
  private e gvD;
  private android.support.v7.widget.a.a gvE;
  private GroupToolsManagereUI.f gvF;
  private LinearLayoutManager gvG;
  private e gvH;
  private e gvI;
  private String gvJ;
  private boolean gvK;
  private int gvL;
  private c gvM;
  private LinearLayout gvy;
  private RecyclerView gvz;
  private com.tencent.mm.ui.base.q tipDialog;
  
  public GroupToolsManagereUI()
  {
    AppMethodBeat.i(182194);
    this.tipDialog = null;
    this.gvI = null;
    this.gtx = new LinkedList();
    this.gvK = false;
    this.gvL = 0;
    this.gvM = new c()
    {
      public final void K(View paramAnonymousView, int paramAnonymousInt)
      {
        AppMethodBeat.i(184789);
        Object localObject = paramAnonymousView.getTag();
        if ((localObject instanceof GroupToolItem))
        {
          boolean bool = ((Boolean)((ViewGroup)paramAnonymousView.getParent()).getTag()).booleanValue();
          paramAnonymousView = (GroupToolItem)localObject;
          Log.i("MicroMsg.roomtools.GroupToolsManagereUI", "iRecentUseToolsCallback click stick:%s", new Object[] { Boolean.valueOf(bool) });
          if (bool)
          {
            paramAnonymousView.crj = cl.aWz();
            GroupToolsManagereUI.a(GroupToolsManagereUI.this).gtw.remove(paramAnonymousView);
            GroupToolsManagereUI.b(GroupToolsManagereUI.this).addFirst(paramAnonymousView);
            GroupToolsManagereUI.c(GroupToolsManagereUI.this).ck(paramAnonymousInt);
            GroupToolsManagereUI.d(GroupToolsManagereUI.this).cj(0);
            if ((!bool) || (GroupToolsManagereUI.a(GroupToolsManagereUI.this).amo())) {
              break label302;
            }
            GroupToolsManagereUI.d(GroupToolsManagereUI.this).gwa = true;
            GroupToolsManagereUI.d(GroupToolsManagereUI.this).atj.notifyChanged();
          }
          for (;;)
          {
            GroupToolsManagereUI.e(GroupToolsManagereUI.this);
            GroupToolsManagereUI.f(GroupToolsManagereUI.this);
            GroupToolsManagereUI.g(GroupToolsManagereUI.this);
            AppMethodBeat.o(184789);
            return;
            if (GroupToolsManagereUI.a(GroupToolsManagereUI.this).amo())
            {
              h.a(GroupToolsManagereUI.this, GroupToolsManagereUI.this.getString(2131757268), "", GroupToolsManagereUI.this.getString(2131755873), false, null);
              AppMethodBeat.o(184789);
              return;
            }
            GroupToolsManagereUI.a(GroupToolsManagereUI.this).gtw.addLast(paramAnonymousView);
            GroupToolsManagereUI.b(GroupToolsManagereUI.this).remove(paramAnonymousView);
            GroupToolsManagereUI.c(GroupToolsManagereUI.this).cj(GroupToolsManagereUI.a(GroupToolsManagereUI.this).gtw.size() - 1);
            GroupToolsManagereUI.d(GroupToolsManagereUI.this).ck(paramAnonymousInt);
            break;
            label302:
            if ((!bool) && (GroupToolsManagereUI.a(GroupToolsManagereUI.this).amo()))
            {
              GroupToolsManagereUI.d(GroupToolsManagereUI.this).gwa = false;
              GroupToolsManagereUI.d(GroupToolsManagereUI.this).atj.notifyChanged();
            }
          }
        }
        Log.i("MicroMsg.roomtools.GroupToolsManagereUI", "iRecentUseToolsCallback click");
        AppMethodBeat.o(184789);
      }
      
      public final void O(RecyclerView.v paramAnonymousv)
      {
        AppMethodBeat.i(182168);
        android.support.v7.widget.a.a locala = GroupToolsManagereUI.h(GroupToolsManagereUI.this);
        if ((locala.aAp.c(locala.mRecyclerView, paramAnonymousv)) && (paramAnonymousv.aus.getParent() == locala.mRecyclerView))
        {
          locala.no();
          locala.aAm = 0.0F;
          locala.aAl = 0.0F;
          locala.e(paramAnonymousv, 2);
        }
        AppMethodBeat.o(182168);
      }
    };
    AppMethodBeat.o(182194);
  }
  
  private boolean amI()
  {
    AppMethodBeat.i(182200);
    if (this.gvK) {
      h.a(this, getString(2131757259), "", getString(2131757261), getString(2131757260), false, new DialogInterface.OnClickListener()new DialogInterface.OnClickListener
      {
        public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
        {
          AppMethodBeat.i(182171);
          Log.i("MicroMsg.roomtools.GroupToolsManagereUI", "back_dialot ok");
          ab.b(GroupToolsManagereUI.j(GroupToolsManagereUI.this), 2, GroupToolsManagereUI.k(GroupToolsManagereUI.this), GroupToolsManagereUI.a(GroupToolsManagereUI.this).gtw.size());
          GroupToolsManagereUI.this.finish();
          AppMethodBeat.o(182171);
        }
      }, new DialogInterface.OnClickListener()
      {
        public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
        {
          AppMethodBeat.i(182172);
          Log.i("MicroMsg.roomtools.GroupToolsManagereUI", "back_dialot cancel");
          AppMethodBeat.o(182172);
        }
      });
    }
    for (;;)
    {
      AppMethodBeat.o(182200);
      return true;
      ab.b(this.gvJ, 1, this.gvL, this.gvI.gtw.size());
      finish();
    }
  }
  
  private void amJ()
  {
    AppMethodBeat.i(182201);
    if (this.gvK)
    {
      enableOptionMenu(0, true);
      AppMethodBeat.o(182201);
      return;
    }
    enableOptionMenu(0, false);
    AppMethodBeat.o(182201);
  }
  
  private void amK()
  {
    AppMethodBeat.i(182202);
    if (this.gvI.gtw.size() > 0) {
      this.gvy.setVisibility(0);
    }
    while (this.gtx.size() > 0)
    {
      this.gvA.setVisibility(0);
      AppMethodBeat.o(182202);
      return;
      this.gvy.setVisibility(8);
    }
    this.gvA.setVisibility(8);
    AppMethodBeat.o(182202);
  }
  
  public int getLayoutId()
  {
    return 2131493473;
  }
  
  public void initView()
  {
    AppMethodBeat.i(182197);
    super.initView();
    setMMTitle("");
    hideActionbarLine();
    setActionbarColor(getResources().getColor(2131099650));
    setBackGroundColorResource(2131099650);
    setBackBtn(new MenuItem.OnMenuItemClickListener()
    {
      public final boolean onMenuItemClick(MenuItem paramAnonymousMenuItem)
      {
        AppMethodBeat.i(182169);
        GroupToolsManagereUI.i(GroupToolsManagereUI.this);
        AppMethodBeat.o(182169);
        return true;
      }
    });
    addTextOptionMenu(0, getString(2131757262), new MenuItem.OnMenuItemClickListener()
    {
      public final boolean onMenuItemClick(MenuItem paramAnonymousMenuItem)
      {
        AppMethodBeat.i(182173);
        Log.i("MicroMsg.roomtools.GroupToolsManagereUI", "menu click");
        paramAnonymousMenuItem = GroupToolsManagereUI.a(GroupToolsManagereUI.this);
        paramAnonymousMenuItem.field_stickToollist = e.W(paramAnonymousMenuItem.gtw);
        GroupToolsManagereUI.l(GroupToolsManagereUI.this);
        AppMethodBeat.o(182173);
        return true;
      }
    }, null, t.b.OGU);
    amJ();
    this.gvy = ((LinearLayout)findViewById(2131304485));
    this.gvz = ((RecyclerView)findViewById(2131304486));
    this.gvA = ((LinearLayout)findViewById(2131304483));
    this.gvB = ((RecyclerView)findViewById(2131304484));
    this.gvF = new GroupToolsManagereUI.f(getContext());
    this.gvC = new LinearLayoutManager();
    this.gvz.setLayoutManager(this.gvC);
    this.gvz.a(this.gvF);
    this.gvD = new e(getContext(), true, this.gvI.gtw, this.gvM);
    this.gvz.setAdapter(this.gvD);
    this.gvD.atj.notifyChanged();
    this.gvG = new LinearLayoutManager();
    this.gvB.setLayoutManager(this.gvG);
    this.gvB.a(this.gvF);
    this.gvH = new e(getContext(), false, this.gtx, this.gvM);
    if (this.gvI.amo()) {
      this.gvH.gwa = false;
    }
    this.gvB.setAdapter(this.gvH);
    this.gvH.atj.notifyChanged();
    amK();
    this.gvE = new android.support.v7.widget.a.a(new a(this.gvI.gtw, new b()
    {
      public final void amL()
      {
        AppMethodBeat.i(182170);
        GroupToolsManagereUI.e(GroupToolsManagereUI.this);
        GroupToolsManagereUI.f(GroupToolsManagereUI.this);
        AppMethodBeat.o(182170);
      }
    }));
    this.gvE.f(this.gvz);
    AppMethodBeat.o(182197);
  }
  
  public void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(182195);
    super.onCreate(paramBundle);
    getWindow().setSoftInputMode(32);
    this.gvJ = getIntent().getStringExtra("key_chatroomname");
    if (Util.isNullOrNil(this.gvJ))
    {
      Log.e("MicroMsg.roomtools.GroupToolsManagereUI", "mChatRoomName is null");
      finish();
    }
    for (;;)
    {
      initView();
      g.azz().a(3546, this);
      AppMethodBeat.o(182195);
      return;
      this.gvI = ((PluginChatroomUI)g.ah(PluginChatroomUI.class)).getGroupToolsStorage().DE(this.gvJ);
      if (this.gvI == null)
      {
        Log.e("MicroMsg.roomtools.GroupToolsManagereUI", "tools is null");
        finish();
      }
      else
      {
        paramBundle = getIntent().getParcelableArrayListExtra("key_recent_use_tools");
        if (paramBundle == null) {
          this.gtx = new LinkedList();
        }
        for (;;)
        {
          paramBundle = this.gvI.gtw.iterator();
          while (paramBundle.hasNext())
          {
            GroupToolItem localGroupToolItem = (GroupToolItem)paramBundle.next();
            if (this.gtx.contains(localGroupToolItem)) {
              this.gtx.remove(localGroupToolItem);
            }
          }
          this.gtx.addAll(paramBundle);
        }
        this.gvL = this.gvI.gtw.size();
        Log.i("MicroMsg.roomtools.GroupToolsManagereUI", "mChatRoomName is %s, recentUseToolItemList:%s", new Object[] { this.gvJ, Integer.valueOf(this.gtx.size()) });
      }
    }
  }
  
  public void onDestroy()
  {
    AppMethodBeat.i(182199);
    g.azz().b(3546, this);
    super.onDestroy();
    AppMethodBeat.o(182199);
  }
  
  public boolean onKeyUp(int paramInt, KeyEvent paramKeyEvent)
  {
    AppMethodBeat.i(182198);
    if (paramInt == 4)
    {
      amI();
      AppMethodBeat.o(182198);
      return true;
    }
    boolean bool = super.onKeyUp(paramInt, paramKeyEvent);
    AppMethodBeat.o(182198);
    return bool;
  }
  
  public void onSceneEnd(int paramInt1, int paramInt2, String paramString, com.tencent.mm.ak.q paramq)
  {
    AppMethodBeat.i(182196);
    Log.i("MicroMsg.roomtools.GroupToolsManagereUI", "onSceneEnd errType = %d, errCode = %d, errMsg = %s, scenetype:%s", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), paramString, Integer.valueOf(paramq.getType()) });
    if ((this.tipDialog != null) && (this.tipDialog.isShowing())) {
      this.tipDialog.dismiss();
    }
    if ((paramInt1 == 0) && (paramInt2 == 0))
    {
      Log.i("MicroMsg.roomtools.GroupToolsManagereUI", "onSceneEnd result:%s", new Object[] { Boolean.valueOf(((PluginChatroomUI)g.ah(PluginChatroomUI.class)).getGroupToolsStorage().a(this.gvI, new String[0])) });
      ab.b(this.gvJ, 3, this.gvL, this.gvI.gtw.size());
      finish();
      AppMethodBeat.o(182196);
      return;
    }
    AppCompatActivity localAppCompatActivity = getContext();
    paramq = paramString;
    if (Util.isNullOrNil(paramString)) {
      paramq = getString(2131766974);
    }
    u.makeText(localAppCompatActivity, paramq, 0).show();
    AppMethodBeat.o(182196);
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
  
  public static final class a
    extends a.a
  {
    private List bXV;
    private boolean dAd = false;
    private GroupToolsManagereUI.b gvO;
    private boolean gvP = true;
    
    public a(List paramList, GroupToolsManagereUI.b paramb)
    {
      this.bXV = paramList;
      this.gvO = paramb;
    }
    
    public final void N(RecyclerView.v paramv) {}
    
    public final int a(RecyclerView paramRecyclerView, RecyclerView.v paramv)
    {
      AppMethodBeat.i(182175);
      int i = db(3);
      AppMethodBeat.o(182175);
      return i;
    }
    
    public final void a(Canvas paramCanvas, RecyclerView paramRecyclerView, RecyclerView.v paramv, float paramFloat1, float paramFloat2, int paramInt, boolean paramBoolean)
    {
      AppMethodBeat.i(182179);
      ViewPropertyAnimator localViewPropertyAnimator;
      if (this.gvP)
      {
        localViewPropertyAnimator = paramv.aus.animate();
        if (Build.VERSION.SDK_INT >= 21)
        {
          paramv.aus.setTranslationZ(20.0F);
          localViewPropertyAnimator.start();
        }
        this.gvP = false;
      }
      if (this.dAd)
      {
        localViewPropertyAnimator = paramv.aus.animate();
        if (Build.VERSION.SDK_INT >= 21)
        {
          paramv.aus.setTranslationZ(0.0F);
          localViewPropertyAnimator.start();
        }
        this.dAd = false;
        this.gvP = true;
      }
      super.a(paramCanvas, paramRecyclerView, paramv, paramFloat1, paramFloat2, paramInt, paramBoolean);
      AppMethodBeat.o(182179);
    }
    
    public final boolean a(RecyclerView paramRecyclerView, RecyclerView.v paramv1, RecyclerView.v paramv2)
    {
      AppMethodBeat.i(182176);
      int i = paramv1.lR();
      int k = paramv2.lR();
      Log.d("MicroMsg.roomtools.GroupToolsManagereUI", "onMove fromIndex:%s toIndex:%s", new Object[] { Integer.valueOf(i), Integer.valueOf(k) });
      if (i < k)
      {
        j = i;
        while (j < k)
        {
          Collections.swap(this.bXV, j, j + 1);
          j += 1;
        }
      }
      int j = i;
      while (j > k)
      {
        Collections.swap(this.bXV, j, j - 1);
        j -= 1;
      }
      paramRecyclerView.getAdapter().ar(i, k);
      if (this.gvO != null) {
        this.gvO.amL();
      }
      paramv1.aus.performHapticFeedback(0, 2);
      AppMethodBeat.o(182176);
      return true;
    }
    
    public final void d(RecyclerView paramRecyclerView, RecyclerView.v paramv)
    {
      AppMethodBeat.i(182178);
      super.d(paramRecyclerView, paramv);
      this.dAd = true;
      AppMethodBeat.o(182178);
    }
    
    public final void f(RecyclerView.v paramv, int paramInt)
    {
      AppMethodBeat.i(182177);
      super.f(paramv, paramInt);
      AppMethodBeat.o(182177);
    }
    
    public final boolean nq()
    {
      return false;
    }
  }
  
  public static abstract interface b
  {
    public abstract void amL();
  }
  
  public static abstract interface c
  {
    public abstract void K(View paramView, int paramInt);
    
    public abstract void O(RecyclerView.v paramv);
  }
  
  public static final class d
    extends RecyclerView.v
  {
    static final c gvY;
    View gvQ;
    RelativeLayout gvR;
    ImageView gvS;
    ImageView gvT;
    ImageView gvU;
    TextView gvV;
    RelativeLayout gvW;
    ImageView gvX;
    
    static
    {
      AppMethodBeat.i(182181);
      c.a locala1 = new c.a();
      locala1.jbq = 2131689602;
      c.a locala2 = locala1.dr(com.tencent.mm.cb.a.fromDPToPix(MMApplicationContext.getContext(), 20), com.tencent.mm.cb.a.fromDPToPix(MMApplicationContext.getContext(), 20));
      locala2.iaT = true;
      locala2.jbf = true;
      locala2.jbd = true;
      gvY = locala1.bdv();
      AppMethodBeat.o(182181);
    }
    
    public d(View paramView)
    {
      super();
      AppMethodBeat.i(182180);
      this.gvQ = paramView;
      this.gvR = ((RelativeLayout)paramView.findViewById(2131309288));
      this.gvS = ((ImageView)paramView.findViewById(2131309281));
      this.gvT = ((ImageView)paramView.findViewById(2131309284));
      this.gvU = ((ImageView)paramView.findViewById(2131296938));
      this.gvV = ((TextView)paramView.findViewById(2131309290));
      this.gvW = ((RelativeLayout)paramView.findViewById(2131309286));
      this.gvX = ((ImageView)paramView.findViewById(2131309285));
      AppMethodBeat.o(182180);
    }
  }
  
  public static final class e
    extends RecyclerView.a
  {
    private Context context;
    private boolean gvZ;
    boolean gwa = true;
    private List<GroupToolItem> gwb;
    private GroupToolsManagereUI.c gwc;
    
    public e(Context paramContext, boolean paramBoolean, List<GroupToolItem> paramList, GroupToolsManagereUI.c paramc)
    {
      this.context = paramContext;
      this.gvZ = paramBoolean;
      this.gwb = paramList;
      this.gwc = paramc;
    }
    
    private static void a(GroupToolsManagereUI.d paramd, WxaAttributes paramWxaAttributes)
    {
      AppMethodBeat.i(182188);
      com.tencent.mm.av.a.a locala = com.tencent.mm.av.q.bcV();
      Object localObject;
      if (paramWxaAttributes != null)
      {
        localObject = paramWxaAttributes.field_smallHeadURL;
        locala.a((String)localObject, paramd.gvU, GroupToolsManagereUI.d.gvY);
        localObject = paramd.gvV;
        if (paramWxaAttributes == null) {
          break label61;
        }
      }
      label61:
      for (paramd = paramWxaAttributes.field_nickname;; paramd = "")
      {
        ((TextView)localObject).setText(paramd);
        AppMethodBeat.o(182188);
        return;
        localObject = "";
        break;
      }
    }
    
    public final RecyclerView.v a(ViewGroup paramViewGroup, int paramInt)
    {
      AppMethodBeat.i(182186);
      paramViewGroup = new GroupToolsManagereUI.d(LayoutInflater.from(paramViewGroup.getContext()).inflate(2131493474, paramViewGroup, false));
      AppMethodBeat.o(182186);
      return paramViewGroup;
    }
    
    public final void a(final RecyclerView.v paramv, int paramInt)
    {
      AppMethodBeat.i(182187);
      if ((this.gwb != null) && (paramInt >= 0) && (paramInt < this.gwb.size()))
      {
        paramv = (GroupToolsManagereUI.d)paramv;
        GroupToolItem localGroupToolItem = (GroupToolItem)this.gwb.get(paramInt);
        Log.d("MicroMsg.roomtools.GroupToolsManagereUI", "onBindViewHolder() i:%s", new Object[] { Integer.valueOf(paramInt) });
        paramv.gvQ.setVisibility(0);
        if (this.gvZ)
        {
          paramv.gvS.setVisibility(8);
          paramv.gvT.setVisibility(0);
          paramv.gvW.setVisibility(0);
          if (!localGroupToolItem.amm()) {
            break label247;
          }
          paramv.gvU.setImageResource(2131233016);
          paramv.gvV.setText(2131757267);
          label131:
          if (!this.gwa) {
            break label344;
          }
          paramv.gvQ.setAlpha(1.0F);
        }
        for (;;)
        {
          ((ViewGroup)paramv.gvR.getParent()).setTag(Boolean.valueOf(this.gvZ));
          paramv.gvR.setTag(localGroupToolItem);
          paramv.gvR.setOnClickListener(new View.OnClickListener()
          {
            public final void onClick(View paramAnonymousView)
            {
              AppMethodBeat.i(182184);
              b localb = new b();
              localb.bm(paramAnonymousView);
              com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/chatroom/ui/GroupToolsManagereUI$ToolAdapter$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.axR());
              if (GroupToolsManagereUI.e.a(GroupToolsManagereUI.e.this) != null) {
                GroupToolsManagereUI.e.a(GroupToolsManagereUI.e.this).K(paramAnonymousView, paramv.lR());
              }
              com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/chatroom/ui/GroupToolsManagereUI$ToolAdapter$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
              AppMethodBeat.o(182184);
            }
          });
          if (!this.gvZ) {
            break label357;
          }
          paramv.gvW.setOnLongClickListener(new View.OnLongClickListener()
          {
            public final boolean onLongClick(View paramAnonymousView)
            {
              AppMethodBeat.i(182185);
              b localb = new b();
              localb.bm(paramAnonymousView);
              com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/chatroom/ui/GroupToolsManagereUI$ToolAdapter$3", "android/view/View$OnLongClickListener", "onLongClick", "(Landroid/view/View;)Z", this, localb.axR());
              GroupToolsManagereUI.e.a(GroupToolsManagereUI.e.this).O(paramv);
              paramv.gvW.performHapticFeedback(0, 2);
              com.tencent.mm.hellhoundlib.a.a.a(true, this, "com/tencent/mm/chatroom/ui/GroupToolsManagereUI$ToolAdapter$3", "android/view/View$OnLongClickListener", "onLongClick", "(Landroid/view/View;)Z");
              AppMethodBeat.o(182185);
              return true;
            }
          });
          AppMethodBeat.o(182187);
          return;
          paramv.gvS.setVisibility(0);
          paramv.gvT.setVisibility(8);
          paramv.gvW.setVisibility(4);
          break;
          label247:
          if (localGroupToolItem.amn())
          {
            paramv.gvU.setImageDrawable(com.tencent.mm.cb.a.l(this.context, 2131233017));
            paramv.gvV.setText(2131755819);
            break label131;
          }
          WxaAttributes localWxaAttributes = ((com.tencent.mm.plugin.appbrand.service.q)g.af(com.tencent.mm.plugin.appbrand.service.q.class)).Xk(localGroupToolItem.username);
          if (localWxaAttributes == null)
          {
            ((com.tencent.mm.plugin.appbrand.service.q)g.af(com.tencent.mm.plugin.appbrand.service.q.class)).a(localGroupToolItem.username, new q.a()
            {
              public final void b(final WxaAttributes paramAnonymousWxaAttributes)
              {
                AppMethodBeat.i(182183);
                MMHandlerThread.postToMainThread(new Runnable()
                {
                  public final void run()
                  {
                    AppMethodBeat.i(182182);
                    GroupToolsManagereUI.e.b(GroupToolsManagereUI.e.1.this.gwd, paramAnonymousWxaAttributes);
                    AppMethodBeat.o(182182);
                  }
                });
                AppMethodBeat.o(182183);
              }
            });
            break label131;
          }
          a(paramv, localWxaAttributes);
          break label131;
          label344:
          paramv.gvQ.setAlpha(0.3F);
        }
        label357:
        paramv.gvW.setOnLongClickListener(null);
      }
      AppMethodBeat.o(182187);
    }
    
    public final int getItemCount()
    {
      AppMethodBeat.i(182189);
      int i = this.gwb.size();
      AppMethodBeat.o(182189);
      return i;
    }
    
    public final int getItemViewType(int paramInt)
    {
      return 0;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.chatroom.ui.GroupToolsManagereUI
 * JD-Core Version:    0.7.0.1
 */