package com.tencent.mm.chatroom.ui;

import android.app.Activity;
import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.support.v4.widget.NestedScrollView;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.RecyclerView.a;
import android.support.v7.widget.RecyclerView.b;
import android.support.v7.widget.RecyclerView.v;
import android.text.SpannableString;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.al.n;
import com.tencent.mm.g.b.a.ar;
import com.tencent.mm.g.b.a.at;
import com.tencent.mm.model.aj;
import com.tencent.mm.model.u;
import com.tencent.mm.model.v;
import com.tencent.mm.plugin.expt.a.b.a;
import com.tencent.mm.pluginsdk.ui.applet.CdnImageView;
import com.tencent.mm.protocal.protobuf.api;
import com.tencent.mm.protocal.protobuf.dgu;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.aq;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.storage.af;
import com.tencent.mm.storage.bg;
import com.tencent.mm.storage.bh;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.ui.base.t;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map.Entry;
import java.util.Set;

public class ManagerRoomByWeworkUI
  extends MMActivity
  implements com.tencent.mm.al.g
{
  private HashMap<String, Boolean> fsA;
  private HashMap<String, Boolean> fsB;
  private int fsC;
  private int fsD;
  private int fsE;
  public Button fsF;
  public Button fsG;
  private CdnImageView fsH;
  public TextView fsI;
  public TextView fsJ;
  public LinearLayout fsK;
  private LinearLayout fsL;
  private LinearLayout fsM;
  private RecyclerView fsN;
  private LinearLayout fsO;
  private TextView fsP;
  private ImageView fsQ;
  private LinearLayoutManager fsR;
  private a fsS;
  private ManagerRoomByWeworkUI.b fsT;
  private int fsU;
  private int fsV;
  private String fss;
  private int fsv;
  private String fsw;
  private List<String> fsx;
  private List<af> fsy;
  private List<String> fsz;
  private com.tencent.mm.ui.base.p tipDialog;
  public TextView titleTv;
  
  public ManagerRoomByWeworkUI()
  {
    AppMethodBeat.i(196629);
    this.fsx = new ArrayList();
    this.fsy = new ArrayList();
    this.fsz = new ArrayList();
    this.fsA = new HashMap();
    this.fsB = new HashMap();
    this.fsC = 0;
    this.fsD = 0;
    this.fsE = 0;
    this.tipDialog = null;
    this.fsU = 0;
    this.fsV = 0;
    AppMethodBeat.o(196629);
  }
  
  private boolean VA()
  {
    AppMethodBeat.i(196632);
    HashMap localHashMap = ((com.tencent.mm.plugin.messenger.foundation.a.k)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.messenger.foundation.a.k.class)).apR().eLh();
    LinkedList localLinkedList = new LinkedList();
    List localList = com.tencent.mm.model.w.ars();
    if (localList.size() == 0)
    {
      AppMethodBeat.o(196632);
      return false;
    }
    Iterator localIterator = localList.iterator();
    while (localIterator.hasNext())
    {
      af localaf = (af)localIterator.next();
      if ((!com.tencent.mm.model.w.so(localaf.field_username)) && (!this.fsz.contains(localaf.field_username)))
      {
        com.tencent.mm.storage.w localw;
        if (!localHashMap.containsKey(localaf.field_username))
        {
          if (com.tencent.mm.n.b.ls(localaf.field_type))
          {
            localw = ((com.tencent.mm.plugin.chatroom.a.c)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.chatroom.a.c.class)).apV().tH(localaf.field_username);
            if (localw == null) {
              ad.e("MicroMsg.ManagerRoomByWeworkUI", "%s member is null", new Object[] { bt.by(localaf.field_username, "") });
            } else if ((localw.ty(u.aqG())) && (c(localaf))) {
              localLinkedList.add(localaf);
            }
          }
        }
        else
        {
          localw = ((com.tencent.mm.plugin.chatroom.a.c)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.chatroom.a.c.class)).apV().tH(localaf.field_username);
          if (localw == null) {
            ad.e("MicroMsg.ManagerRoomByWeworkUI", "%s member is null", new Object[] { bt.by(localaf.field_username, "") });
          } else if ((localw.ty(u.aqG())) && (c(localaf))) {
            localLinkedList.add(localaf);
          }
        }
      }
    }
    localList.clear();
    if (localLinkedList.size() > 0)
    {
      AppMethodBeat.o(196632);
      return true;
    }
    AppMethodBeat.o(196632);
    return false;
  }
  
  private void VB()
  {
    AppMethodBeat.i(196637);
    if (this.fsv == 3)
    {
      if (((com.tencent.mm.plugin.expt.a.b)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.expt.a.b.class)).a(b.a.ppK, 1) == 1) {}
      for (int i = 1; (i != 0) && (VA()) && (this.fsx.size() == 0) && (this.fsz.size() == 0); i = 0)
      {
        this.fsF.setVisibility(8);
        this.fsG.setVisibility(0);
        AppMethodBeat.o(196637);
        return;
      }
      this.fsF.setVisibility(0);
      this.fsG.setVisibility(8);
      if ((this.fsS != null) && (this.fsS.ftb > 0))
      {
        this.fsF.setEnabled(true);
        AppMethodBeat.o(196637);
        return;
      }
      this.fsF.setEnabled(false);
      AppMethodBeat.o(196637);
      return;
    }
    this.fsF.setVisibility(0);
    this.fsG.setVisibility(8);
    AppMethodBeat.o(196637);
  }
  
  private boolean Vz()
  {
    AppMethodBeat.i(196631);
    int i;
    if (((com.tencent.mm.plugin.expt.a.b)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.expt.a.b.class)).a(b.a.ppK, 1) == 1)
    {
      i = 1;
      if ((i == 0) || (!VA())) {
        break label98;
      }
      if ((this.fsx.size() != 0) || (this.fsz.size() != 0)) {
        break label87;
      }
      this.fsO.setVisibility(8);
    }
    for (;;)
    {
      AppMethodBeat.o(196631);
      return true;
      i = 0;
      break;
      label87:
      this.fsO.setVisibility(0);
    }
    label98:
    this.fsO.setVisibility(8);
    this.fsQ.setVisibility(8);
    AppMethodBeat.o(196631);
    return false;
  }
  
  public static void a(Context paramContext, String paramString, TextView paramTextView1, TextView paramTextView2, boolean paramBoolean)
  {
    AppMethodBeat.i(196639);
    SpannableString localSpannableString = com.tencent.mm.pluginsdk.ui.span.k.b(paramContext, v.sh(paramString), com.tencent.mm.cd.a.ao(paramContext, 2131165517));
    Object localObject = localSpannableString;
    if (paramBoolean) {
      localObject = com.tencent.mm.pluginsdk.ui.span.k.d(paramContext, localSpannableString);
    }
    paramTextView1.setText((CharSequence)localObject);
    int i = com.tencent.mm.model.q.rY(((com.tencent.mm.plugin.messenger.foundation.a.k)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.messenger.foundation.a.k.class)).apM().aHY(paramString).field_username);
    if (i == 0)
    {
      paramTextView2.setVisibility(8);
      AppMethodBeat.o(196639);
      return;
    }
    paramTextView2.setVisibility(0);
    paramTextView2.setText(paramContext.getString(2131766410, new Object[] { String.valueOf(i) }));
    AppMethodBeat.o(196639);
  }
  
  private void a(final n paramn, boolean paramBoolean)
  {
    AppMethodBeat.i(196634);
    if (this.tipDialog == null)
    {
      getString(2131755906);
      this.tipDialog = h.b(this, getString(2131755804), paramBoolean, new DialogInterface.OnCancelListener()
      {
        public final void onCancel(DialogInterface paramAnonymousDialogInterface)
        {
          AppMethodBeat.i(182211);
          if (paramn == null)
          {
            ad.i("MicroMsg.ManagerRoomByWeworkUI", "dialog onCancel scene is null");
            AppMethodBeat.o(182211);
            return;
          }
          ad.i("MicroMsg.ManagerRoomByWeworkUI", "dialog onCancel scene:%s", new Object[] { Integer.valueOf(paramn.getType()) });
          com.tencent.mm.kernel.g.aeS().a(paramn);
          if ((paramn instanceof com.tencent.mm.chatroom.d.k)) {
            ManagerRoomByWeworkUI.this.finish();
          }
          AppMethodBeat.o(182211);
        }
      });
      AppMethodBeat.o(196634);
      return;
    }
    if (!this.tipDialog.isShowing()) {
      this.tipDialog.show();
    }
    AppMethodBeat.o(196634);
  }
  
  public static void a(String paramString, final CdnImageView paramCdnImageView)
  {
    AppMethodBeat.i(196638);
    if ((bt.isNullOrNil(paramString)) || (paramCdnImageView == null))
    {
      ad.e("MicroMsg.ManagerRoomByWeworkUI", "username or avatarIv null");
      AppMethodBeat.o(196638);
      return;
    }
    paramString = new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(196618);
        Bitmap localBitmap = com.tencent.mm.ak.c.a(this.fqK, false, -1, null);
        if (localBitmap == null)
        {
          paramCdnImageView.setImageResource(2131231875);
          AppMethodBeat.o(196618);
          return;
        }
        paramCdnImageView.setImageBitmap(localBitmap);
        AppMethodBeat.o(196618);
      }
    };
    if (aq.isMainThread())
    {
      paramString.run();
      AppMethodBeat.o(196638);
      return;
    }
    aq.f(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(196619);
        this.val$run.run();
        AppMethodBeat.o(196619);
      }
    });
    AppMethodBeat.o(196638);
  }
  
  public static void c(String paramString, int paramInt1, int paramInt2, int paramInt3)
  {
    AppMethodBeat.i(182217);
    ar localar = new ar();
    localar.hJ(paramString);
    localar.dKe = paramInt1;
    localar.dMH = paramInt2;
    localar.dMI = paramInt3;
    localar.aBj();
    AppMethodBeat.o(182217);
  }
  
  private static boolean c(af paramaf)
  {
    AppMethodBeat.i(196633);
    if (paramaf == null)
    {
      AppMethodBeat.o(196633);
      return false;
    }
    com.tencent.mm.storage.w localw = ((com.tencent.mm.plugin.chatroom.a.c)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.chatroom.a.c.class)).apV().tH(paramaf.field_username);
    if (localw == null)
    {
      ad.e("MicroMsg.ManagerRoomByWeworkUI", "isValidByMaxNum %s member is null", new Object[] { paramaf.field_username });
      AppMethodBeat.o(196633);
      return false;
    }
    if (localw.field_memberCount < com.tencent.mm.model.q.aqC())
    {
      AppMethodBeat.o(196633);
      return true;
    }
    AppMethodBeat.o(196633);
    return false;
  }
  
  private void f(ArrayList<String> paramArrayList)
  {
    long l2 = 0L;
    AppMethodBeat.i(196636);
    StringBuilder localStringBuilder = new StringBuilder();
    paramArrayList = paramArrayList.iterator();
    int j = 0;
    int i = 0;
    if (paramArrayList.hasNext())
    {
      String str = (String)paramArrayList.next();
      if (this.fsx.contains(str)) {
        i += 1;
      }
      for (;;)
      {
        localStringBuilder.append(str).append("|");
        break;
        j += 1;
      }
    }
    if (localStringBuilder.length() - 1 >= 0) {
      localStringBuilder.deleteCharAt(localStringBuilder.length() - 1);
    }
    paramArrayList = new at();
    paramArrayList.dMJ = i;
    if (this.fsS == null)
    {
      l1 = 0L;
      paramArrayList.dMK = l1;
      paramArrayList.dML = j;
      if (this.fsS != null) {
        break label230;
      }
    }
    label230:
    for (long l1 = l2;; l1 = this.fsS.fte - j)
    {
      paramArrayList.dMM = l1;
      paramArrayList.dMN = paramArrayList.t("sucRoomList", localStringBuilder.toString(), true);
      paramArrayList.dMO = paramArrayList.t("ticketId", bt.by(this.fsw, ""), true);
      paramArrayList.aBj();
      AppMethodBeat.o(196636);
      return;
      l1 = this.fsS.ftd - i;
      break;
    }
  }
  
  public int getLayoutId()
  {
    return 2131493376;
  }
  
  public final void kN(int paramInt)
  {
    long l2 = 0L;
    AppMethodBeat.i(196635);
    com.tencent.mm.g.b.a.au localau = new com.tencent.mm.g.b.a.au();
    localau.dMP = this.fsU;
    localau.dMQ = this.fsV;
    if (this.fsS == null)
    {
      l1 = 0L;
      localau.dMR = l1;
      if (this.fsS != null) {
        break label126;
      }
    }
    label126:
    for (long l1 = l2;; l1 = this.fsS.fte)
    {
      localau.dMS = l1;
      localau.dMT = paramInt;
      localau.hL(bt.by(this.fsw, ""));
      localau.dMV = this.fsE;
      localau.aBj();
      AppMethodBeat.o(196635);
      return;
      l1 = this.fsS.ftd;
      break;
    }
  }
  
  public void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    AppMethodBeat.i(196630);
    super.onActivityResult(paramInt1, paramInt2, paramIntent);
    ad.i("MicroMsg.ManagerRoomByWeworkUI", "requestCode=%d | resultCode=%d", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) });
    if (paramInt2 != -1)
    {
      AppMethodBeat.o(196630);
      return;
    }
    if (paramInt1 == 0)
    {
      paramIntent = paramIntent.getStringExtra("Select_Conv_User");
      Object localObject = this.fsy.iterator();
      while (((Iterator)localObject).hasNext()) {
        if (bt.kU(((af)((Iterator)localObject).next()).field_username, paramIntent))
        {
          ad.i("MicroMsg.ManagerRoomByWeworkUI", "onActivityResult contain");
          AppMethodBeat.o(196630);
          return;
        }
      }
      localObject = ((com.tencent.mm.plugin.messenger.foundation.a.k)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.messenger.foundation.a.k.class)).apM().aHY(paramIntent);
      this.fsy.add(localObject);
      this.fsz.add(paramIntent);
      this.fsA.put(((com.tencent.mm.g.c.au)localObject).field_username, Boolean.TRUE);
      this.fsS.aql.notifyChanged();
      Vz();
      this.fsS.fte += 1;
      this.fsS.ftb += 1;
      com.tencent.mm.ui.tools.p.a(this, (NestedScrollView)findViewById(2131304251), findViewById(2131298738), findViewById(2131306201), findViewById(2131297454));
      VB();
    }
    AppMethodBeat.o(196630);
  }
  
  public void onCreate(Bundle paramBundle)
  {
    boolean bool = true;
    AppMethodBeat.i(182212);
    super.onCreate(paramBundle);
    setMMTitle("");
    this.fss = getIntent().getStringExtra("RoomInfo_Id");
    this.fsv = getIntent().getIntExtra("upgrade_openim_room_from_scene", 0);
    this.fsw = getIntent().getStringExtra("ticket");
    ad.i("MicroMsg.ManagerRoomByWeworkUI", "mFromScene:%s", new Object[] { Integer.valueOf(this.fsv) });
    int i;
    if (this.fsv == 3)
    {
      if (!bt.isNullOrNil(this.fsw)) {
        break label154;
      }
      ad.e("MicroMsg.ManagerRoomByWeworkUI", "mTicket is null");
      finish();
      i = 0;
    }
    while (i == 0)
    {
      AppMethodBeat.o(182212);
      return;
      if (bt.isNullOrNil(this.fss))
      {
        ad.e("MicroMsg.ManagerRoomByWeworkUI", "mRoomId is null");
        finish();
        i = 0;
      }
      else
      {
        label154:
        i = 1;
      }
    }
    com.tencent.mm.kernel.g.aeS().a(3553, this);
    com.tencent.mm.kernel.g.aeS().a(3927, this);
    ad.i("MicroMsg.ManagerRoomByWeworkUI", "doFetchCollectPubFill() roomId:%s", new Object[] { this.fss });
    if (this.fsv == 3)
    {
      paramBundle = new com.tencent.mm.chatroom.d.k(this.fsw, (byte)0);
      com.tencent.mm.kernel.g.aeS().a(paramBundle, 0);
      if (this.fsv == 3) {
        break label307;
      }
    }
    for (;;)
    {
      a(paramBundle, bool);
      setMMTitle("");
      hideActionbarLine();
      setActionbarColor(getResources().getColor(2131099650));
      setBackGroundColorResource(2131099650);
      setBackBtn(new MenuItem.OnMenuItemClickListener()
      {
        public final boolean onMenuItemClick(MenuItem paramAnonymousMenuItem)
        {
          AppMethodBeat.i(182207);
          ad.i("MicroMsg.ManagerRoomByWeworkUI", "onMenuItemClick click");
          WeworkRoomUpgradeResultUI.bT(ManagerRoomByWeworkUI.this);
          ManagerRoomByWeworkUI.this.finish();
          if (ManagerRoomByWeworkUI.a(ManagerRoomByWeworkUI.this) != 3) {
            ManagerRoomByWeworkUI.c(ManagerRoomByWeworkUI.b(ManagerRoomByWeworkUI.this), ManagerRoomByWeworkUI.a(ManagerRoomByWeworkUI.this), 0, 0);
          }
          for (;;)
          {
            AppMethodBeat.o(182207);
            return true;
            ManagerRoomByWeworkUI.this.kN(0);
          }
        }
      });
      AppMethodBeat.o(182212);
      return;
      paramBundle = new com.tencent.mm.chatroom.d.k(this.fss);
      break;
      label307:
      bool = false;
    }
  }
  
  public void onDestroy()
  {
    AppMethodBeat.i(182214);
    com.tencent.mm.kernel.g.aeS().b(3553, this);
    com.tencent.mm.kernel.g.aeS().b(3927, this);
    super.onDestroy();
    AppMethodBeat.o(182214);
  }
  
  public boolean onKeyUp(int paramInt, KeyEvent paramKeyEvent)
  {
    AppMethodBeat.i(182215);
    if (this.fsv != 3) {
      c(this.fss, this.fsv, 0, 0);
    }
    for (;;)
    {
      boolean bool = super.onKeyUp(paramInt, paramKeyEvent);
      AppMethodBeat.o(182215);
      return bool;
      kN(0);
    }
  }
  
  public void onSceneEnd(int paramInt1, int paramInt2, String paramString, n paramn)
  {
    AppMethodBeat.i(182213);
    ad.i("MicroMsg.ManagerRoomByWeworkUI", "onSceneEnd errType = %d, errCode = %d, errMsg = %s, scenetype:%s", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), paramString, Integer.valueOf(paramn.getType()) });
    label121:
    Object localObject1;
    if ((this.fsv != 3) || ((paramn instanceof com.tencent.mm.chatroom.d.k)))
    {
      if ((this.tipDialog != null) && (this.tipDialog.isShowing())) {
        this.tipDialog.dismiss();
      }
      if ((paramInt1 != 0) || (paramInt2 != 0)) {
        break label2129;
      }
      if (!(paramn instanceof com.tencent.mm.chatroom.d.k)) {
        break label1690;
      }
      paramn = (com.tencent.mm.chatroom.d.k)paramn;
      if (paramn.foL != null) {
        break label769;
      }
      paramn = null;
      if (paramn == null) {
        break label1643;
      }
      super.initView();
      this.fsF = ((Button)findViewById(2131306228));
      this.fsG = ((Button)findViewById(2131307239));
      this.titleTv = ((TextView)findViewById(2131297973));
      this.fsH = ((CdnImageView)findViewById(2131297960));
      this.fsI = ((TextView)findViewById(2131297972));
      this.fsJ = ((TextView)findViewById(2131298777));
      this.fsK = ((LinearLayout)findViewById(2131298764));
      this.fsL = ((LinearLayout)findViewById(2131307196));
      this.fsM = ((LinearLayout)findViewById(2131307167));
      this.fsN = ((RecyclerView)findViewById(2131307150));
      this.fsO = ((LinearLayout)findViewById(2131307241));
      this.fsP = ((TextView)findViewById(2131307242));
      this.fsQ = ((ImageView)findViewById(2131307240));
      findViewById(2131298738).setVisibility(0);
      this.fsF.setOnClickListener(new View.OnClickListener()
      {
        public final void onClick(View paramAnonymousView)
        {
          AppMethodBeat.i(196615);
          ad.i("MicroMsg.ManagerRoomByWeworkUI", "click use");
          if (ManagerRoomByWeworkUI.a(ManagerRoomByWeworkUI.this) == 3)
          {
            ManagerRoomByWeworkUI.c(ManagerRoomByWeworkUI.this);
            AppMethodBeat.o(196615);
            return;
          }
          ManagerRoomByWeworkUI.d(ManagerRoomByWeworkUI.this);
          AppMethodBeat.o(196615);
        }
      });
      if ((this.fsv != 1) && (this.fsv != 2)) {
        break label852;
      }
      this.fsM.setVisibility(0);
      this.fsL.setVisibility(8);
      a(this.fss, this.fsH);
      paramString = this.fss;
      localObject1 = this.fsI;
      paramString = ((com.tencent.mm.plugin.messenger.foundation.a.k)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.messenger.foundation.a.k.class)).apM().aHY(paramString);
      if (!bt.isNullOrNil(paramString.field_nickname)) {
        break label817;
      }
      if (com.tencent.mm.model.q.rY(paramString.field_username) != 0) {
        break label779;
      }
      paramString = getString(2131761169);
      label441:
      ((TextView)localObject1).setText(com.tencent.mm.pluginsdk.ui.span.k.d(this, com.tencent.mm.pluginsdk.ui.span.k.b(this, paramString, com.tencent.mm.cd.a.ao(this, 2131165192))));
    }
    Object localObject3;
    label769:
    label779:
    label817:
    label1596:
    label1599:
    for (;;)
    {
      for (;;)
      {
        VB();
        this.titleTv.setText(paramn.title);
        this.fsJ.setText(com.tencent.mm.pluginsdk.ui.span.k.d(getContext(), bt.nullAsNil(paramn.odt), (int)this.fsJ.getTextSize()));
        if ((paramn.DqR == null) || (paramn.DqR.size() <= 0)) {
          break label1601;
        }
        this.fsK.removeAllViews();
        paramString = (LayoutInflater)getContext().getSystemService("layout_inflater");
        paramn = paramn.DqR.iterator();
        paramInt1 = 0;
        while (paramn.hasNext())
        {
          localObject1 = (String)paramn.next();
          localObject3 = paramString.inflate(2131493377, this.fsK, false);
          paramInt1 += 1;
          ((TextView)((View)localObject3).findViewById(2131303086)).setText(paramInt1 + ".");
          ((TextView)((View)localObject3).findViewById(2131299008)).setText((CharSequence)localObject1);
          this.fsK.addView((View)localObject3);
        }
        try
        {
          ad.i("MicroMsg.ManagerRoomByWeworkUI", "NetSceneUpgradeAssociateChatRoom %s", new Object[] { ((com.tencent.mm.chatroom.d.w)paramn).dlX });
          this.fsC += 1;
          if ((this.fsC != this.fsD) || (this.tipDialog == null) || (!this.tipDialog.isShowing())) {
            break;
          }
          this.tipDialog.dismiss();
        }
        catch (Exception localException)
        {
          for (;;)
          {
            ad.e("MicroMsg.ManagerRoomByWeworkUI", "NetSceneUpgradeAssociateChatRoom Exception:%s %s", new Object[] { localException.getClass().getSimpleName(), localException.getMessage() });
          }
        }
      }
      paramn = paramn.foL;
      break label121;
      paramString = getString(2131759496, new Object[] { getString(2131761169), Integer.valueOf(com.tencent.mm.model.q.rY(paramString.field_username)) });
      break label441;
      paramString = getString(2131759496, new Object[] { paramString.ZW(), Integer.valueOf(com.tencent.mm.model.q.rY(paramString.field_username)) });
      break label441;
      label852:
      if (this.fsv == 3)
      {
        this.fsM.setVisibility(8);
        this.fsL.setVisibility(0);
        paramString = new View.OnClickListener()
        {
          public final void onClick(View paramAnonymousView)
          {
            AppMethodBeat.i(196616);
            ad.i("MicroMsg.ManagerRoomByWeworkUI", "select_group_ll click");
            ManagerRoomByWeworkUI.e(ManagerRoomByWeworkUI.this);
            if (ManagerRoomByWeworkUI.f(ManagerRoomByWeworkUI.this).ftb == 5)
            {
              t.makeText(ManagerRoomByWeworkUI.this, 2131766408, 0).show();
              AppMethodBeat.o(196616);
              return;
            }
            paramAnonymousView = new Intent();
            paramAnonymousView.setClassName(ManagerRoomByWeworkUI.this, "com.tencent.mm.ui.contact.GroupCardSelectUI");
            paramAnonymousView.putExtra("group_select_type", true);
            paramAnonymousView.putExtra("group_select_need_result", true);
            paramAnonymousView.putExtra("group_select_only_need_self_owner", true);
            ArrayList localArrayList = new ArrayList();
            Iterator localIterator = ManagerRoomByWeworkUI.g(ManagerRoomByWeworkUI.this).iterator();
            while (localIterator.hasNext()) {
              localArrayList.add(((af)localIterator.next()).field_username);
            }
            paramAnonymousView.putStringArrayListExtra("group_select_block_chatroom", localArrayList);
            paramAnonymousView.putExtra("group_select_chatroom_max_num", com.tencent.mm.model.q.aqC());
            ManagerRoomByWeworkUI.this.startActivityForResult(paramAnonymousView, 0);
            AppMethodBeat.o(196616);
          }
        };
        this.fsO.setOnClickListener(paramString);
        this.fsG.setOnClickListener(paramString);
        paramString = com.tencent.mm.model.w.ars();
        if (paramString.size() == 0) {
          paramInt1 = 0;
        }
        for (;;)
        {
          if ((paramInt1 != 0) || (Vz())) {
            break label1599;
          }
          findViewById(2131299477).setVisibility(0);
          findViewById(2131306228).setVisibility(8);
          this.fsL.setVisibility(8);
          break;
          paramString = paramString.iterator();
          while (paramString.hasNext())
          {
            localObject2 = (af)paramString.next();
            if (com.tencent.mm.model.w.sq(((com.tencent.mm.g.c.au)localObject2).field_username))
            {
              localObject3 = ((com.tencent.mm.plugin.chatroom.a.c)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.chatroom.a.c.class)).apV().tH(((com.tencent.mm.g.c.au)localObject2).field_username);
              if (localObject3 == null)
              {
                ad.e("MicroMsg.ManagerRoomByWeworkUI", "initContactList %s member is null", new Object[] { ((com.tencent.mm.g.c.au)localObject2).field_username });
              }
              else if ((((com.tencent.mm.storage.w)localObject3).field_memberCount < com.tencent.mm.model.q.aqC()) && (bt.kU(((com.tencent.mm.storage.w)localObject3).field_roomowner, u.aqG())))
              {
                this.fsy.add(localObject2);
                this.fsz.add(((com.tencent.mm.g.c.au)localObject2).field_username);
                this.fsx.add(((com.tencent.mm.g.c.au)localObject2).field_username);
              }
            }
          }
          this.fsU = this.fsy.size();
          paramString = ((com.tencent.mm.plugin.messenger.foundation.a.k)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.messenger.foundation.a.k.class)).apR().eLh();
          localObject2 = new LinkedList();
          localObject3 = com.tencent.mm.model.w.ars();
          if (((List)localObject3).size() == 0) {}
          for (this.fsE = 0;; this.fsE = (((List)localObject2).size() - this.fsU))
          {
            this.fsR = new LinearLayoutManager();
            this.fsR.setOrientation(1);
            this.fsN.setLayoutManager(this.fsR);
            this.fsT = new ManagerRoomByWeworkUI.b(getContext(), 96.0F);
            this.fsN.a(this.fsT);
            this.fsS = new a(getContext(), this.fsy, this.fsA, this.fsx, new c()
            {
              public final void VC()
              {
                AppMethodBeat.i(196617);
                ManagerRoomByWeworkUI.h(ManagerRoomByWeworkUI.this);
                AppMethodBeat.o(196617);
              }
            });
            this.fsN.setAdapter(this.fsS);
            this.fsN.setNestedScrollingEnabled(false);
            this.fsS.aql.notifyChanged();
            if (this.fsy.size() != 0) {
              break label1596;
            }
            paramInt1 = 0;
            break;
            Iterator localIterator = ((List)localObject3).iterator();
            while (localIterator.hasNext())
            {
              af localaf = (af)localIterator.next();
              if (!com.tencent.mm.model.w.so(localaf.field_username))
              {
                com.tencent.mm.storage.w localw;
                if (!paramString.containsKey(localaf.field_username))
                {
                  if (com.tencent.mm.n.b.ls(localaf.field_type))
                  {
                    localw = ((com.tencent.mm.plugin.chatroom.a.c)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.chatroom.a.c.class)).apV().tH(localaf.field_username);
                    if (localw == null) {
                      ad.e("MicroMsg.ManagerRoomByWeworkUI", "iniOtherChatroomNum %s member is null", new Object[] { bt.by(localaf.field_username, "") });
                    } else if ((localw.ty(u.aqG())) && (c(localaf))) {
                      ((List)localObject2).add(localaf);
                    }
                  }
                }
                else
                {
                  localw = ((com.tencent.mm.plugin.chatroom.a.c)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.chatroom.a.c.class)).apV().tH(localaf.field_username);
                  if (localw == null) {
                    ad.e("MicroMsg.ManagerRoomByWeworkUI", "iniOtherChatroomNum %s member is null", new Object[] { bt.by(localaf.field_username, "") });
                  } else if ((localw.ty(u.aqG())) && (c(localaf))) {
                    ((List)localObject2).add(localaf);
                  }
                }
              }
            }
            ((List)localObject3).clear();
          }
          paramInt1 = 1;
        }
      }
    }
    label1601:
    com.tencent.mm.ui.tools.p.a(this, (NestedScrollView)findViewById(2131304251), findViewById(2131298738), findViewById(2131306201), findViewById(2131297454));
    AppMethodBeat.o(182213);
    return;
    label1643:
    Object localObject2 = getContext();
    paramn = paramString;
    if (bt.isNullOrNil(paramString)) {
      paramn = getString(2131764612);
    }
    t.makeText((Context)localObject2, paramn, 0).show();
    finish();
    AppMethodBeat.o(182213);
    return;
    label1690:
    if ((paramn instanceof com.tencent.mm.chatroom.d.w))
    {
      localObject2 = (com.tencent.mm.chatroom.d.w)paramn;
      if (((com.tencent.mm.chatroom.d.w)localObject2).fpf == null)
      {
        localObject2 = null;
        if (this.fsv != 3) {
          break label1899;
        }
        if (localObject2 == null) {
          break label1877;
        }
        this.fsB.put(((com.tencent.mm.chatroom.d.w)paramn).dlX, Boolean.TRUE);
      }
    }
    else
    {
      label1748:
      if ((this.fsv != 3) || (!(paramn instanceof com.tencent.mm.chatroom.d.w)) || (this.fsC != this.fsD)) {
        break label2442;
      }
      ad.i("MicroMsg.ManagerRoomByWeworkUI", "NetSceneUpgradeAssociateChatRoom finish");
      paramString = new ArrayList();
      paramn = new ArrayList();
      localObject2 = this.fsB.entrySet().iterator();
    }
    for (;;)
    {
      if (!((Iterator)localObject2).hasNext()) {
        break label2294;
      }
      localObject3 = (Map.Entry)((Iterator)localObject2).next();
      if (((Boolean)((Map.Entry)localObject3).getValue()).booleanValue())
      {
        paramString.add(((Map.Entry)localObject3).getKey());
        continue;
        localObject2 = ((com.tencent.mm.chatroom.d.w)localObject2).fpf;
        break;
        label1877:
        this.fsB.put(((com.tencent.mm.chatroom.d.w)paramn).dlX, Boolean.FALSE);
        break label1748;
        label1899:
        if (localObject2 != null)
        {
          c(this.fss, this.fsv, 1, 0);
          paramString = new Intent();
          paramString.setClass(this, WeworkRoomUpgradeResultUI.class);
          paramString.putExtra("RoomInfo_Id", this.fss);
          paramString.putExtra("popup_wording", bt.by(((dgu)localObject2).Exh, ""));
          paramString.putExtra("upgrade_openim_room_from_scene", this.fsv);
          paramString = new com.tencent.mm.hellhoundlib.b.a().bd(paramString);
          com.tencent.mm.hellhoundlib.a.a.a(this, paramString.adn(), "com/tencent/mm/chatroom/ui/ManagerRoomByWeworkUI", "onSceneEnd", "(IILjava/lang/String;Lcom/tencent/mm/modelbase/NetSceneBase;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
          startActivity((Intent)paramString.lS(0));
          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/chatroom/ui/ManagerRoomByWeworkUI", "onSceneEnd", "(IILjava/lang/String;Lcom/tencent/mm/modelbase/NetSceneBase;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
          finish();
          super.overridePendingTransition(2130772144, 2130772141);
          AppMethodBeat.o(182213);
          return;
        }
        localObject2 = getContext();
        paramn = paramString;
        if (bt.isNullOrNil(paramString)) {
          paramn = getString(2131764612);
        }
        t.makeText((Context)localObject2, paramn, 0).show();
        c(this.fss, this.fsv, 2, 4);
        finish();
        AppMethodBeat.o(182213);
        return;
        label2129:
        if ((paramn instanceof com.tencent.mm.chatroom.d.k))
        {
          localObject2 = getContext();
          paramn = paramString;
          if (bt.isNullOrNil(paramString)) {
            paramn = getString(2131764612);
          }
          t.makeText((Context)localObject2, paramn, 0).show();
          finish();
          AppMethodBeat.o(182213);
          return;
        }
        if (!(paramn instanceof com.tencent.mm.chatroom.d.w)) {
          break label1748;
        }
        if (this.fsv == 3)
        {
          this.fsB.put(((com.tencent.mm.chatroom.d.w)paramn).dlX, Boolean.FALSE);
          break label1748;
        }
        c(this.fss, this.fsv, 2, 4);
        localObject2 = getContext();
        paramn = paramString;
        if (bt.isNullOrNil(paramString)) {
          paramn = getString(2131764612);
        }
        t.makeText((Context)localObject2, paramn, 0).show();
        AppMethodBeat.o(182213);
        return;
      }
      paramn.add(((Map.Entry)localObject3).getKey());
    }
    label2294:
    localObject2 = new Intent();
    ((Intent)localObject2).setClass(this, WeworkRoomUpgradeResultUI.class);
    ((Intent)localObject2).putExtra("upgrade_openim_room_from_scene", this.fsv);
    ((Intent)localObject2).putExtra("wework_upgrade_success_list", paramString);
    ((Intent)localObject2).putExtra("wework_upgrade_fail_list", paramn);
    paramn = new com.tencent.mm.hellhoundlib.b.a().bd(localObject2);
    com.tencent.mm.hellhoundlib.a.a.a(this, paramn.adn(), "com/tencent/mm/chatroom/ui/ManagerRoomByWeworkUI", "onSceneEnd", "(IILjava/lang/String;Lcom/tencent/mm/modelbase/NetSceneBase;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
    startActivity((Intent)paramn.lS(0));
    com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/chatroom/ui/ManagerRoomByWeworkUI", "onSceneEnd", "(IILjava/lang/String;Lcom/tencent/mm/modelbase/NetSceneBase;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
    finish();
    super.overridePendingTransition(2130772144, 2130772141);
    f(paramString);
    label2442:
    AppMethodBeat.o(182213);
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
  
  public static final class a
    extends RecyclerView.a
  {
    private Context context;
    private List<af> fsY;
    private List<String> fsZ;
    private HashMap<String, Boolean> fta;
    int ftb;
    private ManagerRoomByWeworkUI.c ftc;
    int ftd;
    int fte;
    
    public a(Context paramContext, List<af> paramList, HashMap<String, Boolean> paramHashMap, List<String> paramList1, ManagerRoomByWeworkUI.c paramc)
    {
      AppMethodBeat.i(196621);
      this.ftb = 0;
      this.ftd = 0;
      this.fte = 0;
      this.context = paramContext;
      this.fsY = paramList;
      this.fta = paramHashMap;
      this.fsZ = paramList1;
      this.ftc = paramc;
      paramContext = paramList.iterator();
      while (paramContext.hasNext()) {
        paramHashMap.put(((af)paramContext.next()).field_username, Boolean.FALSE);
      }
      AppMethodBeat.o(196621);
    }
    
    public final RecyclerView.v a(ViewGroup paramViewGroup, int paramInt)
    {
      AppMethodBeat.i(196622);
      paramViewGroup = new ManagerRoomByWeworkUI.d(LayoutInflater.from(paramViewGroup.getContext()).inflate(2131496145, paramViewGroup, false));
      AppMethodBeat.o(196622);
      return paramViewGroup;
    }
    
    public final void a(RecyclerView.v paramv, int paramInt)
    {
      AppMethodBeat.i(196623);
      ad.d("MicroMsg.ManagerRoomByWeworkUI", "onBindViewHolder() count:%s i:%s ", new Object[] { Integer.valueOf(this.fsY.size()), Integer.valueOf(paramInt) });
      af localaf;
      Boolean localBoolean;
      CheckBox localCheckBox;
      if ((this.fsY != null) && (paramInt >= 0) && (paramInt < this.fsY.size()))
      {
        paramv = (ManagerRoomByWeworkUI.d)paramv;
        localaf = (af)this.fsY.get(paramInt);
        ad.d("MicroMsg.ManagerRoomByWeworkUI", "onBindViewHolder() count:%s i:%s username:%s", new Object[] { Integer.valueOf(this.fsY.size()), Integer.valueOf(paramInt), localaf.field_username });
        paramv.frN.setVisibility(0);
        ManagerRoomByWeworkUI.a(localaf.field_username, paramv.fsH);
        ManagerRoomByWeworkUI.a(this.context, localaf.field_username, paramv.ftj, paramv.ftk, false);
        localBoolean = (Boolean)this.fta.get(localaf.field_username);
        paramv.fti.setEnabled(true);
        localCheckBox = paramv.fti;
        if (localBoolean != null) {
          break label238;
        }
      }
      label238:
      for (boolean bool = false;; bool = localBoolean.booleanValue())
      {
        localCheckBox.setChecked(bool);
        paramv.frN.setTag(localaf);
        paramv.frN.setOnClickListener(new View.OnClickListener()
        {
          public final void onClick(View paramAnonymousView)
          {
            boolean bool = false;
            AppMethodBeat.i(196620);
            paramAnonymousView = (af)paramAnonymousView.getTag();
            if (paramAnonymousView == null)
            {
              ad.e("MicroMsg.ManagerRoomByWeworkUI", "click:contact is nul");
              AppMethodBeat.o(196620);
              return;
            }
            Boolean localBoolean = (Boolean)ManagerRoomByWeworkUI.a.a(ManagerRoomByWeworkUI.a.this).get(paramAnonymousView.field_username);
            if ((!localBoolean.booleanValue()) && (ManagerRoomByWeworkUI.a.b(ManagerRoomByWeworkUI.a.this) == 5))
            {
              t.makeText(ManagerRoomByWeworkUI.a.c(ManagerRoomByWeworkUI.a.this), 2131766408, 0).show();
              AppMethodBeat.o(196620);
              return;
            }
            HashMap localHashMap = ManagerRoomByWeworkUI.a.a(ManagerRoomByWeworkUI.a.this);
            String str = paramAnonymousView.field_username;
            if ((localBoolean == null) || (!localBoolean.booleanValue())) {
              bool = true;
            }
            localHashMap.put(str, Boolean.valueOf(bool));
            if ((localBoolean == null) || (!localBoolean.booleanValue()))
            {
              ManagerRoomByWeworkUI.a.d(ManagerRoomByWeworkUI.a.this);
              if (ManagerRoomByWeworkUI.a.e(ManagerRoomByWeworkUI.a.this).contains(paramAnonymousView.field_username)) {
                ManagerRoomByWeworkUI.a.f(ManagerRoomByWeworkUI.a.this);
              }
            }
            for (;;)
            {
              ManagerRoomByWeworkUI.a.this.aql.notifyChanged();
              if (ManagerRoomByWeworkUI.a.k(ManagerRoomByWeworkUI.a.this) != null) {
                ManagerRoomByWeworkUI.a.k(ManagerRoomByWeworkUI.a.this).VC();
              }
              AppMethodBeat.o(196620);
              return;
              ManagerRoomByWeworkUI.a.g(ManagerRoomByWeworkUI.a.this);
              continue;
              ManagerRoomByWeworkUI.a.h(ManagerRoomByWeworkUI.a.this);
              if (ManagerRoomByWeworkUI.a.e(ManagerRoomByWeworkUI.a.this).contains(paramAnonymousView.field_username)) {
                ManagerRoomByWeworkUI.a.i(ManagerRoomByWeworkUI.a.this);
              } else {
                ManagerRoomByWeworkUI.a.j(ManagerRoomByWeworkUI.a.this);
              }
            }
          }
        });
        AppMethodBeat.o(196623);
        return;
      }
    }
    
    public final int getItemCount()
    {
      AppMethodBeat.i(196624);
      int i = this.fsY.size();
      AppMethodBeat.o(196624);
      return i;
    }
    
    public final int getItemViewType(int paramInt)
    {
      return 0;
    }
  }
  
  public static abstract interface c
  {
    public abstract void VC();
  }
  
  public static final class d
    extends RecyclerView.v
  {
    View frN;
    CdnImageView fsH;
    CheckBox fti;
    TextView ftj;
    TextView ftk;
    
    public d(View paramView)
    {
      super();
      AppMethodBeat.i(196628);
      this.frN = paramView;
      this.fti = ((CheckBox)paramView.findViewById(2131304502));
      this.fsH = ((CdnImageView)paramView.findViewById(2131307168));
      this.ftj = ((TextView)paramView.findViewById(2131307169));
      this.ftk = ((TextView)paramView.findViewById(2131307170));
      AppMethodBeat.o(196628);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.chatroom.ui.ManagerRoomByWeworkUI
 * JD-Core Version:    0.7.0.1
 */