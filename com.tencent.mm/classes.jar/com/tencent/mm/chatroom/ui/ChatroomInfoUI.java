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
import com.tencent.mm.an.t;
import com.tencent.mm.chatroom.ui.preference.RoomCardPreference;
import com.tencent.mm.f.a.nz;
import com.tencent.mm.f.a.nz.b;
import com.tencent.mm.f.a.vm;
import com.tencent.mm.f.a.yx;
import com.tencent.mm.f.a.yx.b;
import com.tencent.mm.f.a.zy;
import com.tencent.mm.f.b.a.iv;
import com.tencent.mm.f.b.a.nf;
import com.tencent.mm.f.c.ax;
import com.tencent.mm.kernel.k;
import com.tencent.mm.model.ab;
import com.tencent.mm.model.aq;
import com.tencent.mm.model.az.a;
import com.tencent.mm.model.az.b;
import com.tencent.mm.model.az.b.a;
import com.tencent.mm.model.bq.a;
import com.tencent.mm.model.v;
import com.tencent.mm.model.z;
import com.tencent.mm.plugin.messenger.foundation.a.y;
import com.tencent.mm.plugin.newtips.NewTipPreference;
import com.tencent.mm.plugin.report.kvdata.IMBehavior;
import com.tencent.mm.plugin.report.kvdata.IMBehaviorChattingOP;
import com.tencent.mm.plugin.report.kvdata.log_13835;
import com.tencent.mm.pluginsdk.ui.applet.ContactListExpandPreference;
import com.tencent.mm.pluginsdk.ui.applet.ContactListExpandPreference.a;
import com.tencent.mm.pluginsdk.ui.applet.r;
import com.tencent.mm.pluginsdk.ui.applet.s.b;
import com.tencent.mm.pluginsdk.ui.e;
import com.tencent.mm.pluginsdk.ui.span.l;
import com.tencent.mm.protocal.protobuf.cqk;
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
import com.tencent.mm.storage.co;
import com.tencent.mm.ui.base.h.d;
import com.tencent.mm.ui.base.preference.CheckBoxPreference;
import com.tencent.mm.ui.base.preference.KeyValuePreference;
import com.tencent.mm.ui.base.preference.MMPreference;
import com.tencent.mm.ui.base.preference.NormalIconPreference;
import com.tencent.mm.ui.base.preference.Preference;
import com.tencent.mm.ui.base.preference.PreferenceCategory;
import com.tencent.mm.ui.base.s;
import com.tencent.mm.ui.contact.w;
import com.tencent.mm.ui.f.e;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import junit.framework.Assert;

@k
public class ChatroomInfoUI
  extends MMPreference
  implements com.tencent.mm.an.i, com.tencent.mm.bj.a, com.tencent.mm.chatroom.g.a.b, MStorage.IOnStorageChange, MStorageEx.IOnStorageChange
{
  private static boolean iYG = false;
  private as contact;
  private boolean fKN;
  private MMHandler handler;
  private ProgressDialog iXX;
  private ProgressDialog iXY;
  private boolean iXZ;
  private ah iXp;
  private e iYA;
  boolean iYB;
  private IListener iYC;
  int iYD;
  private s iYE;
  private String iYF;
  private com.tencent.mm.roomsdk.a.c.a iYH;
  private String iYI;
  private com.tencent.mm.pluginsdk.d.b iYJ;
  private MTimerHandler iYK;
  private int iYL;
  private RoomCardPreference iYa;
  private Preference iYb;
  private Preference iYc;
  private NormalIconPreference iYd;
  private NormalIconPreference iYe;
  private ContactListExpandPreference iYf;
  private CheckBoxPreference iYg;
  private CheckBoxPreference iYh;
  private CheckBoxPreference iYi;
  private KeyValuePreference iYj;
  private KeyValuePreference iYk;
  private CheckBoxPreference iYl;
  private NewTipPreference iYm;
  private boolean iYn;
  private boolean iYo;
  private boolean iYp;
  private boolean iYq;
  private int iYr;
  private boolean iYs;
  private boolean iYt;
  private int iYu;
  private boolean iYv;
  private boolean iYw;
  private boolean iYx;
  private boolean iYy;
  private boolean iYz;
  private boolean isDeleteCancel;
  private String roomId;
  private com.tencent.mm.ui.base.preference.f screen;
  private SharedPreferences sp;
  
  public ChatroomInfoUI()
  {
    AppMethodBeat.i(12561);
    this.iXX = null;
    this.iXY = null;
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
    this.iYp = false;
    this.iYq = false;
    this.iYt = false;
    this.iXp = null;
    this.iYu = -1;
    this.iYv = true;
    this.iYw = false;
    this.iYx = false;
    this.iYy = false;
    this.iYz = false;
    this.iYA = new e(new AbsListView.OnScrollListener()
    {
      public final void onScroll(AbsListView paramAnonymousAbsListView, int paramAnonymousInt1, int paramAnonymousInt2, int paramAnonymousInt3) {}
      
      public final void onScrollStateChanged(AbsListView paramAnonymousAbsListView, int paramAnonymousInt) {}
    });
    this.iYB = false;
    this.iYC = new ChatroomInfoUI.30(this);
    this.iYD = -1;
    this.iYE = null;
    this.iYF = "";
    this.iYH = null;
    this.iYI = null;
    this.iYJ = new com.tencent.mm.pluginsdk.d.b()
    {
      public final void a(int paramAnonymousInt1, int paramAnonymousInt2, String paramAnonymousString, IEvent paramAnonymousIEvent)
      {
        AppMethodBeat.i(194032);
        if ((paramAnonymousIEvent instanceof nz))
        {
          paramAnonymousIEvent = (nz)paramAnonymousIEvent;
          Log.i("MicroMsg.ChatroomInfoUI", "onSceneEnd: errType = " + paramAnonymousInt1 + " errCode = " + paramAnonymousInt2 + " errMsg = " + paramAnonymousString);
          if (ChatroomInfoUI.z(ChatroomInfoUI.this) != null) {
            ChatroomInfoUI.z(ChatroomInfoUI.this).dismiss();
          }
          if ((paramAnonymousInt1 != 0) || (paramAnonymousInt2 != 0))
          {
            if (paramAnonymousInt2 == -21)
            {
              com.tencent.mm.ui.base.h.d(ChatroomInfoUI.this, ChatroomInfoUI.this.getString(a.i.jgc), ChatroomInfoUI.this.getString(a.i.app_tip), new DialogInterface.OnClickListener()
              {
                public final void onClick(DialogInterface paramAnonymous2DialogInterface, int paramAnonymous2Int)
                {
                  AppMethodBeat.i(188258);
                  ChatroomInfoUI.this.finish();
                  AppMethodBeat.o(188258);
                }
              });
              AppMethodBeat.o(194032);
              return;
            }
            com.tencent.mm.ui.base.h.c(ChatroomInfoUI.this, ChatroomInfoUI.this.getString(a.i.jge), ChatroomInfoUI.this.getString(a.i.app_tip), true);
            AppMethodBeat.o(194032);
            return;
          }
          if ((paramAnonymousInt1 == 0) && (paramAnonymousInt2 == 0) && (ChatroomInfoUI.m(ChatroomInfoUI.this) != null))
          {
            paramAnonymousString = ChatroomInfoUI.U(paramAnonymousIEvent.fMN.fMA);
            paramAnonymousIEvent = ChatroomInfoUI.m(ChatroomInfoUI.this);
            if (paramAnonymousIEvent.RgM != null)
            {
              paramAnonymousIEvent = paramAnonymousIEvent.RgM.Rgc;
              paramAnonymousIEvent.bw(paramAnonymousString);
              paramAnonymousIEvent.ata();
            }
            if (ChatroomInfoUI.f(ChatroomInfoUI.this) != null) {
              ChatroomInfoUI.f(ChatroomInfoUI.this).notifyDataSetChanged();
            }
            ChatroomInfoUI.this.setMMTitle(ChatroomInfoUI.this.getResources().getQuantityString(a.g.jev, paramAnonymousString.size(), new Object[] { Integer.valueOf(paramAnonymousString.size()) }));
          }
          ChatroomInfoUI.j(ChatroomInfoUI.this);
        }
        AppMethodBeat.o(194032);
      }
    };
    this.isDeleteCancel = false;
    this.iYK = null;
    this.iYL = 0;
    AppMethodBeat.o(12561);
  }
  
  private void Kw(String paramString)
  {
    AppMethodBeat.i(12566);
    final int i = this.screen.byJ(paramString);
    paramString = getListView();
    com.tencent.mm.hellhoundlib.b.a locala = com.tencent.mm.hellhoundlib.b.c.a(i, new com.tencent.mm.hellhoundlib.b.a());
    com.tencent.mm.hellhoundlib.a.a.b(paramString, locala.aFh(), "com/tencent/mm/chatroom/ui/ChatroomInfoUI", "MatteHighLightItem", "(Ljava/lang/String;)V", "Undefined", "smoothScrollToPosition", "(I)V");
    paramString.smoothScrollToPosition(((Integer)locala.sf(0)).intValue());
    com.tencent.mm.hellhoundlib.a.a.c(paramString, "com/tencent/mm/chatroom/ui/ChatroomInfoUI", "MatteHighLightItem", "(Ljava/lang/String;)V", "Undefined", "smoothScrollToPosition", "(I)V");
    new MMHandler().postDelayed(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(12558);
        View localView = ((com.tencent.mm.ui.base.preference.a)ChatroomInfoUI.f(ChatroomInfoUI.this)).a(i, ChatroomInfoUI.this.getListView());
        if (localView != null) {
          com.tencent.mm.ui.j.a.c(ChatroomInfoUI.this.getContext(), localView);
        }
        AppMethodBeat.o(12558);
      }
    }, 10L);
    AppMethodBeat.o(12566);
  }
  
  private String Ky(String paramString)
  {
    AppMethodBeat.i(12578);
    if (this.iXp == null)
    {
      AppMethodBeat.o(12578);
      return null;
    }
    paramString = this.iXp.PJ(paramString);
    AppMethodBeat.o(12578);
    return paramString;
  }
  
  public static ArrayList<as> U(List<cqk> paramList)
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
      cqk localcqk = (cqk)paramList.next();
      as localas = new as();
      localas.setUsername(localcqk.UserName);
      localas.setNickname(localcqk.rWI);
      localArrayList.add(localas);
    }
    AppMethodBeat.o(12590);
    return localArrayList;
  }
  
  private void asA()
  {
    AppMethodBeat.i(12587);
    Object localObject;
    RoomCardPreference localRoomCardPreference;
    if ((this.contact != null) && (this.iYa != null))
    {
      localObject = v.Pw(this.roomId);
      if ((localObject != null) && (((String)localObject).length() > 0)) {
        break label136;
      }
      this.iYa.fxt = false;
      this.contact = ((com.tencent.mm.plugin.messenger.foundation.a.n)com.tencent.mm.kernel.h.ae(com.tencent.mm.plugin.messenger.foundation.a.n.class)).bbL().RG(this.roomId);
      if (!asC()) {
        break label159;
      }
      String str = this.contact.ays();
      localRoomCardPreference = this.iYa;
      localObject = str;
      if (str.length() <= 0) {
        localObject = getString(a.i.settings_signature_empty);
      }
    }
    label136:
    label159:
    for (localRoomCardPreference.jml = l.c(this, (CharSequence)localObject);; this.iYa.jml = getString(a.i.eRg))
    {
      this.screen.notifyDataSetChanged();
      AppMethodBeat.o(12587);
      return;
      this.iYa.fxt = true;
      this.iYa.jmm = l.c(this, (CharSequence)localObject);
      break;
    }
  }
  
  private void asB()
  {
    AppMethodBeat.i(12588);
    if ((this.contact != null) && (this.iYb != null))
    {
      this.contact = ((com.tencent.mm.plugin.messenger.foundation.a.n)com.tencent.mm.kernel.h.ae(com.tencent.mm.plugin.messenger.foundation.a.n.class)).bbL().RG(this.roomId);
      if (asC())
      {
        String str2 = this.contact.ayr();
        Preference localPreference = this.iYb;
        String str1 = str2;
        if (str2.length() <= 0) {
          str1 = getString(a.i.settings_signature_empty);
        }
        localPreference.aF(l.c(this, str1));
        if (this.screen != null) {
          this.screen.notifyDataSetChanged();
        }
        AppMethodBeat.o(12588);
        return;
      }
      this.iYb.aF(getString(a.i.eRg));
    }
    AppMethodBeat.o(12588);
  }
  
  private boolean asC()
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
  
  private void asD()
  {
    AppMethodBeat.i(12591);
    com.tencent.mm.plugin.report.service.h.IzE.kvStat(10170, "1");
    Object localObject = new LinkedList();
    ((List)localObject).add(this.roomId);
    ((List)localObject).add(z.bcZ());
    localObject = Util.listToString((List)localObject, ",");
    Intent localIntent = new Intent();
    localIntent.putExtra("titile", getString(a.i.address_title_launch_chatting));
    localIntent.putExtra("list_type", 0);
    localIntent.putExtra("list_attr", qu(w.XtM));
    localIntent.putExtra("always_select_contact", (String)localObject);
    localIntent.putExtra("create_group_recommend", true);
    com.tencent.mm.by.c.f(this, ".ui.contact.SelectContactUI", localIntent);
    AppMethodBeat.o(12591);
  }
  
  private boolean asE()
  {
    AppMethodBeat.i(12600);
    if ((this.iXp != null) && (this.iXp.asE()))
    {
      AppMethodBeat.o(12600);
      return true;
    }
    AppMethodBeat.o(12600);
    return false;
  }
  
  private void asr()
  {
    AppMethodBeat.i(12563);
    Log.i("MicroMsg.ChatroomInfoUI", "[doChatroomDetailCgi] :%s", new Object[] { this.roomId });
    com.tencent.mm.roomsdk.a.c.a locala = com.tencent.mm.roomsdk.a.b.btX(this.roomId).Kk(this.roomId);
    locala.b(new com.tencent.mm.roomsdk.a.b.b() {});
    locala.aRu();
    AppMethodBeat.o(12563);
  }
  
  private void ass()
  {
    AppMethodBeat.i(194274);
    if (this.iXY == null)
    {
      getString(a.i.app_tip);
      this.iXY = com.tencent.mm.ui.base.h.a(this, getString(a.i.app_waiting), false, new DialogInterface.OnCancelListener()
      {
        public final void onCancel(DialogInterface paramAnonymousDialogInterface)
        {
          AppMethodBeat.i(186730);
          ChatroomInfoUI.a(ChatroomInfoUI.this, true);
          AppMethodBeat.o(186730);
        }
      });
      AppMethodBeat.o(194274);
      return;
    }
    this.iXY.show();
    AppMethodBeat.o(194274);
  }
  
  private void ast()
  {
    AppMethodBeat.i(194275);
    if (this.iXY != null) {
      this.iXY.dismiss();
    }
    AppMethodBeat.o(194275);
  }
  
  private void asu()
  {
    AppMethodBeat.i(12573);
    com.tencent.mm.plugin.report.service.h.IzE.idkeyStat(219L, 7L, 1L, true);
    Object localObject = v.Ps(this.roomId);
    String str = Util.listToString((List)localObject, ",");
    if (localObject != null) {
      this.iYr = ((List)localObject).size();
    }
    localObject = new Intent();
    ((Intent)localObject).putExtra("titile", getString(a.i.address_title_select_contact));
    ((Intent)localObject).putExtra("list_type", 1);
    ((Intent)localObject).putExtra("list_attr", qu(w.XtL));
    ((Intent)localObject).putExtra("always_select_contact", str);
    ((Intent)localObject).putExtra("scene", 3);
    boolean bool = ab.PT(this.contact.field_username);
    if ((!as.bvL(this.contact.field_username)) && (!bool)) {
      ((Intent)localObject).putExtra("without_openim", true);
    }
    if ((ab.PP(this.roomId)) && (!bool)) {}
    for (bool = true;; bool = false)
    {
      ((Intent)localObject).putExtra("KBlockOpenImFav", bool);
      ((Intent)localObject).putExtra("create_group_recommend", true);
      ((Intent)localObject).putExtra("is_select_record_msg_mode", ab.PP(this.roomId));
      ((Intent)localObject).putExtra("menu_mode", 2);
      ((Intent)localObject).putExtra("chatroomName", this.roomId);
      com.tencent.mm.by.c.d(this, ".ui.contact.SelectContactUI", (Intent)localObject, 1);
      AppMethodBeat.o(12573);
      return;
    }
  }
  
  private void asv()
  {
    AppMethodBeat.i(12574);
    if (this.fKN)
    {
      asu();
      AppMethodBeat.o(12574);
      return;
    }
    asD();
    AppMethodBeat.o(12574);
  }
  
  private void asw()
  {
    AppMethodBeat.i(12576);
    com.tencent.mm.plugin.report.service.h.IzE.idkeyStat(219L, 8L, 1L, true);
    Object localObject = v.Ps(this.roomId);
    String str = Util.listToString((List)localObject, ",");
    this.iYr = ((List)localObject).size();
    localObject = new Intent();
    ((Intent)localObject).putExtra("RoomInfo_Id", this.roomId);
    ((Intent)localObject).putExtra("Is_Chatroom", true);
    ((Intent)localObject).putExtra("Chatroom_member_list", str);
    ((Intent)localObject).putExtra("room_member_count", this.iYr);
    ((Intent)localObject).putExtra("Is_RoomOwner", this.iYp);
    ((Intent)localObject).putExtra("list_attr", w.XtL);
    ((Intent)localObject).putExtra("room_name", this.contact.field_username);
    ((Intent)localObject).putExtra("room_owner_name", this.iXp.field_roomowner);
    ((Intent)localObject).setClass(this, SelectDelMemberUI.class);
    startActivityForResult((Intent)localObject, 7);
    AppMethodBeat.o(12576);
  }
  
  private String asx()
  {
    AppMethodBeat.i(12579);
    as localas = ((com.tencent.mm.plugin.messenger.foundation.a.n)com.tencent.mm.kernel.h.ae(com.tencent.mm.plugin.messenger.foundation.a.n.class)).bbL().RG(this.iXp.field_roomowner);
    if ((localas != null) && ((int)localas.jxt > 0)) {}
    for (Object localObject2 = localas.field_conRemark;; localObject2 = null)
    {
      Object localObject1 = localObject2;
      if (Util.isNullOrNil((String)localObject2)) {
        localObject1 = Ky(this.iXp.field_roomowner);
      }
      localObject2 = localObject1;
      if (Util.isNullOrNil((String)localObject1))
      {
        localObject2 = localObject1;
        if (localas != null)
        {
          localObject2 = localObject1;
          if ((int)localas.jxt > 0) {
            localObject2 = localas.ayr();
          }
        }
      }
      localObject1 = localObject2;
      if (Util.isNullOrNil((String)localObject2)) {
        localObject1 = this.iXp.field_roomowner;
      }
      AppMethodBeat.o(12579);
      return localObject1;
    }
  }
  
  private void asy()
  {
    AppMethodBeat.i(12584);
    if (this.iYf != null)
    {
      if (this.fKN)
      {
        com.tencent.e.h.ZvG.be(new Runnable()
        {
          public final void run()
          {
            AppMethodBeat.i(192405);
            if (ChatroomInfoUI.c(ChatroomInfoUI.this) == null)
            {
              Log.w("MicroMsg.ChatroomInfoUI", "[updateRoomPref] member == null");
              AppMethodBeat.o(192405);
              return;
            }
            ChatroomInfoUI.a(ChatroomInfoUI.this, ((com.tencent.mm.plugin.chatroom.a.b)com.tencent.mm.kernel.h.ae(com.tencent.mm.plugin.chatroom.a.b.class)).bbV().Rz(ChatroomInfoUI.b(ChatroomInfoUI.this)));
            Object localObject1 = v.Ps(ChatroomInfoUI.b(ChatroomInfoUI.this));
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
                if ((ChatroomInfoUI.c(ChatroomInfoUI.this).bvA(str)) || (ChatroomInfoUI.c(ChatroomInfoUI.this).Rh(str))) {
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
            com.tencent.e.h.ZvG.bc(new Runnable()
            {
              public final void run()
              {
                AppMethodBeat.i(186526);
                if (ChatroomInfoUI.e(ChatroomInfoUI.this) <= 1)
                {
                  ChatroomInfoUI.f(ChatroomInfoUI.this).dz("del_selector_btn", true);
                  ChatroomInfoUI.m(ChatroomInfoUI.this).DZ(true).Ea(false).hkF();
                }
                for (;;)
                {
                  ChatroomInfoUI.m(ChatroomInfoUI.this).s(ChatroomInfoUI.b(ChatroomInfoUI.this), this.iYV);
                  ChatroomInfoUI.m(ChatroomInfoUI.this).DY(true);
                  AppMethodBeat.o(186526);
                  return;
                  ChatroomInfoUI.m(ChatroomInfoUI.this).DZ(true).Ea(ChatroomInfoUI.d(ChatroomInfoUI.this)).hkF();
                }
              }
            });
            AppMethodBeat.o(192405);
          }
        });
        AppMethodBeat.o(12584);
        return;
      }
      LinkedList localLinkedList = new LinkedList();
      localLinkedList.add(this.roomId);
      this.iYf.s(this.roomId, localLinkedList);
    }
    AppMethodBeat.o(12584);
  }
  
  private void asz()
  {
    AppMethodBeat.i(12586);
    if (this.sp == null) {
      this.sp = getSharedPreferences(getPackageName() + "_preferences", 0);
    }
    boolean bool;
    if (this.contact != null)
    {
      if (!this.fKN) {
        break label140;
      }
      if (this.contact.hDj == 0)
      {
        bool = true;
        this.iYs = bool;
      }
    }
    else
    {
      label76:
      if (!this.iYs) {
        break label161;
      }
      setTitleMuteIconVisibility(0);
      if (this.iYg != null) {
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
      if (this.iXZ) {
        break label76;
      }
      this.iYs = this.contact.aeg();
      break label76;
      label161:
      setTitleMuteIconVisibility(8);
      if (this.iYg != null) {
        this.sp.edit().putBoolean("room_notify_new_msg", false).commit();
      }
    }
  }
  
  private int qu(int paramInt)
  {
    AppMethodBeat.i(12575);
    if (!w.hVj())
    {
      AppMethodBeat.o(12575);
      return paramInt;
    }
    if (this.contact != null)
    {
      String str = this.contact.field_username;
      if ((as.bvK(str)) || (as.bvL(str)) || (ab.PT(str)))
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
    if (this.fKN)
    {
      this.iYr = v.Pu(this.roomId);
      if (this.iYr == 0)
      {
        setMMTitle(getString(a.i.eRt));
        AppMethodBeat.o(12583);
        return;
      }
      setMMTitle(getString(a.i.eFv, new Object[] { getString(a.i.eRt), Integer.valueOf(this.iYr) }));
    }
    AppMethodBeat.o(12583);
  }
  
  public final void Kx(String paramString)
  {
    AppMethodBeat.i(194279);
    Log.i("MicroMsg.ChatroomInfoUI", "delete chatroom %s", new Object[] { paramString });
    this.iYH = com.tencent.mm.roomsdk.a.b.btX(paramString).Kl(paramString);
    this.iYH.d(new ChatroomInfoUI.15(this, paramString)).aRu();
    AppMethodBeat.o(194279);
  }
  
  public final void asj()
  {
    AppMethodBeat.i(194326);
    boolean bool;
    Object localObject;
    if (this.iYf != null)
    {
      if (this.fKN)
      {
        asy();
        this.iYf.notifyChanged();
      }
    }
    else
    {
      bool = ((com.tencent.mm.plugin.chatroom.a.b)com.tencent.mm.kernel.h.ae(com.tencent.mm.plugin.chatroom.a.b.class)).asl(this.roomId);
      if (asE()) {
        break label243;
      }
      this.screen.dz("manage_room", true);
      localObject = this.screen;
      if (bool) {
        break label238;
      }
      bool = true;
      label82:
      ((com.tencent.mm.ui.base.preference.f)localObject).dz("room_manager_view", bool);
      label93:
      if (((asE()) || (this.iYr < r.MAX_COUNT)) && ((!asE()) || (this.iYr < r.MAX_COUNT - 1))) {
        break label274;
      }
      this.screen.dz("see_room_member", false);
      this.iYc.setTitle(getString(a.i.jgZ));
    }
    for (;;)
    {
      if (ab.PQ(this.roomId)) {
        this.screen.dz("room_manager_view", true);
      }
      this.screen.notifyDataSetChanged();
      AppMethodBeat.o(194326);
      return;
      if (this.iXZ) {
        break;
      }
      localObject = new LinkedList();
      ((List)localObject).add(this.roomId);
      this.iYf.s(this.roomId, (List)localObject);
      break;
      label238:
      bool = false;
      break label82;
      label243:
      this.screen.dz("room_manager_view", true);
      this.screen.dz("manage_room", false);
      break label93;
      label274:
      this.screen.dz("see_room_member", true);
    }
  }
  
  public final void ask()
  {
    AppMethodBeat.i(194292);
    updateTitle();
    if (this.iXp != null) {
      this.iYr = this.iXp.bjL().size();
    }
    if (((!this.iYp) && (this.iYr >= r.MAX_COUNT)) || ((this.iYp) && (this.iYr >= r.MAX_COUNT - 1)))
    {
      this.screen.dz("see_room_member", false);
      this.iYc.setTitle(getString(a.i.jgZ));
    }
    AppMethodBeat.o(194292);
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
    return a.k.jhI;
  }
  
  public final void h(String paramString1, String paramString2, String paramString3)
  {
    AppMethodBeat.i(12598);
    if ((paramString1.equals(this.roomId)) && (this.iYf != null)) {
      this.iYf.notifyChanged();
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
    if (this.fKN) {
      if (this.iYr == 0)
      {
        setMMTitle(getString(a.i.eRt));
        localObject1 = null;
        if (this.iXp != null)
        {
          localObject1 = this.iXp.field_roomowner;
          this.iYr = this.iXp.bjL().size();
        }
        if (!Util.isNullOrNil((String)localObject1)) {
          break label1363;
        }
        this.iYo = false;
        this.iYp = false;
        this.iYq = false;
        Log.d("MicroMsg.ChatroomInfoUI", "initBaseChatRoomView()");
        this.iYf = ((ContactListExpandPreference)this.screen.byG("roominfo_contact_anchor"));
        this.iYf.a(this.screen, this.iYf.mKey);
        this.iYe = ((NormalIconPreference)this.screen.byG("del_selector_btn"));
        this.iYd = ((NormalIconPreference)this.screen.byG("add_selector_btn"));
        this.iYb = this.screen.byG("room_name");
        this.iYa = ((RoomCardPreference)this.screen.byG("room_card"));
        this.iYc = this.screen.byG("see_room_member");
        this.iYg = ((CheckBoxPreference)this.screen.byG("room_notify_new_msg"));
        this.iYh = ((CheckBoxPreference)this.screen.byG("room_save_to_contact"));
        this.iYi = ((CheckBoxPreference)this.screen.byG("room_placed_to_the_top"));
        this.iYj = ((KeyValuePreference)this.screen.byG("room_nickname"));
        this.iYk = ((KeyValuePreference)this.screen.byG("room_remark"));
        this.iYm = ((NewTipPreference)this.screen.byG("manage_room"));
        this.iYf.DZ(true).Ea(true).hkF();
        bool = ((com.tencent.mm.plugin.chatroom.a.b)com.tencent.mm.kernel.h.ae(com.tencent.mm.plugin.chatroom.a.b.class)).asl(this.roomId);
        if (asE()) {
          break label1388;
        }
        this.screen.dz("manage_room", true);
        localObject1 = this.screen;
        if (bool) {
          break label1383;
        }
        bool = true;
        label414:
        ((com.tencent.mm.ui.base.preference.f)localObject1).dz("room_manager_view", bool);
        label426:
        if ((ab.PP(this.roomId)) && (v.bcV()))
        {
          localObject1 = ((com.tencent.mm.plugin.chatroom.a.b)com.tencent.mm.kernel.h.ae(com.tencent.mm.plugin.chatroom.a.b.class)).bbV().Rw(this.roomId);
          if ((localObject1 != null) && ((((ah)localObject1).field_chatroomStatus & 0x20000) != 131072L) && ((((ah)localObject1).field_chatroomStatus & 0x10000) == 65536L) && (v.bcT()))
          {
            this.iYz = true;
            this.iYm.a(this.screen);
            com.tencent.mm.plugin.newtips.a.fiO().h(this.iYm);
            com.tencent.mm.plugin.newtips.a.g.a(this.iYm);
          }
        }
        if (this.iXp != null)
        {
          this.iYf.brp(this.iXp.field_roomowner);
          if (!Util.isNullOrNil(this.iXp.field_roomowner)) {
            this.iYf.RgM.Rgc.RgC = true;
          }
        }
        this.iYf.hkE();
        this.iYf.hky();
        this.screen.dz("add_selector_btn", true);
        this.screen.dz("del_selector_btn", true);
        this.screen.dz("room_name", false);
        this.screen.dz("room_qr_code", false);
        this.screen.dz("chatroom_info_chexboxes", true);
        this.screen.dz("room_card", false);
        this.screen.dz("room_upgrade_entry", true);
        this.screen.dz("chat_room_story_videos", true);
        if (((asE()) || (this.iYr < r.MAX_COUNT)) && ((!asE()) || (this.iYr < r.MAX_COUNT - 1))) {
          break label1419;
        }
        this.screen.dz("see_room_member", false);
        this.iYc.setTitle(getString(a.i.jgZ));
        label783:
        if (as.bvL(this.roomId)) {
          break label1436;
        }
        this.screen.dz("room_openim_about", true);
        label807:
        Log.d("MicroMsg.ChatroomInfoUI", "updatePlaceTop()");
        if (this.sp == null) {
          this.sp = getSharedPreferences(getPackageName() + "_preferences", 0);
        }
        if (this.iYi != null)
        {
          if (this.contact == null) {
            break label1550;
          }
          this.sp.edit().putBoolean("room_placed_to_the_top", ((com.tencent.mm.plugin.messenger.foundation.a.n)com.tencent.mm.kernel.h.ae(com.tencent.mm.plugin.messenger.foundation.a.n.class)).bbR().bwF(this.contact.field_username)).commit();
        }
        label918:
        this.screen.notifyDataSetChanged();
        Log.d("MicroMsg.ChatroomInfoUI", "updateSaveToContact()");
        if (this.sp == null) {
          this.sp = getSharedPreferences(getPackageName() + "_preferences", 0);
        }
        if (this.iYh == null) {
          break label1608;
        }
        localObject1 = ((com.tencent.mm.plugin.messenger.foundation.a.n)com.tencent.mm.kernel.h.ae(com.tencent.mm.plugin.messenger.foundation.a.n.class)).bbL().RG(this.roomId);
        if (localObject1 != null) {
          break label1577;
        }
        Log.e("MicroMsg.ChatroomInfoUI", "contact == null !!!");
        label1021:
        Log.d("MicroMsg.ChatroomInfoUI", "updateDisplayNickname()");
        if (this.sp == null) {
          this.sp = getSharedPreferences(getPackageName() + "_preferences", 0);
        }
        localObject1 = ((com.tencent.mm.plugin.chatroom.a.b)com.tencent.mm.kernel.h.ae(com.tencent.mm.plugin.chatroom.a.b.class)).bbV().Rw(this.roomId);
        if (localObject1 != null) {
          break label1620;
        }
        Log.e("MicroMsg.ChatroomInfoUI", "members == null !!!");
        label1108:
        this.iYu = ((com.tencent.mm.plugin.messenger.foundation.a.n)com.tencent.mm.kernel.h.ae(com.tencent.mm.plugin.messenger.foundation.a.n.class)).eSe().aOX(this.roomId);
        this.iYu = ((com.tencent.mm.plugin.messenger.foundation.a.n)com.tencent.mm.kernel.h.ae(com.tencent.mm.plugin.messenger.foundation.a.n.class)).eSe().aOX(this.roomId);
      }
    }
    for (;;)
    {
      if (this.iYf != null)
      {
        if ((!this.fKN) && (this.iXZ)) {
          this.iYf.bv(new ArrayList());
        }
        getListView().setOnScrollListener(this.iYA);
        this.iYf.a(this.iYA);
        this.iYf.a(new s.b()
        {
          public final boolean qx(int paramAnonymousInt)
          {
            return true;
          }
        });
        localObject1 = this.iYf;
        localObject2 = new ChatroomInfoUI.33(this);
        if (((ContactListExpandPreference)localObject1).RgM != null) {
          ((ContactListExpandPreference)localObject1).RgM.bwV = ((View.OnClickListener)localObject2);
        }
        this.iYf.a(new ContactListExpandPreference.a()
        {
          public final void asG()
          {
            AppMethodBeat.i(188518);
            if (ChatroomInfoUI.m(ChatroomInfoUI.this) != null) {
              ChatroomInfoUI.m(ChatroomInfoUI.this).hkC();
            }
            AppMethodBeat.o(188518);
          }
          
          public final void e(ViewGroup paramAnonymousViewGroup, int paramAnonymousInt)
          {
            AppMethodBeat.i(188517);
            String str = ChatroomInfoUI.m(ChatroomInfoUI.this).aqq(paramAnonymousInt);
            paramAnonymousViewGroup = Util.nullAsNil(ChatroomInfoUI.m(ChatroomInfoUI.this).aqs(paramAnonymousInt));
            Object localObject;
            if (Util.isNullOrNil(paramAnonymousViewGroup))
            {
              com.tencent.mm.kernel.h.aHH();
              localObject = ((com.tencent.mm.plugin.messenger.foundation.a.n)com.tencent.mm.kernel.h.ae(com.tencent.mm.plugin.messenger.foundation.a.n.class)).bbM().aPj(str);
              if ((localObject != null) && (!Util.isNullOrNil(((co)localObject).field_encryptUsername))) {
                paramAnonymousViewGroup = ((co)localObject).field_conRemark;
              }
            }
            for (;;)
            {
              if (Util.isNullOrNil(str))
              {
                AppMethodBeat.o(188517);
                return;
              }
              localObject = new Intent();
              ((Intent)localObject).putExtra("Contact_User", str);
              ((Intent)localObject).putExtra("Contact_RemarkName", paramAnonymousViewGroup);
              if ((ChatroomInfoUI.n(ChatroomInfoUI.this)) && (ChatroomInfoUI.c(ChatroomInfoUI.this) != null)) {
                ((Intent)localObject).putExtra("Contact_RoomNickname", ChatroomInfoUI.c(ChatroomInfoUI.this).PJ(str));
              }
              ((Intent)localObject).putExtra("Contact_Nick", Util.nullAsNil(ChatroomInfoUI.m(ChatroomInfoUI.this).aqr(paramAnonymousInt)));
              ((Intent)localObject).putExtra("Contact_RoomMember", true);
              ((Intent)localObject).putExtra("room_name", ChatroomInfoUI.o(ChatroomInfoUI.this).field_username);
              paramAnonymousViewGroup = ((com.tencent.mm.plugin.messenger.foundation.a.n)com.tencent.mm.kernel.h.ae(com.tencent.mm.plugin.messenger.foundation.a.n.class)).bbL().RG(str);
              if ((paramAnonymousViewGroup != null) && ((int)paramAnonymousViewGroup.jxt > 0) && (com.tencent.mm.contact.d.rk(paramAnonymousViewGroup.field_type)))
              {
                vm localvm = new vm();
                localvm.fUF.intent = ((Intent)localObject);
                localvm.fUF.username = str;
                EventCenter.instance.publish(localvm);
              }
              if (ChatroomInfoUI.n(ChatroomInfoUI.this))
              {
                com.tencent.mm.plugin.report.service.h.IzE.idkeyStat(219L, 9L, 1L, true);
                if ((paramAnonymousViewGroup != null) && (paramAnonymousViewGroup.hxX())) {
                  com.tencent.mm.plugin.report.service.h.IzE.kvStat(10298, paramAnonymousViewGroup.field_username + ",14");
                }
                ((Intent)localObject).putExtra("Contact_Scene", 14);
              }
              for (;;)
              {
                ((Intent)localObject).putExtra("Is_RoomOwner", ChatroomInfoUI.q(ChatroomInfoUI.this));
                ((Intent)localObject).putExtra("Contact_ChatRoomId", ChatroomInfoUI.b(ChatroomInfoUI.this));
                if (ab.PQ(ChatroomInfoUI.b(ChatroomInfoUI.this)))
                {
                  paramAnonymousViewGroup = new iv();
                  paramAnonymousViewGroup.zR(ChatroomInfoUI.b(ChatroomInfoUI.this));
                  paramAnonymousViewGroup.gmT = 12L;
                  paramAnonymousViewGroup.bpa();
                }
                ((Intent)localObject).putExtra("CONTACT_INFO_UI_SOURCE", 8);
                com.tencent.mm.by.c.b(ChatroomInfoUI.this, "profile", ".ui.ContactInfoUI", (Intent)localObject);
                AppMethodBeat.o(188517);
                return;
                if (ChatroomInfoUI.p(ChatroomInfoUI.this))
                {
                  ((Intent)localObject).putExtra("Contact_Scene", 44);
                  if (!z.PD(paramAnonymousViewGroup.field_username)) {
                    ((Intent)localObject).putExtra("Contact_IsLBSFriend", true);
                  }
                }
              }
            }
          }
          
          public final void qv(int paramAnonymousInt)
          {
            AppMethodBeat.i(188515);
            ChatroomInfoUI.l(ChatroomInfoUI.this);
            AppMethodBeat.o(188515);
          }
          
          public final void qw(int paramAnonymousInt)
          {
            AppMethodBeat.i(188521);
            ChatroomInfoUI.r(ChatroomInfoUI.this);
            AppMethodBeat.o(188521);
          }
        });
      }
      setBackBtn(new MenuItem.OnMenuItemClickListener()
      {
        public final boolean onMenuItemClick(MenuItem paramAnonymousMenuItem)
        {
          AppMethodBeat.i(187672);
          ChatroomInfoUI.this.finish();
          AppMethodBeat.o(187672);
          return true;
        }
      });
      AppMethodBeat.o(12570);
      return;
      if (this.iXp != null) {
        this.iYr = this.iXp.bjL().size();
      }
      setMMTitle(getString(a.i.eFv, new Object[] { getString(a.i.eRt), Integer.valueOf(this.iYr) }));
      break;
      label1363:
      this.iYo = true;
      this.iYp = ((String)localObject1).equals(z.bcZ());
      break label97;
      label1383:
      bool = false;
      break label414;
      label1388:
      this.screen.dz("room_manager_view", true);
      this.screen.dz("manage_room", false);
      break label426;
      label1419:
      this.screen.dz("see_room_member", true);
      break label783;
      label1436:
      this.screen.dz("chatroom_bottom_pc", true);
      this.screen.dz("room_openim_about", false);
      localObject1 = getString(a.i.jgp);
      Object localObject2 = getString(a.i.jgq);
      int i = ((String)localObject1).lastIndexOf((String)localObject2);
      if (i < 0) {
        break label807;
      }
      int j = ((String)localObject2).length();
      localObject1 = new SpannableStringBuilder((CharSequence)localObject1);
      ((SpannableStringBuilder)localObject1).setSpan(new ChatroomInfoUI.4(this), i, j + i, 18);
      this.screen.byG("room_openim_about").setTitle((CharSequence)localObject1);
      break label807;
      label1550:
      this.sp.edit().putBoolean("room_placed_to_the_top", false).commit();
      break label918;
      label1577:
      this.sp.edit().putBoolean("room_save_to_contact", com.tencent.mm.contact.d.rk(((ax)localObject1).field_type)).commit();
      label1608:
      this.screen.notifyDataSetChanged();
      break label1021;
      label1620:
      this.iYn = ((ah)localObject1).hxI();
      this.iYl = ((CheckBoxPreference)this.screen.byG("room_msg_show_username"));
      if (this.iYl != null) {
        this.sp.edit().putBoolean("room_msg_show_username", this.iYn).commit();
      }
      this.screen.notifyDataSetChanged();
      break label1108;
      if (this.iXZ)
      {
        this.iYp = false;
        this.iYq = false;
        setMMTitle(getString(a.i.jgf));
        this.iYf = ((ContactListExpandPreference)this.screen.byG("roominfo_contact_anchor"));
        this.iYf.a(this.screen, this.iYf.mKey);
        this.iYf.DZ(false).Ea(false);
        this.iYf.a(new s.b()
        {
          public final boolean qx(int paramAnonymousInt)
          {
            return true;
          }
        });
        this.screen.removeAll();
        this.screen.b(new PreferenceCategory(this));
        this.screen.b(this.iYf);
        localObject1 = this.roomId;
        localObject2 = new nz();
        ((nz)localObject2).fMM.fKz = ((String)localObject1);
        EventCenter.instance.publish((IEvent)localObject2);
        getString(a.i.app_tip);
        this.iXX = com.tencent.mm.ui.base.h.a(this, getString(a.i.jgd), true, new DialogInterface.OnCancelListener()
        {
          public final void onCancel(DialogInterface paramAnonymousDialogInterface)
          {
            AppMethodBeat.i(186682);
            ChatroomInfoUI.a(this.iYY);
            AppMethodBeat.o(186682);
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
        ((y)com.tencent.mm.kernel.h.ae(y.class)).Wz(3);
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
      paramIntent = com.tencent.mm.roomsdk.a.b.btX(this.roomId).a(this.roomId, paramIntent, 0);
      paramIntent.b(new com.tencent.mm.roomsdk.a.b.b() {});
      paramIntent.c(new com.tencent.mm.roomsdk.a.b.b() {});
      paramIntent.a(this, getString(a.i.app_tip), getString(a.i.eQQ), true, true, new ChatroomInfoUI.19(this, paramIntent));
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
        EventCenter.instance.publish(new zy());
        this.contact.setNickname(paramIntent);
        ((com.tencent.mm.plugin.messenger.foundation.a.n)com.tencent.mm.kernel.h.ae(com.tencent.mm.plugin.messenger.foundation.a.n.class)).bbL().au(this.contact);
        asB();
      }
      AppMethodBeat.o(12569);
      return;
      if (paramInt2 != 0) {
        break;
      }
      this.iYD = -1;
      AppMethodBeat.o(12569);
      return;
      if (paramInt2 == -1) {
        asA();
      }
    }
    AppMethodBeat.o(12569);
  }
  
  public void onConfigurationChanged(Configuration paramConfiguration)
  {
    AppMethodBeat.i(12565);
    super.onConfigurationChanged(paramConfiguration);
    this.iYf.notifyChanged();
    AppMethodBeat.o(12565);
  }
  
  public void onCreate(final Bundle paramBundle)
  {
    AppMethodBeat.i(12562);
    super.onCreate(paramBundle);
    com.tencent.mm.kernel.h.aHF().kcd.a(480, this);
    com.tencent.mm.pluginsdk.d.b.a(nz.class.getName(), this.iYJ);
    paramBundle = this.iYC.alive();
    Assert.assertNotNull(this);
    keep(paramBundle);
    com.tencent.mm.kernel.h.aHG().aHp().add(this);
    ((com.tencent.mm.plugin.chatroom.a.b)com.tencent.mm.kernel.h.ae(com.tencent.mm.plugin.chatroom.a.b.class)).bbV().add(this);
    if (com.tencent.mm.bj.g.meT != null) {
      com.tencent.mm.bj.g.meT.a(this);
    }
    this.roomId = getIntent().getStringExtra("RoomInfo_Id");
    this.contact = ((com.tencent.mm.plugin.messenger.foundation.a.n)com.tencent.mm.kernel.h.ae(com.tencent.mm.plugin.messenger.foundation.a.n.class)).bbL().RG(this.roomId);
    this.iYv = true;
    this.fKN = getIntent().getBooleanExtra("Is_Chatroom", true);
    this.iXZ = getIntent().getBooleanExtra("Is_Lbsroom", false);
    this.iYw = getIntent().getBooleanExtra("fromChatting", false);
    this.iYx = getIntent().getBooleanExtra("isShowSetMuteAnimation", false);
    this.iYF = (getPackageName() + "_preferences");
    if (this.fKN)
    {
      this.iXp = ((com.tencent.mm.plugin.chatroom.a.b)com.tencent.mm.kernel.h.ae(com.tencent.mm.plugin.chatroom.a.b.class)).bbV().Rw(this.roomId);
      if (this.iXp != null) {
        this.iYq = this.iXp.bvA(z.bcZ());
      }
    }
    initView();
    if (this.fKN)
    {
      paramBundle = new ChatroomInfoUI.20(this);
      if (this.iXp == null)
      {
        az.a.ltq.a(this.roomId, "", paramBundle);
        AppMethodBeat.o(12562);
        return;
      }
      if (System.currentTimeMillis() - this.iXp.field_modifytime >= 86400000L) {
        com.tencent.mm.kernel.h.aHJ().postToWorker(new Runnable()
        {
          public final void run()
          {
            AppMethodBeat.i(12543);
            az.a.ltq.a(ChatroomInfoUI.c(ChatroomInfoUI.this).field_chatroomname, "", paramBundle);
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
    if (com.tencent.mm.bj.g.meT != null) {
      com.tencent.mm.bj.g.meT.a(this);
    }
    com.tencent.mm.kernel.h.aHG().aHp().remove(this);
    com.tencent.mm.ui.j.a.dismiss();
    com.tencent.mm.kernel.h.aHF().kcd.b(480, this);
    EventCenter.instance.removeListener(this.iYC);
    com.tencent.mm.pluginsdk.d.b.b(nz.class.getName(), this.iYJ);
    if (com.tencent.mm.kernel.h.aHB())
    {
      ((com.tencent.mm.plugin.messenger.foundation.a.n)com.tencent.mm.kernel.h.ae(com.tencent.mm.plugin.messenger.foundation.a.n.class)).bbL().remove(this);
      ((com.tencent.mm.plugin.chatroom.a.b)com.tencent.mm.kernel.h.ae(com.tencent.mm.plugin.chatroom.a.b.class)).bbV().remove(this);
    }
    if (com.tencent.mm.bj.g.meT != null) {
      com.tencent.mm.bj.g.meT.b(this);
    }
    if (this.iYK != null) {
      this.iYK.stopTimer();
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
    if (!ab.Lj(paramString))
    {
      Log.d("MicroMsg.ChatroomInfoUI", "event:" + paramString + " cancel");
      AppMethodBeat.o(12597);
      return;
    }
    Log.d("MicroMsg.ChatroomInfoUI", "event:".concat(String.valueOf(paramString)));
    if ((this.fKN) && (paramString.equals(this.roomId))) {
      com.tencent.mm.kernel.h.aHJ().postToWorker(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(194548);
          ChatroomInfoUI.a(ChatroomInfoUI.this, ((com.tencent.mm.plugin.chatroom.a.b)com.tencent.mm.kernel.h.ae(com.tencent.mm.plugin.chatroom.a.b.class)).bbV().Rw(ChatroomInfoUI.b(ChatroomInfoUI.this)));
          if (ChatroomInfoUI.c(ChatroomInfoUI.this) == null)
          {
            Log.e("MicroMsg.ChatroomInfoUI", "member is null");
            AppMethodBeat.o(194548);
            return;
          }
          if (Util.isNullOrNil(ChatroomInfoUI.c(ChatroomInfoUI.this).field_roomowner))
          {
            Log.e("MicroMsg.ChatroomInfoUI", "roomowner is null");
            AppMethodBeat.o(194548);
            return;
          }
          ChatroomInfoUI.A(ChatroomInfoUI.this).sendEmptyMessage(0);
          ChatroomInfoUI.b(ChatroomInfoUI.this, ChatroomInfoUI.c(ChatroomInfoUI.this).field_roomowner.equals(z.bcZ()));
          ChatroomInfoUI.c(ChatroomInfoUI.this, ChatroomInfoUI.c(ChatroomInfoUI.this).bvA(z.bcZ()));
          ChatroomInfoUI.m(ChatroomInfoUI.this).brp(ChatroomInfoUI.c(ChatroomInfoUI.this).field_roomowner);
          AppMethodBeat.o(194548);
        }
        
        public final String toString()
        {
          AppMethodBeat.i(194550);
          String str = super.toString() + "|onNotifyChange";
          AppMethodBeat.o(194550);
          return str;
        }
      });
    }
    asj();
    AppMethodBeat.o(12597);
  }
  
  public void onPause()
  {
    AppMethodBeat.i(12567);
    super.onPause();
    if ((this.iYt) && (this.fKN))
    {
      if (this.iXp == null)
      {
        AppMethodBeat.o(12567);
        return;
      }
      v.a(this.roomId, this.iXp, this.iYn);
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
      paramf = com.tencent.mm.n.h.axc().getValue("ChatRoomOwnerModTopic");
      if (!Util.isNullOrNil(paramf)) {
        i = Util.safeParseInt(paramf);
      }
      if ((this.iXp != null) && (!Util.isNullOrNil(this.iXp.field_roomowner)) && (i > 0) && (!asE()) && (i < this.iYr)) {
        com.tencent.mm.ui.base.h.a(this, getString(a.i.jgF, new Object[] { asx() }), null, getString(a.i.app_i_known), new DialogInterface.OnClickListener()
        {
          public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt) {}
        });
      }
    }
    label839:
    label1629:
    for (;;)
    {
      AppMethodBeat.o(12571);
      return false;
      paramf = new Intent();
      paramf.setClass(this, ModRemarkRoomNameUI.class);
      paramf.putExtra("Key_Scenen", 1);
      paramf.putExtra("Key_Room_Id", this.roomId);
      paramf = new com.tencent.mm.hellhoundlib.b.a().bm(paramf);
      com.tencent.mm.hellhoundlib.a.a.b(this, paramf.aFh(), "com/tencent/mm/chatroom/ui/ChatroomInfoUI", "onPreferenceTreeClick", "(Lcom/tencent/mm/ui/base/preference/IPreferenceScreen;Lcom/tencent/mm/ui/base/preference/Preference;)Z", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
      startActivity((Intent)paramf.sf(0));
      com.tencent.mm.hellhoundlib.a.a.c(this, "com/tencent/mm/chatroom/ui/ChatroomInfoUI", "onPreferenceTreeClick", "(Lcom/tencent/mm/ui/base/preference/IPreferenceScreen;Lcom/tencent/mm/ui/base/preference/Preference;)Z", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
      com.tencent.mm.plugin.report.service.h.IzE.idkeyStat(219L, 3L, 1L, true);
      continue;
      label861:
      label2786:
      if (paramf.equals("room_upgrade_entry"))
      {
        if (Util.getInt(com.tencent.mm.n.h.axc().getValue("ChatroomGlobalSwitch"), 1) == 1) {}
        for (i = 1;; i = 0)
        {
          if (i == 0) {
            break label361;
          }
          paramf = new Intent();
          paramf.putExtra("rawUrl", getString(a.i.chatroom_how_to_upgrade, new Object[] { LocaleUtil.getApplicationLanguage() }));
          paramf.putExtra("geta8key_username", z.bcZ());
          paramf.putExtra("showShare", false);
          com.tencent.mm.by.c.b(this, "webview", "com.tencent.mm.plugin.webview.ui.tools.WebViewUI", paramf);
          break;
        }
      }
      else
      {
        label361:
        if (paramf.equals("room_qr_code"))
        {
          if (ab.PQ(this.roomId))
          {
            paramf = new iv();
            paramf.zR(this.roomId);
            paramf.gmT = 6L;
            paramf.bpa();
          }
          com.tencent.mm.plugin.report.service.h.IzE.idkeyStat(219L, 5L, 1L, true);
          paramf = new Intent();
          paramf.putExtra("from_userName", this.roomId);
          com.tencent.mm.by.c.b(this, "setting", ".ui.setting.SelfQRCodeUI", paramf);
        }
        else
        {
          final boolean bool1;
          if (paramf.equals("room_card"))
          {
            if (this.iXp == null)
            {
              Log.w("MicroMsg.ChatroomInfoUI", "goToRoomCardUI member == null");
            }
            else
            {
              bool1 = this.iXp.bvA(z.bcZ());
              if ((Util.isNullOrNil(v.Pw(this.roomId))) && (!asE()))
              {
                com.tencent.mm.ui.base.h.c(this, getString(a.i.jfN), null, getString(a.i.jfO), null, null, null);
              }
              else
              {
                paramf = new Intent();
                paramf.setClass(this, RoomCardUI.class);
                paramf.putExtra("RoomInfo_Id", this.roomId);
                paramf.putExtra("room_name", this.iYa.jml.toString());
                this.iYr = v.Ps(this.roomId).size();
                paramf.putExtra("room_member_count", this.iYr);
                paramf.putExtra("room_owner_name", asx());
                paramf.putExtra("room_notice", v.Pw(this.roomId));
                paramf.putExtra("room_notice_publish_time", v.Pz(this.roomId));
                paramf.putExtra("room_notice_editor", v.Py(this.roomId));
                paramf.putExtra("Is_RoomOwner", this.iYp);
                paramf.putExtra("Is_RoomManager", bool1);
                paramf.putExtra("from_scene", 1);
                startActivityForResult(paramf, 6);
                paramf = new nf().DZ(this.roomId);
                paramf.ggi = this.iXp.field_memberCount;
                long l;
                if (this.iYp)
                {
                  l = 1L;
                  paramf.ggh = l;
                  paramf = paramf.Ea(this.iXp.field_chatroomnoticePublishTime);
                  paramf.gef = 1L;
                  paramf.bpa();
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
            if (paramf.equals("room_notify_new_msg")) {
              if (!this.iYs)
              {
                bool1 = true;
                this.iYs = bool1;
                if (this.fKN)
                {
                  if (!this.iYs) {
                    break label1083;
                  }
                  i = 0;
                  com.tencent.mm.roomsdk.a.b.btX(this.roomId).aa(this.roomId, i).aRu();
                  this.contact = ((com.tencent.mm.plugin.messenger.foundation.a.n)com.tencent.mm.kernel.h.ae(com.tencent.mm.plugin.messenger.foundation.a.n.class)).bbL().RG(this.roomId);
                  this.contact.pA(i);
                  ((com.tencent.mm.plugin.messenger.foundation.a.n)com.tencent.mm.kernel.h.ae(com.tencent.mm.plugin.messenger.foundation.a.n.class)).bbL().c(this.roomId, this.contact);
                  if (this.iYy)
                  {
                    paramf = com.tencent.mm.plugin.report.service.h.IzE;
                    if (!this.iYs) {
                      break label1088;
                    }
                    i = 14;
                    paramf.el(869, i);
                  }
                }
                paramf = com.tencent.mm.modelstat.b.mcf;
                ??? = this.roomId;
                bool1 = this.iYs;
                if ((paramf.bpp()) && (paramf.gz(???)))
                {
                  ??? = new IMBehavior();
                  ???.opType = 1;
                  ???.chattingOp = new IMBehaviorChattingOP();
                  ??? = ???.chattingOp;
                  if (!bool1) {
                    break label1094;
                  }
                  i = 1;
                  ((IMBehaviorChattingOP)???).changeNotifyStatus = i;
                }
              }
            }
            synchronized (paramf.lock)
            {
              paramf.mce.oplist_.add(???);
              asz();
              continue;
              bool1 = false;
              break label839;
              i = 1;
              break label861;
              i = 15;
              break label965;
              i = 2;
            }
            this.sp = getSharedPreferences(getPackageName() + "_preferences", 0);
            paramf = ((com.tencent.mm.plugin.messenger.foundation.a.n)com.tencent.mm.kernel.h.ae(com.tencent.mm.plugin.messenger.foundation.a.n.class)).bbL().RG(this.roomId);
            if (paramf != null)
            {
              boolean bool2 = com.tencent.mm.contact.d.rk(paramf.field_type);
              ??? = this.sp.edit();
              if (!bool2)
              {
                bool1 = true;
                ???.putBoolean("room_save_to_contact", bool1).commit();
                if (!bool2) {
                  break label1296;
                }
                paramf.axl();
                com.tencent.mm.roomsdk.a.b.btX(this.roomId).a(paramf, false);
                com.tencent.mm.ui.base.h.cO(this, getString(a.i.eRo));
                com.tencent.mm.modelstat.b.mcf.Y(this.roomId, false);
              }
              for (;;)
              {
                this.screen.notifyDataSetChanged();
                break;
                bool1 = false;
                break label1215;
                com.tencent.mm.roomsdk.a.b.btX(this.roomId).a(paramf, true);
                com.tencent.mm.ui.base.h.cO(this, getString(a.i.eRq));
                com.tencent.mm.modelstat.b.mcf.Y(this.roomId, true);
              }
              if (paramf.equals("room_placed_to_the_top"))
              {
                paramf = getSharedPreferences(this.iYF, 0);
                if (this.contact != null)
                {
                  if (((com.tencent.mm.plugin.messenger.foundation.a.n)com.tencent.mm.kernel.h.ae(com.tencent.mm.plugin.messenger.foundation.a.n.class)).bbR().bwF(this.contact.field_username))
                  {
                    ab.H(this.contact.field_username, true);
                    com.tencent.mm.modelstat.b.mcf.c(false, this.roomId, false);
                  }
                  for (;;)
                  {
                    paramf.edit().putBoolean("room_placed_to_the_top", ((com.tencent.mm.plugin.messenger.foundation.a.n)com.tencent.mm.kernel.h.ae(com.tencent.mm.plugin.messenger.foundation.a.n.class)).bbR().bwF(this.contact.field_username)).commit();
                    break;
                    ab.G(this.contact.field_username, true);
                    com.tencent.mm.modelstat.b.mcf.c(false, this.roomId, true);
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
                  paramf = getSharedPreferences(this.iYF, 0).edit();
                  if (!this.iYn)
                  {
                    bool1 = true;
                    paramf.putBoolean("room_msg_show_username", bool1).commit();
                    if (this.iYn) {
                      break label1629;
                    }
                  }
                  for (bool1 = true;; bool1 = false)
                  {
                    this.iYn = bool1;
                    this.iYt = true;
                    break;
                    bool1 = false;
                    break label1582;
                  }
                }
                if (paramf.equals("room_set_chatting_background"))
                {
                  if (ab.PQ(this.roomId))
                  {
                    paramf = new iv();
                    paramf.zR(this.roomId);
                    paramf.gmT = 9L;
                    paramf.bpa();
                  }
                  paramf = new Intent();
                  paramf.putExtra("isApplyToAll", false);
                  paramf.putExtra("username", this.contact.field_username);
                  com.tencent.mm.by.c.b(this, "setting", ".ui.setting.SettingsChattingBackgroundUI", paramf, 2);
                }
                else if (paramf.equals("room_search_chatting_content"))
                {
                  if (ab.PQ(this.roomId))
                  {
                    paramf = new iv();
                    paramf.zR(this.roomId);
                    paramf.gmT = 8L;
                    paramf.bpa();
                  }
                  paramf = new Intent();
                  paramf.putExtra("detail_username", this.roomId);
                  com.tencent.mm.plugin.fts.a.d.d(this, ".ui.FTSChattingConvUI", paramf);
                  int j = 0;
                  i = j;
                  if (this.iXp != null)
                  {
                    i = j;
                    if (this.iXp.bjL() != null) {
                      i = this.iXp.bjL().size();
                    }
                  }
                  com.tencent.mm.plugin.report.service.h.IzE.a(14569, new Object[] { Integer.valueOf(1), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(i), Integer.valueOf(1) });
                }
                else if (paramf.equals("room_clear_chatting_history"))
                {
                  if (ab.PQ(this.roomId))
                  {
                    paramf = new iv();
                    paramf.zR(this.roomId);
                    paramf.gmT = 11L;
                    paramf.bpa();
                  }
                  paramf = getString(a.i.jfp);
                  com.tencent.mm.ui.base.h.a(getContext(), paramf, "", getString(a.i.app_clear), getString(a.i.app_cancel), new DialogInterface.OnClickListener()
                  {
                    public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
                    {
                      AppMethodBeat.i(189148);
                      com.tencent.mm.plugin.report.service.h.IzE.a(14553, new Object[] { Integer.valueOf(3), Integer.valueOf(2), ChatroomInfoUI.b(ChatroomInfoUI.this) });
                      ChatroomInfoUI.dN(false);
                      paramAnonymousDialogInterface = ChatroomInfoUI.this;
                      ChatroomInfoUI.this.getString(a.i.app_tip);
                      final s locals = com.tencent.mm.ui.base.h.a(paramAnonymousDialogInterface, ChatroomInfoUI.this.getString(a.i.app_waiting), true, new ChatroomInfoUI.a());
                      if (!ChatroomInfoUI.asF()) {}
                      for (paramAnonymousDialogInterface = com.tencent.mm.pluginsdk.wallet.d.bsh(ChatroomInfoUI.o(ChatroomInfoUI.this).field_username);; paramAnonymousDialogInterface = null)
                      {
                        if (!Util.isNullOrNil(paramAnonymousDialogInterface))
                        {
                          locals.dismiss();
                          com.tencent.mm.ui.base.h.a(ChatroomInfoUI.this, false, ChatroomInfoUI.this.getString(a.i.eVx, new Object[] { paramAnonymousDialogInterface }), null, ChatroomInfoUI.this.getString(a.i.goto_conversation), ChatroomInfoUI.this.getString(a.i.exI), new DialogInterface.OnClickListener()new DialogInterface.OnClickListener
                          {
                            public final void onClick(DialogInterface paramAnonymous2DialogInterface, int paramAnonymous2Int)
                            {
                              AppMethodBeat.i(187244);
                              com.tencent.mm.plugin.report.service.h.IzE.a(14553, new Object[] { Integer.valueOf(3), Integer.valueOf(4), ChatroomInfoUI.b(ChatroomInfoUI.this) });
                              ChatroomInfoUI.a(ChatroomInfoUI.this, true);
                              if (!ChatroomInfoUI.s(ChatroomInfoUI.this))
                              {
                                paramAnonymous2DialogInterface = new Intent();
                                paramAnonymous2DialogInterface.putExtra("Chat_User", ChatroomInfoUI.o(ChatroomInfoUI.this).field_username);
                                paramAnonymous2DialogInterface.addFlags(67108864);
                                com.tencent.mm.by.c.f(ChatroomInfoUI.this, ".ui.chatting.ChattingUI", paramAnonymous2DialogInterface);
                                AppMethodBeat.o(187244);
                                return;
                              }
                              ChatroomInfoUI.this.finish();
                              AppMethodBeat.o(187244);
                            }
                          }, new DialogInterface.OnClickListener()
                          {
                            public final void onClick(DialogInterface paramAnonymous2DialogInterface, int paramAnonymous2Int)
                            {
                              AppMethodBeat.i(187401);
                              com.tencent.mm.plugin.report.service.h.IzE.a(14553, new Object[] { Integer.valueOf(3), Integer.valueOf(3), ChatroomInfoUI.b(ChatroomInfoUI.this) });
                              locals.show();
                              ChatroomInfoUI.a(ChatroomInfoUI.this, false);
                              ChatroomInfoUI.a(ChatroomInfoUI.this, locals);
                              AppMethodBeat.o(187401);
                            }
                          }, -1, a.b.alert_btn_color_warn);
                          AppMethodBeat.o(189148);
                          return;
                        }
                        ChatroomInfoUI.a(ChatroomInfoUI.this, locals);
                        AppMethodBeat.o(189148);
                        return;
                      }
                    }
                  }, null, a.b.alert_btn_color_warn);
                }
                else if (paramf.equals("room_report_it"))
                {
                  if (ab.PQ(this.roomId))
                  {
                    paramf = new iv();
                    paramf.zR(this.roomId);
                    paramf.gmT = 10L;
                    paramf.bpa();
                  }
                  paramf = new Intent();
                  paramf.putExtra("k_username", this.roomId);
                  paramf.putExtra("showShare", false);
                  paramf.putExtra("rawUrl", String.format(f.e.VRX, new Object[] { Integer.valueOf(36) }));
                  com.tencent.mm.by.c.b(this, "webview", ".ui.tools.WebViewUI", paramf);
                  paramf = com.tencent.mm.modelstat.b.mcf;
                  ??? = this.roomId;
                  if ((paramf.bpp()) && (paramf.gz(???)))
                  {
                    ??? = new IMBehavior();
                    ((IMBehavior)???).opType = 1;
                    ((IMBehavior)???).chattingOp = new IMBehaviorChattingOP();
                    ((IMBehavior)???).chattingOp.expose = 1;
                    synchronized (paramf.lock)
                    {
                      paramf.mce.oplist_.add(???);
                    }
                  }
                }
                else if (paramf.equals("room_del_quit"))
                {
                  Log.d("MicroMsg.ChatroomInfoUI", " quit " + this.roomId);
                  paramf = new yx();
                  paramf.fYg.fYi = true;
                  EventCenter.instance.publish(paramf);
                  if ((!Util.isNullOrNil(this.roomId)) && (this.roomId.equals(paramf.fYh.fYk)))
                  {
                    bool1 = true;
                    if (!bool1) {
                      break label2413;
                    }
                    Log.d("MicroMsg.ChatroomInfoUI", " quit talkroom" + this.roomId);
                  }
                  label2413:
                  while ((!this.iYp) || (this.iXp == null) || (this.iXp.bjL().size() <= 2))
                  {
                    com.tencent.mm.ui.base.h.a(getContext(), getString(a.i.eBa), "", getString(a.i.app_ok), getString(a.i.app_cancel), new DialogInterface.OnClickListener()
                    {
                      public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
                      {
                        AppMethodBeat.i(187137);
                        if ((ChatroomInfoUI.b(ChatroomInfoUI.this) == null) || (ChatroomInfoUI.b(ChatroomInfoUI.this).length() <= 0))
                        {
                          Log.e("MicroMsg.ChatroomInfoUI", "quitChatRoom : invalid args");
                          AppMethodBeat.o(187137);
                          return;
                        }
                        if (bool1)
                        {
                          paramAnonymousDialogInterface = new yx();
                          paramAnonymousDialogInterface.fYg.fYj = true;
                          EventCenter.instance.publish(paramAnonymousDialogInterface);
                        }
                        if (!((com.tencent.mm.plugin.messenger.foundation.a.n)com.tencent.mm.kernel.h.ae(com.tencent.mm.plugin.messenger.foundation.a.n.class)).bbL().bwl(ChatroomInfoUI.b(ChatroomInfoUI.this)))
                        {
                          Log.e("MicroMsg.ChatroomInfoUI", "quitChatRoom : room[" + ChatroomInfoUI.b(ChatroomInfoUI.this) + "] is not exist");
                          AppMethodBeat.o(187137);
                          return;
                        }
                        if (((com.tencent.mm.live.a)com.tencent.mm.kernel.h.ag(com.tencent.mm.live.a.class)).isAnchorLiving())
                        {
                          com.tencent.mm.ui.base.h.a(ChatroomInfoUI.this.getContext(), ChatroomInfoUI.this.getString(a.i.jeV), null, ChatroomInfoUI.this.getString(a.i.app_i_known), new DialogInterface.OnClickListener()
                          {
                            public final void onClick(DialogInterface paramAnonymous2DialogInterface, int paramAnonymous2Int) {}
                          });
                          AppMethodBeat.o(187137);
                          return;
                        }
                        if (((com.tencent.mm.live.a)com.tencent.mm.kernel.h.ag(com.tencent.mm.live.a.class)).isVisitorLiving()) {
                          ((com.tencent.mm.live.a)com.tencent.mm.kernel.h.ag(com.tencent.mm.live.a.class)).forceStopCurLive(ChatroomInfoUI.this.getContext());
                        }
                        ChatroomInfoUI.t(ChatroomInfoUI.this);
                        ((com.tencent.mm.plugin.multitalk.model.d)com.tencent.mm.kernel.h.ae(com.tencent.mm.plugin.multitalk.model.d.class)).aPS(ChatroomInfoUI.b(ChatroomInfoUI.this));
                        AppMethodBeat.o(187137);
                      }
                    }, null, a.b.alert_btn_color_warn);
                    break;
                    bool1 = false;
                    break label2328;
                  }
                  paramf = getString(a.i.jgr);
                  ??? = new h.d()
                  {
                    public final void qy(int paramAnonymousInt)
                    {
                      AppMethodBeat.i(187492);
                      switch (paramAnonymousInt)
                      {
                      default: 
                        Log.d("MicroMsg.ChatroomInfoUI", "dz[dealQuitChatRoom owner click cancel]");
                        AppMethodBeat.o(187492);
                        return;
                      }
                      Log.d("MicroMsg.ChatroomInfoUI", "dz[dealQuitChatRoom owner click room_owner_delete_direct]");
                      if (((com.tencent.mm.live.a)com.tencent.mm.kernel.h.ag(com.tencent.mm.live.a.class)).isAnchorLiving())
                      {
                        com.tencent.mm.ui.base.h.a(ChatroomInfoUI.this.getContext(), ChatroomInfoUI.this.getString(a.i.jeV), null, ChatroomInfoUI.this.getString(a.i.app_i_known), new DialogInterface.OnClickListener()
                        {
                          public final void onClick(DialogInterface paramAnonymous2DialogInterface, int paramAnonymous2Int) {}
                        });
                        AppMethodBeat.o(187492);
                        return;
                      }
                      if (((com.tencent.mm.live.a)com.tencent.mm.kernel.h.ag(com.tencent.mm.live.a.class)).isVisitorLiving()) {
                        ((com.tencent.mm.live.a)com.tencent.mm.kernel.h.ag(com.tencent.mm.live.a.class)).forceStopCurLive(ChatroomInfoUI.this.getContext());
                      }
                      ChatroomInfoUI.t(ChatroomInfoUI.this);
                      ((com.tencent.mm.plugin.multitalk.model.d)com.tencent.mm.kernel.h.ae(com.tencent.mm.plugin.multitalk.model.d.class)).aPS(ChatroomInfoUI.b(ChatroomInfoUI.this));
                      AppMethodBeat.o(187492);
                    }
                  };
                  com.tencent.mm.ui.base.h.a(this, "", new String[] { paramf }, "", ???);
                }
                else if (paramf.equals("add_selector_btn"))
                {
                  asv();
                }
                else if (paramf.equals("del_selector_btn"))
                {
                  asw();
                }
                else
                {
                  if (paramf.equals("see_room_member"))
                  {
                    paramf = new Intent();
                    paramf.setClass(getContext(), SeeRoomMemberUI.class);
                    paramf.putExtra("Block_list", z.bcZ());
                    ??? = v.Ps(this.roomId);
                    if (??? != null) {
                      this.iYr = ???.size();
                    }
                    paramf.putExtra("Chatroom_member_list", Util.listToString(???, ","));
                    paramf.putExtra("RoomInfo_Id", this.roomId);
                    paramf.putExtra("room_owner_name", this.iXp.field_roomowner);
                    paramf.putExtra("Is_RoomOwner", this.iYp);
                    paramf.putExtra("room_member_count", this.iYr);
                    paramf.putExtra("Add_address_titile", getString(a.i.jgB));
                    if (this.fKN)
                    {
                      paramf.putExtra("Contact_Scene", 14);
                      label2676:
                      ??? = getListView().getChildAt(0);
                      if (??? != null) {
                        break label2786;
                      }
                    }
                    for (i = 0;; i = -???.getTop())
                    {
                      paramf.putExtra("offset", i);
                      paramf.putExtra("first_pos", getListView().getFirstVisiblePosition());
                      paramf.putExtra("room_name", this.contact.field_username);
                      startActivityForResult(paramf, 5);
                      this.iYD = 5;
                      break;
                      if (!this.iXZ) {
                        break label2676;
                      }
                      paramf.putExtra("Contact_Scene", 44);
                      if (z.PD(this.contact.field_username)) {
                        break label2676;
                      }
                      paramf.putExtra("Contact_IsLBSFriend", true);
                      break label2676;
                    }
                  }
                  if (paramf.equals("manage_room"))
                  {
                    if (this.iYz) {
                      com.tencent.mm.plugin.newtips.a.fiO().aap(26);
                    }
                    paramf = new Intent();
                    paramf.setClass(getContext(), ManageChatroomUI.class);
                    paramf.putExtra("RoomInfo_Id", this.roomId);
                    paramf.putExtra("room_owner_name", this.iXp.field_roomowner);
                    paramf = new com.tencent.mm.hellhoundlib.b.a().bm(paramf);
                    com.tencent.mm.hellhoundlib.a.a.b(this, paramf.aFh(), "com/tencent/mm/chatroom/ui/ChatroomInfoUI", "goToManageChatroomUI", "()V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
                    startActivity((Intent)paramf.sf(0));
                    com.tencent.mm.hellhoundlib.a.a.c(this, "com/tencent/mm/chatroom/ui/ChatroomInfoUI", "goToManageChatroomUI", "()V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
                  }
                  else if (paramf.equals("chat_room_app_brand"))
                  {
                    if (ab.PQ(this.roomId))
                    {
                      paramf = new iv();
                      paramf.zR(this.roomId);
                      paramf.gmT = 7L;
                      paramf.bpa();
                    }
                    paramf = new Intent();
                    paramf.putExtra("Chat_User", this.roomId);
                    com.tencent.mm.by.c.f(this, ".ui.chatting.gallery.AppBrandHistoryListUI", paramf);
                    com.tencent.mm.plugin.report.service.h.IzE.idkeyStat(219L, 25L, 1L, true);
                  }
                  else if (paramf.equals("room_manager_view"))
                  {
                    paramf = new Intent();
                    paramf.setClass(getContext(), SeeRoomOwnerManagerUI.class);
                    paramf.putExtra("RoomInfo_Id", this.roomId);
                    paramf.putExtra("room_owner_name", this.iXp.field_roomowner);
                    paramf = new com.tencent.mm.hellhoundlib.b.a().bm(paramf);
                    com.tencent.mm.hellhoundlib.a.a.b(this, paramf.aFh(), "com/tencent/mm/chatroom/ui/ChatroomInfoUI", "goToOwnerManageChatroomUI", "()V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
                    startActivity((Intent)paramf.sf(0));
                    com.tencent.mm.hellhoundlib.a.a.c(this, "com/tencent/mm/chatroom/ui/ChatroomInfoUI", "goToOwnerManageChatroomUI", "()V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
                  }
                  else if ((!paramf.equals("chat_room_story_videos")) && (paramf.equals("room_remark")))
                  {
                    paramf = new Intent();
                    paramf.setClass(this, ModRemarkRoomNameUI.class);
                    paramf.putExtra("Key_Scenen", 2);
                    paramf.putExtra("Key_Room_Id", this.roomId);
                    paramf = new com.tencent.mm.hellhoundlib.b.a().bm(paramf);
                    com.tencent.mm.hellhoundlib.a.a.b(this, paramf.aFh(), "com/tencent/mm/chatroom/ui/ChatroomInfoUI", "dealModChatroomRemark", "()V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
                    startActivity((Intent)paramf.sf(0));
                    com.tencent.mm.hellhoundlib.a.a.c(this, "com/tencent/mm/chatroom/ui/ChatroomInfoUI", "dealModChatroomRemark", "()V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
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
    if ((this.iXp != null) && (this.iXp.hxJ() != null))
    {
      bool = v.Px(this.iXp.field_chatroomname);
      Log.i("MicroMsg.ChatroomInfoUI", "roomId:%s newVer:%s localVer:%s owner:%s", new Object[] { this.iXp.field_chatroomname, Integer.valueOf(this.iXp.field_chatroomVersion), Integer.valueOf(this.iXp.field_oldChatroomVersion), this.iXp.field_roomowner });
    }
    for (;;)
    {
      if ((v.Pn(this.roomId)) || (bool)) {
        asr();
      }
      asA();
      updateTitle();
      asz();
      Object localObject2;
      Object localObject1;
      if (this.fKN)
      {
        asB();
        if (this.contact != null)
        {
          this.iXp = ((com.tencent.mm.plugin.chatroom.a.b)com.tencent.mm.kernel.h.ae(com.tencent.mm.plugin.chatroom.a.b.class)).bbV().Rw(this.roomId);
          if (this.iXp != null) {
            break label507;
          }
          localObject2 = "";
          localObject1 = localObject2;
          if (Util.isNullOrNil((String)localObject2)) {
            localObject1 = z.bdb();
          }
          if (Util.isNullOrNil((String)localObject1)) {
            break label518;
          }
          this.iYj.hKM();
          this.iYj.WrT = com.tencent.mm.ci.a.aY(getContext(), a.c.jcb);
          KeyValuePreference localKeyValuePreference = this.iYj;
          localObject2 = localObject1;
          if (((String)localObject1).length() <= 0) {
            localObject2 = getString(a.i.settings_signature_empty);
          }
          localKeyValuePreference.aF(l.c(this, (CharSequence)localObject2));
          label268:
          if (this.screen != null) {
            this.screen.notifyDataSetChanged();
          }
        }
        if ((this.contact != null) && (this.iYk != null))
        {
          this.contact = ((com.tencent.mm.plugin.messenger.foundation.a.n)com.tencent.mm.kernel.h.ae(com.tencent.mm.plugin.messenger.foundation.a.n.class)).bbL().RG(this.roomId);
          this.iYk.hKM();
          if (!as.bvL(this.roomId)) {
            break label530;
          }
          this.screen.d(this.iYk);
        }
      }
      for (;;)
      {
        if (this.iYv)
        {
          asy();
          this.iYv = false;
        }
        localObject1 = getIntent().getStringExtra("need_matte_high_light_item");
        if (!this.iYB)
        {
          if (!Util.isNullOrNil((String)localObject1)) {
            Kw((String)localObject1);
          }
          this.iYB = true;
        }
        if ((!Util.isNullOrNil((String)localObject1)) && (((String)localObject1).equals("room_notify_new_notice")) && (!this.iYB))
        {
          Kw("room_card");
          this.iYB = true;
        }
        com.tencent.mm.plugin.newtips.a.fiO().aao(26);
        Log.d("MicroMsg.ChatroomInfoUI", "showSetMuteAnimation isShowSetMuteAnimation[%b]", new Object[] { Boolean.valueOf(this.iYx) });
        if (this.iYx)
        {
          this.iYx = false;
          MMHandlerThread.postToMainThreadDelayed(new Runnable()
          {
            public final void run()
            {
              AppMethodBeat.i(194117);
              ChatroomInfoUI.b(ChatroomInfoUI.this, "room_notify_new_msg");
              ChatroomInfoUI.B(ChatroomInfoUI.this);
              AppMethodBeat.o(194117);
            }
          }, 50L);
        }
        AppMethodBeat.o(12564);
        return;
        label507:
        localObject2 = this.iXp.field_selfDisplayName;
        break;
        label518:
        this.iYj.aF("");
        break label268;
        label530:
        if (!Util.isNullOrNil(this.contact.field_conRemark))
        {
          localObject1 = this.contact.field_conRemark;
          this.iYk.aF(l.c(this, (CharSequence)localObject1));
          if (this.screen != null) {
            this.screen.notifyDataSetChanged();
          }
        }
        else
        {
          this.iYk.aF("");
        }
      }
      bool = false;
    }
  }
  
  public void onSceneEnd(int paramInt1, int paramInt2, String paramString, com.tencent.mm.an.q paramq)
  {
    AppMethodBeat.i(12594);
    Log.i("MicroMsg.ChatroomInfoUI", "onSceneEnd: errType = " + paramInt1 + " errCode = " + paramInt2 + " errMsg = " + paramString + " type = " + paramq.getType());
    Log.d("MicroMsg.ChatroomInfoUI", "pre is " + this.iYr);
    this.iYr = v.Pu(this.roomId);
    Log.d("MicroMsg.ChatroomInfoUI", "now is " + this.iYr);
    if (this.iXX != null) {
      this.iXX.dismiss();
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
      ChatroomInfoUI.dN(true);
      AppMethodBeat.o(12560);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.chatroom.ui.ChatroomInfoUI
 * JD-Core Version:    0.7.0.1
 */