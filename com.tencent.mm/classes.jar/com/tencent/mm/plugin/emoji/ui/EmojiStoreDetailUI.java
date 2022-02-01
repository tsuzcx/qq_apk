package com.tencent.mm.plugin.emoji.ui;

import android.app.Activity;
import android.app.ProgressDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.os.Message;
import android.support.v7.app.AppCompatActivity;
import android.text.Spannable;
import android.text.SpannableString;
import android.text.TextUtils;
import android.text.style.ForegroundColorSpan;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.Adapter;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ImageView.ScaleType;
import android.widget.LinearLayout.LayoutParams;
import android.widget.ProgressBar;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.d;
import com.tencent.mm.ak.d.c;
import com.tencent.mm.ak.i;
import com.tencent.mm.ak.t;
import com.tencent.mm.emoji.b.n;
import com.tencent.mm.g.a.dp;
import com.tencent.mm.g.b.a.as;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.emoji.e.j.1;
import com.tencent.mm.plugin.emoji.f.m;
import com.tencent.mm.plugin.emoji.f.p;
import com.tencent.mm.plugin.emoji.f.r;
import com.tencent.mm.plugin.emoji.model.EmojiLogic;
import com.tencent.mm.plugin.emoji.ui.v2.DonorsAvatarView;
import com.tencent.mm.plugin.emoji.ui.v2.EmojiStoreV2DesignerUI;
import com.tencent.mm.plugin.emoji.ui.v2.EmojiStoreV2RewardDetailUI;
import com.tencent.mm.plugin.emoji.ui.v2.EmojiStoreV2RewardUI;
import com.tencent.mm.pluginsdk.model.k.a;
import com.tencent.mm.pluginsdk.ui.emoji.BannerEmojiView;
import com.tencent.mm.protocal.protobuf.EmotionDetail;
import com.tencent.mm.protocal.protobuf.GetEmotionRewardResponse;
import com.tencent.mm.protocal.protobuf.PackThumbExt;
import com.tencent.mm.protocal.protobuf.PersonalDesigner;
import com.tencent.mm.protocal.protobuf.ait;
import com.tencent.mm.protocal.protobuf.ajg;
import com.tencent.mm.protocal.protobuf.bms;
import com.tencent.mm.protocal.protobuf.dqi;
import com.tencent.mm.sdk.event.EventCenter;
import com.tencent.mm.sdk.event.IListener;
import com.tencent.mm.sdk.platformtools.LocaleUtil;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMHandler;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.sdk.platformtools.WeChatBrands.Business.Entries;
import com.tencent.mm.sdk.storage.MStorage.IOnStorageChange;
import com.tencent.mm.sdk.storage.MStorageEventData;
import com.tencent.mm.storage.bj;
import com.tencent.mm.storage.emotion.EmojiGroupInfo;
import com.tencent.mm.storage.emotion.EmojiInfo;
import com.tencent.mm.storage.emotion.o;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.MMAutoSizeTextView;
import com.tencent.mm.ui.base.o.g;
import com.tencent.mm.view.SmileySubGrid;
import java.lang.ref.WeakReference;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.LinkedList;

public class EmojiStoreDetailUI
  extends MMActivity
  implements View.OnClickListener, i, MStorage.IOnStorageChange
{
  private static d riu;
  private View GQ;
  private int HH;
  private ProgressDialog jZH;
  private Context mContext;
  private MMHandler mHandler;
  private int mNumColumns;
  private int mPadding;
  private ProgressBar qWX;
  private long rbH;
  private String rbI;
  private com.tencent.mm.plugin.emoji.h.c rbL;
  private as rbN;
  private String rcD;
  private String rcE;
  private String rcF;
  private EmotionDetail reN;
  private String reO;
  private int reu;
  private IListener rey;
  private TextView rhA;
  private MMAutoSizeTextView rhB;
  private TextView rhC;
  private TextView rhD;
  private TextView rhE;
  private EmojiDetailGridView rhF;
  private ImageView rhG;
  private View rhH;
  private TextView rhI;
  private TextView rhJ;
  private View rhK;
  private int rhL;
  private View rhM;
  private ProgressBar rhN;
  private View rhO;
  private ImageView rhP;
  private TextView rhQ;
  private View rhR;
  private View rhS;
  private TextView rhT;
  private Button rhU;
  private DonorsAvatarView rhV;
  private TextView rhW;
  private int rhX;
  private int rhY;
  private int rhZ;
  private int rhl;
  private String rhm;
  private boolean rhn;
  private boolean rho;
  private int rhp;
  private m rhq;
  private com.tencent.mm.plugin.emoji.f.h rhr;
  private p rhs;
  private a rht;
  private GetEmotionRewardResponse rhu;
  private boolean rhv;
  private TextView rhw;
  private View rhx;
  private EmojiDetailScrollView rhy;
  private BannerEmojiView rhz;
  private String ria;
  private boolean rib;
  private int ric;
  private int rid;
  private String rie;
  private String rif;
  private String rig;
  private String[] rih;
  private boolean rii;
  private View rij;
  private boolean rik;
  private bms ril;
  private boolean rim;
  private boolean rin;
  private boolean rio;
  private com.tencent.mm.ui.base.q rip;
  private View.OnClickListener riq;
  private View.OnClickListener rir;
  private View.OnClickListener ris;
  private View.OnClickListener rit;
  private com.tencent.mm.av.a.c.l riv;
  private k.a riw;
  
  static
  {
    AppMethodBeat.i(176199);
    riu = new d((byte)0);
    AppMethodBeat.o(176199);
  }
  
  public EmojiStoreDetailUI()
  {
    AppMethodBeat.i(109009);
    this.rho = false;
    this.rhp = -1;
    this.reN = new EmotionDetail();
    this.reO = "";
    this.rhu = null;
    this.rbH = 0L;
    this.rbI = "";
    this.rid = -1;
    this.rih = new String[1];
    this.rii = false;
    this.rik = true;
    this.rim = false;
    this.rin = true;
    this.rio = false;
    this.rey = new IListener() {};
    this.riq = new EmojiStoreDetailUI.12(this);
    this.rir = new EmojiStoreDetailUI.15(this);
    this.ris = new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(108994);
        Object localObject = new com.tencent.mm.hellhoundlib.b.b();
        ((com.tencent.mm.hellhoundlib.b.b)localObject).bm(paramAnonymousView);
        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/emoji/ui/EmojiStoreDetailUI$4", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, ((com.tencent.mm.hellhoundlib.b.b)localObject).axR());
        localObject = new Intent();
        ((Intent)localObject).setClass(EmojiStoreDetailUI.this, EmojiStoreV2RewardUI.class);
        ((Intent)localObject).putExtra("extra_id", EmojiStoreDetailUI.a(EmojiStoreDetailUI.this));
        ((Intent)localObject).putExtra("extra_name", EmojiStoreDetailUI.b(EmojiStoreDetailUI.this).PackName);
        if ((EmojiStoreDetailUI.b(EmojiStoreDetailUI.this) != null) && (EmojiStoreDetailUI.b(EmojiStoreDetailUI.this).PersonalDesigner != null)) {
          ((Intent)localObject).putExtra("name", EmojiStoreDetailUI.b(EmojiStoreDetailUI.this).PersonalDesigner.Name);
        }
        ((Intent)localObject).putExtra("scene", EmojiStoreDetailUI.c(EmojiStoreDetailUI.this));
        ((Intent)localObject).putExtra("pageType", 1);
        ((Intent)localObject).putExtra("searchID", EmojiStoreDetailUI.d(EmojiStoreDetailUI.this));
        paramAnonymousView = EmojiStoreDetailUI.this;
        localObject = new com.tencent.mm.hellhoundlib.b.a().bl(localObject);
        com.tencent.mm.hellhoundlib.a.a.a(paramAnonymousView, ((com.tencent.mm.hellhoundlib.b.a)localObject).axQ(), "com/tencent/mm/plugin/emoji/ui/EmojiStoreDetailUI$4", "onClick", "(Landroid/view/View;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
        paramAnonymousView.startActivity((Intent)((com.tencent.mm.hellhoundlib.b.a)localObject).pG(0));
        com.tencent.mm.hellhoundlib.a.a.a(paramAnonymousView, "com/tencent/mm/plugin/emoji/ui/EmojiStoreDetailUI$4", "onClick", "(Landroid/view/View;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
        com.tencent.mm.plugin.report.service.h.CyF.a(12738, new Object[] { EmojiStoreDetailUI.a(EmojiStoreDetailUI.this), Integer.valueOf(1), Integer.valueOf(EmojiStoreDetailUI.c(EmojiStoreDetailUI.this)), Integer.valueOf(0) });
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/emoji/ui/EmojiStoreDetailUI$4", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(108994);
      }
    };
    this.rit = new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(108995);
        Object localObject = new com.tencent.mm.hellhoundlib.b.b();
        ((com.tencent.mm.hellhoundlib.b.b)localObject).bm(paramAnonymousView);
        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/emoji/ui/EmojiStoreDetailUI$5", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, ((com.tencent.mm.hellhoundlib.b.b)localObject).axR());
        localObject = new Intent();
        ((Intent)localObject).setClass(EmojiStoreDetailUI.this, EmojiStoreV2RewardDetailUI.class);
        ((Intent)localObject).putExtra("extra_id", EmojiStoreDetailUI.a(EmojiStoreDetailUI.this));
        ((Intent)localObject).putExtra("extra_iconurl", EmojiStoreDetailUI.b(EmojiStoreDetailUI.this).IconUrl);
        ((Intent)localObject).putExtra("extra_name", EmojiStoreDetailUI.b(EmojiStoreDetailUI.this).PackName);
        if (EmojiStoreDetailUI.b(EmojiStoreDetailUI.this).PersonalDesigner != null) {
          ((Intent)localObject).putExtra("name", EmojiStoreDetailUI.b(EmojiStoreDetailUI.this).PersonalDesigner.Name);
        }
        paramAnonymousView = EmojiStoreDetailUI.this;
        localObject = new com.tencent.mm.hellhoundlib.b.a().bl(localObject);
        com.tencent.mm.hellhoundlib.a.a.a(paramAnonymousView, ((com.tencent.mm.hellhoundlib.b.a)localObject).axQ(), "com/tencent/mm/plugin/emoji/ui/EmojiStoreDetailUI$5", "onClick", "(Landroid/view/View;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
        paramAnonymousView.startActivity((Intent)((com.tencent.mm.hellhoundlib.b.a)localObject).pG(0));
        com.tencent.mm.hellhoundlib.a.a.a(paramAnonymousView, "com/tencent/mm/plugin/emoji/ui/EmojiStoreDetailUI$5", "onClick", "(Landroid/view/View;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/emoji/ui/EmojiStoreDetailUI$5", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(108995);
      }
    };
    this.mHandler = new MMHandler()
    {
      public final void handleMessage(Message paramAnonymousMessage)
      {
        AppMethodBeat.i(108996);
        switch (paramAnonymousMessage.what)
        {
        default: 
          Log.w("MicroMsg.emoji.EmojiStoreDetailUI", "unknow message, cannt handle.");
          AppMethodBeat.o(108996);
          return;
        case 1001: 
          EmojiStoreDetailUI.e(EmojiStoreDetailUI.this);
          AppMethodBeat.o(108996);
          return;
        case 1002: 
          EmojiStoreDetailUI.f(EmojiStoreDetailUI.this);
          AppMethodBeat.o(108996);
          return;
        case 1003: 
          EmojiStoreDetailUI.g(EmojiStoreDetailUI.this);
          AppMethodBeat.o(108996);
          return;
        case 1004: 
          if (EmojiStoreDetailUI.h(EmojiStoreDetailUI.this).getVisibility() == 0)
          {
            EmojiStoreDetailUI.h(EmojiStoreDetailUI.this).setVisibility(8);
            EmojiStoreDetailUI.i(EmojiStoreDetailUI.this).setVisibility(0);
            EmojiStoreDetailUI.j(EmojiStoreDetailUI.this).setVisibility(0);
          }
          EmojiStoreDetailUI.l(EmojiStoreDetailUI.this).setProgress(EmojiStoreDetailUI.k(EmojiStoreDetailUI.this));
          AppMethodBeat.o(108996);
          return;
        case 1005: 
          EmojiStoreDetailUI.m(EmojiStoreDetailUI.this).scrollTo(0, 0);
          AppMethodBeat.o(108996);
          return;
        case 1006: 
          EmojiStoreDetailUI.n(EmojiStoreDetailUI.this);
          AppMethodBeat.o(108996);
          return;
        }
        EmojiStoreDetailUI.this.cHC();
        AppMethodBeat.o(108996);
      }
    };
    this.riv = new com.tencent.mm.av.a.c.l()
    {
      public final void AC(long paramAnonymousLong)
      {
        AppMethodBeat.i(176192);
        com.tencent.mm.plugin.report.service.h.CyF.kvStat(10930, EmojiStoreDetailUI.a(EmojiStoreDetailUI.this) + "," + paramAnonymousLong);
        AppMethodBeat.o(176192);
      }
    };
    this.riw = new k.a()
    {
      public final void Y(ArrayList<com.tencent.mm.pluginsdk.model.q> paramAnonymousArrayList)
      {
        AppMethodBeat.i(176191);
        int i;
        if (paramAnonymousArrayList == null)
        {
          i = 0;
          Log.i("MicroMsg.emoji.EmojiStoreDetailUI", "[onQueryFinish] %s", new Object[] { Integer.valueOf(i) });
          EmojiStoreDetailUI.B(EmojiStoreDetailUI.this);
          if ((paramAnonymousArrayList != null) && (paramAnonymousArrayList.size() > 0))
          {
            paramAnonymousArrayList = (com.tencent.mm.pluginsdk.model.q)paramAnonymousArrayList.get(0);
            Log.i("MicroMsg.emoji.EmojiStoreDetailUI", "onQueryFinish: %s", new Object[] { paramAnonymousArrayList });
            if (paramAnonymousArrayList.JVq != 10232) {
              break label175;
            }
            EmojiStoreDetailUI.a(EmojiStoreDetailUI.this, 4);
            EmojiStoreDetailUI.a(EmojiStoreDetailUI.this, paramAnonymousArrayList.JVn);
            EmojiStoreDetailUI.b(EmojiStoreDetailUI.this, paramAnonymousArrayList.JVo);
            paramAnonymousArrayList = new BigDecimal(paramAnonymousArrayList.JVp).divide(new BigDecimal(1000000));
            EmojiStoreDetailUI.c(EmojiStoreDetailUI.this, paramAnonymousArrayList.toString());
          }
        }
        for (;;)
        {
          EmojiStoreDetailUI.this.Ga(1002);
          AppMethodBeat.o(176191);
          return;
          i = paramAnonymousArrayList.size();
          break;
          label175:
          EmojiStoreDetailUI.a(EmojiStoreDetailUI.this, 10);
          EmojiStoreDetailUI.b(EmojiStoreDetailUI.this, paramAnonymousArrayList.JVq);
        }
      }
    };
    AppMethodBeat.o(109009);
  }
  
  private void amQ(String paramString)
  {
    AppMethodBeat.i(109025);
    String str = paramString;
    if (TextUtils.isEmpty(paramString)) {
      str = getString(2131758575);
    }
    com.tencent.mm.ui.base.h.d(this, str, "", new DialogInterface.OnClickListener()
    {
      public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt) {}
    });
    AppMethodBeat.o(109025);
  }
  
  private void cHA()
  {
    AppMethodBeat.i(109029);
    if (!Util.isNullOrNil(this.reN.PackName))
    {
      setMMTitle(this.reN.PackName);
      this.rcE = this.reN.PackName;
    }
    Log.d("MicroMsg.emoji.EmojiStoreDetailUI", "mData.PanelUrl:%s", new Object[] { this.reN.PanelUrl });
    this.rhx.setVisibility(0);
    this.GQ.setVisibility(8);
    lt(true);
    this.rhB.setText(this.reN.PackName);
    this.rhC.setText(this.reN.PackCopyright);
    this.rhE.setText(this.reN.PackDesc);
    if (com.tencent.mm.plugin.emoji.a.a.e.fA(this.reN.PackType, 1)) {
      this.rhA.setVisibility(8);
    }
    for (;;)
    {
      cHE();
      cHF();
      cHG();
      cHH();
      cHI();
      this.rhB.setMaxWidth(this.rhL - this.rhM.getWidth() - com.tencent.mm.cb.a.aG(getContext(), 2131165534) * 2 - this.rhA.getWidth() - com.tencent.mm.cb.a.aG(getContext(), 2131165507) * 2);
      this.rhB.setVisibility(8);
      this.rhB.setVisibility(0);
      cHB();
      cHD();
      cHC();
      AppMethodBeat.o(109029);
      return;
      this.rhA.setVisibility(0);
      this.rhA.setText(2131758705);
    }
  }
  
  private void cHB()
  {
    AppMethodBeat.i(109031);
    if ((this.reN.PersonalDesigner != null) && (this.reN.PersonalDesigner.DesignerUin != 0) && (this.rhZ != 6))
    {
      this.rhR.setVisibility(0);
      this.rhO.setVisibility(0);
      com.tencent.mm.av.q.bcV().a(this.reN.PersonalDesigner.HeadUrl, this.rhP, com.tencent.mm.plugin.emoji.e.e.fR(this.rcD, this.reN.PersonalDesigner.HeadUrl));
      this.rhQ.setText(this.reN.PersonalDesigner.Name);
      this.rhO.setOnClickListener(new View.OnClickListener()
      {
        public final void onClick(View paramAnonymousView)
        {
          AppMethodBeat.i(176185);
          Object localObject = new com.tencent.mm.hellhoundlib.b.b();
          ((com.tencent.mm.hellhoundlib.b.b)localObject).bm(paramAnonymousView);
          com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/emoji/ui/EmojiStoreDetailUI$13", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, ((com.tencent.mm.hellhoundlib.b.b)localObject).axR());
          localObject = new Intent();
          ((Intent)localObject).setClass(EmojiStoreDetailUI.this.getContext(), EmojiStoreV2DesignerUI.class);
          ((Intent)localObject).putExtra("uin", EmojiStoreDetailUI.b(EmojiStoreDetailUI.this).PersonalDesigner.DesignerUin);
          ((Intent)localObject).putExtra("name", EmojiStoreDetailUI.b(EmojiStoreDetailUI.this).PersonalDesigner.Name);
          ((Intent)localObject).putExtra("headurl", EmojiStoreDetailUI.b(EmojiStoreDetailUI.this).PersonalDesigner.HeadUrl);
          ((Intent)localObject).putExtra("rediret_url", EmojiStoreDetailUI.b(EmojiStoreDetailUI.this).OldRedirectUrl);
          ((Intent)localObject).putExtra("searchID", EmojiStoreDetailUI.d(EmojiStoreDetailUI.this));
          ((Intent)localObject).putExtra("extra_scence", 26);
          paramAnonymousView = EmojiStoreDetailUI.this.getContext();
          localObject = new com.tencent.mm.hellhoundlib.b.a().bl(localObject);
          com.tencent.mm.hellhoundlib.a.a.a(paramAnonymousView, ((com.tencent.mm.hellhoundlib.b.a)localObject).axQ(), "com/tencent/mm/plugin/emoji/ui/EmojiStoreDetailUI$13", "onClick", "(Landroid/view/View;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
          paramAnonymousView.startActivity((Intent)((com.tencent.mm.hellhoundlib.b.a)localObject).pG(0));
          com.tencent.mm.hellhoundlib.a.a.a(paramAnonymousView, "com/tencent/mm/plugin/emoji/ui/EmojiStoreDetailUI$13", "onClick", "(Landroid/view/View;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/emoji/ui/EmojiStoreDetailUI$13", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
          AppMethodBeat.o(176185);
        }
      });
      AppMethodBeat.o(109031);
      return;
    }
    this.rhR.setVisibility(8);
    this.rhO.setVisibility(8);
    AppMethodBeat.o(109031);
  }
  
  private void cHD()
  {
    AppMethodBeat.i(109033);
    if ((this.reN.PackFlag & 0x20) == 32)
    {
      localLayoutParams1 = (LinearLayout.LayoutParams)this.rhJ.getLayoutParams();
      LinearLayout.LayoutParams localLayoutParams2 = (LinearLayout.LayoutParams)this.rhI.getLayoutParams();
      this.rhJ.setVisibility(0);
      localLayoutParams1.weight = 1.0F;
      localLayoutParams1.gravity = 3;
      localLayoutParams1.leftMargin = com.tencent.mm.cb.a.aG(getContext(), 2131165534);
      this.rhJ.setLayoutParams(localLayoutParams1);
      this.rhJ.setGravity(3);
      localLayoutParams2.weight = 1.0F;
      localLayoutParams2.gravity = 5;
      localLayoutParams2.rightMargin = com.tencent.mm.cb.a.aG(getContext(), 2131165534);
      this.rhI.setLayoutParams(localLayoutParams2);
      this.rhI.setGravity(5);
      AppMethodBeat.o(109033);
      return;
    }
    LinearLayout.LayoutParams localLayoutParams1 = (LinearLayout.LayoutParams)this.rhI.getLayoutParams();
    localLayoutParams1.gravity = 17;
    this.rhI.setLayoutParams(localLayoutParams1);
    this.rhI.setGravity(17);
    this.rhJ.setVisibility(8);
    AppMethodBeat.o(109033);
  }
  
  private void cHE()
  {
    AppMethodBeat.i(109034);
    if (com.tencent.mm.plugin.emoji.a.a.e.fA(this.reN.PackType, 8))
    {
      this.rhY = 0;
      Log.i("MicroMsg.emoji.EmojiStoreDetailUI", "PackFlag:%d", new Object[] { Integer.valueOf(this.reN.PackFlag) });
      if ((!com.tencent.mm.plugin.emoji.a.a.e.fA(this.reN.PackFlag, 8)) || (!com.tencent.mm.plugin.emoji.a.a.e.FT(this.reN.PackType))) {
        break label164;
      }
      this.rhp = 8;
    }
    for (;;)
    {
      if (this.rhv) {
        this.rhp = 7;
      }
      AppMethodBeat.o(109034);
      return;
      if (com.tencent.mm.plugin.emoji.a.a.e.fA(this.reN.PackType, 4))
      {
        this.rhY = 0;
        break;
      }
      if ((!this.rib) && (TextUtils.isEmpty(this.reN.PackPrice)))
      {
        this.rhY = 0;
        break;
      }
      this.rhY = 1;
      break;
      label164:
      if ((com.tencent.mm.plugin.emoji.a.a.e.fA(this.reN.PackFlag, 1)) || (com.tencent.mm.plugin.emoji.a.a.e.fA(this.reN.PackType, 8))) {
        this.rhp = 3;
      } else if (com.tencent.mm.plugin.emoji.a.a.e.FT(this.reN.PackType)) {
        this.rhp = 0;
      } else if ((!this.rib) && ((TextUtils.isEmpty(this.reN.PriceNum)) || (this.reN.PriceNum.equals("0")))) {
        this.rhp = 0;
      } else if (this.rib)
      {
        if (TextUtils.isEmpty(this.rie)) {
          this.rhp = this.ric;
        } else {
          this.rhp = 4;
        }
      }
      else {
        this.rhp = 4;
      }
    }
  }
  
  private void cHF()
  {
    AppMethodBeat.i(109035);
    if (com.tencent.mm.plugin.emoji.h.a.ang(this.rcD)) {
      cHz();
    }
    switch (this.rhp)
    {
    case 1: 
    case 2: 
    case 9: 
    default: 
      Log.w("MicroMsg.emoji.EmojiStoreDetailUI", "unknow product status:%d", new Object[] { Integer.valueOf(this.rhp) });
    }
    for (;;)
    {
      cHG();
      AppMethodBeat.o(109035);
      return;
      this.rhN.setVisibility(8);
      this.rhD.setTextColor(getResources().getColorStateList(2131100306));
      this.rhD.setBackgroundResource(2131231436);
      this.rhD.setText(2131758616);
      this.rhD.setEnabled(false);
      continue;
      this.rhN.setVisibility(8);
      this.rhD.setTextColor(getResources().getColorStateList(2131101430));
      this.rhD.setBackgroundResource(2131231429);
      this.rhD.setText(2131758613);
      this.rhD.setEnabled(true);
      continue;
      this.rhN.setVisibility(8);
      this.rhD.setTextColor(getResources().getColorStateList(2131101430));
      this.rhD.setBackgroundResource(2131231429);
      this.rhD.setEnabled(true);
      if (this.rib)
      {
        if (Util.isNullOrNil(this.rie)) {
          this.rhD.setText("");
        } else {
          this.rhD.setText(this.rie);
        }
      }
      else
      {
        this.rhD.setText(this.reN.PackPrice);
        this.rhp = 4;
        continue;
        this.rhN.setVisibility(8);
        this.rhD.setTextColor(getResources().getColorStateList(2131101430));
        this.rhD.setBackgroundResource(2131231429);
        this.rhD.setText(2131758613);
        this.rhD.setEnabled(true);
        continue;
        this.rhN.setVisibility(8);
        this.rhD.setEnabled(false);
        this.rhH.setVisibility(0);
        this.rhG.setVisibility(0);
        this.rhD.setVisibility(4);
        if (this.rhl != 3)
        {
          continue;
          this.rhN.setVisibility(8);
          this.rhD.setVisibility(0);
          this.rhD.setEnabled(true);
          if (this.rio)
          {
            this.rhD.setText(2131758580);
            this.rhD.setTextColor(getResources().getColorStateList(2131100569));
            this.rhD.setBackgroundResource(2131231431);
          }
          for (;;)
          {
            this.rhH.setVisibility(8);
            this.qWX.setProgress(0);
            this.rhG.setVisibility(4);
            if (this.rhl == 3) {
              break;
            }
            break;
            this.rhD.setTextColor(getResources().getColorStateList(2131101430));
            this.rhD.setText(2131758682);
            this.rhD.setBackgroundResource(2131231429);
          }
          this.rhN.setVisibility(8);
          this.rhD.setBackgroundResource(2131231429);
          this.rhD.setText(2131758613);
          this.rhD.setEnabled(true);
          this.rhN.setVisibility(0);
          this.rhD.setVisibility(0);
          this.rhD.setBackgroundResource(2131235775);
          this.rhD.setText("");
          this.rhD.setEnabled(false);
          this.rhH.setVisibility(8);
          this.qWX.setProgress(0);
          this.rhG.setVisibility(4);
          continue;
          this.rhN.setVisibility(8);
          this.rhD.setVisibility(0);
          this.rhD.setBackgroundResource(2131231429);
          this.rhD.setText(2131758637);
          this.rhD.setEnabled(true);
          this.rhH.setVisibility(8);
          this.qWX.setProgress(0);
          this.rhG.setVisibility(4);
          continue;
          cHE();
          cHF();
        }
      }
    }
  }
  
  private void cHG()
  {
    AppMethodBeat.i(109036);
    if ((this.rim) && ((this.ril == null) || ((this.ril.LVu & 0x1) != 1)) && ((this.reN == null) || (!com.tencent.mm.plugin.emoji.a.a.e.fA(this.reN.PackFlag, 1))) && (this.ril != null) && (!TextUtils.isEmpty(this.ril.LVt)))
    {
      this.rhD.setText(this.ril.LVt);
      this.rhD.setTextColor(getContext().getResources().getColor(2131100584));
      this.rhD.setBackgroundDrawable(null);
      this.rhD.setEnabled(false);
    }
    AppMethodBeat.o(109036);
  }
  
  private void cHH()
  {
    AppMethodBeat.i(109037);
    if ((!com.tencent.mm.plugin.emoji.h.a.ang(this.rcD)) && ((this.reN.ThumbExtList == null) || (this.reN.ThumbExtList.size() <= 0) || (((PackThumbExt)this.reN.ThumbExtList.get(0)).PreviewUrl == null))) {
      this.rij.setVisibility(8);
    }
    for (;;)
    {
      this.rhF.setProductId(this.rcD);
      if (this.rht != null) {
        this.rht.notifyDataSetInvalidated();
      }
      AppMethodBeat.o(109037);
      return;
      this.rij.setVisibility(0);
    }
  }
  
  private void cHI()
  {
    AppMethodBeat.i(109038);
    Log.d("MicroMsg.emoji.EmojiStoreDetailUI", "mData.PackFlag:%s", new Object[] { this.reN.PackFlag });
    if ((this.reN.PackFlag & 0x10) == 16) {
      addIconOptionMenu(0, 2131690907, new MenuItem.OnMenuItemClickListener()
      {
        public final boolean onMenuItemClick(MenuItem paramAnonymousMenuItem)
        {
          AppMethodBeat.i(176186);
          Log.d("MicroMsg.emoji.EmojiStoreDetailUI", "on shard click.");
          EmojiStoreDetailUI.r(EmojiStoreDetailUI.this);
          AppMethodBeat.o(176186);
          return true;
        }
      });
    }
    AppMethodBeat.o(109038);
  }
  
  private void cHJ()
  {
    AppMethodBeat.i(109039);
    com.tencent.mm.ui.base.h.a(this, 2131758605, 0, 2131758670, 2131758608, new DialogInterface.OnClickListener()new DialogInterface.OnClickListener
    {
      public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
      {
        AppMethodBeat.i(176187);
        if (com.tencent.mm.plugin.emoji.h.a.ang(EmojiStoreDetailUI.a(EmojiStoreDetailUI.this)))
        {
          Log.d("MicroMsg.emoji.EmojiStoreDetailUI", "jacks stop tuzi downloading");
          com.tencent.mm.plugin.emoji.f.a.cGm().cGo();
          if (!TextUtils.isEmpty(EmojiStoreDetailUI.t(EmojiStoreDetailUI.this)))
          {
            com.tencent.mm.an.f.baQ().Oc(EmojiStoreDetailUI.t(EmojiStoreDetailUI.this));
            Log.i("MicroMsg.emoji.EmojiStoreDetailUI", "[onClickClose] cancel RecvTask. CdnClientId:%s", new Object[] { EmojiStoreDetailUI.t(EmojiStoreDetailUI.this) });
          }
          if ((!com.tencent.mm.plugin.emoji.a.a.e.fA(EmojiStoreDetailUI.b(EmojiStoreDetailUI.this).PackFlag, 1)) && (!com.tencent.mm.plugin.emoji.a.a.e.FT(EmojiStoreDetailUI.b(EmojiStoreDetailUI.this).PackType))) {
            break label262;
          }
          EmojiStoreDetailUI.a(EmojiStoreDetailUI.this, 3);
        }
        for (;;)
        {
          com.tencent.mm.plugin.emoji.model.k.cGk().h(EmojiStoreDetailUI.a(EmojiStoreDetailUI.this), EmojiStoreDetailUI.u(EmojiStoreDetailUI.this), 0, EmojiStoreDetailUI.t(EmojiStoreDetailUI.this));
          EmojiStoreDetailUI.i(EmojiStoreDetailUI.this).setVisibility(8);
          EmojiStoreDetailUI.l(EmojiStoreDetailUI.this).setProgress(0);
          EmojiStoreDetailUI.j(EmojiStoreDetailUI.this).setVisibility(4);
          EmojiStoreDetailUI.h(EmojiStoreDetailUI.this).setVisibility(0);
          EmojiStoreDetailUI.v(EmojiStoreDetailUI.this);
          EmojiStoreDetailUI.g(EmojiStoreDetailUI.this);
          paramAnonymousDialogInterface = new r(EmojiStoreDetailUI.a(EmojiStoreDetailUI.this), 2);
          g.aAg().hqi.a(paramAnonymousDialogInterface, 0);
          AppMethodBeat.o(176187);
          return;
          g.aAg().hqi.a(EmojiStoreDetailUI.s(EmojiStoreDetailUI.this));
          break;
          label262:
          EmojiStoreDetailUI.a(EmojiStoreDetailUI.this, -1);
        }
      }
    }, new DialogInterface.OnClickListener()
    {
      public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
      {
        AppMethodBeat.i(108987);
        AppMethodBeat.o(108987);
      }
    });
    AppMethodBeat.o(109039);
  }
  
  private void cHK()
  {
    AppMethodBeat.i(109041);
    if (com.tencent.mm.plugin.emoji.h.a.ang(this.rcD))
    {
      com.tencent.mm.plugin.emoji.f.a.cGm();
      com.tencent.mm.plugin.emoji.f.a.cGn();
      AppMethodBeat.o(109041);
      return;
    }
    this.rhr = new com.tencent.mm.plugin.emoji.f.h(this.rcD, this.rcF, this.rcE);
    g.aAg().hqi.a(this.rhr, 0);
    switch (this.reu)
    {
    }
    for (;;)
    {
      AppMethodBeat.o(109041);
      return;
      com.tencent.mm.plugin.report.service.h.CyF.a(11598, new Object[] { Integer.valueOf(1), this.rcD });
      AppMethodBeat.o(109041);
      return;
      com.tencent.mm.plugin.report.service.h.CyF.a(11598, new Object[] { Integer.valueOf(3), this.rcD });
      AppMethodBeat.o(109041);
      return;
      com.tencent.mm.plugin.report.service.h.CyF.a(11598, new Object[] { Integer.valueOf(2), this.rcD });
    }
  }
  
  private void cHv()
  {
    AppMethodBeat.i(109021);
    this.GQ.setVisibility(0);
    this.rhx.setVisibility(8);
    this.rhy.setVisibility(8);
    this.rhw.setText(2131758557);
    AppMethodBeat.o(109021);
  }
  
  private void cHw()
  {
    AppMethodBeat.i(109022);
    Log.i("MicroMsg.emoji.EmojiStoreDetailUI", "[handleLoadDataFailed]");
    if ((this.reN == null) || (this.reN.PackFlag == 0))
    {
      this.GQ.setVisibility(0);
      this.rhx.setVisibility(8);
    }
    AppMethodBeat.o(109022);
  }
  
  private void cHx()
  {
    AppMethodBeat.i(109026);
    this.rhu = com.tencent.mm.plugin.emoji.model.k.getEmojiStorageMgr().OpS.blu(this.rcD);
    AppMethodBeat.o(109026);
  }
  
  private void cHy()
  {
    AppMethodBeat.i(109027);
    if ((com.tencent.mm.plugin.emoji.a.a.e.fA(this.reN.PackFlag, 64)) && (n.auV()))
    {
      this.rhs = new p(this.rcD, p.rde);
      g.aAg().hqi.a(this.rhs, 0);
    }
    AppMethodBeat.o(109027);
  }
  
  private boolean cHz()
  {
    AppMethodBeat.i(109028);
    boolean bool = com.tencent.mm.plugin.emoji.h.a.cHz();
    this.rhv = bool;
    if (bool) {}
    for (int i = 7;; i = 3)
    {
      this.rhp = i;
      AppMethodBeat.o(109028);
      return bool;
    }
  }
  
  private void lt(boolean paramBoolean)
  {
    AppMethodBeat.i(109030);
    Object localObject = null;
    String str;
    if (!Util.isNullOrNil(this.reN.CoverUrl))
    {
      if (!paramBoolean) {
        break label104;
      }
      localObject = this.rcD;
      str = this.reN.CoverUrl;
      com.tencent.mm.cb.a.getDensity(this.mContext);
    }
    for (localObject = EmojiLogic.a((String)localObject, str, riu);; localObject = EmojiLogic.H((String)localObject, 4, str))
    {
      if ((localObject != null) && (this.rhz != null)) {
        this.rhz.setImageFilePath(((EmojiInfo)localObject).hRM());
      }
      if (com.tencent.mm.plugin.emoji.h.a.ang(this.rcD)) {
        this.rhz.setImageResource(2131235363);
      }
      AppMethodBeat.o(109030);
      return;
      label104:
      localObject = this.rcD;
      str = this.reN.CoverUrl;
      com.tencent.mm.cb.a.getDensity(this.mContext);
    }
  }
  
  public final void Ga(int paramInt)
  {
    AppMethodBeat.i(109042);
    if (this.mHandler != null) {
      this.mHandler.sendEmptyMessage(paramInt);
    }
    AppMethodBeat.o(109042);
  }
  
  public final void cHC()
  {
    AppMethodBeat.i(109032);
    if ((com.tencent.mm.plugin.emoji.a.a.e.fA(this.reN.PackFlag, 64)) && (n.auV()))
    {
      if (this.rhu != null)
      {
        this.rhS.setVisibility(0);
        this.rhU.setText(2131758646);
        this.rhT.setText(this.rhu.Reward.LsK);
        this.rhT.setLongClickable(false);
        if (this.rhu.DonorNum > 0)
        {
          this.rhW.setVisibility(0);
          String str1 = String.valueOf(this.rhu.DonorNum);
          String str2 = String.format(getString(2131758650), new Object[] { Integer.valueOf(this.rhu.DonorNum) });
          SpannableString localSpannableString = new SpannableString(str2);
          int i = str2.indexOf(str1);
          if (i >= 0) {
            localSpannableString.setSpan(new ForegroundColorSpan(getResources().getColor(2131100320)), i, str1.length() + i, 33);
          }
          this.rhW.setText(localSpannableString);
        }
        while ((this.rhu.Donors != null) && (this.rhu.Donors.size() > 0))
        {
          this.rhV.setVisibility(0);
          this.rhV.d(this.rcD, this.rhu.Donors);
          AppMethodBeat.o(109032);
          return;
          this.rhW.setVisibility(8);
        }
        this.rhV.setVisibility(8);
        AppMethodBeat.o(109032);
        return;
      }
      this.rhS.setVisibility(8);
      cHy();
      AppMethodBeat.o(109032);
      return;
    }
    this.rhS.setVisibility(8);
    AppMethodBeat.o(109032);
  }
  
  public int getForceOrientation()
  {
    return 1;
  }
  
  public int getLayoutId()
  {
    return 2131493948;
  }
  
  public final void i(String paramString1, int paramInt1, int paramInt2, String paramString2)
  {
    AppMethodBeat.i(109040);
    Log.d("MicroMsg.emoji.EmojiStoreDetailUI", "productId:%s,status:%d, progress:%d, cdnClientID:%s, ", new Object[] { paramString1, Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), paramString2 });
    if ((Util.isNullOrNil(paramString1)) || (!paramString1.equals(this.rcD)))
    {
      AppMethodBeat.o(109040);
      return;
    }
    if (!TextUtils.isEmpty(paramString2)) {
      this.ria = paramString2;
    }
    if (paramInt1 == -1)
    {
      if (this.rhp != -1)
      {
        this.rhp = -1;
        Ga(1003);
        AppMethodBeat.o(109040);
      }
    }
    else
    {
      if (paramInt1 == 7)
      {
        this.rhp = 7;
        Ga(1003);
        AppMethodBeat.o(109040);
        return;
      }
      if (paramInt1 == 6)
      {
        if ((!TextUtils.isEmpty(paramString1)) && (paramString1.equals(this.rcD)))
        {
          this.rhp = 6;
          this.HH = paramInt2;
          Ga(1004);
          AppMethodBeat.o(109040);
        }
      }
      else {
        Log.w("MicroMsg.emoji.EmojiStoreDetailUI", "[onExchange] do nothing.");
      }
    }
    AppMethodBeat.o(109040);
  }
  
  public void initView()
  {
    AppMethodBeat.i(109011);
    if (!Util.isNullOrNil(this.rcE)) {
      setMMTitle(this.rcE);
    }
    setBackBtn(new MenuItem.OnMenuItemClickListener()
    {
      public final boolean onMenuItemClick(MenuItem paramAnonymousMenuItem)
      {
        AppMethodBeat.i(176194);
        EmojiStoreDetailUI.this.finish();
        AppMethodBeat.o(176194);
        return true;
      }
    });
    this.mPadding = com.tencent.mm.cb.a.aG(this.mContext, 2131166254);
    this.rhX = getResources().getDimensionPixelSize(2131166253);
    this.rhX = com.tencent.mm.cb.a.aG(this.mContext, 2131166253);
    this.mNumColumns = 4;
    this.rhy = ((EmojiDetailScrollView)findViewById(2131307342));
    this.GQ = findViewById(2131300076);
    this.rhw = ((TextView)this.GQ.findViewById(2131300085));
    this.rhx = findViewById(2131300055);
    this.rhz = ((BannerEmojiView)findViewById(2131299991));
    int i = this.rhz.getRight();
    int j = this.rhz.getLeft();
    int k = this.rhz.getPaddingRight();
    int m = this.rhz.getPaddingLeft();
    this.rhz.setMinimumHeight((int)((i - j - k - m) * 0.56F));
    this.rhA = ((TextView)findViewById(2131300065));
    this.rhB = ((MMAutoSizeTextView)findViewById(2131300066));
    this.rhC = ((TextView)findViewById(2131299975));
    this.rhD = ((TextView)findViewById(2131300068));
    this.rhE = ((TextView)findViewById(2131299979));
    this.rhL = com.tencent.mm.cb.a.jn(getContext());
    this.rhM = findViewById(2131299942);
    this.rhF = ((EmojiDetailGridView)findViewById(2131299987));
    ProgressBar localProgressBar;
    if (com.tencent.mm.plugin.emoji.h.a.ang(this.rcD))
    {
      this.rht = new b();
      this.rhH = findViewById(2131300042);
      this.qWX = ((ProgressBar)findViewById(2131299982));
      this.rhG = ((ImageView)findViewById(2131299973));
      this.rhG.setOnClickListener(this);
      this.rhH.setVisibility(8);
      this.rhG.setVisibility(8);
      this.qWX.setProgress(0);
      this.rhF.setAdapter(this.rht);
      this.rhF.setColumnWidth(this.rhX);
      this.rhF.setNumColumns(this.mNumColumns);
      this.rhF.setHorizontalSpacing(this.mPadding);
      this.rhF.setVerticalSpacing(this.mPadding);
      this.rhF.setEmojiDetailScrollView(this.rhy);
      this.rhF.setFromDetail(true);
      this.rhF.setIsShowPopWin(true);
      this.rhF.setOnItemClickListener(new AdapterView.OnItemClickListener()
      {
        public final void onItemClick(AdapterView<?> paramAnonymousAdapterView, View paramAnonymousView, int paramAnonymousInt, long paramAnonymousLong)
        {
          AppMethodBeat.i(176183);
          com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
          localb.bm(paramAnonymousAdapterView);
          localb.bm(paramAnonymousView);
          localb.pH(paramAnonymousInt);
          localb.zo(paramAnonymousLong);
          com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/emoji/ui/EmojiStoreDetailUI$10", "android/widget/AdapterView$OnItemClickListener", "onItemClick", "(Landroid/widget/AdapterView;Landroid/view/View;IJ)V", this, localb.axR());
          paramAnonymousAdapterView = paramAnonymousAdapterView.getAdapter().getItem(paramAnonymousInt);
          if ((paramAnonymousAdapterView instanceof EmojiInfo))
          {
            paramAnonymousAdapterView = (EmojiInfo)paramAnonymousAdapterView;
            paramAnonymousView = new ait();
            if ((Util.isNullOrNil(paramAnonymousView.Md5)) || (paramAnonymousView.Md5.equals(paramAnonymousAdapterView.field_md5)))
            {
              paramAnonymousView.Md5 = com.tencent.mm.plugin.emoji.h.b.fX(paramAnonymousAdapterView.field_md5, paramAnonymousView.Md5);
              paramAnonymousView.Md5 = com.tencent.mm.plugin.emoji.h.b.fX(paramAnonymousView.Md5, "");
              paramAnonymousView.Url = com.tencent.mm.plugin.emoji.h.b.fX(paramAnonymousAdapterView.field_cdnUrl, paramAnonymousView.Url);
              paramAnonymousView.ThumbUrl = com.tencent.mm.plugin.emoji.h.b.fX(paramAnonymousAdapterView.field_thumbUrl, paramAnonymousView.ThumbUrl);
              paramAnonymousView.Lsl = com.tencent.mm.plugin.emoji.h.b.fX(paramAnonymousAdapterView.field_designerID, paramAnonymousView.Lsl);
              paramAnonymousView.EncryptUrl = com.tencent.mm.plugin.emoji.h.b.fX(paramAnonymousAdapterView.field_encrypturl, paramAnonymousView.EncryptUrl);
              paramAnonymousView.AesKey = com.tencent.mm.plugin.emoji.h.b.fX(paramAnonymousAdapterView.field_aeskey, paramAnonymousView.AesKey);
              paramAnonymousView.ProductID = com.tencent.mm.plugin.emoji.h.b.fX(paramAnonymousAdapterView.field_groupId, paramAnonymousView.ProductID);
              paramAnonymousView.ExternUrl = com.tencent.mm.plugin.emoji.h.b.fX(paramAnonymousAdapterView.field_externUrl, paramAnonymousView.ExternUrl);
              paramAnonymousView.ExternMd5 = com.tencent.mm.plugin.emoji.h.b.fX(paramAnonymousAdapterView.field_externMd5, paramAnonymousView.ExternMd5);
              paramAnonymousView.ActivityID = com.tencent.mm.plugin.emoji.h.b.fX(paramAnonymousAdapterView.field_activityid, paramAnonymousView.ActivityID);
              paramAnonymousView.Lsm = com.tencent.mm.plugin.emoji.h.b.fX(paramAnonymousAdapterView.field_attachedText, paramAnonymousView.Lsm);
              paramAnonymousView.Lsn = com.tencent.mm.plugin.emoji.h.b.fX(paramAnonymousAdapterView.field_attachTextColor, paramAnonymousView.Lsn);
              paramAnonymousView.Lso = com.tencent.mm.plugin.emoji.h.b.fX(paramAnonymousAdapterView.field_lensId, paramAnonymousView.Lso);
            }
            EmojiStoreDetailUI.a(EmojiStoreDetailUI.this, paramAnonymousView);
            com.tencent.mm.plugin.report.service.h.CyF.a(12787, new Object[] { Integer.valueOf(0), Integer.valueOf(0), paramAnonymousAdapterView.field_md5, Long.valueOf(EmojiStoreDetailUI.d(EmojiStoreDetailUI.this)), paramAnonymousAdapterView.field_designerID, paramAnonymousAdapterView.field_groupId, Integer.valueOf(26) });
          }
          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/emoji/ui/EmojiStoreDetailUI$10", "android/widget/AdapterView$OnItemClickListener", "onItemClick", "(Landroid/widget/AdapterView;Landroid/view/View;IJ)V");
          AppMethodBeat.o(176183);
        }
      });
      this.rhD.setOnClickListener(this);
      this.rhK = findViewById(2131308418);
      this.rhI = ((TextView)findViewById(2131300047));
      this.rhJ = ((TextView)findViewById(2131299974));
      this.rhI.setOnClickListener(this.riq);
      this.rhJ.setOnClickListener(this.rir);
      this.rhN = ((ProgressBar)findViewById(2131299985));
      localProgressBar = this.rhN;
      if (!this.rib) {
        break label796;
      }
    }
    label796:
    for (i = 0;; i = 8)
    {
      localProgressBar.setVisibility(i);
      this.rij = findViewById(2131299999);
      if (WeChatBrands.Business.Entries.MeStickerDeclare.banned()) {
        this.rhK.setVisibility(8);
      }
      this.rhR = findViewById(2131299978);
      this.rhO = findViewById(2131299519);
      this.rhP = ((ImageView)findViewById(2131299525));
      this.rhQ = ((TextView)findViewById(2131299535));
      this.rhS = findViewById(2131300043);
      this.rhT = ((TextView)findViewById(2131307053));
      this.rhU = ((Button)findViewById(2131307054));
      this.rhW = ((TextView)findViewById(2131307058));
      this.rhV = ((DonorsAvatarView)findViewById(2131307052));
      this.rhU.setOnClickListener(this.ris);
      this.rhW.setOnClickListener(this.rit);
      AppMethodBeat.o(109011);
      return;
      this.rht = new a();
      break;
    }
  }
  
  public void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    AppMethodBeat.i(109023);
    Log.d("MicroMsg.emoji.EmojiStoreDetailUI", "onActivityResult. requestCode:[%d] resultCode:[%d]", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) });
    String str1;
    Object localObject;
    if (paramInt1 == 2001)
    {
      str1 = "";
      paramInt1 = 0;
      if (paramIntent != null)
      {
        paramInt1 = paramIntent.getIntExtra("key_err_code", 0);
        Log.w("MicroMsg.emoji.EmojiStoreDetailUI", "errCode:".concat(String.valueOf(paramInt1)));
        str1 = paramIntent.getStringExtra("key_err_msg");
        Log.w("MicroMsg.emoji.EmojiStoreDetailUI", "errMsg:".concat(String.valueOf(str1)));
      }
      this.rii = false;
      if (paramInt2 == -1)
      {
        if ((paramIntent != null) && (paramInt1 == 0))
        {
          localObject = paramIntent.getStringArrayListExtra("key_response_product_ids");
          paramIntent = paramIntent.getStringArrayListExtra("key_response_series_ids");
          if ((localObject != null) && (((ArrayList)localObject).contains(this.rcD)))
          {
            paramInt1 = 0;
            while (paramInt1 < ((ArrayList)localObject).size())
            {
              if (this.rcD.equals(((ArrayList)localObject).get(paramInt1))) {
                this.rcF = ((String)paramIntent.get(paramInt1));
              }
              paramInt1 += 1;
            }
            this.reN.PackFlag = 1;
            cHK();
            this.rhp = 6;
            com.tencent.mm.ui.base.h.cD(this, str1);
            if (com.tencent.mm.model.z.aUn())
            {
              com.tencent.mm.plugin.report.service.h.CyF.idkeyStat(166L, 4L, 1L, false);
              AppMethodBeat.o(109023);
              return;
            }
            com.tencent.mm.plugin.report.service.h.CyF.idkeyStat(166L, 0L, 1L, false);
            AppMethodBeat.o(109023);
            return;
          }
          this.rhp = -1;
          cHF();
          amQ(str1);
          AppMethodBeat.o(109023);
          return;
        }
        if ((paramIntent != null) && (paramInt1 == 100000002))
        {
          cHK();
          this.rhp = 6;
          this.rht.notifyDataSetChanged();
          if (com.tencent.mm.model.z.aUn())
          {
            com.tencent.mm.plugin.report.service.h.CyF.idkeyStat(166L, 7L, 1L, false);
            AppMethodBeat.o(109023);
            return;
          }
          com.tencent.mm.plugin.report.service.h.CyF.idkeyStat(166L, 3L, 1L, false);
          AppMethodBeat.o(109023);
          return;
        }
        if ((paramIntent != null) && (paramInt1 == 1))
        {
          this.rhp = -1;
          cHF();
          if (com.tencent.mm.model.z.aUn())
          {
            com.tencent.mm.plugin.report.service.h.CyF.idkeyStat(166L, 6L, 1L, false);
            AppMethodBeat.o(109023);
            return;
          }
          com.tencent.mm.plugin.report.service.h.CyF.idkeyStat(166L, 2L, 1L, false);
          AppMethodBeat.o(109023);
          return;
        }
        this.rhp = -1;
        cHF();
        amQ(str1);
        if (com.tencent.mm.model.z.aUn())
        {
          com.tencent.mm.plugin.report.service.h.CyF.idkeyStat(166L, 5L, 1L, false);
          AppMethodBeat.o(109023);
          return;
        }
        com.tencent.mm.plugin.report.service.h.CyF.idkeyStat(166L, 1L, 1L, false);
        AppMethodBeat.o(109023);
        return;
      }
      this.rhp = -1;
      cHF();
      if (com.tencent.mm.model.z.aUn())
      {
        com.tencent.mm.plugin.report.service.h.CyF.idkeyStat(166L, 6L, 1L, false);
        AppMethodBeat.o(109023);
        return;
      }
      com.tencent.mm.plugin.report.service.h.CyF.idkeyStat(166L, 2L, 1L, false);
      AppMethodBeat.o(109023);
      return;
    }
    if (paramInt1 == 2002)
    {
      if (paramInt2 == -1)
      {
        paramIntent = paramIntent.getStringExtra("Select_Conv_User");
        if (!Util.isNullOrNil(paramIntent))
        {
          Log.d("MicroMsg.emoji.EmojiStoreDetailUI", "..".concat(String.valueOf(paramIntent)));
          str1 = this.rcD;
          localObject = this.reN.PackName;
          String str2 = this.reN.PackDesc;
          String str3 = this.reN.IconUrl;
          String str4 = this.reN.OldRedirectUrl;
          paramInt1 = this.reN.PackFlag;
          String str5 = getResources().getString(2131755795);
          str5 = str5 + (String)localObject;
          String str6 = getString(2131755976);
          String str7 = getString(2131757786);
          ((com.tencent.mm.pluginsdk.j)g.af(com.tencent.mm.pluginsdk.j.class)).a(this, paramIntent, str5, str6, str7, str3, new j.1(paramIntent, str1, (String)localObject, str2, str3, str4, paramInt1, this));
        }
        AppMethodBeat.o(109023);
      }
    }
    else if (paramInt1 == this.rbL.nTL)
    {
      if (paramInt2 == -1)
      {
        Log.d("MicroMsg.emoji.EmojiStoreDetailUI", "jacks use emoji to : %s", new Object[] { paramIntent.getStringExtra("Select_Conv_User") });
        com.tencent.mm.plugin.emoji.h.c.a(paramIntent, this.rcD, this);
        com.tencent.mm.plugin.report.service.h.CyF.a(12069, new Object[] { Integer.valueOf(3), this.rcD });
        AppMethodBeat.o(109023);
      }
    }
    else if ((paramInt1 == 2004) && (paramInt2 == -1)) {
      com.tencent.mm.ui.widget.snackbar.b.r(this, getContext().getString(2131755979));
    }
    AppMethodBeat.o(109023);
  }
  
  public void onClick(View paramView)
  {
    AppMethodBeat.i(109019);
    com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
    localb.bm(paramView);
    com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/emoji/ui/EmojiStoreDetailUI", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.axR());
    int i = paramView.getId();
    if (i == 2131300068)
    {
      if (this.rhp == 7)
      {
        paramView = getIntent().getStringExtra("to_talker_name");
        if (this.rio)
        {
          paramView = new r(this.rcD, 2);
          g.aAg().hqi.a(paramView, 0);
          this.rip = com.tencent.mm.ui.base.q.a(this, getString(2131762443), true, 0, null);
          Log.d("MicroMsg.emoji.EmojiStoreDetailUI", "jacks kv stat update click use emoji");
          com.tencent.mm.plugin.report.service.h.CyF.kvStat(11076, "0, ");
        }
      }
      for (;;)
      {
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/emoji/ui/EmojiStoreDetailUI", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(109019);
        return;
        if ((!Util.isNullOrNil(paramView)) && (this.rho))
        {
          com.tencent.mm.plugin.emoji.h.c.a(paramView, this.rcD, this);
          break;
        }
        this.rbL.N(this);
        com.tencent.mm.plugin.report.service.h.CyF.a(12069, new Object[] { Integer.valueOf(2), this.rcD });
        break;
        switch (this.rhp)
        {
        case 1: 
        case 2: 
        case 6: 
        case 7: 
        case 8: 
        case 9: 
        default: 
          Log.e("MicroMsg.emoji.EmojiStoreDetailUI", "can not product status.%d", new Object[] { Integer.valueOf(this.rhp) });
          break;
        case 4: 
          if (!this.rii)
          {
            if (this.rio)
            {
              paramView = com.tencent.mm.emoji.c.e.hcl;
              com.tencent.mm.emoji.c.e.pl(6);
            }
            Log.i("MicroMsg.emoji.EmojiStoreDetailUI", "mProductId:%s, mData.PackPrice:%s,PriceType:%s", new Object[] { this.rcD, this.reN.PackPrice, this.reN.PriceType });
            paramView = new Intent();
            paramView.putExtra("key_product_id", this.rcD);
            if (this.rib)
            {
              paramView.putExtra("key_currency_type", this.rif);
              paramView.putExtra("key_price", this.rif + this.rig);
            }
            for (;;)
            {
              com.tencent.mm.br.c.b(this, "wallet_index", ".ui.WalletIapUI", paramView, 2001);
              com.tencent.mm.plugin.report.service.h.CyF.a(12066, new Object[] { Integer.valueOf(2), Integer.valueOf(this.rhZ), "", this.rcD, Long.valueOf(this.rbH), this.rbI });
              this.rii = true;
              break;
              paramView.putExtra("key_currency_type", this.reN.PriceType);
              paramView.putExtra("key_price", this.reN.PriceNum);
            }
          }
          break;
        case 0: 
        case 3: 
          if (this.rio)
          {
            paramView = com.tencent.mm.emoji.c.e.hcl;
            com.tencent.mm.emoji.c.e.pl(6);
          }
          cHK();
          this.rhp = 6;
          cHF();
          com.tencent.mm.plugin.report.service.h.CyF.a(12066, new Object[] { Integer.valueOf(1), Integer.valueOf(this.rhZ), "", this.rcD, Long.valueOf(this.rbH), this.rbI });
          if (this.rbN != null)
          {
            this.rbN.eqm = 4;
            this.rbN.bfK();
          }
          break;
        case 5: 
          this.rhp = 3;
          cHF();
          break;
        case 10: 
        case 12: 
          switch (this.rid)
          {
          default: 
            paramView = getString(2131758706);
          }
          for (;;)
          {
            com.tencent.mm.ui.base.h.c(this, paramView, null, true);
            break;
            paramView = getString(2131758549);
            continue;
            paramView = getString(2131758558);
            continue;
            paramView = getString(2131758701);
          }
        case 11: 
          Log.i("MicroMsg.emoji.EmojiStoreDetailUI", "can not be clicked.");
          break;
        case -1: 
          Log.i("MicroMsg.emoji.EmojiStoreDetailUI", "can not be clicked.");
        }
      }
    }
    if (i == 2131299982)
    {
      cHJ();
      com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/emoji/ui/EmojiStoreDetailUI", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
      AppMethodBeat.o(109019);
      return;
    }
    if (i == 2131299973)
    {
      cHJ();
      com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/emoji/ui/EmojiStoreDetailUI", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
      AppMethodBeat.o(109019);
      return;
    }
    Log.w("MicroMsg.emoji.EmojiStoreDetailUI", "click view is unknow.");
    com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/emoji/ui/EmojiStoreDetailUI", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
    AppMethodBeat.o(109019);
  }
  
  public void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(109010);
    super.onCreate(paramBundle);
    if (!g.aAc())
    {
      finish();
      AppMethodBeat.o(109010);
      return;
    }
    this.rib = com.tencent.mm.model.z.aUn();
    this.rbL = new com.tencent.mm.plugin.emoji.h.c(2003);
    paramBundle = getIntent();
    this.rcD = getIntent().getStringExtra("extra_id");
    this.reu = getIntent().getIntExtra("preceding_scence", -1);
    this.rcE = getIntent().getStringExtra("extra_name");
    this.rhl = getIntent().getIntExtra("call_by", -1);
    Object localObject = getIntent().getStringExtra("sns_object_data");
    if (!TextUtils.isEmpty((CharSequence)localObject))
    {
      this.rcD = EmojiLogic.amt((String)localObject);
      this.reu = 0;
      this.reu = 10;
      com.tencent.mm.plugin.report.service.h.CyF.a(10993, new Object[] { Integer.valueOf(3), this.rcD });
    }
    if (TextUtils.isEmpty(this.rcD))
    {
      Log.d("MicroMsg.emoji.EmojiStoreDetailUI", "[hadleIntent] product id is null.");
      finish();
    }
    if (this.reu == -1)
    {
      Log.e("MicroMsg.emoji.EmojiStoreDetailUI", "[hadleIntent] emoticon preceding scence no set!");
      finish();
    }
    this.rik = paramBundle.getBooleanExtra("check_clickflag", true);
    this.ria = paramBundle.getStringExtra("cdn_client_id");
    this.rhZ = paramBundle.getIntExtra("download_entrance_scene", 0);
    this.rio = paramBundle.getBooleanExtra("from_popup", false);
    this.rbH = paramBundle.getLongExtra("searchID", 0L);
    this.rbI = Util.nullAs(paramBundle.getStringExtra("docID"), "");
    localObject = paramBundle.getStringExtra("extra_copyright");
    if (!TextUtils.isEmpty((CharSequence)localObject)) {
      this.reN.PackCopyright = ((String)localObject);
    }
    localObject = paramBundle.getStringExtra("extra_coverurl");
    if (!TextUtils.isEmpty((CharSequence)localObject)) {
      this.reN.CoverUrl = ((String)localObject);
    }
    localObject = paramBundle.getStringExtra("extra_description");
    if (!TextUtils.isEmpty((CharSequence)localObject)) {
      this.reN.PackDesc = ((String)localObject);
    }
    localObject = paramBundle.getStringExtra("extra_price");
    if (!TextUtils.isEmpty((CharSequence)localObject)) {
      this.reN.PackPrice = ((String)localObject);
    }
    int i = paramBundle.getIntExtra("extra_type", -1);
    if (i != -1) {
      this.reN.PackType = i;
    }
    i = paramBundle.getIntExtra("extra_flag", -1);
    if (i != -1) {
      this.reN.PackFlag = i;
    }
    localObject = paramBundle.getStringExtra("extra_price_type");
    if (!TextUtils.isEmpty((CharSequence)localObject)) {
      this.reN.PriceType = ((String)localObject);
    }
    localObject = paramBundle.getStringExtra("extra_price_num");
    if (!TextUtils.isEmpty((CharSequence)localObject)) {
      this.reN.PriceNum = ((String)localObject);
    }
    if (this.rib)
    {
      this.ric = 11;
      com.tencent.mm.pluginsdk.model.k.a(this, this.rih, this.riw);
    }
    this.rhn = paramBundle.getBooleanExtra("reward_tip", false);
    paramBundle = paramBundle.getStringExtra("action_report");
    if (!Util.isNullOrNil(paramBundle)) {
      this.rbN = new as(paramBundle);
    }
    this.rih[0] = this.rcD;
    this.reN.ProductID = this.rcD;
    this.reN.PackName = this.rcE;
    this.reN.ShareDesc = this.rhm;
    this.reN.PriceNum = "-1";
    this.reN.Version = -1;
    this.mContext = this;
    riu.cMO = new WeakReference(this);
    initView();
    if (!com.tencent.mm.plugin.emoji.h.a.ang(this.rcD)) {
      if (this.reN == null)
      {
        this.rhq = new m(this.rcD, this.reu);
        g.aAg().hqi.a(this.rhq, 0);
        if ((this.rhl == -1) || (this.rhl == 3))
        {
          this.rhx.setVisibility(8);
          this.GQ.setVisibility(8);
          getString(2131755998);
          this.jZH = com.tencent.mm.ui.base.h.a(this, getString(2131756029), true, new DialogInterface.OnCancelListener()
          {
            public final void onCancel(DialogInterface paramAnonymousDialogInterface)
            {
              AppMethodBeat.i(176184);
              g.aAg().hqi.a(EmojiStoreDetailUI.o(EmojiStoreDetailUI.this));
              EmojiStoreDetailUI.p(EmojiStoreDetailUI.this).setText(2131758625);
              EmojiStoreDetailUI.q(EmojiStoreDetailUI.this);
              AppMethodBeat.o(176184);
            }
          });
        }
        cHx();
        if (!this.rik) {
          break label1051;
        }
        paramBundle = new com.tencent.mm.plugin.emoji.f.l(this.rcD);
        g.aAg().hqi.a(paramBundle, 0);
      }
    }
    for (;;)
    {
      cHA();
      com.tencent.mm.plugin.emoji.model.k.getEmojiStorageMgr().OpO.add(this);
      EventCenter.instance.addListener(this.rey);
      g.aAg().hqi.a(822, this);
      i = getIntent().getIntExtra("extra_status", -1);
      int j = getIntent().getIntExtra("extra_progress", 0);
      i(this.rcD, i, j, this.ria);
      this.rin = true;
      com.tencent.mm.plugin.report.service.h.CyF.a(12740, new Object[] { Integer.valueOf(1), "", this.rcD, "", Integer.valueOf(this.rhZ), Integer.valueOf(26) });
      if ((this.rhn) && (this.rhy != null)) {
        this.mHandler.postDelayed(new Runnable()
        {
          public final void run()
          {
            AppMethodBeat.i(176193);
            EmojiStoreDetailUI.m(EmojiStoreDetailUI.this).fullScroll(130);
            AppMethodBeat.o(176193);
          }
        }, 0L);
      }
      AppMethodBeat.o(109010);
      return;
      if ((!Util.isNullOrNil(this.reO)) && (this.reO.equalsIgnoreCase(LocaleUtil.getCurrentLanguage(this.mContext))))
      {
        this.rhq = new m(this.rcD, this.reu, this.reN.Version);
        break;
      }
      this.rhq = new m(this.rcD, this.reu);
      break;
      label1051:
      this.rim = true;
      this.ril = EmojiLogic.cFW();
      continue;
      paramBundle = getContext();
      localObject = new EmotionDetail();
      ((EmotionDetail)localObject).ProductID = EmojiGroupInfo.Uum;
      ((EmotionDetail)localObject).PackName = paramBundle.getString(2131758679);
      ((EmotionDetail)localObject).PackDesc = paramBundle.getString(2131758677);
      ((EmotionDetail)localObject).PackAuthInfo = paramBundle.getString(2131758675);
      ((EmotionDetail)localObject).PackPrice = "";
      ((EmotionDetail)localObject).PackType = 0;
      ((EmotionDetail)localObject).PackFlag = 1;
      ((EmotionDetail)localObject).CoverUrl = "";
      ((EmotionDetail)localObject).PackExpire = 0;
      ((EmotionDetail)localObject).PackCopyright = paramBundle.getString(2131758676);
      ((EmotionDetail)localObject).PanelUrl = "";
      ((EmotionDetail)localObject).PriceNum = "";
      ((EmotionDetail)localObject).PriceType = "";
      ((EmotionDetail)localObject).TimeLimitStr = paramBundle.getString(2131758678);
      this.reN = ((EmotionDetail)localObject);
      this.rim = true;
      this.ril = EmojiLogic.cFW();
      cHz();
    }
  }
  
  public void onDestroy()
  {
    AppMethodBeat.i(109016);
    super.onDestroy();
    com.tencent.mm.plugin.emoji.model.k.getEmojiStorageMgr().OpO.remove(this);
    EventCenter.instance.removeListener(this.rey);
    g.aAg().hqi.b(822, this);
    if (this.rhF != null) {
      this.rhF.hfZ();
    }
    this.mHandler.removeCallbacksAndMessages(null);
    AppMethodBeat.o(109016);
  }
  
  public void onNotifyChange(String paramString, MStorageEventData paramMStorageEventData)
  {
    AppMethodBeat.i(109024);
    Ga(1001);
    AppMethodBeat.o(109024);
  }
  
  public void onPause()
  {
    AppMethodBeat.i(109014);
    super.onPause();
    g.aAg().hqi.b(412, this);
    g.aAg().hqi.b(521, this);
    g.aAg().hqi.b(423, this);
    g.aAg().hqi.b(413, this);
    AppMethodBeat.o(109014);
  }
  
  public void onRestoreInstanceState(Bundle paramBundle)
  {
    AppMethodBeat.i(109018);
    this.rhp = paramBundle.getInt("status");
    this.HH = paramBundle.getInt("progress");
    AppMethodBeat.o(109018);
  }
  
  public void onResume()
  {
    AppMethodBeat.i(109013);
    super.onResume();
    g.aAg().hqi.a(412, this);
    g.aAg().hqi.a(521, this);
    g.aAg().hqi.a(423, this);
    g.aAg().hqi.a(413, this);
    this.rii = false;
    if (!this.rin)
    {
      cHx();
      Ga(1007);
    }
    cHy();
    this.rin = false;
    Ga(1001);
    AppMethodBeat.o(109013);
  }
  
  public void onSaveInstanceState(Bundle paramBundle)
  {
    AppMethodBeat.i(109017);
    paramBundle.putInt("status", this.rhp);
    paramBundle.putInt("progress", this.HH);
    AppMethodBeat.o(109017);
  }
  
  public void onSceneEnd(int paramInt1, int paramInt2, String paramString, com.tencent.mm.ak.q paramq)
  {
    AppMethodBeat.i(109020);
    Log.i("MicroMsg.emoji.EmojiStoreDetailUI", "[onSceneEnd] errType:%d, errCode:%d, errMsg:%s", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), paramString });
    if ((this.jZH != null) && (this.jZH.isShowing())) {
      this.jZH.dismiss();
    }
    switch (paramq.getType())
    {
    }
    for (;;)
    {
      AppMethodBeat.o(109020);
      return;
      if ((paramq instanceof m))
      {
        Log.i("MicroMsg.emoji.EmojiStoreDetailUI", "[onSceneEnd] MMFunc_GetEmotionDetail");
        paramString = (m)paramq;
        if ((paramString != null) && (!Util.isNullOrNil(paramString.rcD)) && (paramString.rcD.equalsIgnoreCase(this.rcD)))
        {
          if (paramInt1 == 0)
          {
            if (paramInt2 == 0)
            {
              this.reN = paramString.cGv();
              Ga(1002);
              AppMethodBeat.o(109020);
              return;
            }
            if (paramInt2 == 1)
            {
              cHv();
              AppMethodBeat.o(109020);
              return;
            }
            this.rhw.setText(2131758624);
            cHw();
            AppMethodBeat.o(109020);
            return;
          }
          if (paramInt2 == 5)
          {
            if ((paramString != null) && (paramString.cGv() != null)) {
              this.reN.PackFlag = paramString.cGv().PackFlag;
            }
            Ga(1002);
            AppMethodBeat.o(109020);
            return;
          }
          if (paramInt2 == 1)
          {
            cHv();
            AppMethodBeat.o(109020);
            return;
          }
          this.rhy.setVisibility(8);
          this.GQ.setVisibility(0);
          this.rhw.setText(2131758625);
          cHw();
          AppMethodBeat.o(109020);
          return;
        }
        Log.i("MicroMsg.emoji.EmojiStoreDetailUI", "no equal productid");
        AppMethodBeat.o(109020);
        return;
        if ((paramq instanceof com.tencent.mm.plugin.emoji.f.h))
        {
          Log.i("MicroMsg.emoji.EmojiStoreDetailUI", "[onSceneEnd] MMFunc_ExchangeEmotionPack");
          paramString = (com.tencent.mm.plugin.emoji.f.h)paramq;
          if ((paramString == this.rhr) && (!Util.isNullOrNil(paramString.rcD)) && (paramString.rcD.equalsIgnoreCase(this.rcD)))
          {
            if ((paramInt1 == 0) && (paramInt2 == 0))
            {
              this.ria = paramString.iYT;
              this.rhp = 6;
              cHF();
              AppMethodBeat.o(109020);
              return;
            }
            this.rhp = -1;
            cHF();
            paramString = this.rcE;
            com.tencent.mm.ui.base.h.a(this, String.format(getString(2131758614), new Object[] { paramString }), "", new DialogInterface.OnClickListener()new EmojiStoreDetailUI.10
            {
              public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
              {
                AppMethodBeat.i(176188);
                EmojiStoreDetailUI.a(EmojiStoreDetailUI.this, new com.tencent.mm.plugin.emoji.f.h(EmojiStoreDetailUI.a(EmojiStoreDetailUI.this), EmojiStoreDetailUI.y(EmojiStoreDetailUI.this), EmojiStoreDetailUI.z(EmojiStoreDetailUI.this)));
                EmojiStoreDetailUI.A(EmojiStoreDetailUI.this);
                EmojiStoreDetailUI.a(EmojiStoreDetailUI.this, 6);
                EmojiStoreDetailUI.g(EmojiStoreDetailUI.this);
                AppMethodBeat.o(176188);
              }
            }, new EmojiStoreDetailUI.10(this));
            AppMethodBeat.o(109020);
            return;
          }
          Log.i("MicroMsg.emoji.EmojiStoreDetailUI", "no equal productid");
          AppMethodBeat.o(109020);
          return;
          Log.i("MicroMsg.emoji.EmojiStoreDetailUI", "[onSceneEnd] MMFunc_GetEmotionDesc");
          paramString = (com.tencent.mm.plugin.emoji.f.l)paramq;
          if ((paramString != null) && (!Util.isNullOrNil(paramString.rcq)) && (paramString.rcq.equalsIgnoreCase(this.rcD))) {
            if ((paramInt1 == 0) && (paramInt2 == 0))
            {
              this.ril = ((bms)paramString.rr.iLL.iLR);
              this.rim = true;
              cHG();
            }
          }
          for (;;)
          {
            this.rim = true;
            cHG();
            AppMethodBeat.o(109020);
            return;
            this.ril = null;
            break;
            Log.i("MicroMsg.emoji.EmojiStoreDetailUI", "no equal productid");
          }
          if ((paramq instanceof p))
          {
            Log.i("MicroMsg.emoji.EmojiStoreDetailUI", "[onSceneEnd] MMFunc_MMGetEmotionReward");
            if ((paramInt1 == 0) && (paramInt2 == 0))
            {
              this.rhu = ((p)paramq).cGz();
              Ga(1007);
              AppMethodBeat.o(109020);
              return;
              if (this.rip != null)
              {
                this.rip.dismiss();
                this.rip = null;
              }
              if ((paramInt1 == 0) && (paramInt2 == 0))
              {
                com.tencent.mm.plugin.emoji.model.k.getEmojiStorageMgr().OpO.blc(((r)paramq).rcD);
                this.rhp = 3;
                cHF();
                AppMethodBeat.o(109020);
                return;
              }
              com.tencent.mm.ui.base.h.c(getContext(), getContext().getString(2131758703), "", "", getContext().getString(2131755874), null, null);
            }
          }
        }
      }
    }
  }
  
  public void onStart()
  {
    AppMethodBeat.i(109012);
    super.onStart();
    AppMethodBeat.o(109012);
  }
  
  public void onStop()
  {
    AppMethodBeat.i(109015);
    super.onStop();
    AppMethodBeat.o(109015);
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
  
  class a
    extends BaseAdapter
    implements com.tencent.mm.view.a.a
  {
    public a() {}
    
    public int getCount()
    {
      AppMethodBeat.i(109000);
      if (EmojiStoreDetailUI.b(EmojiStoreDetailUI.this) == null)
      {
        AppMethodBeat.o(109000);
        return 0;
      }
      int i = EmojiStoreDetailUI.b(EmojiStoreDetailUI.this).PackThumbCnt;
      AppMethodBeat.o(109000);
      return i;
    }
    
    public Object getItem(int paramInt)
    {
      AppMethodBeat.i(109001);
      if ((EmojiStoreDetailUI.b(EmojiStoreDetailUI.this) == null) || (EmojiStoreDetailUI.b(EmojiStoreDetailUI.this).ThumbExtList == null) || (EmojiStoreDetailUI.b(EmojiStoreDetailUI.this).ThumbExtList.size() <= 0) || (EmojiStoreDetailUI.b(EmojiStoreDetailUI.this).ThumbExtList.get(paramInt) == null) || (((PackThumbExt)EmojiStoreDetailUI.b(EmojiStoreDetailUI.this).ThumbExtList.get(paramInt)).PreviewUrl == null))
      {
        AppMethodBeat.o(109001);
        return null;
      }
      Log.d("MicroMsg.emoji.EmojiStoreDetailUI", "jacks get preview : %d", new Object[] { Integer.valueOf(paramInt) });
      PackThumbExt localPackThumbExt = (PackThumbExt)EmojiStoreDetailUI.b(EmojiStoreDetailUI.this).ThumbExtList.get(paramInt);
      EmojiInfo localEmojiInfo = new EmojiInfo();
      localEmojiInfo.field_md5 = localPackThumbExt.Md5;
      localEmojiInfo.field_thumbUrl = localPackThumbExt.ThumbUrl;
      localEmojiInfo.field_cdnUrl = localPackThumbExt.CDNUrl;
      localEmojiInfo.field_aeskey = localPackThumbExt.AesKey;
      localEmojiInfo.field_encrypturl = localPackThumbExt.EncryptUrl;
      localEmojiInfo.field_externUrl = localPackThumbExt.ExternUrl;
      localEmojiInfo.field_externMd5 = localPackThumbExt.ExternMd5;
      localEmojiInfo.field_activityid = localPackThumbExt.ActivityID;
      localEmojiInfo.field_groupId = EmojiStoreDetailUI.a(EmojiStoreDetailUI.this);
      localEmojiInfo.field_catalog = 84;
      localEmojiInfo.field_reserved4 |= EmojiInfo.UuK;
      AppMethodBeat.o(109001);
      return localEmojiInfo;
    }
    
    public long getItemId(int paramInt)
    {
      return paramInt;
    }
    
    public View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
    {
      AppMethodBeat.i(109002);
      if ((paramView == null) || (paramView.getTag() == null))
      {
        paramView = LayoutInflater.from(EmojiStoreDetailUI.w(EmojiStoreDetailUI.this)).inflate(2131493950, null);
        paramViewGroup = new EmojiStoreDetailUI.c(EmojiStoreDetailUI.this, paramView);
        paramView.setTag(paramViewGroup);
        if (!EmojiStoreDetailUI.x(EmojiStoreDetailUI.this).Rnf) {
          break label154;
        }
        paramViewGroup.riz.setBackgroundResource(2131234918);
      }
      for (;;)
      {
        String str = "";
        if (EmojiStoreDetailUI.b(EmojiStoreDetailUI.this).PackThumbList != null) {
          str = com.tencent.mm.platformtools.z.a((dqi)EmojiStoreDetailUI.b(EmojiStoreDetailUI.this).PackThumbList.get(paramInt));
        }
        com.tencent.mm.av.q.bcV().a(str, paramViewGroup.riz, com.tencent.mm.plugin.emoji.e.e.fQ(EmojiStoreDetailUI.a(EmojiStoreDetailUI.this), str));
        AppMethodBeat.o(109002);
        return paramView;
        paramViewGroup = (EmojiStoreDetailUI.c)paramView.getTag();
        break;
        label154:
        paramViewGroup.riz.setBackgroundDrawable(null);
      }
    }
  }
  
  final class b
    extends EmojiStoreDetailUI.a
  {
    private ArrayList<EmojiInfo> riy;
    
    public b()
    {
      super();
      AppMethodBeat.i(109003);
      this.riy = new ArrayList();
      this.riy = ((ArrayList)com.tencent.mm.plugin.emoji.model.k.getEmojiStorageMgr().OpN.amo(com.tencent.mm.plugin.emoji.h.a.cIr()));
      AppMethodBeat.o(109003);
    }
    
    private EmojiInfo FY(int paramInt)
    {
      AppMethodBeat.i(109005);
      if (this.riy == null)
      {
        AppMethodBeat.o(109005);
        return null;
      }
      EmojiInfo localEmojiInfo = (EmojiInfo)this.riy.get(paramInt);
      AppMethodBeat.o(109005);
      return localEmojiInfo;
    }
    
    public final int getCount()
    {
      AppMethodBeat.i(109004);
      if (this.riy == null)
      {
        AppMethodBeat.o(109004);
        return 0;
      }
      int i = this.riy.size();
      AppMethodBeat.o(109004);
      return i;
    }
    
    public final long getItemId(int paramInt)
    {
      return paramInt;
    }
    
    public final View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
    {
      AppMethodBeat.i(109006);
      if ((paramView == null) || (paramView.getTag() == null))
      {
        paramView = LayoutInflater.from(EmojiStoreDetailUI.w(EmojiStoreDetailUI.this)).inflate(2131493950, null);
        paramViewGroup = new EmojiStoreDetailUI.c(EmojiStoreDetailUI.this, paramView);
        paramView.setTag(paramViewGroup);
        paramViewGroup.riz.setBackgroundResource(2131234918);
        localObject = FY(paramInt);
        if (!Util.isNullOrNil(((EmojiInfo)localObject).getContent())) {
          break label129;
        }
      }
      label129:
      for (Object localObject = ((EmojiInfo)localObject).getName();; localObject = ((EmojiInfo)localObject).getContent())
      {
        localObject = localObject.split("\\.")[0];
        com.tencent.mm.av.q.bcV().a((String)localObject, paramViewGroup.riz, com.tencent.mm.plugin.emoji.e.e.cFG());
        AppMethodBeat.o(109006);
        return paramView;
        paramViewGroup = (EmojiStoreDetailUI.c)paramView.getTag();
        break;
      }
    }
  }
  
  final class c
  {
    SquareImageView riz;
    
    public c(View paramView)
    {
      AppMethodBeat.i(109008);
      this.riz = ((SquareImageView)paramView.findViewById(2131299553));
      this.riz.setScaleType(ImageView.ScaleType.FIT_CENTER);
      AppMethodBeat.o(109008);
    }
  }
  
  static final class d
    implements com.tencent.mm.av.a.c.k
  {
    WeakReference<EmojiStoreDetailUI> cMO;
    
    public final void a(String paramString, View paramView, Bitmap paramBitmap, Object... paramVarArgs)
    {
      AppMethodBeat.i(176195);
      Log.d("MicroMsg.emoji.EmojiStoreDetailUI", "[cpan] on image load complete url:%s", new Object[] { paramString });
      if (this.cMO == null)
      {
        AppMethodBeat.o(176195);
        return;
      }
      paramString = (EmojiStoreDetailUI)this.cMO.get();
      if (paramString == null)
      {
        AppMethodBeat.o(176195);
        return;
      }
      if (paramBitmap != null) {
        paramString.Ga(1006);
      }
      AppMethodBeat.o(176195);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.emoji.ui.EmojiStoreDetailUI
 * JD-Core Version:    0.7.0.1
 */