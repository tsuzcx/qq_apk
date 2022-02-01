package com.tencent.mm.chatroom.ui;

import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
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
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.RecyclerView.a;
import androidx.recyclerview.widget.RecyclerView.b;
import androidx.recyclerview.widget.RecyclerView.v;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.am.p;
import com.tencent.mm.chatroom.d.ae;
import com.tencent.mm.chatroom.plugin.PluginChatroomUI;
import com.tencent.mm.chatroom.storage.GroupToolItem;
import com.tencent.mm.chatroom.storage.e;
import com.tencent.mm.chatroom.storage.f;
import com.tencent.mm.hellhoundlib.b.b;
import com.tencent.mm.model.cn;
import com.tencent.mm.modelimage.loader.a.c;
import com.tencent.mm.modelimage.loader.a.c.a;
import com.tencent.mm.modelimage.r;
import com.tencent.mm.plugin.appbrand.config.WxaAttributes;
import com.tencent.mm.plugin.appbrand.service.s.a;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.MMHandlerThread;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.aa;
import com.tencent.mm.ui.base.w;
import com.tencent.mm.ui.y.b;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public class GroupToolsManagereUI
  extends MMActivity
  implements com.tencent.mm.am.h
{
  private LinearLayout lBF;
  private RecyclerView lBG;
  private LinearLayout lBH;
  private RecyclerView lBI;
  private LinearLayoutManager lBJ;
  private e lBK;
  private androidx.recyclerview.widget.k lBL;
  private GroupToolsManagereUI.f lBM;
  private LinearLayoutManager lBN;
  private e lBO;
  private e lBP;
  private String lBQ;
  private boolean lBR;
  private int lBS;
  private c lBT;
  private LinkedList<GroupToolItem> lzF;
  private w tipDialog;
  
  public GroupToolsManagereUI()
  {
    AppMethodBeat.i(182194);
    this.tipDialog = null;
    this.lBP = null;
    this.lzF = new LinkedList();
    this.lBR = false;
    this.lBS = 0;
    this.lBT = new c()
    {
      public final void L(RecyclerView.v paramAnonymousv)
      {
        AppMethodBeat.i(241498);
        GroupToolsManagereUI.h(GroupToolsManagereUI.this).f(paramAnonymousv);
        AppMethodBeat.o(241498);
      }
      
      public final void Q(View paramAnonymousView, int paramAnonymousInt)
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
            paramAnonymousView.egK = cn.bDv();
            GroupToolsManagereUI.a(GroupToolsManagereUI.this).lzE.remove(paramAnonymousView);
            GroupToolsManagereUI.b(GroupToolsManagereUI.this).addFirst(paramAnonymousView);
            GroupToolsManagereUI.c(GroupToolsManagereUI.this).fX(paramAnonymousInt);
            GroupToolsManagereUI.d(GroupToolsManagereUI.this).fW(0);
            if ((!bool) || (GroupToolsManagereUI.a(GroupToolsManagereUI.this).aMj())) {
              break label304;
            }
            GroupToolsManagereUI.d(GroupToolsManagereUI.this).lCh = true;
            GroupToolsManagereUI.d(GroupToolsManagereUI.this).bZE.notifyChanged();
          }
          for (;;)
          {
            GroupToolsManagereUI.e(GroupToolsManagereUI.this);
            GroupToolsManagereUI.f(GroupToolsManagereUI.this);
            GroupToolsManagereUI.g(GroupToolsManagereUI.this);
            AppMethodBeat.o(184789);
            return;
            if (GroupToolsManagereUI.a(GroupToolsManagereUI.this).aMj())
            {
              com.tencent.mm.ui.base.k.a(GroupToolsManagereUI.this, GroupToolsManagereUI.this.getString(a.i.lHt), "", GroupToolsManagereUI.this.getString(a.i.app_i_know), false, null);
              AppMethodBeat.o(184789);
              return;
            }
            GroupToolsManagereUI.a(GroupToolsManagereUI.this).lzE.addLast(paramAnonymousView);
            GroupToolsManagereUI.b(GroupToolsManagereUI.this).remove(paramAnonymousView);
            GroupToolsManagereUI.c(GroupToolsManagereUI.this).fW(GroupToolsManagereUI.a(GroupToolsManagereUI.this).lzE.size() - 1);
            GroupToolsManagereUI.d(GroupToolsManagereUI.this).fX(paramAnonymousInt);
            break;
            label304:
            if ((!bool) && (GroupToolsManagereUI.a(GroupToolsManagereUI.this).aMj()))
            {
              GroupToolsManagereUI.d(GroupToolsManagereUI.this).lCh = false;
              GroupToolsManagereUI.d(GroupToolsManagereUI.this).bZE.notifyChanged();
            }
          }
        }
        Log.i("MicroMsg.roomtools.GroupToolsManagereUI", "iRecentUseToolsCallback click");
        AppMethodBeat.o(184789);
      }
    };
    AppMethodBeat.o(182194);
  }
  
  private boolean aML()
  {
    AppMethodBeat.i(182200);
    if (this.lBR) {
      com.tencent.mm.ui.base.k.a(this, getString(a.i.lHo), "", getString(a.i.lHq), getString(a.i.lHp), false, new DialogInterface.OnClickListener()new DialogInterface.OnClickListener
      {
        public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
        {
          AppMethodBeat.i(182171);
          Log.i("MicroMsg.roomtools.GroupToolsManagereUI", "back_dialot ok");
          ae.c(GroupToolsManagereUI.j(GroupToolsManagereUI.this), 2, GroupToolsManagereUI.k(GroupToolsManagereUI.this), GroupToolsManagereUI.a(GroupToolsManagereUI.this).lzE.size());
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
      ae.c(this.lBQ, 1, this.lBS, this.lBP.lzE.size());
      finish();
    }
  }
  
  private void aMM()
  {
    AppMethodBeat.i(182201);
    if (this.lBR)
    {
      enableOptionMenu(0, true);
      AppMethodBeat.o(182201);
      return;
    }
    enableOptionMenu(0, false);
    AppMethodBeat.o(182201);
  }
  
  private void aMN()
  {
    AppMethodBeat.i(182202);
    if (this.lBP.lzE.size() > 0) {
      this.lBF.setVisibility(0);
    }
    while (this.lzF.size() > 0)
    {
      this.lBH.setVisibility(0);
      AppMethodBeat.o(182202);
      return;
      this.lBF.setVisibility(8);
    }
    this.lBH.setVisibility(8);
    AppMethodBeat.o(182202);
  }
  
  public int getLayoutId()
  {
    return a.f.lGh;
  }
  
  public void initView()
  {
    AppMethodBeat.i(182197);
    super.initView();
    setMMTitle("");
    hideActionbarLine();
    setActionbarColor(getResources().getColor(a.b.BG_2));
    setBackGroundColorResource(a.b.BG_2);
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
    addTextOptionMenu(0, getString(a.i.lHr), new MenuItem.OnMenuItemClickListener()
    {
      public final boolean onMenuItemClick(MenuItem paramAnonymousMenuItem)
      {
        AppMethodBeat.i(182173);
        Log.i("MicroMsg.roomtools.GroupToolsManagereUI", "menu click");
        paramAnonymousMenuItem = GroupToolsManagereUI.a(GroupToolsManagereUI.this);
        paramAnonymousMenuItem.field_stickToollist = e.bt(paramAnonymousMenuItem.lzE);
        GroupToolsManagereUI.l(GroupToolsManagereUI.this);
        AppMethodBeat.o(182173);
        return true;
      }
    }, null, y.b.adEJ);
    aMM();
    this.lBF = ((LinearLayout)findViewById(a.e.lFa));
    this.lBG = ((RecyclerView)findViewById(a.e.lFb));
    this.lBH = ((LinearLayout)findViewById(a.e.lEY));
    this.lBI = ((RecyclerView)findViewById(a.e.lEZ));
    this.lBM = new GroupToolsManagereUI.f(getContext());
    this.lBJ = new LinearLayoutManager();
    this.lBG.setLayoutManager(this.lBJ);
    this.lBG.a(this.lBM);
    this.lBK = new e(getContext(), true, this.lBP.lzE, this.lBT);
    this.lBG.setAdapter(this.lBK);
    this.lBK.bZE.notifyChanged();
    this.lBN = new LinearLayoutManager();
    this.lBI.setLayoutManager(this.lBN);
    this.lBI.a(this.lBM);
    this.lBO = new e(getContext(), false, this.lzF, this.lBT);
    if (this.lBP.aMj()) {
      this.lBO.lCh = false;
    }
    this.lBI.setAdapter(this.lBO);
    this.lBO.bZE.notifyChanged();
    aMN();
    this.lBL = new androidx.recyclerview.widget.k(new GroupToolsManagereUI.a(this.lBP.lzE, new b()
    {
      public final void onAlert()
      {
        AppMethodBeat.i(182170);
        GroupToolsManagereUI.e(GroupToolsManagereUI.this);
        GroupToolsManagereUI.f(GroupToolsManagereUI.this);
        AppMethodBeat.o(182170);
      }
    }));
    this.lBL.a(this.lBG);
    AppMethodBeat.o(182197);
  }
  
  public void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(182195);
    super.onCreate(paramBundle);
    getWindow().setSoftInputMode(32);
    this.lBQ = getIntent().getStringExtra("key_chatroomname");
    if (Util.isNullOrNil(this.lBQ))
    {
      Log.e("MicroMsg.roomtools.GroupToolsManagereUI", "mChatRoomName is null");
      finish();
    }
    for (;;)
    {
      initView();
      com.tencent.mm.kernel.h.aZW().a(3546, this);
      AppMethodBeat.o(182195);
      return;
      this.lBP = ((PluginChatroomUI)com.tencent.mm.kernel.h.az(PluginChatroomUI.class)).getGroupToolsStorage().Db(this.lBQ);
      if (this.lBP == null)
      {
        Log.e("MicroMsg.roomtools.GroupToolsManagereUI", "tools is null");
        finish();
      }
      else
      {
        paramBundle = getIntent().getParcelableArrayListExtra("key_recent_use_tools");
        if (paramBundle == null) {
          this.lzF = new LinkedList();
        }
        for (;;)
        {
          paramBundle = this.lBP.lzE.iterator();
          while (paramBundle.hasNext())
          {
            GroupToolItem localGroupToolItem = (GroupToolItem)paramBundle.next();
            if (this.lzF.contains(localGroupToolItem)) {
              this.lzF.remove(localGroupToolItem);
            }
          }
          this.lzF.addAll(paramBundle);
        }
        this.lBS = this.lBP.lzE.size();
        Log.i("MicroMsg.roomtools.GroupToolsManagereUI", "mChatRoomName is %s, recentUseToolItemList:%s", new Object[] { this.lBQ, Integer.valueOf(this.lzF.size()) });
      }
    }
  }
  
  public void onDestroy()
  {
    AppMethodBeat.i(182199);
    com.tencent.mm.kernel.h.aZW().b(3546, this);
    super.onDestroy();
    AppMethodBeat.o(182199);
  }
  
  public boolean onKeyUp(int paramInt, KeyEvent paramKeyEvent)
  {
    AppMethodBeat.i(182198);
    if (paramInt == 4)
    {
      aML();
      AppMethodBeat.o(182198);
      return true;
    }
    boolean bool = super.onKeyUp(paramInt, paramKeyEvent);
    AppMethodBeat.o(182198);
    return bool;
  }
  
  public void onSceneEnd(int paramInt1, int paramInt2, String paramString, p paramp)
  {
    AppMethodBeat.i(182196);
    Log.i("MicroMsg.roomtools.GroupToolsManagereUI", "onSceneEnd errType = %d, errCode = %d, errMsg = %s, scenetype:%s", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), paramString, Integer.valueOf(paramp.getType()) });
    if ((this.tipDialog != null) && (this.tipDialog.isShowing())) {
      this.tipDialog.dismiss();
    }
    if ((paramInt1 == 0) && (paramInt2 == 0))
    {
      Log.i("MicroMsg.roomtools.GroupToolsManagereUI", "onSceneEnd result:%s", new Object[] { Boolean.valueOf(((PluginChatroomUI)com.tencent.mm.kernel.h.az(PluginChatroomUI.class)).getGroupToolsStorage().a(this.lBP, new String[0])) });
      ae.c(this.lBQ, 3, this.lBS, this.lBP.lzE.size());
      finish();
      AppMethodBeat.o(182196);
      return;
    }
    AppCompatActivity localAppCompatActivity = getContext();
    paramp = paramString;
    if (Util.isNullOrNil(paramString)) {
      paramp = getString(a.i.lJv);
    }
    aa.makeText(localAppCompatActivity, paramp, 0).show();
    AppMethodBeat.o(182196);
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
  
  public static abstract interface b
  {
    public abstract void onAlert();
  }
  
  public static abstract interface c
  {
    public abstract void L(RecyclerView.v paramv);
    
    public abstract void Q(View paramView, int paramInt);
  }
  
  public static final class d
    extends RecyclerView.v
  {
    static final c lCf;
    View lBX;
    RelativeLayout lBY;
    ImageView lBZ;
    ImageView lCa;
    ImageView lCb;
    TextView lCc;
    RelativeLayout lCd;
    ImageView lCe;
    
    static
    {
      AppMethodBeat.i(182181);
      c.a locala1 = new c.a();
      locala1.oKB = a.h.app_brand_app_default_icon_for_tail;
      c.a locala2 = locala1.eG(com.tencent.mm.cd.a.fromDPToPix(MMApplicationContext.getContext(), 20), com.tencent.mm.cd.a.fromDPToPix(MMApplicationContext.getContext(), 20));
      locala2.nrc = true;
      locala2.oKp = true;
      locala2.oKn = true;
      lCf = locala1.bKx();
      AppMethodBeat.o(182181);
    }
    
    public d(View paramView)
    {
      super();
      AppMethodBeat.i(182180);
      this.lBX = paramView;
      this.lBY = ((RelativeLayout)paramView.findViewById(a.e.lFG));
      this.lBZ = ((ImageView)paramView.findViewById(a.e.lFC));
      this.lCa = ((ImageView)paramView.findViewById(a.e.lFD));
      this.lCb = ((ImageView)paramView.findViewById(a.e.frk));
      this.lCc = ((TextView)paramView.findViewById(a.e.lFH));
      this.lCd = ((RelativeLayout)paramView.findViewById(a.e.lFF));
      this.lCe = ((ImageView)paramView.findViewById(a.e.lFE));
      AppMethodBeat.o(182180);
    }
  }
  
  public static final class e
    extends RecyclerView.a
  {
    private Context context;
    private boolean lCg;
    boolean lCh = true;
    private List<GroupToolItem> lCi;
    private GroupToolsManagereUI.c lCj;
    
    public e(Context paramContext, boolean paramBoolean, List<GroupToolItem> paramList, GroupToolsManagereUI.c paramc)
    {
      this.context = paramContext;
      this.lCg = paramBoolean;
      this.lCi = paramList;
      this.lCj = paramc;
    }
    
    private static void a(GroupToolsManagereUI.d paramd, WxaAttributes paramWxaAttributes)
    {
      AppMethodBeat.i(182188);
      com.tencent.mm.modelimage.loader.a locala = r.bKe();
      Object localObject;
      if (paramWxaAttributes != null)
      {
        localObject = paramWxaAttributes.field_smallHeadURL;
        locala.a((String)localObject, paramd.lCb, GroupToolsManagereUI.d.lCf);
        localObject = paramd.lCc;
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
    
    public final RecyclerView.v b(ViewGroup paramViewGroup, int paramInt)
    {
      AppMethodBeat.i(241555);
      paramViewGroup = new GroupToolsManagereUI.d(LayoutInflater.from(paramViewGroup.getContext()).inflate(a.f.lGi, paramViewGroup, false));
      AppMethodBeat.o(241555);
      return paramViewGroup;
    }
    
    public final void d(final RecyclerView.v paramv, int paramInt)
    {
      AppMethodBeat.i(241571);
      if ((this.lCi != null) && (paramInt >= 0) && (paramInt < this.lCi.size()))
      {
        paramv = (GroupToolsManagereUI.d)paramv;
        GroupToolItem localGroupToolItem = (GroupToolItem)this.lCi.get(paramInt);
        Log.d("MicroMsg.roomtools.GroupToolsManagereUI", "onBindViewHolder() i:%s", new Object[] { Integer.valueOf(paramInt) });
        paramv.lBX.setVisibility(0);
        if (this.lCg)
        {
          paramv.lBZ.setVisibility(8);
          paramv.lCa.setVisibility(0);
          paramv.lCd.setVisibility(0);
          if (!localGroupToolItem.aMh()) {
            break label249;
          }
          paramv.lCb.setImageResource(a.d.group_tool_aa_pay);
          paramv.lCc.setText(a.i.lHs);
          label133:
          if (!this.lCh) {
            break label350;
          }
          paramv.lBX.setAlpha(1.0F);
        }
        for (;;)
        {
          ((ViewGroup)paramv.lBY.getParent()).setTag(Boolean.valueOf(this.lCg));
          paramv.lBY.setTag(localGroupToolItem);
          paramv.lBY.setOnClickListener(new View.OnClickListener()
          {
            public final void onClick(View paramAnonymousView)
            {
              AppMethodBeat.i(182184);
              b localb = new b();
              localb.cH(paramAnonymousView);
              com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/chatroom/ui/GroupToolsManagereUI$ToolAdapter$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.aYj());
              if (GroupToolsManagereUI.e.a(GroupToolsManagereUI.e.this) != null) {
                GroupToolsManagereUI.e.a(GroupToolsManagereUI.e.this).Q(paramAnonymousView, paramv.KJ());
              }
              com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/chatroom/ui/GroupToolsManagereUI$ToolAdapter$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
              AppMethodBeat.o(182184);
            }
          });
          if (!this.lCg) {
            break label363;
          }
          paramv.lCd.setOnLongClickListener(new View.OnLongClickListener()
          {
            public final boolean onLongClick(View paramAnonymousView)
            {
              AppMethodBeat.i(182185);
              b localb = new b();
              localb.cH(paramAnonymousView);
              com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/chatroom/ui/GroupToolsManagereUI$ToolAdapter$3", "android/view/View$OnLongClickListener", "onLongClick", "(Landroid/view/View;)Z", this, localb.aYj());
              GroupToolsManagereUI.e.a(GroupToolsManagereUI.e.this).L(paramv);
              paramv.lCd.performHapticFeedback(0, 2);
              com.tencent.mm.hellhoundlib.a.a.a(true, this, "com/tencent/mm/chatroom/ui/GroupToolsManagereUI$ToolAdapter$3", "android/view/View$OnLongClickListener", "onLongClick", "(Landroid/view/View;)Z");
              AppMethodBeat.o(182185);
              return true;
            }
          });
          AppMethodBeat.o(241571);
          return;
          paramv.lBZ.setVisibility(0);
          paramv.lCa.setVisibility(8);
          paramv.lCd.setVisibility(4);
          break;
          label249:
          if (localGroupToolItem.aMi())
          {
            paramv.lCb.setImageDrawable(com.tencent.mm.cd.a.m(this.context, a.d.group_tool_live));
            paramv.lCc.setText(a.i.app_field_live);
            break label133;
          }
          WxaAttributes localWxaAttributes = ((com.tencent.mm.plugin.appbrand.service.s)com.tencent.mm.kernel.h.ax(com.tencent.mm.plugin.appbrand.service.s.class)).Xy(localGroupToolItem.username);
          if (localWxaAttributes == null)
          {
            ((com.tencent.mm.plugin.appbrand.service.s)com.tencent.mm.kernel.h.ax(com.tencent.mm.plugin.appbrand.service.s.class)).a(localGroupToolItem.username, new s.a()
            {
              public final void onGetWeAppInfo(final WxaAttributes paramAnonymousWxaAttributes)
              {
                AppMethodBeat.i(182183);
                MMHandlerThread.postToMainThread(new Runnable()
                {
                  public final void run()
                  {
                    AppMethodBeat.i(182182);
                    GroupToolsManagereUI.e.b(GroupToolsManagereUI.e.1.this.lCk, paramAnonymousWxaAttributes);
                    AppMethodBeat.o(182182);
                  }
                });
                AppMethodBeat.o(182183);
              }
            });
            break label133;
          }
          a(paramv, localWxaAttributes);
          break label133;
          label350:
          paramv.lBX.setAlpha(0.3F);
        }
        label363:
        paramv.lCd.setOnLongClickListener(null);
      }
      AppMethodBeat.o(241571);
    }
    
    public final int getItemCount()
    {
      AppMethodBeat.i(182189);
      int i = this.lCi.size();
      AppMethodBeat.o(182189);
      return i;
    }
    
    public final int getItemViewType(int paramInt)
    {
      return 0;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.chatroom.ui.GroupToolsManagereUI
 * JD-Core Version:    0.7.0.1
 */