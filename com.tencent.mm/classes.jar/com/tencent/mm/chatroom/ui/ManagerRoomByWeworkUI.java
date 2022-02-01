package com.tencent.mm.chatroom.ui;

import android.app.Activity;
import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.os.Bundle;
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
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.widget.NestedScrollView;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.RecyclerView.a;
import androidx.recyclerview.widget.RecyclerView.b;
import androidx.recyclerview.widget.RecyclerView.v;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.an.i;
import com.tencent.mm.an.t;
import com.tencent.mm.chatroom.d.k;
import com.tencent.mm.f.b.a.fw;
import com.tencent.mm.f.b.a.fy;
import com.tencent.mm.f.b.a.fz;
import com.tencent.mm.f.c.ax;
import com.tencent.mm.model.aa;
import com.tencent.mm.model.ab;
import com.tencent.mm.model.aq;
import com.tencent.mm.model.v;
import com.tencent.mm.model.z;
import com.tencent.mm.plugin.expt.b.b.a;
import com.tencent.mm.plugin.messenger.foundation.a.n;
import com.tencent.mm.pluginsdk.ui.applet.CdnImageView;
import com.tencent.mm.pluginsdk.ui.span.l;
import com.tencent.mm.protocal.protobuf.bpv;
import com.tencent.mm.protocal.protobuf.exd;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMHandlerThread;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.ah;
import com.tencent.mm.storage.as;
import com.tencent.mm.storage.bv;
import com.tencent.mm.storage.bw;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.s;
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
  private String jaK;
  private int jaR;
  private String jaS;
  private List<String> jaT;
  private List<as> jaU;
  private List<String> jaV;
  private HashMap<String, Boolean> jaW;
  private HashMap<String, Boolean> jaX;
  private int jaY;
  private int jaZ;
  private int jba;
  public Button jbb;
  public Button jbc;
  private CdnImageView jbd;
  public TextView jbe;
  public TextView jbf;
  public LinearLayout jbg;
  private LinearLayout jbh;
  private LinearLayout jbi;
  private RecyclerView jbj;
  private LinearLayout jbk;
  private TextView jbl;
  private ImageView jbm;
  private LinearLayoutManager jbn;
  private a jbo;
  private ManagerRoomByWeworkUI.b jbp;
  private int jbq;
  private int jbr;
  private s tipDialog;
  public TextView titleTv;
  
  public ManagerRoomByWeworkUI()
  {
    AppMethodBeat.i(192935);
    this.jaT = new ArrayList();
    this.jaU = new ArrayList();
    this.jaV = new ArrayList();
    this.jaW = new HashMap();
    this.jaX = new HashMap();
    this.jaY = 0;
    this.jaZ = 0;
    this.jba = 0;
    this.tipDialog = null;
    this.jbq = 0;
    this.jbr = 0;
    AppMethodBeat.o(192935);
  }
  
  public static void a(Context paramContext, String paramString, TextView paramTextView1, TextView paramTextView2, boolean paramBoolean)
  {
    AppMethodBeat.i(193055);
    SpannableString localSpannableString = l.d(paramContext, aa.PJ(paramString), com.tencent.mm.ci.a.aY(paramContext, a.c.NormalTextSize));
    Object localObject = localSpannableString;
    if (paramBoolean) {
      localObject = l.j(paramContext, localSpannableString, a.h.open_im_title_logo);
    }
    paramTextView1.setText((CharSequence)localObject);
    int i = v.Pu(((n)com.tencent.mm.kernel.h.ae(n.class)).bbL().RG(paramString).field_username);
    if (i == 0)
    {
      paramTextView2.setVisibility(8);
      AppMethodBeat.o(193055);
      return;
    }
    paramTextView2.setVisibility(0);
    paramTextView2.setText(paramContext.getString(a.i.jhi, new Object[] { String.valueOf(i) }));
    AppMethodBeat.o(193055);
  }
  
  private void a(final com.tencent.mm.an.q paramq, boolean paramBoolean)
  {
    AppMethodBeat.i(193018);
    if (this.tipDialog == null)
    {
      getString(a.i.app_tip);
      this.tipDialog = com.tencent.mm.ui.base.h.a(this, getString(a.i.app_loading), paramBoolean, new DialogInterface.OnCancelListener()
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
          com.tencent.mm.kernel.h.aGY().a(paramq);
          if ((paramq instanceof k)) {
            ManagerRoomByWeworkUI.this.finish();
          }
          AppMethodBeat.o(182211);
        }
      });
      AppMethodBeat.o(193018);
      return;
    }
    if (!this.tipDialog.isShowing()) {
      this.tipDialog.show();
    }
    AppMethodBeat.o(193018);
  }
  
  public static void a(String paramString, final CdnImageView paramCdnImageView)
  {
    AppMethodBeat.i(193049);
    if ((Util.isNullOrNil(paramString)) || (paramCdnImageView == null))
    {
      Log.e("MicroMsg.ManagerRoomByWeworkUI", "username or avatarIv null");
      AppMethodBeat.o(193049);
      return;
    }
    paramString = new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(192832);
        Bitmap localBitmap = com.tencent.mm.am.d.a(this.iXG, false, -1, null);
        if (localBitmap == null)
        {
          paramCdnImageView.setImageResource(a.d.default_avatar);
          AppMethodBeat.o(192832);
          return;
        }
        paramCdnImageView.setImageBitmap(localBitmap);
        AppMethodBeat.o(192832);
      }
    };
    if (MMHandlerThread.isMainThread())
    {
      paramString.run();
      AppMethodBeat.o(193049);
      return;
    }
    MMHandlerThread.postToMainThread(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(193765);
        this.val$run.run();
        AppMethodBeat.o(193765);
      }
    });
    AppMethodBeat.o(193049);
  }
  
  private boolean asO()
  {
    AppMethodBeat.i(192991);
    int i;
    if (((com.tencent.mm.plugin.expt.b.b)com.tencent.mm.kernel.h.ae(com.tencent.mm.plugin.expt.b.b.class)).a(b.a.vFp, 1) == 1)
    {
      i = 1;
      if ((i == 0) || (!asP())) {
        break label98;
      }
      if ((this.jaT.size() != 0) || (this.jaV.size() != 0)) {
        break label87;
      }
      this.jbk.setVisibility(8);
    }
    for (;;)
    {
      AppMethodBeat.o(192991);
      return true;
      i = 0;
      break;
      label87:
      this.jbk.setVisibility(0);
    }
    label98:
    this.jbk.setVisibility(8);
    this.jbm.setVisibility(8);
    AppMethodBeat.o(192991);
    return false;
  }
  
  private boolean asP()
  {
    AppMethodBeat.i(193006);
    HashMap localHashMap = ((n)com.tencent.mm.kernel.h.ae(n.class)).bbR().hyG();
    LinkedList localLinkedList = new LinkedList();
    List localList = ab.bdX();
    if (localList.size() == 0)
    {
      AppMethodBeat.o(193006);
      return false;
    }
    Iterator localIterator = localList.iterator();
    while (localIterator.hasNext())
    {
      as localas = (as)localIterator.next();
      if ((!ab.PR(localas.field_username)) && (!this.jaV.contains(localas.field_username)))
      {
        ah localah;
        if (!localHashMap.containsKey(localas.field_username))
        {
          if (com.tencent.mm.contact.d.rk(localas.field_type))
          {
            localah = ((com.tencent.mm.plugin.chatroom.a.b)com.tencent.mm.kernel.h.ae(com.tencent.mm.plugin.chatroom.a.b.class)).bbV().Rw(localas.field_username);
            if (localah == null) {
              Log.e("MicroMsg.ManagerRoomByWeworkUI", "%s member is null", new Object[] { Util.nullAs(localas.field_username, "") });
            } else if ((localah.Rh(z.bcZ())) && (c(localas))) {
              localLinkedList.add(localas);
            }
          }
        }
        else
        {
          localah = ((com.tencent.mm.plugin.chatroom.a.b)com.tencent.mm.kernel.h.ae(com.tencent.mm.plugin.chatroom.a.b.class)).bbV().Rw(localas.field_username);
          if (localah == null) {
            Log.e("MicroMsg.ManagerRoomByWeworkUI", "%s member is null", new Object[] { Util.nullAs(localas.field_username, "") });
          } else if ((localah.Rh(z.bcZ())) && (c(localas))) {
            localLinkedList.add(localas);
          }
        }
      }
    }
    localList.clear();
    if (localLinkedList.size() > 0)
    {
      AppMethodBeat.o(193006);
      return true;
    }
    AppMethodBeat.o(193006);
    return false;
  }
  
  private void asQ()
  {
    AppMethodBeat.i(193040);
    if (this.jaR == 3)
    {
      if (((com.tencent.mm.plugin.expt.b.b)com.tencent.mm.kernel.h.ae(com.tencent.mm.plugin.expt.b.b.class)).a(b.a.vFp, 1) == 1) {}
      for (int i = 1; (i != 0) && (asP()) && (this.jaT.size() == 0) && (this.jaV.size() == 0); i = 0)
      {
        this.jbb.setVisibility(8);
        this.jbc.setVisibility(0);
        AppMethodBeat.o(193040);
        return;
      }
      this.jbb.setVisibility(0);
      this.jbc.setVisibility(8);
      if ((this.jbo != null) && (this.jbo.jbx > 0))
      {
        this.jbb.setEnabled(true);
        AppMethodBeat.o(193040);
        return;
      }
      this.jbb.setEnabled(false);
      AppMethodBeat.o(193040);
      return;
    }
    this.jbb.setVisibility(0);
    this.jbc.setVisibility(8);
    AppMethodBeat.o(193040);
  }
  
  private static boolean c(as paramas)
  {
    AppMethodBeat.i(193010);
    if (paramas == null)
    {
      AppMethodBeat.o(193010);
      return false;
    }
    ah localah = ((com.tencent.mm.plugin.chatroom.a.b)com.tencent.mm.kernel.h.ae(com.tencent.mm.plugin.chatroom.a.b.class)).bbV().Rw(paramas.field_username);
    if (localah == null)
    {
      Log.e("MicroMsg.ManagerRoomByWeworkUI", "isValidByMaxNum %s member is null", new Object[] { paramas.field_username });
      AppMethodBeat.o(193010);
      return false;
    }
    if (localah.field_memberCount < v.bcU())
    {
      AppMethodBeat.o(193010);
      return true;
    }
    AppMethodBeat.o(193010);
    return false;
  }
  
  public static void d(String paramString, int paramInt1, int paramInt2, int paramInt3)
  {
    AppMethodBeat.i(182217);
    fw localfw = new fw();
    localfw.vl(paramString);
    localfw.gnP = paramInt1;
    localfw.gBP = paramInt2;
    localfw.gBQ = paramInt3;
    localfw.bpa();
    AppMethodBeat.o(182217);
  }
  
  private void i(ArrayList<String> paramArrayList)
  {
    long l2 = 0L;
    AppMethodBeat.i(193034);
    StringBuilder localStringBuilder = new StringBuilder();
    paramArrayList = paramArrayList.iterator();
    int j = 0;
    int i = 0;
    if (paramArrayList.hasNext())
    {
      String str = (String)paramArrayList.next();
      if (this.jaT.contains(str)) {
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
    paramArrayList = new fy();
    paramArrayList.gBR = i;
    if (this.jbo == null)
    {
      l1 = 0L;
      paramArrayList.gBS = l1;
      paramArrayList.gBT = j;
      if (this.jbo != null) {
        break label231;
      }
    }
    label231:
    for (long l1 = l2;; l1 = this.jbo.jbA - j)
    {
      paramArrayList.gBU = l1;
      paramArrayList.gBV = paramArrayList.z("sucRoomList", localStringBuilder.toString(), true);
      paramArrayList.gBW = paramArrayList.z("ticketId", Util.nullAs(this.jaS, ""), true);
      paramArrayList.bpa();
      AppMethodBeat.o(193034);
      return;
      l1 = this.jbo.jbz - i;
      break;
    }
  }
  
  public int getLayoutId()
  {
    return a.f.jdU;
  }
  
  public void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    AppMethodBeat.i(192983);
    super.onActivityResult(paramInt1, paramInt2, paramIntent);
    Log.i("MicroMsg.ManagerRoomByWeworkUI", "requestCode=%d | resultCode=%d", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) });
    if (paramInt2 != -1)
    {
      AppMethodBeat.o(192983);
      return;
    }
    if (paramInt1 == 0)
    {
      paramIntent = paramIntent.getStringExtra("Select_Conv_User");
      Object localObject = this.jaU.iterator();
      while (((Iterator)localObject).hasNext()) {
        if (Util.isEqual(((as)((Iterator)localObject).next()).field_username, paramIntent))
        {
          Log.i("MicroMsg.ManagerRoomByWeworkUI", "onActivityResult contain");
          AppMethodBeat.o(192983);
          return;
        }
      }
      localObject = ((n)com.tencent.mm.kernel.h.ae(n.class)).bbL().RG(paramIntent);
      this.jaU.add(localObject);
      this.jaV.add(paramIntent);
      this.jaW.put(((ax)localObject).field_username, Boolean.TRUE);
      this.jbo.alc.notifyChanged();
      asO();
      this.jbo.jbA += 1;
      this.jbo.jbx += 1;
      com.tencent.mm.ui.tools.q.a(this, (NestedScrollView)findViewById(a.e.root_view), findViewById(a.e.container_ll), findViewById(a.e.jdH), findViewById(a.e.bottom_ll));
      asQ();
    }
    AppMethodBeat.o(192983);
  }
  
  public void onCreate(Bundle paramBundle)
  {
    boolean bool = true;
    AppMethodBeat.i(182212);
    super.onCreate(paramBundle);
    setMMTitle("");
    this.jaK = getIntent().getStringExtra("RoomInfo_Id");
    this.jaR = getIntent().getIntExtra("upgrade_openim_room_from_scene", 0);
    this.jaS = getIntent().getStringExtra("ticket");
    Log.i("MicroMsg.ManagerRoomByWeworkUI", "mFromScene:%s", new Object[] { Integer.valueOf(this.jaR) });
    int i;
    if (this.jaR == 3)
    {
      if (!Util.isNullOrNil(this.jaS)) {
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
      if (Util.isNullOrNil(this.jaK))
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
    com.tencent.mm.kernel.h.aGY().a(3553, this);
    com.tencent.mm.kernel.h.aGY().a(3927, this);
    Log.i("MicroMsg.ManagerRoomByWeworkUI", "doFetchCollectPubFill() roomId:%s", new Object[] { this.jaK });
    if (this.jaR == 3)
    {
      paramBundle = new k(this.jaS, (byte)0);
      com.tencent.mm.kernel.h.aGY().a(paramBundle, 0);
      if (this.jaR == 3) {
        break label309;
      }
    }
    for (;;)
    {
      a(paramBundle, bool);
      setMMTitle("");
      hideActionbarLine();
      setActionbarColor(getResources().getColor(a.b.BG_2));
      setBackGroundColorResource(a.b.BG_2);
      setBackBtn(new MenuItem.OnMenuItemClickListener()
      {
        public final boolean onMenuItemClick(MenuItem paramAnonymousMenuItem)
        {
          AppMethodBeat.i(182207);
          Log.i("MicroMsg.ManagerRoomByWeworkUI", "onMenuItemClick click");
          WeworkRoomUpgradeResultUI.cn(ManagerRoomByWeworkUI.this);
          ManagerRoomByWeworkUI.this.finish();
          if (ManagerRoomByWeworkUI.a(ManagerRoomByWeworkUI.this) != 3) {
            ManagerRoomByWeworkUI.d(ManagerRoomByWeworkUI.b(ManagerRoomByWeworkUI.this), ManagerRoomByWeworkUI.a(ManagerRoomByWeworkUI.this), 0, 0);
          }
          for (;;)
          {
            AppMethodBeat.o(182207);
            return true;
            ManagerRoomByWeworkUI.this.qz(0);
          }
        }
      });
      AppMethodBeat.o(182212);
      return;
      paramBundle = new k(this.jaK);
      break;
      label309:
      bool = false;
    }
  }
  
  public void onDestroy()
  {
    AppMethodBeat.i(182214);
    com.tencent.mm.kernel.h.aGY().b(3553, this);
    com.tencent.mm.kernel.h.aGY().b(3927, this);
    super.onDestroy();
    AppMethodBeat.o(182214);
  }
  
  public boolean onKeyUp(int paramInt, KeyEvent paramKeyEvent)
  {
    AppMethodBeat.i(182215);
    if (this.jaR != 3) {
      d(this.jaK, this.jaR, 0, 0);
    }
    for (;;)
    {
      boolean bool = super.onKeyUp(paramInt, paramKeyEvent);
      AppMethodBeat.o(182215);
      return bool;
      qz(0);
    }
  }
  
  public void onSceneEnd(int paramInt1, int paramInt2, String paramString, com.tencent.mm.an.q paramq)
  {
    AppMethodBeat.i(182213);
    Log.i("MicroMsg.ManagerRoomByWeworkUI", "onSceneEnd errType = %d, errCode = %d, errMsg = %s, scenetype:%s", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), paramString, Integer.valueOf(paramq.getType()) });
    label121:
    Object localObject1;
    if ((this.jaR != 3) || ((paramq instanceof k)))
    {
      if ((this.tipDialog != null) && (this.tipDialog.isShowing())) {
        this.tipDialog.dismiss();
      }
      if ((paramInt1 != 0) || (paramInt2 != 0)) {
        break label2138;
      }
      if (!(paramq instanceof k)) {
        break label1698;
      }
      paramq = (k)paramq;
      if (paramq.iWl != null) {
        break label772;
      }
      paramq = null;
      if (paramq == null) {
        break label1651;
      }
      super.initView();
      this.jbb = ((Button)findViewById(a.e.jdP));
      this.jbc = ((Button)findViewById(a.e.jdj));
      this.titleTv = ((TextView)findViewById(a.e.jcD));
      this.jbd = ((CdnImageView)findViewById(a.e.jcp));
      this.jbe = ((TextView)findViewById(a.e.jcA));
      this.jbf = ((TextView)findViewById(a.e.jcF));
      this.jbg = ((LinearLayout)findViewById(a.e.content_ll));
      this.jbh = ((LinearLayout)findViewById(a.e.jcH));
      this.jbi = ((LinearLayout)findViewById(a.e.jct));
      this.jbj = ((RecyclerView)findViewById(a.e.jck));
      this.jbk = ((LinearLayout)findViewById(a.e.jdl));
      this.jbl = ((TextView)findViewById(a.e.jdm));
      this.jbm = ((ImageView)findViewById(a.e.jdk));
      findViewById(a.e.container_ll).setVisibility(0);
      this.jbb.setOnClickListener(new View.OnClickListener()
      {
        public final void onClick(View paramAnonymousView)
        {
          AppMethodBeat.i(191113);
          com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
          localb.bn(paramAnonymousView);
          com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/chatroom/ui/ManagerRoomByWeworkUI$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.aFi());
          Log.i("MicroMsg.ManagerRoomByWeworkUI", "click use");
          if (ManagerRoomByWeworkUI.a(ManagerRoomByWeworkUI.this) == 3) {
            ManagerRoomByWeworkUI.c(ManagerRoomByWeworkUI.this);
          }
          for (;;)
          {
            com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/chatroom/ui/ManagerRoomByWeworkUI$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
            AppMethodBeat.o(191113);
            return;
            ManagerRoomByWeworkUI.d(ManagerRoomByWeworkUI.this);
          }
        }
      });
      if ((this.jaR != 1) && (this.jaR != 2)) {
        break label855;
      }
      this.jbi.setVisibility(0);
      this.jbh.setVisibility(8);
      a(this.jaK, this.jbd);
      paramString = this.jaK;
      localObject1 = this.jbe;
      paramString = ((n)com.tencent.mm.kernel.h.ae(n.class)).bbL().RG(paramString);
      if (!Util.isNullOrNil(paramString.field_nickname)) {
        break label820;
      }
      if (v.Pu(paramString.field_username) != 0) {
        break label782;
      }
      paramString = getString(a.i.jfu);
      label441:
      ((TextView)localObject1).setText(l.j(this, l.d(this, paramString, com.tencent.mm.ci.a.aY(this, a.c.BigTextSize)), a.h.open_im_title_logo));
    }
    Object localObject3;
    label772:
    label782:
    label820:
    label1604:
    label1607:
    for (;;)
    {
      for (;;)
      {
        asQ();
        this.titleTv.setText(paramq.title);
        this.jbf.setText(l.g(getContext(), Util.nullAsNil(paramq.ufH), (int)this.jbf.getTextSize()));
        if ((paramq.Tbm == null) || (paramq.Tbm.size() <= 0)) {
          break label1609;
        }
        this.jbg.removeAllViews();
        paramString = (LayoutInflater)getContext().getSystemService("layout_inflater");
        paramq = paramq.Tbm.iterator();
        paramInt1 = 0;
        while (paramq.hasNext())
        {
          localObject1 = (String)paramq.next();
          localObject3 = paramString.inflate(a.f.jdW, this.jbg, false);
          paramInt1 += 1;
          ((TextView)((View)localObject3).findViewById(a.e.jdd)).setText(paramInt1 + ".");
          ((TextView)((View)localObject3).findViewById(a.e.desc_tv)).setText((CharSequence)localObject1);
          this.jbg.addView((View)localObject3);
        }
        try
        {
          Log.i("MicroMsg.ManagerRoomByWeworkUI", "NetSceneUpgradeAssociateChatRoom %s", new Object[] { ((com.tencent.mm.chatroom.d.w)paramq).fHp });
          this.jaY += 1;
          if ((this.jaY != this.jaZ) || (this.tipDialog == null) || (!this.tipDialog.isShowing())) {
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
      paramq = paramq.iWl;
      break label121;
      paramString = getString(a.i.eFv, new Object[] { getString(a.i.jfu), Integer.valueOf(v.Pu(paramString.field_username)) });
      break label441;
      paramString = getString(a.i.eFv, new Object[] { paramString.ayr(), Integer.valueOf(v.Pu(paramString.field_username)) });
      break label441;
      label855:
      if (this.jaR == 3)
      {
        this.jbi.setVisibility(8);
        this.jbh.setVisibility(0);
        paramString = new View.OnClickListener()
        {
          public final void onClick(View paramAnonymousView)
          {
            AppMethodBeat.i(186234);
            Object localObject = new com.tencent.mm.hellhoundlib.b.b();
            ((com.tencent.mm.hellhoundlib.b.b)localObject).bn(paramAnonymousView);
            com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/chatroom/ui/ManagerRoomByWeworkUI$3", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, ((com.tencent.mm.hellhoundlib.b.b)localObject).aFi());
            Log.i("MicroMsg.ManagerRoomByWeworkUI", "select_group_ll click");
            ManagerRoomByWeworkUI.e(ManagerRoomByWeworkUI.this);
            if (ManagerRoomByWeworkUI.f(ManagerRoomByWeworkUI.this).jbx == 5)
            {
              com.tencent.mm.ui.base.w.makeText(ManagerRoomByWeworkUI.this, a.i.jhg, 0).show();
              com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/chatroom/ui/ManagerRoomByWeworkUI$3", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
              AppMethodBeat.o(186234);
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
            paramAnonymousView.putExtra("group_select_chatroom_max_num", v.bcU());
            ManagerRoomByWeworkUI.this.startActivityForResult(paramAnonymousView, 0);
            com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/chatroom/ui/ManagerRoomByWeworkUI$3", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
            AppMethodBeat.o(186234);
          }
        };
        this.jbk.setOnClickListener(paramString);
        this.jbc.setOnClickListener(paramString);
        paramString = ab.bdX();
        if (paramString.size() == 0) {
          paramInt1 = 0;
        }
        for (;;)
        {
          if ((paramInt1 != 0) || (asO())) {
            break label1607;
          }
          findViewById(a.e.empty_tv).setVisibility(0);
          findViewById(a.e.jdP).setVisibility(8);
          this.jbh.setVisibility(8);
          break;
          paramString = paramString.iterator();
          while (paramString.hasNext())
          {
            localObject2 = (as)paramString.next();
            if (ab.PV(((ax)localObject2).field_username))
            {
              localObject3 = ((com.tencent.mm.plugin.chatroom.a.b)com.tencent.mm.kernel.h.ae(com.tencent.mm.plugin.chatroom.a.b.class)).bbV().Rw(((ax)localObject2).field_username);
              if (localObject3 == null)
              {
                Log.e("MicroMsg.ManagerRoomByWeworkUI", "initContactList %s member is null", new Object[] { ((ax)localObject2).field_username });
              }
              else if ((((ah)localObject3).field_memberCount < v.bcU()) && (Util.isEqual(((ah)localObject3).field_roomowner, z.bcZ())))
              {
                this.jaU.add(localObject2);
                this.jaV.add(((ax)localObject2).field_username);
                this.jaT.add(((ax)localObject2).field_username);
              }
            }
          }
          this.jbq = this.jaU.size();
          paramString = ((n)com.tencent.mm.kernel.h.ae(n.class)).bbR().hyG();
          localObject2 = new LinkedList();
          localObject3 = ab.bdX();
          if (((List)localObject3).size() == 0) {}
          for (this.jba = 0;; this.jba = (((List)localObject2).size() - this.jbq))
          {
            this.jbn = new LinearLayoutManager();
            this.jbn.setOrientation(1);
            this.jbj.setLayoutManager(this.jbn);
            this.jbp = new ManagerRoomByWeworkUI.b(getContext(), 96.0F);
            this.jbj.a(this.jbp);
            this.jbo = new a(getContext(), this.jaU, this.jaW, this.jaT, new c()
            {
              public final void asR()
              {
                AppMethodBeat.i(192050);
                ManagerRoomByWeworkUI.h(ManagerRoomByWeworkUI.this);
                AppMethodBeat.o(192050);
              }
            });
            this.jbj.setAdapter(this.jbo);
            this.jbj.setNestedScrollingEnabled(false);
            this.jbo.alc.notifyChanged();
            if (this.jaU.size() != 0) {
              break label1604;
            }
            paramInt1 = 0;
            break;
            Iterator localIterator = ((List)localObject3).iterator();
            while (localIterator.hasNext())
            {
              as localas = (as)localIterator.next();
              if (!ab.PR(localas.field_username))
              {
                ah localah;
                if (!paramString.containsKey(localas.field_username))
                {
                  if (com.tencent.mm.contact.d.rk(localas.field_type))
                  {
                    localah = ((com.tencent.mm.plugin.chatroom.a.b)com.tencent.mm.kernel.h.ae(com.tencent.mm.plugin.chatroom.a.b.class)).bbV().Rw(localas.field_username);
                    if (localah == null) {
                      Log.e("MicroMsg.ManagerRoomByWeworkUI", "iniOtherChatroomNum %s member is null", new Object[] { Util.nullAs(localas.field_username, "") });
                    } else if ((localah.Rh(z.bcZ())) && (c(localas))) {
                      ((List)localObject2).add(localas);
                    }
                  }
                }
                else
                {
                  localah = ((com.tencent.mm.plugin.chatroom.a.b)com.tencent.mm.kernel.h.ae(com.tencent.mm.plugin.chatroom.a.b.class)).bbV().Rw(localas.field_username);
                  if (localah == null) {
                    Log.e("MicroMsg.ManagerRoomByWeworkUI", "iniOtherChatroomNum %s member is null", new Object[] { Util.nullAs(localas.field_username, "") });
                  } else if ((localah.Rh(z.bcZ())) && (c(localas))) {
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
    label1609:
    com.tencent.mm.ui.tools.q.a(this, (NestedScrollView)findViewById(a.e.root_view), findViewById(a.e.container_ll), findViewById(a.e.jdH), findViewById(a.e.bottom_ll));
    AppMethodBeat.o(182213);
    return;
    label1651:
    Object localObject2 = getContext();
    paramq = paramString;
    if (Util.isNullOrNil(paramString)) {
      paramq = getString(a.i.jhf);
    }
    com.tencent.mm.ui.base.w.makeText((Context)localObject2, paramq, 0).show();
    finish();
    AppMethodBeat.o(182213);
    return;
    label1698:
    if ((paramq instanceof com.tencent.mm.chatroom.d.w))
    {
      localObject2 = (com.tencent.mm.chatroom.d.w)paramq;
      if (((com.tencent.mm.chatroom.d.w)localObject2).iWF == null)
      {
        localObject2 = null;
        if (this.jaR != 3) {
          break label1907;
        }
        if (localObject2 == null) {
          break label1885;
        }
        this.jaX.put(((com.tencent.mm.chatroom.d.w)paramq).fHp, Boolean.TRUE);
      }
    }
    else
    {
      label1756:
      if ((this.jaR != 3) || (!(paramq instanceof com.tencent.mm.chatroom.d.w)) || (this.jaY != this.jaZ)) {
        break label2451;
      }
      Log.i("MicroMsg.ManagerRoomByWeworkUI", "NetSceneUpgradeAssociateChatRoom finish");
      paramString = new ArrayList();
      paramq = new ArrayList();
      localObject2 = this.jaX.entrySet().iterator();
    }
    for (;;)
    {
      if (!((Iterator)localObject2).hasNext()) {
        break label2303;
      }
      localObject3 = (Map.Entry)((Iterator)localObject2).next();
      if (((Boolean)((Map.Entry)localObject3).getValue()).booleanValue())
      {
        paramString.add(((Map.Entry)localObject3).getKey());
        continue;
        localObject2 = ((com.tencent.mm.chatroom.d.w)localObject2).iWF;
        break;
        label1885:
        this.jaX.put(((com.tencent.mm.chatroom.d.w)paramq).fHp, Boolean.FALSE);
        break label1756;
        label1907:
        if (localObject2 != null)
        {
          d(this.jaK, this.jaR, 1, 0);
          paramString = new Intent();
          paramString.setClass(this, WeworkRoomUpgradeResultUI.class);
          paramString.putExtra("RoomInfo_Id", this.jaK);
          paramString.putExtra("popup_wording", Util.nullAs(((exd)localObject2).UxC, ""));
          paramString.putExtra("upgrade_openim_room_from_scene", this.jaR);
          paramString = new com.tencent.mm.hellhoundlib.b.a().bm(paramString);
          com.tencent.mm.hellhoundlib.a.a.b(this, paramString.aFh(), "com/tencent/mm/chatroom/ui/ManagerRoomByWeworkUI", "onSceneEnd", "(IILjava/lang/String;Lcom/tencent/mm/modelbase/NetSceneBase;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
          startActivity((Intent)paramString.sf(0));
          com.tencent.mm.hellhoundlib.a.a.c(this, "com/tencent/mm/chatroom/ui/ManagerRoomByWeworkUI", "onSceneEnd", "(IILjava/lang/String;Lcom/tencent/mm/modelbase/NetSceneBase;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
          finish();
          super.overridePendingTransition(a.a.slide_right_in, a.a.slide_left_out);
          AppMethodBeat.o(182213);
          return;
        }
        localObject2 = getContext();
        paramq = paramString;
        if (Util.isNullOrNil(paramString)) {
          paramq = getString(a.i.jhf);
        }
        com.tencent.mm.ui.base.w.makeText((Context)localObject2, paramq, 0).show();
        d(this.jaK, this.jaR, 2, 4);
        finish();
        AppMethodBeat.o(182213);
        return;
        label2138:
        if ((paramq instanceof k))
        {
          localObject2 = getContext();
          paramq = paramString;
          if (Util.isNullOrNil(paramString)) {
            paramq = getString(a.i.jhf);
          }
          com.tencent.mm.ui.base.w.makeText((Context)localObject2, paramq, 0).show();
          finish();
          AppMethodBeat.o(182213);
          return;
        }
        if (!(paramq instanceof com.tencent.mm.chatroom.d.w)) {
          break label1756;
        }
        if (this.jaR == 3)
        {
          this.jaX.put(((com.tencent.mm.chatroom.d.w)paramq).fHp, Boolean.FALSE);
          break label1756;
        }
        d(this.jaK, this.jaR, 2, 4);
        localObject2 = getContext();
        paramq = paramString;
        if (Util.isNullOrNil(paramString)) {
          paramq = getString(a.i.jhf);
        }
        com.tencent.mm.ui.base.w.makeText((Context)localObject2, paramq, 0).show();
        AppMethodBeat.o(182213);
        return;
      }
      paramq.add(((Map.Entry)localObject3).getKey());
    }
    label2303:
    localObject2 = new Intent();
    ((Intent)localObject2).setClass(this, WeworkRoomUpgradeResultUI.class);
    ((Intent)localObject2).putExtra("upgrade_openim_room_from_scene", this.jaR);
    ((Intent)localObject2).putExtra("wework_upgrade_success_list", paramString);
    ((Intent)localObject2).putExtra("wework_upgrade_fail_list", paramq);
    paramq = new com.tencent.mm.hellhoundlib.b.a().bm(localObject2);
    com.tencent.mm.hellhoundlib.a.a.b(this, paramq.aFh(), "com/tencent/mm/chatroom/ui/ManagerRoomByWeworkUI", "onSceneEnd", "(IILjava/lang/String;Lcom/tencent/mm/modelbase/NetSceneBase;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
    startActivity((Intent)paramq.sf(0));
    com.tencent.mm.hellhoundlib.a.a.c(this, "com/tencent/mm/chatroom/ui/ManagerRoomByWeworkUI", "onSceneEnd", "(IILjava/lang/String;Lcom/tencent/mm/modelbase/NetSceneBase;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
    finish();
    super.overridePendingTransition(a.a.slide_right_in, a.a.slide_left_out);
    i(paramString);
    label2451:
    AppMethodBeat.o(182213);
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
  
  public final void qz(int paramInt)
  {
    long l2 = 0L;
    AppMethodBeat.i(193025);
    fz localfz = new fz();
    localfz.gBX = this.jbq;
    localfz.gBY = this.jbr;
    if (this.jbo == null)
    {
      l1 = 0L;
      localfz.gBZ = l1;
      if (this.jbo != null) {
        break label127;
      }
    }
    label127:
    for (long l1 = l2;; l1 = this.jbo.jbA)
    {
      localfz.gCa = l1;
      localfz.gsS = paramInt;
      localfz.vn(Util.nullAs(this.jaS, ""));
      localfz.gCc = this.jba;
      localfz.bpa();
      AppMethodBeat.o(193025);
      return;
      l1 = this.jbo.jbz;
      break;
    }
  }
  
  public static final class a
    extends RecyclerView.a
  {
    private Context context;
    int jbA;
    private List<as> jbu;
    private List<String> jbv;
    private HashMap<String, Boolean> jbw;
    int jbx;
    private ManagerRoomByWeworkUI.c jby;
    int jbz;
    
    public a(Context paramContext, List<as> paramList, HashMap<String, Boolean> paramHashMap, List<String> paramList1, ManagerRoomByWeworkUI.c paramc)
    {
      AppMethodBeat.i(189528);
      this.jbx = 0;
      this.jbz = 0;
      this.jbA = 0;
      this.context = paramContext;
      this.jbu = paramList;
      this.jbw = paramHashMap;
      this.jbv = paramList1;
      this.jby = paramc;
      paramContext = paramList.iterator();
      while (paramContext.hasNext()) {
        paramHashMap.put(((as)paramContext.next()).field_username, Boolean.FALSE);
      }
      AppMethodBeat.o(189528);
    }
    
    public final RecyclerView.v b(ViewGroup paramViewGroup, int paramInt)
    {
      AppMethodBeat.i(189535);
      paramViewGroup = new ManagerRoomByWeworkUI.d(LayoutInflater.from(paramViewGroup.getContext()).inflate(a.f.jdV, paramViewGroup, false));
      AppMethodBeat.o(189535);
      return paramViewGroup;
    }
    
    public final void d(RecyclerView.v paramv, int paramInt)
    {
      AppMethodBeat.i(189544);
      Log.d("MicroMsg.ManagerRoomByWeworkUI", "onBindViewHolder() count:%s i:%s ", new Object[] { Integer.valueOf(this.jbu.size()), Integer.valueOf(paramInt) });
      as localas;
      Boolean localBoolean;
      CheckBox localCheckBox;
      if ((this.jbu != null) && (paramInt >= 0) && (paramInt < this.jbu.size()))
      {
        paramv = (ManagerRoomByWeworkUI.d)paramv;
        localas = (as)this.jbu.get(paramInt);
        Log.d("MicroMsg.ManagerRoomByWeworkUI", "onBindViewHolder() count:%s i:%s username:%s", new Object[] { Integer.valueOf(this.jbu.size()), Integer.valueOf(paramInt), localas.field_username });
        paramv.jac.setVisibility(0);
        ManagerRoomByWeworkUI.a(localas.field_username, paramv.jbd);
        ManagerRoomByWeworkUI.a(this.context, localas.field_username, paramv.jbF, paramv.jbG, false);
        localBoolean = (Boolean)this.jbw.get(localas.field_username);
        paramv.jbE.setEnabled(true);
        localCheckBox = paramv.jbE;
        if (localBoolean != null) {
          break label238;
        }
      }
      label238:
      for (boolean bool = false;; bool = localBoolean.booleanValue())
      {
        localCheckBox.setChecked(bool);
        paramv.jac.setTag(localas);
        paramv.jac.setOnClickListener(new View.OnClickListener()
        {
          public final void onClick(View paramAnonymousView)
          {
            AppMethodBeat.i(189655);
            Object localObject = new com.tencent.mm.hellhoundlib.b.b();
            ((com.tencent.mm.hellhoundlib.b.b)localObject).bn(paramAnonymousView);
            com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/chatroom/ui/ManagerRoomByWeworkUI$ChatroomAdapter$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, ((com.tencent.mm.hellhoundlib.b.b)localObject).aFi());
            paramAnonymousView = (as)paramAnonymousView.getTag();
            if (paramAnonymousView == null)
            {
              Log.e("MicroMsg.ManagerRoomByWeworkUI", "click:contact is nul");
              com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/chatroom/ui/ManagerRoomByWeworkUI$ChatroomAdapter$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
              AppMethodBeat.o(189655);
              return;
            }
            localObject = (Boolean)ManagerRoomByWeworkUI.a.a(ManagerRoomByWeworkUI.a.this).get(paramAnonymousView.field_username);
            if ((!((Boolean)localObject).booleanValue()) && (ManagerRoomByWeworkUI.a.b(ManagerRoomByWeworkUI.a.this) == 5))
            {
              com.tencent.mm.ui.base.w.makeText(ManagerRoomByWeworkUI.a.c(ManagerRoomByWeworkUI.a.this), a.i.jhg, 0).show();
              com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/chatroom/ui/ManagerRoomByWeworkUI$ChatroomAdapter$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
              AppMethodBeat.o(189655);
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
                break label294;
              }
              ManagerRoomByWeworkUI.a.d(ManagerRoomByWeworkUI.a.this);
              if (!ManagerRoomByWeworkUI.a.e(ManagerRoomByWeworkUI.a.this).contains(paramAnonymousView.field_username)) {
                break label283;
              }
              ManagerRoomByWeworkUI.a.f(ManagerRoomByWeworkUI.a.this);
            }
            for (;;)
            {
              ManagerRoomByWeworkUI.a.this.alc.notifyChanged();
              if (ManagerRoomByWeworkUI.a.k(ManagerRoomByWeworkUI.a.this) != null) {
                ManagerRoomByWeworkUI.a.k(ManagerRoomByWeworkUI.a.this).asR();
              }
              com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/chatroom/ui/ManagerRoomByWeworkUI$ChatroomAdapter$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
              AppMethodBeat.o(189655);
              return;
              bool = false;
              break;
              label283:
              ManagerRoomByWeworkUI.a.g(ManagerRoomByWeworkUI.a.this);
              continue;
              label294:
              ManagerRoomByWeworkUI.a.h(ManagerRoomByWeworkUI.a.this);
              if (ManagerRoomByWeworkUI.a.e(ManagerRoomByWeworkUI.a.this).contains(paramAnonymousView.field_username)) {
                ManagerRoomByWeworkUI.a.i(ManagerRoomByWeworkUI.a.this);
              } else {
                ManagerRoomByWeworkUI.a.j(ManagerRoomByWeworkUI.a.this);
              }
            }
          }
        });
        AppMethodBeat.o(189544);
        return;
      }
    }
    
    public final int getItemCount()
    {
      AppMethodBeat.i(189548);
      int i = this.jbu.size();
      AppMethodBeat.o(189548);
      return i;
    }
    
    public final int getItemViewType(int paramInt)
    {
      return 0;
    }
  }
  
  public static abstract interface c
  {
    public abstract void asR();
  }
  
  public static final class d
    extends RecyclerView.v
  {
    View jac;
    CheckBox jbE;
    TextView jbF;
    TextView jbG;
    CdnImageView jbd;
    
    public d(View paramView)
    {
      super();
      AppMethodBeat.i(190798);
      this.jac = paramView;
      this.jbE = ((CheckBox)paramView.findViewById(a.e.select_cb));
      this.jbd = ((CdnImageView)paramView.findViewById(a.e.jcu));
      this.jbF = ((TextView)paramView.findViewById(a.e.jcz));
      this.jbG = ((TextView)paramView.findViewById(a.e.jcB));
      AppMethodBeat.o(190798);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.chatroom.ui.ManagerRoomByWeworkUI
 * JD-Core Version:    0.7.0.1
 */