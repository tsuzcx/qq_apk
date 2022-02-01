package com.tencent.mm.chatroom.ui;

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
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.Window;
import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;
import android.widget.LinearLayout;
import android.widget.ListView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.autogen.a.aaq;
import com.tencent.mm.autogen.a.aaq.b;
import com.tencent.mm.autogen.a.abv;
import com.tencent.mm.autogen.a.lb;
import com.tencent.mm.autogen.a.ph;
import com.tencent.mm.autogen.a.ph.b;
import com.tencent.mm.autogen.a.pu;
import com.tencent.mm.autogen.a.xc;
import com.tencent.mm.autogen.b.az;
import com.tencent.mm.autogen.b.fi;
import com.tencent.mm.autogen.mmdata.rpt.am;
import com.tencent.mm.autogen.mmdata.rpt.bi;
import com.tencent.mm.autogen.mmdata.rpt.lf;
import com.tencent.mm.autogen.mmdata.rpt.qt;
import com.tencent.mm.chatroom.d.ad;
import com.tencent.mm.chatroom.ui.preference.RoomCardPreference;
import com.tencent.mm.model.ab;
import com.tencent.mm.model.ar;
import com.tencent.mm.model.az.a;
import com.tencent.mm.model.az.b;
import com.tencent.mm.model.az.b.a;
import com.tencent.mm.model.br;
import com.tencent.mm.model.br.a;
import com.tencent.mm.model.v;
import com.tencent.mm.model.z;
import com.tencent.mm.plugin.messenger.foundation.a.a.j;
import com.tencent.mm.plugin.messenger.foundation.a.a.k.a;
import com.tencent.mm.plugin.messenger.foundation.a.y;
import com.tencent.mm.plugin.newtips.NewTipPreference;
import com.tencent.mm.plugin.report.kvdata.IMBehavior;
import com.tencent.mm.plugin.report.kvdata.IMBehaviorChattingOP;
import com.tencent.mm.plugin.report.kvdata.log_13835;
import com.tencent.mm.pluginsdk.event.IListenerNetScene;
import com.tencent.mm.pluginsdk.ui.applet.ContactListExpandPreference;
import com.tencent.mm.pluginsdk.ui.applet.ContactListExpandPreference.a;
import com.tencent.mm.pluginsdk.ui.applet.r;
import com.tencent.mm.pluginsdk.ui.applet.s.b;
import com.tencent.mm.protocal.protobuf.aig;
import com.tencent.mm.protocal.protobuf.dhe;
import com.tencent.mm.protocal.protobuf.etl;
import com.tencent.mm.roomsdk.model.b.e;
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
import com.tencent.mm.storage.aj;
import com.tencent.mm.storage.aq;
import com.tencent.mm.storage.bb;
import com.tencent.mm.storage.bx;
import com.tencent.mm.storage.by;
import com.tencent.mm.storage.cr;
import com.tencent.mm.ui.base.k.d;
import com.tencent.mm.ui.base.preference.ButtonPreference;
import com.tencent.mm.ui.base.preference.CheckBoxPreference;
import com.tencent.mm.ui.base.preference.KeyValuePreference;
import com.tencent.mm.ui.base.preference.MMPreference;
import com.tencent.mm.ui.base.preference.Preference;
import com.tencent.mm.ui.base.preference.PreferenceCategory;
import com.tencent.mm.ui.base.u.g;
import com.tencent.mm.ui.base.u.i;
import com.tencent.mm.ui.component.UIComponent;
import com.tencent.mm.ui.component.k.b;
import com.tencent.mm.ui.contact.w;
import com.tencent.mm.ui.f.f;
import com.tencent.mm.ui.widget.a.f.b;
import com.tencent.mm.util.b.a;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

@com.tencent.mm.kernel.k
public class ChatroomInfoUI
  extends MMPreference
  implements com.tencent.mm.am.h, com.tencent.mm.bc.a, com.tencent.mm.chatroom.g.a.b, MStorage.IOnStorageChange, MStorageEx.IOnStorageChange
{
  private static boolean lAu = false;
  private com.tencent.mm.storage.au contact;
  private boolean hQu;
  private MMHandler handler;
  private boolean isDeleteCancel;
  private com.tencent.mm.roomsdk.model.factory.a lAA;
  private MTimerHandler lAB;
  private int lAC;
  private CheckBoxPreference lAa;
  private CheckBoxPreference lAb;
  private KeyValuePreference lAc;
  private KeyValuePreference lAd;
  private CheckBoxPreference lAe;
  private NewTipPreference lAf;
  private boolean lAg;
  private boolean lAh;
  private int lAi;
  private boolean lAj;
  private boolean lAk;
  private int lAl;
  private boolean lAm;
  private boolean lAn;
  private boolean lAo;
  private boolean lAp;
  private boolean lAq;
  private boolean lAr;
  int lAs;
  boolean lAt;
  private String lAv;
  private String lAw;
  private IListener lAx;
  private IListener lAy;
  private IListenerNetScene lAz;
  private ProgressDialog lzP;
  private ProgressDialog lzQ;
  private boolean lzR;
  private boolean lzS;
  private RoomCardPreference lzT;
  private Preference lzU;
  private Preference lzV;
  private Preference lzW;
  private ContactListExpandPreference lzX;
  private CheckBoxPreference lzY;
  private CheckBoxPreference lzZ;
  private aj lzy;
  private String roomId;
  private com.tencent.mm.ui.base.preference.f screen;
  private SharedPreferences sp;
  
  public ChatroomInfoUI()
  {
    AppMethodBeat.i(12561);
    this.lzP = null;
    this.lzQ = null;
    this.lzR = false;
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
    this.lAh = false;
    this.lAk = false;
    this.lzy = null;
    this.lAl = -1;
    this.lAm = true;
    this.lAn = false;
    this.lAo = false;
    this.lAp = false;
    this.lAq = false;
    this.lAr = false;
    this.lAs = -1;
    this.lAt = false;
    this.isDeleteCancel = false;
    this.lAv = "";
    this.lAw = null;
    this.lAx = new IListener(com.tencent.mm.app.f.hfK) {};
    this.lAy = new IListener(com.tencent.mm.app.f.hfK) {};
    this.lAz = new IListenerNetScene()
    {
      public final void a(int paramAnonymousInt1, int paramAnonymousInt2, String paramAnonymousString, IEvent paramAnonymousIEvent)
      {
        AppMethodBeat.i(241839);
        if ((paramAnonymousIEvent instanceof ph))
        {
          paramAnonymousIEvent = (ph)paramAnonymousIEvent;
          Log.i("MicroMsg.ChatroomInfoUI", "onSceneEnd: errType = " + paramAnonymousInt1 + " errCode = " + paramAnonymousInt2 + " errMsg = " + paramAnonymousString);
          if (ChatroomInfoUI.h(ChatroomInfoUI.this) != null) {
            ChatroomInfoUI.h(ChatroomInfoUI.this).dismiss();
          }
          if ((paramAnonymousInt1 != 0) || (paramAnonymousInt2 != 0))
          {
            if (paramAnonymousInt2 == -21)
            {
              com.tencent.mm.ui.base.k.d(ChatroomInfoUI.this, ChatroomInfoUI.this.getString(a.i.lIp), ChatroomInfoUI.this.getString(a.i.app_tip), new DialogInterface.OnClickListener()
              {
                public final void onClick(DialogInterface paramAnonymous2DialogInterface, int paramAnonymous2Int)
                {
                  AppMethodBeat.i(241512);
                  ChatroomInfoUI.this.finish();
                  AppMethodBeat.o(241512);
                }
              });
              AppMethodBeat.o(241839);
              return;
            }
            com.tencent.mm.ui.base.k.c(ChatroomInfoUI.this, ChatroomInfoUI.this.getString(a.i.lIr), ChatroomInfoUI.this.getString(a.i.app_tip), true);
            AppMethodBeat.o(241839);
            return;
          }
          if ((paramAnonymousInt1 == 0) && (paramAnonymousInt2 == 0) && (!ChatroomInfoUI.i(ChatroomInfoUI.this)) && (ChatroomInfoUI.f(ChatroomInfoUI.this) != null))
          {
            paramAnonymousString = ChatroomInfoUI.bu(paramAnonymousIEvent.hSx.hSk);
            paramAnonymousIEvent = ChatroomInfoUI.f(ChatroomInfoUI.this);
            if (paramAnonymousIEvent.YcP != null)
            {
              paramAnonymousIEvent = paramAnonymousIEvent.YcP.Yce;
              paramAnonymousIEvent.bX(paramAnonymousString);
              paramAnonymousIEvent.aNi();
            }
            if (ChatroomInfoUI.g(ChatroomInfoUI.this) != null) {
              ChatroomInfoUI.g(ChatroomInfoUI.this).notifyDataSetChanged();
            }
            ChatroomInfoUI.this.setMMTitle(ChatroomInfoUI.this.getResources().getQuantityString(a.g.lGG, paramAnonymousString.size(), new Object[] { Integer.valueOf(paramAnonymousString.size()) }));
          }
          ChatroomInfoUI.j(ChatroomInfoUI.this);
        }
        AppMethodBeat.o(241839);
      }
    };
    this.lAA = null;
    this.lAB = null;
    this.lAC = 0;
    AppMethodBeat.o(12561);
  }
  
  private String Dd(String paramString)
  {
    AppMethodBeat.i(12578);
    if ((this.lzy == null) || (Util.isNullOrNil(paramString)))
    {
      AppMethodBeat.o(12578);
      return null;
    }
    paramString = this.lzy.getDisplayName(paramString);
    AppMethodBeat.o(12578);
    return paramString;
  }
  
  private void De(String paramString)
  {
    AppMethodBeat.i(12566);
    final int i = this.screen.bAl(paramString);
    paramString = getListView();
    com.tencent.mm.hellhoundlib.b.a locala = com.tencent.mm.hellhoundlib.b.c.a(i, new com.tencent.mm.hellhoundlib.b.a());
    com.tencent.mm.hellhoundlib.a.a.b(paramString, locala.aYi(), "com/tencent/mm/chatroom/ui/ChatroomInfoUI", "MatteHighLightItem", "(Ljava/lang/String;)V", "Undefined", "smoothScrollToPosition", "(I)V");
    paramString.smoothScrollToPosition(((Integer)locala.sb(0)).intValue());
    com.tencent.mm.hellhoundlib.a.a.c(paramString, "com/tencent/mm/chatroom/ui/ChatroomInfoUI", "MatteHighLightItem", "(Ljava/lang/String;)V", "Undefined", "smoothScrollToPosition", "(I)V");
    new MMHandler().postDelayed(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(241684);
        View localView = ((com.tencent.mm.ui.base.preference.a)ChatroomInfoUI.g(ChatroomInfoUI.this)).a(i, ChatroomInfoUI.this.getListView());
        if (localView != null) {
          com.tencent.mm.ui.j.a.d(ChatroomInfoUI.this.getContext(), localView);
        }
        AppMethodBeat.o(241684);
      }
    }, 10L);
    AppMethodBeat.o(12566);
  }
  
  private void P(int paramInt, boolean paramBoolean)
  {
    AppMethodBeat.i(241739);
    am localam = new am().kB(this.roomId);
    localam.ila = paramInt;
    if (paramBoolean) {}
    for (long l = 1L;; l = 0L)
    {
      localam.ioT = l;
      localam.bMH();
      AppMethodBeat.o(241739);
      return;
    }
  }
  
  private void a(final ProgressDialog paramProgressDialog)
  {
    AppMethodBeat.i(241753);
    ad.CU(this.roomId);
    br.a(this.contact.field_username, new br.a()
    {
      public final boolean aMJ()
      {
        AppMethodBeat.i(241735);
        boolean bool = ChatroomInfoUI.aMH();
        AppMethodBeat.o(241735);
        return bool;
      }
      
      public final void aMK()
      {
        AppMethodBeat.i(241740);
        if (paramProgressDialog != null) {
          paramProgressDialog.dismiss();
        }
        AppMethodBeat.o(241740);
      }
    });
    AppMethodBeat.o(241753);
  }
  
  private void aMA()
  {
    AppMethodBeat.i(12576);
    com.tencent.mm.plugin.report.service.h.OAn.idkeyStat(219L, 8L, 1L, true);
    Object localObject = v.Il(this.roomId);
    String str = Util.listToString((List)localObject, ",");
    this.lAi = ((List)localObject).size();
    localObject = new Intent();
    ((Intent)localObject).putExtra("RoomInfo_Id", this.roomId);
    ((Intent)localObject).putExtra("Is_Chatroom", true);
    ((Intent)localObject).putExtra("Chatroom_member_list", str);
    ((Intent)localObject).putExtra("room_member_count", this.lAi);
    ((Intent)localObject).putExtra("Is_RoomOwner", this.lAh);
    ((Intent)localObject).putExtra("list_attr", w.affp);
    ((Intent)localObject).putExtra("room_name", this.contact.field_username);
    ((Intent)localObject).putExtra("room_owner_name", this.lzy.field_roomowner);
    ((Intent)localObject).setClass(this, SelectDelMemberUI.class);
    startActivityForResult((Intent)localObject, 7);
    AppMethodBeat.o(12576);
  }
  
  private String aMB()
  {
    AppMethodBeat.i(12579);
    com.tencent.mm.storage.au localau = ((com.tencent.mm.plugin.messenger.foundation.a.n)com.tencent.mm.kernel.h.ax(com.tencent.mm.plugin.messenger.foundation.a.n.class)).bzA().JE(this.lzy.field_roomowner);
    if ((localau != null) && ((int)localau.maN > 0)) {}
    for (Object localObject2 = localau.field_conRemark;; localObject2 = null)
    {
      Object localObject1 = localObject2;
      if (Util.isNullOrNil((String)localObject2)) {
        localObject1 = Dd(this.lzy.field_roomowner);
      }
      localObject2 = localObject1;
      if (Util.isNullOrNil((String)localObject1))
      {
        localObject2 = localObject1;
        if (localau != null)
        {
          localObject2 = localObject1;
          if ((int)localau.maN > 0) {
            localObject2 = localau.aSU();
          }
        }
      }
      localObject1 = localObject2;
      if (Util.isNullOrNil((String)localObject2)) {
        localObject1 = this.lzy.field_roomowner;
      }
      AppMethodBeat.o(12579);
      return localObject1;
    }
  }
  
  private boolean aMC()
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
  
  private void aMD()
  {
    AppMethodBeat.i(12591);
    com.tencent.mm.plugin.report.service.h.OAn.kvStat(10170, "1");
    Object localObject = new LinkedList();
    ((List)localObject).add(this.roomId);
    ((List)localObject).add(z.bAM());
    localObject = Util.listToString((List)localObject, ",");
    Intent localIntent = new Intent();
    localIntent.putExtra("titile", getString(a.i.address_title_launch_chatting));
    localIntent.putExtra("list_type", 0);
    localIntent.putExtra("list_attr", qv(w.affr));
    localIntent.putExtra("always_select_contact", (String)localObject);
    localIntent.putExtra("create_group_recommend", true);
    com.tencent.mm.br.c.g(this, ".ui.contact.SelectContactUI", localIntent);
    AppMethodBeat.o(12591);
  }
  
  private void aME()
  {
    AppMethodBeat.i(241798);
    if (this.lzR)
    {
      this.screen.eh("room_name", true);
      this.screen.eh("room_qr_code", true);
      this.screen.eh("manage_room", true);
      this.screen.eh("see_room_member", true);
      this.screen.eh("room_card", true);
      this.screen.eh("room_upgrade_entry", true);
      this.screen.eh("chatroom_info_chexboxes", true);
      this.screen.eh("room_special_follow_member", true);
      this.screen.eh("room_nickname", true);
      this.screen.eh("chat_room_story_videos", true);
      this.screen.eh("room_openim_about", true);
      this.screen.eh("roominfo_contact_anchor_small_category", true);
      this.screen.eh("room_clear_chatting_history", true);
      setMMTitle(getString(a.i.lIs));
    }
    AppMethodBeat.o(241798);
  }
  
  private boolean aMF()
  {
    AppMethodBeat.i(12600);
    if ((this.lzy != null) && (this.lzy.aMF()))
    {
      AppMethodBeat.o(12600);
      return true;
    }
    AppMethodBeat.o(12600);
    return false;
  }
  
  private void aMl()
  {
    AppMethodBeat.i(12583);
    if (this.hQu)
    {
      this.lAi = v.getMembersCountByChatRoomName(this.roomId);
      if (this.lAi == 0)
      {
        setMMTitle(getString(a.i.gTZ));
        AppMethodBeat.o(12583);
        return;
      }
      setMMTitle(getString(a.i.gIp, new Object[] { getString(a.i.gTZ), Integer.valueOf(this.lAi) }));
    }
    AppMethodBeat.o(12583);
  }
  
  private void aMm()
  {
    AppMethodBeat.i(12584);
    if (this.lzR)
    {
      AppMethodBeat.o(12584);
      return;
    }
    if (this.lzX != null)
    {
      if (this.hQu)
      {
        com.tencent.threadpool.h.ahAA.bm(new Runnable()
        {
          public final void run()
          {
            AppMethodBeat.i(241814);
            if (ChatroomInfoUI.k(ChatroomInfoUI.this) == null)
            {
              Log.w("MicroMsg.ChatroomInfoUI", "[updateRoomPref] member == null");
              AppMethodBeat.o(241814);
              return;
            }
            ChatroomInfoUI.a(ChatroomInfoUI.this, ((com.tencent.mm.plugin.chatroom.a.b)com.tencent.mm.kernel.h.ax(com.tencent.mm.plugin.chatroom.a.b.class)).bzK().Jx(ChatroomInfoUI.b(ChatroomInfoUI.this)));
            Object localObject1 = v.Il(ChatroomInfoUI.b(ChatroomInfoUI.this));
            final LinkedList localLinkedList = new LinkedList();
            if (localObject1 != null) {
              localLinkedList.addAll((Collection)localObject1);
            }
            ChatroomInfoUI.a(ChatroomInfoUI.this, localLinkedList.size());
            localObject1 = new LinkedList();
            Object localObject2 = localLinkedList.iterator();
            while (((Iterator)localObject2).hasNext())
            {
              String str = (String)((Iterator)localObject2).next();
              if ((ChatroomInfoUI.k(ChatroomInfoUI.this).bvK(str)) || (ChatroomInfoUI.k(ChatroomInfoUI.this).Jf(str))) {
                ((LinkedList)localObject1).add(str);
              }
            }
            if (ChatroomInfoUI.s(ChatroomInfoUI.this) > r.MAX_COUNT + 1)
            {
              localLinkedList = new LinkedList(localLinkedList.subList(0, r.MAX_COUNT + 1));
              localObject1 = ((LinkedList)localObject1).iterator();
              while (((Iterator)localObject1).hasNext())
              {
                localObject2 = (String)((Iterator)localObject1).next();
                if (!localLinkedList.contains(localObject2)) {
                  localLinkedList.add(0, localObject2);
                }
              }
            }
            for (;;)
            {
              com.tencent.threadpool.h.ahAA.bk(new Runnable()
              {
                public final void run()
                {
                  AppMethodBeat.i(241601);
                  if (ChatroomInfoUI.s(ChatroomInfoUI.this) <= 1)
                  {
                    ChatroomInfoUI.g(ChatroomInfoUI.this).eh("del_selector_btn", true);
                    ChatroomInfoUI.f(ChatroomInfoUI.this).JJ(true).JK(false).iLw();
                  }
                  for (;;)
                  {
                    ChatroomInfoUI.f(ChatroomInfoUI.this).y(ChatroomInfoUI.b(ChatroomInfoUI.this), localLinkedList);
                    ChatroomInfoUI.f(ChatroomInfoUI.this).JI(true);
                    AppMethodBeat.o(241601);
                    return;
                    ChatroomInfoUI.f(ChatroomInfoUI.this).JJ(true).JK(ChatroomInfoUI.t(ChatroomInfoUI.this)).iLw();
                  }
                }
              });
              AppMethodBeat.o(241814);
              return;
            }
          }
        });
        AppMethodBeat.o(12584);
        return;
      }
      LinkedList localLinkedList = new LinkedList();
      localLinkedList.add(this.roomId);
      this.lzX.y(this.roomId, localLinkedList);
    }
    AppMethodBeat.o(12584);
  }
  
  private void aMn()
  {
    AppMethodBeat.i(12588);
    if ((this.contact != null) && (this.lzU != null))
    {
      this.contact = ((com.tencent.mm.plugin.messenger.foundation.a.n)com.tencent.mm.kernel.h.ax(com.tencent.mm.plugin.messenger.foundation.a.n.class)).bzA().JE(this.roomId);
      if (aMC())
      {
        String str2 = this.contact.aSU();
        Preference localPreference = this.lzU;
        String str1 = str2;
        if (str2.length() <= 0) {
          str1 = getString(a.i.settings_signature_empty);
        }
        localPreference.aS(com.tencent.mm.pluginsdk.ui.span.p.b(this, str1));
        if (this.screen != null) {
          this.screen.notifyDataSetChanged();
        }
        AppMethodBeat.o(12588);
        return;
      }
      this.lzU.aS(getString(a.i.gTM));
    }
    AppMethodBeat.o(12588);
  }
  
  private void aMo()
  {
    AppMethodBeat.i(12587);
    Object localObject;
    RoomCardPreference localRoomCardPreference;
    if ((this.contact != null) && (this.lzT != null))
    {
      localObject = v.Ip(this.roomId);
      if ((localObject != null) && (((String)localObject).length() > 0)) {
        break label136;
      }
      this.lzT.hBY = false;
      this.contact = ((com.tencent.mm.plugin.messenger.foundation.a.n)com.tencent.mm.kernel.h.ax(com.tencent.mm.plugin.messenger.foundation.a.n.class)).bzA().JE(this.roomId);
      if (!aMC()) {
        break label159;
      }
      String str = this.contact.aSV();
      localRoomCardPreference = this.lzT;
      localObject = str;
      if (str.length() <= 0) {
        localObject = getString(a.i.settings_signature_empty);
      }
    }
    label136:
    label159:
    for (localRoomCardPreference.lPj = com.tencent.mm.pluginsdk.ui.span.p.b(this, (CharSequence)localObject);; this.lzT.lPj = getString(a.i.gTM))
    {
      this.screen.notifyDataSetChanged();
      AppMethodBeat.o(12587);
      return;
      this.lzT.hBY = true;
      this.lzT.lPk = com.tencent.mm.pluginsdk.ui.span.p.b(this, (CharSequence)localObject);
      break;
    }
  }
  
  private void aMp()
  {
    AppMethodBeat.i(12586);
    if (this.sp == null) {
      this.sp = getSharedPreferences(getPackageName() + "_preferences", 0);
    }
    boolean bool;
    if (this.contact != null)
    {
      if (!this.hQu) {
        break label235;
      }
      if (this.contact.kaf == 0)
      {
        bool = true;
        this.lAj = bool;
      }
    }
    else
    {
      label76:
      if (!this.lAj) {
        break label296;
      }
    }
    label296:
    for (String str = getResources().getString(a.i.conversation_mute);; str = "")
    {
      com.tencent.mm.ui.component.k localk = com.tencent.mm.ui.component.k.aeZF;
      ((com.tencent.mm.chatroom.ui.a.a)com.tencent.mm.ui.component.k.d(getContext()).q(com.tencent.mm.chatroom.ui.a.a.class)).setValue("is_mute", str);
      if (this.lAj)
      {
        setTitleMuteIconVisibility(0);
        if (this.lzY != null) {
          this.sp.edit().putBoolean("room_notify_new_msg", true).commit();
        }
      }
      for (;;)
      {
        ez(this.lAj);
        if (this.screen.bAj("room_set_to_conv_box")) {
          com.tencent.threadpool.h.ahAA.bm(new Runnable()
          {
            public final void run()
            {
              AppMethodBeat.i(241746);
              ChatroomInfoUI.b(ChatroomInfoUI.this, v.Iv(ChatroomInfoUI.b(ChatroomInfoUI.this)));
              AppMethodBeat.o(241746);
            }
          });
        }
        P(12, this.lAj);
        this.screen.notifyDataSetChanged();
        AppMethodBeat.o(12586);
        return;
        bool = false;
        break;
        label235:
        if (this.lzS) {
          break label76;
        }
        this.lAj = this.contact.aGe();
        break label76;
        setTitleMuteIconVisibility(8);
        if (this.lzY != null) {
          this.sp.edit().putBoolean("room_notify_new_msg", false).commit();
        }
      }
    }
  }
  
  private boolean aMq()
  {
    AppMethodBeat.i(241729);
    RoomSpecialFollowMemberManagerUI.a locala = RoomSpecialFollowMemberManagerUI.lLe;
    if ((!RoomSpecialFollowMemberManagerUI.a.aNg()) && (ab.II(this.roomId)))
    {
      AppMethodBeat.o(241729);
      return true;
    }
    AppMethodBeat.o(241729);
    return false;
  }
  
  private void aMr()
  {
    AppMethodBeat.i(241734);
    if (this.sp == null) {
      this.sp = getSharedPreferences(getPackageName() + "_preferences", 0);
    }
    if (this.sp.getBoolean("room_set_to_conv_box", false))
    {
      this.lAb.adXM = true;
      this.lAb.jne();
      AppMethodBeat.o(241734);
      return;
    }
    this.lAb.adXM = false;
    this.lAb.setEnabled(true);
    this.lAb.jnf();
    AppMethodBeat.o(241734);
  }
  
  private void aMs()
  {
    AppMethodBeat.i(12563);
    Log.i("MicroMsg.ChatroomInfoUI", "[doChatroomDetailCgi] :%s", new Object[] { this.roomId });
    com.tencent.mm.roomsdk.model.factory.a locala = com.tencent.mm.roomsdk.model.b.btW(this.roomId).CP(this.roomId);
    locala.b(new com.tencent.mm.roomsdk.model.b.b()
    {
      public final void onResult(int paramAnonymousInt1, int paramAnonymousInt2, String paramAnonymousString, com.tencent.mm.roomsdk.model.b.b paramAnonymousb)
      {
        AppMethodBeat.i(241742);
        if (ChatroomInfoUI.k(ChatroomInfoUI.this) != null) {
          ChatroomInfoUI.a(ChatroomInfoUI.this, ChatroomInfoUI.k(ChatroomInfoUI.this).bHw().size());
        }
        if (((!ChatroomInfoUI.t(ChatroomInfoUI.this)) && (ChatroomInfoUI.s(ChatroomInfoUI.this) >= r.MAX_COUNT)) || ((ChatroomInfoUI.t(ChatroomInfoUI.this)) && (ChatroomInfoUI.s(ChatroomInfoUI.this) >= r.MAX_COUNT - 1)))
        {
          paramAnonymousString = ChatroomInfoUI.g(ChatroomInfoUI.this);
          if (!ChatroomInfoUI.i(ChatroomInfoUI.this)) {
            break label165;
          }
        }
        label165:
        for (boolean bool = true;; bool = false)
        {
          paramAnonymousString.eh("see_room_member", bool);
          ChatroomInfoUI.u(ChatroomInfoUI.this).setTitle(ChatroomInfoUI.this.getString(a.i.lJp));
          ChatroomInfoUI.v(ChatroomInfoUI.this);
          ChatroomInfoUI.w(ChatroomInfoUI.this);
          ChatroomInfoUI.j(ChatroomInfoUI.this);
          AppMethodBeat.o(241742);
          return;
        }
      }
    });
    locala.blj();
    AppMethodBeat.o(12563);
  }
  
  private boolean aMt()
  {
    AppMethodBeat.i(241743);
    if (this.sp == null) {
      this.sp = getSharedPreferences(getPackageName() + "_preferences", 0);
    }
    boolean bool = this.sp.getBoolean("room_set_to_conv_box", false);
    AppMethodBeat.o(241743);
    return bool;
  }
  
  private void aMu()
  {
    AppMethodBeat.i(241751);
    if (this.sp == null) {
      this.sp = getSharedPreferences(this.lAv, 0);
    }
    if (this.contact != null)
    {
      if (!((com.tencent.mm.plugin.messenger.foundation.a.n)com.tencent.mm.kernel.h.ax(com.tencent.mm.plugin.messenger.foundation.a.n.class)).bzG().bxV(this.contact.field_username)) {
        break label145;
      }
      ab.L(this.contact.field_username, true);
      com.tencent.mm.modelstat.b.oUZ.c(false, this.roomId, false);
    }
    for (;;)
    {
      this.sp.edit().putBoolean("room_placed_to_the_top", ((com.tencent.mm.plugin.messenger.foundation.a.n)com.tencent.mm.kernel.h.ax(com.tencent.mm.plugin.messenger.foundation.a.n.class)).bzG().bxV(this.contact.field_username)).commit();
      aMr();
      AppMethodBeat.o(241751);
      return;
      label145:
      ab.K(this.contact.field_username, true);
      com.tencent.mm.modelstat.b.oUZ.c(false, this.roomId, true);
    }
  }
  
  private void aMv()
  {
    AppMethodBeat.i(241763);
    ad.CU(this.roomId);
    com.tencent.mm.plugin.report.service.h.OAn.b(14553, new Object[] { Integer.valueOf(4), Integer.valueOf(2), this.roomId });
    long l = ((com.tencent.mm.plugin.messenger.foundation.a.n)com.tencent.mm.kernel.h.ax(com.tencent.mm.plugin.messenger.foundation.a.n.class)).gaZ().aLF(this.roomId).field_msgSvrId;
    Object localObject = new aig();
    ((aig)localObject).ZqL = new etl().btH(Util.nullAsNil(this.roomId));
    ((aig)localObject).Njv = l;
    ((com.tencent.mm.plugin.messenger.foundation.a.n)com.tencent.mm.kernel.h.ax(com.tencent.mm.plugin.messenger.foundation.a.n.class)).bzz().d(new k.a(8, (com.tencent.mm.bx.a)localObject));
    this.isDeleteCancel = false;
    aMw();
    if (!this.isDeleteCancel) {}
    for (localObject = com.tencent.mm.pluginsdk.wallet.d.brY(this.contact.field_username);; localObject = null)
    {
      if (!Util.isNullOrNil((String)localObject))
      {
        aMx();
        com.tencent.mm.ui.base.k.a(this, false, getString(a.i.lJz, new Object[] { localObject }), null, getString(a.i.goto_conversation), getString(a.i.lIg), new DialogInterface.OnClickListener()new DialogInterface.OnClickListener
        {
          public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
          {
            AppMethodBeat.i(241607);
            com.tencent.mm.plugin.report.service.h.OAn.b(14553, new Object[] { Integer.valueOf(4), Integer.valueOf(4), ChatroomInfoUI.b(ChatroomInfoUI.this) });
            ChatroomInfoUI.d(ChatroomInfoUI.this, true);
            if (!ChatroomInfoUI.x(ChatroomInfoUI.this))
            {
              paramAnonymousDialogInterface = new Intent();
              paramAnonymousDialogInterface.putExtra("Chat_User", ChatroomInfoUI.o(ChatroomInfoUI.this).field_username);
              paramAnonymousDialogInterface.addFlags(67108864);
              com.tencent.mm.br.c.g(ChatroomInfoUI.this, ".ui.chatting.ChattingUI", paramAnonymousDialogInterface);
              AppMethodBeat.o(241607);
              return;
            }
            ChatroomInfoUI.this.finish();
            AppMethodBeat.o(241607);
          }
        }, new DialogInterface.OnClickListener()
        {
          public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
          {
            AppMethodBeat.i(241609);
            com.tencent.mm.plugin.report.service.h.OAn.b(14553, new Object[] { Integer.valueOf(4), Integer.valueOf(3), ChatroomInfoUI.b(ChatroomInfoUI.this) });
            ChatroomInfoUI.z(ChatroomInfoUI.this);
            ChatroomInfoUI.d(ChatroomInfoUI.this, false);
            ChatroomInfoUI.this.Dc(ChatroomInfoUI.b(ChatroomInfoUI.this));
            AppMethodBeat.o(241609);
          }
        }, -1, a.b.alert_btn_color_warn);
        AppMethodBeat.o(241763);
        return;
      }
      Dc(this.roomId);
      AppMethodBeat.o(241763);
      return;
    }
  }
  
  private void aMw()
  {
    AppMethodBeat.i(241765);
    if (this.lzQ == null)
    {
      getString(a.i.app_tip);
      this.lzQ = com.tencent.mm.ui.base.k.a(this, getString(a.i.app_waiting), false, new DialogInterface.OnCancelListener()
      {
        public final void onCancel(DialogInterface paramAnonymousDialogInterface)
        {
          AppMethodBeat.i(241613);
          ChatroomInfoUI.d(ChatroomInfoUI.this, true);
          AppMethodBeat.o(241613);
        }
      });
      AppMethodBeat.o(241765);
      return;
    }
    this.lzQ.show();
    AppMethodBeat.o(241765);
  }
  
  private void aMx()
  {
    AppMethodBeat.i(241767);
    if (this.lzQ != null) {
      this.lzQ.dismiss();
    }
    AppMethodBeat.o(241767);
  }
  
  private void aMy()
  {
    AppMethodBeat.i(12573);
    com.tencent.mm.plugin.report.service.h.OAn.idkeyStat(219L, 7L, 1L, true);
    Object localObject = v.Il(this.roomId);
    String str = Util.listToString((List)localObject, ",");
    if (localObject != null) {
      this.lAi = ((List)localObject).size();
    }
    localObject = new Intent();
    ((Intent)localObject).putExtra("titile", getString(a.i.address_title_select_contact));
    ((Intent)localObject).putExtra("list_type", 1);
    ((Intent)localObject).putExtra("list_attr", qv(w.affp));
    ((Intent)localObject).putExtra("always_select_contact", str);
    ((Intent)localObject).putExtra("scene", 3);
    boolean bool = ab.II(this.contact.field_username);
    if ((!com.tencent.mm.storage.au.bwP(this.contact.field_username)) && (!bool)) {
      ((Intent)localObject).putExtra("without_openim", true);
    }
    if ((com.tencent.mm.storage.au.bwG(this.roomId)) && (!bool)) {}
    for (bool = true;; bool = false)
    {
      ((Intent)localObject).putExtra("KBlockOpenImFav", bool);
      ((Intent)localObject).putExtra("create_group_recommend", true);
      ((Intent)localObject).putExtra("is_select_record_msg_mode", com.tencent.mm.storage.au.bwG(this.roomId));
      ((Intent)localObject).putExtra("menu_mode", 2);
      ((Intent)localObject).putExtra("chatroomName", this.roomId);
      com.tencent.mm.br.c.d(this, ".ui.contact.SelectContactUI", (Intent)localObject, 1);
      AppMethodBeat.o(12573);
      return;
    }
  }
  
  private void aMz()
  {
    AppMethodBeat.i(12574);
    if (this.hQu)
    {
      aMy();
      AppMethodBeat.o(12574);
      return;
    }
    aMD();
    AppMethodBeat.o(12574);
  }
  
  public static ArrayList<com.tencent.mm.storage.au> bu(List<dhe> paramList)
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
      dhe localdhe = (dhe)paramList.next();
      com.tencent.mm.storage.au localau = new com.tencent.mm.storage.au();
      localau.setUsername(localdhe.UserName);
      localau.setNickname(localdhe.vhX);
      localArrayList.add(localau);
    }
    AppMethodBeat.o(12590);
    return localArrayList;
  }
  
  private void eA(boolean paramBoolean)
  {
    AppMethodBeat.i(241761);
    if ((this.roomId == null) || (this.roomId.length() <= 0))
    {
      Log.e("MicroMsg.ChatroomInfoUI", "quitChatRoom : invalid args");
      AppMethodBeat.o(241761);
      return;
    }
    if (paramBoolean)
    {
      aaq localaaq = new aaq();
      localaaq.ieg.iej = true;
      localaaq.publish();
    }
    if (!((com.tencent.mm.plugin.messenger.foundation.a.n)com.tencent.mm.kernel.h.ax(com.tencent.mm.plugin.messenger.foundation.a.n.class)).bzA().bxy(this.roomId))
    {
      Log.e("MicroMsg.ChatroomInfoUI", "quitChatRoom : room[" + this.roomId + "] is not exist");
      AppMethodBeat.o(241761);
      return;
    }
    if (((com.tencent.mm.live.a)com.tencent.mm.kernel.h.az(com.tencent.mm.live.a.class)).isAnchorLiving())
    {
      com.tencent.mm.ui.base.k.a(getContext(), getString(a.i.lHg), null, getString(a.i.app_i_known), new DialogInterface.OnClickListener()
      {
        public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt) {}
      });
      AppMethodBeat.o(241761);
      return;
    }
    if (((com.tencent.mm.live.a)com.tencent.mm.kernel.h.az(com.tencent.mm.live.a.class)).isVisitorLiving()) {
      ((com.tencent.mm.live.a)com.tencent.mm.kernel.h.az(com.tencent.mm.live.a.class)).forceStopCurLive(getContext());
    }
    aMv();
    ((com.tencent.mm.plugin.multitalk.model.d)com.tencent.mm.kernel.h.ax(com.tencent.mm.plugin.multitalk.model.d.class)).aMN(this.roomId);
    AppMethodBeat.o(241761);
  }
  
  private void ez(boolean paramBoolean)
  {
    boolean bool2 = false;
    AppMethodBeat.i(241732);
    if (com.tencent.mm.storage.au.bwG(this.roomId))
    {
      if (aMq())
      {
        this.screen.eh("room_special_follow_member", true);
        this.screen.eh("room_set_to_conv_box", true);
        AppMethodBeat.o(241732);
        return;
      }
      Object localObject;
      boolean bool1;
      if (this.lzR)
      {
        this.screen.eh("room_special_follow_member", true);
        localObject = this.screen;
        bool1 = bool2;
        if (!paramBoolean) {
          bool1 = true;
        }
        ((com.tencent.mm.ui.base.preference.f)localObject).eh("room_set_to_conv_box", bool1);
        if ((paramBoolean) && (!this.lAr))
        {
          this.lAr = true;
          localObject = new com.tencent.mm.autogen.mmdata.rpt.au();
          ((com.tencent.mm.autogen.mmdata.rpt.au)localObject).ipB = 1;
          ((com.tencent.mm.autogen.mmdata.rpt.au)localObject).kI(this.roomId);
          ((com.tencent.mm.autogen.mmdata.rpt.au)localObject).bMH();
          AppMethodBeat.o(241732);
        }
      }
      else
      {
        localObject = this.screen;
        if (!paramBoolean) {}
        for (bool1 = true;; bool1 = false)
        {
          ((com.tencent.mm.ui.base.preference.f)localObject).eh("room_special_follow_member", bool1);
          break;
        }
      }
    }
    else
    {
      this.screen.eh("room_special_follow_member", true);
      this.screen.eh("room_set_to_conv_box", true);
    }
    AppMethodBeat.o(241732);
  }
  
  private void h(Boolean paramBoolean)
  {
    AppMethodBeat.i(241747);
    if (this.sp == null) {
      this.sp = getSharedPreferences(getPackageName() + "_preferences", 0);
    }
    if (paramBoolean != null) {
      this.sp.edit().putBoolean("room_set_to_conv_box", paramBoolean.booleanValue()).apply();
    }
    paramBoolean = ((com.tencent.mm.plugin.messenger.foundation.a.n)com.tencent.mm.kernel.h.ax(com.tencent.mm.plugin.messenger.foundation.a.n.class)).bzG().bxM(this.roomId);
    if (paramBoolean == null)
    {
      paramBoolean = new bb(this.roomId);
      ((com.tencent.mm.plugin.messenger.foundation.a.n)com.tencent.mm.kernel.h.ax(com.tencent.mm.plugin.messenger.foundation.a.n.class)).bzG().h(paramBoolean);
    }
    for (;;)
    {
      aj localaj = ((com.tencent.mm.plugin.chatroom.a.b)com.tencent.mm.kernel.h.ax(com.tencent.mm.plugin.chatroom.a.b.class)).bzK().Ju(this.roomId);
      String str = z.bAM();
      int i;
      if ((paramBoolean != null) && (localaj != null) && (!Util.isNullOrNil(str)))
      {
        if (!aMt()) {
          break label372;
        }
        if (this.sp.getBoolean("room_placed_to_the_top", false))
        {
          aMu();
          paramBoolean = ((com.tencent.mm.plugin.messenger.foundation.a.n)com.tencent.mm.kernel.h.ax(com.tencent.mm.plugin.messenger.foundation.a.n.class)).bzG().bxM(this.roomId);
          ((com.tencent.mm.plugin.chatroom.a.b)com.tencent.mm.kernel.h.ax(com.tencent.mm.plugin.chatroom.a.b.class)).bzK().Ju(this.roomId);
        }
        ((com.tencent.mm.plugin.appbrand.service.n)com.tencent.mm.kernel.h.ax(com.tencent.mm.plugin.appbrand.service.n.class)).a(paramBoolean, this.roomId);
        paramBoolean = com.tencent.mm.util.i.agtt;
        if (((Integer)com.tencent.mm.util.i.a(b.a.agrd, Integer.valueOf(0))).intValue() != 1) {
          break label367;
        }
        i = 1;
        boolean bool = this.sp.getBoolean("is_show_conv_box_guide", false);
        if ((i != 0) || (!bool))
        {
          com.tencent.mm.chatroom.h.b.F(this, this.roomId);
          this.sp.edit().putBoolean("is_show_conv_box_guide", true).apply();
        }
      }
      for (;;)
      {
        aMr();
        AppMethodBeat.o(241747);
        return;
        label367:
        i = 0;
        break;
        label372:
        ((com.tencent.mm.plugin.appbrand.service.n)com.tencent.mm.kernel.h.ax(com.tencent.mm.plugin.appbrand.service.n.class)).b(paramBoolean, this.roomId);
      }
    }
  }
  
  private void qu(int paramInt)
  {
    AppMethodBeat.i(241758);
    switch (paramInt)
    {
    default: 
      Log.d("MicroMsg.ChatroomInfoUI", "dz[dealQuitChatRoom owner click cancel]");
      AppMethodBeat.o(241758);
      return;
    }
    Log.d("MicroMsg.ChatroomInfoUI", "dz[dealQuitChatRoom owner click room_owner_delete_direct]");
    if (((com.tencent.mm.live.a)com.tencent.mm.kernel.h.az(com.tencent.mm.live.a.class)).isAnchorLiving())
    {
      com.tencent.mm.ui.base.k.a(getContext(), getString(a.i.lHg), null, getString(a.i.app_i_known), new DialogInterface.OnClickListener()
      {
        public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt) {}
      });
      AppMethodBeat.o(241758);
      return;
    }
    if (((com.tencent.mm.live.a)com.tencent.mm.kernel.h.az(com.tencent.mm.live.a.class)).isVisitorLiving()) {
      ((com.tencent.mm.live.a)com.tencent.mm.kernel.h.az(com.tencent.mm.live.a.class)).forceStopCurLive(getContext());
    }
    aMv();
    ((com.tencent.mm.plugin.multitalk.model.d)com.tencent.mm.kernel.h.ax(com.tencent.mm.plugin.multitalk.model.d.class)).aMN(this.roomId);
    AppMethodBeat.o(241758);
  }
  
  private int qv(int paramInt)
  {
    AppMethodBeat.i(12575);
    if (!w.jyX())
    {
      AppMethodBeat.o(12575);
      return paramInt;
    }
    if (this.contact != null)
    {
      String str = this.contact.field_username;
      if ((com.tencent.mm.storage.au.bwO(str)) || (com.tencent.mm.storage.au.bwP(str)) || (ab.II(str)))
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
  
  public final void Dc(final String paramString)
  {
    AppMethodBeat.i(241899);
    Log.i("MicroMsg.ChatroomInfoUI", "delete chatroom %s", new Object[] { paramString });
    this.lAA = com.tencent.mm.roomsdk.model.b.btW(paramString).CQ(paramString);
    this.lAA.d(new e() {}).blj();
    AppMethodBeat.o(241899);
  }
  
  public final void aMd()
  {
    boolean bool2 = false;
    AppMethodBeat.i(241907);
    boolean bool1;
    Object localObject;
    if ((!this.lzR) && (this.lzX != null))
    {
      if (this.hQu)
      {
        aMm();
        this.lzX.notifyChanged();
      }
    }
    else
    {
      bool1 = ((com.tencent.mm.plugin.chatroom.a.b)com.tencent.mm.kernel.h.ax(com.tencent.mm.plugin.chatroom.a.b.class)).alP(this.roomId);
      if (aMF()) {
        break label286;
      }
      this.screen.eh("manage_room", true);
      localObject = this.screen;
      if (bool1) {
        break label281;
      }
      bool1 = true;
      label91:
      ((com.tencent.mm.ui.base.preference.f)localObject).eh("room_manager_view", bool1);
      label102:
      if (this.lzR) {
        this.screen.eh("manage_room", true);
      }
      if (((aMF()) || (this.lAi < r.MAX_COUNT)) && ((!aMF()) || (this.lAi < r.MAX_COUNT - 1))) {
        break label317;
      }
      localObject = this.screen;
      bool1 = bool2;
      if (this.lzR) {
        bool1 = true;
      }
      ((com.tencent.mm.ui.base.preference.f)localObject).eh("see_room_member", bool1);
      this.lzV.setTitle(getString(a.i.lJp));
    }
    for (;;)
    {
      if (com.tencent.mm.storage.au.bwF(this.roomId)) {
        this.screen.eh("room_manager_view", true);
      }
      this.screen.notifyDataSetChanged();
      AppMethodBeat.o(241907);
      return;
      if (this.lzS) {
        break;
      }
      localObject = new LinkedList();
      ((List)localObject).add(this.roomId);
      this.lzX.y(this.roomId, (List)localObject);
      break;
      label281:
      bool1 = false;
      break label91;
      label286:
      this.screen.eh("room_manager_view", true);
      this.screen.eh("manage_room", false);
      break label102;
      label317:
      this.screen.eh("see_room_member", true);
    }
  }
  
  public final void aMe()
  {
    AppMethodBeat.i(241894);
    aMl();
    if (this.lzy != null) {
      this.lAi = this.lzy.bHw().size();
    }
    com.tencent.mm.ui.base.preference.f localf;
    if (((!this.lAh) && (this.lAi >= r.MAX_COUNT)) || ((this.lAh) && (this.lAi >= r.MAX_COUNT - 1)))
    {
      localf = this.screen;
      if (!this.lzR) {
        break label115;
      }
    }
    label115:
    for (boolean bool = true;; bool = false)
    {
      localf.eh("see_room_member", bool);
      this.lzV.setTitle(getString(a.i.lJp));
      AppMethodBeat.o(241894);
      return;
    }
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
    return a.k.lJY;
  }
  
  public final void hm(final long paramLong)
  {
    AppMethodBeat.i(241912);
    com.tencent.threadpool.h.ahAA.bm(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(241661);
        bi localbi = new bi();
        localbi.ila = paramLong;
        localbi.ioS = localbi.F("roomUsername", ChatroomInfoUI.b(ChatroomInfoUI.this), true);
        localbi.bMH();
        Log.i("MicroMsg.ChatroomInfoUI", "24182 action = " + paramLong + ",UserRole = " + localbi.irf + ",mRoomId = " + ChatroomInfoUI.b(ChatroomInfoUI.this));
        AppMethodBeat.o(241661);
      }
    });
    AppMethodBeat.o(241912);
  }
  
  public void initView()
  {
    AppMethodBeat.i(12570);
    setBackBtn(new ChatroomInfoUI.41(this));
    this.screen = getPreferenceScreen();
    Object localObject1;
    label99:
    boolean bool;
    if (this.hQu) {
      if (this.lAi == 0)
      {
        setMMTitle(getString(a.i.gTZ));
        localObject1 = null;
        if (this.lzy != null)
        {
          localObject1 = this.lzy.field_roomowner;
          this.lAi = this.lzy.bHw().size();
        }
        if (!Util.isNullOrNil((String)localObject1)) {
          break label1545;
        }
        this.lAh = false;
        Log.d("MicroMsg.ChatroomInfoUI", "initBaseChatRoomView()");
        this.lzX = ((ContactListExpandPreference)this.screen.bAi("roominfo_contact_anchor"));
        this.lzX.a(this.screen, this.lzX.mKey);
        this.lzU = this.screen.bAi("room_name");
        this.lzT = ((RoomCardPreference)this.screen.bAi("room_card"));
        this.lzV = this.screen.bAi("see_room_member");
        this.lzW = this.screen.bAi("room_special_follow_member");
        this.lzY = ((CheckBoxPreference)this.screen.bAi("room_notify_new_msg"));
        this.lzZ = ((CheckBoxPreference)this.screen.bAi("room_save_to_contact"));
        this.lAa = ((CheckBoxPreference)this.screen.bAi("room_set_to_conv_box"));
        this.lAb = ((CheckBoxPreference)this.screen.bAi("room_placed_to_the_top"));
        this.lAc = ((KeyValuePreference)this.screen.bAi("room_nickname"));
        this.lAd = ((KeyValuePreference)this.screen.bAi("room_remark"));
        this.lAf = ((NewTipPreference)this.screen.bAi("manage_room"));
        this.lzX.JJ(true).JK(true).iLw();
        if (this.contact != null)
        {
          if (!this.hQu) {
            break label1565;
          }
          if (this.contact.kaf != 0) {
            break label1560;
          }
          bool = true;
          label387:
          this.lAj = bool;
        }
        label392:
        ez(this.lAj);
        bool = ((com.tencent.mm.plugin.chatroom.a.b)com.tencent.mm.kernel.h.ax(com.tencent.mm.plugin.chatroom.a.b.class)).alP(this.roomId);
        if (aMF()) {
          break label1591;
        }
        this.screen.eh("manage_room", true);
        localObject1 = this.screen;
        if (bool) {
          break label1586;
        }
        bool = true;
        label452:
        ((com.tencent.mm.ui.base.preference.f)localObject1).eh("room_manager_view", bool);
        label464:
        if (this.lzR) {
          this.screen.eh("manage_room", true);
        }
        if ((com.tencent.mm.storage.au.bwG(this.roomId)) && (v.bAI()))
        {
          localObject1 = ((com.tencent.mm.plugin.chatroom.a.b)com.tencent.mm.kernel.h.ax(com.tencent.mm.plugin.chatroom.a.b.class)).bzK().Ju(this.roomId);
          if ((localObject1 != null) && ((((aj)localObject1).field_chatroomStatus & 0x20000) != 131072L) && ((((aj)localObject1).field_chatroomStatus & 0x10000) == 65536L) && (v.bAG()))
          {
            this.lAq = true;
            this.lAf.a(this.screen);
            com.tencent.mm.plugin.newtips.a.gtf().h(this.lAf);
            com.tencent.mm.plugin.newtips.a.g.a(this.lAf);
          }
        }
        if (this.lzy != null)
        {
          this.lzX.brd(this.lzy.field_roomowner);
          if (!Util.isNullOrNil(this.lzy.field_roomowner)) {
            this.lzX.YcP.Yce.YcF = true;
          }
        }
        this.lzX.iLv();
        this.lzX.iLp();
        this.screen.eh("room_name", false);
        this.screen.eh("room_qr_code", false);
        this.screen.eh("chatroom_info_chexboxes", true);
        this.screen.eh("room_card", false);
        this.screen.eh("room_upgrade_entry", true);
        this.screen.eh("chat_room_story_videos", true);
        this.screen.eh("room_set_to_conv_box", true);
        if (((aMF()) || (this.lAi < r.MAX_COUNT)) && ((!aMF()) || (this.lAi < r.MAX_COUNT - 1))) {
          break label1627;
        }
        localObject1 = this.screen;
        if (!this.lzR) {
          break label1622;
        }
        bool = true;
        label815:
        ((com.tencent.mm.ui.base.preference.f)localObject1).eh("see_room_member", bool);
        this.lzV.setTitle(getString(a.i.lJp));
        label841:
        if (com.tencent.mm.storage.au.bwP(this.roomId)) {
          break label1644;
        }
        this.screen.eh("room_openim_about", true);
        label865:
        Log.d("MicroMsg.ChatroomInfoUI", "updatePlaceTop()");
        if (this.sp == null) {
          this.sp = getSharedPreferences(getPackageName() + "_preferences", 0);
        }
        if (this.lAb != null)
        {
          if (this.contact == null) {
            break label1758;
          }
          this.sp.edit().putBoolean("room_placed_to_the_top", ((com.tencent.mm.plugin.messenger.foundation.a.n)com.tencent.mm.kernel.h.ax(com.tencent.mm.plugin.messenger.foundation.a.n.class)).bzG().bxV(this.contact.field_username)).commit();
        }
        label976:
        this.screen.notifyDataSetChanged();
        Log.d("MicroMsg.ChatroomInfoUI", "updateSaveToContact()");
        if (this.sp == null) {
          this.sp = getSharedPreferences(getPackageName() + "_preferences", 0);
        }
        if (this.lzZ == null) {
          break label1816;
        }
        localObject1 = ((com.tencent.mm.plugin.messenger.foundation.a.n)com.tencent.mm.kernel.h.ax(com.tencent.mm.plugin.messenger.foundation.a.n.class)).bzA().JE(this.roomId);
        if (localObject1 != null) {
          break label1785;
        }
        Log.e("MicroMsg.ChatroomInfoUI", "contact == null !!!");
        label1079:
        Log.d("MicroMsg.ChatroomInfoUI", "updateDisplayNickname()");
        if (this.sp == null) {
          this.sp = getSharedPreferences(getPackageName() + "_preferences", 0);
        }
        localObject1 = ((com.tencent.mm.plugin.chatroom.a.b)com.tencent.mm.kernel.h.ax(com.tencent.mm.plugin.chatroom.a.b.class)).bzK().Ju(this.roomId);
        if (localObject1 != null) {
          break label1828;
        }
        Log.e("MicroMsg.ChatroomInfoUI", "members == null !!!");
        label1166:
        Log.d("MicroMsg.ChatroomInfoUI", "updateConvBox()");
        if (this.sp == null) {
          this.sp = getSharedPreferences(getPackageName() + "_preferences", 0);
        }
        if (this.lAa != null)
        {
          if (this.contact == null) {
            break label1902;
          }
          bool = v.Iv(this.roomId);
          this.sp.edit().putBoolean("room_set_to_conv_box", bool).commit();
          label1260:
          this.lAa.adXN = false;
        }
        aMr();
        this.lAl = ((com.tencent.mm.plugin.messenger.foundation.a.n)com.tencent.mm.kernel.h.ax(com.tencent.mm.plugin.messenger.foundation.a.n.class)).gaZ().aLX(this.roomId);
        this.lAl = ((com.tencent.mm.plugin.messenger.foundation.a.n)com.tencent.mm.kernel.h.ax(com.tencent.mm.plugin.messenger.foundation.a.n.class)).gaZ().aLX(this.roomId);
      }
    }
    for (;;)
    {
      if (this.lzR)
      {
        localObject1 = this.screen.bAi("room_del_quit");
        if ((localObject1 instanceof ButtonPreference)) {
          ((ButtonPreference)localObject1).adXI = getResources().getString(a.i.safe_device_del);
        }
        hm(1L);
      }
      if (this.lzX != null)
      {
        if ((!this.hQu) && (this.lzS)) {
          this.lzX.bW(new ArrayList());
        }
        this.lzX.a(new s.b()
        {
          public final boolean qy(int paramAnonymousInt)
          {
            return true;
          }
        });
        localObject1 = this.lzX;
        localObject2 = new ChatroomInfoUI.43(this);
        if (((ContactListExpandPreference)localObject1).YcP != null) {
          ((ContactListExpandPreference)localObject1).YcP.dpY = ((View.OnClickListener)localObject2);
        }
        this.lzX.a(new ContactListExpandPreference.a()
        {
          public final void aMI()
          {
            AppMethodBeat.i(241810);
            if (ChatroomInfoUI.f(ChatroomInfoUI.this) != null) {
              ChatroomInfoUI.f(ChatroomInfoUI.this).iLt();
            }
            AppMethodBeat.o(241810);
          }
          
          public final void e(ViewGroup paramAnonymousViewGroup, int paramAnonymousInt)
          {
            AppMethodBeat.i(241808);
            String str = ChatroomInfoUI.f(ChatroomInfoUI.this).awu(paramAnonymousInt);
            paramAnonymousViewGroup = Util.nullAsNil(ChatroomInfoUI.f(ChatroomInfoUI.this).aww(paramAnonymousInt));
            Object localObject;
            if (Util.isNullOrNil(paramAnonymousViewGroup))
            {
              com.tencent.mm.kernel.h.baF();
              localObject = ((com.tencent.mm.plugin.messenger.foundation.a.n)com.tencent.mm.kernel.h.ax(com.tencent.mm.plugin.messenger.foundation.a.n.class)).bzB().aMi(str);
              if ((localObject != null) && (!Util.isNullOrNil(((cr)localObject).field_encryptUsername))) {
                paramAnonymousViewGroup = ((cr)localObject).field_conRemark;
              }
            }
            for (;;)
            {
              if (Util.isNullOrNil(str))
              {
                AppMethodBeat.o(241808);
                return;
              }
              localObject = new Intent();
              ((Intent)localObject).putExtra("Contact_User", str);
              ((Intent)localObject).putExtra("Contact_RemarkName", paramAnonymousViewGroup);
              if ((ChatroomInfoUI.n(ChatroomInfoUI.this)) && (ChatroomInfoUI.k(ChatroomInfoUI.this) != null)) {
                ((Intent)localObject).putExtra("Contact_RoomNickname", ChatroomInfoUI.k(ChatroomInfoUI.this).getDisplayName(str));
              }
              ((Intent)localObject).putExtra("Contact_Nick", Util.nullAsNil(ChatroomInfoUI.f(ChatroomInfoUI.this).awv(paramAnonymousInt)));
              ((Intent)localObject).putExtra("Contact_RoomMember", true);
              ((Intent)localObject).putExtra("room_name", ChatroomInfoUI.o(ChatroomInfoUI.this).field_username);
              paramAnonymousViewGroup = ((com.tencent.mm.plugin.messenger.foundation.a.n)com.tencent.mm.kernel.h.ax(com.tencent.mm.plugin.messenger.foundation.a.n.class)).bzA().JE(str);
              if ((paramAnonymousViewGroup != null) && ((int)paramAnonymousViewGroup.maN > 0) && (com.tencent.mm.contact.d.rs(paramAnonymousViewGroup.field_type)))
              {
                xc localxc = new xc();
                localxc.iaC.intent = ((Intent)localObject);
                localxc.iaC.username = str;
                localxc.publish();
              }
              if (ChatroomInfoUI.n(ChatroomInfoUI.this))
              {
                com.tencent.mm.plugin.report.service.h.OAn.idkeyStat(219L, 9L, 1L, true);
                if ((paramAnonymousViewGroup != null) && (paramAnonymousViewGroup.iZC())) {
                  com.tencent.mm.plugin.report.service.h.OAn.kvStat(10298, paramAnonymousViewGroup.field_username + ",14");
                }
                ((Intent)localObject).putExtra("Contact_Scene", 14);
              }
              for (;;)
              {
                ((Intent)localObject).putExtra("Is_RoomOwner", ChatroomInfoUI.q(ChatroomInfoUI.this));
                ((Intent)localObject).putExtra("Contact_ChatRoomId", ChatroomInfoUI.b(ChatroomInfoUI.this));
                if (com.tencent.mm.storage.au.bwF(ChatroomInfoUI.b(ChatroomInfoUI.this)))
                {
                  paramAnonymousViewGroup = new lf();
                  paramAnonymousViewGroup.uc(ChatroomInfoUI.b(ChatroomInfoUI.this));
                  paramAnonymousViewGroup.iuA = 12L;
                  paramAnonymousViewGroup.bMH();
                }
                ((Intent)localObject).putExtra("CONTACT_INFO_UI_SOURCE", 8);
                com.tencent.mm.br.c.b(ChatroomInfoUI.this, "profile", ".ui.ContactInfoUI", (Intent)localObject);
                AppMethodBeat.o(241808);
                return;
                if (ChatroomInfoUI.p(ChatroomInfoUI.this))
                {
                  ((Intent)localObject).putExtra("Contact_Scene", 44);
                  if (!z.Iy(paramAnonymousViewGroup.field_username)) {
                    ((Intent)localObject).putExtra("Contact_IsLBSFriend", true);
                  }
                }
              }
            }
          }
          
          public final void qw(int paramAnonymousInt)
          {
            AppMethodBeat.i(241795);
            ChatroomInfoUI.m(ChatroomInfoUI.this);
            AppMethodBeat.o(241795);
          }
          
          public final void qx(int paramAnonymousInt)
          {
            AppMethodBeat.i(241815);
            ChatroomInfoUI.r(ChatroomInfoUI.this);
            AppMethodBeat.o(241815);
          }
        });
      }
      AppMethodBeat.o(12570);
      return;
      if (this.lzy != null) {
        this.lAi = this.lzy.bHw().size();
      }
      setMMTitle(getString(a.i.gIp, new Object[] { getString(a.i.gTZ), Integer.valueOf(this.lAi) }));
      break;
      label1545:
      this.lAh = ((String)localObject1).equals(z.bAM());
      break label99;
      label1560:
      bool = false;
      break label387;
      label1565:
      if (this.lzS) {
        break label392;
      }
      this.lAj = this.contact.aGe();
      break label392;
      label1586:
      bool = false;
      break label452;
      label1591:
      this.screen.eh("room_manager_view", true);
      this.screen.eh("manage_room", false);
      break label464;
      label1622:
      bool = false;
      break label815;
      label1627:
      this.screen.eh("see_room_member", true);
      break label841;
      label1644:
      this.screen.eh("chatroom_bottom_pc", true);
      this.screen.eh("room_openim_about", false);
      localObject1 = getString(a.i.lIC);
      Object localObject2 = getString(a.i.lID);
      int i = ((String)localObject1).lastIndexOf((String)localObject2);
      if (i < 0) {
        break label865;
      }
      int j = ((String)localObject2).length();
      localObject1 = new SpannableStringBuilder((CharSequence)localObject1);
      ((SpannableStringBuilder)localObject1).setSpan(new ChatroomInfoUI.6(this), i, j + i, 18);
      this.screen.bAi("room_openim_about").setTitle((CharSequence)localObject1);
      break label865;
      label1758:
      this.sp.edit().putBoolean("room_placed_to_the_top", false).commit();
      break label976;
      label1785:
      this.sp.edit().putBoolean("room_save_to_contact", com.tencent.mm.contact.d.rs(((az)localObject1).field_type)).commit();
      label1816:
      this.screen.notifyDataSetChanged();
      break label1079;
      label1828:
      this.lAg = ((aj)localObject1).iZn();
      this.lAe = ((CheckBoxPreference)this.screen.bAi("room_msg_show_username"));
      if (this.lAe != null) {
        this.sp.edit().putBoolean("room_msg_show_username", this.lAg).commit();
      }
      this.screen.notifyDataSetChanged();
      break label1166;
      label1902:
      this.sp.edit().putBoolean("room_set_to_conv_box", false).commit();
      break label1260;
      if (this.lzS)
      {
        this.lAh = false;
        setMMTitle(getString(a.i.lIs));
        this.lzX = ((ContactListExpandPreference)this.screen.bAi("roominfo_contact_anchor"));
        this.lzX.a(this.screen, this.lzX.mKey);
        this.lzX.JJ(false).JK(false);
        this.lzX.a(new s.b()
        {
          public final boolean qy(int paramAnonymousInt)
          {
            return true;
          }
        });
        this.screen.removeAll();
        if (!this.lzR)
        {
          this.screen.c(new PreferenceCategory(this));
          this.screen.c(this.lzX);
        }
        localObject1 = new ph();
        ((ph)localObject1).hSw.hQf = this.roomId;
        ((ph)localObject1).publish();
        getString(a.i.app_tip);
        this.lzP = com.tencent.mm.ui.base.k.a(this, getString(a.i.lIq), true, new DialogInterface.OnCancelListener()
        {
          public final void onCancel(DialogInterface paramAnonymousDialogInterface)
          {
            AppMethodBeat.i(241791);
            this.lAE.hSw.hRY = true;
            this.lAE.publish();
            AppMethodBeat.o(241791);
          }
        });
        this.screen.notifyDataSetChanged();
      }
    }
  }
  
  public final void m(String paramString1, String paramString2, String paramString3)
  {
    AppMethodBeat.i(12598);
    if ((!this.lzR) && (paramString1.equals(this.roomId)) && (this.lzX != null)) {
      this.lzX.notifyChanged();
    }
    AppMethodBeat.o(12598);
  }
  
  public void onActivityResult(int paramInt1, int paramInt2, final Intent paramIntent)
  {
    AppMethodBeat.i(12569);
    super.onActivityResult(paramInt1, paramInt2, paramIntent);
    switch (paramInt1)
    {
    case 3: 
    case 8: 
    case 9: 
    default: 
      AppMethodBeat.o(12569);
      return;
    case 1: 
      if (paramInt2 != -1)
      {
        ((y)com.tencent.mm.kernel.h.ax(y.class)).aaB(3);
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
    case 7: 
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
      paramIntent = com.tencent.mm.roomsdk.model.b.btW(this.roomId).a(this.roomId, paramIntent, 0);
      paramIntent.b(new com.tencent.mm.roomsdk.model.b.b()
      {
        public final void onResult(int paramAnonymousInt1, int paramAnonymousInt2, String paramAnonymousString, com.tencent.mm.roomsdk.model.b.b paramAnonymousb)
        {
          AppMethodBeat.i(241576);
          ChatroomInfoUI.this.aMd();
          ChatroomInfoUI.this.aMe();
          AppMethodBeat.o(241576);
        }
      });
      paramIntent.c(new com.tencent.mm.roomsdk.model.b.b()
      {
        public final void onResult(int paramAnonymousInt1, int paramAnonymousInt2, String paramAnonymousString, com.tencent.mm.roomsdk.model.b.b paramAnonymousb)
        {
          AppMethodBeat.i(241579);
          paramAnonymousb = com.tencent.mm.broadcast.a.CH(paramAnonymousString);
          if (paramAnonymousb != null)
          {
            paramAnonymousb.a(ChatroomInfoUI.this, null, null);
            AppMethodBeat.o(241579);
            return;
          }
          if (paramAnonymousInt2 == -66) {
            com.tencent.mm.ui.base.k.c(ChatroomInfoUI.this, ChatroomInfoUI.this.getString(a.i.lHv), ChatroomInfoUI.this.getString(a.i.app_tip), true);
          }
          for (;;)
          {
            ChatroomInfoUI.this.aMd();
            ChatroomInfoUI.this.aMe();
            Log.i("MicroMsg.ActionCallbackFunc", "[delChatroomMember] onResult errType:%s errCode:%s", new Object[] { Integer.valueOf(paramAnonymousInt1), Integer.valueOf(paramAnonymousInt2) });
            AppMethodBeat.o(241579);
            return;
            com.tencent.mm.ui.base.k.c(ChatroomInfoUI.this, Util.nullAs(paramAnonymousString, ChatroomInfoUI.this.getString(a.i.lHw)), ChatroomInfoUI.this.getString(a.i.app_tip), true);
          }
        }
      });
      paramIntent.a(this, getString(a.i.app_tip), getString(a.i.gTw), true, true, new DialogInterface.OnCancelListener()
      {
        public final void onCancel(DialogInterface paramAnonymousDialogInterface)
        {
          AppMethodBeat.i(241582);
          paramIntent.cancel();
          AppMethodBeat.o(241582);
        }
      });
      AppMethodBeat.o(12569);
      return;
    case 2: 
      if (paramInt2 == -1)
      {
        finish();
        AppMethodBeat.o(12569);
        return;
      }
      break;
    case 4: 
      if (paramInt2 == -1)
      {
        paramIntent = paramIntent.getStringExtra("room_name");
        if (!Util.isNullOrNil(paramIntent))
        {
          new abv().publish();
          this.contact.setNickname(paramIntent);
          ((com.tencent.mm.plugin.messenger.foundation.a.n)com.tencent.mm.kernel.h.ax(com.tencent.mm.plugin.messenger.foundation.a.n.class)).bzA().aA(this.contact);
          aMn();
        }
        AppMethodBeat.o(12569);
        return;
      }
      break;
    case 10: 
      if (paramIntent == null)
      {
        AppMethodBeat.o(12569);
        return;
      }
      if (paramIntent.getBooleanExtra("dismiss_chatroom", false))
      {
        finish();
        AppMethodBeat.o(12569);
        return;
      }
      break;
    case 5: 
      if (paramInt2 == 0)
      {
        this.lAs = -1;
        AppMethodBeat.o(12569);
        return;
      }
      break;
    case 6: 
      if (paramInt2 == -1)
      {
        aMo();
        AppMethodBeat.o(12569);
        return;
      }
      break;
    }
    AppMethodBeat.o(12569);
  }
  
  public void onConfigurationChanged(Configuration paramConfiguration)
  {
    AppMethodBeat.i(12565);
    super.onConfigurationChanged(paramConfiguration);
    if ((!this.lzR) && (this.lzX != null)) {
      this.lzX.notifyChanged();
    }
    AppMethodBeat.o(12565);
  }
  
  public void onCreate(final Bundle paramBundle)
  {
    AppMethodBeat.i(12562);
    this.roomId = getIntent().getStringExtra("RoomInfo_Id");
    if ((com.tencent.mm.storage.au.bwE(this.roomId)) && (((com.tencent.mm.plugin.chatroom.a.b)com.tencent.mm.kernel.h.ax(com.tencent.mm.plugin.chatroom.a.b.class)).alQ(this.roomId)))
    {
      bool = true;
      this.lzR = bool;
      bool = v.If(this.roomId);
      Log.i("MicroMsg.ChatroomInfoUI", "isChatroomDismiss = " + this.lzR + ", inChatRoom = " + bool);
      if ((!this.lzR) && (bool)) {
        break label417;
      }
    }
    label417:
    for (boolean bool = true;; bool = false)
    {
      this.lzR = bool;
      super.onCreate(paramBundle);
      com.tencent.mm.kernel.h.baD().mCm.a(480, this);
      IListenerNetScene.a(ph.class.getName(), this.lAz);
      this.lAx.alive();
      this.lAy.alive();
      com.tencent.mm.kernel.h.baE().ban().add(this);
      ((com.tencent.mm.plugin.chatroom.a.b)com.tencent.mm.kernel.h.ax(com.tencent.mm.plugin.chatroom.a.b.class)).bzK().add(this);
      if (com.tencent.mm.bc.g.oXL != null) {
        com.tencent.mm.bc.g.oXL.a(this);
      }
      this.contact = ((com.tencent.mm.plugin.messenger.foundation.a.n)com.tencent.mm.kernel.h.ax(com.tencent.mm.plugin.messenger.foundation.a.n.class)).bzA().JE(this.roomId);
      this.lAm = true;
      this.hQu = getIntent().getBooleanExtra("Is_Chatroom", true);
      this.lzS = getIntent().getBooleanExtra("Is_Lbsroom", false);
      this.lAn = getIntent().getBooleanExtra("fromChatting", false);
      this.lAo = getIntent().getBooleanExtra("isShowSetMuteAnimation", false);
      this.lAv = (getPackageName() + "_preferences");
      if (this.hQu) {
        this.lzy = ((com.tencent.mm.plugin.chatroom.a.b)com.tencent.mm.kernel.h.ax(com.tencent.mm.plugin.chatroom.a.b.class)).bzK().Ju(this.roomId);
      }
      initView();
      if (!this.hQu) {
        break label456;
      }
      paramBundle = new az.b.a()
      {
        public final void getContactCallBack(String paramAnonymousString, boolean paramAnonymousBoolean)
        {
          AppMethodBeat.i(241754);
          if ((paramAnonymousBoolean) && (ChatroomInfoUI.b(ChatroomInfoUI.this).equals(paramAnonymousString))) {
            com.tencent.mm.kernel.h.baH().postToWorker(new ChatroomInfoUI.11.1(this, paramAnonymousString));
          }
          AppMethodBeat.o(241754);
        }
      };
      if (this.lzy != null) {
        break label422;
      }
      az.a.okP.a(this.roomId, "", paramBundle);
      AppMethodBeat.o(12562);
      return;
      bool = false;
      break;
    }
    label422:
    if (System.currentTimeMillis() - this.lzy.field_modifytime >= 86400000L) {
      com.tencent.mm.kernel.h.baH().postToWorker(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(241756);
          az.a.okP.a(ChatroomInfoUI.k(ChatroomInfoUI.this).field_chatroomname, "", paramBundle);
          AppMethodBeat.o(241756);
        }
        
        public final String toString()
        {
          AppMethodBeat.i(241757);
          String str = super.toString() + "|getContactCallBack2";
          AppMethodBeat.o(241757);
          return str;
        }
      });
    }
    label456:
    AppMethodBeat.o(12562);
  }
  
  public void onDestroy()
  {
    AppMethodBeat.i(12568);
    if (com.tencent.mm.bc.g.oXL != null) {
      com.tencent.mm.bc.g.oXL.a(this);
    }
    com.tencent.mm.kernel.h.baE().ban().remove(this);
    com.tencent.mm.ui.j.a.dismiss();
    com.tencent.mm.kernel.h.baD().mCm.b(480, this);
    this.lAx.dead();
    this.lAy.dead();
    IListenerNetScene.b(ph.class.getName(), this.lAz);
    if (com.tencent.mm.kernel.h.baz())
    {
      ((com.tencent.mm.plugin.messenger.foundation.a.n)com.tencent.mm.kernel.h.ax(com.tencent.mm.plugin.messenger.foundation.a.n.class)).bzA().remove(this);
      ((com.tencent.mm.plugin.chatroom.a.b)com.tencent.mm.kernel.h.ax(com.tencent.mm.plugin.chatroom.a.b.class)).bzK().remove(this);
    }
    if (com.tencent.mm.bc.g.oXL != null) {
      com.tencent.mm.bc.g.oXL.b(this);
    }
    if (this.lAB != null) {
      this.lAB.stopTimer();
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
    if (!com.tencent.mm.storage.au.bwE(paramString))
    {
      Log.d("MicroMsg.ChatroomInfoUI", "event:" + paramString + " cancel");
      AppMethodBeat.o(12597);
      return;
    }
    Log.d("MicroMsg.ChatroomInfoUI", "event:".concat(String.valueOf(paramString)));
    if ((this.hQu) && (paramString.equals(this.roomId))) {
      com.tencent.mm.kernel.h.baH().postToWorker(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(12546);
          ChatroomInfoUI.a(ChatroomInfoUI.this, ((com.tencent.mm.plugin.chatroom.a.b)com.tencent.mm.kernel.h.ax(com.tencent.mm.plugin.chatroom.a.b.class)).bzK().Ju(ChatroomInfoUI.b(ChatroomInfoUI.this)));
          if (ChatroomInfoUI.k(ChatroomInfoUI.this) == null)
          {
            Log.e("MicroMsg.ChatroomInfoUI", "member is null");
            AppMethodBeat.o(12546);
            return;
          }
          if (Util.isNullOrNil(ChatroomInfoUI.k(ChatroomInfoUI.this).field_roomowner))
          {
            Log.e("MicroMsg.ChatroomInfoUI", "roomowner is null");
            AppMethodBeat.o(12546);
            return;
          }
          ChatroomInfoUI.l(ChatroomInfoUI.this).sendEmptyMessage(0);
          ChatroomInfoUI.a(ChatroomInfoUI.this, ChatroomInfoUI.k(ChatroomInfoUI.this).field_roomowner.equals(z.bAM()));
          if (!ChatroomInfoUI.i(ChatroomInfoUI.this)) {
            ChatroomInfoUI.f(ChatroomInfoUI.this).brd(ChatroomInfoUI.k(ChatroomInfoUI.this).field_roomowner);
          }
          AppMethodBeat.o(12546);
        }
        
        public final String toString()
        {
          AppMethodBeat.i(241621);
          String str = super.toString() + "|onNotifyChange";
          AppMethodBeat.o(241621);
          return str;
        }
      });
    }
    aMd();
    AppMethodBeat.o(12597);
  }
  
  public void onPause()
  {
    AppMethodBeat.i(12567);
    super.onPause();
    if ((this.lAk) && (this.hQu))
    {
      if (this.lzy == null)
      {
        AppMethodBeat.o(12567);
        return;
      }
      v.a(this.roomId, this.lzy, this.lAg);
    }
    AppMethodBeat.o(12567);
  }
  
  public boolean onPreferenceTreeClick(com.tencent.mm.ui.base.preference.f paramf, Preference arg2)
  {
    AppMethodBeat.i(12571);
    paramf = ???.mKey;
    int i;
    if (paramf.equals("room_name"))
    {
      i = 0;
      paramf = com.tencent.mm.k.i.aRC().getValue("ChatRoomOwnerModTopic");
      if (!Util.isNullOrNil(paramf)) {
        i = Util.safeParseInt(paramf);
      }
      if ((this.lzy != null) && (!Util.isNullOrNil(this.lzy.field_roomowner)) && (i > 0) && (!aMF()) && (i < this.lAi)) {
        com.tencent.mm.ui.base.k.a(this, getString(a.i.lIV, new Object[] { aMB() }), null, getString(a.i.app_i_known), new DialogInterface.OnClickListener()
        {
          public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt) {}
        });
      }
    }
    label906:
    label928:
    label1067:
    label1209:
    label1214:
    label1220:
    label1349:
    label2890:
    for (;;)
    {
      AppMethodBeat.o(12571);
      return false;
      paramf = new Intent();
      paramf.setClass(this, ModRemarkRoomNameUI.class);
      paramf.putExtra("Key_Scenen", 1);
      paramf.putExtra("Key_Room_Id", this.roomId);
      paramf = new com.tencent.mm.hellhoundlib.b.a().cG(paramf);
      com.tencent.mm.hellhoundlib.a.a.b(this, paramf.aYi(), "com/tencent/mm/chatroom/ui/ChatroomInfoUI", "onPreferenceTreeClick", "(Lcom/tencent/mm/ui/base/preference/IPreferenceScreen;Lcom/tencent/mm/ui/base/preference/Preference;)Z", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
      startActivity((Intent)paramf.sb(0));
      com.tencent.mm.hellhoundlib.a.a.c(this, "com/tencent/mm/chatroom/ui/ChatroomInfoUI", "onPreferenceTreeClick", "(Lcom/tencent/mm/ui/base/preference/IPreferenceScreen;Lcom/tencent/mm/ui/base/preference/Preference;)Z", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
      com.tencent.mm.plugin.report.service.h.OAn.idkeyStat(219L, 3L, 1L, true);
      continue;
      label1228:
      label1626:
      if (paramf.equals("room_upgrade_entry"))
      {
        if (Util.getInt(com.tencent.mm.k.i.aRC().getValue("ChatroomGlobalSwitch"), 1) == 1) {}
        for (i = 1;; i = 0)
        {
          if (i == 0) {
            break label361;
          }
          paramf = new Intent();
          paramf.putExtra("rawUrl", getString(a.i.chatroom_how_to_upgrade, new Object[] { LocaleUtil.getApplicationLanguage() }));
          paramf.putExtra("geta8key_username", z.bAM());
          paramf.putExtra("showShare", false);
          com.tencent.mm.br.c.b(this, "webview", "com.tencent.mm.plugin.webview.ui.tools.WebViewUI", paramf);
          break;
        }
      }
      else
      {
        label361:
        if (paramf.equals("room_qr_code"))
        {
          if (com.tencent.mm.storage.au.bwF(this.roomId))
          {
            paramf = new lf();
            paramf.uc(this.roomId);
            paramf.iuA = 6L;
            paramf.bMH();
          }
          com.tencent.mm.plugin.report.service.h.OAn.idkeyStat(219L, 5L, 1L, true);
          paramf = new Intent();
          paramf.putExtra("from_userName", this.roomId);
          com.tencent.mm.br.c.b(this, "setting", ".ui.setting.SelfQRCodeUI", paramf);
        }
        else
        {
          final boolean bool1;
          long l;
          if (paramf.equals("room_card"))
          {
            if (this.lzy == null)
            {
              Log.w("MicroMsg.ChatroomInfoUI", "goToRoomCardUI member == null");
            }
            else
            {
              bool1 = this.lzy.bvK(z.bAM());
              if ((Util.isNullOrNil(v.Ip(this.roomId))) && (!aMF()))
              {
                com.tencent.mm.ui.base.k.b(this, getString(a.i.lHZ), null, getString(a.i.lIa), null, null, null);
              }
              else
              {
                paramf = new Intent();
                paramf.setClass(this, RoomCardUI.class);
                paramf.putExtra("RoomInfo_Id", this.roomId);
                paramf.putExtra("room_name", this.lzT.lPj.toString());
                this.lAi = v.Il(this.roomId).size();
                paramf.putExtra("room_member_count", this.lAi);
                paramf.putExtra("room_owner_name", aMB());
                paramf.putExtra("room_notice", v.Ip(this.roomId));
                paramf.putExtra("room_notice_publish_time", v.Is(this.roomId));
                paramf.putExtra("room_notice_editor", v.Ir(this.roomId));
                paramf.putExtra("Is_RoomOwner", this.lAh);
                paramf.putExtra("Is_RoomManager", bool1);
                paramf.putExtra("from_scene", 1);
                startActivityForResult(paramf, 6);
                paramf = new qt().xT(this.roomId);
                paramf.imZ = this.lzy.field_memberCount;
                if (this.lAh)
                {
                  l = 1L;
                  paramf.imY = l;
                  paramf = paramf.xU(this.lzy.field_chatroomnoticePublishTime);
                  paramf.ikE = 1L;
                  paramf.bMH();
                }
                else
                {
                  if (bool1) {}
                  for (i = 2;; i = 0)
                  {
                    l = i;
                    break;
                  }
                }
              }
            }
          }
          else
          {
            if (paramf.equals("room_set_to_conv_box"))
            {
              h(null);
              bool1 = v.Iv(this.roomId);
              paramf = new am().kB(this.roomId);
              if (bool1) {}
              for (l = 1L;; l = 0L)
              {
                paramf.ila = l;
                paramf.bMH();
                break;
              }
            }
            if (paramf.equals("room_notify_new_msg")) {
              if (!this.lAj)
              {
                bool1 = true;
                this.lAj = bool1;
                if (this.hQu)
                {
                  if (!this.lAj) {
                    break label1209;
                  }
                  i = 0;
                  com.tencent.mm.roomsdk.model.b.btW(this.roomId).aj(this.roomId, i).blj();
                  this.contact = ((com.tencent.mm.plugin.messenger.foundation.a.n)com.tencent.mm.kernel.h.ax(com.tencent.mm.plugin.messenger.foundation.a.n.class)).bzA().JE(this.roomId);
                  this.contact.pz(i);
                  ((com.tencent.mm.plugin.messenger.foundation.a.n)com.tencent.mm.kernel.h.ax(com.tencent.mm.plugin.messenger.foundation.a.n.class)).bzA().d(this.roomId, this.contact);
                  if (this.lAp)
                  {
                    paramf = com.tencent.mm.plugin.report.service.h.OAn;
                    if (!this.lAj) {
                      break label1214;
                    }
                    i = 14;
                    paramf.kJ(869, i);
                  }
                  paramf = new am().kB(this.roomId);
                  if (!this.lAj) {
                    break label1220;
                  }
                  l = 11L;
                  paramf.ila = l;
                  paramf.bMH();
                }
                paramf = com.tencent.mm.modelstat.b.oUZ;
                ??? = this.roomId;
                bool1 = this.lAj;
                if ((paramf.bMW()) && (paramf.hZ(???)))
                {
                  ??? = new IMBehavior();
                  ???.opType = 1;
                  ???.chattingOp = new IMBehaviorChattingOP();
                  ??? = ???.chattingOp;
                  if (!bool1) {
                    break label1228;
                  }
                  i = 1;
                  ((IMBehaviorChattingOP)???).changeNotifyStatus = i;
                }
              }
            }
            synchronized (paramf.lock)
            {
              paramf.oUY.oplist_.add(???);
              aMp();
              if ((aMq()) || (this.lAj)) {
                continue;
              }
              h(Boolean.FALSE);
              continue;
              bool1 = false;
              break label906;
              i = 1;
              break label928;
              i = 15;
              break label1032;
              l = 10L;
              break label1067;
              i = 2;
            }
            this.sp = getSharedPreferences(getPackageName() + "_preferences", 0);
            paramf = ((com.tencent.mm.plugin.messenger.foundation.a.n)com.tencent.mm.kernel.h.ax(com.tencent.mm.plugin.messenger.foundation.a.n.class)).bzA().JE(this.roomId);
            if (paramf != null)
            {
              boolean bool2 = com.tencent.mm.contact.d.rs(paramf.field_type);
              ??? = this.sp.edit();
              if (!bool2)
              {
                bool1 = true;
                ???.putBoolean("room_save_to_contact", bool1).commit();
                if (!bool2) {
                  break label1430;
                }
                paramf.aRL();
                com.tencent.mm.roomsdk.model.b.btW(this.roomId).a(paramf, false);
                com.tencent.mm.ui.base.k.cZ(this, getString(a.i.gTU));
                com.tencent.mm.modelstat.b.oUZ.ad(this.roomId, false);
              }
              for (;;)
              {
                this.screen.notifyDataSetChanged();
                break;
                bool1 = false;
                break label1349;
                com.tencent.mm.roomsdk.model.b.btW(this.roomId).a(paramf, true);
                com.tencent.mm.ui.base.k.cZ(this, getString(a.i.gTW));
                com.tencent.mm.modelstat.b.oUZ.ad(this.roomId, true);
              }
              if (paramf.equals("room_placed_to_the_top"))
              {
                aMu();
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
                  paramf = getSharedPreferences(this.lAv, 0).edit();
                  if (!this.lAg)
                  {
                    bool1 = true;
                    paramf.putBoolean("room_msg_show_username", bool1).commit();
                    if (this.lAg) {
                      break label1626;
                    }
                  }
                  for (bool1 = true;; bool1 = false)
                  {
                    this.lAg = bool1;
                    this.lAk = true;
                    break;
                    bool1 = false;
                    break label1579;
                  }
                }
                if (paramf.equals("room_set_chatting_background"))
                {
                  if (com.tencent.mm.storage.au.bwF(this.roomId))
                  {
                    paramf = new lf();
                    paramf.uc(this.roomId);
                    paramf.iuA = 9L;
                    paramf.bMH();
                  }
                  paramf = new Intent();
                  paramf.putExtra("isApplyToAll", false);
                  paramf.putExtra("username", this.contact.field_username);
                  com.tencent.mm.br.c.b(this, "setting", ".ui.setting.SettingsChattingBackgroundUI", paramf, 2);
                }
                else if (paramf.equals("room_search_chatting_content"))
                {
                  if (com.tencent.mm.storage.au.bwF(this.roomId))
                  {
                    paramf = new lf();
                    paramf.uc(this.roomId);
                    paramf.iuA = 8L;
                    paramf.bMH();
                  }
                  paramf = new Intent();
                  paramf.putExtra("detail_username", this.roomId);
                  paramf.putExtra("detail_user_dismiss", this.lzR);
                  com.tencent.mm.plugin.fts.a.d.d(this, ".ui.FTSChattingConvUI", paramf);
                  int j = 0;
                  i = j;
                  if (this.lzy != null)
                  {
                    i = j;
                    if (this.lzy.bHw() != null) {
                      i = this.lzy.bHw().size();
                    }
                  }
                  if (this.lzR) {
                    com.tencent.mm.plugin.report.service.h.OAn.b(14569, new Object[] { Integer.valueOf(1), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(i), Integer.valueOf(2), Integer.valueOf(0), Integer.valueOf(11) });
                  } else {
                    com.tencent.mm.plugin.report.service.h.OAn.b(14569, new Object[] { Integer.valueOf(1), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(i), Integer.valueOf(1) });
                  }
                }
                else if (paramf.equals("room_clear_chatting_history"))
                {
                  if (com.tencent.mm.storage.au.bwF(this.roomId))
                  {
                    paramf = new lf();
                    paramf.uc(this.roomId);
                    paramf.iuA = 11L;
                    paramf.bMH();
                  }
                  paramf = getString(a.i.lHA);
                  com.tencent.mm.ui.base.k.a(getContext(), paramf, "", getString(a.i.app_clear), getString(a.i.app_cancel), new DialogInterface.OnClickListener()
                  {
                    public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
                    {
                      AppMethodBeat.i(12519);
                      ChatroomInfoUI.c(ChatroomInfoUI.this, true);
                      AppMethodBeat.o(12519);
                    }
                  }, null, a.b.alert_btn_color_warn);
                }
                else if (paramf.equals("room_report_it"))
                {
                  if (this.lzR) {
                    hm(5L);
                  }
                  if (com.tencent.mm.storage.au.bwF(this.roomId))
                  {
                    paramf = new lf();
                    paramf.uc(this.roomId);
                    paramf.iuA = 10L;
                    paramf.bMH();
                  }
                  paramf = new Intent();
                  paramf.putExtra("k_username", this.roomId);
                  paramf.putExtra("showShare", false);
                  paramf.putExtra("rawUrl", String.format(f.f.adwf, new Object[] { Integer.valueOf(36) }));
                  com.tencent.mm.br.c.b(this, "webview", ".ui.tools.WebViewUI", paramf);
                  paramf = com.tencent.mm.modelstat.b.oUZ;
                  ??? = this.roomId;
                  if ((paramf.bMW()) && (paramf.hZ(???)))
                  {
                    ??? = new IMBehavior();
                    ((IMBehavior)???).opType = 1;
                    ((IMBehavior)???).chattingOp = new IMBehaviorChattingOP();
                    ((IMBehavior)???).chattingOp.expose = 1;
                    synchronized (paramf.lock)
                    {
                      paramf.oUY.oplist_.add(???);
                    }
                  }
                }
                else if (paramf.equals("room_del_quit"))
                {
                  if (this.lzR)
                  {
                    hm(2L);
                    paramf = new com.tencent.mm.ui.widget.a.f(this, 1, true);
                    paramf.Vtg = new u.g()
                    {
                      public final void onCreateMMMenu(com.tencent.mm.ui.base.s paramAnonymouss)
                      {
                        AppMethodBeat.i(241736);
                        paramAnonymouss.a(0, ChatroomInfoUI.this.getResources().getColor(a.b.red_text_color_selector), ChatroomInfoUI.this.getString(a.i.app_ok));
                        AppMethodBeat.o(241736);
                      }
                    };
                    paramf.h(getString(a.i.del_after_dismiss_chatroom_dialog_title), 17, com.tencent.mm.cd.a.fromDPToPix(this, 14));
                    paramf.GAC = new u.i()
                    {
                      public final void onMMMenuItemSelected(MenuItem paramAnonymousMenuItem, int paramAnonymousInt)
                      {
                        AppMethodBeat.i(241721);
                        switch (paramAnonymousInt)
                        {
                        default: 
                          ChatroomInfoUI.this.hm(4L);
                          AppMethodBeat.o(241721);
                          return;
                        }
                        ChatroomInfoUI.this.hm(3L);
                        ChatroomInfoUI.c(ChatroomInfoUI.this, false);
                        ChatroomInfoUI.y(ChatroomInfoUI.this);
                        AppMethodBeat.o(241721);
                      }
                    };
                    paramf.aeLi = new f.b()
                    {
                      public final void onDismiss()
                      {
                        AppMethodBeat.i(241720);
                        ChatroomInfoUI.this.hm(4L);
                        AppMethodBeat.o(241720);
                      }
                    };
                    paramf.dDn();
                  }
                  else
                  {
                    Log.d("MicroMsg.ChatroomInfoUI", " quit " + this.roomId);
                    paramf = new aaq();
                    paramf.ieg.iei = true;
                    paramf.publish();
                    if ((!Util.isNullOrNil(this.roomId)) && (this.roomId.equals(paramf.ieh.iek)))
                    {
                      bool1 = true;
                      label2542:
                      if (!bool1) {
                        break label2627;
                      }
                      Log.d("MicroMsg.ChatroomInfoUI", " quit talkroom" + this.roomId);
                    }
                    while ((!this.lAh) || (this.lzy == null) || (this.lzy.bHw().size() <= 2))
                    {
                      com.tencent.mm.ui.base.k.a(getContext(), getString(a.i.gEc), "", getString(a.i.app_ok), getString(a.i.app_cancel), new DialogInterface.OnClickListener()
                      {
                        public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
                        {
                          AppMethodBeat.i(241611);
                          ChatroomInfoUI.e(ChatroomInfoUI.this, bool1);
                          AppMethodBeat.o(241611);
                        }
                      }, null, a.b.alert_btn_color_warn);
                      break;
                      bool1 = false;
                      break label2542;
                    }
                    paramf = getString(a.i.lIE);
                    ??? = new k.d()
                    {
                      public final void qz(int paramAnonymousInt)
                      {
                        AppMethodBeat.i(241612);
                        ChatroomInfoUI.b(ChatroomInfoUI.this, paramAnonymousInt);
                        AppMethodBeat.o(241612);
                      }
                    };
                    com.tencent.mm.ui.base.k.a(this, "", new String[] { paramf }, "", ???);
                  }
                }
                else if (paramf.equals("add_selector_btn"))
                {
                  aMz();
                }
                else if (paramf.equals("del_selector_btn"))
                {
                  aMA();
                }
                else
                {
                  if (paramf.equals("see_room_member"))
                  {
                    paramf = new Intent();
                    paramf.setClass(getContext(), SeeRoomMemberUI.class);
                    paramf.putExtra("Block_list", z.bAM());
                    ??? = v.Il(this.roomId);
                    if (??? != null) {
                      this.lAi = ???.size();
                    }
                    paramf.putExtra("Chatroom_member_list", Util.listToString(???, ","));
                    paramf.putExtra("RoomInfo_Id", this.roomId);
                    paramf.putExtra("room_owner_name", this.lzy.field_roomowner);
                    paramf.putExtra("Is_RoomOwner", this.lAh);
                    paramf.putExtra("room_member_count", this.lAi);
                    paramf.putExtra("Add_address_titile", getString(a.i.lIO));
                    if (this.hQu)
                    {
                      paramf.putExtra("Contact_Scene", 14);
                      ??? = getListView().getChildAt(0);
                      if (??? != null) {
                        break label3000;
                      }
                    }
                    for (i = 0;; i = -???.getTop())
                    {
                      paramf.putExtra("offset", i);
                      paramf.putExtra("first_pos", getListView().getFirstVisiblePosition());
                      paramf.putExtra("room_name", this.contact.field_username);
                      startActivityForResult(paramf, 5);
                      this.lAs = 5;
                      break;
                      if (!this.lzS) {
                        break label2890;
                      }
                      paramf.putExtra("Contact_Scene", 44);
                      if (z.Iy(this.contact.field_username)) {
                        break label2890;
                      }
                      paramf.putExtra("Contact_IsLBSFriend", true);
                      break label2890;
                    }
                  }
                  if (paramf.equals("manage_room"))
                  {
                    if (this.lAq) {
                      com.tencent.mm.plugin.newtips.a.gtf().aeI(26);
                    }
                    paramf = new Intent();
                    paramf.setClass(getContext(), ManageChatroomUI.class);
                    paramf.putExtra("RoomInfo_Id", this.roomId);
                    paramf.putExtra("room_owner_name", this.lzy.field_roomowner);
                    startActivityForResult(paramf, 10);
                  }
                  else if (paramf.equals("chat_room_app_brand"))
                  {
                    if (com.tencent.mm.storage.au.bwF(this.roomId))
                    {
                      paramf = new lf();
                      paramf.uc(this.roomId);
                      paramf.iuA = 7L;
                      paramf.bMH();
                    }
                    paramf = new Intent();
                    paramf.putExtra("Chat_User", this.roomId);
                    com.tencent.mm.br.c.g(this, ".ui.chatting.gallery.AppBrandHistoryListUI", paramf);
                    com.tencent.mm.plugin.report.service.h.OAn.idkeyStat(219L, 25L, 1L, true);
                  }
                  else if (paramf.equals("room_manager_view"))
                  {
                    paramf = new Intent();
                    paramf.setClass(getContext(), SeeRoomOwnerManagerUI.class);
                    paramf.putExtra("RoomInfo_Id", this.roomId);
                    paramf.putExtra("room_owner_name", this.lzy.field_roomowner);
                    paramf = new com.tencent.mm.hellhoundlib.b.a().cG(paramf);
                    com.tencent.mm.hellhoundlib.a.a.b(this, paramf.aYi(), "com/tencent/mm/chatroom/ui/ChatroomInfoUI", "goToOwnerManageChatroomUI", "()V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
                    startActivity((Intent)paramf.sb(0));
                    com.tencent.mm.hellhoundlib.a.a.c(this, "com/tencent/mm/chatroom/ui/ChatroomInfoUI", "goToOwnerManageChatroomUI", "()V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
                  }
                  else if (!paramf.equals("chat_room_story_videos"))
                  {
                    if (paramf.equals("room_remark"))
                    {
                      paramf = new Intent();
                      paramf.setClass(this, ModRemarkRoomNameUI.class);
                      paramf.putExtra("Key_Scenen", 2);
                      paramf.putExtra("Key_Room_Id", this.roomId);
                      paramf = new com.tencent.mm.hellhoundlib.b.a().cG(paramf);
                      com.tencent.mm.hellhoundlib.a.a.b(this, paramf.aYi(), "com/tencent/mm/chatroom/ui/ChatroomInfoUI", "dealModChatroomRemark", "()V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
                      startActivity((Intent)paramf.sb(0));
                      com.tencent.mm.hellhoundlib.a.a.c(this, "com/tencent/mm/chatroom/ui/ChatroomInfoUI", "dealModChatroomRemark", "()V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
                    }
                    else if (paramf.equals("room_special_follow_member"))
                    {
                      paramf = new Intent();
                      paramf.setClass(this, RoomSpecialFollowMemberManagerUI.class);
                      paramf.putExtra("Key_Scenen", 2);
                      paramf.putExtra("RoomInfo_Id", this.roomId);
                      paramf = new com.tencent.mm.hellhoundlib.b.a().cG(paramf);
                      com.tencent.mm.hellhoundlib.a.a.b(this, paramf.aYi(), "com/tencent/mm/chatroom/ui/ChatroomInfoUI", "dealToSpecialFollowMemberUI", "()V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
                      startActivity((Intent)paramf.sb(0));
                      com.tencent.mm.hellhoundlib.a.a.c(this, "com/tencent/mm/chatroom/ui/ChatroomInfoUI", "dealToSpecialFollowMemberUI", "()V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
                      paramf = new com.tencent.mm.autogen.mmdata.rpt.au();
                      paramf.ipB = 2;
                      paramf.kI(this.roomId);
                      paramf.bMH();
                    }
                  }
                }
              }
            }
          }
        }
      }
    }
  }
  
  public void onResume()
  {
    AppMethodBeat.i(12564);
    super.onResume();
    this.screen.notifyDataSetChanged();
    boolean bool;
    if ((this.lzy != null) && (this.lzy.iZo() != null))
    {
      bool = v.Iq(this.lzy.field_chatroomname);
      Log.i("MicroMsg.ChatroomInfoUI", "roomId:%s newVer:%s localVer:%s owner:%s", new Object[] { this.lzy.field_chatroomname, Integer.valueOf(this.lzy.field_chatroomVersion), Integer.valueOf(this.lzy.field_oldChatroomVersion), this.lzy.field_roomowner });
    }
    for (;;)
    {
      if ((v.Ig(this.roomId)) || (bool)) {
        aMs();
      }
      aMo();
      aMl();
      aMp();
      Object localObject2;
      Object localObject1;
      if (this.hQu)
      {
        aMn();
        if (this.contact != null)
        {
          this.lzy = ((com.tencent.mm.plugin.chatroom.a.b)com.tencent.mm.kernel.h.ax(com.tencent.mm.plugin.chatroom.a.b.class)).bzK().Ju(this.roomId);
          if (this.lzy != null) {
            break label511;
          }
          localObject2 = "";
          localObject1 = localObject2;
          if (Util.isNullOrNil((String)localObject2)) {
            localObject1 = z.bAO();
          }
          if (Util.isNullOrNil((String)localObject1)) {
            break label522;
          }
          this.lAc.jnp();
          this.lAc.adZj = com.tencent.mm.cd.a.br(getContext(), a.c.lEb);
          KeyValuePreference localKeyValuePreference = this.lAc;
          localObject2 = localObject1;
          if (((String)localObject1).length() <= 0) {
            localObject2 = getString(a.i.settings_signature_empty);
          }
          localKeyValuePreference.aS(com.tencent.mm.pluginsdk.ui.span.p.b(this, (CharSequence)localObject2));
          label268:
          if (this.screen != null) {
            this.screen.notifyDataSetChanged();
          }
        }
        if ((this.contact != null) && (this.lAd != null))
        {
          this.contact = ((com.tencent.mm.plugin.messenger.foundation.a.n)com.tencent.mm.kernel.h.ax(com.tencent.mm.plugin.messenger.foundation.a.n.class)).bzA().JE(this.roomId);
          this.lAd.jnp();
          if (!com.tencent.mm.storage.au.bwP(this.roomId)) {
            break label534;
          }
          this.screen.e(this.lAd);
        }
      }
      for (;;)
      {
        if (this.lAm)
        {
          aMm();
          this.lAm = false;
        }
        localObject1 = getIntent().getStringExtra("need_matte_high_light_item");
        if (!this.lAt)
        {
          if (!Util.isNullOrNil((String)localObject1)) {
            De((String)localObject1);
          }
          this.lAt = true;
        }
        if ((!Util.isNullOrNil((String)localObject1)) && (((String)localObject1).equals("room_notify_new_notice")) && (!this.lAt))
        {
          De("room_card");
          this.lAt = true;
        }
        com.tencent.mm.plugin.newtips.a.gtf().aeH(26);
        Log.d("MicroMsg.ChatroomInfoUI", "showSetMuteAnimation isShowSetMuteAnimation[%b]", new Object[] { Boolean.valueOf(this.lAo) });
        if (this.lAo)
        {
          this.lAo = false;
          MMHandlerThread.postToMainThreadDelayed(new Runnable()
          {
            public final void run()
            {
              AppMethodBeat.i(241671);
              ChatroomInfoUI.b(ChatroomInfoUI.this, "room_notify_new_msg");
              ChatroomInfoUI.E(ChatroomInfoUI.this);
              AppMethodBeat.o(241671);
            }
          }, 50L);
        }
        aME();
        AppMethodBeat.o(12564);
        return;
        label511:
        localObject2 = this.lzy.field_selfDisplayName;
        break;
        label522:
        this.lAc.aS("");
        break label268;
        label534:
        if (!Util.isNullOrNil(this.contact.field_conRemark))
        {
          localObject1 = this.contact.field_conRemark;
          this.lAd.aS(com.tencent.mm.pluginsdk.ui.span.p.b(this, (CharSequence)localObject1));
          if (this.screen != null) {
            this.screen.notifyDataSetChanged();
          }
        }
        else
        {
          this.lAd.aS("");
        }
      }
      bool = false;
    }
  }
  
  public void onSceneEnd(int paramInt1, int paramInt2, String paramString, com.tencent.mm.am.p paramp)
  {
    AppMethodBeat.i(12594);
    Log.i("MicroMsg.ChatroomInfoUI", "onSceneEnd: errType = " + paramInt1 + " errCode = " + paramInt2 + " errMsg = " + paramString + " type = " + paramp.getType());
    Log.d("MicroMsg.ChatroomInfoUI", "pre is " + this.lAi);
    this.lAi = v.getMembersCountByChatRoomName(this.roomId);
    Log.d("MicroMsg.ChatroomInfoUI", "now is " + this.lAi);
    if (this.lzP != null) {
      this.lzP.dismiss();
    }
    AppMethodBeat.o(12594);
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
  
  public void superImportUIComponents(HashSet<Class<? extends UIComponent>> paramHashSet)
  {
    AppMethodBeat.i(241856);
    super.superImportUIComponents(paramHashSet);
    paramHashSet.add(com.tencent.mm.chatroom.ui.a.a.class);
    AppMethodBeat.o(241856);
  }
  
  public static class LocalHistoryInfo
    implements Parcelable
  {
    public static final Parcelable.Creator<LocalHistoryInfo> CREATOR;
    public String aeskey;
    public String fileid;
    public String filemd5;
    public int lAT;
    public int lAU;
    public String lAV;
    public String lAW;
    public String lAX;
    public int lAY;
    public int lAZ;
    
    static
    {
      AppMethodBeat.i(241830);
      CREATOR = new Parcelable.Creator() {};
      AppMethodBeat.o(241830);
    }
    
    public LocalHistoryInfo() {}
    
    protected LocalHistoryInfo(Parcel paramParcel)
    {
      AppMethodBeat.i(241829);
      this.fileid = paramParcel.readString();
      this.aeskey = paramParcel.readString();
      this.filemd5 = paramParcel.readString();
      this.lAT = paramParcel.readInt();
      this.lAU = paramParcel.readInt();
      this.lAV = paramParcel.readString();
      this.lAW = paramParcel.readString();
      this.lAX = paramParcel.readString();
      this.lAY = paramParcel.readInt();
      this.lAZ = paramParcel.readInt();
      AppMethodBeat.o(241829);
    }
    
    public int describeContents()
    {
      return 0;
    }
    
    public String toString()
    {
      AppMethodBeat.i(241833);
      String str = "LocalHistoryInfo{fileid='" + this.fileid + '\'' + ", aeskey='" + this.aeskey + '\'' + ", filemd5='" + this.filemd5 + '\'' + ", filelength=" + this.lAT + ", msgsount=" + this.lAU + ", newFormatFileid='" + this.lAV + '\'' + ", newFormatAeskey='" + this.lAW + '\'' + ", newFormatFilemd5='" + this.lAX + '\'' + ", newFormatFilelength=" + this.lAY + ", newFormatMsgsount=" + this.lAZ + '}';
      AppMethodBeat.o(241833);
      return str;
    }
    
    public void writeToParcel(Parcel paramParcel, int paramInt)
    {
      AppMethodBeat.i(241837);
      paramParcel.writeString(this.fileid);
      paramParcel.writeString(this.aeskey);
      paramParcel.writeString(this.filemd5);
      paramParcel.writeInt(this.lAT);
      paramParcel.writeInt(this.lAU);
      paramParcel.writeString(this.lAV);
      paramParcel.writeString(this.lAW);
      paramParcel.writeString(this.lAX);
      paramParcel.writeInt(this.lAY);
      paramParcel.writeInt(this.lAZ);
      AppMethodBeat.o(241837);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.chatroom.ui.ChatroomInfoUI
 * JD-Core Version:    0.7.0.1
 */