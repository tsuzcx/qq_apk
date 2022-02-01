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
import com.tencent.mm.ak.f;
import com.tencent.mm.ak.n;
import com.tencent.mm.ak.q;
import com.tencent.mm.g.b.a.ci;
import com.tencent.mm.g.b.a.ck;
import com.tencent.mm.g.b.a.cl;
import com.tencent.mm.g.c.aw;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.al;
import com.tencent.mm.model.r;
import com.tencent.mm.model.v;
import com.tencent.mm.model.x;
import com.tencent.mm.plugin.expt.b.b.a;
import com.tencent.mm.plugin.messenger.foundation.a.l;
import com.tencent.mm.pluginsdk.ui.applet.CdnImageView;
import com.tencent.mm.protocal.protobuf.axa;
import com.tencent.mm.protocal.protobuf.dsx;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.ar;
import com.tencent.mm.sdk.platformtools.bu;
import com.tencent.mm.storage.ac;
import com.tencent.mm.storage.an;
import com.tencent.mm.storage.bq;
import com.tencent.mm.storage.br;
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
  private HashMap<String, Boolean> fRA;
  private HashMap<String, Boolean> fRB;
  private int fRC;
  private int fRD;
  private int fRE;
  public Button fRF;
  public Button fRG;
  private CdnImageView fRH;
  public TextView fRI;
  public TextView fRJ;
  public LinearLayout fRK;
  private LinearLayout fRL;
  private LinearLayout fRM;
  private RecyclerView fRN;
  private LinearLayout fRO;
  private TextView fRP;
  private ImageView fRQ;
  private LinearLayoutManager fRR;
  private a fRS;
  private ManagerRoomByWeworkUI.b fRT;
  private int fRU;
  private int fRV;
  private String fRo;
  private int fRv;
  private String fRw;
  private List<String> fRx;
  private List<an> fRy;
  private List<String> fRz;
  private com.tencent.mm.ui.base.p tipDialog;
  public TextView titleTv;
  
  public ManagerRoomByWeworkUI()
  {
    AppMethodBeat.i(217237);
    this.fRx = new ArrayList();
    this.fRy = new ArrayList();
    this.fRz = new ArrayList();
    this.fRA = new HashMap();
    this.fRB = new HashMap();
    this.fRC = 0;
    this.fRD = 0;
    this.fRE = 0;
    this.tipDialog = null;
    this.fRU = 0;
    this.fRV = 0;
    AppMethodBeat.o(217237);
  }
  
  private boolean Za()
  {
    AppMethodBeat.i(217239);
    int i;
    if (((com.tencent.mm.plugin.expt.b.b)g.ab(com.tencent.mm.plugin.expt.b.b.class)).a(b.a.qFh, 1) == 1)
    {
      i = 1;
      if ((i == 0) || (!Zb())) {
        break label95;
      }
      if ((this.fRx.size() != 0) || (this.fRz.size() != 0)) {
        break label84;
      }
      this.fRO.setVisibility(8);
    }
    for (;;)
    {
      AppMethodBeat.o(217239);
      return true;
      i = 0;
      break;
      label84:
      this.fRO.setVisibility(0);
    }
    label95:
    this.fRO.setVisibility(8);
    this.fRQ.setVisibility(8);
    AppMethodBeat.o(217239);
    return false;
  }
  
  private boolean Zb()
  {
    AppMethodBeat.i(217240);
    HashMap localHashMap = ((l)g.ab(l.class)).azL().fuM();
    LinkedList localLinkedList = new LinkedList();
    List localList = x.aBy();
    if (localList.size() == 0)
    {
      AppMethodBeat.o(217240);
      return false;
    }
    Iterator localIterator = localList.iterator();
    while (localIterator.hasNext())
    {
      an localan = (an)localIterator.next();
      if ((!x.zW(localan.field_username)) && (!this.fRz.contains(localan.field_username)))
      {
        ac localac;
        if (!localHashMap.containsKey(localan.field_username))
        {
          if (com.tencent.mm.contact.c.lO(localan.field_type))
          {
            localac = ((com.tencent.mm.plugin.chatroom.a.c)g.ab(com.tencent.mm.plugin.chatroom.a.c.class)).azP().Bx(localan.field_username);
            if (localac == null) {
              ae.e("MicroMsg.ManagerRoomByWeworkUI", "%s member is null", new Object[] { bu.bI(localan.field_username, "") });
            } else if ((localac.Bj(v.aAC())) && (c(localan))) {
              localLinkedList.add(localan);
            }
          }
        }
        else
        {
          localac = ((com.tencent.mm.plugin.chatroom.a.c)g.ab(com.tencent.mm.plugin.chatroom.a.c.class)).azP().Bx(localan.field_username);
          if (localac == null) {
            ae.e("MicroMsg.ManagerRoomByWeworkUI", "%s member is null", new Object[] { bu.bI(localan.field_username, "") });
          } else if ((localac.Bj(v.aAC())) && (c(localan))) {
            localLinkedList.add(localan);
          }
        }
      }
    }
    localList.clear();
    if (localLinkedList.size() > 0)
    {
      AppMethodBeat.o(217240);
      return true;
    }
    AppMethodBeat.o(217240);
    return false;
  }
  
  private void Zc()
  {
    AppMethodBeat.i(217245);
    if (this.fRv == 3)
    {
      if (((com.tencent.mm.plugin.expt.b.b)g.ab(com.tencent.mm.plugin.expt.b.b.class)).a(b.a.qFh, 1) == 1) {}
      for (int i = 1; (i != 0) && (Zb()) && (this.fRx.size() == 0) && (this.fRz.size() == 0); i = 0)
      {
        this.fRF.setVisibility(8);
        this.fRG.setVisibility(0);
        AppMethodBeat.o(217245);
        return;
      }
      this.fRF.setVisibility(0);
      this.fRG.setVisibility(8);
      if ((this.fRS != null) && (this.fRS.fSb > 0))
      {
        this.fRF.setEnabled(true);
        AppMethodBeat.o(217245);
        return;
      }
      this.fRF.setEnabled(false);
      AppMethodBeat.o(217245);
      return;
    }
    this.fRF.setVisibility(0);
    this.fRG.setVisibility(8);
    AppMethodBeat.o(217245);
  }
  
  public static void a(Context paramContext, String paramString, TextView paramTextView1, TextView paramTextView2, boolean paramBoolean)
  {
    AppMethodBeat.i(217247);
    SpannableString localSpannableString = com.tencent.mm.pluginsdk.ui.span.k.b(paramContext, com.tencent.mm.model.w.zP(paramString), com.tencent.mm.cb.a.ax(paramContext, 2131165517));
    Object localObject = localSpannableString;
    if (paramBoolean) {
      localObject = com.tencent.mm.pluginsdk.ui.span.k.d(paramContext, localSpannableString);
    }
    paramTextView1.setText((CharSequence)localObject);
    int i = r.zC(((l)g.ab(l.class)).azF().BH(paramString).field_username);
    if (i == 0)
    {
      paramTextView2.setVisibility(8);
      AppMethodBeat.o(217247);
      return;
    }
    paramTextView2.setVisibility(0);
    paramTextView2.setText(paramContext.getString(2131766410, new Object[] { String.valueOf(i) }));
    AppMethodBeat.o(217247);
  }
  
  private void a(final n paramn, boolean paramBoolean)
  {
    AppMethodBeat.i(217242);
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
            ae.i("MicroMsg.ManagerRoomByWeworkUI", "dialog onCancel scene is null");
            AppMethodBeat.o(182211);
            return;
          }
          ae.i("MicroMsg.ManagerRoomByWeworkUI", "dialog onCancel scene:%s", new Object[] { Integer.valueOf(paramn.getType()) });
          g.ajj().a(paramn);
          if ((paramn instanceof com.tencent.mm.chatroom.d.k)) {
            ManagerRoomByWeworkUI.this.finish();
          }
          AppMethodBeat.o(182211);
        }
      });
      AppMethodBeat.o(217242);
      return;
    }
    if (!this.tipDialog.isShowing()) {
      this.tipDialog.show();
    }
    AppMethodBeat.o(217242);
  }
  
  public static void a(String paramString, final CdnImageView paramCdnImageView)
  {
    AppMethodBeat.i(217246);
    if ((bu.isNullOrNil(paramString)) || (paramCdnImageView == null))
    {
      ae.e("MicroMsg.ManagerRoomByWeworkUI", "username or avatarIv null");
      AppMethodBeat.o(217246);
      return;
    }
    paramString = new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(217226);
        Bitmap localBitmap = com.tencent.mm.aj.c.a(this.fOj, false, -1, null);
        if (localBitmap == null)
        {
          paramCdnImageView.setImageResource(2131231875);
          AppMethodBeat.o(217226);
          return;
        }
        paramCdnImageView.setImageBitmap(localBitmap);
        AppMethodBeat.o(217226);
      }
    };
    if (ar.isMainThread())
    {
      paramString.run();
      AppMethodBeat.o(217246);
      return;
    }
    ar.f(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(217227);
        this.val$run.run();
        AppMethodBeat.o(217227);
      }
    });
    AppMethodBeat.o(217246);
  }
  
  public static void c(String paramString, int paramInt1, int paramInt2, int paramInt3)
  {
    AppMethodBeat.i(182217);
    ci localci = new ci();
    localci.ma(paramString);
    localci.dWt = paramInt1;
    localci.edS = paramInt2;
    localci.edT = paramInt3;
    localci.aLH();
    AppMethodBeat.o(182217);
  }
  
  private static boolean c(an paraman)
  {
    AppMethodBeat.i(217241);
    if (paraman == null)
    {
      AppMethodBeat.o(217241);
      return false;
    }
    ac localac = ((com.tencent.mm.plugin.chatroom.a.c)g.ab(com.tencent.mm.plugin.chatroom.a.c.class)).azP().Bx(paraman.field_username);
    if (localac == null)
    {
      ae.e("MicroMsg.ManagerRoomByWeworkUI", "isValidByMaxNum %s member is null", new Object[] { paraman.field_username });
      AppMethodBeat.o(217241);
      return false;
    }
    if (localac.field_memberCount < r.aAx())
    {
      AppMethodBeat.o(217241);
      return true;
    }
    AppMethodBeat.o(217241);
    return false;
  }
  
  private void g(ArrayList<String> paramArrayList)
  {
    long l2 = 0L;
    AppMethodBeat.i(217244);
    StringBuilder localStringBuilder = new StringBuilder();
    paramArrayList = paramArrayList.iterator();
    int j = 0;
    int i = 0;
    if (paramArrayList.hasNext())
    {
      String str = (String)paramArrayList.next();
      if (this.fRx.contains(str)) {
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
    paramArrayList.edU = i;
    if (this.fRS == null)
    {
      l1 = 0L;
      paramArrayList.edV = l1;
      paramArrayList.edW = j;
      if (this.fRS != null) {
        break label230;
      }
    }
    label230:
    for (long l1 = l2;; l1 = this.fRS.fSe - j)
    {
      paramArrayList.edX = l1;
      paramArrayList.edY = paramArrayList.t("sucRoomList", localStringBuilder.toString(), true);
      paramArrayList.edZ = paramArrayList.t("ticketId", bu.bI(this.fRw, ""), true);
      paramArrayList.aLH();
      AppMethodBeat.o(217244);
      return;
      l1 = this.fRS.fSd - i;
      break;
    }
  }
  
  public int getLayoutId()
  {
    return 2131493376;
  }
  
  public final void li(int paramInt)
  {
    long l2 = 0L;
    AppMethodBeat.i(217243);
    cl localcl = new cl();
    localcl.eea = this.fRU;
    localcl.eeb = this.fRV;
    if (this.fRS == null)
    {
      l1 = 0L;
      localcl.eec = l1;
      if (this.fRS != null) {
        break label126;
      }
    }
    label126:
    for (long l1 = l2;; l1 = this.fRS.fSe)
    {
      localcl.eed = l1;
      localcl.eee = paramInt;
      localcl.mc(bu.bI(this.fRw, ""));
      localcl.eeg = this.fRE;
      localcl.aLH();
      AppMethodBeat.o(217243);
      return;
      l1 = this.fRS.fSd;
      break;
    }
  }
  
  public void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    AppMethodBeat.i(217238);
    super.onActivityResult(paramInt1, paramInt2, paramIntent);
    ae.i("MicroMsg.ManagerRoomByWeworkUI", "requestCode=%d | resultCode=%d", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) });
    if (paramInt2 != -1)
    {
      AppMethodBeat.o(217238);
      return;
    }
    if (paramInt1 == 0)
    {
      paramIntent = paramIntent.getStringExtra("Select_Conv_User");
      Object localObject = this.fRy.iterator();
      while (((Iterator)localObject).hasNext()) {
        if (bu.lX(((an)((Iterator)localObject).next()).field_username, paramIntent))
        {
          ae.i("MicroMsg.ManagerRoomByWeworkUI", "onActivityResult contain");
          AppMethodBeat.o(217238);
          return;
        }
      }
      localObject = ((l)g.ab(l.class)).azF().BH(paramIntent);
      this.fRy.add(localObject);
      this.fRz.add(paramIntent);
      this.fRA.put(((aw)localObject).field_username, Boolean.TRUE);
      this.fRS.asY.notifyChanged();
      Za();
      this.fRS.fSe += 1;
      this.fRS.fSb += 1;
      com.tencent.mm.ui.tools.p.a(this, (NestedScrollView)findViewById(2131304251), findViewById(2131298738), findViewById(2131306201), findViewById(2131297454));
      Zc();
    }
    AppMethodBeat.o(217238);
  }
  
  public void onCreate(Bundle paramBundle)
  {
    boolean bool = true;
    AppMethodBeat.i(182212);
    super.onCreate(paramBundle);
    setMMTitle("");
    this.fRo = getIntent().getStringExtra("RoomInfo_Id");
    this.fRv = getIntent().getIntExtra("upgrade_openim_room_from_scene", 0);
    this.fRw = getIntent().getStringExtra("ticket");
    ae.i("MicroMsg.ManagerRoomByWeworkUI", "mFromScene:%s", new Object[] { Integer.valueOf(this.fRv) });
    int i;
    if (this.fRv == 3)
    {
      if (!bu.isNullOrNil(this.fRw)) {
        break label154;
      }
      ae.e("MicroMsg.ManagerRoomByWeworkUI", "mTicket is null");
      finish();
      i = 0;
    }
    while (i == 0)
    {
      AppMethodBeat.o(182212);
      return;
      if (bu.isNullOrNil(this.fRo))
      {
        ae.e("MicroMsg.ManagerRoomByWeworkUI", "mRoomId is null");
        finish();
        i = 0;
      }
      else
      {
        label154:
        i = 1;
      }
    }
    g.ajj().a(3553, this);
    g.ajj().a(3927, this);
    ae.i("MicroMsg.ManagerRoomByWeworkUI", "doFetchCollectPubFill() roomId:%s", new Object[] { this.fRo });
    if (this.fRv == 3)
    {
      paramBundle = new com.tencent.mm.chatroom.d.k(this.fRw, (byte)0);
      g.ajj().a(paramBundle, 0);
      if (this.fRv == 3) {
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
          ae.i("MicroMsg.ManagerRoomByWeworkUI", "onMenuItemClick click");
          WeworkRoomUpgradeResultUI.bW(ManagerRoomByWeworkUI.this);
          ManagerRoomByWeworkUI.this.finish();
          if (ManagerRoomByWeworkUI.a(ManagerRoomByWeworkUI.this) != 3) {
            ManagerRoomByWeworkUI.c(ManagerRoomByWeworkUI.b(ManagerRoomByWeworkUI.this), ManagerRoomByWeworkUI.a(ManagerRoomByWeworkUI.this), 0, 0);
          }
          for (;;)
          {
            AppMethodBeat.o(182207);
            return true;
            ManagerRoomByWeworkUI.this.li(0);
          }
        }
      });
      AppMethodBeat.o(182212);
      return;
      paramBundle = new com.tencent.mm.chatroom.d.k(this.fRo);
      break;
      label307:
      bool = false;
    }
  }
  
  public void onDestroy()
  {
    AppMethodBeat.i(182214);
    g.ajj().b(3553, this);
    g.ajj().b(3927, this);
    super.onDestroy();
    AppMethodBeat.o(182214);
  }
  
  public boolean onKeyUp(int paramInt, KeyEvent paramKeyEvent)
  {
    AppMethodBeat.i(182215);
    if (this.fRv != 3) {
      c(this.fRo, this.fRv, 0, 0);
    }
    for (;;)
    {
      boolean bool = super.onKeyUp(paramInt, paramKeyEvent);
      AppMethodBeat.o(182215);
      return bool;
      li(0);
    }
  }
  
  public void onSceneEnd(int paramInt1, int paramInt2, String paramString, n paramn)
  {
    AppMethodBeat.i(182213);
    ae.i("MicroMsg.ManagerRoomByWeworkUI", "onSceneEnd errType = %d, errCode = %d, errMsg = %s, scenetype:%s", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), paramString, Integer.valueOf(paramn.getType()) });
    label121:
    Object localObject1;
    if ((this.fRv != 3) || ((paramn instanceof com.tencent.mm.chatroom.d.k)))
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
      if (paramn.fMO != null) {
        break label769;
      }
      paramn = null;
      if (paramn == null) {
        break label1643;
      }
      super.initView();
      this.fRF = ((Button)findViewById(2131306228));
      this.fRG = ((Button)findViewById(2131307239));
      this.titleTv = ((TextView)findViewById(2131297973));
      this.fRH = ((CdnImageView)findViewById(2131297960));
      this.fRI = ((TextView)findViewById(2131297972));
      this.fRJ = ((TextView)findViewById(2131298777));
      this.fRK = ((LinearLayout)findViewById(2131298764));
      this.fRL = ((LinearLayout)findViewById(2131307196));
      this.fRM = ((LinearLayout)findViewById(2131307167));
      this.fRN = ((RecyclerView)findViewById(2131307150));
      this.fRO = ((LinearLayout)findViewById(2131307241));
      this.fRP = ((TextView)findViewById(2131307242));
      this.fRQ = ((ImageView)findViewById(2131307240));
      findViewById(2131298738).setVisibility(0);
      this.fRF.setOnClickListener(new View.OnClickListener()
      {
        public final void onClick(View paramAnonymousView)
        {
          AppMethodBeat.i(217223);
          com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
          localb.bd(paramAnonymousView);
          com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/chatroom/ui/ManagerRoomByWeworkUI$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.ahF());
          ae.i("MicroMsg.ManagerRoomByWeworkUI", "click use");
          if (ManagerRoomByWeworkUI.a(ManagerRoomByWeworkUI.this) == 3) {
            ManagerRoomByWeworkUI.c(ManagerRoomByWeworkUI.this);
          }
          for (;;)
          {
            com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/chatroom/ui/ManagerRoomByWeworkUI$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
            AppMethodBeat.o(217223);
            return;
            ManagerRoomByWeworkUI.d(ManagerRoomByWeworkUI.this);
          }
        }
      });
      if ((this.fRv != 1) && (this.fRv != 2)) {
        break label852;
      }
      this.fRM.setVisibility(0);
      this.fRL.setVisibility(8);
      a(this.fRo, this.fRH);
      paramString = this.fRo;
      localObject1 = this.fRI;
      paramString = ((l)g.ab(l.class)).azF().BH(paramString);
      if (!bu.isNullOrNil(paramString.field_nickname)) {
        break label817;
      }
      if (r.zC(paramString.field_username) != 0) {
        break label779;
      }
      paramString = getString(2131761169);
      label441:
      ((TextView)localObject1).setText(com.tencent.mm.pluginsdk.ui.span.k.d(this, com.tencent.mm.pluginsdk.ui.span.k.b(this, paramString, com.tencent.mm.cb.a.ax(this, 2131165192))));
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
        Zc();
        this.titleTv.setText(paramn.title);
        this.fRJ.setText(com.tencent.mm.pluginsdk.ui.span.k.d(getContext(), bu.nullAsNil(paramn.prb), (int)this.fRJ.getTextSize()));
        if ((paramn.GOw == null) || (paramn.GOw.size() <= 0)) {
          break label1601;
        }
        this.fRK.removeAllViews();
        paramString = (LayoutInflater)getContext().getSystemService("layout_inflater");
        paramn = paramn.GOw.iterator();
        paramInt1 = 0;
        while (paramn.hasNext())
        {
          localObject1 = (String)paramn.next();
          localObject3 = paramString.inflate(2131493377, this.fRK, false);
          paramInt1 += 1;
          ((TextView)((View)localObject3).findViewById(2131303086)).setText(paramInt1 + ".");
          ((TextView)((View)localObject3).findViewById(2131299008)).setText((CharSequence)localObject1);
          this.fRK.addView((View)localObject3);
        }
        try
        {
          ae.i("MicroMsg.ManagerRoomByWeworkUI", "NetSceneUpgradeAssociateChatRoom %s", new Object[] { ((com.tencent.mm.chatroom.d.w)paramn).dwx });
          this.fRC += 1;
          if ((this.fRC != this.fRD) || (this.tipDialog == null) || (!this.tipDialog.isShowing())) {
            break;
          }
          this.tipDialog.dismiss();
        }
        catch (Exception localException)
        {
          for (;;)
          {
            ae.e("MicroMsg.ManagerRoomByWeworkUI", "NetSceneUpgradeAssociateChatRoom Exception:%s %s", new Object[] { localException.getClass().getSimpleName(), localException.getMessage() });
          }
        }
      }
      paramn = paramn.fMO;
      break label121;
      paramString = getString(2131759496, new Object[] { getString(2131761169), Integer.valueOf(r.zC(paramString.field_username)) });
      break label441;
      paramString = getString(2131759496, new Object[] { paramString.adF(), Integer.valueOf(r.zC(paramString.field_username)) });
      break label441;
      label852:
      if (this.fRv == 3)
      {
        this.fRM.setVisibility(8);
        this.fRL.setVisibility(0);
        paramString = new ManagerRoomByWeworkUI.3(this);
        this.fRO.setOnClickListener(paramString);
        this.fRG.setOnClickListener(paramString);
        paramString = x.aBy();
        if (paramString.size() == 0) {
          paramInt1 = 0;
        }
        for (;;)
        {
          if ((paramInt1 != 0) || (Za())) {
            break label1599;
          }
          findViewById(2131299477).setVisibility(0);
          findViewById(2131306228).setVisibility(8);
          this.fRL.setVisibility(8);
          break;
          paramString = paramString.iterator();
          while (paramString.hasNext())
          {
            localObject2 = (an)paramString.next();
            if (x.zZ(((aw)localObject2).field_username))
            {
              localObject3 = ((com.tencent.mm.plugin.chatroom.a.c)g.ab(com.tencent.mm.plugin.chatroom.a.c.class)).azP().Bx(((aw)localObject2).field_username);
              if (localObject3 == null)
              {
                ae.e("MicroMsg.ManagerRoomByWeworkUI", "initContactList %s member is null", new Object[] { ((aw)localObject2).field_username });
              }
              else if ((((ac)localObject3).field_memberCount < r.aAx()) && (bu.lX(((ac)localObject3).field_roomowner, v.aAC())))
              {
                this.fRy.add(localObject2);
                this.fRz.add(((aw)localObject2).field_username);
                this.fRx.add(((aw)localObject2).field_username);
              }
            }
          }
          this.fRU = this.fRy.size();
          paramString = ((l)g.ab(l.class)).azL().fuM();
          localObject2 = new LinkedList();
          localObject3 = x.aBy();
          if (((List)localObject3).size() == 0) {}
          for (this.fRE = 0;; this.fRE = (((List)localObject2).size() - this.fRU))
          {
            this.fRR = new LinearLayoutManager();
            this.fRR.setOrientation(1);
            this.fRN.setLayoutManager(this.fRR);
            this.fRT = new ManagerRoomByWeworkUI.b(getContext(), 96.0F);
            this.fRN.a(this.fRT);
            this.fRS = new a(getContext(), this.fRy, this.fRA, this.fRx, new c()
            {
              public final void Zd()
              {
                AppMethodBeat.i(217225);
                ManagerRoomByWeworkUI.h(ManagerRoomByWeworkUI.this);
                AppMethodBeat.o(217225);
              }
            });
            this.fRN.setAdapter(this.fRS);
            this.fRN.setNestedScrollingEnabled(false);
            this.fRS.asY.notifyChanged();
            if (this.fRy.size() != 0) {
              break label1596;
            }
            paramInt1 = 0;
            break;
            Iterator localIterator = ((List)localObject3).iterator();
            while (localIterator.hasNext())
            {
              an localan = (an)localIterator.next();
              if (!x.zW(localan.field_username))
              {
                ac localac;
                if (!paramString.containsKey(localan.field_username))
                {
                  if (com.tencent.mm.contact.c.lO(localan.field_type))
                  {
                    localac = ((com.tencent.mm.plugin.chatroom.a.c)g.ab(com.tencent.mm.plugin.chatroom.a.c.class)).azP().Bx(localan.field_username);
                    if (localac == null) {
                      ae.e("MicroMsg.ManagerRoomByWeworkUI", "iniOtherChatroomNum %s member is null", new Object[] { bu.bI(localan.field_username, "") });
                    } else if ((localac.Bj(v.aAC())) && (c(localan))) {
                      ((List)localObject2).add(localan);
                    }
                  }
                }
                else
                {
                  localac = ((com.tencent.mm.plugin.chatroom.a.c)g.ab(com.tencent.mm.plugin.chatroom.a.c.class)).azP().Bx(localan.field_username);
                  if (localac == null) {
                    ae.e("MicroMsg.ManagerRoomByWeworkUI", "iniOtherChatroomNum %s member is null", new Object[] { bu.bI(localan.field_username, "") });
                  } else if ((localac.Bj(v.aAC())) && (c(localan))) {
                    ((List)localObject2).add(localan);
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
    if (bu.isNullOrNil(paramString)) {
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
      if (((com.tencent.mm.chatroom.d.w)localObject2).fNj == null)
      {
        localObject2 = null;
        if (this.fRv != 3) {
          break label1899;
        }
        if (localObject2 == null) {
          break label1877;
        }
        this.fRB.put(((com.tencent.mm.chatroom.d.w)paramn).dwx, Boolean.TRUE);
      }
    }
    else
    {
      label1748:
      if ((this.fRv != 3) || (!(paramn instanceof com.tencent.mm.chatroom.d.w)) || (this.fRC != this.fRD)) {
        break label2442;
      }
      ae.i("MicroMsg.ManagerRoomByWeworkUI", "NetSceneUpgradeAssociateChatRoom finish");
      paramString = new ArrayList();
      paramn = new ArrayList();
      localObject2 = this.fRB.entrySet().iterator();
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
        localObject2 = ((com.tencent.mm.chatroom.d.w)localObject2).fNj;
        break;
        label1877:
        this.fRB.put(((com.tencent.mm.chatroom.d.w)paramn).dwx, Boolean.FALSE);
        break label1748;
        label1899:
        if (localObject2 != null)
        {
          c(this.fRo, this.fRv, 1, 0);
          paramString = new Intent();
          paramString.setClass(this, WeworkRoomUpgradeResultUI.class);
          paramString.putExtra("RoomInfo_Id", this.fRo);
          paramString.putExtra("popup_wording", bu.bI(((dsx)localObject2).HYK, ""));
          paramString.putExtra("upgrade_openim_room_from_scene", this.fRv);
          paramString = new com.tencent.mm.hellhoundlib.b.a().bc(paramString);
          com.tencent.mm.hellhoundlib.a.a.a(this, paramString.ahE(), "com/tencent/mm/chatroom/ui/ManagerRoomByWeworkUI", "onSceneEnd", "(IILjava/lang/String;Lcom/tencent/mm/modelbase/NetSceneBase;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
          startActivity((Intent)paramString.mt(0));
          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/chatroom/ui/ManagerRoomByWeworkUI", "onSceneEnd", "(IILjava/lang/String;Lcom/tencent/mm/modelbase/NetSceneBase;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
          finish();
          super.overridePendingTransition(2130772144, 2130772141);
          AppMethodBeat.o(182213);
          return;
        }
        localObject2 = getContext();
        paramn = paramString;
        if (bu.isNullOrNil(paramString)) {
          paramn = getString(2131764612);
        }
        t.makeText((Context)localObject2, paramn, 0).show();
        c(this.fRo, this.fRv, 2, 4);
        finish();
        AppMethodBeat.o(182213);
        return;
        label2129:
        if ((paramn instanceof com.tencent.mm.chatroom.d.k))
        {
          localObject2 = getContext();
          paramn = paramString;
          if (bu.isNullOrNil(paramString)) {
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
        if (this.fRv == 3)
        {
          this.fRB.put(((com.tencent.mm.chatroom.d.w)paramn).dwx, Boolean.FALSE);
          break label1748;
        }
        c(this.fRo, this.fRv, 2, 4);
        localObject2 = getContext();
        paramn = paramString;
        if (bu.isNullOrNil(paramString)) {
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
    ((Intent)localObject2).putExtra("upgrade_openim_room_from_scene", this.fRv);
    ((Intent)localObject2).putExtra("wework_upgrade_success_list", paramString);
    ((Intent)localObject2).putExtra("wework_upgrade_fail_list", paramn);
    paramn = new com.tencent.mm.hellhoundlib.b.a().bc(localObject2);
    com.tencent.mm.hellhoundlib.a.a.a(this, paramn.ahE(), "com/tencent/mm/chatroom/ui/ManagerRoomByWeworkUI", "onSceneEnd", "(IILjava/lang/String;Lcom/tencent/mm/modelbase/NetSceneBase;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
    startActivity((Intent)paramn.mt(0));
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
    private List<an> fRY;
    private List<String> fRZ;
    private HashMap<String, Boolean> fSa;
    int fSb;
    private ManagerRoomByWeworkUI.c fSc;
    int fSd;
    int fSe;
    
    public a(Context paramContext, List<an> paramList, HashMap<String, Boolean> paramHashMap, List<String> paramList1, ManagerRoomByWeworkUI.c paramc)
    {
      AppMethodBeat.i(217229);
      this.fSb = 0;
      this.fSd = 0;
      this.fSe = 0;
      this.context = paramContext;
      this.fRY = paramList;
      this.fSa = paramHashMap;
      this.fRZ = paramList1;
      this.fSc = paramc;
      paramContext = paramList.iterator();
      while (paramContext.hasNext()) {
        paramHashMap.put(((an)paramContext.next()).field_username, Boolean.FALSE);
      }
      AppMethodBeat.o(217229);
    }
    
    public final RecyclerView.w a(ViewGroup paramViewGroup, int paramInt)
    {
      AppMethodBeat.i(217230);
      paramViewGroup = new ManagerRoomByWeworkUI.d(LayoutInflater.from(paramViewGroup.getContext()).inflate(2131496145, paramViewGroup, false));
      AppMethodBeat.o(217230);
      return paramViewGroup;
    }
    
    public final void a(RecyclerView.w paramw, int paramInt)
    {
      AppMethodBeat.i(217231);
      ae.d("MicroMsg.ManagerRoomByWeworkUI", "onBindViewHolder() count:%s i:%s ", new Object[] { Integer.valueOf(this.fRY.size()), Integer.valueOf(paramInt) });
      an localan;
      Boolean localBoolean;
      CheckBox localCheckBox;
      if ((this.fRY != null) && (paramInt >= 0) && (paramInt < this.fRY.size()))
      {
        paramw = (ManagerRoomByWeworkUI.d)paramw;
        localan = (an)this.fRY.get(paramInt);
        ae.d("MicroMsg.ManagerRoomByWeworkUI", "onBindViewHolder() count:%s i:%s username:%s", new Object[] { Integer.valueOf(this.fRY.size()), Integer.valueOf(paramInt), localan.field_username });
        paramw.fQH.setVisibility(0);
        ManagerRoomByWeworkUI.a(localan.field_username, paramw.fRH);
        ManagerRoomByWeworkUI.a(this.context, localan.field_username, paramw.fSj, paramw.fSk, false);
        localBoolean = (Boolean)this.fSa.get(localan.field_username);
        paramw.fSi.setEnabled(true);
        localCheckBox = paramw.fSi;
        if (localBoolean != null) {
          break label238;
        }
      }
      label238:
      for (boolean bool = false;; bool = localBoolean.booleanValue())
      {
        localCheckBox.setChecked(bool);
        paramw.fQH.setTag(localan);
        paramw.fQH.setOnClickListener(new View.OnClickListener()
        {
          public final void onClick(View paramAnonymousView)
          {
            AppMethodBeat.i(217228);
            Object localObject = new com.tencent.mm.hellhoundlib.b.b();
            ((com.tencent.mm.hellhoundlib.b.b)localObject).bd(paramAnonymousView);
            com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/chatroom/ui/ManagerRoomByWeworkUI$ChatroomAdapter$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, ((com.tencent.mm.hellhoundlib.b.b)localObject).ahF());
            paramAnonymousView = (an)paramAnonymousView.getTag();
            if (paramAnonymousView == null)
            {
              ae.e("MicroMsg.ManagerRoomByWeworkUI", "click:contact is nul");
              com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/chatroom/ui/ManagerRoomByWeworkUI$ChatroomAdapter$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
              AppMethodBeat.o(217228);
              return;
            }
            localObject = (Boolean)ManagerRoomByWeworkUI.a.a(ManagerRoomByWeworkUI.a.this).get(paramAnonymousView.field_username);
            if ((!((Boolean)localObject).booleanValue()) && (ManagerRoomByWeworkUI.a.b(ManagerRoomByWeworkUI.a.this) == 5))
            {
              t.makeText(ManagerRoomByWeworkUI.a.c(ManagerRoomByWeworkUI.a.this), 2131766408, 0).show();
              com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/chatroom/ui/ManagerRoomByWeworkUI$ChatroomAdapter$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
              AppMethodBeat.o(217228);
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
                ManagerRoomByWeworkUI.a.k(ManagerRoomByWeworkUI.a.this).Zd();
              }
              com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/chatroom/ui/ManagerRoomByWeworkUI$ChatroomAdapter$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
              AppMethodBeat.o(217228);
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
        AppMethodBeat.o(217231);
        return;
      }
    }
    
    public final int getItemCount()
    {
      AppMethodBeat.i(217232);
      int i = this.fRY.size();
      AppMethodBeat.o(217232);
      return i;
    }
    
    public final int getItemViewType(int paramInt)
    {
      return 0;
    }
  }
  
  public static abstract interface c
  {
    public abstract void Zd();
  }
  
  public static final class d
    extends RecyclerView.w
  {
    View fQH;
    CdnImageView fRH;
    CheckBox fSi;
    TextView fSj;
    TextView fSk;
    
    public d(View paramView)
    {
      super();
      AppMethodBeat.i(217236);
      this.fQH = paramView;
      this.fSi = ((CheckBox)paramView.findViewById(2131304502));
      this.fRH = ((CdnImageView)paramView.findViewById(2131307168));
      this.fSj = ((TextView)paramView.findViewById(2131307169));
      this.fSk = ((TextView)paramView.findViewById(2131307170));
      AppMethodBeat.o(217236);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.chatroom.ui.ManagerRoomByWeworkUI
 * JD-Core Version:    0.7.0.1
 */