package com.tencent.mm.chatroom.ui;

import android.app.Activity;
import android.app.ProgressDialog;
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
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
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
import com.tencent.mm.chatroom.g.a.b;
import com.tencent.mm.chatroom.ui.preference.RoomCardPreference;
import com.tencent.mm.g.a.it;
import com.tencent.mm.g.a.mp;
import com.tencent.mm.g.a.mp.b;
import com.tencent.mm.g.a.tk;
import com.tencent.mm.g.a.wm;
import com.tencent.mm.g.a.wm.b;
import com.tencent.mm.g.a.xm;
import com.tencent.mm.g.b.a.dm;
import com.tencent.mm.g.c.aw;
import com.tencent.mm.model.ak;
import com.tencent.mm.model.as.a;
import com.tencent.mm.model.as.b;
import com.tencent.mm.model.as.b.a;
import com.tencent.mm.model.bj.a;
import com.tencent.mm.model.w;
import com.tencent.mm.plugin.messenger.foundation.a.l;
import com.tencent.mm.plugin.newtips.NewTipPreference;
import com.tencent.mm.plugin.report.kvdata.IMBehavior;
import com.tencent.mm.plugin.report.kvdata.IMBehaviorChattingOP;
import com.tencent.mm.plugin.report.kvdata.log_13835;
import com.tencent.mm.pluginsdk.ui.applet.ContactListExpandPreference;
import com.tencent.mm.pluginsdk.ui.applet.ContactListExpandPreference.a;
import com.tencent.mm.pluginsdk.ui.applet.r;
import com.tencent.mm.pluginsdk.ui.applet.s.b;
import com.tencent.mm.pluginsdk.ui.span.k;
import com.tencent.mm.protocal.protobuf.btq;
import com.tencent.mm.sdk.e.k.a;
import com.tencent.mm.sdk.e.m;
import com.tencent.mm.sdk.e.n.b;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.ap;
import com.tencent.mm.sdk.platformtools.aq;
import com.tencent.mm.sdk.platformtools.av;
import com.tencent.mm.sdk.platformtools.av.a;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.storage.ab;
import com.tencent.mm.storage.ai;
import com.tencent.mm.storage.am;
import com.tencent.mm.storage.bp;
import com.tencent.mm.storage.bq;
import com.tencent.mm.storage.cf;
import com.tencent.mm.ui.base.h.c;
import com.tencent.mm.ui.base.p;
import com.tencent.mm.ui.base.preference.CheckBoxPreference;
import com.tencent.mm.ui.base.preference.KeyValuePreference;
import com.tencent.mm.ui.base.preference.MMPreference;
import com.tencent.mm.ui.base.preference.NormalIconPreference;
import com.tencent.mm.ui.base.preference.Preference;
import com.tencent.mm.ui.base.preference.PreferenceCategory;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import junit.framework.Assert;

@com.tencent.mm.kernel.i
public class ChatroomInfoUI
  extends MMPreference
  implements com.tencent.mm.al.f, com.tencent.mm.bi.a, a.b, k.a, n.b
{
  private static boolean fNd = false;
  private am contact;
  private boolean dyF;
  private ab fLO;
  private NormalIconPreference fMA;
  private NormalIconPreference fMB;
  private ContactListExpandPreference fMC;
  private CheckBoxPreference fMD;
  private CheckBoxPreference fME;
  private CheckBoxPreference fMF;
  private KeyValuePreference fMG;
  private KeyValuePreference fMH;
  private CheckBoxPreference fMI;
  private NewTipPreference fMJ;
  private boolean fMK;
  private boolean fML;
  private boolean fMM;
  private boolean fMN;
  private int fMO;
  private boolean fMP;
  private boolean fMQ;
  private int fMR;
  private boolean fMS;
  private boolean fMT;
  private boolean fMU;
  private boolean fMV;
  private boolean fMW;
  private com.tencent.mm.pluginsdk.ui.e fMX;
  boolean fMY;
  private com.tencent.mm.sdk.b.c fMZ;
  private ProgressDialog fMu;
  private ProgressDialog fMv;
  private boolean fMw;
  private RoomCardPreference fMx;
  private Preference fMy;
  private Preference fMz;
  int fNa;
  private p fNb;
  private String fNc;
  private com.tencent.mm.roomsdk.a.c.a fNe;
  private String fNf;
  private com.tencent.mm.pluginsdk.c.b fNg;
  private av fNh;
  private int fNi;
  private ap handler;
  private boolean isDeleteCancel;
  private String roomId;
  private com.tencent.mm.ui.base.preference.f screen;
  private SharedPreferences sp;
  
  public ChatroomInfoUI()
  {
    AppMethodBeat.i(12561);
    this.fMu = null;
    this.fMv = null;
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
    this.fMM = false;
    this.fMN = false;
    this.fMQ = false;
    this.fLO = null;
    this.fMR = -1;
    this.fMS = true;
    this.fMT = false;
    this.fMU = false;
    this.fMV = false;
    this.fMW = false;
    this.fMX = new com.tencent.mm.pluginsdk.ui.e(new AbsListView.OnScrollListener()
    {
      public final void onScroll(AbsListView paramAnonymousAbsListView, int paramAnonymousInt1, int paramAnonymousInt2, int paramAnonymousInt3) {}
      
      public final void onScrollStateChanged(AbsListView paramAnonymousAbsListView, int paramAnonymousInt) {}
    });
    this.fMY = false;
    this.fMZ = new com.tencent.mm.sdk.b.c() {};
    this.fNa = -1;
    this.fNb = null;
    this.fNc = "";
    this.fNe = null;
    this.fNf = null;
    this.fNg = new com.tencent.mm.pluginsdk.c.b()
    {
      public final void a(int paramAnonymousInt1, int paramAnonymousInt2, String paramAnonymousString, com.tencent.mm.sdk.b.b paramAnonymousb)
      {
        AppMethodBeat.i(213456);
        if ((paramAnonymousb instanceof mp))
        {
          paramAnonymousb = (mp)paramAnonymousb;
          ad.i("MicroMsg.ChatroomInfoUI", "onSceneEnd: errType = " + paramAnonymousInt1 + " errCode = " + paramAnonymousInt2 + " errMsg = " + paramAnonymousString);
          if (ChatroomInfoUI.z(ChatroomInfoUI.this) != null) {
            ChatroomInfoUI.z(ChatroomInfoUI.this).dismiss();
          }
          if ((paramAnonymousInt1 != 0) || (paramAnonymousInt2 != 0))
          {
            if (paramAnonymousInt2 == -21)
            {
              com.tencent.mm.ui.base.h.d(ChatroomInfoUI.this, ChatroomInfoUI.this.getString(2131762626), ChatroomInfoUI.this.getString(2131755906), new DialogInterface.OnClickListener()
              {
                public final void onClick(DialogInterface paramAnonymous2DialogInterface, int paramAnonymous2Int)
                {
                  AppMethodBeat.i(213455);
                  ChatroomInfoUI.this.finish();
                  AppMethodBeat.o(213455);
                }
              });
              AppMethodBeat.o(213456);
              return;
            }
            com.tencent.mm.ui.base.h.c(ChatroomInfoUI.this, ChatroomInfoUI.this.getString(2131762628), ChatroomInfoUI.this.getString(2131755906), true);
            AppMethodBeat.o(213456);
            return;
          }
          if ((paramAnonymousInt1 == 0) && (paramAnonymousInt2 == 0) && (ChatroomInfoUI.m(ChatroomInfoUI.this) != null))
          {
            paramAnonymousString = ChatroomInfoUI.R(paramAnonymousb.dAy.dAk);
            paramAnonymousb = ChatroomInfoUI.m(ChatroomInfoUI.this);
            if (paramAnonymousb.EWM != null)
            {
              paramAnonymousb = paramAnonymousb.EWM.EWc;
              paramAnonymousb.aO(paramAnonymousString);
              paramAnonymousb.Zd();
            }
            if (ChatroomInfoUI.f(ChatroomInfoUI.this) != null) {
              ChatroomInfoUI.f(ChatroomInfoUI.this).notifyDataSetChanged();
            }
            ChatroomInfoUI.this.setMMTitle(ChatroomInfoUI.this.getResources().getQuantityString(2131623963, paramAnonymousString.size(), new Object[] { Integer.valueOf(paramAnonymousString.size()) }));
          }
          ChatroomInfoUI.j(ChatroomInfoUI.this);
        }
        AppMethodBeat.o(213456);
      }
    };
    this.isDeleteCancel = false;
    this.fNh = null;
    this.fNi = 0;
    AppMethodBeat.o(12561);
  }
  
  public static ArrayList<am> R(List<btq> paramList)
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
      btq localbtq = (btq)paramList.next();
      am localam = new am();
      localam.setUsername(localbtq.nDo);
      localam.sT(localbtq.nEt);
      localArrayList.add(localam);
    }
    AppMethodBeat.o(12590);
    return localArrayList;
  }
  
  private String YA()
  {
    AppMethodBeat.i(12579);
    am localam = ((l)com.tencent.mm.kernel.g.ab(l.class)).azp().Bf(this.fLO.field_roomowner);
    if ((localam != null) && ((int)localam.gfj > 0)) {}
    for (Object localObject2 = localam.field_conRemark;; localObject2 = null)
    {
      Object localObject1 = localObject2;
      if (bt.isNullOrNil((String)localObject2)) {
        localObject1 = uU(this.fLO.field_roomowner);
      }
      localObject2 = localObject1;
      if (bt.isNullOrNil((String)localObject1))
      {
        localObject2 = localObject1;
        if (localam != null)
        {
          localObject2 = localObject1;
          if ((int)localam.gfj > 0) {
            localObject2 = localam.adu();
          }
        }
      }
      localObject1 = localObject2;
      if (bt.isNullOrNil((String)localObject2)) {
        localObject1 = this.fLO.field_roomowner;
      }
      AppMethodBeat.o(12579);
      return localObject1;
    }
  }
  
  private void YB()
  {
    AppMethodBeat.i(12584);
    if (this.fMC != null)
    {
      if (this.dyF)
      {
        com.tencent.e.h.LTJ.aR(new Runnable()
        {
          public final void run()
          {
            AppMethodBeat.i(213454);
            if (ChatroomInfoUI.c(ChatroomInfoUI.this) == null)
            {
              ad.w("MicroMsg.ChatroomInfoUI", "[updateRoomPref] member == null");
              AppMethodBeat.o(213454);
              return;
            }
            ChatroomInfoUI.a(ChatroomInfoUI.this, ((com.tencent.mm.plugin.chatroom.a.c)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.chatroom.a.c.class)).azz().AQ(ChatroomInfoUI.b(ChatroomInfoUI.this)));
            Object localObject1 = com.tencent.mm.model.q.yQ(ChatroomInfoUI.b(ChatroomInfoUI.this));
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
                if ((ChatroomInfoUI.c(ChatroomInfoUI.this).aSH(str)) || (ChatroomInfoUI.c(ChatroomInfoUI.this).Az(str))) {
                  ((LinkedList)localObject3).add(str);
                }
              }
              localObject1 = new LinkedList();
              ChatroomInfoUI.a(ChatroomInfoUI.this, 0);
            }
            Object localObject2 = localObject1;
            if (ChatroomInfoUI.e(ChatroomInfoUI.this) > r.MAX_COUNT + 1)
            {
              localObject2 = localObject1;
              if (localObject1 != null)
              {
                localObject1 = ((List)localObject1).subList(0, r.MAX_COUNT + 1);
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
            com.tencent.e.h.LTJ.aP(new Runnable()
            {
              public final void run()
              {
                AppMethodBeat.i(213453);
                if (ChatroomInfoUI.e(ChatroomInfoUI.this) <= 1)
                {
                  ChatroomInfoUI.f(ChatroomInfoUI.this).cP("del_selector_btn", true);
                  ChatroomInfoUI.m(ChatroomInfoUI.this).vO(true).vP(false).fcK();
                }
                for (;;)
                {
                  ChatroomInfoUI.m(ChatroomInfoUI.this).A(ChatroomInfoUI.b(ChatroomInfoUI.this), this.fNt);
                  ChatroomInfoUI.m(ChatroomInfoUI.this).vN(true);
                  AppMethodBeat.o(213453);
                  return;
                  ChatroomInfoUI.m(ChatroomInfoUI.this).vO(true).vP(ChatroomInfoUI.d(ChatroomInfoUI.this)).fcK();
                }
              }
            });
            AppMethodBeat.o(213454);
          }
        });
        AppMethodBeat.o(12584);
        return;
      }
      LinkedList localLinkedList = new LinkedList();
      localLinkedList.add(this.roomId);
      this.fMC.A(this.roomId, localLinkedList);
    }
    AppMethodBeat.o(12584);
  }
  
  private void YC()
  {
    AppMethodBeat.i(12586);
    if (this.sp == null) {
      this.sp = getSharedPreferences(getPackageName() + "_preferences", 0);
    }
    boolean bool;
    if (this.contact != null)
    {
      if (!this.dyF) {
        break label140;
      }
      if (this.contact.ePs == 0)
      {
        bool = true;
        this.fMP = bool;
      }
    }
    else
    {
      label76:
      if (!this.fMP) {
        break label161;
      }
      setTitleMuteIconVisibility(0);
      if (this.fMD != null) {
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
      if (this.fMw) {
        break label76;
      }
      this.fMP = this.contact.Pf();
      break label76;
      label161:
      setTitleMuteIconVisibility(8);
      if (this.fMD != null) {
        this.sp.edit().putBoolean("room_notify_new_msg", false).commit();
      }
    }
  }
  
  private void YD()
  {
    AppMethodBeat.i(12587);
    Object localObject;
    RoomCardPreference localRoomCardPreference;
    if ((this.contact != null) && (this.fMx != null))
    {
      localObject = com.tencent.mm.model.q.yU(this.roomId);
      if ((localObject != null) && (((String)localObject).length() > 0)) {
        break label136;
      }
      this.fMx.dmo = false;
      this.contact = ((l)com.tencent.mm.kernel.g.ab(l.class)).azp().Bf(this.roomId);
      if (!YF()) {
        break label159;
      }
      String str = this.contact.adv();
      localRoomCardPreference = this.fMx;
      localObject = str;
      if (str.length() <= 0) {
        localObject = getString(2131763409);
      }
    }
    label136:
    label159:
    for (localRoomCardPreference.fUT = k.c(this, (CharSequence)localObject);; this.fMx.fUT = getString(2131762622))
    {
      this.screen.notifyDataSetChanged();
      AppMethodBeat.o(12587);
      return;
      this.fMx.dmo = true;
      this.fMx.fUU = k.c(this, (CharSequence)localObject);
      break;
    }
  }
  
  private void YE()
  {
    AppMethodBeat.i(12588);
    if ((this.contact != null) && (this.fMy != null))
    {
      this.contact = ((l)com.tencent.mm.kernel.g.ab(l.class)).azp().Bf(this.roomId);
      if (YF())
      {
        String str2 = this.contact.adu();
        Preference localPreference = this.fMy;
        String str1 = str2;
        if (str2.length() <= 0) {
          str1 = getString(2131763409);
        }
        localPreference.setSummary(k.c(this, str1));
        if (this.screen != null) {
          this.screen.notifyDataSetChanged();
        }
        AppMethodBeat.o(12588);
        return;
      }
      this.fMy.setSummary(getString(2131762622));
    }
    AppMethodBeat.o(12588);
  }
  
  private boolean YF()
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
  
  private void YG()
  {
    AppMethodBeat.i(12591);
    com.tencent.mm.plugin.report.service.g.yhR.kvStat(10170, "1");
    Object localObject = new LinkedList();
    ((List)localObject).add(this.roomId);
    ((List)localObject).add(com.tencent.mm.model.u.aAm());
    localObject = bt.m((List)localObject, ",");
    Intent localIntent = new Intent();
    localIntent.putExtra("titile", getString(2131755232));
    localIntent.putExtra("list_type", 0);
    localIntent.putExtra("list_attr", lb(com.tencent.mm.ui.contact.u.Knz));
    localIntent.putExtra("always_select_contact", (String)localObject);
    localIntent.putExtra("create_group_recommend", true);
    com.tencent.mm.bs.d.f(this, ".ui.contact.SelectContactUI", localIntent);
    AppMethodBeat.o(12591);
  }
  
  private boolean YH()
  {
    AppMethodBeat.i(12600);
    if ((this.fLO != null) && (this.fLO.YH()))
    {
      AppMethodBeat.o(12600);
      return true;
    }
    AppMethodBeat.o(12600);
    return false;
  }
  
  private void Yu()
  {
    AppMethodBeat.i(12563);
    ad.i("MicroMsg.ChatroomInfoUI", "[doChatroomDetailCgi] :%s", new Object[] { this.roomId });
    com.tencent.mm.roomsdk.a.c.a locala = com.tencent.mm.roomsdk.a.b.aPF(this.roomId).uH(this.roomId);
    locala.b(new com.tencent.mm.roomsdk.a.b.b() {});
    locala.cyR();
    AppMethodBeat.o(12563);
  }
  
  private void Yv()
  {
    AppMethodBeat.i(213469);
    if (this.fMv == null)
    {
      getString(2131755906);
      this.fMv = com.tencent.mm.ui.base.h.b(this, getString(2131755936), false, new DialogInterface.OnCancelListener()
      {
        public final void onCancel(DialogInterface paramAnonymousDialogInterface)
        {
          AppMethodBeat.i(213445);
          ChatroomInfoUI.a(ChatroomInfoUI.this, true);
          AppMethodBeat.o(213445);
        }
      });
      AppMethodBeat.o(213469);
      return;
    }
    this.fMv.show();
    AppMethodBeat.o(213469);
  }
  
  private void Yw()
  {
    AppMethodBeat.i(213470);
    if (this.fMv != null) {
      this.fMv.dismiss();
    }
    AppMethodBeat.o(213470);
  }
  
  private void Yx()
  {
    AppMethodBeat.i(12573);
    com.tencent.mm.plugin.report.service.g.yhR.idkeyStat(219L, 7L, 1L, true);
    Object localObject = com.tencent.mm.model.q.yQ(this.roomId);
    String str = bt.m((List)localObject, ",");
    if (localObject != null) {
      this.fMO = ((List)localObject).size();
    }
    localObject = new Intent();
    ((Intent)localObject).putExtra("titile", getString(2131755234));
    ((Intent)localObject).putExtra("list_type", 1);
    ((Intent)localObject).putExtra("list_attr", lb(com.tencent.mm.ui.contact.u.Kny));
    ((Intent)localObject).putExtra("always_select_contact", str);
    ((Intent)localObject).putExtra("scene", 3);
    boolean bool = w.zn(this.contact.field_username);
    if ((!am.aSR(this.contact.field_username)) && (!bool)) {
      ((Intent)localObject).putExtra("without_openim", true);
    }
    if ((w.zk(this.roomId)) && (!bool)) {}
    for (bool = true;; bool = false)
    {
      ((Intent)localObject).putExtra("KBlockOpenImFav", bool);
      ((Intent)localObject).putExtra("create_group_recommend", true);
      ((Intent)localObject).putExtra("is_select_record_msg_mode", w.zk(this.roomId));
      ((Intent)localObject).putExtra("menu_mode", 2);
      ((Intent)localObject).putExtra("chatroomName", this.roomId);
      com.tencent.mm.bs.d.c(this, ".ui.contact.SelectContactUI", (Intent)localObject, 1);
      AppMethodBeat.o(12573);
      return;
    }
  }
  
  private void Yy()
  {
    AppMethodBeat.i(12574);
    if (this.dyF)
    {
      Yx();
      AppMethodBeat.o(12574);
      return;
    }
    YG();
    AppMethodBeat.o(12574);
  }
  
  private void Yz()
  {
    AppMethodBeat.i(12576);
    com.tencent.mm.plugin.report.service.g.yhR.idkeyStat(219L, 8L, 1L, true);
    Object localObject = com.tencent.mm.model.q.yQ(this.roomId);
    String str = bt.m((List)localObject, ",");
    this.fMO = ((List)localObject).size();
    localObject = new Intent();
    ((Intent)localObject).putExtra("RoomInfo_Id", this.roomId);
    ((Intent)localObject).putExtra("Is_Chatroom", true);
    ((Intent)localObject).putExtra("Chatroom_member_list", str);
    ((Intent)localObject).putExtra("room_member_count", this.fMO);
    ((Intent)localObject).putExtra("Is_RoomOwner", this.fMM);
    ((Intent)localObject).putExtra("list_attr", com.tencent.mm.ui.contact.u.Kny);
    ((Intent)localObject).putExtra("room_name", this.contact.field_username);
    ((Intent)localObject).putExtra("room_owner_name", this.fLO.field_roomowner);
    ((Intent)localObject).setClass(this, SelectDelMemberUI.class);
    startActivityForResult((Intent)localObject, 7);
    AppMethodBeat.o(12576);
  }
  
  private int lb(int paramInt)
  {
    AppMethodBeat.i(12575);
    if (!com.tencent.mm.ui.contact.u.fIr())
    {
      AppMethodBeat.o(12575);
      return paramInt;
    }
    if (this.contact != null)
    {
      String str = this.contact.field_username;
      if ((am.aSQ(str)) || (am.aSR(str)) || (w.zn(str)))
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
  
  private void uS(String paramString)
  {
    AppMethodBeat.i(12566);
    final int i = this.screen.aVF(paramString);
    paramString = getListView();
    com.tencent.mm.hellhoundlib.b.a locala = com.tencent.mm.hellhoundlib.b.c.a(i, new com.tencent.mm.hellhoundlib.b.a());
    com.tencent.mm.hellhoundlib.a.a.a(paramString, locala.ahp(), "com/tencent/mm/chatroom/ui/ChatroomInfoUI", "MatteHighLightItem", "(Ljava/lang/String;)V", "Undefined", "smoothScrollToPosition", "(I)V");
    paramString.smoothScrollToPosition(((Integer)locala.mq(0)).intValue());
    com.tencent.mm.hellhoundlib.a.a.a(paramString, "com/tencent/mm/chatroom/ui/ChatroomInfoUI", "MatteHighLightItem", "(Ljava/lang/String;)V", "Undefined", "smoothScrollToPosition", "(I)V");
    new ap().postDelayed(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(12558);
        View localView = ((com.tencent.mm.ui.base.preference.a)ChatroomInfoUI.f(ChatroomInfoUI.this)).a(i, ChatroomInfoUI.this.getListView());
        if (localView != null) {
          com.tencent.mm.ui.h.a.c(ChatroomInfoUI.this.getContext(), localView);
        }
        AppMethodBeat.o(12558);
      }
    }, 10L);
    AppMethodBeat.o(12566);
  }
  
  private String uU(String paramString)
  {
    AppMethodBeat.i(12578);
    if (this.fLO == null)
    {
      AppMethodBeat.o(12578);
      return null;
    }
    paramString = this.fLO.zf(paramString);
    AppMethodBeat.o(12578);
    return paramString;
  }
  
  private void updateTitle()
  {
    AppMethodBeat.i(12583);
    if (this.dyF)
    {
      this.fMO = com.tencent.mm.model.q.yS(this.roomId);
      if (this.fMO == 0)
      {
        setMMTitle(getString(2131762729));
        AppMethodBeat.o(12583);
        return;
      }
      setMMTitle(getString(2131759496, new Object[] { getString(2131762729), Integer.valueOf(this.fMO) }));
    }
    AppMethodBeat.o(12583);
  }
  
  public final void Yl()
  {
    AppMethodBeat.i(213473);
    boolean bool;
    Object localObject;
    if (this.fMC != null)
    {
      if (this.dyF)
      {
        YB();
        this.fMC.notifyChanged();
      }
    }
    else
    {
      bool = ((com.tencent.mm.plugin.chatroom.a.c)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.chatroom.a.c.class)).ZA(this.roomId);
      if (YH()) {
        break label243;
      }
      this.screen.cP("manage_room", true);
      localObject = this.screen;
      if (bool) {
        break label238;
      }
      bool = true;
      label82:
      ((com.tencent.mm.ui.base.preference.f)localObject).cP("room_manager_view", bool);
      label93:
      if (((YH()) || (this.fMO < r.MAX_COUNT)) && ((!YH()) || (this.fMO < r.MAX_COUNT - 1))) {
        break label274;
      }
      this.screen.cP("see_room_member", false);
      this.fMz.setTitle(getString(2131762973));
    }
    for (;;)
    {
      if (w.zl(this.roomId)) {
        this.screen.cP("room_manager_view", true);
      }
      this.screen.notifyDataSetChanged();
      AppMethodBeat.o(213473);
      return;
      if (this.fMw) {
        break;
      }
      localObject = new LinkedList();
      ((List)localObject).add(this.roomId);
      this.fMC.A(this.roomId, (List)localObject);
      break;
      label238:
      bool = false;
      break label82;
      label243:
      this.screen.cP("room_manager_view", true);
      this.screen.cP("manage_room", false);
      break label93;
      label274:
      this.screen.cP("see_room_member", true);
    }
  }
  
  public final void Ym()
  {
    AppMethodBeat.i(213472);
    updateTitle();
    if (this.fLO != null) {
      this.fMO = this.fLO.aGo().size();
    }
    if (((!this.fMM) && (this.fMO >= r.MAX_COUNT)) || ((this.fMM) && (this.fMO >= r.MAX_COUNT - 1)))
    {
      this.screen.cP("see_room_member", false);
      this.fMz.setTitle(getString(2131762973));
    }
    AppMethodBeat.o(213472);
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
  
  public final void a(String paramString, m paramm)
  {
    AppMethodBeat.i(12597);
    if (bt.isNullOrNil(paramString))
    {
      AppMethodBeat.o(12597);
      return;
    }
    if (!w.vF(paramString))
    {
      ad.d("MicroMsg.ChatroomInfoUI", "event:" + paramString + " cancel");
      AppMethodBeat.o(12597);
      return;
    }
    ad.d("MicroMsg.ChatroomInfoUI", "event:".concat(String.valueOf(paramString)));
    if ((this.dyF) && (paramString.equals(this.roomId))) {
      com.tencent.mm.kernel.g.ajF().ay(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(213458);
          ChatroomInfoUI.a(ChatroomInfoUI.this, ((com.tencent.mm.plugin.chatroom.a.c)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.chatroom.a.c.class)).azz().AN(ChatroomInfoUI.b(ChatroomInfoUI.this)));
          if (ChatroomInfoUI.c(ChatroomInfoUI.this) == null)
          {
            ad.e("MicroMsg.ChatroomInfoUI", "member is null");
            AppMethodBeat.o(213458);
            return;
          }
          if (bt.isNullOrNil(ChatroomInfoUI.c(ChatroomInfoUI.this).field_roomowner))
          {
            ad.e("MicroMsg.ChatroomInfoUI", "roomowner is null");
            AppMethodBeat.o(213458);
            return;
          }
          ChatroomInfoUI.A(ChatroomInfoUI.this).sendEmptyMessage(0);
          ChatroomInfoUI.b(ChatroomInfoUI.this, ChatroomInfoUI.c(ChatroomInfoUI.this).field_roomowner.equals(com.tencent.mm.model.u.aAm()));
          ChatroomInfoUI.c(ChatroomInfoUI.this, ChatroomInfoUI.c(ChatroomInfoUI.this).aSH(com.tencent.mm.model.u.aAm()));
          ChatroomInfoUI.m(ChatroomInfoUI.this).aMV(ChatroomInfoUI.c(ChatroomInfoUI.this).field_roomowner);
          AppMethodBeat.o(213458);
        }
        
        public final String toString()
        {
          AppMethodBeat.i(213459);
          String str = super.toString() + "|onNotifyChange";
          AppMethodBeat.o(213459);
          return str;
        }
      });
    }
    Yl();
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
    if ((paramString1.equals(this.roomId)) && (this.fMC != null)) {
      this.fMC.notifyChanged();
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
    if (this.dyF) {
      if (this.fMO == 0)
      {
        setMMTitle(getString(2131762729));
        localObject1 = null;
        if (this.fLO != null)
        {
          localObject1 = this.fLO.field_roomowner;
          this.fMO = this.fLO.aGo().size();
        }
        if (!bt.isNullOrNil((String)localObject1)) {
          break label1363;
        }
        this.fML = false;
        this.fMM = false;
        this.fMN = false;
        ad.d("MicroMsg.ChatroomInfoUI", "initBaseChatRoomView()");
        this.fMC = ((ContactListExpandPreference)this.screen.aVD("roominfo_contact_anchor"));
        this.fMC.a(this.screen, this.fMC.mKey);
        this.fMB = ((NormalIconPreference)this.screen.aVD("del_selector_btn"));
        this.fMA = ((NormalIconPreference)this.screen.aVD("add_selector_btn"));
        this.fMy = this.screen.aVD("room_name");
        this.fMx = ((RoomCardPreference)this.screen.aVD("room_card"));
        this.fMz = this.screen.aVD("see_room_member");
        this.fMD = ((CheckBoxPreference)this.screen.aVD("room_notify_new_msg"));
        this.fME = ((CheckBoxPreference)this.screen.aVD("room_save_to_contact"));
        this.fMF = ((CheckBoxPreference)this.screen.aVD("room_placed_to_the_top"));
        this.fMG = ((KeyValuePreference)this.screen.aVD("room_nickname"));
        this.fMH = ((KeyValuePreference)this.screen.aVD("room_remark"));
        this.fMJ = ((NewTipPreference)this.screen.aVD("manage_room"));
        this.fMC.vO(true).vP(true).fcK();
        bool = ((com.tencent.mm.plugin.chatroom.a.c)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.chatroom.a.c.class)).ZA(this.roomId);
        if (YH()) {
          break label1388;
        }
        this.screen.cP("manage_room", true);
        localObject1 = this.screen;
        if (bool) {
          break label1383;
        }
        bool = true;
        label414:
        ((com.tencent.mm.ui.base.preference.f)localObject1).cP("room_manager_view", bool);
        label426:
        if ((w.zk(this.roomId)) && (com.tencent.mm.model.q.aAi()))
        {
          localObject1 = ((com.tencent.mm.plugin.chatroom.a.c)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.chatroom.a.c.class)).azz().AN(this.roomId);
          if ((localObject1 != null) && ((((ab)localObject1).field_chatroomStatus & 0x20000) != 131072L) && ((((ab)localObject1).field_chatroomStatus & 0x10000) == 65536L) && (com.tencent.mm.model.q.aAg()))
          {
            this.fMW = true;
            this.fMJ.a(this.screen);
            com.tencent.mm.plugin.newtips.a.dun().h(this.fMJ);
            com.tencent.mm.plugin.newtips.a.g.a(this.fMJ);
          }
        }
        if (this.fLO != null)
        {
          this.fMC.aMV(this.fLO.field_roomowner);
          if (!bt.isNullOrNil(this.fLO.field_roomowner)) {
            this.fMC.EWM.EWc.EWC = true;
          }
        }
        this.fMC.fcJ();
        this.fMC.fcD();
        this.screen.cP("add_selector_btn", true);
        this.screen.cP("del_selector_btn", true);
        this.screen.cP("room_name", false);
        this.screen.cP("room_qr_code", false);
        this.screen.cP("chatroom_info_chexboxes", true);
        this.screen.cP("room_card", false);
        this.screen.cP("room_upgrade_entry", true);
        this.screen.cP("chat_room_story_videos", true);
        if (((YH()) || (this.fMO < r.MAX_COUNT)) && ((!YH()) || (this.fMO < r.MAX_COUNT - 1))) {
          break label1419;
        }
        this.screen.cP("see_room_member", false);
        this.fMz.setTitle(getString(2131762973));
        label783:
        if (am.aSR(this.roomId)) {
          break label1436;
        }
        this.screen.cP("room_openim_about", true);
        label807:
        ad.d("MicroMsg.ChatroomInfoUI", "updatePlaceTop()");
        if (this.sp == null) {
          this.sp = getSharedPreferences(getPackageName() + "_preferences", 0);
        }
        if (this.fMF != null)
        {
          if (this.contact == null) {
            break label1550;
          }
          this.sp.edit().putBoolean("room_placed_to_the_top", ((l)com.tencent.mm.kernel.g.ab(l.class)).azv().aTH(this.contact.field_username)).commit();
        }
        label918:
        this.screen.notifyDataSetChanged();
        ad.d("MicroMsg.ChatroomInfoUI", "updateSaveToContact()");
        if (this.sp == null) {
          this.sp = getSharedPreferences(getPackageName() + "_preferences", 0);
        }
        if (this.fME == null) {
          break label1608;
        }
        localObject1 = ((l)com.tencent.mm.kernel.g.ab(l.class)).azp().Bf(this.roomId);
        if (localObject1 != null) {
          break label1577;
        }
        ad.e("MicroMsg.ChatroomInfoUI", "contact == null !!!");
        label1021:
        ad.d("MicroMsg.ChatroomInfoUI", "updateDisplayNickname()");
        if (this.sp == null) {
          this.sp = getSharedPreferences(getPackageName() + "_preferences", 0);
        }
        localObject1 = ((com.tencent.mm.plugin.chatroom.a.c)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.chatroom.a.c.class)).azz().AN(this.roomId);
        if (localObject1 != null) {
          break label1620;
        }
        ad.e("MicroMsg.ChatroomInfoUI", "members == null !!!");
        label1108:
        this.fMR = ((l)com.tencent.mm.kernel.g.ab(l.class)).dlK().aqn(this.roomId);
        this.fMR = ((l)com.tencent.mm.kernel.g.ab(l.class)).dlK().aqn(this.roomId);
      }
    }
    for (;;)
    {
      if (this.fMC != null)
      {
        if ((!this.dyF) && (this.fMw)) {
          this.fMC.aN(new ArrayList());
        }
        getListView().setOnScrollListener(this.fMX);
        this.fMC.a(this.fMX);
        this.fMC.a(new s.b()
        {
          public final boolean le(int paramAnonymousInt)
          {
            return true;
          }
        });
        localObject1 = this.fMC;
        localObject2 = new ChatroomInfoUI.33(this);
        if (((ContactListExpandPreference)localObject1).EWM != null) {
          ((ContactListExpandPreference)localObject1).EWM.km = ((View.OnClickListener)localObject2);
        }
        this.fMC.a(new ContactListExpandPreference.a()
        {
          public final void YJ()
          {
            AppMethodBeat.i(213433);
            if (ChatroomInfoUI.m(ChatroomInfoUI.this) != null) {
              ChatroomInfoUI.m(ChatroomInfoUI.this).fcH();
            }
            AppMethodBeat.o(213433);
          }
          
          public final void e(ViewGroup paramAnonymousViewGroup, int paramAnonymousInt)
          {
            AppMethodBeat.i(213432);
            String str = ChatroomInfoUI.m(ChatroomInfoUI.this).YX(paramAnonymousInt);
            paramAnonymousViewGroup = bt.nullAsNil(ChatroomInfoUI.m(ChatroomInfoUI.this).YZ(paramAnonymousInt));
            Object localObject;
            if (bt.isNullOrNil(paramAnonymousViewGroup))
            {
              com.tencent.mm.kernel.g.ajD();
              localObject = ((l)com.tencent.mm.kernel.g.ab(l.class)).azq().aqz(str);
              if ((localObject != null) && (!bt.isNullOrNil(((cf)localObject).field_encryptUsername))) {
                paramAnonymousViewGroup = ((cf)localObject).field_conRemark;
              }
            }
            for (;;)
            {
              if (bt.isNullOrNil(str))
              {
                AppMethodBeat.o(213432);
                return;
              }
              localObject = new Intent();
              ((Intent)localObject).putExtra("Contact_User", str);
              ((Intent)localObject).putExtra("Contact_RemarkName", paramAnonymousViewGroup);
              if ((ChatroomInfoUI.n(ChatroomInfoUI.this)) && (ChatroomInfoUI.c(ChatroomInfoUI.this) != null)) {
                ((Intent)localObject).putExtra("Contact_RoomNickname", ChatroomInfoUI.c(ChatroomInfoUI.this).zf(str));
              }
              ((Intent)localObject).putExtra("Contact_Nick", bt.nullAsNil(ChatroomInfoUI.m(ChatroomInfoUI.this).YY(paramAnonymousInt)));
              ((Intent)localObject).putExtra("Contact_RoomMember", true);
              ((Intent)localObject).putExtra("room_name", ChatroomInfoUI.o(ChatroomInfoUI.this).field_username);
              paramAnonymousViewGroup = ((l)com.tencent.mm.kernel.g.ab(l.class)).azp().Bf(str);
              if ((paramAnonymousViewGroup != null) && ((int)paramAnonymousViewGroup.gfj > 0) && (com.tencent.mm.o.b.lM(paramAnonymousViewGroup.field_type)))
              {
                tk localtk = new tk();
                localtk.dHR.intent = ((Intent)localObject);
                localtk.dHR.username = str;
                com.tencent.mm.sdk.b.a.IbL.l(localtk);
              }
              if (ChatroomInfoUI.n(ChatroomInfoUI.this))
              {
                com.tencent.mm.plugin.report.service.g.yhR.idkeyStat(219L, 9L, 1L, true);
                if ((paramAnonymousViewGroup != null) && (paramAnonymousViewGroup.fqg())) {
                  com.tencent.mm.plugin.report.service.g.yhR.kvStat(10298, paramAnonymousViewGroup.field_username + ",14");
                }
                ((Intent)localObject).putExtra("Contact_Scene", 14);
              }
              for (;;)
              {
                ((Intent)localObject).putExtra("Is_RoomOwner", ChatroomInfoUI.q(ChatroomInfoUI.this));
                ((Intent)localObject).putExtra("Contact_ChatRoomId", ChatroomInfoUI.b(ChatroomInfoUI.this));
                if (w.zl(ChatroomInfoUI.b(ChatroomInfoUI.this)))
                {
                  paramAnonymousViewGroup = new dm();
                  paramAnonymousViewGroup.mS(ChatroomInfoUI.b(ChatroomInfoUI.this));
                  paramAnonymousViewGroup.dUW = 12L;
                  paramAnonymousViewGroup.aLk();
                }
                ((Intent)localObject).putExtra("CONTACT_INFO_UI_SOURCE", 8);
                com.tencent.mm.bs.d.b(ChatroomInfoUI.this, "profile", ".ui.ContactInfoUI", (Intent)localObject);
                AppMethodBeat.o(213432);
                return;
                if (ChatroomInfoUI.p(ChatroomInfoUI.this))
                {
                  ((Intent)localObject).putExtra("Contact_Scene", 44);
                  if (!com.tencent.mm.model.u.za(paramAnonymousViewGroup.field_username)) {
                    ((Intent)localObject).putExtra("Contact_IsLBSFriend", true);
                  }
                }
              }
            }
          }
          
          public final void lc(int paramAnonymousInt)
          {
            AppMethodBeat.i(213431);
            ChatroomInfoUI.l(ChatroomInfoUI.this);
            AppMethodBeat.o(213431);
          }
          
          public final void ld(int paramAnonymousInt)
          {
            AppMethodBeat.i(213434);
            ChatroomInfoUI.r(ChatroomInfoUI.this);
            AppMethodBeat.o(213434);
          }
        });
      }
      setBackBtn(new MenuItem.OnMenuItemClickListener()
      {
        public final boolean onMenuItemClick(MenuItem paramAnonymousMenuItem)
        {
          AppMethodBeat.i(213435);
          ChatroomInfoUI.this.finish();
          AppMethodBeat.o(213435);
          return true;
        }
      });
      AppMethodBeat.o(12570);
      return;
      if (this.fLO != null) {
        this.fMO = this.fLO.aGo().size();
      }
      setMMTitle(getString(2131759496, new Object[] { getString(2131762729), Integer.valueOf(this.fMO) }));
      break;
      label1363:
      this.fML = true;
      this.fMM = ((String)localObject1).equals(com.tencent.mm.model.u.aAm());
      break label97;
      label1383:
      bool = false;
      break label414;
      label1388:
      this.screen.cP("room_manager_view", true);
      this.screen.cP("manage_room", false);
      break label426;
      label1419:
      this.screen.cP("see_room_member", true);
      break label783;
      label1436:
      this.screen.cP("chatroom_bottom_pc", true);
      this.screen.cP("room_openim_about", false);
      localObject1 = getString(2131762663);
      Object localObject2 = getString(2131762664);
      int i = ((String)localObject1).lastIndexOf((String)localObject2);
      if (i < 0) {
        break label807;
      }
      int j = ((String)localObject2).length();
      localObject1 = new SpannableStringBuilder((CharSequence)localObject1);
      ((SpannableStringBuilder)localObject1).setSpan(new ChatroomInfoUI.4(this), i, j + i, 18);
      this.screen.aVD("room_openim_about").setTitle((CharSequence)localObject1);
      break label807;
      label1550:
      this.sp.edit().putBoolean("room_placed_to_the_top", false).commit();
      break label918;
      label1577:
      this.sp.edit().putBoolean("room_save_to_contact", com.tencent.mm.o.b.lM(((aw)localObject1).field_type)).commit();
      label1608:
      this.screen.notifyDataSetChanged();
      break label1021;
      label1620:
      this.fMK = ((ab)localObject1).fpR();
      this.fMI = ((CheckBoxPreference)this.screen.aVD("room_msg_show_username"));
      if (this.fMI != null) {
        this.sp.edit().putBoolean("room_msg_show_username", this.fMK).commit();
      }
      this.screen.notifyDataSetChanged();
      break label1108;
      if (this.fMw)
      {
        this.fMM = false;
        this.fMN = false;
        setMMTitle(getString(2131762629));
        this.fMC = ((ContactListExpandPreference)this.screen.aVD("roominfo_contact_anchor"));
        this.fMC.a(this.screen, this.fMC.mKey);
        this.fMC.vO(false).vP(false);
        this.fMC.a(new s.b()
        {
          public final boolean le(int paramAnonymousInt)
          {
            return true;
          }
        });
        this.screen.removeAll();
        this.screen.b(new PreferenceCategory(this));
        this.screen.b(this.fMC);
        localObject1 = this.roomId;
        localObject2 = new mp();
        ((mp)localObject2).dAx.dyr = ((String)localObject1);
        com.tencent.mm.sdk.b.a.IbL.l((com.tencent.mm.sdk.b.b)localObject2);
        getString(2131755906);
        this.fMu = com.tencent.mm.ui.base.h.b(this, getString(2131762627), true, new DialogInterface.OnCancelListener()
        {
          public final void onCancel(DialogInterface paramAnonymousDialogInterface)
          {
            AppMethodBeat.i(213457);
            ChatroomInfoUI.a(this.fNw);
            AppMethodBeat.o(213457);
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
    }
    for (;;)
    {
      AppMethodBeat.o(12569);
      return;
      if (paramInt2 != -1)
      {
        ((com.tencent.mm.plugin.messenger.foundation.a.u)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.messenger.foundation.a.u.class)).JL(3);
        AppMethodBeat.o(12569);
        return;
      }
      if (paramIntent == null)
      {
        AppMethodBeat.o(12569);
        return;
      }
      String str = paramIntent.getStringExtra("Select_Contact");
      LocalHistoryInfo localLocalHistoryInfo = (LocalHistoryInfo)paramIntent.getParcelableExtra("select_record_msg_info");
      long l = paramIntent.getLongExtra("select_record_fake_msg_id", 0L);
      new com.tencent.mm.chatroom.g.a(this, this.roomId, str, localLocalHistoryInfo, l, this);
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
      paramIntent = bt.U(paramIntent.split(","));
      paramIntent = com.tencent.mm.roomsdk.a.b.aPF(this.roomId).a(this.roomId, paramIntent, 0);
      paramIntent.b(new com.tencent.mm.roomsdk.a.b.b() {});
      paramIntent.c(new com.tencent.mm.roomsdk.a.b.b() {});
      getString(2131755906);
      paramIntent.a(this, getString(2131762595), true, new DialogInterface.OnCancelListener()
      {
        public final void onCancel(DialogInterface paramAnonymousDialogInterface)
        {
          AppMethodBeat.i(213452);
          paramIntent.cancel();
          AppMethodBeat.o(213452);
        }
      });
      AppMethodBeat.o(12569);
      return;
      if (paramInt2 != -1) {
        break;
      }
      finish();
      AppMethodBeat.o(12569);
      return;
      if (paramInt2 != -1) {
        break;
      }
      paramIntent = paramIntent.getStringExtra("room_name");
      if (!bt.isNullOrNil(paramIntent))
      {
        com.tencent.mm.sdk.b.a.IbL.l(new xm());
        this.contact.sT(paramIntent);
        ((l)com.tencent.mm.kernel.g.ab(l.class)).azp().af(this.contact);
        YE();
      }
      AppMethodBeat.o(12569);
      return;
      if (paramInt2 != 0) {
        break;
      }
      this.fNa = -1;
      AppMethodBeat.o(12569);
      return;
      if (paramInt2 == -1) {
        YD();
      }
    }
    AppMethodBeat.o(12569);
  }
  
  public void onConfigurationChanged(Configuration paramConfiguration)
  {
    AppMethodBeat.i(12565);
    super.onConfigurationChanged(paramConfiguration);
    this.fMC.notifyChanged();
    AppMethodBeat.o(12565);
  }
  
  public void onCreate(final Bundle paramBundle)
  {
    AppMethodBeat.i(12562);
    super.onCreate(paramBundle);
    com.tencent.mm.kernel.g.ajB().gAO.a(480, this);
    com.tencent.mm.pluginsdk.c.b.a(mp.class.getName(), this.fNg);
    paramBundle = this.fMZ.alive();
    Assert.assertNotNull(this);
    keep(paramBundle);
    com.tencent.mm.kernel.g.ajC().ajl().a(this);
    ((com.tencent.mm.plugin.chatroom.a.c)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.chatroom.a.c.class)).azz().add(this);
    if (com.tencent.mm.bi.g.irs != null) {
      com.tencent.mm.bi.g.irs.a(this);
    }
    this.roomId = getIntent().getStringExtra("RoomInfo_Id");
    this.contact = ((l)com.tencent.mm.kernel.g.ab(l.class)).azp().Bf(this.roomId);
    this.fMS = true;
    this.dyF = getIntent().getBooleanExtra("Is_Chatroom", true);
    this.fMw = getIntent().getBooleanExtra("Is_Lbsroom", false);
    this.fMT = getIntent().getBooleanExtra("fromChatting", false);
    this.fMU = getIntent().getBooleanExtra("isShowSetMuteAnimation", false);
    this.fNc = (getPackageName() + "_preferences");
    if (this.dyF)
    {
      this.fLO = ((com.tencent.mm.plugin.chatroom.a.c)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.chatroom.a.c.class)).azz().AN(this.roomId);
      if (this.fLO != null) {
        this.fMN = this.fLO.aSH(com.tencent.mm.model.u.aAm());
      }
    }
    initView();
    if (this.dyF)
    {
      paramBundle = new ChatroomInfoUI.20(this);
      if (this.fLO == null)
      {
        as.a.hFO.a(this.roomId, "", paramBundle);
        AppMethodBeat.o(12562);
        return;
      }
      if (System.currentTimeMillis() - this.fLO.field_modifytime >= 86400000L) {
        com.tencent.mm.kernel.g.ajF().ay(new Runnable()
        {
          public final void run()
          {
            AppMethodBeat.i(12543);
            as.a.hFO.a(ChatroomInfoUI.c(ChatroomInfoUI.this).field_chatroomname, "", paramBundle);
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
    if (com.tencent.mm.bi.g.irs != null) {
      com.tencent.mm.bi.g.irs.a(this);
    }
    com.tencent.mm.kernel.g.ajC().ajl().b(this);
    com.tencent.mm.ui.h.a.dismiss();
    com.tencent.mm.kernel.g.ajB().gAO.b(480, this);
    com.tencent.mm.sdk.b.a.IbL.d(this.fMZ);
    com.tencent.mm.pluginsdk.c.b.b(mp.class.getName(), this.fNg);
    if (com.tencent.mm.kernel.g.ajx())
    {
      ((l)com.tencent.mm.kernel.g.ab(l.class)).azp().b(this);
      ((com.tencent.mm.plugin.chatroom.a.c)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.chatroom.a.c.class)).azz().remove(this);
    }
    if (com.tencent.mm.bi.g.irs != null) {
      com.tencent.mm.bi.g.irs.b(this);
    }
    if (this.fNh != null) {
      this.fNh.stopTimer();
    }
    super.onDestroy();
    AppMethodBeat.o(12568);
  }
  
  public void onPause()
  {
    AppMethodBeat.i(12567);
    super.onPause();
    if ((this.fMQ) && (this.dyF))
    {
      if (this.fLO == null)
      {
        AppMethodBeat.o(12567);
        return;
      }
      com.tencent.mm.model.q.a(this.roomId, this.fLO, this.fMK);
    }
    AppMethodBeat.o(12567);
  }
  
  public boolean onPreferenceTreeClick(com.tencent.mm.ui.base.preference.f paramf, Preference arg2)
  {
    int j = 1;
    AppMethodBeat.i(12571);
    paramf = ???.mKey;
    if (paramf.equals("room_name"))
    {
      paramf = com.tencent.mm.n.g.acA().getValue("ChatRoomOwnerModTopic");
      if (bt.isNullOrNil(paramf)) {
        break label3193;
      }
    }
    label362:
    label756:
    label1525:
    label3193:
    for (int i = bt.aRe(paramf);; i = 0)
    {
      if ((this.fLO != null) && (!bt.isNullOrNil(this.fLO.field_roomowner)) && (i > 0) && (!YH()) && (i < this.fMO)) {
        com.tencent.mm.ui.base.h.a(this, getString(2131762706, new Object[] { YA() }), null, getString(2131755793), new DialogInterface.OnClickListener()
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
        paramf = new com.tencent.mm.hellhoundlib.b.a().bc(paramf);
        com.tencent.mm.hellhoundlib.a.a.a(this, paramf.ahp(), "com/tencent/mm/chatroom/ui/ChatroomInfoUI", "onPreferenceTreeClick", "(Lcom/tencent/mm/ui/base/preference/IPreferenceScreen;Lcom/tencent/mm/ui/base/preference/Preference;)Z", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
        startActivity((Intent)paramf.mq(0));
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/chatroom/ui/ChatroomInfoUI", "onPreferenceTreeClick", "(Lcom/tencent/mm/ui/base/preference/IPreferenceScreen;Lcom/tencent/mm/ui/base/preference/Preference;)Z", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
        com.tencent.mm.plugin.report.service.g.yhR.idkeyStat(219L, 3L, 1L, true);
        continue;
        if (paramf.equals("room_upgrade_entry"))
        {
          if (bt.getInt(com.tencent.mm.n.g.acA().getValue("ChatroomGlobalSwitch"), 1) == 1) {}
          for (i = 1;; i = 0)
          {
            if (i == 0) {
              break label362;
            }
            paramf = new Intent();
            paramf.putExtra("rawUrl", getString(2131757097, new Object[] { ac.fks() }));
            paramf.putExtra("geta8key_username", com.tencent.mm.model.u.aAm());
            paramf.putExtra("showShare", false);
            com.tencent.mm.bs.d.b(this, "webview", "com.tencent.mm.plugin.webview.ui.tools.WebViewUI", paramf);
            break;
          }
        }
        else if (paramf.equals("room_qr_code"))
        {
          if (w.zl(this.roomId))
          {
            paramf = new dm();
            paramf.mS(this.roomId);
            paramf.dUW = 6L;
            paramf.aLk();
          }
          com.tencent.mm.plugin.report.service.g.yhR.idkeyStat(219L, 5L, 1L, true);
          paramf = new Intent();
          paramf.putExtra("from_userName", this.roomId);
          com.tencent.mm.bs.d.b(this, "setting", ".ui.setting.SelfQRCodeUI", paramf);
        }
        else if (paramf.equals("room_card"))
        {
          if (this.fLO == null)
          {
            ad.w("MicroMsg.ChatroomInfoUI", "goToRoomCardUI member == null");
          }
          else
          {
            bool1 = this.fLO.aSH(com.tencent.mm.model.u.aAm());
            if ((bt.isNullOrNil(com.tencent.mm.model.q.yU(this.roomId))) && (!YH()))
            {
              com.tencent.mm.ui.base.h.e(this, getString(2131762581), null, getString(2131762582), null, null, null);
            }
            else
            {
              paramf = new Intent();
              paramf.setClass(this, RoomCardUI.class);
              paramf.putExtra("RoomInfo_Id", this.roomId);
              paramf.putExtra("room_name", this.fMx.fUT.toString());
              this.fMO = com.tencent.mm.model.q.yQ(this.roomId).size();
              paramf.putExtra("room_member_count", this.fMO);
              paramf.putExtra("room_owner_name", YA());
              paramf.putExtra("room_notice", com.tencent.mm.model.q.yU(this.roomId));
              paramf.putExtra("room_notice_publish_time", com.tencent.mm.model.q.yX(this.roomId));
              paramf.putExtra("room_notice_editor", com.tencent.mm.model.q.yW(this.roomId));
              paramf.putExtra("Is_RoomOwner", this.fMM);
              paramf.putExtra("Is_RoomManager", bool1);
              startActivityForResult(paramf, 6);
            }
          }
        }
        else
        {
          if (paramf.equals("room_notify_new_msg"))
          {
            if (!this.fMP)
            {
              bool1 = true;
              this.fMP = bool1;
              if (this.dyF)
              {
                if (!this.fMP) {
                  break label979;
                }
                i = 0;
                com.tencent.mm.roomsdk.a.b.aPF(this.roomId).G(this.roomId, i).cyR();
                this.contact = ((l)com.tencent.mm.kernel.g.ab(l.class)).azp().Bf(this.roomId);
                this.contact.ki(i);
                ((l)com.tencent.mm.kernel.g.ab(l.class)).azp().c(this.roomId, this.contact);
                if (this.fMV)
                {
                  paramf = com.tencent.mm.plugin.report.service.g.yhR;
                  if (!this.fMP) {
                    break label984;
                  }
                  i = 14;
                  paramf.dD(869, i);
                }
              }
              paramf = com.tencent.mm.modelstat.b.inZ;
              ??? = this.roomId;
              bool1 = this.fMP;
              if ((paramf.aLz()) && (paramf.eW(???)))
              {
                ??? = new IMBehavior();
                ???.opType = 1;
                ???.chattingOp = new IMBehaviorChattingOP();
                ??? = ???.chattingOp;
                if (!bool1) {
                  break label990;
                }
                i = j;
                ((IMBehaviorChattingOP)???).changeNotifyStatus = i;
              }
            }
            synchronized (paramf.lock)
            {
              paramf.inY.oplist_.add(???);
              YC();
              continue;
              bool1 = false;
              break label734;
              i = 1;
              break label756;
              i = 15;
              break label860;
              i = 2;
            }
          }
          if (paramf.equals("room_save_to_contact"))
          {
            if (this.sp == null) {
              this.sp = getSharedPreferences(getPackageName() + "_preferences", 0);
            }
            paramf = ((l)com.tencent.mm.kernel.g.ab(l.class)).azp().Bf(this.roomId);
            if (paramf != null)
            {
              boolean bool2 = com.tencent.mm.o.b.lM(paramf.field_type);
              ??? = this.sp.edit();
              if (!bool2)
              {
                bool1 = true;
                ???.putBoolean("room_save_to_contact", bool1).commit();
                if (!bool2) {
                  break label1192;
                }
                paramf.acI();
                com.tencent.mm.roomsdk.a.b.aPF(this.roomId).a(paramf, false);
                com.tencent.mm.ui.base.h.cl(this, getString(2131762677));
                com.tencent.mm.modelstat.b.inZ.W(this.roomId, false);
              }
              for (;;)
              {
                this.screen.notifyDataSetChanged();
                break;
                bool1 = false;
                break label1111;
                com.tencent.mm.roomsdk.a.b.aPF(this.roomId).a(paramf, true);
                com.tencent.mm.ui.base.h.cl(this, getString(2131762693));
                com.tencent.mm.modelstat.b.inZ.W(this.roomId, true);
              }
            }
          }
          else if (paramf.equals("room_placed_to_the_top"))
          {
            paramf = getSharedPreferences(this.fNc, 0);
            if (this.contact != null)
            {
              if (((l)com.tencent.mm.kernel.g.ab(l.class)).azv().aTH(this.contact.field_username))
              {
                w.E(this.contact.field_username, true);
                com.tencent.mm.modelstat.b.inZ.c(false, this.roomId, false);
              }
              for (;;)
              {
                paramf.edit().putBoolean("room_placed_to_the_top", ((l)com.tencent.mm.kernel.g.ab(l.class)).azv().aTH(this.contact.field_username)).commit();
                break;
                w.D(this.contact.field_username, true);
                com.tencent.mm.modelstat.b.inZ.c(false, this.roomId, true);
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
              paramf = getSharedPreferences(this.fNc, 0).edit();
              if (!this.fMK)
              {
                bool1 = true;
                paramf.putBoolean("room_msg_show_username", bool1).commit();
                if (this.fMK) {
                  break label1525;
                }
              }
              for (bool1 = true;; bool1 = false)
              {
                this.fMK = bool1;
                this.fMQ = true;
                break;
                bool1 = false;
                break label1478;
              }
            }
            if (!paramf.equals("room_set_chatting_background")) {
              break;
            }
            if (w.zl(this.roomId))
            {
              paramf = new dm();
              paramf.mS(this.roomId);
              paramf.dUW = 9L;
              paramf.aLk();
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
        if (w.zl(this.roomId))
        {
          paramf = new dm();
          paramf.mS(this.roomId);
          paramf.dUW = 8L;
          paramf.aLk();
        }
        paramf = new Intent();
        paramf.putExtra("detail_username", this.roomId);
        com.tencent.mm.plugin.fts.a.d.d(this, ".ui.FTSChattingConvUI", paramf);
        if ((this.fLO == null) || (this.fLO.aGo() == null)) {
          break label3188;
        }
      }
      for (i = this.fLO.aGo().size();; i = 0)
      {
        for (;;)
        {
          com.tencent.mm.plugin.report.service.g.yhR.f(14569, new Object[] { Integer.valueOf(1), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(i), Integer.valueOf(1) });
          break;
          if (paramf.equals("room_clear_chatting_history"))
          {
            if (w.zl(this.roomId))
            {
              paramf = new dm();
              paramf.mS(this.roomId);
              paramf.dUW = 11L;
              paramf.aLk();
            }
            paramf = getString(2131759504);
            com.tencent.mm.ui.base.h.a(getContext(), paramf, "", getString(2131755694), getString(2131755691), new DialogInterface.OnClickListener()
            {
              public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
              {
                AppMethodBeat.i(213439);
                com.tencent.mm.plugin.report.service.g.yhR.f(14553, new Object[] { Integer.valueOf(3), Integer.valueOf(2), ChatroomInfoUI.b(ChatroomInfoUI.this) });
                ChatroomInfoUI.cE(false);
                paramAnonymousDialogInterface = ChatroomInfoUI.this;
                ChatroomInfoUI.this.getString(2131755906);
                final p localp = com.tencent.mm.ui.base.h.b(paramAnonymousDialogInterface, ChatroomInfoUI.this.getString(2131755936), true, new ChatroomInfoUI.a());
                if (!ChatroomInfoUI.YI()) {}
                for (paramAnonymousDialogInterface = com.tencent.mm.pluginsdk.wallet.d.aNO(ChatroomInfoUI.o(ChatroomInfoUI.this).field_username);; paramAnonymousDialogInterface = null)
                {
                  if (!bt.isNullOrNil(paramAnonymousDialogInterface))
                  {
                    localp.dismiss();
                    com.tencent.mm.ui.base.h.a(ChatroomInfoUI.this, false, ChatroomInfoUI.this.getString(2131765211, new Object[] { paramAnonymousDialogInterface }), null, ChatroomInfoUI.this.getString(2131760081), ChatroomInfoUI.this.getString(2131757424), new DialogInterface.OnClickListener()new DialogInterface.OnClickListener
                    {
                      public final void onClick(DialogInterface paramAnonymous2DialogInterface, int paramAnonymous2Int)
                      {
                        AppMethodBeat.i(213437);
                        com.tencent.mm.plugin.report.service.g.yhR.f(14553, new Object[] { Integer.valueOf(3), Integer.valueOf(4), ChatroomInfoUI.b(ChatroomInfoUI.this) });
                        ChatroomInfoUI.a(ChatroomInfoUI.this, true);
                        if (!ChatroomInfoUI.s(ChatroomInfoUI.this))
                        {
                          paramAnonymous2DialogInterface = new Intent();
                          paramAnonymous2DialogInterface.putExtra("Chat_User", ChatroomInfoUI.o(ChatroomInfoUI.this).field_username);
                          paramAnonymous2DialogInterface.addFlags(67108864);
                          com.tencent.mm.bs.d.f(ChatroomInfoUI.this, ".ui.chatting.ChattingUI", paramAnonymous2DialogInterface);
                          AppMethodBeat.o(213437);
                          return;
                        }
                        ChatroomInfoUI.this.finish();
                        AppMethodBeat.o(213437);
                      }
                    }, new DialogInterface.OnClickListener()
                    {
                      public final void onClick(DialogInterface paramAnonymous2DialogInterface, int paramAnonymous2Int)
                      {
                        AppMethodBeat.i(213438);
                        com.tencent.mm.plugin.report.service.g.yhR.f(14553, new Object[] { Integer.valueOf(3), Integer.valueOf(3), ChatroomInfoUI.b(ChatroomInfoUI.this) });
                        localp.show();
                        ChatroomInfoUI.a(ChatroomInfoUI.this, false);
                        ChatroomInfoUI.a(ChatroomInfoUI.this, localp);
                        AppMethodBeat.o(213438);
                      }
                    }, -1, 2131099904);
                    AppMethodBeat.o(213439);
                    return;
                  }
                  ChatroomInfoUI.a(ChatroomInfoUI.this, localp);
                  AppMethodBeat.o(213439);
                  return;
                }
              }
            }, null, 2131099904);
            break;
          }
          if (paramf.equals("room_report_it"))
          {
            if (w.zl(this.roomId))
            {
              paramf = new dm();
              paramf.mS(this.roomId);
              paramf.dUW = 10L;
              paramf.aLk();
            }
            paramf = new Intent();
            paramf.putExtra("k_username", this.roomId);
            paramf.putExtra("showShare", false);
            paramf.putExtra("rawUrl", String.format("https://weixin110.qq.com/security/readtemplate?t=weixin_report/w_type&scene=%d#wechat_redirect", new Object[] { Integer.valueOf(36) }));
            com.tencent.mm.bs.d.b(this, "webview", ".ui.tools.WebViewUI", paramf);
            paramf = com.tencent.mm.modelstat.b.inZ;
            ??? = this.roomId;
            if ((!paramf.aLz()) || (!paramf.eW(???))) {
              break;
            }
            ??? = new IMBehavior();
            ((IMBehavior)???).opType = 1;
            ((IMBehavior)???).chattingOp = new IMBehaviorChattingOP();
            ((IMBehavior)???).chattingOp.expose = 1;
            synchronized (paramf.lock)
            {
              paramf.inY.oplist_.add(???);
            }
          }
        }
        if (paramf.equals("room_del_quit"))
        {
          ad.d("MicroMsg.ChatroomInfoUI", " quit " + this.roomId);
          paramf = new wm();
          paramf.dKN.dKP = true;
          com.tencent.mm.sdk.b.a.IbL.l(paramf);
          if ((!bt.isNullOrNil(this.roomId)) && (this.roomId.equals(paramf.dKO.dKR)))
          {
            bool1 = true;
            if (!bool1) {
              break label2300;
            }
            ad.d("MicroMsg.ChatroomInfoUI", " quit talkroom" + this.roomId);
          }
          label2300:
          while ((!this.fMM) || (this.fLO == null) || (this.fLO.aGo().size() <= 2))
          {
            com.tencent.mm.ui.base.h.a(getContext(), getString(2131758025), "", getString(2131755835), getString(2131755691), new DialogInterface.OnClickListener()
            {
              public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
              {
                AppMethodBeat.i(213443);
                if ((ChatroomInfoUI.b(ChatroomInfoUI.this) == null) || (ChatroomInfoUI.b(ChatroomInfoUI.this).length() <= 0))
                {
                  ad.e("MicroMsg.ChatroomInfoUI", "quitChatRoom : invalid args");
                  AppMethodBeat.o(213443);
                  return;
                }
                if (bool1)
                {
                  paramAnonymousDialogInterface = new wm();
                  paramAnonymousDialogInterface.dKN.dKQ = true;
                  com.tencent.mm.sdk.b.a.IbL.l(paramAnonymousDialogInterface);
                }
                if (!((l)com.tencent.mm.kernel.g.ab(l.class)).azp().aTn(ChatroomInfoUI.b(ChatroomInfoUI.this)))
                {
                  ad.e("MicroMsg.ChatroomInfoUI", "quitChatRoom : room[" + ChatroomInfoUI.b(ChatroomInfoUI.this) + "] is not exist");
                  AppMethodBeat.o(213443);
                  return;
                }
                if (((com.tencent.mm.live.a)com.tencent.mm.kernel.g.ad(com.tencent.mm.live.a.class)).isAnchorLiving())
                {
                  com.tencent.mm.ui.base.h.a(ChatroomInfoUI.this.getContext(), ChatroomInfoUI.this.getString(2131760312), null, ChatroomInfoUI.this.getString(2131755793), new DialogInterface.OnClickListener()
                  {
                    public final void onClick(DialogInterface paramAnonymous2DialogInterface, int paramAnonymous2Int) {}
                  });
                  AppMethodBeat.o(213443);
                  return;
                }
                if (((com.tencent.mm.live.a)com.tencent.mm.kernel.g.ad(com.tencent.mm.live.a.class)).isVisitorLiving()) {
                  ((com.tencent.mm.live.a)com.tencent.mm.kernel.g.ad(com.tencent.mm.live.a.class)).forceStopCurLive(ChatroomInfoUI.this.getContext());
                }
                ChatroomInfoUI.t(ChatroomInfoUI.this);
                ((com.tencent.mm.plugin.multitalk.model.d)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.multitalk.model.d.class)).arf(ChatroomInfoUI.b(ChatroomInfoUI.this));
                AppMethodBeat.o(213443);
              }
            }, null, 2131099904);
            break;
            bool1 = false;
            break label2215;
          }
          paramf = getString(2131762665);
          ??? = new h.c()
          {
            public final void lf(int paramAnonymousInt)
            {
              AppMethodBeat.i(213442);
              switch (paramAnonymousInt)
              {
              default: 
                ad.d("MicroMsg.ChatroomInfoUI", "dz[dealQuitChatRoom owner click cancel]");
                AppMethodBeat.o(213442);
                return;
              }
              ad.d("MicroMsg.ChatroomInfoUI", "dz[dealQuitChatRoom owner click room_owner_delete_direct]");
              if (((com.tencent.mm.live.a)com.tencent.mm.kernel.g.ad(com.tencent.mm.live.a.class)).isAnchorLiving())
              {
                com.tencent.mm.ui.base.h.a(ChatroomInfoUI.this.getContext(), ChatroomInfoUI.this.getString(2131760312), null, ChatroomInfoUI.this.getString(2131755793), new DialogInterface.OnClickListener()
                {
                  public final void onClick(DialogInterface paramAnonymous2DialogInterface, int paramAnonymous2Int) {}
                });
                AppMethodBeat.o(213442);
                return;
              }
              if (((com.tencent.mm.live.a)com.tencent.mm.kernel.g.ad(com.tencent.mm.live.a.class)).isVisitorLiving()) {
                ((com.tencent.mm.live.a)com.tencent.mm.kernel.g.ad(com.tencent.mm.live.a.class)).forceStopCurLive(ChatroomInfoUI.this.getContext());
              }
              ChatroomInfoUI.t(ChatroomInfoUI.this);
              ((com.tencent.mm.plugin.multitalk.model.d)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.multitalk.model.d.class)).arf(ChatroomInfoUI.b(ChatroomInfoUI.this));
              AppMethodBeat.o(213442);
            }
          };
          com.tencent.mm.ui.base.h.a(this, "", new String[] { paramf }, "", ???);
          break;
        }
        if (paramf.equals("add_selector_btn"))
        {
          Yy();
          break;
        }
        if (paramf.equals("del_selector_btn"))
        {
          Yz();
          break;
        }
        if (paramf.equals("see_room_member"))
        {
          paramf = new Intent();
          paramf.setClass(getContext(), SeeRoomMemberUI.class);
          paramf.putExtra("Block_list", com.tencent.mm.model.u.aAm());
          ??? = com.tencent.mm.model.q.yQ(this.roomId);
          if (??? != null) {
            this.fMO = ???.size();
          }
          paramf.putExtra("Chatroom_member_list", bt.m(???, ","));
          paramf.putExtra("RoomInfo_Id", this.roomId);
          paramf.putExtra("room_owner_name", this.fLO.field_roomowner);
          paramf.putExtra("Is_RoomOwner", this.fMM);
          paramf.putExtra("room_member_count", this.fMO);
          paramf.putExtra("Add_address_titile", getString(2131762697));
          if (this.dyF)
          {
            paramf.putExtra("Contact_Scene", 14);
            ??? = getListView().getChildAt(0);
            if (??? != null) {
              break label2673;
            }
          }
          for (i = 0;; i = -???.getTop())
          {
            paramf.putExtra("offset", i);
            paramf.putExtra("first_pos", getListView().getFirstVisiblePosition());
            paramf.putExtra("room_name", this.contact.field_username);
            startActivityForResult(paramf, 5);
            this.fNa = 5;
            break;
            if (!this.fMw) {
              break label2563;
            }
            paramf.putExtra("Contact_Scene", 44);
            if (com.tencent.mm.model.u.za(this.contact.field_username)) {
              break label2563;
            }
            paramf.putExtra("Contact_IsLBSFriend", true);
            break label2563;
          }
        }
        if (paramf.equals("manage_room"))
        {
          if (this.fMW) {
            com.tencent.mm.plugin.newtips.a.dun().LQ(26);
          }
          paramf = new Intent();
          paramf.setClass(getContext(), ManageChatroomUI.class);
          paramf.putExtra("RoomInfo_Id", this.roomId);
          paramf.putExtra("room_owner_name", this.fLO.field_roomowner);
          paramf = new com.tencent.mm.hellhoundlib.b.a().bc(paramf);
          com.tencent.mm.hellhoundlib.a.a.a(this, paramf.ahp(), "com/tencent/mm/chatroom/ui/ChatroomInfoUI", "goToManageChatroomUI", "()V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
          startActivity((Intent)paramf.mq(0));
          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/chatroom/ui/ChatroomInfoUI", "goToManageChatroomUI", "()V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
          break;
        }
        if (paramf.equals("chat_room_app_brand"))
        {
          if (w.zl(this.roomId))
          {
            paramf = new dm();
            paramf.mS(this.roomId);
            paramf.dUW = 7L;
            paramf.aLk();
          }
          paramf = new Intent();
          paramf.putExtra("Chat_User", this.roomId);
          com.tencent.mm.bs.d.f(this, ".ui.chatting.gallery.AppBrandHistoryListUI", paramf);
          com.tencent.mm.plugin.report.service.g.yhR.idkeyStat(219L, 25L, 1L, true);
          break;
        }
        if (paramf.equals("room_manager_view"))
        {
          paramf = new Intent();
          paramf.setClass(getContext(), SeeRoomOwnerManagerUI.class);
          paramf.putExtra("RoomInfo_Id", this.roomId);
          paramf.putExtra("room_owner_name", this.fLO.field_roomowner);
          paramf = new com.tencent.mm.hellhoundlib.b.a().bc(paramf);
          com.tencent.mm.hellhoundlib.a.a.a(this, paramf.ahp(), "com/tencent/mm/chatroom/ui/ChatroomInfoUI", "goToOwnerManageChatroomUI", "()V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
          startActivity((Intent)paramf.mq(0));
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
        paramf = new com.tencent.mm.hellhoundlib.b.a().bc(paramf);
        com.tencent.mm.hellhoundlib.a.a.a(this, paramf.ahp(), "com/tencent/mm/chatroom/ui/ChatroomInfoUI", "dealModChatroomRemark", "()V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
        startActivity((Intent)paramf.mq(0));
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
    boolean bool;
    if ((this.fLO != null) && (this.fLO.fpS() != null))
    {
      bool = com.tencent.mm.model.q.yV(this.fLO.field_chatroomname);
      ad.i("MicroMsg.ChatroomInfoUI", "roomId:%s newVer:%s localVer:%s owner:%s", new Object[] { this.fLO.field_chatroomname, Integer.valueOf(this.fLO.field_chatroomVersion), Integer.valueOf(this.fLO.field_oldChatroomVersion), this.fLO.field_roomowner });
    }
    for (;;)
    {
      if ((com.tencent.mm.model.q.yL(this.roomId)) || (bool)) {
        Yu();
      }
      YD();
      updateTitle();
      YC();
      Object localObject2;
      Object localObject1;
      if (this.dyF)
      {
        YE();
        if (this.contact != null)
        {
          this.fLO = ((com.tencent.mm.plugin.chatroom.a.c)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.chatroom.a.c.class)).azz().AN(this.roomId);
          if (this.fLO != null) {
            break label507;
          }
          localObject2 = "";
          localObject1 = localObject2;
          if (bt.isNullOrNil((String)localObject2)) {
            localObject1 = com.tencent.mm.model.u.aAo();
          }
          if (bt.isNullOrNil((String)localObject1)) {
            break label518;
          }
          this.fMG.fzD();
          this.fMG.JsT = com.tencent.mm.cc.a.ax(getContext(), 2131165587);
          KeyValuePreference localKeyValuePreference = this.fMG;
          localObject2 = localObject1;
          if (((String)localObject1).length() <= 0) {
            localObject2 = getString(2131763409);
          }
          localKeyValuePreference.setSummary(k.c(this, (CharSequence)localObject2));
          label268:
          if (this.screen != null) {
            this.screen.notifyDataSetChanged();
          }
        }
        if ((this.contact != null) && (this.fMH != null))
        {
          this.contact = ((l)com.tencent.mm.kernel.g.ab(l.class)).azp().Bf(this.roomId);
          this.fMH.fzD();
          if (!am.aSR(this.roomId)) {
            break label530;
          }
          this.screen.d(this.fMH);
        }
      }
      for (;;)
      {
        if (this.fMS)
        {
          YB();
          this.fMS = false;
        }
        localObject1 = getIntent().getStringExtra("need_matte_high_light_item");
        if (!this.fMY)
        {
          if (!bt.isNullOrNil((String)localObject1)) {
            uS((String)localObject1);
          }
          this.fMY = true;
        }
        if ((!bt.isNullOrNil((String)localObject1)) && (((String)localObject1).equals("room_notify_new_notice")) && (!this.fMY))
        {
          uS("room_card");
          this.fMY = true;
        }
        com.tencent.mm.plugin.newtips.a.dun().LP(26);
        ad.d("MicroMsg.ChatroomInfoUI", "showSetMuteAnimation isShowSetMuteAnimation[%b]", new Object[] { Boolean.valueOf(this.fMU) });
        if (this.fMU)
        {
          this.fMU = false;
          aq.o(new Runnable()
          {
            public final void run()
            {
              AppMethodBeat.i(213460);
              ChatroomInfoUI.b(ChatroomInfoUI.this, "room_notify_new_msg");
              ChatroomInfoUI.B(ChatroomInfoUI.this);
              AppMethodBeat.o(213460);
            }
          }, 50L);
        }
        AppMethodBeat.o(12564);
        return;
        label507:
        localObject2 = this.fLO.field_selfDisplayName;
        break;
        label518:
        this.fMG.setSummary("");
        break label268;
        label530:
        if (!bt.isNullOrNil(this.contact.field_conRemark))
        {
          localObject1 = this.contact.field_conRemark;
          this.fMH.setSummary(k.c(this, (CharSequence)localObject1));
          if (this.screen != null) {
            this.screen.notifyDataSetChanged();
          }
        }
        else
        {
          this.fMH.setSummary("");
        }
      }
      bool = false;
    }
  }
  
  public void onSceneEnd(int paramInt1, int paramInt2, String paramString, com.tencent.mm.al.n paramn)
  {
    AppMethodBeat.i(12594);
    ad.i("MicroMsg.ChatroomInfoUI", "onSceneEnd: errType = " + paramInt1 + " errCode = " + paramInt2 + " errMsg = " + paramString + " type = " + paramn.getType());
    ad.d("MicroMsg.ChatroomInfoUI", "pre is " + this.fMO);
    this.fMO = com.tencent.mm.model.q.yS(this.roomId);
    ad.d("MicroMsg.ChatroomInfoUI", "now is " + this.fMO);
    if (this.fMu != null) {
      this.fMu.dismiss();
    }
    AppMethodBeat.o(12594);
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
  
  public final void uT(final String paramString)
  {
    AppMethodBeat.i(213471);
    ad.i("MicroMsg.ChatroomInfoUI", "delete chatroom %s", new Object[] { paramString });
    this.fNe = com.tencent.mm.roomsdk.a.b.aPF(paramString).uI(paramString);
    this.fNe.d(new com.tencent.mm.roomsdk.a.b.e() {}).cyR();
    AppMethodBeat.o(213471);
  }
  
  public static class LocalHistoryInfo
    implements Parcelable
  {
    public static final Parcelable.Creator<LocalHistoryInfo> CREATOR;
    public String aeskey;
    public int fNA;
    public int fNB;
    public String fileid;
    public String filemd5;
    
    static
    {
      AppMethodBeat.i(213468);
      CREATOR = new Parcelable.Creator() {};
      AppMethodBeat.o(213468);
    }
    
    public LocalHistoryInfo() {}
    
    protected LocalHistoryInfo(Parcel paramParcel)
    {
      AppMethodBeat.i(213467);
      this.fileid = paramParcel.readString();
      this.aeskey = paramParcel.readString();
      this.filemd5 = paramParcel.readString();
      this.fNA = paramParcel.readInt();
      this.fNB = paramParcel.readInt();
      AppMethodBeat.o(213467);
    }
    
    public int describeContents()
    {
      return 0;
    }
    
    public String toString()
    {
      AppMethodBeat.i(213465);
      String str = "LocalHistoryInfo{fileid='" + this.fileid + '\'' + ", aeskey='" + this.aeskey + '\'' + ", filemd5='" + this.filemd5 + '\'' + ", filelength=" + this.fNA + ", msgsount=" + this.fNB + '}';
      AppMethodBeat.o(213465);
      return str;
    }
    
    public void writeToParcel(Parcel paramParcel, int paramInt)
    {
      AppMethodBeat.i(213466);
      paramParcel.writeString(this.fileid);
      paramParcel.writeString(this.aeskey);
      paramParcel.writeString(this.filemd5);
      paramParcel.writeInt(this.fNA);
      paramParcel.writeInt(this.fNB);
      AppMethodBeat.o(213466);
    }
  }
  
  static final class a
    implements DialogInterface.OnCancelListener
  {
    public final void onCancel(DialogInterface paramDialogInterface)
    {
      AppMethodBeat.i(12560);
      ChatroomInfoUI.cE(true);
      AppMethodBeat.o(12560);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.chatroom.ui.ChatroomInfoUI
 * JD-Core Version:    0.7.0.1
 */