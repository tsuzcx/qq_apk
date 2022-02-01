package com.tencent.mm.chatroom.ui;

import android.app.Activity;
import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.RecyclerView.a;
import android.support.v7.widget.RecyclerView.b;
import android.support.v7.widget.RecyclerView.v;
import android.support.v7.widget.a.a;
import android.support.v7.widget.a.a.a;
import android.view.KeyEvent;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.LinearLayout;
import android.widget.Toast;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.al.n;
import com.tencent.mm.al.q;
import com.tencent.mm.chatroom.d.ab;
import com.tencent.mm.chatroom.plugin.PluginChatroomUI;
import com.tencent.mm.chatroom.storage.GroupToolItem;
import com.tencent.mm.chatroom.storage.c;
import com.tencent.mm.chatroom.storage.d;
import com.tencent.mm.model.ce;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.ui.base.p;
import com.tencent.mm.ui.base.t;
import com.tencent.mm.ui.r.b;
import java.util.Iterator;
import java.util.LinkedList;

public class GroupToolsManagereUI
  extends MMActivity
  implements com.tencent.mm.al.g
{
  private LinkedList<GroupToolItem> fpN;
  private a frA;
  private GroupToolsManagereUI.f frB;
  private LinearLayoutManager frC;
  private GroupToolsManagereUI.e frD;
  private c frE;
  private String frF;
  private boolean frG;
  private int frH;
  private GroupToolsManagereUI.c frI;
  private LinearLayout fru;
  private RecyclerView frv;
  private LinearLayout frw;
  private RecyclerView frx;
  private LinearLayoutManager fry;
  private GroupToolsManagereUI.e frz;
  private p tipDialog;
  
  public GroupToolsManagereUI()
  {
    AppMethodBeat.i(182194);
    this.tipDialog = null;
    this.frE = null;
    this.fpN = new LinkedList();
    this.frG = false;
    this.frH = 0;
    this.frI = new GroupToolsManagereUI.c()
    {
      public final void M(RecyclerView.v paramAnonymousv)
      {
        AppMethodBeat.i(182168);
        a locala = GroupToolsManagereUI.h(GroupToolsManagereUI.this);
        if ((locala.axG.c(locala.akA, paramAnonymousv)) && (paramAnonymousv.arI.getParent() == locala.akA))
        {
          locala.mK();
          locala.axD = 0.0F;
          locala.axC = 0.0F;
          locala.e(paramAnonymousv, 2);
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
            paramAnonymousView.fpL = ce.asR();
            GroupToolsManagereUI.a(GroupToolsManagereUI.this).fpM.remove(paramAnonymousView);
            GroupToolsManagereUI.b(GroupToolsManagereUI.this).addFirst(paramAnonymousView);
            GroupToolsManagereUI.c(GroupToolsManagereUI.this).cm(paramAnonymousInt);
            GroupToolsManagereUI.d(GroupToolsManagereUI.this).cl(0);
            if ((!bool) || (GroupToolsManagereUI.a(GroupToolsManagereUI.this).Vb())) {
              break label302;
            }
            GroupToolsManagereUI.d(GroupToolsManagereUI.this).frX = true;
            GroupToolsManagereUI.d(GroupToolsManagereUI.this).aql.notifyChanged();
          }
          for (;;)
          {
            GroupToolsManagereUI.e(GroupToolsManagereUI.this);
            GroupToolsManagereUI.f(GroupToolsManagereUI.this);
            GroupToolsManagereUI.g(GroupToolsManagereUI.this);
            AppMethodBeat.o(184789);
            return;
            if (GroupToolsManagereUI.a(GroupToolsManagereUI.this).Vb())
            {
              h.a(GroupToolsManagereUI.this, GroupToolsManagereUI.this.getString(2131757071), "", GroupToolsManagereUI.this.getString(2131755792), false, null);
              AppMethodBeat.o(184789);
              return;
            }
            GroupToolsManagereUI.a(GroupToolsManagereUI.this).fpM.addLast(paramAnonymousView);
            GroupToolsManagereUI.b(GroupToolsManagereUI.this).remove(paramAnonymousView);
            GroupToolsManagereUI.c(GroupToolsManagereUI.this).cl(GroupToolsManagereUI.a(GroupToolsManagereUI.this).fpM.size() - 1);
            GroupToolsManagereUI.d(GroupToolsManagereUI.this).cm(paramAnonymousInt);
            break;
            label302:
            if ((!bool) && (GroupToolsManagereUI.a(GroupToolsManagereUI.this).Vb()))
            {
              GroupToolsManagereUI.d(GroupToolsManagereUI.this).frX = false;
              GroupToolsManagereUI.d(GroupToolsManagereUI.this).aql.notifyChanged();
            }
          }
        }
        ad.i("MicroMsg.roomtools.GroupToolsManagereUI", "iRecentUseToolsCallback click");
        AppMethodBeat.o(184789);
      }
    };
    AppMethodBeat.o(182194);
  }
  
  private boolean Vv()
  {
    AppMethodBeat.i(182200);
    if (this.frG) {
      h.a(this, getString(2131757062), "", getString(2131757064), getString(2131757063), false, new DialogInterface.OnClickListener()new DialogInterface.OnClickListener
      {
        public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
        {
          AppMethodBeat.i(182171);
          ad.i("MicroMsg.roomtools.GroupToolsManagereUI", "back_dialot ok");
          ab.b(GroupToolsManagereUI.j(GroupToolsManagereUI.this), 2, GroupToolsManagereUI.k(GroupToolsManagereUI.this), GroupToolsManagereUI.a(GroupToolsManagereUI.this).fpM.size());
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
      ab.b(this.frF, 1, this.frH, this.frE.fpM.size());
      finish();
    }
  }
  
  private void Vw()
  {
    AppMethodBeat.i(182201);
    if (this.frG)
    {
      enableOptionMenu(0, true);
      AppMethodBeat.o(182201);
      return;
    }
    enableOptionMenu(0, false);
    AppMethodBeat.o(182201);
  }
  
  private void Vx()
  {
    AppMethodBeat.i(182202);
    if (this.frE.fpM.size() > 0) {
      this.fru.setVisibility(0);
    }
    while (this.fpN.size() > 0)
    {
      this.frw.setVisibility(0);
      AppMethodBeat.o(182202);
      return;
      this.fru.setVisibility(8);
    }
    this.frw.setVisibility(8);
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
        paramAnonymousMenuItem.field_stickToollist = c.X(paramAnonymousMenuItem.fpM);
        GroupToolsManagereUI.l(GroupToolsManagereUI.this);
        AppMethodBeat.o(182173);
        return true;
      }
    }, null, r.b.FOB);
    Vw();
    this.fru = ((LinearLayout)findViewById(2131302146));
    this.frv = ((RecyclerView)findViewById(2131302147));
    this.frw = ((LinearLayout)findViewById(2131302144));
    this.frx = ((RecyclerView)findViewById(2131302145));
    this.frB = new GroupToolsManagereUI.f(getContext());
    this.fry = new LinearLayoutManager();
    this.frv.setLayoutManager(this.fry);
    this.frv.a(this.frB);
    this.frz = new GroupToolsManagereUI.e(getContext(), true, this.frE.fpM, this.frI);
    this.frv.setAdapter(this.frz);
    this.frz.aql.notifyChanged();
    this.frC = new LinearLayoutManager();
    this.frx.setLayoutManager(this.frC);
    this.frx.a(this.frB);
    this.frD = new GroupToolsManagereUI.e(getContext(), false, this.fpN, this.frI);
    this.frx.setAdapter(this.frD);
    this.frD.aql.notifyChanged();
    Vx();
    this.frA = new a(new GroupToolsManagereUI.a(this.frE.fpM, new b()
    {
      public final void Vy()
      {
        AppMethodBeat.i(182170);
        GroupToolsManagereUI.e(GroupToolsManagereUI.this);
        GroupToolsManagereUI.f(GroupToolsManagereUI.this);
        AppMethodBeat.o(182170);
      }
    }));
    this.frA.j(this.frv);
    AppMethodBeat.o(182197);
  }
  
  public void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(182195);
    super.onCreate(paramBundle);
    getWindow().setSoftInputMode(32);
    this.frF = getIntent().getStringExtra("key_chatroomname");
    if (bt.isNullOrNil(this.frF))
    {
      ad.e("MicroMsg.roomtools.GroupToolsManagereUI", "mChatRoomName is null");
      finish();
    }
    for (;;)
    {
      initView();
      com.tencent.mm.kernel.g.aeS().a(3546, this);
      AppMethodBeat.o(182195);
      return;
      this.frE = ((PluginChatroomUI)com.tencent.mm.kernel.g.ad(PluginChatroomUI.class)).getGroupToolsStorage().oQ(this.frF);
      if (this.frE == null)
      {
        ad.e("MicroMsg.roomtools.GroupToolsManagereUI", "tools is null");
        finish();
      }
      else
      {
        paramBundle = getIntent().getParcelableArrayListExtra("key_recent_use_tools");
        if (paramBundle == null) {
          this.fpN = new LinkedList();
        }
        for (;;)
        {
          paramBundle = this.frE.fpM.iterator();
          while (paramBundle.hasNext())
          {
            GroupToolItem localGroupToolItem = (GroupToolItem)paramBundle.next();
            if (this.fpN.contains(localGroupToolItem)) {
              this.fpN.remove(localGroupToolItem);
            }
          }
          this.fpN.addAll(paramBundle);
        }
        this.frH = this.frE.fpM.size();
        ad.i("MicroMsg.roomtools.GroupToolsManagereUI", "mChatRoomName is %s, recentUseToolItemList:%s", new Object[] { this.frF, Integer.valueOf(this.fpN.size()) });
      }
    }
  }
  
  public void onDestroy()
  {
    AppMethodBeat.i(182199);
    com.tencent.mm.kernel.g.aeS().b(3546, this);
    super.onDestroy();
    AppMethodBeat.o(182199);
  }
  
  public boolean onKeyUp(int paramInt, KeyEvent paramKeyEvent)
  {
    AppMethodBeat.i(182198);
    if (paramInt == 4)
    {
      Vv();
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
    ad.i("MicroMsg.roomtools.GroupToolsManagereUI", "onSceneEnd errType = %d, errCode = %d, errMsg = %s, scenetype:%s", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), paramString, Integer.valueOf(paramn.getType()) });
    if ((this.tipDialog != null) && (this.tipDialog.isShowing())) {
      this.tipDialog.dismiss();
    }
    if ((paramInt1 == 0) && (paramInt2 == 0))
    {
      ad.i("MicroMsg.roomtools.GroupToolsManagereUI", "onSceneEnd result:%s", new Object[] { Boolean.valueOf(((PluginChatroomUI)com.tencent.mm.kernel.g.ad(PluginChatroomUI.class)).getGroupToolsStorage().a(this.frE, new String[0])) });
      ab.b(this.frF, 3, this.frH, this.frE.fpM.size());
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
    public abstract void Vy();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.chatroom.ui.GroupToolsManagereUI
 * JD-Core Version:    0.7.0.1
 */