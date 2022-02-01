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
import com.tencent.mm.ak.b.c;
import com.tencent.mm.ak.n;
import com.tencent.mm.g.a.dm;
import com.tencent.mm.model.v;
import com.tencent.mm.plugin.emoji.model.EmojiLogic;
import com.tencent.mm.plugin.emoji.ui.v2.DonorsAvatarView;
import com.tencent.mm.plugin.emoji.ui.v2.EmojiStoreV2DesignerUI;
import com.tencent.mm.plugin.emoji.ui.v2.EmojiStoreV2RewardDetailUI;
import com.tencent.mm.plugin.emoji.ui.v2.EmojiStoreV2RewardUI;
import com.tencent.mm.pluginsdk.model.j.a;
import com.tencent.mm.pluginsdk.ui.emoji.BannerEmojiView;
import com.tencent.mm.protocal.protobuf.EmotionDetail;
import com.tencent.mm.protocal.protobuf.GetEmotionRewardResponse;
import com.tencent.mm.protocal.protobuf.PackThumbExt;
import com.tencent.mm.protocal.protobuf.PersonalDesigner;
import com.tencent.mm.protocal.protobuf.agk;
import com.tencent.mm.protocal.protobuf.agx;
import com.tencent.mm.protocal.protobuf.bbd;
import com.tencent.mm.protocal.protobuf.cxn;
import com.tencent.mm.sdk.e.k.a;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.aq;
import com.tencent.mm.sdk.platformtools.bu;
import com.tencent.mm.storage.be;
import com.tencent.mm.storage.emotion.EmojiGroupInfo;
import com.tencent.mm.storage.emotion.EmojiInfo;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.MMAutoSizeTextView;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.ui.base.n.e;
import com.tencent.mm.view.SmileySubGrid;
import java.lang.ref.WeakReference;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.LinkedList;

public class EmojiStoreDetailUI
  extends MMActivity
  implements View.OnClickListener, com.tencent.mm.ak.f, k.a
{
  private static d pRu;
  private View GG;
  private int Hx;
  private ProgressDialog jbE;
  private Context mContext;
  private aq mHandler;
  private int mNumColumns;
  private int mPadding;
  private ProgressBar pHl;
  private long pLp;
  private String pLq;
  private com.tencent.mm.plugin.emoji.h.c pLt;
  private com.tencent.mm.g.b.a.z pLv;
  private String pMk;
  private String pMl;
  private String pMm;
  private int pNX;
  private com.tencent.mm.sdk.b.c pOb;
  private EmotionDetail pOp;
  private String pOq;
  private BannerEmojiView pQA;
  private TextView pQB;
  private MMAutoSizeTextView pQC;
  private TextView pQD;
  private TextView pQE;
  private TextView pQF;
  private EmojiDetailGridView pQG;
  private ImageView pQH;
  private View pQI;
  private TextView pQJ;
  private TextView pQK;
  private int pQL;
  private View pQM;
  private ProgressBar pQN;
  private View pQO;
  private ImageView pQP;
  private TextView pQQ;
  private View pQR;
  private View pQS;
  private TextView pQT;
  private Button pQU;
  private DonorsAvatarView pQV;
  private TextView pQW;
  private int pQX;
  private int pQY;
  private int pQZ;
  private int pQm;
  private String pQn;
  private boolean pQo;
  private boolean pQp;
  private int pQq;
  private com.tencent.mm.plugin.emoji.f.l pQr;
  private com.tencent.mm.plugin.emoji.f.g pQs;
  private com.tencent.mm.plugin.emoji.f.o pQt;
  private a pQu;
  private GetEmotionRewardResponse pQv;
  private boolean pQw;
  private TextView pQx;
  private View pQy;
  private EmojiDetailScrollView pQz;
  private String pRa;
  private boolean pRb;
  private int pRc;
  private int pRd;
  private String pRe;
  private String pRf;
  private String pRg;
  private String[] pRh;
  private boolean pRi;
  private View pRj;
  private boolean pRk;
  private bbd pRl;
  private boolean pRm;
  private boolean pRn;
  private boolean pRo;
  private com.tencent.mm.ui.base.p pRp;
  private View.OnClickListener pRq;
  private View.OnClickListener pRr;
  private View.OnClickListener pRs;
  private View.OnClickListener pRt;
  private com.tencent.mm.av.a.c.l pRv;
  private j.a pRw;
  
  static
  {
    AppMethodBeat.i(176199);
    pRu = new d((byte)0);
    AppMethodBeat.o(176199);
  }
  
  public EmojiStoreDetailUI()
  {
    AppMethodBeat.i(109009);
    this.pQp = false;
    this.pQq = -1;
    this.pOp = new EmotionDetail();
    this.pOq = "";
    this.pQv = null;
    this.pLp = 0L;
    this.pLq = "";
    this.pRd = -1;
    this.pRh = new String[1];
    this.pRi = false;
    this.pRk = true;
    this.pRm = false;
    this.pRn = true;
    this.pRo = false;
    this.pOb = new com.tencent.mm.sdk.b.c() {};
    this.pRq = new EmojiStoreDetailUI.12(this);
    this.pRr = new EmojiStoreDetailUI.15(this);
    this.pRs = new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(108994);
        Object localObject = new com.tencent.mm.hellhoundlib.b.b();
        ((com.tencent.mm.hellhoundlib.b.b)localObject).bd(paramAnonymousView);
        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/emoji/ui/EmojiStoreDetailUI$4", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, ((com.tencent.mm.hellhoundlib.b.b)localObject).ahF());
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
        localObject = new com.tencent.mm.hellhoundlib.b.a().bc(localObject);
        com.tencent.mm.hellhoundlib.a.a.a(paramAnonymousView, ((com.tencent.mm.hellhoundlib.b.a)localObject).ahE(), "com/tencent/mm/plugin/emoji/ui/EmojiStoreDetailUI$4", "onClick", "(Landroid/view/View;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
        paramAnonymousView.startActivity((Intent)((com.tencent.mm.hellhoundlib.b.a)localObject).mt(0));
        com.tencent.mm.hellhoundlib.a.a.a(paramAnonymousView, "com/tencent/mm/plugin/emoji/ui/EmojiStoreDetailUI$4", "onClick", "(Landroid/view/View;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
        com.tencent.mm.plugin.report.service.g.yxI.f(12738, new Object[] { EmojiStoreDetailUI.a(EmojiStoreDetailUI.this), Integer.valueOf(1), Integer.valueOf(EmojiStoreDetailUI.c(EmojiStoreDetailUI.this)), Integer.valueOf(0) });
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/emoji/ui/EmojiStoreDetailUI$4", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(108994);
      }
    };
    this.pRt = new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(108995);
        Object localObject = new com.tencent.mm.hellhoundlib.b.b();
        ((com.tencent.mm.hellhoundlib.b.b)localObject).bd(paramAnonymousView);
        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/emoji/ui/EmojiStoreDetailUI$5", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, ((com.tencent.mm.hellhoundlib.b.b)localObject).ahF());
        localObject = new Intent();
        ((Intent)localObject).setClass(EmojiStoreDetailUI.this, EmojiStoreV2RewardDetailUI.class);
        ((Intent)localObject).putExtra("extra_id", EmojiStoreDetailUI.a(EmojiStoreDetailUI.this));
        ((Intent)localObject).putExtra("extra_iconurl", EmojiStoreDetailUI.b(EmojiStoreDetailUI.this).IconUrl);
        ((Intent)localObject).putExtra("extra_name", EmojiStoreDetailUI.b(EmojiStoreDetailUI.this).PackName);
        if (EmojiStoreDetailUI.b(EmojiStoreDetailUI.this).PersonalDesigner != null) {
          ((Intent)localObject).putExtra("name", EmojiStoreDetailUI.b(EmojiStoreDetailUI.this).PersonalDesigner.Name);
        }
        paramAnonymousView = EmojiStoreDetailUI.this;
        localObject = new com.tencent.mm.hellhoundlib.b.a().bc(localObject);
        com.tencent.mm.hellhoundlib.a.a.a(paramAnonymousView, ((com.tencent.mm.hellhoundlib.b.a)localObject).ahE(), "com/tencent/mm/plugin/emoji/ui/EmojiStoreDetailUI$5", "onClick", "(Landroid/view/View;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
        paramAnonymousView.startActivity((Intent)((com.tencent.mm.hellhoundlib.b.a)localObject).mt(0));
        com.tencent.mm.hellhoundlib.a.a.a(paramAnonymousView, "com/tencent/mm/plugin/emoji/ui/EmojiStoreDetailUI$5", "onClick", "(Landroid/view/View;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/emoji/ui/EmojiStoreDetailUI$5", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(108995);
      }
    };
    this.mHandler = new aq()
    {
      public final void handleMessage(Message paramAnonymousMessage)
      {
        AppMethodBeat.i(108996);
        switch (paramAnonymousMessage.what)
        {
        default: 
          ae.w("MicroMsg.emoji.EmojiStoreDetailUI", "unknow message, cannt handle.");
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
        EmojiStoreDetailUI.this.cjB();
        AppMethodBeat.o(108996);
      }
    };
    this.pRv = new com.tencent.mm.av.a.c.l()
    {
      public final void sw(long paramAnonymousLong)
      {
        AppMethodBeat.i(176192);
        com.tencent.mm.plugin.report.service.g.yxI.kvStat(10930, EmojiStoreDetailUI.a(EmojiStoreDetailUI.this) + "," + paramAnonymousLong);
        AppMethodBeat.o(176192);
      }
    };
    this.pRw = new j.a()
    {
      public final void R(ArrayList<com.tencent.mm.pluginsdk.model.p> paramAnonymousArrayList)
      {
        AppMethodBeat.i(176191);
        int i;
        if (paramAnonymousArrayList == null)
        {
          i = 0;
          ae.i("MicroMsg.emoji.EmojiStoreDetailUI", "[onQueryFinish] %s", new Object[] { Integer.valueOf(i) });
          EmojiStoreDetailUI.B(EmojiStoreDetailUI.this);
          if ((paramAnonymousArrayList != null) && (paramAnonymousArrayList.size() > 0))
          {
            paramAnonymousArrayList = (com.tencent.mm.pluginsdk.model.p)paramAnonymousArrayList.get(0);
            ae.i("MicroMsg.emoji.EmojiStoreDetailUI", "onQueryFinish: %s", new Object[] { paramAnonymousArrayList });
            if (paramAnonymousArrayList.Fez != 10232) {
              break label175;
            }
            EmojiStoreDetailUI.a(EmojiStoreDetailUI.this, 4);
            EmojiStoreDetailUI.a(EmojiStoreDetailUI.this, paramAnonymousArrayList.Few);
            EmojiStoreDetailUI.b(EmojiStoreDetailUI.this, paramAnonymousArrayList.Fex);
            paramAnonymousArrayList = new BigDecimal(paramAnonymousArrayList.Fey).divide(new BigDecimal(1000000));
            EmojiStoreDetailUI.c(EmojiStoreDetailUI.this, paramAnonymousArrayList.toString());
          }
        }
        for (;;)
        {
          EmojiStoreDetailUI.this.Cp(1002);
          AppMethodBeat.o(176191);
          return;
          i = paramAnonymousArrayList.size();
          break;
          label175:
          EmojiStoreDetailUI.a(EmojiStoreDetailUI.this, 10);
          EmojiStoreDetailUI.b(EmojiStoreDetailUI.this, paramAnonymousArrayList.Fez);
        }
      }
    };
    AppMethodBeat.o(109009);
  }
  
  private void acJ(String paramString)
  {
    AppMethodBeat.i(109025);
    String str = paramString;
    if (TextUtils.isEmpty(paramString)) {
      str = getString(2131758285);
    }
    h.d(this, str, "", new DialogInterface.OnClickListener()
    {
      public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt) {}
    });
    AppMethodBeat.o(109025);
  }
  
  private void cjA()
  {
    AppMethodBeat.i(109031);
    if ((this.pOp.PersonalDesigner != null) && (this.pOp.PersonalDesigner.DesignerUin != 0) && (this.pQZ != 6))
    {
      this.pQR.setVisibility(0);
      this.pQO.setVisibility(0);
      com.tencent.mm.av.q.aJb().a(this.pOp.PersonalDesigner.HeadUrl, this.pQP, com.tencent.mm.plugin.emoji.e.e.fz(this.pMk, this.pOp.PersonalDesigner.HeadUrl));
      this.pQQ.setText(this.pOp.PersonalDesigner.Name);
      this.pQO.setOnClickListener(new View.OnClickListener()
      {
        public final void onClick(View paramAnonymousView)
        {
          AppMethodBeat.i(176185);
          Object localObject = new com.tencent.mm.hellhoundlib.b.b();
          ((com.tencent.mm.hellhoundlib.b.b)localObject).bd(paramAnonymousView);
          com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/emoji/ui/EmojiStoreDetailUI$13", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, ((com.tencent.mm.hellhoundlib.b.b)localObject).ahF());
          localObject = new Intent();
          ((Intent)localObject).setClass(EmojiStoreDetailUI.this.getContext(), EmojiStoreV2DesignerUI.class);
          ((Intent)localObject).putExtra("uin", EmojiStoreDetailUI.b(EmojiStoreDetailUI.this).PersonalDesigner.DesignerUin);
          ((Intent)localObject).putExtra("name", EmojiStoreDetailUI.b(EmojiStoreDetailUI.this).PersonalDesigner.Name);
          ((Intent)localObject).putExtra("headurl", EmojiStoreDetailUI.b(EmojiStoreDetailUI.this).PersonalDesigner.HeadUrl);
          ((Intent)localObject).putExtra("rediret_url", EmojiStoreDetailUI.b(EmojiStoreDetailUI.this).OldRedirectUrl);
          ((Intent)localObject).putExtra("searchID", EmojiStoreDetailUI.d(EmojiStoreDetailUI.this));
          ((Intent)localObject).putExtra("extra_scence", 26);
          paramAnonymousView = EmojiStoreDetailUI.this.getContext();
          localObject = new com.tencent.mm.hellhoundlib.b.a().bc(localObject);
          com.tencent.mm.hellhoundlib.a.a.a(paramAnonymousView, ((com.tencent.mm.hellhoundlib.b.a)localObject).ahE(), "com/tencent/mm/plugin/emoji/ui/EmojiStoreDetailUI$13", "onClick", "(Landroid/view/View;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
          paramAnonymousView.startActivity((Intent)((com.tencent.mm.hellhoundlib.b.a)localObject).mt(0));
          com.tencent.mm.hellhoundlib.a.a.a(paramAnonymousView, "com/tencent/mm/plugin/emoji/ui/EmojiStoreDetailUI$13", "onClick", "(Landroid/view/View;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/emoji/ui/EmojiStoreDetailUI$13", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
          AppMethodBeat.o(176185);
        }
      });
      AppMethodBeat.o(109031);
      return;
    }
    this.pQR.setVisibility(8);
    this.pQO.setVisibility(8);
    AppMethodBeat.o(109031);
  }
  
  private void cjC()
  {
    AppMethodBeat.i(109033);
    if ((this.pOp.PackFlag & 0x20) == 32)
    {
      localLayoutParams1 = (LinearLayout.LayoutParams)this.pQK.getLayoutParams();
      LinearLayout.LayoutParams localLayoutParams2 = (LinearLayout.LayoutParams)this.pQJ.getLayoutParams();
      this.pQK.setVisibility(0);
      localLayoutParams1.weight = 1.0F;
      localLayoutParams1.gravity = 3;
      localLayoutParams1.leftMargin = com.tencent.mm.cb.a.ax(getContext(), 2131165516);
      this.pQK.setLayoutParams(localLayoutParams1);
      this.pQK.setGravity(3);
      localLayoutParams2.weight = 1.0F;
      localLayoutParams2.gravity = 5;
      localLayoutParams2.rightMargin = com.tencent.mm.cb.a.ax(getContext(), 2131165516);
      this.pQJ.setLayoutParams(localLayoutParams2);
      this.pQJ.setGravity(5);
      AppMethodBeat.o(109033);
      return;
    }
    LinearLayout.LayoutParams localLayoutParams1 = (LinearLayout.LayoutParams)this.pQJ.getLayoutParams();
    localLayoutParams1.gravity = 17;
    this.pQJ.setLayoutParams(localLayoutParams1);
    this.pQJ.setGravity(17);
    this.pQK.setVisibility(8);
    AppMethodBeat.o(109033);
  }
  
  private void cjD()
  {
    AppMethodBeat.i(109034);
    if (com.tencent.mm.plugin.emoji.a.a.e.fl(this.pOp.PackType, 8))
    {
      this.pQY = 0;
      ae.i("MicroMsg.emoji.EmojiStoreDetailUI", "PackFlag:%d", new Object[] { Integer.valueOf(this.pOp.PackFlag) });
      if ((!com.tencent.mm.plugin.emoji.a.a.e.fl(this.pOp.PackFlag, 8)) || (!com.tencent.mm.plugin.emoji.a.a.e.Ck(this.pOp.PackType))) {
        break label164;
      }
      this.pQq = 8;
    }
    for (;;)
    {
      if (this.pQw) {
        this.pQq = 7;
      }
      AppMethodBeat.o(109034);
      return;
      if (com.tencent.mm.plugin.emoji.a.a.e.fl(this.pOp.PackType, 4))
      {
        this.pQY = 0;
        break;
      }
      if ((!this.pRb) && (TextUtils.isEmpty(this.pOp.PackPrice)))
      {
        this.pQY = 0;
        break;
      }
      this.pQY = 1;
      break;
      label164:
      if ((com.tencent.mm.plugin.emoji.a.a.e.fl(this.pOp.PackFlag, 1)) || (com.tencent.mm.plugin.emoji.a.a.e.fl(this.pOp.PackType, 8))) {
        this.pQq = 3;
      } else if (com.tencent.mm.plugin.emoji.a.a.e.Ck(this.pOp.PackType)) {
        this.pQq = 0;
      } else if ((!this.pRb) && ((TextUtils.isEmpty(this.pOp.PriceNum)) || (this.pOp.PriceNum.equals("0")))) {
        this.pQq = 0;
      } else if (this.pRb)
      {
        if (TextUtils.isEmpty(this.pRe)) {
          this.pQq = this.pRc;
        } else {
          this.pQq = 4;
        }
      }
      else {
        this.pQq = 4;
      }
    }
  }
  
  private void cjE()
  {
    AppMethodBeat.i(109035);
    if (com.tencent.mm.plugin.emoji.h.a.acY(this.pMk)) {
      cjy();
    }
    switch (this.pQq)
    {
    case 1: 
    case 2: 
    case 9: 
    default: 
      ae.w("MicroMsg.emoji.EmojiStoreDetailUI", "unknow product status:%d", new Object[] { Integer.valueOf(this.pQq) });
    }
    for (;;)
    {
      cjF();
      AppMethodBeat.o(109035);
      return;
      this.pQN.setVisibility(8);
      this.pQE.setTextColor(getResources().getColorStateList(2131100272));
      this.pQE.setBackgroundResource(2131231372);
      this.pQE.setText(2131758322);
      this.pQE.setEnabled(false);
      continue;
      this.pQN.setVisibility(8);
      this.pQE.setTextColor(getResources().getColorStateList(2131101185));
      this.pQE.setBackgroundResource(2131231365);
      this.pQE.setText(2131758319);
      this.pQE.setEnabled(true);
      continue;
      this.pQN.setVisibility(8);
      this.pQE.setTextColor(getResources().getColorStateList(2131101185));
      this.pQE.setBackgroundResource(2131231365);
      this.pQE.setEnabled(true);
      if (this.pRb)
      {
        if (bu.isNullOrNil(this.pRe)) {
          this.pQE.setText("");
        } else {
          this.pQE.setText(this.pRe);
        }
      }
      else
      {
        this.pQE.setText(this.pOp.PackPrice);
        this.pQq = 4;
        continue;
        this.pQN.setVisibility(8);
        this.pQE.setTextColor(getResources().getColorStateList(2131101185));
        this.pQE.setBackgroundResource(2131231365);
        this.pQE.setText(2131758319);
        this.pQE.setEnabled(true);
        continue;
        this.pQN.setVisibility(8);
        this.pQE.setEnabled(false);
        this.pQI.setVisibility(0);
        this.pQH.setVisibility(0);
        this.pQE.setVisibility(4);
        if (this.pQm != 3)
        {
          continue;
          this.pQN.setVisibility(8);
          this.pQE.setVisibility(0);
          this.pQE.setEnabled(true);
          if (this.pRo)
          {
            this.pQE.setText(2131758290);
            this.pQE.setTextColor(getResources().getColorStateList(2131100467));
            this.pQE.setBackgroundResource(2131231367);
          }
          for (;;)
          {
            this.pQI.setVisibility(8);
            this.pHl.setProgress(0);
            this.pQH.setVisibility(4);
            if (this.pQm == 3) {
              break;
            }
            break;
            this.pQE.setTextColor(getResources().getColorStateList(2131101185));
            this.pQE.setText(2131758388);
            this.pQE.setBackgroundResource(2131231365);
          }
          this.pQN.setVisibility(8);
          this.pQE.setBackgroundResource(2131231365);
          this.pQE.setText(2131758319);
          this.pQE.setEnabled(true);
          this.pQN.setVisibility(0);
          this.pQE.setVisibility(0);
          this.pQE.setBackgroundResource(2131234792);
          this.pQE.setText("");
          this.pQE.setEnabled(false);
          this.pQI.setVisibility(8);
          this.pHl.setProgress(0);
          this.pQH.setVisibility(4);
          continue;
          this.pQN.setVisibility(8);
          this.pQE.setVisibility(0);
          this.pQE.setBackgroundResource(2131231365);
          this.pQE.setText(2131758343);
          this.pQE.setEnabled(true);
          this.pQI.setVisibility(8);
          this.pHl.setProgress(0);
          this.pQH.setVisibility(4);
          continue;
          cjD();
          cjE();
        }
      }
    }
  }
  
  private void cjF()
  {
    AppMethodBeat.i(109036);
    if ((this.pRm) && ((this.pRl == null) || ((this.pRl.GRe & 0x1) != 1)) && ((this.pOp == null) || (!com.tencent.mm.plugin.emoji.a.a.e.fl(this.pOp.PackFlag, 1))) && (this.pRl != null) && (!TextUtils.isEmpty(this.pRl.GRd)))
    {
      this.pQE.setText(this.pRl.GRd);
      this.pQE.setTextColor(getContext().getResources().getColor(2131100482));
      this.pQE.setBackgroundDrawable(null);
      this.pQE.setEnabled(false);
    }
    AppMethodBeat.o(109036);
  }
  
  private void cjG()
  {
    AppMethodBeat.i(109037);
    if ((!com.tencent.mm.plugin.emoji.h.a.acY(this.pMk)) && ((this.pOp.ThumbExtList == null) || (this.pOp.ThumbExtList.size() <= 0) || (((PackThumbExt)this.pOp.ThumbExtList.get(0)).PreviewUrl == null))) {
      this.pRj.setVisibility(8);
    }
    for (;;)
    {
      this.pQG.setProductId(this.pMk);
      if (this.pQu != null) {
        this.pQu.notifyDataSetInvalidated();
      }
      AppMethodBeat.o(109037);
      return;
      this.pRj.setVisibility(0);
    }
  }
  
  private void cjH()
  {
    AppMethodBeat.i(109038);
    ae.d("MicroMsg.emoji.EmojiStoreDetailUI", "mData.PackFlag:%s", new Object[] { this.pOp.PackFlag });
    if ((this.pOp.PackFlag & 0x10) == 16) {
      addIconOptionMenu(0, 2131690655, new MenuItem.OnMenuItemClickListener()
      {
        public final boolean onMenuItemClick(MenuItem paramAnonymousMenuItem)
        {
          AppMethodBeat.i(176186);
          ae.d("MicroMsg.emoji.EmojiStoreDetailUI", "on shard click.");
          EmojiStoreDetailUI.r(EmojiStoreDetailUI.this);
          AppMethodBeat.o(176186);
          return true;
        }
      });
    }
    AppMethodBeat.o(109038);
  }
  
  private void cjI()
  {
    AppMethodBeat.i(109039);
    h.a(this, 2131758311, 0, 2131758376, 2131758314, new DialogInterface.OnClickListener()new DialogInterface.OnClickListener
    {
      public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
      {
        AppMethodBeat.i(176187);
        if (com.tencent.mm.plugin.emoji.h.a.acY(EmojiStoreDetailUI.a(EmojiStoreDetailUI.this)))
        {
          ae.d("MicroMsg.emoji.EmojiStoreDetailUI", "jacks stop tuzi downloading");
          com.tencent.mm.plugin.emoji.f.a.cin().cip();
          if (!TextUtils.isEmpty(EmojiStoreDetailUI.t(EmojiStoreDetailUI.this)))
          {
            com.tencent.mm.an.f.aGZ().Fs(EmojiStoreDetailUI.t(EmojiStoreDetailUI.this));
            ae.i("MicroMsg.emoji.EmojiStoreDetailUI", "[onClickClose] cancel RecvTask. CdnClientId:%s", new Object[] { EmojiStoreDetailUI.t(EmojiStoreDetailUI.this) });
          }
          if ((!com.tencent.mm.plugin.emoji.a.a.e.fl(EmojiStoreDetailUI.b(EmojiStoreDetailUI.this).PackFlag, 1)) && (!com.tencent.mm.plugin.emoji.a.a.e.Ck(EmojiStoreDetailUI.b(EmojiStoreDetailUI.this).PackType))) {
            break label262;
          }
          EmojiStoreDetailUI.a(EmojiStoreDetailUI.this, 3);
        }
        for (;;)
        {
          com.tencent.mm.plugin.emoji.model.k.cil().h(EmojiStoreDetailUI.a(EmojiStoreDetailUI.this), EmojiStoreDetailUI.u(EmojiStoreDetailUI.this), 0, EmojiStoreDetailUI.t(EmojiStoreDetailUI.this));
          EmojiStoreDetailUI.i(EmojiStoreDetailUI.this).setVisibility(8);
          EmojiStoreDetailUI.l(EmojiStoreDetailUI.this).setProgress(0);
          EmojiStoreDetailUI.j(EmojiStoreDetailUI.this).setVisibility(4);
          EmojiStoreDetailUI.h(EmojiStoreDetailUI.this).setVisibility(0);
          EmojiStoreDetailUI.v(EmojiStoreDetailUI.this);
          EmojiStoreDetailUI.g(EmojiStoreDetailUI.this);
          paramAnonymousDialogInterface = new com.tencent.mm.plugin.emoji.f.q(EmojiStoreDetailUI.a(EmojiStoreDetailUI.this), 2);
          com.tencent.mm.kernel.g.ajQ().gDv.a(paramAnonymousDialogInterface, 0);
          AppMethodBeat.o(176187);
          return;
          com.tencent.mm.kernel.g.ajQ().gDv.a(EmojiStoreDetailUI.s(EmojiStoreDetailUI.this));
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
  
  private void cjJ()
  {
    AppMethodBeat.i(109041);
    if (com.tencent.mm.plugin.emoji.h.a.acY(this.pMk))
    {
      com.tencent.mm.plugin.emoji.f.a.cin();
      com.tencent.mm.plugin.emoji.f.a.cio();
      AppMethodBeat.o(109041);
      return;
    }
    this.pQs = new com.tencent.mm.plugin.emoji.f.g(this.pMk, this.pMm, this.pMl);
    com.tencent.mm.kernel.g.ajQ().gDv.a(this.pQs, 0);
    switch (this.pNX)
    {
    }
    for (;;)
    {
      AppMethodBeat.o(109041);
      return;
      com.tencent.mm.plugin.report.service.g.yxI.f(11598, new Object[] { Integer.valueOf(1), this.pMk });
      AppMethodBeat.o(109041);
      return;
      com.tencent.mm.plugin.report.service.g.yxI.f(11598, new Object[] { Integer.valueOf(3), this.pMk });
      AppMethodBeat.o(109041);
      return;
      com.tencent.mm.plugin.report.service.g.yxI.f(11598, new Object[] { Integer.valueOf(2), this.pMk });
    }
  }
  
  private void cju()
  {
    AppMethodBeat.i(109021);
    this.GG.setVisibility(0);
    this.pQy.setVisibility(8);
    this.pQz.setVisibility(8);
    this.pQx.setText(2131758269);
    AppMethodBeat.o(109021);
  }
  
  private void cjv()
  {
    AppMethodBeat.i(109022);
    ae.i("MicroMsg.emoji.EmojiStoreDetailUI", "[handleLoadDataFailed]");
    if ((this.pOp == null) || (this.pOp.PackFlag == 0))
    {
      this.GG.setVisibility(0);
      this.pQy.setVisibility(8);
    }
    AppMethodBeat.o(109022);
  }
  
  private void cjw()
  {
    AppMethodBeat.i(109026);
    this.pQv = com.tencent.mm.plugin.emoji.model.k.getEmojiStorageMgr().JfZ.aWv(this.pMk);
    AppMethodBeat.o(109026);
  }
  
  private void cjx()
  {
    AppMethodBeat.i(109027);
    if ((com.tencent.mm.plugin.emoji.a.a.e.fl(this.pOp.PackFlag, 64)) && (com.tencent.mm.emoji.a.m.afh()))
    {
      this.pQt = new com.tencent.mm.plugin.emoji.f.o(this.pMk, com.tencent.mm.plugin.emoji.f.o.pMK);
      com.tencent.mm.kernel.g.ajQ().gDv.a(this.pQt, 0);
    }
    AppMethodBeat.o(109027);
  }
  
  private boolean cjy()
  {
    AppMethodBeat.i(109028);
    boolean bool = com.tencent.mm.plugin.emoji.h.a.cjy();
    this.pQw = bool;
    if (bool) {}
    for (int i = 7;; i = 3)
    {
      this.pQq = i;
      AppMethodBeat.o(109028);
      return bool;
    }
  }
  
  private void cjz()
  {
    AppMethodBeat.i(109029);
    if (!bu.isNullOrNil(this.pOp.PackName))
    {
      setMMTitle(this.pOp.PackName);
      this.pMl = this.pOp.PackName;
    }
    ae.d("MicroMsg.emoji.EmojiStoreDetailUI", "mData.PanelUrl:%s", new Object[] { this.pOp.PanelUrl });
    this.pQy.setVisibility(0);
    this.GG.setVisibility(8);
    kr(true);
    this.pQC.setText(this.pOp.PackName);
    this.pQD.setText(this.pOp.PackCopyright);
    this.pQF.setText(this.pOp.PackDesc);
    if (com.tencent.mm.plugin.emoji.a.a.e.fl(this.pOp.PackType, 1)) {
      this.pQB.setVisibility(8);
    }
    for (;;)
    {
      cjD();
      cjE();
      cjF();
      cjG();
      cjH();
      this.pQC.setMaxWidth(this.pQL - this.pQM.getWidth() - com.tencent.mm.cb.a.ax(getContext(), 2131165516) * 2 - this.pQB.getWidth() - com.tencent.mm.cb.a.ax(getContext(), 2131165489) * 2);
      this.pQC.setVisibility(8);
      this.pQC.setVisibility(0);
      cjA();
      cjC();
      cjB();
      AppMethodBeat.o(109029);
      return;
      this.pQB.setVisibility(0);
      this.pQB.setText(2131758411);
    }
  }
  
  private void kr(boolean paramBoolean)
  {
    AppMethodBeat.i(109030);
    Object localObject = null;
    String str;
    if (!bu.isNullOrNil(this.pOp.CoverUrl))
    {
      if (!paramBoolean) {
        break label104;
      }
      localObject = this.pMk;
      str = this.pOp.CoverUrl;
      com.tencent.mm.cb.a.getDensity(this.mContext);
    }
    for (localObject = EmojiLogic.a((String)localObject, str, pRu);; localObject = EmojiLogic.A((String)localObject, 4, str))
    {
      if ((localObject != null) && (this.pQA != null)) {
        this.pQA.setImageFilePath(((EmojiInfo)localObject).fSQ());
      }
      if (com.tencent.mm.plugin.emoji.h.a.acY(this.pMk)) {
        this.pQA.setImageResource(2131234433);
      }
      AppMethodBeat.o(109030);
      return;
      label104:
      localObject = this.pMk;
      str = this.pOp.CoverUrl;
      com.tencent.mm.cb.a.getDensity(this.mContext);
    }
  }
  
  public final void Cp(int paramInt)
  {
    AppMethodBeat.i(109042);
    if (this.mHandler != null) {
      this.mHandler.sendEmptyMessage(paramInt);
    }
    AppMethodBeat.o(109042);
  }
  
  public final void a(String paramString, com.tencent.mm.sdk.e.m paramm)
  {
    AppMethodBeat.i(109024);
    Cp(1001);
    AppMethodBeat.o(109024);
  }
  
  public final void cjB()
  {
    AppMethodBeat.i(109032);
    if ((com.tencent.mm.plugin.emoji.a.a.e.fl(this.pOp.PackFlag, 64)) && (com.tencent.mm.emoji.a.m.afh()))
    {
      if (this.pQv != null)
      {
        this.pQS.setVisibility(0);
        this.pQU.setText(2131758352);
        this.pQT.setText(this.pQv.Reward.Gxe);
        this.pQT.setLongClickable(false);
        if (this.pQv.DonorNum > 0)
        {
          this.pQW.setVisibility(0);
          String str1 = String.valueOf(this.pQv.DonorNum);
          String str2 = String.format(getString(2131758356), new Object[] { Integer.valueOf(this.pQv.DonorNum) });
          SpannableString localSpannableString = new SpannableString(str2);
          int i = str2.indexOf(str1);
          if (i >= 0) {
            localSpannableString.setSpan(new ForegroundColorSpan(getResources().getColor(2131100286)), i, str1.length() + i, 33);
          }
          this.pQW.setText(localSpannableString);
        }
        while ((this.pQv.Donors != null) && (this.pQv.Donors.size() > 0))
        {
          this.pQV.setVisibility(0);
          this.pQV.d(this.pMk, this.pQv.Donors);
          AppMethodBeat.o(109032);
          return;
          this.pQW.setVisibility(8);
        }
        this.pQV.setVisibility(8);
        AppMethodBeat.o(109032);
        return;
      }
      this.pQS.setVisibility(8);
      cjx();
      AppMethodBeat.o(109032);
      return;
    }
    this.pQS.setVisibility(8);
    AppMethodBeat.o(109032);
  }
  
  public int getForceOrientation()
  {
    return 1;
  }
  
  public int getLayoutId()
  {
    return 2131493794;
  }
  
  public final void i(String paramString1, int paramInt1, int paramInt2, String paramString2)
  {
    AppMethodBeat.i(109040);
    ae.d("MicroMsg.emoji.EmojiStoreDetailUI", "productId:%s,status:%d, progress:%d, cdnClientID:%s, ", new Object[] { paramString1, Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), paramString2 });
    if ((bu.isNullOrNil(paramString1)) || (!paramString1.equals(this.pMk)))
    {
      AppMethodBeat.o(109040);
      return;
    }
    if (!TextUtils.isEmpty(paramString2)) {
      this.pRa = paramString2;
    }
    if (paramInt1 == -1)
    {
      if (this.pQq != -1)
      {
        this.pQq = -1;
        Cp(1003);
        AppMethodBeat.o(109040);
      }
    }
    else
    {
      if (paramInt1 == 7)
      {
        this.pQq = 7;
        Cp(1003);
        AppMethodBeat.o(109040);
        return;
      }
      if (paramInt1 == 6)
      {
        if ((!TextUtils.isEmpty(paramString1)) && (paramString1.equals(this.pMk)))
        {
          this.pQq = 6;
          this.Hx = paramInt2;
          Cp(1004);
          AppMethodBeat.o(109040);
        }
      }
      else {
        ae.w("MicroMsg.emoji.EmojiStoreDetailUI", "[onExchange] do nothing.");
      }
    }
    AppMethodBeat.o(109040);
  }
  
  public void initView()
  {
    AppMethodBeat.i(109011);
    if (!bu.isNullOrNil(this.pMl)) {
      setMMTitle(this.pMl);
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
    this.mPadding = com.tencent.mm.cb.a.ax(this.mContext, 2131166211);
    this.pQX = getResources().getDimensionPixelSize(2131166210);
    this.pQX = com.tencent.mm.cb.a.ax(this.mContext, 2131166210);
    this.mNumColumns = 4;
    this.pQz = ((EmojiDetailScrollView)findViewById(2131304379));
    this.GG = findViewById(2131299457);
    this.pQx = ((TextView)this.GG.findViewById(2131299461));
    this.pQy = findViewById(2131299441);
    this.pQA = ((BannerEmojiView)findViewById(2131299378));
    int i = this.pQA.getRight();
    int j = this.pQA.getLeft();
    int k = this.pQA.getPaddingRight();
    int m = this.pQA.getPaddingLeft();
    this.pQA.setMinimumHeight((int)((i - j - k - m) * 0.56F));
    this.pQB = ((TextView)findViewById(2131299451));
    this.pQC = ((MMAutoSizeTextView)findViewById(2131299452));
    this.pQD = ((TextView)findViewById(2131299362));
    this.pQE = ((TextView)findViewById(2131299454));
    this.pQF = ((TextView)findViewById(2131299366));
    this.pQL = com.tencent.mm.cb.a.iu(getContext());
    this.pQM = findViewById(2131299330);
    this.pQG = ((EmojiDetailGridView)findViewById(2131299374));
    ProgressBar localProgressBar;
    if (com.tencent.mm.plugin.emoji.h.a.acY(this.pMk))
    {
      this.pQu = new b();
      this.pQI = findViewById(2131299429);
      this.pHl = ((ProgressBar)findViewById(2131299369));
      this.pQH = ((ImageView)findViewById(2131299360));
      this.pQH.setOnClickListener(this);
      this.pQI.setVisibility(8);
      this.pQH.setVisibility(8);
      this.pHl.setProgress(0);
      this.pQG.setAdapter(this.pQu);
      this.pQG.setColumnWidth(this.pQX);
      this.pQG.setNumColumns(this.mNumColumns);
      this.pQG.setHorizontalSpacing(this.mPadding);
      this.pQG.setVerticalSpacing(this.mPadding);
      this.pQG.setEmojiDetailScrollView(this.pQz);
      this.pQG.setFromDetail(true);
      this.pQG.setIsShowPopWin(true);
      this.pQG.setOnItemClickListener(new AdapterView.OnItemClickListener()
      {
        public final void onItemClick(AdapterView<?> paramAnonymousAdapterView, View paramAnonymousView, int paramAnonymousInt, long paramAnonymousLong)
        {
          AppMethodBeat.i(176183);
          com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
          localb.bd(paramAnonymousAdapterView);
          localb.bd(paramAnonymousView);
          localb.mu(paramAnonymousInt);
          localb.rl(paramAnonymousLong);
          com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/emoji/ui/EmojiStoreDetailUI$10", "android/widget/AdapterView$OnItemClickListener", "onItemClick", "(Landroid/widget/AdapterView;Landroid/view/View;IJ)V", this, localb.ahF());
          paramAnonymousAdapterView = paramAnonymousAdapterView.getAdapter().getItem(paramAnonymousInt);
          if ((paramAnonymousAdapterView instanceof EmojiInfo))
          {
            paramAnonymousAdapterView = (EmojiInfo)paramAnonymousAdapterView;
            paramAnonymousView = new agk();
            if ((bu.isNullOrNil(paramAnonymousView.Md5)) || (paramAnonymousView.Md5.equals(paramAnonymousAdapterView.field_md5)))
            {
              paramAnonymousView.Md5 = com.tencent.mm.plugin.emoji.h.b.fE(paramAnonymousAdapterView.field_md5, paramAnonymousView.Md5);
              paramAnonymousView.Md5 = com.tencent.mm.plugin.emoji.h.b.fE(paramAnonymousView.Md5, "");
              paramAnonymousView.Url = com.tencent.mm.plugin.emoji.h.b.fE(paramAnonymousAdapterView.field_cdnUrl, paramAnonymousView.Url);
              paramAnonymousView.ThumbUrl = com.tencent.mm.plugin.emoji.h.b.fE(paramAnonymousAdapterView.field_thumbUrl, paramAnonymousView.ThumbUrl);
              paramAnonymousView.GwF = com.tencent.mm.plugin.emoji.h.b.fE(paramAnonymousAdapterView.field_designerID, paramAnonymousView.GwF);
              paramAnonymousView.EncryptUrl = com.tencent.mm.plugin.emoji.h.b.fE(paramAnonymousAdapterView.field_encrypturl, paramAnonymousView.EncryptUrl);
              paramAnonymousView.AesKey = com.tencent.mm.plugin.emoji.h.b.fE(paramAnonymousAdapterView.field_aeskey, paramAnonymousView.AesKey);
              paramAnonymousView.ProductID = com.tencent.mm.plugin.emoji.h.b.fE(paramAnonymousAdapterView.field_groupId, paramAnonymousView.ProductID);
              paramAnonymousView.ExternUrl = com.tencent.mm.plugin.emoji.h.b.fE(paramAnonymousAdapterView.field_externUrl, paramAnonymousView.ExternUrl);
              paramAnonymousView.ExternMd5 = com.tencent.mm.plugin.emoji.h.b.fE(paramAnonymousAdapterView.field_externMd5, paramAnonymousView.ExternMd5);
              paramAnonymousView.ActivityID = com.tencent.mm.plugin.emoji.h.b.fE(paramAnonymousAdapterView.field_activityid, paramAnonymousView.ActivityID);
              paramAnonymousView.GwG = com.tencent.mm.plugin.emoji.h.b.fE(paramAnonymousAdapterView.field_attachedText, paramAnonymousView.GwG);
              paramAnonymousView.GwH = com.tencent.mm.plugin.emoji.h.b.fE(paramAnonymousAdapterView.field_attachTextColor, paramAnonymousView.GwH);
              paramAnonymousView.GwI = com.tencent.mm.plugin.emoji.h.b.fE(paramAnonymousAdapterView.field_lensId, paramAnonymousView.GwI);
            }
            EmojiStoreDetailUI.a(EmojiStoreDetailUI.this, paramAnonymousView);
            com.tencent.mm.plugin.report.service.g.yxI.f(12787, new Object[] { Integer.valueOf(0), Integer.valueOf(0), paramAnonymousAdapterView.field_md5, Long.valueOf(EmojiStoreDetailUI.d(EmojiStoreDetailUI.this)), paramAnonymousAdapterView.field_designerID, paramAnonymousAdapterView.field_groupId, Integer.valueOf(26) });
          }
          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/emoji/ui/EmojiStoreDetailUI$10", "android/widget/AdapterView$OnItemClickListener", "onItemClick", "(Landroid/widget/AdapterView;Landroid/view/View;IJ)V");
          AppMethodBeat.o(176183);
        }
      });
      this.pQE.setOnClickListener(this);
      this.pQJ = ((TextView)findViewById(2131299433));
      this.pQK = ((TextView)findViewById(2131299361));
      this.pQJ.setOnClickListener(this.pRq);
      this.pQK.setOnClickListener(this.pRr);
      this.pQN = ((ProgressBar)findViewById(2131299372));
      localProgressBar = this.pQN;
      if (!this.pRb) {
        break label767;
      }
    }
    label767:
    for (i = 0;; i = 8)
    {
      localProgressBar.setVisibility(i);
      this.pRj = findViewById(2131299386);
      this.pQR = findViewById(2131299365);
      this.pQO = findViewById(2131299016);
      this.pQP = ((ImageView)findViewById(2131299022));
      this.pQQ = ((TextView)findViewById(2131299032));
      this.pQS = findViewById(2131299430);
      this.pQT = ((TextView)findViewById(2131304153));
      this.pQU = ((Button)findViewById(2131304154));
      this.pQW = ((TextView)findViewById(2131304158));
      this.pQV = ((DonorsAvatarView)findViewById(2131304152));
      this.pQU.setOnClickListener(this.pRs);
      this.pQW.setOnClickListener(this.pRt);
      AppMethodBeat.o(109011);
      return;
      this.pQu = new a();
      break;
    }
  }
  
  public void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    AppMethodBeat.i(109023);
    ae.d("MicroMsg.emoji.EmojiStoreDetailUI", "onActivityResult. requestCode:[%d] resultCode:[%d]", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) });
    String str;
    if (paramInt1 == 2001)
    {
      str = "";
      if (paramIntent == null) {
        break label759;
      }
      paramInt1 = paramIntent.getIntExtra("key_err_code", 0);
      ae.w("MicroMsg.emoji.EmojiStoreDetailUI", "errCode:".concat(String.valueOf(paramInt1)));
      str = paramIntent.getStringExtra("key_err_msg");
      ae.w("MicroMsg.emoji.EmojiStoreDetailUI", "errMsg:".concat(String.valueOf(str)));
    }
    for (;;)
    {
      this.pRi = false;
      if (paramInt2 == -1)
      {
        if ((paramIntent != null) && (paramInt1 == 0))
        {
          ArrayList localArrayList = paramIntent.getStringArrayListExtra("key_response_product_ids");
          paramIntent = paramIntent.getStringArrayListExtra("key_response_series_ids");
          if ((localArrayList != null) && (localArrayList.contains(this.pMk)))
          {
            paramInt1 = 0;
            while (paramInt1 < localArrayList.size())
            {
              if (this.pMk.equals(localArrayList.get(paramInt1))) {
                this.pMm = ((String)paramIntent.get(paramInt1));
              }
              paramInt1 += 1;
            }
            this.pOp.PackFlag = 1;
            cjJ();
            this.pQq = 6;
            h.cm(this, str);
            if (v.aAQ())
            {
              com.tencent.mm.plugin.report.service.g.yxI.idkeyStat(166L, 4L, 1L, false);
              AppMethodBeat.o(109023);
              return;
            }
            com.tencent.mm.plugin.report.service.g.yxI.idkeyStat(166L, 0L, 1L, false);
            AppMethodBeat.o(109023);
            return;
          }
          this.pQq = -1;
          cjE();
          acJ(str);
          AppMethodBeat.o(109023);
          return;
        }
        if ((paramIntent != null) && (paramInt1 == 100000002))
        {
          cjJ();
          this.pQq = 6;
          this.pQu.notifyDataSetChanged();
          if (v.aAQ())
          {
            com.tencent.mm.plugin.report.service.g.yxI.idkeyStat(166L, 7L, 1L, false);
            AppMethodBeat.o(109023);
            return;
          }
          com.tencent.mm.plugin.report.service.g.yxI.idkeyStat(166L, 3L, 1L, false);
          AppMethodBeat.o(109023);
          return;
        }
        if ((paramIntent != null) && (paramInt1 == 1))
        {
          this.pQq = -1;
          cjE();
          if (v.aAQ())
          {
            com.tencent.mm.plugin.report.service.g.yxI.idkeyStat(166L, 6L, 1L, false);
            AppMethodBeat.o(109023);
            return;
          }
          com.tencent.mm.plugin.report.service.g.yxI.idkeyStat(166L, 2L, 1L, false);
          AppMethodBeat.o(109023);
          return;
        }
        this.pQq = -1;
        cjE();
        acJ(str);
        if (v.aAQ())
        {
          com.tencent.mm.plugin.report.service.g.yxI.idkeyStat(166L, 5L, 1L, false);
          AppMethodBeat.o(109023);
          return;
        }
        com.tencent.mm.plugin.report.service.g.yxI.idkeyStat(166L, 1L, 1L, false);
        AppMethodBeat.o(109023);
        return;
      }
      this.pQq = -1;
      cjE();
      if (v.aAQ())
      {
        com.tencent.mm.plugin.report.service.g.yxI.idkeyStat(166L, 6L, 1L, false);
        AppMethodBeat.o(109023);
        return;
      }
      com.tencent.mm.plugin.report.service.g.yxI.idkeyStat(166L, 2L, 1L, false);
      AppMethodBeat.o(109023);
      return;
      if (paramInt1 == 2002)
      {
        if (paramInt2 == -1)
        {
          paramIntent = paramIntent.getStringExtra("Select_Conv_User");
          if (!bu.isNullOrNil(paramIntent))
          {
            ae.d("MicroMsg.emoji.EmojiStoreDetailUI", "..".concat(String.valueOf(paramIntent)));
            com.tencent.mm.plugin.emoji.e.j.a(this, paramIntent, this.pMk, this.pOp.PackName, this.pOp.PackDesc, this.pOp.IconUrl, this.pOp.OldRedirectUrl, this.pOp.PackFlag);
          }
          AppMethodBeat.o(109023);
        }
      }
      else if (paramInt1 == this.pLt.mGN)
      {
        if (paramInt2 == -1)
        {
          ae.d("MicroMsg.emoji.EmojiStoreDetailUI", "jacks use emoji to : %s", new Object[] { paramIntent.getStringExtra("Select_Conv_User") });
          com.tencent.mm.plugin.emoji.h.c.a(paramIntent, this.pMk, this);
          com.tencent.mm.plugin.report.service.g.yxI.f(12069, new Object[] { Integer.valueOf(3), this.pMk });
          AppMethodBeat.o(109023);
        }
      }
      else if ((paramInt1 == 2004) && (paramInt2 == -1)) {
        com.tencent.mm.ui.widget.snackbar.b.n(this, getContext().getString(2131755887));
      }
      AppMethodBeat.o(109023);
      return;
      label759:
      paramInt1 = 0;
    }
  }
  
  public void onClick(View paramView)
  {
    AppMethodBeat.i(109019);
    com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
    localb.bd(paramView);
    com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/emoji/ui/EmojiStoreDetailUI", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.ahF());
    int i = paramView.getId();
    if (i == 2131299454)
    {
      if (this.pQq == 7)
      {
        paramView = getIntent().getStringExtra("to_talker_name");
        if (this.pRo)
        {
          paramView = new com.tencent.mm.plugin.emoji.f.q(this.pMk, 2);
          com.tencent.mm.kernel.g.ajQ().gDv.a(paramView, 0);
          this.pRp = com.tencent.mm.ui.base.p.a(this, getString(2131760706), true, 0, null);
          ae.d("MicroMsg.emoji.EmojiStoreDetailUI", "jacks kv stat update click use emoji");
          com.tencent.mm.plugin.report.service.g.yxI.kvStat(11076, "0, ");
        }
      }
      for (;;)
      {
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/emoji/ui/EmojiStoreDetailUI", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(109019);
        return;
        if ((!bu.isNullOrNil(paramView)) && (this.pQp))
        {
          com.tencent.mm.plugin.emoji.h.c.a(paramView, this.pMk, this);
          break;
        }
        this.pLt.P(this);
        com.tencent.mm.plugin.report.service.g.yxI.f(12069, new Object[] { Integer.valueOf(2), this.pMk });
        break;
        switch (this.pQq)
        {
        case 1: 
        case 2: 
        case 6: 
        case 7: 
        case 8: 
        case 9: 
        default: 
          ae.e("MicroMsg.emoji.EmojiStoreDetailUI", "can not product status.%d", new Object[] { Integer.valueOf(this.pQq) });
          break;
        case 4: 
          if (!this.pRi)
          {
            if (this.pRo)
            {
              paramView = com.tencent.mm.emoji.b.d.grb;
              com.tencent.mm.emoji.b.d.md(6);
            }
            ae.i("MicroMsg.emoji.EmojiStoreDetailUI", "mProductId:%s, mData.PackPrice:%s,PriceType:%s", new Object[] { this.pMk, this.pOp.PackPrice, this.pOp.PriceType });
            paramView = new Intent();
            paramView.putExtra("key_product_id", this.pMk);
            if (this.pRb)
            {
              paramView.putExtra("key_currency_type", this.pRf);
              paramView.putExtra("key_price", this.pRf + this.pRg);
            }
            for (;;)
            {
              com.tencent.mm.br.d.b(this, "wallet_index", ".ui.WalletIapUI", paramView, 2001);
              com.tencent.mm.plugin.report.service.g.yxI.f(12066, new Object[] { Integer.valueOf(2), Integer.valueOf(this.pQZ), "", this.pMk, Long.valueOf(this.pLp), this.pLq });
              this.pRi = true;
              break;
              paramView.putExtra("key_currency_type", this.pOp.PriceType);
              paramView.putExtra("key_price", this.pOp.PriceNum);
            }
          }
          break;
        case 0: 
        case 3: 
          if (this.pRo)
          {
            paramView = com.tencent.mm.emoji.b.d.grb;
            com.tencent.mm.emoji.b.d.md(6);
          }
          cjJ();
          this.pQq = 6;
          cjE();
          com.tencent.mm.plugin.report.service.g.yxI.f(12066, new Object[] { Integer.valueOf(1), Integer.valueOf(this.pQZ), "", this.pMk, Long.valueOf(this.pLp), this.pLq });
          if (this.pLv != null)
          {
            this.pLv.dVT = 4;
            this.pLv.aLH();
          }
          break;
        case 5: 
          this.pQq = 3;
          cjE();
          break;
        case 10: 
        case 12: 
          switch (this.pRd)
          {
          default: 
            paramView = getString(2131758412);
          }
          for (;;)
          {
            h.c(this, paramView, null, true);
            break;
            paramView = getString(2131758261);
            continue;
            paramView = getString(2131758270);
            continue;
            paramView = getString(2131758407);
          }
        case 11: 
          ae.i("MicroMsg.emoji.EmojiStoreDetailUI", "can not be clicked.");
          break;
        case -1: 
          ae.i("MicroMsg.emoji.EmojiStoreDetailUI", "can not be clicked.");
        }
      }
    }
    if (i == 2131299369)
    {
      cjI();
      com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/emoji/ui/EmojiStoreDetailUI", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
      AppMethodBeat.o(109019);
      return;
    }
    if (i == 2131299360)
    {
      cjI();
      com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/emoji/ui/EmojiStoreDetailUI", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
      AppMethodBeat.o(109019);
      return;
    }
    ae.w("MicroMsg.emoji.EmojiStoreDetailUI", "click view is unknow.");
    com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/emoji/ui/EmojiStoreDetailUI", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
    AppMethodBeat.o(109019);
  }
  
  public void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(109010);
    super.onCreate(paramBundle);
    if (!com.tencent.mm.kernel.g.ajM())
    {
      finish();
      AppMethodBeat.o(109010);
      return;
    }
    this.pRb = v.aAQ();
    this.pLt = new com.tencent.mm.plugin.emoji.h.c(2003);
    paramBundle = getIntent();
    this.pMk = getIntent().getStringExtra("extra_id");
    this.pNX = getIntent().getIntExtra("preceding_scence", -1);
    this.pMl = getIntent().getStringExtra("extra_name");
    this.pQm = getIntent().getIntExtra("call_by", -1);
    Object localObject = getIntent().getStringExtra("sns_object_data");
    if (!TextUtils.isEmpty((CharSequence)localObject))
    {
      this.pMk = EmojiLogic.acq((String)localObject);
      this.pNX = 0;
      this.pNX = 10;
      com.tencent.mm.plugin.report.service.g.yxI.f(10993, new Object[] { Integer.valueOf(3), this.pMk });
    }
    if (TextUtils.isEmpty(this.pMk))
    {
      ae.d("MicroMsg.emoji.EmojiStoreDetailUI", "[hadleIntent] product id is null.");
      finish();
    }
    if (this.pNX == -1)
    {
      ae.e("MicroMsg.emoji.EmojiStoreDetailUI", "[hadleIntent] emoticon preceding scence no set!");
      finish();
    }
    this.pRk = paramBundle.getBooleanExtra("check_clickflag", true);
    this.pRa = paramBundle.getStringExtra("cdn_client_id");
    this.pQZ = paramBundle.getIntExtra("download_entrance_scene", 0);
    this.pRo = paramBundle.getBooleanExtra("from_popup", false);
    this.pLp = paramBundle.getLongExtra("searchID", 0L);
    this.pLq = bu.bI(paramBundle.getStringExtra("docID"), "");
    localObject = paramBundle.getStringExtra("extra_copyright");
    if (!TextUtils.isEmpty((CharSequence)localObject)) {
      this.pOp.PackCopyright = ((String)localObject);
    }
    localObject = paramBundle.getStringExtra("extra_coverurl");
    if (!TextUtils.isEmpty((CharSequence)localObject)) {
      this.pOp.CoverUrl = ((String)localObject);
    }
    localObject = paramBundle.getStringExtra("extra_description");
    if (!TextUtils.isEmpty((CharSequence)localObject)) {
      this.pOp.PackDesc = ((String)localObject);
    }
    localObject = paramBundle.getStringExtra("extra_price");
    if (!TextUtils.isEmpty((CharSequence)localObject)) {
      this.pOp.PackPrice = ((String)localObject);
    }
    int i = paramBundle.getIntExtra("extra_type", -1);
    if (i != -1) {
      this.pOp.PackType = i;
    }
    i = paramBundle.getIntExtra("extra_flag", -1);
    if (i != -1) {
      this.pOp.PackFlag = i;
    }
    localObject = paramBundle.getStringExtra("extra_price_type");
    if (!TextUtils.isEmpty((CharSequence)localObject)) {
      this.pOp.PriceType = ((String)localObject);
    }
    localObject = paramBundle.getStringExtra("extra_price_num");
    if (!TextUtils.isEmpty((CharSequence)localObject)) {
      this.pOp.PriceNum = ((String)localObject);
    }
    if (this.pRb)
    {
      this.pRc = 11;
      com.tencent.mm.pluginsdk.model.j.a(this, this.pRh, this.pRw);
    }
    this.pQo = paramBundle.getBooleanExtra("reward_tip", false);
    paramBundle = paramBundle.getStringExtra("action_report");
    if (!bu.isNullOrNil(paramBundle)) {
      this.pLv = new com.tencent.mm.g.b.a.z(paramBundle);
    }
    this.pRh[0] = this.pMk;
    this.pOp.ProductID = this.pMk;
    this.pOp.PackName = this.pMl;
    this.pOp.ShareDesc = this.pQn;
    this.pOp.PriceNum = "-1";
    this.pOp.Version = -1;
    this.mContext = this;
    pRu.cyH = new WeakReference(this);
    initView();
    if (!com.tencent.mm.plugin.emoji.h.a.acY(this.pMk)) {
      if (this.pOp == null)
      {
        this.pQr = new com.tencent.mm.plugin.emoji.f.l(this.pMk, this.pNX);
        com.tencent.mm.kernel.g.ajQ().gDv.a(this.pQr, 0);
        if ((this.pQm == -1) || (this.pQm == 3))
        {
          this.pQy.setVisibility(8);
          this.GG.setVisibility(8);
          getString(2131755906);
          this.jbE = h.b(this, getString(2131755936), true, new DialogInterface.OnCancelListener()
          {
            public final void onCancel(DialogInterface paramAnonymousDialogInterface)
            {
              AppMethodBeat.i(176184);
              com.tencent.mm.kernel.g.ajQ().gDv.a(EmojiStoreDetailUI.o(EmojiStoreDetailUI.this));
              EmojiStoreDetailUI.p(EmojiStoreDetailUI.this).setText(2131758331);
              EmojiStoreDetailUI.q(EmojiStoreDetailUI.this);
              AppMethodBeat.o(176184);
            }
          });
        }
        cjw();
        if (!this.pRk) {
          break label1051;
        }
        paramBundle = new com.tencent.mm.plugin.emoji.f.k(this.pMk);
        com.tencent.mm.kernel.g.ajQ().gDv.a(paramBundle, 0);
      }
    }
    for (;;)
    {
      cjz();
      com.tencent.mm.plugin.emoji.model.k.getEmojiStorageMgr().JfV.add(this);
      com.tencent.mm.sdk.b.a.IvT.c(this.pOb);
      com.tencent.mm.kernel.g.ajQ().gDv.a(822, this);
      i = getIntent().getIntExtra("extra_status", -1);
      int j = getIntent().getIntExtra("extra_progress", 0);
      i(this.pMk, i, j, this.pRa);
      this.pRn = true;
      com.tencent.mm.plugin.report.service.g.yxI.f(12740, new Object[] { Integer.valueOf(1), "", this.pMk, "", Integer.valueOf(this.pQZ), Integer.valueOf(26) });
      if ((this.pQo) && (this.pQz != null)) {
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
      if ((!bu.isNullOrNil(this.pOq)) && (this.pOq.equalsIgnoreCase(ad.iR(this.mContext))))
      {
        this.pQr = new com.tencent.mm.plugin.emoji.f.l(this.pMk, this.pNX, this.pOp.Version);
        break;
      }
      this.pQr = new com.tencent.mm.plugin.emoji.f.l(this.pMk, this.pNX);
      break;
      label1051:
      this.pRm = true;
      this.pRl = EmojiLogic.chX();
      continue;
      paramBundle = getContext();
      localObject = new EmotionDetail();
      ((EmotionDetail)localObject).ProductID = EmojiGroupInfo.OzR;
      ((EmotionDetail)localObject).PackName = paramBundle.getString(2131758385);
      ((EmotionDetail)localObject).PackDesc = paramBundle.getString(2131758383);
      ((EmotionDetail)localObject).PackAuthInfo = paramBundle.getString(2131758381);
      ((EmotionDetail)localObject).PackPrice = "";
      ((EmotionDetail)localObject).PackType = 0;
      ((EmotionDetail)localObject).PackFlag = 1;
      ((EmotionDetail)localObject).CoverUrl = "";
      ((EmotionDetail)localObject).PackExpire = 0;
      ((EmotionDetail)localObject).PackCopyright = paramBundle.getString(2131758382);
      ((EmotionDetail)localObject).PanelUrl = "";
      ((EmotionDetail)localObject).PriceNum = "";
      ((EmotionDetail)localObject).PriceType = "";
      ((EmotionDetail)localObject).TimeLimitStr = paramBundle.getString(2131758384);
      this.pOp = ((EmotionDetail)localObject);
      this.pRm = true;
      this.pRl = EmojiLogic.chX();
      cjy();
    }
  }
  
  public void onDestroy()
  {
    AppMethodBeat.i(109016);
    super.onDestroy();
    com.tencent.mm.plugin.emoji.model.k.getEmojiStorageMgr().JfV.remove(this);
    com.tencent.mm.sdk.b.a.IvT.d(this.pOb);
    com.tencent.mm.kernel.g.ajQ().gDv.b(822, this);
    if (this.pQG != null) {
      this.pQG.release();
    }
    this.mHandler.removeCallbacksAndMessages(null);
    AppMethodBeat.o(109016);
  }
  
  public void onPause()
  {
    AppMethodBeat.i(109014);
    super.onPause();
    com.tencent.mm.kernel.g.ajQ().gDv.b(412, this);
    com.tencent.mm.kernel.g.ajQ().gDv.b(521, this);
    com.tencent.mm.kernel.g.ajQ().gDv.b(423, this);
    com.tencent.mm.kernel.g.ajQ().gDv.b(413, this);
    AppMethodBeat.o(109014);
  }
  
  protected void onRestoreInstanceState(Bundle paramBundle)
  {
    AppMethodBeat.i(109018);
    this.pQq = paramBundle.getInt("status");
    this.Hx = paramBundle.getInt("progress");
    AppMethodBeat.o(109018);
  }
  
  public void onResume()
  {
    AppMethodBeat.i(109013);
    super.onResume();
    com.tencent.mm.kernel.g.ajQ().gDv.a(412, this);
    com.tencent.mm.kernel.g.ajQ().gDv.a(521, this);
    com.tencent.mm.kernel.g.ajQ().gDv.a(423, this);
    com.tencent.mm.kernel.g.ajQ().gDv.a(413, this);
    this.pRi = false;
    if (!this.pRn)
    {
      cjw();
      Cp(1007);
    }
    cjx();
    this.pRn = false;
    Cp(1001);
    AppMethodBeat.o(109013);
  }
  
  public void onSaveInstanceState(Bundle paramBundle)
  {
    AppMethodBeat.i(109017);
    paramBundle.putInt("status", this.pQq);
    paramBundle.putInt("progress", this.Hx);
    AppMethodBeat.o(109017);
  }
  
  public void onSceneEnd(int paramInt1, int paramInt2, String paramString, n paramn)
  {
    AppMethodBeat.i(109020);
    ae.i("MicroMsg.emoji.EmojiStoreDetailUI", "[onSceneEnd] errType:%d, errCode:%d, errMsg:%s", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), paramString });
    if ((this.jbE != null) && (this.jbE.isShowing())) {
      this.jbE.dismiss();
    }
    switch (paramn.getType())
    {
    }
    for (;;)
    {
      AppMethodBeat.o(109020);
      return;
      if ((paramn instanceof com.tencent.mm.plugin.emoji.f.l))
      {
        ae.i("MicroMsg.emoji.EmojiStoreDetailUI", "[onSceneEnd] MMFunc_GetEmotionDetail");
        paramString = (com.tencent.mm.plugin.emoji.f.l)paramn;
        if ((paramString != null) && (!bu.isNullOrNil(paramString.pMk)) && (paramString.pMk.equalsIgnoreCase(this.pMk)))
        {
          if (paramInt1 == 0)
          {
            if (paramInt2 == 0)
            {
              this.pOp = paramString.ciw();
              Cp(1002);
              AppMethodBeat.o(109020);
              return;
            }
            if (paramInt2 == 1)
            {
              cju();
              AppMethodBeat.o(109020);
              return;
            }
            this.pQx.setText(2131758330);
            cjv();
            AppMethodBeat.o(109020);
            return;
          }
          if (paramInt2 == 5)
          {
            if ((paramString != null) && (paramString.ciw() != null)) {
              this.pOp.PackFlag = paramString.ciw().PackFlag;
            }
            Cp(1002);
            AppMethodBeat.o(109020);
            return;
          }
          if (paramInt2 == 1)
          {
            cju();
            AppMethodBeat.o(109020);
            return;
          }
          this.pQz.setVisibility(8);
          this.GG.setVisibility(0);
          this.pQx.setText(2131758331);
          cjv();
          AppMethodBeat.o(109020);
          return;
        }
        ae.i("MicroMsg.emoji.EmojiStoreDetailUI", "no equal productid");
        AppMethodBeat.o(109020);
        return;
        if ((paramn instanceof com.tencent.mm.plugin.emoji.f.g))
        {
          ae.i("MicroMsg.emoji.EmojiStoreDetailUI", "[onSceneEnd] MMFunc_ExchangeEmotionPack");
          paramString = (com.tencent.mm.plugin.emoji.f.g)paramn;
          if ((paramString == this.pQs) && (!bu.isNullOrNil(paramString.pMk)) && (paramString.pMk.equalsIgnoreCase(this.pMk)))
          {
            if ((paramInt1 == 0) && (paramInt2 == 0))
            {
              this.pRa = paramString.idX;
              this.pQq = 6;
              cjE();
              AppMethodBeat.o(109020);
              return;
            }
            this.pQq = -1;
            cjE();
            paramString = this.pMl;
            h.a(this, String.format(getString(2131758320), new Object[] { paramString }), "", new DialogInterface.OnClickListener()new EmojiStoreDetailUI.10
            {
              public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
              {
                AppMethodBeat.i(176188);
                EmojiStoreDetailUI.a(EmojiStoreDetailUI.this, new com.tencent.mm.plugin.emoji.f.g(EmojiStoreDetailUI.a(EmojiStoreDetailUI.this), EmojiStoreDetailUI.y(EmojiStoreDetailUI.this), EmojiStoreDetailUI.z(EmojiStoreDetailUI.this)));
                EmojiStoreDetailUI.A(EmojiStoreDetailUI.this);
                EmojiStoreDetailUI.a(EmojiStoreDetailUI.this, 6);
                EmojiStoreDetailUI.g(EmojiStoreDetailUI.this);
                AppMethodBeat.o(176188);
              }
            }, new EmojiStoreDetailUI.10(this));
            AppMethodBeat.o(109020);
            return;
          }
          ae.i("MicroMsg.emoji.EmojiStoreDetailUI", "no equal productid");
          AppMethodBeat.o(109020);
          return;
          ae.i("MicroMsg.emoji.EmojiStoreDetailUI", "[onSceneEnd] MMFunc_GetEmotionDesc");
          paramString = (com.tencent.mm.plugin.emoji.f.k)paramn;
          if ((paramString != null) && (!bu.isNullOrNil(paramString.pLX)) && (paramString.pLX.equalsIgnoreCase(this.pMk))) {
            if ((paramInt1 == 0) && (paramInt2 == 0))
            {
              this.pRl = ((bbd)paramString.rr.hQE.hQJ);
              this.pRm = true;
              cjF();
            }
          }
          for (;;)
          {
            this.pRm = true;
            cjF();
            AppMethodBeat.o(109020);
            return;
            this.pRl = null;
            break;
            ae.i("MicroMsg.emoji.EmojiStoreDetailUI", "no equal productid");
          }
          if ((paramn instanceof com.tencent.mm.plugin.emoji.f.o))
          {
            ae.i("MicroMsg.emoji.EmojiStoreDetailUI", "[onSceneEnd] MMFunc_MMGetEmotionReward");
            if ((paramInt1 == 0) && (paramInt2 == 0))
            {
              this.pQv = ((com.tencent.mm.plugin.emoji.f.o)paramn).ciB();
              Cp(1007);
              AppMethodBeat.o(109020);
              return;
              if (this.pRp != null)
              {
                this.pRp.dismiss();
                this.pRp = null;
              }
              if ((paramInt1 == 0) && (paramInt2 == 0))
              {
                com.tencent.mm.plugin.emoji.model.k.getEmojiStorageMgr().JfV.aWe(((com.tencent.mm.plugin.emoji.f.q)paramn).pMk);
                this.pQq = 3;
                cjE();
                AppMethodBeat.o(109020);
                return;
              }
              h.e(getContext(), getContext().getString(2131758409), "", "", getContext().getString(2131760315), null, null);
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
      ae.d("MicroMsg.emoji.EmojiStoreDetailUI", "jacks get preview : %d", new Object[] { Integer.valueOf(paramInt) });
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
      localEmojiInfo.field_reserved4 |= EmojiInfo.OAp;
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
        paramView = LayoutInflater.from(EmojiStoreDetailUI.w(EmojiStoreDetailUI.this)).inflate(2131493796, null);
        paramViewGroup = new EmojiStoreDetailUI.c(EmojiStoreDetailUI.this, paramView);
        paramView.setTag(paramViewGroup);
        if (!EmojiStoreDetailUI.x(EmojiStoreDetailUI.this).LOI) {
          break label154;
        }
        paramViewGroup.pRz.setBackgroundResource(2131234073);
      }
      for (;;)
      {
        String str = "";
        if (EmojiStoreDetailUI.b(EmojiStoreDetailUI.this).PackThumbList != null) {
          str = com.tencent.mm.platformtools.z.a((cxn)EmojiStoreDetailUI.b(EmojiStoreDetailUI.this).PackThumbList.get(paramInt));
        }
        com.tencent.mm.av.q.aJb().a(str, paramViewGroup.pRz, com.tencent.mm.plugin.emoji.e.e.fy(EmojiStoreDetailUI.a(EmojiStoreDetailUI.this), str));
        AppMethodBeat.o(109002);
        return paramView;
        paramViewGroup = (EmojiStoreDetailUI.c)paramView.getTag();
        break;
        label154:
        paramViewGroup.pRz.setBackgroundDrawable(null);
      }
    }
  }
  
  final class b
    extends EmojiStoreDetailUI.a
  {
    private ArrayList<EmojiInfo> pRy;
    
    public b()
    {
      super();
      AppMethodBeat.i(109003);
      this.pRy = new ArrayList();
      this.pRy = ((ArrayList)com.tencent.mm.plugin.emoji.model.k.getEmojiStorageMgr().JfU.acl(com.tencent.mm.plugin.emoji.h.a.ckp()));
      AppMethodBeat.o(109003);
    }
    
    private EmojiInfo Cn(int paramInt)
    {
      AppMethodBeat.i(109005);
      if (this.pRy == null)
      {
        AppMethodBeat.o(109005);
        return null;
      }
      EmojiInfo localEmojiInfo = (EmojiInfo)this.pRy.get(paramInt);
      AppMethodBeat.o(109005);
      return localEmojiInfo;
    }
    
    public final int getCount()
    {
      AppMethodBeat.i(109004);
      if (this.pRy == null)
      {
        AppMethodBeat.o(109004);
        return 0;
      }
      int i = this.pRy.size();
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
        paramView = LayoutInflater.from(EmojiStoreDetailUI.w(EmojiStoreDetailUI.this)).inflate(2131493796, null);
        paramViewGroup = new EmojiStoreDetailUI.c(EmojiStoreDetailUI.this, paramView);
        paramView.setTag(paramViewGroup);
        paramViewGroup.pRz.setBackgroundResource(2131234073);
        localObject = Cn(paramInt);
        if (!bu.isNullOrNil(((EmojiInfo)localObject).getContent())) {
          break label129;
        }
      }
      label129:
      for (Object localObject = ((EmojiInfo)localObject).getName();; localObject = ((EmojiInfo)localObject).getContent())
      {
        localObject = localObject.split("\\.")[0];
        com.tencent.mm.av.q.aJb().a((String)localObject, paramViewGroup.pRz, com.tencent.mm.plugin.emoji.e.e.chJ());
        AppMethodBeat.o(109006);
        return paramView;
        paramViewGroup = (EmojiStoreDetailUI.c)paramView.getTag();
        break;
      }
    }
  }
  
  final class c
  {
    SquareImageView pRz;
    
    public c(View paramView)
    {
      AppMethodBeat.i(109008);
      this.pRz = ((SquareImageView)paramView.findViewById(2131299047));
      this.pRz.setScaleType(ImageView.ScaleType.FIT_CENTER);
      AppMethodBeat.o(109008);
    }
  }
  
  static final class d
    implements com.tencent.mm.av.a.c.k
  {
    WeakReference<EmojiStoreDetailUI> cyH;
    
    public final void a(String paramString, View paramView, Bitmap paramBitmap, Object... paramVarArgs)
    {
      AppMethodBeat.i(176195);
      ae.d("MicroMsg.emoji.EmojiStoreDetailUI", "[cpan] on image load complete url:%s", new Object[] { paramString });
      if (this.cyH == null)
      {
        AppMethodBeat.o(176195);
        return;
      }
      paramString = (EmojiStoreDetailUI)this.cyH.get();
      if (paramString == null)
      {
        AppMethodBeat.o(176195);
        return;
      }
      if (paramBitmap != null) {
        paramString.Cp(1006);
      }
      AppMethodBeat.o(176195);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.emoji.ui.EmojiStoreDetailUI
 * JD-Core Version:    0.7.0.1
 */