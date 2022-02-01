package com.tencent.mm.chatroom.ui;

import android.app.Activity;
import android.app.ProgressDialog;
import android.content.ComponentName;
import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.os.Bundle;
import android.os.Looper;
import android.os.Message;
import android.text.SpannableStringBuilder;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.Window;
import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;
import android.widget.AbsListView;
import android.widget.AbsListView.OnScrollListener;
import android.widget.LinearLayout;
import android.widget.ListView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.chatroom.ui.preference.RoomCardPreference;
import com.tencent.mm.g.a.ie;
import com.tencent.mm.g.a.lx;
import com.tencent.mm.g.a.lx.b;
import com.tencent.mm.g.a.sk;
import com.tencent.mm.g.a.vj;
import com.tencent.mm.g.a.vj.b;
import com.tencent.mm.g.a.wi;
import com.tencent.mm.g.c.au;
import com.tencent.mm.model.ar.a;
import com.tencent.mm.model.ar.b;
import com.tencent.mm.model.ar.b.a;
import com.tencent.mm.model.bi;
import com.tencent.mm.model.bi.a;
import com.tencent.mm.plugin.newtips.NewTipPreference;
import com.tencent.mm.plugin.report.kvdata.IMBehavior;
import com.tencent.mm.plugin.report.kvdata.IMBehaviorChattingOP;
import com.tencent.mm.plugin.report.kvdata.log_13835;
import com.tencent.mm.pluginsdk.ui.applet.ContactListExpandPreference;
import com.tencent.mm.pluginsdk.ui.applet.ContactListExpandPreference.a;
import com.tencent.mm.pluginsdk.ui.applet.r;
import com.tencent.mm.pluginsdk.ui.applet.s.b;
import com.tencent.mm.protocal.protobuf.blh;
import com.tencent.mm.sdk.e.k.a;
import com.tencent.mm.sdk.e.n.b;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.ap;
import com.tencent.mm.sdk.platformtools.aq;
import com.tencent.mm.sdk.platformtools.av;
import com.tencent.mm.sdk.platformtools.av.a;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.storage.ab;
import com.tencent.mm.storage.af;
import com.tencent.mm.storage.bh;
import com.tencent.mm.storage.bw;
import com.tencent.mm.ui.base.h.c;
import com.tencent.mm.ui.base.preference.CheckBoxPreference;
import com.tencent.mm.ui.base.preference.KeyValuePreference;
import com.tencent.mm.ui.base.preference.MMPreference;
import com.tencent.mm.ui.base.preference.NormalIconPreference;
import com.tencent.mm.ui.base.preference.Preference;
import com.tencent.mm.ui.base.preference.PreferenceCategory;
import com.tencent.mm.ui.base.preference.f;
import com.tencent.mm.ui.widget.a.f.a;
import com.tencent.mm.ui.widget.a.f.c;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import junit.framework.Assert;

@com.tencent.mm.kernel.i
public class ChatroomInfoUI
  extends MMPreference
  implements com.tencent.mm.al.g, com.tencent.mm.bi.a, k.a, n.b
{
  private static boolean fqy = false;
  private af contact;
  private boolean dph;
  private ProgressDialog fpP;
  private boolean fpQ;
  private RoomCardPreference fpR;
  private Preference fpS;
  private Preference fpT;
  private NormalIconPreference fpU;
  private NormalIconPreference fpV;
  private ContactListExpandPreference fpW;
  private CheckBoxPreference fpX;
  private CheckBoxPreference fpY;
  private CheckBoxPreference fpZ;
  private com.tencent.mm.pluginsdk.c.b fqA;
  private av fqB;
  private int fqC;
  private KeyValuePreference fqa;
  private KeyValuePreference fqb;
  private CheckBoxPreference fqc;
  private NewTipPreference fqd;
  private boolean fqe;
  private boolean fqf;
  private boolean fqg;
  private boolean fqh;
  private int fqi;
  private boolean fqj;
  private boolean fqk;
  private com.tencent.mm.storage.w fql;
  private int fqm;
  private boolean fqn;
  private boolean fqo;
  private boolean fqp;
  private boolean fqq;
  private boolean fqr;
  private com.tencent.mm.pluginsdk.ui.d fqs;
  boolean fqt;
  private com.tencent.mm.sdk.b.c fqu;
  int fqv;
  private com.tencent.mm.ui.base.p fqw;
  private String fqx;
  private String fqz;
  private ap handler;
  private boolean isDeleteCancel;
  private String roomId;
  private f screen;
  private SharedPreferences sp;
  
  public ChatroomInfoUI()
  {
    AppMethodBeat.i(12561);
    this.fpP = null;
    this.handler = new ap(Looper.getMainLooper())
    {
      public final void handleMessage(Message paramAnonymousMessage)
      {
        AppMethodBeat.i(12507);
        ChatroomInfoUI.a(ChatroomInfoUI.this);
        AppMethodBeat.o(12507);
      }
    };
    this.sp = null;
    this.fqg = false;
    this.fqh = false;
    this.fqk = false;
    this.fql = null;
    this.fqm = -1;
    this.fqn = true;
    this.fqo = false;
    this.fqp = false;
    this.fqq = false;
    this.fqr = false;
    this.fqs = new com.tencent.mm.pluginsdk.ui.d(new AbsListView.OnScrollListener()
    {
      public final void onScroll(AbsListView paramAnonymousAbsListView, int paramAnonymousInt1, int paramAnonymousInt2, int paramAnonymousInt3) {}
      
      public final void onScrollStateChanged(AbsListView paramAnonymousAbsListView, int paramAnonymousInt) {}
    });
    this.fqt = false;
    this.fqu = new com.tencent.mm.sdk.b.c() {};
    this.fqv = -1;
    this.fqw = null;
    this.fqx = "";
    this.fqz = null;
    this.fqA = new com.tencent.mm.pluginsdk.c.b()
    {
      public final void a(int paramAnonymousInt1, int paramAnonymousInt2, String paramAnonymousString, com.tencent.mm.sdk.b.b paramAnonymousb)
      {
        AppMethodBeat.i(196596);
        if ((paramAnonymousb instanceof lx))
        {
          paramAnonymousb = (lx)paramAnonymousb;
          ad.i("MicroMsg.ChatroomInfoUI", "onSceneEnd: errType = " + paramAnonymousInt1 + " errCode = " + paramAnonymousInt2 + " errMsg = " + paramAnonymousString);
          if (ChatroomInfoUI.v(ChatroomInfoUI.this) != null) {
            ChatroomInfoUI.v(ChatroomInfoUI.this).dismiss();
          }
          if ((paramAnonymousInt1 != 0) || (paramAnonymousInt2 != 0))
          {
            if (paramAnonymousInt2 == -21)
            {
              com.tencent.mm.ui.base.h.d(ChatroomInfoUI.this, ChatroomInfoUI.this.getString(2131762626), ChatroomInfoUI.this.getString(2131755906), new DialogInterface.OnClickListener()
              {
                public final void onClick(DialogInterface paramAnonymous2DialogInterface, int paramAnonymous2Int)
                {
                  AppMethodBeat.i(196595);
                  ChatroomInfoUI.this.finish();
                  AppMethodBeat.o(196595);
                }
              });
              AppMethodBeat.o(196596);
              return;
            }
            com.tencent.mm.ui.base.h.c(ChatroomInfoUI.this, ChatroomInfoUI.this.getString(2131762628), ChatroomInfoUI.this.getString(2131755906), true);
            AppMethodBeat.o(196596);
            return;
          }
          if ((paramAnonymousInt1 == 0) && (paramAnonymousInt2 == 0) && (ChatroomInfoUI.m(ChatroomInfoUI.this) != null))
          {
            paramAnonymousString = ChatroomInfoUI.Y(paramAnonymousb.dqZ.dqL);
            paramAnonymousb = ChatroomInfoUI.m(ChatroomInfoUI.this);
            if (paramAnonymousb.BZr != null)
            {
              paramAnonymousb = paramAnonymousb.BZr.BYH;
              paramAnonymousb.aF(paramAnonymousString);
              paramAnonymousb.VL();
            }
            if (ChatroomInfoUI.f(ChatroomInfoUI.this) != null) {
              ChatroomInfoUI.f(ChatroomInfoUI.this).notifyDataSetChanged();
            }
            ChatroomInfoUI.this.setMMTitle(ChatroomInfoUI.this.getResources().getQuantityString(2131623963, paramAnonymousString.size(), new Object[] { Integer.valueOf(paramAnonymousString.size()) }));
          }
          ChatroomInfoUI.j(ChatroomInfoUI.this);
        }
        AppMethodBeat.o(196596);
      }
    };
    this.isDeleteCancel = false;
    this.fqB = null;
    this.fqC = 0;
    AppMethodBeat.o(12561);
  }
  
  private void Vd()
  {
    AppMethodBeat.i(12563);
    ad.i("MicroMsg.ChatroomInfoUI", "[doChatroomDetailCgi] :%s", new Object[] { this.roomId });
    com.tencent.mm.roomsdk.a.c.a locala = com.tencent.mm.roomsdk.a.b.aEI(this.roomId).oL(this.roomId);
    locala.b(new com.tencent.mm.roomsdk.a.b.b() {});
    locala.eDp();
    AppMethodBeat.o(12563);
  }
  
  private void Ve()
  {
    AppMethodBeat.i(12573);
    com.tencent.mm.plugin.report.service.h.vKh.idkeyStat(219L, 7L, 1L, true);
    Object localObject = com.tencent.mm.model.q.rW(this.roomId);
    String str = bt.n((List)localObject, ",");
    if (localObject != null) {
      this.fqi = ((List)localObject).size();
    }
    localObject = new Intent();
    ((Intent)localObject).putExtra("titile", getString(2131755234));
    ((Intent)localObject).putExtra("list_type", 1);
    ((Intent)localObject).putExtra("list_attr", kH(com.tencent.mm.ui.contact.u.GWC));
    ((Intent)localObject).putExtra("always_select_contact", str);
    ((Intent)localObject).putExtra("scene", 3);
    boolean bool = com.tencent.mm.model.w.sp(this.contact.field_username);
    if ((!af.aHI(this.contact.field_username)) && (!bool)) {
      ((Intent)localObject).putExtra("without_openim", true);
    }
    if ((com.tencent.mm.model.w.sm(this.roomId)) && (!bool)) {}
    for (bool = true;; bool = false)
    {
      ((Intent)localObject).putExtra("KBlockOpenImFav", bool);
      ((Intent)localObject).putExtra("create_group_recommend", true);
      com.tencent.mm.bs.d.c(this, ".ui.contact.SelectContactUI", (Intent)localObject, 1);
      AppMethodBeat.o(12573);
      return;
    }
  }
  
  private void Vf()
  {
    AppMethodBeat.i(12574);
    if (this.dph)
    {
      Ve();
      AppMethodBeat.o(12574);
      return;
    }
    Vo();
    AppMethodBeat.o(12574);
  }
  
  private void Vg()
  {
    AppMethodBeat.i(12576);
    com.tencent.mm.plugin.report.service.h.vKh.idkeyStat(219L, 8L, 1L, true);
    Object localObject = com.tencent.mm.model.q.rW(this.roomId);
    String str = bt.n((List)localObject, ",");
    this.fqi = ((List)localObject).size();
    localObject = new Intent();
    ((Intent)localObject).putExtra("RoomInfo_Id", this.roomId);
    ((Intent)localObject).putExtra("Is_Chatroom", true);
    ((Intent)localObject).putExtra("Chatroom_member_list", str);
    ((Intent)localObject).putExtra("room_member_count", this.fqi);
    ((Intent)localObject).putExtra("Is_RoomOwner", this.fqg);
    ((Intent)localObject).putExtra("list_attr", com.tencent.mm.ui.contact.u.GWC);
    ((Intent)localObject).putExtra("room_name", this.contact.field_username);
    ((Intent)localObject).putExtra("room_owner_name", this.fql.field_roomowner);
    ((Intent)localObject).setClass(this, SelectDelMemberUI.class);
    startActivityForResult((Intent)localObject, 7);
    AppMethodBeat.o(12576);
  }
  
  private String Vh()
  {
    AppMethodBeat.i(12579);
    af localaf = ((com.tencent.mm.plugin.messenger.foundation.a.k)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.messenger.foundation.a.k.class)).apM().aHY(this.fql.field_roomowner);
    if ((localaf != null) && ((int)localaf.fId > 0)) {}
    for (Object localObject2 = localaf.field_conRemark;; localObject2 = null)
    {
      Object localObject1 = localObject2;
      if (bt.isNullOrNil((String)localObject2)) {
        localObject1 = oS(this.fql.field_roomowner);
      }
      localObject2 = localObject1;
      if (bt.isNullOrNil((String)localObject1))
      {
        localObject2 = localObject1;
        if (localaf != null)
        {
          localObject2 = localObject1;
          if ((int)localaf.fId > 0) {
            localObject2 = localaf.ZW();
          }
        }
      }
      localObject1 = localObject2;
      if (bt.isNullOrNil((String)localObject2)) {
        localObject1 = this.fql.field_roomowner;
      }
      AppMethodBeat.o(12579);
      return localObject1;
    }
  }
  
  private static boolean Vi()
  {
    AppMethodBeat.i(12580);
    if (bt.getInt(com.tencent.mm.m.g.Zd().getValue("ChatroomGlobalSwitch"), 1) == 1)
    {
      AppMethodBeat.o(12580);
      return true;
    }
    AppMethodBeat.o(12580);
    return false;
  }
  
  private void Vj()
  {
    AppMethodBeat.i(12584);
    if (this.fpW != null)
    {
      if (this.dph)
      {
        com.tencent.mm.kernel.g.afE().ax(new Runnable()
        {
          public final void run()
          {
            AppMethodBeat.i(196594);
            if (ChatroomInfoUI.c(ChatroomInfoUI.this) == null)
            {
              ad.w("MicroMsg.ChatroomInfoUI", "[updateRoomPref] member == null");
              AppMethodBeat.o(196594);
              return;
            }
            ChatroomInfoUI.a(ChatroomInfoUI.this, ((com.tencent.mm.plugin.chatroom.a.c)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.chatroom.a.c.class)).apV().tK(ChatroomInfoUI.b(ChatroomInfoUI.this)));
            Object localObject1 = com.tencent.mm.model.q.rW(ChatroomInfoUI.b(ChatroomInfoUI.this));
            if (localObject1 != null) {
              ChatroomInfoUI.a(ChatroomInfoUI.this, ((List)localObject1).size());
            }
            Object localObject3;
            for (;;)
            {
              localObject3 = new LinkedList();
              localObject2 = ((List)localObject1).iterator();
              while (((Iterator)localObject2).hasNext())
              {
                String str = (String)((Iterator)localObject2).next();
                if ((ChatroomInfoUI.c(ChatroomInfoUI.this).aHz(str)) || (ChatroomInfoUI.c(ChatroomInfoUI.this).ty(str))) {
                  ((LinkedList)localObject3).add(str);
                }
              }
              localObject1 = new LinkedList();
              ChatroomInfoUI.a(ChatroomInfoUI.this, 0);
            }
            Object localObject2 = localObject1;
            if (ChatroomInfoUI.e(ChatroomInfoUI.this) > r.llh + 1)
            {
              localObject2 = localObject1;
              if (localObject1 != null)
              {
                localObject1 = ((List)localObject1).subList(0, r.llh + 1);
                localObject3 = ((LinkedList)localObject3).iterator();
                for (;;)
                {
                  localObject2 = localObject1;
                  if (!((Iterator)localObject3).hasNext()) {
                    break;
                  }
                  localObject2 = (String)((Iterator)localObject3).next();
                  if (!((List)localObject1).contains(localObject2)) {
                    ((List)localObject1).add(0, localObject2);
                  }
                }
              }
            }
            aq.f(new Runnable()
            {
              public final void run()
              {
                AppMethodBeat.i(196593);
                if (ChatroomInfoUI.e(ChatroomInfoUI.this) <= 1)
                {
                  ChatroomInfoUI.f(ChatroomInfoUI.this).cE("del_selector_btn", true);
                  ChatroomInfoUI.m(ChatroomInfoUI.this).ub(true).uc(false).eyr();
                }
                for (;;)
                {
                  ChatroomInfoUI.m(ChatroomInfoUI.this).B(ChatroomInfoUI.b(ChatroomInfoUI.this), this.fqR);
                  AppMethodBeat.o(196593);
                  return;
                  ChatroomInfoUI.m(ChatroomInfoUI.this).ub(true).uc(ChatroomInfoUI.d(ChatroomInfoUI.this)).eyr();
                }
              }
            });
            AppMethodBeat.o(196594);
          }
        });
        AppMethodBeat.o(12584);
        return;
      }
      LinkedList localLinkedList = new LinkedList();
      localLinkedList.add(this.roomId);
      this.fpW.B(this.roomId, localLinkedList);
    }
    AppMethodBeat.o(12584);
  }
  
  private void Vk()
  {
    AppMethodBeat.i(12586);
    if (this.sp == null) {
      this.sp = getSharedPreferences(getPackageName() + "_preferences", 0);
    }
    boolean bool;
    if (this.contact != null)
    {
      if (!this.dph) {
        break label140;
      }
      if (this.contact.evx == 0)
      {
        bool = true;
        this.fqj = bool;
      }
    }
    else
    {
      label76:
      if (!this.fqj) {
        break label161;
      }
      setTitleMuteIconVisibility(0);
      if (this.fpX != null) {
        this.sp.edit().putBoolean("room_notify_new_msg", true).commit();
      }
    }
    for (;;)
    {
      this.screen.notifyDataSetChanged();
      AppMethodBeat.o(12586);
      return;
      bool = false;
      break;
      label140:
      if (this.fpQ) {
        break label76;
      }
      this.fqj = this.contact.Ny();
      break label76;
      label161:
      setTitleMuteIconVisibility(8);
      if (this.fpX != null) {
        this.sp.edit().putBoolean("room_notify_new_msg", false).commit();
      }
    }
  }
  
  private void Vl()
  {
    AppMethodBeat.i(12587);
    Object localObject;
    RoomCardPreference localRoomCardPreference;
    if ((this.contact != null) && (this.fpR != null))
    {
      localObject = com.tencent.mm.model.q.sa(this.roomId);
      if ((localObject != null) && (((String)localObject).length() > 0)) {
        break label136;
      }
      this.fpR.ddw = false;
      this.contact = ((com.tencent.mm.plugin.messenger.foundation.a.k)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.messenger.foundation.a.k.class)).apM().aHY(this.roomId);
      if (!Vn()) {
        break label159;
      }
      String str = this.contact.ZX();
      localRoomCardPreference = this.fpR;
      localObject = str;
      if (str.length() <= 0) {
        localObject = getString(2131763409);
      }
    }
    label136:
    label159:
    for (localRoomCardPreference.fxZ = com.tencent.mm.pluginsdk.ui.span.k.c(this, (CharSequence)localObject);; this.fpR.fxZ = getString(2131762622))
    {
      this.screen.notifyDataSetChanged();
      AppMethodBeat.o(12587);
      return;
      this.fpR.ddw = true;
      this.fpR.fya = com.tencent.mm.pluginsdk.ui.span.k.c(this, (CharSequence)localObject);
      break;
    }
  }
  
  private void Vm()
  {
    AppMethodBeat.i(12588);
    if ((this.contact != null) && (this.fpS != null))
    {
      this.contact = ((com.tencent.mm.plugin.messenger.foundation.a.k)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.messenger.foundation.a.k.class)).apM().aHY(this.roomId);
      if (Vn())
      {
        String str2 = this.contact.ZW();
        Preference localPreference = this.fpS;
        String str1 = str2;
        if (str2.length() <= 0) {
          str1 = getString(2131763409);
        }
        localPreference.setSummary(com.tencent.mm.pluginsdk.ui.span.k.c(this, str1));
        if (this.screen != null) {
          this.screen.notifyDataSetChanged();
        }
        AppMethodBeat.o(12588);
        return;
      }
      this.fpS.setSummary(getString(2131762622));
    }
    AppMethodBeat.o(12588);
  }
  
  private boolean Vn()
  {
    AppMethodBeat.i(12589);
    String str = this.contact.field_nickname;
    if ((!bt.isNullOrNil(str)) && (str.length() <= 50))
    {
      AppMethodBeat.o(12589);
      return true;
    }
    AppMethodBeat.o(12589);
    return false;
  }
  
  private void Vo()
  {
    AppMethodBeat.i(12591);
    com.tencent.mm.plugin.report.service.h.vKh.kvStat(10170, "1");
    Object localObject = new LinkedList();
    ((List)localObject).add(this.roomId);
    ((List)localObject).add(com.tencent.mm.model.u.aqG());
    localObject = bt.n((List)localObject, ",");
    Intent localIntent = new Intent();
    localIntent.putExtra("titile", getString(2131755232));
    localIntent.putExtra("list_type", 0);
    localIntent.putExtra("list_attr", kH(com.tencent.mm.ui.contact.u.GWD));
    localIntent.putExtra("always_select_contact", (String)localObject);
    localIntent.putExtra("create_group_recommend", true);
    com.tencent.mm.bs.d.e(this, ".ui.contact.SelectContactUI", localIntent);
    AppMethodBeat.o(12591);
  }
  
  private void Vp()
  {
    AppMethodBeat.i(12595);
    boolean bool;
    Object localObject;
    if (this.fpW != null)
    {
      if (this.dph)
      {
        Vj();
        this.fpW.notifyChanged();
      }
    }
    else
    {
      bool = ((com.tencent.mm.plugin.chatroom.a.c)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.chatroom.a.c.class)).RF(this.roomId);
      if (Vq()) {
        break label264;
      }
      this.screen.cE("manage_room", true);
      localObject = this.screen;
      if (bool) {
        break label259;
      }
      bool = true;
      label82:
      ((f)localObject).cE("room_manager_view", bool);
      label93:
      if (((Vq()) || (this.fqi < r.llh)) && ((!Vq()) || (this.fqi < r.llh - 1))) {
        break label323;
      }
      this.screen.cE("see_room_member", false);
      this.fpT.setTitle(getString(2131762973));
      label157:
      if (com.tencent.mm.model.w.sn(this.roomId))
      {
        if (!Vq()) {
          break label340;
        }
        this.screen.cE("manage_room", false);
      }
    }
    for (;;)
    {
      this.screen.cE("room_manager_view", true);
      this.screen.notifyDataSetChanged();
      AppMethodBeat.o(12595);
      return;
      if (this.fpQ) {
        break;
      }
      localObject = new LinkedList();
      ((List)localObject).add(this.roomId);
      this.fpW.B(this.roomId, (List)localObject);
      break;
      label259:
      bool = false;
      break label82;
      label264:
      this.screen.cE("room_manager_view", true);
      if (com.tencent.mm.model.q.rY(this.roomId) > 2)
      {
        this.screen.cE("manage_room", false);
        break label93;
      }
      this.screen.cE("manage_room", true);
      break label93;
      label323:
      this.screen.cE("see_room_member", true);
      break label157;
      label340:
      this.screen.cE("manage_room", true);
    }
  }
  
  private boolean Vq()
  {
    AppMethodBeat.i(12600);
    if ((this.fql != null) && (this.fql.Vq()))
    {
      AppMethodBeat.o(12600);
      return true;
    }
    AppMethodBeat.o(12600);
    return false;
  }
  
  public static ArrayList<af> Y(List<blh> paramList)
  {
    AppMethodBeat.i(12590);
    ArrayList localArrayList = new ArrayList();
    if (paramList == null)
    {
      AppMethodBeat.o(12590);
      return localArrayList;
    }
    paramList = paramList.iterator();
    while (paramList.hasNext())
    {
      blh localblh = (blh)paramList.next();
      af localaf = new af();
      localaf.setUsername(localblh.mAQ);
      localaf.nd(localblh.mBV);
      localArrayList.add(localaf);
    }
    AppMethodBeat.o(12590);
    return localArrayList;
  }
  
  private static List<String> Z(List<String> paramList)
  {
    AppMethodBeat.i(12593);
    LinkedList localLinkedList = new LinkedList();
    if (!com.tencent.mm.kernel.g.afw())
    {
      AppMethodBeat.o(12593);
      return localLinkedList;
    }
    if (paramList == null)
    {
      AppMethodBeat.o(12593);
      return localLinkedList;
    }
    Iterator localIterator = paramList.iterator();
    while (localIterator.hasNext())
    {
      String str = (String)localIterator.next();
      af localaf = ((com.tencent.mm.plugin.messenger.foundation.a.k)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.messenger.foundation.a.k.class)).apM().aHY(str);
      paramList = str;
      if (localaf != null)
      {
        paramList = str;
        if ((int)localaf.fId != 0) {
          paramList = localaf.ZX();
        }
      }
      localLinkedList.add(paramList);
    }
    AppMethodBeat.o(12593);
    return localLinkedList;
  }
  
  private void bR(Context paramContext)
  {
    AppMethodBeat.i(12581);
    if (paramContext == null)
    {
      AppMethodBeat.o(12581);
      return;
    }
    if (Vi())
    {
      paramContext = new Intent();
      paramContext.putExtra("rawUrl", getString(2131757097, new Object[] { ac.eFu() }));
      paramContext.putExtra("geta8key_username", com.tencent.mm.model.u.aqG());
      paramContext.putExtra("showShare", false);
      com.tencent.mm.bs.d.b(this, "webview", "com.tencent.mm.plugin.webview.ui.tools.WebViewUI", paramContext);
    }
    AppMethodBeat.o(12581);
  }
  
  private void c(String paramString, List<String> paramList)
  {
    AppMethodBeat.i(12582);
    if ((paramList != null) && (paramList.size() > 0))
    {
      LinkedList localLinkedList = new LinkedList();
      int i = 0;
      while (i < paramList.size())
      {
        localLinkedList.add(paramList.get(i));
        i += 1;
      }
      paramList = "weixin://findfriend/verifycontact/" + paramString + "/";
      com.tencent.mm.model.p.a(paramString, localLinkedList, getString(2131757105), true, paramList);
    }
    AppMethodBeat.o(12582);
  }
  
  private void cC(boolean paramBoolean)
  {
    AppMethodBeat.i(12572);
    bi.a(this.roomId, new bi.a()
    {
      public final boolean Vt()
      {
        AppMethodBeat.i(196584);
        boolean bool = ChatroomInfoUI.u(ChatroomInfoUI.this);
        AppMethodBeat.o(196584);
        return bool;
      }
      
      public final void Vu()
      {
        AppMethodBeat.i(196585);
        if (ChatroomInfoUI.v(ChatroomInfoUI.this) != null) {
          ChatroomInfoUI.v(ChatroomInfoUI.this).dismiss();
        }
        AppMethodBeat.o(196585);
      }
    });
    ((com.tencent.mm.plugin.messenger.foundation.a.k)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.messenger.foundation.a.k.class)).apL().c(new com.tencent.mm.chatroom.f.a(this.roomId));
    ((com.tencent.mm.plugin.messenger.foundation.a.k)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.messenger.foundation.a.k.class)).apR().aIl(this.roomId);
    com.tencent.mm.roomsdk.a.b.aEI(this.roomId).oM(this.roomId).eDp();
    com.tencent.mm.model.q.rU(this.roomId);
    if (!paramBoolean) {
      this.handler.post(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(12546);
          ((com.tencent.mm.plugin.zero.b.b)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.zero.b.b.class)).azv().ov(7);
          AppMethodBeat.o(12546);
        }
      });
    }
    Object localObject = new Intent();
    ((Intent)localObject).addFlags(67108864);
    ((Intent)localObject).setComponent(new ComponentName(getPackageName(), com.tencent.mm.sdk.platformtools.aj.eFC() + ".ui.LauncherUI"));
    localObject = new com.tencent.mm.hellhoundlib.b.a().bd(localObject);
    com.tencent.mm.hellhoundlib.a.a.a(this, ((com.tencent.mm.hellhoundlib.b.a)localObject).adn(), "com/tencent/mm/chatroom/ui/ChatroomInfoUI", "doDeleteChatroom", "(Z)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
    startActivity((Intent)((com.tencent.mm.hellhoundlib.b.a)localObject).lS(0));
    com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/chatroom/ui/ChatroomInfoUI", "doDeleteChatroom", "(Z)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
    finish();
    AppMethodBeat.o(12572);
  }
  
  private void g(final String paramString1, String paramString2, int paramInt)
  {
    AppMethodBeat.i(12577);
    if ((com.tencent.mm.model.w.sm(this.roomId)) && (!com.tencent.mm.model.w.sp(this.roomId)) && (!com.tencent.mm.model.p.rK(paramString1)))
    {
      com.tencent.mm.ui.base.h.c(this, getString(2131762644), getString(2131755906), true);
      AppMethodBeat.o(12577);
      return;
    }
    if (oT(paramString1))
    {
      com.tencent.mm.ui.base.h.c(this, getString(2131755154), getString(2131755906), true);
      AppMethodBeat.o(12577);
      return;
    }
    paramString1 = bt.S(paramString1.split(","));
    if (paramString1 == null)
    {
      AppMethodBeat.o(12577);
      return;
    }
    paramString1 = com.tencent.mm.roomsdk.a.b.aEI(this.roomId).a(this.roomId, paramString1, paramString2);
    paramString1.d(new com.tencent.mm.roomsdk.a.b.c() {});
    getString(2131755906);
    paramString1.a(this, getString(paramInt), true, new DialogInterface.OnCancelListener()
    {
      public final void onCancel(DialogInterface paramAnonymousDialogInterface)
      {
        AppMethodBeat.i(196589);
        paramString1.cancel();
        AppMethodBeat.o(196589);
      }
    });
    AppMethodBeat.o(12577);
  }
  
  private int kH(int paramInt)
  {
    AppMethodBeat.i(12575);
    if (!com.tencent.mm.ui.contact.u.fbN())
    {
      AppMethodBeat.o(12575);
      return paramInt;
    }
    if (this.contact != null)
    {
      String str = this.contact.field_username;
      if ((af.aHH(str)) || (af.aHI(str)) || (com.tencent.mm.model.w.sp(str)))
      {
        AppMethodBeat.o(12575);
        return paramInt | 0x1000000;
      }
      AppMethodBeat.o(12575);
      return paramInt & 0xFEFFFFFF;
    }
    AppMethodBeat.o(12575);
    return paramInt;
  }
  
  private void oR(String paramString)
  {
    AppMethodBeat.i(12566);
    final int i = this.screen.aKm(paramString);
    paramString = getListView();
    com.tencent.mm.hellhoundlib.b.a locala = com.tencent.mm.hellhoundlib.b.c.a(i, new com.tencent.mm.hellhoundlib.b.a());
    com.tencent.mm.hellhoundlib.a.a.a(paramString, locala.adn(), "com/tencent/mm/chatroom/ui/ChatroomInfoUI", "MatteHighLightItem", "(Ljava/lang/String;)V", "Undefined", "smoothScrollToPosition", "(I)V");
    paramString.smoothScrollToPosition(((Integer)locala.lS(0)).intValue());
    com.tencent.mm.hellhoundlib.a.a.a(paramString, "com/tencent/mm/chatroom/ui/ChatroomInfoUI", "MatteHighLightItem", "(Ljava/lang/String;)V", "Undefined", "smoothScrollToPosition", "(I)V");
    new ap().postDelayed(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(12558);
        View localView = ((com.tencent.mm.ui.base.preference.a)ChatroomInfoUI.f(ChatroomInfoUI.this)).a(i, ChatroomInfoUI.this.getListView());
        if (localView != null) {
          com.tencent.mm.ui.h.a.b(ChatroomInfoUI.this.getContext(), localView);
        }
        AppMethodBeat.o(12558);
      }
    }, 10L);
    AppMethodBeat.o(12566);
  }
  
  private String oS(String paramString)
  {
    AppMethodBeat.i(12578);
    if (this.fql == null)
    {
      AppMethodBeat.o(12578);
      return null;
    }
    paramString = this.fql.sh(paramString);
    AppMethodBeat.o(12578);
    return paramString;
  }
  
  private boolean oT(String paramString)
  {
    AppMethodBeat.i(12592);
    if (bt.nullAsNil(com.tencent.mm.model.u.aqG()).equals(paramString))
    {
      AppMethodBeat.o(12592);
      return true;
    }
    Object localObject = com.tencent.mm.model.q.rW(this.roomId);
    if (localObject == null)
    {
      AppMethodBeat.o(12592);
      return false;
    }
    localObject = ((List)localObject).iterator();
    boolean bool = false;
    if (((Iterator)localObject).hasNext())
    {
      if (!((String)((Iterator)localObject).next()).equals(paramString)) {
        break label94;
      }
      bool = true;
    }
    label94:
    for (;;)
    {
      break;
      AppMethodBeat.o(12592);
      return bool;
    }
  }
  
  private void updateTitle()
  {
    AppMethodBeat.i(12583);
    if (this.dph)
    {
      this.fqi = com.tencent.mm.model.q.rY(this.roomId);
      if (this.fqi == 0)
      {
        setMMTitle(getString(2131762729));
        AppMethodBeat.o(12583);
        return;
      }
      setMMTitle(getString(2131759496, new Object[] { getString(2131762729), Integer.valueOf(this.fqi) }));
    }
    AppMethodBeat.o(12583);
  }
  
  public final void a(int paramInt, com.tencent.mm.sdk.e.n paramn, Object paramObject)
  {
    AppMethodBeat.i(12596);
    if ((paramObject == null) || (!(paramObject instanceof String)))
    {
      ad.d("MicroMsg.ChatroomInfoUI", "onNotifyChange obj not String event:%d stg:%s obj:%s", new Object[] { Integer.valueOf(paramInt), paramn, paramObject });
      AppMethodBeat.o(12596);
      return;
    }
    a((String)paramObject, null);
    AppMethodBeat.o(12596);
  }
  
  public final void a(String paramString, com.tencent.mm.sdk.e.m paramm)
  {
    AppMethodBeat.i(12597);
    if (bt.isNullOrNil(paramString))
    {
      AppMethodBeat.o(12597);
      return;
    }
    if (!com.tencent.mm.model.w.pF(paramString))
    {
      ad.d("MicroMsg.ChatroomInfoUI", "event:" + paramString + " cancel");
      AppMethodBeat.o(12597);
      return;
    }
    ad.d("MicroMsg.ChatroomInfoUI", "event:".concat(String.valueOf(paramString)));
    if ((this.dph) && (paramString.equals(this.roomId))) {
      com.tencent.mm.kernel.g.afE().ax(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(196598);
          ChatroomInfoUI.a(ChatroomInfoUI.this, ((com.tencent.mm.plugin.chatroom.a.c)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.chatroom.a.c.class)).apV().tH(ChatroomInfoUI.b(ChatroomInfoUI.this)));
          if (ChatroomInfoUI.c(ChatroomInfoUI.this) == null)
          {
            ad.e("MicroMsg.ChatroomInfoUI", "member is null");
            AppMethodBeat.o(196598);
            return;
          }
          if (bt.isNullOrNil(ChatroomInfoUI.c(ChatroomInfoUI.this).field_roomowner))
          {
            ad.e("MicroMsg.ChatroomInfoUI", "roomowner is null");
            AppMethodBeat.o(196598);
            return;
          }
          ChatroomInfoUI.y(ChatroomInfoUI.this).sendEmptyMessage(0);
          ChatroomInfoUI.c(ChatroomInfoUI.this, ChatroomInfoUI.c(ChatroomInfoUI.this).field_roomowner.equals(com.tencent.mm.model.u.aqG()));
          ChatroomInfoUI.d(ChatroomInfoUI.this, ChatroomInfoUI.c(ChatroomInfoUI.this).aHz(com.tencent.mm.model.u.aqG()));
          ChatroomInfoUI.m(ChatroomInfoUI.this).aCa(ChatroomInfoUI.c(ChatroomInfoUI.this).field_roomowner);
          AppMethodBeat.o(196598);
        }
        
        public final String toString()
        {
          AppMethodBeat.i(196599);
          String str = super.toString() + "|onNotifyChange";
          AppMethodBeat.o(196599);
          return str;
        }
      });
    }
    Vp();
    AppMethodBeat.o(12597);
  }
  
  public com.tencent.mm.ui.base.preference.h createAdapter(SharedPreferences paramSharedPreferences)
  {
    AppMethodBeat.i(12599);
    paramSharedPreferences = new com.tencent.mm.ui.base.preference.a(this, getListView(), paramSharedPreferences);
    AppMethodBeat.o(12599);
    return paramSharedPreferences;
  }
  
  public int getResourceId()
  {
    return 2131951707;
  }
  
  public final void h(String paramString1, String paramString2, String paramString3)
  {
    AppMethodBeat.i(12598);
    if ((paramString1.equals(this.roomId)) && (this.fpW != null)) {
      this.fpW.notifyChanged();
    }
    AppMethodBeat.o(12598);
  }
  
  public void initView()
  {
    AppMethodBeat.i(12570);
    this.screen = getPreferenceScreen();
    Object localObject1;
    label97:
    boolean bool;
    if (this.dph) {
      if (this.fqi == 0)
      {
        setMMTitle(getString(2131762729));
        localObject1 = null;
        if (this.fql != null)
        {
          localObject1 = this.fql.field_roomowner;
          this.fqi = this.fql.awt().size();
        }
        if (!bt.isNullOrNil((String)localObject1)) {
          break label1384;
        }
        this.fqf = false;
        this.fqg = false;
        this.fqh = false;
        ad.d("MicroMsg.ChatroomInfoUI", "initBaseChatRoomView()");
        this.fpW = ((ContactListExpandPreference)this.screen.aKk("roominfo_contact_anchor"));
        this.fpW.a(this.screen, this.fpW.mKey);
        this.fpV = ((NormalIconPreference)this.screen.aKk("del_selector_btn"));
        this.fpU = ((NormalIconPreference)this.screen.aKk("add_selector_btn"));
        this.fpS = this.screen.aKk("room_name");
        this.fpR = ((RoomCardPreference)this.screen.aKk("room_card"));
        this.fpT = this.screen.aKk("see_room_member");
        this.fpX = ((CheckBoxPreference)this.screen.aKk("room_notify_new_msg"));
        this.fpY = ((CheckBoxPreference)this.screen.aKk("room_save_to_contact"));
        this.fpZ = ((CheckBoxPreference)this.screen.aKk("room_placed_to_the_top"));
        this.fqa = ((KeyValuePreference)this.screen.aKk("room_nickname"));
        this.fqb = ((KeyValuePreference)this.screen.aKk("room_remark"));
        this.fqd = ((NewTipPreference)this.screen.aKk("manage_room"));
        this.fpW.ub(true).uc(true).eyr();
        bool = ((com.tencent.mm.plugin.chatroom.a.c)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.chatroom.a.c.class)).RF(this.roomId);
        if (Vq()) {
          break label1409;
        }
        this.screen.cE("manage_room", true);
        localObject1 = this.screen;
        if (bool) {
          break label1404;
        }
        bool = true;
        label414:
        ((f)localObject1).cE("room_manager_view", bool);
        label426:
        if (com.tencent.mm.model.w.sn(this.roomId))
        {
          if (!Vq()) {
            break label1468;
          }
          this.screen.cE("manage_room", false);
        }
        label457:
        if (com.tencent.mm.model.w.sm(this.roomId))
        {
          localObject1 = ((com.tencent.mm.plugin.chatroom.a.c)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.chatroom.a.c.class)).apV().tH(this.roomId);
          if ((localObject1 != null) && ((((com.tencent.mm.storage.w)localObject1).field_chatroomStatus & 0x20000) != 131072) && ((((com.tencent.mm.storage.w)localObject1).field_chatroomStatus & 0x10000) == 65536) && (com.tencent.mm.model.q.aqB()))
          {
            this.fqr = true;
            this.fqd.a(this.screen);
            com.tencent.mm.plugin.newtips.a.cWs().h(this.fqd);
            com.tencent.mm.plugin.newtips.a.g.a(this.fqd);
          }
        }
        if (this.fql != null)
        {
          this.fpW.aCa(this.fql.field_roomowner);
          if (!bt.isNullOrNil(this.fql.field_roomowner)) {
            this.fpW.BZr.BYH.BZh = true;
          }
        }
        this.fpW.eyq();
        this.fpW.eyk();
        this.screen.cE("add_selector_btn", true);
        this.screen.cE("del_selector_btn", true);
        this.screen.cE("room_name", false);
        this.screen.cE("room_qr_code", false);
        this.screen.cE("chatroom_info_chexboxes", true);
        this.screen.cE("room_card", false);
        this.screen.cE("room_upgrade_entry", true);
        this.screen.cE("chat_room_story_videos", true);
        if (((Vq()) || (this.fqi < r.llh)) && ((!Vq()) || (this.fqi < r.llh - 1))) {
          break label1485;
        }
        this.screen.cE("see_room_member", false);
        this.fpT.setTitle(getString(2131762973));
        label804:
        if (af.aHI(this.roomId)) {
          break label1502;
        }
        this.screen.cE("room_openim_about", true);
        label828:
        ad.d("MicroMsg.ChatroomInfoUI", "updatePlaceTop()");
        if (this.sp == null) {
          this.sp = getSharedPreferences(getPackageName() + "_preferences", 0);
        }
        if (this.fpZ != null)
        {
          if (this.contact == null) {
            break label1616;
          }
          this.sp.edit().putBoolean("room_placed_to_the_top", ((com.tencent.mm.plugin.messenger.foundation.a.k)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.messenger.foundation.a.k.class)).apR().aIv(this.contact.field_username)).commit();
        }
        label939:
        this.screen.notifyDataSetChanged();
        ad.d("MicroMsg.ChatroomInfoUI", "updateSaveToContact()");
        if (this.sp == null) {
          this.sp = getSharedPreferences(getPackageName() + "_preferences", 0);
        }
        if (this.fpY == null) {
          break label1674;
        }
        localObject1 = ((com.tencent.mm.plugin.messenger.foundation.a.k)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.messenger.foundation.a.k.class)).apM().aHY(this.roomId);
        if (localObject1 != null) {
          break label1643;
        }
        ad.e("MicroMsg.ChatroomInfoUI", "contact == null !!!");
        label1042:
        ad.d("MicroMsg.ChatroomInfoUI", "updateDisplayNickname()");
        if (this.sp == null) {
          this.sp = getSharedPreferences(getPackageName() + "_preferences", 0);
        }
        localObject1 = ((com.tencent.mm.plugin.chatroom.a.c)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.chatroom.a.c.class)).apV().tH(this.roomId);
        if (localObject1 != null) {
          break label1686;
        }
        ad.e("MicroMsg.ChatroomInfoUI", "members == null !!!");
        label1129:
        this.fqm = ((com.tencent.mm.plugin.messenger.foundation.a.k)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.messenger.foundation.a.k.class)).cOI().agF(this.roomId);
        this.fqm = ((com.tencent.mm.plugin.messenger.foundation.a.k)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.messenger.foundation.a.k.class)).cOI().agF(this.roomId);
      }
    }
    for (;;)
    {
      if (this.fpW != null)
      {
        if ((!this.dph) && (this.fpQ)) {
          this.fpW.aE(new ArrayList());
        }
        getListView().setOnScrollListener(this.fqs);
        this.fpW.a(this.fqs);
        this.fpW.a(new s.b()
        {
          public final boolean kL(int paramAnonymousInt)
          {
            return true;
          }
        });
        localObject1 = this.fpW;
        localObject2 = new View.OnClickListener()
        {
          public final void onClick(View paramAnonymousView)
          {
            AppMethodBeat.i(12508);
            AppMethodBeat.o(12508);
          }
        };
        if (((ContactListExpandPreference)localObject1).BZr != null) {
          ((ContactListExpandPreference)localObject1).BZr.hs = ((View.OnClickListener)localObject2);
        }
        this.fpW.a(new ContactListExpandPreference.a()
        {
          public final void b(ViewGroup paramAnonymousViewGroup, View paramAnonymousView, int paramAnonymousInt)
          {
            AppMethodBeat.i(205010);
            ChatroomInfoUI.l(ChatroomInfoUI.this);
            AppMethodBeat.o(205010);
          }
          
          public final void c(ViewGroup paramAnonymousViewGroup, View paramAnonymousView, int paramAnonymousInt)
          {
            AppMethodBeat.i(205011);
            paramAnonymousView = ChatroomInfoUI.m(ChatroomInfoUI.this).US(paramAnonymousInt);
            paramAnonymousViewGroup = bt.nullAsNil(ChatroomInfoUI.m(ChatroomInfoUI.this).UU(paramAnonymousInt));
            Object localObject;
            if (bt.isNullOrNil(paramAnonymousViewGroup))
            {
              com.tencent.mm.kernel.g.afC();
              localObject = ((com.tencent.mm.plugin.messenger.foundation.a.k)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.messenger.foundation.a.k.class)).apN().agQ(paramAnonymousView);
              if ((localObject != null) && (!bt.isNullOrNil(((bw)localObject).field_encryptUsername))) {
                paramAnonymousViewGroup = ((bw)localObject).field_conRemark;
              }
            }
            for (;;)
            {
              if (bt.isNullOrNil(paramAnonymousView))
              {
                AppMethodBeat.o(205011);
                return;
              }
              localObject = new Intent();
              ((Intent)localObject).putExtra("Contact_User", paramAnonymousView);
              ((Intent)localObject).putExtra("Contact_RemarkName", paramAnonymousViewGroup);
              if ((ChatroomInfoUI.n(ChatroomInfoUI.this)) && (ChatroomInfoUI.c(ChatroomInfoUI.this) != null)) {
                ((Intent)localObject).putExtra("Contact_RoomNickname", ChatroomInfoUI.c(ChatroomInfoUI.this).sh(paramAnonymousView));
              }
              ((Intent)localObject).putExtra("Contact_Nick", bt.nullAsNil(ChatroomInfoUI.m(ChatroomInfoUI.this).UT(paramAnonymousInt)));
              ((Intent)localObject).putExtra("Contact_RoomMember", true);
              ((Intent)localObject).putExtra("room_name", ChatroomInfoUI.o(ChatroomInfoUI.this).field_username);
              paramAnonymousViewGroup = ((com.tencent.mm.plugin.messenger.foundation.a.k)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.messenger.foundation.a.k.class)).apM().aHY(paramAnonymousView);
              if ((paramAnonymousViewGroup != null) && ((int)paramAnonymousViewGroup.fId > 0) && (com.tencent.mm.n.b.ls(paramAnonymousViewGroup.field_type)))
              {
                sk localsk = new sk();
                localsk.dxW.intent = ((Intent)localObject);
                localsk.dxW.username = paramAnonymousView;
                com.tencent.mm.sdk.b.a.ESL.l(localsk);
              }
              if (ChatroomInfoUI.n(ChatroomInfoUI.this))
              {
                com.tencent.mm.plugin.report.service.h.vKh.idkeyStat(219L, 9L, 1L, true);
                if ((paramAnonymousViewGroup != null) && (paramAnonymousViewGroup.eKB())) {
                  com.tencent.mm.plugin.report.service.h.vKh.kvStat(10298, paramAnonymousViewGroup.field_username + ",14");
                }
                ((Intent)localObject).putExtra("Contact_Scene", 14);
              }
              for (;;)
              {
                ((Intent)localObject).putExtra("Is_RoomOwner", ChatroomInfoUI.q(ChatroomInfoUI.this));
                ((Intent)localObject).putExtra("Contact_ChatRoomId", ChatroomInfoUI.b(ChatroomInfoUI.this));
                if (com.tencent.mm.model.w.sn(ChatroomInfoUI.b(ChatroomInfoUI.this)))
                {
                  paramAnonymousViewGroup = new com.tencent.mm.g.b.a.bg();
                  paramAnonymousViewGroup.hZ(ChatroomInfoUI.b(ChatroomInfoUI.this));
                  paramAnonymousViewGroup.dKc = 12L;
                  paramAnonymousViewGroup.aBj();
                }
                ((Intent)localObject).putExtra("CONTACT_INFO_UI_SOURCE", 8);
                com.tencent.mm.bs.d.b(ChatroomInfoUI.this, "profile", ".ui.ContactInfoUI", (Intent)localObject);
                AppMethodBeat.o(205011);
                return;
                if (ChatroomInfoUI.p(ChatroomInfoUI.this))
                {
                  ((Intent)localObject).putExtra("Contact_Scene", 44);
                  if (!com.tencent.mm.model.u.se(paramAnonymousViewGroup.field_username)) {
                    ((Intent)localObject).putExtra("Contact_IsLBSFriend", true);
                  }
                }
              }
            }
          }
          
          public final void d(ViewGroup paramAnonymousViewGroup, View paramAnonymousView) {}
          
          public final void d(ViewGroup paramAnonymousViewGroup, View paramAnonymousView, int paramAnonymousInt)
          {
            AppMethodBeat.i(205013);
            ChatroomInfoUI.r(ChatroomInfoUI.this);
            AppMethodBeat.o(205013);
          }
          
          public final void e(ViewGroup paramAnonymousViewGroup, View paramAnonymousView)
          {
            AppMethodBeat.i(205012);
            if (ChatroomInfoUI.m(ChatroomInfoUI.this) != null) {
              ChatroomInfoUI.m(ChatroomInfoUI.this).eyo();
            }
            AppMethodBeat.o(205012);
          }
        });
      }
      setBackBtn(new MenuItem.OnMenuItemClickListener()
      {
        public final boolean onMenuItemClick(MenuItem paramAnonymousMenuItem)
        {
          AppMethodBeat.i(12513);
          ChatroomInfoUI.this.finish();
          AppMethodBeat.o(12513);
          return true;
        }
      });
      AppMethodBeat.o(12570);
      return;
      if (this.fql != null) {
        this.fqi = this.fql.awt().size();
      }
      setMMTitle(getString(2131759496, new Object[] { getString(2131762729), Integer.valueOf(this.fqi) }));
      break;
      label1384:
      this.fqf = true;
      this.fqg = ((String)localObject1).equals(com.tencent.mm.model.u.aqG());
      break label97;
      label1404:
      bool = false;
      break label414;
      label1409:
      this.screen.cE("room_manager_view", true);
      if (com.tencent.mm.model.q.rY(this.roomId) > 2)
      {
        this.screen.cE("manage_room", false);
        break label426;
      }
      this.screen.cE("manage_room", true);
      break label426;
      label1468:
      this.screen.cE("manage_room", true);
      break label457;
      label1485:
      this.screen.cE("see_room_member", true);
      break label804;
      label1502:
      this.screen.cE("chatroom_bottom_pc", true);
      this.screen.cE("room_openim_about", false);
      localObject1 = getString(2131762663);
      Object localObject2 = getString(2131762664);
      int i = ((String)localObject1).lastIndexOf((String)localObject2);
      if (i < 0) {
        break label828;
      }
      int j = ((String)localObject2).length();
      localObject1 = new SpannableStringBuilder((CharSequence)localObject1);
      ((SpannableStringBuilder)localObject1).setSpan(new com.tencent.mm.plugin.messenger.a.a()
      {
        public final void onClickImp(View paramAnonymousView)
        {
          AppMethodBeat.i(12514);
          Object localObject = new Intent();
          ((Intent)localObject).setFlags(268435456);
          ((Intent)localObject).setClassName(com.tencent.mm.sdk.platformtools.aj.getContext(), "com.tencent.mm.plugin.webview.ui.tools.WebViewUI");
          ((Intent)localObject).putExtra("rawUrl", "https://weixin.qq.com/cgi-bin/newreadtemplate?t=work_wechat/about_group");
          paramAnonymousView = com.tencent.mm.sdk.platformtools.aj.getContext();
          localObject = new com.tencent.mm.hellhoundlib.b.a().bd(localObject);
          com.tencent.mm.hellhoundlib.a.a.a(paramAnonymousView, ((com.tencent.mm.hellhoundlib.b.a)localObject).adn(), "com/tencent/mm/chatroom/ui/ChatroomInfoUI$13", "onClickImp", "(Landroid/view/View;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
          paramAnonymousView.startActivity((Intent)((com.tencent.mm.hellhoundlib.b.a)localObject).lS(0));
          com.tencent.mm.hellhoundlib.a.a.a(paramAnonymousView, "com/tencent/mm/chatroom/ui/ChatroomInfoUI$13", "onClickImp", "(Landroid/view/View;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
          AppMethodBeat.o(12514);
        }
      }, i, j + i, 18);
      this.screen.aKk("room_openim_about").setTitle((CharSequence)localObject1);
      break label828;
      label1616:
      this.sp.edit().putBoolean("room_placed_to_the_top", false).commit();
      break label939;
      label1643:
      this.sp.edit().putBoolean("room_save_to_contact", com.tencent.mm.n.b.ls(((au)localObject1).field_type)).commit();
      label1674:
      this.screen.notifyDataSetChanged();
      break label1042;
      label1686:
      this.fqe = ((com.tencent.mm.storage.w)localObject1).eKs();
      this.fqc = ((CheckBoxPreference)this.screen.aKk("room_msg_show_username"));
      if (this.fqc != null) {
        this.sp.edit().putBoolean("room_msg_show_username", this.fqe).commit();
      }
      this.screen.notifyDataSetChanged();
      break label1129;
      if (this.fpQ)
      {
        this.fqg = false;
        this.fqh = false;
        setMMTitle(getString(2131762629));
        this.fpW = ((ContactListExpandPreference)this.screen.aKk("roominfo_contact_anchor"));
        this.fpW.a(this.screen, this.fpW.mKey);
        this.fpW.ub(false).uc(false);
        this.fpW.a(new s.b()
        {
          public final boolean kL(int paramAnonymousInt)
          {
            return true;
          }
        });
        this.screen.removeAll();
        this.screen.b(new PreferenceCategory(this));
        this.screen.b(this.fpW);
        localObject1 = this.roomId;
        localObject2 = new lx();
        ((lx)localObject2).dqY.doV = ((String)localObject1);
        com.tencent.mm.sdk.b.a.ESL.l((com.tencent.mm.sdk.b.b)localObject2);
        getString(2131755906);
        this.fpP = com.tencent.mm.ui.base.h.b(this, getString(2131762627), true, new DialogInterface.OnCancelListener()
        {
          public final void onCancel(DialogInterface paramAnonymousDialogInterface)
          {
            AppMethodBeat.i(196597);
            ChatroomInfoUI.a(this.fqU);
            AppMethodBeat.o(196597);
          }
        });
        this.screen.notifyDataSetChanged();
      }
    }
  }
  
  public void onActivityResult(int paramInt1, int paramInt2, final Intent paramIntent)
  {
    AppMethodBeat.i(12569);
    super.onActivityResult(paramInt1, paramInt2, paramIntent);
    switch (paramInt1)
    {
    case 3: 
    default: 
      AppMethodBeat.o(12569);
      return;
    case 1: 
      if (paramIntent == null)
      {
        AppMethodBeat.o(12569);
        return;
      }
      paramIntent = paramIntent.getStringExtra("Select_Contact");
      com.tencent.mm.storage.w localw = ((com.tencent.mm.plugin.chatroom.a.c)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.chatroom.a.c.class)).apV().tH(this.roomId);
      if (localw != null)
      {
        paramInt1 = localw.eKq();
        if (Vq()) {
          break label514;
        }
        if (com.tencent.mm.model.w.sn(this.roomId))
        {
          if ((paramInt1 & 0x1) != 1) {
            break label514;
          }
          paramInt1 = 1;
        }
      }
      break;
    }
    for (;;)
    {
      if (paramInt1 != 0)
      {
        new f.a(this).aMo(getString(2131762554)).aMs(getString(2131755884)).wZ(true).p(Boolean.TRUE).aMt(getString(2131755691)).aMq(getString(2131762208)).c(new f.c()
        {
          public final void d(boolean paramAnonymousBoolean, String paramAnonymousString)
          {
            AppMethodBeat.i(12559);
            if (paramAnonymousBoolean) {
              ChatroomInfoUI.a(ChatroomInfoUI.this, paramIntent, paramAnonymousString);
            }
            AppMethodBeat.o(12559);
          }
        }).show();
        AppMethodBeat.o(12569);
        return;
        if (paramInt1 == 2) {
          paramInt1 = 1;
        }
      }
      else
      {
        g(paramIntent, null, 2131755168);
        AppMethodBeat.o(12569);
        return;
        if (paramIntent == null)
        {
          AppMethodBeat.o(12569);
          return;
        }
        paramIntent = paramIntent.getStringExtra("Select_Contact");
        if ((paramIntent == null) || (paramIntent.equals("")))
        {
          AppMethodBeat.o(12569);
          return;
        }
        paramIntent = bt.S(paramIntent.split(","));
        paramIntent = com.tencent.mm.roomsdk.a.b.aEI(this.roomId).a(this.roomId, paramIntent, 0);
        paramIntent.b(new com.tencent.mm.roomsdk.a.b.b() {});
        paramIntent.c(new com.tencent.mm.roomsdk.a.b.b() {});
        getString(2131755906);
        paramIntent.a(this, getString(2131762595), true, new DialogInterface.OnCancelListener()
        {
          public final void onCancel(DialogInterface paramAnonymousDialogInterface)
          {
            AppMethodBeat.i(196588);
            paramIntent.cancel();
            AppMethodBeat.o(196588);
          }
        });
        AppMethodBeat.o(12569);
        return;
        if (paramInt2 == -1)
        {
          finish();
          AppMethodBeat.o(12569);
          return;
          if (paramInt2 == -1)
          {
            paramIntent = paramIntent.getStringExtra("room_name");
            if (!bt.isNullOrNil(paramIntent))
            {
              com.tencent.mm.sdk.b.a.ESL.l(new wi());
              this.contact.nd(paramIntent);
              ((com.tencent.mm.plugin.messenger.foundation.a.k)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.messenger.foundation.a.k.class)).apM().ae(this.contact);
              Vm();
            }
            AppMethodBeat.o(12569);
            return;
            if (paramInt2 == 0)
            {
              this.fqv = -1;
              AppMethodBeat.o(12569);
              return;
              if (paramInt2 != -1) {
                break;
              }
              Vl();
              break;
            }
          }
        }
        AppMethodBeat.o(12569);
        return;
      }
      label514:
      paramInt1 = 0;
    }
  }
  
  public void onConfigurationChanged(Configuration paramConfiguration)
  {
    AppMethodBeat.i(12565);
    super.onConfigurationChanged(paramConfiguration);
    this.fpW.notifyChanged();
    AppMethodBeat.o(12565);
  }
  
  public void onCreate(final Bundle paramBundle)
  {
    AppMethodBeat.i(12562);
    super.onCreate(paramBundle);
    com.tencent.mm.kernel.g.afA().gcy.a(480, this);
    com.tencent.mm.pluginsdk.c.b.a(lx.class.getName(), this.fqA);
    paramBundle = this.fqu.alive();
    Assert.assertNotNull(this);
    keep(paramBundle);
    com.tencent.mm.kernel.g.afB().afk().a(this);
    ((com.tencent.mm.plugin.chatroom.a.c)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.chatroom.a.c.class)).apV().add(this);
    if (com.tencent.mm.bi.g.hxv != null) {
      com.tencent.mm.bi.g.hxv.a(this);
    }
    this.roomId = getIntent().getStringExtra("RoomInfo_Id");
    this.contact = ((com.tencent.mm.plugin.messenger.foundation.a.k)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.messenger.foundation.a.k.class)).apM().aHY(this.roomId);
    this.fqn = true;
    this.dph = getIntent().getBooleanExtra("Is_Chatroom", true);
    this.fpQ = getIntent().getBooleanExtra("Is_Lbsroom", false);
    this.fqo = getIntent().getBooleanExtra("fromChatting", false);
    this.fqp = getIntent().getBooleanExtra("isShowSetMuteAnimation", false);
    this.fqx = (getPackageName() + "_preferences");
    if (this.dph)
    {
      this.fql = ((com.tencent.mm.plugin.chatroom.a.c)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.chatroom.a.c.class)).apV().tH(this.roomId);
      if (this.fql != null) {
        this.fqh = this.fql.aHz(com.tencent.mm.model.u.aqG());
      }
    }
    initView();
    if (this.dph)
    {
      paramBundle = new ar.b.a()
      {
        public final void p(final String paramAnonymousString, boolean paramAnonymousBoolean)
        {
          AppMethodBeat.i(12534);
          if ((paramAnonymousBoolean) && (ChatroomInfoUI.b(ChatroomInfoUI.this).equals(paramAnonymousString))) {
            com.tencent.mm.kernel.g.afE().ax(new Runnable()
            {
              public final void run()
              {
                AppMethodBeat.i(12532);
                ((com.tencent.mm.plugin.chatroom.a.c)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.chatroom.a.c.class)).apV().v(paramAnonymousString, System.currentTimeMillis());
                AppMethodBeat.o(12532);
              }
              
              public final String toString()
              {
                AppMethodBeat.i(12533);
                String str = super.toString() + "|getContactCallBack";
                AppMethodBeat.o(12533);
                return str;
              }
            });
          }
          AppMethodBeat.o(12534);
        }
      };
      if (this.fql == null)
      {
        ar.a.gMW.a(this.roomId, "", paramBundle);
        AppMethodBeat.o(12562);
        return;
      }
      if (System.currentTimeMillis() - this.fql.field_modifytime >= 86400000L) {
        com.tencent.mm.kernel.g.afE().ax(new Runnable()
        {
          public final void run()
          {
            AppMethodBeat.i(12543);
            ar.a.gMW.a(ChatroomInfoUI.c(ChatroomInfoUI.this).field_chatroomname, "", paramBundle);
            AppMethodBeat.o(12543);
          }
          
          public final String toString()
          {
            AppMethodBeat.i(12544);
            String str = super.toString() + "|getContactCallBack2";
            AppMethodBeat.o(12544);
            return str;
          }
        });
      }
    }
    AppMethodBeat.o(12562);
  }
  
  public void onDestroy()
  {
    AppMethodBeat.i(12568);
    if (com.tencent.mm.bi.g.hxv != null) {
      com.tencent.mm.bi.g.hxv.a(this);
    }
    com.tencent.mm.kernel.g.afB().afk().b(this);
    com.tencent.mm.ui.h.a.dismiss();
    com.tencent.mm.kernel.g.afA().gcy.b(480, this);
    com.tencent.mm.sdk.b.a.ESL.d(this.fqu);
    com.tencent.mm.pluginsdk.c.b.b(lx.class.getName(), this.fqA);
    if (com.tencent.mm.kernel.g.afw())
    {
      ((com.tencent.mm.plugin.messenger.foundation.a.k)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.messenger.foundation.a.k.class)).apM().b(this);
      ((com.tencent.mm.plugin.chatroom.a.c)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.chatroom.a.c.class)).apV().remove(this);
    }
    if (com.tencent.mm.bi.g.hxv != null) {
      com.tencent.mm.bi.g.hxv.b(this);
    }
    if (this.fqB != null) {
      this.fqB.stopTimer();
    }
    super.onDestroy();
    AppMethodBeat.o(12568);
  }
  
  public void onPause()
  {
    AppMethodBeat.i(12567);
    super.onPause();
    if ((this.fqk) && (this.dph))
    {
      if (this.fql == null)
      {
        AppMethodBeat.o(12567);
        return;
      }
      com.tencent.mm.model.q.a(this.roomId, this.fql, this.fqe);
    }
    AppMethodBeat.o(12567);
  }
  
  public boolean onPreferenceTreeClick(f paramf, Preference arg2)
  {
    int j = 1;
    AppMethodBeat.i(12571);
    paramf = ???.mKey;
    if (paramf.equals("room_name"))
    {
      paramf = com.tencent.mm.m.g.Zd().getValue("ChatRoomOwnerModTopic");
      if (bt.isNullOrNil(paramf)) {
        break label3099;
      }
    }
    label647:
    label2579:
    label3094:
    label3099:
    for (int i = bt.aGh(paramf);; i = 0)
    {
      if ((this.fql != null) && (!bt.isNullOrNil(this.fql.field_roomowner)) && (i > 0) && (!Vq()) && (i < this.fqi)) {
        com.tencent.mm.ui.base.h.a(this, getString(2131762706, new Object[] { Vh() }), null, getString(2131755793), new DialogInterface.OnClickListener()
        {
          public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt) {}
        });
      }
      final boolean bool1;
      for (;;)
      {
        AppMethodBeat.o(12571);
        return false;
        paramf = new Intent();
        paramf.setClass(this, ModRemarkRoomNameUI.class);
        paramf.putExtra("Key_Scenen", 1);
        paramf.putExtra("Key_Room_Id", this.roomId);
        paramf = new com.tencent.mm.hellhoundlib.b.a().bd(paramf);
        com.tencent.mm.hellhoundlib.a.a.a(this, paramf.adn(), "com/tencent/mm/chatroom/ui/ChatroomInfoUI", "onPreferenceTreeClick", "(Lcom/tencent/mm/ui/base/preference/IPreferenceScreen;Lcom/tencent/mm/ui/base/preference/Preference;)Z", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
        startActivity((Intent)paramf.lS(0));
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/chatroom/ui/ChatroomInfoUI", "onPreferenceTreeClick", "(Lcom/tencent/mm/ui/base/preference/IPreferenceScreen;Lcom/tencent/mm/ui/base/preference/Preference;)Z", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
        com.tencent.mm.plugin.report.service.h.vKh.idkeyStat(219L, 3L, 1L, true);
        continue;
        if (paramf.equals("room_upgrade_entry"))
        {
          bR(this);
        }
        else if (paramf.equals("room_qr_code"))
        {
          if (com.tencent.mm.model.w.sn(this.roomId))
          {
            paramf = new com.tencent.mm.g.b.a.bg();
            paramf.hZ(this.roomId);
            paramf.dKc = 6L;
            paramf.aBj();
          }
          com.tencent.mm.plugin.report.service.h.vKh.idkeyStat(219L, 5L, 1L, true);
          paramf = new Intent();
          paramf.putExtra("from_userName", this.roomId);
          com.tencent.mm.bs.d.b(this, "setting", ".ui.setting.SelfQRCodeUI", paramf);
        }
        else if (paramf.equals("room_card"))
        {
          if (this.fql == null)
          {
            ad.w("MicroMsg.ChatroomInfoUI", "goToRoomCardUI member == null");
          }
          else
          {
            bool1 = this.fql.aHz(com.tencent.mm.model.u.aqG());
            if ((bt.isNullOrNil(com.tencent.mm.model.q.sa(this.roomId))) && (!Vq()))
            {
              com.tencent.mm.ui.base.h.d(this, getString(2131762581), null, getString(2131762582), null, null, null);
            }
            else
            {
              paramf = new Intent();
              paramf.setClass(this, RoomCardUI.class);
              paramf.putExtra("RoomInfo_Id", this.roomId);
              paramf.putExtra("room_name", this.fpR.fxZ.toString());
              this.fqi = com.tencent.mm.model.q.rW(this.roomId).size();
              paramf.putExtra("room_member_count", this.fqi);
              paramf.putExtra("room_owner_name", Vh());
              paramf.putExtra("room_notice", com.tencent.mm.model.q.sa(this.roomId));
              paramf.putExtra("room_notice_publish_time", com.tencent.mm.model.q.sc(this.roomId));
              paramf.putExtra("room_notice_editor", com.tencent.mm.model.q.sb(this.roomId));
              paramf.putExtra("Is_RoomOwner", this.fqg);
              paramf.putExtra("Is_RoomManager", bool1);
              startActivityForResult(paramf, 6);
            }
          }
        }
        else
        {
          if (paramf.equals("room_notify_new_msg"))
          {
            if (!this.fqj)
            {
              bool1 = true;
              this.fqj = bool1;
              if (this.dph)
              {
                if (!this.fqj) {
                  break label892;
                }
                i = 0;
                label669:
                com.tencent.mm.roomsdk.a.b.aEI(this.roomId).E(this.roomId, i).eDp();
                this.contact = ((com.tencent.mm.plugin.messenger.foundation.a.k)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.messenger.foundation.a.k.class)).apM().aHY(this.roomId);
                this.contact.jM(i);
                ((com.tencent.mm.plugin.messenger.foundation.a.k)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.messenger.foundation.a.k.class)).apM().c(this.roomId, this.contact);
                if (this.fqq)
                {
                  paramf = com.tencent.mm.plugin.report.service.h.vKh;
                  if (!this.fqj) {
                    break label897;
                  }
                  i = 14;
                  paramf.dB(869, i);
                }
              }
              paramf = com.tencent.mm.modelstat.b.huc;
              ??? = this.roomId;
              bool1 = this.fqj;
              if ((paramf.aBz()) && (paramf.em(???)))
              {
                ??? = new IMBehavior();
                ???.opType = 1;
                ???.chattingOp = new IMBehaviorChattingOP();
                ??? = ???.chattingOp;
                if (!bool1) {
                  break label903;
                }
                i = j;
                ((IMBehaviorChattingOP)???).changeNotifyStatus = i;
              }
            }
            synchronized (paramf.lock)
            {
              paramf.hub.oplist_.add(???);
              Vk();
              continue;
              bool1 = false;
              break label647;
              label892:
              i = 1;
              break label669;
              i = 15;
              break label773;
              i = 2;
            }
          }
          if (paramf.equals("room_save_to_contact"))
          {
            if (this.sp == null) {
              this.sp = getSharedPreferences(getPackageName() + "_preferences", 0);
            }
            paramf = ((com.tencent.mm.plugin.messenger.foundation.a.k)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.messenger.foundation.a.k.class)).apM().aHY(this.roomId);
            if (paramf != null)
            {
              boolean bool2 = com.tencent.mm.n.b.ls(paramf.field_type);
              ??? = this.sp.edit();
              if (!bool2)
              {
                bool1 = true;
                ???.putBoolean("room_save_to_contact", bool1).commit();
                if (!bool2) {
                  break label1105;
                }
                paramf.Zl();
                com.tencent.mm.roomsdk.a.b.aEI(this.roomId).a(paramf, false);
                com.tencent.mm.ui.base.h.cf(this, getString(2131762677));
                com.tencent.mm.modelstat.b.huc.V(this.roomId, false);
              }
              for (;;)
              {
                this.screen.notifyDataSetChanged();
                break;
                bool1 = false;
                break label1024;
                label1105:
                com.tencent.mm.roomsdk.a.b.aEI(this.roomId).a(paramf, true);
                com.tencent.mm.ui.base.h.cf(this, getString(2131762693));
                com.tencent.mm.modelstat.b.huc.V(this.roomId, true);
              }
            }
          }
          else if (paramf.equals("room_placed_to_the_top"))
          {
            paramf = getSharedPreferences(this.fqx, 0);
            if (this.contact != null)
            {
              if (((com.tencent.mm.plugin.messenger.foundation.a.k)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.messenger.foundation.a.k.class)).apR().aIv(this.contact.field_username))
              {
                com.tencent.mm.model.w.D(this.contact.field_username, true);
                com.tencent.mm.modelstat.b.huc.c(false, this.roomId, false);
              }
              for (;;)
              {
                paramf.edit().putBoolean("room_placed_to_the_top", ((com.tencent.mm.plugin.messenger.foundation.a.k)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.messenger.foundation.a.k.class)).apR().aIv(this.contact.field_username)).commit();
                break;
                com.tencent.mm.model.w.C(this.contact.field_username, true);
                com.tencent.mm.modelstat.b.huc.c(false, this.roomId, true);
              }
            }
          }
          else if (paramf.equals("room_nickname"))
          {
            paramf = new Intent();
            paramf.setClass(this, ModRemarkRoomNameUI.class);
            paramf.putExtra("Key_Scenen", 3);
            paramf.putExtra("Key_Room_Id", this.roomId);
            startActivityForResult(paramf, 4);
          }
          else
          {
            if (paramf.equals("room_msg_show_username"))
            {
              paramf = getSharedPreferences(this.fqx, 0).edit();
              if (!this.fqe)
              {
                bool1 = true;
                label1391:
                paramf.putBoolean("room_msg_show_username", bool1).commit();
                if (this.fqe) {
                  break label1438;
                }
              }
              label1438:
              for (bool1 = true;; bool1 = false)
              {
                this.fqe = bool1;
                this.fqk = true;
                break;
                bool1 = false;
                break label1391;
              }
            }
            if (!paramf.equals("room_set_chatting_background")) {
              break;
            }
            if (com.tencent.mm.model.w.sn(this.roomId))
            {
              paramf = new com.tencent.mm.g.b.a.bg();
              paramf.hZ(this.roomId);
              paramf.dKc = 9L;
              paramf.aBj();
            }
            paramf = new Intent();
            paramf.putExtra("isApplyToAll", false);
            paramf.putExtra("username", this.contact.field_username);
            com.tencent.mm.bs.d.b(this, "setting", ".ui.setting.SettingsChattingBackgroundUI", paramf, 2);
          }
        }
      }
      if (paramf.equals("room_search_chatting_content"))
      {
        if (com.tencent.mm.model.w.sn(this.roomId))
        {
          paramf = new com.tencent.mm.g.b.a.bg();
          paramf.hZ(this.roomId);
          paramf.dKc = 8L;
          paramf.aBj();
        }
        paramf = new Intent();
        paramf.putExtra("detail_username", this.roomId);
        com.tencent.mm.plugin.fts.a.d.c(this, ".ui.FTSChattingConvUI", paramf);
        if ((this.fql == null) || (this.fql.awt() == null)) {
          break label3094;
        }
      }
      for (i = this.fql.awt().size();; i = 0)
      {
        for (;;)
        {
          com.tencent.mm.plugin.report.service.h.vKh.f(14569, new Object[] { Integer.valueOf(1), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(i), Integer.valueOf(1) });
          break;
          if (paramf.equals("room_clear_chatting_history"))
          {
            if (com.tencent.mm.model.w.sn(this.roomId))
            {
              paramf = new com.tencent.mm.g.b.a.bg();
              paramf.hZ(this.roomId);
              paramf.dKc = 11L;
              paramf.aBj();
            }
            paramf = getString(2131759504);
            com.tencent.mm.ui.base.h.a(getContext(), paramf, "", getString(2131755694), getString(2131755691), new DialogInterface.OnClickListener()
            {
              public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
              {
                AppMethodBeat.i(196578);
                com.tencent.mm.plugin.report.service.h.vKh.f(14553, new Object[] { Integer.valueOf(3), Integer.valueOf(2), ChatroomInfoUI.b(ChatroomInfoUI.this) });
                ChatroomInfoUI.cD(false);
                paramAnonymousDialogInterface = ChatroomInfoUI.this;
                ChatroomInfoUI.this.getString(2131755906);
                final com.tencent.mm.ui.base.p localp = com.tencent.mm.ui.base.h.b(paramAnonymousDialogInterface, ChatroomInfoUI.this.getString(2131755936), true, new ChatroomInfoUI.a());
                if (!ChatroomInfoUI.Vr()) {}
                for (paramAnonymousDialogInterface = com.tencent.mm.pluginsdk.wallet.d.aCU(ChatroomInfoUI.o(ChatroomInfoUI.this).field_username);; paramAnonymousDialogInterface = null)
                {
                  if (!bt.isNullOrNil(paramAnonymousDialogInterface))
                  {
                    localp.dismiss();
                    com.tencent.mm.ui.base.h.a(ChatroomInfoUI.this, false, ChatroomInfoUI.this.getString(2131765211, new Object[] { paramAnonymousDialogInterface }), null, ChatroomInfoUI.this.getString(2131760081), ChatroomInfoUI.this.getString(2131757424), new DialogInterface.OnClickListener()new DialogInterface.OnClickListener
                    {
                      public final void onClick(DialogInterface paramAnonymous2DialogInterface, int paramAnonymous2Int)
                      {
                        AppMethodBeat.i(196576);
                        com.tencent.mm.plugin.report.service.h.vKh.f(14553, new Object[] { Integer.valueOf(3), Integer.valueOf(4), ChatroomInfoUI.b(ChatroomInfoUI.this) });
                        ChatroomInfoUI.a(ChatroomInfoUI.this, true);
                        if (!ChatroomInfoUI.s(ChatroomInfoUI.this))
                        {
                          paramAnonymous2DialogInterface = new Intent();
                          paramAnonymous2DialogInterface.putExtra("Chat_User", ChatroomInfoUI.o(ChatroomInfoUI.this).field_username);
                          paramAnonymous2DialogInterface.addFlags(67108864);
                          com.tencent.mm.bs.d.e(ChatroomInfoUI.this, ".ui.chatting.ChattingUI", paramAnonymous2DialogInterface);
                          AppMethodBeat.o(196576);
                          return;
                        }
                        ChatroomInfoUI.this.finish();
                        AppMethodBeat.o(196576);
                      }
                    }, new DialogInterface.OnClickListener()
                    {
                      public final void onClick(DialogInterface paramAnonymous2DialogInterface, int paramAnonymous2Int)
                      {
                        AppMethodBeat.i(196577);
                        com.tencent.mm.plugin.report.service.h.vKh.f(14553, new Object[] { Integer.valueOf(3), Integer.valueOf(3), ChatroomInfoUI.b(ChatroomInfoUI.this) });
                        localp.show();
                        ChatroomInfoUI.a(ChatroomInfoUI.this, false);
                        ChatroomInfoUI.a(ChatroomInfoUI.this, localp);
                        AppMethodBeat.o(196577);
                      }
                    }, -1, 2131099904);
                    AppMethodBeat.o(196578);
                    return;
                  }
                  ChatroomInfoUI.a(ChatroomInfoUI.this, localp);
                  AppMethodBeat.o(196578);
                  return;
                }
              }
            }, null, 2131099904);
            break;
          }
          if (paramf.equals("room_report_it"))
          {
            if (com.tencent.mm.model.w.sn(this.roomId))
            {
              paramf = new com.tencent.mm.g.b.a.bg();
              paramf.hZ(this.roomId);
              paramf.dKc = 10L;
              paramf.aBj();
            }
            paramf = new Intent();
            paramf.putExtra("k_username", this.roomId);
            paramf.putExtra("showShare", false);
            paramf.putExtra("rawUrl", String.format("https://weixin110.qq.com/security/readtemplate?t=weixin_report/w_type&scene=%d#wechat_redirect", new Object[] { Integer.valueOf(36) }));
            com.tencent.mm.bs.d.b(this, "webview", ".ui.tools.WebViewUI", paramf);
            paramf = com.tencent.mm.modelstat.b.huc;
            ??? = this.roomId;
            if ((!paramf.aBz()) || (!paramf.em(???))) {
              break;
            }
            ??? = new IMBehavior();
            ((IMBehavior)???).opType = 1;
            ((IMBehavior)???).chattingOp = new IMBehaviorChattingOP();
            ((IMBehavior)???).chattingOp.expose = 1;
            synchronized (paramf.lock)
            {
              paramf.hub.oplist_.add(???);
            }
          }
        }
        if (paramf.equals("room_del_quit"))
        {
          ad.d("MicroMsg.ChatroomInfoUI", " quit " + this.roomId);
          paramf = new vj();
          paramf.dAP.dAR = true;
          com.tencent.mm.sdk.b.a.ESL.l(paramf);
          if ((!bt.isNullOrNil(this.roomId)) && (this.roomId.equals(paramf.dAQ.dAT)))
          {
            bool1 = true;
            label2128:
            if (!bool1) {
              break label2213;
            }
            ad.d("MicroMsg.ChatroomInfoUI", " quit talkroom" + this.roomId);
          }
          label2213:
          while ((!this.fqg) || (this.fql.awt().size() <= 2))
          {
            com.tencent.mm.ui.base.h.a(getContext(), getString(2131758025), "", getString(2131755835), getString(2131755691), new DialogInterface.OnClickListener()
            {
              public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
              {
                AppMethodBeat.i(12519);
                if ((ChatroomInfoUI.b(ChatroomInfoUI.this) == null) || (ChatroomInfoUI.b(ChatroomInfoUI.this).length() <= 0))
                {
                  ad.e("MicroMsg.ChatroomInfoUI", "quitChatRoom : invalid args");
                  AppMethodBeat.o(12519);
                  return;
                }
                if (bool1)
                {
                  paramAnonymousDialogInterface = new vj();
                  paramAnonymousDialogInterface.dAP.dAS = true;
                  com.tencent.mm.sdk.b.a.ESL.l(paramAnonymousDialogInterface);
                }
                if (!((com.tencent.mm.plugin.messenger.foundation.a.k)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.messenger.foundation.a.k.class)).apM().aIb(ChatroomInfoUI.b(ChatroomInfoUI.this)))
                {
                  ad.e("MicroMsg.ChatroomInfoUI", "quitChatRoom : room[" + ChatroomInfoUI.b(ChatroomInfoUI.this) + "] is not exist");
                  AppMethodBeat.o(12519);
                  return;
                }
                ChatroomInfoUI.t(ChatroomInfoUI.this);
                ((com.tencent.mm.plugin.multitalk.model.a)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.multitalk.model.a.class)).aho(ChatroomInfoUI.b(ChatroomInfoUI.this));
                AppMethodBeat.o(12519);
              }
            }, null, 2131099904);
            break;
            bool1 = false;
            break label2128;
          }
          paramf = getString(2131762665);
          ??? = new h.c()
          {
            public final void kM(int paramAnonymousInt)
            {
              AppMethodBeat.i(196581);
              switch (paramAnonymousInt)
              {
              default: 
                ad.d("MicroMsg.ChatroomInfoUI", "dz[dealQuitChatRoom owner click cancel]");
                AppMethodBeat.o(196581);
                return;
              }
              ad.d("MicroMsg.ChatroomInfoUI", "dz[dealQuitChatRoom owner click room_owner_delete_direct]");
              ChatroomInfoUI.t(ChatroomInfoUI.this);
              ((com.tencent.mm.plugin.multitalk.model.a)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.multitalk.model.a.class)).aho(ChatroomInfoUI.b(ChatroomInfoUI.this));
              AppMethodBeat.o(196581);
            }
          };
          com.tencent.mm.ui.base.h.a(this, "", new String[] { paramf }, "", ???);
          break;
        }
        if (paramf.equals("add_selector_btn"))
        {
          Vf();
          break;
        }
        if (paramf.equals("del_selector_btn"))
        {
          Vg();
          break;
        }
        if (paramf.equals("see_room_member"))
        {
          paramf = new Intent();
          paramf.setClass(getContext(), SeeRoomMemberUI.class);
          paramf.putExtra("Block_list", com.tencent.mm.model.u.aqG());
          ??? = com.tencent.mm.model.q.rW(this.roomId);
          if (??? != null) {
            this.fqi = ???.size();
          }
          paramf.putExtra("Chatroom_member_list", bt.n(???, ","));
          paramf.putExtra("RoomInfo_Id", this.roomId);
          paramf.putExtra("room_owner_name", this.fql.field_roomowner);
          paramf.putExtra("Is_RoomOwner", this.fqg);
          paramf.putExtra("room_member_count", this.fqi);
          paramf.putExtra("Add_address_titile", getString(2131762697));
          if (this.dph)
          {
            paramf.putExtra("Contact_Scene", 14);
            label2469:
            ??? = getListView().getChildAt(0);
            if (??? != null) {
              break label2579;
            }
          }
          for (i = 0;; i = -???.getTop())
          {
            paramf.putExtra("offset", i);
            paramf.putExtra("first_pos", getListView().getFirstVisiblePosition());
            paramf.putExtra("room_name", this.contact.field_username);
            startActivityForResult(paramf, 5);
            this.fqv = 5;
            break;
            if (!this.fpQ) {
              break label2469;
            }
            paramf.putExtra("Contact_Scene", 44);
            if (com.tencent.mm.model.u.se(this.contact.field_username)) {
              break label2469;
            }
            paramf.putExtra("Contact_IsLBSFriend", true);
            break label2469;
          }
        }
        if (paramf.equals("manage_room"))
        {
          if (this.fqr) {
            com.tencent.mm.plugin.newtips.a.cWs().Ip(26);
          }
          paramf = new Intent();
          paramf.setClass(getContext(), ManageChatroomUI.class);
          paramf.putExtra("RoomInfo_Id", this.roomId);
          paramf.putExtra("room_owner_name", this.fql.field_roomowner);
          paramf = new com.tencent.mm.hellhoundlib.b.a().bd(paramf);
          com.tencent.mm.hellhoundlib.a.a.a(this, paramf.adn(), "com/tencent/mm/chatroom/ui/ChatroomInfoUI", "goToManageChatroomUI", "()V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
          startActivity((Intent)paramf.lS(0));
          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/chatroom/ui/ChatroomInfoUI", "goToManageChatroomUI", "()V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
          break;
        }
        if (paramf.equals("chat_room_app_brand"))
        {
          if (com.tencent.mm.model.w.sn(this.roomId))
          {
            paramf = new com.tencent.mm.g.b.a.bg();
            paramf.hZ(this.roomId);
            paramf.dKc = 7L;
            paramf.aBj();
          }
          paramf = new Intent();
          paramf.putExtra("Chat_User", this.roomId);
          com.tencent.mm.bs.d.e(this, ".ui.chatting.gallery.AppBrandHistoryListUI", paramf);
          com.tencent.mm.plugin.report.service.h.vKh.idkeyStat(219L, 25L, 1L, true);
          break;
        }
        if (paramf.equals("room_manager_view"))
        {
          paramf = new Intent();
          paramf.setClass(getContext(), SeeRoomOwnerManagerUI.class);
          paramf.putExtra("RoomInfo_Id", this.roomId);
          paramf.putExtra("room_owner_name", this.fql.field_roomowner);
          paramf = new com.tencent.mm.hellhoundlib.b.a().bd(paramf);
          com.tencent.mm.hellhoundlib.a.a.a(this, paramf.adn(), "com/tencent/mm/chatroom/ui/ChatroomInfoUI", "goToOwnerManageChatroomUI", "()V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
          startActivity((Intent)paramf.lS(0));
          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/chatroom/ui/ChatroomInfoUI", "goToOwnerManageChatroomUI", "()V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
          break;
        }
        if ((paramf.equals("chat_room_story_videos")) || (!paramf.equals("room_remark"))) {
          break;
        }
        paramf = new Intent();
        paramf.setClass(this, ModRemarkRoomNameUI.class);
        paramf.putExtra("Key_Scenen", 2);
        paramf.putExtra("Key_Room_Id", this.roomId);
        paramf = new com.tencent.mm.hellhoundlib.b.a().bd(paramf);
        com.tencent.mm.hellhoundlib.a.a.a(this, paramf.adn(), "com/tencent/mm/chatroom/ui/ChatroomInfoUI", "dealModChatroomRemark", "()V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
        startActivity((Intent)paramf.lS(0));
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/chatroom/ui/ChatroomInfoUI", "dealModChatroomRemark", "()V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
        break;
      }
    }
  }
  
  public void onResume()
  {
    AppMethodBeat.i(12564);
    super.onResume();
    this.screen.notifyDataSetChanged();
    Object localObject1;
    boolean bool;
    if (this.fql != null)
    {
      localObject1 = this.fql.eKt();
      if (localObject1 != null)
      {
        bool = com.tencent.mm.model.q.U(this.fql.field_chatroomname, ((com.tencent.mm.j.a.a.a)localObject1).fyn);
        ad.i("MicroMsg.ChatroomInfoUI", "roomId:%s newVer:%s localVer:%s owner:%s", new Object[] { this.fql.field_chatroomname, Integer.valueOf(((com.tencent.mm.j.a.a.a)localObject1).fyn), Integer.valueOf(this.fql.field_chatroomVersion), this.fql.field_roomowner });
      }
    }
    for (;;)
    {
      if ((com.tencent.mm.model.q.rR(this.roomId)) || (bool)) {
        Vd();
      }
      Vl();
      updateTitle();
      Vk();
      Object localObject2;
      if (this.dph)
      {
        Vm();
        if (this.contact != null)
        {
          this.fql = ((com.tencent.mm.plugin.chatroom.a.c)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.chatroom.a.c.class)).apV().tH(this.roomId);
          if (this.fql != null) {
            break label510;
          }
          localObject2 = "";
          localObject1 = localObject2;
          if (bt.isNullOrNil((String)localObject2)) {
            localObject1 = com.tencent.mm.model.u.aqI();
          }
          if (bt.isNullOrNil((String)localObject1)) {
            break label521;
          }
          this.fqa.eTC();
          this.fqa.Gfn = com.tencent.mm.cd.a.ao(getContext(), 2131165587);
          KeyValuePreference localKeyValuePreference = this.fqa;
          localObject2 = localObject1;
          if (((String)localObject1).length() <= 0) {
            localObject2 = getString(2131763409);
          }
          localKeyValuePreference.setSummary(com.tencent.mm.pluginsdk.ui.span.k.c(this, (CharSequence)localObject2));
          label271:
          if (this.screen != null) {
            this.screen.notifyDataSetChanged();
          }
        }
        if ((this.contact != null) && (this.fqb != null))
        {
          this.contact = ((com.tencent.mm.plugin.messenger.foundation.a.k)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.messenger.foundation.a.k.class)).apM().aHY(this.roomId);
          this.fqb.eTC();
          if (!af.aHI(this.roomId)) {
            break label533;
          }
          this.screen.d(this.fqb);
        }
      }
      for (;;)
      {
        if (this.fqn)
        {
          Vj();
          this.fqn = false;
        }
        localObject1 = getIntent().getStringExtra("need_matte_high_light_item");
        if (!this.fqt)
        {
          if (!bt.isNullOrNil((String)localObject1)) {
            oR((String)localObject1);
          }
          this.fqt = true;
        }
        if ((!bt.isNullOrNil((String)localObject1)) && (((String)localObject1).equals("room_notify_new_notice")) && (!this.fqt))
        {
          oR("room_card");
          this.fqt = true;
        }
        com.tencent.mm.plugin.newtips.a.cWs().Io(26);
        ad.d("MicroMsg.ChatroomInfoUI", "showSetMuteAnimation isShowSetMuteAnimation[%b]", new Object[] { Boolean.valueOf(this.fqp) });
        if (this.fqp)
        {
          this.fqp = false;
          aq.n(new Runnable()
          {
            public final void run()
            {
              AppMethodBeat.i(196600);
              ChatroomInfoUI.b(ChatroomInfoUI.this, "room_notify_new_msg");
              ChatroomInfoUI.z(ChatroomInfoUI.this);
              AppMethodBeat.o(196600);
            }
          }, 50L);
        }
        AppMethodBeat.o(12564);
        return;
        label510:
        localObject2 = this.fql.field_selfDisplayName;
        break;
        label521:
        this.fqa.setSummary("");
        break label271;
        label533:
        if (!bt.isNullOrNil(this.contact.field_conRemark))
        {
          localObject1 = this.contact.field_conRemark;
          this.fqb.setSummary(com.tencent.mm.pluginsdk.ui.span.k.c(this, (CharSequence)localObject1));
          if (this.screen != null) {
            this.screen.notifyDataSetChanged();
          }
        }
        else
        {
          this.fqb.setSummary("");
        }
      }
      bool = false;
    }
  }
  
  public void onSceneEnd(int paramInt1, int paramInt2, String paramString, com.tencent.mm.al.n paramn)
  {
    AppMethodBeat.i(12594);
    ad.i("MicroMsg.ChatroomInfoUI", "onSceneEnd: errType = " + paramInt1 + " errCode = " + paramInt2 + " errMsg = " + paramString);
    ad.d("MicroMsg.ChatroomInfoUI", "pre is " + this.fqi);
    this.fqi = com.tencent.mm.model.q.rY(this.roomId);
    ad.d("MicroMsg.ChatroomInfoUI", "now is " + this.fqi);
    if (this.fpP != null) {
      this.fpP.dismiss();
    }
    AppMethodBeat.o(12594);
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
  
  static final class a
    implements DialogInterface.OnCancelListener
  {
    public final void onCancel(DialogInterface paramDialogInterface)
    {
      AppMethodBeat.i(12560);
      ChatroomInfoUI.cD(true);
      AppMethodBeat.o(12560);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.chatroom.ui.ChatroomInfoUI
 * JD-Core Version:    0.7.0.1
 */