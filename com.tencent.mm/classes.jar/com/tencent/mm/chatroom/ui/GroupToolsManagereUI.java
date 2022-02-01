package com.tencent.mm.chatroom.ui;

import android.app.Activity;
import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.RecyclerView.a;
import android.support.v7.widget.RecyclerView.b;
import android.support.v7.widget.RecyclerView.h;
import android.support.v7.widget.RecyclerView.t;
import android.support.v7.widget.RecyclerView.w;
import android.support.v7.widget.a.a.a;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnLongClickListener;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.n;
import com.tencent.mm.ak.q;
import com.tencent.mm.av.a.a.c.a;
import com.tencent.mm.av.o;
import com.tencent.mm.chatroom.d.ab;
import com.tencent.mm.chatroom.plugin.PluginChatroomUI;
import com.tencent.mm.chatroom.storage.GroupToolItem;
import com.tencent.mm.chatroom.storage.d;
import com.tencent.mm.model.ce;
import com.tencent.mm.plugin.appbrand.config.WxaAttributes;
import com.tencent.mm.plugin.appbrand.service.m;
import com.tencent.mm.plugin.appbrand.service.m.a;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.ai;
import com.tencent.mm.sdk.platformtools.ap;
import com.tencent.mm.sdk.platformtools.bs;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.ui.base.p;
import com.tencent.mm.ui.base.t;
import com.tencent.mm.ui.s.b;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public class GroupToolsManagereUI
  extends MMActivity
  implements com.tencent.mm.ak.g
{
  private LinkedList<GroupToolItem> ftq;
  private LinearLayout fvb;
  private RecyclerView fvc;
  private LinearLayout fvd;
  private RecyclerView fve;
  private LinearLayoutManager fvf;
  private e fvg;
  private android.support.v7.widget.a.a fvh;
  private f fvi;
  private LinearLayoutManager fvj;
  private e fvk;
  private com.tencent.mm.chatroom.storage.c fvl;
  private String fvm;
  private boolean fvn;
  private int fvo;
  private c fvp;
  private p tipDialog;
  
  public GroupToolsManagereUI()
  {
    AppMethodBeat.i(182194);
    this.tipDialog = null;
    this.fvl = null;
    this.ftq = new LinkedList();
    this.fvn = false;
    this.fvo = 0;
    this.fvp = new c()
    {
      public final void M(RecyclerView.w paramAnonymousw)
      {
        AppMethodBeat.i(182168);
        android.support.v7.widget.a.a locala = GroupToolsManagereUI.h(GroupToolsManagereUI.this);
        if ((locala.ayA.c(locala.alu, paramAnonymousw)) && (paramAnonymousw.asD.getParent() == locala.alu))
        {
          locala.mU();
          locala.ayx = 0.0F;
          locala.ayw = 0.0F;
          locala.e(paramAnonymousw, 2);
        }
        AppMethodBeat.o(182168);
      }
      
      public final void M(View paramAnonymousView, int paramAnonymousInt)
      {
        AppMethodBeat.i(184789);
        Object localObject = paramAnonymousView.getTag();
        if ((localObject instanceof GroupToolItem))
        {
          boolean bool = ((Boolean)((ViewGroup)paramAnonymousView.getParent()).getTag()).booleanValue();
          paramAnonymousView = (GroupToolItem)localObject;
          ac.i("MicroMsg.roomtools.GroupToolsManagereUI", "iRecentUseToolsCallback click stick:%s", new Object[] { Boolean.valueOf(bool) });
          if (bool)
          {
            paramAnonymousView.fto = ce.azI();
            GroupToolsManagereUI.a(GroupToolsManagereUI.this).ftp.remove(paramAnonymousView);
            GroupToolsManagereUI.b(GroupToolsManagereUI.this).addFirst(paramAnonymousView);
            GroupToolsManagereUI.c(GroupToolsManagereUI.this).cl(paramAnonymousInt);
            GroupToolsManagereUI.d(GroupToolsManagereUI.this).ck(0);
            if ((!bool) || (GroupToolsManagereUI.a(GroupToolsManagereUI.this).VY())) {
              break label302;
            }
            GroupToolsManagereUI.d(GroupToolsManagereUI.this).fvE = true;
            GroupToolsManagereUI.d(GroupToolsManagereUI.this).arg.notifyChanged();
          }
          for (;;)
          {
            GroupToolsManagereUI.e(GroupToolsManagereUI.this);
            GroupToolsManagereUI.f(GroupToolsManagereUI.this);
            GroupToolsManagereUI.g(GroupToolsManagereUI.this);
            AppMethodBeat.o(184789);
            return;
            if (GroupToolsManagereUI.a(GroupToolsManagereUI.this).VY())
            {
              h.a(GroupToolsManagereUI.this, GroupToolsManagereUI.this.getString(2131757071), "", GroupToolsManagereUI.this.getString(2131755792), false, null);
              AppMethodBeat.o(184789);
              return;
            }
            GroupToolsManagereUI.a(GroupToolsManagereUI.this).ftp.addLast(paramAnonymousView);
            GroupToolsManagereUI.b(GroupToolsManagereUI.this).remove(paramAnonymousView);
            GroupToolsManagereUI.c(GroupToolsManagereUI.this).ck(GroupToolsManagereUI.a(GroupToolsManagereUI.this).ftp.size() - 1);
            GroupToolsManagereUI.d(GroupToolsManagereUI.this).cl(paramAnonymousInt);
            break;
            label302:
            if ((!bool) && (GroupToolsManagereUI.a(GroupToolsManagereUI.this).VY()))
            {
              GroupToolsManagereUI.d(GroupToolsManagereUI.this).fvE = false;
              GroupToolsManagereUI.d(GroupToolsManagereUI.this).arg.notifyChanged();
            }
          }
        }
        ac.i("MicroMsg.roomtools.GroupToolsManagereUI", "iRecentUseToolsCallback click");
        AppMethodBeat.o(184789);
      }
    };
    AppMethodBeat.o(182194);
  }
  
  private boolean Wt()
  {
    AppMethodBeat.i(182200);
    if (this.fvn) {
      h.a(this, getString(2131757062), "", getString(2131757064), getString(2131757063), false, new DialogInterface.OnClickListener()new GroupToolsManagereUI.5
      {
        public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
        {
          AppMethodBeat.i(182171);
          ac.i("MicroMsg.roomtools.GroupToolsManagereUI", "back_dialot ok");
          ab.b(GroupToolsManagereUI.j(GroupToolsManagereUI.this), 2, GroupToolsManagereUI.k(GroupToolsManagereUI.this), GroupToolsManagereUI.a(GroupToolsManagereUI.this).ftp.size());
          GroupToolsManagereUI.this.finish();
          AppMethodBeat.o(182171);
        }
      }, new GroupToolsManagereUI.5(this));
    }
    for (;;)
    {
      AppMethodBeat.o(182200);
      return true;
      ab.b(this.fvm, 1, this.fvo, this.fvl.ftp.size());
      finish();
    }
  }
  
  private void Wu()
  {
    AppMethodBeat.i(182201);
    if (this.fvn)
    {
      enableOptionMenu(0, true);
      AppMethodBeat.o(182201);
      return;
    }
    enableOptionMenu(0, false);
    AppMethodBeat.o(182201);
  }
  
  private void Wv()
  {
    AppMethodBeat.i(182202);
    if (this.fvl.ftp.size() > 0) {
      this.fvb.setVisibility(0);
    }
    while (this.ftq.size() > 0)
    {
      this.fvd.setVisibility(0);
      AppMethodBeat.o(182202);
      return;
      this.fvb.setVisibility(8);
    }
    this.fvd.setVisibility(8);
    AppMethodBeat.o(182202);
  }
  
  public int getLayoutId()
  {
    return 2131493379;
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
    addTextOptionMenu(0, getString(2131757065), new MenuItem.OnMenuItemClickListener()
    {
      public final boolean onMenuItemClick(MenuItem paramAnonymousMenuItem)
      {
        AppMethodBeat.i(182173);
        ac.i("MicroMsg.roomtools.GroupToolsManagereUI", "menu click");
        paramAnonymousMenuItem = GroupToolsManagereUI.a(GroupToolsManagereUI.this);
        paramAnonymousMenuItem.field_stickToollist = com.tencent.mm.chatroom.storage.c.O(paramAnonymousMenuItem.ftp);
        GroupToolsManagereUI.l(GroupToolsManagereUI.this);
        AppMethodBeat.o(182173);
        return true;
      }
    }, null, s.b.Hom);
    Wu();
    this.fvb = ((LinearLayout)findViewById(2131302146));
    this.fvc = ((RecyclerView)findViewById(2131302147));
    this.fvd = ((LinearLayout)findViewById(2131302144));
    this.fve = ((RecyclerView)findViewById(2131302145));
    this.fvi = new f(getContext());
    this.fvf = new LinearLayoutManager();
    this.fvc.setLayoutManager(this.fvf);
    this.fvc.a(this.fvi);
    this.fvg = new e(getContext(), true, this.fvl.ftp, this.fvp);
    this.fvc.setAdapter(this.fvg);
    this.fvg.arg.notifyChanged();
    this.fvj = new LinearLayoutManager();
    this.fve.setLayoutManager(this.fvj);
    this.fve.a(this.fvi);
    this.fvk = new e(getContext(), false, this.ftq, this.fvp);
    this.fve.setAdapter(this.fvk);
    this.fvk.arg.notifyChanged();
    Wv();
    this.fvh = new android.support.v7.widget.a.a(new GroupToolsManagereUI.a(this.fvl.ftp, new b()
    {
      public final void Ww()
      {
        AppMethodBeat.i(182170);
        GroupToolsManagereUI.e(GroupToolsManagereUI.this);
        GroupToolsManagereUI.f(GroupToolsManagereUI.this);
        AppMethodBeat.o(182170);
      }
    }));
    this.fvh.j(this.fvc);
    AppMethodBeat.o(182197);
  }
  
  public void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(182195);
    super.onCreate(paramBundle);
    getWindow().setSoftInputMode(32);
    this.fvm = getIntent().getStringExtra("key_chatroomname");
    if (bs.isNullOrNil(this.fvm))
    {
      ac.e("MicroMsg.roomtools.GroupToolsManagereUI", "mChatRoomName is null");
      finish();
    }
    for (;;)
    {
      initView();
      com.tencent.mm.kernel.g.agi().a(3546, this);
      AppMethodBeat.o(182195);
      return;
      this.fvl = ((PluginChatroomUI)com.tencent.mm.kernel.g.ad(PluginChatroomUI.class)).getGroupToolsStorage().sb(this.fvm);
      if (this.fvl == null)
      {
        ac.e("MicroMsg.roomtools.GroupToolsManagereUI", "tools is null");
        finish();
      }
      else
      {
        paramBundle = getIntent().getParcelableArrayListExtra("key_recent_use_tools");
        if (paramBundle == null) {
          this.ftq = new LinkedList();
        }
        for (;;)
        {
          paramBundle = this.fvl.ftp.iterator();
          while (paramBundle.hasNext())
          {
            GroupToolItem localGroupToolItem = (GroupToolItem)paramBundle.next();
            if (this.ftq.contains(localGroupToolItem)) {
              this.ftq.remove(localGroupToolItem);
            }
          }
          this.ftq.addAll(paramBundle);
        }
        this.fvo = this.fvl.ftp.size();
        ac.i("MicroMsg.roomtools.GroupToolsManagereUI", "mChatRoomName is %s, recentUseToolItemList:%s", new Object[] { this.fvm, Integer.valueOf(this.ftq.size()) });
      }
    }
  }
  
  public void onDestroy()
  {
    AppMethodBeat.i(182199);
    com.tencent.mm.kernel.g.agi().b(3546, this);
    super.onDestroy();
    AppMethodBeat.o(182199);
  }
  
  public boolean onKeyUp(int paramInt, KeyEvent paramKeyEvent)
  {
    AppMethodBeat.i(182198);
    if (paramInt == 4)
    {
      Wt();
      AppMethodBeat.o(182198);
      return true;
    }
    boolean bool = super.onKeyUp(paramInt, paramKeyEvent);
    AppMethodBeat.o(182198);
    return bool;
  }
  
  public void onSceneEnd(int paramInt1, int paramInt2, String paramString, n paramn)
  {
    AppMethodBeat.i(182196);
    ac.i("MicroMsg.roomtools.GroupToolsManagereUI", "onSceneEnd errType = %d, errCode = %d, errMsg = %s, scenetype:%s", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), paramString, Integer.valueOf(paramn.getType()) });
    if ((this.tipDialog != null) && (this.tipDialog.isShowing())) {
      this.tipDialog.dismiss();
    }
    if ((paramInt1 == 0) && (paramInt2 == 0))
    {
      ac.i("MicroMsg.roomtools.GroupToolsManagereUI", "onSceneEnd result:%s", new Object[] { Boolean.valueOf(((PluginChatroomUI)com.tencent.mm.kernel.g.ad(PluginChatroomUI.class)).getGroupToolsStorage().a(this.fvl, new String[0])) });
      ab.b(this.fvm, 3, this.fvo, this.fvl.ftp.size());
      finish();
      AppMethodBeat.o(182196);
      return;
    }
    AppCompatActivity localAppCompatActivity = getContext();
    paramn = paramString;
    if (bs.isNullOrNil(paramString)) {
      paramn = getString(2131764612);
    }
    t.makeText(localAppCompatActivity, paramn, 0).show();
    AppMethodBeat.o(182196);
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
  
  public static abstract interface b
  {
    public abstract void Ww();
  }
  
  public static abstract interface c
  {
    public abstract void M(RecyclerView.w paramw);
    
    public abstract void M(View paramView, int paramInt);
  }
  
  public static final class d
    extends RecyclerView.w
  {
    static final com.tencent.mm.av.a.a.c fvC;
    RelativeLayout fvA;
    ImageView fvB;
    View fvu;
    RelativeLayout fvv;
    ImageView fvw;
    ImageView fvx;
    ImageView fvy;
    TextView fvz;
    
    static
    {
      AppMethodBeat.i(182181);
      c.a locala1 = new c.a();
      locala1.hKI = 2131689599;
      c.a locala2 = locala1.de(com.tencent.mm.cc.a.fromDPToPix(ai.getContext(), 20), com.tencent.mm.cc.a.fromDPToPix(ai.getContext(), 20));
      locala2.gLt = true;
      locala2.hKx = true;
      locala2.hKv = true;
      fvC = locala1.aFT();
      AppMethodBeat.o(182181);
    }
    
    public d(View paramView)
    {
      super();
      AppMethodBeat.i(182180);
      this.fvu = paramView;
      this.fvv = ((RelativeLayout)paramView.findViewById(2131305983));
      this.fvw = ((ImageView)paramView.findViewById(2131305977));
      this.fvx = ((ImageView)paramView.findViewById(2131305979));
      this.fvy = ((ImageView)paramView.findViewById(2131296846));
      this.fvz = ((TextView)paramView.findViewById(2131305985));
      this.fvA = ((RelativeLayout)paramView.findViewById(2131305981));
      this.fvB = ((ImageView)paramView.findViewById(2131305980));
      AppMethodBeat.o(182180);
    }
  }
  
  public static final class e
    extends RecyclerView.a
  {
    private Context context;
    private boolean fvD;
    boolean fvE = true;
    private List<GroupToolItem> fvF;
    private GroupToolsManagereUI.c fvG;
    
    public e(Context paramContext, boolean paramBoolean, List<GroupToolItem> paramList, GroupToolsManagereUI.c paramc)
    {
      this.context = paramContext;
      this.fvD = paramBoolean;
      this.fvF = paramList;
      this.fvG = paramc;
    }
    
    private static void a(GroupToolsManagereUI.d paramd, WxaAttributes paramWxaAttributes)
    {
      AppMethodBeat.i(182188);
      com.tencent.mm.av.a.a locala = o.aFB();
      Object localObject;
      if (paramWxaAttributes != null)
      {
        localObject = paramWxaAttributes.field_smallHeadURL;
        locala.a((String)localObject, paramd.fvy, GroupToolsManagereUI.d.fvC);
        localObject = paramd.fvz;
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
    
    public final RecyclerView.w a(ViewGroup paramViewGroup, int paramInt)
    {
      AppMethodBeat.i(182186);
      paramViewGroup = new GroupToolsManagereUI.d(LayoutInflater.from(paramViewGroup.getContext()).inflate(2131493380, paramViewGroup, false));
      AppMethodBeat.o(182186);
      return paramViewGroup;
    }
    
    public final void a(final RecyclerView.w paramw, int paramInt)
    {
      AppMethodBeat.i(182187);
      if ((this.fvF != null) && (paramInt >= 0) && (paramInt < this.fvF.size()))
      {
        paramw = (GroupToolsManagereUI.d)paramw;
        GroupToolItem localGroupToolItem = (GroupToolItem)this.fvF.get(paramInt);
        ac.d("MicroMsg.roomtools.GroupToolsManagereUI", "onBindViewHolder() i:%s", new Object[] { Integer.valueOf(paramInt) });
        paramw.fvu.setVisibility(0);
        if (this.fvD)
        {
          paramw.fvw.setVisibility(8);
          paramw.fvx.setVisibility(0);
          paramw.fvA.setVisibility(0);
          if (!localGroupToolItem.VW()) {
            break label247;
          }
          paramw.fvy.setImageResource(2131232617);
          paramw.fvz.setText(2131757070);
          label131:
          if (!this.fvE) {
            break label344;
          }
          paramw.fvu.setAlpha(1.0F);
        }
        for (;;)
        {
          ((ViewGroup)paramw.fvv.getParent()).setTag(Boolean.valueOf(this.fvD));
          paramw.fvv.setTag(localGroupToolItem);
          paramw.fvv.setOnClickListener(new View.OnClickListener()
          {
            public final void onClick(View paramAnonymousView)
            {
              AppMethodBeat.i(182184);
              if (GroupToolsManagereUI.e.a(GroupToolsManagereUI.e.this) != null) {
                GroupToolsManagereUI.e.a(GroupToolsManagereUI.e.this).M(paramAnonymousView, paramw.lv());
              }
              AppMethodBeat.o(182184);
            }
          });
          if (!this.fvD) {
            break label357;
          }
          paramw.fvA.setOnLongClickListener(new View.OnLongClickListener()
          {
            public final boolean onLongClick(View paramAnonymousView)
            {
              AppMethodBeat.i(182185);
              GroupToolsManagereUI.e.a(GroupToolsManagereUI.e.this).M(paramw);
              paramw.fvA.performHapticFeedback(0, 2);
              AppMethodBeat.o(182185);
              return true;
            }
          });
          AppMethodBeat.o(182187);
          return;
          paramw.fvw.setVisibility(0);
          paramw.fvx.setVisibility(8);
          paramw.fvA.setVisibility(4);
          break;
          label247:
          if (localGroupToolItem.VX())
          {
            paramw.fvy.setImageDrawable(com.tencent.mm.cc.a.l(this.context, 2131234903));
            paramw.fvz.setText(2131756264);
            break label131;
          }
          WxaAttributes localWxaAttributes = ((m)com.tencent.mm.kernel.g.ab(m.class)).Ka(localGroupToolItem.username);
          if (localWxaAttributes == null)
          {
            ((m)com.tencent.mm.kernel.g.ab(m.class)).a(localGroupToolItem.username, new m.a()
            {
              public final void b(final WxaAttributes paramAnonymousWxaAttributes)
              {
                AppMethodBeat.i(182183);
                ap.f(new Runnable()
                {
                  public final void run()
                  {
                    AppMethodBeat.i(182182);
                    GroupToolsManagereUI.e.b(GroupToolsManagereUI.e.1.this.fvH, paramAnonymousWxaAttributes);
                    AppMethodBeat.o(182182);
                  }
                });
                AppMethodBeat.o(182183);
              }
            });
            break label131;
          }
          a(paramw, localWxaAttributes);
          break label131;
          label344:
          paramw.fvu.setAlpha(0.3F);
        }
        label357:
        paramw.fvA.setOnLongClickListener(null);
      }
      AppMethodBeat.o(182187);
    }
    
    public final int getItemCount()
    {
      AppMethodBeat.i(182189);
      int i = this.fvF.size();
      AppMethodBeat.o(182189);
      return i;
    }
    
    public final int getItemViewType(int paramInt)
    {
      return 0;
    }
  }
  
  public static final class f
    extends RecyclerView.h
  {
    private int dividerHeight;
    private Paint fvL;
    
    public f(Context paramContext)
    {
      AppMethodBeat.i(182191);
      this.dividerHeight = com.tencent.mm.cc.a.fromDPToPix(paramContext, 8);
      this.fvL = new Paint();
      this.fvL.setColor(paramContext.getResources().getColor(2131099650));
      AppMethodBeat.o(182191);
    }
    
    public final void a(Canvas paramCanvas, RecyclerView paramRecyclerView, RecyclerView.t paramt)
    {
      AppMethodBeat.i(182192);
      super.a(paramCanvas, paramRecyclerView, paramt);
      int j = paramRecyclerView.getChildCount();
      int k = paramRecyclerView.getPaddingLeft();
      int m = paramRecyclerView.getWidth();
      int n = paramRecyclerView.getPaddingRight();
      int i = 0;
      while (i < j)
      {
        paramt = paramRecyclerView.getChildAt(i);
        float f1 = paramt.getBottom();
        float f2 = paramt.getBottom() + this.dividerHeight;
        paramCanvas.drawRect(k, f1, m - n, f2, this.fvL);
        i += 1;
      }
      AppMethodBeat.o(182192);
    }
    
    public final void a(Rect paramRect, View paramView, RecyclerView paramRecyclerView, RecyclerView.t paramt)
    {
      AppMethodBeat.i(182193);
      super.a(paramRect, paramView, paramRecyclerView, paramt);
      paramRect.bottom = this.dividerHeight;
      AppMethodBeat.o(182193);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.chatroom.ui.GroupToolsManagereUI
 * JD-Core Version:    0.7.0.1
 */