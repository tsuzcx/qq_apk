package com.tencent.mm.chatroom.ui;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.content.res.Resources;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.autogen.mmdata.rpt.bh;
import com.tencent.mm.chatroom.d.h.1;
import com.tencent.mm.chatroom.d.h.2;
import com.tencent.mm.chatroom.d.h.a;
import com.tencent.mm.chatroom.d.m;
import com.tencent.mm.chatroom.ui.preference.RoomManagerPreference;
import com.tencent.mm.kernel.c;
import com.tencent.mm.model.ab;
import com.tencent.mm.model.ar;
import com.tencent.mm.model.v;
import com.tencent.mm.model.z;
import com.tencent.mm.plugin.messenger.foundation.a.a.k.a;
import com.tencent.mm.plugin.messenger.foundation.a.e;
import com.tencent.mm.plugin.messenger.foundation.a.e.b;
import com.tencent.mm.plugin.messenger.foundation.a.e.c;
import com.tencent.mm.plugin.messenger.foundation.a.n;
import com.tencent.mm.plugin.newtips.NewTipPreference;
import com.tencent.mm.protocal.protobuf.akp;
import com.tencent.mm.protocal.protobuf.dpa;
import com.tencent.mm.protocal.protobuf.est;
import com.tencent.mm.protocal.protobuf.esu;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMHandlerThread;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.aj;
import com.tencent.mm.storage.au;
import com.tencent.mm.ui.base.aa;
import com.tencent.mm.ui.base.k;
import com.tencent.mm.ui.base.preference.CheckBoxPreference;
import com.tencent.mm.ui.base.preference.MMPreference;
import com.tencent.mm.ui.base.preference.Preference;
import com.tencent.mm.ui.base.u.g;
import com.tencent.mm.ui.base.u.i;
import com.tencent.mm.ui.widget.a.f.b;
import com.tencent.mm.ui.widget.a.g.a;
import java.util.LinkedList;

public class ManageChatroomUI
  extends MMPreference
{
  CheckBoxPreference lCA;
  RoomManagerPreference lCB;
  Preference lCC;
  NewTipPreference lCD;
  private esu lCE = null;
  private int lCF;
  private String lCG;
  private com.tencent.mm.ui.widget.a.j lCH = null;
  String lyn;
  private com.tencent.mm.ui.base.preference.f screen;
  private SharedPreferences sp = null;
  
  private est aMO()
  {
    AppMethodBeat.i(241528);
    if ((this.lCE != null) && (!Util.isNullOrNil(this.lCE.abwn)))
    {
      est localest = (est)this.lCE.abwn.getFirst();
      AppMethodBeat.o(241528);
      return localest;
    }
    AppMethodBeat.o(241528);
    return null;
  }
  
  public static Toast cY(Context paramContext)
  {
    AppMethodBeat.i(241531);
    paramContext = aa.k(paramContext, paramContext.getResources().getString(com.tencent.mm.plugin.setting.b.i.dismiss_chatroom_dialog_success), com.tencent.mm.plugin.sns.b.i.icons_filled_done);
    AppMethodBeat.o(241531);
    return paramContext;
  }
  
  public static void cZ(Context paramContext)
  {
    AppMethodBeat.i(241535);
    aa.y(paramContext, paramContext.getResources().getString(a.i.dismiss_chatroom_dialog_fail), com.tencent.mm.plugin.sns.b.i.icons_filled_error);
    AppMethodBeat.o(241535);
  }
  
  public final void S(final long paramLong1, long paramLong2)
  {
    AppMethodBeat.i(241615);
    com.tencent.threadpool.h.ahAA.bm(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(241538);
        bh localbh = new bh();
        localbh.ila = paramLong1;
        localbh.ijh = this.lCN;
        localbh.ire = ManageChatroomUI.e(ManageChatroomUI.this);
        localbh.ioS = localbh.F("roomUsername", ManageChatroomUI.c(ManageChatroomUI.this), true);
        localbh.bMH();
        Log.i("MicroMsg.ManageChatroomUI", "24180 action = " + paramLong1 + ",code = " + this.lCN + ",mMembersCount = " + ManageChatroomUI.e(ManageChatroomUI.this) + ",mRoomId = " + ManageChatroomUI.c(ManageChatroomUI.this));
        AppMethodBeat.o(241538);
      }
    });
    AppMethodBeat.o(241615);
  }
  
  public int getResourceId()
  {
    return a.k.lJV;
  }
  
  public final void hm(long paramLong)
  {
    AppMethodBeat.i(241614);
    S(paramLong, -1L);
    AppMethodBeat.o(241614);
  }
  
  public void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    AppMethodBeat.i(12662);
    super.onActivityResult(paramInt1, paramInt2, paramIntent);
    switch (paramInt1)
    {
    }
    for (;;)
    {
      AppMethodBeat.o(12662);
      return;
      if (paramIntent == null)
      {
        AppMethodBeat.o(12662);
        return;
      }
      paramInt1 = paramIntent.getIntExtra("into_room_type", -1);
      Log.i("MicroMsg.ManageChatroomUI", "[openVerify] roomId:%s, type:%s", new Object[] { this.lyn, Integer.valueOf(paramInt1) });
      paramIntent = new dpa();
      paramIntent.YFk = Util.nullAsNil(this.lyn);
      paramIntent.OzH = paramInt1;
      paramIntent = new k.a(66, paramIntent);
      ((n)com.tencent.mm.kernel.h.ax(n.class)).bzz().d(paramIntent);
      AppMethodBeat.o(12662);
      return;
      Log.i("MicroMsg.ManageChatroomUI", "[onActivityResult] requestCode:%s", new Object[] { Integer.valueOf(2) });
    }
  }
  
  public void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(12658);
    super.onCreate(paramBundle);
    Log.i("MicroMsg.ManageChatroomUI", "[onCreate]");
    this.lyn = getIntent().getStringExtra("RoomInfo_Id");
    this.lCG = getIntent().getStringExtra("room_owner_name");
    AppMethodBeat.o(12658);
  }
  
  public void onDestroy()
  {
    AppMethodBeat.i(12660);
    super.onDestroy();
    AppMethodBeat.o(12660);
  }
  
  public boolean onPreferenceTreeClick(final com.tencent.mm.ui.base.preference.f paramf, Preference paramPreference)
  {
    int i = 1;
    AppMethodBeat.i(12661);
    paramf = paramPreference.mKey;
    Log.d("MicroMsg.ManageChatroomUI", "[onPreferenceTreeClick] key:%s", new Object[] { paramf });
    if (paramf.equals("room_transfer_room_ower"))
    {
      Log.i("MicroMsg.ManageChatroomUI", "[selectNewRoomOwner] roomId:%s", new Object[] { this.lyn });
      paramf = Util.listToString(v.Il(this.lyn), ",");
      paramPreference = new Intent();
      paramPreference.putExtra("Block_list", z.bAM());
      paramPreference.putExtra("Chatroom_member_list", paramf);
      paramPreference.putExtra("from_scene", 2);
      paramPreference.putExtra("RoomInfo_Id", this.lyn);
      paramPreference.putExtra("is_show_owner", false);
      paramPreference.putExtra("title", getString(a.i.lIR));
      paramPreference.setClass(this, TransferRoomOwnerUI.class);
      paramf = new com.tencent.mm.hellhoundlib.b.a().cG(paramPreference);
      com.tencent.mm.hellhoundlib.a.a.b(this, paramf.aYi(), "com/tencent/mm/chatroom/ui/ManageChatroomUI", "enterSelectNewRoomOwnerUI", "()V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
      startActivity((Intent)paramf.sb(0));
      com.tencent.mm.hellhoundlib.a.a.c(this, "com/tencent/mm/chatroom/ui/ManageChatroomUI", "enterSelectNewRoomOwnerUI", "()V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
    }
    for (;;)
    {
      AppMethodBeat.o(12661);
      return false;
      if (paramf.equals("allow_by_identity"))
      {
        boolean bool = this.lCA.isChecked();
        paramf = aMO();
        if ((paramf != null) && (bool))
        {
          this.lCA.setChecked(false);
          paramf = new g.a(getContext()).bf(getString(a.i.lHb)).bDE(Util.safeFormatString(getString(a.i.lHa), new Object[] { paramf.IKJ })).aEX(a.i.app_i_know);
          paramf.Xdm = true;
          paramf.show();
        }
        else
        {
          com.tencent.mm.plugin.report.service.h.OAn.idkeyStat(219L, 22L, 1L, true);
          Log.i("MicroMsg.ManageChatroomUI", "[selectAllowByIdentity] roomId:%s isOpen:%s", new Object[] { this.lyn, Boolean.valueOf(bool) });
          if (au.bwF(this.lyn))
          {
            paramf = ((n)com.tencent.mm.kernel.h.ax(n.class)).bzz();
            paramPreference = Util.nullAsNil(this.lyn);
            if (bool == true) {}
            for (;;)
            {
              paramf.d(new com.tencent.mm.openim.c.s(paramPreference, i));
              this.lCA.adZV = false;
              break;
              i = 0;
            }
          }
          paramf = new dpa();
          paramf.YFk = Util.nullAsNil(this.lyn);
          if (bool == true) {}
          for (i = 2;; i = 0)
          {
            paramf.OzH = i;
            paramf = new k.a(66, paramf);
            ((n)com.tencent.mm.kernel.h.ax(n.class)).bzz().d(paramf);
            break;
          }
        }
      }
      else
      {
        if (paramf.equals("room_manager"))
        {
          Log.i("MicroMsg.ManageChatroomUI", "[selectRoomManager] roomId:%s", new Object[] { this.lyn });
          paramf = ((com.tencent.mm.plugin.chatroom.a.b)com.tencent.mm.kernel.h.ax(com.tencent.mm.plugin.chatroom.a.b.class)).bzK().Ju(this.lyn);
          paramPreference = new Intent();
          if (paramf.bvK(z.bAM())) {
            paramPreference.setClass(this, SeeRoomOwnerManagerUI.class);
          }
          for (;;)
          {
            paramPreference.putExtra("RoomInfo_Id", this.lyn);
            paramf = new com.tencent.mm.hellhoundlib.b.a().cG(paramPreference);
            com.tencent.mm.hellhoundlib.a.a.b(this, paramf.aYi(), "com/tencent/mm/chatroom/ui/ManageChatroomUI", "enterSeeRoomManagerUI", "()V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
            startActivity((Intent)paramf.sb(0));
            com.tencent.mm.hellhoundlib.a.a.c(this, "com/tencent/mm/chatroom/ui/ManageChatroomUI", "enterSeeRoomManagerUI", "()V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
            break;
            paramPreference.setClass(this, SeeRoomManagerUI.class);
          }
        }
        if (!paramf.equals("use_wework_manager_room")) {
          break label1030;
        }
        Log.i("MicroMsg.ManageChatroomUI", "[useWeworkManagerRoom] roomId:%s", new Object[] { this.lyn });
        paramf = ((com.tencent.mm.plugin.chatroom.a.b)com.tencent.mm.kernel.h.ax(com.tencent.mm.plugin.chatroom.a.b.class)).bzK().Ju(this.lyn);
        if (paramf != null) {
          break;
        }
        Log.e("MicroMsg.ManageChatroomUI", "enterUseWeworkManagerRoomUI member is null");
      }
    }
    if (paramf.field_memberCount >= v.bAH())
    {
      i = 1;
      label786:
      if (paramf.Jf(z.bAM())) {
        break label856;
      }
      Log.i("MicroMsg.ManageChatroomUI", "enterUseWeworkManagerRoomUI：no owner");
      k.a(getContext(), getString(a.i.chatroom_sys_msg_room_upgrade_to_wework_no_owner), "", getString(a.i.app_i_know), false, null);
      if (i == 0) {
        break label1331;
      }
    }
    label1030:
    label1331:
    for (i = 3;; i = 1)
    {
      ManagerRoomByWeworkUI.d(this.lyn, 1, 2, i);
      break;
      i = 0;
      break label786;
      label856:
      if (i != 0)
      {
        Log.e("MicroMsg.ManageChatroomUI", "enterUseWeworkManagerRoomUI：exceed maxnum");
        k.a(getContext(), getString(a.i.chatroom_sys_msg_room_upgrade_to_wework_exceed_max_num), "", getString(a.i.app_i_know), false, null);
        ManagerRoomByWeworkUI.d(this.lyn, 1, 2, 2);
        break;
      }
      com.tencent.mm.plugin.newtips.a.gtf().aeI(27);
      paramf = new Intent();
      paramf.setClass(this, ManagerRoomByWeworkUI.class);
      paramf.putExtra("RoomInfo_Id", this.lyn);
      paramf.putExtra("upgrade_openim_room_from_scene", 1);
      paramf = new com.tencent.mm.hellhoundlib.b.a().cG(paramf);
      com.tencent.mm.hellhoundlib.a.a.b(this, paramf.aYi(), "com/tencent/mm/chatroom/ui/ManageChatroomUI", "enterUseWeworkManagerRoomUI", "()V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
      startActivity((Intent)paramf.sb(0));
      com.tencent.mm.hellhoundlib.a.a.c(this, "com/tencent/mm/chatroom/ui/ManageChatroomUI", "enterUseWeworkManagerRoomUI", "()V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
      break;
      if (paramf.equals("room_bind_app_info"))
      {
        paramf = aMO();
        if ((paramf == null) || ((this.lCH != null) && (this.lCH.isShowing()))) {
          break;
        }
        this.lCH = new com.tencent.mm.ui.widget.a.j(getContext(), 0, 3);
        paramPreference = LayoutInflater.from(getContext()).inflate(a.f.lGm, null, false);
        Object localObject = (ImageView)paramPreference.findViewById(a.e.lEV);
        com.tencent.mm.modelimage.loader.a.bKl().loadImage(paramf.YDL, (ImageView)localObject);
        ((TextView)paramPreference.findViewById(a.e.lFI)).setText(paramf.IKJ);
        ((TextView)paramPreference.findViewById(a.e.lFK)).setText(Util.safeFormatString(getString(a.i.lGY), new Object[] { paramf.IKJ }));
        localObject = (TextView)paramPreference.findViewById(a.e.lFO);
        ((TextView)localObject).setText(Util.safeFormatString(getString(a.i.lHd), new Object[] { paramf.IKJ }));
        ((TextView)localObject).setOnClickListener(new View.OnClickListener()
        {
          public final void onClick(View paramAnonymousView)
          {
            AppMethodBeat.i(241524);
            com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
            localb.cH(paramAnonymousView);
            com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/chatroom/ui/ManageChatroomUI$4", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.aYj());
            ManageChatroomUI.b(ManageChatroomUI.this).cyW();
            ManageChatroomUI.a(ManageChatroomUI.this, paramf);
            com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/chatroom/ui/ManageChatroomUI$4", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
            AppMethodBeat.o(241524);
          }
        });
        this.lCH.setCustomView(paramPreference);
        this.lCH.dDn();
        break;
      }
      if (!paramf.equals("dismiss_chatroom_quit")) {
        break;
      }
      hm(1L);
      paramf = new com.tencent.mm.ui.widget.a.f(this, 1, true);
      paramf.Vtg = new u.g()
      {
        public final void onCreateMMMenu(com.tencent.mm.ui.base.s paramAnonymouss)
        {
          AppMethodBeat.i(241769);
          paramAnonymouss.a(0, ManageChatroomUI.this.getResources().getColor(a.b.red_text_color_selector), ManageChatroomUI.this.getString(a.i.dismiss_chatroom_dialog_ok));
          AppMethodBeat.o(241769);
        }
      };
      paramf.h(getString(a.i.dismiss_chatroom_dialog_title), 17, com.tencent.mm.cd.a.fromDPToPix(this, 14));
      paramf.GAC = new u.i()
      {
        public final void onMMMenuItemSelected(MenuItem paramAnonymousMenuItem, int paramAnonymousInt)
        {
          AppMethodBeat.i(241548);
          switch (paramAnonymousInt)
          {
          default: 
            ManageChatroomUI.this.hm(2L);
            AppMethodBeat.o(241548);
            return;
          }
          ManageChatroomUI.this.hm(3L);
          Object localObject = ManageChatroomUI.this;
          ManageChatroomUI localManageChatroomUI = ManageChatroomUI.this;
          ManageChatroomUI.a local1 = new ManageChatroomUI.a()
          {
            public final void qA(int paramAnonymous2Int)
            {
              AppMethodBeat.i(241775);
              Object localObject = ((com.tencent.mm.plugin.chatroom.a.b)com.tencent.mm.kernel.h.ax(com.tencent.mm.plugin.chatroom.a.b.class)).bzK().Ju(ManageChatroomUI.c(ManageChatroomUI.this));
              int i = (int)(((aj)localObject).field_chatroomStatus | 0x2);
              Log.i("MicroMsg.ManageChatroomUI", "dealDelChatroomBtn, state = ".concat(String.valueOf(i)));
              ((aj)localObject).field_chatroomStatus = i;
              v.a((aj)localObject);
              localObject = new Intent();
              ((Intent)localObject).putExtra("dismiss_chatroom", true);
              ManageChatroomUI.this.setResult(-1, (Intent)localObject);
              ManageChatroomUI.this.S(4L, paramAnonymous2Int);
              ManageChatroomUI.this.finish();
              AppMethodBeat.o(241775);
            }
            
            public final void qB(int paramAnonymous2Int)
            {
              AppMethodBeat.i(241777);
              ManageChatroomUI.this.S(4L, paramAnonymous2Int);
              AppMethodBeat.o(241777);
            }
          };
          paramAnonymousMenuItem = ((ManageChatroomUI)localObject).lyn;
          localObject = new com.tencent.mm.chatroom.d.h(localManageChatroomUI, new ManageChatroomUI.4((ManageChatroomUI)localObject, localManageChatroomUI, local1));
          ((com.tencent.mm.chatroom.d.h)localObject).hks = true;
          if (((com.tencent.mm.chatroom.d.h)localObject).hks)
          {
            ((com.tencent.mm.chatroom.d.h)localObject).hku = new h.2((com.tencent.mm.chatroom.d.h)localObject);
            MMHandlerThread.postToMainThreadDelayed(((com.tencent.mm.chatroom.d.h)localObject).hku, 200L);
          }
          ((com.tencent.mm.chatroom.d.h)localObject).hkt = new h.1((com.tencent.mm.chatroom.d.h)localObject);
          MMHandlerThread.postToMainThreadDelayed(((com.tencent.mm.chatroom.d.h)localObject).hkt, 60000L);
          com.tencent.mm.kernel.h.baD().mCm.a(6217, (com.tencent.mm.am.h)localObject);
          paramAnonymousMenuItem = new m(paramAnonymousMenuItem);
          com.tencent.mm.kernel.h.baD().mCm.a(paramAnonymousMenuItem, 0);
          AppMethodBeat.o(241548);
        }
      };
      paramf.aeLi = new f.b()
      {
        public final void onDismiss()
        {
          AppMethodBeat.i(241544);
          ManageChatroomUI.this.hm(2L);
          AppMethodBeat.o(241544);
        }
      };
      paramf.dDn();
      break;
    }
  }
  
  public void onResume()
  {
    AppMethodBeat.i(12659);
    Object localObject1 = ((com.tencent.mm.plugin.chatroom.a.b)com.tencent.mm.kernel.h.ax(com.tencent.mm.plugin.chatroom.a.b.class)).bzK().Ju(this.lyn);
    if (localObject1 != null)
    {
      if (this.sp == null)
      {
        this.sp = getSharedPreferences(getPackageName() + "_preferences", 0);
        localObject2 = this.sp.edit();
        if (((aj)localObject1).iZl() == 2)
        {
          bool = true;
          ((SharedPreferences.Editor)localObject2).putBoolean("allow_by_identity", bool).commit();
        }
      }
      else
      {
        this.lCF = ((aj)localObject1).field_memberCount;
      }
    }
    else
    {
      super.onResume();
      this.screen = getPreferenceScreen();
      if (this.screen != null)
      {
        setMMTitle(a.i.lHE);
        this.lCA = ((CheckBoxPreference)this.screen.bAi("allow_by_identity"));
        this.lCB = ((RoomManagerPreference)this.screen.bAi("room_manager"));
        this.lCC = this.screen.bAi("room_bind_app_info");
        if ((!ab.II(this.lyn)) || ((z.bBN() & 0x10) != 0))
        {
          localObject1 = this.screen;
          if (((com.tencent.mm.plugin.chatroom.a.b)com.tencent.mm.kernel.h.ax(com.tencent.mm.plugin.chatroom.a.b.class)).alP(this.lyn)) {
            break label667;
          }
          bool = true;
          label243:
          ((com.tencent.mm.ui.base.preference.f)localObject1).eh("room_manager", bool);
        }
        this.screen.eh("select_enable_qrcode", true);
        this.screen.eh("select_into_room_type", true);
        this.screen.eh("use_wework_manager_room", true);
        this.screen.eh("room_bind_app_info", true);
        bool = z.bAM().equals(this.lCG);
        if (!bool)
        {
          this.screen.eh("room_transfer_room_ower", true);
          this.screen.bAk("dismiss_chatroom_quit");
        }
        if (bool) {
          com.tencent.mm.cp.g.ha(this.lyn).h(new com.tencent.mm.vending.c.a() {}).b(new com.tencent.mm.vending.c.a() {});
        }
        localObject1 = ((com.tencent.mm.plugin.chatroom.a.b)com.tencent.mm.kernel.h.ax(com.tencent.mm.plugin.chatroom.a.b.class)).bzK().Ju(this.lyn);
        if (localObject1 != null)
        {
          if (!au.bwF(this.lyn)) {
            break label682;
          }
          if (((aj)localObject1).iZl() != 1) {
            break label672;
          }
          bool = true;
          label433:
          Log.i("MicroMsg.ManageChatroomUI", "isChecked = %s", new Object[] { Boolean.valueOf(bool) });
          localObject2 = this.lCA;
          if ((((aj)localObject1).iZl() & 0x1) != 1) {
            break label677;
          }
        }
      }
    }
    label667:
    label672:
    label677:
    for (boolean bool = true;; bool = false)
    {
      ((CheckBoxPreference)localObject2).setChecked(bool);
      Log.d("MicroMsg.ManageChatroomUI", "mRoomId:%s chatroomstatus:%s", new Object[] { Util.nullAs(this.lyn, "null"), Integer.valueOf(((aj)localObject1).field_chatroomStatus) });
      if ((!au.bwF(this.lyn)) && (v.bAI()) && ((((aj)localObject1).field_chatroomStatus & 0x20000) != 131072L) && ((((aj)localObject1).field_chatroomStatus & 0x10000) == 65536L) && (v.bAG()))
      {
        this.screen.eh("use_wework_manager_room", false);
        this.lCD = ((NewTipPreference)this.screen.bAi("use_wework_manager_room"));
        this.lCD.a(this.screen);
        com.tencent.mm.plugin.newtips.a.gtf().h(this.lCD);
        com.tencent.mm.plugin.newtips.a.g.a(this.lCD);
      }
      this.lCA.adZV = false;
      setBackBtn(new MenuItem.OnMenuItemClickListener()
      {
        public final boolean onMenuItemClick(MenuItem paramAnonymousMenuItem)
        {
          AppMethodBeat.i(241526);
          ManageChatroomUI.this.finish();
          AppMethodBeat.o(241526);
          return true;
        }
      });
      this.screen.notifyDataSetChanged();
      AppMethodBeat.o(12659);
      return;
      bool = false;
      break;
      bool = false;
      break label243;
      bool = false;
      break label433;
    }
    label682:
    Object localObject2 = this.lCA;
    if (((aj)localObject1).iZl() == 2) {}
    for (bool = true;; bool = false)
    {
      ((CheckBoxPreference)localObject2).setChecked(bool);
      break;
    }
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
  
  public static abstract interface a
  {
    public abstract void qA(int paramInt);
    
    public abstract void qB(int paramInt);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.chatroom.ui.ManageChatroomUI
 * JD-Core Version:    0.7.0.1
 */