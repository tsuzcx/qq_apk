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
import com.tencent.mm.ak.n;
import com.tencent.mm.g.b.a.br;
import com.tencent.mm.g.b.a.bt;
import com.tencent.mm.g.b.a.bu;
import com.tencent.mm.g.c.av;
import com.tencent.mm.model.aj;
import com.tencent.mm.model.u;
import com.tencent.mm.model.v;
import com.tencent.mm.plugin.expt.a.b.a;
import com.tencent.mm.pluginsdk.ui.applet.CdnImageView;
import com.tencent.mm.protocal.protobuf.asm;
import com.tencent.mm.protocal.protobuf.dmj;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.ap;
import com.tencent.mm.sdk.platformtools.bs;
import com.tencent.mm.storage.ai;
import com.tencent.mm.storage.bj;
import com.tencent.mm.storage.bk;
import com.tencent.mm.storage.x;
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
  implements com.tencent.mm.ak.g
{
  private String fvZ;
  private b fwA;
  private int fwB;
  private int fwC;
  private int fwc;
  private String fwd;
  private List<String> fwe;
  private List<ai> fwf;
  private List<String> fwg;
  private HashMap<String, Boolean> fwh;
  private HashMap<String, Boolean> fwi;
  private int fwj;
  private int fwk;
  private int fwl;
  public Button fwm;
  public Button fwn;
  private CdnImageView fwo;
  public TextView fwp;
  public TextView fwq;
  public LinearLayout fwr;
  private LinearLayout fws;
  private LinearLayout fwt;
  private RecyclerView fwu;
  private LinearLayout fwv;
  private TextView fww;
  private ImageView fwx;
  private LinearLayoutManager fwy;
  private a fwz;
  private com.tencent.mm.ui.base.p tipDialog;
  public TextView titleTv;
  
  public ManagerRoomByWeworkUI()
  {
    AppMethodBeat.i(197113);
    this.fwe = new ArrayList();
    this.fwf = new ArrayList();
    this.fwg = new ArrayList();
    this.fwh = new HashMap();
    this.fwi = new HashMap();
    this.fwj = 0;
    this.fwk = 0;
    this.fwl = 0;
    this.tipDialog = null;
    this.fwB = 0;
    this.fwC = 0;
    AppMethodBeat.o(197113);
  }
  
  private boolean Wx()
  {
    AppMethodBeat.i(197115);
    int i;
    if (((com.tencent.mm.plugin.expt.a.b)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.expt.a.b.class)).a(b.a.pTv, 1) == 1)
    {
      i = 1;
      if ((i == 0) || (!Wy())) {
        break label95;
      }
      if ((this.fwe.size() != 0) || (this.fwg.size() != 0)) {
        break label84;
      }
      this.fwv.setVisibility(8);
    }
    for (;;)
    {
      AppMethodBeat.o(197115);
      return true;
      i = 0;
      break;
      label84:
      this.fwv.setVisibility(0);
    }
    label95:
    this.fwv.setVisibility(8);
    this.fwx.setVisibility(8);
    AppMethodBeat.o(197115);
    return false;
  }
  
  private boolean Wy()
  {
    AppMethodBeat.i(197116);
    HashMap localHashMap = ((com.tencent.mm.plugin.messenger.foundation.a.k)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.messenger.foundation.a.k.class)).awG().faJ();
    LinkedList localLinkedList = new LinkedList();
    List localList = com.tencent.mm.model.w.ayi();
    if (localList.size() == 0)
    {
      AppMethodBeat.o(197116);
      return false;
    }
    Iterator localIterator = localList.iterator();
    while (localIterator.hasNext())
    {
      ai localai = (ai)localIterator.next();
      if ((!com.tencent.mm.model.w.wr(localai.field_username)) && (!this.fwg.contains(localai.field_username)))
      {
        x localx;
        if (!localHashMap.containsKey(localai.field_username))
        {
          if (com.tencent.mm.n.b.ln(localai.field_type))
          {
            localx = ((com.tencent.mm.plugin.chatroom.a.c)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.chatroom.a.c.class)).awK().xN(localai.field_username);
            if (localx == null) {
              ac.e("MicroMsg.ManagerRoomByWeworkUI", "%s member is null", new Object[] { bs.bG(localai.field_username, "") });
            } else if ((localx.xB(u.axw())) && (c(localai))) {
              localLinkedList.add(localai);
            }
          }
        }
        else
        {
          localx = ((com.tencent.mm.plugin.chatroom.a.c)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.chatroom.a.c.class)).awK().xN(localai.field_username);
          if (localx == null) {
            ac.e("MicroMsg.ManagerRoomByWeworkUI", "%s member is null", new Object[] { bs.bG(localai.field_username, "") });
          } else if ((localx.xB(u.axw())) && (c(localai))) {
            localLinkedList.add(localai);
          }
        }
      }
    }
    localList.clear();
    if (localLinkedList.size() > 0)
    {
      AppMethodBeat.o(197116);
      return true;
    }
    AppMethodBeat.o(197116);
    return false;
  }
  
  private void Wz()
  {
    AppMethodBeat.i(197121);
    if (this.fwc == 3)
    {
      if (((com.tencent.mm.plugin.expt.a.b)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.expt.a.b.class)).a(b.a.pTv, 1) == 1) {}
      for (int i = 1; (i != 0) && (Wy()) && (this.fwe.size() == 0) && (this.fwg.size() == 0); i = 0)
      {
        this.fwm.setVisibility(8);
        this.fwn.setVisibility(0);
        AppMethodBeat.o(197121);
        return;
      }
      this.fwm.setVisibility(0);
      this.fwn.setVisibility(8);
      if ((this.fwz != null) && (this.fwz.fwI > 0))
      {
        this.fwm.setEnabled(true);
        AppMethodBeat.o(197121);
        return;
      }
      this.fwm.setEnabled(false);
      AppMethodBeat.o(197121);
      return;
    }
    this.fwm.setVisibility(0);
    this.fwn.setVisibility(8);
    AppMethodBeat.o(197121);
  }
  
  public static void a(Context paramContext, String paramString, TextView paramTextView1, TextView paramTextView2, boolean paramBoolean)
  {
    AppMethodBeat.i(197123);
    SpannableString localSpannableString = com.tencent.mm.pluginsdk.ui.span.k.b(paramContext, v.wk(paramString), com.tencent.mm.cc.a.au(paramContext, 2131165517));
    Object localObject = localSpannableString;
    if (paramBoolean) {
      localObject = com.tencent.mm.pluginsdk.ui.span.k.d(paramContext, localSpannableString);
    }
    paramTextView1.setText((CharSequence)localObject);
    int i = com.tencent.mm.model.q.wb(((com.tencent.mm.plugin.messenger.foundation.a.k)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.messenger.foundation.a.k.class)).awB().aNt(paramString).field_username);
    if (i == 0)
    {
      paramTextView2.setVisibility(8);
      AppMethodBeat.o(197123);
      return;
    }
    paramTextView2.setVisibility(0);
    paramTextView2.setText(paramContext.getString(2131766410, new Object[] { String.valueOf(i) }));
    AppMethodBeat.o(197123);
  }
  
  private void a(final n paramn, boolean paramBoolean)
  {
    AppMethodBeat.i(197118);
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
            ac.i("MicroMsg.ManagerRoomByWeworkUI", "dialog onCancel scene is null");
            AppMethodBeat.o(182211);
            return;
          }
          ac.i("MicroMsg.ManagerRoomByWeworkUI", "dialog onCancel scene:%s", new Object[] { Integer.valueOf(paramn.getType()) });
          com.tencent.mm.kernel.g.agi().a(paramn);
          if ((paramn instanceof com.tencent.mm.chatroom.d.k)) {
            ManagerRoomByWeworkUI.this.finish();
          }
          AppMethodBeat.o(182211);
        }
      });
      AppMethodBeat.o(197118);
      return;
    }
    if (!this.tipDialog.isShowing()) {
      this.tipDialog.show();
    }
    AppMethodBeat.o(197118);
  }
  
  public static void a(String paramString, final CdnImageView paramCdnImageView)
  {
    AppMethodBeat.i(197122);
    if ((bs.isNullOrNil(paramString)) || (paramCdnImageView == null))
    {
      ac.e("MicroMsg.ManagerRoomByWeworkUI", "username or avatarIv null");
      AppMethodBeat.o(197122);
      return;
    }
    paramString = new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(197102);
        Bitmap localBitmap = com.tencent.mm.aj.c.a(this.fur, false, -1, null);
        if (localBitmap == null)
        {
          paramCdnImageView.setImageResource(2131231875);
          AppMethodBeat.o(197102);
          return;
        }
        paramCdnImageView.setImageBitmap(localBitmap);
        AppMethodBeat.o(197102);
      }
    };
    if (ap.isMainThread())
    {
      paramString.run();
      AppMethodBeat.o(197122);
      return;
    }
    ap.f(new ManagerRoomByWeworkUI.7(paramString));
    AppMethodBeat.o(197122);
  }
  
  public static void c(String paramString, int paramInt1, int paramInt2, int paramInt3)
  {
    AppMethodBeat.i(182217);
    br localbr = new br();
    localbr.jN(paramString);
    localbr.dHY = paramInt1;
    localbr.dNi = paramInt2;
    localbr.dNj = paramInt3;
    localbr.aHZ();
    AppMethodBeat.o(182217);
  }
  
  private static boolean c(ai paramai)
  {
    AppMethodBeat.i(197117);
    if (paramai == null)
    {
      AppMethodBeat.o(197117);
      return false;
    }
    x localx = ((com.tencent.mm.plugin.chatroom.a.c)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.chatroom.a.c.class)).awK().xN(paramai.field_username);
    if (localx == null)
    {
      ac.e("MicroMsg.ManagerRoomByWeworkUI", "isValidByMaxNum %s member is null", new Object[] { paramai.field_username });
      AppMethodBeat.o(197117);
      return false;
    }
    if (localx.field_memberCount < com.tencent.mm.model.q.axs())
    {
      AppMethodBeat.o(197117);
      return true;
    }
    AppMethodBeat.o(197117);
    return false;
  }
  
  private void g(ArrayList<String> paramArrayList)
  {
    long l2 = 0L;
    AppMethodBeat.i(197120);
    StringBuilder localStringBuilder = new StringBuilder();
    paramArrayList = paramArrayList.iterator();
    int j = 0;
    int i = 0;
    if (paramArrayList.hasNext())
    {
      String str = (String)paramArrayList.next();
      if (this.fwe.contains(str)) {
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
    paramArrayList = new bt();
    paramArrayList.dNk = i;
    if (this.fwz == null)
    {
      l1 = 0L;
      paramArrayList.dNl = l1;
      paramArrayList.dNm = j;
      if (this.fwz != null) {
        break label230;
      }
    }
    label230:
    for (long l1 = l2;; l1 = this.fwz.fwL - j)
    {
      paramArrayList.dNn = l1;
      paramArrayList.dNo = paramArrayList.t("sucRoomList", localStringBuilder.toString(), true);
      paramArrayList.dNp = paramArrayList.t("ticketId", bs.bG(this.fwd, ""), true);
      paramArrayList.aHZ();
      AppMethodBeat.o(197120);
      return;
      l1 = this.fwz.fwK - i;
      break;
    }
  }
  
  public int getLayoutId()
  {
    return 2131493376;
  }
  
  public final void kH(int paramInt)
  {
    long l2 = 0L;
    AppMethodBeat.i(197119);
    bu localbu = new bu();
    localbu.dNq = this.fwB;
    localbu.dNr = this.fwC;
    if (this.fwz == null)
    {
      l1 = 0L;
      localbu.dNs = l1;
      if (this.fwz != null) {
        break label126;
      }
    }
    label126:
    for (long l1 = l2;; l1 = this.fwz.fwL)
    {
      localbu.dNt = l1;
      localbu.dNu = paramInt;
      localbu.jP(bs.bG(this.fwd, ""));
      localbu.dNw = this.fwl;
      localbu.aHZ();
      AppMethodBeat.o(197119);
      return;
      l1 = this.fwz.fwK;
      break;
    }
  }
  
  public void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    AppMethodBeat.i(197114);
    super.onActivityResult(paramInt1, paramInt2, paramIntent);
    ac.i("MicroMsg.ManagerRoomByWeworkUI", "requestCode=%d | resultCode=%d", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) });
    if (paramInt2 != -1)
    {
      AppMethodBeat.o(197114);
      return;
    }
    if (paramInt1 == 0)
    {
      paramIntent = paramIntent.getStringExtra("Select_Conv_User");
      Object localObject = this.fwf.iterator();
      while (((Iterator)localObject).hasNext()) {
        if (bs.lr(((ai)((Iterator)localObject).next()).field_username, paramIntent))
        {
          ac.i("MicroMsg.ManagerRoomByWeworkUI", "onActivityResult contain");
          AppMethodBeat.o(197114);
          return;
        }
      }
      localObject = ((com.tencent.mm.plugin.messenger.foundation.a.k)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.messenger.foundation.a.k.class)).awB().aNt(paramIntent);
      this.fwf.add(localObject);
      this.fwg.add(paramIntent);
      this.fwh.put(((av)localObject).field_username, Boolean.TRUE);
      this.fwz.arg.notifyChanged();
      Wx();
      this.fwz.fwL += 1;
      this.fwz.fwI += 1;
      com.tencent.mm.ui.tools.p.a(this, (NestedScrollView)findViewById(2131304251), findViewById(2131298738), findViewById(2131306201), findViewById(2131297454));
      Wz();
    }
    AppMethodBeat.o(197114);
  }
  
  public void onCreate(Bundle paramBundle)
  {
    boolean bool = true;
    AppMethodBeat.i(182212);
    super.onCreate(paramBundle);
    setMMTitle("");
    this.fvZ = getIntent().getStringExtra("RoomInfo_Id");
    this.fwc = getIntent().getIntExtra("upgrade_openim_room_from_scene", 0);
    this.fwd = getIntent().getStringExtra("ticket");
    ac.i("MicroMsg.ManagerRoomByWeworkUI", "mFromScene:%s", new Object[] { Integer.valueOf(this.fwc) });
    int i;
    if (this.fwc == 3)
    {
      if (!bs.isNullOrNil(this.fwd)) {
        break label154;
      }
      ac.e("MicroMsg.ManagerRoomByWeworkUI", "mTicket is null");
      finish();
      i = 0;
    }
    while (i == 0)
    {
      AppMethodBeat.o(182212);
      return;
      if (bs.isNullOrNil(this.fvZ))
      {
        ac.e("MicroMsg.ManagerRoomByWeworkUI", "mRoomId is null");
        finish();
        i = 0;
      }
      else
      {
        label154:
        i = 1;
      }
    }
    com.tencent.mm.kernel.g.agi().a(3553, this);
    com.tencent.mm.kernel.g.agi().a(3927, this);
    ac.i("MicroMsg.ManagerRoomByWeworkUI", "doFetchCollectPubFill() roomId:%s", new Object[] { this.fvZ });
    if (this.fwc == 3)
    {
      paramBundle = new com.tencent.mm.chatroom.d.k(this.fwd, (byte)0);
      com.tencent.mm.kernel.g.agi().a(paramBundle, 0);
      if (this.fwc == 3) {
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
          ac.i("MicroMsg.ManagerRoomByWeworkUI", "onMenuItemClick click");
          WeworkRoomUpgradeResultUI.bW(ManagerRoomByWeworkUI.this);
          ManagerRoomByWeworkUI.this.finish();
          if (ManagerRoomByWeworkUI.a(ManagerRoomByWeworkUI.this) != 3) {
            ManagerRoomByWeworkUI.c(ManagerRoomByWeworkUI.b(ManagerRoomByWeworkUI.this), ManagerRoomByWeworkUI.a(ManagerRoomByWeworkUI.this), 0, 0);
          }
          for (;;)
          {
            AppMethodBeat.o(182207);
            return true;
            ManagerRoomByWeworkUI.this.kH(0);
          }
        }
      });
      AppMethodBeat.o(182212);
      return;
      paramBundle = new com.tencent.mm.chatroom.d.k(this.fvZ);
      break;
      label307:
      bool = false;
    }
  }
  
  public void onDestroy()
  {
    AppMethodBeat.i(182214);
    com.tencent.mm.kernel.g.agi().b(3553, this);
    com.tencent.mm.kernel.g.agi().b(3927, this);
    super.onDestroy();
    AppMethodBeat.o(182214);
  }
  
  public boolean onKeyUp(int paramInt, KeyEvent paramKeyEvent)
  {
    AppMethodBeat.i(182215);
    if (this.fwc != 3) {
      c(this.fvZ, this.fwc, 0, 0);
    }
    for (;;)
    {
      boolean bool = super.onKeyUp(paramInt, paramKeyEvent);
      AppMethodBeat.o(182215);
      return bool;
      kH(0);
    }
  }
  
  public void onSceneEnd(int paramInt1, int paramInt2, String paramString, n paramn)
  {
    AppMethodBeat.i(182213);
    ac.i("MicroMsg.ManagerRoomByWeworkUI", "onSceneEnd errType = %d, errCode = %d, errMsg = %s, scenetype:%s", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), paramString, Integer.valueOf(paramn.getType()) });
    label121:
    Object localObject1;
    if ((this.fwc != 3) || ((paramn instanceof com.tencent.mm.chatroom.d.k)))
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
      if (paramn.fsl != null) {
        break label769;
      }
      paramn = null;
      if (paramn == null) {
        break label1643;
      }
      super.initView();
      this.fwm = ((Button)findViewById(2131306228));
      this.fwn = ((Button)findViewById(2131307239));
      this.titleTv = ((TextView)findViewById(2131297973));
      this.fwo = ((CdnImageView)findViewById(2131297960));
      this.fwp = ((TextView)findViewById(2131297972));
      this.fwq = ((TextView)findViewById(2131298777));
      this.fwr = ((LinearLayout)findViewById(2131298764));
      this.fws = ((LinearLayout)findViewById(2131307196));
      this.fwt = ((LinearLayout)findViewById(2131307167));
      this.fwu = ((RecyclerView)findViewById(2131307150));
      this.fwv = ((LinearLayout)findViewById(2131307241));
      this.fww = ((TextView)findViewById(2131307242));
      this.fwx = ((ImageView)findViewById(2131307240));
      findViewById(2131298738).setVisibility(0);
      this.fwm.setOnClickListener(new View.OnClickListener()
      {
        public final void onClick(View paramAnonymousView)
        {
          AppMethodBeat.i(197099);
          ac.i("MicroMsg.ManagerRoomByWeworkUI", "click use");
          if (ManagerRoomByWeworkUI.a(ManagerRoomByWeworkUI.this) == 3)
          {
            ManagerRoomByWeworkUI.c(ManagerRoomByWeworkUI.this);
            AppMethodBeat.o(197099);
            return;
          }
          ManagerRoomByWeworkUI.d(ManagerRoomByWeworkUI.this);
          AppMethodBeat.o(197099);
        }
      });
      if ((this.fwc != 1) && (this.fwc != 2)) {
        break label852;
      }
      this.fwt.setVisibility(0);
      this.fws.setVisibility(8);
      a(this.fvZ, this.fwo);
      paramString = this.fvZ;
      localObject1 = this.fwp;
      paramString = ((com.tencent.mm.plugin.messenger.foundation.a.k)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.messenger.foundation.a.k.class)).awB().aNt(paramString);
      if (!bs.isNullOrNil(paramString.field_nickname)) {
        break label817;
      }
      if (com.tencent.mm.model.q.wb(paramString.field_username) != 0) {
        break label779;
      }
      paramString = getString(2131761169);
      label441:
      ((TextView)localObject1).setText(com.tencent.mm.pluginsdk.ui.span.k.d(this, com.tencent.mm.pluginsdk.ui.span.k.b(this, paramString, com.tencent.mm.cc.a.au(this, 2131165192))));
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
        Wz();
        this.titleTv.setText(paramn.title);
        this.fwq.setText(com.tencent.mm.pluginsdk.ui.span.k.d(getContext(), bs.nullAsNil(paramn.oGS), (int)this.fwq.getTextSize()));
        if ((paramn.ELT == null) || (paramn.ELT.size() <= 0)) {
          break label1601;
        }
        this.fwr.removeAllViews();
        paramString = (LayoutInflater)getContext().getSystemService("layout_inflater");
        paramn = paramn.ELT.iterator();
        paramInt1 = 0;
        while (paramn.hasNext())
        {
          localObject1 = (String)paramn.next();
          localObject3 = paramString.inflate(2131493377, this.fwr, false);
          paramInt1 += 1;
          ((TextView)((View)localObject3).findViewById(2131303086)).setText(paramInt1 + ".");
          ((TextView)((View)localObject3).findViewById(2131299008)).setText((CharSequence)localObject1);
          this.fwr.addView((View)localObject3);
        }
        try
        {
          ac.i("MicroMsg.ManagerRoomByWeworkUI", "NetSceneUpgradeAssociateChatRoom %s", new Object[] { ((com.tencent.mm.chatroom.d.w)paramn).djF });
          this.fwj += 1;
          if ((this.fwj != this.fwk) || (this.tipDialog == null) || (!this.tipDialog.isShowing())) {
            break;
          }
          this.tipDialog.dismiss();
        }
        catch (Exception localException)
        {
          for (;;)
          {
            ac.e("MicroMsg.ManagerRoomByWeworkUI", "NetSceneUpgradeAssociateChatRoom Exception:%s %s", new Object[] { localException.getClass().getSimpleName(), localException.getMessage() });
          }
        }
      }
      paramn = paramn.fsl;
      break label121;
      paramString = getString(2131759496, new Object[] { getString(2131761169), Integer.valueOf(com.tencent.mm.model.q.wb(paramString.field_username)) });
      break label441;
      paramString = getString(2131759496, new Object[] { paramString.aaR(), Integer.valueOf(com.tencent.mm.model.q.wb(paramString.field_username)) });
      break label441;
      label852:
      if (this.fwc == 3)
      {
        this.fwt.setVisibility(8);
        this.fws.setVisibility(0);
        paramString = new View.OnClickListener()
        {
          public final void onClick(View paramAnonymousView)
          {
            AppMethodBeat.i(197100);
            ac.i("MicroMsg.ManagerRoomByWeworkUI", "select_group_ll click");
            ManagerRoomByWeworkUI.e(ManagerRoomByWeworkUI.this);
            if (ManagerRoomByWeworkUI.f(ManagerRoomByWeworkUI.this).fwI == 5)
            {
              t.makeText(ManagerRoomByWeworkUI.this, 2131766408, 0).show();
              AppMethodBeat.o(197100);
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
              localArrayList.add(((ai)localIterator.next()).field_username);
            }
            paramAnonymousView.putStringArrayListExtra("group_select_block_chatroom", localArrayList);
            paramAnonymousView.putExtra("group_select_chatroom_max_num", com.tencent.mm.model.q.axs());
            ManagerRoomByWeworkUI.this.startActivityForResult(paramAnonymousView, 0);
            AppMethodBeat.o(197100);
          }
        };
        this.fwv.setOnClickListener(paramString);
        this.fwn.setOnClickListener(paramString);
        paramString = com.tencent.mm.model.w.ayi();
        if (paramString.size() == 0) {
          paramInt1 = 0;
        }
        for (;;)
        {
          if ((paramInt1 != 0) || (Wx())) {
            break label1599;
          }
          findViewById(2131299477).setVisibility(0);
          findViewById(2131306228).setVisibility(8);
          this.fws.setVisibility(8);
          break;
          paramString = paramString.iterator();
          while (paramString.hasNext())
          {
            localObject2 = (ai)paramString.next();
            if (com.tencent.mm.model.w.wt(((av)localObject2).field_username))
            {
              localObject3 = ((com.tencent.mm.plugin.chatroom.a.c)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.chatroom.a.c.class)).awK().xN(((av)localObject2).field_username);
              if (localObject3 == null)
              {
                ac.e("MicroMsg.ManagerRoomByWeworkUI", "initContactList %s member is null", new Object[] { ((av)localObject2).field_username });
              }
              else if ((((x)localObject3).field_memberCount < com.tencent.mm.model.q.axs()) && (bs.lr(((x)localObject3).field_roomowner, u.axw())))
              {
                this.fwf.add(localObject2);
                this.fwg.add(((av)localObject2).field_username);
                this.fwe.add(((av)localObject2).field_username);
              }
            }
          }
          this.fwB = this.fwf.size();
          paramString = ((com.tencent.mm.plugin.messenger.foundation.a.k)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.messenger.foundation.a.k.class)).awG().faJ();
          localObject2 = new LinkedList();
          localObject3 = com.tencent.mm.model.w.ayi();
          if (((List)localObject3).size() == 0) {}
          for (this.fwl = 0;; this.fwl = (((List)localObject2).size() - this.fwB))
          {
            this.fwy = new LinearLayoutManager();
            this.fwy.setOrientation(1);
            this.fwu.setLayoutManager(this.fwy);
            this.fwA = new b(getContext(), 96.0F);
            this.fwu.a(this.fwA);
            this.fwz = new a(getContext(), this.fwf, this.fwh, this.fwe, new c()
            {
              public final void WA()
              {
                AppMethodBeat.i(197101);
                ManagerRoomByWeworkUI.h(ManagerRoomByWeworkUI.this);
                AppMethodBeat.o(197101);
              }
            });
            this.fwu.setAdapter(this.fwz);
            this.fwu.setNestedScrollingEnabled(false);
            this.fwz.arg.notifyChanged();
            if (this.fwf.size() != 0) {
              break label1596;
            }
            paramInt1 = 0;
            break;
            Iterator localIterator = ((List)localObject3).iterator();
            while (localIterator.hasNext())
            {
              ai localai = (ai)localIterator.next();
              if (!com.tencent.mm.model.w.wr(localai.field_username))
              {
                x localx;
                if (!paramString.containsKey(localai.field_username))
                {
                  if (com.tencent.mm.n.b.ln(localai.field_type))
                  {
                    localx = ((com.tencent.mm.plugin.chatroom.a.c)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.chatroom.a.c.class)).awK().xN(localai.field_username);
                    if (localx == null) {
                      ac.e("MicroMsg.ManagerRoomByWeworkUI", "iniOtherChatroomNum %s member is null", new Object[] { bs.bG(localai.field_username, "") });
                    } else if ((localx.xB(u.axw())) && (c(localai))) {
                      ((List)localObject2).add(localai);
                    }
                  }
                }
                else
                {
                  localx = ((com.tencent.mm.plugin.chatroom.a.c)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.chatroom.a.c.class)).awK().xN(localai.field_username);
                  if (localx == null) {
                    ac.e("MicroMsg.ManagerRoomByWeworkUI", "iniOtherChatroomNum %s member is null", new Object[] { bs.bG(localai.field_username, "") });
                  } else if ((localx.xB(u.axw())) && (c(localai))) {
                    ((List)localObject2).add(localai);
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
    if (bs.isNullOrNil(paramString)) {
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
      if (((com.tencent.mm.chatroom.d.w)localObject2).fsF == null)
      {
        localObject2 = null;
        if (this.fwc != 3) {
          break label1899;
        }
        if (localObject2 == null) {
          break label1877;
        }
        this.fwi.put(((com.tencent.mm.chatroom.d.w)paramn).djF, Boolean.TRUE);
      }
    }
    else
    {
      label1748:
      if ((this.fwc != 3) || (!(paramn instanceof com.tencent.mm.chatroom.d.w)) || (this.fwj != this.fwk)) {
        break label2442;
      }
      ac.i("MicroMsg.ManagerRoomByWeworkUI", "NetSceneUpgradeAssociateChatRoom finish");
      paramString = new ArrayList();
      paramn = new ArrayList();
      localObject2 = this.fwi.entrySet().iterator();
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
        localObject2 = ((com.tencent.mm.chatroom.d.w)localObject2).fsF;
        break;
        label1877:
        this.fwi.put(((com.tencent.mm.chatroom.d.w)paramn).djF, Boolean.FALSE);
        break label1748;
        label1899:
        if (localObject2 != null)
        {
          c(this.fvZ, this.fwc, 1, 0);
          paramString = new Intent();
          paramString.setClass(this, WeworkRoomUpgradeResultUI.class);
          paramString.putExtra("RoomInfo_Id", this.fvZ);
          paramString.putExtra("popup_wording", bs.bG(((dmj)localObject2).FUj, ""));
          paramString.putExtra("upgrade_openim_room_from_scene", this.fwc);
          paramString = new com.tencent.mm.hellhoundlib.b.a().ba(paramString);
          com.tencent.mm.hellhoundlib.a.a.a(this, paramString.aeD(), "com/tencent/mm/chatroom/ui/ManagerRoomByWeworkUI", "onSceneEnd", "(IILjava/lang/String;Lcom/tencent/mm/modelbase/NetSceneBase;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
          startActivity((Intent)paramString.lR(0));
          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/chatroom/ui/ManagerRoomByWeworkUI", "onSceneEnd", "(IILjava/lang/String;Lcom/tencent/mm/modelbase/NetSceneBase;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
          finish();
          super.overridePendingTransition(2130772144, 2130772141);
          AppMethodBeat.o(182213);
          return;
        }
        localObject2 = getContext();
        paramn = paramString;
        if (bs.isNullOrNil(paramString)) {
          paramn = getString(2131764612);
        }
        t.makeText((Context)localObject2, paramn, 0).show();
        c(this.fvZ, this.fwc, 2, 4);
        finish();
        AppMethodBeat.o(182213);
        return;
        label2129:
        if ((paramn instanceof com.tencent.mm.chatroom.d.k))
        {
          localObject2 = getContext();
          paramn = paramString;
          if (bs.isNullOrNil(paramString)) {
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
        if (this.fwc == 3)
        {
          this.fwi.put(((com.tencent.mm.chatroom.d.w)paramn).djF, Boolean.FALSE);
          break label1748;
        }
        c(this.fvZ, this.fwc, 2, 4);
        localObject2 = getContext();
        paramn = paramString;
        if (bs.isNullOrNil(paramString)) {
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
    ((Intent)localObject2).putExtra("upgrade_openim_room_from_scene", this.fwc);
    ((Intent)localObject2).putExtra("wework_upgrade_success_list", paramString);
    ((Intent)localObject2).putExtra("wework_upgrade_fail_list", paramn);
    paramn = new com.tencent.mm.hellhoundlib.b.a().ba(localObject2);
    com.tencent.mm.hellhoundlib.a.a.a(this, paramn.aeD(), "com/tencent/mm/chatroom/ui/ManagerRoomByWeworkUI", "onSceneEnd", "(IILjava/lang/String;Lcom/tencent/mm/modelbase/NetSceneBase;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
    startActivity((Intent)paramn.lR(0));
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
    private List<ai> fwF;
    private List<String> fwG;
    private HashMap<String, Boolean> fwH;
    int fwI;
    private ManagerRoomByWeworkUI.c fwJ;
    int fwK;
    int fwL;
    
    public a(Context paramContext, List<ai> paramList, HashMap<String, Boolean> paramHashMap, List<String> paramList1, ManagerRoomByWeworkUI.c paramc)
    {
      AppMethodBeat.i(197105);
      this.fwI = 0;
      this.fwK = 0;
      this.fwL = 0;
      this.context = paramContext;
      this.fwF = paramList;
      this.fwH = paramHashMap;
      this.fwG = paramList1;
      this.fwJ = paramc;
      paramContext = paramList.iterator();
      while (paramContext.hasNext()) {
        paramHashMap.put(((ai)paramContext.next()).field_username, Boolean.FALSE);
      }
      AppMethodBeat.o(197105);
    }
    
    public final RecyclerView.w a(ViewGroup paramViewGroup, int paramInt)
    {
      AppMethodBeat.i(197106);
      paramViewGroup = new ManagerRoomByWeworkUI.d(LayoutInflater.from(paramViewGroup.getContext()).inflate(2131496145, paramViewGroup, false));
      AppMethodBeat.o(197106);
      return paramViewGroup;
    }
    
    public final void a(RecyclerView.w paramw, int paramInt)
    {
      AppMethodBeat.i(197107);
      ac.d("MicroMsg.ManagerRoomByWeworkUI", "onBindViewHolder() count:%s i:%s ", new Object[] { Integer.valueOf(this.fwF.size()), Integer.valueOf(paramInt) });
      ai localai;
      Boolean localBoolean;
      CheckBox localCheckBox;
      if ((this.fwF != null) && (paramInt >= 0) && (paramInt < this.fwF.size()))
      {
        paramw = (ManagerRoomByWeworkUI.d)paramw;
        localai = (ai)this.fwF.get(paramInt);
        ac.d("MicroMsg.ManagerRoomByWeworkUI", "onBindViewHolder() count:%s i:%s username:%s", new Object[] { Integer.valueOf(this.fwF.size()), Integer.valueOf(paramInt), localai.field_username });
        paramw.fvu.setVisibility(0);
        ManagerRoomByWeworkUI.a(localai.field_username, paramw.fwo);
        ManagerRoomByWeworkUI.a(this.context, localai.field_username, paramw.fwQ, paramw.fwR, false);
        localBoolean = (Boolean)this.fwH.get(localai.field_username);
        paramw.fwP.setEnabled(true);
        localCheckBox = paramw.fwP;
        if (localBoolean != null) {
          break label238;
        }
      }
      label238:
      for (boolean bool = false;; bool = localBoolean.booleanValue())
      {
        localCheckBox.setChecked(bool);
        paramw.fvu.setTag(localai);
        paramw.fvu.setOnClickListener(new View.OnClickListener()
        {
          public final void onClick(View paramAnonymousView)
          {
            boolean bool = false;
            AppMethodBeat.i(197104);
            paramAnonymousView = (ai)paramAnonymousView.getTag();
            if (paramAnonymousView == null)
            {
              ac.e("MicroMsg.ManagerRoomByWeworkUI", "click:contact is nul");
              AppMethodBeat.o(197104);
              return;
            }
            Boolean localBoolean = (Boolean)ManagerRoomByWeworkUI.a.a(ManagerRoomByWeworkUI.a.this).get(paramAnonymousView.field_username);
            if ((!localBoolean.booleanValue()) && (ManagerRoomByWeworkUI.a.b(ManagerRoomByWeworkUI.a.this) == 5))
            {
              t.makeText(ManagerRoomByWeworkUI.a.c(ManagerRoomByWeworkUI.a.this), 2131766408, 0).show();
              AppMethodBeat.o(197104);
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
              ManagerRoomByWeworkUI.a.this.arg.notifyChanged();
              if (ManagerRoomByWeworkUI.a.k(ManagerRoomByWeworkUI.a.this) != null) {
                ManagerRoomByWeworkUI.a.k(ManagerRoomByWeworkUI.a.this).WA();
              }
              AppMethodBeat.o(197104);
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
        AppMethodBeat.o(197107);
        return;
      }
    }
    
    public final int getItemCount()
    {
      AppMethodBeat.i(197108);
      int i = this.fwF.size();
      AppMethodBeat.o(197108);
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
    private Paint fvL;
    private Paint fwN;
    private int fwO;
    
    public b(Context paramContext, float paramFloat)
    {
      AppMethodBeat.i(197109);
      this.dividerHeight = com.tencent.mm.cc.a.g(paramContext, 0.5F);
      this.fwO = com.tencent.mm.cc.a.g(paramContext, paramFloat);
      this.fvL = new Paint();
      this.fvL.setColor(paramContext.getResources().getColor(2131099656));
      this.fwN = new Paint();
      this.fwN.setColor(paramContext.getResources().getColor(2131099679));
      AppMethodBeat.o(197109);
    }
    
    public final void a(Canvas paramCanvas, RecyclerView paramRecyclerView, RecyclerView.t paramt)
    {
      AppMethodBeat.i(197110);
      super.a(paramCanvas, paramRecyclerView, paramt);
      int j = paramRecyclerView.getChildCount();
      int k = paramRecyclerView.getPaddingLeft();
      int m = this.fwO;
      int n = paramRecyclerView.getWidth() - paramRecyclerView.getPaddingRight();
      int i = 0;
      if (i < j)
      {
        paramt = paramRecyclerView.getChildAt(i);
        float f1 = paramt.getBottom();
        float f2 = paramt.getBottom() + this.dividerHeight;
        if (i == j - 1) {
          paramCanvas.drawRect(k, f1, n, f2, this.fwN);
        }
        for (;;)
        {
          i += 1;
          break;
          paramCanvas.drawRect(k + m, f1, n, f2, this.fvL);
        }
      }
      AppMethodBeat.o(197110);
    }
    
    public final void a(Rect paramRect, View paramView, RecyclerView paramRecyclerView, RecyclerView.t paramt)
    {
      AppMethodBeat.i(197111);
      super.a(paramRect, paramView, paramRecyclerView, paramt);
      paramRect.bottom = this.dividerHeight;
      AppMethodBeat.o(197111);
    }
  }
  
  public static abstract interface c
  {
    public abstract void WA();
  }
  
  public static final class d
    extends RecyclerView.w
  {
    View fvu;
    CheckBox fwP;
    TextView fwQ;
    TextView fwR;
    CdnImageView fwo;
    
    public d(View paramView)
    {
      super();
      AppMethodBeat.i(197112);
      this.fvu = paramView;
      this.fwP = ((CheckBox)paramView.findViewById(2131304502));
      this.fwo = ((CdnImageView)paramView.findViewById(2131307168));
      this.fwQ = ((TextView)paramView.findViewById(2131307169));
      this.fwR = ((TextView)paramView.findViewById(2131307170));
      AppMethodBeat.o(197112);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.chatroom.ui.ManagerRoomByWeworkUI
 * JD-Core Version:    0.7.0.1
 */