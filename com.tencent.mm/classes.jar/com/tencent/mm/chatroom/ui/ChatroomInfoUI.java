package com.tencent.mm.chatroom.ui;

import android.app.Activity;
import android.app.ProgressDialog;
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
import com.tencent.mm.g.a.il;
import com.tencent.mm.g.a.mg;
import com.tencent.mm.g.a.mg.b;
import com.tencent.mm.g.a.st;
import com.tencent.mm.g.a.vt;
import com.tencent.mm.g.a.vt.b;
import com.tencent.mm.g.a.wt;
import com.tencent.mm.g.b.a.ct;
import com.tencent.mm.g.c.av;
import com.tencent.mm.model.aj;
import com.tencent.mm.model.ar.a;
import com.tencent.mm.model.ar.b;
import com.tencent.mm.model.ar.b.a;
import com.tencent.mm.model.bi.a;
import com.tencent.mm.model.w;
import com.tencent.mm.plugin.newtips.NewTipPreference;
import com.tencent.mm.plugin.report.kvdata.IMBehavior;
import com.tencent.mm.plugin.report.kvdata.IMBehaviorChattingOP;
import com.tencent.mm.plugin.report.kvdata.log_13835;
import com.tencent.mm.pluginsdk.ui.applet.ContactListExpandPreference;
import com.tencent.mm.pluginsdk.ui.applet.ContactListExpandPreference.a;
import com.tencent.mm.pluginsdk.ui.applet.r;
import com.tencent.mm.pluginsdk.ui.applet.s.b;
import com.tencent.mm.protocal.protobuf.bpd;
import com.tencent.mm.sdk.e.k.a;
import com.tencent.mm.sdk.e.n.b;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.ao;
import com.tencent.mm.sdk.platformtools.ap;
import com.tencent.mm.sdk.platformtools.au;
import com.tencent.mm.sdk.platformtools.au.a;
import com.tencent.mm.sdk.platformtools.bs;
import com.tencent.mm.storage.ae;
import com.tencent.mm.storage.ai;
import com.tencent.mm.storage.bj;
import com.tencent.mm.storage.bk;
import com.tencent.mm.storage.bz;
import com.tencent.mm.storage.x;
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
  implements com.tencent.mm.ak.g, com.tencent.mm.bh.a, k.a, n.b
{
  private static boolean fuc = false;
  private ai contact;
  private boolean dmR;
  private ContactListExpandPreference ftA;
  private CheckBoxPreference ftB;
  private CheckBoxPreference ftC;
  private CheckBoxPreference ftD;
  private KeyValuePreference ftE;
  private KeyValuePreference ftF;
  private CheckBoxPreference ftG;
  private NewTipPreference ftH;
  private boolean ftI;
  private boolean ftJ;
  private boolean ftK;
  private boolean ftL;
  private int ftM;
  private boolean ftN;
  private boolean ftO;
  private x ftP;
  private int ftQ;
  private boolean ftR;
  private boolean ftS;
  private boolean ftT;
  private boolean ftU;
  private boolean ftV;
  private com.tencent.mm.pluginsdk.ui.d ftW;
  boolean ftX;
  private com.tencent.mm.sdk.b.c ftY;
  int ftZ;
  private ProgressDialog fts;
  private ProgressDialog ftt;
  private boolean ftu;
  private RoomCardPreference ftv;
  private Preference ftw;
  private Preference ftx;
  private NormalIconPreference fty;
  private NormalIconPreference ftz;
  private com.tencent.mm.ui.base.p fua;
  private String fub;
  private com.tencent.mm.roomsdk.a.c.a fud;
  private String fue;
  private com.tencent.mm.pluginsdk.c.b fuf;
  private au fug;
  private int fuh;
  private ao handler;
  private boolean isDeleteCancel;
  private String roomId;
  private f screen;
  private SharedPreferences sp;
  
  public ChatroomInfoUI()
  {
    AppMethodBeat.i(12561);
    this.fts = null;
    this.ftt = null;
    this.handler = new ao(Looper.getMainLooper())
    {
      public final void handleMessage(Message paramAnonymousMessage)
      {
        AppMethodBeat.i(12507);
        ChatroomInfoUI.a(ChatroomInfoUI.this);
        AppMethodBeat.o(12507);
      }
    };
    this.sp = null;
    this.ftK = false;
    this.ftL = false;
    this.ftO = false;
    this.ftP = null;
    this.ftQ = -1;
    this.ftR = true;
    this.ftS = false;
    this.ftT = false;
    this.ftU = false;
    this.ftV = false;
    this.ftW = new com.tencent.mm.pluginsdk.ui.d(new AbsListView.OnScrollListener()
    {
      public final void onScroll(AbsListView paramAnonymousAbsListView, int paramAnonymousInt1, int paramAnonymousInt2, int paramAnonymousInt3) {}
      
      public final void onScrollStateChanged(AbsListView paramAnonymousAbsListView, int paramAnonymousInt) {}
    });
    this.ftX = false;
    this.ftY = new com.tencent.mm.sdk.b.c() {};
    this.ftZ = -1;
    this.fua = null;
    this.fub = "";
    this.fud = null;
    this.fue = null;
    this.fuf = new com.tencent.mm.pluginsdk.c.b()
    {
      public final void a(int paramAnonymousInt1, int paramAnonymousInt2, String paramAnonymousString, com.tencent.mm.sdk.b.b paramAnonymousb)
      {
        AppMethodBeat.i(197075);
        if ((paramAnonymousb instanceof mg))
        {
          paramAnonymousb = (mg)paramAnonymousb;
          ac.i("MicroMsg.ChatroomInfoUI", "onSceneEnd: errType = " + paramAnonymousInt1 + " errCode = " + paramAnonymousInt2 + " errMsg = " + paramAnonymousString);
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
                  AppMethodBeat.i(197074);
                  ChatroomInfoUI.this.finish();
                  AppMethodBeat.o(197074);
                }
              });
              AppMethodBeat.o(197075);
              return;
            }
            com.tencent.mm.ui.base.h.c(ChatroomInfoUI.this, ChatroomInfoUI.this.getString(2131762628), ChatroomInfoUI.this.getString(2131755906), true);
            AppMethodBeat.o(197075);
            return;
          }
          if ((paramAnonymousInt1 == 0) && (paramAnonymousInt2 == 0) && (ChatroomInfoUI.m(ChatroomInfoUI.this) != null))
          {
            paramAnonymousString = ChatroomInfoUI.P(paramAnonymousb.doK.dow);
            paramAnonymousb = ChatroomInfoUI.m(ChatroomInfoUI.this);
            if (paramAnonymousb.DrI != null)
            {
              paramAnonymousb = paramAnonymousb.DrI.DqY;
              paramAnonymousb.aR(paramAnonymousString);
              paramAnonymousb.WJ();
            }
            if (ChatroomInfoUI.f(ChatroomInfoUI.this) != null) {
              ChatroomInfoUI.f(ChatroomInfoUI.this).notifyDataSetChanged();
            }
            ChatroomInfoUI.this.setMMTitle(ChatroomInfoUI.this.getResources().getQuantityString(2131623963, paramAnonymousString.size(), new Object[] { Integer.valueOf(paramAnonymousString.size()) }));
          }
          ChatroomInfoUI.j(ChatroomInfoUI.this);
        }
        AppMethodBeat.o(197075);
      }
    };
    this.isDeleteCancel = false;
    this.fug = null;
    this.fuh = 0;
    AppMethodBeat.o(12561);
  }
  
  public static ArrayList<ai> P(List<bpd> paramList)
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
      bpd localbpd = (bpd)paramList.next();
      ai localai = new ai();
      localai.setUsername(localbpd.ncR);
      localai.qj(localbpd.ndW);
      localArrayList.add(localai);
    }
    AppMethodBeat.o(12590);
    return localArrayList;
  }
  
  private static List<String> Q(List<String> paramList)
  {
    AppMethodBeat.i(12593);
    LinkedList localLinkedList = new LinkedList();
    if (!com.tencent.mm.kernel.g.agM())
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
      ai localai = ((com.tencent.mm.plugin.messenger.foundation.a.k)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.messenger.foundation.a.k.class)).awB().aNt(str);
      paramList = str;
      if (localai != null)
      {
        paramList = str;
        if ((int)localai.fLJ != 0) {
          paramList = localai.aaS();
        }
      }
      localLinkedList.add(paramList);
    }
    AppMethodBeat.o(12593);
    return localLinkedList;
  }
  
  private void Wa()
  {
    AppMethodBeat.i(12563);
    ac.i("MicroMsg.ChatroomInfoUI", "[doChatroomDetailCgi] :%s", new Object[] { this.roomId });
    com.tencent.mm.roomsdk.a.c.a locala = com.tencent.mm.roomsdk.a.b.aJZ(this.roomId).rU(this.roomId);
    locala.b(new com.tencent.mm.roomsdk.a.b.b() {});
    locala.csU();
    AppMethodBeat.o(12563);
  }
  
  private void Wb()
  {
    AppMethodBeat.i(197081);
    if (this.ftt == null)
    {
      getString(2131755906);
      this.ftt = com.tencent.mm.ui.base.h.b(this, getString(2131755936), false, new DialogInterface.OnCancelListener()
      {
        public final void onCancel(DialogInterface paramAnonymousDialogInterface)
        {
          AppMethodBeat.i(197060);
          ChatroomInfoUI.a(ChatroomInfoUI.this, true);
          AppMethodBeat.o(197060);
        }
      });
      AppMethodBeat.o(197081);
      return;
    }
    this.ftt.show();
    AppMethodBeat.o(197081);
  }
  
  private void Wc()
  {
    AppMethodBeat.i(197082);
    if (this.ftt != null) {
      this.ftt.dismiss();
    }
    AppMethodBeat.o(197082);
  }
  
  private void Wd()
  {
    AppMethodBeat.i(12573);
    com.tencent.mm.plugin.report.service.h.wUl.idkeyStat(219L, 7L, 1L, true);
    Object localObject = com.tencent.mm.model.q.vZ(this.roomId);
    String str = bs.n((List)localObject, ",");
    if (localObject != null) {
      this.ftM = ((List)localObject).size();
    }
    localObject = new Intent();
    ((Intent)localObject).putExtra("titile", getString(2131755234));
    ((Intent)localObject).putExtra("list_type", 1);
    ((Intent)localObject).putExtra("list_attr", kE(com.tencent.mm.ui.contact.u.IwQ));
    ((Intent)localObject).putExtra("always_select_contact", str);
    ((Intent)localObject).putExtra("scene", 3);
    boolean bool = w.ws(this.contact.field_username);
    if ((!ai.aNd(this.contact.field_username)) && (!bool)) {
      ((Intent)localObject).putExtra("without_openim", true);
    }
    if ((w.wp(this.roomId)) && (!bool)) {}
    for (bool = true;; bool = false)
    {
      ((Intent)localObject).putExtra("KBlockOpenImFav", bool);
      ((Intent)localObject).putExtra("create_group_recommend", true);
      com.tencent.mm.br.d.c(this, ".ui.contact.SelectContactUI", (Intent)localObject, 1);
      AppMethodBeat.o(12573);
      return;
    }
  }
  
  private void We()
  {
    AppMethodBeat.i(12574);
    if (this.dmR)
    {
      Wd();
      AppMethodBeat.o(12574);
      return;
    }
    Wn();
    AppMethodBeat.o(12574);
  }
  
  private void Wf()
  {
    AppMethodBeat.i(12576);
    com.tencent.mm.plugin.report.service.h.wUl.idkeyStat(219L, 8L, 1L, true);
    Object localObject = com.tencent.mm.model.q.vZ(this.roomId);
    String str = bs.n((List)localObject, ",");
    this.ftM = ((List)localObject).size();
    localObject = new Intent();
    ((Intent)localObject).putExtra("RoomInfo_Id", this.roomId);
    ((Intent)localObject).putExtra("Is_Chatroom", true);
    ((Intent)localObject).putExtra("Chatroom_member_list", str);
    ((Intent)localObject).putExtra("room_member_count", this.ftM);
    ((Intent)localObject).putExtra("Is_RoomOwner", this.ftK);
    ((Intent)localObject).putExtra("list_attr", com.tencent.mm.ui.contact.u.IwQ);
    ((Intent)localObject).putExtra("room_name", this.contact.field_username);
    ((Intent)localObject).putExtra("room_owner_name", this.ftP.field_roomowner);
    ((Intent)localObject).setClass(this, SelectDelMemberUI.class);
    startActivityForResult((Intent)localObject, 7);
    AppMethodBeat.o(12576);
  }
  
  private String Wg()
  {
    AppMethodBeat.i(12579);
    ai localai = ((com.tencent.mm.plugin.messenger.foundation.a.k)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.messenger.foundation.a.k.class)).awB().aNt(this.ftP.field_roomowner);
    if ((localai != null) && ((int)localai.fLJ > 0)) {}
    for (Object localObject2 = localai.field_conRemark;; localObject2 = null)
    {
      Object localObject1 = localObject2;
      if (bs.isNullOrNil((String)localObject2)) {
        localObject1 = se(this.ftP.field_roomowner);
      }
      localObject2 = localObject1;
      if (bs.isNullOrNil((String)localObject1))
      {
        localObject2 = localObject1;
        if (localai != null)
        {
          localObject2 = localObject1;
          if ((int)localai.fLJ > 0) {
            localObject2 = localai.aaR();
          }
        }
      }
      localObject1 = localObject2;
      if (bs.isNullOrNil((String)localObject2)) {
        localObject1 = this.ftP.field_roomowner;
      }
      AppMethodBeat.o(12579);
      return localObject1;
    }
  }
  
  private static boolean Wh()
  {
    AppMethodBeat.i(12580);
    if (bs.getInt(com.tencent.mm.m.g.ZY().getValue("ChatroomGlobalSwitch"), 1) == 1)
    {
      AppMethodBeat.o(12580);
      return true;
    }
    AppMethodBeat.o(12580);
    return false;
  }
  
  private void Wi()
  {
    AppMethodBeat.i(12584);
    if (this.ftA != null)
    {
      if (this.dmR)
      {
        com.tencent.mm.kernel.g.agU().az(new Runnable()
        {
          public final void run()
          {
            AppMethodBeat.i(197073);
            if (ChatroomInfoUI.c(ChatroomInfoUI.this) == null)
            {
              ac.w("MicroMsg.ChatroomInfoUI", "[updateRoomPref] member == null");
              AppMethodBeat.o(197073);
              return;
            }
            ChatroomInfoUI.a(ChatroomInfoUI.this, ((com.tencent.mm.plugin.chatroom.a.c)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.chatroom.a.c.class)).awK().xQ(ChatroomInfoUI.b(ChatroomInfoUI.this)));
            Object localObject1 = com.tencent.mm.model.q.vZ(ChatroomInfoUI.b(ChatroomInfoUI.this));
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
                if ((ChatroomInfoUI.c(ChatroomInfoUI.this).aMU(str)) || (ChatroomInfoUI.c(ChatroomInfoUI.this).xB(str))) {
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
            ap.f(new Runnable()
            {
              public final void run()
              {
                AppMethodBeat.i(197072);
                if (ChatroomInfoUI.e(ChatroomInfoUI.this) <= 1)
                {
                  ChatroomInfoUI.f(ChatroomInfoUI.this).cK("del_selector_btn", true);
                  ChatroomInfoUI.m(ChatroomInfoUI.this).vc(true).vd(false).eNL();
                }
                for (;;)
                {
                  ChatroomInfoUI.m(ChatroomInfoUI.this).y(ChatroomInfoUI.b(ChatroomInfoUI.this), this.fuy);
                  AppMethodBeat.o(197072);
                  return;
                  ChatroomInfoUI.m(ChatroomInfoUI.this).vc(true).vd(ChatroomInfoUI.d(ChatroomInfoUI.this)).eNL();
                }
              }
            });
            AppMethodBeat.o(197073);
          }
        });
        AppMethodBeat.o(12584);
        return;
      }
      LinkedList localLinkedList = new LinkedList();
      localLinkedList.add(this.roomId);
      this.ftA.y(this.roomId, localLinkedList);
    }
    AppMethodBeat.o(12584);
  }
  
  private void Wj()
  {
    AppMethodBeat.i(12586);
    if (this.sp == null) {
      this.sp = getSharedPreferences(getPackageName() + "_preferences", 0);
    }
    boolean bool;
    if (this.contact != null)
    {
      if (!this.dmR) {
        break label140;
      }
      if (this.contact.exT == 0)
      {
        bool = true;
        this.ftN = bool;
      }
    }
    else
    {
      label76:
      if (!this.ftN) {
        break label161;
      }
      setTitleMuteIconVisibility(0);
      if (this.ftB != null) {
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
      if (this.ftu) {
        break label76;
      }
      this.ftN = this.contact.Nw();
      break label76;
      label161:
      setTitleMuteIconVisibility(8);
      if (this.ftB != null) {
        this.sp.edit().putBoolean("room_notify_new_msg", false).commit();
      }
    }
  }
  
  private void Wk()
  {
    AppMethodBeat.i(12587);
    Object localObject;
    RoomCardPreference localRoomCardPreference;
    if ((this.contact != null) && (this.ftv != null))
    {
      localObject = com.tencent.mm.model.q.wd(this.roomId);
      if ((localObject != null) && (((String)localObject).length() > 0)) {
        break label136;
      }
      this.ftv.daU = false;
      this.contact = ((com.tencent.mm.plugin.messenger.foundation.a.k)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.messenger.foundation.a.k.class)).awB().aNt(this.roomId);
      if (!Wm()) {
        break label159;
      }
      String str = this.contact.aaS();
      localRoomCardPreference = this.ftv;
      localObject = str;
      if (str.length() <= 0) {
        localObject = getString(2131763409);
      }
    }
    label136:
    label159:
    for (localRoomCardPreference.fBG = com.tencent.mm.pluginsdk.ui.span.k.c(this, (CharSequence)localObject);; this.ftv.fBG = getString(2131762622))
    {
      this.screen.notifyDataSetChanged();
      AppMethodBeat.o(12587);
      return;
      this.ftv.daU = true;
      this.ftv.fBH = com.tencent.mm.pluginsdk.ui.span.k.c(this, (CharSequence)localObject);
      break;
    }
  }
  
  private void Wl()
  {
    AppMethodBeat.i(12588);
    if ((this.contact != null) && (this.ftw != null))
    {
      this.contact = ((com.tencent.mm.plugin.messenger.foundation.a.k)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.messenger.foundation.a.k.class)).awB().aNt(this.roomId);
      if (Wm())
      {
        String str2 = this.contact.aaR();
        Preference localPreference = this.ftw;
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
      this.ftw.setSummary(getString(2131762622));
    }
    AppMethodBeat.o(12588);
  }
  
  private boolean Wm()
  {
    AppMethodBeat.i(12589);
    String str = this.contact.field_nickname;
    if ((!bs.isNullOrNil(str)) && (str.length() <= 50))
    {
      AppMethodBeat.o(12589);
      return true;
    }
    AppMethodBeat.o(12589);
    return false;
  }
  
  private void Wn()
  {
    AppMethodBeat.i(12591);
    com.tencent.mm.plugin.report.service.h.wUl.kvStat(10170, "1");
    Object localObject = new LinkedList();
    ((List)localObject).add(this.roomId);
    ((List)localObject).add(com.tencent.mm.model.u.axw());
    localObject = bs.n((List)localObject, ",");
    Intent localIntent = new Intent();
    localIntent.putExtra("titile", getString(2131755232));
    localIntent.putExtra("list_type", 0);
    localIntent.putExtra("list_attr", kE(com.tencent.mm.ui.contact.u.IwR));
    localIntent.putExtra("always_select_contact", (String)localObject);
    localIntent.putExtra("create_group_recommend", true);
    com.tencent.mm.br.d.e(this, ".ui.contact.SelectContactUI", localIntent);
    AppMethodBeat.o(12591);
  }
  
  private void Wo()
  {
    AppMethodBeat.i(12595);
    boolean bool;
    Object localObject;
    if (this.ftA != null)
    {
      if (this.dmR)
      {
        Wi();
        this.ftA.notifyChanged();
      }
    }
    else
    {
      bool = ((com.tencent.mm.plugin.chatroom.a.c)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.chatroom.a.c.class)).VR(this.roomId);
      if (Wp()) {
        break label264;
      }
      this.screen.cK("manage_room", true);
      localObject = this.screen;
      if (bool) {
        break label259;
      }
      bool = true;
      label82:
      ((f)localObject).cK("room_manager_view", bool);
      label93:
      if (((Wp()) || (this.ftM < r.MAX_COUNT)) && ((!Wp()) || (this.ftM < r.MAX_COUNT - 1))) {
        break label323;
      }
      this.screen.cK("see_room_member", false);
      this.ftx.setTitle(getString(2131762973));
      label157:
      if (w.wq(this.roomId))
      {
        if (!Wp()) {
          break label340;
        }
        this.screen.cK("manage_room", false);
      }
    }
    for (;;)
    {
      this.screen.cK("room_manager_view", true);
      this.screen.notifyDataSetChanged();
      AppMethodBeat.o(12595);
      return;
      if (this.ftu) {
        break;
      }
      localObject = new LinkedList();
      ((List)localObject).add(this.roomId);
      this.ftA.y(this.roomId, (List)localObject);
      break;
      label259:
      bool = false;
      break label82;
      label264:
      this.screen.cK("room_manager_view", true);
      if (com.tencent.mm.model.q.wb(this.roomId) > 2)
      {
        this.screen.cK("manage_room", false);
        break label93;
      }
      this.screen.cK("manage_room", true);
      break label93;
      label323:
      this.screen.cK("see_room_member", true);
      break label157;
      label340:
      this.screen.cK("manage_room", true);
    }
  }
  
  private boolean Wp()
  {
    AppMethodBeat.i(12600);
    if ((this.ftP != null) && (this.ftP.Wp()))
    {
      AppMethodBeat.o(12600);
      return true;
    }
    AppMethodBeat.o(12600);
    return false;
  }
  
  private void bU(Context paramContext)
  {
    AppMethodBeat.i(12581);
    if (paramContext == null)
    {
      AppMethodBeat.o(12581);
      return;
    }
    if (Wh())
    {
      paramContext = new Intent();
      paramContext.putExtra("rawUrl", getString(2131757097, new Object[] { ab.eUO() }));
      paramContext.putExtra("geta8key_username", com.tencent.mm.model.u.axw());
      paramContext.putExtra("showShare", false);
      com.tencent.mm.br.d.b(this, "webview", "com.tencent.mm.plugin.webview.ui.tools.WebViewUI", paramContext);
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
  
  private void h(final String paramString1, String paramString2, int paramInt)
  {
    AppMethodBeat.i(12577);
    if ((w.wp(this.roomId)) && (!w.ws(this.roomId)) && (!com.tencent.mm.model.p.vN(paramString1)))
    {
      com.tencent.mm.ui.base.h.c(this, getString(2131762644), getString(2131755906), true);
      AppMethodBeat.o(12577);
      return;
    }
    if (sf(paramString1))
    {
      com.tencent.mm.ui.base.h.c(this, getString(2131755154), getString(2131755906), true);
      AppMethodBeat.o(12577);
      return;
    }
    paramString1 = bs.S(paramString1.split(","));
    if (paramString1 == null)
    {
      AppMethodBeat.o(12577);
      return;
    }
    paramString1 = com.tencent.mm.roomsdk.a.b.aJZ(this.roomId).a(this.roomId, paramString1, paramString2);
    paramString1.d(new com.tencent.mm.roomsdk.a.b.c() {});
    getString(2131755906);
    paramString1.a(this, getString(paramInt), true, new DialogInterface.OnCancelListener()
    {
      public final void onCancel(DialogInterface paramAnonymousDialogInterface)
      {
        AppMethodBeat.i(12531);
        paramString1.cancel();
        AppMethodBeat.o(12531);
      }
    });
    AppMethodBeat.o(12577);
  }
  
  private int kE(int paramInt)
  {
    AppMethodBeat.i(12575);
    if (!com.tencent.mm.ui.contact.u.frE())
    {
      AppMethodBeat.o(12575);
      return paramInt;
    }
    if (this.contact != null)
    {
      String str = this.contact.field_username;
      if ((ai.aNc(str)) || (ai.aNd(str)) || (w.ws(str)))
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
  
  private void sc(String paramString)
  {
    AppMethodBeat.i(12566);
    final int i = this.screen.aPP(paramString);
    paramString = getListView();
    com.tencent.mm.hellhoundlib.b.a locala = com.tencent.mm.hellhoundlib.b.c.a(i, new com.tencent.mm.hellhoundlib.b.a());
    com.tencent.mm.hellhoundlib.a.a.a(paramString, locala.aeD(), "com/tencent/mm/chatroom/ui/ChatroomInfoUI", "MatteHighLightItem", "(Ljava/lang/String;)V", "Undefined", "smoothScrollToPosition", "(I)V");
    paramString.smoothScrollToPosition(((Integer)locala.lR(0)).intValue());
    com.tencent.mm.hellhoundlib.a.a.a(paramString, "com/tencent/mm/chatroom/ui/ChatroomInfoUI", "MatteHighLightItem", "(Ljava/lang/String;)V", "Undefined", "smoothScrollToPosition", "(I)V");
    new ao().postDelayed(new Runnable()
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
  
  private String se(String paramString)
  {
    AppMethodBeat.i(12578);
    if (this.ftP == null)
    {
      AppMethodBeat.o(12578);
      return null;
    }
    paramString = this.ftP.wk(paramString);
    AppMethodBeat.o(12578);
    return paramString;
  }
  
  private boolean sf(String paramString)
  {
    AppMethodBeat.i(12592);
    if (bs.nullAsNil(com.tencent.mm.model.u.axw()).equals(paramString))
    {
      AppMethodBeat.o(12592);
      return true;
    }
    Object localObject = com.tencent.mm.model.q.vZ(this.roomId);
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
    if (this.dmR)
    {
      this.ftM = com.tencent.mm.model.q.wb(this.roomId);
      if (this.ftM == 0)
      {
        setMMTitle(getString(2131762729));
        AppMethodBeat.o(12583);
        return;
      }
      setMMTitle(getString(2131759496, new Object[] { getString(2131762729), Integer.valueOf(this.ftM) }));
    }
    AppMethodBeat.o(12583);
  }
  
  public final void a(int paramInt, com.tencent.mm.sdk.e.n paramn, Object paramObject)
  {
    AppMethodBeat.i(12596);
    if ((paramObject == null) || (!(paramObject instanceof String)))
    {
      ac.d("MicroMsg.ChatroomInfoUI", "onNotifyChange obj not String event:%d stg:%s obj:%s", new Object[] { Integer.valueOf(paramInt), paramn, paramObject });
      AppMethodBeat.o(12596);
      return;
    }
    a((String)paramObject, null);
    AppMethodBeat.o(12596);
  }
  
  public final void a(String paramString, com.tencent.mm.sdk.e.m paramm)
  {
    AppMethodBeat.i(12597);
    if (bs.isNullOrNil(paramString))
    {
      AppMethodBeat.o(12597);
      return;
    }
    if (!w.sQ(paramString))
    {
      ac.d("MicroMsg.ChatroomInfoUI", "event:" + paramString + " cancel");
      AppMethodBeat.o(12597);
      return;
    }
    ac.d("MicroMsg.ChatroomInfoUI", "event:".concat(String.valueOf(paramString)));
    if ((this.dmR) && (paramString.equals(this.roomId))) {
      com.tencent.mm.kernel.g.agU().az(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(197077);
          ChatroomInfoUI.a(ChatroomInfoUI.this, ((com.tencent.mm.plugin.chatroom.a.c)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.chatroom.a.c.class)).awK().xN(ChatroomInfoUI.b(ChatroomInfoUI.this)));
          if (ChatroomInfoUI.c(ChatroomInfoUI.this) == null)
          {
            ac.e("MicroMsg.ChatroomInfoUI", "member is null");
            AppMethodBeat.o(197077);
            return;
          }
          if (bs.isNullOrNil(ChatroomInfoUI.c(ChatroomInfoUI.this).field_roomowner))
          {
            ac.e("MicroMsg.ChatroomInfoUI", "roomowner is null");
            AppMethodBeat.o(197077);
            return;
          }
          ChatroomInfoUI.C(ChatroomInfoUI.this).sendEmptyMessage(0);
          ChatroomInfoUI.b(ChatroomInfoUI.this, ChatroomInfoUI.c(ChatroomInfoUI.this).field_roomowner.equals(com.tencent.mm.model.u.axw()));
          ChatroomInfoUI.c(ChatroomInfoUI.this, ChatroomInfoUI.c(ChatroomInfoUI.this).aMU(com.tencent.mm.model.u.axw()));
          ChatroomInfoUI.m(ChatroomInfoUI.this).aHs(ChatroomInfoUI.c(ChatroomInfoUI.this).field_roomowner);
          AppMethodBeat.o(197077);
        }
        
        public final String toString()
        {
          AppMethodBeat.i(197078);
          String str = super.toString() + "|onNotifyChange";
          AppMethodBeat.o(197078);
          return str;
        }
      });
    }
    Wo();
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
    if ((paramString1.equals(this.roomId)) && (this.ftA != null)) {
      this.ftA.notifyChanged();
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
    if (this.dmR) {
      if (this.ftM == 0)
      {
        setMMTitle(getString(2131762729));
        localObject1 = null;
        if (this.ftP != null)
        {
          localObject1 = this.ftP.field_roomowner;
          this.ftM = this.ftP.aDl().size();
        }
        if (!bs.isNullOrNil((String)localObject1)) {
          break label1388;
        }
        this.ftJ = false;
        this.ftK = false;
        this.ftL = false;
        ac.d("MicroMsg.ChatroomInfoUI", "initBaseChatRoomView()");
        this.ftA = ((ContactListExpandPreference)this.screen.aPN("roominfo_contact_anchor"));
        this.ftA.a(this.screen, this.ftA.mKey);
        this.ftz = ((NormalIconPreference)this.screen.aPN("del_selector_btn"));
        this.fty = ((NormalIconPreference)this.screen.aPN("add_selector_btn"));
        this.ftw = this.screen.aPN("room_name");
        this.ftv = ((RoomCardPreference)this.screen.aPN("room_card"));
        this.ftx = this.screen.aPN("see_room_member");
        this.ftB = ((CheckBoxPreference)this.screen.aPN("room_notify_new_msg"));
        this.ftC = ((CheckBoxPreference)this.screen.aPN("room_save_to_contact"));
        this.ftD = ((CheckBoxPreference)this.screen.aPN("room_placed_to_the_top"));
        this.ftE = ((KeyValuePreference)this.screen.aPN("room_nickname"));
        this.ftF = ((KeyValuePreference)this.screen.aPN("room_remark"));
        this.ftH = ((NewTipPreference)this.screen.aPN("manage_room"));
        this.ftA.vc(true).vd(true).eNL();
        bool = ((com.tencent.mm.plugin.chatroom.a.c)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.chatroom.a.c.class)).VR(this.roomId);
        if (Wp()) {
          break label1413;
        }
        this.screen.cK("manage_room", true);
        localObject1 = this.screen;
        if (bool) {
          break label1408;
        }
        bool = true;
        label414:
        ((f)localObject1).cK("room_manager_view", bool);
        label426:
        if (w.wq(this.roomId))
        {
          if (!Wp()) {
            break label1472;
          }
          this.screen.cK("manage_room", false);
        }
        label457:
        if (w.wp(this.roomId))
        {
          localObject1 = ((com.tencent.mm.plugin.chatroom.a.c)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.chatroom.a.c.class)).awK().xN(this.roomId);
          if ((localObject1 != null) && ((((x)localObject1).field_chatroomStatus & 0x20000) != 131072L) && ((((x)localObject1).field_chatroomStatus & 0x10000) == 65536L) && (com.tencent.mm.model.q.axr()))
          {
            this.ftV = true;
            this.ftH.a(this.screen);
            com.tencent.mm.plugin.newtips.a.dkb().h(this.ftH);
            com.tencent.mm.plugin.newtips.a.g.a(this.ftH);
          }
        }
        if (this.ftP != null)
        {
          this.ftA.aHs(this.ftP.field_roomowner);
          if (!bs.isNullOrNil(this.ftP.field_roomowner)) {
            this.ftA.DrI.DqY.Dry = true;
          }
        }
        this.ftA.eNK();
        this.ftA.eNE();
        this.screen.cK("add_selector_btn", true);
        this.screen.cK("del_selector_btn", true);
        this.screen.cK("room_name", false);
        this.screen.cK("room_qr_code", false);
        this.screen.cK("chatroom_info_chexboxes", true);
        this.screen.cK("room_card", false);
        this.screen.cK("room_upgrade_entry", true);
        this.screen.cK("chat_room_story_videos", true);
        if (((Wp()) || (this.ftM < r.MAX_COUNT)) && ((!Wp()) || (this.ftM < r.MAX_COUNT - 1))) {
          break label1489;
        }
        this.screen.cK("see_room_member", false);
        this.ftx.setTitle(getString(2131762973));
        label808:
        if (ai.aNd(this.roomId)) {
          break label1506;
        }
        this.screen.cK("room_openim_about", true);
        label832:
        ac.d("MicroMsg.ChatroomInfoUI", "updatePlaceTop()");
        if (this.sp == null) {
          this.sp = getSharedPreferences(getPackageName() + "_preferences", 0);
        }
        if (this.ftD != null)
        {
          if (this.contact == null) {
            break label1620;
          }
          this.sp.edit().putBoolean("room_placed_to_the_top", ((com.tencent.mm.plugin.messenger.foundation.a.k)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.messenger.foundation.a.k.class)).awG().aNQ(this.contact.field_username)).commit();
        }
        label943:
        this.screen.notifyDataSetChanged();
        ac.d("MicroMsg.ChatroomInfoUI", "updateSaveToContact()");
        if (this.sp == null) {
          this.sp = getSharedPreferences(getPackageName() + "_preferences", 0);
        }
        if (this.ftC == null) {
          break label1678;
        }
        localObject1 = ((com.tencent.mm.plugin.messenger.foundation.a.k)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.messenger.foundation.a.k.class)).awB().aNt(this.roomId);
        if (localObject1 != null) {
          break label1647;
        }
        ac.e("MicroMsg.ChatroomInfoUI", "contact == null !!!");
        label1046:
        ac.d("MicroMsg.ChatroomInfoUI", "updateDisplayNickname()");
        if (this.sp == null) {
          this.sp = getSharedPreferences(getPackageName() + "_preferences", 0);
        }
        localObject1 = ((com.tencent.mm.plugin.chatroom.a.c)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.chatroom.a.c.class)).awK().xN(this.roomId);
        if (localObject1 != null) {
          break label1690;
        }
        ac.e("MicroMsg.ChatroomInfoUI", "members == null !!!");
        label1133:
        this.ftQ = ((com.tencent.mm.plugin.messenger.foundation.a.k)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.messenger.foundation.a.k.class)).dcr().alz(this.roomId);
        this.ftQ = ((com.tencent.mm.plugin.messenger.foundation.a.k)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.messenger.foundation.a.k.class)).dcr().alz(this.roomId);
      }
    }
    for (;;)
    {
      if (this.ftA != null)
      {
        if ((!this.dmR) && (this.ftu)) {
          this.ftA.aQ(new ArrayList());
        }
        getListView().setOnScrollListener(this.ftW);
        this.ftA.a(this.ftW);
        this.ftA.a(new s.b()
        {
          public final boolean kF(int paramAnonymousInt)
          {
            return true;
          }
        });
        localObject1 = this.ftA;
        localObject2 = new View.OnClickListener()
        {
          public final void onClick(View paramAnonymousView)
          {
            AppMethodBeat.i(12508);
            AppMethodBeat.o(12508);
          }
        };
        if (((ContactListExpandPreference)localObject1).DrI != null) {
          ((ContactListExpandPreference)localObject1).DrI.iu = ((View.OnClickListener)localObject2);
        }
        this.ftA.a(new ContactListExpandPreference.a()
        {
          public final void a(ViewGroup paramAnonymousViewGroup, View paramAnonymousView, int paramAnonymousInt)
          {
            AppMethodBeat.i(197048);
            ChatroomInfoUI.l(ChatroomInfoUI.this);
            AppMethodBeat.o(197048);
          }
          
          public final void b(ViewGroup paramAnonymousViewGroup, View paramAnonymousView, int paramAnonymousInt)
          {
            AppMethodBeat.i(197049);
            paramAnonymousView = ChatroomInfoUI.m(ChatroomInfoUI.this).Xb(paramAnonymousInt);
            paramAnonymousViewGroup = bs.nullAsNil(ChatroomInfoUI.m(ChatroomInfoUI.this).Xd(paramAnonymousInt));
            Object localObject;
            if (bs.isNullOrNil(paramAnonymousViewGroup))
            {
              com.tencent.mm.kernel.g.agS();
              localObject = ((com.tencent.mm.plugin.messenger.foundation.a.k)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.messenger.foundation.a.k.class)).awC().alK(paramAnonymousView);
              if ((localObject != null) && (!bs.isNullOrNil(((bz)localObject).field_encryptUsername))) {
                paramAnonymousViewGroup = ((bz)localObject).field_conRemark;
              }
            }
            for (;;)
            {
              if (bs.isNullOrNil(paramAnonymousView))
              {
                AppMethodBeat.o(197049);
                return;
              }
              localObject = new Intent();
              ((Intent)localObject).putExtra("Contact_User", paramAnonymousView);
              ((Intent)localObject).putExtra("Contact_RemarkName", paramAnonymousViewGroup);
              if ((ChatroomInfoUI.n(ChatroomInfoUI.this)) && (ChatroomInfoUI.c(ChatroomInfoUI.this) != null)) {
                ((Intent)localObject).putExtra("Contact_RoomNickname", ChatroomInfoUI.c(ChatroomInfoUI.this).wk(paramAnonymousView));
              }
              ((Intent)localObject).putExtra("Contact_Nick", bs.nullAsNil(ChatroomInfoUI.m(ChatroomInfoUI.this).Xc(paramAnonymousInt)));
              ((Intent)localObject).putExtra("Contact_RoomMember", true);
              ((Intent)localObject).putExtra("room_name", ChatroomInfoUI.o(ChatroomInfoUI.this).field_username);
              paramAnonymousViewGroup = ((com.tencent.mm.plugin.messenger.foundation.a.k)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.messenger.foundation.a.k.class)).awB().aNt(paramAnonymousView);
              if ((paramAnonymousViewGroup != null) && ((int)paramAnonymousViewGroup.fLJ > 0) && (com.tencent.mm.n.b.ln(paramAnonymousViewGroup.field_type)))
              {
                st localst = new st();
                localst.dvI.intent = ((Intent)localObject);
                localst.dvI.username = paramAnonymousView;
                com.tencent.mm.sdk.b.a.GpY.l(localst);
              }
              if (ChatroomInfoUI.n(ChatroomInfoUI.this))
              {
                com.tencent.mm.plugin.report.service.h.wUl.idkeyStat(219L, 9L, 1L, true);
                if ((paramAnonymousViewGroup != null) && (paramAnonymousViewGroup.fad())) {
                  com.tencent.mm.plugin.report.service.h.wUl.kvStat(10298, paramAnonymousViewGroup.field_username + ",14");
                }
                ((Intent)localObject).putExtra("Contact_Scene", 14);
              }
              for (;;)
              {
                ((Intent)localObject).putExtra("Is_RoomOwner", ChatroomInfoUI.q(ChatroomInfoUI.this));
                ((Intent)localObject).putExtra("Contact_ChatRoomId", ChatroomInfoUI.b(ChatroomInfoUI.this));
                if (w.wq(ChatroomInfoUI.b(ChatroomInfoUI.this)))
                {
                  paramAnonymousViewGroup = new ct();
                  paramAnonymousViewGroup.kP(ChatroomInfoUI.b(ChatroomInfoUI.this));
                  paramAnonymousViewGroup.dHR = 12L;
                  paramAnonymousViewGroup.aHZ();
                }
                ((Intent)localObject).putExtra("CONTACT_INFO_UI_SOURCE", 8);
                com.tencent.mm.br.d.b(ChatroomInfoUI.this, "profile", ".ui.ContactInfoUI", (Intent)localObject);
                AppMethodBeat.o(197049);
                return;
                if (ChatroomInfoUI.p(ChatroomInfoUI.this))
                {
                  ((Intent)localObject).putExtra("Contact_Scene", 44);
                  if (!com.tencent.mm.model.u.wh(paramAnonymousViewGroup.field_username)) {
                    ((Intent)localObject).putExtra("Contact_IsLBSFriend", true);
                  }
                }
              }
            }
          }
          
          public final void c(ViewGroup paramAnonymousViewGroup, View paramAnonymousView, int paramAnonymousInt)
          {
            AppMethodBeat.i(197051);
            ChatroomInfoUI.r(ChatroomInfoUI.this);
            AppMethodBeat.o(197051);
          }
          
          public final void d(ViewGroup paramAnonymousViewGroup, View paramAnonymousView) {}
          
          public final void e(ViewGroup paramAnonymousViewGroup, View paramAnonymousView)
          {
            AppMethodBeat.i(197050);
            if (ChatroomInfoUI.m(ChatroomInfoUI.this) != null) {
              ChatroomInfoUI.m(ChatroomInfoUI.this).eNI();
            }
            AppMethodBeat.o(197050);
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
      if (this.ftP != null) {
        this.ftM = this.ftP.aDl().size();
      }
      setMMTitle(getString(2131759496, new Object[] { getString(2131762729), Integer.valueOf(this.ftM) }));
      break;
      label1388:
      this.ftJ = true;
      this.ftK = ((String)localObject1).equals(com.tencent.mm.model.u.axw());
      break label97;
      label1408:
      bool = false;
      break label414;
      label1413:
      this.screen.cK("room_manager_view", true);
      if (com.tencent.mm.model.q.wb(this.roomId) > 2)
      {
        this.screen.cK("manage_room", false);
        break label426;
      }
      this.screen.cK("manage_room", true);
      break label426;
      label1472:
      this.screen.cK("manage_room", true);
      break label457;
      label1489:
      this.screen.cK("see_room_member", true);
      break label808;
      label1506:
      this.screen.cK("chatroom_bottom_pc", true);
      this.screen.cK("room_openim_about", false);
      localObject1 = getString(2131762663);
      Object localObject2 = getString(2131762664);
      int i = ((String)localObject1).lastIndexOf((String)localObject2);
      if (i < 0) {
        break label832;
      }
      int j = ((String)localObject2).length();
      localObject1 = new SpannableStringBuilder((CharSequence)localObject1);
      ((SpannableStringBuilder)localObject1).setSpan(new ChatroomInfoUI.5(this), i, j + i, 18);
      this.screen.aPN("room_openim_about").setTitle((CharSequence)localObject1);
      break label832;
      label1620:
      this.sp.edit().putBoolean("room_placed_to_the_top", false).commit();
      break label943;
      label1647:
      this.sp.edit().putBoolean("room_save_to_contact", com.tencent.mm.n.b.ln(((av)localObject1).field_type)).commit();
      label1678:
      this.screen.notifyDataSetChanged();
      break label1046;
      label1690:
      this.ftI = ((x)localObject1).eZP();
      this.ftG = ((CheckBoxPreference)this.screen.aPN("room_msg_show_username"));
      if (this.ftG != null) {
        this.sp.edit().putBoolean("room_msg_show_username", this.ftI).commit();
      }
      this.screen.notifyDataSetChanged();
      break label1133;
      if (this.ftu)
      {
        this.ftK = false;
        this.ftL = false;
        setMMTitle(getString(2131762629));
        this.ftA = ((ContactListExpandPreference)this.screen.aPN("roominfo_contact_anchor"));
        this.ftA.a(this.screen, this.ftA.mKey);
        this.ftA.vc(false).vd(false);
        this.ftA.a(new s.b()
        {
          public final boolean kF(int paramAnonymousInt)
          {
            return true;
          }
        });
        this.screen.removeAll();
        this.screen.b(new PreferenceCategory(this));
        this.screen.b(this.ftA);
        localObject1 = this.roomId;
        localObject2 = new mg();
        ((mg)localObject2).doJ.dmD = ((String)localObject1);
        com.tencent.mm.sdk.b.a.GpY.l((com.tencent.mm.sdk.b.b)localObject2);
        getString(2131755906);
        this.fts = com.tencent.mm.ui.base.h.b(this, getString(2131762627), true, new DialogInterface.OnCancelListener()
        {
          public final void onCancel(DialogInterface paramAnonymousDialogInterface)
          {
            AppMethodBeat.i(197076);
            ChatroomInfoUI.a(this.fuC);
            AppMethodBeat.o(197076);
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
      x localx = ((com.tencent.mm.plugin.chatroom.a.c)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.chatroom.a.c.class)).awK().xN(this.roomId);
      if (localx != null)
      {
        paramInt1 = localx.eZN();
        if (Wp()) {
          break label515;
        }
        if (w.wq(this.roomId))
        {
          if ((paramInt1 & 0x1) != 1) {
            break label515;
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
        new f.a(this).aRQ(getString(2131762554)).aRU(getString(2131755884)).yi(true).p(Boolean.TRUE).aRV(getString(2131755691)).aRS(getString(2131762208)).c(new f.c()
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
        h(paramIntent, null, 2131755168);
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
        paramIntent = bs.S(paramIntent.split(","));
        paramIntent = com.tencent.mm.roomsdk.a.b.aJZ(this.roomId).a(this.roomId, paramIntent, 0);
        paramIntent.b(new com.tencent.mm.roomsdk.a.b.b() {});
        paramIntent.c(new com.tencent.mm.roomsdk.a.b.b() {});
        getString(2131755906);
        paramIntent.a(this, getString(2131762595), true, new DialogInterface.OnCancelListener()
        {
          public final void onCancel(DialogInterface paramAnonymousDialogInterface)
          {
            AppMethodBeat.i(197067);
            paramIntent.cancel();
            AppMethodBeat.o(197067);
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
            if (!bs.isNullOrNil(paramIntent))
            {
              com.tencent.mm.sdk.b.a.GpY.l(new wt());
              this.contact.qj(paramIntent);
              ((com.tencent.mm.plugin.messenger.foundation.a.k)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.messenger.foundation.a.k.class)).awB().af(this.contact);
              Wl();
            }
            AppMethodBeat.o(12569);
            return;
            if (paramInt2 == 0)
            {
              this.ftZ = -1;
              AppMethodBeat.o(12569);
              return;
              if (paramInt2 != -1) {
                break;
              }
              Wk();
              break;
            }
          }
        }
        AppMethodBeat.o(12569);
        return;
      }
      label515:
      paramInt1 = 0;
    }
  }
  
  public void onConfigurationChanged(Configuration paramConfiguration)
  {
    AppMethodBeat.i(12565);
    super.onConfigurationChanged(paramConfiguration);
    this.ftA.notifyChanged();
    AppMethodBeat.o(12565);
  }
  
  public void onCreate(final Bundle paramBundle)
  {
    AppMethodBeat.i(12562);
    super.onCreate(paramBundle);
    com.tencent.mm.kernel.g.agQ().ghe.a(480, this);
    com.tencent.mm.pluginsdk.c.b.a(mg.class.getName(), this.fuf);
    paramBundle = this.ftY.alive();
    Assert.assertNotNull(this);
    keep(paramBundle);
    com.tencent.mm.kernel.g.agR().agA().a(this);
    ((com.tencent.mm.plugin.chatroom.a.c)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.chatroom.a.c.class)).awK().add(this);
    if (com.tencent.mm.bh.g.hXW != null) {
      com.tencent.mm.bh.g.hXW.a(this);
    }
    this.roomId = getIntent().getStringExtra("RoomInfo_Id");
    this.contact = ((com.tencent.mm.plugin.messenger.foundation.a.k)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.messenger.foundation.a.k.class)).awB().aNt(this.roomId);
    this.ftR = true;
    this.dmR = getIntent().getBooleanExtra("Is_Chatroom", true);
    this.ftu = getIntent().getBooleanExtra("Is_Lbsroom", false);
    this.ftS = getIntent().getBooleanExtra("fromChatting", false);
    this.ftT = getIntent().getBooleanExtra("isShowSetMuteAnimation", false);
    this.fub = (getPackageName() + "_preferences");
    if (this.dmR)
    {
      this.ftP = ((com.tencent.mm.plugin.chatroom.a.c)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.chatroom.a.c.class)).awK().xN(this.roomId);
      if (this.ftP != null) {
        this.ftL = this.ftP.aMU(com.tencent.mm.model.u.axw());
      }
    }
    initView();
    if (this.dmR)
    {
      paramBundle = new ar.b.a()
      {
        public final void p(final String paramAnonymousString, boolean paramAnonymousBoolean)
        {
          AppMethodBeat.i(12534);
          if ((paramAnonymousBoolean) && (ChatroomInfoUI.b(ChatroomInfoUI.this).equals(paramAnonymousString))) {
            com.tencent.mm.kernel.g.agU().az(new Runnable()
            {
              public final void run()
              {
                AppMethodBeat.i(12532);
                ((com.tencent.mm.plugin.chatroom.a.c)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.chatroom.a.c.class)).awK().w(paramAnonymousString, System.currentTimeMillis());
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
      if (this.ftP == null)
      {
        ar.a.hnw.a(this.roomId, "", paramBundle);
        AppMethodBeat.o(12562);
        return;
      }
      if (System.currentTimeMillis() - this.ftP.field_modifytime >= 86400000L) {
        com.tencent.mm.kernel.g.agU().az(new Runnable()
        {
          public final void run()
          {
            AppMethodBeat.i(12543);
            ar.a.hnw.a(ChatroomInfoUI.c(ChatroomInfoUI.this).field_chatroomname, "", paramBundle);
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
    if (com.tencent.mm.bh.g.hXW != null) {
      com.tencent.mm.bh.g.hXW.a(this);
    }
    com.tencent.mm.kernel.g.agR().agA().b(this);
    com.tencent.mm.ui.h.a.dismiss();
    com.tencent.mm.kernel.g.agQ().ghe.b(480, this);
    com.tencent.mm.sdk.b.a.GpY.d(this.ftY);
    com.tencent.mm.pluginsdk.c.b.b(mg.class.getName(), this.fuf);
    if (com.tencent.mm.kernel.g.agM())
    {
      ((com.tencent.mm.plugin.messenger.foundation.a.k)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.messenger.foundation.a.k.class)).awB().b(this);
      ((com.tencent.mm.plugin.chatroom.a.c)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.chatroom.a.c.class)).awK().remove(this);
    }
    if (com.tencent.mm.bh.g.hXW != null) {
      com.tencent.mm.bh.g.hXW.b(this);
    }
    if (this.fug != null) {
      this.fug.stopTimer();
    }
    super.onDestroy();
    AppMethodBeat.o(12568);
  }
  
  public void onPause()
  {
    AppMethodBeat.i(12567);
    super.onPause();
    if ((this.ftO) && (this.dmR))
    {
      if (this.ftP == null)
      {
        AppMethodBeat.o(12567);
        return;
      }
      com.tencent.mm.model.q.a(this.roomId, this.ftP, this.ftI);
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
      paramf = com.tencent.mm.m.g.ZY().getValue("ChatRoomOwnerModTopic");
      if (bs.isNullOrNil(paramf)) {
        break label3103;
      }
    }
    label647:
    label669:
    label1438:
    label3103:
    for (int i = bs.aLy(paramf);; i = 0)
    {
      if ((this.ftP != null) && (!bs.isNullOrNil(this.ftP.field_roomowner)) && (i > 0) && (!Wp()) && (i < this.ftM)) {
        com.tencent.mm.ui.base.h.a(this, getString(2131762706, new Object[] { Wg() }), null, getString(2131755793), new DialogInterface.OnClickListener()
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
        paramf = new com.tencent.mm.hellhoundlib.b.a().ba(paramf);
        com.tencent.mm.hellhoundlib.a.a.a(this, paramf.aeD(), "com/tencent/mm/chatroom/ui/ChatroomInfoUI", "onPreferenceTreeClick", "(Lcom/tencent/mm/ui/base/preference/IPreferenceScreen;Lcom/tencent/mm/ui/base/preference/Preference;)Z", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
        startActivity((Intent)paramf.lR(0));
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/chatroom/ui/ChatroomInfoUI", "onPreferenceTreeClick", "(Lcom/tencent/mm/ui/base/preference/IPreferenceScreen;Lcom/tencent/mm/ui/base/preference/Preference;)Z", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
        com.tencent.mm.plugin.report.service.h.wUl.idkeyStat(219L, 3L, 1L, true);
        continue;
        if (paramf.equals("room_upgrade_entry"))
        {
          bU(this);
        }
        else if (paramf.equals("room_qr_code"))
        {
          if (w.wq(this.roomId))
          {
            paramf = new ct();
            paramf.kP(this.roomId);
            paramf.dHR = 6L;
            paramf.aHZ();
          }
          com.tencent.mm.plugin.report.service.h.wUl.idkeyStat(219L, 5L, 1L, true);
          paramf = new Intent();
          paramf.putExtra("from_userName", this.roomId);
          com.tencent.mm.br.d.b(this, "setting", ".ui.setting.SelfQRCodeUI", paramf);
        }
        else if (paramf.equals("room_card"))
        {
          if (this.ftP == null)
          {
            ac.w("MicroMsg.ChatroomInfoUI", "goToRoomCardUI member == null");
          }
          else
          {
            bool1 = this.ftP.aMU(com.tencent.mm.model.u.axw());
            if ((bs.isNullOrNil(com.tencent.mm.model.q.wd(this.roomId))) && (!Wp()))
            {
              com.tencent.mm.ui.base.h.d(this, getString(2131762581), null, getString(2131762582), null, null, null);
            }
            else
            {
              paramf = new Intent();
              paramf.setClass(this, RoomCardUI.class);
              paramf.putExtra("RoomInfo_Id", this.roomId);
              paramf.putExtra("room_name", this.ftv.fBG.toString());
              this.ftM = com.tencent.mm.model.q.vZ(this.roomId).size();
              paramf.putExtra("room_member_count", this.ftM);
              paramf.putExtra("room_owner_name", Wg());
              paramf.putExtra("room_notice", com.tencent.mm.model.q.wd(this.roomId));
              paramf.putExtra("room_notice_publish_time", com.tencent.mm.model.q.wf(this.roomId));
              paramf.putExtra("room_notice_editor", com.tencent.mm.model.q.we(this.roomId));
              paramf.putExtra("Is_RoomOwner", this.ftK);
              paramf.putExtra("Is_RoomManager", bool1);
              startActivityForResult(paramf, 6);
            }
          }
        }
        else
        {
          if (paramf.equals("room_notify_new_msg"))
          {
            if (!this.ftN)
            {
              bool1 = true;
              this.ftN = bool1;
              if (this.dmR)
              {
                if (!this.ftN) {
                  break label892;
                }
                i = 0;
                com.tencent.mm.roomsdk.a.b.aJZ(this.roomId).E(this.roomId, i).csU();
                this.contact = ((com.tencent.mm.plugin.messenger.foundation.a.k)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.messenger.foundation.a.k.class)).awB().aNt(this.roomId);
                this.contact.jK(i);
                ((com.tencent.mm.plugin.messenger.foundation.a.k)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.messenger.foundation.a.k.class)).awB().c(this.roomId, this.contact);
                if (this.ftU)
                {
                  paramf = com.tencent.mm.plugin.report.service.h.wUl;
                  if (!this.ftN) {
                    break label897;
                  }
                  i = 14;
                  paramf.dB(869, i);
                }
              }
              paramf = com.tencent.mm.modelstat.b.hUE;
              ??? = this.roomId;
              bool1 = this.ftN;
              if ((paramf.aIp()) && (paramf.eb(???)))
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
              paramf.hUD.oplist_.add(???);
              Wj();
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
            paramf = ((com.tencent.mm.plugin.messenger.foundation.a.k)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.messenger.foundation.a.k.class)).awB().aNt(this.roomId);
            if (paramf != null)
            {
              boolean bool2 = com.tencent.mm.n.b.ln(paramf.field_type);
              ??? = this.sp.edit();
              if (!bool2)
              {
                bool1 = true;
                ???.putBoolean("room_save_to_contact", bool1).commit();
                if (!bool2) {
                  break label1105;
                }
                paramf.aag();
                com.tencent.mm.roomsdk.a.b.aJZ(this.roomId).a(paramf, false);
                com.tencent.mm.ui.base.h.cg(this, getString(2131762677));
                com.tencent.mm.modelstat.b.hUE.W(this.roomId, false);
              }
              for (;;)
              {
                this.screen.notifyDataSetChanged();
                break;
                bool1 = false;
                break label1024;
                label1105:
                com.tencent.mm.roomsdk.a.b.aJZ(this.roomId).a(paramf, true);
                com.tencent.mm.ui.base.h.cg(this, getString(2131762693));
                com.tencent.mm.modelstat.b.hUE.W(this.roomId, true);
              }
            }
          }
          else if (paramf.equals("room_placed_to_the_top"))
          {
            paramf = getSharedPreferences(this.fub, 0);
            if (this.contact != null)
            {
              if (((com.tencent.mm.plugin.messenger.foundation.a.k)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.messenger.foundation.a.k.class)).awG().aNQ(this.contact.field_username))
              {
                w.E(this.contact.field_username, true);
                com.tencent.mm.modelstat.b.hUE.c(false, this.roomId, false);
              }
              for (;;)
              {
                paramf.edit().putBoolean("room_placed_to_the_top", ((com.tencent.mm.plugin.messenger.foundation.a.k)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.messenger.foundation.a.k.class)).awG().aNQ(this.contact.field_username)).commit();
                break;
                w.D(this.contact.field_username, true);
                com.tencent.mm.modelstat.b.hUE.c(false, this.roomId, true);
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
              paramf = getSharedPreferences(this.fub, 0).edit();
              if (!this.ftI)
              {
                bool1 = true;
                label1391:
                paramf.putBoolean("room_msg_show_username", bool1).commit();
                if (this.ftI) {
                  break label1438;
                }
              }
              for (bool1 = true;; bool1 = false)
              {
                this.ftI = bool1;
                this.ftO = true;
                break;
                bool1 = false;
                break label1391;
              }
            }
            if (!paramf.equals("room_set_chatting_background")) {
              break;
            }
            if (w.wq(this.roomId))
            {
              paramf = new ct();
              paramf.kP(this.roomId);
              paramf.dHR = 9L;
              paramf.aHZ();
            }
            paramf = new Intent();
            paramf.putExtra("isApplyToAll", false);
            paramf.putExtra("username", this.contact.field_username);
            com.tencent.mm.br.d.b(this, "setting", ".ui.setting.SettingsChattingBackgroundUI", paramf, 2);
          }
        }
      }
      if (paramf.equals("room_search_chatting_content"))
      {
        if (w.wq(this.roomId))
        {
          paramf = new ct();
          paramf.kP(this.roomId);
          paramf.dHR = 8L;
          paramf.aHZ();
        }
        paramf = new Intent();
        paramf.putExtra("detail_username", this.roomId);
        com.tencent.mm.plugin.fts.a.d.c(this, ".ui.FTSChattingConvUI", paramf);
        if ((this.ftP == null) || (this.ftP.aDl() == null)) {
          break label3098;
        }
      }
      for (i = this.ftP.aDl().size();; i = 0)
      {
        for (;;)
        {
          com.tencent.mm.plugin.report.service.h.wUl.f(14569, new Object[] { Integer.valueOf(1), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(i), Integer.valueOf(1) });
          break;
          if (paramf.equals("room_clear_chatting_history"))
          {
            if (w.wq(this.roomId))
            {
              paramf = new ct();
              paramf.kP(this.roomId);
              paramf.dHR = 11L;
              paramf.aHZ();
            }
            paramf = getString(2131759504);
            com.tencent.mm.ui.base.h.a(getContext(), paramf, "", getString(2131755694), getString(2131755691), new DialogInterface.OnClickListener()
            {
              public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
              {
                AppMethodBeat.i(197054);
                com.tencent.mm.plugin.report.service.h.wUl.f(14553, new Object[] { Integer.valueOf(3), Integer.valueOf(2), ChatroomInfoUI.b(ChatroomInfoUI.this) });
                ChatroomInfoUI.cC(false);
                paramAnonymousDialogInterface = ChatroomInfoUI.this;
                ChatroomInfoUI.this.getString(2131755906);
                final com.tencent.mm.ui.base.p localp = com.tencent.mm.ui.base.h.b(paramAnonymousDialogInterface, ChatroomInfoUI.this.getString(2131755936), true, new ChatroomInfoUI.a());
                if (!ChatroomInfoUI.Wq()) {}
                for (paramAnonymousDialogInterface = com.tencent.mm.pluginsdk.wallet.d.aIl(ChatroomInfoUI.o(ChatroomInfoUI.this).field_username);; paramAnonymousDialogInterface = null)
                {
                  if (!bs.isNullOrNil(paramAnonymousDialogInterface))
                  {
                    localp.dismiss();
                    com.tencent.mm.ui.base.h.a(ChatroomInfoUI.this, false, ChatroomInfoUI.this.getString(2131765211, new Object[] { paramAnonymousDialogInterface }), null, ChatroomInfoUI.this.getString(2131760081), ChatroomInfoUI.this.getString(2131757424), new DialogInterface.OnClickListener()new DialogInterface.OnClickListener
                    {
                      public final void onClick(DialogInterface paramAnonymous2DialogInterface, int paramAnonymous2Int)
                      {
                        AppMethodBeat.i(197052);
                        com.tencent.mm.plugin.report.service.h.wUl.f(14553, new Object[] { Integer.valueOf(3), Integer.valueOf(4), ChatroomInfoUI.b(ChatroomInfoUI.this) });
                        ChatroomInfoUI.a(ChatroomInfoUI.this, true);
                        if (!ChatroomInfoUI.s(ChatroomInfoUI.this))
                        {
                          paramAnonymous2DialogInterface = new Intent();
                          paramAnonymous2DialogInterface.putExtra("Chat_User", ChatroomInfoUI.o(ChatroomInfoUI.this).field_username);
                          paramAnonymous2DialogInterface.addFlags(67108864);
                          com.tencent.mm.br.d.e(ChatroomInfoUI.this, ".ui.chatting.ChattingUI", paramAnonymous2DialogInterface);
                          AppMethodBeat.o(197052);
                          return;
                        }
                        ChatroomInfoUI.this.finish();
                        AppMethodBeat.o(197052);
                      }
                    }, new DialogInterface.OnClickListener()
                    {
                      public final void onClick(DialogInterface paramAnonymous2DialogInterface, int paramAnonymous2Int)
                      {
                        AppMethodBeat.i(197053);
                        com.tencent.mm.plugin.report.service.h.wUl.f(14553, new Object[] { Integer.valueOf(3), Integer.valueOf(3), ChatroomInfoUI.b(ChatroomInfoUI.this) });
                        localp.show();
                        ChatroomInfoUI.a(ChatroomInfoUI.this, false);
                        ChatroomInfoUI.a(ChatroomInfoUI.this, localp);
                        AppMethodBeat.o(197053);
                      }
                    }, -1, 2131099904);
                    AppMethodBeat.o(197054);
                    return;
                  }
                  ChatroomInfoUI.a(ChatroomInfoUI.this, localp);
                  AppMethodBeat.o(197054);
                  return;
                }
              }
            }, null, 2131099904);
            break;
          }
          if (paramf.equals("room_report_it"))
          {
            if (w.wq(this.roomId))
            {
              paramf = new ct();
              paramf.kP(this.roomId);
              paramf.dHR = 10L;
              paramf.aHZ();
            }
            paramf = new Intent();
            paramf.putExtra("k_username", this.roomId);
            paramf.putExtra("showShare", false);
            paramf.putExtra("rawUrl", String.format("https://weixin110.qq.com/security/readtemplate?t=weixin_report/w_type&scene=%d#wechat_redirect", new Object[] { Integer.valueOf(36) }));
            com.tencent.mm.br.d.b(this, "webview", ".ui.tools.WebViewUI", paramf);
            paramf = com.tencent.mm.modelstat.b.hUE;
            ??? = this.roomId;
            if ((!paramf.aIp()) || (!paramf.eb(???))) {
              break;
            }
            ??? = new IMBehavior();
            ((IMBehavior)???).opType = 1;
            ((IMBehavior)???).chattingOp = new IMBehaviorChattingOP();
            ((IMBehavior)???).chattingOp.expose = 1;
            synchronized (paramf.lock)
            {
              paramf.hUD.oplist_.add(???);
            }
          }
        }
        if (paramf.equals("room_del_quit"))
        {
          ac.d("MicroMsg.ChatroomInfoUI", " quit " + this.roomId);
          paramf = new vt();
          paramf.dyB.dyD = true;
          com.tencent.mm.sdk.b.a.GpY.l(paramf);
          if ((!bs.isNullOrNil(this.roomId)) && (this.roomId.equals(paramf.dyC.dyF)))
          {
            bool1 = true;
            label2129:
            if (!bool1) {
              break label2215;
            }
            ac.d("MicroMsg.ChatroomInfoUI", " quit talkroom" + this.roomId);
          }
          label2215:
          while ((!this.ftK) || (this.ftP.aDl().size() <= 2))
          {
            com.tencent.mm.ui.base.h.a(getContext(), getString(2131758025), "", getString(2131755835), getString(2131755691), new DialogInterface.OnClickListener()
            {
              public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
              {
                AppMethodBeat.i(12519);
                if ((ChatroomInfoUI.b(ChatroomInfoUI.this) == null) || (ChatroomInfoUI.b(ChatroomInfoUI.this).length() <= 0))
                {
                  ac.e("MicroMsg.ChatroomInfoUI", "quitChatRoom : invalid args");
                  AppMethodBeat.o(12519);
                  return;
                }
                if (bool1)
                {
                  paramAnonymousDialogInterface = new vt();
                  paramAnonymousDialogInterface.dyB.dyE = true;
                  com.tencent.mm.sdk.b.a.GpY.l(paramAnonymousDialogInterface);
                }
                if (!((com.tencent.mm.plugin.messenger.foundation.a.k)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.messenger.foundation.a.k.class)).awB().aNw(ChatroomInfoUI.b(ChatroomInfoUI.this)))
                {
                  ac.e("MicroMsg.ChatroomInfoUI", "quitChatRoom : room[" + ChatroomInfoUI.b(ChatroomInfoUI.this) + "] is not exist");
                  AppMethodBeat.o(12519);
                  return;
                }
                if (((com.tencent.mm.live.a)com.tencent.mm.kernel.g.ad(com.tencent.mm.live.a.class)).isAnchorLiving())
                {
                  com.tencent.mm.ui.base.h.a(ChatroomInfoUI.this.getContext(), ChatroomInfoUI.this.getString(2131760312), null, ChatroomInfoUI.this.getString(2131755793), new DialogInterface.OnClickListener()
                  {
                    public final void onClick(DialogInterface paramAnonymous2DialogInterface, int paramAnonymous2Int)
                    {
                      AppMethodBeat.i(12517);
                      AppMethodBeat.o(12517);
                    }
                  });
                  AppMethodBeat.o(12519);
                  return;
                }
                if (((com.tencent.mm.live.a)com.tencent.mm.kernel.g.ad(com.tencent.mm.live.a.class)).isVisitorLiving()) {
                  ((com.tencent.mm.live.a)com.tencent.mm.kernel.g.ad(com.tencent.mm.live.a.class)).forceStopCurLive(ChatroomInfoUI.this.getContext());
                }
                ChatroomInfoUI.t(ChatroomInfoUI.this);
                ((com.tencent.mm.plugin.multitalk.model.a)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.multitalk.model.a.class)).amj(ChatroomInfoUI.b(ChatroomInfoUI.this));
                AppMethodBeat.o(12519);
              }
            }, null, 2131099904);
            break;
            bool1 = false;
            break label2129;
          }
          paramf = getString(2131762665);
          ??? = new h.c()
          {
            public final void kG(int paramAnonymousInt)
            {
              AppMethodBeat.i(197057);
              switch (paramAnonymousInt)
              {
              default: 
                ac.d("MicroMsg.ChatroomInfoUI", "dz[dealQuitChatRoom owner click cancel]");
                AppMethodBeat.o(197057);
                return;
              }
              ac.d("MicroMsg.ChatroomInfoUI", "dz[dealQuitChatRoom owner click room_owner_delete_direct]");
              if (((com.tencent.mm.live.a)com.tencent.mm.kernel.g.ad(com.tencent.mm.live.a.class)).isAnchorLiving())
              {
                com.tencent.mm.ui.base.h.a(ChatroomInfoUI.this.getContext(), ChatroomInfoUI.this.getString(2131760312), null, ChatroomInfoUI.this.getString(2131755793), new DialogInterface.OnClickListener()
                {
                  public final void onClick(DialogInterface paramAnonymous2DialogInterface, int paramAnonymous2Int) {}
                });
                AppMethodBeat.o(197057);
                return;
              }
              if (((com.tencent.mm.live.a)com.tencent.mm.kernel.g.ad(com.tencent.mm.live.a.class)).isVisitorLiving()) {
                ((com.tencent.mm.live.a)com.tencent.mm.kernel.g.ad(com.tencent.mm.live.a.class)).forceStopCurLive(ChatroomInfoUI.this.getContext());
              }
              ChatroomInfoUI.t(ChatroomInfoUI.this);
              ((com.tencent.mm.plugin.multitalk.model.a)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.multitalk.model.a.class)).amj(ChatroomInfoUI.b(ChatroomInfoUI.this));
              AppMethodBeat.o(197057);
            }
          };
          com.tencent.mm.ui.base.h.a(this, "", new String[] { paramf }, "", ???);
          break;
        }
        if (paramf.equals("add_selector_btn"))
        {
          We();
          break;
        }
        if (paramf.equals("del_selector_btn"))
        {
          Wf();
          break;
        }
        if (paramf.equals("see_room_member"))
        {
          paramf = new Intent();
          paramf.setClass(getContext(), SeeRoomMemberUI.class);
          paramf.putExtra("Block_list", com.tencent.mm.model.u.axw());
          ??? = com.tencent.mm.model.q.vZ(this.roomId);
          if (??? != null) {
            this.ftM = ???.size();
          }
          paramf.putExtra("Chatroom_member_list", bs.n(???, ","));
          paramf.putExtra("RoomInfo_Id", this.roomId);
          paramf.putExtra("room_owner_name", this.ftP.field_roomowner);
          paramf.putExtra("Is_RoomOwner", this.ftK);
          paramf.putExtra("room_member_count", this.ftM);
          paramf.putExtra("Add_address_titile", getString(2131762697));
          if (this.dmR)
          {
            paramf.putExtra("Contact_Scene", 14);
            label2473:
            ??? = getListView().getChildAt(0);
            if (??? != null) {
              break label2583;
            }
          }
          for (i = 0;; i = -???.getTop())
          {
            paramf.putExtra("offset", i);
            paramf.putExtra("first_pos", getListView().getFirstVisiblePosition());
            paramf.putExtra("room_name", this.contact.field_username);
            startActivityForResult(paramf, 5);
            this.ftZ = 5;
            break;
            if (!this.ftu) {
              break label2473;
            }
            paramf.putExtra("Contact_Scene", 44);
            if (com.tencent.mm.model.u.wh(this.contact.field_username)) {
              break label2473;
            }
            paramf.putExtra("Contact_IsLBSFriend", true);
            break label2473;
          }
        }
        if (paramf.equals("manage_room"))
        {
          if (this.ftV) {
            com.tencent.mm.plugin.newtips.a.dkb().Ko(26);
          }
          paramf = new Intent();
          paramf.setClass(getContext(), ManageChatroomUI.class);
          paramf.putExtra("RoomInfo_Id", this.roomId);
          paramf.putExtra("room_owner_name", this.ftP.field_roomowner);
          paramf = new com.tencent.mm.hellhoundlib.b.a().ba(paramf);
          com.tencent.mm.hellhoundlib.a.a.a(this, paramf.aeD(), "com/tencent/mm/chatroom/ui/ChatroomInfoUI", "goToManageChatroomUI", "()V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
          startActivity((Intent)paramf.lR(0));
          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/chatroom/ui/ChatroomInfoUI", "goToManageChatroomUI", "()V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
          break;
        }
        if (paramf.equals("chat_room_app_brand"))
        {
          if (w.wq(this.roomId))
          {
            paramf = new ct();
            paramf.kP(this.roomId);
            paramf.dHR = 7L;
            paramf.aHZ();
          }
          paramf = new Intent();
          paramf.putExtra("Chat_User", this.roomId);
          com.tencent.mm.br.d.e(this, ".ui.chatting.gallery.AppBrandHistoryListUI", paramf);
          com.tencent.mm.plugin.report.service.h.wUl.idkeyStat(219L, 25L, 1L, true);
          break;
        }
        if (paramf.equals("room_manager_view"))
        {
          paramf = new Intent();
          paramf.setClass(getContext(), SeeRoomOwnerManagerUI.class);
          paramf.putExtra("RoomInfo_Id", this.roomId);
          paramf.putExtra("room_owner_name", this.ftP.field_roomowner);
          paramf = new com.tencent.mm.hellhoundlib.b.a().ba(paramf);
          com.tencent.mm.hellhoundlib.a.a.a(this, paramf.aeD(), "com/tencent/mm/chatroom/ui/ChatroomInfoUI", "goToOwnerManageChatroomUI", "()V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
          startActivity((Intent)paramf.lR(0));
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
        paramf = new com.tencent.mm.hellhoundlib.b.a().ba(paramf);
        com.tencent.mm.hellhoundlib.a.a.a(this, paramf.aeD(), "com/tencent/mm/chatroom/ui/ChatroomInfoUI", "dealModChatroomRemark", "()V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
        startActivity((Intent)paramf.lR(0));
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
    if ((this.ftP != null) && (this.ftP.eZQ() != null))
    {
      bool = com.tencent.mm.model.q.GN(this.ftP.field_chatroomname);
      ac.i("MicroMsg.ChatroomInfoUI", "roomId:%s newVer:%s localVer:%s owner:%s", new Object[] { this.ftP.field_chatroomname, Integer.valueOf(this.ftP.field_chatroomVersion), Integer.valueOf(this.ftP.field_oldChatroomVersion), this.ftP.field_roomowner });
    }
    for (;;)
    {
      if ((com.tencent.mm.model.q.vU(this.roomId)) || (bool)) {
        Wa();
      }
      Wk();
      updateTitle();
      Wj();
      Object localObject2;
      Object localObject1;
      if (this.dmR)
      {
        Wl();
        if (this.contact != null)
        {
          this.ftP = ((com.tencent.mm.plugin.chatroom.a.c)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.chatroom.a.c.class)).awK().xN(this.roomId);
          if (this.ftP != null) {
            break label508;
          }
          localObject2 = "";
          localObject1 = localObject2;
          if (bs.isNullOrNil((String)localObject2)) {
            localObject1 = com.tencent.mm.model.u.axy();
          }
          if (bs.isNullOrNil((String)localObject1)) {
            break label519;
          }
          this.ftE.fjo();
          this.ftE.HFc = com.tencent.mm.cc.a.au(getContext(), 2131165587);
          KeyValuePreference localKeyValuePreference = this.ftE;
          localObject2 = localObject1;
          if (((String)localObject1).length() <= 0) {
            localObject2 = getString(2131763409);
          }
          localKeyValuePreference.setSummary(com.tencent.mm.pluginsdk.ui.span.k.c(this, (CharSequence)localObject2));
          label269:
          if (this.screen != null) {
            this.screen.notifyDataSetChanged();
          }
        }
        if ((this.contact != null) && (this.ftF != null))
        {
          this.contact = ((com.tencent.mm.plugin.messenger.foundation.a.k)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.messenger.foundation.a.k.class)).awB().aNt(this.roomId);
          this.ftF.fjo();
          if (!ai.aNd(this.roomId)) {
            break label532;
          }
          this.screen.d(this.ftF);
        }
      }
      for (;;)
      {
        if (this.ftR)
        {
          Wi();
          this.ftR = false;
        }
        localObject1 = getIntent().getStringExtra("need_matte_high_light_item");
        if (!this.ftX)
        {
          if (!bs.isNullOrNil((String)localObject1)) {
            sc((String)localObject1);
          }
          this.ftX = true;
        }
        if ((!bs.isNullOrNil((String)localObject1)) && (((String)localObject1).equals("room_notify_new_notice")) && (!this.ftX))
        {
          sc("room_card");
          this.ftX = true;
        }
        com.tencent.mm.plugin.newtips.a.dkb().Kn(26);
        ac.d("MicroMsg.ChatroomInfoUI", "showSetMuteAnimation isShowSetMuteAnimation[%b]", new Object[] { Boolean.valueOf(this.ftT) });
        if (this.ftT)
        {
          this.ftT = false;
          ap.n(new Runnable()
          {
            public final void run()
            {
              AppMethodBeat.i(12550);
              ChatroomInfoUI.b(ChatroomInfoUI.this, "room_notify_new_msg");
              ChatroomInfoUI.D(ChatroomInfoUI.this);
              AppMethodBeat.o(12550);
            }
          }, 50L);
        }
        AppMethodBeat.o(12564);
        return;
        label508:
        localObject2 = this.ftP.field_selfDisplayName;
        break;
        label519:
        this.ftE.setSummary("");
        break label269;
        label532:
        if (!bs.isNullOrNil(this.contact.field_conRemark))
        {
          localObject1 = this.contact.field_conRemark;
          this.ftF.setSummary(com.tencent.mm.pluginsdk.ui.span.k.c(this, (CharSequence)localObject1));
          if (this.screen != null) {
            this.screen.notifyDataSetChanged();
          }
        }
        else
        {
          this.ftF.setSummary("");
        }
      }
      bool = false;
    }
  }
  
  public void onSceneEnd(int paramInt1, int paramInt2, String paramString, com.tencent.mm.ak.n paramn)
  {
    AppMethodBeat.i(12594);
    ac.i("MicroMsg.ChatroomInfoUI", "onSceneEnd: errType = " + paramInt1 + " errCode = " + paramInt2 + " errMsg = " + paramString + " type = " + paramn.getType());
    ac.d("MicroMsg.ChatroomInfoUI", "pre is " + this.ftM);
    this.ftM = com.tencent.mm.model.q.wb(this.roomId);
    ac.d("MicroMsg.ChatroomInfoUI", "now is " + this.ftM);
    if (this.fts != null) {
      this.fts.dismiss();
    }
    AppMethodBeat.o(12594);
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
  
  public final void sd(final String paramString)
  {
    AppMethodBeat.i(197083);
    ac.i("MicroMsg.ChatroomInfoUI", "delete chatroom %s", new Object[] { paramString });
    this.fud = com.tencent.mm.roomsdk.a.b.aJZ(paramString).rV(paramString);
    this.fud.d(new com.tencent.mm.roomsdk.a.b.e() {}).csU();
    AppMethodBeat.o(197083);
  }
  
  static final class a
    implements DialogInterface.OnCancelListener
  {
    public final void onCancel(DialogInterface paramDialogInterface)
    {
      AppMethodBeat.i(12560);
      ChatroomInfoUI.cC(true);
      AppMethodBeat.o(12560);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.chatroom.ui.ChatroomInfoUI
 * JD-Core Version:    0.7.0.1
 */