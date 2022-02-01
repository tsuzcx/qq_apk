package com.tencent.mm.chatroom.ui;

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
import com.tencent.mm.am.s;
import com.tencent.mm.autogen.b.az;
import com.tencent.mm.autogen.mmdata.rpt.hr;
import com.tencent.mm.autogen.mmdata.rpt.ht;
import com.tencent.mm.autogen.mmdata.rpt.hu;
import com.tencent.mm.model.ab;
import com.tencent.mm.model.ar;
import com.tencent.mm.model.v;
import com.tencent.mm.plugin.expt.b.c;
import com.tencent.mm.plugin.expt.b.c.a;
import com.tencent.mm.pluginsdk.ui.applet.CdnImageView;
import com.tencent.mm.protocal.protobuf.cem;
import com.tencent.mm.protocal.protobuf.fsw;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMHandlerThread;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.aj;
import com.tencent.mm.storage.au;
import com.tencent.mm.storage.bx;
import com.tencent.mm.storage.by;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.k;
import com.tencent.mm.ui.base.w;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map.Entry;
import java.util.Set;

public class ManagerRoomByWeworkUI
  extends MMActivity
  implements com.tencent.mm.am.h
{
  private int lCR;
  private String lCS;
  private List<String> lCT;
  private List<au> lCU;
  private List<String> lCV;
  private HashMap<String, Boolean> lCW;
  private HashMap<String, Boolean> lCX;
  private int lCY;
  private int lCZ;
  private int lDa;
  public Button lDb;
  public Button lDc;
  private CdnImageView lDd;
  public TextView lDe;
  public TextView lDf;
  public LinearLayout lDg;
  private LinearLayout lDh;
  private LinearLayout lDi;
  private RecyclerView lDj;
  private LinearLayout lDk;
  private TextView lDl;
  private ImageView lDm;
  private LinearLayoutManager lDn;
  private a lDo;
  private ManagerRoomByWeworkUI.b lDp;
  private int lDq;
  private int lDr;
  private String lyn;
  private w tipDialog;
  public TextView titleTv;
  
  public ManagerRoomByWeworkUI()
  {
    AppMethodBeat.i(241620);
    this.lCT = new ArrayList();
    this.lCU = new ArrayList();
    this.lCV = new ArrayList();
    this.lCW = new HashMap();
    this.lCX = new HashMap();
    this.lCY = 0;
    this.lCZ = 0;
    this.lDa = 0;
    this.tipDialog = null;
    this.lDq = 0;
    this.lDr = 0;
    AppMethodBeat.o(241620);
  }
  
  public static void a(Context paramContext, String paramString, TextView paramTextView1, TextView paramTextView2, boolean paramBoolean)
  {
    AppMethodBeat.i(241654);
    SpannableString localSpannableString = com.tencent.mm.pluginsdk.ui.span.p.d(paramContext, com.tencent.mm.model.aa.getDisplayName(paramString), com.tencent.mm.cd.a.br(paramContext, a.c.NormalTextSize));
    Object localObject = localSpannableString;
    if (paramBoolean) {
      localObject = com.tencent.mm.pluginsdk.ui.span.p.i(paramContext, localSpannableString, a.h.open_im_title_logo);
    }
    paramTextView1.setText((CharSequence)localObject);
    int i = v.getMembersCountByChatRoomName(((com.tencent.mm.plugin.messenger.foundation.a.n)com.tencent.mm.kernel.h.ax(com.tencent.mm.plugin.messenger.foundation.a.n.class)).bzA().JE(paramString).field_username);
    if (i == 0)
    {
      paramTextView2.setVisibility(8);
      AppMethodBeat.o(241654);
      return;
    }
    paramTextView2.setVisibility(0);
    paramTextView2.setText(paramContext.getString(a.i.lJy, new Object[] { String.valueOf(i) }));
    AppMethodBeat.o(241654);
  }
  
  private void a(final com.tencent.mm.am.p paramp, boolean paramBoolean)
  {
    AppMethodBeat.i(241632);
    if (this.tipDialog == null)
    {
      getString(a.i.app_tip);
      this.tipDialog = k.a(this, getString(a.i.app_loading), paramBoolean, new DialogInterface.OnCancelListener()
      {
        public final void onCancel(DialogInterface paramAnonymousDialogInterface)
        {
          AppMethodBeat.i(182211);
          if (paramp == null)
          {
            Log.i("MicroMsg.ManagerRoomByWeworkUI", "dialog onCancel scene is null");
            AppMethodBeat.o(182211);
            return;
          }
          Log.i("MicroMsg.ManagerRoomByWeworkUI", "dialog onCancel scene:%s", new Object[] { Integer.valueOf(paramp.getType()) });
          com.tencent.mm.kernel.h.aZW().a(paramp);
          if ((paramp instanceof com.tencent.mm.chatroom.d.n)) {
            ManagerRoomByWeworkUI.this.finish();
          }
          AppMethodBeat.o(182211);
        }
      });
      AppMethodBeat.o(241632);
      return;
    }
    if (!this.tipDialog.isShowing()) {
      this.tipDialog.show();
    }
    AppMethodBeat.o(241632);
  }
  
  public static void a(String paramString, final CdnImageView paramCdnImageView)
  {
    AppMethodBeat.i(241648);
    if ((Util.isNullOrNil(paramString)) || (paramCdnImageView == null))
    {
      Log.e("MicroMsg.ManagerRoomByWeworkUI", "username or avatarIv null");
      AppMethodBeat.o(241648);
      return;
    }
    paramString = new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(241827);
        Bitmap localBitmap = com.tencent.mm.modelavatar.d.a(ManagerRoomByWeworkUI.this, false, -1, null);
        if (localBitmap == null)
        {
          paramCdnImageView.setImageResource(a.d.default_avatar);
          AppMethodBeat.o(241827);
          return;
        }
        paramCdnImageView.setImageBitmap(localBitmap);
        AppMethodBeat.o(241827);
      }
    };
    if (MMHandlerThread.isMainThread())
    {
      paramString.run();
      AppMethodBeat.o(241648);
      return;
    }
    MMHandlerThread.postToMainThread(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(241824);
        ManagerRoomByWeworkUI.this.run();
        AppMethodBeat.o(241824);
      }
    });
    AppMethodBeat.o(241648);
  }
  
  private boolean aMP()
  {
    AppMethodBeat.i(241622);
    int i;
    if (((c)com.tencent.mm.kernel.h.ax(c.class)).a(c.a.yUN, 1) == 1)
    {
      i = 1;
      if ((i == 0) || (!aMQ())) {
        break label98;
      }
      if ((this.lCT.size() != 0) || (this.lCV.size() != 0)) {
        break label87;
      }
      this.lDk.setVisibility(8);
    }
    for (;;)
    {
      AppMethodBeat.o(241622);
      return true;
      i = 0;
      break;
      label87:
      this.lDk.setVisibility(0);
    }
    label98:
    this.lDk.setVisibility(8);
    this.lDm.setVisibility(8);
    AppMethodBeat.o(241622);
    return false;
  }
  
  private boolean aMQ()
  {
    AppMethodBeat.i(241626);
    HashMap localHashMap = ((com.tencent.mm.plugin.messenger.foundation.a.n)com.tencent.mm.kernel.h.ax(com.tencent.mm.plugin.messenger.foundation.a.n.class)).bzG().jaL();
    LinkedList localLinkedList = new LinkedList();
    List localList = ab.bBP();
    if ((localList == null) || (localList.size() == 0))
    {
      AppMethodBeat.o(241626);
      return false;
    }
    Iterator localIterator = localList.iterator();
    while (localIterator.hasNext())
    {
      au localau = (au)localIterator.next();
      if ((!ab.IG(localau.field_username)) && (!this.lCV.contains(localau.field_username)))
      {
        aj localaj;
        if (!localHashMap.containsKey(localau.field_username))
        {
          if (com.tencent.mm.contact.d.rs(localau.field_type))
          {
            localaj = ((com.tencent.mm.plugin.chatroom.a.b)com.tencent.mm.kernel.h.ax(com.tencent.mm.plugin.chatroom.a.b.class)).bzK().Ju(localau.field_username);
            if (localaj == null) {
              Log.e("MicroMsg.ManagerRoomByWeworkUI", "%s member is null", new Object[] { Util.nullAs(localau.field_username, "") });
            } else if ((localaj.Jf(com.tencent.mm.model.z.bAM())) && (c(localau))) {
              localLinkedList.add(localau);
            }
          }
        }
        else
        {
          localaj = ((com.tencent.mm.plugin.chatroom.a.b)com.tencent.mm.kernel.h.ax(com.tencent.mm.plugin.chatroom.a.b.class)).bzK().Ju(localau.field_username);
          if (localaj == null) {
            Log.e("MicroMsg.ManagerRoomByWeworkUI", "%s member is null", new Object[] { Util.nullAs(localau.field_username, "") });
          } else if ((localaj.Jf(com.tencent.mm.model.z.bAM())) && (c(localau))) {
            localLinkedList.add(localau);
          }
        }
      }
    }
    localList.clear();
    if (localLinkedList.size() > 0)
    {
      AppMethodBeat.o(241626);
      return true;
    }
    AppMethodBeat.o(241626);
    return false;
  }
  
  private void aMR()
  {
    AppMethodBeat.i(241642);
    if (this.lCR == 3)
    {
      if (((c)com.tencent.mm.kernel.h.ax(c.class)).a(c.a.yUN, 1) == 1) {}
      for (int i = 1; (i != 0) && (aMQ()) && (this.lCT.size() == 0) && (this.lCV.size() == 0); i = 0)
      {
        this.lDb.setVisibility(8);
        this.lDc.setVisibility(0);
        AppMethodBeat.o(241642);
        return;
      }
      this.lDb.setVisibility(0);
      this.lDc.setVisibility(8);
      if ((this.lDo != null) && (this.lDo.lDx > 0))
      {
        this.lDb.setEnabled(true);
        AppMethodBeat.o(241642);
        return;
      }
      this.lDb.setEnabled(false);
      AppMethodBeat.o(241642);
      return;
    }
    this.lDb.setVisibility(0);
    this.lDc.setVisibility(8);
    AppMethodBeat.o(241642);
  }
  
  private static boolean c(au paramau)
  {
    AppMethodBeat.i(241629);
    if (paramau == null)
    {
      AppMethodBeat.o(241629);
      return false;
    }
    aj localaj = ((com.tencent.mm.plugin.chatroom.a.b)com.tencent.mm.kernel.h.ax(com.tencent.mm.plugin.chatroom.a.b.class)).bzK().Ju(paramau.field_username);
    if (localaj == null)
    {
      Log.e("MicroMsg.ManagerRoomByWeworkUI", "isValidByMaxNum %s member is null", new Object[] { paramau.field_username });
      AppMethodBeat.o(241629);
      return false;
    }
    if (localaj.field_memberCount < v.bAH())
    {
      AppMethodBeat.o(241629);
      return true;
    }
    AppMethodBeat.o(241629);
    return false;
  }
  
  public static void d(String paramString, int paramInt1, int paramInt2, int paramInt3)
  {
    AppMethodBeat.i(182217);
    hr localhr = new hr();
    localhr.rF(paramString);
    localhr.iqr = paramInt1;
    localhr.iOQ = paramInt2;
    localhr.iOR = paramInt3;
    localhr.bMH();
    AppMethodBeat.o(182217);
  }
  
  private void l(ArrayList<String> paramArrayList)
  {
    long l2 = 0L;
    AppMethodBeat.i(241638);
    StringBuilder localStringBuilder = new StringBuilder();
    paramArrayList = paramArrayList.iterator();
    int j = 0;
    int i = 0;
    if (paramArrayList.hasNext())
    {
      String str = (String)paramArrayList.next();
      if (this.lCT.contains(str)) {
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
    paramArrayList = new ht();
    paramArrayList.iOS = i;
    if (this.lDo == null)
    {
      l1 = 0L;
      paramArrayList.iOT = l1;
      paramArrayList.iOU = j;
      if (this.lDo != null) {
        break label231;
      }
    }
    label231:
    for (long l1 = l2;; l1 = this.lDo.lDA - j)
    {
      paramArrayList.iOV = l1;
      paramArrayList.iOW = paramArrayList.F("sucRoomList", localStringBuilder.toString(), true);
      paramArrayList.iOX = paramArrayList.F("ticketId", Util.nullAs(this.lCS, ""), true);
      paramArrayList.bMH();
      AppMethodBeat.o(241638);
      return;
      l1 = this.lDo.lDz - i;
      break;
    }
  }
  
  public int getLayoutId()
  {
    return a.f.lGd;
  }
  
  public void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    AppMethodBeat.i(241708);
    super.onActivityResult(paramInt1, paramInt2, paramIntent);
    Log.i("MicroMsg.ManagerRoomByWeworkUI", "requestCode=%d | resultCode=%d", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) });
    if (paramInt2 != -1)
    {
      AppMethodBeat.o(241708);
      return;
    }
    if (paramInt1 == 0)
    {
      paramIntent = paramIntent.getStringExtra("Select_Conv_User");
      Object localObject = this.lCU.iterator();
      while (((Iterator)localObject).hasNext()) {
        if (Util.isEqual(((au)((Iterator)localObject).next()).field_username, paramIntent))
        {
          Log.i("MicroMsg.ManagerRoomByWeworkUI", "onActivityResult contain");
          AppMethodBeat.o(241708);
          return;
        }
      }
      localObject = ((com.tencent.mm.plugin.messenger.foundation.a.n)com.tencent.mm.kernel.h.ax(com.tencent.mm.plugin.messenger.foundation.a.n.class)).bzA().JE(paramIntent);
      this.lCU.add(localObject);
      this.lCV.add(paramIntent);
      this.lCW.put(((az)localObject).field_username, Boolean.TRUE);
      this.lDo.bZE.notifyChanged();
      aMP();
      this.lDo.lDA += 1;
      this.lDo.lDx += 1;
      com.tencent.mm.ui.tools.p.a(this, (NestedScrollView)findViewById(a.e.root_view), findViewById(a.e.container_ll), findViewById(a.e.lFP), findViewById(a.e.bottom_ll));
      aMR();
    }
    AppMethodBeat.o(241708);
  }
  
  public void onCreate(Bundle paramBundle)
  {
    boolean bool = true;
    AppMethodBeat.i(182212);
    super.onCreate(paramBundle);
    setMMTitle("");
    this.lyn = getIntent().getStringExtra("RoomInfo_Id");
    this.lCR = getIntent().getIntExtra("upgrade_openim_room_from_scene", 0);
    this.lCS = getIntent().getStringExtra("ticket");
    Log.i("MicroMsg.ManagerRoomByWeworkUI", "mFromScene:%s", new Object[] { Integer.valueOf(this.lCR) });
    int i;
    if (this.lCR == 3)
    {
      if (!Util.isNullOrNil(this.lCS)) {
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
      if (Util.isNullOrNil(this.lyn))
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
    com.tencent.mm.kernel.h.aZW().a(3553, this);
    com.tencent.mm.kernel.h.aZW().a(3927, this);
    Log.i("MicroMsg.ManagerRoomByWeworkUI", "doFetchCollectPubFill() roomId:%s", new Object[] { this.lyn });
    if (this.lCR == 3)
    {
      paramBundle = new com.tencent.mm.chatroom.d.n(this.lCS, (byte)0);
      com.tencent.mm.kernel.h.aZW().a(paramBundle, 0);
      if (this.lCR == 3) {
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
          WeworkRoomUpgradeResultUI.db(ManagerRoomByWeworkUI.this);
          ManagerRoomByWeworkUI.this.finish();
          if (ManagerRoomByWeworkUI.a(ManagerRoomByWeworkUI.this) != 3) {
            ManagerRoomByWeworkUI.d(ManagerRoomByWeworkUI.b(ManagerRoomByWeworkUI.this), ManagerRoomByWeworkUI.a(ManagerRoomByWeworkUI.this), 0, 0);
          }
          for (;;)
          {
            AppMethodBeat.o(182207);
            return true;
            ManagerRoomByWeworkUI.this.qC(0);
          }
        }
      });
      AppMethodBeat.o(182212);
      return;
      paramBundle = new com.tencent.mm.chatroom.d.n(this.lyn);
      break;
      label309:
      bool = false;
    }
  }
  
  public void onDestroy()
  {
    AppMethodBeat.i(182214);
    com.tencent.mm.kernel.h.aZW().b(3553, this);
    com.tencent.mm.kernel.h.aZW().b(3927, this);
    super.onDestroy();
    AppMethodBeat.o(182214);
  }
  
  public boolean onKeyUp(int paramInt, KeyEvent paramKeyEvent)
  {
    AppMethodBeat.i(182215);
    if (this.lCR != 3) {
      d(this.lyn, this.lCR, 0, 0);
    }
    for (;;)
    {
      boolean bool = super.onKeyUp(paramInt, paramKeyEvent);
      AppMethodBeat.o(182215);
      return bool;
      qC(0);
    }
  }
  
  public void onSceneEnd(int paramInt1, int paramInt2, String paramString, com.tencent.mm.am.p paramp)
  {
    AppMethodBeat.i(182213);
    Log.i("MicroMsg.ManagerRoomByWeworkUI", "onSceneEnd errType = %d, errCode = %d, errMsg = %s, scenetype:%s", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), paramString, Integer.valueOf(paramp.getType()) });
    label121:
    Object localObject1;
    if ((this.lCR != 3) || ((paramp instanceof com.tencent.mm.chatroom.d.n)))
    {
      if ((this.tipDialog != null) && (this.tipDialog.isShowing())) {
        this.tipDialog.dismiss();
      }
      if ((paramInt1 != 0) || (paramInt2 != 0)) {
        break label2150;
      }
      if (!(paramp instanceof com.tencent.mm.chatroom.d.n)) {
        break label1707;
      }
      paramp = (com.tencent.mm.chatroom.d.n)paramp;
      if (paramp.lyo != null) {
        break label772;
      }
      paramp = null;
      if (paramp == null) {
        break label1660;
      }
      super.initView();
      this.lDb = ((Button)findViewById(a.e.lFX));
      this.lDc = ((Button)findViewById(a.e.lFr));
      this.titleTv = ((TextView)findViewById(a.e.lED));
      this.lDd = ((CdnImageView)findViewById(a.e.lEp));
      this.lDe = ((TextView)findViewById(a.e.lEA));
      this.lDf = ((TextView)findViewById(a.e.lEG));
      this.lDg = ((LinearLayout)findViewById(a.e.content_ll));
      this.lDh = ((LinearLayout)findViewById(a.e.lEN));
      this.lDi = ((LinearLayout)findViewById(a.e.lEt));
      this.lDj = ((RecyclerView)findViewById(a.e.lEk));
      this.lDk = ((LinearLayout)findViewById(a.e.lFt));
      this.lDl = ((TextView)findViewById(a.e.lFu));
      this.lDm = ((ImageView)findViewById(a.e.lFs));
      findViewById(a.e.container_ll).setVisibility(0);
      this.lDb.setOnClickListener(new View.OnClickListener()
      {
        public final void onClick(View paramAnonymousView)
        {
          AppMethodBeat.i(241825);
          com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
          localb.cH(paramAnonymousView);
          com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/chatroom/ui/ManagerRoomByWeworkUI$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.aYj());
          Log.i("MicroMsg.ManagerRoomByWeworkUI", "click use");
          if (ManagerRoomByWeworkUI.a(ManagerRoomByWeworkUI.this) == 3) {
            ManagerRoomByWeworkUI.c(ManagerRoomByWeworkUI.this);
          }
          for (;;)
          {
            com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/chatroom/ui/ManagerRoomByWeworkUI$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
            AppMethodBeat.o(241825);
            return;
            ManagerRoomByWeworkUI.d(ManagerRoomByWeworkUI.this);
          }
        }
      });
      if ((this.lCR != 1) && (this.lCR != 2)) {
        break label855;
      }
      this.lDi.setVisibility(0);
      this.lDh.setVisibility(8);
      a(this.lyn, this.lDd);
      paramString = this.lyn;
      localObject1 = this.lDe;
      paramString = ((com.tencent.mm.plugin.messenger.foundation.a.n)com.tencent.mm.kernel.h.ax(com.tencent.mm.plugin.messenger.foundation.a.n.class)).bzA().JE(paramString);
      if (!Util.isNullOrNil(paramString.field_nickname)) {
        break label820;
      }
      if (v.getMembersCountByChatRoomName(paramString.field_username) != 0) {
        break label782;
      }
      paramString = getString(a.i.lHF);
      label441:
      ((TextView)localObject1).setText(com.tencent.mm.pluginsdk.ui.span.p.i(this, com.tencent.mm.pluginsdk.ui.span.p.d(this, paramString, com.tencent.mm.cd.a.br(this, a.c.BigTextSize)), a.h.open_im_title_logo));
    }
    Object localObject3;
    label772:
    label782:
    label820:
    label1613:
    label1616:
    for (;;)
    {
      for (;;)
      {
        aMR();
        this.titleTv.setText(paramp.title);
        this.lDf.setText(com.tencent.mm.pluginsdk.ui.span.p.f(getContext(), Util.nullAsNil(paramp.xlO), (int)this.lDf.getTextSize()));
        if ((paramp.aaoy == null) || (paramp.aaoy.size() <= 0)) {
          break label1618;
        }
        this.lDg.removeAllViews();
        paramString = (LayoutInflater)getContext().getSystemService("layout_inflater");
        paramp = paramp.aaoy.iterator();
        paramInt1 = 0;
        while (paramp.hasNext())
        {
          localObject1 = (String)paramp.next();
          localObject3 = paramString.inflate(a.f.lGf, this.lDg, false);
          paramInt1 += 1;
          ((TextView)((View)localObject3).findViewById(a.e.lFl)).setText(paramInt1 + ".");
          ((TextView)((View)localObject3).findViewById(a.e.desc_tv)).setText((CharSequence)localObject1);
          this.lDg.addView((View)localObject3);
        }
        try
        {
          Log.i("MicroMsg.ManagerRoomByWeworkUI", "NetSceneUpgradeAssociateChatRoom %s", new Object[] { ((com.tencent.mm.chatroom.d.z)paramp).hMM });
          this.lCY += 1;
          if ((this.lCY != this.lCZ) || (this.tipDialog == null) || (!this.tipDialog.isShowing())) {
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
      paramp = paramp.lyo;
      break label121;
      paramString = getString(a.i.gIp, new Object[] { getString(a.i.lHF), Integer.valueOf(v.getMembersCountByChatRoomName(paramString.field_username)) });
      break label441;
      paramString = getString(a.i.gIp, new Object[] { paramString.aSU(), Integer.valueOf(v.getMembersCountByChatRoomName(paramString.field_username)) });
      break label441;
      label855:
      if (this.lCR == 3)
      {
        this.lDi.setVisibility(8);
        this.lDh.setVisibility(0);
        paramString = new View.OnClickListener()
        {
          public final void onClick(View paramAnonymousView)
          {
            AppMethodBeat.i(241822);
            Object localObject = new com.tencent.mm.hellhoundlib.b.b();
            ((com.tencent.mm.hellhoundlib.b.b)localObject).cH(paramAnonymousView);
            com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/chatroom/ui/ManagerRoomByWeworkUI$3", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, ((com.tencent.mm.hellhoundlib.b.b)localObject).aYj());
            Log.i("MicroMsg.ManagerRoomByWeworkUI", "select_group_ll click");
            ManagerRoomByWeworkUI.e(ManagerRoomByWeworkUI.this);
            if (ManagerRoomByWeworkUI.f(ManagerRoomByWeworkUI.this).lDx == 5)
            {
              com.tencent.mm.ui.base.aa.makeText(ManagerRoomByWeworkUI.this, a.i.lJw, 0).show();
              com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/chatroom/ui/ManagerRoomByWeworkUI$3", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
              AppMethodBeat.o(241822);
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
              ((ArrayList)localObject).add(((au)localIterator.next()).field_username);
            }
            paramAnonymousView.putStringArrayListExtra("group_select_block_chatroom", (ArrayList)localObject);
            paramAnonymousView.putExtra("group_select_chatroom_max_num", v.bAH());
            ManagerRoomByWeworkUI.this.startActivityForResult(paramAnonymousView, 0);
            com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/chatroom/ui/ManagerRoomByWeworkUI$3", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
            AppMethodBeat.o(241822);
          }
        };
        this.lDk.setOnClickListener(paramString);
        this.lDc.setOnClickListener(paramString);
        paramString = ab.bBP();
        if ((paramString == null) || (paramString.size() == 0)) {
          paramInt1 = 0;
        }
        for (;;)
        {
          if ((paramInt1 != 0) || (aMP())) {
            break label1616;
          }
          findViewById(a.e.empty_tv).setVisibility(0);
          findViewById(a.e.lFX).setVisibility(8);
          this.lDh.setVisibility(8);
          break;
          paramString = paramString.iterator();
          while (paramString.hasNext())
          {
            localObject2 = (au)paramString.next();
            if (ab.IK(((az)localObject2).field_username))
            {
              localObject3 = ((com.tencent.mm.plugin.chatroom.a.b)com.tencent.mm.kernel.h.ax(com.tencent.mm.plugin.chatroom.a.b.class)).bzK().Ju(((az)localObject2).field_username);
              if (localObject3 == null)
              {
                Log.e("MicroMsg.ManagerRoomByWeworkUI", "initContactList %s member is null", new Object[] { ((az)localObject2).field_username });
              }
              else if ((((aj)localObject3).field_memberCount < v.bAH()) && (Util.isEqual(((aj)localObject3).field_roomowner, com.tencent.mm.model.z.bAM())))
              {
                this.lCU.add(localObject2);
                this.lCV.add(((az)localObject2).field_username);
                this.lCT.add(((az)localObject2).field_username);
              }
            }
          }
          this.lDq = this.lCU.size();
          paramString = ((com.tencent.mm.plugin.messenger.foundation.a.n)com.tencent.mm.kernel.h.ax(com.tencent.mm.plugin.messenger.foundation.a.n.class)).bzG().jaL();
          localObject2 = new LinkedList();
          localObject3 = ab.bBP();
          if ((localObject3 == null) || (((List)localObject3).size() == 0)) {}
          for (this.lDa = 0;; this.lDa = (((List)localObject2).size() - this.lDq))
          {
            this.lDn = new LinearLayoutManager();
            this.lDn.setOrientation(1);
            this.lDj.setLayoutManager(this.lDn);
            this.lDp = new ManagerRoomByWeworkUI.b(getContext(), 96.0F);
            this.lDj.a(this.lDp);
            this.lDo = new a(getContext(), this.lCU, this.lCW, this.lCT, new c()
            {
              public final void aMS()
              {
                AppMethodBeat.i(241818);
                ManagerRoomByWeworkUI.h(ManagerRoomByWeworkUI.this);
                AppMethodBeat.o(241818);
              }
            });
            this.lDj.setAdapter(this.lDo);
            this.lDj.setNestedScrollingEnabled(false);
            this.lDo.bZE.notifyChanged();
            if (this.lCU.size() != 0) {
              break label1613;
            }
            paramInt1 = 0;
            break;
            Iterator localIterator = ((List)localObject3).iterator();
            while (localIterator.hasNext())
            {
              au localau = (au)localIterator.next();
              if (!ab.IG(localau.field_username))
              {
                aj localaj;
                if (!paramString.containsKey(localau.field_username))
                {
                  if (com.tencent.mm.contact.d.rs(localau.field_type))
                  {
                    localaj = ((com.tencent.mm.plugin.chatroom.a.b)com.tencent.mm.kernel.h.ax(com.tencent.mm.plugin.chatroom.a.b.class)).bzK().Ju(localau.field_username);
                    if (localaj == null) {
                      Log.e("MicroMsg.ManagerRoomByWeworkUI", "iniOtherChatroomNum %s member is null", new Object[] { Util.nullAs(localau.field_username, "") });
                    } else if ((localaj.Jf(com.tencent.mm.model.z.bAM())) && (c(localau))) {
                      ((List)localObject2).add(localau);
                    }
                  }
                }
                else
                {
                  localaj = ((com.tencent.mm.plugin.chatroom.a.b)com.tencent.mm.kernel.h.ax(com.tencent.mm.plugin.chatroom.a.b.class)).bzK().Ju(localau.field_username);
                  if (localaj == null) {
                    Log.e("MicroMsg.ManagerRoomByWeworkUI", "iniOtherChatroomNum %s member is null", new Object[] { Util.nullAs(localau.field_username, "") });
                  } else if ((localaj.Jf(com.tencent.mm.model.z.bAM())) && (c(localau))) {
                    ((List)localObject2).add(localau);
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
    label1618:
    com.tencent.mm.ui.tools.p.a(this, (NestedScrollView)findViewById(a.e.root_view), findViewById(a.e.container_ll), findViewById(a.e.lFP), findViewById(a.e.bottom_ll));
    AppMethodBeat.o(182213);
    return;
    label1660:
    Object localObject2 = getContext();
    paramp = paramString;
    if (Util.isNullOrNil(paramString)) {
      paramp = getString(a.i.lJv);
    }
    com.tencent.mm.ui.base.aa.makeText((Context)localObject2, paramp, 0).show();
    finish();
    AppMethodBeat.o(182213);
    return;
    label1707:
    if ((paramp instanceof com.tencent.mm.chatroom.d.z))
    {
      localObject2 = (com.tencent.mm.chatroom.d.z)paramp;
      if (((com.tencent.mm.chatroom.d.z)localObject2).lyJ == null)
      {
        localObject2 = null;
        if (this.lCR != 3) {
          break label1919;
        }
        if (localObject2 == null) {
          break label1897;
        }
        this.lCX.put(((com.tencent.mm.chatroom.d.z)paramp).hMM, Boolean.TRUE);
      }
    }
    else
    {
      label1765:
      if ((this.lCR != 3) || (!(paramp instanceof com.tencent.mm.chatroom.d.z)) || (this.lCY != this.lCZ)) {
        break label2466;
      }
      Log.i("MicroMsg.ManagerRoomByWeworkUI", "NetSceneUpgradeAssociateChatRoom finish");
      paramString = new ArrayList();
      paramp = new ArrayList();
      localObject2 = this.lCX.entrySet().iterator();
    }
    for (;;)
    {
      if (!((Iterator)localObject2).hasNext()) {
        break label2318;
      }
      localObject3 = (Map.Entry)((Iterator)localObject2).next();
      if (((Boolean)((Map.Entry)localObject3).getValue()).booleanValue())
      {
        paramString.add((String)((Map.Entry)localObject3).getKey());
        continue;
        localObject2 = ((com.tencent.mm.chatroom.d.z)localObject2).lyJ;
        break;
        label1897:
        this.lCX.put(((com.tencent.mm.chatroom.d.z)paramp).hMM, Boolean.FALSE);
        break label1765;
        label1919:
        if (localObject2 != null)
        {
          d(this.lyn, this.lCR, 1, 0);
          paramString = new Intent();
          paramString.setClass(this, WeworkRoomUpgradeResultUI.class);
          paramString.putExtra("RoomInfo_Id", this.lyn);
          paramString.putExtra("popup_wording", Util.nullAs(((fsw)localObject2).abRj, ""));
          paramString.putExtra("upgrade_openim_room_from_scene", this.lCR);
          paramString = new com.tencent.mm.hellhoundlib.b.a().cG(paramString);
          com.tencent.mm.hellhoundlib.a.a.b(this, paramString.aYi(), "com/tencent/mm/chatroom/ui/ManagerRoomByWeworkUI", "onSceneEnd", "(IILjava/lang/String;Lcom/tencent/mm/modelbase/NetSceneBase;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
          startActivity((Intent)paramString.sb(0));
          com.tencent.mm.hellhoundlib.a.a.c(this, "com/tencent/mm/chatroom/ui/ManagerRoomByWeworkUI", "onSceneEnd", "(IILjava/lang/String;Lcom/tencent/mm/modelbase/NetSceneBase;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
          finish();
          super.overridePendingTransition(a.a.slide_right_in, a.a.slide_left_out);
          AppMethodBeat.o(182213);
          return;
        }
        localObject2 = getContext();
        paramp = paramString;
        if (Util.isNullOrNil(paramString)) {
          paramp = getString(a.i.lJv);
        }
        com.tencent.mm.ui.base.aa.makeText((Context)localObject2, paramp, 0).show();
        d(this.lyn, this.lCR, 2, 4);
        finish();
        AppMethodBeat.o(182213);
        return;
        label2150:
        if ((paramp instanceof com.tencent.mm.chatroom.d.n))
        {
          localObject2 = getContext();
          paramp = paramString;
          if (Util.isNullOrNil(paramString)) {
            paramp = getString(a.i.lJv);
          }
          com.tencent.mm.ui.base.aa.makeText((Context)localObject2, paramp, 0).show();
          finish();
          AppMethodBeat.o(182213);
          return;
        }
        if (!(paramp instanceof com.tencent.mm.chatroom.d.z)) {
          break label1765;
        }
        if (this.lCR == 3)
        {
          this.lCX.put(((com.tencent.mm.chatroom.d.z)paramp).hMM, Boolean.FALSE);
          break label1765;
        }
        d(this.lyn, this.lCR, 2, 4);
        localObject2 = getContext();
        paramp = paramString;
        if (Util.isNullOrNil(paramString)) {
          paramp = getString(a.i.lJv);
        }
        com.tencent.mm.ui.base.aa.makeText((Context)localObject2, paramp, 0).show();
        AppMethodBeat.o(182213);
        return;
      }
      paramp.add((String)((Map.Entry)localObject3).getKey());
    }
    label2318:
    localObject2 = new Intent();
    ((Intent)localObject2).setClass(this, WeworkRoomUpgradeResultUI.class);
    ((Intent)localObject2).putExtra("upgrade_openim_room_from_scene", this.lCR);
    ((Intent)localObject2).putExtra("wework_upgrade_success_list", paramString);
    ((Intent)localObject2).putExtra("wework_upgrade_fail_list", paramp);
    paramp = new com.tencent.mm.hellhoundlib.b.a().cG(localObject2);
    com.tencent.mm.hellhoundlib.a.a.b(this, paramp.aYi(), "com/tencent/mm/chatroom/ui/ManagerRoomByWeworkUI", "onSceneEnd", "(IILjava/lang/String;Lcom/tencent/mm/modelbase/NetSceneBase;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
    startActivity((Intent)paramp.sb(0));
    com.tencent.mm.hellhoundlib.a.a.c(this, "com/tencent/mm/chatroom/ui/ManagerRoomByWeworkUI", "onSceneEnd", "(IILjava/lang/String;Lcom/tencent/mm/modelbase/NetSceneBase;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
    finish();
    super.overridePendingTransition(a.a.slide_right_in, a.a.slide_left_out);
    l(paramString);
    label2466:
    AppMethodBeat.o(182213);
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
  
  public final void qC(int paramInt)
  {
    long l2 = 0L;
    AppMethodBeat.i(241712);
    hu localhu = new hu();
    localhu.iOY = this.lDq;
    localhu.iOZ = this.lDr;
    if (this.lDo == null)
    {
      l1 = 0L;
      localhu.iPa = l1;
      if (this.lDo != null) {
        break label127;
      }
    }
    label127:
    for (long l1 = l2;; l1 = this.lDo.lDA)
    {
      localhu.iPb = l1;
      localhu.iDn = paramInt;
      localhu.rH(Util.nullAs(this.lCS, ""));
      localhu.iPd = this.lDa;
      localhu.bMH();
      AppMethodBeat.o(241712);
      return;
      l1 = this.lDo.lDz;
      break;
    }
  }
  
  public static final class a
    extends RecyclerView.a
  {
    private Context context;
    int lDA;
    private List<au> lDu;
    private List<String> lDv;
    private HashMap<String, Boolean> lDw;
    int lDx;
    private ManagerRoomByWeworkUI.c lDy;
    int lDz;
    
    public a(Context paramContext, List<au> paramList, HashMap<String, Boolean> paramHashMap, List<String> paramList1, ManagerRoomByWeworkUI.c paramc)
    {
      AppMethodBeat.i(241737);
      this.lDx = 0;
      this.lDz = 0;
      this.lDA = 0;
      this.context = paramContext;
      this.lDu = paramList;
      this.lDw = paramHashMap;
      this.lDv = paramList1;
      this.lDy = paramc;
      paramContext = paramList.iterator();
      while (paramContext.hasNext()) {
        paramHashMap.put(((au)paramContext.next()).field_username, Boolean.FALSE);
      }
      AppMethodBeat.o(241737);
    }
    
    public final RecyclerView.v b(ViewGroup paramViewGroup, int paramInt)
    {
      AppMethodBeat.i(241764);
      paramViewGroup = new ManagerRoomByWeworkUI.d(LayoutInflater.from(paramViewGroup.getContext()).inflate(a.f.lGe, paramViewGroup, false));
      AppMethodBeat.o(241764);
      return paramViewGroup;
    }
    
    public final void d(RecyclerView.v paramv, int paramInt)
    {
      AppMethodBeat.i(241768);
      Log.d("MicroMsg.ManagerRoomByWeworkUI", "onBindViewHolder() count:%s i:%s ", new Object[] { Integer.valueOf(this.lDu.size()), Integer.valueOf(paramInt) });
      au localau;
      Boolean localBoolean;
      CheckBox localCheckBox;
      if ((this.lDu != null) && (paramInt >= 0) && (paramInt < this.lDu.size()))
      {
        paramv = (ManagerRoomByWeworkUI.d)paramv;
        localau = (au)this.lDu.get(paramInt);
        Log.d("MicroMsg.ManagerRoomByWeworkUI", "onBindViewHolder() count:%s i:%s username:%s", new Object[] { Integer.valueOf(this.lDu.size()), Integer.valueOf(paramInt), localau.field_username });
        paramv.lBX.setVisibility(0);
        ManagerRoomByWeworkUI.a(localau.field_username, paramv.lDd);
        ManagerRoomByWeworkUI.a(this.context, localau.field_username, paramv.lDF, paramv.lDG, false);
        localBoolean = (Boolean)this.lDw.get(localau.field_username);
        paramv.lDE.setEnabled(true);
        localCheckBox = paramv.lDE;
        if (localBoolean != null) {
          break label238;
        }
      }
      label238:
      for (boolean bool = false;; bool = localBoolean.booleanValue())
      {
        localCheckBox.setChecked(bool);
        paramv.lBX.setTag(localau);
        paramv.lBX.setOnClickListener(new View.OnClickListener()
        {
          public final void onClick(View paramAnonymousView)
          {
            AppMethodBeat.i(241603);
            Object localObject = new com.tencent.mm.hellhoundlib.b.b();
            ((com.tencent.mm.hellhoundlib.b.b)localObject).cH(paramAnonymousView);
            com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/chatroom/ui/ManagerRoomByWeworkUI$ChatroomAdapter$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, ((com.tencent.mm.hellhoundlib.b.b)localObject).aYj());
            paramAnonymousView = (au)paramAnonymousView.getTag();
            if (paramAnonymousView == null)
            {
              Log.e("MicroMsg.ManagerRoomByWeworkUI", "click:contact is nul");
              com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/chatroom/ui/ManagerRoomByWeworkUI$ChatroomAdapter$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
              AppMethodBeat.o(241603);
              return;
            }
            localObject = (Boolean)ManagerRoomByWeworkUI.a.a(ManagerRoomByWeworkUI.a.this).get(paramAnonymousView.field_username);
            if ((!((Boolean)localObject).booleanValue()) && (ManagerRoomByWeworkUI.a.b(ManagerRoomByWeworkUI.a.this) == 5))
            {
              com.tencent.mm.ui.base.aa.makeText(ManagerRoomByWeworkUI.a.c(ManagerRoomByWeworkUI.a.this), a.i.lJw, 0).show();
              com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/chatroom/ui/ManagerRoomByWeworkUI$ChatroomAdapter$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
              AppMethodBeat.o(241603);
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
              ManagerRoomByWeworkUI.a.this.bZE.notifyChanged();
              if (ManagerRoomByWeworkUI.a.k(ManagerRoomByWeworkUI.a.this) != null) {
                ManagerRoomByWeworkUI.a.k(ManagerRoomByWeworkUI.a.this).aMS();
              }
              com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/chatroom/ui/ManagerRoomByWeworkUI$ChatroomAdapter$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
              AppMethodBeat.o(241603);
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
        AppMethodBeat.o(241768);
        return;
      }
    }
    
    public final int getItemCount()
    {
      AppMethodBeat.i(241772);
      int i = this.lDu.size();
      AppMethodBeat.o(241772);
      return i;
    }
    
    public final int getItemViewType(int paramInt)
    {
      return 0;
    }
  }
  
  public static abstract interface c
  {
    public abstract void aMS();
  }
  
  public static final class d
    extends RecyclerView.v
  {
    View lBX;
    CheckBox lDE;
    TextView lDF;
    TextView lDG;
    CdnImageView lDd;
    
    public d(View paramView)
    {
      super();
      AppMethodBeat.i(241728);
      this.lBX = paramView;
      this.lDE = ((CheckBox)paramView.findViewById(a.e.select_cb));
      this.lDd = ((CdnImageView)paramView.findViewById(a.e.lEu));
      this.lDF = ((TextView)paramView.findViewById(a.e.lEz));
      this.lDG = ((TextView)paramView.findViewById(a.e.lEB));
      AppMethodBeat.o(241728);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.chatroom.ui.ManagerRoomByWeworkUI
 * JD-Core Version:    0.7.0.1
 */