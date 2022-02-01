package com.tencent.mm.chatroom.ui;

import android.app.Activity;
import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
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
import com.tencent.mm.aw.a.a.c;
import com.tencent.mm.aw.a.a.c.a;
import com.tencent.mm.chatroom.d.ab;
import com.tencent.mm.chatroom.plugin.PluginChatroomUI;
import com.tencent.mm.chatroom.storage.GroupToolItem;
import com.tencent.mm.chatroom.storage.e;
import com.tencent.mm.hellhoundlib.b.b;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.cf;
import com.tencent.mm.plugin.appbrand.config.WxaAttributes;
import com.tencent.mm.plugin.appbrand.service.n.a;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.aj;
import com.tencent.mm.sdk.platformtools.aq;
import com.tencent.mm.sdk.platformtools.bt;
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
  implements com.tencent.mm.al.f
{
  private LinkedList<GroupToolItem> fMh;
  private LinearLayout fOi;
  private RecyclerView fOj;
  private LinearLayout fOk;
  private RecyclerView fOl;
  private LinearLayoutManager fOm;
  private e fOn;
  private android.support.v7.widget.a.a fOo;
  private f fOp;
  private LinearLayoutManager fOq;
  private e fOr;
  private e fOs;
  private String fOt;
  private boolean fOu;
  private int fOv;
  private c fOw;
  private p tipDialog;
  
  public GroupToolsManagereUI()
  {
    AppMethodBeat.i(182194);
    this.tipDialog = null;
    this.fOs = null;
    this.fMh = new LinkedList();
    this.fOu = false;
    this.fOv = 0;
    this.fOw = new c()
    {
      public final void M(RecyclerView.w paramAnonymousw)
      {
        AppMethodBeat.i(182168);
        android.support.v7.widget.a.a locala = GroupToolsManagereUI.h(GroupToolsManagereUI.this);
        if ((locala.aAr.c(locala.anl, paramAnonymousw)) && (paramAnonymousw.auu.getParent() == locala.anl))
        {
          locala.nm();
          locala.aAo = 0.0F;
          locala.aAn = 0.0F;
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
          ad.i("MicroMsg.roomtools.GroupToolsManagereUI", "iRecentUseToolsCallback click stick:%s", new Object[] { Boolean.valueOf(bool) });
          if (bool)
          {
            paramAnonymousView.fMf = cf.aCL();
            GroupToolsManagereUI.a(GroupToolsManagereUI.this).fMg.remove(paramAnonymousView);
            GroupToolsManagereUI.b(GroupToolsManagereUI.this).addFirst(paramAnonymousView);
            GroupToolsManagereUI.c(GroupToolsManagereUI.this).cl(paramAnonymousInt);
            GroupToolsManagereUI.d(GroupToolsManagereUI.this).ck(0);
            if ((!bool) || (GroupToolsManagereUI.a(GroupToolsManagereUI.this).Ys())) {
              break label302;
            }
            GroupToolsManagereUI.d(GroupToolsManagereUI.this).fOL = true;
            GroupToolsManagereUI.d(GroupToolsManagereUI.this).asY.notifyChanged();
          }
          for (;;)
          {
            GroupToolsManagereUI.e(GroupToolsManagereUI.this);
            GroupToolsManagereUI.f(GroupToolsManagereUI.this);
            GroupToolsManagereUI.g(GroupToolsManagereUI.this);
            AppMethodBeat.o(184789);
            return;
            if (GroupToolsManagereUI.a(GroupToolsManagereUI.this).Ys())
            {
              h.a(GroupToolsManagereUI.this, GroupToolsManagereUI.this.getString(2131757071), "", GroupToolsManagereUI.this.getString(2131755792), false, null);
              AppMethodBeat.o(184789);
              return;
            }
            GroupToolsManagereUI.a(GroupToolsManagereUI.this).fMg.addLast(paramAnonymousView);
            GroupToolsManagereUI.b(GroupToolsManagereUI.this).remove(paramAnonymousView);
            GroupToolsManagereUI.c(GroupToolsManagereUI.this).ck(GroupToolsManagereUI.a(GroupToolsManagereUI.this).fMg.size() - 1);
            GroupToolsManagereUI.d(GroupToolsManagereUI.this).cl(paramAnonymousInt);
            break;
            label302:
            if ((!bool) && (GroupToolsManagereUI.a(GroupToolsManagereUI.this).Ys()))
            {
              GroupToolsManagereUI.d(GroupToolsManagereUI.this).fOL = false;
              GroupToolsManagereUI.d(GroupToolsManagereUI.this).asY.notifyChanged();
            }
          }
        }
        ad.i("MicroMsg.roomtools.GroupToolsManagereUI", "iRecentUseToolsCallback click");
        AppMethodBeat.o(184789);
      }
    };
    AppMethodBeat.o(182194);
  }
  
  private boolean YM()
  {
    AppMethodBeat.i(182200);
    if (this.fOu) {
      h.a(this, getString(2131757062), "", getString(2131757064), getString(2131757063), false, new DialogInterface.OnClickListener()new DialogInterface.OnClickListener
      {
        public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
        {
          AppMethodBeat.i(182171);
          ad.i("MicroMsg.roomtools.GroupToolsManagereUI", "back_dialot ok");
          ab.b(GroupToolsManagereUI.j(GroupToolsManagereUI.this), 2, GroupToolsManagereUI.k(GroupToolsManagereUI.this), GroupToolsManagereUI.a(GroupToolsManagereUI.this).fMg.size());
          GroupToolsManagereUI.this.finish();
          AppMethodBeat.o(182171);
        }
      }, new DialogInterface.OnClickListener()
      {
        public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
        {
          AppMethodBeat.i(182172);
          ad.i("MicroMsg.roomtools.GroupToolsManagereUI", "back_dialot cancel");
          AppMethodBeat.o(182172);
        }
      });
    }
    for (;;)
    {
      AppMethodBeat.o(182200);
      return true;
      ab.b(this.fOt, 1, this.fOv, this.fOs.fMg.size());
      finish();
    }
  }
  
  private void YN()
  {
    AppMethodBeat.i(182201);
    if (this.fOu)
    {
      enableOptionMenu(0, true);
      AppMethodBeat.o(182201);
      return;
    }
    enableOptionMenu(0, false);
    AppMethodBeat.o(182201);
  }
  
  private void YO()
  {
    AppMethodBeat.i(182202);
    if (this.fOs.fMg.size() > 0) {
      this.fOi.setVisibility(0);
    }
    while (this.fMh.size() > 0)
    {
      this.fOk.setVisibility(0);
      AppMethodBeat.o(182202);
      return;
      this.fOi.setVisibility(8);
    }
    this.fOk.setVisibility(8);
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
        ad.i("MicroMsg.roomtools.GroupToolsManagereUI", "menu click");
        paramAnonymousMenuItem = GroupToolsManagereUI.a(GroupToolsManagereUI.this);
        paramAnonymousMenuItem.field_stickToollist = e.Q(paramAnonymousMenuItem.fMg);
        GroupToolsManagereUI.l(GroupToolsManagereUI.this);
        AppMethodBeat.o(182173);
        return true;
      }
    }, null, s.b.JbS);
    YN();
    this.fOi = ((LinearLayout)findViewById(2131302146));
    this.fOj = ((RecyclerView)findViewById(2131302147));
    this.fOk = ((LinearLayout)findViewById(2131302144));
    this.fOl = ((RecyclerView)findViewById(2131302145));
    this.fOp = new f(getContext());
    this.fOm = new LinearLayoutManager();
    this.fOj.setLayoutManager(this.fOm);
    this.fOj.a(this.fOp);
    this.fOn = new e(getContext(), true, this.fOs.fMg, this.fOw);
    this.fOj.setAdapter(this.fOn);
    this.fOn.asY.notifyChanged();
    this.fOq = new LinearLayoutManager();
    this.fOl.setLayoutManager(this.fOq);
    this.fOl.a(this.fOp);
    this.fOr = new e(getContext(), false, this.fMh, this.fOw);
    if (this.fOs.Ys()) {
      this.fOr.fOL = false;
    }
    this.fOl.setAdapter(this.fOr);
    this.fOr.asY.notifyChanged();
    YO();
    this.fOo = new android.support.v7.widget.a.a(new GroupToolsManagereUI.a(this.fOs.fMg, new b()
    {
      public final void YP()
      {
        AppMethodBeat.i(182170);
        GroupToolsManagereUI.e(GroupToolsManagereUI.this);
        GroupToolsManagereUI.f(GroupToolsManagereUI.this);
        AppMethodBeat.o(182170);
      }
    }));
    this.fOo.j(this.fOj);
    AppMethodBeat.o(182197);
  }
  
  public void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(182195);
    super.onCreate(paramBundle);
    getWindow().setSoftInputMode(32);
    this.fOt = getIntent().getStringExtra("key_chatroomname");
    if (bt.isNullOrNil(this.fOt))
    {
      ad.e("MicroMsg.roomtools.GroupToolsManagereUI", "mChatRoomName is null");
      finish();
    }
    for (;;)
    {
      initView();
      g.aiU().a(3546, this);
      AppMethodBeat.o(182195);
      return;
      this.fOs = ((PluginChatroomUI)g.ad(PluginChatroomUI.class)).getGroupToolsStorage().uR(this.fOt);
      if (this.fOs == null)
      {
        ad.e("MicroMsg.roomtools.GroupToolsManagereUI", "tools is null");
        finish();
      }
      else
      {
        paramBundle = getIntent().getParcelableArrayListExtra("key_recent_use_tools");
        if (paramBundle == null) {
          this.fMh = new LinkedList();
        }
        for (;;)
        {
          paramBundle = this.fOs.fMg.iterator();
          while (paramBundle.hasNext())
          {
            GroupToolItem localGroupToolItem = (GroupToolItem)paramBundle.next();
            if (this.fMh.contains(localGroupToolItem)) {
              this.fMh.remove(localGroupToolItem);
            }
          }
          this.fMh.addAll(paramBundle);
        }
        this.fOv = this.fOs.fMg.size();
        ad.i("MicroMsg.roomtools.GroupToolsManagereUI", "mChatRoomName is %s, recentUseToolItemList:%s", new Object[] { this.fOt, Integer.valueOf(this.fMh.size()) });
      }
    }
  }
  
  public void onDestroy()
  {
    AppMethodBeat.i(182199);
    g.aiU().b(3546, this);
    super.onDestroy();
    AppMethodBeat.o(182199);
  }
  
  public boolean onKeyUp(int paramInt, KeyEvent paramKeyEvent)
  {
    AppMethodBeat.i(182198);
    if (paramInt == 4)
    {
      YM();
      AppMethodBeat.o(182198);
      return true;
    }
    boolean bool = super.onKeyUp(paramInt, paramKeyEvent);
    AppMethodBeat.o(182198);
    return bool;
  }
  
  public void onSceneEnd(int paramInt1, int paramInt2, String paramString, com.tencent.mm.al.n paramn)
  {
    AppMethodBeat.i(182196);
    ad.i("MicroMsg.roomtools.GroupToolsManagereUI", "onSceneEnd errType = %d, errCode = %d, errMsg = %s, scenetype:%s", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), paramString, Integer.valueOf(paramn.getType()) });
    if ((this.tipDialog != null) && (this.tipDialog.isShowing())) {
      this.tipDialog.dismiss();
    }
    if ((paramInt1 == 0) && (paramInt2 == 0))
    {
      ad.i("MicroMsg.roomtools.GroupToolsManagereUI", "onSceneEnd result:%s", new Object[] { Boolean.valueOf(((PluginChatroomUI)g.ad(PluginChatroomUI.class)).getGroupToolsStorage().a(this.fOs, new String[0])) });
      ab.b(this.fOt, 3, this.fOv, this.fOs.fMg.size());
      finish();
      AppMethodBeat.o(182196);
      return;
    }
    AppCompatActivity localAppCompatActivity = getContext();
    paramn = paramString;
    if (bt.isNullOrNil(paramString)) {
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
    public abstract void YP();
  }
  
  public static abstract interface c
  {
    public abstract void M(RecyclerView.w paramw);
    
    public abstract void M(View paramView, int paramInt);
  }
  
  public static final class d
    extends RecyclerView.w
  {
    static final c fOJ;
    View fOB;
    RelativeLayout fOC;
    ImageView fOD;
    ImageView fOE;
    ImageView fOF;
    TextView fOG;
    RelativeLayout fOH;
    ImageView fOI;
    
    static
    {
      AppMethodBeat.i(182181);
      c.a locala1 = new c.a();
      locala1.idD = 2131689599;
      c.a locala2 = locala1.dh(com.tencent.mm.cc.a.fromDPToPix(aj.getContext(), 20), com.tencent.mm.cc.a.fromDPToPix(aj.getContext(), 20));
      locala2.hfi = true;
      locala2.idr = true;
      locala2.idp = true;
      fOJ = locala1.aJc();
      AppMethodBeat.o(182181);
    }
    
    public d(View paramView)
    {
      super();
      AppMethodBeat.i(182180);
      this.fOB = paramView;
      this.fOC = ((RelativeLayout)paramView.findViewById(2131305983));
      this.fOD = ((ImageView)paramView.findViewById(2131305977));
      this.fOE = ((ImageView)paramView.findViewById(2131305979));
      this.fOF = ((ImageView)paramView.findViewById(2131296846));
      this.fOG = ((TextView)paramView.findViewById(2131305985));
      this.fOH = ((RelativeLayout)paramView.findViewById(2131305981));
      this.fOI = ((ImageView)paramView.findViewById(2131305980));
      AppMethodBeat.o(182180);
    }
  }
  
  public static final class e
    extends RecyclerView.a
  {
    private Context context;
    private boolean fOK;
    boolean fOL = true;
    private List<GroupToolItem> fOM;
    private GroupToolsManagereUI.c fON;
    
    public e(Context paramContext, boolean paramBoolean, List<GroupToolItem> paramList, GroupToolsManagereUI.c paramc)
    {
      this.context = paramContext;
      this.fOK = paramBoolean;
      this.fOM = paramList;
      this.fON = paramc;
    }
    
    private static void a(GroupToolsManagereUI.d paramd, WxaAttributes paramWxaAttributes)
    {
      AppMethodBeat.i(182188);
      com.tencent.mm.aw.a.a locala = com.tencent.mm.aw.q.aIJ();
      Object localObject;
      if (paramWxaAttributes != null)
      {
        localObject = paramWxaAttributes.field_smallHeadURL;
        locala.a((String)localObject, paramd.fOF, GroupToolsManagereUI.d.fOJ);
        localObject = paramd.fOG;
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
      if ((this.fOM != null) && (paramInt >= 0) && (paramInt < this.fOM.size()))
      {
        paramw = (GroupToolsManagereUI.d)paramw;
        GroupToolItem localGroupToolItem = (GroupToolItem)this.fOM.get(paramInt);
        ad.d("MicroMsg.roomtools.GroupToolsManagereUI", "onBindViewHolder() i:%s", new Object[] { Integer.valueOf(paramInt) });
        paramw.fOB.setVisibility(0);
        if (this.fOK)
        {
          paramw.fOD.setVisibility(8);
          paramw.fOE.setVisibility(0);
          paramw.fOH.setVisibility(0);
          if (!localGroupToolItem.Yq()) {
            break label247;
          }
          paramw.fOF.setImageResource(2131232617);
          paramw.fOG.setText(2131757070);
          label131:
          if (!this.fOL) {
            break label344;
          }
          paramw.fOB.setAlpha(1.0F);
        }
        for (;;)
        {
          ((ViewGroup)paramw.fOC.getParent()).setTag(Boolean.valueOf(this.fOK));
          paramw.fOC.setTag(localGroupToolItem);
          paramw.fOC.setOnClickListener(new View.OnClickListener()
          {
            public final void onClick(View paramAnonymousView)
            {
              AppMethodBeat.i(182184);
              b localb = new b();
              localb.bd(paramAnonymousView);
              com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/chatroom/ui/GroupToolsManagereUI$ToolAdapter$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.ahq());
              if (GroupToolsManagereUI.e.a(GroupToolsManagereUI.e.this) != null) {
                GroupToolsManagereUI.e.a(GroupToolsManagereUI.e.this).M(paramAnonymousView, paramw.lN());
              }
              com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/chatroom/ui/GroupToolsManagereUI$ToolAdapter$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
              AppMethodBeat.o(182184);
            }
          });
          if (!this.fOK) {
            break label357;
          }
          paramw.fOH.setOnLongClickListener(new View.OnLongClickListener()
          {
            public final boolean onLongClick(View paramAnonymousView)
            {
              AppMethodBeat.i(182185);
              b localb = new b();
              localb.bd(paramAnonymousView);
              com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/chatroom/ui/GroupToolsManagereUI$ToolAdapter$3", "android/view/View$OnLongClickListener", "onLongClick", "(Landroid/view/View;)Z", this, localb.ahq());
              GroupToolsManagereUI.e.a(GroupToolsManagereUI.e.this).M(paramw);
              paramw.fOH.performHapticFeedback(0, 2);
              com.tencent.mm.hellhoundlib.a.a.a(true, this, "com/tencent/mm/chatroom/ui/GroupToolsManagereUI$ToolAdapter$3", "android/view/View$OnLongClickListener", "onLongClick", "(Landroid/view/View;)Z");
              AppMethodBeat.o(182185);
              return true;
            }
          });
          AppMethodBeat.o(182187);
          return;
          paramw.fOD.setVisibility(0);
          paramw.fOE.setVisibility(8);
          paramw.fOH.setVisibility(4);
          break;
          label247:
          if (localGroupToolItem.Yr())
          {
            paramw.fOF.setImageDrawable(com.tencent.mm.cc.a.l(this.context, 2131234903));
            paramw.fOG.setText(2131756264);
            break label131;
          }
          WxaAttributes localWxaAttributes = ((com.tencent.mm.plugin.appbrand.service.n)g.ab(com.tencent.mm.plugin.appbrand.service.n.class)).Nt(localGroupToolItem.username);
          if (localWxaAttributes == null)
          {
            ((com.tencent.mm.plugin.appbrand.service.n)g.ab(com.tencent.mm.plugin.appbrand.service.n.class)).a(localGroupToolItem.username, new n.a()
            {
              public final void b(final WxaAttributes paramAnonymousWxaAttributes)
              {
                AppMethodBeat.i(182183);
                aq.f(new Runnable()
                {
                  public final void run()
                  {
                    AppMethodBeat.i(182182);
                    GroupToolsManagereUI.e.b(GroupToolsManagereUI.e.1.this.fOO, paramAnonymousWxaAttributes);
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
          paramw.fOB.setAlpha(0.3F);
        }
        label357:
        paramw.fOH.setOnLongClickListener(null);
      }
      AppMethodBeat.o(182187);
    }
    
    public final int getItemCount()
    {
      AppMethodBeat.i(182189);
      int i = this.fOM.size();
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
    private Paint fOS;
    
    public f(Context paramContext)
    {
      AppMethodBeat.i(182191);
      this.dividerHeight = com.tencent.mm.cc.a.fromDPToPix(paramContext, 8);
      this.fOS = new Paint();
      this.fOS.setColor(paramContext.getResources().getColor(2131099650));
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
        paramCanvas.drawRect(k, f1, m - n, f2, this.fOS);
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