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
import com.tencent.mm.chatroom.g.a.b;
import com.tencent.mm.chatroom.ui.preference.RoomCardPreference;
import com.tencent.mm.g.a.iu;
import com.tencent.mm.g.a.mq;
import com.tencent.mm.g.a.mq.b;
import com.tencent.mm.g.a.tl;
import com.tencent.mm.g.a.wq;
import com.tencent.mm.g.a.wq.b;
import com.tencent.mm.g.a.xq;
import com.tencent.mm.g.b.a.do;
import com.tencent.mm.model.al;
import com.tencent.mm.model.au.a;
import com.tencent.mm.model.au.b;
import com.tencent.mm.model.au.b.a;
import com.tencent.mm.model.bl.a;
import com.tencent.mm.model.x;
import com.tencent.mm.plugin.messenger.foundation.a.l;
import com.tencent.mm.plugin.newtips.NewTipPreference;
import com.tencent.mm.plugin.report.kvdata.IMBehavior;
import com.tencent.mm.plugin.report.kvdata.IMBehaviorChattingOP;
import com.tencent.mm.plugin.report.kvdata.log_13835;
import com.tencent.mm.pluginsdk.ui.applet.ContactListExpandPreference;
import com.tencent.mm.pluginsdk.ui.applet.ContactListExpandPreference.a;
import com.tencent.mm.pluginsdk.ui.applet.s.b;
import com.tencent.mm.pluginsdk.ui.span.k;
import com.tencent.mm.protocal.protobuf.buk;
import com.tencent.mm.sdk.e.k.a;
import com.tencent.mm.sdk.e.m;
import com.tencent.mm.sdk.e.n.b;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.aq;
import com.tencent.mm.sdk.platformtools.ar;
import com.tencent.mm.sdk.platformtools.aw.a;
import com.tencent.mm.sdk.platformtools.bu;
import com.tencent.mm.storage.ac;
import com.tencent.mm.storage.aj;
import com.tencent.mm.storage.an;
import com.tencent.mm.storage.bq;
import com.tencent.mm.storage.br;
import com.tencent.mm.storage.cg;
import com.tencent.mm.ui.base.h.c;
import com.tencent.mm.ui.base.p;
import com.tencent.mm.ui.base.preference.CheckBoxPreference;
import com.tencent.mm.ui.base.preference.KeyValuePreference;
import com.tencent.mm.ui.base.preference.MMPreference;
import com.tencent.mm.ui.base.preference.NormalIconPreference;
import com.tencent.mm.ui.base.preference.Preference;
import com.tencent.mm.ui.base.preference.PreferenceCategory;
import com.tencent.mm.ui.contact.u;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import junit.framework.Assert;

@com.tencent.mm.kernel.i
public class ChatroomInfoUI
  extends MMPreference
  implements com.tencent.mm.ak.f, com.tencent.mm.bh.a, a.b, k.a, n.b
{
  private static boolean fPl = false;
  private an contact;
  private boolean dzK;
  private ac fNS;
  private ProgressDialog fOC;
  private ProgressDialog fOD;
  private boolean fOE;
  private RoomCardPreference fOF;
  private Preference fOG;
  private Preference fOH;
  private NormalIconPreference fOI;
  private NormalIconPreference fOJ;
  private ContactListExpandPreference fOK;
  private CheckBoxPreference fOL;
  private CheckBoxPreference fOM;
  private CheckBoxPreference fON;
  private KeyValuePreference fOO;
  private KeyValuePreference fOP;
  private CheckBoxPreference fOQ;
  private NewTipPreference fOR;
  private boolean fOS;
  private boolean fOT;
  private boolean fOU;
  private boolean fOV;
  private int fOW;
  private boolean fOX;
  private boolean fOY;
  private int fOZ;
  private boolean fPa;
  private boolean fPb;
  private boolean fPc;
  private boolean fPd;
  private boolean fPe;
  private com.tencent.mm.pluginsdk.ui.e fPf;
  boolean fPg;
  private com.tencent.mm.sdk.b.c fPh;
  int fPi;
  private p fPj;
  private String fPk;
  private com.tencent.mm.roomsdk.a.c.a fPm;
  private String fPn;
  private com.tencent.mm.pluginsdk.c.b fPo;
  private com.tencent.mm.sdk.platformtools.aw fPp;
  private int fPq;
  private aq handler;
  private boolean isDeleteCancel;
  private String roomId;
  private com.tencent.mm.ui.base.preference.f screen;
  private SharedPreferences sp;
  
  public ChatroomInfoUI()
  {
    AppMethodBeat.i(12561);
    this.fOC = null;
    this.fOD = null;
    this.handler = new aq(Looper.getMainLooper())
    {
      public final void handleMessage(Message paramAnonymousMessage)
      {
        AppMethodBeat.i(12507);
        ChatroomInfoUI.a(ChatroomInfoUI.this);
        AppMethodBeat.o(12507);
      }
    };
    this.sp = null;
    this.fOU = false;
    this.fOV = false;
    this.fOY = false;
    this.fNS = null;
    this.fOZ = -1;
    this.fPa = true;
    this.fPb = false;
    this.fPc = false;
    this.fPd = false;
    this.fPe = false;
    this.fPf = new com.tencent.mm.pluginsdk.ui.e(new AbsListView.OnScrollListener()
    {
      public final void onScroll(AbsListView paramAnonymousAbsListView, int paramAnonymousInt1, int paramAnonymousInt2, int paramAnonymousInt3) {}
      
      public final void onScrollStateChanged(AbsListView paramAnonymousAbsListView, int paramAnonymousInt) {}
    });
    this.fPg = false;
    this.fPh = new com.tencent.mm.sdk.b.c() {};
    this.fPi = -1;
    this.fPj = null;
    this.fPk = "";
    this.fPm = null;
    this.fPn = null;
    this.fPo = new com.tencent.mm.pluginsdk.c.b()
    {
      public final void a(int paramAnonymousInt1, int paramAnonymousInt2, String paramAnonymousString, com.tencent.mm.sdk.b.b paramAnonymousb)
      {
        AppMethodBeat.i(217173);
        if ((paramAnonymousb instanceof mq))
        {
          paramAnonymousb = (mq)paramAnonymousb;
          ae.i("MicroMsg.ChatroomInfoUI", "onSceneEnd: errType = " + paramAnonymousInt1 + " errCode = " + paramAnonymousInt2 + " errMsg = " + paramAnonymousString);
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
                  AppMethodBeat.i(217172);
                  ChatroomInfoUI.this.finish();
                  AppMethodBeat.o(217172);
                }
              });
              AppMethodBeat.o(217173);
              return;
            }
            com.tencent.mm.ui.base.h.c(ChatroomInfoUI.this, ChatroomInfoUI.this.getString(2131762628), ChatroomInfoUI.this.getString(2131755906), true);
            AppMethodBeat.o(217173);
            return;
          }
          if ((paramAnonymousInt1 == 0) && (paramAnonymousInt2 == 0) && (ChatroomInfoUI.m(ChatroomInfoUI.this) != null))
          {
            paramAnonymousString = ChatroomInfoUI.R(paramAnonymousb.dBD.dBp);
            paramAnonymousb = ChatroomInfoUI.m(ChatroomInfoUI.this);
            if (paramAnonymousb.Fph != null)
            {
              paramAnonymousb = paramAnonymousb.Fph.Fox;
              paramAnonymousb.aP(paramAnonymousString);
              paramAnonymousb.Zm();
            }
            if (ChatroomInfoUI.f(ChatroomInfoUI.this) != null) {
              ChatroomInfoUI.f(ChatroomInfoUI.this).notifyDataSetChanged();
            }
            ChatroomInfoUI.this.setMMTitle(ChatroomInfoUI.this.getResources().getQuantityString(2131623963, paramAnonymousString.size(), new Object[] { Integer.valueOf(paramAnonymousString.size()) }));
          }
          ChatroomInfoUI.j(ChatroomInfoUI.this);
        }
        AppMethodBeat.o(217173);
      }
    };
    this.isDeleteCancel = false;
    this.fPp = null;
    this.fPq = 0;
    AppMethodBeat.o(12561);
  }
  
  public static ArrayList<an> R(List<buk> paramList)
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
      buk localbuk = (buk)paramList.next();
      an localan = new an();
      localan.setUsername(localbuk.nIJ);
      localan.to(localbuk.nJO);
      localArrayList.add(localan);
    }
    AppMethodBeat.o(12590);
    return localArrayList;
  }
  
  private void YD()
  {
    AppMethodBeat.i(12563);
    ae.i("MicroMsg.ChatroomInfoUI", "[doChatroomDetailCgi] :%s", new Object[] { this.roomId });
    com.tencent.mm.roomsdk.a.c.a locala = com.tencent.mm.roomsdk.a.b.aRc(this.roomId).vc(this.roomId);
    locala.b(new com.tencent.mm.roomsdk.a.b.b() {});
    locala.cAs();
    AppMethodBeat.o(12563);
  }
  
  private void YE()
  {
    AppMethodBeat.i(217186);
    if (this.fOD == null)
    {
      getString(2131755906);
      this.fOD = com.tencent.mm.ui.base.h.b(this, getString(2131755936), false, new DialogInterface.OnCancelListener()
      {
        public final void onCancel(DialogInterface paramAnonymousDialogInterface)
        {
          AppMethodBeat.i(217162);
          ChatroomInfoUI.a(ChatroomInfoUI.this, true);
          AppMethodBeat.o(217162);
        }
      });
      AppMethodBeat.o(217186);
      return;
    }
    this.fOD.show();
    AppMethodBeat.o(217186);
  }
  
  private void YF()
  {
    AppMethodBeat.i(217187);
    if (this.fOD != null) {
      this.fOD.dismiss();
    }
    AppMethodBeat.o(217187);
  }
  
  private void YG()
  {
    AppMethodBeat.i(12573);
    com.tencent.mm.plugin.report.service.g.yxI.idkeyStat(219L, 7L, 1L, true);
    Object localObject = com.tencent.mm.model.r.zA(this.roomId);
    String str = bu.m((List)localObject, ",");
    if (localObject != null) {
      this.fOW = ((List)localObject).size();
    }
    localObject = new Intent();
    ((Intent)localObject).putExtra("titile", getString(2131755234));
    ((Intent)localObject).putExtra("list_type", 1);
    ((Intent)localObject).putExtra("list_attr", ld(u.KJS));
    ((Intent)localObject).putExtra("always_select_contact", str);
    ((Intent)localObject).putExtra("scene", 3);
    boolean bool = x.zX(this.contact.field_username);
    if ((!an.aUr(this.contact.field_username)) && (!bool)) {
      ((Intent)localObject).putExtra("without_openim", true);
    }
    if ((x.zU(this.roomId)) && (!bool)) {}
    for (bool = true;; bool = false)
    {
      ((Intent)localObject).putExtra("KBlockOpenImFav", bool);
      ((Intent)localObject).putExtra("create_group_recommend", true);
      ((Intent)localObject).putExtra("is_select_record_msg_mode", x.zU(this.roomId));
      ((Intent)localObject).putExtra("menu_mode", 2);
      ((Intent)localObject).putExtra("chatroomName", this.roomId);
      com.tencent.mm.br.d.c(this, ".ui.contact.SelectContactUI", (Intent)localObject, 1);
      AppMethodBeat.o(12573);
      return;
    }
  }
  
  private void YH()
  {
    AppMethodBeat.i(12574);
    if (this.dzK)
    {
      YG();
      AppMethodBeat.o(12574);
      return;
    }
    YP();
    AppMethodBeat.o(12574);
  }
  
  private void YI()
  {
    AppMethodBeat.i(12576);
    com.tencent.mm.plugin.report.service.g.yxI.idkeyStat(219L, 8L, 1L, true);
    Object localObject = com.tencent.mm.model.r.zA(this.roomId);
    String str = bu.m((List)localObject, ",");
    this.fOW = ((List)localObject).size();
    localObject = new Intent();
    ((Intent)localObject).putExtra("RoomInfo_Id", this.roomId);
    ((Intent)localObject).putExtra("Is_Chatroom", true);
    ((Intent)localObject).putExtra("Chatroom_member_list", str);
    ((Intent)localObject).putExtra("room_member_count", this.fOW);
    ((Intent)localObject).putExtra("Is_RoomOwner", this.fOU);
    ((Intent)localObject).putExtra("list_attr", u.KJS);
    ((Intent)localObject).putExtra("room_name", this.contact.field_username);
    ((Intent)localObject).putExtra("room_owner_name", this.fNS.field_roomowner);
    ((Intent)localObject).setClass(this, SelectDelMemberUI.class);
    startActivityForResult((Intent)localObject, 7);
    AppMethodBeat.o(12576);
  }
  
  private String YJ()
  {
    AppMethodBeat.i(12579);
    an localan = ((l)com.tencent.mm.kernel.g.ab(l.class)).azF().BH(this.fNS.field_roomowner);
    if ((localan != null) && ((int)localan.ght > 0)) {}
    for (Object localObject2 = localan.field_conRemark;; localObject2 = null)
    {
      Object localObject1 = localObject2;
      if (bu.isNullOrNil((String)localObject2)) {
        localObject1 = vq(this.fNS.field_roomowner);
      }
      localObject2 = localObject1;
      if (bu.isNullOrNil((String)localObject1))
      {
        localObject2 = localObject1;
        if (localan != null)
        {
          localObject2 = localObject1;
          if ((int)localan.ght > 0) {
            localObject2 = localan.adF();
          }
        }
      }
      localObject1 = localObject2;
      if (bu.isNullOrNil((String)localObject2)) {
        localObject1 = this.fNS.field_roomowner;
      }
      AppMethodBeat.o(12579);
      return localObject1;
    }
  }
  
  private void YK()
  {
    AppMethodBeat.i(12584);
    if (this.fOK != null)
    {
      if (this.dzK)
      {
        com.tencent.e.h.MqF.aO(new Runnable()
        {
          public final void run()
          {
            AppMethodBeat.i(217171);
            if (ChatroomInfoUI.c(ChatroomInfoUI.this) == null)
            {
              ae.w("MicroMsg.ChatroomInfoUI", "[updateRoomPref] member == null");
              AppMethodBeat.o(217171);
              return;
            }
            ChatroomInfoUI.a(ChatroomInfoUI.this, ((com.tencent.mm.plugin.chatroom.a.c)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.chatroom.a.c.class)).azP().BA(ChatroomInfoUI.b(ChatroomInfoUI.this)));
            Object localObject1 = com.tencent.mm.model.r.zA(ChatroomInfoUI.b(ChatroomInfoUI.this));
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
                if ((ChatroomInfoUI.c(ChatroomInfoUI.this).aUg(str)) || (ChatroomInfoUI.c(ChatroomInfoUI.this).Bj(str))) {
                  ((LinkedList)localObject3).add(str);
                }
              }
              localObject1 = new LinkedList();
              ChatroomInfoUI.a(ChatroomInfoUI.this, 0);
            }
            Object localObject2 = localObject1;
            if (ChatroomInfoUI.e(ChatroomInfoUI.this) > com.tencent.mm.pluginsdk.ui.applet.r.MAX_COUNT + 1)
            {
              localObject2 = localObject1;
              if (localObject1 != null)
              {
                localObject1 = ((List)localObject1).subList(0, com.tencent.mm.pluginsdk.ui.applet.r.MAX_COUNT + 1);
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
            com.tencent.e.h.MqF.aM(new Runnable()
            {
              public final void run()
              {
                AppMethodBeat.i(217170);
                if (ChatroomInfoUI.e(ChatroomInfoUI.this) <= 1)
                {
                  ChatroomInfoUI.f(ChatroomInfoUI.this).cT("del_selector_btn", true);
                  ChatroomInfoUI.m(ChatroomInfoUI.this).vW(true).vX(false).fgy();
                }
                for (;;)
                {
                  ChatroomInfoUI.m(ChatroomInfoUI.this).B(ChatroomInfoUI.b(ChatroomInfoUI.this), this.fPA);
                  ChatroomInfoUI.m(ChatroomInfoUI.this).vV(true);
                  AppMethodBeat.o(217170);
                  return;
                  ChatroomInfoUI.m(ChatroomInfoUI.this).vW(true).vX(ChatroomInfoUI.d(ChatroomInfoUI.this)).fgy();
                }
              }
            });
            AppMethodBeat.o(217171);
          }
        });
        AppMethodBeat.o(12584);
        return;
      }
      LinkedList localLinkedList = new LinkedList();
      localLinkedList.add(this.roomId);
      this.fOK.B(this.roomId, localLinkedList);
    }
    AppMethodBeat.o(12584);
  }
  
  private void YL()
  {
    AppMethodBeat.i(12586);
    if (this.sp == null) {
      this.sp = getSharedPreferences(getPackageName() + "_preferences", 0);
    }
    boolean bool;
    if (this.contact != null)
    {
      if (!this.dzK) {
        break label140;
      }
      if (this.contact.eRd == 0)
      {
        bool = true;
        this.fOX = bool;
      }
    }
    else
    {
      label76:
      if (!this.fOX) {
        break label161;
      }
      setTitleMuteIconVisibility(0);
      if (this.fOL != null) {
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
      if (this.fOE) {
        break label76;
      }
      this.fOX = this.contact.Pd();
      break label76;
      label161:
      setTitleMuteIconVisibility(8);
      if (this.fOL != null) {
        this.sp.edit().putBoolean("room_notify_new_msg", false).commit();
      }
    }
  }
  
  private void YM()
  {
    AppMethodBeat.i(12587);
    Object localObject;
    RoomCardPreference localRoomCardPreference;
    if ((this.contact != null) && (this.fOF != null))
    {
      localObject = com.tencent.mm.model.r.zE(this.roomId);
      if ((localObject != null) && (((String)localObject).length() > 0)) {
        break label136;
      }
      this.fOF.dnq = false;
      this.contact = ((l)com.tencent.mm.kernel.g.ab(l.class)).azF().BH(this.roomId);
      if (!YO()) {
        break label159;
      }
      String str = this.contact.adG();
      localRoomCardPreference = this.fOF;
      localObject = str;
      if (str.length() <= 0) {
        localObject = getString(2131763409);
      }
    }
    label136:
    label159:
    for (localRoomCardPreference.fWZ = k.c(this, (CharSequence)localObject);; this.fOF.fWZ = getString(2131762622))
    {
      this.screen.notifyDataSetChanged();
      AppMethodBeat.o(12587);
      return;
      this.fOF.dnq = true;
      this.fOF.fXa = k.c(this, (CharSequence)localObject);
      break;
    }
  }
  
  private void YN()
  {
    AppMethodBeat.i(12588);
    if ((this.contact != null) && (this.fOG != null))
    {
      this.contact = ((l)com.tencent.mm.kernel.g.ab(l.class)).azF().BH(this.roomId);
      if (YO())
      {
        String str2 = this.contact.adF();
        Preference localPreference = this.fOG;
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
      this.fOG.setSummary(getString(2131762622));
    }
    AppMethodBeat.o(12588);
  }
  
  private boolean YO()
  {
    AppMethodBeat.i(12589);
    String str = this.contact.field_nickname;
    if ((!bu.isNullOrNil(str)) && (str.length() <= 50))
    {
      AppMethodBeat.o(12589);
      return true;
    }
    AppMethodBeat.o(12589);
    return false;
  }
  
  private void YP()
  {
    AppMethodBeat.i(12591);
    com.tencent.mm.plugin.report.service.g.yxI.kvStat(10170, "1");
    Object localObject = new LinkedList();
    ((List)localObject).add(this.roomId);
    ((List)localObject).add(com.tencent.mm.model.v.aAC());
    localObject = bu.m((List)localObject, ",");
    Intent localIntent = new Intent();
    localIntent.putExtra("titile", getString(2131755232));
    localIntent.putExtra("list_type", 0);
    localIntent.putExtra("list_attr", ld(u.KJT));
    localIntent.putExtra("always_select_contact", (String)localObject);
    localIntent.putExtra("create_group_recommend", true);
    com.tencent.mm.br.d.f(this, ".ui.contact.SelectContactUI", localIntent);
    AppMethodBeat.o(12591);
  }
  
  private boolean YQ()
  {
    AppMethodBeat.i(12600);
    if ((this.fNS != null) && (this.fNS.YQ()))
    {
      AppMethodBeat.o(12600);
      return true;
    }
    AppMethodBeat.o(12600);
    return false;
  }
  
  private int ld(int paramInt)
  {
    AppMethodBeat.i(12575);
    if (!u.fMJ())
    {
      AppMethodBeat.o(12575);
      return paramInt;
    }
    if (this.contact != null)
    {
      String str = this.contact.field_username;
      if ((an.aUq(str)) || (an.aUr(str)) || (x.zX(str)))
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
    if (this.dzK)
    {
      this.fOW = com.tencent.mm.model.r.zC(this.roomId);
      if (this.fOW == 0)
      {
        setMMTitle(getString(2131762729));
        AppMethodBeat.o(12583);
        return;
      }
      setMMTitle(getString(2131759496, new Object[] { getString(2131762729), Integer.valueOf(this.fOW) }));
    }
    AppMethodBeat.o(12583);
  }
  
  private void vo(String paramString)
  {
    AppMethodBeat.i(12566);
    final int i = this.screen.aXg(paramString);
    paramString = getListView();
    com.tencent.mm.hellhoundlib.b.a locala = com.tencent.mm.hellhoundlib.b.c.a(i, new com.tencent.mm.hellhoundlib.b.a());
    com.tencent.mm.hellhoundlib.a.a.a(paramString, locala.ahE(), "com/tencent/mm/chatroom/ui/ChatroomInfoUI", "MatteHighLightItem", "(Ljava/lang/String;)V", "Undefined", "smoothScrollToPosition", "(I)V");
    paramString.smoothScrollToPosition(((Integer)locala.mt(0)).intValue());
    com.tencent.mm.hellhoundlib.a.a.a(paramString, "com/tencent/mm/chatroom/ui/ChatroomInfoUI", "MatteHighLightItem", "(Ljava/lang/String;)V", "Undefined", "smoothScrollToPosition", "(I)V");
    new aq().postDelayed(new Runnable()
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
  
  private String vq(String paramString)
  {
    AppMethodBeat.i(12578);
    if (this.fNS == null)
    {
      AppMethodBeat.o(12578);
      return null;
    }
    paramString = this.fNS.zP(paramString);
    AppMethodBeat.o(12578);
    return paramString;
  }
  
  public final void Yv()
  {
    AppMethodBeat.i(217190);
    boolean bool;
    Object localObject;
    if (this.fOK != null)
    {
      if (this.dzK)
      {
        YK();
        this.fOK.notifyChanged();
      }
    }
    else
    {
      bool = ((com.tencent.mm.plugin.chatroom.a.c)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.chatroom.a.c.class)).aar(this.roomId);
      if (YQ()) {
        break label243;
      }
      this.screen.cT("manage_room", true);
      localObject = this.screen;
      if (bool) {
        break label238;
      }
      bool = true;
      label82:
      ((com.tencent.mm.ui.base.preference.f)localObject).cT("room_manager_view", bool);
      label93:
      if (((YQ()) || (this.fOW < com.tencent.mm.pluginsdk.ui.applet.r.MAX_COUNT)) && ((!YQ()) || (this.fOW < com.tencent.mm.pluginsdk.ui.applet.r.MAX_COUNT - 1))) {
        break label274;
      }
      this.screen.cT("see_room_member", false);
      this.fOH.setTitle(getString(2131762973));
    }
    for (;;)
    {
      if (x.zV(this.roomId)) {
        this.screen.cT("room_manager_view", true);
      }
      this.screen.notifyDataSetChanged();
      AppMethodBeat.o(217190);
      return;
      if (this.fOE) {
        break;
      }
      localObject = new LinkedList();
      ((List)localObject).add(this.roomId);
      this.fOK.B(this.roomId, (List)localObject);
      break;
      label238:
      bool = false;
      break label82;
      label243:
      this.screen.cT("room_manager_view", true);
      this.screen.cT("manage_room", false);
      break label93;
      label274:
      this.screen.cT("see_room_member", true);
    }
  }
  
  public final void Yw()
  {
    AppMethodBeat.i(217189);
    updateTitle();
    if (this.fNS != null) {
      this.fOW = this.fNS.aGE().size();
    }
    if (((!this.fOU) && (this.fOW >= com.tencent.mm.pluginsdk.ui.applet.r.MAX_COUNT)) || ((this.fOU) && (this.fOW >= com.tencent.mm.pluginsdk.ui.applet.r.MAX_COUNT - 1)))
    {
      this.screen.cT("see_room_member", false);
      this.fOH.setTitle(getString(2131762973));
    }
    AppMethodBeat.o(217189);
  }
  
  public final void a(int paramInt, com.tencent.mm.sdk.e.n paramn, Object paramObject)
  {
    AppMethodBeat.i(12596);
    if ((paramObject == null) || (!(paramObject instanceof String)))
    {
      ae.d("MicroMsg.ChatroomInfoUI", "onNotifyChange obj not String event:%d stg:%s obj:%s", new Object[] { Integer.valueOf(paramInt), paramn, paramObject });
      AppMethodBeat.o(12596);
      return;
    }
    a((String)paramObject, null);
    AppMethodBeat.o(12596);
  }
  
  public final void a(String paramString, m paramm)
  {
    AppMethodBeat.i(12597);
    if (bu.isNullOrNil(paramString))
    {
      AppMethodBeat.o(12597);
      return;
    }
    if (!x.wb(paramString))
    {
      ae.d("MicroMsg.ChatroomInfoUI", "event:" + paramString + " cancel");
      AppMethodBeat.o(12597);
      return;
    }
    ae.d("MicroMsg.ChatroomInfoUI", "event:".concat(String.valueOf(paramString)));
    if ((this.dzK) && (paramString.equals(this.roomId))) {
      com.tencent.mm.kernel.g.ajU().aw(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(217175);
          ChatroomInfoUI.a(ChatroomInfoUI.this, ((com.tencent.mm.plugin.chatroom.a.c)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.chatroom.a.c.class)).azP().Bx(ChatroomInfoUI.b(ChatroomInfoUI.this)));
          if (ChatroomInfoUI.c(ChatroomInfoUI.this) == null)
          {
            ae.e("MicroMsg.ChatroomInfoUI", "member is null");
            AppMethodBeat.o(217175);
            return;
          }
          if (bu.isNullOrNil(ChatroomInfoUI.c(ChatroomInfoUI.this).field_roomowner))
          {
            ae.e("MicroMsg.ChatroomInfoUI", "roomowner is null");
            AppMethodBeat.o(217175);
            return;
          }
          ChatroomInfoUI.A(ChatroomInfoUI.this).sendEmptyMessage(0);
          ChatroomInfoUI.b(ChatroomInfoUI.this, ChatroomInfoUI.c(ChatroomInfoUI.this).field_roomowner.equals(com.tencent.mm.model.v.aAC()));
          ChatroomInfoUI.c(ChatroomInfoUI.this, ChatroomInfoUI.c(ChatroomInfoUI.this).aUg(com.tencent.mm.model.v.aAC()));
          ChatroomInfoUI.m(ChatroomInfoUI.this).aOr(ChatroomInfoUI.c(ChatroomInfoUI.this).field_roomowner);
          AppMethodBeat.o(217175);
        }
        
        public final String toString()
        {
          AppMethodBeat.i(217176);
          String str = super.toString() + "|onNotifyChange";
          AppMethodBeat.o(217176);
          return str;
        }
      });
    }
    Yv();
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
    if ((paramString1.equals(this.roomId)) && (this.fOK != null)) {
      this.fOK.notifyChanged();
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
    if (this.dzK) {
      if (this.fOW == 0)
      {
        setMMTitle(getString(2131762729));
        localObject1 = null;
        if (this.fNS != null)
        {
          localObject1 = this.fNS.field_roomowner;
          this.fOW = this.fNS.aGE().size();
        }
        if (!bu.isNullOrNil((String)localObject1)) {
          break label1363;
        }
        this.fOT = false;
        this.fOU = false;
        this.fOV = false;
        ae.d("MicroMsg.ChatroomInfoUI", "initBaseChatRoomView()");
        this.fOK = ((ContactListExpandPreference)this.screen.aXe("roominfo_contact_anchor"));
        this.fOK.a(this.screen, this.fOK.mKey);
        this.fOJ = ((NormalIconPreference)this.screen.aXe("del_selector_btn"));
        this.fOI = ((NormalIconPreference)this.screen.aXe("add_selector_btn"));
        this.fOG = this.screen.aXe("room_name");
        this.fOF = ((RoomCardPreference)this.screen.aXe("room_card"));
        this.fOH = this.screen.aXe("see_room_member");
        this.fOL = ((CheckBoxPreference)this.screen.aXe("room_notify_new_msg"));
        this.fOM = ((CheckBoxPreference)this.screen.aXe("room_save_to_contact"));
        this.fON = ((CheckBoxPreference)this.screen.aXe("room_placed_to_the_top"));
        this.fOO = ((KeyValuePreference)this.screen.aXe("room_nickname"));
        this.fOP = ((KeyValuePreference)this.screen.aXe("room_remark"));
        this.fOR = ((NewTipPreference)this.screen.aXe("manage_room"));
        this.fOK.vW(true).vX(true).fgy();
        bool = ((com.tencent.mm.plugin.chatroom.a.c)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.chatroom.a.c.class)).aar(this.roomId);
        if (YQ()) {
          break label1388;
        }
        this.screen.cT("manage_room", true);
        localObject1 = this.screen;
        if (bool) {
          break label1383;
        }
        bool = true;
        label414:
        ((com.tencent.mm.ui.base.preference.f)localObject1).cT("room_manager_view", bool);
        label426:
        if ((x.zU(this.roomId)) && (com.tencent.mm.model.r.aAy()))
        {
          localObject1 = ((com.tencent.mm.plugin.chatroom.a.c)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.chatroom.a.c.class)).azP().Bx(this.roomId);
          if ((localObject1 != null) && ((((ac)localObject1).field_chatroomStatus & 0x20000) != 131072L) && ((((ac)localObject1).field_chatroomStatus & 0x10000) == 65536L) && (com.tencent.mm.model.r.aAw()))
          {
            this.fPe = true;
            this.fOR.a(this.screen);
            com.tencent.mm.plugin.newtips.a.dxD().h(this.fOR);
            com.tencent.mm.plugin.newtips.a.g.a(this.fOR);
          }
        }
        if (this.fNS != null)
        {
          this.fOK.aOr(this.fNS.field_roomowner);
          if (!bu.isNullOrNil(this.fNS.field_roomowner)) {
            this.fOK.Fph.Fox.FoX = true;
          }
        }
        this.fOK.fgx();
        this.fOK.fgr();
        this.screen.cT("add_selector_btn", true);
        this.screen.cT("del_selector_btn", true);
        this.screen.cT("room_name", false);
        this.screen.cT("room_qr_code", false);
        this.screen.cT("chatroom_info_chexboxes", true);
        this.screen.cT("room_card", false);
        this.screen.cT("room_upgrade_entry", true);
        this.screen.cT("chat_room_story_videos", true);
        if (((YQ()) || (this.fOW < com.tencent.mm.pluginsdk.ui.applet.r.MAX_COUNT)) && ((!YQ()) || (this.fOW < com.tencent.mm.pluginsdk.ui.applet.r.MAX_COUNT - 1))) {
          break label1419;
        }
        this.screen.cT("see_room_member", false);
        this.fOH.setTitle(getString(2131762973));
        label783:
        if (an.aUr(this.roomId)) {
          break label1436;
        }
        this.screen.cT("room_openim_about", true);
        label807:
        ae.d("MicroMsg.ChatroomInfoUI", "updatePlaceTop()");
        if (this.sp == null) {
          this.sp = getSharedPreferences(getPackageName() + "_preferences", 0);
        }
        if (this.fON != null)
        {
          if (this.contact == null) {
            break label1550;
          }
          this.sp.edit().putBoolean("room_placed_to_the_top", ((l)com.tencent.mm.kernel.g.ab(l.class)).azL().aVi(this.contact.field_username)).commit();
        }
        label918:
        this.screen.notifyDataSetChanged();
        ae.d("MicroMsg.ChatroomInfoUI", "updateSaveToContact()");
        if (this.sp == null) {
          this.sp = getSharedPreferences(getPackageName() + "_preferences", 0);
        }
        if (this.fOM == null) {
          break label1608;
        }
        localObject1 = ((l)com.tencent.mm.kernel.g.ab(l.class)).azF().BH(this.roomId);
        if (localObject1 != null) {
          break label1577;
        }
        ae.e("MicroMsg.ChatroomInfoUI", "contact == null !!!");
        label1021:
        ae.d("MicroMsg.ChatroomInfoUI", "updateDisplayNickname()");
        if (this.sp == null) {
          this.sp = getSharedPreferences(getPackageName() + "_preferences", 0);
        }
        localObject1 = ((com.tencent.mm.plugin.chatroom.a.c)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.chatroom.a.c.class)).azP().Bx(this.roomId);
        if (localObject1 != null) {
          break label1620;
        }
        ae.e("MicroMsg.ChatroomInfoUI", "members == null !!!");
        label1108:
        this.fOZ = ((l)com.tencent.mm.kernel.g.ab(l.class)).doJ().ars(this.roomId);
        this.fOZ = ((l)com.tencent.mm.kernel.g.ab(l.class)).doJ().ars(this.roomId);
      }
    }
    for (;;)
    {
      if (this.fOK != null)
      {
        if ((!this.dzK) && (this.fOE)) {
          this.fOK.aO(new ArrayList());
        }
        getListView().setOnScrollListener(this.fPf);
        this.fOK.a(this.fPf);
        this.fOK.a(new s.b()
        {
          public final boolean lg(int paramAnonymousInt)
          {
            return true;
          }
        });
        localObject1 = this.fOK;
        localObject2 = new ChatroomInfoUI.33(this);
        if (((ContactListExpandPreference)localObject1).Fph != null) {
          ((ContactListExpandPreference)localObject1).Fph.km = ((View.OnClickListener)localObject2);
        }
        this.fOK.a(new ContactListExpandPreference.a()
        {
          public final void YS()
          {
            AppMethodBeat.i(217150);
            if (ChatroomInfoUI.m(ChatroomInfoUI.this) != null) {
              ChatroomInfoUI.m(ChatroomInfoUI.this).fgv();
            }
            AppMethodBeat.o(217150);
          }
          
          public final void e(ViewGroup paramAnonymousViewGroup, int paramAnonymousInt)
          {
            AppMethodBeat.i(217149);
            String str = ChatroomInfoUI.m(ChatroomInfoUI.this).ZD(paramAnonymousInt);
            paramAnonymousViewGroup = bu.nullAsNil(ChatroomInfoUI.m(ChatroomInfoUI.this).ZF(paramAnonymousInt));
            Object localObject;
            if (bu.isNullOrNil(paramAnonymousViewGroup))
            {
              com.tencent.mm.kernel.g.ajS();
              localObject = ((l)com.tencent.mm.kernel.g.ab(l.class)).azG().arE(str);
              if ((localObject != null) && (!bu.isNullOrNil(((cg)localObject).field_encryptUsername))) {
                paramAnonymousViewGroup = ((cg)localObject).field_conRemark;
              }
            }
            for (;;)
            {
              if (bu.isNullOrNil(str))
              {
                AppMethodBeat.o(217149);
                return;
              }
              localObject = new Intent();
              ((Intent)localObject).putExtra("Contact_User", str);
              ((Intent)localObject).putExtra("Contact_RemarkName", paramAnonymousViewGroup);
              if ((ChatroomInfoUI.n(ChatroomInfoUI.this)) && (ChatroomInfoUI.c(ChatroomInfoUI.this) != null)) {
                ((Intent)localObject).putExtra("Contact_RoomNickname", ChatroomInfoUI.c(ChatroomInfoUI.this).zP(str));
              }
              ((Intent)localObject).putExtra("Contact_Nick", bu.nullAsNil(ChatroomInfoUI.m(ChatroomInfoUI.this).ZE(paramAnonymousInt)));
              ((Intent)localObject).putExtra("Contact_RoomMember", true);
              ((Intent)localObject).putExtra("room_name", ChatroomInfoUI.o(ChatroomInfoUI.this).field_username);
              paramAnonymousViewGroup = ((l)com.tencent.mm.kernel.g.ab(l.class)).azF().BH(str);
              if ((paramAnonymousViewGroup != null) && ((int)paramAnonymousViewGroup.ght > 0) && (com.tencent.mm.contact.c.lO(paramAnonymousViewGroup.field_type)))
              {
                tl localtl = new tl();
                localtl.dIV.intent = ((Intent)localObject);
                localtl.dIV.username = str;
                com.tencent.mm.sdk.b.a.IvT.l(localtl);
              }
              if (ChatroomInfoUI.n(ChatroomInfoUI.this))
              {
                com.tencent.mm.plugin.report.service.g.yxI.idkeyStat(219L, 9L, 1L, true);
                if ((paramAnonymousViewGroup != null) && (paramAnonymousViewGroup.fug())) {
                  com.tencent.mm.plugin.report.service.g.yxI.kvStat(10298, paramAnonymousViewGroup.field_username + ",14");
                }
                ((Intent)localObject).putExtra("Contact_Scene", 14);
              }
              for (;;)
              {
                ((Intent)localObject).putExtra("Is_RoomOwner", ChatroomInfoUI.q(ChatroomInfoUI.this));
                ((Intent)localObject).putExtra("Contact_ChatRoomId", ChatroomInfoUI.b(ChatroomInfoUI.this));
                if (x.zV(ChatroomInfoUI.b(ChatroomInfoUI.this)))
                {
                  paramAnonymousViewGroup = new do();
                  paramAnonymousViewGroup.nl(ChatroomInfoUI.b(ChatroomInfoUI.this));
                  paramAnonymousViewGroup.dWm = 12L;
                  paramAnonymousViewGroup.aLH();
                }
                ((Intent)localObject).putExtra("CONTACT_INFO_UI_SOURCE", 8);
                com.tencent.mm.br.d.b(ChatroomInfoUI.this, "profile", ".ui.ContactInfoUI", (Intent)localObject);
                AppMethodBeat.o(217149);
                return;
                if (ChatroomInfoUI.p(ChatroomInfoUI.this))
                {
                  ((Intent)localObject).putExtra("Contact_Scene", 44);
                  if (!com.tencent.mm.model.v.zK(paramAnonymousViewGroup.field_username)) {
                    ((Intent)localObject).putExtra("Contact_IsLBSFriend", true);
                  }
                }
              }
            }
          }
          
          public final void le(int paramAnonymousInt)
          {
            AppMethodBeat.i(217148);
            ChatroomInfoUI.l(ChatroomInfoUI.this);
            AppMethodBeat.o(217148);
          }
          
          public final void lf(int paramAnonymousInt)
          {
            AppMethodBeat.i(217151);
            ChatroomInfoUI.r(ChatroomInfoUI.this);
            AppMethodBeat.o(217151);
          }
        });
      }
      setBackBtn(new MenuItem.OnMenuItemClickListener()
      {
        public final boolean onMenuItemClick(MenuItem paramAnonymousMenuItem)
        {
          AppMethodBeat.i(217152);
          ChatroomInfoUI.this.finish();
          AppMethodBeat.o(217152);
          return true;
        }
      });
      AppMethodBeat.o(12570);
      return;
      if (this.fNS != null) {
        this.fOW = this.fNS.aGE().size();
      }
      setMMTitle(getString(2131759496, new Object[] { getString(2131762729), Integer.valueOf(this.fOW) }));
      break;
      label1363:
      this.fOT = true;
      this.fOU = ((String)localObject1).equals(com.tencent.mm.model.v.aAC());
      break label97;
      label1383:
      bool = false;
      break label414;
      label1388:
      this.screen.cT("room_manager_view", true);
      this.screen.cT("manage_room", false);
      break label426;
      label1419:
      this.screen.cT("see_room_member", true);
      break label783;
      label1436:
      this.screen.cT("chatroom_bottom_pc", true);
      this.screen.cT("room_openim_about", false);
      localObject1 = getString(2131762663);
      Object localObject2 = getString(2131762664);
      int i = ((String)localObject1).lastIndexOf((String)localObject2);
      if (i < 0) {
        break label807;
      }
      int j = ((String)localObject2).length();
      localObject1 = new SpannableStringBuilder((CharSequence)localObject1);
      ((SpannableStringBuilder)localObject1).setSpan(new ChatroomInfoUI.4(this), i, j + i, 18);
      this.screen.aXe("room_openim_about").setTitle((CharSequence)localObject1);
      break label807;
      label1550:
      this.sp.edit().putBoolean("room_placed_to_the_top", false).commit();
      break label918;
      label1577:
      this.sp.edit().putBoolean("room_save_to_contact", com.tencent.mm.contact.c.lO(((com.tencent.mm.g.c.aw)localObject1).field_type)).commit();
      label1608:
      this.screen.notifyDataSetChanged();
      break label1021;
      label1620:
      this.fOS = ((ac)localObject1).ftR();
      this.fOQ = ((CheckBoxPreference)this.screen.aXe("room_msg_show_username"));
      if (this.fOQ != null) {
        this.sp.edit().putBoolean("room_msg_show_username", this.fOS).commit();
      }
      this.screen.notifyDataSetChanged();
      break label1108;
      if (this.fOE)
      {
        this.fOU = false;
        this.fOV = false;
        setMMTitle(getString(2131762629));
        this.fOK = ((ContactListExpandPreference)this.screen.aXe("roominfo_contact_anchor"));
        this.fOK.a(this.screen, this.fOK.mKey);
        this.fOK.vW(false).vX(false);
        this.fOK.a(new s.b()
        {
          public final boolean lg(int paramAnonymousInt)
          {
            return true;
          }
        });
        this.screen.removeAll();
        this.screen.b(new PreferenceCategory(this));
        this.screen.b(this.fOK);
        localObject1 = this.roomId;
        localObject2 = new mq();
        ((mq)localObject2).dBC.dzw = ((String)localObject1);
        com.tencent.mm.sdk.b.a.IvT.l((com.tencent.mm.sdk.b.b)localObject2);
        getString(2131755906);
        this.fOC = com.tencent.mm.ui.base.h.b(this, getString(2131762627), true, new DialogInterface.OnCancelListener()
        {
          public final void onCancel(DialogInterface paramAnonymousDialogInterface)
          {
            AppMethodBeat.i(217174);
            ChatroomInfoUI.a(this.fPD);
            AppMethodBeat.o(217174);
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
        ((com.tencent.mm.plugin.messenger.foundation.a.v)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.messenger.foundation.a.v.class)).Kk(3);
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
      paramIntent = bu.U(paramIntent.split(","));
      paramIntent = com.tencent.mm.roomsdk.a.b.aRc(this.roomId).a(this.roomId, paramIntent, 0);
      paramIntent.b(new com.tencent.mm.roomsdk.a.b.b() {});
      paramIntent.c(new com.tencent.mm.roomsdk.a.b.b() {});
      getString(2131755906);
      paramIntent.a(this, getString(2131762595), true, new DialogInterface.OnCancelListener()
      {
        public final void onCancel(DialogInterface paramAnonymousDialogInterface)
        {
          AppMethodBeat.i(217169);
          paramIntent.cancel();
          AppMethodBeat.o(217169);
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
      if (!bu.isNullOrNil(paramIntent))
      {
        com.tencent.mm.sdk.b.a.IvT.l(new xq());
        this.contact.to(paramIntent);
        ((l)com.tencent.mm.kernel.g.ab(l.class)).azF().am(this.contact);
        YN();
      }
      AppMethodBeat.o(12569);
      return;
      if (paramInt2 != 0) {
        break;
      }
      this.fPi = -1;
      AppMethodBeat.o(12569);
      return;
      if (paramInt2 == -1) {
        YM();
      }
    }
    AppMethodBeat.o(12569);
  }
  
  public void onConfigurationChanged(Configuration paramConfiguration)
  {
    AppMethodBeat.i(12565);
    super.onConfigurationChanged(paramConfiguration);
    this.fOK.notifyChanged();
    AppMethodBeat.o(12565);
  }
  
  public void onCreate(final Bundle paramBundle)
  {
    AppMethodBeat.i(12562);
    super.onCreate(paramBundle);
    com.tencent.mm.kernel.g.ajQ().gDv.a(480, this);
    com.tencent.mm.pluginsdk.c.b.a(mq.class.getName(), this.fPo);
    paramBundle = this.fPh.alive();
    Assert.assertNotNull(this);
    keep(paramBundle);
    com.tencent.mm.kernel.g.ajR().ajA().a(this);
    ((com.tencent.mm.plugin.chatroom.a.c)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.chatroom.a.c.class)).azP().add(this);
    if (com.tencent.mm.bh.g.ium != null) {
      com.tencent.mm.bh.g.ium.a(this);
    }
    this.roomId = getIntent().getStringExtra("RoomInfo_Id");
    this.contact = ((l)com.tencent.mm.kernel.g.ab(l.class)).azF().BH(this.roomId);
    this.fPa = true;
    this.dzK = getIntent().getBooleanExtra("Is_Chatroom", true);
    this.fOE = getIntent().getBooleanExtra("Is_Lbsroom", false);
    this.fPb = getIntent().getBooleanExtra("fromChatting", false);
    this.fPc = getIntent().getBooleanExtra("isShowSetMuteAnimation", false);
    this.fPk = (getPackageName() + "_preferences");
    if (this.dzK)
    {
      this.fNS = ((com.tencent.mm.plugin.chatroom.a.c)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.chatroom.a.c.class)).azP().Bx(this.roomId);
      if (this.fNS != null) {
        this.fOV = this.fNS.aUg(com.tencent.mm.model.v.aAC());
      }
    }
    initView();
    if (this.dzK)
    {
      paramBundle = new ChatroomInfoUI.20(this);
      if (this.fNS == null)
      {
        au.a.hIG.a(this.roomId, "", paramBundle);
        AppMethodBeat.o(12562);
        return;
      }
      if (System.currentTimeMillis() - this.fNS.field_modifytime >= 86400000L) {
        com.tencent.mm.kernel.g.ajU().aw(new Runnable()
        {
          public final void run()
          {
            AppMethodBeat.i(12543);
            au.a.hIG.a(ChatroomInfoUI.c(ChatroomInfoUI.this).field_chatroomname, "", paramBundle);
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
    if (com.tencent.mm.bh.g.ium != null) {
      com.tencent.mm.bh.g.ium.a(this);
    }
    com.tencent.mm.kernel.g.ajR().ajA().b(this);
    com.tencent.mm.ui.h.a.dismiss();
    com.tencent.mm.kernel.g.ajQ().gDv.b(480, this);
    com.tencent.mm.sdk.b.a.IvT.d(this.fPh);
    com.tencent.mm.pluginsdk.c.b.b(mq.class.getName(), this.fPo);
    if (com.tencent.mm.kernel.g.ajM())
    {
      ((l)com.tencent.mm.kernel.g.ab(l.class)).azF().b(this);
      ((com.tencent.mm.plugin.chatroom.a.c)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.chatroom.a.c.class)).azP().remove(this);
    }
    if (com.tencent.mm.bh.g.ium != null) {
      com.tencent.mm.bh.g.ium.b(this);
    }
    if (this.fPp != null) {
      this.fPp.stopTimer();
    }
    super.onDestroy();
    AppMethodBeat.o(12568);
  }
  
  public void onPause()
  {
    AppMethodBeat.i(12567);
    super.onPause();
    if ((this.fOY) && (this.dzK))
    {
      if (this.fNS == null)
      {
        AppMethodBeat.o(12567);
        return;
      }
      com.tencent.mm.model.r.a(this.roomId, this.fNS, this.fOS);
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
      paramf = com.tencent.mm.n.g.acL().getValue("ChatRoomOwnerModTopic");
      if (bu.isNullOrNil(paramf)) {
        break label3193;
      }
    }
    label362:
    label756:
    label1525:
    label3193:
    for (int i = bu.aSB(paramf);; i = 0)
    {
      if ((this.fNS != null) && (!bu.isNullOrNil(this.fNS.field_roomowner)) && (i > 0) && (!YQ()) && (i < this.fOW)) {
        com.tencent.mm.ui.base.h.a(this, getString(2131762706, new Object[] { YJ() }), null, getString(2131755793), new DialogInterface.OnClickListener()
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
        com.tencent.mm.hellhoundlib.a.a.a(this, paramf.ahE(), "com/tencent/mm/chatroom/ui/ChatroomInfoUI", "onPreferenceTreeClick", "(Lcom/tencent/mm/ui/base/preference/IPreferenceScreen;Lcom/tencent/mm/ui/base/preference/Preference;)Z", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
        startActivity((Intent)paramf.mt(0));
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/chatroom/ui/ChatroomInfoUI", "onPreferenceTreeClick", "(Lcom/tencent/mm/ui/base/preference/IPreferenceScreen;Lcom/tencent/mm/ui/base/preference/Preference;)Z", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
        com.tencent.mm.plugin.report.service.g.yxI.idkeyStat(219L, 3L, 1L, true);
        continue;
        if (paramf.equals("room_upgrade_entry"))
        {
          if (bu.getInt(com.tencent.mm.n.g.acL().getValue("ChatroomGlobalSwitch"), 1) == 1) {}
          for (i = 1;; i = 0)
          {
            if (i == 0) {
              break label362;
            }
            paramf = new Intent();
            paramf.putExtra("rawUrl", getString(2131757097, new Object[] { ad.fom() }));
            paramf.putExtra("geta8key_username", com.tencent.mm.model.v.aAC());
            paramf.putExtra("showShare", false);
            com.tencent.mm.br.d.b(this, "webview", "com.tencent.mm.plugin.webview.ui.tools.WebViewUI", paramf);
            break;
          }
        }
        else if (paramf.equals("room_qr_code"))
        {
          if (x.zV(this.roomId))
          {
            paramf = new do();
            paramf.nl(this.roomId);
            paramf.dWm = 6L;
            paramf.aLH();
          }
          com.tencent.mm.plugin.report.service.g.yxI.idkeyStat(219L, 5L, 1L, true);
          paramf = new Intent();
          paramf.putExtra("from_userName", this.roomId);
          com.tencent.mm.br.d.b(this, "setting", ".ui.setting.SelfQRCodeUI", paramf);
        }
        else if (paramf.equals("room_card"))
        {
          if (this.fNS == null)
          {
            ae.w("MicroMsg.ChatroomInfoUI", "goToRoomCardUI member == null");
          }
          else
          {
            bool1 = this.fNS.aUg(com.tencent.mm.model.v.aAC());
            if ((bu.isNullOrNil(com.tencent.mm.model.r.zE(this.roomId))) && (!YQ()))
            {
              com.tencent.mm.ui.base.h.e(this, getString(2131762581), null, getString(2131762582), null, null, null);
            }
            else
            {
              paramf = new Intent();
              paramf.setClass(this, RoomCardUI.class);
              paramf.putExtra("RoomInfo_Id", this.roomId);
              paramf.putExtra("room_name", this.fOF.fWZ.toString());
              this.fOW = com.tencent.mm.model.r.zA(this.roomId).size();
              paramf.putExtra("room_member_count", this.fOW);
              paramf.putExtra("room_owner_name", YJ());
              paramf.putExtra("room_notice", com.tencent.mm.model.r.zE(this.roomId));
              paramf.putExtra("room_notice_publish_time", com.tencent.mm.model.r.zH(this.roomId));
              paramf.putExtra("room_notice_editor", com.tencent.mm.model.r.zG(this.roomId));
              paramf.putExtra("Is_RoomOwner", this.fOU);
              paramf.putExtra("Is_RoomManager", bool1);
              startActivityForResult(paramf, 6);
            }
          }
        }
        else
        {
          if (paramf.equals("room_notify_new_msg"))
          {
            if (!this.fOX)
            {
              bool1 = true;
              this.fOX = bool1;
              if (this.dzK)
              {
                if (!this.fOX) {
                  break label979;
                }
                i = 0;
                com.tencent.mm.roomsdk.a.b.aRc(this.roomId).H(this.roomId, i).cAs();
                this.contact = ((l)com.tencent.mm.kernel.g.ab(l.class)).azF().BH(this.roomId);
                this.contact.kk(i);
                ((l)com.tencent.mm.kernel.g.ab(l.class)).azF().c(this.roomId, this.contact);
                if (this.fPd)
                {
                  paramf = com.tencent.mm.plugin.report.service.g.yxI;
                  if (!this.fOX) {
                    break label984;
                  }
                  i = 14;
                  paramf.dD(869, i);
                }
              }
              paramf = com.tencent.mm.modelstat.b.iqT;
              ??? = this.roomId;
              bool1 = this.fOX;
              if ((paramf.aLW()) && (paramf.fb(???)))
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
              paramf.iqS.oplist_.add(???);
              YL();
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
            paramf = ((l)com.tencent.mm.kernel.g.ab(l.class)).azF().BH(this.roomId);
            if (paramf != null)
            {
              boolean bool2 = com.tencent.mm.contact.c.lO(paramf.field_type);
              ??? = this.sp.edit();
              if (!bool2)
              {
                bool1 = true;
                ???.putBoolean("room_save_to_contact", bool1).commit();
                if (!bool2) {
                  break label1192;
                }
                paramf.acT();
                com.tencent.mm.roomsdk.a.b.aRc(this.roomId).a(paramf, false);
                com.tencent.mm.ui.base.h.cm(this, getString(2131762677));
                com.tencent.mm.modelstat.b.iqT.W(this.roomId, false);
              }
              for (;;)
              {
                this.screen.notifyDataSetChanged();
                break;
                bool1 = false;
                break label1111;
                com.tencent.mm.roomsdk.a.b.aRc(this.roomId).a(paramf, true);
                com.tencent.mm.ui.base.h.cm(this, getString(2131762693));
                com.tencent.mm.modelstat.b.iqT.W(this.roomId, true);
              }
            }
          }
          else if (paramf.equals("room_placed_to_the_top"))
          {
            paramf = getSharedPreferences(this.fPk, 0);
            if (this.contact != null)
            {
              if (((l)com.tencent.mm.kernel.g.ab(l.class)).azL().aVi(this.contact.field_username))
              {
                x.E(this.contact.field_username, true);
                com.tencent.mm.modelstat.b.iqT.c(false, this.roomId, false);
              }
              for (;;)
              {
                paramf.edit().putBoolean("room_placed_to_the_top", ((l)com.tencent.mm.kernel.g.ab(l.class)).azL().aVi(this.contact.field_username)).commit();
                break;
                x.D(this.contact.field_username, true);
                com.tencent.mm.modelstat.b.iqT.c(false, this.roomId, true);
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
              paramf = getSharedPreferences(this.fPk, 0).edit();
              if (!this.fOS)
              {
                bool1 = true;
                paramf.putBoolean("room_msg_show_username", bool1).commit();
                if (this.fOS) {
                  break label1525;
                }
              }
              for (bool1 = true;; bool1 = false)
              {
                this.fOS = bool1;
                this.fOY = true;
                break;
                bool1 = false;
                break label1478;
              }
            }
            if (!paramf.equals("room_set_chatting_background")) {
              break;
            }
            if (x.zV(this.roomId))
            {
              paramf = new do();
              paramf.nl(this.roomId);
              paramf.dWm = 9L;
              paramf.aLH();
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
        if (x.zV(this.roomId))
        {
          paramf = new do();
          paramf.nl(this.roomId);
          paramf.dWm = 8L;
          paramf.aLH();
        }
        paramf = new Intent();
        paramf.putExtra("detail_username", this.roomId);
        com.tencent.mm.plugin.fts.a.d.d(this, ".ui.FTSChattingConvUI", paramf);
        if ((this.fNS == null) || (this.fNS.aGE() == null)) {
          break label3188;
        }
      }
      for (i = this.fNS.aGE().size();; i = 0)
      {
        for (;;)
        {
          com.tencent.mm.plugin.report.service.g.yxI.f(14569, new Object[] { Integer.valueOf(1), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(i), Integer.valueOf(1) });
          break;
          if (paramf.equals("room_clear_chatting_history"))
          {
            if (x.zV(this.roomId))
            {
              paramf = new do();
              paramf.nl(this.roomId);
              paramf.dWm = 11L;
              paramf.aLH();
            }
            paramf = getString(2131759504);
            com.tencent.mm.ui.base.h.a(getContext(), paramf, "", getString(2131755694), getString(2131755691), new DialogInterface.OnClickListener()
            {
              public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
              {
                AppMethodBeat.i(217156);
                com.tencent.mm.plugin.report.service.g.yxI.f(14553, new Object[] { Integer.valueOf(3), Integer.valueOf(2), ChatroomInfoUI.b(ChatroomInfoUI.this) });
                ChatroomInfoUI.cE(false);
                paramAnonymousDialogInterface = ChatroomInfoUI.this;
                ChatroomInfoUI.this.getString(2131755906);
                final p localp = com.tencent.mm.ui.base.h.b(paramAnonymousDialogInterface, ChatroomInfoUI.this.getString(2131755936), true, new ChatroomInfoUI.a());
                if (!ChatroomInfoUI.YR()) {}
                for (paramAnonymousDialogInterface = com.tencent.mm.pluginsdk.wallet.d.aPl(ChatroomInfoUI.o(ChatroomInfoUI.this).field_username);; paramAnonymousDialogInterface = null)
                {
                  if (!bu.isNullOrNil(paramAnonymousDialogInterface))
                  {
                    localp.dismiss();
                    com.tencent.mm.ui.base.h.a(ChatroomInfoUI.this, false, ChatroomInfoUI.this.getString(2131765211, new Object[] { paramAnonymousDialogInterface }), null, ChatroomInfoUI.this.getString(2131760081), ChatroomInfoUI.this.getString(2131757424), new DialogInterface.OnClickListener()new DialogInterface.OnClickListener
                    {
                      public final void onClick(DialogInterface paramAnonymous2DialogInterface, int paramAnonymous2Int)
                      {
                        AppMethodBeat.i(217154);
                        com.tencent.mm.plugin.report.service.g.yxI.f(14553, new Object[] { Integer.valueOf(3), Integer.valueOf(4), ChatroomInfoUI.b(ChatroomInfoUI.this) });
                        ChatroomInfoUI.a(ChatroomInfoUI.this, true);
                        if (!ChatroomInfoUI.s(ChatroomInfoUI.this))
                        {
                          paramAnonymous2DialogInterface = new Intent();
                          paramAnonymous2DialogInterface.putExtra("Chat_User", ChatroomInfoUI.o(ChatroomInfoUI.this).field_username);
                          paramAnonymous2DialogInterface.addFlags(67108864);
                          com.tencent.mm.br.d.f(ChatroomInfoUI.this, ".ui.chatting.ChattingUI", paramAnonymous2DialogInterface);
                          AppMethodBeat.o(217154);
                          return;
                        }
                        ChatroomInfoUI.this.finish();
                        AppMethodBeat.o(217154);
                      }
                    }, new DialogInterface.OnClickListener()
                    {
                      public final void onClick(DialogInterface paramAnonymous2DialogInterface, int paramAnonymous2Int)
                      {
                        AppMethodBeat.i(217155);
                        com.tencent.mm.plugin.report.service.g.yxI.f(14553, new Object[] { Integer.valueOf(3), Integer.valueOf(3), ChatroomInfoUI.b(ChatroomInfoUI.this) });
                        localp.show();
                        ChatroomInfoUI.a(ChatroomInfoUI.this, false);
                        ChatroomInfoUI.a(ChatroomInfoUI.this, localp);
                        AppMethodBeat.o(217155);
                      }
                    }, -1, 2131099904);
                    AppMethodBeat.o(217156);
                    return;
                  }
                  ChatroomInfoUI.a(ChatroomInfoUI.this, localp);
                  AppMethodBeat.o(217156);
                  return;
                }
              }
            }, null, 2131099904);
            break;
          }
          if (paramf.equals("room_report_it"))
          {
            if (x.zV(this.roomId))
            {
              paramf = new do();
              paramf.nl(this.roomId);
              paramf.dWm = 10L;
              paramf.aLH();
            }
            paramf = new Intent();
            paramf.putExtra("k_username", this.roomId);
            paramf.putExtra("showShare", false);
            paramf.putExtra("rawUrl", String.format("https://weixin110.qq.com/security/readtemplate?t=weixin_report/w_type&scene=%d#wechat_redirect", new Object[] { Integer.valueOf(36) }));
            com.tencent.mm.br.d.b(this, "webview", ".ui.tools.WebViewUI", paramf);
            paramf = com.tencent.mm.modelstat.b.iqT;
            ??? = this.roomId;
            if ((!paramf.aLW()) || (!paramf.fb(???))) {
              break;
            }
            ??? = new IMBehavior();
            ((IMBehavior)???).opType = 1;
            ((IMBehavior)???).chattingOp = new IMBehaviorChattingOP();
            ((IMBehavior)???).chattingOp.expose = 1;
            synchronized (paramf.lock)
            {
              paramf.iqS.oplist_.add(???);
            }
          }
        }
        if (paramf.equals("room_del_quit"))
        {
          ae.d("MicroMsg.ChatroomInfoUI", " quit " + this.roomId);
          paramf = new wq();
          paramf.dMc.dMe = true;
          com.tencent.mm.sdk.b.a.IvT.l(paramf);
          if ((!bu.isNullOrNil(this.roomId)) && (this.roomId.equals(paramf.dMd.dMg)))
          {
            bool1 = true;
            if (!bool1) {
              break label2300;
            }
            ae.d("MicroMsg.ChatroomInfoUI", " quit talkroom" + this.roomId);
          }
          label2300:
          while ((!this.fOU) || (this.fNS == null) || (this.fNS.aGE().size() <= 2))
          {
            com.tencent.mm.ui.base.h.a(getContext(), getString(2131758025), "", getString(2131755835), getString(2131755691), new DialogInterface.OnClickListener()
            {
              public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
              {
                AppMethodBeat.i(217160);
                if ((ChatroomInfoUI.b(ChatroomInfoUI.this) == null) || (ChatroomInfoUI.b(ChatroomInfoUI.this).length() <= 0))
                {
                  ae.e("MicroMsg.ChatroomInfoUI", "quitChatRoom : invalid args");
                  AppMethodBeat.o(217160);
                  return;
                }
                if (bool1)
                {
                  paramAnonymousDialogInterface = new wq();
                  paramAnonymousDialogInterface.dMc.dMf = true;
                  com.tencent.mm.sdk.b.a.IvT.l(paramAnonymousDialogInterface);
                }
                if (!((l)com.tencent.mm.kernel.g.ab(l.class)).azF().aUO(ChatroomInfoUI.b(ChatroomInfoUI.this)))
                {
                  ae.e("MicroMsg.ChatroomInfoUI", "quitChatRoom : room[" + ChatroomInfoUI.b(ChatroomInfoUI.this) + "] is not exist");
                  AppMethodBeat.o(217160);
                  return;
                }
                if (((com.tencent.mm.live.a)com.tencent.mm.kernel.g.ad(com.tencent.mm.live.a.class)).isAnchorLiving())
                {
                  com.tencent.mm.ui.base.h.a(ChatroomInfoUI.this.getContext(), ChatroomInfoUI.this.getString(2131760312), null, ChatroomInfoUI.this.getString(2131755793), new DialogInterface.OnClickListener()
                  {
                    public final void onClick(DialogInterface paramAnonymous2DialogInterface, int paramAnonymous2Int) {}
                  });
                  AppMethodBeat.o(217160);
                  return;
                }
                if (((com.tencent.mm.live.a)com.tencent.mm.kernel.g.ad(com.tencent.mm.live.a.class)).isVisitorLiving()) {
                  ((com.tencent.mm.live.a)com.tencent.mm.kernel.g.ad(com.tencent.mm.live.a.class)).forceStopCurLive(ChatroomInfoUI.this.getContext());
                }
                ChatroomInfoUI.t(ChatroomInfoUI.this);
                ((com.tencent.mm.plugin.multitalk.model.d)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.multitalk.model.d.class)).asn(ChatroomInfoUI.b(ChatroomInfoUI.this));
                AppMethodBeat.o(217160);
              }
            }, null, 2131099904);
            break;
            bool1 = false;
            break label2215;
          }
          paramf = getString(2131762665);
          ??? = new h.c()
          {
            public final void lh(int paramAnonymousInt)
            {
              AppMethodBeat.i(217159);
              switch (paramAnonymousInt)
              {
              default: 
                ae.d("MicroMsg.ChatroomInfoUI", "dz[dealQuitChatRoom owner click cancel]");
                AppMethodBeat.o(217159);
                return;
              }
              ae.d("MicroMsg.ChatroomInfoUI", "dz[dealQuitChatRoom owner click room_owner_delete_direct]");
              if (((com.tencent.mm.live.a)com.tencent.mm.kernel.g.ad(com.tencent.mm.live.a.class)).isAnchorLiving())
              {
                com.tencent.mm.ui.base.h.a(ChatroomInfoUI.this.getContext(), ChatroomInfoUI.this.getString(2131760312), null, ChatroomInfoUI.this.getString(2131755793), new DialogInterface.OnClickListener()
                {
                  public final void onClick(DialogInterface paramAnonymous2DialogInterface, int paramAnonymous2Int) {}
                });
                AppMethodBeat.o(217159);
                return;
              }
              if (((com.tencent.mm.live.a)com.tencent.mm.kernel.g.ad(com.tencent.mm.live.a.class)).isVisitorLiving()) {
                ((com.tencent.mm.live.a)com.tencent.mm.kernel.g.ad(com.tencent.mm.live.a.class)).forceStopCurLive(ChatroomInfoUI.this.getContext());
              }
              ChatroomInfoUI.t(ChatroomInfoUI.this);
              ((com.tencent.mm.plugin.multitalk.model.d)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.multitalk.model.d.class)).asn(ChatroomInfoUI.b(ChatroomInfoUI.this));
              AppMethodBeat.o(217159);
            }
          };
          com.tencent.mm.ui.base.h.a(this, "", new String[] { paramf }, "", ???);
          break;
        }
        if (paramf.equals("add_selector_btn"))
        {
          YH();
          break;
        }
        if (paramf.equals("del_selector_btn"))
        {
          YI();
          break;
        }
        if (paramf.equals("see_room_member"))
        {
          paramf = new Intent();
          paramf.setClass(getContext(), SeeRoomMemberUI.class);
          paramf.putExtra("Block_list", com.tencent.mm.model.v.aAC());
          ??? = com.tencent.mm.model.r.zA(this.roomId);
          if (??? != null) {
            this.fOW = ???.size();
          }
          paramf.putExtra("Chatroom_member_list", bu.m(???, ","));
          paramf.putExtra("RoomInfo_Id", this.roomId);
          paramf.putExtra("room_owner_name", this.fNS.field_roomowner);
          paramf.putExtra("Is_RoomOwner", this.fOU);
          paramf.putExtra("room_member_count", this.fOW);
          paramf.putExtra("Add_address_titile", getString(2131762697));
          if (this.dzK)
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
            this.fPi = 5;
            break;
            if (!this.fOE) {
              break label2563;
            }
            paramf.putExtra("Contact_Scene", 44);
            if (com.tencent.mm.model.v.zK(this.contact.field_username)) {
              break label2563;
            }
            paramf.putExtra("Contact_IsLBSFriend", true);
            break label2563;
          }
        }
        if (paramf.equals("manage_room"))
        {
          if (this.fPe) {
            com.tencent.mm.plugin.newtips.a.dxD().Mv(26);
          }
          paramf = new Intent();
          paramf.setClass(getContext(), ManageChatroomUI.class);
          paramf.putExtra("RoomInfo_Id", this.roomId);
          paramf.putExtra("room_owner_name", this.fNS.field_roomowner);
          paramf = new com.tencent.mm.hellhoundlib.b.a().bc(paramf);
          com.tencent.mm.hellhoundlib.a.a.a(this, paramf.ahE(), "com/tencent/mm/chatroom/ui/ChatroomInfoUI", "goToManageChatroomUI", "()V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
          startActivity((Intent)paramf.mt(0));
          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/chatroom/ui/ChatroomInfoUI", "goToManageChatroomUI", "()V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
          break;
        }
        if (paramf.equals("chat_room_app_brand"))
        {
          if (x.zV(this.roomId))
          {
            paramf = new do();
            paramf.nl(this.roomId);
            paramf.dWm = 7L;
            paramf.aLH();
          }
          paramf = new Intent();
          paramf.putExtra("Chat_User", this.roomId);
          com.tencent.mm.br.d.f(this, ".ui.chatting.gallery.AppBrandHistoryListUI", paramf);
          com.tencent.mm.plugin.report.service.g.yxI.idkeyStat(219L, 25L, 1L, true);
          break;
        }
        if (paramf.equals("room_manager_view"))
        {
          paramf = new Intent();
          paramf.setClass(getContext(), SeeRoomOwnerManagerUI.class);
          paramf.putExtra("RoomInfo_Id", this.roomId);
          paramf.putExtra("room_owner_name", this.fNS.field_roomowner);
          paramf = new com.tencent.mm.hellhoundlib.b.a().bc(paramf);
          com.tencent.mm.hellhoundlib.a.a.a(this, paramf.ahE(), "com/tencent/mm/chatroom/ui/ChatroomInfoUI", "goToOwnerManageChatroomUI", "()V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
          startActivity((Intent)paramf.mt(0));
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
        com.tencent.mm.hellhoundlib.a.a.a(this, paramf.ahE(), "com/tencent/mm/chatroom/ui/ChatroomInfoUI", "dealModChatroomRemark", "()V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
        startActivity((Intent)paramf.mt(0));
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
    if ((this.fNS != null) && (this.fNS.ftS() != null))
    {
      bool = com.tencent.mm.model.r.zF(this.fNS.field_chatroomname);
      ae.i("MicroMsg.ChatroomInfoUI", "roomId:%s newVer:%s localVer:%s owner:%s", new Object[] { this.fNS.field_chatroomname, Integer.valueOf(this.fNS.field_chatroomVersion), Integer.valueOf(this.fNS.field_oldChatroomVersion), this.fNS.field_roomowner });
    }
    for (;;)
    {
      if ((com.tencent.mm.model.r.zv(this.roomId)) || (bool)) {
        YD();
      }
      YM();
      updateTitle();
      YL();
      Object localObject2;
      Object localObject1;
      if (this.dzK)
      {
        YN();
        if (this.contact != null)
        {
          this.fNS = ((com.tencent.mm.plugin.chatroom.a.c)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.chatroom.a.c.class)).azP().Bx(this.roomId);
          if (this.fNS != null) {
            break label507;
          }
          localObject2 = "";
          localObject1 = localObject2;
          if (bu.isNullOrNil((String)localObject2)) {
            localObject1 = com.tencent.mm.model.v.aAE();
          }
          if (bu.isNullOrNil((String)localObject1)) {
            break label518;
          }
          this.fOO.fDF();
          this.fOO.JNI = com.tencent.mm.cb.a.ax(getContext(), 2131165587);
          KeyValuePreference localKeyValuePreference = this.fOO;
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
        if ((this.contact != null) && (this.fOP != null))
        {
          this.contact = ((l)com.tencent.mm.kernel.g.ab(l.class)).azF().BH(this.roomId);
          this.fOP.fDF();
          if (!an.aUr(this.roomId)) {
            break label530;
          }
          this.screen.d(this.fOP);
        }
      }
      for (;;)
      {
        if (this.fPa)
        {
          YK();
          this.fPa = false;
        }
        localObject1 = getIntent().getStringExtra("need_matte_high_light_item");
        if (!this.fPg)
        {
          if (!bu.isNullOrNil((String)localObject1)) {
            vo((String)localObject1);
          }
          this.fPg = true;
        }
        if ((!bu.isNullOrNil((String)localObject1)) && (((String)localObject1).equals("room_notify_new_notice")) && (!this.fPg))
        {
          vo("room_card");
          this.fPg = true;
        }
        com.tencent.mm.plugin.newtips.a.dxD().Mu(26);
        ae.d("MicroMsg.ChatroomInfoUI", "showSetMuteAnimation isShowSetMuteAnimation[%b]", new Object[] { Boolean.valueOf(this.fPc) });
        if (this.fPc)
        {
          this.fPc = false;
          ar.o(new Runnable()
          {
            public final void run()
            {
              AppMethodBeat.i(217177);
              ChatroomInfoUI.b(ChatroomInfoUI.this, "room_notify_new_msg");
              ChatroomInfoUI.B(ChatroomInfoUI.this);
              AppMethodBeat.o(217177);
            }
          }, 50L);
        }
        AppMethodBeat.o(12564);
        return;
        label507:
        localObject2 = this.fNS.field_selfDisplayName;
        break;
        label518:
        this.fOO.setSummary("");
        break label268;
        label530:
        if (!bu.isNullOrNil(this.contact.field_conRemark))
        {
          localObject1 = this.contact.field_conRemark;
          this.fOP.setSummary(k.c(this, (CharSequence)localObject1));
          if (this.screen != null) {
            this.screen.notifyDataSetChanged();
          }
        }
        else
        {
          this.fOP.setSummary("");
        }
      }
      bool = false;
    }
  }
  
  public void onSceneEnd(int paramInt1, int paramInt2, String paramString, com.tencent.mm.ak.n paramn)
  {
    AppMethodBeat.i(12594);
    ae.i("MicroMsg.ChatroomInfoUI", "onSceneEnd: errType = " + paramInt1 + " errCode = " + paramInt2 + " errMsg = " + paramString + " type = " + paramn.getType());
    ae.d("MicroMsg.ChatroomInfoUI", "pre is " + this.fOW);
    this.fOW = com.tencent.mm.model.r.zC(this.roomId);
    ae.d("MicroMsg.ChatroomInfoUI", "now is " + this.fOW);
    if (this.fOC != null) {
      this.fOC.dismiss();
    }
    AppMethodBeat.o(12594);
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
  
  public final void vp(final String paramString)
  {
    AppMethodBeat.i(217188);
    ae.i("MicroMsg.ChatroomInfoUI", "delete chatroom %s", new Object[] { paramString });
    this.fPm = com.tencent.mm.roomsdk.a.b.aRc(paramString).vd(paramString);
    this.fPm.d(new com.tencent.mm.roomsdk.a.b.e() {}).cAs();
    AppMethodBeat.o(217188);
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