package com.tencent.mm.chatroom.ui;

import android.app.Activity;
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
import androidx.recyclerview.widget.l;
import androidx.recyclerview.widget.l.a;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.an.i;
import com.tencent.mm.an.t;
import com.tencent.mm.chatroom.d.ab;
import com.tencent.mm.chatroom.plugin.PluginChatroomUI;
import com.tencent.mm.chatroom.storage.GroupToolItem;
import com.tencent.mm.chatroom.storage.e;
import com.tencent.mm.chatroom.storage.f;
import com.tencent.mm.hellhoundlib.b.b;
import com.tencent.mm.model.cm;
import com.tencent.mm.plugin.appbrand.config.WxaAttributes;
import com.tencent.mm.plugin.appbrand.service.q.a;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMHandlerThread;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.s;
import com.tencent.mm.ui.base.w;
import com.tencent.mm.ui.w.b;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public class GroupToolsManagereUI
  extends MMActivity
  implements i
{
  private LinkedList<GroupToolItem> iXJ;
  private LinearLayout iZJ;
  private RecyclerView iZK;
  private LinearLayout iZL;
  private RecyclerView iZM;
  private LinearLayoutManager iZN;
  private e iZO;
  private l iZP;
  private GroupToolsManagereUI.f iZQ;
  private LinearLayoutManager iZR;
  private e iZS;
  private e iZT;
  private String iZU;
  private boolean iZV;
  private int iZW;
  private c iZX;
  private s tipDialog;
  
  public GroupToolsManagereUI()
  {
    AppMethodBeat.i(182194);
    this.tipDialog = null;
    this.iZT = null;
    this.iXJ = new LinkedList();
    this.iZV = false;
    this.iZW = 0;
    this.iZX = new c()
    {
      public final void L(View paramAnonymousView, int paramAnonymousInt)
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
            paramAnonymousView.coZ = cm.bfD();
            GroupToolsManagereUI.a(GroupToolsManagereUI.this).iXI.remove(paramAnonymousView);
            GroupToolsManagereUI.b(GroupToolsManagereUI.this).addFirst(paramAnonymousView);
            GroupToolsManagereUI.c(GroupToolsManagereUI.this).cN(paramAnonymousInt);
            GroupToolsManagereUI.d(GroupToolsManagereUI.this).cM(0);
            if ((!bool) || (GroupToolsManagereUI.a(GroupToolsManagereUI.this).asp())) {
              break label304;
            }
            GroupToolsManagereUI.d(GroupToolsManagereUI.this).jam = true;
            GroupToolsManagereUI.d(GroupToolsManagereUI.this).alc.notifyChanged();
          }
          for (;;)
          {
            GroupToolsManagereUI.e(GroupToolsManagereUI.this);
            GroupToolsManagereUI.f(GroupToolsManagereUI.this);
            GroupToolsManagereUI.g(GroupToolsManagereUI.this);
            AppMethodBeat.o(184789);
            return;
            if (GroupToolsManagereUI.a(GroupToolsManagereUI.this).asp())
            {
              com.tencent.mm.ui.base.h.a(GroupToolsManagereUI.this, GroupToolsManagereUI.this.getString(a.i.jfi), "", GroupToolsManagereUI.this.getString(a.i.app_i_know), false, null);
              AppMethodBeat.o(184789);
              return;
            }
            GroupToolsManagereUI.a(GroupToolsManagereUI.this).iXI.addLast(paramAnonymousView);
            GroupToolsManagereUI.b(GroupToolsManagereUI.this).remove(paramAnonymousView);
            GroupToolsManagereUI.c(GroupToolsManagereUI.this).cM(GroupToolsManagereUI.a(GroupToolsManagereUI.this).iXI.size() - 1);
            GroupToolsManagereUI.d(GroupToolsManagereUI.this).cN(paramAnonymousInt);
            break;
            label304:
            if ((!bool) && (GroupToolsManagereUI.a(GroupToolsManagereUI.this).asp()))
            {
              GroupToolsManagereUI.d(GroupToolsManagereUI.this).jam = false;
              GroupToolsManagereUI.d(GroupToolsManagereUI.this).alc.notifyChanged();
            }
          }
        }
        Log.i("MicroMsg.roomtools.GroupToolsManagereUI", "iRecentUseToolsCallback click");
        AppMethodBeat.o(184789);
      }
      
      public final void O(RecyclerView.v paramAnonymousv)
      {
        AppMethodBeat.i(189390);
        l locall = GroupToolsManagereUI.h(GroupToolsManagereUI.this);
        if ((locall.aib.c(locall.mRecyclerView, paramAnonymousv)) && (paramAnonymousv.amk.getParent() == locall.mRecyclerView))
        {
          locall.kx();
          locall.ahY = 0.0F;
          locall.ahX = 0.0F;
          locall.a(paramAnonymousv, 2);
        }
        AppMethodBeat.o(189390);
      }
    };
    AppMethodBeat.o(182194);
  }
  
  private boolean asJ()
  {
    AppMethodBeat.i(182200);
    if (this.iZV) {
      com.tencent.mm.ui.base.h.a(this, getString(a.i.jfd), "", getString(a.i.jff), getString(a.i.jfe), false, new DialogInterface.OnClickListener()new DialogInterface.OnClickListener
      {
        public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
        {
          AppMethodBeat.i(182171);
          Log.i("MicroMsg.roomtools.GroupToolsManagereUI", "back_dialot ok");
          ab.c(GroupToolsManagereUI.j(GroupToolsManagereUI.this), 2, GroupToolsManagereUI.k(GroupToolsManagereUI.this), GroupToolsManagereUI.a(GroupToolsManagereUI.this).iXI.size());
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
      ab.c(this.iZU, 1, this.iZW, this.iZT.iXI.size());
      finish();
    }
  }
  
  private void asK()
  {
    AppMethodBeat.i(182201);
    if (this.iZV)
    {
      enableOptionMenu(0, true);
      AppMethodBeat.o(182201);
      return;
    }
    enableOptionMenu(0, false);
    AppMethodBeat.o(182201);
  }
  
  private void asL()
  {
    AppMethodBeat.i(182202);
    if (this.iZT.iXI.size() > 0) {
      this.iZJ.setVisibility(0);
    }
    while (this.iXJ.size() > 0)
    {
      this.iZL.setVisibility(0);
      AppMethodBeat.o(182202);
      return;
      this.iZJ.setVisibility(8);
    }
    this.iZL.setVisibility(8);
    AppMethodBeat.o(182202);
  }
  
  public int getLayoutId()
  {
    return a.f.jdY;
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
    addTextOptionMenu(0, getString(a.i.jfg), new GroupToolsManagereUI.6(this), null, w.b.Wao);
    asK();
    this.iZJ = ((LinearLayout)findViewById(a.e.jcT));
    this.iZK = ((RecyclerView)findViewById(a.e.jcU));
    this.iZL = ((LinearLayout)findViewById(a.e.jcR));
    this.iZM = ((RecyclerView)findViewById(a.e.jcS));
    this.iZQ = new GroupToolsManagereUI.f(getContext());
    this.iZN = new LinearLayoutManager();
    this.iZK.setLayoutManager(this.iZN);
    this.iZK.a(this.iZQ);
    this.iZO = new e(getContext(), true, this.iZT.iXI, this.iZX);
    this.iZK.setAdapter(this.iZO);
    this.iZO.alc.notifyChanged();
    this.iZR = new LinearLayoutManager();
    this.iZM.setLayoutManager(this.iZR);
    this.iZM.a(this.iZQ);
    this.iZS = new e(getContext(), false, this.iXJ, this.iZX);
    if (this.iZT.asp()) {
      this.iZS.jam = false;
    }
    this.iZM.setAdapter(this.iZS);
    this.iZS.alc.notifyChanged();
    asL();
    this.iZP = new l(new GroupToolsManagereUI.a(this.iZT.iXI, new GroupToolsManagereUI.b()
    {
      public final void asM()
      {
        AppMethodBeat.i(182170);
        GroupToolsManagereUI.e(GroupToolsManagereUI.this);
        GroupToolsManagereUI.f(GroupToolsManagereUI.this);
        AppMethodBeat.o(182170);
      }
    }));
    this.iZP.a(this.iZK);
    AppMethodBeat.o(182197);
  }
  
  public void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(182195);
    super.onCreate(paramBundle);
    getWindow().setSoftInputMode(32);
    this.iZU = getIntent().getStringExtra("key_chatroomname");
    if (Util.isNullOrNil(this.iZU))
    {
      Log.e("MicroMsg.roomtools.GroupToolsManagereUI", "mChatRoomName is null");
      finish();
    }
    for (;;)
    {
      initView();
      com.tencent.mm.kernel.h.aGY().a(3546, this);
      AppMethodBeat.o(182195);
      return;
      this.iZT = ((PluginChatroomUI)com.tencent.mm.kernel.h.ag(PluginChatroomUI.class)).getGroupToolsStorage().Kv(this.iZU);
      if (this.iZT == null)
      {
        Log.e("MicroMsg.roomtools.GroupToolsManagereUI", "tools is null");
        finish();
      }
      else
      {
        paramBundle = getIntent().getParcelableArrayListExtra("key_recent_use_tools");
        if (paramBundle == null) {
          this.iXJ = new LinkedList();
        }
        for (;;)
        {
          paramBundle = this.iZT.iXI.iterator();
          while (paramBundle.hasNext())
          {
            GroupToolItem localGroupToolItem = (GroupToolItem)paramBundle.next();
            if (this.iXJ.contains(localGroupToolItem)) {
              this.iXJ.remove(localGroupToolItem);
            }
          }
          this.iXJ.addAll(paramBundle);
        }
        this.iZW = this.iZT.iXI.size();
        Log.i("MicroMsg.roomtools.GroupToolsManagereUI", "mChatRoomName is %s, recentUseToolItemList:%s", new Object[] { this.iZU, Integer.valueOf(this.iXJ.size()) });
      }
    }
  }
  
  public void onDestroy()
  {
    AppMethodBeat.i(182199);
    com.tencent.mm.kernel.h.aGY().b(3546, this);
    super.onDestroy();
    AppMethodBeat.o(182199);
  }
  
  public boolean onKeyUp(int paramInt, KeyEvent paramKeyEvent)
  {
    AppMethodBeat.i(182198);
    if (paramInt == 4)
    {
      asJ();
      AppMethodBeat.o(182198);
      return true;
    }
    boolean bool = super.onKeyUp(paramInt, paramKeyEvent);
    AppMethodBeat.o(182198);
    return bool;
  }
  
  public void onSceneEnd(int paramInt1, int paramInt2, String paramString, com.tencent.mm.an.q paramq)
  {
    AppMethodBeat.i(182196);
    Log.i("MicroMsg.roomtools.GroupToolsManagereUI", "onSceneEnd errType = %d, errCode = %d, errMsg = %s, scenetype:%s", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), paramString, Integer.valueOf(paramq.getType()) });
    if ((this.tipDialog != null) && (this.tipDialog.isShowing())) {
      this.tipDialog.dismiss();
    }
    if ((paramInt1 == 0) && (paramInt2 == 0))
    {
      Log.i("MicroMsg.roomtools.GroupToolsManagereUI", "onSceneEnd result:%s", new Object[] { Boolean.valueOf(((PluginChatroomUI)com.tencent.mm.kernel.h.ag(PluginChatroomUI.class)).getGroupToolsStorage().a(this.iZT, new String[0])) });
      ab.c(this.iZU, 3, this.iZW, this.iZT.iXI.size());
      finish();
      AppMethodBeat.o(182196);
      return;
    }
    AppCompatActivity localAppCompatActivity = getContext();
    paramq = paramString;
    if (Util.isNullOrNil(paramString)) {
      paramq = getString(a.i.jhf);
    }
    w.makeText(localAppCompatActivity, paramq, 0).show();
    AppMethodBeat.o(182196);
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
  
  public static abstract interface c
  {
    public abstract void L(View paramView, int paramInt);
    
    public abstract void O(RecyclerView.v paramv);
  }
  
  public static final class e
    extends RecyclerView.a
  {
    private Context context;
    private boolean jal;
    boolean jam = true;
    private List<GroupToolItem> jan;
    private GroupToolsManagereUI.c jao;
    
    public e(Context paramContext, boolean paramBoolean, List<GroupToolItem> paramList, GroupToolsManagereUI.c paramc)
    {
      this.context = paramContext;
      this.jal = paramBoolean;
      this.jan = paramList;
      this.jao = paramc;
    }
    
    private static void a(GroupToolsManagereUI.d paramd, WxaAttributes paramWxaAttributes)
    {
      AppMethodBeat.i(182188);
      com.tencent.mm.ay.a.a locala = com.tencent.mm.ay.q.bml();
      Object localObject;
      if (paramWxaAttributes != null)
      {
        localObject = paramWxaAttributes.field_smallHeadURL;
        locala.a((String)localObject, paramd.jag, GroupToolsManagereUI.d.jak);
        localObject = paramd.jah;
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
      AppMethodBeat.i(193938);
      paramViewGroup = new GroupToolsManagereUI.d(LayoutInflater.from(paramViewGroup.getContext()).inflate(a.f.jdZ, paramViewGroup, false));
      AppMethodBeat.o(193938);
      return paramViewGroup;
    }
    
    public final void d(final RecyclerView.v paramv, int paramInt)
    {
      AppMethodBeat.i(193944);
      if ((this.jan != null) && (paramInt >= 0) && (paramInt < this.jan.size()))
      {
        paramv = (GroupToolsManagereUI.d)paramv;
        GroupToolItem localGroupToolItem = (GroupToolItem)this.jan.get(paramInt);
        Log.d("MicroMsg.roomtools.GroupToolsManagereUI", "onBindViewHolder() i:%s", new Object[] { Integer.valueOf(paramInt) });
        paramv.jac.setVisibility(0);
        if (this.jal)
        {
          paramv.jae.setVisibility(8);
          paramv.jaf.setVisibility(0);
          paramv.jai.setVisibility(0);
          if (!localGroupToolItem.asn()) {
            break label249;
          }
          paramv.jag.setImageResource(a.d.group_tool_aa_pay);
          paramv.jah.setText(a.i.jfh);
          label133:
          if (!this.jam) {
            break label350;
          }
          paramv.jac.setAlpha(1.0F);
        }
        for (;;)
        {
          ((ViewGroup)paramv.jad.getParent()).setTag(Boolean.valueOf(this.jal));
          paramv.jad.setTag(localGroupToolItem);
          paramv.jad.setOnClickListener(new View.OnClickListener()
          {
            public final void onClick(View paramAnonymousView)
            {
              AppMethodBeat.i(182184);
              b localb = new b();
              localb.bn(paramAnonymousView);
              com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/chatroom/ui/GroupToolsManagereUI$ToolAdapter$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.aFi());
              if (GroupToolsManagereUI.e.a(GroupToolsManagereUI.e.this) != null) {
                GroupToolsManagereUI.e.a(GroupToolsManagereUI.e.this).L(paramAnonymousView, paramv.md());
              }
              com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/chatroom/ui/GroupToolsManagereUI$ToolAdapter$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
              AppMethodBeat.o(182184);
            }
          });
          if (!this.jal) {
            break label363;
          }
          paramv.jai.setOnLongClickListener(new View.OnLongClickListener()
          {
            public final boolean onLongClick(View paramAnonymousView)
            {
              AppMethodBeat.i(182185);
              b localb = new b();
              localb.bn(paramAnonymousView);
              com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/chatroom/ui/GroupToolsManagereUI$ToolAdapter$3", "android/view/View$OnLongClickListener", "onLongClick", "(Landroid/view/View;)Z", this, localb.aFi());
              GroupToolsManagereUI.e.a(GroupToolsManagereUI.e.this).O(paramv);
              paramv.jai.performHapticFeedback(0, 2);
              com.tencent.mm.hellhoundlib.a.a.a(true, this, "com/tencent/mm/chatroom/ui/GroupToolsManagereUI$ToolAdapter$3", "android/view/View$OnLongClickListener", "onLongClick", "(Landroid/view/View;)Z");
              AppMethodBeat.o(182185);
              return true;
            }
          });
          AppMethodBeat.o(193944);
          return;
          paramv.jae.setVisibility(0);
          paramv.jaf.setVisibility(8);
          paramv.jai.setVisibility(4);
          break;
          label249:
          if (localGroupToolItem.aso())
          {
            paramv.jag.setImageDrawable(com.tencent.mm.ci.a.m(this.context, a.d.group_tool_live));
            paramv.jah.setText(a.i.app_field_live);
            break label133;
          }
          WxaAttributes localWxaAttributes = ((com.tencent.mm.plugin.appbrand.service.q)com.tencent.mm.kernel.h.ae(com.tencent.mm.plugin.appbrand.service.q.class)).aeW(localGroupToolItem.username);
          if (localWxaAttributes == null)
          {
            ((com.tencent.mm.plugin.appbrand.service.q)com.tencent.mm.kernel.h.ae(com.tencent.mm.plugin.appbrand.service.q.class)).a(localGroupToolItem.username, new q.a()
            {
              public final void b(final WxaAttributes paramAnonymousWxaAttributes)
              {
                AppMethodBeat.i(182183);
                MMHandlerThread.postToMainThread(new Runnable()
                {
                  public final void run()
                  {
                    AppMethodBeat.i(182182);
                    GroupToolsManagereUI.e.b(GroupToolsManagereUI.e.1.this.jap, paramAnonymousWxaAttributes);
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
          paramv.jac.setAlpha(0.3F);
        }
        label363:
        paramv.jai.setOnLongClickListener(null);
      }
      AppMethodBeat.o(193944);
    }
    
    public final int getItemCount()
    {
      AppMethodBeat.i(182189);
      int i = this.jan.size();
      AppMethodBeat.o(182189);
      return i;
    }
    
    public final int getItemViewType(int paramInt)
    {
      return 0;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.chatroom.ui.GroupToolsManagereUI
 * JD-Core Version:    0.7.0.1
 */