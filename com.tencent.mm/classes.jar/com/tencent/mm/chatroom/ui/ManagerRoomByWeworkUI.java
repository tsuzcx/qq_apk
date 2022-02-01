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
import android.support.v7.widget.RecyclerView.s;
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
import com.tencent.mm.ak.i;
import com.tencent.mm.ak.t;
import com.tencent.mm.chatroom.d.k;
import com.tencent.mm.chatroom.d.w;
import com.tencent.mm.g.b.a.et;
import com.tencent.mm.g.b.a.ev;
import com.tencent.mm.g.b.a.ew;
import com.tencent.mm.g.c.ax;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.aa;
import com.tencent.mm.model.ab;
import com.tencent.mm.model.ap;
import com.tencent.mm.model.v;
import com.tencent.mm.model.z;
import com.tencent.mm.plugin.expt.b.b.a;
import com.tencent.mm.pluginsdk.ui.applet.CdnImageView;
import com.tencent.mm.protocal.protobuf.bik;
import com.tencent.mm.protocal.protobuf.emv;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMHandlerThread;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.ah;
import com.tencent.mm.storage.as;
import com.tencent.mm.storage.bv;
import com.tencent.mm.storage.bw;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.ui.base.u;
import com.tencent.mm.ui.tools.p;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map.Entry;
import java.util.Set;

public class ManagerRoomByWeworkUI
  extends MMActivity
  implements i
{
  private int gwE;
  private String gwF;
  private List<String> gwG;
  private List<as> gwH;
  private List<String> gwI;
  private HashMap<String, Boolean> gwJ;
  private HashMap<String, Boolean> gwK;
  private int gwL;
  private int gwM;
  private int gwN;
  public Button gwO;
  public Button gwP;
  private CdnImageView gwQ;
  public TextView gwR;
  public TextView gwS;
  public LinearLayout gwT;
  private LinearLayout gwU;
  private LinearLayout gwV;
  private RecyclerView gwW;
  private LinearLayout gwX;
  private TextView gwY;
  private ImageView gwZ;
  private String gwx;
  private LinearLayoutManager gxa;
  private a gxb;
  private b gxc;
  private int gxd;
  private int gxe;
  private com.tencent.mm.ui.base.q tipDialog;
  public TextView titleTv;
  
  public ManagerRoomByWeworkUI()
  {
    AppMethodBeat.i(194151);
    this.gwG = new ArrayList();
    this.gwH = new ArrayList();
    this.gwI = new ArrayList();
    this.gwJ = new HashMap();
    this.gwK = new HashMap();
    this.gwL = 0;
    this.gwM = 0;
    this.gwN = 0;
    this.tipDialog = null;
    this.gxd = 0;
    this.gxe = 0;
    AppMethodBeat.o(194151);
  }
  
  public static void a(Context paramContext, String paramString, TextView paramTextView1, TextView paramTextView2, boolean paramBoolean)
  {
    AppMethodBeat.i(194161);
    SpannableString localSpannableString = com.tencent.mm.pluginsdk.ui.span.l.e(paramContext, aa.getDisplayName(paramString), com.tencent.mm.cb.a.aG(paramContext, 2131165535));
    Object localObject = localSpannableString;
    if (paramBoolean) {
      localObject = com.tencent.mm.pluginsdk.ui.span.l.d(paramContext, localSpannableString);
    }
    paramTextView1.setText((CharSequence)localObject);
    int i = v.Ie(((com.tencent.mm.plugin.messenger.foundation.a.l)g.af(com.tencent.mm.plugin.messenger.foundation.a.l.class)).aSN().Kn(paramString).field_username);
    if (i == 0)
    {
      paramTextView2.setVisibility(8);
      AppMethodBeat.o(194161);
      return;
    }
    paramTextView2.setVisibility(0);
    paramTextView2.setText(paramContext.getString(2131766978, new Object[] { String.valueOf(i) }));
    AppMethodBeat.o(194161);
  }
  
  private void a(final com.tencent.mm.ak.q paramq, boolean paramBoolean)
  {
    AppMethodBeat.i(194156);
    if (this.tipDialog == null)
    {
      getString(2131755998);
      this.tipDialog = h.a(this, getString(2131755886), paramBoolean, new DialogInterface.OnCancelListener()
      {
        public final void onCancel(DialogInterface paramAnonymousDialogInterface)
        {
          AppMethodBeat.i(182211);
          if (paramq == null)
          {
            Log.i("MicroMsg.ManagerRoomByWeworkUI", "dialog onCancel scene is null");
            AppMethodBeat.o(182211);
            return;
          }
          Log.i("MicroMsg.ManagerRoomByWeworkUI", "dialog onCancel scene:%s", new Object[] { Integer.valueOf(paramq.getType()) });
          g.azz().a(paramq);
          if ((paramq instanceof k)) {
            ManagerRoomByWeworkUI.this.finish();
          }
          AppMethodBeat.o(182211);
        }
      });
      AppMethodBeat.o(194156);
      return;
    }
    if (!this.tipDialog.isShowing()) {
      this.tipDialog.show();
    }
    AppMethodBeat.o(194156);
  }
  
  public static void a(String paramString, final CdnImageView paramCdnImageView)
  {
    AppMethodBeat.i(194160);
    if ((Util.isNullOrNil(paramString)) || (paramCdnImageView == null))
    {
      Log.e("MicroMsg.ManagerRoomByWeworkUI", "username or avatarIv null");
      AppMethodBeat.o(194160);
      return;
    }
    paramString = new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(194140);
        Bitmap localBitmap = com.tencent.mm.aj.c.a(this.gtu, false, -1, null);
        if (localBitmap == null)
        {
          paramCdnImageView.setImageResource(2131231957);
          AppMethodBeat.o(194140);
          return;
        }
        paramCdnImageView.setImageBitmap(localBitmap);
        AppMethodBeat.o(194140);
      }
    };
    if (MMHandlerThread.isMainThread())
    {
      paramString.run();
      AppMethodBeat.o(194160);
      return;
    }
    MMHandlerThread.postToMainThread(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(194141);
        this.val$run.run();
        AppMethodBeat.o(194141);
      }
    });
    AppMethodBeat.o(194160);
  }
  
  private boolean amN()
  {
    AppMethodBeat.i(194153);
    int i;
    if (((com.tencent.mm.plugin.expt.b.b)g.af(com.tencent.mm.plugin.expt.b.b.class)).a(b.a.rYr, 1) == 1)
    {
      i = 1;
      if ((i == 0) || (!amO())) {
        break label98;
      }
      if ((this.gwG.size() != 0) || (this.gwI.size() != 0)) {
        break label87;
      }
      this.gwX.setVisibility(8);
    }
    for (;;)
    {
      AppMethodBeat.o(194153);
      return true;
      i = 0;
      break;
      label87:
      this.gwX.setVisibility(0);
    }
    label98:
    this.gwX.setVisibility(8);
    this.gwZ.setVisibility(8);
    AppMethodBeat.o(194153);
    return false;
  }
  
  private boolean amO()
  {
    AppMethodBeat.i(194154);
    HashMap localHashMap = ((com.tencent.mm.plugin.messenger.foundation.a.l)g.af(com.tencent.mm.plugin.messenger.foundation.a.l.class)).aST().gCt();
    LinkedList localLinkedList = new LinkedList();
    List localList = ab.aUV();
    if (localList.size() == 0)
    {
      AppMethodBeat.o(194154);
      return false;
    }
    Iterator localIterator = localList.iterator();
    while (localIterator.hasNext())
    {
      as localas = (as)localIterator.next();
      if ((!ab.Iz(localas.field_username)) && (!this.gwI.contains(localas.field_username)))
      {
        ah localah;
        if (!localHashMap.containsKey(localas.field_username))
        {
          if (com.tencent.mm.contact.c.oR(localas.field_type))
          {
            localah = ((com.tencent.mm.plugin.chatroom.a.c)g.af(com.tencent.mm.plugin.chatroom.a.c.class)).aSX().Kd(localas.field_username);
            if (localah == null) {
              Log.e("MicroMsg.ManagerRoomByWeworkUI", "%s member is null", new Object[] { Util.nullAs(localas.field_username, "") });
            } else if ((localah.JO(z.aTY())) && (c(localas))) {
              localLinkedList.add(localas);
            }
          }
        }
        else
        {
          localah = ((com.tencent.mm.plugin.chatroom.a.c)g.af(com.tencent.mm.plugin.chatroom.a.c.class)).aSX().Kd(localas.field_username);
          if (localah == null) {
            Log.e("MicroMsg.ManagerRoomByWeworkUI", "%s member is null", new Object[] { Util.nullAs(localas.field_username, "") });
          } else if ((localah.JO(z.aTY())) && (c(localas))) {
            localLinkedList.add(localas);
          }
        }
      }
    }
    localList.clear();
    if (localLinkedList.size() > 0)
    {
      AppMethodBeat.o(194154);
      return true;
    }
    AppMethodBeat.o(194154);
    return false;
  }
  
  private void amP()
  {
    AppMethodBeat.i(194159);
    if (this.gwE == 3)
    {
      if (((com.tencent.mm.plugin.expt.b.b)g.af(com.tencent.mm.plugin.expt.b.b.class)).a(b.a.rYr, 1) == 1) {}
      for (int i = 1; (i != 0) && (amO()) && (this.gwG.size() == 0) && (this.gwI.size() == 0); i = 0)
      {
        this.gwO.setVisibility(8);
        this.gwP.setVisibility(0);
        AppMethodBeat.o(194159);
        return;
      }
      this.gwO.setVisibility(0);
      this.gwP.setVisibility(8);
      if ((this.gxb != null) && (this.gxb.gxk > 0))
      {
        this.gwO.setEnabled(true);
        AppMethodBeat.o(194159);
        return;
      }
      this.gwO.setEnabled(false);
      AppMethodBeat.o(194159);
      return;
    }
    this.gwO.setVisibility(0);
    this.gwP.setVisibility(8);
    AppMethodBeat.o(194159);
  }
  
  public static void c(String paramString, int paramInt1, int paramInt2, int paramInt3)
  {
    AppMethodBeat.i(182217);
    et localet = new et();
    localet.rR(paramString);
    localet.erW = paramInt1;
    localet.eEt = paramInt2;
    localet.eEu = paramInt3;
    localet.bfK();
    AppMethodBeat.o(182217);
  }
  
  private static boolean c(as paramas)
  {
    AppMethodBeat.i(194155);
    if (paramas == null)
    {
      AppMethodBeat.o(194155);
      return false;
    }
    ah localah = ((com.tencent.mm.plugin.chatroom.a.c)g.af(com.tencent.mm.plugin.chatroom.a.c.class)).aSX().Kd(paramas.field_username);
    if (localah == null)
    {
      Log.e("MicroMsg.ManagerRoomByWeworkUI", "isValidByMaxNum %s member is null", new Object[] { paramas.field_username });
      AppMethodBeat.o(194155);
      return false;
    }
    if (localah.field_memberCount < v.aTT())
    {
      AppMethodBeat.o(194155);
      return true;
    }
    AppMethodBeat.o(194155);
    return false;
  }
  
  private void i(ArrayList<String> paramArrayList)
  {
    long l2 = 0L;
    AppMethodBeat.i(194158);
    StringBuilder localStringBuilder = new StringBuilder();
    paramArrayList = paramArrayList.iterator();
    int j = 0;
    int i = 0;
    if (paramArrayList.hasNext())
    {
      String str = (String)paramArrayList.next();
      if (this.gwG.contains(str)) {
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
    paramArrayList = new ev();
    paramArrayList.eEv = i;
    if (this.gxb == null)
    {
      l1 = 0L;
      paramArrayList.eEw = l1;
      paramArrayList.eEx = j;
      if (this.gxb != null) {
        break label231;
      }
    }
    label231:
    for (long l1 = l2;; l1 = this.gxb.gxn - j)
    {
      paramArrayList.eEy = l1;
      paramArrayList.eEz = paramArrayList.x("sucRoomList", localStringBuilder.toString(), true);
      paramArrayList.eEA = paramArrayList.x("ticketId", Util.nullAs(this.gwF, ""), true);
      paramArrayList.bfK();
      AppMethodBeat.o(194158);
      return;
      l1 = this.gxb.gxm - i;
      break;
    }
  }
  
  public int getLayoutId()
  {
    return 2131493468;
  }
  
  public final void ok(int paramInt)
  {
    long l2 = 0L;
    AppMethodBeat.i(194157);
    ew localew = new ew();
    localew.eEB = this.gxd;
    localew.eEC = this.gxe;
    if (this.gxb == null)
    {
      l1 = 0L;
      localew.eED = l1;
      if (this.gxb != null) {
        break label127;
      }
    }
    label127:
    for (long l1 = l2;; l1 = this.gxb.gxn)
    {
      localew.eEE = l1;
      localew.ewL = paramInt;
      localew.rT(Util.nullAs(this.gwF, ""));
      localew.eEG = this.gwN;
      localew.bfK();
      AppMethodBeat.o(194157);
      return;
      l1 = this.gxb.gxm;
      break;
    }
  }
  
  public void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    AppMethodBeat.i(194152);
    super.onActivityResult(paramInt1, paramInt2, paramIntent);
    Log.i("MicroMsg.ManagerRoomByWeworkUI", "requestCode=%d | resultCode=%d", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) });
    if (paramInt2 != -1)
    {
      AppMethodBeat.o(194152);
      return;
    }
    if (paramInt1 == 0)
    {
      paramIntent = paramIntent.getStringExtra("Select_Conv_User");
      Object localObject = this.gwH.iterator();
      while (((Iterator)localObject).hasNext()) {
        if (Util.isEqual(((as)((Iterator)localObject).next()).field_username, paramIntent))
        {
          Log.i("MicroMsg.ManagerRoomByWeworkUI", "onActivityResult contain");
          AppMethodBeat.o(194152);
          return;
        }
      }
      localObject = ((com.tencent.mm.plugin.messenger.foundation.a.l)g.af(com.tencent.mm.plugin.messenger.foundation.a.l.class)).aSN().Kn(paramIntent);
      this.gwH.add(localObject);
      this.gwI.add(paramIntent);
      this.gwJ.put(((ax)localObject).field_username, Boolean.TRUE);
      this.gxb.atj.notifyChanged();
      amN();
      this.gxb.gxn += 1;
      this.gxb.gxk += 1;
      p.a(this, (NestedScrollView)findViewById(2131307173), findViewById(2131299179), findViewById(2131309599), findViewById(2131297686));
      amP();
    }
    AppMethodBeat.o(194152);
  }
  
  public void onCreate(Bundle paramBundle)
  {
    boolean bool = true;
    AppMethodBeat.i(182212);
    super.onCreate(paramBundle);
    setMMTitle("");
    this.gwx = getIntent().getStringExtra("RoomInfo_Id");
    this.gwE = getIntent().getIntExtra("upgrade_openim_room_from_scene", 0);
    this.gwF = getIntent().getStringExtra("ticket");
    Log.i("MicroMsg.ManagerRoomByWeworkUI", "mFromScene:%s", new Object[] { Integer.valueOf(this.gwE) });
    int i;
    if (this.gwE == 3)
    {
      if (!Util.isNullOrNil(this.gwF)) {
        break label155;
      }
      Log.e("MicroMsg.ManagerRoomByWeworkUI", "mTicket is null");
      finish();
      i = 0;
    }
    while (i == 0)
    {
      AppMethodBeat.o(182212);
      return;
      if (Util.isNullOrNil(this.gwx))
      {
        Log.e("MicroMsg.ManagerRoomByWeworkUI", "mRoomId is null");
        finish();
        i = 0;
      }
      else
      {
        label155:
        i = 1;
      }
    }
    g.azz().a(3553, this);
    g.azz().a(3927, this);
    Log.i("MicroMsg.ManagerRoomByWeworkUI", "doFetchCollectPubFill() roomId:%s", new Object[] { this.gwx });
    if (this.gwE == 3)
    {
      paramBundle = new k(this.gwF, (byte)0);
      g.azz().a(paramBundle, 0);
      if (this.gwE == 3) {
        break label309;
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
          Log.i("MicroMsg.ManagerRoomByWeworkUI", "onMenuItemClick click");
          WeworkRoomUpgradeResultUI.cr(ManagerRoomByWeworkUI.this);
          ManagerRoomByWeworkUI.this.finish();
          if (ManagerRoomByWeworkUI.a(ManagerRoomByWeworkUI.this) != 3) {
            ManagerRoomByWeworkUI.c(ManagerRoomByWeworkUI.b(ManagerRoomByWeworkUI.this), ManagerRoomByWeworkUI.a(ManagerRoomByWeworkUI.this), 0, 0);
          }
          for (;;)
          {
            AppMethodBeat.o(182207);
            return true;
            ManagerRoomByWeworkUI.this.ok(0);
          }
        }
      });
      AppMethodBeat.o(182212);
      return;
      paramBundle = new k(this.gwx);
      break;
      label309:
      bool = false;
    }
  }
  
  public void onDestroy()
  {
    AppMethodBeat.i(182214);
    g.azz().b(3553, this);
    g.azz().b(3927, this);
    super.onDestroy();
    AppMethodBeat.o(182214);
  }
  
  public boolean onKeyUp(int paramInt, KeyEvent paramKeyEvent)
  {
    AppMethodBeat.i(182215);
    if (this.gwE != 3) {
      c(this.gwx, this.gwE, 0, 0);
    }
    for (;;)
    {
      boolean bool = super.onKeyUp(paramInt, paramKeyEvent);
      AppMethodBeat.o(182215);
      return bool;
      ok(0);
    }
  }
  
  public void onSceneEnd(int paramInt1, int paramInt2, String paramString, com.tencent.mm.ak.q paramq)
  {
    AppMethodBeat.i(182213);
    Log.i("MicroMsg.ManagerRoomByWeworkUI", "onSceneEnd errType = %d, errCode = %d, errMsg = %s, scenetype:%s", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), paramString, Integer.valueOf(paramq.getType()) });
    label121:
    Object localObject1;
    if ((this.gwE != 3) || ((paramq instanceof k)))
    {
      if ((this.tipDialog != null) && (this.tipDialog.isShowing())) {
        this.tipDialog.dismiss();
      }
      if ((paramInt1 != 0) || (paramInt2 != 0)) {
        break label2135;
      }
      if (!(paramq instanceof k)) {
        break label1695;
      }
      paramq = (k)paramq;
      if (paramq.gsa != null) {
        break label769;
      }
      paramq = null;
      if (paramq == null) {
        break label1648;
      }
      super.initView();
      this.gwO = ((Button)findViewById(2131309627));
      this.gwP = ((Button)findViewById(2131307528));
      this.titleTv = ((TextView)findViewById(2131298314));
      this.gwQ = ((CdnImageView)findViewById(2131298296));
      this.gwR = ((TextView)findViewById(2131298311));
      this.gwS = ((TextView)findViewById(2131299222));
      this.gwT = ((LinearLayout)findViewById(2131299208));
      this.gwU = ((LinearLayout)findViewById(2131302189));
      this.gwV = ((LinearLayout)findViewById(2131298301));
      this.gwW = ((RecyclerView)findViewById(2131297056));
      this.gwX = ((LinearLayout)findViewById(2131307530));
      this.gwY = ((TextView)findViewById(2131307531));
      this.gwZ = ((ImageView)findViewById(2131307529));
      findViewById(2131299179).setVisibility(0);
      this.gwO.setOnClickListener(new View.OnClickListener()
      {
        public final void onClick(View paramAnonymousView)
        {
          AppMethodBeat.i(194137);
          com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
          localb.bm(paramAnonymousView);
          com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/chatroom/ui/ManagerRoomByWeworkUI$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.axR());
          Log.i("MicroMsg.ManagerRoomByWeworkUI", "click use");
          if (ManagerRoomByWeworkUI.a(ManagerRoomByWeworkUI.this) == 3) {
            ManagerRoomByWeworkUI.c(ManagerRoomByWeworkUI.this);
          }
          for (;;)
          {
            com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/chatroom/ui/ManagerRoomByWeworkUI$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
            AppMethodBeat.o(194137);
            return;
            ManagerRoomByWeworkUI.d(ManagerRoomByWeworkUI.this);
          }
        }
      });
      if ((this.gwE != 1) && (this.gwE != 2)) {
        break label852;
      }
      this.gwV.setVisibility(0);
      this.gwU.setVisibility(8);
      a(this.gwx, this.gwQ);
      paramString = this.gwx;
      localObject1 = this.gwR;
      paramString = ((com.tencent.mm.plugin.messenger.foundation.a.l)g.af(com.tencent.mm.plugin.messenger.foundation.a.l.class)).aSN().Kn(paramString);
      if (!Util.isNullOrNil(paramString.field_nickname)) {
        break label817;
      }
      if (v.Ie(paramString.field_username) != 0) {
        break label779;
      }
      paramString = getString(2131762956);
      label441:
      ((TextView)localObject1).setText(com.tencent.mm.pluginsdk.ui.span.l.d(this, com.tencent.mm.pluginsdk.ui.span.l.e(this, paramString, com.tencent.mm.cb.a.aG(this, 2131165195))));
    }
    Object localObject3;
    label769:
    label779:
    label817:
    label1601:
    label1604:
    for (;;)
    {
      for (;;)
      {
        amP();
        this.titleTv.setText(paramq.title);
        this.gwS.setText(com.tencent.mm.pluginsdk.ui.span.l.g(getContext(), Util.nullAsNil(paramq.qGG), (int)this.gwS.getTextSize()));
        if ((paramq.LSA == null) || (paramq.LSA.size() <= 0)) {
          break label1606;
        }
        this.gwT.removeAllViews();
        paramString = (LayoutInflater)getContext().getSystemService("layout_inflater");
        paramq = paramq.LSA.iterator();
        paramInt1 = 0;
        while (paramq.hasNext())
        {
          localObject1 = (String)paramq.next();
          localObject3 = paramString.inflate(2131493470, this.gwT, false);
          paramInt1 += 1;
          ((TextView)((View)localObject3).findViewById(2131305694)).setText(paramInt1 + ".");
          ((TextView)((View)localObject3).findViewById(2131299510)).setText((CharSequence)localObject1);
          this.gwT.addView((View)localObject3);
        }
        try
        {
          Log.i("MicroMsg.ManagerRoomByWeworkUI", "NetSceneUpgradeAssociateChatRoom %s", new Object[] { ((w)paramq).dOe });
          this.gwL += 1;
          if ((this.gwL != this.gwM) || (this.tipDialog == null) || (!this.tipDialog.isShowing())) {
            break;
          }
          this.tipDialog.dismiss();
        }
        catch (Exception localException)
        {
          for (;;)
          {
            Log.e("MicroMsg.ManagerRoomByWeworkUI", "NetSceneUpgradeAssociateChatRoom Exception:%s %s", new Object[] { localException.getClass().getSimpleName(), localException.getMessage() });
          }
        }
      }
      paramq = paramq.gsa;
      break label121;
      paramString = getString(2131760811, new Object[] { getString(2131762956), Integer.valueOf(v.Ie(paramString.field_username)) });
      break label441;
      paramString = getString(2131760811, new Object[] { paramString.arI(), Integer.valueOf(v.Ie(paramString.field_username)) });
      break label441;
      label852:
      if (this.gwE == 3)
      {
        this.gwV.setVisibility(8);
        this.gwU.setVisibility(0);
        paramString = new View.OnClickListener()
        {
          public final void onClick(View paramAnonymousView)
          {
            AppMethodBeat.i(194138);
            Object localObject = new com.tencent.mm.hellhoundlib.b.b();
            ((com.tencent.mm.hellhoundlib.b.b)localObject).bm(paramAnonymousView);
            com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/chatroom/ui/ManagerRoomByWeworkUI$3", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, ((com.tencent.mm.hellhoundlib.b.b)localObject).axR());
            Log.i("MicroMsg.ManagerRoomByWeworkUI", "select_group_ll click");
            ManagerRoomByWeworkUI.e(ManagerRoomByWeworkUI.this);
            if (ManagerRoomByWeworkUI.f(ManagerRoomByWeworkUI.this).gxk == 5)
            {
              u.makeText(ManagerRoomByWeworkUI.this, 2131766976, 0).show();
              com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/chatroom/ui/ManagerRoomByWeworkUI$3", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
              AppMethodBeat.o(194138);
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
              ((ArrayList)localObject).add(((as)localIterator.next()).field_username);
            }
            paramAnonymousView.putStringArrayListExtra("group_select_block_chatroom", (ArrayList)localObject);
            paramAnonymousView.putExtra("group_select_chatroom_max_num", v.aTT());
            ManagerRoomByWeworkUI.this.startActivityForResult(paramAnonymousView, 0);
            com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/chatroom/ui/ManagerRoomByWeworkUI$3", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
            AppMethodBeat.o(194138);
          }
        };
        this.gwX.setOnClickListener(paramString);
        this.gwP.setOnClickListener(paramString);
        paramString = ab.aUV();
        if (paramString.size() == 0) {
          paramInt1 = 0;
        }
        for (;;)
        {
          if ((paramInt1 != 0) || (amN())) {
            break label1604;
          }
          findViewById(2131300110).setVisibility(0);
          findViewById(2131309627).setVisibility(8);
          this.gwU.setVisibility(8);
          break;
          paramString = paramString.iterator();
          while (paramString.hasNext())
          {
            localObject2 = (as)paramString.next();
            if (ab.ID(((ax)localObject2).field_username))
            {
              localObject3 = ((com.tencent.mm.plugin.chatroom.a.c)g.af(com.tencent.mm.plugin.chatroom.a.c.class)).aSX().Kd(((ax)localObject2).field_username);
              if (localObject3 == null)
              {
                Log.e("MicroMsg.ManagerRoomByWeworkUI", "initContactList %s member is null", new Object[] { ((ax)localObject2).field_username });
              }
              else if ((((ah)localObject3).field_memberCount < v.aTT()) && (Util.isEqual(((ah)localObject3).field_roomowner, z.aTY())))
              {
                this.gwH.add(localObject2);
                this.gwI.add(((ax)localObject2).field_username);
                this.gwG.add(((ax)localObject2).field_username);
              }
            }
          }
          this.gxd = this.gwH.size();
          paramString = ((com.tencent.mm.plugin.messenger.foundation.a.l)g.af(com.tencent.mm.plugin.messenger.foundation.a.l.class)).aST().gCt();
          localObject2 = new LinkedList();
          localObject3 = ab.aUV();
          if (((List)localObject3).size() == 0) {}
          for (this.gwN = 0;; this.gwN = (((List)localObject2).size() - this.gxd))
          {
            this.gxa = new LinearLayoutManager();
            this.gxa.setOrientation(1);
            this.gwW.setLayoutManager(this.gxa);
            this.gxc = new b(getContext(), 96.0F);
            this.gwW.a(this.gxc);
            this.gxb = new a(getContext(), this.gwH, this.gwJ, this.gwG, new c()
            {
              public final void amQ()
              {
                AppMethodBeat.i(194139);
                ManagerRoomByWeworkUI.h(ManagerRoomByWeworkUI.this);
                AppMethodBeat.o(194139);
              }
            });
            this.gwW.setAdapter(this.gxb);
            this.gwW.setNestedScrollingEnabled(false);
            this.gxb.atj.notifyChanged();
            if (this.gwH.size() != 0) {
              break label1601;
            }
            paramInt1 = 0;
            break;
            Iterator localIterator = ((List)localObject3).iterator();
            while (localIterator.hasNext())
            {
              as localas = (as)localIterator.next();
              if (!ab.Iz(localas.field_username))
              {
                ah localah;
                if (!paramString.containsKey(localas.field_username))
                {
                  if (com.tencent.mm.contact.c.oR(localas.field_type))
                  {
                    localah = ((com.tencent.mm.plugin.chatroom.a.c)g.af(com.tencent.mm.plugin.chatroom.a.c.class)).aSX().Kd(localas.field_username);
                    if (localah == null) {
                      Log.e("MicroMsg.ManagerRoomByWeworkUI", "iniOtherChatroomNum %s member is null", new Object[] { Util.nullAs(localas.field_username, "") });
                    } else if ((localah.JO(z.aTY())) && (c(localas))) {
                      ((List)localObject2).add(localas);
                    }
                  }
                }
                else
                {
                  localah = ((com.tencent.mm.plugin.chatroom.a.c)g.af(com.tencent.mm.plugin.chatroom.a.c.class)).aSX().Kd(localas.field_username);
                  if (localah == null) {
                    Log.e("MicroMsg.ManagerRoomByWeworkUI", "iniOtherChatroomNum %s member is null", new Object[] { Util.nullAs(localas.field_username, "") });
                  } else if ((localah.JO(z.aTY())) && (c(localas))) {
                    ((List)localObject2).add(localas);
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
    label1606:
    p.a(this, (NestedScrollView)findViewById(2131307173), findViewById(2131299179), findViewById(2131309599), findViewById(2131297686));
    AppMethodBeat.o(182213);
    return;
    label1648:
    Object localObject2 = getContext();
    paramq = paramString;
    if (Util.isNullOrNil(paramString)) {
      paramq = getString(2131766974);
    }
    u.makeText((Context)localObject2, paramq, 0).show();
    finish();
    AppMethodBeat.o(182213);
    return;
    label1695:
    if ((paramq instanceof w))
    {
      localObject2 = (w)paramq;
      if (((w)localObject2).gsu == null)
      {
        localObject2 = null;
        if (this.gwE != 3) {
          break label1904;
        }
        if (localObject2 == null) {
          break label1882;
        }
        this.gwK.put(((w)paramq).dOe, Boolean.TRUE);
      }
    }
    else
    {
      label1753:
      if ((this.gwE != 3) || (!(paramq instanceof w)) || (this.gwL != this.gwM)) {
        break label2448;
      }
      Log.i("MicroMsg.ManagerRoomByWeworkUI", "NetSceneUpgradeAssociateChatRoom finish");
      paramString = new ArrayList();
      paramq = new ArrayList();
      localObject2 = this.gwK.entrySet().iterator();
    }
    for (;;)
    {
      if (!((Iterator)localObject2).hasNext()) {
        break label2300;
      }
      localObject3 = (Map.Entry)((Iterator)localObject2).next();
      if (((Boolean)((Map.Entry)localObject3).getValue()).booleanValue())
      {
        paramString.add(((Map.Entry)localObject3).getKey());
        continue;
        localObject2 = ((w)localObject2).gsu;
        break;
        label1882:
        this.gwK.put(((w)paramq).dOe, Boolean.FALSE);
        break label1753;
        label1904:
        if (localObject2 != null)
        {
          c(this.gwx, this.gwE, 1, 0);
          paramString = new Intent();
          paramString.setClass(this, WeworkRoomUpgradeResultUI.class);
          paramString.putExtra("RoomInfo_Id", this.gwx);
          paramString.putExtra("popup_wording", Util.nullAs(((emv)localObject2).NkR, ""));
          paramString.putExtra("upgrade_openim_room_from_scene", this.gwE);
          paramString = new com.tencent.mm.hellhoundlib.b.a().bl(paramString);
          com.tencent.mm.hellhoundlib.a.a.a(this, paramString.axQ(), "com/tencent/mm/chatroom/ui/ManagerRoomByWeworkUI", "onSceneEnd", "(IILjava/lang/String;Lcom/tencent/mm/modelbase/NetSceneBase;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
          startActivity((Intent)paramString.pG(0));
          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/chatroom/ui/ManagerRoomByWeworkUI", "onSceneEnd", "(IILjava/lang/String;Lcom/tencent/mm/modelbase/NetSceneBase;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
          finish();
          super.overridePendingTransition(2130772169, 2130772166);
          AppMethodBeat.o(182213);
          return;
        }
        localObject2 = getContext();
        paramq = paramString;
        if (Util.isNullOrNil(paramString)) {
          paramq = getString(2131766974);
        }
        u.makeText((Context)localObject2, paramq, 0).show();
        c(this.gwx, this.gwE, 2, 4);
        finish();
        AppMethodBeat.o(182213);
        return;
        label2135:
        if ((paramq instanceof k))
        {
          localObject2 = getContext();
          paramq = paramString;
          if (Util.isNullOrNil(paramString)) {
            paramq = getString(2131766974);
          }
          u.makeText((Context)localObject2, paramq, 0).show();
          finish();
          AppMethodBeat.o(182213);
          return;
        }
        if (!(paramq instanceof w)) {
          break label1753;
        }
        if (this.gwE == 3)
        {
          this.gwK.put(((w)paramq).dOe, Boolean.FALSE);
          break label1753;
        }
        c(this.gwx, this.gwE, 2, 4);
        localObject2 = getContext();
        paramq = paramString;
        if (Util.isNullOrNil(paramString)) {
          paramq = getString(2131766974);
        }
        u.makeText((Context)localObject2, paramq, 0).show();
        AppMethodBeat.o(182213);
        return;
      }
      paramq.add(((Map.Entry)localObject3).getKey());
    }
    label2300:
    localObject2 = new Intent();
    ((Intent)localObject2).setClass(this, WeworkRoomUpgradeResultUI.class);
    ((Intent)localObject2).putExtra("upgrade_openim_room_from_scene", this.gwE);
    ((Intent)localObject2).putExtra("wework_upgrade_success_list", paramString);
    ((Intent)localObject2).putExtra("wework_upgrade_fail_list", paramq);
    paramq = new com.tencent.mm.hellhoundlib.b.a().bl(localObject2);
    com.tencent.mm.hellhoundlib.a.a.a(this, paramq.axQ(), "com/tencent/mm/chatroom/ui/ManagerRoomByWeworkUI", "onSceneEnd", "(IILjava/lang/String;Lcom/tencent/mm/modelbase/NetSceneBase;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
    startActivity((Intent)paramq.pG(0));
    com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/chatroom/ui/ManagerRoomByWeworkUI", "onSceneEnd", "(IILjava/lang/String;Lcom/tencent/mm/modelbase/NetSceneBase;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
    finish();
    super.overridePendingTransition(2130772169, 2130772166);
    i(paramString);
    label2448:
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
    private List<as> gxh;
    private List<String> gxi;
    private HashMap<String, Boolean> gxj;
    int gxk;
    private ManagerRoomByWeworkUI.c gxl;
    int gxm;
    int gxn;
    
    public a(Context paramContext, List<as> paramList, HashMap<String, Boolean> paramHashMap, List<String> paramList1, ManagerRoomByWeworkUI.c paramc)
    {
      AppMethodBeat.i(194143);
      this.gxk = 0;
      this.gxm = 0;
      this.gxn = 0;
      this.context = paramContext;
      this.gxh = paramList;
      this.gxj = paramHashMap;
      this.gxi = paramList1;
      this.gxl = paramc;
      paramContext = paramList.iterator();
      while (paramContext.hasNext()) {
        paramHashMap.put(((as)paramContext.next()).field_username, Boolean.FALSE);
      }
      AppMethodBeat.o(194143);
    }
    
    public final RecyclerView.v a(ViewGroup paramViewGroup, int paramInt)
    {
      AppMethodBeat.i(194144);
      paramViewGroup = new ManagerRoomByWeworkUI.d(LayoutInflater.from(paramViewGroup.getContext()).inflate(2131493469, paramViewGroup, false));
      AppMethodBeat.o(194144);
      return paramViewGroup;
    }
    
    public final void a(RecyclerView.v paramv, int paramInt)
    {
      AppMethodBeat.i(194145);
      Log.d("MicroMsg.ManagerRoomByWeworkUI", "onBindViewHolder() count:%s i:%s ", new Object[] { Integer.valueOf(this.gxh.size()), Integer.valueOf(paramInt) });
      as localas;
      Boolean localBoolean;
      CheckBox localCheckBox;
      if ((this.gxh != null) && (paramInt >= 0) && (paramInt < this.gxh.size()))
      {
        paramv = (ManagerRoomByWeworkUI.d)paramv;
        localas = (as)this.gxh.get(paramInt);
        Log.d("MicroMsg.ManagerRoomByWeworkUI", "onBindViewHolder() count:%s i:%s username:%s", new Object[] { Integer.valueOf(this.gxh.size()), Integer.valueOf(paramInt), localas.field_username });
        paramv.gvQ.setVisibility(0);
        ManagerRoomByWeworkUI.a(localas.field_username, paramv.gwQ);
        ManagerRoomByWeworkUI.a(this.context, localas.field_username, paramv.gxs, paramv.gxt, false);
        localBoolean = (Boolean)this.gxj.get(localas.field_username);
        paramv.gxr.setEnabled(true);
        localCheckBox = paramv.gxr;
        if (localBoolean != null) {
          break label238;
        }
      }
      label238:
      for (boolean bool = false;; bool = localBoolean.booleanValue())
      {
        localCheckBox.setChecked(bool);
        paramv.gvQ.setTag(localas);
        paramv.gvQ.setOnClickListener(new View.OnClickListener()
        {
          public final void onClick(View paramAnonymousView)
          {
            AppMethodBeat.i(194142);
            Object localObject = new com.tencent.mm.hellhoundlib.b.b();
            ((com.tencent.mm.hellhoundlib.b.b)localObject).bm(paramAnonymousView);
            com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/chatroom/ui/ManagerRoomByWeworkUI$ChatroomAdapter$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, ((com.tencent.mm.hellhoundlib.b.b)localObject).axR());
            paramAnonymousView = (as)paramAnonymousView.getTag();
            if (paramAnonymousView == null)
            {
              Log.e("MicroMsg.ManagerRoomByWeworkUI", "click:contact is nul");
              com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/chatroom/ui/ManagerRoomByWeworkUI$ChatroomAdapter$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
              AppMethodBeat.o(194142);
              return;
            }
            localObject = (Boolean)ManagerRoomByWeworkUI.a.a(ManagerRoomByWeworkUI.a.this).get(paramAnonymousView.field_username);
            if ((!((Boolean)localObject).booleanValue()) && (ManagerRoomByWeworkUI.a.b(ManagerRoomByWeworkUI.a.this) == 5))
            {
              u.makeText(ManagerRoomByWeworkUI.a.c(ManagerRoomByWeworkUI.a.this), 2131766976, 0).show();
              com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/chatroom/ui/ManagerRoomByWeworkUI$ChatroomAdapter$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
              AppMethodBeat.o(194142);
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
              ManagerRoomByWeworkUI.a.this.atj.notifyChanged();
              if (ManagerRoomByWeworkUI.a.k(ManagerRoomByWeworkUI.a.this) != null) {
                ManagerRoomByWeworkUI.a.k(ManagerRoomByWeworkUI.a.this).amQ();
              }
              com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/chatroom/ui/ManagerRoomByWeworkUI$ChatroomAdapter$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
              AppMethodBeat.o(194142);
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
        AppMethodBeat.o(194145);
        return;
      }
    }
    
    public final int getItemCount()
    {
      AppMethodBeat.i(194146);
      int i = this.gxh.size();
      AppMethodBeat.o(194146);
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
    private Paint gwh;
    private Paint gxp;
    private int gxq;
    
    public b(Context paramContext, float paramFloat)
    {
      AppMethodBeat.i(194147);
      this.dividerHeight = com.tencent.mm.cb.a.fromDPToPix(paramContext, 0.5F);
      this.gxq = com.tencent.mm.cb.a.fromDPToPix(paramContext, paramFloat);
      this.gwh = new Paint();
      this.gwh.setColor(paramContext.getResources().getColor(2131099657));
      this.gxp = new Paint();
      this.gxp.setColor(paramContext.getResources().getColor(2131099689));
      AppMethodBeat.o(194147);
    }
    
    public final void a(Canvas paramCanvas, RecyclerView paramRecyclerView, RecyclerView.s params)
    {
      AppMethodBeat.i(194148);
      super.a(paramCanvas, paramRecyclerView, params);
      int j = paramRecyclerView.getChildCount();
      int k = paramRecyclerView.getPaddingLeft();
      int m = this.gxq;
      int n = paramRecyclerView.getWidth() - paramRecyclerView.getPaddingRight();
      int i = 0;
      if (i < j)
      {
        params = paramRecyclerView.getChildAt(i);
        float f1 = params.getBottom();
        float f2 = params.getBottom() + this.dividerHeight;
        if (i == j - 1) {
          paramCanvas.drawRect(k, f1, n, f2, this.gxp);
        }
        for (;;)
        {
          i += 1;
          break;
          paramCanvas.drawRect(k + m, f1, n, f2, this.gwh);
        }
      }
      AppMethodBeat.o(194148);
    }
    
    public final void a(Rect paramRect, View paramView, RecyclerView paramRecyclerView, RecyclerView.s params)
    {
      AppMethodBeat.i(194149);
      super.a(paramRect, paramView, paramRecyclerView, params);
      paramRect.bottom = this.dividerHeight;
      AppMethodBeat.o(194149);
    }
  }
  
  public static abstract interface c
  {
    public abstract void amQ();
  }
  
  public static final class d
    extends RecyclerView.v
  {
    View gvQ;
    CdnImageView gwQ;
    CheckBox gxr;
    TextView gxs;
    TextView gxt;
    
    public d(View paramView)
    {
      super();
      AppMethodBeat.i(194150);
      this.gvQ = paramView;
      this.gxr = ((CheckBox)paramView.findViewById(2131307508));
      this.gwQ = ((CdnImageView)paramView.findViewById(2131298302));
      this.gxs = ((TextView)paramView.findViewById(2131298310));
      this.gxt = ((TextView)paramView.findViewById(2131298312));
      AppMethodBeat.o(194150);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.chatroom.ui.ManagerRoomByWeworkUI
 * JD-Core Version:    0.7.0.1
 */