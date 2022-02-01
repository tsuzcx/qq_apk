package com.tencent.mm.chatroom.ui;

import android.app.Activity;
import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.os.Bundle;
import android.support.v4.widget.NestedScrollView;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.RecyclerView.a;
import android.support.v7.widget.RecyclerView.b;
import android.support.v7.widget.RecyclerView.h;
import android.support.v7.widget.RecyclerView.t;
import android.support.v7.widget.RecyclerView.w;
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
import com.tencent.mm.al.f;
import com.tencent.mm.al.n;
import com.tencent.mm.g.b.a.ci;
import com.tencent.mm.g.b.a.ck;
import com.tencent.mm.g.b.a.cl;
import com.tencent.mm.g.c.aw;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.ak;
import com.tencent.mm.model.u;
import com.tencent.mm.model.v;
import com.tencent.mm.plugin.expt.b.b.a;
import com.tencent.mm.plugin.messenger.foundation.a.l;
import com.tencent.mm.pluginsdk.ui.applet.CdnImageView;
import com.tencent.mm.protocal.protobuf.awk;
import com.tencent.mm.protocal.protobuf.dsa;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.aq;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.storage.ab;
import com.tencent.mm.storage.am;
import com.tencent.mm.storage.bp;
import com.tencent.mm.storage.bq;
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
  implements f
{
  public Button fPA;
  private CdnImageView fPB;
  public TextView fPC;
  public TextView fPD;
  public LinearLayout fPE;
  private LinearLayout fPF;
  private LinearLayout fPG;
  private RecyclerView fPH;
  private LinearLayout fPI;
  private TextView fPJ;
  private ImageView fPK;
  private LinearLayoutManager fPL;
  private a fPM;
  private b fPN;
  private int fPO;
  private int fPP;
  private String fPi;
  private int fPp;
  private String fPq;
  private List<String> fPr;
  private List<am> fPs;
  private List<String> fPt;
  private HashMap<String, Boolean> fPu;
  private HashMap<String, Boolean> fPv;
  private int fPw;
  private int fPx;
  private int fPy;
  public Button fPz;
  private com.tencent.mm.ui.base.p tipDialog;
  public TextView titleTv;
  
  public ManagerRoomByWeworkUI()
  {
    AppMethodBeat.i(213520);
    this.fPr = new ArrayList();
    this.fPs = new ArrayList();
    this.fPt = new ArrayList();
    this.fPu = new HashMap();
    this.fPv = new HashMap();
    this.fPw = 0;
    this.fPx = 0;
    this.fPy = 0;
    this.tipDialog = null;
    this.fPO = 0;
    this.fPP = 0;
    AppMethodBeat.o(213520);
  }
  
  private boolean YR()
  {
    AppMethodBeat.i(213522);
    int i;
    if (((com.tencent.mm.plugin.expt.b.b)g.ab(com.tencent.mm.plugin.expt.b.b.class)).a(b.a.qyb, 1) == 1)
    {
      i = 1;
      if ((i == 0) || (!YS())) {
        break label95;
      }
      if ((this.fPr.size() != 0) || (this.fPt.size() != 0)) {
        break label84;
      }
      this.fPI.setVisibility(8);
    }
    for (;;)
    {
      AppMethodBeat.o(213522);
      return true;
      i = 0;
      break;
      label84:
      this.fPI.setVisibility(0);
    }
    label95:
    this.fPI.setVisibility(8);
    this.fPK.setVisibility(8);
    AppMethodBeat.o(213522);
    return false;
  }
  
  private boolean YS()
  {
    AppMethodBeat.i(213523);
    HashMap localHashMap = ((l)g.ab(l.class)).azv().fqM();
    LinkedList localLinkedList = new LinkedList();
    List localList = com.tencent.mm.model.w.aBi();
    if (localList.size() == 0)
    {
      AppMethodBeat.o(213523);
      return false;
    }
    Iterator localIterator = localList.iterator();
    while (localIterator.hasNext())
    {
      am localam = (am)localIterator.next();
      if ((!com.tencent.mm.model.w.zm(localam.field_username)) && (!this.fPt.contains(localam.field_username)))
      {
        ab localab;
        if (!localHashMap.containsKey(localam.field_username))
        {
          if (com.tencent.mm.o.b.lM(localam.field_type))
          {
            localab = ((com.tencent.mm.plugin.chatroom.a.c)g.ab(com.tencent.mm.plugin.chatroom.a.c.class)).azz().AN(localam.field_username);
            if (localab == null) {
              ad.e("MicroMsg.ManagerRoomByWeworkUI", "%s member is null", new Object[] { bt.bI(localam.field_username, "") });
            } else if ((localab.Az(u.aAm())) && (c(localam))) {
              localLinkedList.add(localam);
            }
          }
        }
        else
        {
          localab = ((com.tencent.mm.plugin.chatroom.a.c)g.ab(com.tencent.mm.plugin.chatroom.a.c.class)).azz().AN(localam.field_username);
          if (localab == null) {
            ad.e("MicroMsg.ManagerRoomByWeworkUI", "%s member is null", new Object[] { bt.bI(localam.field_username, "") });
          } else if ((localab.Az(u.aAm())) && (c(localam))) {
            localLinkedList.add(localam);
          }
        }
      }
    }
    localList.clear();
    if (localLinkedList.size() > 0)
    {
      AppMethodBeat.o(213523);
      return true;
    }
    AppMethodBeat.o(213523);
    return false;
  }
  
  private void YT()
  {
    AppMethodBeat.i(213528);
    if (this.fPp == 3)
    {
      if (((com.tencent.mm.plugin.expt.b.b)g.ab(com.tencent.mm.plugin.expt.b.b.class)).a(b.a.qyb, 1) == 1) {}
      for (int i = 1; (i != 0) && (YS()) && (this.fPr.size() == 0) && (this.fPt.size() == 0); i = 0)
      {
        this.fPz.setVisibility(8);
        this.fPA.setVisibility(0);
        AppMethodBeat.o(213528);
        return;
      }
      this.fPz.setVisibility(0);
      this.fPA.setVisibility(8);
      if ((this.fPM != null) && (this.fPM.fPV > 0))
      {
        this.fPz.setEnabled(true);
        AppMethodBeat.o(213528);
        return;
      }
      this.fPz.setEnabled(false);
      AppMethodBeat.o(213528);
      return;
    }
    this.fPz.setVisibility(0);
    this.fPA.setVisibility(8);
    AppMethodBeat.o(213528);
  }
  
  public static void a(Context paramContext, String paramString, TextView paramTextView1, TextView paramTextView2, boolean paramBoolean)
  {
    AppMethodBeat.i(213530);
    SpannableString localSpannableString = com.tencent.mm.pluginsdk.ui.span.k.b(paramContext, v.zf(paramString), com.tencent.mm.cc.a.ax(paramContext, 2131165517));
    Object localObject = localSpannableString;
    if (paramBoolean) {
      localObject = com.tencent.mm.pluginsdk.ui.span.k.d(paramContext, localSpannableString);
    }
    paramTextView1.setText((CharSequence)localObject);
    int i = com.tencent.mm.model.q.yS(((l)g.ab(l.class)).azp().Bf(paramString).field_username);
    if (i == 0)
    {
      paramTextView2.setVisibility(8);
      AppMethodBeat.o(213530);
      return;
    }
    paramTextView2.setVisibility(0);
    paramTextView2.setText(paramContext.getString(2131766410, new Object[] { String.valueOf(i) }));
    AppMethodBeat.o(213530);
  }
  
  private void a(final n paramn, boolean paramBoolean)
  {
    AppMethodBeat.i(213525);
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
          g.aiU().a(paramn);
          if ((paramn instanceof com.tencent.mm.chatroom.d.k)) {
            ManagerRoomByWeworkUI.this.finish();
          }
          AppMethodBeat.o(182211);
        }
      });
      AppMethodBeat.o(213525);
      return;
    }
    if (!this.tipDialog.isShowing()) {
      this.tipDialog.show();
    }
    AppMethodBeat.o(213525);
  }
  
  public static void a(String paramString, final CdnImageView paramCdnImageView)
  {
    AppMethodBeat.i(213529);
    if ((bt.isNullOrNil(paramString)) || (paramCdnImageView == null))
    {
      ad.e("MicroMsg.ManagerRoomByWeworkUI", "username or avatarIv null");
      AppMethodBeat.o(213529);
      return;
    }
    paramString = new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(213509);
        Bitmap localBitmap = com.tencent.mm.ak.c.a(this.fNr, false, -1, null);
        if (localBitmap == null)
        {
          paramCdnImageView.setImageResource(2131231875);
          AppMethodBeat.o(213509);
          return;
        }
        paramCdnImageView.setImageBitmap(localBitmap);
        AppMethodBeat.o(213509);
      }
    };
    if (aq.isMainThread())
    {
      paramString.run();
      AppMethodBeat.o(213529);
      return;
    }
    aq.f(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(213510);
        this.val$run.run();
        AppMethodBeat.o(213510);
      }
    });
    AppMethodBeat.o(213529);
  }
  
  public static void c(String paramString, int paramInt1, int paramInt2, int paramInt3)
  {
    AppMethodBeat.i(182217);
    ci localci = new ci();
    localci.lJ(paramString);
    localci.dVd = paramInt1;
    localci.ecx = paramInt2;
    localci.ecy = paramInt3;
    localci.aLk();
    AppMethodBeat.o(182217);
  }
  
  private static boolean c(am paramam)
  {
    AppMethodBeat.i(213524);
    if (paramam == null)
    {
      AppMethodBeat.o(213524);
      return false;
    }
    ab localab = ((com.tencent.mm.plugin.chatroom.a.c)g.ab(com.tencent.mm.plugin.chatroom.a.c.class)).azz().AN(paramam.field_username);
    if (localab == null)
    {
      ad.e("MicroMsg.ManagerRoomByWeworkUI", "isValidByMaxNum %s member is null", new Object[] { paramam.field_username });
      AppMethodBeat.o(213524);
      return false;
    }
    if (localab.field_memberCount < com.tencent.mm.model.q.aAh())
    {
      AppMethodBeat.o(213524);
      return true;
    }
    AppMethodBeat.o(213524);
    return false;
  }
  
  private void g(ArrayList<String> paramArrayList)
  {
    long l2 = 0L;
    AppMethodBeat.i(213527);
    StringBuilder localStringBuilder = new StringBuilder();
    paramArrayList = paramArrayList.iterator();
    int j = 0;
    int i = 0;
    if (paramArrayList.hasNext())
    {
      String str = (String)paramArrayList.next();
      if (this.fPr.contains(str)) {
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
    paramArrayList = new ck();
    paramArrayList.ecz = i;
    if (this.fPM == null)
    {
      l1 = 0L;
      paramArrayList.ecA = l1;
      paramArrayList.ecB = j;
      if (this.fPM != null) {
        break label230;
      }
    }
    label230:
    for (long l1 = l2;; l1 = this.fPM.fPY - j)
    {
      paramArrayList.ecC = l1;
      paramArrayList.ecD = paramArrayList.t("sucRoomList", localStringBuilder.toString(), true);
      paramArrayList.ecE = paramArrayList.t("ticketId", bt.bI(this.fPq, ""), true);
      paramArrayList.aLk();
      AppMethodBeat.o(213527);
      return;
      l1 = this.fPM.fPX - i;
      break;
    }
  }
  
  public int getLayoutId()
  {
    return 2131493376;
  }
  
  public final void lg(int paramInt)
  {
    long l2 = 0L;
    AppMethodBeat.i(213526);
    cl localcl = new cl();
    localcl.ecF = this.fPO;
    localcl.ecG = this.fPP;
    if (this.fPM == null)
    {
      l1 = 0L;
      localcl.ecH = l1;
      if (this.fPM != null) {
        break label126;
      }
    }
    label126:
    for (long l1 = l2;; l1 = this.fPM.fPY)
    {
      localcl.ecI = l1;
      localcl.ecJ = paramInt;
      localcl.lL(bt.bI(this.fPq, ""));
      localcl.ecL = this.fPy;
      localcl.aLk();
      AppMethodBeat.o(213526);
      return;
      l1 = this.fPM.fPX;
      break;
    }
  }
  
  public void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    AppMethodBeat.i(213521);
    super.onActivityResult(paramInt1, paramInt2, paramIntent);
    ad.i("MicroMsg.ManagerRoomByWeworkUI", "requestCode=%d | resultCode=%d", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) });
    if (paramInt2 != -1)
    {
      AppMethodBeat.o(213521);
      return;
    }
    if (paramInt1 == 0)
    {
      paramIntent = paramIntent.getStringExtra("Select_Conv_User");
      Object localObject = this.fPs.iterator();
      while (((Iterator)localObject).hasNext()) {
        if (bt.lQ(((am)((Iterator)localObject).next()).field_username, paramIntent))
        {
          ad.i("MicroMsg.ManagerRoomByWeworkUI", "onActivityResult contain");
          AppMethodBeat.o(213521);
          return;
        }
      }
      localObject = ((l)g.ab(l.class)).azp().Bf(paramIntent);
      this.fPs.add(localObject);
      this.fPt.add(paramIntent);
      this.fPu.put(((aw)localObject).field_username, Boolean.TRUE);
      this.fPM.asY.notifyChanged();
      YR();
      this.fPM.fPY += 1;
      this.fPM.fPV += 1;
      com.tencent.mm.ui.tools.p.a(this, (NestedScrollView)findViewById(2131304251), findViewById(2131298738), findViewById(2131306201), findViewById(2131297454));
      YT();
    }
    AppMethodBeat.o(213521);
  }
  
  public void onCreate(Bundle paramBundle)
  {
    boolean bool = true;
    AppMethodBeat.i(182212);
    super.onCreate(paramBundle);
    setMMTitle("");
    this.fPi = getIntent().getStringExtra("RoomInfo_Id");
    this.fPp = getIntent().getIntExtra("upgrade_openim_room_from_scene", 0);
    this.fPq = getIntent().getStringExtra("ticket");
    ad.i("MicroMsg.ManagerRoomByWeworkUI", "mFromScene:%s", new Object[] { Integer.valueOf(this.fPp) });
    int i;
    if (this.fPp == 3)
    {
      if (!bt.isNullOrNil(this.fPq)) {
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
      if (bt.isNullOrNil(this.fPi))
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
    g.aiU().a(3553, this);
    g.aiU().a(3927, this);
    ad.i("MicroMsg.ManagerRoomByWeworkUI", "doFetchCollectPubFill() roomId:%s", new Object[] { this.fPi });
    if (this.fPp == 3)
    {
      paramBundle = new com.tencent.mm.chatroom.d.k(this.fPq, (byte)0);
      g.aiU().a(paramBundle, 0);
      if (this.fPp == 3) {
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
          WeworkRoomUpgradeResultUI.bU(ManagerRoomByWeworkUI.this);
          ManagerRoomByWeworkUI.this.finish();
          if (ManagerRoomByWeworkUI.a(ManagerRoomByWeworkUI.this) != 3) {
            ManagerRoomByWeworkUI.c(ManagerRoomByWeworkUI.b(ManagerRoomByWeworkUI.this), ManagerRoomByWeworkUI.a(ManagerRoomByWeworkUI.this), 0, 0);
          }
          for (;;)
          {
            AppMethodBeat.o(182207);
            return true;
            ManagerRoomByWeworkUI.this.lg(0);
          }
        }
      });
      AppMethodBeat.o(182212);
      return;
      paramBundle = new com.tencent.mm.chatroom.d.k(this.fPi);
      break;
      label307:
      bool = false;
    }
  }
  
  public void onDestroy()
  {
    AppMethodBeat.i(182214);
    g.aiU().b(3553, this);
    g.aiU().b(3927, this);
    super.onDestroy();
    AppMethodBeat.o(182214);
  }
  
  public boolean onKeyUp(int paramInt, KeyEvent paramKeyEvent)
  {
    AppMethodBeat.i(182215);
    if (this.fPp != 3) {
      c(this.fPi, this.fPp, 0, 0);
    }
    for (;;)
    {
      boolean bool = super.onKeyUp(paramInt, paramKeyEvent);
      AppMethodBeat.o(182215);
      return bool;
      lg(0);
    }
  }
  
  public void onSceneEnd(int paramInt1, int paramInt2, String paramString, n paramn)
  {
    AppMethodBeat.i(182213);
    ad.i("MicroMsg.ManagerRoomByWeworkUI", "onSceneEnd errType = %d, errCode = %d, errMsg = %s, scenetype:%s", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), paramString, Integer.valueOf(paramn.getType()) });
    label121:
    Object localObject1;
    if ((this.fPp != 3) || ((paramn instanceof com.tencent.mm.chatroom.d.k)))
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
      if (paramn.fKL != null) {
        break label769;
      }
      paramn = null;
      if (paramn == null) {
        break label1643;
      }
      super.initView();
      this.fPz = ((Button)findViewById(2131306228));
      this.fPA = ((Button)findViewById(2131307239));
      this.titleTv = ((TextView)findViewById(2131297973));
      this.fPB = ((CdnImageView)findViewById(2131297960));
      this.fPC = ((TextView)findViewById(2131297972));
      this.fPD = ((TextView)findViewById(2131298777));
      this.fPE = ((LinearLayout)findViewById(2131298764));
      this.fPF = ((LinearLayout)findViewById(2131307196));
      this.fPG = ((LinearLayout)findViewById(2131307167));
      this.fPH = ((RecyclerView)findViewById(2131307150));
      this.fPI = ((LinearLayout)findViewById(2131307241));
      this.fPJ = ((TextView)findViewById(2131307242));
      this.fPK = ((ImageView)findViewById(2131307240));
      findViewById(2131298738).setVisibility(0);
      this.fPz.setOnClickListener(new View.OnClickListener()
      {
        public final void onClick(View paramAnonymousView)
        {
          AppMethodBeat.i(213506);
          com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
          localb.bd(paramAnonymousView);
          com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/chatroom/ui/ManagerRoomByWeworkUI$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.ahq());
          ad.i("MicroMsg.ManagerRoomByWeworkUI", "click use");
          if (ManagerRoomByWeworkUI.a(ManagerRoomByWeworkUI.this) == 3) {
            ManagerRoomByWeworkUI.c(ManagerRoomByWeworkUI.this);
          }
          for (;;)
          {
            com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/chatroom/ui/ManagerRoomByWeworkUI$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
            AppMethodBeat.o(213506);
            return;
            ManagerRoomByWeworkUI.d(ManagerRoomByWeworkUI.this);
          }
        }
      });
      if ((this.fPp != 1) && (this.fPp != 2)) {
        break label852;
      }
      this.fPG.setVisibility(0);
      this.fPF.setVisibility(8);
      a(this.fPi, this.fPB);
      paramString = this.fPi;
      localObject1 = this.fPC;
      paramString = ((l)g.ab(l.class)).azp().Bf(paramString);
      if (!bt.isNullOrNil(paramString.field_nickname)) {
        break label817;
      }
      if (com.tencent.mm.model.q.yS(paramString.field_username) != 0) {
        break label779;
      }
      paramString = getString(2131761169);
      label441:
      ((TextView)localObject1).setText(com.tencent.mm.pluginsdk.ui.span.k.d(this, com.tencent.mm.pluginsdk.ui.span.k.b(this, paramString, com.tencent.mm.cc.a.ax(this, 2131165192))));
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
        YT();
        this.titleTv.setText(paramn.title);
        this.fPD.setText(com.tencent.mm.pluginsdk.ui.span.k.d(getContext(), bt.nullAsNil(paramn.pkw), (int)this.fPD.getTextSize()));
        if ((paramn.GuX == null) || (paramn.GuX.size() <= 0)) {
          break label1601;
        }
        this.fPE.removeAllViews();
        paramString = (LayoutInflater)getContext().getSystemService("layout_inflater");
        paramn = paramn.GuX.iterator();
        paramInt1 = 0;
        while (paramn.hasNext())
        {
          localObject1 = (String)paramn.next();
          localObject3 = paramString.inflate(2131493377, this.fPE, false);
          paramInt1 += 1;
          ((TextView)((View)localObject3).findViewById(2131303086)).setText(paramInt1 + ".");
          ((TextView)((View)localObject3).findViewById(2131299008)).setText((CharSequence)localObject1);
          this.fPE.addView((View)localObject3);
        }
        try
        {
          ad.i("MicroMsg.ManagerRoomByWeworkUI", "NetSceneUpgradeAssociateChatRoom %s", new Object[] { ((com.tencent.mm.chatroom.d.w)paramn).dvs });
          this.fPw += 1;
          if ((this.fPw != this.fPx) || (this.tipDialog == null) || (!this.tipDialog.isShowing())) {
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
      paramn = paramn.fKL;
      break label121;
      paramString = getString(2131759496, new Object[] { getString(2131761169), Integer.valueOf(com.tencent.mm.model.q.yS(paramString.field_username)) });
      break label441;
      paramString = getString(2131759496, new Object[] { paramString.adu(), Integer.valueOf(com.tencent.mm.model.q.yS(paramString.field_username)) });
      break label441;
      label852:
      if (this.fPp == 3)
      {
        this.fPG.setVisibility(8);
        this.fPF.setVisibility(0);
        paramString = new View.OnClickListener()
        {
          public final void onClick(View paramAnonymousView)
          {
            AppMethodBeat.i(213507);
            Object localObject = new com.tencent.mm.hellhoundlib.b.b();
            ((com.tencent.mm.hellhoundlib.b.b)localObject).bd(paramAnonymousView);
            com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/chatroom/ui/ManagerRoomByWeworkUI$3", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, ((com.tencent.mm.hellhoundlib.b.b)localObject).ahq());
            ad.i("MicroMsg.ManagerRoomByWeworkUI", "select_group_ll click");
            ManagerRoomByWeworkUI.e(ManagerRoomByWeworkUI.this);
            if (ManagerRoomByWeworkUI.f(ManagerRoomByWeworkUI.this).fPV == 5)
            {
              t.makeText(ManagerRoomByWeworkUI.this, 2131766408, 0).show();
              com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/chatroom/ui/ManagerRoomByWeworkUI$3", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
              AppMethodBeat.o(213507);
              return;
            }
            paramAnonymousView = new Intent();
            paramAnonymousView.setClassName(ManagerRoomByWeworkUI.this, "com.tencent.mm.ui.contact.GroupCardSelectUI");
            paramAnonymousView.putExtra("group_select_type", true);
            paramAnonymousView.putExtra("group_select_need_result", true);
            paramAnonymousView.putExtra("group_select_only_need_self_owner", true);
            localObject = new ArrayList();
            Iterator localIterator = ManagerRoomByWeworkUI.g(ManagerRoomByWeworkUI.this).iterator();
            while (localIterator.hasNext()) {
              ((ArrayList)localObject).add(((am)localIterator.next()).field_username);
            }
            paramAnonymousView.putStringArrayListExtra("group_select_block_chatroom", (ArrayList)localObject);
            paramAnonymousView.putExtra("group_select_chatroom_max_num", com.tencent.mm.model.q.aAh());
            ManagerRoomByWeworkUI.this.startActivityForResult(paramAnonymousView, 0);
            com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/chatroom/ui/ManagerRoomByWeworkUI$3", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
            AppMethodBeat.o(213507);
          }
        };
        this.fPI.setOnClickListener(paramString);
        this.fPA.setOnClickListener(paramString);
        paramString = com.tencent.mm.model.w.aBi();
        if (paramString.size() == 0) {
          paramInt1 = 0;
        }
        for (;;)
        {
          if ((paramInt1 != 0) || (YR())) {
            break label1599;
          }
          findViewById(2131299477).setVisibility(0);
          findViewById(2131306228).setVisibility(8);
          this.fPF.setVisibility(8);
          break;
          paramString = paramString.iterator();
          while (paramString.hasNext())
          {
            localObject2 = (am)paramString.next();
            if (com.tencent.mm.model.w.zp(((aw)localObject2).field_username))
            {
              localObject3 = ((com.tencent.mm.plugin.chatroom.a.c)g.ab(com.tencent.mm.plugin.chatroom.a.c.class)).azz().AN(((aw)localObject2).field_username);
              if (localObject3 == null)
              {
                ad.e("MicroMsg.ManagerRoomByWeworkUI", "initContactList %s member is null", new Object[] { ((aw)localObject2).field_username });
              }
              else if ((((ab)localObject3).field_memberCount < com.tencent.mm.model.q.aAh()) && (bt.lQ(((ab)localObject3).field_roomowner, u.aAm())))
              {
                this.fPs.add(localObject2);
                this.fPt.add(((aw)localObject2).field_username);
                this.fPr.add(((aw)localObject2).field_username);
              }
            }
          }
          this.fPO = this.fPs.size();
          paramString = ((l)g.ab(l.class)).azv().fqM();
          localObject2 = new LinkedList();
          localObject3 = com.tencent.mm.model.w.aBi();
          if (((List)localObject3).size() == 0) {}
          for (this.fPy = 0;; this.fPy = (((List)localObject2).size() - this.fPO))
          {
            this.fPL = new LinearLayoutManager();
            this.fPL.setOrientation(1);
            this.fPH.setLayoutManager(this.fPL);
            this.fPN = new b(getContext(), 96.0F);
            this.fPH.a(this.fPN);
            this.fPM = new a(getContext(), this.fPs, this.fPu, this.fPr, new c()
            {
              public final void YU()
              {
                AppMethodBeat.i(213508);
                ManagerRoomByWeworkUI.h(ManagerRoomByWeworkUI.this);
                AppMethodBeat.o(213508);
              }
            });
            this.fPH.setAdapter(this.fPM);
            this.fPH.setNestedScrollingEnabled(false);
            this.fPM.asY.notifyChanged();
            if (this.fPs.size() != 0) {
              break label1596;
            }
            paramInt1 = 0;
            break;
            Iterator localIterator = ((List)localObject3).iterator();
            while (localIterator.hasNext())
            {
              am localam = (am)localIterator.next();
              if (!com.tencent.mm.model.w.zm(localam.field_username))
              {
                ab localab;
                if (!paramString.containsKey(localam.field_username))
                {
                  if (com.tencent.mm.o.b.lM(localam.field_type))
                  {
                    localab = ((com.tencent.mm.plugin.chatroom.a.c)g.ab(com.tencent.mm.plugin.chatroom.a.c.class)).azz().AN(localam.field_username);
                    if (localab == null) {
                      ad.e("MicroMsg.ManagerRoomByWeworkUI", "iniOtherChatroomNum %s member is null", new Object[] { bt.bI(localam.field_username, "") });
                    } else if ((localab.Az(u.aAm())) && (c(localam))) {
                      ((List)localObject2).add(localam);
                    }
                  }
                }
                else
                {
                  localab = ((com.tencent.mm.plugin.chatroom.a.c)g.ab(com.tencent.mm.plugin.chatroom.a.c.class)).azz().AN(localam.field_username);
                  if (localab == null) {
                    ad.e("MicroMsg.ManagerRoomByWeworkUI", "iniOtherChatroomNum %s member is null", new Object[] { bt.bI(localam.field_username, "") });
                  } else if ((localab.Az(u.aAm())) && (c(localam))) {
                    ((List)localObject2).add(localam);
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
      if (((com.tencent.mm.chatroom.d.w)localObject2).fLf == null)
      {
        localObject2 = null;
        if (this.fPp != 3) {
          break label1899;
        }
        if (localObject2 == null) {
          break label1877;
        }
        this.fPv.put(((com.tencent.mm.chatroom.d.w)paramn).dvs, Boolean.TRUE);
      }
    }
    else
    {
      label1748:
      if ((this.fPp != 3) || (!(paramn instanceof com.tencent.mm.chatroom.d.w)) || (this.fPw != this.fPx)) {
        break label2442;
      }
      ad.i("MicroMsg.ManagerRoomByWeworkUI", "NetSceneUpgradeAssociateChatRoom finish");
      paramString = new ArrayList();
      paramn = new ArrayList();
      localObject2 = this.fPv.entrySet().iterator();
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
        localObject2 = ((com.tencent.mm.chatroom.d.w)localObject2).fLf;
        break;
        label1877:
        this.fPv.put(((com.tencent.mm.chatroom.d.w)paramn).dvs, Boolean.FALSE);
        break label1748;
        label1899:
        if (localObject2 != null)
        {
          c(this.fPi, this.fPp, 1, 0);
          paramString = new Intent();
          paramString.setClass(this, WeworkRoomUpgradeResultUI.class);
          paramString.putExtra("RoomInfo_Id", this.fPi);
          paramString.putExtra("popup_wording", bt.bI(((dsa)localObject2).HEX, ""));
          paramString.putExtra("upgrade_openim_room_from_scene", this.fPp);
          paramString = new com.tencent.mm.hellhoundlib.b.a().bc(paramString);
          com.tencent.mm.hellhoundlib.a.a.a(this, paramString.ahp(), "com/tencent/mm/chatroom/ui/ManagerRoomByWeworkUI", "onSceneEnd", "(IILjava/lang/String;Lcom/tencent/mm/modelbase/NetSceneBase;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
          startActivity((Intent)paramString.mq(0));
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
        c(this.fPi, this.fPp, 2, 4);
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
        if (this.fPp == 3)
        {
          this.fPv.put(((com.tencent.mm.chatroom.d.w)paramn).dvs, Boolean.FALSE);
          break label1748;
        }
        c(this.fPi, this.fPp, 2, 4);
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
    ((Intent)localObject2).putExtra("upgrade_openim_room_from_scene", this.fPp);
    ((Intent)localObject2).putExtra("wework_upgrade_success_list", paramString);
    ((Intent)localObject2).putExtra("wework_upgrade_fail_list", paramn);
    paramn = new com.tencent.mm.hellhoundlib.b.a().bc(localObject2);
    com.tencent.mm.hellhoundlib.a.a.a(this, paramn.ahp(), "com/tencent/mm/chatroom/ui/ManagerRoomByWeworkUI", "onSceneEnd", "(IILjava/lang/String;Lcom/tencent/mm/modelbase/NetSceneBase;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
    startActivity((Intent)paramn.mq(0));
    com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/chatroom/ui/ManagerRoomByWeworkUI", "onSceneEnd", "(IILjava/lang/String;Lcom/tencent/mm/modelbase/NetSceneBase;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
    finish();
    super.overridePendingTransition(2130772144, 2130772141);
    g(paramString);
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
    private List<am> fPS;
    private List<String> fPT;
    private HashMap<String, Boolean> fPU;
    int fPV;
    private ManagerRoomByWeworkUI.c fPW;
    int fPX;
    int fPY;
    
    public a(Context paramContext, List<am> paramList, HashMap<String, Boolean> paramHashMap, List<String> paramList1, ManagerRoomByWeworkUI.c paramc)
    {
      AppMethodBeat.i(213512);
      this.fPV = 0;
      this.fPX = 0;
      this.fPY = 0;
      this.context = paramContext;
      this.fPS = paramList;
      this.fPU = paramHashMap;
      this.fPT = paramList1;
      this.fPW = paramc;
      paramContext = paramList.iterator();
      while (paramContext.hasNext()) {
        paramHashMap.put(((am)paramContext.next()).field_username, Boolean.FALSE);
      }
      AppMethodBeat.o(213512);
    }
    
    public final RecyclerView.w a(ViewGroup paramViewGroup, int paramInt)
    {
      AppMethodBeat.i(213513);
      paramViewGroup = new ManagerRoomByWeworkUI.d(LayoutInflater.from(paramViewGroup.getContext()).inflate(2131496145, paramViewGroup, false));
      AppMethodBeat.o(213513);
      return paramViewGroup;
    }
    
    public final void a(RecyclerView.w paramw, int paramInt)
    {
      AppMethodBeat.i(213514);
      ad.d("MicroMsg.ManagerRoomByWeworkUI", "onBindViewHolder() count:%s i:%s ", new Object[] { Integer.valueOf(this.fPS.size()), Integer.valueOf(paramInt) });
      am localam;
      Boolean localBoolean;
      CheckBox localCheckBox;
      if ((this.fPS != null) && (paramInt >= 0) && (paramInt < this.fPS.size()))
      {
        paramw = (ManagerRoomByWeworkUI.d)paramw;
        localam = (am)this.fPS.get(paramInt);
        ad.d("MicroMsg.ManagerRoomByWeworkUI", "onBindViewHolder() count:%s i:%s username:%s", new Object[] { Integer.valueOf(this.fPS.size()), Integer.valueOf(paramInt), localam.field_username });
        paramw.fOB.setVisibility(0);
        ManagerRoomByWeworkUI.a(localam.field_username, paramw.fPB);
        ManagerRoomByWeworkUI.a(this.context, localam.field_username, paramw.fQd, paramw.fQe, false);
        localBoolean = (Boolean)this.fPU.get(localam.field_username);
        paramw.fQc.setEnabled(true);
        localCheckBox = paramw.fQc;
        if (localBoolean != null) {
          break label238;
        }
      }
      label238:
      for (boolean bool = false;; bool = localBoolean.booleanValue())
      {
        localCheckBox.setChecked(bool);
        paramw.fOB.setTag(localam);
        paramw.fOB.setOnClickListener(new View.OnClickListener()
        {
          public final void onClick(View paramAnonymousView)
          {
            AppMethodBeat.i(213511);
            Object localObject = new com.tencent.mm.hellhoundlib.b.b();
            ((com.tencent.mm.hellhoundlib.b.b)localObject).bd(paramAnonymousView);
            com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/chatroom/ui/ManagerRoomByWeworkUI$ChatroomAdapter$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, ((com.tencent.mm.hellhoundlib.b.b)localObject).ahq());
            paramAnonymousView = (am)paramAnonymousView.getTag();
            if (paramAnonymousView == null)
            {
              ad.e("MicroMsg.ManagerRoomByWeworkUI", "click:contact is nul");
              com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/chatroom/ui/ManagerRoomByWeworkUI$ChatroomAdapter$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
              AppMethodBeat.o(213511);
              return;
            }
            localObject = (Boolean)ManagerRoomByWeworkUI.a.a(ManagerRoomByWeworkUI.a.this).get(paramAnonymousView.field_username);
            if ((!((Boolean)localObject).booleanValue()) && (ManagerRoomByWeworkUI.a.b(ManagerRoomByWeworkUI.a.this) == 5))
            {
              t.makeText(ManagerRoomByWeworkUI.a.c(ManagerRoomByWeworkUI.a.this), 2131766408, 0).show();
              com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/chatroom/ui/ManagerRoomByWeworkUI$ChatroomAdapter$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
              AppMethodBeat.o(213511);
              return;
            }
            HashMap localHashMap = ManagerRoomByWeworkUI.a.a(ManagerRoomByWeworkUI.a.this);
            String str = paramAnonymousView.field_username;
            boolean bool;
            if ((localObject == null) || (!((Boolean)localObject).booleanValue()))
            {
              bool = true;
              localHashMap.put(str, Boolean.valueOf(bool));
              if ((localObject != null) && (((Boolean)localObject).booleanValue())) {
                break label293;
              }
              ManagerRoomByWeworkUI.a.d(ManagerRoomByWeworkUI.a.this);
              if (!ManagerRoomByWeworkUI.a.e(ManagerRoomByWeworkUI.a.this).contains(paramAnonymousView.field_username)) {
                break label282;
              }
              ManagerRoomByWeworkUI.a.f(ManagerRoomByWeworkUI.a.this);
            }
            for (;;)
            {
              ManagerRoomByWeworkUI.a.this.asY.notifyChanged();
              if (ManagerRoomByWeworkUI.a.k(ManagerRoomByWeworkUI.a.this) != null) {
                ManagerRoomByWeworkUI.a.k(ManagerRoomByWeworkUI.a.this).YU();
              }
              com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/chatroom/ui/ManagerRoomByWeworkUI$ChatroomAdapter$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
              AppMethodBeat.o(213511);
              return;
              bool = false;
              break;
              label282:
              ManagerRoomByWeworkUI.a.g(ManagerRoomByWeworkUI.a.this);
              continue;
              label293:
              ManagerRoomByWeworkUI.a.h(ManagerRoomByWeworkUI.a.this);
              if (ManagerRoomByWeworkUI.a.e(ManagerRoomByWeworkUI.a.this).contains(paramAnonymousView.field_username)) {
                ManagerRoomByWeworkUI.a.i(ManagerRoomByWeworkUI.a.this);
              } else {
                ManagerRoomByWeworkUI.a.j(ManagerRoomByWeworkUI.a.this);
              }
            }
          }
        });
        AppMethodBeat.o(213514);
        return;
      }
    }
    
    public final int getItemCount()
    {
      AppMethodBeat.i(213515);
      int i = this.fPS.size();
      AppMethodBeat.o(213515);
      return i;
    }
    
    public final int getItemViewType(int paramInt)
    {
      return 0;
    }
  }
  
  public static final class b
    extends RecyclerView.h
  {
    private int dividerHeight;
    private Paint fOS;
    private Paint fQa;
    private int fQb;
    
    public b(Context paramContext, float paramFloat)
    {
      AppMethodBeat.i(213516);
      this.dividerHeight = com.tencent.mm.cc.a.g(paramContext, 0.5F);
      this.fQb = com.tencent.mm.cc.a.g(paramContext, paramFloat);
      this.fOS = new Paint();
      this.fOS.setColor(paramContext.getResources().getColor(2131099656));
      this.fQa = new Paint();
      this.fQa.setColor(paramContext.getResources().getColor(2131099679));
      AppMethodBeat.o(213516);
    }
    
    public final void a(Canvas paramCanvas, RecyclerView paramRecyclerView, RecyclerView.t paramt)
    {
      AppMethodBeat.i(213517);
      super.a(paramCanvas, paramRecyclerView, paramt);
      int j = paramRecyclerView.getChildCount();
      int k = paramRecyclerView.getPaddingLeft();
      int m = this.fQb;
      int n = paramRecyclerView.getWidth() - paramRecyclerView.getPaddingRight();
      int i = 0;
      if (i < j)
      {
        paramt = paramRecyclerView.getChildAt(i);
        float f1 = paramt.getBottom();
        float f2 = paramt.getBottom() + this.dividerHeight;
        if (i == j - 1) {
          paramCanvas.drawRect(k, f1, n, f2, this.fQa);
        }
        for (;;)
        {
          i += 1;
          break;
          paramCanvas.drawRect(k + m, f1, n, f2, this.fOS);
        }
      }
      AppMethodBeat.o(213517);
    }
    
    public final void a(Rect paramRect, View paramView, RecyclerView paramRecyclerView, RecyclerView.t paramt)
    {
      AppMethodBeat.i(213518);
      super.a(paramRect, paramView, paramRecyclerView, paramt);
      paramRect.bottom = this.dividerHeight;
      AppMethodBeat.o(213518);
    }
  }
  
  public static abstract interface c
  {
    public abstract void YU();
  }
  
  public static final class d
    extends RecyclerView.w
  {
    View fOB;
    CdnImageView fPB;
    CheckBox fQc;
    TextView fQd;
    TextView fQe;
    
    public d(View paramView)
    {
      super();
      AppMethodBeat.i(213519);
      this.fOB = paramView;
      this.fQc = ((CheckBox)paramView.findViewById(2131304502));
      this.fPB = ((CdnImageView)paramView.findViewById(2131307168));
      this.fQd = ((TextView)paramView.findViewById(2131307169));
      this.fQe = ((TextView)paramView.findViewById(2131307170));
      AppMethodBeat.o(213519);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.chatroom.ui.ManagerRoomByWeworkUI
 * JD-Core Version:    0.7.0.1
 */