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
import com.tencent.mm.ak.t;
import com.tencent.mm.chatroom.g.a.b;
import com.tencent.mm.chatroom.ui.preference.RoomCardPreference;
import com.tencent.mm.g.a.nh;
import com.tencent.mm.g.a.nh.b;
import com.tencent.mm.g.a.uj;
import com.tencent.mm.g.a.xq;
import com.tencent.mm.g.a.xq.b;
import com.tencent.mm.g.a.yr;
import com.tencent.mm.g.b.a.gq;
import com.tencent.mm.g.c.ax;
import com.tencent.mm.model.ab;
import com.tencent.mm.model.ap;
import com.tencent.mm.model.ay.a;
import com.tencent.mm.model.ay.b;
import com.tencent.mm.model.ay.b.a;
import com.tencent.mm.model.bp.a;
import com.tencent.mm.model.z;
import com.tencent.mm.plugin.messenger.foundation.a.a.n;
import com.tencent.mm.plugin.newtips.NewTipPreference;
import com.tencent.mm.plugin.report.kvdata.IMBehavior;
import com.tencent.mm.plugin.report.kvdata.IMBehaviorChattingOP;
import com.tencent.mm.plugin.report.kvdata.log_13835;
import com.tencent.mm.pluginsdk.ui.applet.ContactListExpandPreference;
import com.tencent.mm.pluginsdk.ui.applet.ContactListExpandPreference.a;
import com.tencent.mm.pluginsdk.ui.applet.r;
import com.tencent.mm.pluginsdk.ui.applet.s.b;
import com.tencent.mm.protocal.protobuf.cho;
import com.tencent.mm.sdk.event.EventCenter;
import com.tencent.mm.sdk.event.IEvent;
import com.tencent.mm.sdk.event.IListener;
import com.tencent.mm.sdk.platformtools.LocaleUtil;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMHandler;
import com.tencent.mm.sdk.platformtools.MMHandlerThread;
import com.tencent.mm.sdk.platformtools.MTimerHandler;
import com.tencent.mm.sdk.platformtools.MTimerHandler.CallBack;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.sdk.storage.MStorage.IOnStorageChange;
import com.tencent.mm.sdk.storage.MStorageEventData;
import com.tencent.mm.sdk.storage.MStorageEx;
import com.tencent.mm.sdk.storage.MStorageEx.IOnStorageChange;
import com.tencent.mm.storage.ah;
import com.tencent.mm.storage.ao;
import com.tencent.mm.storage.as;
import com.tencent.mm.storage.bv;
import com.tencent.mm.storage.bw;
import com.tencent.mm.storage.cn;
import com.tencent.mm.ui.base.h.d;
import com.tencent.mm.ui.base.preference.CheckBoxPreference;
import com.tencent.mm.ui.base.preference.KeyValuePreference;
import com.tencent.mm.ui.base.preference.MMPreference;
import com.tencent.mm.ui.base.preference.NormalIconPreference;
import com.tencent.mm.ui.base.preference.Preference;
import com.tencent.mm.ui.base.preference.PreferenceCategory;
import com.tencent.mm.ui.contact.u;
import com.tencent.mm.ui.e.e;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import junit.framework.Assert;

@com.tencent.mm.kernel.i
public class ChatroomInfoUI
  extends MMPreference
  implements com.tencent.mm.ak.i, com.tencent.mm.bh.a, a.b, MStorage.IOnStorageChange, MStorageEx.IOnStorageChange
{
  private static boolean guv = false;
  private as contact;
  private boolean dRx;
  private ProgressDialog gtM;
  private ProgressDialog gtN;
  private boolean gtO;
  private RoomCardPreference gtP;
  private Preference gtQ;
  private Preference gtR;
  private NormalIconPreference gtS;
  private NormalIconPreference gtT;
  private ContactListExpandPreference gtU;
  private CheckBoxPreference gtV;
  private CheckBoxPreference gtW;
  private CheckBoxPreference gtX;
  private KeyValuePreference gtY;
  private KeyValuePreference gtZ;
  private ah gtd;
  private int guA;
  private CheckBoxPreference gua;
  private NewTipPreference gub;
  private boolean guc;
  private boolean gud;
  private boolean gue;
  private boolean guf;
  private int gug;
  private boolean guh;
  private boolean gui;
  private int guj;
  private boolean guk;
  private boolean gul;
  private boolean gum;
  private boolean gun;
  private boolean guo;
  private com.tencent.mm.pluginsdk.ui.e gup;
  boolean guq;
  private IListener gur;
  int gus;
  private com.tencent.mm.ui.base.q gut;
  private String guu;
  private com.tencent.mm.roomsdk.a.c.a guw;
  private String gux;
  private com.tencent.mm.pluginsdk.c.b guy;
  private MTimerHandler guz;
  private MMHandler handler;
  private boolean isDeleteCancel;
  private String roomId;
  private com.tencent.mm.ui.base.preference.f screen;
  private SharedPreferences sp;
  
  public ChatroomInfoUI()
  {
    AppMethodBeat.i(12561);
    this.gtM = null;
    this.gtN = null;
    this.handler = new MMHandler(Looper.getMainLooper())
    {
      public final void handleMessage(Message paramAnonymousMessage)
      {
        AppMethodBeat.i(12507);
        ChatroomInfoUI.a(ChatroomInfoUI.this);
        AppMethodBeat.o(12507);
      }
    };
    this.sp = null;
    this.gue = false;
    this.guf = false;
    this.gui = false;
    this.gtd = null;
    this.guj = -1;
    this.guk = true;
    this.gul = false;
    this.gum = false;
    this.gun = false;
    this.guo = false;
    this.gup = new com.tencent.mm.pluginsdk.ui.e(new AbsListView.OnScrollListener()
    {
      public final void onScroll(AbsListView paramAnonymousAbsListView, int paramAnonymousInt1, int paramAnonymousInt2, int paramAnonymousInt3) {}
      
      public final void onScrollStateChanged(AbsListView paramAnonymousAbsListView, int paramAnonymousInt) {}
    });
    this.guq = false;
    this.gur = new ChatroomInfoUI.30(this);
    this.gus = -1;
    this.gut = null;
    this.guu = "";
    this.guw = null;
    this.gux = null;
    this.guy = new com.tencent.mm.pluginsdk.c.b()
    {
      public final void a(int paramAnonymousInt1, int paramAnonymousInt2, String paramAnonymousString, IEvent paramAnonymousIEvent)
      {
        AppMethodBeat.i(194087);
        if ((paramAnonymousIEvent instanceof nh))
        {
          paramAnonymousIEvent = (nh)paramAnonymousIEvent;
          Log.i("MicroMsg.ChatroomInfoUI", "onSceneEnd: errType = " + paramAnonymousInt1 + " errCode = " + paramAnonymousInt2 + " errMsg = " + paramAnonymousString);
          if (ChatroomInfoUI.z(ChatroomInfoUI.this) != null) {
            ChatroomInfoUI.z(ChatroomInfoUI.this).dismiss();
          }
          if ((paramAnonymousInt1 != 0) || (paramAnonymousInt2 != 0))
          {
            if (paramAnonymousInt2 == -21)
            {
              com.tencent.mm.ui.base.h.d(ChatroomInfoUI.this, ChatroomInfoUI.this.getString(2131764708), ChatroomInfoUI.this.getString(2131755998), new DialogInterface.OnClickListener()
              {
                public final void onClick(DialogInterface paramAnonymous2DialogInterface, int paramAnonymous2Int)
                {
                  AppMethodBeat.i(194086);
                  ChatroomInfoUI.this.finish();
                  AppMethodBeat.o(194086);
                }
              });
              AppMethodBeat.o(194087);
              return;
            }
            com.tencent.mm.ui.base.h.c(ChatroomInfoUI.this, ChatroomInfoUI.this.getString(2131764710), ChatroomInfoUI.this.getString(2131755998), true);
            AppMethodBeat.o(194087);
            return;
          }
          if ((paramAnonymousInt1 == 0) && (paramAnonymousInt2 == 0) && (ChatroomInfoUI.m(ChatroomInfoUI.this) != null))
          {
            paramAnonymousString = ChatroomInfoUI.X(paramAnonymousIEvent.dTs.dTe);
            paramAnonymousIEvent = ChatroomInfoUI.m(ChatroomInfoUI.this);
            if (paramAnonymousIEvent.KfY != null)
            {
              paramAnonymousIEvent = paramAnonymousIEvent.KfY.Kfo;
              paramAnonymousIEvent.bh(paramAnonymousString);
              paramAnonymousIEvent.amZ();
            }
            if (ChatroomInfoUI.f(ChatroomInfoUI.this) != null) {
              ChatroomInfoUI.f(ChatroomInfoUI.this).notifyDataSetChanged();
            }
            ChatroomInfoUI.this.setMMTitle(ChatroomInfoUI.this.getResources().getQuantityString(2131623963, paramAnonymousString.size(), new Object[] { Integer.valueOf(paramAnonymousString.size()) }));
          }
          ChatroomInfoUI.j(ChatroomInfoUI.this);
        }
        AppMethodBeat.o(194087);
      }
    };
    this.isDeleteCancel = false;
    this.guz = null;
    this.guA = 0;
    AppMethodBeat.o(12561);
  }
  
  private void DF(String paramString)
  {
    AppMethodBeat.i(12566);
    final int i = this.screen.bmj(paramString);
    paramString = getListView();
    com.tencent.mm.hellhoundlib.b.a locala = com.tencent.mm.hellhoundlib.b.c.a(i, new com.tencent.mm.hellhoundlib.b.a());
    com.tencent.mm.hellhoundlib.a.a.a(paramString, locala.axQ(), "com/tencent/mm/chatroom/ui/ChatroomInfoUI", "MatteHighLightItem", "(Ljava/lang/String;)V", "Undefined", "smoothScrollToPosition", "(I)V");
    paramString.smoothScrollToPosition(((Integer)locala.pG(0)).intValue());
    com.tencent.mm.hellhoundlib.a.a.a(paramString, "com/tencent/mm/chatroom/ui/ChatroomInfoUI", "MatteHighLightItem", "(Ljava/lang/String;)V", "Undefined", "smoothScrollToPosition", "(I)V");
    new MMHandler().postDelayed(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(12558);
        View localView = ((com.tencent.mm.ui.base.preference.a)ChatroomInfoUI.f(ChatroomInfoUI.this)).a(i, ChatroomInfoUI.this.getListView());
        if (localView != null) {
          com.tencent.mm.ui.i.a.c(ChatroomInfoUI.this.getContext(), localView);
        }
        AppMethodBeat.o(12558);
      }
    }, 10L);
    AppMethodBeat.o(12566);
  }
  
  private String DH(String paramString)
  {
    AppMethodBeat.i(12578);
    if (this.gtd == null)
    {
      AppMethodBeat.o(12578);
      return null;
    }
    paramString = this.gtd.getDisplayName(paramString);
    AppMethodBeat.o(12578);
    return paramString;
  }
  
  public static ArrayList<as> X(List<cho> paramList)
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
      cho localcho = (cho)paramList.next();
      as localas = new as();
      localas.setUsername(localcho.UserName);
      localas.setNickname(localcho.oUJ);
      localArrayList.add(localas);
    }
    AppMethodBeat.o(12590);
    return localArrayList;
  }
  
  private void amA()
  {
    AppMethodBeat.i(12588);
    if ((this.contact != null) && (this.gtQ != null))
    {
      this.contact = ((com.tencent.mm.plugin.messenger.foundation.a.l)com.tencent.mm.kernel.g.af(com.tencent.mm.plugin.messenger.foundation.a.l.class)).aSN().Kn(this.roomId);
      if (amB())
      {
        String str2 = this.contact.arI();
        Preference localPreference = this.gtQ;
        String str1 = str2;
        if (str2.length() <= 0) {
          str1 = getString(2131765591);
        }
        localPreference.setSummary(com.tencent.mm.pluginsdk.ui.span.l.c(this, str1));
        if (this.screen != null) {
          this.screen.notifyDataSetChanged();
        }
        AppMethodBeat.o(12588);
        return;
      }
      this.gtQ.setSummary(getString(2131764704));
    }
    AppMethodBeat.o(12588);
  }
  
  private boolean amB()
  {
    AppMethodBeat.i(12589);
    String str = this.contact.field_nickname;
    if ((!Util.isNullOrNil(str)) && (str.length() <= 50))
    {
      AppMethodBeat.o(12589);
      return true;
    }
    AppMethodBeat.o(12589);
    return false;
  }
  
  private void amC()
  {
    AppMethodBeat.i(12591);
    com.tencent.mm.plugin.report.service.h.CyF.kvStat(10170, "1");
    Object localObject = new LinkedList();
    ((List)localObject).add(this.roomId);
    ((List)localObject).add(z.aTY());
    localObject = Util.listToString((List)localObject, ",");
    Intent localIntent = new Intent();
    localIntent.putExtra("titile", getString(2131755266));
    localIntent.putExtra("list_type", 0);
    localIntent.putExtra("list_attr", of(u.PWU));
    localIntent.putExtra("always_select_contact", (String)localObject);
    localIntent.putExtra("create_group_recommend", true);
    com.tencent.mm.br.c.f(this, ".ui.contact.SelectContactUI", localIntent);
    AppMethodBeat.o(12591);
  }
  
  private boolean amD()
  {
    AppMethodBeat.i(12600);
    if ((this.gtd != null) && (this.gtd.amD()))
    {
      AppMethodBeat.o(12600);
      return true;
    }
    AppMethodBeat.o(12600);
    return false;
  }
  
  private void amq()
  {
    AppMethodBeat.i(12563);
    Log.i("MicroMsg.ChatroomInfoUI", "[doChatroomDetailCgi] :%s", new Object[] { this.roomId });
    com.tencent.mm.roomsdk.a.c.a locala = com.tencent.mm.roomsdk.a.b.bhF(this.roomId).Dt(this.roomId);
    locala.b(new com.tencent.mm.roomsdk.a.b.b() {});
    locala.aJu();
    AppMethodBeat.o(12563);
  }
  
  private void amr()
  {
    AppMethodBeat.i(194100);
    if (this.gtN == null)
    {
      getString(2131755998);
      this.gtN = com.tencent.mm.ui.base.h.a(this, getString(2131756029), false, new DialogInterface.OnCancelListener()
      {
        public final void onCancel(DialogInterface paramAnonymousDialogInterface)
        {
          AppMethodBeat.i(194076);
          ChatroomInfoUI.a(ChatroomInfoUI.this, true);
          AppMethodBeat.o(194076);
        }
      });
      AppMethodBeat.o(194100);
      return;
    }
    this.gtN.show();
    AppMethodBeat.o(194100);
  }
  
  private void ams()
  {
    AppMethodBeat.i(194101);
    if (this.gtN != null) {
      this.gtN.dismiss();
    }
    AppMethodBeat.o(194101);
  }
  
  private void amt()
  {
    AppMethodBeat.i(12573);
    com.tencent.mm.plugin.report.service.h.CyF.idkeyStat(219L, 7L, 1L, true);
    Object localObject = com.tencent.mm.model.v.Ic(this.roomId);
    String str = Util.listToString((List)localObject, ",");
    if (localObject != null) {
      this.gug = ((List)localObject).size();
    }
    localObject = new Intent();
    ((Intent)localObject).putExtra("titile", getString(2131755268));
    ((Intent)localObject).putExtra("list_type", 1);
    ((Intent)localObject).putExtra("list_attr", of(u.PWT));
    ((Intent)localObject).putExtra("always_select_contact", str);
    ((Intent)localObject).putExtra("scene", 3);
    boolean bool = ab.IB(this.contact.field_username);
    if ((!as.bjq(this.contact.field_username)) && (!bool)) {
      ((Intent)localObject).putExtra("without_openim", true);
    }
    if ((ab.Ix(this.roomId)) && (!bool)) {}
    for (bool = true;; bool = false)
    {
      ((Intent)localObject).putExtra("KBlockOpenImFav", bool);
      ((Intent)localObject).putExtra("create_group_recommend", true);
      ((Intent)localObject).putExtra("is_select_record_msg_mode", ab.Ix(this.roomId));
      ((Intent)localObject).putExtra("menu_mode", 2);
      ((Intent)localObject).putExtra("chatroomName", this.roomId);
      com.tencent.mm.br.c.c(this, ".ui.contact.SelectContactUI", (Intent)localObject, 1);
      AppMethodBeat.o(12573);
      return;
    }
  }
  
  private void amu()
  {
    AppMethodBeat.i(12574);
    if (this.dRx)
    {
      amt();
      AppMethodBeat.o(12574);
      return;
    }
    amC();
    AppMethodBeat.o(12574);
  }
  
  private void amv()
  {
    AppMethodBeat.i(12576);
    com.tencent.mm.plugin.report.service.h.CyF.idkeyStat(219L, 8L, 1L, true);
    Object localObject = com.tencent.mm.model.v.Ic(this.roomId);
    String str = Util.listToString((List)localObject, ",");
    this.gug = ((List)localObject).size();
    localObject = new Intent();
    ((Intent)localObject).putExtra("RoomInfo_Id", this.roomId);
    ((Intent)localObject).putExtra("Is_Chatroom", true);
    ((Intent)localObject).putExtra("Chatroom_member_list", str);
    ((Intent)localObject).putExtra("room_member_count", this.gug);
    ((Intent)localObject).putExtra("Is_RoomOwner", this.gue);
    ((Intent)localObject).putExtra("list_attr", u.PWT);
    ((Intent)localObject).putExtra("room_name", this.contact.field_username);
    ((Intent)localObject).putExtra("room_owner_name", this.gtd.field_roomowner);
    ((Intent)localObject).setClass(this, SelectDelMemberUI.class);
    startActivityForResult((Intent)localObject, 7);
    AppMethodBeat.o(12576);
  }
  
  private String amw()
  {
    AppMethodBeat.i(12579);
    as localas = ((com.tencent.mm.plugin.messenger.foundation.a.l)com.tencent.mm.kernel.g.af(com.tencent.mm.plugin.messenger.foundation.a.l.class)).aSN().Kn(this.gtd.field_roomowner);
    if ((localas != null) && ((int)localas.gMZ > 0)) {}
    for (Object localObject2 = localas.field_conRemark;; localObject2 = null)
    {
      Object localObject1 = localObject2;
      if (Util.isNullOrNil((String)localObject2)) {
        localObject1 = DH(this.gtd.field_roomowner);
      }
      localObject2 = localObject1;
      if (Util.isNullOrNil((String)localObject1))
      {
        localObject2 = localObject1;
        if (localas != null)
        {
          localObject2 = localObject1;
          if ((int)localas.gMZ > 0) {
            localObject2 = localas.arI();
          }
        }
      }
      localObject1 = localObject2;
      if (Util.isNullOrNil((String)localObject2)) {
        localObject1 = this.gtd.field_roomowner;
      }
      AppMethodBeat.o(12579);
      return localObject1;
    }
  }
  
  private void amx()
  {
    AppMethodBeat.i(12584);
    if (this.gtU != null)
    {
      if (this.dRx)
      {
        com.tencent.f.h.RTc.aX(new Runnable()
        {
          public final void run()
          {
            AppMethodBeat.i(194085);
            if (ChatroomInfoUI.c(ChatroomInfoUI.this) == null)
            {
              Log.w("MicroMsg.ChatroomInfoUI", "[updateRoomPref] member == null");
              AppMethodBeat.o(194085);
              return;
            }
            ChatroomInfoUI.a(ChatroomInfoUI.this, ((com.tencent.mm.plugin.chatroom.a.c)com.tencent.mm.kernel.g.af(com.tencent.mm.plugin.chatroom.a.c.class)).aSX().Kg(ChatroomInfoUI.b(ChatroomInfoUI.this)));
            Object localObject1 = com.tencent.mm.model.v.Ic(ChatroomInfoUI.b(ChatroomInfoUI.this));
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
                if ((ChatroomInfoUI.c(ChatroomInfoUI.this).bjf(str)) || (ChatroomInfoUI.c(ChatroomInfoUI.this).JO(str))) {
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
            com.tencent.f.h.RTc.aV(new Runnable()
            {
              public final void run()
              {
                AppMethodBeat.i(194084);
                if (ChatroomInfoUI.e(ChatroomInfoUI.this) <= 1)
                {
                  ChatroomInfoUI.f(ChatroomInfoUI.this).jdMethod_do("del_selector_btn", true);
                  ChatroomInfoUI.m(ChatroomInfoUI.this).zU(true).zV(false).gpH();
                }
                for (;;)
                {
                  ChatroomInfoUI.m(ChatroomInfoUI.this).H(ChatroomInfoUI.b(ChatroomInfoUI.this), this.guK);
                  ChatroomInfoUI.m(ChatroomInfoUI.this).zT(true);
                  AppMethodBeat.o(194084);
                  return;
                  ChatroomInfoUI.m(ChatroomInfoUI.this).zU(true).zV(ChatroomInfoUI.d(ChatroomInfoUI.this)).gpH();
                }
              }
            });
            AppMethodBeat.o(194085);
          }
        });
        AppMethodBeat.o(12584);
        return;
      }
      LinkedList localLinkedList = new LinkedList();
      localLinkedList.add(this.roomId);
      this.gtU.H(this.roomId, localLinkedList);
    }
    AppMethodBeat.o(12584);
  }
  
  private void amy()
  {
    AppMethodBeat.i(12586);
    if (this.sp == null) {
      this.sp = getSharedPreferences(getPackageName() + "_preferences", 0);
    }
    boolean bool;
    if (this.contact != null)
    {
      if (!this.dRx) {
        break label140;
      }
      if (this.contact.fuH == 0)
      {
        bool = true;
        this.guh = bool;
      }
    }
    else
    {
      label76:
      if (!this.guh) {
        break label161;
      }
      setTitleMuteIconVisibility(0);
      if (this.gtV != null) {
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
      if (this.gtO) {
        break label76;
      }
      this.guh = this.contact.Zx();
      break label76;
      label161:
      setTitleMuteIconVisibility(8);
      if (this.gtV != null) {
        this.sp.edit().putBoolean("room_notify_new_msg", false).commit();
      }
    }
  }
  
  private void amz()
  {
    AppMethodBeat.i(12587);
    Object localObject;
    RoomCardPreference localRoomCardPreference;
    if ((this.contact != null) && (this.gtP != null))
    {
      localObject = com.tencent.mm.model.v.Ig(this.roomId);
      if ((localObject != null) && (((String)localObject).length() > 0)) {
        break label136;
      }
      this.gtP.dEF = false;
      this.contact = ((com.tencent.mm.plugin.messenger.foundation.a.l)com.tencent.mm.kernel.g.af(com.tencent.mm.plugin.messenger.foundation.a.l.class)).aSN().Kn(this.roomId);
      if (!amB()) {
        break label159;
      }
      String str = this.contact.arJ();
      localRoomCardPreference = this.gtP;
      localObject = str;
      if (str.length() <= 0) {
        localObject = getString(2131765591);
      }
    }
    label136:
    label159:
    for (localRoomCardPreference.gCf = com.tencent.mm.pluginsdk.ui.span.l.c(this, (CharSequence)localObject);; this.gtP.gCf = getString(2131764704))
    {
      this.screen.notifyDataSetChanged();
      AppMethodBeat.o(12587);
      return;
      this.gtP.dEF = true;
      this.gtP.gCg = com.tencent.mm.pluginsdk.ui.span.l.c(this, (CharSequence)localObject);
      break;
    }
  }
  
  private int of(int paramInt)
  {
    AppMethodBeat.i(12575);
    if (!u.gVd())
    {
      AppMethodBeat.o(12575);
      return paramInt;
    }
    if (this.contact != null)
    {
      String str = this.contact.field_username;
      if ((as.bjp(str)) || (as.bjq(str)) || (ab.IB(str)))
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
  
  private void updateTitle()
  {
    AppMethodBeat.i(12583);
    if (this.dRx)
    {
      this.gug = com.tencent.mm.model.v.Ie(this.roomId);
      if (this.gug == 0)
      {
        setMMTitle(getString(2131764812));
        AppMethodBeat.o(12583);
        return;
      }
      setMMTitle(getString(2131760811, new Object[] { getString(2131764812), Integer.valueOf(this.gug) }));
    }
    AppMethodBeat.o(12583);
  }
  
  public final void DG(String paramString)
  {
    AppMethodBeat.i(194102);
    Log.i("MicroMsg.ChatroomInfoUI", "delete chatroom %s", new Object[] { paramString });
    this.guw = com.tencent.mm.roomsdk.a.b.bhF(paramString).Du(paramString);
    this.guw.d(new ChatroomInfoUI.15(this, paramString)).aJu();
    AppMethodBeat.o(194102);
  }
  
  public final void ami()
  {
    AppMethodBeat.i(194104);
    boolean bool;
    Object localObject;
    if (this.gtU != null)
    {
      if (this.dRx)
      {
        amx();
        this.gtU.notifyChanged();
      }
    }
    else
    {
      bool = ((com.tencent.mm.plugin.chatroom.a.c)com.tencent.mm.kernel.g.af(com.tencent.mm.plugin.chatroom.a.c.class)).akx(this.roomId);
      if (amD()) {
        break label243;
      }
      this.screen.jdMethod_do("manage_room", true);
      localObject = this.screen;
      if (bool) {
        break label238;
      }
      bool = true;
      label82:
      ((com.tencent.mm.ui.base.preference.f)localObject).jdMethod_do("room_manager_view", bool);
      label93:
      if (((amD()) || (this.gug < r.MAX_COUNT)) && ((!amD()) || (this.gug < r.MAX_COUNT - 1))) {
        break label274;
      }
      this.screen.jdMethod_do("see_room_member", false);
      this.gtR.setTitle(getString(2131765110));
    }
    for (;;)
    {
      if (ab.Iy(this.roomId)) {
        this.screen.jdMethod_do("room_manager_view", true);
      }
      this.screen.notifyDataSetChanged();
      AppMethodBeat.o(194104);
      return;
      if (this.gtO) {
        break;
      }
      localObject = new LinkedList();
      ((List)localObject).add(this.roomId);
      this.gtU.H(this.roomId, (List)localObject);
      break;
      label238:
      bool = false;
      break label82;
      label243:
      this.screen.jdMethod_do("room_manager_view", true);
      this.screen.jdMethod_do("manage_room", false);
      break label93;
      label274:
      this.screen.jdMethod_do("see_room_member", true);
    }
  }
  
  public final void amj()
  {
    AppMethodBeat.i(194103);
    updateTitle();
    if (this.gtd != null) {
      this.gug = this.gtd.bax().size();
    }
    if (((!this.gue) && (this.gug >= r.MAX_COUNT)) || ((this.gue) && (this.gug >= r.MAX_COUNT - 1)))
    {
      this.screen.jdMethod_do("see_room_member", false);
      this.gtR.setTitle(getString(2131765110));
    }
    AppMethodBeat.o(194103);
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
    return 2132017252;
  }
  
  public final void h(String paramString1, String paramString2, String paramString3)
  {
    AppMethodBeat.i(12598);
    if ((paramString1.equals(this.roomId)) && (this.gtU != null)) {
      this.gtU.notifyChanged();
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
    if (this.dRx) {
      if (this.gug == 0)
      {
        setMMTitle(getString(2131764812));
        localObject1 = null;
        if (this.gtd != null)
        {
          localObject1 = this.gtd.field_roomowner;
          this.gug = this.gtd.bax().size();
        }
        if (!Util.isNullOrNil((String)localObject1)) {
          break label1363;
        }
        this.gud = false;
        this.gue = false;
        this.guf = false;
        Log.d("MicroMsg.ChatroomInfoUI", "initBaseChatRoomView()");
        this.gtU = ((ContactListExpandPreference)this.screen.bmg("roominfo_contact_anchor"));
        this.gtU.a(this.screen, this.gtU.mKey);
        this.gtT = ((NormalIconPreference)this.screen.bmg("del_selector_btn"));
        this.gtS = ((NormalIconPreference)this.screen.bmg("add_selector_btn"));
        this.gtQ = this.screen.bmg("room_name");
        this.gtP = ((RoomCardPreference)this.screen.bmg("room_card"));
        this.gtR = this.screen.bmg("see_room_member");
        this.gtV = ((CheckBoxPreference)this.screen.bmg("room_notify_new_msg"));
        this.gtW = ((CheckBoxPreference)this.screen.bmg("room_save_to_contact"));
        this.gtX = ((CheckBoxPreference)this.screen.bmg("room_placed_to_the_top"));
        this.gtY = ((KeyValuePreference)this.screen.bmg("room_nickname"));
        this.gtZ = ((KeyValuePreference)this.screen.bmg("room_remark"));
        this.gub = ((NewTipPreference)this.screen.bmg("manage_room"));
        this.gtU.zU(true).zV(true).gpH();
        bool = ((com.tencent.mm.plugin.chatroom.a.c)com.tencent.mm.kernel.g.af(com.tencent.mm.plugin.chatroom.a.c.class)).akx(this.roomId);
        if (amD()) {
          break label1388;
        }
        this.screen.jdMethod_do("manage_room", true);
        localObject1 = this.screen;
        if (bool) {
          break label1383;
        }
        bool = true;
        label414:
        ((com.tencent.mm.ui.base.preference.f)localObject1).jdMethod_do("room_manager_view", bool);
        label426:
        if ((ab.Ix(this.roomId)) && (com.tencent.mm.model.v.aTU()))
        {
          localObject1 = ((com.tencent.mm.plugin.chatroom.a.c)com.tencent.mm.kernel.g.af(com.tencent.mm.plugin.chatroom.a.c.class)).aSX().Kd(this.roomId);
          if ((localObject1 != null) && ((((ah)localObject1).field_chatroomStatus & 0x20000) != 131072L) && ((((ah)localObject1).field_chatroomStatus & 0x10000) == 65536L) && (com.tencent.mm.model.v.aTS()))
          {
            this.guo = true;
            this.gub.a(this.screen);
            com.tencent.mm.plugin.newtips.a.exl().h(this.gub);
            com.tencent.mm.plugin.newtips.a.g.a(this.gub);
          }
        }
        if (this.gtd != null)
        {
          this.gtU.beT(this.gtd.field_roomowner);
          if (!Util.isNullOrNil(this.gtd.field_roomowner)) {
            this.gtU.KfY.Kfo.KfO = true;
          }
        }
        this.gtU.gpG();
        this.gtU.gpA();
        this.screen.jdMethod_do("add_selector_btn", true);
        this.screen.jdMethod_do("del_selector_btn", true);
        this.screen.jdMethod_do("room_name", false);
        this.screen.jdMethod_do("room_qr_code", false);
        this.screen.jdMethod_do("chatroom_info_chexboxes", true);
        this.screen.jdMethod_do("room_card", false);
        this.screen.jdMethod_do("room_upgrade_entry", true);
        this.screen.jdMethod_do("chat_room_story_videos", true);
        if (((amD()) || (this.gug < r.MAX_COUNT)) && ((!amD()) || (this.gug < r.MAX_COUNT - 1))) {
          break label1419;
        }
        this.screen.jdMethod_do("see_room_member", false);
        this.gtR.setTitle(getString(2131765110));
        label783:
        if (as.bjq(this.roomId)) {
          break label1436;
        }
        this.screen.jdMethod_do("room_openim_about", true);
        label807:
        Log.d("MicroMsg.ChatroomInfoUI", "updatePlaceTop()");
        if (this.sp == null) {
          this.sp = getSharedPreferences(getPackageName() + "_preferences", 0);
        }
        if (this.gtX != null)
        {
          if (this.contact == null) {
            break label1550;
          }
          this.sp.edit().putBoolean("room_placed_to_the_top", ((com.tencent.mm.plugin.messenger.foundation.a.l)com.tencent.mm.kernel.g.af(com.tencent.mm.plugin.messenger.foundation.a.l.class)).aST().bkg(this.contact.field_username)).commit();
        }
        label918:
        this.screen.notifyDataSetChanged();
        Log.d("MicroMsg.ChatroomInfoUI", "updateSaveToContact()");
        if (this.sp == null) {
          this.sp = getSharedPreferences(getPackageName() + "_preferences", 0);
        }
        if (this.gtW == null) {
          break label1608;
        }
        localObject1 = ((com.tencent.mm.plugin.messenger.foundation.a.l)com.tencent.mm.kernel.g.af(com.tencent.mm.plugin.messenger.foundation.a.l.class)).aSN().Kn(this.roomId);
        if (localObject1 != null) {
          break label1577;
        }
        Log.e("MicroMsg.ChatroomInfoUI", "contact == null !!!");
        label1021:
        Log.d("MicroMsg.ChatroomInfoUI", "updateDisplayNickname()");
        if (this.sp == null) {
          this.sp = getSharedPreferences(getPackageName() + "_preferences", 0);
        }
        localObject1 = ((com.tencent.mm.plugin.chatroom.a.c)com.tencent.mm.kernel.g.af(com.tencent.mm.plugin.chatroom.a.c.class)).aSX().Kd(this.roomId);
        if (localObject1 != null) {
          break label1620;
        }
        Log.e("MicroMsg.ChatroomInfoUI", "members == null !!!");
        label1108:
        this.guj = ((com.tencent.mm.plugin.messenger.foundation.a.l)com.tencent.mm.kernel.g.af(com.tencent.mm.plugin.messenger.foundation.a.l.class)).eiy().aEN(this.roomId);
        this.guj = ((com.tencent.mm.plugin.messenger.foundation.a.l)com.tencent.mm.kernel.g.af(com.tencent.mm.plugin.messenger.foundation.a.l.class)).eiy().aEN(this.roomId);
      }
    }
    for (;;)
    {
      if (this.gtU != null)
      {
        if ((!this.dRx) && (this.gtO)) {
          this.gtU.bg(new ArrayList());
        }
        getListView().setOnScrollListener(this.gup);
        this.gtU.a(this.gup);
        this.gtU.a(new s.b()
        {
          public final boolean oi(int paramAnonymousInt)
          {
            return true;
          }
        });
        localObject1 = this.gtU;
        localObject2 = new ChatroomInfoUI.33(this);
        if (((ContactListExpandPreference)localObject1).KfY != null) {
          ((ContactListExpandPreference)localObject1).KfY.ko = ((View.OnClickListener)localObject2);
        }
        this.gtU.a(new ContactListExpandPreference.a()
        {
          public final void amF()
          {
            AppMethodBeat.i(194064);
            if (ChatroomInfoUI.m(ChatroomInfoUI.this) != null) {
              ChatroomInfoUI.m(ChatroomInfoUI.this).gpE();
            }
            AppMethodBeat.o(194064);
          }
          
          public final void e(ViewGroup paramAnonymousViewGroup, int paramAnonymousInt)
          {
            AppMethodBeat.i(194063);
            String str = ChatroomInfoUI.m(ChatroomInfoUI.this).aio(paramAnonymousInt);
            paramAnonymousViewGroup = Util.nullAsNil(ChatroomInfoUI.m(ChatroomInfoUI.this).aiq(paramAnonymousInt));
            Object localObject;
            if (Util.isNullOrNil(paramAnonymousViewGroup))
            {
              com.tencent.mm.kernel.g.aAi();
              localObject = ((com.tencent.mm.plugin.messenger.foundation.a.l)com.tencent.mm.kernel.g.af(com.tencent.mm.plugin.messenger.foundation.a.l.class)).aSO().aEZ(str);
              if ((localObject != null) && (!Util.isNullOrNil(((cn)localObject).field_encryptUsername))) {
                paramAnonymousViewGroup = ((cn)localObject).field_conRemark;
              }
            }
            for (;;)
            {
              if (Util.isNullOrNil(str))
              {
                AppMethodBeat.o(194063);
                return;
              }
              localObject = new Intent();
              ((Intent)localObject).putExtra("Contact_User", str);
              ((Intent)localObject).putExtra("Contact_RemarkName", paramAnonymousViewGroup);
              if ((ChatroomInfoUI.n(ChatroomInfoUI.this)) && (ChatroomInfoUI.c(ChatroomInfoUI.this) != null)) {
                ((Intent)localObject).putExtra("Contact_RoomNickname", ChatroomInfoUI.c(ChatroomInfoUI.this).getDisplayName(str));
              }
              ((Intent)localObject).putExtra("Contact_Nick", Util.nullAsNil(ChatroomInfoUI.m(ChatroomInfoUI.this).aip(paramAnonymousInt)));
              ((Intent)localObject).putExtra("Contact_RoomMember", true);
              ((Intent)localObject).putExtra("room_name", ChatroomInfoUI.o(ChatroomInfoUI.this).field_username);
              paramAnonymousViewGroup = ((com.tencent.mm.plugin.messenger.foundation.a.l)com.tencent.mm.kernel.g.af(com.tencent.mm.plugin.messenger.foundation.a.l.class)).aSN().Kn(str);
              if ((paramAnonymousViewGroup != null) && ((int)paramAnonymousViewGroup.gMZ > 0) && (com.tencent.mm.contact.c.oR(paramAnonymousViewGroup.field_type)))
              {
                uj localuj = new uj();
                localuj.eaI.intent = ((Intent)localObject);
                localuj.eaI.username = str;
                EventCenter.instance.publish(localuj);
              }
              if (ChatroomInfoUI.n(ChatroomInfoUI.this))
              {
                com.tencent.mm.plugin.report.service.h.CyF.idkeyStat(219L, 9L, 1L, true);
                if ((paramAnonymousViewGroup != null) && (paramAnonymousViewGroup.gBM())) {
                  com.tencent.mm.plugin.report.service.h.CyF.kvStat(10298, paramAnonymousViewGroup.field_username + ",14");
                }
                ((Intent)localObject).putExtra("Contact_Scene", 14);
              }
              for (;;)
              {
                ((Intent)localObject).putExtra("Is_RoomOwner", ChatroomInfoUI.q(ChatroomInfoUI.this));
                ((Intent)localObject).putExtra("Contact_ChatRoomId", ChatroomInfoUI.b(ChatroomInfoUI.this));
                if (ab.Iy(ChatroomInfoUI.b(ChatroomInfoUI.this)))
                {
                  paramAnonymousViewGroup = new gq();
                  paramAnonymousViewGroup.us(ChatroomInfoUI.b(ChatroomInfoUI.this));
                  paramAnonymousViewGroup.erw = 12L;
                  paramAnonymousViewGroup.bfK();
                }
                ((Intent)localObject).putExtra("CONTACT_INFO_UI_SOURCE", 8);
                com.tencent.mm.br.c.b(ChatroomInfoUI.this, "profile", ".ui.ContactInfoUI", (Intent)localObject);
                AppMethodBeat.o(194063);
                return;
                if (ChatroomInfoUI.p(ChatroomInfoUI.this))
                {
                  ((Intent)localObject).putExtra("Contact_Scene", 44);
                  if (!z.Im(paramAnonymousViewGroup.field_username)) {
                    ((Intent)localObject).putExtra("Contact_IsLBSFriend", true);
                  }
                }
              }
            }
          }
          
          public final void og(int paramAnonymousInt)
          {
            AppMethodBeat.i(194062);
            ChatroomInfoUI.l(ChatroomInfoUI.this);
            AppMethodBeat.o(194062);
          }
          
          public final void oh(int paramAnonymousInt)
          {
            AppMethodBeat.i(194065);
            ChatroomInfoUI.r(ChatroomInfoUI.this);
            AppMethodBeat.o(194065);
          }
        });
      }
      setBackBtn(new MenuItem.OnMenuItemClickListener()
      {
        public final boolean onMenuItemClick(MenuItem paramAnonymousMenuItem)
        {
          AppMethodBeat.i(194066);
          ChatroomInfoUI.this.finish();
          AppMethodBeat.o(194066);
          return true;
        }
      });
      AppMethodBeat.o(12570);
      return;
      if (this.gtd != null) {
        this.gug = this.gtd.bax().size();
      }
      setMMTitle(getString(2131760811, new Object[] { getString(2131764812), Integer.valueOf(this.gug) }));
      break;
      label1363:
      this.gud = true;
      this.gue = ((String)localObject1).equals(z.aTY());
      break label97;
      label1383:
      bool = false;
      break label414;
      label1388:
      this.screen.jdMethod_do("room_manager_view", true);
      this.screen.jdMethod_do("manage_room", false);
      break label426;
      label1419:
      this.screen.jdMethod_do("see_room_member", true);
      break label783;
      label1436:
      this.screen.jdMethod_do("chatroom_bottom_pc", true);
      this.screen.jdMethod_do("room_openim_about", false);
      localObject1 = getString(2131764746);
      Object localObject2 = getString(2131764747);
      int i = ((String)localObject1).lastIndexOf((String)localObject2);
      if (i < 0) {
        break label807;
      }
      int j = ((String)localObject2).length();
      localObject1 = new SpannableStringBuilder((CharSequence)localObject1);
      ((SpannableStringBuilder)localObject1).setSpan(new ChatroomInfoUI.4(this), i, j + i, 18);
      this.screen.bmg("room_openim_about").setTitle((CharSequence)localObject1);
      break label807;
      label1550:
      this.sp.edit().putBoolean("room_placed_to_the_top", false).commit();
      break label918;
      label1577:
      this.sp.edit().putBoolean("room_save_to_contact", com.tencent.mm.contact.c.oR(((ax)localObject1).field_type)).commit();
      label1608:
      this.screen.notifyDataSetChanged();
      break label1021;
      label1620:
      this.guc = ((ah)localObject1).gBx();
      this.gua = ((CheckBoxPreference)this.screen.bmg("room_msg_show_username"));
      if (this.gua != null) {
        this.sp.edit().putBoolean("room_msg_show_username", this.guc).commit();
      }
      this.screen.notifyDataSetChanged();
      break label1108;
      if (this.gtO)
      {
        this.gue = false;
        this.guf = false;
        setMMTitle(getString(2131764711));
        this.gtU = ((ContactListExpandPreference)this.screen.bmg("roominfo_contact_anchor"));
        this.gtU.a(this.screen, this.gtU.mKey);
        this.gtU.zU(false).zV(false);
        this.gtU.a(new s.b()
        {
          public final boolean oi(int paramAnonymousInt)
          {
            return true;
          }
        });
        this.screen.removeAll();
        this.screen.c(new PreferenceCategory(this));
        this.screen.c(this.gtU);
        localObject1 = this.roomId;
        localObject2 = new nh();
        ((nh)localObject2).dTr.dRj = ((String)localObject1);
        EventCenter.instance.publish((IEvent)localObject2);
        getString(2131755998);
        this.gtM = com.tencent.mm.ui.base.h.a(this, getString(2131764709), true, new DialogInterface.OnCancelListener()
        {
          public final void onCancel(DialogInterface paramAnonymousDialogInterface)
          {
            AppMethodBeat.i(194088);
            ChatroomInfoUI.a(this.guN);
            AppMethodBeat.o(194088);
          }
        });
        this.screen.notifyDataSetChanged();
      }
    }
  }
  
  public void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
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
        ((com.tencent.mm.plugin.messenger.foundation.a.v)com.tencent.mm.kernel.g.af(com.tencent.mm.plugin.messenger.foundation.a.v.class)).Qm(3);
        AppMethodBeat.o(12569);
        return;
      }
      if (paramIntent == null)
      {
        AppMethodBeat.o(12569);
        return;
      }
      String str = paramIntent.getStringExtra("Select_Contact");
      ChatroomInfoUI.LocalHistoryInfo localLocalHistoryInfo = (ChatroomInfoUI.LocalHistoryInfo)paramIntent.getParcelableExtra("select_record_msg_info");
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
      paramIntent = Util.stringsToList(paramIntent.split(","));
      paramIntent = com.tencent.mm.roomsdk.a.b.bhF(this.roomId).a(this.roomId, paramIntent, 0);
      paramIntent.b(new com.tencent.mm.roomsdk.a.b.b() {});
      paramIntent.c(new com.tencent.mm.roomsdk.a.b.b() {});
      paramIntent.a(this, getString(2131755998), getString(2131764675), true, true, new ChatroomInfoUI.19(this, paramIntent));
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
      if (!Util.isNullOrNil(paramIntent))
      {
        EventCenter.instance.publish(new yr());
        this.contact.setNickname(paramIntent);
        ((com.tencent.mm.plugin.messenger.foundation.a.l)com.tencent.mm.kernel.g.af(com.tencent.mm.plugin.messenger.foundation.a.l.class)).aSN().ao(this.contact);
        amA();
      }
      AppMethodBeat.o(12569);
      return;
      if (paramInt2 != 0) {
        break;
      }
      this.gus = -1;
      AppMethodBeat.o(12569);
      return;
      if (paramInt2 == -1) {
        amz();
      }
    }
    AppMethodBeat.o(12569);
  }
  
  public void onConfigurationChanged(Configuration paramConfiguration)
  {
    AppMethodBeat.i(12565);
    super.onConfigurationChanged(paramConfiguration);
    this.gtU.notifyChanged();
    AppMethodBeat.o(12565);
  }
  
  public void onCreate(final Bundle paramBundle)
  {
    AppMethodBeat.i(12562);
    super.onCreate(paramBundle);
    com.tencent.mm.kernel.g.aAg().hqi.a(480, this);
    com.tencent.mm.pluginsdk.c.b.a(nh.class.getName(), this.guy);
    paramBundle = this.gur.alive();
    Assert.assertNotNull(this);
    keep(paramBundle);
    com.tencent.mm.kernel.g.aAh().azQ().add(this);
    ((com.tencent.mm.plugin.chatroom.a.c)com.tencent.mm.kernel.g.af(com.tencent.mm.plugin.chatroom.a.c.class)).aSX().add(this);
    if (com.tencent.mm.bh.g.jpy != null) {
      com.tencent.mm.bh.g.jpy.a(this);
    }
    this.roomId = getIntent().getStringExtra("RoomInfo_Id");
    this.contact = ((com.tencent.mm.plugin.messenger.foundation.a.l)com.tencent.mm.kernel.g.af(com.tencent.mm.plugin.messenger.foundation.a.l.class)).aSN().Kn(this.roomId);
    this.guk = true;
    this.dRx = getIntent().getBooleanExtra("Is_Chatroom", true);
    this.gtO = getIntent().getBooleanExtra("Is_Lbsroom", false);
    this.gul = getIntent().getBooleanExtra("fromChatting", false);
    this.gum = getIntent().getBooleanExtra("isShowSetMuteAnimation", false);
    this.guu = (getPackageName() + "_preferences");
    if (this.dRx)
    {
      this.gtd = ((com.tencent.mm.plugin.chatroom.a.c)com.tencent.mm.kernel.g.af(com.tencent.mm.plugin.chatroom.a.c.class)).aSX().Kd(this.roomId);
      if (this.gtd != null) {
        this.guf = this.gtd.bjf(z.aTY());
      }
    }
    initView();
    if (this.dRx)
    {
      paramBundle = new ChatroomInfoUI.20(this);
      if (this.gtd == null)
      {
        ay.a.iDq.a(this.roomId, "", paramBundle);
        AppMethodBeat.o(12562);
        return;
      }
      if (System.currentTimeMillis() - this.gtd.field_modifytime >= 86400000L) {
        com.tencent.mm.kernel.g.aAk().postToWorker(new Runnable()
        {
          public final void run()
          {
            AppMethodBeat.i(12543);
            ay.a.iDq.a(ChatroomInfoUI.c(ChatroomInfoUI.this).field_chatroomname, "", paramBundle);
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
    if (com.tencent.mm.bh.g.jpy != null) {
      com.tencent.mm.bh.g.jpy.a(this);
    }
    com.tencent.mm.kernel.g.aAh().azQ().remove(this);
    com.tencent.mm.ui.i.a.dismiss();
    com.tencent.mm.kernel.g.aAg().hqi.b(480, this);
    EventCenter.instance.removeListener(this.gur);
    com.tencent.mm.pluginsdk.c.b.b(nh.class.getName(), this.guy);
    if (com.tencent.mm.kernel.g.aAc())
    {
      ((com.tencent.mm.plugin.messenger.foundation.a.l)com.tencent.mm.kernel.g.af(com.tencent.mm.plugin.messenger.foundation.a.l.class)).aSN().remove(this);
      ((com.tencent.mm.plugin.chatroom.a.c)com.tencent.mm.kernel.g.af(com.tencent.mm.plugin.chatroom.a.c.class)).aSX().remove(this);
    }
    if (com.tencent.mm.bh.g.jpy != null) {
      com.tencent.mm.bh.g.jpy.b(this);
    }
    if (this.guz != null) {
      this.guz.stopTimer();
    }
    super.onDestroy();
    AppMethodBeat.o(12568);
  }
  
  public void onNotifyChange(int paramInt, MStorageEx paramMStorageEx, Object paramObject)
  {
    AppMethodBeat.i(12596);
    if ((paramObject == null) || (!(paramObject instanceof String)))
    {
      Log.d("MicroMsg.ChatroomInfoUI", "onNotifyChange obj not String event:%d stg:%s obj:%s", new Object[] { Integer.valueOf(paramInt), paramMStorageEx, paramObject });
      AppMethodBeat.o(12596);
      return;
    }
    onNotifyChange((String)paramObject, null);
    AppMethodBeat.o(12596);
  }
  
  public void onNotifyChange(String paramString, MStorageEventData paramMStorageEventData)
  {
    AppMethodBeat.i(12597);
    if (Util.isNullOrNil(paramString))
    {
      AppMethodBeat.o(12597);
      return;
    }
    if (!ab.Eq(paramString))
    {
      Log.d("MicroMsg.ChatroomInfoUI", "event:" + paramString + " cancel");
      AppMethodBeat.o(12597);
      return;
    }
    Log.d("MicroMsg.ChatroomInfoUI", "event:".concat(String.valueOf(paramString)));
    if ((this.dRx) && (paramString.equals(this.roomId))) {
      com.tencent.mm.kernel.g.aAk().postToWorker(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(194089);
          ChatroomInfoUI.a(ChatroomInfoUI.this, ((com.tencent.mm.plugin.chatroom.a.c)com.tencent.mm.kernel.g.af(com.tencent.mm.plugin.chatroom.a.c.class)).aSX().Kd(ChatroomInfoUI.b(ChatroomInfoUI.this)));
          if (ChatroomInfoUI.c(ChatroomInfoUI.this) == null)
          {
            Log.e("MicroMsg.ChatroomInfoUI", "member is null");
            AppMethodBeat.o(194089);
            return;
          }
          if (Util.isNullOrNil(ChatroomInfoUI.c(ChatroomInfoUI.this).field_roomowner))
          {
            Log.e("MicroMsg.ChatroomInfoUI", "roomowner is null");
            AppMethodBeat.o(194089);
            return;
          }
          ChatroomInfoUI.A(ChatroomInfoUI.this).sendEmptyMessage(0);
          ChatroomInfoUI.b(ChatroomInfoUI.this, ChatroomInfoUI.c(ChatroomInfoUI.this).field_roomowner.equals(z.aTY()));
          ChatroomInfoUI.c(ChatroomInfoUI.this, ChatroomInfoUI.c(ChatroomInfoUI.this).bjf(z.aTY()));
          ChatroomInfoUI.m(ChatroomInfoUI.this).beT(ChatroomInfoUI.c(ChatroomInfoUI.this).field_roomowner);
          AppMethodBeat.o(194089);
        }
        
        public final String toString()
        {
          AppMethodBeat.i(194090);
          String str = super.toString() + "|onNotifyChange";
          AppMethodBeat.o(194090);
          return str;
        }
      });
    }
    ami();
    AppMethodBeat.o(12597);
  }
  
  public void onPause()
  {
    AppMethodBeat.i(12567);
    super.onPause();
    if ((this.gui) && (this.dRx))
    {
      if (this.gtd == null)
      {
        AppMethodBeat.o(12567);
        return;
      }
      com.tencent.mm.model.v.a(this.roomId, this.gtd, this.guc);
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
      paramf = com.tencent.mm.n.h.aqJ().getValue("ChatRoomOwnerModTopic");
      if (Util.isNullOrNil(paramf)) {
        break label3193;
      }
    }
    label362:
    label756:
    label1525:
    label3193:
    for (int i = Util.safeParseInt(paramf);; i = 0)
    {
      if ((this.gtd != null) && (!Util.isNullOrNil(this.gtd.field_roomowner)) && (i > 0) && (!amD()) && (i < this.gug)) {
        com.tencent.mm.ui.base.h.a(this, getString(2131764789, new Object[] { amw() }), null, getString(2131755874), new DialogInterface.OnClickListener()
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
        paramf = new com.tencent.mm.hellhoundlib.b.a().bl(paramf);
        com.tencent.mm.hellhoundlib.a.a.a(this, paramf.axQ(), "com/tencent/mm/chatroom/ui/ChatroomInfoUI", "onPreferenceTreeClick", "(Lcom/tencent/mm/ui/base/preference/IPreferenceScreen;Lcom/tencent/mm/ui/base/preference/Preference;)Z", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
        startActivity((Intent)paramf.pG(0));
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/chatroom/ui/ChatroomInfoUI", "onPreferenceTreeClick", "(Lcom/tencent/mm/ui/base/preference/IPreferenceScreen;Lcom/tencent/mm/ui/base/preference/Preference;)Z", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
        com.tencent.mm.plugin.report.service.h.CyF.idkeyStat(219L, 3L, 1L, true);
        continue;
        if (paramf.equals("room_upgrade_entry"))
        {
          if (Util.getInt(com.tencent.mm.n.h.aqJ().getValue("ChatroomGlobalSwitch"), 1) == 1) {}
          for (i = 1;; i = 0)
          {
            if (i == 0) {
              break label362;
            }
            paramf = new Intent();
            paramf.putExtra("rawUrl", getString(2131757298, new Object[] { LocaleUtil.getApplicationLanguage() }));
            paramf.putExtra("geta8key_username", z.aTY());
            paramf.putExtra("showShare", false);
            com.tencent.mm.br.c.b(this, "webview", "com.tencent.mm.plugin.webview.ui.tools.WebViewUI", paramf);
            break;
          }
        }
        else if (paramf.equals("room_qr_code"))
        {
          if (ab.Iy(this.roomId))
          {
            paramf = new gq();
            paramf.us(this.roomId);
            paramf.erw = 6L;
            paramf.bfK();
          }
          com.tencent.mm.plugin.report.service.h.CyF.idkeyStat(219L, 5L, 1L, true);
          paramf = new Intent();
          paramf.putExtra("from_userName", this.roomId);
          com.tencent.mm.br.c.b(this, "setting", ".ui.setting.SelfQRCodeUI", paramf);
        }
        else if (paramf.equals("room_card"))
        {
          if (this.gtd == null)
          {
            Log.w("MicroMsg.ChatroomInfoUI", "goToRoomCardUI member == null");
          }
          else
          {
            bool1 = this.gtd.bjf(z.aTY());
            if ((Util.isNullOrNil(com.tencent.mm.model.v.Ig(this.roomId))) && (!amD()))
            {
              com.tencent.mm.ui.base.h.c(this, getString(2131764659), null, getString(2131764660), null, null, null);
            }
            else
            {
              paramf = new Intent();
              paramf.setClass(this, RoomCardUI.class);
              paramf.putExtra("RoomInfo_Id", this.roomId);
              paramf.putExtra("room_name", this.gtP.gCf.toString());
              this.gug = com.tencent.mm.model.v.Ic(this.roomId).size();
              paramf.putExtra("room_member_count", this.gug);
              paramf.putExtra("room_owner_name", amw());
              paramf.putExtra("room_notice", com.tencent.mm.model.v.Ig(this.roomId));
              paramf.putExtra("room_notice_publish_time", com.tencent.mm.model.v.Ij(this.roomId));
              paramf.putExtra("room_notice_editor", com.tencent.mm.model.v.Ii(this.roomId));
              paramf.putExtra("Is_RoomOwner", this.gue);
              paramf.putExtra("Is_RoomManager", bool1);
              startActivityForResult(paramf, 6);
            }
          }
        }
        else
        {
          if (paramf.equals("room_notify_new_msg"))
          {
            if (!this.guh)
            {
              bool1 = true;
              this.guh = bool1;
              if (this.dRx)
              {
                if (!this.guh) {
                  break label979;
                }
                i = 0;
                com.tencent.mm.roomsdk.a.b.bhF(this.roomId).I(this.roomId, i).aJu();
                this.contact = ((com.tencent.mm.plugin.messenger.foundation.a.l)com.tencent.mm.kernel.g.af(com.tencent.mm.plugin.messenger.foundation.a.l.class)).aSN().Kn(this.roomId);
                this.contact.nm(i);
                ((com.tencent.mm.plugin.messenger.foundation.a.l)com.tencent.mm.kernel.g.af(com.tencent.mm.plugin.messenger.foundation.a.l.class)).aSN().c(this.roomId, this.contact);
                if (this.gun)
                {
                  paramf = com.tencent.mm.plugin.report.service.h.CyF;
                  if (!this.guh) {
                    break label984;
                  }
                  i = 14;
                  paramf.dN(869, i);
                }
              }
              paramf = com.tencent.mm.modelstat.b.jmd;
              ??? = this.roomId;
              bool1 = this.guh;
              if ((paramf.bfZ()) && (paramf.fP(???)))
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
              paramf.jmc.oplist_.add(???);
              amy();
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
            paramf = ((com.tencent.mm.plugin.messenger.foundation.a.l)com.tencent.mm.kernel.g.af(com.tencent.mm.plugin.messenger.foundation.a.l.class)).aSN().Kn(this.roomId);
            if (paramf != null)
            {
              boolean bool2 = com.tencent.mm.contact.c.oR(paramf.field_type);
              ??? = this.sp.edit();
              if (!bool2)
              {
                bool1 = true;
                ???.putBoolean("room_save_to_contact", bool1).commit();
                if (!bool2) {
                  break label1192;
                }
                paramf.aqR();
                com.tencent.mm.roomsdk.a.b.bhF(this.roomId).a(paramf, false);
                com.tencent.mm.ui.base.h.cD(this, getString(2131764760));
                com.tencent.mm.modelstat.b.jmd.W(this.roomId, false);
              }
              for (;;)
              {
                this.screen.notifyDataSetChanged();
                break;
                bool1 = false;
                break label1111;
                com.tencent.mm.roomsdk.a.b.bhF(this.roomId).a(paramf, true);
                com.tencent.mm.ui.base.h.cD(this, getString(2131764776));
                com.tencent.mm.modelstat.b.jmd.W(this.roomId, true);
              }
            }
          }
          else if (paramf.equals("room_placed_to_the_top"))
          {
            paramf = getSharedPreferences(this.guu, 0);
            if (this.contact != null)
            {
              if (((com.tencent.mm.plugin.messenger.foundation.a.l)com.tencent.mm.kernel.g.af(com.tencent.mm.plugin.messenger.foundation.a.l.class)).aST().bkg(this.contact.field_username))
              {
                ab.F(this.contact.field_username, true);
                com.tencent.mm.modelstat.b.jmd.c(false, this.roomId, false);
              }
              for (;;)
              {
                paramf.edit().putBoolean("room_placed_to_the_top", ((com.tencent.mm.plugin.messenger.foundation.a.l)com.tencent.mm.kernel.g.af(com.tencent.mm.plugin.messenger.foundation.a.l.class)).aST().bkg(this.contact.field_username)).commit();
                break;
                ab.E(this.contact.field_username, true);
                com.tencent.mm.modelstat.b.jmd.c(false, this.roomId, true);
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
              paramf = getSharedPreferences(this.guu, 0).edit();
              if (!this.guc)
              {
                bool1 = true;
                paramf.putBoolean("room_msg_show_username", bool1).commit();
                if (this.guc) {
                  break label1525;
                }
              }
              for (bool1 = true;; bool1 = false)
              {
                this.guc = bool1;
                this.gui = true;
                break;
                bool1 = false;
                break label1478;
              }
            }
            if (!paramf.equals("room_set_chatting_background")) {
              break;
            }
            if (ab.Iy(this.roomId))
            {
              paramf = new gq();
              paramf.us(this.roomId);
              paramf.erw = 9L;
              paramf.bfK();
            }
            paramf = new Intent();
            paramf.putExtra("isApplyToAll", false);
            paramf.putExtra("username", this.contact.field_username);
            com.tencent.mm.br.c.b(this, "setting", ".ui.setting.SettingsChattingBackgroundUI", paramf, 2);
          }
        }
      }
      if (paramf.equals("room_search_chatting_content"))
      {
        if (ab.Iy(this.roomId))
        {
          paramf = new gq();
          paramf.us(this.roomId);
          paramf.erw = 8L;
          paramf.bfK();
        }
        paramf = new Intent();
        paramf.putExtra("detail_username", this.roomId);
        com.tencent.mm.plugin.fts.a.d.d(this, ".ui.FTSChattingConvUI", paramf);
        if ((this.gtd == null) || (this.gtd.bax() == null)) {
          break label3188;
        }
      }
      for (i = this.gtd.bax().size();; i = 0)
      {
        for (;;)
        {
          com.tencent.mm.plugin.report.service.h.CyF.a(14569, new Object[] { Integer.valueOf(1), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(i), Integer.valueOf(1) });
          break;
          if (paramf.equals("room_clear_chatting_history"))
          {
            if (ab.Iy(this.roomId))
            {
              paramf = new gq();
              paramf.us(this.roomId);
              paramf.erw = 11L;
              paramf.bfK();
            }
            paramf = getString(2131760819);
            com.tencent.mm.ui.base.h.a(getContext(), paramf, "", getString(2131755764), getString(2131755761), new DialogInterface.OnClickListener()
            {
              public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
              {
                AppMethodBeat.i(194070);
                com.tencent.mm.plugin.report.service.h.CyF.a(14553, new Object[] { Integer.valueOf(3), Integer.valueOf(2), ChatroomInfoUI.b(ChatroomInfoUI.this) });
                ChatroomInfoUI.dn(false);
                paramAnonymousDialogInterface = ChatroomInfoUI.this;
                ChatroomInfoUI.this.getString(2131755998);
                final com.tencent.mm.ui.base.q localq = com.tencent.mm.ui.base.h.a(paramAnonymousDialogInterface, ChatroomInfoUI.this.getString(2131756029), true, new ChatroomInfoUI.a());
                if (!ChatroomInfoUI.amE()) {}
                for (paramAnonymousDialogInterface = com.tencent.mm.pluginsdk.wallet.d.bfO(ChatroomInfoUI.o(ChatroomInfoUI.this).field_username);; paramAnonymousDialogInterface = null)
                {
                  if (!Util.isNullOrNil(paramAnonymousDialogInterface))
                  {
                    localq.dismiss();
                    com.tencent.mm.ui.base.h.a(ChatroomInfoUI.this, false, ChatroomInfoUI.this.getString(2131767654, new Object[] { paramAnonymousDialogInterface }), null, ChatroomInfoUI.this.getString(2131761460), ChatroomInfoUI.this.getString(2131757641), new DialogInterface.OnClickListener()new DialogInterface.OnClickListener
                    {
                      public final void onClick(DialogInterface paramAnonymous2DialogInterface, int paramAnonymous2Int)
                      {
                        AppMethodBeat.i(194068);
                        com.tencent.mm.plugin.report.service.h.CyF.a(14553, new Object[] { Integer.valueOf(3), Integer.valueOf(4), ChatroomInfoUI.b(ChatroomInfoUI.this) });
                        ChatroomInfoUI.a(ChatroomInfoUI.this, true);
                        if (!ChatroomInfoUI.s(ChatroomInfoUI.this))
                        {
                          paramAnonymous2DialogInterface = new Intent();
                          paramAnonymous2DialogInterface.putExtra("Chat_User", ChatroomInfoUI.o(ChatroomInfoUI.this).field_username);
                          paramAnonymous2DialogInterface.addFlags(67108864);
                          com.tencent.mm.br.c.f(ChatroomInfoUI.this, ".ui.chatting.ChattingUI", paramAnonymous2DialogInterface);
                          AppMethodBeat.o(194068);
                          return;
                        }
                        ChatroomInfoUI.this.finish();
                        AppMethodBeat.o(194068);
                      }
                    }, new DialogInterface.OnClickListener()
                    {
                      public final void onClick(DialogInterface paramAnonymous2DialogInterface, int paramAnonymous2Int)
                      {
                        AppMethodBeat.i(194069);
                        com.tencent.mm.plugin.report.service.h.CyF.a(14553, new Object[] { Integer.valueOf(3), Integer.valueOf(3), ChatroomInfoUI.b(ChatroomInfoUI.this) });
                        localq.show();
                        ChatroomInfoUI.a(ChatroomInfoUI.this, false);
                        ChatroomInfoUI.a(ChatroomInfoUI.this, localq);
                        AppMethodBeat.o(194069);
                      }
                    }, -1, 2131099922);
                    AppMethodBeat.o(194070);
                    return;
                  }
                  ChatroomInfoUI.a(ChatroomInfoUI.this, localq);
                  AppMethodBeat.o(194070);
                  return;
                }
              }
            }, null, 2131099922);
            break;
          }
          if (paramf.equals("room_report_it"))
          {
            if (ab.Iy(this.roomId))
            {
              paramf = new gq();
              paramf.us(this.roomId);
              paramf.erw = 10L;
              paramf.bfK();
            }
            paramf = new Intent();
            paramf.putExtra("k_username", this.roomId);
            paramf.putExtra("showShare", false);
            paramf.putExtra("rawUrl", String.format(e.e.OyU, new Object[] { Integer.valueOf(36) }));
            com.tencent.mm.br.c.b(this, "webview", ".ui.tools.WebViewUI", paramf);
            paramf = com.tencent.mm.modelstat.b.jmd;
            ??? = this.roomId;
            if ((!paramf.bfZ()) || (!paramf.fP(???))) {
              break;
            }
            ??? = new IMBehavior();
            ((IMBehavior)???).opType = 1;
            ((IMBehavior)???).chattingOp = new IMBehaviorChattingOP();
            ((IMBehavior)???).chattingOp.expose = 1;
            synchronized (paramf.lock)
            {
              paramf.jmc.oplist_.add(???);
            }
          }
        }
        if (paramf.equals("room_del_quit"))
        {
          Log.d("MicroMsg.ChatroomInfoUI", " quit " + this.roomId);
          paramf = new xq();
          paramf.edR.edT = true;
          EventCenter.instance.publish(paramf);
          if ((!Util.isNullOrNil(this.roomId)) && (this.roomId.equals(paramf.edS.edV)))
          {
            bool1 = true;
            if (!bool1) {
              break label2300;
            }
            Log.d("MicroMsg.ChatroomInfoUI", " quit talkroom" + this.roomId);
          }
          label2300:
          while ((!this.gue) || (this.gtd == null) || (this.gtd.bax().size() <= 2))
          {
            com.tencent.mm.ui.base.h.a(getContext(), getString(2131758277), "", getString(2131755921), getString(2131755761), new DialogInterface.OnClickListener()
            {
              public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
              {
                AppMethodBeat.i(194074);
                if ((ChatroomInfoUI.b(ChatroomInfoUI.this) == null) || (ChatroomInfoUI.b(ChatroomInfoUI.this).length() <= 0))
                {
                  Log.e("MicroMsg.ChatroomInfoUI", "quitChatRoom : invalid args");
                  AppMethodBeat.o(194074);
                  return;
                }
                if (bool1)
                {
                  paramAnonymousDialogInterface = new xq();
                  paramAnonymousDialogInterface.edR.edU = true;
                  EventCenter.instance.publish(paramAnonymousDialogInterface);
                }
                if (!((com.tencent.mm.plugin.messenger.foundation.a.l)com.tencent.mm.kernel.g.af(com.tencent.mm.plugin.messenger.foundation.a.l.class)).aSN().bjN(ChatroomInfoUI.b(ChatroomInfoUI.this)))
                {
                  Log.e("MicroMsg.ChatroomInfoUI", "quitChatRoom : room[" + ChatroomInfoUI.b(ChatroomInfoUI.this) + "] is not exist");
                  AppMethodBeat.o(194074);
                  return;
                }
                if (((com.tencent.mm.live.a)com.tencent.mm.kernel.g.ah(com.tencent.mm.live.a.class)).isAnchorLiving())
                {
                  com.tencent.mm.ui.base.h.a(ChatroomInfoUI.this.getContext(), ChatroomInfoUI.this.getString(2131757248), null, ChatroomInfoUI.this.getString(2131755874), new DialogInterface.OnClickListener()
                  {
                    public final void onClick(DialogInterface paramAnonymous2DialogInterface, int paramAnonymous2Int) {}
                  });
                  AppMethodBeat.o(194074);
                  return;
                }
                if (((com.tencent.mm.live.a)com.tencent.mm.kernel.g.ah(com.tencent.mm.live.a.class)).isVisitorLiving()) {
                  ((com.tencent.mm.live.a)com.tencent.mm.kernel.g.ah(com.tencent.mm.live.a.class)).forceStopCurLive(ChatroomInfoUI.this.getContext());
                }
                ChatroomInfoUI.t(ChatroomInfoUI.this);
                ((com.tencent.mm.plugin.multitalk.model.d)com.tencent.mm.kernel.g.af(com.tencent.mm.plugin.multitalk.model.d.class)).aFG(ChatroomInfoUI.b(ChatroomInfoUI.this));
                AppMethodBeat.o(194074);
              }
            }, null, 2131099922);
            break;
            bool1 = false;
            break label2215;
          }
          paramf = getString(2131764748);
          ??? = new h.d()
          {
            public final void oj(int paramAnonymousInt)
            {
              AppMethodBeat.i(194073);
              switch (paramAnonymousInt)
              {
              default: 
                Log.d("MicroMsg.ChatroomInfoUI", "dz[dealQuitChatRoom owner click cancel]");
                AppMethodBeat.o(194073);
                return;
              }
              Log.d("MicroMsg.ChatroomInfoUI", "dz[dealQuitChatRoom owner click room_owner_delete_direct]");
              if (((com.tencent.mm.live.a)com.tencent.mm.kernel.g.ah(com.tencent.mm.live.a.class)).isAnchorLiving())
              {
                com.tencent.mm.ui.base.h.a(ChatroomInfoUI.this.getContext(), ChatroomInfoUI.this.getString(2131757248), null, ChatroomInfoUI.this.getString(2131755874), new DialogInterface.OnClickListener()
                {
                  public final void onClick(DialogInterface paramAnonymous2DialogInterface, int paramAnonymous2Int) {}
                });
                AppMethodBeat.o(194073);
                return;
              }
              if (((com.tencent.mm.live.a)com.tencent.mm.kernel.g.ah(com.tencent.mm.live.a.class)).isVisitorLiving()) {
                ((com.tencent.mm.live.a)com.tencent.mm.kernel.g.ah(com.tencent.mm.live.a.class)).forceStopCurLive(ChatroomInfoUI.this.getContext());
              }
              ChatroomInfoUI.t(ChatroomInfoUI.this);
              ((com.tencent.mm.plugin.multitalk.model.d)com.tencent.mm.kernel.g.af(com.tencent.mm.plugin.multitalk.model.d.class)).aFG(ChatroomInfoUI.b(ChatroomInfoUI.this));
              AppMethodBeat.o(194073);
            }
          };
          com.tencent.mm.ui.base.h.a(this, "", new String[] { paramf }, "", ???);
          break;
        }
        if (paramf.equals("add_selector_btn"))
        {
          amu();
          break;
        }
        if (paramf.equals("del_selector_btn"))
        {
          amv();
          break;
        }
        if (paramf.equals("see_room_member"))
        {
          paramf = new Intent();
          paramf.setClass(getContext(), SeeRoomMemberUI.class);
          paramf.putExtra("Block_list", z.aTY());
          ??? = com.tencent.mm.model.v.Ic(this.roomId);
          if (??? != null) {
            this.gug = ???.size();
          }
          paramf.putExtra("Chatroom_member_list", Util.listToString(???, ","));
          paramf.putExtra("RoomInfo_Id", this.roomId);
          paramf.putExtra("room_owner_name", this.gtd.field_roomowner);
          paramf.putExtra("Is_RoomOwner", this.gue);
          paramf.putExtra("room_member_count", this.gug);
          paramf.putExtra("Add_address_titile", getString(2131764780));
          if (this.dRx)
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
            this.gus = 5;
            break;
            if (!this.gtO) {
              break label2563;
            }
            paramf.putExtra("Contact_Scene", 44);
            if (z.Im(this.contact.field_username)) {
              break label2563;
            }
            paramf.putExtra("Contact_IsLBSFriend", true);
            break label2563;
          }
        }
        if (paramf.equals("manage_room"))
        {
          if (this.guo) {
            com.tencent.mm.plugin.newtips.a.exl().TC(26);
          }
          paramf = new Intent();
          paramf.setClass(getContext(), ManageChatroomUI.class);
          paramf.putExtra("RoomInfo_Id", this.roomId);
          paramf.putExtra("room_owner_name", this.gtd.field_roomowner);
          paramf = new com.tencent.mm.hellhoundlib.b.a().bl(paramf);
          com.tencent.mm.hellhoundlib.a.a.a(this, paramf.axQ(), "com/tencent/mm/chatroom/ui/ChatroomInfoUI", "goToManageChatroomUI", "()V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
          startActivity((Intent)paramf.pG(0));
          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/chatroom/ui/ChatroomInfoUI", "goToManageChatroomUI", "()V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
          break;
        }
        if (paramf.equals("chat_room_app_brand"))
        {
          if (ab.Iy(this.roomId))
          {
            paramf = new gq();
            paramf.us(this.roomId);
            paramf.erw = 7L;
            paramf.bfK();
          }
          paramf = new Intent();
          paramf.putExtra("Chat_User", this.roomId);
          com.tencent.mm.br.c.f(this, ".ui.chatting.gallery.AppBrandHistoryListUI", paramf);
          com.tencent.mm.plugin.report.service.h.CyF.idkeyStat(219L, 25L, 1L, true);
          break;
        }
        if (paramf.equals("room_manager_view"))
        {
          paramf = new Intent();
          paramf.setClass(getContext(), SeeRoomOwnerManagerUI.class);
          paramf.putExtra("RoomInfo_Id", this.roomId);
          paramf.putExtra("room_owner_name", this.gtd.field_roomowner);
          paramf = new com.tencent.mm.hellhoundlib.b.a().bl(paramf);
          com.tencent.mm.hellhoundlib.a.a.a(this, paramf.axQ(), "com/tencent/mm/chatroom/ui/ChatroomInfoUI", "goToOwnerManageChatroomUI", "()V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
          startActivity((Intent)paramf.pG(0));
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
        paramf = new com.tencent.mm.hellhoundlib.b.a().bl(paramf);
        com.tencent.mm.hellhoundlib.a.a.a(this, paramf.axQ(), "com/tencent/mm/chatroom/ui/ChatroomInfoUI", "dealModChatroomRemark", "()V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
        startActivity((Intent)paramf.pG(0));
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
    if ((this.gtd != null) && (this.gtd.gBy() != null))
    {
      bool = com.tencent.mm.model.v.Ih(this.gtd.field_chatroomname);
      Log.i("MicroMsg.ChatroomInfoUI", "roomId:%s newVer:%s localVer:%s owner:%s", new Object[] { this.gtd.field_chatroomname, Integer.valueOf(this.gtd.field_chatroomVersion), Integer.valueOf(this.gtd.field_oldChatroomVersion), this.gtd.field_roomowner });
    }
    for (;;)
    {
      if ((com.tencent.mm.model.v.HX(this.roomId)) || (bool)) {
        amq();
      }
      amz();
      updateTitle();
      amy();
      Object localObject2;
      Object localObject1;
      if (this.dRx)
      {
        amA();
        if (this.contact != null)
        {
          this.gtd = ((com.tencent.mm.plugin.chatroom.a.c)com.tencent.mm.kernel.g.af(com.tencent.mm.plugin.chatroom.a.c.class)).aSX().Kd(this.roomId);
          if (this.gtd != null) {
            break label507;
          }
          localObject2 = "";
          localObject1 = localObject2;
          if (Util.isNullOrNil((String)localObject2)) {
            localObject1 = z.aUa();
          }
          if (Util.isNullOrNil((String)localObject1)) {
            break label518;
          }
          this.gtY.gLI();
          this.gtY.OYK = com.tencent.mm.cb.a.aG(getContext(), 2131165605);
          KeyValuePreference localKeyValuePreference = this.gtY;
          localObject2 = localObject1;
          if (((String)localObject1).length() <= 0) {
            localObject2 = getString(2131765591);
          }
          localKeyValuePreference.setSummary(com.tencent.mm.pluginsdk.ui.span.l.c(this, (CharSequence)localObject2));
          label268:
          if (this.screen != null) {
            this.screen.notifyDataSetChanged();
          }
        }
        if ((this.contact != null) && (this.gtZ != null))
        {
          this.contact = ((com.tencent.mm.plugin.messenger.foundation.a.l)com.tencent.mm.kernel.g.af(com.tencent.mm.plugin.messenger.foundation.a.l.class)).aSN().Kn(this.roomId);
          this.gtZ.gLI();
          if (!as.bjq(this.roomId)) {
            break label530;
          }
          this.screen.e(this.gtZ);
        }
      }
      for (;;)
      {
        if (this.guk)
        {
          amx();
          this.guk = false;
        }
        localObject1 = getIntent().getStringExtra("need_matte_high_light_item");
        if (!this.guq)
        {
          if (!Util.isNullOrNil((String)localObject1)) {
            DF((String)localObject1);
          }
          this.guq = true;
        }
        if ((!Util.isNullOrNil((String)localObject1)) && (((String)localObject1).equals("room_notify_new_notice")) && (!this.guq))
        {
          DF("room_card");
          this.guq = true;
        }
        com.tencent.mm.plugin.newtips.a.exl().TB(26);
        Log.d("MicroMsg.ChatroomInfoUI", "showSetMuteAnimation isShowSetMuteAnimation[%b]", new Object[] { Boolean.valueOf(this.gum) });
        if (this.gum)
        {
          this.gum = false;
          MMHandlerThread.postToMainThreadDelayed(new Runnable()
          {
            public final void run()
            {
              AppMethodBeat.i(194091);
              ChatroomInfoUI.b(ChatroomInfoUI.this, "room_notify_new_msg");
              ChatroomInfoUI.B(ChatroomInfoUI.this);
              AppMethodBeat.o(194091);
            }
          }, 50L);
        }
        AppMethodBeat.o(12564);
        return;
        label507:
        localObject2 = this.gtd.field_selfDisplayName;
        break;
        label518:
        this.gtY.setSummary("");
        break label268;
        label530:
        if (!Util.isNullOrNil(this.contact.field_conRemark))
        {
          localObject1 = this.contact.field_conRemark;
          this.gtZ.setSummary(com.tencent.mm.pluginsdk.ui.span.l.c(this, (CharSequence)localObject1));
          if (this.screen != null) {
            this.screen.notifyDataSetChanged();
          }
        }
        else
        {
          this.gtZ.setSummary("");
        }
      }
      bool = false;
    }
  }
  
  public void onSceneEnd(int paramInt1, int paramInt2, String paramString, com.tencent.mm.ak.q paramq)
  {
    AppMethodBeat.i(12594);
    Log.i("MicroMsg.ChatroomInfoUI", "onSceneEnd: errType = " + paramInt1 + " errCode = " + paramInt2 + " errMsg = " + paramString + " type = " + paramq.getType());
    Log.d("MicroMsg.ChatroomInfoUI", "pre is " + this.gug);
    this.gug = com.tencent.mm.model.v.Ie(this.roomId);
    Log.d("MicroMsg.ChatroomInfoUI", "now is " + this.gug);
    if (this.gtM != null) {
      this.gtM.dismiss();
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
      ChatroomInfoUI.dn(true);
      AppMethodBeat.o(12560);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.chatroom.ui.ChatroomInfoUI
 * JD-Core Version:    0.7.0.1
 */