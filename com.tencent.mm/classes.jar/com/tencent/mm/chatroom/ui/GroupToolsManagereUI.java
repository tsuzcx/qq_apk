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
import com.tencent.mm.av.a.a.c;
import com.tencent.mm.av.a.a.c.a;
import com.tencent.mm.chatroom.d.ab;
import com.tencent.mm.chatroom.plugin.PluginChatroomUI;
import com.tencent.mm.chatroom.storage.GroupToolItem;
import com.tencent.mm.chatroom.storage.e;
import com.tencent.mm.hellhoundlib.b.b;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.ch;
import com.tencent.mm.plugin.appbrand.config.WxaAttributes;
import com.tencent.mm.plugin.appbrand.service.o;
import com.tencent.mm.plugin.appbrand.service.o.a;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.ak;
import com.tencent.mm.sdk.platformtools.ar;
import com.tencent.mm.sdk.platformtools.bu;
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
  implements com.tencent.mm.ak.f
{
  private LinkedList<GroupToolItem> fOn;
  private boolean fQA;
  private int fQB;
  private c fQC;
  private LinearLayout fQo;
  private RecyclerView fQp;
  private LinearLayout fQq;
  private RecyclerView fQr;
  private LinearLayoutManager fQs;
  private e fQt;
  private android.support.v7.widget.a.a fQu;
  private f fQv;
  private LinearLayoutManager fQw;
  private e fQx;
  private e fQy;
  private String fQz;
  private p tipDialog;
  
  public GroupToolsManagereUI()
  {
    AppMethodBeat.i(182194);
    this.tipDialog = null;
    this.fQy = null;
    this.fOn = new LinkedList();
    this.fQA = false;
    this.fQB = 0;
    this.fQC = new c()
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
          ae.i("MicroMsg.roomtools.GroupToolsManagereUI", "iRecentUseToolsCallback click stick:%s", new Object[] { Boolean.valueOf(bool) });
          if (bool)
          {
            paramAnonymousView.fOl = ch.aDb();
            GroupToolsManagereUI.a(GroupToolsManagereUI.this).fOm.remove(paramAnonymousView);
            GroupToolsManagereUI.b(GroupToolsManagereUI.this).addFirst(paramAnonymousView);
            GroupToolsManagereUI.c(GroupToolsManagereUI.this).cl(paramAnonymousInt);
            GroupToolsManagereUI.d(GroupToolsManagereUI.this).ck(0);
            if ((!bool) || (GroupToolsManagereUI.a(GroupToolsManagereUI.this).YB())) {
              break label302;
            }
            GroupToolsManagereUI.d(GroupToolsManagereUI.this).fQR = true;
            GroupToolsManagereUI.d(GroupToolsManagereUI.this).asY.notifyChanged();
          }
          for (;;)
          {
            GroupToolsManagereUI.e(GroupToolsManagereUI.this);
            GroupToolsManagereUI.f(GroupToolsManagereUI.this);
            GroupToolsManagereUI.g(GroupToolsManagereUI.this);
            AppMethodBeat.o(184789);
            return;
            if (GroupToolsManagereUI.a(GroupToolsManagereUI.this).YB())
            {
              h.a(GroupToolsManagereUI.this, GroupToolsManagereUI.this.getString(2131757071), "", GroupToolsManagereUI.this.getString(2131755792), false, null);
              AppMethodBeat.o(184789);
              return;
            }
            GroupToolsManagereUI.a(GroupToolsManagereUI.this).fOm.addLast(paramAnonymousView);
            GroupToolsManagereUI.b(GroupToolsManagereUI.this).remove(paramAnonymousView);
            GroupToolsManagereUI.c(GroupToolsManagereUI.this).ck(GroupToolsManagereUI.a(GroupToolsManagereUI.this).fOm.size() - 1);
            GroupToolsManagereUI.d(GroupToolsManagereUI.this).cl(paramAnonymousInt);
            break;
            label302:
            if ((!bool) && (GroupToolsManagereUI.a(GroupToolsManagereUI.this).YB()))
            {
              GroupToolsManagereUI.d(GroupToolsManagereUI.this).fQR = false;
              GroupToolsManagereUI.d(GroupToolsManagereUI.this).asY.notifyChanged();
            }
          }
        }
        ae.i("MicroMsg.roomtools.GroupToolsManagereUI", "iRecentUseToolsCallback click");
        AppMethodBeat.o(184789);
      }
    };
    AppMethodBeat.o(182194);
  }
  
  private boolean YV()
  {
    AppMethodBeat.i(182200);
    if (this.fQA) {
      h.a(this, getString(2131757062), "", getString(2131757064), getString(2131757063), false, new DialogInterface.OnClickListener()new DialogInterface.OnClickListener
      {
        public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
        {
          AppMethodBeat.i(182171);
          ae.i("MicroMsg.roomtools.GroupToolsManagereUI", "back_dialot ok");
          ab.b(GroupToolsManagereUI.j(GroupToolsManagereUI.this), 2, GroupToolsManagereUI.k(GroupToolsManagereUI.this), GroupToolsManagereUI.a(GroupToolsManagereUI.this).fOm.size());
          GroupToolsManagereUI.this.finish();
          AppMethodBeat.o(182171);
        }
      }, new DialogInterface.OnClickListener()
      {
        public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
        {
          AppMethodBeat.i(182172);
          ae.i("MicroMsg.roomtools.GroupToolsManagereUI", "back_dialot cancel");
          AppMethodBeat.o(182172);
        }
      });
    }
    for (;;)
    {
      AppMethodBeat.o(182200);
      return true;
      ab.b(this.fQz, 1, this.fQB, this.fQy.fOm.size());
      finish();
    }
  }
  
  private void YW()
  {
    AppMethodBeat.i(182201);
    if (this.fQA)
    {
      enableOptionMenu(0, true);
      AppMethodBeat.o(182201);
      return;
    }
    enableOptionMenu(0, false);
    AppMethodBeat.o(182201);
  }
  
  private void YX()
  {
    AppMethodBeat.i(182202);
    if (this.fQy.fOm.size() > 0) {
      this.fQo.setVisibility(0);
    }
    while (this.fOn.size() > 0)
    {
      this.fQq.setVisibility(0);
      AppMethodBeat.o(182202);
      return;
      this.fQo.setVisibility(8);
    }
    this.fQq.setVisibility(8);
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
        ae.i("MicroMsg.roomtools.GroupToolsManagereUI", "menu click");
        paramAnonymousMenuItem = GroupToolsManagereUI.a(GroupToolsManagereUI.this);
        paramAnonymousMenuItem.field_stickToollist = e.Q(paramAnonymousMenuItem.fOm);
        GroupToolsManagereUI.l(GroupToolsManagereUI.this);
        AppMethodBeat.o(182173);
        return true;
      }
    }, null, s.b.JwA);
    YW();
    this.fQo = ((LinearLayout)findViewById(2131302146));
    this.fQp = ((RecyclerView)findViewById(2131302147));
    this.fQq = ((LinearLayout)findViewById(2131302144));
    this.fQr = ((RecyclerView)findViewById(2131302145));
    this.fQv = new f(getContext());
    this.fQs = new LinearLayoutManager();
    this.fQp.setLayoutManager(this.fQs);
    this.fQp.a(this.fQv);
    this.fQt = new e(getContext(), true, this.fQy.fOm, this.fQC);
    this.fQp.setAdapter(this.fQt);
    this.fQt.asY.notifyChanged();
    this.fQw = new LinearLayoutManager();
    this.fQr.setLayoutManager(this.fQw);
    this.fQr.a(this.fQv);
    this.fQx = new e(getContext(), false, this.fOn, this.fQC);
    if (this.fQy.YB()) {
      this.fQx.fQR = false;
    }
    this.fQr.setAdapter(this.fQx);
    this.fQx.asY.notifyChanged();
    YX();
    this.fQu = new android.support.v7.widget.a.a(new GroupToolsManagereUI.a(this.fQy.fOm, new b()
    {
      public final void YY()
      {
        AppMethodBeat.i(182170);
        GroupToolsManagereUI.e(GroupToolsManagereUI.this);
        GroupToolsManagereUI.f(GroupToolsManagereUI.this);
        AppMethodBeat.o(182170);
      }
    }));
    this.fQu.j(this.fQp);
    AppMethodBeat.o(182197);
  }
  
  public void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(182195);
    super.onCreate(paramBundle);
    getWindow().setSoftInputMode(32);
    this.fQz = getIntent().getStringExtra("key_chatroomname");
    if (bu.isNullOrNil(this.fQz))
    {
      ae.e("MicroMsg.roomtools.GroupToolsManagereUI", "mChatRoomName is null");
      finish();
    }
    for (;;)
    {
      initView();
      g.ajj().a(3546, this);
      AppMethodBeat.o(182195);
      return;
      this.fQy = ((PluginChatroomUI)g.ad(PluginChatroomUI.class)).getGroupToolsStorage().vn(this.fQz);
      if (this.fQy == null)
      {
        ae.e("MicroMsg.roomtools.GroupToolsManagereUI", "tools is null");
        finish();
      }
      else
      {
        paramBundle = getIntent().getParcelableArrayListExtra("key_recent_use_tools");
        if (paramBundle == null) {
          this.fOn = new LinkedList();
        }
        for (;;)
        {
          paramBundle = this.fQy.fOm.iterator();
          while (paramBundle.hasNext())
          {
            GroupToolItem localGroupToolItem = (GroupToolItem)paramBundle.next();
            if (this.fOn.contains(localGroupToolItem)) {
              this.fOn.remove(localGroupToolItem);
            }
          }
          this.fOn.addAll(paramBundle);
        }
        this.fQB = this.fQy.fOm.size();
        ae.i("MicroMsg.roomtools.GroupToolsManagereUI", "mChatRoomName is %s, recentUseToolItemList:%s", new Object[] { this.fQz, Integer.valueOf(this.fOn.size()) });
      }
    }
  }
  
  public void onDestroy()
  {
    AppMethodBeat.i(182199);
    g.ajj().b(3546, this);
    super.onDestroy();
    AppMethodBeat.o(182199);
  }
  
  public boolean onKeyUp(int paramInt, KeyEvent paramKeyEvent)
  {
    AppMethodBeat.i(182198);
    if (paramInt == 4)
    {
      YV();
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
    ae.i("MicroMsg.roomtools.GroupToolsManagereUI", "onSceneEnd errType = %d, errCode = %d, errMsg = %s, scenetype:%s", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), paramString, Integer.valueOf(paramn.getType()) });
    if ((this.tipDialog != null) && (this.tipDialog.isShowing())) {
      this.tipDialog.dismiss();
    }
    if ((paramInt1 == 0) && (paramInt2 == 0))
    {
      ae.i("MicroMsg.roomtools.GroupToolsManagereUI", "onSceneEnd result:%s", new Object[] { Boolean.valueOf(((PluginChatroomUI)g.ad(PluginChatroomUI.class)).getGroupToolsStorage().a(this.fQy, new String[0])) });
      ab.b(this.fQz, 3, this.fQB, this.fQy.fOm.size());
      finish();
      AppMethodBeat.o(182196);
      return;
    }
    AppCompatActivity localAppCompatActivity = getContext();
    paramn = paramString;
    if (bu.isNullOrNil(paramString)) {
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
    public abstract void YY();
  }
  
  public static abstract interface c
  {
    public abstract void M(RecyclerView.w paramw);
    
    public abstract void M(View paramView, int paramInt);
  }
  
  public static final class d
    extends RecyclerView.w
  {
    static final c fQP;
    View fQH;
    RelativeLayout fQI;
    ImageView fQJ;
    ImageView fQK;
    ImageView fQL;
    TextView fQM;
    RelativeLayout fQN;
    ImageView fQO;
    
    static
    {
      AppMethodBeat.i(182181);
      c.a locala1 = new c.a();
      locala1.igv = 2131689599;
      c.a locala2 = locala1.dh(com.tencent.mm.cb.a.fromDPToPix(ak.getContext(), 20), com.tencent.mm.cb.a.fromDPToPix(ak.getContext(), 20));
      locala2.hhW = true;
      locala2.igk = true;
      locala2.igi = true;
      fQP = locala1.aJu();
      AppMethodBeat.o(182181);
    }
    
    public d(View paramView)
    {
      super();
      AppMethodBeat.i(182180);
      this.fQH = paramView;
      this.fQI = ((RelativeLayout)paramView.findViewById(2131305983));
      this.fQJ = ((ImageView)paramView.findViewById(2131305977));
      this.fQK = ((ImageView)paramView.findViewById(2131305979));
      this.fQL = ((ImageView)paramView.findViewById(2131296846));
      this.fQM = ((TextView)paramView.findViewById(2131305985));
      this.fQN = ((RelativeLayout)paramView.findViewById(2131305981));
      this.fQO = ((ImageView)paramView.findViewById(2131305980));
      AppMethodBeat.o(182180);
    }
  }
  
  public static final class e
    extends RecyclerView.a
  {
    private Context context;
    private boolean fQQ;
    boolean fQR = true;
    private List<GroupToolItem> fQS;
    private GroupToolsManagereUI.c fQT;
    
    public e(Context paramContext, boolean paramBoolean, List<GroupToolItem> paramList, GroupToolsManagereUI.c paramc)
    {
      this.context = paramContext;
      this.fQQ = paramBoolean;
      this.fQS = paramList;
      this.fQT = paramc;
    }
    
    private static void a(GroupToolsManagereUI.d paramd, WxaAttributes paramWxaAttributes)
    {
      AppMethodBeat.i(182188);
      com.tencent.mm.av.a.a locala = com.tencent.mm.av.q.aJb();
      Object localObject;
      if (paramWxaAttributes != null)
      {
        localObject = paramWxaAttributes.field_smallHeadURL;
        locala.a((String)localObject, paramd.fQL, GroupToolsManagereUI.d.fQP);
        localObject = paramd.fQM;
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
      if ((this.fQS != null) && (paramInt >= 0) && (paramInt < this.fQS.size()))
      {
        paramw = (GroupToolsManagereUI.d)paramw;
        GroupToolItem localGroupToolItem = (GroupToolItem)this.fQS.get(paramInt);
        ae.d("MicroMsg.roomtools.GroupToolsManagereUI", "onBindViewHolder() i:%s", new Object[] { Integer.valueOf(paramInt) });
        paramw.fQH.setVisibility(0);
        if (this.fQQ)
        {
          paramw.fQJ.setVisibility(8);
          paramw.fQK.setVisibility(0);
          paramw.fQN.setVisibility(0);
          if (!localGroupToolItem.Yz()) {
            break label247;
          }
          paramw.fQL.setImageResource(2131232617);
          paramw.fQM.setText(2131757070);
          label131:
          if (!this.fQR) {
            break label344;
          }
          paramw.fQH.setAlpha(1.0F);
        }
        for (;;)
        {
          ((ViewGroup)paramw.fQI.getParent()).setTag(Boolean.valueOf(this.fQQ));
          paramw.fQI.setTag(localGroupToolItem);
          paramw.fQI.setOnClickListener(new View.OnClickListener()
          {
            public final void onClick(View paramAnonymousView)
            {
              AppMethodBeat.i(182184);
              b localb = new b();
              localb.bd(paramAnonymousView);
              com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/chatroom/ui/GroupToolsManagereUI$ToolAdapter$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.ahF());
              if (GroupToolsManagereUI.e.a(GroupToolsManagereUI.e.this) != null) {
                GroupToolsManagereUI.e.a(GroupToolsManagereUI.e.this).M(paramAnonymousView, paramw.lN());
              }
              com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/chatroom/ui/GroupToolsManagereUI$ToolAdapter$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
              AppMethodBeat.o(182184);
            }
          });
          if (!this.fQQ) {
            break label357;
          }
          paramw.fQN.setOnLongClickListener(new View.OnLongClickListener()
          {
            public final boolean onLongClick(View paramAnonymousView)
            {
              AppMethodBeat.i(182185);
              b localb = new b();
              localb.bd(paramAnonymousView);
              com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/chatroom/ui/GroupToolsManagereUI$ToolAdapter$3", "android/view/View$OnLongClickListener", "onLongClick", "(Landroid/view/View;)Z", this, localb.ahF());
              GroupToolsManagereUI.e.a(GroupToolsManagereUI.e.this).M(paramw);
              paramw.fQN.performHapticFeedback(0, 2);
              com.tencent.mm.hellhoundlib.a.a.a(true, this, "com/tencent/mm/chatroom/ui/GroupToolsManagereUI$ToolAdapter$3", "android/view/View$OnLongClickListener", "onLongClick", "(Landroid/view/View;)Z");
              AppMethodBeat.o(182185);
              return true;
            }
          });
          AppMethodBeat.o(182187);
          return;
          paramw.fQJ.setVisibility(0);
          paramw.fQK.setVisibility(8);
          paramw.fQN.setVisibility(4);
          break;
          label247:
          if (localGroupToolItem.YA())
          {
            paramw.fQL.setImageDrawable(com.tencent.mm.cb.a.l(this.context, 2131234903));
            paramw.fQM.setText(2131756264);
            break label131;
          }
          WxaAttributes localWxaAttributes = ((o)g.ab(o.class)).Ob(localGroupToolItem.username);
          if (localWxaAttributes == null)
          {
            ((o)g.ab(o.class)).a(localGroupToolItem.username, new o.a()
            {
              public final void b(final WxaAttributes paramAnonymousWxaAttributes)
              {
                AppMethodBeat.i(182183);
                ar.f(new Runnable()
                {
                  public final void run()
                  {
                    AppMethodBeat.i(182182);
                    GroupToolsManagereUI.e.b(GroupToolsManagereUI.e.1.this.fQU, paramAnonymousWxaAttributes);
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
          paramw.fQH.setAlpha(0.3F);
        }
        label357:
        paramw.fQN.setOnLongClickListener(null);
      }
      AppMethodBeat.o(182187);
    }
    
    public final int getItemCount()
    {
      AppMethodBeat.i(182189);
      int i = this.fQS.size();
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
    private Paint fQY;
    
    public f(Context paramContext)
    {
      AppMethodBeat.i(182191);
      this.dividerHeight = com.tencent.mm.cb.a.fromDPToPix(paramContext, 8);
      this.fQY = new Paint();
      this.fQY.setColor(paramContext.getResources().getColor(2131099650));
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
        paramCanvas.drawRect(k, f1, m - n, f2, this.fQY);
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